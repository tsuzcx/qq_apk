package com.tencent.tbs.one.impl.e.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.k.a;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class a
  extends com.tencent.tbs.one.impl.a.a<e<File>>
  implements a.a
{
  int b;
  private Context c;
  private String d;
  private d.a e;
  private File f;
  private File g;
  private com.tencent.tbs.one.impl.d.a h;
  private long i;
  private Bundle j;
  
  public a(Context paramContext, String paramString, d.a parama, File paramFile, Bundle paramBundle)
  {
    AppMethodBeat.i(192449);
    this.i = -1L;
    this.c = paramContext;
    this.d = paramString;
    this.e = parama;
    this.f = paramFile;
    this.j = paramBundle;
    this.g = com.tencent.tbs.one.impl.common.f.a(this.c, this.c, paramString, parama.a, parama.c);
    AppMethodBeat.o(192449);
  }
  
  public final void a()
  {
    AppMethodBeat.i(174009);
    String str = this.e.d;
    this.h = new com.tencent.tbs.one.impl.d.a(this.c, str);
    this.h.f = this;
    this.h.a(new l()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(174012);
        a.this.a(paramAnonymousInt2);
        AppMethodBeat.o(174012);
      }
      
      public final void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(174013);
        a.this.a(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
        AppMethodBeat.o(174013);
      }
    });
    AppMethodBeat.o(174009);
  }
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    AppMethodBeat.i(174011);
    Context localContext = this.c;
    final String str1 = this.d;
    final String str2 = this.e.a;
    int k = this.e.c;
    String str3 = this.e.d;
    final File localFile2 = this.f;
    if ((this.g != null) && (!this.g.exists())) {
      this.g.mkdirs();
    }
    if (this.g == null) {}
    for (File localFile1 = null;; localFile1 = new File(this.g, this.e.a + ".tbs"))
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Receiving component response: [%d] %s", new Object[] { str1, str2, Integer.valueOf(paramInt), paramMap });
      if ((paramInt == 200) && (paramInputStream != null)) {
        break;
      }
      a(215, "Invalid component response stream, url: " + str3 + ", statusCode: " + paramInt, null);
      AppMethodBeat.o(174011);
      return;
    }
    paramMap = (List)paramMap.get("Content-Length");
    if ((paramMap != null) && (paramMap.size() > 0)) {}
    for (;;)
    {
      try
      {
        this.i = Long.parseLong((String)paramMap.get(0));
        paramMap = com.tencent.tbs.one.impl.common.a.b(localContext, str1);
        if (paramMap == null) {
          break;
        }
        paramInt = paramMap.shouldInterceptComponentResponse(str1, str2, k, null, paramInputStream, localFile2, new TBSOneCallback()
        {
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(174007);
            a.this.b = 0;
            a.this.a(paramAnonymousInt, paramAnonymousString, null);
            AppMethodBeat.o(174007);
          }
          
          public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(174006);
            a.this.a(paramAnonymousInt2);
            AppMethodBeat.o(174006);
          }
        });
        if (paramInt == 0) {
          break;
        }
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component download stream by runtime extension", new Object[] { str1, str2 });
        this.b = paramInt;
        AppMethodBeat.o(174011);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.tbs.one.impl.a.f.c("Failed to parse Content-Length header %s, url: %s", new Object[] { paramMap, str3, localException });
        continue;
      }
      com.tencent.tbs.one.impl.a.f.a("No Content-Length header exists, url: %s", new Object[] { str3 });
    }
    paramMap = this.e.e;
    long l = this.i;
    try
    {
      com.tencent.tbs.one.impl.e.f.a(paramInputStream, paramMap, l, localFile2, localFile1, new k.a()
      {
        public final void a(int paramAnonymousInt)
        {
          AppMethodBeat.i(174019);
          a.this.a(paramAnonymousInt);
          AppMethodBeat.o(174019);
        }
        
        public final boolean a()
        {
          return !a.this.a;
        }
      });
      com.tencent.tbs.one.impl.e.f.a(localFile2, localFile2);
      com.tencent.tbs.one.impl.e.f.a(localFile2, k);
      com.tencent.tbs.one.impl.e.f.a(this.c.getDir("tbs", 0));
      com.tencent.tbs.one.impl.e.f.b(localFile2);
      a(e.a(e.a.e, localFile2));
      AppMethodBeat.o(174011);
      return;
    }
    catch (TBSOneException paramMap)
    {
      a(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
      AppMethodBeat.o(174011);
    }
  }
  
  public final void b()
  {
    AppMethodBeat.i(174010);
    super.b();
    if (this.h != null) {
      this.h.b();
    }
    if (this.b != 0)
    {
      TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.b(this.c, this.d);
      if (localTBSOneRuntimeExtension != null) {
        localTBSOneRuntimeExtension.cancel(this.b);
      }
    }
    AppMethodBeat.o(174010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.c.a
 * JD-Core Version:    0.7.0.1
 */