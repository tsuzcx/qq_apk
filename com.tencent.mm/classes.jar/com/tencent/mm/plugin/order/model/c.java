package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  public List<j> nUj;
  private List<a> vwW;
  
  public c()
  {
    AppMethodBeat.i(66661);
    this.nUj = new ArrayList();
    this.vwW = new ArrayList();
    loadFromDB();
    dnM();
    dnL();
    dnN();
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
    while (i < this.vwW.size())
    {
      a locala = (a)this.vwW.get(i);
      if (paramj.dtG.equals(locala.field_msgId))
      {
        this.vwW.remove(locala);
        com.tencent.mm.plugin.order.a.b.dnG();
        boolean bool = com.tencent.mm.plugin.order.a.b.dnI().delete(locala, new String[0]);
        AppMethodBeat.o(66667);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(66667);
    return false;
  }
  
  public static j aoY(String paramString)
  {
    AppMethodBeat.i(66665);
    Map localMap = bv.L(paramString, "sysmsg");
    if (localMap == null)
    {
      AppMethodBeat.o(66665);
      return null;
    }
    j localj = new j();
    localj.vyn = ((String)localMap.get(".sysmsg.paymsg.PayMsgType"));
    localj.vyo = ((String)localMap.get(".sysmsg.paymsg.Brief.IconUrl"));
    localj.vyp = ((String)localMap.get(".sysmsg.paymsg.Brief.CreateTime"));
    localj.vyq = ((String)localMap.get(".sysmsg.paymsg.StatusSection.IconUrl"));
    localj.vyr = ((String)localMap.get(".sysmsg.paymsg.StatusSection.StatusDesc"));
    localj.drV = ((String)localMap.get(".sysmsg.paymsg.StatusSection.Content"));
    localj.vys = ((String)localMap.get(".sysmsg.paymsg.StatusSection.JumpUrl"));
    localj.vyt = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppUserName"));
    localj.vyd = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppNickName"));
    localj.vyu = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppTelephone"));
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
      if (localj.vyv == null) {
        localj.vyv = new ArrayList();
      }
      localj.vyv.add(localObject);
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
      if (localj.vyw == null) {
        localj.vyw = new ArrayList();
      }
      localj.vyw.add(localb);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
    }
    label585:
    AppMethodBeat.o(66665);
    return localj;
  }
  
  private void dnL()
  {
    AppMethodBeat.i(66664);
    if ((this.nUj == null) || (this.nUj.size() == 0))
    {
      AppMethodBeat.o(66664);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.nUj);
    int i = 0;
    while (i < localArrayList.size())
    {
      j localj = (j)localArrayList.get(i);
      if ((localj.vyn != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.vyn)))
      {
        int j = bs.getInt(localj.vyn, 0);
        if ((j != 2) && (j != 1)) {
          aoZ(localj.dtG);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66664);
  }
  
  private void dnM()
  {
    AppMethodBeat.i(66668);
    int i = 0;
    while (i < this.vwW.size())
    {
      a locala = (a)this.vwW.get(i);
      String str = locala.field_msgContentXml;
      j localj = aoY(str);
      localj.dtG = locala.field_msgId;
      this.nUj.add(localj);
      ac.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
      i += 1;
    }
    AppMethodBeat.o(66668);
  }
  
  private void loadFromDB()
  {
    AppMethodBeat.i(66663);
    com.tencent.mm.plugin.order.a.b.dnG();
    Cursor localCursor = com.tencent.mm.plugin.order.a.b.dnI().getAll();
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
        this.vwW.add(locala);
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
    locala.field_msgId = paramj.dtG;
    locala.field_msgContentXml = paramString1;
    locala.field_isRead = paramString2;
    com.tencent.mm.plugin.order.a.b.dnG();
    if (!com.tencent.mm.plugin.order.a.b.dnI().a(locala)) {
      ac.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + paramj.dtG);
    }
    this.vwW.add(locala);
    AppMethodBeat.o(66662);
  }
  
  public final boolean aoZ(String paramString)
  {
    AppMethodBeat.i(66666);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66666);
      return false;
    }
    paramString = apb(paramString);
    if (paramString != null)
    {
      this.nUj.remove(paramString);
      a(paramString);
      AppMethodBeat.o(66666);
      return true;
    }
    AppMethodBeat.o(66666);
    return false;
  }
  
  public final boolean apa(String paramString)
  {
    AppMethodBeat.i(66669);
    if ((this.nUj == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66669);
      return false;
    }
    int i = 0;
    while (i < this.nUj.size())
    {
      j localj = (j)this.nUj.get(i);
      if ((localj != null) && (localj.dtG.equals(paramString)))
      {
        AppMethodBeat.o(66669);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66669);
    return false;
  }
  
  public final j apb(String paramString)
  {
    AppMethodBeat.i(66670);
    if ((this.nUj == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66670);
      return null;
    }
    int i = 0;
    while (i < this.nUj.size())
    {
      j localj = (j)this.nUj.get(i);
      if (paramString.equals(localj.dtG))
      {
        AppMethodBeat.o(66670);
        return localj;
      }
      i += 1;
    }
    AppMethodBeat.o(66670);
    return null;
  }
  
  public final a apc(String paramString)
  {
    AppMethodBeat.i(66671);
    if ((this.vwW == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66671);
      return null;
    }
    int i = 0;
    while (i < this.vwW.size())
    {
      a locala = (a)this.vwW.get(i);
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
  
  public final void dnN()
  {
    AppMethodBeat.i(66672);
    int i = dnO();
    g.agS();
    g.agR().agA().set(204820, Integer.valueOf(i));
    ac.v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(i)));
    AppMethodBeat.o(66672);
  }
  
  public final int dnO()
  {
    AppMethodBeat.i(66673);
    if ((this.vwW == null) || (this.vwW.size() == 0))
    {
      AppMethodBeat.o(66673);
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.vwW.size(); j = k)
    {
      a locala = (a)this.vwW.get(i);
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
    ac.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:".concat(String.valueOf(j)));
    AppMethodBeat.o(66673);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.c
 * JD-Core Version:    0.7.0.1
 */