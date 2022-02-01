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
import com.tencent.mm.ui.aq;

public class IconPreference
  extends Preference
{
  private int JMO;
  private int JMP;
  private int JMQ;
  private ImageView JMR;
  private ViewGroup JMS;
  private TextView JMT;
  protected Drawable JMV;
  RelativeLayout.LayoutParams JMW;
  private int JMX;
  private int JMY;
  private int JMZ;
  private int JNa;
  private int JNb;
  private int JNc;
  private View JNd;
  private View JNe;
  private TextView JNf;
  private TextView JNg;
  protected ImageView JNh;
  public boolean JNi;
  private boolean JNj;
  public boolean JNk;
  private int JNl;
  public boolean JNm;
  public boolean JNn;
  protected int JnV;
  private Bitmap JrG;
  private boolean OAt;
  private Context context;
  private String desc;
  public Drawable drawable;
  private TextView gXb;
  private int height;
  protected View mView;
  protected ImageView vQs;
  private String xit;
  private String xiu;
  private int yUu;
  private int yUv;
  
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
    this.JnV = -1;
    this.vQs = null;
    this.xit = "";
    this.yUu = -1;
    this.yUv = 8;
    this.JMO = 8;
    this.JMX = 8;
    this.desc = "";
    this.xiu = "";
    this.JMY = -1;
    this.JMZ = 8;
    this.JNa = -1;
    this.JrG = null;
    this.JNb = 8;
    this.JMP = 0;
    this.JMQ = 8;
    this.JNc = 8;
    this.JMR = null;
    this.JMS = null;
    this.JNd = null;
    this.JNe = null;
    this.height = -1;
    this.JNj = false;
    this.JNk = false;
    this.JNl = -1;
    this.JNm = false;
    this.JNn = false;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142543);
  }
  
  public final void E(Drawable paramDrawable)
  {
    AppMethodBeat.i(182566);
    this.JMV = paramDrawable;
    this.JrG = null;
    this.JnV = -1;
    if (this.vQs != null) {
      this.vQs.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(182566);
  }
  
  public final void aI(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142553);
    this.JrG = paramBitmap;
    this.JnV = -1;
    this.JMV = null;
    if (this.vQs != null) {
      this.vQs.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(142553);
  }
  
  public final void aX(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142547);
    this.xiu = paramString;
    this.JMY = paramInt1;
    this.JNa = paramInt2;
    if (this.JNf != null)
    {
      this.JNf.setText(paramString);
      if (paramInt1 != -1) {
        this.JNf.setBackgroundDrawable(this.context.getResources().getDrawable(paramInt1));
      }
      if (paramInt2 != -1) {
        this.JNf.setTextColor(paramInt2);
      }
    }
    AppMethodBeat.o(142547);
  }
  
  public final void acS(int paramInt)
  {
    AppMethodBeat.i(142548);
    this.yUv = paramInt;
    if (this.JNg != null) {
      this.JNg.setVisibility(paramInt);
    }
    AppMethodBeat.o(142548);
  }
  
  public final void acT(int paramInt)
  {
    AppMethodBeat.i(142549);
    this.JMZ = paramInt;
    if (this.JNf != null) {
      this.JNf.setVisibility(paramInt);
    }
    AppMethodBeat.o(142549);
  }
  
  public final void acU(int paramInt)
  {
    AppMethodBeat.i(142552);
    this.JMO = paramInt;
    if (this.JMR != null) {
      this.JMR.setVisibility(paramInt);
    }
    AppMethodBeat.o(142552);
  }
  
  public final void acV(int paramInt)
  {
    AppMethodBeat.i(142554);
    this.JnV = paramInt;
    this.JrG = null;
    if (this.vQs != null) {
      this.vQs.setImageResource(paramInt);
    }
    AppMethodBeat.o(142554);
  }
  
  public final void acW(int paramInt)
  {
    AppMethodBeat.i(142555);
    this.JNb = paramInt;
    if (this.vQs != null) {
      this.vQs.setVisibility(this.JNb);
    }
    AppMethodBeat.o(142555);
  }
  
  public final void acX(int paramInt)
  {
    AppMethodBeat.i(142556);
    this.JMP = paramInt;
    if (this.JMS != null) {
      this.JMS.setVisibility(this.JMP);
    }
    AppMethodBeat.o(142556);
  }
  
  public final void acY(int paramInt)
  {
    AppMethodBeat.i(142557);
    this.JMQ = paramInt;
    if (this.JNd != null) {
      this.JNd.setVisibility(this.JMQ);
    }
    AppMethodBeat.o(142557);
  }
  
  public final void fDC()
  {
    AppMethodBeat.i(142550);
    this.JMX = 0;
    if (this.gXb != null) {
      this.gXb.setVisibility(0);
    }
    AppMethodBeat.o(142550);
  }
  
  public final ImageView fDD()
  {
    return this.vQs;
  }
  
  public final void gF(String paramString, int paramInt)
  {
    this.xit = paramString;
    this.yUu = paramInt;
  }
  
  public final void gG(String paramString, int paramInt)
  {
    AppMethodBeat.i(142545);
    aX(paramString, paramInt, this.JNa);
    AppMethodBeat.o(142545);
  }
  
  public final void jR(int paramInt1, int paramInt2)
  {
    this.JMO = paramInt1;
    this.JNl = paramInt2;
  }
  
  public final void jS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142558);
    this.JMW = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.JMW.addRule(13);
    if (this.vQs == null)
    {
      AppMethodBeat.o(142558);
      return;
    }
    this.vQs.setLayoutParams(this.JMW);
    AppMethodBeat.o(142558);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142559);
    super.onBindView(paramView);
    this.JNh = ((ImageView)paramView.findViewById(2131300943));
    label80:
    Object localObject1;
    label130:
    Object localObject2;
    label326:
    int i;
    if (this.JNh != null)
    {
      if (this.drawable != null)
      {
        this.JNh.setImageDrawable(this.drawable);
        this.JNh.setVisibility(0);
        if (this.FEh == 0) {
          break label932;
        }
        this.JNh.getDrawable().setColorFilter(this.FEh, PorterDuff.Mode.SRC_ATOP);
        if (!this.JNi) {
          break label955;
        }
        localObject1 = (LinearLayout.LayoutParams)this.JNh.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = aq.ay(this.mContext, 2131165289);
        ((LinearLayout.LayoutParams)localObject1).gravity = 48;
        this.JNh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      localObject1 = (LinearLayout)paramView.findViewById(2131302326);
      ((LinearLayout)localObject1).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131165488));
      if (this.OAt)
      {
        localObject2 = (LinearLayout)paramView.findViewById(2131297699);
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
      this.JNg = ((TextView)paramView.findViewById(2131305745));
      if (this.JNg != null)
      {
        if (!this.JNk) {
          break label992;
        }
        this.JNg.setCompoundDrawablesWithIntrinsicBounds(2131234447, 0, 0, 0);
        this.JNg.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        this.JNg.setVisibility(this.yUv);
        this.JNg.setText(this.xit);
        if (this.yUu != -1) {
          this.JNg.setBackgroundDrawable(this.context.getResources().getDrawable(this.yUu));
        }
      }
      if (!this.JNn) {
        break label1006;
      }
      i = 2131305746;
      label388:
      this.JNf = ((TextView)paramView.findViewById(i));
      if (this.JNf != null)
      {
        this.JNf.setVisibility(this.JMZ);
        this.JNf.setText(this.xiu);
        if (this.JMY != -1)
        {
          this.JNf.setBackgroundDrawable(this.context.getResources().getDrawable(this.JMY));
          if (this.JMY == 2131233430) {
            this.JNf.setTextSize(0, a.ay(this.context, 2131166950) * a.ip(this.context));
          }
        }
        if (this.JNa != -1) {
          this.JNf.setTextColor(this.JNa);
        }
        if (!this.JNj) {
          break label1013;
        }
        this.JNf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.JNf.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
      }
      label555:
      this.JMR = ((ImageView)paramView.findViewById(2131305740));
      this.JMR.setVisibility(this.JMO);
      if (this.JNl != -1) {
        this.JMR.setImageResource(this.JNl);
      }
      this.vQs = ((ImageView)paramView.findViewById(2131300959));
      this.JMS = ((ViewGroup)paramView.findViewById(2131304191));
      this.JNe = paramView.findViewById(2131304181);
      this.JNe.setVisibility(this.JNc);
      this.JNd = paramView.findViewById(2131304190);
      this.JNd.setVisibility(this.JMQ);
      if (this.JrG == null) {
        break label1027;
      }
      this.vQs.setImageBitmap(this.JrG);
      label689:
      this.vQs.setVisibility(this.JNb);
      this.JMS.setVisibility(this.JMP);
      if (this.JMW != null) {
        this.vQs.setLayoutParams(this.JMW);
      }
      this.JMT = ((TextView)paramView.findViewById(16908310));
      this.gXb = ((TextView)paramView.findViewById(2131298996));
      if (this.gXb != null)
      {
        this.gXb.setVisibility(this.JMX);
        this.gXb.setText(this.desc);
        if (!this.JNm) {
          break label1070;
        }
        this.gXb.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label813:
      if (this.JMT != null)
      {
        if (!this.JNm) {
          break label1093;
        }
        this.JMT.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label847:
      if (this.JNm) {
        break label1116;
      }
    }
    label932:
    label955:
    label1093:
    label1116:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      AppMethodBeat.o(142559);
      return;
      if (this.aeA != 0)
      {
        localObject1 = this.JNh;
        localObject2 = this.mContext.getResources().getDrawable(this.aeA);
        this.drawable = ((Drawable)localObject2);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        this.JNh.setVisibility(0);
        break;
      }
      this.JNh.setVisibility(8);
      break;
      if (this.JNh.getDrawable() == null) {
        break label80;
      }
      this.JNh.getDrawable().clearColorFilter();
      break label80;
      localObject1 = (LinearLayout.LayoutParams)this.JNh.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      this.JNh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break label130;
      label992:
      this.JNg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label326;
      label1006:
      i = 2131305747;
      break label388;
      label1013:
      this.JNf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label555;
      if (this.JnV != -1)
      {
        this.vQs.setImageResource(this.JnV);
        break label689;
      }
      if (this.JMV == null) {
        break label689;
      }
      this.vQs.setImageDrawable(this.JMV);
      break label689;
      this.gXb.setTextColor(this.context.getResources().getColor(2131100212));
      break label813;
      this.JMT.setTextColor(this.context.getResources().getColor(2131099732));
      break label847;
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
    if (this.gXb != null) {
      this.gXb.setText(paramString);
    }
    AppMethodBeat.o(142546);
  }
  
  public final void xM(boolean paramBoolean)
  {
    AppMethodBeat.i(142551);
    this.JNj = paramBoolean;
    if (this.JNf != null)
    {
      if (paramBoolean)
      {
        this.JNf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.JNf.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        AppMethodBeat.o(142551);
        return;
      }
      this.JNf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    AppMethodBeat.o(142551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */