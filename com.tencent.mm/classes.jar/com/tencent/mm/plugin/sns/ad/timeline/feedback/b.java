package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.ad.timeline.feedback.a.c;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class b
  implements View.OnClickListener
{
  private WeImageView JHT;
  private WeImageView JHU;
  private TextView JHV;
  private View JHW;
  private View JHX;
  private WeImageView JHY;
  private View JHZ;
  private WeImageView JIa;
  private View JIb;
  private TextView JIc;
  private WeImageView JId;
  private View JIe;
  ViewGroup JIf;
  View JIg;
  private TextView JIh;
  c JIi;
  private b JIj;
  private Context mContext;
  private View mrI;
  private TextView wB;
  
  b(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    this.JIj = paramb;
    this.JIi = paramc;
  }
  
  private e fLr()
  {
    AppMethodBeat.i(195136);
    Object localObject = this.JIj.aYG("unlike_tag").get("unlike_tag");
    if ((localObject instanceof e))
    {
      localObject = (e)localObject;
      AppMethodBeat.o(195136);
      return localObject;
    }
    AppMethodBeat.o(195136);
    return null;
  }
  
  public final void aeR(int paramInt)
  {
    AppMethodBeat.i(195140);
    if ((this.JHT != null) && (this.JHU != null))
    {
      if (paramInt < 0)
      {
        this.JHT.setVisibility(8);
        this.JHU.setVisibility(0);
        AppMethodBeat.o(195140);
        return;
      }
      this.JHT.setVisibility(0);
      this.JHU.setVisibility(8);
    }
    AppMethodBeat.o(195140);
  }
  
  public final void ge(View paramView)
  {
    AppMethodBeat.i(195121);
    this.mrI = paramView;
    this.JHT = ((WeImageView)this.mrI.findViewById(i.f.sns_ad_top_arrow));
    this.JHU = ((WeImageView)this.mrI.findViewById(i.f.sns_ad_bottom_arrow));
    this.JHV = ((TextView)this.mrI.findViewById(i.f.sns_ad_feedback_special_title));
    this.JHW = this.mrI.findViewById(i.f.sns_ad_feedback_content_root_view);
    this.JIb = this.mrI.findViewById(i.f.sns_ad_feedback_complaint_layout);
    this.JIc = ((TextView)this.mrI.findViewById(i.f.sns_ad_feedback_complaint_prompt));
    this.JId = ((WeImageView)this.mrI.findViewById(i.f.sns_ad_feedback_complaint_arrow));
    this.JIe = this.mrI.findViewById(i.f.sns_ad_feedback_first_page_layout);
    this.JHZ = this.mrI.findViewById(i.f.sns_ad_feedback_no_interest_layout);
    this.JIa = ((WeImageView)this.mrI.findViewById(i.f.sns_ad_feedback_no_interest_image));
    this.JHX = this.mrI.findViewById(i.f.sns_ad_feedback_approve_layout);
    this.JHY = ((WeImageView)this.mrI.findViewById(i.f.sns_ad_feedback_approve_image));
    this.JIf = ((ViewGroup)this.mrI.findViewById(i.f.sns_ad_feedback_dynamic_container));
    this.JIg = this.mrI.findViewById(i.f.sns_ad_feedback_confirm_btn);
    this.wB = ((TextView)this.mrI.findViewById(i.f.sns_ad_feedback_title));
    this.JIh = ((TextView)this.mrI.findViewById(i.f.sns_ad_feedback_subtitle));
    if (this.JHT != null) {
      this.JHT.setImageResource(i.i.sns_ad_feedback_trangle);
    }
    if (this.JHU != null)
    {
      this.JHU.setImageResource(i.i.sns_ad_feedback_trangle);
      this.JHU.setRotation(180.0F);
    }
    if (this.wB != null)
    {
      paramView = this.JIj;
      if (paramView != null)
      {
        paramView = paramView.aYG("expand_title");
        if (d.aC(paramView))
        {
          paramView = paramView.get("expand_title");
          if ((paramView instanceof CharSequence)) {
            this.wB.setText((CharSequence)paramView);
          }
        }
      }
    }
    if (this.JIa != null) {
      this.JIa.setImageResource(i.i.sns_ad_feedback_no_interesting);
    }
    if (this.JHY != null) {
      this.JHY.setImageResource(i.i.sns_ad_feedback_approve);
    }
    if (this.JId != null) {
      this.JId.setImageResource(i.i.sns_ad_feedback_right_arrow);
    }
    if (this.JHZ != null) {
      this.JHZ.setOnClickListener(this);
    }
    if (this.JHX != null) {
      this.JHX.setOnClickListener(this);
    }
    if (this.JIb != null) {
      this.JIb.setOnClickListener(this);
    }
    if (this.JIg != null) {
      this.JIg.setOnClickListener(this);
    }
    if (this.JIf != null)
    {
      paramView = this.JIj;
      if (paramView == null) {
        break label931;
      }
      paramView = paramView.aYG("reason_list");
      if (!d.aC(paramView)) {
        break label931;
      }
      paramView = paramView.get("reason_list");
      if (!(paramView instanceof Collection)) {
        break label931;
      }
    }
    label931:
    for (paramView = (Collection)paramView;; paramView = null)
    {
      if (d.n(paramView))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext())
        {
          c localc = (c)paramView.next();
          Context localContext = this.mContext;
          String str = localc.JIB;
          TextView localTextView = new TextView(localContext);
          localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          localTextView.setSingleLine(true);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          localTextView.setBackgroundResource(i.e.sns_ad_feedback_text_bg_selector);
          localTextView.setTextColor(this.mContext.getResources().getColorStateList(i.c.sns_ad_feedback_text_front_selector));
          int i = com.tencent.mm.ci.a.fromDPToPix(localContext, 12);
          int j = com.tencent.mm.ci.a.fromDPToPix(localContext, 8);
          localTextView.setPadding(i, j, i, j);
          localTextView.setTextSize(2, 14.0F);
          localTextView.setText(str);
          localTextView.setOnClickListener(new a());
          localTextView.setTag(i.f.sns_ad_feed_no_interest_reason_key, localc);
          this.JIf.addView(localTextView);
        }
      }
      paramView = this.JIj;
      if (paramView != null)
      {
        paramView = paramView.aYG("is_special");
        if (d.aC(paramView))
        {
          paramView = paramView.get("is_special");
          if (!(paramView instanceof Boolean)) {}
        }
      }
      for (boolean bool = ((Boolean)paramView).booleanValue();; bool = true)
      {
        if (bool)
        {
          this.JHW.setVisibility(8);
          this.JHV.setVisibility(0);
          paramView = this.JIj;
          if (paramView != null)
          {
            paramView = paramView.aYG("special_prompt");
            if (d.aC(paramView))
            {
              paramView = paramView.get("special_prompt");
              if ((paramView instanceof CharSequence)) {
                this.JHV.setText((CharSequence)paramView);
              }
            }
          }
        }
        if (this.JIc != null)
        {
          paramView = this.JIj;
          if (paramView != null)
          {
            paramView = paramView.aYG("complaint_content");
            if (d.aC(paramView))
            {
              paramView = paramView.get("complaint_content");
              if (((paramView instanceof CharSequence)) && (!TextUtils.isEmpty((CharSequence)paramView))) {
                this.JIc.setText((CharSequence)paramView);
              }
            }
          }
        }
        AppMethodBeat.o(195121);
        return;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195131);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i = paramView.getId();
    if (i == i.f.sns_ad_feedback_no_interest_layout)
    {
      if ((this.JIf != null) && (this.JIf.getChildCount() > 0))
      {
        this.JIf.setVisibility(0);
        if (this.JIe != null) {
          this.JIe.setVisibility(8);
        }
        if (this.wB != null)
        {
          this.wB.setTextColor(com.tencent.mm.ci.a.w(this.wB.getContext(), i.c.sns_ad_new_feedback_text_normal_color));
          this.wB.setText(i.j.sns_ad_new_feedback_select_reason);
        }
        if (this.JIh != null)
        {
          this.JIh.setTextColor(com.tencent.mm.ci.a.w(this.JIh.getContext(), i.c.sns_ad_new_feedback_text_gray_color));
          this.JIh.setText(this.JIh.getContext().getString(i.j.sns_ad_new_feedback_subtitle));
        }
      }
      if (this.JIi != null)
      {
        localObject = fLr();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.JIi.a(paramView, 1, null);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195131);
      return;
      if (i == i.f.sns_ad_feedback_approve_layout)
      {
        if (this.JIi != null) {
          this.JIi.a(paramView, 2, null);
        }
      }
      else if (i == i.f.sns_ad_feedback_complaint_layout)
      {
        if (this.JIi != null) {
          this.JIi.a(paramView, 3, null);
        }
      }
      else if ((i == i.f.sns_ad_feedback_confirm_btn) && (this.JIi != null))
      {
        localObject = fLr();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.JIi.a(paramView, 4, null);
      }
    }
  }
  
  final class a
    implements View.OnClickListener
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(246783);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (paramView != null) {}
      try
      {
        if (paramView.isSelected()) {
          break label171;
        }
        bool = true;
        paramView.setSelected(bool);
        if (b.this.JIg == null) {
          break label123;
        }
        localObject = b.this.JIf;
        if (localObject == null) {
          break label203;
        }
        int j = ((ViewGroup)localObject).getChildCount();
        i = 0;
        label89:
        if (i >= j) {
          break label203;
        }
        if (!((ViewGroup)localObject).getChildAt(i).isSelected()) {
          break label177;
        }
        i = 1;
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          boolean bool;
          label123:
          continue;
          label171:
          label177:
          int i = 0;
        }
      }
      if (i != 0) {
        b.this.JIg.setVisibility(0);
      }
      for (;;)
      {
        localObject = b.this.JIi;
        if (localObject != null) {
          ((b.c)localObject).a(paramView, 5, paramView.getTag(i.f.sns_ad_feed_no_interest_reason_key));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246783);
        return;
        bool = false;
        break;
        i += 1;
        break label89;
        b.this.JIg.setVisibility(8);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract Map<String, Object> aYG(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.b
 * JD-Core Version:    0.7.0.1
 */