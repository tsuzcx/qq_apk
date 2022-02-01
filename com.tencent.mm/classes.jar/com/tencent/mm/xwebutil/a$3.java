package com.tencent.mm.xwebutil;

import android.graphics.Bitmap;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j.a;

final class a$3
  implements j.a
{
  a$3(ValueCallback paramValueCallback) {}
  
  public final void Pc(int paramInt) {}
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public final void ay(int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void bSt() {}
  
  public final void c(int paramInt, Bitmap paramBitmap) {}
  
  public final void erQ() {}
  
  public final void erR()
  {
    AppMethodBeat.i(231690);
    if (this.rXV != null) {
      this.rXV.onReceiveValue("xwebFileReaderReachEnd");
    }
    AppMethodBeat.o(231690);
  }
  
  public final void erS()
  {
    AppMethodBeat.i(231693);
    if (this.rXV != null) {
      this.rXV.onReceiveValue("xwebFileReaderUserOperated");
    }
    AppMethodBeat.o(231693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xwebutil.a.3
 * JD-Core Version:    0.7.0.1
 */