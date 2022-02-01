package com.tencent.mm.plugin.websearch.widget.c.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static List<a> AJn;
  
  static
  {
    AppMethodBeat.i(116659);
    ArrayList localArrayList = new ArrayList();
    AJn = localArrayList;
    localArrayList.add(new c());
    AJn.add(new d());
    AppMethodBeat.o(116659);
  }
  
  public static boolean a(String paramString1, n paramn, String paramString2, WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116658);
    ad.i("OpenAppHandler", "handle url %s", new Object[] { paramString1 });
    Object localObject = AJn.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (locala.avn(paramString1))) {
        if (locala.uX(paramWidgetData.AHB.AHK))
        {
          if (locala.avo(paramString1))
          {
            if ((locala instanceof d))
            {
              paramn = new ay();
              paramn.dNf = 2L;
              paramString1 = paramn.hS(paramString1).hR(paramWidgetData.query).Ql().hP(paramWidgetData.AHB.jko);
              paramString1.dNi = paramWidgetData.AHB.cIB;
              paramString1.hQ(paramWidgetData.AHE).aBj();
            }
            for (;;)
            {
              AppMethodBeat.o(116658);
              return true;
              if ((locala instanceof c))
              {
                paramn = new ay();
                paramn.dNf = 3L;
                paramString1 = paramn.hS(paramString1).hR(paramWidgetData.query).Ql().hP(paramWidgetData.AHB.jko);
                paramString1.dNi = paramWidgetData.AHB.cIB;
                paramString1.hQ(paramWidgetData.AHE).aBj();
              }
            }
          }
        }
        else
        {
          com.tencent.mm.plugin.websearch.widget.c.c.c(paramWidgetData.AHB.gRK, "openApp", new String[] { paramString1 });
          paramn.h(paramString2, paramString1, "", -1);
          AppMethodBeat.o(116658);
          return true;
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("open_target_weapp://"))) {
      if (com.tencent.mm.plugin.websearch.widget.c.c.Z(paramWidgetData.AHB.AHK, 2))
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
    for (int i = bt.aGh((String)localObject);; i = -1)
    {
      paramn.h(paramString2, paramString1, paramWidgetData + "@app", i);
      for (;;)
      {
        AppMethodBeat.o(116658);
        return false;
        com.tencent.mm.plugin.websearch.widget.c.c.c(paramWidgetData.AHB.gRK, "openApp", new String[] { paramString1 });
        paramn.h(paramString2, paramString1, "", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.b
 * JD-Core Version:    0.7.0.1
 */