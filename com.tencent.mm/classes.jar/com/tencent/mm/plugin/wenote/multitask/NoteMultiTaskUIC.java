package com.tencent.mm.plugin.wenote.multitask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.oc.a;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.pa.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.wenote.b.a;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "bundleToJson", "", "bundle", "Landroid/os/Bundle;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "jsonToBundle", "json", "onMultiTaskInit", "", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "openNoteFromTopItem", "topItem", "Lcom/tencent/mm/plugin/wenote/model/datamodel/WNNoteKeepTopItem;", "parseNotifyWNNoteOperationEventData", "Lcom/tencent/mm/autogen/events/NotifyWNNoteOperationEvent$Data;", "parseOpenNoteFromSessionEventData", "Lcom/tencent/mm/autogen/events/OpenNoteFromSessionEvent$Data;", "parseWNNoteKeepTopItem", "supportMultiTaskType", "", "multiTaskType", "", "Companion", "app_release"})
public final class NoteMultiTaskUIC
  extends MultiTaskUIComponent
{
  public static final NoteMultiTaskUIC.a JJq;
  
  static
  {
    AppMethodBeat.i(230931);
    JJq = new NoteMultiTaskUIC.a((byte)0);
    AppMethodBeat.o(230931);
  }
  
  public NoteMultiTaskUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(230930);
    AppMethodBeat.o(230930);
  }
  
  public NoteMultiTaskUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(230929);
    AppMethodBeat.o(230929);
  }
  
  private static pa.a bbK(String paramString)
  {
    AppMethodBeat.i(230927);
    try
    {
      paramString = new JSONObject(paramString);
      pa.a locala = new pa.a();
      locala.msgId = paramString.getLong("msgId");
      locala.dVc = paramString.getString("noteXmlStr");
      locala.dUo = paramString.getBoolean("showShare");
      locala.scene = paramString.getInt("scene");
      locala.context = MMApplicationContext.getContext();
      AppMethodBeat.o(230927);
      return locala;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
      AppMethodBeat.o(230927);
    }
    return null;
  }
  
  private static oc.a bbL(String paramString)
  {
    AppMethodBeat.i(230925);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new oc.a();
      paramString.type = ((JSONObject)localObject).getInt("type");
      paramString.dUg = ((JSONObject)localObject).getString("editorId");
      paramString.field_localId = ((JSONObject)localObject).getLong("field_localId");
      paramString.dUi = ((JSONObject)localObject).getString("insertJsonData");
      paramString.dUj = ((JSONObject)localObject).getString("exportJsonData");
      paramString.dUk = ((JSONObject)localObject).getBoolean("isInsert");
      String str = ((JSONObject)localObject).getString("bundleData");
      if (p.j(str, "")) {}
      for (paramString.dUl = null;; paramString.dUl = bbM(str))
      {
        paramString.dUm = ((JSONObject)localObject).getInt("itemType");
        paramString.path = ((JSONObject)localObject).getString("path");
        paramString.dUn = ((JSONObject)localObject).getInt("intdata");
        paramString.dUo = ((JSONObject)localObject).getBoolean("showShare");
        paramString.field_favProto = new anb();
        str = ((JSONObject)localObject).getString("field_favProto");
        if (!Util.isNullOrNil(str)) {
          paramString.field_favProto.parseFrom(Base64.decode(str, 0));
        }
        paramString.dUp = new and();
        localObject = ((JSONObject)localObject).getString("reportInfo");
        if (!Util.isNullOrNil((String)localObject)) {
          paramString.dUp.parseFrom(Base64.decode((String)localObject, 0));
        }
        paramString.context = MMApplicationContext.getContext();
        AppMethodBeat.o(230925);
        return paramString;
        p.g(str, "bd");
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
      AppMethodBeat.o(230925);
    }
  }
  
  private static Bundle bbM(String paramString)
  {
    AppMethodBeat.i(230926);
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        p.g(localIterator, "jsonObject.keys()");
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
        if (localObject == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(230926);
          throw paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "jsonToBundle", new Object[0]);
        AppMethodBeat.o(230926);
        return null;
      }
      Object localObject = (String)localObject;
      localBundle.putString((String)localObject, paramString.getString((String)localObject));
    }
    AppMethodBeat.o(230926);
    return localBundle;
  }
  
  private static q bbN(String paramString)
  {
    AppMethodBeat.i(230928);
    try
    {
      q localq = new q();
      paramString = new JSONObject(paramString);
      localq.JHR = paramString.getBoolean("topIsOpenFromSession");
      localq.JHS = paramString.getLong("topLocalId");
      localq.JHT = paramString.getLong("topMsgId");
      localq.tcb = paramString.getBoolean("isChatRoom");
      localq.JHU = paramString.getString("topTitle");
      localq.JHV = paramString.getString("topNoteXml");
      localq.JHW = paramString.getInt("topLastPosition");
      localq.JHX = paramString.getInt("topLastOffset");
      AppMethodBeat.o(230928);
      return localq;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "parseWNNoteKeepTopItem", new Object[0]);
      AppMethodBeat.o(230928);
    }
    return null;
  }
  
  public final boolean Js(int paramInt)
  {
    return paramInt == 3;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject)
  {
    AppMethodBeat.i(230924);
    p.h(paramMultiTaskInfo, "info");
    p.h(paramcrq, "animateData");
    paramObject = new ach();
    paramObject.LmQ = paramcrq;
    if (paramView != null)
    {
      paramcrq = SecDataUIC.CWq;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      paramView = SecDataUIC.a.gU(paramView);
      if (paramView != null)
      {
        paramView = (crt)paramView.Xh(5);
        if (paramView == null) {
          break label156;
        }
        paramView = paramView.sGQ;
        label82:
        paramObject.sGQ = paramView;
      }
    }
    else
    {
      paramView = new ctx();
    }
    for (;;)
    {
      try
      {
        paramView.parseFrom(paramMultiTaskInfo.field_data);
        int i = paramView.dRq;
        paramView = paramView.Mzh;
        switch (i)
        {
        default: 
          AppMethodBeat.o(230924);
          return;
        }
      }
      catch (Exception paramView)
      {
        label156:
        Log.e("MicroMsg.NoteMultiTaskUIC", paramView.getMessage());
        AppMethodBeat.o(230924);
        return;
      }
      paramView = null;
      break;
      paramView = null;
      break label82;
      paramView = bbL(paramView);
      if (paramView == null)
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "NotifyWNNoteOperationEvent data is null");
        AppMethodBeat.o(230924);
        return;
      }
      paramView.dUl.putByteArray("key_multi_task_common_info", paramObject.toByteArray());
      if (paramView.type == 9)
      {
        paramcrq = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramView.field_localId);
        if (paramcrq != null)
        {
          paramView.dUg = paramcrq.field_xml;
          paramObject = new Bundle();
          amv localamv = paramcrq.field_favProto.guj();
          p.g(localamv, "favItemInfo.field_favProto.getNoteInfo()");
          if (localamv != null)
          {
            paramObject.putString("noteauthor", localamv.LxT);
            paramObject.putString("noteeditor", localamv.LxU);
          }
          paramObject.putLong("edittime", paramcrq.field_updateTime);
          paramView.dUl = paramObject;
          paramView.field_favProto = paramcrq.field_favProto;
          paramView.type = 2;
        }
      }
      paramcrq = new oc();
      paramObject = com.tencent.mm.kernel.g.ah(af.class);
      p.g(paramObject, "MMKernel.plugin(IPluginFav::class.java)");
      if (((af)paramObject).getFavItemInfoStorage().DY(paramView.field_localId) != null)
      {
        paramcrq.dUe = paramView;
        EventCenter.instance.publish((IEvent)paramcrq);
        AppMethodBeat.o(230924);
        return;
      }
      Log.e("MicroMsg.NoteMultiTaskUIC", "favItemInfo id deleted");
      u.makeText(MMApplicationContext.getContext(), 2131763611, 0).show();
      ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).removeTaskInfoAndCoverImg(paramMultiTaskInfo.field_id);
      AppMethodBeat.o(230924);
      return;
      paramView = bbK(paramView);
      if (paramView == null)
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "OpenNoteFromSessionEvent data is null");
        AppMethodBeat.o(230924);
        return;
      }
      paramView.dUl = new Bundle();
      paramView.dUl.putByteArray("key_multi_task_common_info", paramObject.toByteArray());
      paramMultiTaskInfo = new pa();
      paramMultiTaskInfo.dVb = paramView;
      EventCenter.instance.publish((IEvent)paramMultiTaskInfo);
      AppMethodBeat.o(230924);
      return;
      Log.i("MicroMsg.NoteMultiTaskUIC", "click WNNoteBanner");
      paramView = bbN(paramView);
      if (paramView == null)
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "WNNoteKeepTopItem data is null");
        AppMethodBeat.o(230924);
        return;
      }
      paramMultiTaskInfo = new Bundle();
      paramMultiTaskInfo.putByteArray("key_multi_task_common_info", paramObject.toByteArray());
      if (paramView.JHR)
      {
        if (paramView.tcb) {
          h.CyF.a(14789, new Object[] { Integer.valueOf(3) });
        }
        for (;;)
        {
          Log.i("MicroMsg.NoteMultiTaskUIC", "isOpenFromSession: true");
          paramcrq = new j();
          paramcrq.JGY = a.b(paramView);
          paramcrq.JGZ = 3;
          paramObject = c.gjz();
          p.g(paramObject, "SubCoreWNNoteMsg.getCore()");
          paramObject.a((com.tencent.mm.plugin.wenote.model.d)paramcrq);
          paramObject = new and();
          paramObject.scene = 8;
          paramcrq.a(paramView.JHV, Long.valueOf(paramView.JHT), true, MMApplicationContext.getContext(), paramView.JHW, paramView.JHX, paramObject, paramMultiTaskInfo);
          AppMethodBeat.o(230924);
          return;
          h.CyF.a(14789, new Object[] { Integer.valueOf(2) });
        }
      }
      h.CyF.a(14789, new Object[] { Integer.valueOf(1) });
      Log.i("MicroMsg.NoteMultiTaskUIC", "isOpenFromSession: false");
      paramcrq = new com.tencent.mm.plugin.wenote.model.g();
      paramcrq.JGY = a.b(paramView);
      paramcrq.JGZ = 3;
      paramObject = c.gjz();
      p.g(paramObject, "SubCoreWNNoteMsg.getCore()");
      paramObject.a((com.tencent.mm.plugin.wenote.model.d)paramcrq);
      paramObject = new and();
      paramObject.scene = 8;
      paramMultiTaskInfo = paramMultiTaskInfo.getByteArray("key_multi_task_common_info");
      paramcrq.a(paramView.JHS, MMApplicationContext.getContext(), Boolean.TRUE, paramView.JHW, paramView.JHX, paramObject, null, paramMultiTaskInfo);
    }
  }
  
  public final void dk(Object paramObject) {}
  
  public final a.b dks()
  {
    return a.b.Ach;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.multitask.NoteMultiTaskUIC
 * JD-Core Version:    0.7.0.1
 */