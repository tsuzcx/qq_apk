package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class r$b
  implements com.tencent.mm.modelvideo.b
{
  private cky tkc;
  
  private r$b(r paramr) {}
  
  public final void a(b.a parama) {}
  
  public final void er(String paramString)
  {
    AppMethodBeat.i(1833);
    com.tencent.mm.modelvideo.o.alF().j(paramString, null);
    AppMethodBeat.o(1833);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1835);
    if ((this.tkc != null) && (paramInt1 + paramInt2 <= this.tkc.xVt)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramInt1 == 0) && (bool1) && (this.tjY.thM != null))
      {
        com.tencent.mm.plugin.topstory.a.b.a locala = this.tjY.thM.cJd().tjL;
        if ((locala != null) && (locala.tfj == 0L))
        {
          locala.tfj = (System.currentTimeMillis() - locala.teT);
          locala.tfk = paramInt1;
          locala.tfl = (paramInt1 + paramInt2);
          ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[] { Long.valueOf(locala.tfg), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
      }
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = com.tencent.mm.modelvideo.o.alF().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      }
      AppMethodBeat.o(1835);
      return bool2;
    }
  }
  
  public final void r(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(1832);
    ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[] { paramString1, paramString2 });
    Object localObject2 = this.tjY.thM.cJg();
    Object localObject3 = ((m)localObject2).thM.cJd().tjL;
    Object localObject1;
    boolean bool;
    if (localObject3 != null)
    {
      if (!((m)localObject2).tjq.containsKey(paramString1)) {
        break label458;
      }
      localObject1 = (cky)((m)localObject2).tjq.get(paramString1);
      if (((cky)localObject1).xVu >= 5L)
      {
        ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[] { paramString1, Long.valueOf(((cky)localObject1).xVu), bo.nV(((cky)localObject1).xVt) });
        ((com.tencent.mm.plugin.topstory.a.b.a)localObject3).tfb = 1L;
        ((com.tencent.mm.plugin.topstory.a.b.a)localObject3).tfc = ((cky)localObject1).xVu;
        ((com.tencent.mm.plugin.topstory.a.b.a)localObject3).tfd = ((cky)localObject1).xVt;
        com.tencent.mm.plugin.websearch.api.a.a.kS(25);
        this.tkc = ((cky)localObject1);
        localObject1 = new r.a(this.tjY, (byte)0);
        if (this.tkc == null) {
          break label511;
        }
        localObject2 = new long[2];
        if (this.tkc.xVu >= 100L) {
          break label490;
        }
        com.tencent.mm.modelvideo.o.alF().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
        localObject3 = new CdnLogic.C2CDownloadRequest();
        ((CdnLogic.C2CDownloadRequest)localObject3).fileKey = paramString1;
        ((CdnLogic.C2CDownloadRequest)localObject3).fileType = 90;
        ((CdnLogic.C2CDownloadRequest)localObject3).url = paramString3;
        ((CdnLogic.C2CDownloadRequest)localObject3).savePath = paramString2;
        bool = CdnLogic.queryVideoMoovInfo((CdnLogic.C2CDownloadRequest)localObject3, (long[])localObject2);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", new Object[] { paramString1, Boolean.valueOf(bool) });
      if ((bool) && (!((r.a)localObject1).tjZ)) {
        ((r.a)localObject1).l(paramString1, (int)localObject2[0], (int)localObject2[1]);
      }
      if (r.ad(this.tkc.xVu, this.tkc.xVt)) {
        ((r.a)localObject1).cKk();
      }
      if (this.tkc.xVu == 100L)
      {
        ((r.a)localObject1).n(paramString1, (int)this.tkc.xVt, (int)this.tkc.xVi);
        ((r.a)localObject1).a(paramString1, 0, null);
      }
      AppMethodBeat.o(1832);
      return;
      ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[] { paramString1, Long.valueOf(((cky)localObject1).xVu), bo.nV(((cky)localObject1).xVt) });
      ((com.tencent.mm.plugin.topstory.a.b.a)localObject3).tfb = 3L;
      for (;;)
      {
        ((m)localObject2).cKa();
        localObject1 = null;
        break;
        label458:
        localObject1 = new cky();
        ((cky)localObject1).cBO = paramString1;
        ((m)localObject2).tjq.put(paramString1, localObject1);
      }
      label490:
      bool = true;
      localObject2[0] = new com.tencent.mm.plugin.a.b().wD(paramString2);
    }
    label511:
    com.tencent.mm.modelvideo.o.alF().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
    AppMethodBeat.o(1832);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1834);
    if ((this.tkc != null) && (paramInt1 + paramInt2 <= this.tkc.xVt))
    {
      AppMethodBeat.o(1834);
      return;
    }
    com.tencent.mm.modelvideo.o.alF();
    e.r(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(1834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.b
 * JD-Core Version:    0.7.0.1
 */