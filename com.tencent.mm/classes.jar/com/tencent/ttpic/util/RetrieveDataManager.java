package com.tencent.ttpic.util;

public enum RetrieveDataManager
{
  INSTANCE;
  
  private final TexSaveProcess mRGBATexSaveProcess = new RGBATexSaveProcess();
  private final TexSaveProcess mYUVTexSaveProcess = new YUVTexSaveProcess();
  
  private RetrieveDataManager() {}
  
  private boolean checkBufSize(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if (paramInt1 == RetrieveDataManager.DATA_TYPE.RGBA.value) {
      if (paramArrayOfByte.length != paramInt2 * paramInt3 * 4) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt1 != RetrieveDataManager.DATA_TYPE.YUV.value) {
        break;
      }
    } while (paramArrayOfByte.length == paramInt2 * paramInt3 * 3 / 2);
    return false;
    return false;
  }
  
  private TexSaveProcess createTexSaveProcess(int paramInt)
  {
    if (paramInt == RetrieveDataManager.DATA_TYPE.RGBA.value) {
      return this.mRGBATexSaveProcess;
    }
    if (paramInt == RetrieveDataManager.DATA_TYPE.YUV.value) {
      return this.mYUVTexSaveProcess;
    }
    return null;
  }
  
  public static RetrieveDataManager getInstance()
  {
    return INSTANCE;
  }
  
  public final void clear()
  {
    this.mRGBATexSaveProcess.clear();
    this.mYUVTexSaveProcess.clear();
  }
  
  public final boolean isValid(int paramInt)
  {
    boolean bool2 = false;
    RetrieveDataManager.DATA_TYPE[] arrayOfDATA_TYPE = RetrieveDataManager.DATA_TYPE.values();
    int j = arrayOfDATA_TYPE.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfDATA_TYPE[i].value == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final boolean retrieveData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    if (!checkBufSize(paramInt1, paramInt3, paramInt4, paramArrayOfByte)) {}
    TexSaveProcess localTexSaveProcess;
    do
    {
      return false;
      localTexSaveProcess = createTexSaveProcess(paramInt1);
    } while (localTexSaveProcess == null);
    return localTexSaveProcess.retrieveData(paramInt2, paramInt3, paramInt4, paramArrayOfByte);
  }
  
  public final byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TexSaveProcess localTexSaveProcess = createTexSaveProcess(paramInt1);
    if (localTexSaveProcess != null) {
      return localTexSaveProcess.retrieveData(paramInt2, paramInt3, paramInt4);
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.RetrieveDataManager
 * JD-Core Version:    0.7.0.1
 */