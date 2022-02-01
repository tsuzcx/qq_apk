package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class f
  extends q
  implements m
{
  private i CXJ;
  public boolean CXK;
  private final d hhm;
  
  public f()
  {
    AppMethodBeat.i(256456);
    this.CXJ = null;
    this.CXK = false;
    d.a locala = new d.a();
    locala.iLN = new bss();
    locala.iLO = new bst();
    locala.uri = "/cgi-bin/micromsg-bin/getpluginswitch";
    locala.funcId = 4158;
    this.hhm = locala.aXF();
    AppMethodBeat.o(256456);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256457);
    this.CXJ = parami;
    int i = dispatch(paramg, this.hhm, this);
    AppMethodBeat.o(256457);
    return i;
  }
  
  public final int getType()
  {
    return 4158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256458);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bst)((d)params).iLL.iLR;
      if (params != null)
      {
        params = params.LZx;
        if (params != null)
        {
          params = params.gCs;
          if (params != null)
          {
            params = params.iterator();
            while (params.hasNext())
            {
              paramArrayOfByte = (dbz)params.next();
              if (paramArrayOfByte != null)
              {
                Log.i("MicroMsg.NetSceneGetMiniShopHelperPluginShowStatus", "updateNeedShow, switchId: %d, switchValue: %b", new Object[] { Integer.valueOf(paramArrayOfByte.MGL), Boolean.valueOf(paramArrayOfByte.MGM) });
                if (5200001 == paramArrayOfByte.MGL) {
                  this.CXK = paramArrayOfByte.MGM;
                }
              }
            }
          }
        }
      }
    }
    if (this.CXJ != null) {
      this.CXJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(256458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.f
 * JD-Core Version:    0.7.0.1
 */