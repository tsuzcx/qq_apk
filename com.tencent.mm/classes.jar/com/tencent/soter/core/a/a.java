package com.tencent.soter.core.a;

import android.content.Context;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class a
{
  public static final e LPP;
  public Context mContext;
  
  static
  {
    AppMethodBeat.i(88614);
    if (com.tencent.soter.core.a.fUz())
    {
      LPP = new a.a();
      AppMethodBeat.o(88614);
      return;
    }
    LPP = new f();
    AppMethodBeat.o(88614);
  }
  
  private a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static a le(Context paramContext)
  {
    AppMethodBeat.i(88611);
    paramContext = new a(paramContext);
    AppMethodBeat.o(88611);
    return paramContext;
  }
  
  public final void a(a.d paramd, CancellationSignal paramCancellationSignal, b paramb)
  {
    AppMethodBeat.i(88613);
    LPP.a(this.mContext, paramd, paramCancellationSignal, paramb);
    AppMethodBeat.o(88613);
  }
  
  public final boolean hasEnrolledFingerprints()
  {
    AppMethodBeat.i(88612);
    boolean bool = LPP.hasEnrolledFingerprints(this.mContext);
    AppMethodBeat.o(88612);
    return bool;
  }
  
  public static abstract class b
  {
    public void efW() {}
    
    public void onAuthenticationCancelled() {}
    
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
  }
  
  public static abstract interface e
  {
    public abstract void a(Context paramContext, a.d paramd, CancellationSignal paramCancellationSignal, a.b paramb);
    
    public abstract boolean hasEnrolledFingerprints(Context paramContext);
    
    public abstract boolean isHardwareDetected(Context paramContext);
  }
  
  static final class f
    implements a.e
  {
    public final void a(Context paramContext, a.d paramd, CancellationSignal paramCancellationSignal, a.b paramb) {}
    
    public final boolean hasEnrolledFingerprints(Context paramContext)
    {
      return false;
    }
    
    public final boolean isHardwareDetected(Context paramContext)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.a.a
 * JD-Core Version:    0.7.0.1
 */