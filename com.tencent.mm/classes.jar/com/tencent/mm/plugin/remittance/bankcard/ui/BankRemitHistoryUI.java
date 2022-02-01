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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.g;
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
  implements o.g
{
  private ListView CkK;
  private a CkL;
  private boolean jUW;
  private boolean jUX;
  private int limit;
  private l mHj;
  private int offset;
  private List<cbs> qLE;
  private View rkW;
  
  public BankRemitHistoryUI()
  {
    AppMethodBeat.i(67534);
    this.qLE = new ArrayList();
    this.jUW = false;
    this.jUX = false;
    this.limit = 20;
    this.offset = 0;
    AppMethodBeat.o(67534);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(67541);
    Log.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", new Object[] { Integer.valueOf(this.limit), Integer.valueOf(this.offset) });
    this.jUW = true;
    i locali = new i(this.limit, this.offset);
    locali.t(this);
    doSceneProgress(locali, false);
    AppMethodBeat.o(67541);
  }
  
  public int getLayoutId()
  {
    return 2131493202;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67536);
    this.CkK = ((ListView)findViewById(2131297775));
    this.rkW = LayoutInflater.from(this).inflate(2131492904, null);
    this.mHj = new l(this);
    this.CkL = new a((byte)0);
    this.CkK.addFooterView(this.rkW);
    this.CkK.setAdapter(this.CkL);
    this.CkK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67520);
        Log.d("MicroMsg.BankRemitHistoryUI", "click item, %s", new Object[] { ((cbs)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).title });
        BankRemitHistoryUI.a(BankRemitHistoryUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BankRemitHistoryUI.this, BankRemitHistoryUI.this);
        AppMethodBeat.o(67520);
        return false;
      }
    });
    this.CkK.setOnScrollListener(new AbsListView.OnScrollListener()
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
    setMMTitle(2131756516);
    initView();
    fetchData();
    AppMethodBeat.o(67535);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(67537);
    paramContextMenu.add(0, 1, 0, 2131756533);
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
    localObject = (cbs)this.CkK.getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if ((paramMenuItem.getItemId() == 1) && (localObject != null))
    {
      paramMenuItem = ((cbs)localObject).KZa;
      Log.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", new Object[] { paramMenuItem });
      paramMenuItem = new e(paramMenuItem);
      paramMenuItem.t(this);
      doSceneProgress(paramMenuItem);
    }
    AppMethodBeat.o(67538);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(67539);
    if ((paramq instanceof i))
    {
      paramString = (i)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67524);
          if (paramString.CiQ.Mff != null)
          {
            Log.i("MicroMsg.BankRemitHistoryUI", "history size: %s", new Object[] { Integer.valueOf(paramString.CiQ.Mff.size()) });
            if (paramString.CiQ.Mff.size() < paramString.limit)
            {
              Log.i("MicroMsg.BankRemitHistoryUI", "is last: %s", new Object[] { Integer.valueOf(BankRemitHistoryUI.f(BankRemitHistoryUI.this)) });
              BankRemitHistoryUI.g(BankRemitHistoryUI.this);
              BankRemitHistoryUI.b(BankRemitHistoryUI.this).removeFooterView(BankRemitHistoryUI.h(BankRemitHistoryUI.this));
            }
            if (paramString.CiQ.Mff != null)
            {
              BankRemitHistoryUI.a(BankRemitHistoryUI.this, BankRemitHistoryUI.f(BankRemitHistoryUI.this) + paramString.CiQ.Mff.size());
              BankRemitHistoryUI.i(BankRemitHistoryUI.this).addAll(paramString.CiQ.Mff);
              BankRemitHistoryUI.j(BankRemitHistoryUI.this).notifyDataSetChanged();
              AppMethodBeat.o(67524);
            }
          }
          else
          {
            Log.i("MicroMsg.BankRemitHistoryUI", "return history is null");
            BankRemitHistoryUI.g(BankRemitHistoryUI.this);
            BankRemitHistoryUI.b(BankRemitHistoryUI.this).removeFooterView(BankRemitHistoryUI.h(BankRemitHistoryUI.this));
          }
          AppMethodBeat.o(67524);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67523);
          Log.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", new Object[] { Integer.valueOf(paramString.CiQ.dDN), paramString.CiQ.qwn });
          AppMethodBeat.o(67523);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67522);
          Log.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[] { paramAnonymousq });
          AppMethodBeat.o(67522);
        }
      });
      this.jUW = false;
    }
    for (;;)
    {
      AppMethodBeat.o(67539);
      return false;
      if ((paramq instanceof e))
      {
        paramString = (e)paramq;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67527);
            BankRemitHistoryUI.a(BankRemitHistoryUI.this, paramString.qvC);
            AppMethodBeat.o(67527);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67526);
            Log.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", new Object[] { Integer.valueOf(paramString.CiM.dDN), paramString.CiM.qwn });
            AppMethodBeat.o(67526);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67525);
            Log.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[] { paramAnonymousq });
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
    private SimpleDateFormat BGt;
    
    private a()
    {
      AppMethodBeat.i(67528);
      this.BGt = new SimpleDateFormat(BankRemitHistoryUI.this.getContext().getString(2131756515));
      AppMethodBeat.o(67528);
    }
    
    private String AF(long paramLong)
    {
      AppMethodBeat.i(67532);
      String str = this.BGt.format(new Date(1000L * paramLong));
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
        localView = LayoutInflater.from(BankRemitHistoryUI.this.getContext()).inflate(2131493201, paramViewGroup, false);
        localView.setTag(new BankRemitHistoryUI.b(BankRemitHistoryUI.this, localView));
      }
      paramView = (BankRemitHistoryUI.b)localView.getTag();
      paramViewGroup = (cbs)getItem(paramInt);
      String str = AF(paramViewGroup.Mhz);
      if (paramInt == 0) {
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          paramView.CkP.setText(str);
          paramView.CkP.setVisibility(0);
          label104:
          paramView.CkR.setUrl(paramViewGroup.CiX);
          paramView.hPW.setText(paramViewGroup.title);
          paramView.CkQ.setText(paramViewGroup.MhA);
          paramView.jUO.setText(paramViewGroup.Mhy);
          if (Util.isNullOrNil(paramViewGroup.MhB)) {
            break label252;
          }
          if (!Util.isNullOrNil(paramViewGroup.MhC)) {
            paramView.uzB.setTextColor(g.cI(paramViewGroup.MhC, true));
          }
          paramView.uzB.setText(paramViewGroup.MhB);
          paramView.uzB.setVisibility(0);
        }
        for (;;)
        {
          AppMethodBeat.o(67531);
          return localView;
          if (str.equals(AF(((cbs)getItem(paramInt - 1)).Mhz))) {
            break label264;
          }
          paramInt = 1;
          break;
          paramView.CkP.setVisibility(8);
          break label104;
          label252:
          paramView.uzB.setVisibility(8);
        }
        label264:
        paramInt = 0;
      }
    }
  }
  
  final class b
  {
    TextView CkP;
    TextView CkQ;
    CdnImageView CkR;
    TextView hPW;
    TextView jUO;
    TextView uzB;
    
    public b(View paramView)
    {
      AppMethodBeat.i(67533);
      this.CkP = ((TextView)paramView.findViewById(2131297772));
      this.hPW = ((TextView)paramView.findViewById(2131297771));
      this.CkQ = ((TextView)paramView.findViewById(2131297773));
      this.jUO = ((TextView)paramView.findViewById(2131297770));
      this.uzB = ((TextView)paramView.findViewById(2131297774));
      this.CkR = ((CdnImageView)paramView.findViewById(2131297768));
      AppMethodBeat.o(67533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI
 * JD-Core Version:    0.7.0.1
 */