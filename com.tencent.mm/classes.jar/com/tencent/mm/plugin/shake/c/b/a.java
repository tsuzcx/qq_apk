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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.g.a.tn.b;
import com.tencent.mm.g.a.to;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a
  extends i
{
  private static final String oGh;
  private View iFK;
  private ProgressBar jtq;
  private View.OnClickListener jwB;
  private Resources mResources;
  private String oCY;
  private ImageView oJl;
  private Button oJm;
  private boolean ov;
  private ImageView vze;
  private View xje;
  private TextView ytQ;
  private e zcV;
  private View zcZ;
  private TextView zda;
  private TextView zdb;
  private TextView zdc;
  private TextView zdd;
  private View zde;
  private View zdf;
  private TextView zdg;
  private TextView zdh;
  private TextView zdi;
  private View zdj;
  private ImageView zdk;
  public boolean zdl;
  private boolean zdm;
  private int zdn;
  private tn.b zdo;
  private a zdp;
  private b zdq;
  private com.tencent.mm.sdk.b.c zdr;
  
  static
  {
    AppMethodBeat.i(28239);
    oGh = com.tencent.mm.loader.j.b.asj() + "card";
    AppMethodBeat.o(28239);
  }
  
  private a(Context paramContext)
  {
    super(paramContext, 2131821724);
    AppMethodBeat.i(28223);
    this.zdl = false;
    this.zdm = false;
    this.zdn = 0;
    this.oCY = "";
    this.zdp = a.zdu;
    this.zdr = new com.tencent.mm.sdk.b.c() {};
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28218);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramAnonymousView.getId() == 2131297757)
        {
          a.this.dismiss();
          if (a.a(a.this) != null) {
            a.a(a.this).dxH();
          }
          ae.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28218);
          return;
          if (paramAnonymousView.getId() == 2131297710) {
            if (a.b(a.this) == a.a.zdu)
            {
              a.a(a.this, a.a.zdv);
              a.a(a.this, 0);
              a.c(a.this);
              a.d(a.this);
            }
            else if (a.b(a.this) != a.a.zdv)
            {
              if (a.b(a.this) == a.a.zdx)
              {
                a.d(a.this);
              }
              else if (a.b(a.this) == a.a.zdw)
              {
                com.tencent.mm.sdk.b.a.IvT.c(a.e(a.this));
                a.f(a.this);
              }
            }
          }
        }
      }
    };
    ae.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
    this.mResources = paramContext.getResources();
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.iFK = View.inflate(paramContext, 2131495411, null);
    this.zcZ = this.iFK.findViewById(2131304674);
    this.zda = ((TextView)this.iFK.findViewById(2131297918));
    this.zdb = ((TextView)this.iFK.findViewById(2131297902));
    this.zdc = ((TextView)this.iFK.findViewById(2131297776));
    this.vze = ((ImageView)this.iFK.findViewById(2131297757));
    this.oJm = ((Button)this.iFK.findViewById(2131297710));
    this.zdd = ((TextView)this.iFK.findViewById(2131297716));
    this.jtq = ((ProgressBar)this.iFK.findViewById(2131297881));
    this.vze.setOnClickListener(this.jwB);
    this.oJm.setOnClickListener(this.jwB);
    this.xje = this.iFK.findViewById(2131297736);
    this.zde = this.iFK.findViewById(2131306991);
    this.zdf = this.iFK.findViewById(2131297921);
    this.oJl = ((ImageView)this.iFK.findViewById(2131297855));
    this.zdg = ((TextView)this.iFK.findViewById(2131297911));
    this.zdh = ((TextView)this.iFK.findViewById(2131297743));
    this.zdi = ((TextView)this.iFK.findViewById(2131297907));
    this.zdj = this.iFK.findViewById(2131297886);
    this.zdk = ((ImageView)this.iFK.findViewById(2131304143));
    this.ytQ = ((TextView)this.iFK.findViewById(2131304141));
    this.zdn = com.tencent.mm.plugin.shake.c.c.a.dSC();
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
    locala.zcV = parame;
    if (locala.zcV == null) {
      ae.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
    }
    for (;;)
    {
      locala.zdq = paramb;
      locala.show();
      h.a(paramContext, locala);
      AppMethodBeat.o(28231);
      return locala;
      if (TextUtils.isEmpty(locala.zcV.title)) {
        locala.zda.setText(locala.zcV.title);
      }
      ae.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
      locala.zdp = a.zdu;
      locala.updateLayout();
      locala.dSy();
      if (locala.zdn == 0)
      {
        locala.zcZ.setBackgroundResource(2131233966);
        locala.zde.setBackgroundResource(2131233967);
        locala.zda.setTextColor(locala.mResources.getColor(2131100711));
        locala.zdb.setTextColor(locala.mResources.getColor(2131100694));
        locala.zdc.setTextColor(locala.mResources.getColor(2131100694));
        locala.ytQ.setTextColor(locala.getContext().getResources().getColor(2131100711));
        locala.oJm.setBackgroundResource(2131231365);
        locala.oJm.setTextColor(locala.getContext().getResources().getColor(2131101182));
        locala.zdd.setTextColor(locala.getContext().getResources().getColor(2131100704));
      }
    }
  }
  
  private void dSx()
  {
    AppMethodBeat.i(28229);
    if ((this.zdp == a.zdu) || (this.zdp == a.zdx))
    {
      if (TextUtils.isEmpty(this.zcV.zcF))
      {
        this.oJm.setText(2131756801);
        AppMethodBeat.o(28229);
        return;
      }
      this.oJm.setText(this.zcV.zcF);
      AppMethodBeat.o(28229);
      return;
    }
    if (this.zdp == a.zdv)
    {
      this.oJm.setText("");
      AppMethodBeat.o(28229);
      return;
    }
    if (this.zdp == a.zdw) {
      this.oJm.setText(2131763553);
    }
    AppMethodBeat.o(28229);
  }
  
  private void dSy()
  {
    AppMethodBeat.i(28230);
    int i = getContext().getResources().getDimensionPixelOffset(2131166792);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.ZY(this.zcV.hDr));
    this.zdf.setBackgroundDrawable((Drawable)localObject1);
    dSx();
    if (!TextUtils.isEmpty(this.zcV.zcD)) {
      this.zda.setText(this.zcV.zcD);
    }
    if (!TextUtils.isEmpty(this.zcV.zcH))
    {
      this.zdb.setText(this.zcV.zcH);
      this.zdb.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.zcV.zcE))
    {
      this.zdc.setText(this.zcV.zcE);
      this.zdc.setVisibility(0);
    }
    String str;
    if (!TextUtils.isEmpty(this.zcV.hCp))
    {
      i = getContext().getResources().getDimensionPixelSize(2131166791);
      localObject1 = this.oJl;
      str = this.zcV.hCp;
      if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
        break label380;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.zcV.title)) {
        this.zdg.setText(this.zcV.title);
      }
      if (!TextUtils.isEmpty(this.zcV.oFG)) {
        this.zdh.setText(this.zcV.oFG);
      }
      if (this.zcV.oEs > 0) {
        this.zdi.setText(getContext().getString(2131757024, new Object[] { com.tencent.mm.plugin.shake.c.c.a.sz(this.zcV.oEs) }));
      }
      if (this.zdp != a.zdx) {
        break;
      }
      this.zdd.setVisibility(0);
      AppMethodBeat.o(28230);
      return;
      label380:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = new c.a();
        ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.asj();
        com.tencent.mm.av.q.aJc();
        ((c.a)localObject2).igB = null;
        ((c.a)localObject2).hgD = String.format("%s/%s", new Object[] { oGh, g.getMessageDigest(str.getBytes()) });
        ((c.a)localObject2).igk = true;
        ((c.a)localObject2).hhW = true;
        ((c.a)localObject2).igi = true;
        ((c.a)localObject2).hgG = i;
        ((c.a)localObject2).hgF = i;
        ((c.a)localObject2).igv = 2131691160;
        localObject2 = ((c.a)localObject2).aJu();
        com.tencent.mm.av.q.aJb().a(str, (ImageView)localObject1, (com.tencent.mm.av.a.a.c)localObject2);
      }
      else
      {
        ((ImageView)localObject1).setImageResource(2131691160);
      }
    }
    this.zdd.setVisibility(8);
    AppMethodBeat.o(28230);
  }
  
  private void updateLayout()
  {
    AppMethodBeat.i(28228);
    if (this.zdp == a.zdw)
    {
      this.xje.setVisibility(8);
      this.zdj.setVisibility(0);
      AppMethodBeat.o(28228);
      return;
    }
    if ((this.zdp == a.zdu) || (this.zdp == a.zdv) || (this.zdp == a.zdx))
    {
      this.xje.setVisibility(0);
      this.zdj.setVisibility(8);
    }
    AppMethodBeat.o(28228);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(28227);
    try
    {
      if (this.zdq != null) {
        this.zdq.dxH();
      }
      if ((this.zdp != a.zdw) && (!this.zdm))
      {
        this.zdm = true;
        ae.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
        bc.ajj().a(new com.tencent.mm.plugin.shake.c.a.a(this.zcV.oEo, this.zcV.dJc), 0);
      }
      com.tencent.mm.sdk.b.a.IvT.d(this.zdr);
      ae.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
      super.dismiss();
      AppMethodBeat.o(28227);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(28227);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28225);
    super.onCreate(paramBundle);
    setContentView(this.iFK);
    AppMethodBeat.o(28225);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28224);
    if (paramInt == 4)
    {
      ae.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
      dismiss();
      if (this.zdq != null) {
        this.zdq.dxH();
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
      zdu = new a("PRE_ACCEPT", 0);
      zdv = new a("ACCEPTING", 1);
      zdw = new a("ACCEPTED_SUCCES", 2);
      zdx = new a("ACCEPTED_FAIL", 3);
      zdy = new a[] { zdu, zdv, zdw, zdx };
      AppMethodBeat.o(28222);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void dxH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a
 * JD-Core Version:    0.7.0.1
 */