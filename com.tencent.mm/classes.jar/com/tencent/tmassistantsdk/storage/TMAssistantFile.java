package com.tencent.tmassistantsdk.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
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
  protected int mDataBufferDataLen = 0;
  protected long mFileDataLen = 0L;
  protected FileOutputStream mFileOutputStream = null;
  protected String mFinalFileName = null;
  protected String mTempFileName = null;
  protected byte[] mWriteDataBuffer = null;
  
  public TMAssistantFile(String paramString1, String paramString2)
  {
    this.mTempFileName = paramString1;
    this.mFinalFileName = paramString2;
    this.mFileDataLen = length();
    TMLog.i("TMAssistantFile", "mFileDataLen = " + this.mFileDataLen);
  }
  
  public static String getSaveFilePath(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = getSavePathRootDir();
    } while (str == null);
    return str + File.separator + paramString;
  }
  
  public static String getSavePathRootDir()
  {
    Object localObject = GlobalUtil.getInstance().getContext();
    if (localObject == null) {
      return null;
    }
    if (isSDCardExistAndCanWrite())
    {
      localObject = ((Context)localObject).getPackageName();
      localObject = "/tencent/TMAssistantSDK/Download/" + (String)localObject;
      return Environment.getExternalStorageDirectory().getAbsolutePath() + (String)localObject;
    }
    return ((Context)localObject).getFilesDir().getAbsolutePath() + "/TMAssistantSDK/Download";
  }
  
  public static boolean isSDCardExistAndCanWrite()
  {
    return ("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite());
  }
  
  private boolean moveFileFromTmpToSavaPath(String paramString1, String paramString2)
  {
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
        return bool;
      }
    }
    TMLog.w("TMAssistantFile", "moveFileFromTmpToSavaPath failed ");
    return false;
  }
  
  private boolean writeData(FileOutputStream paramFileOutputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramFileOutputStream == null) || (paramArrayOfByte == null)) {
      return false;
    }
    if (paramLong != this.mFileDataLen)
    {
      TMLog.i("TMAssistantFile", "writeData0 failed,filelen:" + this.mFileDataLen + ",offset:" + paramLong + ",filename:" + this.mTempFileName);
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
        return true;
      }
      catch (IOException paramFileOutputStream)
      {
        y.printErrStackTrace("TMAssistantFile", paramFileOutputStream, "", new Object[0]);
        TMLog.w("TMAssistantFile", "writeData1 failed " + paramFileOutputStream.getMessage());
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
        y.printErrStackTrace("TMAssistantFile", paramFileOutputStream, "", new Object[0]);
        TMLog.w("TMAssistantFile", "writeData2 failed " + paramFileOutputStream.getMessage());
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
    //   2: aload_0
    //   3: invokevirtual 188	com/tencent/tmassistantsdk/storage/TMAssistantFile:flush	()Z
    //   6: pop
    //   7: aload_0
    //   8: getfield 31	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/FileOutputStream;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 31	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/FileOutputStream;
    //   18: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 31	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileOutputStream	Ljava/io/FileOutputStream;
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 33	com/tencent/tmassistantsdk/storage/TMAssistantFile:mWriteDataBuffer	[B
    //   31: aload_0
    //   32: lconst_0
    //   33: putfield 35	com/tencent/tmassistantsdk/storage/TMAssistantFile:mFileDataLen	J
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: ldc 11
    //   42: aload_1
    //   43: ldc 165
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: goto -31 -> 21
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	TMAssistantFile
    //   39	4	1	localIOException	IOException
    //   55	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	39	java/io/IOException
    //   2	7	55	finally
    //   7	21	55	finally
    //   21	36	55	finally
    //   40	52	55	finally
  }
  
  public void deleteTempFile()
  {
    String str = getTmpFilePath(this.mTempFileName);
    TMLog.i("TMAssistantFile", "deleteFile 1 tmpFilePathString: " + str);
    if (!TextUtils.isEmpty(str))
    {
      File localFile = new File(str);
      TMLog.i("TMAssistantFile", "deleteFile 2 file: " + localFile);
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        TMLog.i("TMAssistantFile", "deleteFile result:" + bool + ",filename:" + str);
      }
    }
    else
    {
      return;
    }
    TMLog.i("TMAssistantFile", "deleteFile 3");
  }
  
  void ensureFilePath(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      TMLog.i("TMAssistantFile", "fileFullPath is null or the filename.size is zero.");
      throw new InvalidParameterException("fileFullPath is null or the filename.size is zero.");
    }
    int i = paramString.lastIndexOf("/");
    if ((i == -1) || (paramString.length() == 1))
    {
      TMLog.i("TMAssistantFile", "fileFullPath is not a valid full path. fileName: " + paramString);
      throw new InvalidParameterException("fileFullPath is not a valid full path. fileName: " + paramString);
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
      TMLog.i("TMAssistantFile", "Failed to create directory. dir: " + str);
      throw new IOException("Failed to create directory. dir: " + str);
    }
  }
  
  public boolean flush()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.mFileOutputStream != null)
      {
        int i = this.mDataBufferDataLen;
        bool1 = bool2;
        if (i <= 0) {}
      }
      try
      {
        this.mFileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
        this.mDataBufferDataLen = 0;
        bool1 = true;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.printErrStackTrace("TMAssistantFile", localIOException, "", new Object[0]);
          TMLog.w("TMAssistantFile", "flush failed " + localIOException);
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public String getTmpFilePath(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      str = getSavePathRootDir();
    } while (str == null);
    return str + "/.tmp/" + paramString + ".tmp";
  }
  
  public long length()
  {
    long l = 0L;
    Object localObject = getSaveFilePath(this.mFinalFileName);
    File localFile;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        break label109;
      }
      localObject = getTmpFilePath(this.mTempFileName);
      if (localObject != null)
      {
        localFile = new File((String)localObject);
        if (localFile.exists()) {
          break label73;
        }
        this.mFileDataLen = 0L;
      }
    }
    for (;;)
    {
      l = this.mFileDataLen;
      return l;
      label73:
      TMLog.i("TMAssistantFile", (String)localObject + " exists");
      this.mFileDataLen = localFile.length();
      continue;
      label109:
      this.mFileDataLen = ((File)localObject).length();
    }
  }
  
  public void moveFileToSavaPath()
  {
    moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
  }
  
  public boolean write(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
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
              break label162;
            }
            paramBoolean = bool;
          }
          catch (Exception paramArrayOfByte)
          {
            y.printErrStackTrace("TMAssistantFile", paramArrayOfByte, "", new Object[0]);
            TMLog.w("TMAssistantFile", "write failed" + paramArrayOfByte.getMessage());
            paramBoolean = bool;
            continue;
          }
          return paramBoolean;
        }
      }
      finally {}
      TMLog.w("TMAssistantFile", "write failed tmpFilePathString is null");
      paramBoolean = bool;
      continue;
      label162:
      if ((paramBoolean == true) && (flush() == true)) {
        paramBoolean = moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
      } else {
        paramBoolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.TMAssistantFile
 * JD-Core Version:    0.7.0.1
 */