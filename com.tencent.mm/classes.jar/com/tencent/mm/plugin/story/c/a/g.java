package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.story.c.a.a;
import com.tencent.mm.plugin.story.c.a.b;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "()V", "DEFAULT_VALUE", "TAG", "", "getTAG", "()Ljava/lang/String;", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadDebugConfig", "", "loadServerConfig", "update", "parse", "StoryProcessType", "plugin-story_release"})
public final class g
  extends b<a>
{
  private static final a LFt;
  public static final g LFu;
  private static final String TAG = "MicroMsg.StoryProcessElementConfig";
  
  static
  {
    AppMethodBeat.i(118617);
    LFu = new g();
    TAG = "MicroMsg.StoryProcessElementConfig";
    LFt = a.LFw;
    AppMethodBeat.o(118617);
  }
  
  public final void aTZ()
  {
    AppMethodBeat.i(118616);
    Log.i(TAG, "loadDebugConfig false ");
    Object localObject = MultiProcessMMKV.getMMKV(a.b.LEW.name()).getString(a.a.LEQ.name(), LFt.name());
    if (localObject == null) {
      p.iCn();
    }
    p.j(localObject, "mmkv.getString(getElemen…me, DEFAULT_VALUE.name)!!");
    bS(a.valueOf((String)localObject));
    int i = at("StoryBackgroundRemux", 0);
    int j;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = a.LFw;
        bS(localObject);
      }
    }
    else
    {
      j = af.juP.jtt;
      if (j != -1) {
        if (j != 1) {
          break label170;
        }
      }
    }
    label170:
    for (localObject = a.LFw;; localObject = a.LFv)
    {
      bS(localObject);
      Log.i(TAG, "loadServerConfig : " + (a)aTX() + ", serverConfig:" + i + ", deviceConfig:" + j);
      AppMethodBeat.o(118616);
      return;
      localObject = a.LFv;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FORWARD", "BACKGROUND", "plugin-story_release"})
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(118613);
      a locala1 = new a("FORWARD", 0, 0);
      LFv = locala1;
      a locala2 = new a("BACKGROUND", 1, 1);
      LFw = locala2;
      LFx = new a[] { locala1, locala2 };
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