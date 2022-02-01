package com.tencent.mm.plugin.story.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.c.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"})
public final class d
  extends b<d.a>
{
  public static final d Bae;
  
  static
  {
    AppMethodBeat.i(118605);
    Bae = new d();
    AppMethodBeat.o(118605);
  }
  
  public static boolean aCO(String paramString)
  {
    AppMethodBeat.i(118602);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(118602);
      return false;
    }
    if ((!x.Ac(paramString)) && (!x.Ao(paramString)) && (!x.Af(paramString)) && (!x.Ak(paramString)) && (!x.Ar(paramString)) && (!x.As(paramString)) && (!x.AS(paramString)) && (!x.AX(paramString)) && (!x.AZ(paramString)) && (!x.AD(paramString)) && (!x.zV(paramString)) && (!x.zU(paramString)))
    {
      AppMethodBeat.o(118602);
      return true;
    }
    AppMethodBeat.o(118602);
    return false;
  }
  
  public final void ats()
  {
    AppMethodBeat.i(118604);
    ((d.a)atq()).clear();
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118604);
      return;
    }
    ((d.a)atq()).add(d.b.Bag);
    ((d.a)atq()).add(d.b.Bah);
    ((d.a)atq()).add(d.b.Bai);
    ((d.a)atq()).add(d.b.Baj);
    ((d.a)atq()).add(d.b.Bak);
    ((d.a)atq()).add(d.b.Bam);
    ((d.a)atq()).add(d.b.Bal);
    AppMethodBeat.o(118604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.d
 * JD-Core Version:    0.7.0.1
 */