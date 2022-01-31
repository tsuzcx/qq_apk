package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static l c(Context paramContext, List<awk> paramList)
  {
    if (bk.dk(paramList)) {
      return null;
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (awk)paramList.next();
      if ((localObject2 != null) && (c.a.CT(((awk)localObject2).sYX))) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (bk.dk((List)localObject1)) {
      return null;
    }
    Collections.sort((List)localObject1, new c.1());
    int j = ((awk)((List)localObject1).get(((List)localObject1).size() - 1)).tta;
    paramList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      paramList.add(null);
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (awk)((Iterator)localObject1).next();
      if ((((awk)localObject2).tta > 0) && (((awk)localObject2).tta <= paramList.size())) {
        paramList.set(((awk)localObject2).tta - 1, localObject2);
      }
    }
    paramContext = new l(paramContext);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (awk)paramList.next();
      if (localObject1 == null)
      {
        paramContext.e(-1, "");
      }
      else
      {
        localObject2 = ((awk)localObject1).bGw + "__" + ((awk)localObject1).mQp;
        paramContext.e(((awk)localObject1).tsZ, (CharSequence)localObject2);
      }
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c
 * JD-Core Version:    0.7.0.1
 */