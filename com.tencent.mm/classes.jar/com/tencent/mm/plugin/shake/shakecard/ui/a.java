package com.tencent.mm.plugin.shake.shakecard.ui;

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
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.xe;
import com.tencent.mm.autogen.a.xe.b;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.shake.shakecard.a.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.i;

public final class a
  extends i
{
  private static final String wun;
  private ImageView KpY;
  private View MYT;
  private TextView Oqc;
  private boolean PAA;
  private int PAB;
  private xe.b PAC;
  private a PAD;
  private b PAE;
  private IListener PAF;
  private d PAj;
  private View PAn;
  private TextView PAo;
  private TextView PAp;
  private TextView PAq;
  private TextView PAr;
  private View PAs;
  private View PAt;
  private TextView PAu;
  private TextView PAv;
  private TextView PAw;
  private View PAx;
  private ImageView PAy;
  public boolean PAz;
  private boolean dqR;
  private Resources mResources;
  private View plc;
  private ProgressBar qgC;
  private View.OnClickListener qjL;
  private String wrg;
  private ImageView wxt;
  private Button wxu;
  
  static
  {
    AppMethodBeat.i(28239);
    wun = com.tencent.mm.loader.i.b.bmz() + "card";
    AppMethodBeat.o(28239);
  }
  
  private a(Context paramContext)
  {
    super(paramContext, R.m.gZt);
    AppMethodBeat.i(28223);
    this.PAz = false;
    this.PAA = false;
    this.PAB = 0;
    this.wrg = "";
    this.PAD = a.PAI;
    this.PAF = new ShakeCardDialog.1(this, f.hfK);
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28218);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getId() == R.h.fvr)
        {
          a.this.dismiss();
          if (a.a(a.this) != null) {
            a.a(a.this).gtj();
          }
          Log.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28218);
          return;
          if (paramAnonymousView.getId() == R.h.fvn) {
            if (a.b(a.this) == a.a.PAI)
            {
              a.a(a.this, a.a.PAJ);
              a.a(a.this, 0);
              a.c(a.this);
              a.d(a.this);
            }
            else if (a.b(a.this) != a.a.PAJ)
            {
              if (a.b(a.this) == a.a.PAL)
              {
                a.d(a.this);
              }
              else if (a.b(a.this) == a.a.PAK)
              {
                a.e(a.this).alive();
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
    this.plc = View.inflate(paramContext, R.i.fWb, null);
    this.PAn = this.plc.findViewById(R.h.fWb);
    this.PAo = ((TextView)this.plc.findViewById(R.h.fvz));
    this.PAp = ((TextView)this.plc.findViewById(R.h.fvw));
    this.PAq = ((TextView)this.plc.findViewById(R.h.fvs));
    this.KpY = ((ImageView)this.plc.findViewById(R.h.fvr));
    this.wxu = ((Button)this.plc.findViewById(R.h.fvn));
    this.PAr = ((TextView)this.plc.findViewById(R.h.fvo));
    this.qgC = ((ProgressBar)this.plc.findViewById(R.h.fvu));
    this.KpY.setOnClickListener(this.qjL);
    this.wxu.setOnClickListener(this.qjL);
    this.MYT = this.plc.findViewById(R.h.fvp);
    this.PAs = this.plc.findViewById(R.h.gdN);
    this.PAt = this.plc.findViewById(R.h.fvA);
    this.wxt = ((ImageView)this.plc.findViewById(R.h.fvt));
    this.PAu = ((TextView)this.plc.findViewById(R.h.fvy));
    this.PAv = ((TextView)this.plc.findViewById(R.h.fvq));
    this.PAw = ((TextView)this.plc.findViewById(R.h.fvx));
    this.PAx = this.plc.findViewById(R.h.fvv);
    this.PAy = ((ImageView)this.plc.findViewById(R.h.fUU));
    this.Oqc = ((TextView)this.plc.findViewById(R.h.fUT));
    this.PAB = com.tencent.mm.plugin.shake.shakecard.b.a.gXv();
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
    locala.PAj = paramd;
    if (locala.PAj == null) {
      Log.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
    }
    for (;;)
    {
      locala.PAE = paramb;
      locala.show();
      k.a(paramContext, locala);
      AppMethodBeat.o(28231);
      return locala;
      if (TextUtils.isEmpty(locala.PAj.title)) {
        locala.PAo.setText(locala.PAj.title);
      }
      Log.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
      locala.PAD = a.PAI;
      locala.gXp();
      locala.gXr();
      if (locala.PAB == 0)
      {
        locala.PAn.setBackgroundResource(R.g.fpb);
        locala.PAs.setBackgroundResource(R.g.fpc);
        locala.PAo.setTextColor(locala.mResources.getColor(R.e.normal_text_color));
        locala.PAp.setTextColor(locala.mResources.getColor(R.e.navbar_text_normal));
        locala.PAq.setTextColor(locala.mResources.getColor(R.e.navbar_text_normal));
        locala.Oqc.setTextColor(locala.getContext().getResources().getColor(R.e.normal_text_color));
        locala.wxu.setBackgroundResource(R.g.btn_solid_green);
        locala.wxu.setTextColor(locala.getContext().getResources().getColor(R.e.white_text_color));
        locala.PAr.setTextColor(locala.getContext().getResources().getColor(R.e.fkN));
      }
    }
  }
  
  private void gXp()
  {
    AppMethodBeat.i(28228);
    if (this.PAD == a.PAK)
    {
      this.MYT.setVisibility(8);
      this.PAx.setVisibility(0);
      AppMethodBeat.o(28228);
      return;
    }
    if ((this.PAD == a.PAI) || (this.PAD == a.PAJ) || (this.PAD == a.PAL))
    {
      this.MYT.setVisibility(0);
      this.PAx.setVisibility(8);
    }
    AppMethodBeat.o(28228);
  }
  
  private void gXq()
  {
    AppMethodBeat.i(28229);
    if ((this.PAD == a.PAI) || (this.PAD == a.PAL))
    {
      if (TextUtils.isEmpty(this.PAj.PzT))
      {
        this.wxu.setText(R.l.card_add);
        AppMethodBeat.o(28229);
        return;
      }
      this.wxu.setText(this.PAj.PzT);
      AppMethodBeat.o(28229);
      return;
    }
    if (this.PAD == a.PAJ)
    {
      this.wxu.setText("");
      AppMethodBeat.o(28229);
      return;
    }
    if (this.PAD == a.PAK) {
      this.wxu.setText(R.l.gVj);
    }
    AppMethodBeat.o(28229);
  }
  
  private void gXr()
  {
    AppMethodBeat.i(28230);
    int i = getContext().getResources().getDimensionPixelOffset(R.f.fma);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(com.tencent.mm.plugin.shake.shakecard.b.a.alv(this.PAj.nRQ));
    this.PAt.setBackgroundDrawable((Drawable)localObject1);
    gXq();
    if (!TextUtils.isEmpty(this.PAj.PzR)) {
      this.PAo.setText(this.PAj.PzR);
    }
    if (!TextUtils.isEmpty(this.PAj.PzV))
    {
      this.PAp.setText(this.PAj.PzV);
      this.PAp.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.PAj.PzS))
    {
      this.PAq.setText(this.PAj.PzS);
      this.PAq.setVisibility(0);
    }
    String str;
    int j;
    if (!TextUtils.isEmpty(this.PAj.nQG))
    {
      i = getContext().getResources().getDimensionPixelSize(R.f.flZ);
      localObject1 = this.wxt;
      str = this.PAj.nQG;
      j = R.k.shake_card_package_defaultlogo;
      if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
        break label386;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.PAj.title)) {
        this.PAu.setText(this.PAj.title);
      }
      if (!TextUtils.isEmpty(this.PAj.mee)) {
        this.PAv.setText(this.PAj.mee);
      }
      if (this.PAj.end_time > 0) {
        this.PAw.setText(getContext().getString(R.l.card_validate_to, new Object[] { com.tencent.mm.plugin.shake.shakecard.b.a.iY(this.PAj.end_time) }));
      }
      if (this.PAD != a.PAL) {
        break;
      }
      this.PAr.setVisibility(0);
      AppMethodBeat.o(28230);
      return;
      label386:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = new c.a();
        ((c.a)localObject2).prefixPath = com.tencent.mm.loader.i.b.bmz();
        ((c.a)localObject2).oKH = r.bKf();
        ((c.a)localObject2).fullPath = String.format("%s/%s", new Object[] { wun, g.getMessageDigest(str.getBytes()) });
        ((c.a)localObject2).oKp = true;
        ((c.a)localObject2).nrc = true;
        ((c.a)localObject2).oKn = true;
        ((c.a)localObject2).npV = i;
        ((c.a)localObject2).npU = i;
        ((c.a)localObject2).oKB = j;
        localObject2 = ((c.a)localObject2).bKx();
        r.bKe().a(str, (ImageView)localObject1, (c)localObject2);
      }
      else
      {
        ((ImageView)localObject1).setImageResource(j);
      }
    }
    this.PAr.setVisibility(8);
    AppMethodBeat.o(28230);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(28227);
    try
    {
      if (this.PAE != null) {
        this.PAE.gtj();
      }
      if ((this.PAD != a.PAK) && (!this.PAA))
      {
        this.PAA = true;
        Log.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
        bh.aZW().a(new com.tencent.mm.plugin.shake.shakecard.a.a(this.PAj.wsy, this.PAj.iaJ), 0);
      }
      this.PAF.dead();
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
    setContentView(this.plc);
    AppMethodBeat.o(28225);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28224);
    if (paramInt == 4)
    {
      Log.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
      dismiss();
      if (this.PAE != null) {
        this.PAE.gtj();
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
    this.dqR = paramBoolean;
    setCanceledOnTouchOutside(this.dqR);
    AppMethodBeat.o(28226);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(28222);
      PAI = new a("PRE_ACCEPT", 0);
      PAJ = new a("ACCEPTING", 1);
      PAK = new a("ACCEPTED_SUCCES", 2);
      PAL = new a("ACCEPTED_FAIL", 3);
      PAM = new a[] { PAI, PAJ, PAK, PAL };
      AppMethodBeat.o(28222);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void gtj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.shakecard.ui.a
 * JD-Core Version:    0.7.0.1
 */