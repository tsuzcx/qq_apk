package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.timeline.feedback.a.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class b
  implements View.OnClickListener
{
  private WeImageView PYT;
  private WeImageView PYU;
  private TextView PYV;
  private View PYW;
  private View PYX;
  private WeImageView PYY;
  private View PYZ;
  private WeImageView PZa;
  private View PZb;
  private TextView PZc;
  private WeImageView PZd;
  private View PZe;
  ViewGroup PZf;
  View PZg;
  private TextView PZh;
  c PZi;
  private b PZj;
  private int PZk;
  private int PZl;
  private Context mContext;
  private View plc;
  private int titleMargin;
  private TextView xw;
  
  b(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    this.PZj = paramb;
    this.PZi = paramc;
  }
  
  private e hbJ()
  {
    AppMethodBeat.i(311024);
    Object localObject = this.PZj.aWK("unlike_tag");
    if (localObject != null)
    {
      localObject = ((Map)localObject).get("unlike_tag");
      if ((localObject instanceof e))
      {
        localObject = (e)localObject;
        AppMethodBeat.o(311024);
        return localObject;
      }
    }
    AppMethodBeat.o(311024);
    return null;
  }
  
  public final void ajz(int paramInt)
  {
    AppMethodBeat.i(311134);
    if ((this.PYT != null) && (this.PYU != null))
    {
      if (paramInt < 0)
      {
        this.PYT.setVisibility(8);
        this.PYU.setVisibility(0);
        AppMethodBeat.o(311134);
        return;
      }
      this.PYT.setVisibility(0);
      this.PYU.setVisibility(8);
    }
    AppMethodBeat.o(311134);
  }
  
  public final void jh(View paramView)
  {
    AppMethodBeat.i(311105);
    this.plc = paramView;
    this.PYT = ((WeImageView)this.plc.findViewById(b.f.sns_ad_top_arrow));
    this.PYU = ((WeImageView)this.plc.findViewById(b.f.sns_ad_bottom_arrow));
    this.PYV = ((TextView)this.plc.findViewById(b.f.sns_ad_feedback_special_title));
    this.PYW = this.plc.findViewById(b.f.sns_ad_feedback_content_root_view);
    this.PZb = this.plc.findViewById(b.f.sns_ad_feedback_complaint_layout);
    this.PZc = ((TextView)this.plc.findViewById(b.f.sns_ad_feedback_complaint_prompt));
    this.PZd = ((WeImageView)this.plc.findViewById(b.f.sns_ad_feedback_complaint_arrow));
    this.PZe = this.plc.findViewById(b.f.sns_ad_feedback_first_page_layout);
    this.PYZ = this.plc.findViewById(b.f.sns_ad_feedback_no_interest_layout);
    this.PZa = ((WeImageView)this.plc.findViewById(b.f.sns_ad_feedback_no_interest_image));
    this.PYX = this.plc.findViewById(b.f.sns_ad_feedback_approve_layout);
    this.PYY = ((WeImageView)this.plc.findViewById(b.f.sns_ad_feedback_approve_image));
    this.PZf = ((ViewGroup)this.plc.findViewById(b.f.sns_ad_feedback_dynamic_container));
    this.PZg = this.plc.findViewById(b.f.sns_ad_feedback_confirm_btn);
    this.PZk = this.mContext.getResources().getDimensionPixelOffset(b.d.sns_ad_feedback_panel_width);
    this.titleMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 16);
    if (this.PZg != null) {
      this.PZg.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(310976);
          if (paramAnonymousView.getVisibility() == 0)
          {
            b.a(b.this, b.a(b.this).getWidth());
            b.b(b.this, 0);
            b.a(b.this).removeOnLayoutChangeListener(this);
          }
          AppMethodBeat.o(310976);
        }
      });
    }
    this.xw = ((TextView)this.plc.findViewById(b.f.sns_ad_feedback_title));
    this.PZh = ((TextView)this.plc.findViewById(b.f.sns_ad_feedback_subtitle));
    if (this.PYT != null) {
      this.PYT.setImageResource(b.i.sns_ad_feedback_trangle);
    }
    if (this.PYU != null)
    {
      this.PYU.setImageResource(b.i.sns_ad_feedback_trangle);
      this.PYU.setRotation(180.0F);
    }
    if (this.xw != null)
    {
      paramView = this.PZj;
      if (paramView != null)
      {
        paramView = paramView.aWK("expand_title");
        if (d.aT(paramView))
        {
          paramView = paramView.get("expand_title");
          if ((paramView instanceof CharSequence)) {
            this.xw.setText((CharSequence)paramView);
          }
        }
      }
    }
    if (this.PZa != null) {
      this.PZa.setImageResource(b.i.sns_ad_feedback_no_interesting);
    }
    if (this.PYY != null) {
      this.PYY.setImageResource(b.i.sns_ad_feedback_approve);
    }
    if (this.PZd != null) {
      this.PZd.setImageResource(b.i.sns_ad_feedback_right_arrow);
    }
    if (this.PYZ != null) {
      this.PYZ.setOnClickListener(this);
    }
    if (this.PYX != null) {
      this.PYX.setOnClickListener(this);
    }
    if (this.PZb != null) {
      this.PZb.setOnClickListener(this);
    }
    if (this.PZg != null) {
      this.PZg.setOnClickListener(this);
    }
    if (this.PZf != null)
    {
      paramView = this.PZj;
      if (paramView == null) {
        break label988;
      }
      paramView = paramView.aWK("reason_list");
      if (!d.aT(paramView)) {
        break label988;
      }
      paramView = paramView.get("reason_list");
      if (!(paramView instanceof Collection)) {
        break label988;
      }
    }
    label988:
    for (paramView = (Collection)paramView;; paramView = null)
    {
      if (d.B(paramView))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext())
        {
          c localc = (c)paramView.next();
          Context localContext = this.mContext;
          String str = localc.PZD;
          TextView localTextView = new TextView(localContext);
          localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          localTextView.setSingleLine(true);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          localTextView.setBackgroundResource(b.e.sns_ad_feedback_text_bg_selector);
          localTextView.setTextColor(this.mContext.getResources().getColorStateList(com.tencent.mm.plugin.sns.b.c.sns_ad_feedback_text_front_selector));
          int i = com.tencent.mm.cd.a.fromDPToPix(localContext, 12);
          int j = com.tencent.mm.cd.a.fromDPToPix(localContext, 8);
          localTextView.setPadding(i, j, i, j);
          localTextView.setTextSize(2, 14.0F);
          localTextView.setText(str);
          localTextView.setOnClickListener(new a());
          localTextView.setTag(b.f.sns_ad_feed_no_interest_reason_key, localc);
          this.PZf.addView(localTextView);
        }
      }
      paramView = this.PZj;
      if (paramView != null)
      {
        paramView = paramView.aWK("is_special");
        if (d.aT(paramView))
        {
          paramView = paramView.get("is_special");
          if (!(paramView instanceof Boolean)) {}
        }
      }
      for (boolean bool = ((Boolean)paramView).booleanValue();; bool = true)
      {
        if (bool)
        {
          this.PYW.setVisibility(8);
          this.PYV.setVisibility(0);
          paramView = this.PZj;
          if (paramView != null)
          {
            paramView = paramView.aWK("special_prompt");
            if (d.aT(paramView))
            {
              paramView = paramView.get("special_prompt");
              if ((paramView instanceof CharSequence)) {
                this.PYV.setText((CharSequence)paramView);
              }
            }
          }
        }
        if (this.PZc != null)
        {
          paramView = this.PZj;
          if (paramView != null)
          {
            paramView = paramView.aWK("complaint_content");
            if (d.aT(paramView))
            {
              paramView = paramView.get("complaint_content");
              if (((paramView instanceof CharSequence)) && (!TextUtils.isEmpty((CharSequence)paramView))) {
                this.PZc.setText((CharSequence)paramView);
              }
            }
          }
        }
        AppMethodBeat.o(311105);
        return;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(311123);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i = paramView.getId();
    if (i == b.f.sns_ad_feedback_no_interest_layout)
    {
      if ((this.PZf != null) && (this.PZf.getChildCount() > 0))
      {
        this.PZf.setVisibility(0);
        if (this.PZe != null) {
          this.PZe.setVisibility(8);
        }
        if (this.xw != null)
        {
          this.xw.setTextColor(com.tencent.mm.cd.a.w(this.xw.getContext(), com.tencent.mm.plugin.sns.b.c.sns_ad_new_feedback_text_normal_color));
          this.xw.setText(b.j.sns_ad_new_feedback_select_reason);
        }
        if (this.PZh != null)
        {
          this.PZh.setTextColor(com.tencent.mm.cd.a.w(this.PZh.getContext(), com.tencent.mm.plugin.sns.b.c.sns_ad_new_feedback_text_gray_color));
          this.PZh.setText(this.PZh.getContext().getString(b.j.sns_ad_new_feedback_subtitle));
        }
      }
      if (this.PZi != null)
      {
        localObject = hbJ();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.PZi.a(paramView, 1, null);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(311123);
      return;
      if (i == b.f.sns_ad_feedback_approve_layout)
      {
        if (this.PZi != null) {
          this.PZi.a(paramView, 2, null);
        }
      }
      else if (i == b.f.sns_ad_feedback_complaint_layout)
      {
        if (this.PZi != null) {
          this.PZi.a(paramView, 3, null);
        }
      }
      else if ((i == b.f.sns_ad_feedback_confirm_btn) && (this.PZi != null))
      {
        localObject = hbJ();
        if (localObject != null) {
          paramView.setTag(localObject);
        }
        this.PZi.a(paramView, 4, null);
      }
    }
  }
  
  final class a
    implements View.OnClickListener
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(310977);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      if (paramView != null) {}
      try
      {
        if (paramView.isSelected()) {
          break label179;
        }
        bool = true;
        paramView.setSelected(bool);
        if (b.this.PZg == null) {
          break label131;
        }
        localObject = b.this.PZf;
        if (localObject == null) {
          break label220;
        }
        int j = ((ViewGroup)localObject).getChildCount();
        i = 0;
        label89:
        if (i >= j) {
          break label220;
        }
        if (!((ViewGroup)localObject).getChildAt(i).isSelected()) {
          break label185;
        }
        i = 1;
      }
      finally
      {
        for (;;)
        {
          boolean bool;
          label131:
          label179:
          label185:
          continue;
          int i = 0;
        }
      }
      if (i != 0)
      {
        b.this.PZg.setVisibility(0);
        b.b(b.this, 0);
      }
      for (;;)
      {
        localObject = b.this.PZi;
        if (localObject != null) {
          ((b.c)localObject).a(paramView, 5, paramView.getTag(b.f.sns_ad_feed_no_interest_reason_key));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/feedback/FeedbackDisplayer$DynamicTextViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(310977);
        return;
        bool = false;
        break;
        i += 1;
        break label89;
        b.this.PZg.setVisibility(8);
        b.b(b.this, 8);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract Map<String, Object> aWK(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.b
 * JD-Core Version:    0.7.0.1
 */