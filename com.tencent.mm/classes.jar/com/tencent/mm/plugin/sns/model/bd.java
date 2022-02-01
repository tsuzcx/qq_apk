package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgp;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bd
{
  private static final Pattern juN;
  public int beN;
  public byg dKw;
  private String fHO;
  List<q> zEW;
  String zEX;
  String zEY;
  LinkedList<did> zEZ;
  LinkedList<Long> zFa;
  public TimeLineObject zFb;
  public bzi zFc;
  p zFd;
  SnsObject zFe;
  ba zFf;
  public dlc zFg;
  public egh zFh;
  private int zFi;
  private String zFj;
  private boolean zFk;
  int zuq;
  int zur;
  
  static
  {
    AppMethodBeat.i(96061);
    juN = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(96061);
  }
  
  public bd(int paramInt)
  {
    AppMethodBeat.i(96035);
    this.zFb = h.aLJ();
    this.zFc = new bzi();
    this.zFd = new p();
    this.zFe = null;
    Object localObject = new ba();
    ((ba)localObject).FKW = new ay();
    ((ba)localObject).FKY = new dy();
    ((ba)localObject).FKZ = new ep();
    this.zFf = ((ba)localObject);
    this.zFg = new dlc();
    this.dKw = new byg();
    this.zFh = null;
    this.fHO = "";
    this.zFi = 1;
    this.zFj = "";
    this.zFk = false;
    this.fHO = ah.dXj();
    this.beN = paramInt;
    this.zFb.HUG.Gtw = paramInt;
    ae.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(paramInt)));
    this.zFb.Hml = 0;
    this.zFb.nIJ = this.fHO;
    this.zFc.hFO = g.getMessageDigest((ah.dXj() + bu.HQ() + System.currentTimeMillis()).getBytes());
    this.zFc.HmG = 0;
    this.zFc.HmH = 0;
    this.zFc.Hml = 0;
    this.zFc.HmK = 0;
    this.zFc.hiJ = 0;
    this.zFc.HmM = 0;
    this.zFc.HmO = 0;
    localObject = new SnsObject();
    ((SnsObject)localObject).Id = 0L;
    ((SnsObject)localObject).CreateTime = 0;
    ((SnsObject)localObject).LikeFlag = 0;
    ((SnsObject)localObject).Username = ah.dXj();
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
    this.zFe = ((SnsObject)localObject);
    localObject = this.zFd;
    ((p)localObject).field_localFlag |= 0x10;
    this.zFd.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    this.zFd.field_type = paramInt;
    this.zFd.field_userName = this.fHO;
    this.zFd.field_pravited = 0;
    this.zFd.field_stringSeq = "0000099999999999999999999";
    this.zFd.Rq(2);
    this.zFd.ecl();
    if ((paramInt == 1) || (paramInt == 2)) {
      this.zFd.Rq(4);
    }
    if (paramInt == 7) {
      this.zFd.Ru(2);
    }
    this.zFa = new LinkedList();
    this.zFc.HmN = this.zFa;
    localObject = this.zFa.iterator();
    while (((Iterator)localObject).hasNext())
    {
      long l = ((Long)((Iterator)localObject).next()).longValue();
      dgp localdgp = new dgp();
      localdgp.HNO = l;
      this.zFe.GroupList.add(localdgp);
    }
    this.zFe.GroupCount = this.zFa.size();
    AppMethodBeat.o(96035);
  }
  
  public static void aAK(String paramString)
  {
    AppMethodBeat.i(96052);
    o.aZI(o.aZU(paramString));
    AppMethodBeat.o(96052);
  }
  
  private static String aAz(String paramString)
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
        str1 = juN.matcher(str1).replaceAll("\n\n");
        AppMethodBeat.o(96036);
        return str1;
      }
      catch (Exception localException)
      {
        break label57;
      }
      ae.e("MicroMsg.UploadPackHelper", "filter desc error ");
      AppMethodBeat.o(96036);
      return paramString;
    }
  }
  
  public static bzh aE(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96050);
    bzh localbzh = h.aLK();
    localbzh.Id = paramString1;
    ae.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbzh.nJA = 2;
    localbzh.Url = paramString2;
    localbzh.GXH = 0;
    localbzh.Hmj = paramString3;
    localbzh.Hmk = 0;
    localbzh.Hmp = 1;
    AppMethodBeat.o(96050);
    return localbzh;
  }
  
  public static bzh b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(96048);
    bzh localbzh = h.aLK();
    localbzh.Id = paramString1;
    ae.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { Integer.valueOf(6), paramString2, paramString4, paramString5, paramString6 });
    localbzh.nJA = 6;
    if (o.aZR(paramString2) <= 0L)
    {
      AppMethodBeat.o(96048);
      return null;
    }
    paramString1 = new q(paramString2, 6);
    paramString1.zuu = paramString4;
    paramString2 = ah.dXt().a(paramString1, paramString2, paramString3, paramString5, paramString6);
    if ((paramString2.height > 0) && (paramString2.width > 0) && (paramString2.fileSize > 0))
    {
      paramString1 = new bzj();
      paramString1.Hnb = paramString2.height;
      paramString1.Hna = paramString2.width;
      paramString1.Hnc = paramString2.fileSize;
    }
    for (;;)
    {
      localbzh.Id = ("Locall_path" + paramString2.dKr);
      localbzh.Hmm = paramString1;
      localbzh.dKr = paramString2.dKr;
      AppMethodBeat.o(96048);
      return localbzh;
      paramString1 = null;
    }
  }
  
  private static bzh jz(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(96049);
    bzh localbzh = h.aLK();
    localbzh.Id = paramString1;
    ae.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbzh.nJA = 2;
    if (o.aZR(paramString2) <= 0L)
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString1 = ah.getAccSnsTmpPath() + g.getMessageDigest(new StringBuilder().append(paramString2).append(System.currentTimeMillis()).toString().getBytes());
    o.mF(paramString2, paramString1);
    paramString1 = new q(paramString1, 2);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = ah.dXt().ga(paramString2);
    if ((paramString1 == null) || (paramString1.size() == 0))
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString2 = (q)paramString1.get(0);
    paramString1 = localObject;
    if (paramString2.height > 0)
    {
      paramString1 = localObject;
      if (paramString2.width > 0)
      {
        paramString1 = localObject;
        if (paramString2.fileSize > 0)
        {
          paramString1 = new bzj();
          paramString1.Hnb = paramString2.height;
          paramString1.Hna = paramString2.width;
          paramString1.Hnc = paramString2.fileSize;
        }
      }
    }
    localbzh.Id = ("Locall_path" + paramString2.dKr);
    localbzh.Hmm = paramString1;
    localbzh.dKr = paramString2.dKr;
    AppMethodBeat.o(96049);
    return localbzh;
  }
  
  private static bzh v(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96047);
    if (bu.cF(paramArrayOfByte))
    {
      ae.e("MicroMsg.UploadPackHelper", f.abr() + " attachBuf is null");
      AppMethodBeat.o(96047);
      return null;
    }
    String str = ah.getAccSnsTmpPath() + g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
    o.aZI(ah.getAccSnsTmpPath());
    ae.d("MicroMsg.UploadPackHelper", f.abr() + " buildUploadAttachInfo file:" + str);
    if (o.f(str, paramArrayOfByte, paramArrayOfByte.length) < 0)
    {
      ae.e("MicroMsg.UploadPackHelper", f.abr() + " writeFile error file:" + str);
      AppMethodBeat.o(96047);
      return null;
    }
    paramString = jz(paramString, str);
    AppMethodBeat.o(96047);
    return paramString;
  }
  
  public final bd QI(int paramInt)
  {
    this.zFb.HUI = 1;
    this.zFb.HUJ = paramInt;
    return this;
  }
  
  public final bd QJ(int paramInt)
  {
    this.zFb.hCH = paramInt;
    return this;
  }
  
  public final void QK(int paramInt)
  {
    AppMethodBeat.i(96039);
    ae.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(paramInt)));
    this.zFc.HmM = paramInt;
    AppMethodBeat.o(96039);
  }
  
  public final bd QL(int paramInt)
  {
    AppMethodBeat.i(96040);
    this.zur = paramInt;
    this.zFc.Hml = paramInt;
    this.zFb.Hml = paramInt;
    if (paramInt > 0)
    {
      this.zFd.field_pravited = paramInt;
      this.zFd.eci();
      this.zFd.Ru(2);
      this.zFd.ecm();
    }
    AppMethodBeat.o(96040);
    return this;
  }
  
  public final bd QM(int paramInt)
  {
    this.zuq = paramInt;
    this.zFc.HmH = paramInt;
    return this;
  }
  
  public final bd QN(int paramInt)
  {
    this.zFc.HmO = paramInt;
    return this;
  }
  
  public final bd QO(int paramInt)
  {
    if (paramInt == 1) {
      this.zFe.ExtFlag = 3;
    }
    for (;;)
    {
      this.zFc.HmR = paramInt;
      return this;
      if (paramInt == 0) {
        this.zFe.ExtFlag = 5;
      }
    }
  }
  
  public final bd a(bwk parambwk)
  {
    if (parambwk == null) {
      return this;
    }
    this.zFb.HUE = parambwk;
    return this;
  }
  
  public final void a(b paramb)
  {
    if (paramb != null) {
      this.zFb.HUG.GtB = paramb.ipW;
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(96056);
    paramArrayOfByte = v("", paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
      AppMethodBeat.o(96056);
      return false;
    }
    paramArrayOfByte.Desc = paramString1;
    if (paramInt > 0) {
      paramArrayOfByte.subType = paramInt;
    }
    if (!bu.isNullOrNil(paramString3)) {
      paramArrayOfByte.Aho = paramString3;
    }
    if (!bu.isNullOrNil(paramString2)) {
      paramArrayOfByte.Title = paramString2;
    }
    if (!bu.isNullOrNil(paramString1)) {
      paramArrayOfByte.Desc = paramString1;
    }
    this.zFb.HUG.Gtx.add(paramArrayOfByte);
    paramString1 = new bwe();
    paramString1.Hjg = paramArrayOfByte.dKr;
    this.zFc.HmI.add(paramString1);
    AppMethodBeat.o(96056);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(96057);
    paramArrayOfByte = v("", paramArrayOfByte);
    if ((paramArrayOfByte == null) || ((bu.isNullOrNil(paramString2)) && (bu.isNullOrNil(paramString3))))
    {
      ae.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
      AppMethodBeat.o(96057);
      return false;
    }
    if (!bu.isNullOrNil(paramString1)) {
      this.zFb.HUG.Url = paramString1;
    }
    if (!bu.isNullOrNil(paramString3))
    {
      paramArrayOfByte.Url = paramString3;
      paramArrayOfByte.GXH = 0;
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Hmn = paramString2;
        paramArrayOfByte.Hmo = 0;
      }
      paramArrayOfByte.nJA = paramInt;
      paramArrayOfByte.Title = bu.bI(paramString4, "");
      paramArrayOfByte.Desc = bu.bI(paramString5, "");
      paramArrayOfByte.songAlbumUrl = paramString6;
      paramArrayOfByte.songLyric = paramString7;
      this.zFb.HUG.Gtx.add(paramArrayOfByte);
      paramString1 = new bwe();
      paramString1.Hjg = paramArrayOfByte.dKr;
      this.zFc.HmI.add(paramString1);
      AppMethodBeat.o(96057);
      return true;
      if (!bu.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Url = paramString2;
        paramArrayOfByte.GXH = 0;
      }
    }
  }
  
  public final bd aAA(String paramString)
  {
    AppMethodBeat.i(96037);
    this.zEX = aAz(paramString);
    this.zFb.HUD = this.zEX;
    AppMethodBeat.o(96037);
    return this;
  }
  
  public final bd aAB(String paramString)
  {
    this.zFb.HUK = paramString;
    this.zFf.FKW.FKQ = paramString;
    return this;
  }
  
  public final bd aAC(String paramString)
  {
    this.zFb.AkC = paramString;
    return this;
  }
  
  public final bd aAD(String paramString)
  {
    this.zEY = paramString;
    this.zFb.HUG.Desc = paramString;
    return this;
  }
  
  public final bd aAE(String paramString)
  {
    this.zFb.HUG.Url = paramString;
    return this;
  }
  
  public final bd aAF(String paramString)
  {
    this.zFb.HUG.Title = paramString;
    return this;
  }
  
  public final bd aAG(String paramString)
  {
    AppMethodBeat.i(96042);
    en localen2 = this.zFb.HUF;
    en localen1 = localen2;
    if (localen2 == null) {
      localen1 = new en();
    }
    localen1.Id = paramString;
    this.zFb.HUF = localen1;
    AppMethodBeat.o(96042);
    return this;
  }
  
  public final bd aAH(String paramString)
  {
    AppMethodBeat.i(96043);
    en localen2 = this.zFb.HUF;
    en localen1 = localen2;
    if (localen2 == null) {
      localen1 = new en();
    }
    localen1.uuo = paramString;
    this.zFb.HUF = localen1;
    AppMethodBeat.o(96043);
    return this;
  }
  
  public final bd aAI(String paramString)
  {
    AppMethodBeat.i(96044);
    this.zFb.kbH = bu.nullAsNil(paramString);
    AppMethodBeat.o(96044);
    return this;
  }
  
  public final bd aAJ(String paramString)
  {
    AppMethodBeat.i(96045);
    this.zFb.Fnm = bu.nullAsNil(paramString);
    AppMethodBeat.o(96045);
    return this;
  }
  
  public final void aAL(String paramString)
  {
    this.zFc.dIz = paramString;
  }
  
  public final bd aD(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96038);
    ay localay = this.zFf.FKW;
    Object localObject = paramString1;
    if (bu.isNullOrNil(paramString1)) {
      localObject = "";
    }
    localay.ikm = ((String)localObject);
    localObject = this.zFf.FKW;
    paramString1 = paramString2;
    if (bu.isNullOrNil(paramString2)) {
      paramString1 = "";
    }
    ((ay)localObject).FKR = paramString1;
    paramString2 = this.zFf.FKW;
    paramString1 = paramString3;
    if (bu.isNullOrNil(paramString3)) {
      paramString1 = "";
    }
    paramString2.FKS = paramString1;
    AppMethodBeat.o(96038);
    return this;
  }
  
  public final bd aV(LinkedList<did> paramLinkedList)
  {
    AppMethodBeat.i(96041);
    this.zEZ = paramLinkedList;
    this.zFc.HmJ = paramLinkedList;
    paramLinkedList = this.zEZ.iterator();
    while (paramLinkedList.hasNext())
    {
      did localdid = (did)paramLinkedList.next();
      dgh localdgh = new dgh();
      localdgh.Username = localdid.nIJ;
      this.zFe.WithUserList.add(localdgh);
    }
    this.zFe.WithUserCount = this.zEZ.size();
    this.zFe.WithUserListCount = this.zEZ.size();
    AppMethodBeat.o(96041);
    return this;
  }
  
  public final boolean b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96055);
    boolean bool = a(paramArrayOfByte, paramString1, paramString2, -1, "");
    AppMethodBeat.o(96055);
    return bool;
  }
  
  @Deprecated
  public final boolean c(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(96054);
    paramString1 = aE("", paramString1, paramString2);
    if (paramString1 == null)
    {
      ae.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(96054);
      return false;
    }
    paramString1.Desc = paramString3;
    if (paramInt > 0) {
      paramString1.subType = paramInt;
    }
    if (!bu.isNullOrNil(paramString4)) {
      paramString1.Aho = paramString4;
    }
    this.zFb.HUG.Gtx.add(paramString1);
    AppMethodBeat.o(96054);
    return true;
  }
  
  public final bd cc(int paramInt, String paramString)
  {
    this.zFi = paramInt;
    this.zFj = paramString;
    return this;
  }
  
  /* Error */
  public final int commit()
  {
    // Byte code:
    //   0: ldc_w 779
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: aload_0
    //   12: getfield 82	com/tencent/mm/plugin/sns/model/bd:zFc	Lcom/tencent/mm/protocal/protobuf/bzi;
    //   15: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   18: putfield 782	com/tencent/mm/protocal/protobuf/bzi:HmL	J
    //   21: aload_0
    //   22: getfield 82	com/tencent/mm/plugin/sns/model/bd:zFc	Lcom/tencent/mm/protocal/protobuf/bzi;
    //   25: iconst_0
    //   26: putfield 232	com/tencent/mm/protocal/protobuf/bzi:hiJ	I
    //   29: new 784	com/tencent/mm/protocal/protobuf/cgs
    //   32: dup
    //   33: invokespecial 785	com/tencent/mm/protocal/protobuf/cgs:<init>	()V
    //   36: astore 7
    //   38: aload 7
    //   40: aload_0
    //   41: getfield 133	com/tencent/mm/plugin/sns/model/bd:zFi	I
    //   44: putfield 788	com/tencent/mm/protocal/protobuf/cgs:FOX	I
    //   47: aload 7
    //   49: aload_0
    //   50: getfield 135	com/tencent/mm/plugin/sns/model/bd:zFj	Ljava/lang/String;
    //   53: putfield 791	com/tencent/mm/protocal/protobuf/cgs:uqs	Ljava/lang/String;
    //   56: aload_0
    //   57: getfield 82	com/tencent/mm/plugin/sns/model/bd:zFc	Lcom/tencent/mm/protocal/protobuf/bzi;
    //   60: aload 7
    //   62: putfield 795	com/tencent/mm/protocal/protobuf/bzi:HmZ	Lcom/tencent/mm/protocal/protobuf/cgs;
    //   65: aload_0
    //   66: getfield 87	com/tencent/mm/plugin/sns/model/bd:zFd	Lcom/tencent/mm/plugin/sns/storage/p;
    //   69: aload_0
    //   70: getfield 89	com/tencent/mm/plugin/sns/model/bd:zFe	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   73: invokevirtual 798	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   76: invokevirtual 802	com/tencent/mm/plugin/sns/storage/p:bL	([B)V
    //   79: aload_0
    //   80: getfield 87	com/tencent/mm/plugin/sns/model/bd:zFd	Lcom/tencent/mm/plugin/sns/storage/p;
    //   83: aload_0
    //   84: getfield 82	com/tencent/mm/plugin/sns/model/bd:zFc	Lcom/tencent/mm/protocal/protobuf/bzi;
    //   87: invokevirtual 803	com/tencent/mm/protocal/protobuf/bzi:toByteArray	()[B
    //   90: putfield 807	com/tencent/mm/plugin/sns/storage/p:field_postBuf	[B
    //   93: ldc 158
    //   95: new 184	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 809
    //   102: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 89	com/tencent/mm/plugin/sns/model/bd:zFe	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   109: invokevirtual 810	java/lang/Object:toString	()Ljava/lang/String;
    //   112: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 176	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: ldc 158
    //   123: new 184	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 812
    //   130: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 82	com/tencent/mm/plugin/sns/model/bd:zFc	Lcom/tencent/mm/protocal/protobuf/bzi;
    //   137: invokevirtual 810	java/lang/Object:toString	()Ljava/lang/String;
    //   140: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 176	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: ldc 158
    //   151: new 184	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 814
    //   158: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   165: invokevirtual 810	java/lang/Object:toString	()Ljava/lang/String;
    //   168: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 176	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   181: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   184: getfield 643	com/tencent/mm/protocal/protobuf/abo:Gtx	Ljava/util/LinkedList;
    //   187: ifnull +138 -> 325
    //   190: ldc 158
    //   192: ldc_w 816
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_0
    //   202: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   205: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   208: getfield 643	com/tencent/mm/protocal/protobuf/abo:Gtx	Ljava/util/LinkedList;
    //   211: invokevirtual 373	java/util/LinkedList:size	()I
    //   214: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: invokestatic 818	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: iconst_0
    //   222: istore_1
    //   223: iload_1
    //   224: aload_0
    //   225: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   228: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   231: getfield 643	com/tencent/mm/protocal/protobuf/abo:Gtx	Ljava/util/LinkedList;
    //   234: invokevirtual 373	java/util/LinkedList:size	()I
    //   237: if_icmpge +88 -> 325
    //   240: aload_0
    //   241: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   244: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   247: getfield 643	com/tencent/mm/protocal/protobuf/abo:Gtx	Ljava/util/LinkedList;
    //   250: iload_1
    //   251: invokevirtual 819	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   254: checkcast 428	com/tencent/mm/protocal/protobuf/bzh
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +39 -> 300
    //   264: ldc 158
    //   266: ldc_w 821
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 7
    //   277: getfield 522	com/tencent/mm/protocal/protobuf/bzh:dKr	I
    //   280: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 7
    //   288: getfield 438	com/tencent/mm/protocal/protobuf/bzh:Url	Ljava/lang/String;
    //   291: ldc 129
    //   293: invokestatic 667	com/tencent/mm/sdk/platformtools/bu:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 818	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: iload_1
    //   301: iconst_1
    //   302: iadd
    //   303: istore_1
    //   304: goto -81 -> 223
    //   307: astore 7
    //   309: ldc 158
    //   311: aload 7
    //   313: ldc 129
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 825	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: goto -173 -> 149
    //   325: aload_0
    //   326: getfield 115	com/tencent/mm/plugin/sns/model/bd:zFf	Lcom/tencent/mm/protocal/protobuf/ba;
    //   329: ifnull +14 -> 343
    //   332: aload_0
    //   333: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   336: aload_0
    //   337: getfield 115	com/tencent/mm/plugin/sns/model/bd:zFf	Lcom/tencent/mm/protocal/protobuf/ba;
    //   340: putfield 826	com/tencent/mm/protocal/protobuf/TimeLineObject:zFf	Lcom/tencent/mm/protocal/protobuf/ba;
    //   343: aload_0
    //   344: getfield 127	com/tencent/mm/plugin/sns/model/bd:zFh	Lcom/tencent/mm/protocal/protobuf/egh;
    //   347: ifnull +14 -> 361
    //   350: aload_0
    //   351: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   354: aload_0
    //   355: getfield 127	com/tencent/mm/plugin/sns/model/bd:zFh	Lcom/tencent/mm/protocal/protobuf/egh;
    //   358: putfield 827	com/tencent/mm/protocal/protobuf/TimeLineObject:zFh	Lcom/tencent/mm/protocal/protobuf/egh;
    //   361: aload_0
    //   362: getfield 87	com/tencent/mm/plugin/sns/model/bd:zFd	Lcom/tencent/mm/plugin/sns/storage/p;
    //   365: aload_0
    //   366: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   369: invokevirtual 830	com/tencent/mm/plugin/sns/storage/p:f	(Lcom/tencent/mm/protocal/protobuf/TimeLineObject;)V
    //   372: invokestatic 834	com/tencent/mm/plugin/sns/model/ah:dXE	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   375: aload_0
    //   376: getfield 87	com/tencent/mm/plugin/sns/model/bd:zFd	Lcom/tencent/mm/plugin/sns/storage/p;
    //   379: invokevirtual 840	com/tencent/mm/plugin/sns/storage/q:L	(Lcom/tencent/mm/plugin/sns/storage/p;)I
    //   382: istore_3
    //   383: invokestatic 844	com/tencent/mm/plugin/sns/model/ah:dXL	()Lcom/tencent/mm/plugin/sns/storage/m;
    //   386: astore 8
    //   388: aconst_null
    //   389: astore 7
    //   391: new 184	java/lang/StringBuilder
    //   394: dup
    //   395: ldc_w 846
    //   398: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: getstatic 851	com/tencent/mm/plugin/sns/storage/m:AdP	Ljava/lang/String;
    //   404: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: getstatic 854	com/tencent/mm/plugin/sns/storage/m:AdQ	Ljava/lang/String;
    //   410: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 856
    //   416: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 9
    //   424: aload 8
    //   426: getfield 860	com/tencent/mm/plugin/sns/storage/m:db	Lcom/tencent/mm/sdk/e/e;
    //   429: aload 9
    //   431: aconst_null
    //   432: iconst_2
    //   433: invokeinterface 865 4 0
    //   438: astore 9
    //   440: aload 9
    //   442: invokeinterface 870 1 0
    //   447: ifeq +19 -> 466
    //   450: new 872	com/tencent/mm/plugin/sns/storage/l
    //   453: dup
    //   454: invokespecial 873	com/tencent/mm/plugin/sns/storage/l:<init>	()V
    //   457: astore 7
    //   459: aload 7
    //   461: aload 9
    //   463: invokevirtual 877	com/tencent/mm/plugin/sns/storage/l:convertFrom	(Landroid/database/Cursor;)V
    //   466: aload 9
    //   468: invokeinterface 880 1 0
    //   473: aload 7
    //   475: ifnull +36 -> 511
    //   478: aload 8
    //   480: ldc_w 882
    //   483: iload_3
    //   484: invokestatic 166	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   487: invokevirtual 170	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   490: aload 7
    //   492: getfield 885	com/tencent/mm/plugin/sns/storage/l:field_draft	[B
    //   495: iconst_0
    //   496: invokevirtual 888	com/tencent/mm/plugin/sns/storage/m:b	(Ljava/lang/String;[BI)V
    //   499: aload 8
    //   501: aload 7
    //   503: getfield 891	com/tencent/mm/plugin/sns/storage/l:field_key	Ljava/lang/String;
    //   506: aconst_null
    //   507: iconst_0
    //   508: invokevirtual 888	com/tencent/mm/plugin/sns/storage/m:b	(Ljava/lang/String;[BI)V
    //   511: aload_0
    //   512: getfield 82	com/tencent/mm/plugin/sns/model/bd:zFc	Lcom/tencent/mm/protocal/protobuf/bzi;
    //   515: getfield 652	com/tencent/mm/protocal/protobuf/bzi:HmI	Ljava/util/LinkedList;
    //   518: invokevirtual 341	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   521: astore 9
    //   523: iconst_0
    //   524: istore_2
    //   525: aconst_null
    //   526: astore 7
    //   528: aload 9
    //   530: invokeinterface 347 1 0
    //   535: ifeq +302 -> 837
    //   538: aload 9
    //   540: invokeinterface 351 1 0
    //   545: checkcast 645	com/tencent/mm/protocal/protobuf/bwe
    //   548: astore 8
    //   550: invokestatic 479	com/tencent/mm/plugin/sns/model/ah:dXt	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   553: aload 8
    //   555: getfield 649	com/tencent/mm/protocal/protobuf/bwe:Hjg	I
    //   558: i2l
    //   559: invokevirtual 895	com/tencent/mm/plugin/sns/storage/u:AH	(J)Lcom/tencent/mm/plugin/sns/storage/t;
    //   562: astore 10
    //   564: new 897	com/tencent/mm/protocal/protobuf/bzk
    //   567: dup
    //   568: invokespecial 898	com/tencent/mm/protocal/protobuf/bzk:<init>	()V
    //   571: aload 10
    //   573: getfield 903	com/tencent/mm/plugin/sns/storage/t:Aey	[B
    //   576: invokevirtual 907	com/tencent/mm/protocal/protobuf/bzk:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   579: checkcast 897	com/tencent/mm/protocal/protobuf/bzk
    //   582: astore 11
    //   584: aload_0
    //   585: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   588: getfield 707	com/tencent/mm/protocal/protobuf/TimeLineObject:HUF	Lcom/tencent/mm/protocal/protobuf/en;
    //   591: ifnull +18 -> 609
    //   594: aload 11
    //   596: aload_0
    //   597: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   600: getfield 707	com/tencent/mm/protocal/protobuf/TimeLineObject:HUF	Lcom/tencent/mm/protocal/protobuf/en;
    //   603: getfield 711	com/tencent/mm/protocal/protobuf/en:Id	Ljava/lang/String;
    //   606: putfield 910	com/tencent/mm/protocal/protobuf/bzk:dwb	Ljava/lang/String;
    //   609: aload_0
    //   610: getfield 125	com/tencent/mm/plugin/sns/model/bd:dKw	Lcom/tencent/mm/protocal/protobuf/byg;
    //   613: ifnull +11 -> 624
    //   616: aload_0
    //   617: getfield 125	com/tencent/mm/plugin/sns/model/bd:dKw	Lcom/tencent/mm/protocal/protobuf/byg;
    //   620: iconst_0
    //   621: putfield 913	com/tencent/mm/protocal/protobuf/byg:sVm	I
    //   624: aload 11
    //   626: aload_0
    //   627: getfield 125	com/tencent/mm/plugin/sns/model/bd:dKw	Lcom/tencent/mm/protocal/protobuf/byg;
    //   630: putfield 916	com/tencent/mm/protocal/protobuf/bzk:Hnj	Lcom/tencent/mm/protocal/protobuf/byg;
    //   633: aload 11
    //   635: aload_0
    //   636: getfield 77	com/tencent/mm/plugin/sns/model/bd:zFb	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   639: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   642: getfield 156	com/tencent/mm/protocal/protobuf/abo:Gtw	I
    //   645: putfield 917	com/tencent/mm/protocal/protobuf/bzk:beN	I
    //   648: aload 11
    //   650: getfield 917	com/tencent/mm/protocal/protobuf/bzk:beN	I
    //   653: iconst_1
    //   654: if_icmpeq +13 -> 667
    //   657: aload 11
    //   659: getfield 917	com/tencent/mm/protocal/protobuf/bzk:beN	I
    //   662: bipush 15
    //   664: if_icmpne +22 -> 686
    //   667: aload 11
    //   669: getfield 910	com/tencent/mm/protocal/protobuf/bzk:dwb	Ljava/lang/String;
    //   672: invokestatic 634	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   675: ifne +71 -> 746
    //   678: iconst_5
    //   679: istore_1
    //   680: aload 11
    //   682: iload_1
    //   683: putfield 920	com/tencent/mm/protocal/protobuf/bzk:Hnk	I
    //   686: aload 10
    //   688: aload 11
    //   690: invokevirtual 921	com/tencent/mm/protocal/protobuf/bzk:toByteArray	()[B
    //   693: putfield 903	com/tencent/mm/plugin/sns/storage/t:Aey	[B
    //   696: invokestatic 479	com/tencent/mm/plugin/sns/model/ah:dXt	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   699: aload 8
    //   701: getfield 649	com/tencent/mm/protocal/protobuf/bwe:Hjg	I
    //   704: aload 10
    //   706: invokevirtual 924	com/tencent/mm/plugin/sns/storage/u:a	(ILcom/tencent/mm/plugin/sns/storage/t;)I
    //   709: pop
    //   710: aload 11
    //   712: getfield 927	com/tencent/mm/protocal/protobuf/bzk:md5	Ljava/lang/String;
    //   715: astore 8
    //   717: iload_2
    //   718: iconst_1
    //   719: iadd
    //   720: istore_2
    //   721: aload 8
    //   723: astore 7
    //   725: goto -197 -> 528
    //   728: astore 7
    //   730: aload 9
    //   732: invokeinterface 880 1 0
    //   737: ldc_w 779
    //   740: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   743: aload 7
    //   745: athrow
    //   746: aload 11
    //   748: getfield 916	com/tencent/mm/protocal/protobuf/bzk:Hnj	Lcom/tencent/mm/protocal/protobuf/byg;
    //   751: ifnull +53 -> 804
    //   754: aload 11
    //   756: getfield 917	com/tencent/mm/protocal/protobuf/bzk:beN	I
    //   759: bipush 15
    //   761: if_icmpne +43 -> 804
    //   764: aload 11
    //   766: getfield 916	com/tencent/mm/protocal/protobuf/bzk:Hnj	Lcom/tencent/mm/protocal/protobuf/byg;
    //   769: getfield 930	com/tencent/mm/protocal/protobuf/byg:Hlb	Z
    //   772: ifeq +27 -> 799
    //   775: iconst_1
    //   776: istore_1
    //   777: aload 11
    //   779: iload_1
    //   780: putfield 920	com/tencent/mm/protocal/protobuf/bzk:Hnk	I
    //   783: goto -97 -> 686
    //   786: astore 8
    //   788: ldc 158
    //   790: ldc_w 932
    //   793: invokestatic 419	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: goto -268 -> 528
    //   799: iconst_2
    //   800: istore_1
    //   801: goto -24 -> 777
    //   804: aload_0
    //   805: getfield 934	com/tencent/mm/plugin/sns/model/bd:zEW	Ljava/util/List;
    //   808: iload_2
    //   809: invokeinterface 544 2 0
    //   814: checkcast 469	com/tencent/mm/plugin/sns/data/q
    //   817: getfield 937	com/tencent/mm/plugin/sns/data/q:zuv	Z
    //   820: istore 6
    //   822: iload 6
    //   824: ifeq +8 -> 832
    //   827: iconst_1
    //   828: istore_1
    //   829: goto -149 -> 680
    //   832: iconst_2
    //   833: istore_1
    //   834: goto -154 -> 680
    //   837: ldc 158
    //   839: ldc_w 939
    //   842: iconst_3
    //   843: anewarray 4	java/lang/Object
    //   846: dup
    //   847: iconst_0
    //   848: iload_3
    //   849: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   852: aastore
    //   853: dup
    //   854: iconst_1
    //   855: aload_0
    //   856: getfield 87	com/tencent/mm/plugin/sns/model/bd:zFd	Lcom/tencent/mm/plugin/sns/storage/p;
    //   859: getfield 312	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   862: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   865: aastore
    //   866: dup
    //   867: iconst_2
    //   868: aload 7
    //   870: aastore
    //   871: invokestatic 463	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   874: iload_3
    //   875: ifle +29 -> 904
    //   878: aload_0
    //   879: getfield 87	com/tencent/mm/plugin/sns/model/bd:zFd	Lcom/tencent/mm/plugin/sns/storage/p;
    //   882: getfield 312	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   885: bipush 15
    //   887: if_icmpne +17 -> 904
    //   890: ldc_w 941
    //   893: iload_3
    //   894: i2l
    //   895: invokestatic 947	com/tencent/mm/plugin/sns/storage/x:bn	(Ljava/lang/String;J)Ljava/lang/String;
    //   898: aload 7
    //   900: invokestatic 953	com/tencent/mm/plugin/sns/model/aw:jx	(Ljava/lang/String;Ljava/lang/String;)Z
    //   903: pop
    //   904: ldc 158
    //   906: new 184	java/lang/StringBuilder
    //   909: dup
    //   910: ldc_w 955
    //   913: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   916: iload_3
    //   917: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: ldc_w 957
    //   923: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   929: lload 4
    //   931: lsub
    //   932: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   935: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokestatic 176	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: ldc_w 779
    //   944: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   947: iload_3
    //   948: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	bd
    //   222	612	1	i	int
    //   524	285	2	j	int
    //   382	566	3	k	int
    //   9	921	4	l	long
    //   820	3	6	bool	boolean
    //   36	251	7	localObject1	Object
    //   307	5	7	localException1	Exception
    //   389	335	7	localObject2	Object
    //   728	171	7	str	String
    //   386	336	8	localObject3	Object
    //   786	1	8	localException2	Exception
    //   422	309	9	localObject4	Object
    //   562	143	10	localt	com.tencent.mm.plugin.sns.storage.t
    //   582	196	11	localbzk	com.tencent.mm.protocal.protobuf.bzk
    // Exception table:
    //   from	to	target	type
    //   11	149	307	java/lang/Exception
    //   440	466	728	finally
    //   564	609	786	java/lang/Exception
    //   609	624	786	java/lang/Exception
    //   624	667	786	java/lang/Exception
    //   667	678	786	java/lang/Exception
    //   680	686	786	java/lang/Exception
    //   686	717	786	java/lang/Exception
    //   746	775	786	java/lang/Exception
    //   777	783	786	java/lang/Exception
    //   804	822	786	java/lang/Exception
  }
  
  public final bd fU(List<String> paramList)
  {
    AppMethodBeat.i(96046);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.zFe.ExtFlag = 1;
      AppMethodBeat.o(96046);
      return this;
    }
    paramList = paramList.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      cxn localcxn = new cxn();
      localcxn.aQV(str);
      localLinkedList.add(localcxn);
    }
    this.zFc.GroupUser = localLinkedList;
    if (this.zFe.ExtFlag == 3)
    {
      this.zFe.BlackList = localLinkedList;
      this.zFe.BlackListCount = localLinkedList.size();
    }
    for (;;)
    {
      AppMethodBeat.o(96046);
      return this;
      if (this.zFe.ExtFlag == 5)
      {
        this.zFe.GroupUser = localLinkedList;
        this.zFe.GroupUserCount = localLinkedList.size();
      }
    }
  }
  
  public final void fV(List<q> paramList)
  {
    AppMethodBeat.i(96058);
    this.zEW = paramList;
    paramList = ah.dXt().ga(this.zEW);
    Object localObject1 = new LinkedList();
    if (paramList == null)
    {
      AppMethodBeat.o(96058);
      return;
    }
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      q localq = (q)((Iterator)localObject2).next();
      bwe localbwe = new bwe();
      localbwe.Hjg = localq.dKr;
      ((LinkedList)localObject1).add(localbwe);
    }
    this.zFc.HmI = ((LinkedList)localObject1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (q)paramList.next();
      localObject2 = new bzj();
      ((bzj)localObject2).Hnb = 0.0F;
      ((bzj)localObject2).Hna = 0.0F;
      ((bzj)localObject2).Hnc = 0.0F;
      if ((((q)localObject1).height > 0) && (((q)localObject1).width > 0) && (((q)localObject1).fileSize > 0))
      {
        ((bzj)localObject2).Hnb = ((q)localObject1).height;
        ((bzj)localObject2).Hna = ((q)localObject1).width;
        ((bzj)localObject2).Hnc = ((q)localObject1).fileSize;
      }
      localObject1 = h.a("Locall_path" + ((q)localObject1).dKr, ((q)localObject1).type, "", "", 0, 0, this.zur, "", (bzj)localObject2);
      this.zFb.HUG.Gtx.add(localObject1);
    }
    AppMethodBeat.o(96058);
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96059);
    dhd localdhd = new dhd();
    localdhd.FOU = paramString1;
    localdhd.FOV = paramString2;
    localdhd.FOW = paramString3;
    localdhd.AkD = paramInt1;
    localdhd.AkE = paramInt2;
    this.zFc.HmS = localdhd;
    AppMethodBeat.o(96059);
  }
  
  public final boolean jA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96053);
    String str = ah.getAccSnsTmpPath() + g.getMessageDigest(paramString1.getBytes());
    aAK(str);
    o.mF(paramString1, str);
    paramString1 = jz("", str);
    if (paramString1 == null)
    {
      ae.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      AppMethodBeat.o(96053);
      return false;
    }
    paramString1.Desc = paramString2;
    if (bu.isNullOrNil(paramString1.Title)) {
      paramString1.Title = paramString2;
    }
    this.zFb.HUG.Gtx.add(paramString1);
    paramString2 = new bwe();
    paramString2.Hjg = paramString1.dKr;
    this.zFc.HmI.add(paramString2);
    AppMethodBeat.o(96053);
    return true;
  }
  
  public final bd jy(String paramString1, String paramString2)
  {
    this.zFc.token = paramString1;
    this.zFc.HmQ = paramString2;
    return this;
  }
  
  public final void setSessionId(String paramString)
  {
    this.zFc.sessionId = paramString;
  }
  
  public final boolean z(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(96051);
    Object localObject = c.yho;
    localObject = c.axr(paramString1);
    if (localObject != null) {
      ae.i("MicroMsg.UploadPackHelper", "addSightObjectByPath commit video_info:".concat(String.valueOf(localObject)));
    }
    for (float f = ((c.a)localObject).duration / 1000.0F;; f = 0.0F)
    {
      localObject = ah.getAccSnsTmpPath() + g.getMessageDigest(paramString1.getBytes());
      aAK((String)localObject);
      o.mF(paramString1, (String)localObject);
      paramString1 = ah.getAccSnsTmpPath() + g.getMessageDigest(paramString2.getBytes());
      o.mF(paramString2, paramString1);
      paramString1 = b("", (String)localObject, paramString1, paramString4, "", "");
      if (paramString1 == null)
      {
        ae.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
        AppMethodBeat.o(96051);
        return false;
      }
      paramString1.Desc = paramString3;
      if (bu.isNullOrNil(paramString1.Title)) {
        paramString1.Title = paramString3;
      }
      paramString1.HmF = f;
      this.zFb.HUG.Gtx.add(paramString1);
      paramString2 = new bwe();
      paramString2.Hjg = paramString1.dKr;
      this.zFc.HmI.add(paramString2);
      AppMethodBeat.o(96051);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bd
 * JD-Core Version:    0.7.0.1
 */