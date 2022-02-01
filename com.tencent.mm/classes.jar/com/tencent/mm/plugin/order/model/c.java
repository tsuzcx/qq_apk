package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  public List<j> oxE;
  private List<a> wCq;
  
  public c()
  {
    AppMethodBeat.i(66661);
    this.oxE = new ArrayList();
    this.wCq = new ArrayList();
    loadFromDB();
    dye();
    dyd();
    dyf();
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
    while (i < this.wCq.size())
    {
      a locala = (a)this.wCq.get(i);
      if (paramj.msgId.equals(locala.field_msgId))
      {
        this.wCq.remove(locala);
        com.tencent.mm.plugin.order.a.b.dxY();
        boolean bool = com.tencent.mm.plugin.order.a.b.dya().delete(locala, new String[0]);
        AppMethodBeat.o(66667);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(66667);
    return false;
  }
  
  public static j atY(String paramString)
  {
    AppMethodBeat.i(66665);
    Map localMap = bw.M(paramString, "sysmsg");
    if (localMap == null)
    {
      AppMethodBeat.o(66665);
      return null;
    }
    j localj = new j();
    localj.wDH = ((String)localMap.get(".sysmsg.paymsg.PayMsgType"));
    localj.wDI = ((String)localMap.get(".sysmsg.paymsg.Brief.IconUrl"));
    localj.wDJ = ((String)localMap.get(".sysmsg.paymsg.Brief.CreateTime"));
    localj.wDK = ((String)localMap.get(".sysmsg.paymsg.StatusSection.IconUrl"));
    localj.wDL = ((String)localMap.get(".sysmsg.paymsg.StatusSection.StatusDesc"));
    localj.dDP = ((String)localMap.get(".sysmsg.paymsg.StatusSection.Content"));
    localj.wDM = ((String)localMap.get(".sysmsg.paymsg.StatusSection.JumpUrl"));
    localj.wDN = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppUserName"));
    localj.wDx = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppNickName"));
    localj.wDO = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppTelephone"));
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
      if (localj.wDP == null) {
        localj.wDP = new ArrayList();
      }
      localj.wDP.add(localObject);
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
      if (localj.wDQ == null) {
        localj.wDQ = new ArrayList();
      }
      localj.wDQ.add(localb);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
    }
    label585:
    AppMethodBeat.o(66665);
    return localj;
  }
  
  private void dyd()
  {
    AppMethodBeat.i(66664);
    if ((this.oxE == null) || (this.oxE.size() == 0))
    {
      AppMethodBeat.o(66664);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.oxE);
    int i = 0;
    while (i < localArrayList.size())
    {
      j localj = (j)localArrayList.get(i);
      if ((localj.wDH != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.wDH)))
      {
        int j = bt.getInt(localj.wDH, 0);
        if ((j != 2) && (j != 1)) {
          atZ(localj.msgId);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66664);
  }
  
  private void dye()
  {
    AppMethodBeat.i(66668);
    int i = 0;
    while (i < this.wCq.size())
    {
      a locala = (a)this.wCq.get(i);
      String str = locala.field_msgContentXml;
      j localj = atY(str);
      localj.msgId = locala.field_msgId;
      this.oxE.add(localj);
      ad.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
      i += 1;
    }
    AppMethodBeat.o(66668);
  }
  
  private void loadFromDB()
  {
    AppMethodBeat.i(66663);
    com.tencent.mm.plugin.order.a.b.dxY();
    Cursor localCursor = com.tencent.mm.plugin.order.a.b.dya().getAll();
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
        this.wCq.add(locala);
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
    com.tencent.mm.plugin.order.a.b.dxY();
    if (!com.tencent.mm.plugin.order.a.b.dya().a(locala)) {
      ad.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + paramj.msgId);
    }
    this.wCq.add(locala);
    AppMethodBeat.o(66662);
  }
  
  public final boolean atZ(String paramString)
  {
    AppMethodBeat.i(66666);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66666);
      return false;
    }
    paramString = aub(paramString);
    if (paramString != null)
    {
      this.oxE.remove(paramString);
      a(paramString);
      AppMethodBeat.o(66666);
      return true;
    }
    AppMethodBeat.o(66666);
    return false;
  }
  
  public final boolean aua(String paramString)
  {
    AppMethodBeat.i(66669);
    if ((this.oxE == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66669);
      return false;
    }
    int i = 0;
    while (i < this.oxE.size())
    {
      j localj = (j)this.oxE.get(i);
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
  
  public final j aub(String paramString)
  {
    AppMethodBeat.i(66670);
    if ((this.oxE == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66670);
      return null;
    }
    int i = 0;
    while (i < this.oxE.size())
    {
      j localj = (j)this.oxE.get(i);
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
  
  public final a auc(String paramString)
  {
    AppMethodBeat.i(66671);
    if ((this.wCq == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66671);
      return null;
    }
    int i = 0;
    while (i < this.wCq.size())
    {
      a locala = (a)this.wCq.get(i);
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
  
  public final void dyf()
  {
    AppMethodBeat.i(66672);
    int i = dyg();
    g.ajD();
    g.ajC().ajl().set(204820, Integer.valueOf(i));
    ad.v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(i)));
    AppMethodBeat.o(66672);
  }
  
  public final int dyg()
  {
    AppMethodBeat.i(66673);
    if ((this.wCq == null) || (this.wCq.size() == 0))
    {
      AppMethodBeat.o(66673);
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.wCq.size(); j = k)
    {
      a locala = (a)this.wCq.get(i);
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
    ad.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:".concat(String.valueOf(j)));
    AppMethodBeat.o(66673);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.c
 * JD-Core Version:    0.7.0.1
 */