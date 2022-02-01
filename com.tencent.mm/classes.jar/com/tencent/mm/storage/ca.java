package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.ab;
import com.tencent.mm.az.a.a;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import junit.framework.Assert;

public final class ca
  extends ab
{
  public static String OqB = "voip_content_voice";
  public static String OqC = "voip_content_video";
  public jo OqD;
  public boolean OqE;
  public boolean OqF;
  private String OqG;
  public boolean ZA;
  public String sessionId;
  
  public ca()
  {
    this.OqD = null;
    this.OqE = false;
    this.OqF = false;
    this.ZA = false;
  }
  
  public ca(String paramString)
  {
    AppMethodBeat.i(43216);
    this.OqD = null;
    this.OqE = false;
    this.OqF = false;
    this.ZA = false;
    super.Cy(paramString);
    AppMethodBeat.o(43216);
  }
  
  public static void Nj(long paramLong)
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
  
  private static boolean Xn()
  {
    AppMethodBeat.i(43261);
    String str = ((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("TranslateMsgOff");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(43261);
      return true;
    }
    if (Util.safeParseInt(str) != 0)
    {
      Log.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
      AppMethodBeat.o(43261);
      return false;
    }
    AppMethodBeat.o(43261);
    return true;
  }
  
  public static ca aZ(ca paramca)
  {
    AppMethodBeat.i(43247);
    if (paramca == null)
    {
      Log.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
      AppMethodBeat.o(43247);
      return null;
    }
    ca localca = new ca();
    localca.setMsgId(paramca.field_msgId);
    localca.yF(paramca.field_msgSvrId);
    localca.setType(paramca.getType());
    localca.setStatus(paramca.field_status);
    localca.nv(paramca.field_isSend);
    localca.field_isShowTimer = paramca.field_isShowTimer;
    localca.fqN = true;
    localca.setCreateTime(paramca.field_createTime);
    localca.Cy(paramca.field_talker);
    localca.setContent(paramca.field_content);
    localca.Cz(paramca.field_imgPath);
    localca.CA(paramca.field_reserved);
    localca.aa(paramca.field_lvbuffer);
    localca.CB(paramca.field_transContent);
    localca.CG(paramca.fQR);
    localca.nc(paramca.fqJ);
    localca.BB(paramca.fqK);
    AppMethodBeat.o(43247);
    return localca;
  }
  
  public static boolean cd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43266);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication"))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43266);
      return bool;
    }
  }
  
  public static boolean ce(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43267);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval"))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43267);
      return bool;
    }
  }
  
  private boolean gDA()
  {
    AppMethodBeat.i(43249);
    if ((!isText()) && (!dOS()) && (!gDl()))
    {
      AppMethodBeat.o(43249);
      return true;
    }
    AppMethodBeat.o(43249);
    return false;
  }
  
  public final void akm(int paramInt)
  {
    AppMethodBeat.i(43260);
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      AppMethodBeat.o(43260);
      return;
    }
    nc(this.fqJ | paramInt);
    AppMethodBeat.o(43260);
  }
  
  public final boolean bkz(String paramString)
  {
    AppMethodBeat.i(43264);
    if ((!Util.isNullOrNil(this.fqK)) && (!Util.isNullOrNil(paramString)))
    {
      Object localObject = XmlParser.parseXml(this.fqK, "msgsource", null);
      if (localObject == null)
      {
        AppMethodBeat.o(43264);
        return false;
      }
      localObject = (String)((Map)localObject).get(".msgsource.atuserlist");
      if (!Util.isNullOrNil((String)localObject))
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
  
  public final boolean cWJ()
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
  
  public final boolean cWK()
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
  
  public final boolean cWL()
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
      Log.e("MicroMsg.MsgInfo", localStringBuilder.toString());
      setType(1);
      setContent("");
      paramCursor = aZ(this);
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43201);
          ((l)g.af(l.class)).eiy().a(l, this.OqH);
          AppMethodBeat.o(43201);
        }
      });
    }
    Nj(this.field_msgId);
    AppMethodBeat.o(43268);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43270);
    Nj(this.field_msgId);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(43270);
    return localContentValues;
  }
  
  public final boolean dOQ()
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
  
  public final boolean dOS()
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
  
  public final boolean gAt()
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
  
  public final boolean gAy()
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
  
  public final boolean gAz()
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
  
  public final boolean gDB()
  {
    return (this.fQU & 0x1) > 0;
  }
  
  public final void gDC()
  {
    AppMethodBeat.i(43250);
    nI(this.fQU | 0x1);
    AppMethodBeat.o(43250);
  }
  
  public final boolean gDD()
  {
    return (this.fqJ & 0x200) > 0;
  }
  
  public final void gDE()
  {
    AppMethodBeat.i(43251);
    nc(this.fqJ | 0x200);
    AppMethodBeat.o(43251);
  }
  
  public final void gDF()
  {
    AppMethodBeat.i(178875);
    nc(this.fqJ | 0x800);
    AppMethodBeat.o(178875);
  }
  
  public final int gDG()
  {
    return this.fqJ & 0x4;
  }
  
  public final void gDH()
  {
    AppMethodBeat.i(43253);
    nc(this.fqJ | 0x8);
    AppMethodBeat.o(43253);
  }
  
  public final boolean gDI()
  {
    AppMethodBeat.i(43254);
    if ((gDz()) && ((this.fqJ & 0x10) > 0))
    {
      AppMethodBeat.o(43254);
      return true;
    }
    AppMethodBeat.o(43254);
    return false;
  }
  
  public final void gDJ()
  {
    AppMethodBeat.i(43255);
    if (!gDz())
    {
      AppMethodBeat.o(43255);
      return;
    }
    nc(this.fqJ | 0x10);
    AppMethodBeat.o(43255);
  }
  
  public final void gDK()
  {
    AppMethodBeat.i(43256);
    if (!gDz())
    {
      AppMethodBeat.o(43256);
      return;
    }
    nc(this.fqJ & 0xFFFFFFEF);
    AppMethodBeat.o(43256);
  }
  
  public final boolean gDL()
  {
    AppMethodBeat.i(43257);
    if ((gDz()) && ((this.fqJ & 0x400) > 0))
    {
      AppMethodBeat.o(43257);
      return true;
    }
    AppMethodBeat.o(43257);
    return false;
  }
  
  public final void gDM()
  {
    AppMethodBeat.i(43258);
    nc(this.fqJ | 0x80);
    AppMethodBeat.o(43258);
  }
  
  public final void gDN()
  {
    AppMethodBeat.i(43259);
    nc(this.fqJ & 0xFFFFFF7F);
    AppMethodBeat.o(43259);
  }
  
  public final boolean gDO()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ((this.fqJ & 0x80) == 0)
    {
      bool1 = bool2;
      if ((this.fqJ & 0x300) == 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final boolean gDP()
  {
    return (this.fqJ & 0x2000) > 0;
  }
  
  public final void gDQ()
  {
    AppMethodBeat.i(225994);
    nc(this.fqJ | 0x2000);
    AppMethodBeat.o(225994);
  }
  
  public final void gDR()
  {
    AppMethodBeat.i(225995);
    nc(this.fqJ & 0xFFFFDFFF);
    AppMethodBeat.o(225995);
  }
  
  public final boolean gDS()
  {
    return (this.fqJ & 0x1000) > 0;
  }
  
  public final void gDT()
  {
    AppMethodBeat.i(43262);
    nc(this.fqJ & 0xFFFFFFBF);
    AppMethodBeat.o(43262);
  }
  
  public final void gDU()
  {
    AppMethodBeat.i(43263);
    nc(this.fqJ | 0x40);
    AppMethodBeat.o(43263);
  }
  
  public final boolean gDV()
  {
    AppMethodBeat.i(43265);
    if ((!Util.isNullOrNil(this.fqK)) && ((this.fqK.contains("announcement@all")) || (this.fqK.contains("notify@all")))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43265);
      return bool;
    }
  }
  
  public final String gDW()
  {
    AppMethodBeat.i(43271);
    if (!gDk())
    {
      AppMethodBeat.o(43271);
      return "";
    }
    if (this.OqG == null) {
      gDX();
    }
    String str = this.OqG;
    AppMethodBeat.o(43271);
    return str;
  }
  
  public final com.tencent.mm.az.a gDX()
  {
    AppMethodBeat.i(43272);
    Log.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    com.tencent.mm.az.a locala = a.a.b(XmlParser.parseXml(this.field_content, "sysmsg", null), this);
    if (locala != null)
    {
      Log.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { locala });
      locala.ben();
      this.OqG = locala.TEXT;
    }
    for (;;)
    {
      AppMethodBeat.o(43272);
      return locala;
      Log.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    }
  }
  
  public final boolean gDd()
  {
    AppMethodBeat.i(43220);
    if ((super.getType() == 486539313) && (this.OqE) && (this.OqD != null))
    {
      AppMethodBeat.o(43220);
      return true;
    }
    AppMethodBeat.o(43220);
    return false;
  }
  
  public final boolean gDe()
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
  
  public final boolean gDf()
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
  
  public final boolean gDg()
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
  
  public final boolean gDh()
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
  
  public final boolean gDi()
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
  
  public final boolean gDj()
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
  
  public final boolean gDk()
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
  
  public final boolean gDl()
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
  
  public final boolean gDm()
  {
    AppMethodBeat.i(225991);
    if ((super.getType() == 10000) || (super.getType() == 10002) || (super.getType() == 570425393) || (super.getType() == 64) || (super.getType() == 603979825) || (super.getType() == 889192497) || (super.getType() == 922746929))
    {
      AppMethodBeat.o(225991);
      return true;
    }
    AppMethodBeat.o(225991);
    return false;
  }
  
  public final boolean gDn()
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
  
  public final boolean gDo()
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
  
  public final boolean gDp()
  {
    AppMethodBeat.i(225992);
    if (super.getType() == 855638065)
    {
      AppMethodBeat.o(225992);
      return true;
    }
    AppMethodBeat.o(225992);
    return false;
  }
  
  public final boolean gDq()
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
  
  public final boolean gDr()
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
  
  public final boolean gDs()
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
  
  public final boolean gDt()
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
  
  public final boolean gDu()
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
  
  public final boolean gDv()
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
  
  public final boolean gDw()
  {
    AppMethodBeat.i(225993);
    if ((super.getType() == 889192497) || (super.getType() == 922746929))
    {
      AppMethodBeat.o(225993);
      return true;
    }
    AppMethodBeat.o(225993);
    return false;
  }
  
  public final boolean gDx()
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
  
  public final boolean gDy()
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
  
  public final boolean gDz()
  {
    AppMethodBeat.i(43246);
    if ((Xn()) && (!Util.isNullOrNil(this.field_transContent)))
    {
      AppMethodBeat.o(43246);
      return true;
    }
    AppMethodBeat.o(43246);
    return false;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(258520);
    int i = super.getType();
    AppMethodBeat.o(258520);
    return i;
  }
  
  public final boolean isOmittedFailResend()
  {
    return (this.fqJ & 0x20) > 0;
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
    if ((this.field_isSend == 1) && (gDA()))
    {
      if (this.field_status == 5)
      {
        Log.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()), this.field_talker, Util.getStack() });
        localObject = new tx();
        ((tx)localObject).ear.dCM = this;
        EventCenter.instance.publish((IEvent)localObject);
        AppMethodBeat.o(43248);
        return;
      }
      if (this.field_status == 2)
      {
        Log.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()) });
        localObject = new tz();
        ((tz)localObject).eat.dCM = this;
        EventCenter.instance.publish((IEvent)localObject);
        AppMethodBeat.o(43248);
      }
    }
    else if (this.field_isSend == 0)
    {
      localObject = new qs();
      ((qs)localObject).dXi.dCM = this;
      EventCenter.instance.publish((IEvent)localObject);
    }
    AppMethodBeat.o(43248);
  }
  
  public final void unsetOmittedFailResend()
  {
    AppMethodBeat.i(43252);
    if (isOmittedFailResend()) {
      nc(this.fqJ & 0xFFFFFFDF);
    }
    AppMethodBeat.o(43252);
  }
  
  public static final class a
  {
    public String BdC = "";
    public long Bge = 0L;
    public int IOs = 0;
    public String Kpf = "";
    public int OqJ = 0;
    public String OqK = "";
    public String OqL = "";
    public String OqM = "";
    public String OqN = "";
    public String OqO = "";
    public String OqP = "";
    public String OqQ = "";
    public String OqR = "";
    public String dkU = "";
    public String fMb = "";
    public int fuA;
    private String fuJ;
    private String fuK;
    public String fuN = "";
    private String fuO = "";
    public String kcp = "";
    public String kfQ = "";
    public String kfR = "";
    public String kfS = "";
    public String kfV = "";
    public String nickname = "";
    public int scene = 0;
    public String signature;
    private String source = "";
    
    public static a bkA(String paramString)
    {
      AppMethodBeat.i(43202);
      locala = new a();
      localObject = Util.nullAs(paramString, "").trim();
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("<"))
      {
        int i = ((String)localObject).indexOf(":");
        paramString = (String)localObject;
        if (i != -1) {
          paramString = ((String)localObject).substring(i + 1);
        }
      }
      localObject = XmlParser.parseXml(paramString, "msg", null);
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          if (((Map)localObject).get(".msg.$fromusername") != null) {
            continue;
          }
          locala.dkU = ((String)((Map)localObject).get(".msg.$username"));
          if (((Map)localObject).get(".msg.$fromnickname") != null) {
            continue;
          }
          locala.nickname = ((String)((Map)localObject).get(".msg.$nickname"));
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          continue;
          locala.nickname = ((String)((Map)localObject).get(".msg.$fromnickname"));
          continue;
          paramString = (String)((Map)localObject).get(".msg.$certflag");
          continue;
        }
        locala.fMb = ((String)((Map)localObject).get(".msg.$alias"));
        locala.kfR = ((String)((Map)localObject).get(".msg.$fullpy"));
        locala.kfQ = ((String)((Map)localObject).get(".msg.$shortpy"));
        locala.source = ((String)((Map)localObject).get(".msg.$source"));
        locala.OqJ = Util.getInt((String)((Map)localObject).get(".msg.$imagestatus"), 0);
        locala.scene = Util.getInt((String)((Map)localObject).get(".msg.$scene"), 0);
        locala.OqK = ((String)((Map)localObject).get(".msg.$mobileidentify"));
        locala.OqL = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
        if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
          locala.Bge = Util.getLong((String)((Map)localObject).get(".msg.$qqnum"), 0L);
        }
        locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
        if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
          locala.fuA = Util.getInt((String)((Map)localObject).get(".msg.$sex"), 0);
        }
        locala.fuK = ((String)((Map)localObject).get(".msg.$city"));
        locala.fuJ = ((String)((Map)localObject).get(".msg.$province"));
        locala.kfS = ((String)((Map)localObject).get(".msg.$qqnickname"));
        locala.kfV = ((String)((Map)localObject).get(".msg.$qqremark"));
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
          continue;
        }
        paramString = "0";
        locala.IOs = Util.getInt(paramString, 0);
        locala.fuN = Util.nullAsNil((String)((Map)localObject).get(".msg.$certinfo"));
        locala.BdC = Util.nullAsNil((String)((Map)localObject).get(".msg.$brandIconUrl"));
        locala.fuO = Util.nullAsNil((String)((Map)localObject).get(".msg.$regionCode"));
        locala.OqM = Util.nullAsNil((String)((Map)localObject).get(".msg.$bigheadimgurl"));
        locala.OqN = Util.nullAsNil((String)((Map)localObject).get(".msg.$smallheadimgurl"));
        locala.kcp = Util.nullAsNil((String)((Map)localObject).get(".msg.$googlecontact"));
        locala.Kpf = Util.nullAsNil((String)((Map)localObject).get(".msg.$antispamticket"));
        locala.OqO = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimappid"));
        locala.OqP = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimdesc"));
        locala.OqQ = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimdescicon"));
        locala.OqR = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimcustominfo"));
        if (as.bjp(locala.dkU)) {
          locala.Kpf = Util.nullAsNil((String)((Map)localObject).get(".msg.$ticket"));
        }
        Log.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.dkU, locala.Kpf, locala.OqM, locala.OqN });
        AppMethodBeat.o(43202);
        return locala;
        locala.dkU = ((String)((Map)localObject).get(".msg.$fromusername"));
      }
    }
    
    public final String gDY()
    {
      return this.dkU;
    }
    
    public final String gDZ()
    {
      AppMethodBeat.i(43204);
      if ((this.kfV != null) && (this.kfV.length() > 0))
      {
        str = this.kfV;
        AppMethodBeat.o(43204);
        return str;
      }
      if ((this.kfS != null) && (this.kfS.length() > 0))
      {
        str = this.kfS;
        AppMethodBeat.o(43204);
        return str;
      }
      String str = Long.toString(this.Bge);
      AppMethodBeat.o(43204);
      return str;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43205);
      Object localObject;
      if (!Util.isNullOrNil(this.fuO))
      {
        localObject = this.fuO.split("_");
        if (localObject.length > 0)
        {
          if (localObject.length <= 2) {
            break label71;
          }
          RegionCodeDecoder.gEm();
          this.fuK = RegionCodeDecoder.bs(localObject[0], localObject[1], localObject[2]);
        }
      }
      for (;;)
      {
        localObject = this.fuK;
        AppMethodBeat.o(43205);
        return localObject;
        label71:
        if (localObject.length == 2)
        {
          RegionCodeDecoder.gEm();
          this.fuK = RegionCodeDecoder.mW(localObject[0], localObject[1]);
        }
        else
        {
          this.fuK = "";
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
      if (!TextUtils.isEmpty(this.fMb))
      {
        str = this.fMb;
        AppMethodBeat.o(43203);
        return str;
      }
      Log.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = Util.nullAsNil(this.dkU);
      AppMethodBeat.o(43203);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43206);
      Object localObject;
      if (!Util.isNullOrNil(this.fuO))
      {
        localObject = this.fuO.split("_");
        if (localObject.length > 0)
        {
          if ((localObject.length <= 2) || (!RegionCodeDecoder.bkO(localObject[0]))) {
            break label77;
          }
          RegionCodeDecoder.gEm();
        }
      }
      for (this.fuJ = RegionCodeDecoder.mW(localObject[0], localObject[1]);; this.fuJ = RegionCodeDecoder.bkP(localObject[0]))
      {
        localObject = this.fuJ;
        AppMethodBeat.o(43206);
        return localObject;
        label77:
        RegionCodeDecoder.gEm();
      }
    }
  }
  
  public static final class b
  {
    public String JTr = "";
    public String OqS = "";
    public String OqT = null;
    public String OqU = null;
    public String OqV = null;
    public int dRt = 0;
    public String dkU = "";
    public String kHV = "";
    public String label = "";
    public String yFB = "";
    public double yFu = 0.0D;
    public double yFv = 0.0D;
    
    public static b bkB(String paramString)
    {
      AppMethodBeat.i(43208);
      b localb = new b();
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString != null)
      {
        localb.dkU = Util.nullAs((String)paramString.get(".msg.location.$fromusername"), "");
        localb.yFu = Util.safeParseDouble((String)paramString.get(".msg.location.$x"));
        localb.yFv = Util.safeParseDouble((String)paramString.get(".msg.location.$y"));
        localb.label = Util.nullAs((String)paramString.get(".msg.location.$label"), "");
        localb.OqS = Util.nullAs((String)paramString.get(".msg.location.$maptype"), "");
        localb.dRt = Util.safeParseInt((String)paramString.get(".msg.location.$scale"));
        localb.OqV = Util.nullAs((String)paramString.get(".msg.location.$localLocationen"), "");
        localb.OqT = Util.nullAs((String)paramString.get(".msg.location.$localLocationcn"), "");
        localb.OqU = Util.nullAs((String)paramString.get(".msg.location.$localLocationtw"), "");
        localb.kHV = Util.nullAs((String)paramString.get(".msg.location.$poiname"), "");
        localb.JTr = Util.nullAs((String)paramString.get(".msg.location.$infourl"), "");
        localb.yFB = Util.nullAs((String)paramString.get(".msg.location.$poiid"), "");
      }
      AppMethodBeat.o(43208);
      return localb;
    }
    
    public final boolean gEa()
    {
      AppMethodBeat.i(43209);
      if ((this.kHV != null) && (!this.kHV.equals("")) && (!this.kHV.equals("[位置]")))
      {
        AppMethodBeat.o(43209);
        return true;
      }
      AppMethodBeat.o(43209);
      return false;
    }
    
    public final boolean gEb()
    {
      AppMethodBeat.i(43210);
      if ((Math.abs(this.yFv) > 180.0D) || (Math.abs(this.yFu) > 90.0D))
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
      String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.yFu * 1000000.0D)), Integer.valueOf((int)(this.yFv * 1000000.0D)), Integer.valueOf(this.dRt) });
      AppMethodBeat.o(43207);
      return str;
    }
  }
  
  public static final class c
  {
    public String BqZ;
    public String OqW = "";
    public String content = "";
    public String jje = "";
    public String title = "";
    public boolean tmn = false;
    
    public static c bkC(String paramString)
    {
      AppMethodBeat.i(43211);
      c localc = new c();
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString != null) {}
      try
      {
        localc.title = ((String)paramString.get(".msg.pushmail.content.subject"));
        localc.content = ((String)paramString.get(".msg.pushmail.content.digest"));
        localc.jje = ((String)paramString.get(".msg.pushmail.content.sender"));
        localc.OqW = ((String)paramString.get(".msg.pushmail.waplink"));
        localc.tmn = Util.nullAsNil((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
        localc.BqZ = ((String)paramString.get(".msg.pushmail.mailid"));
        AppMethodBeat.o(43211);
        return localc;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        }
      }
    }
    
    public final String getSender()
    {
      return this.jje;
    }
    
    public final String getTitle()
    {
      return this.title;
    }
  }
  
  public static final class d
  {
    public long Bge = 0L;
    public int OqJ = 0;
    public String OqK = "";
    public String OqL = "";
    public String OqM = "";
    public String OqN = "";
    public int OqX = 0;
    public String OqY;
    public String OqZ;
    public int Ora;
    public String Orb;
    public String Orc;
    public String Ord;
    public String Ore;
    public String chatroomName = "";
    private String cityCode;
    public String content = "";
    private String countryCode;
    public int dKy;
    public String dkU = "";
    public String fMb = "";
    public int fuA;
    public String kcp;
    public String kfQ = "";
    public String kfR = "";
    public String kfS = "";
    private String kfV = "";
    public String nickname = "";
    private String provinceCode;
    public int scene = 0;
    public String signature;
    public String sourceNickName;
    public String sourceUserName;
    public String wZz;
    
    public static d bkD(String paramString)
    {
      AppMethodBeat.i(43212);
      d locald = new d();
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString != null) {}
      try
      {
        locald.dkU = ((String)paramString.get(".msg.$fromusername"));
        locald.fMb = ((String)paramString.get(".msg.$alias"));
        locald.nickname = ((String)paramString.get(".msg.$fromnickname"));
        locald.kfR = ((String)paramString.get(".msg.$fullpy"));
        locald.kfQ = ((String)paramString.get(".msg.$shortpy"));
        locald.content = ((String)paramString.get(".msg.$content"));
        locald.OqJ = Util.getInt((String)paramString.get(".msg.$imagestatus"), 0);
        locald.scene = Util.getInt((String)paramString.get(".msg.$scene"), 0);
        locald.OqK = ((String)paramString.get(".msg.$mhash"));
        locald.OqL = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          locald.Bge = Util.getLong((String)paramString.get(".msg.$qqnum"), 0L);
        }
        locald.kfS = ((String)paramString.get(".msg.$qqnickname"));
        locald.kfV = ((String)paramString.get(".msg.$qqremark"));
        locald.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          locald.fuA = Util.getInt((String)paramString.get(".msg.$sex"), 0);
        }
        locald.cityCode = ((String)paramString.get(".msg.$city"));
        locald.provinceCode = ((String)paramString.get(".msg.$province"));
        locald.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          locald.OqX = Util.getInt((String)paramString.get(".msg.$snsflag"), 0);
          locald.OqY = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        locald.wZz = ((String)paramString.get(".msg.$ticket"));
        Log.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { locald.wZz });
        locald.OqM = Util.nullAsNil((String)paramString.get(".msg.$bigheadimgurl"));
        locald.OqN = Util.nullAsNil((String)paramString.get(".msg.$smallheadimgurl"));
        locald.dKy = Util.getInt((String)paramString.get(".msg.$opcode"), 0);
        locald.OqZ = Util.nullAsNil((String)paramString.get(".msg.$encryptusername"));
        locald.kcp = Util.nullAsNil((String)paramString.get(".msg.$googlecontact"));
        Log.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { locald.dkU, locald.OqM, locald.OqN });
        locald.chatroomName = Util.nullAsNil((String)paramString.get(".msg.$chatroomusername"));
        locald.sourceUserName = ((String)paramString.get(".msg.$sourceusername"));
        locald.sourceNickName = ((String)paramString.get(".msg.$sourcenickname"));
        locald.Ord = ((String)paramString.get(".msg.$sharecardusername"));
        locald.Ore = ((String)paramString.get(".msg.$sharecardnickname"));
        locald.Ora = Util.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (locald.Ora == 1)
        {
          locald.Orb = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          locald.Orc = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.MsgInfo", paramString, "", new Object[0]);
        }
      }
      AppMethodBeat.o(43212);
      return locald;
    }
    
    public final String ajA()
    {
      return this.kfR;
    }
    
    public final int ajE()
    {
      return this.fuA;
    }
    
    public final String ajx()
    {
      return this.fMb;
    }
    
    public final String ajz()
    {
      return this.kfQ;
    }
    
    public final String gDY()
    {
      return this.dkU;
    }
    
    public final String gEc()
    {
      return this.wZz;
    }
    
    public final String gEd()
    {
      return this.OqZ;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43214);
      if ((!Util.isNullOrNil(this.countryCode)) && (!Util.isNullOrNil(this.provinceCode)))
      {
        if (Util.isNullOrNil(this.cityCode))
        {
          RegionCodeDecoder.gEm();
          str = RegionCodeDecoder.mW(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43214);
          return str;
        }
        RegionCodeDecoder.gEm();
        str = RegionCodeDecoder.bs(this.countryCode, this.provinceCode, this.cityCode);
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
      Log.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = this.dkU;
      AppMethodBeat.o(43213);
      return str;
    }
    
    public final String getNickname()
    {
      return this.nickname;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43215);
      if (!Util.isNullOrNil(this.countryCode))
      {
        if ((!Util.isNullOrNil(this.provinceCode)) && (!Util.isNullOrNil(this.cityCode)) && (RegionCodeDecoder.bkO(this.countryCode)))
        {
          RegionCodeDecoder.gEm();
          str = RegionCodeDecoder.mW(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43215);
          return str;
        }
        RegionCodeDecoder.gEm();
        str = RegionCodeDecoder.bkP(this.countryCode);
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
    
    public final String getSignature()
    {
      return this.signature;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ca
 * JD-Core Version:    0.7.0.1
 */