package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
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

public class IconPreference
  extends Preference
{
  private Context context;
  private String desc;
  public Drawable drawable;
  private int height;
  private TextView hsI;
  private View mView;
  protected ImageView oyN;
  private String pAS;
  private String pAT;
  private int qGe;
  private int qGf;
  protected int yUb;
  private Bitmap yXe;
  private int zqL;
  private int zqM;
  private int zqN;
  private ImageView zqO;
  private ViewGroup zqP;
  private TextView zqQ;
  RelativeLayout.LayoutParams zqS;
  private int zqT;
  private int zqU;
  private int zqV;
  private int zqW;
  private int zqX;
  private int zqY;
  private View zqZ;
  private View zra;
  private TextView zrb;
  private TextView zrc;
  protected ImageView zrd;
  private boolean zre;
  public boolean zrf;
  private int zrg;
  public boolean zrh;
  
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
    AppMethodBeat.i(107166);
    this.yUb = -1;
    this.oyN = null;
    this.pAS = "";
    this.qGe = -1;
    this.qGf = 8;
    this.zqL = 8;
    this.zqT = 8;
    this.desc = "";
    this.pAT = "";
    this.zqU = -1;
    this.zqV = 8;
    this.zqW = -1;
    this.yXe = null;
    this.zqX = 8;
    this.zqM = 0;
    this.zqN = 8;
    this.zqY = 8;
    this.zqO = null;
    this.zqP = null;
    this.zqZ = null;
    this.zra = null;
    this.height = -1;
    this.zre = false;
    this.zrf = false;
    this.zrg = -1;
    this.zrh = false;
    this.context = paramContext;
    setLayoutResource(2130970179);
    AppMethodBeat.o(107166);
  }
  
  public final void OL(int paramInt)
  {
    AppMethodBeat.i(107171);
    this.qGf = paramInt;
    if (this.zrc != null) {
      this.zrc.setVisibility(paramInt);
    }
    AppMethodBeat.o(107171);
  }
  
  public final void OM(int paramInt)
  {
    AppMethodBeat.i(107172);
    this.zqV = paramInt;
    if (this.zrb != null) {
      this.zrb.setVisibility(paramInt);
    }
    AppMethodBeat.o(107172);
  }
  
  public final void ON(int paramInt)
  {
    AppMethodBeat.i(107175);
    this.zqL = paramInt;
    if (this.zqO != null) {
      this.zqO.setVisibility(paramInt);
    }
    AppMethodBeat.o(107175);
  }
  
  public final void OO(int paramInt)
  {
    AppMethodBeat.i(107177);
    this.yUb = paramInt;
    this.yXe = null;
    if (this.oyN != null) {
      this.oyN.setImageResource(paramInt);
    }
    AppMethodBeat.o(107177);
  }
  
  public final void OP(int paramInt)
  {
    AppMethodBeat.i(107178);
    this.zqX = paramInt;
    if (this.oyN != null) {
      this.oyN.setVisibility(this.zqX);
    }
    AppMethodBeat.o(107178);
  }
  
  public final void OQ(int paramInt)
  {
    AppMethodBeat.i(107179);
    this.zqM = paramInt;
    if (this.zqP != null) {
      this.zqP.setVisibility(this.zqM);
    }
    AppMethodBeat.o(107179);
  }
  
  public final void OR(int paramInt)
  {
    AppMethodBeat.i(107180);
    this.zqN = paramInt;
    if (this.zqZ != null) {
      this.zqZ.setVisibility(this.zqN);
    }
    AppMethodBeat.o(107180);
  }
  
  public final void aG(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107170);
    this.pAT = paramString;
    this.zqU = paramInt1;
    this.zqW = paramInt2;
    if (this.zrb != null)
    {
      this.zrb.setText(paramString);
      if (paramInt1 != -1) {
        this.zrb.setBackgroundDrawable(this.context.getResources().getDrawable(paramInt1));
      }
      if (paramInt2 != -1) {
        this.zrb.setTextColor(paramInt2);
      }
    }
    AppMethodBeat.o(107170);
  }
  
  public final void ap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(107176);
    this.yXe = paramBitmap;
    this.yUb = -1;
    if (this.oyN != null) {
      this.oyN.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(107176);
  }
  
  public final void dEJ()
  {
    AppMethodBeat.i(107173);
    this.zqT = 0;
    if (this.hsI != null) {
      this.hsI.setVisibility(0);
    }
    AppMethodBeat.o(107173);
  }
  
  public final ImageView dEK()
  {
    return this.oyN;
  }
  
  public final void eN(String paramString, int paramInt)
  {
    this.pAS = paramString;
    this.qGe = paramInt;
  }
  
  public final void eO(String paramString, int paramInt)
  {
    AppMethodBeat.i(107168);
    aG(paramString, paramInt, this.zqW);
    AppMethodBeat.o(107168);
  }
  
  public final void hB(int paramInt1, int paramInt2)
  {
    this.zqL = paramInt1;
    this.zrg = paramInt2;
  }
  
  public final void hC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107181);
    this.zqS = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.zqS.addRule(13);
    if (this.oyN == null)
    {
      AppMethodBeat.o(107181);
      return;
    }
    this.oyN.setLayoutParams(this.zqS);
    AppMethodBeat.o(107181);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(107182);
    super.onBindView(paramView);
    this.zrd = ((ImageView)paramView.findViewById(2131822243));
    label80:
    Object localObject;
    if (this.zrd != null)
    {
      if (this.drawable != null)
      {
        this.zrd.setImageDrawable(this.drawable);
        this.zrd.setVisibility(0);
        if (this.zsg == 0) {
          break label778;
        }
        this.zrd.getDrawable().setColorFilter(this.zsg, PorterDuff.Mode.SRC_ATOP);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(2131822408);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131427780));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.zrc = ((TextView)paramView.findViewById(2131822409));
      if (this.zrc != null)
      {
        if (!this.zrf) {
          break label801;
        }
        this.zrc.setCompoundDrawablesWithIntrinsicBounds(2130840641, 0, 0, 0);
        this.zrc.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131427854));
        label183:
        this.zrc.setVisibility(this.qGf);
        this.zrc.setText(this.pAS);
        if (this.qGe != -1) {
          this.zrc.setBackgroundDrawable(this.context.getResources().getDrawable(this.qGe));
        }
      }
      this.zrb = ((TextView)paramView.findViewById(2131822411));
      if (this.zrb != null)
      {
        this.zrb.setVisibility(this.zqV);
        this.zrb.setText(this.pAT);
        if (this.zqU != -1)
        {
          this.zrb.setBackgroundDrawable(this.context.getResources().getDrawable(this.zqU));
          if (this.zqU == 2130839787) {
            this.zrb.setTextSize(0, a.ap(this.context, 2131428776) * a.gr(this.context));
          }
        }
        if (this.zqW != -1) {
          this.zrb.setTextColor(this.zqW);
        }
        if (!this.zre) {
          break label815;
        }
        this.zrb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840641, 0);
        this.zrb.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131427854));
      }
      label403:
      this.zqO = ((ImageView)paramView.findViewById(2131822410));
      this.zqO.setVisibility(this.zqL);
      if (this.zrg != -1) {
        this.zqO.setImageResource(this.zrg);
      }
      this.oyN = ((ImageView)paramView.findViewById(2131822413));
      this.zqP = ((ViewGroup)paramView.findViewById(2131822412));
      this.zra = paramView.findViewById(2131822415);
      this.zra.setVisibility(this.zqY);
      this.zqZ = paramView.findViewById(2131822414);
      this.zqZ.setVisibility(this.zqN);
      if (this.yXe == null) {
        break label829;
      }
      this.oyN.setImageBitmap(this.yXe);
      label537:
      this.oyN.setVisibility(this.zqX);
      this.zqP.setVisibility(this.zqM);
      if (this.zqS != null) {
        this.oyN.setLayoutParams(this.zqS);
      }
      this.zqQ = ((TextView)paramView.findViewById(16908310));
      this.hsI = ((TextView)paramView.findViewById(2131821115));
      if (this.hsI != null)
      {
        this.hsI.setVisibility(this.zqT);
        this.hsI.setText(this.desc);
        if (!this.zrh) {
          break label851;
        }
        this.hsI.setTextColor(this.context.getResources().getColor(2131689963));
      }
      label661:
      if (this.zqQ != null)
      {
        if (!this.zrh) {
          break label874;
        }
        this.zqQ.setTextColor(this.context.getResources().getColor(2131689963));
      }
      label695:
      if (this.zrh) {
        break label897;
      }
    }
    label897:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      AppMethodBeat.o(107182);
      return;
      if (this.UM != 0)
      {
        localObject = this.zrd;
        Drawable localDrawable = this.mContext.getResources().getDrawable(this.UM);
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.zrd.setVisibility(0);
        break;
      }
      this.zrd.setVisibility(8);
      break;
      label778:
      if (this.zrd.getDrawable() == null) {
        break label80;
      }
      this.zrd.getDrawable().clearColorFilter();
      break label80;
      label801:
      this.zrc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label183;
      label815:
      this.zrb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label403;
      label829:
      if (this.yUb == -1) {
        break label537;
      }
      this.oyN.setImageResource(this.yUb);
      break label537;
      label851:
      this.hsI.setTextColor(this.context.getResources().getColor(2131690168));
      break label661;
      label874:
      this.zqQ.setTextColor(this.context.getResources().getColor(2131690322));
      break label695;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107167);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970203, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(107167);
    return paramViewGroup;
  }
  
  public final void qI(boolean paramBoolean)
  {
    AppMethodBeat.i(107174);
    this.zre = paramBoolean;
    if (this.zrb != null)
    {
      if (paramBoolean)
      {
        this.zrb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840641, 0);
        this.zrb.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131427854));
        AppMethodBeat.o(107174);
        return;
      }
      this.zrb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    AppMethodBeat.o(107174);
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(107169);
    this.desc = paramString;
    if (this.hsI != null) {
      this.hsI.setText(paramString);
    }
    AppMethodBeat.o(107169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */