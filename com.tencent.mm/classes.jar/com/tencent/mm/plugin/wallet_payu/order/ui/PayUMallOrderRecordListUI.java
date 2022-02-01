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
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.caf;
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
  public final String IV(int paramInt)
  {
    AppMethodBeat.i(72077);
    String str = e.a(paramInt, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    AppMethodBeat.o(72077);
    return str;
  }
  
  public final void dal()
  {
    AppMethodBeat.i(72073);
    addSceneEndListener(1519);
    addSceneEndListener(1544);
    AppMethodBeat.o(72073);
  }
  
  public final void dam()
  {
    AppMethodBeat.i(72074);
    removeSceneEndListener(1519);
    removeSceneEndListener(1544);
    AppMethodBeat.o(72074);
  }
  
  public final void dan()
  {
    AppMethodBeat.i(72076);
    doSceneProgress(new a(this.LZ));
    AppMethodBeat.o(72076);
  }
  
  public final void hO(String paramString1, String paramString2)
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
      localObject = ((bzw)paramString.rr.gUT.gUX).DWC;
      paramn = new LinkedList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        caf localcaf = (caf)((Iterator)localObject).next();
        i locali = new i();
        locali.scR = localcaf.scR;
        locali.uph = localcaf.uph;
        locali.upi = localcaf.upi;
        locali.CreateTime = localcaf.CreateTime;
        locali.upd = localcaf.upd;
        locali.upa = localcaf.upa;
        locali.upg = "0";
        locali.upc = localcaf.upc;
        locali.upf = localcaf.upf;
        locali.upl = 1;
        locali.upk = localcaf.upk;
        locali.upj = localcaf.upj;
        locali.upe = localcaf.upe;
        locali.uoZ = localcaf.DWt;
        locali.upb = localcaf.upb;
        locali.uoY = localcaf.uoY;
        paramn.add(locali);
      }
      er(paramn);
      es(null);
      this.mCount = this.uqd.size();
      if (paramString.efL() > this.mCount)
      {
        bool = true;
        this.tkj = bool;
        this.uqc.notifyDataSetChanged();
        ad.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
        ad.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + paramString.efL());
        ad.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.tkj);
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
                PayUMallOrderRecordListUI.c(PayUMallOrderRecordListUI.this).eSM();
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
              PayUMallOrderRecordListUI.g(PayUMallOrderRecordListUI.this).eSN();
            }
          }
        });
        this.isLoading = false;
        label418:
        if ((this.mCount > 0) || (this.uqd.size() != 0)) {
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
            AppMethodBeat.i(72072);
            PayUMallOrderRecordListUI.i(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
            AppMethodBeat.o(72072);
          }
        });
        break;
        paramString = paramString.dai();
        ad.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bt.isNullOrNil(paramString))
        {
          paramn = this.uqd.iterator();
          if (paramn.hasNext())
          {
            localObject = (i)paramn.next();
            if (!paramString.equals(((i)localObject).uoY)) {
              break label539;
            }
            this.uqd.remove(localObject);
            this.mCount = this.uqd.size();
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