package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  String bRO;
  String ndx;
  ab.e neM = null;
  String neO;
  Map<String, String> neP = new HashMap();
  Map<String, String> neQ = new LinkedHashMap();
  Map<String, String> neR = new LinkedHashMap();
  private ab.b neS;
  public z neT;
  Map<String, String> neU = new HashMap();
  ab.f neV = null;
  HashMap<Long, Integer> neW = new HashMap();
  HashMap<Long, String> neX = new HashMap();
  HashMap<String, Integer> neY = new HashMap();
  int neZ = 0;
  String[] nea;
  String[] neb;
  String[] nec;
  ArrayList<g> nfa = new ArrayList();
  String nfb = null;
  String nfc = null;
  HashMap<String, String> nfd = new HashMap();
  ab.c nfe;
  ab.d nff;
  int nfg = 0;
  com.tencent.mm.ah.g nfh = new ab.7(this);
  
  public ab()
  {
    com.tencent.mm.kernel.g.DO().dJT.a(483, this);
    com.tencent.mm.kernel.g.DO().dJT.a(484, this);
    com.tencent.mm.kernel.g.DO().dJT.a(485, this);
  }
  
  private void L(ArrayList<Long> paramArrayList)
  {
    if (this.neW != null)
    {
      this.neW.clear();
      this.neW = null;
    }
    this.neW = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      long l = ((Long)paramArrayList.next()).longValue();
      this.neW.put(Long.valueOf(l), Integer.valueOf(1));
    }
  }
  
  private void a(r paramr)
  {
    this.neZ += 1;
    y.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[] { Integer.valueOf(this.neZ) });
    paramr = ((d)paramr.dmK.ecF.ecN).ndd.iterator();
    while (paramr.hasNext())
    {
      g localg = (g)paramr.next();
      long l = localg.ndm;
      int i = localg.hQq;
      if (this.neW.containsKey(Long.valueOf(l)))
      {
        y.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        if (i == 0)
        {
          this.neW.remove(Long.valueOf(l));
          if (localg.ndn != null)
          {
            y.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[] { Long.valueOf(l), localg.ndn });
            this.neX.put(Long.valueOf(l), localg.ndn);
            this.neY.put(localg.ndn, Integer.valueOf(localg.ndo));
          }
        }
        else
        {
          this.neW.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
    }
    if (this.neW.isEmpty())
    {
      y.i("MicroMsg.ShareModeMailAppService", "all image is in server");
      if (this.neS != null) {
        this.neS.a(new ArrayList(), this.neX);
      }
      return;
    }
    if (this.neZ < 3)
    {
      y.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
      paramr = new r(l(this.neW));
      com.tencent.mm.kernel.g.DO().dJT.a(paramr, 0);
      return;
    }
    this.neS.a(l(this.neW), this.neX);
  }
  
  private static ArrayList<Long> l(HashMap<Long, Integer> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.keySet().iterator();
    while (paramHashMap.hasNext()) {
      localArrayList.add((Long)paramHashMap.next());
    }
    return localArrayList;
  }
  
  public final void a(ab.f paramf, ab.e parame)
  {
    this.neV = paramf;
    this.neM = parame;
    if (this.neP.size() > 0)
    {
      paramf = new ArrayList();
      parame = this.neP.keySet().iterator();
      while (parame.hasNext())
      {
        String str = (String)parame.next();
        y.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", new Object[] { str });
        paramf.add(Long.valueOf(bk.getLong(str, 0L)));
      }
      parame = new ab.b()
      {
        public final void a(ArrayList<Long> paramAnonymousArrayList, HashMap<Long, String> paramAnonymousHashMap)
        {
          y.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", new Object[] { Integer.valueOf(paramAnonymousArrayList.size()), Integer.valueOf(paramAnonymousHashMap.size()) });
          Object localObject1;
          if (paramAnonymousArrayList.size() > 0)
          {
            localObject1 = ab.this;
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            while (paramAnonymousArrayList.hasNext())
            {
              Object localObject2 = (Long)paramAnonymousArrayList.next();
              localObject2 = (String)((ab)localObject1).neP.get(String.valueOf(localObject2));
              y.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", new Object[] { localObject2 });
              if (!bk.bl((String)localObject2))
              {
                if (((ab)localObject1).nfa == null) {
                  ((ab)localObject1).nfa = new ArrayList();
                }
                ((ab)localObject1).nfa.add(new ab.g((String)localObject2, (String)localObject2));
              }
            }
          }
          if (paramAnonymousHashMap.size() > 0) {
            ab.a(ab.this, paramAnonymousHashMap);
          }
          ab.this.wm(10);
          paramAnonymousArrayList = ab.this;
          y.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", new Object[] { Integer.valueOf(paramAnonymousArrayList.nfa.size()) });
          if (paramAnonymousArrayList.nfa == null) {
            paramAnonymousArrayList.nfa = new ArrayList();
          }
          if (paramAnonymousArrayList.nfa.size() > 0)
          {
            paramAnonymousHashMap = new ab.3(paramAnonymousArrayList);
            localObject1 = new ab.4(paramAnonymousArrayList);
            y.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", new Object[] { Integer.valueOf(paramAnonymousArrayList.nfa.size()) });
            paramAnonymousArrayList.nfe = paramAnonymousHashMap;
            paramAnonymousArrayList.nff = ((ab.d)localObject1);
            paramAnonymousArrayList.nfg = paramAnonymousArrayList.nfa.size();
            if ((paramAnonymousArrayList.nfa != null) && (paramAnonymousArrayList.nfa.size() > 0))
            {
              paramAnonymousHashMap = (ab.g)paramAnonymousArrayList.nfa.remove(0);
              paramAnonymousArrayList.nfb = paramAnonymousHashMap.fileId;
              paramAnonymousArrayList.nfc = paramAnonymousHashMap.fileName;
              paramAnonymousArrayList.nfd = new HashMap();
              paramAnonymousArrayList = new u(paramAnonymousArrayList.nfc, paramAnonymousArrayList.nfb, paramAnonymousArrayList.nfh);
              com.tencent.mm.kernel.g.DO().dJT.a(paramAnonymousArrayList, 0);
            }
            return;
          }
          paramAnonymousArrayList.wm(90);
          paramAnonymousArrayList.btB();
        }
      };
      y.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
      this.neZ = 0;
      L(paramf);
      if (this.neX != null)
      {
        this.neX.clear();
        this.neX = null;
      }
      this.neX = new HashMap();
      this.neS = parame;
      paramf = new r(paramf);
      com.tencent.mm.kernel.g.DO().dJT.a(paramf, 0);
      return;
    }
    wm(90);
    btB();
  }
  
  final void btB()
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    Object localObject3;
    Object localObject4;
    if ((this.neQ != null) && (this.neQ.size() > 0))
    {
      localObject1 = new q.a[this.neQ.size()];
      localObject2 = this.neQ.keySet().iterator();
      i = 0;
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new q.a();
        ((q.a)localObject4).neg = ((String)this.neQ.get(localObject3));
        ((q.a)localObject4).fileName = ((String)localObject3);
        ((q.a)localObject4).name = ((String)this.neR.get(localObject3));
        ((q.a)localObject4).fileSize = ((int)e.aeQ((String)localObject3));
        localObject1[j] = localObject4;
        y.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", new Object[] { Integer.valueOf(j), ((q.a)localObject4).neg, ((q.a)localObject4).fileName, ((q.a)localObject4).name, Integer.valueOf(((q.a)localObject4).fileSize) });
        i = ((q.a)localObject4).fileSize + i;
        j += 1;
      }
    }
    for (;;)
    {
      Object localObject5;
      if ((this.neU != null) && (this.neU.size() > 0))
      {
        localObject2 = new q.a[this.neU.size()];
        localObject3 = this.neU.keySet().iterator();
        j = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = new q.a();
          ((q.a)localObject5).neg = ((String)this.neU.get(localObject4));
          ((q.a)localObject5).fileName = ((String)localObject4);
          ((q.a)localObject5).fileSize = bk.a((Integer)this.neY.get(((q.a)localObject5).neg), 0);
          if (((q.a)localObject5).fileSize == 0) {
            ((q.a)localObject5).fileSize = ((int)e.aeQ((String)localObject4));
          }
          localObject2[j] = localObject5;
          y.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", new Object[] { Integer.valueOf(j), ((q.a)localObject5).neg, ((q.a)localObject5).fileName, Integer.valueOf(((q.a)localObject5).fileSize) });
          i = ((q.a)localObject5).fileSize + i;
          j += 1;
        }
      }
      for (;;)
      {
        y.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", new Object[] { Integer.valueOf(i) });
        if ((localObject2 == null) || (localObject2.length == 0))
        {
          localObject2 = null;
          if ((localObject1 != null) && (localObject1.length != 0)) {
            break label585;
          }
          localObject1 = null;
        }
        label585:
        for (;;)
        {
          localObject3 = new ab.5(this);
          localObject4 = new q(this.bRO, this.nea, this.neb, this.nec, this.ndx);
          ((q)localObject4).ned = this.neO;
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1627;
          }
          ((q)localObject4).nef = new q.a[localObject1.length];
          j = 0;
          while (j < ((q)localObject4).nef.length)
          {
            ((q)localObject4).nef[j] = localObject1[j];
            j += 1;
          }
          break;
        }
        y.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", new Object[] { Integer.valueOf(((q)localObject4).nef.length) });
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          ((q)localObject4).nee = ((q.a[])localObject2);
          label631:
          localObject2 = new StringBuilder("");
          localObject5 = new StringBuilder("");
          if (((q)localObject4).bRO == null) {
            break label1645;
          }
          localObject1 = new StringBuilder("");
          ((StringBuilder)localObject1).append("From: ");
          ((StringBuilder)localObject1).append("\"");
          ((StringBuilder)localObject1).append("=?utf-8?B?");
          ((StringBuilder)localObject1).append(Base64.encodeToString(((q)localObject4).bRO.getBytes(), 2));
          ((StringBuilder)localObject1).append("?=");
          ((StringBuilder)localObject1).append("\"");
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append("<");
          ((StringBuilder)localObject1).append(((q)localObject4).bRO);
          ((StringBuilder)localObject1).append(">");
        }
        int k;
        Object localObject6;
        int m;
        label1627:
        label1645:
        for (localObject1 = ((StringBuilder)localObject1).toString();; localObject1 = null)
        {
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((q)localObject4).btv();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((q)localObject4).btw();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((q)localObject4).btx();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          ((StringBuilder)localObject5).append("Subject: ");
          if (((q)localObject4).ndx != null) {
            ((StringBuilder)localObject5).append(((q)localObject4).ndx);
          }
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("Mime-Version: 1.0");
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("Content-Type: multipart/mixed;boundary=\"----=_NextPart_5208D22F_0929AFA8_5112E4AB\"");
          ((StringBuilder)localObject5).append("\n");
          ((StringBuilder)localObject5).append("Content-Transfer-Encoding: 8Bit");
          ((StringBuilder)localObject5).append("\n");
          localObject1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new Locale("en")).format(new Date());
          ((StringBuilder)localObject5).append("Date: " + (String)localObject1);
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
          ((StringBuilder)localObject1).append(Base64.encodeToString(((q)localObject4).ned.getBytes(), 0));
          ((StringBuilder)localObject1).append("\n");
          ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
          ((StringBuilder)localObject2).append("\r\n");
          if ((((q)localObject4).nee == null) || (((q)localObject4).nee.length <= 0)) {
            break label1651;
          }
          localObject1 = ((q)localObject4).nee;
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            StringBuilder localStringBuilder = localObject1[j];
            localObject5 = localStringBuilder.neg;
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
            localStringBuilder.append(String.format("QQMail-Key:%s", new Object[] { q.Lk((String)localObject5) }));
            localStringBuilder.append("\n");
            localStringBuilder.append("QQMail-LinkEnd");
            localStringBuilder.append("\n");
            ((StringBuilder)localObject2).append(localStringBuilder.toString());
            ((StringBuilder)localObject2).append("\r\n");
            j += 1;
          }
          ((q)localObject4).nef = null;
          break;
          ((q)localObject4).nee = null;
          break label631;
        }
        label1651:
        ((StringBuilder)localObject2).append("\r\n");
        if ((((q)localObject4).nef != null) && (((q)localObject4).nef.length > 0))
        {
          localObject1 = ((q)localObject4).nef;
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            localObject5 = localObject1[j];
            localObject4 = ((q.a)localObject5).neg;
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
            ((StringBuilder)localObject6).append(String.format("QQMail-Key:%s", new Object[] { q.Lk((String)localObject4) }));
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append("QQMail-LinkEnd");
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject2).append(((StringBuilder)localObject6).toString());
            ((StringBuilder)localObject2).append("\r\n");
            j += 1;
          }
        }
        ((StringBuilder)localObject2).append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        localObject1 = new s(((StringBuilder)localObject2).toString(), this.bRO, this.nea, i, new ab.8(this, (a)localObject3));
        com.tencent.mm.kernel.g.DO().dJT.a((m)localObject1, 0);
        return;
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramm.getType() == 483) {
        a((r)paramm);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.neM == null);
      ai.d(new ab.6(this));
      return;
      if (paramm.getType() == 483)
      {
        a((r)paramm);
        return;
      }
    } while (paramm.getType() == 484);
    paramm.getType();
  }
  
  public final void wm(int paramInt)
  {
    if (this.neV != null) {
      ai.d(new ab.1(this, paramInt));
    }
  }
  
  static abstract interface a
  {
    public abstract void btD();
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