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
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.tools.d;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.kernel.i
public abstract class MMBaseSelectContactUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, MultiSelectContactView.c, MultiSelectContactView.d, MultiSelectContactView.e, VerticalScrollBar.a, n, s.b
{
  private View Bnt;
  protected ListView Bvb;
  private View PUm;
  private AlphabetScrollBar PWj;
  private q PWk;
  public o PWl;
  private View PWm;
  private com.tencent.mm.ui.base.p PWn;
  private View PWo;
  private View PWp;
  private View PWq;
  private TextView PWr;
  public LabelContainerView PWs;
  private TextView PWt;
  private MMTagPanel PWu;
  private boolean PWv = true;
  private List<String> PWw = new ArrayList();
  boolean PWx = false;
  protected s gzP;
  public int scene;
  public MultiSelectContactView zoy;
  
  private void Cq(final boolean paramBoolean)
  {
    if (!this.PWx)
    {
      if (this.PWk == null) {
        this.PWk = bmC();
      }
      this.Bvb.setAdapter(this.PWk);
      return;
    }
    com.tencent.f.h.RTc.bqo("InitAdaperAsync_SelectUI");
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(219808);
        if (paramBoolean) {}
        for (;;)
        {
          Log.i("MicroMsg.MMBaseSelectContactUI", "createInitAdapterAnsync start, fromInit:%d", new Object[] { Integer.valueOf(i) });
          try
          {
            if (MMBaseSelectContactUI.m(MMBaseSelectContactUI.this) == null) {
              MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.bmC());
            }
            if (MMBaseSelectContactUI.this.Bvb != null) {
              MMBaseSelectContactUI.this.Bvb.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(219806);
                  if ((MMBaseSelectContactUI.this.Bvb != null) && (MMBaseSelectContactUI.m(MMBaseSelectContactUI.this) != null)) {
                    MMBaseSelectContactUI.this.Bvb.setAdapter(MMBaseSelectContactUI.m(MMBaseSelectContactUI.this));
                  }
                  AppMethodBeat.o(219806);
                }
              });
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.MMBaseSelectContactUI", localException, "createInitAdapterAnsync exception", new Object[0]);
            }
          }
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219807);
              if (MMBaseSelectContactUI.m(MMBaseSelectContactUI.this) != null) {
                MMBaseSelectContactUI.m(MMBaseSelectContactUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(219807);
            }
          });
          AppMethodBeat.o(219808);
          return;
          i = 0;
        }
      }
    }, "InitAdaperAsync_SelectUI");
  }
  
  private String gUT()
  {
    if (this.gzP != null) {
      return this.gzP.getSearchContent();
    }
    if (this.zoy != null) {
      return this.zoy.getSearchContent();
    }
    return "";
  }
  
  private void gUU()
  {
    boolean bool;
    if (this.gzP != null)
    {
      bool = this.gzP.gXp();
      if ((!bool) || (!Util.isNullOrNil(gUT()))) {
        break label102;
      }
      if ((this.PWw == null) || (this.PWw.size() <= 0)) {
        break label92;
      }
      this.PWs.setVisibility(0);
      this.PWu.a(null, this.PWw);
    }
    label92:
    label102:
    while (this.PWs == null)
    {
      return;
      if (this.zoy != null)
      {
        bool = this.zoy.hasFocus();
        break;
      }
      bool = false;
      break;
      this.PWs.setVisibility(8);
      return;
    }
    this.PWs.setVisibility(8);
  }
  
  private void gUV()
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.Bvb, 0);
    if (this.PWk != null)
    {
      this.Bvb.setAdapter(this.PWk);
      this.PWk.notifyDataSetChanged();
    }
    for (;;)
    {
      if ((bmA()) && (this.PWj != null)) {
        this.PWj.setVisibility(0);
      }
      this.PWq.setVisibility(8);
      return;
      Cq(false);
    }
  }
  
  public final void DP(String paramString)
  {
    ListAdapter localListAdapter2 = this.Bvb.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof HeaderViewListAdapter)) {
      localListAdapter1 = ((HeaderViewListAdapter)localListAdapter2).getWrappedAdapter();
    }
    int i;
    if ((localListAdapter1 == this.PWk) && (this.PWk != null)) {
      i = this.PWk.bnr(paramString);
    }
    for (;;)
    {
      if (i == 0) {
        this.Bvb.setSelection(0);
      }
      do
      {
        return;
        if (localListAdapter1 != this.PWl) {
          break label189;
        }
        i = this.PWl.bnr(paramString);
        break;
        if (i <= 0) {
          break label165;
        }
        if (bmz())
        {
          this.Bvb.setSelection(i);
          return;
        }
      } while (this.zoy == null);
      this.Bvb.setSelectionFromTop(i, this.zoy.getMeasuredHeight());
      Log.i("MicroMsg.MMBaseSelectContactUI", "Select head selectPosition=%d | header=%s | y=%d", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(this.zoy.getMeasuredHeight()) });
      return;
      label165:
      Log.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
      return;
      label189:
      i = 0;
    }
  }
  
  public void M(View paramView, int paramInt) {}
  
  public final boolean SN(String paramString)
  {
    return false;
  }
  
  public final void SO(String paramString)
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (eim())
    {
      if (this.gzP != null) {
        this.gzP.gXq();
      }
      gUU();
    }
    if (!Util.isNullOrNil(paramString))
    {
      this.PWl.b(paramString, egI());
      return;
    }
    this.PWl.clearData();
    this.PWl.notifyDataSetChanged();
    gUV();
  }
  
  public void T(int paramInt, String paramString) {}
  
  protected void a(ListView paramListView, int paramInt) {}
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  protected void aDT(String paramString)
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
  }
  
  protected void amZ()
  {
    this.scene = getIntent().getIntExtra("scene", 0);
  }
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void bey(String paramString)
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (eim()) {
      gUU();
    }
    if (this.PWl != null)
    {
      if (!Util.isNullOrNil(paramString)) {
        this.PWl.b(paramString, egI());
      }
    }
    else {
      return;
    }
    this.PWl.clearData();
    this.PWl.notifyDataSetChanged();
    gUV();
  }
  
  protected abstract boolean bmA();
  
  protected abstract String bmB();
  
  protected abstract q bmC();
  
  protected abstract o bmD();
  
  protected abstract boolean bmz();
  
  public final void bnA()
  {
    if (this.PUm != null) {
      this.PUm.setVisibility(0);
    }
  }
  
  public final void bnB() {}
  
  public final void bny()
  {
    gUV();
    if (eim()) {
      gUU();
    }
    if (bmz())
    {
      this.PWm.setVisibility(0);
      this.PWo.setBackgroundColor(getResources().getColor(2131099689));
      this.PUm.setVisibility(8);
      this.PWo.setVisibility(0);
    }
  }
  
  public final void bnz() {}
  
  public int[] egI()
  {
    return new int[] { 131072, 131075, 131081 };
  }
  
  public void egJ()
  {
    hideVKB();
    finish();
  }
  
  protected boolean eim()
  {
    return false;
  }
  
  public p gUP()
  {
    if (getContentLV().getHeaderViewsCount() > 0)
    {
      if ((getContentLV().getAdapter() instanceof HeaderViewListAdapter))
      {
        HeaderViewListAdapter localHeaderViewListAdapter = (HeaderViewListAdapter)getContentLV().getAdapter();
        if ((localHeaderViewListAdapter.getWrappedAdapter() instanceof p)) {
          return (p)localHeaderViewListAdapter.getWrappedAdapter();
        }
      }
      return null;
    }
    if ((getContentLV().getAdapter() instanceof p)) {
      return (p)getContentLV().getAdapter();
    }
    return null;
  }
  
  public q gUQ()
  {
    return this.PWk;
  }
  
  public final void gUR()
  {
    if (this.PWm != null)
    {
      this.PWm.setVisibility(0);
      this.PWo.setBackgroundColor(getResources().getColor(2131099689));
    }
  }
  
  public final void gUS()
  {
    if (this.PWm != null)
    {
      this.PWm.setVisibility(8);
      this.PWo.setBackgroundColor(getResources().getColor(2131101424));
    }
  }
  
  public final void gUW()
  {
    if ((this.gzP != null) && (!Util.isNullOrNil(this.gzP.getSearchContent())))
    {
      s locals = this.gzP;
      if (locals.Qwh != null) {
        locals.Qwh.CH(true);
      }
    }
    if ((this.zoy != null) && (!Util.isNullOrNil(this.zoy.getSearchContent()))) {
      this.zoy.getInputText().setText("");
    }
  }
  
  protected final void gUX()
  {
    if (this.gzP != null) {
      if (this.gzP.gXp()) {
        this.gzP.clearFocus();
      }
    }
    while ((this.zoy == null) || (!this.zoy.hasFocus())) {
      return;
    }
    this.zoy.clearFocus();
  }
  
  public boolean gUY()
  {
    return this.PWl != null;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.Bvb;
  }
  
  public int getLayoutId()
  {
    return 2131495637;
  }
  
  public final void goT()
  {
    if (eim()) {
      gUU();
    }
  }
  
  public void initView()
  {
    setMMTitle(bmB());
    this.PWm = findViewById(2131309327);
    this.PUm = findViewById(2131309324);
    this.Bvb = ((ListView)findViewById(2131307514));
    Cq(true);
    this.PWl = bmD();
    this.Bnt = findViewById(2131307726);
    if (gUY())
    {
      this.PWq = findViewById(2131305462);
      this.PWr = ((TextView)findViewById(2131305461));
      this.PWq.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102851);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
          MMBaseSelectContactUI.this.gUW();
          MMBaseSelectContactUI.this.gUX();
          AppMethodBeat.o(102851);
          return false;
        }
      });
      this.zoy = ((MultiSelectContactView)findViewById(2131299114));
      this.zoy.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, -2147483648));
      this.zoy.setOnSearchTextChangeListener(this);
      this.zoy.setOnSearchTextFouceChangeListener(this);
      this.zoy.setOnContactDeselectListener(this);
      this.PWp = LayoutInflater.from(this).inflate(2131493717, null);
      this.PWo = this.PWp.findViewById(2131302272);
      this.Bvb.addHeaderView(this.PWp);
      if (!bmz()) {
        break label562;
      }
      hideActionbarLine();
      if (this.zoy != null) {
        this.zoy.setVisibility(8);
      }
      this.PWm.setVisibility(0);
      this.PWo.setBackgroundColor(getResources().getColor(2131099689));
      this.PUm.setVisibility(8);
      this.gzP = new s((byte)0);
      this.gzP.Qwi = this;
      this.PWm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(102852);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.d("MicroMsg.MMBaseSelectContactUI", "dancy test topSearchView onClick!!");
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).CK(true);
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(102852);
        }
      });
      this.PUm.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102853);
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).gXP();
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
      a(this.Bvb, 0);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(102854);
          MMBaseSelectContactUI.this.egJ();
          AppMethodBeat.o(102854);
          return true;
        }
      });
      if (this.PWl != null) {
        this.PWl.a(new o.a()
        {
          public final void B(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(102855);
            Log.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (MMBaseSelectContactUI.d(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(8);
            }
            if ((paramAnonymousBoolean) && (paramAnonymousInt == 0))
            {
              if (!Util.isNullOrNil(paramAnonymousString))
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
      this.Bvb.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102857);
          if ((!MMBaseSelectContactUI.this.bmz()) && (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null))
          {
            paramAnonymousAbsListView = MMBaseSelectContactUI.this.Bvb.getChildAt(MMBaseSelectContactUI.this.Bvb.getFirstVisiblePosition());
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
          g.aAi();
          if (!Util.nullAsFalse((Boolean)g.aAh().azQ().get(12296, null)))
          {
            g.aAi();
            g.aAh().azQ().set(12296, Boolean.TRUE);
            if (MMBaseSelectContactUI.j(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.j(MMBaseSelectContactUI.this).dismiss();
            }
            MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, u.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.getString(2131762862), 4000L));
          }
          AppMethodBeat.o(102857);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(102856);
          if (paramAnonymousInt != 0)
          {
            MMBaseSelectContactUI.this.hideVKB();
            MMBaseSelectContactUI.this.gUX();
          }
          AppMethodBeat.o(102856);
        }
      });
      this.Bvb.setOnItemClickListener(this);
      if (bmA())
      {
        this.PWj = ((AlphabetScrollBar)findViewById(2131307516));
        this.PWj.setVisibility(0);
        this.PWj.setOnScrollBarTouchListener(this);
      }
      if (eim())
      {
        this.PWs = ((LabelContainerView)findViewById(2131307513));
        this.PWt = ((TextView)this.PWs.findViewById(16908310));
        this.PWt.setText(2131765116);
        this.PWu = ((MMTagPanel)this.PWs.findViewById(2131299109));
        this.PWu.setTagSelectedBG(2131235181);
        this.PWu.setTagSelectedTextColorRes(2131100904);
        this.PWs.setOnLabelContainerListener(new LabelContainerView.a()
        {
          public final void cIi()
          {
            AppMethodBeat.i(102858);
            if (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.h(MMBaseSelectContactUI.this).clearFocus();
            }
            if (MMBaseSelectContactUI.b(MMBaseSelectContactUI.this) != null)
            {
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).clearFocus();
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).gXP();
            }
            MMBaseSelectContactUI.this.PWs.requestFocus();
            MMBaseSelectContactUI.this.PWs.setVisibility(8);
            AppMethodBeat.o(102858);
          }
          
          public final void cIj()
          {
            AppMethodBeat.i(102859);
            MMBaseSelectContactUI.this.hideVKB();
            AppMethodBeat.o(102859);
          }
        });
        this.PWu.setCallBack(new MMTagPanel.a()
        {
          public final void E(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void anb(String paramAnonymousString) {}
          
          public final void anc(String paramAnonymousString)
          {
            AppMethodBeat.i(102860);
            MMBaseSelectContactUI.this.aDT(paramAnonymousString);
            AppMethodBeat.o(102860);
          }
          
          public final void and(String paramAnonymousString) {}
          
          public final void ane(String paramAnonymousString) {}
          
          public final void anf(String paramAnonymousString) {}
          
          public final void cIk() {}
        });
      }
      return;
      label562:
      if (this.PWm != null)
      {
        this.PWm.setVisibility(8);
        this.PWo.setBackgroundColor(getResources().getColor(2131101424));
      }
      if (this.PUm != null) {
        this.PUm.setVisibility(8);
      }
      this.zoy.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!g.aAc())
    {
      Log.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      Log.appenderFlushSync();
      finish();
      return;
    }
    amZ();
    Log.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    initView();
    Log.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (bmz())
    {
      this.gzP.a(this, paramMenu);
      if (paramMenu != null)
      {
        int i = 0;
        while (i < paramMenu.size())
        {
          MenuItem localMenuItem = paramMenu.getItem(i);
          if (localMenuItem.getItemId() == 2131304628) {
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
    if (this.PWj != null) {
      this.PWj.OWL = null;
    }
    if (this.PWk != null) {
      this.PWk.finish();
    }
    if (this.PWl != null) {
      this.PWl.finish();
    }
    if (this.PWn != null) {
      this.PWn.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    int i = paramInt - getContentLV().getHeaderViewsCount();
    int j;
    if (i >= 0)
    {
      paramAdapterView = gUP().anH(i);
      localObject = paramAdapterView.bmx();
      getContext();
      ((a.b)localObject).bmy();
      if (paramAdapterView.hkH)
      {
        i = paramAdapterView.wXQ;
        j = paramAdapterView.wXR;
        if (!paramAdapterView.dOL()) {
          break label313;
        }
        i = 15;
        j = 0;
        switch (paramAdapterView.wXQ)
        {
        }
      }
    }
    for (;;)
    {
      if (paramAdapterView.Qad) {
        j = 1;
      }
      if (paramAdapterView.qcr == 5) {
        j = 7;
      }
      paramAdapterView = String.format("%s,%d,%d,%d,%d", new Object[] { paramAdapterView.query, Integer.valueOf(paramAdapterView.scene), Integer.valueOf(j), Integer.valueOf(paramAdapterView.wXL), Integer.valueOf(i) });
      Log.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramAdapterView });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(13234, paramAdapterView);
      if (!gUP().anI(paramInt)) {
        M(paramView, paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
      label313:
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
      egJ();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.PWn != null) {
      this.PWn.dismiss();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (bmz())
    {
      this.gzP.a(this, paramMenu);
      return super.onPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((eim()) && (this.PWv))
    {
      this.PWv = false;
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102862);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, com.tencent.mm.plugin.label.a.a.ecg().ecb());
          MMBaseSelectContactUI.k(MMBaseSelectContactUI.this);
          MMHandlerThread.postToMainThread(new Runnable()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI
 * JD-Core Version:    0.7.0.1
 */