package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esx;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.plugin.ball.service.e
{
  private static com.tencent.mm.plugin.ball.c.e old;
  
  static
  {
    AppMethodBeat.i(125904);
    old = new a.1();
    AppMethodBeat.o(125904);
  }
  
  public a(f paramf)
  {
    super(paramf);
  }
  
  public static void bOh()
  {
    AppMethodBeat.i(125900);
    if (h.ae(b.class) != null) {
      ((b)h.ae(b.class)).a(8, old);
    }
    AppMethodBeat.o(125900);
  }
  
  public static void bOi()
  {
    AppMethodBeat.i(125901);
    if (h.ae(b.class) != null) {
      ((b)h.ae(b.class)).b(8, old);
    }
    AppMethodBeat.o(125901);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(125899);
    super.I(paramInt, paramString);
    cvL().kqZ = 7;
    AppMethodBeat.o(125899);
  }
  
  public final void a(esv paramesv, esy paramesy)
  {
    AppMethodBeat.i(125902);
    Log.i("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData contextId:%s videoId:%s", new Object[] { paramesv.wmL, paramesy.Crh });
    esx localesx = new esx();
    localesx.UuD = paramesv.UuD;
    localesx.UuE = paramesv.UuE;
    if (Util.isNullOrNil(paramesv.jQi)) {
      localesx.UuF = paramesv.UuF;
    }
    for (;;)
    {
      localesx.UuG = paramesv.UuG;
      localesx.UuJ = paramesv.UuJ;
      localesx.wmL = paramesv.wmL;
      localesx.UuQ = paramesv.UuQ;
      localesx.offset = paramesv.offset;
      localesx.UuH = paramesv.UuH;
      localesx.scene = paramesv.scene;
      localesx.fwe = paramesv.fwe;
      localesx.Pye = paramesv.Pye;
      localesx.TFg.add(paramesy);
      try
      {
        aoy(paramesy.title);
        n("key_context", localesx.toByteArray());
        cvL().fIZ = localesx.UuF;
        cvL().rYy = paramesy.Crh;
        cvL().rYx = localesx.scene;
        Log.d("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData, searchId:%s vid:%s", new Object[] { localesx.UuF, paramesy.Crh });
        cvG();
        AppMethodBeat.o(125902);
        return;
        localesx.UuF = paramesv.jQi;
      }
      catch (Exception paramesv)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryFloatBallHelper", paramesv, "updateFloatBallData exception:%s", new Object[] { paramesv });
        }
      }
    }
  }
  
  public final boolean aOg()
  {
    return true;
  }
  
  public final boolean bOb()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.a
 * JD-Core Version:    0.7.0.1
 */