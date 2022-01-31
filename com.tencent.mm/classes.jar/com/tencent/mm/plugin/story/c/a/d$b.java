package com.tencent.mm.plugin.story.c.a;

import a.a.ad;
import a.i.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "CONTACT_PAGE", "TIMELINE_LIKE", "TIMELINE_DETAIL", "TIMELINE_COMMENT", "TIMELINE_USER_HEAD", "CHATTING_ROOM", "MESSAGE_PAGE", "Companion", "plugin-story_release"})
public enum d$b
{
  private static final Map<Integer, b> map;
  public static final d.b.a ssd;
  private final int value;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(108972);
    Object localObject1 = new b("DEFAULT", 0, -1);
    srU = (b)localObject1;
    Object localObject2 = new b("CONTACT_PAGE", 1, 0);
    srV = (b)localObject2;
    b localb1 = new b("TIMELINE_LIKE", 2, 1);
    srW = localb1;
    b localb2 = new b("TIMELINE_DETAIL", 3, 2);
    srX = localb2;
    b localb3 = new b("TIMELINE_COMMENT", 4, 3);
    srY = localb3;
    b localb4 = new b("TIMELINE_USER_HEAD", 5, 4);
    srZ = localb4;
    b localb5 = new b("CHATTING_ROOM", 6, 5);
    ssa = localb5;
    b localb6 = new b("MESSAGE_PAGE", 7, 6);
    ssb = localb6;
    ssc = new b[] { localObject1, localObject2, localb1, localb2, localb3, localb4, localb5, localb6 };
    ssd = new d.b.a((byte)0);
    localObject1 = values();
    localObject2 = (Map)new LinkedHashMap(e.iE(ad.TQ(localObject1.length), 16));
    int j = localObject1.length;
    while (i < j)
    {
      localb1 = localObject1[i];
      ((Map)localObject2).put(Integer.valueOf(localb1.value), localb1);
      i += 1;
    }
    map = (Map)localObject2;
    AppMethodBeat.o(108972);
  }
  
  private d$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.d.b
 * JD-Core Version:    0.7.0.1
 */