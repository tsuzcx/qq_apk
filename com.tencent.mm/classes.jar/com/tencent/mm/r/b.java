package com.tencent.mm.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.api.i;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.ak.g
{
  public final int atA()
  {
    return 0;
  }
  
  public final int atz()
  {
    return 10002;
  }
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(114099);
    parama = ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b(parama);
    AppMethodBeat.o(114099);
    return parama;
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(114100);
    Object localObject;
    if ((paramc != null) && ((paramc.iMd instanceof i)))
    {
      localObject = ((i)paramc.iMd).field_businessInfo;
      if ((localObject == null) || (((rx)localObject).KZo == null)) {}
    }
    try
    {
      localObject = ((rx)localObject).KZo.yO();
      Log.i("FunctionMsg.NewXmlMsgExtension", "bussinessInfo:%s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      paramc.iMf = ((JSONObject)localObject).optString("msgid");
      paramc.iMe = ((JSONObject)localObject).optString("msgtype");
      label93:
      ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b(paramc);
      AppMethodBeat.o(114100);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.r.b
 * JD-Core Version:    0.7.0.1
 */