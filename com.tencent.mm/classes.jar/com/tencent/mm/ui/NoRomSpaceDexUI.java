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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;

public class NoRomSpaceDexUI
  extends HellActivity
  implements DialogInterface.OnClickListener
{
  PendingIntent FRz;
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33679);
    if (this.FRz != null) {}
    try
    {
      this.FRz.send();
      label19:
      System.exit(0);
      Process.killProcess(Process.myPid());
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
    ac.initLanguage(aj.getContext());
    setContentView(2131495023);
    Object localObject = getIntent();
    this.FRz = ((PendingIntent)((Intent)localObject).getParcelableExtra("action"));
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
      paramBundle.eQS();
      paramBundle.show();
      AppMethodBeat.o(33678);
      return;
      paramBundle.setTitle(((Intent)localObject).getIntExtra("titleRes", 2131757340));
      break;
      label141:
      int i = ((Intent)localObject).getIntExtra("messageRes", 2131757337);
      paramBundle.ESe.setVisibility(0);
      paramBundle.ERW.setVisibility(0);
      paramBundle.ERW.setText(i);
      break label88;
      label177:
      localObject = getString(((Intent)localObject).getIntExtra("buttonRes", 2131757337));
      if (paramBundle.zXZ != null)
      {
        paramBundle.zXZ.setVisibility(0);
        paramBundle.zXZ.setText((CharSequence)localObject);
        paramBundle.zXZ.setOnClickListener(new o.1(paramBundle, this));
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