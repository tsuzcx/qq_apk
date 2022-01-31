package com.tencent.rtmp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

class b$b
  implements Runnable
{
  private WeakReference<b> a;
  private String b;
  private String c;
  
  public b$b(b paramb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65973);
    this.a = new WeakReference(paramb);
    this.b = paramString1;
    this.c = paramString2;
    AppMethodBeat.o(65973);
  }
  
  public void run()
  {
    AppMethodBeat.i(65974);
    b localb = (b)this.a.get();
    if ((this.a != null) && (localb != null))
    {
      localObject3 = null;
      try
      {
        InputStream localInputStream = b.a(localb, this.c);
        localObject3 = localInputStream;
        try
        {
          int i;
          String str;
          Object localObject1;
          localObject3.close();
          AppMethodBeat.o(65974);
          throw localObject2;
          AppMethodBeat.o(65974);
          return;
        }
        catch (IOException localIOException4)
        {
          break label178;
        }
      }
      catch (IOException localIOException2)
      {
        if (localObject1 != null) {
          try
          {
            localObject1.close();
            AppMethodBeat.o(65974);
            return;
          }
          catch (IOException localIOException3)
          {
            AppMethodBeat.o(65974);
            return;
          }
        }
      }
      finally
      {
        if (localObject3 == null) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.a.b.b
 * JD-Core Version:    0.7.0.1
 */