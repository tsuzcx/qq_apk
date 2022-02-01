package com.tencent.mm.plugin.textstatus.g.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.proto.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/upload/PostTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;)V", "lastPostTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusPost", "Companion", "plugin-textstatus_release"})
public final class a
  implements i
{
  public static final a.a MEo;
  private final al MDa;
  private long MEn;
  
  static
  {
    AppMethodBeat.i(232546);
    MEo = new a.a((byte)0);
    AppMethodBeat.o(232546);
  }
  
  public a(al paramal)
  {
    AppMethodBeat.i(232545);
    this.MDa = paramal;
    AppMethodBeat.o(232545);
  }
  
  public final void gmi()
  {
    AppMethodBeat.i(232542);
    d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(232542);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(232543);
    Log.i("MicroMsg.TextStatus.PostTask", "[doPost] end cost:" + (System.currentTimeMillis() - this.MEn) + ",errType" + paramInt1 + ",errCode" + paramInt2);
    h.aGY().b(5293, (i)this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramq = c.MEt;
      paramq = this.MDa;
      p.k(paramq, "postInfo");
      Log.i("MicroMsg.TextStatus.UploadManager", "makeCgiFail " + paramq.MFT + ' ' + paramString + ' ' + paramq.MFR + "  " + paramq.MFS);
      if (Util.isNullOrNil(paramString))
      {
        paramq.MFS += 1;
        c.a(paramq);
        paramString = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.c(paramq.MFV, Long.valueOf(2L));
        c.eCf();
        AppMethodBeat.o(232543);
        return;
      }
      paramq.errMsg = paramString;
      c.a(paramq);
      paramString = f.MAm;
      f.c(Long.valueOf(paramq.MFT), 6);
      paramString = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.c(paramq.MFV, Long.valueOf(5L));
    }
    AppMethodBeat.o(232543);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.g.a
 * JD-Core Version:    0.7.0.1
 */