package com.tencent.mm.plugin.story.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.c.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"})
public final class d
  extends b<d.a>
{
  public static final d zqH;
  
  static
  {
    AppMethodBeat.i(118605);
    zqH = new d();
    AppMethodBeat.o(118605);
  }
  
  public static boolean awq(String paramString)
  {
    AppMethodBeat.i(118602);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(118602);
      return false;
    }
    if ((!w.ww(paramString)) && (!w.wH(paramString)) && (!w.wz(paramString)) && (!w.wD(paramString)) && (!w.wK(paramString)) && (!w.wL(paramString)) && (!w.xl(paramString)) && (!w.xq(paramString)) && (!w.xr(paramString)) && (!w.wW(paramString)) && (!w.wq(paramString)) && (!w.wp(paramString)))
    {
      AppMethodBeat.o(118602);
      return true;
    }
    AppMethodBeat.o(118602);
    return false;
  }
  
  public final void aqo()
  {
    AppMethodBeat.i(118604);
    ((d.a)aqm()).clear();
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118604);
      return;
    }
    ((d.a)aqm()).add(d.b.zqJ);
    ((d.a)aqm()).add(d.b.zqK);
    ((d.a)aqm()).add(d.b.zqL);
    ((d.a)aqm()).add(d.b.zqM);
    ((d.a)aqm()).add(d.b.zqN);
    ((d.a)aqm()).add(d.b.zqP);
    ((d.a)aqm()).add(d.b.zqO);
    AppMethodBeat.o(118604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.d
 * JD-Core Version:    0.7.0.1
 */