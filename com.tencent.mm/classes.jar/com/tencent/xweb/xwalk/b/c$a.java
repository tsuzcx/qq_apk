package com.tencent.xweb.xwalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public final class c$a
{
  public String BKJ;
  public String BKK;
  public String BKO;
  public boolean BKP;
  public int BKV;
  public long BLa;
  public boolean BLb;
  public String BLc;
  public long BLd;
  public String BLe;
  public int BLf;
  public int BLg;
  public boolean bTryUseSharedCore;
  public boolean bUseCdn;
  public String bWN;
  
  static
  {
    AppMethodBeat.i(85455);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(85455);
      return;
    }
  }
  
  public final XWalkUpdater.UpdateConfig eaE()
  {
    AppMethodBeat.i(85454);
    try
    {
      if (this.BLb) {
        break label142;
      }
      if ((this.BKJ != null) && (!this.BKJ.isEmpty())) {
        break label117;
      }
      if (!$assertionsDisabled)
      {
        AssertionError localAssertionError = new AssertionError("royle:no md5 info, maybe something wrong");
        AppMethodBeat.o(85454);
        throw localAssertionError;
      }
    }
    catch (Exception localException)
    {
      XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
      c.a(null);
      AppMethodBeat.o(85454);
      return null;
    }
    Object localObject = new XWalkUpdater.UpdateConfig(this.BKO, false, this.BKV);
    for (;;)
    {
      ((XWalkUpdater.UpdateConfig)localObject).versionDetail = this.BLe;
      ((XWalkUpdater.UpdateConfig)localObject).bUseCdn = this.bUseCdn;
      ((XWalkUpdater.UpdateConfig)localObject).bTryUseSharedCore = this.bTryUseSharedCore;
      AppMethodBeat.o(85454);
      return localObject;
      label117:
      localObject = new XWalkUpdater.UpdateConfig(this.BKJ, false, null, this.BKO, this.BKV);
      continue;
      label142:
      if ((this.BKJ == null) || (this.BKJ.isEmpty()) || (this.bWN == null) || (this.bWN.isEmpty()))
      {
        if (!$assertionsDisabled)
        {
          localObject = new AssertionError("royle:no md5 info, maybe something wrong");
          AppMethodBeat.o(85454);
          throw ((Throwable)localObject);
        }
        localObject = new XWalkUpdater.UpdateConfig(this.BKO, true, this.BKV);
      }
      else
      {
        localObject = new XWalkUpdater.UpdateConfig(this.bWN, true, this.BKJ, this.BKO, this.BKV);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.c.a
 * JD-Core Version:    0.7.0.1
 */