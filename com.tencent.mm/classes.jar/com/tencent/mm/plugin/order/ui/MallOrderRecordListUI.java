package com.tencent.mm.plugin.order.ui;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.acx.b;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.e;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI
  extends WalletBaseUI
{
  public boolean KzR;
  public a MFZ;
  protected List<com.tencent.mm.plugin.order.model.i> MGa;
  protected String MGb;
  public boolean MGc;
  protected Map<String, String> MGd;
  protected int Sc;
  protected boolean isLoading;
  public MMLoadMoreListView lNP;
  protected int mCount;
  protected MMHandler mHandler;
  protected Dialog mProgressDialog;
  
  public MallOrderRecordListUI()
  {
    AppMethodBeat.i(66767);
    this.mHandler = null;
    this.mProgressDialog = null;
    this.MFZ = null;
    this.MGa = new ArrayList();
    this.KzR = true;
    this.mCount = 0;
    this.Sc = 0;
    this.MGb = null;
    this.MGc = false;
    this.isLoading = false;
    this.MGd = new HashMap();
    AppMethodBeat.o(66767);
  }
  
  private boolean aRh(String paramString)
  {
    AppMethodBeat.i(66777);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66777);
      return false;
    }
    int i = 0;
    while (i < this.MGa.size())
    {
      com.tencent.mm.plugin.order.model.i locali = (com.tencent.mm.plugin.order.model.i)this.MGa.get(i);
      if ((locali != null) && (paramString.equals(locali.MEX)))
      {
        AppMethodBeat.o(66777);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66777);
    return false;
  }
  
  private static String ks(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66781);
    String str = paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(66781);
    return str;
  }
  
  protected final void afn(int paramInt)
  {
    AppMethodBeat.i(66775);
    if (paramInt >= this.MGa.size())
    {
      AppMethodBeat.o(66775);
      return;
    }
    com.tencent.mm.plugin.order.model.i locali = (com.tencent.mm.plugin.order.model.i)this.MGa.get(paramInt);
    if (locali != null)
    {
      Bundle localBundle = getInput();
      localBundle.putString("key_trans_id", locali.MEX);
      localBundle.putInt("key_pay_type", locali.MFe);
      localBundle.putString("bill_id", locali.MFp);
      com.tencent.mm.wallet_core.a.k(this, localBundle);
    }
    AppMethodBeat.o(66775);
  }
  
  protected String afo(int paramInt)
  {
    AppMethodBeat.i(66779);
    String str = com.tencent.mm.wallet_core.ui.i.aGz(paramInt);
    AppMethodBeat.o(66779);
    return str;
  }
  
  public int getLayoutId()
  {
    return a.g.mall_order_list;
  }
  
  protected void gxH()
  {
    AppMethodBeat.i(66769);
    addSceneEndListener(388);
    addSceneEndListener(389);
    AppMethodBeat.o(66769);
  }
  
  protected void gxI()
  {
    AppMethodBeat.i(66770);
    removeSceneEndListener(388);
    removeSceneEndListener(389);
    AppMethodBeat.o(66770);
  }
  
  protected void gxJ()
  {
    AppMethodBeat.i(66773);
    doSceneProgress(new e(this.Sc, this.MGb));
    AppMethodBeat.o(66773);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66774);
    if ((com.tencent.mm.wallet_core.a.cm(this) instanceof com.tencent.mm.plugin.order.a.a))
    {
      this.isLoading = true;
      gxJ();
    }
    setMMTitle(a.i.mall_index_ui_my_msg);
    this.lNP = ((MMLoadMoreListView)findViewById(a.f.mall_order_list_lv));
    this.MFZ = new a();
    this.lNP.setAdapter(this.MFZ);
    this.lNP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66756);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        MallOrderRecordListUI.this.afn(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.i.aGA(26);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(66756);
      }
    });
    this.lNP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66758);
        if (paramAnonymousInt >= MallOrderRecordListUI.this.MGa.size())
        {
          AppMethodBeat.o(66758);
          return true;
        }
        k.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(a.i.wallet_order_list_delete_order), null, MallOrderRecordListUI.this.getResources().getString(a.i.app_delete), new k.d()
        {
          public final void qz(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66757);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66757);
              return;
              com.tencent.mm.plugin.order.model.i locali = (com.tencent.mm.plugin.order.model.i)MallOrderRecordListUI.this.MGa.get(paramAnonymousInt);
              if (locali != null)
              {
                String str = locali.MEX;
                MallOrderRecordListUI.this.kL(str, locali.MFp);
              }
            }
          }
        });
        AppMethodBeat.o(66758);
        return true;
      }
    });
    this.lNP.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void onLoadMore()
      {
        AppMethodBeat.i(66759);
        if (!MallOrderRecordListUI.this.isLoading)
        {
          MallOrderRecordListUI.this.isLoading = true;
          MallOrderRecordListUI localMallOrderRecordListUI = MallOrderRecordListUI.this;
          localMallOrderRecordListUI.Sc += 10;
          MallOrderRecordListUI.this.gxJ();
        }
        AppMethodBeat.o(66759);
      }
    });
    Object localObject = new acx();
    ((acx)localObject).igk.scene = "6";
    ((acx)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66760);
        if (!Util.isNullOrNil(this.xer.igl.igm))
        {
          com.tencent.mm.wallet_core.ui.i.a(null, (TextView)MallOrderRecordListUI.this.findViewById(a.f.banner_tips), this.xer.igl.igm, this.xer.igl.content, this.xer.igl.url);
          AppMethodBeat.o(66760);
          return;
        }
        Log.i("MicroMsg.WalletOrderListUI", "no bulletin data");
        AppMethodBeat.o(66760);
      }
    };
    ((acx)localObject).publish();
    com.tencent.mm.plugin.order.a.b.gxv().onChange();
    this.MFZ.notifyDataSetChanged();
    localObject = h.OAn;
    com.tencent.mm.plugin.order.a.b.gxv();
    ((h)localObject).b(11036, new Object[] { Integer.valueOf(com.tencent.mm.plugin.order.a.b.gxy().gxC()) });
    AppMethodBeat.o(66774);
  }
  
  protected final void jq(List<com.tencent.mm.plugin.order.model.i> paramList)
  {
    AppMethodBeat.i(66776);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(66776);
      return;
    }
    if (this.MGa == null) {
      this.MGa = new ArrayList();
    }
    int i = 0;
    while (i < paramList.size())
    {
      com.tencent.mm.plugin.order.model.i locali = (com.tencent.mm.plugin.order.model.i)paramList.get(i);
      if (!aRh(locali.MEX)) {
        this.MGa.add(locali);
      }
      i += 1;
    }
    AppMethodBeat.o(66776);
  }
  
  protected final void jr(List<d> paramList)
  {
    AppMethodBeat.i(66780);
    if (paramList == null)
    {
      AppMethodBeat.o(66780);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      d locald = (d)paramList.get(i);
      if (locald != null)
      {
        String str = ks(locald.year, locald.month);
        this.MGd.put(str, locald.MER);
      }
      i += 1;
    }
    AppMethodBeat.o(66780);
  }
  
  protected void kL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66772);
    doSceneProgress(new g(paramString1, paramString2));
    AppMethodBeat.o(66772);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66768);
    super.onCreate(paramBundle);
    this.mHandler = new MMHandler();
    gxH();
    initView();
    this.Sc = 0;
    this.MGb = null;
    AppMethodBeat.o(66768);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66778);
    gxI();
    super.onDestroy();
    AppMethodBeat.o(66778);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66771);
    super.onResume();
    if (this.MFZ != null) {
      this.MFZ.notifyDataSetChanged();
    }
    AppMethodBeat.o(66771);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(66782);
    boolean bool;
    if ((paramp instanceof e))
    {
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (e)paramp;
      this.MGb = paramString.MEU;
      jq(paramString.MES);
      jr(paramString.MET);
      this.mCount = this.MGa.size();
      if (paramString.wYz > this.mCount)
      {
        bool = true;
        this.KzR = bool;
        this.MFZ.notifyDataSetChanged();
        Log.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
        Log.d("MicroMsg.WalletOrderListUI", "orders list total record: " + paramString.wYz);
        Log.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.KzR);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66761);
            if (MallOrderRecordListUI.this.KzR)
            {
              Log.v("MicroMsg.WalletOrderListUI", "has more");
              if (!MallOrderRecordListUI.this.MGc)
              {
                MallOrderRecordListUI.this.lNP.jms();
                MallOrderRecordListUI.this.lNP.setAdapter(MallOrderRecordListUI.this.MFZ);
                MallOrderRecordListUI.this.MGc = true;
              }
            }
            for (;;)
            {
              MallOrderRecordListUI.this.MFZ.notifyDataSetChanged();
              AppMethodBeat.o(66761);
              return;
              Log.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
              MallOrderRecordListUI.this.lNP.jmt();
            }
          }
        });
        this.isLoading = false;
        label202:
        if ((this.mCount > 0) || (this.MGa.size() != 0)) {
          break label445;
        }
        showOptionMenu(false);
        findViewById(a.f.empty_tip_layout).setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66782);
      return true;
      bool = false;
      break;
      if (!(paramp instanceof g)) {
        break label202;
      }
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (g)paramp;
      label324:
      if (paramString.gxD() == 2)
      {
        if (this.MGa != null) {
          this.MGa.clear();
        }
        this.mCount = 0;
        this.KzR = false;
        this.lNP.jmt();
      }
      for (;;)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66762);
            MallOrderRecordListUI.this.MFZ.notifyDataSetChanged();
            AppMethodBeat.o(66762);
          }
        });
        break;
        paramString = paramString.gxE();
        Log.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!Util.isNullOrNil(paramString))
        {
          paramp = this.MGa.iterator();
          if (paramp.hasNext())
          {
            com.tencent.mm.plugin.order.model.i locali = (com.tencent.mm.plugin.order.model.i)paramp.next();
            if (!paramString.equals(locali.MEX)) {
              break label324;
            }
            this.MGa.remove(locali);
            this.mCount = this.MGa.size();
          }
        }
      }
      label445:
      showOptionMenu(true);
      findViewById(a.f.empty_tip_layout).setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends BaseAdapter
  {
    protected a() {}
    
    private com.tencent.mm.plugin.order.model.i afp(int paramInt)
    {
      AppMethodBeat.i(66764);
      com.tencent.mm.plugin.order.model.i locali = (com.tencent.mm.plugin.order.model.i)MallOrderRecordListUI.this.MGa.get(paramInt);
      AppMethodBeat.o(66764);
      return locali;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66763);
      int i = MallOrderRecordListUI.this.MGa.size();
      AppMethodBeat.o(66763);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66765);
      View localView;
      com.tencent.mm.plugin.order.model.i locali;
      int i;
      Object localObject1;
      if (paramView == null)
      {
        localView = View.inflate(MallOrderRecordListUI.this, a.g.mall_order_list_item, null);
        paramViewGroup = new MallOrderRecordListUI.b(MallOrderRecordListUI.this, (byte)0);
        paramViewGroup.MGg = ((TextView)localView.findViewById(a.f.order_list_item_title_tv));
        paramViewGroup.MGi = ((TextView)localView.findViewById(a.f.order_list_item_time_tv));
        paramViewGroup.MGh = ((TextView)localView.findViewById(a.f.order_list_item_status_tv));
        paramViewGroup.MGj = ((TextView)localView.findViewById(a.f.order_list_item_product_price_tv));
        paramViewGroup.MGl = localView.findViewById(a.f.order_list_item_month_view);
        paramViewGroup.MGm = ((TextView)localView.findViewById(a.f.order_list_item_month_view_date));
        paramViewGroup.MGn = ((TextView)localView.findViewById(a.f.order_list_item_month_view_amount));
        paramViewGroup.MGk = ((TextView)localView.findViewById(a.f.order_list_item_product_real_pay_tv));
        localView.setTag(paramViewGroup);
        locali = afp(paramInt);
        i = 0;
        if (paramInt != 0) {
          break label606;
        }
        i = 1;
        paramView = afp(0);
        localObject1 = new GregorianCalendar();
        ((GregorianCalendar)localObject1).setTimeInMillis(paramView.CreateTime * 1000L);
        paramView = MallOrderRecordListUI.kt(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2) + 1);
      }
      for (;;)
      {
        for (;;)
        {
          if (i != 0)
          {
            localObject1 = new SimpleDateFormat(MallOrderRecordListUI.this.getString(a.i.fmt_year_month, new Object[] { "" })).format(new Date(afp(paramInt).CreateTime * 1000L));
            paramViewGroup.MGm.setText((CharSequence)localObject1);
            if ((!Util.isNullOrNil(paramView)) && (!Util.isNullOrNil((String)MallOrderRecordListUI.this.MGd.get(paramView)))) {
              paramViewGroup.MGn.setText((CharSequence)MallOrderRecordListUI.this.MGd.get(paramView));
            }
            paramViewGroup.MGl.setVisibility(0);
            label347:
            paramViewGroup.MGg.setText(locali.MEZ);
            paramViewGroup.MGh.setText(locali.MFa);
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(a.c.mall_order_detail_item_subtitle_color);
            paramInt = i;
            if (Util.isNullOrNil(locali.MFm)) {}
          }
          try
          {
            paramInt = n.dE(locali.MFm, true);
            paramViewGroup.MGh.setTextColor(paramInt);
            paramViewGroup.MGi.setText(MallOrderRecordListUI.this.afo(locali.CreateTime));
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(a.c.mall_order_detail_item_title_color);
            paramInt = i;
            if (Util.isNullOrNil(locali.MFn)) {}
          }
          catch (Exception paramView)
          {
            try
            {
              paramInt = n.dE(locali.MFn, true);
              if (locali.MEY != locali.MFo)
              {
                paramView = com.tencent.mm.wallet_core.ui.i.e(locali.MEY / 100.0D, locali.MFc);
                localObject1 = new SpannableString(paramView);
                ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), 0, paramView.length(), 33);
                paramViewGroup.MGj.setText((CharSequence)localObject1);
                paramViewGroup.MGk.setTextColor(paramInt);
                paramViewGroup.MGk.setText(com.tencent.mm.wallet_core.ui.i.e(locali.MFo / 100.0D, locali.MFc));
                AppMethodBeat.o(66765);
                return localView;
                paramViewGroup = (MallOrderRecordListUI.b)paramView.getTag();
                localView = paramView;
                break;
                label606:
                paramView = afp(paramInt);
                Object localObject2 = afp(paramInt - 1);
                if ((paramView.CreateTime <= 0) || (((com.tencent.mm.plugin.order.model.i)localObject2).CreateTime <= 0)) {
                  break label835;
                }
                localObject1 = new GregorianCalendar();
                ((GregorianCalendar)localObject1).setTimeInMillis(((com.tencent.mm.plugin.order.model.i)localObject2).CreateTime * 1000L);
                localObject2 = new GregorianCalendar();
                ((GregorianCalendar)localObject2).setTimeInMillis(paramView.CreateTime * 1000L);
                if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(2) == ((GregorianCalendar)localObject2).get(2))) {
                  break label835;
                }
                i = 1;
                paramView = MallOrderRecordListUI.kt(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2) + 1);
                continue;
                paramViewGroup.MGl.setVisibility(8);
                break label347;
                paramView = paramView;
                Log.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + Util.nullAsNil(locali.MFm));
                paramInt = i;
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                Log.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + Util.nullAsNil(locali.MFn));
                paramInt = i;
                continue;
                paramViewGroup.MGj.setText("");
              }
              label835:
              paramView = null;
            }
          }
        }
      }
    }
  }
  
  final class b
  {
    TextView MGg;
    TextView MGh;
    TextView MGi;
    TextView MGj;
    TextView MGk;
    View MGl;
    TextView MGm;
    TextView MGn;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */