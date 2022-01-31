package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.pluginsdk.ui.applet.t.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class SnsTransparentUI$1
  implements MMActivity.a
{
  SnsTransparentUI$1(SnsTransparentUI paramSnsTransparentUI, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(39633);
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {}
      for (paramIntent = null; (paramIntent == null) || (paramIntent.length() == 0); paramIntent = paramIntent.getStringExtra("Select_Conv_User"))
      {
        ab.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
        this.saK.finish();
        AppMethodBeat.o(39633);
        return;
      }
      ab.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
      final String str = this.saE;
      final SnsTransparentUI localSnsTransparentUI = this.saK;
      t.a.vUz.a(((MMActivity)localSnsTransparentUI).getController(), this.saF, this.saG, this.saH, true, localSnsTransparentUI.getResources().getString(2131297067), new q.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(39632);
          if (paramAnonymousBoolean)
          {
            Object localObject1 = new WXMediaMessage();
            ((WXMediaMessage)localObject1).title = SnsTransparentUI.1.this.saF;
            ((WXMediaMessage)localObject1).description = SnsTransparentUI.1.this.saH;
            Object localObject2 = new WXWebpageObject();
            ((WXWebpageObject)localObject2).canvasPageXml = str;
            ((WXWebpageObject)localObject2).webpageUrl = SnsTransparentUI.1.this.saI;
            ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
            if (SnsTransparentUI.a(SnsTransparentUI.1.this.saK).containsKey(SnsTransparentUI.1.this.saG))
            {
              localObject2 = (Bitmap)SnsTransparentUI.a(SnsTransparentUI.1.this.saK).get(SnsTransparentUI.1.this.saG);
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                ab.i("SnsTransparentUI", "thumb image is not null");
                ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                ((WXMediaMessage)localObject1).thumbData = localByteArrayOutputStream.toByteArray();
              }
              localObject2 = new qg();
              ((qg)localObject2).cGL.cyF = ((WXMediaMessage)localObject1);
              ((qg)localObject2).cGL.toUser = paramIntent;
              ((qg)localObject2).cGL.cGM = 49;
              ((qg)localObject2).cGL.cGN = "";
              ((qg)localObject2).cGL.cGO = "";
              ((qg)localObject2).cGL.cGU = SnsTransparentUI.1.this.saJ;
              a.ymk.l((b)localObject2);
              if (!TextUtils.isEmpty(paramAnonymousString))
              {
                localObject1 = new qj();
                ((qj)localObject1).cGX.cGY = paramIntent;
                ((qj)localObject1).cGX.content = paramAnonymousString;
                ((qj)localObject1).cGX.type = com.tencent.mm.model.t.oF(paramIntent);
                ((qj)localObject1).cGX.flags = 0;
                a.ymk.l((b)localObject1);
              }
              com.tencent.mm.ui.base.h.bO(localSnsTransparentUI, localSnsTransparentUI.getString(2131297076));
              SnsTransparentUI.1.this.saK.finish();
              AppMethodBeat.o(39632);
              return;
            }
            ag.cE(SnsTransparentUI.1.this.saG);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", SnsTransparentUI.1.this.saG, false, 1000000001, new SnsTransparentUI.1.1.1(this, (WXMediaMessage)localObject1, paramAnonymousString));
            AppMethodBeat.o(39632);
            return;
          }
          com.tencent.mm.ui.base.h.bO(localSnsTransparentUI, localSnsTransparentUI.getString(2131303663));
          SnsTransparentUI.1.this.saK.finish();
          AppMethodBeat.o(39632);
        }
      });
      AppMethodBeat.o(39633);
      return;
    }
    this.saK.finish();
    AppMethodBeat.o(39633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1
 * JD-Core Version:    0.7.0.1
 */