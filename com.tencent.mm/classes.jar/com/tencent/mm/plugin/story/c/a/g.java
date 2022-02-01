package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.plugin.story.c.a.a;
import com.tencent.mm.plugin.story.c.a.b;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "()V", "DEFAULT_VALUE", "TAG", "", "getTAG", "()Ljava/lang/String;", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadDebugConfig", "", "loadServerConfig", "update", "parse", "StoryProcessType", "plugin-story_release"})
public final class g
  extends b<a>
{
  private static final a AIQ;
  public static final g AIR;
  private static final String TAG = "MicroMsg.StoryProcessElementConfig";
  
  static
  {
    AppMethodBeat.i(118617);
    AIR = new g();
    TAG = "MicroMsg.StoryProcessElementConfig";
    AIQ = a.AIT;
    AppMethodBeat.o(118617);
  }
  
  public final void atd()
  {
    AppMethodBeat.i(118616);
    ad.i(TAG, "loadDebugConfig false ");
    Object localObject = ax.aQz(a.b.AIt.name()).getString(a.a.AIn.name(), AIQ.name());
    if (localObject == null) {
      p.gfZ();
    }
    p.g(localObject, "mmkv.getString(getElemen…me, DEFAULT_VALUE.name)!!");
    bJ(a.valueOf((String)localObject));
    int i = Y("StoryBackgroundRemux", 0);
    int j;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = a.AIT;
        bJ(localObject);
      }
    }
    else
    {
      j = ae.gcM.gbv;
      if (j != -1) {
        if (j != 1) {
          break label170;
        }
      }
    }
    label170:
    for (localObject = a.AIT;; localObject = a.AIS)
    {
      bJ(localObject);
      ad.i(TAG, "loadServerConfig : " + (a)atb() + ", serverConfig:" + i + ", deviceConfig:" + j);
      AppMethodBeat.o(118616);
      return;
      localObject = a.AIS;
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FORWARD", "BACKGROUND", "plugin-story_release"})
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(118613);
      a locala1 = new a("FORWARD", 0, 0);
      AIS = locala1;
      a locala2 = new a("BACKGROUND", 1, 1);
      AIT = locala2;
      AIU = new a[] { locala1, locala2 };
      AppMethodBeat.o(118613);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.g
 * JD-Core Version:    0.7.0.1
 */