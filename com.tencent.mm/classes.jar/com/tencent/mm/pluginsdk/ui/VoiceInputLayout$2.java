package com.tencent.mm.pluginsdk.ui;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

final class VoiceInputLayout$2
  implements g.b
{
  VoiceInputLayout$2(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final void amK()
  {
    AppMethodBeat.i(27580);
    ab.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(this.vSy.currentState) });
    if (VoiceInputLayout.c(this.vSy) != null) {
      VoiceInputLayout.c(this.vSy).stopTimer();
    }
    VoiceInputLayout.d(this.vSy).sendEmptyMessage(0);
    AppMethodBeat.o(27580);
  }
  
  public final void amO()
  {
    AppMethodBeat.i(27581);
    ab.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
    VoiceInputLayout.a(this.vSy).removeMessages(0);
    VoiceInputLayout.a(this.vSy).removeMessages(1);
    VoiceInputLayout.e(this.vSy).bDw();
    this.vSy.reset(false);
    AppMethodBeat.o(27581);
  }
  
  public final void b(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(138173);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ab.d("SucconRes", "str: %s.", new Object[] { paramArrayOfString[i] });
      i += 1;
    }
    VoiceInputLayout.e(this.vSy).c(paramArrayOfString, paramList);
    VoiceInputLayout.a(this.vSy).removeMessages(0);
    VoiceInputLayout.a(this.vSy).sendEmptyMessageDelayed(0, VoiceInputLayout.f(this.vSy));
    AppMethodBeat.o(138173);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(27583);
    VoiceInputLayout.a(this.vSy).removeMessages(0);
    VoiceInputLayout.a(this.vSy).removeMessages(1);
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putInt("localCode", paramInt1);
    localBundle.putInt("errType", paramInt2);
    localBundle.putInt("errCode", paramInt3);
    localMessage.setData(localBundle);
    localMessage.what = 1;
    VoiceInputLayout.d(this.vSy).sendMessage(localMessage);
    AppMethodBeat.o(27583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout.2
 * JD-Core Version:    0.7.0.1
 */