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
    AppMethodBeat.i(198108);
    final String str = paramString2 + paramString3;
    if (!bt.isNullOrNil(str))
    {
      if (i.fv(str))
      {
        ad.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", new Object[] { str });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97307);
            this.zLA.axG(str);
            AppMethodBeat.o(97307);
          }
        });
        AppMethodBeat.o(198108);
        return;
      }
      new d(paramString1, paramString2, paramString3, paramInt, new d.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(97311);
          ad.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", new Object[] { paramString1, paramAnonymousString });
          this.zLA.axG(str);
          AppMethodBeat.o(97311);
        }
        
        public final void dRX()
        {
          AppMethodBeat.i(97310);
          ad.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", new Object[] { paramString1 });
          this.zLA.dRX();
          AppMethodBeat.o(97310);
        }
      }).execute(new Void[0]);
    }
    AppMethodBeat.o(198108);
  }
  
  public static void a(final String paramString1, final String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97312);
    if (!bt.isNullOrNil(paramString2))
    {
      if (i.fv(paramString2))
      {
        ad.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", new Object[] { paramString2 });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97291);
            this.zLA.axG(paramString2);
            AppMethodBeat.o(97291);
          }
        });
        AppMethodBeat.o(97312);
        return;
      }
      new f(paramString1, paramString2, paramBoolean, paramInt, 0, new f.a()
      {
        public final void axG(final String paramAnonymousString)
        {
          AppMethodBeat.i(97297);
          ad.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", new Object[] { paramString1 });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97294);
              e.2.this.zLA.axG(paramAnonymousString);
              AppMethodBeat.o(97294);
            }
          });
          AppMethodBeat.o(97297);
        }
        
        public final void dRW()
        {
          AppMethodBeat.i(97295);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97292);
              e.2.this.zLA.dRW();
              AppMethodBeat.o(97292);
            }
          });
          AppMethodBeat.o(97295);
        }
        
        public final void dRX()
        {
          AppMethodBeat.i(97296);
          ad.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", new Object[] { paramString1 });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97293);
              e.2.this.zLA.dRX();
              AppMethodBeat.o(97293);
            }
          });
          AppMethodBeat.o(97296);
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
        this.zLA.dRX();
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