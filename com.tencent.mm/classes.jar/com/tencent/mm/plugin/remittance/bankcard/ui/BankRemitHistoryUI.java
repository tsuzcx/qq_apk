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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private boolean iXX;
  private boolean iXY;
  private int limit;
  private l lzV;
  private int offset;
  private View pTX;
  private List<bpa> pwn;
  private ListView yjJ;
  private a yjK;
  
  public BankRemitHistoryUI()
  {
    AppMethodBeat.i(67534);
    this.pwn = new ArrayList();
    this.iXX = false;
    this.iXY = false;
    this.limit = 20;
    this.offset = 0;
    AppMethodBeat.o(67534);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(67541);
    ae.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", new Object[] { Integer.valueOf(this.limit), Integer.valueOf(this.offset) });
    this.iXX = true;
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
    this.yjJ = ((ListView)findViewById(2131297549));
    this.pTX = LayoutInflater.from(this).inflate(2131492888, null);
    this.lzV = new l(this);
    this.yjK = new a((byte)0);
    this.yjJ.addFooterView(this.pTX);
    this.yjJ.setAdapter(this.yjK);
    this.yjJ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67520);
        ae.d("MicroMsg.BankRemitHistoryUI", "click item, %s", new Object[] { ((bpa)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).title });
        BankRemitHistoryUI.a(BankRemitHistoryUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BankRemitHistoryUI.this, BankRemitHistoryUI.this);
        AppMethodBeat.o(67520);
        return false;
      }
    });
    this.yjJ.setOnScrollListener(new AbsListView.OnScrollListener()
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
    localObject = (bpa)this.yjJ.getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if ((paramMenuItem.getItemId() == 1) && (localObject != null))
    {
      paramMenuItem = ((bpa)localObject).GeJ;
      ae.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", new Object[] { paramMenuItem });
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
          if (paramString.yhP.Haf != null)
          {
            ae.i("MicroMsg.BankRemitHistoryUI", "history size: %s", new Object[] { Integer.valueOf(paramString.yhP.Haf.size()) });
            if (paramString.yhP.Haf.size() < paramString.limit)
            {
              ae.i("MicroMsg.BankRemitHistoryUI", "is last: %s", new Object[] { Integer.valueOf(BankRemitHistoryUI.f(BankRemitHistoryUI.this)) });
              BankRemitHistoryUI.g(BankRemitHistoryUI.this);
              BankRemitHistoryUI.b(BankRemitHistoryUI.this).removeFooterView(BankRemitHistoryUI.h(BankRemitHistoryUI.this));
            }
            if (paramString.yhP.Haf != null)
            {
              BankRemitHistoryUI.a(BankRemitHistoryUI.this, BankRemitHistoryUI.f(BankRemitHistoryUI.this) + paramString.yhP.Haf.size());
              BankRemitHistoryUI.i(BankRemitHistoryUI.this).addAll(paramString.yhP.Haf);
              BankRemitHistoryUI.j(BankRemitHistoryUI.this).notifyDataSetChanged();
              AppMethodBeat.o(67524);
            }
          }
          else
          {
            ae.i("MicroMsg.BankRemitHistoryUI", "return history is null");
            BankRemitHistoryUI.g(BankRemitHistoryUI.this);
            BankRemitHistoryUI.b(BankRemitHistoryUI.this).removeFooterView(BankRemitHistoryUI.h(BankRemitHistoryUI.this));
          }
          AppMethodBeat.o(67524);
        }
      }).b(new BankRemitHistoryUI.4(this, paramString)).c(new BankRemitHistoryUI.3(this));
      this.iXX = false;
    }
    for (;;)
    {
      AppMethodBeat.o(67539);
      return false;
      if ((paramn instanceof e))
      {
        paramString = (e)paramn;
        paramString.a(new BankRemitHistoryUI.8(this, paramString)).b(new BankRemitHistoryUI.7(this, paramString)).c(new BankRemitHistoryUI.6(this));
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
    private SimpleDateFormat xGu;
    
    private a()
    {
      AppMethodBeat.i(67528);
      this.xGu = new SimpleDateFormat(BankRemitHistoryUI.this.getContext().getString(2131756380));
      AppMethodBeat.o(67528);
    }
    
    private String sz(long paramLong)
    {
      AppMethodBeat.i(67532);
      String str = this.xGu.format(new Date(1000L * paramLong));
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
      paramViewGroup = (bpa)getItem(paramInt);
      String str = sz(paramViewGroup.Hcw);
      if (paramInt == 0) {
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          paramView.yjO.setText(str);
          paramView.yjO.setVisibility(0);
          label104:
          paramView.yjR.setUrl(paramViewGroup.yhW);
          paramView.gXb.setText(paramViewGroup.title);
          paramView.yjP.setText(paramViewGroup.Hcx);
          paramView.iXP.setText(paramViewGroup.Hcv);
          if (bu.isNullOrNil(paramViewGroup.Hcy)) {
            break label252;
          }
          if (!bu.isNullOrNil(paramViewGroup.Hcz)) {
            paramView.yjQ.setTextColor(g.cp(paramViewGroup.Hcz, true));
          }
          paramView.yjQ.setText(paramViewGroup.Hcy);
          paramView.yjQ.setVisibility(0);
        }
        for (;;)
        {
          AppMethodBeat.o(67531);
          return localView;
          if (str.equals(sz(((bpa)getItem(paramInt - 1)).Hcw))) {
            break label264;
          }
          paramInt = 1;
          break;
          paramView.yjO.setVisibility(8);
          break label104;
          label252:
          paramView.yjQ.setVisibility(8);
        }
        label264:
        paramInt = 0;
      }
    }
  }
  
  final class b
  {
    TextView gXb;
    TextView iXP;
    TextView yjO;
    TextView yjP;
    TextView yjQ;
    CdnImageView yjR;
    
    public b(View paramView)
    {
      AppMethodBeat.i(67533);
      this.yjO = ((TextView)paramView.findViewById(2131297546));
      this.gXb = ((TextView)paramView.findViewById(2131297545));
      this.yjP = ((TextView)paramView.findViewById(2131297547));
      this.iXP = ((TextView)paramView.findViewById(2131297544));
      this.yjQ = ((TextView)paramView.findViewById(2131297548));
      this.yjR = ((CdnImageView)paramView.findViewById(2131297542));
      AppMethodBeat.o(67533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI
 * JD-Core Version:    0.7.0.1
 */