package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/task/GetLensInfoTaskImpl;", "Lcom/tencent/mm/sticker/task/GetLensInfoTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lensId", "", "callback", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/lang/String;Lcom/tencent/mm/sticker/task/GetLensInfoCallback;)V", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends d
{
  public e(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, String paramString, c paramc)
  {
    super(paramString);
    AppMethodBeat.i(105985);
    Log.i(f.aUw(), s.X("GetLensInfoTaskImpl: ", paramString));
    Object localObject = com.tencent.mm.sticker.a.a.acCZ.buW(paramString);
    if (com.tencent.mm.sticker.a.a.acCZ.buX(paramString))
    {
      if (paramc != null)
      {
        paramc.a(2, null);
        AppMethodBeat.o(105985);
      }
    }
    else if (localObject != null)
    {
      if (paramc != null)
      {
        paramc.a(0, (dhp)localObject);
        AppMethodBeat.o(105985);
      }
    }
    else
    {
      localObject = new a(paramString);
      ((com.tencent.mm.am.b)localObject).otr = true;
      paramString = ((com.tencent.mm.am.b)localObject).bFJ().j(new e..ExternalSyntheticLambda0(paramc, paramString));
      if (paramb != null) {
        paramString.a(paramb);
      }
    }
    AppMethodBeat.o(105985);
  }
  
  private static final ah a(c paramc, String paramString, b.a parama)
  {
    AppMethodBeat.i(233896);
    s.u(paramString, "$lensId");
    int i = parama.errType;
    int j = parama.errCode;
    String str = parama.errMsg;
    Log.i(f.aUw(), "GetLensInfo: " + i + ", " + j + ", " + str);
    if ((i != 0) || (j != 0))
    {
      if ((i == 4) && (j == -436))
      {
        if (paramc != null) {
          paramc.a(2, null);
        }
        com.tencent.mm.sticker.a.a.acCZ.buY(paramString);
        paramc = ah.aiuX;
        AppMethodBeat.o(233896);
        return paramc;
      }
      if (paramc == null)
      {
        AppMethodBeat.o(233896);
        return null;
      }
      i = 1;
      paramString = null;
    }
    for (;;)
    {
      paramc.a(i, paramString);
      paramc = ah.aiuX;
      AppMethodBeat.o(233896);
      return paramc;
      paramString = (cmd)parama.ott;
      if (paramString != null)
      {
        paramString = paramString.aauh;
        if (paramString != null) {
          com.tencent.mm.sticker.a.a.acCZ.e(paramString);
        }
      }
      if (paramc == null)
      {
        AppMethodBeat.o(233896);
        return null;
      }
      i = 0;
      paramString = (cmd)parama.ott;
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.aauh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sticker.c.e
 * JD-Core Version:    0.7.0.1
 */