package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.as;
import com.tencent.mm.j.a.a.a;
import com.tencent.mm.j.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.tr;
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

public final class w
  extends as
{
  protected static c.a info;
  private a Ffh;
  public a Ffi;
  private List<String> Ffj;
  private Map<String, b> gYH;
  
  static
  {
    AppMethodBeat.i(43163);
    c.a locala = new c.a();
    locala.EYt = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroomname";
    locala.EYv.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "chatroomname";
    locala.columns[1] = "addtime";
    locala.EYv.put("addtime", "LONG");
    localStringBuilder.append(" addtime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "memberlist";
    locala.EYv.put("memberlist", "TEXT");
    localStringBuilder.append(" memberlist TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "displayname";
    locala.EYv.put("displayname", "TEXT");
    localStringBuilder.append(" displayname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "chatroomnick";
    locala.EYv.put("chatroomnick", "TEXT");
    localStringBuilder.append(" chatroomnick TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "roomflag";
    locala.EYv.put("roomflag", "INTEGER");
    localStringBuilder.append(" roomflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "roomowner";
    locala.EYv.put("roomowner", "TEXT");
    localStringBuilder.append(" roomowner TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "roomdata";
    locala.EYv.put("roomdata", "BLOB");
    localStringBuilder.append(" roomdata BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "isShowname";
    locala.EYv.put("isShowname", "INTEGER");
    localStringBuilder.append(" isShowname INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "selfDisplayName";
    locala.EYv.put("selfDisplayName", "TEXT");
    localStringBuilder.append(" selfDisplayName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "style";
    locala.EYv.put("style", "INTEGER");
    localStringBuilder.append(" style INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatroomdataflag";
    locala.EYv.put("chatroomdataflag", "INTEGER");
    localStringBuilder.append(" chatroomdataflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "modifytime";
    locala.EYv.put("modifytime", "LONG");
    localStringBuilder.append(" modifytime LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "chatroomnotice";
    locala.EYv.put("chatroomnotice", "TEXT");
    localStringBuilder.append(" chatroomnotice TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "chatroomVersion";
    locala.EYv.put("chatroomVersion", "INTEGER");
    localStringBuilder.append(" chatroomVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "chatroomnoticeEditor";
    locala.EYv.put("chatroomnoticeEditor", "TEXT");
    localStringBuilder.append(" chatroomnoticeEditor TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomnoticePublishTime";
    locala.EYv.put("chatroomnoticePublishTime", "LONG");
    localStringBuilder.append(" chatroomnoticePublishTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "chatroomLocalVersion";
    locala.EYv.put("chatroomLocalVersion", "LONG");
    localStringBuilder.append(" chatroomLocalVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "chatroomStatus";
    locala.EYv.put("chatroomStatus", "INTEGER default '0' ");
    localStringBuilder.append(" chatroomStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "memberCount";
    locala.EYv.put("memberCount", "INTEGER default '-1' ");
    localStringBuilder.append(" memberCount INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "chatroomfamilystatusmodifytime";
    locala.EYv.put("chatroomfamilystatusmodifytime", "LONG default '0' ");
    localStringBuilder.append(" chatroomfamilystatusmodifytime LONG default '0' ");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(43163);
  }
  
  public w()
  {
    AppMethodBeat.i(43135);
    this.Ffh = new a();
    this.Ffi = this.Ffh;
    this.Ffj = new LinkedList();
    this.gYH = new ConcurrentHashMap();
    AppMethodBeat.o(43135);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(43138);
    if (this.field_roomdata == null) {
      parama = new a();
    }
    parama = parama.fyl.iterator();
    while (parama.hasNext())
    {
      b localb = (b)parama.next();
      if ((localb != null) && (localb.userName != null)) {
        this.gYH.put(localb.userName, localb);
      }
    }
    AppMethodBeat.o(43138);
  }
  
  private static a aHB(String paramString)
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
    Map localMap = bw.K(str1, "RoomData");
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
          str2 = bt.by((String)localMap.get(str2), "");
          if (!bt.isNullOrNil(str2))
          {
            localb.userName = str2;
            localb.fyo = bt.by((String)localMap.get(str1), "");
            localb.fyp = api((String)localMap.get(paramString));
            locala.fyl.add(localb);
            i += 1;
          }
        }
        else
        {
          if (i == 0) {
            break label377;
          }
          str2 = ".RoomData.Member" + i + ".$UserName";
          str1 = ".RoomData.Member" + i + ".DisplayName";
          paramString = ".RoomData.Member" + i + ".Flag";
          continue;
        }
        locala.type = api((String)localMap.get(".RoomData.Type"));
        locala.status = api((String)localMap.get(".RoomData.Status"));
        locala.maxCount = api((String)localMap.get(".RoomData.MaxCount"));
        locala.fym = bt.by((String)localMap.get(".RoomData.ExtInfo.Upgrader"), "");
        AppMethodBeat.o(43152);
        return locala;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(43152);
        return locala;
      }
      label377:
      paramString = null;
      str1 = null;
      String str2 = null;
    }
  }
  
  public static List<String> aHC(String paramString)
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
  
  private static int api(String paramString)
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
  
  private static String fo(List<String> paramList)
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
  
  public final void C(String paramString, List<tr> paramList)
  {
    AppMethodBeat.i(43159);
    if (b(this.Ffi)) {
      eKn();
    }
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (tr)paramList.next();
      if (this.gYH.containsKey(((tr)localObject).mAQ))
      {
        b localb = (b)this.gYH.get(((tr)localObject).mAQ);
        localb.fyo = ((tr)localObject).CVu;
        localb.fyp = ((tr)localObject).CVx;
        localb.fyq = ((tr)localObject).CVy;
      }
    }
    this.Ffi.fyl.clear();
    paramList = this.gYH.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      this.Ffi.fyl.add(this.gYH.get(localObject));
    }
    a(paramString, this.Ffi, false);
    AppMethodBeat.o(43159);
  }
  
  public final boolean Vq()
  {
    AppMethodBeat.i(43161);
    if (bt.isNullOrNil(this.field_roomowner))
    {
      AppMethodBeat.o(43161);
      return false;
    }
    String str = u.aqG();
    if ((c)g.ab(c.class) == null)
    {
      ad.e("MicroMsg.ChatRoomMember", "service is null");
      AppMethodBeat.o(43161);
      return false;
    }
    if ((((c)g.ab(c.class)).RF(this.field_chatroomname)) && (aHz(str))) {}
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
  
  public final void Wu(int paramInt)
  {
    AppMethodBeat.i(43143);
    if (b(this.Ffi)) {
      eKn();
    }
    this.Ffi.dqN = paramInt;
    try
    {
      this.field_roomdata = this.Ffi.toByteArray();
      AppMethodBeat.o(43143);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(43143);
    }
  }
  
  public final w a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(43158);
    this.field_modifytime = System.currentTimeMillis();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = null;
      Iterator localIterator = parama.fyl.iterator();
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
        this.field_selfDisplayName = localObject.fyo;
        this.field_isShowname = (localObject.fyp & 0x1);
      }
      for (int i = localObject.fyp;; i = 0)
      {
        ad.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", new Object[] { this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i) });
        parama.dtM = (i & 0x2 | parama.dtM & 0xFFFFFFFD);
        this.field_chatroomdataflag = parama.dtM;
        try
        {
          this.field_roomdata = parama.toByteArray();
          this.Ffi = parama;
          a(parama);
          AppMethodBeat.o(43158);
          return this;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ad.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bt.m(paramString) });
          }
        }
      }
    }
  }
  
  public final String aHA(String paramString)
  {
    AppMethodBeat.i(43149);
    paramString = aHy(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43149);
      return "";
    }
    paramString = bt.by(paramString.fyq, "");
    AppMethodBeat.o(43149);
    return paramString;
  }
  
  public final b aHy(String paramString)
  {
    AppMethodBeat.i(43141);
    if (this.gYH == null)
    {
      ad.e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
      AppMethodBeat.o(43141);
      return null;
    }
    if (this.gYH.size() <= 0) {
      eKn();
    }
    paramString = (b)this.gYH.get(paramString);
    AppMethodBeat.o(43141);
    return paramString;
  }
  
  public final boolean aHz(String paramString)
  {
    AppMethodBeat.i(43147);
    paramString = aHy(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43147);
      return false;
    }
    if ((paramString.fyp & 0x800) != 0)
    {
      AppMethodBeat.o(43147);
      return true;
    }
    AppMethodBeat.o(43147);
    return false;
  }
  
  public final List<String> awt()
  {
    AppMethodBeat.i(43137);
    if ((this.Ffj == null) || (this.Ffj.size() == 0)) {
      this.Ffj = aHC(this.field_memberlist);
    }
    List localList = this.Ffj;
    AppMethodBeat.o(43137);
    return localList;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(43140);
    if (this.Ffh.computeSize() == parama.computeSize())
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
      ad.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bt.m(parama) });
      AppMethodBeat.o(43156);
    }
  }
  
  public final a eKm()
  {
    AppMethodBeat.i(43136);
    if (b(this.Ffi)) {
      eKn();
    }
    a locala = this.Ffi;
    AppMethodBeat.o(43136);
    return locala;
  }
  
  public final void eKn()
  {
    AppMethodBeat.i(43139);
    if (bt.cw(this.field_roomdata))
    {
      AppMethodBeat.o(43139);
      return;
    }
    try
    {
      this.Ffi = ((a)new a().parseFrom(this.field_roomdata));
      a(this.Ffi);
      AppMethodBeat.o(43139);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Ffi = new a();
      }
    }
  }
  
  public final int eKo()
  {
    AppMethodBeat.i(43142);
    if (b(this.Ffi)) {
      eKn();
    }
    int i = this.Ffi.dqN;
    AppMethodBeat.o(43142);
    return i;
  }
  
  public final boolean eKp()
  {
    AppMethodBeat.i(43144);
    if (b(this.Ffi)) {
      eKn();
    }
    if (this.Ffi.dqN < this.Ffi.fyn)
    {
      AppMethodBeat.o(43144);
      return true;
    }
    AppMethodBeat.o(43144);
    return false;
  }
  
  public final int eKq()
  {
    AppMethodBeat.i(43146);
    if (b(this.Ffi)) {
      eKn();
    }
    int i = this.Ffi.type;
    AppMethodBeat.o(43146);
    return i;
  }
  
  public final int eKr()
  {
    AppMethodBeat.i(43148);
    if (b(this.Ffi)) {
      eKn();
    }
    int i = this.Ffi.maxCount;
    AppMethodBeat.o(43148);
    return i;
  }
  
  public final boolean eKs()
  {
    return this.field_isShowname > 0;
  }
  
  public final a eKt()
  {
    AppMethodBeat.i(43160);
    if (b(this.Ffi)) {
      eKn();
    }
    a locala = this.Ffi;
    AppMethodBeat.o(43160);
    return locala;
  }
  
  public final w gR(List<String> paramList)
  {
    AppMethodBeat.i(43155);
    this.field_memberlist = fo(paramList);
    AppMethodBeat.o(43155);
    return this;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final w la(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43157);
    paramString1 = a(paramString1, aHB(paramString2), false);
    AppMethodBeat.o(43157);
    return paramString1;
  }
  
  public final void lt(int paramInt)
  {
    AppMethodBeat.i(43145);
    if (b(this.Ffi)) {
      eKn();
    }
    this.field_chatroomdataflag = (this.Ffi.dtM & 0xFFFFFFFD | paramInt & 0x2);
    AppMethodBeat.o(43145);
  }
  
  public final String sh(String paramString)
  {
    AppMethodBeat.i(43150);
    paramString = aHy(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(43150);
      return "";
    }
    paramString = bt.by(paramString.fyo, "");
    AppMethodBeat.o(43150);
    return paramString;
  }
  
  public final boolean ty(String paramString)
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
  
  public final w va(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.field_isShowname = i;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.w
 * JD-Core Version:    0.7.0.1
 */