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
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.ao;

public class IconPreference
  extends Preference
{
  private TextView HEA;
  private TextView HEB;
  protected ImageView HEC;
  public boolean HED;
  private boolean HEE;
  public boolean HEF;
  private int HEG;
  public boolean HEH;
  private int HEj;
  private int HEk;
  private int HEl;
  private ImageView HEm;
  private ViewGroup HEn;
  private TextView HEo;
  protected Drawable HEq;
  RelativeLayout.LayoutParams HEr;
  private int HEs;
  private int HEt;
  private int HEu;
  private int HEv;
  private int HEw;
  private int HEx;
  private View HEy;
  private View HEz;
  protected int HfX;
  private Bitmap Hjr;
  private Context context;
  private String desc;
  public Drawable drawable;
  private TextView gAI;
  private int height;
  private View mView;
  protected ImageView uBH;
  private String vLt;
  private String vLu;
  private int xpM;
  private int xpN;
  
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
    this.HfX = -1;
    this.uBH = null;
    this.vLt = "";
    this.xpM = -1;
    this.xpN = 8;
    this.HEj = 8;
    this.HEs = 8;
    this.desc = "";
    this.vLu = "";
    this.HEt = -1;
    this.HEu = 8;
    this.HEv = -1;
    this.Hjr = null;
    this.HEw = 8;
    this.HEk = 0;
    this.HEl = 8;
    this.HEx = 8;
    this.HEm = null;
    this.HEn = null;
    this.HEy = null;
    this.HEz = null;
    this.height = -1;
    this.HEE = false;
    this.HEF = false;
    this.HEG = -1;
    this.HEH = false;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142543);
  }
  
  public final void D(Drawable paramDrawable)
  {
    AppMethodBeat.i(182566);
    this.HEq = paramDrawable;
    this.Hjr = null;
    this.HfX = -1;
    if (this.uBH != null) {
      this.uBH.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(182566);
  }
  
  public final void aF(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142553);
    this.Hjr = paramBitmap;
    this.HfX = -1;
    this.HEq = null;
    if (this.uBH != null) {
      this.uBH.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(142553);
  }
  
  public final void aQ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142547);
    this.vLu = paramString;
    this.HEt = paramInt1;
    this.HEv = paramInt2;
    if (this.HEA != null)
    {
      this.HEA.setText(paramString);
      if (paramInt1 != -1) {
        this.HEA.setBackgroundDrawable(this.context.getResources().getDrawable(paramInt1));
      }
      if (paramInt2 != -1) {
        this.HEA.setTextColor(paramInt2);
      }
    }
    AppMethodBeat.o(142547);
  }
  
  public final void aab(int paramInt)
  {
    AppMethodBeat.i(142548);
    this.xpN = paramInt;
    if (this.HEB != null) {
      this.HEB.setVisibility(paramInt);
    }
    AppMethodBeat.o(142548);
  }
  
  public final void aac(int paramInt)
  {
    AppMethodBeat.i(142549);
    this.HEu = paramInt;
    if (this.HEA != null) {
      this.HEA.setVisibility(paramInt);
    }
    AppMethodBeat.o(142549);
  }
  
  public final void aad(int paramInt)
  {
    AppMethodBeat.i(142552);
    this.HEj = paramInt;
    if (this.HEm != null) {
      this.HEm.setVisibility(paramInt);
    }
    AppMethodBeat.o(142552);
  }
  
  public final void aae(int paramInt)
  {
    AppMethodBeat.i(142554);
    this.HfX = paramInt;
    this.Hjr = null;
    if (this.uBH != null) {
      this.uBH.setImageResource(paramInt);
    }
    AppMethodBeat.o(142554);
  }
  
  public final void aaf(int paramInt)
  {
    AppMethodBeat.i(142555);
    this.HEw = paramInt;
    if (this.uBH != null) {
      this.uBH.setVisibility(this.HEw);
    }
    AppMethodBeat.o(142555);
  }
  
  public final void aag(int paramInt)
  {
    AppMethodBeat.i(142556);
    this.HEk = paramInt;
    if (this.HEn != null) {
      this.HEn.setVisibility(this.HEk);
    }
    AppMethodBeat.o(142556);
  }
  
  public final void aah(int paramInt)
  {
    AppMethodBeat.i(142557);
    this.HEl = paramInt;
    if (this.HEy != null) {
      this.HEy.setVisibility(this.HEl);
    }
    AppMethodBeat.o(142557);
  }
  
  public final void fZ(String paramString, int paramInt)
  {
    this.vLt = paramString;
    this.xpM = paramInt;
  }
  
  public final void fjl()
  {
    AppMethodBeat.i(142550);
    this.HEs = 0;
    if (this.gAI != null) {
      this.gAI.setVisibility(0);
    }
    AppMethodBeat.o(142550);
  }
  
  public final ImageView fjm()
  {
    return this.uBH;
  }
  
  public final void ga(String paramString, int paramInt)
  {
    AppMethodBeat.i(142545);
    aQ(paramString, paramInt, this.HEv);
    AppMethodBeat.o(142545);
  }
  
  public final void jB(int paramInt1, int paramInt2)
  {
    this.HEj = paramInt1;
    this.HEG = paramInt2;
  }
  
  public final void jC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142558);
    this.HEr = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.HEr.addRule(13);
    if (this.uBH == null)
    {
      AppMethodBeat.o(142558);
      return;
    }
    this.uBH.setLayoutParams(this.HEr);
    AppMethodBeat.o(142558);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142559);
    super.onBindView(paramView);
    this.HEC = ((ImageView)paramView.findViewById(2131300943));
    label80:
    Object localObject;
    if (this.HEC != null)
    {
      if (this.drawable != null)
      {
        this.HEC.setImageDrawable(this.drawable);
        this.HEC.setVisibility(0);
        if (this.DGC == 0) {
          break label824;
        }
        this.HEC.getDrawable().setColorFilter(this.DGC, PorterDuff.Mode.SRC_ATOP);
        if (!this.HED) {
          break label847;
        }
        localObject = (LinearLayout.LayoutParams)this.HEC.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ao.av(this.mContext, 2131165289);
        ((LinearLayout.LayoutParams)localObject).gravity = 48;
        this.HEC.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
      this.HEB = ((TextView)paramView.findViewById(2131305745));
      if (this.HEB != null)
      {
        if (!this.HEF) {
          break label880;
        }
        this.HEB.setCompoundDrawablesWithIntrinsicBounds(2131234447, 0, 0, 0);
        this.HEB.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        label229:
        this.HEB.setVisibility(this.xpN);
        this.HEB.setText(this.vLt);
        if (this.xpM != -1) {
          this.HEB.setBackgroundDrawable(this.context.getResources().getDrawable(this.xpM));
        }
      }
      this.HEA = ((TextView)paramView.findViewById(2131305747));
      if (this.HEA != null)
      {
        this.HEA.setVisibility(this.HEu);
        this.HEA.setText(this.vLu);
        if (this.HEt != -1)
        {
          this.HEA.setBackgroundDrawable(this.context.getResources().getDrawable(this.HEt));
          if (this.HEt == 2131233430) {
            this.HEA.setTextSize(0, a.av(this.context, 2131166950) * a.ib(this.context));
          }
        }
        if (this.HEv != -1) {
          this.HEA.setTextColor(this.HEv);
        }
        if (!this.HEE) {
          break label894;
        }
        this.HEA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.HEA.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
      }
      label449:
      this.HEm = ((ImageView)paramView.findViewById(2131305740));
      this.HEm.setVisibility(this.HEj);
      if (this.HEG != -1) {
        this.HEm.setImageResource(this.HEG);
      }
      this.uBH = ((ImageView)paramView.findViewById(2131300959));
      this.HEn = ((ViewGroup)paramView.findViewById(2131304191));
      this.HEz = paramView.findViewById(2131304181);
      this.HEz.setVisibility(this.HEx);
      this.HEy = paramView.findViewById(2131304190);
      this.HEy.setVisibility(this.HEl);
      if (this.Hjr == null) {
        break label908;
      }
      this.uBH.setImageBitmap(this.Hjr);
      label583:
      this.uBH.setVisibility(this.HEw);
      this.HEn.setVisibility(this.HEk);
      if (this.HEr != null) {
        this.uBH.setLayoutParams(this.HEr);
      }
      this.HEo = ((TextView)paramView.findViewById(16908310));
      this.gAI = ((TextView)paramView.findViewById(2131298996));
      if (this.gAI != null)
      {
        this.gAI.setVisibility(this.HEs);
        this.gAI.setText(this.desc);
        if (!this.HEH) {
          break label951;
        }
        this.gAI.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label707:
      if (this.HEo != null)
      {
        if (!this.HEH) {
          break label974;
        }
        this.HEo.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label741:
      if (this.HEH) {
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
      if (this.acJ != 0)
      {
        localObject = this.HEC;
        Drawable localDrawable = this.mContext.getResources().getDrawable(this.acJ);
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.HEC.setVisibility(0);
        break;
      }
      this.HEC.setVisibility(8);
      break;
      if (this.HEC.getDrawable() == null) {
        break label80;
      }
      this.HEC.getDrawable().clearColorFilter();
      break label80;
      localObject = (LinearLayout.LayoutParams)this.HEC.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.HEC.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label126;
      label880:
      this.HEB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label229;
      label894:
      this.HEA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label449;
      if (this.HfX != -1)
      {
        this.uBH.setImageResource(this.HfX);
        break label583;
      }
      if (this.HEq == null) {
        break label583;
      }
      this.uBH.setImageDrawable(this.HEq);
      break label583;
      this.gAI.setTextColor(this.context.getResources().getColor(2131100212));
      break label707;
      this.HEo.setTextColor(ao.aJ(this.context, 2130968584));
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
    if (this.gAI != null) {
      this.gAI.setText(paramString);
    }
    AppMethodBeat.o(142546);
  }
  
  public final void wU(boolean paramBoolean)
  {
    AppMethodBeat.i(142551);
    this.HEE = paramBoolean;
    if (this.HEA != null)
    {
      if (paramBoolean)
      {
        this.HEA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.HEA.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        AppMethodBeat.o(142551);
        return;
      }
      this.HEA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    AppMethodBeat.o(142551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */