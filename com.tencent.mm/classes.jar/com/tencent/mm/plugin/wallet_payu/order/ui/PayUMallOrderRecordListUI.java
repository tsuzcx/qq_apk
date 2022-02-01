package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Dialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.protocal.protobuf.edc;
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
  public final String afo(int paramInt)
  {
    AppMethodBeat.i(72077);
    String str = com.tencent.mm.wallet_core.ui.i.a(paramInt, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    AppMethodBeat.o(72077);
    return str;
  }
  
  public final void gxH()
  {
    AppMethodBeat.i(72073);
    addSceneEndListener(1519);
    addSceneEndListener(1544);
    AppMethodBeat.o(72073);
  }
  
  public final void gxI()
  {
    AppMethodBeat.i(72074);
    removeSceneEndListener(1519);
    removeSceneEndListener(1544);
    AppMethodBeat.o(72074);
  }
  
  public final void gxJ()
  {
    AppMethodBeat.i(72076);
    doSceneProgress(new a(this.Sc));
    AppMethodBeat.o(72076);
  }
  
  public final void kL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72075);
    doSceneProgress(new b(paramString1));
    AppMethodBeat.o(72075);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72078);
    Object localObject;
    boolean bool;
    if ((paramp instanceof a))
    {
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (a)paramp;
      localObject = ((ect)c.c.b(paramString.rr.otC)).abil;
      paramp = new LinkedList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        edc localedc = (edc)((Iterator)localObject).next();
        com.tencent.mm.plugin.order.model.i locali = new com.tencent.mm.plugin.order.model.i();
        locali.IKJ = localedc.IKJ;
        locali.MFg = localedc.MFg;
        locali.MFh = localedc.MFh;
        locali.CreateTime = localedc.CreateTime;
        locali.MFc = localedc.MFc;
        locali.MEZ = localedc.MEZ;
        locali.MFf = "0";
        locali.MFb = localedc.MFb;
        locali.MFe = localedc.MFe;
        locali.MFk = 1;
        locali.MFj = localedc.MFj;
        locali.MFi = localedc.MFi;
        locali.MFd = localedc.MFd;
        locali.MEY = localedc.abic;
        locali.MFa = localedc.MFa;
        locali.MEX = localedc.MEX;
        paramp.add(locali);
      }
      jq(paramp);
      jr(null);
      this.mCount = this.MGa.size();
      if (paramString.imx() > this.mCount)
      {
        bool = true;
        this.KzR = bool;
        this.MFZ.notifyDataSetChanged();
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + paramString.imx());
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.KzR);
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
                PayUMallOrderRecordListUI.c(PayUMallOrderRecordListUI.this).jms();
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
              PayUMallOrderRecordListUI.g(PayUMallOrderRecordListUI.this).jmt();
            }
          }
        });
        this.isLoading = false;
        label418:
        if ((this.mCount > 0) || (this.MGa.size() != 0)) {
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
      if (!(paramp instanceof g)) {
        break label418;
      }
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (g)paramp;
      label539:
      if (paramString.gxD() == 2)
      {
        if (this.MGa != null) {
          this.MGa.clear();
        }
        this.mCount = 0;
        this.KzR = false;
        this.lNP.jmt();
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
        paramString = paramString.gxE();
        Log.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!Util.isNullOrNil(paramString))
        {
          paramp = this.MGa.iterator();
          if (paramp.hasNext())
          {
            localObject = (com.tencent.mm.plugin.order.model.i)paramp.next();
            if (!paramString.equals(((com.tencent.mm.plugin.order.model.i)localObject).MEX)) {
              break label539;
            }
            this.MGa.remove(localObject);
            this.mCount = this.MGa.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */