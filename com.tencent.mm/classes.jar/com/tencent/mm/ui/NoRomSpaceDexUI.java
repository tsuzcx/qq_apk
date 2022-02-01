package com.tencent.mm.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class NoRomSpaceDexUI
  extends HellActivity
  implements DialogInterface.OnClickListener
{
  PendingIntent OKa;
  
  public Resources getResources()
  {
    AppMethodBeat.i(232702);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(232702);
    return localResources;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33679);
    if (this.OKa != null) {}
    try
    {
      this.OKa.send();
      label19:
      finish();
      paramDialogInterface = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramDialogInterface.axQ(), "com/tencent/mm/ui/NoRomSpaceDexUI", "onClick", "(Landroid/content/DialogInterface;I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramDialogInterface.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/NoRomSpaceDexUI", "onClick", "(Landroid/content/DialogInterface;I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(33679);
      return;
    }
    catch (PendingIntent.CanceledException paramDialogInterface)
    {
      break label19;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33678);
    super.onCreate(paramBundle);
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    setContentView(2131495855);
    Object localObject = getIntent();
    this.OKa = ((PendingIntent)((Intent)localObject).getParcelableExtra("action"));
    paramBundle = new p(this);
    if (((Intent)localObject).hasExtra("title"))
    {
      paramBundle.setTitle(((Intent)localObject).getStringExtra("title"));
      if (!((Intent)localObject).hasExtra("message")) {
        break label141;
      }
      paramBundle.setMessage(((Intent)localObject).getStringExtra("message"));
      label88:
      if (!((Intent)localObject).hasExtra("button")) {
        break label177;
      }
      paramBundle.setMessage(((Intent)localObject).getStringExtra("message"));
    }
    for (;;)
    {
      paramBundle.setCancelable(false);
      paramBundle.gIC();
      paramBundle.show();
      AppMethodBeat.o(33678);
      return;
      paramBundle.setTitle(((Intent)localObject).getIntExtra("titleRes", 2131757557));
      break;
      label141:
      int i = ((Intent)localObject).getIntExtra("messageRes", 2131757556);
      paramBundle.NIK.setVisibility(0);
      paramBundle.NIC.setVisibility(0);
      paramBundle.NIC.setText(i);
      break label88;
      label177:
      localObject = getString(((Intent)localObject).getIntExtra("buttonRes", 2131757554));
      if (paramBundle.HRF != null)
      {
        paramBundle.HRF.setVisibility(0);
        paramBundle.HRF.setText((CharSequence)localObject);
        paramBundle.HRF.setOnClickListener(new p.1(paramBundle, this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.NoRomSpaceDexUI
 * JD-Core Version:    0.7.0.1
 */