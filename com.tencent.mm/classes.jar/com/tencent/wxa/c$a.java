package com.tencent.wxa;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.c.a.a;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashSet;

public final class c$a
{
  public static final String DEFAULT_BACKGROUND_MODE;
  public FlutterView.RenderMode aidA;
  private HashSet<b> aidB;
  public a.a aidC;
  public HashSet<FlutterPlugin> aidD;
  public Boolean aidE;
  public Boolean aidF;
  public Boolean aidG;
  public Boolean aidH;
  public String dartEntrypoint;
  public FlutterShellArgs efF;
  public String initialRoute;
  private Context mAppContext;
  
  static
  {
    AppMethodBeat.i(210503);
    DEFAULT_BACKGROUND_MODE = FlutterActivityLaunchConfigs.BackgroundMode.opaque.name();
    AppMethodBeat.o(210503);
  }
  
  public c$a(Context paramContext)
  {
    AppMethodBeat.i(210466);
    this.dartEntrypoint = "main";
    this.initialRoute = "/";
    this.aidA = FlutterView.RenderMode.texture;
    this.efF = new FlutterShellArgs(new String[0]);
    this.aidB = new HashSet();
    this.aidD = new HashSet();
    this.aidE = Boolean.TRUE;
    this.aidF = Boolean.FALSE;
    this.aidG = Boolean.TRUE;
    this.aidH = Boolean.FALSE;
    this.mAppContext = paramContext;
    AppMethodBeat.o(210466);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(210509);
    if (!this.aidB.contains(paramb)) {
      this.aidB.add(paramb);
    }
    AppMethodBeat.o(210509);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.c.a
 * JD-Core Version:    0.7.0.1
 */