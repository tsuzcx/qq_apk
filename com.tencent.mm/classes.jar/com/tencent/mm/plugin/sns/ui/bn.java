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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;

public final class bn
{
  private LinearLayout ApM;
  public TextView ApN;
  public TextView ApO;
  private View ApP;
  private View ApQ;
  public com.tencent.mm.plugin.sns.storage.b ApR;
  public com.tencent.mm.plugin.sns.storage.a ApS;
  private String uZv;
  private View view;
  
  public bn(View paramView)
  {
    AppMethodBeat.i(99719);
    this.view = paramView;
    this.uZv = ac.iM(aj.getContext());
    ad.i("MicroMsg.TimeLineAdView", "adView init lan " + this.uZv);
    this.ApN = ((TextView)this.view.findViewById(2131296432));
    this.ApO = ((TextView)this.view.findViewById(2131296435));
    this.ApP = this.view.findViewById(2131296433);
    this.ApQ = this.view.findViewById(2131296434);
    this.ApM = ((LinearLayout)this.view.findViewById(2131296431));
    paramView = " " + this.view.getResources().getString(2131763766) + " ";
    this.ApN.setText(paramView);
    AppMethodBeat.o(99719);
  }
  
  public final void H(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(99721);
    this.ApO.setTag(paramObject1);
    this.ApN.setTag(paramObject2);
    if (this.ApP != null) {
      this.ApP.setTag(paramObject2);
    }
    if (this.ApM != null) {
      this.ApM.setTag(paramObject2);
    }
    AppMethodBeat.o(99721);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(99720);
    this.ApO.setOnClickListener(paramOnClickListener1);
    this.ApN.setOnClickListener(paramOnClickListener2);
    if (this.ApP != null) {
      this.ApP.setOnClickListener(paramOnClickListener2);
    }
    if (this.ApM != null) {
      this.ApM.setOnClickListener(paramOnClickListener2);
    }
    AppMethodBeat.o(99720);
  }
  
