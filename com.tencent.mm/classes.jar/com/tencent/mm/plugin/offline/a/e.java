package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.u;
import org.json.JSONObject;

public final class e
  extends u
{
  private f callback;
  public int cnK;
  private String kNv;
  public String plc;
  public int pld;
  public String ple;
  public int plf;
  public RealnameGuideHelper plg;
  private String plh;
  private String pli;
  private String plj;
  private String plk;
  private String pll;
  private final b rr;
  
  public e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43390);
    this.plc = "";
    this.cnK = -1;
    this.kNv = "";
    this.pld = -1;
    this.ple = "";
    this.plf = 1;
    b.a locala = new b.a();
    locala.fsX = new bgy();
    locala.fsY = new bgz();
    locala.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
    locala.funcId = 609;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.routeInfo = com.tencent.mm.wallet_core.ui.e.awk(paramString3);
    this.rr = locala.ado();
    paramString3 = (bgy)this.rr.fsV.fta;
    paramString3.xwd = paramInt;
    paramString3.Id = paramString1;
    paramString3.gww = paramString2;
    paramString3.wDH = m.cTC();
    this.plf = paramInt;
    AppMethodBeat.o(43390);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(43391);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43391);
    return i;
  }
  
  public final int getType()
  {
    return 609;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142117);
    if (paramInt2 != 0) {
      ab.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : " + getType() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    }
    paramArrayOfByte = (bgz)((b)paramq).fsW.fta;
    paramInt1 = paramInt2;
    i = paramInt3;
    paramq = paramString;
    if (paramInt2 == 0)
    {
      paramInt1 = paramInt2;
      i = paramInt3;
      paramq = paramString;
      if (paramInt3 == 0)
      {
        paramInt1 = paramInt2;
        i = paramInt3;
        paramq = paramString;
      }
    }
    try
    {
      if (paramArrayOfByte.xdr != null)
      {
        paramArrayOfByte = new JSONObject(paramArrayOfByte.xdr);
        this.plc = paramArrayOfByte.optString("transaction_id");
        this.cnK = paramArrayOfByte.optInt("retcode");
        this.kNv = paramArrayOfByte.optString("retmsg");
        this.pld = paramArrayOfByte.optInt("wx_error_type");
        this.ple = paramArrayOfByte.optString("wx_error_msg");
        ab.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[] { paramArrayOfByte.toString() });
        paramInt1 = paramInt2;
        i = paramInt3;
        paramq = paramString;
        if (paramArrayOfByte.has("real_name_info"))
        {
          paramq = paramArrayOfByte.optJSONObject("real_name_info");
          this.plh = paramq.optString("guide_flag");
          this.pli = paramq.optString("guide_wording");
          this.plj = paramq.optString("left_button_wording");
          this.plk = paramq.optString("right_button_wording");
          this.pll = paramq.optString("upload_credit_url");
          if (!"1".equals(this.plh))
          {
            paramInt1 = paramInt2;
            i = paramInt3;
            paramq = paramString;
            if (!"2".equals(this.plh)) {}
          }
          else
          {
            this.plg = new RealnameGuideHelper();
            this.plg.a(this.plh, this.pli, this.plj, this.plk, this.pll, 0);
            paramq = paramString;
            i = paramInt3;
            paramInt1 = paramInt2;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", paramString, "", new Object[0]);
        paramInt1 = 1000;
        i = 2;
        paramq = ah.getContext().getString(2131305032);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, i, paramq, this);
    }
    AppMethodBeat.o(142117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.e
 * JD-Core Version:    0.7.0.1
 */