package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONArray;
import org.json.JSONObject;

final class GestureGalleryUI$14
  implements View.OnClickListener
{
  GestureGalleryUI$14(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179710);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    for (;;)
    {
      try
      {
        localObject = GestureGalleryUI.K(this.SHm).optJSONObject(GestureGalleryUI.L(this.SHm));
        if (((JSONObject)localObject).optInt("jumpType", 0) != 9) {
          continue;
        }
        paramView = new JSONObject();
        paramView.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
        paramView.put("extInfo", ((JSONObject)localObject).optJSONObject("extInfo"));
        paramView.put("extraInfo", ((JSONObject)localObject).optString("extraInfo", ""));
        ((cn)h.az(cn.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramView.toString(), null);
        GestureGalleryUI.f(this.SHm, 5);
      }
      catch (Exception paramView)
      {
        zp localzp;
        continue;
      }
      a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(179710);
      return;
      if (((JSONObject)localObject).optInt("jumpType", 0) == 2)
      {
        paramView = ((JSONObject)localObject).optString("userName");
        localObject = ((JSONObject)localObject).optString("weappUrl");
        localzp = new zp();
        localzp.icM.userName = paramView;
        localzp.icM.icO = ((String)localObject);
        localzp.publish();
      }
      else if (((JSONObject)localObject).optInt("jumpType", 0) == 3)
      {
        paramView = ((JSONObject)localObject).optString("jumpUrl");
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramView);
        c.b(this.SHm, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.14
 * JD-Core Version:    0.7.0.1
 */