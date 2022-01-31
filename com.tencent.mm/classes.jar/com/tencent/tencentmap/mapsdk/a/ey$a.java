package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.Deflater;

public class ey$a
{
  private static String a;
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      String str2 = b(paramString, em.c());
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
    return hq.a(i, paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    int i = 100;
    int j = 1;
    if (paramInt1 == 2)
    {
      paramInt2 = c(paramString, paramInt2);
      return paramInt2;
    }
    if (("HLHttpDirect".equals(paramString)) && (paramMap != null) && ("event".equals((String)paramMap.get("B15")))) {
      return c(paramString, paramInt2);
    }
    int k = -1;
    if ("HLConnEvent".equals(paramString)) {
      if (paramInt2 == 0)
      {
        paramString = "report_conn_succ_denominator_value";
        label77:
        if (paramInt2 != 0) {
          break label161;
        }
        paramInt1 = 100;
        label84:
        paramInt2 = k;
      }
    }
    for (;;)
    {
      if (paramInt2 == -1)
      {
        i = a("report_all_events", -1, 1, 0);
        paramInt2 = j;
        if (i == 1) {
          break;
        }
        if (i == -1)
        {
          return 0;
          if ((paramInt2 == -4) || (paramInt2 == -3) || (paramInt2 == -288)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label155;
            }
            paramString = "report_conn_nonet_fail_denominator_value";
            break;
          }
          label155:
          paramString = "report_conn_other_fail_denominator_value";
          break label77;
          label161:
          if ((paramInt2 == -4) || (paramInt2 == -3) || (paramInt2 == -288)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label197;
            }
            paramInt1 = 100;
            break;
          }
          label197:
          paramInt1 = 1;
          break label84;
          if ("HLSecurityEvent".equals(paramString))
          {
            if (paramInt2 == 0)
            {
              paramString = "report_security_req_succ_denominator_value";
              label218:
              if (paramInt2 != 0) {
                break label237;
              }
            }
            label237:
            for (paramInt1 = i;; paramInt1 = 1)
            {
              paramInt2 = k;
              break;
              paramString = "report_security_req_fail_denominator_value";
              break label218;
            }
          }
          if ("HLDisconnEvent".equals(paramString))
          {
            paramInt1 = 2;
            paramString = "report_disconn_denominator_value";
            paramInt2 = k;
            continue;
          }
          if (("HLReqRspEvent".equals(paramString)) || ("HLHttpAgent".equals(paramString)) || ("HLHttpDirect".equals(paramString)))
          {
            if ((paramInt2 == 0) && (paramMap != null) && (ho.a(paramString, paramInt1, paramMap)))
            {
              paramMap.put("B28", "1");
              paramString = "report_req_ssl_first_denominator_value";
              paramInt1 = i;
              paramInt2 = k;
              continue;
            }
            if (paramInt2 == 0) {
              paramString = "report_req_succ_denominator_value";
            }
            for (;;)
            {
              if (paramInt2 != 0) {
                break label391;
              }
              paramInt1 = i;
              paramInt2 = k;
              break;
              if ((paramInt2 == -4) || (paramInt2 == -3) || (paramInt2 == -288)) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                if (paramInt1 == 0) {
                  break label385;
                }
                paramString = "report_req_nonet_fail_denominator_value";
                break;
              }
              label385:
              paramString = "report_req_other_fail_denominator_value";
            }
            label391:
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
            continue;
          }
          if ("B_DLSDK_Result".equals(paramString))
          {
            paramInt1 = 1;
            paramString = "report_mass_download_denominator_value";
            paramInt2 = k;
            continue;
          }
          if ("HLDownTiny".equals(paramString))
          {
            paramInt1 = 10;
            paramString = "report_ease_download_denominator_value";
            paramInt2 = k;
            continue;
          }
          if ("HLHeartBeat".equals(paramString))
          {
            if (paramInt2 == 0)
            {
              paramString = "report_heartbeat_succ_denominator_value";
              label507:
              if (paramInt2 != 0) {
                break label526;
              }
            }
            label526:
            for (paramInt1 = 10;; paramInt1 = 5)
            {
              paramInt2 = k;
              break;
              paramString = "report_heartbeat_fail_denominator_value";
              break label507;
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
          continue;
        }
        return a(paramString, 0, 2147483647, paramInt1);
      }
    }
    return paramInt2;
  }
  
  public static Handler a(String paramString, int paramInt)
  {
    paramString = new HandlerThread("halley_" + em.c() + "_" + paramString, 10);
    paramString.start();
    return new Handler(paramString.getLooper());
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
    return bool1;
  }
  
  public static boolean a(String paramString, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    try
    {
      gb.d().a(paramString, paramBoolean1, paramMap, false, true);
      return true;
    }
    catch (Throwable paramString) {}
    return true;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
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
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static String b(String paramString, int paramInt)
  {
    String str1 = gn.a().a(ey.b());
    String str2 = hn.a(ey.g());
    return hj.d().e().a(paramString, paramInt, em.f(), em.a, str1, str2);
  }
  
  private static int c(String paramString, int paramInt)
  {
    int j = 1;
    if (paramString.equals("HLDisconnEvent")) {
      return -2;
    }
    int i;
    if (paramInt != 0)
    {
      if ((paramInt == -4) || (paramInt == -3) || (paramInt == -288))
      {
        i = 1;
        if (i == 0) {
          break label97;
        }
      }
    }
    else
    {
      paramString = "self_report_succ_denominator_value";
      label47:
      if (paramInt != 0)
      {
        i = j;
        if (paramInt != -4)
        {
          i = j;
          if (paramInt != -3)
          {
            if (paramInt != -288) {
              break label104;
            }
            i = j;
          }
        }
        label76:
        if (i == 0) {
          break label109;
        }
      }
    }
    label97:
    label104:
    label109:
    for (paramInt = 100;; paramInt = 2)
    {
      return a(paramString, 0, 2147483647, paramInt);
      i = 0;
      break;
      paramString = "self_report_fail_denominator_value";
      break label47;
      i = 0;
      break label76;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt != 0)
    {
      eq.b();
      eq.c();
      eq.a = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ey.a
 * JD-Core Version:    0.7.0.1
 */