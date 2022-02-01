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
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  public final String KU(int paramInt)
  {
    AppMethodBeat.i(72077);
    String str = e.a(paramInt, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    AppMethodBeat.o(72077);
    return str;
  }
  
  public final void dnT()
  {
    AppMethodBeat.i(72073);
    addSceneEndListener(1519);
    addSceneEndListener(1544);
    AppMethodBeat.o(72073);
  }
  
  public final void dnU()
  {
    AppMethodBeat.i(72074);
    removeSceneEndListener(1519);
    removeSceneEndListener(1544);
    AppMethodBeat.o(72074);
  }
  
  public final void dnV()
  {
    AppMethodBeat.i(72076);
    doSceneProgress(new a(this.MW));
    AppMethodBeat.o(72076);
  }
  
  public final void ih(String paramString1, String paramString2)
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
      localObject = ((ceu)paramString.rr.hvs.hvw).Ftu;
      paramn = new LinkedList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cfd localcfd = (cfd)((Iterator)localObject).next();
        i locali = new i();
        locali.tkL = localcfd.tkL;
        locali.vyd = localcfd.vyd;
        locali.vye = localcfd.vye;
        locali.CreateTime = localcfd.CreateTime;
        locali.vxZ = localcfd.vxZ;
        locali.vxW = localcfd.vxW;
        locali.vyc = "0";
        locali.vxY = localcfd.vxY;
        locali.vyb = localcfd.vyb;
        locali.vyh = 1;
        locali.vyg = localcfd.vyg;
        locali.vyf = localcfd.vyf;
        locali.vya = localcfd.vya;
        locali.vxV = localcfd.Ftl;
        locali.vxX = localcfd.vxX;
        locali.vxU = localcfd.vxU;
        paramn.add(locali);
      }
      ev(paramn);
      ew(null);
      this.mCount = this.vyZ.size();
      if (paramString.evf() > this.mCount)
      {
        bool = true;
        this.usC = bool;
        this.vyY.notifyDataSetChanged();
        ac.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
        ac.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + paramString.evf());
        ac.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.usC);
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72071);
            if (PayUMallOrderRecordListUI.a(PayUMallOrderRecordListUI.this))
            {
              ac.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
              if (!PayUMallOrderRecordListUI.b(PayUMallOrderRecordListUI.this))
              {
                PayUMallOrderRecordListUI.c(PayUMallOrderRecordListUI.this).fiw();
                PayUMallOrderRecordListUI.e(PayUMallOrderRecordListUI.this).setAdapter(PayUMallOrderRecordListUI.d(PayUMallOrderRecordListUI.this));
                PayUMallOrderRecordListUI.f(PayUMallOrderRecordListUI.this);
              }
            }
            for (;;)
            {
              PayUMallOrderRecordListUI.h(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
              AppMethodBeat.o(72071);
              return;
              ac.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
              PayUMallOrderRecordListUI.g(PayUMallOrderRecordListUI.this).fix();
            }
          }
        });
        this.isLoading = false;
        label418:
        if ((this.mCount > 0) || (this.vyZ.size() != 0)) {
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
            AppMethodBeat.i(72072);
            PayUMallOrderRecordListUI.i(PayUMallOrderRecordListUI.this).notifyDataSetChanged();
            AppMethodBeat.o(72072);
          }
        });
        break;
        paramString = paramString.dnQ();
        ac.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bs.isNullOrNil(paramString))
        {
          paramn = this.vyZ.iterator();
          if (paramn.hasNext())
          {
            localObject = (i)paramn.next();
            if (!paramString.equals(((i)localObject).vxU)) {
              break label539;
            }
            this.vyZ.remove(localObject);
            this.mCount = this.vyZ.size();
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