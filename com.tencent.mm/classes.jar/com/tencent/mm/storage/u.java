package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.an;
import com.tencent.mm.j.a.a.a;
import com.tencent.mm.j.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class u
  extends an
{
  protected static c.a info;
  private Map<String, b> fxs;
  private a ywX;
  public a ywY;
  private List<String> ywZ;
  
  static
  {
    AppMethodBeat.i(60102);
    c.a locala = new c.a();
    locala.yrK = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroomname";
    locala.yrM.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "chatroomname";
    locala.columns[1] = "addtime";
    locala.yrM.put("addtime", "LONG");
    localStringBuilder.append(" addtime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "memberlist";
    locala.yrM.put("memberlist", "TEXT");
    localStringBuilder.append(" memberlist TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "displayname";
    locala.yrM.put("displayname", "TEXT");
    localStringBuilder.append(" displayname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "chatroomnick";
    locala.yrM.put("chatroomnick", "TEXT");
    localStringBuilder.append(" chatroomnick TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "roomflag";
    locala.yrM.put("roomflag", "INTEGER");
    localStringBuilder.append(" roomflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "roomowner";
    locala.yrM.put("roomowner", "TEXT");
    localStringBuilder.append(" roomowner TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "roomdata";
    locala.yrM.put("roomdata", "BLOB");
    localStringBuilder.append(" roomdata BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "isShowname";
    locala.yrM.put("isShowname", "INTEGER");
    localStringBuilder.append(" isShowname INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "selfDisplayName";
    locala.yrM.put("selfDisplayName", "TEXT");
    localStringBuilder.append(" selfDisplayName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "style";
    locala.yrM.put("style", "INTEGER");
    localStringBuilder.append(" style INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatroomdataflag";
    locala.yrM.put("chatroomdataflag", "INTEGER");
    localStringBuilder.append(" chatroomdataflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "modifytime";
    locala.yrM.put("modifytime", "LONG");
    localStringBuilder.append(" modifytime LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "chatroomnotice";
    locala.yrM.put("chatroomnotice", "TEXT");
    localStringBuilder.append(" chatroomnotice TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "chatroomVersion";
    locala.yrM.put("chatroomVersion", "INTEGER");
    localStringBuilder.append(" chatroomVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "chatroomnoticeEditor";
    locala.yrM.put("chatroomnoticeEditor", "TEXT");
    localStringBuilder.append(" chatroomnoticeEditor TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomnoticePublishTime";
    locala.yrM.put("chatroomnoticePublishTime", "LONG");
    localStringBuilder.append(" chatroomnoticePublishTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "chatroomLocalVersion";
    locala.yrM.put("chatroomLocalVersion", "LONG");
    localStringBuilder.append(" chatroomLocalVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "chatroomStatus";
    locala.yrM.put("chatroomStatus", "INTEGER default '0' ");
    localStringBuilder.append(" chatroomStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "memberCount";
    locala.yrM.put("memberCount", "INTEGER default '-1' ");
    localStringBuilder.append(" memberCount INTEGER default '-1' ");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(60102);
  }
  
  public u()
  {
    AppMethodBeat.i(60074);
    this.ywX = new a();
    this.ywY = this.ywX;
    this.ywZ = new LinkedList();
    this.fxs = new ConcurrentHashMap();
    AppMethodBeat.o(60074);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(60077);
    if (this.field_roomdata == null) {
      parama = new a();
    }
    parama = parama.elu.iterator();
    while (parama.hasNext())
    {
      b localb = (b)parama.next();
      if ((localb != null) && (localb.userName != null)) {
        this.fxs.put(localb.userName, localb);
      }
    }
    AppMethodBeat.o(60077);
  }
  
  private static int abb(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(60090);
    try
    {
      i = bo.getInt(paramString, 0);
      AppMethodBeat.o(60090);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (paramString != null)
        {
          ab.e("MicroMsg.ChatRoomMember", "parserInt error ".concat(String.valueOf(paramString)));
          i = j;
        }
      }
    }
  }
  
  private static a aqY(String paramString)
  {
    AppMethodBeat.i(60091);
    a locala = new a();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(60091);
      return locala;
    }
    int i = paramString.indexOf('<');
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(i);
    }
    Map localMap = br.F(str1, "RoomData");
    if (localMap == null)
    {
      ab.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
      AppMethodBeat.o(60091);
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
          str2 = bo.bf((String)localMap.get(str2), "");
          if (!bo.isNullOrNil(str2))
          {
            localb.userName = str2;
            localb.elx = bo.bf((String)localMap.get(str1), "");
            localb.ely = abb((String)localMap.get(paramString));
            locala.elu.add(localb);
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
        locala.type = abb((String)localMap.get(".RoomData.Type"));
        locala.status = abb((String)localMap.get(".RoomData.Status"));
        locala.eeH = abb((String)localMap.get(".RoomData.MaxCount"));
        locala.elv = bo.bf((String)localMap.get(".RoomData.ExtInfo.Upgrader"), "");
        AppMethodBeat.o(60091);
        return locala;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(60091);
        return locala;
      }
      label377:
      paramString = null;
      str1 = null;
      String str2 = null;
    }
  }
  
  public static List<String> aqZ(String paramString)
  {
    AppMethodBeat.i(60093);
    LinkedList localLinkedList = new LinkedList();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(60093);
      return localLinkedList;
    }
    paramString = paramString.split(";");
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    AppMethodBeat.o(60093);
    return localLinkedList;
  }
  
  private static String da(List<String> paramList)
  {
    AppMethodBeat.i(60092);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(60092);
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
    AppMethodBeat.o(60092);
    return localObject;
  }
  
  public final boolean JP()
  {
    AppMethodBeat.i(60100);
    if (bo.isNullOrNil(this.field_roomowner))
    {
      AppMethodBeat.o(60100);
      return false;
    }
    String str = r.Zn();
    if ((((c)g.E(c.class)).IV(this.field_chatroomname)) && (aqW(str))) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = this.field_roomowner.equals(str);
      if ((i == 0) && (!bool)) {
        break;
      }
      AppMethodBeat.o(60100);
      return true;
    }
    AppMethodBeat.o(60100);
    return false;
  }
  
  public final void Nq(int paramInt)
  {
    AppMethodBeat.i(60082);
    if (b(this.ywY)) {
      dwn();
    }
    this.ywY.cAE = paramInt;
    try
    {
      this.field_roomdata = this.ywY.toByteArray();
      AppMethodBeat.o(60082);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(60082);
    }
  }
  
  public final u a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(60097);
    this.field_modifytime = System.currentTimeMillis();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = null;
      Iterator localIterator = parama.elu.iterator();
      if (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb.userName == null) || (!localb.userName.equals(paramString))) {
          break label226;
        }
        localObject = localb;
      }
    }
    label226:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        this.field_selfDisplayName = localObject.elx;
        this.field_isShowname = (localObject.ely & 0x1);
      }
      for (int i = localObject.ely;; i = 0)
      {
        ab.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", new Object[] { this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i) });
        parama.bsY = (i & 0x2 | parama.bsY & 0xFFFFFFFD);
        this.field_chatroomdataflag = parama.bsY;
        try
        {
          this.field_roomdata = parama.toByteArray();
          this.ywY = parama;
          a(parama);
          AppMethodBeat.o(60097);
          return this;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ab.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bo.l(paramString) });
          }
        }
      }
    }
  }
  
  public final List<String> afx()
  {
    AppMethodBeat.i(60076);
    if ((this.ywZ == null) || (this.ywZ.size() == 0)) {
      this.ywZ = aqZ(this.field_memberlist);
    }
    List localList = this.ywZ;
    AppMethodBeat.o(60076);
    return localList;
  }
  
  public final b aqV(String paramString)
  {
    AppMethodBeat.i(60080);
    if (this.fxs == null)
    {
      ab.e("MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!");
      AppMethodBeat.o(60080);
      return null;
    }
    if (this.fxs.size() <= 0) {
      dwn();
    }
    paramString = (b)this.fxs.get(paramString);
    AppMethodBeat.o(60080);
    return paramString;
  }
  
  public final boolean aqW(String paramString)
  {
    AppMethodBeat.i(60086);
    paramString = aqV(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(60086);
      return false;
    }
    if ((paramString.ely & 0x800) != 0)
    {
      AppMethodBeat.o(60086);
      return true;
    }
    AppMethodBeat.o(60086);
    return false;
  }
  
  public final String aqX(String paramString)
  {
    AppMethodBeat.i(60088);
    paramString = aqV(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(60088);
      return "";
    }
    paramString = bo.bf(paramString.elz, "");
    AppMethodBeat.o(60088);
    return paramString;
  }
  
  public final boolean ara(String paramString)
  {
    AppMethodBeat.i(60101);
    if ((!bo.isNullOrNil(this.field_roomowner)) && (this.field_roomowner.equals(paramString)))
    {
      AppMethodBeat.o(60101);
      return true;
    }
    AppMethodBeat.o(60101);
    return false;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(60079);
    if (this.ywX.computeSize() == parama.computeSize())
    {
      AppMethodBeat.o(60079);
      return true;
    }
    AppMethodBeat.o(60079);
    return false;
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(60095);
    try
    {
      this.field_roomdata = parama.toByteArray();
      AppMethodBeat.o(60095);
      return;
    }
    catch (Exception parama)
    {
      ab.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bo.l(parama) });
      AppMethodBeat.o(60095);
    }
  }
  
  public final a dwm()
  {
    AppMethodBeat.i(60075);
    if (b(this.ywY)) {
      dwn();
    }
    a locala = this.ywY;
    AppMethodBeat.o(60075);
    return locala;
  }
  
  public final void dwn()
  {
    AppMethodBeat.i(60078);
    if (bo.ce(this.field_roomdata))
    {
      AppMethodBeat.o(60078);
      return;
    }
    try
    {
      this.ywY = ((a)new a().parseFrom(this.field_roomdata));
      a(this.ywY);
      AppMethodBeat.o(60078);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.ywY = new a();
      }
    }
  }
  
  public final int dwo()
  {
    AppMethodBeat.i(60081);
    if (b(this.ywY)) {
      dwn();
    }
    int i = this.ywY.cAE;
    AppMethodBeat.o(60081);
    return i;
  }
  
  public final boolean dwp()
  {
    AppMethodBeat.i(60083);
    if (b(this.ywY)) {
      dwn();
    }
    if (this.ywY.cAE < this.ywY.elw)
    {
      AppMethodBeat.o(60083);
      return true;
    }
    AppMethodBeat.o(60083);
    return false;
  }
  
  public final int dwq()
  {
    AppMethodBeat.i(60085);
    if (b(this.ywY)) {
      dwn();
    }
    int i = this.ywY.type;
    AppMethodBeat.o(60085);
    return i;
  }
  
  public final int dwr()
  {
    AppMethodBeat.i(60087);
    if (b(this.ywY)) {
      dwn();
    }
    int i = this.ywY.eeH;
    AppMethodBeat.o(60087);
    return i;
  }
  
  public final boolean dws()
  {
    return this.field_isShowname > 0;
  }
  
  public final a dwt()
  {
    AppMethodBeat.i(60099);
    if (b(this.ywY)) {
      dwn();
    }
    a locala = this.ywY;
    AppMethodBeat.o(60099);
    return locala;
  }
  
  public final u ex(List<String> paramList)
  {
    AppMethodBeat.i(60094);
    this.field_memberlist = da(paramList);
    AppMethodBeat.o(60094);
    return this;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final u io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(60096);
    paramString1 = a(paramString1, aqY(paramString2), false);
    AppMethodBeat.o(60096);
    return paramString1;
  }
  
  public final void jf(int paramInt)
  {
    AppMethodBeat.i(60084);
    if (b(this.ywY)) {
      dwn();
    }
    this.field_chatroomdataflag = (this.ywY.bsY & 0xFFFFFFFD | paramInt & 0x2);
    AppMethodBeat.o(60084);
  }
  
  public final String nE(String paramString)
  {
    AppMethodBeat.i(60089);
    paramString = aqV(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(60089);
      return "";
    }
    paramString = bo.bf(paramString.elx, "");
    AppMethodBeat.o(60089);
    return paramString;
  }
  
  public final u pS(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.field_isShowname = i;
      return this;
    }
  }
  
  public final void w(String paramString, List<rd> paramList)
  {
    AppMethodBeat.i(60098);
    if (b(this.ywY)) {
      dwn();
    }
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (rd)paramList.next();
      if (this.fxs.containsKey(((rd)localObject).jJA))
      {
        b localb = (b)this.fxs.get(((rd)localObject).jJA);
        localb.elx = ((rd)localObject).wJp;
        localb.ely = ((rd)localObject).wJs;
        localb.elz = ((rd)localObject).wJt;
      }
    }
    this.ywY.elu.clear();
    paramList = this.fxs.keySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      this.ywY.elu.add(this.fxs.get(localObject));
    }
    a(paramString, this.ywY, false);
    AppMethodBeat.o(60098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.u
 * JD-Core Version:    0.7.0.1
 */