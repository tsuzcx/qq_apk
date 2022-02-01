package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/NetSceneAudioPanelGetFinderLikedList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getCount", "getLikedList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMegaVideoCount", "getRespLastBuffer", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends p
  implements m
{
  private final String TAG;
  private h callback;
  public c rr;
  
  public j(b paramb)
  {
    AppMethodBeat.i(279631);
    this.TAG = "Finder.NetSceneAudioPanelGetFinderLikedList";
    c.a locala = new c.a();
    locala.funcId = getType();
    azg localazg = new azg();
    localazg.ZJD = 0L;
    localazg.lastBuffer = paramb;
    localazg.YIZ = z.bAW();
    localazg.ACm = "";
    localazg.hJx = 0;
    paramb = new atz();
    paramb.scene = 101;
    ah localah = ah.aiuX;
    localazg.CJv = paramb;
    locala.otE = ((a)localazg);
    locala.funcId = getType();
    locala.otF = ((a)new azh());
    locala.uri = "/cgi-bin/micromsg-bin/findergetlikedlist";
    paramb = locala.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, kotlin.g.b.s.X(" init:NetSceneAudioPanelGetFinderLikedList ", localazg.YIZ));
    AppMethodBeat.o(279631);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(279633);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(279633);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(279635);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(279635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.j
 * JD-Core Version:    0.7.0.1
 */