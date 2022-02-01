package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.q;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderListener$1$1"})
final class b$e$c
  implements Runnable
{
  b$e$c(b.e parame, String paramString, c paramc, float[] paramArrayOfFloat, b.e.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(39665);
    a locala = q.bml();
    String str = this.sPR;
    ImageView localImageView1 = this.Hft.frg();
    c localc = this.Hfu;
    ImageView localImageView2 = this.Hft.frg();
    p.j(localImageView2, "imageIv");
    int i = localImageView2.getMeasuredWidth();
    localImageView2 = this.Hft.frg();
    p.j(localImageView2, "imageIv");
    locala.a(str, localImageView1, localc, (h)new m(3, i, localImageView2.getMeasuredHeight(), this.Hfv, (m.a)this.Hfw));
    AppMethodBeat.o(39665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.b.e.c
 * JD-Core Version:    0.7.0.1
 */