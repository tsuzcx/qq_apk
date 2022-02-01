package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class e
{
  public static void a(final String paramString1, String paramString2, String paramString3, int paramInt, f.a parama)
  {
    AppMethodBeat.i(200314);
    final String str = paramString2 + paramString3;
    if (!bs.isNullOrNil(str))
    {
      if (i.eA(str))
      {
        ac.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", new Object[] { str });
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97307);
            this.yun.asD(str);
            AppMethodBeat.o(97307);
          }
        });
        AppMethodBeat.o(200314);
        return;
      }
      new d(paramString1, paramString2, paramString3, paramInt, new d.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(97311);
          ac.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", new Object[] { paramString1, paramAnonymousString });
          this.yun.asD(str);
          AppMethodBeat.o(97311);
        }
        
        public final void dFD()
        {
          AppMethodBeat.i(97310);
          ac.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", new Object[] { paramString1 });
          this.yun.dFD();
          AppMethodBeat.o(97310);
        }
      }).execute(new Void[0]);
    }
    AppMethodBeat.o(200314);
  }
  
  public static void a(final String paramString1, final String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97312);
    if (!bs.isNullOrNil(paramString2))
    {
      if (i.eA(paramString2))
      {
        ac.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", new Object[] { paramString2 });
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97291);
            this.yun.asD(paramString2);
            AppMethodBeat.o(97291);
          }
        });
        AppMethodBeat.o(97312);
        return;
      }
      new f(paramString1, paramString2, paramBoolean, paramInt, 0, new f.a()
      {
        public final void asD(final String paramAnonymousString)
        {
          AppMethodBeat.i(97297);
          ac.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", new Object[] { paramString1 });
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97294);
              e.2.this.yun.asD(paramAnonymousString);
              AppMethodBeat.o(97294);
            }
          });
          AppMethodBeat.o(97297);
        }
        
        public final void dFC()
        {
          AppMethodBeat.i(97295);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97292);
              e.2.this.yun.dFC();
              AppMethodBeat.o(97292);
            }
          });
          AppMethodBeat.o(97295);
        }
        
        public final void dFD()
        {
          AppMethodBeat.i(97296);
          ac.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", new Object[] { paramString1 });
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97293);
              e.2.this.yun.dFD();
              AppMethodBeat.o(97293);
            }
          });
          AppMethodBeat.o(97296);
        }
      }).execute(new Void[0]);
      AppMethodBeat.o(97312);
      return;
    }
    ap.f(new e.3(parama));
    AppMethodBeat.o(97312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e
 * JD-Core Version:    0.7.0.1
 */