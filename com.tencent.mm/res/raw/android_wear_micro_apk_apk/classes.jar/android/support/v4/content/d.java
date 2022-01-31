package android.support.v4.content;

import java.io.PrintWriter;

public final class d<D>
{
  int de;
  boolean ej;
  f<D> fQ;
  e<D> fR;
  boolean fS;
  boolean fT;
  boolean fU;
  boolean fV;
  
  public final void a(int paramInt, f<D> paramf)
  {
    if (this.fQ != null) {
      throw new IllegalStateException("There is already a listener registered");
    }
    this.fQ = paramf;
    this.de = paramInt;
  }
  
  public final void a(e<D> parame)
  {
    if (this.fR != null) {
      throw new IllegalStateException("There is already a listener registered");
    }
    this.fR = parame;
  }
  
  public final void a(f<D> paramf)
  {
    if (this.fQ == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.fQ != paramf) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.fQ = null;
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.de);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.fQ);
    if ((this.ej) || (this.fU) || (this.fV))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.ej);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.fU);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.fV);
    }
    if ((this.fS) || (this.fT))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.fS);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.fT);
    }
  }
  
  public final void b(e<D> parame)
  {
    if (this.fR == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.fR != parame) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.fR = null;
  }
  
  public final void reset()
  {
    this.fT = true;
    this.ej = false;
    this.fS = false;
    this.fU = false;
    this.fV = false;
  }
  
  public final void startLoading()
  {
    this.ej = true;
    this.fT = false;
    this.fS = false;
  }
  
  public final void stopLoading()
  {
    this.ej = false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    android.support.v4.b.d.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.de);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.content.d
 * JD-Core Version:    0.7.0.1
 */