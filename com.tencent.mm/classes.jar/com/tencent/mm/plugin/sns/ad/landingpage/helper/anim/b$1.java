package com.tencent.mm.plugin.sns.ad.landingpage.helper.anim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;

final class b$1
  implements g.a
{
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(310894);
    paramString = new StringBuilder("callback, mediaId=").append(paramString).append(", startRet=").append(paramInt).append(", retCode=");
    if (paramd == null) {}
    for (paramInt = -1;; paramInt = paramd.field_retCode)
    {
      Log.i("AdLandingPagePagFileHelper", paramInt + ", onlyCheckExist=" + paramBoolean);
      AppMethodBeat.o(310894);
      return 0;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.b.1
 * JD-Core Version:    0.7.0.1
 */