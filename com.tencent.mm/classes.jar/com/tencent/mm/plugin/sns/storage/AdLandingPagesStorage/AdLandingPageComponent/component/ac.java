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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ac
  extends m
{
  private RelativeLayout KsK;
  ImageView KsL;
  TextView bFR;
  
  public ac(Context paramContext, af paramaf, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaf, paramViewGroup);
    this.KqB = paramaf;
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96679);
    this.bFR.setText(((af)this.KqB).label);
    this.bFR.setTextSize(0, ((af)this.KqB).fontSize);
    if ((((af)this.KqB).nWx != null) && (((af)this.KqB).nWx.length() > 0))
    {
      int i = Color.parseColor(((af)this.KqB).nWx);
      this.KsK.setBackgroundColor(i);
    }
    h.a("adId", ((af)this.KqB).Knd, new f.a()
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(96677);
        try
        {
          paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
          ac.this.KsL.setImageBitmap(paramAnonymousString);
          paramAnonymousString = ac.this.bFR;
          Paint localPaint = new Paint();
          String str = paramAnonymousString.getText().toString();
          localPaint.setTextSize(paramAnonymousString.getTextSize());
          float f = localPaint.measureText(str, 0, str.length());
          f = ac.this.KqB.KmD - f - TypedValue.applyDimension(1, 3.0F, ac.this.context.getResources().getDisplayMetrics());
          int i = (int)(f - ((af)ac.this.KqB).value * f);
          paramAnonymousString = (RelativeLayout.LayoutParams)ac.this.KsL.getLayoutParams();
          paramAnonymousString.setMargins(paramAnonymousString.leftMargin, paramAnonymousString.topMargin, i, paramAnonymousString.leftMargin);
          ac.this.KsL.setLayoutParams(paramAnonymousString);
          AppMethodBeat.o(96677);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + Util.stackTraceToString(paramAnonymousString));
          AppMethodBeat.o(96677);
        }
      }
      
      public final void fJU() {}
      
      public final void fJV() {}
    });
    AppMethodBeat.o(96679);
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96681);
    super.fKk();
    AppMethodBeat.o(96681);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96682);
    super.fKl();
    AppMethodBeat.o(96682);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96678);
    super.fKo();
    AppMethodBeat.o(96678);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96680);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    this.bFR = ((TextView)localView.findViewById(i.f.sns_ad_landingpage_processbar_label));
    this.KsK = ((RelativeLayout)localView.findViewById(i.f.sns_ad_landingpage_processbar_bg));
    this.KsL = ((ImageView)localView.findViewById(i.f.sns_ad_landingpage_processbar_front));
    AppMethodBeat.o(96680);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_process_bar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac
 * JD-Core Version:    0.7.0.1
 */