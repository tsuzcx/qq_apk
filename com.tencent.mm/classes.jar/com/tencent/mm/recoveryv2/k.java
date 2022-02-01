package com.tencent.mm.recoveryv2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class k
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile k IoU;
  public j IoV;
  public final Map<String, e> IoW;
  public Context mContext;
  
  private k()
  {
    AppMethodBeat.i(195377);
    this.IoW = new HashMap();
    AppMethodBeat.o(195377);
  }
  
  public static k flm()
  {
    AppMethodBeat.i(195376);
    if (IoU == null) {}
    try
    {
      if (IoU == null) {
        IoU = new k();
      }
      k localk = IoU;
      AppMethodBeat.o(195376);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(195376);
    }
  }
  
  public static String flo()
  {
    return ":recovery";
  }
  
  public static boolean hZ(Context paramContext)
  {
    AppMethodBeat.i(224223);
    boolean bool = l.cb(paramContext, "");
    AppMethodBeat.o(224223);
    return bool;
  }
  
  public static boolean ia(Context paramContext)
  {
    AppMethodBeat.i(195385);
    boolean bool = l.cb(paramContext, ":recovery");
    AppMethodBeat.o(195385);
    return bool;
  }
  
  public final void a(String paramString, e parame)
  {
    AppMethodBeat.i(195383);
    try
    {
      if (this.IoW.containsKey(paramString))
      {
        paramString = new IllegalArgumentException(paramString + " has been registered! target = " + this.IoW.get(paramString));
        AppMethodBeat.o(195383);
        throw paramString;
      }
    }
    catch (Throwable paramString)
    {
      a.w("MicroMsg.recovery", "register actions fail", paramString);
      AppMethodBeat.o(195383);
      return;
    }
    parame.fkI();
    this.IoW.put(paramString, parame);
    AppMethodBeat.o(195383);
  }
  
  public final void aaI(int paramInt)
  {
    AppMethodBeat.i(195381);
    if (!l.cb(getContext(), ""))
    {
      a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
      AppMethodBeat.o(195381);
      return;
    }
    if ((this.IoV instanceof j.e))
    {
      ((j.e)this.IoV).aaF(paramInt);
      AppMethodBeat.o(195381);
      return;
    }
    if ((this.IoV instanceof j.b))
    {
      ((j.b)this.IoV).aaE(paramInt);
      AppMethodBeat.o(195381);
      return;
    }
    new j.e(getContext()).aaF(paramInt);
    AppMethodBeat.o(195381);
  }
  
  public final k b(int paramInt, d paramd)
  {
    AppMethodBeat.i(195379);
    if (this.IoV == null) {
      fln();
    }
    this.IoV.a(paramInt, paramd);
    AppMethodBeat.o(195379);
    return this;
  }
  
  public final void fln()
  {
    AppMethodBeat.i(195382);
    this.IoV = new j.b(getContext());
    AppMethodBeat.o(195382);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(195378);
    if (this.mContext == null)
    {
      this.mContext = l.a.flp().getApplicationContext();
      l.checkNotNull(this.mContext, "Context should not be null");
    }
    Context localContext = this.mContext;
    AppMethodBeat.o(195378);
    return localContext;
  }
  
  public final void unregister()
  {
    AppMethodBeat.i(195380);
    if (this.IoV != null) {
      this.IoV.finish();
    }
    AppMethodBeat.o(195380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.k
 * JD-Core Version:    0.7.0.1
 */