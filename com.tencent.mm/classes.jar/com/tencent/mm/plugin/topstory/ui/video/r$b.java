package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.protobuf.foi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

final class r$b
  implements f
{
  private foi TNF;
  
  private r$b(r paramr) {}
  
  public final void a(f.a parama) {}
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126209);
    if ((this.TNF != null) && (paramInt1 + paramInt2 <= this.TNF.abOQ)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramInt1 == 0) && (bool1) && (this.TNB.TLn != null))
      {
        com.tencent.mm.plugin.topstory.a.b.b localb = this.TNB.TLn.hNx().TNp;
        if ((localb != null) && (localb.TIS == 0L))
        {
          localb.TIS = (System.currentTimeMillis() - localb.TIB);
          localb.TIT = paramInt1;
          localb.TIU = (paramInt1 + paramInt2);
          Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "firstDataAvailable %d %d %d", new Object[] { Long.valueOf(localb.TIO), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
      }
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = v.bOi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      }
      AppMethodBeat.o(126209);
      return bool2;
    }
  }
  
  public final void js(String paramString)
  {
    AppMethodBeat.i(126207);
    v.bOi().l(paramString, null);
    AppMethodBeat.o(126207);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126208);
    if ((this.TNF != null) && (paramInt1 + paramInt2 <= this.TNF.abOQ))
    {
      AppMethodBeat.o(126208);
      return;
    }
    v.bOi();
    j.v(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(126208);
  }
  
  public final void w(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(126206);
    Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startHttpStream %s %s", new Object[] { paramString1, paramString2 });
    if (this.TNB.TLn == null)
    {
      AppMethodBeat.o(126206);
      return;
    }
    Object localObject2 = this.TNB.TLn.hNA();
    Object localObject3 = ((m)localObject2).TLn.hNx().TNp;
    Object localObject1;
    boolean bool;
    if (localObject3 != null)
    {
      if (!((m)localObject2).TMW.containsKey(paramString1)) {
        break label510;
      }
      localObject1 = (foi)((m)localObject2).TMW.get(paramString1);
      if (((foi)localObject1).abOR >= 5L)
      {
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s percent %d offset %s", new Object[] { paramString1, Long.valueOf(((foi)localObject1).abOR), Util.getSizeMB(((foi)localObject1).abOQ) });
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).TIJ = 1L;
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).TIK = ((foi)localObject1).abOR;
        ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).TIL = ((foi)localObject1).abOQ;
        a.rG(25);
        this.TNF = ((foi)localObject1);
        localObject1 = new r.a(this.TNB, (byte)0);
        if (this.TNF == null) {
          break label563;
        }
        localObject2 = new long[2];
        if (this.TNF.abOR >= 100L) {
          break label542;
        }
        v.bOi().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
        localObject3 = new CdnLogic.C2CDownloadRequest();
        ((CdnLogic.C2CDownloadRequest)localObject3).fileKey = paramString1;
        ((CdnLogic.C2CDownloadRequest)localObject3).fileType = 90;
        ((CdnLogic.C2CDownloadRequest)localObject3).url = paramString3;
        ((CdnLogic.C2CDownloadRequest)localObject3).setSavePath(paramString2);
        bool = CdnLogic.queryVideoMoovInfo((CdnLogic.C2CDownloadRequest)localObject3, (long[])localObject2);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "moov check mediaId %s ret %b", new Object[] { paramString1, Boolean.valueOf(bool) });
      if ((bool) && (!((r.a)localObject1).TNC)) {
        ((r.a)localObject1).a(paramString1, (int)localObject2[0], (int)localObject2[1], "");
      }
      if (r.bv(this.TNF.abOR, this.TNF.abOQ)) {
        ((r.a)localObject1).hOI();
      }
      paramString2 = this.TNB.TLn.hNx().TNp;
      if (paramString2 != null) {
        paramString2.TIV = this.TNF.abOC;
      }
      if (this.TNF.abOR == 100L)
      {
        ((r.a)localObject1).h(paramString1, (int)this.TNF.abOQ, (int)this.TNF.abOC);
        ((r.a)localObject1).a(paramString1, 0, null);
      }
      AppMethodBeat.o(126206);
      return;
      Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "hit preload cache %s but preload percent too small %d offset %s", new Object[] { paramString1, Long.valueOf(((foi)localObject1).abOR), Util.getSizeMB(((foi)localObject1).abOQ) });
      ((com.tencent.mm.plugin.topstory.a.b.b)localObject3).TIJ = 3L;
      for (;;)
      {
        ((m)localObject2).hOy();
        localObject1 = null;
        break;
        label510:
        localObject1 = new foi();
        ((foi)localObject1).mediaId = paramString1;
        ((m)localObject2).TMW.put(paramString1, localObject1);
      }
      label542:
      bool = true;
      localObject2[0] = new com.tencent.mm.plugin.a.b().Sl(paramString2);
    }
    label563:
    v.bOi().a(r.a(paramString1, paramString3, paramString2, (r.a)localObject1), false);
    AppMethodBeat.o(126206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.b
 * JD-Core Version:    0.7.0.1
 */