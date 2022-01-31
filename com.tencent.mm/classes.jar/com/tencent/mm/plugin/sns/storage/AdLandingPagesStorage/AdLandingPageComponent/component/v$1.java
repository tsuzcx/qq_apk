package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class v$1
  implements f.a
{
  v$1(v paramv) {}
  
  public final void Op(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      this.oHH.oHG.setImageBitmap(paramString);
      paramString = this.oHH.flb;
      Paint localPaint = new Paint();
      String str = paramString.getText().toString();
      localPaint.setTextSize(paramString.getTextSize());
      float f = localPaint.measureText(str, 0, str.length());
      f = this.oHH.oFE.oDm - f - TypedValue.applyDimension(1, 3.0F, this.oHH.context.getResources().getDisplayMetrics());
      int i = (int)(f - v.a(this.oHH).value * f);
      paramString = (RelativeLayout.LayoutParams)this.oHH.oHG.getLayoutParams();
      paramString.setMargins(paramString.leftMargin, paramString.topMargin, i, paramString.leftMargin);
      this.oHH.oHG.setLayoutParams(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bk.j(paramString));
    }
  }
  
  public final void bCF() {}
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v.1
 * JD-Core Version:    0.7.0.1
 */