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
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.at;

public class IconPreference
  extends Preference
{
  private String Bgn;
  private String Bgo;
  private int CZk;
  private int CZl;
  private Bitmap OBX;
  private int OXO;
  private int OXP;
  private int OXQ;
  private ImageView OXR;
  private ViewGroup OXS;
  private TextView OXT;
  protected Drawable OXV;
  RelativeLayout.LayoutParams OXW;
  private int OXX;
  private int OXY;
  private int OXZ;
  private int OYa;
  private int OYb;
  private int OYc;
  private View OYd;
  private View OYe;
  private TextView OYf;
  private TextView OYg;
  protected ImageView OYh;
  public boolean OYi;
  private boolean OYj;
  private boolean OYk;
  public boolean OYl;
  private int OYm;
  public boolean OYn;
  public boolean OYo;
  private boolean OYp;
  protected int OxP;
  private Context context;
  private String desc;
  public Drawable drawable;
  private TextView hPW;
  private int height;
  protected View mView;
  protected ImageView zkw;
  
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
    this.OxP = -1;
    this.zkw = null;
    this.Bgn = "";
    this.CZk = -1;
    this.CZl = 8;
    this.OXO = 8;
    this.OXX = 8;
    this.desc = "";
    this.Bgo = "";
    this.OXY = -1;
    this.OXZ = 8;
    this.OYa = -1;
    this.OBX = null;
    this.OYb = 8;
    this.OXP = 0;
    this.OXQ = 8;
    this.OYc = 8;
    this.OXR = null;
    this.OXS = null;
    this.OYd = null;
    this.OYe = null;
    this.height = -1;
    this.OYk = false;
    this.OYl = false;
    this.OYm = -1;
    this.OYn = false;
    this.OYo = false;
    this.OYp = false;
    this.context = paramContext;
    setLayoutResource(2131495538);
    AppMethodBeat.o(142543);
  }
  
  public final void BB(boolean paramBoolean)
  {
    AppMethodBeat.i(142551);
    this.OYk = paramBoolean;
    if (this.OYf != null)
    {
      if (paramBoolean)
      {
        this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131235385, 0);
        this.OYf.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165586));
        AppMethodBeat.o(142551);
        return;
      }
      this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    AppMethodBeat.o(142551);
  }
  
  public final void D(Drawable paramDrawable)
  {
    AppMethodBeat.i(182566);
    this.OXV = paramDrawable;
    this.OBX = null;
    this.OxP = -1;
    if (this.zkw != null) {
      this.zkw.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(182566);
  }
  
  public final void aL(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142553);
    this.OBX = paramBitmap;
    this.OxP = -1;
    this.OXV = null;
    if (this.zkw != null) {
      this.zkw.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(142553);
  }
  
  public final void aS(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142547);
    this.Bgo = paramString;
    this.OXY = paramInt1;
    this.OYa = paramInt2;
    if (this.OYf != null)
    {
      this.OYf.setText(paramString);
      if (paramInt1 != -1) {
        this.OYf.setBackgroundDrawable(this.context.getResources().getDrawable(paramInt1));
      }
      if (paramInt2 != -1) {
        this.OYf.setTextColor(paramInt2);
      }
    }
    AppMethodBeat.o(142547);
  }
  
  public final void alD(int paramInt)
  {
    AppMethodBeat.i(142548);
    this.CZl = paramInt;
    if (this.OYg != null) {
      this.OYg.setVisibility(paramInt);
    }
    AppMethodBeat.o(142548);
  }
  
  public final void alE(int paramInt)
  {
    AppMethodBeat.i(142549);
    this.OXZ = paramInt;
    if (this.OYf != null) {
      this.OYf.setVisibility(paramInt);
    }
    AppMethodBeat.o(142549);
  }
  
  public final void alF(int paramInt)
  {
    AppMethodBeat.i(142552);
    this.OXO = paramInt;
    if (this.OXR != null) {
      this.OXR.setVisibility(paramInt);
    }
    AppMethodBeat.o(142552);
  }
  
  public final void alG(int paramInt)
  {
    AppMethodBeat.i(142554);
    this.OxP = paramInt;
    this.OBX = null;
    if (this.zkw != null) {
      this.zkw.setImageResource(paramInt);
    }
    AppMethodBeat.o(142554);
  }
  
  public final void alH(int paramInt)
  {
    AppMethodBeat.i(142555);
    this.OYb = paramInt;
    if (this.zkw != null) {
      this.zkw.setVisibility(this.OYb);
    }
    AppMethodBeat.o(142555);
  }
  
  public final void alI(int paramInt)
  {
    AppMethodBeat.i(142556);
    this.OXP = paramInt;
    if (this.OXS != null) {
      this.OXS.setVisibility(this.OXP);
    }
    AppMethodBeat.o(142556);
  }
  
  public final void alJ(int paramInt)
  {
    AppMethodBeat.i(142557);
    this.OXQ = paramInt;
    if (this.OYd != null) {
      this.OYd.setVisibility(this.OXQ);
    }
    AppMethodBeat.o(142557);
  }
  
  public final void gLF()
  {
    AppMethodBeat.i(142550);
    this.OXX = 0;
    if (this.hPW != null) {
      this.hPW.setVisibility(0);
    }
    AppMethodBeat.o(142550);
  }
  
  public final ImageView gLG()
  {
    return this.zkw;
  }
  
  public final void gY(String paramString, int paramInt)
  {
    this.Bgn = paramString;
    this.CZk = paramInt;
  }
  
  public final void gZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(142545);
    aS(paramString, paramInt, this.OYa);
    AppMethodBeat.o(142545);
  }
  
  public final void la(int paramInt1, int paramInt2)
  {
    this.OXO = paramInt1;
    this.OYm = paramInt2;
  }
  
  public final void lb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142558);
    this.OXW = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.OXW.addRule(13);
    if (this.zkw == null)
    {
      AppMethodBeat.o(142558);
      return;
    }
    this.zkw.setLayoutParams(this.OXW);
    AppMethodBeat.o(142558);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142559);
    super.onBindView(paramView);
    this.OYh = ((ImageView)paramView.findViewById(2131302573));
    label82:
    Object localObject1;
    label132:
    Object localObject2;
    label326:
    int i;
    if (this.OYh != null)
    {
      if (this.drawable != null)
      {
        this.OYh.setImageDrawable(this.drawable);
        this.OYh.setVisibility(0);
        if (this.Kxl == 0) {
          break label965;
        }
        this.OYh.getDrawable().setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
        if (!this.OYi) {
          break label988;
        }
        localObject1 = (LinearLayout.LayoutParams)this.OYh.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = at.aH(this.mContext, 2131165296);
        ((LinearLayout.LayoutParams)localObject1).gravity = 48;
        this.OYh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      localObject1 = (LinearLayout)paramView.findViewById(2131304721);
      ((LinearLayout)localObject1).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131165506));
      if (this.OYj)
      {
        localObject2 = (LinearLayout)paramView.findViewById(2131307098);
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
      this.OYg = ((TextView)paramView.findViewById(2131309014));
      if (this.OYg != null)
      {
        if (!this.OYl) {
          break label1025;
        }
        this.OYg.setCompoundDrawablesWithIntrinsicBounds(2131235385, 0, 0, 0);
        this.OYg.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165586));
        this.OYg.setVisibility(this.CZl);
        this.OYg.setText(this.Bgn);
        if (this.CZk != -1) {
          this.OYg.setBackgroundDrawable(this.context.getResources().getDrawable(this.CZk));
        }
      }
      if (!this.OYo) {
        break label1039;
      }
      i = 2131309015;
      label388:
      this.OYf = ((TextView)paramView.findViewById(i));
      if (this.OYf != null)
      {
        this.OYf.setVisibility(this.OXZ);
        this.OYf.setText(this.Bgo);
        if (this.OXY != -1)
        {
          this.OYf.setBackgroundDrawable(this.context.getResources().getDrawable(this.OXY));
          if (this.OXY == 2131234232) {
            this.OYf.setTextSize(0, a.aH(this.context, 2131167085) * a.ji(this.context));
          }
        }
        if (this.OYa != -1) {
          this.OYf.setTextColor(this.OYa);
        }
        if (!this.OYk) {
          break label1046;
        }
        this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131235385, 0);
        this.OYf.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165586));
      }
      label553:
      this.OXR = ((ImageView)paramView.findViewById(2131309007));
      this.OXR.setVisibility(this.OXO);
      if (this.OYm != -1) {
        this.OXR.setImageResource(this.OYm);
      }
      this.zkw = ((ImageView)paramView.findViewById(2131302595));
      this.OXS = ((ViewGroup)paramView.findViewById(2131307104));
      this.OYe = paramView.findViewById(2131307090);
      this.OYe.setVisibility(this.OYc);
      this.OYd = paramView.findViewById(2131307102);
      this.OYd.setVisibility(this.OXQ);
      if (this.OBX == null) {
        break label1060;
      }
      this.zkw.setImageBitmap(this.OBX);
      label687:
      this.zkw.setVisibility(this.OYb);
      this.OXS.setVisibility(this.OXP);
      if (this.OXW != null) {
        this.zkw.setLayoutParams(this.OXW);
      }
      this.OXT = ((TextView)paramView.findViewById(16908310));
      this.hPW = ((TextView)paramView.findViewById(2131299495));
      if (this.hPW != null)
      {
        this.hPW.setVisibility(this.OXX);
        this.hPW.setText(this.desc);
        if (!this.OYn) {
          break label1103;
        }
        this.hPW.setTextColor(this.context.getResources().getColor(2131100283));
      }
      label811:
      if (this.OXT != null)
      {
        if (!this.OYn) {
          break label1126;
        }
        this.OXT.setTextColor(this.context.getResources().getColor(2131100283));
      }
      label845:
      if (this.OYn) {
        break label1149;
      }
    }
    label965:
    label988:
    label1126:
    label1149:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      if ((this.OYp) && (this.OXT != null)) {
        this.OXT.setTextColor(this.OXT.getResources().getColor(2131100283));
      }
      AppMethodBeat.o(142559);
      return;
      if (this.aeN != 0)
      {
        localObject1 = this.OYh;
        localObject2 = this.mContext.getResources().getDrawable(this.aeN);
        this.drawable = ((Drawable)localObject2);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        this.OYh.setVisibility(0);
        break;
      }
      this.OYh.setVisibility(8);
      break;
      if (this.OYh.getDrawable() == null) {
        break label82;
      }
      this.OYh.getDrawable().clearColorFilter();
      break label82;
      localObject1 = (LinearLayout.LayoutParams)this.OYh.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      this.OYh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break label132;
      this.OYg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label326;
      i = 2131309016;
      break label388;
      this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label553;
      if (this.OxP != -1)
      {
        this.zkw.setImageResource(this.OxP);
        break label687;
      }
      if (this.OXV == null) {
        break label687;
      }
      this.zkw.setImageDrawable(this.OXV);
      break label687;
      this.hPW.setTextColor(this.context.getResources().getColor(2131100245));
      break label811;
      this.OXT.setTextColor(this.context.getResources().getColor(2131099746));
      break label845;
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142544);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495564, localViewGroup);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(142544);
    return paramViewGroup;
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(142546);
    this.desc = paramString;
    if (this.hPW != null) {
      this.hPW.setText(paramString);
    }
    AppMethodBeat.o(142546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */