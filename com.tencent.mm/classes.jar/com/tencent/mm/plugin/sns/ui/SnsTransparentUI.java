package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.autogen.a.wm;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.pluginsdk.ui.applet.ac;
import com.tencent.mm.pluginsdk.ui.applet.ac.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pluginsdk.ui.span.e.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.y;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class SnsTransparentUI
  extends MMActivity
{
  private Map<String, Bitmap> QQt;
  
  public SnsTransparentUI()
  {
    AppMethodBeat.i(99457);
    this.QQt = new HashMap();
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
      Log.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI");
      Log.i("SnsTransparentUI.Share", "uxInfo = " + str6 + ", canvasId = " + (String)localObject);
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Conv_Type", 259);
      localIntent.putExtra("select_is_ret", true);
      c.a(this, ".ui.transmit.SelectConversationUI", localIntent, 0, new MMActivity.a()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, final Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(99455);
          if (paramAnonymousInt2 == -1)
          {
            if (paramAnonymousIntent == null) {}
            for (paramAnonymousIntent = null; (paramAnonymousIntent == null) || (paramAnonymousIntent.length() == 0); paramAnonymousIntent = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
            {
              Log.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
              SnsTransparentUI.this.finish();
              AppMethodBeat.o(99455);
              return;
            }
            Log.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
            final String str = paramBundle;
            final SnsTransparentUI localSnsTransparentUI = SnsTransparentUI.this;
            ac.a.Yde.a(((MMActivity)localSnsTransparentUI).getController(), str1, str2, str3, true, localSnsTransparentUI.getResources().getString(b.j.app_send), new y.a()
            {
              public final void onDialogClick(boolean paramAnonymous2Boolean, final String paramAnonymous2String, int paramAnonymous2Int)
              {
                AppMethodBeat.i(99454);
                if (paramAnonymous2Boolean)
                {
                  Object localObject1 = new WXMediaMessage();
                  ((WXMediaMessage)localObject1).title = SnsTransparentUI.1.this.RCt;
                  ((WXMediaMessage)localObject1).description = SnsTransparentUI.1.this.RCv;
                  Object localObject2 = new WXWebpageObject();
                  ((WXWebpageObject)localObject2).canvasPageXml = str;
                  ((WXWebpageObject)localObject2).webpageUrl = SnsTransparentUI.1.this.RCw;
                  ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
                  if (SnsTransparentUI.a(SnsTransparentUI.this).containsKey(SnsTransparentUI.1.this.RCu))
                  {
                    localObject2 = (Bitmap)SnsTransparentUI.a(SnsTransparentUI.this).get(SnsTransparentUI.1.this.RCu);
                    if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
                    {
                      Log.i("SnsTransparentUI", "thumb image is not null");
                      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                      ((WXMediaMessage)localObject1).thumbData = localByteArrayOutputStream.toByteArray();
                    }
                    localObject2 = new wm();
                    ((wm)localObject2).hZZ.hzF = ((WXMediaMessage)localObject1);
                    ((wm)localObject2).hZZ.toUser = paramAnonymousIntent;
                    ((wm)localObject2).hZZ.hKZ = 49;
                    ((wm)localObject2).hZZ.iaa = "";
                    ((wm)localObject2).hZZ.iab = "";
                    ((wm)localObject2).hZZ.iah = SnsTransparentUI.1.this.RCx;
                    ((wm)localObject2).publish();
                    if (!TextUtils.isEmpty(paramAnonymous2String))
                    {
                      localObject1 = new wp();
                      ((wp)localObject1).iak.hgl = paramAnonymousIntent;
                      ((wp)localObject1).iak.content = paramAnonymous2String;
                      ((wp)localObject1).iak.type = ab.IX(paramAnonymousIntent);
                      ((wp)localObject1).iak.flags = 0;
                      ((wp)localObject1).publish();
                    }
                    b.aS(paramAnonymousIntent, SnsTransparentUI.1.this.PPX, SnsTransparentUI.1.this.RkQ);
                    com.tencent.mm.ui.base.k.cZ(localSnsTransparentUI, localSnsTransparentUI.getString(b.j.app_shared));
                    SnsTransparentUI.this.finish();
                    AppMethodBeat.o(99454);
                    return;
                  }
                  MD5Util.getMD5String(SnsTransparentUI.1.this.RCu);
                  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.b("adId", SnsTransparentUI.1.this.RCu, new g.a()
                  {
                    public final void aWn(String paramAnonymous3String)
                    {
                      AppMethodBeat.i(99453);
                      try
                      {
                        paramAnonymous3String = BitmapUtil.decodeFile(paramAnonymous3String);
                        SnsTransparentUI.a(SnsTransparentUI.this).put(SnsTransparentUI.1.this.RCu, paramAnonymous3String);
                        if ((paramAnonymous3String != null) && (!paramAnonymous3String.isRecycled()))
                        {
                          Log.i("SnsTransparentUI", "thumb image is not null");
                          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                          paramAnonymous3String.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
                          this.RCB.thumbData = localByteArrayOutputStream.toByteArray();
                        }
                        paramAnonymous3String = new wm();
                        paramAnonymous3String.hZZ.hzF = this.RCB;
                        paramAnonymous3String.hZZ.toUser = SnsTransparentUI.1.1.this.hkh;
                        paramAnonymous3String.hZZ.hKZ = 49;
                        paramAnonymous3String.hZZ.iaa = "";
                        paramAnonymous3String.hZZ.iab = "";
                        paramAnonymous3String.hZZ.iah = SnsTransparentUI.1.this.RCx;
                        paramAnonymous3String.publish();
                        if (!TextUtils.isEmpty(paramAnonymous2String))
                        {
                          paramAnonymous3String = new wp();
                          paramAnonymous3String.iak.hgl = SnsTransparentUI.1.1.this.hkh;
                          paramAnonymous3String.iak.content = paramAnonymous2String;
                          paramAnonymous3String.iak.type = ab.IX(SnsTransparentUI.1.1.this.hkh);
                          paramAnonymous3String.iak.flags = 0;
                          paramAnonymous3String.publish();
                        }
                        b.aS(SnsTransparentUI.1.1.this.hkh, SnsTransparentUI.1.this.PPX, SnsTransparentUI.1.this.RkQ);
                        com.tencent.mm.ui.base.k.cZ(SnsTransparentUI.1.1.this.val$context, SnsTransparentUI.1.1.this.val$context.getString(b.j.app_shared));
                        SnsTransparentUI.this.finish();
                        AppMethodBeat.o(99453);
                        return;
                      }
                      catch (Exception paramAnonymous3String)
                      {
                        Log.e("SnsTransparentUI", "this has a error : " + paramAnonymous3String.toString());
                        SnsTransparentUI.this.finish();
                        AppMethodBeat.o(99453);
                      }
                    }
                    
                    public final void gZM() {}
                    
                    public final void gZN()
                    {
                      AppMethodBeat.i(99452);
                      com.tencent.mm.ui.base.k.cZ(SnsTransparentUI.1.1.this.val$context, SnsTransparentUI.1.1.this.val$context.getString(b.j.share_err));
                      SnsTransparentUI.this.finish();
                      AppMethodBeat.o(99452);
                    }
                  });
                  AppMethodBeat.o(99454);
                  return;
                }
                com.tencent.mm.ui.base.k.cZ(localSnsTransparentUI, localSnsTransparentUI.getString(b.j.share_err));
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
      e.a.YnZ.a(this, paramBundle, new DialogInterface.OnDismissListener()new Bundle
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(99456);
          ar.jS(SnsTransparentUI.this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI
 * JD-Core Version:    0.7.0.1
 */