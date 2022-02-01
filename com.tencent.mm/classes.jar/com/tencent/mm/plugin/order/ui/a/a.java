package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements a.a
{
  public com.tencent.mm.wallet_core.ui.c vzp;
  
  public final List<Preference> a(final Context paramContext, final com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66800);
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    Object localObject2;
    label153:
    label357:
    int j;
    if (paramMallTransactionObject.cUB == 2)
    {
      i = 1;
      if ((!bs.isNullOrNil(paramMallTransactionObject.vxn)) && (!bs.isNullOrNil(paramMallTransactionObject.igG)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).pbZ = paramMallTransactionObject.igG;
        ((d)localObject1).mName = paramMallTransactionObject.vxn;
        ((d)localObject1).mOnClickListener = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66791);
            if (!bs.isNullOrNil(paramMallTransactionObject.vxm)) {
              e.ad(paramContext, paramMallTransactionObject.vxm);
            }
            AppMethodBeat.o(66791);
          }
        };
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      localObject2 = new i(paramContext);
      ((i)localObject2).vzP = e.d(paramMallTransactionObject.oxA, paramMallTransactionObject.vxl);
      if (i == 0) {
        break label1564;
      }
      localObject1 = paramContext.getString(2131765535);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bs.isNullOrNil(paramMallTransactionObject.vxd)) {
        ((i)localObject2).apf(paramMallTransactionObject.vxd);
      }
      localArrayList.add(localObject2);
      boolean bool = false;
      if (paramMallTransactionObject.oxA != paramMallTransactionObject.vxr)
      {
        localObject1 = new h(paramContext);
        ((h)localObject1).vzM = false;
        ((h)localObject1).vzN = true;
        localArrayList.add(localObject1);
        localObject1 = new f(paramContext);
        ((f)localObject1).setContent(e.d(paramMallTransactionObject.vxr, paramMallTransactionObject.vxl));
        ((f)localObject1).setTitle(2131765561);
        localArrayList.add(localObject1);
        bool = true;
      }
      if ((paramMallTransactionObject.oxA != paramMallTransactionObject.vxr) && (!bs.isNullOrNil(paramMallTransactionObject.vxq)))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131765547);
        ((g)localObject1).lZC = paramf;
        localObject2 = paramMallTransactionObject.vxq.split("\n");
        if (localObject2.length != 1) {
          break label1597;
        }
        ((g)localObject1).vzF = localObject2[0];
        localArrayList.add(localObject1);
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).vzM = bool;
      ((h)localObject1).vzN = true;
      localArrayList.add(localObject1);
      if ((i == 0) && (!bs.isNullOrNil(paramMallTransactionObject.vxA)))
      {
        com.tencent.mm.kernel.g.agS();
        localObject1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramMallTransactionObject.vxA);
        if ((localObject1 != null) && ((int)((b)localObject1).fLJ > 0))
        {
          localObject1 = ((b)localObject1).aaS();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131765575);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if ((paramMallTransactionObject.dAs == 31) && (i != 0) && (!bs.isNullOrNil(paramMallTransactionObject.vxH)))
      {
        com.tencent.mm.kernel.g.agS();
        localObject1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramMallTransactionObject.vxH);
        if ((localObject1 != null) && ((int)((b)localObject1).fLJ > 0))
        {
          localObject1 = ((b)localObject1).aaS();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131765559);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if (!bs.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1664;
        }
        paramf = new f(paramContext);
        if ((paramMallTransactionObject.dAs != 32) && (paramMallTransactionObject.dAs != 33) && (paramMallTransactionObject.dAs != 31)) {
          break label1654;
        }
        paramf.setTitle(2131765539);
        label667:
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bs.isNullOrNil(paramMallTransactionObject.vxL))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765587);
        paramf.setContent(paramMallTransactionObject.vxL);
        localArrayList.add(paramf);
      }
      if (!bs.isNullOrNil(paramMallTransactionObject.vxK))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765588);
        paramf.setContent(paramMallTransactionObject.vxK);
        localArrayList.add(paramf);
      }
      if (!TextUtils.isEmpty(paramMallTransactionObject.vxC))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765537);
        paramf.setContent(paramMallTransactionObject.vxC);
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
        if ((paramMallTransactionObject.dAs != 31) || (u.axw().equals(paramMallTransactionObject.vxA)) || (paramMallTransactionObject.vxB <= 0) || (bs.isNullOrNil(paramMallTransactionObject.vxA)) || (bs.isNullOrNil(paramMallTransactionObject.dad))) {
          break label1827;
        }
        localObject1 = paramContext.getString(2131762520);
        localObject2 = paramMallTransactionObject.vxf + " " + (String)localObject1;
        i = paramMallTransactionObject.vxf.length();
        j = paramMallTransactionObject.vxf.length();
        paramf.a((String)localObject2, i + 1, ((String)localObject1).length() + j + 1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66794);
            com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131762443), paramContext.getString(2131755873), paramContext.getString(2131762519), paramContext.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(66793);
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("transaction_id", a.3.this.vwT.dad);
                paramAnonymous2DialogInterface.putExtra("receiver_name", a.3.this.vwT.vxA);
                paramAnonymous2DialogInterface.putExtra("resend_msg_from_flag", 1);
                com.tencent.mm.br.d.b(a.3.this.val$context, "remittance", ".ui.RemittanceResendMsgUI", paramAnonymous2DialogInterface);
                AppMethodBeat.o(66793);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            AppMethodBeat.o(66794);
          }
        });
        label1018:
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131765542);
      paramf.setContent(e.nV(paramMallTransactionObject.hGU));
      localArrayList.add(paramf);
      if (!bs.isNullOrNil(paramMallTransactionObject.vxj))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131765563);
        localObject1 = paramMallTransactionObject.vxj;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bs.isNullOrNil(paramMallTransactionObject.vxk)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.vxk + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bs.isNullOrNil(paramMallTransactionObject.dad))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765583);
        paramf.setContent(paramMallTransactionObject.dad);
        localArrayList.add(paramf);
      }
      if (!bs.isNullOrNil(paramMallTransactionObject.vxi))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131765573);
        if (paramMallTransactionObject.dAs != 8) {
          break label1856;
        }
        paramf.setContent(paramContext.getString(2131765574));
        localObject1 = new c(paramContext);
        localObject2 = com.tencent.mm.by.a.a.b(paramContext, paramMallTransactionObject.vxi, 5, 0);
        ((c)localObject1).vzx = e.aSM(paramMallTransactionObject.vxi);
        ((c)localObject1).hua = ((Bitmap)localObject2);
        ((c)localObject1).mOnClickListener = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66795);
            if (a.this.vzp != null)
            {
              a locala = a.this;
              Bitmap localBitmap = this.val$bmp;
              String str = paramMallTransactionObject.vxi;
              if (locala.vzp != null)
              {
                locala.vzp.mh(str, str);
                locala.vzp.vuj = localBitmap;
                locala.vzp.vuk = localBitmap;
                locala.vzp.fAM();
              }
              a.this.vzp.M(paramAnonymousView, true);
            }
            AppMethodBeat.o(66795);
          }
        };
        localArrayList.add(paramf);
        localArrayList.add(localObject1);
      }
      label1326:
      if (paramMallTransactionObject.vwM.size() != 0) {
        break label1876;
      }
      i = 0;
      label1341:
      if ((i != 0) || ((bs.isNullOrNil(paramMallTransactionObject.vxv)) && (bs.isNullOrNil(paramMallTransactionObject.vxm)) && (bs.isNullOrNil(paramMallTransactionObject.vwP)))) {
        break label1882;
      }
      paramf = new h(paramContext);
      paramf.vzM = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label1412:
      if (i != 0)
      {
        paramf = new j(paramContext);
        if (paramMallTransactionObject.vwN != 1) {
          break label1927;
        }
        if ((!bs.isNullOrNil(paramMallTransactionObject.vxv)) || (!bs.isNullOrNil(paramMallTransactionObject.vxm)) || (!bs.isNullOrNil(paramMallTransactionObject.vwP)))
        {
          if (bs.isNullOrNil(paramMallTransactionObject.vxw)) {
            break label1913;
          }
          paramf.vzQ = paramMallTransactionObject.vxw;
          label1482:
          paramf.vzR = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(66797);
              paramAnonymousView = new LinkedList();
              LinkedList localLinkedList = new LinkedList();
              if (!bs.isNullOrNil(paramMallTransactionObject.vxm))
              {
                localLinkedList.add(Integer.valueOf(0));
                paramAnonymousView.add(paramContext.getString(2131765579));
              }
              if (!bs.isNullOrNil(paramMallTransactionObject.vwP))
              {
                localLinkedList.add(Integer.valueOf(1));
                paramAnonymousView.add(paramContext.getString(2131765580));
              }
              if (!bs.isNullOrNil(paramMallTransactionObject.vxv))
              {
                localLinkedList.add(Integer.valueOf(2));
                paramAnonymousView.add(paramContext.getString(2131765582));
              }
              if (localLinkedList.size() == 1)
              {
                com.tencent.mm.plugin.order.model.a.a(((Integer)localLinkedList.get(0)).intValue(), paramContext, paramMallTransactionObject);
                AppMethodBeat.o(66797);
                return;
              }
              com.tencent.mm.ui.base.h.b(paramContext, null, paramAnonymousView, localLinkedList, null, new h.d()
              {
                public final void ct(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(66796);
                  com.tencent.mm.plugin.order.model.a.a(paramAnonymous2Int2, a.5.this.val$context, a.5.this.vwT);
                  AppMethodBeat.o(66796);
                }
              });
              AppMethodBeat.o(66797);
            }
          };
        }
      }
    }
    for (;;)
    {
      paramf.vwM = paramMallTransactionObject.vwM;
      paramf.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66799);
          if (paramAnonymousView.getTag() == null)
          {
            AppMethodBeat.o(66799);
            return;
          }
          if ((paramAnonymousView.getTag() instanceof MallOrderDetailObject.HelpCenter))
          {
            paramAnonymousView = (MallOrderDetailObject.HelpCenter)paramAnonymousView.getTag();
            a.a(paramContext, paramAnonymousView.url, paramMallTransactionObject);
          }
          AppMethodBeat.o(66799);
        }
      };
      paramContext = new h(paramContext);
      paramContext.vzM = true;
      localArrayList.add(paramContext);
      localArrayList.add(paramf);
      AppMethodBeat.o(66800);
      return localArrayList;
      i = 0;
      break;
      label1564:
      if (paramMallTransactionObject.dAs == 11)
      {
        localObject1 = paramContext.getString(2131765572);
        break label153;
      }
      localObject1 = paramContext.getString(2131765534);
      break label153;
      label1597:
      ((g)localObject1).vzF = paramContext.getString(2131765549, new Object[] { Integer.valueOf(localObject2.length), e.d(paramMallTransactionObject.vxr - paramMallTransactionObject.oxA, paramMallTransactionObject.vxl) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label357;
      label1654:
      paramf.setTitle(2131765559);
      break label667;
      label1664:
      localObject1 = new f(paramContext);
      if (paramMallTransactionObject.dAs == 31)
      {
        ((f)localObject1).setTitle(2131765568);
        label1691:
        if (bs.isNullOrNil(paramMallTransactionObject.vxb)) {
          break label1815;
        }
        localObject2 = paramContext.getString(2131765538);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66792);
            paramAnonymousView = paramMallTransactionObject.desc + "\n" + paramMallTransactionObject.vxb;
            this.vzs.setContent(paramAnonymousView);
            paramf.notifyDataSetChanged();
            AppMethodBeat.o(66792);
          }
        });
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setTitle(2131765545);
        break label1691;
        label1815:
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      label1827:
      paramf.setContent(paramMallTransactionObject.vxf);
      if (bs.isNullOrNil(paramMallTransactionObject.vxg)) {
        break label1018;
      }
      paramf.ape(paramMallTransactionObject.vxg);
      break label1018;
      label1856:
      paramf.setContent(paramMallTransactionObject.vxi);
      localArrayList.add(paramf);
      break label1326;
      label1876:
      i = 1;
      break label1341;
      label1882:
      paramf = new h(paramContext);
      paramf.vzM = true;
      paramf.mLw = false;
      localArrayList.add(paramf);
      break label1412;
      label1913:
      paramf.vzQ = paramContext.getString(2131765581);
      break label1482;
      label1927:
      if (!bs.isNullOrNil(paramMallTransactionObject.vxw))
      {
        paramf.vzQ = paramMallTransactionObject.vxw;
        paramf.vzR = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66798);
            a.a(paramContext, paramMallTransactionObject.vxv, paramMallTransactionObject);
            AppMethodBeat.o(66798);
          }
        };
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a
 * JD-Core Version:    0.7.0.1
 */