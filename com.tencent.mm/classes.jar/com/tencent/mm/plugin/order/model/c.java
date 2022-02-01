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
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  public List<j> nrj;
  private List<a> uoa;
  
  public c()
  {
    AppMethodBeat.i(66661);
    this.nrj = new ArrayList();
    this.uoa = new ArrayList();
    loadFromDB();
    dae();
    dad();
    daf();
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
    while (i < this.uoa.size())
    {
      a locala = (a)this.uoa.get(i);
      if (paramj.dvT.equals(locala.field_msgId))
      {
        this.uoa.remove(locala);
        com.tencent.mm.plugin.order.a.b.cZY();
        boolean bool = com.tencent.mm.plugin.order.a.b.daa().delete(locala, new String[0]);
        AppMethodBeat.o(66667);
        return bool;
      }
      i += 1;
    }
    AppMethodBeat.o(66667);
    return false;
  }
  
  public static j aka(String paramString)
  {
    AppMethodBeat.i(66665);
    Map localMap = bw.K(paramString, "sysmsg");
    if (localMap == null)
    {
      AppMethodBeat.o(66665);
      return null;
    }
    j localj = new j();
    localj.upr = ((String)localMap.get(".sysmsg.paymsg.PayMsgType"));
    localj.ups = ((String)localMap.get(".sysmsg.paymsg.Brief.IconUrl"));
    localj.upt = ((String)localMap.get(".sysmsg.paymsg.Brief.CreateTime"));
    localj.upu = ((String)localMap.get(".sysmsg.paymsg.StatusSection.IconUrl"));
    localj.upv = ((String)localMap.get(".sysmsg.paymsg.StatusSection.StatusDesc"));
    localj.duk = ((String)localMap.get(".sysmsg.paymsg.StatusSection.Content"));
    localj.upw = ((String)localMap.get(".sysmsg.paymsg.StatusSection.JumpUrl"));
    localj.upx = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppUserName"));
    localj.uph = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppNickName"));
    localj.upy = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppTelephone"));
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
      if (localj.upz == null) {
        localj.upz = new ArrayList();
      }
      localj.upz.add(localObject);
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
      if (localj.upA == null) {
        localj.upA = new ArrayList();
      }
      localj.upA.add(localb);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
    }
    label585:
    AppMethodBeat.o(66665);
    return localj;
  }
  
  private void dad()
  {
    AppMethodBeat.i(66664);
    if ((this.nrj == null) || (this.nrj.size() == 0))
    {
      AppMethodBeat.o(66664);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.nrj);
    int i = 0;
    while (i < localArrayList.size())
    {
      j localj = (j)localArrayList.get(i);
      if ((localj.upr != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.upr)))
      {
        int j = bt.getInt(localj.upr, 0);
        if ((j != 2) && (j != 1)) {
          akb(localj.dvT);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66664);
  }
  
  private void dae()
  {
    AppMethodBeat.i(66668);
    int i = 0;
    while (i < this.uoa.size())
    {
      a locala = (a)this.uoa.get(i);
      String str = locala.field_msgContentXml;
      j localj = aka(str);
      localj.dvT = locala.field_msgId;
      this.nrj.add(localj);
      ad.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
      i += 1;
    }
    AppMethodBeat.o(66668);
  }
  
  private void loadFromDB()
  {
    AppMethodBeat.i(66663);
    com.tencent.mm.plugin.order.a.b.cZY();
    Cursor localCursor = com.tencent.mm.plugin.order.a.b.daa().getAll();
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
        this.uoa.add(locala);
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
    locala.field_msgId = paramj.dvT;
    locala.field_msgContentXml = paramString1;
    locala.field_isRead = paramString2;
    com.tencent.mm.plugin.order.a.b.cZY();
    if (!com.tencent.mm.plugin.order.a.b.daa().a(locala)) {
      ad.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + paramj.dvT);
    }
    this.uoa.add(locala);
    AppMethodBeat.o(66662);
  }
  
  public final boolean akb(String paramString)
  {
    AppMethodBeat.i(66666);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(66666);
      return false;
    }
    paramString = akd(paramString);
    if (paramString != null)
    {
      this.nrj.remove(paramString);
      a(paramString);
      AppMethodBeat.o(66666);
      return true;
    }
    AppMethodBeat.o(66666);
    return false;
  }
  
  public final boolean akc(String paramString)
  {
    AppMethodBeat.i(66669);
    if ((this.nrj == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66669);
      return false;
    }
    int i = 0;
    while (i < this.nrj.size())
    {
      j localj = (j)this.nrj.get(i);
      if ((localj != null) && (localj.dvT.equals(paramString)))
      {
        AppMethodBeat.o(66669);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(66669);
    return false;
  }
  
  public final j akd(String paramString)
  {
    AppMethodBeat.i(66670);
    if ((this.nrj == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66670);
      return null;
    }
    int i = 0;
    while (i < this.nrj.size())
    {
      j localj = (j)this.nrj.get(i);
      if (paramString.equals(localj.dvT))
      {
        AppMethodBeat.o(66670);
        return localj;
      }
      i += 1;
    }
    AppMethodBeat.o(66670);
    return null;
  }
  
  public final a ake(String paramString)
  {
    AppMethodBeat.i(66671);
    if ((this.uoa == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(66671);
      return null;
    }
    int i = 0;
    while (i < this.uoa.size())
    {
      a locala = (a)this.uoa.get(i);
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
  
  public final void daf()
  {
    AppMethodBeat.i(66672);
    int i = dag();
    g.afC();
    g.afB().afk().set(204820, Integer.valueOf(i));
    ad.v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(i)));
    AppMethodBeat.o(66672);
  }
  
  public final int dag()
  {
    AppMethodBeat.i(66673);
    if ((this.uoa == null) || (this.uoa.size() == 0))
    {
      AppMethodBeat.o(66673);
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.uoa.size(); j = k)
    {
      a locala = (a)this.uoa.get(i);
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