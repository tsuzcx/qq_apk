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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
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
  private View KkT;
  private AlphabetScrollBar KmR;
  private q KmS;
  public o KmT;
  private View KmU;
  private com.tencent.mm.ui.base.o KmV;
  private View KmW;
  private View KmX;
  private View KmY;
  private TextView KmZ;
  public LabelContainerView Kna;
  private TextView Knb;
  private MMTagPanel Knc;
  private boolean Knd = true;
  private List<String> Kne = new ArrayList();
  protected r fSC;
  protected int scene;
  public MultiSelectContactView vIo;
  protected ListView xfg;
  private View yTD;
  
  private String fIh()
  {
    if (this.fSC != null) {
      return this.fSC.getSearchContent();
    }
    if (this.vIo != null) {
      return this.vIo.getSearchContent();
    }
    return "";
  }
  
  private void fIi()
  {
    boolean bool;
    if (this.fSC != null)
    {
      bool = this.fSC.fKf();
      if ((!bool) || (!bt.isNullOrNil(fIh()))) {
        break label102;
      }
      if ((this.Kne == null) || (this.Kne.size() <= 0)) {
        break label92;
      }
      this.Kna.setVisibility(0);
      this.Knc.a(null, this.Kne);
    }
    label92:
    label102:
    while (this.Kna == null)
    {
      return;
      if (this.vIo != null)
      {
        bool = this.vIo.hasFocus();
        break;
      }
      bool = false;
      break;
      this.Kna.setVisibility(8);
      return;
    }
    this.Kna.setVisibility(8);
  }
  
  private void fIj()
  {
    ad.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.xfg, 0);
    this.xfg.setAdapter(this.KmS);
    this.KmS.notifyDataSetChanged();
    if ((aRv()) && (this.KmR != null)) {
      this.KmR.setVisibility(0);
    }
    this.KmY.setVisibility(8);
  }
  
  public final boolean Jp(String paramString)
  {
    return false;
  }
  
  public final void Jq(String paramString)
  {
    ad.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (dlz())
    {
      if (this.fSC != null) {
        this.fSC.fKg();
      }
      fIi();
    }
    if (!bt.isNullOrNil(paramString))
    {
      this.KmT.b(paramString, djJ());
      return;
    }
    this.KmT.clearData();
    this.KmT.notifyDataSetChanged();
    fIj();
  }
  
  public void Q(int paramInt, String paramString) {}
  
  protected void Zd()
  {
    this.scene = getIntent().getIntExtra("scene", 0);
  }
  
  protected void a(ListView paramListView, int paramInt) {}
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void aMA(String paramString)
  {
    ad.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (dlz()) {
      fIi();
    }
    if (this.KmT != null)
    {
      if (!bt.isNullOrNil(paramString)) {
        this.KmT.b(paramString, djJ());
      }
    }
    else {
      return;
    }
    this.KmT.clearData();
    this.KmT.notifyDataSetChanged();
    fIj();
  }
  
  protected abstract boolean aRu();
  
  protected abstract boolean aRv();
  
  protected abstract String aRw();
  
  protected abstract q aRx();
  
  protected abstract o aRy();
  
  public final void aSm()
  {
    fIj();
    if (dlz()) {
      fIi();
    }
    if (aRu())
    {
      this.KmU.setVisibility(0);
      this.KmW.setBackgroundColor(getResources().getColor(2131099679));
      this.KkT.setVisibility(8);
      this.KmW.setVisibility(0);
    }
  }
  
  public final void aSn() {}
  
  public final void aSo()
  {
    if (this.KkT != null) {
      this.KkT.setVisibility(0);
    }
  }
  
  public final void aSp() {}
  
  protected void apt(String paramString)
  {
    ad.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
  }
  
  public boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public int[] djJ()
  {
    return new int[] { 131072, 131075, 131081 };
  }
  
  public void djK()
  {
    hideVKB();
    finish();
  }
  
  protected boolean dlz()
  {
    return false;
  }
  
  public final p fId()
  {
    if (getContentLV().getHeaderViewsCount() > 0) {
      return (p)((HeaderViewListAdapter)getContentLV().getAdapter()).getWrappedAdapter();
    }
    return (p)getContentLV().getAdapter();
  }
  
  public q fIe()
  {
    return this.KmS;
  }
  
  public final void fIf()
  {
    if (this.KmU != null)
    {
      this.KmU.setVisibility(0);
      this.KmW.setBackgroundColor(getResources().getColor(2131099679));
    }
  }
  
  public final void fIg()
  {
    if (this.KmU != null)
    {
      this.KmU.setVisibility(8);
      this.KmW.setBackgroundColor(getResources().getColor(2131101179));
    }
  }
  
  public final void fIk()
  {
    if ((this.fSC != null) && (!bt.isNullOrNil(this.fSC.getSearchContent())))
    {
      r localr = this.fSC;
      if (localr.KKP != null) {
        localr.KKP.yA(true);
      }
    }
    if ((this.vIo != null) && (!bt.isNullOrNil(this.vIo.getSearchContent()))) {
      this.vIo.getInputText().setText("");
    }
  }
  
  protected final void fIl()
  {
    if (this.fSC != null) {
      if (this.fSC.fKf()) {
        this.fSC.clearFocus();
      }
    }
    while ((this.vIo == null) || (!this.vIo.hasFocus())) {
      return;
    }
    this.vIo.clearFocus();
  }
  
  public boolean fIm()
  {
    return this.KmT != null;
  }
  
  public final void fbW()
  {
    if (dlz()) {
      fIi();
    }
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.xfg;
  }
  
  public int getLayoutId()
  {
    return 2131494899;
  }
  
  public void initView()
  {
    setMMTitle(aRw());
    this.KmU = findViewById(2131306016);
    this.KkT = findViewById(2131306014);
    this.xfg = ((ListView)findViewById(2131304508));
    this.KmS = aRx();
    this.KmT = aRy();
    this.yTD = findViewById(2131304671);
    if (fIm())
    {
      this.KmY = findViewById(2131302885);
      this.KmZ = ((TextView)findViewById(2131302884));
      this.KmY.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102851);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this);
          MMBaseSelectContactUI.this.fIk();
          MMBaseSelectContactUI.this.fIl();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(102851);
          return false;
        }
      });
      this.vIo = ((MultiSelectContactView)findViewById(2131298676));
      this.vIo.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, -2147483648));
      this.vIo.setOnSearchTextChangeListener(this);
      this.vIo.setOnSearchTextFouceChangeListener(this);
      this.vIo.setOnContactDeselectListener(this);
      this.KmX = LayoutInflater.from(this).inflate(2131493600, null);
      this.KmW = this.KmX.findViewById(2131300701);
      this.xfg.addHeaderView(this.KmX);
      if (!aRu()) {
        break label576;
      }
      hideActionbarLine();
      if (this.vIo != null) {
        this.vIo.setVisibility(8);
      }
      this.KmU.setVisibility(0);
      this.KmW.setBackgroundColor(getResources().getColor(2131099679));
      this.KkT.setVisibility(8);
      this.fSC = new r((byte)0);
      this.fSC.KKQ = this;
      this.KmU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(102852);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.d("MicroMsg.MMBaseSelectContactUI", "dancy test topSearchView onClick!!");
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).yC(true);
          MMBaseSelectContactUI.c(MMBaseSelectContactUI.this).setVisibility(8);
          MMBaseSelectContactUI.d(MMBaseSelectContactUI.this).setVisibility(0);
          MMBaseSelectContactUI.e(MMBaseSelectContactUI.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/MMBaseSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(102852);
        }
      });
      this.KkT.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(102853);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).fKE();
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
      a(this.xfg, 0);
      this.xfg.setAdapter(this.KmS);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(102854);
          MMBaseSelectContactUI.this.djK();
          AppMethodBeat.o(102854);
          return true;
        }
      });
      if (this.KmT != null) {
        this.KmT.a(new o.a()
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
      this.xfg.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102857);
          if ((!MMBaseSelectContactUI.this.aRu()) && (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null))
          {
            paramAnonymousAbsListView = MMBaseSelectContactUI.this.xfg.getChildAt(MMBaseSelectContactUI.this.xfg.getFirstVisiblePosition());
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
          com.tencent.mm.kernel.g.ajD();
          if (!bt.o((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(12296, null)))
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajC().ajl().set(12296, Boolean.TRUE);
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
            MMBaseSelectContactUI.this.fIl();
          }
          AppMethodBeat.o(102856);
        }
      });
      this.xfg.setOnItemClickListener(this);
      if (aRv())
      {
        this.KmR = ((AlphabetScrollBar)findViewById(2131304510));
        this.KmR.setVisibility(0);
        this.KmR.setOnScrollBarTouchListener(this);
      }
      if (dlz())
      {
        this.Kna = ((LabelContainerView)findViewById(2131304507));
        this.Knb = ((TextView)this.Kna.findViewById(16908310));
        this.Knb.setText(2131762979);
        this.Knc = ((MMTagPanel)this.Kna.findViewById(2131298672));
        this.Knc.setTagSelectedBG(2131234298);
        this.Knc.setTagSelectedTextColorRes(2131100711);
        this.Kna.setOnLabelContainerListener(new LabelContainerView.a()
        {
          public final void ciQ()
          {
            AppMethodBeat.i(102858);
            if (MMBaseSelectContactUI.h(MMBaseSelectContactUI.this) != null) {
              MMBaseSelectContactUI.h(MMBaseSelectContactUI.this).clearFocus();
            }
            if (MMBaseSelectContactUI.b(MMBaseSelectContactUI.this) != null)
            {
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).clearFocus();
              MMBaseSelectContactUI.b(MMBaseSelectContactUI.this).fKE();
            }
            MMBaseSelectContactUI.this.Kna.requestFocus();
            MMBaseSelectContactUI.this.Kna.setVisibility(8);
            AppMethodBeat.o(102858);
          }
          
          public final void ciR()
          {
            AppMethodBeat.i(102859);
            MMBaseSelectContactUI.this.hideVKB();
            AppMethodBeat.o(102859);
          }
        });
        this.Knc.setCallBack(new MMTagPanel.a()
        {
          public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
          
          public final void acc(String paramAnonymousString) {}
          
          public final void acd(String paramAnonymousString)
          {
            AppMethodBeat.i(102860);
            MMBaseSelectContactUI.this.apt(paramAnonymousString);
            AppMethodBeat.o(102860);
          }
          
          public final void ace(String paramAnonymousString) {}
          
          public final void acf(String paramAnonymousString) {}
          
          public final void acg(String paramAnonymousString) {}
          
          public final void ciS() {}
        });
      }
      return;
      label576:
      if (this.KmU != null)
      {
        this.KmU.setVisibility(8);
        this.KmW.setBackgroundColor(getResources().getColor(2131101179));
      }
      if (this.KkT != null) {
        this.KkT.setVisibility(8);
      }
      this.vIo.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ad.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      ad.fkv();
      finish();
      return;
    }
    Zd();
    ad.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    initView();
    ad.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (aRu())
    {
      this.fSC.a(this, paramMenu);
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
    if (this.KmR != null) {
      this.KmR.Jra = null;
    }
    if (this.KmS != null) {
      this.KmS.finish();
    }
    if (this.KmT != null) {
      this.KmT.finish();
    }
    if (this.KmV != null) {
      this.KmV.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/MMBaseSelectContactUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    int i = paramInt - getContentLV().getHeaderViewsCount();
    int j;
    if (i >= 0)
    {
      paramAdapterView = fId().aen(i);
      paramView = paramAdapterView.aRs();
      getContext();
      paramView.aRt();
      if (paramAdapterView.gvn)
      {
        i = paramAdapterView.twa;
        j = paramAdapterView.twb;
        if (!paramAdapterView.cSX()) {
          break label312;
        }
        i = 15;
        j = 0;
        switch (paramAdapterView.twa)
        {
        }
      }
    }
    for (;;)
    {
      if (paramAdapterView.KqJ) {
        j = 1;
      }
      if (paramAdapterView.oIb == 5) {
        j = 7;
      }
      paramAdapterView = String.format("%s,%d,%d,%d,%d", new Object[] { paramAdapterView.query, Integer.valueOf(paramAdapterView.scene), Integer.valueOf(j), Integer.valueOf(paramAdapterView.tvV), Integer.valueOf(i) });
      ad.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramAdapterView });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(13234, paramAdapterView);
      if (!fId().aeo(paramInt)) {
        rg(paramInt);
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
      djK();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.KmV != null) {
      this.KmV.dismiss();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (aRu())
    {
      this.fSC.a(this, paramMenu);
      return super.onPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((dlz()) && (this.Knd))
    {
      this.Knd = false;
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102862);
          MMBaseSelectContactUI.a(MMBaseSelectContactUI.this, com.tencent.mm.plugin.label.a.a.dfo().dfj());
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
  
  public void rg(int paramInt) {}
  
  public final void vc(String paramString)
  {
    ListAdapter localListAdapter2 = this.xfg.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof HeaderViewListAdapter)) {
      localListAdapter1 = ((HeaderViewListAdapter)localListAdapter2).getWrappedAdapter();
    }
    int i;
    if (localListAdapter1 == this.KmS) {
      i = this.KmS.aWM(paramString);
    }
    for (;;)
    {
      if (i == 0) {
        this.xfg.setSelection(0);
      }
      do
      {
        return;
        if (localListAdapter1 != this.KmT) {
          break label182;
        }
        i = this.KmT.aWM(paramString);
        break;
        if (i <= 0) {
          break label158;
        }
        if (aRu())
        {
          this.xfg.setSelection(i);
          return;
        }
      } while (this.vIo == null);
      this.xfg.setSelectionFromTop(i, this.vIo.getMeasuredHeight());
      ad.i("MicroMsg.MMBaseSelectContactUI", "Select head selectPosition=%d | header=%s | y=%d", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(this.vIo.getMeasuredHeight()) });
      return;
      label158:
      ad.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
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