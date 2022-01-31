package com.tencent.mm.plugin.websearch.widget.c.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.q;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static List<a> uMG;
  
  static
  {
    AppMethodBeat.i(91464);
    ArrayList localArrayList = new ArrayList();
    uMG = localArrayList;
    localArrayList.add(new c());
    uMG.add(new d());
    AppMethodBeat.o(91464);
  }
  
  public static boolean a(String paramString1, r paramr, String paramString2, WidgetData paramWidgetData)
  {
    AppMethodBeat.i(91463);
    ab.i("OpenAppHandler", "handle url %s", new Object[] { paramString1 });
    Object localObject = uMG.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (locala.agF(paramString1))) {
        if (locala.nm(paramWidgetData.uKA.uKK))
        {
          if (locala.agG(paramString1))
          {
            if ((locala instanceof d))
            {
              paramr = new q();
              paramr.cSf = 2L;
              paramString1 = paramr.fm(paramString1).fl(paramWidgetData.query).Fl().fj(paramWidgetData.uKA.hng);
              paramString1.cSi = paramWidgetData.uKA.fmF;
              paramString1.fk(paramWidgetData.uKD).ake();
            }
            for (;;)
            {
              AppMethodBeat.o(91463);
              return true;
              if ((locala instanceof c))
              {
                paramr = new q();
                paramr.cSf = 3L;
                paramString1 = paramr.fm(paramString1).fl(paramWidgetData.query).Fl().fj(paramWidgetData.uKA.hng);
                paramString1.cSi = paramWidgetData.uKA.fmF;
                paramString1.fk(paramWidgetData.uKD).ake();
              }
            }
          }
        }
        else
        {
          com.tencent.mm.plugin.websearch.widget.c.c.c(paramWidgetData.uKA.fqf, "openApp", new String[] { paramString1 });
          paramr.g(paramString2, paramString1, "", -1);
          AppMethodBeat.o(91463);
          return true;
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("open_target_weapp://"))) {
      if (com.tencent.mm.plugin.websearch.widget.c.c.J(paramWidgetData.uKA.uKK, 2))
      {
        localObject = Uri.parse(paramString1);
        paramString1 = ((Uri)localObject).getQueryParameter("path");
        paramWidgetData = ((Uri)localObject).getQueryParameter("origin_id");
        localObject = ((Uri)localObject).getQueryParameter("debug_mode");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label436;
        }
      }
    }
    label436:
    for (int i = bo.apV((String)localObject);; i = -1)
    {
      paramr.g(paramString2, paramString1, paramWidgetData + "@app", i);
      for (;;)
      {
        AppMethodBeat.o(91463);
        return false;
        com.tencent.mm.plugin.websearch.widget.c.c.c(paramWidgetData.uKA.fqf, "openApp", new String[] { paramString1 });
        paramr.g(paramString2, paramString1, "", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.b
 * JD-Core Version:    0.7.0.1
 */