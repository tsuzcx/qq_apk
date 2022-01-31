package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.b.a.au;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "isMoovReady", "", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "onDataAvailable", "", "mediaId", "offset", "", "length", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "onProgress", "total", "setIEngineCallback", "callback", "setVideoCache", "vitem", "plugin-story_release"})
final class q$a
  implements h.a
{
  final String TAG = "MicroMsg.VideoPlayProxy";
  b.a ibL;
  volatile boolean sUU;
  com.tencent.mm.plugin.story.model.d.i sUW;
  n sVy;
  
  public final void a(n paramn, com.tencent.mm.plugin.story.model.d.i parami)
  {
    this.sVy = paramn;
    this.sUW = parami;
  }
  
  public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
  {
    int j = 0;
    Object localObject2 = null;
    AppMethodBeat.i(110969);
    j.q(paramString, "mediaId");
    Object localObject3 = this.TAG;
    Object localObject1 = new StringBuilder("onFinish, mediaId:").append(paramString).append(", ret:").append(paramInt).append(", sceneResult:");
    int i;
    label106:
    long l;
    if (paramd != null)
    {
      i = paramd.field_retCode;
      StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" this:").append(this).append(" currVideoItem:");
      localObject1 = this.sVz.sUp;
      if (localObject1 == null) {
        break label553;
      }
      localObject1 = ((com.tencent.mm.plugin.story.model.d.i)localObject1).username;
      ab.i((String)localObject3, (String)localObject1);
      localObject1 = this.sUW;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.plugin.story.g.b.sDR;
        com.tencent.mm.plugin.story.g.b.mH(((com.tencent.mm.plugin.story.model.d.i)localObject1).cJA);
        p.sUH.mZ(((com.tencent.mm.plugin.story.model.d.i)localObject1).cJA);
      }
      localObject1 = this.sVy;
      if (localObject1 == null) {
        break label559;
      }
      localObject1 = ((n)localObject1).field_filePath;
      label174:
      localObject1 = com.tencent.mm.plugin.sight.base.d.Zo((String)localObject1);
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDE().cb(((com.tencent.mm.plugin.sight.base.a)localObject1).eVA);
        localObject3 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDE().cc(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate);
        localObject3 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDE().cd(((com.tencent.mm.plugin.sight.base.a)localObject1).fzT);
        localObject3 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDE().ce(((com.tencent.mm.plugin.sight.base.a)localObject1).eRw);
        localObject3 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDE().cf(((com.tencent.mm.plugin.sight.base.a)localObject1).width);
        localObject3 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDE().cg(((com.tencent.mm.plugin.sight.base.a)localObject1).height);
        localObject3 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDE().ch(((com.tencent.mm.plugin.sight.base.a)localObject1).qSh);
      }
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      localObject1 = com.tencent.mm.plugin.story.g.i.cDE();
      if (this.sVy == null) {
        break label565;
      }
      localObject3 = this.sVy;
      if (localObject3 == null) {
        j.ebi();
      }
      l = ((n)localObject3).field_totalSize;
      label351:
      ((au)localObject1).ca(l);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      localObject3 = com.tencent.mm.plugin.story.g.i.cDE();
      localObject1 = this.sVy;
      if (localObject1 == null) {
        break label571;
      }
      localObject1 = ((n)localObject1).field_url;
      label387:
      ((au)localObject3).gg((String)localObject1);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      localObject3 = com.tencent.mm.plugin.story.g.i.cDE();
      f.afP();
      localObject1 = this.sVy;
      if (localObject1 == null) {
        break label577;
      }
    }
    label553:
    label559:
    label565:
    label571:
    label577:
    for (localObject1 = ((n)localObject1).field_filePath;; localObject1 = null)
    {
      ((au)localObject3).gh(com.tencent.mm.al.a.sE((String)localObject1));
      if (paramd != null)
      {
        localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDE().bY(paramd.field_startTime);
        localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDE().bZ(paramd.field_endTime);
      }
      localObject1 = localObject2;
      if (paramd != null) {
        localObject1 = paramd.field_usedSvrIps;
      }
      if (localObject1 == null) {
        break label599;
      }
      localObject1 = new StringBuffer();
      paramd = paramd.field_usedSvrIps;
      int k = paramd.length;
      i = j;
      while (i < k)
      {
        ((StringBuffer)localObject1).append(paramd[i]).append("|");
        i += 1;
      }
      i = 0;
      break;
      localObject1 = null;
      break label106;
      localObject1 = null;
      break label174;
      l = 0L;
      break label351;
      localObject1 = null;
      break label387;
    }
    paramd = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDE().gi(((StringBuffer)localObject1).toString());
    label599:
    if (this.sVz.sVt != null)
    {
      paramd = com.tencent.mm.plugin.story.g.i.sFa;
      paramd = com.tencent.mm.plugin.story.g.i.cDE();
      localObject1 = this.sVz.sVt;
      if (localObject1 == null) {
        j.ebi();
      }
      paramd.ci(((q.b)localObject1).czu);
      paramd = com.tencent.mm.plugin.story.g.i.sFa;
      paramd = com.tencent.mm.plugin.story.g.i.cDE();
      localObject1 = this.sVz.sVt;
      if (localObject1 == null) {
        j.ebi();
      }
      if (!((q.b)localObject1).sUV) {
        break label719;
      }
      l = 3L;
    }
    for (;;)
    {
      paramd.cj(l);
      paramd = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDF();
      com.tencent.mm.ab.b.b((a.f.a.a)new q.a.b(this, paramString, paramInt));
      AppMethodBeat.o(110969);
      return;
      label719:
      localObject1 = this.sVz.sVt;
      if (localObject1 == null) {
        j.ebi();
      }
      if (((q.b)localObject1).czu > 0) {
        l = 2L;
      } else {
        l = 1L;
      }
    }
  }
  
  public final void l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110966);
    j.q(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onMoovReady, mediaId:").append(paramString).append(", offset:").append(paramInt1).append(", length:").append(paramInt2).append(", isMoovReady:").append(this.sUU).append(" this:").append(this).append(" currVideoItem:");
    Object localObject = this.sVz.sUp;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.story.model.d.i)localObject).username;; localObject = null)
    {
      ab.i(str, (String)localObject);
      if (!this.sUU) {
        break;
      }
      AppMethodBeat.o(110966);
      return;
    }
    this.sUU = true;
    com.tencent.mm.ab.b.b((a.f.a.a)new q.a.c(this, paramString, paramInt1, paramInt2));
    AppMethodBeat.o(110966);
  }
  
  public final void m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110967);
    j.q(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onDataAvailable, mediaId:").append(paramString).append(", offset:").append(paramInt1).append(", length:").append(paramInt2).append(" this:").append(this).append(" currVideoItem:");
    Object localObject = this.sVz.sUp;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.story.model.d.i)localObject).username;; localObject = null)
    {
      ab.i(str, (String)localObject);
      com.tencent.mm.ab.b.b((a.f.a.a)new q.a.a(this, paramString, paramInt1, paramInt2));
      AppMethodBeat.o(110967);
      return;
    }
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110968);
    j.q(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onProgress, mediaId:").append(paramString).append(", offset:").append(paramInt1).append(", total:").append(paramInt2).append(" this:").append(this).append(" currVideoItem:");
    Object localObject = this.sVz.sUp;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.story.model.d.i)localObject).username;; localObject = null)
    {
      ab.i(str, (String)localObject);
      com.tencent.mm.ab.b.b((a.f.a.a)new q.a.d(this, paramString, paramInt1, paramInt2));
      AppMethodBeat.o(110968);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.q.a
 * JD-Core Version:    0.7.0.1
 */