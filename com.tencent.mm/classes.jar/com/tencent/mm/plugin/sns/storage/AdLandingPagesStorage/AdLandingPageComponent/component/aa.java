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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;

public final class aa
  extends k
{
  TextView tr;
  private RelativeLayout ypr;
  ImageView yps;
  
  public aa(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac paramac, ViewGroup paramViewGroup)
  {
    super(paramContext, paramac, paramViewGroup);
    this.ymQ = paramac;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96680);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    this.tr = ((TextView)localView.findViewById(2131304896));
    this.ypr = ((RelativeLayout)localView.findViewById(2131304894));
    this.yps = ((ImageView)localView.findViewById(2131304895));
    AppMethodBeat.o(96680);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96678);
    super.dJX();
    AppMethodBeat.o(96678);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96681);
    super.dJY();
    AppMethodBeat.o(96681);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96682);
    super.dJZ();
    AppMethodBeat.o(96682);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96679);
    this.tr.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)this.ymQ).label);
    this.tr.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)this.ymQ).bsJ);
    if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)this.ymQ).jBX != null) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)this.ymQ).jBX.length() > 0))
    {
      int i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)this.ymQ).jBX);
      this.ypr.setBackgroundColor(i);
    }
    h.a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)this.ymQ).yjN, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)this.ymQ).yjt, new f.a()
    {
      public final void asD(String paramAnonymousString)
      {
        AppMethodBeat.i(96677);
        try
        {
          paramAnonymousString = f.decodeFile(paramAnonymousString);
          aa.this.yps.setImageBitmap(paramAnonymousString);
          paramAnonymousString = aa.this.tr;
          Paint localPaint = new Paint();
          String str = paramAnonymousString.getText().toString();
          localPaint.setTextSize(paramAnonymousString.getTextSize());
          float f = localPaint.measureText(str, 0, str.length());
          f = aa.this.ymQ.yju - f - TypedValue.applyDimension(1, 3.0F, aa.this.context.getResources().getDisplayMetrics());
          int i = (int)(f - aa.a(aa.this).value * f);
          paramAnonymousString = (RelativeLayout.LayoutParams)aa.this.yps.getLayoutParams();
          paramAnonymousString.setMargins(paramAnonymousString.leftMargin, paramAnonymousString.topMargin, i, paramAnonymousString.leftMargin);
          aa.this.yps.setLayoutParams(paramAnonymousString);
          AppMethodBeat.o(96677);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bs.m(paramAnonymousString));
          AppMethodBeat.o(96677);
        }
      }
      
      public final void dFC() {}
      
      public final void dFD() {}
    });
    AppMethodBeat.o(96679);
  }
  
  protected final int getLayout()
  {
    return 2131495506;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa
 * JD-Core Version:    0.7.0.1
 */