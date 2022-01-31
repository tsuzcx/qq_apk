package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import java.util.ArrayList;
import java.util.List;

public class BankRemitHistoryUI
  extends BankRemitBaseUI
  implements n.d
{
  private boolean gpy;
  private boolean gpz;
  private l igW;
  private List<avb> lby;
  private int limit;
  private View lpY;
  private int offset;
  private ListView qhG;
  private BankRemitHistoryUI.a qhH;
  
  public BankRemitHistoryUI()
  {
    AppMethodBeat.i(44620);
    this.lby = new ArrayList();
    this.gpy = false;
    this.gpz = false;
    this.limit = 20;
    this.offset = 0;
    AppMethodBeat.o(44620);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(44627);
    ab.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", new Object[] { Integer.valueOf(this.limit), Integer.valueOf(this.offset) });
    this.gpy = true;
    i locali = new i(this.limit, this.offset);
    locali.o(this);
    doSceneProgress(locali, false);
    AppMethodBeat.o(44627);
  }
  
  public int getLayoutId()
  {
    return 2130968824;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44622);
    this.qhG = ((ListView)findViewById(2131821709));
    this.lpY = LayoutInflater.from(this).inflate(2130968581, null);
    this.igW = new l(this);
    this.qhH = new BankRemitHistoryUI.a(this, (byte)0);
    this.qhG.addFooterView(this.lpY);
    this.qhG.setAdapter(this.qhH);
    this.qhG.setOnItemLongClickListener(new BankRemitHistoryUI.1(this));
    this.qhG.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(44607);
        if ((BankRemitHistoryUI.b(BankRemitHistoryUI.this).getLastVisiblePosition() == BankRemitHistoryUI.b(BankRemitHistoryUI.this).getCount() - 1) && (BankRemitHistoryUI.b(BankRemitHistoryUI.this).getCount() > 0) && (!BankRemitHistoryUI.c(BankRemitHistoryUI.this)) && (!BankRemitHistoryUI.d(BankRemitHistoryUI.this))) {
          BankRemitHistoryUI.e(BankRemitHistoryUI.this);
        }
        AppMethodBeat.o(44607);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(44622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44621);
    super.onCreate(paramBundle);
    addSceneEndListener(1511);
    addSceneEndListener(1737);
    setMMTitle(2131297495);
    initView();
    fetchData();
    AppMethodBeat.o(44621);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(44623);
    paramContextMenu.add(0, 1, 0, 2131297512);
    AppMethodBeat.o(44623);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44626);
    super.onDestroy();
    removeSceneEndListener(1511);
    removeSceneEndListener(1737);
    AppMethodBeat.o(44626);
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(44624);
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    localObject = (avb)this.qhG.getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if ((paramMenuItem.getItemId() == 1) && (localObject != null))
    {
      paramMenuItem = ((avb)localObject).wBQ;
      ab.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", new Object[] { paramMenuItem });
      paramMenuItem = new e(paramMenuItem);
      paramMenuItem.o(this);
      doSceneProgress(paramMenuItem);
    }
    AppMethodBeat.o(44624);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    AppMethodBeat.i(44625);
    if ((paramm instanceof i))
    {
      paramString = (i)paramm;
      paramString.a(new BankRemitHistoryUI.5(this, paramString)).b(new BankRemitHistoryUI.4(this, paramString)).c(new BankRemitHistoryUI.3(this));
      this.gpy = false;
    }
    for (;;)
    {
      AppMethodBeat.o(44625);
      return false;
      if ((paramm instanceof e))
      {
        paramString = (e)paramm;
        paramString.a(new BankRemitHistoryUI.8(this, paramString)).b(new p.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
          {
            AppMethodBeat.i(44612);
            ab.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", new Object[] { Integer.valueOf(paramString.qfN.cnK), paramString.qfN.kNv });
            AppMethodBeat.o(44612);
          }
        }).c(new BankRemitHistoryUI.6(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
  {
    TextView gpp;
    TextView hsI;
    TextView qhL;
    TextView qhM;
    TextView qhN;
    CdnImageView qhO;
    
    public b(View paramView)
    {
      AppMethodBeat.i(44619);
      this.qhL = ((TextView)paramView.findViewById(2131821702));
      this.hsI = ((TextView)paramView.findViewById(2131821705));
      this.qhM = ((TextView)paramView.findViewById(2131821706));
      this.gpp = ((TextView)paramView.findViewById(2131821707));
      this.qhN = ((TextView)paramView.findViewById(2131821708));
      this.qhO = ((CdnImageView)paramView.findViewById(2131821704));
      AppMethodBeat.o(44619);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI
 * JD-Core Version:    0.7.0.1
 */