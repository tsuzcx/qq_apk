package com.tencent.mm.plugin.transvoice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.a;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al;
import java.util.List;
import java.util.Map;

public final class b
  implements f
{
  private static final String ixV;
  private int BBA;
  public boolean BBB = false;
  public boolean BBC = false;
  private h BBy;
  public a iyf = null;
  private g.b iys;
  
  static
  {
    AppMethodBeat.i(102631);
    ixV = al.IpN + "voice_temp.silk";
    AppMethodBeat.o(102631);
  }
  
  public b(h paramh, int paramInt, g.b paramb)
  {
    this.BBy = paramh;
    this.BBA = paramInt;
    this.iys = paramb;
  }
  
  private void n(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185263);
    ad.i("MicroMsg.SceneVoiceInputAddr2", "reset continuable = %s, sendLastScene = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.BBC = true;
      AppMethodBeat.o(185263);
      return;
    }
    this.BBC = false;
    if ((this.iyf instanceof com.tencent.mm.modelvoiceaddr.c)) {
      this.iyf.aNH();
    }
    if ((this.iyf instanceof com.tencent.mm.modelvoiceaddr.c))
    {
      ad.i("MicroMsg.SceneVoiceInputAddr2", "reset call stop, sendLastScene: %s.", new Object[] { Boolean.valueOf(paramBoolean2) });
      if (paramBoolean2) {
        ((com.tencent.mm.modelvoiceaddr.c)this.iyf).aNN();
      }
      g.aiU().b(235, this);
    }
    this.iyf = null;
    this.iys = null;
    AppMethodBeat.o(185263);
  }
  
  public final void ar(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185262);
    ad.i("MicroMsg.SceneVoiceInputAddr2", "continuable: %s, cancel fromUI = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    n(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(185262);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(102629);
    ar(false, paramBoolean);
    AppMethodBeat.o(102629);
  }
  
  public final void ert()
  {
    AppMethodBeat.i(185261);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185260);
        ad.i("MicroMsg.SceneVoiceInputAddr2", "error localCode = %s, errType = %s, errCode = %s.", new Object[] { Integer.valueOf(this.BBD), Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode) });
        if (b.a(b.this) != null) {
          b.a(b.this).c(this.BBD, this.val$errType, this.val$errCode, -1L);
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
    String[] arrayOfString = ((a)paramn).aNI();
    List localList = ((a)paramn).aNL();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramn.hashCode();
      if (this.iyf != null) {
        break label156;
      }
    }
    label156:
    for (int j = -1;; j = this.iyf.hashCode())
    {
      ad.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd time: %s errType: %s errCode: %s list: %s scene.hashCode(): %s this.hashCode(): %s.", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.iyf != null) && (paramn.hashCode() == this.iyf.hashCode())) {
        break label168;
      }
      ad.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(102628);
      return;
      i = arrayOfString.length;
      break;
    }
    label168:
    if (this.iys != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.iys.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          ar(false, false);
          AppMethodBeat.o(102628);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.iys.c(13, 133, -1, -1L);
          } else {
            this.iys.c(11, paramInt1, paramInt2, ((a)paramn).aNK());
          }
        }
      }
      this.iys.b(arrayOfString, localList);
      if (((paramn instanceof com.tencent.mm.modelvoiceaddr.c)) && (((com.tencent.mm.modelvoiceaddr.c)paramn).ixF.aNW()))
      {
        this.iys.aNU();
        ar(this.BBB, false);
      }
    }
    AppMethodBeat.o(102628);
  }
  
  public final void start()
  {
    AppMethodBeat.i(102627);
    ad.i("MicroMsg.SceneVoiceInputAddr2", "start trans, time: %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100235");
    if (localc.isValid()) {}
    for (int i = bt.getInt((String)localc.foF().get("MMVoipVadOn"), 0);; i = 0)
    {
      this.iyf = new com.tencent.mm.modelvoiceaddr.c(ixV, this.BBy, String.valueOf(i), this.BBA);
      g.aiU().a(235, this);
      if ((!((com.tencent.mm.modelvoiceaddr.c)this.iyf).aNM()) || (!g.aiU().a(this.iyf, 0))) {
        ert();
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