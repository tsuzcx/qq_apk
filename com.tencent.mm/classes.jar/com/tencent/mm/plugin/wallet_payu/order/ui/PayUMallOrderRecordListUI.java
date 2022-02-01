package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.protobuf.dks;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PayUMallOrderRecordListUI
  extends MallOrderRecordListUI
{
  public final String aaW(int paramInt)
  {
    AppMethodBeat.i(72077);
    String str = com.tencent.mm.wallet_core.ui.g.a(paramInt, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    AppMethodBeat.o(72077);
    return str;
  }
  
  public final void fmT()
  {
    AppMethodBeat.i(72073);
    addSceneEndListener(1519);
    addSceneEndListener(1544);
    AppMethodBeat.o(72073);
  }
  
  public final void fmU()
  {
    AppMethodBeat.i(72074);
    removeSceneEndListener(1519);
    removeSceneEndListener(1544);
    AppMethodBeat.o(72074);
  }
  
  public final void fmV()
  {
    AppMethodBeat.i(72076);
    doSceneProgress(new a(this.zP));
    AppMethodBeat.o(72076);
  }
  
  public final void ju(String paramString1, String paramString2)
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
      localObject = ((dkj)d.c.b(paramString.rr.lBS)).TRM;
      paramq = new LinkedList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dks localdks = (dks)((Iterator)localObject).next();
        i locali = new i();
        locali.CQz = localdks.CQz;
        locali.GIq = localdks.GIq;
        locali.GIr = localdks.GIr;
        locali.CreateTime = localdks.CreateTime;
        locali.GIm = localdks.GIm;
        locali.GIj = localdks.GIj;
        locali.GIp = "0";
        locali.GIl = localdks.GIl;
        locali.GIo = localdks.GIo;
        locali.GIu = 1;
        locali.GIt = localdks.GIt;
        locali.GIs = localdks.GIs;
        locali.GIn = localdks.GIn;
        locali.GIi = localdks.TRD;
        locali.GIk = localdks.GIk;
        locali.GIh = localdks.GIh;
        paramq.add(locali);
      }
      gq(paramq);
      gr(null);
      this.mCount = this.GJl.size();
      if (paramString.gNi() > this.mCount)
      {
        bool = true;
        this.EGI = bool;
        this.GJk.notifyDataSetChanged();
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + paramString.gNi());
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.EGI);
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
                PayUMallOrderRecordListUI.c(PayUMallOrderRecordListUI.this).hJK();
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
              PayUMallOrderRecordListUI.g(PayUMallOrderRecordListUI.this).hJL();
            }
          }
        });
        this.isLoading = false;
        label418:
        if ((this.mCount > 0) || (this.GJl.size() != 0)) {
          break label660;
        }
        showOptionMenu(false);
        findViewById(a.f.empty_tip_layout).setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72078);
      return true;
      bool = false;
      break;
      if (!(paramq instanceof com.tencent.mm.plugin.order.model.g)) {
        break label418;
      }
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (com.tencent.mm.plugin.order.model.g)paramq;
      label539:
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
            AppMethodBeat.i(72072);
            PayUMallOrderRecordListUI.i(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
            AppMethodBeat.o(72072);
          }
        });
        break;
        paramString = paramString.fmQ();
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!Util.isNullOrNil(paramString))
        {
          paramq = this.GJl.iterator();
          if (paramq.hasNext())
          {
            localObject = (i)paramq.next();
            if (!paramString.equals(((i)localObject).GIh)) {
              break label539;
            }
            this.GJl.remove(localObject);
            this.mCount = this.GJl.size();
          }
        }
      }
      label660:
      showOptionMenu(true);
      findViewById(a.f.empty_tip_layout).setVisibility(8);
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