package com.tencent.tbs.one.impl.e.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class b
  extends com.tencent.tbs.one.impl.a.a<e<d>>
  implements a.a
{
  com.tencent.tbs.one.impl.d.a b;
  int c;
  private Context d;
  private String e;
  private String f;
  private File g;
  
  public b(Context paramContext, String paramString1, String paramString2, File paramFile)
  {
    this.d = paramContext;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramFile;
  }
  
  public final void a()
  {
    AppMethodBeat.i(174014);
    this.b = new com.tencent.tbs.one.impl.d.a(this.d, this.f);
    this.b.f = this;
    this.b.a(new l()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(174017);
        b.this.a(paramAnonymousInt2);
        AppMethodBeat.o(174017);
      }
      
      public final void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(174018);
        b.this.b = null;
        b.this.a(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
        AppMethodBeat.o(174018);
      }
    });
    AppMethodBeat.o(174014);
  }
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    AppMethodBeat.i(174016);
    Context localContext = this.d;
    String str1 = this.f;
    final String str2 = this.e;
    final File localFile = this.g;
    f.a("[%s] Receiving DEPS response: [%d] %s", new Object[] { str2, Integer.valueOf(paramInt), paramMap });
    if ((paramInt != 200) || (paramInputStream == null))
    {
      a(210, "Invalid DEPS response stream, url: " + str1 + ", statusCode: " + paramInt, null);
      AppMethodBeat.o(174016);
      return;
    }
    paramMap = com.tencent.tbs.one.impl.common.a.b(localContext, str2);
    if (paramMap != null)
    {
      paramInt = paramMap.shouldInterceptDEPSResponse(str2, null, paramInputStream, localFile, new TBSOneCallback()
      {
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(174004);
          b.this.c = 0;
          b.this.a(paramAnonymousInt, paramAnonymousString, null);
          AppMethodBeat.o(174004);
        }
        
        public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(174003);
          b.this.a(paramAnonymousInt2);
          AppMethodBeat.o(174003);
        }
      });
      if (paramInt != 0)
      {
        f.a("[%s] Intercepted DEPS download stream by runtime extension", new Object[] { str2 });
        this.c = paramInt;
        AppMethodBeat.o(174016);
        return;
      }
    }
    try
    {
      paramMap = d.a(c.a(paramInputStream, "utf-8", localFile));
      a(e.a(e.a.e, paramMap));
      AppMethodBeat.o(174016);
      return;
    }
    catch (IOException paramMap)
    {
      a(305, "Failed to download online DEPS from " + str1 + " to " + localFile.getAbsolutePath(), paramMap);
      AppMethodBeat.o(174016);
      return;
    }
    catch (TBSOneException paramMap)
    {
      a(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
      AppMethodBeat.o(174016);
    }
  }
  
  public final void b()
  {
    AppMethodBeat.i(174015);
    super.b();
    if (this.b != null) {
      this.b.b();
    }
    if (this.c != 0)
    {
      TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.b(this.d, this.e);
      if (localTBSOneRuntimeExtension != null) {
        localTBSOneRuntimeExtension.cancel(this.c);
      }
    }
    AppMethodBeat.o(174015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.c.b
 * JD-Core Version:    0.7.0.1
 */