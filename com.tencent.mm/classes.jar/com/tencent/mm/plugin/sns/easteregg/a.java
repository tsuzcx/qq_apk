package com.tencent.mm.plugin.sns.easteregg;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.yv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static final List<String> QoT;
  private static boolean isInit;
  private static IListener<yv> lsH;
  
  static
  {
    AppMethodBeat.i(95170);
    QoT = Collections.synchronizedList(new LinkedList());
    isInit = false;
    lsH = new StoryStateMiddleLayer.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(95170);
  }
  
  public static boolean aXK(String paramString)
  {
    AppMethodBeat.i(95166);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (paramString.equals(h.baE().ban().d(2, null)))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (aXM(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    boolean bool = ((e)h.az(e.class)).isStoryUnread(paramString);
    AppMethodBeat.o(95166);
    return bool;
  }
  
  public static boolean aXL(String paramString)
  {
    AppMethodBeat.i(95167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95167);
      return false;
    }
    if (aXM(paramString))
    {
      AppMethodBeat.o(95167);
      return false;
    }
    if ((((e)h.az(e.class)).isStoryExist(paramString)) || (((e)h.az(e.class)).isStoryUnread(paramString)))
    {
      AppMethodBeat.o(95167);
      return true;
    }
    AppMethodBeat.o(95167);
    return false;
  }
  
  public static boolean aXM(String paramString)
  {
    AppMethodBeat.i(95168);
    boolean bool = hfc().contains(paramString);
    AppMethodBeat.o(95168);
    return bool;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(95165);
    lsH.dead();
    AppMethodBeat.o(95165);
  }
  
  public static List<String> hfc()
  {
    AppMethodBeat.i(95169);
    if (isInit)
    {
      localObject = QoT;
      AppMethodBeat.o(95169);
      return localObject;
    }
    Object localObject = al.hgI().vl(5L);
    if (Util.isNullOrNil(((ac)localObject).field_memberList))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    localObject = Util.stringsToList(((ac)localObject).field_memberList.split(","));
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    QoT.addAll((Collection)localObject);
    isInit = true;
    localObject = QoT;
    AppMethodBeat.o(95169);
    return localObject;
  }
  
  public static void init()
  {
    AppMethodBeat.i(95164);
    lsH.alive();
    AppMethodBeat.o(95164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.easteregg.a
 * JD-Core Version:    0.7.0.1
 */