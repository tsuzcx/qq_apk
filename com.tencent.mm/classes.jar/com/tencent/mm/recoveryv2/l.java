package com.tencent.mm.recoveryv2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class l
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile l UPT;
  private k UPU;
  private final Map<String, e> UPV;
  private Context mContext;
  
  private l()
  {
    AppMethodBeat.i(190400);
    this.UPV = new HashMap();
    AppMethodBeat.o(190400);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(190405);
    if (this.mContext == null)
    {
      if (m.a.jxU == null) {
        m.a.jxU = m.a.getApplication();
      }
      this.mContext = m.a.jxU.getApplicationContext();
      if (this.mContext == null)
      {
        localObject = new RuntimeException(String.valueOf("Context should not be null"));
        AppMethodBeat.o(190405);
        throw ((Throwable)localObject);
      }
    }
    Object localObject = this.mContext;
    AppMethodBeat.o(190405);
    return localObject;
  }
  
  public static l hqR()
  {
    AppMethodBeat.i(190398);
    if (UPT == null) {}
    try
    {
      if (UPT == null) {
        UPT = new l();
      }
      l locall = UPT;
      AppMethodBeat.o(190398);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(190398);
    }
  }
  
  private void hqS()
  {
    AppMethodBeat.i(190426);
    this.UPU = new k.b(getContext());
    AppMethodBeat.o(190426);
  }
  
  public static String hqU()
  {
    return ":recovery";
  }
  
  public static boolean jW(Context paramContext)
  {
    AppMethodBeat.i(292733);
    boolean bool = m.cF(paramContext, "");
    AppMethodBeat.o(292733);
    return bool;
  }
  
  public static boolean jX(Context paramContext)
  {
    AppMethodBeat.i(190435);
    boolean bool = m.cF(paramContext, ":recovery");
    AppMethodBeat.o(190435);
    return bool;
  }
  
  public final void OO()
  {
    AppMethodBeat.i(190416);
    if (!m.cF(getContext(), ""))
    {
      a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
      AppMethodBeat.o(190416);
      return;
    }
    if (!i.a.jQ(getContext()).mEnabled)
    {
      a.a.log(4, "MicroMsg.recovery", "Recovery is disabled, skip");
      AppMethodBeat.o(190416);
      return;
    }
    if (this.UPU == null) {
      hqS();
    }
    this.UPU.begin();
    AppMethodBeat.o(190416);
  }
  
  public final void a(String paramString, e parame)
  {
    AppMethodBeat.i(190427);
    try
    {
      if (this.UPV.containsKey(paramString))
      {
        paramString = new IllegalArgumentException(paramString + " has been registered! target = " + this.UPV.get(paramString));
        AppMethodBeat.o(190427);
        throw paramString;
      }
    }
    catch (Throwable paramString)
    {
      a.w("MicroMsg.recovery", "register actions fail", paramString);
      AppMethodBeat.o(190427);
      return;
    }
    parame.hpS();
    this.UPV.put(paramString, parame);
    AppMethodBeat.o(190427);
  }
  
  public final void arP(int paramInt)
  {
    AppMethodBeat.i(190423);
    if (!m.cF(getContext(), ""))
    {
      a.a.log(4, "MicroMsg.recovery", "not main proc, skip");
      AppMethodBeat.o(190423);
      return;
    }
    if ((this.UPU instanceof k.e))
    {
      ((k.e)this.UPU).arM(paramInt);
      AppMethodBeat.o(190423);
      return;
    }
    if ((this.UPU instanceof k.b))
    {
      ((k.b)this.UPU).arL(paramInt);
      AppMethodBeat.o(190423);
      return;
    }
    new k.e(getContext()).arM(paramInt);
    AppMethodBeat.o(190423);
  }
  
  public final l b(int paramInt, d paramd)
  {
    AppMethodBeat.i(190412);
    if (this.UPU == null) {
      hqS();
    }
    this.UPU.a(paramInt, paramd);
    AppMethodBeat.o(190412);
    return this;
  }
  
  public final l b(b paramb)
  {
    AppMethodBeat.i(190409);
    if (this.UPU == null) {
      hqS();
    }
    this.UPU.a(paramb);
    AppMethodBeat.o(190409);
    return this;
  }
  
  public final Map<String, e> hqT()
  {
    return this.UPV;
  }
  
  public final l jV(Context paramContext)
  {
    if (paramContext != null) {
      this.mContext = paramContext;
    }
    return this;
  }
  
  public final void unregister()
  {
    AppMethodBeat.i(190417);
    if (this.UPU != null) {
      this.UPU.finish();
    }
    AppMethodBeat.o(190417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.l
 * JD-Core Version:    0.7.0.1
 */