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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.pm.b;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a
  extends i
{
  private static final String inc = com.tencent.mm.compatible.util.e.bkH + "card";
  private boolean fsA;
  private ProgressBar fsc;
  private View.OnClickListener fvj = new a.2(this);
  private String ijW = "";
  private ImageView ipO;
  private Button ipP;
  private View ipf;
  private ImageView lOR;
  private Resources mResources;
  private TextView nCW;
  private com.tencent.mm.plugin.shake.c.a.e nZK;
  private View nZO;
  private TextView nZP;
  private TextView nZQ;
  private TextView nZR;
  private TextView nZS;
  private View nZT;
  private View nZU;
  private View nZV;
  private TextView nZW;
  private TextView nZX;
  private TextView nZY;
  private View nZZ;
  private ImageView oaa;
  public boolean oab = false;
  private boolean oac = false;
  private int oad = 0;
  private pm.b oae;
  private a.a oaf = a.a.oak;
  private a.b oag;
  private com.tencent.mm.sdk.b.c oah = new a.1(this);
  
  private a(Context paramContext)
  {
    super(paramContext, R.m.mmcarddialog);
    y.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
    this.mResources = paramContext.getResources();
    setCanceledOnTouchOutside(true);
    getWindow().setSoftInputMode(2);
    this.ipf = View.inflate(paramContext, R.i.shake_card_dialog, null);
    this.nZO = this.ipf.findViewById(R.h.shake_card_dialog);
    this.nZP = ((TextView)this.ipf.findViewById(R.h.card_view_title));
    this.nZQ = ((TextView)this.ipf.findViewById(R.h.card_sub_title));
    this.nZR = ((TextView)this.ipf.findViewById(R.h.card_desc));
    this.lOR = ((ImageView)this.ipf.findViewById(R.h.card_close_img));
    this.ipP = ((Button)this.ipf.findViewById(R.h.card_accept_btn));
    this.nZS = ((TextView)this.ipf.findViewById(R.h.card_accept_fail_tip));
    this.fsc = ((ProgressBar)this.ipf.findViewById(R.h.card_progress_bar));
    this.lOR.setOnClickListener(this.fvj);
    this.ipP.setOnClickListener(this.fvj);
    this.nZT = this.ipf.findViewById(R.h.card_base_info_layout);
    this.nZU = this.ipf.findViewById(R.h.widget_body);
    this.nZV = this.ipf.findViewById(R.h.card_widget_header);
    this.ipO = ((ImageView)this.ipf.findViewById(R.h.card_logo));
    this.nZW = ((TextView)this.ipf.findViewById(R.h.card_title));
    this.nZX = ((TextView)this.ipf.findViewById(R.h.card_brand_name));
    this.nZY = ((TextView)this.ipf.findViewById(R.h.card_time));
    this.nZZ = this.ipf.findViewById(R.h.card_result_layout);
    this.oaa = ((ImageView)this.ipf.findViewById(R.h.result_icon));
    this.nCW = ((TextView)this.ipf.findViewById(R.h.result_desc));
    this.oad = com.tencent.mm.plugin.shake.c.c.a.bAl();
  }
  
  public static a a(Context paramContext, com.tencent.mm.plugin.shake.c.a.e parame, DialogInterface.OnCancelListener paramOnCancelListener, a.b paramb)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return null;
    }
    a locala = new a(paramContext);
    locala.setOnCancelListener(paramOnCancelListener);
    locala.setCancelable(true);
    locala.nZK = parame;
    if (locala.nZK == null) {
      y.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
    }
    for (;;)
    {
      locala.oag = paramb;
      locala.show();
      h.a(paramContext, locala);
      return locala;
      if (TextUtils.isEmpty(locala.nZK.title)) {
        locala.nZP.setText(locala.nZK.title);
      }
      y.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
      locala.oaf = a.a.oak;
      locala.bAg();
      locala.bAi();
      if (locala.oad == 0)
      {
        locala.nZO.setBackgroundResource(R.g.shake_card_dialog_no_activity_bg);
        locala.nZU.setBackgroundResource(R.g.shake_card_normal_widget_body_bg);
        locala.nZP.setTextColor(locala.mResources.getColor(R.e.black));
        locala.nZQ.setTextColor(locala.mResources.getColor(R.e.navbar_text_normal));
        locala.nZR.setTextColor(locala.mResources.getColor(R.e.navbar_text_normal));
        locala.nCW.setTextColor(locala.getContext().getResources().getColor(R.e.black));
        locala.ipP.setBackgroundResource(R.g.btn_solid_green);
        locala.ipP.setTextColor(locala.getContext().getResources().getColor(R.e.white));
        locala.nZS.setTextColor(locala.getContext().getResources().getColor(R.e.noactivity_accept_fail_tip_color));
      }
    }
  }
  
  private void bAg()
  {
    if (this.oaf == a.a.oam)
    {
      this.nZT.setVisibility(8);
      this.nZZ.setVisibility(0);
    }
    while ((this.oaf != a.a.oak) && (this.oaf != a.a.oal) && (this.oaf != a.a.oan)) {
      return;
    }
    this.nZT.setVisibility(0);
    this.nZZ.setVisibility(8);
  }
  
  private void bAh()
  {
    if ((this.oaf == a.a.oak) || (this.oaf == a.a.oan)) {
      if (TextUtils.isEmpty(this.nZK.nZu)) {
        this.ipP.setText(R.l.card_add);
      }
    }
    do
    {
      return;
      this.ipP.setText(this.nZK.nZu);
      return;
      if (this.oaf == a.a.oal)
      {
        this.ipP.setText("");
        return;
      }
    } while (this.oaf != a.a.oam);
    this.ipP.setText(R.l.shake_check_card_detail);
  }
  
  private void bAi()
  {
    int i = getContext().getResources().getDimensionPixelOffset(R.f.shake_card_widget_bg_corner);
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F }, null, null));
    ((ShapeDrawable)localObject1).getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.yR(this.nZK.color));
    this.nZV.setBackgroundDrawable((Drawable)localObject1);
    bAh();
    if (!TextUtils.isEmpty(this.nZK.nZs)) {
      this.nZP.setText(this.nZK.nZs);
    }
    if (!TextUtils.isEmpty(this.nZK.nZw))
    {
      this.nZQ.setText(this.nZK.nZw);
      this.nZQ.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.nZK.nZt))
    {
      this.nZR.setText(this.nZK.nZt);
      this.nZR.setVisibility(0);
    }
    String str;
    int j;
    if (!TextUtils.isEmpty(this.nZK.ilp))
    {
      i = getContext().getResources().getDimensionPixelSize(R.f.shake_card_logo_height);
      localObject1 = this.ipO;
      str = this.nZK.ilp;
      j = R.k.shake_card_package_defaultlogo;
      if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
        break label374;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.nZK.title)) {
        this.nZW.setText(this.nZK.title);
      }
      if (!TextUtils.isEmpty(this.nZK.imA)) {
        this.nZX.setText(this.nZK.imA);
      }
      if (this.nZK.end_time > 0) {
        this.nZY.setText(getContext().getString(R.l.card_validate_to, new Object[] { com.tencent.mm.plugin.shake.c.c.a.ce(this.nZK.end_time) }));
      }
      if (this.oaf != a.a.oan) {
        break;
      }
      this.nZS.setVisibility(0);
      return;
      label374:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = new c.a();
        ((c.a)localObject2).eri = com.tencent.mm.compatible.util.e.bkH;
        o.OO();
        ((c.a)localObject2).erB = null;
        ((c.a)localObject2).erh = String.format("%s/%s", new Object[] { inc, g.o(str.getBytes()) });
        ((c.a)localObject2).erf = true;
        ((c.a)localObject2).erD = true;
        ((c.a)localObject2).erd = true;
        ((c.a)localObject2).erm = i;
        ((c.a)localObject2).erl = i;
        ((c.a)localObject2).eru = j;
        localObject2 = ((c.a)localObject2).OV();
        o.ON().a(str, (ImageView)localObject1, (com.tencent.mm.as.a.a.c)localObject2);
      }
      else
      {
        ((ImageView)localObject1).setImageResource(j);
      }
    }
    this.nZS.setVisibility(8);
  }
  
  public final void dismiss()
  {
    try
    {
      if (this.oag != null) {
        this.oag.bAj();
      }
      if ((this.oaf != a.a.oam) && (!this.oac))
      {
        this.oac = true;
        y.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
        au.Dk().a(new com.tencent.mm.plugin.shake.c.a.a(this.nZK.iln, this.nZK.bZd), 0);
      }
      com.tencent.mm.sdk.b.a.udP.d(this.oah);
      y.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + localException.getMessage());
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.ipf);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      y.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
      dismiss();
      if (this.oag != null) {
        this.oag.bAj();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    this.fsA = paramBoolean;
    setCanceledOnTouchOutside(this.fsA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a
 * JD-Core Version:    0.7.0.1
 */