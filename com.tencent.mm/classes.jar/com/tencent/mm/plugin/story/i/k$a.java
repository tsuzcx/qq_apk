package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage$Companion;", "", "()V", "CON_FAVORITE", "", "CON_HISTORY", "CON_NOT_VISIBLE_SELF", "CON_OTHERS", "CON_STORY_ID", "CON_USER", "EventNotifyStoryInfoDelete", "", "INDEX_CREATE", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "NotifyStoryInfoDelete", "ORDER_BY_FAV_SEQ", "getORDER_BY_FAV_SEQ", "()Ljava/lang/String;", "setORDER_BY_FAV_SEQ", "(Ljava/lang/String;)V", "ORDER_BY_SEQ", "getORDER_BY_SEQ", "setORDER_BY_SEQ", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "STORYINFO_SELECT_BEGIN", "STORYINFO_SELECT_COUNT", "TABLE", "getTABLE", "TAG", "buildLimitString", "data", "", "col", "reverse", "", "getORIntRange", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-story_release"})
public final class k$a
{
  public static String b(List<Integer> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119552);
    p.h(paramList, "data");
    p.h(paramString, "col");
    StringBuilder localStringBuilder = new StringBuilder("(");
    if (paramBoolean) {
      localStringBuilder.append(paramString + " not in (");
    }
    for (;;)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localStringBuilder.append(((Number)paramList.next()).intValue());
        if (paramList.hasNext()) {
          localStringBuilder.append(",");
        }
      }
      localStringBuilder.append(paramString + " in (");
    }
    localStringBuilder.append(")");
    localStringBuilder.append(")");
    paramList = localStringBuilder.toString();
    p.g(paramList, "sb.toString()");
    AppMethodBeat.o(119552);
    return paramList;
  }
  
  public static ArrayList<Integer> fQ(List<Integer> paramList)
  {
    AppMethodBeat.i(119553);
    p.h(paramList, "data");
    Object localObject = new ArrayList((Collection)paramList);
    paramList = new HashSet();
    ArrayList localArrayList1 = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        p.g(localInteger, "i");
        localArrayList2.add(Integer.valueOf(i | localInteger.intValue()));
      }
      paramList.addAll((Collection)new HashSet((Collection)localArrayList2));
      paramList.add(localInteger);
    }
    paramList.add(Integer.valueOf(0));
    localArrayList1.addAll((Collection)paramList);
    AppMethodBeat.o(119553);
    return localArrayList1;
  }
  
  public static String i(List<Integer> paramList, String paramString)
  {
    AppMethodBeat.i(119551);
    p.h(paramList, "data");
    p.h(paramString, "col");
    paramList = b(paramList, paramString, false);
    AppMethodBeat.o(119551);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.k.a
 * JD-Core Version:    0.7.0.1
 */