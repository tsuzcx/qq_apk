package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements a.a
{
  public final List<Preference> a(Context paramContext, final com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(43897);
    ArrayList localArrayList = new ArrayList();
    if (paramMallTransactionObject.cii == 2) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      if ((!bo.isNullOrNil(paramMallTransactionObject.ppr)) && (!bo.isNullOrNil(paramMallTransactionObject.hiQ)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).lix = paramMallTransactionObject.hiQ;
        ((d)localObject1).mName = paramMallTransactionObject.ppr;
        ((d)localObject1).mOnClickListener = new b.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      ab.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + paramMallTransactionObject.ppG + " and fetchTotalFee is " + paramMallTransactionObject.ppQ);
      if (TextUtils.isEmpty(paramMallTransactionObject.ppG)) {
        break;
      }
      localObject1 = new i(paramContext);
      ((i)localObject1).prT = e.e(paramMallTransactionObject.ppQ, paramMallTransactionObject.ppp);
      ((i)localObject1).setTitle(paramContext.getString(2131305322));
      if (!bo.isNullOrNil(paramMallTransactionObject.ppR)) {
        ((i)localObject1).WN(paramMallTransactionObject.ppR);
      }
      localArrayList.add(localObject1);
      localObject1 = new h(paramContext);
      ((h)localObject1).prQ = false;
      ((h)localObject1).prR = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131305339);
      ((f)localObject1).setContent(e.e(paramMallTransactionObject.kNS, paramMallTransactionObject.ppp));
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131305323);
      ((f)localObject1).setContent(paramMallTransactionObject.ppG);
      localArrayList.add(localObject1);
      if (!bo.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1136;
        }
        paramf = new f(paramContext);
        paramf.setTitle(2131305345);
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bo.isNullOrNil(paramMallTransactionObject.ppe))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131305346);
        paramf.setContent(paramMallTransactionObject.ppe);
        localArrayList.add(paramf);
      }
      if (!bo.isNullOrNil(paramMallTransactionObject.ppj))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131305362);
        paramf.setContent(paramMallTransactionObject.ppj);
        if (!bo.isNullOrNil(paramMallTransactionObject.ppk)) {
          paramf.WM(paramMallTransactionObject.ppk);
        }
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131305342);
      paramf.setContent(e.kB(paramMallTransactionObject.fDT));
      localArrayList.add(paramf);
      if (paramMallTransactionObject.ppC <= 0) {
        break label1279;
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131305340);
      paramf.setContent(e.kB(paramMallTransactionObject.ppC));
      localArrayList.add(paramf);
      label563:
      if (!bo.isNullOrNil(paramMallTransactionObject.ppn))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131305341);
        localObject1 = paramMallTransactionObject.ppn;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bo.isNullOrNil(paramMallTransactionObject.ppo)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.ppo + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bo.isNullOrNil(paramMallTransactionObject.ppm))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131305344);
        paramf.setContent(paramMallTransactionObject.ppm);
        localArrayList.add(paramf);
      }
      if ((bo.isNullOrNil(paramMallTransactionObject.ppz)) && (bo.isNullOrNil(paramMallTransactionObject.ppq)) && (bo.isNullOrNil(paramMallTransactionObject.poT))) {
        break label1336;
      }
      paramf = new h(paramContext);
      paramf.prQ = true;
      localArrayList.add(paramf);
      localArrayList.add(a.a(paramContext, paramMallTransactionObject));
      label766:
      AppMethodBeat.o(43897);
      return localArrayList;
    }
    Object localObject2 = new i(paramContext);
    ((i)localObject2).prT = e.e(paramMallTransactionObject.kNS, paramMallTransactionObject.ppp);
    label819:
    boolean bool2;
    if (i != 0)
    {
      localObject1 = paramContext.getString(2131305321);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bo.isNullOrNil(paramMallTransactionObject.pph)) {
        ((i)localObject2).WN(paramMallTransactionObject.pph);
      }
      localArrayList.add(localObject2);
      if ((paramMallTransactionObject.kNS == paramMallTransactionObject.ppv) || (paramMallTransactionObject.ppv <= 0.0D)) {
        break label1367;
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).prQ = false;
      ((h)localObject1).prR = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setContent(e.e(paramMallTransactionObject.ppv, paramMallTransactionObject.ppp));
      ((f)localObject1).setTitle(2131305347);
      localArrayList.add(localObject1);
      bool2 = true;
      bool1 = bool2;
      if (!bo.isNullOrNil(paramMallTransactionObject.ppu))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131305333);
        ((g)localObject1).iLA = paramf;
        localObject2 = paramMallTransactionObject.ppu.split("\n");
        if (localObject2.length != 1) {
          break label1079;
        }
        ((g)localObject1).prJ = localObject2[0];
        label1018:
        localArrayList.add(localObject1);
      }
    }
    label1079:
    label1336:
    label1367:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject1 = new h(paramContext);
      ((h)localObject1).prQ = bool1;
      ((h)localObject1).prR = true;
      localArrayList.add(localObject1);
      break;
      localObject1 = paramContext.getString(2131305339);
      break label819;
      ((g)localObject1).prJ = paramContext.getString(2131305335, new Object[] { Integer.valueOf(localObject2.length), e.e(paramMallTransactionObject.ppv - paramMallTransactionObject.kNS, paramMallTransactionObject.ppp) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label1018;
      label1136:
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131305331);
      if (!bo.isNullOrNil(paramMallTransactionObject.ppf))
      {
        localObject2 = paramContext.getString(2131305324);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        int j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(43896);
            paramAnonymousView = paramMallTransactionObject.desc + "\n" + paramMallTransactionObject.ppf;
            this.prw.setContent(paramAnonymousView);
            paramf.notifyDataSetChanged();
            AppMethodBeat.o(43896);
          }
        });
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      label1279:
      if (paramMallTransactionObject.ppB > 0)
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131305343);
        paramf.setContent(e.kB(paramMallTransactionObject.ppB));
        localArrayList.add(paramf);
        break label563;
      }
      ab.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
      break label563;
      paramContext = new h(paramContext);
      paramContext.prQ = true;
      paramContext.jts = false;
      localArrayList.add(paramContext);
      break label766;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b
 * JD-Core Version:    0.7.0.1
 */