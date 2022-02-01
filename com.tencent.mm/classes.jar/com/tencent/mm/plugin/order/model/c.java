package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  private List<a> ANW;
  public List<j> pRP;
  
  public c()
  {
    AppMethodBeat.i(66661);
    this.pRP = new ArrayList();
    this.ANW = new ArrayList();
    loadFromDB();
    eBf();
    eBe();
    eBg();
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
    while (i < this.ANW.size())
    {
      a locala = (a)this.ANW.get(i);
      if (paramj.msgId.equals(locala.field_msgId))
      {
        this.ANW.remove(locala);
        com.tencent.mm.plugin.order.a.b.eBa();
        boolean bool = com.tencent.mm.plugin.order.a.b.eBc().delete(locala, new String[0]);
        AppMethodBeat.o(66667);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(66667);
    return false;
  }
  
  public static j aJA(String paramString)
  {
    AppMethodBeat.i(66665);
    Map localMap = XmlParser.parseXml(paramString, "sysmsg", null);
    if (localMap == null)
    {
      AppMethodBeat.o(66665);
      return null;
    }
    j localj = new j();
    localj.APm = ((String)localMap.get(".sysmsg.paymsg.PayMsgType"));
    localj.APn = ((String)localMap.get(".sysmsg.paymsg.Brief.IconUrl"));
    localj.APo = ((String)localMap.get(".sysmsg.paymsg.Brief.CreateTime"));
    localj.APp = ((String)localMap.get(".sysmsg.paymsg.StatusSection.IconUrl"));
    localj.APq = ((String)localMap.get(".sysmsg.paymsg.StatusSection.StatusDesc"));
    localj.dWG = ((String)localMap.get(".sysmsg.paymsg.StatusSection.Content"));
    localj.APr = ((String)localMap.get(".sysmsg.paymsg.StatusSection.JumpUrl"));
    localj.APs = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppUserName"));
    localj.APc = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppNickName"));
    localj.APt = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppTelephone"));
    int i = 0;
    if (i == 0) {
      paramString = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button.Name");
    }
    for (String str = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button.JumpUrl");; str = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button" + i + ".JumpUrl"))
    {
      if (TextUtils.isEmpty(paramString)) {
        break label368;
      }
      localObject = new j.a();
      ((j.a)localObject).name = paramString;
      ((j.a)localObject).jumpUrl = str;
      if (localj.APu == null) {
        localj.APu = new ArrayList();
      }
      localj.APu.add(localObject);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button" + i + ".Name");
    }
    label368:
    i = 0;
    if (i == 0)
    {
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection.Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection.Value");
    }
    for (Object localObject = (String)localMap.get(".sysmsg.paymsg.NormalSection.JumpUrl");; localObject = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".JumpUrl"))
    {
      if (TextUtils.isEmpty(paramString)) {
        break label586;
      }
      j.b localb = new j.b();
      localb.name = paramString;
      localb.value = str;
      localb.jumpUrl = ((String)localObject);
      if (localj.APv == null) {
        localj.APv = new ArrayList();
      }
      localj.APv.add(localb);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
    }
    label586:
    AppMethodBeat.o(66665);
    return localj;
  }
  
  private void eBe()
  {
    AppMethodBeat.i(66664);
    if ((this.pRP == null) || (this.pRP.size() == 0))
    {
      AppMethodBeat.o(66664);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.pRP);
    int i = 0;
    while (i < localArrayList.size())
    {
      j localj = (j)localArrayList.get(i);
      if ((localj.APm != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.APm)))
      {
        int j = Util.getInt(localj.APm, 0);
        if ((j != 2) && (j != 1)) {
          aJB(localj.msgId);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66664);
  }
  
  private void eBf()
  {
    AppMethodBeat.i(66668);
    int i = 0;
    while (i < this.ANW.size())
    {
      a locala = (a)this.ANW.get(i);
      String str = locala.field_msgContentXml;
      j localj = aJA(str);
      localj.msgId = locala.field_msgId;
      this.pRP.add(localj);
      Log.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
      i += 1;
    }
    AppMethodBeat.o(66668);
  }
  
  private void loadFromDB()
  {
    AppMethodBeat.i(66663);
    com.tencent.mm.plugin.order.a.b.eBa();
    Cursor localCursor = com.tencent.mm.plugin.order.a.b.eBc().getAll();
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
        this.ANW.add(locala);
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
    com.tencent.mm.plugin.order.a.b.eBa();
    if (!com.tencent.mm.plugin.order.a.b.eBc().a(locala)) {
      Log.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + paramj.msgId);
    }
    this.ANW.add(locala);
    AppMethodBeat.o(66662);
  }
  
  public final boolean aJB(String paramString)
  {
    AppMethodBeat.i(66666);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66666);
      return false;
    }
    paramString = aJD(paramString);
    if (paramString != null)
    {
      this.pRP.remove(paramString);
      a(paramString);
      AppMethodBeat.o(66666);
      return true;
    }
    AppMethodBeat.o(66666);
    return false;
  }
  
  public final boolean aJC(String paramString)
  {
    AppMethodBeat.i(66669);
    if ((this.pRP == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66669);
      return false;
    }
    int i = 0;
    while (i < this.pRP.size())
    {
      j localj = (j)this.pRP.get(i);
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
  
  public final j aJD(String paramString)
  {
    AppMethodBeat.i(66670);
    if ((this.pRP == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66670);
      return null;
    }
    int i = 0;
    while (i < this.pRP.size())
    {
      j localj = (j)this.pRP.get(i);
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
  
  public final a aJE(String paramString)
  {
    AppMethodBeat.i(66671);
    if ((this.ANW == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66671);
      return null;
    }
    int i = 0;
    while (i < this.ANW.size())
    {
      a locala = (a)this.ANW.get(i);
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
  
  public final void eBg()
  {
    AppMethodBeat.i(66672);
    int i = eBh();
    g.aAi();
    g.aAh().azQ().set(204820, Integer.valueOf(i));
    Log.v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(i)));
    AppMethodBeat.o(66672);
  }
  
  public final int eBh()
  {
    AppMethodBeat.i(66673);
    if ((this.ANW == null) || (this.ANW.size() == 0))
    {
      AppMethodBeat.o(66673);
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.ANW.size(); j = k)
    {
      a locala = (a)this.ANW.get(i);
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
    Log.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:".concat(String.valueOf(j)));
    AppMethodBeat.o(66673);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.c
 * JD-Core Version:    0.7.0.1
 */