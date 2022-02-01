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

final class af$a
  implements k.b
{
  public final Key am(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(176878);
    if (paramMap.get("account") == null)
    {
      AppMethodBeat.o(176878);
      return null;
    }
    Log.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(paramString)));
    if (MMApplicationContext.isMainProcess()) {
      h.baC();
    }
    for (paramMap = b.aZs();; paramMap = new p(b.aZP()).toString())
    {
      paramString = new SecretKeySpec(g.U((paramMap + paramString).getBytes()), "RC4");
      AppMethodBeat.o(176878);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.af.a
 * JD-Core Version:    0.7.0.1
 */