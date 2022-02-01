package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.security.Key;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

final class ab$a
  implements h.b
{
  public final Key ac(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(176878);
    if (paramMap.get("account") == null)
    {
      AppMethodBeat.o(176878);
      return null;
    }
    Log.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(paramString)));
    if (MMApplicationContext.isMainProcess()) {
      h.aHE();
    }
    for (paramMap = b.aGq();; paramMap = new p(b.aGP()).toString())
    {
      paramString = new SecretKeySpec(g.V((paramMap + paramString).getBytes()), "RC4");
      AppMethodBeat.o(176878);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.vfs.ab.a
 * JD-Core Version:    0.7.0.1
 */