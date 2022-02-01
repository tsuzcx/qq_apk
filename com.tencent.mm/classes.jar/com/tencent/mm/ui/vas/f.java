package com.tencent.mm.ui.vas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager.a;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "getVASFragment", "Lcom/tencent/mm/ui/vas/VASCommonFragment;", "T", "Lcom/tencent/mm/ui/vas/VASActivity;", "intent", "Landroid/content/Intent;", "isPureFragment", "", "uiCls", "Ljava/lang/Class;", "getVasClassByIntent", "getVasJumpActivityClass", "context", "Landroid/content/Context;", "isTableEnv", "isVASActivity", "hanldeTopFragment", "Landroidx/fragment/app/FragmentManager;", "startVASActivity", "", "Landroid/app/Activity;", "options", "Landroid/os/Bundle;", "startVASActivityForResult", "requestCode", "", "libmmui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  private static VASCommonFragment a(Class<?> paramClass, Intent paramIntent)
  {
    AppMethodBeat.i(249938);
    s.u(paramClass, "uiCls");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("VAS_CLASS", (Serializable)paramClass);
    localIntent.putExtra("KEY_DISABLE_COMMON_AREA_CONTROL", false);
    localIntent.putExtra("KEY_GET_FRAGMENT", false);
    paramClass = VASCommonFragment.afQz;
    paramClass = VASCommonFragment.a.cb(localIntent.getExtras());
    AppMethodBeat.o(249938);
    return paramClass;
  }
  
  public static final void a(Activity paramActivity, Class<?> paramClass, Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(249920);
    s.u(paramActivity, "<this>");
    s.u(paramClass, "uiCls");
    b(paramActivity, paramClass, paramIntent, paramBundle);
    AppMethodBeat.o(249920);
  }
  
  public static final void a(Activity paramActivity, Class<?> paramClass, Intent paramIntent, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(249924);
    s.u(paramActivity, "<this>");
    s.u(paramClass, "uiCls");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass((Context)paramActivity, g((Context)paramActivity, paramClass));
    localIntent.putExtra("VAS_CLASS", (Serializable)paramClass);
    paramActivity.startActivityForResult(localIntent, paramInt, paramBundle);
    AppMethodBeat.o(249924);
  }
  
  public static final void a(VASActivity paramVASActivity, Class<?> paramClass, Intent paramIntent, Bundle paramBundle, int paramInt)
  {
    int m = 0;
    AppMethodBeat.i(249948);
    s.u(paramVASActivity, "<this>");
    s.u(paramClass, "uiCls");
    Log.d("MicroMsg.VAS.VasNavigator", "startVASActivityForResult() called with: uiCls = " + paramClass + ", intent = " + paramIntent + ", options = " + paramBundle + ", requestCode = " + paramInt);
    MMFragmentActivity.aReporter.a(paramIntent, (Context)paramVASActivity, true);
    paramBundle = paramVASActivity.getMFragmentManager();
    int j;
    int i;
    if (paramBundle != null)
    {
      if (paramIntent != null) {
        break label373;
      }
      j = 0;
      if (paramIntent != null) {
        break label386;
      }
      i = 0;
      label106:
      if ((j != 0) || ((0x20000000 & i) == 0)) {
        break label440;
      }
      j = 1;
    }
    label161:
    label440:
    for (;;)
    {
      int k = i;
      if (j == 2) {
        k = i & 0x4000000;
      }
      int n;
      Object localObject;
      if ((k & 0x4000000) != 0)
      {
        n = paramBundle.getBackStackEntryCount();
        if (n > 0)
        {
          i = 0;
          k = i + 1;
          localObject = paramBundle.getBackStackEntryAt(i);
          s.s(localObject, "it.getBackStackEntryAt(i)");
          if (!s.p(((FragmentManager.a)localObject).getName(), paramClass.getName())) {
            break label395;
          }
          i = m;
          if (j == 0) {
            i = 1;
          }
          paramBundle.popBackStackImmediate(((FragmentManager.a)localObject).getName(), i);
        }
      }
      switch (j)
      {
      default: 
        label225:
        label248:
        paramIntent = a(paramClass, paramIntent);
        if (!paramVASActivity.getFragment().isRemoving()) {
          paramIntent.setTargetFragment((Fragment)paramVASActivity.getFragment(), paramInt);
        }
        if (paramVASActivity.isTabMode())
        {
          localObject = d.afQM;
          if (d.cr(paramClass)) {
            paramInt = a.g.layout_vas_container_main;
          }
        }
        break;
      }
      for (;;)
      {
        paramVASActivity.getFragment().a(paramVASActivity.getTempPageAnim());
        paramIntent.b(paramVASActivity.getTempPageAnim());
        paramBundle.beginTransaction().r(a.a.vas_anim_enter_holder, a.a.vas_anim_exit_holder, a.a.vas_anim_pop_enter_holder, a.a.vas_anim_pop_exit_holder).b(paramInt, (Fragment)paramIntent).aI(paramClass.getName()).FX();
        paramIntent.afQA = paramVASActivity.getFragment();
        AppMethodBeat.o(249948);
        return;
        label373:
        j = paramIntent.getIntExtra("KEY_LAUNCH_MODE", 0);
        break;
        i = paramIntent.getFlags();
        break label106;
        if (k >= n) {
          break label225;
        }
        i = k;
        break label161;
        if (!a(paramBundle, paramClass, paramIntent)) {
          break label248;
        }
        AppMethodBeat.o(249948);
        return;
        paramInt = a.g.layout_vas_container_sub;
        continue;
        paramInt = a.g.layout_vas_container;
      }
    }
  }
  
  private static boolean a(FragmentManager paramFragmentManager, Class<?> paramClass, Intent paramIntent)
  {
    AppMethodBeat.i(249954);
    s.u(paramFragmentManager, "<this>");
    s.u(paramClass, "uiCls");
    Fragment localFragment;
    if (paramFragmentManager.getFragments().size() > 0)
    {
      localFragment = (Fragment)paramFragmentManager.getFragments().get(0);
      if (!(localFragment instanceof VASCommonFragment)) {
        break label166;
      }
      paramFragmentManager = ((VASCommonFragment)localFragment).afQn;
      if ((paramFragmentManager == null) || (!s.p(paramFragmentManager.getClass(), paramClass))) {
        break label166;
      }
      paramFragmentManager = ((VASCommonFragment)localFragment).getArguments();
      if (paramFragmentManager != null) {
        paramFragmentManager.clear();
      }
      if (paramIntent != null) {
        break label155;
      }
      paramFragmentManager = null;
      label96:
      if (paramFragmentManager != null) {
        break label163;
      }
      paramFragmentManager = new Bundle();
    }
    label155:
    label163:
    for (;;)
    {
      paramClass = ((VASCommonFragment)localFragment).getArguments();
      if (paramClass != null) {
        paramClass.putAll(paramFragmentManager);
      }
      paramClass = ((VASCommonFragment)localFragment).afQn;
      if (paramClass != null) {
        paramClass.onNewBundle(paramFragmentManager);
      }
      AppMethodBeat.o(249954);
      return true;
      localFragment = null;
      break;
      paramFragmentManager = paramIntent.getExtras();
      break label96;
    }
    label166:
    AppMethodBeat.o(249954);
    return false;
  }
  
  public static final Class<?> g(Context paramContext, Class<?> paramClass)
  {
    AppMethodBeat.i(249917);
    s.u(paramContext, "context");
    s.u(paramClass, "uiCls");
    ao.mX(paramContext);
    if (nI(paramContext))
    {
      paramContext = d.afQM;
      if (d.cr(paramClass))
      {
        AppMethodBeat.o(249917);
        return VASCommonForPadActivity.class;
      }
    }
    AppMethodBeat.o(249917);
    return VASCommonActivity.class;
  }
  
  private static boolean nI(Context paramContext)
  {
    AppMethodBeat.i(249915);
    s.u(paramContext, "context");
    ao.a locala = ao.mX(paramContext);
    if (Math.min(locala.width, locala.height) > com.tencent.mm.cd.a.fromDPToPix(paramContext, 600))
    {
      AppMethodBeat.o(249915);
      return true;
    }
    AppMethodBeat.o(249915);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.f
 * JD-Core Version:    0.7.0.1
 */