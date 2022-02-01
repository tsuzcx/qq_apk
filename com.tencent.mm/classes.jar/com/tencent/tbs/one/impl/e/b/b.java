package com.tencent.tbs.one.impl.e.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import java.io.File;
import java.io.IOException;

public final class b
  extends a<e<d>>
{
  Context b;
  String c;
  File d;
  
  public b(Context paramContext, String paramString, File paramFile)
  {
    this.b = paramContext;
    this.c = paramString;
    this.d = paramFile;
  }
  
  public final void a()
  {
    AppMethodBeat.i(174067);
    m.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174069);
        localb = b.this;
        Object localObject2 = b.this.b;
        String str = b.this.c;
        Object localObject1 = b.this.d;
        localObject2 = f.a((Context)localObject2);
        try
        {
          c.a(f.c((File)localObject2, str), (File)localObject1);
          return;
        }
        catch (IOException localIOException)
        {
          try
          {
            localObject1 = d.a((File)localObject1);
            localb.a(e.a(e.a.b, localObject1));
            AppMethodBeat.o(174069);
            return;
          }
          catch (TBSOneException localTBSOneException)
          {
            localb.a(localTBSOneException.getErrorCode(), localTBSOneException.getMessage(), localTBSOneException.getCause());
            AppMethodBeat.o(174069);
          }
          localIOException = localIOException;
          localb.a(302, "Failed to copy builtin DEPS from " + ((File)localObject2).getAbsolutePath() + " to " + ((File)localObject1).getAbsolutePath(), localIOException);
          AppMethodBeat.o(174069);
          return;
        }
      }
    });
    AppMethodBeat.o(174067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.b.b
 * JD-Core Version:    0.7.0.1
 */