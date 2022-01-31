package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectPayeeUI
  extends BankRemitBaseUI
  implements n.d
{
  private com.tencent.mm.ui.tools.j gGp;
  private int nxA = -1;
  private Intent nxB;
  private ListView nxu;
  private BankRemitSelectPayeeUI.b nxv;
  private List<TransferRecordParcel> nxw;
  private ArrayList<TransferRecordParcel> nxx;
  private ArrayList<String> nxy;
  private int nxz = -1;
  
  public final boolean c(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.j))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.j)paramm;
      paramString.a(new BankRemitSelectPayeeUI.8(this, paramString)).b(new BankRemitSelectPayeeUI.7(this, paramString)).c(new BankRemitSelectPayeeUI.6(this));
    }
    for (;;)
    {
      return false;
      if ((paramm instanceof f))
      {
        paramString = (f)paramm;
        paramString.a(new n.a()
        {
          public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
          {
            BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramString.nuR);
          }
        }).b(new BankRemitSelectPayeeUI.10(this, paramString)).c(new BankRemitSelectPayeeUI.9(this));
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.bank_remit_select_payee_ui;
  }
  
  public final void initView()
  {
    this.nxu = ((ListView)findViewById(a.f.brsp_lv));
    this.gGp = new com.tencent.mm.ui.tools.j(this);
    this.nxv = new BankRemitSelectPayeeUI.b(this, (byte)0);
    this.nxu.setAdapter(this.nxv);
    this.nxu.setOnItemClickListener(new BankRemitSelectPayeeUI.1(this));
    this.nxu.setOnItemLongClickListener(new BankRemitSelectPayeeUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getParcelableArrayListExtra("key_self_transfer_record_list");
    Object localObject = getIntent().getParcelableArrayListExtra("key_freq_transfer_record_list");
    this.nxw = new ArrayList();
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.nxz = 0;
      this.nxw.addAll(paramBundle);
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.nxA = (this.nxw.size() + this.nxz + 1);
      this.nxw.addAll((Collection)localObject);
    }
    y.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", new Object[] { Integer.valueOf(this.nxz), Integer.valueOf(this.nxA) });
    paramBundle = this.nxw.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (TransferRecordParcel)paramBundle.next();
      y.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", new Object[] { ((TransferRecordParcel)localObject).nvy, ((TransferRecordParcel)localObject).nvz, ((TransferRecordParcel)localObject).nve, ((TransferRecordParcel)localObject).lnT, ((TransferRecordParcel)localObject).mOb, ((TransferRecordParcel)localObject).nvA, ((TransferRecordParcel)localObject).nvB });
    }
    this.nxB = new Intent();
    initView();
    setMMTitle(a.i.bank_remit_select_payee_title);
    kh(1590);
    kh(1395);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 1, 0, a.i.bank_remit_select_payee_remark_text);
    paramContextMenu.add(0, 0, 0, a.i.bank_remit_select_payee_delete_text);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1590);
    ki(1395);
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = paramMenuItem.getItemId();
    paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    paramMenuItem = (TransferRecordParcel)this.nxu.getItemAtPosition(paramMenuItem.position);
    if (paramMenuItem == null)
    {
      y.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
      return;
    }
    if (paramInt == 1)
    {
      a.a(this, getString(a.i.collect_main_add_desc_title), paramMenuItem.nvB, "", 32, new BankRemitSelectPayeeUI.4(this, paramMenuItem), new BankRemitSelectPayeeUI.5(this));
      return;
    }
    if (paramInt == 0)
    {
      paramMenuItem = paramMenuItem.nvy;
      y.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
      a(new f(paramMenuItem), true, false);
      h.nFQ.f(14673, new Object[] { Integer.valueOf(7) });
      return;
    }
    y.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI
 * JD-Core Version:    0.7.0.1
 */