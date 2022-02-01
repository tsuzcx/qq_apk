package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qi;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.ui.setting.permission.SettingCameraPermissionUI;
import com.tencent.mm.plugin.setting.ui.setting.permission.SettingContactPermissionUI;
import com.tencent.mm.plugin.setting.ui.setting.permission.SettingLocationPermissionUI;
import com.tencent.mm.plugin.setting.ui.setting.permission.SettingMicrophonePermissionUI;
import com.tencent.mm.plugin.setting.ui.setting.permission.SettingOverlayPermissionUI;
import com.tencent.mm.plugin.setting.ui.setting.permission.SettingSportPermissionUI;
import com.tencent.mm.plugin.setting.ui.setting.permission.SettingStoragePermissionUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.c.a;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mActionBarContainer", "Landroid/view/View;", "mStatusBarHeightCallback", "Lcom/tencent/mm/ui/statusbar/StatusBarHeightWatcher$OnStatusBarHeightChangeCallback;", "oldArrowView", "", "", "getOldArrowView", "()Ljava/util/List;", "oldDescView", "getOldDescView", "fixActionBarStuff", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SettingsSystemPermissionUI
  extends MMActivity
{
  private View Inv;
  private c.a Inw;
  private final List<Integer> PwA;
  private final List<Integer> Pwz;
  
  public SettingsSystemPermissionUI()
  {
    AppMethodBeat.i(299170);
    this.Pwz = p.listOf(new Integer[] { Integer.valueOf(com.tencent.mm.plugin.setting.b.f.desc1), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.desc2), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.desc3), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.desc4), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.desc5), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.desc6), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.desc7) });
    this.PwA = p.listOf(new Integer[] { Integer.valueOf(com.tencent.mm.plugin.setting.b.f.arrow1), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.arrow2), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.arrow3), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.arrow4), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.arrow5), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.arrow6), Integer.valueOf(com.tencent.mm.plugin.setting.b.f.arrow7) });
    AppMethodBeat.o(299170);
  }
  
  private static final void a(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, int paramInt)
  {
    AppMethodBeat.i(299183);
    s.u(paramSettingsSystemPermissionUI, "this$0");
    paramSettingsSystemPermissionUI = paramSettingsSystemPermissionUI.Inv;
    s.checkNotNull(paramSettingsSystemPermissionUI);
    paramSettingsSystemPermissionUI.setPadding(0, paramInt, 0, 0);
    AppMethodBeat.o(299183);
  }
  
  private static final void a(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, View paramView)
  {
    AppMethodBeat.i(299181);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsSystemPermissionUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSettingsSystemPermissionUI, "this$0");
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramSettingsSystemPermissionUI.getContext());
    paramSettingsSystemPermissionUI = new qi();
    paramSettingsSystemPermissionUI.ikE = 101L;
    paramSettingsSystemPermissionUI.bMH();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299181);
  }
  
  private static final void a(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, ah.a parama, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(299178);
    s.u(paramSettingsSystemPermissionUI, "this$0");
    s.u(parama, "$actionBarHide");
    if (paramView.getScrollY() > com.tencent.mm.cd.a.fromDPToPix((Context)paramSettingsSystemPermissionUI.getContext(), 80))
    {
      if (parama.aiwY)
      {
        paramSettingsSystemPermissionUI.setMMTitle(b.i.settings_privacy_sys_permission);
        paramSettingsSystemPermissionUI.setActionbarColor(paramSettingsSystemPermissionUI.getResources().getColor(b.c.BG_2));
        paramSettingsSystemPermissionUI.supportLightStatusBar();
        parama.aiwY = false;
        AppMethodBeat.o(299178);
      }
    }
    else if (!parama.aiwY)
    {
      paramSettingsSystemPermissionUI.setMMTitle("");
      paramSettingsSystemPermissionUI.setActionbarColor(paramSettingsSystemPermissionUI.getResources().getColor(b.c.BG_2));
      paramSettingsSystemPermissionUI.setActionbarElementColor(paramSettingsSystemPermissionUI.getContext().getResources().getColor(b.c.FG_0));
      paramSettingsSystemPermissionUI.supportLightStatusBar();
      parama.aiwY = true;
    }
    AppMethodBeat.o(299178);
  }
  
  private static final boolean a(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(299173);
    s.u(paramSettingsSystemPermissionUI, "this$0");
    paramSettingsSystemPermissionUI.finish();
    AppMethodBeat.o(299173);
    return true;
  }
  
  private static final void b(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, View paramView)
  {
    AppMethodBeat.i(299185);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsSystemPermissionUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSettingsSystemPermissionUI, "this$0");
    paramView = new Intent((Context)paramSettingsSystemPermissionUI.getContext(), SettingLocationPermissionUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramSettingsSystemPermissionUI, paramView.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-11", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramSettingsSystemPermissionUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramSettingsSystemPermissionUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-11", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299185);
  }
  
  private static final void c(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, View paramView)
  {
    AppMethodBeat.i(299187);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsSystemPermissionUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSettingsSystemPermissionUI, "this$0");
    paramView = new Intent((Context)paramSettingsSystemPermissionUI.getContext(), SettingStoragePermissionUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramSettingsSystemPermissionUI, paramView.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-12", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramSettingsSystemPermissionUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramSettingsSystemPermissionUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-12", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299187);
  }
  
  private static final void d(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, View paramView)
  {
    AppMethodBeat.i(299189);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsSystemPermissionUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSettingsSystemPermissionUI, "this$0");
    paramView = new Intent((Context)paramSettingsSystemPermissionUI.getContext(), SettingContactPermissionUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramSettingsSystemPermissionUI, paramView.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-13", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramSettingsSystemPermissionUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramSettingsSystemPermissionUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-13", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299189);
  }
  
  private static final void e(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, View paramView)
  {
    AppMethodBeat.i(299191);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsSystemPermissionUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSettingsSystemPermissionUI, "this$0");
    paramView = new Intent((Context)paramSettingsSystemPermissionUI.getContext(), SettingCameraPermissionUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramSettingsSystemPermissionUI, paramView.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-14", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramSettingsSystemPermissionUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramSettingsSystemPermissionUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-14", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299191);
  }
  
  private static final void f(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, View paramView)
  {
    AppMethodBeat.i(299193);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsSystemPermissionUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSettingsSystemPermissionUI, "this$0");
    paramView = new Intent((Context)paramSettingsSystemPermissionUI.getContext(), SettingMicrophonePermissionUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramSettingsSystemPermissionUI, paramView.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-15", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramSettingsSystemPermissionUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramSettingsSystemPermissionUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-15", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299193);
  }
  
  private static final void g(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, View paramView)
  {
    AppMethodBeat.i(299195);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsSystemPermissionUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSettingsSystemPermissionUI, "this$0");
    paramView = new Intent((Context)paramSettingsSystemPermissionUI.getContext(), SettingSportPermissionUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramSettingsSystemPermissionUI, paramView.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-16", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramSettingsSystemPermissionUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramSettingsSystemPermissionUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-16", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299195);
  }
  
  private static final void h(SettingsSystemPermissionUI paramSettingsSystemPermissionUI, View paramView)
  {
    AppMethodBeat.i(299197);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsSystemPermissionUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSettingsSystemPermissionUI, "this$0");
    paramView = new Intent((Context)paramSettingsSystemPermissionUI.getContext(), SettingOverlayPermissionUI.class);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramSettingsSystemPermissionUI, paramView.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-17", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramSettingsSystemPermissionUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramSettingsSystemPermissionUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "initView$lambda-17", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSystemPermissionUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299197);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.g.settings_system_permissions;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(299263);
    super.initView();
    Object localObject2 = findViewById(com.tencent.mm.plugin.setting.b.f.permission_location_wrapper);
    Object localObject1 = findViewById(com.tencent.mm.plugin.setting.b.f.permission_contact_wrapper);
    Object localObject3 = findViewById(com.tencent.mm.plugin.setting.b.f.permission_storage_wrapper);
    View localView1 = findViewById(com.tencent.mm.plugin.setting.b.f.permission_record_wrapper);
    View localView2 = findViewById(com.tencent.mm.plugin.setting.b.f.permission_sport_wrapper);
    View localView3 = findViewById(com.tencent.mm.plugin.setting.b.f.permission_camera_wrapper);
    View localView4 = findViewById(com.tencent.mm.plugin.setting.b.f.permission_saw_wrapper);
    localObject2 = ak.f(new r[] { v.Y("android.permission.ACCESS_FINE_LOCATION", localObject2), v.Y("android.permission.READ_CONTACTS", localObject1), v.Y(new r("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"), localObject3), v.Y("android.permission.RECORD_AUDIO", localView1), v.Y("android.permission.ACTIVITY_RECOGNITION", localView2), v.Y("android.permission.CAMERA", localView3) }).entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = (Serializable)((Map.Entry)localObject4).getKey();
      localObject4 = (View)((Map.Entry)localObject4).getValue();
      boolean bool;
      if ((localObject3 instanceof r)) {
        if (!com.tencent.mm.pluginsdk.permission.b.g((Context)getContext(), new String[] { String.valueOf(((r)localObject3).bsC) }))
        {
          if (!com.tencent.mm.pluginsdk.permission.b.g((Context)getContext(), new String[] { String.valueOf(((r)localObject3).bsD) })) {}
        }
        else {
          bool = true;
        }
      }
      for (;;)
      {
        if (!bool) {
          break label346;
        }
        ((View)localObject4).setVisibility(0);
        i = 1;
        break;
        bool = false;
        continue;
        if ((localObject3 instanceof String)) {
          bool = com.tencent.mm.pluginsdk.permission.b.g((Context)getContext(), new String[] { (String)localObject3 });
        } else {
          bool = false;
        }
      }
      label346:
      ((View)localObject4).setVisibility(8);
    }
    if (com.tencent.mm.pluginsdk.permission.b.lw((Context)getContext()))
    {
      localView4.setVisibility(0);
      i = 1;
      if (i == 0) {
        break label487;
      }
      findViewById(com.tencent.mm.plugin.setting.b.f.granted_permission_container).setVisibility(0);
      findViewById(com.tencent.mm.plugin.setting.b.f.no_permission_granted_container).setVisibility(8);
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.sensitive.d.b.acvJ;
      com.tencent.mm.sensitive.d.b.report(102L);
      if (!((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).isUsingOldPermissionDialog()) {
        break label566;
      }
      localObject1 = ((Iterable)this.Pwz).iterator();
      while (((Iterator)localObject1).hasNext()) {
        findViewById(((Number)((Iterator)localObject1).next()).intValue()).setVisibility(0);
      }
      localView4.setVisibility(8);
      break;
      label487:
      findViewById(com.tencent.mm.plugin.setting.b.f.granted_permission_container).setVisibility(8);
      findViewById(com.tencent.mm.plugin.setting.b.f.no_permission_granted_container).setVisibility(0);
    }
    localObject1 = ((Iterable)this.PwA).iterator();
    while (((Iterator)localObject1).hasNext()) {
      findViewById(((Number)((Iterator)localObject1).next()).intValue()).setVisibility(8);
    }
    AppMethodBeat.o(299263);
    return;
    label566:
    localObject2 = ((Iterable)this.Pwz).iterator();
    while (((Iterator)localObject2).hasNext()) {
      findViewById(((Number)((Iterator)localObject2).next()).intValue()).setVisibility(8);
    }
    localObject2 = ((Iterable)this.PwA).iterator();
    while (((Iterator)localObject2).hasNext()) {
      findViewById(((Number)((Iterator)localObject2).next()).intValue()).setVisibility(0);
    }
    findViewById(com.tencent.mm.plugin.setting.b.f.system_permission_locaion).setOnClickListener(new SettingsSystemPermissionUI..ExternalSyntheticLambda8(this));
    findViewById(com.tencent.mm.plugin.setting.b.f.permission_storage_wrapper).setOnClickListener(new SettingsSystemPermissionUI..ExternalSyntheticLambda1(this));
    ((View)localObject1).setOnClickListener(new SettingsSystemPermissionUI..ExternalSyntheticLambda5(this));
    localView3.setOnClickListener(new SettingsSystemPermissionUI..ExternalSyntheticLambda4(this));
    localView1.setOnClickListener(new SettingsSystemPermissionUI..ExternalSyntheticLambda6(this));
    localView2.setOnClickListener(new SettingsSystemPermissionUI..ExternalSyntheticLambda3(this));
    localView4.setOnClickListener(new SettingsSystemPermissionUI..ExternalSyntheticLambda7(this));
    AppMethodBeat.o(299263);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(299250);
    com.tencent.mm.pluginsdk.h.w((MMActivity)this);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.Inv = findViewById(com.tencent.mm.plugin.sns.b.f.action_bar_container);
    if ((this.Inv == null) || (!c.afCQ)) {}
    Object localObject;
    for (;;)
    {
      setNavigationbarColor(getResources().getColor(b.c.BG_2));
      paramBundle = getWindow().getDecorView();
      s.s(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1280);
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(getResources().getColor(b.c.BG_2));
      setActionbarElementColor(getContext().getResources().getColor(b.c.FG_0));
      setBackBtn(new SettingsSystemPermissionUI..ExternalSyntheticLambda0(this));
      supportLightStatusBar();
      paramBundle = new ah.a();
      paramBundle.aiwY = true;
      localObject = findViewById(com.tencent.mm.plugin.setting.b.f.granted_permission_container);
      if (localObject != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.ScrollView");
      AppMethodBeat.o(299250);
      throw paramBundle;
      paramBundle = c.ch((Activity)this);
      localObject = new SettingsSystemPermissionUI..ExternalSyntheticLambda10(this);
      this.Inw = ((c.a)localObject);
      ah localah = ah.aiuX;
      paramBundle.a((c.a)localObject);
      getWindow().getDecorView().requestApplyInsets();
      com.tencent.mm.ui.statusbar.d.g(getWindow());
    }
    ((ScrollView)localObject).setOnScrollChangeListener(new SettingsSystemPermissionUI..ExternalSyntheticLambda9(this, paramBundle));
    int j = com.tencent.mm.plugin.setting.b.f.goto_system_permission_settings;
    int k = com.tencent.mm.plugin.setting.b.f.goto_system_permission_settings2;
    while (i < 2)
    {
      paramBundle = (TextView)findViewById(((Number)new Integer[] { Integer.valueOf(j), Integer.valueOf(k) }[i]).intValue());
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new SettingsSystemPermissionUI..ExternalSyntheticLambda2(this));
      }
      i += 1;
    }
    AppMethodBeat.o(299250);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(299253);
    super.onResume();
    initView();
    AppMethodBeat.o(299253);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSystemPermissionUI
 * JD-Core Version:    0.7.0.1
 */