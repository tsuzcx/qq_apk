package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.aa;
import com.tencent.mm.ba.a.a;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;
import junit.framework.Assert;

public final class bl
  extends aa
{
  public static String FzM = "voip_content_voice";
  public static String FzN = "voip_content_video";
  public io FzO;
  public boolean FzP;
  public boolean FzQ;
  private String FzR;
  public String sessionId;
  
  public bl()
  {
    this.FzO = null;
    this.FzP = false;
    this.FzQ = false;
  }
  
  public bl(String paramString)
  {
    AppMethodBeat.i(43216);
    this.FzO = null;
    this.FzP = false;
    this.FzQ = false;
    super.nY(paramString);
    AppMethodBeat.o(43216);
  }
  
  private static boolean LA()
  {
    AppMethodBeat.i(43261);
    String str = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("TranslateMsgOff");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(43261);
      return true;
    }
    if (bt.aGh(str) != 0)
    {
      ad.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
      AppMethodBeat.o(43261);
      return false;
    }
    AppMethodBeat.o(43261);
    return true;
  }
  
  public static bl aI(bl parambl)
  {
    AppMethodBeat.i(43247);
    if (parambl == null)
    {
      ad.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
      AppMethodBeat.o(43247);
      return null;
    }
    bl localbl = new bl();
    localbl.setMsgId(parambl.field_msgId);
    localbl.kX(parambl.field_msgSvrId);
    localbl.setType(parambl.getType());
    localbl.setStatus(parambl.field_status);
    localbl.jV(parambl.field_isSend);
    localbl.field_isShowTimer = parambl.field_isShowTimer;
    localbl.eOH = true;
    localbl.kY(parambl.field_createTime);
    localbl.nY(parambl.field_talker);
    localbl.setContent(parambl.field_content);
    localbl.nZ(parambl.field_imgPath);
    localbl.oa(parambl.field_reserved);
    localbl.P(parambl.field_lvbuffer);
    localbl.ob(parambl.field_transContent);
    localbl.od(parambl.eOT);
    localbl.jC(parambl.esg);
    localbl.mZ(parambl.esh);
    AppMethodBeat.o(43247);
    return localbl;
  }
  
  public static boolean bI(Map<String, String> paramMap)
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
  
  public static boolean bJ(Map<String, String> paramMap)
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
  
  private boolean eMk()
  {
    AppMethodBeat.i(43249);
    if ((!isText()) && (!cxD()) && (!eLX()))
    {
      AppMethodBeat.o(43249);
      return true;
    }
    AppMethodBeat.o(43249);
    return false;
  }
  
  public static void wn(long paramLong)
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
  
  public final void WD(int paramInt)
  {
    AppMethodBeat.i(43260);
    switch (paramInt)
    {
    default: 
      ad.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      AppMethodBeat.o(43260);
      return;
    }
    jC(this.esg | paramInt);
    AppMethodBeat.o(43260);
  }
  
  public final boolean aIN(String paramString)
  {
    AppMethodBeat.i(43264);
    if ((!bt.isNullOrNil(this.esh)) && (!bt.isNullOrNil(paramString)))
    {
      Object localObject = bw.K(this.esh, "msgsource");
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
  
  public final boolean cjM()
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
  
  public final boolean cjN()
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
  
  public final boolean cjO()
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
      paramCursor = aI(this);
      g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43201);
          ((k)g.ab(k.class)).cOI().a(l, this.FzS);
          AppMethodBeat.o(43201);
        }
      });
    }
    wn(this.field_msgId);
    AppMethodBeat.o(43268);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43270);
    wn(this.field_msgId);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(43270);
    return localContentValues;
  }
  
  public final boolean cxB()
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
  
  public final boolean cxD()
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
  
  public final boolean eJL()
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
  
  public final boolean eJN()
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
  
  public final boolean eJO()
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
  
  public final boolean eLP()
  {
    AppMethodBeat.i(43220);
    if ((super.getType() == 486539313) && (this.FzP) && (this.FzO != null))
    {
      AppMethodBeat.o(43220);
      return true;
    }
    AppMethodBeat.o(43220);
    return false;
  }
  
  public final boolean eLQ()
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
  
  public final boolean eLR()
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
  
  public final boolean eLS()
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
  
  public final boolean eLT()
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
  
  public final boolean eLU()
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
  
  public final boolean eLV()
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
  
  public final boolean eLW()
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
  
  public final boolean eLX()
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
  
  public final boolean eLY()
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
  
  public final boolean eLZ()
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
  
  public final void eMA()
  {
    AppMethodBeat.i(43262);
    jC(this.esg & 0xFFFFFFBF);
    AppMethodBeat.o(43262);
  }
  
  public final void eMB()
  {
    AppMethodBeat.i(43263);
    jC(this.esg | 0x40);
    AppMethodBeat.o(43263);
  }
  
  public final boolean eMC()
  {
    AppMethodBeat.i(43265);
    if ((!bt.isNullOrNil(this.esh)) && ((this.esh.contains("announcement@all")) || (this.esh.contains("notify@all")))) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43265);
      return bool;
    }
  }
  
  public final String eMD()
  {
    AppMethodBeat.i(43271);
    if (!eLW())
    {
      AppMethodBeat.o(43271);
      return "";
    }
    if (this.FzR == null) {
      eME();
    }
    String str = this.FzR;
    AppMethodBeat.o(43271);
    return str;
  }
  
  public final com.tencent.mm.ba.a eME()
  {
    AppMethodBeat.i(43272);
    ad.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    com.tencent.mm.ba.a locala = a.a.b(bw.K(this.field_content, "sysmsg"), this);
    if (locala != null)
    {
      ad.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { locala });
      locala.azQ();
      this.FzR = locala.TEXT;
    }
    for (;;)
    {
      AppMethodBeat.o(43272);
      return locala;
      ad.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    }
  }
  
  public final boolean eMa()
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
  
  public final boolean eMb()
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
  
  public final boolean eMc()
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
  
  public final boolean eMd()
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
  
  public final boolean eMe()
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
  
  public final boolean eMf()
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
  
  public final boolean eMg()
  {
    AppMethodBeat.i(186493);
    if (super.getType() == 889192497)
    {
      AppMethodBeat.o(186493);
      return true;
    }
    AppMethodBeat.o(186493);
    return false;
  }
  
  public final boolean eMh()
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
  
  public final boolean eMi()
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
  
  public final boolean eMj()
  {
    AppMethodBeat.i(43246);
    if ((LA()) && (!bt.isNullOrNil(this.field_transContent)))
    {
      AppMethodBeat.o(43246);
      return true;
    }
    AppMethodBeat.o(43246);
    return false;
  }
  
  public final boolean eMl()
  {
    return (this.eOW & 0x1) > 0;
  }
  
  public final void eMm()
  {
    AppMethodBeat.i(43250);
    kj(this.eOW | 0x1);
    AppMethodBeat.o(43250);
  }
  
  public final boolean eMn()
  {
    return (this.esg & 0x200) > 0;
  }
  
  public final void eMo()
  {
    AppMethodBeat.i(43251);
    jC(this.esg | 0x200);
    AppMethodBeat.o(43251);
  }
  
  public final void eMp()
  {
    AppMethodBeat.i(178875);
    jC(this.esg | 0x800);
    AppMethodBeat.o(178875);
  }
  
  public final void eMq()
  {
    AppMethodBeat.i(43252);
    if (eMr()) {
      jC(this.esg & 0xFFFFFFDF);
    }
    AppMethodBeat.o(43252);
  }
  
  public final boolean eMr()
  {
    return (this.esg & 0x20) > 0;
  }
  
  public final void eMs()
  {
    AppMethodBeat.i(43253);
    jC(this.esg | 0x8);
    AppMethodBeat.o(43253);
  }
  
  public final boolean eMt()
  {
    AppMethodBeat.i(43254);
    if ((eMj()) && ((this.esg & 0x10) > 0))
    {
      AppMethodBeat.o(43254);
      return true;
    }
    AppMethodBeat.o(43254);
    return false;
  }
  
  public final void eMu()
  {
    AppMethodBeat.i(43255);
    if (!eMj())
    {
      AppMethodBeat.o(43255);
      return;
    }
    jC(this.esg | 0x10);
    AppMethodBeat.o(43255);
  }
  
  public final void eMv()
  {
    AppMethodBeat.i(43256);
    if (!eMj())
    {
      AppMethodBeat.o(43256);
      return;
    }
    jC(this.esg & 0xFFFFFFEF);
    AppMethodBeat.o(43256);
  }
  
  public final boolean eMw()
  {
    AppMethodBeat.i(43257);
    if ((eMj()) && ((this.esg & 0x400) > 0))
    {
      AppMethodBeat.o(43257);
      return true;
    }
    AppMethodBeat.o(43257);
    return false;
  }
  
  public final void eMx()
  {
    AppMethodBeat.i(43258);
    jC(this.esg | 0x80);
    AppMethodBeat.o(43258);
  }
  
  public final void eMy()
  {
    AppMethodBeat.i(43259);
    jC(this.esg & 0xFFFFFF7F);
    AppMethodBeat.o(43259);
  }
  
  public final boolean eMz()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ((this.esg & 0x80) == 0)
    {
      bool1 = bool2;
      if ((this.esg & 0x300) == 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(197135);
    int i = super.getType();
    AppMethodBeat.o(197135);
    return i;
  }
  
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
    if ((this.field_isSend == 1) && (eMk()))
    {
      if (this.field_status == 5)
      {
        ad.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()), this.field_talker, bt.eGN() });
        localObject = new sc();
        ((sc)localObject).dxL.dbD = this;
        com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
        AppMethodBeat.o(43248);
        return;
      }
      if (this.field_status == 2)
      {
        ad.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()) });
        localObject = new se();
        ((se)localObject).dxN.dbD = this;
        com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
        AppMethodBeat.o(43248);
      }
    }
    else if (this.field_isSend == 0)
    {
      localObject = new pe();
      ((pe)localObject).duL.dbD = this;
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
    }
    AppMethodBeat.o(43248);
  }
  
  public static final class a
  {
    public int AOL = 0;
    public String Cin = "";
    public String FAa = "";
    public String FAb = "";
    public String FAc = "";
    public int FzU = 0;
    public String FzV = "";
    public String FzW = "";
    public String FzX = "";
    public String FzY = "";
    public String FzZ = "";
    public String eKn = "";
    private String evA;
    public String evE = "";
    private String evF = "";
    public int evp;
    private String evz;
    public String iic = "";
    public String ilE = "";
    public String ilF = "";
    public String ilG = "";
    public String ilJ = "";
    public String nickname = "";
    public int scene = 0;
    public String signature;
    private String source = "";
    public String uAe = "";
    public long uCr = 0L;
    public String yGA = "";
    
    public static a aIO(String paramString)
    {
      AppMethodBeat.i(43202);
      locala = new a();
      localObject = bt.by(paramString, "").trim();
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("<"))
      {
        int i = ((String)localObject).indexOf(":");
        paramString = (String)localObject;
        if (i != -1) {
          paramString = ((String)localObject).substring(i + 1);
        }
      }
      localObject = bw.K(paramString, "msg");
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          if (((Map)localObject).get(".msg.$fromusername") != null) {
            continue;
          }
          locala.yGA = ((String)((Map)localObject).get(".msg.$username"));
          if (((Map)localObject).get(".msg.$fromnickname") != null) {
            continue;
          }
          locala.nickname = ((String)((Map)localObject).get(".msg.$nickname"));
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bt.m(paramString) });
          continue;
          locala.nickname = ((String)((Map)localObject).get(".msg.$fromnickname"));
          continue;
          paramString = (String)((Map)localObject).get(".msg.$certflag");
          continue;
        }
        locala.eKn = ((String)((Map)localObject).get(".msg.$alias"));
        locala.ilF = ((String)((Map)localObject).get(".msg.$fullpy"));
        locala.ilE = ((String)((Map)localObject).get(".msg.$shortpy"));
        locala.source = ((String)((Map)localObject).get(".msg.$source"));
        locala.FzU = bt.getInt((String)((Map)localObject).get(".msg.$imagestatus"), 0);
        locala.scene = bt.getInt((String)((Map)localObject).get(".msg.$scene"), 0);
        locala.FzV = ((String)((Map)localObject).get(".msg.$mobileidentify"));
        locala.FzW = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
        if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
          locala.uCr = bt.getLong((String)((Map)localObject).get(".msg.$qqnum"), 0L);
        }
        locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
        if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
          locala.evp = bt.getInt((String)((Map)localObject).get(".msg.$sex"), 0);
        }
        locala.evA = ((String)((Map)localObject).get(".msg.$city"));
        locala.evz = ((String)((Map)localObject).get(".msg.$province"));
        locala.ilG = ((String)((Map)localObject).get(".msg.$qqnickname"));
        locala.ilJ = ((String)((Map)localObject).get(".msg.$qqremark"));
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
          continue;
        }
        paramString = "0";
        locala.AOL = bt.getInt(paramString, 0);
        locala.evE = bt.nullAsNil((String)((Map)localObject).get(".msg.$certinfo"));
        locala.uAe = bt.nullAsNil((String)((Map)localObject).get(".msg.$brandIconUrl"));
        locala.evF = bt.nullAsNil((String)((Map)localObject).get(".msg.$regionCode"));
        locala.FzX = bt.nullAsNil((String)((Map)localObject).get(".msg.$bigheadimgurl"));
        locala.FzY = bt.nullAsNil((String)((Map)localObject).get(".msg.$smallheadimgurl"));
        locala.iic = bt.nullAsNil((String)((Map)localObject).get(".msg.$googlecontact"));
        locala.Cin = bt.nullAsNil((String)((Map)localObject).get(".msg.$antispamticket"));
        locala.FzZ = bt.nullAsNil((String)((Map)localObject).get(".msg.$openimappid"));
        locala.FAa = bt.nullAsNil((String)((Map)localObject).get(".msg.$openimdesc"));
        locala.FAb = bt.nullAsNil((String)((Map)localObject).get(".msg.$openimdescicon"));
        locala.FAc = bt.nullAsNil((String)((Map)localObject).get(".msg.$openimcustominfo"));
        if (af.aHH(locala.yGA)) {
          locala.Cin = bt.nullAsNil((String)((Map)localObject).get(".msg.$ticket"));
        }
        ad.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.yGA, locala.Cin, locala.FzX, locala.FzY });
        AppMethodBeat.o(43202);
        return locala;
        locala.yGA = ((String)((Map)localObject).get(".msg.$fromusername"));
      }
    }
    
    public final String eMF()
    {
      return this.yGA;
    }
    
    public final String eMG()
    {
      AppMethodBeat.i(43204);
      if ((this.ilJ != null) && (this.ilJ.length() > 0))
      {
        str = this.ilJ;
        AppMethodBeat.o(43204);
        return str;
      }
      if ((this.ilG != null) && (this.ilG.length() > 0))
      {
        str = this.ilG;
        AppMethodBeat.o(43204);
        return str;
      }
      String str = Long.toString(this.uCr);
      AppMethodBeat.o(43204);
      return str;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43205);
      Object localObject;
      if (!bt.isNullOrNil(this.evF))
      {
        localObject = this.evF.split("_");
        if (localObject.length > 0)
        {
          if (localObject.length <= 2) {
            break label71;
          }
          RegionCodeDecoder.eMO();
          this.evA = RegionCodeDecoder.aV(localObject[0], localObject[1], localObject[2]);
        }
      }
      for (;;)
      {
        localObject = this.evA;
        AppMethodBeat.o(43205);
        return localObject;
        label71:
        if (localObject.length == 2)
        {
          RegionCodeDecoder.eMO();
          this.evA = RegionCodeDecoder.lg(localObject[0], localObject[1]);
        }
        else
        {
          this.evA = "";
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
      if (!TextUtils.isEmpty(this.eKn))
      {
        str = this.eKn;
        AppMethodBeat.o(43203);
        return str;
      }
      ad.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = bt.nullAsNil(this.yGA);
      AppMethodBeat.o(43203);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43206);
      Object localObject;
      if (!bt.isNullOrNil(this.evF))
      {
        localObject = this.evF.split("_");
        if (localObject.length > 0)
        {
          if ((localObject.length <= 2) || (!RegionCodeDecoder.aJc(localObject[0]))) {
            break label77;
          }
          RegionCodeDecoder.eMO();
        }
      }
      for (this.evz = RegionCodeDecoder.lg(localObject[0], localObject[1]);; this.evz = RegionCodeDecoder.aJd(localObject[0]))
      {
        localObject = this.evz;
        AppMethodBeat.o(43206);
        return localObject;
        label77:
        RegionCodeDecoder.eMO();
      }
    }
  }
  
  public static final class b
  {
    public String BNO = "";
    public String FAd = "";
    public String FAe = null;
    public String FAf = null;
    public String FAg = null;
    public int dpd = 0;
    public String goQ = "";
    public String label = "";
    public String sOC = "";
    public double sOv = 0.0D;
    public double sOw = 0.0D;
    public String yGA = "";
    
    public static b aIP(String paramString)
    {
      AppMethodBeat.i(43208);
      b localb = new b();
      paramString = bw.K(paramString, "msg");
      if (paramString != null)
      {
        localb.yGA = bt.by((String)paramString.get(".msg.location.$fromusername"), "");
        localb.sOv = bt.aGj((String)paramString.get(".msg.location.$x"));
        localb.sOw = bt.aGj((String)paramString.get(".msg.location.$y"));
        localb.label = bt.by((String)paramString.get(".msg.location.$label"), "");
        localb.FAd = bt.by((String)paramString.get(".msg.location.$maptype"), "");
        localb.dpd = bt.aGh((String)paramString.get(".msg.location.$scale"));
        localb.FAg = bt.by((String)paramString.get(".msg.location.$localLocationen"), "");
        localb.FAe = bt.by((String)paramString.get(".msg.location.$localLocationcn"), "");
        localb.FAf = bt.by((String)paramString.get(".msg.location.$localLocationtw"), "");
        localb.goQ = bt.by((String)paramString.get(".msg.location.$poiname"), "");
        localb.BNO = bt.by((String)paramString.get(".msg.location.$infourl"), "");
        localb.sOC = bt.by((String)paramString.get(".msg.location.$poiid"), "");
      }
      AppMethodBeat.o(43208);
      return localb;
    }
    
    public final boolean eMH()
    {
      AppMethodBeat.i(43209);
      if ((this.goQ != null) && (!this.goQ.equals("")) && (!this.goQ.equals("[位置]")))
      {
        AppMethodBeat.o(43209);
        return true;
      }
      AppMethodBeat.o(43209);
      return false;
    }
    
    public final boolean eMI()
    {
      AppMethodBeat.i(43210);
      if ((Math.abs(this.sOw) > 180.0D) || (Math.abs(this.sOv) > 90.0D))
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
      String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.sOv * 1000000.0D)), Integer.valueOf((int)(this.sOw * 1000000.0D)), Integer.valueOf(this.dpd) });
      AppMethodBeat.o(43207);
      return str;
    }
  }
  
  public static final class c
  {
    public String FAh = "";
    public String content = "";
    public String hrn = "";
    public boolean qlA = false;
    public String title = "";
    public String uLc;
    
    public static c aIQ(String paramString)
    {
      AppMethodBeat.i(43211);
      c localc = new c();
      paramString = bw.K(paramString, "msg");
      if (paramString != null) {}
      try
      {
        localc.title = ((String)paramString.get(".msg.pushmail.content.subject"));
        localc.content = ((String)paramString.get(".msg.pushmail.content.digest"));
        localc.hrn = ((String)paramString.get(".msg.pushmail.content.sender"));
        localc.FAh = ((String)paramString.get(".msg.pushmail.waplink"));
        localc.qlA = bt.nullAsNil((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
        localc.uLc = ((String)paramString.get(".msg.pushmail.mailid"));
        AppMethodBeat.o(43211);
        return localc;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bt.m(paramString) });
        }
      }
    }
    
    public final String getSender()
    {
      return this.hrn;
    }
    
    public final String getTitle()
    {
      return this.title;
    }
  }
  
  public static final class d
  {
    public String BXw;
    public int FAi = 0;
    public String FAj;
    public String FAk;
    public int FAl;
    public String FAm;
    public String FAn;
    public String FAo;
    public String FAp;
    public int FzU = 0;
    public String FzV = "";
    public String FzW = "";
    public String FzX = "";
    public String FzY = "";
    public String chatroomName = "";
    private String cityCode;
    public String content = "";
    private String countryCode;
    public int djq;
    public String eKn = "";
    public int evp;
    public String iic;
    public String ilE = "";
    public String ilF = "";
    public String ilG = "";
    private String ilJ = "";
    public String jec;
    public String nickname = "";
    private String provinceCode;
    public String rso;
    public int scene = 0;
    public String signature;
    public long uCr = 0L;
    public String yGA = "";
    
    public static d aIR(String paramString)
    {
      AppMethodBeat.i(43212);
      d locald = new d();
      paramString = bw.K(paramString, "msg");
      if (paramString != null) {}
      try
      {
        locald.yGA = ((String)paramString.get(".msg.$fromusername"));
        locald.eKn = ((String)paramString.get(".msg.$alias"));
        locald.nickname = ((String)paramString.get(".msg.$fromnickname"));
        locald.ilF = ((String)paramString.get(".msg.$fullpy"));
        locald.ilE = ((String)paramString.get(".msg.$shortpy"));
        locald.content = ((String)paramString.get(".msg.$content"));
        locald.FzU = bt.getInt((String)paramString.get(".msg.$imagestatus"), 0);
        locald.scene = bt.getInt((String)paramString.get(".msg.$scene"), 0);
        locald.FzV = ((String)paramString.get(".msg.$mhash"));
        locald.FzW = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          locald.uCr = bt.getLong((String)paramString.get(".msg.$qqnum"), 0L);
        }
        locald.ilG = ((String)paramString.get(".msg.$qqnickname"));
        locald.ilJ = ((String)paramString.get(".msg.$qqremark"));
        locald.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          locald.evp = bt.getInt((String)paramString.get(".msg.$sex"), 0);
        }
        locald.cityCode = ((String)paramString.get(".msg.$city"));
        locald.provinceCode = ((String)paramString.get(".msg.$province"));
        locald.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          locald.FAi = bt.getInt((String)paramString.get(".msg.$snsflag"), 0);
          locald.FAj = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        locald.rso = ((String)paramString.get(".msg.$ticket"));
        ad.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { locald.rso });
        locald.FzX = bt.nullAsNil((String)paramString.get(".msg.$bigheadimgurl"));
        locald.FzY = bt.nullAsNil((String)paramString.get(".msg.$smallheadimgurl"));
        locald.djq = bt.getInt((String)paramString.get(".msg.$opcode"), 0);
        locald.FAk = bt.nullAsNil((String)paramString.get(".msg.$encryptusername"));
        locald.iic = bt.nullAsNil((String)paramString.get(".msg.$googlecontact"));
        ad.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { locald.yGA, locald.FzX, locald.FzY });
        locald.chatroomName = bt.nullAsNil((String)paramString.get(".msg.$chatroomusername"));
        locald.jec = ((String)paramString.get(".msg.$sourceusername"));
        locald.BXw = ((String)paramString.get(".msg.$sourcenickname"));
        locald.FAo = ((String)paramString.get(".msg.$sharecardusername"));
        locald.FAp = ((String)paramString.get(".msg.$sharecardnickname"));
        locald.FAl = bt.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (locald.FAl == 1)
        {
          locald.FAm = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          locald.FAn = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
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
    
    public final String Gn()
    {
      return this.signature;
    }
    
    public final String Ss()
    {
      return this.eKn;
    }
    
    public final String Su()
    {
      return this.nickname;
    }
    
    public final String Sv()
    {
      return this.ilE;
    }
    
    public final String Sw()
    {
      return this.ilF;
    }
    
    public final String eMF()
    {
      return this.yGA;
    }
    
    public final String eMJ()
    {
      return this.rso;
    }
    
    public final int eMK()
    {
      return this.evp;
    }
    
    public final String eML()
    {
      return this.FAk;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43214);
      if ((!bt.isNullOrNil(this.countryCode)) && (!bt.isNullOrNil(this.provinceCode)))
      {
        if (bt.isNullOrNil(this.cityCode))
        {
          RegionCodeDecoder.eMO();
          str = RegionCodeDecoder.lg(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43214);
          return str;
        }
        RegionCodeDecoder.eMO();
        str = RegionCodeDecoder.aV(this.countryCode, this.provinceCode, this.cityCode);
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
      String str = this.yGA;
      AppMethodBeat.o(43213);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43215);
      if (!bt.isNullOrNil(this.countryCode))
      {
        if ((!bt.isNullOrNil(this.provinceCode)) && (!bt.isNullOrNil(this.cityCode)) && (RegionCodeDecoder.aJc(this.countryCode)))
        {
          RegionCodeDecoder.eMO();
          str = RegionCodeDecoder.lg(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43215);
          return str;
        }
        RegionCodeDecoder.eMO();
        str = RegionCodeDecoder.aJd(this.countryCode);
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
 * Qualified Name:     com.tencent.mm.storage.bl
 * JD-Core Version:    0.7.0.1
 */