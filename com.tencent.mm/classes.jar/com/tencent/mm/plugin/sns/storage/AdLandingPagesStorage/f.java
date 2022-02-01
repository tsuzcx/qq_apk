package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class f
{
  public static void a(final String paramString1, String paramString2, String paramString3, final int paramInt, g.a parama)
  {
    AppMethodBeat.i(306746);
    final String str = paramString2 + paramString3;
    if (!Util.isNullOrNil(str))
    {
      if (y.ZC(str))
      {
        Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", new Object[] { str });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97307);
            f.this.aWn(str);
            AppMethodBeat.o(97307);
          }
        });
        AppMethodBeat.o(306746);
        return;
      }
      new e(paramString1, paramString2, paramString3, paramInt, new e.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(97311);
          Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", new Object[] { paramString1, paramAnonymousString });
          f.this.aWn(str);
          if (paramInt == 0) {
            m.d(0, 1, 1, paramString1);
          }
          AppMethodBeat.o(97311);
        }
        
        public final void gZN()
        {
          AppMethodBeat.i(97310);
          Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", new Object[] { paramString1 });
          f.this.gZN();
          if (paramInt == 0) {
            m.d(1, 1, 1, paramString1);
          }
          AppMethodBeat.o(97310);
        }
      }).execute(new Void[0]);
    }
    AppMethodBeat.o(306746);
  }
  
  public static void a(final String paramString1, final String paramString2, boolean paramBoolean, final int paramInt1, int paramInt2, g.a parama)
  {
    AppMethodBeat.i(306740);
    if (!Util.isNullOrNil(paramString2))
    {
      if (y.ZC(paramString2))
      {
        Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", new Object[] { paramString2 });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97291);
            if (f.this != null) {
              f.this.aWn(paramString2);
            }
            AppMethodBeat.o(97291);
          }
        });
        AppMethodBeat.o(306740);
        return;
      }
      new g(paramString1, paramString2, paramBoolean, paramInt1, 0, new g.a()
      {
        public final void aWn(final String paramAnonymousString)
        {
          AppMethodBeat.i(97297);
          Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", new Object[] { paramString1 });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97294);
              if (f.this != null) {
                f.this.aWn(paramAnonymousString);
              }
              AppMethodBeat.o(97294);
            }
          });
          if (paramInt1 == 41) {
            m.d(0, 0, 0, paramString1);
          }
          AppMethodBeat.o(97297);
        }
        
        public final void gZM()
        {
          AppMethodBeat.i(97295);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97292);
              if (f.this != null) {
                f.this.gZM();
              }
              AppMethodBeat.o(97292);
            }
          });
          AppMethodBeat.o(97295);
        }
        
        public final void gZN()
        {
          AppMethodBeat.i(97296);
          Log.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", new Object[] { paramString1 });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97293);
              if (f.this != null) {
                f.this.gZN();
              }
              AppMethodBeat.o(97293);
            }
          });
          if (paramInt1 == 41) {
            m.d(1, 0, 0, paramString1);
          }
          AppMethodBeat.o(97296);
        }
      }).execute(new Void[0]);
      AppMethodBeat.o(306740);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97298);
        if (f.this != null) {
          f.this.gZN();
        }
        AppMethodBeat.o(97298);
      }
    });
    AppMethodBeat.o(306740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f
 * JD-Core Version:    0.7.0.1
 */