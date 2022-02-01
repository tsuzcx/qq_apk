package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class IconSummaryPreference
  extends Preference
{
  private int JMP;
  private int JMQ;
  private ViewGroup JMS;
  RelativeLayout.LayoutParams JMW;
  private int JNb;
  private View JNd;
  private int JNo;
  private TextView JNp;
  private int JNq;
  private int JnV;
  private Bitmap JrG;
  private Context context;
  private Drawable drawable;
  private int height;
  private ImageView vQs;
  private String xit;
  private int yUu;
  public int yUv;
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142560);
    this.xit = "";
    this.yUu = -1;
    this.yUv = 8;
    this.JrG = null;
    this.JnV = -1;
    this.JNb = 8;
    this.JMP = 0;
    this.JMQ = 8;
    this.JNo = 8;
    this.vQs = null;
    this.JMS = null;
    this.JNd = null;
    this.JNp = null;
    this.JNq = -1;
    this.height = -1;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142560);
  }
  
  public final void aXh(String paramString)
  {
    this.xit = paramString;
    this.yUu = 2131233430;
  }
  
  public final void fDE()
  {
    AppMethodBeat.i(142564);
    this.JNo = 0;
    if (this.JNp != null) {
      this.JNp.setVisibility(this.JNo);
    }
    AppMethodBeat.o(142564);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142565);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131300943);
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      if (this.drawable != null)
      {
        ((ImageView)localObject).setImageDrawable(this.drawable);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      localObject = (TextView)paramView.findViewById(2131305745);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(this.yUv);
        ((TextView)localObject).setText(this.xit);
        if (this.yUu != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.l(this.context, this.yUu));
        }
      }
      if (this.vQs == null) {
        this.vQs = ((ImageView)paramView.findViewById(2131300959));
      }
      if (this.JMS == null) {
        this.JMS = ((ViewGroup)paramView.findViewById(2131304191));
      }
      if (this.JNd == null) {
        this.JNd = paramView.findViewById(2131304190);
      }
      this.JNd.setVisibility(this.JMQ);
      if (this.JrG == null) {
        break label425;
      }
      this.vQs.setImageBitmap(this.JrG);
    }
    for (;;)
    {
      this.vQs.setVisibility(this.JNb);
      this.JMS.setVisibility(this.JMP);
      if (this.JMW != null) {
        this.vQs.setLayoutParams(this.JMW);
      }
      this.JNp = ((TextView)paramView.findViewById(2131304197));
      if ((this.JNp != null) && (getSummary() != null) && (getSummary().length() > 0))
      {
        this.JNp.setText(getSummary());
        this.JNp.setVisibility(this.JNo);
      }
      if ((this.JNp != null) && (this.JNq != -1))
      {
        this.JNp.setCompoundDrawablesWithIntrinsicBounds(this.JNq, 0, 0, 0);
        int i = BackwardSupportUtil.b.h(this.mContext, 2.0F);
        this.JNp.setCompoundDrawablePadding(i);
        this.JNp.setVisibility(this.JNo);
      }
      AppMethodBeat.o(142565);
      return;
      if (this.Xj != null)
      {
        ((ImageView)localObject).setImageDrawable(this.Xj);
        ((ImageView)localObject).setVisibility(0);
        break;
      }
      if (this.aeA == 0) {
        break;
      }
      ((ImageView)localObject).setImageResource(this.aeA);
      ((ImageView)localObject).setVisibility(0);
      break;
      label425:
      if (this.JnV != -1) {
        this.vQs.setImageResource(this.JnV);
      }
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142561);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494830, localViewGroup);
    AppMethodBeat.o(142561);
    return paramViewGroup;
  }
  
  public final void setSummary(int paramInt)
  {
    AppMethodBeat.i(142563);
    super.setSummary(paramInt);
    if ((this.JNp != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.JNp.setText(getSummary());
    }
    AppMethodBeat.o(142563);
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142562);
    super.setSummary(paramCharSequence);
    if ((this.JNp != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.JNp.setText(getSummary());
    }
    AppMethodBeat.o(142562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */