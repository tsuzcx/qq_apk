package android.support.v4.content;

import java.io.PrintWriter;

public final class d<D>
{
  int eS;
  e<D> hN;
  boolean hO;
  boolean hP;
  boolean hQ;
  boolean hR;
  boolean hS;
  
  public static String dataToString(D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    android.support.v4.b.d.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void a(e<D> parame)
  {
    if (this.hN == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.hN != parame) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.hN = null;
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.eS);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.hN);
    if ((this.hO) || (this.hR) || (this.hS))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.hO);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.hR);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.hS);
    }
    if ((this.hP) || (this.hQ))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.hP);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.hQ);
    }
  }
  
  public final void abandon()
  {
    this.hP = true;
  }
  
  public final void reset()
  {
    this.hQ = true;
    this.hO = false;
    this.hP = false;
    this.hR = false;
    this.hS = false;
  }
  
  public final void startLoading()
  {
    this.hO = true;
    this.hQ = false;
    this.hP = false;
  }
  
  public final void stopLoading()
  {
    this.hO = false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    android.support.v4.b.d.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.eS);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.content.d
 * JD-Core Version:    0.7.0.1
 */