  public final void a(com.tencent.mm.plugin.sns.storage.b paramb, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(99722);
    this.ApS = parama;
    this.ApR = paramb;
    Object localObject1 = "";
    Context localContext;
    if (paramb != null)
    {
      if ("zh_CN".equals(this.uZv)) {
        localObject1 = paramb.zvB;
      }
    }
    else
    {
      Object localObject2 = localObject1;
      if (paramb != null)
      {
        localObject2 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject2 = paramb.zvz;
        }
      }
      localContext = this.ApO.getContext();
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = localContext.getString(2131763772);
      }
      localObject1 = (String)localObject1 + " ";
      final int i = ((String)localObject1).length();
      localObject2 = new SpannableString((String)localObject1 + "ad_");
      if ((parama == null) || (!parama.dVQ())) {
        break label404;
      }
      if (!al.isDarkMode()) {
        break label389;
      }
      localObject1 = localContext.getResources().getDrawable(2131689524);
      label183:
      ((Drawable)localObject1).setBounds(0, 0, (int)(this.ApO.getTextSize() * 0.8D), (int)(this.ApO.getTextSize() * 0.8D));
      localObject1 = new ImageSpan((Drawable)localObject1, 1);
      if (!bt.isNullOrNil(paramb.zvA)) {
        h.c("adId", paramb.zvA, false, 41, new f.a()
        {
          public final void axG(String paramAnonymousString)
          {
            AppMethodBeat.i(99717);
            if (bt.isNullOrNil(paramAnonymousString))
            {
              AppMethodBeat.o(99717);
              return;
            }
            paramAnonymousString = Drawable.createFromPath(paramAnonymousString);
            if (paramAnonymousString != null)
            {
              paramAnonymousString.setBounds(0, 0, (int)(bn.this.ApO.getTextSize() * 1.3D), (int)(bn.this.ApO.getTextSize() * 1.3D));
              paramAnonymousString = new ImageSpan(paramAnonymousString, 0);
              this.ApT.setSpan(paramAnonymousString, i, i + 3, 33);
              bn.this.ApO.setText(this.ApT);
            }
            AppMethodBeat.o(99717);
          }
          
          public final void dRW() {}
          
          public final void dRX() {}
        });
      }
      ((SpannableString)localObject2).setSpan(localObject1, i, i + 3, 33);
      this.ApO.setText((CharSequence)localObject2);
      if ((parama == null) || (bt.isNullOrNil(parama.zuH))) {
        break label485;
      }
      this.ApQ.setVisibility(0);
      label305:
      if (paramb != null)
      {
        if (!"zh_CN".equals(this.uZv)) {
          break label497;
        }
        paramb = paramb.zvK;
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramb)) {
        this.ApN.setText(paramb);
      }
      AppMethodBeat.o(99722);
      return;
      if (("zh_TW".equals(this.uZv)) || ("zh_HK".equals(this.uZv)))
      {
        localObject1 = paramb.zvD;
        break;
      }
      localObject1 = paramb.zvC;
      break;
      label389:
      localObject1 = localContext.getResources().getDrawable(2131689523);
      break label183;
      label404:
      if (al.isDarkMode()) {}
      for (localObject1 = localContext.getResources().getDrawable(2131689525);; localObject1 = localContext.getResources().getDrawable(2131689526))
      {
        ((Drawable)localObject1).setBounds(0, 0, (int)(this.ApO.getTextSize() * 0.8D), (int)(this.ApO.getTextSize() * 0.8D));
        localObject1 = new ImageSpan((Drawable)localObject1, 1);
        break;
      }
      label485:
      this.ApQ.setVisibility(8);
      break label305;
      label497:
      if (("zh_TW".equals(this.uZv)) || ("zh_HK".equals(this.uZv))) {
        paramb = paramb.zvM;
      } else {
        paramb = paramb.zvL;
      }
    }
  }
  
  public final String edM()
  {
    if (this.ApS == null) {
      return "";
    }
    if (this.ApS.dFy == null) {
      return "";
    }
    return this.ApS.dFy;
  }
  
  public final int[] edN()
  {
    AppMethodBeat.i(99718);
    int[] arrayOfInt = new int[2];
    if (this.ApM != null)
    {
      this.ApP.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] += this.ApP.getMeasuredWidth() + com.tencent.mm.cc.a.fromDPToPix(this.ApP.getContext(), 5);
    }
    for (;;)
    {
      AppMethodBeat.o(99718);
      return arrayOfInt;
      if (this.ApP != null)
      {
        this.ApP.getLocationInWindow(arrayOfInt);
        arrayOfInt[0] += this.ApP.getMeasuredWidth() + com.tencent.mm.cc.a.fromDPToPix(this.ApP.getContext(), 5);
      }
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(99723);
    com.tencent.mm.storage.a locala;
    if ((this.ApR != null) && (this.ApR.zvy == 1))
    {
      this.ApO.setVisibility(8);
      locala = d.aDt().aSj("Sns_CanvasAd_DetailLink_JumpWay");
      if (!locala.isValid()) {
        break label202;
      }
    }
    label202:
    for (int i = bt.getInt(locala.field_value, -1);; i = -1)
    {
      if ((i != -1) && (this.ApR != null) && (this.ApR.dVU()) && (i.azV(this.ApR.dBS))) {
        this.ApO.setVisibility(paramInt);
      }
      this.ApN.setVisibility(paramInt);
      if (this.ApP != null) {
        this.ApP.setVisibility(paramInt);
      }
      if (this.ApM != null) {
        this.ApM.setVisibility(paramInt);
      }
      if ((this.ApS != null) && (!bt.isNullOrNil(this.ApS.zuH)))
      {
        this.ApQ.setVisibility(paramInt);
        AppMethodBeat.o(99723);
        return;
        this.ApO.setVisibility(paramInt);
        break;
      }
      this.ApQ.setVisibility(8);
      AppMethodBeat.o(99723);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bn
 * JD-Core Version:    0.7.0.1
 */