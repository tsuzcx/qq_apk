package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.d.a;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.z;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.i.class)
public class j
  extends a
  implements com.tencent.mm.af.t, com.tencent.mm.ui.chatting.c.b.i
{
  public static az zEQ;
  private com.tencent.mm.storage.ad czH;
  private com.tencent.mm.ui.tools.q eiV;
  private boolean hasInit = false;
  private Animation qUH;
  private String zBH = "";
  private boolean zDu = false;
  private ChattingFooterMoreBtnBar zER;
  private boolean zES = true;
  private boolean zvB;
  
  static
  {
    AppMethodBeat.i(31343);
    zEQ = new az(5, "MicroMsg.ChattingMoreBtnBarHelper");
    AppMethodBeat.o(31343);
  }
  
  private void dHV()
  {
    AppMethodBeat.i(31338);
    if (this.zDu) {
      this.caz.showOptionMenu(false);
    }
    for (;;)
    {
      ((aj)this.caz.ay(aj.class)).dJw();
      AppMethodBeat.o(31338);
      return;
      ((r)this.caz.ay(r.class)).dIy();
    }
  }
  
  public final boolean Yr()
  {
    return this.zES;
  }
  
  public final void a(com.tencent.mm.af.t.a parama)
  {
    AppMethodBeat.i(153837);
    dHU();
    AppMethodBeat.o(153837);
  }
  
  public final void b(com.tencent.mm.af.t.a parama) {}
  
  public final void bd(bi parambi)
  {
    AppMethodBeat.i(31335);
    if (this.hasInit)
    {
      ab.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
      this.czH = this.caz.txj;
      if ((!this.caz.dJF()) && (!((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw())) {
        break label579;
      }
    }
    label579:
    for (boolean bool = true;; bool = false)
    {
      this.zvB = bool;
      this.zER.dGA();
      this.caz.zJz.getController().addSearchMenu(true, this.eiV);
      this.zER.startAnimation(this.qUH);
      this.zER.setVisibility(0);
      this.zDu = true;
      ((z)this.caz.ay(z.class)).dIY();
      com.tencent.mm.ui.chatting.c.b.h localh = (com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
      localh.dHb();
      localh.dHa();
      localh.oC(parambi.field_msgId);
      int i = localh.ces();
      this.zER.Pr(i);
      ((com.tencent.mm.ui.chatting.c.b.l)this.caz.ay(com.tencent.mm.ui.chatting.c.b.l.class)).dIe();
      this.caz.hideVKB();
      dHV();
      ((com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class)).dIp();
      com.tencent.mm.plugin.report.service.h.qsU.e(10811, new Object[] { Integer.valueOf(1) });
      if (this.czH.dwz())
      {
        parambi = this.caz;
        ab.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[] { Integer.valueOf(2131820646) });
        parambi.zJA.removeOptionMenu(2131820646);
      }
      ((com.tencent.mm.ui.chatting.c.b.s)this.caz.ay(com.tencent.mm.ui.chatting.c.b.s.class)).dII();
      AppMethodBeat.o(31335);
      return;
      this.hasInit = true;
      if (this.zER == null)
      {
        ((ViewStub)this.caz.findViewById(2131822456)).inflate();
        this.zER = ((ChattingFooterMoreBtnBar)this.caz.findViewById(2131822797));
      }
      if (((z)this.caz.ay(z.class)).dJf())
      {
        ab.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        if (this.eiV == null) {}
      }
      for (this.eiV.Axg = null;; this.eiV.Axg = new j.8(this))
      {
        this.zER.c(3, new j.2(this));
        this.zER.c(2, new j.3(this));
        this.zER.c(1, new j.4(this));
        this.zER.c(0, new j.5(this));
        this.zER.c(4, new View.OnClickListener()
        {
          private void c(cm paramAnonymouscm)
          {
            AppMethodBeat.i(31323);
            paramAnonymouscm.cpR.fragment = j.this.caz.zJz;
            paramAnonymouscm.cpR.cpY = 41;
            paramAnonymouscm.cpR.cqa = new j.6.1(this);
            com.tencent.mm.sdk.b.a.ymk.l(paramAnonymouscm);
            int i;
            Object localObject1;
            long l;
            label90:
            Object localObject2;
            if (paramAnonymouscm.cpS.ret == 0)
            {
              i = 1;
              localObject1 = j.c(j.this);
              l = bo.aox();
              Iterator localIterator = ((List)localObject1).iterator();
              while (localIterator.hasNext())
              {
                localObject1 = (bi)localIterator.next();
                if (((bi)localObject1).bCn())
                {
                  localObject2 = j.b.mY(bo.apU(((dd)localObject1).field_content));
                  if ((localObject2 != null) && (((j.b)localObject2).type == 5) && (!bo.isNullOrNil(((j.b)localObject2).url))) {
                    if (!((bi)localObject1).dvV()) {
                      break label649;
                    }
                  }
                }
              }
            }
            label649:
            for (int j = 1;; j = 2)
            {
              ab.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((j.b)localObject2).url, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(1) });
              localObject1 = "";
              try
              {
                localObject2 = URLEncoder.encode(((j.b)localObject2).url, "UTF-8");
                localObject1 = localObject2;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                for (;;)
                {
                  ab.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", localUnsupportedEncodingException, "", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.h.qsU.e(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
              break label90;
              i = 2;
              break;
              if (paramAnonymouscm.cpS.ret == 0)
              {
                if (14 != paramAnonymouscm.cpR.type)
                {
                  ab.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                  AppMethodBeat.o(31323);
                  return;
                }
                if (paramAnonymouscm.cpR.cpU == null)
                {
                  ab.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                  AppMethodBeat.o(31323);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.qsU.e(11142, new Object[] { Integer.valueOf(paramAnonymouscm.cpR.cpU.wVr), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVs), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVt), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVu), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVv), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVw), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVx), Integer.valueOf(paramAnonymouscm.cpR.cpU.fileCount), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVy), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVz), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVA), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVB), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVC), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVD), Integer.valueOf(paramAnonymouscm.cpR.cpU.wVE) });
              }
              AppMethodBeat.o(31323);
              return;
            }
          }
          
          private static String ff(List<bi> paramAnonymousList)
          {
            AppMethodBeat.i(31324);
            StringBuffer localStringBuffer = new StringBuffer();
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext()) {
              localStringBuffer.append(((bi)paramAnonymousList.next()).field_msgId);
            }
            paramAnonymousList = localStringBuffer.toString();
            AppMethodBeat.o(31324);
            return paramAnonymousList;
          }
          
          private static void fg(List<bi> paramAnonymousList)
          {
            AppMethodBeat.i(31328);
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              bi localbi = (bi)paramAnonymousList.next();
              com.tencent.mm.ui.chatting.a.a(a.c.zvl, a.d.zvq, localbi, 0);
            }
            AppMethodBeat.o(31328);
          }
          
          private void h(HashSet<Long> paramAnonymousHashSet)
          {
            AppMethodBeat.i(31326);
            if (paramAnonymousHashSet.isEmpty()) {
              new ak(Looper.getMainLooper()).post(new j.6.5(this));
            }
            AppMethodBeat.o(31326);
          }
          
          public final void dHY()
          {
            AppMethodBeat.i(31327);
            j.a(j.this, "");
            List localList = j.c(j.this);
            if (com.tencent.mm.ui.chatting.j.fa(localList))
            {
              com.tencent.mm.ui.base.h.a(j.this.caz.zJz.getContext(), j.this.caz.zJz.getContext().getString(2131299728), "", j.this.caz.zJz.getContext().getString(2131296332), new j.6.6(this));
              AppMethodBeat.o(31327);
              return;
            }
            cm localcm = new cm();
            ab.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { j.e(j.this).field_username });
            Object localObject1;
            Object localObject2;
            Object localObject3;
            if (localList.size() == 1)
            {
              localObject1 = (bi)localList.get(0);
              if ((localObject1 != null) && ((((bi)localObject1).bCn()) || (((bi)localObject1).dvV())))
              {
                localObject2 = v.oQ(((dd)localObject1).field_msgSvrId);
                localObject3 = v.aae().z((String)localObject2, true);
                ((v.b)localObject3).i("prePublishId", "msg_" + ((dd)localObject1).field_msgSvrId);
                boolean bool = ((com.tencent.mm.ui.chatting.c.b.d)j.this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv();
                ((v.b)localObject3).i("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a((bi)localObject1, j.d(j.this), bool));
                ((v.b)localObject3).i("preChatName", j.e(j.this).field_username);
                ((v.b)localObject3).i("preMsgIndex", Integer.valueOf(0));
                ((v.b)localObject3).i("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.b.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", (v.b)localObject3, (bi)localObject1);
                localcm.cpR.cpW = ((String)localObject2);
              }
            }
            if (com.tencent.mm.pluginsdk.model.g.a(j.this.caz.zJz.getContext(), localcm, j.e(j.this).field_username, localList, true))
            {
              localObject1 = localList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (bi)((Iterator)localObject1).next();
                if (((bi)localObject2).bCn()) {
                  com.tencent.mm.modelstat.b.fRu.b((bi)localObject2, com.tencent.mm.af.k.k((bi)localObject2));
                } else {
                  com.tencent.mm.modelstat.b.fRu.D((bi)localObject2);
                }
              }
              c(localcm);
              fg(j.c(j.this));
              AppMethodBeat.o(31327);
              return;
            }
            if (j.c(j.this).size() > 1)
            {
              localObject3 = j.this.caz.zJz.getContext();
              if (localcm.cpR.cpX >= 0)
              {
                localObject1 = j.this.caz.zJz.getContext().getString(2131299727);
                if (localcm.cpR.cpX < 0) {
                  break label637;
                }
              }
              label637:
              for (localObject2 = j.this.caz.zJz.getContext().getString(2131298501);; localObject2 = j.this.caz.zJz.getContext().getString(2131302102))
              {
                com.tencent.mm.ui.base.h.d((Context)localObject3, (String)localObject1, "", (String)localObject2, j.this.caz.zJz.getContext().getString(2131298499), new j.6.7(this, localList, localcm), null);
                AppMethodBeat.o(31327);
                return;
                localObject1 = j.this.caz.zJz.getContext().getString(2131299726);
                break;
              }
            }
            com.tencent.mm.ui.base.h.h(j.this.caz.zJz.getContext(), localcm.cpR.cpX, 0);
            AppMethodBeat.o(31327);
          }
          
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(31325);
            Object localObject1 = j.c(j.this);
            paramAnonymousView = new HashSet();
            Object localObject2 = ff((List)localObject1);
            if (((String)localObject2).equals(j.f(j.this)))
            {
              com.tencent.mm.ui.base.t.makeText(j.this.caz.zJz.getContext(), j.this.caz.zJz.getContext().getString(2131299669), 0).show();
              AppMethodBeat.o(31325);
              return;
            }
            j.a(j.this, (String)localObject2);
            localObject1 = ((List)localObject1).iterator();
            label814:
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (bi)((Iterator)localObject1).next();
              Object localObject3;
              Object localObject4;
              com.tencent.mm.i.g localg;
              if (((bi)localObject2).bCn())
              {
                localObject3 = j.b.mY(((dd)localObject2).field_content);
                if ((localObject3 != null) && (((j.b)localObject3).type == 6) && (!bo.isNullOrNil(((j.b)localObject3).fgC)))
                {
                  localObject4 = com.tencent.mm.pluginsdk.model.app.l.d((bi)localObject2, ((j.b)localObject3).cmN);
                  if ((localObject4 != null) && ((!com.tencent.mm.vfs.e.cN(((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath)) || (com.tencent.mm.vfs.e.avI(((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_totalLen)))
                  {
                    ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[] { Long.valueOf(((dd)localObject2).field_msgId) });
                    paramAnonymousView.add(Long.valueOf(((dd)localObject2).field_msgId));
                    localg = new com.tencent.mm.i.g();
                    localg.edp = new j.6.4(this, (com.tencent.mm.pluginsdk.model.app.b)localObject4, (bi)localObject2, paramAnonymousView);
                    localg.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.aoy(), ((dd)localObject2).field_talker, ((dd)localObject2).field_msgId);
                    localg.field_aesKey = ((j.b)localObject3).ewj;
                    localg.field_fileType = 19;
                    localg.field_authKey = ((j.b)localObject3).fgI;
                    localg.eds = ((j.b)localObject3).fgC;
                    if ((localObject4 == null) || (bo.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath))) {
                      break label712;
                    }
                    localg.field_fullpath = ((com.tencent.mm.pluginsdk.model.app.b)localObject4).field_fileFullPath;
                    label378:
                    if (!com.tencent.mm.al.f.afO().b(localg, -1))
                    {
                      ab.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                      paramAnonymousView.remove(Long.valueOf(((dd)localObject2).field_msgId));
                    }
                  }
                }
              }
              int i;
              if (((bi)localObject2).dvX())
              {
                localObject3 = com.tencent.mm.at.o.ahC().gS(((dd)localObject2).field_msgSvrId);
                if (((dd)localObject2).field_isSend != 1) {
                  break label745;
                }
                if (!((com.tencent.mm.at.e)localObject3).ahh()) {
                  break label740;
                }
                i = 1;
                label451:
                if ((((com.tencent.mm.at.e)localObject3).offset < ((com.tencent.mm.at.e)localObject3).fsd) || (((com.tencent.mm.at.e)localObject3).fsd == 0))
                {
                  ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(((dd)localObject2).field_msgId) });
                  paramAnonymousView.add(Long.valueOf(((dd)localObject2).field_msgId));
                  if (!com.tencent.mm.at.o.ahD().a(((com.tencent.mm.at.e)localObject3).fDL, ((dd)localObject2).field_msgId, i, localObject2, 2130838228, new d.a()
                  {
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(31319);
                      ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.fkH.field_msgId) });
                      paramAnonymousView.remove(Long.valueOf(this.fkH.field_msgId));
                      j.6.a(j.6.this, paramAnonymousView);
                      AppMethodBeat.o(31319);
                    }
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, m paramAnonymous2m) {}
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, String paramAnonymous2String, m paramAnonymous2m)
                    {
                      AppMethodBeat.i(31318);
                      if ((paramAnonymous2Int3 == 0) && (paramAnonymous2Int4 == 0)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.fkH.field_msgId), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
                        paramAnonymousView.remove(Long.valueOf(this.fkH.field_msgId));
                        j.6.a(j.6.this, paramAnonymousView);
                        AppMethodBeat.o(31318);
                        return;
                      }
                    }
                  })) {
                    paramAnonymousView.remove(Long.valueOf(((dd)localObject2).field_msgId));
                  }
                }
              }
              if ((((bi)localObject2).byj()) || (((bi)localObject2).byk()))
              {
                localObject3 = u.vr(((dd)localObject2).field_imgPath);
                if ((localObject3 != null) && (((com.tencent.mm.modelvideo.s)localObject3).status != 199))
                {
                  paramAnonymousView.add(Long.valueOf(((dd)localObject2).field_msgId));
                  localObject4 = new j.6.2(this, (bi)localObject2, paramAnonymousView);
                  com.tencent.mm.modelvideo.o.alE().a((com.tencent.mm.modelvideo.t.a)localObject4, Looper.getMainLooper());
                  ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(((dd)localObject2).field_msgId), ((dd)localObject2).field_imgPath });
                  if (((com.tencent.mm.modelvideo.s)localObject3).alR()) {
                    ab.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                  }
                  for (i = u.vy(((dd)localObject2).field_imgPath);; i = u.vn(((dd)localObject2).field_imgPath))
                  {
                    if (i == 0) {
                      break label814;
                    }
                    paramAnonymousView.remove(Long.valueOf(((dd)localObject2).field_msgId));
                    break;
                    label712:
                    aw.aaz();
                    localg.field_fullpath = com.tencent.mm.pluginsdk.model.app.l.Z(com.tencent.mm.model.c.YS(), ((j.b)localObject3).title, ((j.b)localObject3).fgx);
                    break label378;
                    label740:
                    i = 0;
                    break label451;
                    label745:
                    if (!((com.tencent.mm.at.e)localObject3).ahh())
                    {
                      i = 0;
                      break label451;
                    }
                    localObject4 = com.tencent.mm.at.f.a((com.tencent.mm.at.e)localObject3);
                    if (!com.tencent.mm.vfs.e.cN(com.tencent.mm.at.o.ahC().q(((com.tencent.mm.at.e)localObject4).fDM, "", "")))
                    {
                      i = 0;
                      break label451;
                    }
                    i = 1;
                    break label451;
                    ab.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                  }
                }
              }
            }
            h(paramAnonymousView);
            AppMethodBeat.o(31325);
          }
        });
        this.qUH = AnimationUtils.loadAnimation(this.caz.zJz.getContext(), 2131034230);
        ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).c(new j.1(this));
        break;
        this.eiV = new com.tencent.mm.ui.tools.q((byte)0);
      }
    }
  }
  
  public final void be(bi parambi)
  {
    AppMethodBeat.i(31336);
    if (parambi == null)
    {
      ab.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
      AppMethodBeat.o(31336);
      return;
    }
    com.tencent.mm.ui.chatting.c.b.h localh = (com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
    if (localh.oC(parambi.field_msgId))
    {
      int i = localh.ces();
      this.zER.Pr(i);
      this.zER.setVisibility(0);
      this.eiV.dNV();
    }
    AppMethodBeat.o(31336);
  }
  
  public final void c(com.tencent.mm.af.t.a parama)
  {
    AppMethodBeat.i(153838);
    dHU();
    AppMethodBeat.o(153838);
  }
  
  public final void dHU()
  {
    AppMethodBeat.i(31337);
    this.caz.zJz.getController().addSearchMenu(false, this.eiV);
    this.zER.setVisibility(8);
    ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).bxH();
    ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHJ();
    ((z)this.caz.ay(z.class)).dIY();
    this.zDu = false;
    dHV();
    ((com.tencent.mm.ui.chatting.c.b.l)this.caz.ay(com.tencent.mm.ui.chatting.c.b.l.class)).cwA();
    ((com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class)).dIp();
    this.caz.hideVKB();
    com.tencent.mm.ui.chatting.k.dGm();
    AppMethodBeat.o(31337);
  }
  
  public final boolean dHW()
  {
    return this.zDu;
  }
  
  public final void dHX()
  {
    AppMethodBeat.i(31339);
    if (this.eiV != null)
    {
      this.eiV.dNV();
      this.eiV.Axg = null;
    }
    AppMethodBeat.o(31339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j
 * JD-Core Version:    0.7.0.1
 */