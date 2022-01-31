package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class MallProductUI
  extends MallBaseUI
  implements x.a
{
  private Button gJr;
  private TextView kPB;
  protected com.tencent.mm.plugin.product.b.c pvR;
  private HtmlTextView pvx;
  private f pwA;
  private ListView pwZ;
  private TextView pwu;
  private a pxa;
  private LinearLayout pxc;
  private LinearLayout pxd;
  private ImageView pxe;
  private TextView pxf;
  private HtmlTextView pxg;
  private RelativeLayout pxh;
  private ListView pxi;
  private k pxj = null;
  private Button pxk;
  
  protected final void bJ()
  {
    AppMethodBeat.i(44171);
    Object localObject = this.pvR.ptU;
    if (localObject == null)
    {
      showOptionMenu(false);
      AppMethodBeat.o(44171);
      return;
    }
    showOptionMenu(true);
    setContentViewVisibility(0);
    this.pxc.setVisibility(0);
    this.pxd.setVisibility(8);
    if (((m)localObject).puA != null)
    {
      this.kPB.setText(((m)localObject).puA.name);
      this.pwu.setText(com.tencent.mm.plugin.product.b.b.v(((m)localObject).puA.puM, ((m)localObject).puA.puN, ((m)localObject).puA.ppp));
      this.pxf.setText(com.tencent.mm.plugin.product.b.b.d(((m)localObject).puA.puL, ((m)localObject).puA.ppp));
    }
    if (this.pvR.cbf() <= 0)
    {
      this.gJr.setEnabled(false);
      this.gJr.setText(2131301487);
      if ((((m)localObject).puA == null) || (((m)localObject).puA.puV == null) || (((m)localObject).puA.puV.size() <= 0)) {
        break label429;
      }
      this.pwZ.setVisibility(0);
      this.pxa.cx(((m)localObject).puA.puV);
      this.pxa.notifyDataSetChanged();
      label218:
      if ((((m)localObject).puA == null) || (bo.isNullOrNil(((m)localObject).puA.detail))) {
        break label441;
      }
      this.pxh.setVisibility(0);
      this.pvx.setVisibility(0);
      this.pvx.setText(((m)localObject).puA.detail);
      label268:
      if (bo.isNullOrNil(((m)localObject).puG)) {
        break label462;
      }
      this.pxg.setVisibility(0);
      this.pxg.setText(((m)localObject).puG);
    }
    for (;;)
    {
      showOptionMenu(true);
      if (!bo.isNullOrNil(this.pvR.pue))
      {
        localObject = x.a(new c(this.pvR.pue));
        this.pxe.setImageBitmap((Bitmap)localObject);
        x.a(this);
      }
      AppMethodBeat.o(44171);
      return;
      if (this.pvR.ptU.puz <= 0)
      {
        this.gJr.setEnabled(false);
        this.gJr.setText(2131301486);
        break;
      }
      this.gJr.setEnabled(true);
      if (!bo.isNullOrNil(((m)localObject).puF))
      {
        this.gJr.setText(((m)localObject).puF);
        break;
      }
      this.gJr.setText(2131301474);
      break;
      label429:
      this.pwZ.setVisibility(8);
      break label218;
      label441:
      this.pxh.setVisibility(8);
      this.pvx.setVisibility(8);
      break label268;
      label462:
      this.pxg.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2130970460;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44169);
    setMMTitle(2131301503);
    setBackBtn(new MallProductUI.2(this));
    this.pxc = ((LinearLayout)findViewById(2131826832));
    this.pxd = ((LinearLayout)findViewById(2131826843));
    this.pxe = ((ImageView)findViewById(2131826833));
    this.kPB = ((TextView)findViewById(2131826834));
    this.pwu = ((TextView)findViewById(2131826835));
    this.pxf = ((TextView)findViewById(2131826836));
    this.pxf.getPaint().setFlags(16);
    this.pxh = ((RelativeLayout)findViewById(2131826840));
    this.pvx = ((HtmlTextView)findViewById(2131826841));
    this.pxg = ((HtmlTextView)findViewById(2131826838));
    this.pwZ = ((ListView)findViewById(2131826842));
    this.pxa = new a(this);
    this.pwZ.setAdapter(this.pxa);
    this.pwZ.setOnItemClickListener(new MallProductUI.3(this));
    this.pxk = ((Button)findViewById(2131826837));
    this.pxk.setOnClickListener(new MallProductUI.4(this));
    this.pxi = ((ListView)findViewById(2131826844));
    this.pxj = new k(this);
    this.pxj.pwD = new MallProductUI.5(this);
    this.pxi.setAdapter(this.pxj);
    this.gJr = ((Button)findViewById(2131826839));
    this.gJr.setOnClickListener(new MallProductUI.6(this));
    addIconOptionMenu(0, 2130839668, new MallProductUI.7(this));
    showOptionMenu(false);
    this.pxe.setFocusable(true);
    this.pxe.setFocusableInTouchMode(true);
    this.pxe.requestFocus();
    AppMethodBeat.o(44169);
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(44172);
    if ((paramString != null) && (paramString.equals(this.pvR.pue))) {
      this.pxe.post(new MallProductUI.8(this, paramBitmap));
    }
    AppMethodBeat.o(44172);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44166);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    boolean bool = getIntent().getBooleanExtra("key_go_finish", false);
    setResult(-1);
    if (bool)
    {
      finish();
      AppMethodBeat.o(44166);
      return;
    }
    initView();
    com.tencent.mm.plugin.product.a.a.caT();
    this.pvR = com.tencent.mm.plugin.product.a.a.caU();
    this.pwA = new f(getContext(), new MallProductUI.1(this));
    paramBundle = this.pwA;
    Object localObject = getIntent();
    m localm = new m();
    g.RO().a(new f.1(paramBundle, (Intent)localObject, localm));
    paramBundle.pvP = true;
    localObject = new nk();
    ((nk)localObject).cDN.errCode = -1;
    ((nk)localObject).callback = new f.2(paramBundle, (nk)localObject);
    com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
    AppMethodBeat.o(44166);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(44170);
    super.onNewIntent(paramIntent);
    ab.v("MicroMsg.MallProductUI", "onNewIntent");
    setIntent(paramIntent);
    AppMethodBeat.o(44170);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(44168);
    this.pwA.onStop();
    super.onPause();
    AppMethodBeat.o(44168);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44167);
    super.onResume();
    this.pwA.onStart();
    AppMethodBeat.o(44167);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI
 * JD-Core Version:    0.7.0.1
 */