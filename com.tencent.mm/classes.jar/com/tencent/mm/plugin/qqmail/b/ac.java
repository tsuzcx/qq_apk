package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements com.tencent.mm.ak.g
{
  String dng;
  String vTY;
  String[] vUA;
  private String[] vUB;
  String[] vUz;
  HashMap<String, String> vVA;
  c vVB;
  d vVC;
  int vVD;
  h vVE;
  e vVj;
  String vVl;
  Map<String, String> vVm;
  private Map<String, String> vVn;
  private Map<String, String> vVo;
  private b vVp;
  public aa vVq;
  Map<String, String> vVr;
  f vVs;
  private HashMap<Long, Integer> vVt;
  private HashMap<Long, String> vVu;
  private HashMap<String, Integer> vVv;
  private int vVw;
  ArrayList<g> vVx;
  String vVy;
  String vVz;
  
  public ac()
  {
    AppMethodBeat.i(122778);
    this.vVm = new HashMap();
    this.vVn = new LinkedHashMap();
    this.vVo = new LinkedHashMap();
    this.vVr = new HashMap();
    this.vVs = null;
    this.vVj = null;
    this.vVt = new HashMap();
    this.vVu = new HashMap();
    this.vVv = new HashMap();
    this.vVw = 0;
    this.vVx = new ArrayList();
    this.vVy = null;
    this.vVz = null;
    this.vVA = new HashMap();
    this.vVD = 0;
    this.vVE = new h()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(122776);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[] { ac.this.vVy, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(ac.this.vVx.size()) });
        if (paramAnonymousInt1 >= paramAnonymousInt2)
        {
          ac.this.vVA.put(ac.this.vVz, ((v)paramAnonymousn).drJ().vTP);
          paramAnonymousn = ((v)paramAnonymousn).drJ();
          if (ac.this.vVC != null) {
            ac.this.vVC.h(ac.this.vVD - ac.this.vVx.size(), ac.this.vVD, ac.this.vVz, paramAnonymousn.vTP);
          }
          if (ac.this.vVx.isEmpty())
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "finished send all files");
            if (ac.this.vVB != null) {
              ac.this.vVB.drM();
            }
            AppMethodBeat.o(122776);
            return;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
          paramAnonymousn = (ac.g)ac.this.vVx.remove(0);
          ac.this.vVy = paramAnonymousn.fileId;
          ac.this.vVz = paramAnonymousn.fileName;
          paramAnonymousn = new v(ac.this.vVz, ac.this.vVy, this);
          com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousn, 0);
        }
        AppMethodBeat.o(122776);
      }
    };
    com.tencent.mm.kernel.g.agQ().ghe.a(483, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(484, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(485, this);
    AppMethodBeat.o(122778);
  }
  
  private void a(s params)
  {
    AppMethodBeat.i(122790);
    this.vVw += 1;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[] { Integer.valueOf(this.vVw) });
    params = params.drI().iterator();
    while (params.hasNext())
    {
      g localg = (g)params.next();
      long l = localg.vTO;
      int i = localg.ndj;
      if (this.vVt.containsKey(Long.valueOf(l)))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        if (i == 0)
        {
          this.vVt.remove(Long.valueOf(l));
          if (localg.vTP != null)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[] { Long.valueOf(l), localg.vTP });
            this.vVu.put(Long.valueOf(l), localg.vTP);
            this.vVv.put(localg.vTP, Integer.valueOf(localg.FileSize));
          }
        }
        else
        {
          this.vVt.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
    }
    if (this.vVt.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "all image is in server");
      if (this.vVp != null) {
        this.vVp.a(new ArrayList(), this.vVu);
      }
      AppMethodBeat.o(122790);
      return;
    }
    if (this.vVw < 3)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
      params = new s(j(this.vVt));
      com.tencent.mm.kernel.g.agQ().ghe.a(params, 0);
      AppMethodBeat.o(122790);
      return;
    }
    this.vVp.a(j(this.vVt), this.vVu);
    AppMethodBeat.o(122790);
  }
  
  private void a(ArrayList<Long> paramArrayList, b paramb)
  {
    AppMethodBeat.i(122788);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
    this.vVw = 0;
    ar(paramArrayList);
    if (this.vVu != null)
    {
      this.vVu.clear();
      this.vVu = null;
    }
    this.vVu = new HashMap();
    this.vVp = paramb;
    paramArrayList = new s(paramArrayList);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramArrayList, 0);
    AppMethodBeat.o(122788);
  }
  
  private void ar(ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(122787);
    if (this.vVt != null)
    {
      this.vVt.clear();
      this.vVt = null;
    }
    this.vVt = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      long l = ((Long)paramArrayList.next()).longValue();
      this.vVt.put(Long.valueOf(l), Integer.valueOf(1));
    }
    AppMethodBeat.o(122787);
  }
  
  private static ArrayList<Long> j(HashMap<Long, Integer> paramHashMap)
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
  
  public final void LL(final int paramInt)
  {
    AppMethodBeat.i(122782);
    if (this.vVs != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(122770);
          ac.this.vVs.ap(ac.this.vTY, paramInt, this.hIC);
          AppMethodBeat.o(122770);
        }
      });
    }
    AppMethodBeat.o(122782);
  }
  
  public final void a(f paramf, e parame)
  {
    AppMethodBeat.i(122784);
    this.vVs = paramf;
    this.vVj = parame;
    if (this.vVm.size() > 0)
    {
      paramf = new ArrayList();
      parame = this.vVm.keySet().iterator();
      while (parame.hasNext())
      {
        String str = (String)parame.next();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", new Object[] { str });
        paramf.add(Long.valueOf(bs.getLong(str, 0L)));
      }
      a(paramf, new b()
      {
        public final void a(ArrayList<Long> paramAnonymousArrayList, HashMap<Long, String> paramAnonymousHashMap)
        {
          AppMethodBeat.i(122771);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", new Object[] { Integer.valueOf(paramAnonymousArrayList.size()), Integer.valueOf(paramAnonymousHashMap.size()) });
          Object localObject1;
          if (paramAnonymousArrayList.size() > 0)
          {
            localObject1 = ac.this;
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            while (paramAnonymousArrayList.hasNext())
            {
              Object localObject2 = (Long)paramAnonymousArrayList.next();
              localObject2 = (String)((ac)localObject1).vVm.get(String.valueOf(localObject2));
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", new Object[] { localObject2 });
              if (!bs.isNullOrNil((String)localObject2))
              {
                if (((ac)localObject1).vVx == null) {
                  ((ac)localObject1).vVx = new ArrayList();
                }
                ((ac)localObject1).vVx.add(new ac.g((String)localObject2, (String)localObject2));
              }
            }
          }
          if (paramAnonymousHashMap.size() > 0) {
            ac.a(ac.this, paramAnonymousHashMap);
          }
          ac.this.LL(10);
          paramAnonymousArrayList = ac.this;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", new Object[] { Integer.valueOf(paramAnonymousArrayList.vVx.size()) });
          if (paramAnonymousArrayList.vVx == null) {
            paramAnonymousArrayList.vVx = new ArrayList();
          }
          if (paramAnonymousArrayList.vVx.size() > 0)
          {
            paramAnonymousHashMap = new ac.3(paramAnonymousArrayList);
            localObject1 = new ac.4(paramAnonymousArrayList);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", new Object[] { Integer.valueOf(paramAnonymousArrayList.vVx.size()) });
            paramAnonymousArrayList.vVB = paramAnonymousHashMap;
            paramAnonymousArrayList.vVC = ((ac.d)localObject1);
            paramAnonymousArrayList.vVD = paramAnonymousArrayList.vVx.size();
            if ((paramAnonymousArrayList.vVx != null) && (paramAnonymousArrayList.vVx.size() > 0))
            {
              paramAnonymousHashMap = (ac.g)paramAnonymousArrayList.vVx.remove(0);
              paramAnonymousArrayList.vVy = paramAnonymousHashMap.fileId;
              paramAnonymousArrayList.vVz = paramAnonymousHashMap.fileName;
              paramAnonymousArrayList.vVA = new HashMap();
              paramAnonymousArrayList = new v(paramAnonymousArrayList.vVz, paramAnonymousArrayList.vVy, paramAnonymousArrayList.vVE);
              com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousArrayList, 0);
            }
            AppMethodBeat.o(122771);
            return;
          }
          paramAnonymousArrayList.LL(90);
          paramAnonymousArrayList.drL();
          AppMethodBeat.o(122771);
        }
      });
      AppMethodBeat.o(122784);
      return;
    }
    LL(90);
    drL();
    AppMethodBeat.o(122784);
  }
  
  public final void av(Map<String, String> paramMap)
  {
    AppMethodBeat.i(122779);
    this.vVm = new HashMap();
    this.vVm.putAll(paramMap);
    AppMethodBeat.o(122779);
  }
  
  public final void aw(Map<String, String> paramMap)
  {
    AppMethodBeat.i(122780);
    this.vVn = new LinkedHashMap();
    this.vVn.putAll(paramMap);
    AppMethodBeat.o(122780);
  }
  
  public final void ax(Map<String, String> paramMap)
  {
    AppMethodBeat.i(122781);
    this.vVo = new LinkedHashMap();
    this.vVo.putAll(paramMap);
    AppMethodBeat.o(122781);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(122783);
    this.vVu.clear();
    this.vUB = null;
    this.vVw = 0;
    this.vVy = null;
    this.vVz = null;
    this.vVA.clear();
    this.vVx.clear();
    this.dng = null;
    this.vVt.clear();
    this.vVm.clear();
    this.vVl = null;
    this.vTY = null;
    this.vVD = 0;
    this.vUz = null;
    this.vVn.clear();
    this.vVr.clear();
    this.vVv.clear();
    this.vVs = null;
    this.vVj = null;
    AppMethodBeat.o(122783);
  }
  
  final void drL()
  {
    AppMethodBeat.i(122785);
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    Object localObject3;
    Object localObject4;
    if ((this.vVn != null) && (this.vVn.size() > 0))
    {
      localObject1 = new r.a[this.vVn.size()];
      localObject2 = this.vVn.keySet().iterator();
      i = 0;
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new r.a();
        ((r.a)localObject4).vUF = ((String)this.vVn.get(localObject3));
        ((r.a)localObject4).fileName = ((String)localObject3);
        ((r.a)localObject4).name = ((String)this.vVo.get(localObject3));
        ((r.a)localObject4).fileSize = ((int)i.aSp((String)localObject3));
        localObject1[j] = localObject4;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", new Object[] { Integer.valueOf(j), ((r.a)localObject4).vUF, ((r.a)localObject4).fileName, ((r.a)localObject4).name, Integer.valueOf(((r.a)localObject4).fileSize) });
        i = ((r.a)localObject4).fileSize + i;
        j += 1;
      }
    }
    for (;;)
    {
      Object localObject5;
      if ((this.vVr != null) && (this.vVr.size() > 0))
      {
        localObject2 = new r.a[this.vVr.size()];
        localObject3 = this.vVr.keySet().iterator();
        j = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = new r.a();
          ((r.a)localObject5).vUF = ((String)this.vVr.get(localObject4));
          ((r.a)localObject5).fileName = ((String)localObject4);
          ((r.a)localObject5).fileSize = bs.a((Integer)this.vVv.get(((r.a)localObject5).vUF), 0);
          if (((r.a)localObject5).fileSize == 0) {
            ((r.a)localObject5).fileSize = ((int)i.aSp((String)localObject4));
          }
          localObject2[j] = localObject5;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", new Object[] { Integer.valueOf(j), ((r.a)localObject5).vUF, ((r.a)localObject5).fileName, Integer.valueOf(((r.a)localObject5).fileSize) });
          i = ((r.a)localObject5).fileSize + i;
          j += 1;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", new Object[] { Integer.valueOf(i) });
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
            public final void drN()
            {
              AppMethodBeat.i(122774);
              ac.this.LL(100);
              AppMethodBeat.o(122774);
            }
          };
          localObject4 = new r(this.dng, this.vUz, this.vUA, this.vUB, this.vTY);
          ((r)localObject4).vUC = this.vVl;
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label1622;
          }
          ((r)localObject4).vUE = new r.a[localObject1.length];
          j = 0;
          while (j < ((r)localObject4).vUE.length)
          {
            ((r)localObject4).vUE[j] = localObject1[j];
            j += 1;
          }
          break;
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", new Object[] { Integer.valueOf(((r)localObject4).vUE.length) });
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          ((r)localObject4).vUD = ((r.a[])localObject2);
          label637:
          localObject2 = new StringBuilder("");
          localObject5 = new StringBuilder("");
          if (((r)localObject4).dng == null) {
            break label1640;
          }
          localObject1 = new StringBuilder("");
          ((StringBuilder)localObject1).append("From: ");
          ((StringBuilder)localObject1).append("\"");
          ((StringBuilder)localObject1).append("=?utf-8?B?");
          ((StringBuilder)localObject1).append(Base64.encodeToString(((r)localObject4).dng.getBytes(), 2));
          ((StringBuilder)localObject1).append("?=");
          ((StringBuilder)localObject1).append("\"");
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append("<");
          ((StringBuilder)localObject1).append(((r)localObject4).dng);
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
          localObject1 = ((r)localObject4).drF();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((r)localObject4).drG();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          localObject1 = ((r)localObject4).drH();
          if (localObject1 != null)
          {
            ((StringBuilder)localObject5).append((String)localObject1);
            ((StringBuilder)localObject5).append("\n");
          }
          ((StringBuilder)localObject5).append("Subject: ");
          if (((r)localObject4).vTY != null) {
            ((StringBuilder)localObject5).append(((r)localObject4).vTY);
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
          ((StringBuilder)localObject1).append(Base64.encodeToString(((r)localObject4).vUC.getBytes(), 0));
          ((StringBuilder)localObject1).append("\n");
          ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
          ((StringBuilder)localObject2).append("\r\n");
          if ((((r)localObject4).vUD == null) || (((r)localObject4).vUD.length <= 0)) {
            break label1646;
          }
          localObject1 = ((r)localObject4).vUD;
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            StringBuilder localStringBuilder = localObject1[j];
            localObject5 = localStringBuilder.vUF;
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
            localStringBuilder.append(String.format("QQMail-Key:%s", new Object[] { r.apW((String)localObject5) }));
            localStringBuilder.append("\n");
            localStringBuilder.append("QQMail-LinkEnd");
            localStringBuilder.append("\n");
            ((StringBuilder)localObject2).append(localStringBuilder.toString());
            ((StringBuilder)localObject2).append("\r\n");
            j += 1;
          }
          ((r)localObject4).vUE = null;
          break;
          ((r)localObject4).vUD = null;
          break label637;
        }
        label1646:
        ((StringBuilder)localObject2).append("\r\n");
        if ((((r)localObject4).vUE != null) && (((r)localObject4).vUE.length > 0))
        {
          localObject1 = ((r)localObject4).vUE;
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            localObject5 = localObject1[j];
            localObject4 = ((r.a)localObject5).vUF;
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
            ((StringBuilder)localObject6).append(String.format("QQMail-Key:%s", new Object[] { r.apW((String)localObject4) }));
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject6).append("QQMail-LinkEnd");
            ((StringBuilder)localObject6).append("\n");
            ((StringBuilder)localObject2).append(((StringBuilder)localObject6).toString());
            ((StringBuilder)localObject2).append("\r\n");
            j += 1;
          }
        }
        ((StringBuilder)localObject2).append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        localObject1 = new t(((StringBuilder)localObject2).toString(), this.dng, this.vUz, i, new h()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
          {
            AppMethodBeat.i(122777);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if (paramAnonymousInt1 >= paramAnonymousInt2)
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "finish send");
              if (this.vVG != null) {
                this.vVG.drN();
              }
            }
            AppMethodBeat.o(122777);
          }
        });
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject1, 0);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramn.getType() == 483)
      {
        a((s)paramn);
        AppMethodBeat.o(122786);
        return;
      }
      if (this.vVj != null) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122775);
            ac.this.vVj.apZ(ac.this.vTY);
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
    public abstract void drN();
  }
  
  public static abstract interface b
  {
    public abstract void a(ArrayList<Long> paramArrayList, HashMap<Long, String> paramHashMap);
  }
  
  public static abstract interface c
  {
    public abstract void drM();
  }
  
  public static abstract interface d
  {
    public abstract void h(int paramInt1, int paramInt2, String paramString1, String paramString2);
  }
  
  public static abstract interface e
  {
    public abstract void apZ(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void ap(String paramString, int paramInt1, int paramInt2);
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