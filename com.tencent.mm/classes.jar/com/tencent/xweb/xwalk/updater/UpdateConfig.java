package com.tencent.xweb.xwalk.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkFileUtil;

public class UpdateConfig
{
  public String ZaV;
  public boolean aiiL;
  public boolean aijL;
  public boolean ailq;
  public c aiqI;
  public boolean aiqJ;
  public String aiqK;
  public String aiqL;
  public String aiqM;
  public int aiqN;
  public String aiqO;
  public int aiqy;
  
  public UpdateConfig(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(212998);
    this.aiqN = -1;
    this.aiqJ = false;
    this.ailq = paramBoolean;
    this.aiqM = paramString1;
    this.aiqN = paramInt1;
    this.ZaV = paramString2;
    this.aiqy = paramInt2;
    if (!checkValid())
    {
      paramString1 = new RuntimeException("invalid update config");
      AppMethodBeat.o(212998);
      throw paramString1;
    }
    AppMethodBeat.o(212998);
  }
  
  public UpdateConfig(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(213004);
    this.aiqN = -1;
    this.aiqJ = true;
    this.aiqK = paramString1;
    this.ailq = paramBoolean;
    this.aiqL = paramString2;
    this.aiqM = paramString3;
    this.aiqN = paramInt1;
    this.ZaV = paramString4;
    this.aiqy = paramInt2;
    if (!checkValid())
    {
      paramString1 = new RuntimeException("invalid update config");
      AppMethodBeat.o(213004);
      throw paramString1;
    }
    AppMethodBeat.o(213004);
  }
  
  public boolean checkValid()
  {
    AppMethodBeat.i(213011);
    if ((this.aiqJ) && ((this.aiqK == null) || (this.aiqK.isEmpty())))
    {
      AppMethodBeat.o(213011);
      return false;
    }
    if ((this.aiqM == null) || (this.aiqM.isEmpty()))
    {
      AppMethodBeat.o(213011);
      return false;
    }
    if (this.aiqN == -1)
    {
      AppMethodBeat.o(213011);
      return false;
    }
    if ((this.aiqJ) && (this.ailq) && ((this.aiqL == null) || (this.aiqL.isEmpty())))
    {
      AppMethodBeat.o(213011);
      return false;
    }
    AppMethodBeat.o(213011);
    return true;
  }
  
  public final String gEb()
  {
    AppMethodBeat.i(213009);
    if (checkValid())
    {
      if (this.ailq)
      {
        localObject = XWalkFileUtil.getDownloadPatchPath(this.aiqN);
        AppMethodBeat.o(213009);
        return localObject;
      }
      localObject = XWalkFileUtil.getDownloadZipPath(this.aiqN);
      AppMethodBeat.o(213009);
      return localObject;
    }
    Object localObject = new RuntimeException("invalid update config");
    AppMethodBeat.o(213009);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.UpdateConfig
 * JD-Core Version:    0.7.0.1
 */