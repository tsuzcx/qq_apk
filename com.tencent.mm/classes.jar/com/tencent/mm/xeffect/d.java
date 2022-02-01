package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/xeffect/XEffectFileUtils;", "", "()V", "TAG", "", "alignmentName", "coreModelName", "coreParamName", "detectName", "gestureClsName", "gestureDetName", "imageLabelName", "segName", "trackName", "checkAssetsMatch", "", "localMd5", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "copyModelFiles", "context", "Landroid/content/Context;", "output", "getAssetsMD5", "renderlib_release"})
public final class d
{
  public static final d LYD;
  private static final String TAG = "XEffectFileUtils";
  
  static
  {
    AppMethodBeat.i(217077);
    LYD = new d();
    TAG = "XEffectFileUtils";
    AppMethodBeat.o(217077);
  }
  
  public static boolean bav(String paramString)
  {
    AppMethodBeat.i(217076);
    p.h(paramString, "localMd5");
    boolean bool = p.i("b5e3b65978452dee9add4e235e240a35", paramString);
    AppMethodBeat.o(217076);
    return bool;
  }
  
  public static String fWS()
  {
    return "b5e3b65978452dee9add4e235e240a35";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.xeffect.d
 * JD-Core Version:    0.7.0.1
 */