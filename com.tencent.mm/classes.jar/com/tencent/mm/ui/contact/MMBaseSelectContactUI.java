package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.d;
import com.tencent.mm.ui.tools.n.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public abstract class MMBaseSelectContactUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, MultiSelectContactView.a, MultiSelectContactView.b, MultiSelectContactView.c, VerticalScrollBar.a, l, n.b
{
  public com.tencent.mm.ui.tools.n drn;
  public MultiSelectContactView mbR;
  private ListView nhb;
  private View ogQ;
  public int scene;
  private AlphabetScrollBar vLL;
  private o vLM;
  public m vLN;
  private com.tencent.mm.ui.base.o vLO;
  private View vLP;
  private View vLQ;
  private TextView vLR;
  private LabelContainerView vLS;
  private TextView vLT;
  private MMTagPanel vLU;
  private boolean vLV = true;
  private List<String> vLW = new ArrayList();
  
  private String cHG()
  {
    if (this.drn != null) {
      return this.drn.getSearchContent();
    }
    if (this.mbR != null) {
      return this.mbR.getSearchContent();
    }
    return "";
  }
  
  private void cHH()
  {
    boolean bool;
    if (this.drn != null)
    {
      bool = this.drn.cIK();
      if ((!bool) || (!bk.bl(cHG()))) {
        break label102;
      }
      if ((this.vLW == null) || (this.vLW.size() <= 0)) {
        break label92;
      }
      this.vLS.setVisibility(0);
      this.vLU.a(null, this.vLW);
    }
    label92:
    label102:
    while (this.vLS == null)
    {
      return;
      if (this.mbR != null)
      {
        bool = this.mbR.hasFocus();
        break;
      }
      bool = false;
      break;
      this.vLS.setVisibility(8);
      return;
    }
    this.vLS.setVisibility(8);
  }
  
  private void cHJ()
  {
    y.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
    a(this.nhb, 0);
    this.nhb.setAdapter(this.vLM);
    this.vLM.notifyDataSetChanged();
    if ((VD()) && (this.vLL != null)) {
      this.vLL.setVisibility(0);
    }
    this.vLQ.setVisibility(8);
  }
  
  public final void GH(String paramString)
  {
    y.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[] { paramString });
    if (bhB()) {
      cHH();
    }
    if (this.vLN != null)
    {
      if (!bk.bl(paramString)) {
        this.vLN.a(paramString, bgw(), cHI());
      }
    }
    else {
      return;
    }
    this.vLN.adg();
    this.vLN.notifyDataSetChanged();
    cHJ();
  }
  
  public void Ha(String paramString)
  {
    y.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[] { paramString });
  }
  
  public abstract boolean VC();
  
  public abstract boolean VD();
  
  public abstract String VE();
  
  public abstract o VF();
  
  public abstract m VG();
  
  public final void Wl()
  {
    cHJ();
    if (bhB()) {
      cHH();
    }
  }
  
  public final void Wm() {}
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  public void a(ListView paramListView, int paramInt) {}
  
  public boolean a(a parama)
  {
    return false;
  }
  
  public boolean b(a parama)
  {
    return false;
  }
  
  public int[] bgw()
  {
    return new int[] { 131072, 131075, 131081 };
  }
  
  public void bgx()
  {
    XM();
    finish();
  }
  
  public boolean bhB()
  {
    return false;
  }
  
  public final n cHE()
  {
    if (getContentLV().getHeaderViewsCount() > 0) {
      return (n)((HeaderViewListAdapter)getContentLV().getAdapter()).getWrappedAdapter();
    }
    return (n)getContentLV().getAdapter();
  }
  
  public o cHF()
  {
    return this.vLM;
  }
  
  public boolean cHI()
  {
    return false;
  }
  
  public final void cHK()
  {
    if (this.drn != null) {
      if (!bk.bl(this.drn.getSearchContent()))
      {
        localn = this.drn;
        if (localn.wep != null) {
          localn.wep.nI(true);
        }
      }
    }
    while ((this.mbR == null) || (bk.bl(this.mbR.getSearchContent())))
    {
      com.tencent.mm.ui.tools.n localn;
      return;
    }
    this.mbR.san.setText("");
  }
  
  public final void cHL()
  {
    if (this.drn != null) {
      if (this.drn.cIK()) {
        this.drn.clearFocus();
      }
    }
    while ((this.mbR == null) || (!this.mbR.hasFocus())) {
      return;
    }
    this.mbR.clearFocus();
  }
  
  public boolean cHM()
  {
    return this.vLN != null;
  }
  
  public final void cmt()
  {
    if (bhB()) {
      cHH();
    }
  }
  
  public final void eU(String paramString)
  {
    int i;
    if (this.vLM != null)
    {
      i = this.vLM.adP(paramString);
      if (i != 0) {
        break label29;
      }
      this.nhb.setSelection(0);
    }
    label29:
    do
    {
      return;
      if (i <= 0) {
        break;
      }
      if (VC())
      {
        this.nhb.setSelection(i);
        return;
      }
    } while (this.mbR == null);
    this.nhb.setSelectionFromTop(i, this.mbR.getMeasuredHeight());
    return;
    y.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[] { Integer.valueOf(i), paramString });
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.nhb;
  }
  
  public int getLayoutId()
  {
    return a.f.mm_select_contact_ui;
  }
  
  public void initView()
  {
    setMMTitle(VE());
    this.nhb = ((ListView)findViewById(a.e.select_contact_lv));
    this.vLM = VF();
    this.vLN = VG();
    this.ogQ = findViewById(a.e.shadow);
    if (cHM())
    {
      this.vLQ = findViewById(a.e.no_result_view);
      this.vLR = ((TextView)findViewById(a.e.no_result_tv));
      this.vLQ.setOnTouchListener(new MMBaseSelectContactUI.1(this));
      if (!VC()) {
        break label361;
      }
      this.drn = new com.tencent.mm.ui.tools.n((byte)0);
      this.drn.weq = this;
      a(this.drn);
    }
    for (;;)
    {
      a(this.nhb, 0);
      this.nhb.setAdapter(this.vLM);
      setBackBtn(new MMBaseSelectContactUI.2(this));
      if (this.vLN != null) {
        this.vLN.a(new MMBaseSelectContactUI.3(this));
      }
      this.nhb.setOnScrollListener(new MMBaseSelectContactUI.4(this));
      this.nhb.setOnItemClickListener(this);
      if (VD())
      {
        this.vLL = ((AlphabetScrollBar)findViewById(a.e.select_contact_scrollbar));
        this.vLL.setVisibility(0);
        this.vLL.setOnScrollBarTouchListener(this);
      }
      if (bhB())
      {
        this.vLS = ((LabelContainerView)findViewById(a.e.select_contact_label_container));
        this.vLT = ((TextView)this.vLS.findViewById(16908310));
        this.vLT.setText(a.h.select_contact_by_label_panel);
        this.vLU = ((MMTagPanel)this.vLS.findViewById(a.e.contact_label_panel));
        this.vLU.setTagSelectedBG(a.d.tag_white_tab_selector);
        this.vLU.setTagSelectedTextColorRes(com.tencent.mm.plugin.selectcontact.a.b.normal_text_color);
        this.vLS.setOnLabelContainerListener(new MMBaseSelectContactUI.5(this));
        this.vLU.setCallBack(new MMBaseSelectContactUI.6(this));
      }
      return;
      label361:
      this.mbR = ((MultiSelectContactView)findViewById(a.e.contact_multiselect));
      this.mbR.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, -2147483648));
      this.mbR.setOnSearchTextChangeListener(this);
      this.mbR.setOnSearchTextFouceChangeListener(this);
      this.mbR.setOnContactDeselectListener(this);
      this.mbR.setVisibility(0);
      this.vLP = new View(this.mController.uMN);
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, this.mbR.getMeasuredHeight());
      this.vLP.setLayoutParams(localLayoutParams);
      this.vLP.setVisibility(4);
      this.nhb.addHeaderView(this.vLP);
      findViewById(a.e.padding_view).setVisibility(0);
    }
  }
  
  public void jP(int paramInt) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
    if (!g.DK())
    {
      y.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
      y.cqM();
      finish();
      return;
    }
    xK();
    y.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
    initView();
    y.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.vLL != null) {
      this.vLL.vbE = null;
    }
    if (this.vLM != null) {
      this.vLM.finish();
    }
    if (this.vLN != null) {
      this.vLN.finish();
    }
    if (this.vLO != null) {
      this.vLO.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt - getContentLV().getHeaderViewsCount();
    int j;
    if (i >= 0)
    {
      paramAdapterView = cHE().HK(i);
      paramView = paramAdapterView.Vz();
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      paramView.VB();
      if (paramAdapterView.dDQ)
      {
        i = paramAdapterView.kya;
        j = paramAdapterView.kyb;
        if (!paramAdapterView.aVG()) {
          break label243;
        }
        i = 15;
        switch (paramAdapterView.kya)
        {
        default: 
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (paramAdapterView.vOk) {
        j = 1;
      }
      if (paramAdapterView.ivk == 5) {
        j = 7;
      }
      paramAdapterView = String.format("%s,%d,%d,%d,%d", new Object[] { paramAdapterView.bVk, Integer.valueOf(paramAdapterView.scene), Integer.valueOf(j), Integer.valueOf(paramAdapterView.kxV), Integer.valueOf(i) });
      y.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramAdapterView });
      h.nFQ.aC(13234, paramAdapterView);
      if (!cHE().HL(paramInt)) {
        jP(paramInt);
      }
      return;
      label243:
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
      bgx();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.vLO != null) {
      this.vLO.dismiss();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((bhB()) && (this.vLV))
    {
      this.vLV = false;
      g.DS().O(new MMBaseSelectContactUI.7(this));
    }
  }
  
  public final boolean pB(String paramString)
  {
    return false;
  }
  
  public final void pC(String paramString)
  {
    y.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[] { paramString });
    if (bhB())
    {
      if (this.drn != null) {
        this.drn.cIL();
      }
      cHH();
    }
    if (!bk.bl(paramString))
    {
      this.vLN.a(paramString, bgw(), cHI());
      return;
    }
    this.vLN.adg();
    this.vLN.notifyDataSetChanged();
    cHJ();
  }
  
  public void pw(String paramString) {}
  
  public void xK()
  {
    this.scene = getIntent().getIntExtra("scene", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI
 * JD-Core Version:    0.7.0.1
 */