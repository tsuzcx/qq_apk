package com.tencent.mm.plugin.wenote.a;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.a.ql.a;
import com.tencent.mm.autogen.a.rk.a;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
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
  private static com.tencent.mm.plugin.ball.c.e roL;
  private NoteEditorUI Xzr;
  
  static
  {
    AppMethodBeat.i(30284);
    roL = new b.1();
    AppMethodBeat.o(30284);
  }
  
  public b(NoteEditorUI paramNoteEditorUI, a parama)
  {
    super(parama);
    this.Xzr = paramNoteEditorUI;
  }
  
  public static String a(ql.a parama)
  {
    AppMethodBeat.i(30277);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", parama.type);
        if (parama.hTA != null) {
          continue;
        }
        str = "";
        localJSONObject.put("editorId", str);
        localJSONObject.put("field_localId", parama.field_localId);
        if (parama.hTC != null) {
          continue;
        }
        str = "";
        localJSONObject.put("insertJsonData", str);
        if (parama.hTD != null) {
          continue;
        }
        str = "";
        localJSONObject.put("exportJsonData", str);
        localJSONObject.put("isInsert", parama.hTE);
        if (parama.hTF != null) {
          continue;
        }
        str = "";
        localJSONObject.put("bundleData", str);
        localJSONObject.put("itemType", parama.itemType);
        if (parama.path != null) {
          continue;
        }
        str = "";
        localJSONObject.put("path", str);
        localJSONObject.put("intdata", parama.hTG);
        localJSONObject.put("showShare", parama.hTH);
        if (parama.field_favProto != null) {
          continue;
        }
        str = "";
        localJSONObject.put("field_favProto", str);
        if (parama.hTI != null) {
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
      str = parama.hTA;
      continue;
      str = parama.hTC;
      continue;
      str = parama.hTD;
      continue;
      str = bR(parama.hTF);
      continue;
      str = parama.path;
      continue;
      str = Base64.encodeToString(parama.field_favProto.toByteArray(), 0);
      continue;
      parama = Base64.encodeToString(parama.hTI.toByteArray(), 0);
    }
  }
  
  public static String a(rk.a parama)
  {
    AppMethodBeat.i(30275);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("msgId", parama.msgId);
        if (parama.hUx != null) {
          continue;
        }
        str = "";
        localJSONObject.put("noteXmlStr", str);
        localJSONObject.put("showShare", parama.hTH);
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
      str = parama.hUx;
    }
  }
  
  public static void a(q paramq)
  {
    AppMethodBeat.i(30272);
    if (paramq.XAH)
    {
      if (paramq.Aeu) {
        com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        Log.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: true");
        localObject = new j();
        ((j)localObject).XzO = b(paramq);
        ((j)localObject).XzP = 3;
        c.iDT().XzB = ((d)localObject);
        localarx = new arx();
        localarx.scene = 8;
        ((j)localObject).a(paramq.XAL, Long.valueOf(paramq.XAJ), true, MMApplicationContext.getContext(), paramq.XAM, paramq.XAN, localarx, null);
        AppMethodBeat.o(30272);
        return;
        com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(2) });
      }
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(14789, new Object[] { Integer.valueOf(1) });
    Log.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: false");
    Object localObject = new g();
    ((g)localObject).XzO = b(paramq);
    ((g)localObject).XzP = 3;
    c.iDT().XzB = ((d)localObject);
    arx localarx = new arx();
    localarx.scene = 8;
    ((g)localObject).a(paramq.XAI, MMApplicationContext.getContext(), Boolean.TRUE, paramq.XAM, paramq.XAN, localarx, null, null);
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
        localJSONObject.put("topIsOpenFromSession", paramq.XAH);
        localJSONObject.put("topLocalId", paramq.XAI);
        localJSONObject.put("topMsgId", paramq.XAJ);
        localJSONObject.put("isChatRoom", paramq.Aeu);
        if (paramq.XAK != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topTitle", str);
        if (paramq.XAL != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topNoteXml", str);
        localJSONObject.put("topLastPosition", paramq.XAM);
        localJSONObject.put("topLastOffset", paramq.XAN);
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
      str = paramq.XAK;
      continue;
      str = paramq.XAL;
    }
  }
  
  private static String bR(Bundle paramBundle)
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
  
  private static Bundle bnA(String paramString)
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
  
  private static q bnB(String paramString)
  {
    AppMethodBeat.i(30282);
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
  
  private static rk.a bny(String paramString)
  {
    AppMethodBeat.i(30276);
    try
    {
      paramString = new i(paramString);
      rk.a locala = new rk.a();
      locala.msgId = paramString.getLong("msgId");
      locala.hUx = paramString.getString("noteXmlStr");
      locala.hTH = paramString.getBoolean("showShare");
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
  
  private static ql.a bnz(String paramString)
  {
    AppMethodBeat.i(30278);
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
      if (str.equals("")) {}
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
  
  public static void con()
  {
    AppMethodBeat.i(30273);
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(3, roL);
    }
    AppMethodBeat.o(30273);
  }
  
  public static void coo()
  {
    AppMethodBeat.i(30274);
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(3, roL);
    }
    AppMethodBeat.o(30274);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(30268);
    super.J(paramInt, paramString);
    cYv().mUU = 5;
    cYv().vjN = 6;
    cYv().ovT = "";
    cYr();
    AppMethodBeat.o(30268);
  }
  
  public final boolean bhU()
  {
    AppMethodBeat.i(30267);
    boolean bool = this.vkT.bhU();
    AppMethodBeat.o(30267);
    return bool;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(30271);
    super.bhV();
    this.vkT.iR(false);
    AppMethodBeat.o(30271);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(30270);
    super.coj();
    AppMethodBeat.o(30270);
  }
  
  public final boolean cop()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.b
 * JD-Core Version:    0.7.0.1
 */