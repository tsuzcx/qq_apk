package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.at;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.k.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class ab
  extends at
{
  protected static c.a info;
  private a Ipl;
  public a Ipm;
  private List<String> Ipn;
  private Map<String, b> hRB;
  
  static
  {
    AppMethodBeat.i(43163);
    c.a locala = new c.a();
    locala.IhA = new Field[27];
    locala.columns = new String[28];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroomname";
    locala.IhC.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "chatroomname";
    locala.columns[1] = "addtime";
    locala.IhC.put("addtime", "LONG");
    localStringBuilder.append(" addtime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "memberlist";
    locala.IhC.put("memberlist", "TEXT");
    localStringBuilder.append(" memberlist TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "displayname";
    locala.IhC.put("displayname", "TEXT");
    localStringBuilder.append(" displayname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "chatroomnick";
    locala.IhC.put("chatroomnick", "TEXT");
    localStringBuilder.append(" chatroomnick TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "roomflag";
    locala.IhC.put("roomflag", "INTEGER");
    localStringBuilder.append(" roomflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "roomowner";
    locala.IhC.put("roomowner", "TEXT");
    localStringBuilder.append(" roomowner TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "roomdata";
    locala.IhC.put("roomdata", "BLOB");
    localStringBuilder.append(" roomdata BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "isShowname";
    locala.IhC.put("isShowname", "INTEGER");
    localStringBuilder.append(" isShowname INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "selfDisplayName";
    locala.IhC.put("selfDisplayName", "TEXT");
    localStringBuilder.append(" selfDisplayName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "style";
    locala.IhC.put("style", "INTEGER");
    localStringBuilder.append(" style INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatroomdataflag";
    locala.IhC.put("chatroomdataflag", "INTEGER");
    localStringBuilder.append(" chatroomdataflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "modifytime";
    locala.IhC.put("modifytime", "LONG");
    localStringBuilder.append(" modifytime LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "chatroomnotice";
    locala.IhC.put("chatroomnotice", "TEXT");
    localStringBuilder.append(" chatroomnotice TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "chatroomVersion";
    locala.IhC.put("chatroomVersion", "INTEGER");
    localStringBuilder.append(" chatroomVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "chatroomnoticeEditor";
    locala.IhC.put("chatroomnoticeEditor", "TEXT");
    localStringBuilder.append(" chatroomnoticeEditor TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomnoticePublishTime";
    locala.IhC.put("chatroomnoticePublishTime", "LONG");
    localStringBuilder.append(" chatroomnoticePublishTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "chatroomLocalVersion";
    locala.IhC.put("chatroomLocalVersion", "LONG");
    localStringBuilder.append(" chatroomLocalVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "chatroomStatus";
    locala.IhC.put("chatroomStatus", "INTEGER default '0' ");
    localStringBuilder.append(" chatroomStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "memberCount";
    locala.IhC.put("memberCount", "INTEGER default '-1' ");
    localStringBuilder.append(" memberCount INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "chatroomfamilystatusmodifytime";
    locala.IhC.put("chatroomfamilystatusmodifytime", "LONG default '0' ");
    localStringBuilder.append(" chatroomfamilystatusmodifytime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "associateOpenIMRoomName";
    locala.IhC.put("associateOpenIMRoomName", "TEXT");
    localStringBuilder.append(" associateOpenIMRoomName TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "openIMRoomMigrateStatus";
    locala.IhC.put("openIMRoomMigrateStatus", "INTEGER default '0' ");
    localStringBuilder.append(" openIMRoomMigrateStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "saveByteVersion";
    locala.IhC.put("saveByteVersion", "TEXT");
    localStringBuilder.append(" saveByteVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "handleByteVersion";
    locala.IhC.put("handleByteVersion", "TEXT");
    localStringBuilder.append(" handleByteVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "roomInfoDetailResByte";
    locala.IhC.put("roomInfoDetailResByte", "BLOB");
    localStringBuilder.append(" roomInfoDetailResByte BLOB");
    localStringBuilder.append(", ");
    locala.columns[26] = "oldChatroomVersion";
    locala.IhC.put("oldChatroomVersion", "INTEGER");
    localStringBuilder.append(" oldChatroomVersion INTEGER");
    locala.columns[27] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43163);
  }
  
  public ab()
  {
    AppMethodBeat.i(43135);
    this.Ipl = new a();
    this.Ipm = this.Ipl;
    this.Ipn = new LinkedList();
    this.hRB = new ConcurrentHashMap();
    AppMethodBeat.o(43135);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(43138);
    if (this.field_roomdata == null) {
      parama = new a();
    }
    parama = parama.fVg.iterator();
    while (parama.hasNext())
    {
      b localb = (b)parama.next();
      if ((localb != null) && (localb.userName != null)) {
        this.hRB.put(localb.userName, localb);
      }
    }
    AppMethodBeat.o(43138);
  }
  
  private static a aSJ(String paramString)
  {
    AppMethodBeat.i(43152);
    a locala = new a();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43152);
      return locala;
    }
    int i = paramString.indexOf('<');
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(i);
    }
    Map localMap = bw.M(str1, "RoomData");
    if (localMap == null)
    {
      ad.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
      AppMethodBeat.o(43152);
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
          str2 = bt.bI((String)localMap.get(str2), "");
          if (!bt.isNullOrNil(str2))
          {
            localb.userName = str2;
            localb.fVj = bt.bI((String)localMap.get(str1), "");
            localb.fVk = azA((String)localMap.get(paramString));
            locala.fVg.add(localb);
            i += 1;
          }
        }
        else
        {
          if (i == 0) {
            break label383;
          }
          str2 = ".RoomData.Member" + i + ".$UserName";
          str1 = ".RoomData.Member" + i + ".DisplayName";
          paramString = ".RoomData.Member" + i + ".Flag";
          continue;
        }
        locala.type = azA((String)localMap.get(".RoomData.Type"));
        locala.status = azA((String)localMap.get(".RoomData.Status"));
        locala.maxCount = azA((String)localMap.get(".RoomData.MaxCount"));
        locala.fVh = bt.bI((String)localMap.get(".RoomData.ExtInfo.Upgrader"), "");
        AppMethodBeat.o(43152);
        return locala;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(43152);
        return locala;
      }
      label383:
      paramString = null;
      str1 = null;
      String str2 = null;
    }
  }
  
  public static List<String> aSK(String paramString)
  {
    AppMethodBeat.i(43154);
    LinkedList localLinkedList = new LinkedList();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43154);
      return localLinkedList;
    }
    paramString = paramString.split(";");
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    AppMethodBeat.o(43154);
    return localLinkedList;
  }
  
  private static int azA(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(43151);
    try
    {
      i = bt.getInt(paramString, 0);
      AppMethodBeat.o(43151);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (paramString != null)
        {
          ad.e("MicroMsg.ChatRoomMember", "parserInt error ".concat(String.valueOf(paramString)));
          i = j;
        }
      }
    }
  }
  
  private static String fJ(List<String> paramList)
  {
    AppMethodBeat.i(43153);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(43153);
      return "";
    }
    Object localObject = "";
    int i = 0;
    while (i < paramList.size())
    {
      String str = (String)localObject + (String)paramList.get(i);
      localObject = str;
      if (i < paramList.size() - 1) {
        localObject = str + ";";
      }
      i += 1;
    }
    AppMethodBeat.o(43153);
    return localObject;
  }
  
  public final boolean Az(String paramString)
  {
    AppMethodBeat.i(43162);
    if ((!bt.isNullOrNil(this.field_roomowner)) && (this.field_roomowner.equals(paramString)))
    {
      AppMethodBeat.o(43162);
      return true;
    }
    AppMethodBeat.o(43162);
    return false;
  }
  
  public final void B(String paramString, List<vw> paramList)
  {
    AppMethodBeat.i(43159);
    if (b(this.Ipm)) {
      fpM();
    }
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (vw)paramList.next();
      if (this.hRB.containsKey(((vw)localObject).nDo))
      {
        b localb = (b)this.hRB.get(((vw)localObject).nDo);
        localb.fVj = ((vw)localObject).FVn;
        localb.fVk = ((vw)localObject).FVq;
        localb.fVl = ((vw)localObject).FVr;
      }
    }
    this.Ipm.fVg.clear();
    paramList = this.hRB.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      this.Ipm.fVg.add(this.hRB.get(localObject));
    }
    a(paramString, this.Ipm, false);
    AppMethodBeat.o(43159);
  }
  
  public final boolean YH()
  {
    AppMethodBeat.i(43161);
    if (bt.isNullOrNil(this.field_roomowner))
    {
      AppMethodBeat.o(43161);
      return false;
    }
    String str = u.aAm();
    if ((c)g.ab(c.class) == null)
    {
      ad.e("MicroMsg.ChatRoomMember", "service is null");
      AppMethodBeat.o(43161);
      return false;
    }
    if ((((c)g.ab(c.class)).ZA(this.field_chatroomname)) && (aSH(str))) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = this.field_roomowner.equals(str);
      if ((i == 0) && (!bool)) {
        break;
      }
      AppMethodBeat.o(43161);
      return true;
    }
    AppMethodBeat.o(43161);
    return false;
  }
  
  public final ab a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(43158);
    this.field_modifytime = System.currentTimeMillis();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = null;
      Iterator localIterator = parama.fVg.iterator();
      if (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb.userName == null) || (!localb.userName.equals(paramString))) {
          break label228;
        }
        localObject = localb;
      }
    }
    label228:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        this.field_selfDisplayName = localObject.fVj;
        this.field_isShowname = (localObject.fVk & 0x1);
      }
      for (int i = localObject.fVk;; i = 0)
      {
        ad.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", new Object[] { this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i) });
        parama.dDp = (i & 0x2 | parama.dDp & 0xFFFFFFFD);
        this.field_chatroomdataflag = parama.dDp;
        try
        {
          this.field_roomdata = parama.toByteArray();
          this.Ipm = parama;
          a(parama);
          AppMethodBeat.o(43158);
          return this;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ad.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bt.n(paramString) });
          }
        }
      }
    }
  }
  
  public final List<String> aGo()
  {
    AppMethodBeat.i(43137);
    if ((this.Ipn == null) || (this.Ipn.size() == 0)) {
      this.Ipn = aSK(this.field_memberlist);
    }
    List localList = this.Ipn;
    AppMethodBeat.o(43137);
    return localList;
  }
  
  public final b aSG(String paramString)
  {
    AppMethodBeat.i(43141);
    if (this.hRB == null)
    {
      ad.e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
      AppMethodBeat.o(43141);
      return null;
    }
    if (this.hRB.size() <= 0) {
      fpM();
    }
    paramString = (b)this.hRB.get(paramString);
    AppMethodBeat.o(43141);
    return paramString;
  }
  
  public final boolean aSH(String paramString)
  {
    AppMethodBeat.i(43147);
    paramString = aSG(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43147);
      return false;
    }
    if ((paramString.fVk & 0x800) != 0)
    {
      AppMethodBeat.o(43147);
      return true;
    }
    AppMethodBeat.o(43147);
    return false;
  }
  
  public final String aSI(String paramString)
  {
    AppMethodBeat.i(43149);
    paramString = aSG(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43149);
      return "";
    }
    paramString = bt.bI(paramString.fVl, "");
    AppMethodBeat.o(43149);
    return paramString;
  }
  
  public final void aaN(int paramInt)
  {
    AppMethodBeat.i(43143);
    if (b(this.Ipm)) {
      fpM();
    }
    this.Ipm.dAm = paramInt;
    try
    {
      this.field_roomdata = this.Ipm.toByteArray();
      AppMethodBeat.o(43143);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(43143);
    }
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(43140);
    if (this.Ipl.computeSize() == parama.computeSize())
    {
      AppMethodBeat.o(43140);
      return true;
    }
    AppMethodBeat.o(43140);
    return false;
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(43156);
    try
    {
      this.field_roomdata = parama.toByteArray();
      AppMethodBeat.o(43156);
      return;
    }
    catch (Exception parama)
    {
      ad.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bt.n(parama) });
      AppMethodBeat.o(43156);
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(192563);
    super.convertFrom(paramCursor);
    if ((this.field_roomInfoDetailResByte != null) && (this.field_roomInfoDetailResByte.length > 0)) {
      ad.i("MicroMsg.ChatRoomMember", "handleGetRoomInfoResUnKnownField saveByteVersion:%s handleByteVersion:%s byte:%s", new Object[] { this.field_saveByteVersion, this.field_handleByteVersion, Integer.valueOf(this.field_roomInfoDetailResByte.length) });
    }
    AppMethodBeat.o(192563);
  }
  
  public final a fpL()
  {
    AppMethodBeat.i(43136);
    if (b(this.Ipm)) {
      fpM();
    }
    a locala = this.Ipm;
    AppMethodBeat.o(43136);
    return locala;
  }
  
  public final void fpM()
  {
    AppMethodBeat.i(43139);
    if (bt.cC(this.field_roomdata))
    {
      AppMethodBeat.o(43139);
      return;
    }
    try
    {
      this.Ipm = ((a)new a().parseFrom(this.field_roomdata));
      a(this.Ipm);
      AppMethodBeat.o(43139);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Ipm = new a();
      }
    }
  }
  
  public final int fpN()
  {
    AppMethodBeat.i(43142);
    if (b(this.Ipm)) {
      fpM();
    }
    int i = this.Ipm.dAm;
    AppMethodBeat.o(43142);
    return i;
  }
  
  public final boolean fpO()
  {
    AppMethodBeat.i(43144);
    if (b(this.Ipm)) {
      fpM();
    }
    if (this.Ipm.dAm < this.Ipm.fVi)
    {
      AppMethodBeat.o(43144);
      return true;
    }
    AppMethodBeat.o(43144);
    return false;
  }
  
  public final int fpP()
  {
    AppMethodBeat.i(43146);
    if (b(this.Ipm)) {
      fpM();
    }
    int i = this.Ipm.type;
    AppMethodBeat.o(43146);
    return i;
  }
  
  public final int fpQ()
  {
    AppMethodBeat.i(43148);
    if (b(this.Ipm)) {
      fpM();
    }
    int i = this.Ipm.maxCount;
    AppMethodBeat.o(43148);
    return i;
  }
  
  public final boolean fpR()
  {
    return this.field_isShowname > 0;
  }
  
  public final a fpS()
  {
    AppMethodBeat.i(43160);
    if (b(this.Ipm)) {
      fpM();
    }
    a locala = this.Ipm;
    AppMethodBeat.o(43160);
    return locala;
  }
  
  public final boolean fpT()
  {
    AppMethodBeat.i(192564);
    if (((this.field_chatroomStatus & 0x200000) == 2097152L) && (bt.isNullOrNil(this.field_associateOpenIMRoomName)))
    {
      AppMethodBeat.o(192564);
      return true;
    }
    AppMethodBeat.o(192564);
    return false;
  }
  
  public final boolean fpU()
  {
    return this.field_openIMRoomMigrateStatus == 1;
  }
  
  public final boolean fpV()
  {
    return this.field_openIMRoomMigrateStatus == 2;
  }
  
  public final boolean fpW()
  {
    return (this.field_openIMRoomMigrateStatus == 3) || (this.field_openIMRoomMigrateStatus == 4);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final ab hq(List<String> paramList)
  {
    AppMethodBeat.i(43155);
    this.field_memberlist = fJ(paramList);
    AppMethodBeat.o(43155);
    return this;
  }
  
  public final void lN(int paramInt)
  {
    AppMethodBeat.i(43145);
    if (b(this.Ipm)) {
      fpM();
    }
    this.field_chatroomdataflag = (this.Ipm.dDp & 0xFFFFFFFD | paramInt & 0x2);
    AppMethodBeat.o(43145);
  }
  
  public final ab lV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43157);
    paramString1 = a(paramString1, aSJ(paramString2), false);
    AppMethodBeat.o(43157);
    return paramString1;
  }
  
  public final ab wO(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.field_isShowname = i;
      return this;
    }
  }
  
  public final String zf(String paramString)
  {
    AppMethodBeat.i(43150);
    paramString = aSG(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43150);
      return "";
    }
    paramString = bt.bI(paramString.fVj, "");
    AppMethodBeat.o(43150);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ab
 * JD-Core Version:    0.7.0.1
 */