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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ad
  extends m
{
  private RelativeLayout EfF;
  ImageView EfG;
  TextView vr;
  
  public ad(Context paramContext, ae paramae, ViewGroup paramViewGroup)
  {
    super(paramContext, paramae, paramViewGroup);
    this.EcX = paramae;
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96679);
    this.vr.setText(((ae)this.EcX).label);
    this.vr.setTextSize(0, ((ae)this.EcX).fontSize);
    if ((((ae)this.EcX).lco != null) && (((ae)this.EcX).lco.length() > 0))
    {
      int i = Color.parseColor(((ae)this.EcX).lco);
      this.EfF.setBackgroundColor(i);
    }
    h.a(((ae)this.EcX).DZI, ((ae)this.EcX).DZj, new f.a()
    {
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(96677);
        try
        {
          paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
          ad.this.EfG.setImageBitmap(paramAnonymousString);
          paramAnonymousString = ad.this.vr;
          Paint localPaint = new Paint();
          String str = paramAnonymousString.getText().toString();
          localPaint.setTextSize(paramAnonymousString.getTextSize());
          float f = localPaint.measureText(str, 0, str.length());
          f = ad.this.EcX.DZk - f - TypedValue.applyDimension(1, 3.0F, ad.this.context.getResources().getDisplayMetrics());
          int i = (int)(f - ad.a(ad.this).value * f);
          paramAnonymousString = (RelativeLayout.LayoutParams)ad.this.EfG.getLayoutParams();
          paramAnonymousString.setMargins(paramAnonymousString.leftMargin, paramAnonymousString.topMargin, i, paramAnonymousString.leftMargin);
          ad.this.EfG.setLayoutParams(paramAnonymousString);
          AppMethodBeat.o(96677);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + Util.stackTraceToString(paramAnonymousString));
          AppMethodBeat.o(96677);
        }
      }
      
      public final void eWN() {}
      
      public final void eWO() {}
    });
    AppMethodBeat.o(96679);
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96681);
    super.eWZ();
    AppMethodBeat.o(96681);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96682);
    super.eXa();
    AppMethodBeat.o(96682);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96678);
    super.eXd();
    AppMethodBeat.o(96678);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96680);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    this.vr = ((TextView)localView.findViewById(2131308032));
    this.EfF = ((RelativeLayout)localView.findViewById(2131308030));
    this.EfG = ((ImageView)localView.findViewById(2131308031));
    AppMethodBeat.o(96680);
  }
  
  protected final int getLayout()
  {
    return 2131496391;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad
 * JD-Core Version:    0.7.0.1
 */