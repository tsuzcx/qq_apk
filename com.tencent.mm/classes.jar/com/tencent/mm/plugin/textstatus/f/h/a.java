package com.tencent.mm.plugin.textstatus.f.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/upload/PostTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;)V", "lastPostTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusPost", "Companion", "plugin-textstatus_release"})
public final class a
  implements i
{
  public static final a.a FZS;
  private final v FYQ;
  private long FZR;
  
  static
  {
    AppMethodBeat.i(216303);
    FZS = new a.a((byte)0);
    AppMethodBeat.o(216303);
  }
  
  public a(v paramv)
  {
    AppMethodBeat.i(216302);
    this.FYQ = paramv;
    AppMethodBeat.o(216302);
  }
  
  public final void fwb()
  {
    AppMethodBeat.i(216300);
    d.h((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(216300);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216301);
    Log.i("MicroMsg.TxtStatus.PostTask", "[doPost] end cost:" + (System.currentTimeMillis() - this.FZR) + ",errType" + paramInt1 + ",errCode" + paramInt2);
    g.azz().b(5293, (i)this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramq = c.FZX;
      paramq = this.FYQ;
      p.h(paramq, "postInfo");
      Log.i("MicroMsg.TxtStatus.UploadManager", "makeCgiFail " + paramq.Gba + ' ' + paramString + ' ' + paramq.GaY + "  " + paramq.GaZ);
      if (Util.isNullOrNil(paramString))
      {
        paramq.GaZ += 1;
        c.a(paramq);
        paramString = com.tencent.mm.plugin.textstatus.k.a.UsD;
        com.tencent.mm.plugin.textstatus.k.a.c(paramq.Usb, Long.valueOf(2L));
        c.dYH();
        AppMethodBeat.o(216301);
        return;
      }
      paramq.errMsg = paramString;
      c.a(paramq);
      paramString = f.FXJ;
      f.c(Long.valueOf(paramq.Gba), 6);
      paramString = com.tencent.mm.plugin.textstatus.k.a.UsD;
      com.tencent.mm.plugin.textstatus.k.a.c(paramq.Usb, Long.valueOf(5L));
    }
    AppMethodBeat.o(216301);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.h.a
 * JD-Core Version:    0.7.0.1
 */