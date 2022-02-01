package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/NetSceneAudioPanelGetFinderLikedList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getCount", "getLikedList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMegaVideoCount", "getRespLastBuffer", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-recordvideo_release"})
public final class j
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  public d rr;
  
  public j(b paramb)
  {
    AppMethodBeat.i(225330);
    this.TAG = "Finder.NetSceneAudioPanelGetFinderLikedList";
    d.a locala = new d.a();
    locala.vD(getType());
    auo localauo = new auo();
    localauo.SGM = 0L;
    localauo.lastBuffer = paramb;
    localauo.RLN = z.bdh();
    localauo.xcW = "";
    localauo.fEH = 0;
    paramb = new aqe();
    paramb.scene = 101;
    localauo.yjp = paramb;
    locala.c((a)localauo);
    locala.vD(getType());
    locala.d((a)new aup());
    locala.TW("/cgi-bin/micromsg-bin/findergetlikedlist");
    paramb = locala.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, " init:NetSceneAudioPanelGetFinderLikedList " + localauo.RLN);
    AppMethodBeat.o(225330);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(225314);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(225314);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225322);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(225322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.j
 * JD-Core Version:    0.7.0.1
 */