package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.h.a.rz;
import com.tencent.mm.h.a.rz.b;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.protocal.c.bye;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.xweb.WebView.d;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

public final class d
{
  public static com.tencent.mm.as.a.a.c pDJ;
  public static com.tencent.mm.as.a.a.c pDK;
  
  static
  {
    c.a locala = new c.a();
    locala.erf = true;
    locala.ere = true;
    locala.erD = true;
    locala.eru = b.c.default_avatar;
    pDJ = locala.OV();
    locala = new c.a();
    locala.erf = true;
    locala.ere = true;
    locala.eru = b.c.default_avatar;
    pDK = locala.OV();
  }
  
  public static void L(Context paramContext, int paramInt)
  {
    Object localObject1 = "";
    if (((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().bMU())
    {
      localObject1 = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().bMX().bVP;
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().bMV();
      y.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d red dot %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aa.Bs(1)), localObject1 });
    }
    for (;;)
    {
      if ((!bk.bl((String)localObject1)) && (bNi()))
      {
        localObject2 = new rz();
        ((rz)localObject2).cbC.actionType = 2;
        a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      }
      String str1 = String.valueOf(System.currentTimeMillis());
      String str2 = paramContext.getString(b.g.fts_recommend_search_keyword);
      Object localObject2 = new byb();
      ((byb)localObject2).tNY = bNj();
      ((byb)localObject2).scene = paramInt;
      ((byb)localObject2).fTF = "";
      ((byb)localObject2).bGm = str2;
      ((byb)localObject2).bvj = 100;
      ((byb)localObject2).pDC = ((PluginTopStoryUI)com.tencent.mm.kernel.g.t(PluginTopStoryUI.class)).getFirstLoadWebView();
      String str3 = aa.Bm(paramInt);
      ((byb)localObject2).bIB = str3;
      ((byb)localObject2).bVp = str3;
      ((byb)localObject2).tOb = str2;
      HashMap localHashMap = new HashMap();
      if (!bk.bl((String)localObject1)) {
        localHashMap.put("redPointMsgId", localObject1);
      }
      if (!bk.bl(str3)) {
        localHashMap.put("sessionId", str3);
      }
      if (!bk.bl(str2)) {
        localHashMap.put("query", str2);
      }
      if (!bk.bl(str1))
      {
        localHashMap.put("requestId", str1);
        localHashMap.put("pRequestId", str1);
        localHashMap.put("seq", str1);
      }
      localHashMap.put("scene", String.valueOf(paramInt));
      ((byb)localObject2).url = com.tencent.mm.plugin.topstory.a.g.m(localHashMap);
      ((byb)localObject2).tOa = 1;
      ((byb)localObject2).tOc = aa.boM();
      ((byb)localObject2).tOd = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType().name();
      a(((byb)localObject2).qTG, (String)localObject1, str1, true);
      b((byb)localObject2, "clickTopStory", System.currentTimeMillis());
      localObject1 = new Intent();
      try
      {
        ((Intent)localObject1).putExtra("key_context", ((byb)localObject2).toByteArray());
        label420:
        ((Intent)localObject1).addFlags(268435456);
        aa.c(paramContext, ".ui.home.TopStoryHomeUI", (Intent)localObject1);
        if (!bNi()) {
          ai.d(new d.1((byb)localObject2));
        }
        ((PluginTopStoryUI)com.tencent.mm.kernel.g.t(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzw, Long.valueOf(System.currentTimeMillis()));
        ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.boots.a.c.class)).cr(com.tencent.mm.plugin.boots.a.b.hXI, 884);
        return;
        y.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(aa.Bs(1)) });
      }
      catch (IOException localIOException)
      {
        break label420;
      }
    }
  }
  
  public static final String a(byb parambyb)
  {
    Collections.sort(parambyb.tNZ, new d.3());
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    while (i < parambyb.tNZ.size())
    {
      localStringBuffer.append(((bye)parambyb.tNZ.get(i - 1)).name);
      localStringBuffer.append("->");
      localStringBuffer.append(((bye)parambyb.tNZ.get(i)).name);
      localStringBuffer.append(":");
      localStringBuffer.append(((bye)parambyb.tNZ.get(i)).timestamp - ((bye)parambyb.tNZ.get(i - 1)).timestamp);
      localStringBuffer.append("\n");
      i += 1;
    }
    if (parambyb.tNZ.size() > 2)
    {
      localStringBuffer.append("TotalUseTime:");
      localStringBuffer.append(((bye)parambyb.tNZ.get(parambyb.tNZ.size() - 1)).timestamp - ((bye)parambyb.tNZ.get(0)).timestamp);
      localStringBuffer.append("\n");
    }
    parambyb.tNZ.clear();
    localStringBuffer.append("============");
    localStringBuffer.append("\n");
    if (com.tencent.mm.plugin.topstory.a.g.bNd()) {
      com.tencent.mm.sdk.f.e.post(new d.a(localStringBuffer.toString()), "TopStory.SaveTraceTask");
    }
    return localStringBuffer.toString();
  }
  
  public static void a(Context paramContext, byb parambyb, String paramString)
  {
    a(parambyb.qTG, "", paramString, false);
    b(parambyb, "clickTopStory", System.currentTimeMillis());
    paramString = new Intent();
    try
    {
      paramString.putExtra("key_context", parambyb.toByteArray());
      label41:
      aa.c(paramContext, ".ui.home.TopStoryTabHomeUI", paramString);
      ai.d(new d.2(parambyb));
      return;
    }
    catch (IOException localIOException)
    {
      break label41;
    }
  }
  
  private static void a(List<rb> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    rb localrb = new rb();
    localrb.key = "redPointMsgId";
    localrb.sOJ = String.valueOf(paramString1);
    paramList.add(localrb);
    paramString1 = new rb();
    paramString1.key = "currentPage";
    paramString1.sOI = 1L;
    paramList.add(paramString1);
    paramString1 = new rb();
    paramString1.key = "is_prefetch";
    paramString1.sOI = 0L;
    paramList.add(paramString1);
    paramString1 = new rb();
    paramString1.key = "seq";
    paramString1.sOJ = paramString2;
    paramList.add(paramString1);
    paramString1 = new rb();
    paramString1.key = "requestId";
    paramString1.sOJ = paramString2;
    paramList.add(paramString1);
    paramString1 = new rb();
    paramString1.key = "recType";
    paramString1.sOI = 0L;
    paramList.add(paramString1);
    if (paramBoolean)
    {
      paramString1 = new rb();
      paramString1.key = "direction";
      paramString1.sOI = 1L;
      paramList.add(paramString1);
      paramString1 = new rb();
      paramString1.key = "time_zone_min";
      paramString2 = TimeZone.getDefault();
      int i = paramString2.getOffset(GregorianCalendar.getInstance(paramString2).getTimeInMillis());
      paramString1.sOJ = ((0 - i) / 1000 / 60);
      paramList.add(paramString1);
    }
  }
  
  public static final String an(String paramString, long paramLong)
  {
    return paramString + "_" + paramLong;
  }
  
  private static void b(byb parambyb, String paramString, long paramLong)
  {
    h.a(parambyb, paramString, paramLong);
    if (parambyb.tNZ.size() != 0) {
      return;
    }
    bye localbye = new bye();
    localbye.name = paramString;
    localbye.timestamp = paramLong;
    parambyb.tNZ.add(localbye);
  }
  
  private static boolean bNi()
  {
    rz localrz = new rz();
    localrz.cbC.actionType = 1;
    a.udP.m(localrz);
    return localrz.cbD.cbE;
  }
  
  public static final String bNj()
  {
    Object localObject = new rz();
    ((rz)localObject).cbC.actionType = 3;
    a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    String str = "";
    if (((rz)localObject).cbD.cbF != null) {
      str = ((rz)localObject).cbD.cbF.tNY;
    }
    localObject = str;
    if (bk.bl(str)) {
      localObject = UUID.randomUUID().toString();
    }
    return localObject;
  }
  
  public static final void c(byb parambyb, String paramString, long paramLong)
  {
    h.a(parambyb, paramString, paramLong);
    if (parambyb.tNZ.size() > 0)
    {
      bye localbye = new bye();
      localbye.name = paramString;
      localbye.timestamp = paramLong;
      parambyb.tNZ.add(localbye);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d
 * JD-Core Version:    0.7.0.1
 */