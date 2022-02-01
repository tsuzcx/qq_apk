package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizMsgResortTest;", "", "()V", "TAG", "", "resortTestOpen", "", "getResortTestOpen", "()I", "setResortTestOpen", "(I)V", "checkReqData", "", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "beginTime", "", "checkReqLimit", "reqLimit", "itemSize", "checkRespData", "isResortTestOpen", "", "onCheckFail", "errMsg", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final w acEV;
  private static int acEW;
  
  static
  {
    AppMethodBeat.i(248762);
    acEV = new w();
    acEW = -1;
    AppMethodBeat.o(248762);
  }
  
  public static void ayy(int paramInt)
  {
    acEW = paramInt;
  }
  
  static void bvz(String paramString)
  {
    AppMethodBeat.i(248759);
    Log.e("MicroMsg.BizMsgResortTest", s.X("onCheckFail ", paramString));
    if ((BuildInfo.DEBUG) || (Log.getLogLevel() <= 1))
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
      long l = System.currentTimeMillis();
      if (Math.abs(l - localMultiProcessMMKV.decodeLong("lastResortCrashTime", -1L)) > 86400000L)
      {
        localMultiProcessMMKV.encode("lastResortCrashTime", l);
        Assert.assertTrue(s.X("onCheckFail ", paramString), false);
      }
    }
    AppMethodBeat.o(248759);
  }
  
  static boolean iXX()
  {
    AppMethodBeat.i(248753);
    if (acEW != -1)
    {
      if (acEW == 1)
      {
        AppMethodBeat.o(248753);
        return true;
      }
      AppMethodBeat.o(248753);
      return false;
    }
    if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) && (Log.getLogLevel() < 2))
    {
      AppMethodBeat.o(248753);
      return true;
    }
    AppMethodBeat.o(248753);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.w
 * JD-Core Version:    0.7.0.1
 */