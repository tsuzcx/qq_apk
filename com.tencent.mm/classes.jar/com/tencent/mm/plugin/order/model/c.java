package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
{
  public List<j> ilf = new ArrayList();
  private List<a> mOK = new ArrayList();
  
  public c()
  {
    loadFromDB();
    brB();
    brA();
    brC();
  }
  
  public static j KF(String paramString)
  {
    Map localMap = bn.s(paramString, "sysmsg");
    if (localMap == null) {
      return null;
    }
    j localj = new j();
    localj.mQc = ((String)localMap.get(".sysmsg.paymsg.PayMsgType"));
    localj.mQd = ((String)localMap.get(".sysmsg.paymsg.Brief.IconUrl"));
    localj.mQe = ((String)localMap.get(".sysmsg.paymsg.Brief.CreateTime"));
    localj.mQf = ((String)localMap.get(".sysmsg.paymsg.StatusSection.IconUrl"));
    localj.mQg = ((String)localMap.get(".sysmsg.paymsg.StatusSection.StatusDesc"));
    localj.bVV = ((String)localMap.get(".sysmsg.paymsg.StatusSection.Content"));
    localj.mQh = ((String)localMap.get(".sysmsg.paymsg.StatusSection.JumpUrl"));
    localj.mQi = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppUserName"));
    localj.mPS = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppNickName"));
    localj.mQj = ((String)localMap.get(".sysmsg.paymsg.ContactSection.AppTelephone"));
    int i = 0;
    if (i == 0) {
      paramString = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button.Name");
    }
    for (String str = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button.JumpUrl");; str = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button" + i + ".JumpUrl"))
    {
      if (TextUtils.isEmpty(paramString)) {
        break label357;
      }
      localObject = new j.a();
      ((j.a)localObject).name = paramString;
      ((j.a)localObject).jumpUrl = str;
      if (localj.mQk == null) {
        localj.mQk = new ArrayList();
      }
      localj.mQk.add(localObject);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.StatusSection.Button" + i + ".Name");
    }
    label357:
    i = 0;
    if (i == 0)
    {
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection.Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection.Value");
    }
    for (Object localObject = (String)localMap.get(".sysmsg.paymsg.NormalSection.JumpUrl");; localObject = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".JumpUrl"))
    {
      if (TextUtils.isEmpty(paramString)) {
        break label575;
      }
      j.b localb = new j.b();
      localb.name = paramString;
      localb.value = str;
      localb.jumpUrl = ((String)localObject);
      if (localj.mQl == null) {
        localj.mQl = new ArrayList();
      }
      localj.mQl.add(localb);
      i += 1;
      break;
      paramString = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Name");
      str = (String)localMap.get(".sysmsg.paymsg.NormalSection" + i + ".Value");
    }
    label575:
    return localj;
  }
  
  public static MallOrderDetailObject a(j paramj)
  {
    if (paramj == null) {
      return null;
    }
    MallOrderDetailObject localMallOrderDetailObject = new MallOrderDetailObject();
    Object localObject1 = new MallOrderDetailObject.b();
    ((MallOrderDetailObject.b)localObject1).mOF = paramj.mQg;
    if ((!TextUtils.isEmpty(paramj.mQe)) && (com.tencent.mm.plugin.order.c.c.yS(paramj.mQe))) {}
    int i;
    Object localObject2;
    MallOrderDetailObject.a locala;
    for (((MallOrderDetailObject.b)localObject1).time = Integer.valueOf(paramj.mQe).intValue();; ((MallOrderDetailObject.b)localObject1).time = ((int)(System.currentTimeMillis() / 1000L)))
    {
      ((MallOrderDetailObject.b)localObject1).thumbUrl = paramj.mQf;
      ((MallOrderDetailObject.b)localObject1).kRP = paramj.mQh;
      ((MallOrderDetailObject.b)localObject1).mOG = paramj.bVV;
      localMallOrderDetailObject.mOx = ((MallOrderDetailObject.b)localObject1);
      localObject1 = paramj.mQk;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break;
      }
      localMallOrderDetailObject.mOz = new ArrayList();
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (j.a)((List)localObject1).get(i);
        locala = new MallOrderDetailObject.a();
        locala.name = ((j.a)localObject2).name;
        locala.value = "";
        locala.jumpUrl = ((j.a)localObject2).jumpUrl;
        locala.ilA = false;
        localMallOrderDetailObject.mOz.add(locala);
        i += 1;
      }
    }
    localObject1 = paramj.mQl;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (localMallOrderDetailObject.mOz == null) {
        localMallOrderDetailObject.mOz = new ArrayList();
      }
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (j.b)((List)localObject1).get(i);
        locala = new MallOrderDetailObject.a();
        locala.name = ((j.b)localObject2).name;
        locala.value = ((j.b)localObject2).value;
        locala.jumpUrl = ((j.b)localObject2).jumpUrl;
        locala.ilA = false;
        if (i == 0) {
          locala.ilA = true;
        }
        localMallOrderDetailObject.mOz.add(locala);
        i += 1;
      }
    }
    localMallOrderDetailObject.mOD = paramj.mQj;
    localMallOrderDetailObject.bNZ = paramj.mQi;
    if ((!TextUtils.isEmpty(paramj.mQe)) && (com.tencent.mm.plugin.order.c.c.yS(paramj.mQe))) {}
    for (localMallOrderDetailObject.mOE = Integer.valueOf(paramj.mQe).intValue();; localMallOrderDetailObject.mOE = ((int)(System.currentTimeMillis() / 1000L))) {
      return localMallOrderDetailObject;
    }
  }
  
  private void brA()
  {
    if ((this.ilf == null) || (this.ilf.size() == 0)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.ilf);
      int i = 0;
      while (i < localArrayList.size())
      {
        j localj = (j)localArrayList.get(i);
        if ((localj.mQc != null) && (com.tencent.mm.plugin.order.c.c.yS(localj.mQc)))
        {
          int j = Integer.valueOf(localj.mQc).intValue();
          if ((j != 2) && (j != 1)) {
            KG(localj.bVP);
          }
        }
        i += 1;
      }
    }
  }
  
  private void brB()
  {
    int i = 0;
    while (i < this.mOK.size())
    {
      a locala = (a)this.mOK.get(i);
      String str = locala.field_msgContentXml;
      j localj = KF(str);
      localj.bVP = locala.field_msgId;
      this.ilf.add(localj);
      y.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:" + str);
      i += 1;
    }
  }
  
  private void loadFromDB()
  {
    com.tencent.mm.plugin.order.a.b.brv();
    Cursor localCursor = com.tencent.mm.plugin.order.a.b.brx().aAn();
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
        this.mOK.add(locala);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
  }
  
  public final boolean KG(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = KI(paramString);
    } while (paramString == null);
    this.ilf.remove(paramString);
    int i;
    if (paramString != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.mOK.size())
      {
        a locala = (a)this.mOK.get(i);
        if (paramString.bVP.equals(locala.field_msgId))
        {
          this.mOK.remove(locala);
          com.tencent.mm.plugin.order.a.b.brv();
          com.tencent.mm.plugin.order.a.b.brx().a(locala, new String[0]);
        }
      }
      else
      {
        return true;
      }
      i += 1;
    }
  }
  
  public final boolean KH(String paramString)
  {
    if ((this.ilf == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.ilf.size())
      {
        j localj = (j)this.ilf.get(i);
        if ((localj != null) && (localj.bVP.equals(paramString))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final j KI(String paramString)
  {
    Object localObject;
    if ((this.ilf == null) || (TextUtils.isEmpty(paramString)))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.ilf.size()) {
        break label70;
      }
      j localj = (j)this.ilf.get(i);
      localObject = localj;
      if (paramString.equals(localj.bVP)) {
        break;
      }
      i += 1;
    }
    label70:
    return null;
  }
  
  public final a KJ(String paramString)
  {
    Object localObject;
    if ((this.mOK == null) || (TextUtils.isEmpty(paramString)))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.mOK.size()) {
        break label70;
      }
      a locala = (a)this.mOK.get(i);
      localObject = locala;
      if (paramString.equals(locala.field_msgId)) {
        break;
      }
      i += 1;
    }
    label70:
    return null;
  }
  
  public final void a(j paramj, String paramString1, String paramString2)
  {
    if ((paramj == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    a locala = new a();
    locala.field_msgId = paramj.bVP;
    locala.field_msgContentXml = paramString1;
    locala.field_isRead = paramString2;
    com.tencent.mm.plugin.order.a.b.brv();
    if (!com.tencent.mm.plugin.order.a.b.brx().a(locala)) {
      y.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + paramj.bVP);
    }
    this.mOK.add(locala);
  }
  
  public final void brC()
  {
    int i = brD();
    g.DQ();
    g.DP().Dz().o(204820, Integer.valueOf(i));
    y.v("MicroMsg.MallPayMsgManager", "save unread msg is :" + i);
  }
  
  public final int brD()
  {
    if ((this.mOK == null) || (this.mOK.size() == 0)) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < this.mOK.size(); j = k)
    {
      a locala = (a)this.mOK.get(i);
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
    y.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:" + j);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.c
 * JD-Core Version:    0.7.0.1
 */