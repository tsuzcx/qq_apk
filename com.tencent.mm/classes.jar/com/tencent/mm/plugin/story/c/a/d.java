package com.tencent.mm.plugin.story.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.storage.au;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceConfig;", "()V", "checkChatterEnableStoryEntrance", "", "userName", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "ShowEntranceConfig", "ShowEntranceType", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b<d.a>
{
  public static final d SiQ;
  
  static
  {
    AppMethodBeat.i(118605);
    SiQ = new d();
    AppMethodBeat.o(118605);
  }
  
  public static boolean bbC(String paramString)
  {
    AppMethodBeat.i(118602);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(118602);
      return false;
    }
    if ((!au.bwS(paramString)) && (!ab.IS(paramString)) && (!au.bxe(paramString)) && (!ab.IP(paramString)) && (!au.bvS(paramString)) && (!au.bvT(paramString)) && (!au.bwu(paramString)) && (!au.bwA(paramString)) && (!ab.IV(paramString)) && (!au.bwf(paramString)) && (!au.bwF(paramString)) && (!au.bwG(paramString)))
    {
      AppMethodBeat.o(118602);
      return true;
    }
    AppMethodBeat.o(118602);
    return false;
  }
  
  public final void boD()
  {
    AppMethodBeat.i(118604);
    ((d.a)boB()).clear();
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118604);
      return;
    }
    ((d.a)boB()).add(b.SiT);
    ((d.a)boB()).add(b.SiU);
    ((d.a)boB()).add(b.SiV);
    ((d.a)boB()).add(b.SiW);
    ((d.a)boB()).add(b.SiX);
    ((d.a)boB()).add(b.SiZ);
    ((d.a)boB()).add(b.SiY);
    AppMethodBeat.o(118604);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryEntranceElementConfig$ShowEntranceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "CONTACT_PAGE", "TIMELINE_LIKE", "TIMELINE_DETAIL", "TIMELINE_COMMENT", "TIMELINE_USER_HEAD", "CHATTING_ROOM", "MESSAGE_PAGE", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    public static final d.b.a SiR;
    private static final Map<Integer, b> map;
    private final int value;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(118599);
      SiS = new b("DEFAULT", 0, -1);
      SiT = new b("CONTACT_PAGE", 1, 0);
      SiU = new b("TIMELINE_LIKE", 2, 1);
      SiV = new b("TIMELINE_DETAIL", 3, 2);
      SiW = new b("TIMELINE_COMMENT", 4, 3);
      SiX = new b("TIMELINE_USER_HEAD", 5, 4);
      SiY = new b("CHATTING_ROOM", 6, 5);
      SiZ = new b("MESSAGE_PAGE", 7, 6);
      Sja = new b[] { SiS, SiT, SiU, SiV, SiW, SiX, SiY, SiZ };
      SiR = new d.b.a((byte)0);
      b[] arrayOfb = values();
      Map localMap = (Map)new LinkedHashMap(k.qu(ak.aKi(arrayOfb.length), 16));
      int j = arrayOfb.length;
      while (i < j)
      {
        b localb = arrayOfb[i];
        localMap.put(Integer.valueOf(localb.value), localb);
        i += 1;
      }
      map = localMap;
      AppMethodBeat.o(118599);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.d
 * JD-Core Version:    0.7.0.1
 */