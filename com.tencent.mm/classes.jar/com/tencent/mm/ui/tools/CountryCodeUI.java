package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.at.b;
import com.tencent.mm.at.b.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.Collections;
import java.util.List;

public class CountryCodeUI
  extends MMActivity
{
  private String countryCode;
  private n drn;
  private String esg;
  private String feq = "";
  private String fml;
  private List<b.a> list;
  private boolean luZ = false;
  private ListView lvp;
  private VerticalScrollBar.a vJp;
  private c vYr;
  private VerticalScrollBar vYs;
  
  protected final int getLayoutId()
  {
    if (x.cqH()) {
      return R.i.country_code_select_big5;
    }
    return R.i.country_code_select;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.address_title_select_country_code);
    this.list = b.C(this, getString(R.l.country_code));
    if (!x.cqH())
    {
      Collections.sort(this.list, new CountryCodeUI.1(this));
      this.drn = new n((byte)0);
      this.drn.weq = new CountryCodeUI.3(this);
      a(this.drn);
      this.lvp = ((ListView)findViewById(R.h.address_contactlist));
      this.vYr = new c(this, this.list);
      this.vYr.luZ = this.luZ;
      this.lvp.setAdapter(this.vYr);
      this.lvp.setVisibility(0);
      this.vYs = ((VerticalScrollBar)findViewById(R.h.address_scrollbar));
      if (x.cqH()) {
        break label227;
      }
    }
    label227:
    for (this.vJp = new CountryCodeUI.4(this);; this.vJp = new CountryCodeUI.5(this))
    {
      this.vYs.setOnScrollBarTouchListener(this.vJp);
      setBackBtn(new CountryCodeUI.6(this));
      this.lvp.setOnItemClickListener(new CountryCodeUI.7(this));
      return;
      Collections.sort(this.list, new CountryCodeUI.2(this));
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.esg = ah.aM(getIntent().getStringExtra("country_name"), "");
    this.countryCode = ah.aM(getIntent().getStringExtra("couttry_code"), "");
    this.fml = ah.aM(getIntent().getStringExtra("iso_code"), "");
    this.luZ = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
    initView();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("country_name", this.esg);
      paramKeyEvent.putExtra("couttry_code", this.countryCode);
      paramKeyEvent.putExtra("iso_code", this.fml);
      setResult(100, paramKeyEvent);
      finish();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.drn != null) {
      this.drn.cJg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI
 * JD-Core Version:    0.7.0.1
 */