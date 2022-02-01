package com.tencent.mm.plugin.setting.ui.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindOtherServiceUI.a;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.widget.a.j.b;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2, com.tencent.mm.plugin.setting.model.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(298623);
    if (paramBoolean) {}
    for (paramContext = new com.tencent.mm.plugin.setting.model.a(paramContext, paramInt1, paramInt2, paramLong1, paramLong2, parama, (byte)0);; paramContext = new com.tencent.mm.plugin.setting.model.a(paramContext, paramInt1, paramInt2, paramLong1, paramLong2, parama))
    {
      paramContext.hks = true;
      paramContext.gUT();
      AppMethodBeat.o(298623);
      return;
    }
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong1, long paramLong2, com.tencent.mm.plugin.setting.model.a.a parama)
  {
    AppMethodBeat.i(298621);
    a(paramContext, 1, paramInt, paramLong1, paramLong2, parama, false);
    AppMethodBeat.o(298621);
  }
  
  public static void a(Context paramContext, long paramLong, CheckBoxPreference paramCheckBoxPreference, a parama, int paramInt)
  {
    AppMethodBeat.i(298627);
    b(paramContext, paramLong, paramCheckBoxPreference, parama, paramInt);
    AppMethodBeat.o(298627);
  }
  
  public static void a(Context paramContext, String paramString, SettingsManageFindOtherServiceUI.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(298611);
    String str = paramContext.getString(com.tencent.mm.plugin.setting.b.i.setting_finder_other_services_dlg_bottom_tips);
    final com.tencent.mm.ui.base.p localp = new com.tencent.mm.ui.base.p(paramContext);
    localp.bAe(paramString).bAf(str).j(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(298605);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/utils/SafeSwitchTipDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.this.adRn = true;
        a.this.cyW();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/utils/SafeSwitchTipDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(298605);
      }
    }).jmq();
    com.tencent.mm.pluginsdk.ui.span.p.a(paramContext, jG(paramContext), str, jH(paramContext), localp.qjr);
    localp.k(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(298617);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/utils/SafeSwitchTipDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.this.cyW();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/utils/SafeSwitchTipDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(298617);
      }
    });
    localp.bAg(paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.setting_finder_common_double_dlg_ok));
    localp.agfT = new j.b()
    {
      public final void dismiss()
      {
        AppMethodBeat.i(298609);
        a.this.sK(localp.adRn);
        AppMethodBeat.o(298609);
      }
    };
    localp.dDn();
    AppMethodBeat.o(298611);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(298638);
    if (paramBoolean)
    {
      a(paramContext, paramContext.getString(com.tencent.mm.plugin.setting.b.i.setting_finder_other_services_dlg_bottom_title), new SettingsManageFindOtherServiceUI.a()
      {
        public final void sK(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(298613);
          if (paramAnonymousBoolean)
          {
            a.a(a.this, 3, 1, this.Pub, 8L, new com.tencent.mm.plugin.setting.model.a.a()
            {
              public final void b(boolean paramAnonymous2Boolean, app paramAnonymous2app)
              {
                AppMethodBeat.i(298612);
                if ((paramAnonymous2app == null) || (!paramAnonymous2Boolean))
                {
                  a.cZ(a.this);
                  a.5.this.Pyj.cjC();
                  AppMethodBeat.o(298612);
                  return;
                }
                a.jI(a.this);
                a.5.this.Pyj.onSuccess();
                AppMethodBeat.o(298612);
              }
            }, true);
            AppMethodBeat.o(298613);
            return;
          }
          parama.cjC();
          AppMethodBeat.o(298613);
        }
      }, true);
      AppMethodBeat.o(298638);
      return;
    }
    Log.i("MicroMsg.SafeSwitchTipDialog", "doSave. switchValue = 0, WhichExtFunctionSwitch= 8");
    a(paramContext, 3, 2, 8L, 0L, new com.tencent.mm.plugin.setting.model.a.a()
    {
      public final void b(boolean paramAnonymousBoolean, app paramAnonymousapp)
      {
        AppMethodBeat.i(298620);
        if ((paramAnonymousapp == null) || (!paramAnonymousBoolean))
        {
          Log.i("MicroMsg.SafeSwitchTipDialog", "doSave. response = success");
          a.this.cjC();
          AppMethodBeat.o(298620);
          return;
        }
        Log.i("MicroMsg.SafeSwitchTipDialog", "doSave. response = fail");
        a.this.onSuccess();
        AppMethodBeat.o(298620);
      }
    }, true);
    AppMethodBeat.o(298638);
  }
  
  private static void b(Context paramContext, long paramLong, CheckBoxPreference paramCheckBoxPreference, final a parama, final int paramInt)
  {
    AppMethodBeat.i(298631);
    String str = paramContext.getString(com.tencent.mm.plugin.setting.b.i.setting_finder_other_services_dlg_bottom_title);
    paramCheckBoxPreference = new SettingsManageFindOtherServiceUI.a()
    {
      public final void sK(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(298614);
        if (paramAnonymousBoolean)
        {
          a.a(a.this, paramInt, 1, this.Pub, 0L, new com.tencent.mm.plugin.setting.model.a.a()
          {
            public final void b(boolean paramAnonymous2Boolean, app paramAnonymous2app)
            {
              AppMethodBeat.i(298608);
              if ((paramAnonymous2app == null) || (!paramAnonymous2Boolean))
              {
                a.cZ(a.this);
                if (a.4.this.PtN != null)
                {
                  paramAnonymous2app = a.4.this.PtN;
                  if (a.4.this.PtN.isChecked()) {
                    break label67;
                  }
                }
                label67:
                for (paramAnonymous2Boolean = true;; paramAnonymous2Boolean = false)
                {
                  paramAnonymous2app.Hy(paramAnonymous2Boolean);
                  AppMethodBeat.o(298608);
                  return;
                }
              }
              a.jI(a.this);
              a.4.this.Pyg.onSuccess();
              AppMethodBeat.o(298608);
            }
          }, this.Pyh);
          AppMethodBeat.o(298614);
          return;
        }
        this.Pyg.cjC();
        AppMethodBeat.o(298614);
      }
    };
    if (paramInt == 3) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramContext, str, paramCheckBoxPreference, bool);
      AppMethodBeat.o(298631);
      return;
    }
  }
  
  public static void cZ(Context paramContext)
  {
    AppMethodBeat.i(298619);
    aa.y(paramContext, paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.setting_finder_common_fail_toast), com.tencent.mm.plugin.sns.b.i.icons_filled_error);
    AppMethodBeat.o(298619);
  }
  
  private static List<String> jG(Context paramContext)
  {
    AppMethodBeat.i(298606);
    ArrayList localArrayList = new ArrayList();
    if ("zh_CN".equals(LocaleUtil.getCurrentLanguage(paramContext)))
    {
      localArrayList.add(paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.setting_wechat_tx_software_safe_guide_link_zh));
      localArrayList.add(paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.setting_wechat_privary_guide_link_zh));
    }
    for (;;)
    {
      AppMethodBeat.o(298606);
      return localArrayList;
      localArrayList.add(paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.setting_wechat_tx_software_safe_guide_link));
      localArrayList.add(paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.setting_wechat_privary_guide_link));
    }
  }
  
  private static List<String> jH(Context paramContext)
  {
    AppMethodBeat.i(298607);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramContext.getString(com.tencent.mm.plugin.setting.b.i.setting_wechat_tx_software_safe_guide));
    localArrayList.add(paramContext.getString(com.tencent.mm.plugin.setting.b.i.setting_wechat_privary_guide));
    AppMethodBeat.o(298607);
    return localArrayList;
  }
  
  public static void jI(Context paramContext)
  {
    AppMethodBeat.i(298616);
    aa.y(paramContext, paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.setting_finder_common_ok_toast), com.tencent.mm.plugin.sns.b.i.icons_filled_done);
    AppMethodBeat.o(298616);
  }
  
  public static abstract interface a
  {
    public abstract void cjC();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.b.a
 * JD-Core Version:    0.7.0.1
 */