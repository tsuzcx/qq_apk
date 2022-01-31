package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.cb.a;

public class IconPreference
  extends Preference
{
  private Context context;
  private String desc = "";
  public Drawable drawable;
  private TextView gaI;
  private int height = -1;
  public ImageView lZf = null;
  private View mView;
  private String nSg = "";
  private int nSh = -1;
  private int nSi = 8;
  public int uGS = -1;
  private Bitmap uJy = null;
  RelativeLayout.LayoutParams vcA;
  private TextView vcB;
  private TextView vcC;
  public ImageView vcD;
  private boolean vcE = false;
  public boolean vcF = false;
  private int vcG = -1;
  public boolean vcH = false;
  private int vck = 8;
  private int vcl = 0;
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
  
  public IconPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference);
  }
  
  public final void Gt(int paramInt)
  {
    this.nSi = paramInt;
    if (this.vcC != null) {
      this.vcC.setVisibility(paramInt);
    }
  }
  
  public final void Gu(int paramInt)
  {
    this.vcu = paramInt;
    if (this.vcB != null) {
      this.vcB.setVisibility(paramInt);
    }
  }
  
  public final void Gv(int paramInt)
  {
    this.vck = paramInt;
    if (this.vcn != null) {
      this.vcn.setVisibility(paramInt);
    }
  }
  
  public final void Gw(int paramInt)
  {
    this.uGS = paramInt;
    this.uJy = null;
    if (this.lZf != null) {
      this.lZf.setImageResource(paramInt);
    }
  }
  
  public final void Gx(int paramInt)
  {
    this.vcw = paramInt;
    if (this.lZf != null) {
      this.lZf.setVisibility(this.vcw);
    }
  }
  
  public final void Gy(int paramInt)
  {
    this.vcl = paramInt;
    if (this.vco != null) {
      this.vco.setVisibility(this.vcl);
    }
  }
  
  public final void Gz(int paramInt)
  {
    this.vcm = paramInt;
    if (this.vcy != null) {
      this.vcy.setVisibility(this.vcm);
    }
  }
  
  public final void Z(Bitmap paramBitmap)
  {
    this.uJy = paramBitmap;
    this.uGS = -1;
    if (this.lZf != null) {
      this.lZf.setImageBitmap(paramBitmap);
    }
  }
  
  public final void ap(String paramString, int paramInt1, int paramInt2)
  {
    this.vcs = paramString;
    this.vct = paramInt1;
    this.vcv = paramInt2;
    if (this.vcB != null)
    {
      this.vcB.setText(paramString);
      if (paramInt1 != -1) {
        this.vcB.setBackgroundDrawable(a.g(this.context, paramInt1));
      }
      if (paramInt2 != -1) {
        this.vcB.setTextColor(paramInt2);
      }
    }
  }
  
  public final void cBu()
  {
    this.vcr = 0;
    if (this.gaI != null) {
      this.gaI.setVisibility(0);
    }
  }
  
  public final void dD(String paramString, int paramInt)
  {
    this.nSg = paramString;
    this.nSh = paramInt;
  }
  
  public final void dE(String paramString, int paramInt)
  {
    ap(paramString, paramInt, this.vcv);
  }
  
  public final void fv(int paramInt1, int paramInt2)
  {
    this.vck = paramInt1;
    this.vcG = paramInt2;
  }
  
  public final void fw(int paramInt1, int paramInt2)
  {
    this.vcA = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.vcA.addRule(13);
    if (this.lZf == null) {
      return;
    }
    this.lZf.setLayoutParams(this.vcA);
  }
  
  public final void ne(boolean paramBoolean)
  {
    this.vcE = paramBoolean;
    if (this.vcB != null)
    {
      if (paramBoolean)
      {
        this.vcB.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.unread_dot_shape, 0);
        this.vcB.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.SmallPadding));
      }
    }
    else {
      return;
    }
    this.vcB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.vcD = ((ImageView)paramView.findViewById(a.g.image_iv));
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
      localObject = (LinearLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      ((LinearLayout)localObject).setMinimumHeight((int)(paramView.getResources().getDimensionPixelSize(a.e.SmallListHeight) * a.fg(this.context)));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.vcC = ((TextView)paramView.findViewById(a.g.text_tv_one));
      if (this.vcC != null)
      {
        if (!this.vcF) {
          break label722;
        }
        this.vcC.setCompoundDrawablesWithIntrinsicBounds(a.f.unread_dot_shape, 0, 0, 0);
        this.vcC.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.SmallPadding));
        label165:
        this.vcC.setVisibility(this.nSi);
        this.vcC.setText(this.nSg);
        if (this.nSh != -1) {
          this.vcC.setBackgroundDrawable(a.g(this.context, this.nSh));
        }
      }
      this.vcB = ((TextView)paramView.findViewById(a.g.text_tv_two));
      if (this.vcB != null)
      {
        this.vcB.setVisibility(this.vcu);
        this.vcB.setText(this.vcs);
        if (this.vct != -1) {
          this.vcB.setBackgroundDrawable(a.g(this.context, this.vct));
        }
        if (this.vcv != -1) {
          this.vcB.setTextColor(this.vcv);
        }
        if (!this.vcE) {
          break label736;
        }
        this.vcB.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.unread_dot_shape, 0);
        this.vcB.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.SmallPadding));
      }
      label342:
      this.vcn = ((ImageView)paramView.findViewById(a.g.text_prospect));
      this.vcn.setVisibility(this.vck);
      if (this.vcG != -1) {
        this.vcn.setImageResource(this.vcG);
      }
      this.lZf = ((ImageView)paramView.findViewById(a.g.image_right_iv));
      this.lZf.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.vco = ((ViewGroup)paramView.findViewById(a.g.right_rl));
      this.vcz = paramView.findViewById(a.g.right_center_prospect);
      this.vcz.setVisibility(this.vcx);
      this.vcy = paramView.findViewById(a.g.right_prospect);
      this.vcy.setVisibility(this.vcm);
      if (this.uJy == null) {
        break label750;
      }
      this.lZf.setImageBitmap(this.uJy);
      label486:
      this.lZf.setVisibility(this.vcw);
      this.vco.setVisibility(this.vcl);
      if (this.vcA != null) {
        this.lZf.setLayoutParams(this.vcA);
      }
      this.vcp = ((TextView)paramView.findViewById(16908310));
      this.gaI = ((TextView)paramView.findViewById(a.g.desc));
      if (this.gaI != null)
      {
        this.gaI.setVisibility(this.vcr);
        this.gaI.setText(this.desc);
        if (!this.vcH) {
          break label772;
        }
        this.gaI.setTextColor(this.context.getResources().getColor(a.d.disable_text_color));
      }
      label610:
      if (this.vcp != null)
      {
        if (!this.vcH) {
          break label795;
        }
        this.vcp.setTextColor(this.context.getResources().getColor(a.d.disable_text_color));
      }
      label644:
      if (this.vcH) {
        break label818;
      }
    }
    label772:
    label795:
    label818:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      return;
      if (this.Ub != 0)
      {
        localObject = this.vcD;
        Drawable localDrawable = this.mContext.getResources().getDrawable(this.Ub);
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.vcD.setVisibility(0);
        break;
      }
      this.vcD.setVisibility(8);
      break;
      label722:
      this.vcC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label165;
      label736:
      this.vcB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label342;
      label750:
      if (this.uGS == -1) {
        break label486;
      }
      this.lZf.setImageResource(this.uGS);
      break label486;
      this.gaI.setTextColor(this.context.getResources().getColor(a.d.hint_text_color));
      break label610;
      this.vcp.setTextColor(this.context.getResources().getColor(a.d.normal_text_color));
      break label644;
    }
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, a.h.mm_preference_content_icon, localViewGroup);
      this.mView = paramViewGroup;
    }
    return this.mView;
  }
  
  public final void setDesc(String paramString)
  {
    this.desc = paramString;
    if (this.gaI != null) {
      this.gaI.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */