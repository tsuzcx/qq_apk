package com.tencent.mm.pluginsdk.ui;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

final class VoiceInputLayout$2
  implements g.b
{
  VoiceInputLayout$2(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final void TC()
  {
    y.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
    VoiceInputLayout.a(this.sbr).removeMessages(0);
    VoiceInputLayout.a(this.sbr).removeMessages(1);
    VoiceInputLayout.e(this.sbr).aWP();
    this.sbr.reset(false);
  }
  
  public final void Ty()
  {
    y.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(this.sbr.kFU) });
    if (VoiceInputLayout.c(this.sbr) != null) {
      VoiceInputLayout.c(this.sbr).stopTimer();
    }
    VoiceInputLayout.d(this.sbr).sendEmptyMessage(0);
  }
  
  public final void a(String[] paramArrayOfString, Set<String> paramSet)
  {
    VoiceInputLayout.e(this.sbr).b(paramArrayOfString, paramSet);
    VoiceInputLayout.a(this.sbr).removeMessages(0);
    VoiceInputLayout.a(this.sbr).sendEmptyMessageDelayed(0, VoiceInputLayout.f(this.sbr));
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    VoiceInputLayout.a(this.sbr).removeMessages(0);
    VoiceInputLayout.a(this.sbr).removeMessages(1);
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putInt("localCode", paramInt1);
    localBundle.putInt("errType", paramInt2);
    localBundle.putInt("errCode", paramInt3);
    localMessage.setData(localBundle);
    localMessage.what = 1;
    VoiceInputLayout.d(this.sbr).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout.2
 * JD-Core Version:    0.7.0.1
 */