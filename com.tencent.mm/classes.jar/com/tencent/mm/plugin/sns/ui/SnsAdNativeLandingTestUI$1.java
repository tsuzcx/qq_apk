package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;

final class SnsAdNativeLandingTestUI$1
  implements View.OnClickListener
{
  SnsAdNativeLandingTestUI$1(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98420);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("Select_Conv_Type", 259);
    paramView.putExtra("select_is_ret", true);
    c.a(this.Ezj, ".ui.transmit.SelectConversationUI", paramView, 0, new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98419);
        if (paramAnonymousInt2 == -1)
        {
          if (paramAnonymousIntent == null) {}
          for (paramAnonymousIntent = null; (paramAnonymousIntent == null) || (paramAnonymousIntent.length() == 0); paramAnonymousIntent = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
          {
            Log.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", "mmOnActivityResult fail, toUser is null");
            AppMethodBeat.o(98419);
            return;
          }
          final SnsAdNativeLandingTestUI localSnsAdNativeLandingTestUI = SnsAdNativeLandingTestUI.1.this.Ezj;
          ab.a.Kgn.a(((MMActivity)localSnsAdNativeLandingTestUI).getController(), "test title", "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150", "test desc", true, localSnsAdNativeLandingTestUI.getResources().getString(2131755976), new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(98418);
              if (paramAnonymous2Boolean)
              {
                Object localObject1 = new WXMediaMessage();
                ((WXMediaMessage)localObject1).title = "test title";
                ((WXMediaMessage)localObject1).description = "test desc";
                Object localObject2 = new WXWebpageObject();
                ((WXWebpageObject)localObject2).canvasPageXml = "<xml></xml>";
                ((WXWebpageObject)localObject2).webpageUrl = "http://www.baidu.com/";
                ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
                localObject2 = ap.getBitmap("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
                if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
                {
                  Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
                  ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                  ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                  ((WXMediaMessage)localObject1).thumbData = localByteArrayOutputStream.toByteArray();
                }
                localObject2 = new tt();
                ((tt)localObject2).eaf.dCE = ((WXMediaMessage)localObject1);
                ((tt)localObject2).eaf.toUser = paramAnonymousIntent;
                ((tt)localObject2).eaf.dMG = 49;
                ((tt)localObject2).eaf.eag = "";
                ((tt)localObject2).eaf.eah = "";
                EventCenter.instance.publish((IEvent)localObject2);
                if (!TextUtils.isEmpty(paramAnonymous2String))
                {
                  localObject1 = new tw();
                  ((tw)localObject1).eaq.dkV = paramAnonymousIntent;
                  ((tw)localObject1).eaq.content = paramAnonymous2String;
                  ((tw)localObject1).eaq.type = com.tencent.mm.model.ab.JG(paramAnonymousIntent);
                  ((tw)localObject1).eaq.flags = 0;
                  EventCenter.instance.publish((IEvent)localObject1);
                }
                h.cD(localSnsAdNativeLandingTestUI, localSnsAdNativeLandingTestUI.getString(2131755986));
                AppMethodBeat.o(98418);
                return;
              }
              AppMethodBeat.o(98418);
            }
          });
        }
        AppMethodBeat.o(98419);
      }
    });
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(98420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.1
 * JD-Core Version:    0.7.0.1
 */