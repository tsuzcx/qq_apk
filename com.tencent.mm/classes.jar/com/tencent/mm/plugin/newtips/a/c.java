package com.tencent.mm.plugin.newtips.a;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class c
  extends q
  implements m
{
  private i callback;
  private String dUb;
  private d rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(184028);
    d.a locala = new d.a();
    locala.iLN = new dgf();
    locala.iLO = new dgg();
    locala.uri = "/cgi-bin/micromsg-bin/pushnewtips";
    locala.funcId = 597;
    this.rr = locala.aXF();
    ((dgf)this.rr.iLK.iLR).KSL = paramString;
    this.dUb = paramString;
    AppMethodBeat.o(184028);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(184030);
    Log.d("MicroMsg.NewTips.NetScenePushNewTips", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(184030);
    return i;
  }
  
  public final int getType()
  {
    return 597;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184029);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NewTips.NetScenePushNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(184029);
      return;
    }
    params = (dgg)((d)params).iLL.iLR;
    paramArrayOfByte = this.dUb;
    boolean bool = params.MKT;
    Log.i("MicroMsg.NewTips.NewTipsHelper", "setLocalNewTipsState() uniqueId:%s isReject:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool) });
    MultiProcessMMKV.getMMKV("new_tips").edit().putBoolean(paramArrayOfByte, bool).commit();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    Log.i("MicroMsg.NewTips.NetScenePushNewTips", "onGYNetEnd() uniqueId:%s IsReject:%s", new Object[] { this.dUb, Boolean.valueOf(params.MKT) });
    AppMethodBeat.o(184029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.c
 * JD-Core Version:    0.7.0.1
 */