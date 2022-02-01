package com.tencent.mm.sensitive.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sensitive.PluginSensitive;
import com.tencent.mm.sensitive.PluginSensitive.a;
import com.tencent.mm.sensitive.business.BusinessStackRecorder;
import com.tencent.mm.sensitive.business.BusinessStackRecorder.a;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.sensitive.j.a;
import com.tencent.mm.sensitive.j.b;
import com.tencent.mm.sensitive.j.d;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil;", "", "()V", "MMKV_KEY_EXPT_PERMISSION_DIALOG", "", "getMMKV_KEY_EXPT_PERMISSION_DIALOG", "()Ljava/lang/String;", "MMKV_KEY_EXPT_VALUE", "getMMKV_KEY_EXPT_VALUE", "TAG", "listener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "getListener", "()Lcom/tencent/mm/sdk/event/IListener;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "noExitOnDenied", "", "getNoExitOnDenied", "()[Ljava/lang/String;", "[Ljava/lang/String;", "showingStatus", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getShowingStatus", "()Ljava/util/HashMap;", "checkAction", "methodName", "callBack", "Lkotlin/Function1;", "", "checkManually", "activity", "Landroid/app/Activity;", "permission", "Lcom/tencent/mm/sensitive/IPluginSensitive$PERMISSION;", "business", "Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;", "hasSysPermission", "(Lcom/tencent/mm/sensitive/IPluginSensitive$PERMISSION;)Ljava/lang/Boolean;", "ifNeedCheckBusinessSwitch", "isShowOldPermissionDialog", "resetSwitch", "isAccountInit", "saveExptSwitch", "showBusinessPermissionDialogUI", "showBusinessRequestPermissionDialog", "topActivity", "showHowManagePermissionDialog", "Lkotlin/Function0;", "showRequestPermissionDialog", "specifyBusiness", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a acvO;
  private static final HashMap<String, Boolean> acvP;
  private static final String[] acvQ;
  private static final String acvR;
  private static final String acvS;
  private static final MultiProcessMMKV eMf;
  private static final IListener<gh> lsH;
  
  static
  {
    AppMethodBeat.i(241141);
    acvO = new a();
    TAG = "PermissionSwitchCheckUtil";
    acvP = new HashMap();
    acvQ = new String[] { "LauncherUI", "ComposeUI" };
    acvR = "MMKV_KEY_EXPT_VALUE";
    acvS = "MMKV_KEY_EXPT_PERMISSION_DIALOG";
    eMf = MultiProcessMMKV.getMMKV(acvR);
    lsH = (IListener)new PermissionSwitchCheckUtil.listener.1(f.hfK);
    AppMethodBeat.o(241141);
  }
  
  public static Boolean a(d.c paramc)
  {
    AppMethodBeat.i(241049);
    if (paramc == d.c.actB)
    {
      boolean bool = com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext());
      AppMethodBeat.o(241049);
      return Boolean.valueOf(bool);
    }
    PluginSensitive.a locala = PluginSensitive.actU;
    paramc = (String[])PluginSensitive.access$getPERMISSION_ENUM_TO_SYS_PERMISSION$cp().get(paramc);
    int k;
    int i;
    if (paramc == null)
    {
      paramc = null;
      if (paramc == null)
      {
        AppMethodBeat.o(241049);
        return null;
      }
    }
    else
    {
      k = paramc.length;
      i = 0;
    }
    for (;;)
    {
      for (;;)
      {
        if (i < k)
        {
          locala = paramc[i];
          try
          {
            int j = androidx.core.content.a.checkSelfPermission(MMApplicationContext.getContext(), locala);
            if (j == 0) {}
            for (j = 1;; j = 0)
            {
              if (j == 0) {
                break label160;
              }
              paramc = Boolean.valueOf(true);
              break;
            }
            paramc = Boolean.FALSE;
          }
          catch (Exception paramc)
          {
            Log.e(TAG, "check mpermission exception:%s.", new Object[] { paramc });
            paramc = Boolean.FALSE;
            AppMethodBeat.o(241049);
            return paramc;
          }
        }
      }
      AppMethodBeat.o(241049);
      return paramc;
      AppMethodBeat.o(241049);
      return paramc;
      label160:
      i += 1;
    }
  }
  
  private static void a(Activity paramActivity, d.c paramc, d.a parama, kotlin.g.a.a<ah> parama1)
  {
    AppMethodBeat.i(241098);
    com.tencent.mm.ui.widget.a.h localh = new com.tencent.mm.ui.widget.a.h((Context)paramActivity);
    localh.jHN();
    Object localObject1 = View.inflate((Context)paramActivity, j.b.permission_setting_desc_dialog_layout, null);
    if (localObject1 == null)
    {
      paramActivity = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
      AppMethodBeat.o(241098);
      throw paramActivity;
    }
    localObject1 = (RoundedCornerFrameLayout)localObject1;
    View localView = ((RoundedCornerFrameLayout)localObject1).findViewById(j.a.back);
    TextView localTextView = (TextView)((RoundedCornerFrameLayout)localObject1).findViewById(j.a.desc);
    aw.a((Paint)((TextView)((RoundedCornerFrameLayout)localObject1).findViewById(j.a.title)).getPaint(), 0.8F);
    if (parama != null)
    {
      Object localObject2 = com.tencent.mm.sensitive.business.a.acuK;
      localObject2 = com.tencent.mm.sensitive.business.a.iUc().get(paramc.value);
      com.tencent.mm.sensitive.business.a locala = com.tencent.mm.sensitive.business.a.acuK;
      parama = com.tencent.mm.sensitive.business.a.iUd().get(parama.value);
      if ((localObject2 != null) && (parama != null))
      {
        parama = (String)parama;
        localObject2 = (String)localObject2;
        localTextView.setText((CharSequence)paramActivity.getString(j.d.settings_permission_how_desc_business, new Object[] { localObject2, parama }));
      }
    }
    for (parama = ah.aiuX;; parama = null)
    {
      if (parama == null)
      {
        parama = com.tencent.mm.sensitive.business.a.acuK;
        paramc = (String)com.tencent.mm.sensitive.business.a.iUc().get(paramc.value);
        if (paramc != null) {
          localTextView.setText((CharSequence)paramActivity.getString(j.d.settings_permission_how_desc_no_business, new Object[] { paramc }));
        }
      }
      localView.setOnClickListener(new a..ExternalSyntheticLambda3(localh));
      localh.agfD = new a..ExternalSyntheticLambda8(parama1);
      localh.mh((View)localObject1);
      localh.jHP();
      localh.dDn();
      AppMethodBeat.o(241098);
      return;
    }
  }
  
  public static void a(Activity paramActivity, final d.c paramc, final d.a parama, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(241087);
    s.u(paramActivity, "topActivity");
    s.u(paramc, "permission");
    s.u(parama, "business");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramActivity, paramc, parama, paramb));
    AppMethodBeat.o(241087);
  }
  
  private static final void a(Activity paramActivity, d.c paramc, com.tencent.mm.ui.widget.a.h paramh, View paramView)
  {
    AppMethodBeat.i(241105);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramActivity);
    localb.cH(paramc);
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramActivity, "$activity");
    s.u(paramc, "$permission");
    s.u(paramh, "$dialog");
    acvP.remove(paramActivity + '_' + paramc.value);
    paramh.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241105);
  }
  
  private static final void a(ah.a parama, Activity paramActivity, d.c paramc, com.tencent.mm.ui.widget.a.h paramh, View paramView)
  {
    AppMethodBeat.i(241111);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramActivity);
    localb.cH(paramc);
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$clickConfirm");
    s.u(paramActivity, "$activity");
    s.u(paramc, "$permission");
    s.u(paramh, "$dialog");
    parama.aiwY = true;
    acvP.remove(paramActivity + '_' + paramc.value);
    paramh.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241111);
  }
  
  private static final void a(ah.a parama1, Activity paramActivity, d.c paramc, kotlin.g.a.b paramb, ah.a parama2)
  {
    AppMethodBeat.i(241116);
    s.u(parama1, "$isGoToHow");
    s.u(paramActivity, "$activity");
    s.u(paramc, "$permission");
    s.u(paramb, "$callBack");
    s.u(parama2, "$clickConfirm");
    if (!parama1.aiwY)
    {
      acvP.remove(paramActivity + '_' + paramc.value);
      paramb.invoke(Boolean.valueOf(parama2.aiwY));
    }
    AppMethodBeat.o(241116);
  }
  
  private static final void a(ah.a parama, com.tencent.mm.ui.widget.a.h paramh, Activity paramActivity, final d.c paramc, final d.a parama1, final kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(241101);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramh);
    localb.cH(paramActivity);
    localb.cH(paramc);
    localb.cH(parama1);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$isGoToHow");
    s.u(paramh, "$dialog");
    s.u(paramActivity, "$activity");
    s.u(paramc, "$permission");
    s.u(parama1, "$business");
    s.u(paramb, "$callBack");
    parama.aiwY = true;
    paramh.cyW();
    a(paramActivity, paramc, parama1, (kotlin.g.a.a)new a(paramActivity, paramc, parama1, paramb));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241101);
  }
  
  private static final void a(ah.a parama, com.tencent.mm.ui.widget.a.h paramh, View paramView)
  {
    AppMethodBeat.i(241126);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$clickConfirm");
    s.u(paramh, "$dialog");
    parama.aiwY = true;
    paramh.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241126);
  }
  
  private static final void a(ah.a parama1, kotlin.g.a.b paramb, ah.a parama2)
  {
    AppMethodBeat.i(241129);
    s.u(parama1, "$isGoToHow");
    s.u(paramb, "$callBack");
    s.u(parama2, "$clickConfirm");
    if (!parama1.aiwY) {
      paramb.invoke(Boolean.valueOf(parama2.aiwY));
    }
    AppMethodBeat.o(241129);
  }
  
  public static boolean a(d.c paramc, d.a parama)
  {
    AppMethodBeat.i(241040);
    com.tencent.mm.sensitive.business.a locala = com.tencent.mm.sensitive.business.a.acuK;
    paramc = (com.tencent.mm.sensitive.business.a.b)com.tencent.mm.sensitive.business.a.iUa().get(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(241040);
      return false;
    }
    paramc = paramc.acuV;
    if (paramc == null)
    {
      AppMethodBeat.o(241040);
      return false;
    }
    paramc = (com.tencent.mm.sensitive.business.a.a)paramc.get(parama);
    if (paramc == null)
    {
      AppMethodBeat.o(241040);
      return false;
    }
    boolean bool = paramc.acuR;
    AppMethodBeat.o(241040);
    return bool;
  }
  
  public static boolean a(d.c paramc, d.a parama, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(241072);
    s.u(paramc, "permission");
    s.u(parama, "business");
    if (iUw())
    {
      AppMethodBeat.o(241072);
      return false;
    }
    if (!a(paramc, parama))
    {
      AppMethodBeat.o(241072);
      return false;
    }
    Object localObject1 = a(paramc);
    int i;
    if (localObject1 != null)
    {
      if (!((Boolean)localObject1).booleanValue())
      {
        i = 1;
        if (i == 0) {
          break label99;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label105;
        }
        ((Boolean)localObject1).booleanValue();
        AppMethodBeat.o(241072);
        return false;
        i = 0;
        break;
        label99:
        localObject1 = null;
      }
    }
    label105:
    localObject1 = ((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).getPermissionConfigMMkv(paramc.value);
    if (localObject1 != null)
    {
      Object localObject2 = parama.value;
      boolean bool;
      if (!parama.acts.booleanValue())
      {
        bool = true;
        localObject1 = Boolean.valueOf(((MultiProcessMMKV)localObject1).getBoolean((String)localObject2, bool));
        if (((Boolean)localObject1).booleanValue()) {
          break label271;
        }
        i = 1;
        label173:
        if (i == 0) {
          break label276;
        }
        label177:
        if (localObject1 == null) {
          break label430;
        }
        ((Boolean)localObject1).booleanValue();
        localObject1 = BusinessStackRecorder.acuv;
        localObject1 = BusinessStackRecorder.a.iTX();
        if (localObject1 != null) {
          break label282;
        }
        localObject1 = null;
        label206:
        if ((localObject1 != null) && (!s.p(localObject1, Boolean.FALSE))) {
          break label422;
        }
        localObject1 = AppForegroundDelegate.heY.aCc();
        if (localObject1 != null) {
          break label385;
        }
        localObject1 = null;
        label238:
        if (localObject1 != null) {
          break label398;
        }
      }
      for (localObject1 = null;; localObject1 = ah.aiuX)
      {
        if (localObject1 == null) {
          b(paramc, parama, paramb);
        }
        AppMethodBeat.o(241072);
        return true;
        bool = false;
        break;
        label271:
        i = 0;
        break label173;
        label276:
        localObject1 = null;
        break label177;
        label282:
        localObject2 = com.tencent.mm.sensitive.business.a.acuK;
        localObject2 = (com.tencent.mm.sensitive.business.a.b)com.tencent.mm.sensitive.business.a.iUa().get(paramc);
        if (localObject2 == null)
        {
          localObject1 = null;
          break label206;
        }
        localObject2 = ((com.tencent.mm.sensitive.business.a.b)localObject2).acuV;
        if (localObject2 == null)
        {
          localObject1 = null;
          break label206;
        }
        localObject2 = (com.tencent.mm.sensitive.business.a.a)((HashMap)localObject2).get(parama);
        if (localObject2 == null)
        {
          localObject1 = null;
          break label206;
        }
        localObject2 = ((com.tencent.mm.sensitive.business.a.a)localObject2).acuS;
        if (localObject2 == null)
        {
          localObject1 = null;
          break label206;
        }
        localObject1 = Boolean.valueOf(((List)localObject2).contains(localObject1));
        break label206;
        label385:
        localObject1 = (Activity)((WeakReference)localObject1).get();
        break label238;
        label398:
        s.s(localObject1, "topActivity");
        a((Activity)localObject1, paramc, parama, paramb);
      }
      label422:
      AppMethodBeat.o(241072);
      return true;
    }
    label430:
    AppMethodBeat.o(241072);
    return false;
  }
  
  private static final void b(Activity paramActivity, d.c paramc, com.tencent.mm.ui.widget.a.h paramh, View paramView)
  {
    AppMethodBeat.i(241107);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramActivity);
    localb.cH(paramc);
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramActivity, "$activity");
    s.u(paramc, "$permission");
    s.u(paramh, "$dialog");
    acvP.remove(paramActivity + '_' + paramc.value);
    paramh.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241107);
  }
  
  public static void b(d.c paramc, d.a parama, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(241082);
    s.u(paramc, "permission");
    s.u(parama, "business");
    Intent localIntent = new Intent();
    PermissionDialogUI.a locala = PermissionDialogUI.acvK;
    localIntent.putExtra(PermissionDialogUI.iUo(), paramc.value);
    paramc = PermissionDialogUI.acvK;
    localIntent.putExtra(PermissionDialogUI.iUp(), parama.value);
    localIntent.addFlags(268435456);
    localIntent.setClass(MMApplicationContext.getContext(), PermissionDialogUI.class);
    paramc = PermissionDialogUI.acvK;
    PermissionDialogUI.aS(paramb);
    paramc = MMApplicationContext.getContext();
    parama = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramc, parama.aYi(), "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "showBusinessRequestPermissionDialog", "(Lcom/tencent/mm/sensitive/IPluginSensitive$PERMISSION;Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;Lkotlin/jvm/functions/Function1;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramc.startActivity((Intent)parama.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "showBusinessRequestPermissionDialog", "(Lcom/tencent/mm/sensitive/IPluginSensitive$PERMISSION;Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;Lkotlin/jvm/functions/Function1;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(241082);
  }
  
  private static final void b(ah.a parama, com.tencent.mm.ui.widget.a.h paramh, Activity paramActivity, final d.c paramc, final d.a parama1, final kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(241120);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramh);
    localb.cH(paramActivity);
    localb.cH(paramc);
    localb.cH(parama1);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$isGoToHow");
    s.u(paramh, "$dialog");
    s.u(paramActivity, "$activity");
    s.u(paramc, "$permission");
    s.u(paramb, "$callBack");
    parama.aiwY = true;
    paramh.cyW();
    a(paramActivity, paramc, null, (kotlin.g.a.a)new c(paramActivity, paramc, parama1, paramb));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241120);
  }
  
  public static boolean b(Activity paramActivity, d.c paramc, d.a parama, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(241091);
    s.u(paramActivity, "activity");
    s.u(paramc, "permission");
    s.u(parama, "business");
    s.u(paramb, "callBack");
    if (iUw())
    {
      AppMethodBeat.o(241091);
      return false;
    }
    if (s.p(acvP.get(paramActivity + '_' + paramc.value), Boolean.TRUE))
    {
      AppMethodBeat.o(241091);
      return false;
    }
    ((Map)acvP).put(paramActivity + '_' + paramc.value, Boolean.TRUE);
    com.tencent.mm.ui.widget.a.h localh = new com.tencent.mm.ui.widget.a.h((Context)paramActivity);
    localh.jHN();
    Object localObject1 = View.inflate((Context)paramActivity, j.b.permission_business_request_half_dialog, null);
    if (localObject1 == null)
    {
      paramActivity = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
      AppMethodBeat.o(241091);
      throw paramActivity;
    }
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = (RoundedCornerFrameLayout)localObject1;
    localRoundedCornerFrameLayout.A(bd.fromDPToPix((Context)paramActivity, 12), bd.fromDPToPix((Context)paramActivity, 12), 0.0F, 0.0F);
    localObject1 = (com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class);
    Object localObject2 = (WeImageView)localRoundedCornerFrameLayout.findViewById(j.a.permission_icon);
    Object localObject3 = (TextView)localRoundedCornerFrameLayout.findViewById(j.a.desc_default);
    TextView localTextView = (TextView)localRoundedCornerFrameLayout.findViewById(j.a.title);
    View localView1 = localRoundedCornerFrameLayout.findViewById(j.a.close);
    View localView2 = localRoundedCornerFrameLayout.findViewById(j.a.how_permission);
    Integer localInteger = ((com.tencent.mm.sensitive.d)localObject1).getPermissionIcon(paramc.value);
    s.s(localInteger, "plugin.getPermissionIcon(permission.value)");
    ((WeImageView)localObject2).setImageResource(((Number)localInteger).intValue());
    localTextView.setText((CharSequence)((com.tencent.mm.sensitive.d)localObject1).getPermissionBusinessTitle(paramc.value, parama.value));
    aw.a((Paint)localTextView.getPaint(), 0.8F);
    localObject1 = ((com.tencent.mm.sensitive.d)localObject1).getPermissionBusinessDesc(paramc.value, parama.value);
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((Pair)localObject1).first;
      localObject2 = (Integer)localObject1;
      if (localObject2 != null) {
        break label600;
      }
      i = 1;
      label412:
      if (i == 0) {
        break label615;
      }
      label417:
      localObject1 = (Integer)localObject1;
      if (localObject1 != null) {
        break label621;
      }
      localObject1 = "";
    }
    for (;;)
    {
      ((TextView)localObject3).setText((CharSequence)String.valueOf(localObject1));
      localObject3 = localRoundedCornerFrameLayout.findViewById(j.a.cancel_btn);
      localObject1 = localRoundedCornerFrameLayout.findViewById(j.a.ok_btn);
      localObject2 = new ah.a();
      localView2.setOnClickListener(new a..ExternalSyntheticLambda7((ah.a)localObject2, localh, paramActivity, paramc, parama, paramb));
      localView1.setOnClickListener(new a..ExternalSyntheticLambda1(paramActivity, paramc, localh));
      ((View)localObject3).setOnClickListener(new a..ExternalSyntheticLambda0(paramActivity, paramc, localh));
      parama = new ah.a();
      ((View)localObject1).setOnClickListener(new a..ExternalSyntheticLambda4(parama, paramActivity, paramc, localh));
      localh.mh((View)localRoundedCornerFrameLayout);
      localh.agfD = new a..ExternalSyntheticLambda9((ah.a)localObject2, paramActivity, paramc, paramb, parama);
      localh.jHP();
      localh.dDn();
      AppMethodBeat.o(241091);
      return true;
      label600:
      if (((Integer)localObject2).intValue() != -1) {
        break;
      }
      i = 0;
      break label412;
      label615:
      localObject1 = null;
      break label417;
      label621:
      localObject2 = paramActivity.getString(((Number)localObject1).intValue());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  public static void c(Activity paramActivity, d.c paramc, d.a parama, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(241095);
    s.u(paramActivity, "activity");
    s.u(paramc, "permission");
    s.u(paramb, "callBack");
    com.tencent.mm.ui.widget.a.h localh = new com.tencent.mm.ui.widget.a.h((Context)paramActivity);
    localh.jHN();
    Object localObject1 = View.inflate((Context)paramActivity, j.b.permission_request_half_dialg_layout, null);
    if (localObject1 == null)
    {
      paramActivity = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
      AppMethodBeat.o(241095);
      throw paramActivity;
    }
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = (RoundedCornerFrameLayout)localObject1;
    View localView1 = localRoundedCornerFrameLayout.findViewById(j.a.cancel_btn);
    View localView2 = localRoundedCornerFrameLayout.findViewById(j.a.ok_btn);
    localRoundedCornerFrameLayout.findViewById(j.a.bg);
    Object localObject2 = (WeImageView)localRoundedCornerFrameLayout.findViewById(j.a.permission_icon);
    Object localObject3 = (TextView)localRoundedCornerFrameLayout.findViewById(j.a.title);
    TextView localTextView = (TextView)localRoundedCornerFrameLayout.findViewById(j.a.desc);
    View localView3 = localRoundedCornerFrameLayout.findViewById(j.a.how_permission);
    com.tencent.mm.sensitive.d locald = (com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class);
    if (parama == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label437;
      }
      localObject1 = BusinessStackRecorder.acuv;
      localObject1 = BusinessStackRecorder.a.iTW();
      label200:
      Integer localInteger = locald.getPermissionIcon(paramc.value);
      s.s(localInteger, "plugin.getPermissionIcon(permission.value)");
      ((WeImageView)localObject2).setImageResource(((Number)localInteger).intValue());
      ((TextView)localObject3).setText((CharSequence)locald.getPermissionWxTitle(paramc.value));
      aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
      if (localObject1 != null) {
        break label440;
      }
    }
    for (localObject1 = null;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = locald.getPermissionDefaultDesc(paramc.value);
        if (localObject1 != null) {
          localTextView.setText((CharSequence)paramActivity.getString(((Number)localObject1).intValue()));
        }
      }
      localObject1 = new ah.a();
      localView3.setOnClickListener(new a..ExternalSyntheticLambda6((ah.a)localObject1, localh, paramActivity, paramc, parama, paramb));
      paramActivity = new ah.a();
      localView1.setOnClickListener(new a..ExternalSyntheticLambda2(localh));
      localView2.setOnClickListener(new a..ExternalSyntheticLambda5(paramActivity, localh));
      localh.agfD = new a..ExternalSyntheticLambda10((ah.a)localObject1, paramb, paramActivity);
      localh.mh((View)localRoundedCornerFrameLayout);
      localh.jHP();
      localh.dDn();
      AppMethodBeat.o(241095);
      return;
      localObject1 = parama.value;
      break;
      label437:
      break label200;
      label440:
      localObject2 = locald.getPermissionBusinessDesc(paramc.value, (String)localObject1);
      if (localObject2 != null) {
        break label466;
      }
    }
    label466:
    localObject1 = ((Pair)localObject2).first;
    localObject3 = (Integer)localObject1;
    label485:
    int i;
    if (localObject3 == null)
    {
      i = 1;
      label488:
      if (i == 0) {
        break label592;
      }
      label493:
      localObject1 = (Integer)localObject1;
      if (localObject1 != null) {
        break label598;
      }
      localObject1 = "";
      label510:
      localObject2 = ((Pair)localObject2).second;
      localObject3 = (Integer)localObject2;
      if (localObject3 != null) {
        break label628;
      }
      label529:
      i = 1;
      label532:
      if (i == 0) {
        break label643;
      }
      label537:
      localObject2 = (Integer)localObject2;
      if (localObject2 != null) {
        break label649;
      }
      localObject2 = "";
    }
    for (;;)
    {
      localTextView.setText((CharSequence)s.X((String)localObject1, localObject2));
      localObject1 = ah.aiuX;
      break;
      if (((Integer)localObject3).intValue() != -1) {
        break label485;
      }
      i = 0;
      break label488;
      label592:
      localObject1 = null;
      break label493;
      label598:
      localObject1 = paramActivity.getString(((Number)localObject1).intValue());
      if (localObject1 == null)
      {
        localObject1 = "";
        break label510;
      }
      break label510;
      label628:
      if (((Integer)localObject3).intValue() != -1) {
        break label529;
      }
      i = 0;
      break label532;
      label643:
      localObject2 = null;
      break label537;
      label649:
      localObject3 = paramActivity.getString(((Number)localObject2).intValue());
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  private static final void cb(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(241138);
    s.u(parama, "$callBack");
    parama.invoke();
    AppMethodBeat.o(241138);
  }
  
  private static final void d(com.tencent.mm.ui.widget.a.h paramh, View paramView)
  {
    AppMethodBeat.i(241123);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "$dialog");
    paramh.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241123);
  }
  
  private static final void e(com.tencent.mm.ui.widget.a.h paramh, View paramView)
  {
    AppMethodBeat.i(241133);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "$dialog");
    paramh.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/sensitive/ui/PermissionSwitchCheckUtil", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241133);
  }
  
  public static HashMap<String, Boolean> iUr()
  {
    return acvP;
  }
  
  public static String[] iUs()
  {
    return acvQ;
  }
  
  public static String iUt()
  {
    return acvR;
  }
  
  public static String iUu()
  {
    return acvS;
  }
  
  private static void iUv()
  {
    AppMethodBeat.i(241035);
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yJM, 0) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      eMf.putBoolean(acvS, bool);
      AppMethodBeat.o(241035);
      return;
    }
  }
  
  public static boolean iUw()
  {
    AppMethodBeat.i(241038);
    boolean bool = eMf.getBoolean(acvS, true);
    AppMethodBeat.o(241038);
    return bool;
  }
  
  public static void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(241028);
    if (paramBoolean)
    {
      iUv();
      lsH.alive();
      AppMethodBeat.o(241028);
      return;
    }
    eMf.putBoolean(acvS, true);
    lsH.dead();
    AppMethodBeat.o(241028);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(Activity paramActivity, d.c paramc, d.a parama, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(Activity paramActivity, d.c paramc, d.a parama, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Boolean, ah>
    {
      a(d.c paramc, d.a parama, kotlin.g.a.b<? super Boolean, ah> paramb, Activity paramActivity)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(Activity paramActivity, d.c paramc, d.a parama, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.ui.a
 * JD-Core Version:    0.7.0.1
 */