package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

final class k$7
  implements Runnable
{
  k$7(k paramk, AdLandingPageChattingTask paramAdLandingPageChattingTask, WxaExposedParams.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(145301);
    Intent localIntent = new Intent();
    localIntent.setFlags(67108864);
    localIntent.putExtra("Chat_User", this.rvw.username);
    localIntent.putExtra("app_brand_chatting_from_scene", 3);
    localIntent.putExtra("app_brand_chatting_expose_params", this.hKJ.ayJ());
    localIntent.putExtra("key_temp_session_from", this.rvw.sessionFrom);
    localIntent.putExtra("finish_direct", true);
    localIntent.putExtra("key_need_send_video", false);
    localIntent.putExtra("showMessageCard", false);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("uxInfo", this.rvt.crc().cFe);
      localObject = ((JSONObject)localObject).toString();
      localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject);
      MMActivity localMMActivity = (MMActivity)this.rvt.context;
      localMMActivity.mmSetOnActivityResultCallback(new k.7.1(this));
      ab.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(localObject)));
      d.b(localMMActivity, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
      AppMethodBeat.o(145301);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k.7
 * JD-Core Version:    0.7.0.1
 */