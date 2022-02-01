package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.as;
import com.tencent.mm.j.a.a.a;
import com.tencent.mm.j.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class x
  extends as
{
  protected static c.a info;
  private a GCS;
  public a GCT;
  private List<String> GCU;
  private Map<String, b> hzg;
  
  static
  {
    AppMethodBeat.i(43163);
    c.a locala = new c.a();
    locala.GvF = new Field[27];
    locala.columns = new String[28];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroomname";
    locala.GvH.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "chatroomname";
    locala.columns[1] = "addtime";
    locala.GvH.put("addtime", "LONG");
    localStringBuilder.append(" addtime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "memberlist";
    locala.GvH.put("memberlist", "TEXT");
    localStringBuilder.append(" memberlist TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "displayname";
    locala.GvH.put("displayname", "TEXT");
    localStringBuilder.append(" displayname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "chatroomnick";
    locala.GvH.put("chatroomnick", "TEXT");
    localStringBuilder.append(" chatroomnick TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "roomflag";
    locala.GvH.put("roomflag", "INTEGER");
    localStringBuilder.append(" roomflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "roomowner";
    locala.GvH.put("roomowner", "TEXT");
    localStringBuilder.append(" roomowner TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "roomdata";
    locala.GvH.put("roomdata", "BLOB");
    localStringBuilder.append(" roomdata BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "isShowname";
    locala.GvH.put("isShowname", "INTEGER");
    localStringBuilder.append(" isShowname INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "selfDisplayName";
    locala.GvH.put("selfDisplayName", "TEXT");
    localStringBuilder.append(" selfDisplayName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "style";
    locala.GvH.put("style", "INTEGER");
    localStringBuilder.append(" style INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatroomdataflag";
    locala.GvH.put("chatroomdataflag", "INTEGER");
    localStringBuilder.append(" chatroomdataflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "modifytime";
    locala.GvH.put("modifytime", "LONG");
    localStringBuilder.append(" modifytime LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "chatroomnotice";
    locala.GvH.put("chatroomnotice", "TEXT");
    localStringBuilder.append(" chatroomnotice TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "chatroomVersion";
    locala.GvH.put("chatroomVersion", "INTEGER");
    localStringBuilder.append(" chatroomVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "chatroomnoticeEditor";
    locala.GvH.put("chatroomnoticeEditor", "TEXT");
    localStringBuilder.append(" chatroomnoticeEditor TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomnoticePublishTime";
    locala.GvH.put("chatroomnoticePublishTime", "LONG");
    localStringBuilder.append(" chatroomnoticePublishTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "chatroomLocalVersion";
    locala.GvH.put("chatroomLocalVersion", "LONG");
    localStringBuilder.append(" chatroomLocalVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "chatroomStatus";
    locala.GvH.put("chatroomStatus", "INTEGER default '0' ");
    localStringBuilder.append(" chatroomStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "memberCount";
    locala.GvH.put("memberCount", "INTEGER default '-1' ");
    localStringBuilder.append(" memberCount INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "chatroomfamilystatusmodifytime";
    locala.GvH.put("chatroomfamilystatusmodifytime", "LONG default '0' ");
    localStringBuilder.append(" chatroomfamilystatusmodifytime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "associateOpenIMRoomName";
    locala.GvH.put("associateOpenIMRoomName", "TEXT");
    localStringBuilder.append(" associateOpenIMRoomName TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "openIMRoomMigrateStatus";
    locala.GvH.put("openIMRoomMigrateStatus", "INTEGER default '0' ");
    localStringBuilder.append(" openIMRoomMigrateStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "saveByteVersion";
    locala.GvH.put("saveByteVersion", "TEXT");
    localStringBuilder.append(" saveByteVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "handleByteVersion";
    locala.GvH.put("handleByteVersion", "TEXT");
    localStringBuilder.append(" handleByteVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "roomInfoDetailResByte";
    locala.GvH.put("roomInfoDetailResByte", "BLOB");
    localStringBuilder.append(" roomInfoDetailResByte BLOB");
    localStringBuilder.append(", ");
    locala.columns[26] = "oldChatroomVersion";
    locala.GvH.put("oldChatroomVersion", "INTEGER");
    localStringBuilder.append(" oldChatroomVersion INTEGER");
    locala.columns[27] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43163);
  }
  
  public x()
  {
    AppMethodBeat.i(43135);
    this.GCS = new a();
    this.GCT = this.GCS;
    this.GCU = new LinkedList();
    this.hzg = new ConcurrentHashMap();
    AppMethodBeat.o(43135);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(43138);
    if (this.field_roomdata == null) {
      parama = new a();
    }
    parama = parama.fBS.iterator();
    while (parama.hasNext())
    {
      b localb = (b)parama.next();
      if ((localb != null) && (localb.userName != null)) {
        this.hzg.put(localb.userName, localb);
      }
    }
    AppMethodBeat.o(43138);
  }
  
  private static a aMW(String paramString)
  {
    AppMethodBeat.i(43152);
    a locala = new a();
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43152);
      return locala;
    }
    int i = paramString.indexOf('<');
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(i);
    }
    Map localMap = bv.L(str1, "RoomData");
    if (localMap == null)
    {
      ac.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
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
          str2 = bs.bG((String)localMap.get(str2), "");
          if (!bs.isNullOrNil(str2))
          {
            localb.userName = str2;
            localb.fBV = bs.bG((String)localMap.get(str1), "");
            localb.fBW = auu((String)localMap.get(paramString));
            locala.fBS.add(localb);
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
        locala.type = auu((String)localMap.get(".RoomData.Type"));
        locala.status = auu((String)localMap.get(".RoomData.Status"));
        locala.maxCount = auu((String)localMap.get(".RoomData.MaxCount"));
        locala.fBT = bs.bG((String)localMap.get(".RoomData.ExtInfo.Upgrader"), "");
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
  
  public static List<String> aMX(String paramString)
  {
    AppMethodBeat.i(43154);
    LinkedList localLinkedList = new LinkedList();
    if (bs.isNullOrNil(paramString))
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
  
  private static int auu(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(43151);
    try
    {
      i = bs.getInt(paramString, 0);
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
          ac.e("MicroMsg.ChatRoomMember", "parserInt error ".concat(String.valueOf(paramString)));
          i = j;
        }
      }
    }
  }
  
  private static String fw(List<String> paramList)
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
  
  public final boolean Wp()
  {
    AppMethodBeat.i(43161);
    if (bs.isNullOrNil(this.field_roomowner))
    {
      AppMethodBeat.o(43161);
      return false;
    }
    String str = u.axw();
    if ((c)g.ab(c.class) == null)
    {
      ac.e("MicroMsg.ChatRoomMember", "service is null");
      AppMethodBeat.o(43161);
      return false;
    }
    if ((((c)g.ab(c.class)).VR(this.field_chatroomname)) && (aMU(str))) {}
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
  
  public final void YE(int paramInt)
  {
    AppMethodBeat.i(43143);
    if (b(this.GCT)) {
      eZK();
    }
    this.GCT.doy = paramInt;
    try
    {
      this.field_roomdata = this.GCT.toByteArray();
      AppMethodBeat.o(43143);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(43143);
    }
  }
  
  public final x a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(43158);
    this.field_modifytime = System.currentTimeMillis();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = null;
      Iterator localIterator = parama.fBS.iterator();
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
        this.field_selfDisplayName = localObject.fBV;
        this.field_isShowname = (localObject.fBW & 0x1);
      }
      for (int i = localObject.fBW;; i = 0)
      {
        ac.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", new Object[] { this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i) });
        parama.drx = (i & 0x2 | parama.drx & 0xFFFFFFFD);
        this.field_chatroomdataflag = parama.drx;
        try
        {
          this.field_roomdata = parama.toByteArray();
          this.GCT = parama;
          a(parama);
          AppMethodBeat.o(43158);
          return this;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ac.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bs.m(paramString) });
          }
        }
      }
    }
  }
  
  public final List<String> aDl()
  {
    AppMethodBeat.i(43137);
    if ((this.GCU == null) || (this.GCU.size() == 0)) {
      this.GCU = aMX(this.field_memberlist);
    }
    List localList = this.GCU;
    AppMethodBeat.o(43137);
    return localList;
  }
  
  public final b aMT(String paramString)
  {
    AppMethodBeat.i(43141);
    if (this.hzg == null)
    {
      ac.e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
      AppMethodBeat.o(43141);
      return null;
    }
    if (this.hzg.size() <= 0) {
      eZK();
    }
    paramString = (b)this.hzg.get(paramString);
    AppMethodBeat.o(43141);
    return paramString;
  }
  
  public final boolean aMU(String paramString)
  {
    AppMethodBeat.i(43147);
    paramString = aMT(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43147);
      return false;
    }
    if ((paramString.fBW & 0x800) != 0)
    {
      AppMethodBeat.o(43147);
      return true;
    }
    AppMethodBeat.o(43147);
    return false;
  }
  
  public final String aMV(String paramString)
  {
    AppMethodBeat.i(43149);
    paramString = aMT(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43149);
      return "";
    }
    paramString = bs.bG(paramString.fBX, "");
    AppMethodBeat.o(43149);
    return paramString;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(43140);
    if (this.GCS.computeSize() == parama.computeSize())
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
      ac.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bs.m(parama) });
      AppMethodBeat.o(43156);
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(194053);
    super.convertFrom(paramCursor);
    if ((this.field_roomInfoDetailResByte != null) && (this.field_roomInfoDetailResByte.length > 0)) {
      ac.i("MicroMsg.ChatRoomMember", "handleGetRoomInfoResUnKnownField saveByteVersion:%s handleByteVersion:%s byte:%s", new Object[] { this.field_saveByteVersion, this.field_handleByteVersion, Integer.valueOf(this.field_roomInfoDetailResByte.length) });
    }
    AppMethodBeat.o(194053);
  }
  
  public final a eZJ()
  {
    AppMethodBeat.i(43136);
    if (b(this.GCT)) {
      eZK();
    }
    a locala = this.GCT;
    AppMethodBeat.o(43136);
    return locala;
  }
  
  public final void eZK()
  {
    AppMethodBeat.i(43139);
    if (bs.cv(this.field_roomdata))
    {
      AppMethodBeat.o(43139);
      return;
    }
    try
    {
      this.GCT = ((a)new a().parseFrom(this.field_roomdata));
      a(this.GCT);
      AppMethodBeat.o(43139);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.GCT = new a();
      }
    }
  }
  
  public final int eZL()
  {
    AppMethodBeat.i(43142);
    if (b(this.GCT)) {
      eZK();
    }
    int i = this.GCT.doy;
    AppMethodBeat.o(43142);
    return i;
  }
  
  public final boolean eZM()
  {
    AppMethodBeat.i(43144);
    if (b(this.GCT)) {
      eZK();
    }
    if (this.GCT.doy < this.GCT.fBU)
    {
      AppMethodBeat.o(43144);
      return true;
    }
    AppMethodBeat.o(43144);
    return false;
  }
  
  public final int eZN()
  {
    AppMethodBeat.i(43146);
    if (b(this.GCT)) {
      eZK();
    }
    int i = this.GCT.type;
    AppMethodBeat.o(43146);
    return i;
  }
  
  public final int eZO()
  {
    AppMethodBeat.i(43148);
    if (b(this.GCT)) {
      eZK();
    }
    int i = this.GCT.maxCount;
    AppMethodBeat.o(43148);
    return i;
  }
  
  public final boolean eZP()
  {
    return this.field_isShowname > 0;
  }
  
  public final a eZQ()
  {
    AppMethodBeat.i(43160);
    if (b(this.GCT)) {
      eZK();
    }
    a locala = this.GCT;
    AppMethodBeat.o(43160);
    return locala;
  }
  
  public final boolean eZR()
  {
    AppMethodBeat.i(194054);
    if (((this.field_chatroomStatus & 0x200000) == 2097152L) && (bs.isNullOrNil(this.field_associateOpenIMRoomName)))
    {
      AppMethodBeat.o(194054);
      return true;
    }
    AppMethodBeat.o(194054);
    return false;
  }
  
  public final boolean eZS()
  {
    return this.field_openIMRoomMigrateStatus == 1;
  }
  
  public final boolean eZT()
  {
    return this.field_openIMRoomMigrateStatus == 2;
  }
  
  public final boolean eZU()
  {
    return (this.field_openIMRoomMigrateStatus == 3) || (this.field_openIMRoomMigrateStatus == 4);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final x he(List<String> paramList)
  {
    AppMethodBeat.i(43155);
    this.field_memberlist = fw(paramList);
    AppMethodBeat.o(43155);
    return this;
  }
  
  public final void lo(int paramInt)
  {
    AppMethodBeat.i(43145);
    if (b(this.GCT)) {
      eZK();
    }
    this.field_chatroomdataflag = (this.GCT.drx & 0xFFFFFFFD | paramInt & 0x2);
    AppMethodBeat.o(43145);
  }
  
  public final x lx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43157);
    paramString1 = a(paramString1, aMW(paramString2), false);
    AppMethodBeat.o(43157);
    return paramString1;
  }
  
  public final x wc(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.field_isShowname = i;
      return this;
    }
  }
  
  public final String wk(String paramString)
  {
    AppMethodBeat.i(43150);
    paramString = aMT(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43150);
      return "";
    }
    paramString = bs.bG(paramString.fBV, "");
    AppMethodBeat.o(43150);
    return paramString;
  }
  
  public final boolean xB(String paramString)
  {
    AppMethodBeat.i(43162);
    if ((!bs.isNullOrNil(this.field_roomowner)) && (this.field_roomowner.equals(paramString)))
    {
      AppMethodBeat.o(43162);
      return true;
    }
    AppMethodBeat.o(43162);
    return false;
  }
  
  public final void z(String paramString, List<ub> paramList)
  {
    AppMethodBeat.i(43159);
    if (b(this.GCT)) {
      eZK();
    }
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (ub)paramList.next();
      if (this.hzg.containsKey(((ub)localObject).ncR))
      {
        b localb = (b)this.hzg.get(((ub)localObject).ncR);
        localb.fBV = ((ub)localObject).Eoe;
        localb.fBW = ((ub)localObject).Eoh;
        localb.fBX = ((ub)localObject).Eoi;
      }
    }
    this.GCT.fBS.clear();
    paramList = this.hzg.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      this.GCT.fBS.add(this.hzg.get(localObject));
    }
    a(paramString, this.GCT, false);
    AppMethodBeat.o(43159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.x
 * JD-Core Version:    0.7.0.1
 */