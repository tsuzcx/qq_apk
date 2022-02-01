package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.fgc;
import com.tencent.mm.protocal.protobuf.fgd;
import com.tencent.mm.sdk.platformtools.Log;

public final class ac
  extends p
  implements m
{
  public h callback;
  private c rr;
  
  public ac(String paramString, u paramu)
  {
    AppMethodBeat.i(309398);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fgc();
    ((c.a)localObject).otF = new fgd();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnswwlikecover";
    ((c.a)localObject).funcId = 4051;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fgc)c.b.b(this.rr.otB);
    ((fgc)localObject).Username = paramString;
    ((fgc)localObject).abGa = paramu.field_bgUrl;
    ((fgc)localObject).abGb = paramu.field_imBGmd5sum;
    ((fgc)localObject).abGc = paramu.field_imBGfileid;
    Log.i("MicroMsg.NetSceneSnsWwLikeCover", "SnsWwLikeCover username:%s, bgUrl:%s, bgMd5:%s, fileId:%s", new Object[] { paramString, paramu.field_bgUrl, paramu.field_imBGmd5sum, paramu.field_imBGfileid });
    AppMethodBeat.o(309398);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(309400);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(309400);
    return i;
  }
  
  public final int getType()
  {
    return 4051;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(309405);
    Log.i("MicroMsg.NetSceneSnsWwLikeCover", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(309405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac
 * JD-Core Version:    0.7.0.1
 */