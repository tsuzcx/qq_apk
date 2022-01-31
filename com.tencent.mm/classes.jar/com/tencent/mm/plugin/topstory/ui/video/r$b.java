package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mm.ak.e;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.protocal.c.byh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class r$b
  implements com.tencent.mm.modelvideo.b
{
  private byh pGI;
  
  private r$b(r paramr) {}
  
  public final void a(b.a parama) {}
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.pGI != null) && (paramInt1 + paramInt2 <= this.pGI.tOL)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramInt1 == 0) && (bool1) && (this.pGD.pEp != null))
      {
        com.tencent.mm.plugin.topstory.a.b.a locala = this.pGD.pEp.bNt().pGq;
        if ((locala != null) && (locala.pDu == 0L))
        {
          locala.pDu = (System.currentTimeMillis() - locala.pDe);
          locala.pDv = paramInt1;
          locala.pDw = (paramInt1 + paramInt2);
          y.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[] { Long.valueOf(locala.pDr), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
      }
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = com.tencent.mm.modelvideo.o.Ss().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      }
      return bool2;
    }
  }
  
  public final void j(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.pGI != null) && (paramInt1 + paramInt2 <= this.pGI.tOL)) {
      return;
    }
    com.tencent.mm.modelvideo.o.Ss();
    e.h(paramString, paramInt1, paramInt2);
  }
  
  public final void nF(String paramString)
  {
    com.tencent.mm.modelvideo.o.Ss().k(paramString, null);
  }
  
  public final void p(String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[] { paramString1, paramString2 });
    Object localObject2 = this.pGD.pEp.bNw();
    Object localObject3 = ((m)localObject2).pEp.bNt().pGq;
    Object localObject1;
    boolean bool;
    if (localObject3 != null)
    {
      if (!((m)localObject2).pFS.containsKey(paramString1)) {
        break label445;
      }
      localObject1 = (byh)((m)localObject2).pFS.get(paramString1);
      if (((byh)localObject1).tOM >= 5L)
      {
        y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[] { paramString1, Long.valueOf(((byh)localObject1).tOM), bk.ht(((byh)localObject1).tOL) });
        ((com.tencent.mm.plugin.topstory.a.b.a)localObject3).pDm = 1L;
        ((com.tencent.mm.plugin.topstory.a.b.a)localObject3).pDn = ((byh)localObject1).tOM;
        ((com.tencent.mm.plugin.topstory.a.b.a)localObject3).pDo = ((byh)localObject1).tOL;
        com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(25);
        this.pGI = ((byh)localObject1);
        localObject1 = new r.a(this.pGD, (byte)0);
        if (this.pGI == null) {
          break label498;
        }
        localObject2 = new long[2];
        if (this.pGI.tOM >= 100L) {
          break label477;
        }
        com.tencent.mm.modelvideo.o.Ss().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
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
      y.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", new Object[] { paramString1, Boolean.valueOf(bool) });
      if ((bool) && (!((r.a)localObject1).pGE)) {
        ((r.a)localObject1).onMoovReady(paramString1, (int)localObject2[0], (int)localObject2[1]);
      }
      if (r.O(this.pGI.tOM, this.pGI.tOL)) {
        ((r.a)localObject1).bOv();
      }
      if (this.pGI.tOM == 100L)
      {
        ((r.a)localObject1).e(paramString1, (int)this.pGI.tOL, (int)this.pGI.tOF);
        ((r.a)localObject1).x(paramString1, 0);
      }
      return;
      y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[] { paramString1, Long.valueOf(((byh)localObject1).tOM), bk.ht(((byh)localObject1).tOL) });
      ((com.tencent.mm.plugin.topstory.a.b.a)localObject3).pDm = 3L;
      for (;;)
      {
        ((m)localObject2).bOo();
        localObject1 = null;
        break;
        label445:
        localObject1 = new byh();
        ((byh)localObject1).bUi = paramString1;
        ((m)localObject2).pFS.put(paramString1, localObject1);
      }
      label477:
      bool = true;
      localObject2[0] = new com.tencent.mm.plugin.a.b().po(paramString2);
    }
    label498:
    com.tencent.mm.modelvideo.o.Ss().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.b
 * JD-Core Version:    0.7.0.1
 */