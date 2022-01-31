package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.d;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class j$6
  implements View.OnClickListener
{
  j$6(j paramj) {}
  
  private void c(cj paramcj)
  {
    paramcj.bIw.uD = this.vpr.byx.vtz;
    paramcj.bIw.bID = 41;
    paramcj.bIw.bIF = new j.6.1(this);
    com.tencent.mm.sdk.b.a.udP.m(paramcj);
    int i;
    Object localObject1;
    long l;
    label84:
    Object localObject2;
    if (paramcj.bIx.ret == 0)
    {
      i = 1;
      localObject1 = j.c(this.vpr);
      l = bk.UX();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (bi)localIterator.next();
        if (((bi)localObject1).aVK())
        {
          localObject2 = g.a.gp(bk.ZQ(((cs)localObject1).field_content));
          if ((localObject2 != null) && (((g.a)localObject2).type == 5) && (!bk.bl(((g.a)localObject2).url))) {
            if (!((bi)localObject1).ctz()) {
              break label625;
            }
          }
        }
      }
    }
    label625:
    for (int j = 1;; j = 2)
    {
      y.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((g.a)localObject2).url, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(1) });
      localObject1 = "";
      try
      {
        localObject2 = URLEncoder.encode(((g.a)localObject2).url, "UTF-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
      break label84;
      i = 2;
      break;
      if (paramcj.bIx.ret == 0)
      {
        if (14 != paramcj.bIw.type) {
          y.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
        }
      }
      else {
        return;
      }
      if (paramcj.bIw.bIz == null)
      {
        y.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11142, new Object[] { Integer.valueOf(paramcj.bIw.bIz.sXr), Integer.valueOf(paramcj.bIw.bIz.sXs), Integer.valueOf(paramcj.bIw.bIz.sXt), Integer.valueOf(paramcj.bIw.bIz.sXu), Integer.valueOf(paramcj.bIw.bIz.sXv), Integer.valueOf(paramcj.bIw.bIz.sXw), Integer.valueOf(paramcj.bIw.bIz.sXx), Integer.valueOf(paramcj.bIw.bIz.sXy), Integer.valueOf(paramcj.bIw.bIz.sXz), Integer.valueOf(paramcj.bIw.bIz.sXA), Integer.valueOf(paramcj.bIw.bIz.sXB), Integer.valueOf(paramcj.bIw.bIz.sXC), Integer.valueOf(paramcj.bIw.bIz.sXD), Integer.valueOf(paramcj.bIw.bIz.sXE), Integer.valueOf(paramcj.bIw.bIz.sXF) });
      return;
    }
  }
  
  private static String dV(List<bi> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuffer.append(((bi)paramList.next()).field_msgId);
    }
    return localStringBuffer.toString();
  }
  
  private static void dW(List<bi> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.vgo, a.d.vgt, localbi, 0);
    }
  }
  
  private void g(HashSet<Long> paramHashSet)
  {
    if (paramHashSet.isEmpty()) {
      new ah(Looper.getMainLooper()).post(new j.6.5(this));
    }
  }
  
  public final void cEj()
  {
    j.a(this.vpr, "");
    List localList = j.c(this.vpr);
    if (k.dR(localList))
    {
      com.tencent.mm.ui.base.h.a(this.vpr.byx.vtz.getContext(), this.vpr.byx.vtz.getContext().getString(R.l.favorite_fail_remuxing_error), "", this.vpr.byx.vtz.getContext().getString(R.l.I_known), new j.6.6(this));
      return;
    }
    cj localcj = new cj();
    y.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { j.e(this.vpr).field_username });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (localList.size() == 1)
    {
      localObject1 = (bi)localList.get(0);
      if ((localObject1 != null) && ((((bi)localObject1).aVK()) || (((bi)localObject1).ctz())))
      {
        localObject2 = com.tencent.mm.model.u.ij(((cs)localObject1).field_msgSvrId);
        localObject3 = com.tencent.mm.model.u.Hc().v((String)localObject2, true);
        ((u.b)localObject3).h("prePublishId", "msg_" + ((cs)localObject1).field_msgSvrId);
        boolean bool = ((com.tencent.mm.ui.chatting.b.b.c)this.vpr.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG();
        ((u.b)localObject3).h("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a((bi)localObject1, j.d(this.vpr), bool));
        ((u.b)localObject3).h("preChatName", j.e(this.vpr).field_username);
        ((u.b)localObject3).h("preMsgIndex", Integer.valueOf(0));
        ((u.b)localObject3).h("sendAppMsgScene", Integer.valueOf(1));
        ((i)com.tencent.mm.kernel.g.r(i.class)).a("adExtStr", (u.b)localObject3, (bi)localObject1);
        localcj.bIw.bIB = ((String)localObject2);
      }
    }
    if (com.tencent.mm.pluginsdk.model.g.a(this.vpr.byx.vtz.getContext(), localcj, j.e(this.vpr).field_username, localList, false, true))
    {
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bi)((Iterator)localObject1).next();
        if (((bi)localObject2).aVK()) {
          com.tencent.mm.modelstat.b.eBD.b((bi)localObject2, com.tencent.mm.ae.h.g((bi)localObject2));
        } else {
          com.tencent.mm.modelstat.b.eBD.x((bi)localObject2);
        }
      }
      c(localcj);
      dW(j.c(this.vpr));
      return;
    }
    if (j.c(this.vpr).size() > 1)
    {
      localObject3 = this.vpr.byx.vtz.getContext();
      if (localcj.bIw.bIC >= 0)
      {
        localObject1 = this.vpr.byx.vtz.getContext().getString(R.l.favorite_fail_recordtype_error);
        if (localcj.bIw.bIC < 0) {
          break label614;
        }
      }
      label614:
      for (localObject2 = this.vpr.byx.vtz.getContext().getString(R.l.confirm_dialog_ok);; localObject2 = this.vpr.byx.vtz.getContext().getString(R.l.plugin_favorite_opt))
      {
        com.tencent.mm.ui.base.h.a((Context)localObject3, (String)localObject1, "", (String)localObject2, this.vpr.byx.vtz.getContext().getString(R.l.confirm_dialog_cancel), new j.6.7(this, localList, localcj), null);
        return;
        localObject1 = this.vpr.byx.vtz.getContext().getString(R.l.favorite_fail_record_expired_bigfile);
        break;
      }
    }
    com.tencent.mm.ui.base.h.h(this.vpr.byx.vtz.getContext(), localcj.bIw.bIC, 0);
  }
  
  public final void onClick(View paramView)
  {
    Object localObject1 = j.c(this.vpr);
    paramView = new HashSet();
    Object localObject2 = dV((List)localObject1);
    if (((String)localObject2).equals(j.g(this.vpr)))
    {
      com.tencent.mm.ui.base.s.makeText(this.vpr.byx.vtz.getContext(), this.vpr.byx.vtz.getContext().getString(R.l.fav_doing_error_toast), 0).show();
      return;
    }
    j.a(this.vpr, (String)localObject2);
    localObject1 = ((List)localObject1).iterator();
    label802:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bi)((Iterator)localObject1).next();
      Object localObject3;
      Object localObject4;
      com.tencent.mm.j.f localf;
      if (((bi)localObject2).aVK())
      {
        localObject3 = g.a.gp(((cs)localObject2).field_content);
        if ((localObject3 != null) && (((g.a)localObject3).type == 6) && (!bk.bl(((g.a)localObject3).dQB)))
        {
          localObject4 = l.d((bi)localObject2, ((g.a)localObject3).bFE);
          if ((localObject4 != null) && ((!com.tencent.mm.vfs.e.bK(((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath)) || (com.tencent.mm.vfs.e.aeQ(((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_totalLen)))
          {
            y.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[] { Long.valueOf(((cs)localObject2).field_msgId) });
            paramView.add(Long.valueOf(((cs)localObject2).field_msgId));
            localf = new com.tencent.mm.j.f();
            localf.dlP = new j.6.4(this, (com.tencent.mm.pluginsdk.model.app.b)localObject4, (bi)localObject2, paramView);
            localf.field_mediaId = com.tencent.mm.ak.c.a("checkExist", bk.UY(), ((cs)localObject2).field_talker, ((cs)localObject2).field_msgId);
            localf.field_aesKey = ((g.a)localObject3).dQR;
            localf.field_fileType = 19;
            localf.field_authKey = ((g.a)localObject3).dQH;
            localf.dlQ = ((g.a)localObject3).dQB;
            if ((localObject4 == null) || (bk.bl(((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath))) {
              break label700;
            }
            localf.field_fullpath = ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath;
            label366:
            if (!com.tencent.mm.ak.f.Nd().b(localf, -1))
            {
              y.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
              paramView.remove(Long.valueOf(((cs)localObject2).field_msgId));
            }
          }
        }
      }
      int i;
      if (((bi)localObject2).ctB())
      {
        localObject3 = com.tencent.mm.as.o.OJ().bX(((cs)localObject2).field_msgSvrId);
        if (((cs)localObject2).field_isSend != 1) {
          break label733;
        }
        if (!((com.tencent.mm.as.e)localObject3).Or()) {
          break label728;
        }
        i = 1;
        label439:
        if ((((com.tencent.mm.as.e)localObject3).offset < ((com.tencent.mm.as.e)localObject3).ebK) || (((com.tencent.mm.as.e)localObject3).ebK == 0))
        {
          y.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(((cs)localObject2).field_msgId) });
          paramView.add(Long.valueOf(((cs)localObject2).field_msgId));
          if (!com.tencent.mm.as.o.OK().a(((com.tencent.mm.as.e)localObject3).enp, ((cs)localObject2).field_msgId, i, localObject2, R.g.chat_img_template, new j.6.3(this, (bi)localObject2, paramView))) {
            paramView.remove(Long.valueOf(((cs)localObject2).field_msgId));
          }
        }
      }
      if ((((bi)localObject2).aRQ()) || (((bi)localObject2).aRR()))
      {
        localObject3 = com.tencent.mm.modelvideo.u.oe(((cs)localObject2).field_imgPath);
        if ((localObject3 != null) && (((com.tencent.mm.modelvideo.s)localObject3).status != 199))
        {
          paramView.add(Long.valueOf(((cs)localObject2).field_msgId));
          localObject4 = new j.6.2(this, (bi)localObject2, paramView);
          com.tencent.mm.modelvideo.o.Sr().a((t.a)localObject4, Looper.getMainLooper());
          y.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(((cs)localObject2).field_msgId), ((cs)localObject2).field_imgPath });
          if (((com.tencent.mm.modelvideo.s)localObject3).SF()) {
            y.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
          }
          for (i = com.tencent.mm.modelvideo.u.oj(((cs)localObject2).field_imgPath);; i = com.tencent.mm.modelvideo.u.oa(((cs)localObject2).field_imgPath))
          {
            if (i == 0) {
              break label802;
            }
            paramView.remove(Long.valueOf(((cs)localObject2).field_msgId));
            break;
            label700:
            au.Hx();
            localf.field_fullpath = l.aj(com.tencent.mm.model.c.FO(), ((g.a)localObject3).title, ((g.a)localObject3).dQw);
            break label366;
            label728:
            i = 0;
            break label439;
            label733:
            if (!((com.tencent.mm.as.e)localObject3).Or())
            {
              i = 0;
              break label439;
            }
            localObject4 = com.tencent.mm.as.f.a((com.tencent.mm.as.e)localObject3);
            if (!com.tencent.mm.vfs.e.bK(com.tencent.mm.as.o.OJ().o(((com.tencent.mm.as.e)localObject4).enq, "", "")))
            {
              i = 0;
              break label439;
            }
            i = 1;
            break label439;
            y.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
          }
        }
      }
    }
    g(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.6
 * JD-Core Version:    0.7.0.1
 */