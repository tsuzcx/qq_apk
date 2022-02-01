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
import com.tencent.mm.ci.a;
import com.tencent.mm.ui.aw;

public class IconPreference
  extends Preference
{
  protected ImageView EPM;
  private String GRG;
  private int GRH;
  private int GRI;
  protected TextView GRL;
  private String GZW;
  protected int VQS;
  private Bitmap VVp;
  private int WqY;
  private int WqZ;
  private int Wra;
  private ImageView Wrb;
  private ViewGroup Wrc;
  private TextView Wrd;
  protected Drawable Wrf;
  RelativeLayout.LayoutParams Wrg;
  private int Wrh;
  private int Wri;
  private int Wrj;
  private int Wrk;
  private int Wrl;
  private int Wrm;
  private View Wrn;
  private View Wro;
  private TextView Wrp;
  private ImageView Wrq;
  public boolean Wrr;
  private boolean Wrs;
  private boolean Wrt;
  public boolean Wru;
  private int Wrv;
  public boolean Wrw;
  public boolean Wrx;
  private boolean Wry;
  private Context context;
  private String desc;
  public Drawable drawable;
  private int height;
  private TextView kEs;
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
    this.VQS = -1;
    this.EPM = null;
    this.GRG = "";
    this.GRH = -1;
    this.GRI = 8;
    this.WqY = 8;
    this.Wrh = 8;
    this.desc = "";
    this.GZW = "";
    this.Wri = -1;
    this.Wrj = 8;
    this.Wrk = -1;
    this.VVp = null;
    this.Wrl = 8;
    this.WqZ = 8;
    this.Wra = 8;
    this.Wrm = 8;
    this.Wrb = null;
    this.Wrc = null;
    this.Wrn = null;
    this.Wro = null;
    this.height = -1;
    this.Wrt = false;
    this.Wru = false;
    this.Wrv = -1;
    this.Wrw = false;
    this.Wrx = false;
    this.Wry = false;
    this.context = paramContext;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142543);
  }
  
  public final void FT(boolean paramBoolean)
  {
    AppMethodBeat.i(142551);
    this.Wrt = paramBoolean;
    if (this.Wrp != null)
    {
      if (paramBoolean)
      {
        this.Wrp.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.unread_dot_shape, 0);
        this.Wrp.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.SmallPadding));
        AppMethodBeat.o(142551);
        return;
      }
      this.Wrp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    AppMethodBeat.o(142551);
  }
  
  public final void J(Drawable paramDrawable)
  {
    AppMethodBeat.i(182566);
    this.Wrf = paramDrawable;
    this.VVp = null;
    this.VQS = -1;
    if (this.EPM != null) {
      this.EPM.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(182566);
  }
  
  public final void aK(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142553);
    this.VVp = paramBitmap;
    this.VQS = -1;
    this.Wrf = null;
    if (this.EPM != null) {
      this.EPM.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(142553);
  }
  
  public final void aU(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142547);
    this.GZW = paramString;
    this.Wri = paramInt1;
    this.Wrk = paramInt2;
    if (this.Wrp != null)
    {
      this.Wrp.setText(paramString);
      if (paramInt1 != -1) {
        this.Wrp.setBackgroundDrawable(this.context.getResources().getDrawable(paramInt1));
      }
      if (paramInt2 != -1) {
        this.Wrp.setTextColor(paramInt2);
      }
    }
    AppMethodBeat.o(142547);
  }
  
  public void aak(int paramInt)
  {
    AppMethodBeat.i(142552);
    this.WqY = paramInt;
    if (this.Wrb != null) {
      this.Wrb.setVisibility(paramInt);
    }
    AppMethodBeat.o(142552);
  }
  
  public final void abe(int paramInt)
  {
    AppMethodBeat.i(142548);
    this.GRI = paramInt;
    if (this.GRL != null) {
      this.GRL.setVisibility(paramInt);
    }
    AppMethodBeat.o(142548);
  }
  
  public final void auD(int paramInt)
  {
    AppMethodBeat.i(142549);
    this.Wrj = paramInt;
    if (this.Wrp != null) {
      this.Wrp.setVisibility(paramInt);
    }
    AppMethodBeat.o(142549);
  }
  
  public final void auE(int paramInt)
  {
    AppMethodBeat.i(142554);
    this.VQS = paramInt;
    this.VVp = null;
    if (this.EPM != null) {
      this.EPM.setImageResource(paramInt);
    }
    AppMethodBeat.o(142554);
  }
  
  public final void auF(int paramInt)
  {
    AppMethodBeat.i(142555);
    this.Wrl = paramInt;
    if (this.EPM != null) {
      this.EPM.setVisibility(this.Wrl);
    }
    AppMethodBeat.o(142555);
  }
  
  public final void auG(int paramInt)
  {
    AppMethodBeat.i(142556);
    this.WqZ = paramInt;
    if (this.Wrc != null) {
      this.Wrc.setVisibility(this.WqZ);
    }
    AppMethodBeat.o(142556);
  }
  
  public final void auH(int paramInt)
  {
    AppMethodBeat.i(142557);
    this.Wra = paramInt;
    if (this.Wrn != null) {
      this.Wrn.setVisibility(this.Wra);
    }
    AppMethodBeat.o(142557);
  }
  
  public final void fC(String paramString, int paramInt)
  {
    this.GRG = paramString;
    this.GRH = paramInt;
  }
  
  public final void hH(String paramString, int paramInt)
  {
    AppMethodBeat.i(220176);
    this.GRG = paramString;
    this.GRH = paramInt;
    if (this.GRL != null)
    {
      if (this.GRG != null) {
        this.GRL.setText(this.GRG);
      }
      if (this.GRH != -1) {
        this.GRL.setBackgroundDrawable(this.context.getResources().getDrawable(this.GRH));
      }
    }
    AppMethodBeat.o(220176);
  }
  
  public final void hI(String paramString, int paramInt)
  {
    AppMethodBeat.i(142545);
    aU(paramString, paramInt, this.Wrk);
    AppMethodBeat.o(142545);
  }
  
  protected final View hKH()
  {
    AppMethodBeat.i(220169);
    if (this.mView == null)
    {
      AppMethodBeat.o(220169);
      return null;
    }
    View localView = this.mView.findViewById(16908312);
    AppMethodBeat.o(220169);
    return localView;
  }
  
  public final void hKI()
  {
    AppMethodBeat.i(142550);
    this.Wrh = 0;
    if (this.kEs != null) {
      this.kEs.setVisibility(0);
    }
    AppMethodBeat.o(142550);
  }
  
  public final ImageView hKJ()
  {
    return this.EPM;
  }
  
  public final ImageView hKK()
  {
    return this.Wrq;
  }
  
  public final void mt(int paramInt1, int paramInt2)
  {
    this.WqY = paramInt1;
    this.Wrv = paramInt2;
  }
  
  public final void mu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142558);
    this.Wrg = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.Wrg.addRule(13);
    if (this.EPM == null)
    {
      AppMethodBeat.o(142558);
      return;
    }
    this.EPM.setLayoutParams(this.Wrg);
    AppMethodBeat.o(142558);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142559);
    super.onBindView(paramView);
    this.Wrq = ((ImageView)paramView.findViewById(a.g.image_iv));
    label82:
    Object localObject1;
    label132:
    Object localObject2;
    label328:
    int i;
    if (this.Wrq != null)
    {
      if (this.drawable != null)
      {
        this.Wrq.setImageDrawable(this.drawable);
        this.Wrq.setVisibility(0);
        if (hKV() == 0) {
          break label969;
        }
        this.Wrq.getDrawable().setColorFilter(hKV(), PorterDuff.Mode.SRC_ATOP);
        if (!this.Wrr) {
          break label992;
        }
        localObject1 = (LinearLayout.LayoutParams)this.Wrq.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = aw.aZ(this.mContext, a.e.Edge_2A);
        ((LinearLayout.LayoutParams)localObject1).gravity = 48;
        this.Wrq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      localObject1 = (LinearLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      ((LinearLayout)localObject1).setMinimumHeight(paramView.getResources().getDimensionPixelSize(a.e.ListItemHeight));
      if (this.Wrs)
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
      this.GRL = ((TextView)paramView.findViewById(a.g.text_tv_one));
      if (this.GRL != null)
      {
        if (!this.Wru) {
          break label1029;
        }
        this.GRL.setCompoundDrawablesWithIntrinsicBounds(a.f.unread_dot_shape, 0, 0, 0);
        this.GRL.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.SmallPadding));
        this.GRL.setVisibility(this.GRI);
        this.GRL.setText(this.GRG);
        if (this.GRH != -1) {
          this.GRL.setBackgroundDrawable(this.context.getResources().getDrawable(this.GRH));
        }
      }
      if (!this.Wrx) {
        break label1043;
      }
      i = a.g.text_tv_right;
      label390:
      this.Wrp = ((TextView)paramView.findViewById(i));
      if (this.Wrp != null)
      {
        this.Wrp.setVisibility(this.Wrj);
        this.Wrp.setText(this.GZW);
        if (this.Wri != -1)
        {
          this.Wrp.setBackgroundDrawable(this.context.getResources().getDrawable(this.Wri));
          if (this.Wri == a.f.new_tips_bg) {
            this.Wrp.setTextSize(0, a.aZ(this.context, a.e.unReadNewTextSize) * a.km(this.context));
          }
        }
        if (this.Wrk != -1) {
          this.Wrp.setTextColor(this.Wrk);
        }
        if (!this.Wrt) {
          break label1050;
        }
        this.Wrp.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.unread_dot_shape, 0);
        this.Wrp.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.SmallPadding));
      }
      label557:
      this.Wrb = ((ImageView)paramView.findViewById(a.g.text_prospect));
      this.Wrb.setVisibility(this.WqY);
      if (this.Wrv != -1) {
        this.Wrb.setImageResource(this.Wrv);
      }
      this.EPM = ((ImageView)paramView.findViewById(a.g.image_right_iv));
      this.Wrc = ((ViewGroup)paramView.findViewById(a.g.right_rl));
      this.Wro = paramView.findViewById(a.g.right_center_prospect);
      this.Wro.setVisibility(this.Wrm);
      this.Wrn = paramView.findViewById(a.g.right_prospect);
      this.Wrn.setVisibility(this.Wra);
      if (this.VVp == null) {
        break label1064;
      }
      this.EPM.setImageBitmap(this.VVp);
      label691:
      this.EPM.setVisibility(this.Wrl);
      this.Wrc.setVisibility(this.WqZ);
      if (this.Wrg != null) {
        this.EPM.setLayoutParams(this.Wrg);
      }
      this.Wrd = ((TextView)paramView.findViewById(16908310));
      this.kEs = ((TextView)paramView.findViewById(a.g.desc));
      if (this.kEs != null)
      {
        this.kEs.setVisibility(this.Wrh);
        this.kEs.setText(this.desc);
        if (!this.Wrw) {
          break label1107;
        }
        this.kEs.setTextColor(this.context.getResources().getColor(a.d.disable_text_color));
      }
      label815:
      if (this.Wrd != null)
      {
        if (!this.Wrw) {
          break label1130;
        }
        this.Wrd.setTextColor(this.context.getResources().getColor(a.d.disable_text_color));
      }
      label849:
      if (this.Wrw) {
        break label1153;
      }
    }
    label1153:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      if ((this.Wry) && (this.Wrd != null)) {
        this.Wrd.setTextColor(this.Wrd.getResources().getColor(a.d.disable_text_color));
      }
      AppMethodBeat.o(142559);
      return;
      if (cMV() != 0)
      {
        localObject1 = this.Wrq;
        localObject2 = this.mContext.getResources().getDrawable(cMV());
        this.drawable = ((Drawable)localObject2);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        this.Wrq.setVisibility(0);
        break;
      }
      this.Wrq.setVisibility(8);
      break;
      label969:
      if (this.Wrq.getDrawable() == null) {
        break label82;
      }
      this.Wrq.getDrawable().clearColorFilter();
      break label82;
      label992:
      localObject1 = (LinearLayout.LayoutParams)this.Wrq.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      this.Wrq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break label132;
      label1029:
      this.GRL.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label328;
      label1043:
      i = a.g.text_tv_two;
      break label390;
      label1050:
      this.Wrp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label557;
      label1064:
      if (this.VQS != -1)
      {
        this.EPM.setImageResource(this.VQS);
        break label691;
      }
      if (this.Wrf == null) {
        break label691;
      }
      this.EPM.setImageDrawable(this.Wrf);
      break label691;
      label1107:
      this.kEs.setTextColor(this.context.getResources().getColor(a.d.desc_text_color));
      break label815;
      label1130:
      this.Wrd.setTextColor(this.context.getResources().getColor(a.d.FG_0));
      break label849;
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
    paramViewGroup = this.mView;
    AppMethodBeat.o(142544);
    return paramViewGroup;
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(142546);
    this.desc = paramString;
    if (this.kEs != null) {
      this.kEs.setText(paramString);
    }
    AppMethodBeat.o(142546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */