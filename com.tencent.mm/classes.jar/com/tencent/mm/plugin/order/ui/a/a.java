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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements a.a
{
  public com.tencent.mm.wallet_core.ui.c AQq;
  
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
    if (paramMallTransactionObject.dyc == 2)
    {
      i = 1;
      if ((!Util.isNullOrNil(paramMallTransactionObject.AOm)) && (!Util.isNullOrNil(paramMallTransactionObject.jyi)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).rcG = paramMallTransactionObject.jyi;
        ((d)localObject1).mName = paramMallTransactionObject.AOm;
        ((d)localObject1).mOnClickListener = new a.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      localObject2 = new i(paramContext);
      ((i)localObject2).AQQ = com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.qwJ, paramMallTransactionObject.AOl);
      if (i == 0) {
        break label1564;
      }
      localObject1 = paramContext.getString(2131767984);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!Util.isNullOrNil(paramMallTransactionObject.AOd)) {
        ((i)localObject2).aJH(paramMallTransactionObject.AOd);
      }
      localArrayList.add(localObject2);
      boolean bool = false;
      if (paramMallTransactionObject.qwJ != paramMallTransactionObject.AOq)
      {
        localObject1 = new h(paramContext);
        ((h)localObject1).AQN = false;
        ((h)localObject1).AQO = true;
        localArrayList.add(localObject1);
        localObject1 = new f(paramContext);
        ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.AOq, paramMallTransactionObject.AOl));
        ((f)localObject1).setTitle(2131768010);
        localArrayList.add(localObject1);
        bool = true;
      }
      if ((paramMallTransactionObject.qwJ != paramMallTransactionObject.AOq) && (!Util.isNullOrNil(paramMallTransactionObject.AOp)))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131767996);
        ((g)localObject1).nRm = paramf;
        localObject2 = paramMallTransactionObject.AOp.split("\n");
        if (localObject2.length != 1) {
          break label1597;
        }
        ((g)localObject1).AQG = localObject2[0];
        localArrayList.add(localObject1);
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).AQN = bool;
      ((h)localObject1).AQO = true;
      localArrayList.add(localObject1);
      if ((i == 0) && (!Util.isNullOrNil(paramMallTransactionObject.AOz)))
      {
        com.tencent.mm.kernel.g.aAi();
        localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramMallTransactionObject.AOz);
        if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).gMZ > 0))
        {
          localObject1 = ((com.tencent.mm.contact.c)localObject1).arJ();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131768024);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if ((paramMallTransactionObject.efQ == 31) && (i != 0) && (!Util.isNullOrNil(paramMallTransactionObject.AOG)))
      {
        com.tencent.mm.kernel.g.aAi();
        localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramMallTransactionObject.AOG);
        if ((localObject1 != null) && ((int)((com.tencent.mm.contact.c)localObject1).gMZ > 0))
        {
          localObject1 = ((com.tencent.mm.contact.c)localObject1).arJ();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(2131768008);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1664;
        }
        paramf = new f(paramContext);
        if ((paramMallTransactionObject.efQ != 32) && (paramMallTransactionObject.efQ != 33) && (paramMallTransactionObject.efQ != 31)) {
          break label1654;
        }
        paramf.setTitle(2131767988);
        label667:
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.AOK))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131768036);
        paramf.setContent(paramMallTransactionObject.AOK);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.AOJ))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131768037);
        paramf.setContent(paramMallTransactionObject.AOJ);
        localArrayList.add(paramf);
      }
      if (!TextUtils.isEmpty(paramMallTransactionObject.AOB))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131767986);
        paramf.setContent(paramMallTransactionObject.AOB);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.AOa))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131768009);
        paramf.setContent(paramMallTransactionObject.AOa);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.AOf))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131768025);
        if ((paramMallTransactionObject.efQ != 31) || (z.aTY().equals(paramMallTransactionObject.AOz)) || (paramMallTransactionObject.AOA <= 0) || (Util.isNullOrNil(paramMallTransactionObject.AOz)) || (Util.isNullOrNil(paramMallTransactionObject.dDM))) {
          break label1827;
        }
        localObject1 = paramContext.getString(2131764587);
        localObject2 = paramMallTransactionObject.AOf + " " + (String)localObject1;
        i = paramMallTransactionObject.AOf.length();
        j = paramMallTransactionObject.AOf.length();
        paramf.a((String)localObject2, i + 1, ((String)localObject1).length() + j + 1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66794);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(2131764509), paramContext.getString(2131755962), paramContext.getString(2131764586), paramContext.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(66793);
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("transaction_id", a.3.this.ANT.dDM);
                paramAnonymous2DialogInterface.putExtra("receiver_name", a.3.this.ANT.AOz);
                paramAnonymous2DialogInterface.putExtra("resend_msg_from_flag", 1);
                com.tencent.mm.br.c.b(a.3.this.val$context, "remittance", ".ui.RemittanceResendMsgUI", paramAnonymous2DialogInterface);
                AppMethodBeat.o(66793);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66794);
          }
        });
        label1018:
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131767991);
      paramf.setContent(com.tencent.mm.wallet_core.ui.f.rZ(paramMallTransactionObject.iXu));
      localArrayList.add(paramf);
      if (!Util.isNullOrNil(paramMallTransactionObject.AOj))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131768012);
        localObject1 = paramMallTransactionObject.AOj;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!Util.isNullOrNil(paramMallTransactionObject.AOk)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.AOk + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.dDM))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131768032);
        paramf.setContent(paramMallTransactionObject.dDM);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.AOi))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131768022);
        if (paramMallTransactionObject.efQ != 8) {
          break label1856;
        }
        paramf.setContent(paramContext.getString(2131768023));
        localObject1 = new c(paramContext);
        localObject2 = com.tencent.mm.by.a.a.b(paramContext, paramMallTransactionObject.AOi, 5, 0);
        ((c)localObject1).AQy = com.tencent.mm.wallet_core.ui.f.bpw(paramMallTransactionObject.AOi);
        ((c)localObject1).iKs = ((Bitmap)localObject2);
        ((c)localObject1).mOnClickListener = new a.4(this, (Bitmap)localObject2, paramMallTransactionObject);
        localArrayList.add(paramf);
        localArrayList.add(localObject1);
      }
      label1326:
      if (paramMallTransactionObject.ANM.size() != 0) {
        break label1876;
      }
      i = 0;
      label1341:
      if ((i != 0) || ((Util.isNullOrNil(paramMallTransactionObject.AOu)) && (Util.isNullOrNil(paramMallTransactionObject.dCu)) && (Util.isNullOrNil(paramMallTransactionObject.ANP)))) {
        break label1882;
      }
      paramf = new h(paramContext);
      paramf.AQN = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label1412:
      if (i != 0)
      {
        paramf = new j(paramContext);
        if (paramMallTransactionObject.ANN != 1) {
          break label1927;
        }
        if ((!Util.isNullOrNil(paramMallTransactionObject.AOu)) || (!Util.isNullOrNil(paramMallTransactionObject.dCu)) || (!Util.isNullOrNil(paramMallTransactionObject.ANP)))
        {
          if (Util.isNullOrNil(paramMallTransactionObject.AOv)) {
            break label1913;
          }
          paramf.AQR = paramMallTransactionObject.AOv;
          label1482:
          paramf.AQS = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(66797);
              Object localObject = new b();
              ((b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
              paramAnonymousView = new LinkedList();
              localObject = new LinkedList();
              if (!Util.isNullOrNil(paramMallTransactionObject.dCu))
              {
                ((List)localObject).add(Integer.valueOf(0));
                paramAnonymousView.add(paramContext.getString(2131768028));
              }
              if (!Util.isNullOrNil(paramMallTransactionObject.ANP))
              {
                ((List)localObject).add(Integer.valueOf(1));
                paramAnonymousView.add(paramContext.getString(2131768029));
              }
              if (!Util.isNullOrNil(paramMallTransactionObject.AOu))
              {
                ((List)localObject).add(Integer.valueOf(2));
                paramAnonymousView.add(paramContext.getString(2131768031));
              }
              if (((List)localObject).size() == 1)
              {
                com.tencent.mm.plugin.order.model.a.a(((Integer)((List)localObject).get(0)).intValue(), paramContext, paramMallTransactionObject);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(66797);
                return;
              }
              com.tencent.mm.ui.base.h.b(paramContext, null, paramAnonymousView, (List)localObject, null, new h.e()
              {
                public final void cy(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(66796);
                  com.tencent.mm.plugin.order.model.a.a(paramAnonymous2Int2, a.5.this.val$context, a.5.this.ANT);
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
      paramf.ANM = paramMallTransactionObject.ANM;
      paramf.mOnClickListener = new a.7(this, paramContext, paramMallTransactionObject);
      paramContext = new h(paramContext);
      paramContext.AQN = true;
      localArrayList.add(paramContext);
      localArrayList.add(paramf);
      AppMethodBeat.o(66800);
      return localArrayList;
      i = 0;
      break;
      label1564:
      if (paramMallTransactionObject.efQ == 11)
      {
        localObject1 = paramContext.getString(2131768021);
        break label153;
      }
      localObject1 = paramContext.getString(2131767983);
      break label153;
      label1597:
      ((g)localObject1).AQG = paramContext.getString(2131767998, new Object[] { Integer.valueOf(localObject2.length), com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.AOq - paramMallTransactionObject.qwJ, paramMallTransactionObject.AOl) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label357;
      label1654:
      paramf.setTitle(2131768008);
      break label667;
      label1664:
      localObject1 = new f(paramContext);
      if (paramMallTransactionObject.efQ == 31)
      {
        ((f)localObject1).setTitle(2131768017);
        label1691:
        if (Util.isNullOrNil(paramMallTransactionObject.AOb)) {
          break label1815;
        }
        localObject2 = paramContext.getString(2131767987);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66792);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = paramMallTransactionObject.desc + "\n" + paramMallTransactionObject.AOb;
            this.AQt.setContent(paramAnonymousView);
            paramf.notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66792);
          }
        });
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setTitle(2131767994);
        break label1691;
        label1815:
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      label1827:
      paramf.setContent(paramMallTransactionObject.AOf);
      if (Util.isNullOrNil(paramMallTransactionObject.AOg)) {
        break label1018;
      }
      paramf.aJG(paramMallTransactionObject.AOg);
      break label1018;
      label1856:
      paramf.setContent(paramMallTransactionObject.AOi);
      localArrayList.add(paramf);
      break label1326;
      label1876:
      i = 1;
      break label1341;
      label1882:
      paramf = new h(paramContext);
      paramf.AQN = true;
      paramf.oAJ = false;
      localArrayList.add(paramf);
      break label1412;
      label1913:
      paramf.AQR = paramContext.getString(2131768030);
      break label1482;
      label1927:
      if (!Util.isNullOrNil(paramMallTransactionObject.AOv))
      {
        paramf.AQR = paramMallTransactionObject.AOv;
        paramf.AQS = new a.6(this, paramContext, paramMallTransactionObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a
 * JD-Core Version:    0.7.0.1
 */