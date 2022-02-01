package com.tencent.mm.plugin.qqmail.d;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.qqmail.c.a;
import com.tencent.mm.plugin.qqmail.c.b;
import com.tencent.mm.plugin.qqmail.c.c;
import com.tencent.mm.plugin.qqmail.c.d;
import com.tencent.mm.plugin.qqmail.c.e;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.u;
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

public class v
{
  public static final String Hml;
  public static final String Hmm;
  private static SparseArray<String> Hms;
  public m Hmn;
  public h Hmo;
  private j Hmp;
  private Map<Long, c.c> Hmq;
  private Map<Long, a> Hmr;
  Map<String, String> cookie;
  
  static
  {
    AppMethodBeat.i(250487);
    Hml = WeChatHosts.domainString(e.i.host_wx_mail_qq_com);
    Hmm = WeChatHosts.domainString(e.i.host_wx_mail_qq_com) + ":443";
    Hms = null;
    AppMethodBeat.o(250487);
  }
  
  public v()
  {
    AppMethodBeat.i(250468);
    this.cookie = new HashMap();
    this.Hmq = new HashMap();
    this.Hmr = new HashMap();
    reset();
    AppMethodBeat.o(250468);
  }
  
  private static String abN(int paramInt)
  {
    AppMethodBeat.i(122752);
    Object localObject1;
    if (Hms == null)
    {
      Hms = new SparseArray();
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
          Hms.put(m, localStringBuilder.toString().toLowerCase());
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
      localObject1 = (String)Hms.get(paramInt);
      if (localObject1 == null)
      {
        localObject1 = bP(paramInt, "request error");
        AppMethodBeat.o(122752);
        return localObject1;
      }
      AppMethodBeat.o(122752);
      return localObject1;
    }
  }
  
