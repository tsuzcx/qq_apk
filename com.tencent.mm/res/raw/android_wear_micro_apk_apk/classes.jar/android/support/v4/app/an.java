package android.support.v4.app;

import android.arch.lifecycle.i;
import android.arch.lifecycle.p;
import android.arch.lifecycle.q;
import android.os.Bundle;
import android.support.v4.content.e;
import android.util.Log;
import java.io.PrintWriter;

public final class an<D>
  extends p<D>
  implements e<D>
{
  private final int eS;
  private i gb;
  private final Bundle gd;
  private final android.support.v4.content.d<D> ge;
  private ao<D> gf;
  private android.support.v4.content.d<D> gg;
  
  public final void a(q<D> paramq)
  {
    super.a(paramq);
    this.gb = null;
    this.gf = null;
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.eS);
    paramPrintWriter.print(" mArgs=");
    paramPrintWriter.println(this.gd);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoader=");
    paramPrintWriter.println(this.ge);
    this.ge.a(paramString + "  ", paramPrintWriter);
    if (this.gf != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(this.gf);
      this.gf.dump(paramString + "  ", paramPrintWriter);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mData=");
    paramPrintWriter.println(android.support.v4.content.d.dataToString(getValue()));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mStarted=");
    paramPrintWriter.println(m());
  }
  
  final void aH()
  {
    i locali = this.gb;
    ao localao = this.gf;
    if ((locali != null) && (localao != null))
    {
      super.a(localao);
      a(locali, localao);
    }
  }
  
  final android.support.v4.content.d<D> aI()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Destroying: ".concat(String.valueOf(this)));
    }
    this.ge.abandon();
    ao localao = this.gf;
    if (localao != null)
    {
      a(localao);
      localao.reset();
    }
    this.ge.a(this);
    this.ge.reset();
    return this.gg;
  }
  
  protected final void l()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Stopping: ".concat(String.valueOf(this)));
    }
    this.ge.stopLoading();
  }
  
  protected final void onActive()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Starting: ".concat(String.valueOf(this)));
    }
    this.ge.startLoading();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(this.eS);
    localStringBuilder.append(" : ");
    android.support.v4.b.d.a(this.ge, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.an
 * JD-Core Version:    0.7.0.1
 */