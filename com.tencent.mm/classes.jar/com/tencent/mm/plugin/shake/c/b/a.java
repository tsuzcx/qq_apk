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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.vo;
import com.tencent.mm.f.a.vo.b;
import com.tencent.mm.f.a.vp;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.shake.c.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a
  extends i
{
  private static final String tpO;
  private ImageView Exp;
  private View HaM;
  private TextView Isu;
  private TextView JnA;
  private TextView JnB;
  private View JnC;
  private View JnD;
  private TextView JnE;
  private TextView JnF;
  private TextView JnG;
  private View JnH;
  private ImageView JnI;
  public boolean JnJ;
  private boolean JnK;
  private int JnL;
  private vo.b JnM;
  private a.a JnN;
  private b JnO;
  private IListener JnP;
  private d Jnt;
  private View Jnx;
  private TextView Jny;
  private TextView Jnz;
  private boolean bxO;
  private Resources mResources;
  private View mrI;
  private ProgressBar njo;
  private View.OnClickListener nmC;
  private String tmG;
  private ImageView tsW;
  private Button tsX;
  
  static
  {
    AppMethodBeat.i(28239);
    tpO = com.tencent.mm.loader.j.b.aSL() + "card";
    AppMethodBeat.o(28239);
  }
  
  private a(Context paramContext)
  {
    super(paramContext, R.m.eWf);
    AppMethodBeat.i(28223);
    this.JnJ = false;
    this.JnK = false;
    this.JnL = 0;
    this.tmG = "";
    this.JnN = a.a.JnS;
    this.JnP = new IListener() {};
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28218);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getId() == R.h.duZ)
        {
          a.this.dismiss();
          if (a.a(a.this) != null) {
            a.a(a.this).fiS();
          }
          Log.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28218);
          return;
          if (paramAnonymousView.getId() == R.h.duV) {
            if (a.b(a.this) == a.a.JnS)
            {
              a.a(a.this, a.a.JnT);
              a.a(a.this, 0);
              a.c(a.this);
              a.d(a.this);
            }
            else if (a.b(a.this) != a.a.JnT)
            {
              if (a.b(a.this) == a.a.JnV)
              {
                a.d(a.this);
              }
              else if (a.b(a.this) == a.a.JnU)
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
    this.mrI = View.inflate(paramContext, R.i.dTT, null);
    this.Jnx = this.mrI.findViewById(R.h.dTT);
    this.Jny = ((TextView)this.mrI.findViewById(R.h.dvh));
    this.Jnz = ((TextView)this.mrI.findViewById(R.h.dve));
    this.JnA = ((TextView)this.mrI.findViewById(R.h.dva));
    this.Exp = ((ImageView)this.mrI.findViewById(R.h.duZ));
    this.tsX = ((Button)this.mrI.findViewById(R.h.duV));
    this.JnB = ((TextView)this.mrI.findViewById(R.h.duW));
    this.njo = ((ProgressBar)this.mrI.findViewById(R.h.dvc));
    this.Exp.setOnClickListener(this.nmC);
    this.tsX.setOnClickListener(this.nmC);
    this.HaM = this.mrI.findViewById(R.h.duX);
    this.JnC = this.mrI.findViewById(R.h.ebj);
    this.JnD = this.mrI.findViewById(R.h.dvi);
    this.tsW = ((ImageView)this.mrI.findViewById(R.h.dvb));
    this.JnE = ((TextView)this.mrI.findViewById(R.h.dvg));
    this.JnF = ((TextView)this.mrI.findViewById(R.h.duY));
    this.JnG = ((TextView)this.mrI.findViewById(R.h.dvf));
    this.JnH = this.mrI.findViewById(R.h.dvd);
    this.JnI = ((ImageView)this.mrI.findViewById(R.h.dSR));
    this.Isu = ((TextView)this.mrI.findViewById(R.h.dSQ));
    this.JnL = com.tencent.mm.plugin.shake.c.c.a.fHF();
    AppMethodBeat.o(28223);
  }
  
  public static a a(Context paramContext, d paramd, DialogInterface.OnCancelListener paramOnCancelListener, b paramb)
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
    locala.Jnt = paramd;
    if (locala.Jnt == null) {
      Log.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
    }
    for (;;)
    {
      locala.JnO = paramb;
      locala.show();
      h.a(paramContext, locala);
      AppMethodBeat.o(28231);
      return locala;
      if (TextUtils.isEmpty(locala.Jnt.title)) {
        locala.Jny.setText(locala.Jnt.title);
      }
      Log.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
      locala.JnN = a.a.JnS;
      locala.updateLayout();
      locala.fHB();
      if (locala.JnL == 0)
      {
        locala.Jnx.setBackgroundResource(R.g.doE);
        locala.JnC.setBackgroundResource(R.g.doF);
        locala.Jny.setTextColor(locala.mResources.getColor(R.e.normal_text_color));
        locala.Jnz.setTextColor(locala.mResources.getColor(R.e.navbar_text_normal));
        locala.JnA.setTextColor(locala.mResources.getColor(R.e.navbar_text_normal));
        locala.Isu.setTextColor(locala.getContext().getResources().getColor(R.e.normal_text_color));
        locala.tsX.setBackgroundResource(R.g.btn_solid_green);
        locala.tsX.setTextColor(locala.getContext().getResources().getColor(R.e.white_text_color));
        locala.JnB.setTextColor(locala.getContext().getResources().getColor(R.e.dkB));
      }
    }
  }
  
  private void fHA()
  {
    AppMethodBeat.i(28229);
    if ((this.JnN == a.a.JnS) || (this.JnN == a.a.JnV))
    {
      if (TextUtils.isEmpty(this.Jnt.Jnd))
      {
        this.tsX.setText(R.l.card_add);
        AppMethodBeat.o(28229);
        return;
      }
      this.tsX.setText(this.Jnt.Jnd);
      AppMethodBeat.o(28229);
      return;
    }
    if (this.JnN == a.a.JnT)
    {
      this.tsX.setText("");
      AppMethodBeat.o(28229);
      return;
    }
    if (this.JnN == a.a.JnU) {
      this.tsX.setText(R.l.eSv);
    }
    AppMethodBeat.o(28229);
  }
  
  private void fHB()
  {
    AppMethodBeat.i(28230);
    int i = getContext().getResources().getDimensionPixelOffset(R.f.dlI);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.arR(this.Jnt.lmL));
    this.JnD.setBackgroundDrawable((Drawable)localObject1);
    fHA();
    if (!TextUtils.isEmpty(this.Jnt.Jnb)) {
      this.Jny.setText(this.Jnt.Jnb);
    }
    if (!TextUtils.isEmpty(this.Jnt.Jnf))
    {
      this.Jnz.setText(this.Jnt.Jnf);
      this.Jnz.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.Jnt.Jnc))
    {
      this.JnA.setText(this.Jnt.Jnc);
      this.JnA.setVisibility(0);
    }
    String str;
    int j;
    if (!TextUtils.isEmpty(this.Jnt.llI))
    {
      i = getContext().getResources().getDimensionPixelSize(R.f.dlH);
      localObject1 = this.tsW;
      str = this.Jnt.llI;
      j = R.k.shake_card_package_defaultlogo;
      if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
        break label386;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.Jnt.title)) {
        this.JnE.setText(this.Jnt.title);
      }
      if (!TextUtils.isEmpty(this.Jnt.jEi)) {
        this.JnF.setText(this.Jnt.jEi);
      }
      if (this.Jnt.end_time > 0) {
        this.JnG.setText(getContext().getString(R.l.card_validate_to, new Object[] { com.tencent.mm.plugin.shake.c.c.a.GN(this.Jnt.end_time) }));
      }
      if (this.JnN != a.a.JnV) {
        break;
      }
      this.JnB.setVisibility(0);
      AppMethodBeat.o(28230);
      return;
      label386:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = new c.a();
        ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aSL();
        q.bmm();
        ((c.a)localObject2).lRV = null;
        ((c.a)localObject2).fullPath = String.format("%s/%s", new Object[] { tpO, g.getMessageDigest(str.getBytes()) });
        ((c.a)localObject2).lRD = true;
        ((c.a)localObject2).kPz = true;
        ((c.a)localObject2).lRB = true;
        ((c.a)localObject2).kOg = i;
        ((c.a)localObject2).kOf = i;
        ((c.a)localObject2).lRP = j;
        localObject2 = ((c.a)localObject2).bmL();
        q.bml().a(str, (ImageView)localObject1, (c)localObject2);
      }
      else
      {
        ((ImageView)localObject1).setImageResource(j);
      }
    }
    this.JnB.setVisibility(8);
    AppMethodBeat.o(28230);
  }
  
  private void updateLayout()
  {
    AppMethodBeat.i(28228);
    if (this.JnN == a.a.JnU)
    {
      this.HaM.setVisibility(8);
      this.JnH.setVisibility(0);
      AppMethodBeat.o(28228);
      return;
    }
    if ((this.JnN == a.a.JnS) || (this.JnN == a.a.JnT) || (this.JnN == a.a.JnV))
    {
      this.HaM.setVisibility(0);
      this.JnH.setVisibility(8);
    }
    AppMethodBeat.o(28228);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(28227);
    try
    {
      if (this.JnO != null) {
        this.JnO.fiS();
      }
      if ((this.JnN != a.a.JnU) && (!this.JnK))
      {
        this.JnK = true;
        Log.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
        bh.aGY().a(new com.tencent.mm.plugin.shake.c.a.a(this.Jnt.tnX, this.Jnt.fUM), 0);
      }
      EventCenter.instance.removeListener(this.JnP);
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
    setContentView(this.mrI);
    AppMethodBeat.o(28225);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28224);
    if (paramInt == 4)
    {
      Log.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
      dismiss();
      if (this.JnO != null) {
        this.JnO.fiS();
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
    this.bxO = paramBoolean;
    setCanceledOnTouchOutside(this.bxO);
    AppMethodBeat.o(28226);
  }
  
  public static abstract interface b
  {
    public abstract void fiS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a
 * JD-Core Version:    0.7.0.1
 */