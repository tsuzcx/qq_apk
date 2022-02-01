package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bc
{
  private static final Pattern jrU;
  public int beN;
  public bxm dJi;
  private String fFK;
  int zdA;
  int zdB;
  List<com.tencent.mm.plugin.sns.data.p> znH;
  String znI;
  String znJ;
  LinkedList<dhj> znK;
  LinkedList<Long> znL;
  public TimeLineObject znM;
  public byo znN;
  com.tencent.mm.plugin.sns.storage.p znO;
  SnsObject znP;
  ba znQ;
  public dkh znR;
  public eeq znS;
  private int znT;
  private String znU;
  private boolean znV;
  
  static
  {
    AppMethodBeat.i(96061);
    jrU = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(96061);
  }
  
  public bc(int paramInt)
  {
    AppMethodBeat.i(96035);
    this.znM = h.aLm();
    this.znN = new byo();
    this.znO = new com.tencent.mm.plugin.sns.storage.p();
    this.znP = null;
    Object localObject = new ba();
    ((ba)localObject).Fsy = new ay();
    ((ba)localObject).FsA = new dy();
    ((ba)localObject).FsB = new ep();
    this.znQ = ((ba)localObject);
    this.znR = new dkh();
    this.dJi = new bxm();
    this.znS = null;
    this.fFK = "";
    this.znT = 1;
    this.znU = "";
    this.znV = false;
    this.fFK = ag.dTJ();
    this.beN = paramInt;
    this.znM.HAT.GaP = paramInt;
    ad.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(paramInt)));
    this.znM.GSK = 0;
    this.znM.nDo = this.fFK;
    this.znN.hCW = g.getMessageDigest((ag.dTJ() + bt.HI() + System.currentTimeMillis()).getBytes());
    this.znN.GTf = 0;
    this.znN.GTg = 0;
    this.znN.GSK = 0;
    this.znN.GTj = 0;
    this.znN.hfV = 0;
    this.znN.GTl = 0;
    this.znN.GTn = 0;
    localObject = new SnsObject();
    ((SnsObject)localObject).Id = 0L;
    ((SnsObject)localObject).CreateTime = 0;
    ((SnsObject)localObject).LikeFlag = 0;
    ((SnsObject)localObject).Username = ag.dTJ();
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
    this.znP = ((SnsObject)localObject);
    localObject = this.znO;
    ((com.tencent.mm.plugin.sns.storage.p)localObject).field_localFlag |= 0x10;
    this.znO.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    this.znO.field_type = paramInt;
    this.znO.field_userName = this.fFK;
    this.znO.field_pravited = 0;
    this.znO.field_stringSeq = "0000099999999999999999999";
    this.znO.QJ(2);
    this.znO.dYH();
    if ((paramInt == 1) || (paramInt == 2)) {
      this.znO.QJ(4);
    }
    if (paramInt == 7) {
      this.znO.QN(2);
    }
    this.znL = new LinkedList();
    this.znN.GTm = this.znL;
    localObject = this.znL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      long l = ((Long)((Iterator)localObject).next()).longValue();
      dfv localdfv = new dfv();
      localdfv.Hul = l;
      this.znP.GroupList.add(localdfv);
    }
    this.znP.GroupCount = this.znL.size();
    AppMethodBeat.o(96035);
  }
  
  public static byn aE(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96050);
    byn localbyn = h.aLn();
    localbyn.Id = paramString1;
    ad.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbyn.nEf = 2;
    localbyn.Url = paramString2;
    localbyn.GEe = 0;
    localbyn.GSI = paramString3;
    localbyn.GSJ = 0;
    localbyn.GSO = 1;
    AppMethodBeat.o(96050);
    return localbyn;
  }
  
  private static String azi(String paramString)
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
        str1 = jrU.matcher(str1).replaceAll("\n\n");
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
  
  public static void azt(String paramString)
  {
    AppMethodBeat.i(96052);
    i.aYg(i.aYr(paramString));
    AppMethodBeat.o(96052);
  }
  
  public static byn b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(96048);
    byn localbyn = h.aLn();
    localbyn.Id = paramString1;
    ad.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { Integer.valueOf(6), paramString2, paramString4, paramString5, paramString6 });
    localbyn.nEf = 6;
    if (i.aYo(paramString2) <= 0L)
    {
      AppMethodBeat.o(96048);
      return null;
    }
    paramString1 = new com.tencent.mm.plugin.sns.data.p(paramString2, 6);
    paramString1.zdE = paramString4;
    paramString2 = ag.dTT().a(paramString1, paramString2, paramString3, paramString5, paramString6);
    if ((paramString2.height > 0) && (paramString2.width > 0) && (paramString2.fileSize > 0))
    {
      paramString1 = new byp();
      paramString1.GTA = paramString2.height;
      paramString1.GTz = paramString2.width;
      paramString1.GTB = paramString2.fileSize;
    }
    for (;;)
    {
      localbyn.Id = ("Locall_path" + paramString2.dJd);
      localbyn.GSL = paramString1;
      localbyn.dJd = paramString2.dJd;
      AppMethodBeat.o(96048);
      return localbyn;
      paramString1 = null;
    }
  }
  
  private static byn js(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(96049);
    byn localbyn = h.aLn();
    localbyn.Id = paramString1;
    ad.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbyn.nEf = 2;
    if (i.aYo(paramString2) <= 0L)
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString1 = ag.getAccSnsTmpPath() + g.getMessageDigest(new StringBuilder().append(paramString2).append(System.currentTimeMillis()).toString().getBytes());
    i.mz(paramString2, paramString1);
    paramString1 = new com.tencent.mm.plugin.sns.data.p(paramString1, 2);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = ag.dTT().fR(paramString2);
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
          paramString1 = new byp();
          paramString1.GTA = paramString2.height;
          paramString1.GTz = paramString2.width;
          paramString1.GTB = paramString2.fileSize;
        }
      }
    }
    localbyn.Id = ("Locall_path" + paramString2.dJd);
    localbyn.GSL = paramString1;
    localbyn.dJd = paramString2.dJd;
    AppMethodBeat.o(96049);
    return localbyn;
  }
  
  private static byn v(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96047);
    if (bt.cC(paramArrayOfByte))
    {
      ad.e("MicroMsg.UploadPackHelper", f.abi() + " attachBuf is null");
      AppMethodBeat.o(96047);
      return null;
    }
    String str = ag.getAccSnsTmpPath() + g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
    i.aYg(ag.getAccSnsTmpPath());
    ad.d("MicroMsg.UploadPackHelper", f.abi() + " buildUploadAttachInfo file:" + str);
    if (i.f(str, paramArrayOfByte, paramArrayOfByte.length) < 0)
    {
      ad.e("MicroMsg.UploadPackHelper", f.abi() + " writeFile error file:" + str);
      AppMethodBeat.o(96047);
      return null;
    }
    paramString = js(paramString, str);
    AppMethodBeat.o(96047);
    return paramString;
  }
  
  public final bc Qb(int paramInt)
  {
    this.znM.HAV = 1;
    this.znM.HAW = paramInt;
    return this;
  }
  
  public final bc Qc(int paramInt)
  {
    this.znM.hzT = paramInt;
    return this;
  }
  
  public final void Qd(int paramInt)
  {
    AppMethodBeat.i(96039);
    ad.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(paramInt)));
    this.znN.GTl = paramInt;
    AppMethodBeat.o(96039);
  }
  
  public final bc Qe(int paramInt)
  {
    AppMethodBeat.i(96040);
    this.zdB = paramInt;
    this.znN.GSK = paramInt;
    this.znM.GSK = paramInt;
    if (paramInt > 0)
    {
      this.znO.field_pravited = paramInt;
      this.znO.dYE();
      this.znO.QN(2);
      this.znO.dYI();
    }
    AppMethodBeat.o(96040);
    return this;
  }
  
  public final bc Qf(int paramInt)
  {
    this.zdA = paramInt;
    this.znN.GTg = paramInt;
    return this;
  }
  
  public final bc Qg(int paramInt)
  {
    this.znN.GTn = paramInt;
    return this;
  }
  
  public final bc Qh(int paramInt)
  {
    if (paramInt == 1) {
      this.znP.ExtFlag = 3;
    }
    for (;;)
    {
      this.znN.GTq = paramInt;
      return this;
      if (paramInt == 0) {
        this.znP.ExtFlag = 5;
      }
    }
  }
  
  public final bc a(bvq parambvq)
  {
    if (parambvq == null) {
      return this;
    }
    this.znM.HAR = parambvq;
    return this;
  }
  
  public final void a(b paramb)
  {
    if (paramb != null) {
      this.znM.HAT.GaU = paramb.inc;
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(96056);
    paramArrayOfByte = v("", paramArrayOfByte);
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
      paramArrayOfByte.zQh = paramString3;
    }
    if (!bt.isNullOrNil(paramString2)) {
      paramArrayOfByte.Title = paramString2;
    }
    if (!bt.isNullOrNil(paramString1)) {
      paramArrayOfByte.Desc = paramString1;
    }
    this.znM.HAT.GaQ.add(paramArrayOfByte);
    paramString1 = new bvk();
    paramString1.GPE = paramArrayOfByte.dJd;
    this.znN.GTh.add(paramString1);
    AppMethodBeat.o(96056);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(96057);
    paramArrayOfByte = v("", paramArrayOfByte);
    if ((paramArrayOfByte == null) || ((bt.isNullOrNil(paramString2)) && (bt.isNullOrNil(paramString3))))
    {
      ad.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
      AppMethodBeat.o(96057);
      return false;
    }
    if (!bt.isNullOrNil(paramString1)) {
      this.znM.HAT.Url = paramString1;
    }
    if (!bt.isNullOrNil(paramString3))
    {
      paramArrayOfByte.Url = paramString3;
      paramArrayOfByte.GEe = 0;
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString2))
      {
        paramArrayOfByte.GSM = paramString2;
        paramArrayOfByte.GSN = 0;
      }
      paramArrayOfByte.nEf = paramInt;
      paramArrayOfByte.Title = bt.bI(paramString4, "");
      paramArrayOfByte.Desc = bt.bI(paramString5, "");
      paramArrayOfByte.songAlbumUrl = paramString6;
      paramArrayOfByte.songLyric = paramString7;
      this.znM.HAT.GaQ.add(paramArrayOfByte);
      paramString1 = new bvk();
      paramString1.GPE = paramArrayOfByte.dJd;
      this.znN.GTh.add(paramString1);
      AppMethodBeat.o(96057);
      return true;
      if (!bt.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Url = paramString2;
        paramArrayOfByte.GEe = 0;
      }
    }
  }
  
  public final bc aD(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96038);
    ay localay = this.znQ.Fsy;
    Object localObject = paramString1;
    if (bt.isNullOrNil(paramString1)) {
      localObject = "";
    }
    localay.iht = ((String)localObject);
    localObject = this.znQ.Fsy;
    paramString1 = paramString2;
    if (bt.isNullOrNil(paramString2)) {
      paramString1 = "";
    }
    ((ay)localObject).Fst = paramString1;
    paramString2 = this.znQ.Fsy;
    paramString1 = paramString3;
    if (bt.isNullOrNil(paramString3)) {
      paramString1 = "";
    }
    paramString2.Fsu = paramString1;
    AppMethodBeat.o(96038);
    return this;
  }
  
  public final bc aU(LinkedList<dhj> paramLinkedList)
  {
    AppMethodBeat.i(96041);
    this.znK = paramLinkedList;
    this.znN.GTi = paramLinkedList;
    paramLinkedList = this.znK.iterator();
    while (paramLinkedList.hasNext())
    {
      dhj localdhj = (dhj)paramLinkedList.next();
      dfn localdfn = new dfn();
      localdfn.Username = localdhj.nDo;
      this.znP.WithUserList.add(localdfn);
    }
    this.znP.WithUserCount = this.znK.size();
    this.znP.WithUserListCount = this.znK.size();
    AppMethodBeat.o(96041);
    return this;
  }
  
  public final bc azj(String paramString)
  {
    AppMethodBeat.i(96037);
    this.znI = azi(paramString);
    this.znM.HAQ = this.znI;
    AppMethodBeat.o(96037);
    return this;
  }
  
  public final bc azk(String paramString)
  {
    this.znM.HAX = paramString;
    this.znQ.Fsy.Fss = paramString;
    return this;
  }
  
  public final bc azl(String paramString)
  {
    this.znM.zTv = paramString;
    return this;
  }
  
  public final bc azm(String paramString)
  {
    this.znJ = paramString;
    this.znM.HAT.Desc = paramString;
    return this;
  }
  
  public final bc azn(String paramString)
  {
    this.znM.HAT.Url = paramString;
    return this;
  }
  
  public final bc azo(String paramString)
  {
    this.znM.HAT.Title = paramString;
    return this;
  }
  
  public final bc azp(String paramString)
  {
    AppMethodBeat.i(96042);
    en localen2 = this.znM.HAS;
    en localen1 = localen2;
    if (localen2 == null) {
      localen1 = new en();
    }
    localen1.Id = paramString;
    this.znM.HAS = localen1;
    AppMethodBeat.o(96042);
    return this;
  }
  
  public final bc azq(String paramString)
  {
    AppMethodBeat.i(96043);
    en localen2 = this.znM.HAS;
    en localen1 = localen2;
    if (localen2 == null) {
      localen1 = new en();
    }
    localen1.uiR = paramString;
    this.znM.HAS = localen1;
    AppMethodBeat.o(96043);
    return this;
  }
  
  public final bc azr(String paramString)
  {
    AppMethodBeat.i(96044);
    this.znM.jYs = bt.nullAsNil(paramString);
    AppMethodBeat.o(96044);
    return this;
  }
  
  public final bc azs(String paramString)
  {
    AppMethodBeat.i(96045);
    this.znM.EUR = bt.nullAsNil(paramString);
    AppMethodBeat.o(96045);
    return this;
  }
  
  public final void azu(String paramString)
  {
    this.znN.dHu = paramString;
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
      ad.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(96054);
      return false;
    }
    paramString1.Desc = paramString3;
    if (paramInt > 0) {
      paramString1.subType = paramInt;
    }
    if (!bt.isNullOrNil(paramString4)) {
      paramString1.zQh = paramString4;
    }
    this.znM.HAT.GaQ.add(paramString1);
    AppMethodBeat.o(96054);
    return true;
  }
  
  public final bc cc(int paramInt, String paramString)
  {
    this.znT = paramInt;
    this.znU = paramString;
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
    //   12: getfield 82	com/tencent/mm/plugin/sns/model/bc:znN	Lcom/tencent/mm/protocal/protobuf/byo;
    //   15: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   18: putfield 782	com/tencent/mm/protocal/protobuf/byo:GTk	J
    //   21: aload_0
    //   22: getfield 82	com/tencent/mm/plugin/sns/model/bc:znN	Lcom/tencent/mm/protocal/protobuf/byo;
    //   25: iconst_0
    //   26: putfield 232	com/tencent/mm/protocal/protobuf/byo:hfV	I
    //   29: new 784	com/tencent/mm/protocal/protobuf/cfy
    //   32: dup
    //   33: invokespecial 785	com/tencent/mm/protocal/protobuf/cfy:<init>	()V
    //   36: astore 7
    //   38: aload 7
    //   40: aload_0
    //   41: getfield 133	com/tencent/mm/plugin/sns/model/bc:znT	I
    //   44: putfield 788	com/tencent/mm/protocal/protobuf/cfy:Fwz	I
    //   47: aload 7
    //   49: aload_0
    //   50: getfield 135	com/tencent/mm/plugin/sns/model/bc:znU	Ljava/lang/String;
    //   53: putfield 791	com/tencent/mm/protocal/protobuf/cfy:ufi	Ljava/lang/String;
    //   56: aload_0
    //   57: getfield 82	com/tencent/mm/plugin/sns/model/bc:znN	Lcom/tencent/mm/protocal/protobuf/byo;
    //   60: aload 7
    //   62: putfield 795	com/tencent/mm/protocal/protobuf/byo:GTy	Lcom/tencent/mm/protocal/protobuf/cfy;
    //   65: aload_0
    //   66: getfield 87	com/tencent/mm/plugin/sns/model/bc:znO	Lcom/tencent/mm/plugin/sns/storage/p;
    //   69: aload_0
    //   70: getfield 89	com/tencent/mm/plugin/sns/model/bc:znP	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   73: invokevirtual 798	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   76: invokevirtual 801	com/tencent/mm/plugin/sns/storage/p:bI	([B)V
    //   79: aload_0
    //   80: getfield 87	com/tencent/mm/plugin/sns/model/bc:znO	Lcom/tencent/mm/plugin/sns/storage/p;
    //   83: aload_0
    //   84: getfield 82	com/tencent/mm/plugin/sns/model/bc:znN	Lcom/tencent/mm/protocal/protobuf/byo;
    //   87: invokevirtual 802	com/tencent/mm/protocal/protobuf/byo:toByteArray	()[B
    //   90: putfield 806	com/tencent/mm/plugin/sns/storage/p:field_postBuf	[B
    //   93: ldc 158
    //   95: new 184	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 808
    //   102: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 89	com/tencent/mm/plugin/sns/model/bc:znP	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   109: invokevirtual 809	java/lang/Object:toString	()Ljava/lang/String;
    //   112: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 176	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: ldc 158
    //   123: new 184	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 811
    //   130: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 82	com/tencent/mm/plugin/sns/model/bc:znN	Lcom/tencent/mm/protocal/protobuf/byo;
    //   137: invokevirtual 809	java/lang/Object:toString	()Ljava/lang/String;
    //   140: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 176	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: ldc 158
    //   151: new 184	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 813
    //   158: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   165: invokevirtual 809	java/lang/Object:toString	()Ljava/lang/String;
    //   168: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 176	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   181: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HAT	Lcom/tencent/mm/protocal/protobuf/abf;
    //   184: getfield 643	com/tencent/mm/protocal/protobuf/abf:GaQ	Ljava/util/LinkedList;
    //   187: ifnull +138 -> 325
    //   190: ldc 158
    //   192: ldc_w 815
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_0
    //   202: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   205: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HAT	Lcom/tencent/mm/protocal/protobuf/abf;
    //   208: getfield 643	com/tencent/mm/protocal/protobuf/abf:GaQ	Ljava/util/LinkedList;
    //   211: invokevirtual 373	java/util/LinkedList:size	()I
    //   214: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: invokestatic 817	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: iconst_0
    //   222: istore_1
    //   223: iload_1
    //   224: aload_0
    //   225: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   228: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HAT	Lcom/tencent/mm/protocal/protobuf/abf;
    //   231: getfield 643	com/tencent/mm/protocal/protobuf/abf:GaQ	Ljava/util/LinkedList;
    //   234: invokevirtual 373	java/util/LinkedList:size	()I
    //   237: if_icmpge +88 -> 325
    //   240: aload_0
    //   241: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   244: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HAT	Lcom/tencent/mm/protocal/protobuf/abf;
    //   247: getfield 643	com/tencent/mm/protocal/protobuf/abf:GaQ	Ljava/util/LinkedList;
    //   250: iload_1
    //   251: invokevirtual 818	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   254: checkcast 385	com/tencent/mm/protocal/protobuf/byn
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +39 -> 300
    //   264: ldc 158
    //   266: ldc_w 820
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 7
    //   277: getfield 522	com/tencent/mm/protocal/protobuf/byn:dJd	I
    //   280: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 7
    //   288: getfield 395	com/tencent/mm/protocal/protobuf/byn:Url	Ljava/lang/String;
    //   291: ldc 129
    //   293: invokestatic 667	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 817	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   319: invokestatic 824	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: goto -173 -> 149
    //   325: aload_0
    //   326: getfield 115	com/tencent/mm/plugin/sns/model/bc:znQ	Lcom/tencent/mm/protocal/protobuf/ba;
    //   329: ifnull +14 -> 343
    //   332: aload_0
    //   333: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   336: aload_0
    //   337: getfield 115	com/tencent/mm/plugin/sns/model/bc:znQ	Lcom/tencent/mm/protocal/protobuf/ba;
    //   340: putfield 825	com/tencent/mm/protocal/protobuf/TimeLineObject:znQ	Lcom/tencent/mm/protocal/protobuf/ba;
    //   343: aload_0
    //   344: getfield 127	com/tencent/mm/plugin/sns/model/bc:znS	Lcom/tencent/mm/protocal/protobuf/eeq;
    //   347: ifnull +14 -> 361
    //   350: aload_0
    //   351: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   354: aload_0
    //   355: getfield 127	com/tencent/mm/plugin/sns/model/bc:znS	Lcom/tencent/mm/protocal/protobuf/eeq;
    //   358: putfield 826	com/tencent/mm/protocal/protobuf/TimeLineObject:znS	Lcom/tencent/mm/protocal/protobuf/eeq;
    //   361: aload_0
    //   362: getfield 87	com/tencent/mm/plugin/sns/model/bc:znO	Lcom/tencent/mm/plugin/sns/storage/p;
    //   365: aload_0
    //   366: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   369: invokevirtual 829	com/tencent/mm/plugin/sns/storage/p:f	(Lcom/tencent/mm/protocal/protobuf/TimeLineObject;)V
    //   372: invokestatic 833	com/tencent/mm/plugin/sns/model/ag:dUe	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   375: aload_0
    //   376: getfield 87	com/tencent/mm/plugin/sns/model/bc:znO	Lcom/tencent/mm/plugin/sns/storage/p;
    //   379: invokevirtual 839	com/tencent/mm/plugin/sns/storage/q:L	(Lcom/tencent/mm/plugin/sns/storage/p;)I
    //   382: istore_3
    //   383: invokestatic 843	com/tencent/mm/plugin/sns/model/ag:dUl	()Lcom/tencent/mm/plugin/sns/storage/m;
    //   386: astore 8
    //   388: aconst_null
    //   389: astore 7
    //   391: new 184	java/lang/StringBuilder
    //   394: dup
    //   395: ldc_w 845
    //   398: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: getstatic 850	com/tencent/mm/plugin/sns/storage/m:zMI	Ljava/lang/String;
    //   404: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: getstatic 853	com/tencent/mm/plugin/sns/storage/m:zMJ	Ljava/lang/String;
    //   410: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 855
    //   416: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 9
    //   424: aload 8
    //   426: getfield 859	com/tencent/mm/plugin/sns/storage/m:db	Lcom/tencent/mm/sdk/e/e;
    //   429: aload 9
    //   431: aconst_null
    //   432: iconst_2
    //   433: invokeinterface 864 4 0
    //   438: astore 9
    //   440: aload 9
    //   442: invokeinterface 869 1 0
    //   447: ifeq +19 -> 466
    //   450: new 871	com/tencent/mm/plugin/sns/storage/l
    //   453: dup
    //   454: invokespecial 872	com/tencent/mm/plugin/sns/storage/l:<init>	()V
    //   457: astore 7
    //   459: aload 7
    //   461: aload 9
    //   463: invokevirtual 876	com/tencent/mm/plugin/sns/storage/l:convertFrom	(Landroid/database/Cursor;)V
    //   466: aload 9
    //   468: invokeinterface 879 1 0
    //   473: aload 7
    //   475: ifnull +36 -> 511
    //   478: aload 8
    //   480: ldc_w 881
    //   483: iload_3
    //   484: invokestatic 166	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   487: invokevirtual 170	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   490: aload 7
    //   492: getfield 884	com/tencent/mm/plugin/sns/storage/l:field_draft	[B
    //   495: iconst_0
    //   496: invokevirtual 887	com/tencent/mm/plugin/sns/storage/m:b	(Ljava/lang/String;[BI)V
    //   499: aload 8
    //   501: aload 7
    //   503: getfield 890	com/tencent/mm/plugin/sns/storage/l:field_key	Ljava/lang/String;
    //   506: aconst_null
    //   507: iconst_0
    //   508: invokevirtual 887	com/tencent/mm/plugin/sns/storage/m:b	(Ljava/lang/String;[BI)V
    //   511: aload_0
    //   512: getfield 82	com/tencent/mm/plugin/sns/model/bc:znN	Lcom/tencent/mm/protocal/protobuf/byo;
    //   515: getfield 652	com/tencent/mm/protocal/protobuf/byo:GTh	Ljava/util/LinkedList;
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
    //   545: checkcast 645	com/tencent/mm/protocal/protobuf/bvk
    //   548: astore 8
    //   550: invokestatic 479	com/tencent/mm/plugin/sns/model/ag:dTT	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   553: aload 8
    //   555: getfield 649	com/tencent/mm/protocal/protobuf/bvk:GPE	I
    //   558: i2l
    //   559: invokevirtual 894	com/tencent/mm/plugin/sns/storage/u:Aj	(J)Lcom/tencent/mm/plugin/sns/storage/t;
    //   562: astore 10
    //   564: new 896	com/tencent/mm/protocal/protobuf/byq
    //   567: dup
    //   568: invokespecial 897	com/tencent/mm/protocal/protobuf/byq:<init>	()V
    //   571: aload 10
    //   573: getfield 902	com/tencent/mm/plugin/sns/storage/t:zNr	[B
    //   576: invokevirtual 906	com/tencent/mm/protocal/protobuf/byq:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   579: checkcast 896	com/tencent/mm/protocal/protobuf/byq
    //   582: astore 11
    //   584: aload_0
    //   585: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   588: getfield 736	com/tencent/mm/protocal/protobuf/TimeLineObject:HAS	Lcom/tencent/mm/protocal/protobuf/en;
    //   591: ifnull +18 -> 609
    //   594: aload 11
    //   596: aload_0
    //   597: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   600: getfield 736	com/tencent/mm/protocal/protobuf/TimeLineObject:HAS	Lcom/tencent/mm/protocal/protobuf/en;
    //   603: getfield 740	com/tencent/mm/protocal/protobuf/en:Id	Ljava/lang/String;
    //   606: putfield 909	com/tencent/mm/protocal/protobuf/byq:duW	Ljava/lang/String;
    //   609: aload_0
    //   610: getfield 125	com/tencent/mm/plugin/sns/model/bc:dJi	Lcom/tencent/mm/protocal/protobuf/bxm;
    //   613: ifnull +11 -> 624
    //   616: aload_0
    //   617: getfield 125	com/tencent/mm/plugin/sns/model/bc:dJi	Lcom/tencent/mm/protocal/protobuf/bxm;
    //   620: iconst_0
    //   621: putfield 912	com/tencent/mm/protocal/protobuf/bxm:sJZ	I
    //   624: aload 11
    //   626: aload_0
    //   627: getfield 125	com/tencent/mm/plugin/sns/model/bc:dJi	Lcom/tencent/mm/protocal/protobuf/bxm;
    //   630: putfield 915	com/tencent/mm/protocal/protobuf/byq:GTI	Lcom/tencent/mm/protocal/protobuf/bxm;
    //   633: aload 11
    //   635: aload_0
    //   636: getfield 77	com/tencent/mm/plugin/sns/model/bc:znM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   639: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:HAT	Lcom/tencent/mm/protocal/protobuf/abf;
    //   642: getfield 156	com/tencent/mm/protocal/protobuf/abf:GaP	I
    //   645: putfield 916	com/tencent/mm/protocal/protobuf/byq:beN	I
    //   648: aload 11
    //   650: getfield 916	com/tencent/mm/protocal/protobuf/byq:beN	I
    //   653: iconst_1
    //   654: if_icmpeq +13 -> 667
    //   657: aload 11
    //   659: getfield 916	com/tencent/mm/protocal/protobuf/byq:beN	I
    //   662: bipush 15
    //   664: if_icmpne +22 -> 686
    //   667: aload 11
    //   669: getfield 909	com/tencent/mm/protocal/protobuf/byq:duW	Ljava/lang/String;
    //   672: invokestatic 634	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   675: ifne +71 -> 746
    //   678: iconst_5
    //   679: istore_1
    //   680: aload 11
    //   682: iload_1
    //   683: putfield 919	com/tencent/mm/protocal/protobuf/byq:GTJ	I
    //   686: aload 10
    //   688: aload 11
    //   690: invokevirtual 920	com/tencent/mm/protocal/protobuf/byq:toByteArray	()[B
    //   693: putfield 902	com/tencent/mm/plugin/sns/storage/t:zNr	[B
    //   696: invokestatic 479	com/tencent/mm/plugin/sns/model/ag:dTT	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   699: aload 8
    //   701: getfield 649	com/tencent/mm/protocal/protobuf/bvk:GPE	I
    //   704: aload 10
    //   706: invokevirtual 923	com/tencent/mm/plugin/sns/storage/u:a	(ILcom/tencent/mm/plugin/sns/storage/t;)I
    //   709: pop
    //   710: aload 11
    //   712: getfield 926	com/tencent/mm/protocal/protobuf/byq:md5	Ljava/lang/String;
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
    //   732: invokeinterface 879 1 0
    //   737: ldc_w 779
    //   740: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   743: aload 7
    //   745: athrow
    //   746: aload 11
    //   748: getfield 915	com/tencent/mm/protocal/protobuf/byq:GTI	Lcom/tencent/mm/protocal/protobuf/bxm;
    //   751: ifnull +53 -> 804
    //   754: aload 11
    //   756: getfield 916	com/tencent/mm/protocal/protobuf/byq:beN	I
    //   759: bipush 15
    //   761: if_icmpne +43 -> 804
    //   764: aload 11
    //   766: getfield 915	com/tencent/mm/protocal/protobuf/byq:GTI	Lcom/tencent/mm/protocal/protobuf/bxm;
    //   769: getfield 929	com/tencent/mm/protocal/protobuf/bxm:GRA	Z
    //   772: ifeq +27 -> 799
    //   775: iconst_1
    //   776: istore_1
    //   777: aload 11
    //   779: iload_1
    //   780: putfield 919	com/tencent/mm/protocal/protobuf/byq:GTJ	I
    //   783: goto -97 -> 686
    //   786: astore 8
    //   788: ldc 158
    //   790: ldc_w 931
    //   793: invokestatic 438	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: goto -268 -> 528
    //   799: iconst_2
    //   800: istore_1
    //   801: goto -24 -> 777
    //   804: aload_0
    //   805: getfield 933	com/tencent/mm/plugin/sns/model/bc:znH	Ljava/util/List;
    //   808: iload_2
    //   809: invokeinterface 544 2 0
    //   814: checkcast 469	com/tencent/mm/plugin/sns/data/p
    //   817: getfield 936	com/tencent/mm/plugin/sns/data/p:zdF	Z
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
    //   839: ldc_w 938
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
    //   856: getfield 87	com/tencent/mm/plugin/sns/model/bc:znO	Lcom/tencent/mm/plugin/sns/storage/p;
    //   859: getfield 312	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   862: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   865: aastore
    //   866: dup
    //   867: iconst_2
    //   868: aload 7
    //   870: aastore
    //   871: invokestatic 463	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   874: iload_3
    //   875: ifle +29 -> 904
    //   878: aload_0
    //   879: getfield 87	com/tencent/mm/plugin/sns/model/bc:znO	Lcom/tencent/mm/plugin/sns/storage/p;
    //   882: getfield 312	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   885: bipush 15
    //   887: if_icmpne +17 -> 904
    //   890: ldc_w 940
    //   893: iload_3
    //   894: i2l
    //   895: invokestatic 946	com/tencent/mm/plugin/sns/storage/x:bm	(Ljava/lang/String;J)Ljava/lang/String;
    //   898: aload 7
    //   900: invokestatic 952	com/tencent/mm/plugin/sns/model/av:jq	(Ljava/lang/String;Ljava/lang/String;)Z
    //   903: pop
    //   904: ldc 158
    //   906: new 184	java/lang/StringBuilder
    //   909: dup
    //   910: ldc_w 954
    //   913: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   916: iload_3
    //   917: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: ldc_w 956
    //   923: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   929: lload 4
    //   931: lsub
    //   932: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   935: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokestatic 176	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: ldc_w 779
    //   944: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   947: iload_3
    //   948: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	bc
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
    //   582	196	11	localbyq	com.tencent.mm.protocal.protobuf.byq
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
  
  public final bc fL(List<String> paramList)
  {
    AppMethodBeat.i(96046);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.znP.ExtFlag = 1;
      AppMethodBeat.o(96046);
      return this;
    }
    paramList = paramList.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      cwt localcwt = new cwt();
      localcwt.aPy(str);
      localLinkedList.add(localcwt);
    }
    this.znN.GroupUser = localLinkedList;
    if (this.znP.ExtFlag == 3)
    {
      this.znP.BlackList = localLinkedList;
      this.znP.BlackListCount = localLinkedList.size();
    }
    for (;;)
    {
      AppMethodBeat.o(96046);
      return this;
      if (this.znP.ExtFlag == 5)
      {
        this.znP.GroupUser = localLinkedList;
        this.znP.GroupUserCount = localLinkedList.size();
      }
    }
  }
  
  public final void fM(List<com.tencent.mm.plugin.sns.data.p> paramList)
  {
    AppMethodBeat.i(96058);
    this.znH = paramList;
    paramList = ag.dTT().fR(this.znH);
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
      bvk localbvk = new bvk();
      localbvk.GPE = localp.dJd;
      ((LinkedList)localObject1).add(localbvk);
    }
    this.znN.GTh = ((LinkedList)localObject1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.sns.data.p)paramList.next();
      localObject2 = new byp();
      ((byp)localObject2).GTA = 0.0F;
      ((byp)localObject2).GTz = 0.0F;
      ((byp)localObject2).GTB = 0.0F;
      if ((((com.tencent.mm.plugin.sns.data.p)localObject1).height > 0) && (((com.tencent.mm.plugin.sns.data.p)localObject1).width > 0) && (((com.tencent.mm.plugin.sns.data.p)localObject1).fileSize > 0))
      {
        ((byp)localObject2).GTA = ((com.tencent.mm.plugin.sns.data.p)localObject1).height;
        ((byp)localObject2).GTz = ((com.tencent.mm.plugin.sns.data.p)localObject1).width;
        ((byp)localObject2).GTB = ((com.tencent.mm.plugin.sns.data.p)localObject1).fileSize;
      }
      localObject1 = h.a("Locall_path" + ((com.tencent.mm.plugin.sns.data.p)localObject1).dJd, ((com.tencent.mm.plugin.sns.data.p)localObject1).type, "", "", 0, 0, this.zdB, "", (byp)localObject2);
      this.znM.HAT.GaQ.add(localObject1);
    }
    AppMethodBeat.o(96058);
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96059);
    dgj localdgj = new dgj();
    localdgj.Fww = paramString1;
    localdgj.Fwx = paramString2;
    localdgj.Fwy = paramString3;
    localdgj.zTw = paramInt1;
    localdgj.zTx = paramInt2;
    this.znN.GTr = localdgj;
    AppMethodBeat.o(96059);
  }
  
  public final bc jr(String paramString1, String paramString2)
  {
    this.znN.token = paramString1;
    this.znN.GTp = paramString2;
    return this;
  }
  
  public final boolean jt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96053);
    String str = ag.getAccSnsTmpPath() + g.getMessageDigest(paramString1.getBytes());
    azt(str);
    i.mz(paramString1, str);
    paramString1 = js("", str);
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
    this.znM.HAT.GaQ.add(paramString1);
    paramString2 = new bvk();
    paramString2.GPE = paramString1.dJd;
    this.znN.GTh.add(paramString2);
    AppMethodBeat.o(96053);
    return true;
  }
  
  public final void setSessionId(String paramString)
  {
    this.znN.sessionId = paramString;
  }
  
  public final boolean z(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(96051);
    Object localObject = c.xRv;
    localObject = c.awc(paramString1);
    if (localObject != null) {
      ad.i("MicroMsg.UploadPackHelper", "addSightObjectByPath commit video_info:".concat(String.valueOf(localObject)));
    }
    for (float f = ((c.a)localObject).duration / 1000.0F;; f = 0.0F)
    {
      localObject = ag.getAccSnsTmpPath() + g.getMessageDigest(paramString1.getBytes());
      azt((String)localObject);
      i.mz(paramString1, (String)localObject);
      paramString1 = ag.getAccSnsTmpPath() + g.getMessageDigest(paramString2.getBytes());
      i.mz(paramString2, paramString1);
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
      paramString1.GTe = f;
      this.znM.HAT.GaQ.add(paramString1);
      paramString2 = new bvk();
      paramString2.GPE = paramString1.dJd;
      this.znN.GTh.add(paramString2);
      AppMethodBeat.o(96051);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bc
 * JD-Core Version:    0.7.0.1
 */