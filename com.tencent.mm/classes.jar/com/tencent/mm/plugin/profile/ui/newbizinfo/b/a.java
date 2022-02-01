package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.nc;
import d.g.b.k;
import d.l;
import d.o;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "", "()V", "headerList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "now", "Ljava/util/Calendar;", "nowDay", "", "nowYear", "<set-?>", "size", "getSize", "()I", "getDateString", "", "position", "getHeaderItem", "getHeaderItemType", "getItem", "getItemType", "update", "", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "updateHeader", "notifyInfo", "Companion", "ItemType", "app_release"})
public final class a
{
  public static final a.a vPa;
  public final LinkedList<o<b, nc>> fBS;
  public final LinkedList<o<b, chl>> vOW;
  private final Calendar vOX;
  private final int vOY;
  private final int vOZ;
  
  static
  {
    AppMethodBeat.i(169910);
    vPa = new a.a((byte)0);
    AppMethodBeat.o(169910);
  }
  
  public a()
  {
    AppMethodBeat.i(39633);
    this.fBS = new LinkedList();
    this.vOW = new LinkedList();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    k.g(localCalendar, "Calendar.getInstance().apply { time = Date() }");
    this.vOX = localCalendar;
    this.vOY = this.vOX.get(6);
    this.vOZ = this.vOX.get(1);
    AppMethodBeat.o(39633);
  }
  
  private final b Ly(int paramInt)
  {
    AppMethodBeat.i(169907);
    b localb = (b)((o)this.vOW.get(paramInt)).first;
    AppMethodBeat.o(169907);
    return localb;
  }
  
  private final chl Lz(int paramInt)
  {
    AppMethodBeat.i(169909);
    chl localchl = (chl)((o)this.vOW.get(paramInt)).second;
    AppMethodBeat.o(169909);
    return localchl;
  }
  
  public final b Lx(int paramInt)
  {
    AppMethodBeat.i(39631);
    if (paramInt < this.vOW.size())
    {
      localb = Ly(paramInt);
      AppMethodBeat.o(39631);
      return localb;
    }
    b localb = (b)((o)this.fBS.get(paramInt - this.vOW.size())).first;
    AppMethodBeat.o(39631);
    return localb;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(169908);
    if (paramInt < this.vOW.size())
    {
      localObject = Lz(paramInt);
      AppMethodBeat.o(169908);
      return localObject;
    }
    Object localObject = ((o)this.fBS.get(paramInt - this.vOW.size())).second;
    AppMethodBeat.o(169908);
    return localObject;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "", "(Ljava/lang/String;I)V", "SectionToday", "SectionYesterday", "SectionThisWeek", "SectionThisYear", "SectionFullDate", "Message", "Loading", "VideoChannel", "app_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(39628);
      b localb1 = new b("SectionToday", 0);
      vPb = localb1;
      b localb2 = new b("SectionYesterday", 1);
      vPc = localb2;
      b localb3 = new b("SectionThisWeek", 2);
      vPd = localb3;
      b localb4 = new b("SectionThisYear", 3);
      vPe = localb4;
      b localb5 = new b("SectionFullDate", 4);
      vPf = localb5;
      b localb6 = new b("Message", 5);
      vPg = localb6;
      b localb7 = new b("Loading", 6);
      vPh = localb7;
      b localb8 = new b("VideoChannel", 7);
      vPi = localb8;
      vPj = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8 };
      AppMethodBeat.o(39628);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.a
 * JD-Core Version:    0.7.0.1
 */