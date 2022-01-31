package com.tencent.soter.core.a;

import android.content.Context;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  static final a.e BlQ;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(72987);
    if (com.tencent.soter.core.a.dVc())
    {
      BlQ = new a.a();
      AppMethodBeat.o(72987);
      return;
    }
    BlQ = new a.f();
    AppMethodBeat.o(72987);
  }
  
  private a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static a jl(Context paramContext)
  {
    AppMethodBeat.i(72983);
    paramContext = new a(paramContext);
    AppMethodBeat.o(72983);
    return paramContext;
  }
  
  public final void a(a.d paramd, CancellationSignal paramCancellationSignal, a.b paramb)
  {
    AppMethodBeat.i(72986);
    BlQ.a(this.mContext, paramd, paramCancellationSignal, paramb);
    AppMethodBeat.o(72986);
  }
  
  public final boolean hasEnrolledFingerprints()
  {
    AppMethodBeat.i(72984);
    boolean bool = BlQ.hasEnrolledFingerprints(this.mContext);
    AppMethodBeat.o(72984);
    return bool;
  }
  
  public final boolean isHardwareDetected()
  {
    AppMethodBeat.i(72985);
    boolean bool = BlQ.isHardwareDetected(this.mContext);
    AppMethodBeat.o(72985);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.a.a
 * JD-Core Version:    0.7.0.1
 */