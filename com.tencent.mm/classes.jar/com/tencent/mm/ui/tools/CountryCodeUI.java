package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.au.b.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.Collections;
import java.util.List;

public class CountryCodeUI
  extends MMActivity
{
  private VerticalScrollBar.a AaL;
  private c AqD;
  private VerticalScrollBar AqE;
  private String[] AqF = null;
  private String countryCode;
  private q eiV;
  private String fHT;
  private String gDF;
  private String gvZ = "";
  private List<b.a> list;
  private ListView nSF;
  private boolean nSq = false;
  private String title = null;
  
  public int getLayoutId()
  {
    AppMethodBeat.i(34808);
    if (aa.dsE())
    {
      AppMethodBeat.o(34808);
      return 2130969283;
    }
    AppMethodBeat.o(34808);
    return 2130969282;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34811);
    int i;
    if (!bo.isNullOrNil(this.title))
    {
      setMMTitle(this.title);
      this.list = b.G(this, getString(2131298871));
      if ((this.AqF == null) || (this.AqF.length <= 0)) {
        break label176;
      }
      i = this.list.size() - 1;
      label64:
      if (i < 0) {
        break label176;
      }
      String str = ((b.a)this.list.get(i)).fHR;
      String[] arrayOfString = this.AqF;
      int k = arrayOfString.length;
      j = 0;
      label98:
      if (j >= k) {
        break label171;
      }
      if (!arrayOfString[j].equals(str)) {
        break label164;
      }
      ab.i("MicroMsg.CountryCodeUI", "exclude country: %s", new Object[] { str });
    }
    label164:
    label171:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        this.list.remove(i);
      }
      i -= 1;
      break label64;
      setMMTitle(2131296503);
      break;
      j += 1;
      break label98;
    }
    label176:
    if (!aa.dsE())
    {
      Collections.sort(this.list, new CountryCodeUI.1(this));
      this.eiV = new q((byte)0);
      this.eiV.Axg = new CountryCodeUI.3(this);
      addSearchMenu(true, this.eiV);
      this.nSF = ((ListView)findViewById(2131821074));
      this.AqD = new c(this, this.list);
      this.AqD.nSq = this.nSq;
      this.nSF.setAdapter(this.AqD);
      this.nSF.setVisibility(0);
      this.AqE = ((VerticalScrollBar)findViewById(2131821077));
      if (aa.dsE()) {
        break label385;
      }
    }
    label385:
    for (this.AaL = new CountryCodeUI.4(this);; this.AaL = new CountryCodeUI.5(this))
    {
      this.AqE.setOnScrollBarTouchListener(this.AaL);
      setBackBtn(new CountryCodeUI.6(this));
      this.nSF.setOnItemClickListener(new CountryCodeUI.7(this));
      AppMethodBeat.o(34811);
      return;
      Collections.sort(this.list, new CountryCodeUI.2(this));
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34807);
    super.onCreate(paramBundle);
    this.fHT = ah.bf(getIntent().getStringExtra("country_name"), "");
    this.countryCode = ah.bf(getIntent().getStringExtra("couttry_code"), "");
    this.gDF = ah.bf(getIntent().getStringExtra("iso_code"), "");
    this.nSq = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
    this.AqF = getIntent().getStringArrayExtra("exclude_countries_iso");
    this.title = getIntent().getStringExtra("ui_title");
    initView();
    AppMethodBeat.o(34807);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34812);
    if (paramInt == 4)
    {
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("country_name", this.fHT);
      paramKeyEvent.putExtra("couttry_code", this.countryCode);
      paramKeyEvent.putExtra("iso_code", this.gDF);
      setResult(100, paramKeyEvent);
      finish();
      AppMethodBeat.o(34812);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(34812);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34809);
    super.onPause();
    if (this.eiV != null) {
      this.eiV.dNV();
    }
    AppMethodBeat.o(34809);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI
 * JD-Core Version:    0.7.0.1
 */