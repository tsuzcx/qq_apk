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
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
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
  protected int LZ;
  public MMLoadMoreListView fwH;
  protected boolean isLoading;
  protected int mCount;
  protected ap mHandler;
  protected Dialog mProgressDialog;
  public boolean tkj;
  public a uqc;
  protected List<i> uqd;
  protected String uqe;
  public boolean uqf;
  protected Map<String, String> uqg;
  
  public MallOrderRecordListUI()
  {
    AppMethodBeat.i(66767);
    this.mHandler = null;
    this.mProgressDialog = null;
    this.uqc = null;
    this.uqd = new ArrayList();
    this.tkj = true;
    this.mCount = 0;
    this.LZ = 0;
    this.uqe = null;
    this.uqf = false;
    this.isLoading = false;
    this.uqg = new HashMap();
    AppMethodBeat.o(66767);
  }
  
  private boolean akf(String paramString)
  {
    AppMethodBeat.i(66777);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66777);
      return false;
    }
    int i = 0;
    while (i < this.uqd.size())
    {
      i locali = (i)this.uqd.get(i);
      if ((locali != null) && (paramString.equals(locali.uoY)))
      {
        AppMethodBeat.o(66777);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66777);
    return false;
  }
  
  private static String gw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66781);
    String str = paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(66781);
    return str;
  }
  
  protected final void IU(int paramInt)
  {
    AppMethodBeat.i(66775);
    if (paramInt >= this.uqd.size())
    {
      AppMethodBeat.o(66775);
      return;
    }
    i locali = (i)this.uqd.get(paramInt);
    if (locali != null)
    {
      Bundle localBundle = getInput();
      localBundle.putString("key_trans_id", locali.uoY);
      localBundle.putInt("key_pay_type", locali.upf);
      localBundle.putString("bill_id", locali.upq);
      com.tencent.mm.wallet_core.a.k(this, localBundle);
    }
    AppMethodBeat.o(66775);
  }
  
  protected String IV(int paramInt)
  {
    AppMethodBeat.i(66779);
    String str = com.tencent.mm.wallet_core.ui.e.abx(paramInt);
    AppMethodBeat.o(66779);
    return str;
  }
  
  protected void dal()
  {
    AppMethodBeat.i(66769);
    addSceneEndListener(388);
    addSceneEndListener(389);
    AppMethodBeat.o(66769);
  }
  
  protected void dam()
  {
    AppMethodBeat.i(66770);
    removeSceneEndListener(388);
    removeSceneEndListener(389);
    AppMethodBeat.o(66770);
  }
  
  protected void dan()
  {
    AppMethodBeat.i(66773);
    doSceneProgress(new com.tencent.mm.plugin.order.model.e(this.LZ, this.uqe));
    AppMethodBeat.o(66773);
  }
  
  protected final void er(List<i> paramList)
  {
    AppMethodBeat.i(66776);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(66776);
      return;
    }
    if (this.uqd == null) {
      this.uqd = new ArrayList();
    }
    int i = 0;
    while (i < paramList.size())
    {
      i locali = (i)paramList.get(i);
      if (!akf(locali.uoY)) {
        this.uqd.add(locali);
      }
      i += 1;
    }
    AppMethodBeat.o(66776);
  }
  
  protected final void es(List<d> paramList)
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
        String str = gw(locald.year, locald.month);
        this.uqg.put(str, locald.uoS);
      }
      i += 1;
    }
    AppMethodBeat.o(66780);
  }
  
  public int getLayoutId()
  {
    return 2131494716;
  }
  
  protected void hO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66772);
    doSceneProgress(new com.tencent.mm.plugin.order.model.g(paramString1, paramString2));
    AppMethodBeat.o(66772);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66774);
    if ((com.tencent.mm.wallet_core.a.bo(this) instanceof com.tencent.mm.plugin.order.a.a))
    {
      this.isLoading = true;
      dan();
    }
    setMMTitle(2131761091);
    this.fwH = ((MMLoadMoreListView)findViewById(2131302064));
    this.uqc = new a();
    this.fwH.setAdapter(this.uqc);
    this.fwH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66756);
        MallOrderRecordListUI.this.IU(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.e.aby(26);
        AppMethodBeat.o(66756);
      }
    });
    this.fwH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66758);
        if (paramAnonymousInt >= MallOrderRecordListUI.this.uqd.size())
        {
          AppMethodBeat.o(66758);
          return true;
        }
        com.tencent.mm.ui.base.h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(2131765585), null, MallOrderRecordListUI.this.getResources().getString(2131755707), new h.c()
        {
          public final void kM(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66757);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66757);
              return;
              i locali = (i)MallOrderRecordListUI.this.uqd.get(paramAnonymousInt);
              if (locali != null)
              {
                String str = locali.uoY;
                MallOrderRecordListUI.this.hO(str, locali.upq);
              }
            }
          }
        });
        AppMethodBeat.o(66758);
        return true;
      }
    });
    this.fwH.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Wc()
      {
        AppMethodBeat.i(66759);
        if (!MallOrderRecordListUI.this.isLoading)
        {
          MallOrderRecordListUI.this.isLoading = true;
          MallOrderRecordListUI localMallOrderRecordListUI = MallOrderRecordListUI.this;
          localMallOrderRecordListUI.LZ += 10;
          MallOrderRecordListUI.this.dan();
        }
        AppMethodBeat.o(66759);
      }
    });
    Object localObject = new xd();
    ((xd)localObject).dCC.scene = "6";
    ((xd)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66760);
        if (!bt.isNullOrNil(this.nYZ.dCD.dCE))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)MallOrderRecordListUI.this.findViewById(2131297186), this.nYZ.dCD.dCE, this.nYZ.dCD.content, this.nYZ.dCD.url);
          AppMethodBeat.o(66760);
          return;
        }
        ad.i("MicroMsg.WalletOrderListUI", "no bulletin data");
        AppMethodBeat.o(66760);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.plugin.order.a.b.cZY().onChange();
    this.uqc.notifyDataSetChanged();
    localObject = com.tencent.mm.plugin.report.service.h.vKh;
    com.tencent.mm.plugin.order.a.b.cZY();
    ((com.tencent.mm.plugin.report.service.h)localObject).f(11036, new Object[] { Integer.valueOf(com.tencent.mm.plugin.order.a.b.dab().dag()) });
    AppMethodBeat.o(66774);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66768);
    super.onCreate(paramBundle);
    this.mHandler = new ap();
    dal();
    initView();
    this.LZ = 0;
    this.uqe = null;
    AppMethodBeat.o(66768);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66778);
    dam();
    super.onDestroy();
    AppMethodBeat.o(66778);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66771);
    super.onResume();
    if (this.uqc != null) {
      this.uqc.notifyDataSetChanged();
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
      this.uqe = paramString.uoV;
      er(paramString.uoT);
      es(paramString.uoU);
      this.mCount = this.uqd.size();
      if (paramString.nTB > this.mCount)
      {
        bool = true;
        this.tkj = bool;
        this.uqc.notifyDataSetChanged();
        ad.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
        ad.d("MicroMsg.WalletOrderListUI", "orders list total record: " + paramString.nTB);
        ad.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.tkj);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66761);
            if (MallOrderRecordListUI.this.tkj)
            {
              ad.v("MicroMsg.WalletOrderListUI", "has more");
              if (!MallOrderRecordListUI.this.uqf)
              {
                MallOrderRecordListUI.this.fwH.eSM();
                MallOrderRecordListUI.this.fwH.setAdapter(MallOrderRecordListUI.this.uqc);
                MallOrderRecordListUI.this.uqf = true;
              }
            }
            for (;;)
            {
              MallOrderRecordListUI.this.uqc.notifyDataSetChanged();
              AppMethodBeat.o(66761);
              return;
              ad.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
              MallOrderRecordListUI.this.fwH.eSN();
            }
          }
        });
        this.isLoading = false;
        label202:
        if ((this.mCount > 0) || (this.uqd.size() != 0)) {
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
      if (paramString.dah() == 2)
      {
        if (this.uqd != null) {
          this.uqd.clear();
        }
        this.mCount = 0;
        this.tkj = false;
        this.fwH.eSN();
      }
      for (;;)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66762);
            MallOrderRecordListUI.this.uqc.notifyDataSetChanged();
            AppMethodBeat.o(66762);
          }
        });
        break;
        paramString = paramString.dai();
        ad.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bt.isNullOrNil(paramString))
        {
          paramn = this.uqd.iterator();
          if (paramn.hasNext())
          {
            i locali = (i)paramn.next();
            if (!paramString.equals(locali.uoY)) {
              break label324;
            }
            this.uqd.remove(locali);
            this.mCount = this.uqd.size();
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
    
    private i IW(int paramInt)
    {
      AppMethodBeat.i(66764);
      i locali = (i)MallOrderRecordListUI.this.uqd.get(paramInt);
      AppMethodBeat.o(66764);
      return locali;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66763);
      int i = MallOrderRecordListUI.this.uqd.size();
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
        paramViewGroup.uqj = ((TextView)localView.findViewById(2131303073));
        paramViewGroup.uql = ((TextView)localView.findViewById(2131303072));
        paramViewGroup.uqk = ((TextView)localView.findViewById(2131303071));
        paramViewGroup.uqm = ((TextView)localView.findViewById(2131303069));
        paramViewGroup.uqo = localView.findViewById(2131303066);
        paramViewGroup.uqp = ((TextView)localView.findViewById(2131303068));
        paramViewGroup.uqq = ((TextView)localView.findViewById(2131303067));
        paramViewGroup.uqn = ((TextView)localView.findViewById(2131303070));
        localView.setTag(paramViewGroup);
        locali = IW(paramInt);
        i = 0;
        if (paramInt != 0) {
          break label594;
        }
        i = 1;
        paramView = IW(0);
        localObject1 = new GregorianCalendar();
        ((GregorianCalendar)localObject1).setTimeInMillis(paramView.CreateTime * 1000L);
        paramView = MallOrderRecordListUI.gx(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2) + 1);
      }
      for (;;)
      {
        for (;;)
        {
          if (i != 0)
          {
            localObject1 = new SimpleDateFormat(MallOrderRecordListUI.this.getString(2131759579, new Object[] { "" })).format(new Date(IW(paramInt).CreateTime * 1000L));
            paramViewGroup.uqp.setText((CharSequence)localObject1);
            if ((!bt.isNullOrNil(paramView)) && (!bt.isNullOrNil((String)MallOrderRecordListUI.this.uqg.get(paramView)))) {
              paramViewGroup.uqq.setText((CharSequence)MallOrderRecordListUI.this.uqg.get(paramView));
            }
            paramViewGroup.uqo.setVisibility(0);
            label337:
            paramViewGroup.uqj.setText(locali.upa);
            paramViewGroup.uqk.setText(locali.upb);
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100609);
            paramInt = i;
            if (bt.isNullOrNil(locali.upn)) {}
          }
          try
          {
            paramInt = com.tencent.mm.plugin.wallet_core.utils.g.bW(locali.upn, true);
            paramViewGroup.uqk.setTextColor(paramInt);
            paramViewGroup.uql.setText(MallOrderRecordListUI.this.IV(locali.CreateTime));
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100611);
            paramInt = i;
            if (bt.isNullOrNil(locali.upo)) {}
          }
          catch (Exception paramView)
          {
            try
            {
              paramInt = com.tencent.mm.plugin.wallet_core.utils.g.bW(locali.upo, true);
              if (locali.uoZ != locali.upp)
              {
                paramView = com.tencent.mm.wallet_core.ui.e.d(locali.uoZ / 100.0D, locali.upd);
                localObject1 = new SpannableString(paramView);
                ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), 0, paramView.length(), 33);
                paramViewGroup.uqm.setText((CharSequence)localObject1);
                paramViewGroup.uqn.setTextColor(paramInt);
                paramViewGroup.uqn.setText(com.tencent.mm.wallet_core.ui.e.d(locali.upp / 100.0D, locali.upd));
                AppMethodBeat.o(66765);
                return localView;
                paramViewGroup = (MallOrderRecordListUI.b)paramView.getTag();
                localView = paramView;
                break;
                label594:
                paramView = IW(paramInt);
                Object localObject2 = IW(paramInt - 1);
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
                paramView = MallOrderRecordListUI.gx(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2) + 1);
                continue;
                paramViewGroup.uqo.setVisibility(8);
                break label337;
                paramView = paramView;
                ad.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bt.nullAsNil(locali.upn));
                paramInt = i;
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                ad.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bt.nullAsNil(locali.upo));
                paramInt = i;
                continue;
                paramViewGroup.uqm.setText("");
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
    TextView uqj;
    TextView uqk;
    TextView uql;
    TextView uqm;
    TextView uqn;
    View uqo;
    TextView uqp;
    TextView uqq;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */