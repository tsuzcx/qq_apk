package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements a.a
{
  public com.tencent.mm.wallet_core.ui.c wEJ;
  
  public final List<Preference> a(Context paramContext, com.tencent.mm.ui.base.preference.f paramf, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66800);
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    Object localObject2;
    label153:
    label356:
    int j;
    if (paramMallTransactionObject.dfR == 2)
    {
      i = 1;
      if ((!bt.isNullOrNil(paramMallTransactionObject.wCH)) && (!bt.isNullOrNil(paramMallTransactionObject.iAa)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).pFJ = paramMallTransactionObject.iAa;
        ((d)localObject1).mName = paramMallTransactionObject.wCH;
        ((d)localObject1).mOnClickListener = new a.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      localObject2 = new i(paramContext);
      ((i)localObject2).wFj = e.d(paramMallTransactionObject.paV, paramMallTransactionObject.wCF);
      if (i == 0) {
        break label1563;
      }
      localObject1 = paramContext.getString(2131765535);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bt.isNullOrNil(paramMallTransactionObject.wCx)) {
        ((i)localObject2).auf(paramMallTransactionObject.wCx);
      }
      localArrayList.add(localObject2);
      boolean bool = false;
      if (paramMallTransactionObject.paV != paramMallTransactionObject.wCL)
      {
        localObject1 = new h(paramContext);
        ((h)localObject1).wFg = false;
        ((h)localObject1).wFh = true;
        localArrayList.add(localObject1);
        localObject1 = new f(paramContext);
        ((f)localObject1).setContent(e.d(paramMallTransactionObject.wCL, paramMallTransactionObject.wCF));
        ((f)localObject1).setTitle(2131765561);
        localArrayList.add(localObject1);
        bool = true;
      }
      if ((paramMallTransactionObject.paV != paramMallTransactionObject.wCL) && (!bt.isNullOrNil(paramMallTransactionObject.wCK)))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131765547);
        ((g)localObject1).mzx = paramf;
        localObject2 = paramMallTransactionObject.wCK.split("\n");
        if (localObject2.length != 1) {
          break label1596;
        }
        ((g)localObject1).wEZ = localObject2[0];
        localArrayList.add(localObject1);
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).wFg = bool;
      ((h)localObject1).wFh = true;
      localArrayList.add(localObject1);
      if ((i == 0) && (!bt.isNullOrNil(paramMallTransactionObject.wCU)))
      {
        com.tencent.mm.kernel.g.ajD();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramMallTransactionObject.wCU);
        if ((localObject1 != null) && ((int)((b)localObject1).gfj > 0))
        {
          localObject1 = ((b)localObject1).adv();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131765575);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if ((paramMallTransactionObject.dMF == 31) && (i != 0) && (!bt.isNullOrNil(paramMallTransactionObject.wDb)))
      {
        com.tencent.mm.kernel.g.ajD();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramMallTransactionObject.wDb);
        if ((localObject1 != null) && ((int)((b)localObject1).gfj > 0))
        {
          localObject1 = ((b)localObject1).adv();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131765559);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1663;
        }
        paramf = new f(paramContext);
        if ((paramMallTransactionObject.dMF != 32) && (paramMallTransactionObject.dMF != 33) && (paramMallTransactionObject.dMF != 31)) {
          break label1653;
        }
        paramf.setTitle(2131765539);
        label666:
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.wDf))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765587);
        paramf.setContent(paramMallTransactionObject.wDf);
        localArrayList.add(paramf);
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.wDe))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765588);
        paramf.setContent(paramMallTransactionObject.wDe);
        localArrayList.add(paramf);
      }
      if (!TextUtils.isEmpty(paramMallTransactionObject.wCW))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765537);
        paramf.setContent(paramMallTransactionObject.wCW);
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
        if ((paramMallTransactionObject.dMF != 31) || (u.aAm().equals(paramMallTransactionObject.wCU)) || (paramMallTransactionObject.wCV <= 0) || (bt.isNullOrNil(paramMallTransactionObject.wCU)) || (bt.isNullOrNil(paramMallTransactionObject.dlv))) {
          break label1826;
        }
        localObject1 = paramContext.getString(2131762520);
        localObject2 = paramMallTransactionObject.wCz + " " + (String)localObject1;
        i = paramMallTransactionObject.wCz.length();
        j = paramMallTransactionObject.wCz.length();
        paramf.a((String)localObject2, i + 1, ((String)localObject1).length() + j + 1, new a.3(this, paramContext, paramMallTransactionObject));
        label1017:
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765542);
      paramf.setContent(e.ov(paramMallTransactionObject.hZE));
      localArrayList.add(paramf);
      if (!bt.isNullOrNil(paramMallTransactionObject.wCD))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131765563);
        localObject1 = paramMallTransactionObject.wCD;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bt.isNullOrNil(paramMallTransactionObject.wCE)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.wCE + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.dlv))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765583);
        paramf.setContent(paramMallTransactionObject.dlv);
        localArrayList.add(paramf);
      }
      if (!bt.isNullOrNil(paramMallTransactionObject.wCC))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765573);
        if (paramMallTransactionObject.dMF != 8) {
          break label1855;
        }
        paramf.setContent(paramContext.getString(2131765574));
        localObject1 = new c(paramContext);
        localObject2 = com.tencent.mm.bz.a.a.b(paramContext, paramMallTransactionObject.wCC, 5, 0);
        ((c)localObject1).wER = e.aYL(paramMallTransactionObject.wCC);
        ((c)localObject1).hMs = ((Bitmap)localObject2);
        ((c)localObject1).mOnClickListener = new a.4(this, (Bitmap)localObject2, paramMallTransactionObject);
        localArrayList.add(paramf);
        localArrayList.add(localObject1);
      }
      label1325:
      if (paramMallTransactionObject.wCg.size() != 0) {
        break label1875;
      }
      i = 0;
      label1340:
      if ((i != 0) || ((bt.isNullOrNil(paramMallTransactionObject.wCP)) && (bt.isNullOrNil(paramMallTransactionObject.wCG)) && (bt.isNullOrNil(paramMallTransactionObject.wCj)))) {
        break label1881;
      }
      paramf = new h(paramContext);
      paramf.wFg = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label1411:
      if (i != 0)
      {
        paramf = new j(paramContext);
        if (paramMallTransactionObject.wCh != 1) {
          break label1926;
        }
        if ((!bt.isNullOrNil(paramMallTransactionObject.wCP)) || (!bt.isNullOrNil(paramMallTransactionObject.wCG)) || (!bt.isNullOrNil(paramMallTransactionObject.wCj)))
        {
          if (bt.isNullOrNil(paramMallTransactionObject.wCQ)) {
            break label1912;
          }
          paramf.wFk = paramMallTransactionObject.wCQ;
          label1481:
          paramf.wFl = new a.5(this, paramMallTransactionObject, paramContext);
        }
      }
    }
    for (;;)
    {
      paramf.wCg = paramMallTransactionObject.wCg;
      paramf.mOnClickListener = new a.7(this, paramContext, paramMallTransactionObject);
      paramContext = new h(paramContext);
      paramContext.wFg = true;
      localArrayList.add(paramContext);
      localArrayList.add(paramf);
      AppMethodBeat.o(66800);
      return localArrayList;
      i = 0;
      break;
      label1563:
      if (paramMallTransactionObject.dMF == 11)
      {
        localObject1 = paramContext.getString(2131765572);
        break label153;
      }
      localObject1 = paramContext.getString(2131765534);
      break label153;
      label1596:
      ((g)localObject1).wEZ = paramContext.getString(2131765549, new Object[] { Integer.valueOf(localObject2.length), e.d(paramMallTransactionObject.wCL - paramMallTransactionObject.paV, paramMallTransactionObject.wCF) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label356;
      label1653:
      paramf.setTitle(2131765559);
      break label666;
      label1663:
      localObject1 = new f(paramContext);
      if (paramMallTransactionObject.dMF == 31)
      {
        ((f)localObject1).setTitle(2131765568);
        label1690:
        if (bt.isNullOrNil(paramMallTransactionObject.wCv)) {
          break label1814;
        }
        localObject2 = paramContext.getString(2131765538);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new a.2(this, paramMallTransactionObject, (f)localObject1, paramf));
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setTitle(2131765545);
        break label1690;
        label1814:
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      label1826:
      paramf.setContent(paramMallTransactionObject.wCz);
      if (bt.isNullOrNil(paramMallTransactionObject.wCA)) {
        break label1017;
      }
      paramf.aue(paramMallTransactionObject.wCA);
      break label1017;
      label1855:
      paramf.setContent(paramMallTransactionObject.wCC);
      localArrayList.add(paramf);
      break label1325;
      label1875:
      i = 1;
      break label1340;
      label1881:
      paramf = new h(paramContext);
      paramf.wFg = true;
      paramf.nlS = false;
      localArrayList.add(paramf);
      break label1411;
      label1912:
      paramf.wFk = paramContext.getString(2131765581);
      break label1481;
      label1926:
      if (!bt.isNullOrNil(paramMallTransactionObject.wCQ))
      {
        paramf.wFk = paramMallTransactionObject.wCQ;
        paramf.wFl = new a.6(this, paramContext, paramMallTransactionObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a
 * JD-Core Version:    0.7.0.1
 */