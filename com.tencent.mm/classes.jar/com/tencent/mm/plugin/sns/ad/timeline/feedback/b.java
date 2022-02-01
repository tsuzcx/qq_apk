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
  private WeImageView DxZ;
  private WeImageView Dya;
  private TextView Dyb;
  private View Dyc;
  private View Dyd;
  private WeImageView Dye;
  private View Dyf;
  private WeImageView Dyg;
  private View Dyh;
  private WeImageView Dyi;
  private View Dyj;
  ViewGroup Dyk;
  View Dyl;
  private TextView Dym;
  c Dyn;
  private b Dyo;
  private TextView ayz;
  private View jBN;
  private Context mContext;
  
  b(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    this.Dyo = paramb;
    this.Dyn = paramc;
  }
  
  private com.tencent.mm.plugin.sns.data.c eXO()
  {
    AppMethodBeat.i(202169);
    Object localObject = this.Dyo.aNQ("unlike_tag").get("unlike_tag");
    if ((localObject instanceof com.tencent.mm.plugin.sns.data.c))
    {
      localObject = (com.tencent.mm.plugin.sns.data.c)localObject;
      AppMethodBeat.o(202169);
      return localObject;
    }
    AppMethodBeat.o(202169);
    return null;
  }
  
  public final void XM(int paramInt)
  {
    AppMethodBeat.i(202170);
    if ((this.DxZ != null) && (this.Dya != null))
    {
      if (paramInt < 0)
      {
        this.DxZ.setVisibility(8);
        this.Dya.setVisibility(0);
        AppMethodBeat.o(202170);
        return;
      }
      this.DxZ.setVisibility(0);
      this.Dya.setVisibility(8);
    }
    AppMethodBeat.o(202170);
  }
  
  public final void eY(View paramView)
  {
    AppMethodBeat.i(202167);
    this.jBN = paramView;
    this.DxZ = ((WeImageView)this.jBN.findViewById(2131308066));
    this.Dya = ((WeImageView)this.jBN.findViewById(2131307975));
    this.Dyb = ((TextView)this.jBN.findViewById(2131308004));
    this.Dyc = this.jBN.findViewById(2131307997);
    this.Dyh = this.jBN.findViewById(2131307993);
    this.Dyi = ((WeImageView)this.jBN.findViewById(2131307992));
    this.Dyj = this.jBN.findViewById(2131307999);
    this.Dyf = this.jBN.findViewById(2131308002);
    this.Dyg = ((WeImageView)this.jBN.findViewById(2131308001));
    this.Dyd = this.jBN.findViewById(2131307991);
    this.Dye = ((WeImageView)this.jBN.findViewById(2131307990));
    this.Dyk = ((ViewGroup)this.jBN.findViewById(2131307998));
    this.Dyl = this.jBN.findViewById(2131307995);
    this.ayz = ((TextView)this.jBN.findViewById(2131308006));
    this.Dym = ((TextView)this.jBN.findViewById(2131308005));
    if (this.DxZ != null) {
      this.DxZ.setImageResource(2131691507);
    }
    if (this.Dya != null)
    {
      this.Dya.setImageResource(2131691507);
      this.Dya.setRotation(180.0F);
    }
    if (this.ayz != null)
    {
      paramView = this.Dyo;
      if (paramView != null)
      {
        paramView = paramView.aNQ("expand_title");
        if (com.tencent.mm.plugin.sns.ad.i.c.aI(paramView))
        {
          paramView = paramView.get("expand_title");
          if ((paramView instanceof CharSequence)) {
            this.ayz.setText((CharSequence)paramView);
          }
        }
      }
    }
    if (this.Dyg != null) {
      this.Dyg.setImageResource(2131691505);
    }
    if (this.Dye != null) {
      this.Dye.setImageResource(2131691504);
    }
    if (this.Dyi != null) {
      this.Dyi.setImageResource(2131691506);
    }
    if (this.Dyf != null) {
      this.Dyf.setOnClickListener(this);
    }
    if (this.Dyd != null) {
      this.Dyd.setOnClickListener(this);
    }
    if (this.Dyh != null) {
      this.Dyh.setOnClickListener(this);
    }
    if (this.Dyl != null) {
      this.Dyl.setOnClickListener(this);
    }
    if (this.Dyk != null)
    {
      paramView = this.Dyo;
      if (paramView == null) {
        break label821;
      }
      paramView = paramView.aNQ("reason_list");
      if (!com.tencent.mm.plugin.sns.ad.i.c.aI(paramView)) {
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
      if (com.tencent.mm.plugin.sns.ad.i.c.o(paramView))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext())
        {
          d locald = (d)paramView.next();
          Context localContext = this.mContext;
          String str = locald.Dyr;
          TextView localTextView = new TextView(localContext);
          localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          localTextView.setSingleLine(true);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          localTextView.setBackgroundResource(2131234938);
          localTextView.setTextColor(this.mContext.getResources().getColorStateList(2131101095));
          int i = com.tencent.mm.cb.a.fromDPToPix(localContext, 12);
          int j = com.tencent.mm.cb.a.fromDPToPix(localContext, 8);
          localTextView.setPadding(i, j, i, j);
          localTextView.setTextSize(2, 14.0F);
          localTextView.setText(str);
          localTextView.setOnClickListener(new a());
          localTextView.setTag(2131307988, locald);
          this.Dyk.addView(localTextView);
        }
      }
      paramView = this.Dyo;
      if (paramView != null)
      {
        paramView = paramView.aNQ("is_special");
        if (com.tencent.mm.plugin.sns.ad.i.c.aI(paramView))
        {
          paramView = paramView.get("is_special");
          if (!(paramView instanceof Boolean)) {}
        }
      }
      for (boolean bool = ((Boolean)paramView).booleanValue();; bool = true)
      {
        if (bool)
        {
          this.Dyc.setVisibility(8);
          this.Dyb.setVisibility(0);
          paramView = this.Dyo;
          if (paramView != null)
          {
            paramView = paramView.aNQ("special_prompt");
            if (com.tencent.mm.plugin.sns.ad.i.c.aI(paramView))
            {
              paramView = paramView.get("special_prompt");
              if ((paramView instanceof CharSequence)) {
                this.Dyb.setText((CharSequence)paramView);
              }
            }
          }
        }
        AppMethodBeat.o(202167);
        return;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(202168);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    int i = paramView.getId();
    if (i == 2131308002)
    {
      if ((this.Dyk != null) && (this.Dyk.getChildCount() > 0))
      {
        this.Dyk.setVisibility(0);
        if (this.Dyj != null) {
          this.Dyj.setVisibility(8);
        }
        if (this.ayz != null)
        {
          this.ayz.setTextColor(com.tencent.mm.cb.a.n(this.ayz.getContext(), 2131101110));
          this.ayz.setText(2131765976);
        }
        if (this.Dym != null)
        {
          this.Dym.setTextColor(com.tencent.mm.cb.a.n(this.Dym.getContext(), 2131101108));
          this.Dym.setText(this.Dym.getContext().getString(2131765977));
        }
      }
      if (this.Dyn != null)
      {
        localObject = eXO();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.Dyn.a(paramView, 1, null);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202168);
      return;
      if (i == 2131307991)
      {
        if (this.Dyn != null) {
          this.Dyn.a(paramView, 2, null);
        }
      }
      else if (i == 2131307993)
      {
        if (this.Dyn != null) {
          this.Dyn.a(paramView, 3, null);
        }
      }
      else if ((i == 2131307995) && (this.Dyn != null))
      {
        localObject = eXO();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.Dyn.a(paramView, 4, null);
      }
    }
  }
  
  final class a
    implements View.OnClickListener
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202166);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      try
      {
        localObject = b.this.Dyk;
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
        if (b.this.Dyl != null) {
          b.this.Dyl.setVisibility(0);
        }
        localObject = b.this.Dyn;
        if (localObject != null) {
          ((b.c)localObject).a(paramView, 5, paramView.getTag(2131307988));
        }
      }
      catch (Throwable paramView)
      {
        label136:
        break label136;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202166);
    }
  }
  
  public static abstract interface b
  {
    public abstract Map<String, Object> aNQ(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, int paramInt, Object paramObject);
  }
  
  public static final class d
  {
    public final int Dyq;
    public final String Dyr;
    
    d(int paramInt, String paramString)
    {
      this.Dyq = paramInt;
      this.Dyr = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.b
 * JD-Core Version:    0.7.0.1
 */