package com.tencent.tmassistantsdk.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;

public class TMAssistantFile
{
  protected static final int DataBufferMaxLen = 16384;
  protected static final String TAG = "TMAssistantFile";
  protected int mDataBufferDataLen;
  protected long mFileDataLen;
  protected FileOutputStream mFileOutputStream;
  protected String mFinalFileName;
  protected String mTempFileName;
  protected byte[] mWriteDataBuffer;
  
  public TMAssistantFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76168);
    this.mTempFileName = null;
    this.mFinalFileName = null;
    this.mFileOutputStream = null;
    this.mWriteDataBuffer = null;
    this.mFileDataLen = 0L;
    this.mDataBufferDataLen = 0;
    this.mTempFileName = paramString1;
    this.mFinalFileName = paramString2;
    this.mFileDataLen = length();
    TMLog.i("TMAssistantFile", "mFileDataLen = " + this.mFileDataLen);
    AppMethodBeat.o(76168);
  }
  
  public static String getSaveFilePath(String paramString)
  {
    AppMethodBeat.i(76175);
    if (paramString == null)
    {
      AppMethodBeat.o(76175);
      return null;
    }
    String str = getSavePathRootDir();
    if (str == null)
    {
      AppMethodBeat.o(76175);
      return null;
    }
    paramString = str + File.separator + paramString;
    AppMethodBeat.o(76175);
    return paramString;
  }
  
  public static String getSavePathRootDir()
  {
    AppMethodBeat.i(76177);
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(76177);
      return null;
    }
    if (isSDCardExistAndCanWrite()) {
      localObject = "/tencent/TMAssistantSDK/Download/".concat(String.valueOf(((Context)localObject).getPackageName()));
    }
    for (localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + (String)localObject;; localObject = ((Context)localObject).getFilesDir().getAbsolutePath() + "/TMAssistantSDK/Download")
    {
      AppMethodBeat.o(76177);
      return localObject;
    }
  }
  
  public static boolean isSDCardExistAndCanWrite()
  {
    AppMethodBeat.i(76179);
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
    {
      AppMethodBeat.o(76179);
      return true;
    }
    AppMethodBeat.o(76179);
    return false;
  }
  
  private boolean moveFileFromTmpToSavaPath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76181);
    TMLog.i("TMAssistantFile", "moveFileFromTmpToSavaPath, tmpFilePath = " + paramString1 + ", saveFilePath = " + paramString2);
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = new File(paramString1);
      if (paramString1.exists() == true)
      {
        boolean bool = paramString1.renameTo(new File(paramString2));
        if (bool) {
          GlobalUtil.updateFilePathAuthorized(paramString2);
        }
        AppMethodBeat.o(76181);
        return bool;
      }
    }
    TMLog.w("TMAssistantFile", "moveFileFromTmpToSavaPath failed ");
    AppMethodBeat.o(76181);
    return false;
  }
  
  private boolean writeData(FileOutputStream paramFileOutputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(76180);
    if ((paramFileOutputStream == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(76180);
      return false;
    }
    if (paramLong != this.mFileDataLen)
    {
      TMLog.i("TMAssistantFile", "writeData0 failed,filelen:" + this.mFileDataLen + ",offset:" + paramLong + ",filename:" + this.mTempFileName);
      AppMethodBeat.o(76180);
      return false;
    }
    if (paramInt2 >= 16384) {}
    for (;;)
    {
      try
      {
        if (this.mDataBufferDataLen > 0)
        {
          paramFileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
          this.mDataBufferDataLen = 0;
        }
        paramFileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
        this.mFileDataLen += paramInt2;
        AppMethodBeat.o(76180);
        return true;
      }
      catch (IOException paramFileOutputStream)
      {
        ab.printErrStackTrace("TMAssistantFile", paramFileOutputStream, "", new Object[0]);
        TMLog.w("TMAssistantFile", "writeData1 failed " + paramFileOutputStream.getMessage());
        AppMethodBeat.o(76180);
        return false;
      }
      if ((this.mDataBufferDataLen + paramInt2 > 16384) && (this.mDataBufferDataLen > 0)) {}
      try
      {
        paramFileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
        this.mDataBufferDataLen = 0;
        System.arraycopy(paramArrayOfByte, paramInt1, this.mWriteDataBuffer, this.mDataBufferDataLen, paramInt2);
        this.mDataBufferDataLen += paramInt2;
        this.mFileDataLen += paramInt2;
      }
      catch (IOException paramFileOutputStream)
      {
        ab.printErrStackTrace("TMAssistantFile", paramFileOutputStream, "", new Object[0]);
        TMLog.w("TMAssistantFile", "writeData2 failed " + paramFileOutputStream.getMessage());
        AppMethodBeat.o(76180);
      }
    }
    return false;
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 207
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 210	com/tencent/tmassistantsdk/storage/TMAssistantFile:flush	()Z
    //   11: pop
    //   12: aload_0
    //   13: getfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/FileOutputStream;
    //   16: ifnull +10 -> 26
    //   19: aload_0
    //   20: getfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/FileOutputStream;
    //   23: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/FileOutputStream;
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 40	com/tencent/tmassistantsdk/storage/TMAssistantFile:mWriteDataBuffer	[B
    //   36: aload_0
    //   37: lconst_0
    //   38: putfield 42	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileDataLen	J
    //   41: ldc 207
    //   43: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: ldc 11
    //   52: aload_1
    //   53: ldc 186
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: goto -36 -> 26
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	TMAssistantFile
    //   49	4	1	localIOException	IOException
    //   65	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	26	49	java/io/IOException
    //   2	12	65	finally
    //   12	26	65	finally
    //   26	46	65	finally
    //   50	62	65	finally
  }
  
  public void deleteTempFile()
  {
    AppMethodBeat.i(76169);
    String str = getTmpFilePath(this.mTempFileName);
    TMLog.i("TMAssistantFile", "deleteFile 1 tmpFilePathString: ".concat(String.valueOf(str)));
    if (!TextUtils.isEmpty(str))
    {
      File localFile = new File(str);
      TMLog.i("TMAssistantFile", "deleteFile 2 file: ".concat(String.valueOf(localFile)));
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        TMLog.i("TMAssistantFile", "deleteFile result:" + bool + ",filename:" + str);
        AppMethodBeat.o(76169);
        return;
      }
      TMLog.i("TMAssistantFile", "deleteFile 3");
    }
    AppMethodBeat.o(76169);
  }
  
  void ensureFilePath(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(76171);
    if (TextUtils.isEmpty(paramString))
    {
      TMLog.i("TMAssistantFile", "fileFullPath is null or the filename.size is zero.");
      paramString = new InvalidParameterException("fileFullPath is null or the filename.size is zero.");
      AppMethodBeat.o(76171);
      throw paramString;
    }
    int i = paramString.lastIndexOf("/");
    if ((i == -1) || (paramString.length() == 1))
    {
      TMLog.i("TMAssistantFile", "fileFullPath is not a valid full path. fileName: ".concat(String.valueOf(paramString)));
      paramString = new InvalidParameterException("fileFullPath is not a valid full path. fileName: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(76171);
      throw paramString;
    }
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    paramString = new File(str);
    if (!paramString.exists()) {
      bool = paramString.mkdirs();
    }
    if (!bool)
    {
      TMLog.i("TMAssistantFile", "Failed to create directory. dir: ".concat(String.valueOf(str)));
      paramString = new IOException("Failed to create directory. dir: ".concat(String.valueOf(str)));
      AppMethodBeat.o(76171);
      throw paramString;
    }
    AppMethodBeat.o(76171);
  }
  
  /* Error */
  public boolean flush()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 266
    //   7: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/FileOutputStream;
    //   14: ifnull +73 -> 87
    //   17: aload_0
    //   18: getfield 44	com/tencent/tmassistantsdk/storage/TMAssistantFile:mDataBufferDataLen	I
    //   21: istore_1
    //   22: iload_1
    //   23: ifle +64 -> 87
    //   26: aload_0
    //   27: getfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/FileOutputStream;
    //   30: aload_0
    //   31: getfield 40	com/tencent/tmassistantsdk/storage/TMAssistantFile:mWriteDataBuffer	[B
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 44	com/tencent/tmassistantsdk/storage/TMAssistantFile:mDataBufferDataLen	I
    //   39: invokevirtual 184	java/io/FileOutputStream:write	([BII)V
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 44	com/tencent/tmassistantsdk/storage/TMAssistantFile:mDataBufferDataLen	I
    //   47: iconst_1
    //   48: istore_2
    //   49: ldc_w 266
    //   52: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_0
    //   56: monitorexit
    //   57: iload_2
    //   58: ireturn
    //   59: astore_3
    //   60: ldc 11
    //   62: aload_3
    //   63: ldc 186
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc 11
    //   74: ldc_w 268
    //   77: aload_3
    //   78: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   81: invokevirtual 117	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 167	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: ldc_w 266
    //   90: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: goto -38 -> 55
    //   96: astore_3
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_3
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	TMAssistantFile
    //   21	2	1	i	int
    //   1	57	2	bool	boolean
    //   59	19	3	localIOException	IOException
    //   96	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	47	59	java/io/IOException
    //   4	22	96	finally
    //   26	47	96	finally
    //   49	55	96	finally
    //   60	87	96	finally
    //   87	93	96	finally
  }
  
  public String getTmpFilePath(String paramString)
  {
    AppMethodBeat.i(76176);
    if (paramString == null)
    {
      AppMethodBeat.o(76176);
      return null;
    }
    String str = getSavePathRootDir();
    if (str == null)
    {
      AppMethodBeat.o(76176);
      return null;
    }
    paramString = str + "/.tmp/" + paramString + ".tmp";
    AppMethodBeat.o(76176);
    return paramString;
  }
  
  public long length()
  {
    AppMethodBeat.i(76170);
    Object localObject = getSaveFilePath(this.mFinalFileName);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      File localFile;
      if (!((File)localObject).exists())
      {
        localObject = getTmpFilePath(this.mTempFileName);
        if (localObject != null)
        {
          localFile = new File((String)localObject);
          if (localFile.exists()) {
            break label83;
          }
          this.mFileDataLen = 0L;
        }
      }
      for (;;)
      {
        long l = this.mFileDataLen;
        AppMethodBeat.o(76170);
        return l;
        label83:
        TMLog.i("TMAssistantFile", (String)localObject + " exists");
        this.mFileDataLen = localFile.length();
        continue;
        this.mFileDataLen = ((File)localObject).length();
      }
    }
    AppMethodBeat.o(76170);
    return 0L;
  }
  
  public void moveFileToSavaPath()
  {
    AppMethodBeat.i(76178);
    moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
    AppMethodBeat.o(76178);
  }
  
  public boolean write(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(76172);
        String str;
        if (this.mFileOutputStream == null)
        {
          str = getTmpFilePath(this.mTempFileName);
          if (str == null) {}
        }
        else
        {
          try
          {
            ensureFilePath(str);
            this.mFileOutputStream = new FileOutputStream(str, true);
            if (this.mWriteDataBuffer == null)
            {
              this.mWriteDataBuffer = new byte[16384];
              this.mDataBufferDataLen = 0;
            }
            bool = writeData(this.mFileOutputStream, paramArrayOfByte, paramInt1, paramInt2, paramLong);
            if (bool) {
              break label186;
            }
            AppMethodBeat.o(76172);
            paramBoolean = bool;
          }
          catch (Exception paramArrayOfByte)
          {
            ab.printErrStackTrace("TMAssistantFile", paramArrayOfByte, "", new Object[0]);
            TMLog.w("TMAssistantFile", "write failed" + paramArrayOfByte.getMessage());
            AppMethodBeat.o(76172);
            paramBoolean = bool;
            continue;
          }
          return paramBoolean;
        }
      }
      finally {}
      TMLog.w("TMAssistantFile", "write failed tmpFilePathString is null");
      AppMethodBeat.o(76172);
      paramBoolean = bool;
      continue;
      label186:
      if ((paramBoolean == true) && (flush() == true))
      {
        paramBoolean = moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
        AppMethodBeat.o(76172);
      }
      else
      {
        AppMethodBeat.o(76172);
        paramBoolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.TMAssistantFile
 * JD-Core Version:    0.7.0.1
 */