package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceInputLayoutImpl$1
  implements View.OnLongClickListener
{
  VoiceInputLayoutImpl$1(VoiceInputLayoutImpl paramVoiceInputLayoutImpl) {}
  
  public final boolean onLongClick(View paramView)
  {
    y.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(this.sbt.kFU) });
    VoiceInputLayoutImpl.a(this.sbt, true);
    VoiceInputLayoutImpl.a(this.sbt).cmw();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.1
 * JD-Core Version:    0.7.0.1
 */