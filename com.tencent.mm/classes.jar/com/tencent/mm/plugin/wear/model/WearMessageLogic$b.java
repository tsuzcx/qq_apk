package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wear.model.e.p.1;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.qqpinyin.voicerecoapi.c;
import java.io.IOException;
import java.util.LinkedList;

final class WearMessageLogic$b
  extends com.tencent.mm.plugin.wear.model.f.d
{
  public int cnU;
  public int fOC;
  public int uHh;
  public byte[] uHi;
  
  private WearMessageLogic$b(WearMessageLogic paramWearMessageLogic) {}
  
  public final void execute()
  {
    AppMethodBeat.i(26323);
    switch (this.fOC)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26323);
      return;
      com.tencent.mm.plugin.wear.model.e.p localp = a.cYy().uGC.uGV;
      int i = this.cnU;
      Object localObject = this.uHi;
      if (localp.hmy.contains(Integer.valueOf(i))) {
        continue;
      }
      cya localcya = new cya();
      try
      {
        localcya.parseFrom((byte[])localObject);
        label85:
        if (localp.uHP == i)
        {
          if (localcya.yfi)
          {
            ab.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[] { Integer.valueOf(i) });
            localp.reset();
            AppMethodBeat.o(26323);
            return;
          }
          if (localcya.yfh)
          {
            localp.a(i, localcya);
            if (localp.uHN != null)
            {
              localp.uHN.Fb();
              localp.uHN = null;
              ab.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
            }
            if (localp.uHM != null)
            {
              localp.uHM.stop();
              localp.uHM = null;
              ab.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
            }
            if (localp.uHL != null)
            {
              localp.uHL.fZu = true;
              if (!localp.cMU) {
                aw.Rc().a(localp.uHL, 0);
              }
              localp.uHL = null;
              ab.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
            }
            AppMethodBeat.o(26323);
            return;
          }
          localp.a(i, localcya);
          AppMethodBeat.o(26323);
          return;
        }
        localp.reset();
        localp.uHP = i;
        ab.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[] { Integer.valueOf(localp.uHP) });
        e.deleteFile(com.tencent.mm.plugin.wear.model.e.p.uHK);
        if (localp.uHN == null)
        {
          localp.uHN = new com.tencent.mm.audio.e.d();
          localp.uHN.eN(com.tencent.mm.plugin.wear.model.e.p.uHK);
        }
        if (localp.uHM == null)
        {
          localp.uHM = new c(1500000);
          if (localp.uHM.dUg() != 0)
          {
            localp.uHQ = -2;
            AppMethodBeat.o(26323);
            return;
          }
        }
        localObject = localcya.xlH;
        if (localp.uHL == null) {
          al.d(new p.1(localp, (String)localObject));
        }
        localp.a(i, localcya);
      }
      catch (IOException localIOException)
      {
        break label85;
      }
    }
  }
  
  public final String getName()
  {
    return "LongConnectTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.WearMessageLogic.b
 * JD-Core Version:    0.7.0.1
 */