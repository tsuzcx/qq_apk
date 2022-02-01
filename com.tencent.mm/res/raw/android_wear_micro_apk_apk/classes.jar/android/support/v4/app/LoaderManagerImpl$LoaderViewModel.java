package android.support.v4.app;

import android.arch.lifecycle.u;
import android.arch.lifecycle.w;
import android.support.v4.b.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl$LoaderViewModel
  extends u
{
  private static final w gj = new w() {};
  private s<an> gk = new s();
  
  final void aH()
  {
    int j = this.gk.size();
    int i = 0;
    while (i < j)
    {
      ((an)this.gk.valueAt(i)).aH();
      i += 1;
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (this.gk.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      paramFileDescriptor = paramString + "    ";
      int i = 0;
      while (i < this.gk.size())
      {
        paramArrayOfString = (an)this.gk.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.gk.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramArrayOfString.toString());
        paramArrayOfString.a(paramFileDescriptor, paramPrintWriter);
        i += 1;
      }
    }
  }
  
  protected final void q()
  {
    super.q();
    int j = this.gk.size();
    int i = 0;
    while (i < j)
    {
      ((an)this.gk.valueAt(i)).aI();
      i += 1;
    }
    this.gk.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl.LoaderViewModel
 * JD-Core Version:    0.7.0.1
 */