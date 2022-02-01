package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends q
  implements m
{
  private i callback;
  public eii eel;
  private d rr;
  private long uOV;
  
  public b(eii parameii, int paramInt, String paramString)
  {
    AppMethodBeat.i(91005);
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", new Object[] { Integer.valueOf(parameii.channelId), Integer.valueOf(paramInt), parameii.sGQ, parameii.sessionId });
    this.uOV = System.currentTimeMillis();
    this.eel = parameii;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((d.a)localObject).iLN = new fal();
    ((d.a)localObject).iLO = new fam();
    this.rr = ((d.a)localObject).aXF();
    localObject = (fal)this.rr.iLK.iLR;
    ((fal)localObject).KZk = parameii.offset;
    ((fal)localObject).MaY = ai.aft(1);
    ((fal)localObject).LPT = parameii.dDv;
    ((fal)localObject).MlQ = ai.clJ();
    ((fal)localObject).Scene = parameii.scene;
    ((fal)localObject).KZj = parameii.hes;
    ((fal)localObject).Nva.addAll(parameii.IDO);
    ((fal)localObject).NgA = parameii.channelId;
    ((fal)localObject).NwK = paramInt;
    ((fal)localObject).NwL = parameii.NhC;
    if (((fal)localObject).NgA == 110)
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo();
      if (paramString != null) {
        ((fal)localObject).MOi = paramString.msgId;
      }
    }
    for (;;)
    {
      ((fal)localObject).NwI = parameii.IDW;
      ((fal)localObject).NwJ = parameii.NhB;
      parameii = new aca();
      parameii.key = "client_system_version";
      parameii.LmC = Build.VERSION.SDK_INT;
      ((fal)localObject).Nva.add(parameii);
      parameii = new aca();
      parameii.key = "netType";
      parameii.LmD = ai.ait();
      ((fal)localObject).Nva.add(parameii);
      parameii = new aca();
      parameii.key = "client_request_time";
      parameii.LmD = String.valueOf(System.currentTimeMillis());
      ((fal)localObject).Nva.add(parameii);
      parameii = ((fal)localObject).Nva.iterator();
      while (parameii.hasNext())
      {
        paramString = (aca)parameii.next();
        Log.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[] { paramString.key, Long.valueOf(paramString.LmC), paramString.LmD });
      }
      if (((fal)localObject).NgA == 100) {
        ((fal)localObject).MOi = paramString;
      } else {
        ((fal)localObject).MOi = "";
      }
    }
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", new Object[] { Integer.valueOf(((fal)localObject).KZk), Integer.valueOf(((fal)localObject).MaY), Integer.valueOf(((fal)localObject).NwJ.size()) });
    AppMethodBeat.o(91005);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(91006);
    ar.kb(this.eel.scene, 2);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91006);
    return i;
  }
  
  public final fam fxZ()
  {
    return (fam)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91007);
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.uOV) });
    if (paramInt3 == -1) {
      ar.kb(this.eel.scene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(91007);
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        ar.kb(this.eel.scene, 8);
      } else {
        ar.kb(this.eel.scene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.b
 * JD-Core Version:    0.7.0.1
 */