package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.oa;
import d.g.b.p;
import d.l;
import d.o;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "", "()V", "headerList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "now", "Ljava/util/Calendar;", "nowDay", "", "nowYear", "<set-?>", "size", "getSize", "()I", "getDateString", "", "position", "getHeaderItem", "getHeaderItemType", "getItem", "getItemType", "update", "", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "updateHeader", "notifyInfo", "Companion", "ItemType", "app_release"})
public final class a
{
  public static final a.a xmc;
  public final LinkedList<o<b, oa>> fXm;
  public final LinkedList<o<b, cne>> xlY;
  private final Calendar xlZ;
  private final int xma;
  private final int xmb;
  
  static
  {
    AppMethodBeat.i(169910);
    xmc = new a.a((byte)0);
    AppMethodBeat.o(169910);
  }
  
  public a()
  {
    AppMethodBeat.i(39633);
    this.fXm = new LinkedList();
    this.xlY = new LinkedList();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    p.g(localCalendar, "Calendar.getInstance().apply { time = Date() }");
    this.xlZ = localCalendar;
    this.xma = this.xlZ.get(6);
    this.xmb = this.xlZ.get(1);
    AppMethodBeat.o(39633);
  }
  
  private final b NG(int paramInt)
  {
    AppMethodBeat.i(169907);
    b localb = (b)((o)this.xlY.get(paramInt)).first;
    AppMethodBeat.o(169907);
    return localb;
  }
  
  private final cne NH(int paramInt)
  {
    AppMethodBeat.i(169909);
    cne localcne = (cne)((o)this.xlY.get(paramInt)).second;
    AppMethodBeat.o(169909);
    return localcne;
  }
  
  public final b NF(int paramInt)
  {
    AppMethodBeat.i(39631);
    if (paramInt < this.xlY.size())
    {
      localb = NG(paramInt);
      AppMethodBeat.o(39631);
      return localb;
    }
    b localb = (b)((o)this.fXm.get(paramInt - this.xlY.size())).first;
    AppMethodBeat.o(39631);
    return localb;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(169908);
    if (paramInt < this.xlY.size())
    {
      localObject = NH(paramInt);
      AppMethodBeat.o(169908);
      return localObject;
    }
    Object localObject = ((o)this.fXm.get(paramInt - this.xlY.size())).second;
    AppMethodBeat.o(169908);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "", "(Ljava/lang/String;I)V", "SectionToday", "SectionYesterday", "SectionThisWeek", "SectionThisYear", "SectionFullDate", "Message", "Loading", "VideoChannel", "app_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(39628);
      b localb1 = new b("SectionToday", 0);
      xmd = localb1;
      b localb2 = new b("SectionYesterday", 1);
      xme = localb2;
      b localb3 = new b("SectionThisWeek", 2);
      xmf = localb3;
      b localb4 = new b("SectionThisYear", 3);
      xmg = localb4;
      b localb5 = new b("SectionFullDate", 4);
      xmh = localb5;
      b localb6 = new b("Message", 5);
      xmi = localb6;
      b localb7 = new b("Loading", 6);
      xmj = localb7;
      b localb8 = new b("VideoChannel", 7);
      xmk = localb8;
      xml = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8 };
      AppMethodBeat.o(39628);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.a
 * JD-Core Version:    0.7.0.1
 */