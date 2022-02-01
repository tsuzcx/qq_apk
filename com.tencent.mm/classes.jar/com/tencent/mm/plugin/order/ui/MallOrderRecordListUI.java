package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
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
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.aba.b;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.e;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.h.d;
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
  public boolean EGI;
  public a GJk;
  protected List<i> GJl;
  protected String GJm;
  public boolean GJn;
  protected Map<String, String> GJo;
  protected boolean isLoading;
  public MMLoadMoreListView jkX;
  protected int mCount;
  protected MMHandler mHandler;
  protected Dialog mProgressDialog;
  protected int zP;
  
  public MallOrderRecordListUI()
  {
    AppMethodBeat.i(66767);
    this.mHandler = null;
    this.mProgressDialog = null;
    this.GJk = null;
    this.GJl = new ArrayList();
    this.EGI = true;
    this.mCount = 0;
    this.zP = 0;
    this.GJm = null;
    this.GJn = false;
    this.isLoading = false;
    this.GJo = new HashMap();
    AppMethodBeat.o(66767);
  }
  
  private boolean aUb(String paramString)
  {
    AppMethodBeat.i(66777);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66777);
      return false;
    }
    int i = 0;
    while (i < this.GJl.size())
    {
      i locali = (i)this.GJl.get(i);
      if ((locali != null) && (paramString.equals(locali.GIh)))
      {
        AppMethodBeat.o(66777);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66777);
    return false;
  }
  
  private static String iM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66781);
    String str = paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(66781);
    return str;
  }
  
  protected final void aaV(int paramInt)
  {
    AppMethodBeat.i(66775);
    if (paramInt >= this.GJl.size())
    {
      AppMethodBeat.o(66775);
      return;
    }
    i locali = (i)this.GJl.get(paramInt);
    if (locali != null)
    {
      Bundle localBundle = getInput();
      localBundle.putString("key_trans_id", locali.GIh);
      localBundle.putInt("key_pay_type", locali.GIo);
      localBundle.putString("bill_id", locali.GIz);
      com.tencent.mm.wallet_core.a.l(this, localBundle);
    }
    AppMethodBeat.o(66775);
  }
  
  protected String aaW(int paramInt)
  {
    AppMethodBeat.i(66779);
    String str = com.tencent.mm.wallet_core.ui.g.azJ(paramInt);
    AppMethodBeat.o(66779);
    return str;
  }
  
  protected void fmT()
  {
    AppMethodBeat.i(66769);
    addSceneEndListener(388);
    addSceneEndListener(389);
    AppMethodBeat.o(66769);
  }
  
  protected void fmU()
  {
    AppMethodBeat.i(66770);
    removeSceneEndListener(388);
    removeSceneEndListener(389);
    AppMethodBeat.o(66770);
  }
  
  protected void fmV()
  {
    AppMethodBeat.i(66773);
    doSceneProgress(new e(this.zP, this.GJm));
    AppMethodBeat.o(66773);
  }
  
  public int getLayoutId()
  {
    return a.g.mall_order_list;
  }
  
  protected final void gq(List<i> paramList)
  {
    AppMethodBeat.i(66776);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(66776);
      return;
    }
    if (this.GJl == null) {
      this.GJl = new ArrayList();
    }
    int i = 0;
    while (i < paramList.size())
    {
      i locali = (i)paramList.get(i);
      if (!aUb(locali.GIh)) {
        this.GJl.add(locali);
      }
      i += 1;
    }
    AppMethodBeat.o(66776);
  }
  
  protected final void gr(List<d> paramList)
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
        String str = iM(locald.year, locald.month);
        this.GJo.put(str, locald.GIb);
      }
      i += 1;
    }
    AppMethodBeat.o(66780);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66774);
    if ((com.tencent.mm.wallet_core.a.bF(this) instanceof com.tencent.mm.plugin.order.a.a))
    {
      this.isLoading = true;
      fmV();
    }
    setMMTitle(a.i.mall_index_ui_my_msg);
    this.jkX = ((MMLoadMoreListView)findViewById(a.f.mall_order_list_lv));
    this.GJk = new a();
    this.jkX.setAdapter(this.GJk);
    this.jkX.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66756);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        MallOrderRecordListUI.this.aaV(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.g.azK(26);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(66756);
      }
    });
    this.jkX.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66758);
        if (paramAnonymousInt >= MallOrderRecordListUI.this.GJl.size())
        {
          AppMethodBeat.o(66758);
          return true;
        }
        com.tencent.mm.ui.base.h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(a.i.wallet_order_list_delete_order), null, MallOrderRecordListUI.this.getResources().getString(a.i.app_delete), new h.d()
        {
          public final void qy(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66757);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66757);
              return;
              i locali = (i)MallOrderRecordListUI.this.GJl.get(paramAnonymousInt);
              if (locali != null)
              {
                String str = locali.GIh;
                MallOrderRecordListUI.this.ju(str, locali.GIz);
              }
            }
          }
        });
        AppMethodBeat.o(66758);
        return true;
      }
    });
    this.jkX.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void onLoadMore()
      {
        AppMethodBeat.i(66759);
        if (!MallOrderRecordListUI.this.isLoading)
        {
          MallOrderRecordListUI.this.isLoading = true;
          MallOrderRecordListUI localMallOrderRecordListUI = MallOrderRecordListUI.this;
          localMallOrderRecordListUI.zP += 10;
          MallOrderRecordListUI.this.fmV();
        }
        AppMethodBeat.o(66759);
      }
    });
    Object localObject = new aba();
    ((aba)localObject).gac.scene = "6";
    ((aba)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66760);
        if (!Util.isNullOrNil(this.uaN.gad.gae))
        {
          com.tencent.mm.wallet_core.ui.g.a((TextView)MallOrderRecordListUI.this.findViewById(a.f.banner_tips), this.uaN.gad.gae, this.uaN.gad.content, this.uaN.gad.url);
          AppMethodBeat.o(66760);
          return;
        }
        Log.i("MicroMsg.WalletOrderListUI", "no bulletin data");
        AppMethodBeat.o(66760);
      }
    };
    EventCenter.instance.publish((IEvent)localObject);
    com.tencent.mm.plugin.order.a.b.fmH().onChange();
    this.GJk.notifyDataSetChanged();
    localObject = com.tencent.mm.plugin.report.service.h.IzE;
    com.tencent.mm.plugin.order.a.b.fmH();
    ((com.tencent.mm.plugin.report.service.h)localObject).a(11036, new Object[] { Integer.valueOf(com.tencent.mm.plugin.order.a.b.fmK().fmO()) });
    AppMethodBeat.o(66774);
  }
  
  protected void ju(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66772);
    doSceneProgress(new com.tencent.mm.plugin.order.model.g(paramString1, paramString2));
    AppMethodBeat.o(66772);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66768);
    super.onCreate(paramBundle);
    this.mHandler = new MMHandler();
    fmT();
    initView();
    this.zP = 0;
    this.GJm = null;
    AppMethodBeat.o(66768);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66778);
    fmU();
    super.onDestroy();
    AppMethodBeat.o(66778);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66771);
    super.onResume();
    if (this.GJk != null) {
      this.GJk.notifyDataSetChanged();
    }
    AppMethodBeat.o(66771);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66782);
    boolean bool;
    if ((paramq instanceof e))
    {
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (e)paramq;
      this.GJm = paramString.GIe;
      gq(paramString.GIc);
      gr(paramString.GId);
      this.mCount = this.GJl.size();
      if (paramString.tVd > this.mCount)
      {
        bool = true;
        this.EGI = bool;
        this.GJk.notifyDataSetChanged();
        Log.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
        Log.d("MicroMsg.WalletOrderListUI", "orders list total record: " + paramString.tVd);
        Log.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.EGI);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66761);
            if (MallOrderRecordListUI.this.EGI)
            {
              Log.v("MicroMsg.WalletOrderListUI", "has more");
              if (!MallOrderRecordListUI.this.GJn)
              {
                MallOrderRecordListUI.this.jkX.hJK();
                MallOrderRecordListUI.this.jkX.setAdapter(MallOrderRecordListUI.this.GJk);
                MallOrderRecordListUI.this.GJn = true;
              }
            }
            for (;;)
            {
              MallOrderRecordListUI.this.GJk.notifyDataSetChanged();
              AppMethodBeat.o(66761);
              return;
              Log.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
              MallOrderRecordListUI.this.jkX.hJL();
            }
          }
        });
        this.isLoading = false;
        label202:
        if ((this.mCount > 0) || (this.GJl.size() != 0)) {
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
      if (!(paramq instanceof com.tencent.mm.plugin.order.model.g)) {
        break label202;
      }
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (com.tencent.mm.plugin.order.model.g)paramq;
      label324:
      if (paramString.fmP() == 2)
      {
        if (this.GJl != null) {
          this.GJl.clear();
        }
        this.mCount = 0;
        this.EGI = false;
        this.jkX.hJL();
      }
      for (;;)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66762);
            MallOrderRecordListUI.this.GJk.notifyDataSetChanged();
            AppMethodBeat.o(66762);
          }
        });
        break;
        paramString = paramString.fmQ();
        Log.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!Util.isNullOrNil(paramString))
        {
          paramq = this.GJl.iterator();
          if (paramq.hasNext())
          {
            i locali = (i)paramq.next();
            if (!paramString.equals(locali.GIh)) {
              break label324;
            }
            this.GJl.remove(locali);
            this.mCount = this.GJl.size();
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
    
    private i aaX(int paramInt)
    {
      AppMethodBeat.i(66764);
      i locali = (i)MallOrderRecordListUI.this.GJl.get(paramInt);
      AppMethodBeat.o(66764);
      return locali;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66763);
      int i = MallOrderRecordListUI.this.GJl.size();
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
      i locali;
      int i;
      Object localObject1;
      if (paramView == null)
      {
        localView = View.inflate(MallOrderRecordListUI.this, a.g.mall_order_list_item, null);
        paramViewGroup = new MallOrderRecordListUI.b(MallOrderRecordListUI.this, (byte)0);
        paramViewGroup.GJr = ((TextView)localView.findViewById(a.f.order_list_item_title_tv));
        paramViewGroup.GJt = ((TextView)localView.findViewById(a.f.order_list_item_time_tv));
        paramViewGroup.GJs = ((TextView)localView.findViewById(a.f.order_list_item_status_tv));
        paramViewGroup.GJu = ((TextView)localView.findViewById(a.f.order_list_item_product_price_tv));
        paramViewGroup.GJw = localView.findViewById(a.f.order_list_item_month_view);
        paramViewGroup.GJx = ((TextView)localView.findViewById(a.f.order_list_item_month_view_date));
        paramViewGroup.GJy = ((TextView)localView.findViewById(a.f.order_list_item_month_view_amount));
        paramViewGroup.GJv = ((TextView)localView.findViewById(a.f.order_list_item_product_real_pay_tv));
        localView.setTag(paramViewGroup);
        locali = aaX(paramInt);
        i = 0;
        if (paramInt != 0) {
          break label606;
        }
        i = 1;
        paramView = aaX(0);
        localObject1 = new GregorianCalendar();
        ((GregorianCalendar)localObject1).setTimeInMillis(paramView.CreateTime * 1000L);
        paramView = MallOrderRecordListUI.iN(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2) + 1);
      }
      for (;;)
      {
        for (;;)
        {
          if (i != 0)
          {
            localObject1 = new SimpleDateFormat(MallOrderRecordListUI.this.getString(a.i.fmt_year_month, new Object[] { "" })).format(new Date(aaX(paramInt).CreateTime * 1000L));
            paramViewGroup.GJx.setText((CharSequence)localObject1);
            if ((!Util.isNullOrNil(paramView)) && (!Util.isNullOrNil((String)MallOrderRecordListUI.this.GJo.get(paramView)))) {
              paramViewGroup.GJy.setText((CharSequence)MallOrderRecordListUI.this.GJo.get(paramView));
            }
            paramViewGroup.GJw.setVisibility(0);
            label347:
            paramViewGroup.GJr.setText(locali.GIj);
            paramViewGroup.GJs.setText(locali.GIk);
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(a.c.mall_order_detail_item_subtitle_color);
            paramInt = i;
            if (Util.isNullOrNil(locali.GIw)) {}
          }
          try
          {
            paramInt = k.cW(locali.GIw, true);
            paramViewGroup.GJs.setTextColor(paramInt);
            paramViewGroup.GJt.setText(MallOrderRecordListUI.this.aaW(locali.CreateTime));
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(a.c.mall_order_detail_item_title_color);
            paramInt = i;
            if (Util.isNullOrNil(locali.GIx)) {}
          }
          catch (Exception paramView)
          {
            try
            {
              paramInt = k.cW(locali.GIx, true);
              if (locali.GIi != locali.GIy)
              {
                paramView = com.tencent.mm.wallet_core.ui.g.d(locali.GIi / 100.0D, locali.GIm);
                localObject1 = new SpannableString(paramView);
                ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), 0, paramView.length(), 33);
                paramViewGroup.GJu.setText((CharSequence)localObject1);
                paramViewGroup.GJv.setTextColor(paramInt);
                paramViewGroup.GJv.setText(com.tencent.mm.wallet_core.ui.g.d(locali.GIy / 100.0D, locali.GIm));
                AppMethodBeat.o(66765);
                return localView;
                paramViewGroup = (MallOrderRecordListUI.b)paramView.getTag();
                localView = paramView;
                break;
                label606:
                paramView = aaX(paramInt);
                Object localObject2 = aaX(paramInt - 1);
                if ((paramView.CreateTime <= 0) || (((i)localObject2).CreateTime <= 0)) {
                  break label835;
                }
                localObject1 = new GregorianCalendar();
                ((GregorianCalendar)localObject1).setTimeInMillis(((i)localObject2).CreateTime * 1000L);
                localObject2 = new GregorianCalendar();
                ((GregorianCalendar)localObject2).setTimeInMillis(paramView.CreateTime * 1000L);
                if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(2) == ((GregorianCalendar)localObject2).get(2))) {
                  break label835;
                }
                i = 1;
                paramView = MallOrderRecordListUI.iN(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2) + 1);
                continue;
                paramViewGroup.GJw.setVisibility(8);
                break label347;
                paramView = paramView;
                Log.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + Util.nullAsNil(locali.GIw));
                paramInt = i;
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                Log.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + Util.nullAsNil(locali.GIx));
                paramInt = i;
                continue;
                paramViewGroup.GJu.setText("");
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
    TextView GJr;
    TextView GJs;
    TextView GJt;
    TextView GJu;
    TextView GJv;
    View GJw;
    TextView GJx;
    TextView GJy;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */