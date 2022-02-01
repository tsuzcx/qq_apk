package com.tencent.mm.plugin.mv.model.a;

import com.tencent.mm.am.p;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "pageHashCode", "", "(I)V", "callbackNetSceneTimestamp", "", "createNetSceneTimestamp", "dispatchNetSceneTimestamp", "getPageHashCode", "()I", "dispatch", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "rr", "Lcom/tencent/mm/network/IReqResp;", "callback", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "cookie", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends p
  implements m
{
  private static final HashMap<Integer, c> LYE = new HashMap();
  public static final a LYz = new a((byte)0);
  public final int LYA;
  private long LYB;
  private long LYC;
  private long LYD;
  
  public a(int paramInt)
  {
    this.LYA = paramInt;
    this.LYB = cn.bDw();
    this.LYC = cn.bDw();
    this.LYD = cn.bDw();
  }
  
  public int dispatch(g paramg, s params, m paramm)
  {
    this.LYC = cn.bDw();
    return super.dispatch(paramg, params, paramm);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    this.LYD = cn.bDw();
    ((Map)LYE).put(Integer.valueOf(getType()), new c(getType(), this.LYB, this.LYC, this.LYD));
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene$Companion;", "", "()V", "costObjList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneCostObj;", "Lkotlin/collections/HashMap;", "getCostObjList", "()Ljava/util/HashMap;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.a
 * JD-Core Version:    0.7.0.1
 */