package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mm.h.a.pb;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class SnsTransparentUI$1$1$1
  implements f.a
{
  SnsTransparentUI$1$1$1(SnsTransparentUI.1.1 param1, WXMediaMessage paramWXMediaMessage, String paramString) {}
  
  public final void Op(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      SnsTransparentUI.a(this.pij.pih.pif).put(this.pij.pih.pia, paramString);
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        y.i("SnsTransparentUI", "thumb image is not null");
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        this.pii.thumbData = localByteArrayOutputStream.toByteArray();
      }
      paramString = new pb();
      paramString.bYE.bRd = this.pii;
      paramString.bYE.toUser = this.pij.bxX;
      paramString.bYE.bYF = 49;
      paramString.bYE.bYG = "";
      paramString.bYE.bYH = "";
      paramString.bYE.bYN = this.pij.pih.pie;
      a.udP.m(paramString);
      if (!TextUtils.isEmpty(this.dAG))
      {
        paramString = new pe();
        paramString.bYQ.bYR = this.pij.bxX;
        paramString.bYQ.content = this.dAG;
        paramString.bYQ.type = s.hW(this.pij.bxX);
        paramString.bYQ.flags = 0;
        a.udP.m(paramString);
      }
      h.bC(this.pij.val$context, this.pij.val$context.getString(i.j.app_shared));
      this.pij.pih.pif.finish();
      return;
    }
    catch (Exception paramString)
    {
      y.e("SnsTransparentUI", "this has a error : " + paramString.toString());
      this.pij.pih.pif.finish();
    }
  }
  
  public final void bCF()
  {
    h.bC(this.pij.val$context, this.pij.val$context.getString(i.j.share_err));
    this.pij.pih.pif.finish();
  }
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1.1.1
 * JD-Core Version:    0.7.0.1
 */