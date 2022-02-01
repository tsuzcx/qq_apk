package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class y$1
  implements View.OnClickListener
{
  y$1(y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(97881);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (y.a(this.RdA) == null)
    {
      a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(97881);
      return;
    }
    if (y.a(this.RdA).getLikeFlag() == 0) {
      if (y.a(this.RdA).isExtFlag())
      {
        ar.a.a(y.a(this.RdA), 1, "", "", y.b(this.RdA));
        y.a(this.RdA).setLikeFlag(1);
        al.hgB().V(y.a(this.RdA));
        j.QFS.hip().jeW = 2L;
        label148:
        if (y.a(this.RdA).field_snsId != 0L) {
          break label347;
        }
      }
    }
    label347:
    for (paramView = "";; paramView = t.uA(y.a(this.RdA).field_snsId))
    {
      h.OAn.b(11989, new Object[] { Integer.valueOf(1), paramView, Integer.valueOf(0) });
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(97880);
          y.1.this.RdA.bDL();
          AppMethodBeat.o(97880);
        }
      }, 500L);
      a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(97881);
      return;
      ar.a.a(y.a(this.RdA).field_userName, 5, "", y.a(this.RdA), y.b(this.RdA));
      break;
      y.a(this.RdA).setLikeFlag(0);
      al.hgB().V(y.a(this.RdA));
      ar.a.aYC(y.a(this.RdA).getSnsId());
      y.a(this.RdA, al.hgB().vj(y.a(this.RdA).field_snsId));
      j.QFS.hip().jeW = 4L;
      break label148;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.y.1
 * JD-Core Version:    0.7.0.1
 */