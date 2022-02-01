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
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.ul.b;
import com.tencent.mm.g.a.um;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a
  extends i
{
  private static final String pTN;
  private View Bhb;
  private TextView CuH;
  private e DhN;
  private View DhR;
  private TextView DhS;
  private TextView DhT;
  private TextView DhU;
  private TextView DhV;
  private View DhW;
  private View DhX;
  private TextView DhY;
  private TextView DhZ;
  private TextView Dia;
  private View Dib;
  private ImageView Dic;
  public boolean Did;
  private boolean Die;
  private int Dif;
  private ul.b Dig;
  private a Dih;
  private b Dii;
  private IListener Dij;
  private View jBN;
  private ProgressBar krF;
  private View.OnClickListener kuO;
  private Resources mResources;
  private boolean ox;
  private String pQH;
  private ImageView pWZ;
  private Button pXa;
  private ImageView yTs;
  
  static
  {
    AppMethodBeat.i(28239);
    pTN = com.tencent.mm.loader.j.b.aKJ() + "card";
    AppMethodBeat.o(28239);
  }
  
  private a(Context paramContext)
  {
    super(paramContext, 2131821773);
    AppMethodBeat.i(28223);
    this.Did = false;
    this.Die = false;
    this.Dif = 0;
    this.pQH = "";
    this.Dih = a.Dim;
    this.Dij = new IListener() {};
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28218);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getId() == 2131298071)
        {
          a.this.dismiss();
          if (a.a(a.this) != null) {
            a.a(a.this).exp();
          }
          Log.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28218);
          return;
          if (paramAnonymousView.getId() == 2131298014) {
            if (a.b(a.this) == a.a.Dim)
            {
              a.a(a.this, a.a.Din);
              a.a(a.this, 0);
              a.c(a.this);
              a.d(a.this);
            }
            else if (a.b(a.this) != a.a.Din)
            {
              if (a.b(a.this) == a.a.Dip)
              {
                a.d(a.this);
              }
              else if (a.b(a.this) == a.a.Dio)
              {
                EventCenter.instance.addListener(a.e(a.this));
                a.f(a.this);
              }
            }
          }
        }
      }
    };
    Log.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
    this.mResources = paramContext.getResources();
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.jBN = View.inflate(paramContext, 2131496279, null);
    this.DhR = this.jBN.findViewById(2131307730);
    this.DhS = ((TextView)this.jBN.findViewById(2131298236));
    this.DhT = ((TextView)this.jBN.findViewById(2131298220));
    this.DhU = ((TextView)this.jBN.findViewById(2131298091));
    this.yTs = ((ImageView)this.jBN.findViewById(2131298071));
    this.pXa = ((Button)this.jBN.findViewById(2131298014));
    this.DhV = ((TextView)this.jBN.findViewById(2131298020));
    this.krF = ((ProgressBar)this.jBN.findViewById(2131298198));
    this.yTs.setOnClickListener(this.kuO);
    this.pXa.setOnClickListener(this.kuO);
    this.Bhb = this.jBN.findViewById(2131298048);
    this.DhW = this.jBN.findViewById(2131310503);
    this.DhX = this.jBN.findViewById(2131298239);
    this.pWZ = ((ImageView)this.jBN.findViewById(2131298171));
    this.DhY = ((TextView)this.jBN.findViewById(2131298229));
    this.DhZ = ((TextView)this.jBN.findViewById(2131298056));
    this.Dia = ((TextView)this.jBN.findViewById(2131298225));
    this.Dib = this.jBN.findViewById(2131298203);
    this.Dic = ((ImageView)this.jBN.findViewById(2131307039));
    this.CuH = ((TextView)this.jBN.findViewById(2131307037));
    this.Dif = com.tencent.mm.plugin.shake.c.c.a.eUD();
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
    locala.DhN = parame;
    if (locala.DhN == null) {
      Log.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
    }
    for (;;)
    {
      locala.Dii = paramb;
      locala.show();
      h.a(paramContext, locala);
      AppMethodBeat.o(28231);
      return locala;
      if (TextUtils.isEmpty(locala.DhN.title)) {
        locala.DhS.setText(locala.DhN.title);
      }
      Log.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
      locala.Dih = a.Dim;
      locala.updateLayout();
      locala.eUz();
      if (locala.Dif == 0)
      {
        locala.DhR.setBackgroundResource(2131234803);
        locala.DhW.setBackgroundResource(2131234804);
        locala.DhS.setTextColor(locala.mResources.getColor(2131100904));
        locala.DhT.setTextColor(locala.mResources.getColor(2131100887));
        locala.DhU.setTextColor(locala.mResources.getColor(2131100887));
        locala.CuH.setTextColor(locala.getContext().getResources().getColor(2131100904));
        locala.pXa.setBackgroundResource(2131231429);
        locala.pXa.setTextColor(locala.getContext().getResources().getColor(2131101427));
        locala.DhV.setTextColor(locala.getContext().getResources().getColor(2131100897));
      }
    }
  }
  
  private void eUy()
  {
    AppMethodBeat.i(28229);
    if ((this.Dih == a.Dim) || (this.Dih == a.Dip))
    {
      if (TextUtils.isEmpty(this.DhN.Dhx))
      {
        this.pXa.setText(2131756966);
        AppMethodBeat.o(28229);
        return;
      }
      this.pXa.setText(this.DhN.Dhx);
      AppMethodBeat.o(28229);
      return;
    }
    if (this.Dih == a.Din)
    {
      this.pXa.setText("");
      AppMethodBeat.o(28229);
      return;
    }
    if (this.Dih == a.Dio) {
      this.pXa.setText(2131765741);
    }
    AppMethodBeat.o(28229);
  }
  
  private void eUz()
  {
    AppMethodBeat.i(28230);
    int i = getContext().getResources().getDimensionPixelOffset(2131166916);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.ake(this.DhN.ixw));
    this.DhX.setBackgroundDrawable((Drawable)localObject1);
    eUy();
    if (!TextUtils.isEmpty(this.DhN.Dhv)) {
      this.DhS.setText(this.DhN.Dhv);
    }
    if (!TextUtils.isEmpty(this.DhN.Dhz))
    {
      this.DhT.setText(this.DhN.Dhz);
      this.DhT.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.DhN.Dhw))
    {
      this.DhU.setText(this.DhN.Dhw);
      this.DhU.setVisibility(0);
    }
    String str;
    if (!TextUtils.isEmpty(this.DhN.iwv))
    {
      i = getContext().getResources().getDimensionPixelSize(2131166915);
      localObject1 = this.pWZ;
      str = this.DhN.iwv;
      if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
        break label380;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.DhN.title)) {
        this.DhY.setText(this.DhN.title);
      }
      if (!TextUtils.isEmpty(this.DhN.gTG)) {
        this.DhZ.setText(this.DhN.gTG);
      }
      if (this.DhN.pSb > 0) {
        this.Dia.setText(getContext().getString(2131757194, new Object[] { com.tencent.mm.plugin.shake.c.c.a.AF(this.DhN.pSb) }));
      }
      if (this.Dih != a.Dip) {
        break;
      }
      this.DhV.setVisibility(0);
      AppMethodBeat.o(28230);
      return;
      label380:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = new c.a();
        ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aKJ();
        q.bcW();
        ((c.a)localObject2).jbw = null;
        ((c.a)localObject2).fullPath = String.format("%s/%s", new Object[] { pTN, g.getMessageDigest(str.getBytes()) });
        ((c.a)localObject2).jbf = true;
        ((c.a)localObject2).iaT = true;
        ((c.a)localObject2).jbd = true;
        ((c.a)localObject2).hZA = i;
        ((c.a)localObject2).hZz = i;
        ((c.a)localObject2).jbq = 2131691471;
        localObject2 = ((c.a)localObject2).bdv();
        q.bcV().a(str, (ImageView)localObject1, (c)localObject2);
      }
      else
      {
        ((ImageView)localObject1).setImageResource(2131691471);
      }
    }
    this.DhV.setVisibility(8);
    AppMethodBeat.o(28230);
  }
  
  private void updateLayout()
  {
    AppMethodBeat.i(28228);
    if (this.Dih == a.Dio)
    {
      this.Bhb.setVisibility(8);
      this.Dib.setVisibility(0);
      AppMethodBeat.o(28228);
      return;
    }
    if ((this.Dih == a.Dim) || (this.Dih == a.Din) || (this.Dih == a.Dip))
    {
      this.Bhb.setVisibility(0);
      this.Dib.setVisibility(8);
    }
    AppMethodBeat.o(28228);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(28227);
    try
    {
      if (this.Dii != null) {
        this.Dii.exp();
      }
      if ((this.Dih != a.Dio) && (!this.Die))
      {
        this.Die = true;
        Log.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
        bg.azz().a(new com.tencent.mm.plugin.shake.c.a.a(this.DhN.pRX, this.DhN.eaP), 0);
      }
      EventCenter.instance.removeListener(this.Dij);
      Log.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
      super.dismiss();
      AppMethodBeat.o(28227);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(28227);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28225);
    super.onCreate(paramBundle);
    setContentView(this.jBN);
    AppMethodBeat.o(28225);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28224);
    if (paramInt == 4)
    {
      Log.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
      dismiss();
      if (this.Dii != null) {
        this.Dii.exp();
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
    this.ox = paramBoolean;
    setCanceledOnTouchOutside(this.ox);
    AppMethodBeat.o(28226);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(28222);
      Dim = new a("PRE_ACCEPT", 0);
      Din = new a("ACCEPTING", 1);
      Dio = new a("ACCEPTED_SUCCES", 2);
      Dip = new a("ACCEPTED_FAIL", 3);
      Diq = new a[] { Dim, Din, Dio, Dip };
      AppMethodBeat.o(28222);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void exp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a
 * JD-Core Version:    0.7.0.1
 */