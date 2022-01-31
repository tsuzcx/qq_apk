package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class f$9
  implements View.OnClickListener
{
  f$9(f paramf) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
    if ((this.pZw.pWz != null) && (this.pZw.pWz.get() != null) && (((c)this.pZw.pWz.get()).bQA()))
    {
      this.pZw.cD(this.pZw.getString(a.e.voip_cancel_call), -1);
      f.j(this.pZw).setEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f.9
 * JD-Core Version:    0.7.0.1
 */