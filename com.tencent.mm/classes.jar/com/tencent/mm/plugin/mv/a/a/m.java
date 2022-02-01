package com.tencent.mm.plugin.mv.a.a;

import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "pageHashCode", "", "(I)V", "callbackNetSceneTimestamp", "", "createNetSceneTimestamp", "dispatchNetSceneTimestamp", "getPageHashCode", "()I", "dispatch", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "rr", "Lcom/tencent/mm/network/IReqResp;", "callback", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "cookie", "", "Companion", "plugin-mv_release"})
public abstract class m
  extends q
  implements com.tencent.mm.network.m
{
  private static final HashMap<Integer, n> UqH = new HashMap();
  public static final a UqI = new a((byte)0);
  public final int NoN;
  private long UqE;
  private long UqF;
  private long UqG;
  
  public m(int paramInt)
  {
    this.NoN = paramInt;
    this.UqE = cl.aWA();
    this.UqF = cl.aWA();
    this.UqG = cl.aWA();
  }
  
  public int dispatch(g paramg, s params, com.tencent.mm.network.m paramm)
  {
    this.UqF = cl.aWA();
    return super.dispatch(paramg, params, paramm);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    this.UqG = cl.aWA();
    ((Map)UqH).put(Integer.valueOf(getType()), new n(getType(), this.UqE, this.UqF, this.UqG));
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene$Companion;", "", "()V", "costObjList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneCostObj;", "Lkotlin/collections/HashMap;", "getCostObjList", "()Ljava/util/HashMap;", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.m
 * JD-Core Version:    0.7.0.1
 */