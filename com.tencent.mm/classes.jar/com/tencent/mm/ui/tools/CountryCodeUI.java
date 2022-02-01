package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryCodeUI
  extends MMActivity
{
  private c IMR;
  private VerticalScrollBar IMS;
  private String[] IMT = null;
  private VerticalScrollBar.a Itk;
  private String countryCode;
  private r fzp;
  private String hLr;
  private String iJd = "";
  private String iRg;
  private List<b.a> list;
  private boolean tNR = false;
  private ListView tOh;
  private String title = null;
  
  public int getLayoutId()
  {
    AppMethodBeat.i(39001);
    if (ab.eUM())
    {
      AppMethodBeat.o(39001);
      return 2131493671;
    }
    AppMethodBeat.o(39001);
    return 2131493670;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39003);
    int i;
    if (!bs.isNullOrNil(this.title))
    {
      setMMTitle(this.title);
      this.list = b.CN(getString(2131757950));
      if ((this.IMT == null) || (this.IMT.length <= 0)) {
        break label175;
      }
      i = this.list.size() - 1;
      label63:
      if (i < 0) {
        break label175;
      }
      String str = ((b.a)this.list.get(i)).hLp;
      String[] arrayOfString = this.IMT;
      int k = arrayOfString.length;
      j = 0;
      label97:
      if (j >= k) {
        break label170;
      }
      if (!arrayOfString[j].equals(str)) {
        break label163;
      }
      ac.i("MicroMsg.CountryCodeUI", "exclude country: %s", new Object[] { str });
    }
    label163:
    label170:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        this.list.remove(i);
      }
      i -= 1;
      break label63;
      setMMTitle(2131755235);
      break;
      j += 1;
      break label97;
    }
    label175:
    if (!ab.eUM())
    {
      Collections.sort(this.list, new Comparator() {});
      this.fzp = new r((byte)0);
      this.fzp.ITM = new r.b()
      {
        public final boolean Ga(String paramAnonymousString)
        {
          return false;
        }
        
        public final void Gb(String paramAnonymousString)
        {
          AppMethodBeat.i(38995);
          CountryCodeUI.a(CountryCodeUI.this, paramAnonymousString);
          CountryCodeUI.a(CountryCodeUI.this);
          AppMethodBeat.o(38995);
        }
        
        public final void aPa() {}
        
        public final void aPb() {}
        
        public final void aPc() {}
        
        public final void aPd() {}
      };
      addSearchMenu(true, this.fzp);
      this.tOh = ((ListView)findViewById(2131296471));
      this.IMR = new c(this, this.list);
      this.IMR.tNR = this.tNR;
      this.tOh.setAdapter(this.IMR);
      this.tOh.setVisibility(0);
      this.IMS = ((VerticalScrollBar)findViewById(2131296489));
      if (ab.eUM()) {
        break label384;
      }
    }
    label384:
    for (this.Itk = new VerticalScrollBar.a()
        {
          public final void sn(String paramAnonymousString)
          {
            int i = 0;
            AppMethodBeat.i(38996);
            int j = paramAnonymousString.charAt(0);
            if (CountryCodeUI.this.getString(2131762893).equals(paramAnonymousString))
            {
              CountryCodeUI.b(CountryCodeUI.this).setSelection(0);
              AppMethodBeat.o(38996);
              return;
            }
            paramAnonymousString = CountryCodeUI.c(CountryCodeUI.this).tNQ;
            if (paramAnonymousString == null)
            {
              AppMethodBeat.o(38996);
              return;
            }
            do
            {
              i += 1;
              if (i >= paramAnonymousString.length) {
                break;
              }
            } while (paramAnonymousString[i] != j);
            CountryCodeUI.b(CountryCodeUI.this).setSelection(i + CountryCodeUI.b(CountryCodeUI.this).getHeaderViewsCount());
            AppMethodBeat.o(38996);
            return;
            AppMethodBeat.o(38996);
          }
        };; this.Itk = new VerticalScrollBar.a()
        {
          public final void sn(String paramAnonymousString)
          {
            int i = 0;
            AppMethodBeat.i(38997);
            if (CountryCodeUI.this.getString(2131762893).equals(paramAnonymousString))
            {
              CountryCodeUI.b(CountryCodeUI.this).setSelection(0);
              AppMethodBeat.o(38997);
              return;
            }
            int j = Integer.decode(paramAnonymousString.substring(0, paramAnonymousString.length() - 1)).intValue();
            paramAnonymousString = CountryCodeUI.c(CountryCodeUI.this).tNQ;
            if (paramAnonymousString == null)
            {
              AppMethodBeat.o(38997);
              return;
            }
            do
            {
              i += 1;
              if (i >= paramAnonymousString.length) {
                break;
              }
            } while (paramAnonymousString[i] != j);
            CountryCodeUI.b(CountryCodeUI.this).setSelection(i + CountryCodeUI.b(CountryCodeUI.this).getHeaderViewsCount());
            AppMethodBeat.o(38997);
            return;
            AppMethodBeat.o(38997);
          }
        })
    {
      this.IMS.setOnScrollBarTouchListener(this.Itk);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38998);
          CountryCodeUI.this.hideVKB();
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("country_name", CountryCodeUI.d(CountryCodeUI.this));
          paramAnonymousMenuItem.putExtra("couttry_code", CountryCodeUI.e(CountryCodeUI.this));
          paramAnonymousMenuItem.putExtra("iso_code", CountryCodeUI.f(CountryCodeUI.this));
          CountryCodeUI.this.setResult(100, paramAnonymousMenuItem);
          CountryCodeUI.this.finish();
          AppMethodBeat.o(38998);
          return true;
        }
      });
      this.tOh.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38999);
          paramAnonymousAdapterView = new Intent();
          if (paramAnonymousInt >= CountryCodeUI.b(CountryCodeUI.this).getHeaderViewsCount())
          {
            paramAnonymousView = (b.a)CountryCodeUI.c(CountryCodeUI.this).getItem(paramAnonymousInt - CountryCodeUI.b(CountryCodeUI.this).getHeaderViewsCount());
            paramAnonymousAdapterView.putExtra("country_name", paramAnonymousView.hLr);
            paramAnonymousAdapterView.putExtra("couttry_code", paramAnonymousView.hLq);
            paramAnonymousAdapterView.putExtra("iso_code", paramAnonymousView.hLp);
            CountryCodeUI.this.setResult(100, paramAnonymousAdapterView);
          }
          CountryCodeUI.this.finish();
          AppMethodBeat.o(38999);
        }
      });
      AppMethodBeat.o(39003);
      return;
      Collections.sort(this.list, new Comparator() {});
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39000);
    super.onCreate(paramBundle);
    this.hLr = bs.bG(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bs.bG(getIntent().getStringExtra("couttry_code"), "");
    this.iRg = bs.bG(getIntent().getStringExtra("iso_code"), "");
    this.tNR = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
    this.IMT = getIntent().getStringArrayExtra("exclude_countries_iso");
    this.title = getIntent().getStringExtra("ui_title");
    initView();
    AppMethodBeat.o(39000);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(39004);
    if (paramInt == 4)
    {
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("country_name", this.hLr);
      paramKeyEvent.putExtra("couttry_code", this.countryCode);
      paramKeyEvent.putExtra("iso_code", this.iRg);
      setResult(100, paramKeyEvent);
      finish();
      AppMethodBeat.o(39004);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(39004);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39002);
    super.onPause();
    if (this.fzp != null) {
      this.fzp.ftR();
    }
    AppMethodBeat.o(39002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI
 * JD-Core Version:    0.7.0.1
 */