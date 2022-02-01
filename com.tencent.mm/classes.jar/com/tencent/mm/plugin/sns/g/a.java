package com.tencent.mm.plugin.sns.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static boolean csX;
  private static c<ts> fjL;
  private static final List<String> wBU;
  
  static
  {
    AppMethodBeat.i(95170);
    wBU = Collections.synchronizedList(new LinkedList());
    csX = false;
    fjL = new c() {};
    AppMethodBeat.o(95170);
  }
  
  public static boolean anY(String paramString)
  {
    AppMethodBeat.i(95166);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (paramString.equals(g.afB().afk().get(2, null)))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (aoa(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryUnread(paramString);
    AppMethodBeat.o(95166);
    return bool;
  }
  
  public static boolean anZ(String paramString)
  {
    AppMethodBeat.i(95167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95167);
      return false;
    }
    if (aoa(paramString))
    {
      AppMethodBeat.o(95167);
      return false;
    }
    if ((((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(paramString)) || (((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryUnread(paramString)))
    {
      AppMethodBeat.o(95167);
      return true;
    }
    AppMethodBeat.o(95167);
    return false;
  }
  
  public static boolean aoa(String paramString)
  {
    AppMethodBeat.i(95168);
    boolean bool = dso().contains(paramString);
    AppMethodBeat.o(95168);
    return bool;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(95165);
    fjL.dead();
    AppMethodBeat.o(95165);
  }
  
  public static List<String> dso()
  {
    AppMethodBeat.i(95169);
    if (csX)
    {
      localObject = wBU;
      AppMethodBeat.o(95169);
      return localObject;
    }
    Object localObject = af.dtA().tj(5L);
    if (bt.isNullOrNil(((v)localObject).field_memberList))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    localObject = bt.S(((v)localObject).field_memberList.split(","));
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    wBU.addAll((Collection)localObject);
    csX = true;
    localObject = wBU;
    AppMethodBeat.o(95169);
    return localObject;
  }
  
  public static void init()
  {
    AppMethodBeat.i(95164);
    fjL.alive();
    AppMethodBeat.o(95164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.a
 * JD-Core Version:    0.7.0.1
 */