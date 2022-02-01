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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.g.a.tm.b;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a
  extends i
{
  private static final String ozF;
  private View iCR;
  private ProgressBar jqx;
  private View.OnClickListener jtG;
  private Resources mResources;
  private ImageView oCJ;
  private Button oCK;
  private boolean ov;
  private String oww;
  private ImageView vmZ;
  private View wTn;
  private e yML;
  private View yMP;
  private TextView yMQ;
  private TextView yMR;
  private TextView yMS;
  private TextView yMT;
  private View yMU;
  private View yMV;
  private TextView yMW;
  private TextView yMX;
  private TextView yMY;
  private View yMZ;
  private ImageView yNa;
  public boolean yNb;
  private boolean yNc;
  private int yNd;
  private tm.b yNe;
  private a yNf;
  private b yNg;
  private com.tencent.mm.sdk.b.c yNh;
  private TextView ydZ;
  
  static
  {
    AppMethodBeat.i(28239);
    ozF = com.tencent.mm.loader.j.b.arU() + "card";
    AppMethodBeat.o(28239);
  }
  
  private a(Context paramContext)
  {
    super(paramContext, 2131821724);
    AppMethodBeat.i(28223);
    this.yNb = false;
    this.yNc = false;
    this.yNd = 0;
    this.oww = "";
    this.yNf = a.yNk;
    this.yNh = new com.tencent.mm.sdk.b.c() {};
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28218);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getId() == 2131297757)
        {
          a.this.dismiss();
          if (a.a(a.this) != null) {
            a.a(a.this).dur();
          }
          ad.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28218);
          return;
          if (paramAnonymousView.getId() == 2131297710) {
            if (a.b(a.this) == a.a.yNk)
            {
              a.a(a.this, a.a.yNl);
              a.a(a.this, 0);
              a.c(a.this);
              a.d(a.this);
            }
            else if (a.b(a.this) != a.a.yNl)
            {
              if (a.b(a.this) == a.a.yNn)
              {
                a.d(a.this);
              }
              else if (a.b(a.this) == a.a.yNm)
              {
                com.tencent.mm.sdk.b.a.IbL.c(a.e(a.this));
                a.f(a.this);
              }
            }
          }
        }
      }
    };
    ad.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
    this.mResources = paramContext.getResources();
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.iCR = View.inflate(paramContext, 2131495411, null);
    this.yMP = this.iCR.findViewById(2131304674);
    this.yMQ = ((TextView)this.iCR.findViewById(2131297918));
    this.yMR = ((TextView)this.iCR.findViewById(2131297902));
    this.yMS = ((TextView)this.iCR.findViewById(2131297776));
    this.vmZ = ((ImageView)this.iCR.findViewById(2131297757));
    this.oCK = ((Button)this.iCR.findViewById(2131297710));
    this.yMT = ((TextView)this.iCR.findViewById(2131297716));
    this.jqx = ((ProgressBar)this.iCR.findViewById(2131297881));
    this.vmZ.setOnClickListener(this.jtG);
    this.oCK.setOnClickListener(this.jtG);
    this.wTn = this.iCR.findViewById(2131297736);
    this.yMU = this.iCR.findViewById(2131306991);
    this.yMV = this.iCR.findViewById(2131297921);
    this.oCJ = ((ImageView)this.iCR.findViewById(2131297855));
    this.yMW = ((TextView)this.iCR.findViewById(2131297911));
    this.yMX = ((TextView)this.iCR.findViewById(2131297743));
    this.yMY = ((TextView)this.iCR.findViewById(2131297907));
    this.yMZ = this.iCR.findViewById(2131297886);
    this.yNa = ((ImageView)this.iCR.findViewById(2131304143));
    this.ydZ = ((TextView)this.iCR.findViewById(2131304141));
    this.yNd = com.tencent.mm.plugin.shake.c.c.a.dPf();
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
    locala.yML = parame;
    if (locala.yML == null) {
      ad.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
    }
    for (;;)
    {
      locala.yNg = paramb;
      locala.show();
      h.a(paramContext, locala);
      AppMethodBeat.o(28231);
      return locala;
      if (TextUtils.isEmpty(locala.yML.title)) {
        locala.yMQ.setText(locala.yML.title);
      }
      ad.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
      locala.yNf = a.yNk;
      locala.updateLayout();
      locala.dPb();
      if (locala.yNd == 0)
      {
        locala.yMP.setBackgroundResource(2131233966);
        locala.yMU.setBackgroundResource(2131233967);
        locala.yMQ.setTextColor(locala.mResources.getColor(2131100711));
        locala.yMR.setTextColor(locala.mResources.getColor(2131100694));
        locala.yMS.setTextColor(locala.mResources.getColor(2131100694));
        locala.ydZ.setTextColor(locala.getContext().getResources().getColor(2131100711));
        locala.oCK.setBackgroundResource(2131231365);
        locala.oCK.setTextColor(locala.getContext().getResources().getColor(2131101182));
        locala.yMT.setTextColor(locala.getContext().getResources().getColor(2131100704));
      }
    }
  }
  
  private void dPa()
  {
    AppMethodBeat.i(28229);
    if ((this.yNf == a.yNk) || (this.yNf == a.yNn))
    {
      if (TextUtils.isEmpty(this.yML.yMv))
      {
        this.oCK.setText(2131756801);
        AppMethodBeat.o(28229);
        return;
      }
      this.oCK.setText(this.yML.yMv);
      AppMethodBeat.o(28229);
      return;
    }
    if (this.yNf == a.yNl)
    {
      this.oCK.setText("");
      AppMethodBeat.o(28229);
      return;
    }
    if (this.yNf == a.yNm) {
      this.oCK.setText(2131763553);
    }
    AppMethodBeat.o(28229);
  }
  
  private void dPb()
  {
    AppMethodBeat.i(28230);
    int i = getContext().getResources().getDimensionPixelOffset(2131166792);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.Zh(this.yML.hAD));
    this.yMV.setBackgroundDrawable((Drawable)localObject1);
    dPa();
    if (!TextUtils.isEmpty(this.yML.yMt)) {
      this.yMQ.setText(this.yML.yMt);
    }
    if (!TextUtils.isEmpty(this.yML.yMx))
    {
      this.yMR.setText(this.yML.yMx);
      this.yMR.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.yML.yMu))
    {
      this.yMS.setText(this.yML.yMu);
      this.yMS.setVisibility(0);
    }
    String str;
    if (!TextUtils.isEmpty(this.yML.hzB))
    {
      i = getContext().getResources().getDimensionPixelSize(2131166791);
      localObject1 = this.oCJ;
      str = this.yML.hzB;
      if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
        break label380;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.yML.title)) {
        this.yMW.setText(this.yML.title);
      }
      if (!TextUtils.isEmpty(this.yML.oze)) {
        this.yMX.setText(this.yML.oze);
      }
      if (this.yML.oxQ > 0) {
        this.yMY.setText(getContext().getString(2131757024, new Object[] { com.tencent.mm.plugin.shake.c.c.a.sm(this.yML.oxQ) }));
      }
      if (this.yNf != a.yNn) {
        break;
      }
      this.yMT.setVisibility(0);
      AppMethodBeat.o(28230);
      return;
      label380:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = new c.a();
        ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.arU();
        com.tencent.mm.aw.q.aIK();
        ((c.a)localObject2).idJ = null;
        ((c.a)localObject2).hdP = String.format("%s/%s", new Object[] { ozF, g.getMessageDigest(str.getBytes()) });
        ((c.a)localObject2).idr = true;
        ((c.a)localObject2).hfi = true;
        ((c.a)localObject2).idp = true;
        ((c.a)localObject2).hdS = i;
        ((c.a)localObject2).hdR = i;
        ((c.a)localObject2).idD = 2131691160;
        localObject2 = ((c.a)localObject2).aJc();
        com.tencent.mm.aw.q.aIJ().a(str, (ImageView)localObject1, (com.tencent.mm.aw.a.a.c)localObject2);
      }
      else
      {
        ((ImageView)localObject1).setImageResource(2131691160);
      }
    }
    this.yMT.setVisibility(8);
    AppMethodBeat.o(28230);
  }
  
  private void updateLayout()
  {
    AppMethodBeat.i(28228);
    if (this.yNf == a.yNm)
    {
      this.wTn.setVisibility(8);
      this.yMZ.setVisibility(0);
      AppMethodBeat.o(28228);
      return;
    }
    if ((this.yNf == a.yNk) || (this.yNf == a.yNl) || (this.yNf == a.yNn))
    {
      this.wTn.setVisibility(0);
      this.yMZ.setVisibility(8);
    }
    AppMethodBeat.o(28228);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(28227);
    try
    {
      if (this.yNg != null) {
        this.yNg.dur();
      }
      if ((this.yNf != a.yNm) && (!this.yNc))
      {
        this.yNc = true;
        ad.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
        ba.aiU().a(new com.tencent.mm.plugin.shake.c.a.a(this.yML.oxM, this.yML.dHY), 0);
      }
      com.tencent.mm.sdk.b.a.IbL.d(this.yNh);
      ad.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
      super.dismiss();
      AppMethodBeat.o(28227);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(28227);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28225);
    super.onCreate(paramBundle);
    setContentView(this.iCR);
    AppMethodBeat.o(28225);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28224);
    if (paramInt == 4)
    {
      ad.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
      dismiss();
      if (this.yNg != null) {
        this.yNg.dur();
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
    this.ov = paramBoolean;
    setCanceledOnTouchOutside(this.ov);
    AppMethodBeat.o(28226);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(28222);
      yNk = new a("PRE_ACCEPT", 0);
      yNl = new a("ACCEPTING", 1);
      yNm = new a("ACCEPTED_SUCCES", 2);
      yNn = new a("ACCEPTED_FAIL", 3);
      yNo = new a[] { yNk, yNl, yNm, yNn };
      AppMethodBeat.o(28222);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void dur();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a
 * JD-Core Version:    0.7.0.1
 */