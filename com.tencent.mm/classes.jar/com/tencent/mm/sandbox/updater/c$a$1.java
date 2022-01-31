package com.tencent.mm.sandbox.updater;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class c$a$1
  extends OutputStream
{
  private ak handler;
  private ByteArrayOutputStream ykR;
  
  c$a$1(c.a parama)
  {
    AppMethodBeat.i(28863);
    this.handler = new ak(Looper.getMainLooper());
    this.ykR = new ByteArrayOutputStream();
    AppMethodBeat.o(28863);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(28865);
    IOException localIOException = new IOException("unexpected operation");
    AppMethodBeat.o(28865);
    throw localIOException;
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28864);
    this.ykR.write(paramArrayOfByte, paramInt1, paramInt2);
    if ((this.ykR.size() < 131072) && (c.a.a(this.ykS) + this.ykR.size() < c.a.b(this.ykS)))
    {
      AppMethodBeat.o(28864);
      return;
    }
    paramInt1 = this.ykR.size();
    paramInt2 = e.a(this.ykS.ykM.amg(), this.ykR.toByteArray(), paramInt1);
    this.ykR.reset();
    if (paramInt2 != 0)
    {
      paramArrayOfByte = new IOException("appendToFile failed :".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(28864);
      throw paramArrayOfByte;
    }
    c.a.a(this.ykS, c.a.a(this.ykS) + paramInt1);
    this.handler.post(new c.a.1.1(this, paramInt1));
    if (c.a(this.ykS.ykM))
    {
      paramArrayOfByte = new IOException("manual force cancel!");
      AppMethodBeat.o(28864);
      throw paramArrayOfByte;
    }
    AppMethodBeat.o(28864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c.a.1
 * JD-Core Version:    0.7.0.1
 */