package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;

public class NearLifeCreatePoiUI
  extends MMActivity
  implements f
{
  private TextWatcher ami;
  private com.tencent.mm.ui.base.p ehb;
  private String hng;
  private EditText pfA;
  private TextView pfB;
  private TextView pfC;
  private com.tencent.mm.modelgeo.c pfD;
  private b pfE;
  private View.OnClickListener pfF;
  private View.OnClickListener pfG;
  private View.OnClickListener pfH;
  private MenuItem.OnMenuItemClickListener pfI;
  private c.a pfJ;
  private MenuItem.OnMenuItemClickListener pfK;
  private azt pfu;
  private String pfv;
  private String pfw;
  private Addr pfx;
  private String pfy;
  private EditText pfz;
  
  public NearLifeCreatePoiUI()
  {
    AppMethodBeat.i(22980);
    this.pfF = new NearLifeCreatePoiUI.1(this);
    this.pfG = new NearLifeCreatePoiUI.2(this);
    this.pfH = new NearLifeCreatePoiUI.3(this);
    this.pfI = new NearLifeCreatePoiUI.4(this);
    this.pfJ = new NearLifeCreatePoiUI.5(this);
    this.pfK = new NearLifeCreatePoiUI.6(this);
    this.ami = new NearLifeCreatePoiUI.7(this);
    AppMethodBeat.o(22980);
  }
  
  private void bWP()
  {
    AppMethodBeat.i(22986);
    com.tencent.mm.ui.base.h.a(this, 2131301839, 2131301845, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(22979);
        com.tencent.mm.plugin.report.service.h.qsU.e(11138, new Object[] { "3", "0", NearLifeCreatePoiUI.b(NearLifeCreatePoiUI.this) });
        NearLifeCreatePoiUI.this.setResult(0, new Intent());
        NearLifeCreatePoiUI.this.finish();
        AppMethodBeat.o(22979);
      }
    }, null);
    AppMethodBeat.o(22986);
  }
  
  public int getLayoutId()
  {
    return 2130970338;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22982);
    setMMTitle(2131301845);
    ((ViewGroup)findViewById(2131826471)).setOnClickListener(this.pfF);
    ((ViewGroup)findViewById(2131826475)).setOnClickListener(this.pfG);
    ((TextView)findViewById(2131826474)).setOnClickListener(this.pfH);
    findViewById(2131826474).setVisibility(8);
    findViewById(2131826475).setVisibility(0);
    findViewById(2131826477).setVisibility(0);
    this.pfz = ((EditText)findViewById(2131826470));
    this.pfA = ((EditText)findViewById(2131826473));
    this.pfB = ((TextView)findViewById(2131826472));
    this.pfC = ((TextView)findViewById(2131826476));
    this.pfz.addTextChangedListener(this.ami);
    this.pfA.addTextChangedListener(this.ami);
    this.pfB.addTextChangedListener(this.ami);
    String str = bo.bf(getIntent().getStringExtra("get_poi_name"), "");
    if (str.length() != 0)
    {
      this.pfz.setText(str);
      this.pfz.setSelection(str.length());
    }
    com.tencent.mm.ui.tools.b.c.d(this.pfz).QS(100).a(null);
    com.tencent.mm.ui.tools.b.c.d(this.pfA).QS(400).a(null);
    com.tencent.mm.ui.tools.b.c.d((EditText)findViewById(2131826478)).QS(100).a(null);
    addTextOptionMenu(0, getString(2131296964), this.pfI, null, q.b.zby);
    enableOptionMenu(0, false);
    setBackBtn(this.pfK);
    AppMethodBeat.o(22982);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22983);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22983);
      return;
      paramIntent = paramIntent.getStringExtra("karea_result");
      if (!bo.isNullOrNil(paramIntent))
      {
        ((TextView)findViewById(2131826472)).setText(paramIntent.replace(" ", ""));
        AppMethodBeat.o(22983);
        return;
        if ((-1 == paramInt2) && (paramIntent != null))
        {
          paramIntent = bo.nullAsNil(paramIntent.getStringExtra("poi_category"));
          this.pfC.setText(paramIntent);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22981);
    super.onCreate(paramBundle);
    aw.Rc().a(650, this);
    this.pfu = new azt();
    this.pfu.wDi = getIntent().getFloatExtra("get_lat", -85.0F);
    this.pfu.wDh = getIntent().getFloatExtra("get_lng", -1000.0F);
    this.pfu.wSk = getIntent().getIntExtra("get_preci", 0);
    this.pfu.wSm = "";
    this.pfu.wSn = 0;
    this.pfu.wSl = "";
    this.pfD = com.tencent.mm.modelgeo.c.agN();
    if (this.pfD != null) {
      this.pfD.a(this.pfu.wDi, this.pfu.wDh, this.pfJ);
    }
    this.hng = getIntent().getStringExtra("search_id");
    ab.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[] { this.hng });
    initView();
    AppMethodBeat.o(22981);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22984);
    super.onDestroy();
    aw.Rc().b(650, this);
    AppMethodBeat.o(22984);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22985);
    if (4 == paramKeyEvent.getKeyCode())
    {
      bWP();
      AppMethodBeat.o(22985);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(22985);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22987);
    ab.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.ehb.dismiss();
      paramString = (b)paramm;
      paramm = new Intent();
      if (this.pfu != null)
      {
        paramm.putExtra("get_lat", this.pfu.wDi);
        paramm.putExtra("get_lng", this.pfu.wDh);
      }
      if (this.pfx != null) {
        paramm.putExtra("get_city", this.pfx.fBs);
      }
      paramm.putExtra("get_poi_address", this.pfw);
      paramm.putExtra("get_poi_classify_id", paramString.peh);
      paramm.putExtra("get_poi_name", this.pfv);
      paramm.putExtra("get_poi_classify_type", 1);
      setResult(-1, paramm);
      finish();
      AppMethodBeat.o(22987);
      return;
    }
    this.ehb.dismiss();
    Toast.makeText(getContext(), getString(2131301843), 1).show();
    this.pfE = null;
    AppMethodBeat.o(22987);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI
 * JD-Core Version:    0.7.0.1
 */