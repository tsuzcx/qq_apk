package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements a.a
{
  public final List<Preference> a(Context paramContext, com.tencent.mm.ui.base.preference.f paramf, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66804);
    ArrayList localArrayList = new ArrayList();
    if (paramMallTransactionObject.dgT == 2) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      if ((!bu.isNullOrNil(paramMallTransactionObject.wSs)) && (!bu.isNullOrNil(paramMallTransactionObject.iCT)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).pMn = paramMallTransactionObject.iCT;
        ((d)localObject1).mName = paramMallTransactionObject.wSs;
        ((d)localObject1).mOnClickListener = new b.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      ae.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + paramMallTransactionObject.wSH + " and fetchTotalFee is " + paramMallTransactionObject.wSR);
      if (TextUtils.isEmpty(paramMallTransactionObject.wSH)) {
        break;
      }
      localObject1 = new i(paramContext);
      ((i)localObject1).wUU = com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.wSR, paramMallTransactionObject.wSq);
      ((i)localObject1).setTitle(paramContext.getString(2131765536));
      if (!bu.isNullOrNil(paramMallTransactionObject.wSS)) {
        ((i)localObject1).avu(paramMallTransactionObject.wSS);
      }
      localArrayList.add(localObject1);
      localObject1 = new h(paramContext);
      ((h)localObject1).wUR = false;
      ((h)localObject1).wUS = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765553);
      ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.phz, paramMallTransactionObject.wSq));
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765537);
      ((f)localObject1).setContent(paramMallTransactionObject.wSH);
      localArrayList.add(localObject1);
      if (!bu.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1136;
        }
        paramf = new f(paramContext);
        paramf.setTitle(2131765559);
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bu.isNullOrNil(paramMallTransactionObject.wSf))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765560);
        paramf.setContent(paramMallTransactionObject.wSf);
        localArrayList.add(paramf);
      }
      if (!bu.isNullOrNil(paramMallTransactionObject.wSk))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765576);
        paramf.setContent(paramMallTransactionObject.wSk);
        if (!bu.isNullOrNil(paramMallTransactionObject.wSl)) {
          paramf.avt(paramMallTransactionObject.wSl);
        }
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765556);
      paramf.setContent(com.tencent.mm.wallet_core.ui.f.oy(paramMallTransactionObject.icw));
      localArrayList.add(paramf);
      if (paramMallTransactionObject.wSD <= 0) {
        break label1279;
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765554);
      paramf.setContent(com.tencent.mm.wallet_core.ui.f.oy(paramMallTransactionObject.wSD));
      localArrayList.add(paramf);
      label563:
      if (!bu.isNullOrNil(paramMallTransactionObject.wSo))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131765555);
        localObject1 = paramMallTransactionObject.wSo;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bu.isNullOrNil(paramMallTransactionObject.wSp)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.wSp + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bu.isNullOrNil(paramMallTransactionObject.wSn))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765558);
        paramf.setContent(paramMallTransactionObject.wSn);
        localArrayList.add(paramf);
      }
      if ((bu.isNullOrNil(paramMallTransactionObject.wSA)) && (bu.isNullOrNil(paramMallTransactionObject.wSr)) && (bu.isNullOrNil(paramMallTransactionObject.wRU))) {
        break label1336;
      }
      paramf = new h(paramContext);
      paramf.wUR = true;
      localArrayList.add(paramf);
      localArrayList.add(a.a(paramContext, paramMallTransactionObject));
      label766:
      AppMethodBeat.o(66804);
      return localArrayList;
    }
    Object localObject2 = new i(paramContext);
    ((i)localObject2).wUU = com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.phz, paramMallTransactionObject.wSq);
    label819:
    boolean bool2;
    if (i != 0)
    {
      localObject1 = paramContext.getString(2131765535);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bu.isNullOrNil(paramMallTransactionObject.wSi)) {
        ((i)localObject2).avu(paramMallTransactionObject.wSi);
      }
      localArrayList.add(localObject2);
      if ((paramMallTransactionObject.phz == paramMallTransactionObject.wSw) || (paramMallTransactionObject.wSw <= 0.0D)) {
        break label1367;
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).wUR = false;
      ((h)localObject1).wUS = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.wSw, paramMallTransactionObject.wSq));
      ((f)localObject1).setTitle(2131765561);
      localArrayList.add(localObject1);
      bool2 = true;
      bool1 = bool2;
      if (!bu.isNullOrNil(paramMallTransactionObject.wSv))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131765547);
        ((g)localObject1).mEx = paramf;
        localObject2 = paramMallTransactionObject.wSv.split("\n");
        if (localObject2.length != 1) {
          break label1079;
        }
        ((g)localObject1).wUK = localObject2[0];
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
      ((h)localObject1).wUR = bool1;
      ((h)localObject1).wUS = true;
      localArrayList.add(localObject1);
      break;
      localObject1 = paramContext.getString(2131765553);
      break label819;
      ((g)localObject1).wUK = paramContext.getString(2131765549, new Object[] { Integer.valueOf(localObject2.length), com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.wSw - paramMallTransactionObject.phz, paramMallTransactionObject.wSq) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label1018;
      label1136:
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765545);
      if (!bu.isNullOrNil(paramMallTransactionObject.wSg))
      {
        localObject2 = paramContext.getString(2131765538);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        int j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new b.2(this, paramMallTransactionObject, (f)localObject1, paramf));
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      label1279:
      if (paramMallTransactionObject.wSC > 0)
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765557);
        paramf.setContent(com.tencent.mm.wallet_core.ui.f.oy(paramMallTransactionObject.wSC));
        localArrayList.add(paramf);
        break label563;
      }
      ae.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
      break label563;
      paramContext = new h(paramContext);
      paramContext.wUR = true;
      paramContext.nrc = false;
      localArrayList.add(paramContext);
      break label766;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b
 * JD-Core Version:    0.7.0.1
 */