package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f jPm;
  
  static
  {
    AppMethodBeat.i(125904);
    jPm = new com.tencent.mm.plugin.ball.c.g()
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
  
  public static void bdm()
  {
    AppMethodBeat.i(125900);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).a(8, jPm);
    }
    AppMethodBeat.o(125900);
  }
  
  public static void bdn()
  {
    AppMethodBeat.i(125901);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).b(8, jPm);
    }
    AppMethodBeat.o(125901);
  }
  
  public final void a(dil paramdil, dio paramdio)
  {
    AppMethodBeat.i(125902);
    ac.i("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData contextId:%s videoId:%s", new Object[] { paramdil.qox, paramdio.sVF });
    din localdin = new din();
    localdin.FRv = paramdil.FRv;
    localdin.FRw = paramdil.FRw;
    if (bs.isNullOrNil(paramdil.jKB)) {
      localdin.FRx = paramdil.FRx;
    }
    for (;;)
    {
      localdin.FRy = paramdil.FRy;
      localdin.FRB = paramdil.FRB;
      localdin.qox = paramdil.qox;
      localdin.FRI = paramdil.FRI;
      localdin.offset = paramdil.offset;
      localdin.FRz = paramdil.FRz;
      localdin.scene = paramdil.scene;
      localdin.cZL = paramdil.cZL;
      localdin.BYq = paramdil.BYq;
      localdin.FRM.add(paramdio);
      try
      {
        SO(paramdio.title);
        paramdil = localdin.toByteArray();
        if (this.nfN != null)
        {
          ac.i("MicroMsg.FloatBallHelper", "updateByteArrayExtra, %s", new Object[] { "key_context" });
          this.nfN.l("key_context", paramdil);
          bGr();
        }
        bGv().dlk = localdin.FRx;
        bGv().nfH = paramdio.sVF;
        bGv().nfF = localdin.scene;
        ac.d("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData, searchId:%s vid:%s", new Object[] { localdin.FRx, paramdio.sVF });
        bGr();
        AppMethodBeat.o(125902);
        return;
        localdin.FRx = paramdil.jKB;
      }
      catch (IOException paramdil)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TopStory.TopStoryFloatBallHelper", paramdil, "updateFloatBallData exception:%s", new Object[] { paramdil });
        }
      }
    }
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(125899);
    super.aa(paramInt, paramString);
    bGv().nfG = 7;
    AppMethodBeat.o(125899);
  }
  
  public final boolean bcV()
  {
    return true;
  }
  
  public final boolean bde()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.a
 * JD-Core Version:    0.7.0.1
 */