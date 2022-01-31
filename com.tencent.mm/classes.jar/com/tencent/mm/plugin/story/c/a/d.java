package com.tencent.mm.plugin.story.c.a;

import a.l;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.c.c;
import java.util.HashSet;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"})
public final class d
  extends c<a>
{
  public static final d srT;
  
  static
  {
    AppMethodBeat.i(108978);
    srT = new d();
    AppMethodBeat.o(108978);
  }
  
  public static boolean acG(String paramString)
  {
    AppMethodBeat.i(108975);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(108975);
      return false;
    }
    if ((!t.nM(paramString)) && (!t.nU(paramString)) && (!t.nP(paramString)) && (!t.nQ(paramString)) && (!t.nX(paramString)) && (!t.nY(paramString)) && (!t.oy(paramString)) && (!t.oD(paramString)) && (!t.oj(paramString)) && (!t.nK(paramString)) && (!t.nJ(paramString)))
    {
      AppMethodBeat.o(108975);
      return true;
    }
    AppMethodBeat.o(108975);
    return false;
  }
  
  public final void Uv()
  {
    AppMethodBeat.i(108977);
    ((a)Ut()).clear();
    if (!n.isShowStoryCheck())
    {
      AppMethodBeat.o(108977);
      return;
    }
    ((a)Ut()).add(d.b.srV);
    ((a)Ut()).add(d.b.srW);
    ((a)Ut()).add(d.b.srX);
    ((a)Ut()).add(d.b.srY);
    ((a)Ut()).add(d.b.srZ);
    ((a)Ut()).add(d.b.ssb);
    ((a)Ut()).add(d.b.ssa);
    AppMethodBeat.o(108977);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "Lkotlin/collections/HashSet;", "()V", "plugin-story_release"})
  public static final class a
    extends HashSet<d.b>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.d
 * JD-Core Version:    0.7.0.1
 */