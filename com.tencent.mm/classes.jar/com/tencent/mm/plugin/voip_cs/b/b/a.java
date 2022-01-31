package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  private ak nOd;
  private boolean nOe;
  boolean nOf;
  public com.tencent.mm.plugin.voip_cs.b.a tLy;
  public a.a tLz;
  
  public a()
  {
    AppMethodBeat.i(135368);
    this.nOe = false;
    this.nOf = false;
    this.tLz = null;
    this.nOd = new a.1(this, Looper.getMainLooper());
    this.tLy = new com.tencent.mm.plugin.voip_cs.b.a(this.nOd);
    AppMethodBeat.o(135368);
  }
  
  public static int aeO(String paramString)
  {
    AppMethodBeat.i(135370);
    paramString = paramString.split("\\.");
    int i = bo.getInt(paramString[0], 0);
    int j = bo.getInt(paramString[1], 0);
    int k = bo.getInt(paramString[2], 0);
    int m = bo.getInt(paramString[3], 0);
    AppMethodBeat.o(135370);
    return m + ((i << 24) + (j << 16) + (k << 8));
  }
  
  public final void init()
  {
    AppMethodBeat.i(135369);
    this.nOf = false;
    this.nOe = false;
    if (this.tLy.cOG())
    {
      ab.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
      this.tLy.mX(false);
      this.tLy.reset();
    }
    this.tLy.tAa = 1;
    long l = System.currentTimeMillis();
    int i = this.tLy.cQk();
    ab.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    if (i < 0) {
      ab.e("MicroMsg.VoipCSEngine", "engine init failed!");
    }
    AppMethodBeat.o(135369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.b.a
 * JD-Core Version:    0.7.0.1
 */