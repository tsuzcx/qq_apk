package com.tencent.mm.plugin.wenote.b;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.g.a.nj.a;
import com.tencent.mm.g.a.oh.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
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
  private static com.tencent.mm.plugin.ball.c.f kjw;
  private NoteEditorUI Eyt;
  
  static
  {
    AppMethodBeat.i(30284);
    kjw = new com.tencent.mm.plugin.ball.c.g()
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
    this.Eyt = paramNoteEditorUI;
  }
  
  public static String a(nj.a parama)
  {
    AppMethodBeat.i(30277);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", parama.type);
        if (parama.dBl != null) {
          continue;
        }
        str = "";
        localJSONObject.put("editorId", str);
        localJSONObject.put("field_localId", parama.field_localId);
        if (parama.dBn != null) {
          continue;
        }
        str = "";
        localJSONObject.put("insertJsonData", str);
        if (parama.dBo != null) {
          continue;
        }
        str = "";
        localJSONObject.put("exportJsonData", str);
        localJSONObject.put("isInsert", parama.dBp);
        if (parama.dBq != null) {
          continue;
        }
        str = "";
        localJSONObject.put("bundleData", str);
        localJSONObject.put("itemType", parama.dBr);
        if (parama.path != null) {
          continue;
        }
        str = "";
        localJSONObject.put("path", str);
        localJSONObject.put("intdata", parama.dBs);
        localJSONObject.put("showShare", parama.dBt);
        if (parama.field_favProto != null) {
          continue;
        }
        str = "";
        localJSONObject.put("field_favProto", str);
        if (parama.dBu != null) {
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
      str = parama.dBl;
      continue;
      str = parama.dBn;
      continue;
      str = parama.dBo;
      continue;
      str = ba(parama.dBq);
      continue;
      str = parama.path;
      continue;
      str = Base64.encodeToString(parama.field_favProto.toByteArray(), 0);
      continue;
      parama = Base64.encodeToString(parama.dBu.toByteArray(), 0);
    }
  }
  
  public static String a(oh.a parama)
  {
    AppMethodBeat.i(30275);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("msgId", parama.msgId);
        if (parama.dCi != null) {
          continue;
        }
        str = "";
        localJSONObject.put("noteXmlStr", str);
        localJSONObject.put("showShare", parama.dBt);
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
      str = parama.dCi;
    }
  }
  
  public static void a(q paramq)
  {
    AppMethodBeat.i(30272);
    if (paramq.EzI)
    {
      if (paramq.ruk) {
        com.tencent.mm.plugin.report.service.g.yhR.f(14789, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        ad.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: true");
        localObject = new j();
        ((j)localObject).EyQ = b(paramq);
        ((j)localObject).EyR = 3;
        com.tencent.mm.plugin.wenote.model.c.eWI().EyD = ((d)localObject);
        localakf = new akf();
        localakf.scene = 8;
        ((j)localObject).a(paramq.EzM, Long.valueOf(paramq.EzK), true, aj.getContext(), paramq.EzN, paramq.EzO, localakf);
        AppMethodBeat.o(30272);
        return;
        com.tencent.mm.plugin.report.service.g.yhR.f(14789, new Object[] { Integer.valueOf(2) });
      }
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(14789, new Object[] { Integer.valueOf(1) });
    ad.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: false");
    Object localObject = new com.tencent.mm.plugin.wenote.model.g();
    ((com.tencent.mm.plugin.wenote.model.g)localObject).EyQ = b(paramq);
    ((com.tencent.mm.plugin.wenote.model.g)localObject).EyR = 3;
    com.tencent.mm.plugin.wenote.model.c.eWI().EyD = ((d)localObject);
    akf localakf = new akf();
    localakf.scene = 8;
    ((com.tencent.mm.plugin.wenote.model.g)localObject).a(paramq.EzJ, aj.getContext(), Boolean.TRUE, paramq.EzN, paramq.EzO, localakf, null);
    AppMethodBeat.o(30272);
  }
  
  private static oh.a aJY(String paramString)
  {
    AppMethodBeat.i(30276);
    try
    {
      paramString = new i(paramString);
      oh.a locala = new oh.a();
      locala.msgId = paramString.getLong("msgId");
      locala.dCi = paramString.getString("noteXmlStr");
      locala.dBt = paramString.getBoolean("showShare");
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
  
  private static nj.a aJZ(String paramString)
  {
    AppMethodBeat.i(30278);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new nj.a();
      paramString.type = ((JSONObject)localObject).getInt("type");
      paramString.dBl = ((JSONObject)localObject).getString("editorId");
      paramString.field_localId = ((JSONObject)localObject).getLong("field_localId");
      paramString.dBn = ((JSONObject)localObject).getString("insertJsonData");
      paramString.dBo = ((JSONObject)localObject).getString("exportJsonData");
      paramString.dBp = ((JSONObject)localObject).getBoolean("isInsert");
      String str = ((JSONObject)localObject).getString("bundleData");
      if (str.equals("")) {}
      for (paramString.dBq = null;; paramString.dBq = aKa(str))
      {
        paramString.dBr = ((JSONObject)localObject).getInt("itemType");
        paramString.path = ((JSONObject)localObject).getString("path");
        paramString.dBs = ((JSONObject)localObject).getInt("intdata");
        paramString.dBt = ((JSONObject)localObject).getBoolean("showShare");
        paramString.field_favProto = new akd();
        str = ((JSONObject)localObject).getString("field_favProto");
        if (!bt.isNullOrNil(str)) {
          paramString.field_favProto.parseFrom(Base64.decode(str, 0));
        }
        paramString.dBu = new akf();
        localObject = ((JSONObject)localObject).getString("reportInfo");
        if (!bt.isNullOrNil((String)localObject)) {
          paramString.dBu.parseFrom(Base64.decode((String)localObject, 0));
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
  
  private static Bundle aKa(String paramString)
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
  
  private static q aKb(String paramString)
  {
    AppMethodBeat.i(30282);
    try
    {
      q localq = new q();
      paramString = new JSONObject(paramString);
      localq.EzI = paramString.getBoolean("topIsOpenFromSession");
      localq.EzJ = paramString.getLong("topLocalId");
      localq.EzK = paramString.getLong("topMsgId");
      localq.ruk = paramString.getBoolean("isChatRoom");
      localq.EzL = paramString.getString("topTitle");
      localq.EzM = paramString.getString("topNoteXml");
      localq.EzN = paramString.getInt("topLastPosition");
      localq.EzO = paramString.getInt("topLastOffset");
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
        localJSONObject.put("topIsOpenFromSession", paramq.EzI);
        localJSONObject.put("topLocalId", paramq.EzJ);
        localJSONObject.put("topMsgId", paramq.EzK);
        localJSONObject.put("isChatRoom", paramq.ruk);
        if (paramq.EzL != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topTitle", str);
        if (paramq.EzM != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topNoteXml", str);
        localJSONObject.put("topLastPosition", paramq.EzN);
        localJSONObject.put("topLastOffset", paramq.EzO);
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
      str = paramq.EzL;
      continue;
      str = paramq.EzM;
    }
  }
  
  private static String ba(Bundle paramBundle)
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
  
  public static void bgJ()
  {
    AppMethodBeat.i(30273);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(3, kjw);
    }
    AppMethodBeat.o(30273);
  }
  
  public static void bgK()
  {
    AppMethodBeat.i(30274);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(3, kjw);
    }
    AppMethodBeat.o(30274);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(30268);
    super.ac(paramInt, paramString);
    bKG().nGc = 5;
    bKG().nGb = 6;
    bKG().hPO = "";
    bKC();
    AppMethodBeat.o(30268);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(30271);
    super.bgD();
    this.nHb.gg(false);
    AppMethodBeat.o(30271);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(30270);
    super.bgE();
    AppMethodBeat.o(30270);
  }
  
  public final boolean bgI()
  {
    return true;
  }
  
  public final boolean bgz()
  {
    AppMethodBeat.i(30267);
    boolean bool = this.nHb.bgz();
    AppMethodBeat.o(30267);
    return bool;
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