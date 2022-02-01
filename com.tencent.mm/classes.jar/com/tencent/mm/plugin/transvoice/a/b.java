package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.modelvoiceaddr.a;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.List;
import java.util.Map;

public final class b
  implements i
{
  private static final String mlG;
  private com.tencent.mm.modelvoiceaddr.h NgV;
  private int NgX;
  public boolean NgY = false;
  public boolean NgZ = false;
  public a mlQ = null;
  private g.b mmd;
  
  static
  {
    AppMethodBeat.i(102631);
    mlG = ar.Vgb + "voice_temp.silk";
    AppMethodBeat.o(102631);
  }
  
  public b(com.tencent.mm.modelvoiceaddr.h paramh, int paramInt, g.b paramb)
  {
    this.NgV = paramh;
    this.NgX = paramInt;
    this.mmd = paramb;
  }
  
  private void r(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185263);
    Log.i("MicroMsg.SceneVoiceInputAddr2", "reset continuable = %s, sendLastScene = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.NgZ = true;
      AppMethodBeat.o(185263);
      return;
    }
    this.NgZ = false;
    if ((this.mlQ instanceof com.tencent.mm.modelvoiceaddr.c)) {
      this.mlQ.brK();
    }
    if ((this.mlQ instanceof com.tencent.mm.modelvoiceaddr.c))
    {
      Log.i("MicroMsg.SceneVoiceInputAddr2", "reset call stop, sendLastScene: %s.", new Object[] { Boolean.valueOf(paramBoolean2) });
      if (paramBoolean2) {
        ((com.tencent.mm.modelvoiceaddr.c)this.mlQ).brQ();
      }
      com.tencent.mm.kernel.h.aGY().b(235, this);
    }
    this.mlQ = null;
    this.mmd = null;
    AppMethodBeat.o(185263);
  }
  
  public final void aM(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185262);
    Log.i("MicroMsg.SceneVoiceInputAddr2", "continuable: %s, cancel fromUI = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    r(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(185262);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(102629);
    aM(false, paramBoolean);
    AppMethodBeat.o(102629);
  }
  
  public final void gsu()
  {
    AppMethodBeat.i(185261);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185260);
        Log.i("MicroMsg.SceneVoiceInputAddr2", "error localCode = %s, errType = %s, errCode = %s.", new Object[] { Integer.valueOf(this.Nha), Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode) });
        if (b.a(b.this) != null) {
          b.a(b.this).c(this.Nha, this.val$errType, this.val$errCode, -1L);
        }
        b.b(b.this);
        AppMethodBeat.o(185260);
      }
    });
    AppMethodBeat.o(185261);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(102628);
    String[] arrayOfString = ((a)paramq).brL();
    ((a)paramq).brM();
    List localList = ((a)paramq).brO();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramq.hashCode();
      if (this.mlQ != null) {
        break label165;
      }
    }
    label165:
    for (int j = -1;; j = this.mlQ.hashCode())
    {
      Log.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd time: %s errType: %s errCode: %s list: %s scene.hashCode(): %s this.hashCode(): %s.", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.mlQ != null) && (paramq.hashCode() == this.mlQ.hashCode())) {
        break label177;
      }
      Log.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(102628);
      return;
      i = arrayOfString.length;
      break;
    }
    label177:
    if (this.mmd != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.mmd.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          aM(false, false);
          AppMethodBeat.o(102628);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.mmd.c(13, 133, -1, -1L);
          } else {
            this.mmd.c(11, paramInt1, paramInt2, ((a)paramq).brN());
          }
        }
      }
      this.mmd.b(arrayOfString, localList);
      if (((paramq instanceof com.tencent.mm.modelvoiceaddr.c)) && (((com.tencent.mm.modelvoiceaddr.c)paramq).mlq.brZ()))
      {
        this.mmd.brX();
        aM(this.NgY, false);
      }
    }
    AppMethodBeat.o(102628);
  }
  
  public final void start()
  {
    AppMethodBeat.i(102627);
    Log.i("MicroMsg.SceneVoiceInputAddr2", "start trans, time: %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.bgB().Mu("100235");
    if (localc.isValid()) {}
    for (int i = Util.getInt((String)localc.hvz().get("MMVoipVadOn"), 0);; i = 0)
    {
      this.mlQ = new com.tencent.mm.modelvoiceaddr.c(mlG, this.NgV, String.valueOf(i), this.NgX);
      com.tencent.mm.kernel.h.aGY().a(235, this);
      if ((!((com.tencent.mm.modelvoiceaddr.c)this.mlQ).brP()) || (!com.tencent.mm.kernel.h.aGY().a(this.mlQ, 0))) {
        gsu();
      }
      AppMethodBeat.o(102627);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.b
 * JD-Core Version:    0.7.0.1
 */