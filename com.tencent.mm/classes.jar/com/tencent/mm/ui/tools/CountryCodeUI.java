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
import com.tencent.mm.aw.b.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryCodeUI
  extends MMActivity
{
  private VerticalScrollBar.a PTg;
  private c Qpt;
  private VerticalScrollBar Qpu;
  private String[] Qpv = null;
  private String countryCode;
  private s gzP;
  private String jbZ;
  private String kdi = "";
  private String klq;
  private List<b.a> list;
  private String title = null;
  private boolean yuQ = false;
  private ListView yvg;
  
  public int getLayoutId()
  {
    AppMethodBeat.i(39001);
    if (LocaleUtil.isTraditionalChineseAppLang())
    {
      AppMethodBeat.o(39001);
      return 2131493801;
    }
    AppMethodBeat.o(39001);
    return 2131493800;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39003);
    int i;
    if (!Util.isNullOrNil(this.title))
    {
      setMMTitle(this.title);
      this.list = com.tencent.mm.aw.b.Pf(getString(2131758198));
      if ((this.Qpv == null) || (this.Qpv.length <= 0)) {
        break label175;
      }
      i = this.list.size() - 1;
      label63:
      if (i < 0) {
        break label175;
      }
      String str = ((b.a)this.list.get(i)).jbX;
      String[] arrayOfString = this.Qpv;
      int k = arrayOfString.length;
      j = 0;
      label97:
      if (j >= k) {
        break label170;
      }
      if (!arrayOfString[j].equals(str)) {
        break label163;
      }
      Log.i("MicroMsg.CountryCodeUI", "exclude country: %s", new Object[] { str });
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
      setMMTitle(2131755269);
      break;
      j += 1;
      break label97;
    }
    label175:
    if (!LocaleUtil.isTraditionalChineseAppLang())
    {
      Collections.sort(this.list, new Comparator() {});
      this.gzP = new s((byte)0);
      this.gzP.Qwi = new s.b()
      {
        public final boolean SN(String paramAnonymousString)
        {
          return false;
        }
        
        public final void SO(String paramAnonymousString)
        {
          AppMethodBeat.i(38995);
          CountryCodeUI.a(CountryCodeUI.this, paramAnonymousString);
          CountryCodeUI.a(CountryCodeUI.this);
          AppMethodBeat.o(38995);
        }
        
        public final void bnA() {}
        
        public final void bnB() {}
        
        public final void bny() {}
        
        public final void bnz() {}
      };
      addSearchMenu(true, this.gzP);
      this.yvg = ((ListView)findViewById(2131296545));
      this.Qpt = new c(this, this.list);
      this.Qpt.yuQ = this.yuQ;
      this.yvg.setAdapter(this.Qpt);
      this.yvg.setVisibility(0);
      this.Qpu = ((VerticalScrollBar)findViewById(2131296563));
      if (LocaleUtil.isTraditionalChineseAppLang()) {
        break label384;
      }
    }
    label384:
    for (this.PTg = new VerticalScrollBar.a()
        {
          public final void DP(String paramAnonymousString)
          {
            int i = 0;
            AppMethodBeat.i(38996);
            int j = paramAnonymousString.charAt(0);
            if (CountryCodeUI.this.getString(2131765029).equals(paramAnonymousString))
            {
              CountryCodeUI.b(CountryCodeUI.this).setSelection(0);
              AppMethodBeat.o(38996);
              return;
            }
            paramAnonymousString = CountryCodeUI.c(CountryCodeUI.this).yuP;
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
        };; this.PTg = new VerticalScrollBar.a()
        {
          public final void DP(String paramAnonymousString)
          {
            int i = 0;
            AppMethodBeat.i(38997);
            if (CountryCodeUI.this.getString(2131765029).equals(paramAnonymousString))
            {
              CountryCodeUI.b(CountryCodeUI.this).setSelection(0);
              AppMethodBeat.o(38997);
              return;
            }
            int j = Integer.decode(paramAnonymousString.substring(0, paramAnonymousString.length() - 1)).intValue();
            paramAnonymousString = CountryCodeUI.c(CountryCodeUI.this).yuP;
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
      this.Qpu.setOnScrollBarTouchListener(this.PTg);
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
      this.yvg.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38999);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          a.b("com/tencent/mm/ui/tools/CountryCodeUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = new Intent();
          if (paramAnonymousInt >= CountryCodeUI.b(CountryCodeUI.this).getHeaderViewsCount())
          {
            paramAnonymousView = (b.a)CountryCodeUI.c(CountryCodeUI.this).getItem(paramAnonymousInt - CountryCodeUI.b(CountryCodeUI.this).getHeaderViewsCount());
            paramAnonymousAdapterView.putExtra("country_name", paramAnonymousView.jbZ);
            paramAnonymousAdapterView.putExtra("couttry_code", paramAnonymousView.jbY);
            paramAnonymousAdapterView.putExtra("iso_code", paramAnonymousView.jbX);
            CountryCodeUI.this.setResult(100, paramAnonymousAdapterView);
          }
          CountryCodeUI.this.finish();
          a.a(this, "com/tencent/mm/ui/tools/CountryCodeUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
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
    this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
    this.klq = Util.nullAs(getIntent().getStringExtra("iso_code"), "");
    this.yuQ = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
    this.Qpv = getIntent().getStringArrayExtra("exclude_countries_iso");
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
      paramKeyEvent.putExtra("country_name", this.jbZ);
      paramKeyEvent.putExtra("couttry_code", this.countryCode);
      paramKeyEvent.putExtra("iso_code", this.klq);
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
    if (this.gzP != null) {
      this.gzP.gXP();
    }
    AppMethodBeat.o(39002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI
 * JD-Core Version:    0.7.0.1
 */