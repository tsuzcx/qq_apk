package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/HldContactUI;", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity;", "()V", "postLogin", "", "loginResult", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;", "intent", "Landroid/content/Intent;", "preLogin", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HldContactUI
  extends AutoLoginActivity
{
  public static final a adAh;
  
  static
  {
    AppMethodBeat.i(249590);
    adAh = new a((byte)0);
    AppMethodBeat.o(249590);
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    int j = 7;
    AppMethodBeat.i(249600);
    int i;
    if (parama == null) {
      i = -1;
    }
    while (i == 1)
    {
      parama = l.JyV;
      parama = MMApplicationContext.getContext();
      s.s(parama, "getContext()");
      if (l.ic(parama))
      {
        if (paramIntent != null) {
          break label80;
        }
        parama = null;
        if (parama == null) {
          Log.e("WxIme.HldContactUI", "intent is null");
        }
      }
      finish();
      AppMethodBeat.o(249600);
      return;
      i = b.$EnumSwitchMapping$0[parama.ordinal()];
      continue;
      label80:
      parama = new Intent();
      parama.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.hld.ui.WelabHldInfoUI");
      if (Util.isEqual(paramIntent.getStringExtra("ime_enter_scene"), Integer.valueOf(7))) {
        parama.putExtra("ime_open_active", true);
      }
      for (i = j;; i = 8)
      {
        parama.putExtra("ime_enter_scene", i);
        parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
        com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/HldContactUI", "postLogin", "(Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)parama.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/HldContactUI", "postLogin", "(Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama = ah.aiuX;
        break;
      }
    }
    finish();
    AppMethodBeat.o(249600);
  }
  
  public final boolean ad(Intent paramIntent)
  {
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/HldContactUI$Companion;", "", "()V", "TAG", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HldContactUI
 * JD-Core Version:    0.7.0.1
 */