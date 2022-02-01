package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class e
{
  public static void a(final String paramString1, String paramString2, String paramString3, final int paramInt, f.a parama)
  {
    AppMethodBeat.i(270675);
    final String str = paramString2 + paramString3;
    if (!Util.isNullOrNil(str))
    {
      if (u.agG(str))
      {
        Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", new Object[] { str });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97307);
            this.JLs.aYs(str);
            AppMethodBeat.o(97307);
          }
        });
        AppMethodBeat.o(270675);
        return;
      }
      new d(paramString1, paramString2, paramString3, paramInt, new d.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(97311);
          Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", new Object[] { paramString1, paramAnonymousString });
          this.JLs.aYs(str);
          if (paramInt == 0) {
            m.b(0, 1, 1, paramString1);
          }
          AppMethodBeat.o(97311);
        }
        
        public final void fJV()
        {
          AppMethodBeat.i(97310);
          Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", new Object[] { paramString1 });
          this.JLs.fJV();
          if (paramInt == 0) {
            m.b(1, 1, 1, paramString1);
          }
          AppMethodBeat.o(97310);
        }
      }).execute(new Void[0]);
    }
    AppMethodBeat.o(270675);
  }
  
  public static void a(final String paramString1, final String paramString2, boolean paramBoolean, final int paramInt1, int paramInt2, f.a parama)
  {
    AppMethodBeat.i(270674);
    if (!Util.isNullOrNil(paramString2))
    {
      if (u.agG(paramString2))
      {
        Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", new Object[] { paramString2 });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97291);
            if (this.JLs != null) {
              this.JLs.aYs(paramString2);
            }
            AppMethodBeat.o(97291);
          }
        });
        AppMethodBeat.o(270674);
        return;
      }
      new f(paramString1, paramString2, paramBoolean, paramInt1, 0, new f.a()
      {
        public final void aYs(final String paramAnonymousString)
        {
          AppMethodBeat.i(97297);
          Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", new Object[] { paramString1 });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97294);
              if (e.2.this.JLs != null) {
                e.2.this.JLs.aYs(paramAnonymousString);
              }
              AppMethodBeat.o(97294);
            }
          });
          if (paramInt1 == 41) {
            m.b(0, 0, 0, paramString1);
          }
          AppMethodBeat.o(97297);
        }
        
        public final void fJU()
        {
          AppMethodBeat.i(97295);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97292);
              if (e.2.this.JLs != null) {
                e.2.this.JLs.fJU();
              }
              AppMethodBeat.o(97292);
            }
          });
          AppMethodBeat.o(97295);
        }
        
        public final void fJV()
        {
          AppMethodBeat.i(97296);
          Log.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", new Object[] { paramString1 });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(97293);
              if (e.2.this.JLs != null) {
                e.2.this.JLs.fJV();
              }
              AppMethodBeat.o(97293);
            }
          });
          if (paramInt1 == 41) {
            m.b(1, 0, 0, paramString1);
          }
          AppMethodBeat.o(97296);
        }
      }).execute(new Void[0]);
      AppMethodBeat.o(270674);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97298);
        if (this.JLs != null) {
          this.JLs.fJV();
        }
        AppMethodBeat.o(97298);
      }
    });
    AppMethodBeat.o(270674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e
 * JD-Core Version:    0.7.0.1
 */