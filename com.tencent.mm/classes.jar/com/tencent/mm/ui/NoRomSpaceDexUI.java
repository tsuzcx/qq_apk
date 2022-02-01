package com.tencent.mm.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;

public class NoRomSpaceDexUI
  extends HellActivity
  implements DialogInterface.OnClickListener
{
  PendingIntent JzE;
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33679);
    if (this.JzE != null) {}
    try
    {
      this.JzE.send();
      label19:
      finish();
      paramDialogInterface = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramDialogInterface.ahE(), "com/tencent/mm/ui/NoRomSpaceDexUI", "onClick", "(Landroid/content/DialogInterface;I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramDialogInterface.mt(0)).intValue());
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
    ad.initLanguage(ak.getContext());
    setContentView(2131495023);
    Object localObject = getIntent();
    this.JzE = ((PendingIntent)((Intent)localObject).getParcelableExtra("action"));
    paramBundle = new o(this);
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
      paramBundle.fAK();
      paramBundle.show();
      AppMethodBeat.o(33678);
      return;
      paramBundle.setTitle(((Intent)localObject).getIntExtra("titleRes", 2131757340));
      break;
      label141:
      int i = ((Intent)localObject).getIntExtra("messageRes", 2131757337);
      paramBundle.Ivm.setVisibility(0);
      paramBundle.Ivd.setVisibility(0);
      paramBundle.Ivd.setText(i);
      break label88;
      label177:
      localObject = getString(((Intent)localObject).getIntExtra("buttonRes", 2131757337));
      if (paramBundle.Dim != null)
      {
        paramBundle.Dim.setVisibility(0);
        paramBundle.Dim.setText((CharSequence)localObject);
        paramBundle.Dim.setOnClickListener(new o.1(paramBundle, this));
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