package com.tencent.mm.plugin.wenote.b;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.oc.a;
import com.tencent.mm.g.a.pa.a;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static e lqt;
  private NoteEditorUI UtH;
  
  static
  {
    AppMethodBeat.i(30284);
    lqt = new com.tencent.mm.plugin.ball.c.f()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(30266);
        a.a(paramAnonymousBallInfo);
        AppMethodBeat.o(30266);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(30284);
  }
  
  public a(NoteEditorUI paramNoteEditorUI, b paramb)
  {
    super(paramb);
    this.UtH = paramNoteEditorUI;
  }
  
  public static String a(oc.a parama)
  {
    AppMethodBeat.i(30277);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", parama.type);
        if (parama.dUg != null) {
          continue;
        }
        str = "";
        localJSONObject.put("editorId", str);
        localJSONObject.put("field_localId", parama.field_localId);
        if (parama.dUi != null) {
          continue;
        }
        str = "";
        localJSONObject.put("insertJsonData", str);
        if (parama.dUj != null) {
          continue;
        }
        str = "";
        localJSONObject.put("exportJsonData", str);
        localJSONObject.put("isInsert", parama.dUk);
        if (parama.dUl != null) {
          continue;
        }
        str = "";
        localJSONObject.put("bundleData", str);
        localJSONObject.put("itemType", parama.dUm);
        if (parama.path != null) {
          continue;
        }
        str = "";
        localJSONObject.put("path", str);
        localJSONObject.put("intdata", parama.dUn);
        localJSONObject.put("showShare", parama.dUo);
        if (parama.field_favProto != null) {
          continue;
        }
        str = "";
        localJSONObject.put("field_favProto", str);
        if (parama.dUp != null) {
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
      str = parama.dUg;
      continue;
      str = parama.dUi;
      continue;
      str = parama.dUj;
      continue;
      str = bn(parama.dUl);
      continue;
      str = parama.path;
      continue;
      str = Base64.encodeToString(parama.field_favProto.toByteArray(), 0);
      continue;
      parama = Base64.encodeToString(parama.dUp.toByteArray(), 0);
    }
  }
  
  public static String a(pa.a parama)
  {
    AppMethodBeat.i(30275);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("msgId", parama.msgId);
        if (parama.dVc != null) {
          continue;
        }
        str = "";
        localJSONObject.put("noteXmlStr", str);
        localJSONObject.put("showShare", parama.dUo);
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
      str = parama.dVc;
    }
  }
  
  public static void a(q paramq)
  {
    AppMethodBeat.i(30272);
    if (paramq.JHR)
    {
      if (paramq.tcb) {
        h.CyF.a(14789, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        Log.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: true");
        localObject = new j();
        ((j)localObject).JGY = b(paramq);
        ((j)localObject).JGZ = 3;
        c.gjz().JGL = ((d)localObject);
        localand = new and();
        localand.scene = 8;
        ((j)localObject).a(paramq.JHV, Long.valueOf(paramq.JHT), true, MMApplicationContext.getContext(), paramq.JHW, paramq.JHX, localand, null);
        AppMethodBeat.o(30272);
        return;
        h.CyF.a(14789, new Object[] { Integer.valueOf(2) });
      }
    }
    h.CyF.a(14789, new Object[] { Integer.valueOf(1) });
    Log.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: false");
    Object localObject = new com.tencent.mm.plugin.wenote.model.g();
    ((com.tencent.mm.plugin.wenote.model.g)localObject).JGY = b(paramq);
    ((com.tencent.mm.plugin.wenote.model.g)localObject).JGZ = 3;
    c.gjz().JGL = ((d)localObject);
    and localand = new and();
    localand.scene = 8;
    ((com.tencent.mm.plugin.wenote.model.g)localObject).a(paramq.JHS, MMApplicationContext.getContext(), Boolean.TRUE, paramq.JHW, paramq.JHX, localand, null, null);
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
        localJSONObject.put("topIsOpenFromSession", paramq.JHR);
        localJSONObject.put("topLocalId", paramq.JHS);
        localJSONObject.put("topMsgId", paramq.JHT);
        localJSONObject.put("isChatRoom", paramq.tcb);
        if (paramq.JHU != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topTitle", str);
        if (paramq.JHV != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topNoteXml", str);
        localJSONObject.put("topLastPosition", paramq.JHW);
        localJSONObject.put("topLastOffset", paramq.JHX);
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
      str = paramq.JHU;
      continue;
      str = paramq.JHV;
    }
  }
  
  public static void bCE()
  {
    AppMethodBeat.i(30273);
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a(3, lqt);
    }
    AppMethodBeat.o(30273);
  }
  
  public static void bCF()
  {
    AppMethodBeat.i(30274);
    if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b(3, lqt);
    }
    AppMethodBeat.o(30274);
  }
  
  private static pa.a bbK(String paramString)
  {
    AppMethodBeat.i(30276);
    try
    {
      paramString = new i(paramString);
      pa.a locala = new pa.a();
      locala.msgId = paramString.getLong("msgId");
      locala.dVc = paramString.getString("noteXmlStr");
      locala.dUo = paramString.getBoolean("showShare");
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
  
  private static oc.a bbL(String paramString)
  {
    AppMethodBeat.i(30278);
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
      if (str.equals("")) {}
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
  
  private static Bundle bbM(String paramString)
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
  
  private static q bbN(String paramString)
  {
    AppMethodBeat.i(30282);
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
  
  private static String bn(Bundle paramBundle)
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
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(30268);
    super.G(paramInt, paramString);
    ciw().hDa = 5;
    ciw().oWx = 6;
    ciw().iNV = "";
    cit();
    AppMethodBeat.o(30268);
  }
  
  public final boolean aGg()
  {
    AppMethodBeat.i(30267);
    boolean bool = this.oXA.aGg();
    AppMethodBeat.o(30267);
    return bool;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(30271);
    super.aGi();
    this.oXA.hb(false);
    AppMethodBeat.o(30271);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(30270);
    super.bCB();
    AppMethodBeat.o(30270);
  }
  
  public final boolean bCG()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.a
 * JD-Core Version:    0.7.0.1
 */