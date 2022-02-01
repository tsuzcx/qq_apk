package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.scanlib.b;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanDebugUtil;", "", "()V", "DEFAULT_NO_RECOGNIZE_CODE_DURATION", "", "TAG", "", "checkQBarAIModeFile", "", "getCheckQBarAIModeFile", "()Z", "checkQBarAIModeFile$delegate", "Lkotlin/Lazy;", "codeNoRecognizeDuration", "getCodeNoRecognizeDuration", "()I", "codeNoRecognizeDuration$delegate", "loadSoFromSDCard", "getLoadSoFromSDCard", "setLoadSoFromSDCard", "(Z)V", "localConfig", "getLocalConfig", "()Ljava/lang/String;", "setLocalConfig", "(Ljava/lang/String;)V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "qBarAIModeFileIsChecked", "getQBarAIModeFileIsChecked", "setQBarAIModeFileIsChecked", "showDebugView", "useXnet", "getUseXnet", "useXnet$delegate", "canDebug", "getNoRecognizeDuration", "getQBarBackend", "init", "", "setQBarBackend", "context", "Landroid/content/Context;", "shouldCheckQBarAIModelFile", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static boolean PiA;
  private static boolean PiB;
  private static String PiC;
  private static final j PiD;
  private static final j PiE;
  private static final j PiF;
  private static boolean PiG;
  public static final e Piz;
  private static MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(314196);
    Piz = new e();
    Object localObject = h.PiL;
    PiB = MultiProcessMMKV.getSingleMMKV("ScanDebug").getBoolean("loadSoFromSDCard", false);
    localObject = h.PiL;
    String str = MultiProcessMMKV.getSingleMMKV("ScanDebug").getString("debugFFEngineConfig", "");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    PiC = (String)localObject;
    PiD = k.cm((a)c.PiJ);
    PiE = k.cm((a)a.PiH);
    PiF = k.cm((a)b.PiI);
    AppMethodBeat.o(314196);
  }
  
  public static final boolean gTR()
  {
    AppMethodBeat.i(314135);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(314135);
      return true;
    }
    AppMethodBeat.o(314135);
    return false;
  }
  
  public static final boolean gTS()
  {
    return PiA;
  }
  
  private static boolean gTT()
  {
    AppMethodBeat.i(314141);
    boolean bool = ((Boolean)PiD.getValue()).booleanValue();
    AppMethodBeat.o(314141);
    return bool;
  }
  
  private static boolean gTU()
  {
    AppMethodBeat.i(314146);
    boolean bool = ((Boolean)PiE.getValue()).booleanValue();
    AppMethodBeat.o(314146);
    return bool;
  }
  
  private static int gTV()
  {
    AppMethodBeat.i(314154);
    int i = ((Number)PiF.getValue()).intValue();
    AppMethodBeat.o(314154);
    return i;
  }
  
  public static final int gTW()
  {
    AppMethodBeat.i(314160);
    Log.i("MicroMsg.ScanDebugUtil", s.X("getNoRecognizeDuration:", Integer.valueOf(gTV())));
    int i = gTV();
    AppMethodBeat.o(314160);
    return i;
  }
  
  public static final int gTX()
  {
    AppMethodBeat.i(314172);
    if (gTT())
    {
      AppMethodBeat.o(314172);
      return 1;
    }
    AppMethodBeat.o(314172);
    return 0;
  }
  
  public static final boolean gTY()
  {
    AppMethodBeat.i(314181);
    if (PiG)
    {
      Log.w("MicroMsg.ScanDebugUtil", "shouldCheckQBarAIModelFile isChecked, do not check again");
      AppMethodBeat.o(314181);
      return false;
    }
    PiG = true;
    Log.i("MicroMsg.ScanDebugUtil", s.X("shouldCheckQBarAIModelFile checkQBarAIModeFile:", Boolean.valueOf(gTU())));
    boolean bool = gTU();
    AppMethodBeat.o(314181);
    return bool;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(314129);
    boolean bool = gTR();
    if (!bool)
    {
      AppMethodBeat.o(314129);
      return;
    }
    eMf = MultiProcessMMKV.getMMKV("ScanDebug");
    MultiProcessMMKV localMultiProcessMMKV;
    if (bool)
    {
      localMultiProcessMMKV = eMf;
      if (localMultiProcessMMKV == null)
      {
        bool = false;
        if (!bool) {
          break label88;
        }
      }
    }
    label88:
    for (bool = true;; bool = false)
    {
      PiA = bool;
      Log.i("MicroMsg.ScanDebugUtil", "alvinluo ScanDebugUtil init showDebugView %b", new Object[] { Boolean.valueOf(PiA) });
      AppMethodBeat.o(314129);
      return;
      bool = localMultiProcessMMKV.getBoolean("scan_debug_show_debug_view", false);
      break;
    }
  }
  
  public static final void jB(Context paramContext)
  {
    AppMethodBeat.i(314167);
    s.u(paramContext, "context");
    if (gTT())
    {
      b.bG(paramContext, 1);
      AppMethodBeat.o(314167);
      return;
    }
    b.bG(paramContext, 0);
    AppMethodBeat.o(314167);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Boolean>
  {
    public static final a PiH;
    
    static
    {
      AppMethodBeat.i(314191);
      PiH = new a();
      AppMethodBeat.o(314191);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Integer>
  {
    public static final b PiI;
    
    static
    {
      AppMethodBeat.i(314183);
      PiI = new b();
      AppMethodBeat.o(314183);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Boolean>
  {
    public static final c PiJ;
    
    static
    {
      AppMethodBeat.i(314192);
      PiJ = new c();
      AppMethodBeat.o(314192);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e
 * JD-Core Version:    0.7.0.1
 */