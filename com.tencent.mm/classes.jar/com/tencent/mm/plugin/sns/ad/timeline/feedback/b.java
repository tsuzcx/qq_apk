package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class b
  implements View.OnClickListener
{
  private TextView ayB;
  private View iCR;
  private Context mContext;
  private View zaA;
  private View zaB;
  private WeImageView zaC;
  private View zaD;
  private WeImageView zaE;
  private View zaF;
  private WeImageView zaG;
  private View zaH;
  ViewGroup zaI;
  View zaJ;
  private TextView zaK;
  c zaL;
  private b zaM;
  private WeImageView zax;
  private WeImageView zay;
  private TextView zaz;
  
  b(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    this.zaM = paramb;
    this.zaL = paramc;
  }
  
  private com.tencent.mm.plugin.sns.data.b dRM()
  {
    AppMethodBeat.i(197625);
    Object localObject = this.zaM.axE("unlike_tag").get("unlike_tag");
    if ((localObject instanceof com.tencent.mm.plugin.sns.data.b))
    {
      localObject = (com.tencent.mm.plugin.sns.data.b)localObject;
      AppMethodBeat.o(197625);
      return localObject;
    }
    AppMethodBeat.o(197625);
    return null;
  }
  
  public final void PA(int paramInt)
  {
    AppMethodBeat.i(197626);
    if ((this.zax != null) && (this.zay != null))
    {
      if (paramInt < 0)
      {
        this.zax.setVisibility(8);
        this.zay.setVisibility(0);
        AppMethodBeat.o(197626);
        return;
      }
      this.zax.setVisibility(0);
      this.zay.setVisibility(8);
    }
    AppMethodBeat.o(197626);
  }
  
  public final void eM(View paramView)
  {
    AppMethodBeat.i(197623);
    this.iCR = paramView;
    this.zax = ((WeImageView)this.iCR.findViewById(2131308002));
    this.zay = ((WeImageView)this.iCR.findViewById(2131307982));
    this.zaz = ((TextView)this.iCR.findViewById(2131307999));
    this.zaA = this.iCR.findViewById(2131307992);
    this.zaF = this.iCR.findViewById(2131307988);
    this.zaG = ((WeImageView)this.iCR.findViewById(2131307987));
    this.zaH = this.iCR.findViewById(2131307994);
    this.zaD = this.iCR.findViewById(2131307997);
    this.zaE = ((WeImageView)this.iCR.findViewById(2131307996));
    this.zaB = this.iCR.findViewById(2131307986);
    this.zaC = ((WeImageView)this.iCR.findViewById(2131307985));
    this.zaI = ((ViewGroup)this.iCR.findViewById(2131307993));
    this.zaJ = this.iCR.findViewById(2131307990);
    this.ayB = ((TextView)this.iCR.findViewById(2131308001));
    this.zaK = ((TextView)this.iCR.findViewById(2131308000));
    if (this.zax != null) {
      this.zax.setImageResource(2131691560);
    }
    if (this.zay != null)
    {
      this.zay.setImageResource(2131691560);
      this.zay.setRotation(180.0F);
    }
    if (this.ayB != null)
    {
      paramView = this.zaM;
      if (paramView != null)
      {
        paramView = paramView.axE("expand_title");
        if (com.tencent.mm.plugin.sns.ad.e.b.aD(paramView))
        {
          paramView = paramView.get("expand_title");
          if ((paramView instanceof CharSequence)) {
            this.ayB.setText((CharSequence)paramView);
          }
        }
      }
    }
    if (this.zaE != null) {
      this.zaE.setImageResource(2131691558);
    }
    if (this.zaC != null) {
      this.zaC.setImageResource(2131691557);
    }
    if (this.zaG != null) {
      this.zaG.setImageResource(2131691559);
    }
    if (this.zaD != null) {
      this.zaD.setOnClickListener(this);
    }
    if (this.zaB != null) {
      this.zaB.setOnClickListener(this);
    }
    if (this.zaF != null) {
      this.zaF.setOnClickListener(this);
    }
    if (this.zaJ != null) {
      this.zaJ.setOnClickListener(this);
    }
    if (this.zaI != null)
    {
      paramView = this.zaM;
      if (paramView == null) {
        break label821;
      }
      paramView = paramView.axE("reason_list");
      if (!com.tencent.mm.plugin.sns.ad.e.b.aD(paramView)) {
        break label821;
      }
      paramView = paramView.get("reason_list");
      if (!(paramView instanceof Collection)) {
        break label821;
      }
    }
    label821:
    for (paramView = (Collection)paramView;; paramView = null)
    {
      if (com.tencent.mm.plugin.sns.ad.e.b.m(paramView))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext())
        {
          d locald = (d)paramView.next();
          Context localContext = this.mContext;
          String str = locald.zaP;
          TextView localTextView = new TextView(localContext);
          localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          localTextView.setSingleLine(true);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          localTextView.setBackgroundResource(2131234964);
          localTextView.setTextColor(this.mContext.getResources().getColorStateList(2131101213));
          int i = com.tencent.mm.cc.a.fromDPToPix(localContext, 12);
          int j = com.tencent.mm.cc.a.fromDPToPix(localContext, 8);
          localTextView.setPadding(i, j, i, j);
          localTextView.setTextSize(2, 14.0F);
          localTextView.setText(str);
          localTextView.setOnClickListener(new a());
          localTextView.setTag(2131307983, locald);
          this.zaI.addView(localTextView);
        }
      }
      paramView = this.zaM;
      if (paramView != null)
      {
        paramView = paramView.axE("is_special");
        if (com.tencent.mm.plugin.sns.ad.e.b.aD(paramView))
        {
          paramView = paramView.get("is_special");
          if (!(paramView instanceof Boolean)) {}
        }
      }
      for (boolean bool = ((Boolean)paramView).booleanValue();; bool = true)
      {
        if (bool)
        {
          this.zaA.setVisibility(8);
          this.zaz.setVisibility(0);
          paramView = this.zaM;
          if (paramView != null)
          {
            paramView = paramView.axE("special_prompt");
            if (com.tencent.mm.plugin.sns.ad.e.b.aD(paramView))
            {
              paramView = paramView.get("special_prompt");
              if ((paramView instanceof CharSequence)) {
                this.zaz.setText((CharSequence)paramView);
              }
            }
          }
        }
        AppMethodBeat.o(197623);
        return;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197624);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    int i = paramView.getId();
    if (i == 2131307997)
    {
      if ((this.zaI != null) && (this.zaI.getChildCount() > 0))
      {
        this.zaI.setVisibility(0);
        if (this.zaH != null) {
          this.zaH.setVisibility(8);
        }
        if (this.ayB != null)
        {
          this.ayB.setTextColor(com.tencent.mm.cc.a.n(this.ayB.getContext(), 2131101219));
          this.ayB.setText(2131766818);
        }
        if (this.zaK != null)
        {
          this.zaK.setTextColor(com.tencent.mm.cc.a.n(this.zaK.getContext(), 2131101217));
          this.zaK.setText(this.zaK.getContext().getString(2131766819));
        }
      }
      if (this.zaL != null)
      {
        localObject = dRM();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.zaL.a(paramView, 1, null);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(197624);
      return;
      if (i == 2131307986)
      {
        if (this.zaL != null) {
          this.zaL.a(paramView, 2, null);
        }
      }
      else if (i == 2131307988)
      {
        if (this.zaL != null) {
          this.zaL.a(paramView, 3, null);
        }
      }
      else if ((i == 2131307990) && (this.zaL != null))
      {
        localObject = dRM();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.zaL.a(paramView, 4, null);
      }
    }
  }
  
  final class a
    implements View.OnClickListener
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197622);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      try
      {
        localObject = b.this.zaI;
        if (localObject != null)
        {
          int j = ((ViewGroup)localObject).getChildCount();
          int i = 0;
          while (i < j)
          {
            ((ViewGroup)localObject).getChildAt(i).setSelected(false);
            i += 1;
          }
        }
        paramView.setSelected(true);
        if (b.this.zaJ != null) {
          b.this.zaJ.setVisibility(0);
        }
        localObject = b.this.zaL;
        if (localObject != null) {
          ((b.c)localObject).a(paramView, 5, paramView.getTag(2131307983));
        }
      }
      catch (Throwable paramView)
      {
        label136:
        break label136;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(197622);
    }
  }
  
  public static abstract interface b
  {
    public abstract Map<String, Object> axE(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, int paramInt, Object paramObject);
  }
  
  public static final class d
  {
    public final int zaO;
    public final String zaP;
    
    d(int paramInt, String paramString)
    {
      this.zaO = paramInt;
      this.zaP = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.b
 * JD-Core Version:    0.7.0.1
 */