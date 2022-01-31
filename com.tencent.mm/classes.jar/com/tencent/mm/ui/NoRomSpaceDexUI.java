package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;

public class NoRomSpaceDexUI
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29832);
    super.onCreate(paramBundle);
    aa.initLanguage(ah.getContext());
    setContentView(2130970362);
    String str = getString(2131298348);
    paramBundle = new o(this);
    paramBundle.setTitle(2131298349);
    paramBundle.zai.setVisibility(0);
    paramBundle.zag.setVisibility(0);
    paramBundle.zag.setText(str);
    str = getString(2131298346);
    DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29831);
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(29831);
      }
    };
    if (paramBundle.usy != null)
    {
      paramBundle.usy.setVisibility(0);
      paramBundle.usy.setText(str);
      paramBundle.usy.setOnClickListener(new o.1(paramBundle, local1));
    }
    paramBundle.setCancelable(false);
    paramBundle.dCp();
    paramBundle.show();
    AppMethodBeat.o(29832);
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