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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yo.b;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.e;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
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
  public MMLoadMoreListView fVK;
  protected int fq;
  protected boolean isLoading;
  protected int mCount;
  protected aq mHandler;
  protected Dialog mProgressDialog;
  public boolean vHj;
  public a wUd;
  protected List<i> wUe;
  protected String wUf;
  public boolean wUg;
  protected Map<String, String> wUh;
  
  public MallOrderRecordListUI()
  {
    AppMethodBeat.i(66767);
    this.mHandler = null;
    this.mProgressDialog = null;
    this.wUd = null;
    this.wUe = new ArrayList();
    this.vHj = true;
    this.mCount = 0;
    this.fq = 0;
    this.wUf = null;
    this.wUg = false;
    this.isLoading = false;
    this.wUh = new HashMap();
    AppMethodBeat.o(66767);
  }
  
  private boolean avs(String paramString)
  {
    AppMethodBeat.i(66777);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66777);
      return false;
    }
    int i = 0;
    while (i < this.wUe.size())
    {
      i locali = (i)this.wUe.get(i);
      if ((locali != null) && (paramString.equals(locali.wSZ)))
      {
        AppMethodBeat.o(66777);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66777);
    return false;
  }
  
  private static String gW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66781);
    String str = paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(66781);
    return str;
  }
  
  protected final void Na(int paramInt)
  {
    AppMethodBeat.i(66775);
    if (paramInt >= this.wUe.size())
    {
      AppMethodBeat.o(66775);
      return;
    }
    i locali = (i)this.wUe.get(paramInt);
    if (locali != null)
    {
      Bundle localBundle = getInput();
      localBundle.putString("key_trans_id", locali.wSZ);
      localBundle.putInt("key_pay_type", locali.wTg);
      localBundle.putString("bill_id", locali.wTr);
      com.tencent.mm.wallet_core.a.k(this, localBundle);
    }
    AppMethodBeat.o(66775);
  }
  
  protected String Nb(int paramInt)
  {
    AppMethodBeat.i(66779);
    String str = f.agZ(paramInt);
    AppMethodBeat.o(66779);
    return str;
  }
  
  protected void dBB()
  {
    AppMethodBeat.i(66769);
    addSceneEndListener(388);
    addSceneEndListener(389);
    AppMethodBeat.o(66769);
  }
  
  protected void dBC()
  {
    AppMethodBeat.i(66770);
    removeSceneEndListener(388);
    removeSceneEndListener(389);
    AppMethodBeat.o(66770);
  }
  
  protected void dBD()
  {
    AppMethodBeat.i(66773);
    doSceneProgress(new e(this.fq, this.wUf));
    AppMethodBeat.o(66773);
  }
  
  protected final void eP(List<i> paramList)
  {
    AppMethodBeat.i(66776);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(66776);
      return;
    }
    if (this.wUe == null) {
      this.wUe = new ArrayList();
    }
    int i = 0;
    while (i < paramList.size())
    {
      i locali = (i)paramList.get(i);
      if (!avs(locali.wSZ)) {
        this.wUe.add(locali);
      }
      i += 1;
    }
    AppMethodBeat.o(66776);
  }
  
  protected final void eQ(List<d> paramList)
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
        String str = gW(locald.year, locald.month);
        this.wUh.put(str, locald.wST);
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
    if ((com.tencent.mm.wallet_core.a.bs(this) instanceof com.tencent.mm.plugin.order.a.a))
    {
      this.isLoading = true;
      dBD();
    }
    setMMTitle(2131761091);
    this.fVK = ((MMLoadMoreListView)findViewById(2131302064));
    this.wUd = new a();
    this.fVK.setAdapter(this.wUd);
    this.fVK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66756);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        MallOrderRecordListUI.this.Na(paramAnonymousInt);
        f.aha(26);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(66756);
      }
    });
    this.fVK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66758);
        if (paramAnonymousInt >= MallOrderRecordListUI.this.wUe.size())
        {
          AppMethodBeat.o(66758);
          return true;
        }
        h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(2131765585), null, MallOrderRecordListUI.this.getResources().getString(2131755707), new h.c()
        {
          public final void lh(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66757);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66757);
              return;
              i locali = (i)MallOrderRecordListUI.this.wUe.get(paramAnonymousInt);
              if (locali != null)
              {
                String str = locali.wSZ;
                MallOrderRecordListUI.this.iy(str, locali.wTr);
              }
            }
          }
        });
        AppMethodBeat.o(66758);
        return true;
      }
    });
    this.fVK.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void ZC()
      {
        AppMethodBeat.i(66759);
        if (!MallOrderRecordListUI.this.isLoading)
        {
          MallOrderRecordListUI.this.isLoading = true;
          MallOrderRecordListUI localMallOrderRecordListUI = MallOrderRecordListUI.this;
          localMallOrderRecordListUI.fq += 10;
          MallOrderRecordListUI.this.dBD();
        }
        AppMethodBeat.o(66759);
      }
    });
    Object localObject = new yo();
    ((yo)localObject).dNR.scene = "6";
    ((yo)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66760);
        if (!bu.isNullOrNil(this.pmv.dNS.dNT))
        {
          f.a((TextView)MallOrderRecordListUI.this.findViewById(2131297186), this.pmv.dNS.dNT, this.pmv.dNS.content, this.pmv.dNS.url);
          AppMethodBeat.o(66760);
          return;
        }
        ae.i("MicroMsg.WalletOrderListUI", "no bulletin data");
        AppMethodBeat.o(66760);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.plugin.order.a.b.dBo().onChange();
    this.wUd.notifyDataSetChanged();
    localObject = com.tencent.mm.plugin.report.service.g.yxI;
    com.tencent.mm.plugin.order.a.b.dBo();
    ((com.tencent.mm.plugin.report.service.g)localObject).f(11036, new Object[] { Integer.valueOf(com.tencent.mm.plugin.order.a.b.dBr().dBw()) });
    AppMethodBeat.o(66774);
  }
  
  protected void iy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66772);
    doSceneProgress(new com.tencent.mm.plugin.order.model.g(paramString1, paramString2));
    AppMethodBeat.o(66772);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66768);
    super.onCreate(paramBundle);
    this.mHandler = new aq();
    dBB();
    initView();
    this.fq = 0;
    this.wUf = null;
    AppMethodBeat.o(66768);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66778);
    dBC();
    super.onDestroy();
    AppMethodBeat.o(66778);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66771);
    super.onResume();
    if (this.wUd != null) {
      this.wUd.notifyDataSetChanged();
    }
    AppMethodBeat.o(66771);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66782);
    boolean bool;
    if ((paramn instanceof e))
    {
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (e)paramn;
      this.wUf = paramString.wSW;
      eP(paramString.wSU);
      eQ(paramString.wSV);
      this.mCount = this.wUe.size();
      if (paramString.pgV > this.mCount)
      {
        bool = true;
        this.vHj = bool;
        this.wUd.notifyDataSetChanged();
        ae.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
        ae.d("MicroMsg.WalletOrderListUI", "orders list total record: " + paramString.pgV);
        ae.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.vHj);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66761);
            if (MallOrderRecordListUI.this.vHj)
            {
              ae.v("MicroMsg.WalletOrderListUI", "has more");
              if (!MallOrderRecordListUI.this.wUg)
              {
                MallOrderRecordListUI.this.fVK.fCN();
                MallOrderRecordListUI.this.fVK.setAdapter(MallOrderRecordListUI.this.wUd);
                MallOrderRecordListUI.this.wUg = true;
              }
            }
            for (;;)
            {
              MallOrderRecordListUI.this.wUd.notifyDataSetChanged();
              AppMethodBeat.o(66761);
              return;
              ae.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
              MallOrderRecordListUI.this.fVK.fCO();
            }
          }
        });
        this.isLoading = false;
        label202:
        if ((this.mCount > 0) || (this.wUe.size() != 0)) {
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
      if (paramString.dBx() == 2)
      {
        if (this.wUe != null) {
          this.wUe.clear();
        }
        this.mCount = 0;
        this.vHj = false;
        this.fVK.fCO();
      }
      for (;;)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66762);
            MallOrderRecordListUI.this.wUd.notifyDataSetChanged();
            AppMethodBeat.o(66762);
          }
        });
        break;
        paramString = paramString.dBy();
        ae.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bu.isNullOrNil(paramString))
        {
          paramn = this.wUe.iterator();
          if (paramn.hasNext())
          {
            i locali = (i)paramn.next();
            if (!paramString.equals(locali.wSZ)) {
              break label324;
            }
            this.wUe.remove(locali);
            this.mCount = this.wUe.size();
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
    
    private i Nc(int paramInt)
    {
      AppMethodBeat.i(66764);
      i locali = (i)MallOrderRecordListUI.this.wUe.get(paramInt);
      AppMethodBeat.o(66764);
      return locali;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66763);
      int i = MallOrderRecordListUI.this.wUe.size();
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
        paramViewGroup.wUk = ((TextView)localView.findViewById(2131303073));
        paramViewGroup.wUm = ((TextView)localView.findViewById(2131303072));
        paramViewGroup.wUl = ((TextView)localView.findViewById(2131303071));
        paramViewGroup.wUn = ((TextView)localView.findViewById(2131303069));
        paramViewGroup.wUp = localView.findViewById(2131303066);
        paramViewGroup.wUq = ((TextView)localView.findViewById(2131303068));
        paramViewGroup.wUr = ((TextView)localView.findViewById(2131303067));
        paramViewGroup.wUo = ((TextView)localView.findViewById(2131303070));
        localView.setTag(paramViewGroup);
        locali = Nc(paramInt);
        i = 0;
        if (paramInt != 0) {
          break label594;
        }
        i = 1;
        paramView = Nc(0);
        localObject1 = new GregorianCalendar();
        ((GregorianCalendar)localObject1).setTimeInMillis(paramView.CreateTime * 1000L);
        paramView = MallOrderRecordListUI.gX(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2) + 1);
      }
      for (;;)
      {
        for (;;)
        {
          if (i != 0)
          {
            localObject1 = new SimpleDateFormat(MallOrderRecordListUI.this.getString(2131759579, new Object[] { "" })).format(new Date(Nc(paramInt).CreateTime * 1000L));
            paramViewGroup.wUq.setText((CharSequence)localObject1);
            if ((!bu.isNullOrNil(paramView)) && (!bu.isNullOrNil((String)MallOrderRecordListUI.this.wUh.get(paramView)))) {
              paramViewGroup.wUr.setText((CharSequence)MallOrderRecordListUI.this.wUh.get(paramView));
            }
            paramViewGroup.wUp.setVisibility(0);
            label337:
            paramViewGroup.wUk.setText(locali.wTb);
            paramViewGroup.wUl.setText(locali.wTc);
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100609);
            paramInt = i;
            if (bu.isNullOrNil(locali.wTo)) {}
          }
          try
          {
            paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cp(locali.wTo, true);
            paramViewGroup.wUl.setTextColor(paramInt);
            paramViewGroup.wUm.setText(MallOrderRecordListUI.this.Nb(locali.CreateTime));
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100611);
            paramInt = i;
            if (bu.isNullOrNil(locali.wTp)) {}
          }
          catch (Exception paramView)
          {
            try
            {
              paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cp(locali.wTp, true);
              if (locali.wTa != locali.wTq)
              {
                paramView = f.d(locali.wTa / 100.0D, locali.wTe);
                localObject1 = new SpannableString(paramView);
                ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), 0, paramView.length(), 33);
                paramViewGroup.wUn.setText((CharSequence)localObject1);
                paramViewGroup.wUo.setTextColor(paramInt);
                paramViewGroup.wUo.setText(f.d(locali.wTq / 100.0D, locali.wTe));
                AppMethodBeat.o(66765);
                return localView;
                paramViewGroup = (MallOrderRecordListUI.b)paramView.getTag();
                localView = paramView;
                break;
                label594:
                paramView = Nc(paramInt);
                Object localObject2 = Nc(paramInt - 1);
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
                paramView = MallOrderRecordListUI.gX(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2) + 1);
                continue;
                paramViewGroup.wUp.setVisibility(8);
                break label337;
                paramView = paramView;
                ae.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bu.nullAsNil(locali.wTo));
                paramInt = i;
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                ae.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bu.nullAsNil(locali.wTp));
                paramInt = i;
                continue;
                paramViewGroup.wUn.setText("");
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
    TextView wUk;
    TextView wUl;
    TextView wUm;
    TextView wUn;
    TextView wUo;
    View wUp;
    TextView wUq;
    TextView wUr;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */