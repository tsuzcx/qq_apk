package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/XEffectFileUtils;", "", "()V", "OpenCLCNNLibPath", "", "TAG", "imageLabelName", "checkAssetsMatch", "", "localMd5", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "copyModelFiles", "context", "Landroid/content/Context;", "output", "getAssetsMD5", "renderlib_release"})
public final class d
{
  private static final String TAG = "XEffectFileUtils";
  public static final d YZr;
  
  static
  {
    AppMethodBeat.i(195658);
    YZr = new d();
    TAG = "XEffectFileUtils";
    AppMethodBeat.o(195658);
  }
  
  public static boolean bCA(String paramString)
  {
    AppMethodBeat.i(195653);
    p.k(paramString, "localMd5");
    boolean bool = p.h("5da8e92f66b5f960e6788f3a30ff352b", paramString);
    AppMethodBeat.o(195653);
    return bool;
  }
  
  public static String ijY()
  {
    return "5da8e92f66b5f960e6788f3a30ff352b";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.d
 * JD-Core Version:    0.7.0.1
 */