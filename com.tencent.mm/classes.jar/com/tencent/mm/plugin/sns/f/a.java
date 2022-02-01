package com.tencent.mm.plugin.sns.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static final List<String> DFl;
  private static IListener<vx> gmC;
  private static boolean isInit;
  
  static
  {
    AppMethodBeat.i(95170);
    DFl = Collections.synchronizedList(new LinkedList());
    isInit = false;
    gmC = new IListener() {};
    AppMethodBeat.o(95170);
  }
  
  public static boolean aOD(String paramString)
  {
    AppMethodBeat.i(95166);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (paramString.equals(g.aAh().azQ().get(2, null)))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (aOF(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).isStoryUnread(paramString);
    AppMethodBeat.o(95166);
    return bool;
  }
  
  public static boolean aOE(String paramString)
  {
    AppMethodBeat.i(95167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95167);
      return false;
    }
    if (aOF(paramString))
    {
      AppMethodBeat.o(95167);
      return false;
    }
    if ((((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(paramString)) || (((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).isStoryUnread(paramString)))
    {
      AppMethodBeat.o(95167);
      return true;
    }
    AppMethodBeat.o(95167);
    return false;
  }
  
  public static boolean aOF(String paramString)
  {
    AppMethodBeat.i(95168);
    boolean bool = eZI().contains(paramString);
    AppMethodBeat.o(95168);
    return bool;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(95165);
    gmC.dead();
    AppMethodBeat.o(95165);
  }
  
  public static List<String> eZI()
  {
    AppMethodBeat.i(95169);
    if (isInit)
    {
      localObject = DFl;
      AppMethodBeat.o(95169);
      return localObject;
    }
    Object localObject = aj.faU().JL(5L);
    if (Util.isNullOrNil(((s)localObject).field_memberList))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    localObject = Util.stringsToList(((s)localObject).field_memberList.split(","));
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    DFl.addAll((Collection)localObject);
    isInit = true;
    localObject = DFl;
    AppMethodBeat.o(95169);
    return localObject;
  }
  
  public static void init()
  {
    AppMethodBeat.i(95164);
    gmC.alive();
    AppMethodBeat.o(95164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.a
 * JD-Core Version:    0.7.0.1
 */