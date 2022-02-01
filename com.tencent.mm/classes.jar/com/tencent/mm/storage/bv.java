package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.aa;
import com.tencent.mm.az.a.a;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;
import junit.framework.Assert;

public final class bv
  extends aa
{
  public static String JgK = "voip_content_voice";
  public static String JgL = "voip_content_video";
  public jb JgM;
  public boolean JgN;
  public boolean JgO;
  private String JgP;
  public boolean Zn;
  public String sessionId;
  
  public bv()
  {
    this.JgM = null;
    this.JgN = false;
    this.JgO = false;
    this.Zn = false;
  }
  
  public bv(String paramString)
  {
    AppMethodBeat.i(43216);
    this.JgM = null;
    this.JgN = false;
    this.JgO = false;
    this.Zn = false;
    super.ui(paramString);
    AppMethodBeat.o(43216);
  }
  
  public static void Ef(long paramLong)
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
  
  private static boolean Nb()
  {
    AppMethodBeat.i(43261);
    String str = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("TranslateMsgOff");
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(43261);
      return true;
    }
    if (bu.aSB(str) != 0)
    {
      ae.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
      AppMethodBeat.o(43261);
      return false;
    }
    AppMethodBeat.o(43261);
    return true;
  }
  
  public static bv aM(bv parambv)
  {
    AppMethodBeat.i(43247);
    if (parambv == null)
    {
      ae.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
      AppMethodBeat.o(43247);
      return null;
    }
    bv localbv = new bv();
    localbv.setMsgId(parambv.field_msgId);
    localbv.qM(parambv.field_msgSvrId);
    localbv.setType(parambv.getType());
    localbv.setStatus(parambv.field_status);
    localbv.kt(parambv.field_isSend);
    localbv.field_isShowTimer = parambv.field_isShowTimer;
    localbv.eNg = true;
    localbv.qN(parambv.field_createTime);
    localbv.ui(parambv.field_talker);
    localbv.setContent(parambv.field_content);
    localbv.uj(parambv.field_imgPath);
    localbv.uk(parambv.field_reserved);
    localbv.M(parambv.field_lvbuffer);
    localbv.ul(parambv.field_transContent);
    localbv.uq(parambv.fmn);
    localbv.ka(parambv.eNc);
    localbv.tk(parambv.eNd);
    AppMethodBeat.o(43247);
    return localbv;
  }
  
  public static boolean bX(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43266);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication"))) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43266);
      return bool;
    }
  }
  
  public static boolean bY(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43267);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval"))) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43267);
      return bool;
    }
  }
  
  private boolean fvT()
  {
    AppMethodBeat.i(43249);
    if ((!isText()) && (!cVJ()) && (!fvE()))
    {
      AppMethodBeat.o(43249);
      return true;
    }
    AppMethodBeat.o(43249);
    return false;
  }
  
  public final boolean aVB(String paramString)
  {
    AppMethodBeat.i(43264);
    if ((!bu.isNullOrNil(this.eNd)) && (!bu.isNullOrNil(paramString)))
    {
      Object localObject = bx.M(this.eNd, "msgsource");
      if (localObject == null)
      {
        AppMethodBeat.o(43264);
        return false;
      }
      localObject = (String)((Map)localObject).get(".msgsource.atuserlist");
      if (!bu.isNullOrNil((String)localObject))
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
  
  public final void abE(int paramInt)
  {
    AppMethodBeat.i(43260);
    switch (paramInt)
    {
    default: 
      ae.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      AppMethodBeat.o(43260);
      return;
    }
    ka(this.eNc | paramInt);
    AppMethodBeat.o(43260);
  }
  
  public final boolean cVH()
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
  
  public final boolean cVJ()
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
      ae.e("MicroMsg.MsgInfo", localStringBuilder.toString());
      setType(1);
      setContent("");
      paramCursor = aM(this);
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43201);
          ((l)g.ab(l.class)).doJ().a(l, this.JgQ);
          AppMethodBeat.o(43201);
        }
      });
    }
    Ef(this.field_msgId);
    AppMethodBeat.o(43268);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(43270);
    Ef(this.field_msgId);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(43270);
    return localContentValues;
  }
  
  public final boolean cyG()
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
  
  public final boolean cyH()
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
  
  public final boolean cyI()
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
  
  public final boolean fta()
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
  
  public final boolean ftf()
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
  
  public final boolean ftg()
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
  
  public final boolean fvA()
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
  
  public final boolean fvB()
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
  
  public final boolean fvC()
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
  
  public final boolean fvD()
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
  
  public final boolean fvE()
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
  
  public final boolean fvF()
  {
    AppMethodBeat.i(213449);
    if ((super.getType() == 10000) || (super.getType() == 10002) || (super.getType() == 570425393) || (super.getType() == 64) || (super.getType() == 603979825) || (super.getType() == 889192497) || (super.getType() == 922746929))
    {
      AppMethodBeat.o(213449);
      return true;
    }
    AppMethodBeat.o(213449);
    return false;
  }
  
  public final boolean fvG()
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
  
  public final boolean fvH()
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
  
  public final boolean fvI()
  {
    AppMethodBeat.i(213450);
    if (super.getType() == 855638065)
    {
      AppMethodBeat.o(213450);
      return true;
    }
    AppMethodBeat.o(213450);
    return false;
  }
  
  public final boolean fvJ()
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
  
  public final boolean fvK()
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
  
  public final boolean fvL()
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
  
  public final boolean fvM()
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
  
  public final boolean fvN()
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
  
  public final boolean fvO()
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
  
  public final boolean fvP()
  {
    AppMethodBeat.i(213451);
    if ((super.getType() == 889192497) || (super.getType() == 922746929))
    {
      AppMethodBeat.o(213451);
      return true;
    }
    AppMethodBeat.o(213451);
    return false;
  }
  
  public final boolean fvQ()
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
  
  public final boolean fvR()
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
  
  public final boolean fvS()
  {
    AppMethodBeat.i(43246);
    if ((Nb()) && (!bu.isNullOrNil(this.field_transContent)))
    {
      AppMethodBeat.o(43246);
      return true;
    }
    AppMethodBeat.o(43246);
    return false;
  }
  
  public final boolean fvU()
  {
    return (this.fmq & 0x1) > 0;
  }
  
  public final void fvV()
  {
    AppMethodBeat.i(43250);
    kF(this.fmq | 0x1);
    AppMethodBeat.o(43250);
  }
  
  public final boolean fvW()
  {
    return (this.eNc & 0x200) > 0;
  }
  
  public final void fvX()
  {
    AppMethodBeat.i(43251);
    ka(this.eNc | 0x200);
    AppMethodBeat.o(43251);
  }
  
  public final void fvY()
  {
    AppMethodBeat.i(178875);
    ka(this.eNc | 0x800);
    AppMethodBeat.o(178875);
  }
  
  public final void fvZ()
  {
    AppMethodBeat.i(43252);
    if (fwa()) {
      ka(this.eNc & 0xFFFFFFDF);
    }
    AppMethodBeat.o(43252);
  }
  
  public final boolean fvw()
  {
    AppMethodBeat.i(43220);
    if ((super.getType() == 486539313) && (this.JgN) && (this.JgM != null))
    {
      AppMethodBeat.o(43220);
      return true;
    }
    AppMethodBeat.o(43220);
    return false;
  }
  
  public final boolean fvx()
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
  
  public final boolean fvy()
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
  
  public final boolean fvz()
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
  
  public final boolean fwa()
  {
    return (this.eNc & 0x20) > 0;
  }
  
  public final void fwb()
  {
    AppMethodBeat.i(43253);
    ka(this.eNc | 0x8);
    AppMethodBeat.o(43253);
  }
  
  public final boolean fwc()
  {
    AppMethodBeat.i(43254);
    if ((fvS()) && ((this.eNc & 0x10) > 0))
    {
      AppMethodBeat.o(43254);
      return true;
    }
    AppMethodBeat.o(43254);
    return false;
  }
  
  public final void fwd()
  {
    AppMethodBeat.i(43255);
    if (!fvS())
    {
      AppMethodBeat.o(43255);
      return;
    }
    ka(this.eNc | 0x10);
    AppMethodBeat.o(43255);
  }
  
  public final void fwe()
  {
    AppMethodBeat.i(43256);
    if (!fvS())
    {
      AppMethodBeat.o(43256);
      return;
    }
    ka(this.eNc & 0xFFFFFFEF);
    AppMethodBeat.o(43256);
  }
  
  public final boolean fwf()
  {
    AppMethodBeat.i(43257);
    if ((fvS()) && ((this.eNc & 0x400) > 0))
    {
      AppMethodBeat.o(43257);
      return true;
    }
    AppMethodBeat.o(43257);
    return false;
  }
  
  public final void fwg()
  {
    AppMethodBeat.i(43258);
    ka(this.eNc | 0x80);
    AppMethodBeat.o(43258);
  }
  
  public final void fwh()
  {
    AppMethodBeat.i(43259);
    ka(this.eNc & 0xFFFFFF7F);
    AppMethodBeat.o(43259);
  }
  
  public final boolean fwi()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ((this.eNc & 0x80) == 0)
    {
      bool1 = bool2;
      if ((this.eNc & 0x300) == 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final boolean fwj()
  {
    return (this.eNc & 0x2000) > 0;
  }
  
  public final void fwk()
  {
    AppMethodBeat.i(213452);
    ka(this.eNc | 0x2000);
    AppMethodBeat.o(213452);
  }
  
  public final void fwl()
  {
    AppMethodBeat.i(213453);
    ka(this.eNc & 0xFFFFDFFF);
    AppMethodBeat.o(213453);
  }
  
  public final boolean fwm()
  {
    return (this.eNc & 0x1000) > 0;
  }
  
  public final void fwn()
  {
    AppMethodBeat.i(43262);
    ka(this.eNc & 0xFFFFFFBF);
    AppMethodBeat.o(43262);
  }
  
  public final void fwo()
  {
    AppMethodBeat.i(43263);
    ka(this.eNc | 0x40);
    AppMethodBeat.o(43263);
  }
  
  public final boolean fwp()
  {
    AppMethodBeat.i(43265);
    if ((!bu.isNullOrNil(this.eNd)) && ((this.eNd.contains("announcement@all")) || (this.eNd.contains("notify@all")))) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43265);
      return bool;
    }
  }
  
  public final String fwq()
  {
    AppMethodBeat.i(43271);
    if (!fvD())
    {
      AppMethodBeat.o(43271);
      return "";
    }
    if (this.JgP == null) {
      fwr();
    }
    String str = this.JgP;
    AppMethodBeat.o(43271);
    return str;
  }
  
  public final com.tencent.mm.az.a fwr()
  {
    AppMethodBeat.i(43272);
    ae.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    com.tencent.mm.az.a locala = a.a.b(bx.M(this.field_content, "sysmsg"), this);
    if (locala != null)
    {
      ae.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { locala });
      locala.aKk();
      this.JgP = locala.TEXT;
    }
    for (;;)
    {
      AppMethodBeat.o(43272);
      return locala;
      ae.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(224500);
    int i = super.getType();
    AppMethodBeat.o(224500);
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
    if ((this.field_isSend == 1) && (fvT()))
    {
      if (this.field_status == 5)
      {
        ae.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()), this.field_talker, bu.fpN() });
        localObject = new sz();
        ((sz)localObject).dIE.dlw = this;
        com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
        AppMethodBeat.o(43248);
        return;
      }
      if (this.field_status == 2)
      {
        ae.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()) });
        localObject = new tb();
        ((tb)localObject).dIG.dlw = this;
        com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
        AppMethodBeat.o(43248);
      }
    }
    else if (this.field_isSend == 0)
    {
      localObject = new py();
      ((py)localObject).dFv.dlw = this;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
    }
    AppMethodBeat.o(43248);
  }
  
  public static final class a
  {
    public int Ecg = 0;
    public String Fyj = "";
    public int JgS = 0;
    public String JgT = "";
    public String JgU = "";
    public String JgV = "";
    public String JgW = "";
    public String JgX = "";
    public String JgY = "";
    public String JgZ = "";
    public String Jha = "";
    public String cUA = "";
    public int eQV;
    private String eRf;
    private String eRg;
    public String eRk = "";
    private String eRl = "";
    public String fhy = "";
    public String jem = "";
    public String jhN = "";
    public String jhO = "";
    public String jhP = "";
    public String jhS = "";
    public String nickname = "";
    public int scene = 0;
    public String signature;
    private String source = "";
    public String xfV = "";
    public long xik = 0L;
    
    public static a aVC(String paramString)
    {
      AppMethodBeat.i(43202);
      locala = new a();
      localObject = bu.bI(paramString, "").trim();
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("<"))
      {
        int i = ((String)localObject).indexOf(":");
        paramString = (String)localObject;
        if (i != -1) {
          paramString = ((String)localObject).substring(i + 1);
        }
      }
      localObject = bx.M(paramString, "msg");
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          if (((Map)localObject).get(".msg.$fromusername") != null) {
            continue;
          }
          locala.cUA = ((String)((Map)localObject).get(".msg.$username"));
          if (((Map)localObject).get(".msg.$fromnickname") != null) {
            continue;
          }
          locala.nickname = ((String)((Map)localObject).get(".msg.$nickname"));
        }
        catch (Exception paramString)
        {
          ae.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bu.o(paramString) });
          continue;
          locala.nickname = ((String)((Map)localObject).get(".msg.$fromnickname"));
          continue;
          paramString = (String)((Map)localObject).get(".msg.$certflag");
          continue;
        }
        locala.fhy = ((String)((Map)localObject).get(".msg.$alias"));
        locala.jhO = ((String)((Map)localObject).get(".msg.$fullpy"));
        locala.jhN = ((String)((Map)localObject).get(".msg.$shortpy"));
        locala.source = ((String)((Map)localObject).get(".msg.$source"));
        locala.JgS = bu.getInt((String)((Map)localObject).get(".msg.$imagestatus"), 0);
        locala.scene = bu.getInt((String)((Map)localObject).get(".msg.$scene"), 0);
        locala.JgT = ((String)((Map)localObject).get(".msg.$mobileidentify"));
        locala.JgU = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
        if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
          locala.xik = bu.getLong((String)((Map)localObject).get(".msg.$qqnum"), 0L);
        }
        locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
        if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
          locala.eQV = bu.getInt((String)((Map)localObject).get(".msg.$sex"), 0);
        }
        locala.eRg = ((String)((Map)localObject).get(".msg.$city"));
        locala.eRf = ((String)((Map)localObject).get(".msg.$province"));
        locala.jhP = ((String)((Map)localObject).get(".msg.$qqnickname"));
        locala.jhS = ((String)((Map)localObject).get(".msg.$qqremark"));
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
          continue;
        }
        paramString = "0";
        locala.Ecg = bu.getInt(paramString, 0);
        locala.eRk = bu.nullAsNil((String)((Map)localObject).get(".msg.$certinfo"));
        locala.xfV = bu.nullAsNil((String)((Map)localObject).get(".msg.$brandIconUrl"));
        locala.eRl = bu.nullAsNil((String)((Map)localObject).get(".msg.$regionCode"));
        locala.JgV = bu.nullAsNil((String)((Map)localObject).get(".msg.$bigheadimgurl"));
        locala.JgW = bu.nullAsNil((String)((Map)localObject).get(".msg.$smallheadimgurl"));
        locala.jem = bu.nullAsNil((String)((Map)localObject).get(".msg.$googlecontact"));
        locala.Fyj = bu.nullAsNil((String)((Map)localObject).get(".msg.$antispamticket"));
        locala.JgX = bu.nullAsNil((String)((Map)localObject).get(".msg.$openimappid"));
        locala.JgY = bu.nullAsNil((String)((Map)localObject).get(".msg.$openimdesc"));
        locala.JgZ = bu.nullAsNil((String)((Map)localObject).get(".msg.$openimdescicon"));
        locala.Jha = bu.nullAsNil((String)((Map)localObject).get(".msg.$openimcustominfo"));
        if (an.aUq(locala.cUA)) {
          locala.Fyj = bu.nullAsNil((String)((Map)localObject).get(".msg.$ticket"));
        }
        ae.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.cUA, locala.Fyj, locala.JgV, locala.JgW });
        AppMethodBeat.o(43202);
        return locala;
        locala.cUA = ((String)((Map)localObject).get(".msg.$fromusername"));
      }
    }
    
    public final String fws()
    {
      return this.cUA;
    }
    
    public final String fwt()
    {
      AppMethodBeat.i(43204);
      if ((this.jhS != null) && (this.jhS.length() > 0))
      {
        str = this.jhS;
        AppMethodBeat.o(43204);
        return str;
      }
      if ((this.jhP != null) && (this.jhP.length() > 0))
      {
        str = this.jhP;
        AppMethodBeat.o(43204);
        return str;
      }
      String str = Long.toString(this.xik);
      AppMethodBeat.o(43204);
      return str;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43205);
      Object localObject;
      if (!bu.isNullOrNil(this.eRl))
      {
        localObject = this.eRl.split("_");
        if (localObject.length > 0)
        {
          if (localObject.length <= 2) {
            break label71;
          }
          RegionCodeDecoder.fwA();
          this.eRg = RegionCodeDecoder.bi(localObject[0], localObject[1], localObject[2]);
        }
      }
      for (;;)
      {
        localObject = this.eRg;
        AppMethodBeat.o(43205);
        return localObject;
        label71:
        if (localObject.length == 2)
        {
          RegionCodeDecoder.fwA();
          this.eRg = RegionCodeDecoder.mi(localObject[0], localObject[1]);
        }
        else
        {
          this.eRg = "";
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
      if (!TextUtils.isEmpty(this.fhy))
      {
        str = this.fhy;
        AppMethodBeat.o(43203);
        return str;
      }
      ae.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = bu.nullAsNil(this.cUA);
      AppMethodBeat.o(43203);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43206);
      Object localObject;
      if (!bu.isNullOrNil(this.eRl))
      {
        localObject = this.eRl.split("_");
        if (localObject.length > 0)
        {
          if ((localObject.length <= 2) || (!RegionCodeDecoder.aVQ(localObject[0]))) {
            break label77;
          }
          RegionCodeDecoder.fwA();
        }
      }
      for (this.eRf = RegionCodeDecoder.mi(localObject[0], localObject[1]);; this.eRf = RegionCodeDecoder.aVR(localObject[0]))
      {
        localObject = this.eRf;
        AppMethodBeat.o(43206);
        return localObject;
        label77:
        RegionCodeDecoder.fwA();
      }
    }
  }
  
  public static final class b
  {
    public String Fcs = "";
    public String Jhb = "";
    public String Jhc = null;
    public String Jhd = null;
    public String Jhe = null;
    public String cUA = "";
    public int dzG = 0;
    public String jGd = "";
    public String label = "";
    public double vlC = 0.0D;
    public double vlD = 0.0D;
    public String vlJ = "";
    
    public static b aVD(String paramString)
    {
      AppMethodBeat.i(43208);
      b localb = new b();
      paramString = bx.M(paramString, "msg");
      if (paramString != null)
      {
        localb.cUA = bu.bI((String)paramString.get(".msg.location.$fromusername"), "");
        localb.vlC = bu.aSD((String)paramString.get(".msg.location.$x"));
        localb.vlD = bu.aSD((String)paramString.get(".msg.location.$y"));
        localb.label = bu.bI((String)paramString.get(".msg.location.$label"), "");
        localb.Jhb = bu.bI((String)paramString.get(".msg.location.$maptype"), "");
        localb.dzG = bu.aSB((String)paramString.get(".msg.location.$scale"));
        localb.Jhe = bu.bI((String)paramString.get(".msg.location.$localLocationen"), "");
        localb.Jhc = bu.bI((String)paramString.get(".msg.location.$localLocationcn"), "");
        localb.Jhd = bu.bI((String)paramString.get(".msg.location.$localLocationtw"), "");
        localb.jGd = bu.bI((String)paramString.get(".msg.location.$poiname"), "");
        localb.Fcs = bu.bI((String)paramString.get(".msg.location.$infourl"), "");
        localb.vlJ = bu.bI((String)paramString.get(".msg.location.$poiid"), "");
      }
      AppMethodBeat.o(43208);
      return localb;
    }
    
    public final boolean fwu()
    {
      AppMethodBeat.i(43209);
      if ((this.jGd != null) && (!this.jGd.equals("")) && (!this.jGd.equals("[位置]")))
      {
        AppMethodBeat.o(43209);
        return true;
      }
      AppMethodBeat.o(43209);
      return false;
    }
    
    public final boolean fwv()
    {
      AppMethodBeat.i(43210);
      if ((Math.abs(this.vlD) > 180.0D) || (Math.abs(this.vlC) > 90.0D))
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
      String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.vlC * 1000000.0D)), Integer.valueOf((int)(this.vlD * 1000000.0D)), Integer.valueOf(this.dzG) });
      AppMethodBeat.o(43207);
      return str;
    }
  }
  
  public static final class c
  {
    public String Jhf = "";
    public String content = "";
    public String inW = "";
    public boolean rMB = false;
    public String title = "";
    public String xqW;
    
    public static c aVE(String paramString)
    {
      AppMethodBeat.i(43211);
      c localc = new c();
      paramString = bx.M(paramString, "msg");
      if (paramString != null) {}
      try
      {
        localc.title = ((String)paramString.get(".msg.pushmail.content.subject"));
        localc.content = ((String)paramString.get(".msg.pushmail.content.digest"));
        localc.inW = ((String)paramString.get(".msg.pushmail.content.sender"));
        localc.Jhf = ((String)paramString.get(".msg.pushmail.waplink"));
        localc.rMB = bu.nullAsNil((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
        localc.xqW = ((String)paramString.get(".msg.pushmail.mailid"));
        AppMethodBeat.o(43211);
        return localc;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ae.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bu.o(paramString) });
        }
      }
    }
    
    public final String getSender()
    {
      return this.inW;
    }
    
    public final String getTitle()
    {
      return this.title;
    }
  }
  
  public static final class d
  {
    public String Fnm;
    public int JgS = 0;
    public String JgT = "";
    public String JgU = "";
    public String JgV = "";
    public String JgW = "";
    public int Jhg = 0;
    public String Jhh;
    public String Jhi;
    public int Jhj;
    public String Jhk;
    public String Jhl;
    public String Jhm;
    public String Jhn;
    public String cUA = "";
    public String chatroomName = "";
    private String cityCode;
    public String content = "";
    private String countryCode;
    public int dto;
    public int eQV;
    public String fhy = "";
    public String jem;
    public String jhN = "";
    public String jhO = "";
    public String jhP = "";
    private String jhS = "";
    public String kbH;
    public String nickname = "";
    private String provinceCode;
    public int scene = 0;
    public String signature;
    public String tIA;
    public long xik = 0L;
    
    public static d aVF(String paramString)
    {
      AppMethodBeat.i(43212);
      d locald = new d();
      paramString = bx.M(paramString, "msg");
      if (paramString != null) {}
      try
      {
        locald.cUA = ((String)paramString.get(".msg.$fromusername"));
        locald.fhy = ((String)paramString.get(".msg.$alias"));
        locald.nickname = ((String)paramString.get(".msg.$fromnickname"));
        locald.jhO = ((String)paramString.get(".msg.$fullpy"));
        locald.jhN = ((String)paramString.get(".msg.$shortpy"));
        locald.content = ((String)paramString.get(".msg.$content"));
        locald.JgS = bu.getInt((String)paramString.get(".msg.$imagestatus"), 0);
        locald.scene = bu.getInt((String)paramString.get(".msg.$scene"), 0);
        locald.JgT = ((String)paramString.get(".msg.$mhash"));
        locald.JgU = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          locald.xik = bu.getLong((String)paramString.get(".msg.$qqnum"), 0L);
        }
        locald.jhP = ((String)paramString.get(".msg.$qqnickname"));
        locald.jhS = ((String)paramString.get(".msg.$qqremark"));
        locald.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          locald.eQV = bu.getInt((String)paramString.get(".msg.$sex"), 0);
        }
        locald.cityCode = ((String)paramString.get(".msg.$city"));
        locald.provinceCode = ((String)paramString.get(".msg.$province"));
        locald.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          locald.Jhg = bu.getInt((String)paramString.get(".msg.$snsflag"), 0);
          locald.Jhh = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        locald.tIA = ((String)paramString.get(".msg.$ticket"));
        ae.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { locald.tIA });
        locald.JgV = bu.nullAsNil((String)paramString.get(".msg.$bigheadimgurl"));
        locald.JgW = bu.nullAsNil((String)paramString.get(".msg.$smallheadimgurl"));
        locald.dto = bu.getInt((String)paramString.get(".msg.$opcode"), 0);
        locald.Jhi = bu.nullAsNil((String)paramString.get(".msg.$encryptusername"));
        locald.jem = bu.nullAsNil((String)paramString.get(".msg.$googlecontact"));
        ae.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { locald.cUA, locald.JgV, locald.JgW });
        locald.chatroomName = bu.nullAsNil((String)paramString.get(".msg.$chatroomusername"));
        locald.kbH = ((String)paramString.get(".msg.$sourceusername"));
        locald.Fnm = ((String)paramString.get(".msg.$sourcenickname"));
        locald.Jhm = ((String)paramString.get(".msg.$sharecardusername"));
        locald.Jhn = ((String)paramString.get(".msg.$sharecardnickname"));
        locald.Jhj = bu.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (locald.Jhj == 1)
        {
          locald.Jhk = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          locald.Jhl = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.MsgInfo", paramString, "", new Object[0]);
        }
      }
      AppMethodBeat.o(43212);
      return locald;
    }
    
    public final String HC()
    {
      return this.signature;
    }
    
    public final String VI()
    {
      return this.fhy;
    }
    
    public final String VK()
    {
      return this.nickname;
    }
    
    public final String VL()
    {
      return this.jhN;
    }
    
    public final String VM()
    {
      return this.jhO;
    }
    
    public final int VQ()
    {
      return this.eQV;
    }
    
    public final String fws()
    {
      return this.cUA;
    }
    
    public final String fww()
    {
      return this.tIA;
    }
    
    public final String fwx()
    {
      return this.Jhi;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43214);
      if ((!bu.isNullOrNil(this.countryCode)) && (!bu.isNullOrNil(this.provinceCode)))
      {
        if (bu.isNullOrNil(this.cityCode))
        {
          RegionCodeDecoder.fwA();
          str = RegionCodeDecoder.mi(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43214);
          return str;
        }
        RegionCodeDecoder.fwA();
        str = RegionCodeDecoder.bi(this.countryCode, this.provinceCode, this.cityCode);
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
      ae.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = this.cUA;
      AppMethodBeat.o(43213);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43215);
      if (!bu.isNullOrNil(this.countryCode))
      {
        if ((!bu.isNullOrNil(this.provinceCode)) && (!bu.isNullOrNil(this.cityCode)) && (RegionCodeDecoder.aVQ(this.countryCode)))
        {
          RegionCodeDecoder.fwA();
          str = RegionCodeDecoder.mi(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43215);
          return str;
        }
        RegionCodeDecoder.fwA();
        str = RegionCodeDecoder.aVR(this.countryCode);
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
 * Qualified Name:     com.tencent.mm.storage.bv
 * JD-Core Version:    0.7.0.1
 */