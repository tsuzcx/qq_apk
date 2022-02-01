package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class d
  extends e
{
  protected b Gmr;
  public boolean Gol = false;
  
  public d(b paramb)
  {
    super(paramb);
    this.Gmr = paramb;
  }
  
  public final int abY(int paramInt)
  {
    return 0;
  }
  
  public final void t(final List<eiw> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126248);
    super.t(paramList, paramBoolean);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126247);
        Object localObject1 = d.a(d.this).fyO();
        int i = ((n)localObject1).fzy();
        Log.i("MicroMsg.TopStory.TopStoryFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()) });
        List localList = paramList;
        try
        {
          if (!Util.isNullOrNil(localList)) {
            ((n)localObject1).GW().addAll(localList);
          }
          localObject1 = d.this;
          ((d)localObject1).ci(i + ((d)localObject1).getHeadersCount());
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