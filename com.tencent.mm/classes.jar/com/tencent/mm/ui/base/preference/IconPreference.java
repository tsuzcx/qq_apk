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
import com.tencent.mm.ui.aq;

public class IconPreference
  extends Preference
{
  protected int ITn;
  private Bitmap IWY;
  private int JrZ;
  private int Jsa;
  private int Jsb;
  private ImageView Jsc;
  private ViewGroup Jsd;
  private TextView Jse;
  protected Drawable Jsg;
  RelativeLayout.LayoutParams Jsh;
  private int Jsi;
  private int Jsj;
  private int Jsk;
  private int Jsl;
  private int Jsm;
  private int Jsn;
  private View Jso;
  private View Jsp;
  private TextView Jsq;
  private TextView Jsr;
  protected ImageView Jss;
  public boolean Jst;
  private boolean Jsu;
  public boolean Jsv;
  private int Jsw;
  public boolean Jsx;
  public boolean Jsy;
  private Context context;
  private String desc;
  public Drawable drawable;
  private TextView gUs;
  private int height;
  protected View mView;
  protected ImageView vEo;
  private String wSC;
  private String wSD;
  private int yEp;
  private int yEq;
  
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
    this.ITn = -1;
    this.vEo = null;
    this.wSC = "";
    this.yEp = -1;
    this.yEq = 8;
    this.JrZ = 8;
    this.Jsi = 8;
    this.desc = "";
    this.wSD = "";
    this.Jsj = -1;
    this.Jsk = 8;
    this.Jsl = -1;
    this.IWY = null;
    this.Jsm = 8;
    this.Jsa = 0;
    this.Jsb = 8;
    this.Jsn = 8;
    this.Jsc = null;
    this.Jsd = null;
    this.Jso = null;
    this.Jsp = null;
    this.height = -1;
    this.Jsu = false;
    this.Jsv = false;
    this.Jsw = -1;
    this.Jsx = false;
    this.Jsy = false;
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142543);
  }
  
  public final void D(Drawable paramDrawable)
  {
    AppMethodBeat.i(182566);
    this.Jsg = paramDrawable;
    this.IWY = null;
    this.ITn = -1;
    if (this.vEo != null) {
      this.vEo.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(182566);
  }
  
  public final void aH(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142553);
    this.IWY = paramBitmap;
    this.ITn = -1;
    this.Jsg = null;
    if (this.vEo != null) {
      this.vEo.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(142553);
  }
  
  public final void aU(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142547);
    this.wSD = paramString;
    this.Jsj = paramInt1;
    this.Jsl = paramInt2;
    if (this.Jsq != null)
    {
      this.Jsq.setText(paramString);
      if (paramInt1 != -1) {
        this.Jsq.setBackgroundDrawable(this.context.getResources().getDrawable(paramInt1));
      }
      if (paramInt2 != -1) {
        this.Jsq.setTextColor(paramInt2);
      }
    }
    AppMethodBeat.o(142547);
  }
  
  public final void acl(int paramInt)
  {
    AppMethodBeat.i(142548);
    this.yEq = paramInt;
    if (this.Jsr != null) {
      this.Jsr.setVisibility(paramInt);
    }
    AppMethodBeat.o(142548);
  }
  
  public final void acm(int paramInt)
  {
    AppMethodBeat.i(142549);
    this.Jsk = paramInt;
    if (this.Jsq != null) {
      this.Jsq.setVisibility(paramInt);
    }
    AppMethodBeat.o(142549);
  }
  
  public final void acn(int paramInt)
  {
    AppMethodBeat.i(142552);
    this.JrZ = paramInt;
    if (this.Jsc != null) {
      this.Jsc.setVisibility(paramInt);
    }
    AppMethodBeat.o(142552);
  }
  
  public final void aco(int paramInt)
  {
    AppMethodBeat.i(142554);
    this.ITn = paramInt;
    this.IWY = null;
    if (this.vEo != null) {
      this.vEo.setImageResource(paramInt);
    }
    AppMethodBeat.o(142554);
  }
  
  public final void acp(int paramInt)
  {
    AppMethodBeat.i(142555);
    this.Jsm = paramInt;
    if (this.vEo != null) {
      this.vEo.setVisibility(this.Jsm);
    }
    AppMethodBeat.o(142555);
  }
  
  public final void acq(int paramInt)
  {
    AppMethodBeat.i(142556);
    this.Jsa = paramInt;
    if (this.Jsd != null) {
      this.Jsd.setVisibility(this.Jsa);
    }
    AppMethodBeat.o(142556);
  }
  
  public final void acr(int paramInt)
  {
    AppMethodBeat.i(142557);
    this.Jsb = paramInt;
    if (this.Jso != null) {
      this.Jso.setVisibility(this.Jsb);
    }
    AppMethodBeat.o(142557);
  }
  
  public final void fzA()
  {
    AppMethodBeat.i(142550);
    this.Jsi = 0;
    if (this.gUs != null) {
      this.gUs.setVisibility(0);
    }
    AppMethodBeat.o(142550);
  }
  
  public final ImageView fzB()
  {
    return this.vEo;
  }
  
  public final void gw(String paramString, int paramInt)
  {
    this.wSC = paramString;
    this.yEp = paramInt;
  }
  
  public final void gx(String paramString, int paramInt)
  {
    AppMethodBeat.i(142545);
    aU(paramString, paramInt, this.Jsl);
    AppMethodBeat.o(142545);
  }
  
  public final void jN(int paramInt1, int paramInt2)
  {
    this.JrZ = paramInt1;
    this.Jsw = paramInt2;
  }
  
  public final void jO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142558);
    this.Jsh = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    this.Jsh.addRule(13);
    if (this.vEo == null)
    {
      AppMethodBeat.o(142558);
      return;
    }
    this.vEo.setLayoutParams(this.Jsh);
    AppMethodBeat.o(142558);
  }
  
  protected void onBindView(View paramView)
  {
    AppMethodBeat.i(142559);
    super.onBindView(paramView);
    this.Jss = ((ImageView)paramView.findViewById(2131300943));
    label80:
    Object localObject;
    label130:
    label236:
    int i;
    if (this.Jss != null)
    {
      if (this.drawable != null)
      {
        this.Jss.setImageDrawable(this.drawable);
        this.Jss.setVisibility(0);
        if (this.FlJ == 0) {
          break label842;
        }
        this.Jss.getDrawable().setColorFilter(this.FlJ, PorterDuff.Mode.SRC_ATOP);
        if (!this.Jst) {
          break label865;
        }
        localObject = (LinearLayout.LayoutParams)this.Jss.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = aq.ay(this.mContext, 2131165289);
        ((LinearLayout.LayoutParams)localObject).gravity = 48;
        this.Jss.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      ((LinearLayout)localObject).setMinimumHeight(paramView.getResources().getDimensionPixelSize(2131165488));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.Jsr = ((TextView)paramView.findViewById(2131305745));
      if (this.Jsr != null)
      {
        if (!this.Jsv) {
          break label902;
        }
        this.Jsr.setCompoundDrawablesWithIntrinsicBounds(2131234447, 0, 0, 0);
        this.Jsr.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        this.Jsr.setVisibility(this.yEq);
        this.Jsr.setText(this.wSC);
        if (this.yEp != -1) {
          this.Jsr.setBackgroundDrawable(this.context.getResources().getDrawable(this.yEp));
        }
      }
      if (!this.Jsy) {
        break label916;
      }
      i = 2131305746;
      label298:
      this.Jsq = ((TextView)paramView.findViewById(i));
      if (this.Jsq != null)
      {
        this.Jsq.setVisibility(this.Jsk);
        this.Jsq.setText(this.wSD);
        if (this.Jsj != -1)
        {
          this.Jsq.setBackgroundDrawable(this.context.getResources().getDrawable(this.Jsj));
          if (this.Jsj == 2131233430) {
            this.Jsq.setTextSize(0, a.ay(this.context, 2131166950) * a.ik(this.context));
          }
        }
        if (this.Jsl != -1) {
          this.Jsq.setTextColor(this.Jsl);
        }
        if (!this.Jsu) {
          break label923;
        }
        this.Jsq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.Jsq.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
      }
      label465:
      this.Jsc = ((ImageView)paramView.findViewById(2131305740));
      this.Jsc.setVisibility(this.JrZ);
      if (this.Jsw != -1) {
        this.Jsc.setImageResource(this.Jsw);
      }
      this.vEo = ((ImageView)paramView.findViewById(2131300959));
      this.Jsd = ((ViewGroup)paramView.findViewById(2131304191));
      this.Jsp = paramView.findViewById(2131304181);
      this.Jsp.setVisibility(this.Jsn);
      this.Jso = paramView.findViewById(2131304190);
      this.Jso.setVisibility(this.Jsb);
      if (this.IWY == null) {
        break label937;
      }
      this.vEo.setImageBitmap(this.IWY);
      label599:
      this.vEo.setVisibility(this.Jsm);
      this.Jsd.setVisibility(this.Jsa);
      if (this.Jsh != null) {
        this.vEo.setLayoutParams(this.Jsh);
      }
      this.Jse = ((TextView)paramView.findViewById(16908310));
      this.gUs = ((TextView)paramView.findViewById(2131298996));
      if (this.gUs != null)
      {
        this.gUs.setVisibility(this.Jsi);
        this.gUs.setText(this.desc);
        if (!this.Jsx) {
          break label980;
        }
        this.gUs.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label723:
      if (this.Jse != null)
      {
        if (!this.Jsx) {
          break label1003;
        }
        this.Jse.setTextColor(this.context.getResources().getColor(2131100249));
      }
      label757:
      if (this.Jsx) {
        break label1026;
      }
    }
    label1026:
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnabled(bool);
      AppMethodBeat.o(142559);
      return;
      if (this.aeA != 0)
      {
        localObject = this.Jss;
        Drawable localDrawable = this.mContext.getResources().getDrawable(this.aeA);
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.Jss.setVisibility(0);
        break;
      }
      this.Jss.setVisibility(8);
      break;
      label842:
      if (this.Jss.getDrawable() == null) {
        break label80;
      }
      this.Jss.getDrawable().clearColorFilter();
      break label80;
      label865:
      localObject = (LinearLayout.LayoutParams)this.Jss.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.Jss.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label130;
      label902:
      this.Jsr.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label236;
      label916:
      i = 2131305747;
      break label298;
      label923:
      this.Jsq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label465;
      label937:
      if (this.ITn != -1)
      {
        this.vEo.setImageResource(this.ITn);
        break label599;
      }
      if (this.Jsg == null) {
        break label599;
      }
      this.vEo.setImageDrawable(this.Jsg);
      break label599;
      label980:
      this.gUs.setTextColor(this.context.getResources().getColor(2131100212));
      break label723;
      label1003:
      this.Jse.setTextColor(this.context.getResources().getColor(2131099732));
      break label757;
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
    if (this.gUs != null) {
      this.gUs.setText(paramString);
    }
    AppMethodBeat.o(142546);
  }
  
  public final void xF(boolean paramBoolean)
  {
    AppMethodBeat.i(142551);
    this.Jsu = paramBoolean;
    if (this.Jsq != null)
    {
      if (paramBoolean)
      {
        this.Jsq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131234447, 0);
        this.Jsq.setCompoundDrawablePadding((int)this.context.getResources().getDimension(2131165568));
        AppMethodBeat.o(142551);
        return;
      }
      this.Jsq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    AppMethodBeat.o(142551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconPreference
 * JD-Core Version:    0.7.0.1
 */