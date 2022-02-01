package com.tencent.mm.plugin.wenote.b;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.nb.a;
import com.tencent.mm.g.a.nz.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f jPm;
  private NoteEditorUI CUw;
  
  static
  {
    AppMethodBeat.i(30284);
    jPm = new com.tencent.mm.plugin.ball.c.g()
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
    this.CUw = paramNoteEditorUI;
  }
  
  public static String a(nb.a parama)
  {
    AppMethodBeat.i(30277);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", parama.type);
        if (parama.dpy != null) {
          continue;
        }
        str = "";
        localJSONObject.put("editorId", str);
        localJSONObject.put("field_localId", parama.field_localId);
        if (parama.dpA != null) {
          continue;
        }
        str = "";
        localJSONObject.put("insertJsonData", str);
        if (parama.dpB != null) {
          continue;
        }
        str = "";
        localJSONObject.put("exportJsonData", str);
        localJSONObject.put("isInsert", parama.dpC);
        if (parama.dpD != null) {
          continue;
        }
        str = "";
        localJSONObject.put("bundleData", str);
        localJSONObject.put("itemType", parama.dpE);
        if (parama.path != null) {
          continue;
        }
        str = "";
        localJSONObject.put("path", str);
        localJSONObject.put("intdata", parama.dpF);
        localJSONObject.put("showShare", parama.dpG);
        if (parama.field_favProto != null) {
          continue;
        }
        str = "";
        localJSONObject.put("field_favProto", str);
        if (parama.dpH != null) {
          continue;
        }
        parama = "";
        localJSONObject.put("reportInfo", parama);
      }
      catch (Exception parama)
      {
        String str;
        ac.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", parama, "eventToJson NotifyWNNoteOperationEvent", new Object[0]);
        continue;
      }
      parama = localJSONObject.toString();
      AppMethodBeat.o(30277);
      return parama;
      str = parama.dpy;
      continue;
      str = parama.dpA;
      continue;
      str = parama.dpB;
      continue;
      str = aV(parama.dpD);
      continue;
      str = parama.path;
      continue;
      str = Base64.encodeToString(parama.field_favProto.toByteArray(), 0);
      continue;
      parama = Base64.encodeToString(parama.dpH.toByteArray(), 0);
    }
  }
  
  public static String a(nz.a parama)
  {
    AppMethodBeat.i(30275);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("msgId", parama.msgId);
        if (parama.dqv != null) {
          continue;
        }
        str = "";
        localJSONObject.put("noteXmlStr", str);
        localJSONObject.put("showShare", parama.dpG);
        localJSONObject.put("scene", parama.scene);
      }
      catch (Exception parama)
      {
        String str;
        ac.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", parama, "eventToJson OpenNoteFromSessionEvent", new Object[0]);
        continue;
      }
      parama = localJSONObject.toString();
      AppMethodBeat.o(30275);
      return parama;
      str = parama.dqv;
    }
  }
  
  public static void a(q paramq)
  {
    AppMethodBeat.i(30272);
    if (paramq.CVL)
    {
      if (paramq.qKi) {
        h.wUl.f(14789, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        ac.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: true");
        localObject = new j();
        ((j)localObject).CUT = b(paramq);
        ((j)localObject).CUU = 3;
        com.tencent.mm.plugin.wenote.model.c.eHP().CUG = ((d)localObject);
        localahp = new ahp();
        localahp.scene = 8;
        ((j)localObject).a(paramq.CVP, Long.valueOf(paramq.CVN), true, ai.getContext(), paramq.CVQ, paramq.CVR, localahp);
        AppMethodBeat.o(30272);
        return;
        h.wUl.f(14789, new Object[] { Integer.valueOf(2) });
      }
    }
    h.wUl.f(14789, new Object[] { Integer.valueOf(1) });
    ac.i("MicroMsg.Fav.NoteFloatBallHelper", "isOpenFromSession: false");
    Object localObject = new com.tencent.mm.plugin.wenote.model.g();
    ((com.tencent.mm.plugin.wenote.model.g)localObject).CUT = b(paramq);
    ((com.tencent.mm.plugin.wenote.model.g)localObject).CUU = 3;
    com.tencent.mm.plugin.wenote.model.c.eHP().CUG = ((d)localObject);
    ahp localahp = new ahp();
    localahp.scene = 8;
    ((com.tencent.mm.plugin.wenote.model.g)localObject).a(paramq.CVM, ai.getContext(), Boolean.TRUE, paramq.CVQ, paramq.CVR, localahp, null);
    AppMethodBeat.o(30272);
  }
  
  private static Bundle aEA(String paramString)
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
      ac.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "jsonToBundle", new Object[0]);
      AppMethodBeat.o(30280);
      return null;
    }
    return localBundle;
  }
  
  private static q aEB(String paramString)
  {
    AppMethodBeat.i(30282);
    try
    {
      q localq = new q();
      paramString = new JSONObject(paramString);
      localq.CVL = paramString.getBoolean("topIsOpenFromSession");
      localq.CVM = paramString.getLong("topLocalId");
      localq.CVN = paramString.getLong("topMsgId");
      localq.qKi = paramString.getBoolean("isChatRoom");
      localq.CVO = paramString.getString("topTitle");
      localq.CVP = paramString.getString("topNoteXml");
      localq.CVQ = paramString.getInt("topLastPosition");
      localq.CVR = paramString.getInt("topLastOffset");
      AppMethodBeat.o(30282);
      return localq;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parseWNNoteKeepTopItem", new Object[0]);
      AppMethodBeat.o(30282);
    }
    return null;
  }
  
  private static nz.a aEy(String paramString)
  {
    AppMethodBeat.i(30276);
    try
    {
      paramString = new i(paramString);
      nz.a locala = new nz.a();
      locala.msgId = paramString.getLong("msgId");
      locala.dqv = paramString.getString("noteXmlStr");
      locala.dpG = paramString.getBoolean("showShare");
      locala.scene = paramString.getInt("scene");
      locala.context = ai.getContext();
      AppMethodBeat.o(30276);
      return locala;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parseOpenNoteFromSessionEventData", new Object[0]);
      AppMethodBeat.o(30276);
    }
    return null;
  }
  
  private static nb.a aEz(String paramString)
  {
    AppMethodBeat.i(30278);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new nb.a();
      paramString.type = ((JSONObject)localObject).getInt("type");
      paramString.dpy = ((JSONObject)localObject).getString("editorId");
      paramString.field_localId = ((JSONObject)localObject).getLong("field_localId");
      paramString.dpA = ((JSONObject)localObject).getString("insertJsonData");
      paramString.dpB = ((JSONObject)localObject).getString("exportJsonData");
      paramString.dpC = ((JSONObject)localObject).getBoolean("isInsert");
      String str = ((JSONObject)localObject).getString("bundleData");
      if (str.equals("")) {}
      for (paramString.dpD = null;; paramString.dpD = aEA(str))
      {
        paramString.dpE = ((JSONObject)localObject).getInt("itemType");
        paramString.path = ((JSONObject)localObject).getString("path");
        paramString.dpF = ((JSONObject)localObject).getInt("intdata");
        paramString.dpG = ((JSONObject)localObject).getBoolean("showShare");
        paramString.field_favProto = new ahn();
        str = ((JSONObject)localObject).getString("field_favProto");
        if (!bs.isNullOrNil(str)) {
          paramString.field_favProto.parseFrom(Base64.decode(str, 0));
        }
        paramString.dpH = new ahp();
        localObject = ((JSONObject)localObject).getString("reportInfo");
        if (!bs.isNullOrNil((String)localObject)) {
          paramString.dpH.parseFrom(Base64.decode((String)localObject, 0));
        }
        paramString.context = ai.getContext();
        AppMethodBeat.o(30278);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramString, "parse NotifyWNNoteOperationEvent", new Object[0]);
      AppMethodBeat.o(30278);
    }
  }
  
  private static String aV(Bundle paramBundle)
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
      ac.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramBundle, "bundleToJson", new Object[0]);
      AppMethodBeat.o(30279);
      return null;
    }
    AppMethodBeat.o(30279);
    return paramBundle;
  }
  
  private static String b(q paramq)
  {
    AppMethodBeat.i(30281);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("topIsOpenFromSession", paramq.CVL);
        localJSONObject.put("topLocalId", paramq.CVM);
        localJSONObject.put("topMsgId", paramq.CVN);
        localJSONObject.put("isChatRoom", paramq.qKi);
        if (paramq.CVO != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topTitle", str);
        if (paramq.CVP != null) {
          continue;
        }
        str = "";
        localJSONObject.put("topNoteXml", str);
        localJSONObject.put("topLastPosition", paramq.CVQ);
        localJSONObject.put("topLastOffset", paramq.CVR);
      }
      catch (Exception paramq)
      {
        String str;
        ac.printErrStackTrace("MicroMsg.Fav.NoteFloatBallHelper", paramq, "topItemToJson", new Object[0]);
        continue;
      }
      paramq = localJSONObject.toString();
      AppMethodBeat.o(30281);
      return paramq;
      str = paramq.CVO;
      continue;
      str = paramq.CVP;
    }
  }
  
  public static void bdf()
  {
    AppMethodBeat.i(30273);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(3, jPm);
    }
    AppMethodBeat.o(30273);
  }
  
  public static void bdg()
  {
    AppMethodBeat.i(30274);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(3, jPm);
    }
    AppMethodBeat.o(30274);
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(30268);
    super.aa(paramInt, paramString);
    bGv().nfG = 5;
    bGv().nfF = 6;
    bGv().hxt = "";
    bGr();
    AppMethodBeat.o(30268);
  }
  
  public final boolean bcV()
  {
    AppMethodBeat.i(30267);
    boolean bool = this.ngF.bcV();
    AppMethodBeat.o(30267);
    return bool;
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(30271);
    super.bcZ();
    this.ngF.gb(false);
    AppMethodBeat.o(30271);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(30270);
    super.bda();
    AppMethodBeat.o(30270);
  }
  
  public final boolean bde()
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
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.b
 * JD-Core Version:    0.7.0.1
 */