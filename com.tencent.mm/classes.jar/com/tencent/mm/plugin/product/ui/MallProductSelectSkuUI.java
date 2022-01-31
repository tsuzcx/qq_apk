package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class MallProductSelectSkuUI
  extends MallBaseUI
  implements x.a
{
  private TextView iJG;
  private m ptU;
  private e pul;
  private com.tencent.mm.plugin.product.b.c pvR;
  private f pwA;
  private ImageView pwt;
  private TextView pwu;
  private TextView pwv;
  private Button pww;
  private ListView pwx;
  private MallProductSelectAmountView pwy = null;
  private i pwz = null;
  
  private void bJ()
  {
    AppMethodBeat.i(44115);
    if (this.ptU != null)
    {
      if ((this.pul == null) || (this.ptU.puA == null)) {
        break label180;
      }
      this.pwu.setText(b.v(this.pul.pup, this.pul.puq, this.ptU.puA.ppp));
    }
    for (;;)
    {
      if (this.ptU.puA != null) {
        this.iJG.setText(this.ptU.puA.name);
      }
      if (!bo.isNullOrNil(this.pvR.caX()))
      {
        Bitmap localBitmap = x.a(new c(this.pvR.caX()));
        this.pwt.setImageBitmap(localBitmap);
        x.a(this);
      }
      this.pwv.setVisibility(8);
      this.pwy.fh(this.pvR.cbf(), this.pvR.ptU.puz);
      this.pwz.notifyDataSetChanged();
      AppMethodBeat.o(44115);
      return;
      label180:
      this.pwu.setText(b.v(this.ptU.puA.puM, this.ptU.puA.puN, this.ptU.puA.ppp));
    }
  }
  
  public int getLayoutId()
  {
    return 2130970455;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44114);
    setMMTitle(2131301483);
    this.pwt = ((ImageView)findViewById(2131826804));
    this.iJG = ((TextView)findViewById(2131826805));
    this.pwu = ((TextView)findViewById(2131826806));
    this.pwv = ((TextView)findViewById(2131826809));
    this.pww = ((Button)findViewById(2131826810));
    this.pwx = ((ListView)findViewById(2131826807));
    this.pwy = ((MallProductSelectAmountView)findViewById(2131826808));
    this.pwy.setAmount(this.pvR.mCount);
    this.pwz = new i(this);
    if ((this.ptU != null) && (this.ptU.puA != null) && (this.ptU.puA.puU != null)) {
      this.pwz.pwC = this.ptU.puA.puU;
    }
    for (;;)
    {
      this.pwz.pwD = new MallProductSelectSkuUI.2(this);
      this.pwx.setAdapter(this.pwz);
      this.pwy.setOnAmountChangeListener(new MallProductSelectSkuUI.3(this));
      this.pww.setOnClickListener(new MallProductSelectSkuUI.4(this));
      this.pwt.setFocusable(true);
      this.pwt.setFocusableInTouchMode(true);
      this.pwt.requestFocus();
      AppMethodBeat.o(44114);
      return;
      ab.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
    }
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(44117);
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MallProductSelectSkuUI", bool);
      if (!bo.isNullOrNil(this.pvR.caX())) {
        break;
      }
      AppMethodBeat.o(44117);
      return;
    }
    this.pwt.post(new MallProductSelectSkuUI.5(this, paramBitmap));
    AppMethodBeat.o(44117);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(44116);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.pwA.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(44116);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44111);
    super.onCreate(paramBundle);
    this.pwA = new f(getContext(), new MallProductSelectSkuUI.1(this));
    a.caT();
    this.pvR = a.caU();
    this.ptU = this.pvR.ptU;
    initView();
    bJ();
    AppMethodBeat.o(44111);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(44112);
    this.pwA.onStart();
    super.onStart();
    AppMethodBeat.o(44112);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(44113);
    this.pwA.onStop();
    super.onStop();
    AppMethodBeat.o(44113);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI
 * JD-Core Version:    0.7.0.1
 */