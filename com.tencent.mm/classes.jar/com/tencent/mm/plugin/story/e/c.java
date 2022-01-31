package com.tencent.mm.plugin.story.e;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/data/StoryUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class c
{
  private static final String TAG = "MicroMsg.StoryUtil";
  private static final String rby = "storyb";
  private static final String ssA = "story_respone_count";
  public static final c.a ssB;
  private static final String ssy = "Locall_path";
  private static final float ssz = -1000.0F;
  
  static
  {
    AppMethodBeat.i(108997);
    ssB = new c.a((byte)0);
    TAG = "MicroMsg.StoryUtil";
    ssy = "Locall_path";
    ssz = -1000.0F;
    rby = "storyb";
    ssA = "story_respone_count";
    AppMethodBeat.o(108997);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "", "width", "", "height", "duration", "rotate", "videoBitrate", "fps", "matchScreenRatio", "", "(IIIIIIZ)V", "getDuration", "()I", "getFps", "getHeight", "getMatchScreenRatio", "()Z", "getRotate", "getVideoBitrate", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-story_release"})
  public static final class a$a
  {
    public final int duration;
    public final int fps;
    public final int height;
    public final int rotate;
    public final boolean ssC;
    public final int videoBitrate;
    public final int width;
    
    public a$a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.duration = paramInt3;
      this.rotate = paramInt4;
      this.videoBitrate = paramInt5;
      this.fps = paramInt6;
      this.ssC = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (this != paramObject)
      {
        bool1 = bool2;
        if (!(paramObject instanceof a)) {
          break label165;
        }
        paramObject = (a)paramObject;
        if (this.width != paramObject.width) {
          break label167;
        }
        i = 1;
        bool1 = bool2;
        if (i == 0) {
          break label165;
        }
        if (this.height != paramObject.height) {
          break label172;
        }
        i = 1;
        label56:
        bool1 = bool2;
        if (i == 0) {
          break label165;
        }
        if (this.duration != paramObject.duration) {
          break label177;
        }
        i = 1;
        label76:
        bool1 = bool2;
        if (i == 0) {
          break label165;
        }
        if (this.rotate != paramObject.rotate) {
          break label182;
        }
        i = 1;
        label96:
        bool1 = bool2;
        if (i == 0) {
          break label165;
        }
        if (this.videoBitrate != paramObject.videoBitrate) {
          break label187;
        }
        i = 1;
        label116:
        bool1 = bool2;
        if (i == 0) {
          break label165;
        }
        if (this.fps != paramObject.fps) {
          break label192;
        }
        i = 1;
        label136:
        bool1 = bool2;
        if (i == 0) {
          break label165;
        }
        if (this.ssC != paramObject.ssC) {
          break label197;
        }
      }
      label165:
      label167:
      label172:
      label177:
      label182:
      label187:
      label192:
      label197:
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
        i = 0;
        break label96;
        i = 0;
        break label116;
        i = 0;
        break label136;
      }
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(108993);
      String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", rotate=" + this.rotate + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", matchScreenRatio=" + this.ssC + ")";
      AppMethodBeat.o(108993);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.c
 * JD-Core Version:    0.7.0.1
 */