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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.w.b;
import java.util.LinkedList;

public class NearLifeCreatePoiUI
  extends MMActivity
  implements i
{
  private cqg Gvg;
  private String Gvh;
  private String Gvi;
  private Addr Gvj;
  private String Gvk;
  private EditText Gvl;
  private EditText Gvm;
  private TextView Gvn;
  private TextView Gvo;
  private com.tencent.mm.modelgeo.c Gvp;
  private com.tencent.mm.plugin.nearlife.b.c Gvq;
  private View.OnClickListener Gvr;
  private View.OnClickListener Gvs;
  private View.OnClickListener Gvt;
  private MenuItem.OnMenuItemClickListener Gvu;
  private c.a Gvv;
  private MenuItem.OnMenuItemClickListener Gvw;
  private String jQi;
  private s jhZ;
  private TextWatcher uY;
  
  public NearLifeCreatePoiUI()
  {
    AppMethodBeat.i(26606);
    this.Gvr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26597);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("ui_title", R.l.eMJ);
        if (NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this) != null)
        {
          paramAnonymousView.putExtra("extra_province", NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this).lLh);
          paramAnonymousView.putExtra("extra_city", NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this).lLi);
        }
        com.tencent.mm.by.c.b(NearLifeCreatePoiUI.this.getContext(), "address", ".ui.WalletMultiRcptSelectUI", paramAnonymousView, 1);
        a.a(this, "com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26597);
      }
    };
    this.Gvs = new NearLifeCreatePoiUI.2(this);
    this.Gvt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26599);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        NearLifeCreatePoiUI.this.findViewById(R.h.dYi).setVisibility(8);
        NearLifeCreatePoiUI.this.findViewById(R.h.dLt).setVisibility(0);
        NearLifeCreatePoiUI.this.findViewById(R.h.dLv).setVisibility(0);
        a.a(this, "com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26599);
      }
    };
    this.Gvu = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26601);
        com.tencent.mm.plugin.report.service.h.IzE.a(11138, new Object[] { "2", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        paramAnonymousMenuItem = NearLifeCreatePoiUI.this;
        Object localObject = NearLifeCreatePoiUI.this.getContext();
        NearLifeCreatePoiUI.this.getString(R.l.eMH);
        NearLifeCreatePoiUI.a(paramAnonymousMenuItem, com.tencent.mm.ui.base.h.a((Context)localObject, NearLifeCreatePoiUI.this.getString(R.l.eMI), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(26600);
            bh.aGY().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this));
            AppMethodBeat.o(26600);
          }
        }));
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.d(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.e(NearLifeCreatePoiUI.this).getText().toString());
        NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this, NearLifeCreatePoiUI.f(NearLifeCreatePoiUI.this).getText().toString());
        paramAnonymousMenuItem = ((EditText)NearLifeCreatePoiUI.this.findViewById(R.h.dFL)).getText().toString();
        localObject = NearLifeCreatePoiUI.g(NearLifeCreatePoiUI.this);
        NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this, new com.tencent.mm.plugin.nearlife.b.c(NearLifeCreatePoiUI.h(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.i(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.j(NearLifeCreatePoiUI.this), NearLifeCreatePoiUI.k(NearLifeCreatePoiUI.this), ((LinkedList)localObject).size(), (LinkedList)localObject, paramAnonymousMenuItem));
        bh.aGY().a(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.this), 0);
        Log.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
        AppMethodBeat.o(26601);
        return true;
      }
    };
    this.Gvv = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(26602);
        String str1 = Util.nullAsNil(paramAnonymousAddr.lLi) + Util.nullAsNil(paramAnonymousAddr.lLk);
        String str2 = Util.nullAsNil(paramAnonymousAddr.lLl) + Util.nullAsNil(paramAnonymousAddr.lLm);
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
    this.Gvw = new NearLifeCreatePoiUI.6(this);
    this.uY = new TextWatcher()
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
  
  private void fiJ()
  {
    AppMethodBeat.i(26612);
    com.tencent.mm.ui.base.h.a(this, R.l.eME, R.l.eMH, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(26605);
        com.tencent.mm.plugin.report.service.h.IzE.a(11138, new Object[] { "3", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        NearLifeCreatePoiUI.this.setResult(0, new Intent());
        NearLifeCreatePoiUI.this.finish();
        AppMethodBeat.o(26605);
      }
    }, null);
    AppMethodBeat.o(26612);
  }
  
  public int getLayoutId()
  {
    return R.i.ejn;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26608);
    setMMTitle(R.l.eMH);
    ((ViewGroup)findViewById(R.h.dLu)).setOnClickListener(this.Gvr);
    ((ViewGroup)findViewById(R.h.dLt)).setOnClickListener(this.Gvs);
    ((TextView)findViewById(R.h.dYi)).setOnClickListener(this.Gvt);
    findViewById(R.h.dYi).setVisibility(8);
    findViewById(R.h.dLt).setVisibility(0);
    findViewById(R.h.dLv).setVisibility(0);
    this.Gvl = ((EditText)findViewById(R.h.dFK));
    this.Gvm = ((EditText)findViewById(R.h.dFJ));
    this.Gvn = ((TextView)findViewById(R.h.dYm));
    this.Gvo = ((TextView)findViewById(R.h.dYl));
    this.Gvl.addTextChangedListener(this.uY);
    this.Gvm.addTextChangedListener(this.uY);
    this.Gvn.addTextChangedListener(this.uY);
    String str = Util.nullAs(getIntent().getStringExtra("get_poi_name"), "");
    if (str.length() != 0)
    {
      this.Gvl.setText(str);
      this.Gvl.setSelection(str.length());
    }
    com.tencent.mm.ui.tools.b.c.i(this.Gvl).axx(100).a(null);
    com.tencent.mm.ui.tools.b.c.i(this.Gvm).axx(400).a(null);
    com.tencent.mm.ui.tools.b.c.i((EditText)findViewById(R.h.dFL)).axx(100).a(null);
    addTextOptionMenu(0, getString(R.l.app_finish), this.Gvu, null, w.b.Wao);
    enableOptionMenu(0, false);
    setBackBtn(this.Gvw);
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
        ((TextView)findViewById(R.h.dYm)).setText(paramIntent.replace(" ", ""));
        AppMethodBeat.o(26609);
        return;
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          paramIntent = Util.nullAsNil(paramIntent.getStringExtra("poi_category"));
          this.Gvo.setText(paramIntent);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26607);
    super.onCreate(paramBundle);
    bh.aGY().a(650, this);
    this.Gvg = new cqg();
    this.Gvg.ScP = getIntent().getFloatExtra("get_lat", -85.0F);
    this.Gvg.ScO = getIntent().getFloatExtra("get_lng", -1000.0F);
    this.Gvg.Sxt = getIntent().getIntExtra("get_preci", 0);
    this.Gvg.Sxv = "";
    this.Gvg.Sxw = 0;
    this.Gvg.Sxu = "";
    this.Gvp = com.tencent.mm.modelgeo.c.bln();
    if (this.Gvp != null) {
      this.Gvp.a(this.Gvg.ScP, this.Gvg.ScO, this.Gvv);
    }
    this.jQi = getIntent().getStringExtra("search_id");
    Log.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[] { this.jQi });
    initView();
    AppMethodBeat.o(26607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26610);
    super.onDestroy();
    bh.aGY().b(650, this);
    AppMethodBeat.o(26610);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(26611);
    if (4 == paramKeyEvent.getKeyCode())
    {
      fiJ();
      AppMethodBeat.o(26611);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(26611);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(26613);
    Log.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jhZ.dismiss();
      paramString = (com.tencent.mm.plugin.nearlife.b.c)paramq;
      paramq = new Intent();
      if (this.Gvg != null)
      {
        paramq.putExtra("get_lat", this.Gvg.ScP);
        paramq.putExtra("get_lng", this.Gvg.ScO);
      }
      if (this.Gvj != null) {
        paramq.putExtra("get_city", this.Gvj.lLi);
      }
      paramq.putExtra("get_poi_address", this.Gvi);
      paramq.putExtra("get_poi_classify_id", paramString.GtT);
      paramq.putExtra("get_poi_name", this.Gvh);
      paramq.putExtra("get_poi_classify_type", 1);
      setResult(-1, paramq);
      finish();
      AppMethodBeat.o(26613);
      return;
    }
    this.jhZ.dismiss();
    Toast.makeText(getContext(), getString(R.l.eMF), 1).show();
    this.Gvq = null;
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