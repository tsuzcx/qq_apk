package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class d
  extends e
{
  protected b BLL;
  public boolean BNE = false;
  
  public d(b paramb)
  {
    super(paramb);
    this.BLL = paramb;
  }
  
  public final int TI(int paramInt)
  {
    return 0;
  }
  
  public final void o(final List<dpa> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126248);
    super.o(paramList, paramBoolean);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126247);
        Object localObject1 = d.a(d.this).ets();
        int i = ((n)localObject1).euc();
        ae.i("MicroMsg.TopStory.TopStoryFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()) });
        List localList = paramList;
        try
        {
          if (!bu.ht(localList)) {
            ((n)localObject1).cPU().addAll(localList);
          }
          localObject1 = d.this;
          ((d)localObject1).cj(i + ((d)localObject1).getHeadersCount());
          AppMethodBeat.o(126247);
          return;
        }
        finally
        {
          AppMethodBeat.o(126247);
        }
      }
    });
    AppMethodBeat.o(126248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.d
 * JD-Core Version:    0.7.0.1
 */