package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.a.b;
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
        this.EOy.finish();
        AppMethodBeat.o(99455);
        return;
      }
      Log.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
      final String str = this.EOs;
      final SnsTransparentUI localSnsTransparentUI = this.EOy;
      ab.a.Kgn.a(((MMActivity)localSnsTransparentUI).getController(), this.EOt, this.EOu, this.EOv, true, localSnsTransparentUI.getResources().getString(2131755976), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, final String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(99454);
          if (paramAnonymousBoolean)
          {
            Object localObject1 = new WXMediaMessage();
            ((WXMediaMessage)localObject1).title = SnsTransparentUI.1.this.EOt;
            ((WXMediaMessage)localObject1).description = SnsTransparentUI.1.this.EOv;
            Object localObject2 = new WXWebpageObject();
            ((WXWebpageObject)localObject2).canvasPageXml = str;
            ((WXWebpageObject)localObject2).webpageUrl = SnsTransparentUI.1.this.EOw;
            ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
            if (SnsTransparentUI.a(SnsTransparentUI.1.this.EOy).containsKey(SnsTransparentUI.1.this.EOu))
            {
              localObject2 = (Bitmap)SnsTransparentUI.a(SnsTransparentUI.1.this.EOy).get(SnsTransparentUI.1.this.EOu);
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                Log.i("SnsTransparentUI", "thumb image is not null");
                ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                ((WXMediaMessage)localObject1).thumbData = localByteArrayOutputStream.toByteArray();
              }
              localObject2 = new tt();
              ((tt)localObject2).eaf.dCE = ((WXMediaMessage)localObject1);
              ((tt)localObject2).eaf.toUser = paramIntent;
              ((tt)localObject2).eaf.dMG = 49;
              ((tt)localObject2).eaf.eag = "";
              ((tt)localObject2).eaf.eah = "";
              ((tt)localObject2).eaf.ean = SnsTransparentUI.1.this.EOx;
              EventCenter.instance.publish((IEvent)localObject2);
              if (!TextUtils.isEmpty(paramAnonymousString))
              {
                localObject1 = new tw();
                ((tw)localObject1).eaq.dkV = paramIntent;
                ((tw)localObject1).eaq.content = paramAnonymousString;
                ((tw)localObject1).eaq.type = com.tencent.mm.model.ab.JG(paramIntent);
                ((tw)localObject1).eaq.flags = 0;
                EventCenter.instance.publish((IEvent)localObject1);
              }
              b.aI(paramIntent, SnsTransparentUI.1.this.Dty, SnsTransparentUI.1.this.Exk);
              com.tencent.mm.ui.base.h.cD(localSnsTransparentUI, localSnsTransparentUI.getString(2131755986));
              SnsTransparentUI.1.this.EOy.finish();
              AppMethodBeat.o(99454);
              return;
            }
            MD5Util.getMD5String(SnsTransparentUI.1.this.EOu);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", SnsTransparentUI.1.this.EOu, false, 1000000001, new f.a()
            {
              public final void aNH(String paramAnonymous2String)
              {
                AppMethodBeat.i(99453);
                try
                {
                  paramAnonymous2String = BitmapUtil.decodeFile(paramAnonymous2String);
                  SnsTransparentUI.a(SnsTransparentUI.1.this.EOy).put(SnsTransparentUI.1.this.EOu, paramAnonymous2String);
                  if ((paramAnonymous2String != null) && (!paramAnonymous2String.isRecycled()))
                  {
                    Log.i("SnsTransparentUI", "thumb image is not null");
                    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                    paramAnonymous2String.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                    this.EOA.thumbData = localByteArrayOutputStream.toByteArray();
                  }
                  paramAnonymous2String = new tt();
                  paramAnonymous2String.eaf.dCE = this.EOA;
                  paramAnonymous2String.eaf.toUser = SnsTransparentUI.1.1.this.dnJ;
                  paramAnonymous2String.eaf.dMG = 49;
                  paramAnonymous2String.eaf.eag = "";
                  paramAnonymous2String.eaf.eah = "";
                  paramAnonymous2String.eaf.ean = SnsTransparentUI.1.this.EOx;
                  EventCenter.instance.publish(paramAnonymous2String);
                  if (!TextUtils.isEmpty(paramAnonymousString))
                  {
                    paramAnonymous2String = new tw();
                    paramAnonymous2String.eaq.dkV = SnsTransparentUI.1.1.this.dnJ;
                    paramAnonymous2String.eaq.content = paramAnonymousString;
                    paramAnonymous2String.eaq.type = com.tencent.mm.model.ab.JG(SnsTransparentUI.1.1.this.dnJ);
                    paramAnonymous2String.eaq.flags = 0;
                    EventCenter.instance.publish(paramAnonymous2String);
                  }
                  b.aI(SnsTransparentUI.1.1.this.dnJ, SnsTransparentUI.1.this.Dty, SnsTransparentUI.1.this.Exk);
                  com.tencent.mm.ui.base.h.cD(SnsTransparentUI.1.1.this.val$context, SnsTransparentUI.1.1.this.val$context.getString(2131755986));
                  SnsTransparentUI.1.this.EOy.finish();
                  AppMethodBeat.o(99453);
                  return;
                }
                catch (Exception paramAnonymous2String)
                {
                  Log.e("SnsTransparentUI", "this has a error : " + paramAnonymous2String.toString());
                  SnsTransparentUI.1.this.EOy.finish();
                  AppMethodBeat.o(99453);
                }
              }
              
              public final void eWN() {}
              
              public final void eWO()
              {
                AppMethodBeat.i(99452);
                com.tencent.mm.ui.base.h.cD(SnsTransparentUI.1.1.this.val$context, SnsTransparentUI.1.1.this.val$context.getString(2131765833));
                SnsTransparentUI.1.this.EOy.finish();
                AppMethodBeat.o(99452);
              }
            });
            AppMethodBeat.o(99454);
            return;
          }
          com.tencent.mm.ui.base.h.cD(localSnsTransparentUI, localSnsTransparentUI.getString(2131765833));
          SnsTransparentUI.1.this.EOy.finish();
          AppMethodBeat.o(99454);
        }
      });
      AppMethodBeat.o(99455);
      return;
    }
    this.EOy.finish();
    AppMethodBeat.o(99455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1
 * JD-Core Version:    0.7.0.1
 */