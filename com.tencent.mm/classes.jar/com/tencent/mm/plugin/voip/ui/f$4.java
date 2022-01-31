package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class f$4
  implements View.OnClickListener
{
  f$4(f paramf) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = f.a(this.pZw).isChecked();
    y.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[] { Boolean.valueOf(bool) });
    f.a(this.pZw).setEnabled(false);
    if ((this.pZw.pWz != null) && (this.pZw.pWz.get() != null)) {
      ((c)this.pZw.pWz.get()).jV(bool);
    }
    paramView = this.pZw;
    if (bool) {}
    for (int i = 1;; i = 2)
    {
      f.a(paramView, i);
      f.a(this.pZw).setEnabled(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f.4
 * JD-Core Version:    0.7.0.1
 */