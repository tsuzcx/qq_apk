package com.tencent.mm.storage;

import com.tencent.mm.h.c.am;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.k.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class u
  extends am
{
  protected static c.a buS;
  private Map<String, b> eho = new HashMap();
  private a unl = new a();
  public a unm = this.unl;
  private List<String> unn = new LinkedList();
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroomname";
    locala.ujN.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "chatroomname";
    locala.columns[1] = "addtime";
    locala.ujN.put("addtime", "LONG");
    localStringBuilder.append(" addtime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "memberlist";
    locala.ujN.put("memberlist", "TEXT");
    localStringBuilder.append(" memberlist TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "displayname";
    locala.ujN.put("displayname", "TEXT");
    localStringBuilder.append(" displayname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "chatroomnick";
    locala.ujN.put("chatroomnick", "TEXT");
    localStringBuilder.append(" chatroomnick TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "roomflag";
    locala.ujN.put("roomflag", "INTEGER");
    localStringBuilder.append(" roomflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "roomowner";
    locala.ujN.put("roomowner", "TEXT");
    localStringBuilder.append(" roomowner TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "roomdata";
    locala.ujN.put("roomdata", "BLOB");
    localStringBuilder.append(" roomdata BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "isShowname";
    locala.ujN.put("isShowname", "INTEGER");
    localStringBuilder.append(" isShowname INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "selfDisplayName";
    locala.ujN.put("selfDisplayName", "TEXT");
    localStringBuilder.append(" selfDisplayName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "style";
    locala.ujN.put("style", "INTEGER");
    localStringBuilder.append(" style INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatroomdataflag";
    locala.ujN.put("chatroomdataflag", "INTEGER");
    localStringBuilder.append(" chatroomdataflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "modifytime";
    locala.ujN.put("modifytime", "LONG");
    localStringBuilder.append(" modifytime LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "chatroomnotice";
    locala.ujN.put("chatroomnotice", "TEXT");
    localStringBuilder.append(" chatroomnotice TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "chatroomVersion";
    locala.ujN.put("chatroomVersion", "INTEGER");
    localStringBuilder.append(" chatroomVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "chatroomnoticeEditor";
    locala.ujN.put("chatroomnoticeEditor", "TEXT");
    localStringBuilder.append(" chatroomnoticeEditor TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomnoticePublishTime";
    locala.ujN.put("chatroomnoticePublishTime", "LONG");
    localStringBuilder.append(" chatroomnoticePublishTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "chatroomLocalVersion";
    locala.ujN.put("chatroomLocalVersion", "LONG");
    localStringBuilder.append(" chatroomLocalVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "chatroomStatus";
    locala.ujN.put("chatroomStatus", "INTEGER default '0' ");
    localStringBuilder.append(" chatroomStatus INTEGER default '0' ");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  private static int Oh(String paramString)
  {
    int i = 0;
    try
    {
      int j = bk.getInt(paramString, 0);
      i = j;
    }
    catch (Exception localException)
    {
      while (paramString == null) {}
      y.e("MicroMsg.ChatRoomMember", "parserInt error " + paramString);
    }
    return i;
    return 0;
  }
  
  private void a(a parama)
  {
    if (this.field_roomdata == null) {
      parama = new a();
    }
    parama = parama.dtH.iterator();
    while (parama.hasNext())
    {
      b localb = (b)parama.next();
      this.eho.put(localb.userName, localb);
    }
  }
  
  private static a aaN(String paramString)
  {
    a locala = new a();
    if (bk.bl(paramString)) {
      return locala;
    }
    int i = paramString.indexOf('<');
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(i);
    }
    Map localMap = bn.s(str1, "RoomData");
    if (localMap == null)
    {
      y.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
      return null;
    }
    i = 0;
    for (;;)
    {
      try
      {
        b localb = new b();
        if (i == 0)
        {
          str2 = ".RoomData.Member.$UserName";
          str1 = ".RoomData.Member.DisplayName";
          paramString = ".RoomData.Member.Flag";
          str2 = bk.aM((String)localMap.get(str2), "");
          if (!bk.bl(str2))
          {
            localb.userName = str2;
            localb.dtK = bk.aM((String)localMap.get(str1), "");
            localb.dtL = Oh((String)localMap.get(paramString));
            locala.dtH.add(localb);
            i += 1;
          }
        }
        else
        {
          if (i == 0) {
            break label348;
          }
          str2 = ".RoomData.Member" + i + ".$UserName";
          str1 = ".RoomData.Member" + i + ".DisplayName";
          paramString = ".RoomData.Member" + i + ".Flag";
          continue;
        }
        locala.type = Oh((String)localMap.get(".RoomData.Type"));
        locala.status = Oh((String)localMap.get(".RoomData.Status"));
        locala.dng = Oh((String)localMap.get(".RoomData.MaxCount"));
        locala.dtI = bk.aM((String)localMap.get(".RoomData.ExtInfo.Upgrader"), "");
        return locala;
      }
      catch (Exception paramString)
      {
        return locala;
      }
      label348:
      paramString = null;
      str1 = null;
      String str2 = null;
    }
  }
  
  public static List<String> aaO(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    if (bk.bl(paramString)) {
      return localLinkedList;
    }
    paramString = paramString.split(";");
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    return localLinkedList;
  }
  
  public static boolean ctP()
  {
    return false;
  }
  
  public final void Fk(int paramInt)
  {
    if (b(this.unm)) {
      ctM();
    }
    this.unm.bSZ = paramInt;
    try
    {
      this.field_roomdata = this.unm.toByteArray();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final List<String> MN()
  {
    if ((this.unn == null) || (this.unn.size() == 0)) {
      this.unn = aaO(this.field_memberlist);
    }
    return this.unn;
  }
  
  public final u a(String paramString, a parama, boolean paramBoolean)
  {
    this.field_modifytime = System.currentTimeMillis();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = null;
      Iterator localIterator = parama.dtH.iterator();
      if (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb.userName == null) || (!localb.userName.equals(paramString))) {
          break label214;
        }
        localObject = localb;
      }
    }
    label214:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        this.field_selfDisplayName = localObject.dtK;
        this.field_isShowname = (localObject.dtL & 0x1);
      }
      for (int i = localObject.dtL;; i = 0)
      {
        y.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", new Object[] { this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i) });
        parama.bcw = (i & 0x2 | parama.bcw & 0xFFFFFFFD);
        this.field_chatroomdataflag = parama.bcw;
        try
        {
          this.field_roomdata = parama.toByteArray();
          this.unm = parama;
          a(parama);
          return this;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            y.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bk.j(paramString) });
          }
        }
      }
    }
  }
  
  public final b aaL(String paramString)
  {
    if (this.eho.size() <= 0) {
      ctM();
    }
    if (this.eho.containsKey(paramString)) {
      return (b)this.eho.get(paramString);
    }
    return null;
  }
  
  public final boolean aaM(String paramString)
  {
    paramString = aaL(paramString);
    if (paramString == null) {}
    while ((paramString.dtL & 0x800) == 0) {
      return false;
    }
    return true;
  }
  
  public final boolean aaP(String paramString)
  {
    return (!bk.bl(this.field_roomowner)) && (this.field_roomowner.equals(paramString));
  }
  
  public final boolean b(a parama)
  {
    return this.unl.btq() == parama.btq();
  }
  
  public final void ctM()
  {
    if (bk.bE(this.field_roomdata)) {
      return;
    }
    try
    {
      this.unm = ((a)new a().aH(this.field_roomdata));
      a(this.unm);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.unm = new a();
      }
    }
  }
  
  public final int ctN()
  {
    if (b(this.unm)) {
      ctM();
    }
    return this.unm.bSZ;
  }
  
  public final boolean ctO()
  {
    if (b(this.unm)) {
      ctM();
    }
    return this.unm.bSZ < this.unm.dtJ;
  }
  
  public final int ctQ()
  {
    if (b(this.unm)) {
      ctM();
    }
    return this.unm.type;
  }
  
  public final int ctR()
  {
    if (b(this.unm)) {
      ctM();
    }
    return this.unm.dng;
  }
  
  public final boolean ctS()
  {
    return this.field_isShowname > 0;
  }
  
  public final a ctT()
  {
    if (b(this.unm)) {
      ctM();
    }
    return this.unm;
  }
  
  public final u jdMethod_do(List<String> paramList)
  {
    Object localObject2;
    if ((paramList == null) || (paramList.size() == 0))
    {
      localObject2 = "";
      this.field_memberlist = ((String)localObject2);
      return this;
    }
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= paramList.size()) {
        break;
      }
      localObject2 = (String)localObject1 + (String)paramList.get(i);
      localObject1 = localObject2;
      if (i < paramList.size() - 1) {
        localObject1 = (String)localObject2 + ";";
      }
      i += 1;
    }
  }
  
  public final void gS(int paramInt)
  {
    this.field_chatroomdataflag = (this.unm.bcw & 0xFFFFFFFD | paramInt & 0x2);
  }
  
  public final String gV(String paramString)
  {
    paramString = aaL(paramString);
    if (paramString == null) {
      return "";
    }
    return bk.aM(paramString.dtK, "");
  }
  
  public final u gn(String paramString1, String paramString2)
  {
    return a(paramString1, aaN(paramString2), false);
  }
  
  public final u mB(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.field_isShowname = i;
      return this;
    }
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final void t(String paramString, List<ob> paramList)
  {
    if (b(this.unm)) {
      ctM();
    }
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (ob)paramList.next();
      if (this.eho.containsKey(((ob)localObject).hPY))
      {
        b localb = (b)this.eho.get(((ob)localObject).hPY);
        localb.dtK = ((ob)localObject).sLC;
        localb.dtL = ((ob)localObject).sLF;
        localb.dtM = ((ob)localObject).sLG;
      }
    }
    this.unm.dtH.clear();
    paramList = this.eho.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      this.unm.dtH.add(this.eho.get(localObject));
    }
    a(paramString, this.unm, false);
  }
  
  public final boolean xw()
  {
    if (bk.bl(this.field_roomowner)) {
      return false;
    }
    String str = q.Gj();
    if ((((c)g.r(c.class)).zl(this.field_chatroomname)) && (aaM(str))) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = this.field_roomowner.equals(str);
      if ((i == 0) && (!bool)) {
        break;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.u
 * JD-Core Version:    0.7.0.1
 */