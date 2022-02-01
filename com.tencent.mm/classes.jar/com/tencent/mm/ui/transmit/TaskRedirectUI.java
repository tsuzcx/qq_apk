package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.ui.LauncherUI;

@com.tencent.mm.ui.base.a(7)
public class TaskRedirectUI
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39486);
    super.onCreate(paramBundle);
    paramBundle = new Intent(this, LauncherUI.class);
    paramBundle.addFlags(268435456);
    paramBundle.addFlags(67108864);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/ui/transmit/TaskRedirectUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramBundle.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/TaskRedirectUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(39486);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.TaskRedirectUI
 * JD-Core Version:    0.7.0.1
 */