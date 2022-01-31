package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class BankRemitHistoryUI
  extends BankRemitBaseUI
  implements n.d
{
  private boolean eXB = false;
  private boolean eXC = false;
  private j gGp;
  private List<apc> iSO = new ArrayList();
  private View jhf;
  private int limit = 20;
  private ListView nwE;
  private BankRemitHistoryUI.a nwF;
  private int offset = 0;
  
  private void bwc()
  {
    y.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", new Object[] { Integer.valueOf(this.limit), Integer.valueOf(this.offset) });
    this.eXB = true;
    i locali = new i(this.limit, this.offset);
    locali.m(this);
    a(locali, false, false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof i))
    {
      paramString = (i)paramm;
      paramString.a(new BankRemitHistoryUI.5(this, paramString)).b(new BankRemitHistoryUI.4(this, paramString)).c(new BankRemitHistoryUI.3(this));
      this.eXB = false;
    }
    while (!(paramm instanceof e)) {
      return false;
    }
    paramString = (e)paramm;
    paramString.a(new BankRemitHistoryUI.8(this, paramString)).b(new BankRemitHistoryUI.7(this, paramString)).c(new BankRemitHistoryUI.6(this));
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.bank_remit_history_ui;
  }
  
  protected final void initView()
  {
    this.nwE = ((ListView)findViewById(a.f.brhu_lv));
    this.jhf = LayoutInflater.from(this).inflate(a.g.aa_record_list_loading_more, null);
    this.gGp = new j(this);
    this.nwF = new BankRemitHistoryUI.a(this, (byte)0);
    this.nwE.addFooterView(this.jhf);
    this.nwE.setAdapter(this.nwF);
    this.nwE.setOnItemLongClickListener(new BankRemitHistoryUI.1(this));
    this.nwE.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((BankRemitHistoryUI.b(BankRemitHistoryUI.this).getLastVisiblePosition() == BankRemitHistoryUI.b(BankRemitHistoryUI.this).getCount() - 1) && (BankRemitHistoryUI.b(BankRemitHistoryUI.this).getCount() > 0) && (!BankRemitHistoryUI.c(BankRemitHistoryUI.this)) && (!BankRemitHistoryUI.d(BankRemitHistoryUI.this))) {
          BankRemitHistoryUI.e(BankRemitHistoryUI.this);
        }
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1511);
    kh(1737);
    setMMTitle(a.i.bank_remit_history_title);
    initView();
    bwc();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 1, 0, a.i.bank_remit_select_payee_delete_text);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1511);
    ki(1737);
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    localObject = (apc)this.nwE.getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if ((paramMenuItem.getItemId() == 1) && (localObject != null))
    {
      paramMenuItem = ((apc)localObject).sFw;
      y.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", new Object[] { paramMenuItem });
      paramMenuItem = new e(paramMenuItem);
      paramMenuItem.m(this);
      a(paramMenuItem, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI
 * JD-Core Version:    0.7.0.1
 */