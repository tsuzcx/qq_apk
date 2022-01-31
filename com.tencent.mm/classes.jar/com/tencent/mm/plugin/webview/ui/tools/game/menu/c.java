package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static l c(Context paramContext, List<bcz> paramList)
  {
    AppMethodBeat.i(8816);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(8816);
      return null;
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (bcz)paramList.next();
      if ((localObject2 != null) && (c.a.KO(((bcz)localObject2).wzE))) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (bo.es((List)localObject1))
    {
      AppMethodBeat.o(8816);
      return null;
    }
    Collections.sort((List)localObject1, new c.1());
    int j = ((bcz)((List)localObject1).get(((List)localObject1).size() - 1)).xta;
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
      localObject2 = (bcz)((Iterator)localObject1).next();
      if ((((bcz)localObject2).xta > 0) && (((bcz)localObject2).xta <= paramList.size())) {
        paramList.set(((bcz)localObject2).xta - 1, localObject2);
      }
    }
    paramContext = new l(paramContext);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (bcz)paramList.next();
      if (localObject1 == null)
      {
        paramContext.e(-1, "");
      }
      else
      {
        localObject2 = ((bcz)localObject1).Title + "__" + ((bcz)localObject1).ThumbUrl;
        paramContext.e(((bcz)localObject1).xsZ, (CharSequence)localObject2);
      }
    }
    AppMethodBeat.o(8816);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.c
 * JD-Core Version:    0.7.0.1
 */