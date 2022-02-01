package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONArray;
import org.json.JSONObject;

final class GestureGalleryUI$12
  implements View.OnClickListener
{
  GestureGalleryUI$12(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(232087);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    try
    {
      localObject = GestureGalleryUI.P(this.FLO).optJSONObject(GestureGalleryUI.Q(this.FLO));
      if (((JSONObject)localObject).optInt("jumpType", 0) == 9)
      {
        paramView = new JSONObject();
        paramView.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
        paramView.put("extInfo", ((JSONObject)localObject).optJSONObject("extInfo"));
        paramView.put("extraInfo", ((JSONObject)localObject).optString("extraInfo", ""));
        ((aj)g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramView.toString(), null);
      }
      for (;;)
      {
        label136:
        a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232087);
        return;
        if (((JSONObject)localObject).optInt("jumpType", 0) == 2)
        {
          paramView = ((JSONObject)localObject).optString("userName");
          localObject = ((JSONObject)localObject).optString("weappUrl");
          wq localwq = new wq();
          localwq.ecI.userName = paramView;
          localwq.ecI.ecK = ((String)localObject);
          EventCenter.instance.publish(localwq);
        }
        else if (((JSONObject)localObject).optInt("jumpType", 0) == 3)
        {
          paramView = ((JSONObject)localObject).optString("jumpUrl");
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView);
          c.b(this.FLO, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
        }
      }
    }
    catch (Exception paramView)
    {
      break label136;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.12
 * JD-Core Version:    0.7.0.1
 */