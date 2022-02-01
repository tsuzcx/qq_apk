package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/XEffectFileUtils;", "", "()V", "OpenCLCNNLibPath", "", "TAG", "imageLabelName", "checkAssetsMatch", "", "localMd5", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "copyModelFiles", "context", "Landroid/content/Context;", "output", "getAssetsMD5", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class e
{
  private static final String TAG = "XEffectFileUtils";
  public static final e agXD;
  
  static
  {
    AppMethodBeat.i(234515);
    agXD = new e();
    TAG = "XEffectFileUtils";
    AppMethodBeat.o(234515);
  }
  
  public static boolean bEX(String paramString)
  {
    AppMethodBeat.i(234498);
    s.t(paramString, "localMd5");
    boolean bool = s.p("67107ab8f0a4142b305efda34b4fe687", paramString);
    AppMethodBeat.o(234498);
    return bool;
  }
  
  public static String jQg()
  {
    return "67107ab8f0a4142b305efda34b4fe687";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.xeffect.e
 * JD-Core Version:    0.7.0.1
 */