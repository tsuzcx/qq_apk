package com.tencent.mm.plugin.transvoice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.modelvoiceaddr.a;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.am.h
{
  private static final String pfs;
  private com.tencent.mm.modelvoiceaddr.h TTT;
  private int TTV;
  public boolean TTW = false;
  public boolean TTX = false;
  public a pfC = null;
  private g.b pfP;
  
  static
  {
    AppMethodBeat.i(102631);
    pfs = at.acHq + "voice_temp.silk";
    AppMethodBeat.o(102631);
  }
  
  public b(com.tencent.mm.modelvoiceaddr.h paramh, int paramInt, g.b paramb)
  {
    this.TTT = paramh;
    this.TTV = paramInt;
    this.pfP = paramb;
  }
  
  private void w(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185263);
    Log.i("MicroMsg.SceneVoiceInputAddr2", "reset continuable = %s, sendLastScene = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.TTX = true;
      AppMethodBeat.o(185263);
      return;
    }
    this.TTX = false;
    if ((this.pfC instanceof com.tencent.mm.modelvoiceaddr.c)) {
      this.pfC.bPq();
    }
    if ((this.pfC instanceof com.tencent.mm.modelvoiceaddr.c))
    {
      Log.i("MicroMsg.SceneVoiceInputAddr2", "reset call stop, sendLastScene: %s.", new Object[] { Boolean.valueOf(paramBoolean2) });
      if (paramBoolean2) {
        ((com.tencent.mm.modelvoiceaddr.c)this.pfC).bPw();
      }
      com.tencent.mm.kernel.h.aZW().b(235, this);
    }
    this.pfC = null;
    this.pfP = null;
    AppMethodBeat.o(185263);
  }
  
  public final void bj(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(185262);
    Log.i("MicroMsg.SceneVoiceInputAddr2", "continuable: %s, cancel fromUI = %s.", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    w(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(185262);
  }
  
  public final void hPC()
  {
    AppMethodBeat.i(185261);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185260);
        Log.i("MicroMsg.SceneVoiceInputAddr2", "error localCode = %s, errType = %s, errCode = %s.", new Object[] { Integer.valueOf(this.TTY), Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode) });
        if (b.a(b.this) != null) {
          b.a(b.this).c(this.TTY, this.val$errType, this.val$errCode, -1L);
        }
        b.b(b.this);
        AppMethodBeat.o(185260);
      }
    });
    AppMethodBeat.o(185261);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(102628);
    String[] arrayOfString = ((a)paramp).bPr();
    ((a)paramp).bPs();
    List localList = ((a)paramp).bPu();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramp.hashCode();
      if (this.pfC != null) {
        break label165;
      }
    }
    label165:
    for (int j = -1;; j = this.pfC.hashCode())
    {
      Log.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd time: %s errType: %s errCode: %s list: %s scene.hashCode(): %s this.hashCode(): %s.", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.pfC != null) && (paramp.hashCode() == this.pfC.hashCode())) {
        break label177;
      }
      Log.d("MicroMsg.SceneVoiceInputAddr2", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(102628);
      return;
      i = arrayOfString.length;
      break;
    }
    label177:
    if (this.pfP != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.pfP.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          bj(false, false);
          AppMethodBeat.o(102628);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.pfP.c(13, 133, -1, -1L);
          } else {
            this.pfP.c(11, paramInt1, paramInt2, ((a)paramp).bPt());
          }
        }
      }
      this.pfP.b(arrayOfString, localList);
      if (((paramp instanceof com.tencent.mm.modelvoiceaddr.c)) && (((com.tencent.mm.modelvoiceaddr.c)paramp).pfc.bPF()))
      {
        this.pfP.bPD();
        bj(this.TTW, false);
      }
    }
    AppMethodBeat.o(102628);
  }
  
  public final void start()
  {
    AppMethodBeat.i(102627);
    Log.i("MicroMsg.SceneVoiceInputAddr2", "start trans, time: %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.storage.c localc = com.tencent.mm.model.newabtest.d.bEt().Fd("100235");
    if ((localc != null) && (localc.isValid())) {}
    for (int i = Util.getInt((String)localc.iWZ().get("MMVoipVadOn"), 0);; i = 0)
    {
      this.pfC = new com.tencent.mm.modelvoiceaddr.c(pfs, this.TTT, String.valueOf(i), this.TTV);
      com.tencent.mm.kernel.h.aZW().a(235, this);
      if ((!((com.tencent.mm.modelvoiceaddr.c)this.pfC).bPv()) || (!com.tencent.mm.kernel.h.aZW().a(this.pfC, 0))) {
        hPC();
      }
      AppMethodBeat.o(102627);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.model.b
 * JD-Core Version:    0.7.0.1
 */