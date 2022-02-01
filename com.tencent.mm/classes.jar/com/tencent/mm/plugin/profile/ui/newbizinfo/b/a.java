package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.mv;
import d.g.b.k;
import d.l;
import d.o;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "", "()V", "headerList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "now", "Ljava/util/Calendar;", "nowDay", "", "nowYear", "<set-?>", "size", "getSize", "()I", "getDateString", "", "position", "getHeaderItem", "getHeaderItemType", "getItem", "getItemType", "update", "", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "updateHeader", "notifyInfo", "Companion", "ItemType", "app_release"})
public final class a
{
  public static final a uGj;
  public final LinkedList<o<b, mv>> fyl;
  public final LinkedList<o<b, ccj>> uGf;
  private final Calendar uGg;
  private final int uGh;
  private final int uGi;
  
  static
  {
    AppMethodBeat.i(169910);
    uGj = new a((byte)0);
    AppMethodBeat.o(169910);
  }
  
  public a()
  {
    AppMethodBeat.i(39633);
    this.fyl = new LinkedList();
    this.uGf = new LinkedList();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    k.g(localCalendar, "Calendar.getInstance().apply { time = Date() }");
    this.uGg = localCalendar;
    this.uGh = this.uGg.get(6);
    this.uGi = this.uGg.get(1);
    AppMethodBeat.o(39633);
  }
  
  private final ccj JA(int paramInt)
  {
    AppMethodBeat.i(169909);
    ccj localccj = (ccj)((o)this.uGf.get(paramInt)).second;
    AppMethodBeat.o(169909);
    return localccj;
  }
  
  private final b Jz(int paramInt)
  {
    AppMethodBeat.i(169907);
    b localb = (b)((o)this.uGf.get(paramInt)).first;
    AppMethodBeat.o(169907);
    return localb;
  }
  
  public final b Jy(int paramInt)
  {
    AppMethodBeat.i(39631);
    if (paramInt < this.uGf.size())
    {
      localb = Jz(paramInt);
      AppMethodBeat.o(39631);
      return localb;
    }
    b localb = (b)((o)this.fyl.get(paramInt - this.uGf.size())).first;
    AppMethodBeat.o(39631);
    return localb;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(169908);
    if (paramInt < this.uGf.size())
    {
      localObject = JA(paramInt);
      AppMethodBeat.o(169908);
      return localObject;
    }
    Object localObject = ((o)this.fyl.get(paramInt - this.uGf.size())).second;
    AppMethodBeat.o(169908);
    return localObject;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "", "(Ljava/lang/String;I)V", "SectionToday", "SectionYesterday", "SectionThisWeek", "SectionThisYear", "SectionFullDate", "Message", "Loading", "VideoChannel", "app_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(39628);
      b localb1 = new b("SectionToday", 0);
      uGk = localb1;
      b localb2 = new b("SectionYesterday", 1);
      uGl = localb2;
      b localb3 = new b("SectionThisWeek", 2);
      uGm = localb3;
      b localb4 = new b("SectionThisYear", 3);
      uGn = localb4;
      b localb5 = new b("SectionFullDate", 4);
      uGo = localb5;
      b localb6 = new b("Message", 5);
      uGp = localb6;
      b localb7 = new b("Loading", 6);
      uGq = localb7;
      b localb8 = new b("VideoChannel", 7);
      uGr = localb8;
      uGs = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8 };
      AppMethodBeat.o(39628);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.a
 * JD-Core Version:    0.7.0.1
 */