package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.d;
import j.d.a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.c.j;

final class w
  implements e
{
  final u ajNB;
  final j ajNC;
  final d ajND;
  private o ajNE;
  final x ajNF;
  final boolean ajNG;
  private boolean ajNH;
  
  private w(u paramu, x paramx, boolean paramBoolean)
  {
    AppMethodBeat.i(186693);
    this.ajNB = paramu;
    this.ajNF = paramx;
    this.ajNG = paramBoolean;
    this.ajNC = new j(paramu, paramBoolean);
    this.ajND = new d()
    {
      public final void kHd()
      {
        AppMethodBeat.i(186715);
        w.this.cancel();
        AppMethodBeat.o(186715);
      }
    };
    this.ajND.b(paramu.ajNr, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(186693);
  }
  
  static w a(u paramu, x paramx, boolean paramBoolean)
  {
    AppMethodBeat.i(186700);
    paramx = new w(paramu, paramx, paramBoolean);
    paramx.ajNE = paramu.ajNj.kGK();
    AppMethodBeat.o(186700);
    return paramx;
  }
  
  private void kHa()
  {
    AppMethodBeat.i(186710);
    Object localObject = okhttp3.internal.g.g.kIq().bKK("response.body().close()");
    this.ajNC.ajPC = localObject;
    AppMethodBeat.o(186710);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(186777);
    try
    {
      if (this.ajNH)
      {
        paramf = new IllegalStateException("Already Executed");
        AppMethodBeat.o(186777);
        throw paramf;
      }
    }
    finally
    {
      AppMethodBeat.o(186777);
    }
    this.ajNH = true;
    kHa();
    m localm = this.ajNB.ajNh;
    paramf = new a(paramf);
    try
    {
      localm.ajMI.add(paramf);
      localm.kGI();
      AppMethodBeat.o(186777);
      return;
    }
    finally
    {
      AppMethodBeat.o(186777);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(186788);
    ??? = this.ajNC;
    ((j)???).oLU = true;
    Object localObject3 = ((j)???).ajPO;
    if (localObject3 != null)
    {
      synchronized (((okhttp3.internal.b.g)localObject3).ajNn)
      {
        ((okhttp3.internal.b.g)localObject3).oLU = true;
        okhttp3.internal.c.c localc = ((okhttp3.internal.b.g)localObject3).ajPH;
        localObject3 = ((okhttp3.internal.b.g)localObject3).ajPF;
        if (localc != null)
        {
          localc.cancel();
          AppMethodBeat.o(186788);
          return;
        }
      }
      if (localObject3 != null) {
        okhttp3.internal.c.closeQuietly(((okhttp3.internal.b.c)localObject3).ajPl);
      }
    }
    AppMethodBeat.o(186788);
  }
  
  final IOException d(IOException paramIOException)
  {
    AppMethodBeat.i(186759);
    Object localObject = this.ajND;
    d.a locala = d.ajSX;
    if (!d.a.d((d)localObject))
    {
      AppMethodBeat.o(186759);
      return paramIOException;
    }
    localObject = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      ((InterruptedIOException)localObject).initCause(paramIOException);
    }
    AppMethodBeat.o(186759);
    return localObject;
  }
  
  public final boolean isCanceled()
  {
    return this.ajNC.oLU;
  }
  
  public final z kGD()
  {
    AppMethodBeat.i(186750);
    try
    {
      if (this.ajNH)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Already Executed");
        AppMethodBeat.o(186750);
        throw localIllegalStateException;
      }
    }
    finally
    {
      AppMethodBeat.o(186750);
    }
    this.ajNH = true;
    kHa();
    this.ajND.enter();
    try
    {
      this.ajNB.ajNh.a(this);
      Object localObject2 = kHc();
      if (localObject2 == null)
      {
        localObject2 = new IOException("Canceled");
        AppMethodBeat.o(186750);
        throw ((Throwable)localObject2);
      }
    }
    catch (IOException localIOException1)
    {
      IOException localIOException2 = d(localIOException1);
      AppMethodBeat.o(186750);
      throw localIOException2;
    }
    finally
    {
      this.ajNB.ajNh.b(this);
      AppMethodBeat.o(186750);
    }
    this.ajNB.ajNh.b(this);
    AppMethodBeat.o(186750);
    return localz;
  }
  
  final String kHb()
  {
    AppMethodBeat.i(186806);
    Object localObject = this.ajNF.ajIN.bKq("/...");
    ((r.a)localObject).ajMX = r.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
    ((r.a)localObject).ajMY = r.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
    localObject = ((r.a)localObject).kGU().toString();
    AppMethodBeat.o(186806);
    return localObject;
  }
  
  final z kHc()
  {
    AppMethodBeat.i(186821);
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.ajNB.interceptors);
    ((List)localObject).add(this.ajNC);
    ((List)localObject).add(new okhttp3.internal.c.a(this.ajNB.ajNk));
    ((List)localObject).add(new okhttp3.internal.a.a(this.ajNB.kGZ()));
    ((List)localObject).add(new okhttp3.internal.b.a(this.ajNB));
    if (!this.ajNG) {
      ((List)localObject).addAll(this.ajNB.ajNi);
    }
    ((List)localObject).add(new okhttp3.internal.c.b(this.ajNG));
    localObject = new okhttp3.internal.c.g((List)localObject, null, null, null, 0, this.ajNF, this, this.ajNE, this.ajNB.connectTimeout, this.ajNB.readTimeout, this.ajNB.ajNs).c(this.ajNF);
    if (this.ajNC.oLU)
    {
      okhttp3.internal.c.closeQuietly((Closeable)localObject);
      localObject = new IOException("Canceled");
      AppMethodBeat.o(186821);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(186821);
    return localObject;
  }
  
  final class a
    extends okhttp3.internal.b
  {
    final f ajNJ;
    
    static
    {
      AppMethodBeat.i(186588);
      if (!w.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(186588);
        return;
      }
    }
    
    a(f paramf)
    {
      super(new Object[] { w.this.kHb() });
      AppMethodBeat.i(186581);
      this.ajNJ = paramf;
      AppMethodBeat.o(186581);
    }
    
    public final void execute()
    {
      AppMethodBeat.i(186609);
      int j = 0;
      int i = 0;
      w.this.ajND.enter();
      for (;;)
      {
        try
        {
          z localz = w.this.kHc();
          j = 1;
          i = 1;
          this.ajNJ.a(w.this, localz);
          w.this.ajNB.ajNh.b(this);
          AppMethodBeat.o(186609);
          return;
        }
        catch (IOException localIOException1)
        {
          try
          {
            localIOException2 = w.this.d(localIOException1);
            if (i != 0)
            {
              okhttp3.internal.g.g localg = okhttp3.internal.g.g.kIq();
              StringBuilder localStringBuilder1 = new StringBuilder("Callback failure for ");
              w localw = w.this;
              StringBuilder localStringBuilder2 = new StringBuilder();
              String str1;
              if (localw.ajNC.oLU)
              {
                str1 = "canceled ";
                localStringBuilder2 = localStringBuilder2.append(str1);
                if (localw.ajNG)
                {
                  str1 = "web socket";
                  localg.g(4, localStringBuilder2.append(str1).append(" to ").append(localw.kHb()).toString(), localIOException2);
                }
              }
              else
              {
                str1 = "";
                continue;
              }
            }
            else
            {
              w.c(w.this);
              this.ajNJ.a(w.this, localIOException2);
              continue;
              localObject2 = finally;
            }
          }
          finally
          {
            w.this.ajNB.ajNh.b(this);
            AppMethodBeat.o(186609);
          }
        }
        finally
        {
          IOException localIOException2;
          w.this.cancel();
          if (j == 0)
          {
            localIOException2 = new IOException("canceled due to ".concat(String.valueOf(localObject2)));
            this.ajNJ.a(w.this, localIOException2);
          }
          AppMethodBeat.o(186609);
        }
        String str2 = "call";
      }
    }
    
    final String kHe()
    {
      return w.this.ajNF.ajIN.host;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.w
 * JD-Core Version:    0.7.0.1
 */