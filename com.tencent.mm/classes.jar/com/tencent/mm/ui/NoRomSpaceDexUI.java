package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

public class NoRomSpaceDexUI
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    x.initLanguage(ae.getContext());
    setContentView(R.i.no_space_dex);
    String str = getString(R.l.check_db_size_tip_dangerous_message);
    paramBundle = new q(this);
    paramBundle.setTitle(R.l.check_db_size_tip_dangerous_title);
    paramBundle.uMb.setVisibility(0);
    paramBundle.uLZ.setVisibility(0);
    paramBundle.uLZ.setText(str);
    str = getString(R.l.check_db_size_btn_dangerous_message);
    DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Process.killProcess(Process.myPid());
      }
    };
    if (paramBundle.qFr != null)
    {
      paramBundle.qFr.setVisibility(0);
      paramBundle.qFr.setText(str);
      paramBundle.qFr.setOnClickListener(new q.1(paramBundle, local1));
    }
    paramBundle.setCancelable(false);
    paramBundle.cze();
    paramBundle.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.NoRomSpaceDexUI
 * JD-Core Version:    0.7.0.1
 */