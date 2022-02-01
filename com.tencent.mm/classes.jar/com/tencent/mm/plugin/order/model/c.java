package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  public List<j> oEg;
  private List<a> wSb;
  
  public c()
  {
    AppMethodBeat.i(66661);
    this.oEg = new ArrayList();
    this.wSb = new ArrayList();
    loadFromDB();
    dBu();
    dBt();
    dBv();
    AppMethodBeat.o(66661);
  }
  
  private boolean a(j paramj)
  {
    AppMethodBeat.i(66667);
    if (paramj == null)
    {
      AppMethodBeat.o(66667);
      return false;
    }
    int i = 0;
    while (i < this.wSb.size())
    {
      a locala = (a)this.wSb.get(i);
      if (paramj.msgId.equals(locala.field_msgId))
      {
        this.wSb.remove(locala);
        com.tencent.mm.plugin.order.a.b.dBo();
        boolean bool = com.tencent.mm.plugin.order.a.b.dBq().delete(locala, new String[0]);
        AppMethodBeat.o(66667);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(66667);
    return false;
  }
  
  public static j avn(String paramString)
  {
    AppMethodBeat.i(66665);
    Map localMap = bx.M(paramString, "sysmsg");
    if (localMap == null)
    {
      AppMethodBeat.o(66665);
      return null;
    }
    j localj = new j();
    localj.wTs = ((String)localMap.get(".sysmsg.paymsg.PayMsgType"));
    localj.wTt = ((String)localMap.get(".sysmsg.paymsg.Brief.IconUrl"));
    localj.wTu = ((String)localMap.get(".sysmsg.paymsg.Brief.CreateTime"));
    localj.wTv = ((String)localMap.get(".sysmsg.paymsg.StatusSection.IconUrl"));
    localj.wTw = ((String)localMap.get(".sysmsg.paymsg.StatusSection.StatusDesc"));
    localj.dEU = ((String)localMap.get(".sysmsg.paymsg.StatusSection.Content"));
    localj.wTx = ((String)localMap.get(".sysmsg.paymsg.StatusSection.JumpUrl"));
    localj.wTy = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppUserName"));
    localj.wTi = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppNickName"));
    localj.wTz = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppTelephone"));
    int i = 0;
    if (i == 0) {
      paramString = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button.Name");
    }
    for (String str = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button.JumpUrl");; str = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button" + i + ".JumpUrl"))
    {
      if (TextUtils.isEmpty(paramString)) {
        break label367;
      }
      localObject = new j.a();
      ((j.a)localObject).name = paramString;
      ((j.a)localObject).jumpUrl = str;
      if (localj.wTA == null) {
        localj.wTA = new ArrayList();
      }
      localj.wTA.add(localObject);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button" + i + ".Name");
    }
    label367:
    i = 0;
    if (i == 0)
    {
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection.Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection.Value");
    }
    for (Object localObject = (String)localMap.get(".sysmsg.paymsg.NormalSection.JumpUrl");; localObject = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".JumpUrl"))
    {
      if (TextUtils.isEmpty(paramString)) {
        break label585;
      }
      j.b localb = new j.b();
      localb.name = paramString;
      localb.value = str;
      localb.jumpUrl = ((String)localObject);
      if (localj.wTB == null) {
        localj.wTB = new ArrayList();
      }
      localj.wTB.add(localb);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
    }
    label585:
    AppMethodBeat.o(66665);
    return localj;
  }
  
  private void dBt()
  {
    AppMethodBeat.i(66664);
    if ((this.oEg == null) || (this.oEg.size() == 0))
    {
      AppMethodBeat.o(66664);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.oEg);
    int i = 0;
    while (i < localArrayList.size())
    {
      j localj = (j)localArrayList.get(i);
      if ((localj.wTs != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.wTs)))
      {
        int j = bu.getInt(localj.wTs, 0);
        if ((j != 2) && (j != 1)) {
          avo(localj.msgId);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66664);
  }
  
  private void dBu()
  {
    AppMethodBeat.i(66668);
    int i = 0;
    while (i < this.wSb.size())
    {
      a locala = (a)this.wSb.get(i);
      String str = locala.field_msgContentXml;
      j localj = avn(str);
      localj.msgId = locala.field_msgId;
      this.oEg.add(localj);
      ae.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
      i += 1;
    }
    AppMethodBeat.o(66668);
  }
  
  private void loadFromDB()
  {
    AppMethodBeat.i(66663);
    com.tencent.mm.plugin.order.a.b.dBo();
    Cursor localCursor = com.tencent.mm.plugin.order.a.b.dBq().getAll();
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      localCursor.moveToFirst();
      int i = localCursor.getColumnIndex("msgId");
      int j = localCursor.getColumnIndex("msgContentXml");
      int k = localCursor.getColumnIndex("isRead");
      while (!localCursor.isAfterLast())
      {
        a locala = new a();
        locala.field_msgId = localCursor.getString(i);
        locala.field_msgContentXml = localCursor.getString(j);
        locala.field_isRead = localCursor.getString(k);
        localCursor.moveToNext();
        this.wSb.add(locala);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(66663);
  }
  
  public final void a(j paramj, String paramString1, String paramString2)
  {
    AppMethodBeat.i(66662);
    if ((paramj == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(66662);
      return;
    }
    a locala = new a();
    locala.field_msgId = paramj.msgId;
    locala.field_msgContentXml = paramString1;
    locala.field_isRead = paramString2;
    com.tencent.mm.plugin.order.a.b.dBo();
    if (!com.tencent.mm.plugin.order.a.b.dBq().a(locala)) {
      ae.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + paramj.msgId);
    }
    this.wSb.add(locala);
    AppMethodBeat.o(66662);
  }
  
  public final boolean avo(String paramString)
  {
    AppMethodBeat.i(66666);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66666);
      return false;
    }
    paramString = avq(paramString);
    if (paramString != null)
    {
      this.oEg.remove(paramString);
      a(paramString);
      AppMethodBeat.o(66666);
      return true;
    }
    AppMethodBeat.o(66666);
    return false;
  }
  
  public final boolean avp(String paramString)
  {
    AppMethodBeat.i(66669);
    if ((this.oEg == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66669);
      return false;
    }
    int i = 0;
    while (i < this.oEg.size())
    {
      j localj = (j)this.oEg.get(i);
      if ((localj != null) && (localj.msgId.equals(paramString)))
      {
        AppMethodBeat.o(66669);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66669);
    return false;
  }
  
  public final j avq(String paramString)
  {
    AppMethodBeat.i(66670);
    if ((this.oEg == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66670);
      return null;
    }
    int i = 0;
    while (i < this.oEg.size())
    {
      j localj = (j)this.oEg.get(i);
      if (paramString.equals(localj.msgId))
      {
        AppMethodBeat.o(66670);
        return localj;
      }
      i += 1;
    }
    AppMethodBeat.o(66670);
    return null;
  }
  
  public final a avr(String paramString)
  {
    AppMethodBeat.i(66671);
    if ((this.wSb == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66671);
      return null;
    }
    int i = 0;
    while (i < this.wSb.size())
    {
      a locala = (a)this.wSb.get(i);
      if (paramString.equals(locala.field_msgId))
      {
        AppMethodBeat.o(66671);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(66671);
    return null;
  }
  
  public final void dBv()
  {
    AppMethodBeat.i(66672);
    int i = dBw();
    g.ajS();
    g.ajR().ajA().set(204820, Integer.valueOf(i));
    ae.v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(i)));
    AppMethodBeat.o(66672);
  }
  
  public final int dBw()
  {
    AppMethodBeat.i(66673);
    if ((this.wSb == null) || (this.wSb.size() == 0))
    {
      AppMethodBeat.o(66673);
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.wSb.size(); j = k)
    {
      a locala = (a)this.wSb.get(i);
      k = j;
      if (locala != null)
      {
        k = j;
        if ("0".equals(locala.field_isRead)) {
          k = j + 1;
        }
      }
      i += 1;
    }
    ae.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:".concat(String.valueOf(j)));
    AppMethodBeat.o(66673);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.c
 * JD-Core Version:    0.7.0.1
 */