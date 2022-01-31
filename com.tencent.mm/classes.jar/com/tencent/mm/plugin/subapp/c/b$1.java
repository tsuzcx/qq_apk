package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$1
  implements ap.a
{
  b$1(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25250);
    Object localObject = this.sXc.fileName;
    localObject = d.cGT().adV((String)localObject);
    if ((localObject == null) || (!((g)localObject).amw()))
    {
      ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.sXc.fileName);
      this.sXc.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      this.sXc.callback.onSceneEnd(3, -1, "doScene failed", this.sXc);
      AppMethodBeat.o(25250);
      return false;
    }
    if ((3 != ((g)localObject).field_status) && (8 != ((g)localObject).field_status))
    {
      long l = System.currentTimeMillis();
      if (l / 1000L - ((g)localObject).field_lastmodifytime > 30L)
      {
        ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + this.sXc.fileName);
        this.sXc.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
        this.sXc.callback.onSceneEnd(3, -1, "doScene failed", this.sXc);
        AppMethodBeat.o(25250);
        return false;
      }
      if (l - this.sXc.fZz < 2000L)
      {
        ab.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + this.sXc.fileName + " but last send time:" + (l - this.sXc.fZz));
        AppMethodBeat.o(25250);
        return true;
      }
      c.a locala = h.adS(this.sXc.fileName).Gl(((g)localObject).field_offset);
      ab.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + this.sXc.fileName + " readByte:" + locala.ckj + " stat:" + ((g)localObject).field_status);
      if (locala.ckj < 2000)
      {
        AppMethodBeat.o(25250);
        return true;
      }
    }
    if (this.sXc.doScene(this.sXc.dispatcher(), this.sXc.callback) == -1)
    {
      this.sXc.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      this.sXc.callback.onSceneEnd(3, -1, "doScene failed", this.sXc);
    }
    AppMethodBeat.o(25250);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.b.1
 * JD-Core Version:    0.7.0.1
 */