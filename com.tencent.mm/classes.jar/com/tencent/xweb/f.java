package com.tencent.xweb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.m;
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
  public static final String[] ZZI = { "ppt", "pptx", "xls", "xlsx", "doc", "docx", "pdf" };
  public static String ZZJ = "open_x5_from_scene";
  
  public static a a(String paramString, a parama, boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(156735);
    i(paramIntent, 40);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "getReaderType fileExt is empty");
      AppMethodBeat.o(156735);
      return parama;
    }
    String str = paramString.toLowerCase();
    paramString = parama;
    if (parama == a.ZZK)
    {
      if (y.iwp() == null) {
        break label173;
      }
      paramString = y.iwp().bFk(str);
      Log.i("XFilesReaderHelper", "getReaderType force type: " + paramString.toString());
      i(paramIntent, 41);
    }
    for (;;)
    {
      parama = paramString;
      if (paramString == a.ZZK)
      {
        parama = b.bES(str);
        Log.i("XFilesReaderHelper", "getReaderType cmd type: " + parama.toString());
        i(paramIntent, 42);
      }
      if ((parama != a.ZZM) && (parama != a.ZZK)) {
        break;
      }
      Log.i("XFilesReaderHelper", "getReaderType use x5");
      paramString = a.ZZM;
      AppMethodBeat.o(156735);
      return paramString;
      label173:
      Log.e("XFilesReaderHelper", "getReaderType WebDebugCfg is null, skip force");
      paramString = parama;
    }
    if (y.iwp() != null) {}
    for (boolean bool = y.iwp().iwr();; bool = false)
    {
      if ((!bool) && (e.bEU(str)))
      {
        Log.i("XFilesReaderHelper", "getReaderType recent crashed, use x5");
        i(paramIntent, 43);
        paramString = a.ZZM;
        AppMethodBeat.o(156735);
        return paramString;
      }
      paramString = bEW(str);
      if (!(paramString instanceof m))
      {
        Log.i("XFilesReaderHelper", str + " is not supported, use x5");
        i(paramIntent, 47);
        paramString = a.ZZM;
        AppMethodBeat.o(156735);
        return paramString;
      }
      paramString = (m)paramString;
      int i = paramString.izd();
      int j = paramString.aCX(0);
      if ((i <= 0) || (i < j))
      {
        if (ak.iwQ())
        {
          Log.i("XFilesReaderHelper", "getReaderType forbid download code, use x5");
          i(paramIntent, 44);
          paramString = a.ZZM;
          AppMethodBeat.o(156735);
          return paramString;
        }
        if (!b.ivU())
        {
          Log.i("XFilesReaderHelper", "getReaderType plugin version: " + i + ", require: " + j + ", canDownloadWhenNotInstall: false, use x5");
          if (i <= 0) {}
          for (i = 45;; i = 46)
          {
            i(paramIntent, i);
            paramString = a.ZZM;
            AppMethodBeat.o(156735);
            return paramString;
          }
        }
        Log.i("XFilesReaderHelper", "getReaderType plugin version: " + i + ", require: " + j + ", canDownloadWhenNotInstall: true, use xweb");
        paramString = a.ZZL;
        AppMethodBeat.o(156735);
        return paramString;
      }
      if (paramString.ef(str, paramBoolean))
      {
        Log.i("XFilesReaderHelper", "getReaderType plugin support, use xweb");
        paramString = a.ZZL;
        AppMethodBeat.o(156735);
        return paramString;
      }
      Log.i("XFilesReaderHelper", "getReaderType plugin not support, use x5");
      i(paramIntent, 47);
      paramString = a.ZZM;
      AppMethodBeat.o(156735);
      return paramString;
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    AppMethodBeat.i(156744);
    if ((paramString1 == null) || (paramString1.isEmpty()))
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
      com.tencent.xweb.util.h.dA(17565, paramString1);
      AppMethodBeat.o(156744);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("XFilesReaderHelper", "reportException error: ", paramString1);
      AppMethodBeat.o(156744);
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
    b localb = bEX(paramString);
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
        com.tencent.xweb.util.h.dA(17566, paramString);
      }
    }
    else if ((paramBoolean) || (paramInt1 == -102))
    {
      if (!localb.ZZO) {
        break label305;
      }
      paramInt1 = 15;
      label150:
      Log.d("XFilesReaderHelper", "reportX5ErrorCode idkey id:" + localb.wed + ", key:" + paramInt1);
      com.tencent.xweb.util.h.u(localb.wed, paramInt1, 1L);
      if (paramInt2 == 49) {
        if (!localb.ZZO) {
          break label311;
        }
      }
    }
    label305:
    label311:
    for (paramInt1 = 39;; paramInt1 = 38)
    {
      Log.d("XFilesReaderHelper", "reportX5ErrorCode XWeb and X5 All failed id:" + localb.wed + ", key:" + paramInt1);
      com.tencent.xweb.util.h.u(localb.wed, paramInt1, 1L);
      AppMethodBeat.o(156742);
      return;
      paramString = "-1," + paramString + "," + paramInt1 + ",x5";
      break;
      paramInt1 = 14;
      break label150;
    }
  }
  
  private static boolean bEV(String paramString)
  {
    AppMethodBeat.i(196292);
    c localc1 = c.ZZP;
    if (y.iwp() != null)
    {
      localc1 = y.iwp().bFl(paramString);
      Log.i("XFilesReaderHelper", "getUseOfficeReader force = " + localc1.toString());
    }
    for (;;)
    {
      c localc2 = localc1;
      if (localc1 == c.ZZP)
      {
        localc2 = b.bEQ(paramString);
        Log.i("XFilesReaderHelper", "getUseOfficeReader cmd = " + localc2.toString());
      }
      if (localc2 != c.ZZQ) {
        break;
      }
      AppMethodBeat.o(196292);
      return true;
      Log.e("XFilesReaderHelper", "getUseOfficeReader WebDebugCfg is null, skip force");
    }
    AppMethodBeat.o(196292);
    return false;
  }
  
  public static g bEW(String paramString)
  {
    AppMethodBeat.i(156736);
    if (paramString == null)
    {
      AppMethodBeat.o(156736);
      return null;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      if (bEV(paramString))
      {
        paramString = com.tencent.xweb.xwalk.a.h.bEW("XFilesOfficeReader");
        AppMethodBeat.o(156736);
        return paramString;
      }
      paramString = com.tencent.xweb.xwalk.a.h.bEW("XFilesPPTReader");
      AppMethodBeat.o(156736);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      paramString = com.tencent.xweb.xwalk.a.h.bEW("XFilesPDFReader");
      AppMethodBeat.o(156736);
      return paramString;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      if (bEV(paramString))
      {
        paramString = com.tencent.xweb.xwalk.a.h.bEW("XFilesOfficeReader");
        AppMethodBeat.o(156736);
        return paramString;
      }
      paramString = com.tencent.xweb.xwalk.a.h.bEW("XFilesWordReader");
      AppMethodBeat.o(156736);
      return paramString;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx")))
    {
      if (bEV(paramString))
      {
        paramString = com.tencent.xweb.xwalk.a.h.bEW("XFilesOfficeReader");
        AppMethodBeat.o(156736);
        return paramString;
      }
      paramString = com.tencent.xweb.xwalk.a.h.bEW("XFilesExcelReader");
      AppMethodBeat.o(156736);
      return paramString;
    }
    AppMethodBeat.o(156736);
    return null;
  }
  
  private static b bEX(String paramString)
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
  
  public static void bEY(String paramString)
  {
    AppMethodBeat.i(196339);
    iw(paramString, 74);
    AppMethodBeat.o(196339);
  }
  
  public static void bEZ(String paramString)
  {
    AppMethodBeat.i(196341);
    iw(paramString, 75);
    AppMethodBeat.o(196341);
  }
  
  public static void bFa(String paramString)
  {
    AppMethodBeat.i(196343);
    iw(paramString, 76);
    AppMethodBeat.o(196343);
  }
  
  public static void bFb(String paramString)
  {
    AppMethodBeat.i(196344);
    iw(paramString, 77);
    AppMethodBeat.o(196344);
  }
  
  public static void bFc(String paramString)
  {
    AppMethodBeat.i(196345);
    iw(paramString, 78);
    AppMethodBeat.o(196345);
  }
  
  public static void bFd(String paramString)
  {
    AppMethodBeat.i(196346);
    iw(paramString, 80);
    AppMethodBeat.o(196346);
  }
  
  public static void bb(String paramString, int paramInt1, int paramInt2)
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
    paramString = bEX(str);
    if (paramString == null)
    {
      Log.d("XFilesReaderHelper", "reportXWebErrorCode skip ".concat(String.valueOf(str)));
      AppMethodBeat.o(156743);
      return;
    }
    str = paramInt1 + "," + str + "," + paramInt2 + ",xweb";
    Log.d("XFilesReaderHelper", "reportXWebErrorCode kv key:17566, val:".concat(String.valueOf(str)));
    com.tencent.xweb.util.h.dA(17566, str);
    if (paramString.ZZO) {}
    for (paramInt1 = 13;; paramInt1 = 12)
    {
      Log.d("XFilesReaderHelper", "reportXWebErrorCode first idkey id:" + paramString.wed + ", key:" + paramInt1);
      com.tencent.xweb.util.h.u(paramString.wed, paramInt1, 1L);
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
      Log.d("XFilesReaderHelper", "reportXWebErrorCode second idkey id:" + paramString.wed + ", key:" + paramInt1);
      com.tencent.xweb.util.h.u(paramString.wed, paramInt1, 1L);
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
      continue;
      paramInt1 = 164;
      continue;
      paramInt1 = 165;
      continue;
      paramInt1 = 166;
      continue;
      paramInt1 = 167;
    }
  }
  
  private static void i(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(156737);
    if (paramIntent != null) {
      paramIntent.putExtra(ZZJ, paramInt);
    }
    AppMethodBeat.o(156737);
  }
  
  public static void iv(String paramString, int paramInt)
  {
    AppMethodBeat.i(156740);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "reportReadByX5Scene param is null");
      AppMethodBeat.o(156740);
      return;
    }
    String str = paramString.toLowerCase();
    paramString = bEX(str);
    if (paramString == null)
    {
      Log.d("XFilesReaderHelper", "reportReadByX5Scene idkey skip ".concat(String.valueOf(str)));
      AppMethodBeat.o(156740);
      return;
    }
    str = str + "," + paramInt;
    Log.d("XFilesReaderHelper", "reportReadByX5Scene kv key:17563, val:".concat(String.valueOf(str)));
    com.tencent.xweb.util.h.dA(17563, str);
    Log.d("XFilesReaderHelper", "reportReadByX5Scene idkey id:" + paramString.wed + ", key:" + paramInt);
    com.tencent.xweb.util.h.u(paramString.wed, paramInt, 1L);
    AppMethodBeat.o(156740);
  }
  
  private static void iw(String paramString, int paramInt)
  {
    AppMethodBeat.i(196338);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "reportIDKeyByFileExt param is null");
      AppMethodBeat.o(196338);
      return;
    }
    paramString = paramString.toLowerCase();
    b localb = bEX(paramString);
    if (localb == null)
    {
      Log.d("XFilesReaderHelper", "reportIDKeyByFileExt skip ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(196338);
      return;
    }
    Log.d("XFilesReaderHelper", "reportIDKeyByFileExt id:" + localb.wed + ", key:" + paramInt);
    com.tencent.xweb.util.h.u(localb.wed, paramInt, 1L);
    AppMethodBeat.o(196338);
  }
  
  public static void ix(String paramString, int paramInt)
  {
    AppMethodBeat.i(196353);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XFilesReaderHelper", "reportDownloadErrorCode param is null");
      AppMethodBeat.o(196353);
      return;
    }
    paramString = paramString.toLowerCase();
    b localb = bEX(paramString);
    if (localb == null)
    {
      Log.d("XFilesReaderHelper", "reportDownloadErrorCode skip ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(196353);
      return;
    }
    switch (paramInt)
    {
    default: 
      Log.e("XFilesReaderHelper", "reportDownloadErrorCode idkey unknown ret: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(196353);
      return;
    case 0: 
      paramInt = 79;
    }
    for (;;)
    {
      Log.d("XFilesReaderHelper", "reportDownloadErrorCode idkey id:" + localb.wed + ", key:" + paramInt);
      com.tencent.xweb.util.h.u(localb.wed, paramInt, 1L);
      AppMethodBeat.o(196353);
      return;
      paramInt = 81;
      continue;
      paramInt = 82;
      continue;
      paramInt = 83;
      continue;
      paramInt = 84;
      continue;
      paramInt = 85;
      continue;
      paramInt = 86;
      continue;
      paramInt = 87;
      continue;
      paramInt = 88;
      continue;
      paramInt = 89;
    }
  }
  
  public static long mz(Context paramContext)
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
  
  public static void oT(String paramString1, String paramString2)
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
      com.tencent.xweb.util.h.dA(17562, paramString1);
      paramString1 = bEX(paramString2);
      if (paramString1 != null) {
        break;
      }
      Log.d("XFilesReaderHelper", "reportFileSize idkey skip ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(156739);
      return;
    }
    if (l1 <= 10L)
    {
      if (paramString1.ZZO) {}
      for (i = 24;; i = 20)
      {
        Log.d("XFilesReaderHelper", "reportFileSize idkey id:" + paramString1.wed + ", key:" + i);
        com.tencent.xweb.util.h.u(paramString1.wed, i, 1L);
        AppMethodBeat.o(156739);
        return;
      }
    }
    if (l1 <= 20L)
    {
      if (paramString1.ZZO) {}
      for (i = 25;; i = 21) {
        break;
      }
    }
    if (l1 <= 50L)
    {
      if (paramString1.ZZO) {}
      for (i = 26;; i = 22) {
        break;
      }
    }
    if (paramString1.ZZO) {}
    for (int i = 27;; i = 23) {
      break;
    }
  }
  
  public static void oU(String paramString1, String paramString2)
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
    Object localObject1 = bEX((String)localObject2);
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
    if (a.ZZL.name().equalsIgnoreCase(paramString2)) {
      if (((b)localObject1).ZZO)
      {
        i = 1;
        if (!((b)localObject1).ZZO) {
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
          Log.d("XFilesReaderHelper", "reportPV id:" + ((b)localObject1).wed + ", key:" + j);
          com.tencent.xweb.util.h.u(((b)localObject1).wed, j, 1L);
          if (k == 0) {
            continue;
          }
          Log.d("XFilesReaderHelper", "reportUV id:" + ((b)localObject1).wed + ", key:" + i);
          com.tencent.xweb.util.h.u(((b)localObject1).wed, i, 1L);
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
          if (a.ZZM.name().equalsIgnoreCase(paramString2))
          {
            if (((b)localObject1).ZZO)
            {
              i = 5;
              if (((b)localObject1).ZZO)
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
            if (((b)localObject1).ZZO)
            {
              i = 17;
              if (((b)localObject1).ZZO)
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
            if (((b)localObject1).ZZO)
            {
              i = 9;
              if (((b)localObject1).ZZO)
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
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156734);
      ZZK = new a("NONE", 0);
      ZZL = new a("XWEB", 1);
      ZZM = new a("X5", 2);
      ZZN = new a[] { ZZK, ZZL, ZZM };
      AppMethodBeat.o(156734);
    }
    
    private a() {}
  }
  
  static final class b
  {
    boolean ZZO;
    int wed;
    
    public b(int paramInt, boolean paramBoolean)
    {
      this.wed = paramInt;
      this.ZZO = paramBoolean;
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(196114);
      ZZP = new c("none", 0);
      ZZQ = new c("yes", 1);
      ZZR = new c("no", 2);
      ZZS = new c[] { ZZP, ZZQ, ZZR };
      AppMethodBeat.o(196114);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.f
 * JD-Core Version:    0.7.0.1
 */