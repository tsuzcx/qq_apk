package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.e.c.a;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dai;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bb
{
  private static final Pattern iYL;
  public int aUt;
  public bsz dwW;
  private String fnC;
  int xNG;
  int xNH;
  List<com.tencent.mm.plugin.sns.data.p> xXI;
  String xXJ;
  String xXK;
  LinkedList<dbw> xXL;
  LinkedList<Long> xXM;
  public TimeLineObject xXN;
  public bua xXO;
  com.tencent.mm.plugin.sns.storage.p xXP;
  SnsObject xXQ;
  ba xXR;
  public deu xXS;
  public dyo xXT;
  private int xXU;
  private String xXV;
  private boolean xXW;
  
  static
  {
    AppMethodBeat.i(96061);
    iYL = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(96061);
  }
  
  public bb(int paramInt)
  {
    AppMethodBeat.i(96035);
    this.xXN = com.tencent.mm.modelsns.g.aIb();
    this.xXO = new bua();
    this.xXP = new com.tencent.mm.plugin.sns.storage.p();
    this.xXQ = null;
    Object localObject = new ba();
    ((ba)localObject).DNt = new ay();
    ((ba)localObject).DNv = new dx();
    ((ba)localObject).DNw = new el();
    this.xXR = ((ba)localObject);
    this.xXS = new deu();
    this.dwW = new bsz();
    this.xXT = null;
    this.fnC = "";
    this.xXU = 1;
    this.xXV = "";
    this.xXW = false;
    this.fnC = af.dHx();
    this.aUt = paramInt;
    this.xXN.FQo.Ety = paramInt;
    ac.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(paramInt)));
    this.xXN.Fjj = 0;
    this.xXN.ncR = this.fnC;
    this.xXO.hkN = com.tencent.mm.b.g.getMessageDigest((af.dHx() + bs.Gn() + System.currentTimeMillis()).getBytes());
    this.xXO.FjE = 0;
    this.xXO.FjF = 0;
    this.xXO.Fjj = 0;
    this.xXO.FjI = 0;
    this.xXO.gLY = 0;
    this.xXO.FjK = 0;
    this.xXO.FjM = 0;
    localObject = new SnsObject();
    ((SnsObject)localObject).Id = 0L;
    ((SnsObject)localObject).CreateTime = 0;
    ((SnsObject)localObject).LikeFlag = 0;
    ((SnsObject)localObject).Username = af.dHx();
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
    this.xXQ = ((SnsObject)localObject);
    localObject = this.xXP;
    ((com.tencent.mm.plugin.sns.storage.p)localObject).field_localFlag |= 0x10;
    this.xXP.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    this.xXP.field_type = paramInt;
    this.xXP.field_userName = this.fnC;
    this.xXP.field_pravited = 0;
    this.xXP.field_stringSeq = "0000099999999999999999999";
    this.xXP.Pb(2);
    this.xXP.dMr();
    if ((paramInt == 1) || (paramInt == 2)) {
      this.xXP.Pb(4);
    }
    if (paramInt == 7) {
      this.xXP.Pf(2);
    }
    this.xXM = new LinkedList();
    this.xXO.FjL = this.xXM;
    localObject = this.xXM.iterator();
    while (((Iterator)localObject).hasNext())
    {
      long l = ((Long)((Iterator)localObject).next()).longValue();
      dai localdai = new dai();
      localdai.FJD = l;
      this.xXQ.GroupList.add(localdai);
    }
    this.xXQ.GroupCount = this.xXM.size();
    AppMethodBeat.o(96035);
  }
  
  private static String aud(String paramString)
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
        str1 = iYL.matcher(str1).replaceAll("\n\n");
        AppMethodBeat.o(96036);
        return str1;
      }
      catch (Exception localException)
      {
        break label57;
      }
      ac.e("MicroMsg.UploadPackHelper", "filter desc error ");
      AppMethodBeat.o(96036);
      return paramString;
    }
  }
  
  public static void auo(String paramString)
  {
    AppMethodBeat.i(96052);
    i.aSh(i.aSs(paramString));
    AppMethodBeat.o(96052);
  }
  
  public static btz ax(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96050);
    btz localbtz = com.tencent.mm.modelsns.g.aIc();
    localbtz.Id = paramString1;
    ac.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbtz.ndI = 2;
    localbtz.Url = paramString2;
    localbtz.EUH = 0;
    localbtz.Fjh = paramString3;
    localbtz.Fji = 0;
    localbtz.Fjn = 1;
    AppMethodBeat.o(96050);
    return localbtz;
  }
  
  public static btz b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(96048);
    btz localbtz = com.tencent.mm.modelsns.g.aIc();
    localbtz.Id = paramString1;
    ac.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { Integer.valueOf(6), paramString2, paramString4, paramString5, paramString6 });
    localbtz.ndI = 6;
    if (i.aSp(paramString2) <= 0L)
    {
      AppMethodBeat.o(96048);
      return null;
    }
    paramString1 = new com.tencent.mm.plugin.sns.data.p(paramString2, 6);
    paramString1.xNK = paramString4;
    paramString2 = af.dHG().a(paramString1, paramString2, paramString3, paramString5, paramString6);
    if ((paramString2.height > 0) && (paramString2.width > 0) && (paramString2.fileSize > 0))
    {
      paramString1 = new bub();
      paramString1.FjZ = paramString2.height;
      paramString1.FjY = paramString2.width;
      paramString1.Fka = paramString2.fileSize;
    }
    for (;;)
    {
      localbtz.Id = ("Locall_path" + paramString2.dwR);
      localbtz.Fjk = paramString1;
      localbtz.dwR = paramString2.dwR;
      AppMethodBeat.o(96048);
      return localbtz;
      paramString1 = null;
    }
  }
  
  private static btz jg(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(96049);
    btz localbtz = com.tencent.mm.modelsns.g.aIc();
    localbtz.Id = paramString1;
    ac.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localbtz.ndI = 2;
    if (i.aSp(paramString2) <= 0L)
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString1 = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(paramString2).append(System.currentTimeMillis()).toString().getBytes());
    i.lZ(paramString2, paramString1);
    paramString1 = new com.tencent.mm.plugin.sns.data.p(paramString1, 2);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = af.dHG().fG(paramString2);
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
          paramString1 = new bub();
          paramString1.FjZ = paramString2.height;
          paramString1.FjY = paramString2.width;
          paramString1.Fka = paramString2.fileSize;
        }
      }
    }
    localbtz.Id = ("Locall_path" + paramString2.dwR);
    localbtz.Fjk = paramString1;
    localbtz.dwR = paramString2.dwR;
    AppMethodBeat.o(96049);
    return localbtz;
  }
  
  private static btz u(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96047);
    if (bs.cv(paramArrayOfByte))
    {
      ac.e("MicroMsg.UploadPackHelper", f.YG() + " attachBuf is null");
      AppMethodBeat.o(96047);
      return null;
    }
    String str = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
    i.aSh(af.getAccSnsTmpPath());
    ac.d("MicroMsg.UploadPackHelper", f.YG() + " buildUploadAttachInfo file:" + str);
    if (i.f(str, paramArrayOfByte, paramArrayOfByte.length) < 0)
    {
      ac.e("MicroMsg.UploadPackHelper", f.YG() + " writeFile error file:" + str);
      AppMethodBeat.o(96047);
      return null;
    }
    paramString = jg(paramString, str);
    AppMethodBeat.o(96047);
    return paramString;
  }
  
  public final bb Ou(int paramInt)
  {
    this.xXN.FQq = 1;
    this.xXN.FQr = paramInt;
    return this;
  }
  
  public final void Ov(int paramInt)
  {
    AppMethodBeat.i(96039);
    ac.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(paramInt)));
    this.xXO.FjK = paramInt;
    AppMethodBeat.o(96039);
  }
  
  public final bb Ow(int paramInt)
  {
    AppMethodBeat.i(96040);
    this.xNH = paramInt;
    this.xXO.Fjj = paramInt;
    this.xXN.Fjj = paramInt;
    if (paramInt > 0)
    {
      this.xXP.field_pravited = paramInt;
      this.xXP.dMo();
      this.xXP.Pf(2);
      this.xXP.dMs();
    }
    AppMethodBeat.o(96040);
    return this;
  }
  
  public final bb Ox(int paramInt)
  {
    this.xNG = paramInt;
    this.xXO.FjF = paramInt;
    return this;
  }
  
  public final bb Oy(int paramInt)
  {
    this.xXO.FjM = paramInt;
    return this;
  }
  
  public final bb Oz(int paramInt)
  {
    if (paramInt == 1) {
      this.xXQ.ExtFlag = 3;
    }
    for (;;)
    {
      this.xXO.FjP = paramInt;
      return this;
      if (paramInt == 0) {
        this.xXQ.ExtFlag = 5;
      }
    }
  }
  
  public final bb a(brd parambrd)
  {
    if (parambrd == null) {
      return this;
    }
    this.xXN.FQm = parambrd;
    return this;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(96056);
    paramArrayOfByte = u("", paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
      AppMethodBeat.o(96056);
      return false;
    }
    paramArrayOfByte.Desc = paramString1;
    if (paramInt > 0) {
      paramArrayOfByte.subType = paramInt;
    }
    if (!bs.isNullOrNil(paramString3)) {
      paramArrayOfByte.yyV = paramString3;
    }
    if (!bs.isNullOrNil(paramString2)) {
      paramArrayOfByte.Title = paramString2;
    }
    if (!bs.isNullOrNil(paramString1)) {
      paramArrayOfByte.Desc = paramString1;
    }
    this.xXN.FQo.Etz.add(paramArrayOfByte);
    paramString1 = new bqx();
    paramString1.Fgc = paramArrayOfByte.dwR;
    this.xXO.FjG.add(paramString1);
    AppMethodBeat.o(96056);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(96057);
    paramArrayOfByte = u("", paramArrayOfByte);
    if ((paramArrayOfByte == null) || ((bs.isNullOrNil(paramString2)) && (bs.isNullOrNil(paramString3))))
    {
      ac.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
      AppMethodBeat.o(96057);
      return false;
    }
    if (!bs.isNullOrNil(paramString1)) {
      this.xXN.FQo.Url = paramString1;
    }
    if (!bs.isNullOrNil(paramString3))
    {
      paramArrayOfByte.Url = paramString3;
      paramArrayOfByte.EUH = 0;
    }
    for (;;)
    {
      if (!bs.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Fjl = paramString2;
        paramArrayOfByte.Fjm = 0;
      }
      paramArrayOfByte.ndI = paramInt;
      paramArrayOfByte.Title = bs.bG(paramString4, "");
      paramArrayOfByte.Desc = bs.bG(paramString5, "");
      paramArrayOfByte.songAlbumUrl = paramString6;
      paramArrayOfByte.songLyric = paramString7;
      this.xXN.FQo.Etz.add(paramArrayOfByte);
      paramString1 = new bqx();
      paramString1.Fgc = paramArrayOfByte.dwR;
      this.xXO.FjG.add(paramString1);
      AppMethodBeat.o(96057);
      return true;
      if (!bs.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Url = paramString2;
        paramArrayOfByte.EUH = 0;
      }
    }
  }
  
  public final bb aT(LinkedList<dbw> paramLinkedList)
  {
    AppMethodBeat.i(96041);
    this.xXL = paramLinkedList;
    this.xXO.FjH = paramLinkedList;
    paramLinkedList = this.xXL.iterator();
    while (paramLinkedList.hasNext())
    {
      dbw localdbw = (dbw)paramLinkedList.next();
      daa localdaa = new daa();
      localdaa.Username = localdbw.ncR;
      this.xXQ.WithUserList.add(localdaa);
    }
    this.xXQ.WithUserCount = this.xXL.size();
    this.xXQ.WithUserListCount = this.xXL.size();
    AppMethodBeat.o(96041);
    return this;
  }
  
  public final bb aue(String paramString)
  {
    AppMethodBeat.i(96037);
    this.xXJ = aud(paramString);
    this.xXN.FQl = this.xXJ;
    AppMethodBeat.o(96037);
    return this;
  }
  
  public final bb auf(String paramString)
  {
    this.xXN.FQs = paramString;
    this.xXR.DNt.DNn = paramString;
    return this;
  }
  
  public final bb aug(String paramString)
  {
    this.xXN.yCb = paramString;
    return this;
  }
  
  public final bb auh(String paramString)
  {
    this.xXK = paramString;
    this.xXN.FQo.Desc = paramString;
    return this;
  }
  
  public final bb aui(String paramString)
  {
    this.xXN.FQo.Url = paramString;
    return this;
  }
  
  public final bb auj(String paramString)
  {
    this.xXN.FQo.Title = paramString;
    return this;
  }
  
  public final bb auk(String paramString)
  {
    AppMethodBeat.i(96042);
    ej localej2 = this.xXN.FQn;
    ej localej1 = localej2;
    if (localej2 == null) {
      localej1 = new ej();
    }
    localej1.Id = paramString;
    this.xXN.FQn = localej1;
    AppMethodBeat.o(96042);
    return this;
  }
  
  public final bb aul(String paramString)
  {
    AppMethodBeat.i(96043);
    ej localej2 = this.xXN.FQn;
    ej localej1 = localej2;
    if (localej2 == null) {
      localej1 = new ej();
    }
    localej1.tkL = paramString;
    this.xXN.FQn = localej1;
    AppMethodBeat.o(96043);
    return this;
  }
  
  public final bb aum(String paramString)
  {
    AppMethodBeat.i(96044);
    this.xXN.jEq = bs.nullAsNil(paramString);
    AppMethodBeat.o(96044);
    return this;
  }
  
  public final bb aun(String paramString)
  {
    AppMethodBeat.i(96045);
    this.xXN.DpN = bs.nullAsNil(paramString);
    AppMethodBeat.o(96045);
    return this;
  }
  
  public final bb aw(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96038);
    ay localay = this.xXR.DNt;
    Object localObject = paramString1;
    if (bs.isNullOrNil(paramString1)) {
      localObject = "";
    }
    localay.hOf = ((String)localObject);
    localObject = this.xXR.DNt;
    paramString1 = paramString2;
    if (bs.isNullOrNil(paramString2)) {
      paramString1 = "";
    }
    ((ay)localObject).DNo = paramString1;
    paramString2 = this.xXR.DNt;
    paramString1 = paramString3;
    if (bs.isNullOrNil(paramString3)) {
      paramString1 = "";
    }
    paramString2.DNp = paramString1;
    AppMethodBeat.o(96038);
    return this;
  }
  
  public final boolean b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96055);
    boolean bool = a(paramArrayOfByte, paramString1, paramString2, -1, "");
    AppMethodBeat.o(96055);
    return bool;
  }
  
  public final bb bV(int paramInt, String paramString)
  {
    this.xXU = paramInt;
    this.xXV = paramString;
    return this;
  }
  
  @Deprecated
  public final boolean c(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(96054);
    paramString1 = ax("", paramString1, paramString2);
    if (paramString1 == null)
    {
      ac.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(96054);
      return false;
    }
    paramString1.Desc = paramString3;
    if (paramInt > 0) {
      paramString1.subType = paramInt;
    }
    if (!bs.isNullOrNil(paramString4)) {
      paramString1.yyV = paramString4;
    }
    this.xXN.FQo.Etz.add(paramString1);
    AppMethodBeat.o(96054);
    return true;
  }
  
  /* Error */
  public final int commit()
  {
    // Byte code:
    //   0: ldc_w 761
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: aload_0
    //   12: getfield 82	com/tencent/mm/plugin/sns/model/bb:xXO	Lcom/tencent/mm/protocal/protobuf/bua;
    //   15: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   18: putfield 764	com/tencent/mm/protocal/protobuf/bua:FjJ	J
    //   21: aload_0
    //   22: getfield 82	com/tencent/mm/plugin/sns/model/bb:xXO	Lcom/tencent/mm/protocal/protobuf/bua;
    //   25: iconst_0
    //   26: putfield 232	com/tencent/mm/protocal/protobuf/bua:gLY	I
    //   29: new 766	com/tencent/mm/protocal/protobuf/cbh
    //   32: dup
    //   33: invokespecial 767	com/tencent/mm/protocal/protobuf/cbh:<init>	()V
    //   36: astore 7
    //   38: aload 7
    //   40: aload_0
    //   41: getfield 133	com/tencent/mm/plugin/sns/model/bb:xXU	I
    //   44: putfield 770	com/tencent/mm/protocal/protobuf/cbh:DRh	I
    //   47: aload 7
    //   49: aload_0
    //   50: getfield 135	com/tencent/mm/plugin/sns/model/bb:xXV	Ljava/lang/String;
    //   53: putfield 773	com/tencent/mm/protocal/protobuf/cbh:thr	Ljava/lang/String;
    //   56: aload_0
    //   57: getfield 82	com/tencent/mm/plugin/sns/model/bb:xXO	Lcom/tencent/mm/protocal/protobuf/bua;
    //   60: aload 7
    //   62: putfield 777	com/tencent/mm/protocal/protobuf/bua:FjX	Lcom/tencent/mm/protocal/protobuf/cbh;
    //   65: aload_0
    //   66: getfield 87	com/tencent/mm/plugin/sns/model/bb:xXP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   69: aload_0
    //   70: getfield 89	com/tencent/mm/plugin/sns/model/bb:xXQ	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   73: invokevirtual 780	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   76: invokevirtual 784	com/tencent/mm/plugin/sns/storage/p:bB	([B)V
    //   79: aload_0
    //   80: getfield 87	com/tencent/mm/plugin/sns/model/bb:xXP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   83: aload_0
    //   84: getfield 82	com/tencent/mm/plugin/sns/model/bb:xXO	Lcom/tencent/mm/protocal/protobuf/bua;
    //   87: invokevirtual 785	com/tencent/mm/protocal/protobuf/bua:toByteArray	()[B
    //   90: putfield 789	com/tencent/mm/plugin/sns/storage/p:field_postBuf	[B
    //   93: ldc 158
    //   95: new 184	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 791
    //   102: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 89	com/tencent/mm/plugin/sns/model/bb:xXQ	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   109: invokevirtual 792	java/lang/Object:toString	()Ljava/lang/String;
    //   112: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 176	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: ldc 158
    //   123: new 184	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 794
    //   130: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 82	com/tencent/mm/plugin/sns/model/bb:xXO	Lcom/tencent/mm/protocal/protobuf/bua;
    //   137: invokevirtual 792	java/lang/Object:toString	()Ljava/lang/String;
    //   140: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 176	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: ldc 158
    //   151: new 184	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 796
    //   158: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   165: invokevirtual 792	java/lang/Object:toString	()Ljava/lang/String;
    //   168: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 176	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   181: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
    //   184: getfield 629	com/tencent/mm/protocal/protobuf/zf:Etz	Ljava/util/LinkedList;
    //   187: ifnull +138 -> 325
    //   190: ldc 158
    //   192: ldc_w 798
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_0
    //   202: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   205: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
    //   208: getfield 629	com/tencent/mm/protocal/protobuf/zf:Etz	Ljava/util/LinkedList;
    //   211: invokevirtual 373	java/util/LinkedList:size	()I
    //   214: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: invokestatic 800	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: iconst_0
    //   222: istore_1
    //   223: iload_1
    //   224: aload_0
    //   225: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   228: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
    //   231: getfield 629	com/tencent/mm/protocal/protobuf/zf:Etz	Ljava/util/LinkedList;
    //   234: invokevirtual 373	java/util/LinkedList:size	()I
    //   237: if_icmpge +88 -> 325
    //   240: aload_0
    //   241: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   244: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
    //   247: getfield 629	com/tencent/mm/protocal/protobuf/zf:Etz	Ljava/util/LinkedList;
    //   250: iload_1
    //   251: invokevirtual 801	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   254: checkcast 428	com/tencent/mm/protocal/protobuf/btz
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +39 -> 300
    //   264: ldc 158
    //   266: ldc_w 803
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 7
    //   277: getfield 522	com/tencent/mm/protocal/protobuf/btz:dwR	I
    //   280: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 7
    //   288: getfield 438	com/tencent/mm/protocal/protobuf/btz:Url	Ljava/lang/String;
    //   291: ldc 129
    //   293: invokestatic 653	com/tencent/mm/sdk/platformtools/bs:bG	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 800	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   319: invokestatic 807	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: goto -173 -> 149
    //   325: aload_0
    //   326: getfield 115	com/tencent/mm/plugin/sns/model/bb:xXR	Lcom/tencent/mm/protocal/protobuf/ba;
    //   329: ifnull +14 -> 343
    //   332: aload_0
    //   333: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   336: aload_0
    //   337: getfield 115	com/tencent/mm/plugin/sns/model/bb:xXR	Lcom/tencent/mm/protocal/protobuf/ba;
    //   340: putfield 808	com/tencent/mm/protocal/protobuf/TimeLineObject:xXR	Lcom/tencent/mm/protocal/protobuf/ba;
    //   343: aload_0
    //   344: getfield 127	com/tencent/mm/plugin/sns/model/bb:xXT	Lcom/tencent/mm/protocal/protobuf/dyo;
    //   347: ifnull +14 -> 361
    //   350: aload_0
    //   351: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   354: aload_0
    //   355: getfield 127	com/tencent/mm/plugin/sns/model/bb:xXT	Lcom/tencent/mm/protocal/protobuf/dyo;
    //   358: putfield 809	com/tencent/mm/protocal/protobuf/TimeLineObject:xXT	Lcom/tencent/mm/protocal/protobuf/dyo;
    //   361: aload_0
    //   362: getfield 87	com/tencent/mm/plugin/sns/model/bb:xXP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   365: aload_0
    //   366: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   369: invokevirtual 812	com/tencent/mm/plugin/sns/storage/p:f	(Lcom/tencent/mm/protocal/protobuf/TimeLineObject;)V
    //   372: invokestatic 816	com/tencent/mm/plugin/sns/model/af:dHR	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   375: aload_0
    //   376: getfield 87	com/tencent/mm/plugin/sns/model/bb:xXP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   379: invokevirtual 821	com/tencent/mm/plugin/sns/storage/q:J	(Lcom/tencent/mm/plugin/sns/storage/p;)I
    //   382: istore_3
    //   383: invokestatic 825	com/tencent/mm/plugin/sns/model/af:dHY	()Lcom/tencent/mm/plugin/sns/storage/m;
    //   386: astore 8
    //   388: aconst_null
    //   389: astore 7
    //   391: new 184	java/lang/StringBuilder
    //   394: dup
    //   395: ldc_w 827
    //   398: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: getstatic 832	com/tencent/mm/plugin/sns/storage/m:yvv	Ljava/lang/String;
    //   404: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: getstatic 835	com/tencent/mm/plugin/sns/storage/m:yvw	Ljava/lang/String;
    //   410: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 837
    //   416: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 9
    //   424: aload 8
    //   426: getfield 841	com/tencent/mm/plugin/sns/storage/m:db	Lcom/tencent/mm/sdk/e/e;
    //   429: aload 9
    //   431: aconst_null
    //   432: iconst_2
    //   433: invokeinterface 846 4 0
    //   438: astore 9
    //   440: aload 9
    //   442: invokeinterface 851 1 0
    //   447: ifeq +19 -> 466
    //   450: new 853	com/tencent/mm/plugin/sns/storage/l
    //   453: dup
    //   454: invokespecial 854	com/tencent/mm/plugin/sns/storage/l:<init>	()V
    //   457: astore 7
    //   459: aload 7
    //   461: aload 9
    //   463: invokevirtual 858	com/tencent/mm/plugin/sns/storage/l:convertFrom	(Landroid/database/Cursor;)V
    //   466: aload 9
    //   468: invokeinterface 861 1 0
    //   473: aload 7
    //   475: ifnull +36 -> 511
    //   478: aload 8
    //   480: ldc_w 863
    //   483: iload_3
    //   484: invokestatic 166	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   487: invokevirtual 170	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   490: aload 7
    //   492: getfield 866	com/tencent/mm/plugin/sns/storage/l:field_draft	[B
    //   495: iconst_0
    //   496: invokevirtual 869	com/tencent/mm/plugin/sns/storage/m:b	(Ljava/lang/String;[BI)V
    //   499: aload 8
    //   501: aload 7
    //   503: getfield 872	com/tencent/mm/plugin/sns/storage/l:field_key	Ljava/lang/String;
    //   506: aconst_null
    //   507: iconst_0
    //   508: invokevirtual 869	com/tencent/mm/plugin/sns/storage/m:b	(Ljava/lang/String;[BI)V
    //   511: aload_0
    //   512: getfield 82	com/tencent/mm/plugin/sns/model/bb:xXO	Lcom/tencent/mm/protocal/protobuf/bua;
    //   515: getfield 638	com/tencent/mm/protocal/protobuf/bua:FjG	Ljava/util/LinkedList;
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
    //   545: checkcast 631	com/tencent/mm/protocal/protobuf/bqx
    //   548: astore 8
    //   550: invokestatic 479	com/tencent/mm/plugin/sns/model/af:dHG	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   553: aload 8
    //   555: getfield 635	com/tencent/mm/protocal/protobuf/bqx:Fgc	I
    //   558: i2l
    //   559: invokevirtual 876	com/tencent/mm/plugin/sns/storage/u:xL	(J)Lcom/tencent/mm/plugin/sns/storage/t;
    //   562: astore 10
    //   564: new 878	com/tencent/mm/protocal/protobuf/buc
    //   567: dup
    //   568: invokespecial 879	com/tencent/mm/protocal/protobuf/buc:<init>	()V
    //   571: aload 10
    //   573: getfield 884	com/tencent/mm/plugin/sns/storage/t:ywe	[B
    //   576: invokevirtual 888	com/tencent/mm/protocal/protobuf/buc:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   579: checkcast 878	com/tencent/mm/protocal/protobuf/buc
    //   582: astore 11
    //   584: aload_0
    //   585: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   588: getfield 710	com/tencent/mm/protocal/protobuf/TimeLineObject:FQn	Lcom/tencent/mm/protocal/protobuf/ej;
    //   591: ifnull +18 -> 609
    //   594: aload 11
    //   596: aload_0
    //   597: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   600: getfield 710	com/tencent/mm/protocal/protobuf/TimeLineObject:FQn	Lcom/tencent/mm/protocal/protobuf/ej;
    //   603: getfield 714	com/tencent/mm/protocal/protobuf/ej:Id	Ljava/lang/String;
    //   606: putfield 891	com/tencent/mm/protocal/protobuf/buc:djj	Ljava/lang/String;
    //   609: aload_0
    //   610: getfield 125	com/tencent/mm/plugin/sns/model/bb:dwW	Lcom/tencent/mm/protocal/protobuf/bsz;
    //   613: ifnull +11 -> 624
    //   616: aload_0
    //   617: getfield 125	com/tencent/mm/plugin/sns/model/bb:dwW	Lcom/tencent/mm/protocal/protobuf/bsz;
    //   620: iconst_0
    //   621: putfield 894	com/tencent/mm/protocal/protobuf/bsz:rNU	I
    //   624: aload 11
    //   626: aload_0
    //   627: getfield 125	com/tencent/mm/plugin/sns/model/bb:dwW	Lcom/tencent/mm/protocal/protobuf/bsz;
    //   630: putfield 897	com/tencent/mm/protocal/protobuf/buc:Fkh	Lcom/tencent/mm/protocal/protobuf/bsz;
    //   633: aload 11
    //   635: aload_0
    //   636: getfield 77	com/tencent/mm/plugin/sns/model/bb:xXN	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   639: getfield 151	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
    //   642: getfield 156	com/tencent/mm/protocal/protobuf/zf:Ety	I
    //   645: putfield 898	com/tencent/mm/protocal/protobuf/buc:aUt	I
    //   648: aload 11
    //   650: getfield 898	com/tencent/mm/protocal/protobuf/buc:aUt	I
    //   653: iconst_1
    //   654: if_icmpeq +13 -> 667
    //   657: aload 11
    //   659: getfield 898	com/tencent/mm/protocal/protobuf/buc:aUt	I
    //   662: bipush 15
    //   664: if_icmpne +22 -> 686
    //   667: aload 11
    //   669: getfield 891	com/tencent/mm/protocal/protobuf/buc:djj	Ljava/lang/String;
    //   672: invokestatic 620	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   675: ifne +71 -> 746
    //   678: iconst_5
    //   679: istore_1
    //   680: aload 11
    //   682: iload_1
    //   683: putfield 901	com/tencent/mm/protocal/protobuf/buc:Fki	I
    //   686: aload 10
    //   688: aload 11
    //   690: invokevirtual 902	com/tencent/mm/protocal/protobuf/buc:toByteArray	()[B
    //   693: putfield 884	com/tencent/mm/plugin/sns/storage/t:ywe	[B
    //   696: invokestatic 479	com/tencent/mm/plugin/sns/model/af:dHG	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   699: aload 8
    //   701: getfield 635	com/tencent/mm/protocal/protobuf/bqx:Fgc	I
    //   704: aload 10
    //   706: invokevirtual 905	com/tencent/mm/plugin/sns/storage/u:a	(ILcom/tencent/mm/plugin/sns/storage/t;)I
    //   709: pop
    //   710: aload 11
    //   712: getfield 908	com/tencent/mm/protocal/protobuf/buc:md5	Ljava/lang/String;
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
    //   732: invokeinterface 861 1 0
    //   737: ldc_w 761
    //   740: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   743: aload 7
    //   745: athrow
    //   746: aload 11
    //   748: getfield 897	com/tencent/mm/protocal/protobuf/buc:Fkh	Lcom/tencent/mm/protocal/protobuf/bsz;
    //   751: ifnull +53 -> 804
    //   754: aload 11
    //   756: getfield 898	com/tencent/mm/protocal/protobuf/buc:aUt	I
    //   759: bipush 15
    //   761: if_icmpne +43 -> 804
    //   764: aload 11
    //   766: getfield 897	com/tencent/mm/protocal/protobuf/buc:Fkh	Lcom/tencent/mm/protocal/protobuf/bsz;
    //   769: getfield 911	com/tencent/mm/protocal/protobuf/bsz:FhZ	Z
    //   772: ifeq +27 -> 799
    //   775: iconst_1
    //   776: istore_1
    //   777: aload 11
    //   779: iload_1
    //   780: putfield 901	com/tencent/mm/protocal/protobuf/buc:Fki	I
    //   783: goto -97 -> 686
    //   786: astore 8
    //   788: ldc 158
    //   790: ldc_w 913
    //   793: invokestatic 407	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: goto -268 -> 528
    //   799: iconst_2
    //   800: istore_1
    //   801: goto -24 -> 777
    //   804: aload_0
    //   805: getfield 915	com/tencent/mm/plugin/sns/model/bb:xXI	Ljava/util/List;
    //   808: iload_2
    //   809: invokeinterface 544 2 0
    //   814: checkcast 469	com/tencent/mm/plugin/sns/data/p
    //   817: getfield 918	com/tencent/mm/plugin/sns/data/p:xNL	Z
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
    //   839: ldc_w 920
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
    //   856: getfield 87	com/tencent/mm/plugin/sns/model/bb:xXP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   859: getfield 312	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   862: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   865: aastore
    //   866: dup
    //   867: iconst_2
    //   868: aload 7
    //   870: aastore
    //   871: invokestatic 463	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   874: iload_3
    //   875: ifle +29 -> 904
    //   878: aload_0
    //   879: getfield 87	com/tencent/mm/plugin/sns/model/bb:xXP	Lcom/tencent/mm/plugin/sns/storage/p;
    //   882: getfield 312	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   885: bipush 15
    //   887: if_icmpne +17 -> 904
    //   890: ldc_w 922
    //   893: iload_3
    //   894: i2l
    //   895: invokestatic 928	com/tencent/mm/plugin/sns/storage/x:bj	(Ljava/lang/String;J)Ljava/lang/String;
    //   898: aload 7
    //   900: invokestatic 934	com/tencent/mm/plugin/sns/model/au:je	(Ljava/lang/String;Ljava/lang/String;)Z
    //   903: pop
    //   904: ldc 158
    //   906: new 184	java/lang/StringBuilder
    //   909: dup
    //   910: ldc_w 936
    //   913: invokespecial 511	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   916: iload_3
    //   917: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: ldc_w 938
    //   923: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   929: lload 4
    //   931: lsub
    //   932: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   935: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokestatic 176	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: ldc_w 761
    //   944: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   947: iload_3
    //   948: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	bb
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
    //   582	196	11	localbuc	com.tencent.mm.protocal.protobuf.buc
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
  
  public final bb fy(List<String> paramList)
  {
    AppMethodBeat.i(96046);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.xXQ.ExtFlag = 1;
      AppMethodBeat.o(96046);
      return this;
    }
    paramList = paramList.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      crm localcrm = new crm();
      localcrm.aJV(str);
      localLinkedList.add(localcrm);
    }
    this.xXO.GroupUser = localLinkedList;
    if (this.xXQ.ExtFlag == 3)
    {
      this.xXQ.BlackList = localLinkedList;
      this.xXQ.BlackListCount = localLinkedList.size();
    }
    for (;;)
    {
      AppMethodBeat.o(96046);
      return this;
      if (this.xXQ.ExtFlag == 5)
      {
        this.xXQ.GroupUser = localLinkedList;
        this.xXQ.GroupUserCount = localLinkedList.size();
      }
    }
  }
  
  public final void fz(List<com.tencent.mm.plugin.sns.data.p> paramList)
  {
    AppMethodBeat.i(96058);
    this.xXI = paramList;
    paramList = af.dHG().fG(this.xXI);
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
      bqx localbqx = new bqx();
      localbqx.Fgc = localp.dwR;
      ((LinkedList)localObject1).add(localbqx);
    }
    this.xXO.FjG = ((LinkedList)localObject1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.sns.data.p)paramList.next();
      localObject2 = new bub();
      ((bub)localObject2).FjZ = 0.0F;
      ((bub)localObject2).FjY = 0.0F;
      ((bub)localObject2).Fka = 0.0F;
      if ((((com.tencent.mm.plugin.sns.data.p)localObject1).height > 0) && (((com.tencent.mm.plugin.sns.data.p)localObject1).width > 0) && (((com.tencent.mm.plugin.sns.data.p)localObject1).fileSize > 0))
      {
        ((bub)localObject2).FjZ = ((com.tencent.mm.plugin.sns.data.p)localObject1).height;
        ((bub)localObject2).FjY = ((com.tencent.mm.plugin.sns.data.p)localObject1).width;
        ((bub)localObject2).Fka = ((com.tencent.mm.plugin.sns.data.p)localObject1).fileSize;
      }
      localObject1 = com.tencent.mm.modelsns.g.a("Locall_path" + ((com.tencent.mm.plugin.sns.data.p)localObject1).dwR, ((com.tencent.mm.plugin.sns.data.p)localObject1).type, "", "", 0, 0, this.xNH, "", (bub)localObject2);
      this.xXN.FQo.Etz.add(localObject1);
    }
    AppMethodBeat.o(96058);
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96059);
    daw localdaw = new daw();
    localdaw.DRe = paramString1;
    localdaw.DRf = paramString2;
    localdaw.DRg = paramString3;
    localdaw.yCc = paramInt1;
    localdaw.yCd = paramInt2;
    this.xXO.FjQ = localdaw;
    AppMethodBeat.o(96059);
  }
  
  public final bb jf(String paramString1, String paramString2)
  {
    this.xXO.token = paramString1;
    this.xXO.FjO = paramString2;
    return this;
  }
  
  public final boolean jh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96053);
    String str = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    auo(str);
    i.lZ(paramString1, str);
    paramString1 = jg("", str);
    if (paramString1 == null)
    {
      ac.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      AppMethodBeat.o(96053);
      return false;
    }
    paramString1.Desc = paramString2;
    if (bs.isNullOrNil(paramString1.Title)) {
      paramString1.Title = paramString2;
    }
    this.xXN.FQo.Etz.add(paramString1);
    paramString2 = new bqx();
    paramString2.Fgc = paramString1.dwR;
    this.xXO.FjG.add(paramString2);
    AppMethodBeat.o(96053);
    return true;
  }
  
  public final void setSessionId(String paramString)
  {
    this.xXO.sessionId = paramString;
  }
  
  public final boolean y(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(96051);
    Object localObject = c.wDO;
    localObject = c.arc(paramString1);
    if (localObject != null) {
      ac.i("MicroMsg.UploadPackHelper", "addSightObjectByPath commit video_info:".concat(String.valueOf(localObject)));
    }
    for (float f = ((c.a)localObject).duration / 1000.0F;; f = 0.0F)
    {
      localObject = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
      auo((String)localObject);
      i.lZ(paramString1, (String)localObject);
      paramString1 = af.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString2.getBytes());
      i.lZ(paramString2, paramString1);
      paramString1 = b("", (String)localObject, paramString1, paramString4, "", "");
      if (paramString1 == null)
      {
        ac.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
        AppMethodBeat.o(96051);
        return false;
      }
      paramString1.Desc = paramString3;
      if (bs.isNullOrNil(paramString1.Title)) {
        paramString1.Title = paramString3;
      }
      paramString1.FjD = f;
      this.xXN.FQo.Etz.add(paramString1);
      paramString2 = new bqx();
      paramString2.Fgc = paramString1.dwR;
      this.xXO.FjG.add(paramString2);
      AppMethodBeat.o(96051);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bb
 * JD-Core Version:    0.7.0.1
 */