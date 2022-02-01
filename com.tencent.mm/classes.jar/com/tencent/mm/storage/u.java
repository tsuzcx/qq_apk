package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import d.l;
import junit.framework.Assert;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/storage/BizMsgResortTest;", "", "()V", "TAG", "", "resortTestOpen", "", "getResortTestOpen", "()I", "setResortTestOpen", "(I)V", "checkReqData", "", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "beginTime", "", "checkReqLimit", "reqLimit", "itemSize", "checkRespData", "isResortTestOpen", "", "onCheckFail", "errMsg", "plugin-biz_release"})
public final class u
{
  private static int Iol;
  public static final u Iom;
  
  static
  {
    AppMethodBeat.i(207365);
    Iom = new u();
    Iol = -1;
    AppMethodBeat.o(207365);
  }
  
  static void aSC(String paramString)
  {
    AppMethodBeat.i(207364);
    ad.e("MicroMsg.BizMsgResortTest", "onCheckFail ".concat(String.valueOf(paramString)));
    if ((i.DEBUG) || (ad.getLogLevel() <= 1))
    {
      ax localax = ax.aQA("brandService");
      long l = System.currentTimeMillis();
      if (Math.abs(l - localax.decodeLong("lastResortCrashTime", -1L)) > 86400000L)
      {
        localax.encode("lastResortCrashTime", l);
        Assert.assertTrue("onCheckFail ".concat(String.valueOf(paramString)), false);
      }
    }
    AppMethodBeat.o(207364);
  }
  
  public static void aaF(int paramInt)
  {
    Iol = paramInt;
  }
  
  static boolean fpa()
  {
    AppMethodBeat.i(207363);
    if (Iol != -1)
    {
      if (Iol == 1)
      {
        AppMethodBeat.o(207363);
        return true;
      }
      AppMethodBeat.o(207363);
      return false;
    }
    if (((i.DEBUG) || (i.IS_FLAVOR_RED) || (bu.flY())) && (ad.getLogLevel() < 2))
    {
      AppMethodBeat.o(207363);
      return true;
    }
    AppMethodBeat.o(207363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.u
 * JD-Core Version:    0.7.0.1
 */