package com.tencent.mm.plugin.websearch.widget.c.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.h.b.a.k;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static List<a> qXr;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    qXr = localArrayList;
    localArrayList.add(new c());
    qXr.add(new d());
  }
  
  public static boolean a(String paramString1, r paramr, String paramString2, WidgetData paramWidgetData)
  {
    y.i("OpenAppHandler", "handle url %s", new Object[] { paramString1 });
    Object localObject = qXr.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala != null) && (locala.RE(paramString1))) {
        if (locala.gQ(paramWidgetData.qVo.qVy))
        {
          if (locala.RF(paramString1))
          {
            if ((locala instanceof d))
            {
              paramr = new k();
              paramr.cig = 2L;
              paramr.cih = paramString1;
              paramr.cif = paramWidgetData.bVk;
              paramString1 = paramr.uO();
              paramString1.cid = paramWidgetData.qVo.fTF;
              paramString1.cij = paramWidgetData.qVo.dWx;
              paramString1.cie = paramWidgetData.qVr;
              paramString1.QX();
            }
            for (;;)
            {
              return true;
              if ((locala instanceof c))
              {
                paramr = new k();
                paramr.cig = 3L;
                paramr.cih = paramString1;
                paramr.cif = paramWidgetData.bVk;
                paramString1 = paramr.uO();
                paramString1.cid = paramWidgetData.qVo.fTF;
                paramString1.cij = paramWidgetData.qVo.dWx;
                paramString1.cie = paramWidgetData.qVr;
                paramString1.QX();
              }
            }
          }
        }
        else
        {
          com.tencent.mm.plugin.websearch.widget.c.c.c(paramWidgetData.qVo.dZY, "openApp", new String[] { paramString1 });
          paramr.g(paramString2, paramString1, "", -1);
          return true;
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("open_target_weapp://"))) {
      if (com.tencent.mm.plugin.websearch.widget.c.c.z(paramWidgetData.qVo.qVy, 2))
      {
        localObject = Uri.parse(paramString1);
        paramString1 = ((Uri)localObject).getQueryParameter("path");
        paramWidgetData = ((Uri)localObject).getQueryParameter("origin_id");
        localObject = ((Uri)localObject).getQueryParameter("debug_mode");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label424;
        }
      }
    }
    label424:
    for (int i = bk.ZR((String)localObject);; i = -1)
    {
      paramr.g(paramString2, paramString1, paramWidgetData + "@app", i);
      for (;;)
      {
        return false;
        com.tencent.mm.plugin.websearch.widget.c.c.c(paramWidgetData.qVo.dZY, "openApp", new String[] { paramString1 });
        paramr.g(paramString2, paramString1, "", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.b
 * JD-Core Version:    0.7.0.1
 */