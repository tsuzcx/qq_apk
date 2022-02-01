package com.tencent.mm.ui.tools;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.au.b.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.f;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CountryCodeUI
  extends MMActivity
{
  private boolean JMd = false;
  private ListView JMt;
  private d afDU;
  private VerticalScrollBar afDV;
  private String[] afDW = null;
  private VerticalScrollBar.a afbu;
  private String countryCode;
  private s lMw;
  private List<b.a> list;
  private String oLl;
  private String pRp = "";
  private String qaB;
  private String title = null;
  
  public int getLayoutId()
  {
    AppMethodBeat.i(39001);
    if (LocaleUtil.isTraditionalChineseAppLang())
    {
      i = R.i.giL;
      AppMethodBeat.o(39001);
      return i;
    }
    int i = R.i.giK;
    AppMethodBeat.o(39001);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39003);
    int i;
    if (!Util.isNullOrNil(this.title))
    {
      setMMTitle(this.title);
      this.list = com.tencent.mm.au.b.OB(getString(R.l.country_code));
      if ((this.afDW == null) || (this.afDW.length <= 0)) {
        break label177;
      }
      i = this.list.size() - 1;
      label64:
      if (i < 0) {
        break label177;
      }
      String str = ((b.a)this.list.get(i)).oLj;
      String[] arrayOfString = this.afDW;
      int k = arrayOfString.length;
      j = 0;
      label98:
      if (j >= k) {
        break label172;
      }
      if (!arrayOfString[j].equals(str)) {
        break label165;
      }
      Log.i("MicroMsg.CountryCodeUI", "exclude country: %s", new Object[] { str });
    }
    label165:
    label172:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        this.list.remove(i);
      }
      i -= 1;
      break label64;
      setMMTitle(R.l.gqV);
      break;
      j += 1;
      break label98;
    }
    label177:
    if (!LocaleUtil.isTraditionalChineseAppLang())
    {
      Collections.sort(this.list, new Comparator() {});
      this.lMw = new s(true);
      this.lMw.afKz = new s.c()
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
        
        public final void bWw() {}
        
        public final void bWx() {}
        
        public final void bWy() {}
        
        public final void bWz() {}
      };
      addSearchMenu(true, this.lMw);
      this.JMt = ((ListView)findViewById(R.h.address_contactlist));
      this.afDU = new d(this, this.list);
      this.afDU.JMd = this.JMd;
      this.JMt.setAdapter(this.afDU);
      this.JMt.setVisibility(0);
      this.afDV = ((VerticalScrollBar)findViewById(R.h.fqN));
      if (LocaleUtil.isTraditionalChineseAppLang()) {
        break label388;
      }
    }
    label388:
    for (this.afbu = new VerticalScrollBar.a()
        {
          public final void onScollBarTouch(String paramAnonymousString)
          {
            int i = 0;
            AppMethodBeat.i(38996);
            int j = paramAnonymousString.charAt(0);
            if (CountryCodeUI.this.getString(R.l.scroll_bar_search).equals(paramAnonymousString))
            {
              CountryCodeUI.b(CountryCodeUI.this).setSelection(0);
              AppMethodBeat.o(38996);
              return;
            }
            paramAnonymousString = CountryCodeUI.c(CountryCodeUI.this).JMc;
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
        };; this.afbu = new VerticalScrollBar.a()
        {
          public final void onScollBarTouch(String paramAnonymousString)
          {
            int i = 0;
            AppMethodBeat.i(38997);
            if (CountryCodeUI.this.getString(R.l.scroll_bar_search).equals(paramAnonymousString))
            {
              CountryCodeUI.b(CountryCodeUI.this).setSelection(0);
              AppMethodBeat.o(38997);
              return;
            }
            int j = Integer.decode(paramAnonymousString.substring(0, paramAnonymousString.length() - 1)).intValue();
            paramAnonymousString = CountryCodeUI.c(CountryCodeUI.this).JMc;
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
      this.afDV.setOnScrollBarTouchListener(this.afbu);
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
      this.JMt.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38999);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          a.c("com/tencent/mm/ui/tools/CountryCodeUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = new Intent();
          if (paramAnonymousInt >= CountryCodeUI.b(CountryCodeUI.this).getHeaderViewsCount())
          {
            paramAnonymousView = (b.a)CountryCodeUI.c(CountryCodeUI.this).getItem(paramAnonymousInt - CountryCodeUI.b(CountryCodeUI.this).getHeaderViewsCount());
            paramAnonymousAdapterView.putExtra("country_name", paramAnonymousView.oLl);
            paramAnonymousAdapterView.putExtra("couttry_code", paramAnonymousView.oLk);
            paramAnonymousAdapterView.putExtra("iso_code", paramAnonymousView.oLj);
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
    this.oLl = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
    this.qaB = Util.nullAs(getIntent().getStringExtra("iso_code"), "");
    this.JMd = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
    this.afDW = getIntent().getStringArrayExtra("exclude_countries_iso");
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
      paramKeyEvent.putExtra("country_name", this.oLl);
      paramKeyEvent.putExtra("couttry_code", this.countryCode);
      paramKeyEvent.putExtra("iso_code", this.qaB);
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
    if (this.lMw != null) {
      this.lMw.jyO();
    }
    AppMethodBeat.o(39002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(251095);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(f.class);
    AppMethodBeat.o(251095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CountryCodeUI
 * JD-Core Version:    0.7.0.1
 */