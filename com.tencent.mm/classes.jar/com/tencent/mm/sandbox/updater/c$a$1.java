package com.tencent.mm.sandbox.updater;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class c$a$1
  extends OutputStream
{
  private ah handler = new ah(Looper.getMainLooper());
  private ByteArrayOutputStream ucC = new ByteArrayOutputStream();
  
  c$a$1(c.a parama) {}
  
  public final void write(int paramInt)
  {
    throw new IOException("unexpected operation");
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.ucC.write(paramArrayOfByte, paramInt1, paramInt2);
    if ((this.ucC.size() < 131072) && (c.a.a(this.ucD) + this.ucC.size() < c.a.b(this.ucD))) {}
    do
    {
      return;
      paramInt1 = this.ucC.size();
      paramInt2 = e.a(this.ucD.ucx.SV(), this.ucC.toByteArray(), paramInt1);
      this.ucC.reset();
      if (paramInt2 != 0) {
        throw new IOException("appendToFile failed :" + paramInt2);
      }
      c.a.a(this.ucD, c.a.a(this.ucD) + paramInt1);
      this.handler.post(new c.a.1.1(this, paramInt1));
    } while (!c.a(this.ucD.ucx));
    throw new IOException("manual force cancel!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c.a.1
 * JD-Core Version:    0.7.0.1
 */