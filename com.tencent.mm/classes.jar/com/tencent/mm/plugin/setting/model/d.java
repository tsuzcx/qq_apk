package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.protocal.protobuf.ec;
import com.tencent.mm.protocal.protobuf.fqm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends p
  implements m
{
  private h callback;
  private List<String> zPw;
  
  public d(List<String> paramList)
  {
    this.zPw = paramList;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(73763);
    this.callback = paramh;
    paramh = new c.a();
    eb localeb = new eb();
    ArrayList localArrayList = new ArrayList();
    if (this.zPw != null)
    {
      i = 0;
      while (i < this.zPw.size())
      {
        fqm localfqm = new fqm();
        localfqm.UserName = ((String)this.zPw.get(i));
        localArrayList.add(localfqm);
        i += 1;
      }
    }
    localeb.YGj.addAll(localArrayList);
    paramh.otE = localeb;
    paramh.otF = new ec();
    paramh.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
    paramh.funcId = 583;
    paramh.otG = 0;
    paramh.otG = 0;
    int i = dispatch(paramg, paramh.bEF(), this);
    AppMethodBeat.o(73763);
    return i;
  }
  
  public final int getType()
  {
    return 583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73762);
    updateDispatchIdNew(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.d
 * JD-Core Version:    0.7.0.1
 */