package com.tencent.mm.plugin.sns.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static boolean cqf;
  private static c<ub> fnf;
  private static final List<String> xOp;
  
  static
  {
    AppMethodBeat.i(95170);
    xOp = Collections.synchronizedList(new LinkedList());
    cqf = false;
    fnf = new c() {};
    AppMethodBeat.o(95170);
  }
  
  public static boolean atk(String paramString)
  {
    AppMethodBeat.i(95166);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (paramString.equals(g.agR().agA().get(2, null)))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    if (atm(paramString))
    {
      AppMethodBeat.o(95166);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryUnread(paramString);
    AppMethodBeat.o(95166);
    return bool;
  }
  
  public static boolean atl(String paramString)
  {
    AppMethodBeat.i(95167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95167);
      return false;
    }
    if (atm(paramString))
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
  
  public static boolean atm(String paramString)
  {
    AppMethodBeat.i(95168);
    boolean bool = dGN().contains(paramString);
    AppMethodBeat.o(95168);
    return bool;
  }
  
  public static List<String> dGN()
  {
    AppMethodBeat.i(95169);
    if (cqf)
    {
      localObject = xOp;
      AppMethodBeat.o(95169);
      return localObject;
    }
    Object localObject = af.dHX().xM(5L);
    if (bs.isNullOrNil(((v)localObject).field_memberList))
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    localObject = bs.S(((v)localObject).field_memberList.split(","));
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(95169);
      return localObject;
    }
    xOp.addAll((Collection)localObject);
    cqf = true;
    localObject = xOp;
    AppMethodBeat.o(95169);
    return localObject;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(95165);
    fnf.dead();
    AppMethodBeat.o(95165);
  }
  
  public static void init()
  {
    AppMethodBeat.i(95164);
    fnf.alive();
    AppMethodBeat.o(95164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.a
 * JD-Core Version:    0.7.0.1
 */