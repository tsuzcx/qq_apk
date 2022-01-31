package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.f.c;
import com.tencent.mm.g.a.t;
import com.tencent.mm.g.a.t.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class f$5
  implements com.tencent.mm.audio.mix.f.b
{
  f$5(f paramf) {}
  
  public final void b(t paramt)
  {
    AppMethodBeat.i(137274);
    a.ymk.a(paramt, Looper.getMainLooper());
    AppMethodBeat.o(137274);
  }
  
  public final void c(t paramt)
  {
    AppMethodBeat.i(137275);
    a.ymk.a(paramt, Looper.getMainLooper());
    AppMethodBeat.o(137275);
  }
  
  public final void d(t paramt)
  {
    AppMethodBeat.i(137276);
    a.ymk.a(paramt, Looper.getMainLooper());
    AppMethodBeat.o(137276);
  }
  
  public final void e(t paramt)
  {
    AppMethodBeat.i(137277);
    a.ymk.a(paramt, Looper.getMainLooper());
    AppMethodBeat.o(137277);
  }
  
  public final void f(t paramt)
  {
    AppMethodBeat.i(137278);
    a.ymk.a(paramt, Looper.getMainLooper());
    AppMethodBeat.o(137278);
  }
  
  public final void g(t paramt)
  {
    AppMethodBeat.i(137279);
    a.ymk.a(paramt, Looper.getMainLooper());
    AppMethodBeat.o(137279);
  }
  
  public final void h(t paramt)
  {
    AppMethodBeat.i(137280);
    a.ymk.a(paramt, Looper.getMainLooper());
    AppMethodBeat.o(137280);
  }
  
  public final void i(t paramt)
  {
    AppMethodBeat.i(137281);
    a.ymk.a(paramt, Looper.getMainLooper());
    AppMethodBeat.o(137281);
  }
  
  public final void j(t paramt)
  {
    AppMethodBeat.i(137282);
    int i = paramt.cmZ.errCode;
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", new Object[] { Integer.valueOf(i) });
    if ((i == 709) || (i == 702) || (i == 703) || (i == 705) || (i == 706)) {
      ab.e("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
    }
    while (this.oXg.oWV != null)
    {
      com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.oXg.oWM.get(paramt.cmZ.ceu);
      if (localb == null)
      {
        AppMethodBeat.o(137282);
        return;
        a.ymk.a(paramt, Looper.getMainLooper());
      }
      else
      {
        this.oXg.oWV.zR(paramt.cmZ.errCode);
        if (!this.oXg.oWZ.eA(localb.filePath))
        {
          if (this.oXg.oWY.containsKey(localb.filePath))
          {
            i = ((Integer)this.oXg.oWY.get(localb.filePath)).intValue();
            this.oXg.oWY.put(localb.filePath, Integer.valueOf(i + 1));
            AppMethodBeat.o(137282);
            return;
          }
          this.oXg.oWY.put(localb.filePath, Integer.valueOf(1));
        }
      }
    }
    AppMethodBeat.o(137282);
  }
  
  public final void k(t paramt)
  {
    AppMethodBeat.i(137283);
    if (this.oXg.oWV != null)
    {
      com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.oXg.oWM.get(paramt.cmZ.ceu);
      if (localb == null)
      {
        AppMethodBeat.o(137283);
        return;
      }
      if (localb.frd > 1000000L) {
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", new Object[] { localb.ceu, Long.valueOf(localb.frd) });
      }
      Object localObject = paramt.cmZ.cfG;
      paramt = (t)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramt = localb.cfG;
      }
      localObject = this.oXg.oWV;
      String str1 = localb.ceu;
      long l1 = System.currentTimeMillis();
      long l2 = localb.frb;
      long l3 = localb.frc;
      long l4 = localb.frd;
      String str2 = localb.filePath;
      long l5 = this.oXg.oWZ.ew(localb.ceu);
      long l6 = localb.fileSize;
      String str3 = localb.filePath;
      ((com.tencent.mm.plugin.music.b.a.d)localObject).a(str1, paramt, l1 - l2, l3, l4, false, str2, l5, l6, com.tencent.mm.audio.mix.b.d.De().dU(str3));
      if (this.oXg.oWY.containsKey(localb.filePath)) {
        this.oXg.oWY.remove(localb.filePath);
      }
    }
    AppMethodBeat.o(137283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f.5
 * JD-Core Version:    0.7.0.1
 */