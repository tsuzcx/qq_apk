package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/HldContactUI;", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity;", "()V", "postLogin", "", "loginResult", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;", "intent", "Landroid/content/Intent;", "preLogin", "", "Companion", "app_release"})
public final class HldContactUI
  extends AutoLoginActivity
{
  public static final a VVJ;
  
  static
  {
    AppMethodBeat.i(287570);
    VVJ = new a((byte)0);
    AppMethodBeat.o(287570);
  }
  
  public final boolean Z(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    int i = 7;
    AppMethodBeat.i(287569);
    if (parama == null) {}
    for (;;)
    {
      finish();
      AppMethodBeat.o(287569);
      return;
      switch (k.$EnumSwitchMapping$0[parama.ordinal()])
      {
      }
    }
    parama = com.tencent.mm.plugin.hld.f.l.DHK;
    parama = MMApplicationContext.getContext();
    p.j(parama, "MMApplicationContext.getContext()");
    if (com.tencent.mm.plugin.hld.f.l.gJ(parama))
    {
      if (paramIntent == null) {
        break label203;
      }
      parama = new Intent();
      parama.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.hld.ui.WelabHldInfoUI");
      if (!Util.isEqual(paramIntent.getStringExtra("ime_enter_scene"), Integer.valueOf(7))) {
        break label197;
      }
      parama.putExtra("ime_open_active", true);
      parama.putExtra("ime_enter_scene", i);
      parama = new com.tencent.mm.hellhoundlib.b.a().bm(parama);
      com.tencent.mm.hellhoundlib.a.a.b(this, parama.aFh(), "com/tencent/mm/ui/HldContactUI", "postLogin", "(Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)parama.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/HldContactUI", "postLogin", "(Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(287569);
      return;
      label197:
      i = 8;
      break;
      label203:
      Log.e("WxIme.HldContactUI", "intent is null");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/HldContactUI$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HldContactUI
 * JD-Core Version:    0.7.0.1
 */