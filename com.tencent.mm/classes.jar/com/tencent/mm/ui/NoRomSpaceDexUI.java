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
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class NoRomSpaceDexUI
  extends HellActivity
  implements DialogInterface.OnClickListener
{
  PendingIntent adIY;
  
  public Resources getResources()
  {
    AppMethodBeat.i(250240);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(250240);
    return localResources;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33679);
    if (this.adIY != null) {}
    try
    {
      this.adIY.send();
      label19:
      finish();
      paramDialogInterface = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramDialogInterface.aYi(), "com/tencent/mm/ui/NoRomSpaceDexUI", "onClick", "(Landroid/content/DialogInterface;I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramDialogInterface.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/NoRomSpaceDexUI", "onClick", "(Landroid/content/DialogInterface;I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
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
    setContentView(R.i.gmB);
    Object localObject = getIntent();
    this.adIY = ((PendingIntent)((Intent)localObject).getParcelableExtra("action"));
    paramBundle = new s(this);
    if (((Intent)localObject).hasExtra("title"))
    {
      paramBundle.setTitle(((Intent)localObject).getStringExtra("title"));
      if (!((Intent)localObject).hasExtra("message")) {
        break label143;
      }
      paramBundle.setMessage(((Intent)localObject).getStringExtra("message"));
      label89:
      if (!((Intent)localObject).hasExtra("button")) {
        break label180;
      }
      paramBundle.setMessage(((Intent)localObject).getStringExtra("message"));
    }
    for (;;)
    {
      paramBundle.setCancelable(false);
      paramBundle.jjx();
      paramBundle.show();
      AppMethodBeat.o(33678);
      return;
      paramBundle.setTitle(((Intent)localObject).getIntExtra("titleRes", R.l.check_db_size_tip_dangerous_title));
      break;
      label143:
      int i = ((Intent)localObject).getIntExtra("messageRes", R.l.check_db_size_tip_dangerous_message);
      paramBundle.acrw.setVisibility(0);
      paramBundle.acro.setVisibility(0);
      paramBundle.acro.setText(i);
      break label89;
      label180:
      localObject = getString(((Intent)localObject).getIntExtra("buttonRes", R.l.check_db_size_btn_dangerous_message));
      if (paramBundle.BoW != null)
      {
        paramBundle.BoW.setVisibility(0);
        paramBundle.BoW.setText((CharSequence)localObject);
        paramBundle.BoW.setOnClickListener(new s.1(paramBundle, this));
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