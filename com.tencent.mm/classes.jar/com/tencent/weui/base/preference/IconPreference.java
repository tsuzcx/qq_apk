package com.tencent.weui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.d;
import com.tencent.mm.ci.a.e;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;

public class IconPreference
  extends Preference
{
  private Context context;
  private String desc = "";
  private Drawable drawable;
  private TextView gaI;
  private int height = -1;
  protected ImageView lZf = null;
  private String nSg = "";
  private int nSh = -1;
  private int nSi = 8;
  private ImageView oFp = null;
  protected int uGS = -1;
  private Bitmap uJy = null;
  RelativeLayout.LayoutParams vcA;
  private TextView vcB;
  private TextView vcC;
  private ImageView vcD;
  private boolean vcE = false;
  private boolean vcF = false;
  private int vcG = -1;
  private boolean vcH = false;
  private int vck = 8;
  private int vcl = 8;
  private int vcm = 8;
  private ImageView vcn = null;
  private ViewGroup vco = null;
  private TextView vcp;
  private int vcr = 8;
  private String vcs = "";
  private int vct = -1;
  private int vcu = 8;
  private int vcv = -1;
  private int vcw = 8;
  private int vcx = 8;
  private View vcy = null;
  private View vcz = null;
  private int xfR = 8;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    setLayoutResource(a.g.mm_preference);
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.vcD = ((ImageView)paramView.findViewById(a.f.image_iv));
    Object localObject;
    if (this.vcD != null)
    {
      if (this.drawable != null)
      {
        this.vcD.setImageDrawable(this.drawable);
        this.vcD.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(a.f.mm_preference_ll_id);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(a.d.SmallListHeight));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.vcC = ((TextView)paramView.findViewById(a.f.text_tv_one));
      if (this.vcC != null)
      {
        if (!this.vcF) {
          break label723;
        }
        this.vcC.setCompoundDrawablesWithIntrinsicBounds(a.e.unread_dot_shape, 0, 0, 0);
        this.vcC.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.d.SmallPadding));
        label155:
        this.vcC.setVisibility(this.nSi);
        this.vcC.setText(this.nSg);
        if (this.nSh != -1) {
          this.vcC.setBackgroundDrawable(this.context.getResources().getDrawable(this.nSh));
        }
      }
      this.vcB = ((TextView)paramView.findViewById(a.f.text_tv_two));
      if (this.vcB != null)
      {
        this.vcB.setVisibility(this.vcu);
        this.vcB.setText(this.vcs);
        if (this.vct != -1) {
          this.vcB.setBackgroundDrawable(this.context.getResources().getDrawable(this.vct));
        }
        if (this.vcv != -1) {
          this.vcB.setTextColor(this.vcv);
        }
        if (!this.vcE) {
          break label737;
        }
        this.vcB.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.unread_dot_shape, 0);
        this.vcB.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.d.SmallPadding));
      }
      label338:
      this.vcn = ((ImageView)paramView.findViewById(a.f.text_prospect));
      this.vcn.setVisibility(this.vck);
      if (this.vcG != -1) {
        this.vcn.setImageResource(this.vcG);
      }
      this.lZf = ((ImageView)paramView.findViewById(a.f.image_right_iv));
      this.vco = ((ViewGroup)paramView.findViewById(a.f.right_rl));
      this.vcz = paramView.findViewById(a.f.right_center_prospect);
      this.vcz.setVisibility(this.vcx);
      this.vcy = paramView.findViewById(a.f.right_prospect);
      this.vcy.setVisibility(this.vcm);
      this.oFp = ((ImageView)paramView.findViewById(a.f.right_arrow));
      this.oFp.setVisibility(this.xfR);
      if (this.uJy == null) {
        break label751;
      }
      this.lZf.setImageBitmap(this.uJy);
      label497:
      this.lZf.setVisibility(this.vcw);
      this.vco.setVisibility(this.vcl);
      if (this.vcA != null) {
        this.lZf.setLayoutParams(this.vcA);
      }
      this.vcp = ((TextView)paramView.findViewById(16908310));
      this.gaI = ((TextView)paramView.findViewById(a.f.desc));
      if (this.gaI != null)
      {
        this.gaI.setVisibility(this.vcr);
        this.gaI.setText(this.desc);
        if (!this.vcH) {
          break label773;
        }
        this.gaI.setTextColor(this.context.getResources().getColor(a.c.disable_text_color));
      }
      label621:
      if (this.vcp != null)
      {
        if (!this.vcH) {
          break label796;
        }
        this.vcp.setTextColor(this.context.getResources().getColor(a.c.disable_text_color));
      }
      label655:
      if (this.vcH) {
        break label819;
      }
    }
    label773:
    label796:
    label819:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      return;
      if (getIcon() != null)
      {
        localObject = this.vcD;
        Drawable localDrawable = getIcon();
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.vcD.setVisibility(0);
        break;
      }
      this.vcD.setVisibility(8);
      break;
      label723:
      this.vcC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label155;
      label737:
      this.vcB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label338;
      label751:
      if (this.uGS == -1) {
        break label497;
      }
      this.lZf.setImageResource(this.uGS);
      break label497;
      this.gaI.setTextColor(this.context.getResources().getColor(a.c.hint_text_color));
      break label621;
      this.vcp.setTextColor(this.context.getResources().getColor(a.c.normal_text_color));
      break label655;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), a.g.preference_content_icon, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.weui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */