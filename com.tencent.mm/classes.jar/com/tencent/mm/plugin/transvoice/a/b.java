package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.a;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.List;
import java.util.Map;

public final class b
  implements i
{
  private static final String jwd;
  private h GtC;
  private int GtE;
  public boolean GtF = false;
  public boolean GtG = false;
  private g.b jwA;
  public a jwn = null;
  
  static
  {
    AppMethodBeat.i(102631);
    jwd = ar.NSe + "voice_temp.silk";
    AppMethodBeat.o(102631);
  }
  
  public b(h paramh, int paramInt, g.b paramb)
  {
    this.GtC = paramh;
    this.GtE = paramInt;
    this.jwA = paramb;
  }
  
  private void n(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185263);
    Log.i("MicroMsg.SceneVoiceInputAddr2", "reset continuable = %s, sendLastScene = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.GtG = true;
      AppMethodBeat.o(185263);
      return;
    }
    this.GtG = false;
    if ((this.jwn instanceof com.tencent.mm.modelvoiceaddr.c)) {
      this.jwn.bim();
    }
    if ((this.jwn instanceof com.tencent.mm.modelvoiceaddr.c))
    {
      Log.i("MicroMsg.SceneVoiceInputAddr2", "reset call stop, sendLastScene: %s.", new Object[] { Boolean.valueOf(paramBoolean2) });
      if (paramBoolean2) {
        ((com.tencent.mm.modelvoiceaddr.c)this.jwn).bis();
      }
      g.azz().b(235, this);
    }
    this.jwn = null;
    this.jwA = null;
    AppMethodBeat.o(185263);
  }
  
  public final void az(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185262);
    Log.i("MicroMsg.SceneVoiceInputAddr2", "continuable: %s, cancel fromUI = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    n(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(185262);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(102629);
    az(false, paramBoolean);
    AppMethodBeat.o(102629);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(185261);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185260);
        Log.i("MicroMsg.SceneVoiceInputAddr2", "error localCode = %s, errType = %s, errCode = %s.", new Object[] { Integer.valueOf(this.GtH), Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode) });
        if (b.a(b.this) != null) {
          b.a(b.this).c(this.GtH, this.val$errType, this.val$errCode, -1L);
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
    String[] arrayOfString = ((a)paramq).bin();
    List localList = ((a)paramq).biq();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramq.hashCode();
      if (this.jwn != null) {
        break label156;
      }
    }
    label156:
    for (int j = -1;; j = this.jwn.hashCode())
    {
      Log.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd time: %s errType: %s errCode: %s list: %s scene.hashCode(): %s this.hashCode(): %s.", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.jwn != null) && (paramq.hashCode() == this.jwn.hashCode())) {
        break label168;
      }
      Log.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(102628);
      return;
      i = arrayOfString.length;
      break;
    }
    label168:
    if (this.jwA != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.jwA.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          az(false, false);
          AppMethodBeat.o(102628);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.jwA.c(13, 133, -1, -1L);
          } else {
            this.jwA.c(11, paramInt1, paramInt2, ((a)paramq).bip());
          }
        }
      }
      this.jwA.b(arrayOfString, localList);
      if (((paramq instanceof com.tencent.mm.modelvoiceaddr.c)) && (((com.tencent.mm.modelvoiceaddr.c)paramq).jvN.biB()))
      {
        this.jwA.biz();
        az(this.GtF, false);
      }
    }
    AppMethodBeat.o(102628);
  }
  
  public final void start()
  {
    AppMethodBeat.i(102627);
    Log.i("MicroMsg.SceneVoiceInputAddr2", "start trans, time: %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu("100235");
    if (localc.isValid()) {}
    for (int i = Util.getInt((String)localc.gzz().get("MMVoipVadOn"), 0);; i = 0)
    {
      this.jwn = new com.tencent.mm.modelvoiceaddr.c(jwd, this.GtC, String.valueOf(i), this.GtE);
      g.azz().a(235, this);
      if ((!((com.tencent.mm.modelvoiceaddr.c)this.jwn).bir()) || (!g.azz().a(this.jwn, 0))) {
        fAt();
      }
      AppMethodBeat.o(102627);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.b
 * JD-Core Version:    0.7.0.1
 */