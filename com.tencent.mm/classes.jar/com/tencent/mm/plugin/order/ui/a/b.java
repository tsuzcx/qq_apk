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
  public final List<Preference> a(final Context paramContext, final com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66804);
    ArrayList localArrayList = new ArrayList();
    if (paramMallTransactionObject.cXf == 2) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      if ((!bt.isNullOrNil(paramMallTransactionObject.uor)) && (!bt.isNullOrNil(paramMallTransactionObject.hGe)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).oyz = paramMallTransactionObject.hGe;
        ((d)localObject1).mName = paramMallTransactionObject.uor;
        ((d)localObject1).mOnClickListener = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66802);
            if (!bt.isNullOrNil(paramMallTransactionObject.uoq)) {
              e.ac(paramContext, paramMallTransactionObject.uoq);
            }
            AppMethodBeat.o(66802);
          }
        };
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      ad.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + paramMallTransactionObject.uoG + " and fetchTotalFee is " + paramMallTransactionObject.uoQ);
      if (TextUtils.isEmpty(paramMallTransactionObject.uoG)) {
        break;
      }
      localObject1 = new i(paramContext);
      ((i)localObject1).uqT = e.d(paramMallTransactionObject.uoQ, paramMallTransactionObject.uop);
      ((i)localObject1).setTitle(paramContext.getString(2131765536));
      if (!bt.isNullOrNil(paramMallTransactionObject.uoR)) {
        ((i)localObject1).akh(paramMallTransactionObject.uoR);
      }
      localArrayList.add(localObject1);
      localObject1 = new h(paramContext);
      ((h)localObject1).uqQ = false;
      ((h)localObject1).uqR = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765553);
      ((f)localObject1).setContent(e.d(paramMallTransactionObject.nUf, paramMallTransactionObject.uop));
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765537);
      ((f)localObject1).setContent(paramMallTransactionObject.uoG);
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
      if (!bt.isNullOrNil(paramMallTransactionObject.uoe))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765560);
        paramf.setContent(paramMallTransactionObject.uoe);
        localArrayList.add(paramf);
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.uoj))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765576);
        paramf.setContent(paramMallTransactionObject.uoj);
        if (!bt.isNullOrNil(paramMallTransactionObject.uok)) {
          paramf.akg(paramMallTransactionObject.uok);
        }
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765556);
      paramf.setContent(e.nh(paramMallTransactionObject.hgr));
      localArrayList.add(paramf);
      if (paramMallTransactionObject.uoC <= 0) {
        break label1279;
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765554);
      paramf.setContent(e.nh(paramMallTransactionObject.uoC));
      localArrayList.add(paramf);
      label563:
      if (!bt.isNullOrNil(paramMallTransactionObject.uon))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131765555);
        localObject1 = paramMallTransactionObject.uon;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bt.isNullOrNil(paramMallTransactionObject.uoo)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.uoo + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.uom))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765558);
        paramf.setContent(paramMallTransactionObject.uom);
        localArrayList.add(paramf);
      }
      if ((bt.isNullOrNil(paramMallTransactionObject.uoz)) && (bt.isNullOrNil(paramMallTransactionObject.uoq)) && (bt.isNullOrNil(paramMallTransactionObject.unT))) {
        break label1336;
      }
      paramf = new h(paramContext);
      paramf.uqQ = true;
      localArrayList.add(paramf);
      localArrayList.add(a.a(paramContext, paramMallTransactionObject));
      label766:
      AppMethodBeat.o(66804);
      return localArrayList;
    }
    Object localObject2 = new i(paramContext);
    ((i)localObject2).uqT = e.d(paramMallTransactionObject.nUf, paramMallTransactionObject.uop);
    label819:
    boolean bool2;
    if (i != 0)
    {
      localObject1 = paramContext.getString(2131765535);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bt.isNullOrNil(paramMallTransactionObject.uoh)) {
        ((i)localObject2).akh(paramMallTransactionObject.uoh);
      }
      localArrayList.add(localObject2);
      if ((paramMallTransactionObject.nUf == paramMallTransactionObject.uov) || (paramMallTransactionObject.uov <= 0.0D)) {
        break label1367;
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).uqQ = false;
      ((h)localObject1).uqR = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setContent(e.d(paramMallTransactionObject.uov, paramMallTransactionObject.uop));
      ((f)localObject1).setTitle(2131765561);
      localArrayList.add(localObject1);
      bool2 = true;
      bool1 = bool2;
      if (!bt.isNullOrNil(paramMallTransactionObject.uou))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131765547);
        ((g)localObject1).lxI = paramf;
        localObject2 = paramMallTransactionObject.uou.split("\n");
        if (localObject2.length != 1) {
          break label1079;
        }
        ((g)localObject1).uqJ = localObject2[0];
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
      ((h)localObject1).uqQ = bool1;
      ((h)localObject1).uqR = true;
      localArrayList.add(localObject1);
      break;
      localObject1 = paramContext.getString(2131765553);
      break label819;
      ((g)localObject1).uqJ = paramContext.getString(2131765549, new Object[] { Integer.valueOf(localObject2.length), e.d(paramMallTransactionObject.uov - paramMallTransactionObject.nUf, paramMallTransactionObject.uop) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label1018;
      label1136:
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131765545);
      if (!bt.isNullOrNil(paramMallTransactionObject.uof))
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
            paramAnonymousView = paramMallTransactionObject.desc + "\n" + paramMallTransactionObject.uof;
            this.uqw.setContent(paramAnonymousView);
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
      if (paramMallTransactionObject.uoB > 0)
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765557);
        paramf.setContent(e.nh(paramMallTransactionObject.uoB));
        localArrayList.add(paramf);
        break label563;
      }
      ad.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
      break label563;
      paramContext = new h(paramContext);
      paramContext.uqQ = true;
      paramContext.mjw = false;
      localArrayList.add(paramContext);
      break label766;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b
 * JD-Core Version:    0.7.0.1
 */