package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.protocal.protobuf.drq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BankRemitHistoryUI
  extends BankRemitBaseUI
  implements q.g
{
  private ListView IhD;
  private a IhE;
  private int limit;
  private boolean mMj;
  private boolean mMk;
  private int offset;
  private m pGE;
  private View uOi;
  private List<cjv> umQ;
  
  public BankRemitHistoryUI()
  {
    AppMethodBeat.i(67534);
    this.umQ = new ArrayList();
    this.mMj = false;
    this.mMk = false;
    this.limit = 20;
    this.offset = 0;
    AppMethodBeat.o(67534);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(67541);
    Log.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", new Object[] { Integer.valueOf(this.limit), Integer.valueOf(this.offset) });
    this.mMj = true;
    i locali = new i(this.limit, this.offset);
    locali.u(this);
    doSceneProgress(locali, false);
    AppMethodBeat.o(67541);
  }
  
  public int getLayoutId()
  {
    return a.g.bank_remit_history_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67536);
    this.IhD = ((ListView)findViewById(a.f.brhu_lv));
    this.uOi = LayoutInflater.from(this).inflate(a.g.aa_record_list_loading_more, null);
    this.pGE = new m(this);
    this.IhE = new a((byte)0);
    this.IhD.addFooterView(this.uOi);
    this.IhD.setAdapter(this.IhE);
    this.IhD.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67520);
        Log.d("MicroMsg.BankRemitHistoryUI", "click item, %s", new Object[] { ((cjv)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).title });
        BankRemitHistoryUI.a(BankRemitHistoryUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BankRemitHistoryUI.this, BankRemitHistoryUI.this);
        AppMethodBeat.o(67520);
        return false;
      }
    });
    this.IhD.setOnScrollListener(new AbsListView.OnScrollListener()
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
    setMMTitle(a.i.bank_remit_history_title);
    initView();
    fetchData();
    AppMethodBeat.o(67535);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(67537);
    paramContextMenu.add(0, 1, 0, a.i.bank_remit_select_payee_delete_text);
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
    localObject = (cjv)this.IhD.getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if ((paramMenuItem.getItemId() == 1) && (localObject != null))
    {
      paramMenuItem = ((cjv)localObject).Saj;
      Log.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", new Object[] { paramMenuItem });
      paramMenuItem = new e(paramMenuItem);
      paramMenuItem.u(this);
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
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67524);
          if (paramString.IfJ.ToH != null)
          {
            Log.i("MicroMsg.BankRemitHistoryUI", "history size: %s", new Object[] { Integer.valueOf(paramString.IfJ.ToH.size()) });
            if (paramString.IfJ.ToH.size() < paramString.limit)
            {
              Log.i("MicroMsg.BankRemitHistoryUI", "is last: %s", new Object[] { Integer.valueOf(BankRemitHistoryUI.f(BankRemitHistoryUI.this)) });
              BankRemitHistoryUI.g(BankRemitHistoryUI.this);
              BankRemitHistoryUI.b(BankRemitHistoryUI.this).removeFooterView(BankRemitHistoryUI.h(BankRemitHistoryUI.this));
            }
            if (paramString.IfJ.ToH != null)
            {
              BankRemitHistoryUI.a(BankRemitHistoryUI.this, BankRemitHistoryUI.f(BankRemitHistoryUI.this) + paramString.IfJ.ToH.size());
              BankRemitHistoryUI.i(BankRemitHistoryUI.this).addAll(paramString.IfJ.ToH);
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
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67523);
          Log.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", new Object[] { Integer.valueOf(paramString.IfJ.fwx), paramString.IfJ.tVo });
          AppMethodBeat.o(67523);
        }
      }).c(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67522);
          Log.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[] { paramAnonymousq });
          AppMethodBeat.o(67522);
        }
      });
      this.mMj = false;
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
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67527);
            BankRemitHistoryUI.a(BankRemitHistoryUI.this, paramString.tUB);
            AppMethodBeat.o(67527);
          }
        }).b(new r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67526);
            Log.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", new Object[] { Integer.valueOf(paramString.IfF.fwx), paramString.IfF.tVo });
            AppMethodBeat.o(67526);
          }
        }).c(new r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
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
    private SimpleDateFormat HCy;
    
    private a()
    {
      AppMethodBeat.i(67528);
      this.HCy = new SimpleDateFormat(BankRemitHistoryUI.this.getContext().getString(a.i.bank_remit_history_date_format_pattern));
      AppMethodBeat.o(67528);
    }
    
    private String GN(long paramLong)
    {
      AppMethodBeat.i(67532);
      String str = this.HCy.format(new Date(1000L * paramLong));
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
        localView = LayoutInflater.from(BankRemitHistoryUI.this.getContext()).inflate(a.g.bank_remit_history_item, paramViewGroup, false);
        localView.setTag(new BankRemitHistoryUI.b(BankRemitHistoryUI.this, localView));
      }
      paramView = (BankRemitHistoryUI.b)localView.getTag();
      paramViewGroup = (cjv)getItem(paramInt);
      String str = GN(paramViewGroup.Trm);
      if (paramInt == 0) {
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          paramView.IhI.setText(str);
          paramView.IhI.setVisibility(0);
          label105:
          paramView.IhK.setUrl(paramViewGroup.IfQ);
          paramView.kEs.setText(paramViewGroup.title);
          paramView.IhJ.setText(paramViewGroup.Trn);
          paramView.mMb.setText(paramViewGroup.Trl);
          if (Util.isNullOrNil(paramViewGroup.Tro)) {
            break label253;
          }
          if (!Util.isNullOrNil(paramViewGroup.Trp)) {
            paramView.yVc.setTextColor(k.cW(paramViewGroup.Trp, true));
          }
          paramView.yVc.setText(paramViewGroup.Tro);
          paramView.yVc.setVisibility(0);
        }
        for (;;)
        {
          AppMethodBeat.o(67531);
          return localView;
          if (str.equals(GN(((cjv)getItem(paramInt - 1)).Trm))) {
            break label265;
          }
          paramInt = 1;
          break;
          paramView.IhI.setVisibility(8);
          break label105;
          label253:
          paramView.yVc.setVisibility(8);
        }
        label265:
        paramInt = 0;
      }
    }
  }
  
  final class b
  {
    TextView IhI;
    TextView IhJ;
    CdnImageView IhK;
    TextView kEs;
    TextView mMb;
    TextView yVc;
    
    public b(View paramView)
    {
      AppMethodBeat.i(67533);
      this.IhI = ((TextView)paramView.findViewById(a.f.brhi_header_tv));
      this.kEs = ((TextView)paramView.findViewById(a.f.brhi_desc_tv));
      this.IhJ = ((TextView)paramView.findViewById(a.f.brhi_money_tv));
      this.mMb = ((TextView)paramView.findViewById(a.f.brhi_date_tv));
      this.yVc = ((TextView)paramView.findViewById(a.f.brhi_state_tv));
      this.IhK = ((CdnImageView)paramView.findViewById(a.f.brhi_bank_icon_iv));
      AppMethodBeat.o(67533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI
 * JD-Core Version:    0.7.0.1
 */