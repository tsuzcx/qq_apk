package com.tencent.mm.plugin.remittance.bankcard.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.e;
import com.tencent.mm.plugin.remittance.bankcard.b.i;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.protocal.protobuf.ekl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BankRemitHistoryUI
  extends BankRemitBaseUI
  implements u.i
{
  private ListView Oeg;
  private a Oeh;
  private int limit;
  private int offset;
  private boolean pIR;
  private boolean pIS;
  private l sLE;
  private View xWS;
  private List<dab> xti;
  
  public BankRemitHistoryUI()
  {
    AppMethodBeat.i(67534);
    this.xti = new ArrayList();
    this.pIR = false;
    this.pIS = false;
    this.limit = 20;
    this.offset = 0;
    AppMethodBeat.o(67534);
  }
  
  private void fetchData()
  {
    AppMethodBeat.i(67541);
    Log.i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", new Object[] { Integer.valueOf(this.limit), Integer.valueOf(this.offset) });
    this.pIR = true;
    i locali = new i(this.limit, this.offset);
    locali.r(this);
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
    this.Oeg = ((ListView)findViewById(a.f.brhu_lv));
    this.xWS = LayoutInflater.from(this).inflate(a.g.aa_record_list_loading_more, null);
    this.sLE = new l(this);
    this.Oeh = new a((byte)0);
    this.Oeg.addFooterView(this.xWS);
    this.Oeg.setAdapter(this.Oeh);
    this.Oeg.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67520);
        Log.d("MicroMsg.BankRemitHistoryUI", "click item, %s", new Object[] { ((dab)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt)).title });
        BankRemitHistoryUI.a(BankRemitHistoryUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BankRemitHistoryUI.this, BankRemitHistoryUI.this);
        AppMethodBeat.o(67520);
        return false;
      }
    });
    this.Oeg.setOnScrollListener(new AbsListView.OnScrollListener()
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
    localObject = (dab)this.Oeg.getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if ((paramMenuItem.getItemId() == 1) && (localObject != null))
    {
      paramMenuItem = ((dab)localObject).YYi;
      Log.i("MicroMsg.BankRemitHistoryUI", "delete record: %s", new Object[] { paramMenuItem });
      paramMenuItem = new e(paramMenuItem);
      paramMenuItem.r(this);
      doSceneProgress(paramMenuItem);
    }
    AppMethodBeat.o(67538);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(67539);
    if ((paramp instanceof i))
    {
      paramString = (i)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(67524);
          if (paramString.Oci.aaCO != null)
          {
            Log.i("MicroMsg.BankRemitHistoryUI", "history size: %s", new Object[] { Integer.valueOf(paramString.Oci.aaCO.size()) });
            if (paramString.Oci.aaCO.size() < paramString.limit)
            {
              Log.i("MicroMsg.BankRemitHistoryUI", "is last: %s", new Object[] { Integer.valueOf(BankRemitHistoryUI.f(BankRemitHistoryUI.this)) });
              BankRemitHistoryUI.g(BankRemitHistoryUI.this);
              BankRemitHistoryUI.b(BankRemitHistoryUI.this).removeFooterView(BankRemitHistoryUI.h(BankRemitHistoryUI.this));
            }
            if (paramString.Oci.aaCO != null)
            {
              BankRemitHistoryUI.a(BankRemitHistoryUI.this, paramString.Oci.aaCO.size());
              BankRemitHistoryUI.i(BankRemitHistoryUI.this).addAll(paramString.Oci.aaCO);
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
      }).b(new BankRemitHistoryUI.4(this, paramString)).c(new BankRemitHistoryUI.3(this));
      this.pIR = false;
    }
    for (;;)
    {
      AppMethodBeat.o(67539);
      return false;
      if ((paramp instanceof e))
      {
        paramString = (e)paramp;
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
    private SimpleDateFormat NAb;
    
    private a()
    {
      AppMethodBeat.i(67528);
      this.NAb = new SimpleDateFormat(BankRemitHistoryUI.this.getContext().getString(a.i.bank_remit_history_date_format_pattern));
      AppMethodBeat.o(67528);
    }
    
    private String iY(long paramLong)
    {
      AppMethodBeat.i(67532);
      String str = this.NAb.format(new Date(1000L * paramLong));
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
      paramViewGroup = (dab)getItem(paramInt);
      String str = iY(paramViewGroup.aaFw);
      if (paramInt == 0) {
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          paramView.DGu.setText(str);
          paramView.DGu.setVisibility(0);
          label105:
          paramView.Oem.setUrl(paramViewGroup.Ocp);
          paramView.descTv.setText(paramViewGroup.title);
          paramView.Oel.setText(paramViewGroup.aaFx);
          paramView.pIJ.setText(paramViewGroup.aaFv);
          if (Util.isNullOrNil(paramViewGroup.aaFy)) {
            break label253;
          }
          if (!Util.isNullOrNil(paramViewGroup.aaFz)) {
            paramView.Dip.setTextColor(n.dE(paramViewGroup.aaFz, true));
          }
          paramView.Dip.setText(paramViewGroup.aaFy);
          paramView.Dip.setVisibility(0);
        }
        for (;;)
        {
          AppMethodBeat.o(67531);
          return localView;
          if (str.equals(iY(((dab)getItem(paramInt - 1)).aaFw))) {
            break label265;
          }
          paramInt = 1;
          break;
          paramView.DGu.setVisibility(8);
          break label105;
          label253:
          paramView.Dip.setVisibility(8);
        }
        label265:
        paramInt = 0;
      }
    }
  }
  
  final class b
  {
    TextView DGu;
    TextView Dip;
    TextView Oel;
    CdnImageView Oem;
    TextView descTv;
    TextView pIJ;
    
    public b(View paramView)
    {
      AppMethodBeat.i(67533);
      this.DGu = ((TextView)paramView.findViewById(a.f.brhi_header_tv));
      this.descTv = ((TextView)paramView.findViewById(a.f.brhi_desc_tv));
      this.Oel = ((TextView)paramView.findViewById(a.f.brhi_money_tv));
      this.pIJ = ((TextView)paramView.findViewById(a.f.brhi_date_tv));
      this.Dip = ((TextView)paramView.findViewById(a.f.brhi_state_tv));
      this.Oem = ((CdnImageView)paramView.findViewById(a.f.brhi_bank_icon_iv));
      AppMethodBeat.o(67533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI
 * JD-Core Version:    0.7.0.1
 */