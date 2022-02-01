package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class e
{
  public static void a(final String paramString1, String paramString2, String paramString3, int paramInt, f.a parama)
  {
    AppMethodBeat.i(219622);
    final String str = paramString2 + paramString3;
    if (!bu.isNullOrNil(str))
    {
      if (o.fB(str))
      {
        ae.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", new Object[] { str });
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97307);
            this.AcH.ayY(str);
            AppMethodBeat.o(97307);
          }
        });
        AppMethodBeat.o(219622);
        return;
      }
      new d(paramString1, paramString2, paramString3, paramInt, new d.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(97311);
          ae.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", new Object[] { paramString1, paramAnonymousString });
          this.AcH.ayY(str);
          AppMethodBeat.o(97311);
        }
        
        public final void dVv()
        {
          AppMethodBeat.i(97310);
          ae.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", new Object[] { paramString1 });
          this.AcH.dVv();
          AppMethodBeat.o(97310);
        }
      }).execute(new Void[0]);
    }
    AppMethodBeat.o(219622);
  }
  
  public static void a(final String paramString1, final String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97312);
    if (!bu.isNullOrNil(paramString2))
    {
      if (o.fB(paramString2))
      {
        ae.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", new Object[] { paramString2 });
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97291);
            this.AcH.ayY(paramString2);
            AppMethodBeat.o(97291);
          }
        });
        AppMethodBeat.o(97312);
        return;
      }
      new f(paramString1, paramString2, paramBoolean, paramInt, 0, new f.a()
      {
        public final void ayY(final String paramAnonymousString)
        {
          AppMethodBeat.i(97297);
          ae.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", new Object[] { paramString1 });
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97294);
              e.2.this.AcH.ayY(paramAnonymousString);
              AppMethodBeat.o(97294);
            }
          });
          AppMethodBeat.o(97297);
        }
        
        public final void dVu()
        {
          AppMethodBeat.i(97295);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97292);
              e.2.this.AcH.dVu();
              AppMethodBeat.o(97292);
            }
          });
          AppMethodBeat.o(97295);
        }
        
        public final void dVv()
        {
          AppMethodBeat.i(97296);
          ae.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", new Object[] { paramString1 });
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97293);
              e.2.this.AcH.dVv();
              AppMethodBeat.o(97293);
            }
          });
          AppMethodBeat.o(97296);
        }
      }).execute(new Void[0]);
      AppMethodBeat.o(97312);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97298);
        this.AcH.dVv();
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