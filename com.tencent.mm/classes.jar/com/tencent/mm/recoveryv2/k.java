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
  private static volatile k HUM;
  public j HUN;
  public final Map<String, e> HUO;
  public Context mContext;
  
  private k()
  {
    AppMethodBeat.i(207069);
    this.HUO = new HashMap();
    AppMethodBeat.o(207069);
  }
  
  public static k fhu()
  {
    AppMethodBeat.i(207068);
    if (HUM == null) {}
    try
    {
      if (HUM == null) {
        HUM = new k();
      }
      k localk = HUM;
      AppMethodBeat.o(207068);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(207068);
    }
  }
  
  public static String fhw()
  {
    return ":recovery";
  }
  
  public static boolean hT(Context paramContext)
  {
    AppMethodBeat.i(221190);
    boolean bool = l.ca(paramContext, "");
    AppMethodBeat.o(221190);
    return bool;
  }
  
  public static boolean hU(Context paramContext)
  {
    AppMethodBeat.i(207077);
    boolean bool = l.ca(paramContext, ":recovery");
    AppMethodBeat.o(207077);
    return bool;
  }
  
  public final void a(String paramString, e parame)
  {
    AppMethodBeat.i(207075);
    try
    {
      if (this.HUO.containsKey(paramString))
      {
        paramString = new IllegalArgumentException(paramString + " has been registered! target = " + this.HUO.get(paramString));
        AppMethodBeat.o(207075);
        throw paramString;
      }
    }
    catch (Throwable paramString)
    {
      a.w("MicroMsg.recovery", "register actions fail", paramString);
      AppMethodBeat.o(207075);
      return;
    }
    parame.fgQ();
    this.HUO.put(paramString, parame);
    AppMethodBeat.o(207075);
  }
  
  public final void aac(int paramInt)
  {
    AppMethodBeat.i(207073);
    if (!l.ca(getContext(), ""))
    {
      a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
      AppMethodBeat.o(207073);
      return;
    }
    if ((this.HUN instanceof j.e))
    {
      ((j.e)this.HUN).ZZ(paramInt);
      AppMethodBeat.o(207073);
      return;
    }
    if ((this.HUN instanceof j.b))
    {
      ((j.b)this.HUN).ZY(paramInt);
      AppMethodBeat.o(207073);
      return;
    }
    new j.e(getContext()).ZZ(paramInt);
    AppMethodBeat.o(207073);
  }
  
  public final k b(int paramInt, d paramd)
  {
    AppMethodBeat.i(207071);
    if (this.HUN == null) {
      fhv();
    }
    this.HUN.a(paramInt, paramd);
    AppMethodBeat.o(207071);
    return this;
  }
  
  public final void fhv()
  {
    AppMethodBeat.i(207074);
    this.HUN = new j.b(getContext());
    AppMethodBeat.o(207074);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(207070);
    if (this.mContext == null)
    {
      this.mContext = l.a.fhx().getApplicationContext();
      l.checkNotNull(this.mContext, "Context should not be null");
    }
    Context localContext = this.mContext;
    AppMethodBeat.o(207070);
    return localContext;
  }
  
  public final void unregister()
  {
    AppMethodBeat.i(207072);
    if (this.HUN != null) {
      this.HUN.finish();
    }
    AppMethodBeat.o(207072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.k
 * JD-Core Version:    0.7.0.1
 */