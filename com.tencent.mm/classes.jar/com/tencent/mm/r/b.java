package com.tencent.mm.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.g;
import com.tencent.mm.an.g.b;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.api.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements g
{
  public final void a(g.b paramb) {}
  
  public final int aAq()
  {
    return 10002;
  }
  
  public final long aAr()
  {
    return 0L;
  }
  
  public final void aAs() {}
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(114099);
    parama = ((v)h.ag(v.class)).getSysCmdMsgExtension().b(parama);
    AppMethodBeat.o(114099);
    return parama;
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(114100);
    Object localObject;
    if ((paramc != null) && ((paramc.lCk instanceof i)))
    {
      localObject = ((i)paramc.lCk).field_businessInfo;
      if ((localObject == null) || (((rq)localObject).Sax == null)) {}
    }
    try
    {
      localObject = ((rq)localObject).Sax.Ap();
      Log.i("FunctionMsg.NewXmlMsgExtension", "bussinessInfo:%s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      paramc.lCm = ((JSONObject)localObject).optString("msgid");
      paramc.lCl = ((JSONObject)localObject).optString("msgtype");
      label93:
      ((v)h.ag(v.class)).getSysCmdMsgExtension().b(paramc);
      AppMethodBeat.o(114100);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.b
 * JD-Core Version:    0.7.0.1
 */