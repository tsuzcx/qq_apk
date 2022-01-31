package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
{
  public static void a(String paramString1, String paramString2, String paramString3, f.a parama)
  {
    AppMethodBeat.i(37716);
    String str = paramString2 + paramString3;
    if (!bo.isNullOrNil(str))
    {
      if (com.tencent.mm.vfs.e.cN(str))
      {
        ab.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", new Object[] { str });
        al.d(new e.7(parama, str));
        AppMethodBeat.o(37716);
        return;
      }
      new d(paramString1, paramString2, paramString3, new e.8(parama, paramString1, str)).execute(new Void[0]);
    }
    AppMethodBeat.o(37716);
  }
  
  public static void a(String paramString1, final String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(37715);
    if (!bo.isNullOrNil(paramString2))
    {
      if (com.tencent.mm.vfs.e.cN(paramString2))
      {
        ab.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", new Object[] { paramString2 });
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37694);
            this.rBW.abi(paramString2);
            AppMethodBeat.o(37694);
          }
        });
        AppMethodBeat.o(37715);
        return;
      }
      new f(paramString1, paramString2, paramBoolean, paramInt, 0, new e.2(parama, paramString1)).execute(new Void[0]);
      AppMethodBeat.o(37715);
      return;
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37701);
        this.rBW.coe();
        AppMethodBeat.o(37701);
      }
    });
    AppMethodBeat.o(37715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e
 * JD-Core Version:    0.7.0.1
 */