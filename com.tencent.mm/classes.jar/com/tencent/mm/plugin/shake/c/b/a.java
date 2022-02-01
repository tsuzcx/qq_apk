package com.tencent.mm.plugin.shake.c.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sv.b;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a
  extends i
{
  private static final String nWl;
  private ProgressBar iXo;
  private View ijA;
  private View.OnClickListener jax;
  private Resources mResources;
  private boolean mz;
  private String nTb;
  private ImageView nZp;
  private Button nZq;
  private ImageView ukr;
  private View vMe;
  private TextView wQr;
  private e xya;
  private View xye;
  private TextView xyf;
  private TextView xyg;
  private TextView xyh;
  private TextView xyi;
  private View xyj;
  private View xyk;
  private TextView xyl;
  private TextView xym;
  private TextView xyn;
  private View xyo;
  private ImageView xyp;
  public boolean xyq;
  private boolean xyr;
  private int xyt;
  private sv.b xyu;
  private a xyv;
  private b xyw;
  private com.tencent.mm.sdk.b.c xyx;
  
  static
  {
    AppMethodBeat.i(28239);
    nWl = b.aph() + "card";
    AppMethodBeat.o(28239);
  }
  
  private a(Context paramContext)
  {
    super(paramContext, 2131821724);
    AppMethodBeat.i(28223);
    this.xyq = false;
    this.xyr = false;
    this.xyt = 0;
    this.nTb = "";
    this.xyv = a.xyA;
    this.xyx = new com.tencent.mm.sdk.b.c() {};
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28218);
        if (paramAnonymousView.getId() == 2131297757)
        {
          a.this.dismiss();
          if (a.a(a.this) != null) {
            a.a(a.this).dkf();
          }
          ac.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
          AppMethodBeat.o(28218);
          return;
        }
        if (paramAnonymousView.getId() == 2131297710)
        {
          if (a.b(a.this) == a.a.xyA)
          {
            a.a(a.this, a.a.xyB);
            a.a(a.this, 0);
            a.c(a.this);
            a.d(a.this);
            AppMethodBeat.o(28218);
            return;
          }
          if (a.b(a.this) != a.a.xyB)
          {
            if (a.b(a.this) == a.a.xyD)
            {
              a.d(a.this);
              AppMethodBeat.o(28218);
              return;
            }
            if (a.b(a.this) == a.a.xyC)
            {
              com.tencent.mm.sdk.b.a.GpY.c(a.e(a.this));
              a.f(a.this);
            }
          }
        }
        AppMethodBeat.o(28218);
      }
    };
    ac.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
    this.mResources = paramContext.getResources();
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.ijA = View.inflate(paramContext, 2131495411, null);
    this.xye = this.ijA.findViewById(2131304674);
    this.xyf = ((TextView)this.ijA.findViewById(2131297918));
    this.xyg = ((TextView)this.ijA.findViewById(2131297902));
    this.xyh = ((TextView)this.ijA.findViewById(2131297776));
    this.ukr = ((ImageView)this.ijA.findViewById(2131297757));
    this.nZq = ((Button)this.ijA.findViewById(2131297710));
    this.xyi = ((TextView)this.ijA.findViewById(2131297716));
    this.iXo = ((ProgressBar)this.ijA.findViewById(2131297881));
    this.ukr.setOnClickListener(this.jax);
    this.nZq.setOnClickListener(this.jax);
    this.vMe = this.ijA.findViewById(2131297736);
    this.xyj = this.ijA.findViewById(2131306991);
    this.xyk = this.ijA.findViewById(2131297921);
    this.nZp = ((ImageView)this.ijA.findViewById(2131297855));
    this.xyl = ((TextView)this.ijA.findViewById(2131297911));
    this.xym = ((TextView)this.ijA.findViewById(2131297743));
    this.xyn = ((TextView)this.ijA.findViewById(2131297907));
    this.xyo = this.ijA.findViewById(2131297886);
    this.xyp = ((ImageView)this.ijA.findViewById(2131304143));
    this.wQr = ((TextView)this.ijA.findViewById(2131304141));
    this.xyt = com.tencent.mm.plugin.shake.c.c.a.dDC();
    AppMethodBeat.o(28223);
  }
  
  public static a a(Context paramContext, e parame, DialogInterface.OnCancelListener paramOnCancelListener, b paramb)
  {
    AppMethodBeat.i(28231);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(28231);
      return null;
    }
    a locala = new a(paramContext);
    locala.setOnCancelListener(paramOnCancelListener);
    locala.setCancelable(true);
    locala.xya = parame;
    if (locala.xya == null) {
      ac.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
    }
    for (;;)
    {
      locala.xyw = paramb;
      locala.show();
      h.a(paramContext, locala);
      AppMethodBeat.o(28231);
      return locala;
      if (TextUtils.isEmpty(locala.xya.title)) {
        locala.xyf.setText(locala.xya.title);
      }
      ac.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
      locala.xyv = a.xyA;
      locala.updateLayout();
      locala.dDy();
      if (locala.xyt == 0)
      {
        locala.xye.setBackgroundResource(2131233966);
        locala.xyj.setBackgroundResource(2131233967);
        locala.xyf.setTextColor(locala.mResources.getColor(2131100711));
        locala.xyg.setTextColor(locala.mResources.getColor(2131100694));
        locala.xyh.setTextColor(locala.mResources.getColor(2131100694));
        locala.wQr.setTextColor(locala.getContext().getResources().getColor(2131100711));
        locala.nZq.setBackgroundResource(2131231365);
        locala.nZq.setTextColor(locala.getContext().getResources().getColor(2131101182));
        locala.xyi.setTextColor(locala.getContext().getResources().getColor(2131100704));
      }
    }
  }
  
  private void dDx()
  {
    AppMethodBeat.i(28229);
    if ((this.xyv == a.xyA) || (this.xyv == a.xyD))
    {
      if (TextUtils.isEmpty(this.xya.xxK))
      {
        this.nZq.setText(2131756801);
        AppMethodBeat.o(28229);
        return;
      }
      this.nZq.setText(this.xya.xxK);
      AppMethodBeat.o(28229);
      return;
    }
    if (this.xyv == a.xyB)
    {
      this.nZq.setText("");
      AppMethodBeat.o(28229);
      return;
    }
    if (this.xyv == a.xyC) {
      this.nZq.setText(2131763553);
    }
    AppMethodBeat.o(28229);
  }
  
  private void dDy()
  {
    AppMethodBeat.i(28230);
    int i = getContext().getResources().getDimensionPixelOffset(2131166792);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.Vy(this.xya.hiu));
    this.xyk.setBackgroundDrawable((Drawable)localObject1);
    dDx();
    if (!TextUtils.isEmpty(this.xya.xxI)) {
      this.xyf.setText(this.xya.xxI);
    }
    if (!TextUtils.isEmpty(this.xya.xxM))
    {
      this.xyg.setText(this.xya.xxM);
      this.xyg.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.xya.xxJ))
    {
      this.xyh.setText(this.xya.xxJ);
      this.xyh.setVisibility(0);
    }
    String str;
    if (!TextUtils.isEmpty(this.xya.hhs))
    {
      i = getContext().getResources().getDimensionPixelSize(2131166791);
      localObject1 = this.nZp;
      str = this.xya.hhs;
      if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
        break label380;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.xya.title)) {
        this.xyl.setText(this.xya.title);
      }
      if (!TextUtils.isEmpty(this.xya.nVK)) {
        this.xym.setText(this.xya.nVK);
      }
      if (this.xya.nUv > 0) {
        this.xyn.setText(getContext().getString(2131757024, new Object[] { com.tencent.mm.plugin.shake.c.c.a.qn(this.xya.nUv) }));
      }
      if (this.xyv != a.xyD) {
        break;
      }
      this.xyi.setVisibility(0);
      AppMethodBeat.o(28230);
      return;
      label380:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = new c.a();
        ((c.a)localObject2).prefixPath = b.aph();
        o.aFC();
        ((c.a)localObject2).hKO = null;
        ((c.a)localObject2).gKe = String.format("%s/%s", new Object[] { nWl, g.getMessageDigest(str.getBytes()) });
        ((c.a)localObject2).hKx = true;
        ((c.a)localObject2).gLt = true;
        ((c.a)localObject2).hKv = true;
        ((c.a)localObject2).gKh = i;
        ((c.a)localObject2).gKg = i;
        ((c.a)localObject2).hKI = 2131691160;
        localObject2 = ((c.a)localObject2).aFT();
        o.aFB().a(str, (ImageView)localObject1, (com.tencent.mm.av.a.a.c)localObject2);
      }
      else
      {
        ((ImageView)localObject1).setImageResource(2131691160);
      }
    }
    this.xyi.setVisibility(8);
    AppMethodBeat.o(28230);
  }
  
  private void updateLayout()
  {
    AppMethodBeat.i(28228);
    if (this.xyv == a.xyC)
    {
      this.vMe.setVisibility(8);
      this.xyo.setVisibility(0);
      AppMethodBeat.o(28228);
      return;
    }
    if ((this.xyv == a.xyA) || (this.xyv == a.xyB) || (this.xyv == a.xyD))
    {
      this.vMe.setVisibility(0);
      this.xyo.setVisibility(8);
    }
    AppMethodBeat.o(28228);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(28227);
    try
    {
      if (this.xyw != null) {
        this.xyw.dkf();
      }
      if ((this.xyv != a.xyC) && (!this.xyr))
      {
        this.xyr = true;
        ac.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
        az.agi().a(new com.tencent.mm.plugin.shake.c.a.a(this.xya.nUr, this.xya.dvP), 0);
      }
      com.tencent.mm.sdk.b.a.GpY.d(this.xyx);
      ac.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
      super.dismiss();
      AppMethodBeat.o(28227);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(28227);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28225);
    super.onCreate(paramBundle);
    setContentView(this.ijA);
    AppMethodBeat.o(28225);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28224);
    if (paramInt == 4)
    {
      ac.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
      dismiss();
      if (this.xyw != null) {
        this.xyw.dkf();
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(28224);
    return bool;
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(28226);
    super.setCancelable(paramBoolean);
    this.mz = paramBoolean;
    setCanceledOnTouchOutside(this.mz);
    AppMethodBeat.o(28226);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(28222);
      xyA = new a("PRE_ACCEPT", 0);
      xyB = new a("ACCEPTING", 1);
      xyC = new a("ACCEPTED_SUCCES", 2);
      xyD = new a("ACCEPTED_FAIL", 3);
      xyE = new a[] { xyA, xyB, xyC, xyD };
      AppMethodBeat.o(28222);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void dkf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a
 * JD-Core Version:    0.7.0.1
 */