package com.tencent.mm.plugin.wenote.b;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.a.oz.a;
import com.tencent.mm.f.a.px.a;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.ball.service.e
{
  private static com.tencent.mm.plugin.ball.c.e old;
  private NoteEditorUI QFT;
  
  static
  {
    AppMethodBeat.i(30284);
    old = new b.1();
    AppMethodBeat.o(30284);
  }
  
  public b(NoteEditorUI paramNoteEditorUI, a parama)
  {
    super(parama);
    this.QFT = paramNoteEditorUI;
  }
  
  public static String a(oz.a parama)
  {
    AppMethodBeat.i(30277);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", parama.type);
        if (parama.fNI != null) {
          continue;
        }
        str = "";
        localJSONObject.put("editorId", str);
        localJSONObject.put("field_localId", parama.field_localId);
        if (parama.fNK != null) {
          continue;
        }
        str = "";
        localJSONObject.put("insertJsonData", str);
        if (parama.fNL != null) {
          continue;
        }
        str = "";
        localJSONObject.put("exportJsonData", str);
        localJSONObject.put("isInsert", parama.fNM);
        if (parama.fNN != null) {
          continue;
        }
        str = "";
        localJSONObject.put("bundleData", str);
        localJSONObject.put("itemType", parama.fNO);
        if (parama.path != null) {
          continue;
        }
        str = "";
        localJSONObject.put("path", str);
        localJSONObject.put("intdata", parama.fNP);
        localJSONObject.put("showShare", parama.fNQ);
        if (parama.field_favProto != null) {
          continue;
        }
        str = "";
        localJSONObject.put("field_favProto", str);
        if (parama.fNR != null) {
          continue;
        }
        parama = "";
        localJSONObject.put("reportInfo", parama);
      }
      catch (Exception parama)
      {
        String str;
        Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", parama, "eventToJson NotifyWNNoteOperationEvent", new Object[0]);
        continue;
      }
      parama = localJSONObject.toString();
      AppMethodBeat.o(30277);
      return parama;
      str = parama.fNI;
      continue;
      str = parama.fNK;
      continue;
      str = parama.fNL;
      continue;
      str = bl(parama.fNN);
      continue;
      str = parama.path;
      continue;
      str = Base64.encodeToString(parama.field_favProto.toByteArray(), 0);
      continue;
      parama = Base64.encodeToString(parama.fNR.toByteArray(), 0);
    }
  }
  
  public static String a(px.a parama)
  {
    AppMethodBeat.i(30275);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("msgId", parama.msgId);
        if (parama.fOE != null) {
          continue;
        }
        str = "";
        localJSONObject.put("noteXmlStr", str);
        localJSONObject.put("showShare", parama.fNQ);
        localJSONObject.put("scene", parama.scene);
      }
      catch (Exception parama)
      {
        String str;
        Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", parama, "eventToJson OpenNoteFromSessionEvent", new Object[0]);
        continue;
      }
      parama = localJSONObject.toString();
      AppMethodBeat.o(30275);
      return parama;
      str = parama.fOE;
    }
  }
  
  public static void a(q paramq)
  {
    AppMethodBeat.i(30272);
    if (paramq.QHj)
    {
      if (paramq.wIg) {
        com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        Log.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: true");
        localObject = new j();
        ((j)localObject).QGq = b(paramq);
        ((j)localObject).QGr = 3;
        c.hdm().QGd = ((d)localObject);
        localaoe = new aoe();
        localaoe.scene = 8;
        ((j)localObject).a(paramq.QHn, Long.valueOf(paramq.QHl), true, MMApplicationContext.getContext(), paramq.QHo, paramq.QHp, localaoe, null);
        AppMethodBeat.o(30272);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(2) });
      }
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(14789, new Object[] { Integer.valueOf(1) });
    Log.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: false");
    Object localObject = new g();
    ((g)localObject).QGq = b(paramq);
    ((g)localObject).QGr = 3;
    c.hdm().QGd = ((d)localObject);
    aoe localaoe = new aoe();
    localaoe.scene = 8;
    ((g)localObject).a(paramq.QHk, MMApplicationContext.getContext(), Boolean.TRUE, paramq.QHo, paramq.QHp, localaoe, null, null);
    AppMethodBeat.o(30272);
  }
  
  public static String b(q paramq)
  {
    AppMethodBeat.i(30281);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("topIsOpenFromSession", paramq.QHj);
        localJSONObject.put("topLocalId", paramq.QHk);
        localJSONObject.put("topMsgId", paramq.QHl);
        localJSONObject.put("isChatRoom", paramq.wIg);
        if (paramq.QHm != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topTitle", str);
        if (paramq.QHn != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topNoteXml", str);
        localJSONObject.put("topLastPosition", paramq.QHo);
        localJSONObject.put("topLastOffset", paramq.QHp);
      }
      catch (Exception paramq)
      {
        String str;
        Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramq, "topItemToJson", new Object[0]);
        continue;
      }
      paramq = localJSONObject.toString();
      AppMethodBeat.o(30281);
      return paramq;
      str = paramq.QHm;
      continue;
      str = paramq.QHn;
    }
  }
  
  public static void bNZ()
  {
    AppMethodBeat.i(30273);
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(3, old);
    }
    AppMethodBeat.o(30273);
  }
  
  public static void bOa()
  {
    AppMethodBeat.i(30274);
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(3, old);
    }
    AppMethodBeat.o(30274);
  }
  
  private static String bl(Bundle paramBundle)
  {
    AppMethodBeat.i(30279);
    JSONObject localJSONObject = new JSONObject();
    Object localObject = paramBundle.keySet();
    try
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localJSONObject.put(str, JSONObject.wrap(paramBundle.get(str)));
      }
      paramBundle = localJSONObject.toString();
    }
    catch (JSONException paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramBundle, "bundleToJson", new Object[0]);
      AppMethodBeat.o(30279);
      return null;
    }
    AppMethodBeat.o(30279);
    return paramBundle;
  }
  
  private static px.a bnK(String paramString)
  {
    AppMethodBeat.i(30276);
    try
    {
      paramString = new i(paramString);
      px.a locala = new px.a();
      locala.msgId = paramString.getLong("msgId");
      locala.fOE = paramString.getString("noteXmlStr");
      locala.fNQ = paramString.getBoolean("showShare");
      locala.scene = paramString.getInt("scene");
      locala.context = MMApplicationContext.getContext();
      AppMethodBeat.o(30276);
      return locala;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
      AppMethodBeat.o(30276);
    }
    return null;
  }
  
  private static oz.a bnL(String paramString)
  {
    AppMethodBeat.i(30278);
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
      if (str.equals("")) {}
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
        AppMethodBeat.o(30278);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
      AppMethodBeat.o(30278);
    }
  }
  
  private static Bundle bnM(String paramString)
  {
    AppMethodBeat.i(30280);
    Bundle localBundle = new Bundle();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBundle.putString(str, paramString.getString(str));
      }
      AppMethodBeat.o(30280);
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "jsonToBundle", new Object[0]);
      AppMethodBeat.o(30280);
      return null;
    }
    return localBundle;
  }
  
  private static q bnN(String paramString)
  {
    AppMethodBeat.i(30282);
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
      AppMethodBeat.o(30282);
      return localq;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parseWNNoteKeepTopItem", new Object[0]);
      AppMethodBeat.o(30282);
    }
    return null;
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(30268);
    super.I(paramInt, paramString);
    cvL().kqZ = 5;
    cvL().rYx = 6;
    cvL().lEm = "";
    cvG();
    AppMethodBeat.o(30268);
  }
  
  public final boolean aOg()
  {
    AppMethodBeat.i(30267);
    boolean bool = this.rZC.aOg();
    AppMethodBeat.o(30267);
    return bool;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(30271);
    super.aOi();
    this.rZC.hS(false);
    AppMethodBeat.o(30271);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(30270);
    super.bNW();
    AppMethodBeat.o(30270);
  }
  
  public final boolean bOb()
  {
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(30269);
    super.onDestroy();
    AppMethodBeat.o(30269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.b
 * JD-Core Version:    0.7.0.1
 */