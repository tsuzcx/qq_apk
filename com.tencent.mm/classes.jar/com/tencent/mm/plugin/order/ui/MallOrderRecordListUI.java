package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI
  extends WalletBaseUI
{
  protected int Fb;
  public MMLoadMoreListView ejW;
  protected boolean isLoading;
  protected int mCount;
  protected ak mHandler;
  protected Dialog mProgressDialog;
  public boolean orF;
  public MallOrderRecordListUI.a prc;
  protected List<i> prd;
  protected String pre;
  public boolean prf;
  protected Map<String, String> prg;
  
  public MallOrderRecordListUI()
  {
    AppMethodBeat.i(43860);
    this.mHandler = null;
    this.mProgressDialog = null;
    this.prc = null;
    this.prd = new ArrayList();
    this.orF = true;
    this.mCount = 0;
    this.Fb = 0;
    this.pre = null;
    this.prf = false;
    this.isLoading = false;
    this.prg = new HashMap();
    AppMethodBeat.o(43860);
  }
  
  private boolean WL(String paramString)
  {
    AppMethodBeat.i(43870);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(43870);
      return false;
    }
    int i = 0;
    while (i < this.prd.size())
    {
      i locali = (i)this.prd.get(i);
      if ((locali != null) && (paramString.equals(locali.ppY)))
      {
        AppMethodBeat.o(43870);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(43870);
    return false;
  }
  
  private static String fa(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43874);
    String str = paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(43874);
    return str;
  }
  
  protected final void Bi(int paramInt)
  {
    AppMethodBeat.i(43868);
    if (paramInt >= this.prd.size())
    {
      AppMethodBeat.o(43868);
      return;
    }
    i locali = (i)this.prd.get(paramInt);
    if (locali != null)
    {
      Bundle localBundle = getInput();
      localBundle.putString("key_trans_id", locali.ppY);
      localBundle.putInt("key_pay_type", locali.pqf);
      localBundle.putString("bill_id", locali.pqq);
      com.tencent.mm.wallet_core.a.j(this, localBundle);
    }
    AppMethodBeat.o(43868);
  }
  
  protected String Bj(int paramInt)
  {
    AppMethodBeat.i(43872);
    String str = com.tencent.mm.wallet_core.ui.e.RW(paramInt);
    AppMethodBeat.o(43872);
    return str;
  }
  
  protected void cax()
  {
    AppMethodBeat.i(43862);
    addSceneEndListener(388);
    addSceneEndListener(389);
    AppMethodBeat.o(43862);
  }
  
  protected void cay()
  {
    AppMethodBeat.i(43863);
    removeSceneEndListener(388);
    removeSceneEndListener(389);
    AppMethodBeat.o(43863);
  }
  
  protected void caz()
  {
    AppMethodBeat.i(43866);
    doSceneProgress(new com.tencent.mm.plugin.order.model.e(this.Fb, this.pre));
    AppMethodBeat.o(43866);
  }
  
  protected final void cu(List<i> paramList)
  {
    AppMethodBeat.i(43869);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(43869);
      return;
    }
    if (this.prd == null) {
      this.prd = new ArrayList();
    }
    int i = 0;
    while (i < paramList.size())
    {
      i locali = (i)paramList.get(i);
      if (!WL(locali.ppY)) {
        this.prd.add(locali);
      }
      i += 1;
    }
    AppMethodBeat.o(43869);
  }
  
  protected final void cv(List<d> paramList)
  {
    AppMethodBeat.i(43873);
    if (paramList == null)
    {
      AppMethodBeat.o(43873);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      d locald = (d)paramList.get(i);
      if (locald != null)
      {
        String str = fa(locald.year, locald.month);
        this.prg.put(str, locald.ppS);
      }
      i += 1;
    }
    AppMethodBeat.o(43873);
  }
  
  protected void fI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43865);
    doSceneProgress(new g(paramString1, paramString2));
    AppMethodBeat.o(43865);
  }
  
  public int getLayoutId()
  {
    return 2130970102;
  }
  
  public void initView()
  {
    AppMethodBeat.i(43867);
    if ((com.tencent.mm.wallet_core.a.aM(this) instanceof com.tencent.mm.plugin.order.a.a))
    {
      this.isLoading = true;
      caz();
    }
    setMMTitle(2131301444);
    this.ejW = ((MMLoadMoreListView)findViewById(2131826002));
    this.prc = new MallOrderRecordListUI.a(this);
    this.ejW.setAdapter(this.prc);
    this.ejW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(43849);
        MallOrderRecordListUI.this.Bi(paramAnonymousInt);
        com.tencent.mm.wallet_core.ui.e.RX(26);
        AppMethodBeat.o(43849);
      }
    });
    this.ejW.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(43851);
        if (paramAnonymousInt >= MallOrderRecordListUI.this.prd.size())
        {
          AppMethodBeat.o(43851);
          return true;
        }
        com.tencent.mm.ui.base.h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(2131305371), null, MallOrderRecordListUI.this.getResources().getString(2131296901), new MallOrderRecordListUI.2.1(this, paramAnonymousInt));
        AppMethodBeat.o(43851);
        return true;
      }
    });
    this.ejW.setOnLoadMoreListener(new MallOrderRecordListUI.3(this));
    Object localObject = new vd();
    ((vd)localObject).cLE.bSd = "6";
    ((vd)localObject).callback = new MallOrderRecordListUI.4(this, (vd)localObject);
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.plugin.order.a.b.cak().onChange();
    this.prc.notifyDataSetChanged();
    localObject = com.tencent.mm.plugin.report.service.h.qsU;
    com.tencent.mm.plugin.order.a.b.cak();
    ((com.tencent.mm.plugin.report.service.h)localObject).e(11036, new Object[] { Integer.valueOf(com.tencent.mm.plugin.order.a.b.can().cas()) });
    AppMethodBeat.o(43867);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43861);
    super.onCreate(paramBundle);
    this.mHandler = new ak();
    cax();
    initView();
    this.Fb = 0;
    this.pre = null;
    AppMethodBeat.o(43861);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43871);
    cay();
    super.onDestroy();
    AppMethodBeat.o(43871);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(43864);
    super.onResume();
    if (this.prc != null) {
      this.prc.notifyDataSetChanged();
    }
    AppMethodBeat.o(43864);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(43875);
    boolean bool;
    if ((paramm instanceof com.tencent.mm.plugin.order.model.e))
    {
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (com.tencent.mm.plugin.order.model.e)paramm;
      this.pre = paramString.ppV;
      cu(paramString.ppT);
      cv(paramString.ppU);
      this.mCount = this.prd.size();
      if (paramString.kNn > this.mCount)
      {
        bool = true;
        this.orF = bool;
        this.prc.notifyDataSetChanged();
        ab.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
        ab.d("MicroMsg.WalletOrderListUI", "orders list total record: " + paramString.kNn);
        ab.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.orF);
        this.mHandler.post(new MallOrderRecordListUI.5(this));
        this.isLoading = false;
        label202:
        if ((this.mCount > 0) || (this.prd.size() != 0)) {
          break label445;
        }
        showOptionMenu(false);
        findViewById(2131826003).setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(43875);
      return true;
      bool = false;
      break;
      if (!(paramm instanceof g)) {
        break label202;
      }
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (g)paramm;
      label324:
      if (paramString.cat() == 2)
      {
        if (this.prd != null) {
          this.prd.clear();
        }
        this.mCount = 0;
        this.orF = false;
        this.ejW.dDZ();
      }
      for (;;)
      {
        this.mHandler.post(new MallOrderRecordListUI.6(this));
        break;
        paramString = paramString.cau();
        ab.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bo.isNullOrNil(paramString))
        {
          paramm = this.prd.iterator();
          if (paramm.hasNext())
          {
            i locali = (i)paramm.next();
            if (!paramString.equals(locali.ppY)) {
              break label324;
            }
            this.prd.remove(locali);
            this.mCount = this.prd.size();
          }
        }
      }
      label445:
      showOptionMenu(true);
      findViewById(2131826003).setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */