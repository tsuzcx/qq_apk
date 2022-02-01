package com.tencent.mm.plugin.nearlife.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.y.b;
import java.util.LinkedList;

public class NearLifeCreatePoiUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private dha Mrf;
  private String Mrg;
  private String Mrh;
  private Addr Mri;
  private String Mrj;
  private EditText Mrk;
  private EditText Mrl;
  private TextView Mrm;
  private TextView Mrn;
  private com.tencent.mm.modelgeo.c Mro;
  private com.tencent.mm.plugin.nearlife.b.c Mrp;
  private View.OnClickListener Mrq;
  private View.OnClickListener Mrr;
  private View.OnClickListener Mrs;
  private MenuItem.OnMenuItemClickListener Mrt;
  private c.a Mru;
  private MenuItem.OnMenuItemClickListener Mrv;
  private w lKp;
  private String mpa;
  private TextWatcher vU;
  
  public NearLifeCreatePoiUI()
  {
    AppMethodBeat.i(26606);
    this.Mrq = new NearLifeCreatePoiUI.1(this);
    this.Mrr = new NearLifeCreatePoiUI.2(this);
    this.Mrs = new NearLifeCreatePoiUI.3(this);
    this.Mrt = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26601);
        com.tencent.mm.plugin.report.service.h.OAn.b(11138, new Object[] { "2", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        paramAnonymousMenuItem = NearLifeCreatePoiUI.this;
        Object localObject = NearLifeCreatePoiUI.this.getContext();
        NearLifeCreatePoiUI.this.getString(R.l.gOO);
        NearLifeCreatePoiUI.a(paramAnonymousMenuItem, k.a((Context)localObject, NearLifeCreatePoiUI.this.getString(R.l.gOP), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(26600);
            bh.aZW().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this));
            AppMethodBeat.o(26600);
          }
        }));
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.d(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString());
        paramAnonymousMenuItem = ((EditText)NearLifeCreatePoiUI.this.findViewById(R.h.fGR)).getText().toString();
        localObject = NearLifeCreatePoiUI.g(NearLifeCreatePoiUI.this);
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, new com.tencent.mm.plugin.nearlife.b.c(NearLifeCreatePoiUI.h(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.i(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.j(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.k(NearLifeCreatePoiUI.this), ((LinkedList)localObject).size(), (LinkedList)localObject, paramAnonymousMenuItem));
        bh.aZW().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this), 0);
        Log.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
        AppMethodBeat.o(26601);
        return true;
      }
    };
    this.Mru = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(26602);
        String str1 = Util.nullAsNil(paramAnonymousAddr.oDK) + Util.nullAsNil(paramAnonymousAddr.oDM);
        String str2 = Util.nullAsNil(paramAnonymousAddr.oDN) + Util.nullAsNil(paramAnonymousAddr.oDO);
        Log.d("MicroMsg.NearLifeCreatePoiUI", "get address:".concat(String.valueOf(str1)));
        if (Util.isNullOrNil(NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString())) {
          NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).setText(str1);
        }
        if ((Util.isNullOrNil(NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString())) && (!Util.isNullOrNil(str2))) {
          NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).setText(str2);
        }
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, paramAnonymousAddr);
        AppMethodBeat.o(26602);
      }
    };
    this.Mrv = new NearLifeCreatePoiUI.6(this);
    this.vU = new TextWatcher()
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
  
  private void gtb()
  {
    AppMethodBeat.i(26612);
    k.a(this, R.l.gOL, R.l.gOO, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26605);
        com.tencent.mm.plugin.report.service.h.OAn.b(11138, new Object[] { "3", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        NearLifeCreatePoiUI.this.setResult(0, new Intent());
        NearLifeCreatePoiUI.this.finish();
        AppMethodBeat.o(26605);
      }
    }, null);
    AppMethodBeat.o(26612);
  }
  
  public int getLayoutId()
  {
    return R.i.gmo;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26608);
    setMMTitle(R.l.gOO);
    ((ViewGroup)findViewById(R.h.fNb)).setOnClickListener(this.Mrq);
    ((ViewGroup)findViewById(R.h.fNa)).setOnClickListener(this.Mrr);
    ((TextView)findViewById(R.h.gaT)).setOnClickListener(this.Mrs);
    findViewById(R.h.gaT).setVisibility(8);
    findViewById(R.h.fNa).setVisibility(0);
    findViewById(R.h.fNc).setVisibility(0);
    this.Mrk = ((EditText)findViewById(R.h.fGQ));
    this.Mrl = ((EditText)findViewById(R.h.fGP));
    this.Mrm = ((TextView)findViewById(R.h.gaY));
    this.Mrn = ((TextView)findViewById(R.h.gaX));
    this.Mrk.addTextChangedListener(this.vU);
    this.Mrl.addTextChangedListener(this.vU);
    this.Mrm.addTextChangedListener(this.vU);
    String str = Util.nullAs(getIntent().getStringExtra("get_poi_name"), "");
    if (str.length() != 0)
    {
      this.Mrk.setText(str);
      this.Mrk.setSelection(str.length());
    }
    com.tencent.mm.ui.tools.b.c.i(this.Mrk).aEg(100).a(null);
    com.tencent.mm.ui.tools.b.c.i(this.Mrl).aEg(400).a(null);
    com.tencent.mm.ui.tools.b.c.i((EditText)findViewById(R.h.fGR)).aEg(100).a(null);
    addTextOptionMenu(0, getString(R.l.app_finish), this.Mrt, null, y.b.adEJ);
    enableOptionMenu(0, false);
    setBackBtn(this.Mrv);
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
      if (!Util.isNullOrNil(paramIntent))
      {
        ((TextView)findViewById(R.h.gaY)).setText(paramIntent.replace(" ", ""));
        AppMethodBeat.o(26609);
        return;
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          paramIntent = Util.nullAsNil(paramIntent.getStringExtra("poi_category"));
          this.Mrn.setText(paramIntent);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26607);
    super.onCreate(paramBundle);
    bh.aZW().a(650, this);
    this.Mrf = new dha();
    this.Mrf.ZaH = getIntent().getFloatExtra("get_lat", -85.0F);
    this.Mrf.ZaG = getIntent().getFloatExtra("get_lng", -1000.0F);
    this.Mrf.Zyl = getIntent().getIntExtra("get_preci", 0);
    this.Mrf.Zyn = "";
    this.Mrf.Zyo = 0;
    this.Mrf.Zym = "";
    this.Mro = com.tencent.mm.modelgeo.c.bJh();
    if (this.Mro != null) {
      this.Mro.a(this.Mrf.ZaH, this.Mrf.ZaG, this.Mru);
    }
    this.mpa = getIntent().getStringExtra("search_id");
    Log.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[] { this.mpa });
    initView();
    AppMethodBeat.o(26607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26610);
    super.onDestroy();
    bh.aZW().b(650, this);
    AppMethodBeat.o(26610);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26611);
    if (4 == paramKeyEvent.getKeyCode())
    {
      gtb();
      AppMethodBeat.o(26611);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(26611);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(26613);
    Log.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.lKp.dismiss();
      paramString = (com.tencent.mm.plugin.nearlife.b.c)paramp;
      paramp = new Intent();
      if (this.Mrf != null)
      {
        paramp.putExtra("get_lat", this.Mrf.ZaH);
        paramp.putExtra("get_lng", this.Mrf.ZaG);
      }
      if (this.Mri != null) {
        paramp.putExtra("get_city", this.Mri.oDK);
      }
      paramp.putExtra("get_poi_address", this.Mrh);
      paramp.putExtra("get_poi_classify_id", paramString.MpT);
      paramp.putExtra("get_poi_name", this.Mrg);
      paramp.putExtra("get_poi_classify_type", 1);
      setResult(-1, paramp);
      finish();
      AppMethodBeat.o(26613);
      return;
    }
    this.lKp.dismiss();
    Toast.makeText(getContext(), getString(R.l.gOM), 1).show();
    this.Mrp = null;
    AppMethodBeat.o(26613);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI
 * JD-Core Version:    0.7.0.1
 */