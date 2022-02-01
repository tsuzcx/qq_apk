package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

final class ag$1
  implements View.OnClickListener
{
  ag$1(ag paramag) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(97925);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if ((!Util.isNullOrNil(this.KFk.KFd)) || (this.KFk.KEF) || (this.KFk.KEG))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(97925);
      return;
    }
    localObject = ad.beh().I(this.KFk.mSessionId, true);
    if (((ad.b)localObject).containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      int i = ((ad.b)localObject).getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      int j = ((ad.b)localObject).getInt("_DATA_SHOW_NATIVE_PAGE", -1);
      if ((i == 5) && (j == 1) && (this.KFk.iXq.getIntent().getBundleExtra("BizVideoDetailUIExtras") != null))
      {
        Log.i("MicroMsg.LinkWidget", "goto native video");
        localObject = new Intent();
        ((Intent)localObject).putExtras(this.KFk.iXq.getIntent().getBundleExtra("BizVideoDetailUIExtras"));
        paramView = paramView.findViewById(i.f.image_left);
        if (paramView != null)
        {
          i = paramView.getWidth();
          j = paramView.getHeight();
          int[] arrayOfInt = new int[2];
          paramView.getLocationInWindow(arrayOfInt);
          ((Intent)localObject).putExtra("img_gallery_width", i).putExtra("img_gallery_height", j).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
        }
        ((Intent)localObject).addFlags(268435456);
        com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "brandservice", ".ui.timeline.video.BizVideoDetailUI", (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(97925);
        return;
      }
      ab.hnS();
      paramView = new Intent();
      j = (int)(System.currentTimeMillis() / 1000L);
      localObject = ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).e(this.KFk.link, 2, 10000, j);
      if (!((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(this.KFk.iXq, (String)localObject, i, 2, 10000, paramView))
      {
        paramView.putExtra("rawUrl", this.KFk.link);
        com.tencent.mm.by.c.b(this.KFk.iXq, "webview", ".ui.tools.WebViewUI", paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(97925);
      return;
    }
    Log.i("MicroMsg.LinkWidget", "adlink url " + this.KFk.link);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.KFk.link);
    com.tencent.mm.plugin.sns.c.a.mIG.h(paramView, this.KFk.iXq);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(97925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.1
 * JD-Core Version:    0.7.0.1
 */