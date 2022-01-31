package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;

final class SnsAdNativeLandingTestUI$1$1$1
  implements q.a
{
  SnsAdNativeLandingTestUI$1$1$1(SnsAdNativeLandingTestUI.1.1 param1, String paramString, Context paramContext) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(38700);
    if (paramBoolean)
    {
      Object localObject1 = new WXMediaMessage();
      ((WXMediaMessage)localObject1).title = "test title";
      ((WXMediaMessage)localObject1).description = "test desc";
      Object localObject2 = new WXWebpageObject();
      ((WXWebpageObject)localObject2).canvasPageXml = "<xml></xml>";
      ((WXWebpageObject)localObject2).webpageUrl = "http://www.baidu.com/";
      ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
      localObject2 = ae.getBitmap("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        ab.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        ((WXMediaMessage)localObject1).thumbData = localByteArrayOutputStream.toByteArray();
      }
      localObject2 = new qg();
      ((qg)localObject2).cGL.cyF = ((WXMediaMessage)localObject1);
      ((qg)localObject2).cGL.toUser = this.bZZ;
      ((qg)localObject2).cGL.cGM = 49;
      ((qg)localObject2).cGL.cGN = "";
      ((qg)localObject2).cGL.cGO = "";
      a.ymk.l((b)localObject2);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = new qj();
        ((qj)localObject1).cGX.cGY = this.bZZ;
        ((qj)localObject1).cGX.content = paramString;
        ((qj)localObject1).cGX.type = t.oF(this.bZZ);
        ((qj)localObject1).cGX.flags = 0;
        a.ymk.l((b)localObject1);
      }
      h.bO(this.val$context, this.val$context.getString(2131297076));
      AppMethodBeat.o(38700);
      return;
    }
    AppMethodBeat.o(38700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.1.1.1
 * JD-Core Version:    0.7.0.1
 */