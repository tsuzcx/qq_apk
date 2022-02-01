package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/xeffect/XEffectFileUtils;", "", "()V", "TAG", "", "alignmentName", "coreModelName", "coreParamName", "detectName", "gestureClsName", "gestureDetName", "segName", "trackName", "checkAssetsMatch", "", "localMd5", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "copyModelFiles", "context", "Landroid/content/Context;", "output", "getAssetsMD5", "renderlib_release"})
public final class d
{
  public static final d LBD;
  private static final String TAG = "XEffectFileUtils";
  
  static
  {
    AppMethodBeat.i(220324);
    LBD = new d();
    TAG = "XEffectFileUtils";
    AppMethodBeat.o(220324);
  }
  
  public static boolean aYS(String paramString)
  {
    AppMethodBeat.i(220323);
    p.h(paramString, "localMd5");
    boolean bool = p.i("b200b9bf03c2c07db385ce2b1554f89b", paramString);
    AppMethodBeat.o(220323);
    return bool;
  }
  
  public static String fSt()
  {
    return "b200b9bf03c2c07db385ce2b1554f89b";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.xeffect.d
 * JD-Core Version:    0.7.0.1
 */