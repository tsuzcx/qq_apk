package com.tencent.mm.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.api.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements d
{
  public final int adG()
  {
    return 10002;
  }
  
  public final int adH()
  {
    return 0;
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(114099);
    parama = ((r)g.ad(r.class)).getSysCmdMsgExtension().b(parama);
    AppMethodBeat.o(114099);
    return parama;
  }
  
  public final void b(e.c paramc)
  {
    AppMethodBeat.i(114100);
    Object localObject;
    if ((paramc != null) && ((paramc.hOc instanceof h)))
    {
      localObject = ((h)paramc.hOc).field_businessInfo;
      if ((localObject == null) || (((qu)localObject).FMy == null)) {}
    }
    try
    {
      localObject = ((qu)localObject).FMy.ffY();
      ad.i("FunctionMsg.NewXmlMsgExtension", "bussinessInfo:%s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      paramc.hOe = ((JSONObject)localObject).optString("msgid");
      paramc.hOd = ((JSONObject)localObject).optString("msgtype");
      label93:
      ((r)g.ad(r.class)).getSysCmdMsgExtension().b(paramc);
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
 * Qualified Name:     com.tencent.mm.t.b
 * JD-Core Version:    0.7.0.1
 */