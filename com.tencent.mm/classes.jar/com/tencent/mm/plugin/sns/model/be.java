package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.recordvideo.e.e.a;
import com.tencent.mm.plugin.sns.data.s;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.ejw;
import com.tencent.mm.protocal.protobuf.ekm;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class be
{
  private static final Pattern PATTERN;
  int JRv;
  int JRw;
  List<s> Kcf;
  String Kcg;
  String Kch;
  LinkedList<elm> Kci;
  LinkedList<Long> Kcj;
  public TimeLineObject Kck;
  public cvu Kcl;
  public SnsInfo Kcm;
  SnsObject Kcn;
  public eoq Kco;
  private int Kcp;
  private String Kcq;
  private boolean Kcr;
  public int aOl;
  bc actionInfo;
  public cuv fWm;
  private String iRj;
  private WeakReference<Context> mContextRef;
  public flm webSearchInfo;
  
  static
  {
    AppMethodBeat.i(96061);
    PATTERN = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(96061);
  }
  
  public be(int paramInt)
  {
    this(paramInt, null);
    AppMethodBeat.i(96035);
    AppMethodBeat.o(96035);
  }
  
  public be(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(232311);
    this.Kck = o.bpc();
    this.Kcl = new cvu();
    this.Kcm = new SnsInfo();
    this.Kcn = null;
    Object localObject = new bc();
    ((bc)localObject).RFO = new ba();
    ((bc)localObject).RFQ = new eh();
    ((bc)localObject).RFR = new ez();
    this.actionInfo = ((bc)localObject);
    this.Kco = new eoq();
    this.fWm = new cuv();
    this.webSearchInfo = null;
    this.iRj = "";
    this.Kcp = 1;
    this.Kcq = "";
    this.Kcr = false;
    this.iRj = aj.fOo();
    this.aOl = paramInt;
    this.Kck.ContentObj.Sqq = paramInt;
    if (paramContext != null) {
      this.mContextRef = new WeakReference(paramContext);
    }
    Log.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(paramInt)));
    this.Kck.Privated = 0;
    this.Kck.UserName = this.iRj;
    this.Kcl.lps = com.tencent.mm.b.g.getMessageDigest((aj.fOo() + Util.currentTicks() + System.currentTimeMillis()).getBytes());
    this.Kcl.TEa = 0;
    this.Kcl.TEb = 0;
    this.Kcl.Privated = 0;
    this.Kcl.TEe = 0;
    this.Kcl.kQn = 0;
    this.Kcl.TEg = 0;
    this.Kcl.TEi = 0;
    paramContext = new SnsObject();
    paramContext.Id = 0L;
    paramContext.CreateTime = 0;
    paramContext.LikeFlag = 0;
    paramContext.Username = aj.fOo();
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
    paramContext.ObjectDesc = new eae().dc(new byte[0]);
    this.Kcn = paramContext;
    this.Kcm.setPostWaiting();
    this.Kcm.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    this.Kcm.setTypeFlag(paramInt);
    this.Kcm.setUserName(this.iRj);
    this.Kcm.setPravited(0);
    this.Kcm.setStringSeq("0000099999999999999999999");
    this.Kcm.addSourceFlag(2);
    this.Kcm.setExtFlag();
    if ((paramInt == 1) || (paramInt == 2)) {
      this.Kcm.addSourceFlag(4);
    }
    if (paramInt == 7) {
      this.Kcm.removeSourceFlag(2);
    }
    this.Kcj = new LinkedList();
    this.Kcl.TEh = this.Kcj;
    paramContext = this.Kcj.iterator();
    while (paramContext.hasNext())
    {
      long l = ((Long)paramContext.next()).longValue();
      localObject = new ejw();
      ((ejw)localObject).UlP = l;
      this.Kcn.GroupList.add(localObject);
    }
    this.Kcn.GroupCount = this.Kcj.size();
    AppMethodBeat.o(232311);
  }
  
  private static cvt A(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96047);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.UploadPackHelper", f.avD() + " attachBuf is null");
      AppMethodBeat.o(96047);
      return null;
    }
    String str = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
    u.bBD(aj.getAccSnsTmpPath());
    Log.d("MicroMsg.UploadPackHelper", f.avD() + " buildUploadAttachInfo file:" + str);
    if (u.f(str, paramArrayOfByte, paramArrayOfByte.length) < 0)
    {
      Log.e("MicroMsg.UploadPackHelper", f.avD() + " writeFile error file:" + str);
      AppMethodBeat.o(96047);
      return null;
    }
    paramString = kH(paramString, str);
    AppMethodBeat.o(96047);
    return paramString;
  }
  
  private static cvt aJ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96050);
    cvt localcvt = o.bpd();
    localcvt.Id = paramString1;
    Log.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localcvt.rWu = 2;
    localcvt.Url = paramString2;
    localcvt.TlV = 0;
    localcvt.TDF = paramString3;
    localcvt.TDG = 0;
    localcvt.TDK = 1;
    AppMethodBeat.o(96050);
    return localcvt;
  }
  
  public static cvt b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(96048);
    cvt localcvt = o.bpd();
    localcvt.Id = paramString1;
    Log.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { Integer.valueOf(6), paramString2, paramString4, paramString5, paramString6 });
    localcvt.rWu = 6;
    if (u.bBQ(paramString2) <= 0L)
    {
      AppMethodBeat.o(96048);
      return null;
    }
    paramString1 = new s(paramString2, 6);
    paramString1.JRz = paramString4;
    paramString2 = aj.fOx().a(paramString1, paramString2, paramString3, paramString5, paramString6);
    if ((paramString2.height > 0) && (paramString2.width > 0) && (paramString2.fileSize > 0))
    {
      paramString1 = new cvv();
      paramString1.TEv = paramString2.height;
      paramString1.TEu = paramString2.width;
      paramString1.TEw = paramString2.fileSize;
    }
    for (;;)
    {
      localcvt.Id = ("Locall_path" + paramString2.fWh);
      localcvt.TDH = paramString1;
      localcvt.fWh = paramString2.fWh;
      AppMethodBeat.o(96048);
      return localcvt;
      paramString1 = null;
    }
  }
  
  public static void baC(String paramString)
  {
    AppMethodBeat.i(96052);
    u.bBD(u.bBT(paramString));
    AppMethodBeat.o(96052);
  }
  
  private static String bar(String paramString)
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
  
  private static cvt kH(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(96049);
    cvt localcvt = o.bpd();
    localcvt.Id = paramString1;
    Log.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localcvt.rWu = 2;
    if (u.bBQ(paramString2) <= 0L)
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString1 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(paramString2).append(System.currentTimeMillis()).toString().getBytes());
    u.on(paramString2, paramString1);
    paramString1 = new s(paramString1, 2);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = aj.fOx().hE(paramString2);
    if ((paramString1 == null) || (paramString1.size() == 0))
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString2 = (s)paramString1.get(0);
    paramString1 = localObject;
    if (paramString2.height > 0)
    {
      paramString1 = localObject;
      if (paramString2.width > 0)
      {
        paramString1 = localObject;
        if (paramString2.fileSize > 0)
        {
          paramString1 = new cvv();
          paramString1.TEv = paramString2.height;
          paramString1.TEu = paramString2.width;
          paramString1.TEw = paramString2.fileSize;
        }
      }
    }
    localcvt.Id = ("Locall_path" + paramString2.fWh);
    localcvt.TDH = paramString1;
    localcvt.fWh = paramString2.fWh;
    AppMethodBeat.o(96049);
    return localcvt;
  }
  
  public final boolean I(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(96051);
    Object localObject = com.tencent.mm.plugin.recordvideo.e.e.Ife;
    localObject = com.tencent.mm.plugin.recordvideo.e.e.aWt(paramString1);
    if (localObject != null) {
      Log.i("MicroMsg.UploadPackHelper", "addSightObjectByPath commit video_info:".concat(String.valueOf(localObject)));
    }
    for (float f = ((e.a)localObject).duration / 1000.0F;; f = 0.0F)
    {
      localObject = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
      baC((String)localObject);
      u.on(paramString1, (String)localObject);
      paramString1 = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString2.getBytes());
      u.on(paramString2, paramString1);
      paramString1 = b("", (String)localObject, paramString1, paramString4, "", "");
      if (paramString1 == null)
      {
        Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
        AppMethodBeat.o(96051);
        return false;
      }
      paramString1.CMB = paramString3;
      if (Util.isNullOrNil(paramString1.fwr)) {
        paramString1.fwr = paramString3;
      }
      paramString1.TDZ = f;
      this.Kck.ContentObj.Sqr.add(paramString1);
      paramString2 = new csn();
      paramString2.TAo = paramString1.fWh;
      this.Kcl.TEc.add(paramString2);
      AppMethodBeat.o(96051);
      return true;
    }
  }
  
  public final be a(cst paramcst)
  {
    if (paramcst == null) {
      return this;
    }
    this.Kck.Location = paramcst;
    return this;
  }
  
  public final void a(d paramd)
  {
    if (paramd != null) {
      this.Kck.ContentObj.yNL = paramd.mbh;
    }
  }
  
  public final void a(com.tencent.mm.modelsns.e parame)
  {
    if (parame != null) {
      this.Kck.ContentObj.fFJ = parame.mbi;
    }
  }
  
  public final void a(com.tencent.mm.modelsns.g paramg)
  {
    if (paramg != null) {
      this.Kck.ContentObj.Sqv = paramg.mbf;
    }
  }
  
  public final void a(h paramh)
  {
    if (paramh != null) {
      this.Kck.ContentObj.Sqy = paramh.mbk;
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(96056);
    paramArrayOfByte = A("", paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
      AppMethodBeat.o(96056);
      return false;
    }
    paramArrayOfByte.CMB = paramString1;
    if (paramInt > 0) {
      paramArrayOfByte.subType = paramInt;
    }
    if (!Util.isNullOrNil(paramString3)) {
      paramArrayOfByte.KCT = paramString3;
    }
    if (!Util.isNullOrNil(paramString2)) {
      paramArrayOfByte.fwr = paramString2;
    }
    if (!Util.isNullOrNil(paramString1)) {
      paramArrayOfByte.CMB = paramString1;
    }
    this.Kck.ContentObj.Sqr.add(paramArrayOfByte);
    paramString1 = new csn();
    paramString1.TAo = paramArrayOfByte.fWh;
    this.Kcl.TEc.add(paramString1);
    AppMethodBeat.o(96056);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(96057);
    paramArrayOfByte = A("", paramArrayOfByte);
    if ((paramArrayOfByte == null) || ((Util.isNullOrNil(paramString2)) && (Util.isNullOrNil(paramString3))))
    {
      Log.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
      AppMethodBeat.o(96057);
      return false;
    }
    if (!Util.isNullOrNil(paramString1)) {
      this.Kck.ContentObj.Url = paramString1;
    }
    if (!Util.isNullOrNil(paramString3))
    {
      paramArrayOfByte.Url = paramString3;
      paramArrayOfByte.TlV = 0;
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        paramArrayOfByte.TDI = paramString2;
        paramArrayOfByte.TDJ = 0;
      }
      paramArrayOfByte.rWu = paramInt;
      paramArrayOfByte.fwr = Util.nullAs(paramString4, "");
      paramArrayOfByte.CMB = Util.nullAs(paramString5, "");
      paramArrayOfByte.songAlbumUrl = paramString6;
      paramArrayOfByte.songLyric = paramString7;
      this.Kck.ContentObj.Sqr.add(paramArrayOfByte);
      paramString1 = new csn();
      paramString1.TAo = paramArrayOfByte.fWh;
      this.Kcl.TEc.add(paramString1);
      AppMethodBeat.o(96057);
      return true;
      if (!Util.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Url = paramString2;
        paramArrayOfByte.TlV = 0;
      }
    }
  }
  
  public final be aI(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96038);
    ba localba = this.actionInfo.RFO;
    Object localObject = paramString1;
    if (Util.isNullOrNil(paramString1)) {
      localObject = "";
    }
    localba.lVG = ((String)localObject);
    localObject = this.actionInfo.RFO;
    paramString1 = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      paramString1 = "";
    }
    ((ba)localObject).RFJ = paramString1;
    paramString2 = this.actionInfo.RFO;
    paramString1 = paramString3;
    if (Util.isNullOrNil(paramString3)) {
      paramString1 = "";
    }
    paramString2.RFK = paramString1;
    AppMethodBeat.o(96038);
    return this;
  }
  
  public final be afW(int paramInt)
  {
    this.Kck.contentDescShowType = 1;
    this.Kck.contentDescScene = paramInt;
    return this;
  }
  
  public final be afX(int paramInt)
  {
    this.Kck.contentattr = paramInt;
    return this;
  }
  
  public final void afY(int paramInt)
  {
    AppMethodBeat.i(96039);
    Log.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(paramInt)));
    this.Kcl.TEg = paramInt;
    AppMethodBeat.o(96039);
  }
  
  public final be afZ(int paramInt)
  {
    AppMethodBeat.i(96040);
    this.JRw = paramInt;
    this.Kcl.Privated = paramInt;
    this.Kck.Privated = paramInt;
    if (paramInt > 0)
    {
      this.Kcm.setPravited(paramInt);
      this.Kcm.setLocalPrivate();
      this.Kcm.removeSourceFlag(2);
      this.Kcm.unSetExtFlag();
    }
    AppMethodBeat.o(96040);
    return this;
  }
  
  public final be aga(int paramInt)
  {
    this.JRv = paramInt;
    this.Kcl.TEb = paramInt;
    return this;
  }
  
  public final be agb(int paramInt)
  {
    this.Kcl.TEi = paramInt;
    return this;
  }
  
  public final be agc(int paramInt)
  {
    if (paramInt == 1) {
      this.Kcn.ExtFlag = 3;
    }
    for (;;)
    {
      this.Kcl.TEl = paramInt;
      return this;
      if (paramInt == 0) {
        this.Kcn.ExtFlag = 5;
      }
    }
  }
  
  public final boolean b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96055);
    boolean bool = a(paramArrayOfByte, paramString1, paramString2, -1, "");
    AppMethodBeat.o(96055);
    return bool;
  }
  
  public final be bL(LinkedList<elm> paramLinkedList)
  {
    AppMethodBeat.i(96041);
    this.Kci = paramLinkedList;
    this.Kcl.TEd = paramLinkedList;
    paramLinkedList = this.Kci.iterator();
    while (paramLinkedList.hasNext())
    {
      elm localelm = (elm)paramLinkedList.next();
      ejo localejo = new ejo();
      localejo.Username = localelm.UserName;
      this.Kcn.WithUserList.add(localejo);
    }
    this.Kcn.WithUserCount = this.Kci.size();
    this.Kcn.WithUserListCount = this.Kci.size();
    AppMethodBeat.o(96041);
    return this;
  }
  
  public final be baA(String paramString)
  {
    AppMethodBeat.i(96044);
    this.Kck.sourceUserName = Util.nullAsNil(paramString);
    AppMethodBeat.o(96044);
    return this;
  }
  
  public final be baB(String paramString)
  {
    AppMethodBeat.i(96045);
    this.Kck.sourceNickName = Util.nullAsNil(paramString);
    AppMethodBeat.o(96045);
    return this;
  }
  
  public final void baD(String paramString)
  {
    this.Kcl.fUj = paramString;
  }
  
  public final be bas(String paramString)
  {
    AppMethodBeat.i(96037);
    this.Kcg = bar(paramString);
    this.Kck.ContentDesc = this.Kcg;
    AppMethodBeat.o(96037);
    return this;
  }
  
  public final be bat(String paramString)
  {
    this.Kck.statisticsData = paramString;
    this.actionInfo.RFO.RFI = paramString;
    return this;
  }
  
  public final be bau(String paramString)
  {
    this.Kck.canvasInfo = paramString;
    return this;
  }
  
  public final be bav(String paramString)
  {
    this.Kch = paramString;
    this.Kck.ContentObj.CMB = paramString;
    return this;
  }
  
  public final be baw(String paramString)
  {
    this.Kck.ContentObj.Url = paramString;
    return this;
  }
  
  public final be bax(String paramString)
  {
    this.Kck.ContentObj.fwr = paramString;
    return this;
  }
  
  public final be bay(String paramString)
  {
    AppMethodBeat.i(96042);
    ex localex2 = this.Kck.AppInfo;
    ex localex1 = localex2;
    if (localex2 == null) {
      localex1 = new ex();
    }
    localex1.Id = paramString;
    this.Kck.AppInfo = localex1;
    AppMethodBeat.o(96042);
    return this;
  }
  
  public final be baz(String paramString)
  {
    AppMethodBeat.i(96043);
    ex localex2 = this.Kck.AppInfo;
    ex localex1 = localex2;
    if (localex2 == null) {
      localex1 = new ex();
    }
    localex1.CQz = paramString;
    this.Kck.AppInfo = localex1;
    AppMethodBeat.o(96043);
    return this;
  }
  
  @Deprecated
  public final boolean c(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(96054);
    paramString1 = aJ("", paramString1, paramString2);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(96054);
      return false;
    }
    paramString1.CMB = paramString3;
    if (paramInt > 0) {
      paramString1.subType = paramInt;
    }
    if (!Util.isNullOrNil(paramString4)) {
      paramString1.KCT = paramString4;
    }
    this.Kck.ContentObj.Sqr.add(paramString1);
    AppMethodBeat.o(96054);
    return true;
  }
  
  public final be ct(int paramInt, String paramString)
  {
    this.Kcp = paramInt;
    this.Kcq = paramString;
    return this;
  }
  
  public final int fPM()
  {
    return this.aOl;
  }
  
  public final be fPN()
  {
    return this;
  }
  
  @Deprecated
  public final boolean h(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(232334);
    paramString1 = aJ("", paramString1, paramString1);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(232334);
      return false;
    }
    paramString1.CMB = paramString2;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      cvv localcvv = new cvv();
      localcvv.TEv = paramInt2;
      localcvv.TEu = paramInt1;
      paramString1.TDH = localcvv;
    }
    if (!Util.isNullOrNil(paramString3)) {
      paramString1.fwr = paramString3;
    }
    if (!Util.isNullOrNil(paramString2)) {
      paramString1.CMB = paramString2;
    }
    this.Kck.ContentObj.Sqr.add(paramString1);
    AppMethodBeat.o(232334);
    return true;
  }
  
  public final be hA(List<String> paramList)
  {
    AppMethodBeat.i(96046);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Kcn.ExtFlag = 1;
      AppMethodBeat.o(96046);
      return this;
    }
    paramList = paramList.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      eaf localeaf = new eaf();
      localeaf.btQ(str);
      localLinkedList.add(localeaf);
    }
    this.Kcl.GroupUser = localLinkedList;
    if (this.Kcn.ExtFlag == 3)
    {
      this.Kcn.BlackList = localLinkedList;
      this.Kcn.BlackListCount = localLinkedList.size();
    }
    for (;;)
    {
      AppMethodBeat.o(96046);
      return this;
      if (this.Kcn.ExtFlag == 5)
      {
        this.Kcn.GroupUser = localLinkedList;
        this.Kcn.GroupUserCount = localLinkedList.size();
      }
    }
  }
  
  public final void hB(List<s> paramList)
  {
    AppMethodBeat.i(96058);
    this.Kcf = paramList;
    paramList = aj.fOx().hE(this.Kcf);
    Object localObject1 = new LinkedList();
    if (paramList == null)
    {
      AppMethodBeat.o(96058);
      return;
    }
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      s locals = (s)((Iterator)localObject2).next();
      csn localcsn = new csn();
      localcsn.TAo = locals.fWh;
      ((LinkedList)localObject1).add(localcsn);
    }
    this.Kcl.TEc = ((LinkedList)localObject1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (s)paramList.next();
      localObject2 = new cvv();
      ((cvv)localObject2).TEv = 0.0F;
      ((cvv)localObject2).TEu = 0.0F;
      ((cvv)localObject2).TEw = 0.0F;
      if ((((s)localObject1).height > 0) && (((s)localObject1).width > 0) && (((s)localObject1).fileSize > 0))
      {
        ((cvv)localObject2).TEv = ((s)localObject1).height;
        ((cvv)localObject2).TEu = ((s)localObject1).width;
        ((cvv)localObject2).TEw = ((s)localObject1).fileSize;
      }
      localObject1 = o.a("Locall_path" + ((s)localObject1).fWh, ((s)localObject1).type, "", "", 0, 0, this.JRw, "", (cvv)localObject2);
      this.Kck.ContentObj.Sqr.add(localObject1);
    }
    AppMethodBeat.o(96058);
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96059);
    ekm localekm = new ekm();
    localekm.RJT = paramString1;
    localekm.RJU = paramString2;
    localekm.RJV = paramString3;
    localekm.KGN = paramInt1;
    localekm.KGO = paramInt2;
    this.Kcl.TEm = localekm;
    AppMethodBeat.o(96059);
  }
  
  /* Error */
  public final int in()
  {
    // Byte code:
    //   0: ldc_w 923
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: aload_0
    //   12: getfield 89	com/tencent/mm/plugin/sns/model/be:Kcl	Lcom/tencent/mm/protocal/protobuf/cvu;
    //   15: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   18: putfield 926	com/tencent/mm/protocal/protobuf/cvu:TEf	J
    //   21: aload_0
    //   22: getfield 89	com/tencent/mm/plugin/sns/model/be:Kcl	Lcom/tencent/mm/protocal/protobuf/cvu;
    //   25: iconst_0
    //   26: putfield 246	com/tencent/mm/protocal/protobuf/cvu:kQn	I
    //   29: new 928	com/tencent/mm/protocal/protobuf/dgj
    //   32: dup
    //   33: invokespecial 929	com/tencent/mm/protocal/protobuf/dgj:<init>	()V
    //   36: astore 7
    //   38: aload 7
    //   40: aload_0
    //   41: getfield 140	com/tencent/mm/plugin/sns/model/be:Kcp	I
    //   44: putfield 932	com/tencent/mm/protocal/protobuf/dgj:RJW	I
    //   47: aload 7
    //   49: aload_0
    //   50: getfield 142	com/tencent/mm/plugin/sns/model/be:Kcq	Ljava/lang/String;
    //   53: putfield 935	com/tencent/mm/protocal/protobuf/dgj:CqB	Ljava/lang/String;
    //   56: aload_0
    //   57: getfield 89	com/tencent/mm/plugin/sns/model/be:Kcl	Lcom/tencent/mm/protocal/protobuf/cvu;
    //   60: aload 7
    //   62: putfield 939	com/tencent/mm/protocal/protobuf/cvu:TEt	Lcom/tencent/mm/protocal/protobuf/dgj;
    //   65: aload_0
    //   66: getfield 94	com/tencent/mm/plugin/sns/model/be:Kcm	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   69: aload_0
    //   70: getfield 96	com/tencent/mm/plugin/sns/model/be:Kcn	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   73: invokevirtual 942	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   76: invokevirtual 946	com/tencent/mm/plugin/sns/storage/SnsInfo:setAttrBuf	([B)V
    //   79: aload_0
    //   80: getfield 94	com/tencent/mm/plugin/sns/model/be:Kcm	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   83: aload_0
    //   84: getfield 89	com/tencent/mm/plugin/sns/model/be:Kcl	Lcom/tencent/mm/protocal/protobuf/cvu;
    //   87: invokevirtual 947	com/tencent/mm/protocal/protobuf/cvu:toByteArray	()[B
    //   90: invokevirtual 950	com/tencent/mm/plugin/sns/storage/SnsInfo:setPostBuf	([B)V
    //   93: ldc 172
    //   95: new 198	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 952
    //   102: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 96	com/tencent/mm/plugin/sns/model/be:Kcn	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   109: invokevirtual 953	java/lang/Object:toString	()Ljava/lang/String;
    //   112: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: ldc 172
    //   123: new 198	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 955
    //   130: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 89	com/tencent/mm/plugin/sns/model/be:Kcl	Lcom/tencent/mm/protocal/protobuf/cvu;
    //   137: invokevirtual 953	java/lang/Object:toString	()Ljava/lang/String;
    //   140: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: ldc 172
    //   151: new 198	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 957
    //   158: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   165: invokevirtual 953	java/lang/Object:toString	()Ljava/lang/String;
    //   168: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   181: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   184: getfield 629	com/tencent/mm/protocal/protobuf/adw:Sqr	Ljava/util/LinkedList;
    //   187: ifnull +138 -> 325
    //   190: ldc 172
    //   192: ldc_w 959
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_0
    //   202: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   205: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   208: getfield 629	com/tencent/mm/protocal/protobuf/adw:Sqr	Ljava/util/LinkedList;
    //   211: invokevirtual 388	java/util/LinkedList:size	()I
    //   214: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: invokestatic 961	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: iconst_0
    //   222: istore_1
    //   223: iload_1
    //   224: aload_0
    //   225: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   228: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   231: getfield 629	com/tencent/mm/protocal/protobuf/adw:Sqr	Ljava/util/LinkedList;
    //   234: invokevirtual 388	java/util/LinkedList:size	()I
    //   237: if_icmpge +88 -> 325
    //   240: aload_0
    //   241: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   244: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   247: getfield 629	com/tencent/mm/protocal/protobuf/adw:Sqr	Ljava/util/LinkedList;
    //   250: iload_1
    //   251: invokevirtual 962	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   254: checkcast 442	com/tencent/mm/protocal/protobuf/cvt
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +39 -> 300
    //   264: ldc 172
    //   266: ldc_w 964
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 7
    //   277: getfield 534	com/tencent/mm/protocal/protobuf/cvt:fWh	I
    //   280: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 7
    //   288: getfield 452	com/tencent/mm/protocal/protobuf/cvt:Url	Ljava/lang/String;
    //   291: ldc 136
    //   293: invokestatic 710	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 961	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   319: invokestatic 968	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: goto -173 -> 149
    //   325: aload_0
    //   326: getfield 122	com/tencent/mm/plugin/sns/model/be:actionInfo	Lcom/tencent/mm/protocal/protobuf/bc;
    //   329: ifnull +14 -> 343
    //   332: aload_0
    //   333: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   336: aload_0
    //   337: getfield 122	com/tencent/mm/plugin/sns/model/be:actionInfo	Lcom/tencent/mm/protocal/protobuf/bc;
    //   340: putfield 969	com/tencent/mm/protocal/protobuf/TimeLineObject:actionInfo	Lcom/tencent/mm/protocal/protobuf/bc;
    //   343: aload_0
    //   344: getfield 134	com/tencent/mm/plugin/sns/model/be:webSearchInfo	Lcom/tencent/mm/protocal/protobuf/flm;
    //   347: ifnull +14 -> 361
    //   350: aload_0
    //   351: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   354: aload_0
    //   355: getfield 134	com/tencent/mm/plugin/sns/model/be:webSearchInfo	Lcom/tencent/mm/protocal/protobuf/flm;
    //   358: putfield 970	com/tencent/mm/protocal/protobuf/TimeLineObject:webSearchInfo	Lcom/tencent/mm/protocal/protobuf/flm;
    //   361: aload_0
    //   362: getfield 94	com/tencent/mm/plugin/sns/model/be:Kcm	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   365: aload_0
    //   366: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   369: invokevirtual 974	com/tencent/mm/plugin/sns/storage/SnsInfo:setTimeLine	(Lcom/tencent/mm/protocal/protobuf/TimeLineObject;)V
    //   372: invokestatic 978	com/tencent/mm/plugin/sns/model/aj:fOI	()Lcom/tencent/mm/plugin/sns/storage/n;
    //   375: aload_0
    //   376: getfield 94	com/tencent/mm/plugin/sns/model/be:Kcm	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   379: invokevirtual 984	com/tencent/mm/plugin/sns/storage/n:S	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)I
    //   382: istore_3
    //   383: invokestatic 988	com/tencent/mm/plugin/sns/model/aj:fOP	()Lcom/tencent/mm/plugin/sns/storage/k;
    //   386: astore 8
    //   388: aconst_null
    //   389: astore 7
    //   391: new 198	java/lang/StringBuilder
    //   394: dup
    //   395: ldc_w 990
    //   398: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: getstatic 995	com/tencent/mm/plugin/sns/storage/k:Kzv	Ljava/lang/String;
    //   404: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: getstatic 998	com/tencent/mm/plugin/sns/storage/k:Kzw	Ljava/lang/String;
    //   410: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 1000
    //   416: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 9
    //   424: aload 8
    //   426: getfield 1004	com/tencent/mm/plugin/sns/storage/k:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   429: aload 9
    //   431: aconst_null
    //   432: iconst_2
    //   433: invokeinterface 1010 4 0
    //   438: astore 9
    //   440: aload 9
    //   442: invokeinterface 1015 1 0
    //   447: ifeq +19 -> 466
    //   450: new 1017	com/tencent/mm/plugin/sns/storage/j
    //   453: dup
    //   454: invokespecial 1018	com/tencent/mm/plugin/sns/storage/j:<init>	()V
    //   457: astore 7
    //   459: aload 7
    //   461: aload 9
    //   463: invokevirtual 1022	com/tencent/mm/plugin/sns/storage/j:convertFrom	(Landroid/database/Cursor;)V
    //   466: aload 9
    //   468: invokeinterface 1025 1 0
    //   473: aload 7
    //   475: ifnull +36 -> 511
    //   478: aload 8
    //   480: ldc_w 1027
    //   483: iload_3
    //   484: invokestatic 180	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   487: invokevirtual 184	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   490: aload 7
    //   492: getfield 1031	com/tencent/mm/plugin/sns/storage/j:field_draft	[B
    //   495: iconst_0
    //   496: invokevirtual 1034	com/tencent/mm/plugin/sns/storage/k:b	(Ljava/lang/String;[BI)V
    //   499: aload 8
    //   501: aload 7
    //   503: getfield 1037	com/tencent/mm/plugin/sns/storage/j:field_key	Ljava/lang/String;
    //   506: aconst_null
    //   507: iconst_0
    //   508: invokevirtual 1034	com/tencent/mm/plugin/sns/storage/k:b	(Ljava/lang/String;[BI)V
    //   511: aload_0
    //   512: getfield 89	com/tencent/mm/plugin/sns/model/be:Kcl	Lcom/tencent/mm/protocal/protobuf/cvu;
    //   515: getfield 638	com/tencent/mm/protocal/protobuf/cvu:TEc	Ljava/util/LinkedList;
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
    //   545: checkcast 631	com/tencent/mm/protocal/protobuf/csn
    //   548: astore 8
    //   550: invokestatic 493	com/tencent/mm/plugin/sns/model/aj:fOx	()Lcom/tencent/mm/plugin/sns/storage/r;
    //   553: aload 8
    //   555: getfield 635	com/tencent/mm/protocal/protobuf/csn:TAo	I
    //   558: i2l
    //   559: invokevirtual 1041	com/tencent/mm/plugin/sns/storage/r:Re	(J)Lcom/tencent/mm/plugin/sns/storage/q;
    //   562: astore 10
    //   564: new 1043	com/tencent/mm/protocal/protobuf/cvw
    //   567: dup
    //   568: invokespecial 1044	com/tencent/mm/protocal/protobuf/cvw:<init>	()V
    //   571: aload 10
    //   573: getfield 1049	com/tencent/mm/plugin/sns/storage/q:KAa	[B
    //   576: invokevirtual 1053	com/tencent/mm/protocal/protobuf/cvw:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   579: checkcast 1043	com/tencent/mm/protocal/protobuf/cvw
    //   582: astore 11
    //   584: aload_0
    //   585: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   588: getfield 834	com/tencent/mm/protocal/protobuf/TimeLineObject:AppInfo	Lcom/tencent/mm/protocal/protobuf/ex;
    //   591: ifnull +18 -> 609
    //   594: aload 11
    //   596: aload_0
    //   597: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   600: getfield 834	com/tencent/mm/protocal/protobuf/TimeLineObject:AppInfo	Lcom/tencent/mm/protocal/protobuf/ex;
    //   603: getfield 838	com/tencent/mm/protocal/protobuf/ex:Id	Ljava/lang/String;
    //   606: putfield 1056	com/tencent/mm/protocal/protobuf/cvw:appid	Ljava/lang/String;
    //   609: aload_0
    //   610: getfield 132	com/tencent/mm/plugin/sns/model/be:fWm	Lcom/tencent/mm/protocal/protobuf/cuv;
    //   613: ifnull +11 -> 624
    //   616: aload_0
    //   617: getfield 132	com/tencent/mm/plugin/sns/model/be:fWm	Lcom/tencent/mm/protocal/protobuf/cuv;
    //   620: iconst_0
    //   621: putfield 1059	com/tencent/mm/protocal/protobuf/cuv:ABK	I
    //   624: aload 11
    //   626: aload_0
    //   627: getfield 132	com/tencent/mm/plugin/sns/model/be:fWm	Lcom/tencent/mm/protocal/protobuf/cuv;
    //   630: putfield 1062	com/tencent/mm/protocal/protobuf/cvw:TED	Lcom/tencent/mm/protocal/protobuf/cuv;
    //   633: aload 11
    //   635: aload_0
    //   636: getfield 84	com/tencent/mm/plugin/sns/model/be:Kck	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   639: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   642: getfield 163	com/tencent/mm/protocal/protobuf/adw:Sqq	I
    //   645: putfield 1063	com/tencent/mm/protocal/protobuf/cvw:aOl	I
    //   648: aload 11
    //   650: getfield 1063	com/tencent/mm/protocal/protobuf/cvw:aOl	I
    //   653: iconst_1
    //   654: if_icmpeq +13 -> 667
    //   657: aload 11
    //   659: getfield 1063	com/tencent/mm/protocal/protobuf/cvw:aOl	I
    //   662: bipush 15
    //   664: if_icmpne +22 -> 686
    //   667: aload 11
    //   669: getfield 1056	com/tencent/mm/protocal/protobuf/cvw:appid	Ljava/lang/String;
    //   672: invokestatic 623	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   675: ifne +71 -> 746
    //   678: iconst_5
    //   679: istore_1
    //   680: aload 11
    //   682: iload_1
    //   683: putfield 1066	com/tencent/mm/protocal/protobuf/cvw:TEE	I
    //   686: aload 10
    //   688: aload 11
    //   690: invokevirtual 1067	com/tencent/mm/protocal/protobuf/cvw:toByteArray	()[B
    //   693: putfield 1049	com/tencent/mm/plugin/sns/storage/q:KAa	[B
    //   696: invokestatic 493	com/tencent/mm/plugin/sns/model/aj:fOx	()Lcom/tencent/mm/plugin/sns/storage/r;
    //   699: aload 8
    //   701: getfield 635	com/tencent/mm/protocal/protobuf/csn:TAo	I
    //   704: aload 10
    //   706: invokevirtual 1070	com/tencent/mm/plugin/sns/storage/r:a	(ILcom/tencent/mm/plugin/sns/storage/q;)I
    //   709: pop
    //   710: aload 11
    //   712: getfield 1073	com/tencent/mm/protocal/protobuf/cvw:md5	Ljava/lang/String;
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
    //   732: invokeinterface 1025 1 0
    //   737: ldc_w 923
    //   740: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   743: aload 7
    //   745: athrow
    //   746: aload 11
    //   748: getfield 1062	com/tencent/mm/protocal/protobuf/cvw:TED	Lcom/tencent/mm/protocal/protobuf/cuv;
    //   751: ifnull +53 -> 804
    //   754: aload 11
    //   756: getfield 1063	com/tencent/mm/protocal/protobuf/cvw:aOl	I
    //   759: bipush 15
    //   761: if_icmpne +43 -> 804
    //   764: aload 11
    //   766: getfield 1062	com/tencent/mm/protocal/protobuf/cvw:TED	Lcom/tencent/mm/protocal/protobuf/cuv;
    //   769: getfield 1076	com/tencent/mm/protocal/protobuf/cuv:TCA	Z
    //   772: ifeq +27 -> 799
    //   775: iconst_1
    //   776: istore_1
    //   777: aload 11
    //   779: iload_1
    //   780: putfield 1066	com/tencent/mm/protocal/protobuf/cvw:TEE	I
    //   783: goto -97 -> 686
    //   786: astore 8
    //   788: ldc 172
    //   790: ldc_w 1078
    //   793: invokestatic 408	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: goto -268 -> 528
    //   799: iconst_2
    //   800: istore_1
    //   801: goto -24 -> 777
    //   804: aload_0
    //   805: getfield 890	com/tencent/mm/plugin/sns/model/be:Kcf	Ljava/util/List;
    //   808: iload_2
    //   809: invokeinterface 584 2 0
    //   814: checkcast 483	com/tencent/mm/plugin/sns/data/s
    //   817: getfield 1081	com/tencent/mm/plugin/sns/data/s:JRA	Z
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
    //   839: ldc_w 1083
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
    //   856: getfield 94	com/tencent/mm/plugin/sns/model/be:Kcm	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   859: invokevirtual 1086	com/tencent/mm/plugin/sns/storage/SnsInfo:getTypeFlag	()I
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
    //   879: getfield 94	com/tencent/mm/plugin/sns/model/be:Kcm	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   882: invokevirtual 1086	com/tencent/mm/plugin/sns/storage/SnsInfo:getTypeFlag	()I
    //   885: bipush 15
    //   887: if_icmpne +17 -> 904
    //   890: ldc_w 1088
    //   893: iload_3
    //   894: i2l
    //   895: invokestatic 1094	com/tencent/mm/plugin/sns/storage/y:bs	(Ljava/lang/String;J)Ljava/lang/String;
    //   898: aload 7
    //   900: invokestatic 1100	com/tencent/mm/plugin/sns/model/ax:kF	(Ljava/lang/String;Ljava/lang/String;)Z
    //   903: pop
    //   904: ldc 172
    //   906: new 198	java/lang/StringBuilder
    //   909: dup
    //   910: ldc_w 1102
    //   913: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   916: iload_3
    //   917: invokevirtual 529	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: ldc_w 1104
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
    //   946: getfield 170	com/tencent/mm/plugin/sns/model/be:mContextRef	Ljava/lang/ref/WeakReference;
    //   949: ifnull +13 -> 962
    //   952: aload_0
    //   953: getfield 170	com/tencent/mm/plugin/sns/model/be:mContextRef	Ljava/lang/ref/WeakReference;
    //   956: invokevirtual 1106	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   959: ifnonnull +11 -> 970
    //   962: ldc_w 923
    //   965: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   968: iload_3
    //   969: ireturn
    //   970: aload_0
    //   971: getfield 170	com/tencent/mm/plugin/sns/model/be:mContextRef	Ljava/lang/ref/WeakReference;
    //   974: invokevirtual 1106	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   977: checkcast 1108	android/content/Context
    //   980: astore 7
    //   982: getstatic 1114	com/tencent/mm/plugin/secdata/ui/a:JbV	Lcom/tencent/mm/plugin/secdata/ui/a$a;
    //   985: astore 8
    //   987: aload 7
    //   989: iconst_2
    //   990: ldc_w 1116
    //   993: invokestatic 1121	com/tencent/mm/plugin/secdata/ui/a$a:c	(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/cd/a;
    //   996: checkcast 1116	com/tencent/mm/plugin/sns/j/j
    //   999: astore 7
    //   1001: aload 7
    //   1003: ifnull -41 -> 962
    //   1006: aload 7
    //   1008: iload_3
    //   1009: putfield 1122	com/tencent/mm/plugin/sns/j/j:fWh	I
    //   1012: goto -50 -> 962
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1015	0	this	be
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
    //   985	1	8	locala	com.tencent.mm.plugin.secdata.ui.a.a
    //   422	309	9	localObject5	Object
    //   562	143	10	localq	com.tencent.mm.plugin.sns.storage.q
    //   582	196	11	localcvw	com.tencent.mm.protocal.protobuf.cvw
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
  
  public final be kG(String paramString1, String paramString2)
  {
    this.Kcl.token = paramString1;
    this.Kcl.TEk = paramString2;
    return this;
  }
  
  public final boolean kI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96053);
    String str = aj.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    baC(str);
    u.on(paramString1, str);
    paramString1 = kH("", str);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      AppMethodBeat.o(96053);
      return false;
    }
    paramString1.CMB = paramString2;
    if (Util.isNullOrNil(paramString1.fwr)) {
      paramString1.fwr = paramString2;
    }
    this.Kck.ContentObj.Sqr.add(paramString1);
    paramString2 = new csn();
    paramString2.TAo = paramString1.fWh;
    this.Kcl.TEc.add(paramString2);
    AppMethodBeat.o(96053);
    return true;
  }
  
  public final void setSessionId(String paramString)
  {
    this.Kcl.sessionId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.be
 * JD-Core Version:    0.7.0.1
 */