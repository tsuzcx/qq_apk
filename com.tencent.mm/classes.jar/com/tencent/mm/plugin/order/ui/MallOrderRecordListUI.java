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
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  protected int MW;
  public MMLoadMoreListView fAo;
  protected boolean isLoading;
  protected int mCount;
  protected ao mHandler;
  protected Dialog mProgressDialog;
  public boolean usC;
  public a vyY;
  protected List<i> vyZ;
  protected String vza;
  public boolean vzb;
  protected Map<String, String> vzc;
  
  public MallOrderRecordListUI()
  {
    AppMethodBeat.i(66767);
    this.mHandler = null;
    this.mProgressDialog = null;
    this.vyY = null;
    this.vyZ = new ArrayList();
    this.usC = true;
    this.mCount = 0;
    this.MW = 0;
    this.vza = null;
    this.vzb = false;
    this.isLoading = false;
    this.vzc = new HashMap();
    AppMethodBeat.o(66767);
  }
  
  private boolean apd(String paramString)
  {
    AppMethodBeat.i(66777);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66777);
      return false;
    }
    int i = 0;
    while (i < this.vyZ.size())
    {
      i locali = (i)this.vyZ.get(i);
      if ((locali != null) && (paramString.equals(locali.vxU)))
      {
        AppMethodBeat.o(66777);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66777);
    return false;
  }
  
  private static String gD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66781);
    String str = paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(66781);
    return str;
  }
  
  protected final void KT(int paramInt)
  {
    AppMethodBeat.i(66775);
    if (paramInt >= this.vyZ.size())
    {
      AppMethodBeat.o(66775);
      return;
    }
    i locali = (i)this.vyZ.get(paramInt);
    if (locali != null)
    {
      Bundle localBundle = getInput();
      localBundle.putString("key_trans_id", locali.vxU);
      localBundle.putInt("key_pay_type", locali.vyb);
      localBundle.putString("bill_id", locali.vym);
      com.tencent.mm.wallet_core.a.k(this, localBundle);
    }
    AppMethodBeat.o(66775);
  }
  
  protected String KU(int paramInt)
  {
    AppMethodBeat.i(66779);
    String str = com.tencent.mm.wallet_core.ui.e.adQ(paramInt);
    AppMethodBeat.o(66779);
    return str;
  }
  
  protected void dnT()
  {
    AppMethodBeat.i(66769);
    addSceneEndListener(388);
    addSceneEndListener(389);
    AppMethodBeat.o(66769);
  }
  
  protected void dnU()
  {
    AppMethodBeat.i(66770);
    removeSceneEndListener(388);
    removeSceneEndListener(389);
    AppMethodBeat.o(66770);
  }
  
  protected void dnV()
  {
    AppMethodBeat.i(66773);
    doSceneProgress(new com.tencent.mm.plugin.order.model.e(this.MW, this.vza));
    AppMethodBeat.o(66773);
  }
  
  protected final void ev(List<i> paramList)
  {
    AppMethodBeat.i(66776);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(66776);
      return;
    }
    if (this.vyZ == null) {
      this.vyZ = new ArrayList();
    }
    int i = 0;
    while (i < paramList.size())
    {
      i locali = (i)paramList.get(i);
      if (!apd(locali.vxU)) {
        this.vyZ.add(locali);
      }
      i += 1;
    }
    AppMethodBeat.o(66776);
  }
  
  protected final void ew(List<d> paramList)
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
        String str = gD(locald.year, locald.month);
        this.vzc.put(str, locald.vxO);
      }
      i += 1;
    }
    AppMethodBeat.o(66780);
  }
  
  public int getLayoutId()
  {
    return 2131494716;
  }
  
  protected void ih(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66772);
    doSceneProgress(new com.tencent.mm.plugin.order.model.g(paramString1, paramString2));
    AppMethodBeat.o(66772);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66774);
    if ((com.tencent.mm.wallet_core.a.br(this) instanceof com.tencent.mm.plugin.order.a.a))
    {
      this.isLoading = true;
      dnV();
    }
    setMMTitle(2131761091);
    this.fAo = ((MMLoadMoreListView)findViewById(2131302064));
    this.vyY = new a();
    this.fAo.setAdapter(this.vyY);
    this.fAo.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66756);
        MallOrderRecordListUI.this.KT(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.e.adR(26);
        AppMethodBeat.o(66756);
      }
    });
    this.fAo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(66758);
        if (paramAnonymousInt >= MallOrderRecordListUI.this.vyZ.size())
        {
          AppMethodBeat.o(66758);
          return true;
        }
        com.tencent.mm.ui.base.h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(2131765585), null, MallOrderRecordListUI.this.getResources().getString(2131755707), new h.c()
        {
          public final void kG(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66757);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(66757);
              return;
              i locali = (i)MallOrderRecordListUI.this.vyZ.get(paramAnonymousInt);
              if (locali != null)
              {
                String str = locali.vxU;
                MallOrderRecordListUI.this.ih(str, locali.vym);
              }
            }
          }
        });
        AppMethodBeat.o(66758);
        return true;
      }
    });
    this.fAo.setOnLoadMoreListener(new MMLoadMoreListView.a()
    {
      public final void Xa()
      {
        AppMethodBeat.i(66759);
        if (!MallOrderRecordListUI.this.isLoading)
        {
          MallOrderRecordListUI.this.isLoading = true;
          MallOrderRecordListUI localMallOrderRecordListUI = MallOrderRecordListUI.this;
          localMallOrderRecordListUI.MW += 10;
          MallOrderRecordListUI.this.dnV();
        }
        AppMethodBeat.o(66759);
      }
    });
    Object localObject = new xo();
    ((xo)localObject).dAo.scene = "6";
    ((xo)localObject).callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66760);
        if (!bs.isNullOrNil(this.oCu.dAp.dAq))
        {
          com.tencent.mm.wallet_core.ui.e.a((TextView)MallOrderRecordListUI.this.findViewById(2131297186), this.oCu.dAp.dAq, this.oCu.dAp.content, this.oCu.dAp.url);
          AppMethodBeat.o(66760);
          return;
        }
        ac.i("MicroMsg.WalletOrderListUI", "no bulletin data");
        AppMethodBeat.o(66760);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.plugin.order.a.b.dnG().onChange();
    this.vyY.notifyDataSetChanged();
    localObject = com.tencent.mm.plugin.report.service.h.wUl;
    com.tencent.mm.plugin.order.a.b.dnG();
    ((com.tencent.mm.plugin.report.service.h)localObject).f(11036, new Object[] { Integer.valueOf(com.tencent.mm.plugin.order.a.b.dnJ().dnO()) });
    AppMethodBeat.o(66774);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66768);
    super.onCreate(paramBundle);
    this.mHandler = new ao();
    dnT();
    initView();
    this.MW = 0;
    this.vza = null;
    AppMethodBeat.o(66768);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66778);
    dnU();
    super.onDestroy();
    AppMethodBeat.o(66778);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66771);
    super.onResume();
    if (this.vyY != null) {
      this.vyY.notifyDataSetChanged();
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
      this.vza = paramString.vxR;
      ev(paramString.vxP);
      ew(paramString.vxQ);
      this.mCount = this.vyZ.size();
      if (paramString.owW > this.mCount)
      {
        bool = true;
        this.usC = bool;
        this.vyY.notifyDataSetChanged();
        ac.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
        ac.d("MicroMsg.WalletOrderListUI", "orders list total record: " + paramString.owW);
        ac.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.usC);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66761);
            if (MallOrderRecordListUI.this.usC)
            {
              ac.v("MicroMsg.WalletOrderListUI", "has more");
              if (!MallOrderRecordListUI.this.vzb)
              {
                MallOrderRecordListUI.this.fAo.fiw();
                MallOrderRecordListUI.this.fAo.setAdapter(MallOrderRecordListUI.this.vyY);
                MallOrderRecordListUI.this.vzb = true;
              }
            }
            for (;;)
            {
              MallOrderRecordListUI.this.vyY.notifyDataSetChanged();
              AppMethodBeat.o(66761);
              return;
              ac.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
              MallOrderRecordListUI.this.fAo.fix();
            }
          }
        });
        this.isLoading = false;
        label202:
        if ((this.mCount > 0) || (this.vyZ.size() != 0)) {
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
      if (paramString.dnP() == 2)
      {
        if (this.vyZ != null) {
          this.vyZ.clear();
        }
        this.mCount = 0;
        this.usC = false;
        this.fAo.fix();
      }
      for (;;)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66762);
            MallOrderRecordListUI.this.vyY.notifyDataSetChanged();
            AppMethodBeat.o(66762);
          }
        });
        break;
        paramString = paramString.dnQ();
        ac.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bs.isNullOrNil(paramString))
        {
          paramn = this.vyZ.iterator();
          if (paramn.hasNext())
          {
            i locali = (i)paramn.next();
            if (!paramString.equals(locali.vxU)) {
              break label324;
            }
            this.vyZ.remove(locali);
            this.mCount = this.vyZ.size();
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
    
    private i KV(int paramInt)
    {
      AppMethodBeat.i(66764);
      i locali = (i)MallOrderRecordListUI.this.vyZ.get(paramInt);
      AppMethodBeat.o(66764);
      return locali;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66763);
      int i = MallOrderRecordListUI.this.vyZ.size();
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
        paramViewGroup.vzf = ((TextView)localView.findViewById(2131303073));
        paramViewGroup.vzh = ((TextView)localView.findViewById(2131303072));
        paramViewGroup.vzg = ((TextView)localView.findViewById(2131303071));
        paramViewGroup.vzi = ((TextView)localView.findViewById(2131303069));
        paramViewGroup.vzk = localView.findViewById(2131303066);
        paramViewGroup.vzl = ((TextView)localView.findViewById(2131303068));
        paramViewGroup.vzm = ((TextView)localView.findViewById(2131303067));
        paramViewGroup.vzj = ((TextView)localView.findViewById(2131303070));
        localView.setTag(paramViewGroup);
        locali = KV(paramInt);
        i = 0;
        if (paramInt != 0) {
          break label594;
        }
        i = 1;
        paramView = KV(0);
        localObject1 = new GregorianCalendar();
        ((GregorianCalendar)localObject1).setTimeInMillis(paramView.CreateTime * 1000L);
        paramView = MallOrderRecordListUI.gE(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2) + 1);
      }
      for (;;)
      {
        for (;;)
        {
          if (i != 0)
          {
            localObject1 = new SimpleDateFormat(MallOrderRecordListUI.this.getString(2131759579, new Object[] { "" })).format(new Date(KV(paramInt).CreateTime * 1000L));
            paramViewGroup.vzl.setText((CharSequence)localObject1);
            if ((!bs.isNullOrNil(paramView)) && (!bs.isNullOrNil((String)MallOrderRecordListUI.this.vzc.get(paramView)))) {
              paramViewGroup.vzm.setText((CharSequence)MallOrderRecordListUI.this.vzc.get(paramView));
            }
            paramViewGroup.vzk.setVisibility(0);
            label337:
            paramViewGroup.vzf.setText(locali.vxW);
            paramViewGroup.vzg.setText(locali.vxX);
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100609);
            paramInt = i;
            if (bs.isNullOrNil(locali.vyj)) {}
          }
          try
          {
            paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cd(locali.vyj, true);
            paramViewGroup.vzg.setTextColor(paramInt);
            paramViewGroup.vzh.setText(MallOrderRecordListUI.this.KU(locali.CreateTime));
            i = MallOrderRecordListUI.this.getContext().getResources().getColor(2131100611);
            paramInt = i;
            if (bs.isNullOrNil(locali.vyk)) {}
          }
          catch (Exception paramView)
          {
            try
            {
              paramInt = com.tencent.mm.plugin.wallet_core.utils.g.cd(locali.vyk, true);
              if (locali.vxV != locali.vyl)
              {
                paramView = com.tencent.mm.wallet_core.ui.e.d(locali.vxV / 100.0D, locali.vxZ);
                localObject1 = new SpannableString(paramView);
                ((SpannableString)localObject1).setSpan(new StrikethroughSpan(), 0, paramView.length(), 33);
                paramViewGroup.vzi.setText((CharSequence)localObject1);
                paramViewGroup.vzj.setTextColor(paramInt);
                paramViewGroup.vzj.setText(com.tencent.mm.wallet_core.ui.e.d(locali.vyl / 100.0D, locali.vxZ));
                AppMethodBeat.o(66765);
                return localView;
                paramViewGroup = (MallOrderRecordListUI.b)paramView.getTag();
                localView = paramView;
                break;
                label594:
                paramView = KV(paramInt);
                Object localObject2 = KV(paramInt - 1);
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
                paramView = MallOrderRecordListUI.gE(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2) + 1);
                continue;
                paramViewGroup.vzk.setVisibility(8);
                break label337;
                paramView = paramView;
                ac.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bs.nullAsNil(locali.vyj));
                paramInt = i;
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                ac.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bs.nullAsNil(locali.vyk));
                paramInt = i;
                continue;
                paramViewGroup.vzi.setText("");
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
    TextView vzf;
    TextView vzg;
    TextView vzh;
    TextView vzi;
    TextView vzj;
    View vzk;
    TextView vzl;
    TextView vzm;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */