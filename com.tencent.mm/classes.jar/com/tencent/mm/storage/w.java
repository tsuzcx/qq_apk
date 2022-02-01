package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import junit.framework.Assert;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizMsgResortTest;", "", "()V", "TAG", "", "resortTestOpen", "", "getResortTestOpen", "()I", "setResortTestOpen", "(I)V", "checkReqData", "", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "beginTime", "", "checkReqLimit", "reqLimit", "itemSize", "checkRespData", "isResortTestOpen", "", "onCheckFail", "errMsg", "plugin-biz_release"})
public final class w
{
  private static int VdB;
  public static final w VdC;
  
  static
  {
    AppMethodBeat.i(205221);
    VdC = new w();
    VdB = -1;
    AppMethodBeat.o(205221);
  }
  
  public static void asn(int paramInt)
  {
    VdB = paramInt;
  }
  
  static void bvr(String paramString)
  {
    AppMethodBeat.i(205219);
    Log.e("MicroMsg.BizMsgResortTest", "onCheckFail ".concat(String.valueOf(paramString)));
    if ((BuildInfo.DEBUG) || (Log.getLogLevel() <= 1))
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
      long l = System.currentTimeMillis();
      if (Math.abs(l - localMultiProcessMMKV.decodeLong("lastResortCrashTime", -1L)) > 86400000L)
      {
        localMultiProcessMMKV.encode("lastResortCrashTime", l);
        Assert.assertTrue("onCheckFail ".concat(String.valueOf(paramString)), false);
      }
    }
    AppMethodBeat.o(205219);
  }
  
  static boolean hwr()
  {
    AppMethodBeat.i(205218);
    if (VdB != -1)
    {
      if (VdB == 1)
      {
        AppMethodBeat.o(205218);
        return true;
      }
      AppMethodBeat.o(205218);
      return false;
    }
    if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) && (Log.getLogLevel() < 2))
    {
      AppMethodBeat.o(205218);
      return true;
    }
    AppMethodBeat.o(205218);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.w
 * JD-Core Version:    0.7.0.1
 */