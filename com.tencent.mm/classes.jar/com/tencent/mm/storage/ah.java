package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.au;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class ah
  extends au
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public a VfA;
  private List<String> VfB;
  private a Vfz;
  private Map<String, com.tencent.mm.k.a.a.b> lFW;
  
  static
  {
    AppMethodBeat.i(43163);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[28];
    localMAutoDBInfo.columns = new String[29];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "chatroomname";
    localMAutoDBInfo.colsMap.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "chatroomname";
    localMAutoDBInfo.columns[1] = "addtime";
    localMAutoDBInfo.colsMap.put("addtime", "LONG");
    localStringBuilder.append(" addtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "memberlist";
    localMAutoDBInfo.colsMap.put("memberlist", "TEXT");
    localStringBuilder.append(" memberlist TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "displayname";
    localMAutoDBInfo.colsMap.put("displayname", "TEXT");
    localStringBuilder.append(" displayname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "chatroomnick";
    localMAutoDBInfo.colsMap.put("chatroomnick", "TEXT");
    localStringBuilder.append(" chatroomnick TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "roomflag";
    localMAutoDBInfo.colsMap.put("roomflag", "INTEGER");
    localStringBuilder.append(" roomflag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "roomowner";
    localMAutoDBInfo.colsMap.put("roomowner", "TEXT");
    localStringBuilder.append(" roomowner TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "roomdata";
    localMAutoDBInfo.colsMap.put("roomdata", "BLOB");
    localStringBuilder.append(" roomdata BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "isShowname";
    localMAutoDBInfo.colsMap.put("isShowname", "INTEGER");
    localStringBuilder.append(" isShowname INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "selfDisplayName";
    localMAutoDBInfo.colsMap.put("selfDisplayName", "TEXT");
    localStringBuilder.append(" selfDisplayName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "style";
    localMAutoDBInfo.colsMap.put("style", "INTEGER");
    localStringBuilder.append(" style INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "chatroomdataflag";
    localMAutoDBInfo.colsMap.put("chatroomdataflag", "INTEGER");
    localStringBuilder.append(" chatroomdataflag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "modifytime";
    localMAutoDBInfo.colsMap.put("modifytime", "LONG");
    localStringBuilder.append(" modifytime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "chatroomnotice";
    localMAutoDBInfo.colsMap.put("chatroomnotice", "TEXT");
    localStringBuilder.append(" chatroomnotice TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "chatroomVersion";
    localMAutoDBInfo.colsMap.put("chatroomVersion", "INTEGER");
    localStringBuilder.append(" chatroomVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "chatroomnoticeEditor";
    localMAutoDBInfo.colsMap.put("chatroomnoticeEditor", "TEXT");
    localStringBuilder.append(" chatroomnoticeEditor TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "chatroomnoticePublishTime";
    localMAutoDBInfo.colsMap.put("chatroomnoticePublishTime", "LONG");
    localStringBuilder.append(" chatroomnoticePublishTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "chatroomNoticeNew";
    localMAutoDBInfo.colsMap.put("chatroomNoticeNew", "INTEGER");
    localStringBuilder.append(" chatroomNoticeNew INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "chatroomLocalVersion";
    localMAutoDBInfo.colsMap.put("chatroomLocalVersion", "LONG");
    localStringBuilder.append(" chatroomLocalVersion LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "chatroomStatus";
    localMAutoDBInfo.colsMap.put("chatroomStatus", "INTEGER default '0' ");
    localStringBuilder.append(" chatroomStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "memberCount";
    localMAutoDBInfo.colsMap.put("memberCount", "INTEGER default '-1' ");
    localStringBuilder.append(" memberCount INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "chatroomfamilystatusmodifytime";
    localMAutoDBInfo.colsMap.put("chatroomfamilystatusmodifytime", "LONG default '0' ");
    localStringBuilder.append(" chatroomfamilystatusmodifytime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "associateOpenIMRoomName";
    localMAutoDBInfo.colsMap.put("associateOpenIMRoomName", "TEXT");
    localStringBuilder.append(" associateOpenIMRoomName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "openIMRoomMigrateStatus";
    localMAutoDBInfo.colsMap.put("openIMRoomMigrateStatus", "INTEGER default '0' ");
    localStringBuilder.append(" openIMRoomMigrateStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "saveByteVersion";
    localMAutoDBInfo.colsMap.put("saveByteVersion", "TEXT");
    localStringBuilder.append(" saveByteVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "handleByteVersion";
    localMAutoDBInfo.colsMap.put("handleByteVersion", "TEXT");
    localStringBuilder.append(" handleByteVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "roomInfoDetailResByte";
    localMAutoDBInfo.colsMap.put("roomInfoDetailResByte", "BLOB");
    localStringBuilder.append(" roomInfoDetailResByte BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "oldChatroomVersion";
    localMAutoDBInfo.colsMap.put("oldChatroomVersion", "INTEGER");
    localStringBuilder.append(" oldChatroomVersion INTEGER");
    localMAutoDBInfo.columns[28] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(43163);
  }
  
  public ah()
  {
    AppMethodBeat.i(43135);
    this.Vfz = new a();
    this.VfA = this.Vfz;
    this.VfB = new LinkedList();
    this.lFW = new ConcurrentHashMap();
    AppMethodBeat.o(43135);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(43138);
    if (this.field_roomdata == null) {
      parama = new a();
    }
    parama = parama.jmy.iterator();
    while (parama.hasNext())
    {
      com.tencent.mm.k.a.a.b localb = (com.tencent.mm.k.a.a.b)parama.next();
      if ((localb != null) && (localb.userName != null)) {
        this.lFW.put(localb.userName, localb);
      }
    }
    AppMethodBeat.o(43138);
  }
  
  private static int baK(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(43151);
    try
    {
      i = Util.getInt(paramString, 0);
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
          Log.e("MicroMsg.ChatRoomMember", "parserInt error ".concat(String.valueOf(paramString)));
          i = j;
        }
      }
    }
  }
  
  private static a bvB(String paramString)
  {
    AppMethodBeat.i(43152);
    a locala = new a();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43152);
      return locala;
    }
    int i = paramString.indexOf('<');
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(i);
    }
    Map localMap = XmlParser.parseXml(str1, "RoomData", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
      AppMethodBeat.o(43152);
      return null;
    }
    i = 0;
    for (;;)
    {
      try
      {
        com.tencent.mm.k.a.a.b localb = new com.tencent.mm.k.a.a.b();
        if (i == 0)
        {
          str2 = ".RoomData.Member.$UserName";
          str1 = ".RoomData.Member.DisplayName";
          paramString = ".RoomData.Member.Flag";
          str2 = Util.nullAs((String)localMap.get(str2), "");
          if (!Util.isNullOrNil(str2))
          {
            localb.userName = str2;
            localb.jmB = Util.nullAs((String)localMap.get(str1), "");
            localb.jmC = baK((String)localMap.get(paramString));
            locala.jmy.add(localb);
            i += 1;
          }
        }
        else
        {
          if (i == 0) {
            break label384;
          }
          str2 = ".RoomData.Member" + i + ".$UserName";
          str1 = ".RoomData.Member" + i + ".DisplayName";
          paramString = ".RoomData.Member" + i + ".Flag";
          continue;
        }
        locala.type = baK((String)localMap.get(".RoomData.Type"));
        locala.status = baK((String)localMap.get(".RoomData.Status"));
        locala.iWH = baK((String)localMap.get(".RoomData.MaxCount"));
        locala.jmz = Util.nullAs((String)localMap.get(".RoomData.ExtInfo.Upgrader"), "");
        AppMethodBeat.o(43152);
        return locala;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(43152);
        return locala;
      }
      label384:
      paramString = null;
      str1 = null;
      String str2 = null;
    }
  }
  
  public static List<String> bvC(String paramString)
  {
    AppMethodBeat.i(43154);
    LinkedList localLinkedList = new LinkedList();
    if (Util.isNullOrNil(paramString))
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
  
  private static String hy(List<String> paramList)
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
  
  public final ah ET(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.field_isShowname = i;
      return this;
    }
  }
  
  public final void H(String paramString, List<xn> paramList)
  {
    AppMethodBeat.i(43159);
    if (b(this.VfA)) {
      hxD();
    }
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (xn)paramList.next();
      if (this.lFW.containsKey(((xn)localObject).UserName))
      {
        com.tencent.mm.k.a.a.b localb = (com.tencent.mm.k.a.a.b)this.lFW.get(((xn)localObject).UserName);
        localb.jmB = ((xn)localObject).SjH;
        localb.jmC = ((xn)localObject).SjK;
        localb.jmD = ((xn)localObject).SjL;
      }
    }
    this.VfA.jmy.clear();
    paramList = this.lFW.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      this.VfA.jmy.add(this.lFW.get(localObject));
    }
    a(paramString, this.VfA, false);
    AppMethodBeat.o(43159);
  }
  
  public final String PJ(String paramString)
  {
    AppMethodBeat.i(43150);
    paramString = bvz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43150);
      return "";
    }
    paramString = Util.nullAs(paramString.jmB, "");
    AppMethodBeat.o(43150);
    return paramString;
  }
  
  public final boolean Rh(String paramString)
  {
    AppMethodBeat.i(43162);
    if ((!Util.isNullOrNil(this.field_roomowner)) && (this.field_roomowner.equals(paramString)))
    {
      AppMethodBeat.o(43162);
      return true;
    }
    AppMethodBeat.o(43162);
    return false;
  }
  
  public final ah a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(43158);
    this.field_modifytime = System.currentTimeMillis();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = null;
      Iterator localIterator = parama.jmy.iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.k.a.a.b localb = (com.tencent.mm.k.a.a.b)localIterator.next();
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
        this.field_selfDisplayName = localObject.jmB;
        this.field_isShowname = (localObject.jmC & 0x1);
      }
      for (int i = localObject.jmC;; i = 0)
      {
        Log.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", new Object[] { this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i) });
        parama.cUP = (i & 0x2 | parama.cUP & 0xFFFFFFFD);
        this.field_chatroomdataflag = parama.cUP;
        try
        {
          this.field_roomdata = parama.toByteArray();
          this.VfA = parama;
          a(parama);
          AppMethodBeat.o(43158);
          return this;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          }
        }
      }
    }
  }
  
  public final void asA(int paramInt)
  {
    AppMethodBeat.i(43143);
    if (b(this.VfA)) {
      hxD();
    }
    this.VfA.fMC = paramInt;
    try
    {
      this.field_roomdata = this.VfA.toByteArray();
      AppMethodBeat.o(43143);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(43143);
    }
  }
  
  public final boolean asE()
  {
    AppMethodBeat.i(43161);
    if (Util.isNullOrNil(this.field_roomowner))
    {
      AppMethodBeat.o(43161);
      return false;
    }
    String str = z.bcZ();
    if ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class) == null)
    {
      Log.e("MicroMsg.ChatRoomMember", "service is null");
      AppMethodBeat.o(43161);
      return false;
    }
    if ((((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).asl(this.field_chatroomname)) && (bvA(str))) {}
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
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(43140);
    if (this.Vfz.computeSize() == parama.computeSize())
    {
      AppMethodBeat.o(43140);
      return true;
    }
    AppMethodBeat.o(43140);
    return false;
  }
  
  public final List<String> bjL()
  {
    AppMethodBeat.i(43137);
    if ((this.VfB == null) || (this.VfB.size() == 0)) {
      this.VfB = bvC(this.field_memberlist);
    }
    List localList = this.VfB;
    AppMethodBeat.o(43137);
    return localList;
  }
  
  public final boolean bvA(String paramString)
  {
    AppMethodBeat.i(43147);
    paramString = bvz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43147);
      return false;
    }
    if ((paramString.jmC & 0x800) != 0)
    {
      AppMethodBeat.o(43147);
      return true;
    }
    AppMethodBeat.o(43147);
    return false;
  }
  
  public final com.tencent.mm.k.a.a.b bvz(String paramString)
  {
    AppMethodBeat.i(43141);
    if (this.lFW == null)
    {
      Log.e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
      AppMethodBeat.o(43141);
      return null;
    }
    if (this.lFW.size() <= 0) {
      hxD();
    }
    paramString = (com.tencent.mm.k.a.a.b)this.lFW.get(paramString);
    AppMethodBeat.o(43141);
    return paramString;
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
      Log.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
      AppMethodBeat.o(43156);
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(240934);
    super.convertFrom(paramCursor);
    if ((this.field_roomInfoDetailResByte != null) && (this.field_roomInfoDetailResByte.length > 0)) {
      Log.i("MicroMsg.ChatRoomMember", "handleGetRoomInfoResUnKnownField saveByteVersion:%s handleByteVersion:%s byte:%s", new Object[] { this.field_saveByteVersion, this.field_handleByteVersion, Integer.valueOf(this.field_roomInfoDetailResByte.length) });
    }
    AppMethodBeat.o(240934);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final a hxC()
  {
    AppMethodBeat.i(43136);
    if (b(this.VfA)) {
      hxD();
    }
    a locala = this.VfA;
    AppMethodBeat.o(43136);
    return locala;
  }
  
  public final void hxD()
  {
    AppMethodBeat.i(43139);
    if (Util.isNullOrNil(this.field_roomdata))
    {
      AppMethodBeat.o(43139);
      return;
    }
    try
    {
      this.VfA = ((a)new a().parseFrom(this.field_roomdata));
      a(this.VfA);
      AppMethodBeat.o(43139);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.VfA = new a();
      }
    }
  }
  
  public final int hxE()
  {
    AppMethodBeat.i(43142);
    if (b(this.VfA)) {
      hxD();
    }
    int i = this.VfA.fMC;
    AppMethodBeat.o(43142);
    return i;
  }
  
  public final boolean hxF()
  {
    AppMethodBeat.i(43144);
    if (b(this.VfA)) {
      hxD();
    }
    if (this.VfA.fMC < this.VfA.jmA)
    {
      AppMethodBeat.o(43144);
      return true;
    }
    AppMethodBeat.o(43144);
    return false;
  }
  
  public final int hxG()
  {
    AppMethodBeat.i(43146);
    if (b(this.VfA)) {
      hxD();
    }
    int i = this.VfA.type;
    AppMethodBeat.o(43146);
    return i;
  }
  
  public final int hxH()
  {
    AppMethodBeat.i(43148);
    if (b(this.VfA)) {
      hxD();
    }
    int i = this.VfA.iWH;
    AppMethodBeat.o(43148);
    return i;
  }
  
  public final boolean hxI()
  {
    return this.field_isShowname > 0;
  }
  
  public final a hxJ()
  {
    AppMethodBeat.i(43160);
    if (b(this.VfA)) {
      hxD();
    }
    a locala = this.VfA;
    AppMethodBeat.o(43160);
    return locala;
  }
  
  public final boolean hxK()
  {
    AppMethodBeat.i(240952);
    if (((this.field_chatroomStatus & 0x200000) == 2097152L) && (Util.isNullOrNil(this.field_associateOpenIMRoomName)))
    {
      AppMethodBeat.o(240952);
      return true;
    }
    AppMethodBeat.o(240952);
    return false;
  }
  
  public final boolean hxL()
  {
    return this.field_openIMRoomMigrateStatus == 1;
  }
  
  public final boolean hxM()
  {
    return this.field_openIMRoomMigrateStatus == 2;
  }
  
  public final boolean hxN()
  {
    return (this.field_openIMRoomMigrateStatus == 3) || (this.field_openIMRoomMigrateStatus == 4);
  }
  
  public final ah jw(List<String> paramList)
  {
    AppMethodBeat.i(43155);
    this.field_memberlist = hy(paramList);
    AppMethodBeat.o(43155);
    return this;
  }
  
  public final ah nH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43157);
    paramString1 = a(paramString1, bvB(paramString2), false);
    AppMethodBeat.o(43157);
    return paramString1;
  }
  
  public final void rl(int paramInt)
  {
    AppMethodBeat.i(43145);
    if (b(this.VfA)) {
      hxD();
    }
    this.field_chatroomdataflag = (this.VfA.cUP & 0xFFFFFFFD | paramInt & 0x2);
    AppMethodBeat.o(43145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.ah
 * JD-Core Version:    0.7.0.1
 */