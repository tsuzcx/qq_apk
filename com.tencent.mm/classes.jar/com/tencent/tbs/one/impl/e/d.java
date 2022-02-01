package com.tencent.tbs.one.impl.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.b;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.l;
import java.io.File;

public final class d
  extends b<e<com.tencent.tbs.one.impl.common.d>>
{
  private a<e<com.tencent.tbs.one.impl.common.d>> e;
  private File f;
  
  public d(a<e<com.tencent.tbs.one.impl.common.d>> parama, File paramFile)
  {
    super(com.tencent.tbs.one.impl.common.f.e(paramFile, ".lock"));
    AppMethodBeat.i(174108);
    this.e = parama;
    this.f = paramFile;
    AppMethodBeat.o(174108);
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(174111);
    File localFile = this.f;
    c.c(localFile);
    f.f(localFile);
    super.a(paramInt, paramString, paramThrowable);
    AppMethodBeat.o(174111);
  }
  
  public final void a(e<com.tencent.tbs.one.impl.common.d> parame)
  {
    AppMethodBeat.i(174112);
    f.f(this.f);
    super.a(parame);
    AppMethodBeat.o(174112);
  }
  
  public final void a(Exception paramException)
  {
    AppMethodBeat.i(174110);
    a(301, "Failed to wait for DEPS installation lock " + this.f, paramException);
    AppMethodBeat.o(174110);
  }
  
  public final void b()
  {
    AppMethodBeat.i(174113);
    super.b();
    this.e.b();
    AppMethodBeat.o(174113);
  }
  
  public final void c()
  {
    AppMethodBeat.i(174109);
    Object localObject = this.f;
    if (f.g((File)localObject))
    {
      if (((File)localObject).exists()) {
        try
        {
          localObject = com.tencent.tbs.one.impl.common.d.a((File)localObject);
          a(e.a(e.a.a, localObject));
          AppMethodBeat.o(174109);
          return;
        }
        catch (TBSOneException localTBSOneException)
        {
          a(localTBSOneException.getErrorCode(), localTBSOneException.getMessage(), localTBSOneException.getCause());
          AppMethodBeat.o(174109);
          return;
        }
      }
      f.e(localTBSOneException);
    }
    for (;;)
    {
      this.e.a(new l()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(174024);
          d.this.a(paramAnonymousInt2);
          AppMethodBeat.o(174024);
        }
        
        public final void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(174025);
          d.this.a(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
          AppMethodBeat.o(174025);
        }
      });
      AppMethodBeat.o(174109);
      return;
      if (localTBSOneException.exists()) {
        c.c(localTBSOneException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.d
 * JD-Core Version:    0.7.0.1
 */