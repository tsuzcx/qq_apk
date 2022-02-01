package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.e;
import android.arch.lifecycle.g;
import android.arch.lifecycle.i;
import android.arch.lifecycle.j;
import android.arch.lifecycle.s;
import android.os.Bundle;
import android.support.v4.b.r;

public class SupportActivity
  extends Activity
  implements i
{
  private j dk = new j(this);
  private r<Class<? extends Object>, Object> hG = new r();
  
  public e h()
  {
    return this.dk;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    s.a(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.dk.b(g.J);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.SupportActivity
 * JD-Core Version:    0.7.0.1
 */