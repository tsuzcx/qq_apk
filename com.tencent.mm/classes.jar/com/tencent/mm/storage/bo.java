package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.aa;
import com.tencent.mm.az.a.a;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;
import junit.framework.Assert;

public final class bo
  extends aa
{
  public static String GYO = "voip_content_voice";
  public static String GYP = "voip_content_video";
  public iu GYQ;
  public boolean GYR;
  public boolean GYS;
  private String GYT;
  public String sessionId;
  
  public bo()
  {
    this.GYQ = null;
    this.GYR = false;
    this.GYS = false;
  }
  
  public bo(String paramString)
  {
    AppMethodBeat.i(43216);
    this.GYQ = null;
    this.GYR = false;
    this.GYS = false;
    super.re(paramString);
    AppMethodBeat.o(43216);
  }
  
  public static void AQ(long paramLong)
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
  
  private static boolean Ly()
  {
    AppMethodBeat.i(43261);
    String str = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("TranslateMsgOff");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(43261);
      return true;
    }
    if (bs.aLy(str) != 0)
    {
      ac.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
      AppMethodBeat.o(43261);
      return false;
    }
    AppMethodBeat.o(43261);
    return true;
  }
  
  public static bo aK(bo parambo)
  {
    AppMethodBeat.i(43247);
    if (parambo == null)
    {
      ac.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
      AppMethodBeat.o(43247);
      return null;
    }
    bo localbo = new bo();
    localbo.setMsgId(parambo.field_msgId);
    localbo.oz(parambo.field_msgSvrId);
    localbo.setType(parambo.getType());
    localbo.setStatus(parambo.field_status);
    localbo.jT(parambo.field_isSend);
    localbo.field_isShowTimer = parambo.field_isShowTimer;
    localbo.eRP = true;
    localbo.oA(parambo.field_createTime);
    localbo.re(parambo.field_talker);
    localbo.setContent(parambo.field_content);
    localbo.rf(parambo.field_imgPath);
    localbo.rg(parambo.field_reserved);
    localbo.N(parambo.field_lvbuffer);
    localbo.rh(parambo.field_transContent);
    localbo.rj(parambo.eSb);
    localbo.jA(parambo.euk);
    localbo.qf(parambo.eul);
    AppMethodBeat.o(43247);
    return localbo;
  }
  
  public static boolean bN(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43266);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication"))) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43266);
      return bool;
    }
  }
  
  public static boolean bO(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43267);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval"))) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43267);
      return bool;
    }
  }
  
  private boolean fbP()
  {
    AppMethodBeat.i(43249);
    if ((!isText()) && (!cKP()) && (!fbB()))
    {
      AppMethodBeat.o(43249);
      return true;
    }
    AppMethodBeat.o(43249);
    return false;
  }
  
  public final void YN(int paramInt)
  {
    AppMethodBeat.i(43260);
    switch (paramInt)
    {
    default: 
      ac.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      AppMethodBeat.o(43260);
      return;
    }
    jA(this.euk | paramInt);
    AppMethodBeat.o(43260);
  }
  
  public final boolean aOj(String paramString)
  {
    AppMethodBeat.i(43264);
    if ((!bs.isNullOrNil(this.eul)) && (!bs.isNullOrNil(paramString)))
    {
      Object localObject = bv.L(this.eul, "msgsource");
      if (localObject == null)
      {
        AppMethodBeat.o(43264);
        return false;
      }
      localObject = (String)((Map)localObject).get(".msgsource.atuserlist");
      if (!bs.isNullOrNil((String)localObject))
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
  
  public final boolean cKN()
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
  
  public final boolean cKP()
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
      ac.e("MicroMsg.MsgInfo", localStringBuilder.toString());
      setType(1);
      setContent("");
      paramCursor = aK(this);
      g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43201);
          ((k)g.ab(k.class)).dcr().a(l, this.GYU);
          AppMethodBeat.o(43201);
        }
      });
    }
    AQ(this.field_msgId);
    AppMethodBeat.o(43268);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43270);
    AQ(this.field_msgId);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(43270);
    return localContentValues;
  }
  
  public final boolean crt()
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
  
  public final boolean cru()
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
  
  public final boolean crv()
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
  
  public final boolean eZj()
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
  
  public final boolean eZl()
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
  
  public final boolean eZm()
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
  
  public final boolean fbA()
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
  
  public final boolean fbB()
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
  
  public final boolean fbC()
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
  
  public final boolean fbD()
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
  
  public final boolean fbE()
  {
    AppMethodBeat.i(194055);
    if (super.getType() == 855638065)
    {
      AppMethodBeat.o(194055);
      return true;
    }
    AppMethodBeat.o(194055);
    return false;
  }
  
  public final boolean fbF()
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
  
  public final boolean fbG()
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
  
  public final boolean fbH()
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
  
  public final boolean fbI()
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
  
  public final boolean fbJ()
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
  
  public final boolean fbK()
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
  
  public final boolean fbL()
  {
    AppMethodBeat.i(194056);
    if (super.getType() == 889192497)
    {
      AppMethodBeat.o(194056);
      return true;
    }
    AppMethodBeat.o(194056);
    return false;
  }
  
  public final boolean fbM()
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
  
  public final boolean fbN()
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
  
  public final boolean fbO()
  {
    AppMethodBeat.i(43246);
    if ((Ly()) && (!bs.isNullOrNil(this.field_transContent)))
    {
      AppMethodBeat.o(43246);
      return true;
    }
    AppMethodBeat.o(43246);
    return false;
  }
  
  public final boolean fbQ()
  {
    return (this.eSe & 0x1) > 0;
  }
  
  public final void fbR()
  {
    AppMethodBeat.i(43250);
    kg(this.eSe | 0x1);
    AppMethodBeat.o(43250);
  }
  
  public final boolean fbS()
  {
    return (this.euk & 0x200) > 0;
  }
  
  public final void fbT()
  {
    AppMethodBeat.i(43251);
    jA(this.euk | 0x200);
    AppMethodBeat.o(43251);
  }
  
  public final void fbU()
  {
    AppMethodBeat.i(178875);
    jA(this.euk | 0x800);
    AppMethodBeat.o(178875);
  }
  
  public final void fbV()
  {
    AppMethodBeat.i(43252);
    if (fbW()) {
      jA(this.euk & 0xFFFFFFDF);
    }
    AppMethodBeat.o(43252);
  }
  
  public final boolean fbW()
  {
    return (this.euk & 0x20) > 0;
  }
  
  public final void fbX()
  {
    AppMethodBeat.i(43253);
    jA(this.euk | 0x8);
    AppMethodBeat.o(43253);
  }
  
  public final boolean fbY()
  {
    AppMethodBeat.i(43254);
    if ((fbO()) && ((this.euk & 0x10) > 0))
    {
      AppMethodBeat.o(43254);
      return true;
    }
    AppMethodBeat.o(43254);
    return false;
  }
  
  public final void fbZ()
  {
    AppMethodBeat.i(43255);
    if (!fbO())
    {
      AppMethodBeat.o(43255);
      return;
    }
    jA(this.euk | 0x10);
    AppMethodBeat.o(43255);
  }
  
  public final boolean fbt()
  {
    AppMethodBeat.i(43220);
    if ((super.getType() == 486539313) && (this.GYR) && (this.GYQ != null))
    {
      AppMethodBeat.o(43220);
      return true;
    }
    AppMethodBeat.o(43220);
    return false;
  }
  
  public final boolean fbu()
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
  
  public final boolean fbv()
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
  
  public final boolean fbw()
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
  
  public final boolean fbx()
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
  
  public final boolean fby()
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
  
  public final boolean fbz()
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
  
  public final void fca()
  {
    AppMethodBeat.i(43256);
    if (!fbO())
    {
      AppMethodBeat.o(43256);
      return;
    }
    jA(this.euk & 0xFFFFFFEF);
    AppMethodBeat.o(43256);
  }
  
  public final boolean fcb()
  {
    AppMethodBeat.i(43257);
    if ((fbO()) && ((this.euk & 0x400) > 0))
    {
      AppMethodBeat.o(43257);
      return true;
    }
    AppMethodBeat.o(43257);
    return false;
  }
  
  public final void fcc()
  {
    AppMethodBeat.i(43258);
    jA(this.euk | 0x80);
    AppMethodBeat.o(43258);
  }
  
  public final void fcd()
  {
    AppMethodBeat.i(43259);
    jA(this.euk & 0xFFFFFF7F);
    AppMethodBeat.o(43259);
  }
  
  public final boolean fce()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ((this.euk & 0x80) == 0)
    {
      bool1 = bool2;
      if ((this.euk & 0x300) == 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final void fcf()
  {
    AppMethodBeat.i(43262);
    jA(this.euk & 0xFFFFFFBF);
    AppMethodBeat.o(43262);
  }
  
  public final void fcg()
  {
    AppMethodBeat.i(43263);
    jA(this.euk | 0x40);
    AppMethodBeat.o(43263);
  }
  
  public final boolean fch()
  {
    AppMethodBeat.i(43265);
    if ((!bs.isNullOrNil(this.eul)) && ((this.eul.contains("announcement@all")) || (this.eul.contains("notify@all")))) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43265);
      return bool;
    }
  }
  
  public final String fci()
  {
    AppMethodBeat.i(43271);
    if (!fbA())
    {
      AppMethodBeat.o(43271);
      return "";
    }
    if (this.GYT == null) {
      fcj();
    }
    String str = this.GYT;
    AppMethodBeat.o(43271);
    return str;
  }
  
  public final com.tencent.mm.az.a fcj()
  {
    AppMethodBeat.i(43272);
    ac.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    com.tencent.mm.az.a locala = a.a.b(bv.L(this.field_content, "sysmsg"), this);
    if (locala != null)
    {
      ac.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { locala });
      locala.aGG();
      this.GYT = locala.TEXT;
    }
    for (;;)
    {
      AppMethodBeat.o(43272);
      return locala;
      ac.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(210244);
    int i = super.getType();
    AppMethodBeat.o(210244);
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
    if ((this.field_isSend == 1) && (fbP()))
    {
      if (this.field_status == 5)
      {
        ac.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()), this.field_talker, bs.eWi() });
        localObject = new sl();
        ((sl)localObject).dvx.cZc = this;
        com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
        AppMethodBeat.o(43248);
        return;
      }
      if (this.field_status == 2)
      {
        ac.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()) });
        localObject = new sn();
        ((sn)localObject).dvz.cZc = this;
        com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
        AppMethodBeat.o(43248);
      }
    }
    else if (this.field_isSend == 0)
    {
      localObject = new pn();
      ((pn)localObject).dsx.cZc = this;
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
    }
    AppMethodBeat.o(43248);
  }
  
  public static final class a
  {
    public int Chb = 0;
    public String DAE = "";
    public int GYW = 0;
    public String GYX = "";
    public String GYY = "";
    public String GYZ = "";
    public String GZa = "";
    public String GZb = "";
    public String GZc = "";
    public String GZd = "";
    public String GZe = "";
    public String eNf = "";
    public int exL;
    private String exV;
    private String exW;
    public String eya = "";
    private String eyb = "";
    public String iIk = "";
    public String iLL = "";
    public String iLM = "";
    public String iLN = "";
    public String iLQ = "";
    public String nickname = "";
    public int scene = 0;
    public String signature;
    private String source = "";
    public String vIX = "";
    public long vLk = 0L;
    public String zTO = "";
    
    public static a aOk(String paramString)
    {
      AppMethodBeat.i(43202);
      locala = new a();
      localObject = bs.bG(paramString, "").trim();
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("<"))
      {
        int i = ((String)localObject).indexOf(":");
        paramString = (String)localObject;
        if (i != -1) {
          paramString = ((String)localObject).substring(i + 1);
        }
      }
      localObject = bv.L(paramString, "msg");
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          if (((Map)localObject).get(".msg.$fromusername") != null) {
            continue;
          }
          locala.zTO = ((String)((Map)localObject).get(".msg.$username"));
          if (((Map)localObject).get(".msg.$fromnickname") != null) {
            continue;
          }
          locala.nickname = ((String)((Map)localObject).get(".msg.$nickname"));
        }
        catch (Exception paramString)
        {
          ac.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bs.m(paramString) });
          continue;
          locala.nickname = ((String)((Map)localObject).get(".msg.$fromnickname"));
          continue;
          paramString = (String)((Map)localObject).get(".msg.$certflag");
          continue;
        }
        locala.eNf = ((String)((Map)localObject).get(".msg.$alias"));
        locala.iLM = ((String)((Map)localObject).get(".msg.$fullpy"));
        locala.iLL = ((String)((Map)localObject).get(".msg.$shortpy"));
        locala.source = ((String)((Map)localObject).get(".msg.$source"));
        locala.GYW = bs.getInt((String)((Map)localObject).get(".msg.$imagestatus"), 0);
        locala.scene = bs.getInt((String)((Map)localObject).get(".msg.$scene"), 0);
        locala.GYX = ((String)((Map)localObject).get(".msg.$mobileidentify"));
        locala.GYY = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
        if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
          locala.vLk = bs.getLong((String)((Map)localObject).get(".msg.$qqnum"), 0L);
        }
        locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
        if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
          locala.exL = bs.getInt((String)((Map)localObject).get(".msg.$sex"), 0);
        }
        locala.exW = ((String)((Map)localObject).get(".msg.$city"));
        locala.exV = ((String)((Map)localObject).get(".msg.$province"));
        locala.iLN = ((String)((Map)localObject).get(".msg.$qqnickname"));
        locala.iLQ = ((String)((Map)localObject).get(".msg.$qqremark"));
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
          continue;
        }
        paramString = "0";
        locala.Chb = bs.getInt(paramString, 0);
        locala.eya = bs.nullAsNil((String)((Map)localObject).get(".msg.$certinfo"));
        locala.vIX = bs.nullAsNil((String)((Map)localObject).get(".msg.$brandIconUrl"));
        locala.eyb = bs.nullAsNil((String)((Map)localObject).get(".msg.$regionCode"));
        locala.GYZ = bs.nullAsNil((String)((Map)localObject).get(".msg.$bigheadimgurl"));
        locala.GZa = bs.nullAsNil((String)((Map)localObject).get(".msg.$smallheadimgurl"));
        locala.iIk = bs.nullAsNil((String)((Map)localObject).get(".msg.$googlecontact"));
        locala.DAE = bs.nullAsNil((String)((Map)localObject).get(".msg.$antispamticket"));
        locala.GZb = bs.nullAsNil((String)((Map)localObject).get(".msg.$openimappid"));
        locala.GZc = bs.nullAsNil((String)((Map)localObject).get(".msg.$openimdesc"));
        locala.GZd = bs.nullAsNil((String)((Map)localObject).get(".msg.$openimdescicon"));
        locala.GZe = bs.nullAsNil((String)((Map)localObject).get(".msg.$openimcustominfo"));
        if (ai.aNc(locala.zTO)) {
          locala.DAE = bs.nullAsNil((String)((Map)localObject).get(".msg.$ticket"));
        }
        ac.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.zTO, locala.DAE, locala.GYZ, locala.GZa });
        AppMethodBeat.o(43202);
        return locala;
        locala.zTO = ((String)((Map)localObject).get(".msg.$fromusername"));
      }
    }
    
    public final String fck()
    {
      return this.zTO;
    }
    
    public final String fcl()
    {
      AppMethodBeat.i(43204);
      if ((this.iLQ != null) && (this.iLQ.length() > 0))
      {
        str = this.iLQ;
        AppMethodBeat.o(43204);
        return str;
      }
      if ((this.iLN != null) && (this.iLN.length() > 0))
      {
        str = this.iLN;
        AppMethodBeat.o(43204);
        return str;
      }
      String str = Long.toString(this.vLk);
      AppMethodBeat.o(43204);
      return str;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43205);
      Object localObject;
      if (!bs.isNullOrNil(this.eyb))
      {
        localObject = this.eyb.split("_");
        if (localObject.length > 0)
        {
          if (localObject.length <= 2) {
            break label71;
          }
          RegionCodeDecoder.fcs();
          this.exW = RegionCodeDecoder.aY(localObject[0], localObject[1], localObject[2]);
        }
      }
      for (;;)
      {
        localObject = this.exW;
        AppMethodBeat.o(43205);
        return localObject;
        label71:
        if (localObject.length == 2)
        {
          RegionCodeDecoder.fcs();
          this.exW = RegionCodeDecoder.lD(localObject[0], localObject[1]);
        }
        else
        {
          this.exW = "";
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
      if (!TextUtils.isEmpty(this.eNf))
      {
        str = this.eNf;
        AppMethodBeat.o(43203);
        return str;
      }
      ac.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = bs.nullAsNil(this.zTO);
      AppMethodBeat.o(43203);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43206);
      Object localObject;
      if (!bs.isNullOrNil(this.eyb))
      {
        localObject = this.eyb.split("_");
        if (localObject.length > 0)
        {
          if ((localObject.length <= 2) || (!RegionCodeDecoder.aOy(localObject[0]))) {
            break label77;
          }
          RegionCodeDecoder.fcs();
        }
      }
      for (this.exV = RegionCodeDecoder.lD(localObject[0], localObject[1]);; this.exV = RegionCodeDecoder.aOz(localObject[0]))
      {
        localObject = this.exV;
        AppMethodBeat.o(43206);
        return localObject;
        label77:
        RegionCodeDecoder.fcs();
      }
    }
  }
  
  public static final class b
  {
    public String DfY = "";
    public String GZf = "";
    public String GZg = null;
    public String GZh = null;
    public String GZi = null;
    public int dmN = 0;
    public String gPy = "";
    public String label = "";
    public double tWI = 0.0D;
    public double tWJ = 0.0D;
    public String tWP = "";
    public String zTO = "";
    
    public static b aOl(String paramString)
    {
      AppMethodBeat.i(43208);
      b localb = new b();
      paramString = bv.L(paramString, "msg");
      if (paramString != null)
      {
        localb.zTO = bs.bG((String)paramString.get(".msg.location.$fromusername"), "");
        localb.tWI = bs.aLA((String)paramString.get(".msg.location.$x"));
        localb.tWJ = bs.aLA((String)paramString.get(".msg.location.$y"));
        localb.label = bs.bG((String)paramString.get(".msg.location.$label"), "");
        localb.GZf = bs.bG((String)paramString.get(".msg.location.$maptype"), "");
        localb.dmN = bs.aLy((String)paramString.get(".msg.location.$scale"));
        localb.GZi = bs.bG((String)paramString.get(".msg.location.$localLocationen"), "");
        localb.GZg = bs.bG((String)paramString.get(".msg.location.$localLocationcn"), "");
        localb.GZh = bs.bG((String)paramString.get(".msg.location.$localLocationtw"), "");
        localb.gPy = bs.bG((String)paramString.get(".msg.location.$poiname"), "");
        localb.DfY = bs.bG((String)paramString.get(".msg.location.$infourl"), "");
        localb.tWP = bs.bG((String)paramString.get(".msg.location.$poiid"), "");
      }
      AppMethodBeat.o(43208);
      return localb;
    }
    
    public final boolean fcm()
    {
      AppMethodBeat.i(43209);
      if ((this.gPy != null) && (!this.gPy.equals("")) && (!this.gPy.equals("[位置]")))
      {
        AppMethodBeat.o(43209);
        return true;
      }
      AppMethodBeat.o(43209);
      return false;
    }
    
    public final boolean fcn()
    {
      AppMethodBeat.i(43210);
      if ((Math.abs(this.tWJ) > 180.0D) || (Math.abs(this.tWI) > 90.0D))
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
      String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.tWI * 1000000.0D)), Integer.valueOf((int)(this.tWJ * 1000000.0D)), Integer.valueOf(this.dmN) });
      AppMethodBeat.o(43207);
      return str;
    }
  }
  
  public static final class c
  {
    public String GZj = "";
    public String content = "";
    public String hRP = "";
    public boolean qUc = false;
    public String title = "";
    public String vTT;
    
    public static c aOm(String paramString)
    {
      AppMethodBeat.i(43211);
      c localc = new c();
      paramString = bv.L(paramString, "msg");
      if (paramString != null) {}
      try
      {
        localc.title = ((String)paramString.get(".msg.pushmail.content.subject"));
        localc.content = ((String)paramString.get(".msg.pushmail.content.digest"));
        localc.hRP = ((String)paramString.get(".msg.pushmail.content.sender"));
        localc.GZj = ((String)paramString.get(".msg.pushmail.waplink"));
        localc.qUc = bs.nullAsNil((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
        localc.vTT = ((String)paramString.get(".msg.pushmail.mailid"));
        AppMethodBeat.o(43211);
        return localc;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ac.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bs.m(paramString) });
        }
      }
    }
    
    public final String getSender()
    {
      return this.hRP;
    }
    
    public final String getTitle()
    {
      return this.title;
    }
  }
  
  public static final class d
  {
    public String DpN;
    public int GYW = 0;
    public String GYX = "";
    public String GYY = "";
    public String GYZ = "";
    public String GZa = "";
    public int GZk = 0;
    public String GZl;
    public String GZm;
    public int GZn;
    public String GZo;
    public String GZp;
    public String GZq;
    public String GZr;
    public String chatroomName = "";
    private String cityCode;
    public String content = "";
    private String countryCode;
    public int dgL;
    public String eNf = "";
    public int exL;
    public String iIk;
    public String iLL = "";
    public String iLM = "";
    public String iLN = "";
    private String iLQ = "";
    public String jEq;
    public String nickname = "";
    private String provinceCode;
    public String sBi;
    public int scene = 0;
    public String signature;
    public long vLk = 0L;
    public String zTO = "";
    
    public static d aOn(String paramString)
    {
      AppMethodBeat.i(43212);
      d locald = new d();
      paramString = bv.L(paramString, "msg");
      if (paramString != null) {}
      try
      {
        locald.zTO = ((String)paramString.get(".msg.$fromusername"));
        locald.eNf = ((String)paramString.get(".msg.$alias"));
        locald.nickname = ((String)paramString.get(".msg.$fromnickname"));
        locald.iLM = ((String)paramString.get(".msg.$fullpy"));
        locald.iLL = ((String)paramString.get(".msg.$shortpy"));
        locald.content = ((String)paramString.get(".msg.$content"));
        locald.GYW = bs.getInt((String)paramString.get(".msg.$imagestatus"), 0);
        locald.scene = bs.getInt((String)paramString.get(".msg.$scene"), 0);
        locald.GYX = ((String)paramString.get(".msg.$mhash"));
        locald.GYY = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          locald.vLk = bs.getLong((String)paramString.get(".msg.$qqnum"), 0L);
        }
        locald.iLN = ((String)paramString.get(".msg.$qqnickname"));
        locald.iLQ = ((String)paramString.get(".msg.$qqremark"));
        locald.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          locald.exL = bs.getInt((String)paramString.get(".msg.$sex"), 0);
        }
        locald.cityCode = ((String)paramString.get(".msg.$city"));
        locald.provinceCode = ((String)paramString.get(".msg.$province"));
        locald.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          locald.GZk = bs.getInt((String)paramString.get(".msg.$snsflag"), 0);
          locald.GZl = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        locald.sBi = ((String)paramString.get(".msg.$ticket"));
        ac.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { locald.sBi });
        locald.GYZ = bs.nullAsNil((String)paramString.get(".msg.$bigheadimgurl"));
        locald.GZa = bs.nullAsNil((String)paramString.get(".msg.$smallheadimgurl"));
        locald.dgL = bs.getInt((String)paramString.get(".msg.$opcode"), 0);
        locald.GZm = bs.nullAsNil((String)paramString.get(".msg.$encryptusername"));
        locald.iIk = bs.nullAsNil((String)paramString.get(".msg.$googlecontact"));
        ac.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { locald.zTO, locald.GYZ, locald.GZa });
        locald.chatroomName = bs.nullAsNil((String)paramString.get(".msg.$chatroomusername"));
        locald.jEq = ((String)paramString.get(".msg.$sourceusername"));
        locald.DpN = ((String)paramString.get(".msg.$sourcenickname"));
        locald.GZq = ((String)paramString.get(".msg.$sharecardusername"));
        locald.GZr = ((String)paramString.get(".msg.$sharecardnickname"));
        locald.GZn = bs.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (locald.GZn == 1)
        {
          locald.GZo = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          locald.GZp = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.MsgInfo", paramString, "", new Object[0]);
        }
      }
      AppMethodBeat.o(43212);
      return locald;
    }
    
    public final String FZ()
    {
      return this.signature;
    }
    
    public final String Tl()
    {
      return this.eNf;
    }
    
    public final String Tn()
    {
      return this.nickname;
    }
    
    public final String To()
    {
      return this.iLL;
    }
    
    public final String Tp()
    {
      return this.iLM;
    }
    
    public final int Tt()
    {
      return this.exL;
    }
    
    public final String fck()
    {
      return this.zTO;
    }
    
    public final String fco()
    {
      return this.sBi;
    }
    
    public final String fcp()
    {
      return this.GZm;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43214);
      if ((!bs.isNullOrNil(this.countryCode)) && (!bs.isNullOrNil(this.provinceCode)))
      {
        if (bs.isNullOrNil(this.cityCode))
        {
          RegionCodeDecoder.fcs();
          str = RegionCodeDecoder.lD(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43214);
          return str;
        }
        RegionCodeDecoder.fcs();
        str = RegionCodeDecoder.aY(this.countryCode, this.provinceCode, this.cityCode);
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
      ac.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = this.zTO;
      AppMethodBeat.o(43213);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43215);
      if (!bs.isNullOrNil(this.countryCode))
      {
        if ((!bs.isNullOrNil(this.provinceCode)) && (!bs.isNullOrNil(this.cityCode)) && (RegionCodeDecoder.aOy(this.countryCode)))
        {
          RegionCodeDecoder.fcs();
          str = RegionCodeDecoder.lD(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43215);
          return str;
        }
        RegionCodeDecoder.fcs();
        str = RegionCodeDecoder.aOz(this.countryCode);
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
 * Qualified Name:     com.tencent.mm.storage.bo
 * JD-Core Version:    0.7.0.1
 */