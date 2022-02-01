package com.tencent.mm.plugin.webwx.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abn;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMBaseActivity;

public class WebWXPopupUnlockUI
  extends MMBaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30243);
    super.onCreate(paramBundle);
    if (getIntent() != null)
    {
      paramBundle = getIntent().getStringExtra("deviceName");
      if (paramBundle != null)
      {
        final com.tencent.mm.plugin.crashfix.b.a locala = new com.tencent.mm.plugin.crashfix.b.a(this);
        locala.requestWindowFeature(1);
        View localView = View.inflate(this, R.i.gjP, null);
        TextView localTextView = (TextView)localView.findViewById(R.h.fFp);
        ((TextView)localView.findViewById(R.h.gbh)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(30241);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webwx/ui/WebWXPopupUnlockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = new com.tencent.mm.plugin.webwx.model.b(2);
            bh.aZW().a(paramAnonymousView, 0);
            Log.d("MicroMsg.WebWxPopUnlockUI", "doScene netSceneExtDeviceControl : UNLOCK");
            com.tencent.mm.plugin.webwx.a.pFo.nK(1);
            Log.d("MicroMsg.WebWxPopUnlockUI", "trigger netSceneSync notify");
            locala.dismiss();
            new abn().publish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXPopupUnlockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30241);
          }
        });
        locala.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(30242);
            WebWXPopupUnlockUI.this.finish();
            AppMethodBeat.o(30242);
          }
        });
        localTextView.setText(paramBundle);
        locala.setContentView(localView);
        locala.show();
        AppMethodBeat.o(30243);
        return;
      }
      Log.w("MicroMsg.WebWxPopUnlockUI", "Mac WeChat request to unlock,the deviceName is null");
    }
    AppMethodBeat.o(30243);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI
 * JD-Core Version:    0.7.0.1
 */