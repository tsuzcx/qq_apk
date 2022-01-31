package com.tencent.mm.pluginsdk.ui.websearch;

import android.telephony.PhoneStateListener;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.sdk.platformtools.y;

final class a$4
  extends PhoneStateListener
{
  a$4(a parama) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    int i = -1;
    if (a.f(this.snT) != null) {
      i = a.f(this.snT).getCurrentState();
    }
    y.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i != 2) {
      return;
    }
    this.snT.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a.4
 * JD-Core Version:    0.7.0.1
 */