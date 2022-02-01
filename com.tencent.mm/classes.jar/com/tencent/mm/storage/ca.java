package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.ab;
import com.tencent.mm.bc.a.a;
import com.tencent.mm.f.a.rs;
import com.tencent.mm.f.a.va;
import com.tencent.mm.f.a.vc;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.n.f;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import junit.framework.Assert;

public class ca
  extends ab
{
  public static String VGx = "voip_content_voice";
  public static String VGy = "voip_content_video";
  public boolean VGA;
  public boolean VGB;
  private String VGC;
  public jd VGz;
  public boolean gX;
  public String sessionId;
  
  public ca()
  {
    this.VGz = null;
    this.VGA = false;
    this.VGB = false;
    this.gX = false;
  }
  
  public ca(String paramString)
  {
    AppMethodBeat.i(43216);
    this.VGz = null;
    this.VGA = false;
    this.VGB = false;
    this.gX = false;
    super.Jm(paramString);
    AppMethodBeat.o(43216);
  }
  
  public static void UV(long paramLong)
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
  
  private static boolean abP()
  {
    AppMethodBeat.i(43261);
    String str = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("TranslateMsgOff");
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
  
  public static ca bs(ca paramca)
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
    localca.EG(paramca.field_msgSvrId);
    localca.setType(paramca.getType());
    localca.setStatus(paramca.field_status);
    localca.pJ(paramca.field_isSend);
    localca.pV(paramca.apI());
    localca.setCreateTime(paramca.field_createTime);
    localca.Jm(paramca.field_talker);
    localca.setContent(paramca.field_content);
    localca.Jn(paramca.field_imgPath);
    localca.Jo(paramca.field_reserved);
    localca.ah(paramca.apM());
    localca.Jp(paramca.field_transContent);
    localca.Ju(paramca.ilh);
    localca.pp(paramca.hxx);
    localca.Ip(paramca.hxy);
    AppMethodBeat.o(43247);
    return localca;
  }
  
  public static boolean ck(Map<String, String> paramMap)
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
  
  public static boolean cl(Map<String, String> paramMap)
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
  
  private boolean hzP()
  {
    AppMethodBeat.i(43249);
    if ((!hwH()) && (!erm()) && (!hzy()))
    {
      AppMethodBeat.o(43249);
      return true;
    }
    AppMethodBeat.o(43249);
    return false;
  }
  
  public final boolean Ic()
  {
    return (this.ilk & 0x1) > 0;
  }
  
  public final void asJ(int paramInt)
  {
    AppMethodBeat.i(43260);
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      AppMethodBeat.o(43260);
      return;
    }
    pp(this.hxx | paramInt);
    AppMethodBeat.o(43260);
  }
  
  public final boolean bwY(String paramString)
  {
    AppMethodBeat.i(43264);
    if ((!Util.isNullOrNil(this.hxy)) && (!Util.isNullOrNil(paramString)))
    {
      Object localObject = XmlParser.parseXml(this.hxy, "msgsource", null);
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
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(43268);
    super.convertFrom(paramCursor);
    paramCursor = this.field_content;
    if ((paramCursor != null) && (paramCursor.length() > 2097152))
    {
      long l = this.field_msgId;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("Very big message: \nmsgId = ").append(l).append('\n').append("msgSvrId = ").append(this.field_msgSvrId).append('\n').append("type = ").append(super.getType()).append('\n').append("createTime = ").append(this.field_createTime).append('\n').append("talker = ").append(this.field_talker).append('\n').append("flag = ").append(this.field_flag).append('\n').append("content.length() = ").append(paramCursor.length()).append('\n').append("content = ").append(paramCursor.substring(0, 256));
      Log.e("MicroMsg.MsgInfo", localStringBuilder.toString());
      setType(1);
      setContent("");
      paramCursor = bs(this);
      h.aHJ().postToWorker(new ca.1(this, l, paramCursor));
    }
    UV(this.field_msgId);
    AppMethodBeat.o(43268);
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(43270);
    UV(this.field_msgId);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(43270);
    return localContentValues;
  }
  
  public final boolean dlR()
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
  
  public final boolean dlS()
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
  
  public final boolean dlT()
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
  
  public final boolean erk()
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
  
  public final boolean erm()
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
  
  public final int getType()
  {
    AppMethodBeat.i(292927);
    int i = super.getType();
    AppMethodBeat.o(292927);
    return i;
  }
  
  public final void hAa()
  {
    AppMethodBeat.i(43258);
    pp(this.hxx | 0x80);
    AppMethodBeat.o(43258);
  }
  
  public final void hAb()
  {
    AppMethodBeat.i(43259);
    pp(this.hxx & 0xFFFFFF7F);
    AppMethodBeat.o(43259);
  }
  
  public final boolean hAc()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ((this.hxx & 0x80) == 0)
    {
      bool1 = bool2;
      if ((this.hxx & 0x300) == 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final boolean hAd()
  {
    return (this.hxx & 0x2000) > 0;
  }
  
  public final void hAe()
  {
    AppMethodBeat.i(240095);
    pp(this.hxx | 0x2000);
    AppMethodBeat.o(240095);
  }
  
  public final void hAf()
  {
    AppMethodBeat.i(240097);
    pp(this.hxx & 0xFFFFDFFF);
    AppMethodBeat.o(240097);
  }
  
  public final boolean hAg()
  {
    return (this.hxx & 0x1000) > 0;
  }
  
  public final void hAh()
  {
    AppMethodBeat.i(43262);
    pp(this.hxx & 0xFFFFFFBF);
    AppMethodBeat.o(43262);
  }
  
  public final void hAi()
  {
    AppMethodBeat.i(43263);
    pp(this.hxx | 0x40);
    AppMethodBeat.o(43263);
  }
  
  public final boolean hAj()
  {
    return (this.hxx & 0x40) != 0;
  }
  
  public final boolean hAk()
  {
    AppMethodBeat.i(43265);
    if ((!Util.isNullOrNil(this.hxy)) && (this.hxy.contains("notify@all"))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43265);
      return bool;
    }
  }
  
  public final boolean hAl()
  {
    AppMethodBeat.i(240112);
    if ((!Util.isNullOrNil(this.hxy)) && (this.hxy.contains("announcement@all"))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(240112);
      return bool;
    }
  }
  
  public final String hAm()
  {
    AppMethodBeat.i(43271);
    if (!hzx())
    {
      AppMethodBeat.o(43271);
      return "";
    }
    if (this.VGC == null) {
      hAn();
    }
    String str = this.VGC;
    AppMethodBeat.o(43271);
    return str;
  }
  
  public final com.tencent.mm.bc.a hAn()
  {
    AppMethodBeat.i(43272);
    Log.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    Object localObject = this.field_content;
    if (super.getType() == 268445458) {
      localObject = this.ilz;
    }
    localObject = a.a.b(XmlParser.parseXml((String)localObject, "sysmsg", null), this);
    if (localObject != null)
    {
      Log.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { localObject });
      ((com.tencent.mm.bc.a)localObject).bnL();
      this.VGC = ((com.tencent.mm.bc.a)localObject).lWh;
    }
    for (;;)
    {
      AppMethodBeat.o(43272);
      return localObject;
      Log.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    }
  }
  
  public final boolean hwA()
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
  
  public final boolean hwF()
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
  
  public final boolean hwG()
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
  
  public final boolean hwH()
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
  
  public final boolean hzA()
  {
    AppMethodBeat.i(240015);
    if ((super.getType() == 10000) || (super.getType() == 10002) || (super.getType() == 570425393) || (super.getType() == 64) || (super.getType() == 603979825) || (super.getType() == 889192497) || (super.getType() == 922746929))
    {
      AppMethodBeat.o(240015);
      return true;
    }
    AppMethodBeat.o(240015);
    return false;
  }
  
  public final boolean hzB()
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
  
  public final boolean hzC()
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
  
  public final boolean hzD()
  {
    AppMethodBeat.i(240025);
    if (super.getType() == 855638065)
    {
      AppMethodBeat.o(240025);
      return true;
    }
    AppMethodBeat.o(240025);
    return false;
  }
  
  public final boolean hzE()
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
  
  public final boolean hzF()
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
  
  public final boolean hzG()
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
  
  public final boolean hzH()
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
  
  public final boolean hzI()
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
  
  public final boolean hzJ()
  {
    AppMethodBeat.i(240041);
    if (super.getType() == 1090519089)
    {
      AppMethodBeat.o(240041);
      return true;
    }
    AppMethodBeat.o(240041);
    return false;
  }
  
  public final boolean hzK()
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
  
  public final boolean hzL()
  {
    AppMethodBeat.i(240047);
    if ((super.getType() == 889192497) || (super.getType() == 922746929))
    {
      AppMethodBeat.o(240047);
      return true;
    }
    AppMethodBeat.o(240047);
    return false;
  }
  
  public final boolean hzM()
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
  
  public final boolean hzN()
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
  
  public final boolean hzO()
  {
    AppMethodBeat.i(43246);
    if ((abP()) && (!Util.isNullOrNil(this.field_transContent)))
    {
      AppMethodBeat.o(43246);
      return true;
    }
    AppMethodBeat.o(43246);
    return false;
  }
  
  public final boolean hzQ()
  {
    return (this.hxx & 0x200) > 0;
  }
  
  public final void hzR()
  {
    AppMethodBeat.i(43251);
    pp(this.hxx | 0x200);
    AppMethodBeat.o(43251);
  }
  
  public final void hzS()
  {
    AppMethodBeat.i(178875);
    pp(this.hxx | 0x800);
    AppMethodBeat.o(178875);
  }
  
  public final int hzT()
  {
    return this.hxx & 0x4;
  }
  
  public final void hzU()
  {
    AppMethodBeat.i(240074);
    pp(this.hxx | 0x4);
    AppMethodBeat.o(240074);
  }
  
  public final void hzV()
  {
    AppMethodBeat.i(43253);
    pp(this.hxx | 0x8);
    AppMethodBeat.o(43253);
  }
  
  public final boolean hzW()
  {
    AppMethodBeat.i(43254);
    if ((hzO()) && ((this.hxx & 0x10) > 0))
    {
      AppMethodBeat.o(43254);
      return true;
    }
    AppMethodBeat.o(43254);
    return false;
  }
  
  public final void hzX()
  {
    AppMethodBeat.i(43255);
    if (!hzO())
    {
      AppMethodBeat.o(43255);
      return;
    }
    pp(this.hxx | 0x10);
    AppMethodBeat.o(43255);
  }
  
  public final void hzY()
  {
    AppMethodBeat.i(43256);
    if (!hzO())
    {
      AppMethodBeat.o(43256);
      return;
    }
    pp(this.hxx & 0xFFFFFFEF);
    AppMethodBeat.o(43256);
  }
  
  public final boolean hzZ()
  {
    AppMethodBeat.i(43257);
    if ((hzO()) && ((this.hxx & 0x400) > 0))
    {
      AppMethodBeat.o(43257);
      return true;
    }
    AppMethodBeat.o(43257);
    return false;
  }
  
  public final boolean hzq()
  {
    AppMethodBeat.i(43220);
    if ((super.getType() == 486539313) && (this.VGA) && (this.VGz != null))
    {
      AppMethodBeat.o(43220);
      return true;
    }
    AppMethodBeat.o(43220);
    return false;
  }
  
  public final boolean hzr()
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
  
  public final boolean hzs()
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
  
  public final boolean hzt()
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
  
  public final boolean hzu()
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
  
  public final boolean hzv()
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
  
  public final boolean hzw()
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
  
  public final boolean hzx()
  {
    AppMethodBeat.i(43228);
    if ((super.getType() == 10002) || (super.getType() == 268445458))
    {
      AppMethodBeat.o(43228);
      return true;
    }
    AppMethodBeat.o(43228);
    return false;
  }
  
  public final boolean hzy()
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
  
  @Deprecated
  public final boolean hzz()
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
  
  public final boolean isOmittedFailResend()
  {
    return (this.hxx & 0x20) > 0;
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(43248);
    super.setStatus(paramInt);
    Object localObject;
    if ((this.field_isSend == 1) && (hzP()))
    {
      if (this.field_status == 5)
      {
        Log.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()), this.field_talker, Util.getStack() });
        localObject = new va();
        ((va)localObject).fUo.fvt = this;
        EventCenter.instance.publish((IEvent)localObject);
        AppMethodBeat.o(43248);
        return;
      }
      if (this.field_status == 2)
      {
        Log.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()) });
        localObject = new vc();
        ((vc)localObject).fUq.fvt = this;
        EventCenter.instance.publish((IEvent)localObject);
        AppMethodBeat.o(43248);
      }
    }
    else if (this.field_isSend == 0)
    {
      localObject = new rs();
      ((rs)localObject).fQU.fvt = this;
      EventCenter.instance.publish((IEvent)localObject);
    }
    AppMethodBeat.o(43248);
  }
  
  public final void unsetOmittedFailResend()
  {
    AppMethodBeat.i(43252);
    if (isOmittedFailResend()) {
      pp(this.hxx & 0xFFFFFFDF);
    }
    AppMethodBeat.o(43252);
  }
  
  public static final class a
  {
    public String GXB = "";
    public long GZN = 0L;
    public int PKJ = 0;
    public String RpW = "";
    public int VGF = 0;
    public String VGG = "";
    public String VGH = "";
    public String VGI = "";
    public String VGJ = "";
    public String VGK = "";
    public String VGL = "";
    public String VGM = "";
    public String VGN = "";
    private String city;
    public String fcC = "";
    private String hDn = "";
    public String idS = "";
    public String mTO = "";
    public String mXp = "";
    public String mXq = "";
    public String mXr = "";
    public String mXu = "";
    public String nickname = "";
    private String province;
    public int scene = 0;
    public int sex;
    public String signature;
    private String source = "";
    public String verifyInfo = "";
    
    public static a bwZ(String paramString)
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
          locala.fcC = ((String)((Map)localObject).get(".msg.$username"));
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
        locala.idS = ((String)((Map)localObject).get(".msg.$alias"));
        locala.mXq = ((String)((Map)localObject).get(".msg.$fullpy"));
        locala.mXp = ((String)((Map)localObject).get(".msg.$shortpy"));
        locala.source = ((String)((Map)localObject).get(".msg.$source"));
        locala.VGF = Util.getInt((String)((Map)localObject).get(".msg.$imagestatus"), 0);
        locala.scene = Util.getInt((String)((Map)localObject).get(".msg.$scene"), 0);
        locala.VGG = ((String)((Map)localObject).get(".msg.$mobileidentify"));
        locala.VGH = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
        if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
          locala.GZN = Util.getLong((String)((Map)localObject).get(".msg.$qqnum"), 0L);
        }
        locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
        if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
          locala.sex = Util.getInt((String)((Map)localObject).get(".msg.$sex"), 0);
        }
        locala.city = ((String)((Map)localObject).get(".msg.$city"));
        locala.province = ((String)((Map)localObject).get(".msg.$province"));
        locala.mXr = ((String)((Map)localObject).get(".msg.$qqnickname"));
        locala.mXu = ((String)((Map)localObject).get(".msg.$qqremark"));
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
          continue;
        }
        paramString = "0";
        locala.PKJ = Util.getInt(paramString, 0);
        locala.verifyInfo = Util.nullAsNil((String)((Map)localObject).get(".msg.$certinfo"));
        locala.GXB = Util.nullAsNil((String)((Map)localObject).get(".msg.$brandIconUrl"));
        locala.hDn = Util.nullAsNil((String)((Map)localObject).get(".msg.$regionCode"));
        locala.VGI = Util.nullAsNil((String)((Map)localObject).get(".msg.$bigheadimgurl"));
        locala.VGJ = Util.nullAsNil((String)((Map)localObject).get(".msg.$smallheadimgurl"));
        locala.mTO = Util.nullAsNil((String)((Map)localObject).get(".msg.$googlecontact"));
        locala.RpW = Util.nullAsNil((String)((Map)localObject).get(".msg.$antispamticket"));
        locala.VGK = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimappid"));
        locala.VGL = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimdesc"));
        locala.VGM = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimdescicon"));
        locala.VGN = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimcustominfo"));
        if (as.bvK(locala.fcC)) {
          locala.RpW = Util.nullAsNil((String)((Map)localObject).get(".msg.$ticket"));
        }
        Log.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.fcC, locala.RpW, locala.VGI, locala.VGJ });
        AppMethodBeat.o(43202);
        return locala;
        locala.fcC = ((String)((Map)localObject).get(".msg.$fromusername"));
      }
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43205);
      Object localObject;
      if (!Util.isNullOrNil(this.hDn))
      {
        localObject = this.hDn.split("_");
        if (localObject.length > 0)
        {
          if (localObject.length <= 2) {
            break label71;
          }
          RegionCodeDecoder.hAC();
          this.city = RegionCodeDecoder.bn(localObject[0], localObject[1], localObject[2]);
        }
      }
      for (;;)
      {
        localObject = this.city;
        AppMethodBeat.o(43205);
        return localObject;
        label71:
        if (localObject.length == 2)
        {
          RegionCodeDecoder.hAC();
          this.city = RegionCodeDecoder.nO(localObject[0], localObject[1]);
        }
        else
        {
          this.city = "";
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
      if (!TextUtils.isEmpty(this.idS))
      {
        str = this.idS;
        AppMethodBeat.o(43203);
        return str;
      }
      Log.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = Util.nullAsNil(this.fcC);
      AppMethodBeat.o(43203);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43206);
      Object localObject;
      if (!Util.isNullOrNil(this.hDn))
      {
        localObject = this.hDn.split("_");
        if (localObject.length > 0)
        {
          if ((localObject.length <= 2) || (!RegionCodeDecoder.bxn(localObject[0]))) {
            break label77;
          }
          RegionCodeDecoder.hAC();
        }
      }
      for (this.province = RegionCodeDecoder.nO(localObject[0], localObject[1]);; this.province = RegionCodeDecoder.bxp(localObject[0]))
      {
        localObject = this.province;
        AppMethodBeat.o(43206);
        return localObject;
        label77:
        RegionCodeDecoder.hAC();
      }
    }
    
    public final int getScene()
    {
      return this.scene;
    }
    
    public final String hAo()
    {
      return this.fcC;
    }
    
    public final String hAp()
    {
      AppMethodBeat.i(43204);
      if ((this.mXu != null) && (this.mXu.length() > 0))
      {
        str = this.mXu;
        AppMethodBeat.o(43204);
        return str;
      }
      if ((this.mXr != null) && (this.mXr.length() > 0))
      {
        str = this.mXr;
        AppMethodBeat.o(43204);
        return str;
      }
      String str = Long.toString(this.GZN);
      AppMethodBeat.o(43204);
      return str;
    }
  }
  
  public static final class b
  {
    public double Ejn = 0.0D;
    public double Ejo = 0.0D;
    public String Eju = "";
    public String QSw = "";
    public String VGO = "";
    public String VGP = null;
    public String VGQ = null;
    public String VGR = null;
    public int fKJ = 0;
    public String fcC = "";
    public String label = "";
    public String poiName = "";
    
    public static b bxa(String paramString)
    {
      AppMethodBeat.i(43208);
      b localb = new b();
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString != null)
      {
        localb.fcC = Util.nullAs((String)paramString.get(".msg.location.$fromusername"), "");
        localb.Ejn = Util.safeParseDouble((String)paramString.get(".msg.location.$x"));
        localb.Ejo = Util.safeParseDouble((String)paramString.get(".msg.location.$y"));
        localb.label = Util.nullAs((String)paramString.get(".msg.location.$label"), "");
        localb.VGO = Util.nullAs((String)paramString.get(".msg.location.$maptype"), "");
        localb.fKJ = Util.safeParseInt((String)paramString.get(".msg.location.$scale"));
        localb.VGR = Util.nullAs((String)paramString.get(".msg.location.$localLocationen"), "");
        localb.VGP = Util.nullAs((String)paramString.get(".msg.location.$localLocationcn"), "");
        localb.VGQ = Util.nullAs((String)paramString.get(".msg.location.$localLocationtw"), "");
        localb.poiName = Util.nullAs((String)paramString.get(".msg.location.$poiname"), "");
        localb.QSw = Util.nullAs((String)paramString.get(".msg.location.$infourl"), "");
        localb.Eju = Util.nullAs((String)paramString.get(".msg.location.$poiid"), "");
      }
      AppMethodBeat.o(43208);
      return localb;
    }
    
    public final boolean hAq()
    {
      AppMethodBeat.i(43209);
      if ((this.poiName != null) && (!this.poiName.equals("")) && (!this.poiName.equals("[位置]")))
      {
        AppMethodBeat.o(43209);
        return true;
      }
      AppMethodBeat.o(43209);
      return false;
    }
    
    public final boolean hAr()
    {
      AppMethodBeat.i(43210);
      if ((Math.abs(this.Ejo) > 180.0D) || (Math.abs(this.Ejn) > 90.0D))
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
      String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.Ejn * 1000000.0D)), Integer.valueOf((int)(this.Ejo * 1000000.0D)), Integer.valueOf(this.fKJ) });
      AppMethodBeat.o(43207);
      return str;
    }
  }
  
  public static final class c
  {
    public String Hls;
    public String VGS = "";
    public String content = "";
    public String lZa = "";
    public String title = "";
    public boolean wSL = false;
    
    public static c bxb(String paramString)
    {
      AppMethodBeat.i(43211);
      c localc = new c();
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString != null) {}
      try
      {
        localc.title = ((String)paramString.get(".msg.pushmail.content.subject"));
        localc.content = ((String)paramString.get(".msg.pushmail.content.digest"));
        localc.lZa = ((String)paramString.get(".msg.pushmail.content.sender"));
        localc.VGS = ((String)paramString.get(".msg.pushmail.waplink"));
        localc.wSL = Util.nullAsNil((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
        localc.Hls = ((String)paramString.get(".msg.pushmail.mailid"));
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
      return this.lZa;
    }
    
    public final String getTitle()
    {
      return this.title;
    }
  }
  
  public static final class d
  {
    public String BLy;
    public long GZN = 0L;
    public int VGF = 0;
    public String VGG = "";
    public String VGH = "";
    public String VGI = "";
    public String VGJ = "";
    public int VGT = 0;
    public String VGU;
    public String VGV;
    public int VGW;
    public String VGX;
    public String VGY;
    public String VGZ;
    public String VHa;
    public String chatroomName = "";
    private String cityCode;
    public String content = "";
    private String countryCode;
    public int fDn;
    public String fcC = "";
    public String idS = "";
    public String mTO;
    public String mXp = "";
    public String mXq = "";
    public String mXr = "";
    private String mXu = "";
    public String nickname = "";
    private String provinceCode;
    public int scene = 0;
    public int sex;
    public String signature;
    public String sourceNickName;
    public String sourceUserName;
    
    public static d bxc(String paramString)
    {
      AppMethodBeat.i(43212);
      d locald = new d();
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString != null) {}
      try
      {
        locald.fcC = ((String)paramString.get(".msg.$fromusername"));
        locald.idS = ((String)paramString.get(".msg.$alias"));
        locald.nickname = ((String)paramString.get(".msg.$fromnickname"));
        locald.mXq = ((String)paramString.get(".msg.$fullpy"));
        locald.mXp = ((String)paramString.get(".msg.$shortpy"));
        locald.content = ((String)paramString.get(".msg.$content"));
        locald.VGF = Util.getInt((String)paramString.get(".msg.$imagestatus"), 0);
        locald.scene = Util.getInt((String)paramString.get(".msg.$scene"), 0);
        locald.VGG = ((String)paramString.get(".msg.$mhash"));
        locald.VGH = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          locald.GZN = Util.getLong((String)paramString.get(".msg.$qqnum"), 0L);
        }
        locald.mXr = ((String)paramString.get(".msg.$qqnickname"));
        locald.mXu = ((String)paramString.get(".msg.$qqremark"));
        locald.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          locald.sex = Util.getInt((String)paramString.get(".msg.$sex"), 0);
        }
        locald.cityCode = ((String)paramString.get(".msg.$city"));
        locald.provinceCode = ((String)paramString.get(".msg.$province"));
        locald.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          locald.VGT = Util.getInt((String)paramString.get(".msg.$snsflag"), 0);
          locald.VGU = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        locald.BLy = ((String)paramString.get(".msg.$ticket"));
        Log.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { locald.BLy });
        locald.VGI = Util.nullAsNil((String)paramString.get(".msg.$bigheadimgurl"));
        locald.VGJ = Util.nullAsNil((String)paramString.get(".msg.$smallheadimgurl"));
        locald.fDn = Util.getInt((String)paramString.get(".msg.$opcode"), 0);
        locald.VGV = Util.nullAsNil((String)paramString.get(".msg.$encryptusername"));
        locald.mTO = Util.nullAsNil((String)paramString.get(".msg.$googlecontact"));
        Log.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { locald.fcC, locald.VGI, locald.VGJ });
        locald.chatroomName = Util.nullAsNil((String)paramString.get(".msg.$chatroomusername"));
        locald.sourceUserName = ((String)paramString.get(".msg.$sourceusername"));
        locald.sourceNickName = ((String)paramString.get(".msg.$sourcenickname"));
        locald.VGZ = ((String)paramString.get(".msg.$sharecardusername"));
        locald.VHa = ((String)paramString.get(".msg.$sharecardnickname"));
        locald.VGW = Util.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (locald.VGW == 1)
        {
          locald.VGX = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          locald.VGY = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
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
    
    public final String apf()
    {
      return this.idS;
    }
    
    public final String aph()
    {
      return this.mXp;
    }
    
    public final String api()
    {
      return this.mXq;
    }
    
    public final int apt()
    {
      return this.sex;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43214);
      if ((!Util.isNullOrNil(this.countryCode)) && (!Util.isNullOrNil(this.provinceCode)))
      {
        if (Util.isNullOrNil(this.cityCode))
        {
          RegionCodeDecoder.hAC();
          str = RegionCodeDecoder.nO(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43214);
          return str;
        }
        RegionCodeDecoder.hAC();
        str = RegionCodeDecoder.bn(this.countryCode, this.provinceCode, this.cityCode);
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
      String str = this.fcC;
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
        if ((!Util.isNullOrNil(this.provinceCode)) && (!Util.isNullOrNil(this.cityCode)) && (RegionCodeDecoder.bxn(this.countryCode)))
        {
          RegionCodeDecoder.hAC();
          str = RegionCodeDecoder.nO(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43215);
          return str;
        }
        RegionCodeDecoder.hAC();
        str = RegionCodeDecoder.bxp(this.countryCode);
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
    
    public final String hAo()
    {
      return this.fcC;
    }
    
    public final String hAs()
    {
      return this.BLy;
    }
    
    public final String hAt()
    {
      return this.VGV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.ca
 * JD-Core Version:    0.7.0.1
 */