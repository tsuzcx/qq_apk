package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements a.a
{
  public final List<Preference> a(Context paramContext, com.tencent.mm.ui.base.preference.f paramf, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66804);
    ArrayList localArrayList = new ArrayList();
    if (paramMallTransactionObject.dfR == 2) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      if ((!bt.isNullOrNil(paramMallTransactionObject.wCH)) && (!bt.isNullOrNil(paramMallTransactionObject.iAa)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).pFJ = paramMallTransactionObject.iAa;
        ((d)localObject1).mName = paramMallTransactionObject.wCH;
        ((d)localObject1).mOnClickListener = new b.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      ad.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + paramMallTransactionObject.wCW + " and fetchTotalFee is " + paramMallTransactionObject.wDg);
      if (TextUtils.isEmpty(paramMallTransactionObject.wCW)) {
        break;
      }
      localObject1 = new i(paramContext);
      ((i)localObject1).wFj = e.d(paramMallTransactionObject.wDg, paramMallTransactionObject.wCF);
      ((i)localObject1).setTitle(paramContext.getString(2131765536));
      if (!bt.isNullOrNil(paramMallTransactionObject.wDh)) {
        ((i)localObject1).auf(paramMallTransactionObject.wDh);
      }
      localArrayList.add(localObject1);
      localObject1 = new h(paramContext);
      ((h)localObject1).wFg = false;
      ((h)localObject1).wFh = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765553);
      ((f)localObject1).setContent(e.d(paramMallTransactionObject.paV, paramMallTransactionObject.wCF));
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765537);
      ((f)localObject1).setContent(paramMallTransactionObject.wCW);
      localArrayList.add(localObject1);
      if (!bt.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1136;
        }
        paramf = new f(paramContext);
        paramf.setTitle(2131765559);
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.wCu))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765560);
        paramf.setContent(paramMallTransactionObject.wCu);
        localArrayList.add(paramf);
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.wCz))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765576);
        paramf.setContent(paramMallTransactionObject.wCz);
        if (!bt.isNullOrNil(paramMallTransactionObject.wCA)) {
          paramf.aue(paramMallTransactionObject.wCA);
        }
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765556);
      paramf.setContent(e.ov(paramMallTransactionObject.hZE));
      localArrayList.add(paramf);
      if (paramMallTransactionObject.wCS <= 0) {
        break label1279;
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765554);
      paramf.setContent(e.ov(paramMallTransactionObject.wCS));
      localArrayList.add(paramf);
      label563:
      if (!bt.isNullOrNil(paramMallTransactionObject.wCD))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131765555);
        localObject1 = paramMallTransactionObject.wCD;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bt.isNullOrNil(paramMallTransactionObject.wCE)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.wCE + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.wCC))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765558);
        paramf.setContent(paramMallTransactionObject.wCC);
        localArrayList.add(paramf);
      }
      if ((bt.isNullOrNil(paramMallTransactionObject.wCP)) && (bt.isNullOrNil(paramMallTransactionObject.wCG)) && (bt.isNullOrNil(paramMallTransactionObject.wCj))) {
        break label1336;
      }
      paramf = new h(paramContext);
      paramf.wFg = true;
      localArrayList.add(paramf);
      localArrayList.add(a.a(paramContext, paramMallTransactionObject));
      label766:
      AppMethodBeat.o(66804);
      return localArrayList;
    }
    Object localObject2 = new i(paramContext);
    ((i)localObject2).wFj = e.d(paramMallTransactionObject.paV, paramMallTransactionObject.wCF);
    label819:
    boolean bool2;
    if (i != 0)
    {
      localObject1 = paramContext.getString(2131765535);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bt.isNullOrNil(paramMallTransactionObject.wCx)) {
        ((i)localObject2).auf(paramMallTransactionObject.wCx);
      }
      localArrayList.add(localObject2);
      if ((paramMallTransactionObject.paV == paramMallTransactionObject.wCL) || (paramMallTransactionObject.wCL <= 0.0D)) {
        break label1367;
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).wFg = false;
      ((h)localObject1).wFh = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setContent(e.d(paramMallTransactionObject.wCL, paramMallTransactionObject.wCF));
      ((f)localObject1).setTitle(2131765561);
      localArrayList.add(localObject1);
      bool2 = true;
      bool1 = bool2;
      if (!bt.isNullOrNil(paramMallTransactionObject.wCK))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131765547);
        ((g)localObject1).mzx = paramf;
        localObject2 = paramMallTransactionObject.wCK.split("\n");
        if (localObject2.length != 1) {
          break label1079;
        }
        ((g)localObject1).wEZ = localObject2[0];
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
      ((h)localObject1).wFg = bool1;
      ((h)localObject1).wFh = true;
      localArrayList.add(localObject1);
      break;
      localObject1 = paramContext.getString(2131765553);
      break label819;
      ((g)localObject1).wEZ = paramContext.getString(2131765549, new Object[] { Integer.valueOf(localObject2.length), e.d(paramMallTransactionObject.wCL - paramMallTransactionObject.paV, paramMallTransactionObject.wCF) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label1018;
      label1136:
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765545);
      if (!bt.isNullOrNil(paramMallTransactionObject.wCv))
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
      if (paramMallTransactionObject.wCR > 0)
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765557);
        paramf.setContent(e.ov(paramMallTransactionObject.wCR));
        localArrayList.add(paramf);
        break label563;
      }
      ad.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
      break label563;
      paramContext = new h(paramContext);
      paramContext.wFg = true;
      paramContext.nlS = false;
      localArrayList.add(paramContext);
      break label766;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b
 * JD-Core Version:    0.7.0.1
 */