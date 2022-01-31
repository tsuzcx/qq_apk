package com.tencent.xweb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import com.tencent.xweb.xwalk.a.b;
import com.tencent.xweb.xwalk.a.c;
import com.tencent.xweb.xwalk.a.e;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  public static final String[] BCY = { "ppt", "pptx", "xls", "xlsx", "doc", "docx", "pdf" };
  public static String BCZ = "open_x5_from_scene";
  
  public static d.a a(String paramString, d.a parama, boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(151394);
    c(paramIntent, 40);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("FileReaderHelper", "getReaderType fileExt is empty");
      AppMethodBeat.o(151394);
      return parama;
    }
    String str = paramString.toLowerCase();
    paramString = parama;
    if (parama == d.a.BDa)
    {
      if (q.dYn() == null) {
        break label173;
      }
      paramString = q.dYn().axX(str);
      Log.i("FileReaderHelper", "getReaderType force type: " + paramString.toString());
      c(paramIntent, 41);
    }
    for (;;)
    {
      parama = paramString;
      if (paramString == d.a.BDa)
      {
        parama = a.axK(str);
        Log.i("FileReaderHelper", "getReaderType cmd type: " + parama.toString());
        c(paramIntent, 42);
      }
      if ((parama != d.a.BDc) && (parama != d.a.BDa)) {
        break;
      }
      Log.i("FileReaderHelper", "getReaderType use x5");
      paramString = d.a.BDc;
      AppMethodBeat.o(151394);
      return paramString;
      label173:
      Log.e("FileReaderHelper", "getReaderType WebDebugCfg is null, skip force");
      paramString = parama;
    }
    boolean bool = false;
    if (q.dYn() != null) {
      bool = q.dYn().dYp();
    }
    if ((!bool) && (z.axZ(str)))
    {
      Log.i("FileReaderHelper", "getReaderType recent crashed, use x5");
      c(paramIntent, 43);
      paramString = d.a.BDc;
      AppMethodBeat.o(151394);
      return paramString;
    }
    if ((str.endsWith("ppt")) || (str.endsWith("pptx")))
    {
      paramString = (b)e.ayq("XFilesPPTReader");
      if (paramString == null)
      {
        Log.i("FileReaderHelper", "getPPTReaderType plugin not found, use x5");
        c(paramIntent, 44);
        paramString = d.a.BDc;
        AppMethodBeat.o(151394);
        return paramString;
      }
      if (paramString.BKm < 0)
      {
        Log.i("FileReaderHelper", "getPPTReaderType invalid version, try again");
        paramString.ean();
      }
      if (paramString.BKm < 0)
      {
        Log.i("FileReaderHelper", "getPPTReaderType plugin not installed, use x5");
        c(paramIntent, 45);
        paramString = d.a.BDc;
        AppMethodBeat.o(151394);
        return paramString;
      }
      if (paramString.BKm < 203)
      {
        Log.i("FileReaderHelper", "getPPTReaderType plugin version is too old, require: 203, use x5");
        c(paramIntent, 46);
        paramString = d.a.BDc;
        AppMethodBeat.o(151394);
        return paramString;
      }
      if (paramString.cB(str, paramBoolean))
      {
        Log.i("FileReaderHelper", "getPPTReaderType plugin support, use xweb");
        paramString = d.a.BDb;
        AppMethodBeat.o(151394);
        return paramString;
      }
      Log.i("FileReaderHelper", "getPPTReaderType plugin not support, use x5");
      c(paramIntent, 47);
      paramString = d.a.BDc;
      AppMethodBeat.o(151394);
      return paramString;
    }
    Log.i("FileReaderHelper", str + " is not supported, use x5");
    c(paramIntent, 47);
    paramString = d.a.BDc;
    AppMethodBeat.o(151394);
    return paramString;
  }
  
  public static void a(String paramString, d.a parama)
  {
    AppMethodBeat.i(151400);
    if ((paramString == null) || (paramString.isEmpty()) || (parama == null))
    {
      Log.e("FileReaderHelper", "reportReadFailed param is null");
      AppMethodBeat.o(151400);
      return;
    }
    paramString = paramString.toLowerCase();
    d.b localb = axT(paramString);
    if (localb == null)
    {
      Log.i("FileReaderHelper", "reportReadFailed skip " + paramString + ", " + parama.name());
      AppMethodBeat.o(151400);
      return;
    }
    int i;
    if (parama == d.a.BDb)
    {
      if (localb.BDf) {}
      for (i = 13;; i = 12)
      {
        Log.i("FileReaderHelper", "reportReadFailed id:" + localb.BDe + ", key:" + i);
        f.m(localb.BDe, i, 1L);
        AppMethodBeat.o(151400);
        return;
      }
    }
    if (parama == d.a.BDc)
    {
      if (localb.BDf) {}
      for (i = 15;; i = 14) {
        break;
      }
    }
    Log.e("FileReaderHelper", "reportReadFailed unknown reader type");
    AppMethodBeat.o(151400);
  }
  
  public static void aL(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151401);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("FileReaderHelper", "reportXWebPPTFailReason param is null");
      AppMethodBeat.o(151401);
      return;
    }
    paramString = paramString.toLowerCase();
    paramString = paramInt1 + "," + paramString + "," + paramInt2;
    Log.i("FileReaderHelper", "reportXWebPPTFailReason kv key:17566, val:".concat(String.valueOf(paramString)));
    f.bW(17566, paramString);
    switch (paramInt2)
    {
    default: 
      Log.e("FileReaderHelper", "reportXWebPPTFailReason idkey unknown ret: ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(151401);
      return;
    case -1: 
      paramInt1 = 151;
    }
    for (;;)
    {
      Log.i("FileReaderHelper", "reportXWebPPTFailReason idkey id:1068, key:".concat(String.valueOf(paramInt1)));
      f.m(1068L, paramInt1, 1L);
      AppMethodBeat.o(151401);
      return;
      paramInt1 = 152;
      continue;
      paramInt1 = 153;
      continue;
      paramInt1 = 154;
      continue;
      paramInt1 = 155;
      continue;
      paramInt1 = 156;
      continue;
      paramInt1 = 157;
      continue;
      paramInt1 = 158;
      continue;
      paramInt1 = 159;
      continue;
      paramInt1 = 160;
      continue;
      paramInt1 = 161;
    }
  }
  
  private static d.b axT(String paramString)
  {
    AppMethodBeat.i(151396);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("FileReaderHelper", "getReportTarget fileExt is null");
      AppMethodBeat.o(151396);
      return null;
    }
    if (paramString.endsWith("ppt"))
    {
      paramString = new d.b(1068, false);
      AppMethodBeat.o(151396);
      return paramString;
    }
    if (paramString.endsWith("pptx"))
    {
      paramString = new d.b(1068, true);
      AppMethodBeat.o(151396);
      return paramString;
    }
    if (paramString.endsWith("xls"))
    {
      paramString = new d.b(1070, false);
      AppMethodBeat.o(151396);
      return paramString;
    }
    if (paramString.endsWith("xlsx"))
    {
      paramString = new d.b(1070, true);
      AppMethodBeat.o(151396);
      return paramString;
    }
    if (paramString.endsWith("doc"))
    {
      paramString = new d.b(1069, false);
      AppMethodBeat.o(151396);
      return paramString;
    }
    if (paramString.endsWith("docx"))
    {
      paramString = new d.b(1069, true);
      AppMethodBeat.o(151396);
      return paramString;
    }
    if (paramString.endsWith("pdf"))
    {
      paramString = new d.b(1071, false);
      AppMethodBeat.o(151396);
      return paramString;
    }
    AppMethodBeat.o(151396);
    return null;
  }
  
  private static void c(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(151395);
    if (paramIntent != null) {
      paramIntent.putExtra(BCZ, paramInt);
    }
    AppMethodBeat.o(151395);
  }
  
  public static void fj(String paramString, int paramInt)
  {
    AppMethodBeat.i(151398);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("FileReaderHelper", "reportReadByX5Scene param is null");
      AppMethodBeat.o(151398);
      return;
    }
    paramString = paramString.toLowerCase();
    Object localObject = paramString + "," + paramInt;
    Log.i("FileReaderHelper", "reportReadByX5Scene kv key:17563, val:".concat(String.valueOf(localObject)));
    f.bW(17563, (String)localObject);
    localObject = axT(paramString);
    if (localObject == null)
    {
      Log.i("FileReaderHelper", "reportReadByX5Scene idkey skip ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(151398);
      return;
    }
    Log.i("FileReaderHelper", "reportReadByX5Scene idkey id:" + ((d.b)localObject).BDe + ", key:" + paramInt);
    f.m(((d.b)localObject).BDe, paramInt, 1L);
    AppMethodBeat.o(151398);
  }
  
  public static void iX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151397);
    if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      Log.e("FileReaderHelper", "reportFileSize param is null");
      AppMethodBeat.o(151397);
      return;
    }
    paramString2 = paramString2.toLowerCase();
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      Log.e("FileReaderHelper", "reportFileSize file not exist");
      AppMethodBeat.o(151397);
      return;
    }
    long l2 = paramString1.length() / 1048576L;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = l2 + 1L;
    }
    paramString1 = paramString2 + "," + l1;
    Log.i("FileReaderHelper", "reportFileSize kv key:17562, val:".concat(String.valueOf(paramString1)));
    f.bW(17562, paramString1);
    paramString1 = axT(paramString2);
    if (paramString1 == null)
    {
      Log.i("FileReaderHelper", "reportFileSize idkey skip ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(151397);
      return;
    }
    if (l1 <= 10L)
    {
      if (paramString1.BDf) {}
      for (i = 24;; i = 20)
      {
        Log.i("FileReaderHelper", "reportFileSize idkey id:" + paramString1.BDe + ", key:" + i);
        f.m(paramString1.BDe, i, 1L);
        AppMethodBeat.o(151397);
        return;
      }
    }
    if (l1 <= 20L)
    {
      if (paramString1.BDf) {}
      for (i = 25;; i = 21) {
        break;
      }
    }
    if (l1 <= 50L)
    {
      if (paramString1.BDf) {}
      for (i = 26;; i = 22) {
        break;
      }
    }
    if (paramString1.BDf) {}
    for (int i = 27;; i = 23) {
      break;
    }
  }
  
  public static void iY(String paramString1, String paramString2)
  {
    int m = 1;
    AppMethodBeat.i(155567);
    if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      Log.e("FileReaderHelper", "reportPVUV param is null");
      AppMethodBeat.o(155567);
      return;
    }
    Object localObject2 = paramString1.toLowerCase();
    Object localObject1 = axT((String)localObject2);
    if (localObject1 == null)
    {
      Log.i("FileReaderHelper", "reportPVUV skip " + (String)localObject2 + ", " + paramString2);
      AppMethodBeat.o(155567);
      return;
    }
    int i;
    int j;
    label136:
    int k;
    if (d.a.BDb.name().equalsIgnoreCase(paramString2)) {
      if (((d.b)localObject1).BDf)
      {
        i = 1;
        if (!((d.b)localObject1).BDf) {
          break label372;
        }
        j = 3;
        k = j;
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
        paramString2 = (String)localObject2 + "_" + paramString2 + "__report_uv_date";
        localObject2 = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
        if (localObject2 != null)
        {
          if (((SharedPreferences)localObject2).getString(paramString2, "").equals(paramString1)) {
            break label620;
          }
          k = m;
          Log.i("FileReaderHelper", "reportPV id:" + ((d.b)localObject1).BDe + ", key:" + j);
          f.m(((d.b)localObject1).BDe, j, 1L);
          if (k == 0) {
            continue;
          }
          Log.i("FileReaderHelper", "reportUV id:" + ((d.b)localObject1).BDe + ", key:" + i);
          f.m(((d.b)localObject1).BDe, i, 1L);
          localObject1 = ((SharedPreferences)localObject2).edit();
          if (localObject1 == null) {
            continue;
          }
          ((SharedPreferences.Editor)localObject1).putString(paramString2, paramString1);
          ((SharedPreferences.Editor)localObject1).commit();
          AppMethodBeat.o(155567);
          return;
          i = 0;
          break;
          label372:
          j = 2;
          break label136;
          if (d.a.BDc.name().equalsIgnoreCase(paramString2))
          {
            if (((d.b)localObject1).BDf)
            {
              i = 5;
              if (((d.b)localObject1).BDf)
              {
                j = 7;
                k = i;
                i = j;
                j = k;
              }
            }
            else
            {
              i = 4;
              continue;
            }
            j = 6;
            continue;
          }
          if ("QQBROWSER".equalsIgnoreCase(paramString2))
          {
            if (((d.b)localObject1).BDf)
            {
              i = 17;
              if (((d.b)localObject1).BDf)
              {
                j = 19;
                k = i;
                i = j;
                j = k;
              }
            }
            else
            {
              i = 16;
              continue;
            }
            j = 18;
            continue;
          }
          if ("THIRDAPP".equalsIgnoreCase(paramString2))
          {
            if (((d.b)localObject1).BDf)
            {
              i = 9;
              if (((d.b)localObject1).BDf)
              {
                j = 11;
                k = i;
                i = j;
                j = k;
              }
            }
            else
            {
              i = 8;
              continue;
            }
            j = 10;
            continue;
          }
          Log.e("FileReaderHelper", "reportPVUV unknown type, skip");
          AppMethodBeat.o(155567);
          return;
        }
      }
      catch (Exception paramString1)
      {
        Log.e("FileReaderHelper", "reportPVUV get cur date error: " + paramString1.getMessage());
        paramString1 = "";
        continue;
        Log.e("FileReaderHelper", "reportPVUV sp is null, skip uv report");
        k = 0;
        continue;
        Log.e("FileReaderHelper", "reportPVUV editor is null, skip");
        AppMethodBeat.o(155567);
        return;
      }
      label620:
      k = 0;
    }
  }
  
  public static long jR(Context paramContext)
  {
    AppMethodBeat.i(151402);
    if (paramContext == null)
    {
      AppMethodBeat.o(151402);
      return 0L;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      AppMethodBeat.o(151402);
      return 0L;
    }
    paramContext = paramContext.getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((paramContext == null) || (paramContext.length <= 0))
    {
      AppMethodBeat.o(151402);
      return 0L;
    }
    int i = paramContext[0].getTotalPrivateClean();
    long l = (paramContext[0].getTotalPrivateDirty() + i) / 1024;
    Log.i("FileReaderHelper", "getCurrentProcessMemory ".concat(String.valueOf(l)));
    AppMethodBeat.o(151402);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.d
 * JD-Core Version:    0.7.0.1
 */