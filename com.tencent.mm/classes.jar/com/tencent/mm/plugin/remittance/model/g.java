package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.ka;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  jz nxY;
  public ka nxZ;
  public c nya;
  public d nyb;
  public boolean nyc = false;
  public String nyd = "";
  public boolean nye = false;
  public int nyf = 0;
  
  public g(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, c paramc, d paramd)
  {
    this.nyd = (System.currentTimeMillis() + paramInt1);
    b.a locala = new b.a();
    this.nyf = paramInt1;
    locala.ecH = new jz();
    locala.ecI = new ka();
    locala.ecG = 2677;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.nxY = ((jz)this.eWr.ecE.ecN);
    this.nxY.amount = paramInt1;
    this.nxY.bUR = paramInt2;
    this.nxY.nxO = paramInt3;
    this.nxY.sEO = paramString1;
    this.nxY.nzi = paramString2;
    this.nxY.nxP = paramString3;
    this.nxY.nzl = paramString4;
    this.nxY.swg = paramString5;
    this.nxY.nxQ = paramString6;
    this.nxY.sEP = paramInt4;
    this.nya = paramc;
    this.nyb = paramd;
    paramString1 = new StringBuffer();
    paramString1.append(String.format("request.amount %s", new Object[] { Integer.valueOf(this.nxY.amount) }));
    paramString1.append(String.format("request.channel %s", new Object[] { Integer.valueOf(this.nxY.bUR) }));
    paramString1.append(String.format("request.scan_scene %s", new Object[] { Integer.valueOf(this.nxY.nxO) }));
    paramString1.append(String.format("request.receiver_desc %s", new Object[] { this.nxY.sEO }));
    paramString1.append(String.format("request.mch_name %s", new Object[] { this.nxY.nzi }));
    paramString1.append(String.format("request.favor_req_sign %s", new Object[] { this.nxY.nxP }));
    paramString1.append(String.format("request.receiver_openid %s", new Object[] { this.nxY.nzl }));
    paramString1.append(String.format("request.receiver_username %s", new Object[] { this.nxY.swg }));
    paramString1.append(String.format("request.favor_req_extend %s", new Object[] { this.nxY.nxQ }));
    paramString1.append(String.format("request.fail_click_cell %s", new Object[] { Integer.valueOf(this.nxY.sEP) }));
    y.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[] { paramString1.toString() });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nxZ = ((ka)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[] { Integer.valueOf(this.nxZ.ino), this.nxZ.inp, a.a(this.nxZ.nxS) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 2677;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.g
 * JD-Core Version:    0.7.0.1
 */