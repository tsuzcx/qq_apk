package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.fog;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.plugin.ball.service.e
{
  private static com.tencent.mm.plugin.ball.c.e roL;
  
  static
  {
    AppMethodBeat.i(125904);
    roL = new a.1();
    AppMethodBeat.o(125904);
  }
  
  public a(f paramf)
  {
    super(paramf);
  }
  
  public static void cou()
  {
    AppMethodBeat.i(125900);
    if (h.ax(b.class) != null) {
      ((b)h.ax(b.class)).a(8, roL);
    }
    AppMethodBeat.o(125900);
  }
  
  public static void cov()
  {
    AppMethodBeat.i(125901);
    if (h.ax(b.class) != null) {
      ((b)h.ax(b.class)).b(8, roL);
    }
    AppMethodBeat.o(125901);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(125899);
    super.J(paramInt, paramString);
    cYv().mUU = 7;
    AppMethodBeat.o(125899);
  }
  
  public final void a(foe paramfoe, foh paramfoh)
  {
    AppMethodBeat.i(125902);
    Log.i("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData contextId:%s videoId:%s", new Object[] { paramfoe.zIO, paramfoh.Ido });
    fog localfog = new fog();
    localfog.abOf = paramfoe.abOf;
    localfog.abOg = paramfoe.abOg;
    if (Util.isNullOrNil(paramfoe.mpa)) {
      localfog.abOh = paramfoe.abOh;
    }
    for (;;)
    {
      localfog.abOi = paramfoe.abOi;
      localfog.abOl = paramfoe.abOl;
      localfog.zIO = paramfoe.zIO;
      localfog.abOs = paramfoe.abOs;
      localfog.offset = paramfoe.offset;
      localfog.abOj = paramfoe.abOj;
      localfog.scene = paramfoe.scene;
      localfog.hAB = paramfoe.hAB;
      localfog.Wol = paramfoe.Wol;
      localfog.aaUM.add(paramfoh);
      try
      {
        ahU(paramfoh.title);
        q("key_context", localfog.toByteArray());
        cYv().hOH = localfog.abOh;
        cYv().vjO = paramfoh.Ido;
        cYv().vjN = localfog.scene;
        Log.d("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData, searchId:%s vid:%s", new Object[] { localfog.abOh, paramfoh.Ido });
        cYr();
        AppMethodBeat.o(125902);
        return;
        localfog.abOh = paramfoe.mpa;
      }
      catch (Exception paramfoe)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryFloatBallHelper", paramfoe, "updateFloatBallData exception:%s", new Object[] { paramfoe });
        }
      }
    }
  }
  
  public final boolean bhU()
  {
    return true;
  }
  
  public final boolean cop()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.a
 * JD-Core Version:    0.7.0.1
 */