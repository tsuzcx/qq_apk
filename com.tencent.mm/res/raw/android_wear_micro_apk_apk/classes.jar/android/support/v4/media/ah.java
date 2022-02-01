package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

public final class ah
{
  private Bundle gl;
  private CharSequence jA;
  private Bitmap jB;
  private Uri jC;
  private Uri jD;
  private String jx;
  private CharSequence jy;
  private CharSequence jz;
  
  public final ah b(Bitmap paramBitmap)
  {
    this.jB = paramBitmap;
    return this;
  }
  
  public final ah b(Uri paramUri)
  {
    this.jC = paramUri;
    return this;
  }
  
  public final MediaDescriptionCompat be()
  {
    return new MediaDescriptionCompat(this.jx, this.jy, this.jz, this.jA, this.jB, this.jC, this.gl, this.jD);
  }
  
  public final ah c(Uri paramUri)
  {
    this.jD = paramUri;
    return this;
  }
  
  public final ah e(String paramString)
  {
    this.jx = paramString;
    return this;
  }
  
  public final ah f(Bundle paramBundle)
  {
    this.gl = paramBundle;
    return this;
  }
  
  public final ah f(CharSequence paramCharSequence)
  {
    this.jy = paramCharSequence;
    return this;
  }
  
  public final ah g(CharSequence paramCharSequence)
  {
    this.jz = paramCharSequence;
    return this;
  }
  
  public final ah h(CharSequence paramCharSequence)
  {
    this.jA = paramCharSequence;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.ah
 * JD-Core Version:    0.7.0.1
 */