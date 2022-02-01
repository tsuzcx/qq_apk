package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eeb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class h
  extends p
  implements m
{
  private com.tencent.mm.am.h PnE;
  public boolean PnF;
  private final c mtC;
  
  public h()
  {
    AppMethodBeat.i(298544);
    this.PnE = null;
    this.PnF = false;
    c.a locala = new c.a();
    locala.otE = new cpv();
    locala.otF = new cpw();
    locala.uri = "/cgi-bin/micromsg-bin/getpluginswitch";
    locala.funcId = 4158;
    this.mtC = locala.bEF();
    AppMethodBeat.o(298544);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(298550);
    this.PnE = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(298550);
    return i;
  }
  
  public final int getType()
  {
    return 4158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(298552);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cpw)c.c.b(((c)params).otC);
      if (params != null)
      {
        params = params.aawq;
        if (params != null)
        {
          params = params.lPK;
          if (params != null)
          {
            params = params.iterator();
            while (params.hasNext())
            {
              paramArrayOfByte = (eea)params.next();
              if (paramArrayOfByte != null)
              {
                Log.i("MicroMsg.NetSceneGetMiniShopHelperPluginShowStatus", "updateNeedShow, switchId: %d, switchValue: %b", new Object[] { Integer.valueOf(paramArrayOfByte.abiX), Boolean.valueOf(paramArrayOfByte.abiY) });
                if (5200001 == paramArrayOfByte.abiX) {
                  this.PnF = paramArrayOfByte.abiY;
                }
              }
            }
          }
        }
      }
    }
    if (this.PnE != null) {
      this.PnE.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(298552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.h
 * JD-Core Version:    0.7.0.1
 */