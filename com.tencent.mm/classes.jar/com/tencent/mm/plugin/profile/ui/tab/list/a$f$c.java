package com.tencent.mm.plugin.profile.ui.tab.list;

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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel$imageUrl$imageLoaderListener$1$1"})
final class a$f$c
  implements Runnable
{
  a$f$c(a.f paramf, String paramString, c paramc, float[] paramArrayOfFloat, a.f.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(286852);
    a locala = q.bml();
    String str = this.sPR;
    ImageView localImageView1 = this.Hhz.frg();
    c localc = this.Hfu;
    ImageView localImageView2 = this.Hhz.frg();
    p.j(localImageView2, "imageIv");
    int i = localImageView2.getMeasuredWidth();
    localImageView2 = this.Hhz.frg();
    p.j(localImageView2, "imageIv");
    locala.a(str, localImageView1, localc, (h)new m(3, i, localImageView2.getMeasuredHeight(), this.Hfv, (m.a)this.HhA));
    AppMethodBeat.o(286852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.a.f.c
 * JD-Core Version:    0.7.0.1
 */