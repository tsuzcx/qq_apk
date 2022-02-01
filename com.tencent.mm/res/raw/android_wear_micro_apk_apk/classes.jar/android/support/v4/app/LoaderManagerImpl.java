package android.support.v4.app;

import android.arch.lifecycle.i;
import android.support.v4.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

final class LoaderManagerImpl
  extends al
{
  static boolean DEBUG = false;
  private final i gb;
  private final LoaderManagerImpl.LoaderViewModel gc;
  
  final void aH()
  {
    this.gc.aH();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.gc.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    d.a(this.gb, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */