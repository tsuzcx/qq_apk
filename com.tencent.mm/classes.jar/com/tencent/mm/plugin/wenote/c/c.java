package com.tencent.mm.plugin.wenote.c;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.a.oz.a;
import com.tencent.mm.f.a.px;
import com.tencent.mm.f.a.px.a;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "bundleToJson", "", "bundle", "Landroid/os/Bundle;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "jsonToBundle", "json", "onMultiTaskInit", "", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "openNoteFromTopItem", "topItem", "Lcom/tencent/mm/plugin/wenote/model/datamodel/WNNoteKeepTopItem;", "parseNotifyWNNoteOperationEventData", "Lcom/tencent/mm/autogen/events/NotifyWNNoteOperationEvent$Data;", "parseOpenNoteFromSessionEventData", "Lcom/tencent/mm/autogen/events/OpenNoteFromSessionEvent$Data;", "parseWNNoteKeepTopItem", "supportMultiTaskType", "", "multiTaskType", "", "Companion", "app_release"})
public final class c
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final c.a QII;
  
  static
  {
    AppMethodBeat.i(269835);
    QII = new c.a((byte)0);
    AppMethodBeat.o(269835);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(269832);
    AppMethodBeat.o(269832);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(269833);
    AppMethodBeat.o(269833);
  }
  
  private static px.a bnK(String paramString)
  {
    AppMethodBeat.i(269829);
    try
    {
      paramString = new JSONObject(paramString);
      px.a locala = new px.a();
      locala.msgId = paramString.getLong("msgId");
      locala.fOE = paramString.getString("noteXmlStr");
      locala.fNQ = paramString.getBoolean("showShare");
      locala.scene = paramString.getInt("scene");
      locala.context = MMApplicationContext.getContext();
      AppMethodBeat.o(269829);
      return locala;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
      AppMethodBeat.o(269829);
    }
    return null;
  }
  
  private static oz.a bnL(String paramString)
  {
    AppMethodBeat.i(269827);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new oz.a();
      paramString.type = ((JSONObject)localObject).getInt("type");
      paramString.fNI = ((JSONObject)localObject).getString("editorId");
      paramString.field_localId = ((JSONObject)localObject).getLong("field_localId");
      paramString.fNK = ((JSONObject)localObject).getString("insertJsonData");
      paramString.fNL = ((JSONObject)localObject).getString("exportJsonData");
      paramString.fNM = ((JSONObject)localObject).getBoolean("isInsert");
      String str = ((JSONObject)localObject).getString("bundleData");
      if (p.h(str, "")) {}
      for (paramString.fNN = null;; paramString.fNN = bnM(str))
      {
        paramString.fNO = ((JSONObject)localObject).getInt("itemType");
        paramString.path = ((JSONObject)localObject).getString("path");
        paramString.fNP = ((JSONObject)localObject).getInt("intdata");
        paramString.fNQ = ((JSONObject)localObject).getBoolean("showShare");
        paramString.field_favProto = new aoc();
        str = ((JSONObject)localObject).getString("field_favProto");
        if (!Util.isNullOrNil(str)) {
          paramString.field_favProto.parseFrom(Base64.decode(str, 0));
        }
        paramString.fNR = new aoe();
        localObject = ((JSONObject)localObject).getString("reportInfo");
        if (!Util.isNullOrNil((String)localObject)) {
          paramString.fNR.parseFrom(Base64.decode((String)localObject, 0));
        }
        paramString.context = MMApplicationContext.getContext();
        AppMethodBeat.o(269827);
        return paramString;
        p.j(str, "bd");
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
      AppMethodBeat.o(269827);
    }
  }
  
  private static Bundle bnM(String paramString)
  {
    AppMethodBeat.i(269828);
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        p.j(localIterator, "jsonObject.keys()");
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
        if (localObject == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(269828);
          throw paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "jsonToBundle", new Object[0]);
        AppMethodBeat.o(269828);
        return null;
      }
      Object localObject = (String)localObject;
      localBundle.putString((String)localObject, paramString.getString((String)localObject));
    }
    AppMethodBeat.o(269828);
    return localBundle;
  }
  
  private static q bnN(String paramString)
  {
    AppMethodBeat.i(269830);
    try
    {
      q localq = new q();
      paramString = new JSONObject(paramString);
      localq.QHj = paramString.getBoolean("topIsOpenFromSession");
      localq.QHk = paramString.getLong("topLocalId");
      localq.QHl = paramString.getLong("topMsgId");
      localq.wIg = paramString.getBoolean("isChatRoom");
      localq.QHm = paramString.getString("topTitle");
      localq.QHn = paramString.getString("topNoteXml");
      localq.QHo = paramString.getInt("topLastPosition");
      localq.QHp = paramString.getInt("topLastOffset");
      AppMethodBeat.o(269830);
      return localq;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "parseWNNoteKeepTopItem", new Object[0]);
      AppMethodBeat.o(269830);
    }
    return null;
  }
  
  public final boolean Of(int paramInt)
  {
    return paramInt == 3;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject)
  {
    AppMethodBeat.i(269826);
    p.k(paramMultiTaskInfo, "info");
    p.k(paramdal, "animateData");
    paramObject = new aco();
    paramObject.Soh = paramdal;
    if (paramView != null)
    {
      paramdal = a.JbV;
      paramView = paramView.getContext();
      p.j(paramView, "view.context");
      paramView = a.a.hU(paramView);
      if (paramView != null)
      {
        paramView = (daq)paramView.aef(5);
        if (paramView == null) {
          break label156;
        }
        paramView = paramView.wmL;
        label82:
        paramObject.wmL = paramView;
      }
    }
    else
    {
      paramView = new dcy();
    }
    for (;;)
    {
      try
      {
        paramView.parseFrom(paramMultiTaskInfo.field_data);
        int i = paramView.fKG;
        paramView = paramView.TKK;
        switch (i)
        {
        default: 
          AppMethodBeat.o(269826);
          return;
        }
      }
      catch (Exception paramView)
      {
        label156:
        Log.e("MicroMsg.NoteMultiTaskUIC", paramView.getMessage());
        AppMethodBeat.o(269826);
        return;
      }
      paramView = null;
      break;
      paramView = null;
      break label82;
      paramView = bnL(paramView);
      if (paramView == null)
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "NotifyWNNoteOperationEvent data is null");
        AppMethodBeat.o(269826);
        return;
      }
      paramView.fNN.putByteArray("key_multi_task_common_info", paramObject.toByteArray());
      if (paramView.type == 9)
      {
        paramdal = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramView.field_localId);
        if (paramdal != null)
        {
          paramView.fNI = paramdal.field_xml;
          paramObject = new Bundle();
          anw localanw = paramdal.field_favProto.hpF();
          p.j(localanw, "favItemInfo.field_favProto.getNoteInfo()");
          if (localanw != null)
          {
            paramObject.putString("noteauthor", localanw.SAu);
            paramObject.putString("noteeditor", localanw.SAv);
          }
          paramObject.putLong("edittime", paramdal.field_updateTime);
          paramView.fNN = paramObject;
          paramView.field_favProto = paramdal.field_favProto;
          paramView.type = 2;
        }
      }
      paramdal = new oz();
      paramObject = com.tencent.mm.kernel.h.ag(ag.class);
      p.j(paramObject, "MMKernel.plugin(IPluginFav::class.java)");
      if (((ag)paramObject).getFavItemInfoStorage().Km(paramView.field_localId) != null)
      {
        paramdal.fNG = paramView;
        EventCenter.instance.publish((IEvent)paramdal);
        AppMethodBeat.o(269826);
        return;
      }
      Log.e("MicroMsg.NoteMultiTaskUIC", "favItemInfo id deleted");
      w.makeText(MMApplicationContext.getContext(), R.l.eMR, 0).show();
      ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class)).removeTaskInfoAndCoverImg(paramMultiTaskInfo.field_id);
      AppMethodBeat.o(269826);
      return;
      paramView = bnK(paramView);
      if (paramView == null)
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "OpenNoteFromSessionEvent data is null");
        AppMethodBeat.o(269826);
        return;
      }
      paramView.fNN = new Bundle();
      paramView.fNN.putByteArray("key_multi_task_common_info", paramObject.toByteArray());
      paramMultiTaskInfo = new px();
      paramMultiTaskInfo.fOD = paramView;
      EventCenter.instance.publish((IEvent)paramMultiTaskInfo);
      AppMethodBeat.o(269826);
      return;
      Log.i("MicroMsg.NoteMultiTaskUIC", "click WNNoteBanner");
      paramView = bnN(paramView);
      if (paramView == null)
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "WNNoteKeepTopItem data is null");
        AppMethodBeat.o(269826);
        return;
      }
      paramMultiTaskInfo = new Bundle();
      paramMultiTaskInfo.putByteArray("key_multi_task_common_info", paramObject.toByteArray());
      if (paramView.QHj)
      {
        if (paramView.wIg) {
          com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(3) });
        }
        for (;;)
        {
          Log.i("MicroMsg.NoteMultiTaskUIC", "isOpenFromSession: true");
          paramdal = new j();
          paramdal.QGq = b.b(paramView);
          paramdal.QGr = 3;
          paramObject = com.tencent.mm.plugin.wenote.model.c.hdm();
          p.j(paramObject, "SubCoreWNNoteMsg.getCore()");
          paramObject.a((com.tencent.mm.plugin.wenote.model.d)paramdal);
          paramObject = new aoe();
          paramObject.scene = 8;
          paramdal.a(paramView.QHn, Long.valueOf(paramView.QHl), true, MMApplicationContext.getContext(), paramView.QHo, paramView.QHp, paramObject, paramMultiTaskInfo);
          AppMethodBeat.o(269826);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(2) });
        }
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(1) });
      Log.i("MicroMsg.NoteMultiTaskUIC", "isOpenFromSession: false");
      paramdal = new com.tencent.mm.plugin.wenote.model.g();
      paramdal.QGq = b.b(paramView);
      paramdal.QGr = 3;
      paramObject = com.tencent.mm.plugin.wenote.model.c.hdm();
      p.j(paramObject, "SubCoreWNNoteMsg.getCore()");
      paramObject.a((com.tencent.mm.plugin.wenote.model.d)paramdal);
      paramObject = new aoe();
      paramObject.scene = 8;
      paramMultiTaskInfo = paramMultiTaskInfo.getByteArray("key_multi_task_common_info");
      paramdal.a(paramView.QHk, MMApplicationContext.getContext(), Boolean.TRUE, paramView.QHo, paramView.QHp, paramObject, null, paramMultiTaskInfo);
    }
  }
  
  public final a.b dKp()
  {
    return a.b.FHX;
  }
  
  public final void dp(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.c.c
 * JD-Core Version:    0.7.0.1
 */