package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectPayeeUI
  extends BankRemitBaseUI
  implements n.d
{
  private l igW;
  private int qiA = -1;
  private int qiB = -1;
  private Intent qiC;
  private ListView qiv;
  private BankRemitSelectPayeeUI.b qiw;
  private List<TransferRecordParcel> qix;
  private ArrayList<TransferRecordParcel> qiy;
  private ArrayList<String> qiz;
  
  public int getLayoutId()
  {
    return 2130968833;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44690);
    this.qiv = ((ListView)findViewById(2131821731));
    this.igW = new l(this);
    this.qiw = new BankRemitSelectPayeeUI.b(this, (byte)0);
    this.qiv.setAdapter(this.qiw);
    this.qiv.setOnItemClickListener(new BankRemitSelectPayeeUI.1(this));
    this.qiv.setOnItemLongClickListener(new BankRemitSelectPayeeUI.3(this));
    AppMethodBeat.o(44690);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44689);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getParcelableArrayListExtra("key_self_transfer_record_list");
    Object localObject = getIntent().getParcelableArrayListExtra("key_freq_transfer_record_list");
    this.qix = new ArrayList();
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.qiA = 0;
      this.qix.addAll(paramBundle);
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.qiB = (this.qix.size() + this.qiA + 1);
      this.qix.addAll((Collection)localObject);
    }
    ab.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", new Object[] { Integer.valueOf(this.qiA), Integer.valueOf(this.qiB) });
    paramBundle = this.qix.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (TransferRecordParcel)paramBundle.next();
      ab.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", new Object[] { ((TransferRecordParcel)localObject).qgu, ((TransferRecordParcel)localObject).qgv, ((TransferRecordParcel)localObject).qfY, ((TransferRecordParcel)localObject).nLq, ((TransferRecordParcel)localObject).poq, ((TransferRecordParcel)localObject).qgw, ((TransferRecordParcel)localObject).qgx });
    }
    this.qiC = new Intent();
    initView();
    setMMTitle(2131297517);
    addSceneEndListener(1590);
    addSceneEndListener(1395);
    AppMethodBeat.o(44689);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(44691);
    paramContextMenu.add(0, 1, 0, 2131297515);
    paramContextMenu.add(0, 0, 0, 2131297512);
    AppMethodBeat.o(44691);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44693);
    super.onDestroy();
    removeSceneEndListener(1590);
    removeSceneEndListener(1395);
    AppMethodBeat.o(44693);
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(44692);
    paramInt = paramMenuItem.getItemId();
    paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    paramMenuItem = (TransferRecordParcel)this.qiv.getItemAtPosition(paramMenuItem.position);
    if (paramMenuItem == null)
    {
      ab.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
      AppMethodBeat.o(44692);
      return;
    }
    if (paramInt == 1)
    {
      a.a(this, getString(2131298441), paramMenuItem.qgx, "", 32, new BankRemitSelectPayeeUI.4(this, paramMenuItem), new BankRemitSelectPayeeUI.5(this));
      AppMethodBeat.o(44692);
      return;
    }
    if (paramInt == 0)
    {
      paramMenuItem = paramMenuItem.qgu;
      ab.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
      doSceneProgress(new f(paramMenuItem), true);
      h.qsU.e(14673, new Object[] { Integer.valueOf(7) });
      AppMethodBeat.o(44692);
      return;
    }
    ab.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(44692);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    AppMethodBeat.i(44694);
    if ((paramm instanceof j))
    {
      paramString = (j)paramm;
      paramString.a(new BankRemitSelectPayeeUI.8(this, paramString)).b(new BankRemitSelectPayeeUI.7(this, paramString)).c(new BankRemitSelectPayeeUI.6(this));
    }
    for (;;)
    {
      AppMethodBeat.o(44694);
      return false;
      if ((paramm instanceof f))
      {
        paramString = (f)paramm;
        paramString.a(new p.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
          {
            AppMethodBeat.i(44672);
            BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramString.qfK);
            AppMethodBeat.o(44672);
          }
        }).b(new BankRemitSelectPayeeUI.10(this, paramString)).c(new BankRemitSelectPayeeUI.9(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI
 * JD-Core Version:    0.7.0.1
 */