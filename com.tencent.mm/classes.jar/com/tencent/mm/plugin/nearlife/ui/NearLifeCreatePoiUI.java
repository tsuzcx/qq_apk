package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t.b;
import java.util.LinkedList;

public class NearLifeCreatePoiUI
  extends MMActivity
  implements i
{
  private chk ACd;
  private String ACe;
  private String ACf;
  private Addr ACg;
  private String ACh;
  private EditText ACi;
  private EditText ACj;
  private TextView ACk;
  private TextView ACl;
  private com.tencent.mm.modelgeo.c ACm;
  private com.tencent.mm.plugin.nearlife.b.c ACn;
  private View.OnClickListener ACo;
  private View.OnClickListener ACp;
  private View.OnClickListener ACq;
  private MenuItem.OnMenuItemClickListener ACr;
  private c.a ACs;
  private MenuItem.OnMenuItemClickListener ACt;
  private TextWatcher aws;
  private com.tencent.mm.ui.base.q gxX;
  private String hes;
  
  public NearLifeCreatePoiUI()
  {
    AppMethodBeat.i(26606);
    this.ACo = new NearLifeCreatePoiUI.1(this);
    this.ACp = new NearLifeCreatePoiUI.2(this);
    this.ACq = new NearLifeCreatePoiUI.3(this);
    this.ACr = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26601);
        com.tencent.mm.plugin.report.service.h.CyF.a(11138, new Object[] { "2", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        paramAnonymousMenuItem = NearLifeCreatePoiUI.this;
        Object localObject = NearLifeCreatePoiUI.this.getContext();
        NearLifeCreatePoiUI.this.getString(2131763573);
        NearLifeCreatePoiUI.a(paramAnonymousMenuItem, com.tencent.mm.ui.base.h.a((Context)localObject, NearLifeCreatePoiUI.this.getString(2131763574), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(26600);
            bg.azz().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this));
            AppMethodBeat.o(26600);
          }
        }));
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.d(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString());
        paramAnonymousMenuItem = ((EditText)NearLifeCreatePoiUI.this.findViewById(2131300170)).getText().toString();
        localObject = NearLifeCreatePoiUI.g(NearLifeCreatePoiUI.this);
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, new com.tencent.mm.plugin.nearlife.b.c(NearLifeCreatePoiUI.h(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.i(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.j(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.k(NearLifeCreatePoiUI.this), ((LinkedList)localObject).size(), (LinkedList)localObject, paramAnonymousMenuItem));
        bg.azz().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this), 0);
        Log.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
        AppMethodBeat.o(26601);
        return true;
      }
    };
    this.ACs = new NearLifeCreatePoiUI.5(this);
    this.ACt = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26603);
        NearLifeCreatePoiUI.l(NearLifeCreatePoiUI.this);
        AppMethodBeat.o(26603);
        return true;
      }
    };
    this.aws = new NearLifeCreatePoiUI.7(this);
    AppMethodBeat.o(26606);
  }
  
  private void exg()
  {
    AppMethodBeat.i(26612);
    com.tencent.mm.ui.base.h.a(this, 2131763567, 2131763573, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26605);
        com.tencent.mm.plugin.report.service.h.CyF.a(11138, new Object[] { "3", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        NearLifeCreatePoiUI.this.setResult(0, new Intent());
        NearLifeCreatePoiUI.this.finish();
        AppMethodBeat.o(26605);
      }
    }, null);
    AppMethodBeat.o(26612);
  }
  
  public int getLayoutId()
  {
    return 2131495808;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26608);
    setMMTitle(2131763573);
    ((ViewGroup)findViewById(2131303648)).setOnClickListener(this.ACo);
    ((ViewGroup)findViewById(2131303647)).setOnClickListener(this.ACp);
    ((TextView)findViewById(2131309505)).setOnClickListener(this.ACq);
    findViewById(2131309505).setVisibility(8);
    findViewById(2131303647).setVisibility(0);
    findViewById(2131303649).setVisibility(0);
    this.ACi = ((EditText)findViewById(2131300169));
    this.ACj = ((EditText)findViewById(2131300168));
    this.ACk = ((TextView)findViewById(2131309514));
    this.ACl = ((TextView)findViewById(2131309513));
    this.ACi.addTextChangedListener(this.aws);
    this.ACj.addTextChangedListener(this.aws);
    this.ACk.addTextChangedListener(this.aws);
    String str = Util.nullAs(getIntent().getStringExtra("get_poi_name"), "");
    if (str.length() != 0)
    {
      this.ACi.setText(str);
      this.ACi.setSelection(str.length());
    }
    com.tencent.mm.ui.tools.b.c.f(this.ACi).aoq(100).a(null);
    com.tencent.mm.ui.tools.b.c.f(this.ACj).aoq(400).a(null);
    com.tencent.mm.ui.tools.b.c.f((EditText)findViewById(2131300170)).aoq(100).a(null);
    addTextOptionMenu(0, getString(2131755858), this.ACr, null, t.b.OGU);
    enableOptionMenu(0, false);
    setBackBtn(this.ACt);
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
        ((TextView)findViewById(2131309514)).setText(paramIntent.replace(" ", ""));
        AppMethodBeat.o(26609);
        return;
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          paramIntent = Util.nullAsNil(paramIntent.getStringExtra("poi_category"));
          this.ACl.setText(paramIntent);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26607);
    super.onCreate(paramBundle);
    bg.azz().a(650, this);
    this.ACd = new chk();
    this.ACd.LbD = getIntent().getFloatExtra("get_lat", -85.0F);
    this.ACd.LbC = getIntent().getFloatExtra("get_lng", -1000.0F);
    this.ACd.LuT = getIntent().getIntExtra("get_preci", 0);
    this.ACd.LuV = "";
    this.ACd.LuW = 0;
    this.ACd.LuU = "";
    this.ACm = com.tencent.mm.modelgeo.c.bbX();
    if (this.ACm != null) {
      this.ACm.a(this.ACd.LbD, this.ACd.LbC, this.ACs);
    }
    this.hes = getIntent().getStringExtra("search_id");
    Log.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[] { this.hes });
    initView();
    AppMethodBeat.o(26607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26610);
    super.onDestroy();
    bg.azz().b(650, this);
    AppMethodBeat.o(26610);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26611);
    if (4 == paramKeyEvent.getKeyCode())
    {
      exg();
      AppMethodBeat.o(26611);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(26611);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(26613);
    Log.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.gxX.dismiss();
      paramString = (com.tencent.mm.plugin.nearlife.b.c)paramq;
      paramq = new Intent();
      if (this.ACd != null)
      {
        paramq.putExtra("get_lat", this.ACd.LbD);
        paramq.putExtra("get_lng", this.ACd.LbC);
      }
      if (this.ACg != null) {
        paramq.putExtra("get_city", this.ACg.iUQ);
      }
      paramq.putExtra("get_poi_address", this.ACf);
      paramq.putExtra("get_poi_classify_id", paramString.AAR);
      paramq.putExtra("get_poi_name", this.ACe);
      paramq.putExtra("get_poi_classify_type", 1);
      setResult(-1, paramq);
      finish();
      AppMethodBeat.o(26613);
      return;
    }
    this.gxX.dismiss();
    Toast.makeText(getContext(), getString(2131763571), 1).show();
    this.ACn = null;
    AppMethodBeat.o(26613);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI
 * JD-Core Version:    0.7.0.1
 */