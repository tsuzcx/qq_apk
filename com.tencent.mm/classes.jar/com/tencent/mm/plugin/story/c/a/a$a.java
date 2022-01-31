package com.tencent.mm.plugin.story.c.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.f.a;
import java.util.HashSet;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-story_release"})
public final class a$a
{
  final String regex;
  final HashSet<f.a> srA;
  boolean srB;
  boolean srC;
  boolean srD;
  public boolean srE;
  public boolean srF;
  public boolean srG;
  boolean srH;
  public boolean srI;
  int srJ;
  public int srK;
  private int srL;
  public boolean srM;
  public int srN;
  public int srO;
  
  private a$a()
  {
    AppMethodBeat.i(108946);
    this.srL = 2;
    this.srM = true;
    this.srN = 0;
    this.srO = 0;
    this.srA = new HashSet();
    this.regex = "#冒泡#";
    this.srH = true;
    this.srJ = 15552000;
    this.srK = 10;
    AppMethodBeat.o(108946);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof a)) {
        break label105;
      }
      paramObject = (a)paramObject;
      if (this.srL != paramObject.srL) {
        break label107;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label105;
      }
      if (this.srM != paramObject.srM) {
        break label112;
      }
      i = 1;
      label56:
      bool1 = bool2;
      if (i == 0) {
        break label105;
      }
      if (this.srN != paramObject.srN) {
        break label117;
      }
      i = 1;
      label76:
      bool1 = bool2;
      if (i == 0) {
        break label105;
      }
      if (this.srO != paramObject.srO) {
        break label122;
      }
    }
    label105:
    label107:
    label112:
    label117:
    label122:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      i = 0;
      break label56;
      i = 0;
      break label76;
    }
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108947);
    String str = "StoryBasicConfig(repeatMD5=" + this.srL + ", showMusicIcon=" + this.srM + ", albumThumbHeight=" + this.srN + ", albumThumbWidth=" + this.srO + ")";
    AppMethodBeat.o(108947);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */