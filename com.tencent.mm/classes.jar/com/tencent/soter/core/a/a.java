package com.tencent.soter.core.a;

import android.content.Context;
import android.os.CancellationSignal;
import com.tencent.soter.core.c.d;

public final class a
{
  static final a.e wOs = new a.f();
  private Context mContext;
  
  static
  {
    if (com.tencent.soter.core.a.cPh())
    {
      wOs = new a.a();
      return;
    }
  }
  
  private a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static a hK(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public final void a(a.d paramd, CancellationSignal paramCancellationSignal, a.b paramb)
  {
    wOs.a(this.mContext, paramd, paramCancellationSignal, paramb);
  }
  
  public final boolean hasEnrolledFingerprints()
  {
    return wOs.hasEnrolledFingerprints(this.mContext);
  }
  
  public final boolean isHardwareDetected()
  {
    return wOs.isHardwareDetected(this.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.a.a
 * JD-Core Version:    0.7.0.1
 */