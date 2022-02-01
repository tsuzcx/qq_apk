package com.tencent.mm.plugin.topstory.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static e lqt;
  
  static
  {
    AppMethodBeat.i(125904);
    lqt = new com.tencent.mm.plugin.ball.c.f()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(125898);
        a.a(paramAnonymousBallInfo);
        AppMethodBeat.o(125898);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(125904);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(125899);
    super.G(paramInt, paramString);
    ciw().hDa = 7;
    AppMethodBeat.o(125899);
  }
  
  public final void a(eit parameit, eiw parameiw)
  {
    AppMethodBeat.i(125902);
    Log.i("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData contextId:%s videoId:%s", new Object[] { parameit.sGQ, parameiw.psI });
    eiv localeiv = new eiv();
    localeiv.NhX = parameit.NhX;
    localeiv.NhY = parameit.NhY;
    if (Util.isNullOrNil(parameit.hes)) {
      localeiv.NhZ = parameit.NhZ;
    }
    for (;;)
    {
      localeiv.Nia = parameit.Nia;
      localeiv.Nid = parameit.Nid;
      localeiv.sGQ = parameit.sGQ;
      localeiv.Nik = parameit.Nik;
      localeiv.offset = parameit.offset;
      localeiv.Nib = parameit.Nib;
      localeiv.scene = parameit.scene;
      localeiv.dDv = parameit.dDv;
      localeiv.IDO = parameit.IDO;
      localeiv.Mub.add(parameiw);
      try
      {
        agT(parameiw.title);
        parameit = localeiv.toByteArray();
        if (this.oWE != null)
        {
          Log.i("MicroMsg.FloatBallHelper", "updateByteArrayExtra, %s", new Object[] { "key_context" });
          this.oWE.G("key_context", parameit);
          cit();
        }
        ciw().dPJ = localeiv.NhZ;
        ciw().oWy = parameiw.psI;
        ciw().oWx = localeiv.scene;
        Log.d("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData, searchId:%s vid:%s", new Object[] { localeiv.NhZ, parameiw.psI });
        cit();
        AppMethodBeat.o(125902);
        return;
        localeiv.NhZ = parameit.hes;
      }
      catch (Exception parameit)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryFloatBallHelper", parameit, "updateFloatBallData exception:%s", new Object[] { parameit });
        }
      }
    }
  }
  
  public final boolean aGg()
  {
    return true;
  }
  
  public final boolean bCG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.b.a
 * JD-Core Version:    0.7.0.1
 */