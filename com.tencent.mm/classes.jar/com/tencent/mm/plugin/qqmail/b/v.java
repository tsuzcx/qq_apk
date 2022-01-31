package com.tencent.mm.plugin.qqmail.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static SparseArray<String> pJH = null;
  public p pJC;
  public i pJD;
  private k pJE;
  private Map<Long, v.d> pJF;
  private Map<Long, v.b> pJG;
  private Map<String, String> pJc;
  
  public v(int paramInt, String paramString)
  {
    AppMethodBeat.i(68004);
    this.pJc = new HashMap();
    this.pJF = new HashMap();
    this.pJG = new HashMap();
    af.setHost("qqmail.weixin.qq.com:443");
    af.setUserAgent("weixin/" + paramString + "/0x" + Integer.toHexString(paramInt));
    reset();
    AppMethodBeat.o(68004);
  }
  
  private static String BV(int paramInt)
  {
    AppMethodBeat.i(68018);
    Object localObject1;
    if (pJH == null)
    {
      pJH = new SparseArray();
      localObject1 = HttpURLConnection.class.getDeclaredFields();
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        StringBuilder localStringBuilder = localObject1[i];
        int j = localStringBuilder.getModifiers();
        Object localObject2 = localStringBuilder.getName();
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
          pJH.put(m, localStringBuilder.toString().toLowerCase());
        }
        catch (Exception localException)
        {
          label183:
          break label183;
        }
        i += 1;
      }
    }
    else
    {
      localObject1 = (String)pJH.get(paramInt);
      if (localObject1 == null)
      {
        localObject1 = aX(paramInt, "request error");
        AppMethodBeat.o(68018);
        return localObject1;
      }
      AppMethodBeat.o(68018);
      return localObject1;
    }
  }
  
  private long a(String paramString, int paramInt, Map<String, String> paramMap, n.d paramd, v.c paramc, v.a parama)
  {
    AppMethodBeat.i(68010);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("appname", "qqmail_weixin");
    ((Map)localObject).put("f", "xml");
    ((Map)localObject).put("charset", "utf-8");
    ((Map)localObject).put("clientip", getLocalIp());
    paramString = new v.d(this, paramString, new n.b(paramInt, (Map)localObject, getCookie(), paramd), parama);
    paramString.pJQ = paramc;
    al.d(new v.1(this, paramString));
    long l = paramString.id;
    AppMethodBeat.o(68010);
    return l;
  }
  
  private static String aX(int paramInt, String paramString)
  {
    AppMethodBeat.i(68019);
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt == 0)
    {
      AppMethodBeat.o(68019);
      return paramString;
      paramInt = 2131302142;
      continue;
      paramInt = 2131302147;
      continue;
      paramInt = 2131302149;
      continue;
      paramInt = 2131302146;
      continue;
      paramInt = 2131302148;
      continue;
      paramInt = 2131302144;
      continue;
      paramInt = 2131302145;
    }
    paramString = a.aq(ah.getContext(), paramInt);
    AppMethodBeat.o(68019);
    return paramString;
  }
  
  private void cancel()
  {
    AppMethodBeat.i(68011);
    Iterator localIterator = this.pJG.values().iterator();
    while (localIterator.hasNext()) {
      ((v.b)localIterator.next()).cancel(true);
    }
    this.pJG.clear();
    this.pJF.clear();
    AppMethodBeat.o(68011);
  }
  
  public static String cdK()
  {
    return "https://qqmail.weixin.qq.com:443";
  }
  
  private static String cdL()
  {
    AppMethodBeat.i(68020);
    Object localObject = new StringBuilder();
    g.RM();
    localObject = g.RL().eHR + "mailapp/";
    AppMethodBeat.o(68020);
    return localObject;
  }
  
  public static String getDownloadPath()
  {
    AppMethodBeat.i(68015);
    String str = com.tencent.mm.compatible.util.e.esq;
    com.tencent.mm.vfs.e.um(str);
    AppMethodBeat.o(68015);
    return str;
  }
  
  private static String getLocalIp()
  {
    AppMethodBeat.i(68016);
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
      AppMethodBeat.o(68016);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(68016);
      return null;
    }
    catch (SocketException localSocketException)
    {
      label72:
      break label72;
    }
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, v.c paramc, v.a parama)
  {
    AppMethodBeat.i(68009);
    long l = a(paramString1, 1, null, new n.d(paramString2, paramString3), paramc, parama);
    AppMethodBeat.o(68009);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, v.a parama)
  {
    AppMethodBeat.i(68005);
    long l = a(paramString, paramMap, new v.c(), parama);
    AppMethodBeat.o(68005);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, v.c paramc, v.a parama)
  {
    AppMethodBeat.i(68006);
    long l = a(paramString, 1, paramMap, null, paramc, parama);
    AppMethodBeat.o(68006);
    return l;
  }
  
  public final long b(String paramString, Map<String, String> paramMap, v.a parama)
  {
    AppMethodBeat.i(68007);
    long l = b(paramString, paramMap, new v.c(), parama);
    AppMethodBeat.o(68007);
    return l;
  }
  
  public final long b(String paramString, Map<String, String> paramMap, v.c paramc, v.a parama)
  {
    AppMethodBeat.i(68008);
    long l = a(paramString, 0, paramMap, null, paramc, parama);
    AppMethodBeat.o(68008);
    return l;
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(68012);
    v.b localb = (v.b)this.pJG.get(Long.valueOf(paramLong));
    if (localb != null)
    {
      localb.onCancelled();
      localb.cancel(true);
    }
    this.pJG.remove(Long.valueOf(paramLong));
    this.pJF.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(68012);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(68014);
    com.tencent.mm.vfs.e.O(cdL(), true);
    reset();
    AppMethodBeat.o(68014);
  }
  
  public final Map<String, String> getCookie()
  {
    AppMethodBeat.i(68017);
    String str = (String)g.RL().Ru().get(-1535680990, null);
    Map localMap = this.pJc;
    if (str == null) {}
    for (Object localObject = "";; localObject = str)
    {
      localMap.put("skey", localObject);
      int i = bo.f(g.RL().Ru().get(9, null), 0);
      this.pJc.put("uin", "o" + new com.tencent.mm.a.p(i));
      ab.d("MicroMsg.NormalMailAppService", "sKey:%b, uin:%d", new Object[] { Boolean.valueOf(bo.isNullOrNil(str)), Integer.valueOf(i) });
      localObject = this.pJc;
      AppMethodBeat.o(68017);
      return localObject;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(68013);
    af.Xq(getDownloadPath());
    cancel();
    this.pJc.clear();
    String str = cdL();
    this.pJC = new p(str + "addr/");
    this.pJD = new i(str + "draft/");
    this.pJE = new k(str + "http/", 0);
    AppMethodBeat.o(68013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v
 * JD-Core Version:    0.7.0.1
 */