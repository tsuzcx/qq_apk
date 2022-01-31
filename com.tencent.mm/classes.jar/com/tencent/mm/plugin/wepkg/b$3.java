package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

final class b$3
  implements Runnable
{
  b$3(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(63350);
    String str = this.vEx;
    HashSet localHashSet = new HashSet();
    if (!bo.isNullOrNil(str)) {
      localHashSet.add(str);
    }
    if (!bo.isNullOrNil(a.dkb())) {
      localHashSet.add(a.dkb());
    }
    WepkgVersionUpdater.a(localHashSet, 0, false);
    AppMethodBeat.o(63350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.3
 * JD-Core Version:    0.7.0.1
 */