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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;

public final class aa
  extends k
{
  TextView ss;
  private RelativeLayout xcD;
  ImageView xcE;
  
  public aa(Context paramContext, ab paramab, ViewGroup paramViewGroup)
  {
    super(paramContext, paramab, paramViewGroup);
    this.xab = paramab;
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(96682);
    super.dvA();
    AppMethodBeat.o(96682);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96679);
    this.ss.setText(((ab)this.xab).label);
    this.ss.setTextSize(0, ((ab)this.xab).buK);
    if ((((ab)this.xab).jbK != null) && (((ab)this.xab).jbK.length() > 0))
    {
      int i = Color.parseColor(((ab)this.xab).jbK);
      this.xcD.setBackgroundColor(i);
    }
    h.a(((ab)this.xab).wWY, ((ab)this.xab).wWF, new f.a()
    {
      public final void apm(String paramAnonymousString)
      {
        AppMethodBeat.i(96677);
        try
        {
          paramAnonymousString = f.decodeFile(paramAnonymousString);
          aa.this.xcE.setImageBitmap(paramAnonymousString);
          paramAnonymousString = aa.this.ss;
          Paint localPaint = new Paint();
          String str = paramAnonymousString.getText().toString();
          localPaint.setTextSize(paramAnonymousString.getTextSize());
          float f = localPaint.measureText(str, 0, str.length());
          f = aa.this.xab.wWG - f - TypedValue.applyDimension(1, 3.0F, aa.this.context.getResources().getDisplayMetrics());
          int i = (int)(f - aa.a(aa.this).value * f);
          paramAnonymousString = (RelativeLayout.LayoutParams)aa.this.xcE.getLayoutParams();
          paramAnonymousString.setMargins(paramAnonymousString.leftMargin, paramAnonymousString.topMargin, i, paramAnonymousString.leftMargin);
          aa.this.xcE.setLayoutParams(paramAnonymousString);
          AppMethodBeat.o(96677);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bt.m(paramAnonymousString));
          AppMethodBeat.o(96677);
        }
      }
      
      public final void dsA() {}
      
      public final void duP() {}
    });
    AppMethodBeat.o(96679);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96680);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    this.ss = ((TextView)localView.findViewById(2131304896));
    this.xcD = ((RelativeLayout)localView.findViewById(2131304894));
    this.xcE = ((ImageView)localView.findViewById(2131304895));
    AppMethodBeat.o(96680);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96678);
    super.dvy();
    AppMethodBeat.o(96678);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96681);
    super.dvz();
    AppMethodBeat.o(96681);
  }
  
  protected final int getLayout()
  {
    return 2131495506;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa
 * JD-Core Version:    0.7.0.1
 */