package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

final class ad$1
  implements View.OnClickListener
{
  ad$1(ad paramad) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(97925);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    if ((!bt.isNullOrNil(this.zRZ.zRX)) || (this.zRZ.zRB))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(97925);
      return;
    }
    localObject = y.aBq().F(this.zRZ.mSessionId, true);
    if (((y.b)localObject).containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      int i = ((y.b)localObject).getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      int j = ((y.b)localObject).getInt("_DATA_SHOW_NATIVE_PAGE", -1);
      if ((i == 5) && (j == 1))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LinkWidget", "goto native video");
        localObject = new Intent();
        ((Intent)localObject).putExtras(this.zRZ.fLP.getIntent().getBundleExtra("BizVideoDetailUIExtras"));
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
        d.b(aj.getContext(), "brandservice", ".ui.timeline.video.BizVideoDetailUI", (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97925);
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LinkWidget", "adlink url " + this.zRZ.link);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.zRZ.link);
    com.tencent.mm.plugin.sns.c.a.iRG.i(paramView, this.zRZ.fLP);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(97925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ad.1
 * JD-Core Version:    0.7.0.1
 */