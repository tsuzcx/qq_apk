package com.tencent.mm.plugin.websearch.a.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.ecs;
import com.tencent.mm.protocal.protobuf.eql;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
final class c$f
  implements r.a
{
  c$f(c paramc, k.b paramb, ecs paramecs, ccn paramccn, String paramString) {}
  
  public final void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(198711);
    paramString1 = BitmapUtil.Bitmap2Bytes(paramBitmap);
    w.a.bbx().a(this.PAC, this.PAD.jUi, "", this.PAz.PAx.talker, "", paramString1);
    this.PAz.a(this.PAA, this.PAn);
    AppMethodBeat.o(198711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.c.f
 * JD-Core Version:    0.7.0.1
 */