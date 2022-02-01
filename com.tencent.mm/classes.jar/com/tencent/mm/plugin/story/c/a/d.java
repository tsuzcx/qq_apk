package com.tencent.mm.plugin.story.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.c.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"})
public final class d
  extends b<d.a>
{
  public static final d AIB;
  
  static
  {
    AppMethodBeat.i(118605);
    AIB = new d();
    AppMethodBeat.o(118605);
  }
  
  public static boolean aBv(String paramString)
  {
    AppMethodBeat.i(118602);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(118602);
      return false;
    }
    if ((!w.zs(paramString)) && (!w.zE(paramString)) && (!w.zv(paramString)) && (!w.zA(paramString)) && (!w.zH(paramString)) && (!w.zI(paramString)) && (!w.Ai(paramString)) && (!w.An(paramString)) && (!w.Ap(paramString)) && (!w.zT(paramString)) && (!w.zl(paramString)) && (!w.zk(paramString)))
    {
      AppMethodBeat.o(118602);
      return true;
    }
    AppMethodBeat.o(118602);
    return false;
  }
  
  public final void atd()
  {
    AppMethodBeat.i(118604);
    ((d.a)atb()).clear();
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118604);
      return;
    }
    ((d.a)atb()).add(d.b.AID);
    ((d.a)atb()).add(d.b.AIE);
    ((d.a)atb()).add(d.b.AIF);
    ((d.a)atb()).add(d.b.AIG);
    ((d.a)atb()).add(d.b.AIH);
    ((d.a)atb()).add(d.b.AIJ);
    ((d.a)atb()).add(d.b.AII);
    AppMethodBeat.o(118604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.d
 * JD-Core Version:    0.7.0.1
 */