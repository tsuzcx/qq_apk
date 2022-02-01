package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.aa;
import com.tencent.mm.ba.a.a;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;
import junit.framework.Assert;

public final class bu
  extends aa
{
  public static String IMd = "voip_content_voice";
  public static String IMe = "voip_content_video";
  public jb IMf;
  public boolean IMg;
  public boolean IMh;
  private String IMi;
  public boolean Zn;
  public String sessionId;
  
  public bu()
  {
    this.IMf = null;
    this.IMg = false;
    this.IMh = false;
    this.Zn = false;
  }
  
  public bu(String paramString)
  {
    AppMethodBeat.i(43216);
    this.IMf = null;
    this.IMg = false;
    this.IMh = false;
    this.Zn = false;
    super.tN(paramString);
    AppMethodBeat.o(43216);
  }
  
  public static void DG(long paramLong)
  {
    AppMethodBeat.i(43269);
    if ((100000000L > paramLong) && (-10L < paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("msgId not in the reasonable scope", bool);
      AppMethodBeat.o(43269);
      return;
    }
  }
  
  private static boolean Ng()
  {
    AppMethodBeat.i(43261);
    String str = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("TranslateMsgOff");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(43261);
      return true;
    }
    if (bt.aRe(str) != 0)
    {
      ad.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
      AppMethodBeat.o(43261);
      return false;
    }
    AppMethodBeat.o(43261);
    return true;
  }
  
  public static bu aN(bu parambu)
  {
    AppMethodBeat.i(43247);
    if (parambu == null)
    {
      ad.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
      AppMethodBeat.o(43247);
      return null;
    }
    bu localbu = new bu();
    localbu.setMsgId(parambu.field_msgId);
    localbu.qz(parambu.field_msgSvrId);
    localbu.setType(parambu.getType());
    localbu.setStatus(parambu.field_status);
    localbu.kr(parambu.field_isSend);
    localbu.field_isShowTimer = parambu.field_isShowTimer;
    localbu.eLv = true;
    localbu.qA(parambu.field_createTime);
    localbu.tN(parambu.field_talker);
    localbu.setContent(parambu.field_content);
    localbu.tO(parambu.field_imgPath);
    localbu.tP(parambu.field_reserved);
    localbu.M(parambu.field_lvbuffer);
    localbu.tQ(parambu.field_transContent);
    localbu.tV(parambu.fkq);
    localbu.jY(parambu.eLr);
    localbu.sP(parambu.eLs);
    AppMethodBeat.o(43247);
    return localbu;
  }
  
  public static boolean bR(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43266);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication"))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43266);
      return bool;
    }
  }
  
  public static boolean bS(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43267);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval"))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43267);
      return bool;
    }
  }
  
  private boolean fvl()
  {
    AppMethodBeat.i(43249);
    if ((!isText()) && (!cTe()) && (!frE()))
    {
      AppMethodBeat.o(43249);
      return true;
    }
    AppMethodBeat.o(43249);
    return false;
  }
  
  public final boolean aUa(String paramString)
  {
    AppMethodBeat.i(43264);
    if ((!bt.isNullOrNil(this.eLs)) && (!bt.isNullOrNil(paramString)))
    {
      Object localObject = bw.M(this.eLs, "msgsource");
      if (localObject == null)
      {
        AppMethodBeat.o(43264);
        return false;
      }
      localObject = (String)((Map)localObject).get(".msgsource.atuserlist");
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].trim().equals(paramString))
          {
            AppMethodBeat.o(43264);
            return true;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(43264);
    return false;
  }
  
  public final void aaW(int paramInt)
  {
    AppMethodBeat.i(43260);
    switch (paramInt)
    {
    default: 
      ad.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      AppMethodBeat.o(43260);
      return;
    }
    jY(this.eLr | paramInt);
    AppMethodBeat.o(43260);
  }
  
  public final boolean cTc()
  {
    AppMethodBeat.i(43217);
    if ((super.getType() & 0xFFFF) == 49)
    {
      AppMethodBeat.o(43217);
      return true;
    }
    AppMethodBeat.o(43217);
    return false;
  }
  
  public final boolean cTe()
  {
    AppMethodBeat.i(43231);
    if (super.getType() == 48)
    {
      AppMethodBeat.o(43231);
      return true;
    }
    AppMethodBeat.o(43231);
    return false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(43268);
    super.convertFrom(paramCursor);
    paramCursor = this.field_content;
    if ((paramCursor != null) && (paramCursor.length() > 2097152))
    {
      final long l = this.field_msgId;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("Very big message: \nmsgId = ").append(l).append('\n').append("msgSvrId = ").append(this.field_msgSvrId).append('\n').append("type = ").append(super.getType()).append('\n').append("createTime = ").append(this.field_createTime).append('\n').append("talker = ").append(this.field_talker).append('\n').append("flag = ").append(this.field_flag).append('\n').append("content.length() = ").append(paramCursor.length()).append('\n').append("content = ").append(paramCursor.substring(0, 256));
      ad.e("MicroMsg.MsgInfo", localStringBuilder.toString());
      setType(1);
      setContent("");
      paramCursor = aN(this);
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43201);
          ((l)g.ab(l.class)).dlK().a(l, this.IMj);
          AppMethodBeat.o(43201);
        }
      });
    }
    DG(this.field_msgId);
    AppMethodBeat.o(43268);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43270);
    DG(this.field_msgId);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(43270);
    return localContentValues;
  }
  
  public final boolean cxf()
  {
    AppMethodBeat.i(43234);
    if (super.getType() == 43)
    {
      AppMethodBeat.o(43234);
      return true;
    }
    AppMethodBeat.o(43234);
    return false;
  }
  
  public final boolean cxg()
  {
    AppMethodBeat.i(43219);
    if (super.getType() == 486539313)
    {
      AppMethodBeat.o(43219);
      return true;
    }
    AppMethodBeat.o(43219);
    return false;
  }
  
  public final boolean cxh()
  {
    AppMethodBeat.i(43235);
    if (super.getType() == 62)
    {
      AppMethodBeat.o(43235);
      return true;
    }
    AppMethodBeat.o(43235);
    return false;
  }
  
  public final boolean fpd()
  {
    AppMethodBeat.i(43218);
    if (super.getType() == 285212721)
    {
      AppMethodBeat.o(43218);
      return true;
    }
    AppMethodBeat.o(43218);
    return false;
  }
  
  public final boolean fph()
  {
    AppMethodBeat.i(43221);
    if (super.getType() == 34)
    {
      AppMethodBeat.o(43221);
      return true;
    }
    AppMethodBeat.o(43221);
    return false;
  }
  
  public final boolean fpi()
  {
    AppMethodBeat.i(43229);
    switch (super.getType())
    {
    default: 
      AppMethodBeat.o(43229);
      return false;
    }
    AppMethodBeat.o(43229);
    return true;
  }
  
  public final boolean frA()
  {
    AppMethodBeat.i(43225);
    if ((super.getType() == 50) || (super.getType() == 53))
    {
      AppMethodBeat.o(43225);
      return true;
    }
    AppMethodBeat.o(43225);
    return false;
  }
  
  public final boolean frB()
  {
    AppMethodBeat.i(43226);
    if (super.getType() == 52)
    {
      AppMethodBeat.o(43226);
      return true;
    }
    AppMethodBeat.o(43226);
    return false;
  }
  
  public final boolean frC()
  {
    AppMethodBeat.i(43227);
    if (super.getType() == 318767153)
    {
      AppMethodBeat.o(43227);
      return true;
    }
    AppMethodBeat.o(43227);
    return false;
  }
  
  public final boolean frD()
  {
    AppMethodBeat.i(43228);
    if (super.getType() == 10002)
    {
      AppMethodBeat.o(43228);
      return true;
    }
    AppMethodBeat.o(43228);
    return false;
  }
  
  public final boolean frE()
  {
    AppMethodBeat.i(43230);
    if ((super.getType() == 42) || (super.getType() == 66))
    {
      AppMethodBeat.o(43230);
      return true;
    }
    AppMethodBeat.o(43230);
    return false;
  }
  
  public final boolean frF()
  {
    AppMethodBeat.i(192573);
    if ((super.getType() == 10000) || (super.getType() == 10002) || (super.getType() == 570425393) || (super.getType() == 64) || (super.getType() == 603979825))
    {
      AppMethodBeat.o(192573);
      return true;
    }
    AppMethodBeat.o(192573);
    return false;
  }
  
  public final boolean frG()
  {
    AppMethodBeat.i(43236);
    if (super.getType() == 47)
    {
      AppMethodBeat.o(43236);
      return true;
    }
    AppMethodBeat.o(43236);
    return false;
  }
  
  public final boolean frH()
  {
    AppMethodBeat.i(43237);
    if (super.getType() == 1048625)
    {
      AppMethodBeat.o(43237);
      return true;
    }
    AppMethodBeat.o(43237);
    return false;
  }
  
  public final boolean frI()
  {
    AppMethodBeat.i(192574);
    if (super.getType() == 855638065)
    {
      AppMethodBeat.o(192574);
      return true;
    }
    AppMethodBeat.o(192574);
    return false;
  }
  
  public final boolean frJ()
  {
    AppMethodBeat.i(43238);
    if (super.getType() == 16777265)
    {
      AppMethodBeat.o(43238);
      return true;
    }
    AppMethodBeat.o(43238);
    return false;
  }
  
  public final boolean frK()
  {
    AppMethodBeat.i(43239);
    if (super.getType() == 268435505)
    {
      AppMethodBeat.o(43239);
      return true;
    }
    AppMethodBeat.o(43239);
    return false;
  }
  
  public final boolean frL()
  {
    AppMethodBeat.i(43240);
    if (super.getType() == -1879048191)
    {
      AppMethodBeat.o(43240);
      return true;
    }
    AppMethodBeat.o(43240);
    return false;
  }
  
  public final boolean frM()
  {
    AppMethodBeat.i(43241);
    if (super.getType() == -1879048190)
    {
      AppMethodBeat.o(43241);
      return true;
    }
    AppMethodBeat.o(43241);
    return false;
  }
  
  public final boolean frN()
  {
    AppMethodBeat.i(43242);
    if (super.getType() == -1879048189)
    {
      AppMethodBeat.o(43242);
      return true;
    }
    AppMethodBeat.o(43242);
    return false;
  }
  
  public final boolean frO()
  {
    AppMethodBeat.i(43243);
    switch (super.getType())
    {
    case 56: 
    default: 
      AppMethodBeat.o(43243);
      return false;
    }
    AppMethodBeat.o(43243);
    return true;
  }
  
  public final boolean frP()
  {
    AppMethodBeat.i(192575);
    if ((super.getType() == 889192497) || (super.getType() == 922746929))
    {
      AppMethodBeat.o(192575);
      return true;
    }
    AppMethodBeat.o(192575);
    return false;
  }
  
  public final boolean frQ()
  {
    AppMethodBeat.i(43244);
    if (super.getType() == 805306417)
    {
      AppMethodBeat.o(43244);
      return true;
    }
    AppMethodBeat.o(43244);
    return false;
  }
  
  public final boolean frR()
  {
    AppMethodBeat.i(43245);
    if (super.getType() == 822083633)
    {
      AppMethodBeat.o(43245);
      return true;
    }
    AppMethodBeat.o(43245);
    return false;
  }
  
  public final boolean frS()
  {
    AppMethodBeat.i(43246);
    if ((Ng()) && (!bt.isNullOrNil(this.field_transContent)))
    {
      AppMethodBeat.o(43246);
      return true;
    }
    AppMethodBeat.o(43246);
    return false;
  }
  
  public final boolean frT()
  {
    return (this.fkt & 0x1) > 0;
  }
  
  public final void frU()
  {
    AppMethodBeat.i(43250);
    kD(this.fkt | 0x1);
    AppMethodBeat.o(43250);
  }
  
  public final boolean frV()
  {
    return (this.eLr & 0x200) > 0;
  }
  
  public final void frW()
  {
    AppMethodBeat.i(43251);
    jY(this.eLr | 0x200);
    AppMethodBeat.o(43251);
  }
  
  public final void frX()
  {
    AppMethodBeat.i(178875);
    jY(this.eLr | 0x800);
    AppMethodBeat.o(178875);
  }
  
  public final void frY()
  {
    AppMethodBeat.i(43252);
    if (frZ()) {
      jY(this.eLr & 0xFFFFFFDF);
    }
    AppMethodBeat.o(43252);
  }
  
  public final boolean frZ()
  {
    return (this.eLr & 0x20) > 0;
  }
  
  public final boolean frw()
  {
    AppMethodBeat.i(43220);
    if ((super.getType() == 486539313) && (this.IMg) && (this.IMf != null))
    {
      AppMethodBeat.o(43220);
      return true;
    }
    AppMethodBeat.o(43220);
    return false;
  }
  
  public final boolean frx()
  {
    AppMethodBeat.i(43222);
    if (super.getType() == 436207665)
    {
      AppMethodBeat.o(43222);
      return true;
    }
    AppMethodBeat.o(43222);
    return false;
  }
  
  public final boolean fry()
  {
    AppMethodBeat.i(43223);
    if (super.getType() == 469762097)
    {
      AppMethodBeat.o(43223);
      return true;
    }
    AppMethodBeat.o(43223);
    return false;
  }
  
  public final boolean frz()
  {
    AppMethodBeat.i(43224);
    if (super.getType() == 301989937)
    {
      AppMethodBeat.o(43224);
      return true;
    }
    AppMethodBeat.o(43224);
    return false;
  }
  
  public final void fsa()
  {
    AppMethodBeat.i(43253);
    jY(this.eLr | 0x8);
    AppMethodBeat.o(43253);
  }
  
  public final boolean fsb()
  {
    AppMethodBeat.i(43254);
    if ((frS()) && ((this.eLr & 0x10) > 0))
    {
      AppMethodBeat.o(43254);
      return true;
    }
    AppMethodBeat.o(43254);
    return false;
  }
  
  public final void fsc()
  {
    AppMethodBeat.i(43255);
    if (!frS())
    {
      AppMethodBeat.o(43255);
      return;
    }
    jY(this.eLr | 0x10);
    AppMethodBeat.o(43255);
  }
  
  public final void fsd()
  {
    AppMethodBeat.i(43256);
    if (!frS())
    {
      AppMethodBeat.o(43256);
      return;
    }
    jY(this.eLr & 0xFFFFFFEF);
    AppMethodBeat.o(43256);
  }
  
  public final boolean fse()
  {
    AppMethodBeat.i(43257);
    if ((frS()) && ((this.eLr & 0x400) > 0))
    {
      AppMethodBeat.o(43257);
      return true;
    }
    AppMethodBeat.o(43257);
    return false;
  }
  
  public final void fsf()
  {
    AppMethodBeat.i(43258);
    jY(this.eLr | 0x80);
    AppMethodBeat.o(43258);
  }
  
  public final void fsg()
  {
    AppMethodBeat.i(43259);
    jY(this.eLr & 0xFFFFFF7F);
    AppMethodBeat.o(43259);
  }
  
  public final boolean fsh()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ((this.eLr & 0x80) == 0)
    {
      bool1 = bool2;
      if ((this.eLr & 0x300) == 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final boolean fsi()
  {
    return (this.eLr & 0x2000) > 0;
  }
  
  public final void fsj()
  {
    AppMethodBeat.i(192576);
    jY(this.eLr | 0x2000);
    AppMethodBeat.o(192576);
  }
  
  public final void fsk()
  {
    AppMethodBeat.i(192577);
    jY(this.eLr & 0xFFFFDFFF);
    AppMethodBeat.o(192577);
  }
  
  public final boolean fsl()
  {
    return (this.eLr & 0x1000) > 0;
  }
  
  public final void fsm()
  {
    AppMethodBeat.i(43262);
    jY(this.eLr & 0xFFFFFFBF);
    AppMethodBeat.o(43262);
  }
  
  public final void fsn()
  {
    AppMethodBeat.i(43263);
    jY(this.eLr | 0x40);
    AppMethodBeat.o(43263);
  }
  
  public final boolean fso()
  {
    AppMethodBeat.i(43265);
    if ((!bt.isNullOrNil(this.eLs)) && ((this.eLs.contains("announcement@all")) || (this.eLs.contains("notify@all")))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43265);
      return bool;
    }
  }
  
  public final String fsp()
  {
    AppMethodBeat.i(43271);
    if (!frD())
    {
      AppMethodBeat.o(43271);
      return "";
    }
    if (this.IMi == null) {
      fsq();
    }
    String str = this.IMi;
    AppMethodBeat.o(43271);
    return str;
  }
  
  public final com.tencent.mm.ba.a fsq()
  {
    AppMethodBeat.i(43272);
    ad.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    com.tencent.mm.ba.a locala = a.a.b(bw.M(this.field_content, "sysmsg"), this);
    if (locala != null)
    {
      ad.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { locala });
      locala.aJR();
      this.IMi = locala.TEXT;
    }
    for (;;)
    {
      AppMethodBeat.o(43272);
      return locala;
      ad.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(221204);
    int i = super.getType();
    AppMethodBeat.o(221204);
    return i;
  }
  
  @Deprecated
  public final boolean isSystem()
  {
    AppMethodBeat.i(43233);
    if (super.getType() == 10000)
    {
      AppMethodBeat.o(43233);
      return true;
    }
    AppMethodBeat.o(43233);
    return false;
  }
  
  public final boolean isText()
  {
    AppMethodBeat.i(43232);
    switch (super.getType())
    {
    default: 
      AppMethodBeat.o(43232);
      return false;
    }
    AppMethodBeat.o(43232);
    return true;
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(43248);
    super.setStatus(paramInt);
    Object localObject;
    if ((this.field_isSend == 1) && (fvl()))
    {
      if (this.field_status == 5)
      {
        ad.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()), this.field_talker, bt.flS() });
        localObject = new sy();
        ((sy)localObject).dHA.dku = this;
        com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
        AppMethodBeat.o(43248);
        return;
      }
      if (this.field_status == 2)
      {
        ad.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()) });
        localObject = new ta();
        ((ta)localObject).dHC.dku = this;
        com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
        AppMethodBeat.o(43248);
      }
    }
    else if (this.field_isSend == 0)
    {
      localObject = new px();
      ((px)localObject).dEq.dku = this;
      com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
    }
    AppMethodBeat.o(43248);
  }
  
  public static final class a
  {
    public int DKi = 0;
    public String FfL = "";
    public int IMl = 0;
    public String IMm = "";
    public String IMn = "";
    public String IMo = "";
    public String IMp = "";
    public String IMq = "";
    public String IMr = "";
    public String IMs = "";
    public String IMt = "";
    public String dHm = "";
    private String ePA = "";
    public int ePk;
    private String ePu;
    private String ePv;
    public String ePz = "";
    public String ffB = "";
    public String jbt = "";
    public String jeU = "";
    public String jeV = "";
    public String jeW = "";
    public String jeZ = "";
    public String nickname = "";
    public int scene = 0;
    public String signature;
    private String source = "";
    public String wQe = "";
    public long wSt = 0L;
    
    public static a aUb(String paramString)
    {
      AppMethodBeat.i(43202);
      locala = new a();
      localObject = bt.bI(paramString, "").trim();
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("<"))
      {
        int i = ((String)localObject).indexOf(":");
        paramString = (String)localObject;
        if (i != -1) {
          paramString = ((String)localObject).substring(i + 1);
        }
      }
      localObject = bw.M(paramString, "msg");
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          if (((Map)localObject).get(".msg.$fromusername") != null) {
            continue;
          }
          locala.dHm = ((String)((Map)localObject).get(".msg.$username"));
          if (((Map)localObject).get(".msg.$fromnickname") != null) {
            continue;
          }
          locala.nickname = ((String)((Map)localObject).get(".msg.$nickname"));
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bt.n(paramString) });
          continue;
          locala.nickname = ((String)((Map)localObject).get(".msg.$fromnickname"));
          continue;
          paramString = (String)((Map)localObject).get(".msg.$certflag");
          continue;
        }
        locala.ffB = ((String)((Map)localObject).get(".msg.$alias"));
        locala.jeV = ((String)((Map)localObject).get(".msg.$fullpy"));
        locala.jeU = ((String)((Map)localObject).get(".msg.$shortpy"));
        locala.source = ((String)((Map)localObject).get(".msg.$source"));
        locala.IMl = bt.getInt((String)((Map)localObject).get(".msg.$imagestatus"), 0);
        locala.scene = bt.getInt((String)((Map)localObject).get(".msg.$scene"), 0);
        locala.IMm = ((String)((Map)localObject).get(".msg.$mobileidentify"));
        locala.IMn = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
        if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
          locala.wSt = bt.getLong((String)((Map)localObject).get(".msg.$qqnum"), 0L);
        }
        locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
        if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
          locala.ePk = bt.getInt((String)((Map)localObject).get(".msg.$sex"), 0);
        }
        locala.ePv = ((String)((Map)localObject).get(".msg.$city"));
        locala.ePu = ((String)((Map)localObject).get(".msg.$province"));
        locala.jeW = ((String)((Map)localObject).get(".msg.$qqnickname"));
        locala.jeZ = ((String)((Map)localObject).get(".msg.$qqremark"));
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
          continue;
        }
        paramString = "0";
        locala.DKi = bt.getInt(paramString, 0);
        locala.ePz = bt.nullAsNil((String)((Map)localObject).get(".msg.$certinfo"));
        locala.wQe = bt.nullAsNil((String)((Map)localObject).get(".msg.$brandIconUrl"));
        locala.ePA = bt.nullAsNil((String)((Map)localObject).get(".msg.$regionCode"));
        locala.IMo = bt.nullAsNil((String)((Map)localObject).get(".msg.$bigheadimgurl"));
        locala.IMp = bt.nullAsNil((String)((Map)localObject).get(".msg.$smallheadimgurl"));
        locala.jbt = bt.nullAsNil((String)((Map)localObject).get(".msg.$googlecontact"));
        locala.FfL = bt.nullAsNil((String)((Map)localObject).get(".msg.$antispamticket"));
        locala.IMq = bt.nullAsNil((String)((Map)localObject).get(".msg.$openimappid"));
        locala.IMr = bt.nullAsNil((String)((Map)localObject).get(".msg.$openimdesc"));
        locala.IMs = bt.nullAsNil((String)((Map)localObject).get(".msg.$openimdescicon"));
        locala.IMt = bt.nullAsNil((String)((Map)localObject).get(".msg.$openimcustominfo"));
        if (am.aSQ(locala.dHm)) {
          locala.FfL = bt.nullAsNil((String)((Map)localObject).get(".msg.$ticket"));
        }
        ad.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.dHm, locala.FfL, locala.IMo, locala.IMp });
        AppMethodBeat.o(43202);
        return locala;
        locala.dHm = ((String)((Map)localObject).get(".msg.$fromusername"));
      }
    }
    
    public final String fsr()
    {
      return this.dHm;
    }
    
    public final String fss()
    {
      AppMethodBeat.i(43204);
      if ((this.jeZ != null) && (this.jeZ.length() > 0))
      {
        str = this.jeZ;
        AppMethodBeat.o(43204);
        return str;
      }
      if ((this.jeW != null) && (this.jeW.length() > 0))
      {
        str = this.jeW;
        AppMethodBeat.o(43204);
        return str;
      }
      String str = Long.toString(this.wSt);
      AppMethodBeat.o(43204);
      return str;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43205);
      Object localObject;
      if (!bt.isNullOrNil(this.ePA))
      {
        localObject = this.ePA.split("_");
        if (localObject.length > 0)
        {
          if (localObject.length <= 2) {
            break label71;
          }
          RegionCodeDecoder.fsz();
          this.ePv = RegionCodeDecoder.bh(localObject[0], localObject[1], localObject[2]);
        }
      }
      for (;;)
      {
        localObject = this.ePv;
        AppMethodBeat.o(43205);
        return localObject;
        label71:
        if (localObject.length == 2)
        {
          RegionCodeDecoder.fsz();
          this.ePv = RegionCodeDecoder.mb(localObject[0], localObject[1]);
        }
        else
        {
          this.ePv = "";
        }
      }
    }
    
    public final String getDisplayName()
    {
      AppMethodBeat.i(43203);
      if (!TextUtils.isEmpty(this.nickname))
      {
        str = this.nickname;
        AppMethodBeat.o(43203);
        return str;
      }
      if (!TextUtils.isEmpty(this.ffB))
      {
        str = this.ffB;
        AppMethodBeat.o(43203);
        return str;
      }
      ad.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = bt.nullAsNil(this.dHm);
      AppMethodBeat.o(43203);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43206);
      Object localObject;
      if (!bt.isNullOrNil(this.ePA))
      {
        localObject = this.ePA.split("_");
        if (localObject.length > 0)
        {
          if ((localObject.length <= 2) || (!RegionCodeDecoder.aUp(localObject[0]))) {
            break label77;
          }
          RegionCodeDecoder.fsz();
        }
      }
      for (this.ePu = RegionCodeDecoder.mb(localObject[0], localObject[1]);; this.ePu = RegionCodeDecoder.aUq(localObject[0]))
      {
        localObject = this.ePu;
        AppMethodBeat.o(43206);
        return localObject;
        label77:
        RegionCodeDecoder.fsz();
      }
    }
  }
  
  public static final class b
  {
    public String EJU = "";
    public String IMu = "";
    public String IMv = null;
    public String IMw = null;
    public String IMx = null;
    public String dHm = "";
    public int dyB = 0;
    public String jDf = "";
    public String label = "";
    public double uZr = 0.0D;
    public double uZs = 0.0D;
    public String uZy = "";
    
    public static b aUc(String paramString)
    {
      AppMethodBeat.i(43208);
      b localb = new b();
      paramString = bw.M(paramString, "msg");
      if (paramString != null)
      {
        localb.dHm = bt.bI((String)paramString.get(".msg.location.$fromusername"), "");
        localb.uZr = bt.aRg((String)paramString.get(".msg.location.$x"));
        localb.uZs = bt.aRg((String)paramString.get(".msg.location.$y"));
        localb.label = bt.bI((String)paramString.get(".msg.location.$label"), "");
        localb.IMu = bt.bI((String)paramString.get(".msg.location.$maptype"), "");
        localb.dyB = bt.aRe((String)paramString.get(".msg.location.$scale"));
        localb.IMx = bt.bI((String)paramString.get(".msg.location.$localLocationen"), "");
        localb.IMv = bt.bI((String)paramString.get(".msg.location.$localLocationcn"), "");
        localb.IMw = bt.bI((String)paramString.get(".msg.location.$localLocationtw"), "");
        localb.jDf = bt.bI((String)paramString.get(".msg.location.$poiname"), "");
        localb.EJU = bt.bI((String)paramString.get(".msg.location.$infourl"), "");
        localb.uZy = bt.bI((String)paramString.get(".msg.location.$poiid"), "");
      }
      AppMethodBeat.o(43208);
      return localb;
    }
    
    public final boolean fst()
    {
      AppMethodBeat.i(43209);
      if ((this.jDf != null) && (!this.jDf.equals("")) && (!this.jDf.equals("[位置]")))
      {
        AppMethodBeat.o(43209);
        return true;
      }
      AppMethodBeat.o(43209);
      return false;
    }
    
    public final boolean fsu()
    {
      AppMethodBeat.i(43210);
      if ((Math.abs(this.uZs) > 180.0D) || (Math.abs(this.uZr) > 90.0D))
      {
        AppMethodBeat.o(43210);
        return false;
      }
      AppMethodBeat.o(43210);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(43207);
      String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.uZr * 1000000.0D)), Integer.valueOf((int)(this.uZs * 1000000.0D)), Integer.valueOf(this.dyB) });
      AppMethodBeat.o(43207);
      return str;
    }
  }
  
  public static final class c
  {
    public String IMy = "";
    public String content = "";
    public String ild = "";
    public boolean rEq = false;
    public String title = "";
    public String xbf;
    
    public static c aUd(String paramString)
    {
      AppMethodBeat.i(43211);
      c localc = new c();
      paramString = bw.M(paramString, "msg");
      if (paramString != null) {}
      try
      {
        localc.title = ((String)paramString.get(".msg.pushmail.content.subject"));
        localc.content = ((String)paramString.get(".msg.pushmail.content.digest"));
        localc.ild = ((String)paramString.get(".msg.pushmail.content.sender"));
        localc.IMy = ((String)paramString.get(".msg.pushmail.waplink"));
        localc.rEq = bt.nullAsNil((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
        localc.xbf = ((String)paramString.get(".msg.pushmail.mailid"));
        AppMethodBeat.o(43211);
        return localc;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bt.n(paramString) });
        }
      }
    }
    
    public final String getSender()
    {
      return this.ild;
    }
    
    public final String getTitle()
    {
      return this.title;
    }
  }
  
  public static final class d
  {
    public String EUR;
    public String IMA;
    public String IMB;
    public int IMC;
    public String IMD;
    public String IME;
    public String IMF;
    public String IMG;
    public int IMl = 0;
    public String IMm = "";
    public String IMn = "";
    public String IMo = "";
    public String IMp = "";
    public int IMz = 0;
    public String chatroomName = "";
    private String cityCode;
    public String content = "";
    private String countryCode;
    public String dHm = "";
    public int dsi;
    public int ePk;
    public String ffB = "";
    public String jYs;
    public String jbt;
    public String jeU = "";
    public String jeV = "";
    public String jeW = "";
    private String jeZ = "";
    public String nickname = "";
    private String provinceCode;
    public int scene = 0;
    public String signature;
    public String txJ;
    public long wSt = 0L;
    
    public static d aUe(String paramString)
    {
      AppMethodBeat.i(43212);
      d locald = new d();
      paramString = bw.M(paramString, "msg");
      if (paramString != null) {}
      try
      {
        locald.dHm = ((String)paramString.get(".msg.$fromusername"));
        locald.ffB = ((String)paramString.get(".msg.$alias"));
        locald.nickname = ((String)paramString.get(".msg.$fromnickname"));
        locald.jeV = ((String)paramString.get(".msg.$fullpy"));
        locald.jeU = ((String)paramString.get(".msg.$shortpy"));
        locald.content = ((String)paramString.get(".msg.$content"));
        locald.IMl = bt.getInt((String)paramString.get(".msg.$imagestatus"), 0);
        locald.scene = bt.getInt((String)paramString.get(".msg.$scene"), 0);
        locald.IMm = ((String)paramString.get(".msg.$mhash"));
        locald.IMn = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          locald.wSt = bt.getLong((String)paramString.get(".msg.$qqnum"), 0L);
        }
        locald.jeW = ((String)paramString.get(".msg.$qqnickname"));
        locald.jeZ = ((String)paramString.get(".msg.$qqremark"));
        locald.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          locald.ePk = bt.getInt((String)paramString.get(".msg.$sex"), 0);
        }
        locald.cityCode = ((String)paramString.get(".msg.$city"));
        locald.provinceCode = ((String)paramString.get(".msg.$province"));
        locald.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          locald.IMz = bt.getInt((String)paramString.get(".msg.$snsflag"), 0);
          locald.IMA = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        locald.txJ = ((String)paramString.get(".msg.$ticket"));
        ad.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { locald.txJ });
        locald.IMo = bt.nullAsNil((String)paramString.get(".msg.$bigheadimgurl"));
        locald.IMp = bt.nullAsNil((String)paramString.get(".msg.$smallheadimgurl"));
        locald.dsi = bt.getInt((String)paramString.get(".msg.$opcode"), 0);
        locald.IMB = bt.nullAsNil((String)paramString.get(".msg.$encryptusername"));
        locald.jbt = bt.nullAsNil((String)paramString.get(".msg.$googlecontact"));
        ad.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { locald.dHm, locald.IMo, locald.IMp });
        locald.chatroomName = bt.nullAsNil((String)paramString.get(".msg.$chatroomusername"));
        locald.jYs = ((String)paramString.get(".msg.$sourceusername"));
        locald.EUR = ((String)paramString.get(".msg.$sourcenickname"));
        locald.IMF = ((String)paramString.get(".msg.$sharecardusername"));
        locald.IMG = ((String)paramString.get(".msg.$sharecardnickname"));
        locald.IMC = bt.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (locald.IMC == 1)
        {
          locald.IMD = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          locald.IME = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.MsgInfo", paramString, "", new Object[0]);
        }
      }
      AppMethodBeat.o(43212);
      return locald;
    }
    
    public final String Hu()
    {
      return this.signature;
    }
    
    public final String VA()
    {
      return this.ffB;
    }
    
    public final String VC()
    {
      return this.nickname;
    }
    
    public final String VD()
    {
      return this.jeU;
    }
    
    public final String VE()
    {
      return this.jeV;
    }
    
    public final int VI()
    {
      return this.ePk;
    }
    
    public final String fsr()
    {
      return this.dHm;
    }
    
    public final String fsv()
    {
      return this.txJ;
    }
    
    public final String fsw()
    {
      return this.IMB;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43214);
      if ((!bt.isNullOrNil(this.countryCode)) && (!bt.isNullOrNil(this.provinceCode)))
      {
        if (bt.isNullOrNil(this.cityCode))
        {
          RegionCodeDecoder.fsz();
          str = RegionCodeDecoder.mb(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43214);
          return str;
        }
        RegionCodeDecoder.fsz();
        str = RegionCodeDecoder.bh(this.countryCode, this.provinceCode, this.cityCode);
        AppMethodBeat.o(43214);
        return str;
      }
      String str = this.cityCode;
      AppMethodBeat.o(43214);
      return str;
    }
    
    public final String getDisplayName()
    {
      AppMethodBeat.i(43213);
      if ((this.nickname != null) && (this.nickname.length() > 0))
      {
        str = this.nickname;
        AppMethodBeat.o(43213);
        return str;
      }
      ad.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = this.dHm;
      AppMethodBeat.o(43213);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43215);
      if (!bt.isNullOrNil(this.countryCode))
      {
        if ((!bt.isNullOrNil(this.provinceCode)) && (!bt.isNullOrNil(this.cityCode)) && (RegionCodeDecoder.aUp(this.countryCode)))
        {
          RegionCodeDecoder.fsz();
          str = RegionCodeDecoder.mb(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43215);
          return str;
        }
        RegionCodeDecoder.fsz();
        str = RegionCodeDecoder.aUq(this.countryCode);
        AppMethodBeat.o(43215);
        return str;
      }
      String str = this.provinceCode;
      AppMethodBeat.o(43215);
      return str;
    }
    
    public final int getScene()
    {
      return this.scene;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bu
 * JD-Core Version:    0.7.0.1
 */