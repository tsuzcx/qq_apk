package com.tencent.mm.plugin.wenote.c;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.oz.a;
import com.tencent.mm.f.a.px.a;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion;", "", "()V", "NoteDataType_FAV_SNS", "", "NoteDataType_SESSION", "NoteDataType_TOP_ITEM", "TAG", "", "taskBarEventListener", "com/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskHelper$Companion$taskBarEventListener$1;", "bundleToJson", "bundle", "Landroid/os/Bundle;", "jsonToBundle", "json", "openNoteFromTopItem", "", "topItem", "Lcom/tencent/mm/plugin/wenote/model/datamodel/WNNoteKeepTopItem;", "parseNotifyWNNoteOperationEventData", "Lcom/tencent/mm/autogen/events/NotifyWNNoteOperationEvent$Data;", "parseOpenNoteFromSessionEventData", "Lcom/tencent/mm/autogen/events/OpenNoteFromSessionEvent$Data;", "parseWNNoteKeepTopItem", "startListeningMultiTaskEvent", "startListeningTaskBarEvent", "stopListeningTaskBarEvent", "app_release"})
public final class a$a
{
  static px.a bnK(String paramString)
  {
    AppMethodBeat.i(288256);
    try
    {
      paramString = new JSONObject(paramString);
      px.a locala = new px.a();
      locala.msgId = paramString.getLong("msgId");
      locala.fOE = paramString.getString("noteXmlStr");
      locala.fNQ = paramString.getBoolean("showShare");
      locala.scene = paramString.getInt("scene");
      locala.context = MMApplicationContext.getContext();
      AppMethodBeat.o(288256);
      return locala;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
      AppMethodBeat.o(288256);
    }
    return null;
  }
  
  static oz.a bnL(String paramString)
  {
    AppMethodBeat.i(288254);
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
        AppMethodBeat.o(288254);
        return paramString;
        p.j(str, "bd");
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
      AppMethodBeat.o(288254);
    }
  }
  
  private static Bundle bnM(String paramString)
  {
    AppMethodBeat.i(288255);
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
          AppMethodBeat.o(288255);
          throw paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "jsonToBundle", new Object[0]);
        AppMethodBeat.o(288255);
        return null;
      }
      Object localObject = (String)localObject;
      localBundle.putString((String)localObject, paramString.getString((String)localObject));
    }
    AppMethodBeat.o(288255);
    return localBundle;
  }
  
  static q bnN(String paramString)
  {
    AppMethodBeat.i(288257);
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
      AppMethodBeat.o(288257);
      return localq;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", (Throwable)paramString, "parseWNNoteKeepTopItem", new Object[0]);
      AppMethodBeat.o(288257);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.c.a.a
 * JD-Core Version:    0.7.0.1
 */