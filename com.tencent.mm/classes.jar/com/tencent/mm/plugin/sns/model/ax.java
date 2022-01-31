package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.btj;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bty;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.dm;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ax
{
  private static final Pattern ftw = Pattern.compile("(\n){3,}");
  public int avS;
  public avn bZX;
  private String diG;
  int ona;
  int onb;
  n ouA = new n();
  bto ouB = null;
  av ouC;
  public bvz ouD;
  public ckw ouE;
  private boolean ouF;
  List<h> ous;
  String ouu;
  String ouv;
  LinkedList<buw> ouw;
  LinkedList<Long> oux;
  public bxk ouy = com.tencent.mm.modelsns.e.QZ();
  public awe ouz = new awe();
  
  public ax(int paramInt)
  {
    Object localObject = new av();
    ((av)localObject).sug = new at();
    ((av)localObject).sui = new da();
    ((av)localObject).suj = new dm();
    this.ouC = ((av)localObject);
    this.ouD = new bvz();
    this.bZX = new avn();
    this.ouE = null;
    this.diG = "";
    this.ouF = false;
    this.diG = af.bDl();
    this.avS = paramInt;
    this.ouy.tNr.sPI = paramInt;
    y.d("MicroMsg.UploadPackHelper", "contentType " + paramInt);
    this.ouy.trR = 0;
    this.ouy.hPY = this.diG;
    this.ouz.nde = com.tencent.mm.a.g.o((af.bDl() + bk.UZ() + System.currentTimeMillis()).getBytes());
    this.ouz.tsl = 0;
    this.ouz.tsm = 0;
    this.ouz.trR = 0;
    this.ouz.tsp = 0;
    this.ouz.ebp = 0;
    this.ouz.tsr = 0;
    this.ouz.tst = 0;
    localObject = new bto();
    ((bto)localObject).sGd = 0L;
    ((bto)localObject).mPL = 0;
    ((bto)localObject).tJV = 0;
    ((bto)localObject).sxM = af.bDl();
    ((bto)localObject).tJY = new LinkedList();
    ((bto)localObject).tJW = 0;
    ((bto)localObject).tJX = 0;
    ((bto)localObject).tKe = new LinkedList();
    ((bto)localObject).tKc = 0;
    ((bto)localObject).tKd = 0;
    ((bto)localObject).tKb = new LinkedList();
    ((bto)localObject).tJZ = 0;
    ((bto)localObject).tKa = 0;
    ((bto)localObject).ttI = 1;
    ((bto)localObject).tJV = 0;
    ((bto)localObject).tKf = 0;
    ((bto)localObject).tJU = new bmk().bs(new byte[0]);
    this.ouB = ((bto)localObject);
    localObject = this.ouA;
    ((n)localObject).field_localFlag |= 0x10;
    this.ouA.iB((int)(System.currentTimeMillis() / 1000L));
    this.ouA.field_type = paramInt;
    this.ouA.field_userName = this.diG;
    this.ouA.field_pravited = 0;
    this.ouA.field_stringSeq = "0000099999999999999999999";
    this.ouA.yp(2);
    this.ouA.bGB();
    if ((paramInt == 1) || (paramInt == 2)) {
      this.ouA.yp(4);
    }
    if (paramInt == 7) {
      this.ouA.ys(2);
    }
    this.oux = new LinkedList();
    this.ouz.tss = this.oux;
    localObject = this.oux.iterator();
    while (((Iterator)localObject).hasNext())
    {
      long l = ((Long)((Iterator)localObject).next()).longValue();
      btj localbtj = new btj();
      localbtj.tJS = l;
      this.ouB.swl.add(localbtj);
    }
    this.ouB.tuG = this.oux.size();
  }
  
  private static String NQ(String paramString)
  {
    if (paramString == null) {}
    label45:
    String str2;
    for (String str1 = "";; str2 = paramString)
    {
      paramString = str1;
      try
      {
        str1 = str1.trim();
        paramString = str1;
        str1 = str1.replace("\r\n", "\n");
        paramString = str1;
        str1 = ftw.matcher(str1).replaceAll("\n\n");
        return str1;
      }
      catch (Exception localException)
      {
        break label45;
      }
      y.e("MicroMsg.UploadPackHelper", "filter desc error ");
      return paramString;
    }
  }
  
  public static void Ob(String paramString)
  {
    com.tencent.mm.vfs.e.nb(com.tencent.mm.vfs.e.aeS(paramString));
  }
  
  public static awd Z(String paramString1, String paramString2, String paramString3)
  {
    awd localawd = com.tencent.mm.modelsns.e.Ra();
    localawd.lsK = paramString1;
    y.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localawd.hQR = 2;
    localawd.kSC = paramString2;
    localawd.trO = 0;
    localawd.trP = paramString3;
    localawd.trQ = 0;
    localawd.trV = 1;
    return localawd;
  }
  
  public static awd c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    awd localawd = com.tencent.mm.modelsns.e.Ra();
    localawd.lsK = paramString1;
    y.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { Integer.valueOf(6), paramString2, paramString4, paramString5, paramString6 });
    localawd.hQR = 6;
    if (com.tencent.mm.vfs.e.aeQ(paramString2) <= 0L) {
      return null;
    }
    paramString1 = new h(paramString2, 6);
    paramString1.onf = paramString4;
    paramString2 = af.bDu().a(paramString1, paramString2, paramString3, paramString5, paramString6);
    if ((paramString2.height > 0) && (paramString2.width > 0) && (paramString2.fileSize > 0))
    {
      paramString1 = new awf();
      paramString1.tsG = paramString2.height;
      paramString1.tsF = paramString2.width;
      paramString1.tsH = paramString2.fileSize;
    }
    for (;;)
    {
      localawd.lsK = ("Locall_path" + paramString2.onc);
      localawd.trS = paramString1;
      localawd.onc = paramString2.onc;
      return localawd;
      paramString1 = null;
    }
  }
  
  private static awd eN(String paramString1, String paramString2)
  {
    Object localObject = null;
    awd localawd = com.tencent.mm.modelsns.e.Ra();
    localawd.lsK = paramString1;
    y.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localawd.hQR = 2;
    if (com.tencent.mm.vfs.e.aeQ(paramString2) <= 0L) {}
    do
    {
      return null;
      paramString1 = af.getAccSnsTmpPath() + com.tencent.mm.a.g.o(new StringBuilder().append(paramString2).append(System.currentTimeMillis()).toString().getBytes());
      com.tencent.mm.vfs.e.r(paramString2, paramString1);
      paramString1 = new h(paramString1, 2);
      paramString2 = new LinkedList();
      paramString2.add(paramString1);
      paramString1 = af.bDu().cC(paramString2);
    } while ((paramString1 == null) || (paramString1.size() == 0));
    paramString2 = (h)paramString1.get(0);
    paramString1 = localObject;
    if (paramString2.height > 0)
    {
      paramString1 = localObject;
      if (paramString2.width > 0)
      {
        paramString1 = localObject;
        if (paramString2.fileSize > 0)
        {
          paramString1 = new awf();
          paramString1.tsG = paramString2.height;
          paramString1.tsF = paramString2.width;
          paramString1.tsH = paramString2.fileSize;
        }
      }
    }
    localawd.lsK = ("Locall_path" + paramString2.onc);
    localawd.trS = paramString1;
    localawd.onc = paramString2.onc;
    return localawd;
  }
  
  private static awd s(String paramString, byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte))
    {
      y.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.zI() + " attachBuf is null");
      return null;
    }
    String str = af.getAccSnsTmpPath() + com.tencent.mm.a.g.o(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
    com.tencent.mm.vfs.e.nb(af.getAccSnsTmpPath());
    y.d("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.zI() + " buildUploadAttachInfo file:" + str);
    if (com.tencent.mm.vfs.e.b(str, paramArrayOfByte, paramArrayOfByte.length) < 0)
    {
      y.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.zI() + " writeFile error file:" + str);
      return null;
    }
    return eN(paramString, str);
  }
  
  public final ax NR(String paramString)
  {
    this.ouu = NQ(paramString);
    this.ouy.tNo = this.ouu;
    return this;
  }
  
  public final ax NS(String paramString)
  {
    this.ouy.tNv = paramString;
    this.ouC.sug.sua = paramString;
    return this;
  }
  
  public final ax NT(String paramString)
  {
    this.ouy.pjl = paramString;
    return this;
  }
  
  public final ax NU(String paramString)
  {
    this.ouv = paramString;
    this.ouy.tNr.kRN = paramString;
    return this;
  }
  
  public final ax NV(String paramString)
  {
    this.ouy.tNr.kSC = paramString;
    return this;
  }
  
  public final ax NW(String paramString)
  {
    this.ouy.tNr.bGw = paramString;
    return this;
  }
  
  public final ax NX(String paramString)
  {
    dk localdk2 = this.ouy.tNq;
    dk localdk1 = localdk2;
    if (localdk2 == null) {
      localdk1 = new dk();
    }
    localdk1.lsK = paramString;
    this.ouy.tNq = localdk1;
    return this;
  }
  
  public final ax NY(String paramString)
  {
    dk localdk2 = this.ouy.tNq;
    dk localdk1 = localdk2;
    if (localdk2 == null) {
      localdk1 = new dk();
    }
    localdk1.kVn = paramString;
    this.ouy.tNq = localdk1;
    return this;
  }
  
  public final ax NZ(String paramString)
  {
    this.ouy.sbK = bk.pm(paramString);
    return this;
  }
  
  public final ax Oa(String paramString)
  {
    this.ouy.sbL = bk.pm(paramString);
    return this;
  }
  
  public final ax Y(String paramString1, String paramString2, String paramString3)
  {
    at localat = this.ouC.sug;
    Object localObject = paramString1;
    if (bk.bl(paramString1)) {
      localObject = "";
    }
    localat.euK = ((String)localObject);
    localObject = this.ouC.sug;
    paramString1 = paramString2;
    if (bk.bl(paramString2)) {
      paramString1 = "";
    }
    ((at)localObject).sub = paramString1;
    paramString2 = this.ouC.sug;
    paramString1 = paramString3;
    if (bk.bl(paramString3)) {
      paramString1 = "";
    }
    paramString2.suc = paramString1;
    return this;
  }
  
  public final ax a(aui paramaui)
  {
    if (paramaui == null) {
      return this;
    }
    this.ouy.tNp = paramaui;
    return this;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    paramArrayOfByte = s("", paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
      return false;
    }
    paramArrayOfByte.kRN = paramString1;
    if (paramInt > 0) {
      paramArrayOfByte.brC = paramInt;
    }
    if (!bk.bl(paramString3)) {
      paramArrayOfByte.oOw = paramString3;
    }
    if (!bk.bl(paramString2)) {
      paramArrayOfByte.bGw = paramString2;
    }
    if (!bk.bl(paramString1)) {
      paramArrayOfByte.kRN = paramString1;
    }
    this.ouy.tNr.sPJ.add(paramArrayOfByte);
    paramString1 = new auf();
    paramString1.tpH = paramArrayOfByte.onc;
    this.ouz.tsn.add(paramString1);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    paramArrayOfByte = s("", paramArrayOfByte);
    if ((paramArrayOfByte == null) || ((bk.bl(paramString2)) && (bk.bl(paramString3))))
    {
      y.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
      return false;
    }
    if (!bk.bl(paramString1)) {
      this.ouy.tNr.kSC = paramString1;
    }
    if (!bk.bl(paramString3))
    {
      paramArrayOfByte.kSC = paramString3;
      paramArrayOfByte.trO = 0;
    }
    for (;;)
    {
      if (!bk.bl(paramString2))
      {
        paramArrayOfByte.trT = paramString2;
        paramArrayOfByte.trU = 0;
      }
      paramArrayOfByte.hQR = paramInt;
      paramArrayOfByte.bGw = bk.aM(paramString4, "");
      paramArrayOfByte.kRN = bk.aM(paramString5, "");
      this.ouy.tNr.sPJ.add(paramArrayOfByte);
      paramString1 = new auf();
      paramString1.tpH = paramArrayOfByte.onc;
      this.ouz.tsn.add(paramString1);
      return true;
      if (!bk.bl(paramString2))
      {
        paramArrayOfByte.kSC = paramString2;
        paramArrayOfByte.trO = 0;
      }
    }
  }
  
  public final ax am(LinkedList<buw> paramLinkedList)
  {
    this.ouw = paramLinkedList;
    this.ouz.tso = paramLinkedList;
    paramLinkedList = this.ouw.iterator();
    while (paramLinkedList.hasNext())
    {
      buw localbuw = (buw)paramLinkedList.next();
      btd localbtd = new btd();
      localbtd.sxM = localbuw.hPY;
      this.ouB.tKe.add(localbtd);
    }
    this.ouB.tKc = this.ouw.size();
    this.ouB.tKd = this.ouw.size();
    return this;
  }
  
  @Deprecated
  public final boolean b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = Z("", paramString1, paramString2);
    if (paramString1 == null)
    {
      y.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      return false;
    }
    paramString1.kRN = paramString3;
    if (paramInt > 0) {
      paramString1.brC = paramInt;
    }
    if (!bk.bl(paramString4)) {
      paramString1.oOw = paramString4;
    }
    this.ouy.tNr.sPJ.add(paramString1);
    return true;
  }
  
  public final boolean b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    return a(paramArrayOfByte, paramString1, paramString2, -1, "");
  }
  
  public final int commit()
  {
    long l = System.currentTimeMillis();
    try
    {
      this.ouz.tsq = System.currentTimeMillis();
      this.ouz.ebp = 0;
      this.ouA.aL(this.ouB.toByteArray());
      this.ouA.field_postBuf = this.ouz.toByteArray();
      y.d("MicroMsg.UploadPackHelper", "snsObj " + this.ouB.toString());
      y.d("MicroMsg.UploadPackHelper", "postinfo " + this.ouz.toString());
      y.d("MicroMsg.UploadPackHelper", "timelineObj " + this.ouy.toString());
      if (this.ouy.tNr.sPJ != null)
      {
        y.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", new Object[] { Integer.valueOf(this.ouy.tNr.sPJ.size()) });
        i = 0;
        while (i < this.ouy.tNr.sPJ.size())
        {
          awd localawd = (awd)this.ouy.tNr.sPJ.get(i);
          if (localawd != null) {
            y.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", new Object[] { Integer.valueOf(localawd.onc), bk.aM(localawd.kSC, "") });
          }
          i += 1;
        }
      }
    }
    catch (Exception localException1)
    {
      int i;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.UploadPackHelper", localException1, "", new Object[0]);
      }
      if (this.ouC != null) {
        this.ouy.ouC = this.ouC;
      }
      if (this.ouE != null) {
        this.ouy.ouE = this.ouE;
      }
      this.ouA.c(this.ouy);
      int k = af.bDF().B(this.ouA);
      Iterator localIterator = this.ouz.tsn.iterator();
      int j = 0;
      Object localObject1 = null;
      if (localIterator.hasNext())
      {
        Object localObject2 = (auf)localIterator.next();
        r localr = af.bDu().gu(((auf)localObject2).tpH);
        for (;;)
        {
          try
          {
            awg localawg = (awg)new awg().aH(localr.oLV);
            if (this.ouy.tNq != null) {
              localawg.bOL = this.ouy.tNq.lsK;
            }
            if (this.bZX != null) {
              this.bZX.trb = 0;
            }
            localawg.tsP = this.bZX;
            localawg.avS = this.ouy.tNr.sPI;
            if ((localawg.avS == 1) || (localawg.avS == 15))
            {
              if (!bk.bl(localawg.bOL))
              {
                i = 5;
                localawg.tsQ = i;
              }
            }
            else
            {
              localr.oLV = localawg.toByteArray();
              af.bDu().a(((auf)localObject2).tpH, localr);
              localObject2 = localawg.bIW;
              j += 1;
              localObject1 = localObject2;
              break;
            }
            if ((localawg.tsP == null) || (localawg.avS != 15)) {
              break label616;
            }
            if (localawg.tsP.tra)
            {
              i = 1;
              localawg.tsQ = i;
              continue;
            }
          }
          catch (Exception localException2)
          {
            y.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
          }
          i = 2;
          continue;
          label616:
          boolean bool = ((h)this.ous.get(j)).ong;
          if (bool) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
      y.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.ouA.field_type), localObject1 });
      if ((k > 0) && (this.ouA.field_type == 15)) {
        aq.eL(v.ak("sns_table_", k), localObject1);
      }
      y.d("MicroMsg.UploadPackHelper", "pack commit result " + k + " cost " + (System.currentTimeMillis() - l));
      return k;
    }
  }
  
  public final ax cx(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.ouB.ttI = 1;
    }
    LinkedList localLinkedList;
    do
    {
      return this;
      paramList = paramList.iterator();
      localLinkedList = new LinkedList();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        bml localbml = new bml();
        localbml.YI(str);
        localLinkedList.add(localbml);
      }
      this.ouz.tsx = localLinkedList;
      if (this.ouB.ttI == 3)
      {
        this.ouB.tKj = localLinkedList;
        this.ouB.tKi = localLinkedList.size();
        return this;
      }
    } while (this.ouB.ttI != 5);
    this.ouB.tsx = localLinkedList;
    this.ouB.tKk = localLinkedList.size();
    return this;
  }
  
  public final void cy(List<h> paramList)
  {
    this.ous = paramList;
    paramList = af.bDu().cC(this.ous);
    Object localObject1 = new LinkedList();
    if (paramList == null) {}
    for (;;)
    {
      return;
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        h localh = (h)((Iterator)localObject2).next();
        auf localauf = new auf();
        localauf.tpH = localh.onc;
        ((LinkedList)localObject1).add(localauf);
      }
      this.ouz.tsn = ((LinkedList)localObject1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (h)paramList.next();
        localObject2 = new awf();
        ((awf)localObject2).tsG = 0.0F;
        ((awf)localObject2).tsF = 0.0F;
        ((awf)localObject2).tsH = 0.0F;
        if ((((h)localObject1).height > 0) && (((h)localObject1).width > 0) && (((h)localObject1).fileSize > 0))
        {
          ((awf)localObject2).tsG = ((h)localObject1).height;
          ((awf)localObject2).tsF = ((h)localObject1).width;
          ((awf)localObject2).tsH = ((h)localObject1).fileSize;
        }
        localObject1 = com.tencent.mm.modelsns.e.a("Locall_path" + ((h)localObject1).onc, ((h)localObject1).type, "", "", 0, 0, this.onb, "", (awf)localObject2);
        this.ouy.tNr.sPJ.add(localObject1);
      }
    }
  }
  
  public final ax eM(String paramString1, String paramString2)
  {
    this.ouz.token = paramString1;
    this.ouz.tsv = paramString2;
    return this;
  }
  
  public final boolean eO(String paramString1, String paramString2)
  {
    String str = af.getAccSnsTmpPath() + com.tencent.mm.a.g.o(paramString1.getBytes());
    Ob(str);
    com.tencent.mm.vfs.e.r(paramString1, str);
    paramString1 = eN("", str);
    if (paramString1 == null)
    {
      y.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      return false;
    }
    paramString1.kRN = paramString2;
    if (bk.bl(paramString1.bGw)) {
      paramString1.bGw = paramString2;
    }
    this.ouy.tNr.sPJ.add(paramString1);
    paramString2 = new auf();
    paramString2.tpH = paramString1.onc;
    this.ouz.tsn.add(paramString2);
    return true;
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    bty localbty = new bty();
    localbty.swU = paramString1;
    localbty.swV = paramString2;
    localbty.swW = paramString3;
    localbty.oTt = paramInt1;
    localbty.oTu = paramInt2;
    this.ouz.tsy = localbty;
  }
  
  public final boolean q(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = af.getAccSnsTmpPath() + com.tencent.mm.a.g.o(paramString1.getBytes());
    Ob(str);
    com.tencent.mm.vfs.e.r(paramString1, str);
    paramString1 = af.getAccSnsTmpPath() + com.tencent.mm.a.g.o(paramString2.getBytes());
    com.tencent.mm.vfs.e.r(paramString2, paramString1);
    paramString1 = c("", str, paramString1, paramString4, "", "");
    if (paramString1 == null)
    {
      y.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      return false;
    }
    paramString1.kRN = paramString3;
    if (bk.bl(paramString1.bGw)) {
      paramString1.bGw = paramString3;
    }
    this.ouy.tNr.sPJ.add(paramString1);
    paramString2 = new auf();
    paramString2.tpH = paramString1.onc;
    this.ouz.tsn.add(paramString2);
    return true;
  }
  
  public final void setSessionId(String paramString)
  {
    this.ouz.bIB = paramString;
  }
  
  public final ax xS(int paramInt)
  {
    this.ouy.tNt = 1;
    this.ouy.tNu = paramInt;
    return this;
  }
  
  public final void xT(int paramInt)
  {
    y.d("MicroMsg.UploadPackHelper", "set post form " + paramInt);
    this.ouz.tsr = paramInt;
  }
  
  public final ax xU(int paramInt)
  {
    this.onb = paramInt;
    this.ouz.trR = paramInt;
    this.ouy.trR = paramInt;
    if (paramInt > 0)
    {
      this.ouA.field_pravited = paramInt;
      this.ouA.bGy();
      this.ouA.ys(2);
      this.ouA.bGC();
    }
    return this;
  }
  
  public final ax xV(int paramInt)
  {
    this.ona = paramInt;
    this.ouz.tsm = paramInt;
    return this;
  }
  
  public final ax xW(int paramInt)
  {
    this.ouz.tst = paramInt;
    return this;
  }
  
  public final ax xX(int paramInt)
  {
    if (paramInt == 1) {
      this.ouB.ttI = 3;
    }
    for (;;)
    {
      this.ouz.tsw = paramInt;
      return this;
      if (paramInt == 0) {
        this.ouB.ttI = 5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax
 * JD-Core Version:    0.7.0.1
 */