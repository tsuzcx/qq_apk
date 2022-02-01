package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.plugin.story.c.a.a;
import com.tencent.mm.plugin.story.c.a.b;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "()V", "DEFAULT_VALUE", "TAG", "", "getTAG", "()Ljava/lang/String;", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadDebugConfig", "", "loadServerConfig", "update", "parse", "StoryProcessType", "plugin-story_release"})
public final class g
  extends b<a>
{
  private static final String TAG = "MicroMsg.StoryProcessElementConfig";
  private static final a ydW;
  public static final g ydX;
  
  static
  {
    AppMethodBeat.i(118617);
    ydX = new g();
    TAG = "MicroMsg.StoryProcessElementConfig";
    ydW = a.ydZ;
    AppMethodBeat.o(118617);
  }
  
  public final void ajo()
  {
    AppMethodBeat.i(118616);
    ad.i(TAG, "loadDebugConfig false ");
    Object localObject = ax.aFC(a.b.ydz.name()).getString(a.a.ydt.name(), ydW.name());
    if (localObject == null) {
      k.fvU();
    }
    k.g(localObject, "mmkv.getString(getElemen…me, DEFAULT_VALUE.name)!!");
    bJ(a.valueOf((String)localObject));
    int i = P("StoryBackgroundRemux", 0);
    int j;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = a.ydZ;
        bJ(localObject);
      }
    }
    else
    {
      j = ae.fFE.fEo;
      if (j != -1) {
        if (j != 1) {
          break label170;
        }
      }
    }
    label170:
    for (localObject = a.ydZ;; localObject = a.ydY)
    {
      bJ(localObject);
      ad.i(TAG, "loadServerConfig : " + (a)ajm() + ", serverConfig:" + i + ", deviceConfig:" + j);
      AppMethodBeat.o(118616);
      return;
      localObject = a.ydY;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FORWARD", "BACKGROUND", "plugin-story_release"})
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(118613);
      a locala1 = new a("FORWARD", 0, 0);
      ydY = locala1;
      a locala2 = new a("BACKGROUND", 1, 1);
      ydZ = locala2;
      yea = new a[] { locala1, locala2 };
      AppMethodBeat.o(118613);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.g
 * JD-Core Version:    0.7.0.1
 */