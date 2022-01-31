package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;

public final class e
{
  public static boolean a(String paramString1, Context paramContext, MMFragment paramMMFragment, String paramString2)
  {
    AppMethodBeat.i(30456);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(30456);
      return false;
    }
    Object localObject = null;
    if (paramString1.startsWith("weixin://openNativeUrl/weixinHB")) {
      localObject = new e.a();
    }
    while ((localObject != null) && (((e.c)localObject).a(paramString1, paramContext, paramMMFragment, paramString2)))
    {
      AppMethodBeat.o(30456);
      return true;
      if (e.b.atJ(paramString1)) {
        localObject = new e.b();
      } else if (e.d.atJ(paramString1)) {
        localObject = new e.d();
      }
    }
    AppMethodBeat.o(30456);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e
 * JD-Core Version:    0.7.0.1
 */