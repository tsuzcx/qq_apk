package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.HashMap;

final class PluginTopStoryUI$2
  implements Runnable
{
  PluginTopStoryUI$2(PluginTopStoryUI paramPluginTopStoryUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(125855);
    d locald = PluginTopStoryUI.access$000(this.BJl);
    k localk = new k(h.ess());
    int i;
    int k;
    Object localObject;
    if (localk.exists())
    {
      k[] arrayOfk = localk.fTj();
      if ((arrayOfk != null) && (arrayOfk.length > 0))
      {
        j = arrayOfk.length;
        i = 0;
        if (i < j)
        {
          localk = arrayOfk[i];
          k = bu.getInt(localk.getName(), -1);
          don localdon;
          if (k > 0) {
            localdon = new don();
          }
          for (;;)
          {
            try
            {
              localObject = o.bb(w.B(localk.fTh()), 0, -1);
              localdon.parseFrom((byte[])localObject);
              locald.BLf.put(Integer.valueOf(k), localdon);
              ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(localObject.length) });
              i += 1;
            }
            catch (Exception localException1)
            {
              ae.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException1, "loadHomeDataCache %s", new Object[] { localk.fTi() });
              continue;
            }
            ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", new Object[] { w.B(localk.fTh()) });
          }
        }
      }
      else
      {
        ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", new Object[] { w.B(localk.fTh()) });
      }
      locald = PluginTopStoryUI.access$000(this.BJl);
      localk = new k(h.est());
      if (!localk.exists()) {
        break label502;
      }
      arrayOfk = localk.fTj();
      if ((arrayOfk == null) || (arrayOfk.length <= 0)) {
        break label474;
      }
      int j = arrayOfk.length;
      i = 0;
      label290:
      if (i >= j) {
        break label468;
      }
      localk = arrayOfk[i];
      k = bu.getInt(localk.getName(), -1);
      if (k <= 0) {
        break label443;
      }
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = o.bb(w.B(localk.fTh()), 0, -1);
        localObject = new String(arrayOfByte, "utf-8");
        locald.BLg.put(Integer.valueOf(k), localObject);
        ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
        i += 1;
        break label290;
        ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", new Object[] { w.B(localk.fTh()) });
      }
      catch (Exception localException2)
      {
        ae.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException2, "loadNegDataCache %s", new Object[] { localk.fTi() });
        continue;
      }
      label443:
      ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", new Object[] { w.B(localk.fTh()) });
    }
    label468:
    AppMethodBeat.o(125855);
    return;
    label474:
    ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", new Object[] { w.B(localk.fTh()) });
    AppMethodBeat.o(125855);
    return;
    label502:
    ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", new Object[] { w.B(localk.fTh()) });
    AppMethodBeat.o(125855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.2
 * JD-Core Version:    0.7.0.1
 */