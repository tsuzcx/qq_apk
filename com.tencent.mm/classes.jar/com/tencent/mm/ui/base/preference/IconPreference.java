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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.ao;

public class IconPreference
  extends Preference
{
  protected int FGP;
  private Bitmap FKj;
  protected Drawable GeB;
  RelativeLayout.LayoutParams GeC;
  private int GeD;
  private int GeE;
  private int GeF;
  private int GeG;
  private int GeH;
  private int GeI;
  private View GeJ;
  private View GeK;
  private TextView GeL;
  private TextView GeM;
  protected ImageView GeN;
  public boolean GeO;
  private boolean GeP;
  public boolean GeQ;
  private int GeR;
  public boolean GeS;
  private int Geu;
  private int Gev;
  private int Gew;
  private ImageView Gex;
  private ViewGroup Gey;
  private TextView Gez;
  private Context context;
  private String desc;
  public Drawable drawable;
  private int height;
  private TextView lEA;
  private View mView;
  protected ImageView tto;
  private String uCA;
  private String uCB;
  private int wey;
  private int wez;
  
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
    this.FGP = -1;
    this.tto = null;
    this.uCA = "";
    this.wey = -1;
    this.wez = 8;
    this.Geu = 8;
    this.GeD = 8;
    this.desc = "";
    this.uCB = "";
    this.GeE = -1;
    this.GeF = 8;
    this.GeG = -1;
    this.FKj = null;
    this.GeH = 8;
    this.Gev = 0;
    this.Gew = 8;
    this.GeI = 8;
    this.Gex = null;
    this.Gey = null;
    this.GeJ = null;
    this.GeK = null;
    this.height = -1;
    this.GeP = false;
    this.GeQ = false;
    this.GeR = -1;
    this.GeS = false;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142543);
  }
  
  public final void E(Drawable paramDrawable)
  {
    AppMethodBeat.i(182566);
    this.GeB = paramDrawable;
    this.FKj = null;
    this.FGP = -1;
    if (this.tto != null) {
      this.tto.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(182566);
  }
  
  public final void XQ(int paramInt)
  {
    AppMethodBeat.i(142548);
    this.wez = paramInt;
    if (this.GeM != null) {
      this.GeM.setVisibility(paramInt);
    }
    AppMethodBeat.o(142548);
  }
  
  public final void XR(int paramInt)
  {
    AppMethodBeat.i(142549);
    this.GeF = paramInt;
    if (this.GeL != null) {
      this.GeL.setVisibility(paramInt);
    }
    AppMethodBeat.o(142549);
  }
  
  public final void XS(int paramInt)
  {
    AppMethodBeat.i(142552);
    this.Geu = paramInt;
    if (this.Gex != null) {
      this.Gex.setVisibility(paramInt);
    }
    AppMethodBeat.o(142552);
  }
  
  public final void XT(int paramInt)
  {
    AppMethodBeat.i(142554);
    this.FGP = paramInt;
    this.FKj = null;
    if (this.tto != null) {
      this.tto.setImageResource(paramInt);
    }
    AppMethodBeat.o(142554);
  }
  
  public final void XU(int paramInt)
  {
    AppMethodBeat.i(142555);
    this.GeH = paramInt;
    if (this.tto != null) {
      this.tto.setVisibility(this.GeH);
    }
    AppMethodBeat.o(142555);
  }
  
  public final void XV(int paramInt)
  {
    AppMethodBeat.i(142556);
    this.Gev = paramInt;
    if (this.Gey != null) {
      this.Gey.setVisibility(this.Gev);
    }
    AppMethodBeat.o(142556);
  }
  
  public final void XW(int paramInt)
  {
    AppMethodBeat.i(142557);
    this.Gew = paramInt;
    if (this.GeJ != null) {
      this.GeJ.setVisibility(this.Gew);
    }
    AppMethodBeat.o(142557);
  }
  
  public final void aD(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142553);
    this.FKj = paramBitmap;
    this.FGP = -1;
    this.GeB = null;
    if (this.tto != null) {
      this.tto.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(142553);
  }
  
  public final void aN(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142547);
    this.uCB = paramString;
    this.GeE = paramInt1;
    this.GeG = paramInt2;
    if (this.GeL != null)
    {
      this.GeL.setText(paramString);
      if (paramInt1 != -1) {
        this.GeL.setBackgroundDrawable(this.context.getResources().getDrawable(paramInt1));
      }
      if (paramInt2 != -1) {
        this.GeL.setTextColor(paramInt2);
      }
    }
    AppMethodBeat.o(142547);
  }
  
  public final ImageView eTA()
  {
    return this.tto;
  }
  
  public final void eTz()
  {
    AppMethodBeat.i(142550);
    this.GeD = 0;
    if (this.lEA != null) {
      this.lEA.setVisibility(0);
    }
    AppMethodBeat.o(142550);
  }
  
  public final void fV(String paramString, int paramInt)
  {
    this.uCA = paramString;
    this.wey = paramInt;
  }
  
  public final void fW(String paramString, int paramInt)
  {
    AppMethodBeat.i(142545);
    aN(paramString, paramInt, this.GeG);
    AppMethodBeat.o(142545);
  }
  
  public final void jp(int paramInt1, int paramInt2)
  {
    this.Geu = paramInt1;
    this.GeR = paramInt2;
  }
  
  public final void jq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142558);
    this.GeC = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.GeC.addRule(13);
    if (this.tto == null)
    {
      AppMethodBeat.o(142558);
      return;
    }
    this.tto.setLayoutParams(this.GeC);
    AppMethodBeat.o(142558);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142559);
    super.onBindView(paramView);
    this.GeN = ((ImageView)paramView.findViewById(2131300943));
    label80:
    Object localObject;
    if (this.GeN != null)
    {
      if (this.drawable != null)
      {
        this.GeN.setImageDrawable(this.drawable);
        this.GeN.setVisibility(0);
        if (this.Coj == 0) {
          break label824;
        }
        this.GeN.getDrawable().setColorFilter(this.Coj, PorterDuff.Mode.SRC_ATOP);
        if (!this.GeO) {
          break label847;
        }
        localObject = (LinearLayout.LayoutParams)this.GeN.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ao.ap(this.mContext, 2131165289);
        ((LinearLayout.LayoutParams)localObject).gravity = 48;
        this.GeN.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      label126:
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131165488));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.GeM = ((TextView)paramView.findViewById(2131305745));
      if (this.GeM != null)
      {
        if (!this.GeQ) {
          break label880;
        }
        this.GeM.setCompoundDrawablesWithIntrinsicBounds(2131234447, 0, 0, 0);
        this.GeM.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        label229:
        this.GeM.setVisibility(this.wez);
        this.GeM.setText(this.uCA);
        if (this.wey != -1) {
          this.GeM.setBackgroundDrawable(this.context.getResources().getDrawable(this.wey));
        }
      }
      this.GeL = ((TextView)paramView.findViewById(2131305747));
      if (this.GeL != null)
      {
        this.GeL.setVisibility(this.GeF);
        this.GeL.setText(this.uCB);
        if (this.GeE != -1)
        {
          this.GeL.setBackgroundDrawable(this.context.getResources().getDrawable(this.GeE));
          if (this.GeE == 2131233430) {
            this.GeL.setTextSize(0, a.ap(this.context, 2131166950) * a.hQ(this.context));
          }
        }
        if (this.GeG != -1) {
          this.GeL.setTextColor(this.GeG);
        }
        if (!this.GeP) {
          break label894;
        }
        this.GeL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.GeL.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
      }
      label449:
      this.Gex = ((ImageView)paramView.findViewById(2131305740));
      this.Gex.setVisibility(this.Geu);
      if (this.GeR != -1) {
        this.Gex.setImageResource(this.GeR);
      }
      this.tto = ((ImageView)paramView.findViewById(2131300959));
      this.Gey = ((ViewGroup)paramView.findViewById(2131304191));
      this.GeK = paramView.findViewById(2131304181);
      this.GeK.setVisibility(this.GeI);
      this.GeJ = paramView.findViewById(2131304190);
      this.GeJ.setVisibility(this.Gew);
      if (this.FKj == null) {
        break label908;
      }
      this.tto.setImageBitmap(this.FKj);
      label583:
      this.tto.setVisibility(this.GeH);
      this.Gey.setVisibility(this.Gev);
      if (this.GeC != null) {
        this.tto.setLayoutParams(this.GeC);
      }
      this.Gez = ((TextView)paramView.findViewById(16908310));
      this.lEA = ((TextView)paramView.findViewById(2131298996));
      if (this.lEA != null)
      {
        this.lEA.setVisibility(this.GeD);
        this.lEA.setText(this.desc);
        if (!this.GeS) {
          break label951;
        }
        this.lEA.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label707:
      if (this.Gez != null)
      {
        if (!this.GeS) {
          break label974;
        }
        this.Gez.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label741:
      if (this.GeS) {
        break label994;
      }
    }
    label824:
    label847:
    label994:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      AppMethodBeat.o(142559);
      return;
      if (this.abP != 0)
      {
        localObject = this.GeN;
        Drawable localDrawable = this.mContext.getResources().getDrawable(this.abP);
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.GeN.setVisibility(0);
        break;
      }
      this.GeN.setVisibility(8);
      break;
      if (this.GeN.getDrawable() == null) {
        break label80;
      }
      this.GeN.getDrawable().clearColorFilter();
      break label80;
      localObject = (LinearLayout.LayoutParams)this.GeN.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.GeN.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label126;
      label880:
      this.GeM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label229;
      label894:
      this.GeL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label449;
      if (this.FGP != -1)
      {
        this.tto.setImageResource(this.FGP);
        break label583;
      }
      if (this.GeB == null) {
        break label583;
      }
      this.tto.setImageDrawable(this.GeB);
      break label583;
      this.lEA.setTextColor(this.context.getResources().getColor(2131100212));
      break label707;
      this.Gez.setTextColor(ao.aD(this.context, 2130968584));
      break label741;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142544);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494829, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(142544);
    return paramViewGroup;
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(142546);
    this.desc = paramString;
    if (this.lEA != null) {
      this.lEA.setText(paramString);
    }
    AppMethodBeat.o(142546);
  }
  
  public final void vQ(boolean paramBoolean)
  {
    AppMethodBeat.i(142551);
    this.GeP = paramBoolean;
    if (this.GeL != null)
    {
      if (paramBoolean)
      {
        this.GeL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.GeL.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        AppMethodBeat.o(142551);
        return;
      }
      this.GeL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    AppMethodBeat.o(142551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */