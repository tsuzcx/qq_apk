package com.tencent.mm.ui.chatting.gallery;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ra;
import com.tencent.mm.autogen.a.ra.a;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

class ImageGalleryVideoHandler$12
  extends IListener<ra>
{
  ImageGalleryVideoHandler$12(p paramp, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(254573);
    this.__eventId = ra.class.getName().hashCode();
    AppMethodBeat.o(254573);
  }
  
  private boolean a(ra paramra)
  {
    AppMethodBeat.i(36246);
    if (!p.f(this.aeEH).bay(paramra.hTZ.mediaId))
    {
      AppMethodBeat.o(36246);
      return false;
    }
    if ((paramra.hTZ.retCode != 0) && (paramra.hTZ.retCode != -21006))
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramra.hTZ.retCode);
      p.a(this.aeEH, paramra.hTZ.mediaId, paramra.hTZ.retCode);
      AppMethodBeat.o(36246);
      return false;
    }
    switch (paramra.hTZ.hId)
    {
    default: 
      Log.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramra.hTZ.hId);
    }
    for (;;)
    {
      AppMethodBeat.o(36246);
      return false;
      v localv = p.f(this.aeEH);
      long l2 = paramra.hTZ.offset;
      long l1 = paramra.hTZ.hUa;
      boolean bool = paramra.hTZ.hUb;
      Log.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localv.oYw), Integer.valueOf(localv.oYv), Long.valueOf(l1), Long.valueOf(localv.lxf) });
      if (localv.oYv != 0) {
        Log.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
      }
      for (;;)
      {
        p.a(this.aeEH, true);
        break;
        if (l1 > localv.lxf) {}
        for (;;)
        {
          for (;;)
          {
            localv.lxf = l1;
            h.OAn.idkeyStat(354L, 5L, 1L, false);
            localv.RhK = Util.nowMilliSecond();
            com.tencent.mm.modelvideo.v.bOh();
            paramra = aa.PX(localv.filename);
            try
            {
              if (localv.RhG != null) {
                break label435;
              }
              Log.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
            }
            catch (Exception paramra)
            {
              Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramra, "", new Object[0]);
              Log.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramra.toString());
            }
          }
          break;
          l1 = localv.lxf;
        }
        label435:
        if (localv.RhG.O(paramra, l2))
        {
          localv.oYv = localv.RhG.pEg;
          Log.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(localv.oYv), localv.filename, Boolean.valueOf(bool) });
          if (!bool) {
            MMHandlerThread.postToMainThread(new v.1(localv));
          }
          if (localv.oYw == -1) {}
          for (localv.oYt = 1;; localv.oYt = 2)
          {
            h.OAn.idkeyStat(354L, 7L, 1L, false);
            break;
          }
        }
        Log.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
        com.tencent.mm.modelvideo.v.bOi();
        com.tencent.mm.modelcdntran.j.v(localv.mediaId, 0, -1);
        ab.bf(localv.filename, 15);
        h.OAn.idkeyStat(354L, 8L, 1L, false);
        Log.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localv.hashCode()), localv.filename });
        h.OAn.b(13836, new Object[] { Integer.valueOf(302), Long.valueOf(Util.nowSecond()), "" });
      }
      localv = p.f(this.aeEH);
      Object localObject = paramra.hTZ.mediaId;
      int i = paramra.hTZ.offset;
      int j = paramra.hTZ.length;
      localv.oYC = false;
      if ((i < 0) || (j < 0)) {
        Log.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
      while (!localv.bay((String)localObject))
      {
        if (paramra.hTZ.length <= 0) {
          break;
        }
        this.aeEH.ho(true);
        break;
      }
      localObject = localv.mediaId + i + "_" + j;
      localObject = (Integer)localv.RhF.get(localObject);
      if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
        localv.oYz = ((Integer)localObject).intValue();
      }
      for (;;)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localv.oYz) });
        break;
        try
        {
          localv.oYz = localv.RhG.eX(i, j);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
          Log.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
        }
      }
      this.aeEH.ho(true);
      continue;
      paramra = p.f(this.aeEH);
      Log.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramra.oYt) });
      paramra.oYC = false;
      paramra.oYs = 3;
      if (paramra.oYt == 0)
      {
        Log.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
        paramra.hmV();
        h.OAn.idkeyStat(354L, 6L, 1L, false);
      }
      for (;;)
      {
        paramra.hKF();
        h.OAn.idkeyStat(354L, 26L, 1L, false);
        this.aeEH.ho(true);
        break;
        if (paramra.oYt == 5)
        {
          Log.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramra.mediaId);
          paramra.hmV();
        }
      }
      localv = p.f(this.aeEH);
      String str = paramra.hTZ.mediaId;
      i = paramra.hTZ.offset;
      if (localv.bay(str))
      {
        if (localv.qEw != 0) {
          localv.RhI = (i * 100 / localv.qEw);
        }
        Log.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + localv.RhI);
      }
      if (localv.RhI >= 100)
      {
        localv.oYs = 3;
        continue;
        paramra = p.f(this.aeEH);
        Log.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
        paramra.hKF();
        paramra.hmV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryVideoHandler.12
 * JD-Core Version:    0.7.0.1
 */