package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ay
{
  private static final Pattern gKY;
  public int ayi;
  public bby cIu;
  private String dZZ;
  int rbq;
  int rbr;
  List<h> rjm;
  String rjn;
  String rjo;
  LinkedList<cfm> rjp;
  LinkedList<Long> rjq;
  public TimeLineObject rjr;
  public bct rjs;
  n rjt;
  SnsObject rju;
  av rjv;
  public cih rjw;
  public cyl rjx;
  private boolean rjy;
  
  static
  {
    AppMethodBeat.i(36740);
    gKY = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(36740);
  }
  
  public ay(int paramInt)
  {
    AppMethodBeat.i(36714);
    this.rjr = com.tencent.mm.modelsns.e.akg();
    this.rjs = new bct();
    this.rjt = new n();
    this.rju = null;
    Object localObject = new av();
    ((av)localObject).wmJ = new at();
    ((av)localObject).wmL = new dj();
    ((av)localObject).wmM = new dw();
    this.rjv = ((av)localObject);
    this.rjw = new cih();
    this.cIu = new bby();
    this.rjx = null;
    this.dZZ = "";
    this.rjy = false;
    this.dZZ = ag.coK();
    this.ayi = paramInt;
    this.rjr.xTS.wNZ = paramInt;
    ab.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(paramInt)));
    this.rjr.xrU = 0;
    this.rjr.jJA = this.dZZ;
    this.rjs.pIw = com.tencent.mm.a.g.w((ag.coK() + bo.yB() + System.currentTimeMillis()).getBytes());
    this.rjs.xso = 0;
    this.rjs.xsp = 0;
    this.rjs.xrU = 0;
    this.rjs.xss = 0;
    this.rjs.ePG = 0;
    this.rjs.xsu = 0;
    this.rjs.xsw = 0;
    localObject = new SnsObject();
    ((SnsObject)localObject).Id = 0L;
    ((SnsObject)localObject).CreateTime = 0;
    ((SnsObject)localObject).LikeFlag = 0;
    ((SnsObject)localObject).Username = ag.coK();
    ((SnsObject)localObject).LikeUserList = new LinkedList();
    ((SnsObject)localObject).LikeCount = 0;
    ((SnsObject)localObject).LikeUserListCount = 0;
    ((SnsObject)localObject).WithUserList = new LinkedList();
    ((SnsObject)localObject).WithUserCount = 0;
    ((SnsObject)localObject).WithUserListCount = 0;
    ((SnsObject)localObject).CommentUserList = new LinkedList();
    ((SnsObject)localObject).CommentCount = 0;
    ((SnsObject)localObject).CommentUserListCount = 0;
    ((SnsObject)localObject).ExtFlag = 1;
    ((SnsObject)localObject).LikeFlag = 0;
    ((SnsObject)localObject).NoChange = 0;
    ((SnsObject)localObject).ObjectDesc = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    this.rju = ((SnsObject)localObject);
    localObject = this.rjt;
    ((n)localObject).field_localFlag |= 0x10;
    this.rjt.lp((int)(System.currentTimeMillis() / 1000L));
    this.rjt.field_type = paramInt;
    this.rjt.field_userName = this.dZZ;
    this.rjt.field_pravited = 0;
    this.rjt.field_stringSeq = "0000099999999999999999999";
    this.rjt.Eu(2);
    this.rjt.csE();
    if ((paramInt == 1) || (paramInt == 2)) {
      this.rjt.Eu(4);
    }
    if (paramInt == 7) {
      this.rjt.Ey(2);
    }
    this.rjq = new LinkedList();
    this.rjs.xsv = this.rjq;
    localObject = this.rjq.iterator();
    while (((Iterator)localObject).hasNext())
    {
      long l = ((Long)((Iterator)localObject).next()).longValue();
      cdz localcdz = new cdz();
      localcdz.xOC = l;
      this.rju.GroupList.add(localcdz);
    }
    this.rju.GroupCount = this.rjq.size();
    AppMethodBeat.o(36714);
  }
  
  private static bcs A(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36726);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.Ml() + " attachBuf is null");
      AppMethodBeat.o(36726);
      return null;
    }
    String str = ag.getAccSnsTmpPath() + com.tencent.mm.a.g.w(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
    com.tencent.mm.vfs.e.um(ag.getAccSnsTmpPath());
    ab.d("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.Ml() + " buildUploadAttachInfo file:" + str);
    if (com.tencent.mm.vfs.e.b(str, paramArrayOfByte, paramArrayOfByte.length) < 0)
    {
      ab.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.Ml() + " writeFile error file:" + str);
      AppMethodBeat.o(36726);
      return null;
    }
    paramString = gp(paramString, str);
    AppMethodBeat.o(36726);
    return paramString;
  }
  
  private static String aaK(String paramString)
  {
    AppMethodBeat.i(36715);
    if (paramString == null) {}
    label57:
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
        str1 = gKY.matcher(str1).replaceAll("\n\n");
        AppMethodBeat.o(36715);
        return str1;
      }
      catch (Exception localException)
      {
        break label57;
      }
      ab.e("MicroMsg.UploadPackHelper", "filter desc error ");
      AppMethodBeat.o(36715);
      return paramString;
    }
  }
  
  public static void aaV(String paramString)
  {
    AppMethodBeat.i(36731);
    com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(paramString));
    AppMethodBeat.o(36731);
  }
  
  public static bcs ak(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36729);
    bcs localbcs = com.tencent.mm.modelsns.e.akh();
    localbcs.Id = paramString1;
    ab.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbcs.jKs = 2;
    localbcs.Url = paramString2;
    localbcs.xrR = 0;
    localbcs.xrS = paramString3;
    localbcs.xrT = 0;
    localbcs.xrY = 1;
    AppMethodBeat.o(36729);
    return localbcs;
  }
  
  public static bcs c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(36727);
    bcs localbcs = com.tencent.mm.modelsns.e.akh();
    localbcs.Id = paramString1;
    ab.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { Integer.valueOf(6), paramString2, paramString4, paramString5, paramString6 });
    localbcs.jKs = 6;
    if (com.tencent.mm.vfs.e.avI(paramString2) <= 0L)
    {
      AppMethodBeat.o(36727);
      return null;
    }
    paramString1 = new h(paramString2, 6);
    paramString1.rbu = paramString4;
    paramString2 = ag.coU().a(paramString1, paramString2, paramString3, paramString5, paramString6);
    if ((paramString2.height > 0) && (paramString2.width > 0) && (paramString2.fileSize > 0))
    {
      paramString1 = new bcu();
      paramString1.xsI = paramString2.height;
      paramString1.xsH = paramString2.width;
      paramString1.xsJ = paramString2.fileSize;
    }
    for (;;)
    {
      localbcs.Id = ("Locall_path" + paramString2.cIp);
      localbcs.xrV = paramString1;
      localbcs.cIp = paramString2.cIp;
      AppMethodBeat.o(36727);
      return localbcs;
      paramString1 = null;
    }
  }
  
  private static bcs gp(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(36728);
    bcs localbcs = com.tencent.mm.modelsns.e.akh();
    localbcs.Id = paramString1;
    ab.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbcs.jKs = 2;
    if (com.tencent.mm.vfs.e.avI(paramString2) <= 0L)
    {
      AppMethodBeat.o(36728);
      return null;
    }
    paramString1 = ag.getAccSnsTmpPath() + com.tencent.mm.a.g.w(new StringBuilder().append(paramString2).append(System.currentTimeMillis()).toString().getBytes());
    com.tencent.mm.vfs.e.C(paramString2, paramString1);
    paramString1 = new h(paramString1, 2);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = ag.coU().di(paramString2);
    if ((paramString1 == null) || (paramString1.size() == 0))
    {
      AppMethodBeat.o(36728);
      return null;
    }
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
          paramString1 = new bcu();
          paramString1.xsI = paramString2.height;
          paramString1.xsH = paramString2.width;
          paramString1.xsJ = paramString2.fileSize;
        }
      }
    }
    localbcs.Id = ("Locall_path" + paramString2.cIp);
    localbcs.xrV = paramString1;
    localbcs.cIp = paramString2.cIp;
    AppMethodBeat.o(36728);
    return localbcs;
  }
  
  public final ay DS(int paramInt)
  {
    this.rjr.xTU = 1;
    this.rjr.xTV = paramInt;
    return this;
  }
  
  public final void DT(int paramInt)
  {
    AppMethodBeat.i(36718);
    ab.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(paramInt)));
    this.rjs.xsu = paramInt;
    AppMethodBeat.o(36718);
  }
  
  public final ay DU(int paramInt)
  {
    AppMethodBeat.i(36719);
    this.rbr = paramInt;
    this.rjs.xrU = paramInt;
    this.rjr.xrU = paramInt;
    if (paramInt > 0)
    {
      this.rjt.field_pravited = paramInt;
      this.rjt.csB();
      this.rjt.Ey(2);
      this.rjt.csF();
    }
    AppMethodBeat.o(36719);
    return this;
  }
  
  public final ay DV(int paramInt)
  {
    this.rbq = paramInt;
    this.rjs.xsp = paramInt;
    return this;
  }
  
  public final ay DW(int paramInt)
  {
    this.rjs.xsw = paramInt;
    return this;
  }
  
  public final ay DX(int paramInt)
  {
    if (paramInt == 1) {
      this.rju.ExtFlag = 3;
    }
    for (;;)
    {
      this.rjs.xsz = paramInt;
      return this;
      if (paramInt == 0) {
        this.rju.ExtFlag = 5;
      }
    }
  }
  
  public final ay a(bap parambap)
  {
    if (parambap == null) {
      return this;
    }
    this.rjr.xTQ = parambap;
    return this;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(36735);
    paramArrayOfByte = A("", paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
      AppMethodBeat.o(36735);
      return false;
    }
    paramArrayOfByte.Desc = paramString1;
    if (paramInt > 0) {
      paramArrayOfByte.subType = paramInt;
    }
    if (!bo.isNullOrNil(paramString3)) {
      paramArrayOfByte.rGh = paramString3;
    }
    if (!bo.isNullOrNil(paramString2)) {
      paramArrayOfByte.Title = paramString2;
    }
    if (!bo.isNullOrNil(paramString1)) {
      paramArrayOfByte.Desc = paramString1;
    }
    this.rjr.xTS.wOa.add(paramArrayOfByte);
    paramString1 = new bam();
    paramString1.xpE = paramArrayOfByte.cIp;
    this.rjs.xsq.add(paramString1);
    AppMethodBeat.o(36735);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(36736);
    paramArrayOfByte = A("", paramArrayOfByte);
    if ((paramArrayOfByte == null) || ((bo.isNullOrNil(paramString2)) && (bo.isNullOrNil(paramString3))))
    {
      ab.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
      AppMethodBeat.o(36736);
      return false;
    }
    if (!bo.isNullOrNil(paramString1)) {
      this.rjr.xTS.Url = paramString1;
    }
    if (!bo.isNullOrNil(paramString3))
    {
      paramArrayOfByte.Url = paramString3;
      paramArrayOfByte.xrR = 0;
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramString2))
      {
        paramArrayOfByte.xrW = paramString2;
        paramArrayOfByte.xrX = 0;
      }
      paramArrayOfByte.jKs = paramInt;
      paramArrayOfByte.Title = bo.bf(paramString4, "");
      paramArrayOfByte.Desc = bo.bf(paramString5, "");
      this.rjr.xTS.wOa.add(paramArrayOfByte);
      paramString1 = new bam();
      paramString1.xpE = paramArrayOfByte.cIp;
      this.rjs.xsq.add(paramString1);
      AppMethodBeat.o(36736);
      return true;
      if (!bo.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Url = paramString2;
        paramArrayOfByte.xrR = 0;
      }
    }
  }
  
  public final ay aaL(String paramString)
  {
    AppMethodBeat.i(36716);
    this.rjn = aaK(paramString);
    this.rjr.xTP = this.rjn;
    AppMethodBeat.o(36716);
    return this;
  }
  
  public final ay aaM(String paramString)
  {
    this.rjr.xTW = paramString;
    this.rjv.wmJ.wmD = paramString;
    return this;
  }
  
  public final ay aaN(String paramString)
  {
    this.rjr.sbN = paramString;
    return this;
  }
  
  public final ay aaO(String paramString)
  {
    this.rjo = paramString;
    this.rjr.xTS.Desc = paramString;
    return this;
  }
  
  public final ay aaP(String paramString)
  {
    this.rjr.xTS.Url = paramString;
    return this;
  }
  
  public final ay aaQ(String paramString)
  {
    this.rjr.xTS.Title = paramString;
    return this;
  }
  
  public final ay aaR(String paramString)
  {
    AppMethodBeat.i(36721);
    du localdu2 = this.rjr.xTR;
    du localdu1 = localdu2;
    if (localdu2 == null) {
      localdu1 = new du();
    }
    localdu1.Id = paramString;
    this.rjr.xTR = localdu1;
    AppMethodBeat.o(36721);
    return this;
  }
  
  public final ay aaS(String paramString)
  {
    AppMethodBeat.i(36722);
    du localdu2 = this.rjr.xTR;
    du localdu1 = localdu2;
    if (localdu2 == null) {
      localdu1 = new du();
    }
    localdu1.ntp = paramString;
    this.rjr.xTR = localdu1;
    AppMethodBeat.o(36722);
    return this;
  }
  
  public final ay aaT(String paramString)
  {
    AppMethodBeat.i(36723);
    this.rjr.inF = bo.nullAsNil(paramString);
    AppMethodBeat.o(36723);
    return this;
  }
  
  public final ay aaU(String paramString)
  {
    AppMethodBeat.i(36724);
    this.rjr.vSR = bo.nullAsNil(paramString);
    AppMethodBeat.o(36724);
    return this;
  }
  
  public final ay aj(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36717);
    at localat = this.rjv.wmJ;
    Object localObject = paramString1;
    if (bo.isNullOrNil(paramString1)) {
      localObject = "";
    }
    localat.fKw = ((String)localObject);
    localObject = this.rjv.wmJ;
    paramString1 = paramString2;
    if (bo.isNullOrNil(paramString2)) {
      paramString1 = "";
    }
    ((at)localObject).wmE = paramString1;
    paramString2 = this.rjv.wmJ;
    paramString1 = paramString3;
    if (bo.isNullOrNil(paramString3)) {
      paramString1 = "";
    }
    paramString2.wmF = paramString1;
    AppMethodBeat.o(36717);
    return this;
  }
  
  public final ay av(LinkedList<cfm> paramLinkedList)
  {
    AppMethodBeat.i(36720);
    this.rjp = paramLinkedList;
    this.rjs.xsr = paramLinkedList;
    paramLinkedList = this.rjp.iterator();
    while (paramLinkedList.hasNext())
    {
      cfm localcfm = (cfm)paramLinkedList.next();
      cds localcds = new cds();
      localcds.Username = localcfm.jJA;
      this.rju.WithUserList.add(localcds);
    }
    this.rju.WithUserCount = this.rjp.size();
    this.rju.WithUserListCount = this.rjp.size();
    AppMethodBeat.o(36720);
    return this;
  }
  
  @Deprecated
  public final boolean b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(36733);
    paramString1 = ak("", paramString1, paramString2);
    if (paramString1 == null)
    {
      ab.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(36733);
      return false;
    }
    paramString1.Desc = paramString3;
    if (paramInt > 0) {
      paramString1.subType = paramInt;
    }
    if (!bo.isNullOrNil(paramString4)) {
      paramString1.rGh = paramString4;
    }
    this.rjr.xTS.wOa.add(paramString1);
    AppMethodBeat.o(36733);
    return true;
  }
  
  public final boolean b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(36734);
    boolean bool = a(paramArrayOfByte, paramString1, paramString2, -1, "");
    AppMethodBeat.o(36734);
    return bool;
  }
  
  public final int commit()
  {
    AppMethodBeat.i(36739);
    long l = System.currentTimeMillis();
    try
    {
      this.rjs.xst = System.currentTimeMillis();
      this.rjs.ePG = 0;
      this.rjt.bj(this.rju.toByteArray());
      this.rjt.field_postBuf = this.rjs.toByteArray();
      ab.d("MicroMsg.UploadPackHelper", "snsObj " + this.rju.toString());
      ab.d("MicroMsg.UploadPackHelper", "postinfo " + this.rjs.toString());
      ab.d("MicroMsg.UploadPackHelper", "timelineObj " + this.rjr.toString());
      if (this.rjr.xTS.wOa != null)
      {
        ab.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", new Object[] { Integer.valueOf(this.rjr.xTS.wOa.size()) });
        i = 0;
        while (i < this.rjr.xTS.wOa.size())
        {
          bcs localbcs = (bcs)this.rjr.xTS.wOa.get(i);
          if (localbcs != null) {
            ab.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", new Object[] { Integer.valueOf(localbcs.cIp), bo.bf(localbcs.Url, "") });
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
        ab.printErrStackTrace("MicroMsg.UploadPackHelper", localException1, "", new Object[0]);
      }
      if (this.rjv != null) {
        this.rjr.rjv = this.rjv;
      }
      if (this.rjx != null) {
        this.rjr.rjx = this.rjx;
      }
      this.rjt.c(this.rjr);
      int k = ag.cpf().A(this.rjt);
      Iterator localIterator = this.rjs.xsq.iterator();
      int j = 0;
      Object localObject1 = null;
      if (localIterator.hasNext())
      {
        Object localObject2 = (bam)localIterator.next();
        r localr = ag.coU().ma(((bam)localObject2).xpE);
        for (;;)
        {
          try
          {
            bcv localbcv = (bcv)new bcv().parseFrom(localr.rDG);
            if (this.rjr.xTR != null) {
              localbcv.cwc = this.rjr.xTR.Id;
            }
            if (this.cIu != null) {
              this.cIu.xrb = 0;
            }
            localbcv.xsQ = this.cIu;
            localbcv.ayi = this.rjr.xTS.wNZ;
            if ((localbcv.ayi == 1) || (localbcv.ayi == 15))
            {
              if (!bo.isNullOrNil(localbcv.cwc))
              {
                i = 5;
                localbcv.xsR = i;
              }
            }
            else
            {
              localr.rDG = localbcv.toByteArray();
              ag.coU().a(((bam)localObject2).xpE, localr);
              localObject2 = localbcv.cqq;
              j += 1;
              localObject1 = localObject2;
              break;
            }
            if ((localbcv.xsQ == null) || (localbcv.ayi != 15)) {
              break label622;
            }
            if (localbcv.xsQ.xra)
            {
              i = 1;
              localbcv.xsR = i;
              continue;
            }
          }
          catch (Exception localException2)
          {
            ab.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
          }
          i = 2;
          continue;
          label622:
          boolean bool = ((h)this.rjm.get(j)).rbv;
          if (bool) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
      ab.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.rjt.field_type), localObject1 });
      if ((k > 0) && (this.rjt.field_type == 15)) {
        ar.gn(v.aE("sns_table_", k), localObject1);
      }
      ab.d("MicroMsg.UploadPackHelper", "pack commit result " + k + " cost " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(36739);
      return k;
    }
  }
  
  public final ay dc(List<String> paramList)
  {
    AppMethodBeat.i(36725);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.rju.ExtFlag = 1;
      AppMethodBeat.o(36725);
      return this;
    }
    paramList = paramList.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bwc localbwc = new bwc();
      localbwc.aoF(str);
      localLinkedList.add(localbwc);
    }
    this.rjs.GroupUser = localLinkedList;
    if (this.rju.ExtFlag == 3)
    {
      this.rju.BlackList = localLinkedList;
      this.rju.BlackListCount = localLinkedList.size();
    }
    for (;;)
    {
      AppMethodBeat.o(36725);
      return this;
      if (this.rju.ExtFlag == 5)
      {
        this.rju.GroupUser = localLinkedList;
        this.rju.GroupUserCount = localLinkedList.size();
      }
    }
  }
  
  public final void dd(List<h> paramList)
  {
    AppMethodBeat.i(36737);
    this.rjm = paramList;
    paramList = ag.coU().di(this.rjm);
    Object localObject1 = new LinkedList();
    if (paramList == null)
    {
      AppMethodBeat.o(36737);
      return;
    }
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      h localh = (h)((Iterator)localObject2).next();
      bam localbam = new bam();
      localbam.xpE = localh.cIp;
      ((LinkedList)localObject1).add(localbam);
    }
    this.rjs.xsq = ((LinkedList)localObject1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (h)paramList.next();
      localObject2 = new bcu();
      ((bcu)localObject2).xsI = 0.0F;
      ((bcu)localObject2).xsH = 0.0F;
      ((bcu)localObject2).xsJ = 0.0F;
      if ((((h)localObject1).height > 0) && (((h)localObject1).width > 0) && (((h)localObject1).fileSize > 0))
      {
        ((bcu)localObject2).xsI = ((h)localObject1).height;
        ((bcu)localObject2).xsH = ((h)localObject1).width;
        ((bcu)localObject2).xsJ = ((h)localObject1).fileSize;
      }
      localObject1 = com.tencent.mm.modelsns.e.a("Locall_path" + ((h)localObject1).cIp, ((h)localObject1).type, "", "", 0, 0, this.rbr, "", (bcu)localObject2);
      this.rjr.xTS.wOa.add(localObject1);
    }
    AppMethodBeat.o(36737);
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36738);
    cen localcen = new cen();
    localcen.wpV = paramString1;
    localcen.wpW = paramString2;
    localcen.wpX = paramString3;
    localcen.rLq = paramInt1;
    localcen.rLr = paramInt2;
    this.rjs.xsA = localcen;
    AppMethodBeat.o(36738);
  }
  
  public final ay go(String paramString1, String paramString2)
  {
    this.rjs.token = paramString1;
    this.rjs.xsy = paramString2;
    return this;
  }
  
  public final boolean gq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36732);
    String str = ag.getAccSnsTmpPath() + com.tencent.mm.a.g.w(paramString1.getBytes());
    aaV(str);
    com.tencent.mm.vfs.e.C(paramString1, str);
    paramString1 = gp("", str);
    if (paramString1 == null)
    {
      ab.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      AppMethodBeat.o(36732);
      return false;
    }
    paramString1.Desc = paramString2;
    if (bo.isNullOrNil(paramString1.Title)) {
      paramString1.Title = paramString2;
    }
    this.rjr.xTS.wOa.add(paramString1);
    paramString2 = new bam();
    paramString2.xpE = paramString1.cIp;
    this.rjs.xsq.add(paramString2);
    AppMethodBeat.o(36732);
    return true;
  }
  
  public final void setSessionId(String paramString)
  {
    this.rjs.cpW = paramString;
  }
  
  public final boolean t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(36730);
    String str = ag.getAccSnsTmpPath() + com.tencent.mm.a.g.w(paramString1.getBytes());
    aaV(str);
    com.tencent.mm.vfs.e.C(paramString1, str);
    paramString1 = ag.getAccSnsTmpPath() + com.tencent.mm.a.g.w(paramString2.getBytes());
    com.tencent.mm.vfs.e.C(paramString2, paramString1);
    paramString1 = c("", str, paramString1, paramString4, "", "");
    if (paramString1 == null)
    {
      ab.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      AppMethodBeat.o(36730);
      return false;
    }
    paramString1.Desc = paramString3;
    if (bo.isNullOrNil(paramString1.Title)) {
      paramString1.Title = paramString3;
    }
    this.rjr.xTS.wOa.add(paramString1);
    paramString2 = new bam();
    paramString2.xpE = paramString1.cIp;
    this.rjs.xsq.add(paramString2);
    AppMethodBeat.o(36730);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ay
 * JD-Core Version:    0.7.0.1
 */