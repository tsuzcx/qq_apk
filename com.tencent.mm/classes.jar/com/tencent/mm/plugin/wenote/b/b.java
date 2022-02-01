package com.tencent.mm.plugin.wenote.b;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.g.a.ms.a;
import com.tencent.mm.g.a.nq.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f jpa;
  private NoteEditorUI BCq;
  
  static
  {
    AppMethodBeat.i(30284);
    jpa = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(30266);
        b.b(paramAnonymousBallInfo);
        AppMethodBeat.o(30266);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(30284);
  }
  
  public b(NoteEditorUI paramNoteEditorUI, a parama)
  {
    super(parama);
    this.BCq = paramNoteEditorUI;
  }
  
  public static String a(ms.a parama)
  {
    AppMethodBeat.i(30277);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", parama.type);
        if (parama.drN != null) {
          continue;
        }
        str = "";
        localJSONObject.put("editorId", str);
        localJSONObject.put("field_localId", parama.field_localId);
        if (parama.drP != null) {
          continue;
        }
        str = "";
        localJSONObject.put("insertJsonData", str);
        if (parama.drQ != null) {
          continue;
        }
        str = "";
        localJSONObject.put("exportJsonData", str);
        localJSONObject.put("isInsert", parama.drR);
        if (parama.drS != null) {
          continue;
        }
        str = "";
        localJSONObject.put("bundleData", str);
        localJSONObject.put("itemType", parama.drT);
        if (parama.path != null) {
          continue;
        }
        str = "";
        localJSONObject.put("path", str);
        localJSONObject.put("intdata", parama.drU);
        localJSONObject.put("showShare", parama.drV);
        if (parama.field_favProto != null) {
          continue;
        }
        str = "";
        localJSONObject.put("field_favProto", str);
        if (parama.drW != null) {
          continue;
        }
        parama = "";
        localJSONObject.put("reportInfo", parama);
      }
      catch (Exception parama)
      {
        String str;
        ad.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", parama, "eventToJson NotifyWNNoteOperationEvent", new Object[0]);
        continue;
      }
      parama = localJSONObject.toString();
      AppMethodBeat.o(30277);
      return parama;
      str = parama.drN;
      continue;
      str = parama.drP;
      continue;
      str = parama.drQ;
      continue;
      str = aR(parama.drS);
      continue;
      str = parama.path;
      continue;
      str = Base64.encodeToString(parama.field_favProto.toByteArray(), 0);
      continue;
      parama = Base64.encodeToString(parama.drW.toByteArray(), 0);
    }
  }
  
  public static String a(nq.a parama)
  {
    AppMethodBeat.i(30275);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("msgId", parama.msgId);
        if (parama.dsL != null) {
          continue;
        }
        str = "";
        localJSONObject.put("noteXmlStr", str);
        localJSONObject.put("showShare", parama.drV);
        localJSONObject.put("scene", parama.scene);
      }
      catch (Exception parama)
      {
        String str;
        ad.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", parama, "eventToJson OpenNoteFromSessionEvent", new Object[0]);
        continue;
      }
      parama = localJSONObject.toString();
      AppMethodBeat.o(30275);
      return parama;
      str = parama.dsL;
    }
  }
  
  public static void a(q paramq)
  {
    AppMethodBeat.i(30272);
    if (paramq.BDF)
    {
      if (paramq.qbC) {
        h.vKh.f(14789, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        ad.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: true");
        localObject = new j();
        ((j)localObject).BCN = b(paramq);
        ((j)localObject).BCO = 3;
        com.tencent.mm.plugin.wenote.model.c.esw().BCA = ((d)localObject);
        localagq = new agq();
        localagq.scene = 8;
        ((j)localObject).a(paramq.BDJ, Long.valueOf(paramq.BDH), true, aj.getContext(), paramq.BDK, paramq.BDL, localagq);
        AppMethodBeat.o(30272);
        return;
        h.vKh.f(14789, new Object[] { Integer.valueOf(2) });
      }
    }
    h.vKh.f(14789, new Object[] { Integer.valueOf(1) });
    ad.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: false");
    Object localObject = new com.tencent.mm.plugin.wenote.model.g();
    ((com.tencent.mm.plugin.wenote.model.g)localObject).BCN = b(paramq);
    ((com.tencent.mm.plugin.wenote.model.g)localObject).BCO = 3;
    com.tencent.mm.plugin.wenote.model.c.esw().BCA = ((d)localObject);
    agq localagq = new agq();
    localagq.scene = 8;
    ((com.tencent.mm.plugin.wenote.model.g)localObject).a(paramq.BDG, aj.getContext(), Boolean.TRUE, paramq.BDK, paramq.BDL, localagq, null);
    AppMethodBeat.o(30272);
  }
  
  private static String aR(Bundle paramBundle)
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
      ad.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramBundle, "bundleToJson", new Object[0]);
      AppMethodBeat.o(30279);
      return null;
    }
    AppMethodBeat.o(30279);
    return paramBundle;
  }
  
  public static void aWh()
  {
    AppMethodBeat.i(30273);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(3, jpa);
    }
    AppMethodBeat.o(30273);
  }
  
  public static void aWi()
  {
    AppMethodBeat.i(30274);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(3, jpa);
    }
    AppMethodBeat.o(30274);
  }
  
  private static nq.a azh(String paramString)
  {
    AppMethodBeat.i(30276);
    try
    {
      paramString = new i(paramString);
      nq.a locala = new nq.a();
      locala.msgId = paramString.getLong("msgId");
      locala.dsL = paramString.getString("noteXmlStr");
      locala.drV = paramString.getBoolean("showShare");
      locala.scene = paramString.getInt("scene");
      locala.context = aj.getContext();
      AppMethodBeat.o(30276);
      return locala;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
      AppMethodBeat.o(30276);
    }
    return null;
  }
  
  private static ms.a azi(String paramString)
  {
    AppMethodBeat.i(30278);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new ms.a();
      paramString.type = ((JSONObject)localObject).getInt("type");
      paramString.drN = ((JSONObject)localObject).getString("editorId");
      paramString.field_localId = ((JSONObject)localObject).getLong("field_localId");
      paramString.drP = ((JSONObject)localObject).getString("insertJsonData");
      paramString.drQ = ((JSONObject)localObject).getString("exportJsonData");
      paramString.drR = ((JSONObject)localObject).getBoolean("isInsert");
      String str = ((JSONObject)localObject).getString("bundleData");
      if (str.equals("")) {}
      for (paramString.drS = null;; paramString.drS = azj(str))
      {
        paramString.drT = ((JSONObject)localObject).getInt("itemType");
        paramString.path = ((JSONObject)localObject).getString("path");
        paramString.drU = ((JSONObject)localObject).getInt("intdata");
        paramString.drV = ((JSONObject)localObject).getBoolean("showShare");
        paramString.field_favProto = new ago();
        str = ((JSONObject)localObject).getString("field_favProto");
        if (!bt.isNullOrNil(str)) {
          paramString.field_favProto.parseFrom(Base64.decode(str, 0));
        }
        paramString.drW = new agq();
        localObject = ((JSONObject)localObject).getString("reportInfo");
        if (!bt.isNullOrNil((String)localObject)) {
          paramString.drW.parseFrom(Base64.decode((String)localObject, 0));
        }
        paramString.context = aj.getContext();
        AppMethodBeat.o(30278);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
      AppMethodBeat.o(30278);
    }
  }
  
  private static Bundle azj(String paramString)
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
      ad.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "jsonToBundle", new Object[0]);
      AppMethodBeat.o(30280);
      return null;
    }
    return localBundle;
  }
  
  private static q azk(String paramString)
  {
    AppMethodBeat.i(30282);
    try
    {
      q localq = new q();
      paramString = new JSONObject(paramString);
      localq.BDF = paramString.getBoolean("topIsOpenFromSession");
      localq.BDG = paramString.getLong("topLocalId");
      localq.BDH = paramString.getLong("topMsgId");
      localq.qbC = paramString.getBoolean("isChatRoom");
      localq.BDI = paramString.getString("topTitle");
      localq.BDJ = paramString.getString("topNoteXml");
      localq.BDK = paramString.getInt("topLastPosition");
      localq.BDL = paramString.getInt("topLastOffset");
      AppMethodBeat.o(30282);
      return localq;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parseWNNoteKeepTopItem", new Object[0]);
      AppMethodBeat.o(30282);
    }
    return null;
  }
  
  private static String b(q paramq)
  {
    AppMethodBeat.i(30281);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("topIsOpenFromSession", paramq.BDF);
        localJSONObject.put("topLocalId", paramq.BDG);
        localJSONObject.put("topMsgId", paramq.BDH);
        localJSONObject.put("isChatRoom", paramq.qbC);
        if (paramq.BDI != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topTitle", str);
        if (paramq.BDJ != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topNoteXml", str);
        localJSONObject.put("topLastPosition", paramq.BDK);
        localJSONObject.put("topLastOffset", paramq.BDL);
      }
      catch (Exception paramq)
      {
        String str;
        ad.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramq, "topItemToJson", new Object[0]);
        continue;
      }
      paramq = localJSONObject.toString();
      AppMethodBeat.o(30281);
      return paramq;
      str = paramq.BDI;
      continue;
      str = paramq.BDJ;
    }
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(30268);
    super.Z(paramInt, paramString);
    bzz().mDz = 5;
    bzz().mDy = 6;
    bzz().gWU = "";
    bzv();
    AppMethodBeat.o(30268);
  }
  
  public final boolean aVX()
  {
    AppMethodBeat.i(30267);
    boolean bool = this.mEA.aVX();
    AppMethodBeat.o(30267);
    return bool;
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(30271);
    super.aWb();
    this.mEA.fF(false);
    AppMethodBeat.o(30271);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(30270);
    super.aWc();
    AppMethodBeat.o(30270);
  }
  
  public final boolean aWg()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.b
 * JD-Core Version:    0.7.0.1
 */