package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallProductSubmitUI
  extends MallBaseUI
  implements x.a
{
  private Button gJr;
  private TextView iJG;
  private com.tencent.mm.plugin.product.b.e pul;
  private com.tencent.mm.plugin.product.b.c pvR;
  private f pwA;
  private RelativeLayout pwQ;
  private TextView pwR;
  private TextView pwS;
  private MallProductItemView pwT;
  private MallProductItemView pwU;
  private TextView pwV;
  private TextView pwW;
  private TextView pwX;
  private TextView pwY;
  private ListView pwZ;
  private ImageView pwt;
  private TextView pwu;
  private a pxa;
  
  private void bJ()
  {
    AppMethodBeat.i(44151);
    m localm = this.pvR.ptU;
    Object localObject1;
    label187:
    String str;
    if (this.pul != null)
    {
      this.pwu.setText(b.v(this.pul.pup, this.pul.pup, localm.puA.ppp) + " x " + this.pvR.mCount);
      if (!bo.isNullOrNil(this.pvR.caX()))
      {
        localObject1 = x.a(new c(this.pvR.caX()));
        this.pwt.setImageBitmap((Bitmap)localObject1);
        x.a(this);
      }
      this.iJG.setText(localm.puA.name);
      this.pwV.setText(this.pvR.caY());
      localObject1 = this.pvR.cbb();
      if ((localObject1 == null) || (bo.isNullOrNil(((bse)localObject1).nqY))) {
        break label593;
      }
      this.pwU.setSummary(((bse)localObject1).nqY);
      str = "";
      localObject1 = str;
      if (!this.pvR.caW().cbs())
      {
        localObject1 = this.pvR.pub;
        if (localObject1 == null) {
          break label605;
        }
        this.pwT.setEnabled(true);
        this.pwT.setClickable(true);
        this.pwT.setSummary(b.a(this, (aan)localObject1));
        localObject1 = getString(2131301498, new Object[] { b.d(((aan)localObject1).wCm, ((aan)localObject1).PriceType) });
        this.pwS.setVisibility(8);
      }
      label280:
      str = "";
      int i = this.pvR.cba();
      if (i > 0)
      {
        bo.isNullOrNil((String)localObject1);
        str = getString(2131301497, new Object[] { b.d(i, localm.puA.ppp) });
      }
      Object localObject2 = this.pvR.ad(this);
      if (((LinkedList)localObject2).size() <= 0) {
        break label648;
      }
      this.pwZ.setVisibility(0);
      this.pxa.cx((List)localObject2);
      this.pxa.notifyDataSetChanged();
      label369:
      localObject2 = this.pvR.puc;
      if (localObject2 != null) {
        this.pwR.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[] { ((cx)localObject2).jJA, ((cx)localObject2).wpj, ((cx)localObject2).gwQ, ((cx)localObject2).gwR, ((cx)localObject2).nqY })));
      }
      localObject1 = (String)localObject1 + str;
      if (bo.isNullOrNil((String)localObject1)) {
        break label660;
      }
      localObject1 = getString(2131301496, new Object[] { localObject1 });
      this.pwW.setText((CharSequence)localObject1);
      this.pwX.setVisibility(8);
      this.pwW.setVisibility(0);
    }
    for (;;)
    {
      this.pwY.setText(b.d(this.pvR.caZ(), localm.puA.ppp));
      this.gJr.setEnabled(this.pvR.cbi());
      AppMethodBeat.o(44151);
      return;
      this.pwu.setText(b.v(localm.puA.puM, localm.puA.puN, localm.puA.ppp));
      break;
      label593:
      this.pwU.setSummary("");
      break label187;
      label605:
      this.pwT.setEnabled(false);
      this.pwT.setClickable(false);
      this.pwT.setSummary(getString(2131301499));
      this.pwS.setVisibility(0);
      localObject1 = str;
      break label280;
      label648:
      this.pwZ.setVisibility(8);
      break label369;
      label660:
      this.pwX.setVisibility(0);
      this.pwW.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2130970458;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44150);
    setMMTitle(2131301502);
    this.pwQ = ((RelativeLayout)findViewById(2131826815));
    this.pwR = ((TextView)findViewById(2131826817));
    this.pwS = ((TextView)findViewById(2131826818));
    this.pwT = ((MallProductItemView)findViewById(2131826819));
    this.pwU = ((MallProductItemView)findViewById(2131826820));
    this.pwt = ((ImageView)findViewById(2131826821));
    this.iJG = ((TextView)findViewById(2131826822));
    this.pwV = ((TextView)findViewById(2131826823));
    this.pwu = ((TextView)findViewById(2131826824));
    this.pwW = ((TextView)findViewById(2131826828));
    this.pwX = ((TextView)findViewById(2131826827));
    this.pwY = ((TextView)findViewById(2131826826));
    this.pwZ = ((ListView)findViewById(2131826825));
    this.pxa = new a(this);
    this.pwZ.setAdapter(this.pxa);
    this.pwZ.setOnItemClickListener(new MallProductSubmitUI.2(this));
    this.gJr = ((Button)findViewById(2131826829));
    this.gJr.setOnClickListener(new MallProductSubmitUI.3(this));
    this.pwQ.setOnClickListener(new MallProductSubmitUI.4(this));
    this.pwT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(44143);
        MallProductSubmitUI.this.showDialog(1);
        AppMethodBeat.o(44143);
      }
    });
    this.pwU.setOnClickListener(new MallProductSubmitUI.6(this));
    MallProductItemView localMallProductItemView = this.pwU;
    boolean bool;
    if ((this.pvR.caW().pvO & 0x2) > 0)
    {
      bool = true;
      ab.d("MicroMsg.MallProductConfig", "hasReceipt, ret = ".concat(String.valueOf(bool)));
      if (!bool) {
        break label411;
      }
    }
    label411:
    for (int i = 0;; i = 8)
    {
      localMallProductItemView.setVisibility(i);
      if (this.pvR.caW().cbs())
      {
        this.pwT.setEnabled(false);
        this.pwT.setClickable(false);
        this.pwT.setSummary(getString(2131301500));
      }
      AppMethodBeat.o(44150);
      return;
      bool = false;
      break;
    }
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(44153);
    paramString = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MallProductSubmitUI", bool);
      if (!bo.isNullOrNil(this.pvR.caX())) {
        break;
      }
      AppMethodBeat.o(44153);
      return;
    }
    this.pwt.post(new MallProductSubmitUI.7(this, paramBitmap));
    AppMethodBeat.o(44153);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(44152);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.pwA.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(44152);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44147);
    super.onCreate(paramBundle);
    this.pwA = new f(getContext(), new MallProductSubmitUI.1(this));
    com.tencent.mm.plugin.product.a.a.caT();
    this.pvR = com.tencent.mm.plugin.product.a.a.caU();
    this.pul = this.pvR.pul;
    initView();
    bJ();
    AppMethodBeat.o(44147);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(44154);
    switch (paramInt)
    {
    }
    do
    {
      localObject1 = super.onCreateDialog(paramInt);
      AppMethodBeat.o(44154);
      return localObject1;
      localObject2 = this.pvR.puj;
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(b.a(this, (aan)((Iterator)localObject2).next()));
    }
    localObject2 = getString(2131301491);
    MallProductSubmitUI.8 local8 = new MallProductSubmitUI.8(this);
    d.a locala = new d.a(this);
    ListViewInScrollView localListViewInScrollView = (ListViewInScrollView)View.inflate(this, 2130970172, null);
    localListViewInScrollView.setOnItemClickListener(new d.1(local8, locala));
    locala.pvI = ((List)localObject1);
    locala.pvJ = 0;
    localListViewInScrollView.setAdapter(locala);
    localObject1 = new c.a(this);
    ((c.a)localObject1).avm((String)localObject2);
    ((c.a)localObject1).fu(localListViewInScrollView);
    ((c.a)localObject1).e(null);
    localObject1 = ((c.a)localObject1).aLZ();
    ((com.tencent.mm.ui.widget.b.c)localObject1).show();
    AppMethodBeat.o(44154);
    return localObject1;
  }
  
  public void onStart()
  {
    AppMethodBeat.i(44148);
    this.pwA.onStart();
    super.onStart();
    AppMethodBeat.o(44148);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(44149);
    this.pwA.onStop();
    super.onStop();
    AppMethodBeat.o(44149);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI
 * JD-Core Version:    0.7.0.1
 */