  public static an ap(Bundle paramBundle)
  {
    AppMethodBeat.i(250476);
    an localan = new an();
    localan.Hnp = paramBundle.getInt("mail_send_type");
    localan.Hnt = paramBundle.getString("mail_id");
    localan.BDX = paramBundle.getString("mail_subject");
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
    localan.Hnu = true;
    localObject1 = paramBundle.getParcelableArrayList("mail_from_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localan.Hnq = new al();
      localObject2 = localan.Hnq;
      com.tencent.mm.kernel.h.aHE();
      ((al)localObject2).uin = com.tencent.mm.kernel.b.getUin();
      localan.Hnq.Hne = ((Bundle)((ArrayList)localObject1).get(0)).getString("item_addr");
      localan.Hnq.nickname = ((Bundle)((ArrayList)localObject1).get(0)).getString("item_name");
      Log.i("MicroMsg.Mail.NormalMailAppService", "from addr %s", new Object[] { localan.Hnq.Hne });
    }
    localObject1 = paramBundle.getParcelableArrayList("mail_to_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bundle)((Iterator)localObject1).next();
        localObject3 = new al();
        ((al)localObject3).Hne = ((Bundle)localObject2).getString("item_addr");
        ((al)localObject3).nickname = ((Bundle)localObject2).getString("item_name");
        localan.Hnh.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "to addr %s", new Object[] { ((al)localObject3).Hne });
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
        ((al)localObject3).Hne = ((Bundle)localObject2).getString("item_addr");
        ((al)localObject3).nickname = ((Bundle)localObject2).getString("item_name");
        localan.Hni.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "cc addr %s", new Object[] { ((al)localObject3).Hne });
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
        ((al)localObject3).Hne = ((Bundle)localObject2).getString("item_addr");
        ((al)localObject3).nickname = ((Bundle)localObject2).getString("item_name");
        localan.Hnj.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "bcc addr %s", new Object[] { ((al)localObject3).Hne });
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
        ((ak)localObject3).Hnd = ((Bundle)localObject2).getString("attach_download_url");
        ((ak)localObject3).type = ((Bundle)localObject2).getString("attach_type");
        localan.Hnr.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "attach %s,%s,%s", new Object[] { ((ak)localObject3).fileid, ((ak)localObject3).name, ((ak)localObject3).Hnd });
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
        ((ak)localObject2).Hnd = ((Bundle)localObject1).getString("attach_download_url");
        ((ak)localObject2).type = ((Bundle)localObject1).getString("attach_type");
        localan.Hns.add(localObject2);
        Log.i("MicroMsg.Mail.NormalMailAppService", "big attach %s,%s,%s", new Object[] { ((ak)localObject2).fileid, ((ak)localObject2).name, ((ak)localObject2).Hnd });
      }
    }
    AppMethodBeat.o(250476);
    return localan;
  }
  
  private static String bP(int paramInt, String paramString)
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
      paramInt = e.i.plugin_qqmail_svr_error_desc_1;
      continue;
      paramInt = e.i.plugin_qqmail_svr_error_desc_3;
      continue;
      paramInt = e.i.plugin_qqmail_svr_error_desc_7;
      continue;
      paramInt = e.i.plugin_qqmail_svr_error_desc_104;
      continue;
      paramInt = e.i.plugin_qqmail_svr_error_desc_6;
      continue;
      paramInt = e.i.plugin_qqmail_svr_error_desc_102;
      continue;
      paramInt = e.i.plugin_qqmail_svr_error_desc_103;
    }
    paramString = a.ba(MMApplicationContext.getContext(), paramInt);
    AppMethodBeat.o(122753);
    return paramString;
  }
  
  private void cancel()
  {
    AppMethodBeat.i(122745);
    Iterator localIterator = this.Hmr.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cancel(true);
    }
    this.Hmr.clear();
    this.Hmq.clear();
    AppMethodBeat.o(122745);
  }
  
  public static String fss()
  {
    AppMethodBeat.i(250470);
    String str = "https://" + Hml;
    AppMethodBeat.o(250470);
    return str;
  }
  
  public static String fst()
  {
    AppMethodBeat.i(122749);
    String str = com.tencent.mm.loader.j.b.aTL() + "attach/";
    u.bBD(str);
    AppMethodBeat.o(122749);
    return str;
  }
  
  private static String fsu()
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
  
  public static String fsv()
  {
    AppMethodBeat.i(250477);
    String str = ((IPCString)com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), new IPCVoid(), com.tencent.mm.plugin.qqmail.c.c.class)).value;
    AppMethodBeat.o(250477);
    return str;
  }
  
  public final long a(final String paramString, int paramInt, Map<String, String> paramMap, c.b paramb, c.a parama)
  {
    AppMethodBeat.i(250472);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("appname", "qqmail_weixin");
    ((Map)localObject).put("f", "xml");
    ((Map)localObject).put("charset", "utf-8");
    ((Map)localObject).put("clientip", fsu());
    paramMap = new c.e(paramInt, (Map)localObject, this.cookie);
    paramString = new c.c(fss() + paramString, paramMap, parama);
    paramString.Hlg = paramb;
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
    AppMethodBeat.o(250472);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, c.a parama)
  {
    AppMethodBeat.i(250466);
    long l = a(paramString, paramMap, new c.b(), parama);
    AppMethodBeat.o(250466);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, c.b paramb, c.a parama)
  {
    AppMethodBeat.i(250467);
    long l = a(paramString, 1, paramMap, paramb, parama);
    AppMethodBeat.o(250467);
    return l;
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(122746);
    a locala = (a)this.Hmr.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.onCancelled();
      locala.cancel(true);
    }
    this.Hmr.remove(Long.valueOf(paramLong));
    this.Hmq.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(122746);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(122748);
    u.deleteDir("wcf://mailapp/");
    reset();
    AppMethodBeat.o(122748);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(122747);
    cancel();
    this.cookie.clear();
    String str = fsv();
    if (Util.isNullOrNil(str))
    {
      this.Hmn = new m("wcf://mailapp/" + "addr/mail_address/addrpage");
      this.Hmn.HlT.bvh();
    }
    for (;;)
    {
      this.Hmo = new h("wcf://mailapp/" + "draft/");
      this.Hmp = new j("wcf://mailapp/" + "http/", 0);
      AppMethodBeat.o(122747);
      return;
      this.Hmn = new m("wcf://mailapp/" + "addr/mail_address/" + str + "/addrpage");
    }
  }
  
  final class a
    extends AsyncTask<c.c, Integer, c.c>
    implements c.d
  {
    private com.tencent.mm.plugin.qqmail.c Hmv;
    c.c Hmw;
    
    private a() {}
    
    public final boolean b(c.c paramc)
    {
      AppMethodBeat.i(250010);
      if (!paramc.Hlk.onReady())
      {
        AppMethodBeat.o(250010);
        return false;
      }
      this.Hmw = paramc;
      super.execute(new c.c[] { paramc });
      AppMethodBeat.o(250010);
      return true;
    }
    
    public final void fsk()
    {
      AppMethodBeat.i(122730);
      publishProgress(new Integer[] { Integer.valueOf(0) });
      AppMethodBeat.o(122730);
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(122731);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.v
 * JD-Core Version:    0.7.0.1
 */