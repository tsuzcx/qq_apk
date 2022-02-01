package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f kmM;
  
  static
  {
    AppMethodBeat.i(125904);
    kmM = new com.tencent.mm.plugin.ball.c.g()
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
  
  public static void bhy()
  {
    AppMethodBeat.i(125900);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).a(8, kmM);
    }
    AppMethodBeat.o(125900);
  }
  
  public static void bhz()
  {
    AppMethodBeat.i(125901);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).b(8, kmM);
    }
    AppMethodBeat.o(125901);
  }
  
  public final void a(dox paramdox, dpa paramdpa)
  {
    AppMethodBeat.i(125902);
    ae.i("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData contextId:%s videoId:%s", new Object[] { paramdox.rfA, paramdpa.udb });
    doz localdoz = new doz();
    localdoz.HVO = paramdox.HVO;
    localdoz.HVP = paramdox.HVP;
    if (bu.isNullOrNil(paramdox.kid)) {
      localdoz.HVQ = paramdox.HVQ;
    }
    for (;;)
    {
      localdoz.HVR = paramdox.HVR;
      localdoz.HVU = paramdox.HVU;
      localdoz.rfA = paramdox.rfA;
      localdoz.HWb = paramdox.HWb;
      localdoz.offset = paramdox.offset;
      localdoz.HVS = paramdox.HVS;
      localdoz.scene = paramdox.scene;
      localdoz.dmf = paramdox.dmf;
      localdoz.DTg = paramdox.DTg;
      localdoz.HWf.add(paramdpa);
      try
      {
        WY(paramdpa.title);
        paramdox = localdoz.toByteArray();
        if (this.nLK != null)
        {
          ae.i("MicroMsg.FloatBallHelper", "updateByteArrayExtra, %s", new Object[] { "key_context" });
          this.nLK.m("key_context", paramdox);
          bLz();
        }
        bLD().dyc = localdoz.HVQ;
        bLD().nLD = paramdpa.udb;
        bLD().nLB = localdoz.scene;
        ae.d("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData, searchId:%s vid:%s", new Object[] { localdoz.HVQ, paramdpa.udb });
        bLz();
        AppMethodBeat.o(125902);
        return;
        localdoz.HVQ = paramdox.kid;
      }
      catch (Exception paramdox)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TopStory.TopStoryFloatBallHelper", paramdox, "updateFloatBallData exception:%s", new Object[] { paramdox });
        }
      }
    }
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(125899);
    super.ac(paramInt, paramString);
    bLD().nLC = 7;
    AppMethodBeat.o(125899);
  }
  
  public final boolean bhh()
  {
    return true;
  }
  
  public final boolean bhq()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.a
 * JD-Core Version:    0.7.0.1
 */