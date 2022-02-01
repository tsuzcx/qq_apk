package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.api.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements e
{
  public final int abd()
  {
    return 10002;
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(114099);
    parama = ((q)g.ad(q.class)).getSysCmdMsgExtension().b(parama);
    AppMethodBeat.o(114099);
    return parama;
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(114100);
    Object localObject;
    if ((paramc != null) && ((paramc.hvN instanceof h)))
    {
      localObject = ((h)paramc.hvN).field_businessInfo;
      if ((localObject == null) || (((pp)localObject).EfZ == null)) {}
    }
    try
    {
      localObject = ((pp)localObject).EfZ.eQU();
      ac.i("FunctionMsg.NewXmlMsgExtension", "bussinessInfo:%s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      paramc.hvP = ((JSONObject)localObject).optString("msgid");
      paramc.hvO = ((JSONObject)localObject).optString("msgtype");
      label93:
      ((q)g.ad(q.class)).getSysCmdMsgExtension().b(paramc);
      AppMethodBeat.o(114100);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.s.b
 * JD-Core Version:    0.7.0.1
 */