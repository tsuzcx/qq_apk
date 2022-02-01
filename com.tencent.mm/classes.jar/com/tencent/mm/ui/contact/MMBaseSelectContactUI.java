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
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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
  private View KHn;
  private AlphabetScrollBar KJl;
  private q KJm;
  public o KJn;
  private View KJo;
  private com.tencent.mm.ui.base.o KJp;
  private View KJq;
  private View KJr;
  private View KJs;
  private TextView KJt;
  public LabelContainerView KJu;
  private TextView KJv;
  private MMTagPanel KJw;
  private boolean KJx = true;
  private List<String> KJy = new ArrayList();
  protected r fUI;
  protected int scene;
  public MultiSelectContactView vUs;
  protected ListView xuY;
  private View zjN;
  
  private void fMA()
  {
    boolean bool;
    if (this.fUI != null)
    {
      bool = this.fUI.fOw();
      if ((!bool) || (!bu.isNullOrNil(fMz()))) {
        break label102;
      }
      if ((this.KJy == null) || (this.KJy.size() <= 0)) {
        break label92;
      }
      this.KJu.setVisibility(0);
      this.KJw.a(null, this.KJy);
    }
    label92:
    label102:
    while (this.KJu == null)
    {
      return;
      if (this.vUs != null)
      {
        bool = this.vUs.hasFocus();
        break;
      }
      bool = false;
      break;
      this.KJu.setVisibility(8);
      return;
    }
    this.KJu.setVisibility(8);
  }
  
  private void fMB()
  {
    ae.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.xuY, 0);
    this.xuY.setAdapter(this.KJm);
    this.KJm.notifyDataSetChanged();
    if ((aRU()) && (this.KJl != null)) {
      this.KJl.setVisibility(0);
    }
    this.KJs.setVisibility(8);
  }
  
  private String fMz()
  {
    if (this.fUI != null) {
      return this.fUI.getSearchContent();
    }
    if (this.vUs != null) {
      return this.vUs.getSearchContent();
    }
    return "";
  }
  
  public final boolean JO(String paramString)
  {
    return false;
  }
  
  public final void JP(String paramString)
  {
    ae.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (doz())
    {
      if (this.fUI != null) {
        this.fUI.fOx();
      }
      fMA();
    }
    if (!bu.isNullOrNil(paramString))
    {
      this.KJn.b(paramString, dmI());
      return;
    }
    this.KJn.clearData();
    this.KJn.notifyDataSetChanged();
    fMB();
  }
  
  public void Q(int paramInt, String paramString) {}
  
  protected void Zm()
  {
    this.scene = getIntent().getIntExtra("scene", 0);
  }
  
  protected void a(ListView paramListView, int paramInt) {}
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void aNW(String paramString)
  {
    ae.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (doz()) {
      fMA();
    }
    if (this.KJn != null)
    {
      if (!bu.isNullOrNil(paramString)) {
        this.KJn.b(paramString, dmI());
      }
    }
    else {
      return;
    }
    this.KJn.clearData();
    this.KJn.notifyDataSetChanged();
    fMB();
  }
  
  protected abstract boolean aRT();
  
  protected abstract boolean aRU();
  
  protected abstract String aRV();
  
  protected abstract q aRW();
  
  protected abstract o aRX();
  
  public final void aSL()
  {
    fMB();
    if (doz()) {
      fMA();
    }
    if (aRT())
    {
      this.KJo.setVisibility(0);
      this.KJq.setBackgroundColor(getResources().getColor(2131099679));
      this.KHn.setVisibility(8);
      this.KJq.setVisibility(0);
    }
  }
  
  public final void aSM() {}
  
  public final void aSN()
  {
    if (this.KHn != null) {
      this.KHn.setVisibility(0);
    }
  }
  
  public final void aSO() {}
  
  protected void aqy(String paramString)
  {
    ae.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
  }
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public int[] dmI()
  {
    return new int[] { 131072, 131075, 131081 };
  }
  
  public void dmJ()
  {
    hideVKB();
    finish();
  }
  
  protected boolean doz()
  {
    return false;
  }
  
  public final void fMC()
  {
    if ((this.fUI != null) && (!bu.isNullOrNil(this.fUI.getSearchContent())))
    {
      r localr = this.fUI;
      if (localr.Lhj != null) {
        localr.Lhj.yN(true);
      }
    }
    if ((this.vUs != null) && (!bu.isNullOrNil(this.vUs.getSearchContent()))) {
      this.vUs.getInputText().setText("");
    }
  }
  
  protected final void fMD()
  {
    if (this.fUI != null) {
      if (this.fUI.fOw()) {
        this.fUI.clearFocus();
      }
    }
    while ((this.vUs == null) || (!this.vUs.hasFocus())) {
      return;
    }
    this.vUs.clearFocus();
  }
  
  public boolean fME()
  {
    return this.KJn != null;
  }
  
  public final p fMv()
  {
    if (getContentLV().getHeaderViewsCount() > 0) {
      return (p)((HeaderViewListAdapter)getContentLV().getAdapter()).getWrappedAdapter();
    }
    return (p)getContentLV().getAdapter();
  }
  
  public q fMw()
  {
    return this.KJm;
  }
  
  public final void fMx()
  {
    if (this.KJo != null)
    {
      this.KJo.setVisibility(0);
      this.KJq.setBackgroundColor(getResources().getColor(2131099679));
    }
  }
  
  public final void fMy()
  {
    if (this.KJo != null)
    {
      this.KJo.setVisibility(8);
      this.KJq.setBackgroundColor(getResources().getColor(2131101179));
    }
  }
  
  public final void ffK()
  {
    if (doz()) {
      fMA();
    }
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.xuY;
  }
  
  public int getLayoutId()
  {
    return 2131494899;
  }
  
  public void initView()
  {
    setMMTitle(aRV());
    this.KJo = findViewById(2131306016);
    this.KHn = findViewById(2131306014);
    this.xuY = ((ListView)findViewById(2131304508));
    this.KJm = aRW();
    this.KJn = aRX();
    this.zjN = findViewById(2131304671);
    if (fME())
    {
      this.KJs = findViewById(2131302885);
      this.KJt = ((TextView)findViewById(2131302884));
      this.KJs.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102851);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
          MMBaseSelectContactUI.this.fMC();
          MMBaseSelectContactUI.this.fMD();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(102851);
          return false;
        }
      });
      this.vUs = ((MultiSelectContactView)findViewById(2131298676));
      this.vUs.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, -2147483648));
      this.vUs.setOnSearchTextChangeListener(this);
      this.vUs.setOnSearchTextFouceChangeListener(this);
      this.vUs.setOnContactDeselectListener(this);
      this.KJr = LayoutInflater.from(this).inflate(2131493600, null);
      this.KJq = this.KJr.findViewById(2131300701);
      this.xuY.addHeaderView(this.KJr);
      if (!aRT()) {
        break label576;
      }
      hideActionbarLine();
      if (this.vUs != null) {
        this.vUs.setVisibility(8);
      }
      this.KJo.setVisibility(0);
      this.KJq.setBackgroundColor(getResources().getColor(2131099679));
      this.KHn.setVisibility(8);
      this.fUI = new r((byte)0);
      this.fUI.Lhk = this;
      this.KJo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(102852);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.MMBaseSelectContactUI", "dancy test topSearchView onClick!!");
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).yP(true);
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(102852);
        }
      });
      this.KHn.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102853);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).fOV();
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(102853);
          return true;
        }
      });
    }
    for (;;)
    {
      a(this.xuY, 0);
      this.xuY.setAdapter(this.KJm);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(102854);
          MMBaseSelectContactUI.this.dmJ();
          AppMethodBeat.o(102854);
          return true;
        }
      });
      if (this.KJn != null) {
        this.KJn.a(new o.a()
        {
          public final void y(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(102855);
            ae.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (MMBaseSelectContactUI.d(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(8);
            }
            if ((paramAnonymousBoolean) && (paramAnonymousInt == 0))
            {
              if (!bu.isNullOrNil(paramAnonymousString))
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
      this.xuY.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102857);
          if ((!MMBaseSelectContactUI.this.aRT()) && (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null))
          {
            paramAnonymousAbsListView = MMBaseSelectContactUI.this.xuY.getChildAt(MMBaseSelectContactUI.this.xuY.getFirstVisiblePosition());
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
          com.tencent.mm.kernel.g.ajS();
          if (!bu.o((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(12296, null)))
          {
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajR().ajA().set(12296, Boolean.TRUE);
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
            MMBaseSelectContactUI.this.fMD();
          }
          AppMethodBeat.o(102856);
        }
      });
      this.xuY.setOnItemClickListener(this);
      if (aRU())
      {
        this.KJl = ((AlphabetScrollBar)findViewById(2131304510));
        this.KJl.setVisibility(0);
        this.KJl.setOnScrollBarTouchListener(this);
      }
      if (doz())
      {
        this.KJu = ((LabelContainerView)findViewById(2131304507));
        this.KJv = ((TextView)this.KJu.findViewById(16908310));
        this.KJv.setText(2131762979);
        this.KJw = ((MMTagPanel)this.KJu.findViewById(2131298672));
        this.KJw.setTagSelectedBG(2131234298);
        this.KJw.setTagSelectedTextColorRes(2131100711);
        this.KJu.setOnLabelContainerListener(new LabelContainerView.a()
        {
          public final void ckg()
          {
            AppMethodBeat.i(102858);
            if (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.h(MMBaseSelectContactUI.this).clearFocus();
            }
            if (MMBaseSelectContactUI.b(MMBaseSelectContactUI.this) != null)
            {
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).clearFocus();
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).fOV();
            }
            MMBaseSelectContactUI.this.KJu.requestFocus();
            MMBaseSelectContactUI.this.KJu.setVisibility(8);
            AppMethodBeat.o(102858);
          }
          
          public final void ckh()
          {
            AppMethodBeat.i(102859);
            MMBaseSelectContactUI.this.hideVKB();
            AppMethodBeat.o(102859);
          }
        });
        this.KJw.setCallBack(new MMTagPanel.a()
        {
          public final void D(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void acT(String paramAnonymousString) {}
          
          public final void acU(String paramAnonymousString)
          {
            AppMethodBeat.i(102860);
            MMBaseSelectContactUI.this.aqy(paramAnonymousString);
            AppMethodBeat.o(102860);
          }
          
          public final void acV(String paramAnonymousString) {}
          
          public final void acW(String paramAnonymousString) {}
          
          public final void acX(String paramAnonymousString) {}
          
          public final void cki() {}
        });
      }
      return;
      label576:
      if (this.KJo != null)
      {
        this.KJo.setVisibility(8);
        this.KJq.setBackgroundColor(getResources().getColor(2131101179));
      }
      if (this.KHn != null) {
        this.KHn.setVisibility(8);
      }
      this.vUs.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ae.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      ae.fop();
      finish();
      return;
    }
    Zm();
    ae.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    initView();
    ae.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (aRT())
    {
      this.fUI.a(this, paramMenu);
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
    if (this.KJl != null) {
      this.KJl.JLP = null;
    }
    if (this.KJm != null) {
      this.KJm.finish();
    }
    if (this.KJn != null) {
      this.KJn.finish();
    }
    if (this.KJp != null) {
      this.KJp.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    int i = paramInt - getContentLV().getHeaderViewsCount();
    int j;
    if (i >= 0)
    {
      paramAdapterView = fMv().aeW(i);
      paramView = paramAdapterView.aRR();
      getContext();
      paramView.aRS();
      if (paramAdapterView.gxU)
      {
        i = paramAdapterView.tGR;
        j = paramAdapterView.tGS;
        if (!paramAdapterView.cVC()) {
          break label312;
        }
        i = 15;
        j = 0;
        switch (paramAdapterView.tGR)
        {
        }
      }
    }
    for (;;)
    {
      if (paramAdapterView.KNd) {
        j = 1;
      }
      if (paramAdapterView.oOD == 5) {
        j = 7;
      }
      paramAdapterView = String.format("%s,%d,%d,%d,%d", new Object[] { paramAdapterView.query, Integer.valueOf(paramAdapterView.scene), Integer.valueOf(j), Integer.valueOf(paramAdapterView.tGM), Integer.valueOf(i) });
      ae.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramAdapterView });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(13234, paramAdapterView);
      if (!fMv().aeX(paramInt)) {
        rj(paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
      label312:
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
      dmJ();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.KJp != null) {
      this.KJp.dismiss();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (aRT())
    {
      this.fUI.a(this, paramMenu);
      return super.onPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((doz()) && (this.KJx))
    {
      this.KJx = false;
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102862);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, com.tencent.mm.plugin.label.a.a.dig().dib());
          MMBaseSelectContactUI.k(MMBaseSelectContactUI.this);
          ar.f(new Runnable()
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
  
  public void rj(int paramInt) {}
  
  public final void vy(String paramString)
  {
    ListAdapter localListAdapter2 = this.xuY.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof HeaderViewListAdapter)) {
      localListAdapter1 = ((HeaderViewListAdapter)localListAdapter2).getWrappedAdapter();
    }
    int i;
    if (localListAdapter1 == this.KJm) {
      i = this.KJm.aYn(paramString);
    }
    for (;;)
    {
      if (i == 0) {
        this.xuY.setSelection(0);
      }
      do
      {
        return;
        if (localListAdapter1 != this.KJn) {
          break label182;
        }
        i = this.KJn.aYn(paramString);
        break;
        if (i <= 0) {
          break label158;
        }
        if (aRT())
        {
          this.xuY.setSelection(i);
          return;
        }
      } while (this.vUs == null);
      this.xuY.setSelectionFromTop(i, this.vUs.getMeasuredHeight());
      ae.i("MicroMsg.MMBaseSelectContactUI", "Select head selectPosition=%d | header=%s | y=%d", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(this.vUs.getMeasuredHeight()) });
      return;
      label158:
      ae.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
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