package com.tencent.mm.plugin.nearlife.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.a.c;

public class NearLifeCreatePoiUI
  extends MMActivity
  implements f
{
  private TextWatcher ajS = new NearLifeCreatePoiUI.7(this);
  private com.tencent.mm.ui.base.p dpF;
  private String fTF;
  private View.OnClickListener mFA = new NearLifeCreatePoiUI.2(this);
  private View.OnClickListener mFB = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      NearLifeCreatePoiUI.this.findViewById(R.h.tv_more_content).setVisibility(8);
      NearLifeCreatePoiUI.this.findViewById(R.h.ll_pos_category_ctn).setVisibility(0);
      NearLifeCreatePoiUI.this.findViewById(R.h.ll_pos_tel_container).setVisibility(0);
    }
  };
  private MenuItem.OnMenuItemClickListener mFC = new NearLifeCreatePoiUI.4(this);
  private b.a mFD = new NearLifeCreatePoiUI.5(this);
  private MenuItem.OnMenuItemClickListener mFE = new NearLifeCreatePoiUI.6(this);
  private ato mFo;
  private String mFp;
  private String mFq;
  private Addr mFr;
  private String mFs;
  private EditText mFt;
  private EditText mFu;
  private TextView mFv;
  private TextView mFw;
  private com.tencent.mm.modelgeo.b mFx;
  private com.tencent.mm.plugin.nearlife.b.b mFy;
  private View.OnClickListener mFz = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new Intent();
      paramAnonymousView.putExtra("ui_title", R.l.nl_select_address_title);
      if (NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this) != null)
      {
        paramAnonymousView.putExtra("extra_province", NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this).ela);
        paramAnonymousView.putExtra("extra_city", NearLifeCreatePoiUI.a(NearLifeCreatePoiUI.this).elb);
      }
      d.b(NearLifeCreatePoiUI.this.mController.uMN, "address", ".ui.WalletMultiRcptSelectUI", paramAnonymousView, 1);
    }
  };
  
  private void boq()
  {
    h.a(this, R.l.nl_abandon_create_poi, R.l.nl_create_poi_title, new NearLifeCreatePoiUI.8(this), null);
  }
  
  protected final int getLayoutId()
  {
    return R.i.near_life_create_poi;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.nl_create_poi_title);
    ((ViewGroup)findViewById(R.h.ll_pos_district_ctn)).setOnClickListener(this.mFz);
    ((ViewGroup)findViewById(R.h.ll_pos_category_ctn)).setOnClickListener(this.mFA);
    ((TextView)findViewById(R.h.tv_more_content)).setOnClickListener(this.mFB);
    findViewById(R.h.tv_more_content).setVisibility(8);
    findViewById(R.h.ll_pos_category_ctn).setVisibility(0);
    findViewById(R.h.ll_pos_tel_container).setVisibility(0);
    this.mFt = ((EditText)findViewById(R.h.et_position_name));
    this.mFu = ((EditText)findViewById(R.h.et_detailed_address));
    this.mFv = ((TextView)findViewById(R.h.tv_position_district));
    this.mFw = ((TextView)findViewById(R.h.tv_position_category));
    this.mFt.addTextChangedListener(this.ajS);
    this.mFu.addTextChangedListener(this.ajS);
    this.mFv.addTextChangedListener(this.ajS);
    String str = bk.aM(getIntent().getStringExtra("get_poi_name"), "");
    if (str.length() != 0)
    {
      this.mFt.setText(str);
      this.mFt.setSelection(str.length());
    }
    c.d(this.mFt).Ig(100).a(null);
    c.d(this.mFu).Ig(400).a(null);
    c.d((EditText)findViewById(R.h.et_position_tel)).Ig(100).a(null);
    a(0, getString(R.l.app_finish), this.mFC, s.b.uNx);
    enableOptionMenu(0, false);
    setBackBtn(this.mFE);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getStringExtra("karea_result");
      } while (bk.bl(paramIntent));
      ((TextView)findViewById(R.h.tv_position_district)).setText(paramIntent.replace(" ", ""));
      return;
    } while ((-1 != paramInt2) || (paramIntent == null));
    paramIntent = bk.pm(paramIntent.getStringExtra("poi_category"));
    this.mFw.setText(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(650, this);
    this.mFo = new ato();
    this.mFo.sGK = getIntent().getFloatExtra("get_lat", -85.0F);
    this.mFo.sGJ = getIntent().getFloatExtra("get_lng", -1000.0F);
    this.mFo.sUn = getIntent().getIntExtra("get_preci", 0);
    this.mFo.sUp = "";
    this.mFo.sUq = 0;
    this.mFo.sUo = "";
    this.mFx = com.tencent.mm.modelgeo.b.NZ();
    if (this.mFx != null) {
      this.mFx.a(this.mFo.sGK, this.mFo.sGJ, this.mFD);
    }
    this.fTF = getIntent().getStringExtra("search_id");
    y.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[] { this.fTF });
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(650, this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramKeyEvent.getKeyCode())
    {
      boq();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.dpF.dismiss();
      paramString = (com.tencent.mm.plugin.nearlife.b.b)paramm;
      paramm = new Intent();
      if (this.mFo != null)
      {
        paramm.putExtra("get_lat", this.mFo.sGK);
        paramm.putExtra("get_lng", this.mFo.sGJ);
      }
      if (this.mFr != null) {
        paramm.putExtra("get_city", this.mFr.elb);
      }
      paramm.putExtra("get_poi_address", this.mFq);
      paramm.putExtra("get_poi_classify_id", paramString.mEf);
      paramm.putExtra("get_poi_name", this.mFp);
      paramm.putExtra("get_poi_classify_type", 1);
      setResult(-1, paramm);
      finish();
      return;
    }
    this.dpF.dismiss();
    Toast.makeText(this.mController.uMN, getString(R.l.nl_create_failed), 1).show();
    this.mFy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI
 * JD-Core Version:    0.7.0.1
 */