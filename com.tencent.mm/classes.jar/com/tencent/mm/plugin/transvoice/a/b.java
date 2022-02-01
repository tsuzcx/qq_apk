package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.a;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am;
import java.util.List;
import java.util.Map;

public final class b
  implements f
{
  private static final String iAO;
  private h BSW;
  private int BSY;
  public boolean BSZ = false;
  public boolean BTa = false;
  public a iAY = null;
  private g.b iBl;
  
  static
  {
    AppMethodBeat.i(102631);
    iAO = am.IKh + "voice_temp.silk";
    AppMethodBeat.o(102631);
  }
  
  public b(h paramh, int paramInt, g.b paramb)
  {
    this.BSW = paramh;
    this.BSY = paramInt;
    this.iBl = paramb;
  }
  
  private void n(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185263);
    ae.i("MicroMsg.SceneVoiceInputAddr2", "reset continuable = %s, sendLastScene = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.BTa = true;
      AppMethodBeat.o(185263);
      return;
    }
    this.BTa = false;
    if ((this.iAY instanceof com.tencent.mm.modelvoiceaddr.c)) {
      this.iAY.aOf();
    }
    if ((this.iAY instanceof com.tencent.mm.modelvoiceaddr.c))
    {
      ae.i("MicroMsg.SceneVoiceInputAddr2", "reset call stop, sendLastScene: %s.", new Object[] { Boolean.valueOf(paramBoolean2) });
      if (paramBoolean2) {
        ((com.tencent.mm.modelvoiceaddr.c)this.iAY).aOl();
      }
      g.ajj().b(235, this);
    }
    this.iAY = null;
    this.iBl = null;
    AppMethodBeat.o(185263);
  }
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185262);
    ae.i("MicroMsg.SceneVoiceInputAddr2", "continuable: %s, cancel fromUI = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    n(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(185262);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(102629);
    aq(false, paramBoolean);
    AppMethodBeat.o(102629);
  }
  
  public final void eva()
  {
    AppMethodBeat.i(185261);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185260);
        ae.i("MicroMsg.SceneVoiceInputAddr2", "error localCode = %s, errType = %s, errCode = %s.", new Object[] { Integer.valueOf(this.BTb), Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode) });
        if (b.a(b.this) != null) {
          b.a(b.this).c(this.BTb, this.val$errType, this.val$errCode, -1L);
        }
        b.b(b.this);
        AppMethodBeat.o(185260);
      }
    });
    AppMethodBeat.o(185261);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(102628);
    String[] arrayOfString = ((a)paramn).aOg();
    List localList = ((a)paramn).aOj();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramn.hashCode();
      if (this.iAY != null) {
        break label156;
      }
    }
    label156:
    for (int j = -1;; j = this.iAY.hashCode())
    {
      ae.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd time: %s errType: %s errCode: %s list: %s scene.hashCode(): %s this.hashCode(): %s.", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.iAY != null) && (paramn.hashCode() == this.iAY.hashCode())) {
        break label168;
      }
      ae.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(102628);
      return;
      i = arrayOfString.length;
      break;
    }
    label168:
    if (this.iBl != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.iBl.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          aq(false, false);
          AppMethodBeat.o(102628);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.iBl.c(13, 133, -1, -1L);
          } else {
            this.iBl.c(11, paramInt1, paramInt2, ((a)paramn).aOi());
          }
        }
      }
      this.iBl.b(arrayOfString, localList);
      if (((paramn instanceof com.tencent.mm.modelvoiceaddr.c)) && (((com.tencent.mm.modelvoiceaddr.c)paramn).iAy.aOu()))
      {
        this.iBl.aOs();
        aq(this.BSZ, false);
      }
    }
    AppMethodBeat.o(102628);
  }
  
  public final void start()
  {
    AppMethodBeat.i(102627);
    ae.i("MicroMsg.SceneVoiceInputAddr2", "start trans, time: %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100235");
    if (localc.isValid()) {}
    for (int i = bu.getInt((String)localc.fsy().get("MMVoipVadOn"), 0);; i = 0)
    {
      this.iAY = new com.tencent.mm.modelvoiceaddr.c(iAO, this.BSW, String.valueOf(i), this.BSY);
      g.ajj().a(235, this);
      if ((!((com.tencent.mm.modelvoiceaddr.c)this.iAY).aOk()) || (!g.ajj().a(this.iAY, 0))) {
        eva();
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