package com.tencent.mm.plugin.story.c.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.plugin.story.c.b.a;
import com.tencent.mm.plugin.story.c.b.b;
import com.tencent.mm.plugin.story.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "()V", "DEFAULT_VALUE", "TAG", "", "getTAG", "()Ljava/lang/String;", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadDebugConfig", "", "loadServerConfig", "update", "parse", "StoryProcessType", "plugin-story_release"})
public final class f
  extends c<f.a>
{
  private static final String TAG = "MicroMsg.StoryProcessElementConfig";
  private static final f.a ssg;
  public static final f ssh;
  
  static
  {
    AppMethodBeat.i(108985);
    ssh = new f();
    TAG = "MicroMsg.StoryProcessElementConfig";
    ssg = f.a.ssj;
    AppMethodBeat.o(108985);
  }
  
  public final void Uv()
  {
    AppMethodBeat.i(108984);
    ab.i(TAG, "loadDebugConfig false ");
    Object localObject = as.apq(b.b.srp.name()).getString(b.a.srk.name(), ssg.name());
    if (localObject == null) {
      j.ebi();
    }
    j.p(localObject, "mmkv.getString(getElemen…me, DEFAULT_VALUE.name)!!");
    aF(f.a.valueOf((String)localObject));
    int i = L("StoryBackgroundRemux", 0);
    int j;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = f.a.ssj;
        aF(localObject);
      }
    }
    else
    {
      j = ac.erC.eqW;
      if (j != -1) {
        if (j != 1) {
          break label170;
        }
      }
    }
    label170:
    for (localObject = f.a.ssj;; localObject = f.a.ssi)
    {
      aF(localObject);
      ab.i(TAG, "loadServerConfig : " + (f.a)Ut() + ", serverConfig:" + i + ", deviceConfig:" + j);
      AppMethodBeat.o(108984);
      return;
      localObject = f.a.ssi;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.f
 * JD-Core Version:    0.7.0.1
 */