package com.tencent.mm.plugin.sns.storage.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.protocal.protobuf.fek;
import com.tencent.mm.protocal.protobuf.fel;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/cover/cgi/GetSnsObjectDetailCgi;", "Lcom/tencent/mm/plugin/sns/storage/cover/cgi/SnsCgi;", "Lcom/tencent/mm/protocal/protobuf/SnsObjectDetailResponse;", "objId", "", "(J)V", "TAG", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<fel>
{
  private final String TAG;
  
  public a(long paramLong)
  {
    AppMethodBeat.i(306689);
    this.TAG = "MicroMsg.GetSnsObjectDetailCgi";
    c.a locala = new c.a();
    fek localfek = new fek();
    localfek.Id = paramLong;
    ah localah = ah.aiuX;
    locala.otE = ((com.tencent.mm.bx.a)localfek);
    locala.otF = ((com.tencent.mm.bx.a)new fel());
    locala.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
    locala.funcId = 210;
    locala.otG = 101;
    locala.respCmdId = 1000000101;
    c(locala.bEF());
    Log.i(this.TAG, s.X("req snsId ", t.uA(paramLong)));
    AppMethodBeat.o(306689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a.a.a
 * JD-Core Version:    0.7.0.1
 */