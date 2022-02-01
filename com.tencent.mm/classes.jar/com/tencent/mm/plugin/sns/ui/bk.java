package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;

public final class bk
{
  private String tWM;
  private View view;
  private LinearLayout yYb;
  public TextView yYc;
  public TextView yYd;
  private View yYe;
  private View yYf;
  public com.tencent.mm.plugin.sns.storage.b yYg;
  public com.tencent.mm.plugin.sns.storage.a yYh;
  
  public bk(View paramView)
  {
    AppMethodBeat.i(99719);
    this.view = paramView;
    this.tWM = ab.iC(ai.getContext());
    ac.i("MicroMsg.TimeLineAdView", "adView init lan " + this.tWM);
    this.yYc = ((TextView)this.view.findViewById(2131296432));
    this.yYd = ((TextView)this.view.findViewById(2131296435));
    this.yYe = this.view.findViewById(2131296433);
    this.yYf = this.view.findViewById(2131296434);
    this.yYb = ((LinearLayout)this.view.findViewById(2131296431));
    paramView = " " + this.view.getResources().getString(2131763766) + " ";
    this.yYc.setText(paramView);
    AppMethodBeat.o(99719);
  }
  
  public final void F(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(99721);
    this.yYd.setTag(paramObject1);
    this.yYc.setTag(paramObject2);
    if (this.yYe != null) {
      this.yYe.setTag(paramObject2);
    }
    if (this.yYb != null) {
      this.yYb.setTag(paramObject2);
    }
    AppMethodBeat.o(99721);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(99720);
    this.yYd.setOnClickListener(paramOnClickListener1);
    this.yYc.setOnClickListener(paramOnClickListener2);
    if (this.yYe != null) {
      this.yYe.setOnClickListener(paramOnClickListener2);
    }
    if (this.yYb != null) {
      this.yYb.setOnClickListener(paramOnClickListener2);
    }
    AppMethodBeat.o(99720);
  }
  
