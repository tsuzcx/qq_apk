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
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@k
public abstract class MMBaseSelectContactUI
  extends MMSecDataActivity
  implements AdapterView.OnItemClickListener, MultiSelectContactView.c, MultiSelectContactView.d, MultiSelectContactView.e, VerticalScrollBar.a, o, s.c
{
  private View DGv;
  public MultiSelectContactView KOt;
  private View NfI;
  public ListView Nnk;
  protected AlphabetScrollBar afeA;
  private r afeB;
  public p afeC;
  public View afeD;
  private v afeE;
  public View afeF;
  private View afeG;
  private View afeH;
  private TextView afeI;
  private TextView afeJ;
  private boolean afeK;
  public LabelContainerView afeL;
  private TextView afeM;
  private MMTagPanel afeN;
  private boolean afeO = true;
  private List<String> afeP = new ArrayList();
  private boolean afeQ = false;
  private HashSet<String> afeR = new HashSet();
  private s lMw;
  public int scene;
  
  private void MA(final boolean paramBoolean)
  {
    if (!this.afeQ)
    {
      if (this.afeB == null) {
        this.afeB = bVA();
      }
      this.Nnk.setAdapter(this.afeB);
      return;
    }
    com.tencent.threadpool.h.ahAA.bFQ("InitAdaperAsync_SelectUI");
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(253038);
        if (paramBoolean) {}
        for (;;)
        {
          Log.i("MicroMsg.MMBaseSelectContactUI", "createInitAdapterAnsync start, fromInit:%d", new Object[] { Integer.valueOf(i) });
          try
          {
            if (MMBaseSelectContactUI.j(MMBaseSelectContactUI.this) == null) {
              MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.bVA());
            }
            if (MMBaseSelectContactUI.this.Nnk != null) {
              MMBaseSelectContactUI.this.Nnk.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(252916);
                  if ((MMBaseSelectContactUI.this.Nnk != null) && (MMBaseSelectContactUI.j(MMBaseSelectContactUI.this) != null)) {
                    MMBaseSelectContactUI.this.Nnk.setAdapter(MMBaseSelectContactUI.j(MMBaseSelectContactUI.this));
                  }
                  AppMethodBeat.o(252916);
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
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(252915);
              if ((MMBaseSelectContactUI.this.Nnk != null) && (MMBaseSelectContactUI.j(MMBaseSelectContactUI.this) != null)) {
                MMBaseSelectContactUI.this.Nnk.setAdapter(MMBaseSelectContactUI.j(MMBaseSelectContactUI.this));
              }
              if (MMBaseSelectContactUI.j(MMBaseSelectContactUI.this) != null) {
                MMBaseSelectContactUI.j(MMBaseSelectContactUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(252915);
            }
          });
          AppMethodBeat.o(253038);
          return;
          i = 0;
        }
      }
    }, "InitAdaperAsync_SelectUI");
  }
  
  private String jyK()
  {
    if (this.lMw != null) {
      return this.lMw.getSearchContent();
    }
    if (this.KOt != null) {
      return this.KOt.getSearchContent();
    }
    return "";
  }
  
  private void jyL()
  {
    boolean bool;
    if (this.lMw != null)
    {
      bool = this.lMw.jCL();
      if ((!bool) || (!Util.isNullOrNil(jyK()))) {
        break label102;
      }
      if ((this.afeP == null) || (this.afeP.size() <= 0)) {
        break label92;
      }
      this.afeL.setVisibility(0);
      this.afeN.a(null, this.afeP);
    }
    label92:
    label102:
    while (this.afeL == null)
    {
      return;
      if (this.KOt != null)
      {
        bool = this.KOt.hasFocus();
        break;
      }
      bool = false;
      break;
      this.afeL.setVisibility(8);
      return;
    }
    this.afeL.setVisibility(8);
  }
  
  private void jyM()
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.Nnk, 0);
    if (this.afeB != null)
    {
      this.Nnk.setAdapter(this.afeB);
      this.afeB.notifyDataSetChanged();
    }
    for (;;)
    {
      if ((bVy()) && (this.afeA != null)) {
        this.afeA.setVisibility(0);
      }
      this.afeH.setVisibility(8);
      this.Nnk.setVisibility(0);
      return;
      MA(false);
    }
  }
  
  public final void JC(boolean paramBoolean)
  {
    if (gaC()) {
      jyL();
    }
  }
  
  public final boolean SN(String paramString)
  {
    return false;
  }
  
  public final void SO(String paramString)
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (gaC())
    {
      if (this.lMw != null) {
        this.lMw.jCM();
      }
      jyL();
    }
    if (!Util.isNullOrNil(paramString))
    {
      this.afeC.a(paramString, efu());
      return;
    }
    this.afeC.clearData();
    this.afeC.notifyDataSetChanged();
    jyM();
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  protected void a(ListView paramListView, int paramInt) {}
  
  protected final void a(r paramr)
  {
    this.afeB = paramr;
    if (this.afeB != null) {
      this.Nnk.setAdapter(this.afeB);
    }
  }
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  protected void aLa(String paramString)
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
  }
  
  protected void aNi()
  {
    this.scene = getIntent().getIntExtra("scene", 0);
  }
  
  public void ad(int paramInt, String paramString) {}
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  protected abstract r bVA();
  
  protected abstract p bVB();
  
  protected abstract boolean bVx();
  
  protected abstract boolean bVy();
  
  protected abstract String bVz();
  
  public final void bWw()
  {
    jyM();
    if (gaC()) {
      jyL();
    }
    if (bVx())
    {
      this.afeD.setVisibility(0);
      this.afeF.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_93));
      this.DGv.setVisibility(8);
      this.afeF.setVisibility(0);
      this.Nnk.setVisibility(0);
    }
  }
  
  public final void bWx() {}
  
  public final void bWy()
  {
    if (this.DGv != null) {
      this.DGv.setVisibility(0);
    }
  }
  
  public final void bWz() {}
  
  public final void bqJ(String paramString)
  {
    Log.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (gaC()) {
      jyL();
    }
    if (this.afeC != null)
    {
      if (!Util.isNullOrNil(paramString)) {
        this.afeC.a(paramString, efu());
      }
    }
    else {
      return;
    }
    this.afeC.clearData();
    this.afeC.notifyDataSetChanged();
    jyM();
  }
  
  public String c(com.tencent.mm.ui.contact.a.a parama)
  {
    return null;
  }
  
  public int[] efu()
  {
    return new int[] { 131072, 131075, 131081 };
  }
  
  public void fYZ()
  {
    hideVKB();
    finish();
  }
  
  protected boolean gaC()
  {
    return false;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.Nnk;
  }
  
  public int getLayoutId()
  {
    return a.f.mm_select_contact_ui;
  }
  
  public final void iKA()
  {
    if ((this.lMw != null) && (!Util.isNullOrNil(this.lMw.getSearchContent())))
    {
      s locals = this.lMw;
      if (locals.afKy != null) {
        locals.afKy.MW(true);
      }
    }
    if ((this.KOt != null) && (!Util.isNullOrNil(this.KOt.getSearchContent()))) {
      this.KOt.iKA();
    }
  }
  
  public void initView()
  {
    setMMTitle(bVz());
    this.afeD = findViewById(a.e.top_search_view);
    this.DGv = findViewById(a.e.top_mask);
    this.Nnk = ((ListView)findViewById(a.e.select_contact_lv));
    this.Nnk.setVisibility(0);
    MA(true);
    this.afeC = bVB();
    this.NfI = findViewById(a.e.shadow);
    if (jyP())
    {
      this.afeH = findViewById(a.e.no_result_view);
      this.afeH.setTag(a.e.tag_multi_talk_status_search_result, Boolean.valueOf(this.afeK));
      this.afeI = ((TextView)findViewById(a.e.no_result_tv));
      this.afeJ = ((TextView)findViewById(a.e.no_result_tv_tip));
      this.afeH.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102851);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
          MMBaseSelectContactUI.this.iKA();
          MMBaseSelectContactUI.this.jyN();
          AppMethodBeat.o(102851);
          return false;
        }
      });
      this.KOt = ((MultiSelectContactView)findViewById(a.e.contact_multiselect));
      this.KOt.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, -2147483648));
      this.KOt.setOnSearchTextChangeListener(this);
      this.KOt.setOnSearchTextFouceChangeListener(this);
      this.KOt.setOnContactDeselectListener(this);
      this.afeG = LayoutInflater.from(this).inflate(a.f.contact_header, null);
      this.afeF = this.afeG.findViewById(a.e.header);
      this.Nnk.addHeaderView(this.afeG);
      if (!bVx()) {
        break label618;
      }
      hideActionbarLine();
      if (this.KOt != null) {
        this.KOt.setVisibility(8);
      }
      this.afeD.setVisibility(0);
      this.afeF.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_93));
      this.DGv.setVisibility(8);
      this.lMw = new s(true);
      this.lMw.afKz = this;
      this.lMw.afKG = true;
      this.afeD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(102852);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.d("MicroMsg.MMBaseSelectContactUI", "dancy test topSearchView onClick!!");
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).MY(true);
          MMBaseSelectContactUI.this.afeD.setVisibility(8);
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.this.afeF.setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(102852);
        }
      });
      this.DGv.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102853);
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).jyO();
          MMBaseSelectContactUI.this.afeD.setVisibility(0);
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.this.afeF.setVisibility(0);
          AppMethodBeat.o(102853);
          return true;
        }
      });
      addSearchMenu(true, this.lMw);
    }
    for (;;)
    {
      a(this.Nnk, 0);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(102854);
          MMBaseSelectContactUI.this.fYZ();
          AppMethodBeat.o(102854);
          return true;
        }
      });
      if (this.afeC != null) {
        this.afeC.a(new p.a()
        {
          public final void h(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(102855);
            Log.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (MMBaseSelectContactUI.c(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(8);
            }
            if ((paramAnonymousBoolean) && (paramAnonymousInt == 0))
            {
              if (!Util.isNullOrNil(paramAnonymousString))
              {
                MMBaseSelectContactUI.d(MMBaseSelectContactUI.this);
                AppMethodBeat.o(102855);
                return;
              }
              MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
              AppMethodBeat.o(102855);
              return;
            }
            MMBaseSelectContactUI.e(MMBaseSelectContactUI.this);
            AppMethodBeat.o(102855);
          }
        });
      }
      this.Nnk.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102857);
          if ((!MMBaseSelectContactUI.this.bVx()) && (MMBaseSelectContactUI.this.KOt != null))
          {
            paramAnonymousAbsListView = MMBaseSelectContactUI.this.Nnk.getChildAt(MMBaseSelectContactUI.this.Nnk.getFirstVisiblePosition());
            if ((paramAnonymousAbsListView == null) || (paramAnonymousAbsListView.getTop() != 0)) {
              break label80;
            }
            MMBaseSelectContactUI.f(MMBaseSelectContactUI.this).setVisibility(8);
          }
          while (paramAnonymousInt1 < 2)
          {
            AppMethodBeat.o(102857);
            return;
            label80:
            MMBaseSelectContactUI.f(MMBaseSelectContactUI.this).setVisibility(0);
          }
          com.tencent.mm.kernel.h.baF();
          if (!Util.nullAsFalse((Boolean)com.tencent.mm.kernel.h.baE().ban().d(12296, null)))
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().B(12296, Boolean.TRUE);
            if (MMBaseSelectContactUI.g(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.g(MMBaseSelectContactUI.this).dismiss();
            }
            MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, aa.a(MMBaseSelectContactUI.this, MMBaseSelectContactUI.this.getString(a.h.main_slide_toast), 4000L));
          }
          AppMethodBeat.o(102857);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(102856);
          if (paramAnonymousInt != 0)
          {
            MMBaseSelectContactUI.this.hideVKB();
            MMBaseSelectContactUI.this.jyN();
          }
          AppMethodBeat.o(102856);
        }
      });
      this.Nnk.setOnItemClickListener(this);
      if (bVy())
      {
        this.afeA = ((AlphabetScrollBar)findViewById(a.e.select_contact_scrollbar));
        this.afeA.setVisibility(0);
        this.afeA.setOnScrollBarTouchListener(this);
      }
      if (gaC())
      {
        this.afeL = ((LabelContainerView)findViewById(a.e.select_contact_label_container));
        this.afeM = ((TextView)this.afeL.findViewById(16908310));
        this.afeM.setText(a.h.select_contact_by_label_panel);
        this.afeN = ((MMTagPanel)this.afeL.findViewById(a.e.contact_label_panel));
        this.afeN.setTagSelectedBG(a.d.tag_white_tab_selector);
        this.afeN.setTagSelectedTextColorRes(com.tencent.mm.plugin.selectcontact.a.b.normal_text_color);
        this.afeL.setOnLabelContainerListener(new LabelContainerView.a()
        {
          public final void dCv()
          {
            AppMethodBeat.i(102858);
            if (MMBaseSelectContactUI.this.KOt != null) {
              MMBaseSelectContactUI.this.KOt.clearFocus();
            }
            if (MMBaseSelectContactUI.b(MMBaseSelectContactUI.this) != null)
            {
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).clearFocus();
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).jyO();
            }
            MMBaseSelectContactUI.this.afeL.requestFocus();
            MMBaseSelectContactUI.this.afeL.setVisibility(8);
            AppMethodBeat.o(102858);
          }
          
          public final void dCw()
          {
            AppMethodBeat.i(102859);
            MMBaseSelectContactUI.this.hideVKB();
            AppMethodBeat.o(102859);
          }
        });
        this.afeN.setCallBack(new MMTagPanel.a()
        {
          public final void G(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void aoT(String paramAnonymousString) {}
          
          public final void aoU(String paramAnonymousString)
          {
            AppMethodBeat.i(102860);
            MMBaseSelectContactUI.this.aLa(paramAnonymousString);
            AppMethodBeat.o(102860);
          }
          
          public final void aoV(String paramAnonymousString) {}
          
          public final void aoW(String paramAnonymousString) {}
          
          public final void aoX(String paramAnonymousString) {}
          
          public final void dCx() {}
        });
      }
      return;
      label618:
      if (this.afeD != null)
      {
        this.afeD.setVisibility(8);
        this.afeF.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.white));
      }
      if (this.DGv != null) {
        this.DGv.setVisibility(8);
      }
      this.KOt.setVisibility(0);
    }
  }
  
  public q jyE()
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
  
  public r jyF()
  {
    return this.afeB;
  }
  
  public final void jyG()
  {
    if (this.afeD != null)
    {
      this.afeD.setVisibility(0);
      this.afeF.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.BW_93));
    }
  }
  
  public final void jyH()
  {
    if (this.afeD != null)
    {
      this.afeD.setVisibility(8);
      this.afeF.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.selectcontact.a.b.white));
    }
  }
  
  public final void jyI()
  {
    if (this.KOt != null) {
      this.KOt.iKv();
    }
  }
  
  public final void jyJ()
  {
    if (this.KOt != null) {
      this.KOt.iKw();
    }
  }
  
  protected final void jyN()
  {
    if (this.lMw != null) {
      if (this.lMw.jCL()) {
        this.lMw.clearFocus();
      }
    }
    while ((this.KOt == null) || (!this.KOt.hasFocus())) {
      return;
    }
    this.KOt.clearFocus();
  }
  
  protected final void jyO()
  {
    if (this.lMw != null)
    {
      this.lMw.clearFocus();
      this.lMw.jyO();
    }
  }
  
  public boolean jyP()
  {
    return this.afeC != null;
  }
  
  public final s jyQ()
  {
    return this.lMw;
  }
  
  public final HashSet<String> jyR()
  {
    return this.afeR;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      Log.appenderFlushSync();
      finish();
      return;
    }
    aNi();
    Log.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    initView();
    Log.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.afeA != null) {
      this.afeA.adXj = null;
    }
    if (this.afeB != null) {
      this.afeB.finish();
    }
    if (this.afeC != null) {
      this.afeC.finish();
    }
    if (this.afeE != null) {
      this.afeE.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    int i = paramInt - getContentLV().getHeaderViewsCount();
    boolean bool1 = false;
    Object localObject2;
    int j;
    if (i >= 0)
    {
      localObject1 = jyE().aDt(i);
      bool1 = ((com.tencent.mm.ui.contact.a.a)localObject1).bVv().a(getContext(), paramView, (com.tencent.mm.ui.contact.a.a)localObject1);
      localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact;
      if ((this.afeR != null) && (localObject2 != null))
      {
        localObject2 = ((az)localObject2).field_username;
        if (!Util.isNullOrNil((String)localObject2))
        {
          if ((((com.tencent.mm.ui.contact.a.a)localObject1).query == null) || (((com.tencent.mm.ui.contact.a.a)localObject1).query.length() <= 0)) {
            break label434;
          }
          if (this.afeR.contains(localObject2)) {
            break label421;
          }
          this.afeR.add(localObject2);
        }
      }
      if (((com.tencent.mm.ui.contact.a.a)localObject1).mwk)
      {
        i = ((com.tencent.mm.ui.contact.a.a)localObject1).Huv;
        j = ((com.tencent.mm.ui.contact.a.a)localObject1).Huw;
        if (!((com.tencent.mm.ui.contact.a.a)localObject1).fxL()) {
          break label459;
        }
        i = 15;
        label211:
        j = 0;
        switch (((com.tencent.mm.ui.contact.a.a)localObject1).Huv)
        {
        }
      }
    }
    for (;;)
    {
      if (((com.tencent.mm.ui.contact.a.a)localObject1).afjE) {
        j = 1;
      }
      if (((com.tencent.mm.ui.contact.a.a)localObject1).viewType == 5) {
        j = 7;
      }
      localObject1 = String.format("%s,%d,%d,%d,%d", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject1).query, Integer.valueOf(((com.tencent.mm.ui.contact.a.a)localObject1).scene), Integer.valueOf(j), Integer.valueOf(((com.tencent.mm.ui.contact.a.a)localObject1).Huq), Integer.valueOf(i) });
      Log.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { localObject1 });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(13234, (String)localObject1);
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = jyE().aDu(paramInt);
      }
      if (!bool2) {
        a(paramAdapterView, paramView, paramInt, paramLong);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
      label421:
      this.afeR.remove(localObject2);
      break;
      label434:
      if (!this.afeR.contains(localObject2)) {
        break;
      }
      this.afeR.remove(localObject2);
      break;
      label459:
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
        break label211;
      }
      i = 0;
      break label211;
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
      fYZ();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.afeE != null) {
      this.afeE.dismiss();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((gaC()) && (this.afeO))
    {
      this.afeO = false;
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102862);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, com.tencent.mm.plugin.label.a.a.fTb().fSW());
          MMBaseSelectContactUI.h(MMBaseSelectContactUI.this);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(102861);
              MMBaseSelectContactUI.i(MMBaseSelectContactUI.this);
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
  
  public void onScollBarTouch(String paramString)
  {
    ListAdapter localListAdapter2 = this.Nnk.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof HeaderViewListAdapter)) {
      localListAdapter1 = ((HeaderViewListAdapter)localListAdapter2).getWrappedAdapter();
    }
    int i;
    if ((localListAdapter1 == this.afeB) && (this.afeB != null)) {
      i = this.afeB.aJM(paramString);
    }
    for (;;)
    {
      if (i == 0) {
        this.Nnk.setSelection(0);
      }
      do
      {
        return;
        if (localListAdapter1 != this.afeC) {
          break label189;
        }
        i = this.afeC.aJM(paramString);
        break;
        if (i <= 0) {
          break label165;
        }
        if (bVx())
        {
          this.Nnk.setSelection(i);
          return;
        }
      } while (this.KOt == null);
      this.Nnk.setSelectionFromTop(i, this.KOt.getMeasuredHeight());
      Log.i("MicroMsg.MMBaseSelectContactUI", "Select head selectPosition=%d | header=%s | y=%d", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(this.KOt.getMeasuredHeight()) });
      return;
      label165:
      Log.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
      return;
      label189:
      i = 0;
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