package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class d
  extends e
{
  protected b AcC;
  public boolean Aeu = false;
  
  public d(b paramb)
  {
    super(paramb);
    this.AcC = paramb;
  }
  
  public final int Rr(int paramInt)
  {
    return 0;
  }
  
  public final void n(final List<dio> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126248);
    super.n(paramList, paramBoolean);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126247);
        Object localObject1 = d.a(d.this).edt();
        int i = ((n)localObject1).eee();
        ac.i("MicroMsg.TopStory.TopStoryFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()) });
        List localList = paramList;
        try
        {
          if (!bs.gY(localList)) {
            ((n)localObject1).eed().addAll(localList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.d
 * JD-Core Version:    0.7.0.1
 */