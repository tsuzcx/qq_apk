package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.uw;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.a.b;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class SnsTransparentUI$1
  implements MMActivity.a
{
  SnsTransparentUI$1(SnsTransparentUI paramSnsTransparentUI, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public final void d(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(99455);
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {}
      for (paramIntent = null; (paramIntent == null) || (paramIntent.length() == 0); paramIntent = paramIntent.getStringExtra("Select_Conv_User"))
      {
        Log.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
        this.Lcu.finish();
        AppMethodBeat.o(99455);
        return;
      }
      Log.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
      final String str = this.Lco;
      final SnsTransparentUI localSnsTransparentUI = this.Lcu;
      ab.a.RgY.a(((MMActivity)localSnsTransparentUI).getController(), this.Lcp, this.Lcq, this.Lcr, true, localSnsTransparentUI.getResources().getString(i.j.app_send), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, final String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(99454);
          if (paramAnonymousBoolean)
          {
            Object localObject1 = new WXMediaMessage();
            ((WXMediaMessage)localObject1).title = SnsTransparentUI.1.this.Lcp;
            ((WXMediaMessage)localObject1).description = SnsTransparentUI.1.this.Lcr;
            Object localObject2 = new WXWebpageObject();
            ((WXWebpageObject)localObject2).canvasPageXml = str;
            ((WXWebpageObject)localObject2).webpageUrl = SnsTransparentUI.1.this.Lcs;
            ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
            if (SnsTransparentUI.a(SnsTransparentUI.1.this.Lcu).containsKey(SnsTransparentUI.1.this.Lcq))
            {
              localObject2 = (Bitmap)SnsTransparentUI.a(SnsTransparentUI.1.this.Lcu).get(SnsTransparentUI.1.this.Lcq);
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                Log.i("SnsTransparentUI", "thumb image is not null");
                ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                ((WXMediaMessage)localObject1).thumbData = localByteArrayOutputStream.toByteArray();
              }
              localObject2 = new uw();
              ((uw)localObject2).fUc.fvl = ((WXMediaMessage)localObject1);
              ((uw)localObject2).fUc.toUser = paramIntent;
              ((uw)localObject2).fUc.fFO = 49;
              ((uw)localObject2).fUc.fUd = "";
              ((uw)localObject2).fUc.fUe = "";
              ((uw)localObject2).fUc.fUk = SnsTransparentUI.1.this.Lct;
              EventCenter.instance.publish((IEvent)localObject2);
              if (!TextUtils.isEmpty(paramAnonymousString))
              {
                localObject1 = new uz();
                ((uz)localObject1).fUn.fcD = paramIntent;
                ((uz)localObject1).fUn.content = paramAnonymousString;
                ((uz)localObject1).fUn.type = com.tencent.mm.model.ab.QZ(paramIntent);
                ((uz)localObject1).fUn.flags = 0;
                EventCenter.instance.publish((IEvent)localObject1);
              }
              b.aC(paramIntent, SnsTransparentUI.1.this.JAp, SnsTransparentUI.1.this.KLd);
              com.tencent.mm.ui.base.h.cO(localSnsTransparentUI, localSnsTransparentUI.getString(i.j.app_shared));
              SnsTransparentUI.1.this.Lcu.finish();
              AppMethodBeat.o(99454);
              return;
            }
            MD5Util.getMD5String(SnsTransparentUI.1.this.Lcq);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", SnsTransparentUI.1.this.Lcq, new f.a()
            {
              public final void aYs(String paramAnonymous2String)
              {
                AppMethodBeat.i(99453);
                try
                {
                  paramAnonymous2String = BitmapUtil.decodeFile(paramAnonymous2String);
                  SnsTransparentUI.a(SnsTransparentUI.1.this.Lcu).put(SnsTransparentUI.1.this.Lcq, paramAnonymous2String);
                  if ((paramAnonymous2String != null) && (!paramAnonymous2String.isRecycled()))
                  {
                    Log.i("SnsTransparentUI", "thumb image is not null");
                    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                    paramAnonymous2String.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                    this.Lcw.thumbData = localByteArrayOutputStream.toByteArray();
                  }
                  paramAnonymous2String = new uw();
                  paramAnonymous2String.fUc.fvl = this.Lcw;
                  paramAnonymous2String.fUc.toUser = SnsTransparentUI.1.1.this.ffX;
                  paramAnonymous2String.fUc.fFO = 49;
                  paramAnonymous2String.fUc.fUd = "";
                  paramAnonymous2String.fUc.fUe = "";
                  paramAnonymous2String.fUc.fUk = SnsTransparentUI.1.this.Lct;
                  EventCenter.instance.publish(paramAnonymous2String);
                  if (!TextUtils.isEmpty(paramAnonymousString))
                  {
                    paramAnonymous2String = new uz();
                    paramAnonymous2String.fUn.fcD = SnsTransparentUI.1.1.this.ffX;
                    paramAnonymous2String.fUn.content = paramAnonymousString;
                    paramAnonymous2String.fUn.type = com.tencent.mm.model.ab.QZ(SnsTransparentUI.1.1.this.ffX);
                    paramAnonymous2String.fUn.flags = 0;
                    EventCenter.instance.publish(paramAnonymous2String);
                  }
                  b.aC(SnsTransparentUI.1.1.this.ffX, SnsTransparentUI.1.this.JAp, SnsTransparentUI.1.this.KLd);
                  com.tencent.mm.ui.base.h.cO(SnsTransparentUI.1.1.this.val$context, SnsTransparentUI.1.1.this.val$context.getString(i.j.app_shared));
                  SnsTransparentUI.1.this.Lcu.finish();
                  AppMethodBeat.o(99453);
                  return;
                }
                catch (Exception paramAnonymous2String)
                {
                  Log.e("SnsTransparentUI", "this has a error : " + paramAnonymous2String.toString());
                  SnsTransparentUI.1.this.Lcu.finish();
                  AppMethodBeat.o(99453);
                }
              }
              
              public final void fJU() {}
              
              public final void fJV()
              {
                AppMethodBeat.i(99452);
                com.tencent.mm.ui.base.h.cO(SnsTransparentUI.1.1.this.val$context, SnsTransparentUI.1.1.this.val$context.getString(i.j.share_err));
                SnsTransparentUI.1.this.Lcu.finish();
                AppMethodBeat.o(99452);
              }
            });
            AppMethodBeat.o(99454);
            return;
          }
          com.tencent.mm.ui.base.h.cO(localSnsTransparentUI, localSnsTransparentUI.getString(i.j.share_err));
          SnsTransparentUI.1.this.Lcu.finish();
          AppMethodBeat.o(99454);
        }
      });
      AppMethodBeat.o(99455);
      return;
    }
    this.Lcu.finish();
    AppMethodBeat.o(99455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1
 * JD-Core Version:    0.7.0.1
 */