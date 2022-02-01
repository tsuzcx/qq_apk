package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.e;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
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
  public a APZ;
  protected List<i> AQa;
  protected String AQb;
  public boolean AQc;
  protected Map<String, String> AQd;
  protected int fs;
  public MMLoadMoreListView gAR;
  protected boolean isLoading;
  protected int mCount;
  protected MMHandler mHandler;
  protected Dialog mProgressDialog;
  public boolean zci;
  
  public MallOrderRecordListUI()
  {
    AppMethodBeat.i(66767);
    this.mHandler = null;
    this.mProgressDialog = null;
    this.APZ = null;
    this.AQa = new ArrayList();
    this.zci = true;
    this.mCount = 0;
    this.fs = 0;
    this.AQb = null;
    this.AQc = false;
    this.isLoading = false;
    this.AQd = new HashMap();
    AppMethodBeat.o(66767);
  }
  
  private boolean aJF(String paramString)
  {
    AppMethodBeat.i(66777);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66777);
      return false;
    }
    int i = 0;
    while (i < this.AQa.size())
    {
      i locali = (i)this.AQa.get(i);
      if ((locali != null) && (paramString.equals(locali.AOT)))
      {
        AppMethodBeat.o(66777);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66777);
    return false;
  }
  
  private static String hH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66781);
    String str = paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(66781);
    return str;
  }
  
  protected final void Uk(int paramInt)
  {
    AppMethodBeat.i(66775);
    if (paramInt >= this.AQa.size())
    {
      AppMethodBeat.o(66775);
      return;
    }
    i locali = (i)this.AQa.get(paramInt);
    if (locali != null)
    {
      Bundle localBundle = getInput();
      localBundle.putString("key_trans_id", locali.AOT);
      localBundle.putInt("key_pay_type", locali.APa);
      localBundle.putString("bill_id", locali.APl);
      com.tencent.mm.wallet_core.a.l(this, localBundle);
    }
    AppMethodBeat.o(66775);
  }
  
  protected String Ul(int paramInt)
  {
    AppMethodBeat.i(66779);
    String str = f.aql(paramInt);
    AppMethodBeat.o(66779);
    return str;
  }
  
  protected void eBm()
  {
    AppMethodBeat.i(66769);
    addSceneEndListener(388);
    addSceneEndListener(389);
    AppMethodBeat.o(66769);
  }
  
  protected void eBn()
  {
    AppMethodBeat.i(66770);
    removeSceneEndListener(388);
    removeSceneEndListener(389);
    AppMethodBeat.o(66770);
  }
  
  protected void eBo()
  {
    AppMethodBeat.i(66773);
    doSceneProgress(new e(this.fs, this.AQb));
    AppMethodBeat.o(66773);
  }
  
  protected final void fM(List<i> paramList)
  {
    AppMethodBeat.i(66776);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(66776);
      return;
    }
    if (this.AQa == null) {
      this.AQa = new ArrayList();
    }
    int i = 0;
    while (i < paramList.size())
    {
      i locali = (i)paramList.get(i);
      if (!aJF(locali.AOT)) {
        this.AQa.add(locali);
      }
      i += 1;
    }
    AppMethodBeat.o(66776);
  }
  
  protected final void fN(List<d> paramList)
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
        String str = hH(locald.year, locald.month);
        this.AQd.put(str, locald.AON);
      }
      i += 1;
    }
    AppMethodBeat.o(66780);
  }
  
  public int getLayoutId()
  {
    return 2131495445;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66774);
    if ((com.tencent.mm.wallet_core.a.by(this) instanceof com.tencent.mm.plugin.order.a.a))
    {
      this.isLoading = true;
      eBo();
    }
    setMMTitle(2131762878);
    this.gAR = ((MMLoadMoreListView)findViewById(2131304403));
    this.APZ = new a();
    this.gAR.setAdapter(this.APZ);
    this.gAR.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66756);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        MallOrderRecordListUI.this.Uk(paramAnonymousInt);
        f.aqm(26);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(66756);
      }
    });
    this.gAR.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66758);
        if (paramAnonymousInt >= MallOrderRecordListUI.this.AQa.size())
        {
          AppMethodBeat.o(66758);
          return true;
        }
        com.tencent.mm.ui.base.h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(2131768034), null, MallOrderRecordListUI.this.getResources().getString(2131755778), new h.d()
        {
          public final void oj(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66757);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66757);
              return;
              i locali = (i)MallOrderRecordListUI.this.AQa.get(paramAnonymousInt);
              if (locali != null)
              {
                String str = locali.AOT;
                MallOrderRecordListUI.this.jj(str, locali.APl);
              }
            }
          }
        });
        AppMethodBeat.o(66758);
        return true;
      }
    });
    this.gAR.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void onLoadMore()
      {
        AppMethodBeat.i(66759);
        if (!MallOrderRecordListUI.this.isLoading)
        {
          MallOrderRecordListUI.this.isLoading = true;
          MallOrderRecordListUI localMallOrderRecordListUI = MallOrderRecordListUI.this;
          localMallOrderRecordListUI.fs += 10;
          MallOrderRecordListUI.this.eBo();
        }
        AppMethodBeat.o(66759);
      }
    });
    Object localObject = new zt();
    ((zt)localObject).efM.scene = "6";
    ((zt)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66760);
        if (!Util.isNullOrNil(this.qBN.efN.efO))
        {
          f.a((TextView)MallOrderRecordListUI.this.findViewById(2131297330), this.qBN.efN.efO, this.qBN.efN.content, this.qBN.efN.url);
          AppMethodBeat.o(66760);
          return;
        }
        Log.i("MicroMsg.WalletOrderListUI", "no bulletin data");
        AppMethodBeat.o(66760);
      }
    };
    EventCenter.instance.publish((IEvent)localObject);
    com.tencent.mm.plugin.order.a.b.eBa().onChange();
    this.APZ.notifyDataSetChanged();
    localObject = com.tencent.mm.plugin.report.service.h.CyF;
    com.tencent.mm.plugin.order.a.b.eBa();
    ((com.tencent.mm.plugin.report.service.h)localObject).a(11036, new Object[] { Integer.valueOf(com.tencent.mm.plugin.order.a.b.eBd().eBh()) });
    AppMethodBeat.o(66774);
  }
  
  protected void jj(String paramString1, String paramString2)
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
    eBm();
    initView();
    this.fs = 0;
    this.AQb = null;
    AppMethodBeat.o(66768);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66778);
    eBn();
    super.onDestroy();
    AppMethodBeat.o(66778);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66771);
    super.onResume();
    if (this.APZ != null) {
      this.APZ.notifyDataSetChanged();
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
      this.AQb = paramString.AOQ;
      fM(paramString.AOO);
      fN(paramString.AOP);
      this.mCount = this.AQa.size();
      if (paramString.qwe > this.mCount)
      {
        bool = true;
        this.zci = bool;
        this.APZ.notifyDataSetChanged();
        Log.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
        Log.d("MicroMsg.WalletOrderListUI", "orders list total record: " + paramString.qwe);
        Log.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.zci);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66761);
            if (MallOrderRecordListUI.this.zci)
            {
              Log.v("MicroMsg.WalletOrderListUI", "has more");
              if (!MallOrderRecordListUI.this.AQc)
              {
                MallOrderRecordListUI.this.gAR.gKM();
                MallOrderRecordListUI.this.gAR.setAdapter(MallOrderRecordListUI.this.APZ);
                MallOrderRecordListUI.this.AQc = true;
              }
            }
            for (;;)
            {
              MallOrderRecordListUI.this.APZ.notifyDataSetChanged();
              AppMethodBeat.o(66761);
              return;
              Log.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
              MallOrderRecordListUI.this.gAR.gKN();
            }
          }
        });
        this.isLoading = false;
        label202:
        if ((this.mCount > 0) || (this.AQa.size() != 0)) {
          break label445;
        }
        showOptionMenu(false);
        findViewById(2131300102).setVisibility(0);
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
      if (paramString.eBi() == 2)
      {
        if (this.AQa != null) {
          this.AQa.clear();
        }
        this.mCount = 0;
        this.zci = false;
        this.gAR.gKN();
      }
      for (;;)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66762);
            MallOrderRecordListUI.this.APZ.notifyDataSetChanged();
            AppMethodBeat.o(66762);
          }
        });
        break;
        paramString = paramString.eBj();
        Log.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!Util.isNullOrNil(paramString))
        {
          paramq = this.AQa.iterator();
          if (paramq.hasNext())
          {
            i locali = (i)paramq.next();
            if (!paramString.equals(locali.AOT)) {
              break label324;
            }
            this.AQa.remove(locali);
            this.mCount = this.AQa.size();
          }
        }
      }
      label445:
      showOptionMenu(true);
      findViewById(2131300102).setVisibility(8);
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
    
    private i Um(int paramInt)
    {
      AppMethodBeat.i(66764);
      i locali = (i)MallOrderRecordListUI.this.AQa.get(paramInt);
      AppMethodBeat.o(66764);
      return locali;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66763);
      int i = MallOrderRecordListUI.this.AQa.size();
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
        localView = View.inflate(MallOrderRecordListUI.this, 2131495446, null);
        paramViewGroup = new MallOrderRecordListUI.b(MallOrderRecordListUI.this, (byte)0);
        paramViewGroup.AQg = ((TextView)localView.findViewById(2131305681));
        paramViewGroup.AQi = ((TextView)localView.findViewById(2131305680));
        paramViewGroup.AQh = ((TextView)localView.findViewById(2131305679));
        paramViewGroup.AQj = ((TextView)localView.findViewById(2131305677));
        paramViewGroup.AQl = localView.findViewById(2131305674);
        paramViewGroup.AQm = ((TextView)localView.findViewById(2131305676));
        paramViewGroup.AQn = ((TextView)localView.findViewById(2131305675));
        paramViewGroup.AQk = ((TextView)localView.findViewById(2131305678));
        localView.setTag(paramViewGroup);
        locali = Um(paramInt);
        i = 0;
        if (paramInt != 0) {
          break label594;
        }
        i = 1;
        paramView = Um(0);
        localObject1 = new GregorianCalendar();
        ((GregorianCalendar)localObject1).setTimeInMillis(paramView.CreateTime * 1000L);
        paramView = MallOrderRecordListUI.hI(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2) + 1);
      }
      for (;;)
      {
        for (;;)
        {
          if (i != 0)
          {
            localObject1 = new SimpleDateFormat(MallOrderRecordListUI.this.getString(2131760896, new Object[] { "" })).format(new Date(Um(paramInt).CreateTime * 1000L));
            paramViewGroup.AQm.setText((CharSequence)localObject1);
            if ((!Util.isNullOrNil(paramView)) && (!Util.isNullOrNil((String)MallOrderRecordListUI.this.AQd.get(paramView)))) {
              paramViewGroup.AQn.setText((CharSequence)MallOrderRecordListUI.this.AQd.get(paramView));
            }
            paramViewGroup.AQl.setVisibility(0);
            label337:
            paramViewGroup.AQg.setText(locali.AOV);
            paramViewGroup.AQh.setText(locali.AOW);
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100777);
            paramInt = i;
            if (Util.isNullOrNil(locali.APi)) {}
          }
          try
          {
            paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cI(locali.APi, true);
            paramViewGroup.AQh.setTextColor(paramInt);
            paramViewGroup.AQi.setText(MallOrderRecordListUI.this.Ul(locali.CreateTime));
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100779);
            paramInt = i;
            if (Util.isNullOrNil(locali.APj)) {}
          }
          catch (Exception paramView)
          {
            try
            {
              paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cI(locali.APj, true);
              if (locali.AOU != locali.APk)
              {
                paramView = f.d(locali.AOU / 100.0D, locali.AOY);
                localObject1 = new SpannableString(paramView);
                ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), 0, paramView.length(), 33);
                paramViewGroup.AQj.setText((CharSequence)localObject1);
                paramViewGroup.AQk.setTextColor(paramInt);
                paramViewGroup.AQk.setText(f.d(locali.APk / 100.0D, locali.AOY));
                AppMethodBeat.o(66765);
                return localView;
                paramViewGroup = (MallOrderRecordListUI.b)paramView.getTag();
                localView = paramView;
                break;
                label594:
                paramView = Um(paramInt);
                Object localObject2 = Um(paramInt - 1);
                if ((paramView.CreateTime <= 0) || (((i)localObject2).CreateTime <= 0)) {
                  break label823;
                }
                localObject1 = new GregorianCalendar();
                ((GregorianCalendar)localObject1).setTimeInMillis(((i)localObject2).CreateTime * 1000L);
                localObject2 = new GregorianCalendar();
                ((GregorianCalendar)localObject2).setTimeInMillis(paramView.CreateTime * 1000L);
                if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(2) == ((GregorianCalendar)localObject2).get(2))) {
                  break label823;
                }
                i = 1;
                paramView = MallOrderRecordListUI.hI(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2) + 1);
                continue;
                paramViewGroup.AQl.setVisibility(8);
                break label337;
                paramView = paramView;
                Log.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + Util.nullAsNil(locali.APi));
                paramInt = i;
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                Log.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + Util.nullAsNil(locali.APj));
                paramInt = i;
                continue;
                paramViewGroup.AQj.setText("");
              }
              label823:
              paramView = null;
            }
          }
        }
      }
    }
  }
  
  final class b
  {
    TextView AQg;
    TextView AQh;
    TextView AQi;
    TextView AQj;
    TextView AQk;
    View AQl;
    TextView AQm;
    TextView AQn;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */