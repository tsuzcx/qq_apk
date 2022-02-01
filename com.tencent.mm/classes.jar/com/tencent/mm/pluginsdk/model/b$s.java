package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.core.g;
import com.tencent.mm.plugin.webview.core.g.a;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.LinkedList;
import kotlin.Result;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "callback"})
final class b$s
  implements IPCRunCgi.a
{
  b$s(aa.a parama, kotlin.d.d paramd) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
  {
    paramString = null;
    AppMethodBeat.i(292871);
    p.k(paramd, "rr");
    Log.i("MicroMsg.BizFinderLiveLogic", "getBizFinderLives callback " + paramInt1 + ", " + paramInt2);
    if (this.lrI.aaBx)
    {
      AppMethodBeat.o(292871);
      return;
    }
    this.lrI.aaBx = true;
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      try
      {
        paramString = b.QTJ;
        b.TM(2L);
        paramString = this.lrJ;
        paramd = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(null));
        AppMethodBeat.o(292871);
        return;
      }
      catch (Exception paramString)
      {
        paramd = b.QTJ;
        b.TM(3L);
        Log.e("MicroMsg.BizFinderLiveLogic", "callback ex " + paramString.getMessage());
        AppMethodBeat.o(292871);
        return;
      }
    }
    Object localObject = b.QTJ;
    b.TM(1L);
    if (!(paramd.bhY() instanceof oe))
    {
      paramString = this.lrJ;
      paramd = Result.Companion;
      paramString.resumeWith(Result.constructor-impl(null));
      AppMethodBeat.o(292871);
      return;
    }
    paramd = paramd.bhY();
    if (paramd == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizFinderLiveResp");
      AppMethodBeat.o(292871);
      throw paramString;
    }
    paramd = (oe)paramd;
    localObject = g.PHD;
    if (g.a.No())
    {
      localObject = MultiProcessMMKV.getSingleMMKV("brandService");
      if ((localObject != null) && (((MultiProcessMMKV)localObject).decodeInt("BizTimeLineFinderLiveStatus", 1) == 0)) {
        paramd.RVu.clear();
      }
    }
    localObject = new StringBuilder("getBizFinderLives card size=");
    LinkedList localLinkedList = paramd.RVu;
    if (localLinkedList != null) {
      paramString = Integer.valueOf(localLinkedList.size());
    }
    Log.i("MicroMsg.BizFinderLiveLogic", paramString + " interval=" + paramd.RVv);
    if ((paramd.RVs != null) && (paramd.RVs.UH.length > 0))
    {
      paramString = b.QTJ;
      b.bcJ().encode("FinderLiveBuffer", paramd.RVs.toByteArray());
    }
    paramString = this.lrJ;
    localObject = Result.Companion;
    paramString.resumeWith(Result.constructor-impl(paramd));
    AppMethodBeat.o(292871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.b.s
 * JD-Core Version:    0.7.0.1
 */