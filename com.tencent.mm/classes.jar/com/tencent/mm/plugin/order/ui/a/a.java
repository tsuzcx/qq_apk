package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements a.a
{
  public com.tencent.mm.wallet_core.ui.c prt;
  
  public final List<Preference> a(final Context paramContext, com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(43893);
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    Object localObject2;
    label153:
    label357:
    int j;
    if (paramMallTransactionObject.cii == 2)
    {
      i = 1;
      if ((!bo.isNullOrNil(paramMallTransactionObject.ppr)) && (!bo.isNullOrNil(paramMallTransactionObject.hiQ)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).lix = paramMallTransactionObject.hiQ;
        ((d)localObject1).mName = paramMallTransactionObject.ppr;
        ((d)localObject1).mOnClickListener = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(43884);
            if (!bo.isNullOrNil(paramMallTransactionObject.ppq)) {
              e.ad(paramContext, paramMallTransactionObject.ppq);
            }
            AppMethodBeat.o(43884);
          }
        };
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      localObject2 = new i(paramContext);
      ((i)localObject2).prT = e.e(paramMallTransactionObject.kNS, paramMallTransactionObject.ppp);
      if (i == 0) {
        break label1564;
      }
      localObject1 = paramContext.getString(2131305321);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bo.isNullOrNil(paramMallTransactionObject.pph)) {
        ((i)localObject2).WN(paramMallTransactionObject.pph);
      }
      localArrayList.add(localObject2);
      boolean bool = false;
      if (paramMallTransactionObject.kNS != paramMallTransactionObject.ppv)
      {
        localObject1 = new h(paramContext);
        ((h)localObject1).prQ = false;
        ((h)localObject1).prR = true;
        localArrayList.add(localObject1);
        localObject1 = new f(paramContext);
        ((f)localObject1).setContent(e.e(paramMallTransactionObject.ppv, paramMallTransactionObject.ppp));
        ((f)localObject1).setTitle(2131305347);
        localArrayList.add(localObject1);
        bool = true;
      }
      if ((paramMallTransactionObject.kNS != paramMallTransactionObject.ppv) && (!bo.isNullOrNil(paramMallTransactionObject.ppu)))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131305333);
        ((g)localObject1).iLA = paramf;
        localObject2 = paramMallTransactionObject.ppu.split("\n");
        if (localObject2.length != 1) {
          break label1597;
        }
        ((g)localObject1).prJ = localObject2[0];
        localArrayList.add(localObject1);
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).prQ = bool;
      ((h)localObject1).prR = true;
      localArrayList.add(localObject1);
      if ((i == 0) && (!bo.isNullOrNil(paramMallTransactionObject.ppE)))
      {
        com.tencent.mm.kernel.g.RM();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramMallTransactionObject.ppE);
        if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).euF > 0))
        {
          localObject1 = ((com.tencent.mm.n.a)localObject1).Of();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131305361);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if ((paramMallTransactionObject.cLI == 31) && (i != 0) && (!bo.isNullOrNil(paramMallTransactionObject.ppL)))
      {
        com.tencent.mm.kernel.g.RM();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramMallTransactionObject.ppL);
        if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).euF > 0))
        {
          localObject1 = ((com.tencent.mm.n.a)localObject1).Of();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131305345);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if (!bo.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1664;
        }
        paramf = new f(paramContext);
        if ((paramMallTransactionObject.cLI != 32) && (paramMallTransactionObject.cLI != 33) && (paramMallTransactionObject.cLI != 31)) {
          break label1654;
        }
        paramf.setTitle(2131305325);
        label667:
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bo.isNullOrNil(paramMallTransactionObject.ppP))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131305373);
        paramf.setContent(paramMallTransactionObject.ppP);
        localArrayList.add(paramf);
      }
      if (!bo.isNullOrNil(paramMallTransactionObject.ppO))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131305374);
        paramf.setContent(paramMallTransactionObject.ppO);
        localArrayList.add(paramf);
      }
      if (!TextUtils.isEmpty(paramMallTransactionObject.ppG))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131305323);
        paramf.setContent(paramMallTransactionObject.ppG);
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
        if ((paramMallTransactionObject.cLI != 31) || (r.Zn().equals(paramMallTransactionObject.ppE)) || (paramMallTransactionObject.ppF <= 0) || (bo.isNullOrNil(paramMallTransactionObject.ppE)) || (bo.isNullOrNil(paramMallTransactionObject.cnJ))) {
          break label1827;
        }
        localObject1 = paramContext.getString(2131302614);
        localObject2 = paramMallTransactionObject.ppj + " " + (String)localObject1;
        i = paramMallTransactionObject.ppj.length();
        j = paramMallTransactionObject.ppj.length();
        paramf.a((String)localObject2, i + 1, ((String)localObject1).length() + j + 1, new a.3(this, paramContext, paramMallTransactionObject));
        label1018:
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131305328);
      paramf.setContent(e.kB(paramMallTransactionObject.fDT));
      localArrayList.add(paramf);
      if (!bo.isNullOrNil(paramMallTransactionObject.ppn))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131305349);
        localObject1 = paramMallTransactionObject.ppn;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bo.isNullOrNil(paramMallTransactionObject.ppo)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.ppo + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bo.isNullOrNil(paramMallTransactionObject.cnJ))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131305369);
        paramf.setContent(paramMallTransactionObject.cnJ);
        localArrayList.add(paramf);
      }
      if (!bo.isNullOrNil(paramMallTransactionObject.ppm))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131305359);
        if (paramMallTransactionObject.cLI != 8) {
          break label1856;
        }
        paramf.setContent(paramContext.getString(2131305360));
        localObject1 = new c(paramContext);
        localObject2 = com.tencent.mm.by.a.a.b(paramContext, paramMallTransactionObject.ppm, 5, 0);
        ((c)localObject1).prB = e.awg(paramMallTransactionObject.ppm);
        ((c)localObject1).frG = ((Bitmap)localObject2);
        ((c)localObject1).mOnClickListener = new a.4(this, (Bitmap)localObject2, paramMallTransactionObject);
        localArrayList.add(paramf);
        localArrayList.add(localObject1);
      }
      label1326:
      if (paramMallTransactionObject.poQ.size() != 0) {
        break label1876;
      }
      i = 0;
      label1341:
      if ((i != 0) || ((bo.isNullOrNil(paramMallTransactionObject.ppz)) && (bo.isNullOrNil(paramMallTransactionObject.ppq)) && (bo.isNullOrNil(paramMallTransactionObject.poT)))) {
        break label1882;
      }
      paramf = new h(paramContext);
      paramf.prQ = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label1412:
      if (i != 0)
      {
        paramf = new j(paramContext);
        if (paramMallTransactionObject.poR != 1) {
          break label1927;
        }
        if ((!bo.isNullOrNil(paramMallTransactionObject.ppz)) || (!bo.isNullOrNil(paramMallTransactionObject.ppq)) || (!bo.isNullOrNil(paramMallTransactionObject.poT)))
        {
          if (bo.isNullOrNil(paramMallTransactionObject.ppA)) {
            break label1913;
          }
          paramf.prU = paramMallTransactionObject.ppA;
          label1482:
          paramf.prV = new a.5(this, paramMallTransactionObject, paramContext);
        }
      }
    }
    for (;;)
    {
      paramf.poQ = paramMallTransactionObject.poQ;
      paramf.mOnClickListener = new a.7(this, paramContext, paramMallTransactionObject);
      paramContext = new h(paramContext);
      paramContext.prQ = true;
      localArrayList.add(paramContext);
      localArrayList.add(paramf);
      AppMethodBeat.o(43893);
      return localArrayList;
      i = 0;
      break;
      label1564:
      if (paramMallTransactionObject.cLI == 11)
      {
        localObject1 = paramContext.getString(2131305358);
        break label153;
      }
      localObject1 = paramContext.getString(2131305320);
      break label153;
      label1597:
      ((g)localObject1).prJ = paramContext.getString(2131305335, new Object[] { Integer.valueOf(localObject2.length), e.e(paramMallTransactionObject.ppv - paramMallTransactionObject.kNS, paramMallTransactionObject.ppp) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label357;
      label1654:
      paramf.setTitle(2131305345);
      break label667;
      label1664:
      localObject1 = new f(paramContext);
      if (paramMallTransactionObject.cLI == 31)
      {
        ((f)localObject1).setTitle(2131305354);
        label1691:
        if (bo.isNullOrNil(paramMallTransactionObject.ppf)) {
          break label1815;
        }
        localObject2 = paramContext.getString(2131305324);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new a.2(this, paramMallTransactionObject, (f)localObject1, paramf));
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setTitle(2131305331);
        break label1691;
        label1815:
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      label1827:
      paramf.setContent(paramMallTransactionObject.ppj);
      if (bo.isNullOrNil(paramMallTransactionObject.ppk)) {
        break label1018;
      }
      paramf.WM(paramMallTransactionObject.ppk);
      break label1018;
      label1856:
      paramf.setContent(paramMallTransactionObject.ppm);
      localArrayList.add(paramf);
      break label1326;
      label1876:
      i = 1;
      break label1341;
      label1882:
      paramf = new h(paramContext);
      paramf.prQ = true;
      paramf.jts = false;
      localArrayList.add(paramf);
      break label1412;
      label1913:
      paramf.prU = paramContext.getString(2131305367);
      break label1482;
      label1927:
      if (!bo.isNullOrNil(paramMallTransactionObject.ppA))
      {
        paramf.prU = paramMallTransactionObject.ppA;
        paramf.prV = new a.6(this, paramContext, paramMallTransactionObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a
 * JD-Core Version:    0.7.0.1
 */