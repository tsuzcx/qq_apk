package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ba
{
  private static final Pattern iyI;
  public int aTB;
  public boj dzk;
  private String fki;
  int wBl;
  int wBm;
  List<com.tencent.mm.plugin.sns.data.p> wLc;
  String wLd;
  String wLe;
  LinkedList<cwk> wLf;
  LinkedList<Long> wLg;
  public TimeLineObject wLh;
  public bpj wLi;
  com.tencent.mm.plugin.sns.storage.p wLj;
  SnsObject wLk;
  ay wLl;
  public czi wLm;
  public dsx wLn;
  private int wLo;
  private String wLp;
  private boolean wLq;
  
  static
  {
    AppMethodBeat.i(96061);
    iyI = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(96061);
  }
  
  public ba(int paramInt)
  {
    AppMethodBeat.i(96035);
    this.wLh = com.tencent.mm.modelsns.g.aBl();
    this.wLi = new bpj();
    this.wLj = new com.tencent.mm.plugin.sns.storage.p();
    this.wLk = null;
    Object localObject = new ay();
    ((ay)localObject).CuY = new aw();
    ((ay)localObject).Cva = new dv();
    ((ay)localObject).Cvb = new ej();
    this.wLl = ((ay)localObject);
    this.wLm = new czi();
    this.dzk = new boj();
    this.wLn = null;
    this.fki = "";
    this.wLo = 1;
    this.wLp = "";
    this.wLq = false;
    this.fki = af.dta();
    this.aTB = paramInt;
    this.wLh.Etm.DaB = paramInt;
    ad.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(paramInt)));
    this.wLh.DMS = 0;
    this.wLh.mAQ = this.fki;
    this.wLi.gKn = com.tencent.mm.b.g.getMessageDigest((af.dta() + bt.GC() + System.currentTimeMillis()).getBytes());
    this.wLi.DNn = 0;
    this.wLi.DNo = 0;
    this.wLi.DMS = 0;
    this.wLi.DNr = 0;
    this.wLi.gll = 0;
    this.wLi.DNt = 0;
    this.wLi.DNv = 0;
    localObject = new SnsObject();
    ((SnsObject)localObject).Id = 0L;
    ((SnsObject)localObject).CreateTime = 0;
    ((SnsObject)localObject).LikeFlag = 0;
    ((SnsObject)localObject).Username = af.dta();
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
    this.wLk = ((SnsObject)localObject);
    localObject = this.wLj;
    ((com.tencent.mm.plugin.sns.storage.p)localObject).field_localFlag |= 0x10;
    this.wLj.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    this.wLj.field_type = paramInt;
    this.wLj.field_userName = this.fki;
    this.wLj.field_pravited = 0;
    this.wLj.field_stringSeq = "0000099999999999999999999";
    this.wLj.MY(2);
    this.wLj.dxU();
    if ((paramInt == 1) || (paramInt == 2)) {
      this.wLj.MY(4);
    }
    if (paramInt == 7) {
      this.wLj.Nc(2);
    }
    this.wLg = new LinkedList();
    this.wLi.DNu = this.wLg;
    localObject = this.wLg.iterator();
    while (((Iterator)localObject).hasNext())
    {
      long l = ((Long)((Iterator)localObject).next()).longValue();
      cuw localcuw = new cuw();
      localcuw.EmE = l;
      this.wLk.GroupList.add(localcuw);
    }
    this.wLk.GroupCount = this.wLg.size();
    AppMethodBeat.o(96035);
  }
  
  private static String aoR(String paramString)
  {
    AppMethodBeat.i(96036);
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
        str1 = iyI.matcher(str1).replaceAll("\n\n");
        AppMethodBeat.o(96036);
        return str1;
      }
      catch (Exception localException)
      {
        break label57;
      }
      ad.e("MicroMsg.UploadPackHelper", "filter desc error ");
      AppMethodBeat.o(96036);
      return paramString;
    }
  }
  
  public static void apc(String paramString)
  {
    AppMethodBeat.i(96052);
    i.aMF(i.aMQ(paramString));
    AppMethodBeat.o(96052);
  }
  
  public static bpi av(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96050);
    bpi localbpi = com.tencent.mm.modelsns.g.aBm();
    localbpi.Id = paramString1;
    ad.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbpi.mBH = 2;
    localbpi.Url = paramString2;
    localbpi.Dzl = 0;
    localbpi.DMQ = paramString3;
    localbpi.DMR = 0;
    localbpi.DMW = 1;
    AppMethodBeat.o(96050);
    return localbpi;
  }
  
  public static bpi b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(96048);
    bpi localbpi = com.tencent.mm.modelsns.g.aBm();
    localbpi.Id = paramString1;
    ad.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { Integer.valueOf(6), paramString2, paramString4, paramString5, paramString6 });
    localbpi.mBH = 6;
    if (i.aMN(paramString2) <= 0L)
    {
      AppMethodBeat.o(96048);
      return null;
    }
    paramString1 = new com.tencent.mm.plugin.sns.data.p(paramString2, 6);
    paramString1.wBp = paramString4;
    paramString2 = af.dtj().a(paramString1, paramString2, paramString3, paramString5, paramString6);
    if ((paramString2.height > 0) && (paramString2.width > 0) && (paramString2.fileSize > 0))
    {
      paramString1 = new bpk();
      paramString1.DNI = paramString2.height;
      paramString1.DNH = paramString2.width;
      paramString1.DNJ = paramString2.fileSize;
    }
    for (;;)
    {
      localbpi.Id = ("Locall_path" + paramString2.dzf);
      localbpi.DMT = paramString1;
      localbpi.dzf = paramString2.dzf;
      AppMethodBeat.o(96048);
      return localbpi;
      paramString1 = null;
    }
  }
  
  private static bpi iJ(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(96049);
    bpi localbpi = com.tencent.mm.modelsns.g.aBm();
    localbpi.Id = paramString1;
    ad.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbpi.mBH = 2;
    if (i.aMN(paramString2) <= 0L)
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString1 = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(paramString2).append(System.currentTimeMillis()).toString().getBytes());
    i.lC(paramString2, paramString1);
    paramString1 = new com.tencent.mm.plugin.sns.data.p(paramString1, 2);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = af.dtj().fy(paramString2);
    if ((paramString1 == null) || (paramString1.size() == 0))
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString2 = (com.tencent.mm.plugin.sns.data.p)paramString1.get(0);
    paramString1 = localObject;
    if (paramString2.height > 0)
    {
      paramString1 = localObject;
      if (paramString2.width > 0)
      {
        paramString1 = localObject;
        if (paramString2.fileSize > 0)
        {
          paramString1 = new bpk();
          paramString1.DNI = paramString2.height;
          paramString1.DNH = paramString2.width;
          paramString1.DNJ = paramString2.fileSize;
        }
      }
    }
    localbpi.Id = ("Locall_path" + paramString2.dzf);
    localbpi.DMT = paramString1;
    localbpi.dzf = paramString2.dzf;
    AppMethodBeat.o(96049);
    return localbpi;
  }
  
  private static bpi u(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96047);
    if (bt.cw(paramArrayOfByte))
    {
      ad.e("MicroMsg.UploadPackHelper", f.XJ() + " attachBuf is null");
      AppMethodBeat.o(96047);
      return null;
    }
    String str = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
    i.aMF(af.getAccSnsTmpPath());
    ad.d("MicroMsg.UploadPackHelper", f.XJ() + " buildUploadAttachInfo file:" + str);
    if (i.f(str, paramArrayOfByte, paramArrayOfByte.length) < 0)
    {
      ad.e("MicroMsg.UploadPackHelper", f.XJ() + " writeFile error file:" + str);
      AppMethodBeat.o(96047);
      return null;
    }
    paramString = iJ(paramString, str);
    AppMethodBeat.o(96047);
    return paramString;
  }
  
  public final ba Ms(int paramInt)
  {
    this.wLh.Eto = 1;
    this.wLh.Etp = paramInt;
    return this;
  }
  
  public final void Mt(int paramInt)
  {
    AppMethodBeat.i(96039);
    ad.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(paramInt)));
    this.wLi.DNt = paramInt;
    AppMethodBeat.o(96039);
  }
  
  public final ba Mu(int paramInt)
  {
    AppMethodBeat.i(96040);
    this.wBm = paramInt;
    this.wLi.DMS = paramInt;
    this.wLh.DMS = paramInt;
    if (paramInt > 0)
    {
      this.wLj.field_pravited = paramInt;
      this.wLj.dxR();
      this.wLj.Nc(2);
      this.wLj.dxV();
    }
    AppMethodBeat.o(96040);
    return this;
  }
  
  public final ba Mv(int paramInt)
  {
    this.wBl = paramInt;
    this.wLi.DNo = paramInt;
    return this;
  }
  
  public final ba Mw(int paramInt)
  {
    this.wLi.DNv = paramInt;
    return this;
  }
  
  public final ba Mx(int paramInt)
  {
    if (paramInt == 1) {
      this.wLk.ExtFlag = 3;
    }
    for (;;)
    {
      this.wLi.DNy = paramInt;
      return this;
      if (paramInt == 0) {
        this.wLk.ExtFlag = 5;
      }
    }
  }
  
  public final ba a(bmn parambmn)
  {
    if (parambmn == null) {
      return this;
    }
    this.wLh.Etk = parambmn;
    return this;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(96056);
    paramArrayOfByte = u("", paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
      AppMethodBeat.o(96056);
      return false;
    }
    paramArrayOfByte.Desc = paramString1;
    if (paramInt > 0) {
      paramArrayOfByte.subType = paramInt;
    }
    if (!bt.isNullOrNil(paramString3)) {
      paramArrayOfByte.xmd = paramString3;
    }
    if (!bt.isNullOrNil(paramString2)) {
      paramArrayOfByte.Title = paramString2;
    }
    if (!bt.isNullOrNil(paramString1)) {
      paramArrayOfByte.Desc = paramString1;
    }
    this.wLh.Etm.DaC.add(paramArrayOfByte);
    paramString1 = new bmh();
    paramString1.DJN = paramArrayOfByte.dzf;
    this.wLi.DNp.add(paramString1);
    AppMethodBeat.o(96056);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(96057);
    paramArrayOfByte = u("", paramArrayOfByte);
    if ((paramArrayOfByte == null) || ((bt.isNullOrNil(paramString2)) && (bt.isNullOrNil(paramString3))))
    {
      ad.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
      AppMethodBeat.o(96057);
      return false;
    }
    if (!bt.isNullOrNil(paramString1)) {
      this.wLh.Etm.Url = paramString1;
    }
    if (!bt.isNullOrNil(paramString3))
    {
      paramArrayOfByte.Url = paramString3;
      paramArrayOfByte.Dzl = 0;
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString2))
      {
        paramArrayOfByte.DMU = paramString2;
        paramArrayOfByte.DMV = 0;
      }
      paramArrayOfByte.mBH = paramInt;
      paramArrayOfByte.Title = bt.by(paramString4, "");
      paramArrayOfByte.Desc = bt.by(paramString5, "");
      paramArrayOfByte.songAlbumUrl = paramString6;
      paramArrayOfByte.songLyric = paramString7;
      this.wLh.Etm.DaC.add(paramArrayOfByte);
      paramString1 = new bmh();
      paramString1.DJN = paramArrayOfByte.dzf;
      this.wLi.DNp.add(paramString1);
      AppMethodBeat.o(96057);
      return true;
      if (!bt.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Url = paramString2;
        paramArrayOfByte.Dzl = 0;
      }
    }
  }
  
  public final ba aM(LinkedList<cwk> paramLinkedList)
  {
    AppMethodBeat.i(96041);
    this.wLf = paramLinkedList;
    this.wLi.DNq = paramLinkedList;
    paramLinkedList = this.wLf.iterator();
    while (paramLinkedList.hasNext())
    {
      cwk localcwk = (cwk)paramLinkedList.next();
      cuo localcuo = new cuo();
      localcuo.Username = localcwk.mAQ;
      this.wLk.WithUserList.add(localcuo);
    }
    this.wLk.WithUserCount = this.wLf.size();
    this.wLk.WithUserListCount = this.wLf.size();
    AppMethodBeat.o(96041);
    return this;
  }
  
  public final ba aoS(String paramString)
  {
    AppMethodBeat.i(96037);
    this.wLd = aoR(paramString);
    this.wLh.Etj = this.wLd;
    AppMethodBeat.o(96037);
    return this;
  }
  
  public final ba aoT(String paramString)
  {
    this.wLh.Etq = paramString;
    this.wLl.CuY.CuS = paramString;
    return this;
  }
  
  public final ba aoU(String paramString)
  {
    this.wLh.xpl = paramString;
    return this;
  }
  
  public final ba aoV(String paramString)
  {
    this.wLe = paramString;
    this.wLh.Etm.Desc = paramString;
    return this;
  }
  
  public final ba aoW(String paramString)
  {
    this.wLh.Etm.Url = paramString;
    return this;
  }
  
  public final ba aoX(String paramString)
  {
    this.wLh.Etm.Title = paramString;
    return this;
  }
  
  public final ba aoY(String paramString)
  {
    AppMethodBeat.i(96042);
    eh localeh2 = this.wLh.Etl;
    eh localeh1 = localeh2;
    if (localeh2 == null) {
      localeh1 = new eh();
    }
    localeh1.Id = paramString;
    this.wLh.Etl = localeh1;
    AppMethodBeat.o(96042);
    return this;
  }
  
  public final ba aoZ(String paramString)
  {
    AppMethodBeat.i(96043);
    eh localeh2 = this.wLh.Etl;
    eh localeh1 = localeh2;
    if (localeh2 == null) {
      localeh1 = new eh();
    }
    localeh1.scR = paramString;
    this.wLh.Etl = localeh1;
    AppMethodBeat.o(96043);
    return this;
  }
  
  public final ba apa(String paramString)
  {
    AppMethodBeat.i(96044);
    this.wLh.jec = bt.nullAsNil(paramString);
    AppMethodBeat.o(96044);
    return this;
  }
  
  public final ba apb(String paramString)
  {
    AppMethodBeat.i(96045);
    this.wLh.BXw = bt.nullAsNil(paramString);
    AppMethodBeat.o(96045);
    return this;
  }
  
  public final ba au(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96038);
    aw localaw = this.wLl.CuY;
    Object localObject = paramString1;
    if (bt.isNullOrNil(paramString1)) {
      localObject = "";
    }
    localaw.hnC = ((String)localObject);
    localObject = this.wLl.CuY;
    paramString1 = paramString2;
    if (bt.isNullOrNil(paramString2)) {
      paramString1 = "";
    }
    ((aw)localObject).CuT = paramString1;
    paramString2 = this.wLl.CuY;
    paramString1 = paramString3;
    if (bt.isNullOrNil(paramString3)) {
      paramString1 = "";
    }
    paramString2.CuU = paramString1;
    AppMethodBeat.o(96038);
    return this;
  }
  
  @Deprecated
  public final boolean b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(96054);
    paramString1 = av("", paramString1, paramString2);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(96054);
      return false;
    }
    paramString1.Desc = paramString3;
    if (paramInt > 0) {
      paramString1.subType = paramInt;
    }
    if (!bt.isNullOrNil(paramString4)) {
      paramString1.xmd = paramString4;
    }
    this.wLh.Etm.DaC.add(paramString1);
    AppMethodBeat.o(96054);
    return true;
  }
  
  public final boolean b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96055);
    boolean bool = a(paramArrayOfByte, paramString1, paramString2, -1, "");
    AppMethodBeat.o(96055);
    return bool;
  }
  
  public final ba bR(int paramInt, String paramString)
  {
    this.wLo = paramInt;
    this.wLp = paramString;
    return this;
  }
  
  public final int commit()
  {
    AppMethodBeat.i(96060);
    long l = System.currentTimeMillis();
    try
    {
      this.wLi.DNs = System.currentTimeMillis();
      this.wLi.gll = 0;
      Object localObject1 = new bwn();
      ((bwn)localObject1).CyL = this.wLo;
      ((bwn)localObject1).rZy = this.wLp;
      this.wLi.DNG = ((bwn)localObject1);
      this.wLj.bC(this.wLk.toByteArray());
      this.wLj.field_postBuf = this.wLi.toByteArray();
      ad.d("MicroMsg.UploadPackHelper", "snsObj " + this.wLk.toString());
      ad.d("MicroMsg.UploadPackHelper", "postinfo " + this.wLi.toString());
      ad.d("MicroMsg.UploadPackHelper", "timelineObj " + this.wLh.toString());
      if (this.wLh.Etm.DaC != null)
      {
        ad.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", new Object[] { Integer.valueOf(this.wLh.Etm.DaC.size()) });
        i = 0;
        while (i < this.wLh.Etm.DaC.size())
        {
          localObject1 = (bpi)this.wLh.Etm.DaC.get(i);
          if (localObject1 != null) {
            ad.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", new Object[] { Integer.valueOf(((bpi)localObject1).dzf), bt.by(((bpi)localObject1).Url, "") });
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
        ad.printErrStackTrace("MicroMsg.UploadPackHelper", localException1, "", new Object[0]);
      }
      if (this.wLl != null) {
        this.wLh.wLl = this.wLl;
      }
      if (this.wLn != null) {
        this.wLh.wLn = this.wLn;
      }
      this.wLj.g(this.wLh);
      int k = af.dtu().I(this.wLj);
      Iterator localIterator = this.wLi.DNp.iterator();
      int j = 0;
      Object localObject2 = null;
      if (localIterator.hasNext())
      {
        Object localObject3 = (bmh)localIterator.next();
        t localt = af.dtj().ti(((bmh)localObject3).DJN);
        for (;;)
        {
          try
          {
            bpl localbpl = (bpl)new bpl().parseFrom(localt.xjn);
            if (this.wLh.Etl != null) {
              localbpl.dlB = this.wLh.Etl.Id;
            }
            if (this.dzk != null) {
              this.dzk.qRG = 0;
            }
            localbpl.DNQ = this.dzk;
            localbpl.aTB = this.wLh.Etm.DaB;
            if ((localbpl.aTB == 1) || (localbpl.aTB == 15))
            {
              if (!bt.isNullOrNil(localbpl.dlB))
              {
                i = 5;
                localbpl.DNR = i;
              }
            }
            else
            {
              localt.xjn = localbpl.toByteArray();
              af.dtj().a(((bmh)localObject3).DJN, localt);
              localObject3 = localbpl.md5;
              j += 1;
              localObject2 = localObject3;
              break;
            }
            if ((localbpl.DNQ == null) || (localbpl.aTB != 15)) {
              break label658;
            }
            if (localbpl.DNQ.DLK)
            {
              i = 1;
              localbpl.DNR = i;
              continue;
            }
          }
          catch (Exception localException2)
          {
            ad.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
          }
          i = 2;
          continue;
          label658:
          boolean bool = ((com.tencent.mm.plugin.sns.data.p)this.wLc.get(j)).wBq;
          if (bool) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
      ad.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.wLj.field_type), localObject2 });
      if ((k > 0) && (this.wLj.field_type == 15)) {
        at.iH(x.bh("sns_table_", k), localObject2);
      }
      ad.d("MicroMsg.UploadPackHelper", "pack commit result " + k + " cost " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(96060);
      return k;
    }
  }
  
  public final ba fq(List<String> paramList)
  {
    AppMethodBeat.i(96046);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.wLk.ExtFlag = 1;
      AppMethodBeat.o(96046);
      return this;
    }
    paramList = paramList.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      cmf localcmf = new cmf();
      localcmf.aEE(str);
      localLinkedList.add(localcmf);
    }
    this.wLi.GroupUser = localLinkedList;
    if (this.wLk.ExtFlag == 3)
    {
      this.wLk.BlackList = localLinkedList;
      this.wLk.BlackListCount = localLinkedList.size();
    }
    for (;;)
    {
      AppMethodBeat.o(96046);
      return this;
      if (this.wLk.ExtFlag == 5)
      {
        this.wLk.GroupUser = localLinkedList;
        this.wLk.GroupUserCount = localLinkedList.size();
      }
    }
  }
  
  public final void fr(List<com.tencent.mm.plugin.sns.data.p> paramList)
  {
    AppMethodBeat.i(96058);
    this.wLc = paramList;
    paramList = af.dtj().fy(this.wLc);
    Object localObject1 = new LinkedList();
    if (paramList == null)
    {
      AppMethodBeat.o(96058);
      return;
    }
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.plugin.sns.data.p localp = (com.tencent.mm.plugin.sns.data.p)((Iterator)localObject2).next();
      bmh localbmh = new bmh();
      localbmh.DJN = localp.dzf;
      ((LinkedList)localObject1).add(localbmh);
    }
    this.wLi.DNp = ((LinkedList)localObject1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.sns.data.p)paramList.next();
      localObject2 = new bpk();
      ((bpk)localObject2).DNI = 0.0F;
      ((bpk)localObject2).DNH = 0.0F;
      ((bpk)localObject2).DNJ = 0.0F;
      if ((((com.tencent.mm.plugin.sns.data.p)localObject1).height > 0) && (((com.tencent.mm.plugin.sns.data.p)localObject1).width > 0) && (((com.tencent.mm.plugin.sns.data.p)localObject1).fileSize > 0))
      {
        ((bpk)localObject2).DNI = ((com.tencent.mm.plugin.sns.data.p)localObject1).height;
        ((bpk)localObject2).DNH = ((com.tencent.mm.plugin.sns.data.p)localObject1).width;
        ((bpk)localObject2).DNJ = ((com.tencent.mm.plugin.sns.data.p)localObject1).fileSize;
      }
      localObject1 = com.tencent.mm.modelsns.g.a("Locall_path" + ((com.tencent.mm.plugin.sns.data.p)localObject1).dzf, ((com.tencent.mm.plugin.sns.data.p)localObject1).type, "", "", 0, 0, this.wBm, "", (bpk)localObject2);
      this.wLh.Etm.DaC.add(localObject1);
    }
    AppMethodBeat.o(96058);
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96059);
    cvk localcvk = new cvk();
    localcvk.CyI = paramString1;
    localcvk.CyJ = paramString2;
    localcvk.CyK = paramString3;
    localcvk.xpm = paramInt1;
    localcvk.xpn = paramInt2;
    this.wLi.DNz = localcvk;
    AppMethodBeat.o(96059);
  }
  
  public final ba iI(String paramString1, String paramString2)
  {
    this.wLi.token = paramString1;
    this.wLi.DNx = paramString2;
    return this;
  }
  
  public final boolean iK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96053);
    String str = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    apc(str);
    i.lC(paramString1, str);
    paramString1 = iJ("", str);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      AppMethodBeat.o(96053);
      return false;
    }
    paramString1.Desc = paramString2;
    if (bt.isNullOrNil(paramString1.Title)) {
      paramString1.Title = paramString2;
    }
    this.wLh.Etm.DaC.add(paramString1);
    paramString2 = new bmh();
    paramString2.DJN = paramString1.dzf;
    this.wLi.DNp.add(paramString2);
    AppMethodBeat.o(96053);
    return true;
  }
  
  public final void setSessionId(String paramString)
  {
    this.wLi.sessionId = paramString;
  }
  
  public final boolean w(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(96051);
    Object localObject = c.vtL;
    localObject = c.alZ(paramString1);
    if (localObject != null) {
      ad.i("MicroMsg.UploadPackHelper", "addSightObjectByPath commit video_info:".concat(String.valueOf(localObject)));
    }
    for (float f = ((c.a)localObject).duration / 1000.0F;; f = 0.0F)
    {
      localObject = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
      apc((String)localObject);
      i.lC(paramString1, (String)localObject);
      paramString1 = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString2.getBytes());
      i.lC(paramString2, paramString1);
      paramString1 = b("", (String)localObject, paramString1, paramString4, "", "");
      if (paramString1 == null)
      {
        ad.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
        AppMethodBeat.o(96051);
        return false;
      }
      paramString1.Desc = paramString3;
      if (bt.isNullOrNil(paramString1.Title)) {
        paramString1.Title = paramString3;
      }
      paramString1.DNm = f;
      this.wLh.Etm.DaC.add(paramString1);
      paramString2 = new bmh();
      paramString2.DJN = paramString1.dzf;
      this.wLi.DNp.add(paramString2);
      AppMethodBeat.o(96051);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ba
 * JD-Core Version:    0.7.0.1
 */