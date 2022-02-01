package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;

final class b$1
  implements g.a
{
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(269615);
    paramString = new StringBuilder("callback, mediaId=").append(paramString).append(", startRet=").append(paramInt).append(", retCode=");
    if (paramd == null) {}
    for (paramInt = -1;; paramInt = paramd.field_retCode)
    {
      Log.i("AdLandingPagePagFileHelper", paramInt + ", onlyCheckExist=" + paramBoolean);
      AppMethodBeat.o(269615);
      return 0;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b.1
 * JD-Core Version:    0.7.0.1
 */