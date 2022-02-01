package com.tencent.mm.plugin.textstatus.third;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/ExtJumpInfoHandler$FinderJumpInfoUpdater;", "Lcom/tencent/mm/plugin/textstatus/third/ExtJumpInfoHandler$JumpInfoUpdater;", "()V", "update", "", "reqInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "callback", "Lkotlin/Function0;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  implements a.b
{
  public static final a Tux;
  
  static
  {
    AppMethodBeat.i(290182);
    Tux = new a();
    AppMethodBeat.o(290182);
  }
  
  private static final void a(long paramLong, String paramString, a parama, TextStatusJumpInfo paramTextStatusJumpInfo, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(290173);
    s.u(parama, "$callback");
    s.u(paramTextStatusJumpInfo, "$reqInfo");
    Log.i("MicroMsg.TextStatus.ExtJumpInfoHandler", "[CgiGetFinderFeed] errType=" + paramInt1 + " errCode=" + paramInt2 + " feed_id=" + paramLong + " nonce_id:" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (!(paramObject instanceof FinderObject)) {
        break label127;
      }
    }
    label127:
    for (paramString = (FinderObject)paramObject;; paramString = null)
    {
      if (paramString != null)
      {
        paramString = paramString.toByteArray();
        paramTextStatusJumpInfo.busiBuf = Base64.encodeToString(paramString, 0, paramString.length, 0);
      }
      parama.invoke();
      AppMethodBeat.o(290173);
      return;
    }
  }
  
  public final void a(TextStatusJumpInfo paramTextStatusJumpInfo, a<ah> parama)
  {
    AppMethodBeat.i(290209);
    s.u(paramTextStatusJumpInfo, "reqInfo");
    s.u(parama, "callback");
    Object localObject = Base64.decode(paramTextStatusJumpInfo.keyBusiBuf, 0);
    av localav = new av();
    localav.parseFrom((byte[])localObject);
    long l = localav.Tqa;
    localObject = localav.mdD;
    ((cn)h.az(cn.class)).tryGetFinderObject(l, (String)localObject, 106, true, false, new a.a..ExternalSyntheticLambda0(l, (String)localObject, parama, paramTextStatusJumpInfo));
    AppMethodBeat.o(290209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.a.a
 * JD-Core Version:    0.7.0.1
 */