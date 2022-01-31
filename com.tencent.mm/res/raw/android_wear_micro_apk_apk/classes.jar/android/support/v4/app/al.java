package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.e;
import android.support.v4.content.f;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

final class al
  implements e<Object>, f<Object>
{
  boolean bj;
  boolean cF;
  final int de;
  boolean ej;
  final Bundle ek;
  aj<Object> el;
  android.support.v4.content.d<Object> em;
  boolean en;
  boolean eo;
  Object ep;
  boolean eq;
  boolean er;
  boolean es;
  al et;
  
  final void a(android.support.v4.content.d<Object> paramd, Object paramObject)
  {
    String str;
    if (this.el != null)
    {
      if (this.eu.aZ == null) {
        break label171;
      }
      str = this.eu.aZ.aY.cG;
      this.eu.aZ.aY.cG = "onLoadFinished";
    }
    for (;;)
    {
      try
      {
        if (ak.DEBUG)
        {
          paramd = new StringBuilder("  onLoadFinished in ").append(paramd).append(": ");
          StringBuilder localStringBuilder = new StringBuilder(64);
          android.support.v4.b.d.a(paramObject, localStringBuilder);
          localStringBuilder.append("}");
          Log.v("LoaderManager", localStringBuilder.toString());
        }
        if (this.eu.aZ != null) {
          this.eu.aZ.aY.cG = str;
        }
        this.eo = true;
        return;
      }
      finally
      {
        if (this.eu.aZ != null) {
          this.eu.aZ.aY.cG = str;
        }
      }
      label171:
      str = null;
    }
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter)
  {
    paramFileDescriptor = paramString;
    paramString = this;
    for (;;)
    {
      paramPrintWriter.print(paramFileDescriptor);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(paramString.de);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(paramString.ek);
      paramPrintWriter.print(paramFileDescriptor);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(paramString.el);
      paramPrintWriter.print(paramFileDescriptor);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(paramString.em);
      if (paramString.em != null) {
        paramString.em.a(paramFileDescriptor + "  ", paramPrintWriter);
      }
      if ((paramString.en) || (paramString.eo))
      {
        paramPrintWriter.print(paramFileDescriptor);
        paramPrintWriter.print("mHaveData=");
        paramPrintWriter.print(paramString.en);
        paramPrintWriter.print("  mDeliveredData=");
        paramPrintWriter.println(paramString.eo);
        paramPrintWriter.print(paramFileDescriptor);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(paramString.ep);
      }
      paramPrintWriter.print(paramFileDescriptor);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(paramString.ej);
      paramPrintWriter.print(" mReportNextStart=");
      paramPrintWriter.print(paramString.er);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(paramString.cF);
      paramPrintWriter.print(paramFileDescriptor);
      paramPrintWriter.print("mRetaining=");
      paramPrintWriter.print(paramString.bj);
      paramPrintWriter.print(" mRetainingStarted=");
      paramPrintWriter.print(paramString.eq);
      paramPrintWriter.print(" mListenerRegistered=");
      paramPrintWriter.println(paramString.es);
      if (paramString.et == null) {
        break;
      }
      paramPrintWriter.print(paramFileDescriptor);
      paramPrintWriter.println("Pending Loader ");
      paramPrintWriter.print(paramString.et);
      paramPrintWriter.println(":");
      paramString = paramString.et;
      paramFileDescriptor = paramFileDescriptor + "  ";
    }
  }
  
  final void destroy()
  {
    al localal = this;
    if (ak.DEBUG) {
      Log.v("LoaderManager", "  Destroying: " + localal);
    }
    localal.cF = true;
    boolean bool = localal.eo;
    localal.eo = false;
    String str;
    if ((localal.el != null) && (localal.em != null) && (localal.en) && (bool))
    {
      if (ak.DEBUG) {
        Log.v("LoaderManager", "  Resetting: " + localal);
      }
      if (localal.eu.aZ == null) {
        break label234;
      }
      str = localal.eu.aZ.aY.cG;
      localal.eu.aZ.aY.cG = "onLoaderReset";
    }
    for (;;)
    {
      if (localal.eu.aZ != null) {
        localal.eu.aZ.aY.cG = str;
      }
      localal.el = null;
      localal.ep = null;
      localal.en = false;
      if (localal.em != null)
      {
        if (localal.es)
        {
          localal.es = false;
          localal.em.a(localal);
          localal.em.b(localal);
        }
        localal.em.reset();
      }
      if (localal.et != null)
      {
        localal = localal.et;
        break;
      }
      return;
      label234:
      str = null;
    }
  }
  
  final void stop()
  {
    if (ak.DEBUG) {
      Log.v("LoaderManager", "  Stopping: " + this);
    }
    this.ej = false;
    if ((!this.bj) && (this.em != null) && (this.es))
    {
      this.es = false;
      this.em.a(this);
      this.em.b(this);
      this.em.stopLoading();
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(this.de);
    localStringBuilder.append(" : ");
    android.support.v4.b.d.a(this.em, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.al
 * JD-Core Version:    0.7.0.1
 */