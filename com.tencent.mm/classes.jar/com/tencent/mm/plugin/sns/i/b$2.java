package com.tencent.mm.plugin.sns.i;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;

public final class b$2
  implements Runnable
{
  public b$2(b paramb, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(36845);
    if (!g.RJ().QU())
    {
      ab.w("MicroMsg.SnsBrowseInfoHelper", "account not init.");
      AppMethodBeat.o(36845);
      return;
    }
    int i = Process.myTid();
    ab.i("MicroMsg.SnsBrowseInfoHelper", "summersns report tid[%d] osTid[%d], prior[%d][%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(i), Integer.valueOf(Thread.currentThread().getPriority()), Integer.valueOf(Process.getThreadPriority(i)) });
    long l = System.currentTimeMillis();
    b localb = this.rox;
    i = this.roy;
    Object localObject;
    if (i != -1)
    {
      localObject = ak.DO(i);
      if (localObject != null)
      {
        localObject = i.j((n)localObject);
        localb.rmO = ((String)localObject);
        abx localabx = ag.cpj().abz("@__weixintimtline").csy();
        if ((localabx.wSq == 0L) || (i.lr(localabx.wSq).compareTo((String)localObject) <= 0)) {
          break label2863;
        }
        localb.lr(true);
      }
    }
    for (;;)
    {
      i = t.aad();
      localObject = new d();
      ((d)localObject).k("20BrowseTime", localb.rmz + ",");
      ((d)localObject).k("21BrowseFeedCount", localb.rmA + ",");
      ((d)localObject).k("22CommentOrLikeFeedCount", localb.rmB + ",");
      ((d)localObject).k("23ClickFeedCount", localb.rmC + ",");
      ((d)localObject).k("24ClickAlbumCount", localb.rmD + ",");
      ((d)localObject).k("25PostFeedCount", localb.rmE + ",");
      ((d)localObject).k("26ExposeFeedCount", localb.rnV.size() + ",");
      ((d)localObject).k("27FavFeedCount", localb.rnW.size() + ",");
      ((d)localObject).k("28BlackListFriendCount", localb.rmH + ",");
      ((d)localObject).k("29OutsiderFriendCount", localb.rmI + ",");
      ((d)localObject).k("30BrowseNewFeedCount", localb.rmJ + ",");
      ((d)localObject).k("31HasNewSnsMsgWhenEntrance", localb.rmK + ",");
      ((d)localObject).k("32HasNewChatMsgWhenExit", localb.rmL + ",");
      ((d)localObject).k("33StartBrowseSnsObjectId", localb.rmM + ",");
      ((d)localObject).k("34EndBrowseSnsObjectId", localb.rmN + ",");
      ((d)localObject).k("35NextBrowseSnsObjectId", localb.rmO + ",");
      ((d)localObject).k("36HasNewFeedInServer", localb.rmP + ",");
      ((d)localObject).k("37BrowseBrandUrlFeedCount", localb.rmQ + ",");
      ((d)localObject).k("38BrowseNotBrandUrlFeedCount", localb.rmR + ",");
      ((d)localObject).k("39BrowseTextFeedCount", localb.rmS + ",");
      ((d)localObject).k("40BrowseImageFeedCount", localb.rmT + ",");
      ((d)localObject).k("41BrowseSightFeedCount", localb.rmU + ",");
      ((d)localObject).k("42BrowseAdFeedCount", localb.rmV + ",");
      ((d)localObject).k("43BrowseMusicFeedCount", localb.rmW + ",");
      ((d)localObject).k("44contactCount", i + ",");
      ((d)localObject).k("BrowseVideoFeedCount45", localb.rmX + ",");
      ((d)localObject).k("ClickBrandUrlFeedCount46", localb.rmY + ",");
      ((d)localObject).k("ClickNotBrandUrlFeedCount47", localb.rmZ + ",");
      ((d)localObject).k("ClickImageFeedCount48", localb.rna + ",");
      ((d)localObject).k("ClickSightFeedCount49", localb.rnb + ",");
      ((d)localObject).k("ClickMusicFeedCount50", localb.rnc + ",");
      ((d)localObject).k("ClickVideoFeedCount51", localb.rnd + ",");
      ((d)localObject).k("BrowseOtherFeedCount52", localb.rne + ",");
      ((d)localObject).k("BrowserStreamVideoFeedCount53", localb.rnf + ",");
      ((d)localObject).k("ClickStreamVideoCount54", localb.rng + ",");
      ((d)localObject).k("ClickAdFeed55", localb.rnh + ",");
      ((d)localObject).k("56BackGroundTime", localb.rni + ",");
      ((d)localObject).k("57BrowseTimeLineTime", localb.rnk + ",");
      ((d)localObject).k("58BrowseMyAlbumTime", localb.rnm + ",");
      ((d)localObject).k("59BrowseOtherAlbumTime", localb.rno + ",");
      ((d)localObject).k("60BrowseMessageListTime", localb.rnq + ",");
      ((d)localObject).k("61ClickNewPostTime", localb.rns + ",");
      ((d)localObject).k("62BrowseFullScreenImageTime", localb.rnu + ",");
      ((d)localObject).k("63BrowseFullScreenSightTime", localb.rnw + ",");
      ((d)localObject).k("64BrowseMPArticleTime", localb.rny + ",");
      ((d)localObject).k("65BrowseExternalArticleTime", localb.rnA + ",");
      ((d)localObject).k("66BrowseFullScreenAdImageTime", localb.rnC + ",");
      ((d)localObject).k("67BrowseAdSightTime", "0,");
      ((d)localObject).k("68BrowseAdDetailTime", localb.rnE + ",");
      ((d)localObject).k("69BrowseFullScreenAdSightTime", localb.rnG + ",");
      ((d)localObject).k("70BrowseFullScreenAdLongVideoTime", localb.rnI + ",");
      ((d)localObject).k("71BrowseForwardAdLongVideoTime", localb.rnK + ",");
      ((d)localObject).k("72StartBrowseTime", localb.rov + ",");
      ((d)localObject).k("73ClickFeedIdList", b.f(localb.rnU) + ",");
      ((d)localObject).k("74ExposeFeedIdList", b.f(localb.rnV) + ",");
      ((d)localObject).k("75FavFeedIdList", b.f(localb.rnW) + ",");
      ((d)localObject).k("76ClickAlbumUserList", b.f(localb.roc) + ",");
      ((d)localObject).k("77ForwardFeedIdList", b.f(localb.rnX) + ",");
      ((d)localObject).k("78ClickAvatarFeedIdList", b.f(localb.rnY) + ",");
      ((d)localObject).k("79ClickNickNameFeedIdList", b.f(localb.rnZ) + ",");
      ((d)localObject).k("80ForwardToSingleChatFeedIdList", b.f(localb.roa) + ",");
      ((d)localObject).k("81ForwardToChatRoomFeedIdList", b.f(localb.rob) + ",");
      ((d)localObject).k("82FeedUpdateNotification", localb.eah + ",");
      ((d)localObject).k("83abandon", ",");
      ((d)localObject).k("84abandon", ",");
      ((d)localObject).k("85LastestUnReadFeedId", localb.rnM + ",");
      ((d)localObject).k("86UnReadMsgCount", localb.rnN + ",");
      ((d)localObject).k("87BrowseAdCanvasPageTime", localb.rnP + ",");
      ((d)localObject).k("88BrowseForwardAdCanvasTime", localb.rnR + ",");
      ((d)localObject).k("90EnterObjectId", localb.rnO);
      ab.v("MicroMsg.SnsBrowseInfoHelper", "report logbuffer(12076): " + ((d)localObject).Fg());
      h.qsU.e(12076, new Object[] { localObject });
      com.tencent.mm.sdk.b.a.ymk.d(localb.dZC);
      localb.rmz = 0L;
      localb.rmA = 0;
      localb.rmB = 0;
      localb.rmC = 0;
      localb.rmD = 0;
      localb.rmE = 0;
      localb.rmF = 0;
      localb.rmG = 0;
      localb.rmH = 0;
      localb.rmI = 0;
      localb.rmJ = 0;
      localb.rmK = 0;
      localb.rmL = 0;
      localb.rmM = "";
      localb.rmN = "";
      localb.rmO = "";
      localb.rmP = 0;
      localb.rmQ = 0;
      localb.rmR = 0;
      localb.rmS = 0;
      localb.rmT = 0;
      localb.rmU = 0;
      localb.rmV = 0;
      localb.rmW = 0;
      localb.jUj = 0;
      localb.rmX = 0;
      localb.rmY = 0;
      localb.rmZ = 0;
      localb.rna = 0;
      localb.rnb = 0;
      localb.rnc = 0;
      localb.rnd = 0;
      localb.rne = 0;
      localb.rnf = 0;
      localb.rng = 0;
      localb.rnh = 0;
      localb.rni = 0L;
      localb.rnj = 0L;
      localb.rnk = 0L;
      localb.rnl = 0L;
      localb.rnm = 0L;
      localb.rnn = 0L;
      localb.rno = 0L;
      localb.rnp = 0L;
      localb.rnq = 0L;
      localb.rnr = 0L;
      localb.rns = 0L;
      localb.rnt = 0L;
      localb.rnu = 0L;
      localb.rnv = 0L;
      localb.rnw = 0L;
      localb.rnx = 0L;
      localb.rny = 0L;
      localb.rnz = 0L;
      localb.rnA = 0L;
      localb.rnB = 0L;
      localb.rnC = 0L;
      localb.rnD = 0L;
      localb.rnE = 0L;
      localb.rnF = 0L;
      localb.rnG = 0L;
      localb.rnH = 0L;
      localb.rnI = 0L;
      localb.rnJ = 0L;
      localb.rnK = 0L;
      localb.rnL = 0L;
      localb.rnU.clear();
      localb.rnV.clear();
      localb.rnW.clear();
      localb.rnX.clear();
      localb.rnY.clear();
      localb.rnZ.clear();
      localb.roa.clear();
      localb.rob.clear();
      localb.eah = 0;
      localb.rnM = "";
      localb.rnN = 0;
      ab.i("MicroMsg.SnsBrowseInfoHelper", "summersns report take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(36845);
      return;
      label2863:
      localb.lr(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.b.2
 * JD-Core Version:    0.7.0.1
 */