package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class f$8
  implements View.OnClickListener
{
  f$8(f paramf) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
    if ((this.pZw.pWz != null) && (this.pZw.pWz.get() != null) && (((c)this.pZw.pWz.get()).bQs())) {
      this.pZw.cD(this.pZw.getString(a.e.voip_finish_call), -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f.8
 * JD-Core Version:    0.7.0.1
 */