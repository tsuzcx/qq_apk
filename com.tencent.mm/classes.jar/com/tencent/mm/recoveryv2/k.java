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
  private static volatile k NCr;
  public j NCs;
  public final Map<String, e> NCt;
  public Context mContext;
  
  private k()
  {
    AppMethodBeat.i(193865);
    this.NCt = new HashMap();
    AppMethodBeat.o(193865);
  }
  
  public static k guX()
  {
    AppMethodBeat.i(193864);
    if (NCr == null) {}
    try
    {
      if (NCr == null) {
        NCr = new k();
      }
      k localk = NCr;
      AppMethodBeat.o(193864);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(193864);
    }
  }
  
  public static String guZ()
  {
    return ":recovery";
  }
  
  public static boolean iS(Context paramContext)
  {
    AppMethodBeat.i(258372);
    boolean bool = l.cv(paramContext, "");
    AppMethodBeat.o(258372);
    return bool;
  }
  
  public static boolean iT(Context paramContext)
  {
    AppMethodBeat.i(193873);
    boolean bool = l.cv(paramContext, ":recovery");
    AppMethodBeat.o(193873);
    return bool;
  }
  
  public final void a(String paramString, e parame)
  {
    AppMethodBeat.i(193871);
    try
    {
      if (this.NCt.containsKey(paramString))
      {
        paramString = new IllegalArgumentException(paramString + " has been registered! target = " + this.NCt.get(paramString));
        AppMethodBeat.o(193871);
        throw paramString;
      }
    }
    catch (Throwable paramString)
    {
      a.w("MicroMsg.recovery", "register actions fail", paramString);
      AppMethodBeat.o(193871);
      return;
    }
    parame.guu();
    this.NCt.put(paramString, parame);
    AppMethodBeat.o(193871);
  }
  
  public final void ajx(int paramInt)
  {
    AppMethodBeat.i(193869);
    if (!l.cv(getContext(), ""))
    {
      a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
      AppMethodBeat.o(193869);
      return;
    }
    if ((this.NCs instanceof j.e))
    {
      ((j.e)this.NCs).aju(paramInt);
      AppMethodBeat.o(193869);
      return;
    }
    if ((this.NCs instanceof j.b))
    {
      ((j.b)this.NCs).ajt(paramInt);
      AppMethodBeat.o(193869);
      return;
    }
    new j.e(getContext()).aju(paramInt);
    AppMethodBeat.o(193869);
  }
  
  public final k b(int paramInt, d paramd)
  {
    AppMethodBeat.i(193867);
    if (this.NCs == null) {
      guY();
    }
    this.NCs.a(paramInt, paramd);
    AppMethodBeat.o(193867);
    return this;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(193866);
    if (this.mContext == null)
    {
      this.mContext = l.a.gva().getApplicationContext();
      l.checkNotNull(this.mContext, "Context should not be null");
    }
    Context localContext = this.mContext;
    AppMethodBeat.o(193866);
    return localContext;
  }
  
  public final void guY()
  {
    AppMethodBeat.i(193870);
    this.NCs = new j.b(getContext());
    AppMethodBeat.o(193870);
  }
  
  public final void unregister()
  {
    AppMethodBeat.i(193868);
    if (this.NCs != null) {
      this.NCs.finish();
    }
    AppMethodBeat.o(193868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.k
 * JD-Core Version:    0.7.0.1
 */