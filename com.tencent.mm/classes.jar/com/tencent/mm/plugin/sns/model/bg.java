package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.recordvideo.util.g.a;
import com.tencent.mm.plugin.sns.data.s;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.protocal.protobuf.feu;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.gom;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bg
{
  private static final Pattern PATTERN;
  int Qog;
  int Qoh;
  public TimeLineObject QzA;
  public dna QzB;
  public SnsInfo QzC;
  SnsObject QzD;
  public fjo QzE;
  private int QzF;
  private String QzG;
  private boolean QzH;
  List<s> Qzw;
  String Qzx;
  LinkedList<ffw> Qzy;
  LinkedList<Long> Qzz;
  bh actionInfo;
  public int cIh;
  public dmb icl;
  private String ltf;
  private WeakReference<Context> mContextRef;
  String uyk;
  public gib webSearchInfo;
  
  static
  {
    AppMethodBeat.i(96061);
    PATTERN = Pattern.compile("(\n){3,}");
    AppMethodBeat.o(96061);
  }
  
  public bg(int paramInt)
  {
    this(paramInt, null);
    AppMethodBeat.i(96035);
    AppMethodBeat.o(96035);
  }
  
  public bg(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(309389);
    this.QzA = o.bMJ();
    this.QzB = new dna();
    this.QzC = new SnsInfo();
    this.QzD = null;
    Object localObject = new bh();
    ((bh)localObject).YCC = new bd();
    ((bh)localObject).YCE = new fb();
    ((bh)localObject).YCF = new ft();
    this.actionInfo = ((bh)localObject);
    this.QzE = new fjo();
    this.icl = new dmb();
    this.webSearchInfo = null;
    this.ltf = "";
    this.QzF = 1;
    this.QzG = "";
    this.QzH = false;
    this.ltf = al.hgg();
    this.cIh = paramInt;
    this.QzA.ContentObj.Zpq = paramInt;
    if (paramContext != null) {
      this.mContextRef = new WeakReference(paramContext);
    }
    Log.d("MicroMsg.UploadPackHelper", "contentType ".concat(String.valueOf(paramInt)));
    this.QzA.Privated = 0;
    this.QzA.UserName = this.ltf;
    this.QzB.nUv = com.tencent.mm.b.g.getMessageDigest((al.hgg() + Util.currentTicks() + System.currentTimeMillis()).getBytes());
    this.QzB.aaTG = 0;
    this.QzB.aaTH = 0;
    this.QzB.Privated = 0;
    this.QzB.aaTK = 0;
    this.QzB.nrQ = 0;
    this.QzB.aaTM = 0;
    this.QzB.aaTO = 0;
    paramContext = new SnsObject();
    paramContext.Id = 0L;
    paramContext.CreateTime = 0;
    paramContext.LikeFlag = 0;
    paramContext.Username = al.hgg();
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
    paramContext.ObjectDesc = new gol().df(new byte[0]);
    this.QzD = paramContext;
    this.QzC.setPostWaiting();
    this.QzC.setCreateTime((int)(System.currentTimeMillis() / 1000L));
    this.QzC.setTypeFlag(paramInt);
    this.QzC.setUserName(this.ltf);
    this.QzC.setPravited(0);
    this.QzC.setStringSeq("0000099999999999999999999");
    this.QzC.addSourceFlag(2);
    this.QzC.setExtFlag();
    if ((paramInt == 1) || (paramInt == 2)) {
      this.QzC.addSourceFlag(4);
    }
    if (paramInt == 7) {
      this.QzC.removeSourceFlag(2);
    }
    this.Qzz = new LinkedList();
    this.QzB.aaTN = this.Qzz;
    paramContext = this.Qzz.iterator();
    while (paramContext.hasNext())
    {
      long l = ((Long)paramContext.next()).longValue();
      localObject = new fee();
      ((fee)localObject).abDQ = l;
      this.QzD.GroupList.add(localObject);
    }
    this.QzD.GroupCount = this.Qzz.size();
    AppMethodBeat.o(309389);
  }
  
  private static dmz D(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96047);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.UploadPackHelper", f.aPX() + " attachBuf is null");
      AppMethodBeat.o(96047);
      return null;
    }
    String str = al.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder(" ").append(System.currentTimeMillis()).toString().getBytes());
    y.bDX(al.getAccSnsTmpPath());
    Log.d("MicroMsg.UploadPackHelper", f.aPX() + " buildUploadAttachInfo file:" + str);
    if (y.f(str, paramArrayOfByte, paramArrayOfByte.length) < 0)
    {
      Log.e("MicroMsg.UploadPackHelper", f.aPX() + " writeFile error file:" + str);
      AppMethodBeat.o(96047);
      return null;
    }
    paramString = mn(paramString, str);
    AppMethodBeat.o(96047);
    return paramString;
  }
  
  private static String aYL(String paramString)
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
  
  public static void aYW(String paramString)
  {
    AppMethodBeat.i(96052);
    y.bDX(y.bEo(paramString));
    AppMethodBeat.o(96052);
  }
  
  private static dmz aZ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96050);
    dmz localdmz = o.bMK();
    localdmz.Id = paramString1;
    Log.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localdmz.vhJ = 2;
    localdmz.Url = paramString2;
    localdmz.aazR = 0;
    localdmz.aaTl = paramString3;
    localdmz.aaTm = 0;
    localdmz.aaTq = 1;
    AppMethodBeat.o(96050);
    return localdmz;
  }
  
  public static dmz d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(96048);
    dmz localdmz = o.bMK();
    localdmz.Id = paramString1;
    Log.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { Integer.valueOf(6), paramString2, paramString4, paramString5, paramString6 });
    localdmz.vhJ = 6;
    if (y.bEl(paramString2) <= 0L)
    {
      AppMethodBeat.o(96048);
      return null;
    }
    paramString1 = new s(paramString2, 6);
    paramString1.Qok = paramString4;
    paramString2 = al.hgq().a(paramString1, paramString2, paramString3, paramString5, paramString6);
    if ((paramString2.height > 0) && (paramString2.width > 0) && (paramString2.fileSize > 0))
    {
      paramString1 = new dnb();
      paramString1.aaUc = paramString2.height;
      paramString1.aaUb = paramString2.width;
      paramString1.aaUd = paramString2.fileSize;
    }
    for (;;)
    {
      localdmz.Id = ("Locall_path" + paramString2.icg);
      localdmz.aaTn = paramString1;
      localdmz.icg = paramString2.icg;
      AppMethodBeat.o(96048);
      return localdmz;
      paramString1 = null;
    }
  }
  
  private static dmz mn(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(96049);
    dmz localdmz = o.bMK();
    localdmz.Id = paramString1;
    Log.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
    localdmz.vhJ = 2;
    if (y.bEl(paramString2) <= 0L)
    {
      AppMethodBeat.o(96049);
      return null;
    }
    paramString1 = al.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(paramString2).append(System.currentTimeMillis()).toString().getBytes());
    y.O(paramString2, paramString1, false);
    paramString1 = new s(paramString1, 2);
    paramString2 = new LinkedList();
    paramString2.add(paramString1);
    paramString1 = al.hgq().kF(paramString2);
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
          paramString1 = new dnb();
          paramString1.aaUc = paramString2.height;
          paramString1.aaUb = paramString2.width;
          paramString1.aaUd = paramString2.fileSize;
        }
      }
    }
    localdmz.Id = ("Locall_path" + paramString2.icg);
    localdmz.aaTn = paramString1;
    localdmz.icg = paramString2.icg;
    AppMethodBeat.o(96049);
    return localdmz;
  }
  
  /* Error */
  public final int FW()
  {
    // Byte code:
    //   0: ldc_w 585
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: aload_0
    //   12: getfield 89	com/tencent/mm/plugin/sns/model/bg:QzB	Lcom/tencent/mm/protocal/protobuf/dna;
    //   15: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   18: putfield 588	com/tencent/mm/protocal/protobuf/dna:aaTL	J
    //   21: aload_0
    //   22: getfield 89	com/tencent/mm/plugin/sns/model/bg:QzB	Lcom/tencent/mm/protocal/protobuf/dna;
    //   25: iconst_0
    //   26: putfield 246	com/tencent/mm/protocal/protobuf/dna:nrQ	I
    //   29: new 590	com/tencent/mm/protocal/protobuf/dyq
    //   32: dup
    //   33: invokespecial 591	com/tencent/mm/protocal/protobuf/dyq:<init>	()V
    //   36: astore 7
    //   38: aload 7
    //   40: aload_0
    //   41: getfield 140	com/tencent/mm/plugin/sns/model/bg:QzF	I
    //   44: putfield 594	com/tencent/mm/protocal/protobuf/dyq:YHq	I
    //   47: aload 7
    //   49: aload_0
    //   50: getfield 142	com/tencent/mm/plugin/sns/model/bg:QzG	Ljava/lang/String;
    //   53: putfield 597	com/tencent/mm/protocal/protobuf/dyq:IcK	Ljava/lang/String;
    //   56: aload_0
    //   57: getfield 89	com/tencent/mm/plugin/sns/model/bg:QzB	Lcom/tencent/mm/protocal/protobuf/dna;
    //   60: aload 7
    //   62: putfield 601	com/tencent/mm/protocal/protobuf/dna:aaTZ	Lcom/tencent/mm/protocal/protobuf/dyq;
    //   65: aload_0
    //   66: getfield 94	com/tencent/mm/plugin/sns/model/bg:QzC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   69: aload_0
    //   70: getfield 96	com/tencent/mm/plugin/sns/model/bg:QzD	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   73: invokevirtual 604	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   76: invokevirtual 608	com/tencent/mm/plugin/sns/storage/SnsInfo:setAttrBuf	([B)V
    //   79: aload_0
    //   80: getfield 94	com/tencent/mm/plugin/sns/model/bg:QzC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   83: aload_0
    //   84: getfield 89	com/tencent/mm/plugin/sns/model/bg:QzB	Lcom/tencent/mm/protocal/protobuf/dna;
    //   87: invokevirtual 609	com/tencent/mm/protocal/protobuf/dna:toByteArray	()[B
    //   90: invokevirtual 612	com/tencent/mm/plugin/sns/storage/SnsInfo:setPostBuf	([B)V
    //   93: ldc 172
    //   95: new 198	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 614
    //   102: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 96	com/tencent/mm/plugin/sns/model/bg:QzD	Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   109: invokevirtual 615	java/lang/Object:toString	()Ljava/lang/String;
    //   112: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: ldc 172
    //   123: new 198	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 617
    //   130: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 89	com/tencent/mm/plugin/sns/model/bg:QzB	Lcom/tencent/mm/protocal/protobuf/dna;
    //   137: invokevirtual 615	java/lang/Object:toString	()Ljava/lang/String;
    //   140: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: ldc 172
    //   151: new 198	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 619
    //   158: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   165: invokevirtual 615	java/lang/Object:toString	()Ljava/lang/String;
    //   168: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   181: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   184: getfield 622	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   187: ifnull +138 -> 325
    //   190: ldc 172
    //   192: ldc_w 624
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_0
    //   202: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   205: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   208: getfield 622	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   211: invokevirtual 388	java/util/LinkedList:size	()I
    //   214: invokestatic 506	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: invokestatic 626	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: iconst_0
    //   222: istore_1
    //   223: iload_1
    //   224: aload_0
    //   225: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   228: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   231: getfield 622	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   234: invokevirtual 388	java/util/LinkedList:size	()I
    //   237: if_icmpge +88 -> 325
    //   240: aload_0
    //   241: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   244: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   247: getfield 622	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   250: iload_1
    //   251: invokevirtual 627	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   254: checkcast 475	com/tencent/mm/protocal/protobuf/dmz
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +39 -> 300
    //   264: ldc 172
    //   266: ldc_w 629
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 7
    //   277: getfield 566	com/tencent/mm/protocal/protobuf/dmz:icg	I
    //   280: invokestatic 506	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 7
    //   288: getfield 485	com/tencent/mm/protocal/protobuf/dmz:Url	Ljava/lang/String;
    //   291: ldc 136
    //   293: invokestatic 633	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 626	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   319: invokestatic 637	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: goto -173 -> 149
    //   325: aload_0
    //   326: getfield 122	com/tencent/mm/plugin/sns/model/bg:actionInfo	Lcom/tencent/mm/protocal/protobuf/bh;
    //   329: ifnull +14 -> 343
    //   332: aload_0
    //   333: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   336: aload_0
    //   337: getfield 122	com/tencent/mm/plugin/sns/model/bg:actionInfo	Lcom/tencent/mm/protocal/protobuf/bh;
    //   340: putfield 638	com/tencent/mm/protocal/protobuf/TimeLineObject:actionInfo	Lcom/tencent/mm/protocal/protobuf/bh;
    //   343: aload_0
    //   344: getfield 134	com/tencent/mm/plugin/sns/model/bg:webSearchInfo	Lcom/tencent/mm/protocal/protobuf/gib;
    //   347: ifnull +14 -> 361
    //   350: aload_0
    //   351: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   354: aload_0
    //   355: getfield 134	com/tencent/mm/plugin/sns/model/bg:webSearchInfo	Lcom/tencent/mm/protocal/protobuf/gib;
    //   358: putfield 639	com/tencent/mm/protocal/protobuf/TimeLineObject:webSearchInfo	Lcom/tencent/mm/protocal/protobuf/gib;
    //   361: aload_0
    //   362: getfield 94	com/tencent/mm/plugin/sns/model/bg:QzC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   365: aload_0
    //   366: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   369: invokevirtual 643	com/tencent/mm/plugin/sns/storage/SnsInfo:setTimeLine	(Lcom/tencent/mm/protocal/protobuf/TimeLineObject;)V
    //   372: invokestatic 647	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   375: aload_0
    //   376: getfield 94	com/tencent/mm/plugin/sns/model/bg:QzC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   379: invokevirtual 653	com/tencent/mm/plugin/sns/storage/w:U	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)I
    //   382: istore_3
    //   383: invokestatic 657	com/tencent/mm/plugin/sns/model/al:hgJ	()Lcom/tencent/mm/plugin/sns/storage/t;
    //   386: astore 8
    //   388: aconst_null
    //   389: astore 7
    //   391: new 198	java/lang/StringBuilder
    //   394: dup
    //   395: ldc_w 659
    //   398: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: getstatic 664	com/tencent/mm/plugin/sns/storage/t:QYN	Ljava/lang/String;
    //   404: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: getstatic 667	com/tencent/mm/plugin/sns/storage/t:QYO	Ljava/lang/String;
    //   410: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 669
    //   416: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 9
    //   424: aload 8
    //   426: getfield 673	com/tencent/mm/plugin/sns/storage/t:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   429: aload 9
    //   431: aconst_null
    //   432: iconst_2
    //   433: invokeinterface 679 4 0
    //   438: astore 9
    //   440: aload 9
    //   442: invokeinterface 684 1 0
    //   447: ifeq +19 -> 466
    //   450: new 686	com/tencent/mm/plugin/sns/storage/s
    //   453: dup
    //   454: invokespecial 687	com/tencent/mm/plugin/sns/storage/s:<init>	()V
    //   457: astore 7
    //   459: aload 7
    //   461: aload 9
    //   463: invokevirtual 691	com/tencent/mm/plugin/sns/storage/s:convertFrom	(Landroid/database/Cursor;)V
    //   466: aload 9
    //   468: invokeinterface 694 1 0
    //   473: aload 7
    //   475: ifnull +36 -> 511
    //   478: aload 8
    //   480: ldc_w 696
    //   483: iload_3
    //   484: invokestatic 180	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   487: invokevirtual 184	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   490: aload 7
    //   492: getfield 700	com/tencent/mm/plugin/sns/storage/s:field_draft	[B
    //   495: iconst_0
    //   496: invokevirtual 704	com/tencent/mm/plugin/sns/storage/t:b	(Ljava/lang/String;[BI)V
    //   499: aload 8
    //   501: aload 7
    //   503: getfield 707	com/tencent/mm/plugin/sns/storage/s:field_key	Ljava/lang/String;
    //   506: aconst_null
    //   507: iconst_0
    //   508: invokevirtual 704	com/tencent/mm/plugin/sns/storage/t:b	(Ljava/lang/String;[BI)V
    //   511: aload_0
    //   512: getfield 89	com/tencent/mm/plugin/sns/model/bg:QzB	Lcom/tencent/mm/protocal/protobuf/dna;
    //   515: getfield 710	com/tencent/mm/protocal/protobuf/dna:aaTI	Ljava/util/LinkedList;
    //   518: invokevirtual 356	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   521: astore 9
    //   523: iconst_0
    //   524: istore_2
    //   525: aconst_null
    //   526: astore 7
    //   528: aload 9
    //   530: invokeinterface 362 1 0
    //   535: ifeq +350 -> 885
    //   538: aload 9
    //   540: invokeinterface 366 1 0
    //   545: checkcast 712	com/tencent/mm/protocal/protobuf/djp
    //   548: astore 8
    //   550: invokestatic 525	com/tencent/mm/plugin/sns/model/al:hgq	()Lcom/tencent/mm/plugin/sns/storage/aa;
    //   553: aload 8
    //   555: getfield 715	com/tencent/mm/protocal/protobuf/djp:aaPC	I
    //   558: i2l
    //   559: invokevirtual 719	com/tencent/mm/plugin/sns/storage/aa:vk	(J)Lcom/tencent/mm/plugin/sns/storage/z;
    //   562: astore 10
    //   564: new 721	com/tencent/mm/protocal/protobuf/dnc
    //   567: dup
    //   568: invokespecial 722	com/tencent/mm/protocal/protobuf/dnc:<init>	()V
    //   571: aload 10
    //   573: getfield 727	com/tencent/mm/plugin/sns/storage/z:QZv	[B
    //   576: invokevirtual 731	com/tencent/mm/protocal/protobuf/dnc:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   579: checkcast 721	com/tencent/mm/protocal/protobuf/dnc
    //   582: astore 11
    //   584: aload_0
    //   585: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   588: getfield 735	com/tencent/mm/protocal/protobuf/TimeLineObject:AppInfo	Lcom/tencent/mm/protocal/protobuf/fr;
    //   591: ifnull +18 -> 609
    //   594: aload 11
    //   596: aload_0
    //   597: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   600: getfield 735	com/tencent/mm/protocal/protobuf/TimeLineObject:AppInfo	Lcom/tencent/mm/protocal/protobuf/fr;
    //   603: getfield 738	com/tencent/mm/protocal/protobuf/fr:Id	Ljava/lang/String;
    //   606: putfield 741	com/tencent/mm/protocal/protobuf/dnc:appid	Ljava/lang/String;
    //   609: aload_0
    //   610: getfield 122	com/tencent/mm/plugin/sns/model/bg:actionInfo	Lcom/tencent/mm/protocal/protobuf/bh;
    //   613: ifnull +44 -> 657
    //   616: aload_0
    //   617: getfield 122	com/tencent/mm/plugin/sns/model/bg:actionInfo	Lcom/tencent/mm/protocal/protobuf/bh;
    //   620: getfield 106	com/tencent/mm/protocal/protobuf/bh:YCC	Lcom/tencent/mm/protocal/protobuf/bd;
    //   623: ifnull +34 -> 657
    //   626: aload_0
    //   627: getfield 122	com/tencent/mm/plugin/sns/model/bg:actionInfo	Lcom/tencent/mm/protocal/protobuf/bh;
    //   630: getfield 106	com/tencent/mm/protocal/protobuf/bh:YCC	Lcom/tencent/mm/protocal/protobuf/bd;
    //   633: getfield 744	com/tencent/mm/protocal/protobuf/bd:oOI	Ljava/lang/String;
    //   636: invokestatic 746	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   639: ifne +18 -> 657
    //   642: aload 11
    //   644: aload_0
    //   645: getfield 122	com/tencent/mm/plugin/sns/model/bg:actionInfo	Lcom/tencent/mm/protocal/protobuf/bh;
    //   648: getfield 106	com/tencent/mm/protocal/protobuf/bh:YCC	Lcom/tencent/mm/protocal/protobuf/bd;
    //   651: getfield 744	com/tencent/mm/protocal/protobuf/bd:oOI	Ljava/lang/String;
    //   654: putfield 741	com/tencent/mm/protocal/protobuf/dnc:appid	Ljava/lang/String;
    //   657: aload_0
    //   658: getfield 132	com/tencent/mm/plugin/sns/model/bg:icl	Lcom/tencent/mm/protocal/protobuf/dmb;
    //   661: ifnull +11 -> 672
    //   664: aload_0
    //   665: getfield 132	com/tencent/mm/plugin/sns/model/bg:icl	Lcom/tencent/mm/protocal/protobuf/dmb;
    //   668: iconst_0
    //   669: putfield 749	com/tencent/mm/protocal/protobuf/dmb:Gad	I
    //   672: aload 11
    //   674: aload_0
    //   675: getfield 132	com/tencent/mm/plugin/sns/model/bg:icl	Lcom/tencent/mm/protocal/protobuf/dmb;
    //   678: putfield 752	com/tencent/mm/protocal/protobuf/dnc:aaUk	Lcom/tencent/mm/protocal/protobuf/dmb;
    //   681: aload 11
    //   683: aload_0
    //   684: getfield 84	com/tencent/mm/plugin/sns/model/bg:QzA	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   687: getfield 158	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   690: getfield 163	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   693: putfield 753	com/tencent/mm/protocal/protobuf/dnc:cIh	I
    //   696: aload 11
    //   698: getfield 753	com/tencent/mm/protocal/protobuf/dnc:cIh	I
    //   701: iconst_1
    //   702: if_icmpeq +13 -> 715
    //   705: aload 11
    //   707: getfield 753	com/tencent/mm/protocal/protobuf/dnc:cIh	I
    //   710: bipush 15
    //   712: if_icmpne +22 -> 734
    //   715: aload 11
    //   717: getfield 741	com/tencent/mm/protocal/protobuf/dnc:appid	Ljava/lang/String;
    //   720: invokestatic 746	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   723: ifne +71 -> 794
    //   726: iconst_5
    //   727: istore_1
    //   728: aload 11
    //   730: iload_1
    //   731: putfield 756	com/tencent/mm/protocal/protobuf/dnc:aaUl	I
    //   734: aload 10
    //   736: aload 11
    //   738: invokevirtual 757	com/tencent/mm/protocal/protobuf/dnc:toByteArray	()[B
    //   741: putfield 727	com/tencent/mm/plugin/sns/storage/z:QZv	[B
    //   744: invokestatic 525	com/tencent/mm/plugin/sns/model/al:hgq	()Lcom/tencent/mm/plugin/sns/storage/aa;
    //   747: aload 8
    //   749: getfield 715	com/tencent/mm/protocal/protobuf/djp:aaPC	I
    //   752: aload 10
    //   754: invokevirtual 760	com/tencent/mm/plugin/sns/storage/aa:a	(ILcom/tencent/mm/plugin/sns/storage/z;)I
    //   757: pop
    //   758: aload 11
    //   760: getfield 763	com/tencent/mm/protocal/protobuf/dnc:md5	Ljava/lang/String;
    //   763: astore 8
    //   765: iload_2
    //   766: iconst_1
    //   767: iadd
    //   768: istore_2
    //   769: aload 8
    //   771: astore 7
    //   773: goto -245 -> 528
    //   776: astore 7
    //   778: aload 9
    //   780: invokeinterface 694 1 0
    //   785: ldc_w 585
    //   788: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   791: aload 7
    //   793: athrow
    //   794: aload 11
    //   796: getfield 752	com/tencent/mm/protocal/protobuf/dnc:aaUk	Lcom/tencent/mm/protocal/protobuf/dmb;
    //   799: ifnull +53 -> 852
    //   802: aload 11
    //   804: getfield 753	com/tencent/mm/protocal/protobuf/dnc:cIh	I
    //   807: bipush 15
    //   809: if_icmpne +43 -> 852
    //   812: aload 11
    //   814: getfield 752	com/tencent/mm/protocal/protobuf/dnc:aaUk	Lcom/tencent/mm/protocal/protobuf/dmb;
    //   817: getfield 766	com/tencent/mm/protocal/protobuf/dmb:aaSg	Z
    //   820: ifeq +27 -> 847
    //   823: iconst_1
    //   824: istore_1
    //   825: aload 11
    //   827: iload_1
    //   828: putfield 756	com/tencent/mm/protocal/protobuf/dnc:aaUl	I
    //   831: goto -97 -> 734
    //   834: astore 8
    //   836: ldc 172
    //   838: ldc_w 768
    //   841: invokestatic 408	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   844: goto -316 -> 528
    //   847: iconst_2
    //   848: istore_1
    //   849: goto -24 -> 825
    //   852: aload_0
    //   853: getfield 770	com/tencent/mm/plugin/sns/model/bg:Qzw	Ljava/util/List;
    //   856: iload_2
    //   857: invokeinterface 583 2 0
    //   862: checkcast 515	com/tencent/mm/plugin/sns/data/s
    //   865: getfield 773	com/tencent/mm/plugin/sns/data/s:Qol	Z
    //   868: istore 6
    //   870: iload 6
    //   872: ifeq +8 -> 880
    //   875: iconst_1
    //   876: istore_1
    //   877: goto -149 -> 728
    //   880: iconst_2
    //   881: istore_1
    //   882: goto -154 -> 728
    //   885: ldc 172
    //   887: ldc_w 775
    //   890: iconst_3
    //   891: anewarray 4	java/lang/Object
    //   894: dup
    //   895: iconst_0
    //   896: iload_3
    //   897: invokestatic 506	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   900: aastore
    //   901: dup
    //   902: iconst_1
    //   903: aload_0
    //   904: getfield 94	com/tencent/mm/plugin/sns/model/bg:QzC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   907: invokevirtual 778	com/tencent/mm/plugin/sns/storage/SnsInfo:getTypeFlag	()I
    //   910: invokestatic 506	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   913: aastore
    //   914: dup
    //   915: iconst_2
    //   916: aload 7
    //   918: aastore
    //   919: invokestatic 509	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   922: iload_3
    //   923: ifle +29 -> 952
    //   926: aload_0
    //   927: getfield 94	com/tencent/mm/plugin/sns/model/bg:QzC	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   930: invokevirtual 778	com/tencent/mm/plugin/sns/storage/SnsInfo:getTypeFlag	()I
    //   933: bipush 15
    //   935: if_icmpne +17 -> 952
    //   938: ldc_w 780
    //   941: iload_3
    //   942: i2l
    //   943: invokestatic 786	com/tencent/mm/plugin/sns/storage/ai:bE	(Ljava/lang/String;J)Ljava/lang/String;
    //   946: aload 7
    //   948: invokestatic 792	com/tencent/mm/plugin/sns/model/az:mk	(Ljava/lang/String;Ljava/lang/String;)Z
    //   951: pop
    //   952: ldc 172
    //   954: new 198	java/lang/StringBuilder
    //   957: dup
    //   958: ldc_w 794
    //   961: invokespecial 415	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   964: iload_3
    //   965: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   968: ldc_w 796
    //   971: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   977: lload 4
    //   979: lsub
    //   980: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   983: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   989: iload_3
    //   990: ifle +20 -> 1010
    //   993: aload_0
    //   994: getfield 170	com/tencent/mm/plugin/sns/model/bg:mContextRef	Ljava/lang/ref/WeakReference;
    //   997: ifnull +13 -> 1010
    //   1000: aload_0
    //   1001: getfield 170	com/tencent/mm/plugin/sns/model/bg:mContextRef	Ljava/lang/ref/WeakReference;
    //   1004: invokevirtual 798	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1007: ifnonnull +11 -> 1018
    //   1010: ldc_w 585
    //   1013: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1016: iload_3
    //   1017: ireturn
    //   1018: aload_0
    //   1019: getfield 170	com/tencent/mm/plugin/sns/model/bg:mContextRef	Ljava/lang/ref/WeakReference;
    //   1022: invokevirtual 798	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1025: checkcast 800	android/content/Context
    //   1028: astore 7
    //   1030: getstatic 806	com/tencent/mm/plugin/secdata/ui/a:PlI	Lcom/tencent/mm/plugin/secdata/ui/a$a;
    //   1033: astore 8
    //   1035: aload 7
    //   1037: iconst_2
    //   1038: ldc_w 808
    //   1041: invokestatic 814	com/tencent/mm/plugin/secdata/ui/a$a:c	(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/bx/a;
    //   1044: checkcast 808	com/tencent/mm/plugin/sns/k/j
    //   1047: astore 7
    //   1049: aload 7
    //   1051: ifnull -41 -> 1010
    //   1054: aload 7
    //   1056: iload_3
    //   1057: putfield 815	com/tencent/mm/plugin/sns/k/j:icg	I
    //   1060: goto -50 -> 1010
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1063	0	this	bg
    //   222	660	1	i	int
    //   524	333	2	j	int
    //   382	675	3	k	int
    //   9	969	4	l	long
    //   868	3	6	bool	boolean
    //   36	251	7	localObject1	Object
    //   307	5	7	localException1	Exception
    //   389	383	7	localObject2	Object
    //   776	171	7	str	String
    //   1028	27	7	localObject3	Object
    //   386	384	8	localObject4	Object
    //   834	1	8	localException2	Exception
    //   1033	1	8	locala	com.tencent.mm.plugin.secdata.ui.a.a
    //   422	357	9	localObject5	Object
    //   562	191	10	localz	com.tencent.mm.plugin.sns.storage.z
    //   582	244	11	localdnc	com.tencent.mm.protocal.protobuf.dnc
    // Exception table:
    //   from	to	target	type
    //   11	149	307	java/lang/Exception
    //   440	466	776	finally
    //   564	609	834	java/lang/Exception
    //   609	657	834	java/lang/Exception
    //   657	672	834	java/lang/Exception
    //   672	715	834	java/lang/Exception
    //   715	726	834	java/lang/Exception
    //   728	734	834	java/lang/Exception
    //   734	765	834	java/lang/Exception
    //   794	823	834	java/lang/Exception
    //   825	831	834	java/lang/Exception
    //   852	870	834	java/lang/Exception
  }
  
  public final boolean K(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(96051);
    Object localObject = com.tencent.mm.plugin.recordvideo.util.g.Obu;
    localObject = com.tencent.mm.plugin.recordvideo.util.g.aTF(paramString1);
    if (localObject != null) {
      Log.i("MicroMsg.UploadPackHelper", "addSightObjectByPath commit video_info:".concat(String.valueOf(localObject)));
    }
    for (float f = ((g.a)localObject).duration / 1000.0F;; f = 0.0F)
    {
      localObject = al.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
      aYW((String)localObject);
      y.O(paramString1, (String)localObject, false);
      paramString1 = al.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString2.getBytes());
      y.O(paramString2, paramString1, false);
      paramString1 = d("", (String)localObject, paramString1, paramString4, "", "");
      if (paramString1 == null)
      {
        Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
        AppMethodBeat.o(96051);
        return false;
      }
      paramString1.IGG = paramString3;
      if (Util.isNullOrNil(paramString1.hAP)) {
        paramString1.hAP = paramString3;
      }
      paramString1.aaTF = f;
      this.QzA.ContentObj.Zpr.add(paramString1);
      paramString2 = new djp();
      paramString2.aaPC = paramString1.icg;
      this.QzB.aaTI.add(paramString2);
      AppMethodBeat.o(96051);
      return true;
    }
  }
  
  public final bg a(djv paramdjv)
  {
    if (paramdjv == null) {
      return this;
    }
    this.QzA.Location = paramdjv;
    return this;
  }
  
  public final void a(d paramd)
  {
    if (paramd != null) {
      this.QzA.ContentObj.DHa = paramd.oUb;
    }
  }
  
  public final void a(e parame)
  {
    if (parame != null) {
      this.QzA.ContentObj.hKU = parame.oUc;
    }
  }
  
  public final void a(com.tencent.mm.modelsns.g paramg)
  {
    if (paramg != null) {
      this.QzA.ContentObj.Zpv = paramg.oTZ;
    }
  }
  
  public final void a(h paramh)
  {
    if (paramh != null) {
      this.QzA.ContentObj.Zpy = paramh.oUe;
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(96056);
    paramArrayOfByte = D("", paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
      AppMethodBeat.o(96056);
      return false;
    }
    paramArrayOfByte.IGG = paramString1;
    if (paramInt > 0) {
      paramArrayOfByte.subType = paramInt;
    }
    if (!Util.isNullOrNil(paramString3)) {
      paramArrayOfByte.RcB = paramString3;
    }
    if (!Util.isNullOrNil(paramString2)) {
      paramArrayOfByte.hAP = paramString2;
    }
    if (!Util.isNullOrNil(paramString1)) {
      paramArrayOfByte.IGG = paramString1;
    }
    this.QzA.ContentObj.Zpr.add(paramArrayOfByte);
    paramString1 = new djp();
    paramString1.aaPC = paramArrayOfByte.icg;
    this.QzB.aaTI.add(paramString1);
    AppMethodBeat.o(96056);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(309460);
    paramArrayOfByte = D("", paramArrayOfByte);
    if ((paramArrayOfByte == null) || ((Util.isNullOrNil(paramString2)) && (Util.isNullOrNil(paramString3))))
    {
      Log.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
      AppMethodBeat.o(309460);
      return false;
    }
    if (!Util.isNullOrNil(paramString1)) {
      this.QzA.ContentObj.Url = paramString1;
    }
    if (!Util.isNullOrNil(paramString3))
    {
      paramArrayOfByte.Url = paramString3;
      paramArrayOfByte.aazR = 0;
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        paramArrayOfByte.aaTo = paramString2;
        paramArrayOfByte.aaTp = 0;
      }
      paramArrayOfByte.vhJ = paramInt;
      paramArrayOfByte.hAP = Util.nullAs(paramString4, "");
      paramArrayOfByte.IGG = Util.nullAs(paramString5, "");
      paramArrayOfByte.songAlbumUrl = paramString6;
      paramArrayOfByte.songLyric = paramString7;
      this.QzA.ContentObj.Zpr.add(paramArrayOfByte);
      paramString1 = new djp();
      paramString1.aaPC = paramArrayOfByte.icg;
      this.QzB.aaTI.add(paramString1);
      AppMethodBeat.o(309460);
      return true;
      if (!Util.isNullOrNil(paramString2))
      {
        paramArrayOfByte.Url = paramString2;
        paramArrayOfByte.aazR = 0;
      }
    }
  }
  
  public final bg aY(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96038);
    bd localbd = this.actionInfo.YCC;
    Object localObject = paramString1;
    if (Util.isNullOrNil(paramString1)) {
      localObject = "";
    }
    localbd.oOI = ((String)localObject);
    localObject = this.actionInfo.YCC;
    paramString1 = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      paramString1 = "";
    }
    ((bd)localObject).YCn = paramString1;
    paramString2 = this.actionInfo.YCC;
    paramString1 = paramString3;
    if (Util.isNullOrNil(paramString3)) {
      paramString1 = "";
    }
    paramString2.YCo = paramString1;
    AppMethodBeat.o(96038);
    return this;
  }
  
  public final bg aYM(String paramString)
  {
    AppMethodBeat.i(96037);
    this.uyk = aYL(paramString);
    this.QzA.ContentDesc = this.uyk;
    AppMethodBeat.o(96037);
    return this;
  }
  
  public final bg aYN(String paramString)
  {
    this.QzA.statisticsData = paramString;
    this.actionInfo.YCC.YCm = paramString;
    return this;
  }
  
  public final bg aYO(String paramString)
  {
    this.QzA.canvasInfo = paramString;
    return this;
  }
  
  public final bg aYP(String paramString)
  {
    this.Qzx = paramString;
    this.QzA.ContentObj.IGG = paramString;
    return this;
  }
  
  public final bg aYQ(String paramString)
  {
    this.QzA.ContentObj.Url = paramString;
    return this;
  }
  
  public final bg aYR(String paramString)
  {
    this.QzA.ContentObj.hAP = paramString;
    return this;
  }
  
  public final bg aYS(String paramString)
  {
    AppMethodBeat.i(96042);
    fr localfr2 = this.QzA.AppInfo;
    fr localfr1 = localfr2;
    if (localfr2 == null) {
      localfr1 = new fr();
    }
    localfr1.Id = paramString;
    this.QzA.AppInfo = localfr1;
    AppMethodBeat.o(96042);
    return this;
  }
  
  public final bg aYT(String paramString)
  {
    AppMethodBeat.i(96043);
    fr localfr2 = this.QzA.AppInfo;
    fr localfr1 = localfr2;
    if (localfr2 == null) {
      localfr1 = new fr();
    }
    localfr1.IKJ = paramString;
    this.QzA.AppInfo = localfr1;
    AppMethodBeat.o(96043);
    return this;
  }
  
  public final bg aYU(String paramString)
  {
    AppMethodBeat.i(96044);
    this.QzA.sourceUserName = Util.nullAsNil(paramString);
    AppMethodBeat.o(96044);
    return this;
  }
  
  public final bg aYV(String paramString)
  {
    AppMethodBeat.i(96045);
    this.QzA.sourceNickName = Util.nullAsNil(paramString);
    AppMethodBeat.o(96045);
    return this;
  }
  
  public final void aYX(String paramString)
  {
    this.QzB.iag = paramString;
  }
  
  public final bg akL(int paramInt)
  {
    this.QzA.contentDescShowType = 1;
    this.QzA.contentDescScene = paramInt;
    return this;
  }
  
  public final bg akM(int paramInt)
  {
    this.QzA.contentattr = paramInt;
    return this;
  }
  
  public final void akN(int paramInt)
  {
    AppMethodBeat.i(96039);
    Log.d("MicroMsg.UploadPackHelper", "set post form ".concat(String.valueOf(paramInt)));
    this.QzB.aaTM = paramInt;
    AppMethodBeat.o(96039);
  }
  
  public final bg akO(int paramInt)
  {
    AppMethodBeat.i(96040);
    this.Qoh = paramInt;
    this.QzB.Privated = paramInt;
    this.QzA.Privated = paramInt;
    if (paramInt > 0)
    {
      this.QzC.setPravited(paramInt);
      this.QzC.setLocalPrivate();
      this.QzC.removeSourceFlag(2);
      this.QzC.unSetExtFlag();
    }
    AppMethodBeat.o(96040);
    return this;
  }
  
  public final bg akP(int paramInt)
  {
    this.Qog = paramInt;
    this.QzB.aaTH = paramInt;
    return this;
  }
  
  public final bg akQ(int paramInt)
  {
    this.QzB.aaTO = paramInt;
    return this;
  }
  
  public final bg akR(int paramInt)
  {
    if (paramInt == 1) {
      this.QzD.ExtFlag = 3;
    }
    for (;;)
    {
      this.QzB.aaTR = paramInt;
      return this;
      if (paramInt == 0) {
        this.QzD.ExtFlag = 5;
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
  
  public final bg bU(LinkedList<ffw> paramLinkedList)
  {
    AppMethodBeat.i(96041);
    this.Qzy = paramLinkedList;
    this.QzB.aaTJ = paramLinkedList;
    paramLinkedList = this.Qzy.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (ffw)paramLinkedList.next();
      fdv localfdv = new fdv();
      localfdv.Username = ((ffw)localObject).UserName;
      this.QzD.WithUserList.add(localfdv);
      if (aj.hga())
      {
        localObject = new etl();
        ((etl)localObject).btH(localfdv.Username);
        this.QzD.WithTaList.add(localObject);
        this.QzD.NewWithTaList.add(localfdv);
      }
    }
    if ((aj.hga()) && (this.QzD.NewWithTaListCount != this.Qzy.size())) {
      this.QzD.NewWithTaListCount = this.Qzy.size();
    }
    this.QzD.WithUserCount = this.Qzy.size();
    this.QzD.WithUserListCount = this.Qzy.size();
    AppMethodBeat.o(96041);
    return this;
  }
  
  @Deprecated
  public final boolean c(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(96054);
    paramString1 = aZ("", paramString1, paramString2);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(96054);
      return false;
    }
    paramString1.IGG = paramString3;
    if (paramInt > 0) {
      paramString1.subType = paramInt;
    }
    if (!Util.isNullOrNil(paramString4)) {
      paramString1.RcB = paramString4;
    }
    this.QzA.ContentObj.Zpr.add(paramString1);
    AppMethodBeat.o(96054);
    return true;
  }
  
  public final bg df(int paramInt, String paramString)
  {
    this.QzF = paramInt;
    this.QzG = paramString;
    return this;
  }
  
  @Deprecated
  public final boolean h(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(309450);
    paramString1 = aZ("", paramString1, paramString1);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
      AppMethodBeat.o(309450);
      return false;
    }
    paramString1.IGG = paramString2;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      dnb localdnb = new dnb();
      localdnb.aaUc = paramInt2;
      localdnb.aaUb = paramInt1;
      paramString1.aaTn = localdnb;
    }
    if (!Util.isNullOrNil(paramString3)) {
      paramString1.hAP = paramString3;
    }
    if (!Util.isNullOrNil(paramString2)) {
      paramString1.IGG = paramString2;
    }
    this.QzA.ContentObj.Zpr.add(paramString1);
    AppMethodBeat.o(309450);
    return true;
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96059);
    feu localfeu = new feu();
    localfeu.YHn = paramString1;
    localfeu.YHo = paramString2;
    localfeu.YHp = paramString3;
    localfeu.Rgo = paramInt1;
    localfeu.Rgp = paramInt2;
    this.QzB.aaTS = localfeu;
    AppMethodBeat.o(96059);
  }
  
  public final bg kB(List<String> paramList)
  {
    AppMethodBeat.i(96046);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.QzD.ExtFlag = 1;
      AppMethodBeat.o(96046);
      return this;
    }
    paramList = paramList.iterator();
    LinkedList localLinkedList = new LinkedList();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      etl localetl = new etl();
      localetl.btH(str);
      localLinkedList.add(localetl);
    }
    this.QzB.GroupUser = localLinkedList;
    if ((this.QzD.ExtFlag & 0x2) > 0)
    {
      this.QzD.BlackList = localLinkedList;
      this.QzD.BlackListCount = localLinkedList.size();
    }
    for (;;)
    {
      AppMethodBeat.o(96046);
      return this;
      if ((this.QzD.ExtFlag & 0x4) > 0)
      {
        this.QzD.GroupUser = localLinkedList;
        this.QzD.GroupUserCount = localLinkedList.size();
      }
    }
  }
  
  public final void kC(List<s> paramList)
  {
    AppMethodBeat.i(96058);
    this.Qzw = paramList;
    paramList = al.hgq().kF(this.Qzw);
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
      djp localdjp = new djp();
      localdjp.aaPC = locals.icg;
      ((LinkedList)localObject1).add(localdjp);
    }
    this.QzB.aaTI = ((LinkedList)localObject1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (s)paramList.next();
      localObject2 = new dnb();
      ((dnb)localObject2).aaUc = 0.0F;
      ((dnb)localObject2).aaUb = 0.0F;
      ((dnb)localObject2).aaUd = 0.0F;
      if ((((s)localObject1).height > 0) && (((s)localObject1).width > 0) && (((s)localObject1).fileSize > 0))
      {
        ((dnb)localObject2).aaUc = ((s)localObject1).height;
        ((dnb)localObject2).aaUb = ((s)localObject1).width;
        ((dnb)localObject2).aaUd = ((s)localObject1).fileSize;
      }
      localObject1 = o.a("Locall_path" + ((s)localObject1).icg, ((s)localObject1).type, "", "", 0, 0, this.Qoh, "", (dnb)localObject2);
      this.QzA.ContentObj.Zpr.add(localObject1);
    }
    AppMethodBeat.o(96058);
  }
  
  public final void kLL()
  {
    AppMethodBeat.i(369987);
    gom localgom = new gom();
    localgom.aklr = 1;
    localgom.aklp = Tiger2022Helper.kLO();
    if (localgom.aklp) {
      localgom.aklq = Tiger2022Helper.kLM();
    }
    this.QzA.ContentObj.akiL = localgom;
    AppMethodBeat.o(369987);
  }
  
  public final bg mm(String paramString1, String paramString2)
  {
    this.QzB.token = paramString1;
    this.QzB.aaTQ = paramString2;
    return this;
  }
  
  public final boolean mo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96053);
    String str = al.getAccSnsTmpPath() + com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes());
    aYW(str);
    y.O(paramString1, str, false);
    paramString1 = mn("", str);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
      AppMethodBeat.o(96053);
      return false;
    }
    paramString1.IGG = paramString2;
    if (Util.isNullOrNil(paramString1.hAP)) {
      paramString1.hAP = paramString2;
    }
    this.QzA.ContentObj.Zpr.add(paramString1);
    paramString2 = new djp();
    paramString2.aaPC = paramString1.icg;
    this.QzB.aaTI.add(paramString2);
    AppMethodBeat.o(96053);
    return true;
  }
  
  public final void setSessionId(String paramString)
  {
    this.QzB.sessionId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bg
 * JD-Core Version:    0.7.0.1
 */