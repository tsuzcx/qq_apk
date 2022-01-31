package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

public final class ah
{
  private Bundle ew;
  private CharSequence hA;
  private CharSequence hB;
  private Bitmap hC;
  private Uri hD;
  private Uri hE;
  private String hy;
  private CharSequence hz;
  
  public final ah a(Bitmap paramBitmap)
  {
    this.hC = paramBitmap;
    return this;
  }
  
  public final MediaDescriptionCompat aO()
  {
    return new MediaDescriptionCompat(this.hy, this.hz, this.hA, this.hB, this.hC, this.hD, this.ew, this.hE);
  }
  
  public final ah b(Uri paramUri)
  {
    this.hD = paramUri;
    return this;
  }
  
  public final ah c(Uri paramUri)
  {
    this.hE = paramUri;
    return this;
  }
  
  public final ah e(String paramString)
  {
    this.hy = paramString;
    return this;
  }
  
  public final ah f(Bundle paramBundle)
  {
    this.ew = paramBundle;
    return this;
  }
  
  public final ah f(CharSequence paramCharSequence)
  {
    this.hz = paramCharSequence;
    return this;
  }
  
  public final ah g(CharSequence paramCharSequence)
  {
    this.hA = paramCharSequence;
    return this;
  }
  
  public final ah h(CharSequence paramCharSequence)
  {
    this.hB = paramCharSequence;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.ah
 * JD-Core Version:    0.7.0.1
 */