package com.tencent.mm.plugin.wenote.b;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.autogen.a.ql.a;
import com.tencent.mm.autogen.a.rk;
import com.tencent.mm.autogen.a.rk.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.wenote.a.b;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "bundleToJson", "", "bundle", "Landroid/os/Bundle;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "jsonToBundle", "json", "onMultiTaskInit", "", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "openNoteFromTopItem", "topItem", "Lcom/tencent/mm/plugin/wenote/model/datamodel/WNNoteKeepTopItem;", "parseNotifyWNNoteOperationEventData", "Lcom/tencent/mm/autogen/events/NotifyWNNoteOperationEvent$Data;", "parseOpenNoteFromSessionEventData", "Lcom/tencent/mm/autogen/events/OpenNoteFromSessionEvent$Data;", "parseWNNoteKeepTopItem", "supportMultiTaskType", "", "multiTaskType", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final c.a XCh;
  
  static
  {
    AppMethodBeat.i(275114);
    XCh = new c.a((byte)0);
    AppMethodBeat.o(275114);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(275081);
    AppMethodBeat.o(275081);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(275085);
    AppMethodBeat.o(275085);
  }
  
  private static Bundle bnA(String paramString)
  {
    AppMethodBeat.i(275096);
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
          AppMethodBeat.o(275096);
          throw paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "jsonToBundle", new Object[0]);
        AppMethodBeat.o(275096);
        return null;
      }
      Object localObject = (String)localObject;
      localBundle.putString((String)localObject, paramString.getString((String)localObject));
    }
    AppMethodBeat.o(275096);
    return localBundle;
  }
  
  private static q bnB(String paramString)
  {
    AppMethodBeat.i(275110);
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
      AppMethodBeat.o(275110);
      return localq;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "parseWNNoteKeepTopItem", new Object[0]);
      AppMethodBeat.o(275110);
    }
    return null;
  }
  
  private static rk.a bny(String paramString)
  {
    AppMethodBeat.i(275102);
    try
    {
      paramString = new JSONObject(paramString);
      rk.a locala = new rk.a();
      locala.msgId = paramString.getLong("msgId");
      locala.hUx = paramString.getString("noteXmlStr");
      locala.hTH = paramString.getBoolean("showShare");
      locala.scene = paramString.getInt("scene");
      locala.context = MMApplicationContext.getContext();
      AppMethodBeat.o(275102);
      return locala;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
      AppMethodBeat.o(275102);
    }
    return null;
  }
  
  private static ql.a bnz(String paramString)
  {
    AppMethodBeat.i(275091);
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
        AppMethodBeat.o(275091);
        return paramString;
        s.s(str, "bd");
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", (Throwable)paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
      AppMethodBeat.o(275091);
    }
  }
  
  public final boolean Qs(int paramInt)
  {
    return paramInt == 3;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    AppMethodBeat.i(275130);
    s.u(paramMultiTaskInfo, "info");
    s.u(paramdrt, "animateData");
    paramObject = new aet();
    paramObject.ZmM = paramdrt;
    if (paramView != null)
    {
      paramdrt = a.PlI;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      paramView = a.a.jC(paramView);
      if (paramView == null)
      {
        paramView = null;
        if (paramView != null) {
          break label155;
        }
        paramView = null;
        label72:
        paramObject.zIO = paramView;
      }
    }
    else
    {
      paramView = new dur();
    }
    for (;;)
    {
      try
      {
        paramView.parseFrom(paramMultiTaskInfo.field_data);
        int i = paramView.hQm;
        paramView = paramView.abaD;
        switch (i)
        {
        default: 
          AppMethodBeat.o(275130);
          return;
        }
      }
      catch (Exception paramView)
      {
        label155:
        Log.e("MicroMsg.NoteMultiTaskUIC", paramView.getMessage());
        AppMethodBeat.o(275130);
        return;
      }
      paramView = (dry)paramView.aiK(5);
      break;
      paramView = paramView.zIO;
      break label72;
      paramView = bnz(paramView);
      if (paramView == null)
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "NotifyWNNoteOperationEvent data is null");
        AppMethodBeat.o(275130);
        return;
      }
      paramView.hTF.putByteArray("key_multi_task_common_info", paramObject.toByteArray());
      if (paramView.type == 9)
      {
        paramdrt = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramView.field_localId);
        if (paramdrt != null)
        {
          paramView.hTA = paramdrt.field_xml;
          paramObject = new Bundle();
          arp localarp = paramdrt.field_favProto.YzK;
          s.s(localarp, "favItemInfo.field_favProto.getNoteInfo()");
          paramObject.putString("noteauthor", localarp.ZBm);
          paramObject.putString("noteeditor", localarp.ZBn);
          paramObject.putLong("edittime", paramdrt.field_updateTime);
          paramView.hTF = paramObject;
          paramView.field_favProto = paramdrt.field_favProto;
          paramView.type = 2;
        }
      }
      paramdrt = new ql();
      if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramView.field_localId) == null) {}
      for (paramView = null; paramView == null; paramView = Boolean.valueOf(paramdrt.publish()))
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "favItemInfo id deleted");
        aa.makeText(MMApplicationContext.getContext(), R.l.gPd, 0).show();
        ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class)).removeTaskInfoAndCoverImg(paramMultiTaskInfo.field_id);
        AppMethodBeat.o(275130);
        return;
        paramdrt.hTy = paramView;
      }
      paramView.booleanValue();
      AppMethodBeat.o(275130);
      return;
      paramView = bny(paramView);
      if (paramView == null)
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "OpenNoteFromSessionEvent data is null");
        AppMethodBeat.o(275130);
        return;
      }
      paramView.hTF = new Bundle();
      paramView.hTF.putByteArray("key_multi_task_common_info", paramObject.toByteArray());
      paramMultiTaskInfo = new rk();
      paramMultiTaskInfo.hUw = paramView;
      paramMultiTaskInfo.publish();
      AppMethodBeat.o(275130);
      return;
      Log.i("MicroMsg.NoteMultiTaskUIC", "click WNNoteBanner");
      paramView = bnB(paramView);
      if (paramView == null)
      {
        Log.e("MicroMsg.NoteMultiTaskUIC", "WNNoteKeepTopItem data is null");
        AppMethodBeat.o(275130);
        return;
      }
      paramMultiTaskInfo = new Bundle();
      paramMultiTaskInfo.putByteArray("key_multi_task_common_info", paramObject.toByteArray());
      if (paramView.XAH)
      {
        if (paramView.Aeu) {
          com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(3) });
        }
        for (;;)
        {
          Log.i("MicroMsg.NoteMultiTaskUIC", "isOpenFromSession: true");
          paramdrt = new j();
          paramdrt.XzO = b.b(paramView);
          paramdrt.XzP = 3;
          com.tencent.mm.plugin.wenote.model.c.iDT().XzB = ((com.tencent.mm.plugin.wenote.model.d)paramdrt);
          paramObject = new arx();
          paramObject.scene = 8;
          paramdrt.a(paramView.XAL, Long.valueOf(paramView.XAJ), true, MMApplicationContext.getContext(), paramView.XAM, paramView.XAN, paramObject, paramMultiTaskInfo);
          AppMethodBeat.o(275130);
          return;
          com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(2) });
        }
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(1) });
      Log.i("MicroMsg.NoteMultiTaskUIC", "isOpenFromSession: false");
      paramdrt = new com.tencent.mm.plugin.wenote.model.g();
      paramdrt.XzO = b.b(paramView);
      paramdrt.XzP = 3;
      com.tencent.mm.plugin.wenote.model.c.iDT().XzB = ((com.tencent.mm.plugin.wenote.model.d)paramdrt);
      paramObject = new arx();
      paramObject.scene = 8;
      paramMultiTaskInfo = paramMultiTaskInfo.getByteArray("key_multi_task_common_info");
      paramdrt.a(paramView.XAI, MMApplicationContext.getContext(), Boolean.TRUE, paramView.XAM, paramView.XAN, paramObject, null, paramMultiTaskInfo);
    }
  }
  
  public final a.b eDe()
  {
    return a.b.LDq;
  }
  
  public final void fw(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.c
 * JD-Core Version:    0.7.0.1
 */