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
import com.tencent.mm.a.g;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.qt.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a
  extends i
{
  private static final String knX;
  private ProgressBar gJE;
  private boolean gKc;
  private View.OnClickListener gMO;
  private View iCk;
  private String kkW;
  private ImageView kqW;
  private Button kqX;
  private Resources mResources;
  private ImageView oml;
  private View pBF;
  private com.tencent.mm.plugin.shake.c.a.e qNU;
  private View qNY;
  private TextView qNZ;
  private TextView qOa;
  private TextView qOb;
  private TextView qOc;
  private View qOd;
  private View qOe;
  private TextView qOf;
  private TextView qOg;
  private TextView qOh;
  private View qOi;
  private ImageView qOj;
  public boolean qOk;
  private boolean qOl;
  private int qOm;
  private qt.b qOn;
  private a.a qOo;
  private a.b qOp;
  private com.tencent.mm.sdk.b.c qOq;
  private TextView qpb;
  
  static
  {
    AppMethodBeat.i(24569);
    knX = com.tencent.mm.compatible.util.e.eQz + "card";
    AppMethodBeat.o(24569);
  }
  
  private a(Context paramContext)
  {
    super(paramContext, 2131493882);
    AppMethodBeat.i(24553);
    this.qOk = false;
    this.qOl = false;
    this.qOm = 0;
    this.kkW = "";
    this.qOo = a.a.qOt;
    this.qOq = new a.1(this);
    this.gMO = new a.2(this);
    ab.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
    this.mResources = paramContext.getResources();
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.iCk = View.inflate(paramContext, 2130970708, null);
    this.qNY = this.iCk.findViewById(2131827685);
    this.qNZ = ((TextView)this.iCk.findViewById(2131827687));
    this.qOa = ((TextView)this.iCk.findViewById(2131822396));
    this.qOb = ((TextView)this.iCk.findViewById(2131827688));
    this.oml = ((ImageView)this.iCk.findViewById(2131827694));
    this.kqX = ((Button)this.iCk.findViewById(2131821984));
    this.qOc = ((TextView)this.iCk.findViewById(2131827693));
    this.gJE = ((ProgressBar)this.iCk.findViewById(2131827692));
    this.oml.setOnClickListener(this.gMO);
    this.kqX.setOnClickListener(this.gMO);
    this.pBF = this.iCk.findViewById(2131827686);
    this.qOd = this.iCk.findViewById(2131822056);
    this.qOe = this.iCk.findViewById(2131827695);
    this.kqW = ((ImageView)this.iCk.findViewById(2131827696));
    this.qOf = ((TextView)this.iCk.findViewById(2131822059));
    this.qOg = ((TextView)this.iCk.findViewById(2131821971));
    this.qOh = ((TextView)this.iCk.findViewById(2131827699));
    this.qOi = this.iCk.findViewById(2131827689);
    this.qOj = ((ImageView)this.iCk.findViewById(2131827690));
    this.qpb = ((TextView)this.iCk.findViewById(2131827691));
    this.qOm = com.tencent.mm.plugin.shake.c.c.a.clF();
    AppMethodBeat.o(24553);
  }
  
  public static a a(Context paramContext, com.tencent.mm.plugin.shake.c.a.e parame, DialogInterface.OnCancelListener paramOnCancelListener, a.b paramb)
  {
    AppMethodBeat.i(24561);
    if (((Activity)paramContext).isFinishing())
    {
      AppMethodBeat.o(24561);
      return null;
    }
    a locala = new a(paramContext);
    locala.setOnCancelListener(paramOnCancelListener);
    locala.setCancelable(true);
    locala.qNU = parame;
    if (locala.qNU == null) {
      ab.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
    }
    for (;;)
    {
      locala.qOp = paramb;
      locala.show();
      h.a(paramContext, locala);
      AppMethodBeat.o(24561);
      return locala;
      if (TextUtils.isEmpty(locala.qNU.title)) {
        locala.qNZ.setText(locala.qNU.title);
      }
      ab.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
      locala.qOo = a.a.qOt;
      locala.updateLayout();
      locala.clA();
      if (locala.qOm == 0)
      {
        locala.qNY.setBackgroundResource(2130840256);
        locala.qOd.setBackgroundResource(2130840257);
        locala.qNZ.setTextColor(locala.mResources.getColor(2131689763));
        locala.qOa.setTextColor(locala.mResources.getColor(2131690309));
        locala.qOb.setTextColor(locala.mResources.getColor(2131690309));
        locala.qpb.setTextColor(locala.getContext().getResources().getColor(2131689763));
        locala.kqX.setBackgroundResource(2130838045);
        locala.kqX.setTextColor(locala.getContext().getResources().getColor(2131690709));
        locala.qOc.setTextColor(locala.getContext().getResources().getColor(2131690315));
      }
    }
  }
  
  private void clA()
  {
    AppMethodBeat.i(24560);
    int i = getContext().getResources().getDimensionPixelOffset(2131428666);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.IB(this.qNU.color));
    this.qOe.setBackgroundDrawable((Drawable)localObject1);
    clz();
    if (!TextUtils.isEmpty(this.qNU.qNC)) {
      this.qNZ.setText(this.qNU.qNC);
    }
    if (!TextUtils.isEmpty(this.qNU.qNG))
    {
      this.qOa.setText(this.qNU.qNG);
      this.qOa.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.qNU.qND))
    {
      this.qOb.setText(this.qNU.qND);
      this.qOb.setVisibility(0);
    }
    String str;
    if (!TextUtils.isEmpty(this.qNU.kmm))
    {
      i = getContext().getResources().getDimensionPixelSize(2131428665);
      localObject1 = this.kqW;
      str = this.qNU.kmm;
      if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
        break label380;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.qNU.title)) {
        this.qOf.setText(this.qNU.title);
      }
      if (!TextUtils.isEmpty(this.qNU.knw)) {
        this.qOg.setText(this.qNU.knw);
      }
      if (this.qNU.kmq > 0) {
        this.qOh.setText(getContext().getString(2131298082, new Object[] { com.tencent.mm.plugin.shake.c.c.a.ha(this.qNU.kmq) }));
      }
      if (this.qOo != a.a.qOw) {
        break;
      }
      this.qOc.setVisibility(0);
      AppMethodBeat.o(24560);
      return;
      label380:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = new c.a();
        ((c.a)localObject2).eNP = com.tencent.mm.compatible.util.e.eQz;
        o.ahH();
        ((c.a)localObject2).eOd = null;
        ((c.a)localObject2).eNO = String.format("%s/%s", new Object[] { knX, g.w(str.getBytes()) });
        ((c.a)localObject2).eNM = true;
        ((c.a)localObject2).eOk = true;
        ((c.a)localObject2).eNK = true;
        ((c.a)localObject2).eNT = i;
        ((c.a)localObject2).eNS = i;
        ((c.a)localObject2).eNY = 2131231974;
        localObject2 = ((c.a)localObject2).ahY();
        o.ahG().a(str, (ImageView)localObject1, (com.tencent.mm.at.a.a.c)localObject2);
      }
      else
      {
        ((ImageView)localObject1).setImageResource(2131231974);
      }
    }
    this.qOc.setVisibility(8);
    AppMethodBeat.o(24560);
  }
  
  private void clz()
  {
    AppMethodBeat.i(24559);
    if ((this.qOo == a.a.qOt) || (this.qOo == a.a.qOw))
    {
      if (TextUtils.isEmpty(this.qNU.qNE))
      {
        this.kqX.setText(2131297869);
        AppMethodBeat.o(24559);
        return;
      }
      this.kqX.setText(this.qNU.qNE);
      AppMethodBeat.o(24559);
      return;
    }
    if (this.qOo == a.a.qOu)
    {
      this.kqX.setText("");
      AppMethodBeat.o(24559);
      return;
    }
    if (this.qOo == a.a.qOv) {
      this.kqX.setText(2131303571);
    }
    AppMethodBeat.o(24559);
  }
  
  private void updateLayout()
  {
    AppMethodBeat.i(24558);
    if (this.qOo == a.a.qOv)
    {
      this.pBF.setVisibility(8);
      this.qOi.setVisibility(0);
      AppMethodBeat.o(24558);
      return;
    }
    if ((this.qOo == a.a.qOt) || (this.qOo == a.a.qOu) || (this.qOo == a.a.qOw))
    {
      this.pBF.setVisibility(0);
      this.qOi.setVisibility(8);
    }
    AppMethodBeat.o(24558);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(24557);
    try
    {
      if (this.qOp != null) {
        this.qOp.clB();
      }
      if ((this.qOo != a.a.qOv) && (!this.qOl))
      {
        this.qOl = true;
        ab.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
        aw.Rc().a(new com.tencent.mm.plugin.shake.c.a.a(this.qNU.kml, this.qNU.cHo), 0);
      }
      com.tencent.mm.sdk.b.a.ymk.d(this.qOq);
      ab.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
      super.dismiss();
      AppMethodBeat.o(24557);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(24557);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24555);
    super.onCreate(paramBundle);
    setContentView(this.iCk);
    AppMethodBeat.o(24555);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24554);
    if (paramInt == 4)
    {
      ab.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
      dismiss();
      if (this.qOp != null) {
        this.qOp.clB();
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(24554);
    return bool;
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(24556);
    super.setCancelable(paramBoolean);
    this.gKc = paramBoolean;
    setCanceledOnTouchOutside(this.gKc);
    AppMethodBeat.o(24556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a
 * JD-Core Version:    0.7.0.1
 */