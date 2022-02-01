package com.tencent.mm.plugin.mv.model.a;

import com.tencent.mm.an.q;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "pageHashCode", "", "(I)V", "callbackNetSceneTimestamp", "", "createNetSceneTimestamp", "dispatchNetSceneTimestamp", "getPageHashCode", "()I", "dispatch", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "rr", "Lcom/tencent/mm/network/IReqResp;", "callback", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "cookie", "", "Companion", "plugin-mv_release"})
public abstract class a
  extends q
  implements m
{
  private static final HashMap<Integer, b> GcX = new HashMap();
  public static final a GcY = new a((byte)0);
  private long GcT;
  private long GcU;
  private long GcV;
  public final int GcW;
  
  public a(int paramInt)
  {
    this.GcW = paramInt;
    this.GcT = cm.bfE();
    this.GcU = cm.bfE();
    this.GcV = cm.bfE();
  }
  
  public int dispatch(g paramg, s params, m paramm)
  {
    this.GcU = cm.bfE();
    return super.dispatch(paramg, params, paramm);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    this.GcV = cm.bfE();
    ((Map)GcX).put(Integer.valueOf(getType()), new b(getType(), this.GcT, this.GcU, this.GcV));
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene$Companion;", "", "()V", "costObjList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneCostObj;", "Lkotlin/collections/HashMap;", "getCostObjList", "()Ljava/util/HashMap;", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.a
 * JD-Core Version:    0.7.0.1
 */