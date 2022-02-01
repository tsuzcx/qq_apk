package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONArray;
import org.json.JSONObject;

final class GestureGalleryUI$12
  implements View.OnClickListener
{
  GestureGalleryUI$12(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(186652);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    try
    {
      localObject = GestureGalleryUI.O(this.BBc).optJSONObject(GestureGalleryUI.P(this.BBc));
      if (((JSONObject)localObject).optInt("jumpType", 0) == 9)
      {
        paramView = new JSONObject();
        paramView.put("feedId", ((JSONObject)localObject).optString("feedId", ""));
        paramView.put("extInfo", ((JSONObject)localObject).optJSONObject("extInfo"));
        ((t)g.ad(t.class)).enterFinderShareFeedUI(ak.getContext(), paramView.toString(), null);
      }
      for (;;)
      {
        label121:
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186652);
        return;
        if (((JSONObject)localObject).optInt("jumpType", 0) == 2)
        {
          paramView = ((JSONObject)localObject).optString("userName");
          localObject = ((JSONObject)localObject).optString("weappUrl");
          vq localvq = new vq();
          localvq.dKT.userName = paramView;
          localvq.dKT.dKV = ((String)localObject);
          com.tencent.mm.sdk.b.a.IvT.l(localvq);
        }
        else if (((JSONObject)localObject).optInt("jumpType", 0) == 3)
        {
          paramView = ((JSONObject)localObject).optString("jumpUrl");
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView);
          d.b(this.BBc, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
        }
      }
    }
    catch (Exception paramView)
    {
      break label121;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.12
 * JD-Core Version:    0.7.0.1
 */