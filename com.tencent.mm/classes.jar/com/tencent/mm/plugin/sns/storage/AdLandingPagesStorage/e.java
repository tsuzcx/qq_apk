package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class e
{
  public static void a(final String paramString1, String paramString2, String paramString3, final int paramInt, f.a parama)
  {
    AppMethodBeat.i(203154);
    final String str = paramString2 + paramString3;
    if (!Util.isNullOrNil(str))
    {
      if (s.YS(str))
      {
        Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", new Object[] { str });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97307);
            this.EkX.aNH(str);
            AppMethodBeat.o(97307);
          }
        });
        AppMethodBeat.o(203154);
        return;
      }
      new d(paramString1, paramString2, paramString3, paramInt, new d.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(97311);
          Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", new Object[] { paramString1, paramAnonymousString });
          this.EkX.aNH(str);
          if (paramInt == 0) {
            k.c(0, 1, 1, paramString1);
          }
          AppMethodBeat.o(97311);
        }
        
        public final void eWO()
        {
          AppMethodBeat.i(97310);
          Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", new Object[] { paramString1 });
          this.EkX.eWO();
          if (paramInt == 0) {
            k.c(1, 1, 1, paramString1);
          }
          AppMethodBeat.o(97310);
        }
      }).execute(new Void[0]);
    }
    AppMethodBeat.o(203154);
  }
  
  public static void a(final String paramString1, final String paramString2, boolean paramBoolean, final int paramInt1, int paramInt2, f.a parama)
  {
    AppMethodBeat.i(203153);
    if (!Util.isNullOrNil(paramString2))
    {
      if (s.YS(paramString2))
      {
        Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", new Object[] { paramString2 });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97291);
            this.EkX.aNH(paramString2);
            AppMethodBeat.o(97291);
          }
        });
        AppMethodBeat.o(203153);
        return;
      }
      new f(paramString1, paramString2, paramBoolean, paramInt1, paramInt2, new f.a()
      {
        public final void aNH(final String paramAnonymousString)
        {
          AppMethodBeat.i(97297);
          Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", new Object[] { paramString1 });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97294);
              e.2.this.EkX.aNH(paramAnonymousString);
              AppMethodBeat.o(97294);
            }
          });
          if (paramInt1 == 41) {
            k.c(0, 0, 0, paramString1);
          }
          AppMethodBeat.o(97297);
        }
        
        public final void eWN()
        {
          AppMethodBeat.i(97295);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97292);
              e.2.this.EkX.eWN();
              AppMethodBeat.o(97292);
            }
          });
          AppMethodBeat.o(97295);
        }
        
        public final void eWO()
        {
          AppMethodBeat.i(97296);
          Log.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", new Object[] { paramString1 });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97293);
              e.2.this.EkX.eWO();
              AppMethodBeat.o(97293);
            }
          });
          if (paramInt1 == 41) {
            k.c(1, 0, 0, paramString1);
          }
          AppMethodBeat.o(97296);
        }
      }).execute(new Void[0]);
      AppMethodBeat.o(203153);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97298);
        this.EkX.eWO();
        AppMethodBeat.o(97298);
      }
    });
    AppMethodBeat.o(203153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e
 * JD-Core Version:    0.7.0.1
 */