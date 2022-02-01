package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.k.h;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "CONTACT_PAGE", "TIMELINE_LIKE", "TIMELINE_DETAIL", "TIMELINE_COMMENT", "TIMELINE_USER_HEAD", "CHATTING_ROOM", "MESSAGE_PAGE", "Companion", "plugin-story_release"})
public enum d$b
{
  public static final a AIL;
  private static final Map<Integer, b> map;
  private final int value;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(118599);
    Object localObject1 = new b("DEFAULT", 0, -1);
    AIC = (b)localObject1;
    Object localObject2 = new b("CONTACT_PAGE", 1, 0);
    AID = (b)localObject2;
    b localb1 = new b("TIMELINE_LIKE", 2, 1);
    AIE = localb1;
    b localb2 = new b("TIMELINE_DETAIL", 3, 2);
    AIF = localb2;
    b localb3 = new b("TIMELINE_COMMENT", 4, 3);
    AIG = localb3;
    b localb4 = new b("TIMELINE_USER_HEAD", 5, 4);
    AIH = localb4;
    b localb5 = new b("CHATTING_ROOM", 6, 5);
    AII = localb5;
    b localb6 = new b("MESSAGE_PAGE", 7, 6);
    AIJ = localb6;
    AIK = new b[] { localObject1, localObject2, localb1, localb2, localb3, localb4, localb5, localb6 };
    AIL = new a((byte)0);
    localObject1 = values();
    localObject2 = (Map)new LinkedHashMap(h.lp(ae.aji(localObject1.length), 16));
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
  
  private d$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType$Companion;", "", "()V", "map", "", "", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "fromInt", "type", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.d.b
 * JD-Core Version:    0.7.0.1
 */