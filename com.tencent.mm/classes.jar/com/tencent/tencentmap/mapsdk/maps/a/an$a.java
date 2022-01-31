package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.Deflater;

public class an$a
{
  private static String a;
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(147224);
    try
    {
      String str2 = b(paramString, ac.c());
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = b(paramString, 0);
      }
      i = Integer.parseInt(str1);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        int i = paramInt3;
      }
    }
    paramInt1 = dd.a(i, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(147224);
    return paramInt1;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    int i = 100;
    int j = 1;
    AppMethodBeat.i(147228);
    if (paramInt1 == 2)
    {
      paramInt1 = c(paramString, paramInt2);
      AppMethodBeat.o(147228);
      return paramInt1;
    }
    if (("HLHttpDirect".equals(paramString)) && (paramMap != null) && ("event".equals((String)paramMap.get("B15"))))
    {
      paramInt1 = c(paramString, paramInt2);
      AppMethodBeat.o(147228);
      return paramInt1;
    }
    int k = -1;
    if ("HLConnEvent".equals(paramString)) {
      if (paramInt2 == 0)
      {
        paramString = "report_conn_succ_denominator_value";
        if (paramInt2 != 0) {
          break label175;
        }
        paramInt1 = 100;
        label101:
        paramInt2 = k;
        label104:
        if (paramInt2 != -1) {
          break label655;
        }
        paramInt2 = a("report_all_events", -1, 1, 0);
        if (paramInt2 != 1) {
          break label633;
        }
        paramInt1 = j;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(147228);
      return paramInt1;
      if ((paramInt2 == -4) || (paramInt2 == -3) || (paramInt2 == -288)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label169;
        }
        paramString = "report_conn_nonet_fail_denominator_value";
        break;
      }
      label169:
      paramString = "report_conn_other_fail_denominator_value";
      break;
      label175:
      if ((paramInt2 == -4) || (paramInt2 == -3) || (paramInt2 == -288)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label211;
        }
        paramInt1 = 100;
        break;
      }
      label211:
      paramInt1 = 1;
      break label101;
      if ("HLSecurityEvent".equals(paramString))
      {
        if (paramInt2 == 0)
        {
          paramString = "report_security_req_succ_denominator_value";
          label232:
          if (paramInt2 != 0) {
            break label251;
          }
        }
        label251:
        for (paramInt1 = i;; paramInt1 = 1)
        {
          paramInt2 = k;
          break;
          paramString = "report_security_req_fail_denominator_value";
          break label232;
        }
      }
      if ("HLDisconnEvent".equals(paramString))
      {
        paramInt1 = 2;
        paramString = "report_disconn_denominator_value";
        paramInt2 = k;
        break label104;
      }
      if (("HLReqRspEvent".equals(paramString)) || ("HLHttpAgent".equals(paramString)) || ("HLHttpDirect".equals(paramString)))
      {
        if ((paramInt2 == 0) && (paramMap != null) && (db.a(paramString, paramInt1, paramMap)))
        {
          paramMap.put("B28", "1");
          paramString = "report_req_ssl_first_denominator_value";
          paramInt1 = i;
          paramInt2 = k;
          break label104;
        }
        if (paramInt2 == 0) {
          paramString = "report_req_succ_denominator_value";
        }
        for (;;)
        {
          if (paramInt2 != 0) {
            break label405;
          }
          paramInt1 = i;
          paramInt2 = k;
          break;
          if ((paramInt2 == -4) || (paramInt2 == -3) || (paramInt2 == -288)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label399;
            }
            paramString = "report_req_nonet_fail_denominator_value";
            break;
          }
          label399:
          paramString = "report_req_other_fail_denominator_value";
        }
        label405:
        if ((paramInt2 == -4) || (paramInt2 == -3) || (paramInt2 == -288)) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          paramInt1 = i;
          if (paramInt2 != 0) {
            break;
          }
          paramInt1 = 1;
          break;
        }
      }
      if ("HLPushEvent".equals(paramString))
      {
        paramInt1 = 10;
        paramString = "report_push_denominator_value";
        paramInt2 = k;
        break label104;
      }
      if ("B_DLSDK_Result".equals(paramString))
      {
        paramInt1 = 1;
        paramString = "report_mass_download_denominator_value";
        paramInt2 = k;
        break label104;
      }
      if ("HLDownTiny".equals(paramString))
      {
        paramInt1 = 10;
        paramString = "report_ease_download_denominator_value";
        paramInt2 = k;
        break label104;
      }
      if ("HLHeartBeat".equals(paramString))
      {
        if (paramInt2 == 0)
        {
          paramString = "report_heartbeat_succ_denominator_value";
          label521:
          if (paramInt2 != 0) {
            break label540;
          }
        }
        label540:
        for (paramInt1 = 10;; paramInt1 = 5)
        {
          paramInt2 = k;
          break;
          paramString = "report_heartbeat_fail_denominator_value";
          break label521;
        }
      }
      if ("HLReportEvent".equals(paramString))
      {
        if (paramInt2 == 0) {}
        for (paramString = "platform_report_quality_succ_denominator_value";; paramString = "platform_report_quality_fail_denominator_value")
        {
          paramInt1 = 1;
          paramInt2 = k;
          break;
        }
      }
      if (("HLMsgClickEvent".equals(paramString)) || ("HLMsgProcessEvent".equals(paramString)) || ("HLMsgDispatchEvent".equals(paramString)))
      {
        if (paramInt2 == 0) {}
        for (paramString = "report_msg_push_succ_denominator_value";; paramString = "report_msg_push_fail_denominator_value")
        {
          paramInt1 = 1;
          paramInt2 = k;
          break;
        }
      }
      paramInt1 = 0;
      paramString = "";
      paramInt2 = 0;
      break label104;
      label633:
      if (paramInt2 == -1) {
        paramInt1 = 0;
      } else {
        paramInt1 = a(paramString, 0, 2147483647, paramInt1);
      }
    }
    label655:
    AppMethodBeat.o(147228);
    return paramInt2;
  }
  
  public static Handler a(String paramString, int paramInt)
  {
    AppMethodBeat.i(147226);
    paramString = new HandlerThread("halley_" + ac.c() + "_" + paramString, 10);
    paramString.start();
    paramString = new Handler(paramString.getLooper());
    AppMethodBeat.o(147226);
    return paramString;
  }
  
  public static String a()
  {
    return a;
  }
  
  public static void a(String paramString)
  {
    a = paramString;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(147229);
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (paramInt <= 2147483647)
      {
        bool1 = bool2;
        if (new Random().nextInt(paramInt) == 0) {
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(147229);
    return bool1;
  }
  
  public static boolean a(String paramString, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(147227);
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    try
    {
      bp.d().a(paramString, paramBoolean1, paramMap, false, true);
      label54:
      AppMethodBeat.o(147227);
      return true;
    }
    catch (Throwable paramString)
    {
      break label54;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(147231);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(147231);
      return paramArrayOfByte;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    paramArrayOfByte = new byte[256];
    while (!localDeflater.finished()) {
      localByteArrayOutputStream.write(paramArrayOfByte, 0, localDeflater.deflate(paramArrayOfByte));
    }
    localDeflater.finish();
    localDeflater.end();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(147231);
    return paramArrayOfByte;
  }
  
  private static String b(String paramString, int paramInt)
  {
    AppMethodBeat.i(147225);
    String str1 = cb.a().a(an.b());
    String str2 = da.a(an.g());
    paramString = cw.d().e().a(paramString, paramInt, ac.f(), ac.a, str1, str2);
    AppMethodBeat.o(147225);
    return paramString;
  }
  
  private static int c(String paramString, int paramInt)
  {
    AppMethodBeat.i(147230);
    if (paramString.equals("HLDisconnEvent"))
    {
      AppMethodBeat.o(147230);
      return -2;
    }
    int i;
    if (paramInt != 0)
    {
      if ((paramInt == -4) || (paramInt == -3) || (paramInt == -288))
      {
        i = 1;
        if (i == 0) {
          break label111;
        }
      }
    }
    else
    {
      paramString = "self_report_succ_denominator_value";
      label57:
      if (paramInt != 0)
      {
        if ((paramInt != -4) && (paramInt != -3) && (paramInt != -288)) {
          break label118;
        }
        paramInt = 1;
        label82:
        if (paramInt == 0) {
          break label123;
        }
      }
    }
    label111:
    label118:
    label123:
    for (paramInt = 100;; paramInt = 2)
    {
      paramInt = a(paramString, 0, 2147483647, paramInt);
      AppMethodBeat.o(147230);
      return paramInt;
      i = 0;
      break;
      paramString = "self_report_fail_denominator_value";
      break label57;
      paramInt = 0;
      break label82;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(147223);
    if (paramInt != 0)
    {
      af.b();
      af.c();
      af.a = paramString;
    }
    AppMethodBeat.o(147223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.an.a
 * JD-Core Version:    0.7.0.1
 */