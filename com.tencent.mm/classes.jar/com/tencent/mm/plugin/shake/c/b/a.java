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
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.b;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a
  extends i
{
  private static final String ntl;
  private View hIZ;
  private View.OnClickListener iAw;
  private ProgressBar ixl;
  private boolean lA;
  private Resources mResources;
  private String nqb;
  private ImageView nwp;
  private Button nwq;
  private ImageView tcc;
  private View uDn;
  private TextView vGm;
  private e wmK;
  private View wmO;
  private TextView wmP;
  private TextView wmQ;
  private TextView wmR;
  private TextView wmS;
  private View wmT;
  private View wmU;
  private TextView wmV;
  private TextView wmW;
  private TextView wmX;
  private View wmY;
  private ImageView wmZ;
  public boolean wna;
  private boolean wnb;
  private int wnc;
  private sm.b wnd;
  private a wne;
  private b wnf;
  private com.tencent.mm.sdk.b.c wng;
  
  static
  {
    AppMethodBeat.i(28239);
    ntl = b.aih() + "card";
    AppMethodBeat.o(28239);
  }
  
  private a(Context paramContext)
  {
    super(paramContext, 2131821724);
    AppMethodBeat.i(28223);
    this.wna = false;
    this.wnb = false;
    this.wnc = 0;
    this.nqb = "";
    this.wne = a.wnj;
    this.wng = new com.tencent.mm.sdk.b.c() {};
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28218);
        if (paramAnonymousView.getId() == 2131297757)
        {
          a.this.dismiss();
          if (a.a(a.this) != null) {
            a.a(a.this).cWw();
          }
          ad.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
          AppMethodBeat.o(28218);
          return;
        }
        if (paramAnonymousView.getId() == 2131297710)
        {
          if (a.b(a.this) == a.a.wnj)
          {
            a.a(a.this, a.a.wnk);
            a.a(a.this, 0);
            a.c(a.this);
            a.d(a.this);
            AppMethodBeat.o(28218);
            return;
          }
          if (a.b(a.this) != a.a.wnk)
          {
            if (a.b(a.this) == a.a.wnm)
            {
              a.d(a.this);
              AppMethodBeat.o(28218);
              return;
            }
            if (a.b(a.this) == a.a.wnl)
            {
              com.tencent.mm.sdk.b.a.ESL.c(a.e(a.this));
              a.f(a.this);
            }
          }
        }
        AppMethodBeat.o(28218);
      }
    };
    ad.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
    this.mResources = paramContext.getResources();
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.hIZ = View.inflate(paramContext, 2131495411, null);
    this.wmO = this.hIZ.findViewById(2131304674);
    this.wmP = ((TextView)this.hIZ.findViewById(2131297918));
    this.wmQ = ((TextView)this.hIZ.findViewById(2131297902));
    this.wmR = ((TextView)this.hIZ.findViewById(2131297776));
    this.tcc = ((ImageView)this.hIZ.findViewById(2131297757));
    this.nwq = ((Button)this.hIZ.findViewById(2131297710));
    this.wmS = ((TextView)this.hIZ.findViewById(2131297716));
    this.ixl = ((ProgressBar)this.hIZ.findViewById(2131297881));
    this.tcc.setOnClickListener(this.iAw);
    this.nwq.setOnClickListener(this.iAw);
    this.uDn = this.hIZ.findViewById(2131297736);
    this.wmT = this.hIZ.findViewById(2131306991);
    this.wmU = this.hIZ.findViewById(2131297921);
    this.nwp = ((ImageView)this.hIZ.findViewById(2131297855));
    this.wmV = ((TextView)this.hIZ.findViewById(2131297911));
    this.wmW = ((TextView)this.hIZ.findViewById(2131297743));
    this.wmX = ((TextView)this.hIZ.findViewById(2131297907));
    this.wmY = this.hIZ.findViewById(2131297886);
    this.wmZ = ((ImageView)this.hIZ.findViewById(2131304143));
    this.vGm = ((TextView)this.hIZ.findViewById(2131304141));
    this.wnc = com.tencent.mm.plugin.shake.c.c.a.dps();
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
    locala.wmK = parame;
    if (locala.wmK == null) {
      ad.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
    }
    for (;;)
    {
      locala.wnf = paramb;
      locala.show();
      h.a(paramContext, locala);
      AppMethodBeat.o(28231);
      return locala;
      if (TextUtils.isEmpty(locala.wmK.title)) {
        locala.wmP.setText(locala.wmK.title);
      }
      ad.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
      locala.wne = a.wnj;
      locala.updateLayout();
      locala.dpo();
      if (locala.wnc == 0)
      {
        locala.wmO.setBackgroundResource(2131233966);
        locala.wmT.setBackgroundResource(2131233967);
        locala.wmP.setTextColor(locala.mResources.getColor(2131100711));
        locala.wmQ.setTextColor(locala.mResources.getColor(2131100694));
        locala.wmR.setTextColor(locala.mResources.getColor(2131100694));
        locala.vGm.setTextColor(locala.getContext().getResources().getColor(2131100711));
        locala.nwq.setBackgroundResource(2131231365);
        locala.nwq.setTextColor(locala.getContext().getResources().getColor(2131101182));
        locala.wmS.setTextColor(locala.getContext().getResources().getColor(2131100704));
      }
    }
  }
  
  private void dpn()
  {
    AppMethodBeat.i(28229);
    if ((this.wne == a.wnj) || (this.wne == a.wnm))
    {
      if (TextUtils.isEmpty(this.wmK.wmu))
      {
        this.nwq.setText(2131756801);
        AppMethodBeat.o(28229);
        return;
      }
      this.nwq.setText(this.wmK.wmu);
      AppMethodBeat.o(28229);
      return;
    }
    if (this.wne == a.wnk)
    {
      this.nwq.setText("");
      AppMethodBeat.o(28229);
      return;
    }
    if (this.wne == a.wnl) {
      this.nwq.setText(2131763553);
    }
    AppMethodBeat.o(28229);
  }
  
  private void dpo()
  {
    AppMethodBeat.i(28230);
    int i = getContext().getResources().getDimensionPixelOffset(2131166792);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.Rm(this.wmK.gHT));
    this.wmU.setBackgroundDrawable((Drawable)localObject1);
    dpn();
    if (!TextUtils.isEmpty(this.wmK.wms)) {
      this.wmP.setText(this.wmK.wms);
    }
    if (!TextUtils.isEmpty(this.wmK.wmw))
    {
      this.wmQ.setText(this.wmK.wmw);
      this.wmQ.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.wmK.wmt))
    {
      this.wmR.setText(this.wmK.wmt);
      this.wmR.setVisibility(0);
    }
    String str;
    if (!TextUtils.isEmpty(this.wmK.gGR))
    {
      i = getContext().getResources().getDimensionPixelSize(2131166791);
      localObject1 = this.nwp;
      str = this.wmK.gGR;
      if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
        break label380;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.wmK.title)) {
        this.wmV.setText(this.wmK.title);
      }
      if (!TextUtils.isEmpty(this.wmK.nsK)) {
        this.wmW.setText(this.wmK.nsK);
      }
      if (this.wmK.nrv > 0) {
        this.wmX.setText(getContext().getString(2131757024, new Object[] { com.tencent.mm.plugin.shake.c.c.a.mz(this.wmK.nrv) }));
      }
      if (this.wne != a.wnm) {
        break;
      }
      this.wmS.setVisibility(0);
      AppMethodBeat.o(28230);
      return;
      label380:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = new c.a();
        ((c.a)localObject2).prefixPath = b.aih();
        o.ayK();
        ((c.a)localObject2).hkl = null;
        ((c.a)localObject2).gjt = String.format("%s/%s", new Object[] { ntl, g.getMessageDigest(str.getBytes()) });
        ((c.a)localObject2).hjU = true;
        ((c.a)localObject2).gkG = true;
        ((c.a)localObject2).hjS = true;
        ((c.a)localObject2).gjw = i;
        ((c.a)localObject2).gjv = i;
        ((c.a)localObject2).hkf = 2131691160;
        localObject2 = ((c.a)localObject2).azc();
        o.ayJ().a(str, (ImageView)localObject1, (com.tencent.mm.aw.a.a.c)localObject2);
      }
      else
      {
        ((ImageView)localObject1).setImageResource(2131691160);
      }
    }
    this.wmS.setVisibility(8);
    AppMethodBeat.o(28230);
  }
  
  private void updateLayout()
  {
    AppMethodBeat.i(28228);
    if (this.wne == a.wnl)
    {
      this.uDn.setVisibility(8);
      this.wmY.setVisibility(0);
      AppMethodBeat.o(28228);
      return;
    }
    if ((this.wne == a.wnj) || (this.wne == a.wnk) || (this.wne == a.wnm))
    {
      this.uDn.setVisibility(0);
      this.wmY.setVisibility(8);
    }
    AppMethodBeat.o(28228);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(28227);
    try
    {
      if (this.wnf != null) {
        this.wnf.cWw();
      }
      if ((this.wne != a.wnl) && (!this.wnb))
      {
        this.wnb = true;
        ad.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
        az.aeS().a(new com.tencent.mm.plugin.shake.c.a.a(this.wmK.nrr, this.wmK.dyd), 0);
      }
      com.tencent.mm.sdk.b.a.ESL.d(this.wng);
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
    setContentView(this.hIZ);
    AppMethodBeat.o(28225);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28224);
    if (paramInt == 4)
    {
      ad.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
      dismiss();
      if (this.wnf != null) {
        this.wnf.cWw();
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
    this.lA = paramBoolean;
    setCanceledOnTouchOutside(this.lA);
    AppMethodBeat.o(28226);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(28222);
      wnj = new a("PRE_ACCEPT", 0);
      wnk = new a("ACCEPTING", 1);
      wnl = new a("ACCEPTED_SUCCES", 2);
      wnm = new a("ACCEPTED_FAIL", 3);
      wnn = new a[] { wnj, wnk, wnl, wnm };
      AppMethodBeat.o(28222);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void cWw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a
 * JD-Core Version:    0.7.0.1
 */