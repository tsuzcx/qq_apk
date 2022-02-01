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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class ac
  extends m
{
  TextView vk;
  private RelativeLayout zXs;
  ImageView zXt;
  
  public ac(Context paramContext, ad paramad, ViewGroup paramViewGroup)
  {
    super(paramContext, paramad, paramViewGroup);
    this.zUP = paramad;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96680);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    this.vk = ((TextView)localView.findViewById(2131304896));
    this.zXs = ((RelativeLayout)localView.findViewById(2131304894));
    this.zXt = ((ImageView)localView.findViewById(2131304895));
    AppMethodBeat.o(96680);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96679);
    this.vk.setText(((ad)this.zUP).label);
    this.vk.setTextSize(0, ((ad)this.zUP).fontSize);
    if ((((ad)this.zUP).jZm != null) && (((ad)this.zUP).jZm.length() > 0))
    {
      int i = Color.parseColor(((ad)this.zUP).jZm);
      this.zXs.setBackgroundColor(i);
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(((ad)this.zUP).zRC, ((ad)this.zUP).zRh, new f.a()
    {
      public final void ayY(String paramAnonymousString)
      {
        AppMethodBeat.i(96677);
        try
        {
          paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString);
          ac.this.zXt.setImageBitmap(paramAnonymousString);
          paramAnonymousString = ac.this.vk;
          Paint localPaint = new Paint();
          String str = paramAnonymousString.getText().toString();
          localPaint.setTextSize(paramAnonymousString.getTextSize());
          float f = localPaint.measureText(str, 0, str.length());
          f = ac.this.zUP.zRi - f - TypedValue.applyDimension(1, 3.0F, ac.this.context.getResources().getDisplayMetrics());
          int i = (int)(f - ac.a(ac.this).value * f);
          paramAnonymousString = (RelativeLayout.LayoutParams)ac.this.zXt.getLayoutParams();
          paramAnonymousString.setMargins(paramAnonymousString.leftMargin, paramAnonymousString.topMargin, i, paramAnonymousString.leftMargin);
          ac.this.zXt.setLayoutParams(paramAnonymousString);
          AppMethodBeat.o(96677);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bu.o(paramAnonymousString));
          AppMethodBeat.o(96677);
        }
      }
      
      public final void dVu() {}
      
      public final void dVv() {}
    });
    AppMethodBeat.o(96679);
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96681);
    super.dUK();
    AppMethodBeat.o(96681);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96682);
    super.dUL();
    AppMethodBeat.o(96682);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96678);
    super.dUM();
    AppMethodBeat.o(96678);
  }
  
  protected final int getLayout()
  {
    return 2131495506;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac
 * JD-Core Version:    0.7.0.1
 */