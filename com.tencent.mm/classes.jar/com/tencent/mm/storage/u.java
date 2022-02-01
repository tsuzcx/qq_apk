package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import d.l;
import junit.framework.Assert;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/storage/BizMsgResortTest;", "", "()V", "TAG", "", "resortTestOpen", "", "getResortTestOpen", "()I", "setResortTestOpen", "(I)V", "checkReqData", "", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "beginTime", "", "checkReqLimit", "reqLimit", "itemSize", "checkRespData", "isResortTestOpen", "", "onCheckFail", "errMsg", "plugin-biz_release"})
public final class u
{
  private static int IIB;
  public static final u IIC;
  
  static
  {
    AppMethodBeat.i(188837);
    IIC = new u();
    IIB = -1;
    AppMethodBeat.o(188837);
  }
  
  static void aTZ(String paramString)
  {
    AppMethodBeat.i(188836);
    ae.e("MicroMsg.BizMsgResortTest", "onCheckFail ".concat(String.valueOf(paramString)));
    if ((j.DEBUG) || (ae.getLogLevel() <= 1))
    {
      ay localay = ay.aRX("brandService");
      long l = System.currentTimeMillis();
      if (Math.abs(l - localay.decodeLong("lastResortCrashTime", -1L)) > 86400000L)
      {
        localay.encode("lastResortCrashTime", l);
        Assert.assertTrue("onCheckFail ".concat(String.valueOf(paramString)), false);
      }
    }
    AppMethodBeat.o(188836);
  }
  
  public static void abm(int paramInt)
  {
    IIB = paramInt;
  }
  
  static boolean fsX()
  {
    AppMethodBeat.i(188835);
    if (IIB != -1)
    {
      if (IIB == 1)
      {
        AppMethodBeat.o(188835);
        return true;
      }
      AppMethodBeat.o(188835);
      return false;
    }
    if (((j.DEBUG) || (j.IS_FLAVOR_RED) || (bv.fpT())) && (ae.getLogLevel() < 2))
    {
      AppMethodBeat.o(188835);
      return true;
    }
    AppMethodBeat.o(188835);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.u
 * JD-Core Version:    0.7.0.1
 */