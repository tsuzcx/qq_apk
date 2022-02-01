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
import com.tencent.mm.ui.ai;

public final class bk
{
  private String sOz;
  private View view;
  private LinearLayout xLm;
  public TextView xLn;
  public TextView xLo;
  private View xLp;
  private View xLq;
  public com.tencent.mm.plugin.sns.storage.b xLr;
  public com.tencent.mm.plugin.sns.storage.a xLs;
  
  public bk(View paramView)
  {
    AppMethodBeat.i(99719);
    this.view = paramView;
    this.sOz = ac.ir(aj.getContext());
    ad.i("MicroMsg.TimeLineAdView", "adView init lan " + this.sOz);
    this.xLn = ((TextView)this.view.findViewById(2131296432));
    this.xLo = ((TextView)this.view.findViewById(2131296435));
    this.xLp = this.view.findViewById(2131296433);
    this.xLq = this.view.findViewById(2131296434);
    this.xLm = ((LinearLayout)this.view.findViewById(2131296431));
    paramView = " " + this.view.getResources().getString(2131763766) + " ";
    this.xLn.setText(paramView);
    AppMethodBeat.o(99719);
  }
  
  public final void F(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(99721);
    this.xLo.setTag(paramObject1);
    this.xLn.setTag(paramObject2);
    if (this.xLp != null) {
      this.xLp.setTag(paramObject2);
    }
    if (this.xLm != null) {
      this.xLm.setTag(paramObject2);
    }
    AppMethodBeat.o(99721);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(99720);
    this.xLo.setOnClickListener(paramOnClickListener1);
    this.xLn.setOnClickListener(paramOnClickListener2);
    if (this.xLp != null) {
      this.xLp.setOnClickListener(paramOnClickListener2);
    }
    if (this.xLm != null) {
      this.xLm.setOnClickListener(paramOnClickListener2);
    }
    AppMethodBeat.o(99720);
  }
  
  public final void a(com.tencent.mm.plugin.sns.storage.b paramb, com.tencent.mm.plugin.sns.storage.a parama)
  {
    AppMethodBeat.i(99722);
    this.xLs = parama;
    this.xLr = paramb;
    Object localObject1 = "";
    Context localContext;
    if (paramb != null)
    {
      if ("zh_CN".equals(this.sOz)) {
        localObject1 = paramb.wSP;
      }
    }
    else
    {
      Object localObject2 = localObject1;
      if (paramb != null)
      {
        localObject2 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject2 = paramb.wSN;
        }
      }
      localContext = this.xLo.getContext();
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = localContext.getString(2131763772);
      }
      localObject1 = (String)localObject1 + " ";
      final int i = ((String)localObject1).length();
      localObject2 = new SpannableString((String)localObject1 + "ad_");
      if ((parama == null) || (!parama.dvd())) {
        break label404;
      }
      if (!ai.Eq()) {
        break label389;
      }
      localObject1 = localContext.getResources().getDrawable(2131689524);
      label183:
      ((Drawable)localObject1).setBounds(0, 0, (int)(this.xLo.getTextSize() * 0.8D), (int)(this.xLo.getTextSize() * 0.8D));
      localObject1 = new ImageSpan((Drawable)localObject1, 1);
      if (!bt.isNullOrNil(paramb.wSO)) {
        h.c("adId", paramb.wSO, false, 41, new f.a()
        {
          public final void apm(String paramAnonymousString)
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
              paramAnonymousString.setBounds(0, 0, (int)(bk.this.xLo.getTextSize() * 1.3D), (int)(bk.this.xLo.getTextSize() * 1.3D));
              paramAnonymousString = new ImageSpan(paramAnonymousString, 0);
              this.xLt.setSpan(paramAnonymousString, i, i + 3, 33);
              bk.this.xLo.setText(this.xLt);
            }
            AppMethodBeat.o(99717);
          }
          
          public final void dsA() {}
          
          public final void duP() {}
        });
      }
      ((SpannableString)localObject2).setSpan(localObject1, i, i + 3, 33);
      this.xLo.setText((CharSequence)localObject2);
      if ((parama == null) || (bt.isNullOrNil(parama.wSa))) {
        break label485;
      }
      this.xLq.setVisibility(0);
      label305:
      if (paramb != null)
      {
        if (!"zh_CN".equals(this.sOz)) {
          break label497;
        }
        paramb = paramb.wSY;
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramb)) {
        this.xLn.setText(paramb);
      }
      AppMethodBeat.o(99722);
      return;
      if (("zh_TW".equals(this.sOz)) || ("zh_HK".equals(this.sOz)))
      {
        localObject1 = paramb.wSR;
        break;
      }
      localObject1 = paramb.wSQ;
      break;
      label389:
      localObject1 = localContext.getResources().getDrawable(2131689523);
      break label183;
      label404:
      if (ai.Eq()) {}
      for (localObject1 = localContext.getResources().getDrawable(2131689525);; localObject1 = localContext.getResources().getDrawable(2131689526))
      {
        ((Drawable)localObject1).setBounds(0, 0, (int)(this.xLo.getTextSize() * 0.8D), (int)(this.xLo.getTextSize() * 0.8D));
        localObject1 = new ImageSpan((Drawable)localObject1, 1);
        break;
      }
      label485:
      this.xLq.setVisibility(8);
      break label305;
      label497:
      if (("zh_TW".equals(this.sOz)) || ("zh_HK".equals(this.sOz))) {
        paramb = paramb.wTa;
      } else {
        paramb = paramb.wSZ;
      }
    }
  }
  
  public final String dCV()
  {
    if (this.xLs == null) {
      return "";
    }
    if (this.xLs.dvK == null) {
      return "";
    }
    return this.xLs.dvK;
  }
  
  public final int[] dCW()
  {
    AppMethodBeat.i(99718);
    int[] arrayOfInt = new int[2];
    if (this.xLm != null)
    {
      this.xLp.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] += this.xLp.getMeasuredWidth() + com.tencent.mm.cd.a.fromDPToPix(this.xLp.getContext(), 5);
    }
    for (;;)
    {
      AppMethodBeat.o(99718);
      return arrayOfInt;
      if (this.xLp != null)
      {
        this.xLp.getLocationInWindow(arrayOfInt);
        arrayOfInt[0] += this.xLp.getMeasuredWidth() + com.tencent.mm.cd.a.fromDPToPix(this.xLp.getContext(), 5);
      }
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(99723);
    com.tencent.mm.storage.a locala;
    if ((this.xLr != null) && (this.xLr.wSM == 1))
    {
      this.xLo.setVisibility(8);
      locala = d.atz().aHi("Sns_CanvasAd_DetailLink_JumpWay");
      if (!locala.isValid()) {
        break label202;
      }
    }
    label202:
    for (int i = bt.getInt(locala.field_value, -1);; i = -1)
    {
      if ((i != -1) && (this.xLr != null) && (this.xLr.dvh()) && (i.apF(this.xLr.dsv))) {
        this.xLo.setVisibility(paramInt);
      }
      this.xLn.setVisibility(paramInt);
      if (this.xLp != null) {
        this.xLp.setVisibility(paramInt);
      }
      if (this.xLm != null) {
        this.xLm.setVisibility(paramInt);
      }
      if ((this.xLs != null) && (!bt.isNullOrNil(this.xLs.wSa)))
      {
        this.xLq.setVisibility(paramInt);
        AppMethodBeat.o(99723);
        return;
        this.xLo.setVisibility(paramInt);
        break;
      }
      this.xLq.setVisibility(8);
      AppMethodBeat.o(99723);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bk
 * JD-Core Version:    0.7.0.1
 */