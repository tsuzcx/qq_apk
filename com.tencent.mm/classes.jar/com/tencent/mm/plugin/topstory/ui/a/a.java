package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f kjw;
  
  static
  {
    AppMethodBeat.i(125904);
    kjw = new com.tencent.mm.plugin.ball.c.g()
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
  
  public static void bgQ()
  {
    AppMethodBeat.i(125900);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).a(8, kjw);
    }
    AppMethodBeat.o(125900);
  }
  
  public static void bgR()
  {
    AppMethodBeat.i(125901);
    if (com.tencent.mm.kernel.g.ab(c.class) != null) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).b(8, kjw);
    }
    AppMethodBeat.o(125901);
  }
  
  public final void a(doa paramdoa, dod paramdod)
  {
    AppMethodBeat.i(125902);
    ad.i("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData contextId:%s videoId:%s", new Object[] { paramdoa.qXu, paramdod.tSk });
    doc localdoc = new doc();
    localdoc.HCb = paramdoa.HCb;
    localdoc.HCc = paramdoa.HCc;
    if (bt.isNullOrNil(paramdoa.keN)) {
      localdoc.HCd = paramdoa.HCd;
    }
    for (;;)
    {
      localdoc.HCe = paramdoa.HCe;
      localdoc.HCh = paramdoa.HCh;
      localdoc.qXu = paramdoa.qXu;
      localdoc.HCo = paramdoa.HCo;
      localdoc.offset = paramdoa.offset;
      localdoc.HCf = paramdoa.HCf;
      localdoc.scene = paramdoa.scene;
      localdoc.dld = paramdoa.dld;
      localdoc.DBj = paramdoa.DBj;
      localdoc.HCs.add(paramdod);
      try
      {
        Wm(paramdod.title);
        paramdoa = localdoc.toByteArray();
        if (this.nGj != null)
        {
          ad.i("MicroMsg.FloatBallHelper", "updateByteArrayExtra, %s", new Object[] { "key_context" });
          this.nGj.m("key_context", paramdoa);
          bKC();
        }
        bKG().dwX = localdoc.HCd;
        bKG().nGd = paramdod.tSk;
        bKG().nGb = localdoc.scene;
        ad.d("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData, searchId:%s vid:%s", new Object[] { localdoc.HCd, paramdod.tSk });
        bKC();
        AppMethodBeat.o(125902);
        return;
        localdoc.HCd = paramdoa.keN;
      }
      catch (Exception paramdoa)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.TopStoryFloatBallHelper", paramdoa, "updateFloatBallData exception:%s", new Object[] { paramdoa });
        }
      }
    }
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(125899);
    super.ac(paramInt, paramString);
    bKG().nGc = 7;
    AppMethodBeat.o(125899);
  }
  
  public final boolean bgI()
  {
    return true;
  }
  
  public final boolean bgz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.a
 * JD-Core Version:    0.7.0.1
 */