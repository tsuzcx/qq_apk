package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements a.a
{
  public com.tencent.mm.wallet_core.ui.c wUu;
  
  public final List<Preference> a(final Context paramContext, com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66800);
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    Object localObject2;
    label153:
    label356:
    int j;
    if (paramMallTransactionObject.dgT == 2)
    {
      i = 1;
      if ((!bu.isNullOrNil(paramMallTransactionObject.wSs)) && (!bu.isNullOrNil(paramMallTransactionObject.iCT)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).pMn = paramMallTransactionObject.iCT;
        ((d)localObject1).mName = paramMallTransactionObject.wSs;
        ((d)localObject1).mOnClickListener = new a.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      localObject2 = new i(paramContext);
      ((i)localObject2).wUU = com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.phz, paramMallTransactionObject.wSq);
      if (i == 0) {
        break label1563;
      }
      localObject1 = paramContext.getString(2131765535);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bu.isNullOrNil(paramMallTransactionObject.wSi)) {
        ((i)localObject2).avu(paramMallTransactionObject.wSi);
      }
      localArrayList.add(localObject2);
      boolean bool = false;
      if (paramMallTransactionObject.phz != paramMallTransactionObject.wSw)
      {
        localObject1 = new h(paramContext);
        ((h)localObject1).wUR = false;
        ((h)localObject1).wUS = true;
        localArrayList.add(localObject1);
        localObject1 = new f(paramContext);
        ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.wSw, paramMallTransactionObject.wSq));
        ((f)localObject1).setTitle(2131765561);
        localArrayList.add(localObject1);
        bool = true;
      }
      if ((paramMallTransactionObject.phz != paramMallTransactionObject.wSw) && (!bu.isNullOrNil(paramMallTransactionObject.wSv)))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131765547);
        ((g)localObject1).mEx = paramf;
        localObject2 = paramMallTransactionObject.wSv.split("\n");
        if (localObject2.length != 1) {
          break label1596;
        }
        ((g)localObject1).wUK = localObject2[0];
        localArrayList.add(localObject1);
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).wUR = bool;
      ((h)localObject1).wUS = true;
      localArrayList.add(localObject1);
      if ((i == 0) && (!bu.isNullOrNil(paramMallTransactionObject.wSF)))
      {
        com.tencent.mm.kernel.g.ajS();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramMallTransactionObject.wSF);
        if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).ght > 0))
        {
          localObject1 = ((com.tencent.mm.contact.c)localObject1).adG();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131765575);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if ((paramMallTransactionObject.dNV == 31) && (i != 0) && (!bu.isNullOrNil(paramMallTransactionObject.wSM)))
      {
        com.tencent.mm.kernel.g.ajS();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramMallTransactionObject.wSM);
        if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).ght > 0))
        {
          localObject1 = ((com.tencent.mm.contact.c)localObject1).adG();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131765559);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if (!bu.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1663;
        }
        paramf = new f(paramContext);
        if ((paramMallTransactionObject.dNV != 32) && (paramMallTransactionObject.dNV != 33) && (paramMallTransactionObject.dNV != 31)) {
          break label1653;
        }
        paramf.setTitle(2131765539);
        label666:
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bu.isNullOrNil(paramMallTransactionObject.wSQ))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765587);
        paramf.setContent(paramMallTransactionObject.wSQ);
        localArrayList.add(paramf);
      }
      if (!bu.isNullOrNil(paramMallTransactionObject.wSP))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765588);
        paramf.setContent(paramMallTransactionObject.wSP);
        localArrayList.add(paramf);
      }
      if (!TextUtils.isEmpty(paramMallTransactionObject.wSH))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765537);
        paramf.setContent(paramMallTransactionObject.wSH);
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
        if ((paramMallTransactionObject.dNV != 31) || (v.aAC().equals(paramMallTransactionObject.wSF)) || (paramMallTransactionObject.wSG <= 0) || (bu.isNullOrNil(paramMallTransactionObject.wSF)) || (bu.isNullOrNil(paramMallTransactionObject.dmx))) {
          break label1826;
        }
        localObject1 = paramContext.getString(2131762520);
        localObject2 = paramMallTransactionObject.wSk + " " + (String)localObject1;
        i = paramMallTransactionObject.wSk.length();
        j = paramMallTransactionObject.wSk.length();
        paramf.a((String)localObject2, i + 1, ((String)localObject1).length() + j + 1, new a.3(this, paramContext, paramMallTransactionObject));
        label1017:
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765542);
      paramf.setContent(com.tencent.mm.wallet_core.ui.f.oy(paramMallTransactionObject.icw));
      localArrayList.add(paramf);
      if (!bu.isNullOrNil(paramMallTransactionObject.wSo))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131765563);
        localObject1 = paramMallTransactionObject.wSo;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bu.isNullOrNil(paramMallTransactionObject.wSp)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.wSp + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bu.isNullOrNil(paramMallTransactionObject.dmx))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765583);
        paramf.setContent(paramMallTransactionObject.dmx);
        localArrayList.add(paramf);
      }
      if (!bu.isNullOrNil(paramMallTransactionObject.wSn))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765573);
        if (paramMallTransactionObject.dNV != 8) {
          break label1855;
        }
        paramf.setContent(paramContext.getString(2131765574));
        localObject1 = new c(paramContext);
        localObject2 = com.tencent.mm.by.a.a.b(paramContext, paramMallTransactionObject.wSn, 5, 0);
        ((c)localObject1).wUC = com.tencent.mm.wallet_core.ui.f.bao(paramMallTransactionObject.wSn);
        ((c)localObject1).hPl = ((Bitmap)localObject2);
        ((c)localObject1).mOnClickListener = new a.4(this, (Bitmap)localObject2, paramMallTransactionObject);
        localArrayList.add(paramf);
        localArrayList.add(localObject1);
      }
      label1325:
      if (paramMallTransactionObject.wRR.size() != 0) {
        break label1875;
      }
      i = 0;
      label1340:
      if ((i != 0) || ((bu.isNullOrNil(paramMallTransactionObject.wSA)) && (bu.isNullOrNil(paramMallTransactionObject.wSr)) && (bu.isNullOrNil(paramMallTransactionObject.wRU)))) {
        break label1881;
      }
      paramf = new h(paramContext);
      paramf.wUR = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label1411:
      if (i != 0)
      {
        paramf = new j(paramContext);
        if (paramMallTransactionObject.wRS != 1) {
          break label1926;
        }
        if ((!bu.isNullOrNil(paramMallTransactionObject.wSA)) || (!bu.isNullOrNil(paramMallTransactionObject.wSr)) || (!bu.isNullOrNil(paramMallTransactionObject.wRU)))
        {
          if (bu.isNullOrNil(paramMallTransactionObject.wSB)) {
            break label1912;
          }
          paramf.wUV = paramMallTransactionObject.wSB;
          label1481:
          paramf.wUW = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(66797);
              Object localObject = new b();
              ((b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
              paramAnonymousView = new LinkedList();
              localObject = new LinkedList();
              if (!bu.isNullOrNil(paramMallTransactionObject.wSr))
              {
                ((List)localObject).add(Integer.valueOf(0));
                paramAnonymousView.add(paramContext.getString(2131765579));
              }
              if (!bu.isNullOrNil(paramMallTransactionObject.wRU))
              {
                ((List)localObject).add(Integer.valueOf(1));
                paramAnonymousView.add(paramContext.getString(2131765580));
              }
              if (!bu.isNullOrNil(paramMallTransactionObject.wSA))
              {
                ((List)localObject).add(Integer.valueOf(2));
                paramAnonymousView.add(paramContext.getString(2131765582));
              }
              if (((List)localObject).size() == 1)
              {
                com.tencent.mm.plugin.order.model.a.a(((Integer)((List)localObject).get(0)).intValue(), paramContext, paramMallTransactionObject);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(66797);
                return;
              }
              com.tencent.mm.ui.base.h.b(paramContext, null, paramAnonymousView, (List)localObject, null, new h.d()
              {
                public final void cv(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(66796);
                  com.tencent.mm.plugin.order.model.a.a(paramAnonymous2Int2, a.5.this.val$context, a.5.this.wRY);
                  AppMethodBeat.o(66796);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(66797);
            }
          };
        }
      }
    }
    for (;;)
    {
      paramf.wRR = paramMallTransactionObject.wRR;
      paramf.mOnClickListener = new a.7(this, paramContext, paramMallTransactionObject);
      paramContext = new h(paramContext);
      paramContext.wUR = true;
      localArrayList.add(paramContext);
      localArrayList.add(paramf);
      AppMethodBeat.o(66800);
      return localArrayList;
      i = 0;
      break;
      label1563:
      if (paramMallTransactionObject.dNV == 11)
      {
        localObject1 = paramContext.getString(2131765572);
        break label153;
      }
      localObject1 = paramContext.getString(2131765534);
      break label153;
      label1596:
      ((g)localObject1).wUK = paramContext.getString(2131765549, new Object[] { Integer.valueOf(localObject2.length), com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.wSw - paramMallTransactionObject.phz, paramMallTransactionObject.wSq) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label356;
      label1653:
      paramf.setTitle(2131765559);
      break label666;
      label1663:
      localObject1 = new f(paramContext);
      if (paramMallTransactionObject.dNV == 31)
      {
        ((f)localObject1).setTitle(2131765568);
        label1690:
        if (bu.isNullOrNil(paramMallTransactionObject.wSg)) {
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
      paramf.setContent(paramMallTransactionObject.wSk);
      if (bu.isNullOrNil(paramMallTransactionObject.wSl)) {
        break label1017;
      }
      paramf.avt(paramMallTransactionObject.wSl);
      break label1017;
      label1855:
      paramf.setContent(paramMallTransactionObject.wSn);
      localArrayList.add(paramf);
      break label1325;
      label1875:
      i = 1;
      break label1340;
      label1881:
      paramf = new h(paramContext);
      paramf.wUR = true;
      paramf.nrc = false;
      localArrayList.add(paramf);
      break label1411;
      label1912:
      paramf.wUV = paramContext.getString(2131765581);
      break label1481;
      label1926:
      if (!bu.isNullOrNil(paramMallTransactionObject.wSB))
      {
        paramf.wUV = paramMallTransactionObject.wSB;
        paramf.wUW = new a.6(this, paramContext, paramMallTransactionObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a
 * JD-Core Version:    0.7.0.1
 */