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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.b;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
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
  public MMLoadMoreListView fTE;
  protected int fq;
  protected boolean isLoading;
  protected int mCount;
  protected ap mHandler;
  protected Dialog mProgressDialog;
  public boolean vvf;
  public a wEs;
  protected List<i> wEt;
  protected String wEu;
  public boolean wEv;
  protected Map<String, String> wEw;
  
  public MallOrderRecordListUI()
  {
    AppMethodBeat.i(66767);
    this.mHandler = null;
    this.mProgressDialog = null;
    this.wEs = null;
    this.wEt = new ArrayList();
    this.vvf = true;
    this.mCount = 0;
    this.fq = 0;
    this.wEu = null;
    this.wEv = false;
    this.isLoading = false;
    this.wEw = new HashMap();
    AppMethodBeat.o(66767);
  }
  
  private boolean aud(String paramString)
  {
    AppMethodBeat.i(66777);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66777);
      return false;
    }
    int i = 0;
    while (i < this.wEt.size())
    {
      i locali = (i)this.wEt.get(i);
      if ((locali != null) && (paramString.equals(locali.wDo)))
      {
        AppMethodBeat.o(66777);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66777);
    return false;
  }
  
  private static String gV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66781);
    String str = paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(66781);
    return str;
  }
  
  protected final void Mv(int paramInt)
  {
    AppMethodBeat.i(66775);
    if (paramInt >= this.wEt.size())
    {
      AppMethodBeat.o(66775);
      return;
    }
    i locali = (i)this.wEt.get(paramInt);
    if (locali != null)
    {
      Bundle localBundle = getInput();
      localBundle.putString("key_trans_id", locali.wDo);
      localBundle.putInt("key_pay_type", locali.wDv);
      localBundle.putString("bill_id", locali.wDG);
      com.tencent.mm.wallet_core.a.k(this, localBundle);
    }
    AppMethodBeat.o(66775);
  }
  
  protected String Mw(int paramInt)
  {
    AppMethodBeat.i(66779);
    String str = com.tencent.mm.wallet_core.ui.e.agq(paramInt);
    AppMethodBeat.o(66779);
    return str;
  }
  
  protected void dyl()
  {
    AppMethodBeat.i(66769);
    addSceneEndListener(388);
    addSceneEndListener(389);
    AppMethodBeat.o(66769);
  }
  
  protected void dym()
  {
    AppMethodBeat.i(66770);
    removeSceneEndListener(388);
    removeSceneEndListener(389);
    AppMethodBeat.o(66770);
  }
  
  protected void dyn()
  {
    AppMethodBeat.i(66773);
    doSceneProgress(new com.tencent.mm.plugin.order.model.e(this.fq, this.wEu));
    AppMethodBeat.o(66773);
  }
  
  protected final void eI(List<i> paramList)
  {
    AppMethodBeat.i(66776);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(66776);
      return;
    }
    if (this.wEt == null) {
      this.wEt = new ArrayList();
    }
    int i = 0;
    while (i < paramList.size())
    {
      i locali = (i)paramList.get(i);
      if (!aud(locali.wDo)) {
        this.wEt.add(locali);
      }
      i += 1;
    }
    AppMethodBeat.o(66776);
  }
  
  protected final void eJ(List<d> paramList)
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
        String str = gV(locald.year, locald.month);
        this.wEw.put(str, locald.wDi);
      }
      i += 1;
    }
    AppMethodBeat.o(66780);
  }
  
  public int getLayoutId()
  {
    return 2131494716;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66774);
    if ((com.tencent.mm.wallet_core.a.br(this) instanceof com.tencent.mm.plugin.order.a.a))
    {
      this.isLoading = true;
      dyn();
    }
    setMMTitle(2131761091);
    this.fTE = ((MMLoadMoreListView)findViewById(2131302064));
    this.wEs = new a();
    this.fTE.setAdapter(this.wEs);
    this.fTE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66756);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        MallOrderRecordListUI.this.Mv(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.e.agr(26);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(66756);
      }
    });
    this.fTE.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66758);
        if (paramAnonymousInt >= MallOrderRecordListUI.this.wEt.size())
        {
          AppMethodBeat.o(66758);
          return true;
        }
        h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(2131765585), null, MallOrderRecordListUI.this.getResources().getString(2131755707), new h.c()
        {
          public final void lf(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66757);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66757);
              return;
              i locali = (i)MallOrderRecordListUI.this.wEt.get(paramAnonymousInt);
              if (locali != null)
              {
                String str = locali.wDo;
                MallOrderRecordListUI.this.is(str, locali.wDG);
              }
            }
          }
        });
        AppMethodBeat.o(66758);
        return true;
      }
    });
    this.fTE.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Zt()
      {
        AppMethodBeat.i(66759);
        if (!MallOrderRecordListUI.this.isLoading)
        {
          MallOrderRecordListUI.this.isLoading = true;
          MallOrderRecordListUI localMallOrderRecordListUI = MallOrderRecordListUI.this;
          localMallOrderRecordListUI.fq += 10;
          MallOrderRecordListUI.this.dyn();
        }
        AppMethodBeat.o(66759);
      }
    });
    Object localObject = new yi();
    ((yi)localObject).dMB.scene = "6";
    ((yi)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66760);
        if (!bt.isNullOrNil(this.pfP.dMC.dMD))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)MallOrderRecordListUI.this.findViewById(2131297186), this.pfP.dMC.dMD, this.pfP.dMC.content, this.pfP.dMC.url);
          AppMethodBeat.o(66760);
          return;
        }
        ad.i("MicroMsg.WalletOrderListUI", "no bulletin data");
        AppMethodBeat.o(66760);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.plugin.order.a.b.dxY().onChange();
    this.wEs.notifyDataSetChanged();
    localObject = com.tencent.mm.plugin.report.service.g.yhR;
    com.tencent.mm.plugin.order.a.b.dxY();
    ((com.tencent.mm.plugin.report.service.g)localObject).f(11036, new Object[] { Integer.valueOf(com.tencent.mm.plugin.order.a.b.dyb().dyg()) });
    AppMethodBeat.o(66774);
  }
  
  protected void is(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66772);
    doSceneProgress(new com.tencent.mm.plugin.order.model.g(paramString1, paramString2));
    AppMethodBeat.o(66772);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66768);
    super.onCreate(paramBundle);
    this.mHandler = new ap();
    dyl();
    initView();
    this.fq = 0;
    this.wEu = null;
    AppMethodBeat.o(66768);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66778);
    dym();
    super.onDestroy();
    AppMethodBeat.o(66778);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66771);
    super.onResume();
    if (this.wEs != null) {
      this.wEs.notifyDataSetChanged();
    }
    AppMethodBeat.o(66771);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66782);
    boolean bool;
    if ((paramn instanceof com.tencent.mm.plugin.order.model.e))
    {
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (com.tencent.mm.plugin.order.model.e)paramn;
      this.wEu = paramString.wDl;
      eI(paramString.wDj);
      eJ(paramString.wDk);
      this.mCount = this.wEt.size();
      if (paramString.par > this.mCount)
      {
        bool = true;
        this.vvf = bool;
        this.wEs.notifyDataSetChanged();
        ad.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
        ad.d("MicroMsg.WalletOrderListUI", "orders list total record: " + paramString.par);
        ad.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.vvf);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66761);
            if (MallOrderRecordListUI.this.vvf)
            {
              ad.v("MicroMsg.WalletOrderListUI", "has more");
              if (!MallOrderRecordListUI.this.wEv)
              {
                MallOrderRecordListUI.this.fTE.fyL();
                MallOrderRecordListUI.this.fTE.setAdapter(MallOrderRecordListUI.this.wEs);
                MallOrderRecordListUI.this.wEv = true;
              }
            }
            for (;;)
            {
              MallOrderRecordListUI.this.wEs.notifyDataSetChanged();
              AppMethodBeat.o(66761);
              return;
              ad.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
              MallOrderRecordListUI.this.fTE.fyM();
            }
          }
        });
        this.isLoading = false;
        label202:
        if ((this.mCount > 0) || (this.wEt.size() != 0)) {
          break label445;
        }
        showOptionMenu(false);
        findViewById(2131299473).setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66782);
      return true;
      bool = false;
      break;
      if (!(paramn instanceof com.tencent.mm.plugin.order.model.g)) {
        break label202;
      }
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (com.tencent.mm.plugin.order.model.g)paramn;
      label324:
      if (paramString.dyh() == 2)
      {
        if (this.wEt != null) {
          this.wEt.clear();
        }
        this.mCount = 0;
        this.vvf = false;
        this.fTE.fyM();
      }
      for (;;)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66762);
            MallOrderRecordListUI.this.wEs.notifyDataSetChanged();
            AppMethodBeat.o(66762);
          }
        });
        break;
        paramString = paramString.dyi();
        ad.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bt.isNullOrNil(paramString))
        {
          paramn = this.wEt.iterator();
          if (paramn.hasNext())
          {
            i locali = (i)paramn.next();
            if (!paramString.equals(locali.wDo)) {
              break label324;
            }
            this.wEt.remove(locali);
            this.mCount = this.wEt.size();
          }
        }
      }
      label445:
      showOptionMenu(true);
      findViewById(2131299473).setVisibility(8);
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
    
    private i Mx(int paramInt)
    {
      AppMethodBeat.i(66764);
      i locali = (i)MallOrderRecordListUI.this.wEt.get(paramInt);
      AppMethodBeat.o(66764);
      return locali;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66763);
      int i = MallOrderRecordListUI.this.wEt.size();
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
        localView = View.inflate(MallOrderRecordListUI.this, 2131494717, null);
        paramViewGroup = new MallOrderRecordListUI.b(MallOrderRecordListUI.this, (byte)0);
        paramViewGroup.wEz = ((TextView)localView.findViewById(2131303073));
        paramViewGroup.wEB = ((TextView)localView.findViewById(2131303072));
        paramViewGroup.wEA = ((TextView)localView.findViewById(2131303071));
        paramViewGroup.wEC = ((TextView)localView.findViewById(2131303069));
        paramViewGroup.wEE = localView.findViewById(2131303066);
        paramViewGroup.wEF = ((TextView)localView.findViewById(2131303068));
        paramViewGroup.wEG = ((TextView)localView.findViewById(2131303067));
        paramViewGroup.wED = ((TextView)localView.findViewById(2131303070));
        localView.setTag(paramViewGroup);
        locali = Mx(paramInt);
        i = 0;
        if (paramInt != 0) {
          break label594;
        }
        i = 1;
        paramView = Mx(0);
        localObject1 = new GregorianCalendar();
        ((GregorianCalendar)localObject1).setTimeInMillis(paramView.CreateTime * 1000L);
        paramView = MallOrderRecordListUI.gW(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2) + 1);
      }
      for (;;)
      {
        for (;;)
        {
          if (i != 0)
          {
            localObject1 = new SimpleDateFormat(MallOrderRecordListUI.this.getString(2131759579, new Object[] { "" })).format(new Date(Mx(paramInt).CreateTime * 1000L));
            paramViewGroup.wEF.setText((CharSequence)localObject1);
            if ((!bt.isNullOrNil(paramView)) && (!bt.isNullOrNil((String)MallOrderRecordListUI.this.wEw.get(paramView)))) {
              paramViewGroup.wEG.setText((CharSequence)MallOrderRecordListUI.this.wEw.get(paramView));
            }
            paramViewGroup.wEE.setVisibility(0);
            label337:
            paramViewGroup.wEz.setText(locali.wDq);
            paramViewGroup.wEA.setText(locali.wDr);
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100609);
            paramInt = i;
            if (bt.isNullOrNil(locali.wDD)) {}
          }
          try
          {
            paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cl(locali.wDD, true);
            paramViewGroup.wEA.setTextColor(paramInt);
            paramViewGroup.wEB.setText(MallOrderRecordListUI.this.Mw(locali.CreateTime));
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100611);
            paramInt = i;
            if (bt.isNullOrNil(locali.wDE)) {}
          }
          catch (Exception paramView)
          {
            try
            {
              paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cl(locali.wDE, true);
              if (locali.wDp != locali.wDF)
              {
                paramView = com.tencent.mm.wallet_core.ui.e.d(locali.wDp / 100.0D, locali.wDt);
                localObject1 = new SpannableString(paramView);
                ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), 0, paramView.length(), 33);
                paramViewGroup.wEC.setText((CharSequence)localObject1);
                paramViewGroup.wED.setTextColor(paramInt);
                paramViewGroup.wED.setText(com.tencent.mm.wallet_core.ui.e.d(locali.wDF / 100.0D, locali.wDt));
                AppMethodBeat.o(66765);
                return localView;
                paramViewGroup = (MallOrderRecordListUI.b)paramView.getTag();
                localView = paramView;
                break;
                label594:
                paramView = Mx(paramInt);
                Object localObject2 = Mx(paramInt - 1);
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
                paramView = MallOrderRecordListUI.gW(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2) + 1);
                continue;
                paramViewGroup.wEE.setVisibility(8);
                break label337;
                paramView = paramView;
                ad.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bt.nullAsNil(locali.wDD));
                paramInt = i;
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                ad.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bt.nullAsNil(locali.wDE));
                paramInt = i;
                continue;
                paramViewGroup.wEC.setText("");
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
    TextView wEA;
    TextView wEB;
    TextView wEC;
    TextView wED;
    View wEE;
    TextView wEF;
    TextView wEG;
    TextView wEz;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */