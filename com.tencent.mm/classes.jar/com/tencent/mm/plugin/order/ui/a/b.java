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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements a.a
{
  public final List<Preference> a(final Context paramContext, final com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66804);
    ArrayList localArrayList = new ArrayList();
    if (paramMallTransactionObject.cUB == 2) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      if ((!bs.isNullOrNil(paramMallTransactionObject.vxn)) && (!bs.isNullOrNil(paramMallTransactionObject.igG)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).pbZ = paramMallTransactionObject.igG;
        ((d)localObject1).mName = paramMallTransactionObject.vxn;
        ((d)localObject1).mOnClickListener = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66802);
            if (!bs.isNullOrNil(paramMallTransactionObject.vxm)) {
              e.ad(paramContext, paramMallTransactionObject.vxm);
            }
            AppMethodBeat.o(66802);
          }
        };
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      ac.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + paramMallTransactionObject.vxC + " and fetchTotalFee is " + paramMallTransactionObject.vxM);
      if (TextUtils.isEmpty(paramMallTransactionObject.vxC)) {
        break;
      }
      localObject1 = new i(paramContext);
      ((i)localObject1).vzP = e.d(paramMallTransactionObject.vxM, paramMallTransactionObject.vxl);
      ((i)localObject1).setTitle(paramContext.getString(2131765536));
      if (!bs.isNullOrNil(paramMallTransactionObject.vxN)) {
        ((i)localObject1).apf(paramMallTransactionObject.vxN);
      }
      localArrayList.add(localObject1);
      localObject1 = new h(paramContext);
      ((h)localObject1).vzM = false;
      ((h)localObject1).vzN = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765553);
      ((f)localObject1).setContent(e.d(paramMallTransactionObject.oxA, paramMallTransactionObject.vxl));
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765537);
      ((f)localObject1).setContent(paramMallTransactionObject.vxC);
      localArrayList.add(localObject1);
      if (!bs.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1136;
        }
        paramf = new f(paramContext);
        paramf.setTitle(2131765559);
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bs.isNullOrNil(paramMallTransactionObject.vxa))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765560);
        paramf.setContent(paramMallTransactionObject.vxa);
        localArrayList.add(paramf);
      }
      if (!bs.isNullOrNil(paramMallTransactionObject.vxf))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765576);
        paramf.setContent(paramMallTransactionObject.vxf);
        if (!bs.isNullOrNil(paramMallTransactionObject.vxg)) {
          paramf.ape(paramMallTransactionObject.vxg);
        }
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765556);
      paramf.setContent(e.nV(paramMallTransactionObject.hGU));
      localArrayList.add(paramf);
      if (paramMallTransactionObject.vxy <= 0) {
        break label1279;
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765554);
      paramf.setContent(e.nV(paramMallTransactionObject.vxy));
      localArrayList.add(paramf);
      label563:
      if (!bs.isNullOrNil(paramMallTransactionObject.vxj))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131765555);
        localObject1 = paramMallTransactionObject.vxj;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bs.isNullOrNil(paramMallTransactionObject.vxk)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.vxk + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bs.isNullOrNil(paramMallTransactionObject.vxi))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765558);
        paramf.setContent(paramMallTransactionObject.vxi);
        localArrayList.add(paramf);
      }
      if ((bs.isNullOrNil(paramMallTransactionObject.vxv)) && (bs.isNullOrNil(paramMallTransactionObject.vxm)) && (bs.isNullOrNil(paramMallTransactionObject.vwP))) {
        break label1336;
      }
      paramf = new h(paramContext);
      paramf.vzM = true;
      localArrayList.add(paramf);
      localArrayList.add(a.a(paramContext, paramMallTransactionObject));
      label766:
      AppMethodBeat.o(66804);
      return localArrayList;
    }
    Object localObject2 = new i(paramContext);
    ((i)localObject2).vzP = e.d(paramMallTransactionObject.oxA, paramMallTransactionObject.vxl);
    label819:
    boolean bool2;
    if (i != 0)
    {
      localObject1 = paramContext.getString(2131765535);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bs.isNullOrNil(paramMallTransactionObject.vxd)) {
        ((i)localObject2).apf(paramMallTransactionObject.vxd);
      }
      localArrayList.add(localObject2);
      if ((paramMallTransactionObject.oxA == paramMallTransactionObject.vxr) || (paramMallTransactionObject.vxr <= 0.0D)) {
        break label1367;
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).vzM = false;
      ((h)localObject1).vzN = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setContent(e.d(paramMallTransactionObject.vxr, paramMallTransactionObject.vxl));
      ((f)localObject1).setTitle(2131765561);
      localArrayList.add(localObject1);
      bool2 = true;
      bool1 = bool2;
      if (!bs.isNullOrNil(paramMallTransactionObject.vxq))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131765547);
        ((g)localObject1).lZC = paramf;
        localObject2 = paramMallTransactionObject.vxq.split("\n");
        if (localObject2.length != 1) {
          break label1079;
        }
        ((g)localObject1).vzF = localObject2[0];
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
      ((h)localObject1).vzM = bool1;
      ((h)localObject1).vzN = true;
      localArrayList.add(localObject1);
      break;
      localObject1 = paramContext.getString(2131765553);
      break label819;
      ((g)localObject1).vzF = paramContext.getString(2131765549, new Object[] { Integer.valueOf(localObject2.length), e.d(paramMallTransactionObject.vxr - paramMallTransactionObject.oxA, paramMallTransactionObject.vxl) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label1018;
      label1136:
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765545);
      if (!bs.isNullOrNil(paramMallTransactionObject.vxb))
      {
        localObject2 = paramContext.getString(2131765538);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        int j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66803);
            paramAnonymousView = paramMallTransactionObject.desc + "\n" + paramMallTransactionObject.vxb;
            this.vzs.setContent(paramAnonymousView);
            paramf.notifyDataSetChanged();
            AppMethodBeat.o(66803);
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
      if (paramMallTransactionObject.vxx > 0)
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765557);
        paramf.setContent(e.nV(paramMallTransactionObject.vxx));
        localArrayList.add(paramf);
        break label563;
      }
      ac.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
      break label563;
      paramContext = new h(paramContext);
      paramContext.vzM = true;
      paramContext.mLw = false;
      localArrayList.add(paramContext);
      break label766;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b
 * JD-Core Version:    0.7.0.1
 */