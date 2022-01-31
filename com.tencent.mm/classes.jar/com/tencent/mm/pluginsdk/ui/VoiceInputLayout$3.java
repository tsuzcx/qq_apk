package com.tencent.mm.pluginsdk.ui;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceInputLayout$3
  extends ah
{
  VoiceInputLayout$3(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return;
        paramMessage = this.sbr;
        y.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(paramMessage.kFU) });
      } while (paramMessage.kFU != 2);
      paramMessage.kFU = 3;
      paramMessage.gNQ.removeMessages(0);
      paramMessage.gNQ.sendEmptyMessageDelayed(0, paramMessage.kGa);
      paramMessage.gNQ.sendEmptyMessageDelayed(1, paramMessage.kGb);
      paramMessage.db(false);
      return;
    }
    paramMessage = paramMessage.getData();
    this.sbr.I(paramMessage.getInt("localCode"), paramMessage.getInt("errType"), paramMessage.getInt("errCode"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout.3
 * JD-Core Version:    0.7.0.1
 */