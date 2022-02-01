package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.tools.d;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.List;

public abstract class MMBaseSelectContactUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, MultiSelectContactView.c, MultiSelectContactView.d, MultiSelectContactView.e, VerticalScrollBar.a, n, r.b
{
  private View Iun;
  private AlphabetScrollBar Iwj;
  private q Iwk;
  public o Iwl;
  private View Iwm;
  private com.tencent.mm.ui.base.o Iwn;
  private View Iwo;
  private View Iwp;
  private View Iwq;
  private TextView Iwr;
  public LabelContainerView Iws;
  private TextView Iwt;
  private MMTagPanel Iwu;
  private boolean Iwv = true;
  private List<String> Iww = new ArrayList();
  protected r fzp;
  protected int scene;
  public MultiSelectContactView uFo;
  protected ListView vXs;
  private View xET;
  
  private String fru()
  {
    if (this.fzp != null) {
      return this.fzp.getSearchContent();
    }
    if (this.uFo != null) {
      return this.uFo.getSearchContent();
    }
    return "";
  }
  
  private void frv()
  {
    boolean bool;
    if (this.fzp != null)
    {
      bool = this.fzp.ftr();
      if ((!bool) || (!bs.isNullOrNil(fru()))) {
        break label102;
      }
      if ((this.Iww == null) || (this.Iww.size() <= 0)) {
        break label92;
      }
      this.Iws.setVisibility(0);
      this.Iwu.a(null, this.Iww);
    }
    label92:
    label102:
    while (this.Iws == null)
    {
      return;
      if (this.uFo != null)
      {
        bool = this.uFo.hasFocus();
        break;
      }
      bool = false;
      break;
      this.Iws.setVisibility(8);
      return;
    }
    this.Iws.setVisibility(8);
  }
  
  private void frw()
  {
    ac.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.vXs, 0);
    this.vXs.setAdapter(this.Iwk);
    this.Iwk.notifyDataSetChanged();
    if ((aOj()) && (this.Iwj != null)) {
      this.Iwj.setVisibility(0);
    }
    this.Iwq.setVisibility(8);
  }
  
  public final boolean Ga(String paramString)
  {
    return false;
  }
  
  public final void Gb(String paramString)
  {
    ac.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (dce())
    {
      if (this.fzp != null) {
        this.fzp.fts();
      }
      frv();
    }
    if (!bs.isNullOrNil(paramString))
    {
      this.Iwl.b(paramString, daw());
      return;
    }
    this.Iwl.clearData();
    this.Iwl.notifyDataSetChanged();
    frw();
  }
  
  public void O(int paramInt, String paramString) {}
  
  protected void WJ()
  {
    this.scene = getIntent().getIntExtra("scene", 0);
  }
  
  protected void a(ListView paramListView, int paramInt) {}
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void aGX(String paramString)
  {
    ac.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (dce()) {
      frv();
    }
    if (this.Iwl != null)
    {
      if (!bs.isNullOrNil(paramString)) {
        this.Iwl.b(paramString, daw());
      }
    }
    else {
      return;
    }
    this.Iwl.clearData();
    this.Iwl.notifyDataSetChanged();
    frw();
  }
  
  protected abstract boolean aOi();
  
  protected abstract boolean aOj();
  
  protected abstract String aOk();
  
  protected abstract q aOl();
  
  protected abstract o aOm();
  
  public final void aPa()
  {
    frw();
    if (dce()) {
      frv();
    }
    if (aOi())
    {
      this.Iwm.setVisibility(0);
      this.Iwo.setBackgroundColor(getResources().getColor(2131099679));
      this.Iun.setVisibility(8);
      this.Iwo.setVisibility(0);
    }
  }
  
  public final void aPb() {}
  
  public final void aPc()
  {
    if (this.Iun != null) {
      this.Iun.setVisibility(0);
    }
  }
  
  public final void aPd() {}
  
  protected void akG(String paramString)
  {
    ac.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
  }
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public int[] daw()
  {
    return new int[] { 131072, 131075, 131081 };
  }
  
  public void dax()
  {
    hideVKB();
    finish();
  }
  
  protected boolean dce()
  {
    return false;
  }
  
  public final void eMX()
  {
    if (dce()) {
      frv();
    }
  }
  
  public final p frq()
  {
    if (getContentLV().getHeaderViewsCount() > 0) {
      return (p)((HeaderViewListAdapter)getContentLV().getAdapter()).getWrappedAdapter();
    }
    return (p)getContentLV().getAdapter();
  }
  
  public q frr()
  {
    return this.Iwk;
  }
  
  public final void frs()
  {
    if (this.Iwm != null)
    {
      this.Iwm.setVisibility(0);
      this.Iwo.setBackgroundColor(getResources().getColor(2131099679));
    }
  }
  
  public final void frt()
  {
    if (this.Iwm != null)
    {
      this.Iwm.setVisibility(8);
      this.Iwo.setBackgroundColor(getResources().getColor(2131101179));
    }
  }
  
  public final void frx()
  {
    if ((this.fzp != null) && (!bs.isNullOrNil(this.fzp.getSearchContent())))
    {
      r localr = this.fzp;
      if (localr.ITL != null) {
        localr.ITL.xM(true);
      }
    }
    if ((this.uFo != null) && (!bs.isNullOrNil(this.uFo.getSearchContent()))) {
      this.uFo.getInputText().setText("");
    }
  }
  
  protected final void fry()
  {
    if (this.fzp != null) {
      if (this.fzp.ftr()) {
        this.fzp.clearFocus();
      }
    }
    while ((this.uFo == null) || (!this.uFo.hasFocus())) {
      return;
    }
    this.uFo.clearFocus();
  }
  
  public boolean frz()
  {
    return this.Iwl != null;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.vXs;
  }
  
  public int getLayoutId()
  {
    return 2131494899;
  }
  
  public void initView()
  {
    setMMTitle(aOk());
    this.Iwm = findViewById(2131306016);
    this.Iun = findViewById(2131306014);
    this.vXs = ((ListView)findViewById(2131304508));
    this.Iwk = aOl();
    this.Iwl = aOm();
    this.xET = findViewById(2131304671);
    if (frz())
    {
      this.Iwq = findViewById(2131302885);
      this.Iwr = ((TextView)findViewById(2131302884));
      this.Iwq.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102851);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
          MMBaseSelectContactUI.this.frx();
          MMBaseSelectContactUI.this.fry();
          AppMethodBeat.o(102851);
          return false;
        }
      });
      this.uFo = ((MultiSelectContactView)findViewById(2131298676));
      this.uFo.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, -2147483648));
      this.uFo.setOnSearchTextChangeListener(this);
      this.uFo.setOnSearchTextFouceChangeListener(this);
      this.uFo.setOnContactDeselectListener(this);
      this.Iwp = LayoutInflater.from(this).inflate(2131493600, null);
      this.Iwo = this.Iwp.findViewById(2131300701);
      this.vXs.addHeaderView(this.Iwp);
      if (!aOi()) {
        break label576;
      }
      hideActionbarLine();
      if (this.uFo != null) {
        this.uFo.setVisibility(8);
      }
      this.Iwm.setVisibility(0);
      this.Iwo.setBackgroundColor(getResources().getColor(2131099679));
      this.Iun.setVisibility(8);
      this.fzp = new r((byte)0);
      this.fzp.ITM = this;
      this.Iwm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(102852);
          ac.d("MicroMsg.MMBaseSelectContactUI", "dancy test topSearchView onClick!!");
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).xO(true);
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).setVisibility(8);
          AppMethodBeat.o(102852);
        }
      });
      this.Iun.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102853);
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).ftR();
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).setVisibility(0);
          AppMethodBeat.o(102853);
          return true;
        }
      });
    }
    for (;;)
    {
      a(this.vXs, 0);
      this.vXs.setAdapter(this.Iwk);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(102854);
          MMBaseSelectContactUI.this.dax();
          AppMethodBeat.o(102854);
          return true;
        }
      });
      if (this.Iwl != null) {
        this.Iwl.a(new o.a()
        {
          public final void y(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(102855);
            ac.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (MMBaseSelectContactUI.d(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(8);
            }
            if ((paramAnonymousBoolean) && (paramAnonymousInt == 0))
            {
              if (!bs.isNullOrNil(paramAnonymousString))
              {
                MMBaseSelectContactUI.f(MMBaseSelectContactUI.this);
                AppMethodBeat.o(102855);
                return;
              }
              MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
              AppMethodBeat.o(102855);
              return;
            }
            MMBaseSelectContactUI.g(MMBaseSelectContactUI.this);
            AppMethodBeat.o(102855);
          }
        });
      }
      this.vXs.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102857);
          if ((!MMBaseSelectContactUI.this.aOi()) && (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null))
          {
            paramAnonymousAbsListView = MMBaseSelectContactUI.this.vXs.getChildAt(MMBaseSelectContactUI.this.vXs.getFirstVisiblePosition());
            if ((paramAnonymousAbsListView == null) || (paramAnonymousAbsListView.getTop() != 0)) {
              break label80;
            }
            MMBaseSelectContactUI.i(MMBaseSelectContactUI.this).setVisibility(8);
          }
          while (paramAnonymousInt1 < 2)
          {
            AppMethodBeat.o(102857);
            return;
            label80:
            MMBaseSelectContactUI.i(MMBaseSelectContactUI.this).setVisibility(0);
          }
          g.agS();
          if (!bs.l((Boolean)g.agR().agA().get(12296, null)))
          {
            g.agS();
            g.agR().agA().set(12296, Boolean.TRUE);
            if (MMBaseSelectContactUI.j(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.j(MMBaseSelectContactUI.this).dismiss();
            }
            MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, t.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.getString(2131761076), 4000L));
          }
          AppMethodBeat.o(102857);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(102856);
          if (paramAnonymousInt != 0)
          {
            MMBaseSelectContactUI.this.hideVKB();
            MMBaseSelectContactUI.this.fry();
          }
          AppMethodBeat.o(102856);
        }
      });
      this.vXs.setOnItemClickListener(this);
      if (aOj())
      {
        this.Iwj = ((AlphabetScrollBar)findViewById(2131304510));
        this.Iwj.setVisibility(0);
        this.Iwj.setOnScrollBarTouchListener(this);
      }
      if (dce())
      {
        this.Iws = ((LabelContainerView)findViewById(2131304507));
        this.Iwt = ((TextView)this.Iws.findViewById(16908310));
        this.Iwt.setText(2131762979);
        this.Iwu = ((MMTagPanel)this.Iws.findViewById(2131298672));
        this.Iwu.setTagSelectedBG(2131234298);
        this.Iwu.setTagSelectedTextColorRes(2131100711);
        this.Iws.setOnLabelContainerListener(new LabelContainerView.a()
        {
          public final void cen()
          {
            AppMethodBeat.i(102858);
            if (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.h(MMBaseSelectContactUI.this).clearFocus();
            }
            if (MMBaseSelectContactUI.b(MMBaseSelectContactUI.this) != null)
            {
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).clearFocus();
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).ftR();
            }
            MMBaseSelectContactUI.this.Iws.requestFocus();
            MMBaseSelectContactUI.this.Iws.setVisibility(8);
            AppMethodBeat.o(102858);
          }
          
          public final void ceo()
          {
            AppMethodBeat.i(102859);
            MMBaseSelectContactUI.this.hideVKB();
            AppMethodBeat.o(102859);
          }
        });
        this.Iwu.setCallBack(new MMTagPanel.a()
        {
          public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void YA(String paramAnonymousString) {}
          
          public final void Yw(String paramAnonymousString) {}
          
          public final void Yx(String paramAnonymousString)
          {
            AppMethodBeat.i(102860);
            MMBaseSelectContactUI.this.akG(paramAnonymousString);
            AppMethodBeat.o(102860);
          }
          
          public final void Yy(String paramAnonymousString) {}
          
          public final void Yz(String paramAnonymousString) {}
          
          public final void cep() {}
        });
      }
      return;
      label576:
      if (this.Iwm != null)
      {
        this.Iwm.setVisibility(8);
        this.Iwo.setBackgroundColor(getResources().getColor(2131101179));
      }
      if (this.Iun != null) {
        this.Iun.setVisibility(8);
      }
      this.uFo.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ac.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!g.agM())
    {
      ac.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      ac.eUR();
      finish();
      return;
    }
    WJ();
    ac.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    initView();
    ac.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (aOi())
    {
      this.fzp.a(this, paramMenu);
      if (paramMenu != null)
      {
        int i = 0;
        while (i < paramMenu.size())
        {
          MenuItem localMenuItem = paramMenu.getItem(i);
          if (localMenuItem.getItemId() == 2131302248) {
            localMenuItem.setVisible(false);
          }
          i += 1;
        }
      }
      return super.onCreateOptionsMenu(paramMenu);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.Iwj != null) {
      this.Iwj.HDk = null;
    }
    if (this.Iwk != null) {
      this.Iwk.finish();
    }
    if (this.Iwl != null) {
      this.Iwl.finish();
    }
    if (this.Iwn != null) {
      this.Iwn.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt - getContentLV().getHeaderViewsCount();
    int j;
    if (i >= 0)
    {
      paramAdapterView = frq().abQ(i);
      paramView = paramAdapterView.aOg();
      getContext();
      paramView.aOh();
      if (paramAdapterView.gbD)
      {
        i = paramAdapterView.szz;
        j = paramAdapterView.szA;
        if (!paramAdapterView.cKI()) {
          break label239;
        }
        i = 15;
        switch (paramAdapterView.szz)
        {
        default: 
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (paramAdapterView.IzD) {
        j = 1;
      }
      if (paramAdapterView.oeH == 5) {
        j = 7;
      }
      paramAdapterView = String.format("%s,%d,%d,%d,%d", new Object[] { paramAdapterView.query, Integer.valueOf(paramAdapterView.scene), Integer.valueOf(j), Integer.valueOf(paramAdapterView.szu), Integer.valueOf(i) });
      ac.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramAdapterView });
      h.wUl.kvStat(13234, paramAdapterView);
      if (!frq().abR(paramInt)) {
        qG(paramInt);
      }
      return;
      label239:
      if (i == 131072) {
        switch (j)
        {
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 13: 
        case 14: 
        default: 
          i = 0;
          break;
        case 1: 
          i = 1;
          break;
        case 2: 
          i = 2;
          break;
        case 3: 
          i = 3;
          break;
        case 4: 
          i = 4;
          break;
        case 5: 
          i = 5;
          break;
        case 6: 
          i = 6;
          break;
        case 7: 
          i = 7;
          break;
        case 11: 
          i = 8;
          break;
        case 16: 
          i = 10;
          break;
        case 17: 
        case 18: 
          i = 9;
          break;
        case 15: 
          i = 16;
          break;
        }
      }
      if (i == 131075) {
        switch (j)
        {
        default: 
          i = 0;
          break;
        case 1: 
        case 5: 
          i = 12;
          break;
        case 2: 
        case 6: 
          i = 13;
          break;
        case 3: 
        case 7: 
          i = 14;
          break;
        case 29: 
        case 30: 
        case 31: 
        case 32: 
        case 34: 
        case 35: 
        case 36: 
        case 37: 
        case 38: 
          i = 11;
          break;
        }
      }
      if (i == 65536)
      {
        i = 17;
        break;
      }
      i = 0;
      break;
      j = 2;
      continue;
      j = 3;
      continue;
      j = 4;
      continue;
      j = 5;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4) {
      dax();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.Iwn != null) {
      this.Iwn.dismiss();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (aOi())
    {
      this.fzp.a(this, paramMenu);
      return super.onPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((dce()) && (this.Iwv))
    {
      this.Iwv = false;
      g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102862);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, com.tencent.mm.plugin.label.a.a.cWd().cVY());
          MMBaseSelectContactUI.k(MMBaseSelectContactUI.this);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(102861);
              MMBaseSelectContactUI.l(MMBaseSelectContactUI.this);
              AppMethodBeat.o(102861);
            }
          });
          AppMethodBeat.o(102862);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(102863);
          String str = super.toString() + "|updateLabelList";
          AppMethodBeat.o(102863);
          return str;
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void qG(int paramInt) {}
  
  public final void sn(String paramString)
  {
    ListAdapter localListAdapter2 = this.vXs.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof HeaderViewListAdapter)) {
      localListAdapter1 = ((HeaderViewListAdapter)localListAdapter2).getWrappedAdapter();
    }
    int i;
    if (localListAdapter1 == this.Iwk) {
      i = this.Iwk.aQR(paramString);
    }
    for (;;)
    {
      if (i == 0) {
        this.vXs.setSelection(0);
      }
      do
      {
        return;
        if (localListAdapter1 != this.Iwl) {
          break label182;
        }
        i = this.Iwl.aQR(paramString);
        break;
        if (i <= 0) {
          break label158;
        }
        if (aOi())
        {
          this.vXs.setSelection(i);
          return;
        }
      } while (this.uFo == null);
      this.vXs.setSelectionFromTop(i, this.uFo.getMeasuredHeight());
      ac.i("MicroMsg.MMBaseSelectContactUI", "Select head selectPosition=%d | header=%s | y=%d", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(this.uFo.getMeasuredHeight()) });
      return;
      label158:
      ac.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
      return;
      label182:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI
 * JD-Core Version:    0.7.0.1
 */