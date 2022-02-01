package com.tencent.xweb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.a.k;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class f
{
  public static final String[] IMr = { "ppt", "pptx", "xls", "xlsx", "doc", "docx", "pdf" };
  public static String IMs = "open_x5_from_scene";
  
  public static f.a a(String paramString, f.a parama, boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(156735);
    c(paramIntent, 40);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "getReaderType fileExt is empty");
      AppMethodBeat.o(156735);
      return parama;
    }
    String str = paramString.toLowerCase();
    paramString = parama;
    if (parama == f.a.IMt)
    {
      if (x.fqR() == null) {
        break label173;
      }
      paramString = x.fqR().aPd(str);
      Log.i("XFilesReaderHelper", "getReaderType force type: " + paramString.toString());
      c(paramIntent, 41);
    }
    for (;;)
    {
      parama = paramString;
      if (paramString == f.a.IMt)
      {
        parama = b.aOT(str);
        Log.i("XFilesReaderHelper", "getReaderType cmd type: " + parama.toString());
        c(paramIntent, 42);
      }
      if ((parama != f.a.IMv) && (parama != f.a.IMt)) {
        break;
      }
      Log.i("XFilesReaderHelper", "getReaderType use x5");
      paramString = f.a.IMv;
      AppMethodBeat.o(156735);
      return paramString;
      label173:
      Log.e("XFilesReaderHelper", "getReaderType WebDebugCfg is null, skip force");
      paramString = parama;
    }
    boolean bool = false;
    if (x.fqR() != null) {
      bool = x.fqR().fqT();
    }
    if ((!bool) && (e.aOV(str)))
    {
      Log.i("XFilesReaderHelper", "getReaderType recent crashed, use x5");
      c(paramIntent, 43);
      paramString = f.a.IMv;
      AppMethodBeat.o(156735);
      return paramString;
    }
    paramString = aOW(str);
    if (!(paramString instanceof k))
    {
      Log.i("XFilesReaderHelper", str + " is not supported, use x5");
      c(paramIntent, 47);
      paramString = f.a.IMv;
      AppMethodBeat.o(156735);
      return paramString;
    }
    paramString = (k)paramString;
    if (paramString.IUH < 0)
    {
      Log.i("XFilesReaderHelper", "getReaderType invalid version, try again");
      paramString.fti();
    }
    if (paramString.IUH < 0)
    {
      Log.i("XFilesReaderHelper", "getReaderType plugin not installed, use x5");
      c(paramIntent, 45);
      paramString = f.a.IMv;
      AppMethodBeat.o(156735);
      return paramString;
    }
    if (paramString.IUH < paramString.ftf())
    {
      Log.i("XFilesReaderHelper", "getReaderType plugin version is too old, require: " + paramString.ftf() + ", use x5");
      c(paramIntent, 46);
      paramString = f.a.IMv;
      AppMethodBeat.o(156735);
      return paramString;
    }
    if (paramString.dj(str, paramBoolean))
    {
      Log.i("XFilesReaderHelper", "getReaderType plugin support, use xweb");
      paramString = f.a.IMu;
      AppMethodBeat.o(156735);
      return paramString;
    }
    Log.i("XFilesReaderHelper", "getReaderType plugin not support, use x5");
    c(paramIntent, 47);
    paramString = f.a.IMv;
    AppMethodBeat.o(156735);
    return paramString;
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    AppMethodBeat.i(156744);
    if (paramString1.isEmpty())
    {
      Log.e("XFilesReaderHelper", "reportException wrong param");
      AppMethodBeat.o(156744);
      return;
    }
    try
    {
      Object localObject = new StringWriter();
      paramException.printStackTrace(new PrintWriter((Writer)localObject));
      String str = ((StringWriter)localObject).toString();
      localObject = str;
      if (str.isEmpty()) {
        localObject = "empty";
      }
      localObject = ((String)localObject).substring(0, Math.min(((String)localObject).length(), 1000)).replace(',', ' ').replace(':', ' ');
      paramException = paramString2 + " " + paramException.getMessage();
      paramString2 = paramException;
      if (paramException.isEmpty()) {
        paramString2 = "empty";
      }
      paramString2 = paramString2.substring(0, Math.min(paramString2.length(), 1000)).replace(',', ' ').replace(':', ' ');
      paramString1 = paramInt + "," + paramString1 + "," + (String)localObject + "," + paramString2;
      Log.d("XFilesReaderHelper", "reportException kv key:17565, val:".concat(String.valueOf(paramString1)));
      com.tencent.xweb.util.g.cR(17565, paramString1);
      AppMethodBeat.o(156744);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderHelper", "reportException error: ", paramString1);
      AppMethodBeat.o(156744);
    }
  }
  
  public static com.tencent.xweb.xwalk.a.e aOW(String paramString)
  {
    AppMethodBeat.i(156736);
    if (paramString == null)
    {
      AppMethodBeat.o(156736);
      return null;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      paramString = com.tencent.xweb.xwalk.a.g.aOW("XFilesPPTReader");
      AppMethodBeat.o(156736);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      paramString = com.tencent.xweb.xwalk.a.g.aOW("XFilesPDFReader");
      AppMethodBeat.o(156736);
      return paramString;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      paramString = com.tencent.xweb.xwalk.a.g.aOW("XFilesWordReader");
      AppMethodBeat.o(156736);
      return paramString;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx")))
    {
      paramString = com.tencent.xweb.xwalk.a.g.aOW("XFilesExcelReader");
      AppMethodBeat.o(156736);
      return paramString;
    }
    AppMethodBeat.o(156736);
    return null;
  }
  
  private static b aOX(String paramString)
  {
    AppMethodBeat.i(156738);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "getReportTarget fileExt is null");
      AppMethodBeat.o(156738);
      return null;
    }
    if (paramString.equalsIgnoreCase("ppt"))
    {
      paramString = new b(1068, false);
      AppMethodBeat.o(156738);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("pptx"))
    {
      paramString = new b(1068, true);
      AppMethodBeat.o(156738);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("xls"))
    {
      paramString = new b(1070, false);
      AppMethodBeat.o(156738);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("xlsx"))
    {
      paramString = new b(1070, true);
      AppMethodBeat.o(156738);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("doc"))
    {
      paramString = new b(1069, false);
      AppMethodBeat.o(156738);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("docx"))
    {
      paramString = new b(1069, true);
      AppMethodBeat.o(156738);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      paramString = new b(1071, false);
      AppMethodBeat.o(156738);
      return paramString;
    }
    AppMethodBeat.o(156738);
    return null;
  }
  
  public static void aW(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156743);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "reportXWebErrorCode param is null");
      AppMethodBeat.o(156743);
      return;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(156743);
      return;
    }
    String str = paramString.toLowerCase();
    paramString = aOX(str);
    if (paramString == null)
    {
      Log.d("XFilesReaderHelper", "reportXWebErrorCode skip ".concat(String.valueOf(str)));
      AppMethodBeat.o(156743);
      return;
    }
    str = paramInt1 + "," + str + "," + paramInt2 + ",xweb";
    Log.d("XFilesReaderHelper", "reportXWebErrorCode kv key:17566, val:".concat(String.valueOf(str)));
    com.tencent.xweb.util.g.cR(17566, str);
    if (paramString.IMy) {}
    for (paramInt1 = 13;; paramInt1 = 12)
    {
      Log.d("XFilesReaderHelper", "reportXWebErrorCode first idkey id:" + paramString.IMx + ", key:" + paramInt1);
      com.tencent.xweb.util.g.r(paramString.IMx, paramInt1, 1L);
      switch (paramInt2)
      {
      default: 
        Log.e("XFilesReaderHelper", "reportXWebErrorCode idkey unknown ret: ".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(156743);
        return;
      }
    }
    paramInt1 = 151;
    for (;;)
    {
      Log.d("XFilesReaderHelper", "reportXWebErrorCode second idkey id:" + paramString.IMx + ", key:" + paramInt1);
      com.tencent.xweb.util.g.r(paramString.IMx, paramInt1, 1L);
      AppMethodBeat.o(156743);
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
      continue;
      paramInt1 = 162;
      continue;
      paramInt1 = 163;
    }
  }
  
  public static void b(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(156742);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "reportX5ErrorCode param is null");
      AppMethodBeat.o(156742);
      return;
    }
    paramString = paramString.toLowerCase();
    b localb = aOX(paramString);
    if (localb == null)
    {
      Log.d("XFilesReaderHelper", "reportX5ErrorCode skip ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156742);
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramBoolean)
      {
        paramString = "-1," + paramString + "," + paramInt1 + ",x5init";
        Log.d("XFilesReaderHelper", "reportX5ErrorCode kv key:17566, val:".concat(String.valueOf(paramString)));
        com.tencent.xweb.util.g.cR(17566, paramString);
      }
    }
    else if ((paramBoolean) || (paramInt1 == -102))
    {
      if (!localb.IMy) {
        break label310;
      }
      paramInt1 = 15;
      label154:
      Log.d("XFilesReaderHelper", "reportX5ErrorCode idkey id:" + localb.IMx + ", key:" + paramInt1);
      com.tencent.xweb.util.g.r(localb.IMx, paramInt1, 1L);
      if (paramInt2 == 49) {
        if (!localb.IMy) {
          break label316;
        }
      }
    }
    label310:
    label316:
    for (paramInt1 = 39;; paramInt1 = 38)
    {
      Log.d("XFilesReaderHelper", "reportX5ErrorCode XWeb and X5 All failed id:" + localb.IMx + ", key:" + paramInt1);
      com.tencent.xweb.util.g.r(localb.IMx, paramInt1, 1L);
      AppMethodBeat.o(156742);
      return;
      paramString = "-1," + paramString + "," + paramInt1 + ",x5";
      break;
      paramInt1 = 14;
      break label154;
    }
  }
  
  private static void c(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(156737);
    if (paramIntent != null) {
      paramIntent.putExtra(IMs, paramInt);
    }
    AppMethodBeat.o(156737);
  }
  
  public static void gE(String paramString, int paramInt)
  {
    AppMethodBeat.i(156740);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "reportReadByX5Scene param is null");
      AppMethodBeat.o(156740);
      return;
    }
    String str = paramString.toLowerCase();
    paramString = aOX(str);
    if (paramString == null)
    {
      Log.d("XFilesReaderHelper", "reportReadByX5Scene idkey skip ".concat(String.valueOf(str)));
      AppMethodBeat.o(156740);
      return;
    }
    str = str + "," + paramInt;
    Log.d("XFilesReaderHelper", "reportReadByX5Scene kv key:17563, val:".concat(String.valueOf(str)));
    com.tencent.xweb.util.g.cR(17563, str);
    Log.d("XFilesReaderHelper", "reportReadByX5Scene idkey id:" + paramString.IMx + ", key:" + paramInt);
    com.tencent.xweb.util.g.r(paramString.IMx, paramInt, 1L);
    AppMethodBeat.o(156740);
  }
  
  public static long kV(Context paramContext)
  {
    AppMethodBeat.i(156745);
    if (paramContext == null)
    {
      AppMethodBeat.o(156745);
      return 0L;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null)
    {
      AppMethodBeat.o(156745);
      return 0L;
    }
    paramContext = paramContext.getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((paramContext == null) || (paramContext.length <= 0))
    {
      AppMethodBeat.o(156745);
      return 0L;
    }
    int i = paramContext[0].getTotalPrivateClean();
    long l = (paramContext[0].getTotalPrivateDirty() + i) / 1024;
    Log.i("XFilesReaderHelper", "getCurrentProcessMemory ".concat(String.valueOf(l)));
    AppMethodBeat.o(156745);
    return l;
  }
  
  public static void lY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156739);
    if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "reportFileSize param is null");
      AppMethodBeat.o(156739);
      return;
    }
    paramString2 = paramString2.toLowerCase();
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      Log.e("XFilesReaderHelper", "reportFileSize file not exist");
      AppMethodBeat.o(156739);
      return;
    }
    long l2 = paramString1.length() / 1048576L;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = l2 + 1L;
    }
    if (paramString2.length() > 50) {}
    for (paramString1 = paramString2.substring(0, 50);; paramString1 = paramString2)
    {
      paramString1 = paramString1 + "," + l1;
      Log.d("XFilesReaderHelper", "reportFileSize kv key:17562, val:".concat(String.valueOf(paramString1)));
      com.tencent.xweb.util.g.cR(17562, paramString1);
      paramString1 = aOX(paramString2);
      if (paramString1 != null) {
        break;
      }
      Log.d("XFilesReaderHelper", "reportFileSize idkey skip ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(156739);
      return;
    }
    if (l1 <= 10L)
    {
      if (paramString1.IMy) {}
      for (i = 24;; i = 20)
      {
        Log.d("XFilesReaderHelper", "reportFileSize idkey id:" + paramString1.IMx + ", key:" + i);
        com.tencent.xweb.util.g.r(paramString1.IMx, i, 1L);
        AppMethodBeat.o(156739);
        return;
      }
    }
    if (l1 <= 20L)
    {
      if (paramString1.IMy) {}
      for (i = 25;; i = 21) {
        break;
      }
    }
    if (l1 <= 50L)
    {
      if (paramString1.IMy) {}
      for (i = 26;; i = 22) {
        break;
      }
    }
    if (paramString1.IMy) {}
    for (int i = 27;; i = 23) {
      break;
    }
  }
  
  public static void lZ(String paramString1, String paramString2)
  {
    int m = 1;
    AppMethodBeat.i(156741);
    if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "reportPVUV param is null");
      AppMethodBeat.o(156741);
      return;
    }
    Object localObject2 = paramString1.toLowerCase();
    Object localObject1 = aOX((String)localObject2);
    if (localObject1 == null)
    {
      Log.d("XFilesReaderHelper", "reportPVUV skip " + (String)localObject2 + ", " + paramString2);
      AppMethodBeat.o(156741);
      return;
    }
    int i;
    int j;
    label137:
    int k;
    if (f.a.IMu.name().equalsIgnoreCase(paramString2)) {
      if (((b)localObject1).IMy)
      {
        i = 1;
        if (!((b)localObject1).IMy) {
          break label375;
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
            break label623;
          }
          k = m;
          Log.d("XFilesReaderHelper", "reportPV id:" + ((b)localObject1).IMx + ", key:" + j);
          com.tencent.xweb.util.g.r(((b)localObject1).IMx, j, 1L);
          if (k == 0) {
            continue;
          }
          Log.d("XFilesReaderHelper", "reportUV id:" + ((b)localObject1).IMx + ", key:" + i);
          com.tencent.xweb.util.g.r(((b)localObject1).IMx, i, 1L);
          localObject1 = ((SharedPreferences)localObject2).edit();
          if (localObject1 == null) {
            continue;
          }
          ((SharedPreferences.Editor)localObject1).putString(paramString2, paramString1);
          ((SharedPreferences.Editor)localObject1).commit();
          AppMethodBeat.o(156741);
          return;
          i = 0;
          break;
          label375:
          j = 2;
          break label137;
          if (f.a.IMv.name().equalsIgnoreCase(paramString2))
          {
            if (((b)localObject1).IMy)
            {
              i = 5;
              if (((b)localObject1).IMy)
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
            if (((b)localObject1).IMy)
            {
              i = 17;
              if (((b)localObject1).IMy)
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
            if (((b)localObject1).IMy)
            {
              i = 9;
              if (((b)localObject1).IMy)
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
          Log.e("XFilesReaderHelper", "reportPVUV unknown type, skip");
          AppMethodBeat.o(156741);
          return;
        }
      }
      catch (Exception paramString1)
      {
        Log.e("XFilesReaderHelper", "reportPVUV get cur date error: " + paramString1.getMessage());
        paramString1 = "";
        continue;
        Log.e("XFilesReaderHelper", "reportPVUV sp is null, skip uv report");
        k = 0;
        continue;
        Log.e("XFilesReaderHelper", "reportPVUV editor is null, skip");
        AppMethodBeat.o(156741);
        return;
      }
      label623:
      k = 0;
    }
  }
  
  static final class b
  {
    int IMx;
    boolean IMy;
    
    public b(int paramInt, boolean paramBoolean)
    {
      this.IMx = paramInt;
      this.IMy = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.f
 * JD-Core Version:    0.7.0.1
 */