package com.tencent.mm.plugin.story.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.c.b;
import d.a.ae;
import d.k.h;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"})
public final class d
  extends b<d.a>
{
  public static final d ydH;
  
  static
  {
    AppMethodBeat.i(118605);
    ydH = new d();
    AppMethodBeat.o(118605);
  }
  
  public static boolean arh(String paramString)
  {
    AppMethodBeat.i(118602);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(118602);
      return false;
    }
    if ((!w.st(paramString)) && (!w.sE(paramString)) && (!w.sw(paramString)) && (!w.sA(paramString)) && (!w.sH(paramString)) && (!w.sI(paramString)) && (!w.ti(paramString)) && (!w.tn(paramString)) && (!w.to(paramString)) && (!w.sT(paramString)) && (!w.sn(paramString)) && (!w.sm(paramString)))
    {
      AppMethodBeat.o(118602);
      return true;
    }
    AppMethodBeat.o(118602);
    return false;
  }
  
  public final void ajo()
  {
    AppMethodBeat.i(118604);
    ((d.a)ajm()).clear();
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118604);
      return;
    }
    ((d.a)ajm()).add(b.ydJ);
    ((d.a)ajm()).add(b.ydK);
    ((d.a)ajm()).add(b.ydL);
    ((d.a)ajm()).add(b.ydM);
    ((d.a)ajm()).add(b.ydN);
    ((d.a)ajm()).add(b.ydP);
    ((d.a)ajm()).add(b.ydO);
    AppMethodBeat.o(118604);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "CONTACT_PAGE", "TIMELINE_LIKE", "TIMELINE_DETAIL", "TIMELINE_COMMENT", "TIMELINE_USER_HEAD", "CHATTING_ROOM", "MESSAGE_PAGE", "Companion", "plugin-story_release"})
  public static enum b
  {
    private static final Map<Integer, b> map;
    public static final a ydR;
    private final int value;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(118599);
      Object localObject1 = new b("DEFAULT", 0, -1);
      ydI = (b)localObject1;
      Object localObject2 = new b("CONTACT_PAGE", 1, 0);
      ydJ = (b)localObject2;
      b localb1 = new b("TIMELINE_LIKE", 2, 1);
      ydK = localb1;
      b localb2 = new b("TIMELINE_DETAIL", 3, 2);
      ydL = localb2;
      b localb3 = new b("TIMELINE_COMMENT", 4, 3);
      ydM = localb3;
      b localb4 = new b("TIMELINE_USER_HEAD", 5, 4);
      ydN = localb4;
      b localb5 = new b("CHATTING_ROOM", 6, 5);
      ydO = localb5;
      b localb6 = new b("MESSAGE_PAGE", 7, 6);
      ydP = localb6;
      ydQ = new b[] { localObject1, localObject2, localb1, localb2, localb3, localb4, localb5, localb6 };
      ydR = new a((byte)0);
      localObject1 = values();
      localObject2 = (Map)new LinkedHashMap(h.kK(ae.adL(localObject1.length), 16));
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
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType$Companion;", "", "()V", "map", "", "", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "fromInt", "type", "plugin-story_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.d
 * JD-Core Version:    0.7.0.1
 */