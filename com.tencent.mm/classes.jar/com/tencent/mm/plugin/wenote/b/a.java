package com.tencent.mm.plugin.wenote.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.autogen.a.ql.a;
import com.tencent.mm.autogen.a.rk;
import com.tencent.mm.autogen.a.rk.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.multitask.b.c.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "activity", "Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "getActivity", "()Lcom/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI;", "data", "", "isSupportMultiTaskFBMenu", "", "()Z", "isSupportSwipeToMultiTask", "title", "type", "", "beforeOnMenuEnterOrSwipebackToMultiTask", "", "onMenuFloatBallSelectCallback", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "fillMultiTaskInfo", "handleCurrentHistoryTaskInfoOnClose", "bitmap", "Landroid/graphics/Bitmap;", "ended", "isSupportSwipeToHome", "onClose", "way", "end", "onCreate", "multiTaskType", "multiTaskId", "onDataChanged", "jsonData", "onMenuMultiTaskSelected", "enterMultiTask", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.multitask.b.c
{
  public static final a XCd;
  private static final b XCf;
  private final NoteEditorUI XCe;
  public String data;
  public String title;
  public int type;
  
  static
  {
    AppMethodBeat.i(275089);
    XCd = new a((byte)0);
    XCf = new b();
    AppMethodBeat.o(275089);
  }
  
  public a(NoteEditorUI paramNoteEditorUI, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(275084);
    this.XCe = paramNoteEditorUI;
    this.data = "";
    this.title = "";
    Log.i("MicroMsg.NoteMultiTaskHelper", "create, NoteEditorUI:%s", new Object[] { Integer.valueOf(this.XCe.hashCode()) });
    AppMethodBeat.o(275084);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(275099);
    super.J(paramInt, paramString);
    if (gjZ())
    {
      paramString = this.LBU;
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
      paramString = this.LBU;
      if (paramString != null)
      {
        paramString = paramString.getActivity();
        if (paramString != null) {
          paramString.overridePendingTransition(R.a.fast_faded_in, 0);
        }
      }
      paramString = this.LBU;
      if (paramString != null) {
        break label111;
      }
    }
    label111:
    for (paramString = null;; paramString = paramString.getActivity())
    {
      com.tencent.mm.ui.base.b.a(paramString, null);
      AppMethodBeat.o(275099);
      return;
    }
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(275127);
    if (gjZ())
    {
      NoteEditorUI localNoteEditorUI = this.XCe;
      if (localNoteEditorUI != null) {
        localNoteEditorUI.hideVKB();
      }
    }
    super.a(paramb);
    AppMethodBeat.o(275127);
  }
  
  public final void bnK(String paramString)
  {
    AppMethodBeat.i(275094);
    s.u(paramString, "title");
    this.title = paramString;
    cCe();
    super.ke(true);
    AppMethodBeat.o(275094);
  }
  
  public final boolean cBZ()
  {
    return true;
  }
  
  public final boolean cCa()
  {
    return true;
  }
  
  public final void cCe()
  {
    AppMethodBeat.i(275122);
    if (this.type == 0)
    {
      AppMethodBeat.o(275122);
      return;
    }
    try
    {
      dur localdur = new dur();
      localdur.hQm = this.type;
      localdur.abaD = this.data;
      Object localObject = this.LCE;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((MultiTaskInfo)localObject).gkh())
      {
        if (localObject != null) {
          ((drz)localObject).title = this.title;
        }
        localObject = this.LCE;
        if (localObject == null) {
          break;
        }
        ((MultiTaskInfo)localObject).field_data = localdur.toByteArray();
        AppMethodBeat.o(275122);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NoteMultiTaskHelper", s.X("onMenuMultiTaskSelected error, ex = ", localException.getMessage()));
      AppMethodBeat.o(275122);
    }
  }
  
  public final void e(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(275111);
    if (paramBoolean)
    {
      Log.i("MicroMsg.NoteMultiTaskHelper", "ended, remove historyTaskInfo");
      gkb();
      AppMethodBeat.o(275111);
      return;
    }
    Log.i("MicroMsg.NoteMultiTaskHelper", "not ended update historyTaskInfo");
    as(paramBitmap);
    AppMethodBeat.o(275111);
  }
  
  public final boolean eCI()
  {
    return true;
  }
  
  public final boolean n(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(275106);
    s.u(paramString, "title");
    NoteEditorUI localNoteEditorUI = this.XCe;
    if (localNoteEditorUI != null) {
      localNoteEditorUI.hideVKB();
    }
    this.title = paramString;
    cCe();
    paramBoolean = super.af(paramInt, paramBoolean);
    AppMethodBeat.o(275106);
    return paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion;", "", "()V", "NoteDataType_FAV_SNS", "", "NoteDataType_SESSION", "NoteDataType_TOP_ITEM", "TAG", "", "taskBarEventListener", "com/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion$taskBarEventListener$1;", "bundleToJson", "bundle", "Landroid/os/Bundle;", "jsonToBundle", "json", "openNoteFromTopItem", "", "topItem", "Lcom/tencent/mm/plugin/wenote/model/datamodel/WNNoteKeepTopItem;", "parseNotifyWNNoteOperationEventData", "Lcom/tencent/mm/autogen/events/NotifyWNNoteOperationEvent$Data;", "parseOpenNoteFromSessionEventData", "Lcom/tencent/mm/autogen/events/OpenNoteFromSessionEvent$Data;", "parseWNNoteKeepTopItem", "startListeningMultiTaskEvent", "startListeningTaskBarEvent", "stopListeningTaskBarEvent", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static Bundle bnA(String paramString)
    {
      AppMethodBeat.i(275098);
      Bundle localBundle = new Bundle();
      for (;;)
      {
        try
        {
          paramString = new JSONObject(paramString);
          Iterator localIterator = paramString.keys();
          s.s(localIterator, "jsonObject.keys()");
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
          if (localObject == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(275098);
            throw paramString;
          }
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "jsonToBundle", new Object[0]);
          AppMethodBeat.o(275098);
          return null;
        }
        Object localObject = (String)localObject;
        localBundle.putString((String)localObject, paramString.getString((String)localObject));
      }
      AppMethodBeat.o(275098);
      return localBundle;
    }
    
    static q bnB(String paramString)
    {
      AppMethodBeat.i(275112);
      try
      {
        q localq = new q();
        paramString = new JSONObject(paramString);
        localq.XAH = paramString.getBoolean("topIsOpenFromSession");
        localq.XAI = paramString.getLong("topLocalId");
        localq.XAJ = paramString.getLong("topMsgId");
        localq.Aeu = paramString.getBoolean("isChatRoom");
        localq.XAK = paramString.getString("topTitle");
        localq.XAL = paramString.getString("topNoteXml");
        localq.XAM = paramString.getInt("topLastPosition");
        localq.XAN = paramString.getInt("topLastOffset");
        AppMethodBeat.o(275112);
        return localq;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "parseWNNoteKeepTopItem", new Object[0]);
        AppMethodBeat.o(275112);
      }
      return null;
    }
    
    static rk.a bny(String paramString)
    {
      AppMethodBeat.i(275105);
      try
      {
        paramString = new JSONObject(paramString);
        rk.a locala = new rk.a();
        locala.msgId = paramString.getLong("msgId");
        locala.hUx = paramString.getString("noteXmlStr");
        locala.hTH = paramString.getBoolean("showShare");
        locala.scene = paramString.getInt("scene");
        locala.context = MMApplicationContext.getContext();
        AppMethodBeat.o(275105);
        return locala;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
        AppMethodBeat.o(275105);
      }
      return null;
    }
    
    static ql.a bnz(String paramString)
    {
      AppMethodBeat.i(275092);
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = new ql.a();
        paramString.type = ((JSONObject)localObject).getInt("type");
        paramString.hTA = ((JSONObject)localObject).getString("editorId");
        paramString.field_localId = ((JSONObject)localObject).getLong("field_localId");
        paramString.hTC = ((JSONObject)localObject).getString("insertJsonData");
        paramString.hTD = ((JSONObject)localObject).getString("exportJsonData");
        paramString.hTE = ((JSONObject)localObject).getBoolean("isInsert");
        String str = ((JSONObject)localObject).getString("bundleData");
        if (s.p(str, "")) {}
        for (paramString.hTF = null;; paramString.hTF = bnA(str))
        {
          paramString.itemType = ((JSONObject)localObject).getInt("itemType");
          paramString.path = ((JSONObject)localObject).getString("path");
          paramString.hTG = ((JSONObject)localObject).getInt("intdata");
          paramString.hTH = ((JSONObject)localObject).getBoolean("showShare");
          paramString.field_favProto = new arv();
          str = ((JSONObject)localObject).getString("field_favProto");
          if (!Util.isNullOrNil(str)) {
            paramString.field_favProto.parseFrom(Base64.decode(str, 0));
          }
          paramString.hTI = new arx();
          localObject = ((JSONObject)localObject).getString("reportInfo");
          if (!Util.isNullOrNil((String)localObject)) {
            paramString.hTI.parseFrom(Base64.decode((String)localObject, 0));
          }
          paramString.context = MMApplicationContext.getContext();
          AppMethodBeat.o(275092);
          return paramString;
          s.s(str, "bd");
        }
        return null;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
        AppMethodBeat.o(275092);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.a
  {
    public final void a(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(275088);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(275088);
    }
    
    public final void b(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(275103);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      Object localObject1 = new dur();
      for (;;)
      {
        try
        {
          ((dur)localObject1).parseFrom(paramMultiTaskInfo.field_data);
          paramMultiTaskInfo = new aet();
          paramMultiTaskInfo.ZmN = true;
          int i = ((dur)localObject1).hQm;
          localObject1 = ((dur)localObject1).abaD;
          switch (i)
          {
          default: 
            AppMethodBeat.o(275103);
            return;
          }
        }
        catch (Exception paramMultiTaskInfo)
        {
          Log.e("MicroMsg.NoteMultiTaskHelper", paramMultiTaskInfo.getMessage());
          AppMethodBeat.o(275103);
          return;
        }
        Object localObject2 = a.XCd;
        localObject1 = a.a.bnz((String)localObject1);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.NoteMultiTaskHelper", "NotifyWNNoteOperationEvent data is null");
          AppMethodBeat.o(275103);
          return;
        }
        try
        {
          ((ql.a)localObject1).hTF.putByteArray("key_multi_task_common_info", paramMultiTaskInfo.toByteArray());
          if (((ql.a)localObject1).type == 9)
          {
            paramMultiTaskInfo = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(((ql.a)localObject1).field_localId);
            s.s(paramMultiTaskInfo, "plugin(IPluginFav::class…calId(data.field_localId)");
            ((ql.a)localObject1).hTA = paramMultiTaskInfo.field_xml;
            localObject2 = new Bundle();
            localObject3 = paramMultiTaskInfo.field_favProto.YzK;
            s.s(localObject3, "favItemInfo.field_favProto.getNoteInfo()");
            ((Bundle)localObject2).putString("noteauthor", ((arp)localObject3).ZBm);
            ((Bundle)localObject2).putString("noteeditor", ((arp)localObject3).ZBn);
            ((Bundle)localObject2).putLong("edittime", paramMultiTaskInfo.field_updateTime);
            ((ql.a)localObject1).hTF = ((Bundle)localObject2);
            ((ql.a)localObject1).field_favProto = paramMultiTaskInfo.field_favProto;
            ((ql.a)localObject1).type = 2;
          }
          paramMultiTaskInfo = new ql();
          paramMultiTaskInfo.hTy = ((ql.a)localObject1);
          paramMultiTaskInfo.publish();
          AppMethodBeat.o(275103);
          return;
        }
        catch (Exception paramMultiTaskInfo)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.WebMultiTaskHelper", (Throwable)paramMultiTaskInfo, "onTaskBarItemClicked", new Object[0]);
          }
        }
        localObject2 = a.XCd;
        localObject1 = a.a.bny((String)localObject1);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.NoteMultiTaskHelper", "OpenNoteFromSessionEvent data is null");
          AppMethodBeat.o(275103);
          return;
        }
        ((rk.a)localObject1).hTF = new Bundle();
        ((rk.a)localObject1).hTF.putByteArray("key_multi_task_common_info", paramMultiTaskInfo.toByteArray());
        paramMultiTaskInfo = new rk();
        paramMultiTaskInfo.hUw = ((rk.a)localObject1);
        paramMultiTaskInfo.publish();
        AppMethodBeat.o(275103);
        return;
        Log.i("MicroMsg.NoteMultiTaskHelper", "click WNNoteBanner");
        localObject2 = a.XCd;
        localObject1 = a.a.bnB((String)localObject1);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.NoteMultiTaskHelper", "WNNoteKeepTopItem data is null");
          AppMethodBeat.o(275103);
          return;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putByteArray("key_multi_task_common_info", paramMultiTaskInfo.toByteArray());
        paramMultiTaskInfo = a.XCd;
        if (((q)localObject1).XAH)
        {
          if (((q)localObject1).Aeu) {
            com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(3) });
          }
          for (;;)
          {
            Log.i("MicroMsg.NoteMultiTaskHelper", "isOpenFromSession: true");
            paramMultiTaskInfo = new j();
            paramMultiTaskInfo.XzO = com.tencent.mm.plugin.wenote.a.b.b((q)localObject1);
            paramMultiTaskInfo.XzP = 3;
            com.tencent.mm.plugin.wenote.model.c.iDT().XzB = ((d)paramMultiTaskInfo);
            localObject3 = new arx();
            ((arx)localObject3).scene = 8;
            paramMultiTaskInfo.a(((q)localObject1).XAL, Long.valueOf(((q)localObject1).XAJ), true, MMApplicationContext.getContext(), ((q)localObject1).XAM, ((q)localObject1).XAN, (arx)localObject3, (Bundle)localObject2);
            AppMethodBeat.o(275103);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(2) });
          }
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(1) });
        Log.i("MicroMsg.NoteMultiTaskHelper", "isOpenFromSession: false");
        paramMultiTaskInfo = new com.tencent.mm.plugin.wenote.model.g();
        paramMultiTaskInfo.XzO = com.tencent.mm.plugin.wenote.a.b.b((q)localObject1);
        paramMultiTaskInfo.XzP = 3;
        com.tencent.mm.plugin.wenote.model.c.iDT().XzB = ((d)paramMultiTaskInfo);
        Object localObject3 = new arx();
        ((arx)localObject3).scene = 8;
        localObject2 = ((Bundle)localObject2).getByteArray("key_multi_task_common_info");
        paramMultiTaskInfo.a(((q)localObject1).XAI, MMApplicationContext.getContext(), Boolean.TRUE, ((q)localObject1).XAM, ((q)localObject1).XAN, (arx)localObject3, null, (byte[])localObject2);
      }
    }
    
    public final void c(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(275109);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(275109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.a
 * JD-Core Version:    0.7.0.1
 */