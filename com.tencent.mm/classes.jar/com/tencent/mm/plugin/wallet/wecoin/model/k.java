package com.tencent.mm.plugin.wallet.wecoin.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.setting.ui.b.a.a;
import com.tencent.mm.plugin.wallet.wecoin.a.g;
import com.tencent.mm.plugin.wallet.wecoin.a.j;
import com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cln;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.egu;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class k
  implements com.tencent.mm.plugin.wallet.wecoin.a.d
{
  private static void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(315813);
    com.tencent.mm.plugin.report.service.h.OAn.b(22129, new Object[] { Integer.valueOf(paramInt1), paramString1, "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString2 });
    AppMethodBeat.o(315813);
  }
  
  private void a(Context paramContext, final egu paramegu, final com.tencent.mm.plugin.wallet.wecoin.a.a parama)
  {
    AppMethodBeat.i(315806);
    if (paramContext == null)
    {
      AppMethodBeat.o(315806);
      return;
    }
    dcl localdcl = paramegu.ablX;
    if (localdcl != null) {
      com.tencent.mm.plugin.wallet.wecoin.utils.c.a(paramContext, localdcl, new b()
      {
        public final void a(efg paramAnonymousefg)
        {
          AppMethodBeat.i(315737);
          if ((paramAnonymousefg != null) && (paramAnonymousefg.action == 3))
          {
            k.this.a(paramegu, parama, false);
            AppMethodBeat.o(315737);
            return;
          }
          if ((parama != null) && (parama.VtS != null)) {
            parama.VtS.onClick();
          }
          AppMethodBeat.o(315737);
        }
      });
    }
    AppMethodBeat.o(315806);
  }
  
  private com.tencent.mm.plugin.wallet.wecoin.a.e b(FragmentActivity paramFragmentActivity, com.tencent.mm.plugin.wallet.wecoin.a.h paramh)
  {
    AppMethodBeat.i(315798);
    if (paramh.Vud == g.VtW)
    {
      final com.tencent.mm.plugin.wallet.wecoin.a.i locali = paramh.VtR;
      if ((paramFragmentActivity == null) || (paramh == null) || (TextUtils.isEmpty(paramh.hBT)))
      {
        Log.e("MicroMsg.WeCoinManagerImplement", "DirectRecharge productInfo is invalid.");
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(315809);
            if (locali != null) {
              locali.s(3, -1, "DirectRecharge productInfo is invalid.");
            }
            AppMethodBeat.o(315809);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(315798);
        return null;
        l.a locala = l.Vvd;
        l.iht().a(paramFragmentActivity, paramh, locali);
      }
    }
    if ((paramFragmentActivity == null) || (paramh == null))
    {
      AppMethodBeat.o(315798);
      return null;
    }
    paramFragmentActivity = new com.tencent.mm.plugin.wallet.wecoin.ui.a(paramFragmentActivity, paramh);
    AppMethodBeat.o(315798);
    return paramFragmentActivity;
  }
  
  private static boolean ihs()
  {
    AppMethodBeat.i(315820);
    boolean bool = "CN".equalsIgnoreCase(com.tencent.mm.kernel.h.baE().ban().bbx("CN"));
    AppMethodBeat.o(315820);
    return bool;
  }
  
  public final com.tencent.mm.plugin.wallet.wecoin.a.c T(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(315924);
    if (paramContext == null)
    {
      AppMethodBeat.o(315924);
      return null;
    }
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acXZ, Boolean.FALSE);
    if (localObject == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(315924);
      throw paramContext;
    }
    if (((Boolean)localObject).booleanValue())
    {
      AppMethodBeat.o(315924);
      return null;
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXZ, Boolean.TRUE);
    paramContext = new com.tencent.mm.plugin.wallet.wecoin.ui.f(paramContext, paramBoolean);
    AppMethodBeat.o(315924);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.wallet.wecoin.a.e a(final FragmentActivity paramFragmentActivity, final com.tencent.mm.plugin.wallet.wecoin.a.h paramh)
  {
    AppMethodBeat.i(315900);
    Log.i("MicroMsg.WeCoinManagerImplement", "prepareWeCoinRecharge");
    if (ihl())
    {
      paramFragmentActivity = b(paramFragmentActivity, paramh);
      AppMethodBeat.o(315900);
      return paramFragmentActivity;
    }
    MMActivity localMMActivity = (MMActivity)paramFragmentActivity;
    paramFragmentActivity = new com.tencent.mm.plugin.wallet.wecoin.a.i()
    {
      public final void onSuccess(Object paramAnonymousObject)
      {
        AppMethodBeat.i(315747);
        k.a(k.this, paramFragmentActivity, paramh);
        AppMethodBeat.o(315747);
      }
      
      public final void s(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(315756);
        if (paramh.VtR != null) {
          paramh.VtR.s(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(315756);
      }
    };
    Log.i("MicroMsg.WeCoinManagerImplement", "showWecoinAuthDialog");
    if (localMMActivity != null) {
      com.tencent.mm.plugin.setting.ui.b.a.a(localMMActivity, true, new a.a()
      {
        public final void cjC()
        {
          AppMethodBeat.i(315762);
          Log.i("MicroMsg.WeCoinManagerImplement", "changeSwitchWechatCommonTips onCancalBtn.");
          if (paramFragmentActivity != null) {
            paramFragmentActivity.s(3, -3, "授权微信豆失败");
          }
          AppMethodBeat.o(315762);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(315757);
          Log.i("MicroMsg.WeCoinManagerImplement", "changeSwitchWechatCommonTips onPositionBtn.");
          if (paramFragmentActivity != null) {
            paramFragmentActivity.onSuccess(null);
          }
          AppMethodBeat.o(315757);
        }
      });
    }
    AppMethodBeat.o(315900);
    return null;
  }
  
  public final Object a(MMActivity paramMMActivity, com.tencent.mm.plugin.wallet.wecoin.a.k paramk, WeakReference<j> paramWeakReference)
  {
    AppMethodBeat.i(315949);
    paramMMActivity = new com.tencent.mm.plugin.wallet.wecoin.c.a(paramMMActivity, paramk, paramWeakReference);
    paramMMActivity.ihm();
    AppMethodBeat.o(315949);
    return paramMMActivity;
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.wallet.wecoin.a.a parama)
  {
    AppMethodBeat.i(315894);
    int j = parama.VtP;
    String str2 = parama.FUP;
    if ((paramContext == null) || (parama.VtQ == null))
    {
      Log.e("MicroMsg.WeCoinManagerImplement", "consumeWeCoin param is invalid");
      a(j, str2, 1, 3, 3, "consumeWeCoin contextBuff is null");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 72);
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(315823);
          if (parama.VtR != null) {
            parama.VtR.s(3, -2, "");
          }
          AppMethodBeat.o(315823);
        }
      });
      AppMethodBeat.o(315894);
      return;
    }
    egu localegu = new egu();
    for (;;)
    {
      String str1;
      try
      {
        localegu.parseFrom(parama.VtQ);
        com.tencent.mm.plugin.wallet.wecoin.utils.c.d("MicroMsg.WeCoinManagerImplement", localegu);
        kd localkd = localegu.BaseResponse;
        if ((localkd != null) && (localkd.Idd != 0))
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 72);
          int i = localkd.Idd;
          str1 = "";
          if (localegu.ablX != null)
          {
            Log.i("MicroMsg.WeCoinManagerImplement", "consumeWeCoin intercept_info is not null");
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 77);
            i = 10000;
            str1 = localegu.ablX.wording;
            a(paramContext, localegu, parama);
          }
          if ((localkd.akjO == null) || (!localkd.akjO.abwN)) {
            break label382;
          }
          paramContext = localkd.akjO.abwM;
          Log.i("MicroMsg.WeCoinManagerImplement", "serialize PrepareWecoinConsumeResponse, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(localkd.Idd), paramContext });
          if (parama.VtR != null) {
            parama.VtR.s(4, i, paramContext);
          }
          a(j, str2, 1, 3, localkd.Idd, paramContext);
          AppMethodBeat.o(315894);
          return;
        }
      }
      catch (Exception paramContext)
      {
        a(j, str2, 1, 3, 3, "parse response failed");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 72);
        Log.e("MicroMsg.WeCoinManagerImplement", "parse PrepareWecoinConsumeResponse failed, exception: %s", new Object[] { paramContext.getMessage() });
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(315811);
            if (parama.VtR != null) {
              parama.VtR.s(3, -1, "");
            }
            AppMethodBeat.o(315811);
          }
        });
        AppMethodBeat.o(315894);
        return;
      }
      a(localegu, parama, false);
      AppMethodBeat.o(315894);
      return;
      label382:
      paramContext = str1;
    }
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.wallet.wecoin.a.i<Boolean> parami)
  {
    AppMethodBeat.i(315845);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WeCoinManagerImplement", "initEngine context is null.");
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(315752);
          if (parami != null) {
            parami.s(3, -2, "");
          }
          AppMethodBeat.o(315752);
        }
      });
      AppMethodBeat.o(315845);
      return;
    }
    l.a locala = l.Vvd;
    l.iht().b(paramContext, parami);
    AppMethodBeat.o(315845);
  }
  
  public final void a(Context paramContext, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(315918);
    if (paramContext == null)
    {
      AppMethodBeat.o(315918);
      return;
    }
    Intent localIntent = new Intent(paramContext, WeCoinIncomeDetailView.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localIntent.putExtra("wecoin_enter_encash_business_kv_data", new WecoinEncashKVData(1, paramString1, ""));
    localIntent.putExtra("wecoin_enter_encash_business_kv_is_cocert_activate", paramBoolean);
    localIntent.putExtra("wecoin_enter_encash_business_kv_tips", str);
    localIntent.putExtra("WECOIN_BUSINESS_ID", paramInt);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinManagerImplement", "startWeCoinIncomeDetailView", "(Landroid/content/Context;Ljava/lang/String;IZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinManagerImplement", "startWeCoinIncomeDetailView", "(Landroid/content/Context;Ljava/lang/String;IZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(315918);
  }
  
  public final void a(Context paramContext, String paramString, byte[] paramArrayOfByte, com.tencent.mm.plugin.wallet.wecoin.a.i<Long> parami)
  {
    AppMethodBeat.i(315882);
    com.tencent.mm.plugin.wallet.wecoin.a.a locala = new com.tencent.mm.plugin.wallet.wecoin.a.a();
    locala.VtP = 1;
    locala.VtQ = paramArrayOfByte;
    locala.VtR = parami;
    locala.VtS = null;
    locala.FUP = paramString;
    a(paramContext, locala);
    AppMethodBeat.o(315882);
  }
  
  public final void a(com.tencent.mm.plugin.wallet.wecoin.a.i<Long> parami)
  {
    AppMethodBeat.i(315862);
    a(parami, null);
    AppMethodBeat.o(315862);
  }
  
  public final void a(final com.tencent.mm.plugin.wallet.wecoin.a.i<Long> parami, Context paramContext)
  {
    AppMethodBeat.i(315868);
    parami = new com.tencent.mm.plugin.wallet.wecoin.b.h().bFJ().b(new com.tencent.mm.vending.c.a() {});
    if ((paramContext instanceof MMActivity)) {
      parami.a((MMActivity)paramContext);
    }
    AppMethodBeat.o(315868);
  }
  
  public final void a(final egu paramegu, final com.tencent.mm.plugin.wallet.wecoin.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(315954);
    com.tencent.mm.bx.b localb = paramegu.ZoR;
    if (localb == null)
    {
      a(parama.VtP, parama.FUP, 1, 3, 3, "contextByteString is null");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 72);
      Log.e("MicroMsg.WeCoinManagerImplement", "contextByteString is null");
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(315750);
          if (parama.VtR != null) {
            parama.VtR.s(3, -1, "");
          }
          AppMethodBeat.o(315750);
        }
      });
      AppMethodBeat.o(315954);
      return;
    }
    if (!paramBoolean)
    {
      a(parama.VtP, parama.FUP, 1, 3, 0, "");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 71);
    }
    a(parama.VtP, parama.FUP, 2, 1, 0, "");
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 73);
    byte[] arrayOfByte = com.tencent.mm.network.b.bQD().aK(localb.Op);
    if (arrayOfByte == null)
    {
      Log.e("MicroMsg.WeCoinManagerImplement", "signData is null");
      a(parama.VtP, parama.FUP, 2, 3, 4, "sign data failed.");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 76);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 75);
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(315748);
          if (parama.VtR != null) {
            parama.VtR.s(3, -1, "");
          }
          AppMethodBeat.o(315748);
        }
      });
      AppMethodBeat.o(315954);
      return;
    }
    new com.tencent.mm.plugin.wallet.wecoin.b.b(localb, parama.FUP, new com.tencent.mm.bx.b(arrayOfByte)).bFJ().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(315954);
  }
  
  public final void a(LinkedList<Integer> paramLinkedList, final com.tencent.mm.plugin.wallet.wecoin.a.i<cjj> parami)
  {
    AppMethodBeat.i(315933);
    new com.tencent.mm.plugin.wallet.wecoin.b.d(paramLinkedList).bFJ().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(315933);
  }
  
  public final void b(final com.tencent.mm.plugin.wallet.wecoin.a.i<Long> parami)
  {
    AppMethodBeat.i(315876);
    new com.tencent.mm.plugin.wallet.wecoin.b.e().bFJ().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(315876);
  }
  
  public final void cj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(315905);
    a(paramContext, paramString, 1, false, "");
    AppMethodBeat.o(315905);
  }
  
  public final Long ihk()
  {
    AppMethodBeat.i(315853);
    long l = com.tencent.mm.plugin.wallet.wecoin.utils.c.ihF();
    AppMethodBeat.o(315853);
    return Long.valueOf(l);
  }
  
  public final boolean ihl()
  {
    AppMethodBeat.i(315959);
    if (ihs())
    {
      AppMethodBeat.o(315959);
      return true;
    }
    if ((z.bAS() & 0x8) != 0L)
    {
      AppMethodBeat.o(315959);
      return true;
    }
    AppMethodBeat.o(315959);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.model.k
 * JD-Core Version:    0.7.0.1
 */