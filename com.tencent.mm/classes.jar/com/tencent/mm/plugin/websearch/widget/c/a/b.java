package com.tencent.mm.plugin.websearch.widget.c.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fr;
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
  private static List<a> IIr;
  
  static
  {
    AppMethodBeat.i(116659);
    ArrayList localArrayList = new ArrayList();
    IIr = localArrayList;
    localArrayList.add(new c());
    IIr.add(new d());
    AppMethodBeat.o(116659);
  }
  
  public static boolean a(String paramString1, n paramn, String paramString2, WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116658);
    Log.i("OpenAppHandler", "handle url %s", new Object[] { paramString1 });
    Object localObject = IIr.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (locala.aXt(paramString1))) {
        if (locala.Mb(paramWidgetData.IFG.IFN))
        {
          if (locala.aXu(paramString1))
          {
            if ((locala instanceof d))
            {
              paramn = new fr();
              paramn.eGU = 2L;
              paramString1 = paramn.sI(paramString1).sH(paramWidgetData.query).agD().sF(paramWidgetData.IFG.hes);
              paramString1.eGX = paramWidgetData.IFG.serviceType;
              paramString1.sG(paramWidgetData.dWw).bfK();
            }
            for (;;)
            {
              AppMethodBeat.o(116658);
              return true;
              if ((locala instanceof c))
              {
                paramn = new fr();
                paramn.eGU = 3L;
                paramString1 = paramn.sI(paramString1).sH(paramWidgetData.query).agD().sF(paramWidgetData.IFG.hes);
                paramString1.eGX = paramWidgetData.IFG.serviceType;
                paramString1.sG(paramWidgetData.dWw).bfK();
              }
            }
          }
        }
        else
        {
          com.tencent.mm.plugin.websearch.widget.c.c.d(paramWidgetData.IFG.iIA, "openApp", new String[] { paramString1 });
          paramn.j(paramString2, paramString1, "", -1);
          AppMethodBeat.o(116658);
          return true;
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("open_target_weapp://"))) {
      if (com.tencent.mm.plugin.websearch.widget.c.c.ak(paramWidgetData.IFG.IFN, 2))
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
      paramn.j(paramString2, paramString1, paramWidgetData + "@app", i);
      for (;;)
      {
        AppMethodBeat.o(116658);
        return false;
        com.tencent.mm.plugin.websearch.widget.c.c.d(paramWidgetData.IFG.iIA, "openApp", new String[] { paramString1 });
        paramn.j(paramString2, paramString1, "", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.b
 * JD-Core Version:    0.7.0.1
 */