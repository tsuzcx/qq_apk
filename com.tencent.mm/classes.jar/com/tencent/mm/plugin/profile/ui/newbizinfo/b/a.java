package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "", "()V", "headerList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "now", "Ljava/util/Calendar;", "nowDay", "", "nowYear", "<set-?>", "size", "getSize", "()I", "getDateString", "", "position", "getHeaderItem", "getHeaderItemType", "getItem", "getItemType", "update", "", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "updateHeader", "notifyInfo", "Companion", "ItemType", "app_release"})
public final class a
{
  public static final a.a Hex;
  private final LinkedList<o<b, dor>> Het;
  private final Calendar Heu;
  private final int Hev;
  private final int Hew;
  private final LinkedList<o<b, oo>> jmy;
  
  static
  {
    AppMethodBeat.i(169910);
    Hex = new a.a((byte)0);
    AppMethodBeat.o(169910);
  }
  
  public a()
  {
    AppMethodBeat.i(39633);
    this.jmy = new LinkedList();
    this.Het = new LinkedList();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    p.j(localCalendar, "Calendar.getInstance().apply { time = Date() }");
    this.Heu = localCalendar;
    this.Hev = this.Heu.get(6);
    this.Hew = this.Heu.get(1);
    AppMethodBeat.o(39633);
  }
  
  private final b abB(int paramInt)
  {
    AppMethodBeat.i(169907);
    b localb = (b)((o)this.Het.get(paramInt)).Mx;
    AppMethodBeat.o(169907);
    return localb;
  }
  
  private final dor abC(int paramInt)
  {
    AppMethodBeat.i(169909);
    dor localdor = (dor)((o)this.Het.get(paramInt)).My;
    AppMethodBeat.o(169909);
    return localdor;
  }
  
  public final void a(dor paramdor)
  {
    AppMethodBeat.i(281124);
    if ((paramdor != null) && (d.cyZ()))
    {
      LinkedList localLinkedList = paramdor.TVR;
      p.j(localLinkedList, "notifyInfo.notify_list");
      if (((Collection)localLinkedList).isEmpty()) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.BizMessageAdapter", "alvinluo updateHeader add video channel");
        this.Het.clear();
        this.Het.add(new o(b.HeF, paramdor));
      }
      AppMethodBeat.o(281124);
      return;
    }
  }
  
  public final b abA(int paramInt)
  {
    AppMethodBeat.i(39631);
    if (paramInt < this.Het.size())
    {
      localb = abB(paramInt);
      AppMethodBeat.o(39631);
      return localb;
    }
    b localb = (b)((o)this.jmy.get(paramInt - this.Het.size())).Mx;
    AppMethodBeat.o(39631);
    return localb;
  }
  
  public final String abz(int paramInt)
  {
    AppMethodBeat.i(281127);
    Object localObject1 = MMApplicationContext.getContext();
    abA(paramInt);
    Object localObject2 = getItem(paramInt);
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
      AppMethodBeat.o(281127);
      throw ((Throwable)localObject1);
    }
    long l = ((oo)localObject2).RWw.SnX * 1000L;
    localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTime(new Date(l));
    p.j(localObject2, "Calendar.getInstance().apply { time = Date(date) }");
    DateFormat.format((CharSequence)((Context)localObject1).getString(R.l.fmt_normal_time), l);
    localObject1 = f.A((Context)localObject1, l).toString();
    AppMethodBeat.o(281127);
    return localObject1;
  }
  
  public final void b(op paramop)
  {
    AppMethodBeat.i(281122);
    p.k(paramop, "msgList");
    this.jmy.clear();
    p.j(Calendar.getInstance(), "Calendar.getInstance()");
    new Date();
    Object localObject = paramop.RWC;
    p.j(localObject, "msgList.Msg");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      oo localoo = (oo)((Iterator)localObject).next();
      this.jmy.add(new o(b.HeC, localoo));
      this.jmy.add(new o(b.HeD, localoo));
    }
    paramop = paramop.RWD;
    if (paramop != null)
    {
      if (paramop.RXo == 0) {
        this.jmy.add(new o(b.HeE, new oo()));
      }
      AppMethodBeat.o(281122);
      return;
    }
    AppMethodBeat.o(281122);
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(169908);
    if (paramInt < this.Het.size())
    {
      localObject = abC(paramInt);
      AppMethodBeat.o(169908);
      return localObject;
    }
    Object localObject = ((o)this.jmy.get(paramInt - this.Het.size())).My;
    AppMethodBeat.o(169908);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(281125);
    int i = this.jmy.size();
    int j = this.Het.size();
    AppMethodBeat.o(281125);
    return i + j;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "", "(Ljava/lang/String;I)V", "SectionToday", "SectionYesterday", "SectionThisWeek", "SectionThisYear", "SectionFullDate", "Message", "Loading", "VideoChannel", "app_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(39628);
      b localb1 = new b("SectionToday", 0);
      Hey = localb1;
      b localb2 = new b("SectionYesterday", 1);
      Hez = localb2;
      b localb3 = new b("SectionThisWeek", 2);
      HeA = localb3;
      b localb4 = new b("SectionThisYear", 3);
      HeB = localb4;
      b localb5 = new b("SectionFullDate", 4);
      HeC = localb5;
      b localb6 = new b("Message", 5);
      HeD = localb6;
      b localb7 = new b("Loading", 6);
      HeE = localb7;
      b localb8 = new b("VideoChannel", 7);
      HeF = localb8;
      HeG = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8 };
      AppMethodBeat.o(39628);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.a
 * JD-Core Version:    0.7.0.1
 */