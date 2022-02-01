package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
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
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.t.b;
import java.util.ArrayList;
import java.util.List;

@k
public abstract class MMBaseSelectContactUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, MultiSelectContactView.c, MultiSelectContactView.d, MultiSelectContactView.e, VerticalScrollBar.a, o, t.b
{
  public MultiSelectContactView ETP;
  private View HhP;
  protected ListView Hpw;
  private View XqX;
  protected AlphabetScrollBar XsZ;
  private r Xta;
  public p Xtb;
  private View Xtc;
  private com.tencent.mm.ui.base.r Xtd;
  private View Xte;
  private View Xtf;
  private View Xtg;
  private TextView Xth;
  public LabelContainerView Xti;
  private TextView Xtj;
  private MMTagPanel Xtk;
  private boolean Xtl = true;
  private List<String> Xtm = new ArrayList();
  private boolean Xtn = false;
  private t jjS;
  public int scene;
  
  private void GM(final boolean paramBoolean)
  {
    if (!this.Xtn)
    {
      if (this.Xta == null) {
        this.Xta = bwK();
      }
      this.Hpw.setAdapter(this.Xta);
      return;
    }
    com.tencent.e.h.ZvG.bDh("InitAdaperAsync_SelectUI");
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(187389);
        if (paramBoolean) {}
        for (;;)
        {
          Log.i("MicroMsg.MMBaseSelectContactUI", "createInitAdapterAnsync start, fromInit:%d", new Object[] { Integer.valueOf(i) });
          try
          {
            if (MMBaseSelectContactUI.m(MMBaseSelectContactUI.this) == null) {
              MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.bwK());
            }
            if (MMBaseSelectContactUI.this.Hpw != null) {
              MMBaseSelectContactUI.this.Hpw.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(187267);
                  if ((MMBaseSelectContactUI.this.Hpw != null) && (MMBaseSelectContactUI.m(MMBaseSelectContactUI.this) != null)) {
                    MMBaseSelectContactUI.this.Hpw.setAdapter(MMBaseSelectContactUI.m(MMBaseSelectContactUI.this));
                  }
                  AppMethodBeat.o(187267);
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
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187442);
              if ((MMBaseSelectContactUI.this.Hpw != null) && (MMBaseSelectContactUI.m(MMBaseSelectContactUI.this) != null)) {
                MMBaseSelectContactUI.this.Hpw.setAdapter(MMBaseSelectContactUI.m(MMBaseSelectContactUI.this));
              }
              if (MMBaseSelectContactUI.m(MMBaseSelectContactUI.this) != null) {
                MMBaseSelectContactUI.m(MMBaseSelectContactUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(187442);
            }
          });
          AppMethodBeat.o(187389);
          return;
          i = 0;
        }
      }
    }, "InitAdaperAsync_SelectUI");
  }
  
  private String hUW()
  {
    if (this.jjS != null) {
      return this.jjS.getSearchContent();
    }
    if (this.ETP != null) {
      return this.ETP.getSearchContent();
    }
    return "";
  }
  
  private void hUX()
  {
    boolean bool;
    if (this.jjS != null)
    {
      bool = this.jjS.hYb();
      if ((!bool) || (!Util.isNullOrNil(hUW()))) {
        break label102;
      }
      if ((this.Xtm == null) || (this.Xtm.size() <= 0)) {
        break label92;
      }
      this.Xti.setVisibility(0);
      this.Xtk.a(null, this.Xtm);
    }
    label92:
    label102:
    while (this.Xti == null)
    {
      return;
      if (this.ETP != null)
      {
        bool = this.ETP.hasFocus();
        break;
      }
      bool = false;
      break;
      this.Xti.setVisibility(8);
      return;
    }
    this.Xti.setVisibility(8);
  }
  
  private void hUY()
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.Hpw, 0);
    if (this.Xta != null)
    {
      this.Hpw.setAdapter(this.Xta);
      this.Xta.notifyDataSetChanged();
    }
    for (;;)
    {
      if ((bwI()) && (this.XsZ != null)) {
        this.XsZ.setVisibility(0);
      }
      this.Xtg.setVisibility(8);
      return;
      GM(false);
    }
  }
  
  public final void KH(String paramString)
  {
    ListAdapter localListAdapter2 = this.Hpw.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof HeaderViewListAdapter)) {
      localListAdapter1 = ((HeaderViewListAdapter)localListAdapter2).getWrappedAdapter();
    }
    int i;
    if ((localListAdapter1 == this.Xta) && (this.Xta != null)) {
      i = this.Xta.bzR(paramString);
    }
    for (;;)
    {
      if (i == 0) {
        this.Hpw.setSelection(0);
      }
      do
      {
        return;
        if (localListAdapter1 != this.Xtb) {
          break label189;
        }
        i = this.Xtb.bzR(paramString);
        break;
        if (i <= 0) {
          break label165;
        }
        if (bwH())
        {
          this.Hpw.setSelection(i);
          return;
        }
      } while (this.ETP == null);
      this.Hpw.setSelectionFromTop(i, this.ETP.getMeasuredHeight());
      Log.i("MicroMsg.MMBaseSelectContactUI", "Select head selectPosition=%d | header=%s | y=%d", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(this.ETP.getMeasuredHeight()) });
      return;
      label165:
      Log.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
      return;
      label189:
      i = 0;
    }
  }
  
  public void N(View paramView, int paramInt) {}
  
  public void V(int paramInt, String paramString) {}
  
  protected void a(ListView paramListView, int paramInt) {}
  
  protected final void a(r paramr)
  {
    this.Xta = paramr;
    if (this.Xta != null) {
      this.Hpw.setAdapter(this.Xta);
    }
  }
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  protected void aOd(String paramString)
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
  }
  
  public final boolean aat(String paramString)
  {
    return false;
  }
  
  public final void aau(String paramString)
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (eRT())
    {
      if (this.jjS != null) {
        this.jjS.hYc();
      }
      hUX();
    }
    if (!Util.isNullOrNil(paramString))
    {
      this.Xtb.a(paramString, dvA());
      return;
    }
    this.Xtb.clearData();
    this.Xtb.notifyDataSetChanged();
    hUY();
  }
  
  protected void ata()
  {
    this.scene = getIntent().getIntExtra("scene", 0);
  }
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void bqU(String paramString)
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (eRT()) {
      hUX();
    }
    if (this.Xtb != null)
    {
      if (!Util.isNullOrNil(paramString)) {
        this.Xtb.a(paramString, dvA());
      }
    }
    else {
      return;
    }
    this.Xtb.clearData();
    this.Xtb.notifyDataSetChanged();
    hUY();
  }
  
  protected abstract boolean bwH();
  
  protected abstract boolean bwI();
  
  protected abstract String bwJ();
  
  protected abstract r bwK();
  
  protected abstract p bwL();
  
  public final void bxH()
  {
    hUY();
    if (eRT()) {
      hUX();
    }
    if (bwH())
    {
      this.Xtc.setVisibility(0);
      this.Xte.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_93));
      this.XqX.setVisibility(8);
      this.Xte.setVisibility(0);
    }
  }
  
  public final void bxI() {}
  
  public final void bxJ()
  {
    if (this.XqX != null) {
      this.XqX.setVisibility(0);
    }
  }
  
  public final void bxK() {}
  
  public int[] dvA()
  {
    return new int[] { 131072, 131075, 131081 };
  }
  
  public void eQp()
  {
    hideVKB();
    finish();
  }
  
  protected boolean eRT()
  {
    return false;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.Hpw;
  }
  
  public int getLayoutId()
  {
    return a.f.mm_select_contact_ui;
  }
  
  public q hUP()
  {
    if (getContentLV().getHeaderViewsCount() > 0)
    {
      if ((getContentLV().getAdapter() instanceof HeaderViewListAdapter))
      {
        HeaderViewListAdapter localHeaderViewListAdapter = (HeaderViewListAdapter)getContentLV().getAdapter();
        if ((localHeaderViewListAdapter.getWrappedAdapter() instanceof q)) {
          return (q)localHeaderViewListAdapter.getWrappedAdapter();
        }
      }
      return null;
    }
    if ((getContentLV().getAdapter() instanceof q)) {
      return (q)getContentLV().getAdapter();
    }
    return null;
  }
  
  public r hUQ()
  {
    return this.Xta;
  }
  
  public final MultiSelectContactView hUR()
  {
    return this.ETP;
  }
  
  public final void hUS()
  {
    if (this.Xtc != null)
    {
      this.Xtc.setVisibility(0);
      this.Xte.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_93));
    }
  }
  
  public final void hUT()
  {
    if (this.Xtc != null)
    {
      this.Xtc.setVisibility(8);
      this.Xte.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.white));
    }
  }
  
  public final void hUU()
  {
    if (this.ETP != null) {
      this.ETP.hjD();
    }
  }
  
  public final void hUV()
  {
    if (this.ETP != null) {
      this.ETP.hjE();
    }
  }
  
  public final void hUZ()
  {
    if ((this.jjS != null) && (!Util.isNullOrNil(this.jjS.getSearchContent())))
    {
      t localt = this.jjS;
      if (localt.XUk != null) {
        localt.XUk.Hb(true);
      }
    }
    if ((this.ETP != null) && (!Util.isNullOrNil(this.ETP.getSearchContent()))) {
      this.ETP.getInputText().setText("");
    }
  }
  
  protected final void hVa()
  {
    if (this.jjS != null) {
      if (this.jjS.hYb()) {
        this.jjS.clearFocus();
      }
    }
    while ((this.ETP == null) || (!this.ETP.hasFocus())) {
      return;
    }
    this.ETP.clearFocus();
  }
  
  protected final void hVb()
  {
    if (this.jjS != null)
    {
      this.jjS.clearFocus();
      this.jjS.hVb();
    }
  }
  
  public boolean hVc()
  {
    return this.Xtb != null;
  }
  
  public final t hVd()
  {
    return this.jjS;
  }
  
  public final void hjI()
  {
    if (eRT()) {
      hUX();
    }
  }
  
  public void initView()
  {
    setMMTitle(bwJ());
    this.Xtc = findViewById(a.e.top_search_view);
    this.XqX = findViewById(a.e.top_mask);
    this.Hpw = ((ListView)findViewById(a.e.select_contact_lv));
    GM(true);
    this.Xtb = bwL();
    this.HhP = findViewById(a.e.shadow);
    if (hVc())
    {
      this.Xtg = findViewById(a.e.no_result_view);
      this.Xth = ((TextView)findViewById(a.e.no_result_tv));
      this.Xtg.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102851);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
          MMBaseSelectContactUI.this.hUZ();
          MMBaseSelectContactUI.this.hVa();
          AppMethodBeat.o(102851);
          return false;
        }
      });
      this.ETP = ((MultiSelectContactView)findViewById(a.e.contact_multiselect));
      this.ETP.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, -2147483648));
      this.ETP.setOnSearchTextChangeListener(this);
      this.ETP.setOnSearchTextFouceChangeListener(this);
      this.ETP.setOnContactDeselectListener(this);
      this.Xtf = LayoutInflater.from(this).inflate(a.f.contact_header, null);
      this.Xte = this.Xtf.findViewById(a.e.header);
      this.Hpw.addHeaderView(this.Xtf);
      if (!bwH()) {
        break label579;
      }
      hideActionbarLine();
      if (this.ETP != null) {
        this.ETP.setVisibility(8);
      }
      this.Xtc.setVisibility(0);
      this.Xte.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_93));
      this.XqX.setVisibility(8);
      this.jjS = new t((byte)0);
      this.jjS.XUl = this;
      this.jjS.XUs = true;
      this.Xtc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(102852);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.MMBaseSelectContactUI", "dancy test topSearchView onClick!!");
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).He(true);
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(102852);
        }
      });
      this.XqX.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102853);
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).hVb();
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).setVisibility(0);
          AppMethodBeat.o(102853);
          return true;
        }
      });
      addSearchMenu(true, this.jjS);
    }
    for (;;)
    {
      a(this.Hpw, 0);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(102854);
          MMBaseSelectContactUI.this.eQp();
          AppMethodBeat.o(102854);
          return true;
        }
      });
      if (this.Xtb != null) {
        this.Xtb.a(new p.a()
        {
          public final void g(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
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
      this.Hpw.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102857);
          if ((!MMBaseSelectContactUI.this.bwH()) && (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null))
          {
            paramAnonymousAbsListView = MMBaseSelectContactUI.this.Hpw.getChildAt(MMBaseSelectContactUI.this.Hpw.getFirstVisiblePosition());
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
          com.tencent.mm.kernel.h.aHH();
          if (!Util.nullAsFalse((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(12296, null)))
          {
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHG().aHp().i(12296, Boolean.TRUE);
            if (MMBaseSelectContactUI.j(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.j(MMBaseSelectContactUI.this).dismiss();
            }
            MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, w.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.getString(a.h.main_slide_toast), 4000L));
          }
          AppMethodBeat.o(102857);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(102856);
          if (paramAnonymousInt != 0)
          {
            MMBaseSelectContactUI.this.hideVKB();
            MMBaseSelectContactUI.this.hVa();
          }
          AppMethodBeat.o(102856);
        }
      });
      this.Hpw.setOnItemClickListener(this);
      if (bwI())
      {
        this.XsZ = ((AlphabetScrollBar)findViewById(a.e.select_contact_scrollbar));
        this.XsZ.setVisibility(0);
        this.XsZ.setOnScrollBarTouchListener(this);
      }
      if (eRT())
      {
        this.Xti = ((LabelContainerView)findViewById(a.e.select_contact_label_container));
        this.Xtj = ((TextView)this.Xti.findViewById(16908310));
        this.Xtj.setText(a.h.select_contact_by_label_panel);
        this.Xtk = ((MMTagPanel)this.Xti.findViewById(a.e.contact_label_panel));
        this.Xtk.setTagSelectedBG(a.d.tag_white_tab_selector);
        this.Xtk.setTagSelectedTextColorRes(com.tencent.mm.plugin.selectcontact.a.b.normal_text_color);
        this.Xti.setOnLabelContainerListener(new LabelContainerView.a()
        {
          public final void cWP()
          {
            AppMethodBeat.i(102858);
            if (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.h(MMBaseSelectContactUI.this).clearFocus();
            }
            if (MMBaseSelectContactUI.b(MMBaseSelectContactUI.this) != null)
            {
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).clearFocus();
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).hVb();
            }
            MMBaseSelectContactUI.this.Xti.requestFocus();
            MMBaseSelectContactUI.this.Xti.setVisibility(8);
            AppMethodBeat.o(102858);
          }
          
          public final void cWQ()
          {
            AppMethodBeat.i(102859);
            MMBaseSelectContactUI.this.hideVKB();
            AppMethodBeat.o(102859);
          }
        });
        this.Xtk.setCallBack(new MMTagPanel.a()
        {
          public final void I(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void auV(String paramAnonymousString) {}
          
          public final void auW(String paramAnonymousString)
          {
            AppMethodBeat.i(102860);
            MMBaseSelectContactUI.this.aOd(paramAnonymousString);
            AppMethodBeat.o(102860);
          }
          
          public final void auX(String paramAnonymousString) {}
          
          public final void auY(String paramAnonymousString) {}
          
          public final void auZ(String paramAnonymousString) {}
          
          public final void cWR() {}
        });
      }
      return;
      label579:
      if (this.Xtc != null)
      {
        this.Xtc.setVisibility(8);
        this.Xte.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.white));
      }
      if (this.XqX != null) {
        this.XqX.setVisibility(8);
      }
      this.ETP.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      Log.appenderFlushSync();
      finish();
      return;
    }
    ata();
    Log.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    initView();
    Log.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.XsZ != null) {
      this.XsZ.WpX = null;
    }
    if (this.Xta != null) {
      this.Xta.finish();
    }
    if (this.Xtb != null) {
      this.Xtb.finish();
    }
    if (this.Xtd != null) {
      this.Xtd.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    int i = paramInt - getContentLV().getHeaderViewsCount();
    boolean bool1 = false;
    int j;
    if (i >= 0)
    {
      paramAdapterView = hUP().awM(i);
      bool1 = paramAdapterView.bwF().a(getContext(), paramView, paramAdapterView);
      if (paramAdapterView.jWq)
      {
        i = paramAdapterView.BJM;
        j = paramAdapterView.BJN;
        if (!paramAdapterView.ere()) {
          break label330;
        }
        i = 15;
        j = 0;
        switch (paramAdapterView.BJM)
        {
        }
      }
    }
    for (;;)
    {
      if (paramAdapterView.Xxv) {
        j = 1;
      }
      if (paramAdapterView.viewType == 5) {
        j = 7;
      }
      paramAdapterView = String.format("%s,%d,%d,%d,%d", new Object[] { paramAdapterView.query, Integer.valueOf(paramAdapterView.scene), Integer.valueOf(j), Integer.valueOf(paramAdapterView.BJH), Integer.valueOf(i) });
      Log.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramAdapterView });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(13234, paramAdapterView);
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = hUP().awN(paramInt);
      }
      if (!bool2) {
        N(paramView, paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
      label330:
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
      eQp();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.Xtd != null) {
      this.Xtd.dismiss();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((eRT()) && (this.Xtl))
    {
      this.Xtl = false;
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102862);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, com.tencent.mm.plugin.label.a.a.eLe().eKZ());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI
 * JD-Core Version:    0.7.0.1
 */