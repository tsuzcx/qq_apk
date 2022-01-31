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
import com.tencent.mm.model.c.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class bc
{
  private String nZZ;
  private LinearLayout scl;
  public TextView scm;
  public TextView scn;
  private View sco;
  private View scp;
  public com.tencent.mm.plugin.sns.storage.b scq;
  public com.tencent.mm.plugin.sns.storage.a scr;
  private View view;
  
  public bc(View paramView)
  {
    AppMethodBeat.i(39857);
    this.view = paramView;
    this.nZZ = aa.gP(ah.getContext());
    ab.i("MicroMsg.TimeLineAdView", "adView init lan " + this.nZZ);
    this.scm = ((TextView)this.view.findViewById(2131827887));
    this.scn = ((TextView)this.view.findViewById(2131827888));
    this.sco = this.view.findViewById(2131827942);
    this.scp = this.view.findViewById(2131827941);
    this.scl = ((LinearLayout)this.view.findViewById(2131827940));
    paramView = " " + this.view.getResources().getString(2131303763) + " ";
    this.scm.setText(paramView);
    AppMethodBeat.o(39857);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(39858);
    this.scn.setOnClickListener(paramOnClickListener1);
    this.scm.setOnClickListener(paramOnClickListener2);
    if (this.sco != null) {
      this.sco.setOnClickListener(paramOnClickListener2);
    }
    if (this.scl != null) {
      this.scl.setOnClickListener(paramOnClickListener2);
    }
    AppMethodBeat.o(39858);
  }
  
  public final void a(com.tencent.mm.plugin.sns.storage.b paramb, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(39860);
    this.scr = parama;
    this.scq = paramb;
    Object localObject1 = "";
    Context localContext;
    if (paramb != null)
    {
      if ("zh_CN".equals(this.nZZ)) {
        localObject1 = paramb.rpU;
      }
    }
    else
    {
      Object localObject2 = localObject1;
      if (paramb != null)
      {
        localObject2 = localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          localObject2 = paramb.rpS;
        }
      }
      localContext = this.scn.getContext();
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = localContext.getString(2131303769);
      }
      localObject1 = (String)localObject1 + " ";
      int i = ((String)localObject1).length();
      localObject2 = new SpannableString((String)localObject1 + "ad_");
      if ((parama == null) || (!parama.cqi())) {
        break label383;
      }
      localObject1 = localContext.getResources().getDrawable(2131230770);
      ((Drawable)localObject1).setBounds(0, 0, (int)(this.scn.getTextSize() * 0.8D), (int)(this.scn.getTextSize() * 0.8D));
      localObject1 = new ImageSpan((Drawable)localObject1, 1);
      label222:
      if (!bo.isNullOrNil(paramb.rpT)) {
        h.c("adId", paramb.rpT, false, 41, new bc.1(this, (SpannableString)localObject2, i));
      }
      ((SpannableString)localObject2).setSpan(localObject1, i, i + 3, 33);
      this.scn.setText((CharSequence)localObject2);
      if ((parama == null) || (bo.isNullOrNil(parama.rpn))) {
        break label443;
      }
      this.scp.setVisibility(0);
      label299:
      if (paramb != null)
      {
        if (!"zh_CN".equals(this.nZZ)) {
          break label455;
        }
        paramb = paramb.rqd;
      }
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramb)) {
        this.scm.setText(paramb);
      }
      AppMethodBeat.o(39860);
      return;
      if (("zh_TW".equals(this.nZZ)) || ("zh_HK".equals(this.nZZ)))
      {
        localObject1 = paramb.rpW;
        break;
      }
      localObject1 = paramb.rpV;
      break;
      label383:
      localObject1 = localContext.getResources().getDrawable(2131230771);
      ((Drawable)localObject1).setBounds(0, 0, (int)(this.scn.getTextSize() * 1.3D), (int)(this.scn.getTextSize() * 1.3D));
      localObject1 = new ImageSpan((Drawable)localObject1, 0);
      break label222;
      label443:
      this.scp.setVisibility(8);
      break label299;
      label455:
      if (("zh_TW".equals(this.nZZ)) || ("zh_HK".equals(this.nZZ))) {
        paramb = paramb.rqf;
      } else {
        paramb = paramb.rqe;
      }
    }
  }
  
  public final String cwG()
  {
    if (this.scr == null) {
      return "";
    }
    if (this.scr.cFe == null) {
      return "";
    }
    return this.scr.cFe;
  }
  
  public final int[] cwH()
  {
    AppMethodBeat.i(39856);
    int[] arrayOfInt = new int[2];
    if (this.scl != null)
    {
      this.sco.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] += this.sco.getMeasuredWidth();
    }
    for (;;)
    {
      AppMethodBeat.o(39856);
      return arrayOfInt;
      if (this.sco != null)
      {
        this.sco.getLocationInWindow(arrayOfInt);
        arrayOfInt[0] += this.sco.getMeasuredWidth();
      }
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(39861);
    com.tencent.mm.storage.a locala;
    if ((this.scq != null) && (this.scq.rpR == 1))
    {
      this.scn.setVisibility(8);
      locala = c.abV().aqM("Sns_CanvasAd_DetailLink_JumpWay");
      if (!locala.isValid()) {
        break label202;
      }
    }
    label202:
    for (int i = bo.getInt(locala.field_value, -1);; i = -1)
    {
      if ((i != -1) && (this.scq != null) && (this.scq.cqk()) && (i.abq(this.scq.cBW))) {
        this.scn.setVisibility(paramInt);
      }
      this.scm.setVisibility(paramInt);
      if (this.sco != null) {
        this.sco.setVisibility(paramInt);
      }
      if (this.scl != null) {
        this.scl.setVisibility(paramInt);
      }
      if ((this.scr != null) && (!bo.isNullOrNil(this.scr.rpn)))
      {
        this.scp.setVisibility(paramInt);
        AppMethodBeat.o(39861);
        return;
        this.scn.setVisibility(paramInt);
        break;
      }
      this.scp.setVisibility(8);
      AppMethodBeat.o(39861);
      return;
    }
  }
  
  public final void w(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(39859);
    this.scn.setTag(paramObject1);
    this.scm.setTag(paramObject2);
    if (this.sco != null) {
      this.sco.setTag(paramObject2);
    }
    if (this.scl != null) {
      this.scl.setTag(paramObject2);
    }
    AppMethodBeat.o(39859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bc
 * JD-Core Version:    0.7.0.1
 */