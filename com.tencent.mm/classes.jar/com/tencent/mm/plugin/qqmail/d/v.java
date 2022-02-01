package com.tencent.mm.plugin.qqmail.d;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.qqmail.c.a;
import com.tencent.mm.plugin.qqmail.c.b;
import com.tencent.mm.plugin.qqmail.c.c;
import com.tencent.mm.plugin.qqmail.c.d;
import com.tencent.mm.plugin.qqmail.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.s;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class v
{
  public static final String BrS;
  public static final String BrT;
  private static SparseArray<String> BrZ;
  public m BrU;
  public h BrV;
  private j BrW;
  private Map<Long, c.c> BrX;
  private Map<Long, a> BrY;
  Map<String, String> cookie;
  
  static
  {
    AppMethodBeat.i(198622);
    BrS = WeChatHosts.domainString(2131761755);
    BrT = WeChatHosts.domainString(2131761755) + ":443";
    BrZ = null;
    AppMethodBeat.o(198622);
  }
  
  public v()
  {
    AppMethodBeat.i(198615);
    this.cookie = new HashMap();
    this.BrX = new HashMap();
    this.BrY = new HashMap();
    reset();
    AppMethodBeat.o(198615);
  }
  
  private static String Vf(int paramInt)
  {
    AppMethodBeat.i(122752);
    Object localObject1;
    if (BrZ == null)
    {
      BrZ = new SparseArray();
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
          BrZ.put(m, localStringBuilder.toString().toLowerCase());
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
      localObject1 = (String)BrZ.get(paramInt);
      if (localObject1 == null)
      {
        localObject1 = bR(paramInt, "request error");
        AppMethodBeat.o(122752);
        return localObject1;
      }
      AppMethodBeat.o(122752);
      return localObject1;
    }
  }
  
  public static an at(Bundle paramBundle)
  {
    AppMethodBeat.i(198618);
    an localan = new an();
    localan.BsV = paramBundle.getInt("mail_send_type");
    localan.BsZ = paramBundle.getString("mail_id");
    localan.Bru = paramBundle.getString("mail_subject");
    localan.content = paramBundle.getString("mail_content");
    Log.i("MicroMsg.Mail.NormalMailAppService", "parseSendMailContent before content:%s", new Object[] { localan.content });
    Object localObject1 = paramBundle.getParcelableArrayList("mail_image_attach");
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject4 = (Bundle)((Iterator)localObject1).next();
        localObject2 = ((Bundle)localObject4).getString("attach_fileId", "");
        localObject3 = ((Bundle)localObject4).getString("attach_name", "");
        localObject4 = ((Bundle)localObject4).getString("attach_path", "");
        localan.content = localan.content.replaceAll(String.format("src=\"%s\"", new Object[] { "file://".concat(String.valueOf(localObject4)) }), String.format("src=\"/attach/preview?bizid=50&fileid=%s&name=%s\"", new Object[] { localObject2, localObject3 }));
      }
    }
    Log.i("MicroMsg.Mail.NormalMailAppService", "parseSendMailContent after content:%s", new Object[] { localan.content });
    localan.Bta = true;
    localObject1 = paramBundle.getParcelableArrayList("mail_from_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localan.BsW = new al();
      localObject2 = localan.BsW;
      g.aAf();
      ((al)localObject2).uin = com.tencent.mm.kernel.a.getUin();
      localan.BsW.BsK = ((Bundle)((ArrayList)localObject1).get(0)).getString("item_addr");
      localan.BsW.nickname = ((Bundle)((ArrayList)localObject1).get(0)).getString("item_name");
      Log.i("MicroMsg.Mail.NormalMailAppService", "from addr %s", new Object[] { localan.BsW.BsK });
    }
    localObject1 = paramBundle.getParcelableArrayList("mail_to_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bundle)((Iterator)localObject1).next();
        localObject3 = new al();
        ((al)localObject3).BsK = ((Bundle)localObject2).getString("item_addr");
        ((al)localObject3).nickname = ((Bundle)localObject2).getString("item_name");
        localan.BsN.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "to addr %s", new Object[] { ((al)localObject3).BsK });
      }
    }
    localObject1 = paramBundle.getParcelableArrayList("mail_cc_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bundle)((Iterator)localObject1).next();
        localObject3 = new al();
        ((al)localObject3).BsK = ((Bundle)localObject2).getString("item_addr");
        ((al)localObject3).nickname = ((Bundle)localObject2).getString("item_name");
        localan.BsO.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "cc addr %s", new Object[] { ((al)localObject3).BsK });
      }
    }
    localObject1 = paramBundle.getParcelableArrayList("mail_bcc_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bundle)((Iterator)localObject1).next();
        localObject3 = new al();
        ((al)localObject3).BsK = ((Bundle)localObject2).getString("item_addr");
        ((al)localObject3).nickname = ((Bundle)localObject2).getString("item_name");
        localan.BsP.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "bcc addr %s", new Object[] { ((al)localObject3).BsK });
      }
    }
    localObject1 = paramBundle.getParcelableArrayList("mail_normal_attach");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bundle)((Iterator)localObject1).next();
        localObject3 = new ak();
        ((ak)localObject3).fileid = ((Bundle)localObject2).getString("attach_fileId");
        ((ak)localObject3).key = ((Bundle)localObject2).getString("attach_key");
        ((ak)localObject3).name = ((Bundle)localObject2).getString("attach_name");
        ((ak)localObject3).size = ((Bundle)localObject2).getInt("attach_size");
        ((ak)localObject3).BsJ = ((Bundle)localObject2).getString("attach_download_url");
        ((ak)localObject3).type = ((Bundle)localObject2).getString("attach_type");
        localan.BsX.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "attach %s,%s,%s", new Object[] { ((ak)localObject3).fileid, ((ak)localObject3).name, ((ak)localObject3).BsJ });
      }
    }
    paramBundle = paramBundle.getParcelableArrayList("mail_big_attach");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject1 = (Bundle)paramBundle.next();
        localObject2 = new ak();
        ((ak)localObject2).fileid = ((Bundle)localObject1).getString("attach_fileId");
        ((ak)localObject2).key = ((Bundle)localObject1).getString("attach_key");
        ((ak)localObject2).name = ((Bundle)localObject1).getString("attach_name");
        ((ak)localObject2).size = ((Bundle)localObject1).getInt("attach_size");
        ((ak)localObject2).BsJ = ((Bundle)localObject1).getString("attach_download_url");
        ((ak)localObject2).type = ((Bundle)localObject1).getString("attach_type");
        localan.BsY.add(localObject2);
        Log.i("MicroMsg.Mail.NormalMailAppService", "big attach %s,%s,%s", new Object[] { ((ak)localObject2).fileid, ((ak)localObject2).name, ((ak)localObject2).BsJ });
      }
    }
    AppMethodBeat.o(198618);
    return localan;
  }
  
  private static String bR(int paramInt, String paramString)
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
      paramInt = 2131763988;
      continue;
      paramInt = 2131763993;
      continue;
      paramInt = 2131763995;
      continue;
      paramInt = 2131763992;
      continue;
      paramInt = 2131763994;
      continue;
      paramInt = 2131763990;
      continue;
      paramInt = 2131763991;
    }
    paramString = com.tencent.mm.cb.a.aI(MMApplicationContext.getContext(), paramInt);
    AppMethodBeat.o(122753);
    return paramString;
  }
  
  private void cancel()
  {
    AppMethodBeat.i(122745);
    Iterator localIterator = this.BrY.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cancel(true);
    }
    this.BrY.clear();
    this.BrX.clear();
    AppMethodBeat.o(122745);
  }
  
  public static String eGq()
  {
    AppMethodBeat.i(198616);
    String str = "https://" + BrS;
    AppMethodBeat.o(198616);
    return str;
  }
  
  public static String eGr()
  {
    AppMethodBeat.i(198619);
    String str = ((IPCString)com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), new IPCVoid(), com.tencent.mm.plugin.qqmail.c.c.class)).value;
    AppMethodBeat.o(198619);
    return str;
  }
  
  public static String getDownloadPath()
  {
    AppMethodBeat.i(122749);
    String str = b.aLG() + "attach/";
    s.boN(str);
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
  
  public final long a(final String paramString, int paramInt, Map<String, String> paramMap, c.b paramb, c.a parama)
  {
    AppMethodBeat.i(198617);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("appname", "qqmail_weixin");
    ((Map)localObject).put("f", "xml");
    ((Map)localObject).put("charset", "utf-8");
    ((Map)localObject).put("clientip", getLocalIp());
    paramMap = new c.e(paramInt, (Map)localObject, this.cookie);
    paramString = new c.c(eGq() + paramString, paramMap, parama);
    paramString.BqN = paramb;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122726);
        v.a locala = new v.a(v.this, (byte)0);
        v.a(v.this).put(Long.valueOf(paramString.id), paramString);
        v.b(v.this).put(Long.valueOf(paramString.id), locala);
        locala.b(paramString);
        AppMethodBeat.o(122726);
      }
    });
    long l = paramString.id;
    AppMethodBeat.o(198617);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, c.a parama)
  {
    AppMethodBeat.i(198613);
    long l = a(paramString, paramMap, new c.b(), parama);
    AppMethodBeat.o(198613);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, c.b paramb, c.a parama)
  {
    AppMethodBeat.i(198614);
    long l = a(paramString, 1, paramMap, paramb, parama);
    AppMethodBeat.o(198614);
    return l;
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(122746);
    a locala = (a)this.BrY.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.onCancelled();
      locala.cancel(true);
    }
    this.BrY.remove(Long.valueOf(paramLong));
    this.BrX.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(122746);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(122748);
    s.dy("wcf://mailapp/", true);
    reset();
    AppMethodBeat.o(122748);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(122747);
    cancel();
    this.cookie.clear();
    String str = eGr();
    if (Util.isNullOrNil(str))
    {
      this.BrU = new m("wcf://mailapp/" + "addr/mail_address/addrpage");
      this.BrU.BrA.blr();
    }
    for (;;)
    {
      this.BrV = new h("wcf://mailapp/" + "draft/");
      this.BrW = new j("wcf://mailapp/" + "http/", 0);
      AppMethodBeat.o(122747);
      return;
      this.BrU = new m("wcf://mailapp/" + "addr/mail_address/" + str + "/addrpage");
    }
  }
  
  final class a
    extends AsyncTask<c.c, Integer, c.c>
    implements c.d
  {
    private com.tencent.mm.plugin.qqmail.c Bsc;
    c.c Bsd;
    
    private a() {}
    
    public final boolean b(c.c paramc)
    {
      AppMethodBeat.i(198612);
      if (!paramc.BqR.onReady())
      {
        AppMethodBeat.o(198612);
        return false;
      }
      this.Bsd = paramc;
      super.execute(new c.c[] { paramc });
      AppMethodBeat.o(198612);
      return true;
    }
    
    public final void eGj()
    {
      AppMethodBeat.i(122730);
      publishProgress(new Integer[] { Integer.valueOf(0) });
      AppMethodBeat.o(122730);
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(122731);
      g.aAi();
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(122727);
          if (v.a.a(v.a.this) != null) {
            v.a.a(v.a.this).cancel();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.v
 * JD-Core Version:    0.7.0.1
 */