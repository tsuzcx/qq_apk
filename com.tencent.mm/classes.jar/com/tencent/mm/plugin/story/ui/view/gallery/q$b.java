package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.story.e.c.a;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;
import java.util.Map;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;)V", "TAG", "", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadFinish", "", "getPreloadFinish", "()Z", "setPreloadFinish", "(Z)V", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "videoCache", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "createReportRptTips", "", "", "()[Ljava/lang/Object;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "callback", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$VideoPlayCdnCallback;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "isVideoDataAvailable", "offset", "length", "requestVideoData", "", "setIEngineCallback", "setStoryVideoItem", "startHttpStream", "stop", "plugin-story_release"})
final class q$b
  implements com.tencent.mm.modelvideo.b
{
  final String TAG = "MicroMsg.VideoPlayProxy";
  int czu;
  private com.tencent.mm.modelvideo.b.a ibL;
  boolean sUV;
  com.tencent.mm.plugin.story.model.d.i sUW;
  n sVy;
  
  public final void a(com.tencent.mm.modelvideo.b.a parama)
  {
    this.ibL = parama;
  }
  
  public final void er(String paramString)
  {
    int k = 2;
    int j = 1;
    com.tencent.mm.plugin.story.model.d.i locali = null;
    AppMethodBeat.i(110973);
    a.f.b.j.q(paramString, "mediaId");
    ab.i(this.TAG, "this: " + this + " stop " + paramString + ' ' + bo.dtY());
    Object[] arrayOfObject = new Object[17];
    Object localObject1 = this.sVz.sVs;
    label124:
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getCurrPosMs());
      arrayOfObject[0] = localObject1;
      localObject1 = this.sVz.sVs;
      if (localObject1 == null) {
        break label588;
      }
      localObject1 = Integer.valueOf((int)((StoryVideoView)localObject1).getFirstPlayWaitTime());
      arrayOfObject[1] = localObject1;
      localObject1 = this.sVz.sVs;
      if (localObject1 == null) {
        break label594;
      }
      localObject1 = Integer.valueOf(((StoryVideoView)localObject1).cGt());
      label154:
      arrayOfObject[2] = localObject1;
      localObject1 = this.sVz.sVs;
      if (localObject1 == null) {
        break label600;
      }
      localObject1 = Integer.valueOf(((StoryVideoView)localObject1).cGu());
      label184:
      arrayOfObject[3] = localObject1;
      localObject1 = this.sVz.sVs;
      if (localObject1 == null) {
        break label606;
      }
      localObject1 = Integer.valueOf(((StoryVideoView)localObject1).cGv());
      label214:
      arrayOfObject[4] = localObject1;
      localObject1 = this.sVz.sVs;
      if (localObject1 == null) {
        break label612;
      }
      localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getStayTime());
      label244:
      arrayOfObject[5] = localObject1;
      localObject1 = this.sVz.sVs;
      if (localObject1 == null) {
        break label618;
      }
      localObject1 = Integer.valueOf(((StoryVideoView)localObject1).getErrorCode());
      label274:
      arrayOfObject[6] = localObject1;
      arrayOfObject[7] = Integer.valueOf(this.czu);
      if (this.czu <= 0) {
        break label624;
      }
      i = 2;
      label302:
      arrayOfObject[8] = Integer.valueOf(i);
      i = k;
      if (this.sUV) {
        i = 3;
      }
      arrayOfObject[9] = Integer.valueOf(i);
      localObject1 = com.tencent.mm.plugin.story.e.c.ssB;
      localObject1 = this.sVz.sVs;
      if (localObject1 != null)
      {
        localObject2 = ((StoryVideoView)localObject1).getFilePath();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      arrayOfObject[10] = c.a.acO((String)localObject1);
      Object localObject2 = this.sUW;
      localObject1 = locali;
      if (localObject2 != null) {
        localObject1 = Long.valueOf(((com.tencent.mm.plugin.story.model.d.i)localObject2).cJA);
      }
      arrayOfObject[11] = localObject1;
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      arrayOfObject[12] = Long.valueOf(com.tencent.mm.plugin.story.g.i.cDo().FF());
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      arrayOfObject[13] = Long.valueOf(com.tencent.mm.plugin.story.g.i.cDo().FH());
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      if (com.tencent.mm.plugin.story.g.i.cDo().FK() != 1L) {
        break label629;
      }
      i = j;
      label469:
      arrayOfObject[14] = Integer.valueOf(i);
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAB();
      locali = this.sUW;
      if (locali == null) {
        break label634;
      }
    }
    label588:
    label594:
    label600:
    label606:
    label612:
    label618:
    label624:
    label629:
    label634:
    for (long l = locali.cJA;; l = 0L)
    {
      arrayOfObject[15] = Integer.valueOf(((k)localObject1).mW(l));
      arrayOfObject[16] = Integer.valueOf(this.sVz.sVv);
      ab.i(this.TAG, "reportTips: " + Arrays.toString(arrayOfObject));
      com.tencent.mm.modelvideo.o.alF().h(paramString, arrayOfObject);
      AppMethodBeat.o(110973);
      return;
      localObject1 = Integer.valueOf(0);
      break;
      localObject1 = null;
      break label124;
      localObject1 = null;
      break label154;
      localObject1 = null;
      break label184;
      localObject1 = null;
      break label214;
      localObject1 = null;
      break label244;
      localObject1 = null;
      break label274;
      i = 1;
      break label302;
      i = 0;
      break label469;
    }
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    String str2 = null;
    String str1 = null;
    AppMethodBeat.i(110975);
    a.f.b.j.q(paramString, "mediaId");
    Object localObject1 = this.sUW;
    if (localObject1 != null)
    {
      localObject2 = s.swk;
      this.sVy = s.a((com.tencent.mm.plugin.story.model.d.i)localObject1);
      localObject1 = this.sVy;
      if ((localObject1 != null) && (((n)localObject1).Jo() == true))
      {
        str2 = this.TAG;
        localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", download finish cacheSize:");
        localObject2 = this.sVy;
        paramString = str1;
        if (localObject2 != null) {
          paramString = Integer.valueOf(((n)localObject2).field_cacheSize);
        }
        ab.i(str2, paramString + " this:" + this);
        AppMethodBeat.o(110975);
        return true;
      }
    }
    boolean bool = com.tencent.mm.modelvideo.o.alF().isVideoDataAvailable(paramString, paramInt1, paramInt2);
    str1 = this.TAG;
    localObject1 = new StringBuilder("isVideoDataAvailable ").append(paramString).append(", ").append(paramInt1).append(", ").append(paramInt2).append(", available:").append(bool).append(" cacheSize:");
    Object localObject2 = this.sVy;
    paramString = str2;
    if (localObject2 != null) {
      paramString = Integer.valueOf(((n)localObject2).field_cacheSize);
    }
    ab.i(str1, paramString + " this:" + this);
    AppMethodBeat.o(110975);
    return bool;
  }
  
  public final void p(com.tencent.mm.plugin.story.model.d.i parami)
  {
    AppMethodBeat.i(110971);
    a.f.b.j.q(parami, "item");
    this.sUW = parami;
    s locals = s.swk;
    this.sVy = s.a(parami);
    ab.i(this.TAG, "setStoryVideoItem " + parami + " videoCache " + this.sVy);
    AppMethodBeat.o(110971);
  }
  
  public final void r(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(110972);
    ab.i(this.TAG, "startHttpStream " + paramString1 + ' ' + paramString2 + ' ' + paramString3 + " this:" + this);
    Object localObject1;
    Object localObject3;
    Object localObject4;
    boolean bool;
    if (this.sUW != null)
    {
      localObject1 = s.swk;
      localObject1 = this.sUW;
      if (localObject1 == null) {
        a.f.b.j.ebi();
      }
      this.sVy = s.a((com.tencent.mm.plugin.story.model.d.i)localObject1);
      localObject1 = this.sVy;
      if ((localObject1 != null) && (!com.tencent.mm.vfs.e.cN(((n)localObject1).field_filePath)))
      {
        localObject3 = com.tencent.mm.plugin.story.model.l.svv;
        localObject3 = ((n)localObject1).field_filePath;
        a.f.b.j.p(localObject3, "it.field_filePath");
        com.tencent.mm.plugin.story.model.l.add((String)localObject3);
        ab.i(this.TAG, "startHttpStream error downloadFinish " + ((n)localObject1).Jo() + " ret:" + com.tencent.mm.vfs.e.cN(((n)localObject1).field_filePath) + " path:" + ((n)localObject1).field_filePath);
        ((n)localObject1).cFl();
        localObject3 = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAF().b((n)localObject1);
      }
      localObject1 = this.sVz.sUp;
      long l;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.plugin.story.g.c.sEl;
        com.tencent.mm.plugin.story.g.c.cCG();
        localObject3 = com.tencent.mm.plugin.story.g.b.sDR;
        l = ((com.tencent.mm.plugin.story.model.d.i)localObject1).cJA;
        if (com.tencent.mm.plugin.story.g.b.aiY())
        {
          ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "startHttp storyId ".concat(String.valueOf(l)));
          if (com.tencent.mm.plugin.story.g.b.sDD.containsKey(Long.valueOf(l)))
          {
            localObject1 = (com.tencent.mm.plugin.story.g.b.a)com.tencent.mm.plugin.story.g.b.sDD.get(Long.valueOf(l));
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.story.g.b.a)localObject1).sDV = true;
            }
          }
        }
      }
      localObject1 = this.sUW;
      if (localObject1 == null) {
        break label880;
      }
      localObject1 = ((com.tencent.mm.plugin.story.model.d.i)localObject1).syB;
      if (localObject1 == null) {
        break label880;
      }
      localObject1 = ((chl)localObject1).Url;
      if (!bo.isNullOrNil((String)localObject1))
      {
        localObject1 = this.sVz;
        ((q)localObject1).sVv += 1;
        localObject1 = ((q)localObject1).sVs;
        if (localObject1 != null) {
          ((StoryVideoView)localObject1).setNeedShowLoading(true);
        }
        localObject1 = new q.a(this.sVz);
        ((q.a)localObject1).ibL = this.ibL;
        ((q.a)localObject1).a(this.sVy, this.sUW);
        localObject3 = new h();
        localObject4 = new q.a(this.sVz);
        ((q.a)localObject4).ibL = this.ibL;
        ((q.a)localObject4).a(this.sVy, this.sUW);
        ((h)localObject3).field_mediaId = paramString1;
        ((h)localObject3).url = paramString3;
        ((h)localObject3).edJ = 1;
        ((h)localObject3).edE = 6;
        ((h)localObject3).concurrentCount = 4;
        ((h)localObject3).field_fullpath = paramString2;
        ((h)localObject3).edQ = ((h.a)localObject1);
        ((h)localObject3).field_fileType = com.tencent.mm.i.a.ecN;
        ((h)localObject3).field_requestVideoFormat = d.y(1, paramString2);
        paramString2 = p.sUH;
        paramString2 = this.sUW;
        if (paramString2 == null) {
          a.f.b.j.ebi();
        }
        p.k(paramString2);
        paramString2 = this.sVz.sUp;
        if (paramString2 != null)
        {
          paramString3 = com.tencent.mm.plugin.story.g.b.sDR;
          l = paramString2.cJA;
          if (this.sVy != null)
          {
            paramString2 = this.sVy;
            if ((paramString2 == null) || (paramString2.field_cacheSize != 0)) {
              break label886;
            }
          }
          bool = true;
          label612:
          com.tencent.mm.plugin.story.g.b.A(l, bool);
        }
        com.tencent.mm.modelvideo.o.alF().a((h)localObject3);
        if ((this.sUW != null) && (paramString1 != null))
        {
          paramString2 = p.sUH;
          paramString2 = this.sUW;
          if (paramString2 == null) {
            a.f.b.j.ebi();
          }
          paramString3 = p.l(paramString2);
          if ((paramString3.sUU) && (!((q.a)localObject1).sUU))
          {
            localObject3 = this.TAG;
            localObject4 = new StringBuilder("checkPreloadOnVideoPlay ").append(paramString1).append(", moovReady, offset:").append(paramString3.offset).append(", length:").append(paramString3.aPF).append(", cacheSize:");
            paramString2 = this.sVy;
            if (paramString2 == null) {
              break label892;
            }
          }
        }
      }
    }
    label880:
    label886:
    label892:
    for (paramString2 = Integer.valueOf(paramString2.field_cacheSize);; paramString2 = null)
    {
      localObject4 = ((StringBuilder)localObject4).append(paramString2).append(", totalSize:");
      n localn = this.sVy;
      paramString2 = localObject2;
      if (localn != null) {
        paramString2 = Integer.valueOf(localn.field_totalSize);
      }
      ab.i((String)localObject3, paramString2 + ", preloadFinish:" + paramString3.sUV);
      if ((paramString3.offset > 0L) && (paramString3.aPF > 0L))
      {
        ((q.a)localObject1).l(paramString1, (int)paramString3.offset, (int)paramString3.aPF);
        paramString1 = this.sVy;
        if (paramString1 != null) {
          i = paramString1.field_cacheSize;
        }
        this.czu = i;
        this.sUV = paramString3.sUV;
      }
      AppMethodBeat.o(110972);
      return;
      localObject1 = null;
      break;
      bool = false;
      break label612;
    }
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110974);
    a.f.b.j.q(paramString, "mediaId");
    com.tencent.mm.ab.b.b((a.f.a.a)new q.b.a(this, paramString, paramInt1, paramInt2));
    AppMethodBeat.o(110974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.q.b
 * JD-Core Version:    0.7.0.1
 */