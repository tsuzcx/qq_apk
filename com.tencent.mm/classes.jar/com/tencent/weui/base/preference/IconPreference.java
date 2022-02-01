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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;

public class IconPreference
  extends Preference
{
  protected ImageView KKj;
  private String MPk;
  private int MPl;
  private int MPm;
  private TextView MPp;
  private String MYb;
  private ImageView QNl;
  private int adYA;
  private int adYB;
  private View adYC;
  private View adYD;
  private TextView adYE;
  private ImageView adYF;
  private boolean adYJ;
  private boolean adYK;
  private int adYL;
  private boolean adYM;
  private int adYn;
  private int adYo;
  private int adYp;
  private ImageView adYq;
  private ViewGroup adYr;
  private TextView adYs;
  RelativeLayout.LayoutParams adYv;
  private int adYw;
  private int adYx;
  private int adYy;
  private int adYz;
  private int adZY;
  protected int adva;
  private Bitmap adzN;
  private Context context;
  private String desc;
  private TextView descTv;
  private Drawable drawable;
  private int height;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159990);
    this.adva = -1;
    this.KKj = null;
    this.MPk = "";
    this.MPl = -1;
    this.MPm = 8;
    this.adYn = 8;
    this.adYw = 8;
    this.desc = "";
    this.MYb = "";
    this.adYx = -1;
    this.adYy = 8;
    this.adYz = -1;
    this.adzN = null;
    this.adYA = 8;
    this.adYo = 8;
    this.adYp = 8;
    this.adYB = 8;
    this.adZY = 0;
    this.adYq = null;
    this.adYr = null;
    this.adYC = null;
    this.adYD = null;
    this.QNl = null;
    this.height = -1;
    this.adYJ = false;
    this.adYK = false;
    this.adYL = -1;
    this.adYM = false;
    this.context = paramContext;
    setLayoutResource(a.g.mm_preference);
    AppMethodBeat.o(159990);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(159992);
    super.onBindView(paramView);
    this.adYF = ((ImageView)paramView.findViewById(a.f.image_iv));
    Object localObject;
    if (this.adYF != null)
    {
      if (this.drawable != null)
      {
        this.adYF.setImageDrawable(this.drawable);
        this.adYF.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(a.f.mm_preference_ll_id);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(a.d.SmallListHeight));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.MPp = ((TextView)paramView.findViewById(a.f.text_tv_one));
      if (this.MPp != null)
      {
        if (!this.adYK) {
          break label733;
        }
        this.MPp.setCompoundDrawablesWithIntrinsicBounds(a.e.unread_dot_shape, 0, 0, 0);
        this.MPp.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.d.SmallPadding));
        label160:
        this.MPp.setVisibility(this.MPm);
        this.MPp.setText(this.MPk);
        if (this.MPl != -1) {
          this.MPp.setBackgroundDrawable(this.context.getResources().getDrawable(this.MPl));
        }
      }
      this.adYE = ((TextView)paramView.findViewById(a.f.text_tv_two));
      if (this.adYE != null)
      {
        this.adYE.setVisibility(this.adYy);
        this.adYE.setText(this.MYb);
        if (this.adYx != -1) {
          this.adYE.setBackgroundDrawable(this.context.getResources().getDrawable(this.adYx));
        }
        if (this.adYz != -1) {
          this.adYE.setTextColor(this.adYz);
        }
        if (!this.adYJ) {
          break label747;
        }
        this.adYE.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.unread_dot_shape, 0);
        this.adYE.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.d.SmallPadding));
      }
      label343:
      this.adYq = ((ImageView)paramView.findViewById(a.f.text_prospect));
      this.adYq.setVisibility(this.adYn);
      if (this.adYL != -1) {
        this.adYq.setImageResource(this.adYL);
      }
      this.KKj = ((ImageView)paramView.findViewById(a.f.image_right_iv));
      this.adYr = ((ViewGroup)paramView.findViewById(a.f.right_rl));
      this.adYD = paramView.findViewById(a.f.right_center_prospect);
      this.adYD.setVisibility(this.adYB);
      this.adYC = paramView.findViewById(a.f.right_prospect);
      this.adYC.setVisibility(this.adYp);
      this.QNl = ((ImageView)paramView.findViewById(a.f.right_arrow));
      this.QNl.setVisibility(this.adZY);
      if (this.adzN == null) {
        break label761;
      }
      this.KKj.setImageBitmap(this.adzN);
      label502:
      this.KKj.setVisibility(this.adYA);
      this.adYr.setVisibility(this.adYo);
      if (this.adYv != null) {
        this.KKj.setLayoutParams(this.adYv);
      }
      this.adYs = ((TextView)paramView.findViewById(16908310));
      this.descTv = ((TextView)paramView.findViewById(a.f.desc));
      if (this.descTv != null)
      {
        this.descTv.setVisibility(this.adYw);
        this.descTv.setText(this.desc);
        if (!this.adYM) {
          break label783;
        }
        this.descTv.setTextColor(this.context.getResources().getColor(a.c.disable_text_color));
      }
      label626:
      if (this.adYs != null)
      {
        if (!this.adYM) {
          break label806;
        }
        this.adYs.setTextColor(this.context.getResources().getColor(a.c.disable_text_color));
      }
      label660:
      if (this.adYM) {
        break label829;
      }
    }
    label783:
    label806:
    label829:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      AppMethodBeat.o(159992);
      return;
      if (getIcon() != null)
      {
        localObject = this.adYF;
        Drawable localDrawable = getIcon();
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.adYF.setVisibility(0);
        break;
      }
      this.adYF.setVisibility(8);
      break;
      label733:
      this.MPp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label160;
      label747:
      this.adYE.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label343;
      label761:
      if (this.adva == -1) {
        break label502;
      }
      this.KKj.setImageResource(this.adva);
      break label502;
      this.descTv.setTextColor(this.context.getResources().getColor(a.c.hint_text_color));
      break label626;
      this.adYs.setTextColor(this.context.getResources().getColor(a.c.normal_text_color));
      break label660;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(159991);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    View.inflate(getContext(), a.g.preference_content_icon, localViewGroup);
    AppMethodBeat.o(159991);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.weui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */