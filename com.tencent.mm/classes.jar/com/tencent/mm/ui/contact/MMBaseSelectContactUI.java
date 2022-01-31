package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.tools.d;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.q.b;
import java.util.ArrayList;
import java.util.List;

public abstract class MMBaseSelectContactUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, MultiSelectContactView.c, MultiSelectContactView.d, MultiSelectContactView.e, VerticalScrollBar.a, m, q.b
{
  private AlphabetScrollBar Adn;
  private p Ado;
  public n Adp;
  private com.tencent.mm.ui.base.o Adq;
  private View Adr;
  private View Ads;
  private TextView Adt;
  private LabelContainerView Adu;
  private TextView Adv;
  private MMTagPanel Adw;
  private boolean Adx = true;
  private List<String> Ady = new ArrayList();
  protected q eiV;
  public MultiSelectContactView oCs;
  private ListView pMp;
  private View qVf;
  protected int scene;
  
  private String dLY()
  {
    if (this.eiV != null) {
      return this.eiV.getSearchContent();
    }
    if (this.oCs != null) {
      return this.oCs.getSearchContent();
    }
    return "";
  }
  
  private void dLZ()
  {
    boolean bool;
    if (this.eiV != null)
    {
      bool = this.eiV.dNy();
      if ((!bool) || (!bo.isNullOrNil(dLY()))) {
        break label102;
      }
      if ((this.Ady == null) || (this.Ady.size() <= 0)) {
        break label92;
      }
      this.Adu.setVisibility(0);
      this.Adw.a(null, this.Ady);
    }
    label92:
    label102:
    while (this.Adu == null)
    {
      return;
      if (this.oCs != null)
      {
        bool = this.oCs.hasFocus();
        break;
      }
      bool = false;
      break;
      this.Adu.setVisibility(8);
      return;
    }
    this.Adu.setVisibility(8);
  }
  
  private void dMb()
  {
    ab.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.pMp, 0);
    this.pMp.setAdapter(this.Ado);
    this.Ado.notifyDataSetChanged();
    if ((apb()) && (this.Adn != null)) {
      this.Adn.setVisibility(0);
    }
    this.Ads.setVisibility(8);
  }
  
  protected void Kc()
  {
    this.scene = getIntent().getIntExtra("scene", 0);
  }
  
  protected void SL(String paramString)
  {
    ab.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
  }
  
  public final void Sk(String paramString)
  {
    ab.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (bPC()) {
      dLZ();
    }
    if (this.Adp != null)
    {
      if (!bo.isNullOrNil(paramString)) {
        this.Adp.a(paramString, bOp(), dMa());
      }
    }
    else {
      return;
    }
    this.Adp.clearData();
    this.Adp.notifyDataSetChanged();
    dMb();
  }
  
  protected void a(ListView paramListView, int paramInt) {}
  
  public boolean a(a parama)
  {
    return false;
  }
  
  public final void apN()
  {
    dMb();
    if (bPC()) {
      dLZ();
    }
  }
  
  public final void apO() {}
  
  public final void apP() {}
  
  public final void apQ() {}
  
  protected abstract boolean apa();
  
  protected abstract boolean apb();
  
  protected abstract String apc();
  
  protected abstract p apd();
  
  protected abstract n ape();
  
  public boolean b(a parama)
  {
    return false;
  }
  
  public int[] bOp()
  {
    return new int[] { 131072, 131075, 131081 };
  }
  
  public void bOq()
  {
    hideVKB();
    finish();
  }
  
  protected boolean bPC()
  {
    return false;
  }
  
  public final o dLW()
  {
    if (getContentLV().getHeaderViewsCount() > 0) {
      return (o)((HeaderViewListAdapter)getContentLV().getAdapter()).getWrappedAdapter();
    }
    return (o)getContentLV().getAdapter();
  }
  
  public p dLX()
  {
    return this.Ado;
  }
  
  protected boolean dMa()
  {
    return false;
  }
  
  protected final void dMc()
  {
    if (this.eiV != null) {
      if (!bo.isNullOrNil(this.eiV.getSearchContent()))
      {
        localq = this.eiV;
        if (localq.Axf != null) {
          localq.Axf.rs(true);
        }
      }
    }
    while ((this.oCs == null) || (bo.isNullOrNil(this.oCs.getSearchContent())))
    {
      q localq;
      return;
    }
    this.oCs.getInputText().setText("");
  }
  
  protected final void dMd()
  {
    if (this.eiV != null) {
      if (this.eiV.dNy()) {
        this.eiV.clearFocus();
      }
    }
    while ((this.oCs == null) || (!this.oCs.hasFocus())) {
      return;
    }
    this.oCs.clearFocus();
  }
  
  public boolean dMe()
  {
    return this.Adp != null;
  }
  
  public final void dnj()
  {
    if (bPC()) {
      dLZ();
    }
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.pMp;
  }
  
  public int getLayoutId()
  {
    return 2130970269;
  }
  
  public void initView()
  {
    setMMTitle(apc());
    this.pMp = ((ListView)findViewById(2131820911));
    this.Ado = apd();
    this.Adp = ape();
    this.qVf = findViewById(2131820913);
    if (dMe())
    {
      this.Ads = findViewById(2131820917);
      this.Adt = ((TextView)findViewById(2131820918));
      this.Ads.setOnTouchListener(new MMBaseSelectContactUI.1(this));
      if (!apa()) {
        break label362;
      }
      this.eiV = new q((byte)0);
      this.eiV.Axg = this;
      addSearchMenu(true, this.eiV);
    }
    for (;;)
    {
      a(this.pMp, 0);
      this.pMp.setAdapter(this.Ado);
      setBackBtn(new MMBaseSelectContactUI.2(this));
      if (this.Adp != null) {
        this.Adp.a(new MMBaseSelectContactUI.3(this));
      }
      this.pMp.setOnScrollListener(new MMBaseSelectContactUI.4(this));
      this.pMp.setOnItemClickListener(this);
      if (apb())
      {
        this.Adn = ((AlphabetScrollBar)findViewById(2131820914));
        this.Adn.setVisibility(0);
        this.Adn.setOnScrollBarTouchListener(this);
      }
      if (bPC())
      {
        this.Adu = ((LabelContainerView)findViewById(2131820915));
        this.Adv = ((TextView)this.Adu.findViewById(16908310));
        this.Adv.setText(2131303035);
        this.Adw = ((MMTagPanel)this.Adu.findViewById(2131820916));
        this.Adw.setTagSelectedBG(2130840509);
        this.Adw.setTagSelectedTextColorRes(2131690322);
        this.Adu.setOnLabelContainerListener(new MMBaseSelectContactUI.5(this));
        this.Adw.setCallBack(new MMBaseSelectContactUI.6(this));
      }
      return;
      label362:
      this.oCs = ((MultiSelectContactView)findViewById(2131820912));
      this.oCs.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, -2147483648));
      this.oCs.setOnSearchTextChangeListener(this);
      this.oCs.setOnSearchTextFouceChangeListener(this);
      this.oCs.setOnContactDeselectListener(this);
      this.oCs.setVisibility(0);
      this.Adr = new View(getContext());
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, this.oCs.getMeasuredHeight());
      this.Adr.setLayoutParams(localLayoutParams);
      this.Adr.setVisibility(4);
      this.pMp.addHeaderView(this.Adr);
      findViewById(2131820910).setVisibility(0);
    }
  }
  
  public final void lf(String paramString)
  {
    int i;
    if (this.Ado != null)
    {
      i = this.Ado.aux(paramString);
      if (i != 0) {
        break label29;
      }
      this.pMp.setSelection(0);
    }
    label29:
    do
    {
      return;
      if (i <= 0) {
        break;
      }
      if (apa())
      {
        this.pMp.setSelection(i);
        return;
      }
    } while (this.oCs == null);
    this.pMp.setSelectionFromTop(i, this.oCs.getMeasuredHeight());
    return;
    ab.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
  }
  
  public void mL(int paramInt) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ab.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!g.RG())
    {
      ab.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      ab.dsJ();
      finish();
      return;
    }
    Kc();
    ab.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    initView();
    ab.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.Adn != null) {
      this.Adn.zpW = null;
    }
    if (this.Ado != null) {
      this.Ado.finish();
    }
    if (this.Adp != null) {
      this.Adp.finish();
    }
    if (this.Adq != null) {
      this.Adq.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt - getContentLV().getHeaderViewsCount();
    int j;
    if (i >= 0)
    {
      paramAdapterView = dLW().Qt(i);
      paramView = paramAdapterView.aoY();
      getContext();
      paramView.aoZ();
      if (paramAdapterView.eBr)
      {
        i = paramAdapterView.mTN;
        j = paramAdapterView.mTO;
        if (!paramAdapterView.bCi()) {
          break label239;
        }
        i = 15;
        switch (paramAdapterView.mTN)
        {
        default: 
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (paramAdapterView.AfS) {
        j = 1;
      }
      if (paramAdapterView.kwo == 5) {
        j = 7;
      }
      paramAdapterView = String.format("%s,%d,%d,%d,%d", new Object[] { paramAdapterView.query, Integer.valueOf(paramAdapterView.scene), Integer.valueOf(j), Integer.valueOf(paramAdapterView.mTI), Integer.valueOf(i) });
      ab.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramAdapterView });
      h.qsU.kvStat(13234, paramAdapterView);
      if (!dLW().Qu(paramInt)) {
        mL(paramInt);
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
      bOq();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.Adq != null) {
      this.Adq.dismiss();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((bPC()) && (this.Adx))
    {
      this.Adx = false;
      g.RO().ac(new MMBaseSelectContactUI.7(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void wK(String paramString) {}
  
  public final boolean wR(String paramString)
  {
    return false;
  }
  
  public final void wS(String paramString)
  {
    ab.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (bPC())
    {
      if (this.eiV != null) {
        this.eiV.dNz();
      }
      dLZ();
    }
    if (!bo.isNullOrNil(paramString))
    {
      this.Adp.a(paramString, bOp(), dMa());
      return;
    }
    this.Adp.clearData();
    this.Adp.notifyDataSetChanged();
    dMb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI
 * JD-Core Version:    0.7.0.1
 */