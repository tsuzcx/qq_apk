package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.span.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.s;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(7)
public class SnsTransparentUI
  extends MMActivity
{
  private Map<String, Bitmap> zWk;
  
  public SnsTransparentUI()
  {
    AppMethodBeat.i(99457);
    this.zWk = new HashMap();
    AppMethodBeat.o(99457);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(99458);
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    Object localObject = getIntent();
    if (localObject != null) {
      switch (((Intent)localObject).getIntExtra("op", -1))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(99458);
      return;
      paramBundle = ((Intent)localObject).getStringExtra("adlandingXml");
      final String str1 = ((Intent)localObject).getStringExtra("shareTitle");
      final String str2 = ((Intent)localObject).getStringExtra("shareThumbUrl");
      final String str3 = ((Intent)localObject).getStringExtra("shareDesc");
      final String str4 = ((Intent)localObject).getStringExtra("shareUrl");
      final String str5 = ((Intent)localObject).getStringExtra("statExtStr");
      final String str6 = ((Intent)localObject).getStringExtra("uxInfo");
      localObject = ((Intent)localObject).getStringExtra("canvasId");
      ae.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI");
      ae.i("SnsTransparentUI.Share", "uxInfo = " + str6 + ", canvasId = " + (String)localObject);
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Conv_Type", 259);
      localIntent.putExtra("select_is_ret", true);
      com.tencent.mm.br.d.a(this, ".ui.transmit.SelectConversationUI", localIntent, 0, new MMActivity.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, final Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(99455);
          if (paramAnonymousInt2 == -1)
          {
            if (paramAnonymousIntent == null) {}
            for (paramAnonymousIntent = null; (paramAnonymousIntent == null) || (paramAnonymousIntent.length() == 0); paramAnonymousIntent = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
            {
              ae.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
              SnsTransparentUI.this.finish();
              AppMethodBeat.o(99455);
              return;
            }
            ae.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
            final String str = paramBundle;
            final SnsTransparentUI localSnsTransparentUI = SnsTransparentUI.this;
            ab.a.Fpw.a(((MMActivity)localSnsTransparentUI).getController(), str1, str2, str3, true, localSnsTransparentUI.getResources().getString(2131755884), new y.a()
            {
              public final void a(boolean paramAnonymous2Boolean, final String paramAnonymous2String, int paramAnonymous2Int)
              {
                AppMethodBeat.i(99454);
                if (paramAnonymous2Boolean)
                {
                  Object localObject1 = new WXMediaMessage();
                  ((WXMediaMessage)localObject1).title = SnsTransparentUI.1.this.AEQ;
                  ((WXMediaMessage)localObject1).description = SnsTransparentUI.1.this.AES;
                  Object localObject2 = new WXWebpageObject();
                  ((WXWebpageObject)localObject2).canvasPageXml = str;
                  ((WXWebpageObject)localObject2).webpageUrl = SnsTransparentUI.1.this.AET;
                  ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
                  if (SnsTransparentUI.a(SnsTransparentUI.this).containsKey(SnsTransparentUI.1.this.AER))
                  {
                    localObject2 = (Bitmap)SnsTransparentUI.a(SnsTransparentUI.this).get(SnsTransparentUI.1.this.AER);
                    if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
                    {
                      ae.i("SnsTransparentUI", "thumb image is not null");
                      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                      ((WXMediaMessage)localObject1).thumbData = localByteArrayOutputStream.toByteArray();
                    }
                    localObject2 = new sv();
                    ((sv)localObject2).dIs.dve = ((WXMediaMessage)localObject1);
                    ((sv)localObject2).dIs.toUser = paramAnonymousIntent;
                    ((sv)localObject2).dIs.dvf = 49;
                    ((sv)localObject2).dIs.dIt = "";
                    ((sv)localObject2).dIs.dIu = "";
                    ((sv)localObject2).dIs.dIA = SnsTransparentUI.1.this.AEU;
                    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
                    if (!TextUtils.isEmpty(paramAnonymous2String))
                    {
                      localObject1 = new sy();
                      ((sy)localObject1).dID.cUB = paramAnonymousIntent;
                      ((sy)localObject1).dID.content = paramAnonymous2String;
                      ((sy)localObject1).dID.type = x.Bb(paramAnonymousIntent);
                      ((sy)localObject1).dID.flags = 0;
                      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
                    }
                    com.tencent.mm.plugin.sns.a.b.ax(paramAnonymousIntent, SnsTransparentUI.1.this.ztT, SnsTransparentUI.1.this.Aoz);
                    com.tencent.mm.ui.base.h.cm(localSnsTransparentUI, localSnsTransparentUI.getString(2131755894));
                    SnsTransparentUI.this.finish();
                    AppMethodBeat.o(99454);
                    return;
                  }
                  aj.ej(SnsTransparentUI.1.this.AER);
                  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", SnsTransparentUI.1.this.AER, false, 1000000001, new f.a()
                  {
                    public final void ayY(String paramAnonymous3String)
                    {
                      AppMethodBeat.i(99453);
                      try
                      {
                        paramAnonymous3String = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymous3String);
                        SnsTransparentUI.a(SnsTransparentUI.this).put(SnsTransparentUI.1.this.AER, paramAnonymous3String);
                        if ((paramAnonymous3String != null) && (!paramAnonymous3String.isRecycled()))
                        {
                          ae.i("SnsTransparentUI", "thumb image is not null");
                          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                          paramAnonymous3String.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                          this.AEX.thumbData = localByteArrayOutputStream.toByteArray();
                        }
                        paramAnonymous3String = new sv();
                        paramAnonymous3String.dIs.dve = this.AEX;
                        paramAnonymous3String.dIs.toUser = SnsTransparentUI.1.1.this.cXi;
                        paramAnonymous3String.dIs.dvf = 49;
                        paramAnonymous3String.dIs.dIt = "";
                        paramAnonymous3String.dIs.dIu = "";
                        paramAnonymous3String.dIs.dIA = SnsTransparentUI.1.this.AEU;
                        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymous3String);
                        if (!TextUtils.isEmpty(paramAnonymous2String))
                        {
                          paramAnonymous3String = new sy();
                          paramAnonymous3String.dID.cUB = SnsTransparentUI.1.1.this.cXi;
                          paramAnonymous3String.dID.content = paramAnonymous2String;
                          paramAnonymous3String.dID.type = x.Bb(SnsTransparentUI.1.1.this.cXi);
                          paramAnonymous3String.dID.flags = 0;
                          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymous3String);
                        }
                        com.tencent.mm.plugin.sns.a.b.ax(SnsTransparentUI.1.1.this.cXi, SnsTransparentUI.1.this.ztT, SnsTransparentUI.1.this.Aoz);
                        com.tencent.mm.ui.base.h.cm(SnsTransparentUI.1.1.this.val$context, SnsTransparentUI.1.1.this.val$context.getString(2131755894));
                        SnsTransparentUI.this.finish();
                        AppMethodBeat.o(99453);
                        return;
                      }
                      catch (Exception paramAnonymous3String)
                      {
                        ae.e("SnsTransparentUI", "this has a error : " + paramAnonymous3String.toString());
                        SnsTransparentUI.this.finish();
                        AppMethodBeat.o(99453);
                      }
                    }
                    
                    public final void dVu() {}
                    
                    public final void dVv()
                    {
                      AppMethodBeat.i(99452);
                      com.tencent.mm.ui.base.h.cm(SnsTransparentUI.1.1.this.val$context, SnsTransparentUI.1.1.this.val$context.getString(2131763645));
                      SnsTransparentUI.this.finish();
                      AppMethodBeat.o(99452);
                    }
                  });
                  AppMethodBeat.o(99454);
                  return;
                }
                com.tencent.mm.ui.base.h.cm(localSnsTransparentUI, localSnsTransparentUI.getString(2131763645));
                SnsTransparentUI.this.finish();
                AppMethodBeat.o(99454);
              }
            });
            AppMethodBeat.o(99455);
            return;
          }
          SnsTransparentUI.this.finish();
          AppMethodBeat.o(99455);
        }
      });
      AppMethodBeat.o(99458);
      return;
      paramBundle = ((Intent)localObject).getStringExtra("phoneNum");
      d.a.FzC.a(this, paramBundle, new DialogInterface.OnDismissListener()new Bundle
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(99456);
          an.gq(SnsTransparentUI.this);
          SnsTransparentUI.this.finish();
          AppMethodBeat.o(99456);
        }
      }, new Bundle());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI
 * JD-Core Version:    0.7.0.1
 */