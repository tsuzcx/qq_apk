package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONArray;
import org.json.JSONObject;

final class GestureGalleryUI$13
  implements View.OnClickListener
{
  GestureGalleryUI$13(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179708);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    for (;;)
    {
      try
      {
        localObject = GestureGalleryUI.L(this.MfO).optJSONObject(GestureGalleryUI.M(this.MfO));
        if (((JSONObject)localObject).optInt("jumpType", 0) != 9) {
          continue;
        }
        paramView = new JSONObject();
        paramView.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
        paramView.put("extInfo", ((JSONObject)localObject).optJSONObject("extInfo"));
        paramView.put("extraInfo", ((JSONObject)localObject).optString("extraInfo", ""));
        ((ak)h.ag(ak.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramView.toString(), null);
        GestureGalleryUI.e(this.MfO, 5);
      }
      catch (Exception paramView)
      {
        xw localxw;
        continue;
      }
      a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(179708);
      return;
      if (((JSONObject)localObject).optInt("jumpType", 0) == 2)
      {
        paramView = ((JSONObject)localObject).optString("userName");
        localObject = ((JSONObject)localObject).optString("weappUrl");
        localxw = new xw();
        localxw.fWN.userName = paramView;
        localxw.fWN.fWP = ((String)localObject);
        EventCenter.instance.publish(localxw);
      }
      else if (((JSONObject)localObject).optInt("jumpType", 0) == 3)
      {
        paramView = ((JSONObject)localObject).optString("jumpUrl");
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramView);
        c.b(this.MfO, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.13
 * JD-Core Version:    0.7.0.1
 */