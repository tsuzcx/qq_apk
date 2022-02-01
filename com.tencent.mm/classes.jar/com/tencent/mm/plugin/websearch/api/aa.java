package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.ght;
import com.tencent.mm.protocal.protobuf.ghu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class aa
  extends a
  implements m
{
  private w WnS;
  private h callback;
  private c rr;
  
  public aa(w paramw)
  {
    AppMethodBeat.i(117630);
    this.WnS = paramw;
    this.HQI = paramw.hAB;
    this.Sc = paramw.offset;
    this.mScene = paramw.scene;
    this.WnM = paramw.hVk;
    this.WnS = paramw;
    this.WnN = paramw.OMx;
    Object localObject1 = new c.a();
    ((c.a)localObject1).funcId = getType();
    ((c.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((c.a)localObject1).otE = new ght();
    ((c.a)localObject1).otF = new ghu();
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (ght)c.b.b(this.rr.otB);
    ((ght)localObject1).YYs = paramw.offset;
    ((ght)localObject1).aayc = aj.asY(1);
    ((ght)localObject1).abuB = paramw.Wob;
    ((ght)localObject1).aakp = paramw.hAB;
    ((ght)localObject1).aaLr = aj.dch();
    ((ght)localObject1).IJG = paramw.scene;
    ((ght)localObject1).YYr = paramw.xVe;
    ((ght)localObject1).abuF = paramw.hVr;
    ((ght)localObject1).aced = paramw.Woh;
    ((ght)localObject1).abMl = paramw.channelId;
    ((ght)localObject1).acef = paramw.Wot;
    Object localObject2 = new aem();
    ((aem)localObject2).key = "client_system_version";
    ((aem)localObject2).Zmx = Build.VERSION.SDK_INT;
    paramw.Wol.add(localObject2);
    ((ght)localObject1).accs = paramw.Wol;
    ((ght)localObject1).acee = paramw.sessionId;
    this.hVo = paramw.hOG;
    int i;
    String str;
    int j;
    if (paramw.Wox)
    {
      i = paramw.scene;
      localObject1 = paramw.sessionId;
      localObject2 = paramw.hVn;
      str = paramw.xVe;
      j = paramw.offset;
      if (paramw.Wob != 1) {
        break label372;
      }
    }
    for (;;)
    {
      ai.a(i, (String)localObject1, (String)localObject2, str, j, bool, paramw.hOG, paramw.hAB, paramw.businessType, paramw.Wor);
      AppMethodBeat.o(117630);
      return;
      label372:
      bool = false;
    }
  }
  
  private ghu ipM()
  {
    AppMethodBeat.i(315347);
    ghu localghu = (ghu)c.c.b(this.rr.otC);
    AppMethodBeat.o(315347);
    return localghu;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(117631);
    as.nb(this.mScene, 2);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(117631);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final String ipG()
  {
    AppMethodBeat.i(117633);
    if (ipM() != null)
    {
      String str = ipM().aayd;
      AppMethodBeat.o(117633);
      return str;
    }
    AppMethodBeat.o(117633);
    return "";
  }
  
  public final int ipH()
  {
    AppMethodBeat.i(117634);
    if (ipM() != null)
    {
      int i = ipM().acek;
      AppMethodBeat.o(117634);
      return i;
    }
    AppMethodBeat.o(117634);
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117632);
    Log.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if (this.WnS.Wox)
      {
        paramInt1 = this.WnS.scene;
        params = this.WnS.sessionId;
        paramArrayOfByte = this.WnS.hVn;
        String str = this.WnS.xVe;
        int i = this.WnS.offset;
        if (this.WnS.Wob != 1) {
          break label208;
        }
        bool2 = true;
        label124:
        ai.a(paramInt1, params, paramArrayOfByte, str, i, bool2, this.WnS.hOG, bool1, this.WnS.hAB, this.WnS.businessType, this.WnS.Wor);
      }
      if (paramInt3 != -1) {
        break label214;
      }
      as.nb(this.mScene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117632);
      return;
      bool1 = false;
      break;
      label208:
      bool2 = false;
      break label124;
      label214:
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        as.nb(this.mScene, 8);
      } else {
        as.nb(this.mScene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aa
 * JD-Core Version:    0.7.0.1
 */