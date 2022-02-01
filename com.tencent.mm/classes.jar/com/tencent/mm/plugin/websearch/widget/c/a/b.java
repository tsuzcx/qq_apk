package com.tencent.mm.plugin.websearch.widget.c.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static List<a> CbE;
  
  static
  {
    AppMethodBeat.i(116659);
    ArrayList localArrayList = new ArrayList();
    CbE = localArrayList;
    localArrayList.add(new c());
    CbE.add(new d());
    AppMethodBeat.o(116659);
  }
  
  public static boolean a(String paramString1, m paramm, String paramString2, WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116658);
    ac.i("OpenAppHandler", "handle url %s", new Object[] { paramString1 });
    Object localObject = CbE.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (locala.aAF(paramString1))) {
        if (locala.zA(paramWidgetData.BZS.Cab))
        {
          if (locala.aAG(paramString1))
          {
            if ((locala instanceof d))
            {
              paramm = new ck();
              paramm.dOI = 2L;
              paramString1 = paramm.ku(paramString1).kt(paramWidgetData.query).QN().kr(paramWidgetData.BZS.jKB);
              paramString1.dOL = paramWidgetData.BZS.cFI;
              paramString1.ks(paramWidgetData.BZV).aHZ();
            }
            for (;;)
            {
              AppMethodBeat.o(116658);
              return true;
              if ((locala instanceof c))
              {
                paramm = new ck();
                paramm.dOI = 3L;
                paramString1 = paramm.ku(paramString1).kt(paramWidgetData.query).QN().kr(paramWidgetData.BZS.jKB);
                paramString1.dOL = paramWidgetData.BZS.cFI;
                paramString1.ks(paramWidgetData.BZV).aHZ();
              }
            }
          }
        }
        else
        {
          com.tencent.mm.plugin.websearch.widget.c.c.c(paramWidgetData.BZS.hsk, "openApp", new String[] { paramString1 });
          paramm.h(paramString2, paramString1, "", -1);
          AppMethodBeat.o(116658);
          return true;
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("open_target_weapp://"))) {
      if (com.tencent.mm.plugin.websearch.widget.c.c.ac(paramWidgetData.BZS.Cab, 2))
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
    for (int i = bs.aLy((String)localObject);; i = -1)
    {
      paramm.h(paramString2, paramString1, paramWidgetData + "@app", i);
      for (;;)
      {
        AppMethodBeat.o(116658);
        return false;
        com.tencent.mm.plugin.websearch.widget.c.c.c(paramWidgetData.BZS.hsk, "openApp", new String[] { paramString1 });
        paramm.h(paramString2, paramString1, "", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.b
 * JD-Core Version:    0.7.0.1
 */