  public final void a(com.tencent.mm.plugin.sns.storage.b paramb, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(99722);
    this.yYh = parama;
    this.yYg = paramb;
    Object localObject1 = "";
    Context localContext;
    if (paramb != null)
    {
      if ("zh_CN".equals(this.tWM)) {
        localObject1 = paramb.yfz;
      }
    }
    else
    {
      Object localObject2 = localObject1;
      if (paramb != null)
      {
        localObject2 = localObject1;
        if (bs.isNullOrNil((String)localObject1)) {
          localObject2 = paramb.yfx;
        }
      }
      localContext = this.yYd.getContext();
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = localContext.getString(2131763772);
      }
      localObject1 = (String)localObject1 + " ";
      final int i = ((String)localObject1).length();
      localObject2 = new SpannableString((String)localObject1 + "ad_");
      if ((parama == null) || (!parama.dJC())) {
        break label404;
      }
      if (!aj.DT()) {
        break label389;
      }
      localObject1 = localContext.getResources().getDrawable(2131689524);
      label183:
      ((Drawable)localObject1).setBounds(0, 0, (int)(this.yYd.getTextSize() * 0.8D), (int)(this.yYd.getTextSize() * 0.8D));
      localObject1 = new ImageSpan((Drawable)localObject1, 1);
      if (!bs.isNullOrNil(paramb.yfy)) {
        h.c("adId", paramb.yfy, false, 41, new f.a()
        {
          public final void asD(String paramAnonymousString)
          {
            AppMethodBeat.i(99717);
            if (bs.isNullOrNil(paramAnonymousString))
            {
              AppMethodBeat.o(99717);
              return;
            }
            paramAnonymousString = Drawable.createFromPath(paramAnonymousString);
            if (paramAnonymousString != null)
            {
              paramAnonymousString.setBounds(0, 0, (int)(bk.this.yYd.getTextSize() * 1.3D), (int)(bk.this.yYd.getTextSize() * 1.3D));
              paramAnonymousString = new ImageSpan(paramAnonymousString, 0);
              this.yYi.setSpan(paramAnonymousString, i, i + 3, 33);
              bk.this.yYd.setText(this.yYi);
            }
            AppMethodBeat.o(99717);
          }
          
          public final void dFC() {}
          
          public final void dFD() {}
        });
      }
      ((SpannableString)localObject2).setSpan(localObject1, i, i + 3, 33);
      this.yYd.setText((CharSequence)localObject2);
      if ((parama == null) || (bs.isNullOrNil(parama.yeG))) {
        break label485;
      }
      this.yYf.setVisibility(0);
      label305:
      if (paramb != null)
      {
        if (!"zh_CN".equals(this.tWM)) {
          break label497;
        }
        paramb = paramb.yfI;
      }
    }
    for (;;)
    {
      if (!bs.isNullOrNil(paramb)) {
        this.yYc.setText(paramb);
      }
      AppMethodBeat.o(99722);
      return;
      if (("zh_TW".equals(this.tWM)) || ("zh_HK".equals(this.tWM)))
      {
        localObject1 = paramb.yfB;
        break;
      }
      localObject1 = paramb.yfA;
      break;
      label389:
      localObject1 = localContext.getResources().getDrawable(2131689523);
      break label183;
      label404:
      if (aj.DT()) {}
      for (localObject1 = localContext.getResources().getDrawable(2131689525);; localObject1 = localContext.getResources().getDrawable(2131689526))
      {
        ((Drawable)localObject1).setBounds(0, 0, (int)(this.yYd.getTextSize() * 0.8D), (int)(this.yYd.getTextSize() * 0.8D));
        localObject1 = new ImageSpan((Drawable)localObject1, 1);
        break;
      }
      label485:
      this.yYf.setVisibility(8);
      break label305;
      label497:
      if (("zh_TW".equals(this.tWM)) || ("zh_HK".equals(this.tWM))) {
        paramb = paramb.yfK;
      } else {
        paramb = paramb.yfJ;
      }
    }
  }
  
  public final String dRs()
  {
    if (this.yYh == null) {
      return "";
    }
    if (this.yYh.dtx == null) {
      return "";
    }
    return this.yYh.dtx;
  }
  
  public final int[] dRt()
  {
    AppMethodBeat.i(99718);
    int[] arrayOfInt = new int[2];
    if (this.yYb != null)
    {
      this.yYe.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] += this.yYe.getMeasuredWidth() + com.tencent.mm.cc.a.fromDPToPix(this.yYe.getContext(), 5);
    }
    for (;;)
    {
      AppMethodBeat.o(99718);
      return arrayOfInt;
      if (this.yYe != null)
      {
        this.yYe.getLocationInWindow(arrayOfInt);
        arrayOfInt[0] += this.yYe.getMeasuredWidth() + com.tencent.mm.cc.a.fromDPToPix(this.yYe.getContext(), 5);
      }
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(99723);
    com.tencent.mm.storage.a locala;
    if ((this.yYg != null) && (this.yYg.yfw == 1))
    {
      this.yYd.setVisibility(8);
      locala = d.aAq().aMC("Sns_CanvasAd_DetailLink_JumpWay");
      if (!locala.isValid()) {
        break label202;
      }
    }
    label202:
    for (int i = bs.getInt(locala.field_value, -1);; i = -1)
    {
      if ((i != -1) && (this.yYg != null) && (this.yYg.dJG()) && (i.auO(this.yYg.dqf))) {
        this.yYd.setVisibility(paramInt);
      }
      this.yYc.setVisibility(paramInt);
      if (this.yYe != null) {
        this.yYe.setVisibility(paramInt);
      }
      if (this.yYb != null) {
        this.yYb.setVisibility(paramInt);
      }
      if ((this.yYh != null) && (!bs.isNullOrNil(this.yYh.yeG)))
      {
        this.yYf.setVisibility(paramInt);
        AppMethodBeat.o(99723);
        return;
        this.yYd.setVisibility(paramInt);
        break;
      }
      this.yYf.setVisibility(8);
      AppMethodBeat.o(99723);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bk
 * JD-Core Version:    0.7.0.1
 */