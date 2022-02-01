package com.tencent.smtt.sandbox;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ContextUtils
{
  private static final String TAG = "ContextUtils";
  private static Context sApplicationContext;
  
  public static Context getApplicationContext()
  {
    return sApplicationContext;
  }
  
  public static void initApplicationContext(Context paramContext)
  {
    AppMethodBeat.i(53785);
    if ((sApplicationContext != null) && (sApplicationContext != paramContext))
    {
      paramContext = new RuntimeException("Attempting to set multiple global application contexts.");
      AppMethodBeat.o(53785);
      throw paramContext;
    }
    initJavaSideApplicationContext(paramContext);
    AppMethodBeat.o(53785);
  }
  
  private static void initJavaSideApplicationContext(Context paramContext)
  {
    AppMethodBeat.i(53786);
    if (paramContext == null)
    {
      paramContext = new RuntimeException("Global application context cannot be set to null.");
      AppMethodBeat.o(53786);
      throw paramContext;
    }
    sApplicationContext = paramContext;
    AppMethodBeat.o(53786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sandbox.ContextUtils
 * JD-Core Version:    0.7.0.1
 */