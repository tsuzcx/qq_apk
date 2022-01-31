package com.tencent.mm.plugin.webwx.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.crashfix.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMBaseActivity;

public class WebWXPopupUnlockUI
  extends MMBaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26570);
    super.onCreate(paramBundle);
    if (getIntent() != null)
    {
      paramBundle = getIntent().getStringExtra("deviceName");
      if (paramBundle != null)
      {
        a locala = new a(this);
        locala.requestWindowFeature(1);
        View localView = View.inflate(this, 2130969485, null);
        TextView localTextView = (TextView)localView.findViewById(2131823852);
        ((TextView)localView.findViewById(2131823853)).setOnClickListener(new WebWXPopupUnlockUI.1(this, locala));
        locala.setOnDismissListener(new WebWXPopupUnlockUI.2(this));
        localTextView.setText(paramBundle);
        locala.setContentView(localView);
        locala.show();
        AppMethodBeat.o(26570);
        return;
      }
      ab.w("MicroMsg.WebWxPopUnlockUI", "Mac WeChat request to unlock,the deviceName is null");
    }
    AppMethodBeat.o(26570);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI
 * JD-Core Version:    0.7.0.1
 */