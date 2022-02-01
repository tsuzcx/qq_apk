package com.tencent.tbs.one.impl.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.b;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d.a;
import java.io.File;

public final class c
  extends b<e<File>>
{
  private d.a e;
  private a<e<File>> f;
  private File g;
  
  public c(d.a parama, a<e<File>> parama1, File paramFile)
  {
    super(com.tencent.tbs.one.impl.common.f.e(paramFile, ".lock"));
    AppMethodBeat.i(173996);
    this.e = parama;
    this.f = parama1;
    this.g = paramFile;
    AppMethodBeat.o(173996);
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(173999);
    File localFile = this.g;
    com.tencent.tbs.one.impl.a.c.c(localFile);
    f.f(localFile);
    super.a(paramInt, paramString, paramThrowable);
    AppMethodBeat.o(173999);
  }
  
  public final void a(e<File> parame)
  {
    AppMethodBeat.i(174000);
    f.f(this.g);
    super.a(parame);
    AppMethodBeat.o(174000);
  }
  
  public final void a(Exception paramException)
  {
    AppMethodBeat.i(173998);
    a(311, "Failed to wait for component installation lock " + this.g, paramException);
    AppMethodBeat.o(173998);
  }
  
  public final void b()
  {
    AppMethodBeat.i(174001);
    super.b();
    this.f.b();
    AppMethodBeat.o(174001);
  }
  
  public final void c()
  {
    AppMethodBeat.i(173997);
    File localFile = this.g;
    if (f.g(localFile))
    {
      if (localFile.exists())
      {
        a(e.a(e.a.a, localFile));
        AppMethodBeat.o(173997);
        return;
      }
      f.e(localFile);
    }
    for (;;)
    {
      this.f.a(new l()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(174021);
          c.this.a(paramAnonymousInt2);
          AppMethodBeat.o(174021);
        }
        
        public final void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(174022);
          c.this.a(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
          AppMethodBeat.o(174022);
        }
      });
      AppMethodBeat.o(173997);
      return;
      if (localFile.exists()) {
        com.tencent.tbs.one.impl.a.c.c(localFile);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.c
 * JD-Core Version:    0.7.0.1
 */