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
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class IconSummaryPreference
  extends Preference
{
  private Context context;
  private Drawable drawable;
  private int height = -1;
  private ImageView lZf = null;
  private String nSg = "";
  private int nSh = -1;
  public int nSi = 8;
  private int uGS = -1;
  private Bitmap uJy = null;
  RelativeLayout.LayoutParams vcA;
  public int vcI = 8;
  public TextView vcJ = null;
  private int vcK = -1;
  private int vcl = 0;
  private int vcm = 8;
  private ViewGroup vco = null;
  private int vcw = 8;
  private View vcy = null;
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference);
  }
  
  public final void dD(String paramString, int paramInt)
  {
    this.nSg = paramString;
    this.nSh = paramInt;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(a.g.image_iv);
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
      localObject = (LinearLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      localObject = (TextView)paramView.findViewById(a.g.text_tv_one);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(this.nSi);
        ((TextView)localObject).setText(this.nSg);
        if (this.nSh != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.g(this.context, this.nSh));
        }
      }
      if (this.lZf == null) {
        this.lZf = ((ImageView)paramView.findViewById(a.g.image_right_iv));
      }
      if (this.vco == null) {
        this.vco = ((ViewGroup)paramView.findViewById(a.g.right_rl));
      }
      if (this.vcy == null) {
        this.vcy = paramView.findViewById(a.g.right_prospect);
      }
      this.vcy.setVisibility(this.vcm);
      if (this.uJy == null) {
        break label422;
      }
      this.lZf.setImageBitmap(this.uJy);
    }
    for (;;)
    {
      this.lZf.setVisibility(this.vcw);
      this.vco.setVisibility(this.vcl);
      if (this.vcA != null) {
        this.lZf.setLayoutParams(this.vcA);
      }
      this.vcJ = ((TextView)paramView.findViewById(a.g.right_summary));
      if ((this.vcJ != null) && (getSummary() != null) && (getSummary().length() > 0))
      {
        this.vcJ.setText(getSummary());
        this.vcJ.setVisibility(this.vcI);
      }
      if ((this.vcJ != null) && (this.vcK != -1))
      {
        this.vcJ.setCompoundDrawablesWithIntrinsicBounds(this.vcK, 0, 0, 0);
        int i = BackwardSupportUtil.b.b(this.mContext, 2.0F);
        this.vcJ.setCompoundDrawablePadding(i);
        this.vcJ.setVisibility(this.vcI);
      }
      return;
      if (this.kc != null)
      {
        ((ImageView)localObject).setImageDrawable(this.kc);
        ((ImageView)localObject).setVisibility(0);
        break;
      }
      if (this.Ub == 0) {
        break;
      }
      ((ImageView)localObject).setImageResource(this.Ub);
      ((ImageView)localObject).setVisibility(0);
      break;
      label422:
      if (this.uGS != -1) {
        this.lZf.setImageResource(this.uGS);
      }
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_content_icon_summary, localViewGroup);
    return paramViewGroup;
  }
  
  public final void setSummary(int paramInt)
  {
    super.setSummary(paramInt);
    if ((this.vcJ != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.vcJ.setText(getSummary());
    }
  }
  
  public final void setSummary(CharSequence paramCharSequence)
  {
    super.setSummary(paramCharSequence);
    if ((this.vcJ != null) && (getSummary() != null) && (getSummary().length() > 0)) {
      this.vcJ.setText(getSummary());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSummaryPreference
 * JD-Core Version:    0.7.0.1
 */