package com.tencent.mm.plugin.qqmail.b;

import android.util.SparseArray;
import com.tencent.mm.a.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class v
{
  private static SparseArray<String> ner = null;
  private Map<String, String> ndM = new HashMap();
  public p nem;
  public i nen;
  private k neo;
  private Map<Long, v.d> nep = new HashMap();
  private Map<Long, v.b> neq = new HashMap();
  
  public v(int paramInt, String paramString)
  {
    af.setHost("qqmail.weixin.qq.com:443");
    af.setUserAgent("weixin/" + paramString + "/0x" + Integer.toHexString(paramInt));
    reset();
  }
  
  private static String aA(int paramInt, String paramString)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt == 0)
    {
      return paramString;
      paramInt = b.j.plugin_qqmail_svr_error_desc_1;
      continue;
      paramInt = b.j.plugin_qqmail_svr_error_desc_3;
      continue;
      paramInt = b.j.plugin_qqmail_svr_error_desc_7;
      continue;
      paramInt = b.j.plugin_qqmail_svr_error_desc_104;
      continue;
      paramInt = b.j.plugin_qqmail_svr_error_desc_6;
      continue;
      paramInt = b.j.plugin_qqmail_svr_error_desc_102;
      continue;
      paramInt = b.j.plugin_qqmail_svr_error_desc_103;
    }
    return a.ac(ae.getContext(), paramInt);
  }
  
  static String btA()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    g.DQ();
    return g.DP().dKt + "mailapp/";
  }
  
  public static String btz()
  {
    return "https://qqmail.weixin.qq.com:443";
  }
  
  public static String getDownloadPath()
  {
    String str = com.tencent.mm.compatible.util.e.dzB;
    com.tencent.mm.vfs.e.nb(str);
    return str;
  }
  
  private static String getLocalIp()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress();
      return localObject;
    }
    catch (Exception localException)
    {
      return null;
    }
    catch (SocketException localSocketException)
    {
      label60:
      break label60;
    }
  }
  
  private static String wk(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (ner == null)
    {
      ner = new SparseArray();
      localObject1 = HttpURLConnection.class.getDeclaredFields();
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        StringBuilder localStringBuilder = localObject1[i];
        int j = localStringBuilder.getModifiers();
        localObject2 = localStringBuilder.getName();
        if ((localObject2 != null) && (((String)localObject2).startsWith("HTTP_")) && (Modifier.isPublic(j)) && (Modifier.isFinal(j)) && (Modifier.isStatic(j))) {}
        try
        {
          int m = localStringBuilder.getInt(Integer.valueOf(0));
          localStringBuilder = new StringBuilder();
          localObject2 = ((String)localObject2).split("_");
          if (localObject2 != null)
          {
            j = 1;
            while (j < localObject2.length)
            {
              localStringBuilder.append(localObject2[j]).append(' ');
              j += 1;
            }
            localStringBuilder.append("error");
          }
          ner.put(m, localStringBuilder.toString().toLowerCase());
        }
        catch (Exception localException)
        {
          label182:
          break label182;
        }
        i += 1;
      }
    }
    else
    {
      localObject2 = (String)ner.get(paramInt);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = aA(paramInt, "request error");
      }
      return localObject1;
    }
  }
  
  public final long a(String paramString, int paramInt, Map<String, String> paramMap, n.d paramd, v.c paramc, v.a parama)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("appname", "qqmail_weixin");
    ((Map)localObject).put("f", "xml");
    ((Map)localObject).put("charset", "utf-8");
    ((Map)localObject).put("clientip", getLocalIp());
    paramString = new v.d(this, paramString, new n.b(paramInt, (Map)localObject, getCookie(), paramd), parama);
    paramString.neB = paramc;
    ai.d(new v.1(this, paramString));
    return paramString.id;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, v.c paramc, v.a parama)
  {
    return a(paramString, 1, paramMap, null, paramc, parama);
  }
  
  public final long b(String paramString, Map<String, String> paramMap, v.c paramc, v.a parama)
  {
    return a(paramString, 0, paramMap, null, paramc, parama);
  }
  
  public final void cancel(long paramLong)
  {
    v.b localb = (v.b)this.neq.get(Long.valueOf(paramLong));
    if (localb != null)
    {
      localb.onCancelled();
      localb.cancel(true);
    }
    this.neq.remove(Long.valueOf(paramLong));
    this.nep.remove(Long.valueOf(paramLong));
  }
  
  public final Map<String, String> getCookie()
  {
    String str2 = (String)g.DP().Dz().get(-1535680990, null);
    Map localMap = this.ndM;
    if (str2 == null) {}
    for (String str1 = "";; str1 = str2)
    {
      localMap.put("skey", str1);
      int i = bk.e(g.DP().Dz().get(9, null), 0);
      this.ndM.put("uin", "o" + new o(i));
      y.d("MicroMsg.NormalMailAppService", "sKey:%b, uin:%d", new Object[] { Boolean.valueOf(bk.bl(str2)), Integer.valueOf(i) });
      return this.ndM;
    }
  }
  
  public final void reset()
  {
    af.Lg(getDownloadPath());
    Object localObject = this.neq.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((v.b)((Iterator)localObject).next()).cancel(true);
    }
    this.neq.clear();
    this.nep.clear();
    this.ndM.clear();
    localObject = btA();
    this.nem = new p((String)localObject + "addr/");
    this.nen = new i((String)localObject + "draft/");
    this.neo = new k((String)localObject + "http/", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v
 * JD-Core Version:    0.7.0.1
 */