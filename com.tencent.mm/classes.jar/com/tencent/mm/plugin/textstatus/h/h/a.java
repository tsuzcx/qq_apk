package com.tencent.mm.plugin.textstatus.h.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.i.b;
import com.tencent.mm.plugin.textstatus.proto.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/upload/PostTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;)V", "lastPostTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusPost", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.am.h
{
  public static final a.a TnW;
  private final bg TmA;
  private long TnX;
  
  static
  {
    AppMethodBeat.i(290641);
    TnW = new a.a((byte)0);
    AppMethodBeat.o(290641);
  }
  
  public a(bg parambg)
  {
    AppMethodBeat.i(290630);
    this.TmA = parambg;
    AppMethodBeat.o(290630);
  }
  
  public final void hHS()
  {
    AppMethodBeat.i(290647);
    d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(290647);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(290659);
    Log.i("MicroMsg.TextStatus.PostTask", "[doPost] end cost:" + (System.currentTimeMillis() - this.TnX) + ",errType" + paramInt1 + ",errCode" + paramInt2);
    com.tencent.mm.kernel.h.aZW().b(5293, (com.tencent.mm.am.h)this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramp = c.Tob;
      paramp = this.TmA;
      kotlin.g.b.s.u(paramp, "postInfo");
      Log.i("MicroMsg.TextStatus.UploadManager", "makeCgiFail " + paramp.Tqo + ' ' + paramString + ' ' + paramp.Tqm + "  " + paramp.Tqn);
      if (Util.isNullOrNil(paramString))
      {
        paramp.Tqn += 1;
        c.a(paramp);
        paramString = b.Trt;
        b.d(paramp.Tqq, Long.valueOf(2L));
        c.retry();
        AppMethodBeat.o(290659);
        return;
      }
      paramp.errMsg = paramString;
      c.a(paramp);
      paramString = f.TjQ;
      f.d(Long.valueOf(paramp.Tqo), 6);
      paramString = b.Trt;
      b.d(paramp.Tqq, Long.valueOf(5L));
    }
    AppMethodBeat.o(290659);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.h.a
 * JD-Core Version:    0.7.0.1
 */