package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class e
{
  public static void a(final String paramString1, String paramString2, String paramString3, int paramInt, f.a parama)
  {
    AppMethodBeat.i(187509);
    final String str = paramString2 + paramString3;
    if (!bt.isNullOrNil(str))
    {
      if (i.eK(str))
      {
        ad.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", new Object[] { str });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97307);
            this.xhz.apm(str);
            AppMethodBeat.o(97307);
          }
        });
        AppMethodBeat.o(187509);
        return;
      }
      new d(paramString1, paramString2, paramString3, paramInt, new d.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(97311);
          ad.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", new Object[] { paramString1, paramAnonymousString });
          this.xhz.apm(str);
          AppMethodBeat.o(97311);
        }
        
        public final void dsA()
        {
          AppMethodBeat.i(97310);
          ad.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", new Object[] { paramString1 });
          this.xhz.dsA();
          AppMethodBeat.o(97310);
        }
      }).execute(new Void[0]);
    }
    AppMethodBeat.o(187509);
  }
  
  public static void a(final String paramString1, final String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97312);
    if (!bt.isNullOrNil(paramString2))
    {
      if (i.eK(paramString2))
      {
        ad.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", new Object[] { paramString2 });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97291);
            this.xhz.apm(paramString2);
            AppMethodBeat.o(97291);
          }
        });
        AppMethodBeat.o(97312);
        return;
      }
      new f(paramString1, paramString2, paramBoolean, paramInt, 0, new f.a()
      {
        public final void apm(final String paramAnonymousString)
        {
          AppMethodBeat.i(97297);
          ad.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", new Object[] { paramString1 });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97294);
              e.2.this.xhz.apm(paramAnonymousString);
              AppMethodBeat.o(97294);
            }
          });
          AppMethodBeat.o(97297);
        }
        
        public final void dsA()
        {
          AppMethodBeat.i(97296);
          ad.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", new Object[] { paramString1 });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97293);
              e.2.this.xhz.dsA();
              AppMethodBeat.o(97293);
            }
          });
          AppMethodBeat.o(97296);
        }
        
        public final void duP()
        {
          AppMethodBeat.i(97295);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97292);
              e.2.this.xhz.duP();
              AppMethodBeat.o(97292);
            }
          });
          AppMethodBeat.o(97295);
        }
      }).execute(new Void[0]);
      AppMethodBeat.o(97312);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97298);
        this.xhz.dsA();
        AppMethodBeat.o(97298);
      }
    });
    AppMethodBeat.o(97312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e
 * JD-Core Version:    0.7.0.1
 */