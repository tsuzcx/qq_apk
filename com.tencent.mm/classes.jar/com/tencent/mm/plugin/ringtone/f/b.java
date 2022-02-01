package com.tencent.mm.plugin.ringtone.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.a.h;
import com.tencent.mm.protocal.protobuf.a.k;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/model/GetFriendRingBackCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetFriendRingBackResponse;", "username", "", "isOutCall", "", "(Ljava/lang/String;Z)V", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<k>
{
  public b(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(272769);
    h localh = new h();
    localh.UserName = paramString;
    localh.acjb = paramBoolean;
    paramString = new c.a();
    paramString.otE = ((a)localh);
    paramString.otF = ((a)new k());
    paramString.otG = 0;
    paramString.respCmdId = 0;
    paramString.uri = "/cgi-bin/micromsg-bin/getfriendringback";
    paramString.funcId = 6619;
    c(paramString.bEF());
    AppMethodBeat.o(272769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.f.b
 * JD-Core Version:    0.7.0.1
 */