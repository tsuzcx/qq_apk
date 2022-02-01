package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class f
  extends q
  implements m
{
  private i Jdp;
  public boolean Jdq;
  private final d jTk;
  
  public f()
  {
    AppMethodBeat.i(263743);
    this.Jdp = null;
    this.Jdq = false;
    d.a locala = new d.a();
    locala.lBU = new cam();
    locala.lBV = new can();
    locala.uri = "/cgi-bin/micromsg-bin/getpluginswitch";
    locala.funcId = 4158;
    this.jTk = locala.bgN();
    AppMethodBeat.o(263743);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(263747);
    this.Jdp = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(263747);
    return i;
  }
  
  public final int getType()
  {
    return 4158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(263750);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (can)d.c.b(((d)params).lBS);
      if (params != null)
      {
        params = params.TiQ;
        if (params != null)
        {
          params = params.jmy;
          if (params != null)
          {
            params = params.iterator();
            while (params.hasNext())
            {
              paramArrayOfByte = (dlp)params.next();
              if (paramArrayOfByte != null)
              {
                Log.i("MicroMsg.NetSceneGetMiniShopHelperPluginShowStatus", "updateNeedShow, switchId: %d, switchValue: %b", new Object[] { Integer.valueOf(paramArrayOfByte.TSz), Boolean.valueOf(paramArrayOfByte.TSA) });
                if (5200001 == paramArrayOfByte.TSz) {
                  this.Jdq = paramArrayOfByte.TSA;
                }
              }
            }
          }
        }
      }
    }
    if (this.Jdp != null) {
      this.Jdp.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(263750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.f
 * JD-Core Version:    0.7.0.1
 */