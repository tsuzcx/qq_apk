package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.b;
import java.util.LinkedList;

public class NearLifeCreatePoiUI
  extends MMActivity
  implements g
{
  private TextWatcher atH;
  private p ftP;
  private String jko;
  private bld ucT;
  private String ucU;
  private String ucV;
  private Addr ucW;
  private String ucX;
  private EditText ucY;
  private EditText ucZ;
  private TextView uda;
  private TextView udb;
  private com.tencent.mm.modelgeo.c udc;
  private com.tencent.mm.plugin.nearlife.b.c udd;
  private View.OnClickListener ude;
  private View.OnClickListener udf;
  private View.OnClickListener udg;
  private MenuItem.OnMenuItemClickListener udh;
  private c.a udi;
  private MenuItem.OnMenuItemClickListener udj;
  
  public NearLifeCreatePoiUI()
  {
    AppMethodBeat.i(26606);
    this.ude = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26597);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("ui_title", 2131761615);
        if (NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this) != null)
        {
          paramAnonymousView.putExtra("extra_province", NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this).hdR);
          paramAnonymousView.putExtra("extra_city", NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this).hdS);
        }
        d.b(NearLifeCreatePoiUI.this.getContext(), "address", ".ui.WalletMultiRcptSelectUI", paramAnonymousView, 1);
        AppMethodBeat.o(26597);
      }
    };
    this.udf = new NearLifeCreatePoiUI.2(this);
    this.udg = new NearLifeCreatePoiUI.3(this);
    this.udh = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26601);
        com.tencent.mm.plugin.report.service.h.vKh.f(11138, new Object[] { "2", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        paramAnonymousMenuItem = NearLifeCreatePoiUI.this;
        Object localObject = NearLifeCreatePoiUI.this.getContext();
        NearLifeCreatePoiUI.this.getString(2131761605);
        NearLifeCreatePoiUI.a(paramAnonymousMenuItem, com.tencent.mm.ui.base.h.b((Context)localObject, NearLifeCreatePoiUI.this.getString(2131761606), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(26600);
            az.aeS().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this));
            AppMethodBeat.o(26600);
          }
        }));
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.d(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString());
        paramAnonymousMenuItem = ((EditText)NearLifeCreatePoiUI.this.findViewById(2131299527)).getText().toString();
        localObject = NearLifeCreatePoiUI.g(NearLifeCreatePoiUI.this);
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, new com.tencent.mm.plugin.nearlife.b.c(NearLifeCreatePoiUI.h(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.i(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.j(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.k(NearLifeCreatePoiUI.this), ((LinkedList)localObject).size(), (LinkedList)localObject, paramAnonymousMenuItem));
        az.aeS().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this), 0);
        ad.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
        AppMethodBeat.o(26601);
        return true;
      }
    };
    this.udi = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(26602);
        String str1 = bt.nullAsNil(paramAnonymousAddr.hdS) + bt.nullAsNil(paramAnonymousAddr.hdU);
        String str2 = bt.nullAsNil(paramAnonymousAddr.hdV) + bt.nullAsNil(paramAnonymousAddr.hdW);
        ad.d("MicroMsg.NearLifeCreatePoiUI", "get address:".concat(String.valueOf(str1)));
        if (bt.isNullOrNil(NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString())) {
          NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).setText(str1);
        }
        if ((bt.isNullOrNil(NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString())) && (!bt.isNullOrNil(str2))) {
          NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).setText(str2);
        }
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, paramAnonymousAddr);
        AppMethodBeat.o(26602);
      }
    };
    this.udj = new NearLifeCreatePoiUI.6(this);
    this.atH = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(26604);
        if ((NearLifeCreatePoiUI.d(NearLifeCreatePoiUI.this).getText().toString().trim().length() == 0) || (NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString().trim().length() == 0) || (NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString().trim().length() == 0))
        {
          NearLifeCreatePoiUI.this.enableOptionMenu(0, false);
          AppMethodBeat.o(26604);
          return;
        }
        NearLifeCreatePoiUI.this.enableOptionMenu(0, true);
        AppMethodBeat.o(26604);
      }
    };
    AppMethodBeat.o(26606);
  }
  
  private void cWp()
  {
    AppMethodBeat.i(26612);
    com.tencent.mm.ui.base.h.a(this, 2131761599, 2131761605, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26605);
        com.tencent.mm.plugin.report.service.h.vKh.f(11138, new Object[] { "3", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        NearLifeCreatePoiUI.this.setResult(0, new Intent());
        NearLifeCreatePoiUI.this.finish();
        AppMethodBeat.o(26605);
      }
    }, null);
    AppMethodBeat.o(26612);
  }
  
  public int getLayoutId()
  {
    return 2131494995;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26608);
    setMMTitle(2131761605);
    ((ViewGroup)findViewById(2131301463)).setOnClickListener(this.ude);
    ((ViewGroup)findViewById(2131301462)).setOnClickListener(this.udf);
    ((TextView)findViewById(2131306139)).setOnClickListener(this.udg);
    findViewById(2131306139).setVisibility(8);
    findViewById(2131301462).setVisibility(0);
    findViewById(2131301464).setVisibility(0);
    this.ucY = ((EditText)findViewById(2131299526));
    this.ucZ = ((EditText)findViewById(2131299525));
    this.uda = ((TextView)findViewById(2131306144));
    this.udb = ((TextView)findViewById(2131306143));
    this.ucY.addTextChangedListener(this.atH);
    this.ucZ.addTextChangedListener(this.atH);
    this.uda.addTextChangedListener(this.atH);
    String str = bt.by(getIntent().getStringExtra("get_poi_name"), "");
    if (str.length() != 0)
    {
      this.ucY.setText(str);
      this.ucY.setSelection(str.length());
    }
    com.tencent.mm.ui.tools.b.c.d(this.ucY).aaj(100).a(null);
    com.tencent.mm.ui.tools.b.c.d(this.ucZ).aaj(400).a(null);
    com.tencent.mm.ui.tools.b.c.d((EditText)findViewById(2131299527)).aaj(100).a(null);
    addTextOptionMenu(0, getString(2131755779), this.udh, null, r.b.FOB);
    enableOptionMenu(0, false);
    setBackBtn(this.udj);
    AppMethodBeat.o(26608);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26609);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26609);
      return;
      paramIntent = paramIntent.getStringExtra("karea_result");
      if (!bt.isNullOrNil(paramIntent))
      {
        ((TextView)findViewById(2131306144)).setText(paramIntent.replace(" ", ""));
        AppMethodBeat.o(26609);
        return;
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          paramIntent = bt.nullAsNil(paramIntent.getStringExtra("poi_category"));
          this.udb.setText(paramIntent);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26607);
    super.onCreate(paramBundle);
    az.aeS().a(650, this);
    this.ucT = new bld();
    this.ucT.COJ = getIntent().getFloatExtra("get_lat", -85.0F);
    this.ucT.COI = getIntent().getFloatExtra("get_lng", -1000.0F);
    this.ucT.DfE = getIntent().getIntExtra("get_preci", 0);
    this.ucT.DfG = "";
    this.ucT.DfH = 0;
    this.ucT.DfF = "";
    this.udc = com.tencent.mm.modelgeo.c.axQ();
    if (this.udc != null) {
      this.udc.a(this.ucT.COJ, this.ucT.COI, this.udi);
    }
    this.jko = getIntent().getStringExtra("search_id");
    ad.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[] { this.jko });
    initView();
    AppMethodBeat.o(26607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26610);
    super.onDestroy();
    az.aeS().b(650, this);
    AppMethodBeat.o(26610);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26611);
    if (4 == paramKeyEvent.getKeyCode())
    {
      cWp();
      AppMethodBeat.o(26611);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(26611);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(26613);
    ad.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.ftP.dismiss();
      paramString = (com.tencent.mm.plugin.nearlife.b.c)paramn;
      paramn = new Intent();
      if (this.ucT != null)
      {
        paramn.putExtra("get_lat", this.ucT.COJ);
        paramn.putExtra("get_lng", this.ucT.COI);
      }
      if (this.ucW != null) {
        paramn.putExtra("get_city", this.ucW.hdS);
      }
      paramn.putExtra("get_poi_address", this.ucV);
      paramn.putExtra("get_poi_classify_id", paramString.ubH);
      paramn.putExtra("get_poi_name", this.ucU);
      paramn.putExtra("get_poi_classify_type", 1);
      setResult(-1, paramn);
      finish();
      AppMethodBeat.o(26613);
      return;
    }
    this.ftP.dismiss();
    Toast.makeText(getContext(), getString(2131761603), 1).show();
    this.udd = null;
    AppMethodBeat.o(26613);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI
 * JD-Core Version:    0.7.0.1
 */