package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.be;
import java.lang.ref.WeakReference;

public class ln
  implements JNICallback.b, JNICallback.c, lq.b
{
  private WeakReference<kx> a;
  private WeakReference<f> b;
  private lt c;
  private int d;
  
  public ln(kx paramkx)
  {
    AppMethodBeat.i(149189);
    this.d = -1;
    this.a = new WeakReference(paramkx);
    this.b = new WeakReference(paramkx.b());
    this.c = new lr(paramkx.i());
    a(this);
    a(this);
    AppMethodBeat.o(149189);
  }
  
  public int a()
  {
    AppMethodBeat.i(149192);
    if ((this.b != null) && (this.b.get() != null))
    {
      this.d = ((f)this.b.get()).A();
      if (this.d != -1) {
        ((f)this.b.get()).a(this.d, 4, 20);
      }
    }
    int i = this.d;
    AppMethodBeat.o(149192);
    return i;
  }
  
  public Bitmap a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149195);
    if ((this.a == null) || (this.a.get() == null) || (this.d == -1))
    {
      AppMethodBeat.o(149195);
      return null;
    }
    be localbe = new be();
    localbe.a(paramArrayOfByte);
    paramArrayOfByte = this.c.a(localbe.a(), localbe.b(), localbe.c(), paramArrayOfByte);
    AppMethodBeat.o(149195);
    return paramArrayOfByte;
  }
  
  public void a(JNICallback.b paramb)
  {
    AppMethodBeat.i(149190);
    if ((this.b != null) && (this.b.get() != null)) {
      ((f)this.b.get()).a(paramb);
    }
    AppMethodBeat.o(149190);
  }
  
  public void a(JNICallback.c paramc)
  {
    AppMethodBeat.i(149191);
    if ((this.b != null) && (this.b.get() != null)) {
      ((f)this.b.get()).a(paramc);
    }
    AppMethodBeat.o(149191);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(149196);
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte2.length == 0) || (paramArrayOfByte1.length == 0))
    {
      AppMethodBeat.o(149196);
      return;
    }
    be localbe = new be();
    localbe.a(paramArrayOfByte1);
    this.c.a(localbe.a(), localbe.b(), localbe.c(), paramString, paramArrayOfByte2);
    AppMethodBeat.o(149196);
  }
  
  public void b()
  {
    AppMethodBeat.i(149193);
    if ((this.b != null) && (this.b.get() != null) && (this.d != -1))
    {
      f localf = (f)this.b.get();
      localf.a(null);
      localf.a(null);
      localf.i(this.d);
      this.c.b();
      this.d = -1;
    }
    AppMethodBeat.o(149193);
  }
  
  public void b_()
  {
    AppMethodBeat.i(149197);
    this.c.a();
    c();
    AppMethodBeat.o(149197);
  }
  
  public void c()
  {
    AppMethodBeat.i(149194);
    if ((this.b != null) && (this.b.get() != null) && (this.d != -2147483648)) {
      ((f)this.b.get()).j(this.d);
    }
    AppMethodBeat.o(149194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ln
 * JD-Core Version:    0.7.0.1
 */