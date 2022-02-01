package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  public bvf Awo;
  public String Awp;
  public String Awq;
  public String Awr;
  private g callback;
  public int dcG;
  public String nTK;
  private b rr;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(71692);
    this.dcG = 0;
    this.nTK = "";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bve();
    ((b.a)localObject).gUV = new bvf();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bve)this.rr.gUS.gUX;
    ((bve)localObject).CFs = paramString1;
    ((bve)localObject).CFt = paramString2;
    this.rr.setIsUserCmd(true);
    ((bve)localObject).DSo = 0;
    ((bve)localObject).dsB = paramInt;
    ((bve)localObject).dye = 1;
    ((bve)localObject).DSl = true;
    ad.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71692);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean, int paramInt2, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramBoolean, false, paramInt2, paramString6);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString6)
  {
    AppMethodBeat.i(71691);
    this.dcG = 0;
    this.nTK = "";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bve();
    ((b.a)localObject).gUV = new bvf();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/openecard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bve)this.rr.gUS.gUX;
    ((bve)localObject).CFs = paramString1;
    ((bve)localObject).CFt = paramString2;
    this.rr.setIsUserCmd(true);
    if (paramBoolean1)
    {
      ((bve)localObject).DSm = paramString3;
      if (!paramBoolean2) {
        break label287;
      }
    }
    label287:
    for (((bve)localObject).DSo = 1;; ((bve)localObject).DSo = 0)
    {
      ((bve)localObject).zWw = paramString4;
      ((bve)localObject).dca = paramString5;
      ((bve)localObject).dsB = paramInt1;
      ((bve)localObject).DSl = false;
      ((bve)localObject).dye = paramInt2;
      ((bve)localObject).DSp = paramString6;
      this.Awp = paramString3;
      this.Awq = paramString4;
      this.Awr = paramString5;
      ad.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", new Object[] { paramString3 });
      ad.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s, fromScene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(71691);
      return;
      ((bve)localObject).DSn = paramString3;
      break;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71694);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71694);
    return i;
  }
  
  public final int getType()
  {
    return 1985;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71693);
    ad.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Awo = ((bvf)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.Awo.ntx), this.Awo.nty });
    if (!bt.isNullOrNil(this.Awo.DSj)) {
      ad.d("MicroMsg.NetSceneOpenECard", "rettext: %s", new Object[] { this.Awo.DSj });
    }
    try
    {
      paramq = new JSONObject(this.Awo.DSj);
      this.dcG = paramq.optInt("retcode", 0);
      this.nTK = paramq.optString("retmsg", "");
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(71693);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneOpenECard", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.d
 * JD-Core Version:    0.7.0.1
 */