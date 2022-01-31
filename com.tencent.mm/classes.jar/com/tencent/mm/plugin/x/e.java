package com.tencent.mm.plugin.x;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.dn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private String aeskey;
  private String diG;
  private b dmK;
  private f dmL;
  private String fileId;
  private int mtd;
  private String mte;
  private String mtf;
  
  public e(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    this.fileId = paramString1;
    this.aeskey = paramString2;
    this.mtd = paramInt;
    this.diG = paramString3;
    this.mte = paramString4;
    this.mtf = paramString5;
    paramString2 = new b.a();
    paramString2.ecH = new bos();
    paramString2.ecI = new bot();
    paramString2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    paramString2.ecG = 222;
    paramString2.ecJ = 107;
    paramString2.ecK = 1000000107;
    this.dmK = paramString2.Kt();
    y.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[] { paramString4, this.mte, paramString1, Integer.valueOf(paramInt), paramString3, bk.csb() });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new g.a();
    paramf.title = "ChatSync";
    paramf.description = "ChatSync";
    paramf.type = 35;
    paramf.url = this.fileId;
    paramf.dQR = this.aeskey;
    paramf.dQS = this.aeskey;
    paramf.dQv = this.mtd;
    paramf.dQS = this.aeskey;
    paramf.showType = 0;
    paramf.action = "phone";
    paramf.messageAction = this.mte;
    paramf.extInfo = "supportAfterSleep,supportGetMore";
    paramf.content = this.mtf;
    bos localbos = (bos)this.dmK.ecE.ecN;
    dn localdn = new dn();
    localdn.kWn = this.diG;
    localdn.swP = paramf.sdkVer;
    localdn.hQR = 35;
    localdn.kWm = this.diG;
    localdn.kVs = g.a.a(paramf, null, null, 0, 0);
    localdn.mPL = ((int)bk.UX());
    localbos.tGZ = localdn;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 222;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.x.e
 * JD-Core Version:    0.7.0.1
 */