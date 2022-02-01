package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends q
  implements m
{
  private long DJb;
  public i callback;
  private int dJY;
  private d rr;
  private int scene;
  
  public x(int paramInt1, long paramLong, String paramString, int paramInt2, List<String> paramList, int paramInt3)
  {
    AppMethodBeat.i(95655);
    this.scene = 0;
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + paramInt1 + " tagName " + paramString + " memberList " + paramList.size() + " scene " + paramInt3);
    this.dJY = paramInt1;
    this.DJb = paramLong;
    this.scene = paramInt3;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eaz();
    ((d.a)localObject).iLO = new eba();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
    ((d.a)localObject).funcId = 291;
    ((d.a)localObject).iLP = 115;
    ((d.a)localObject).respCmdId = 1000000115;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eaz)this.rr.iLK.iLR;
    ((eaz)localObject).OpCode = paramInt1;
    ((eaz)localObject).Nar = paramLong;
    ((eaz)localObject).xMo = paramString;
    ((eaz)localObject).oTz = paramInt2;
    ((eaz)localObject).Scene = this.scene;
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString.add(new dqi().bhy(str));
    }
    ((eaz)localObject).oTA = paramString;
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + localObject.toString());
    AppMethodBeat.o(95655);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95656);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95656);
    return i;
  }
  
  public final int getType()
  {
    return 291;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95657);
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
    }
    params = ((eba)((d)params).iLL.iLR).Nat;
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + params.toString());
    paramArrayOfByte = aj.faU().JL(params.Nar);
    paramArrayOfByte.field_tagId = params.Nar;
    paramArrayOfByte.field_tagName = Util.nullAs(params.xMo, "");
    switch (this.dJY)
    {
    }
    for (;;)
    {
      aj.faU().a(paramArrayOfByte);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
      paramArrayOfByte.field_count = params.oTz;
      paramArrayOfByte.gX(params.oTA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.x
 * JD-Core Version:    0.7.0.1
 */