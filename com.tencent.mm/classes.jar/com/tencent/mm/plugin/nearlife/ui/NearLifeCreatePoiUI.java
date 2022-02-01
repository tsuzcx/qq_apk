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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;
import java.util.LinkedList;

public class NearLifeCreatePoiUI
  extends MMActivity
  implements g
{
  private TextWatcher auC;
  private p fxw;
  private String jKB;
  private boz vlS;
  private String vlT;
  private String vlU;
  private Addr vlV;
  private String vlW;
  private EditText vlX;
  private EditText vlY;
  private TextView vlZ;
  private TextView vma;
  private com.tencent.mm.modelgeo.c vmb;
  private com.tencent.mm.plugin.nearlife.b.c vmc;
  private View.OnClickListener vmd;
  private View.OnClickListener vme;
  private View.OnClickListener vmf;
  private MenuItem.OnMenuItemClickListener vmg;
  private c.a vmh;
  private MenuItem.OnMenuItemClickListener vmi;
  
  public NearLifeCreatePoiUI()
  {
    AppMethodBeat.i(26606);
    this.vmd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26597);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("ui_title", 2131761615);
        if (NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this) != null)
        {
          paramAnonymousView.putExtra("extra_province", NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this).hEu);
          paramAnonymousView.putExtra("extra_city", NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this).hEv);
        }
        d.b(NearLifeCreatePoiUI.this.getContext(), "address", ".ui.WalletMultiRcptSelectUI", paramAnonymousView, 1);
        AppMethodBeat.o(26597);
      }
    };
    this.vme = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26598);
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(NearLifeCreatePoiUI.this.getContext(), SelectPoiCategoryUI.class);
        NearLifeCreatePoiUI.this.startActivityForResult(paramAnonymousView, 2);
        AppMethodBeat.o(26598);
      }
    };
    this.vmf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26599);
        NearLifeCreatePoiUI.this.findViewById(2131306139).setVisibility(8);
        NearLifeCreatePoiUI.this.findViewById(2131301462).setVisibility(0);
        NearLifeCreatePoiUI.this.findViewById(2131301464).setVisibility(0);
        AppMethodBeat.o(26599);
      }
    };
    this.vmg = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26601);
        com.tencent.mm.plugin.report.service.h.wUl.f(11138, new Object[] { "2", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        paramAnonymousMenuItem = NearLifeCreatePoiUI.this;
        Object localObject = NearLifeCreatePoiUI.this.getContext();
        NearLifeCreatePoiUI.this.getString(2131761605);
        NearLifeCreatePoiUI.a(paramAnonymousMenuItem, com.tencent.mm.ui.base.h.b((Context)localObject, NearLifeCreatePoiUI.this.getString(2131761606), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(26600);
            az.agi().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this));
            AppMethodBeat.o(26600);
          }
        }));
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.d(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString());
        paramAnonymousMenuItem = ((EditText)NearLifeCreatePoiUI.this.findViewById(2131299527)).getText().toString();
        localObject = NearLifeCreatePoiUI.g(NearLifeCreatePoiUI.this);
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, new com.tencent.mm.plugin.nearlife.b.c(NearLifeCreatePoiUI.h(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.i(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.j(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.k(NearLifeCreatePoiUI.this), ((LinkedList)localObject).size(), (LinkedList)localObject, paramAnonymousMenuItem));
        az.agi().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this), 0);
        ac.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
        AppMethodBeat.o(26601);
        return true;
      }
    };
    this.vmh = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(26602);
        String str1 = bs.nullAsNil(paramAnonymousAddr.hEv) + bs.nullAsNil(paramAnonymousAddr.hEx);
        String str2 = bs.nullAsNil(paramAnonymousAddr.hEy) + bs.nullAsNil(paramAnonymousAddr.hEz);
        ac.d("MicroMsg.NearLifeCreatePoiUI", "get address:".concat(String.valueOf(str1)));
        if (bs.isNullOrNil(NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString())) {
          NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).setText(str1);
        }
        if ((bs.isNullOrNil(NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString())) && (!bs.isNullOrNil(str2))) {
          NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).setText(str2);
        }
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, paramAnonymousAddr);
        AppMethodBeat.o(26602);
      }
    };
    this.vmi = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26603);
        NearLifeCreatePoiUI.l(NearLifeCreatePoiUI.this);
        AppMethodBeat.o(26603);
        return true;
      }
    };
    this.auC = new TextWatcher()
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
  
  private void djX()
  {
    AppMethodBeat.i(26612);
    com.tencent.mm.ui.base.h.a(this, 2131761599, 2131761605, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26605);
        com.tencent.mm.plugin.report.service.h.wUl.f(11138, new Object[] { "3", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
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
    ((ViewGroup)findViewById(2131301463)).setOnClickListener(this.vmd);
    ((ViewGroup)findViewById(2131301462)).setOnClickListener(this.vme);
    ((TextView)findViewById(2131306139)).setOnClickListener(this.vmf);
    findViewById(2131306139).setVisibility(8);
    findViewById(2131301462).setVisibility(0);
    findViewById(2131301464).setVisibility(0);
    this.vlX = ((EditText)findViewById(2131299526));
    this.vlY = ((EditText)findViewById(2131299525));
    this.vlZ = ((TextView)findViewById(2131306144));
    this.vma = ((TextView)findViewById(2131306143));
    this.vlX.addTextChangedListener(this.auC);
    this.vlY.addTextChangedListener(this.auC);
    this.vlZ.addTextChangedListener(this.auC);
    String str = bs.bG(getIntent().getStringExtra("get_poi_name"), "");
    if (str.length() != 0)
    {
      this.vlX.setText(str);
      this.vlX.setSelection(str.length());
    }
    com.tencent.mm.ui.tools.b.c.d(this.vlX).acw(100).a(null);
    com.tencent.mm.ui.tools.b.c.d(this.vlY).acw(400).a(null);
    com.tencent.mm.ui.tools.b.c.d((EditText)findViewById(2131299527)).acw(100).a(null);
    addTextOptionMenu(0, getString(2131755779), this.vmg, null, s.b.Hom);
    enableOptionMenu(0, false);
    setBackBtn(this.vmi);
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
      if (!bs.isNullOrNil(paramIntent))
      {
        ((TextView)findViewById(2131306144)).setText(paramIntent.replace(" ", ""));
        AppMethodBeat.o(26609);
        return;
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          paramIntent = bs.nullAsNil(paramIntent.getStringExtra("poi_category"));
          this.vma.setText(paramIntent);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26607);
    super.onCreate(paramBundle);
    az.agi().a(650, this);
    this.vlS = new boz();
    this.vlS.Ehu = getIntent().getFloatExtra("get_lat", -85.0F);
    this.vlS.Eht = getIntent().getFloatExtra("get_lng", -1000.0F);
    this.vlS.EyK = getIntent().getIntExtra("get_preci", 0);
    this.vlS.EyM = "";
    this.vlS.EyN = 0;
    this.vlS.EyL = "";
    this.vmb = com.tencent.mm.modelgeo.c.aEI();
    if (this.vmb != null) {
      this.vmb.a(this.vlS.Ehu, this.vlS.Eht, this.vmh);
    }
    this.jKB = getIntent().getStringExtra("search_id");
    ac.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[] { this.jKB });
    initView();
    AppMethodBeat.o(26607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26610);
    super.onDestroy();
    az.agi().b(650, this);
    AppMethodBeat.o(26610);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26611);
    if (4 == paramKeyEvent.getKeyCode())
    {
      djX();
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
    ac.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.fxw.dismiss();
      paramString = (com.tencent.mm.plugin.nearlife.b.c)paramn;
      paramn = new Intent();
      if (this.vlS != null)
      {
        paramn.putExtra("get_lat", this.vlS.Ehu);
        paramn.putExtra("get_lng", this.vlS.Eht);
      }
      if (this.vlV != null) {
        paramn.putExtra("get_city", this.vlV.hEv);
      }
      paramn.putExtra("get_poi_address", this.vlU);
      paramn.putExtra("get_poi_classify_id", paramString.vkF);
      paramn.putExtra("get_poi_name", this.vlT);
      paramn.putExtra("get_poi_classify_type", 1);
      setResult(-1, paramn);
      finish();
      AppMethodBeat.o(26613);
      return;
    }
    this.fxw.dismiss();
    Toast.makeText(getContext(), getString(2131761603), 1).show();
    this.vmc = null;
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