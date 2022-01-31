package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.h.a.pb;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class SnsTransparentUI$1$1
  implements q.a
{
  SnsTransparentUI$1$1(SnsTransparentUI.1 param1, String paramString1, Context paramContext, String paramString2) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      Object localObject1 = new WXMediaMessage();
      ((WXMediaMessage)localObject1).title = this.pih.phZ;
      ((WXMediaMessage)localObject1).description = this.pih.pib;
      Object localObject2 = new WXWebpageObject();
      ((WXWebpageObject)localObject2).canvasPageXml = this.pig;
      ((WXWebpageObject)localObject2).webpageUrl = this.pih.pic;
      ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
      if (SnsTransparentUI.a(this.pih.pif).containsKey(this.pih.pia))
      {
        localObject2 = (Bitmap)SnsTransparentUI.a(this.pih.pif).get(this.pih.pia);
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
        {
          y.i("SnsTransparentUI", "thumb image is not null");
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
          ((WXMediaMessage)localObject1).thumbData = localByteArrayOutputStream.toByteArray();
        }
        localObject2 = new pb();
        ((pb)localObject2).bYE.bRd = ((WXMediaMessage)localObject1);
        ((pb)localObject2).bYE.toUser = this.bxX;
        ((pb)localObject2).bYE.bYF = 49;
        ((pb)localObject2).bYE.bYG = "";
        ((pb)localObject2).bYE.bYH = "";
        ((pb)localObject2).bYE.bYN = this.pih.pie;
        a.udP.m((b)localObject2);
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = new pe();
          ((pe)localObject1).bYQ.bYR = this.bxX;
          ((pe)localObject1).bYQ.content = paramString;
          ((pe)localObject1).bYQ.type = s.hW(this.bxX);
          ((pe)localObject1).bYQ.flags = 0;
          a.udP.m((b)localObject1);
        }
        com.tencent.mm.ui.base.h.bC(this.val$context, this.val$context.getString(i.j.app_shared));
        this.pih.pif.finish();
        return;
      }
      ad.bB(this.pih.pia);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", this.pih.pia, false, 1000000001, new SnsTransparentUI.1.1.1(this, (WXMediaMessage)localObject1, paramString));
      return;
    }
    com.tencent.mm.ui.base.h.bC(this.val$context, this.val$context.getString(i.j.share_err));
    this.pih.pif.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1.1
 * JD-Core Version:    0.7.0.1
 */