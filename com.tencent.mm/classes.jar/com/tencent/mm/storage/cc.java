package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.th;
import com.tencent.mm.autogen.a.wq;
import com.tencent.mm.autogen.a.ws;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.ax.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.ab;
import com.tencent.mm.model.bt;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import junit.framework.Assert;

public class cc
  extends ab
{
  public static String adko = "voip_content_voice";
  public static String adkp = "voip_content_video";
  private b adkq;
  private e adkr;
  public jz adks;
  public boolean adkt;
  public boolean adku;
  private String adkv;
  public boolean hS;
  public String sessionId;
  
  public cc()
  {
    this.adks = null;
    this.adkt = false;
    this.adku = false;
    this.hS = false;
  }
  
  public cc(String paramString)
  {
    AppMethodBeat.i(43216);
    this.adks = null;
    this.adkt = false;
    this.adku = false;
    this.hS = false;
    super.BS(paramString);
    AppMethodBeat.o(43216);
  }
  
  private static boolean aDO()
  {
    AppMethodBeat.i(43261);
    String str = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("TranslateMsgOff");
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
  
  public static cc bI(cc paramcc)
  {
    AppMethodBeat.i(43247);
    if (paramcc == null)
    {
      Log.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
      AppMethodBeat.o(43247);
      return null;
    }
    cc localcc = new cc();
    localcc.setMsgId(paramcc.field_msgId);
    localcc.gX(paramcc.field_msgSvrId);
    localcc.setType(paramcc.getType());
    localcc.setStatus(paramcc.field_status);
    localcc.pI(paramcc.field_isSend);
    localcc.pV(paramcc.aJJ());
    localcc.setCreateTime(paramcc.getCreateTime());
    localcc.BS(paramcc.field_talker);
    localcc.setContent(paramcc.field_content);
    localcc.BT(paramcc.field_imgPath);
    localcc.BU(paramcc.field_reserved);
    localcc.ah(paramcc.aJN());
    localcc.BV(paramcc.field_transContent);
    localcc.Ca(paramcc.kLg);
    localcc.po(paramcc.jUq);
    localcc.AU(paramcc.jUr);
    AppMethodBeat.o(43247);
    return localcc;
  }
  
  public static boolean cI(Map<String, String> paramMap)
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
  
  public static boolean cJ(Map<String, String> paramMap)
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
  
  private boolean jbU()
  {
    AppMethodBeat.i(43249);
    if ((!iYl()) && (!fxT()) && (!jbB()))
    {
      AppMethodBeat.o(43249);
      return true;
    }
    AppMethodBeat.o(43249);
    return false;
  }
  
  private b jbq()
  {
    AppMethodBeat.i(248444);
    try
    {
      if (this.adkq == null)
      {
        this.adkq = new b();
        localObject1 = XmlParser.parseXml(this.field_content, "sysmsg", null);
        this.adkq.adkH = ((String)((Map)localObject1).get(".sysmsg.sysmsgtemplate.content_template.link_list.link2.msgcount"));
      }
      label55:
      Object localObject1 = this.adkq;
      AppMethodBeat.o(248444);
      return localObject1;
    }
    finally
    {
      break label55;
    }
  }
  
  private e jbs()
  {
    AppMethodBeat.i(248446);
    try
    {
      if (this.adkr == null)
      {
        this.adkr = new e();
        this.adkr.adkN = this.jUr.contains("<share_msg>");
        if (this.adkr.adkN) {
          this.adkr.createTime = bt.JT(this.jUr);
        }
      }
      label65:
      e locale = this.adkr;
      AppMethodBeat.o(248446);
      return locale;
    }
    finally
    {
      break label65;
    }
  }
  
  public static void zd(long paramLong)
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
  
  public final void AU(String paramString)
  {
    AppMethodBeat.i(248457);
    super.AU(paramString);
    this.adkr = null;
    AppMethodBeat.o(248457);
  }
  
  public final String aJO()
  {
    AppMethodBeat.i(248461);
    String str2 = super.aJO();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      if (this.field_isSend != 1) {
        break label53;
      }
    }
    label53:
    for (str1 = (String)h.baE().ban().d(2, "");; str1 = this.field_talker)
    {
      AppMethodBeat.o(248461);
      return str1;
    }
  }
  
  public final String aJP()
  {
    AppMethodBeat.i(248463);
    String str2 = super.aJP();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      if (this.field_isSend != 1) {
        break label41;
      }
    }
    label41:
    for (str1 = this.field_talker;; str1 = (String)h.baE().ban().d(2, ""))
    {
      AppMethodBeat.o(248463);
      return str1;
    }
  }
  
  public final void ayZ(int paramInt)
  {
    AppMethodBeat.i(43260);
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      AppMethodBeat.o(43260);
      return;
    }
    po(this.jUq | paramInt);
    AppMethodBeat.o(43260);
  }
  
  public final boolean byr(String paramString)
  {
    AppMethodBeat.i(43264);
    if ((!Util.isNullOrNil(this.jUr)) && (!Util.isNullOrNil(paramString)))
    {
      Object localObject = XmlParser.parseXml(this.jUr, "msgsource", null);
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
      localStringBuilder.append("Very big message: \nmsgId = ").append(l).append('\n').append("msgSvrId = ").append(this.field_msgSvrId).append('\n').append("type = ").append(super.getType()).append('\n').append("createTime = ").append(getCreateTime()).append('\n').append("talker = ").append(this.field_talker).append('\n').append("flag = ").append(this.field_flag).append('\n').append("content.length() = ").append(paramCursor.length()).append('\n').append("content = ").append(paramCursor.substring(0, 256));
      Log.e("MicroMsg.MsgInfo", localStringBuilder.toString());
      setType(1);
      setContent("");
      paramCursor = bI(this);
      h.baH().postToWorker(new cc.1(this, l, paramCursor));
    }
    zd(this.field_msgId);
    AppMethodBeat.o(43268);
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(43270);
    zd(this.field_msgId);
    ContentValues localContentValues = super.convertTo();
    AppMethodBeat.o(43270);
    return localContentValues;
  }
  
  public final boolean dSH()
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
  
  public final boolean dSI()
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
  
  public final boolean dSJ()
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
  
  public final boolean fxR()
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
  
  public final boolean fxT()
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
  
  public final long getCreateTime()
  {
    AppMethodBeat.i(248459);
    e locale = jbs();
    if ((locale != null) && (locale.adkN))
    {
      l = locale.createTime;
      if (l != -1L)
      {
        AppMethodBeat.o(248459);
        return l;
      }
    }
    long l = super.getCreateTime();
    AppMethodBeat.o(248459);
    return l;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(369611);
    int i = super.getType();
    AppMethodBeat.o(369611);
    return i;
  }
  
  public final boolean iYe()
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
  
  public final boolean iYj()
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
  
  public final boolean iYk()
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
  
  public final boolean iYl()
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
  
  public final boolean isClean()
  {
    return (this.kLj & 0x1) > 0;
  }
  
  public final boolean isOmittedFailResend()
  {
    return (this.jUq & 0x20) > 0;
  }
  
  public final boolean jbA()
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
  
  public final boolean jbB()
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
  
  public final boolean jbC()
  {
    AppMethodBeat.i(248504);
    if (super.getType() == 67)
    {
      AppMethodBeat.o(248504);
      return true;
    }
    AppMethodBeat.o(248504);
    return false;
  }
  
  @Deprecated
  public final boolean jbD()
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
  
  public final boolean jbE()
  {
    AppMethodBeat.i(248515);
    if ((super.getType() == 10000) || (super.getType() == 10002) || (super.getType() == 570425393) || (super.getType() == 64) || (super.getType() == 603979825) || (super.getType() == 889192497) || (super.getType() == 922746929) || (super.getType() == 268445456))
    {
      AppMethodBeat.o(248515);
      return true;
    }
    AppMethodBeat.o(248515);
    return false;
  }
  
  public final boolean jbF()
  {
    AppMethodBeat.i(248519);
    if ((super.getType() == 10000) || (super.getType() == 10002) || (super.getType() == 570425393) || (super.getType() == 64) || (super.getType() == 603979825) || (super.getType() == 889192497) || (super.getType() == 922746929) || (super.getType() == 268445456) || (super.getType() == 268445458) || (super.getType() == -1879048191))
    {
      AppMethodBeat.o(248519);
      return true;
    }
    AppMethodBeat.o(248519);
    return false;
  }
  
  public final boolean jbG()
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
  
  public final boolean jbH()
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
  
  public final boolean jbI()
  {
    AppMethodBeat.i(248536);
    if (super.getType() == 855638065)
    {
      AppMethodBeat.o(248536);
      return true;
    }
    AppMethodBeat.o(248536);
    return false;
  }
  
  public final boolean jbJ()
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
  
  public final boolean jbK()
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
  
  public final boolean jbL()
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
  
  public final boolean jbM()
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
  
  public final boolean jbN()
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
  
  public final boolean jbO()
  {
    AppMethodBeat.i(248563);
    if (super.getType() == 1090519089)
    {
      AppMethodBeat.o(248563);
      return true;
    }
    AppMethodBeat.o(248563);
    return false;
  }
  
  public final boolean jbP()
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
  
  public final boolean jbQ()
  {
    AppMethodBeat.i(248573);
    if ((super.getType() == 889192497) || (super.getType() == 922746929))
    {
      AppMethodBeat.o(248573);
      return true;
    }
    AppMethodBeat.o(248573);
    return false;
  }
  
  public final boolean jbR()
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
  
  public final boolean jbS()
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
  
  public final boolean jbT()
  {
    AppMethodBeat.i(43246);
    if ((aDO()) && (!Util.isNullOrNil(this.field_transContent)))
    {
      AppMethodBeat.o(43246);
      return true;
    }
    AppMethodBeat.o(43246);
    return false;
  }
  
  public final boolean jbV()
  {
    return (this.jUq & 0x200) > 0;
  }
  
  public final void jbW()
  {
    AppMethodBeat.i(43251);
    po(this.jUq | 0x200);
    AppMethodBeat.o(43251);
  }
  
  public final void jbX()
  {
    AppMethodBeat.i(178875);
    po(this.jUq | 0x800);
    AppMethodBeat.o(178875);
  }
  
  public final void jbY()
  {
    AppMethodBeat.i(248613);
    po(this.jUq | 0x4);
    AppMethodBeat.o(248613);
  }
  
  public final void jbZ()
  {
    AppMethodBeat.i(43253);
    po(this.jUq | 0x8);
    AppMethodBeat.o(43253);
  }
  
  public final String jbr()
  {
    AppMethodBeat.i(248455);
    Object localObject = jbq();
    if (localObject != null)
    {
      localObject = ((b)localObject).adkH;
      AppMethodBeat.o(248455);
      return localObject;
    }
    AppMethodBeat.o(248455);
    return "";
  }
  
  public final boolean jbt()
  {
    AppMethodBeat.i(43220);
    if ((super.getType() == 486539313) && (this.adkt) && (this.adks != null))
    {
      AppMethodBeat.o(43220);
      return true;
    }
    AppMethodBeat.o(43220);
    return false;
  }
  
  public final boolean jbu()
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
  
  public final boolean jbv()
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
  
  public final boolean jbw()
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
  
  public final boolean jbx()
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
  
  public final boolean jby()
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
  
  public final boolean jbz()
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
  
  public final boolean jca()
  {
    AppMethodBeat.i(43254);
    if ((jbT()) && ((this.jUq & 0x10) > 0))
    {
      AppMethodBeat.o(43254);
      return true;
    }
    AppMethodBeat.o(43254);
    return false;
  }
  
  public final void jcb()
  {
    AppMethodBeat.i(43255);
    if (!jbT())
    {
      AppMethodBeat.o(43255);
      return;
    }
    po(this.jUq | 0x10);
    AppMethodBeat.o(43255);
  }
  
  public final void jcc()
  {
    AppMethodBeat.i(43256);
    if (!jbT())
    {
      AppMethodBeat.o(43256);
      return;
    }
    po(this.jUq & 0xFFFFFFEF);
    AppMethodBeat.o(43256);
  }
  
  public final boolean jcd()
  {
    AppMethodBeat.i(43257);
    if ((jbT()) && ((this.jUq & 0x400) > 0))
    {
      AppMethodBeat.o(43257);
      return true;
    }
    AppMethodBeat.o(43257);
    return false;
  }
  
  public final void jce()
  {
    AppMethodBeat.i(43258);
    po(this.jUq | 0x80);
    AppMethodBeat.o(43258);
  }
  
  public final void jcf()
  {
    AppMethodBeat.i(43259);
    po(this.jUq & 0xFFFFFF7F);
    AppMethodBeat.o(43259);
  }
  
  public final boolean jcg()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ((this.jUq & 0x80) == 0)
    {
      bool1 = bool2;
      if ((this.jUq & 0x300) == 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final boolean jch()
  {
    return (this.jUq & 0x2000) > 0;
  }
  
  public final void jci()
  {
    AppMethodBeat.i(248658);
    po(this.jUq | 0x2000);
    AppMethodBeat.o(248658);
  }
  
  public final void jcj()
  {
    AppMethodBeat.i(248663);
    po(this.jUq & 0xFFFFDFFF);
    AppMethodBeat.o(248663);
  }
  
  public final boolean jck()
  {
    return (this.jUq & 0x1000) > 0;
  }
  
  public final boolean jcl()
  {
    return (this.jUq & 0x40000) != 0;
  }
  
  public final void jcm()
  {
    AppMethodBeat.i(248673);
    po(this.jUq | 0x80000);
    AppMethodBeat.o(248673);
  }
  
  public final void jcn()
  {
    AppMethodBeat.i(43262);
    po(this.jUq & 0xFFFFFFBF);
    AppMethodBeat.o(43262);
  }
  
  public final void jco()
  {
    AppMethodBeat.i(43263);
    po(this.jUq | 0x40);
    AppMethodBeat.o(43263);
  }
  
  public final boolean jcp()
  {
    return (this.jUq & 0x40) != 0;
  }
  
  public final boolean jcq()
  {
    AppMethodBeat.i(248689);
    if (!Util.isNullOrNil(this.jUr))
    {
      Map localMap = XmlParser.parseXml(this.jUr, "msgsource", null);
      if (localMap == null)
      {
        AppMethodBeat.o(248689);
        return false;
      }
      if (!Util.isNullOrNil((String)localMap.get(".msgsource.watchuser")))
      {
        AppMethodBeat.o(248689);
        return true;
      }
    }
    AppMethodBeat.o(248689);
    return false;
  }
  
  public final boolean jcr()
  {
    AppMethodBeat.i(43265);
    if ((!Util.isNullOrNil(this.jUr)) && (this.jUr.contains("notify@all"))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(43265);
      return bool;
    }
  }
  
  public final boolean jcs()
  {
    AppMethodBeat.i(248693);
    if ((!Util.isNullOrNil(this.jUr)) && (this.jUr.contains("announcement@all"))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(248693);
      return bool;
    }
  }
  
  public final String jct()
  {
    AppMethodBeat.i(43271);
    if (!jbA())
    {
      AppMethodBeat.o(43271);
      return "";
    }
    if (this.adkv == null) {
      jcu();
    }
    String str = this.adkv;
    AppMethodBeat.o(43271);
    return str;
  }
  
  public final com.tencent.mm.ax.a jcu()
  {
    AppMethodBeat.i(43272);
    Log.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    Object localObject = this.field_content;
    if (super.getType() == 268445458) {
      localObject = this.kLy;
    }
    localObject = a.a.b(XmlParser.parseXml((String)localObject, "sysmsg", null), this);
    if (localObject != null)
    {
      Log.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { localObject });
      ((com.tencent.mm.ax.a)localObject).bLy();
      this.adkv = ((com.tencent.mm.ax.a)localObject).oPk;
    }
    for (;;)
    {
      AppMethodBeat.o(43272);
      return localObject;
      Log.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    }
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(43248);
    super.setStatus(paramInt);
    Object localObject;
    if ((this.field_isSend == 1) && (jbU()))
    {
      if (this.field_status == 5)
      {
        Log.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()), this.field_talker, Util.getStack() });
        localObject = new wq();
        ((wq)localObject).ial.hzO = this;
        ((wq)localObject).publish();
        AppMethodBeat.o(43248);
        return;
      }
      if (this.field_status == 2)
      {
        Log.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(super.getType()) });
        localObject = new ws();
        ((ws)localObject).ian.hzO = this;
        ((ws)localObject).publish();
        AppMethodBeat.o(43248);
      }
    }
    else if (this.field_isSend == 0)
    {
      localObject = new th();
      ((th)localObject).hWR.hzO = this;
      ((th)localObject).publish();
    }
    AppMethodBeat.o(43248);
  }
  
  public final void unsetOmittedFailResend()
  {
    AppMethodBeat.i(43252);
    if (isOmittedFailResend()) {
      po(this.jUq & 0xFFFFFFDF);
    }
    AppMethodBeat.o(43252);
  }
  
  public static final class a
  {
    public String MVy = "";
    public long MXS = 0L;
    public int WAW = 0;
    public String Ymm = "";
    public String adkA = "";
    public String adkB = "";
    public String adkC = "";
    public String adkD = "";
    public String adkE = "";
    public String adkF = "";
    public String adkG = "";
    public int adky = 0;
    public String adkz = "";
    private String city;
    public String hgk = "";
    public String kDc = "";
    private String kaj = "";
    public String nickname = "";
    public String pQw = "";
    public String pTX = "";
    public String pTY = "";
    public String pTZ = "";
    public String pUc = "";
    private String province;
    public int scene = 0;
    public int sex;
    public String signature;
    private String source = "";
    public String verifyInfo = "";
    
    public static a bys(String paramString)
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
          locala.hgk = ((String)((Map)localObject).get(".msg.$username"));
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
        locala.kDc = ((String)((Map)localObject).get(".msg.$alias"));
        locala.pTY = ((String)((Map)localObject).get(".msg.$fullpy"));
        locala.pTX = ((String)((Map)localObject).get(".msg.$shortpy"));
        locala.source = ((String)((Map)localObject).get(".msg.$source"));
        locala.adky = Util.getInt((String)((Map)localObject).get(".msg.$imagestatus"), 0);
        locala.scene = Util.getInt((String)((Map)localObject).get(".msg.$scene"), 0);
        locala.adkz = ((String)((Map)localObject).get(".msg.$mobileidentify"));
        locala.adkA = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
        if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
          locala.MXS = Util.getLong((String)((Map)localObject).get(".msg.$qqnum"), 0L);
        }
        locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
        if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
          locala.sex = Util.getInt((String)((Map)localObject).get(".msg.$sex"), 0);
        }
        locala.city = ((String)((Map)localObject).get(".msg.$city"));
        locala.province = ((String)((Map)localObject).get(".msg.$province"));
        locala.pTZ = ((String)((Map)localObject).get(".msg.$qqnickname"));
        locala.pUc = ((String)((Map)localObject).get(".msg.$qqremark"));
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
          continue;
        }
        paramString = "0";
        locala.WAW = Util.getInt(paramString, 0);
        locala.verifyInfo = Util.nullAsNil((String)((Map)localObject).get(".msg.$certinfo"));
        locala.MVy = Util.nullAsNil((String)((Map)localObject).get(".msg.$brandIconUrl"));
        locala.kaj = Util.nullAsNil((String)((Map)localObject).get(".msg.$regionCode"));
        locala.adkB = Util.nullAsNil((String)((Map)localObject).get(".msg.$bigheadimgurl"));
        locala.adkC = Util.nullAsNil((String)((Map)localObject).get(".msg.$smallheadimgurl"));
        locala.pQw = Util.nullAsNil((String)((Map)localObject).get(".msg.$googlecontact"));
        locala.Ymm = Util.nullAsNil((String)((Map)localObject).get(".msg.$antispamticket"));
        locala.adkD = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimappid"));
        locala.adkE = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimdesc"));
        locala.adkF = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimdescicon"));
        locala.adkG = Util.nullAsNil((String)((Map)localObject).get(".msg.$openimcustominfo"));
        if (au.bwO(locala.hgk)) {
          locala.Ymm = Util.nullAsNil((String)((Map)localObject).get(".msg.$ticket"));
        }
        Log.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.hgk, locala.Ymm, locala.adkB, locala.adkC });
        AppMethodBeat.o(43202);
        return locala;
        locala.hgk = ((String)((Map)localObject).get(".msg.$fromusername"));
      }
    }
    
    public final String aJO()
    {
      return this.hgk;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43205);
      Object localObject;
      if (!Util.isNullOrNil(this.kaj))
      {
        localObject = this.kaj.split("_");
        if (localObject.length > 0)
        {
          if (localObject.length <= 2) {
            break label71;
          }
          RegionCodeDecoder.jcF();
          this.city = RegionCodeDecoder.bK(localObject[0], localObject[1], localObject[2]);
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
          RegionCodeDecoder.jcF();
          this.city = RegionCodeDecoder.pM(localObject[0], localObject[1]);
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
      if (!TextUtils.isEmpty(this.kDc))
      {
        str = this.kDc;
        AppMethodBeat.o(43203);
        return str;
      }
      Log.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = Util.nullAsNil(this.hgk);
      AppMethodBeat.o(43203);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43206);
      Object localObject;
      if (!Util.isNullOrNil(this.kaj))
      {
        localObject = this.kaj.split("_");
        if (localObject.length > 0)
        {
          if ((localObject.length <= 2) || (!RegionCodeDecoder.byG(localObject[0]))) {
            break label77;
          }
          RegionCodeDecoder.jcF();
        }
      }
      for (this.province = RegionCodeDecoder.pM(localObject[0], localObject[1]);; this.province = RegionCodeDecoder.byH(localObject[0]))
      {
        localObject = this.province;
        AppMethodBeat.o(43206);
        return localObject;
        label77:
        RegionCodeDecoder.jcF();
      }
    }
    
    public final String jcv()
    {
      AppMethodBeat.i(43204);
      if ((this.pUc != null) && (this.pUc.length() > 0))
      {
        str = this.pUc;
        AppMethodBeat.o(43204);
        return str;
      }
      if ((this.pTZ != null) && (this.pTZ.length() > 0))
      {
        str = this.pTZ;
        AppMethodBeat.o(43204);
        return str;
      }
      String str = Long.toString(this.MXS);
      AppMethodBeat.o(43204);
      return str;
    }
  }
  
  public static final class b
  {
    String adkH;
  }
  
  public static final class c
  {
    public double KbW = 0.0D;
    public double KbX = 0.0D;
    public String Kcd = "";
    public String XOv = "";
    public String adkI = "";
    public String adkJ = null;
    public String adkK = null;
    public String adkL = null;
    public int hQp = 0;
    public String hgk = "";
    public String label = "";
    public String poiName = "";
    
    public static c byt(String paramString)
    {
      AppMethodBeat.i(43208);
      c localc = new c();
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString != null)
      {
        localc.hgk = Util.nullAs((String)paramString.get(".msg.location.$fromusername"), "");
        localc.KbW = Util.safeParseDouble((String)paramString.get(".msg.location.$x"));
        localc.KbX = Util.safeParseDouble((String)paramString.get(".msg.location.$y"));
        localc.label = Util.nullAs((String)paramString.get(".msg.location.$label"), "");
        localc.adkI = Util.nullAs((String)paramString.get(".msg.location.$maptype"), "");
        localc.hQp = Util.safeParseInt((String)paramString.get(".msg.location.$scale"));
        localc.adkL = Util.nullAs((String)paramString.get(".msg.location.$localLocationen"), "");
        localc.adkJ = Util.nullAs((String)paramString.get(".msg.location.$localLocationcn"), "");
        localc.adkK = Util.nullAs((String)paramString.get(".msg.location.$localLocationtw"), "");
        localc.poiName = Util.nullAs((String)paramString.get(".msg.location.$poiname"), "");
        localc.XOv = Util.nullAs((String)paramString.get(".msg.location.$infourl"), "");
        localc.Kcd = Util.nullAs((String)paramString.get(".msg.location.$poiid"), "");
      }
      AppMethodBeat.o(43208);
      return localc;
    }
    
    public final boolean jcw()
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
    
    public final boolean jcx()
    {
      AppMethodBeat.i(43210);
      if ((Math.abs(this.KbX) > 180.0D) || (Math.abs(this.KbW) > 90.0D))
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
      String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.KbW * 1000000.0D)), Integer.valueOf((int)(this.KbX * 1000000.0D)), Integer.valueOf(this.hQp) });
      AppMethodBeat.o(43207);
      return str;
    }
  }
  
  public static final class e
  {
    boolean adkN;
    long createTime;
  }
  
  public static final class f
  {
    public long MXS = 0L;
    public String adkA = "";
    public String adkB = "";
    public String adkC = "";
    public int adkO = 0;
    public String adkP;
    public String adkQ;
    public int adkR;
    public String adkS;
    public String adkT;
    public String adkU;
    public String adkV;
    public int adky = 0;
    public String adkz = "";
    public String chatroomName = "";
    private String cityCode;
    public String content = "";
    private String countryCode;
    public int hId;
    public String hgk = "";
    public String kDc = "";
    public String nickname = "";
    public String pPi;
    public String pQw;
    public String pTX = "";
    public String pTY = "";
    public String pTZ = "";
    private String pUc = "";
    private String provinceCode;
    public int scene = 0;
    public int sex;
    public String signature;
    public String sourceNickName;
    public String sourceUserName;
    
    public static f byv(String paramString)
    {
      AppMethodBeat.i(43212);
      f localf = new f();
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString != null) {}
      try
      {
        localf.hgk = ((String)paramString.get(".msg.$fromusername"));
        localf.kDc = ((String)paramString.get(".msg.$alias"));
        localf.nickname = ((String)paramString.get(".msg.$fromnickname"));
        localf.pTY = ((String)paramString.get(".msg.$fullpy"));
        localf.pTX = ((String)paramString.get(".msg.$shortpy"));
        localf.content = ((String)paramString.get(".msg.$content"));
        localf.adky = Util.getInt((String)paramString.get(".msg.$imagestatus"), 0);
        localf.scene = Util.getInt((String)paramString.get(".msg.$scene"), 0);
        localf.adkz = ((String)paramString.get(".msg.$mhash"));
        localf.adkA = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          localf.MXS = Util.getLong((String)paramString.get(".msg.$qqnum"), 0L);
        }
        localf.pTZ = ((String)paramString.get(".msg.$qqnickname"));
        localf.pUc = ((String)paramString.get(".msg.$qqremark"));
        localf.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          localf.sex = Util.getInt((String)paramString.get(".msg.$sex"), 0);
        }
        localf.cityCode = ((String)paramString.get(".msg.$city"));
        localf.provinceCode = ((String)paramString.get(".msg.$province"));
        localf.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          localf.adkO = Util.getInt((String)paramString.get(".msg.$snsflag"), 0);
          localf.adkP = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        localf.pPi = ((String)paramString.get(".msg.$ticket"));
        Log.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { localf.pPi });
        localf.adkB = Util.nullAsNil((String)paramString.get(".msg.$bigheadimgurl"));
        localf.adkC = Util.nullAsNil((String)paramString.get(".msg.$smallheadimgurl"));
        localf.hId = Util.getInt((String)paramString.get(".msg.$opcode"), 0);
        localf.adkQ = Util.nullAsNil((String)paramString.get(".msg.$encryptusername"));
        localf.pQw = Util.nullAsNil((String)paramString.get(".msg.$googlecontact"));
        Log.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { localf.hgk, localf.adkB, localf.adkC });
        localf.chatroomName = Util.nullAsNil((String)paramString.get(".msg.$chatroomusername"));
        localf.sourceUserName = ((String)paramString.get(".msg.$sourceusername"));
        localf.sourceNickName = ((String)paramString.get(".msg.$sourcenickname"));
        localf.adkU = ((String)paramString.get(".msg.$sharecardusername"));
        localf.adkV = ((String)paramString.get(".msg.$sharecardnickname"));
        localf.adkR = Util.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (localf.adkR == 1)
        {
          localf.adkS = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          localf.adkT = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
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
      return localf;
    }
    
    public final String aJO()
    {
      return this.hgk;
    }
    
    public final String getCity()
    {
      AppMethodBeat.i(43214);
      if ((!Util.isNullOrNil(this.countryCode)) && (!Util.isNullOrNil(this.provinceCode)))
      {
        if (Util.isNullOrNil(this.cityCode))
        {
          RegionCodeDecoder.jcF();
          str = RegionCodeDecoder.pM(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43214);
          return str;
        }
        RegionCodeDecoder.jcF();
        str = RegionCodeDecoder.bK(this.countryCode, this.provinceCode, this.cityCode);
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
      String str = this.hgk;
      AppMethodBeat.o(43213);
      return str;
    }
    
    public final String getProvince()
    {
      AppMethodBeat.i(43215);
      if (!Util.isNullOrNil(this.countryCode))
      {
        if ((!Util.isNullOrNil(this.provinceCode)) && (!Util.isNullOrNil(this.cityCode)) && (RegionCodeDecoder.byG(this.countryCode)))
        {
          RegionCodeDecoder.jcF();
          str = RegionCodeDecoder.pM(this.countryCode, this.provinceCode);
          AppMethodBeat.o(43215);
          return str;
        }
        RegionCodeDecoder.jcF();
        str = RegionCodeDecoder.byH(this.countryCode);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.cc
 * JD-Core Version:    0.7.0.1
 */