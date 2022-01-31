package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.a;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
  public final String Bj(int paramInt)
  {
    AppMethodBeat.i(48436);
    String str = e.a(paramInt, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    AppMethodBeat.o(48436);
    return str;
  }
  
  public final void cax()
  {
    AppMethodBeat.i(48432);
    addSceneEndListener(1519);
    addSceneEndListener(1544);
    AppMethodBeat.o(48432);
  }
  
  public final void cay()
  {
    AppMethodBeat.i(48433);
    removeSceneEndListener(1519);
    removeSceneEndListener(1544);
    AppMethodBeat.o(48433);
  }
  
  public final void caz()
  {
    AppMethodBeat.i(48435);
    doSceneProgress(new a(this.Fb));
    AppMethodBeat.o(48435);
  }
  
  public final void fI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48434);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.order.a.b(paramString1));
    AppMethodBeat.o(48434);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48437);
    Object localObject;
    boolean bool;
    if ((paramm instanceof a))
    {
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (a)paramm;
      localObject = ((blt)paramString.rr.fsW.fta).xAt;
      paramm = new LinkedList();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bmd localbmd = (bmd)((Iterator)localObject).next();
        i locali = new i();
        locali.ntp = localbmd.ntp;
        locali.pqh = localbmd.pqh;
        locali.pqi = localbmd.pqi;
        locali.CreateTime = localbmd.CreateTime;
        locali.pqd = localbmd.pqd;
        locali.pqa = localbmd.pqa;
        locali.pqg = "0";
        locali.pqc = localbmd.pqc;
        locali.pqf = localbmd.pqf;
        locali.pql = 1;
        locali.pqk = localbmd.pqk;
        locali.pqj = localbmd.pqj;
        locali.pqe = localbmd.pqe;
        locali.ppZ = localbmd.xAm;
        locali.pqb = localbmd.pqb;
        locali.ppY = localbmd.ppY;
        paramm.add(locali);
      }
      cu(paramm);
      cv(null);
      this.mCount = this.prd.size();
      if (paramString.cXr() > this.mCount)
      {
        bool = true;
        this.orF = bool;
        this.prc.notifyDataSetChanged();
        ab.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
        ab.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + paramString.cXr());
        ab.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.orF);
        this.mHandler.post(new PayUMallOrderRecordListUI.1(this));
        this.isLoading = false;
        label418:
        if ((this.mCount > 0) || (this.prd.size() != 0)) {
          break label660;
        }
        showOptionMenu(false);
        findViewById(2131826003).setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(48437);
      return true;
      bool = false;
      break;
      if (!(paramm instanceof g)) {
        break label418;
      }
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      paramString = (g)paramm;
      label539:
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
        this.mHandler.post(new PayUMallOrderRecordListUI.2(this));
        break;
        paramString = paramString.cau();
        ab.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(paramString)));
        if (!bo.isNullOrNil(paramString))
        {
          paramm = this.prd.iterator();
          if (paramm.hasNext())
          {
            localObject = (i)paramm.next();
            if (!paramString.equals(((i)localObject).ppY)) {
              break label539;
            }
            this.prd.remove(localObject);
            this.mCount = this.prd.size();
          }
        }
      }
      label660:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI
 * JD-Core Version:    0.7.0.1
 */