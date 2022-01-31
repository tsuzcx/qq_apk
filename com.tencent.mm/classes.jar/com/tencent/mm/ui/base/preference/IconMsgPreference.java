package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;

public class IconMsgPreference
  extends Preference
{
  private Context context;
  private Drawable drawable;
  private int height = -1;
  private String nSg = "";
  private int nSh = -1;
  private int nSi = 8;
  private int vck = 8;
  private int vcl = 0;
  private int vcm = 8;
  private ImageView vcn = null;
  private ViewGroup vco = null;
  private TextView vcp;
  private String vcq = "";
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(a.g.image_iv);
    if (localObject != null)
    {
      if (this.drawable == null) {
        break label212;
      }
      ((ImageView)localObject).setImageDrawable(this.drawable);
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
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
      this.vcn = ((ImageView)paramView.findViewById(a.g.text_prospect));
      this.vcn.setVisibility(this.vck);
      this.vco = ((ViewGroup)paramView.findViewById(a.g.right_rl));
      this.vco.setVisibility(this.vcl);
      this.vcp = ((TextView)paramView.findViewById(16908310));
      paramView = (TextView)paramView.findViewById(a.g.text_tv_right);
      if (!bk.bl(this.vcq)) {
        break;
      }
      paramView.setVisibility(8);
      return;
      label212:
      if (this.Ub != 0)
      {
        ((ImageView)localObject).setImageResource(this.Ub);
        ((ImageView)localObject).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    paramView.setVisibility(0);
    paramView.setText(this.vcq);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_icon_msg, localViewGroup);
    paramViewGroup.setMinimumHeight(paramViewGroup.getResources().getDimensionPixelSize(a.e.SmallListHeight));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconMsgPreference
 * JD-Core Version:    0.7.0.1
 */