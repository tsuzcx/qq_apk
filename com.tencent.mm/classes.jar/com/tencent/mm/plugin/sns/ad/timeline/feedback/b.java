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
import com.tencent.mm.plugin.sns.ad.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class b
  implements View.OnClickListener
{
  private TextView ayB;
  private View iFK;
  private Context mContext;
  private WeImageView zqY;
  private WeImageView zqZ;
  private TextView zra;
  private View zrb;
  private View zrc;
  private WeImageView zrd;
  private View zre;
  private WeImageView zrf;
  private View zrg;
  private WeImageView zrh;
  private View zri;
  ViewGroup zrj;
  View zrk;
  private TextView zrl;
  c zrm;
  private b zrn;
  
  b(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    this.zrn = paramb;
    this.zrm = paramc;
  }
  
  private com.tencent.mm.plugin.sns.data.b dVk()
  {
    AppMethodBeat.i(219091);
    Object localObject = this.zrn.ayW("unlike_tag").get("unlike_tag");
    if ((localObject instanceof com.tencent.mm.plugin.sns.data.b))
    {
      localObject = (com.tencent.mm.plugin.sns.data.b)localObject;
      AppMethodBeat.o(219091);
      return localObject;
    }
    AppMethodBeat.o(219091);
    return null;
  }
  
  public final void Qh(int paramInt)
  {
    AppMethodBeat.i(219092);
    if ((this.zqY != null) && (this.zqZ != null))
    {
      if (paramInt < 0)
      {
        this.zqY.setVisibility(8);
        this.zqZ.setVisibility(0);
        AppMethodBeat.o(219092);
        return;
      }
      this.zqY.setVisibility(0);
      this.zqZ.setVisibility(8);
    }
    AppMethodBeat.o(219092);
  }
  
  public final void eM(View paramView)
  {
    AppMethodBeat.i(219089);
    this.iFK = paramView;
    this.zqY = ((WeImageView)this.iFK.findViewById(2131308002));
    this.zqZ = ((WeImageView)this.iFK.findViewById(2131307982));
    this.zra = ((TextView)this.iFK.findViewById(2131307999));
    this.zrb = this.iFK.findViewById(2131307992);
    this.zrg = this.iFK.findViewById(2131307988);
    this.zrh = ((WeImageView)this.iFK.findViewById(2131307987));
    this.zri = this.iFK.findViewById(2131307994);
    this.zre = this.iFK.findViewById(2131307997);
    this.zrf = ((WeImageView)this.iFK.findViewById(2131307996));
    this.zrc = this.iFK.findViewById(2131307986);
    this.zrd = ((WeImageView)this.iFK.findViewById(2131307985));
    this.zrj = ((ViewGroup)this.iFK.findViewById(2131307993));
    this.zrk = this.iFK.findViewById(2131307990);
    this.ayB = ((TextView)this.iFK.findViewById(2131308001));
    this.zrl = ((TextView)this.iFK.findViewById(2131308000));
    if (this.zqY != null) {
      this.zqY.setImageResource(2131691560);
    }
    if (this.zqZ != null)
    {
      this.zqZ.setImageResource(2131691560);
      this.zqZ.setRotation(180.0F);
    }
    if (this.ayB != null)
    {
      paramView = this.zrn;
      if (paramView != null)
      {
        paramView = paramView.ayW("expand_title");
        if (c.aJ(paramView))
        {
          paramView = paramView.get("expand_title");
          if ((paramView instanceof CharSequence)) {
            this.ayB.setText((CharSequence)paramView);
          }
        }
      }
    }
    if (this.zrf != null) {
      this.zrf.setImageResource(2131691558);
    }
    if (this.zrd != null) {
      this.zrd.setImageResource(2131691557);
    }
    if (this.zrh != null) {
      this.zrh.setImageResource(2131691559);
    }
    if (this.zre != null) {
      this.zre.setOnClickListener(this);
    }
    if (this.zrc != null) {
      this.zrc.setOnClickListener(this);
    }
    if (this.zrg != null) {
      this.zrg.setOnClickListener(this);
    }
    if (this.zrk != null) {
      this.zrk.setOnClickListener(this);
    }
    if (this.zrj != null)
    {
      paramView = this.zrn;
      if (paramView == null) {
        break label821;
      }
      paramView = paramView.ayW("reason_list");
      if (!c.aJ(paramView)) {
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
      if (c.m(paramView))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext())
        {
          d locald = (d)paramView.next();
          Context localContext = this.mContext;
          String str = locald.zrq;
          TextView localTextView = new TextView(localContext);
          localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          localTextView.setSingleLine(true);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          localTextView.setBackgroundResource(2131234964);
          localTextView.setTextColor(this.mContext.getResources().getColorStateList(2131101213));
          int i = com.tencent.mm.cb.a.fromDPToPix(localContext, 12);
          int j = com.tencent.mm.cb.a.fromDPToPix(localContext, 8);
          localTextView.setPadding(i, j, i, j);
          localTextView.setTextSize(2, 14.0F);
          localTextView.setText(str);
          localTextView.setOnClickListener(new a());
          localTextView.setTag(2131307983, locald);
          this.zrj.addView(localTextView);
        }
      }
      paramView = this.zrn;
      if (paramView != null)
      {
        paramView = paramView.ayW("is_special");
        if (c.aJ(paramView))
        {
          paramView = paramView.get("is_special");
          if (!(paramView instanceof Boolean)) {}
        }
      }
      for (boolean bool = ((Boolean)paramView).booleanValue();; bool = true)
      {
        if (bool)
        {
          this.zrb.setVisibility(8);
          this.zra.setVisibility(0);
          paramView = this.zrn;
          if (paramView != null)
          {
            paramView = paramView.ayW("special_prompt");
            if (c.aJ(paramView))
            {
              paramView = paramView.get("special_prompt");
              if ((paramView instanceof CharSequence)) {
                this.zra.setText((CharSequence)paramView);
              }
            }
          }
        }
        AppMethodBeat.o(219089);
        return;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(219090);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    int i = paramView.getId();
    if (i == 2131307997)
    {
      if ((this.zrj != null) && (this.zrj.getChildCount() > 0))
      {
        this.zrj.setVisibility(0);
        if (this.zri != null) {
          this.zri.setVisibility(8);
        }
        if (this.ayB != null)
        {
          this.ayB.setTextColor(com.tencent.mm.cb.a.n(this.ayB.getContext(), 2131101219));
          this.ayB.setText(2131766818);
        }
        if (this.zrl != null)
        {
          this.zrl.setTextColor(com.tencent.mm.cb.a.n(this.zrl.getContext(), 2131101217));
          this.zrl.setText(this.zrl.getContext().getString(2131766819));
        }
      }
      if (this.zrm != null)
      {
        localObject = dVk();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.zrm.a(paramView, 1, null);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(219090);
      return;
      if (i == 2131307986)
      {
        if (this.zrm != null) {
          this.zrm.a(paramView, 2, null);
        }
      }
      else if (i == 2131307988)
      {
        if (this.zrm != null) {
          this.zrm.a(paramView, 3, null);
        }
      }
      else if ((i == 2131307990) && (this.zrm != null))
      {
        localObject = dVk();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.zrm.a(paramView, 4, null);
      }
    }
  }
  
  final class a
    implements View.OnClickListener
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(219088);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      try
      {
        localObject = b.this.zrj;
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
        if (b.this.zrk != null) {
          b.this.zrk.setVisibility(0);
        }
        localObject = b.this.zrm;
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
      AppMethodBeat.o(219088);
    }
  }
  
  public static abstract interface b
  {
    public abstract Map<String, Object> ayW(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, int paramInt, Object paramObject);
  }
  
  public static final class d
  {
    public final int zrp;
    public final String zrq;
    
    d(int paramInt, String paramString)
    {
      this.zrp = paramInt;
      this.zrq = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.b
 * JD-Core Version:    0.7.0.1
 */