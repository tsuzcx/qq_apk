package com.tencent.tmassistantsdk.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidParameterException;

public class TMAssistantFile
{
  protected static final int DataBufferMaxLen = 16384;
  protected static final String TAG = "TMAssistantFile";
  protected int mDataBufferDataLen;
  protected long mFileDataLen;
  protected OutputStream mFileOutputStream;
  protected String mFinalFileName;
  protected String mTempFileName;
  protected byte[] mWriteDataBuffer;
  
  public TMAssistantFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102414);
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
    AppMethodBeat.o(102414);
  }
  
  public static String getSaveFilePath(String paramString)
  {
    AppMethodBeat.i(102421);
    if (paramString == null)
    {
      AppMethodBeat.o(102421);
      return null;
    }
    String str = getSavePathRootDir();
    if (str == null)
    {
      AppMethodBeat.o(102421);
      return null;
    }
    paramString = str + "/" + paramString;
    AppMethodBeat.o(102421);
    return paramString;
  }
  
  public static String getSavePathRootDir()
  {
    AppMethodBeat.i(102423);
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(102423);
      return null;
    }
    if (isSDCardExistAndCanWrite()) {
      localObject = "/tencent/TMAssistantSDK/Download/".concat(String.valueOf(((Context)localObject).getPackageName()));
    }
    for (localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + (String)localObject;; localObject = ((Context)localObject).getExternalCacheDir() + "/TMAssistantSDK/Download")
    {
      AppMethodBeat.o(102423);
      return localObject;
    }
  }
  
  public static boolean isSDCardExistAndCanWrite()
  {
    AppMethodBeat.i(102425);
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
    {
      AppMethodBeat.o(102425);
      return true;
    }
    AppMethodBeat.o(102425);
    return false;
  }
  
  private boolean moveFileFromTmpToSavaPath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102427);
    TMLog.i("TMAssistantFile", "moveFileFromTmpToSavaPath, tmpFilePath = " + paramString1 + ", saveFilePath = " + paramString2);
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = new e(paramString1);
      if (paramString1.exists() == true)
      {
        boolean bool = paramString1.ag(new e(paramString2));
        if (bool) {
          GlobalUtil.updateFilePathAuthorized(paramString2);
        }
        AppMethodBeat.o(102427);
        return bool;
      }
    }
    TMLog.w("TMAssistantFile", "moveFileFromTmpToSavaPath failed ");
    AppMethodBeat.o(102427);
    return false;
  }
  
  private boolean writeData(OutputStream paramOutputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(177060);
    if ((paramOutputStream == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(177060);
      return false;
    }
    if (paramLong != this.mFileDataLen)
    {
      TMLog.i("TMAssistantFile", "writeData0 failed,filelen:" + this.mFileDataLen + ",offset:" + paramLong + ",filename:" + this.mTempFileName);
      AppMethodBeat.o(177060);
      return false;
    }
    if (paramInt2 >= 16384) {}
    for (;;)
    {
      try
      {
        if (this.mDataBufferDataLen > 0)
        {
          paramOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
          this.mDataBufferDataLen = 0;
        }
        paramOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
        this.mFileDataLen += paramInt2;
        AppMethodBeat.o(177060);
        return true;
      }
      catch (IOException paramOutputStream)
      {
        ad.printErrStackTrace("TMAssistantFile", paramOutputStream, "", new Object[0]);
        TMLog.w("TMAssistantFile", "writeData1 failed " + paramOutputStream.getMessage());
        AppMethodBeat.o(177060);
        return false;
      }
      if ((this.mDataBufferDataLen + paramInt2 > 16384) && (this.mDataBufferDataLen > 0)) {}
      try
      {
        paramOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
        this.mDataBufferDataLen = 0;
        System.arraycopy(paramArrayOfByte, paramInt1, this.mWriteDataBuffer, this.mDataBufferDataLen, paramInt2);
        this.mDataBufferDataLen += paramInt2;
        this.mFileDataLen += paramInt2;
      }
      catch (IOException paramOutputStream)
      {
        ad.printErrStackTrace("TMAssistantFile", paramOutputStream, "", new Object[0]);
        TMLog.w("TMAssistantFile", "writeData2 failed " + paramOutputStream.getMessage());
        AppMethodBeat.o(177060);
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
    //   2: ldc 211
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 214	com/tencent/tmassistantsdk/storage/TMAssistantFile:flush	()Z
    //   11: pop
    //   12: aload_0
    //   13: getfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/OutputStream;
    //   16: ifnull +10 -> 26
    //   19: aload_0
    //   20: getfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/OutputStream;
    //   23: invokevirtual 216	java/io/OutputStream:close	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/OutputStream;
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 40	com/tencent/tmassistantsdk/storage/TMAssistantFile:mWriteDataBuffer	[B
    //   36: aload_0
    //   37: lconst_0
    //   38: putfield 42	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileDataLen	J
    //   41: ldc 211
    //   43: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: ldc 11
    //   52: aload_1
    //   53: ldc 190
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 196	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    AppMethodBeat.i(102415);
    String str = getTmpFilePath(this.mTempFileName);
    TMLog.i("TMAssistantFile", "deleteFile 1 tmpFilePathString: ".concat(String.valueOf(str)));
    if (!TextUtils.isEmpty(str))
    {
      e locale = new e(str);
      TMLog.i("TMAssistantFile", "deleteFile 2 file: ".concat(String.valueOf(locale)));
      if (locale.exists())
      {
        boolean bool = locale.delete();
        TMLog.i("TMAssistantFile", "deleteFile result:" + bool + ",filename:" + str);
        AppMethodBeat.o(102415);
        return;
      }
      TMLog.i("TMAssistantFile", "deleteFile 3");
    }
    AppMethodBeat.o(102415);
  }
  
  void ensureFilePath(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(102417);
    if (TextUtils.isEmpty(paramString))
    {
      TMLog.i("TMAssistantFile", "fileFullPath is null or the filename.size is zero.");
      paramString = new InvalidParameterException("fileFullPath is null or the filename.size is zero.");
      AppMethodBeat.o(102417);
      throw paramString;
    }
    int i = paramString.lastIndexOf("/");
    if ((i == -1) || (paramString.length() == 1))
    {
      TMLog.i("TMAssistantFile", "fileFullPath is not a valid full path. fileName: ".concat(String.valueOf(paramString)));
      paramString = new InvalidParameterException("fileFullPath is not a valid full path. fileName: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(102417);
      throw paramString;
    }
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    paramString = new e(str);
    if (!paramString.exists()) {
      bool = paramString.mkdirs();
    }
    if (!bool)
    {
      TMLog.i("TMAssistantFile", "Failed to create directory. dir: ".concat(String.valueOf(str)));
      paramString = new IOException("Failed to create directory. dir: ".concat(String.valueOf(str)));
      AppMethodBeat.o(102417);
      throw paramString;
    }
    AppMethodBeat.o(102417);
  }
  
  /* Error */
  public boolean flush()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 268
    //   7: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/OutputStream;
    //   14: ifnull +73 -> 87
    //   17: aload_0
    //   18: getfield 44	com/tencent/tmassistantsdk/storage/TMAssistantFile:mDataBufferDataLen	I
    //   21: istore_1
    //   22: iload_1
    //   23: ifle +64 -> 87
    //   26: aload_0
    //   27: getfield 38	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/OutputStream;
    //   30: aload_0
    //   31: getfield 40	com/tencent/tmassistantsdk/storage/TMAssistantFile:mWriteDataBuffer	[B
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 44	com/tencent/tmassistantsdk/storage/TMAssistantFile:mDataBufferDataLen	I
    //   39: invokevirtual 188	java/io/OutputStream:write	([BII)V
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 44	com/tencent/tmassistantsdk/storage/TMAssistantFile:mDataBufferDataLen	I
    //   47: iconst_1
    //   48: istore_2
    //   49: ldc_w 268
    //   52: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_0
    //   56: monitorexit
    //   57: iload_2
    //   58: ireturn
    //   59: astore_3
    //   60: ldc 11
    //   62: aload_3
    //   63: ldc 190
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 196	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc 11
    //   74: ldc_w 270
    //   77: aload_3
    //   78: invokestatic 111	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   81: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 171	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: ldc_w 268
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
    AppMethodBeat.i(102422);
    if (paramString == null)
    {
      AppMethodBeat.o(102422);
      return null;
    }
    String str = getSavePathRootDir();
    if (str == null)
    {
      AppMethodBeat.o(102422);
      return null;
    }
    paramString = str + "/.tmp/" + paramString + ".tmp";
    AppMethodBeat.o(102422);
    return paramString;
  }
  
  public long length()
  {
    AppMethodBeat.i(102416);
    Object localObject = getSaveFilePath(this.mFinalFileName);
    if (localObject != null)
    {
      localObject = new e((String)localObject);
      e locale;
      if (!((e)localObject).exists())
      {
        localObject = getTmpFilePath(this.mTempFileName);
        if (localObject != null)
        {
          locale = new e((String)localObject);
          if (locale.exists()) {
            break label83;
          }
          this.mFileDataLen = 0L;
        }
      }
      for (;;)
      {
        long l = this.mFileDataLen;
        AppMethodBeat.o(102416);
        return l;
        label83:
        TMLog.i("TMAssistantFile", (String)localObject + " exists");
        this.mFileDataLen = locale.length();
        continue;
        this.mFileDataLen = ((e)localObject).length();
      }
    }
    AppMethodBeat.o(102416);
    return 0L;
  }
  
  public void moveFileToSavaPath()
  {
    AppMethodBeat.i(102424);
    moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
    AppMethodBeat.o(102424);
  }
  
  public boolean write(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(102418);
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
            this.mFileOutputStream = i.cX(str, true);
            if (this.mWriteDataBuffer == null)
            {
              this.mWriteDataBuffer = new byte[16384];
              this.mDataBufferDataLen = 0;
            }
            bool = writeData(this.mFileOutputStream, paramArrayOfByte, paramInt1, paramInt2, paramLong);
            if (bool) {
              break label182;
            }
            AppMethodBeat.o(102418);
            paramBoolean = bool;
          }
          catch (Exception paramArrayOfByte)
          {
            ad.printErrStackTrace("TMAssistantFile", paramArrayOfByte, "", new Object[0]);
            TMLog.w("TMAssistantFile", "write failed" + paramArrayOfByte.getMessage());
            AppMethodBeat.o(102418);
            paramBoolean = bool;
            continue;
          }
          return paramBoolean;
        }
      }
      finally {}
      TMLog.w("TMAssistantFile", "write failed tmpFilePathString is null");
      AppMethodBeat.o(102418);
      paramBoolean = bool;
      continue;
      label182:
      if ((paramBoolean == true) && (flush() == true))
      {
        paramBoolean = moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
        AppMethodBeat.o(102418);
      }
      else
      {
        AppMethodBeat.o(102418);
        paramBoolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.TMAssistantFile
 * JD-Core Version:    0.7.0.1
 */