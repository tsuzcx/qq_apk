package com.tencent.mm.plugin.websearch.widget.c.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.hj;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static List<a> PCM;
  
  static
  {
    AppMethodBeat.i(116659);
    ArrayList localArrayList = new ArrayList();
    PCM = localArrayList;
    localArrayList.add(new c());
    PCM.add(new d());
    AppMethodBeat.o(116659);
  }
  
  public static boolean a(String paramString1, n paramn, String paramString2, WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116658);
    Log.i("OpenAppHandler", "handle url %s", new Object[] { paramString1 });
    Object localObject = PCM.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (locala.bjf(paramString1))) {
        if (locala.Tz(paramWidgetData.PzY.MFy))
        {
          if (locala.bjg(paramString1))
          {
            if ((locala instanceof d))
            {
              paramn = new hj();
              paramn.gFv = 2L;
              paramString1 = paramn.ww(paramString1).wv(paramWidgetData.query).alG().wt(paramWidgetData.PzY.jQi);
              paramString1.gFx = paramWidgetData.PzY.serviceType;
              paramString1.wu(paramWidgetData.fQb).bpa();
            }
            for (;;)
            {
              AppMethodBeat.o(116658);
              return true;
              if ((locala instanceof c))
              {
                paramn = new hj();
                paramn.gFv = 3L;
                paramString1 = paramn.ww(paramString1).wv(paramWidgetData.query).alG().wt(paramWidgetData.PzY.jQi);
                paramString1.gFx = paramWidgetData.PzY.serviceType;
                paramString1.wu(paramWidgetData.fQb).bpa();
              }
            }
          }
        }
        else
        {
          com.tencent.mm.plugin.websearch.widget.c.c.e(paramWidgetData.PzY.lyD, "openApp", new String[] { paramString1 });
          paramn.i(paramString2, paramString1, "", -1);
          AppMethodBeat.o(116658);
          return true;
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("open_target_weapp://"))) {
      if (com.tencent.mm.plugin.websearch.widget.c.c.at(paramWidgetData.PzY.MFy, 2))
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
    for (int i = Util.safeParseInt((String)localObject);; i = -1)
    {
      paramn.i(paramString2, paramString1, paramWidgetData + "@app", i);
      for (;;)
      {
        AppMethodBeat.o(116658);
        return false;
        com.tencent.mm.plugin.websearch.widget.c.c.e(paramWidgetData.PzY.lyD, "openApp", new String[] { paramString1 });
        paramn.i(paramString2, paramString1, "", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.b
 * JD-Core Version:    0.7.0.1
 */