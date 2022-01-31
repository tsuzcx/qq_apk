package com.tencent.mm.plugin.sns.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static boolean bRB;
  private static c<ry> dZC;
  private static final List<String> rbE;
  
  static
  {
    AppMethodBeat.i(35872);
    rbE = Collections.synchronizedList(new LinkedList());
    bRB = false;
    dZC = new a.1();
    AppMethodBeat.o(35872);
  }
  
  public static boolean ZR(String paramString)
  {
    AppMethodBeat.i(35868);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(35868);
      return false;
    }
    if (paramString.equals(g.RL().Ru().get(2, null)))
    {
      AppMethodBeat.o(35868);
      return false;
    }
    if (ZT(paramString))
    {
      AppMethodBeat.o(35868);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.story.api.e)g.G(com.tencent.mm.plugin.story.api.e.class)).isStoryUnread(paramString);
    AppMethodBeat.o(35868);
    return bool;
  }
  
  public static boolean ZS(String paramString)
  {
    AppMethodBeat.i(35869);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(35869);
      return false;
    }
    if (ZT(paramString))
    {
      AppMethodBeat.o(35869);
      return false;
    }
    if ((((com.tencent.mm.plugin.story.api.e)g.G(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(paramString)) || (((com.tencent.mm.plugin.story.api.e)g.G(com.tencent.mm.plugin.story.api.e.class)).isStoryUnread(paramString)))
    {
      AppMethodBeat.o(35869);
      return true;
    }
    AppMethodBeat.o(35869);
    return false;
  }
  
  public static boolean ZT(String paramString)
  {
    AppMethodBeat.i(35870);
    boolean bool = cnU().contains(paramString);
    AppMethodBeat.o(35870);
    return bool;
  }
  
  public static List<String> cnU()
  {
    AppMethodBeat.i(35871);
    if (bRB)
    {
      localObject = rbE;
      AppMethodBeat.o(35871);
      return localObject;
    }
    Object localObject = ag.cpl().mb(5L);
    if (bo.isNullOrNil(((t)localObject).field_memberList))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(35871);
      return localObject;
    }
    localObject = bo.P(((t)localObject).field_memberList.split(","));
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(35871);
      return localObject;
    }
    rbE.addAll((Collection)localObject);
    bRB = true;
    localObject = rbE;
    AppMethodBeat.o(35871);
    return localObject;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(35867);
    dZC.dead();
    AppMethodBeat.o(35867);
  }
  
  public static void init()
  {
    AppMethodBeat.i(35866);
    dZC.alive();
    AppMethodBeat.o(35866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.a
 * JD-Core Version:    0.7.0.1
 */