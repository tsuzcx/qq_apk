package com.tencent.mm.plugin.voip.floatcard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.j;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/floatcard/VoipFloatCardPermissionDialog;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showDialog", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VoipFloatCardPermissionDialog
  extends MMBaseActivity
{
  public static final a UvI;
  
  static
  {
    AppMethodBeat.i(292342);
    UvI = new a((byte)0);
    AppMethodBeat.o(292342);
  }
  
  private static final void a(VoipFloatCardPermissionDialog paramVoipFloatCardPermissionDialog)
  {
    AppMethodBeat.i(292328);
    s.u(paramVoipFloatCardPermissionDialog, "this$0");
    paramVoipFloatCardPermissionDialog.finish();
    AppMethodBeat.o(292328);
  }
  
  private static final void a(VoipFloatCardPermissionDialog paramVoipFloatCardPermissionDialog, j paramj)
  {
    AppMethodBeat.i(292338);
    s.u(paramVoipFloatCardPermissionDialog, "this$0");
    s.u(paramj, "$this_apply");
    if (d.rb(23)) {
      try
      {
        Object localObject1 = Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class);
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(292338);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.e("VoipFloatCardPermission", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", new Object[] { localException.getMessage(), localException.getClass().getCanonicalName() });
      }
    }
    while (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = paramVoipFloatCardPermissionDialog.getString(b.g.floating_window_permission_url);
      s.s(localObject2, "getString(R.string.floating_window_permission_url)");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", (String)localObject2);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      c.b((Context)paramVoipFloatCardPermissionDialog, "webview", ".ui.tools.WebViewUI", localIntent);
      paramj.cyW();
      paramVoipFloatCardPermissionDialog.finish();
      AppMethodBeat.o(292338);
      return;
    }
    Object localObject2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(s.X("package:", MMApplicationContext.getPackageName())));
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(paramVoipFloatCardPermissionDialog, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/voip/floatcard/VoipFloatCardPermissionDialog", "showDialog$lambda-2$lambda-1", "(Lcom/tencent/mm/plugin/voip/floatcard/VoipFloatCardPermissionDialog;Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramVoipFloatCardPermissionDialog.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramVoipFloatCardPermissionDialog, "com/tencent/mm/plugin/voip/floatcard/VoipFloatCardPermissionDialog", "showDialog$lambda-2$lambda-1", "(Lcom/tencent/mm/plugin/voip/floatcard/VoipFloatCardPermissionDialog;Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramj.cyW();
    paramVoipFloatCardPermissionDialog.finish();
    AppMethodBeat.o(292338);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(292359);
    super.onCreate(paramBundle);
    Log.i("VoipFloatCardPermission", "showDialog: ");
    if (b.dh((Context)this))
    {
      finish();
      Log.i("VoipFloatCardPermission", "showDialog: has permission");
      AppMethodBeat.o(292359);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("voip_float_card_config");
    int i;
    j localj;
    if ((localMultiProcessMMKV != null) && (localMultiProcessMMKV.getBoolean("has_showed_dialog", false) == true))
    {
      i = 1;
      if (i != 0) {
        break label198;
      }
      localj = new j((Context)this, 2, 1);
      localj.aFe(0);
      if (!d.rb(23)) {
        break label187;
      }
    }
    label187:
    for (paramBundle = getText(b.g.voip_float_card_permission_dialog_btn_tip);; paramBundle = getText(b.g.voip_float_card_permission_dialog_btn_tip_below23))
    {
      localj.au(paramBundle);
      localj.aFf(b.e.voip_float_card_permission_dialog_layout);
      localj.agfT = new VoipFloatCardPermissionDialog..ExternalSyntheticLambda1(this);
      localj.agfR = new VoipFloatCardPermissionDialog..ExternalSyntheticLambda0(this, localj);
      localj.dDn();
      Log.i("VoipFloatCardPermission", "showDialog: show");
      localMultiProcessMMKV.putBoolean("has_showed_dialog", true);
      AppMethodBeat.o(292359);
      return;
      i = 0;
      break;
    }
    label198:
    Log.i("VoipFloatCardPermission", "showDialog: finish");
    finish();
    AppMethodBeat.o(292359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/floatcard/VoipFloatCardPermissionDialog$Companion;", "", "()V", "HAS_SHOWED_DIALOG", "", "MMKV_CONFIG", "TAG", "showDialog", "", "context", "Landroid/content/Context;", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void showDialog(Context paramContext)
    {
      AppMethodBeat.i(292233);
      s.u(paramContext, "context");
      Object localObject = new Intent(paramContext, VoipFloatCardPermissionDialog.class);
      ((Intent)localObject).addFlags(805306368);
      ah localah = ah.aiuX;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/voip/floatcard/VoipFloatCardPermissionDialog$Companion", "showDialog", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/voip/floatcard/VoipFloatCardPermissionDialog$Companion", "showDialog", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(292233);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.floatcard.VoipFloatCardPermissionDialog
 * JD-Core Version:    0.7.0.1
 */