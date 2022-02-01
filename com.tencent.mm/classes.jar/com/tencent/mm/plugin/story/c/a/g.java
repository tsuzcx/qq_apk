package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.story.c.a.a;
import com.tencent.mm.plugin.story.c.a.b;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "()V", "DEFAULT_VALUE", "TAG", "", "getTAG", "()Ljava/lang/String;", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadDebugConfig", "", "loadServerConfig", "update", "parse", "StoryProcessType", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends b<a>
{
  public static final g Sjf;
  private static final a Sjg;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118617);
    Sjf = new g();
    TAG = "MicroMsg.StoryProcessElementConfig";
    Sjg = a.Sji;
    AppMethodBeat.o(118617);
  }
  
  public final void boD()
  {
    AppMethodBeat.i(118616);
    Log.i(TAG, "loadDebugConfig false ");
    Object localObject = MultiProcessMMKV.getMMKV(a.b.SiH.name()).getString(a.a.SiB.name(), Sjg.name());
    s.checkNotNull(localObject);
    s.s(localObject, "mmkv.getString(getElemen…me, DEFAULT_VALUE.name)!!");
    dm(a.valueOf((String)localObject));
    int i = aC("StoryBackgroundRemux", 0);
    int j;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = a.Sji;
        dm(localObject);
      }
    }
    else
    {
      j = af.lYg.lWK;
      if (j != -1) {
        if (j != 1) {
          break label164;
        }
      }
    }
    label164:
    for (localObject = a.Sji;; localObject = a.Sjh)
    {
      dm(localObject);
      Log.i(TAG, "loadServerConfig : " + boB() + ", serverConfig:" + i + ", deviceConfig:" + j);
      AppMethodBeat.o(118616);
      return;
      localObject = a.Sjh;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FORWARD", "BACKGROUND", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(118613);
      Sjh = new a("FORWARD", 0, 0);
      Sji = new a("BACKGROUND", 1, 1);
      Sjj = new a[] { Sjh, Sji };
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