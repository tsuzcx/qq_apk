package com.tencent.mm.plugin.wenote.multitask;

import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.oc.a;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.pa.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.multitask.b.c.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.taskbar.api.c.a;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.b;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "activity", "Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "getActivity", "()Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;", "data", "", "isSupportMultiTaskFBMenu", "", "()Z", "isSupportSwipeToMultiTask", "title", "type", "", "beforeOnMenuEnterOrSwipebackToMultiTask", "", "onMenuFloatBallSelectCallback", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "fillMultiTaskInfo", "isSupportSwipeToHome", "onClose", "way", "end", "onCreate", "multiTaskType", "multiTaskId", "onDataChanged", "jsonData", "onMenuMultiTaskSelected", "enterMultiTask", "Companion", "app_release"})
public final class a
  extends com.tencent.mm.plugin.multitask.b.c
{
  private static final b JJn;
  public static final a JJo;
  private final NoteEditorUI JJm;
  public String data;
  public String title;
  public int type;
  
  static
  {
    AppMethodBeat.i(230922);
    JJo = new a((byte)0);
    JJn = new b();
    AppMethodBeat.o(230922);
  }
  
  public a(NoteEditorUI paramNoteEditorUI, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(230921);
    this.JJm = paramNoteEditorUI;
    this.data = "";
    this.title = "";
    Log.i("MicroMsg.NoteMultiTaskHelper", "create, NoteEditorUI:%s", new Object[] { Integer.valueOf(this.JJm.hashCode()) });
    AppMethodBeat.o(230921);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(230917);
    super.G(paramInt, paramString);
    if (eqZ())
    {
      paramString = this.Aak;
      if (paramString != null)
      {
        paramString = paramString.getActivity();
        if (paramString != null)
        {
          paramString = paramString.getWindow();
          if (paramString != null)
          {
            paramString = paramString.getDecorView();
            if (paramString != null) {
              paramString.setBackgroundColor(0);
            }
          }
        }
      }
      paramString = this.Aak;
      if (paramString != null)
      {
        paramString = paramString.getActivity();
        if (paramString != null) {
          paramString.overridePendingTransition(2130772059, 0);
        }
      }
      paramString = this.Aak;
      if (paramString == null) {
        break label115;
      }
    }
    label115:
    for (paramString = paramString.getActivity();; paramString = null)
    {
      b.a(paramString, null);
      AppMethodBeat.o(230917);
      return;
    }
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(230920);
    if (eqZ())
    {
      NoteEditorUI localNoteEditorUI = this.JJm;
      if (localNoteEditorUI != null) {
        localNoteEditorUI.hideVKB();
      }
    }
    super.a(paramb);
    AppMethodBeat.o(230920);
  }
  
  public final boolean bPp()
  {
    return true;
  }
  
  public final boolean bPq()
  {
    return true;
  }
  
  public final void bPu()
  {
    AppMethodBeat.i(230919);
    if (this.type == 0)
    {
      AppMethodBeat.o(230919);
      return;
    }
    try
    {
      ctx localctx = new ctx();
      localctx.dRq = this.type;
      localctx.Mzh = this.data;
      Object localObject = this.Abp;
      if (localObject != null)
      {
        localObject = ((MultiTaskInfo)localObject).erh();
        if (localObject != null) {
          ((cru)localObject).title = this.title;
        }
      }
      localObject = this.Abp;
      if (localObject != null)
      {
        ((MultiTaskInfo)localObject).field_data = localctx.toByteArray();
        AppMethodBeat.o(230919);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NoteMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + localException.getMessage());
      AppMethodBeat.o(230919);
      return;
    }
    AppMethodBeat.o(230919);
  }
  
  public final void bbW(String paramString)
  {
    AppMethodBeat.i(230916);
    p.h(paramString, "title");
    this.title = paramString;
    bPu();
    super.ic(true);
    AppMethodBeat.o(230916);
  }
  
  public final boolean dki()
  {
    return true;
  }
  
  public final boolean l(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(230918);
    p.h(paramString, "title");
    NoteEditorUI localNoteEditorUI = this.JJm;
    if (localNoteEditorUI != null) {
      localNoteEditorUI.hideVKB();
    }
    this.title = paramString;
    bPu();
    paramBoolean = super.O(paramInt, paramBoolean);
    AppMethodBeat.o(230918);
    return paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion;", "", "()V", "NoteDataType_FAV_SNS", "", "NoteDataType_SESSION", "NoteDataType_TOP_ITEM", "TAG", "", "taskBarEventListener", "com/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion$taskBarEventListener$1;", "bundleToJson", "bundle", "Landroid/os/Bundle;", "jsonToBundle", "json", "openNoteFromTopItem", "", "topItem", "Lcom/tencent/mm/plugin/wenote/model/datamodel/WNNoteKeepTopItem;", "parseNotifyWNNoteOperationEventData", "Lcom/tencent/mm/autogen/events/NotifyWNNoteOperationEvent$Data;", "parseOpenNoteFromSessionEventData", "Lcom/tencent/mm/autogen/events/OpenNoteFromSessionEvent$Data;", "parseWNNoteKeepTopItem", "startListeningMultiTaskEvent", "startListeningTaskBarEvent", "stopListeningTaskBarEvent", "app_release"})
  public static final class a
  {
    static pa.a bbK(String paramString)
    {
      AppMethodBeat.i(230914);
      try
      {
        paramString = new JSONObject(paramString);
        pa.a locala = new pa.a();
        locala.msgId = paramString.getLong("msgId");
        locala.dVc = paramString.getString("noteXmlStr");
        locala.dUo = paramString.getBoolean("showShare");
        locala.scene = paramString.getInt("scene");
        locala.context = MMApplicationContext.getContext();
        AppMethodBeat.o(230914);
        return locala;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
        AppMethodBeat.o(230914);
      }
      return null;
    }
    
    static oc.a bbL(String paramString)
    {
      AppMethodBeat.i(230912);
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
          AppMethodBeat.o(230912);
          return paramString;
          p.g(str, "bd");
        }
        return null;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
        AppMethodBeat.o(230912);
      }
    }
    
    private static Bundle bbM(String paramString)
    {
      AppMethodBeat.i(230913);
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
            AppMethodBeat.o(230913);
            throw paramString;
          }
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "jsonToBundle", new Object[0]);
          AppMethodBeat.o(230913);
          return null;
        }
        Object localObject = (String)localObject;
        localBundle.putString((String)localObject, paramString.getString((String)localObject));
      }
      AppMethodBeat.o(230913);
      return localBundle;
    }
    
    static q bbN(String paramString)
    {
      AppMethodBeat.i(230915);
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
        AppMethodBeat.o(230915);
        return localq;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "parseWNNoteKeepTopItem", new Object[0]);
        AppMethodBeat.o(230915);
      }
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "app_release"})
  public static final class b
    implements c.a
  {
    public final void a(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(230909);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(230909);
    }
    
    public final void b(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(230910);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      Object localObject3 = new ctx();
      for (;;)
      {
        Object localObject1;
        try
        {
          ((ctx)localObject3).parseFrom(paramMultiTaskInfo.field_data);
          localObject1 = new ach();
          ((ach)localObject1).LmR = true;
          int i = ((ctx)localObject3).dRq;
          paramMultiTaskInfo = ((ctx)localObject3).Mzh;
          switch (i)
          {
          default: 
            AppMethodBeat.o(230910);
            return;
          }
        }
        catch (Exception paramMultiTaskInfo)
        {
          Log.e("MicroMsg.NoteMultiTaskHelper", paramMultiTaskInfo.getMessage());
          AppMethodBeat.o(230910);
          return;
        }
        localObject3 = a.JJo;
        paramMultiTaskInfo = a.a.bbL(paramMultiTaskInfo);
        if (paramMultiTaskInfo == null)
        {
          Log.e("MicroMsg.NoteMultiTaskHelper", "NotifyWNNoteOperationEvent data is null");
          AppMethodBeat.o(230910);
          return;
        }
        try
        {
          paramMultiTaskInfo.dUl.putByteArray("key_multi_task_common_info", ((ach)localObject1).toByteArray());
          if (paramMultiTaskInfo.type == 9)
          {
            localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramMultiTaskInfo.field_localId);
            p.g(localObject1, "MMKernel.plugin(IPluginF…calId(data.field_localId)");
            if (localObject1 != null)
            {
              paramMultiTaskInfo.dUg = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_xml;
              localObject3 = new Bundle();
              localObject4 = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.guj();
              p.g(localObject4, "favItemInfo.field_favProto.getNoteInfo()");
              if (localObject4 != null)
              {
                ((Bundle)localObject3).putString("noteauthor", ((amv)localObject4).LxT);
                ((Bundle)localObject3).putString("noteeditor", ((amv)localObject4).LxU);
              }
              ((Bundle)localObject3).putLong("edittime", ((com.tencent.mm.plugin.fav.a.g)localObject1).field_updateTime);
              paramMultiTaskInfo.dUl = ((Bundle)localObject3);
              paramMultiTaskInfo.field_favProto = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto;
              paramMultiTaskInfo.type = 2;
            }
          }
          localObject1 = new oc();
          ((oc)localObject1).dUe = paramMultiTaskInfo;
          EventCenter.instance.publish((IEvent)localObject1);
          AppMethodBeat.o(230910);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.WebMultiTaskHelper", (Throwable)localException, "onTaskBarItemClicked", new Object[0]);
          }
        }
        localObject3 = a.JJo;
        paramMultiTaskInfo = a.a.bbK(paramMultiTaskInfo);
        if (paramMultiTaskInfo == null)
        {
          Log.e("MicroMsg.NoteMultiTaskHelper", "OpenNoteFromSessionEvent data is null");
          AppMethodBeat.o(230910);
          return;
        }
        paramMultiTaskInfo.dUl = new Bundle();
        paramMultiTaskInfo.dUl.putByteArray("key_multi_task_common_info", localException.toByteArray());
        Object localObject2 = new pa();
        ((pa)localObject2).dVb = paramMultiTaskInfo;
        EventCenter.instance.publish((IEvent)localObject2);
        AppMethodBeat.o(230910);
        return;
        Log.i("MicroMsg.NoteMultiTaskHelper", "click WNNoteBanner");
        localObject3 = a.JJo;
        paramMultiTaskInfo = a.a.bbN(paramMultiTaskInfo);
        if (paramMultiTaskInfo == null)
        {
          Log.e("MicroMsg.NoteMultiTaskHelper", "WNNoteKeepTopItem data is null");
          AppMethodBeat.o(230910);
          return;
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putByteArray("key_multi_task_common_info", ((ach)localObject2).toByteArray());
        localObject2 = a.JJo;
        if (paramMultiTaskInfo.JHR)
        {
          if (paramMultiTaskInfo.tcb) {
            h.CyF.a(14789, new Object[] { Integer.valueOf(3) });
          }
          for (;;)
          {
            Log.i("MicroMsg.NoteMultiTaskHelper", "isOpenFromSession: true");
            localObject2 = new j();
            ((j)localObject2).JGY = com.tencent.mm.plugin.wenote.b.a.b(paramMultiTaskInfo);
            ((j)localObject2).JGZ = 3;
            localObject4 = com.tencent.mm.plugin.wenote.model.c.gjz();
            p.g(localObject4, "SubCoreWNNoteMsg.getCore()");
            ((com.tencent.mm.plugin.wenote.model.c)localObject4).a((d)localObject2);
            localObject4 = new and();
            ((and)localObject4).scene = 8;
            ((j)localObject2).a(paramMultiTaskInfo.JHV, Long.valueOf(paramMultiTaskInfo.JHT), true, MMApplicationContext.getContext(), paramMultiTaskInfo.JHW, paramMultiTaskInfo.JHX, (and)localObject4, (Bundle)localObject3);
            AppMethodBeat.o(230910);
            return;
            h.CyF.a(14789, new Object[] { Integer.valueOf(2) });
          }
        }
        h.CyF.a(14789, new Object[] { Integer.valueOf(1) });
        Log.i("MicroMsg.NoteMultiTaskHelper", "isOpenFromSession: false");
        localObject2 = new com.tencent.mm.plugin.wenote.model.g();
        ((com.tencent.mm.plugin.wenote.model.g)localObject2).JGY = com.tencent.mm.plugin.wenote.b.a.b(paramMultiTaskInfo);
        ((com.tencent.mm.plugin.wenote.model.g)localObject2).JGZ = 3;
        Object localObject4 = com.tencent.mm.plugin.wenote.model.c.gjz();
        p.g(localObject4, "SubCoreWNNoteMsg.getCore()");
        ((com.tencent.mm.plugin.wenote.model.c)localObject4).a((d)localObject2);
        localObject4 = new and();
        ((and)localObject4).scene = 8;
        localObject3 = ((Bundle)localObject3).getByteArray("key_multi_task_common_info");
        ((com.tencent.mm.plugin.wenote.model.g)localObject2).a(paramMultiTaskInfo.JHS, MMApplicationContext.getContext(), Boolean.TRUE, paramMultiTaskInfo.JHW, paramMultiTaskInfo.JHX, (and)localObject4, null, (byte[])localObject3);
      }
    }
    
    public final void c(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(230911);
      p.h(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(230911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.multitask.a
 * JD-Core Version:    0.7.0.1
 */