package com.tencent.mm.plugin.wenote.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.a.oz.a;
import com.tencent.mm.f.a.px;
import com.tencent.mm.f.a.px.a;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "app_release"})
public final class a$b
  implements b.a
{
  public final void a(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(230061);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    AppMethodBeat.o(230061);
  }
  
  public final void b(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(230062);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject3 = new dcy();
    for (;;)
    {
      Object localObject1;
      try
      {
        ((dcy)localObject3).parseFrom(paramMultiTaskInfo.field_data);
        localObject1 = new aco();
        ((aco)localObject1).Soi = true;
        int i = ((dcy)localObject3).fKG;
        paramMultiTaskInfo = ((dcy)localObject3).TKK;
        switch (i)
        {
        default: 
          AppMethodBeat.o(230062);
          return;
        }
      }
      catch (Exception paramMultiTaskInfo)
      {
        Log.e("MicroMsg.NoteMultiTaskHelper", paramMultiTaskInfo.getMessage());
        AppMethodBeat.o(230062);
        return;
      }
      localObject3 = a.QIG;
      paramMultiTaskInfo = a.a.bnL(paramMultiTaskInfo);
      if (paramMultiTaskInfo == null)
      {
        Log.e("MicroMsg.NoteMultiTaskHelper", "NotifyWNNoteOperationEvent data is null");
        AppMethodBeat.o(230062);
        return;
      }
      try
      {
        paramMultiTaskInfo.fNN.putByteArray("key_multi_task_common_info", ((aco)localObject1).toByteArray());
        if (paramMultiTaskInfo.type == 9)
        {
          localObject1 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramMultiTaskInfo.field_localId);
          p.j(localObject1, "MMKernel.plugin(IPluginF…calId(data.field_localId)");
          if (localObject1 != null)
          {
            paramMultiTaskInfo.fNI = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml;
            localObject3 = new Bundle();
            localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.hpF();
            p.j(localObject4, "favItemInfo.field_favProto.getNoteInfo()");
            if (localObject4 != null)
            {
              ((Bundle)localObject3).putString("noteauthor", ((anw)localObject4).SAu);
              ((Bundle)localObject3).putString("noteeditor", ((anw)localObject4).SAv);
            }
            ((Bundle)localObject3).putLong("edittime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
            paramMultiTaskInfo.fNN = ((Bundle)localObject3);
            paramMultiTaskInfo.field_favProto = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
            paramMultiTaskInfo.type = 2;
          }
        }
        localObject1 = new oz();
        ((oz)localObject1).fNG = paramMultiTaskInfo;
        EventCenter.instance.publish((IEvent)localObject1);
        AppMethodBeat.o(230062);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WebMultiTaskHelper", (Throwable)localException, "onTaskBarItemClicked", new Object[0]);
        }
      }
      localObject3 = a.QIG;
      paramMultiTaskInfo = a.a.bnK(paramMultiTaskInfo);
      if (paramMultiTaskInfo == null)
      {
        Log.e("MicroMsg.NoteMultiTaskHelper", "OpenNoteFromSessionEvent data is null");
        AppMethodBeat.o(230062);
        return;
      }
      paramMultiTaskInfo.fNN = new Bundle();
      paramMultiTaskInfo.fNN.putByteArray("key_multi_task_common_info", localException.toByteArray());
      Object localObject2 = new px();
      ((px)localObject2).fOD = paramMultiTaskInfo;
      EventCenter.instance.publish((IEvent)localObject2);
      AppMethodBeat.o(230062);
      return;
      Log.i("MicroMsg.NoteMultiTaskHelper", "click WNNoteBanner");
      localObject3 = a.QIG;
      paramMultiTaskInfo = a.a.bnN(paramMultiTaskInfo);
      if (paramMultiTaskInfo == null)
      {
        Log.e("MicroMsg.NoteMultiTaskHelper", "WNNoteKeepTopItem data is null");
        AppMethodBeat.o(230062);
        return;
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putByteArray("key_multi_task_common_info", ((aco)localObject2).toByteArray());
      localObject2 = a.QIG;
      if (paramMultiTaskInfo.QHj)
      {
        if (paramMultiTaskInfo.wIg) {
          com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(3) });
        }
        for (;;)
        {
          Log.i("MicroMsg.NoteMultiTaskHelper", "isOpenFromSession: true");
          localObject2 = new j();
          ((j)localObject2).QGq = b.b(paramMultiTaskInfo);
          ((j)localObject2).QGr = 3;
          localObject4 = c.hdm();
          p.j(localObject4, "SubCoreWNNoteMsg.getCore()");
          ((c)localObject4).a((d)localObject2);
          localObject4 = new aoe();
          ((aoe)localObject4).scene = 8;
          ((j)localObject2).a(paramMultiTaskInfo.QHn, Long.valueOf(paramMultiTaskInfo.QHl), true, MMApplicationContext.getContext(), paramMultiTaskInfo.QHo, paramMultiTaskInfo.QHp, (aoe)localObject4, (Bundle)localObject3);
          AppMethodBeat.o(230062);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(2) });
        }
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(1) });
      Log.i("MicroMsg.NoteMultiTaskHelper", "isOpenFromSession: false");
      localObject2 = new com.tencent.mm.plugin.wenote.model.g();
      ((com.tencent.mm.plugin.wenote.model.g)localObject2).QGq = b.b(paramMultiTaskInfo);
      ((com.tencent.mm.plugin.wenote.model.g)localObject2).QGr = 3;
      Object localObject4 = c.hdm();
      p.j(localObject4, "SubCoreWNNoteMsg.getCore()");
      ((c)localObject4).a((d)localObject2);
      localObject4 = new aoe();
      ((aoe)localObject4).scene = 8;
      localObject3 = ((Bundle)localObject3).getByteArray("key_multi_task_common_info");
      ((com.tencent.mm.plugin.wenote.model.g)localObject2).a(paramMultiTaskInfo.QHk, MMApplicationContext.getContext(), Boolean.TRUE, paramMultiTaskInfo.QHo, paramMultiTaskInfo.QHp, (aoe)localObject4, null, (byte[])localObject3);
    }
  }
  
  public final void c(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(230068);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    AppMethodBeat.o(230068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.c.a.b
 * JD-Core Version:    0.7.0.1
 */