package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.ae.o;
import com.tencent.mm.ax.a.a;
import com.tencent.mm.h.a.mv;
import com.tencent.mm.h.a.pf;
import com.tencent.mm.h.a.ph;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import junit.framework.Assert;

public final class bi
  extends o
{
  public static String uBP = "voip_content_voice";
  public static String uBQ = "voip_content_video";
  public boolean uBR = false;
  private String uBS;
  
  public bi() {}
  
  public bi(String paramString)
  {
    super.ec(paramString);
  }
  
  public static bi ak(bi parambi)
  {
    if (parambi == null)
    {
      y.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
      return null;
    }
    bi localbi = new bi();
    localbi.setMsgId(parambi.field_msgId);
    localbi.bf(parambi.field_msgSvrId);
    localbi.setType(parambi.getType());
    localbi.setStatus(parambi.field_status);
    localbi.fA(parambi.field_isSend);
    localbi.field_isShowTimer = parambi.field_isShowTimer;
    localbi.cQt = true;
    localbi.bg(parambi.field_createTime);
    localbi.ec(parambi.field_talker);
    localbi.setContent(parambi.field_content);
    localbi.ed(parambi.field_imgPath);
    localbi.ee(parambi.field_reserved);
    localbi.w(parambi.field_lvbuffer);
    localbi.ef(parambi.field_transContent);
    localbi.eh(parambi.cQF);
    localbi.ff(parambi.czq);
    localbi.cY(parambi.czr);
    return localbi;
  }
  
  public static boolean av(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication"))) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public static boolean aw(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval"))) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public static void hG(long paramLong)
  {
    if ((100000000L > paramLong) && (-10L < paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("msgId not in the reasonable scope", bool);
      return;
    }
  }
  
  public final void Fq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      y.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      return;
    }
    ff(this.czq | paramInt);
  }
  
  public final boolean aRQ()
  {
    return getType() == 43;
  }
  
  public final boolean aRR()
  {
    return getType() == 62;
  }
  
  public final boolean aVK()
  {
    return (getType() & 0xFFFF) == 49;
  }
  
  public final boolean aVM()
  {
    return getType() == 48;
  }
  
  public final boolean abY(String paramString)
  {
    if ((!bk.bl(this.czr)) && (!bk.bl(paramString)))
    {
      Object localObject = bn.s(this.czr, "msgsource");
      if (localObject == null) {
        return false;
      }
      localObject = (String)((Map)localObject).get(".msgsource.atuserlist");
      if (!bk.bl((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].trim().equals(paramString)) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public final boolean ctA()
  {
    return getType() == 34;
  }
  
  public final boolean ctB()
  {
    switch (getType())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean ctz()
  {
    return getType() == 285212721;
  }
  
  public final boolean cvA()
  {
    return (this.czq & 0x20) > 0;
  }
  
  public final boolean cvB()
  {
    return (cvw()) && ((this.czq & 0x10) > 0);
  }
  
  public final void cvC()
  {
    if (!cvw()) {
      return;
    }
    ff(this.czq | 0x10);
  }
  
  public final boolean cvD()
  {
    return (cvw()) && ((this.czq & 0x400) > 0);
  }
  
  public final void cvE()
  {
    ff(this.czq | 0x80);
  }
  
  public final boolean cvF()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ((this.czq & 0x80) == 0)
    {
      bool1 = bool2;
      if ((this.czq & 0x300) == 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final void cvG()
  {
    ff(this.czq & 0xFFFFFFBF);
  }
  
  public final void cvH()
  {
    ff(this.czq | 0x40);
  }
  
  public final boolean cvI()
  {
    return (this.czq & 0x40) != 0;
  }
  
  public final boolean cvJ()
  {
    if ((!bk.bl(this.czr)) && ((this.czr.contains("announcement@all")) || (this.czr.contains("notify@all")))) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public final String cvK()
  {
    if (!cvm()) {
      return "";
    }
    if (this.uBS == null) {
      cvL();
    }
    return this.uBS;
  }
  
  public final com.tencent.mm.ax.a cvL()
  {
    y.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    com.tencent.mm.ax.a locala = a.a.b(bn.s(this.field_content, "sysmsg"), this);
    if (locala != null)
    {
      y.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { locala });
      if ((locala.values != null) && (locala.values.size() > 0))
      {
        if (locala.values.containsKey(".sysmsg.$type")) {
          locala.TYPE = ((String)locala.values.get(".sysmsg.$type"));
        }
        com.tencent.mm.ax.a.evw = ".sysmsg." + locala.TYPE + ".text";
        if (locala.values.containsKey(com.tencent.mm.ax.a.evw)) {
          locala.TEXT = ((String)locala.values.get(com.tencent.mm.ax.a.evw));
        }
        com.tencent.mm.ax.a.evx = ".sysmsg." + locala.TYPE + ".link.scene";
        if (locala.values.containsKey(com.tencent.mm.ax.a.evx)) {
          locala.evz = ((String)locala.values.get(com.tencent.mm.ax.a.evx));
        }
        locala.Ib();
      }
      for (;;)
      {
        this.uBS = locala.TEXT;
        return locala;
        y.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
      }
    }
    y.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    return locala;
  }
  
  public final boolean cvg()
  {
    return getType() == 436207665;
  }
  
  public final boolean cvh()
  {
    return getType() == 469762097;
  }
  
  public final boolean cvi()
  {
    return getType() == 301989937;
  }
  
  public final boolean cvj()
  {
    return (getType() == 50) || (getType() == 53);
  }
  
  public final boolean cvk()
  {
    return getType() == 52;
  }
  
  public final boolean cvl()
  {
    return getType() == 318767153;
  }
  
  public final boolean cvm()
  {
    return getType() == 10002;
  }
  
  public final boolean cvn()
  {
    return (getType() == 42) || (getType() == 66);
  }
  
  public final boolean cvo()
  {
    return getType() == 47;
  }
  
  public final boolean cvp()
  {
    return getType() == 1048625;
  }
  
  public final boolean cvq()
  {
    return getType() == 16777265;
  }
  
  public final boolean cvr()
  {
    return getType() == 268435505;
  }
  
  public final boolean cvs()
  {
    return getType() == -1879048191;
  }
  
  public final boolean cvt()
  {
    return getType() == -1879048190;
  }
  
  public final boolean cvu()
  {
    return getType() == -1879048189;
  }
  
  public final boolean cvv()
  {
    switch (getType())
    {
    case 56: 
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean cvw()
  {
    String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("TranslateMsgOff");
    if ((!bk.bl(str)) && (bk.ZR(str) != 0)) {
      y.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
    }
    for (int i = 0; (i != 0) && (!bk.bl(this.field_transContent)); i = 1) {
      return true;
    }
    return false;
  }
  
  public final boolean cvx()
  {
    return (this.cQI & 0x1) > 0;
  }
  
  public final void cvy()
  {
    this.cQI |= 0x1;
    this.cyX = true;
  }
  
  public final void cvz()
  {
    if (cvA()) {
      ff(this.czq & 0xFFFFFFDF);
    }
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
    paramCursor = this.field_content;
    if ((paramCursor != null) && (paramCursor.length() > 2097152))
    {
      final long l = this.field_msgId;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("Very big message: \nmsgId = ").append(l).append('\n').append("msgSvrId = ").append(this.field_msgSvrId).append('\n').append("type = ").append(getType()).append('\n').append("createTime = ").append(this.field_createTime).append('\n').append("talker = ").append(this.field_talker).append('\n').append("flag = ").append(this.field_flag).append('\n').append("content.length() = ").append(paramCursor.length()).append('\n').append("content = ").append(paramCursor.substring(0, 256));
      y.e("MicroMsg.MsgInfo", localStringBuilder.toString());
      setType(1);
      setContent("");
      paramCursor = ak(this);
      com.tencent.mm.kernel.g.DS().O(new Runnable()
      {
        public final void run()
        {
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(l, this.uBT);
        }
      });
    }
    hG(this.field_msgId);
  }
  
  public final int getType()
  {
    int j = super.getType();
    int i = j;
    if (j == 486539313) {
      i = 285212721;
    }
    return i;
  }
  
  public final boolean isSystem()
  {
    return getType() == 10000;
  }
  
  public final boolean isText()
  {
    switch (getType())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final void setStatus(int paramInt)
  {
    super.setStatus(paramInt);
    if (this.field_isSend == 1) {
      if ((!isText()) && (!aVM()) && (!cvn()))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label188;
        }
        if (this.field_status != 5) {
          break label123;
        }
        y.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(getType()), this.field_talker, bk.csb() });
        localObject = new pf();
        ((pf)localObject).bYS.bFH = this;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      }
    }
    label123:
    while (this.field_isSend != 0)
    {
      do
      {
        return;
        paramInt = 0;
        break;
      } while (this.field_status != 2);
      y.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(getType()) });
      localObject = new ph();
      ((ph)localObject).bYU.bFH = this;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      return;
    }
    label188:
    Object localObject = new mv();
    ((mv)localObject).bWw.bFH = this;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
  }
  
  public final ContentValues vf()
  {
    hG(this.field_msgId);
    return super.vf();
  }
  
  public static final class a
  {
    private String aWf = "";
    private String cCA;
    private String cCB;
    public String cCF = "";
    private String cCG = "";
    public String cMT = "";
    public String fds = "";
    public String fgZ = "";
    public String fha = "";
    public String fhb = "";
    public String fhe = "";
    public String mVN = "";
    public long mXV = 0L;
    public String nickname = "";
    public String pyp = "";
    public int qZn = 0;
    public int scene = 0;
    public int sex;
    public String signature;
    public String sii = "";
    public int uBV = 0;
    public String uBW = "";
    public String uBX = "";
    public String uBY = "";
    public String uBZ = "";
    public String uCa = "";
    public String uCb = "";
    public String uCc = "";
    public String uCd = "";
    
    public static a abZ(String paramString)
    {
      a locala = new a();
      Object localObject = bk.aM(paramString, "").trim();
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("<"))
      {
        int i = ((String)localObject).indexOf(":");
        paramString = (String)localObject;
        if (i != -1) {
          paramString = ((String)localObject).substring(i + 1);
        }
      }
      localObject = bn.s(paramString, "msg");
      if (localObject != null) {
        for (;;)
        {
          try
          {
            if (((Map)localObject).get(".msg.$fromusername") == null)
            {
              locala.pyp = ((String)((Map)localObject).get(".msg.$username"));
              if (((Map)localObject).get(".msg.$fromnickname") == null)
              {
                locala.nickname = ((String)((Map)localObject).get(".msg.$nickname"));
                locala.cMT = ((String)((Map)localObject).get(".msg.$alias"));
                locala.fha = ((String)((Map)localObject).get(".msg.$fullpy"));
                locala.fgZ = ((String)((Map)localObject).get(".msg.$shortpy"));
                locala.aWf = ((String)((Map)localObject).get(".msg.$source"));
                locala.uBV = bk.getInt((String)((Map)localObject).get(".msg.$imagestatus"), 0);
                locala.scene = bk.getInt((String)((Map)localObject).get(".msg.$scene"), 0);
                locala.uBW = ((String)((Map)localObject).get(".msg.$mobileidentify"));
                locala.uBX = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
                if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
                  locala.mXV = bk.getLong((String)((Map)localObject).get(".msg.$qqnum"), 0L);
                }
                locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
                if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
                  locala.sex = bk.getInt((String)((Map)localObject).get(".msg.$sex"), 0);
                }
                locala.cCB = ((String)((Map)localObject).get(".msg.$city"));
                locala.cCA = ((String)((Map)localObject).get(".msg.$province"));
                locala.fhb = ((String)((Map)localObject).get(".msg.$qqnickname"));
                locala.fhe = ((String)((Map)localObject).get(".msg.$qqremark"));
                if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
                  break label765;
                }
                paramString = "0";
                locala.qZn = bk.getInt(paramString, 0);
                locala.cCF = bk.pm((String)((Map)localObject).get(".msg.$certinfo"));
                locala.mVN = bk.pm((String)((Map)localObject).get(".msg.$brandIconUrl"));
                locala.cCG = bk.pm((String)((Map)localObject).get(".msg.$regionCode"));
                locala.uBY = bk.pm((String)((Map)localObject).get(".msg.$bigheadimgurl"));
                locala.uBZ = bk.pm((String)((Map)localObject).get(".msg.$smallheadimgurl"));
                locala.fds = bk.pm((String)((Map)localObject).get(".msg.$googlecontact"));
                locala.sii = bk.pm((String)((Map)localObject).get(".msg.$antispamticket"));
                locala.uCa = bk.pm((String)((Map)localObject).get(".msg.$openimappid"));
                locala.uCb = bk.pm((String)((Map)localObject).get(".msg.$openimdesc"));
                locala.uCc = bk.pm((String)((Map)localObject).get(".msg.$openimdescicon"));
                locala.uCd = bk.pm((String)((Map)localObject).get(".msg.$openimcustominfo"));
                if (ad.aaU(locala.pyp)) {
                  locala.sii = bk.pm((String)((Map)localObject).get(".msg.$ticket"));
                }
                y.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.pyp, locala.sii, locala.uBY, locala.uBZ });
                return locala;
              }
            }
            else
            {
              locala.pyp = ((String)((Map)localObject).get(".msg.$fromusername"));
              continue;
            }
            locala.nickname = ((String)((Map)localObject).get(".msg.$fromnickname"));
          }
          catch (Exception paramString)
          {
            y.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bk.j(paramString) });
            return locala;
          }
          continue;
          label765:
          paramString = (String)((Map)localObject).get(".msg.$certflag");
        }
      }
      return locala;
    }
    
    public final String cvM()
    {
      if ((this.fhe != null) && (this.fhe.length() > 0)) {
        return this.fhe;
      }
      if ((this.fhb != null) && (this.fhb.length() > 0)) {
        return this.fhb;
      }
      return Long.toString(this.mXV);
    }
    
    public final String getCity()
    {
      String[] arrayOfString;
      if (!bk.bl(this.cCG))
      {
        arrayOfString = this.cCG.split("_");
        if (arrayOfString.length > 0)
        {
          if (arrayOfString.length <= 2) {
            break label57;
          }
          RegionCodeDecoder.cvV();
          this.cCB = RegionCodeDecoder.ap(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
        }
      }
      for (;;)
      {
        return this.cCB;
        label57:
        if (arrayOfString.length == 2)
        {
          RegionCodeDecoder.cvV();
          this.cCB = RegionCodeDecoder.gp(arrayOfString[0], arrayOfString[1]);
        }
        else
        {
          this.cCB = "";
        }
      }
    }
    
    public final String getDisplayName()
    {
      if (!TextUtils.isEmpty(this.nickname)) {
        return this.nickname;
      }
      if (!TextUtils.isEmpty(this.cMT)) {
        return this.cMT;
      }
      y.f("MicroMsg.MsgInfo", "username is nullOrNil");
      return bk.pm(this.pyp);
    }
    
    public final String getProvince()
    {
      String[] arrayOfString;
      if (!bk.bl(this.cCG))
      {
        arrayOfString = this.cCG.split("_");
        if (arrayOfString.length > 0)
        {
          if ((arrayOfString.length <= 2) || (!RegionCodeDecoder.acl(arrayOfString[0]))) {
            break label63;
          }
          RegionCodeDecoder.cvV();
        }
      }
      for (this.cCA = RegionCodeDecoder.gp(arrayOfString[0], arrayOfString[1]);; this.cCA = RegionCodeDecoder.acm(arrayOfString[0]))
      {
        return this.cCA;
        label63:
        RegionCodeDecoder.cvV();
      }
    }
  }
  
  public static final class b
  {
    public int bRv = 0;
    public double lCJ = 0.0D;
    public double lCK = 0.0D;
    public String lCQ = "";
    public String lFn = "";
    public String label = "";
    public String pyp = "";
    public String rSW = "";
    public String uCe = "";
    public String uCf = null;
    public String uCg = null;
    public String uCh = null;
    
    public static b aca(String paramString)
    {
      b localb = new b();
      paramString = bn.s(paramString, "msg");
      if (paramString != null)
      {
        localb.pyp = bk.aM((String)paramString.get(".msg.location.$fromusername"), "");
        localb.lCJ = bk.ZT((String)paramString.get(".msg.location.$x"));
        localb.lCK = bk.ZT((String)paramString.get(".msg.location.$y"));
        localb.label = bk.aM((String)paramString.get(".msg.location.$label"), "");
        localb.uCe = bk.aM((String)paramString.get(".msg.location.$maptype"), "");
        localb.bRv = bk.ZR((String)paramString.get(".msg.location.$scale"));
        localb.uCh = bk.aM((String)paramString.get(".msg.location.$localLocationen"), "");
        localb.uCf = bk.aM((String)paramString.get(".msg.location.$localLocationcn"), "");
        localb.uCg = bk.aM((String)paramString.get(".msg.location.$localLocationtw"), "");
        localb.lFn = bk.aM((String)paramString.get(".msg.location.$poiname"), "");
        localb.rSW = bk.aM((String)paramString.get(".msg.location.$infourl"), "");
        localb.lCQ = bk.aM((String)paramString.get(".msg.location.$poiid"), "");
      }
      return localb;
    }
    
    public final boolean cvN()
    {
      return (this.lFn != null) && (!this.lFn.equals("")) && (!this.lFn.equals("[位置]"));
    }
    
    public final boolean cvO()
    {
      return (Math.abs(this.lCK) <= 180.0D) && (Math.abs(this.lCJ) <= 90.0D);
    }
    
    public final String toString()
    {
      return String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.lCJ * 1000000.0D)), Integer.valueOf((int)(this.lCK * 1000000.0D)), Integer.valueOf(this.bRv) });
    }
  }
  
  public static final class c
  {
    public String content = "";
    public String eyU = "";
    public boolean kjj = false;
    public String nds;
    public String title = "";
    public String uCi = "";
    
    public static c acb(String paramString)
    {
      c localc = new c();
      paramString = bn.s(paramString, "msg");
      if (paramString != null) {}
      try
      {
        localc.title = ((String)paramString.get(".msg.pushmail.content.subject"));
        localc.content = ((String)paramString.get(".msg.pushmail.content.digest"));
        localc.eyU = ((String)paramString.get(".msg.pushmail.content.sender"));
        localc.uCi = ((String)paramString.get(".msg.pushmail.waplink"));
        localc.kjj = bk.pm((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
        localc.nds = ((String)paramString.get(".msg.pushmail.mailid"));
        return localc;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bk.j(paramString) });
      }
      return localc;
    }
  }
  
  public static final class d
  {
    public int bNb;
    public String cMT = "";
    public String chatroomName = "";
    public String content = "";
    private String countryCode;
    private String dXu;
    private String dXv;
    public String fds;
    public String fgZ = "";
    public String fha = "";
    public String fhb = "";
    private String fhe = "";
    public String kzG;
    public long mXV = 0L;
    public String nickname = "";
    public String pyp = "";
    public String sbK;
    public String sbL;
    public int scene = 0;
    public int sex;
    public String signature;
    public int uBV = 0;
    public String uBW = "";
    public String uBX = "";
    public String uBY = "";
    public String uBZ = "";
    public int uCj = 0;
    public String uCk;
    public String uCl;
    public int uCm;
    public String uCn;
    public String uCo;
    
    public static d acc(String paramString)
    {
      d locald = new d();
      paramString = bn.s(paramString, "msg");
      if (paramString != null) {}
      try
      {
        locald.pyp = ((String)paramString.get(".msg.$fromusername"));
        locald.cMT = ((String)paramString.get(".msg.$alias"));
        locald.nickname = ((String)paramString.get(".msg.$fromnickname"));
        locald.fha = ((String)paramString.get(".msg.$fullpy"));
        locald.fgZ = ((String)paramString.get(".msg.$shortpy"));
        locald.content = ((String)paramString.get(".msg.$content"));
        locald.uBV = bk.getInt((String)paramString.get(".msg.$imagestatus"), 0);
        locald.scene = bk.getInt((String)paramString.get(".msg.$scene"), 0);
        locald.uBW = ((String)paramString.get(".msg.$mhash"));
        locald.uBX = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          locald.mXV = bk.getLong((String)paramString.get(".msg.$qqnum"), 0L);
        }
        locald.fhb = ((String)paramString.get(".msg.$qqnickname"));
        locald.fhe = ((String)paramString.get(".msg.$qqremark"));
        locald.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          locald.sex = bk.getInt((String)paramString.get(".msg.$sex"), 0);
        }
        locald.dXu = ((String)paramString.get(".msg.$city"));
        locald.dXv = ((String)paramString.get(".msg.$province"));
        locald.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          locald.uCj = bk.getInt((String)paramString.get(".msg.$snsflag"), 0);
          locald.uCk = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        locald.kzG = ((String)paramString.get(".msg.$ticket"));
        y.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { locald.kzG });
        locald.uBY = bk.pm((String)paramString.get(".msg.$bigheadimgurl"));
        locald.uBZ = bk.pm((String)paramString.get(".msg.$smallheadimgurl"));
        locald.bNb = bk.getInt((String)paramString.get(".msg.$opcode"), 0);
        locald.uCl = bk.pm((String)paramString.get(".msg.$encryptusername"));
        locald.fds = bk.pm((String)paramString.get(".msg.$googlecontact"));
        y.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { locald.pyp, locald.uBY, locald.uBZ });
        locald.chatroomName = bk.pm((String)paramString.get(".msg.$chatroomusername"));
        locald.sbK = ((String)paramString.get(".msg.$sourceusername"));
        locald.sbL = ((String)paramString.get(".msg.$sourcenickname"));
        locald.uCm = bk.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (locald.uCm == 1)
        {
          locald.uCn = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          locald.uCo = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
        }
        return locald;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.MsgInfo", paramString, "", new Object[0]);
      }
      return locald;
    }
    
    public final String cvP()
    {
      return this.kzG;
    }
    
    public final String cvQ()
    {
      return this.pyp;
    }
    
    public final int cvR()
    {
      return this.sex;
    }
    
    public final String cvS()
    {
      return this.uCl;
    }
    
    public final String getCity()
    {
      if ((!bk.bl(this.countryCode)) && (!bk.bl(this.dXv)))
      {
        if (bk.bl(this.dXu))
        {
          RegionCodeDecoder.cvV();
          return RegionCodeDecoder.gp(this.countryCode, this.dXv);
        }
        RegionCodeDecoder.cvV();
        return RegionCodeDecoder.ap(this.countryCode, this.dXv, this.dXu);
      }
      return this.dXu;
    }
    
    public final String getDisplayName()
    {
      if ((this.nickname != null) && (this.nickname.length() > 0)) {
        return this.nickname;
      }
      y.f("MicroMsg.MsgInfo", "username is nullOrNil");
      return this.pyp;
    }
    
    public final String getProvince()
    {
      if (!bk.bl(this.countryCode))
      {
        if ((!bk.bl(this.dXv)) && (!bk.bl(this.dXu)) && (RegionCodeDecoder.acl(this.countryCode)))
        {
          RegionCodeDecoder.cvV();
          return RegionCodeDecoder.gp(this.countryCode, this.dXv);
        }
        RegionCodeDecoder.cvV();
        return RegionCodeDecoder.acm(this.countryCode);
      }
      return this.dXv;
    }
    
    public final String getSignature()
    {
      return this.signature;
    }
    
    public final String vk()
    {
      return this.cMT;
    }
    
    public final String vm()
    {
      return this.nickname;
    }
    
    public final String vn()
    {
      return this.fgZ;
    }
    
    public final String vo()
    {
      return this.fha;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bi
 * JD-Core Version:    0.7.0.1
 */