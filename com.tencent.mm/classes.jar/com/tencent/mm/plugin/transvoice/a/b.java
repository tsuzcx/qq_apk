package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelvoiceaddr.a;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.ak.g
{
  private static final String ieB;
  private h AjM;
  private int AjO;
  public boolean AjP = false;
  public boolean AjQ = false;
  public a ieL = null;
  private g.b ieY;
  
  static
  {
    AppMethodBeat.i(102631);
    ieB = ah.GDu + "voice_temp.silk";
    AppMethodBeat.o(102631);
  }
  
  public b(h paramh, int paramInt, g.b paramb)
  {
    this.AjM = paramh;
    this.AjO = paramInt;
    this.ieY = paramb;
  }
  
  private void n(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185263);
    ac.i("MicroMsg.SceneVoiceInputAddr2", "reset continuable = %s, sendLastScene = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.AjQ = true;
      AppMethodBeat.o(185263);
      return;
    }
    this.AjQ = false;
    if ((this.ieL instanceof com.tencent.mm.modelvoiceaddr.c)) {
      this.ieL.aKy();
    }
    if ((this.ieL instanceof com.tencent.mm.modelvoiceaddr.c))
    {
      ac.i("MicroMsg.SceneVoiceInputAddr2", "reset call stop, sendLastScene: %s.", new Object[] { Boolean.valueOf(paramBoolean2) });
      if (paramBoolean2) {
        ((com.tencent.mm.modelvoiceaddr.c)this.ieL).aKE();
      }
      com.tencent.mm.kernel.g.agi().b(235, this);
    }
    this.ieL = null;
    this.ieY = null;
    AppMethodBeat.o(185263);
  }
  
  public final void an(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185262);
    ac.i("MicroMsg.SceneVoiceInputAddr2", "continuable: %s, cancel fromUI = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    n(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(185262);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(102629);
    an(false, paramBoolean);
    AppMethodBeat.o(102629);
  }
  
  public final void efc()
  {
    AppMethodBeat.i(185261);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185260);
        ac.i("MicroMsg.SceneVoiceInputAddr2", "error localCode = %s, errType = %s, errCode = %s.", new Object[] { Integer.valueOf(this.AjR), Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode) });
        if (b.a(b.this) != null) {
          b.a(b.this).c(this.AjR, this.val$errType, this.val$errCode, -1L);
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
    String[] arrayOfString = ((a)paramn).aKz();
    List localList = ((a)paramn).aKC();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramn.hashCode();
      if (this.ieL != null) {
        break label156;
      }
    }
    label156:
    for (int j = -1;; j = this.ieL.hashCode())
    {
      ac.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd time: %s errType: %s errCode: %s list: %s scene.hashCode(): %s this.hashCode(): %s.", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.ieL != null) && (paramn.hashCode() == this.ieL.hashCode())) {
        break label168;
      }
      ac.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(102628);
      return;
      i = arrayOfString.length;
      break;
    }
    label168:
    if (this.ieY != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.ieY.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          an(false, false);
          AppMethodBeat.o(102628);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.ieY.c(13, 133, -1, -1L);
          } else {
            this.ieY.c(11, paramInt1, paramInt2, ((a)paramn).aKB());
          }
        }
      }
      this.ieY.b(arrayOfString, localList);
      if (((paramn instanceof com.tencent.mm.modelvoiceaddr.c)) && (((com.tencent.mm.modelvoiceaddr.c)paramn).iek.aKN()))
      {
        this.ieY.aKL();
        an(this.AjP, false);
      }
    }
    AppMethodBeat.o(102628);
  }
  
  public final void start()
  {
    AppMethodBeat.i(102627);
    ac.i("MicroMsg.SceneVoiceInputAddr2", "start trans, time: %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aAp().tJ("100235");
    if (localc.isValid()) {}
    for (int i = bs.getInt((String)localc.eYV().get("MMVoipVadOn"), 0);; i = 0)
    {
      this.ieL = new com.tencent.mm.modelvoiceaddr.c(ieB, this.AjM, String.valueOf(i), this.AjO);
      com.tencent.mm.kernel.g.agi().a(235, this);
      if ((!((com.tencent.mm.modelvoiceaddr.c)this.ieL).aKD()) || (!com.tencent.mm.kernel.g.agi().a(this.ieL, 0))) {
        efc();
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