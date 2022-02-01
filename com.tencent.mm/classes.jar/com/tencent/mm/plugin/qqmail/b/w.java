package com.tencent.mm.plugin.qqmail.b;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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

public final class w
{
  private static SparseArray<String> vUQ = null;
  public q vUL;
  public i vUM;
  private k vUN;
  private Map<Long, d> vUO;
  private Map<Long, b> vUP;
  private Map<String, String> vUm;
  
  public w(int paramInt, String paramString)
  {
    AppMethodBeat.i(122738);
    this.vUm = new HashMap();
    this.vUO = new HashMap();
    this.vUP = new HashMap();
    ag.setHost("qqmail.weixin.qq.com:443");
    ag.setUserAgent("weixin/" + paramString + "/0x" + Integer.toHexString(paramInt));
    reset();
    AppMethodBeat.o(122738);
  }
  
  private static String LJ(int paramInt)
  {
    AppMethodBeat.i(122752);
    Object localObject1;
    if (vUQ == null)
    {
      vUQ = new SparseArray();
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
          vUQ.put(m, localStringBuilder.toString().toLowerCase());
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
      localObject1 = (String)vUQ.get(paramInt);
      if (localObject1 == null)
      {
        localObject1 = by(paramInt, "request error");
        AppMethodBeat.o(122752);
        return localObject1;
      }
      AppMethodBeat.o(122752);
      return localObject1;
    }
  }
  
