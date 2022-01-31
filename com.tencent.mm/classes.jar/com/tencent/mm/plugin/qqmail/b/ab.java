package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class ab
  implements f
{
  String czp;
  String pIO;
  String[] pJq;
  String[] pJr;
  private String[] pJs;
  ab.e pKb;
  String pKd;
  Map<String, String> pKe;
  private Map<String, String> pKf;
  private Map<String, String> pKg;
  private b pKh;
  public z pKi;
  Map<String, String> pKj;
  ab.f pKk;
  private HashMap<Long, Integer> pKl;
  private HashMap<Long, String> pKm;
  private HashMap<String, Integer> pKn;
  private int pKo;
  ArrayList<g> pKp;
  String pKq;
  String pKr;
  HashMap<String, String> pKs;
  c pKt;
  ab.d pKu;
  int pKv;
  com.tencent.mm.ai.g pKw;
  
  public ab()
  {
    AppMethodBeat.i(68045);
    this.pKe = new HashMap();
    this.pKf = new LinkedHashMap();
    this.pKg = new LinkedHashMap();
    this.pKj = new HashMap();
    this.pKk = null;
    this.pKb = null;
    this.pKl = new HashMap();
    this.pKm = new HashMap();
    this.pKn = new HashMap();
    this.pKo = 0;
    this.pKp = new ArrayList();
    this.pKq = null;
    this.pKr = null;
    this.pKs = new HashMap();
    this.pKv = 0;
    this.pKw = new ab.7(this);
    com.tencent.mm.kernel.g.RK().eHt.a(483, this);
    com.tencent.mm.kernel.g.RK().eHt.a(484, this);
    com.tencent.mm.kernel.g.RK().eHt.a(485, this);
    AppMethodBeat.o(68045);
  }
  
  private void N(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(68054);
    if (this.pKl != null)
    {
      this.pKl.clear();
      this.pKl = null;
    }
    this.pKl = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      long l = ((Long)paramArrayList.next()).longValue();
      this.pKl.put(Long.valueOf(l), Integer.valueOf(1));
    }
    AppMethodBeat.o(68054);
  }
  
  private void a(r paramr)
  {
    AppMethodBeat.i(68057);
    this.pKo += 1;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[] { Integer.valueOf(this.pKo) });
    paramr = paramr.cdI().iterator();
    while (paramr.hasNext())
    {
      g localg = (g)paramr.next();
      long l = localg.pIE;
      int i = localg.jJS;
      if (this.pKl.containsKey(Long.valueOf(l)))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        if (i == 0)
        {
          this.pKl.remove(Long.valueOf(l));
          if (localg.pIF != null)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[] { Long.valueOf(l), localg.pIF });
            this.pKm.put(Long.valueOf(l), localg.pIF);
            this.pKn.put(localg.pIF, Integer.valueOf(localg.FileSize));
          }
        }
        else
        {
          this.pKl.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
    }
    if (this.pKl.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "all image is in server");
      if (this.pKh != null) {
        this.pKh.a(new ArrayList(), this.pKm);
      }
      AppMethodBeat.o(68057);
      return;
    }
    if (this.pKo < 3)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
      paramr = new r(m(this.pKl));
      com.tencent.mm.kernel.g.RK().eHt.a(paramr, 0);
      AppMethodBeat.o(68057);
      return;
    }
    this.pKh.a(m(this.pKl), this.pKm);
    AppMethodBeat.o(68057);
  }
  
  private void a(ArrayList<Long> paramArrayList, b paramb)
  {
    AppMethodBeat.i(68055);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
    this.pKo = 0;
    N(paramArrayList);
    if (this.pKm != null)
    {
      this.pKm.clear();
      this.pKm = null;
    }
    this.pKm = new HashMap();
    this.pKh = paramb;
    paramArrayList = new r(paramArrayList);
    com.tencent.mm.kernel.g.RK().eHt.a(paramArrayList, 0);
    AppMethodBeat.o(68055);
  }
  
  private static ArrayList<Long> m(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(68056);
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.keySet().iterator();
    while (paramHashMap.hasNext()) {
      localArrayList.add((Long)paramHashMap.next());
    }
    AppMethodBeat.o(68056);
    return localArrayList;
  }
  
  public final void BX(int paramInt)
  {
    AppMethodBeat.i(68049);
    if (this.pKk != null) {
      al.d(new ab.1(this, paramInt));
    }
    AppMethodBeat.o(68049);
  }
  
  public final void X(Map<String, String> paramMap)
  {
    AppMethodBeat.i(68046);
    this.pKe = new HashMap();
    this.pKe.putAll(paramMap);
    AppMethodBeat.o(68046);
  }
  
  public final void Y(Map<String, String> paramMap)
  {
    AppMethodBeat.i(68047);
    this.pKf = new LinkedHashMap();
    this.pKf.putAll(paramMap);
    AppMethodBeat.o(68047);
  }
  
  public final void Z(Map<String, String> paramMap)
  {
    AppMethodBeat.i(68048);
    this.pKg = new LinkedHashMap();
    this.pKg.putAll(paramMap);
    AppMethodBeat.o(68048);
  }
  
  public final void a(ab.f paramf, ab.e parame)
  {
    AppMethodBeat.i(68051);
    this.pKk = paramf;
    this.pKb = parame;
    if (this.pKe.size() > 0)
    {
      paramf = new ArrayList();
      parame = this.pKe.keySet().iterator();
      while (parame.hasNext())
      {
        String str = (String)parame.next();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", new Object[] { str });
        paramf.add(Long.valueOf(bo.getLong(str, 0L)));
      }
      a(paramf, new ab.2(this));
      AppMethodBeat.o(68051);
      return;
    }
    BX(90);
    cdM();
    AppMethodBeat.o(68051);
  }
  
  final void cdM()
  {
    AppMethodBeat.i(68052);
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    Object localObject3;
    Object localObject4;
    if ((this.pKf != null) && (this.pKf.size() > 0))
    {
      localObject1 = new q.a[this.pKf.size()];
      localObject2 = this.pKf.keySet().iterator();
      i = 0;
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new q.a();
        ((q.a)localObject4).pJw = ((String)this.pKf.get(localObject3));
        ((q.a)localObject4).fileName = ((String)localObject3);
        ((q.a)localObject4).name = ((String)this.pKg.get(localObject3));
        ((q.a)localObject4).fileSize = ((int)e.avI((String)localObject3));
        localObject1[j] = localObject4;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", new Object[] { Integer.valueOf(j), ((q.a)localObject4).pJw, ((q.a)localObject4).fileName, ((q.a)localObject4).name, Integer.valueOf(((q.a)localObject4).fileSize) });
        i = ((q.a)localObject4).fileSize + i;
        j += 1;
      }
    }
    for (;;)
    {
      Object localObject5;
      if ((this.pKj != null) && (this.pKj.size() > 0))
      {
        localObject2 = new q.a[this.pKj.size()];
        localObject3 = this.pKj.keySet().iterator();
        j = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = new q.a();
          ((q.a)localObject5).pJw = ((String)this.pKj.get(localObject4));
          ((q.a)localObject5).fileName = ((String)localObject4);
          ((q.a)localObject5).fileSize = bo.a((Integer)this.pKn.get(((q.a)localObject5).pJw), 0);
          if (((q.a)localObject5).fileSize == 0) {
            ((q.a)localObject5).fileSize = ((int)e.avI((String)localObject4));
          }
          localObject2[j] = localObject5;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", new Object[] { Integer.valueOf(j), ((q.a)localObject5).pJw, ((q.a)localObject5).fileName, Integer.valueOf(((q.a)localObject5).fileSize) });
          i = ((q.a)localObject5).fileSize + i;
          j += 1;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", new Object[] { Integer.valueOf(i) });
        if ((localObject2 == null) || (localObject2.length == 0))
        {
          localObject2 = null;
          if ((localObject1 != null) && (localObject1.length != 0)) {
            break label591;
          }
          localObject1 = null;
        }
        label591:
        for (;;)
        {
          localObject3 = new a()
          {
            public final void cdO()
            {
              AppMethodBeat.i(68041);
              ab.this.BX(100);
              AppMethodBeat.o(68041);
            }
          };
          localObject4 = new q(this.czp, this.pJq, this.pJr, this.pJs, this.pIO);
          ((q)localObject4).pJt = this.pKd;
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1622;
          }
          ((q)localObject4).pJv = new q.a[localObject1.length];
          j = 0;
          while (j < ((q)localObject4).pJv.length)
          {
            ((q)localObject4).pJv[j] = localObject1[j];
            j += 1;
          }
          break;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", new Object[] { Integer.valueOf(((q)localObject4).pJv.length) });
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          ((q)localObject4).pJu = ((q.a[])localObject2);
          label637:
          localObject2 = new StringBuilder("");
          localObject5 = new StringBuilder("");
          if (((q)localObject4).czp == null) {
            break label1640;
          }
          localObject1 = new StringBuilder("");
          ((StringBuilder)localObject1).append("From: ");
          ((StringBuilder)localObject1).append("\"");
          ((StringBuilder)localObject1).append("=?utf-8?B?");
          ((StringBuilder)localObject1).append(Base64.encodeToString(((q)localObject4).czp.getBytes(), 2));
          ((StringBuilder)localObject1).append("?=");
          ((StringBuilder)localObject1).append("\"");
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append("<");
          ((StringBuilder)localObject1).append(((q)localObject4).czp);
          ((StringBuilder)localObject1).append(">");
        }
        int k;
        Object localObject6;
        int m;
        label1622:
        label1640:
        for (localObject1 = ((StringBuilder)localObject1).toString();; localObject1 = null)
        {
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((q)localObject4).cdF();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((q)localObject4).cdG();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((q)localObject4).cdH();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          ((StringBuilder)localObject5).append("Subject: ");
          if (((q)localObject4).pIO != null) {
            ((StringBuilder)localObject5).append(((q)localObject4).pIO);
          }
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("Mime-Version: 1.0");
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("Content-Type: multipart/mixed;boundary=\"----=_NextPart_5208D22F_0929AFA8_5112E4AB\"");
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("Content-Transfer-Encoding: 8Bit");
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("Date: ".concat(String.valueOf(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new Locale("en")).format(new Date()))));
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("X-QQ-MIME: TCMime 1.0 by Tencent");
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("X-Mailer: QQMail 2.x");
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("X-QQ-Mailer: QQMail 2.x");
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject2).append(((StringBuilder)localObject5).toString());
          ((StringBuilder)localObject2).append("\r\n");
          ((StringBuilder)localObject2).append("This is a multi-part message in MIME format.");
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append("\r\n");
          localObject1 = new StringBuilder("");
          ((StringBuilder)localObject1).append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
          ((StringBuilder)localObject1).append("\n");
          ((StringBuilder)localObject1).append("Content-Type:text/html;charset=\"utf-8\"");
          ((StringBuilder)localObject1).append("\n");
          ((StringBuilder)localObject1).append("Content-Transfer-Encoding:base64");
          ((StringBuilder)localObject1).append("\n");
          ((StringBuilder)localObject1).append("\r\n");
          ((StringBuilder)localObject1).append(Base64.encodeToString(((q)localObject4).pJt.getBytes(), 0));
          ((StringBuilder)localObject1).append("\n");
          ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
          ((StringBuilder)localObject2).append("\r\n");
          if ((((q)localObject4).pJu == null) || (((q)localObject4).pJu.length <= 0)) {
            break label1646;
          }
          localObject1 = ((q)localObject4).pJu;
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            StringBuilder localStringBuilder = localObject1[j];
            localObject5 = localStringBuilder.pJw;
            localObject6 = localStringBuilder.fileName;
            m = localStringBuilder.fileSize;
            localStringBuilder = new StringBuilder("");
            localStringBuilder.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
            localStringBuilder.append("\n");
            localStringBuilder.append(String.format("Content-Type:image/jpeg;name=\"%s\"", new Object[] { localObject6 }));
            localStringBuilder.append("\n");
            localStringBuilder.append("Content-Transfer-Encoding:base64");
            localStringBuilder.append("\n");
            localStringBuilder.append(String.format("Content-ID:<%s>", new Object[] { localObject6 }));
            localStringBuilder.append("\n");
            localStringBuilder.append("\r\n");
            localStringBuilder.append(String.format("QQMail-LinkID:%s", new Object[] { localObject5 }));
            localStringBuilder.append("\n");
            localStringBuilder.append(String.format("QQMail-LinkSize:%d", new Object[] { Integer.valueOf(m) }));
            localStringBuilder.append("\n");
            localStringBuilder.append("QQMail-LineLen:72");
            localStringBuilder.append("\n");
            localStringBuilder.append("QQMail-BreakType:1");
            localStringBuilder.append("\n");
            localStringBuilder.append(String.format("QQMail-Key:%s", new Object[] { q.Xu((String)localObject5) }));
            localStringBuilder.append("\n");
            localStringBuilder.append("QQMail-LinkEnd");
            localStringBuilder.append("\n");
            ((StringBuilder)localObject2).append(localStringBuilder.toString());
            ((StringBuilder)localObject2).append("\r\n");
            j += 1;
          }
          ((q)localObject4).pJv = null;
          break;
          ((q)localObject4).pJu = null;
          break label637;
        }
        label1646:
        ((StringBuilder)localObject2).append("\r\n");
        if ((((q)localObject4).pJv != null) && (((q)localObject4).pJv.length > 0))
        {
          localObject1 = ((q)localObject4).pJv;
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            localObject5 = localObject1[j];
            localObject4 = ((q.a)localObject5).pJw;
            m = ((q.a)localObject5).fileSize;
            localObject5 = ((q.a)localObject5).name;
            localObject6 = new StringBuilder("");
            ((StringBuilder)localObject6).append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append(String.format("Content-Type:application/octet-stream;charset=\"utf-8\";name=\"=?utf-8?B?%s?=\"", new Object[] { Base64.encodeToString(((String)localObject5).getBytes(), 2) }));
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append(String.format("Content-Disposition: attachment; filename=\"=?utf-8?B?%s?=\"", new Object[] { Base64.encodeToString(((String)localObject5).getBytes(), 2) }));
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append("Content-Transfer-Encoding:base64");
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append(String.format("Content-ID:<%s>", new Object[] { Long.valueOf(System.currentTimeMillis()) }));
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append("\r\n");
            ((StringBuilder)localObject6).append(String.format("QQMail-LinkID:%s", new Object[] { localObject4 }));
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append(String.format("QQMail-LinkSize:%d", new Object[] { Integer.valueOf(m) }));
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append("QQMail-LineLen:72");
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append("QQMail-BreakType:1");
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append(String.format("QQMail-Key:%s", new Object[] { q.Xu((String)localObject4) }));
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append("QQMail-LinkEnd");
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject2).append(((StringBuilder)localObject6).toString());
            ((StringBuilder)localObject2).append("\r\n");
            j += 1;
          }
        }
        ((StringBuilder)localObject2).append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        localObject1 = new s(((StringBuilder)localObject2).toString(), this.czp, this.pJq, i, new com.tencent.mm.ai.g()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, m paramAnonymousm)
          {
            AppMethodBeat.i(68044);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if (paramAnonymousInt1 >= paramAnonymousInt2)
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "finish send");
              if (this.pKy != null) {
                this.pKy.cdO();
              }
            }
            AppMethodBeat.o(68044);
          }
        });
        com.tencent.mm.kernel.g.RK().eHt.a((m)localObject1, 0);
        AppMethodBeat.o(68052);
        return;
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(68050);
    this.pKm.clear();
    this.pJs = null;
    this.pKo = 0;
    this.pKq = null;
    this.pKr = null;
    this.pKs.clear();
    this.pKp.clear();
    this.czp = null;
    this.pKl.clear();
    this.pKe.clear();
    this.pKd = null;
    this.pIO = null;
    this.pKv = 0;
    this.pJq = null;
    this.pKf.clear();
    this.pKj.clear();
    this.pKn.clear();
    this.pKk = null;
    this.pKb = null;
    AppMethodBeat.o(68050);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(68053);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramm.getType() == 483)
      {
        a((r)paramm);
        AppMethodBeat.o(68053);
        return;
      }
      if (this.pKb != null) {
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68042);
            ab.this.pKb.Xx(ab.this.pIO);
            AppMethodBeat.o(68042);
          }
        });
      }
      AppMethodBeat.o(68053);
      return;
    }
    if (paramm.getType() == 483)
    {
      a((r)paramm);
      AppMethodBeat.o(68053);
      return;
    }
    if (paramm.getType() != 484) {
      paramm.getType();
    }
    AppMethodBeat.o(68053);
  }
  
  static abstract interface a
  {
    public abstract void cdO();
  }
  
  public static abstract interface b
  {
    public abstract void a(ArrayList<Long> paramArrayList, HashMap<Long, String> paramHashMap);
  }
  
  public static abstract interface c
  {
    public abstract void cdN();
  }
  
  public static final class g
  {
    public String fileId;
    public String fileName;
    
    public g() {}
    
    public g(String paramString1, String paramString2)
    {
      this.fileId = paramString1;
      this.fileName = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ab
 * JD-Core Version:    0.7.0.1
 */