package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/XEffectFileUtils;", "", "()V", "OpenCLCNNLibPath", "", "TAG", "imageLabelName", "checkAssetsMatch", "", "localMd5", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "copyModelFiles", "context", "Landroid/content/Context;", "output", "getAssetsMD5", "renderlib_release"})
public final class c
{
  public static final c RxL;
  private static final String TAG = "XEffectFileUtils";
  
  static
  {
    AppMethodBeat.i(237042);
    RxL = new c();
    TAG = "XEffectFileUtils";
    AppMethodBeat.o(237042);
  }
  
  public static boolean bpD(String paramString)
  {
    AppMethodBeat.i(237041);
    p.h(paramString, "localMd5");
    boolean bool = p.j("7d43ae8f98f974d41b4a30304f5aeefc", paramString);
    AppMethodBeat.o(237041);
    return bool;
  }
  
  public static String his()
  {
    return "7d43ae8f98f974d41b4a30304f5aeefc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.xeffect.c
 * JD-Core Version:    0.7.0.1
 */