  private long a(final String paramString, int paramInt, Map<String, String> paramMap, n.d paramd, c paramc, a parama)
  {
    AppMethodBeat.i(122744);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("appname", "qqmail_weixin");
    ((Map)localObject).put("f", "xml");
    ((Map)localObject).put("charset", "utf-8");
    ((Map)localObject).put("clientip", getLocalIp());
    paramString = new d(paramString, new n.b(paramInt, (Map)localObject, getCookie(), paramd), parama);
    paramString.vUZ = paramc;
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122726);
        w.b localb = new w.b(w.this, (byte)0);
        w.a(w.this).put(Long.valueOf(paramString.id), paramString);
        w.b(w.this).put(Long.valueOf(paramString.id), localb);
        localb.b(paramString);
        AppMethodBeat.o(122726);
      }
    });
    long l = paramString.id;
    AppMethodBeat.o(122744);
    return l;
  }
  
  private static String by(int paramInt, String paramString)
  {
    AppMethodBeat.i(122753);
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    while (paramInt == 0)
    {
      AppMethodBeat.o(122753);
      return paramString;
      paramInt = 2131761981;
      continue;
      paramInt = 2131761986;
      continue;
      paramInt = 2131761988;
      continue;
      paramInt = 2131761985;
      continue;
      paramInt = 2131761987;
      continue;
      paramInt = 2131761983;
      continue;
      paramInt = 2131761984;
    }
    paramString = a.aw(ai.getContext(), paramInt);
    AppMethodBeat.o(122753);
    return paramString;
  }
  
  private void cancel()
  {
    AppMethodBeat.i(122745);
    Iterator localIterator = this.vUP.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cancel(true);
    }
    this.vUP.clear();
    this.vUO.clear();
    AppMethodBeat.o(122745);
  }
  
  public static String drK()
  {
    return "https://qqmail.weixin.qq.com:443";
  }
  
  public static String getDownloadPath()
  {
    AppMethodBeat.i(122749);
    String str = b.apj();
    com.tencent.mm.vfs.i.aSh(str);
    AppMethodBeat.o(122749);
    return str;
  }
  
  private static String getLocalIp()
  {
    AppMethodBeat.i(122750);
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
      AppMethodBeat.o(122750);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(122750);
      return null;
    }
    catch (SocketException localSocketException)
    {
      label72:
      break label72;
    }
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, c paramc, a parama)
  {
    AppMethodBeat.i(122743);
    long l = a(paramString1, 1, null, new n.d(paramString2, paramString3), paramc, parama);
    AppMethodBeat.o(122743);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, a parama)
  {
    AppMethodBeat.i(122739);
    long l = a(paramString, paramMap, new c(), parama);
    AppMethodBeat.o(122739);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, c paramc, a parama)
  {
    AppMethodBeat.i(122740);
    long l = a(paramString, 1, paramMap, null, paramc, parama);
    AppMethodBeat.o(122740);
    return l;
  }
  
  public final long b(String paramString, Map<String, String> paramMap, a parama)
  {
    AppMethodBeat.i(122741);
    long l = b(paramString, paramMap, new c(), parama);
    AppMethodBeat.o(122741);
    return l;
  }
  
  public final long b(String paramString, Map<String, String> paramMap, c paramc, a parama)
  {
    AppMethodBeat.i(122742);
    long l = a(paramString, 0, paramMap, null, paramc, parama);
    AppMethodBeat.o(122742);
    return l;
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(122746);
    b localb = (b)this.vUP.get(Long.valueOf(paramLong));
    if (localb != null)
    {
      localb.onCancelled();
      localb.cancel(true);
    }
    this.vUP.remove(Long.valueOf(paramLong));
    this.vUO.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(122746);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(122748);
    com.tencent.mm.vfs.i.cU("wcf://mailapp/", true);
    reset();
    AppMethodBeat.o(122748);
  }
  
  public final Map<String, String> getCookie()
  {
    AppMethodBeat.i(122751);
    String str = (String)g.agR().agA().get(-1535680990, null);
    Map localMap = this.vUm;
    if (str == null) {}
    for (Object localObject = "";; localObject = str)
    {
      localMap.put("skey", localObject);
      int i = bs.l(g.agR().agA().get(9, null), 0);
      this.vUm.put("uin", "o" + new p(i));
      ac.d("MicroMsg.NormalMailAppService", "sKey:%b, uin:%d", new Object[] { Boolean.valueOf(bs.isNullOrNil(str)), Integer.valueOf(i) });
      localObject = this.vUm;
      AppMethodBeat.o(122751);
      return localObject;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(122747);
    ag.apS(getDownloadPath());
    cancel();
    this.vUm.clear();
    this.vUL = new q("wcf://mailapp/" + "addr/");
    this.vUM = new i("wcf://mailapp/" + "draft/");
    this.vUN = new k("wcf://mailapp/" + "http/", 0);
    AppMethodBeat.o(122747);
  }
  
  public static abstract class a
  {
    public void onComplete() {}
    
    public abstract void onError(int paramInt, String paramString);
    
    public void onProgress(int paramInt) {}
    
    public boolean onReady()
    {
      return true;
    }
    
    public abstract void onSuccess(String paramString, Map<String, String> paramMap);
  }
  
  final class b
    extends AsyncTask<w.d, Integer, w.d>
    implements n.a
  {
    private n vUT;
    w.d vUU;
    
    private b() {}
    
    public final boolean b(w.d paramd)
    {
      AppMethodBeat.i(122729);
      if (!paramd.vVd.onReady())
      {
        AppMethodBeat.o(122729);
        return false;
      }
      this.vUU = paramd;
      super.execute(new w.d[] { paramd });
      AppMethodBeat.o(122729);
      return true;
    }
    
    public final void drD()
    {
      AppMethodBeat.i(122730);
      publishProgress(new Integer[] { Integer.valueOf(0) });
      AppMethodBeat.o(122730);
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(122731);
      g.agS();
      g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(122727);
          if (w.b.a(w.b.this) != null) {
            w.b.a(w.b.this).cancel();
          }
          AppMethodBeat.o(122727);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(122728);
          String str = super.toString() + "|onCancelled";
          AppMethodBeat.o(122728);
          return str;
        }
      });
      super.onCancelled();
      AppMethodBeat.o(122731);
    }
  }
  
  public static final class c
  {
    public boolean vUW = false;
    public boolean vUX = true;
    public boolean vUY = true;
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(122736);
      this.vUW = paramBundle.getBoolean("qqmail_httpoptions_expired");
      this.vUX = paramBundle.getBoolean("qqmail_httpoptions_needcache");
      this.vUY = paramBundle.getBoolean("qqmail_httpoptions_needparse");
      AppMethodBeat.o(122736);
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(122735);
      paramBundle.putBoolean("qqmail_httpoptions_expired", this.vUW);
      paramBundle.putBoolean("qqmail_httpoptions_needcache", this.vUX);
      paramBundle.putBoolean("qqmail_httpoptions_needparse", this.vUY);
      AppMethodBeat.o(122735);
    }
  }
  
  final class d
  {
    long id;
    String uri;
    w.c vUZ;
    n.b vVa;
    n.c vVb;
    Map<String, String> vVc;
    w.a vVd;
    
    public d(String paramString, n.b paramb, w.a parama)
    {
      AppMethodBeat.i(122737);
      this.id = System.currentTimeMillis();
      this.uri = paramString;
      this.vVa = paramb;
      this.vVd = parama;
      AppMethodBeat.o(122737);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.w
 * JD-Core Version:    0.7.0.1
 */