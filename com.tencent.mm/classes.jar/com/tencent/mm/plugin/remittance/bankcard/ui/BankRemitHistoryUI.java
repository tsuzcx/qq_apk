package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BankRemitHistoryUI
  extends BankRemitBaseUI
  implements n.e
{
  private boolean iVe;
  private boolean iVf;
  private int limit;
  private l lvx;
  private int offset;
  private View pNs;
  private List<boi> ppH;
  private ListView xTQ;
  private a xTR;
  
  public BankRemitHistoryUI()
  {
    AppMethodBeat.i(67534);
    this.ppH = new ArrayList();
    this.iVe = false;
    this.iVf = false;
    this.limit = 20;
    this.offset = 0;
    AppMethodBeat.o(67534);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(67541);
    ad.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", new Object[] { Integer.valueOf(this.limit), Integer.valueOf(this.offset) });
    this.iVe = true;
    i locali = new i(this.limit, this.offset);
    locali.t(this);
    doSceneProgress(locali, false);
    AppMethodBeat.o(67541);
  }
  
  public int getLayoutId()
  {
    return 2131493156;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67536);
    this.xTQ = ((ListView)findViewById(2131297549));
    this.pNs = LayoutInflater.from(this).inflate(2131492888, null);
    this.lvx = new l(this);
    this.xTR = new a((byte)0);
    this.xTQ.addFooterView(this.pNs);
    this.xTQ.setAdapter(this.xTR);
    this.xTQ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67520);
        ad.d("MicroMsg.BankRemitHistoryUI", "click item, %s", new Object[] { ((boi)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).title });
        BankRemitHistoryUI.a(BankRemitHistoryUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BankRemitHistoryUI.this, BankRemitHistoryUI.this);
        AppMethodBeat.o(67520);
        return false;
      }
    });
    this.xTQ.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(67521);
        if ((BankRemitHistoryUI.b(BankRemitHistoryUI.this).getLastVisiblePosition() == BankRemitHistoryUI.b(BankRemitHistoryUI.this).getCount() - 1) && (BankRemitHistoryUI.b(BankRemitHistoryUI.this).getCount() > 0) && (!BankRemitHistoryUI.c(BankRemitHistoryUI.this)) && (!BankRemitHistoryUI.d(BankRemitHistoryUI.this))) {
          BankRemitHistoryUI.e(BankRemitHistoryUI.this);
        }
        AppMethodBeat.o(67521);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(67536);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67535);
    super.onCreate(paramBundle);
    addSceneEndListener(1511);
    addSceneEndListener(1737);
    setMMTitle(2131756381);
    initView();
    fetchData();
    AppMethodBeat.o(67535);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(67537);
    paramContextMenu.add(0, 1, 0, 2131756398);
    AppMethodBeat.o(67537);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67540);
    super.onDestroy();
    removeSceneEndListener(1511);
    removeSceneEndListener(1737);
    AppMethodBeat.o(67540);
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(67538);
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    localObject = (boi)this.xTQ.getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if ((paramMenuItem.getItemId() == 1) && (localObject != null))
    {
      paramMenuItem = ((boi)localObject).FMk;
      ad.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", new Object[] { paramMenuItem });
      paramMenuItem = new e(paramMenuItem);
      paramMenuItem.t(this);
      doSceneProgress(paramMenuItem);
    }
    AppMethodBeat.o(67538);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(67539);
    if ((paramn instanceof i))
    {
      paramString = (i)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67524);
          if (paramString.xRW.GGD != null)
          {
            ad.i("MicroMsg.BankRemitHistoryUI", "history size: %s", new Object[] { Integer.valueOf(paramString.xRW.GGD.size()) });
            if (paramString.xRW.GGD.size() < paramString.limit)
            {
              ad.i("MicroMsg.BankRemitHistoryUI", "is last: %s", new Object[] { Integer.valueOf(BankRemitHistoryUI.f(BankRemitHistoryUI.this)) });
              BankRemitHistoryUI.g(BankRemitHistoryUI.this);
              BankRemitHistoryUI.b(BankRemitHistoryUI.this).removeFooterView(BankRemitHistoryUI.h(BankRemitHistoryUI.this));
            }
            if (paramString.xRW.GGD != null)
            {
              BankRemitHistoryUI.a(BankRemitHistoryUI.this, BankRemitHistoryUI.f(BankRemitHistoryUI.this) + paramString.xRW.GGD.size());
              BankRemitHistoryUI.i(BankRemitHistoryUI.this).addAll(paramString.xRW.GGD);
              BankRemitHistoryUI.j(BankRemitHistoryUI.this).notifyDataSetChanged();
              AppMethodBeat.o(67524);
            }
          }
          else
          {
            ad.i("MicroMsg.BankRemitHistoryUI", "return history is null");
            BankRemitHistoryUI.g(BankRemitHistoryUI.this);
            BankRemitHistoryUI.b(BankRemitHistoryUI.this).removeFooterView(BankRemitHistoryUI.h(BankRemitHistoryUI.this));
          }
          AppMethodBeat.o(67524);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67523);
          ad.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", new Object[] { Integer.valueOf(paramString.xRW.dlw), paramString.xRW.paA });
          AppMethodBeat.o(67523);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67522);
          ad.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(67522);
        }
      });
      this.iVe = false;
    }
    for (;;)
    {
      AppMethodBeat.o(67539);
      return false;
      if ((paramn instanceof e))
      {
        paramString = (e)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67527);
            BankRemitHistoryUI.a(BankRemitHistoryUI.this, paramString.oZN);
            AppMethodBeat.o(67527);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67526);
            ad.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", new Object[] { Integer.valueOf(paramString.xRS.dlw), paramString.xRS.paA });
            AppMethodBeat.o(67526);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67525);
            ad.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[] { paramAnonymousn });
            AppMethodBeat.o(67525);
          }
        });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private SimpleDateFormat xqx;
    
    private a()
    {
      AppMethodBeat.i(67528);
      this.xqx = new SimpleDateFormat(BankRemitHistoryUI.this.getContext().getString(2131756380));
      AppMethodBeat.o(67528);
    }
    
    private String sm(long paramLong)
    {
      AppMethodBeat.i(67532);
      String str = this.xqx.format(new Date(1000L * paramLong));
      AppMethodBeat.o(67532);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67529);
      int i = BankRemitHistoryUI.i(BankRemitHistoryUI.this).size();
      AppMethodBeat.o(67529);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(67530);
      Object localObject = BankRemitHistoryUI.i(BankRemitHistoryUI.this).get(paramInt);
      AppMethodBeat.o(67530);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(67531);
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(BankRemitHistoryUI.this.getContext()).inflate(2131493155, paramViewGroup, false);
        localView.setTag(new BankRemitHistoryUI.b(BankRemitHistoryUI.this, localView));
      }
      paramView = (BankRemitHistoryUI.b)localView.getTag();
      paramViewGroup = (boi)getItem(paramInt);
      String str = sm(paramViewGroup.GIV);
      if (paramInt == 0) {
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          paramView.xTV.setText(str);
          paramView.xTV.setVisibility(0);
          label104:
          paramView.xTY.setUrl(paramViewGroup.xSd);
          paramView.gUs.setText(paramViewGroup.title);
          paramView.xTW.setText(paramViewGroup.GIW);
          paramView.iUW.setText(paramViewGroup.GIU);
          if (bt.isNullOrNil(paramViewGroup.GIX)) {
            break label252;
          }
          if (!bt.isNullOrNil(paramViewGroup.GIY)) {
            paramView.xTX.setTextColor(g.cl(paramViewGroup.GIY, true));
          }
          paramView.xTX.setText(paramViewGroup.GIX);
          paramView.xTX.setVisibility(0);
        }
        for (;;)
        {
          AppMethodBeat.o(67531);
          return localView;
          if (str.equals(sm(((boi)getItem(paramInt - 1)).GIV))) {
            break label264;
          }
          paramInt = 1;
          break;
          paramView.xTV.setVisibility(8);
          break label104;
          label252:
          paramView.xTX.setVisibility(8);
        }
        label264:
        paramInt = 0;
      }
    }
  }
  
  final class b
  {
    TextView gUs;
    TextView iUW;
    TextView xTV;
    TextView xTW;
    TextView xTX;
    CdnImageView xTY;
    
    public b(View paramView)
    {
      AppMethodBeat.i(67533);
      this.xTV = ((TextView)paramView.findViewById(2131297546));
      this.gUs = ((TextView)paramView.findViewById(2131297545));
      this.xTW = ((TextView)paramView.findViewById(2131297547));
      this.iUW = ((TextView)paramView.findViewById(2131297544));
      this.xTX = ((TextView)paramView.findViewById(2131297548));
      this.xTY = ((CdnImageView)paramView.findViewById(2131297542));
      AppMethodBeat.o(67533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI
 * JD-Core Version:    0.7.0.1
 */