package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.plugin.story.c.a.a;
import com.tencent.mm.plugin.story.c.a.b;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "()V", "DEFAULT_VALUE", "TAG", "", "getTAG", "()Ljava/lang/String;", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadDebugConfig", "", "loadServerConfig", "update", "parse", "StoryProcessType", "plugin-story_release"})
public final class g
  extends b<a>
{
  private static final String TAG = "MicroMsg.StoryProcessElementConfig";
  private static final a zqW;
  public static final g zqX;
  
  static
  {
    AppMethodBeat.i(118617);
    zqX = new g();
    TAG = "MicroMsg.StoryProcessElementConfig";
    zqW = a.zqZ;
    AppMethodBeat.o(118617);
  }
  
  public final void aqo()
  {
    AppMethodBeat.i(118616);
    ac.i(TAG, "loadDebugConfig false ");
    Object localObject = aw.aKT(a.b.zqz.name()).getString(a.a.zqt.name(), zqW.name());
    if (localObject == null) {
      k.fOy();
    }
    k.g(localObject, "mmkv.getString(getElemen…me, DEFAULT_VALUE.name)!!");
    bH(a.valueOf((String)localObject));
    int i = U("StoryBackgroundRemux", 0);
    int j;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = a.zqZ;
        bH(localObject);
      }
    }
    else
    {
      j = ae.fJl.fHV;
      if (j != -1) {
        if (j != 1) {
          break label170;
        }
      }
    }
    label170:
    for (localObject = a.zqZ;; localObject = a.zqY)
    {
      bH(localObject);
      ac.i(TAG, "loadServerConfig : " + (a)aqm() + ", serverConfig:" + i + ", deviceConfig:" + j);
      AppMethodBeat.o(118616);
      return;
      localObject = a.zqY;
      break;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FORWARD", "BACKGROUND", "plugin-story_release"})
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(118613);
      a locala1 = new a("FORWARD", 0, 0);
      zqY = locala1;
      a locala2 = new a("BACKGROUND", 1, 1);
      zqZ = locala2;
      zra = new a[] { locala1, locala2 };
      AppMethodBeat.o(118613);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.g
 * JD-Core Version:    0.7.0.1
 */