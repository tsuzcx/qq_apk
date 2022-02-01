package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.protocal.protobuf.si;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;
import java.util.LinkedList;

public final class j
  extends w
{
  public int OgO;
  sh Oin;
  public si Oio;
  public e Oip;
  public f Oiq;
  public boolean Oir;
  public String Ois;
  private h callback;
  public boolean cancel;
  private c nao;
  
  public j(a parama, e parame, f paramf)
  {
    AppMethodBeat.i(288828);
    this.Oir = false;
    this.Ois = "";
    this.cancel = false;
    this.OgO = 0;
    this.Ois = (System.currentTimeMillis() + parama.amount);
    c.a locala = new c.a();
    this.OgO = parama.amount;
    locala.otE = new sh();
    locala.otF = new si();
    locala.funcId = 2677;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.Oin = ((sh)c.b.b(this.nao.otB));
    this.Oin.amount = parama.amount;
    this.Oin.channel = parama.channel;
    this.Oin.OhP = parama.OhP;
    this.Oin.Oiu = parama.Oiu;
    this.Oin.Oiv = parama.Oiv;
    this.Oin.OhQ = parama.OhQ;
    this.Oin.Oiw = parama.Oiw;
    this.Oin.nQU = parama.nQU;
    this.Oin.OhR = parama.OhR;
    this.Oin.Oix = parama.Oix;
    this.Oin.YXk = parama.Oit;
    this.Oin.Oiy = parama.Oiy;
    this.Oip = parame;
    this.Oiq = paramf;
    parama = new StringBuffer();
    parama.append(String.format("request.amount %s", new Object[] { Integer.valueOf(this.Oin.amount) }));
    parama.append(String.format("request.channel %s", new Object[] { Integer.valueOf(this.Oin.channel) }));
    parama.append(String.format("request.scan_scene %s", new Object[] { Integer.valueOf(this.Oin.OhP) }));
    parama.append(String.format("request.receiver_desc %s", new Object[] { this.Oin.Oiu }));
    parama.append(String.format("request.mch_name %s", new Object[] { this.Oin.Oiv }));
    parama.append(String.format("request.favor_req_sign %s", new Object[] { this.Oin.OhQ }));
    parama.append(String.format("request.receiver_openid %s", new Object[] { this.Oin.Oiw }));
    parama.append(String.format("request.receiver_username %s", new Object[] { this.Oin.nQU }));
    parama.append(String.format("request.favor_req_extend %s", new Object[] { this.Oin.OhR }));
    parama.append(String.format("request.fail_click_cell %s", new Object[] { Integer.valueOf(this.Oin.Oix) }));
    Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", new Object[] { parama.toString() });
    AppMethodBeat.o(288828);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67844);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67844);
    return i;
  }
  
  public final int getType()
  {
    return 2677;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288835);
    Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Oio = ((si)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", new Object[] { Integer.valueOf(this.Oio.wuz), this.Oio.wuA, b.a(this.Oio.OhT) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288835);
  }
  
  public static final class a
  {
    public int OhP;
    public String OhQ;
    public String OhR;
    public int Oit;
    public String Oiu;
    public String Oiv;
    public String Oiw;
    public int Oix;
    public LinkedList<apu> Oiy;
    public int amount;
    public int channel;
    public String nQU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.j
 * JD-Core Version:    0.7.0.1
 */