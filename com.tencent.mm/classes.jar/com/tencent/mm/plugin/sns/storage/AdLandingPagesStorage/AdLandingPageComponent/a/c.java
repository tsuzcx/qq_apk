package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203132);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bya();
    ((d.a)localObject).iLO = new byb();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_wx_user_name";
    ((d.a)localObject).funcId = 4353;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bya)this.rr.iLK.iLR;
    ((bya)localObject).gTk = paramString1;
    ((bya)localObject).MdB = paramString2;
    AppMethodBeat.o(203132);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(203135);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(203135);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(203134);
    int i = this.rr.getType();
    AppMethodBeat.o(203134);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(203133);
    Log.i("NetSceneAdGetBtnPersonalUserName", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(203133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c
 * JD-Core Version:    0.7.0.1
 */