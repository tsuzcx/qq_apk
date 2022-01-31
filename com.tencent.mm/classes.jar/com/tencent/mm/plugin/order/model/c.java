package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  public List<j> kmd;
  private List<a> ppa;
  
  public c()
  {
    AppMethodBeat.i(43753);
    this.kmd = new ArrayList();
    this.ppa = new ArrayList();
    loadFromDB();
    caq();
    cap();
    car();
    AppMethodBeat.o(43753);
  }
  
  public static j WG(String paramString)
  {
    AppMethodBeat.i(43757);
    Map localMap = br.F(paramString, "sysmsg");
    if (localMap == null)
    {
      AppMethodBeat.o(43757);
      return null;
    }
    j localj = new j();
    localj.pqr = ((String)localMap.get(".sysmsg.paymsg.PayMsgType"));
    localj.pqs = ((String)localMap.get(".sysmsg.paymsg.Brief.IconUrl"));
    localj.pqt = ((String)localMap.get(".sysmsg.paymsg.Brief.CreateTime"));
    localj.pqu = ((String)localMap.get(".sysmsg.paymsg.StatusSection.IconUrl"));
    localj.pqv = ((String)localMap.get(".sysmsg.paymsg.StatusSection.StatusDesc"));
    localj.cDI = ((String)localMap.get(".sysmsg.paymsg.StatusSection.Content"));
    localj.pqw = ((String)localMap.get(".sysmsg.paymsg.StatusSection.JumpUrl"));
    localj.pqx = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppUserName"));
    localj.pqh = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppNickName"));
    localj.pqy = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppTelephone"));
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
      if (localj.pqz == null) {
        localj.pqz = new ArrayList();
      }
      localj.pqz.add(localObject);
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
      if (localj.pqA == null) {
        localj.pqA = new ArrayList();
      }
      localj.pqA.add(localb);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
    }
    label585:
    AppMethodBeat.o(43757);
    return localj;
  }
  
  private boolean a(j paramj)
  {
    AppMethodBeat.i(43759);
    if (paramj == null)
    {
      AppMethodBeat.o(43759);
      return false;
    }
    int i = 0;
    while (i < this.ppa.size())
    {
      a locala = (a)this.ppa.get(i);
      if (paramj.cDC.equals(locala.field_msgId))
      {
        this.ppa.remove(locala);
        com.tencent.mm.plugin.order.a.b.cak();
        boolean bool = com.tencent.mm.plugin.order.a.b.cam().delete(locala, new String[0]);
        AppMethodBeat.o(43759);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(43759);
    return false;
  }
  
  private void cap()
  {
    AppMethodBeat.i(43756);
    if ((this.kmd == null) || (this.kmd.size() == 0))
    {
      AppMethodBeat.o(43756);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.kmd);
    int i = 0;
    while (i < localArrayList.size())
    {
      j localj = (j)localArrayList.get(i);
      if ((localj.pqr != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.pqr)))
      {
        int j = Integer.valueOf(localj.pqr).intValue();
        if ((j != 2) && (j != 1)) {
          WH(localj.cDC);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(43756);
  }
  
  private void caq()
  {
    AppMethodBeat.i(43760);
    int i = 0;
    while (i < this.ppa.size())
    {
      a locala = (a)this.ppa.get(i);
      String str = locala.field_msgContentXml;
      j localj = WG(str);
      localj.cDC = locala.field_msgId;
      this.kmd.add(localj);
      ab.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
      i += 1;
    }
    AppMethodBeat.o(43760);
  }
  
  private void loadFromDB()
  {
    AppMethodBeat.i(43755);
    com.tencent.mm.plugin.order.a.b.cak();
    Cursor localCursor = com.tencent.mm.plugin.order.a.b.cam().getAll();
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
        this.ppa.add(locala);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(43755);
  }
  
  public final boolean WH(String paramString)
  {
    AppMethodBeat.i(43758);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(43758);
      return false;
    }
    paramString = WJ(paramString);
    if (paramString != null)
    {
      this.kmd.remove(paramString);
      a(paramString);
      AppMethodBeat.o(43758);
      return true;
    }
    AppMethodBeat.o(43758);
    return false;
  }
  
  public final boolean WI(String paramString)
  {
    AppMethodBeat.i(43761);
    if ((this.kmd == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(43761);
      return false;
    }
    int i = 0;
    while (i < this.kmd.size())
    {
      j localj = (j)this.kmd.get(i);
      if ((localj != null) && (localj.cDC.equals(paramString)))
      {
        AppMethodBeat.o(43761);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(43761);
    return false;
  }
  
  public final j WJ(String paramString)
  {
    AppMethodBeat.i(43762);
    if ((this.kmd == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(43762);
      return null;
    }
    int i = 0;
    while (i < this.kmd.size())
    {
      j localj = (j)this.kmd.get(i);
      if (paramString.equals(localj.cDC))
      {
        AppMethodBeat.o(43762);
        return localj;
      }
      i += 1;
    }
    AppMethodBeat.o(43762);
    return null;
  }
  
  public final a WK(String paramString)
  {
    AppMethodBeat.i(43763);
    if ((this.ppa == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(43763);
      return null;
    }
    int i = 0;
    while (i < this.ppa.size())
    {
      a locala = (a)this.ppa.get(i);
      if (paramString.equals(locala.field_msgId))
      {
        AppMethodBeat.o(43763);
        return locala;
      }
      i += 1;
    }
    AppMethodBeat.o(43763);
    return null;
  }
  
  public final void a(j paramj, String paramString1, String paramString2)
  {
    AppMethodBeat.i(43754);
    if ((paramj == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(43754);
      return;
    }
    a locala = new a();
    locala.field_msgId = paramj.cDC;
    locala.field_msgContentXml = paramString1;
    locala.field_isRead = paramString2;
    com.tencent.mm.plugin.order.a.b.cak();
    if (!com.tencent.mm.plugin.order.a.b.cam().a(locala)) {
      ab.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + paramj.cDC);
    }
    this.ppa.add(locala);
    AppMethodBeat.o(43754);
  }
  
  public final void car()
  {
    AppMethodBeat.i(43764);
    int i = cas();
    g.RM();
    g.RL().Ru().set(204820, Integer.valueOf(i));
    ab.v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(i)));
    AppMethodBeat.o(43764);
  }
  
  public final int cas()
  {
    AppMethodBeat.i(43765);
    if ((this.ppa == null) || (this.ppa.size() == 0))
    {
      AppMethodBeat.o(43765);
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.ppa.size(); j = k)
    {
      a locala = (a)this.ppa.get(i);
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
    ab.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:".concat(String.valueOf(j)));
    AppMethodBeat.o(43765);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.c
 * JD-Core Version:    0.7.0.1
 */