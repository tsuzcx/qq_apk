package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements a.a
{
  public final List<Preference> a(Context paramContext, final com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66804);
    ArrayList localArrayList = new ArrayList();
    if (paramMallTransactionObject.dyc == 2) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      if ((!Util.isNullOrNil(paramMallTransactionObject.AOm)) && (!Util.isNullOrNil(paramMallTransactionObject.jyi)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).rcG = paramMallTransactionObject.jyi;
        ((d)localObject1).mName = paramMallTransactionObject.AOm;
        ((d)localObject1).mOnClickListener = new b.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      Log.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + paramMallTransactionObject.AOB + " and fetchTotalFee is " + paramMallTransactionObject.AOL);
      if (TextUtils.isEmpty(paramMallTransactionObject.AOB)) {
        break;
      }
      localObject1 = new i(paramContext);
      ((i)localObject1).AQQ = com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.AOL, paramMallTransactionObject.AOl);
      ((i)localObject1).setTitle(paramContext.getString(2131767985));
      if (!Util.isNullOrNil(paramMallTransactionObject.AOM)) {
        ((i)localObject1).aJH(paramMallTransactionObject.AOM);
      }
      localArrayList.add(localObject1);
      localObject1 = new h(paramContext);
      ((h)localObject1).AQN = false;
      ((h)localObject1).AQO = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131768002);
      ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.qwJ, paramMallTransactionObject.AOl));
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131767986);
      ((f)localObject1).setContent(paramMallTransactionObject.AOB);
      localArrayList.add(localObject1);
      if (!Util.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1136;
        }
        paramf = new f(paramContext);
        paramf.setTitle(2131768008);
        paramf.setContent(paramMallTransactionObject.desc);
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
        paramf.setContent(paramMallTransactionObject.AOf);
        if (!Util.isNullOrNil(paramMallTransactionObject.AOg)) {
          paramf.aJG(paramMallTransactionObject.AOg);
        }
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131768005);
      paramf.setContent(com.tencent.mm.wallet_core.ui.f.rZ(paramMallTransactionObject.iXu));
      localArrayList.add(paramf);
      if (paramMallTransactionObject.AOx <= 0) {
        break label1279;
      }
      paramf = new f(paramContext);
      paramf.setTitle(2131768003);
      paramf.setContent(com.tencent.mm.wallet_core.ui.f.rZ(paramMallTransactionObject.AOx));
      localArrayList.add(paramf);
      label563:
      if (!Util.isNullOrNil(paramMallTransactionObject.AOj))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(2131768004);
        localObject1 = paramMallTransactionObject.AOj;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!Util.isNullOrNil(paramMallTransactionObject.AOk)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.AOk + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.AOi))
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131768007);
        paramf.setContent(paramMallTransactionObject.AOi);
        localArrayList.add(paramf);
      }
      if ((Util.isNullOrNil(paramMallTransactionObject.AOu)) && (Util.isNullOrNil(paramMallTransactionObject.dCu)) && (Util.isNullOrNil(paramMallTransactionObject.ANP))) {
        break label1336;
      }
      paramf = new h(paramContext);
      paramf.AQN = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label766:
      AppMethodBeat.o(66804);
      return localArrayList;
    }
    Object localObject2 = new i(paramContext);
    ((i)localObject2).AQQ = com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.qwJ, paramMallTransactionObject.AOl);
    label819:
    boolean bool2;
    if (i != 0)
    {
      localObject1 = paramContext.getString(2131767984);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!Util.isNullOrNil(paramMallTransactionObject.AOd)) {
        ((i)localObject2).aJH(paramMallTransactionObject.AOd);
      }
      localArrayList.add(localObject2);
      if ((paramMallTransactionObject.qwJ == paramMallTransactionObject.AOq) || (paramMallTransactionObject.AOq <= 0.0D)) {
        break label1367;
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).AQN = false;
      ((h)localObject1).AQO = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.AOq, paramMallTransactionObject.AOl));
      ((f)localObject1).setTitle(2131768010);
      localArrayList.add(localObject1);
      bool2 = true;
      bool1 = bool2;
      if (!Util.isNullOrNil(paramMallTransactionObject.AOp))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(2131767996);
        ((g)localObject1).nRm = paramf;
        localObject2 = paramMallTransactionObject.AOp.split("\n");
        if (localObject2.length != 1) {
          break label1079;
        }
        ((g)localObject1).AQG = localObject2[0];
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
      ((h)localObject1).AQN = bool1;
      ((h)localObject1).AQO = true;
      localArrayList.add(localObject1);
      break;
      localObject1 = paramContext.getString(2131768002);
      break label819;
      ((g)localObject1).AQG = paramContext.getString(2131767998, new Object[] { Integer.valueOf(localObject2.length), com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.AOq - paramMallTransactionObject.qwJ, paramMallTransactionObject.AOl) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label1018;
      label1136:
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(2131767994);
      if (!Util.isNullOrNil(paramMallTransactionObject.AOb))
      {
        localObject2 = paramContext.getString(2131767987);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        int j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66803);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = paramMallTransactionObject.desc + "\n" + paramMallTransactionObject.AOb;
            this.AQt.setContent(paramAnonymousView);
            paramf.notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      if (paramMallTransactionObject.AOw > 0)
      {
        paramf = new f(paramContext);
        paramf.setTitle(2131768006);
        paramf.setContent(com.tencent.mm.wallet_core.ui.f.rZ(paramMallTransactionObject.AOw));
        localArrayList.add(paramf);
        break label563;
      }
      Log.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
      break label563;
      paramContext = new h(paramContext);
      paramContext.AQN = true;
      paramContext.oAJ = false;
      localArrayList.add(paramContext);
      break label766;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b
 * JD-Core Version:    0.7.0.1
 */