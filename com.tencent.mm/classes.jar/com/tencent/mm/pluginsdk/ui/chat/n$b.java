package com.tencent.mm.pluginsdk.ui.chat;

import android.telephony.PhoneStateListener;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.sdk.platformtools.y;

final class n$b
  extends PhoneStateListener
{
  VoiceInputLayout sgU;
  
  public n$b(VoiceInputLayout paramVoiceInputLayout)
  {
    this.sgU = paramVoiceInputLayout;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    int i = -1;
    if (this.sgU != null)
    {
      i = this.sgU.getCurrentState();
      this.sgU.TG();
    }
    y.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i != 2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.b
 * JD-Core Version:    0.7.0.1
 */