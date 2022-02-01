package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import d.l;
import junit.framework.Assert;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/storage/BizMsgResortTest;", "", "()V", "TAG", "", "resortTestOpen", "", "getResortTestOpen", "()I", "setResortTestOpen", "(I)V", "checkReqData", "", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "beginTime", "", "checkReqLimit", "reqLimit", "itemSize", "checkRespData", "isResortTestOpen", "", "onCheckFail", "errMsg", "plugin-biz_release"})
public final class s
{
  private static int GBX;
  public static final s GBY;
  
  static
  {
    AppMethodBeat.i(209601);
    GBY = new s();
    GBX = -1;
    AppMethodBeat.o(209601);
  }
  
  public static void Yy(int paramInt)
  {
    GBX = paramInt;
  }
  
  static void aMQ(String paramString)
  {
    AppMethodBeat.i(209600);
    ac.e("MicroMsg.BizMsgResortTest", "onCheckFail ".concat(String.valueOf(paramString)));
    if ((h.DEBUG) || (ac.getLogLevel() <= 1))
    {
      aw localaw = aw.aKU("brandService");
      long l = System.currentTimeMillis();
      if (Math.abs(l - localaw.decodeLong("lastResortCrashTime", -1L)) > 86400000L)
      {
        localaw.encode("lastResortCrashTime", l);
        Assert.assertTrue("onCheckFail ".concat(String.valueOf(paramString)), false);
      }
    }
    AppMethodBeat.o(209600);
  }
  
  static boolean eZg()
  {
    AppMethodBeat.i(209599);
    if (GBX != -1)
    {
      if (GBX == 1)
      {
        AppMethodBeat.o(209599);
        return true;
      }
      AppMethodBeat.o(209599);
      return false;
    }
    if (((h.DEBUG) || (h.IS_FLAVOR_RED) || (bt.eWo())) && (ac.getLogLevel() < 2))
    {
      AppMethodBeat.o(209599);
      return true;
    }
    AppMethodBeat.o(209599);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.s
 * JD-Core Version:    0.7.0.1
 */