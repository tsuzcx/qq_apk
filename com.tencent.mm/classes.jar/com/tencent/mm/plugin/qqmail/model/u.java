package com.tencent.mm.plugin.qqmail.model;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.h;
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
import com.tencent.mm.vfs.y;
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

public class u
{
  public static final String NjZ;
  public static final String Nka;
  private static SparseArray<String> Nkg;
  public l Nkb;
  public g Nkc;
  private i Nkd;
  private Map<Long, c.c> Nke;
  private Map<Long, a> Nkf;
  Map<String, String> cookie;
  
  static
  {
    AppMethodBeat.i(267098);
    NjZ = WeChatHosts.domainString(e.i.host_wx_mail_qq_com);
    Nka = WeChatHosts.domainString(e.i.host_wx_mail_qq_com) + ":443";
    Nkg = null;
    AppMethodBeat.o(267098);
  }
  
  public u()
  {
    AppMethodBeat.i(267070);
    this.cookie = new HashMap();
    this.Nke = new HashMap();
    this.Nkf = new HashMap();
    reset();
    AppMethodBeat.o(267070);
  }
  
  public static am aN(Bundle paramBundle)
  {
    AppMethodBeat.i(267087);
    am localam = new am();
    localam.Nld = paramBundle.getInt("mail_send_type");
    localam.Nlh = paramBundle.getString("mail_id");
    localam.Hox = paramBundle.getString("mail_subject");
    localam.content = paramBundle.getString("mail_content");
    Log.i("MicroMsg.Mail.NormalMailAppService", "parseSendMailContent before content:%s", new Object[] { localam.content });
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
        localam.content = localam.content.replaceAll(String.format("src=\"%s\"", new Object[] { "file://".concat(String.valueOf(localObject4)) }), String.format("src=\"/attach/preview?bizid=50&fileid=%s&name=%s\"", new Object[] { localObject2, localObject3 }));
      }
    }
    Log.i("MicroMsg.Mail.NormalMailAppService", "parseSendMailContent after content:%s", new Object[] { localam.content });
    localam.Nli = true;
    localObject1 = paramBundle.getParcelableArrayList("mail_from_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localam.Nle = new ak();
      localObject2 = localam.Nle;
      h.baC();
      ((ak)localObject2).uin = com.tencent.mm.kernel.b.getUin();
      localam.Nle.NkS = ((Bundle)((ArrayList)localObject1).get(0)).getString("item_addr");
      localam.Nle.nickname = ((Bundle)((ArrayList)localObject1).get(0)).getString("item_name");
      Log.i("MicroMsg.Mail.NormalMailAppService", "from addr %s", new Object[] { localam.Nle.NkS });
    }
    localObject1 = paramBundle.getParcelableArrayList("mail_to_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bundle)((Iterator)localObject1).next();
        localObject3 = new ak();
        ((ak)localObject3).NkS = ((Bundle)localObject2).getString("item_addr");
        ((ak)localObject3).nickname = ((Bundle)localObject2).getString("item_name");
        localam.NkV.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "to addr %s", new Object[] { ((ak)localObject3).NkS });
      }
    }
    localObject1 = paramBundle.getParcelableArrayList("mail_cc_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bundle)((Iterator)localObject1).next();
        localObject3 = new ak();
        ((ak)localObject3).NkS = ((Bundle)localObject2).getString("item_addr");
        ((ak)localObject3).nickname = ((Bundle)localObject2).getString("item_name");
        localam.NkW.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "cc addr %s", new Object[] { ((ak)localObject3).NkS });
      }
    }
    localObject1 = paramBundle.getParcelableArrayList("mail_bcc_list");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bundle)((Iterator)localObject1).next();
        localObject3 = new ak();
        ((ak)localObject3).NkS = ((Bundle)localObject2).getString("item_addr");
        ((ak)localObject3).nickname = ((Bundle)localObject2).getString("item_name");
        localam.NkX.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "bcc addr %s", new Object[] { ((ak)localObject3).NkS });
      }
    }
    localObject1 = paramBundle.getParcelableArrayList("mail_normal_attach");
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bundle)((Iterator)localObject1).next();
        localObject3 = new aj();
        ((aj)localObject3).fileid = ((Bundle)localObject2).getString("attach_fileId");
        ((aj)localObject3).key = ((Bundle)localObject2).getString("attach_key");
        ((aj)localObject3).name = ((Bundle)localObject2).getString("attach_name");
        ((aj)localObject3).size = ((Bundle)localObject2).getInt("attach_size");
        ((aj)localObject3).NkR = ((Bundle)localObject2).getString("attach_download_url");
        ((aj)localObject3).type = ((Bundle)localObject2).getString("attach_type");
        localam.Nlf.add(localObject3);
        Log.i("MicroMsg.Mail.NormalMailAppService", "attach %s,%s,%s", new Object[] { ((aj)localObject3).fileid, ((aj)localObject3).name, ((aj)localObject3).NkR });
      }
    }
    paramBundle = paramBundle.getParcelableArrayList("mail_big_attach");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject1 = (Bundle)paramBundle.next();
        localObject2 = new aj();
        ((aj)localObject2).fileid = ((Bundle)localObject1).getString("attach_fileId");
        ((aj)localObject2).key = ((Bundle)localObject1).getString("attach_key");
        ((aj)localObject2).name = ((Bundle)localObject1).getString("attach_name");
        ((aj)localObject2).size = ((Bundle)localObject1).getInt("attach_size");
        ((aj)localObject2).NkR = ((Bundle)localObject1).getString("attach_download_url");
        ((aj)localObject2).type = ((Bundle)localObject1).getString("attach_type");
        localam.Nlg.add(localObject2);
        Log.i("MicroMsg.Mail.NormalMailAppService", "big attach %s,%s,%s", new Object[] { ((aj)localObject2).fileid, ((aj)localObject2).name, ((aj)localObject2).NkR });
      }
    }
    AppMethodBeat.o(267087);
    return localam;
  }
  
  private static String agb(int paramInt)
  {
    AppMethodBeat.i(122752);
    Object localObject1;
    if (Nkg == null)
    {
      Nkg = new SparseArray();
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
          Nkg.put(m, localStringBuilder.toString().toLowerCase());
        }
        catch (Exception localException)
        {
          label188:
          break label188;
        }
        i += 1;
      }
    }
    else
    {
      localObject1 = (String)Nkg.get(paramInt);
      if (localObject1 == null)
      {
        localObject1 = cx(paramInt, "request error");
        AppMethodBeat.o(122752);
        return localObject1;
      }
      AppMethodBeat.o(122752);
      return localObject1;
    }
  }
  
  private void cancel()
  {
    AppMethodBeat.i(122745);
    Iterator localIterator = this.Nkf.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cancel(true);
    }
    this.Nkf.clear();
    this.Nke.clear();
    AppMethodBeat.o(122745);
  }
  
  private static String cx(int paramInt, String paramString)
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
    paramString = a.bt(MMApplicationContext.getContext(), paramInt);
    AppMethodBeat.o(122753);
    return paramString;
  }
  
  public static String gEa()
  {
    AppMethodBeat.i(267072);
    String str = "https://" + NjZ;
    AppMethodBeat.o(267072);
    return str;
  }
  
  public static String gEb()
  {
    AppMethodBeat.i(122749);
    String str = com.tencent.mm.loader.i.b.bnz() + "attach/";
    y.bDX(str);
    AppMethodBeat.o(122749);
    return str;
  }
  
  private static String gEc()
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
  
  public static String gEd()
  {
    AppMethodBeat.i(267093);
    String str = ((IPCString)j.a(MMApplicationContext.getPackageName(), new IPCVoid(), com.tencent.mm.plugin.qqmail.c.c.class)).value;
    AppMethodBeat.o(267093);
    return str;
  }
  
  public final long a(final String paramString, int paramInt, Map<String, String> paramMap, c.b paramb, c.a parama)
  {
    AppMethodBeat.i(267101);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("appname", "qqmail_weixin");
    ((Map)localObject).put("f", "xml");
    ((Map)localObject).put("charset", "utf-8");
    ((Map)localObject).put("clientip", gEc());
    paramMap = new c.e(paramInt, (Map)localObject, this.cookie);
    paramString = new c.c(gEa() + paramString, paramMap, parama);
    paramString.NiT = paramb;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122726);
        u.a locala = new u.a(u.this, (byte)0);
        u.a(u.this).put(Long.valueOf(paramString.id), paramString);
        u.b(u.this).put(Long.valueOf(paramString.id), locala);
        locala.b(paramString);
        AppMethodBeat.o(122726);
      }
    });
    long l = paramString.id;
    AppMethodBeat.o(267101);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, c.a parama)
  {
    AppMethodBeat.i(267099);
    long l = a(paramString, paramMap, new c.b(), parama);
    AppMethodBeat.o(267099);
    return l;
  }
  
  public final long a(String paramString, Map<String, String> paramMap, c.b paramb, c.a parama)
  {
    AppMethodBeat.i(267100);
    long l = a(paramString, 1, paramMap, paramb, parama);
    AppMethodBeat.o(267100);
    return l;
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(122746);
    a locala = (a)this.Nkf.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.onCancelled();
      locala.cancel(true);
    }
    this.Nkf.remove(Long.valueOf(paramLong));
    this.Nke.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(122746);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(122748);
    y.ew("wcf://mailapp/", true);
    reset();
    AppMethodBeat.o(122748);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(122747);
    cancel();
    this.cookie.clear();
    String str = gEd();
    if (Util.isNullOrNil(str))
    {
      this.Nkb = new l("wcf://mailapp/" + "addr/mail_address/addrpage");
      this.Nkb.NjH.bTu();
    }
    for (;;)
    {
      this.Nkc = new g("wcf://mailapp/" + "draft/");
      this.Nkd = new i("wcf://mailapp/" + "http/", 0);
      AppMethodBeat.o(122747);
      return;
      this.Nkb = new l("wcf://mailapp/" + "addr/mail_address/" + str + "/addrpage");
    }
  }
  
  final class a
    extends AsyncTask<c.c, Integer, c.c>
    implements c.d
  {
    private com.tencent.mm.plugin.qqmail.c Nkj;
    c.c Nkk;
    
    private a() {}
    
    public final boolean b(c.c paramc)
    {
      AppMethodBeat.i(267031);
      if (!paramc.NiX.onReady())
      {
        AppMethodBeat.o(267031);
        return false;
      }
      this.Nkk = paramc;
      super.execute(new c.c[] { paramc });
      AppMethodBeat.o(267031);
      return true;
    }
    
    public final void gDS()
    {
      AppMethodBeat.i(122730);
      publishProgress(new Integer[] { Integer.valueOf(0) });
      AppMethodBeat.o(122730);
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(122731);
      h.baF();
      h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(122727);
          if (u.a.a(u.a.this) != null) {
            u.a.a(u.a.this).cancel();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.u
 * JD-Core Version:    0.7.0.1
 */