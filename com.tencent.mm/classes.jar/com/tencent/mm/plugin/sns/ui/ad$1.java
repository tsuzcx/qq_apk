package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

final class ad$1
  implements View.OnClickListener
{
  ad$1(ad paramad) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(97925);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if ((!bu.isNullOrNil(this.Ajg.Aje)) || (this.Ajg.AiI))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(97925);
      return;
    }
    localObject = z.aBG().F(this.Ajg.mSessionId, true);
    if (((z.b)localObject).containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      int i = ((z.b)localObject).getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      int j = ((z.b)localObject).getInt("_DATA_SHOW_NATIVE_PAGE", -1);
      if ((i == 5) && (j == 1) && (this.Ajg.fNT.getIntent().getBundleExtra("BizVideoDetailUIExtras") != null))
      {
        ae.i("MicroMsg.LinkWidget", "goto native video");
        localObject = new Intent();
        ((Intent)localObject).putExtras(this.Ajg.fNT.getIntent().getBundleExtra("BizVideoDetailUIExtras"));
        paramView = paramView.findViewById(2131300948);
        if (paramView != null)
        {
          i = paramView.getWidth();
          j = paramView.getHeight();
          int[] arrayOfInt = new int[2];
          paramView.getLocationInWindow(arrayOfInt);
          ((Intent)localObject).putExtra("img_gallery_width", i).putExtra("img_gallery_height", j).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
        }
        ((Intent)localObject).addFlags(268435456);
        d.b(ak.getContext(), "brandservice", ".ui.timeline.video.BizVideoDetailUI", (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97925);
        return;
      }
      if (x.fjk())
      {
        paramView = new Intent();
        j = (int)(System.currentTimeMillis() / 1000L);
        localObject = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d(this.Ajg.link, 2, 10000, j);
        if (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.Ajg.fNT, (String)localObject, i, 2, 10000, paramView))
        {
          paramView.putExtra("rawUrl", this.Ajg.link);
          d.b(this.Ajg.fNT, "webview", ".ui.tools.WebViewUI", paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97925);
        return;
      }
    }
    ae.i("MicroMsg.LinkWidget", "adlink url " + this.Ajg.link);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.Ajg.link);
    com.tencent.mm.plugin.sns.c.a.iUz.i(paramView, this.Ajg.fNT);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(97925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ad.1
 * JD-Core Version:    0.7.0.1
 */