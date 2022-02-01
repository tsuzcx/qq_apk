package com.tencent.smtt.export.external.X5Graphics;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class X5Graphics
{
  private static final boolean sIsEnable = true;
  
  public static boolean init(Context paramContext, String paramString)
  {
    AppMethodBeat.i(53171);
    boolean bool = GraphicsLib.init(paramContext, paramString, null, null);
    AppMethodBeat.o(53171);
    return bool;
  }
  
  public static boolean init(Context paramContext, String paramString, IBeacon paramIBeacon)
  {
    AppMethodBeat.i(53173);
    boolean bool = GraphicsLib.init(paramContext, paramString, null, paramIBeacon);
    AppMethodBeat.o(53173);
    return bool;
  }
  
  public static boolean init(Context paramContext, String paramString, SoThinker paramSoThinker)
  {
    AppMethodBeat.i(53172);
    boolean bool = GraphicsLib.init(paramContext, paramString, paramSoThinker, null);
    AppMethodBeat.o(53172);
    return bool;
  }
  
  public static boolean init(Context paramContext, String paramString, SoThinker paramSoThinker, IBeacon paramIBeacon)
  {
    AppMethodBeat.i(53174);
    boolean bool = GraphicsLib.init(paramContext, paramString, paramSoThinker, paramIBeacon);
    AppMethodBeat.o(53174);
    return bool;
  }
  
  public static boolean isEnable()
  {
    return true;
  }
  
  public static abstract class IBeacon
  {
    public abstract void report(String paramString, HashMap<String, String> paramHashMap);
  }
  
  public static abstract class SoThinker
  {
    public abstract String path(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.X5Graphics.X5Graphics
 * JD-Core Version:    0.7.0.1
 */