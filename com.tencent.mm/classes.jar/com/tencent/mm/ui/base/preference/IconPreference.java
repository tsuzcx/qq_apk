package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;

public class IconPreference
  extends Preference
{
  protected ImageView KKj;
  private String MPk;
  private int MPl;
  private int MPm;
  protected TextView MPp;
  private String MYb;
  private int adYA;
  private int adYB;
  private View adYC;
  private View adYD;
  private TextView adYE;
  private ImageView adYF;
  public boolean adYG;
  private boolean adYH;
  private String adYI;
  private boolean adYJ;
  public boolean adYK;
  private int adYL;
  public boolean adYM;
  public boolean adYN;
  private boolean adYO;
  public int adYn;
  private int adYo;
  private int adYp;
  private ImageView adYq;
  private ViewGroup adYr;
  private TextView adYs;
  protected Drawable adYu;
  RelativeLayout.LayoutParams adYv;
  private int adYw;
  private int adYx;
  private int adYy;
  private int adYz;
  protected int adva;
  private Bitmap adzN;
  private Context context;
  private String desc;
  private TextView descTv;
  public Drawable drawable;
  private int height;
  private View mView;
  
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
    AppMethodBeat.i(142543);
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
    this.adYq = null;
    this.adYr = null;
    this.adYC = null;
    this.adYD = null;
    this.height = -1;
    this.adYJ = false;
    this.adYK = false;
    this.adYL = -1;
    this.adYM = false;
    this.adYN = false;
    this.adYO = false;
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142543);
  }
  
  public final void LF(boolean paramBoolean)
  {
    AppMethodBeat.i(142551);
    this.adYJ = paramBoolean;
    if (this.adYE != null)
    {
      if (paramBoolean)
      {
        this.adYE.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.unread_dot_shape, 0);
        this.adYE.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.SmallPadding));
        AppMethodBeat.o(142551);
        return;
      }
      this.adYE.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    AppMethodBeat.o(142551);
  }
  
  public final void T(Drawable paramDrawable)
  {
    AppMethodBeat.i(182566);
    this.adYu = paramDrawable;
    this.adzN = null;
    this.adva = -1;
    if (this.KKj != null) {
      this.KKj.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(182566);
  }
  
  public final void aBf(int paramInt)
  {
    AppMethodBeat.i(142549);
    this.adYy = paramInt;
    if (this.adYE != null) {
      this.adYE.setVisibility(paramInt);
    }
    AppMethodBeat.o(142549);
  }
  
  public final void aBg(int paramInt)
  {
    AppMethodBeat.i(142554);
    this.adva = paramInt;
    this.adzN = null;
    if (this.KKj != null) {
      this.KKj.setImageResource(paramInt);
    }
    AppMethodBeat.o(142554);
  }
  
  public final void aBh(int paramInt)
  {
    AppMethodBeat.i(142555);
    this.adYA = paramInt;
    if (this.KKj != null) {
      this.KKj.setVisibility(this.adYA);
    }
    AppMethodBeat.o(142555);
  }
  
  public final void aBi(int paramInt)
  {
    AppMethodBeat.i(142556);
    this.adYo = paramInt;
    if (this.adYr != null) {
      this.adYr.setVisibility(this.adYo);
    }
    AppMethodBeat.o(142556);
  }
  
  public final void aBj(int paramInt)
  {
    AppMethodBeat.i(142557);
    this.adYp = paramInt;
    if (this.adYC != null) {
      this.adYC.setVisibility(this.adYp);
    }
    AppMethodBeat.o(142557);
  }
  
  public void aeD(int paramInt)
  {
    AppMethodBeat.i(142552);
    this.adYn = paramInt;
    if (this.adYq != null) {
      this.adYq.setVisibility(paramInt);
    }
    AppMethodBeat.o(142552);
  }
  
  public final void afx(int paramInt)
  {
    AppMethodBeat.i(142548);
    this.MPm = paramInt;
    if (this.MPp != null) {
      this.MPp.setVisibility(paramInt);
    }
    AppMethodBeat.o(142548);
  }
  
  public final void bd(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142553);
    this.adzN = paramBitmap;
    this.adva = -1;
    this.adYu = null;
    if (this.KKj != null) {
      this.KKj.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(142553);
  }
  
  public final void bd(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142547);
    this.MYb = paramString;
    this.adYx = paramInt1;
    this.adYz = paramInt2;
    if (this.adYE != null)
    {
      this.adYE.setText(paramString);
      if (paramInt1 != -1) {
        this.adYE.setBackgroundDrawable(this.context.getResources().getDrawable(paramInt1));
      }
      if (paramInt2 != -1) {
        this.adYE.setTextColor(paramInt2);
      }
    }
    AppMethodBeat.o(142547);
  }
  
  public final void gv(String paramString, int paramInt)
  {
    this.MPk = paramString;
    this.MPl = paramInt;
  }
  
  public final void iO(String paramString, int paramInt)
  {
    AppMethodBeat.i(251521);
    this.MPk = paramString;
    this.MPl = paramInt;
    if (this.MPp != null)
    {
      if (this.MPk != null) {
        this.MPp.setText(this.MPk);
      }
      if (this.MPl != -1) {
        this.MPp.setBackgroundDrawable(this.context.getResources().getDrawable(this.MPl));
      }
    }
    AppMethodBeat.o(251521);
  }
  
  public final void iP(String paramString, int paramInt)
  {
    AppMethodBeat.i(142545);
    bd(paramString, paramInt, this.adYz);
    AppMethodBeat.o(142545);
  }
  
  protected final View jnk()
  {
    AppMethodBeat.i(251516);
    if (this.mView == null)
    {
      AppMethodBeat.o(251516);
      return null;
    }
    View localView = this.mView.findViewById(16908312);
    AppMethodBeat.o(251516);
    return localView;
  }
  
  public final void jnl()
  {
    AppMethodBeat.i(142550);
    this.adYw = 0;
    if (this.descTv != null) {
      this.descTv.setVisibility(0);
    }
    AppMethodBeat.o(142550);
  }
  
  public final ImageView jnm()
  {
    return this.KKj;
  }
  
  public final ImageView jnn()
  {
    return this.adYF;
  }
  
  public final void on(int paramInt1, int paramInt2)
  {
    this.adYn = paramInt1;
    this.adYL = paramInt2;
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142559);
    super.onBindView(paramView);
    this.adYF = ((ImageView)paramView.findViewById(a.g.image_iv));
    label82:
    Object localObject1;
    label132:
    Object localObject2;
    label328:
    int i;
    if (this.adYF != null)
    {
      if (this.drawable != null)
      {
        this.adYF.setImageDrawable(this.drawable);
        this.adYF.setVisibility(0);
        if (getIconColor() == 0) {
          break label1016;
        }
        this.adYF.getDrawable().setColorFilter(getIconColor(), PorterDuff.Mode.SRC_ATOP);
        if (!this.adYG) {
          break label1039;
        }
        localObject1 = (LinearLayout.LayoutParams)this.adYF.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = bd.bs(this.mContext, a.e.Edge_2A);
        ((LinearLayout.LayoutParams)localObject1).gravity = 48;
        this.adYF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      localObject1 = (LinearLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      ((LinearLayout)localObject1).setMinimumHeight(paramView.getResources().getDimensionPixelSize(a.e.ListItemHeight));
      if (this.adYH)
      {
        localObject2 = (LinearLayout)paramView.findViewById(a.g.right_ll);
        if (localObject2 != null) {
          ((LinearLayout)localObject2).setPadding(0, 0, 0, 0);
        }
        if ((((LinearLayout)localObject1).getParent() != null) && (((LinearLayout)localObject1).getParent().getParent() != null) && ((((LinearLayout)localObject1).getParent().getParent() instanceof LinearLayout))) {
          ((LinearLayout)((LinearLayout)localObject1).getParent().getParent()).setPadding(0, 0, 0, 0);
        }
      }
      if (this.height != -1) {
        ((LinearLayout)localObject1).setMinimumHeight(this.height);
      }
      this.MPp = ((TextView)paramView.findViewById(a.g.text_tv_one));
      if (this.MPp != null)
      {
        if (!this.adYK) {
          break label1076;
        }
        this.MPp.setCompoundDrawablesWithIntrinsicBounds(a.f.unread_dot_shape, 0, 0, 0);
        this.MPp.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.SmallPadding));
        this.MPp.setVisibility(this.MPm);
        this.MPp.setText(this.MPk);
        aw.d(this.MPp.getPaint());
        if (this.MPl != -1)
        {
          if (this.MPl != a.f.new_tips_bg) {
            break label1090;
          }
          this.MPp.setTextSize(0, a.bs(this.mContext, a.e.unReadNewTextSize) * a.jO(this.context));
          label405:
          this.MPp.setBackgroundDrawable(this.context.getResources().getDrawable(this.MPl));
        }
      }
      if (!this.adYN) {
        break label1120;
      }
      i = a.g.text_tv_right;
      label437:
      this.adYE = ((TextView)paramView.findViewById(i));
      if (this.adYE != null)
      {
        this.adYE.setVisibility(this.adYy);
        this.adYE.setText(this.MYb);
        if (this.adYx != -1)
        {
          this.adYE.setBackgroundDrawable(this.context.getResources().getDrawable(this.adYx));
          if (this.adYx == a.f.new_tips_bg) {
            this.adYE.setTextSize(0, a.bs(this.context, a.e.unReadNewTextSize) * a.jO(this.context));
          }
        }
        if (this.adYz != -1) {
          this.adYE.setTextColor(this.adYz);
        }
        if (!this.adYJ) {
          break label1127;
        }
        this.adYE.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.unread_dot_shape, 0);
        this.adYE.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.SmallPadding));
      }
      label604:
      this.adYq = ((ImageView)paramView.findViewById(a.g.text_prospect));
      this.adYq.setVisibility(this.adYn);
      if (this.adYL != -1) {
        this.adYq.setImageResource(this.adYL);
      }
      this.KKj = ((ImageView)paramView.findViewById(a.g.image_right_iv));
      this.adYr = ((ViewGroup)paramView.findViewById(a.g.right_rl));
      this.adYD = paramView.findViewById(a.g.right_center_prospect);
      this.adYD.setVisibility(this.adYB);
      this.adYC = paramView.findViewById(a.g.right_prospect);
      this.adYC.setVisibility(this.adYp);
      if (this.adzN == null) {
        break label1141;
      }
      this.KKj.setImageBitmap(this.adzN);
      label738:
      this.KKj.setVisibility(this.adYA);
      this.adYr.setVisibility(this.adYo);
      if (this.adYv != null) {
        this.KKj.setLayoutParams(this.adYv);
      }
      this.adYs = ((TextView)paramView.findViewById(16908310));
      this.descTv = ((TextView)paramView.findViewById(a.g.desc));
      if (this.descTv != null)
      {
        this.descTv.setVisibility(this.adYw);
        this.descTv.setText(this.desc);
        if (!this.adYM) {
          break label1184;
        }
        this.descTv.setTextColor(this.context.getResources().getColor(a.d.disable_text_color));
      }
      label862:
      if (this.adYs != null)
      {
        if (!this.adYM) {
          break label1207;
        }
        this.adYs.setTextColor(this.context.getResources().getColor(a.d.disable_text_color));
      }
      label896:
      if (this.adYM) {
        break label1230;
      }
    }
    label1039:
    label1076:
    label1090:
    label1230:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      if ((this.adYO) && (this.adYs != null)) {
        this.adYs.setTextColor(this.adYs.getResources().getColor(a.d.disable_text_color));
      }
      AppMethodBeat.o(142559);
      return;
      if (dqA() != 0)
      {
        localObject1 = this.adYF;
        localObject2 = this.mContext.getResources().getDrawable(dqA());
        this.drawable = ((Drawable)localObject2);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        this.adYF.setVisibility(0);
        break;
      }
      this.adYF.setVisibility(8);
      break;
      label1016:
      if (this.adYF.getDrawable() == null) {
        break label82;
      }
      this.adYF.getDrawable().clearColorFilter();
      break label82;
      localObject1 = (LinearLayout.LayoutParams)this.adYF.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      this.adYF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break label132;
      this.MPp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label328;
      this.MPp.setTextSize(0, a.bs(this.mContext, a.e.unReadCountTextSize) * a.jO(this.context));
      break label405;
      label1120:
      i = a.g.text_tv_two;
      break label437;
      label1127:
      this.adYE.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label604;
      label1141:
      if (this.adva != -1)
      {
        this.KKj.setImageResource(this.adva);
        break label738;
      }
      if (this.adYu == null) {
        break label738;
      }
      this.KKj.setImageDrawable(this.adYu);
      break label738;
      this.descTv.setTextColor(this.context.getResources().getColor(a.d.desc_text_color));
      break label862;
      this.adYs.setTextColor(this.context.getResources().getColor(a.d.FG_0));
      break label896;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142544);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_content_icon, localViewGroup);
    this.mView = paramViewGroup;
    if ((this.adYI != null) && (this.adYI.length() > 0)) {
      this.mView.setContentDescription(this.adYI);
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(142544);
    return paramViewGroup;
  }
  
  public final void oo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142558);
    this.adYv = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.adYv.addRule(13);
    if (this.KKj == null)
    {
      AppMethodBeat.o(142558);
      return;
    }
    this.KKj.setLayoutParams(this.adYv);
    AppMethodBeat.o(142558);
  }
  
  public final void setContentDescription(String paramString)
  {
    AppMethodBeat.i(251587);
    if (this.mView != null) {
      this.mView.setContentDescription(paramString);
    }
    this.adYI = paramString;
    AppMethodBeat.o(251587);
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(142546);
    this.desc = paramString;
    if (this.descTv != null) {
      this.descTv.setText(paramString);
    }
    AppMethodBeat.o(142546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */