package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ffe;
import com.tencent.mm.protocal.protobuf.ffh;
import com.tencent.mm.protocal.protobuf.ffi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends p
  implements m
{
  private long Qtc;
  public h callback;
  private int hHC;
  private c rr;
  private int scene;
  
  public x(int paramInt1, long paramLong, String paramString, int paramInt2, List<String> paramList, int paramInt3)
  {
    AppMethodBeat.i(95655);
    this.scene = 0;
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + paramInt1 + " tagName " + paramString + " memberList " + paramList.size() + " scene " + paramInt3);
    this.hHC = paramInt1;
    this.Qtc = paramLong;
    this.scene = paramInt3;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ffh();
    ((c.a)localObject).otF = new ffi();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
    ((c.a)localObject).funcId = 291;
    ((c.a)localObject).otG = 115;
    ((c.a)localObject).respCmdId = 1000000115;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ffh)c.b.b(this.rr.otB);
    ((ffh)localObject).YIq = paramInt1;
    ((ffh)localObject).abES = paramLong;
    ((ffh)localObject).IKH = paramString;
    ((ffh)localObject).vgN = paramInt2;
    ((ffh)localObject).IJG = this.scene;
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString.add(new etl().btH(str));
    }
    ((ffh)localObject).vgO = paramString;
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + localObject.toString());
    AppMethodBeat.o(95655);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(95656);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95656);
    return i;
  }
  
  public final int getType()
  {
    return 291;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95657);
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
    }
    ffe localffe = ((ffi)c.c.b(((c)params).otC)).abEU;
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + localffe.toString());
    paramArrayOfByte = al.hgI().vl(localffe.abES);
    params = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      params = new ac();
    }
    params.field_tagId = localffe.abES;
    params.field_tagName = Util.nullAs(localffe.IKH, "");
    switch (this.hHC)
    {
    }
    for (;;)
    {
      al.hgI().a(params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
      params.field_count = localffe.vgN;
      params.kG(localffe.vgO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.x
 * JD-Core Version:    0.7.0.1
 */