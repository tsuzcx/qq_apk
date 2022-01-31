package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.u;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;
import junit.framework.Assert;

public final class bi
  extends u
{
  public static String yOb = "voip_content_voice";
  public static String yOc = "voip_content_video";
  public boolean yOd;
  private String yOe;
  
  public bi()
  {
    this.yOd = false;
  }
  
  public bi(String paramString)
  {
    AppMethodBeat.i(60155);
    this.yOd = false;
    super.kj(paramString);
    AppMethodBeat.o(60155);
  }
  
  private static boolean Cc()
  {
    AppMethodBeat.i(60195);
    String str = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("TranslateMsgOff");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(60195);
      return true;
    }
    if (bo.apV(str) != 0)
    {
      ab.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
      AppMethodBeat.o(60195);
      return false;
    }
    AppMethodBeat.o(60195);
    return true;
  }
  
  public static boolean aU(Map<String, String> paramMap)
  {
    AppMethodBeat.i(60200);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication"))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(60200);
      return bool;
    }
  }
  
  public static boolean aV(Map<String, String> paramMap)
  {
    AppMethodBeat.i(60201);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval"))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(60201);
      return bool;
    }
  }
  
  public static bi as(bi parambi)
  {
    AppMethodBeat.i(60182);
    if (parambi == null)
    {
      ab.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
      AppMethodBeat.o(60182);
      return null;
    }
    bi localbi = new bi();
    localbi.setMsgId(parambi.field_msgId);
    localbi.fP(parambi.field_msgSvrId);
    localbi.setType(parambi.getType());
    localbi.setStatus(parambi.field_status);
    localbi.hL(parambi.field_isSend);
    localbi.field_isShowTimer = parambi.field_isShowTimer;
    localbi.dGF = true;
    localbi.fQ(parambi.field_createTime);
    localbi.kj(parambi.field_talker);
    localbi.setContent(parambi.field_content);
    localbi.kk(parambi.field_imgPath);
    localbi.kl(parambi.field_reserved);
    localbi.H(parambi.field_lvbuffer);
    localbi.km(parambi.field_transContent);
    localbi.ko(parambi.dGR);
    localbi.hr(parambi.dnr);
    localbi.jl(parambi.dns);
    AppMethodBeat.o(60182);
    return localbi;
  }
  
  private boolean dyb()
  {
    AppMethodBeat.i(60184);
    if ((!isText()) && (!bCp()) && (!dxR()))
    {
      AppMethodBeat.o(60184);
      return true;
    }
    AppMethodBeat.o(60184);
    return false;
  }
  
  public static void op(long paramLong)
  {
    AppMethodBeat.i(60203);
    if ((100000000L > paramLong) && (-10L < paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("msgId not in the reasonable scope", bool);
      AppMethodBeat.o(60203);
      return;
    }
  }
  
  public final void Nx(int paramInt)
  {
    AppMethodBeat.i(60194);
    switch (paramInt)
    {
    default: 
      ab.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      AppMethodBeat.o(60194);
      return;
    }
    hr(this.dnr | paramInt);
    AppMethodBeat.o(60194);
  }
  
  public final boolean asi(String paramString)
  {
    AppMethodBeat.i(60198);
    if ((!bo.isNullOrNil(this.dns)) && (!bo.isNullOrNil(paramString)))
    {
      Object localObject = br.F(this.dns, "msgsource");
      if (localObject == null)
      {
        AppMethodBeat.o(60198);
        return false;
      }
      localObject = (String)((Map)localObject).get(".msgsource.atuserlist");
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].trim().equals(paramString))
          {
            AppMethodBeat.o(60198);
            return true;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(60198);
    return false;
  }
  
  public final boolean bCn()
  {
    AppMethodBeat.i(60156);
    if ((getType() & 0xFFFF) == 49)
    {
      AppMethodBeat.o(60156);
      return true;
    }
    AppMethodBeat.o(60156);
    return false;
  }
  
  public final boolean bCp()
  {
    AppMethodBeat.i(60168);
    if (getType() == 48)
    {
      AppMethodBeat.o(60168);
      return true;
    }
    AppMethodBeat.o(60168);
    return false;
  }
  
  public final boolean byj()
  {
    AppMethodBeat.i(60171);
    if (getType() == 43)
    {
      AppMethodBeat.o(60171);
      return true;
    }
    AppMethodBeat.o(60171);
    return false;
  }
  
  public final boolean byk()
  {
    AppMethodBeat.i(60172);
    if (getType() == 62)
    {
      AppMethodBeat.o(60172);
      return true;
    }
    AppMethodBeat.o(60172);
    return false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(60202);
    super.convertFrom(paramCursor);
    paramCursor = this.field_content;
    if ((paramCursor != null) && (paramCursor.length() > 2097152))
    {
      final long l = this.field_msgId;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("Very big message: \nmsgId = ").append(l).append('\n').append("msgSvrId = ").append(this.field_msgSvrId).append('\n').append("type = ").append(getType()).append('\n').append("createTime = ").append(this.field_createTime).append('\n').append("talker = ").append(this.field_talker).append('\n').append("flag = ").append(this.field_flag).append('\n').append("content.length() = ").append(paramCursor.length()).append('\n').append("content = ").append(paramCursor.substring(0, 256));
      ab.e("MicroMsg.MsgInfo", localStringBuilder.toString());
      setType(1);
      setContent("");
      paramCursor = as(this);
      g.RO().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(60140);
          ((j)g.E(j.class)).bPQ().a(l, this.yOf);
          AppMethodBeat.o(60140);
        }
      });
    }
    op(this.field_msgId);
    AppMethodBeat.o(60202);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(60204);
    op(this.field_msgId);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(60204);
    return localContentValues;
  }
  
  public final boolean dvV()
  {
    AppMethodBeat.i(60157);
    if (getType() == 285212721)
    {
      AppMethodBeat.o(60157);
      return true;
    }
    AppMethodBeat.o(60157);
    return false;
  }
  
  public final boolean dvW()
  {
    AppMethodBeat.i(60158);
    if (getType() == 34)
    {
      AppMethodBeat.o(60158);
      return true;
    }
    AppMethodBeat.o(60158);
    return false;
  }
  
  public final boolean dvX()
  {
    AppMethodBeat.i(60166);
    switch (getType())
    {
    default: 
      AppMethodBeat.o(60166);
      return false;
    }
    AppMethodBeat.o(60166);
    return true;
  }
  
  public final boolean dxK()
  {
    AppMethodBeat.i(60159);
    if (getType() == 436207665)
    {
      AppMethodBeat.o(60159);
      return true;
    }
    AppMethodBeat.o(60159);
    return false;
  }
  
  public final boolean dxL()
  {
    AppMethodBeat.i(60160);
    if (getType() == 469762097)
    {
      AppMethodBeat.o(60160);
      return true;
    }
    AppMethodBeat.o(60160);
    return false;
  }
  
  public final boolean dxM()
  {
    AppMethodBeat.i(60161);
    if (getType() == 301989937)
    {
      AppMethodBeat.o(60161);
      return true;
    }
    AppMethodBeat.o(60161);
    return false;
  }
  
  public final boolean dxN()
  {
    AppMethodBeat.i(60162);
    if ((getType() == 50) || (getType() == 53))
    {
      AppMethodBeat.o(60162);
      return true;
    }
    AppMethodBeat.o(60162);
    return false;
  }
  
  public final boolean dxO()
  {
    AppMethodBeat.i(60163);
    if (getType() == 52)
    {
      AppMethodBeat.o(60163);
      return true;
    }
    AppMethodBeat.o(60163);
    return false;
  }
  
  public final boolean dxP()
  {
    AppMethodBeat.i(60164);
    if (getType() == 318767153)
    {
      AppMethodBeat.o(60164);
      return true;
    }
    AppMethodBeat.o(60164);
    return false;
  }
  
  public final boolean dxQ()
  {
    AppMethodBeat.i(60165);
    if (getType() == 10002)
    {
      AppMethodBeat.o(60165);
      return true;
    }
    AppMethodBeat.o(60165);
    return false;
  }
  
  public final boolean dxR()
  {
    AppMethodBeat.i(60167);
    if ((getType() == 42) || (getType() == 66))
    {
      AppMethodBeat.o(60167);
      return true;
    }
    AppMethodBeat.o(60167);
    return false;
  }
  
  public final boolean dxS()
  {
    AppMethodBeat.i(60173);
    if (getType() == 47)
    {
      AppMethodBeat.o(60173);
      return true;
    }
    AppMethodBeat.o(60173);
    return false;
  }
  
  public final boolean dxT()
  {
    AppMethodBeat.i(60174);
    if (getType() == 1048625)
    {
      AppMethodBeat.o(60174);
      return true;
    }
    AppMethodBeat.o(60174);
    return false;
  }
  
  public final boolean dxU()
  {
    AppMethodBeat.i(60175);
    if (getType() == 16777265)
    {
      AppMethodBeat.o(60175);
      return true;
    }
    AppMethodBeat.o(60175);
    return false;
  }
  
  public final boolean dxV()
  {
    AppMethodBeat.i(60176);
    if (getType() == 268435505)
    {
      AppMethodBeat.o(60176);
      return true;
    }
    AppMethodBeat.o(60176);
    return false;
  }
  
  public final boolean dxW()
  {
    AppMethodBeat.i(60177);
    if (getType() == -1879048191)
    {
      AppMethodBeat.o(60177);
      return true;
    }
    AppMethodBeat.o(60177);
    return false;
  }
  
  public final boolean dxX()
  {
    AppMethodBeat.i(60178);
    if (getType() == -1879048190)
    {
      AppMethodBeat.o(60178);
      return true;
    }
    AppMethodBeat.o(60178);
    return false;
  }
  
  public final boolean dxY()
  {
    AppMethodBeat.i(60179);
    if (getType() == -1879048189)
    {
      AppMethodBeat.o(60179);
      return true;
    }
    AppMethodBeat.o(60179);
    return false;
  }
  
  public final boolean dxZ()
  {
    AppMethodBeat.i(60180);
    switch (getType())
    {
    case 56: 
    default: 
      AppMethodBeat.o(60180);
      return false;
    }
    AppMethodBeat.o(60180);
    return true;
  }
  
  public final boolean dya()
  {
    AppMethodBeat.i(60181);
    if ((Cc()) && (!bo.isNullOrNil(this.field_transContent)))
    {
      AppMethodBeat.o(60181);
      return true;
    }
    AppMethodBeat.o(60181);
    return false;
  }
  
  public final boolean dyc()
  {
    return (this.dGU & 0x1) > 0;
  }
  
  public final void dyd()
  {
    AppMethodBeat.i(60185);
    hY(this.dGU | 0x1);
    AppMethodBeat.o(60185);
  }
  
  public final void dye()
  {
    AppMethodBeat.i(60186);
    if (dyf()) {
      hr(this.dnr & 0xFFFFFFDF);
    }
    AppMethodBeat.o(60186);
  }
  
  public final boolean dyf()
  {
    return (this.dnr & 0x20) > 0;
  }
  
  public final void dyg()
  {
    AppMethodBeat.i(60187);
    hr(this.dnr | 0x8);
    AppMethodBeat.o(60187);
  }
  
  public final boolean dyh()
  {
    AppMethodBeat.i(60188);
    if ((dya()) && ((this.dnr & 0x10) > 0))
    {
      AppMethodBeat.o(60188);
      return true;
    }
    AppMethodBeat.o(60188);
    return false;
  }
  
  public final void dyi()
  {
    AppMethodBeat.i(60189);
    if (!dya())
    {
      AppMethodBeat.o(60189);
      return;
    }
    hr(this.dnr | 0x10);
    AppMethodBeat.o(60189);
  }
  
  public final void dyj()
  {
    AppMethodBeat.i(60190);
    if (!dya())
    {
      AppMethodBeat.o(60190);
      return;
    }
    hr(this.dnr & 0xFFFFFFEF);
    AppMethodBeat.o(60190);
  }
  
  public final boolean dyk()
  {
    AppMethodBeat.i(60191);
    if ((dya()) && ((this.dnr & 0x400) > 0))
    {
      AppMethodBeat.o(60191);
      return true;
    }
    AppMethodBeat.o(60191);
    return false;
  }
  
  public final void dyl()
  {
    AppMethodBeat.i(60192);
    hr(this.dnr | 0x80);
    AppMethodBeat.o(60192);
  }
  
  public final void dym()
  {
    AppMethodBeat.i(60193);
    hr(this.dnr & 0xFFFFFF7F);
    AppMethodBeat.o(60193);
  }
  
  public final boolean dyn()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ((this.dnr & 0x80) == 0)
    {
      bool1 = bool2;
      if ((this.dnr & 0x300) == 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final void dyo()
  {
    AppMethodBeat.i(60196);
    hr(this.dnr & 0xFFFFFFBF);
    AppMethodBeat.o(60196);
  }
  
  public final void dyp()
  {
    AppMethodBeat.i(60197);
    hr(this.dnr | 0x40);
    AppMethodBeat.o(60197);
  }
  
  public final boolean dyq()
  {
    AppMethodBeat.i(60199);
    if ((!bo.isNullOrNil(this.dns)) && ((this.dns.contains("announcement@all")) || (this.dns.contains("notify@all")))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(60199);
      return bool;
    }
  }
  
  public final String dyr()
  {
    AppMethodBeat.i(60205);
    if (!dxQ())
    {
      AppMethodBeat.o(60205);
      return "";
    }
    if (this.yOe == null) {
      dys();
    }
    String str = this.yOe;
    AppMethodBeat.o(60205);
    return str;
  }
  
  public final com.tencent.mm.ay.a dys()
  {
    AppMethodBeat.i(60206);
    ab.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    com.tencent.mm.ay.a locala = a.a.b(br.F(this.field_content, "sysmsg"), this);
    if (locala != null)
    {
      ab.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { locala });
      locala.aiH();
      this.yOe = locala.TEXT;
    }
    for (;;)
    {
      AppMethodBeat.o(60206);
      return locala;
      ab.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(60207);
    int i = super.getType();
    if (i == 486539313)
    {
      AppMethodBeat.o(60207);
      return 285212721;
    }
    AppMethodBeat.o(60207);
    return i;
  }
  
  public final boolean isSystem()
  {
    AppMethodBeat.i(60170);
    if (getType() == 10000)
    {
      AppMethodBeat.o(60170);
      return true;
    }
    AppMethodBeat.o(60170);
    return false;
  }
  
  public final boolean isText()
  {
    AppMethodBeat.i(60169);
    switch (getType())
    {
    default: 
      AppMethodBeat.o(60169);
      return false;
    }
    AppMethodBeat.o(60169);
    return true;
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(60183);
    super.setStatus(paramInt);
    Object localObject;
    if ((this.field_isSend == 1) && (dyb()))
    {
      if (this.field_status == 5)
      {
        ab.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(getType()), this.field_talker, bo.dtY() });
        localObject = new qk();
        ((qk)localObject).cGZ.cmQ = this;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
        AppMethodBeat.o(60183);
        return;
      }
      if (this.field_status == 2)
      {
        ab.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(getType()) });
        localObject = new qm();
        ((qm)localObject).cHb.cmQ = this;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
        AppMethodBeat.o(60183);
      }
    }
    else if (this.field_isSend == 0)
    {
      localObject = new nr();
      ((nr)localObject).cEj.cmQ = this;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    }
    AppMethodBeat.o(60183);
  }
  
  public static final class a
  {
    private String city;
    public String dCJ = "";
    public int dqC;
    public String dqP = "";
    private String dqQ = "";
    public String gvd = "";
    public String gyH = "";
    public String gyI = "";
    public String gyJ = "";
    public String gyM = "";
    public String nickname = "";
    public long pAI = 0L;
    private String province;
    public String pyu = "";
    public int scene = 0;
    public String signature;
    private String source = "";
    public String tac = "";
    public int uOT = 0;
    public String waH = "";
    public int yOh = 0;
    public String yOi = "";
    public String yOj = "";
    public String yOk = "";
    public String yOl = "";
    public String yOm = "";
    public String yOn = "";
    public String yOo = "";
    public String yOp = "";
    
    public static a asj(String paramString)
    {
      AppMethodBeat.i(60141);
      locala = new a();
      localObject = bo.bf(paramString, "").trim();
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("<"))
      {
        int i = ((String)localObject).indexOf(":");
        paramString = (String)localObject;
        if (i != -1) {
          paramString = ((String)localObject).substring(i + 1);
        }
      }
      localObject = br.F(paramString, "msg");
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          if (((Map)localObject).get(".msg.$fromusername") != null) {
            continue;
          }
          locala.tac = ((String)((Map)localObject).get(".msg.$username"));
          if (((Map)localObject).get(".msg.$fromnickname") != null) {
            continue;
          }
          locala.nickname = ((String)((Map)localObject).get(".msg.$nickname"));
        }
        catch (Exception paramString)
        {
          ab.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bo.l(paramString) });
          continue;
          locala.nickname = ((String)((Map)localObject).get(".msg.$fromnickname"));
          continue;
          paramString = (String)((Map)localObject).get(".msg.$certflag");
          continue;
        }
        locala.dCJ = ((String)((Map)localObject).get(".msg.$alias"));
        locala.gyI = ((String)((Map)localObject).get(".msg.$fullpy"));
        locala.gyH = ((String)((Map)localObject).get(".msg.$shortpy"));
        locala.source = ((String)((Map)localObject).get(".msg.$source"));
        locala.yOh = bo.getInt((String)((Map)localObject).get(".msg.$imagestatus"), 0);
        locala.scene = bo.getInt((String)((Map)localObject).get(".msg.$scene"), 0);
        locala.yOi = ((String)((Map)localObject).get(".msg.$mobileidentify"));
        locala.yOj = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
        if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
          locala.pAI = bo.getLong((String)((Map)localObject).get(".msg.$qqnum"), 0L);
        }
        locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
        if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
          locala.dqC = bo.getInt((String)((Map)localObject).get(".msg.$sex"), 0);
        }
        locala.city = ((String)((Map)localObject).get(".msg.$city"));
        locala.province = ((String)((Map)localObject).get(".msg.$province"));
        locala.gyJ = ((String)((Map)localObject).get(".msg.$qqnickname"));
        locala.gyM = ((String)((Map)localObject).get(".msg.$qqremark"));
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
          continue;
        }
        paramString = "0";
        locala.uOT = bo.getInt(paramString, 0);
        locala.dqP = bo.nullAsNil((String)((Map)localObject).get(".msg.$certinfo"));
        locala.pyu = bo.nullAsNil((String)((Map)localObject).get(".msg.$brandIconUrl"));
        locala.dqQ = bo.nullAsNil((String)((Map)localObject).get(".msg.$regionCode"));
        locala.yOk = bo.nullAsNil((String)((Map)localObject).get(".msg.$bigheadimgurl"));
        locala.yOl = bo.nullAsNil((String)((Map)localObject).get(".msg.$smallheadimgurl"));
        locala.gvd = bo.nullAsNil((String)((Map)localObject).get(".msg.$googlecontact"));
        locala.waH = bo.nullAsNil((String)((Map)localObject).get(".msg.$antispamticket"));
        locala.yOm = bo.nullAsNil((String)((Map)localObject).get(".msg.$openimappid"));
        locala.yOn = bo.nullAsNil((String)((Map)localObject).get(".msg.$openimdesc"));
        locala.yOo = bo.nullAsNil((String)((Map)localObject).get(".msg.$openimdescicon"));
        locala.yOp = bo.nullAsNil((String)((Map)localObject).get(".msg.$openimcustominfo"));
        if (ad.arf(locala.tac)) {
          locala.waH = bo.nullAsNil((String)((Map)localObject).get(".msg.$ticket"));
        }
        ab.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.tac, locala.waH, locala.yOk, locala.yOl });
        AppMethodBeat.o(60141);
        return locala;
        locala.tac = ((String)((Map)localObject).get(".msg.$fromusername"));
      }
    }
    
    public final String dyt()
    {
      return this.tac;
    }
    
    public final String dyu()
    {
      AppMethodBeat.i(60143);
      if ((this.gyM != null) && (this.gyM.length() > 0))
      {
        str = this.gyM;
        AppMethodBeat.o(60143);
        return str;
      }
      if ((this.gyJ != null) && (this.gyJ.length() > 0))
      {
        str = this.gyJ;
        AppMethodBeat.o(60143);
        return str;
      }
      String str = Long.toString(this.pAI);
      AppMethodBeat.o(60143);
      return str;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(60144);
      Object localObject;
      if (!bo.isNullOrNil(this.dqQ))
      {
        localObject = this.dqQ.split("_");
        if (localObject.length > 0)
        {
          if (localObject.length <= 2) {
            break label71;
          }
          RegionCodeDecoder.dyE();
          this.city = RegionCodeDecoder.aG(localObject[0], localObject[1], localObject[2]);
        }
      }
      for (;;)
      {
        localObject = this.city;
        AppMethodBeat.o(60144);
        return localObject;
        label71:
        if (localObject.length == 2)
        {
          RegionCodeDecoder.dyE();
          this.city = RegionCodeDecoder.iq(localObject[0], localObject[1]);
        }
        else
        {
          this.city = "";
        }
      }
    }
    
    public final String getDisplayName()
    {
      AppMethodBeat.i(60142);
      if (!TextUtils.isEmpty(this.nickname))
      {
        str = this.nickname;
        AppMethodBeat.o(60142);
        return str;
      }
      if (!TextUtils.isEmpty(this.dCJ))
      {
        str = this.dCJ;
        AppMethodBeat.o(60142);
        return str;
      }
      ab.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = bo.nullAsNil(this.tac);
      AppMethodBeat.o(60142);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(60145);
      Object localObject;
      if (!bo.isNullOrNil(this.dqQ))
      {
        localObject = this.dqQ.split("_");
        if (localObject.length > 0)
        {
          if ((localObject.length <= 2) || (!RegionCodeDecoder.asx(localObject[0]))) {
            break label77;
          }
          RegionCodeDecoder.dyE();
        }
      }
      for (this.province = RegionCodeDecoder.iq(localObject[0], localObject[1]);; this.province = RegionCodeDecoder.asy(localObject[0]))
      {
        localObject = this.province;
        AppMethodBeat.o(60145);
        return localObject;
        label77:
        RegionCodeDecoder.dyE();
      }
    }
  }
  
  public static final class b
  {
    public int cyX = 0;
    public String eSM = "";
    public String label = "";
    public double nZV = 0.0D;
    public double nZW = 0.0D;
    public String oac = "";
    public String tac = "";
    public String vJU = "";
    public String yOq = "";
    public String yOr = null;
    public String yOs = null;
    public String yOt = null;
    
    public static b ask(String paramString)
    {
      AppMethodBeat.i(60147);
      b localb = new b();
      paramString = br.F(paramString, "msg");
      if (paramString != null)
      {
        localb.tac = bo.bf((String)paramString.get(".msg.location.$fromusername"), "");
        localb.nZV = bo.apX((String)paramString.get(".msg.location.$x"));
        localb.nZW = bo.apX((String)paramString.get(".msg.location.$y"));
        localb.label = bo.bf((String)paramString.get(".msg.location.$label"), "");
        localb.yOq = bo.bf((String)paramString.get(".msg.location.$maptype"), "");
        localb.cyX = bo.apV((String)paramString.get(".msg.location.$scale"));
        localb.yOt = bo.bf((String)paramString.get(".msg.location.$localLocationen"), "");
        localb.yOr = bo.bf((String)paramString.get(".msg.location.$localLocationcn"), "");
        localb.yOs = bo.bf((String)paramString.get(".msg.location.$localLocationtw"), "");
        localb.eSM = bo.bf((String)paramString.get(".msg.location.$poiname"), "");
        localb.vJU = bo.bf((String)paramString.get(".msg.location.$infourl"), "");
        localb.oac = bo.bf((String)paramString.get(".msg.location.$poiid"), "");
      }
      AppMethodBeat.o(60147);
      return localb;
    }
    
    public final boolean dyv()
    {
      AppMethodBeat.i(60148);
      if ((this.eSM != null) && (!this.eSM.equals("")) && (!this.eSM.equals("[位置]")))
      {
        AppMethodBeat.o(60148);
        return true;
      }
      AppMethodBeat.o(60148);
      return false;
    }
    
    public final boolean dyw()
    {
      AppMethodBeat.i(60149);
      if ((Math.abs(this.nZW) > 180.0D) || (Math.abs(this.nZV) > 90.0D))
      {
        AppMethodBeat.o(60149);
        return false;
      }
      AppMethodBeat.o(60149);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60146);
      String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.nZV * 1000000.0D)), Integer.valueOf((int)(this.nZW * 1000000.0D)), Integer.valueOf(this.cyX) });
      AppMethodBeat.o(60146);
      return str;
    }
  }
  
  public static final class c
  {
    public String content = "";
    public String fOJ = "";
    public boolean mDP = false;
    public String pIJ;
    public String title = "";
    public String yOu = "";
    
    public static c asl(String paramString)
    {
      AppMethodBeat.i(60150);
      c localc = new c();
      paramString = br.F(paramString, "msg");
      if (paramString != null) {}
      try
      {
        localc.title = ((String)paramString.get(".msg.pushmail.content.subject"));
        localc.content = ((String)paramString.get(".msg.pushmail.content.digest"));
        localc.fOJ = ((String)paramString.get(".msg.pushmail.content.sender"));
        localc.yOu = ((String)paramString.get(".msg.pushmail.waplink"));
        localc.mDP = bo.nullAsNil((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
        localc.pIJ = ((String)paramString.get(".msg.pushmail.mailid"));
        AppMethodBeat.o(60150);
        return localc;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ab.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bo.l(paramString) });
        }
      }
    }
    
    public final String getSender()
    {
      return this.fOJ;
    }
    
    public final String getTitle()
    {
      return this.title;
    }
  }
  
  public static final class d
  {
    public String chatroomName = "";
    public String content = "";
    private String countryCode;
    public int cut;
    public String dCJ = "";
    public int dqC;
    private String fnB;
    private String fnC;
    public String gvd;
    public String gyH = "";
    public String gyI = "";
    public String gyJ = "";
    private String gyM = "";
    public String inF;
    public String mVw;
    public String nickname = "";
    public long pAI = 0L;
    public int scene = 0;
    public String signature;
    public String tac = "";
    public String vSR;
    public String yOA;
    public int yOh = 0;
    public String yOi = "";
    public String yOj = "";
    public String yOk = "";
    public String yOl = "";
    public int yOv = 0;
    public String yOw;
    public String yOx;
    public int yOy;
    public String yOz;
    
    public static d asm(String paramString)
    {
      AppMethodBeat.i(60151);
      d locald = new d();
      paramString = br.F(paramString, "msg");
      if (paramString != null) {}
      try
      {
        locald.tac = ((String)paramString.get(".msg.$fromusername"));
        locald.dCJ = ((String)paramString.get(".msg.$alias"));
        locald.nickname = ((String)paramString.get(".msg.$fromnickname"));
        locald.gyI = ((String)paramString.get(".msg.$fullpy"));
        locald.gyH = ((String)paramString.get(".msg.$shortpy"));
        locald.content = ((String)paramString.get(".msg.$content"));
        locald.yOh = bo.getInt((String)paramString.get(".msg.$imagestatus"), 0);
        locald.scene = bo.getInt((String)paramString.get(".msg.$scene"), 0);
        locald.yOi = ((String)paramString.get(".msg.$mhash"));
        locald.yOj = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          locald.pAI = bo.getLong((String)paramString.get(".msg.$qqnum"), 0L);
        }
        locald.gyJ = ((String)paramString.get(".msg.$qqnickname"));
        locald.gyM = ((String)paramString.get(".msg.$qqremark"));
        locald.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          locald.dqC = bo.getInt((String)paramString.get(".msg.$sex"), 0);
        }
        locald.fnB = ((String)paramString.get(".msg.$city"));
        locald.fnC = ((String)paramString.get(".msg.$province"));
        locald.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          locald.yOv = bo.getInt((String)paramString.get(".msg.$snsflag"), 0);
          locald.yOw = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        locald.mVw = ((String)paramString.get(".msg.$ticket"));
        ab.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { locald.mVw });
        locald.yOk = bo.nullAsNil((String)paramString.get(".msg.$bigheadimgurl"));
        locald.yOl = bo.nullAsNil((String)paramString.get(".msg.$smallheadimgurl"));
        locald.cut = bo.getInt((String)paramString.get(".msg.$opcode"), 0);
        locald.yOx = bo.nullAsNil((String)paramString.get(".msg.$encryptusername"));
        locald.gvd = bo.nullAsNil((String)paramString.get(".msg.$googlecontact"));
        ab.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { locald.tac, locald.yOk, locald.yOl });
        locald.chatroomName = bo.nullAsNil((String)paramString.get(".msg.$chatroomusername"));
        locald.inF = ((String)paramString.get(".msg.$sourceusername"));
        locald.vSR = ((String)paramString.get(".msg.$sourcenickname"));
        locald.yOy = bo.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (locald.yOy == 1)
        {
          locald.yOz = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          locald.yOA = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.MsgInfo", paramString, "", new Object[0]);
        }
      }
      AppMethodBeat.o(60151);
      return locald;
    }
    
    public final String Hq()
    {
      return this.dCJ;
    }
    
    public final String Hs()
    {
      return this.nickname;
    }
    
    public final String Ht()
    {
      return this.gyH;
    }
    
    public final String Hu()
    {
      return this.gyI;
    }
    
    public final String dyA()
    {
      return this.yOx;
    }
    
    public final String dyt()
    {
      return this.tac;
    }
    
    public final String dyx()
    {
      return this.mVw;
    }
    
    public final int dyy()
    {
      return this.dqC;
    }
    
    public final String dyz()
    {
      return this.signature;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(60153);
      if ((!bo.isNullOrNil(this.countryCode)) && (!bo.isNullOrNil(this.fnC)))
      {
        if (bo.isNullOrNil(this.fnB))
        {
          RegionCodeDecoder.dyE();
          str = RegionCodeDecoder.iq(this.countryCode, this.fnC);
          AppMethodBeat.o(60153);
          return str;
        }
        RegionCodeDecoder.dyE();
        str = RegionCodeDecoder.aG(this.countryCode, this.fnC, this.fnB);
        AppMethodBeat.o(60153);
        return str;
      }
      String str = this.fnB;
      AppMethodBeat.o(60153);
      return str;
    }
    
    public final String getDisplayName()
    {
      AppMethodBeat.i(60152);
      if ((this.nickname != null) && (this.nickname.length() > 0))
      {
        str = this.nickname;
        AppMethodBeat.o(60152);
        return str;
      }
      ab.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = this.tac;
      AppMethodBeat.o(60152);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(60154);
      if (!bo.isNullOrNil(this.countryCode))
      {
        if ((!bo.isNullOrNil(this.fnC)) && (!bo.isNullOrNil(this.fnB)) && (RegionCodeDecoder.asx(this.countryCode)))
        {
          RegionCodeDecoder.dyE();
          str = RegionCodeDecoder.iq(this.countryCode, this.fnC);
          AppMethodBeat.o(60154);
          return str;
        }
        RegionCodeDecoder.dyE();
        str = RegionCodeDecoder.asy(this.countryCode);
        AppMethodBeat.o(60154);
        return str;
      }
      String str = this.fnC;
      AppMethodBeat.o(60154);
      return str;
    }
    
    public final int getScene()
    {
      return this.scene;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bi
 * JD-Core Version:    0.7.0.1
 */