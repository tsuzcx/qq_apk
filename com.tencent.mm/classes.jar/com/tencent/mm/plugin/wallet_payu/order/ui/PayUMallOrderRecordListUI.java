package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.dbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
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
  public final String Ul(int paramInt)
  {
    AppMethodBeat.i(72077);
    String str = f.a(paramInt, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    AppMethodBeat.o(72077);
    return str;
  }
  
  public final void eBm()
  {
    AppMethodBeat.i(72073);
    addSceneEndListener(1519);
    addSceneEndListener(1544);
    AppMethodBeat.o(72073);
  }
  
  public final void eBn()
  {
    AppMethodBeat.i(72074);
    removeSceneEndListener(1519);
    removeSceneEndListener(1544);
    AppMethodBeat.o(72074);
  }
  
  public final void eBo()
  {
    AppMethodBeat.i(72076);
    doSceneProgress(new a(this.fs));
    AppMethodBeat.o(72076);
  }
  
  public final void jj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72075);
    doSceneProgress(new b(paramString1));
    AppMethodBeat.o(72075);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72078);
    Object localObject;
    boolean bool;
    if ((paramq instanceof a))
    {
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (a)paramq;
      localObject = ((dav)paramString.rr.iLL.iLR).MGa;
      paramq = new LinkedList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dbe localdbe = (dbe)((Iterator)localObject).next();
        i locali = new i();
        locali.xMq = localdbe.xMq;
        locali.APc = localdbe.APc;
        locali.APd = localdbe.APd;
        locali.CreateTime = localdbe.CreateTime;
        locali.AOY = localdbe.AOY;
        locali.AOV = localdbe.AOV;
        locali.APb = "0";
        locali.AOX = localdbe.AOX;
        locali.APa = localdbe.APa;
        locali.APg = 1;
        locali.APf = localdbe.APf;
        locali.APe = localdbe.APe;
        locali.AOZ = localdbe.AOZ;
        locali.AOU = localdbe.MFR;
        locali.AOW = localdbe.AOW;
        locali.AOT = localdbe.AOT;
        paramq.add(locali);
      }
      fM(paramq);
      fN(null);
      this.mCount = this.AQa.size();
      if (paramString.fUC() > this.mCount)
      {
        bool = true;
        this.zci = bool;
        this.APZ.notifyDataSetChanged();
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + paramString.fUC());
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.zci);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72071);
            if (PayUMallOrderRecordListUI.a(PayUMallOrderRecordListUI.this))
            {
              Log.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
              if (!PayUMallOrderRecordListUI.b(PayUMallOrderRecordListUI.this))
              {
                PayUMallOrderRecordListUI.c(PayUMallOrderRecordListUI.this).gKM();
                PayUMallOrderRecordListUI.e(PayUMallOrderRecordListUI.this).setAdapter(PayUMallOrderRecordListUI.d(PayUMallOrderRecordListUI.this));
                PayUMallOrderRecordListUI.f(PayUMallOrderRecordListUI.this);
              }
            }
            for (;;)
            {
              PayUMallOrderRecordListUI.h(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
              AppMethodBeat.o(72071);
              return;
              Log.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
              PayUMallOrderRecordListUI.g(PayUMallOrderRecordListUI.this).gKN();
            }
          }
        });
        this.isLoading = false;
        label418:
        if ((this.mCount > 0) || (this.AQa.size() != 0)) {
          break label660;
        }
        showOptionMenu(false);
        findViewById(2131300102).setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72078);
      return true;
      bool = false;
      break;
      if (!(paramq instanceof g)) {
        break label418;
      }
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (g)paramq;
      label539:
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
            AppMethodBeat.i(72072);
            PayUMallOrderRecordListUI.i(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
            AppMethodBeat.o(72072);
          }
        });
        break;
        paramString = paramString.eBj();
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!Util.isNullOrNil(paramString))
        {
          paramq = this.AQa.iterator();
          if (paramq.hasNext())
          {
            localObject = (i)paramq.next();
            if (!paramString.equals(((i)localObject).AOT)) {
              break label539;
            }
            this.AQa.remove(localObject);
            this.mCount = this.AQa.size();
          }
        }
      }
      label660:
      showOptionMenu(true);
      findViewById(2131300102).setVisibility(8);
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