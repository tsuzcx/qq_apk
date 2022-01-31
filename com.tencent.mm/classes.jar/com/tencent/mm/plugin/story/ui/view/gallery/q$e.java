package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.plugin.story.g.b;
import com.tencent.mm.plugin.story.g.b.a;
import com.tencent.mm.plugin.story.g.c;
import com.tencent.mm.plugin.story.model.k;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-story_release"})
public final class q$e
  implements h.b
{
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110979);
    ab.i(this.sVz.TAG, "videoViewCallback onError: " + paramString1 + ", meidiaId:" + paramString2 + ", errorMsg:" + paramString3 + ", what:" + paramInt1 + ", extra:" + paramInt2);
    AppMethodBeat.o(110979);
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110980);
    ab.i(this.sVz.TAG, "videoViewCallback onPrepared: " + paramString1 + ", meidiaId:" + paramString2);
    AppMethodBeat.o(110980);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110981);
    ab.i(this.sVz.TAG, "videoViewCallback onVideoEnded: " + paramString1 + ", meidiaId:" + paramString2);
    paramString1 = com.tencent.mm.plugin.story.g.i.sFa;
    paramString1 = com.tencent.mm.plugin.story.g.i.cDo();
    paramString1.cO(paramString1.FO() + 1L);
    paramString1 = this.sVz.sUp;
    if (paramString1 != null)
    {
      paramString2 = b.sDR;
      long l = paramString1.cJA;
      if (b.aiY())
      {
        ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "onVideoEnd ".concat(String.valueOf(l)));
        if (b.sDD.containsKey(Long.valueOf(l)))
        {
          paramString1 = (b.a)b.sDD.get(Long.valueOf(l));
          if (paramString1 != null)
          {
            paramString1.eRq = true;
            AppMethodBeat.o(110981);
            return;
          }
        }
      }
      AppMethodBeat.o(110981);
      return;
    }
    AppMethodBeat.o(110981);
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110983);
    ab.i(this.sVz.TAG, "videoViewCallback onVideoPause: " + paramString1 + ", meidiaId:" + paramString2);
    AppMethodBeat.o(110983);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110984);
    String str = this.sVz.TAG;
    StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoPlay: ").append(paramString1).append(' ');
    Object localObject = this.sVz.sVs;
    long l1;
    label278:
    long l2;
    if (localObject != null)
    {
      localObject = ((StoryVideoView)localObject).getSessionId();
      ab.i(str, (String)localObject + ", " + this.sVz.sUn + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.sVz.sUm);
      if ((m.I(paramString1, this.sVz.sUn, false)) && (this.sVz.sUm))
      {
        paramString1 = this.sVz.sVs;
        if ((paramString1 != null) && (!paramString1.sVa)) {
          this.sVz.r(null);
        }
      }
      paramString2 = this.sVz.sUp;
      if (paramString2 == null) {
        break label950;
      }
      paramString1 = c.sEl;
      c.mJ(paramString2.cJA);
      paramString1 = b.sDR;
      l1 = paramString2.cJA;
      if (b.aiY())
      {
        localObject = new StringBuilder("onVideoPlay storyId ").append(l1).append(" lastStoryId ").append(b.sDC).append(" contains:").append(b.sDD.containsKey(Long.valueOf(l1))).append(" result");
        paramString1 = (b.a)b.sDD.get(Long.valueOf(l1));
        if (paramString1 == null) {
          break label456;
        }
        paramString1 = Long.valueOf(paramString1.sDU);
        ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", paramString1);
        if ((l1 == b.sDC) && (b.sDD.containsKey(Long.valueOf(l1))))
        {
          paramString1 = (b.a)b.sDD.get(Long.valueOf(l1));
          if ((paramString1 != null) && (!paramString1.rKr) && (paramString1.sDU <= 0L) && (paramString1.sDT > 0L))
          {
            paramString1.isWaiting = false;
            l2 = bo.hl(paramString1.sDT);
            paramString1.sDU = bo.aoy();
            if (l2 <= 120000L) {
              break label461;
            }
            ab.w("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
          }
        }
      }
    }
    for (;;)
    {
      p.sUH.mY(paramString2.cJA);
      paramString1 = k.svr;
      k.acT(paramString2.username);
      AppMethodBeat.o(110984);
      return;
      localObject = null;
      break;
      label456:
      paramString1 = null;
      break label278;
      label461:
      ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "onPlayCostTime  storyId " + l1 + " onPlayCostTime:" + l2);
      b.k(b.ltw, 31L, l2);
      b.k(b.ltw, 30L, 1L);
      if (l2 <= 400L)
      {
        b.k(b.ltw, 90L, 1L);
        label534:
        if (l2 > 400L) {
          break label717;
        }
        b.k(b.ltw, 50L, 1L);
        label553:
        if (l1 != b.sDF) {
          break label838;
        }
        if (!b.sDJ) {
          break label840;
        }
        b.k(b.ltw, 40L, 1L);
        b.k(b.ltw, 42L, l2);
      }
      for (;;)
      {
        if (l2 <= 1000L)
        {
          if (b.sDJ)
          {
            b.k(b.ltw, 44L, 1L);
            break;
            if (l2 <= 800L)
            {
              b.k(b.ltw, 91L, 1L);
              break label534;
            }
            if (l2 <= 1600L)
            {
              b.k(b.ltw, 92L, 1L);
              break label534;
            }
            if (l2 <= 3200L)
            {
              b.k(b.ltw, 93L, 1L);
              break label534;
            }
            if (l2 <= 5000L)
            {
              b.k(b.ltw, 94L, 1L);
              break label534;
            }
            b.k(b.ltw, 95L, 1L);
            break label534;
            label717:
            if (l2 <= 800L)
            {
              b.k(b.ltw, 51L, 1L);
              break label553;
            }
            if (l2 <= 1000L)
            {
              b.k(b.ltw, 52L, 1L);
              break label553;
            }
            if (l2 <= 2000L)
            {
              b.k(b.ltw, 53L, 1L);
              break label553;
            }
            if (l2 <= 3000L)
            {
              b.k(b.ltw, 54L, 1L);
              break label553;
            }
            if (l2 <= 4000L)
            {
              b.k(b.ltw, 55L, 1L);
              break label553;
            }
            b.k(b.ltw, 56L, 1L);
            break label553;
            label838:
            break;
            label840:
            b.k(b.ltw, 41L, 1L);
            b.k(b.ltw, 43L, l2);
            continue;
          }
          b.k(b.ltw, 45L, 1L);
          break;
        }
      }
      if (l2 <= 2000L)
      {
        if (b.sDJ) {
          b.k(b.ltw, 46L, 1L);
        } else {
          b.k(b.ltw, 47L, 1L);
        }
      }
      else if (b.sDJ) {
        b.k(b.ltw, 48L, 1L);
      } else {
        b.k(b.ltw, 49L, 1L);
      }
    }
    label950:
    AppMethodBeat.o(110984);
  }
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110985);
    ab.i(this.sVz.TAG, "videoViewCallback onVideoWaiting: " + paramString1 + ", meidiaId:" + paramString2);
    paramString1 = this.sVz.sUp;
    if (paramString1 != null)
    {
      paramString2 = c.sEl;
      c.mI(paramString1.cJA);
      paramString2 = b.sDR;
      long l = paramString1.cJA;
      if ((b.aiY()) && (b.sDD.containsKey(Long.valueOf(l))))
      {
        paramString1 = (b.a)b.sDD.get(Long.valueOf(l));
        if ((paramString1 != null) && (!paramString1.rKr) && (paramString1.sDV))
        {
          paramString1.isWaiting = true;
          AppMethodBeat.o(110985);
          return;
        }
      }
      AppMethodBeat.o(110985);
      return;
    }
    AppMethodBeat.o(110985);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110986);
    String str = this.sVz.TAG;
    StringBuilder localStringBuilder = new StringBuilder("videoViewCallback onVideoWaitingEnd: ").append(paramString1).append(' ');
    Object localObject = this.sVz.sVs;
    if (localObject != null) {}
    for (localObject = ((StoryVideoView)localObject).getSessionId();; localObject = null)
    {
      ab.i(str, (String)localObject + ", " + this.sVz.sUn + ", meidiaId:" + paramString2 + ", isVideoPause:" + this.sVz.sUm);
      if ((m.I(paramString1, this.sVz.sUn, false)) && (this.sVz.sUm))
      {
        paramString1 = this.sVz.sVs;
        if (paramString1 == null) {
          break;
        }
        if (!paramString1.sVa) {
          this.sVz.r(null);
        }
      }
      AppMethodBeat.o(110986);
      return;
    }
    AppMethodBeat.o(110986);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110982);
    ab.i(this.sVz.TAG, "videoViewCallback onGetVideoSize: " + paramString1 + ", " + this.sVz.sUn + ", meidiaId:" + paramString2);
    AppMethodBeat.o(110982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.q.e
 * JD-Core Version:    0.7.0.1
 */