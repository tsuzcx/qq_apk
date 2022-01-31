package android.support.v4.app;

import android.support.v4.content.e;
import android.support.v4.content.f;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class ak
  extends ai
{
  static boolean DEBUG = false;
  final String aM;
  r aZ;
  boolean bj;
  final android.support.v4.b.r<al> eh;
  final android.support.v4.b.r<al> ei;
  boolean ej;
  
  public final boolean aq()
  {
    int j = this.eh.size();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      al localal = (al)this.eh.valueAt(i);
      if ((localal.ej) && (!localal.eo)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 |= bool1;
        i += 1;
        break;
      }
    }
    return bool2;
  }
  
  final void as()
  {
    if (DEBUG) {
      Log.v("LoaderManager", "Starting in " + this);
    }
    Object localObject;
    if (this.ej)
    {
      localObject = new RuntimeException("here");
      ((RuntimeException)localObject).fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, (Throwable)localObject);
      return;
    }
    this.ej = true;
    int i = this.eh.size() - 1;
    label89:
    if (i >= 0)
    {
      localObject = (al)this.eh.valueAt(i);
      if ((!((al)localObject).bj) || (!((al)localObject).eq)) {
        break label131;
      }
      ((al)localObject).ej = true;
    }
    for (;;)
    {
      i -= 1;
      break label89;
      break;
      label131:
      if (!((al)localObject).ej)
      {
        ((al)localObject).ej = true;
        if (DEBUG) {
          Log.v("LoaderManager", "  Starting: " + localObject);
        }
        if ((((al)localObject).em == null) && (((al)localObject).el != null)) {
          ((al)localObject).em = ((al)localObject).el.ar();
        }
        if (((al)localObject).em != null)
        {
          if ((((al)localObject).em.getClass().isMemberClass()) && (!Modifier.isStatic(((al)localObject).em.getClass().getModifiers()))) {
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + ((al)localObject).em);
          }
          if (!((al)localObject).es)
          {
            ((al)localObject).em.a(((al)localObject).de, (f)localObject);
            ((al)localObject).em.a((e)localObject);
            ((al)localObject).es = true;
          }
          ((al)localObject).em.startLoading();
        }
      }
    }
  }
  
  final void at()
  {
    if (DEBUG) {
      Log.v("LoaderManager", "Stopping in " + this);
    }
    if (!this.ej)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
      return;
    }
    int i = this.eh.size() - 1;
    while (i >= 0)
    {
      ((al)this.eh.valueAt(i)).stop();
      i -= 1;
    }
    this.ej = false;
  }
  
  final void au()
  {
    if (DEBUG) {
      Log.v("LoaderManager", "Retaining in " + this);
    }
    Object localObject;
    if (!this.ej)
    {
      localObject = new RuntimeException("here");
      ((RuntimeException)localObject).fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, (Throwable)localObject);
    }
    for (;;)
    {
      return;
      this.bj = true;
      this.ej = false;
      int i = this.eh.size() - 1;
      while (i >= 0)
      {
        localObject = (al)this.eh.valueAt(i);
        if (DEBUG) {
          Log.v("LoaderManager", "  Retaining: " + localObject);
        }
        ((al)localObject).bj = true;
        ((al)localObject).eq = ((al)localObject).ej;
        ((al)localObject).ej = false;
        ((al)localObject).el = null;
        i -= 1;
      }
    }
  }
  
  final void av()
  {
    int i = this.eh.size() - 1;
    while (i >= 0)
    {
      ((al)this.eh.valueAt(i)).er = true;
      i -= 1;
    }
  }
  
  final void aw()
  {
    int i = this.eh.size() - 1;
    while (i >= 0)
    {
      al localal = (al)this.eh.valueAt(i);
      if ((localal.ej) && (localal.er))
      {
        localal.er = false;
        if ((localal.en) && (!localal.bj)) {
          localal.a(localal.em, localal.ep);
        }
      }
      i -= 1;
    }
  }
  
  final void ax()
  {
    if (!this.bj)
    {
      if (DEBUG) {
        Log.v("LoaderManager", "Destroying Active in " + this);
      }
      i = this.eh.size() - 1;
      while (i >= 0)
      {
        ((al)this.eh.valueAt(i)).destroy();
        i -= 1;
      }
      this.eh.clear();
    }
    if (DEBUG) {
      Log.v("LoaderManager", "Destroying Inactive in " + this);
    }
    int i = this.ei.size() - 1;
    while (i >= 0)
    {
      ((al)this.ei.valueAt(i)).destroy();
      i -= 1;
    }
    this.ei.clear();
    this.aZ = null;
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    int i;
    al localal;
    if (this.eh.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      paramArrayOfString = paramString + "    ";
      i = 0;
      while (i < this.eh.size())
      {
        localal = (al)this.eh.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.eh.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localal.toString());
        localal.a(paramArrayOfString, paramFileDescriptor, paramPrintWriter);
        i += 1;
      }
    }
    if (this.ei.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      paramArrayOfString = paramString + "    ";
      i = j;
      while (i < this.ei.size())
      {
        localal = (al)this.ei.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.ei.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localal.toString());
        localal.a(paramArrayOfString, paramFileDescriptor, paramPrintWriter);
        i += 1;
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    android.support.v4.b.d.a(this.aZ, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ak
 * JD-Core Version:    0.7.0.1
 */