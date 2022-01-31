package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import javax.microedition.khronos.opengles.GL10;

public class mj
  extends ln
  implements JNICallback.b, JNICallback.c, ml.b
{
  private int a;
  private mi b;
  
  public mj(mi parammi)
  {
    this.b = parammi;
    this.b.a(this);
    this.b.a(this);
    this.a = parammi.a();
    new StringBuilder("tileOverlayId:").append(this.a);
  }
  
  public Bitmap a(byte[] paramArrayOfByte)
  {
    if (this.b != null) {
      return this.b.a(paramArrayOfByte);
    }
    return null;
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.b != null) {
      this.b.a(paramString, paramArrayOfByte1, paramArrayOfByte2);
    }
  }
  
  public void a(GL10 paramGL10) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    e();
  }
  
  public void e()
  {
    if (this.b != null) {
      this.b.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mj
 * JD-Core Version:    0.7.0.1
 */