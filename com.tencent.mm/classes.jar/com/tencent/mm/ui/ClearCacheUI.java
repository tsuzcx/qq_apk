package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;

public class ClearCacheUI
  extends MMBaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32994);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_message");
    final long l = getIntent().getLongExtra("key_mask", 0L);
    h.a(this, paramBundle, getString(2131757640), getString(2131757639), getString(2131757637), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32990);
        ClearCacheUI.a(ClearCacheUI.this, l);
        ClearCacheUI.this.finish();
        AppMethodBeat.o(32990);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32991);
        ClearCacheUI.this.finish();
        AppMethodBeat.o(32991);
      }
    });
    AppMethodBeat.o(32994);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ClearCacheUI
 * JD-Core Version:    0.7.0.1
 */