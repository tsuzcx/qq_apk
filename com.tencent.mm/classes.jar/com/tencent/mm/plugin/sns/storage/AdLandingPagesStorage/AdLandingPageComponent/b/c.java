package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306830);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cvx();
    ((c.a)localObject).otF = new cvy();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_wx_user_name";
    ((c.a)localObject).funcId = 4353;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cvx)c.b.b(this.rr.otB);
    ((cvx)localObject).mdG = paramString1;
    ((cvx)localObject).aaBi = paramString2;
    AppMethodBeat.o(306830);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(306839);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(306839);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(306837);
    int i = this.rr.getType();
    AppMethodBeat.o(306837);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(306834);
    Log.i("NetSceneAdGetBtnPersonalUserName", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(306834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.c
 * JD-Core Version:    0.7.0.1
 */