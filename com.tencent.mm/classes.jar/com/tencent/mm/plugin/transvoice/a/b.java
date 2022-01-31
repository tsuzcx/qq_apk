package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.a;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.d;
import java.util.List;
import java.util.Map;

public final class b
  implements f
{
  private static final String gbo;
  private g.b gbE;
  private int gbb;
  private a gby = null;
  private h tph;
  
  static
  {
    AppMethodBeat.i(155204);
    gbo = ac.eQv + "voice_temp.silk";
    AppMethodBeat.o(155204);
  }
  
  public b(h paramh, int paramInt, g.b paramb)
  {
    this.tph = paramh;
    this.gbb = paramInt;
    this.gbE = paramb;
  }
  
  private void mF(boolean paramBoolean)
  {
    AppMethodBeat.i(155203);
    ab.i("MicroMsg.SceneVoiceInputAddr2", "reset keepNetScene = %s, sendLastScene = %s.", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean) });
    if ((this.gby instanceof com.tencent.mm.modelvoiceaddr.c)) {
      this.gby.amB();
    }
    if ((this.gby instanceof com.tencent.mm.modelvoiceaddr.c))
    {
      ab.i("MicroMsg.SceneVoiceInputAddr2", "reset call stop, sendLastScene: %s.", new Object[] { Boolean.valueOf(paramBoolean) });
      if (paramBoolean) {
        ((com.tencent.mm.modelvoiceaddr.c)this.gby).amH();
      }
      g.Rc().b(235, this);
    }
    this.gby = null;
    AppMethodBeat.o(155203);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(155202);
    ab.i("MicroMsg.SceneVoiceInputAddr2", "cancel fromUI = %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gbE = null;
    mF(paramBoolean);
    AppMethodBeat.o(155202);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(155201);
    String[] arrayOfString = ((a)paramm).amC();
    List localList = ((a)paramm).amF();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramm.hashCode();
      if (this.gby != null) {
        break label156;
      }
    }
    label156:
    for (int j = -1;; j = this.gby.hashCode())
    {
      ab.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd time: %s errType: %s errCode: %s list: %s scene.hashCode(): %s this.hashCode(): %s.", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.gby != null) && (paramm.hashCode() == this.gby.hashCode())) {
        break label168;
      }
      ab.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(155201);
      return;
      i = arrayOfString.length;
      break;
    }
    label168:
    if (this.gbE != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.gbE.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          cancel(false);
          AppMethodBeat.o(155201);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.gbE.c(13, 133, -1, -1L);
          } else {
            this.gbE.c(11, paramInt1, paramInt2, ((a)paramm).amE());
          }
        }
      }
      this.gbE.b(arrayOfString, localList);
      if (((paramm instanceof com.tencent.mm.modelvoiceaddr.c)) && (((com.tencent.mm.modelvoiceaddr.c)paramm).gaW.amQ()))
      {
        this.gbE.amO();
        cancel(false);
      }
    }
    AppMethodBeat.o(155201);
  }
  
  public final void start()
  {
    AppMethodBeat.i(155200);
    ab.i("MicroMsg.SceneVoiceInputAddr2", "start trans, time: %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100235");
    if (localc.isValid()) {}
    for (int i = bo.getInt((String)localc.dvN().get("MMVoipVadOn"), 0);; i = 0)
    {
      this.gby = new com.tencent.mm.modelvoiceaddr.c(gbo, this.tph, String.valueOf(i), this.gbb);
      g.Rc().a(235, this);
      if ((!((com.tencent.mm.modelvoiceaddr.c)this.gby).amG()) || (!g.Rc().a(this.gby, 0)))
      {
        ab.i("MicroMsg.SceneVoiceInputAddr2", "error localCode = %s, errType = %s, errCode = %s.", new Object[] { Integer.valueOf(13), Integer.valueOf(131), Integer.valueOf(-1) });
        if (this.gbE != null) {
          this.gbE.c(13, 131, -1, -1L);
        }
        mF(true);
      }
      AppMethodBeat.o(155200);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.b
 * JD-Core Version:    0.7.0.1
 */