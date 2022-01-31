package com.tencent.mm.plugin.sns.h;

import android.os.Process;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

public final class b$2
  implements Runnable
{
  public b$2(b paramb, int paramInt) {}
  
  public final void run()
  {
    if (!g.DN().Dc())
    {
      y.w("MicroMsg.SnsBrowseInfoHelper", "account not init.");
      return;
    }
    int i = Process.myTid();
    y.i("MicroMsg.SnsBrowseInfoHelper", "summersns report tid[%d] osTid[%d], prior[%d][%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(i), Integer.valueOf(Thread.currentThread().getPriority()), Integer.valueOf(Process.getThreadPriority(i)) });
    long l = System.currentTimeMillis();
    b localb = this.ozz;
    i = this.ozA;
    Object localObject;
    if (i != -1)
    {
      localObject = aj.xO(i);
      if (localObject != null)
      {
        localObject = i.j((n)localObject);
        localb.oxS = ((String)localObject);
        xs localxs = af.bDJ().OF("@__weixintimtline").bGv();
        if ((localxs.sUt == 0L) || (i.fO(localxs.sUt).compareTo((String)localObject) <= 0)) {
          break label2833;
        }
        localb.jl(true);
      }
    }
    for (;;)
    {
      i = s.Hb();
      localObject = new d();
      ((d)localObject).j("20BrowseTime", localb.oxD + ",");
      ((d)localObject).j("21BrowseFeedCount", localb.oxE + ",");
      ((d)localObject).j("22CommentOrLikeFeedCount", localb.oxF + ",");
      ((d)localObject).j("23ClickFeedCount", localb.oxG + ",");
      ((d)localObject).j("24ClickAlbumCount", localb.oxH + ",");
      ((d)localObject).j("25PostFeedCount", localb.oxI + ",");
      ((d)localObject).j("26ExposeFeedCount", localb.oyY.size() + ",");
      ((d)localObject).j("27FavFeedCount", localb.oyZ.size() + ",");
      ((d)localObject).j("28BlackListFriendCount", localb.oxL + ",");
      ((d)localObject).j("29OutsiderFriendCount", localb.oxM + ",");
      ((d)localObject).j("30BrowseNewFeedCount", localb.oxN + ",");
      ((d)localObject).j("31HasNewSnsMsgWhenEntrance", localb.oxO + ",");
      ((d)localObject).j("32HasNewChatMsgWhenExit", localb.oxP + ",");
      ((d)localObject).j("33StartBrowseSnsObjectId", localb.oxQ + ",");
      ((d)localObject).j("34EndBrowseSnsObjectId", localb.oxR + ",");
      ((d)localObject).j("35NextBrowseSnsObjectId", localb.oxS + ",");
      ((d)localObject).j("36HasNewFeedInServer", localb.oxT + ",");
      ((d)localObject).j("37BrowseBrandUrlFeedCount", localb.oxU + ",");
      ((d)localObject).j("38BrowseNotBrandUrlFeedCount", localb.oxV + ",");
      ((d)localObject).j("39BrowseTextFeedCount", localb.oxW + ",");
      ((d)localObject).j("40BrowseImageFeedCount", localb.oxX + ",");
      ((d)localObject).j("41BrowseSightFeedCount", localb.oxY + ",");
      ((d)localObject).j("42BrowseAdFeedCount", localb.oxZ + ",");
      ((d)localObject).j("43BrowseMusicFeedCount", localb.oya + ",");
      ((d)localObject).j("44contactCount", i + ",");
      ((d)localObject).j("BrowseVideoFeedCount45", localb.oyb + ",");
      ((d)localObject).j("ClickBrandUrlFeedCount46", localb.oyc + ",");
      ((d)localObject).j("ClickNotBrandUrlFeedCount47", localb.oyd + ",");
      ((d)localObject).j("ClickImageFeedCount48", localb.oye + ",");
      ((d)localObject).j("ClickSightFeedCount49", localb.oyf + ",");
      ((d)localObject).j("ClickMusicFeedCount50", localb.oyg + ",");
      ((d)localObject).j("ClickVideoFeedCount51", localb.oyh + ",");
      ((d)localObject).j("BrowseOtherFeedCount52", localb.oyi + ",");
      ((d)localObject).j("BrowserStreamVideoFeedCount53", localb.oyj + ",");
      ((d)localObject).j("ClickStreamVideoCount54", localb.oyk + ",");
      ((d)localObject).j("ClickAdFeed55", localb.oyl + ",");
      ((d)localObject).j("56BackGroundTime", localb.oym + ",");
      ((d)localObject).j("57BrowseTimeLineTime", localb.oyo + ",");
      ((d)localObject).j("58BrowseMyAlbumTime", localb.oyq + ",");
      ((d)localObject).j("59BrowseOtherAlbumTime", localb.oys + ",");
      ((d)localObject).j("60BrowseMessageListTime", localb.oyu + ",");
      ((d)localObject).j("61ClickNewPostTime", localb.oyw + ",");
      ((d)localObject).j("62BrowseFullScreenImageTime", localb.oyy + ",");
      ((d)localObject).j("63BrowseFullScreenSightTime", localb.oyA + ",");
      ((d)localObject).j("64BrowseMPArticleTime", localb.oyC + ",");
      ((d)localObject).j("65BrowseExternalArticleTime", localb.oyE + ",");
      ((d)localObject).j("66BrowseFullScreenAdImageTime", localb.oyG + ",");
      ((d)localObject).j("67BrowseAdSightTime", "0,");
      ((d)localObject).j("68BrowseAdDetailTime", localb.oyI + ",");
      ((d)localObject).j("69BrowseFullScreenAdSightTime", localb.oyK + ",");
      ((d)localObject).j("70BrowseFullScreenAdLongVideoTime", localb.oyM + ",");
      ((d)localObject).j("71BrowseForwardAdLongVideoTime", localb.oyO + ",");
      ((d)localObject).j("72StartBrowseTime", localb.ozy + ",");
      ((d)localObject).j("73ClickFeedIdList", b.f(localb.oyX) + ",");
      ((d)localObject).j("74ExposeFeedIdList", b.f(localb.oyY) + ",");
      ((d)localObject).j("75FavFeedIdList", b.f(localb.oyZ) + ",");
      ((d)localObject).j("76ClickAlbumUserList", b.f(localb.ozf) + ",");
      ((d)localObject).j("77ForwardFeedIdList", b.f(localb.oza) + ",");
      ((d)localObject).j("78ClickAvatarFeedIdList", b.f(localb.ozb) + ",");
      ((d)localObject).j("79ClickNickNameFeedIdList", b.f(localb.ozc) + ",");
      ((d)localObject).j("80ForwardToSingleChatFeedIdList", b.f(localb.ozd) + ",");
      ((d)localObject).j("81ForwardToChatRoomFeedIdList", b.f(localb.oze) + ",");
      ((d)localObject).j("82FeedUpdateNotification", localb.diO + ",");
      ((d)localObject).j("83abandon", ",");
      ((d)localObject).j("84abandon", ",");
      ((d)localObject).j("85LastestUnReadFeedId", localb.oyQ + ",");
      ((d)localObject).j("86UnReadMsgCount", localb.oyR + ",");
      ((d)localObject).j("87BrowseAdCanvasPageTime", localb.oyS + ",");
      ((d)localObject).j("88BrowseForwardAdCanvasTime", localb.oyU + ",");
      y.v("MicroMsg.SnsBrowseInfoHelper", "report logbuffer(12076): " + ((d)localObject).uJ());
      h.nFQ.f(12076, new Object[] { localObject });
      com.tencent.mm.sdk.b.a.udP.d(localb.dii);
      localb.oxD = 0L;
      localb.oxE = 0;
      localb.oxF = 0;
      localb.oxG = 0;
      localb.oxH = 0;
      localb.oxI = 0;
      localb.oxJ = 0;
      localb.oxK = 0;
      localb.oxL = 0;
      localb.oxM = 0;
      localb.oxN = 0;
      localb.oxO = 0;
      localb.oxP = 0;
      localb.oxQ = "";
      localb.oxR = "";
      localb.oxS = "";
      localb.oxT = 0;
      localb.oxU = 0;
      localb.oxV = 0;
      localb.oxW = 0;
      localb.oxX = 0;
      localb.oxY = 0;
      localb.oxZ = 0;
      localb.oya = 0;
      localb.idv = 0;
      localb.oyb = 0;
      localb.oyc = 0;
      localb.oyd = 0;
      localb.oye = 0;
      localb.oyf = 0;
      localb.oyg = 0;
      localb.oyh = 0;
      localb.oyi = 0;
      localb.oyj = 0;
      localb.oyk = 0;
      localb.oyl = 0;
      localb.oym = 0L;
      localb.oyn = 0L;
      localb.oyo = 0L;
      localb.oyp = 0L;
      localb.oyq = 0L;
      localb.oyr = 0L;
      localb.oys = 0L;
      localb.oyt = 0L;
      localb.oyu = 0L;
      localb.oyv = 0L;
      localb.oyw = 0L;
      localb.oyx = 0L;
      localb.oyy = 0L;
      localb.oyz = 0L;
      localb.oyA = 0L;
      localb.oyB = 0L;
      localb.oyC = 0L;
      localb.oyD = 0L;
      localb.oyE = 0L;
      localb.oyF = 0L;
      localb.oyG = 0L;
      localb.oyH = 0L;
      localb.oyI = 0L;
      localb.oyJ = 0L;
      localb.oyK = 0L;
      localb.oyL = 0L;
      localb.oyM = 0L;
      localb.oyN = 0L;
      localb.oyO = 0L;
      localb.oyP = 0L;
      localb.oyX.clear();
      localb.oyY.clear();
      localb.oyZ.clear();
      localb.oza.clear();
      localb.ozb.clear();
      localb.ozc.clear();
      localb.ozd.clear();
      localb.oze.clear();
      localb.diO = 0;
      localb.oyQ = "";
      localb.oyR = 0;
      y.i("MicroMsg.SnsBrowseInfoHelper", "summersns report take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      label2833:
      localb.jl(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.b.2
 * JD-Core Version:    0.7.0.1
 */