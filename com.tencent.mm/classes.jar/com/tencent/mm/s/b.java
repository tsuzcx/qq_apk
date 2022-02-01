package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.api.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements d
{
  public final int adS()
  {
    return 10002;
  }
  
  public final int adT()
  {
    return 0;
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(114099);
    parama = ((s)g.ad(s.class)).getSysCmdMsgExtension().b(parama);
    AppMethodBeat.o(114099);
    return parama;
  }
  
  public final void b(e.c paramc)
  {
    AppMethodBeat.i(114100);
    Object localObject;
    if ((paramc != null) && ((paramc.hQV instanceof h)))
    {
      localObject = ((h)paramc.hQV).field_businessInfo;
      if ((localObject == null) || (((qw)localObject).GeX == null)) {}
    }
    try
    {
      localObject = ((qw)localObject).GeX.fjO();
      ae.i("FunctionMsg.NewXmlMsgExtension", "bussinessInfo:%s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      paramc.hQX = ((JSONObject)localObject).optString("msgid");
      paramc.hQW = ((JSONObject)localObject).optString("msgtype");
      label93:
      ((s)g.ad(s.class)).getSysCmdMsgExtension().b(paramc);
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