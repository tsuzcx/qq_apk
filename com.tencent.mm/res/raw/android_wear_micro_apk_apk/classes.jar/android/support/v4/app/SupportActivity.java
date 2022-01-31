package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.b;
import android.arch.lifecycle.d;
import android.arch.lifecycle.e;
import android.arch.lifecycle.f;
import android.arch.lifecycle.l;
import android.os.Bundle;
import android.support.v4.b.q;

public class SupportActivity
  extends Activity
  implements e
{
  private f bB = new f(this);
  private q<Class<? extends Object>, Object> fJ = new q();
  
  public b d()
  {
    return this.bB;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    l.a(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.bB.a(d.p);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.SupportActivity
 * JD-Core Version:    0.7.0.1
 */