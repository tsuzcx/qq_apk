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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;

final class SnsAdNativeLandingTestUI$1$1$1
  implements q.a
{
  SnsAdNativeLandingTestUI$1$1$1(SnsAdNativeLandingTestUI.1.1 param1, String paramString, Context paramContext) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      Object localObject1 = new WXMediaMessage();
      ((WXMediaMessage)localObject1).title = "test title";
      ((WXMediaMessage)localObject1).description = "test desc";
      Object localObject2 = new WXWebpageObject();
      ((WXWebpageObject)localObject2).canvasPageXml = "<xml></xml>";
      ((WXWebpageObject)localObject2).webpageUrl = "http://www.baidu.com/";
      ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
      localObject2 = ad.getBitmap("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        y.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
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
      h.bC(this.val$context, this.val$context.getString(i.j.app_shared));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.1.1.1
 * JD-Core Version:    0.7.0.1
 */