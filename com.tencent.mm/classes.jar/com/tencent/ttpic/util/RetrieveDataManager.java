package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class RetrieveDataManager
{
  private static final ThreadLocal<RetrieveDataManager> INSTANCE;
  private final TexSaveProcess mRGBATexSaveProcess;
  private final TexSaveProcess mYUVTexSaveProcess;
  
  static
  {
    AppMethodBeat.i(83974);
    INSTANCE = new RetrieveDataManager.1();
    AppMethodBeat.o(83974);
  }
  
  public RetrieveDataManager()
  {
    AppMethodBeat.i(83969);
    this.mRGBATexSaveProcess = new RGBATexSaveProcess();
    this.mYUVTexSaveProcess = new YUVTexSaveProcess();
    AppMethodBeat.o(83969);
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
    AppMethodBeat.i(83970);
    RetrieveDataManager localRetrieveDataManager = (RetrieveDataManager)INSTANCE.get();
    AppMethodBeat.o(83970);
    return localRetrieveDataManager;
  }
  
  public void clear()
  {
    AppMethodBeat.i(83973);
    this.mRGBATexSaveProcess.clear();
    this.mYUVTexSaveProcess.clear();
    AppMethodBeat.o(83973);
  }
  
  public boolean isValid(int paramInt)
  {
    AppMethodBeat.i(83972);
    RetrieveDataManager.DATA_TYPE[] arrayOfDATA_TYPE = RetrieveDataManager.DATA_TYPE.values();
    int j = arrayOfDATA_TYPE.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfDATA_TYPE[i].value == paramInt)
      {
        AppMethodBeat.o(83972);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(83972);
    return false;
  }
  
  public byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(83971);
    Object localObject = createTexSaveProcess(paramInt1);
    if (localObject != null)
    {
      localObject = ((TexSaveProcess)localObject).retrieveData(paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(83971);
      return localObject;
    }
    AppMethodBeat.o(83971);
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.RetrieveDataManager
 * JD-Core Version:    0.7.0.1
 */