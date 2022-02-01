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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;
import java.util.LinkedList;

public class NearLifeCreatePoiUI
  extends MMActivity
  implements f
{
  private TextWatcher awu;
  private p fSP;
  private String kid;
  private bug wGT;
  private String wGU;
  private String wGV;
  private Addr wGW;
  private String wGX;
  private EditText wGY;
  private EditText wGZ;
  private TextView wHa;
  private TextView wHb;
  private com.tencent.mm.modelgeo.c wHc;
  private com.tencent.mm.plugin.nearlife.b.c wHd;
  private View.OnClickListener wHe;
  private View.OnClickListener wHf;
  private View.OnClickListener wHg;
  private MenuItem.OnMenuItemClickListener wHh;
  private c.a wHi;
  private MenuItem.OnMenuItemClickListener wHj;
  
  public NearLifeCreatePoiUI()
  {
    AppMethodBeat.i(26606);
    this.wHe = new NearLifeCreatePoiUI.1(this);
    this.wHf = new NearLifeCreatePoiUI.2(this);
    this.wHg = new NearLifeCreatePoiUI.3(this);
    this.wHh = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26601);
        g.yxI.f(11138, new Object[] { "2", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        paramAnonymousMenuItem = NearLifeCreatePoiUI.this;
        Object localObject = NearLifeCreatePoiUI.this.getContext();
        NearLifeCreatePoiUI.this.getString(2131761605);
        NearLifeCreatePoiUI.a(paramAnonymousMenuItem, h.b((Context)localObject, NearLifeCreatePoiUI.this.getString(2131761606), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(26600);
            bc.ajj().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this));
            AppMethodBeat.o(26600);
          }
        }));
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.d(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString());
        paramAnonymousMenuItem = ((EditText)NearLifeCreatePoiUI.this.findViewById(2131299527)).getText().toString();
        localObject = NearLifeCreatePoiUI.g(NearLifeCreatePoiUI.this);
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, new com.tencent.mm.plugin.nearlife.b.c(NearLifeCreatePoiUI.h(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.i(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.j(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.k(NearLifeCreatePoiUI.this), ((LinkedList)localObject).size(), (LinkedList)localObject, paramAnonymousMenuItem));
        bc.ajj().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this), 0);
        ae.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
        AppMethodBeat.o(26601);
        return true;
      }
    };
    this.wHi = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(26602);
        String str1 = bu.nullAsNil(paramAnonymousAddr.hZS) + bu.nullAsNil(paramAnonymousAddr.hZU);
        String str2 = bu.nullAsNil(paramAnonymousAddr.hZV) + bu.nullAsNil(paramAnonymousAddr.hZW);
        ae.d("MicroMsg.NearLifeCreatePoiUI", "get address:".concat(String.valueOf(str1)));
        if (bu.isNullOrNil(NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString())) {
          NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).setText(str1);
        }
        if ((bu.isNullOrNil(NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString())) && (!bu.isNullOrNil(str2))) {
          NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).setText(str2);
        }
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, paramAnonymousAddr);
        AppMethodBeat.o(26602);
      }
    };
    this.wHj = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26603);
        NearLifeCreatePoiUI.l(NearLifeCreatePoiUI.this);
        AppMethodBeat.o(26603);
        return true;
      }
    };
    this.awu = new TextWatcher()
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
  
  private void dxy()
  {
    AppMethodBeat.i(26612);
    h.a(this, 2131761599, 2131761605, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26605);
        g.yxI.f(11138, new Object[] { "3", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
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
    ((ViewGroup)findViewById(2131301463)).setOnClickListener(this.wHe);
    ((ViewGroup)findViewById(2131301462)).setOnClickListener(this.wHf);
    ((TextView)findViewById(2131306139)).setOnClickListener(this.wHg);
    findViewById(2131306139).setVisibility(8);
    findViewById(2131301462).setVisibility(0);
    findViewById(2131301464).setVisibility(0);
    this.wGY = ((EditText)findViewById(2131299526));
    this.wGZ = ((EditText)findViewById(2131299525));
    this.wHa = ((TextView)findViewById(2131306144));
    this.wHb = ((TextView)findViewById(2131306143));
    this.wGY.addTextChangedListener(this.awu);
    this.wGZ.addTextChangedListener(this.awu);
    this.wHa.addTextChangedListener(this.awu);
    String str = bu.bI(getIntent().getStringExtra("get_poi_name"), "");
    if (str.length() != 0)
    {
      this.wGY.setText(str);
      this.wGY.setSelection(str.length());
    }
    com.tencent.mm.ui.tools.b.c.d(this.wGY).afD(100).a(null);
    com.tencent.mm.ui.tools.b.c.d(this.wGZ).afD(400).a(null);
    com.tencent.mm.ui.tools.b.c.d((EditText)findViewById(2131299527)).afD(100).a(null);
    addTextOptionMenu(0, getString(2131755779), this.wHh, null, s.b.JwA);
    enableOptionMenu(0, false);
    setBackBtn(this.wHj);
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
      if (!bu.isNullOrNil(paramIntent))
      {
        ((TextView)findViewById(2131306144)).setText(paramIntent.replace(" ", ""));
        AppMethodBeat.o(26609);
        return;
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          paramIntent = bu.nullAsNil(paramIntent.getStringExtra("poi_category"));
          this.wHb.setText(paramIntent);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26607);
    super.onCreate(paramBundle);
    bc.ajj().a(650, this);
    this.wGT = new bug();
    this.wGT.Gha = getIntent().getFloatExtra("get_lat", -85.0F);
    this.wGT.GgZ = getIntent().getFloatExtra("get_lng", -1000.0F);
    this.wGT.Gzf = getIntent().getIntExtra("get_preci", 0);
    this.wGT.Gzh = "";
    this.wGT.Gzi = 0;
    this.wGT.Gzg = "";
    this.wHc = com.tencent.mm.modelgeo.c.aIe();
    if (this.wHc != null) {
      this.wHc.a(this.wGT.Gha, this.wGT.GgZ, this.wHi);
    }
    this.kid = getIntent().getStringExtra("search_id");
    ae.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[] { this.kid });
    initView();
    AppMethodBeat.o(26607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26610);
    super.onDestroy();
    bc.ajj().b(650, this);
    AppMethodBeat.o(26610);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26611);
    if (4 == paramKeyEvent.getKeyCode())
    {
      dxy();
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
    ae.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.fSP.dismiss();
      paramString = (com.tencent.mm.plugin.nearlife.b.c)paramn;
      paramn = new Intent();
      if (this.wGT != null)
      {
        paramn.putExtra("get_lat", this.wGT.Gha);
        paramn.putExtra("get_lng", this.wGT.GgZ);
      }
      if (this.wGW != null) {
        paramn.putExtra("get_city", this.wGW.hZS);
      }
      paramn.putExtra("get_poi_address", this.wGV);
      paramn.putExtra("get_poi_classify_id", paramString.wFG);
      paramn.putExtra("get_poi_name", this.wGU);
      paramn.putExtra("get_poi_classify_type", 1);
      setResult(-1, paramn);
      finish();
      AppMethodBeat.o(26613);
      return;
    }
    this.fSP.dismiss();
    Toast.makeText(getContext(), getString(2131761603), 1).show();
    this.wHd = null;
    AppMethodBeat.o(26613);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI
 * JD-Core Version:    0.7.0.1
 */