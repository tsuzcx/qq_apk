package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import junit.framework.Assert;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizMsgResortTest;", "", "()V", "TAG", "", "resortTestOpen", "", "getResortTestOpen", "()I", "setResortTestOpen", "(I)V", "checkReqData", "", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "beginTime", "", "checkReqLimit", "reqLimit", "itemSize", "checkRespData", "isResortTestOpen", "", "onCheckFail", "errMsg", "plugin-biz_release"})
public final class w
{
  private static int NPJ;
  public static final w NPK;
  
  static
  {
    AppMethodBeat.i(212571);
    NPK = new w();
    NPJ = -1;
    AppMethodBeat.o(212571);
  }
  
  public static void ajS(int paramInt)
  {
    NPJ = paramInt;
  }
  
  static void biV(String paramString)
  {
    AppMethodBeat.i(212570);
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
    AppMethodBeat.o(212570);
  }
  
  static boolean gAk()
  {
    AppMethodBeat.i(212569);
    if (NPJ != -1)
    {
      if (NPJ == 1)
      {
        AppMethodBeat.o(212569);
        return true;
      }
      AppMethodBeat.o(212569);
      return false;
    }
    if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) && (Log.getLogLevel() < 2))
    {
      AppMethodBeat.o(212569);
      return true;
    }
    AppMethodBeat.o(212569);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.w
 * JD-Core Version:    0.7.0.1
 */