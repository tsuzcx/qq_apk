package com.tencent.mm.pluginsdk;

import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class h$3
  implements Runnable
{
  h$3(AppCompatActivity paramAppCompatActivity, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(141146);
    this.QSb.getWindow().getDecorView().setSystemUiVisibility(this.QSb.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
    Log.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", new Object[] { Integer.valueOf(this.val$height) });
    if (this.OKn != null) {
      this.OKn.setPadding(0, this.val$height, 0, 0);
    }
    AppMethodBeat.o(141146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.3
 * JD-Core Version:    0.7.0.1
 */