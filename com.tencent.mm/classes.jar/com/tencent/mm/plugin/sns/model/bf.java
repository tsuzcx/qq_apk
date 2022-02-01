package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.recordvideo.e.d.a;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bf
{
  private static final Pattern PATTERN;
  int DEA;
  int DEB;
  List<q> DOY;
  String DOZ;
  String DPa;
  LinkedList<ebm> DPb;
  LinkedList<Long> DPc;
  public TimeLineObject DPd;
  public cnc DPe;
  public SnsInfo DPf;
  SnsObject DPg;
  public eep DPh;
  private int DPi;
  private String DPj;
  private boolean DPk;
  be actionInfo;
  public int beK;
  public cly eck;
  private String gna;
  private WeakReference<Context> mContextRef;
  public fat webSearchInfo;
  
  static
  {
    AppMethodBeat.i(96061);
    PATTERN = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(96061);
  }
  
  public bf(int paramInt)
  {
    this(paramInt, null);
    AppMethodBeat.i(96035);
    AppMethodBeat.o(96035);
  }
  
  public bf(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(202797);
    this.DPd = n.bfM();
    this.DPe = new cnc();
    this.DPf = new SnsInfo();
    this.DPg = null;
    Object localObject = new be();
    ((be)localObject).KEw = new bc();
    ((be)localObject).KEy = new ek();
    ((be)localObject).KEz = new fc();
    this.actionInfo = ((be)localObject);
    this.DPh = new eep();
    this.eck = new cly();
    this.webSearchInfo = null;
    this.gna = "";
    this.DPi = 1;
    this.DPj = "";
    this.DPk = false;
    this.gna = aj.fau();
    this.beK = paramInt;
    this.DPd.ContentObj.LoU = paramInt;
    if (paramContext != null) {
      this.mContextRef = new WeakReference(paramContext);
    }
    Log.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(paramInt)));
    this.DPd.Privated = 0;
    this.DPd.UserName = this.gna;
    this.DPe.izX = com.tencent.mm.b.g.getMessageDigest((aj.fau() + Util.currentTicks() + System.currentTimeMillis()).getBytes());
    this.DPe.MsU = 0;
    this.DPe.MsV = 0;
    this.DPe.Privated = 0;
    this.DPe.MsY = 0;
    this.DPe.ibG = 0;
    this.DPe.Mta = 0;
    this.DPe.Mtc = 0;
    paramContext = new SnsObject();
    paramContext.Id = 0L;
    paramContext.CreateTime = 0;
    paramContext.LikeFlag = 0;
    paramContext.Username = aj.fau();
    paramContext.LikeUserList = new LinkedList();
    paramContext.LikeCount = 0;
    paramContext.LikeUserListCount = 0;
    paramContext.WithUserList = new LinkedList();
    paramContext.WithUserCount = 0;
    paramContext.WithUserListCount = 0;
    paramContext.CommentUserList = new LinkedList();
    paramContext.CommentCount = 0;
    paramContext.CommentUserListCount = 0;
    paramContext.ExtFlag = 1;
    paramContext.LikeFlag = 0;
    paramContext.NoChange = 0;
    paramContext.ObjectDesc = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    this.DPg = paramContext;
    this.DPf.setPostWaiting();
    this.DPf.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    this.DPf.setTypeFlag(paramInt);
    this.DPf.setUserName(this.gna);
    this.DPf.setPravited(0);
    this.DPf.setStringSeq("0000099999999999999999999");
    this.DPf.addSourceFlag(2);
    this.DPf.setExtFlag();
    if ((paramInt == 1) || (paramInt == 2)) {
      this.DPf.addSourceFlag(4);
    }
    if (paramInt == 7) {
      this.DPf.removeSourceFlag(2);
    }
    this.DPc = new LinkedList();
    this.DPe.Mtb = this.DPc;
    paramContext = this.DPc.iterator();
    while (paramContext.hasNext())
    {
      long l = ((Long)paramContext.next()).longValue();
      localObject = new dzw();
      ((dzw)localObject).MZv = l;
      this.DPg.GroupList.add(localObject);
    }
    this.DPg.GroupCount = this.DPc.size();
    AppMethodBeat.o(202797);
  }
  
  public static cnb aP(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96050);
    cnb localcnb = n.bfN();
    localcnb.Id = paramString1;
    Log.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localcnb.oUv = 2;
    localcnb.Url = paramString2;
    localcnb.Mcw = 0;
    localcnb.Msz = paramString3;
    localcnb.MsA = 0;
    localcnb.MsE = 1;
    AppMethodBeat.o(96050);
    return localcnb;
  }
  
  public static void aPG(String paramString)
  {
    AppMethodBeat.i(96052);
    s.boN(s.boZ(paramString));
    AppMethodBeat.o(96052);
  }
  
  private static String aPv(String paramString)
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
        str1 = PATTERN.matcher(str1).replaceAll("\n\n");
        AppMethodBeat.o(96036);
        return str1;
      }
      catch (Exception localException)
      {
        break label57;
      }
      Log.e("MicroMsg.UploadPackHelper", "filter desc error ");
      AppMethodBeat.o(96036);
      return paramString;
    }
  }
  
  public static cnb b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(96048);
    cnb localcnb = n.bfN();
    localcnb.Id = paramString1;
    Log.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { Integer.valueOf(6), paramString2, paramString4, paramString5, paramString6 });
    localcnb.oUv = 6;
    if (s.boW(paramString2) <= 0L)
    {
      AppMethodBeat.o(96048);
      return null;
    }
    paramString1 = new q(paramString2, 6);
    paramString1.DEE = paramString4;
    paramString2 = aj.faD().a(paramString1, paramString2, paramString3, paramString5, paramString6);
    if ((paramString2.height > 0) && (paramString2.width > 0) && (paramString2.fileSize > 0))
    {
      paramString1 = new cnd();
      paramString1.Mtp = paramString2.height;
      paramString1.Mto = paramString2.width;
      paramString1.Mtq = paramString2.fileSize;
    }
    for (;;)
    {
      localcnb.Id = ("Locall_path" + paramString2.ecf);
      localcnb.MsB = paramString1;
      localcnb.ecf = paramString2.ecf;
      AppMethodBeat.o(96048);
      return localcnb;
      paramString1 = null;
    }
  }
  
  private static cnb km(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(96049);
    cnb localcnb = n.bfN();
    localcnb.Id = paramString1;
    Log.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localcnb.oUv = 2;
    if (s.boW(paramString2) <= 0L)
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString1 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(paramString2).append(System.currentTimeMillis()).toString().getBytes());
    s.nw(paramString2, paramString1);
    paramString1 = new q(paramString1, 2);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = aj.faD().gW(paramString2);
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
          paramString1 = new cnd();
          paramString1.Mtp = paramString2.height;
          paramString1.Mto = paramString2.width;
          paramString1.Mtq = paramString2.fileSize;
        }
      }
    }
    localcnb.Id = ("Locall_path" + paramString2.ecf);
    localcnb.MsB = paramString1;
    localcnb.ecf = paramString2.ecf;
    AppMethodBeat.o(96049);
    return localcnb;
  }
  
  private static cnb v(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96047);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.f.apq() + " attachBuf is null");
      AppMethodBeat.o(96047);
      return null;
    }
    String str = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
    s.boN(aj.getAccSnsTmpPath());
    Log.d("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.f.apq() + " buildUploadAttachInfo file:" + str);
    if (s.f(str, paramArrayOfByte, paramArrayOfByte.length) < 0)
    {
      Log.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.f.apq() + " writeFile error file:" + str);
      AppMethodBeat.o(96047);
      return null;
    }
    paramString = km(paramString, str);
    AppMethodBeat.o(96047);
    return paramString;
  }
  
  public final boolean D(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(96051);
    Object localObject = com.tencent.mm.plugin.recordvideo.e.d.Cin;
    localObject = com.tencent.mm.plugin.recordvideo.e.d.aLQ(paramString1);
    if (localObject != null) {
      Log.i("MicroMsg.UploadPackHelper", "addSightObjectByPath commit video_info:".concat(String.valueOf(localObject)));
    }
    for (float f = ((d.a)localObject).duration / 1000.0F;; f = 0.0F)
    {
      localObject = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
      aPG((String)localObject);
      s.nw(paramString1, (String)localObject);
      paramString1 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString2.getBytes());
      s.nw(paramString2, paramString1);
      paramString1 = b("", (String)localObject, paramString1, paramString4, "", "");
      if (paramString1 == null)
      {
        Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
        AppMethodBeat.o(96051);
        return false;
      }
      paramString1.Desc = paramString3;
      if (Util.isNullOrNil(paramString1.Title)) {
        paramString1.Title = paramString3;
      }
      paramString1.MsT = f;
      this.DPd.ContentObj.LoV.add(paramString1);
      paramString2 = new cjs();
      paramString2.Mpj = paramString1.ecf;
      this.DPe.MsW.add(paramString2);
      AppMethodBeat.o(96051);
      return true;
    }
  }
  
  public final bf YF(int paramInt)
  {
    this.DPd.contentDescShowType = 1;
    this.DPd.contentDescScene = paramInt;
    return this;
  }
  
  public final bf YG(int paramInt)
  {
    this.DPd.contentattr = paramInt;
    return this;
  }
  
  public final void YH(int paramInt)
  {
    AppMethodBeat.i(96039);
    Log.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(paramInt)));
    this.DPe.Mta = paramInt;
    AppMethodBeat.o(96039);
  }
  
  public final bf YI(int paramInt)
  {
    AppMethodBeat.i(96040);
    this.DEB = paramInt;
    this.DPe.Privated = paramInt;
    this.DPd.Privated = paramInt;
    if (paramInt > 0)
    {
      this.DPf.setPravited(paramInt);
      this.DPf.setLocalPrivate();
      this.DPf.removeSourceFlag(2);
      this.DPf.unSetExtFlag();
    }
    AppMethodBeat.o(96040);
    return this;
  }
  
  public final bf YJ(int paramInt)
  {
    this.DEA = paramInt;
    this.DPe.MsV = paramInt;
    return this;
  }
  
  public final bf YK(int paramInt)
  {
    this.DPe.Mtc = paramInt;
    return this;
  }
  
  public final bf YL(int paramInt)
  {
    if (paramInt == 1) {
      this.DPg.ExtFlag = 3;
    }
    for (;;)
    {
      this.DPe.Mtf = paramInt;
      return this;
      if (paramInt == 0) {
        this.DPg.ExtFlag = 5;
      }
    }
  }
  
  public final bf a(cjy paramcjy)
  {
    if (paramcjy == null) {
      return this;
    }
    this.DPd.Location = paramcjy;
    return this;
  }
  
  public final void a(com.tencent.mm.modelsns.d paramd)
  {
    if (paramd != null) {
      this.DPd.ContentObj.Lpc = paramd.jlf;
    }
  }
  
  public final void a(e parame)
  {
    if (parame != null) {
      this.DPd.ContentObj.dME = parame.jlg;
    }
  }
  
  public final void a(com.tencent.mm.modelsns.f paramf)
  {
    if (paramf != null) {
      this.DPd.ContentObj.LoZ = paramf.jld;
    }
  }
  
  public final void a(com.tencent.mm.modelsns.g paramg)
  {
    if (paramg != null) {
      this.DPd.ContentObj.Lpd = paramg.jlh;
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(96056);
    paramArrayOfByte = v("", paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
      AppMethodBeat.o(96056);
      return false;
    }
    paramArrayOfByte.Desc = paramString1;
    if (paramInt > 0) {
      paramArrayOfByte.subType = paramInt;
    }
    if (!Util.isNullOrNil(paramString3)) {
      paramArrayOfByte.EpK = paramString3;
    }
    if (!Util.isNullOrNil(paramString2)) {
      paramArrayOfByte.Title = paramString2;
    }
    if (!Util.isNullOrNil(paramString1)) {
      paramArrayOfByte.Desc = paramString1;
    }
    this.DPd.ContentObj.LoV.add(paramArrayOfByte);
    paramString1 = new cjs();
    paramString1.Mpj = paramArrayOfByte.ecf;
    this.DPe.MsW.add(paramString1);
    AppMethodBeat.o(96056);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(96057);
    paramArrayOfByte = v("", paramArrayOfByte);
    if ((paramArrayOfByte == null) || ((Util.isNullOrNil(paramString2)) && (Util.isNullOrNil(paramString3))))
    {
      Log.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
      AppMethodBeat.o(96057);
      return false;
    }
    if (!Util.isNullOrNil(paramString1)) {
      this.DPd.ContentObj.Url = paramString1;
    }
    if (!Util.isNullOrNil(paramString3))
    {
      paramArrayOfByte.Url = paramString3;
      paramArrayOfByte.Mcw = 0;
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        paramArrayOfByte.MsC = paramString2;
        paramArrayOfByte.MsD = 0;
      }
      paramArrayOfByte.oUv = paramInt;
      paramArrayOfByte.Title = Util.nullAs(paramString4, "");
      paramArrayOfByte.Desc = Util.nullAs(paramString5, "");
      paramArrayOfByte.songAlbumUrl = paramString6;
      paramArrayOfByte.songLyric = paramString7;
      this.DPd.ContentObj.LoV.add(paramArrayOfByte);
      paramString1 = new cjs();
      paramString1.Mpj = paramArrayOfByte.ecf;
      this.DPe.MsW.add(paramString1);
      AppMethodBeat.o(96057);
      return true;
      if (!Util.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Url = paramString2;
        paramArrayOfByte.Mcw = 0;
      }
    }
  }
  
  public final bf aO(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96038);
    bc localbc = this.actionInfo.KEw;
    Object localObject = paramString1;
    if (Util.isNullOrNil(paramString1)) {
      localObject = "";
    }
    localbc.jfi = ((String)localObject);
    localObject = this.actionInfo.KEw;
    paramString1 = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      paramString1 = "";
    }
    ((bc)localObject).KEr = paramString1;
    paramString2 = this.actionInfo.KEw;
    paramString1 = paramString3;
    if (Util.isNullOrNil(paramString3)) {
      paramString1 = "";
    }
    paramString2.KEs = paramString1;
    AppMethodBeat.o(96038);
    return this;
  }
  
  public final bf aPA(String paramString)
  {
    this.DPd.ContentObj.Url = paramString;
    return this;
  }
  
  public final bf aPB(String paramString)
  {
    this.DPd.ContentObj.Title = paramString;
    return this;
  }
  
  public final bf aPC(String paramString)
  {
    AppMethodBeat.i(96042);
    fa localfa2 = this.DPd.AppInfo;
    fa localfa1 = localfa2;
    if (localfa2 == null) {
      localfa1 = new fa();
    }
    localfa1.Id = paramString;
    this.DPd.AppInfo = localfa1;
    AppMethodBeat.o(96042);
    return this;
  }
  
  public final bf aPD(String paramString)
  {
    AppMethodBeat.i(96043);
    fa localfa2 = this.DPd.AppInfo;
    fa localfa1 = localfa2;
    if (localfa2 == null) {
      localfa1 = new fa();
    }
    localfa1.xMq = paramString;
    this.DPd.AppInfo = localfa1;
    AppMethodBeat.o(96043);
    return this;
  }
  
  public final bf aPE(String paramString)
  {
    AppMethodBeat.i(96044);
    this.DPd.sourceUserName = Util.nullAsNil(paramString);
    AppMethodBeat.o(96044);
    return this;
  }
  
  public final bf aPF(String paramString)
  {
    AppMethodBeat.i(96045);
    this.DPd.sourceNickName = Util.nullAsNil(paramString);
    AppMethodBeat.o(96045);
    return this;
  }
  
  public final void aPH(String paramString)
  {
    this.DPe.eam = paramString;
  }
  
  public final bf aPw(String paramString)
  {
    AppMethodBeat.i(96037);
    this.DOZ = aPv(paramString);
    this.DPd.ContentDesc = this.DOZ;
    AppMethodBeat.o(96037);
    return this;
  }
  
  public final bf aPx(String paramString)
  {
    this.DPd.statisticsData = paramString;
    this.actionInfo.KEw.KEq = paramString;
    return this;
  }
  
  public final bf aPy(String paramString)
  {
    this.DPd.canvasInfo = paramString;
    return this;
  }
  
  public final bf aPz(String paramString)
  {
    this.DPa = paramString;
    this.DPd.ContentObj.Desc = paramString;
    return this;
  }
  
  public final boolean b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96055);
    boolean bool = a(paramArrayOfByte, paramString1, paramString2, -1, "");
    AppMethodBeat.o(96055);
    return bool;
  }
  
  public final bf bq(LinkedList<ebm> paramLinkedList)
  {
    AppMethodBeat.i(96041);
    this.DPb = paramLinkedList;
    this.DPe.MsX = paramLinkedList;
    paramLinkedList = this.DPb.iterator();
    while (paramLinkedList.hasNext())
    {
      ebm localebm = (ebm)paramLinkedList.next();
      dzo localdzo = new dzo();
      localdzo.Username = localebm.UserName;
      this.DPg.WithUserList.add(localdzo);
    }
    this.DPg.WithUserCount = this.DPb.size();
    this.DPg.WithUserListCount = this.DPb.size();
    AppMethodBeat.o(96041);
    return this;
  }
  
  @Deprecated
  public final boolean c(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(96054);
    paramString1 = aP("", paramString1, paramString2);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(96054);
      return false;
    }
    paramString1.Desc = paramString3;
    if (paramInt > 0) {
      paramString1.subType = paramInt;
    }
    if (!Util.isNullOrNil(paramString4)) {
      paramString1.EpK = paramString4;
    }
    this.DPd.ContentObj.LoV.add(paramString1);
    AppMethodBeat.o(96054);
    return true;
  }
  
  /* Error */
  public final int commit()
  {
    // Byte code:
    //   0: ldc_w 855
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: aload_0
    //   12: getfield 89	com/tencent/mm/plugin/sns/model/bf:DPe	Lcom/tencent/mm/protocal/protobuf/cnc;
    //   15: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   18: putfield 858	com/tencent/mm/protocal/protobuf/cnc:MsZ	J
    //   21: aload_0
    //   22: getfield 89	com/tencent/mm/plugin/sns/model/bf:DPe	Lcom/tencent/mm/protocal/protobuf/cnc;
    //   25: iconst_0
    //   26: putfield 246	com/tencent/mm/protocal/protobuf/cnc:ibG	I
    //   29: new 860	com/tencent/mm/protocal/protobuf/cwz
    //   32: dup
    //   33: invokespecial 861	com/tencent/mm/protocal/protobuf/cwz:<init>	()V
    //   36: astore 7
    //   38: aload 7
    //   40: aload_0
    //   41: getfield 140	com/tencent/mm/plugin/sns/model/bf:DPi	I
    //   44: putfield 864	com/tencent/mm/protocal/protobuf/cwz:KIF	I
    //   47: aload 7
    //   49: aload_0
    //   50: getfield 142	com/tencent/mm/plugin/sns/model/bf:DPj	Ljava/lang/String;
    //   53: putfield 867	com/tencent/mm/protocal/protobuf/cwz:xuk	Ljava/lang/String;
    //   56: aload_0
    //   57: getfield 89	com/tencent/mm/plugin/sns/model/bf:DPe	Lcom/tencent/mm/protocal/protobuf/cnc;
    //   60: aload 7
    //   62: putfield 871	com/tencent/mm/protocal/protobuf/cnc:Mtn	Lcom/tencent/mm/protocal/protobuf/cwz;
    //   65: aload_0
    //   66: getfield 94	com/tencent/mm/plugin/sns/model/bf:DPf	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   69: aload_0
    //   70: getfield 96	com/tencent/mm/plugin/sns/model/bf:DPg	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   73: invokevirtual 874	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   76: invokevirtual 878	com/tencent/mm/plugin/sns/storage/SnsInfo:setAttrBuf	([B)V
    //   79: aload_0
    //   80: getfield 94	com/tencent/mm/plugin/sns/model/bf:DPf	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   83: aload_0
    //   84: getfield 89	com/tencent/mm/plugin/sns/model/bf:DPe	Lcom/tencent/mm/protocal/protobuf/cnc;
    //   87: invokevirtual 879	com/tencent/mm/protocal/protobuf/cnc:toByteArray	()[B
    //   90: invokevirtual 882	com/tencent/mm/plugin/sns/storage/SnsInfo:setPostBuf	([B)V
    //   93: ldc 172
    //   95: new 198	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 884
    //   102: invokespecial 525	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 96	com/tencent/mm/plugin/sns/model/bf:DPg	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   109: invokevirtual 885	java/lang/Object:toString	()Ljava/lang/String;
    //   112: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: ldc 172
    //   123: new 198	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 887
    //   130: invokespecial 525	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 89	com/tencent/mm/plugin/sns/model/bf:DPe	Lcom/tencent/mm/protocal/protobuf/cnc;
    //   137: invokevirtual 885	java/lang/Object:toString	()Ljava/lang/String;
    //   140: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: ldc 172
    //   151: new 198	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 889
    //   158: invokespecial 525	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   165: invokevirtual 885	java/lang/Object:toString	()Ljava/lang/String;
    //   168: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   181: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adp;
    //   184: getfield 630	com/tencent/mm/protocal/protobuf/adp:LoV	Ljava/util/LinkedList;
    //   187: ifnull +138 -> 325
    //   190: ldc 172
    //   192: ldc_w 891
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_0
    //   202: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   205: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adp;
    //   208: getfield 630	com/tencent/mm/protocal/protobuf/adp:LoV	Ljava/util/LinkedList;
    //   211: invokevirtual 388	java/util/LinkedList:size	()I
    //   214: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: invokestatic 893	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: iconst_0
    //   222: istore_1
    //   223: iload_1
    //   224: aload_0
    //   225: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   228: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adp;
    //   231: getfield 630	com/tencent/mm/protocal/protobuf/adp:LoV	Ljava/util/LinkedList;
    //   234: invokevirtual 388	java/util/LinkedList:size	()I
    //   237: if_icmpge +88 -> 325
    //   240: aload_0
    //   241: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   244: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adp;
    //   247: getfield 630	com/tencent/mm/protocal/protobuf/adp:LoV	Ljava/util/LinkedList;
    //   250: iload_1
    //   251: invokevirtual 894	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   254: checkcast 400	com/tencent/mm/protocal/protobuf/cnb
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +39 -> 300
    //   264: ldc 172
    //   266: ldc_w 896
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 7
    //   277: getfield 536	com/tencent/mm/protocal/protobuf/cnb:ecf	I
    //   280: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 7
    //   288: getfield 410	com/tencent/mm/protocal/protobuf/cnb:Url	Ljava/lang/String;
    //   291: ldc 136
    //   293: invokestatic 745	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 893	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: iload_1
    //   301: iconst_1
    //   302: iadd
    //   303: istore_1
    //   304: goto -81 -> 223
    //   307: astore 7
    //   309: ldc 172
    //   311: aload 7
    //   313: ldc 136
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 900	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: goto -173 -> 149
    //   325: aload_0
    //   326: getfield 122	com/tencent/mm/plugin/sns/model/bf:actionInfo	Lcom/tencent/mm/protocal/protobuf/be;
    //   329: ifnull +14 -> 343
    //   332: aload_0
    //   333: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   336: aload_0
    //   337: getfield 122	com/tencent/mm/plugin/sns/model/bf:actionInfo	Lcom/tencent/mm/protocal/protobuf/be;
    //   340: putfield 901	com/tencent/mm/protocal/protobuf/TimeLineObject:actionInfo	Lcom/tencent/mm/protocal/protobuf/be;
    //   343: aload_0
    //   344: getfield 134	com/tencent/mm/plugin/sns/model/bf:webSearchInfo	Lcom/tencent/mm/protocal/protobuf/fat;
    //   347: ifnull +14 -> 361
    //   350: aload_0
    //   351: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   354: aload_0
    //   355: getfield 134	com/tencent/mm/plugin/sns/model/bf:webSearchInfo	Lcom/tencent/mm/protocal/protobuf/fat;
    //   358: putfield 902	com/tencent/mm/protocal/protobuf/TimeLineObject:webSearchInfo	Lcom/tencent/mm/protocal/protobuf/fat;
    //   361: aload_0
    //   362: getfield 94	com/tencent/mm/plugin/sns/model/bf:DPf	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   365: aload_0
    //   366: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   369: invokevirtual 906	com/tencent/mm/plugin/sns/storage/SnsInfo:setTimeLine	(Lcom/tencent/mm/protocal/protobuf/TimeLineObject;)V
    //   372: invokestatic 910	com/tencent/mm/plugin/sns/model/aj:faO	()Lcom/tencent/mm/plugin/sns/storage/n;
    //   375: aload_0
    //   376: getfield 94	com/tencent/mm/plugin/sns/model/bf:DPf	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   379: invokevirtual 916	com/tencent/mm/plugin/sns/storage/n:R	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)I
    //   382: istore_3
    //   383: invokestatic 920	com/tencent/mm/plugin/sns/model/aj:faV	()Lcom/tencent/mm/plugin/sns/storage/k;
    //   386: astore 8
    //   388: aconst_null
    //   389: astore 7
    //   391: new 198	java/lang/StringBuilder
    //   394: dup
    //   395: ldc_w 922
    //   398: invokespecial 525	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: getstatic 927	com/tencent/mm/plugin/sns/storage/k:Emm	Ljava/lang/String;
    //   404: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: getstatic 930	com/tencent/mm/plugin/sns/storage/k:Emn	Ljava/lang/String;
    //   410: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 932
    //   416: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 9
    //   424: aload 8
    //   426: getfield 936	com/tencent/mm/plugin/sns/storage/k:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   429: aload 9
    //   431: aconst_null
    //   432: iconst_2
    //   433: invokeinterface 942 4 0
    //   438: astore 9
    //   440: aload 9
    //   442: invokeinterface 947 1 0
    //   447: ifeq +19 -> 466
    //   450: new 949	com/tencent/mm/plugin/sns/storage/j
    //   453: dup
    //   454: invokespecial 950	com/tencent/mm/plugin/sns/storage/j:<init>	()V
    //   457: astore 7
    //   459: aload 7
    //   461: aload 9
    //   463: invokevirtual 954	com/tencent/mm/plugin/sns/storage/j:convertFrom	(Landroid/database/Cursor;)V
    //   466: aload 9
    //   468: invokeinterface 957 1 0
    //   473: aload 7
    //   475: ifnull +36 -> 511
    //   478: aload 8
    //   480: ldc_w 959
    //   483: iload_3
    //   484: invokestatic 180	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   487: invokevirtual 184	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   490: aload 7
    //   492: getfield 963	com/tencent/mm/plugin/sns/storage/j:field_draft	[B
    //   495: iconst_0
    //   496: invokevirtual 966	com/tencent/mm/plugin/sns/storage/k:b	(Ljava/lang/String;[BI)V
    //   499: aload 8
    //   501: aload 7
    //   503: getfield 969	com/tencent/mm/plugin/sns/storage/j:field_key	Ljava/lang/String;
    //   506: aconst_null
    //   507: iconst_0
    //   508: invokevirtual 966	com/tencent/mm/plugin/sns/storage/k:b	(Ljava/lang/String;[BI)V
    //   511: aload_0
    //   512: getfield 89	com/tencent/mm/plugin/sns/model/bf:DPe	Lcom/tencent/mm/protocal/protobuf/cnc;
    //   515: getfield 639	com/tencent/mm/protocal/protobuf/cnc:MsW	Ljava/util/LinkedList;
    //   518: invokevirtual 356	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   521: astore 9
    //   523: iconst_0
    //   524: istore_2
    //   525: aconst_null
    //   526: astore 7
    //   528: aload 9
    //   530: invokeinterface 362 1 0
    //   535: ifeq +302 -> 837
    //   538: aload 9
    //   540: invokeinterface 366 1 0
    //   545: checkcast 632	com/tencent/mm/protocal/protobuf/cjs
    //   548: astore 8
    //   550: invokestatic 493	com/tencent/mm/plugin/sns/model/aj:faD	()Lcom/tencent/mm/plugin/sns/storage/r;
    //   553: aload 8
    //   555: getfield 636	com/tencent/mm/protocal/protobuf/cjs:Mpj	I
    //   558: i2l
    //   559: invokevirtual 973	com/tencent/mm/plugin/sns/storage/r:JK	(J)Lcom/tencent/mm/plugin/sns/storage/q;
    //   562: astore 10
    //   564: new 975	com/tencent/mm/protocal/protobuf/cne
    //   567: dup
    //   568: invokespecial 976	com/tencent/mm/protocal/protobuf/cne:<init>	()V
    //   571: aload 10
    //   573: getfield 981	com/tencent/mm/plugin/sns/storage/q:EmR	[B
    //   576: invokevirtual 985	com/tencent/mm/protocal/protobuf/cne:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   579: checkcast 975	com/tencent/mm/protocal/protobuf/cne
    //   582: astore 11
    //   584: aload_0
    //   585: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   588: getfield 773	com/tencent/mm/protocal/protobuf/TimeLineObject:AppInfo	Lcom/tencent/mm/protocal/protobuf/fa;
    //   591: ifnull +18 -> 609
    //   594: aload 11
    //   596: aload_0
    //   597: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   600: getfield 773	com/tencent/mm/protocal/protobuf/TimeLineObject:AppInfo	Lcom/tencent/mm/protocal/protobuf/fa;
    //   603: getfield 777	com/tencent/mm/protocal/protobuf/fa:Id	Ljava/lang/String;
    //   606: putfield 988	com/tencent/mm/protocal/protobuf/cne:dNI	Ljava/lang/String;
    //   609: aload_0
    //   610: getfield 132	com/tencent/mm/plugin/sns/model/bf:eck	Lcom/tencent/mm/protocal/protobuf/cly;
    //   613: ifnull +11 -> 624
    //   616: aload_0
    //   617: getfield 132	com/tencent/mm/plugin/sns/model/bf:eck	Lcom/tencent/mm/protocal/protobuf/cly;
    //   620: iconst_0
    //   621: putfield 991	com/tencent/mm/protocal/protobuf/cly:vUh	I
    //   624: aload 11
    //   626: aload_0
    //   627: getfield 132	com/tencent/mm/plugin/sns/model/bf:eck	Lcom/tencent/mm/protocal/protobuf/cly;
    //   630: putfield 994	com/tencent/mm/protocal/protobuf/cne:Mtx	Lcom/tencent/mm/protocal/protobuf/cly;
    //   633: aload 11
    //   635: aload_0
    //   636: getfield 84	com/tencent/mm/plugin/sns/model/bf:DPd	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   639: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adp;
    //   642: getfield 163	com/tencent/mm/protocal/protobuf/adp:LoU	I
    //   645: putfield 995	com/tencent/mm/protocal/protobuf/cne:beK	I
    //   648: aload 11
    //   650: getfield 995	com/tencent/mm/protocal/protobuf/cne:beK	I
    //   653: iconst_1
    //   654: if_icmpeq +13 -> 667
    //   657: aload 11
    //   659: getfield 995	com/tencent/mm/protocal/protobuf/cne:beK	I
    //   662: bipush 15
    //   664: if_icmpne +22 -> 686
    //   667: aload 11
    //   669: getfield 988	com/tencent/mm/protocal/protobuf/cne:dNI	Ljava/lang/String;
    //   672: invokestatic 624	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   675: ifne +71 -> 746
    //   678: iconst_5
    //   679: istore_1
    //   680: aload 11
    //   682: iload_1
    //   683: putfield 998	com/tencent/mm/protocal/protobuf/cne:Mty	I
    //   686: aload 10
    //   688: aload 11
    //   690: invokevirtual 999	com/tencent/mm/protocal/protobuf/cne:toByteArray	()[B
    //   693: putfield 981	com/tencent/mm/plugin/sns/storage/q:EmR	[B
    //   696: invokestatic 493	com/tencent/mm/plugin/sns/model/aj:faD	()Lcom/tencent/mm/plugin/sns/storage/r;
    //   699: aload 8
    //   701: getfield 636	com/tencent/mm/protocal/protobuf/cjs:Mpj	I
    //   704: aload 10
    //   706: invokevirtual 1002	com/tencent/mm/plugin/sns/storage/r:a	(ILcom/tencent/mm/plugin/sns/storage/q;)I
    //   709: pop
    //   710: aload 11
    //   712: getfield 1005	com/tencent/mm/protocal/protobuf/cne:md5	Ljava/lang/String;
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
    //   732: invokeinterface 957 1 0
    //   737: ldc_w 855
    //   740: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   743: aload 7
    //   745: athrow
    //   746: aload 11
    //   748: getfield 994	com/tencent/mm/protocal/protobuf/cne:Mtx	Lcom/tencent/mm/protocal/protobuf/cly;
    //   751: ifnull +53 -> 804
    //   754: aload 11
    //   756: getfield 995	com/tencent/mm/protocal/protobuf/cne:beK	I
    //   759: bipush 15
    //   761: if_icmpne +43 -> 804
    //   764: aload 11
    //   766: getfield 994	com/tencent/mm/protocal/protobuf/cne:Mtx	Lcom/tencent/mm/protocal/protobuf/cly;
    //   769: getfield 1008	com/tencent/mm/protocal/protobuf/cly:Mrn	Z
    //   772: ifeq +27 -> 799
    //   775: iconst_1
    //   776: istore_1
    //   777: aload 11
    //   779: iload_1
    //   780: putfield 998	com/tencent/mm/protocal/protobuf/cne:Mty	I
    //   783: goto -97 -> 686
    //   786: astore 8
    //   788: ldc 172
    //   790: ldc_w 1010
    //   793: invokestatic 464	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: goto -268 -> 528
    //   799: iconst_2
    //   800: istore_1
    //   801: goto -24 -> 777
    //   804: aload_0
    //   805: getfield 1012	com/tencent/mm/plugin/sns/model/bf:DOY	Ljava/util/List;
    //   808: iload_2
    //   809: invokeinterface 558 2 0
    //   814: checkcast 483	com/tencent/mm/plugin/sns/data/q
    //   817: getfield 1015	com/tencent/mm/plugin/sns/data/q:DEF	Z
    //   820: istore 6
    //   822: iload 6
    //   824: ifeq +8 -> 832
    //   827: iconst_1
    //   828: istore_1
    //   829: goto -149 -> 680
    //   832: iconst_2
    //   833: istore_1
    //   834: goto -154 -> 680
    //   837: ldc 172
    //   839: ldc_w 1017
    //   842: iconst_3
    //   843: anewarray 4	java/lang/Object
    //   846: dup
    //   847: iconst_0
    //   848: iload_3
    //   849: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   852: aastore
    //   853: dup
    //   854: iconst_1
    //   855: aload_0
    //   856: getfield 94	com/tencent/mm/plugin/sns/model/bf:DPf	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   859: invokevirtual 1020	com/tencent/mm/plugin/sns/storage/SnsInfo:getTypeFlag	()I
    //   862: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   865: aastore
    //   866: dup
    //   867: iconst_2
    //   868: aload 7
    //   870: aastore
    //   871: invokestatic 477	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   874: iload_3
    //   875: ifle +29 -> 904
    //   878: aload_0
    //   879: getfield 94	com/tencent/mm/plugin/sns/model/bf:DPf	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   882: invokevirtual 1020	com/tencent/mm/plugin/sns/storage/SnsInfo:getTypeFlag	()I
    //   885: bipush 15
    //   887: if_icmpne +17 -> 904
    //   890: ldc_w 1022
    //   893: iload_3
    //   894: i2l
    //   895: invokestatic 1028	com/tencent/mm/plugin/sns/storage/y:bp	(Ljava/lang/String;J)Ljava/lang/String;
    //   898: aload 7
    //   900: invokestatic 1034	com/tencent/mm/plugin/sns/model/ay:kk	(Ljava/lang/String;Ljava/lang/String;)Z
    //   903: pop
    //   904: ldc 172
    //   906: new 198	java/lang/StringBuilder
    //   909: dup
    //   910: ldc_w 1036
    //   913: invokespecial 525	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   916: iload_3
    //   917: invokevirtual 531	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: ldc_w 1038
    //   923: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   929: lload 4
    //   931: lsub
    //   932: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   935: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: iload_3
    //   942: ifle +20 -> 962
    //   945: aload_0
    //   946: getfield 170	com/tencent/mm/plugin/sns/model/bf:mContextRef	Ljava/lang/ref/WeakReference;
    //   949: ifnull +13 -> 962
    //   952: aload_0
    //   953: getfield 170	com/tencent/mm/plugin/sns/model/bf:mContextRef	Ljava/lang/ref/WeakReference;
    //   956: invokevirtual 1040	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   959: ifnonnull +11 -> 970
    //   962: ldc_w 855
    //   965: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   968: iload_3
    //   969: ireturn
    //   970: aload_0
    //   971: getfield 170	com/tencent/mm/plugin/sns/model/bf:mContextRef	Ljava/lang/ref/WeakReference;
    //   974: invokevirtual 1040	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   977: checkcast 1042	android/content/Context
    //   980: astore 7
    //   982: getstatic 1048	com/tencent/mm/plugin/secdata/ui/SecDataUIC:CWq	Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC$a;
    //   985: astore 8
    //   987: aload 7
    //   989: iconst_2
    //   990: ldc_w 1050
    //   993: invokestatic 1055	com/tencent/mm/plugin/secdata/ui/SecDataUIC$a:c	(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/bw/a;
    //   996: checkcast 1050	com/tencent/mm/plugin/sns/j/j
    //   999: astore 7
    //   1001: aload 7
    //   1003: ifnull -41 -> 962
    //   1006: aload 7
    //   1008: iload_3
    //   1009: putfield 1056	com/tencent/mm/plugin/sns/j/j:ecf	I
    //   1012: goto -50 -> 962
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1015	0	this	bf
    //   222	612	1	i	int
    //   524	285	2	j	int
    //   382	627	3	k	int
    //   9	921	4	l	long
    //   820	3	6	bool	boolean
    //   36	251	7	localObject1	Object
    //   307	5	7	localException1	Exception
    //   389	335	7	localObject2	Object
    //   728	171	7	str	String
    //   980	27	7	localObject3	Object
    //   386	336	8	localObject4	Object
    //   786	1	8	localException2	Exception
    //   985	1	8	locala	com.tencent.mm.plugin.secdata.ui.SecDataUIC.a
    //   422	309	9	localObject5	Object
    //   562	143	10	localq	com.tencent.mm.plugin.sns.storage.q
    //   582	196	11	localcne	com.tencent.mm.protocal.protobuf.cne
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
  
  public final bf ct(int paramInt, String paramString)
  {
    this.DPi = paramInt;
    this.DPj = paramString;
    return this;
  }
  
  public final bf fbU()
  {
    return this;
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96059);
    eam localeam = new eam();
    localeam.KIC = paramString1;
    localeam.KID = paramString2;
    localeam.KIE = paramString3;
    localeam.Etq = paramInt1;
    localeam.Etr = paramInt2;
    this.DPe.Mtg = localeam;
    AppMethodBeat.o(96059);
  }
  
  public final bf gR(List<String> paramList)
  {
    AppMethodBeat.i(96046);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.DPg.ExtFlag = 1;
      AppMethodBeat.o(96046);
      return this;
    }
    paramList = paramList.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      dqi localdqi = new dqi();
      localdqi.bhy(str);
      localLinkedList.add(localdqi);
    }
    this.DPe.GroupUser = localLinkedList;
    if (this.DPg.ExtFlag == 3)
    {
      this.DPg.BlackList = localLinkedList;
      this.DPg.BlackListCount = localLinkedList.size();
    }
    for (;;)
    {
      AppMethodBeat.o(96046);
      return this;
      if (this.DPg.ExtFlag == 5)
      {
        this.DPg.GroupUser = localLinkedList;
        this.DPg.GroupUserCount = localLinkedList.size();
      }
    }
  }
  
  public final void gS(List<q> paramList)
  {
    AppMethodBeat.i(96058);
    this.DOY = paramList;
    paramList = aj.faD().gW(this.DOY);
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
      cjs localcjs = new cjs();
      localcjs.Mpj = localq.ecf;
      ((LinkedList)localObject1).add(localcjs);
    }
    this.DPe.MsW = ((LinkedList)localObject1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (q)paramList.next();
      localObject2 = new cnd();
      ((cnd)localObject2).Mtp = 0.0F;
      ((cnd)localObject2).Mto = 0.0F;
      ((cnd)localObject2).Mtq = 0.0F;
      if ((((q)localObject1).height > 0) && (((q)localObject1).width > 0) && (((q)localObject1).fileSize > 0))
      {
        ((cnd)localObject2).Mtp = ((q)localObject1).height;
        ((cnd)localObject2).Mto = ((q)localObject1).width;
        ((cnd)localObject2).Mtq = ((q)localObject1).fileSize;
      }
      localObject1 = n.a("Locall_path" + ((q)localObject1).ecf, ((q)localObject1).type, "", "", 0, 0, this.DEB, "", (cnd)localObject2);
      this.DPd.ContentObj.LoV.add(localObject1);
    }
    AppMethodBeat.o(96058);
  }
  
  public final int getContentType()
  {
    return this.beK;
  }
  
  public final bf kl(String paramString1, String paramString2)
  {
    this.DPe.token = paramString1;
    this.DPe.Mte = paramString2;
    return this;
  }
  
  public final boolean kn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96053);
    String str = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    aPG(str);
    s.nw(paramString1, str);
    paramString1 = km("", str);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      AppMethodBeat.o(96053);
      return false;
    }
    paramString1.Desc = paramString2;
    if (Util.isNullOrNil(paramString1.Title)) {
      paramString1.Title = paramString2;
    }
    this.DPd.ContentObj.LoV.add(paramString1);
    paramString2 = new cjs();
    paramString2.Mpj = paramString1.ecf;
    this.DPe.MsW.add(paramString2);
    AppMethodBeat.o(96053);
    return true;
  }
  
  public final void setSessionId(String paramString)
  {
    this.DPe.sessionId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bf
 * JD-Core Version:    0.7.0.1
 */