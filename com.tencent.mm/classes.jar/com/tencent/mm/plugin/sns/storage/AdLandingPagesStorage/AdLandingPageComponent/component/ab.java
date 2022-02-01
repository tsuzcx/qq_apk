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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;

public final class ab
  extends l
{
  TextView vk;
  private RelativeLayout zGm;
  ImageView zGn;
  
  public ab(Context paramContext, ac paramac, ViewGroup paramViewGroup)
  {
    super(paramContext, paramac, paramViewGroup);
    this.zDK = paramac;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96680);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    this.vk = ((TextView)localView.findViewById(2131304896));
    this.zGm = ((RelativeLayout)localView.findViewById(2131304894));
    this.zGn = ((ImageView)localView.findViewById(2131304895));
    AppMethodBeat.o(96680);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96679);
    this.vk.setText(((ac)this.zDK).label);
    this.vk.setTextSize(0, ((ac)this.zDK).fontSize);
    if ((((ac)this.zDK).jVX != null) && (((ac)this.zDK).jVX.length() > 0))
    {
      int i = Color.parseColor(((ac)this.zDK).jVX);
      this.zGm.setBackgroundColor(i);
    }
    h.a(((ac)this.zDK).zAC, ((ac)this.zDK).zAh, new f.a()
    {
      public final void axG(String paramAnonymousString)
      {
        AppMethodBeat.i(96677);
        try
        {
          paramAnonymousString = g.decodeFile(paramAnonymousString);
          ab.this.zGn.setImageBitmap(paramAnonymousString);
          paramAnonymousString = ab.this.vk;
          Paint localPaint = new Paint();
          String str = paramAnonymousString.getText().toString();
          localPaint.setTextSize(paramAnonymousString.getTextSize());
          float f = localPaint.measureText(str, 0, str.length());
          f = ab.this.zDK.zAi - f - TypedValue.applyDimension(1, 3.0F, ab.this.context.getResources().getDisplayMetrics());
          int i = (int)(f - ab.a(ab.this).value * f);
          paramAnonymousString = (RelativeLayout.LayoutParams)ab.this.zGn.getLayoutParams();
          paramAnonymousString.setMargins(paramAnonymousString.leftMargin, paramAnonymousString.topMargin, i, paramAnonymousString.leftMargin);
          ab.this.zGn.setLayoutParams(paramAnonymousString);
          AppMethodBeat.o(96677);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bt.n(paramAnonymousString));
          AppMethodBeat.o(96677);
        }
      }
      
      public final void dRW() {}
      
      public final void dRX() {}
    });
    AppMethodBeat.o(96679);
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96681);
    super.dRm();
    AppMethodBeat.o(96681);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96682);
    super.dRn();
    AppMethodBeat.o(96682);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96678);
    super.dRo();
    AppMethodBeat.o(96678);
  }
  
  protected final int getLayout()
  {
    return 2131495506;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab
 * JD-Core Version:    0.7.0.1
 */