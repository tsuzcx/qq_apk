package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  private List<a> MEb;
  public List<j> wsq;
  
  public c()
  {
    AppMethodBeat.i(66661);
    this.wsq = new ArrayList();
    this.MEb = new ArrayList();
    loadFromDB();
    gxA();
    gxz();
    gxB();
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
    while (i < this.MEb.size())
    {
      a locala = (a)this.MEb.get(i);
      if (paramj.msgId.equals(locala.field_msgId))
      {
        this.MEb.remove(locala);
        com.tencent.mm.plugin.order.a.b.gxv();
        boolean bool = com.tencent.mm.plugin.order.a.b.gxx().delete(locala, new String[0]);
        AppMethodBeat.o(66667);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(66667);
    return false;
  }
  
  public static j aRc(String paramString)
  {
    AppMethodBeat.i(66665);
    Map localMap = XmlParser.parseXml(paramString, "sysmsg", null);
    if (localMap == null)
    {
      AppMethodBeat.o(66665);
      return null;
    }
    j localj = new j();
    localj.MFq = ((String)localMap.get(".sysmsg.paymsg.PayMsgType"));
    localj.MFr = ((String)localMap.get(".sysmsg.paymsg.Brief.IconUrl"));
    localj.MFs = ((String)localMap.get(".sysmsg.paymsg.Brief.CreateTime"));
    localj.MFt = ((String)localMap.get(".sysmsg.paymsg.StatusSection.IconUrl"));
    localj.MFu = ((String)localMap.get(".sysmsg.paymsg.StatusSection.StatusDesc"));
    localj.hWn = ((String)localMap.get(".sysmsg.paymsg.StatusSection.Content"));
    localj.MFv = ((String)localMap.get(".sysmsg.paymsg.StatusSection.JumpUrl"));
    localj.MFw = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppUserName"));
    localj.MFg = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppNickName"));
    localj.MFx = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppTelephone"));
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
      if (localj.MFy == null) {
        localj.MFy = new ArrayList();
      }
      localj.MFy.add(localObject);
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
      if (localj.MFz == null) {
        localj.MFz = new ArrayList();
      }
      localj.MFz.add(localb);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
    }
    label586:
    AppMethodBeat.o(66665);
    return localj;
  }
  
  private void gxA()
  {
    AppMethodBeat.i(66668);
    int i = 0;
    while (i < this.MEb.size())
    {
      a locala = (a)this.MEb.get(i);
      String str = locala.field_msgContentXml;
      j localj = aRc(str);
      localj.msgId = locala.field_msgId;
      this.wsq.add(localj);
      Log.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
      i += 1;
    }
    AppMethodBeat.o(66668);
  }
  
  private void gxz()
  {
    AppMethodBeat.i(66664);
    if ((this.wsq == null) || (this.wsq.size() == 0))
    {
      AppMethodBeat.o(66664);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.wsq);
    int i = 0;
    while (i < localArrayList.size())
    {
      j localj = (j)localArrayList.get(i);
      if ((localj.MFq != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.MFq)))
      {
        int j = Util.getInt(localj.MFq, 0);
        if ((j != 2) && (j != 1)) {
          aRd(localj.msgId);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66664);
  }
  
  private void loadFromDB()
  {
    AppMethodBeat.i(66663);
    com.tencent.mm.plugin.order.a.b.gxv();
    Cursor localCursor = com.tencent.mm.plugin.order.a.b.gxx().getAll();
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
        this.MEb.add(locala);
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
    com.tencent.mm.plugin.order.a.b.gxv();
    if (!com.tencent.mm.plugin.order.a.b.gxx().a(locala)) {
      Log.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + paramj.msgId);
    }
    this.MEb.add(locala);
    AppMethodBeat.o(66662);
  }
  
  public final boolean aRd(String paramString)
  {
    AppMethodBeat.i(66666);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66666);
      return false;
    }
    paramString = aRf(paramString);
    if (paramString != null)
    {
      this.wsq.remove(paramString);
      a(paramString);
      AppMethodBeat.o(66666);
      return true;
    }
    AppMethodBeat.o(66666);
    return false;
  }
  
  public final boolean aRe(String paramString)
  {
    AppMethodBeat.i(66669);
    if ((this.wsq == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66669);
      return false;
    }
    int i = 0;
    while (i < this.wsq.size())
    {
      j localj = (j)this.wsq.get(i);
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
  
  public final j aRf(String paramString)
  {
    AppMethodBeat.i(66670);
    if ((this.wsq == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66670);
      return null;
    }
    int i = 0;
    while (i < this.wsq.size())
    {
      j localj = (j)this.wsq.get(i);
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
  
  public final a aRg(String paramString)
  {
    AppMethodBeat.i(66671);
    if ((this.MEb == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66671);
      return null;
    }
    int i = 0;
    while (i < this.MEb.size())
    {
      a locala = (a)this.MEb.get(i);
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
  
  public final void gxB()
  {
    AppMethodBeat.i(66672);
    int i = gxC();
    h.baF();
    h.baE().ban().B(204820, Integer.valueOf(i));
    Log.v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(i)));
    AppMethodBeat.o(66672);
  }
  
  public final int gxC()
  {
    AppMethodBeat.i(66673);
    if ((this.MEb == null) || (this.MEb.size() == 0))
    {
      AppMethodBeat.o(66673);
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.MEb.size(); j = k)
    {
      a locala = (a)this.MEb.get(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.c
 * JD-Core Version:    0.7.0.1
 */