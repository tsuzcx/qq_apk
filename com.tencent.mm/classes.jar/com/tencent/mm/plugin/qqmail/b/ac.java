package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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

public final class ac
  implements com.tencent.mm.al.g
{
  String dpv;
  String[] uLJ;
  String[] uLK;
  private String[] uLL;
  String uLh;
  public aa uMA;
  Map<String, String> uMB;
  f uMC;
  private HashMap<Long, Integer> uMD;
  private HashMap<Long, String> uME;
  private HashMap<String, Integer> uMF;
  private int uMG;
  ArrayList<g> uMH;
  String uMI;
  String uMJ;
  HashMap<String, String> uMK;
  c uML;
  d uMM;
  int uMN;
  h uMO;
  e uMt;
  String uMv;
  Map<String, String> uMw;
  private Map<String, String> uMx;
  private Map<String, String> uMy;
  private b uMz;
  
  public ac()
  {
    AppMethodBeat.i(122778);
    this.uMw = new HashMap();
    this.uMx = new LinkedHashMap();
    this.uMy = new LinkedHashMap();
    this.uMB = new HashMap();
    this.uMC = null;
    this.uMt = null;
    this.uMD = new HashMap();
    this.uME = new HashMap();
    this.uMF = new HashMap();
    this.uMG = 0;
    this.uMH = new ArrayList();
    this.uMI = null;
    this.uMJ = null;
    this.uMK = new HashMap();
    this.uMN = 0;
    this.uMO = new h()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(122776);
        ad.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[] { ac.this.uMI, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(ac.this.uMH.size()) });
        if (paramAnonymousInt1 >= paramAnonymousInt2)
        {
          ac.this.uMK.put(ac.this.uMJ, ((v)paramAnonymousn).deb().uKY);
          paramAnonymousn = ((v)paramAnonymousn).deb();
          if (ac.this.uMM != null) {
            ac.this.uMM.f(ac.this.uMN - ac.this.uMH.size(), ac.this.uMN, ac.this.uMJ, paramAnonymousn.uKY);
          }
          if (ac.this.uMH.isEmpty())
          {
            ad.i("MicroMsg.ShareModeMailAppService", "finished send all files");
            if (ac.this.uML != null) {
              ac.this.uML.dee();
            }
            AppMethodBeat.o(122776);
            return;
          }
          ad.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
          paramAnonymousn = (ac.g)ac.this.uMH.remove(0);
          ac.this.uMI = paramAnonymousn.fileId;
          ac.this.uMJ = paramAnonymousn.fileName;
          paramAnonymousn = new v(ac.this.uMJ, ac.this.uMI, this);
          com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousn, 0);
        }
        AppMethodBeat.o(122776);
      }
    };
    com.tencent.mm.kernel.g.afA().gcy.a(483, this);
    com.tencent.mm.kernel.g.afA().gcy.a(484, this);
    com.tencent.mm.kernel.g.afA().gcy.a(485, this);
    AppMethodBeat.o(122778);
  }
  
  private void a(s params)
  {
    AppMethodBeat.i(122790);
    this.uMG += 1;
    ad.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[] { Integer.valueOf(this.uMG) });
    params = params.dea().iterator();
    while (params.hasNext())
    {
      g localg = (g)params.next();
      long l = localg.uKX;
      int i = localg.mBi;
      if (this.uMD.containsKey(Long.valueOf(l)))
      {
        ad.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        if (i == 0)
        {
          this.uMD.remove(Long.valueOf(l));
          if (localg.uKY != null)
          {
            ad.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[] { Long.valueOf(l), localg.uKY });
            this.uME.put(Long.valueOf(l), localg.uKY);
            this.uMF.put(localg.uKY, Integer.valueOf(localg.FileSize));
          }
        }
        else
        {
          this.uMD.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
    }
    if (this.uMD.isEmpty())
    {
      ad.i("MicroMsg.ShareModeMailAppService", "all image is in server");
      if (this.uMz != null) {
        this.uMz.a(new ArrayList(), this.uME);
      }
      AppMethodBeat.o(122790);
      return;
    }
    if (this.uMG < 3)
    {
      ad.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
      params = new s(i(this.uMD));
      com.tencent.mm.kernel.g.afA().gcy.a(params, 0);
      AppMethodBeat.o(122790);
      return;
    }
    this.uMz.a(i(this.uMD), this.uME);
    AppMethodBeat.o(122790);
  }
  
  private void a(ArrayList<Long> paramArrayList, b paramb)
  {
    AppMethodBeat.i(122788);
    ad.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
    this.uMG = 0;
    ag(paramArrayList);
    if (this.uME != null)
    {
      this.uME.clear();
      this.uME = null;
    }
    this.uME = new HashMap();
    this.uMz = paramb;
    paramArrayList = new s(paramArrayList);
    com.tencent.mm.kernel.g.afA().gcy.a(paramArrayList, 0);
    AppMethodBeat.o(122788);
  }
  
  private void ag(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(122787);
    if (this.uMD != null)
    {
      this.uMD.clear();
      this.uMD = null;
    }
    this.uMD = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      long l = ((Long)paramArrayList.next()).longValue();
      this.uMD.put(Long.valueOf(l), Integer.valueOf(1));
    }
    AppMethodBeat.o(122787);
  }
  
  private static ArrayList<Long> i(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(122789);
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.keySet().iterator();
    while (paramHashMap.hasNext()) {
      localArrayList.add((Long)paramHashMap.next());
    }
    AppMethodBeat.o(122789);
    return localArrayList;
  }
  
  public final void JM(final int paramInt)
  {
    AppMethodBeat.i(122782);
    if (this.uMC != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(122770);
          ac.this.uMC.aq(ac.this.uLh, paramInt, this.hhZ);
          AppMethodBeat.o(122770);
        }
      });
    }
    AppMethodBeat.o(122782);
  }
  
  public final void a(f paramf, e parame)
  {
    AppMethodBeat.i(122784);
    this.uMC = paramf;
    this.uMt = parame;
    if (this.uMw.size() > 0)
    {
      paramf = new ArrayList();
      parame = this.uMw.keySet().iterator();
      while (parame.hasNext())
      {
        String str = (String)parame.next();
        ad.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", new Object[] { str });
        paramf.add(Long.valueOf(bt.getLong(str, 0L)));
      }
      a(paramf, new b()
      {
        public final void a(ArrayList<Long> paramAnonymousArrayList, HashMap<Long, String> paramAnonymousHashMap)
        {
          AppMethodBeat.i(122771);
          ad.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", new Object[] { Integer.valueOf(paramAnonymousArrayList.size()), Integer.valueOf(paramAnonymousHashMap.size()) });
          Object localObject1;
          if (paramAnonymousArrayList.size() > 0)
          {
            localObject1 = ac.this;
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            while (paramAnonymousArrayList.hasNext())
            {
              Object localObject2 = (Long)paramAnonymousArrayList.next();
              localObject2 = (String)((ac)localObject1).uMw.get(String.valueOf(localObject2));
              ad.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", new Object[] { localObject2 });
              if (!bt.isNullOrNil((String)localObject2))
              {
                if (((ac)localObject1).uMH == null) {
                  ((ac)localObject1).uMH = new ArrayList();
                }
                ((ac)localObject1).uMH.add(new ac.g((String)localObject2, (String)localObject2));
              }
            }
          }
          if (paramAnonymousHashMap.size() > 0) {
            ac.a(ac.this, paramAnonymousHashMap);
          }
          ac.this.JM(10);
          paramAnonymousArrayList = ac.this;
          ad.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", new Object[] { Integer.valueOf(paramAnonymousArrayList.uMH.size()) });
          if (paramAnonymousArrayList.uMH == null) {
            paramAnonymousArrayList.uMH = new ArrayList();
          }
          if (paramAnonymousArrayList.uMH.size() > 0)
          {
            paramAnonymousHashMap = new ac.3(paramAnonymousArrayList);
            localObject1 = new ac.4(paramAnonymousArrayList);
            ad.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", new Object[] { Integer.valueOf(paramAnonymousArrayList.uMH.size()) });
            paramAnonymousArrayList.uML = paramAnonymousHashMap;
            paramAnonymousArrayList.uMM = ((ac.d)localObject1);
            paramAnonymousArrayList.uMN = paramAnonymousArrayList.uMH.size();
            if ((paramAnonymousArrayList.uMH != null) && (paramAnonymousArrayList.uMH.size() > 0))
            {
              paramAnonymousHashMap = (ac.g)paramAnonymousArrayList.uMH.remove(0);
              paramAnonymousArrayList.uMI = paramAnonymousHashMap.fileId;
              paramAnonymousArrayList.uMJ = paramAnonymousHashMap.fileName;
              paramAnonymousArrayList.uMK = new HashMap();
              paramAnonymousArrayList = new v(paramAnonymousArrayList.uMJ, paramAnonymousArrayList.uMI, paramAnonymousArrayList.uMO);
              com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousArrayList, 0);
            }
            AppMethodBeat.o(122771);
            return;
          }
          paramAnonymousArrayList.JM(90);
          paramAnonymousArrayList.ded();
          AppMethodBeat.o(122771);
        }
      });
      AppMethodBeat.o(122784);
      return;
    }
    JM(90);
    ded();
    AppMethodBeat.o(122784);
  }
  
  public final void at(Map<String, String> paramMap)
  {
    AppMethodBeat.i(122779);
    this.uMw = new HashMap();
    this.uMw.putAll(paramMap);
    AppMethodBeat.o(122779);
  }
  
  public final void au(Map<String, String> paramMap)
  {
    AppMethodBeat.i(122780);
    this.uMx = new LinkedHashMap();
    this.uMx.putAll(paramMap);
    AppMethodBeat.o(122780);
  }
  
  public final void av(Map<String, String> paramMap)
  {
    AppMethodBeat.i(122781);
    this.uMy = new LinkedHashMap();
    this.uMy.putAll(paramMap);
    AppMethodBeat.o(122781);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(122783);
    this.uME.clear();
    this.uLL = null;
    this.uMG = 0;
    this.uMI = null;
    this.uMJ = null;
    this.uMK.clear();
    this.uMH.clear();
    this.dpv = null;
    this.uMD.clear();
    this.uMw.clear();
    this.uMv = null;
    this.uLh = null;
    this.uMN = 0;
    this.uLJ = null;
    this.uMx.clear();
    this.uMB.clear();
    this.uMF.clear();
    this.uMC = null;
    this.uMt = null;
    AppMethodBeat.o(122783);
  }
  
  final void ded()
  {
    AppMethodBeat.i(122785);
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    Object localObject3;
    Object localObject4;
    if ((this.uMx != null) && (this.uMx.size() > 0))
    {
      localObject1 = new r.a[this.uMx.size()];
      localObject2 = this.uMx.keySet().iterator();
      i = 0;
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new r.a();
        ((r.a)localObject4).uLP = ((String)this.uMx.get(localObject3));
        ((r.a)localObject4).fileName = ((String)localObject3);
        ((r.a)localObject4).name = ((String)this.uMy.get(localObject3));
        ((r.a)localObject4).fileSize = ((int)i.aMN((String)localObject3));
        localObject1[j] = localObject4;
        ad.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", new Object[] { Integer.valueOf(j), ((r.a)localObject4).uLP, ((r.a)localObject4).fileName, ((r.a)localObject4).name, Integer.valueOf(((r.a)localObject4).fileSize) });
        i = ((r.a)localObject4).fileSize + i;
        j += 1;
      }
    }
    for (;;)
    {
      Object localObject5;
      if ((this.uMB != null) && (this.uMB.size() > 0))
      {
        localObject2 = new r.a[this.uMB.size()];
        localObject3 = this.uMB.keySet().iterator();
        j = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = new r.a();
          ((r.a)localObject5).uLP = ((String)this.uMB.get(localObject4));
          ((r.a)localObject5).fileName = ((String)localObject4);
          ((r.a)localObject5).fileSize = bt.a((Integer)this.uMF.get(((r.a)localObject5).uLP), 0);
          if (((r.a)localObject5).fileSize == 0) {
            ((r.a)localObject5).fileSize = ((int)i.aMN((String)localObject4));
          }
          localObject2[j] = localObject5;
          ad.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", new Object[] { Integer.valueOf(j), ((r.a)localObject5).uLP, ((r.a)localObject5).fileName, Integer.valueOf(((r.a)localObject5).fileSize) });
          i = ((r.a)localObject5).fileSize + i;
          j += 1;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", new Object[] { Integer.valueOf(i) });
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
            public final void def()
            {
              AppMethodBeat.i(122774);
              ac.this.JM(100);
              AppMethodBeat.o(122774);
            }
          };
          localObject4 = new r(this.dpv, this.uLJ, this.uLK, this.uLL, this.uLh);
          ((r)localObject4).uLM = this.uMv;
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1622;
          }
          ((r)localObject4).uLO = new r.a[localObject1.length];
          j = 0;
          while (j < ((r)localObject4).uLO.length)
          {
            ((r)localObject4).uLO[j] = localObject1[j];
            j += 1;
          }
          break;
        }
        ad.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", new Object[] { Integer.valueOf(((r)localObject4).uLO.length) });
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          ((r)localObject4).uLN = ((r.a[])localObject2);
          label637:
          localObject2 = new StringBuilder("");
          localObject5 = new StringBuilder("");
          if (((r)localObject4).dpv == null) {
            break label1640;
          }
          localObject1 = new StringBuilder("");
          ((StringBuilder)localObject1).append("From: ");
          ((StringBuilder)localObject1).append("\"");
          ((StringBuilder)localObject1).append("=?utf-8?B?");
          ((StringBuilder)localObject1).append(Base64.encodeToString(((r)localObject4).dpv.getBytes(), 2));
          ((StringBuilder)localObject1).append("?=");
          ((StringBuilder)localObject1).append("\"");
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append("<");
          ((StringBuilder)localObject1).append(((r)localObject4).dpv);
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
          localObject1 = ((r)localObject4).ddX();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((r)localObject4).ddY();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((r)localObject4).ddZ();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          ((StringBuilder)localObject5).append("Subject: ");
          if (((r)localObject4).uLh != null) {
            ((StringBuilder)localObject5).append(((r)localObject4).uLh);
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
          ((StringBuilder)localObject1).append(Base64.encodeToString(((r)localObject4).uLM.getBytes(), 0));
          ((StringBuilder)localObject1).append("\n");
          ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
          ((StringBuilder)localObject2).append("\r\n");
          if ((((r)localObject4).uLN == null) || (((r)localObject4).uLN.length <= 0)) {
            break label1646;
          }
          localObject1 = ((r)localObject4).uLN;
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            StringBuilder localStringBuilder = localObject1[j];
            localObject5 = localStringBuilder.uLP;
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
            localStringBuilder.append(String.format("QQMail-Key:%s", new Object[] { r.akX((String)localObject5) }));
            localStringBuilder.append("\n");
            localStringBuilder.append("QQMail-LinkEnd");
            localStringBuilder.append("\n");
            ((StringBuilder)localObject2).append(localStringBuilder.toString());
            ((StringBuilder)localObject2).append("\r\n");
            j += 1;
          }
          ((r)localObject4).uLO = null;
          break;
          ((r)localObject4).uLN = null;
          break label637;
        }
        label1646:
        ((StringBuilder)localObject2).append("\r\n");
        if ((((r)localObject4).uLO != null) && (((r)localObject4).uLO.length > 0))
        {
          localObject1 = ((r)localObject4).uLO;
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            localObject5 = localObject1[j];
            localObject4 = ((r.a)localObject5).uLP;
            m = ((r.a)localObject5).fileSize;
            localObject5 = ((r.a)localObject5).name;
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
            ((StringBuilder)localObject6).append(String.format("QQMail-Key:%s", new Object[] { r.akX((String)localObject4) }));
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append("QQMail-LinkEnd");
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject2).append(((StringBuilder)localObject6).toString());
            ((StringBuilder)localObject2).append("\r\n");
            j += 1;
          }
        }
        ((StringBuilder)localObject2).append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        localObject1 = new t(((StringBuilder)localObject2).toString(), this.dpv, this.uLJ, i, new h()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
          {
            AppMethodBeat.i(122777);
            ad.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if (paramAnonymousInt1 >= paramAnonymousInt2)
            {
              ad.i("MicroMsg.ShareModeMailAppService", "finish send");
              if (this.uMQ != null) {
                this.uMQ.def();
              }
            }
            AppMethodBeat.o(122777);
          }
        });
        com.tencent.mm.kernel.g.afA().gcy.a((n)localObject1, 0);
        AppMethodBeat.o(122785);
        return;
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(122786);
    ad.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramn.getType() == 483)
      {
        a((s)paramn);
        AppMethodBeat.o(122786);
        return;
      }
      if (this.uMt != null) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122775);
            ac.this.uMt.ala(ac.this.uLh);
            AppMethodBeat.o(122775);
          }
        });
      }
      AppMethodBeat.o(122786);
      return;
    }
    if (paramn.getType() == 483)
    {
      a((s)paramn);
      AppMethodBeat.o(122786);
      return;
    }
    if (paramn.getType() != 484) {
      paramn.getType();
    }
    AppMethodBeat.o(122786);
  }
  
  static abstract interface a
  {
    public abstract void def();
  }
  
  public static abstract interface b
  {
    public abstract void a(ArrayList<Long> paramArrayList, HashMap<Long, String> paramHashMap);
  }
  
  public static abstract interface c
  {
    public abstract void dee();
  }
  
  public static abstract interface d
  {
    public abstract void f(int paramInt1, int paramInt2, String paramString1, String paramString2);
  }
  
  public static abstract interface e
  {
    public abstract void ala(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void aq(String paramString, int paramInt1, int paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ac
 * JD-Core Version:    0.7.0.1
 */