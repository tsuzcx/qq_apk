package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.dda;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f jpa;
  
  static
  {
    AppMethodBeat.i(125904);
    jpa = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(125898);
        a.b(paramAnonymousBallInfo);
        AppMethodBeat.o(125898);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(125904);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public static void aWo()
  {
    AppMethodBeat.i(125900);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).a(8, jpa);
    }
    AppMethodBeat.o(125900);
  }
  
  public static void aWp()
  {
    AppMethodBeat.i(125901);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).b(8, jpa);
    }
    AppMethodBeat.o(125901);
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(125899);
    super.Z(paramInt, paramString);
    bzz().mDz = 7;
    AppMethodBeat.o(125899);
  }
  
  public final void a(dcy paramdcy, ddb paramddb)
  {
    AppMethodBeat.i(125902);
    ad.i("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData contextId:%s videoId:%s", new Object[] { paramdcy.qwV, paramddb.rNP });
    dda localdda = new dda();
    localdda.Euu = paramdcy.Euu;
    localdda.Euv = paramdcy.Euv;
    if (bt.isNullOrNil(paramdcy.jko)) {
      localdda.Euw = paramdcy.Euw;
    }
    for (;;)
    {
      localdda.Eux = paramdcy.Eux;
      localdda.EuA = paramdcy.EuA;
      localdda.qwV = paramdcy.qwV;
      localdda.EuH = paramdcy.EuH;
      localdda.offset = paramdcy.offset;
      localdda.Euy = paramdcy.Euy;
      localdda.scene = paramdcy.scene;
      localdda.dcm = paramdcy.dcm;
      localdda.AFX = paramdcy.AFX;
      localdda.EuL.add(paramddb);
      try
      {
        OE(paramddb.title);
        paramdcy = localdda.toByteArray();
        if (this.mDH != null)
        {
          ad.i("MicroMsg.FloatBallHelper", "updateByteArrayExtra, %s", new Object[] { "key_context" });
          this.mDH.l("key_context", paramdcy);
          bzv();
        }
        bzz().dnC = localdda.Euw;
        bzz().mDA = paramddb.rNP;
        bzz().mDy = localdda.scene;
        ad.d("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData, searchId:%s vid:%s", new Object[] { localdda.Euw, paramddb.rNP });
        bzv();
        AppMethodBeat.o(125902);
        return;
        localdda.Euw = paramdcy.jko;
      }
      catch (IOException paramdcy)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.TopStoryFloatBallHelper", paramdcy, "updateFloatBallData exception:%s", new Object[] { paramdcy });
        }
      }
    }
  }
  
  public final boolean aVX()
  {
    return true;
  }
  
  public final boolean aWg()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.a
 * JD-Core Version:    0.7.0.1
 */