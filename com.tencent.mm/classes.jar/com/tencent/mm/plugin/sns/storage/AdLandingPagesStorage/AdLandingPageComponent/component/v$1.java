package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class v$1
  implements f.a
{
  v$1(v paramv) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37257);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      this.rxx.rxw.setImageBitmap(paramString);
      paramString = this.rxx.euY;
      Paint localPaint = new Paint();
      String str = paramString.getText().toString();
      localPaint.setTextSize(paramString.getTextSize());
      float f = localPaint.measureText(str, 0, str.length());
      f = this.rxx.rve.rsK - f - TypedValue.applyDimension(1, 3.0F, this.rxx.context.getResources().getDisplayMetrics());
      int i = (int)(f - v.a(this.rxx).value * f);
      paramString = (RelativeLayout.LayoutParams)this.rxx.rxw.getLayoutParams();
      paramString.setMargins(paramString.leftMargin, paramString.topMargin, i, paramString.leftMargin);
      this.rxx.rxw.setLayoutParams(paramString);
      AppMethodBeat.o(37257);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bo.l(paramString));
      AppMethodBeat.o(37257);
    }
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v.1
 * JD-Core Version:    0.7.0.1
 */