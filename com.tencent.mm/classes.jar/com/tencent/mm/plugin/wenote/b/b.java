package com.tencent.mm.plugin.wenote.b;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.nk.a;
import com.tencent.mm.g.a.oi.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f kmM;
  private NoteEditorUI EQP;
  
  static
  {
    AppMethodBeat.i(30284);
    kmM = new com.tencent.mm.plugin.ball.c.g()
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
    this.EQP = paramNoteEditorUI;
  }
  
  public static String a(nk.a parama)
  {
    AppMethodBeat.i(30277);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", parama.type);
        if (parama.dCq != null) {
          continue;
        }
        str = "";
        localJSONObject.put("editorId", str);
        localJSONObject.put("field_localId", parama.field_localId);
        if (parama.dCs != null) {
          continue;
        }
        str = "";
        localJSONObject.put("insertJsonData", str);
        if (parama.dCt != null) {
          continue;
        }
        str = "";
        localJSONObject.put("exportJsonData", str);
        localJSONObject.put("isInsert", parama.dCu);
        if (parama.dCv != null) {
          continue;
        }
        str = "";
        localJSONObject.put("bundleData", str);
        localJSONObject.put("itemType", parama.dCw);
        if (parama.path != null) {
          continue;
        }
        str = "";
        localJSONObject.put("path", str);
        localJSONObject.put("intdata", parama.dCx);
        localJSONObject.put("showShare", parama.dCy);
        if (parama.field_favProto != null) {
          continue;
        }
        str = "";
        localJSONObject.put("field_favProto", str);
        if (parama.dCz != null) {
          continue;
        }
        parama = "";
        localJSONObject.put("reportInfo", parama);
      }
      catch (Exception parama)
      {
        String str;
        ae.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", parama, "eventToJson NotifyWNNoteOperationEvent", new Object[0]);
        continue;
      }
      parama = localJSONObject.toString();
      AppMethodBeat.o(30277);
      return parama;
      str = parama.dCq;
      continue;
      str = parama.dCs;
      continue;
      str = parama.dCt;
      continue;
      str = bb(parama.dCv);
      continue;
      str = parama.path;
      continue;
      str = Base64.encodeToString(parama.field_favProto.toByteArray(), 0);
      continue;
      parama = Base64.encodeToString(parama.dCz.toByteArray(), 0);
    }
  }
  
  public static String a(oi.a parama)
  {
    AppMethodBeat.i(30275);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("msgId", parama.msgId);
        if (parama.dDn != null) {
          continue;
        }
        str = "";
        localJSONObject.put("noteXmlStr", str);
        localJSONObject.put("showShare", parama.dCy);
        localJSONObject.put("scene", parama.scene);
      }
      catch (Exception parama)
      {
        String str;
        ae.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", parama, "eventToJson OpenNoteFromSessionEvent", new Object[0]);
        continue;
      }
      parama = localJSONObject.toString();
      AppMethodBeat.o(30275);
      return parama;
      str = parama.dDn;
    }
  }
  
  public static void a(q paramq)
  {
    AppMethodBeat.i(30272);
    if (paramq.ESe)
    {
      if (paramq.rCw) {
        com.tencent.mm.plugin.report.service.g.yxI.f(14789, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        ae.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: true");
        localObject = new j();
        ((j)localObject).ERm = b(paramq);
        ((j)localObject).ERn = 3;
        com.tencent.mm.plugin.wenote.model.c.fau().EQZ = ((d)localObject);
        localakp = new akp();
        localakp.scene = 8;
        ((j)localObject).a(paramq.ESi, Long.valueOf(paramq.ESg), true, ak.getContext(), paramq.ESj, paramq.ESk, localakp);
        AppMethodBeat.o(30272);
        return;
        com.tencent.mm.plugin.report.service.g.yxI.f(14789, new Object[] { Integer.valueOf(2) });
      }
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(14789, new Object[] { Integer.valueOf(1) });
    ae.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: false");
    Object localObject = new com.tencent.mm.plugin.wenote.model.g();
    ((com.tencent.mm.plugin.wenote.model.g)localObject).ERm = b(paramq);
    ((com.tencent.mm.plugin.wenote.model.g)localObject).ERn = 3;
    com.tencent.mm.plugin.wenote.model.c.fau().EQZ = ((d)localObject);
    akp localakp = new akp();
    localakp.scene = 8;
    ((com.tencent.mm.plugin.wenote.model.g)localObject).a(paramq.ESf, ak.getContext(), Boolean.TRUE, paramq.ESj, paramq.ESk, localakp, null);
    AppMethodBeat.o(30272);
  }
  
  private static oi.a aLu(String paramString)
  {
    AppMethodBeat.i(30276);
    try
    {
      paramString = new i(paramString);
      oi.a locala = new oi.a();
      locala.msgId = paramString.getLong("msgId");
      locala.dDn = paramString.getString("noteXmlStr");
      locala.dCy = paramString.getBoolean("showShare");
      locala.scene = paramString.getInt("scene");
      locala.context = ak.getContext();
      AppMethodBeat.o(30276);
      return locala;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
      AppMethodBeat.o(30276);
    }
    return null;
  }
  
  private static nk.a aLv(String paramString)
  {
    AppMethodBeat.i(30278);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new nk.a();
      paramString.type = ((JSONObject)localObject).getInt("type");
      paramString.dCq = ((JSONObject)localObject).getString("editorId");
      paramString.field_localId = ((JSONObject)localObject).getLong("field_localId");
      paramString.dCs = ((JSONObject)localObject).getString("insertJsonData");
      paramString.dCt = ((JSONObject)localObject).getString("exportJsonData");
      paramString.dCu = ((JSONObject)localObject).getBoolean("isInsert");
      String str = ((JSONObject)localObject).getString("bundleData");
      if (str.equals("")) {}
      for (paramString.dCv = null;; paramString.dCv = aLw(str))
      {
        paramString.dCw = ((JSONObject)localObject).getInt("itemType");
        paramString.path = ((JSONObject)localObject).getString("path");
        paramString.dCx = ((JSONObject)localObject).getInt("intdata");
        paramString.dCy = ((JSONObject)localObject).getBoolean("showShare");
        paramString.field_favProto = new akn();
        str = ((JSONObject)localObject).getString("field_favProto");
        if (!bu.isNullOrNil(str)) {
          paramString.field_favProto.parseFrom(Base64.decode(str, 0));
        }
        paramString.dCz = new akp();
        localObject = ((JSONObject)localObject).getString("reportInfo");
        if (!bu.isNullOrNil((String)localObject)) {
          paramString.dCz.parseFrom(Base64.decode((String)localObject, 0));
        }
        paramString.context = ak.getContext();
        AppMethodBeat.o(30278);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
      AppMethodBeat.o(30278);
    }
  }
  
  private static Bundle aLw(String paramString)
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
      ae.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "jsonToBundle", new Object[0]);
      AppMethodBeat.o(30280);
      return null;
    }
    return localBundle;
  }
  
  private static q aLx(String paramString)
  {
    AppMethodBeat.i(30282);
    try
    {
      q localq = new q();
      paramString = new JSONObject(paramString);
      localq.ESe = paramString.getBoolean("topIsOpenFromSession");
      localq.ESf = paramString.getLong("topLocalId");
      localq.ESg = paramString.getLong("topMsgId");
      localq.rCw = paramString.getBoolean("isChatRoom");
      localq.ESh = paramString.getString("topTitle");
      localq.ESi = paramString.getString("topNoteXml");
      localq.ESj = paramString.getInt("topLastPosition");
      localq.ESk = paramString.getInt("topLastOffset");
      AppMethodBeat.o(30282);
      return localq;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parseWNNoteKeepTopItem", new Object[0]);
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
        localJSONObject.put("topIsOpenFromSession", paramq.ESe);
        localJSONObject.put("topLocalId", paramq.ESf);
        localJSONObject.put("topMsgId", paramq.ESg);
        localJSONObject.put("isChatRoom", paramq.rCw);
        if (paramq.ESh != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topTitle", str);
        if (paramq.ESi != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topNoteXml", str);
        localJSONObject.put("topLastPosition", paramq.ESj);
        localJSONObject.put("topLastOffset", paramq.ESk);
      }
      catch (Exception paramq)
      {
        String str;
        ae.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramq, "topItemToJson", new Object[0]);
        continue;
      }
      paramq = localJSONObject.toString();
      AppMethodBeat.o(30281);
      return paramq;
      str = paramq.ESh;
      continue;
      str = paramq.ESi;
    }
  }
  
  private static String bb(Bundle paramBundle)
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
      ae.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramBundle, "bundleToJson", new Object[0]);
      AppMethodBeat.o(30279);
      return null;
    }
    AppMethodBeat.o(30279);
    return paramBundle;
  }
  
  public static void bhr()
  {
    AppMethodBeat.i(30273);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(3, kmM);
    }
    AppMethodBeat.o(30273);
  }
  
  public static void bhs()
  {
    AppMethodBeat.i(30274);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(3, kmM);
    }
    AppMethodBeat.o(30274);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(30268);
    super.ac(paramInt, paramString);
    bLD().nLC = 5;
    bLD().nLB = 6;
    bLD().hSG = "";
    bLz();
    AppMethodBeat.o(30268);
  }
  
  public final boolean bhh()
  {
    AppMethodBeat.i(30267);
    boolean bool = this.nME.bhh();
    AppMethodBeat.o(30267);
    return bool;
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(30271);
    super.bhl();
    this.nME.ge(false);
    AppMethodBeat.o(30271);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(30270);
    super.bhm();
    AppMethodBeat.o(30270);
  }
  
  public final boolean bhq()
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