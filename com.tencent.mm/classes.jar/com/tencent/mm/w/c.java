package com.tencent.mm.w;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public Runnable callback;
  public Context context;
  public String fTN;
  public String fTO;
  public Object fTP;
  public Object result;
  
  public final <T> T qa(String paramString)
  {
    AppMethodBeat.i(159065);
    if (this.fTP == null)
    {
      AppMethodBeat.o(159065);
      return null;
    }
    if ((this.fTP instanceof Map))
    {
      paramString = ((Map)this.fTP).get(paramString);
      AppMethodBeat.o(159065);
      return paramString;
    }
    if ((this.fTP instanceof JSONObject))
    {
      paramString = ((JSONObject)this.fTP).opt(paramString);
      AppMethodBeat.o(159065);
      return paramString;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(159065);
    throw paramString;
  }
  
  public final boolean qb(String paramString)
  {
    AppMethodBeat.i(159066);
    if (this.fTP == null)
    {
      AppMethodBeat.o(159066);
      return false;
    }
    boolean bool;
    if ((this.fTP instanceof Map))
    {
      bool = ((Map)this.fTP).containsKey(paramString);
      AppMethodBeat.o(159066);
      return bool;
    }
    if ((this.fTP instanceof JSONObject))
    {
      bool = ((JSONObject)this.fTP).has(paramString);
      AppMethodBeat.o(159066);
      return bool;
    }
    paramString = new ClassCastException();
    AppMethodBeat.o(159066);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.c
 * JD-Core Version:    0.7.0.1
 */