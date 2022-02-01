package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PayUMallOrderRecordListUI
  extends MallOrderRecordListUI
{
  public final String Mw(int paramInt)
  {
    AppMethodBeat.i(72077);
    String str = e.a(paramInt, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    AppMethodBeat.o(72077);
    return str;
  }
  
  public final void dyl()
  {
    AppMethodBeat.i(72073);
    addSceneEndListener(1519);
    addSceneEndListener(1544);
    AppMethodBeat.o(72073);
  }
  
  public final void dym()
  {
    AppMethodBeat.i(72074);
    removeSceneEndListener(1519);
    removeSceneEndListener(1544);
    AppMethodBeat.o(72074);
  }
  
  public final void dyn()
  {
    AppMethodBeat.i(72076);
    doSceneProgress(new a(this.fq));
    AppMethodBeat.o(72076);
  }
  
  public final void is(String paramString1, String paramString2)
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
      localObject = ((cjt)paramString.rr.hNL.hNQ).HdA;
      paramn = new LinkedList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ckc localckc = (ckc)((Iterator)localObject).next();
        i locali = new i();
        locali.uiR = localckc.uiR;
        locali.wDx = localckc.wDx;
        locali.wDy = localckc.wDy;
        locali.CreateTime = localckc.CreateTime;
        locali.wDt = localckc.wDt;
        locali.wDq = localckc.wDq;
        locali.wDw = "0";
        locali.wDs = localckc.wDs;
        locali.wDv = localckc.wDv;
        locali.wDB = 1;
        locali.wDA = localckc.wDA;
        locali.wDz = localckc.wDz;
        locali.wDu = localckc.wDu;
        locali.wDp = localckc.Hdr;
        locali.wDr = localckc.wDr;
        locali.wDo = localckc.wDo;
        paramn.add(locali);
      }
      eI(paramn);
      eJ(null);
      this.mCount = this.wEt.size();
      if (paramString.eJl() > this.mCount)
      {
        bool = true;
        this.vvf = bool;
        this.wEs.notifyDataSetChanged();
        ad.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
        ad.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + paramString.eJl());
        ad.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.vvf);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72071);
            if (PayUMallOrderRecordListUI.a(PayUMallOrderRecordListUI.this))
            {
              ad.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
              if (!PayUMallOrderRecordListUI.b(PayUMallOrderRecordListUI.this))
              {
                PayUMallOrderRecordListUI.c(PayUMallOrderRecordListUI.this).fyL();
                PayUMallOrderRecordListUI.e(PayUMallOrderRecordListUI.this).setAdapter(PayUMallOrderRecordListUI.d(PayUMallOrderRecordListUI.this));
                PayUMallOrderRecordListUI.f(PayUMallOrderRecordListUI.this);
              }
            }
            for (;;)
            {
              PayUMallOrderRecordListUI.h(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
              AppMethodBeat.o(72071);
              return;
              ad.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
              PayUMallOrderRecordListUI.g(PayUMallOrderRecordListUI.this).fyM();
            }
          }
        });
        this.isLoading = false;
        label418:
        if ((this.mCount > 0) || (this.wEt.size() != 0)) {
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
            AppMethodBeat.i(72072);
            PayUMallOrderRecordListUI.i(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
            AppMethodBeat.o(72072);
          }
        });
        break;
        paramString = paramString.dyi();
        ad.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bt.isNullOrNil(paramString))
        {
          paramn = this.wEt.iterator();
          if (paramn.hasNext())
          {
            localObject = (i)paramn.next();
            if (!paramString.equals(((i)localObject).wDo)) {
              break label539;
            }
            this.wEt.remove(localObject);
            this.mCount = this.wEt.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */