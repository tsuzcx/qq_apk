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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
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
  private View GUc;
  private AlphabetScrollBar GVV;
  private q GVW;
  public o GVX;
  private View GVY;
  private com.tencent.mm.ui.base.o GVZ;
  private View GWa;
  private View GWb;
  private View GWc;
  private TextView GWd;
  public LabelContainerView GWe;
  private TextView GWf;
  private MMTagPanel GWg;
  private boolean GWh = true;
  private List<String> GWi = new ArrayList();
  protected r fvI;
  protected int scene;
  public MultiSelectContactView twW;
  protected ListView uOC;
  private View wtD;
  
  private String fbD()
  {
    if (this.fvI != null) {
      return this.fvI.getSearchContent();
    }
    if (this.twW != null) {
      return this.twW.getSearchContent();
    }
    return "";
  }
  
  private void fbE()
  {
    boolean bool;
    if (this.fvI != null)
    {
      bool = this.fvI.fdw();
      if ((!bool) || (!bt.isNullOrNil(fbD()))) {
        break label102;
      }
      if ((this.GWi == null) || (this.GWi.size() <= 0)) {
        break label92;
      }
      this.GWe.setVisibility(0);
      this.GWg.a(null, this.GWi);
    }
    label92:
    label102:
    while (this.GWe == null)
    {
      return;
      if (this.twW != null)
      {
        bool = this.twW.hasFocus();
        break;
      }
      bool = false;
      break;
      this.GWe.setVisibility(8);
      return;
    }
    this.GWe.setVisibility(8);
  }
  
  private void fbF()
  {
    ad.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.uOC, 0);
    this.uOC.setAdapter(this.GVW);
    this.GVW.notifyDataSetChanged();
    if ((aHu()) && (this.GVV != null)) {
      this.GVV.setVisibility(0);
    }
    this.GWc.setVisibility(8);
  }
  
  public final boolean BX(String paramString)
  {
    return false;
  }
  
  public final void BY(String paramString)
  {
    ad.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (cOv())
    {
      if (this.fvI != null) {
        this.fvI.fdx();
      }
      fbE();
    }
    if (!bt.isNullOrNil(paramString))
    {
      this.GVX.b(paramString, cMQ());
      return;
    }
    this.GVX.clearData();
    this.GVX.notifyDataSetChanged();
    fbF();
  }
  
  public void N(int paramInt, String paramString) {}
  
  protected void VL()
  {
    this.scene = getIntent().getIntExtra("scene", 0);
  }
  
  protected void a(ListView paramListView, int paramInt) {}
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void aBF(String paramString)
  {
    ad.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (cOv()) {
      fbE();
    }
    if (this.GVX != null)
    {
      if (!bt.isNullOrNil(paramString)) {
        this.GVX.b(paramString, cMQ());
      }
    }
    else {
      return;
    }
    this.GVX.clearData();
    this.GVX.notifyDataSetChanged();
    fbF();
  }
  
  protected abstract boolean aHt();
  
  protected abstract boolean aHu();
  
  protected abstract String aHv();
  
  protected abstract q aHw();
  
  protected abstract o aHx();
  
  public final void aIj()
  {
    fbF();
    if (cOv()) {
      fbE();
    }
    if (aHt())
    {
      this.GVY.setVisibility(0);
      this.GWa.setBackgroundColor(getResources().getColor(2131099679));
      this.GUc.setVisibility(8);
      this.GWa.setVisibility(0);
    }
  }
  
  public final void aIk() {}
  
  public final void aIl()
  {
    if (this.GUc != null) {
      this.GUc.setVisibility(0);
    }
  }
  
  public final void aIm() {}
  
  protected void afM(String paramString)
  {
    ad.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
  }
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public int[] cMQ()
  {
    return new int[] { 131072, 131075, 131081 };
  }
  
  public void cMR()
  {
    hideVKB();
    finish();
  }
  
  protected boolean cOv()
  {
    return false;
  }
  
  public final void exD()
  {
    if (cOv()) {
      fbE();
    }
  }
  
  public q fbA()
  {
    return this.GVW;
  }
  
  public final void fbB()
  {
    if (this.GVY != null)
    {
      this.GVY.setVisibility(0);
      this.GWa.setBackgroundColor(getResources().getColor(2131099679));
    }
  }
  
  public final void fbC()
  {
    if (this.GVY != null)
    {
      this.GVY.setVisibility(8);
      this.GWa.setBackgroundColor(getResources().getColor(2131101179));
    }
  }
  
  public final void fbG()
  {
    if ((this.fvI != null) && (!bt.isNullOrNil(this.fvI.getSearchContent())))
    {
      r localr = this.fvI;
      if (localr.Hto != null) {
        localr.Hto.wF(true);
      }
    }
    if ((this.twW != null) && (!bt.isNullOrNil(this.twW.getSearchContent()))) {
      this.twW.getInputText().setText("");
    }
  }
  
  protected final void fbH()
  {
    if (this.fvI != null) {
      if (this.fvI.fdw()) {
        this.fvI.clearFocus();
      }
    }
    while ((this.twW == null) || (!this.twW.hasFocus())) {
      return;
    }
    this.twW.clearFocus();
  }
  
  public boolean fbI()
  {
    return this.GVX != null;
  }
  
  public final p fbz()
  {
    if (getContentLV().getHeaderViewsCount() > 0) {
      return (p)((HeaderViewListAdapter)getContentLV().getAdapter()).getWrappedAdapter();
    }
    return (p)getContentLV().getAdapter();
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.uOC;
  }
  
  public int getLayoutId()
  {
    return 2131494899;
  }
  
  public void initView()
  {
    setMMTitle(aHv());
    this.GVY = findViewById(2131306016);
    this.GUc = findViewById(2131306014);
    this.uOC = ((ListView)findViewById(2131304508));
    this.GVW = aHw();
    this.GVX = aHx();
    this.wtD = findViewById(2131304671);
    if (fbI())
    {
      this.GWc = findViewById(2131302885);
      this.GWd = ((TextView)findViewById(2131302884));
      this.GWc.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102851);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
          MMBaseSelectContactUI.this.fbG();
          MMBaseSelectContactUI.this.fbH();
          AppMethodBeat.o(102851);
          return false;
        }
      });
      this.twW = ((MultiSelectContactView)findViewById(2131298676));
      this.twW.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, -2147483648));
      this.twW.setOnSearchTextChangeListener(this);
      this.twW.setOnSearchTextFouceChangeListener(this);
      this.twW.setOnContactDeselectListener(this);
      this.GWb = LayoutInflater.from(this).inflate(2131493600, null);
      this.GWa = this.GWb.findViewById(2131300701);
      this.uOC.addHeaderView(this.GWb);
      if (!aHt()) {
        break label576;
      }
      hideActionbarLine();
      if (this.twW != null) {
        this.twW.setVisibility(8);
      }
      this.GVY.setVisibility(0);
      this.GWa.setBackgroundColor(getResources().getColor(2131099679));
      this.GUc.setVisibility(8);
      this.fvI = new r((byte)0);
      this.fvI.Htp = this;
      this.GVY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(102852);
          ad.d("MicroMsg.MMBaseSelectContactUI", "dancy test topSearchView onClick!!");
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).wH(true);
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).setVisibility(8);
          AppMethodBeat.o(102852);
        }
      });
      this.GUc.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102853);
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).fdW();
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
      a(this.uOC, 0);
      this.uOC.setAdapter(this.GVW);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(102854);
          MMBaseSelectContactUI.this.cMR();
          AppMethodBeat.o(102854);
          return true;
        }
      });
      if (this.GVX != null) {
        this.GVX.a(new o.a()
        {
          public final void y(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(102855);
            ad.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (MMBaseSelectContactUI.d(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(8);
            }
            if ((paramAnonymousBoolean) && (paramAnonymousInt == 0))
            {
              if (!bt.isNullOrNil(paramAnonymousString))
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
      this.uOC.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102857);
          if ((!MMBaseSelectContactUI.this.aHt()) && (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null))
          {
            paramAnonymousAbsListView = MMBaseSelectContactUI.this.uOC.getChildAt(MMBaseSelectContactUI.this.uOC.getFirstVisiblePosition());
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
          g.afC();
          if (!bt.l((Boolean)g.afB().afk().get(12296, null)))
          {
            g.afC();
            g.afB().afk().set(12296, Boolean.TRUE);
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
            MMBaseSelectContactUI.this.fbH();
          }
          AppMethodBeat.o(102856);
        }
      });
      this.uOC.setOnItemClickListener(this);
      if (aHu())
      {
        this.GVV = ((AlphabetScrollBar)findViewById(2131304510));
        this.GVV.setVisibility(0);
        this.GVV.setOnScrollBarTouchListener(this);
      }
      if (cOv())
      {
        this.GWe = ((LabelContainerView)findViewById(2131304507));
        this.GWf = ((TextView)this.GWe.findViewById(16908310));
        this.GWf.setText(2131762979);
        this.GWg = ((MMTagPanel)this.GWe.findViewById(2131298672));
        this.GWg.setTagSelectedBG(2131234298);
        this.GWg.setTagSelectedTextColorRes(2131100711);
        this.GWe.setOnLabelContainerListener(new LabelContainerView.a()
        {
          public final void bXa()
          {
            AppMethodBeat.i(102858);
            if (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.h(MMBaseSelectContactUI.this).clearFocus();
            }
            if (MMBaseSelectContactUI.b(MMBaseSelectContactUI.this) != null)
            {
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).clearFocus();
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).fdW();
            }
            MMBaseSelectContactUI.this.GWe.requestFocus();
            MMBaseSelectContactUI.this.GWe.setVisibility(8);
            AppMethodBeat.o(102858);
          }
          
          public final void bXb()
          {
            AppMethodBeat.i(102859);
            MMBaseSelectContactUI.this.hideVKB();
            AppMethodBeat.o(102859);
          }
        });
        this.GWg.setCallBack(new MMTagPanel.a()
        {
          public final void B(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void Uk(String paramAnonymousString) {}
          
          public final void Ul(String paramAnonymousString)
          {
            AppMethodBeat.i(102860);
            MMBaseSelectContactUI.this.afM(paramAnonymousString);
            AppMethodBeat.o(102860);
          }
          
          public final void Um(String paramAnonymousString) {}
          
          public final void Un(String paramAnonymousString) {}
          
          public final void Uo(String paramAnonymousString) {}
          
          public final void bXc() {}
        });
      }
      return;
      label576:
      if (this.GVY != null)
      {
        this.GVY.setVisibility(8);
        this.GWa.setBackgroundColor(getResources().getColor(2131101179));
      }
      if (this.GUc != null) {
        this.GUc.setVisibility(8);
      }
      this.twW.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ad.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!g.afw())
    {
      ad.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      ad.eFx();
      finish();
      return;
    }
    VL();
    ad.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    initView();
    ad.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (aHt())
    {
      this.fvI.a(this, paramMenu);
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
    if (this.GVV != null) {
      this.GVV.Gdv = null;
    }
    if (this.GVW != null) {
      this.GVW.finish();
    }
    if (this.GVX != null) {
      this.GVX.finish();
    }
    if (this.GVZ != null) {
      this.GVZ.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt - getContentLV().getHeaderViewsCount();
    int j;
    if (i >= 0)
    {
      paramAdapterView = fbz().ZC(i);
      paramView = paramAdapterView.aHr();
      getContext();
      paramView.aHs();
      if (paramAdapterView.fWW)
      {
        i = paramAdapterView.rqF;
        j = paramAdapterView.rqG;
        if (!paramAdapterView.cxw()) {
          break label239;
        }
        i = 15;
        switch (paramAdapterView.rqF)
        {
        default: 
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (paramAdapterView.GZl) {
        j = 1;
      }
      if (paramAdapterView.nBH == 5) {
        j = 7;
      }
      paramAdapterView = String.format("%s,%d,%d,%d,%d", new Object[] { paramAdapterView.query, Integer.valueOf(paramAdapterView.scene), Integer.valueOf(j), Integer.valueOf(paramAdapterView.rqA), Integer.valueOf(i) });
      ad.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramAdapterView });
      h.vKh.kvStat(13234, paramAdapterView);
      if (!fbz().ZD(paramInt)) {
        pT(paramInt);
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
      cMR();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.GVZ != null) {
      this.GVZ.dismiss();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (aHt())
    {
      this.fvI.a(this, paramMenu);
      return super.onPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((cOv()) && (this.GWh))
    {
      this.GWh = false;
      g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102862);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, com.tencent.mm.plugin.label.a.a.cIS().cIN());
          MMBaseSelectContactUI.k(MMBaseSelectContactUI.this);
          aq.f(new Runnable()
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
  
  public void pT(int paramInt) {}
  
  public final void pb(String paramString)
  {
    ListAdapter localListAdapter2 = this.uOC.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof HeaderViewListAdapter)) {
      localListAdapter1 = ((HeaderViewListAdapter)localListAdapter2).getWrappedAdapter();
    }
    int i;
    if (localListAdapter1 == this.GVW) {
      i = this.GVW.aLn(paramString);
    }
    for (;;)
    {
      if (i == 0) {
        this.uOC.setSelection(0);
      }
      do
      {
        return;
        if (localListAdapter1 != this.GVX) {
          break label182;
        }
        i = this.GVX.aLn(paramString);
        break;
        if (i <= 0) {
          break label158;
        }
        if (aHt())
        {
          this.uOC.setSelection(i);
          return;
        }
      } while (this.twW == null);
      this.uOC.setSelectionFromTop(i, this.twW.getMeasuredHeight());
      ad.i("MicroMsg.MMBaseSelectContactUI", "Select head selectPosition=%d | header=%s | y=%d", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(this.twW.getMeasuredHeight()) });
      return;
      label158:
      ad.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
      return;
      label182:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI
 * JD-Core Version:    0.7.0.1
 */