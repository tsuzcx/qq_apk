package com.tencent.mm.plugin.story.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.c.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"})
public final class d
  extends b<d.a>
{
  public static final d LFe;
  
  static
  {
    AppMethodBeat.i(118605);
    LFe = new d();
    AppMethodBeat.o(118605);
  }
  
  public static boolean bcO(String paramString)
  {
    AppMethodBeat.i(118602);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(118602);
      return false;
    }
    if ((!ab.PY(paramString)) && (!ab.Qm(paramString)) && (!ab.Qb(paramString)) && (!ab.Qi(paramString)) && (!ab.Qp(paramString)) && (!ab.Qq(paramString)) && (!ab.QQ(paramString)) && (!ab.QV(paramString)) && (!ab.QX(paramString)) && (!ab.QB(paramString)) && (!ab.PQ(paramString)) && (!ab.PP(paramString)))
    {
      AppMethodBeat.o(118602);
      return true;
    }
    AppMethodBeat.o(118602);
    return false;
  }
  
  public final void aTZ()
  {
    AppMethodBeat.i(118604);
    ((d.a)aTX()).clear();
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118604);
      return;
    }
    ((d.a)aTX()).add(b.LFg);
    ((d.a)aTX()).add(b.LFh);
    ((d.a)aTX()).add(b.LFi);
    ((d.a)aTX()).add(b.LFj);
    ((d.a)aTX()).add(b.LFk);
    ((d.a)aTX()).add(b.LFm);
    ((d.a)aTX()).add(b.LFl);
    AppMethodBeat.o(118604);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "CONTACT_PAGE", "TIMELINE_LIKE", "TIMELINE_DETAIL", "TIMELINE_COMMENT", "TIMELINE_USER_HEAD", "CHATTING_ROOM", "MESSAGE_PAGE", "Companion", "plugin-story_release"})
  public static enum b
  {
    public static final a LFo;
    private static final Map<Integer, b> map;
    private final int value;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(118599);
      Object localObject1 = new b("DEFAULT", 0, -1);
      LFf = (b)localObject1;
      Object localObject2 = new b("CONTACT_PAGE", 1, 0);
      LFg = (b)localObject2;
      b localb1 = new b("TIMELINE_LIKE", 2, 1);
      LFh = localb1;
      b localb2 = new b("TIMELINE_DETAIL", 3, 2);
      LFi = localb2;
      b localb3 = new b("TIMELINE_COMMENT", 4, 3);
      LFj = localb3;
      b localb4 = new b("TIMELINE_USER_HEAD", 5, 4);
      LFk = localb4;
      b localb5 = new b("CHATTING_ROOM", 6, 5);
      LFl = localb5;
      b localb6 = new b("MESSAGE_PAGE", 7, 6);
      LFm = localb6;
      LFn = new b[] { localObject1, localObject2, localb1, localb2, localb3, localb4, localb5, localb6 };
      LFo = new a((byte)0);
      localObject1 = values();
      localObject2 = (Map)new LinkedHashMap(i.ov(ae.aDD(localObject1.length), 16));
      int j = localObject1.length;
      while (i < j)
      {
        localb1 = localObject1[i];
        ((Map)localObject2).put(Integer.valueOf(localb1.value), localb1);
        i += 1;
      }
      map = (Map)localObject2;
      AppMethodBeat.o(118599);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType$Companion;", "", "()V", "map", "", "", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "fromInt", "type", "plugin-story_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.d
 * JD-Core Version:    0.7.0.1
 */