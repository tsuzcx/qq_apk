package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.wallet_core.ui.f;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PayUMallOrderRecordListUI
  extends MallOrderRecordListUI
{
  public final String Nb(int paramInt)
  {
    AppMethodBeat.i(72077);
    String str = f.a(paramInt, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    AppMethodBeat.o(72077);
    return str;
  }
  
  public final void dBB()
  {
    AppMethodBeat.i(72073);
    addSceneEndListener(1519);
    addSceneEndListener(1544);
    AppMethodBeat.o(72073);
  }
  
  public final void dBC()
  {
    AppMethodBeat.i(72074);
    removeSceneEndListener(1519);
    removeSceneEndListener(1544);
    AppMethodBeat.o(72074);
  }
  
  public final void dBD()
  {
    AppMethodBeat.i(72076);
    doSceneProgress(new a(this.fq));
    AppMethodBeat.o(72076);
  }
  
  public final void iy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72075);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.order.a.b(paramString1));
    AppMethodBeat.o(72075);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72078);
    Object localObject;
    boolean bool;
    if ((paramn instanceof a))
    {
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (a)paramn;
      localObject = ((ckn)paramString.rr.hQE.hQJ).Hxa;
      paramn = new LinkedList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ckw localckw = (ckw)((Iterator)localObject).next();
        i locali = new i();
        locali.uuo = localckw.uuo;
        locali.wTi = localckw.wTi;
        locali.wTj = localckw.wTj;
        locali.CreateTime = localckw.CreateTime;
        locali.wTe = localckw.wTe;
        locali.wTb = localckw.wTb;
        locali.wTh = "0";
        locali.wTd = localckw.wTd;
        locali.wTg = localckw.wTg;
        locali.wTm = 1;
        locali.wTl = localckw.wTl;
        locali.wTk = localckw.wTk;
        locali.wTf = localckw.wTf;
        locali.wTa = localckw.HwR;
        locali.wTc = localckw.wTc;
        locali.wSZ = localckw.wSZ;
        paramn.add(locali);
      }
      eP(paramn);
      eQ(null);
      this.mCount = this.wUe.size();
      if (paramString.eMT() > this.mCount)
      {
        bool = true;
        this.vHj = bool;
        this.wUd.notifyDataSetChanged();
        ae.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
        ae.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + paramString.eMT());
        ae.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.vHj);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72071);
            if (PayUMallOrderRecordListUI.a(PayUMallOrderRecordListUI.this))
            {
              ae.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
              if (!PayUMallOrderRecordListUI.b(PayUMallOrderRecordListUI.this))
              {
                PayUMallOrderRecordListUI.c(PayUMallOrderRecordListUI.this).fCN();
                PayUMallOrderRecordListUI.e(PayUMallOrderRecordListUI.this).setAdapter(PayUMallOrderRecordListUI.d(PayUMallOrderRecordListUI.this));
                PayUMallOrderRecordListUI.f(PayUMallOrderRecordListUI.this);
              }
            }
            for (;;)
            {
              PayUMallOrderRecordListUI.h(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
              AppMethodBeat.o(72071);
              return;
              ae.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
              PayUMallOrderRecordListUI.g(PayUMallOrderRecordListUI.this).fCO();
            }
          }
        });
        this.isLoading = false;
        label418:
        if ((this.mCount > 0) || (this.wUe.size() != 0)) {
          break label660;
        }
        showOptionMenu(false);
        findViewById(2131299473).setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72078);
      return true;
      bool = false;
      break;
      if (!(paramn instanceof g)) {
        break label418;
      }
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (g)paramn;
      label539:
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
            AppMethodBeat.i(72072);
            PayUMallOrderRecordListUI.i(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
            AppMethodBeat.o(72072);
          }
        });
        break;
        paramString = paramString.dBy();
        ae.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bu.isNullOrNil(paramString))
        {
          paramn = this.wUe.iterator();
          if (paramn.hasNext())
          {
            localObject = (i)paramn.next();
            if (!paramString.equals(((i)localObject).wSZ)) {
              break label539;
            }
            this.wUe.remove(localObject);
            this.mCount = this.wUe.size();
          }
        }
      }
      label660:
      showOptionMenu(true);
      findViewById(2131299473).setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */