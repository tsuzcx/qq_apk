package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.at;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.k.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class ac
  extends at
{
  protected static c.a info;
  private a IJF;
  public a IJG;
  private List<String> IJH;
  private Map<String, b> hUt;
  
  static
  {
    AppMethodBeat.i(43163);
    c.a locala = new c.a();
    locala.IBL = new Field[27];
    locala.columns = new String[28];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroomname";
    locala.IBN.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "chatroomname";
    locala.columns[1] = "addtime";
    locala.IBN.put("addtime", "LONG");
    localStringBuilder.append(" addtime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "memberlist";
    locala.IBN.put("memberlist", "TEXT");
    localStringBuilder.append(" memberlist TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "displayname";
    locala.IBN.put("displayname", "TEXT");
    localStringBuilder.append(" displayname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "chatroomnick";
    locala.IBN.put("chatroomnick", "TEXT");
    localStringBuilder.append(" chatroomnick TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "roomflag";
    locala.IBN.put("roomflag", "INTEGER");
    localStringBuilder.append(" roomflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "roomowner";
    locala.IBN.put("roomowner", "TEXT");
    localStringBuilder.append(" roomowner TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "roomdata";
    locala.IBN.put("roomdata", "BLOB");
    localStringBuilder.append(" roomdata BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "isShowname";
    locala.IBN.put("isShowname", "INTEGER");
    localStringBuilder.append(" isShowname INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "selfDisplayName";
    locala.IBN.put("selfDisplayName", "TEXT");
    localStringBuilder.append(" selfDisplayName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "style";
    locala.IBN.put("style", "INTEGER");
    localStringBuilder.append(" style INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatroomdataflag";
    locala.IBN.put("chatroomdataflag", "INTEGER");
    localStringBuilder.append(" chatroomdataflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "modifytime";
    locala.IBN.put("modifytime", "LONG");
    localStringBuilder.append(" modifytime LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "chatroomnotice";
    locala.IBN.put("chatroomnotice", "TEXT");
    localStringBuilder.append(" chatroomnotice TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "chatroomVersion";
    locala.IBN.put("chatroomVersion", "INTEGER");
    localStringBuilder.append(" chatroomVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "chatroomnoticeEditor";
    locala.IBN.put("chatroomnoticeEditor", "TEXT");
    localStringBuilder.append(" chatroomnoticeEditor TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomnoticePublishTime";
    locala.IBN.put("chatroomnoticePublishTime", "LONG");
    localStringBuilder.append(" chatroomnoticePublishTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "chatroomLocalVersion";
    locala.IBN.put("chatroomLocalVersion", "LONG");
    localStringBuilder.append(" chatroomLocalVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "chatroomStatus";
    locala.IBN.put("chatroomStatus", "INTEGER default '0' ");
    localStringBuilder.append(" chatroomStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "memberCount";
    locala.IBN.put("memberCount", "INTEGER default '-1' ");
    localStringBuilder.append(" memberCount INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "chatroomfamilystatusmodifytime";
    locala.IBN.put("chatroomfamilystatusmodifytime", "LONG default '0' ");
    localStringBuilder.append(" chatroomfamilystatusmodifytime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "associateOpenIMRoomName";
    locala.IBN.put("associateOpenIMRoomName", "TEXT");
    localStringBuilder.append(" associateOpenIMRoomName TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "openIMRoomMigrateStatus";
    locala.IBN.put("openIMRoomMigrateStatus", "INTEGER default '0' ");
    localStringBuilder.append(" openIMRoomMigrateStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[23] = "saveByteVersion";
    locala.IBN.put("saveByteVersion", "TEXT");
    localStringBuilder.append(" saveByteVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "handleByteVersion";
    locala.IBN.put("handleByteVersion", "TEXT");
    localStringBuilder.append(" handleByteVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "roomInfoDetailResByte";
    locala.IBN.put("roomInfoDetailResByte", "BLOB");
    localStringBuilder.append(" roomInfoDetailResByte BLOB");
    localStringBuilder.append(", ");
    locala.columns[26] = "oldChatroomVersion";
    locala.IBN.put("oldChatroomVersion", "INTEGER");
    localStringBuilder.append(" oldChatroomVersion INTEGER");
    locala.columns[27] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43163);
  }
  
  public ac()
  {
    AppMethodBeat.i(43135);
    this.IJF = new a();
    this.IJG = this.IJF;
    this.IJH = new LinkedList();
    this.hUt = new ConcurrentHashMap();
    AppMethodBeat.o(43135);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(43138);
    if (this.field_roomdata == null) {
      parama = new a();
    }
    parama = parama.fXm.iterator();
    while (parama.hasNext())
    {
      b localb = (b)parama.next();
      if ((localb != null) && (localb.userName != null)) {
        this.hUt.put(localb.userName, localb);
      }
    }
    AppMethodBeat.o(43138);
  }
  
  private static int aAR(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(43151);
    try
    {
      i = bu.getInt(paramString, 0);
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
          ae.e("MicroMsg.ChatRoomMember", "parserInt error ".concat(String.valueOf(paramString)));
          i = j;
        }
      }
    }
  }
  
  private static a aUi(String paramString)
  {
    AppMethodBeat.i(43152);
    a locala = new a();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43152);
      return locala;
    }
    int i = paramString.indexOf('<');
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(i);
    }
    Map localMap = bx.M(str1, "RoomData");
    if (localMap == null)
    {
      ae.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
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
          str2 = bu.bI((String)localMap.get(str2), "");
          if (!bu.isNullOrNil(str2))
          {
            localb.userName = str2;
            localb.fXp = bu.bI((String)localMap.get(str1), "");
            localb.fXq = aAR((String)localMap.get(paramString));
            locala.fXm.add(localb);
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
        locala.type = aAR((String)localMap.get(".RoomData.Type"));
        locala.status = aAR((String)localMap.get(".RoomData.Status"));
        locala.maxCount = aAR((String)localMap.get(".RoomData.MaxCount"));
        locala.fXn = bu.bI((String)localMap.get(".RoomData.ExtInfo.Upgrader"), "");
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
  
  public static List<String> aUj(String paramString)
  {
    AppMethodBeat.i(43154);
    LinkedList localLinkedList = new LinkedList();
    if (bu.isNullOrNil(paramString))
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
  
  private static String fS(List<String> paramList)
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
  
  public final boolean Bj(String paramString)
  {
    AppMethodBeat.i(43162);
    if ((!bu.isNullOrNil(this.field_roomowner)) && (this.field_roomowner.equals(paramString)))
    {
      AppMethodBeat.o(43162);
      return true;
    }
    AppMethodBeat.o(43162);
    return false;
  }
  
  public final void C(String paramString, List<vz> paramList)
  {
    AppMethodBeat.i(43159);
    if (b(this.IJG)) {
      ftM();
    }
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (vz)paramList.next();
      if (this.hUt.containsKey(((vz)localObject).nIJ))
      {
        b localb = (b)this.hUt.get(((vz)localObject).nIJ);
        localb.fXp = ((vz)localObject).GnM;
        localb.fXq = ((vz)localObject).GnP;
        localb.fXr = ((vz)localObject).GnQ;
      }
    }
    this.IJG.fXm.clear();
    paramList = this.hUt.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      this.IJG.fXm.add(this.hUt.get(localObject));
    }
    a(paramString, this.IJG, false);
    AppMethodBeat.o(43159);
  }
  
  public final boolean YQ()
  {
    AppMethodBeat.i(43161);
    if (bu.isNullOrNil(this.field_roomowner))
    {
      AppMethodBeat.o(43161);
      return false;
    }
    String str = v.aAC();
    if ((c)g.ab(c.class) == null)
    {
      ae.e("MicroMsg.ChatRoomMember", "service is null");
      AppMethodBeat.o(43161);
      return false;
    }
    if ((((c)g.ab(c.class)).aar(this.field_chatroomname)) && (aUg(str))) {}
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
  
  public final ac a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(43158);
    this.field_modifytime = System.currentTimeMillis();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = null;
      Iterator localIterator = parama.fXm.iterator();
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
        this.field_selfDisplayName = localObject.fXp;
        this.field_isShowname = (localObject.fXq & 0x1);
      }
      for (int i = localObject.fXq;; i = 0)
      {
        ae.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", new Object[] { this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i) });
        parama.dEu = (i & 0x2 | parama.dEu & 0xFFFFFFFD);
        this.field_chatroomdataflag = parama.dEu;
        try
        {
          this.field_roomdata = parama.toByteArray();
          this.IJG = parama;
          a(parama);
          AppMethodBeat.o(43158);
          return this;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ae.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bu.o(paramString) });
          }
        }
      }
    }
  }
  
  public final List<String> aGE()
  {
    AppMethodBeat.i(43137);
    if ((this.IJH == null) || (this.IJH.size() == 0)) {
      this.IJH = aUj(this.field_memberlist);
    }
    List localList = this.IJH;
    AppMethodBeat.o(43137);
    return localList;
  }
  
  public final b aUf(String paramString)
  {
    AppMethodBeat.i(43141);
    if (this.hUt == null)
    {
      ae.e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
      AppMethodBeat.o(43141);
      return null;
    }
    if (this.hUt.size() <= 0) {
      ftM();
    }
    paramString = (b)this.hUt.get(paramString);
    AppMethodBeat.o(43141);
    return paramString;
  }
  
  public final boolean aUg(String paramString)
  {
    AppMethodBeat.i(43147);
    paramString = aUf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43147);
      return false;
    }
    if ((paramString.fXq & 0x800) != 0)
    {
      AppMethodBeat.o(43147);
      return true;
    }
    AppMethodBeat.o(43147);
    return false;
  }
  
  public final String aUh(String paramString)
  {
    AppMethodBeat.i(43149);
    paramString = aUf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43149);
      return "";
    }
    paramString = bu.bI(paramString.fXr, "");
    AppMethodBeat.o(43149);
    return paramString;
  }
  
  public final void abv(int paramInt)
  {
    AppMethodBeat.i(43143);
    if (b(this.IJG)) {
      ftM();
    }
    this.IJG.dBr = paramInt;
    try
    {
      this.field_roomdata = this.IJG.toByteArray();
      AppMethodBeat.o(43143);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(43143);
    }
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(43140);
    if (this.IJF.computeSize() == parama.computeSize())
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
      ae.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bu.o(parama) });
      AppMethodBeat.o(43156);
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(213438);
    super.convertFrom(paramCursor);
    if ((this.field_roomInfoDetailResByte != null) && (this.field_roomInfoDetailResByte.length > 0)) {
      ae.i("MicroMsg.ChatRoomMember", "handleGetRoomInfoResUnKnownField saveByteVersion:%s handleByteVersion:%s byte:%s", new Object[] { this.field_saveByteVersion, this.field_handleByteVersion, Integer.valueOf(this.field_roomInfoDetailResByte.length) });
    }
    AppMethodBeat.o(213438);
  }
  
  public final a ftL()
  {
    AppMethodBeat.i(43136);
    if (b(this.IJG)) {
      ftM();
    }
    a locala = this.IJG;
    AppMethodBeat.o(43136);
    return locala;
  }
  
  public final void ftM()
  {
    AppMethodBeat.i(43139);
    if (bu.cF(this.field_roomdata))
    {
      AppMethodBeat.o(43139);
      return;
    }
    try
    {
      this.IJG = ((a)new a().parseFrom(this.field_roomdata));
      a(this.IJG);
      AppMethodBeat.o(43139);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.IJG = new a();
      }
    }
  }
  
  public final int ftN()
  {
    AppMethodBeat.i(43142);
    if (b(this.IJG)) {
      ftM();
    }
    int i = this.IJG.dBr;
    AppMethodBeat.o(43142);
    return i;
  }
  
  public final boolean ftO()
  {
    AppMethodBeat.i(43144);
    if (b(this.IJG)) {
      ftM();
    }
    if (this.IJG.dBr < this.IJG.fXo)
    {
      AppMethodBeat.o(43144);
      return true;
    }
    AppMethodBeat.o(43144);
    return false;
  }
  
  public final int ftP()
  {
    AppMethodBeat.i(43146);
    if (b(this.IJG)) {
      ftM();
    }
    int i = this.IJG.type;
    AppMethodBeat.o(43146);
    return i;
  }
  
  public final int ftQ()
  {
    AppMethodBeat.i(43148);
    if (b(this.IJG)) {
      ftM();
    }
    int i = this.IJG.maxCount;
    AppMethodBeat.o(43148);
    return i;
  }
  
  public final boolean ftR()
  {
    return this.field_isShowname > 0;
  }
  
  public final a ftS()
  {
    AppMethodBeat.i(43160);
    if (b(this.IJG)) {
      ftM();
    }
    a locala = this.IJG;
    AppMethodBeat.o(43160);
    return locala;
  }
  
  public final boolean ftT()
  {
    AppMethodBeat.i(213439);
    if (((this.field_chatroomStatus & 0x200000) == 2097152L) && (bu.isNullOrNil(this.field_associateOpenIMRoomName)))
    {
      AppMethodBeat.o(213439);
      return true;
    }
    AppMethodBeat.o(213439);
    return false;
  }
  
  public final boolean ftU()
  {
    return this.field_openIMRoomMigrateStatus == 1;
  }
  
  public final boolean ftV()
  {
    return this.field_openIMRoomMigrateStatus == 2;
  }
  
  public final boolean ftW()
  {
    return (this.field_openIMRoomMigrateStatus == 3) || (this.field_openIMRoomMigrateStatus == 4);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final ac hA(List<String> paramList)
  {
    AppMethodBeat.i(43155);
    this.field_memberlist = fS(paramList);
    AppMethodBeat.o(43155);
    return this;
  }
  
  public final void lP(int paramInt)
  {
    AppMethodBeat.i(43145);
    if (b(this.IJG)) {
      ftM();
    }
    this.field_chatroomdataflag = (this.IJG.dEu & 0xFFFFFFFD | paramInt & 0x2);
    AppMethodBeat.o(43145);
  }
  
  public final ac mc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43157);
    paramString1 = a(paramString1, aUi(paramString2), false);
    AppMethodBeat.o(43157);
    return paramString1;
  }
  
  public final ac wX(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.field_isShowname = i;
      return this;
    }
  }
  
  public final String zP(String paramString)
  {
    AppMethodBeat.i(43150);
    paramString = aUf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43150);
      return "";
    }
    paramString = bu.bI(paramString.fXp, "");
    AppMethodBeat.o(43150);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ac
 * JD-Core Version:    0.7.0.1
 */