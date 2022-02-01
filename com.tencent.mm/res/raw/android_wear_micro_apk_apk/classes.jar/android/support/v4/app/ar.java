package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public final class ar
{
  public PendingIntent actionIntent;
  final Bundle gl;
  private final ba[] gm;
  private final ba[] gn;
  private boolean go;
  public int icon;
  public CharSequence title;
  
  public ar(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private ar(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    this.icon = paramInt;
    this.title = at.e(paramCharSequence);
    this.actionIntent = paramPendingIntent;
    this.gl = paramBundle;
    this.gm = null;
    this.gn = null;
    this.go = true;
  }
  
  public final ba[] aK()
  {
    return this.gm;
  }
  
  public final ba[] aL()
  {
    return this.gn;
  }
  
  public final boolean getAllowGeneratedReplies()
  {
    return this.go;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ar
 * JD-Core Version:    0.7.0.1
 */