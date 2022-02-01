package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class af
  extends n
{
  private RelativeLayout QRi;
  ImageView QRj;
  TextView dyR;
  
  public af(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af paramaf, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaf, paramViewGroup);
    this.QOV = paramaf;
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96680);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    this.dyR = ((TextView)localView.findViewById(b.f.sns_ad_landingpage_processbar_label));
    this.QRi = ((RelativeLayout)localView.findViewById(b.f.sns_ad_landingpage_processbar_bg));
    this.QRj = ((ImageView)localView.findViewById(b.f.sns_ad_landingpage_processbar_front));
    AppMethodBeat.o(96680);
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_process_bar;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96679);
    this.dyR.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)this.QOV).label);
    this.dyR.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)this.QOV).fontSize);
    if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)this.QOV).qWk != null) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)this.QOV).qWk.length() > 0))
    {
      int i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)this.QOV).qWk);
      this.QRi.setBackgroundColor(i);
    }
    k.b("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)this.QOV).QLi, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(96677);
        try
        {
          paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
          af.this.QRj.setImageBitmap(paramAnonymousString);
          paramAnonymousString = af.this.dyR;
          Paint localPaint = new Paint();
          String str = paramAnonymousString.getText().toString();
          localPaint.setTextSize(paramAnonymousString.getTextSize());
          float f = localPaint.measureText(str, 0, str.length());
          f = af.this.QOV.QKI - f - TypedValue.applyDimension(1, 3.0F, af.this.context.getResources().getDisplayMetrics());
          int i = (int)(f - ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)af.this.QOV).value * f);
          paramAnonymousString = (RelativeLayout.LayoutParams)af.this.QRj.getLayoutParams();
          paramAnonymousString.setMargins(paramAnonymousString.leftMargin, paramAnonymousString.topMargin, i, paramAnonymousString.leftMargin);
          af.this.QRj.setLayoutParams(paramAnonymousString);
          AppMethodBeat.o(96677);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + Util.stackTraceToString(paramAnonymousString));
          AppMethodBeat.o(96677);
        }
      }
      
      public final void gZM() {}
      
      public final void gZN() {}
    });
    AppMethodBeat.o(96679);
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96681);
    super.hao();
    AppMethodBeat.o(96681);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96682);
    super.hap();
    AppMethodBeat.o(96682);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96678);
    super.has();
    AppMethodBeat.o(96678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af
 * JD-Core Version:    0.7.0.1
 */