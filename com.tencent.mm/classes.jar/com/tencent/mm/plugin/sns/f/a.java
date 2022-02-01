package com.tencent.mm.plugin.sns.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static boolean cAX;
  private static c<uu> fFn;
  private static final List<String> zej;
  
  static
  {
    AppMethodBeat.i(95170);
    zej = Collections.synchronizedList(new LinkedList());
    cAX = false;
    fFn = new c() {};
    AppMethodBeat.o(95170);
  }
  
  public static boolean ayp(String paramString)
  {
    AppMethodBeat.i(95166);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (paramString.equals(g.ajC().ajl().get(2, null)))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (ayr(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryUnread(paramString);
    AppMethodBeat.o(95166);
    return bool;
  }
  
  public static boolean ayq(String paramString)
  {
    AppMethodBeat.i(95167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95167);
      return false;
    }
    if (ayr(paramString))
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
  
  public static boolean ayr(String paramString)
  {
    AppMethodBeat.i(95168);
    boolean bool = dTa().contains(paramString);
    AppMethodBeat.o(95168);
    return bool;
  }
  
  public static List<String> dTa()
  {
    AppMethodBeat.i(95169);
    if (cAX)
    {
      localObject = zej;
      AppMethodBeat.o(95169);
      return localObject;
    }
    Object localObject = ag.dUk().Ak(5L);
    if (bt.isNullOrNil(((v)localObject).field_memberList))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    localObject = bt.U(((v)localObject).field_memberList.split(","));
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    zej.addAll((Collection)localObject);
    cAX = true;
    localObject = zej;
    AppMethodBeat.o(95169);
    return localObject;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(95165);
    fFn.dead();
    AppMethodBeat.o(95165);
  }
  
  public static void init()
  {
    AppMethodBeat.i(95164);
    fFn.alive();
    AppMethodBeat.o(95164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.a
 * JD-Core Version:    0.7.0.1
 */