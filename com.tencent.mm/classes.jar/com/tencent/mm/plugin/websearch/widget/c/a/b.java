package com.tencent.mm.plugin.websearch.widget.c.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static List<a> DWA;
  
  static
  {
    AppMethodBeat.i(116659);
    ArrayList localArrayList = new ArrayList();
    DWA = localArrayList;
    localArrayList.add(new c());
    DWA.add(new d());
    AppMethodBeat.o(116659);
  }
  
  public static boolean a(String paramString1, n paramn, String paramString2, WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116658);
    ae.i("OpenAppHandler", "handle url %s", new Object[] { paramString1 });
    Object localObject = DWA.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (locala.aHt(paramString1))) {
        if (locala.CM(paramWidgetData.DUM.DUU))
        {
          if (locala.aHu(paramString1))
          {
            if ((locala instanceof d))
            {
              paramn = new dc();
              paramn.efx = 2L;
              paramString1 = paramn.mI(paramString1).mH(paramWidgetData.query).Ta().mF(paramWidgetData.DUM.kid);
              paramString1.efA = paramWidgetData.DUM.cRx;
              paramString1.mG(paramWidgetData.dEJ).aLH();
            }
            for (;;)
            {
              AppMethodBeat.o(116658);
              return true;
              if ((locala instanceof c))
              {
                paramn = new dc();
                paramn.efx = 3L;
                paramString1 = paramn.mI(paramString1).mH(paramWidgetData.query).Ta().mF(paramWidgetData.DUM.kid);
                paramString1.efA = paramWidgetData.DUM.cRx;
                paramString1.mG(paramWidgetData.dEJ).aLH();
              }
            }
          }
        }
        else
        {
          com.tencent.mm.plugin.websearch.widget.c.c.d(paramWidgetData.DUM.hNv, "openApp", new String[] { paramString1 });
          paramn.h(paramString2, paramString1, "", -1);
          AppMethodBeat.o(116658);
          return true;
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("open_target_weapp://"))) {
      if (com.tencent.mm.plugin.websearch.widget.c.c.ah(paramWidgetData.DUM.DUU, 2))
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
    for (int i = bu.aSB((String)localObject);; i = -1)
    {
      paramn.h(paramString2, paramString1, paramWidgetData + "@app", i);
      for (;;)
      {
        AppMethodBeat.o(116658);
        return false;
        com.tencent.mm.plugin.websearch.widget.c.c.d(paramWidgetData.DUM.hNv, "openApp", new String[] { paramString1 });
        paramn.h(paramString2, paramString1, "", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.b
 * JD-Core Version:    0.7.0.1
 */