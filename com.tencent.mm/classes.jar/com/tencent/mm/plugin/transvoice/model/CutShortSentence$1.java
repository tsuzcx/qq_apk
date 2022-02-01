package com.tencent.mm.plugin.transvoice.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wi;
import com.tencent.mm.autogen.a.wi.a;
import com.tencent.mm.modelvoiceaddr.a.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class CutShortSentence$1
  extends IListener<wi>
{
  short[] pfS;
  
  CutShortSentence$1(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(262518);
    this.__eventId = wi.class.getName().hashCode();
    AppMethodBeat.o(262518);
  }
  
  private boolean a(wi paramwi)
  {
    AppMethodBeat.i(102618);
    for (;;)
    {
      synchronized (this.TTU)
      {
        Log.d("MicroMsg.CutShortSentence", "receive SceneVoiceRcdDataEvent.");
        byte[] arrayOfByte = paramwi.hZW.buf;
        int j = paramwi.hZW.len;
        Log.i("MicroMsg.CutShortSentence", "rec data, len: %s time: %s.", new Object[] { Integer.valueOf(j), Long.valueOf(System.currentTimeMillis()) });
        if ((this.pfS == null) || (this.pfS.length < j / 2))
        {
          this.pfS = new short[j / 2];
          break label200;
          if (i < j / 2)
          {
            this.pfS[i] = ((short)(arrayOfByte[(i * 2)] & 0xFF | arrayOfByte[(i * 2 + 1)] << 8));
            i += 1;
            continue;
          }
          if (a.a(this.TTU) != null)
          {
            a.a(this.TTU).f(this.pfS, j / 2);
            AppMethodBeat.o(102618);
            return false;
          }
          a.apo(4);
          Log.e("MicroMsg.CutShortSentence", "mVoiceSilentDetectAPI is null");
        }
      }
      label200:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.model.CutShortSentence.1
 * JD-Core Version:    0.7.0.1
 */