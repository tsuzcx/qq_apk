package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.am.1;
import com.tencent.mm.ui.chatting.am.2;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.mm.ui.tools.r.b;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.j.class)
public class k
  extends a
  implements z, com.tencent.mm.ui.chatting.c.b.j
{
  public static be Gtr;
  private boolean GjM;
  private String GpX = "";
  private boolean GrP = false;
  private ChattingFooterMoreBtnBar Gts;
  private boolean Gtt = true;
  private af dpQ;
  private com.tencent.mm.ui.tools.r fvI;
  private boolean hasInit = false;
  private Animation wtf;
  
  static
  {
    AppMethodBeat.i(35233);
    Gtr = new be(5, "MicroMsg.ChattingMoreBtnBarHelper");
    AppMethodBeat.o(35233);
  }
  
  private List<bl> eXf()
  {
    AppMethodBeat.i(169864);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWg().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[] { Long.valueOf(l) });
      az.arV();
      localLinkedList.add(com.tencent.mm.model.c.apO().rm(l));
    }
    Collections.sort(localLinkedList, new Comparator() {});
    AppMethodBeat.o(169864);
    return localLinkedList;
  }
  
  private void eXh()
  {
    AppMethodBeat.i(35228);
    if (this.GrP) {
      this.cOd.showOptionMenu(false);
    }
    for (;;)
    {
      ((ao)this.cOd.be(ao.class)).eYR();
      AppMethodBeat.o(35228);
      return;
      ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXT();
    }
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(35230);
    eXg();
    AppMethodBeat.o(35230);
  }
  
  public final boolean apE()
  {
    return this.Gtt;
  }
  
  public final void b(z.a parama) {}
  
  public final void by(bl parambl)
  {
    AppMethodBeat.i(35225);
    if (this.hasInit)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
      this.dpQ = this.cOd.zgX;
      if ((!this.cOd.eZa()) && (!((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD())) {
        break label590;
      }
    }
    label590:
    for (boolean bool = true;; bool = false)
    {
      this.GjM = bool;
      this.Gts.eVG();
      this.cOd.GzJ.getController().addSearchMenu(true, this.fvI);
      if (this.Gts != null)
      {
        this.Gts.startAnimation(this.wtf);
        this.Gts.setVisibility(0);
      }
      this.GrP = true;
      ((ae)this.cOd.be(ae.class)).eYt();
      com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
      locali.eWi();
      locali.eWh();
      locali.wA(parambl.field_msgId);
      int i = locali.deG();
      this.Gts.Yw(i);
      ((com.tencent.mm.ui.chatting.c.b.m)this.cOd.be(com.tencent.mm.ui.chatting.c.b.m.class)).eXq();
      this.cOd.hideVKB();
      eXh();
      ((q)this.cOd.be(q.class)).eXB();
      com.tencent.mm.plugin.report.service.h.vKh.f(10811, new Object[] { Integer.valueOf(1) });
      if (this.dpQ.eKB())
      {
        parambl = this.cOd;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[] { Integer.valueOf(2131302248) });
        parambl.GzK.removeOptionMenu(2131302248);
      }
      ((x)this.cOd.be(x.class)).eYd();
      AppMethodBeat.o(35225);
      return;
      this.hasInit = true;
      if (this.Gts == null)
      {
        ((ViewStub)this.cOd.findViewById(2131306440)).inflate();
        this.Gts = ((ChattingFooterMoreBtnBar)this.cOd.findViewById(2131298096));
      }
      if (((ae)this.cOd.be(ae.class)).eYA())
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        if (this.fvI == null) {}
      }
      for (this.fvI.Htp = null;; this.fvI.Htp = new r.b()
          {
            String GtB = null;
            
            public final boolean BX(String paramAnonymousString)
            {
              return false;
            }
            
            public final void BY(String paramAnonymousString)
            {
              AppMethodBeat.i(35222);
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
              Object localObject = (ae)k.this.cOd.be(ae.class);
              if (bt.isNullOrNil(paramAnonymousString)) {
                if (((ae)localObject).eYA())
                {
                  if (((ae)localObject).eYv() != null) {
                    ((ae)localObject).eYv().BW("");
                  }
                  ((ae)localObject).YP(-1);
                }
              }
              for (;;)
              {
                this.GtB = paramAnonymousString;
                AppMethodBeat.o(35222);
                return;
                if (k.h(k.this))
                {
                  if (this.GtB != null)
                  {
                    ((ae)localObject).eYt();
                    k.b(k.this).setVisibility(0);
                    localObject = (com.tencent.mm.ui.chatting.c.b.i)k.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
                    k.b(k.this).Yw(((com.tencent.mm.ui.chatting.c.b.i)localObject).deG());
                  }
                }
                else
                {
                  ((ae)localObject).eYt();
                  k.b(k.this).setVisibility(8);
                  continue;
                  com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                  k.b(k.this).setVisibility(8);
                  ((ae)localObject).eYs();
                  if (((ae)localObject).eYv() != null) {
                    ((ae)localObject).eYv().BW(paramAnonymousString);
                  }
                }
              }
            }
            
            public final void aIj()
            {
              AppMethodBeat.i(35223);
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
              com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)k.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
              if (locali.isInEditMode())
              {
                ((ae)k.this.cOd.be(ae.class)).eYt();
                k.b(k.this).setVisibility(0);
                k.b(k.this).Yw(locali.deG());
              }
              k.this.cOd.GzJ.getController().supportInvalidateOptionsMenu();
              AppMethodBeat.o(35223);
            }
            
            public final void aIk()
            {
              AppMethodBeat.i(35224);
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 21L, 1L, true);
              if (((com.tencent.mm.ui.chatting.c.b.i)k.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).isInEditMode())
              {
                ((ae)k.this.cOd.be(ae.class)).eYs();
                k.b(k.this).setVisibility(8);
              }
              AppMethodBeat.o(35224);
            }
            
            public final void aIl() {}
            
            public final void aIm() {}
          })
      {
        this.Gts.b(3, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35197);
            paramAnonymousView = (com.tencent.mm.ui.chatting.c.b.i)k.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
            if (paramAnonymousView.deG() == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              AppMethodBeat.o(35197);
              return;
            }
            final Activity localActivity = k.this.cOd.GzJ.getContext();
            com.tencent.mm.ui.base.h.a(localActivity, localActivity.getString(2131757553), "", localActivity.getString(2131758038), localActivity.getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(35196);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                com.tencent.mm.ui.chatting.i.a(localActivity, paramAnonymousView.eWg(), k.this);
                k.this.eXg();
                AppMethodBeat.o(35196);
              }
            }, null, 2131099904);
            AppMethodBeat.o(35197);
          }
        });
        this.Gts.b(2, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35198);
            if (((com.tencent.mm.ui.chatting.c.b.i)k.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).deG() == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              AppMethodBeat.o(35198);
              return;
            }
            com.tencent.mm.ui.chatting.m.a(k.this.cOd, k.c(k.this), k.d(k.this), k.this, k.e(k.this));
            AppMethodBeat.o(35198);
          }
        });
        this.Gts.b(1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35199);
            paramAnonymousView = (com.tencent.mm.ui.chatting.c.b.i)k.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
            if ((paramAnonymousView == null) || (paramAnonymousView.deG() == 0))
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              AppMethodBeat.o(35199);
              return;
            }
            paramAnonymousView = k.c(k.this);
            if (com.tencent.mm.ui.chatting.j.hx(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(k.this.cOd.GzJ.getContext(), k.this.cOd.GzJ.getContext().getString(2131757937), "", k.this.cOd.GzJ.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.j.hy(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(k.this.cOd.GzJ.getContext(), k.this.cOd.GzJ.getContext().getString(2131757938), "", k.this.cOd.GzJ.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.j.hw(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(k.this.cOd.GzJ.getContext(), k.this.cOd.GzJ.getContext().getString(2131757939), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.n.a(k.this.cOd, paramAnonymousView, k.e(k.this))) {
              k.this.eXg();
            }
            AppMethodBeat.o(35199);
          }
        });
        this.Gts.b(0, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35202);
            if (((com.tencent.mm.ui.chatting.c.b.i)k.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).deG() == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              AppMethodBeat.o(35202);
              return;
            }
            if (((com.tencent.mm.model.w.sE(k.e(k.this).field_username)) && (!com.tencent.mm.am.f.pc(k.e(k.this).field_username))) || (com.tencent.mm.model.w.tp(k.e(k.this).field_username)))
            {
              k.a(k.this, true);
              com.tencent.mm.ui.chatting.k.a(k.this.cOd.GzJ.getContext(), k.c(k.this), k.d(k.this), k.e(k.this).field_username, k.this);
              AppMethodBeat.o(35202);
              return;
            }
            paramAnonymousView = new com.tencent.mm.ui.widget.a.e(k.this.cOd.GzJ.getContext(), 1, false);
            paramAnonymousView.HrX = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(35200);
                paramAnonymous2l.jj(0, 2131761385);
                paramAnonymous2l.jj(1, 2131761386);
                if (WWAPIFactory.kS(k.this.cOd.GzJ.getContext()).fqp()) {
                  paramAnonymous2l.c(2, k.this.cOd.GzJ.getContext().getString(2131761387, new Object[] { WWAPIFactory.kS(k.this.cOd.GzJ.getContext()).fqq() }));
                }
                AppMethodBeat.o(35200);
              }
            };
            paramAnonymousView.HrY = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(35201);
                if (k.f(k.this) > com.tencent.mm.m.b.YM())
                {
                  com.tencent.mm.ui.base.t.makeText(k.this.cOd.GzJ.getContext(), k.this.cOd.GzJ.getContext().getString(2131759065, new Object[] { bt.mK(com.tencent.mm.m.b.YM()) }), 0).show();
                  AppMethodBeat.o(35201);
                  return;
                }
                switch (paramAnonymous2MenuItem.getItemId())
                {
                default: 
                  AppMethodBeat.o(35201);
                  return;
                case 0: 
                  k.a(k.this, true);
                  com.tencent.mm.ui.chatting.k.a(k.this.cOd.GzJ.getContext(), k.c(k.this), k.d(k.this), k.e(k.this).field_username, k.this);
                  AppMethodBeat.o(35201);
                  return;
                case 1: 
                  k.a(k.this, false);
                  com.tencent.mm.ui.chatting.k.a(k.this.cOd.GzJ.getContext(), k.c(k.this), k.d(k.this), k.e(k.this).field_username, k.this);
                  AppMethodBeat.o(35201);
                  return;
                }
                paramAnonymous2MenuItem = k.this.cOd.GzJ.getContext();
                af localaf = k.e(k.this);
                List localList = k.c(k.this);
                boolean bool = k.d(k.this);
                if ((localList == null) || (localList.size() == 0)) {}
                for (;;)
                {
                  k.this.eXg();
                  break;
                  if (com.tencent.mm.ui.chatting.j.hw(localList))
                  {
                    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
                    com.tencent.mm.ui.base.h.a(paramAnonymous2MenuItem, paramAnonymous2MenuItem.getString(2131757940), "", new am.1(), null);
                  }
                  else if (!com.tencent.mm.ui.chatting.j.a(true, localList, localaf.field_username, null))
                  {
                    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                    com.tencent.mm.ui.base.h.d(paramAnonymous2MenuItem, paramAnonymous2MenuItem.getString(2131760349), "", paramAnonymous2MenuItem.getString(2131762559), paramAnonymous2MenuItem.getString(2131755691), new am.2(paramAnonymous2MenuItem, localaf, localList, bool), null);
                  }
                  else
                  {
                    am.a(paramAnonymous2MenuItem, localaf, localList, bool);
                  }
                }
              }
            };
            paramAnonymousView.csG();
            AppMethodBeat.o(35202);
          }
        });
        this.Gts.b(4, new View.OnClickListener()
        {
          private void c(cs paramAnonymouscs)
          {
            AppMethodBeat.i(35212);
            paramAnonymouscs.deQ.fragment = k.this.cOd.GzJ;
            paramAnonymouscs.deQ.deW = 41;
            paramAnonymouscs.deQ.deY = new com.tencent.mm.ui.widget.snackbar.a.c()
            {
              public final void aXN()
              {
                AppMethodBeat.i(35205);
                ((q)k.this.cOd.be(q.class)).eXA();
                AppMethodBeat.o(35205);
              }
              
              public final void onHide()
              {
                AppMethodBeat.i(35204);
                k.this.eXg();
                AppMethodBeat.o(35204);
              }
              
              public final void onShow()
              {
                AppMethodBeat.i(35203);
                k.this.eXg();
                k.b(k.this).setVisibility(4);
                AppMethodBeat.o(35203);
              }
            };
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymouscs);
            int i;
            Object localObject1;
            long l;
            label89:
            Object localObject2;
            if (paramAnonymouscs.deR.ret == 0)
            {
              i = 1;
              localObject1 = k.c(k.this);
              l = bt.aGK();
              Iterator localIterator = ((List)localObject1).iterator();
              while (localIterator.hasNext())
              {
                localObject1 = (bl)localIterator.next();
                if (((bl)localObject1).cxB())
                {
                  localObject2 = k.b.rx(bt.aGg(((du)localObject1).field_content));
                  if ((localObject2 != null) && (((k.b)localObject2).type == 5) && (!bt.isNullOrNil(((k.b)localObject2).url))) {
                    if (!((bl)localObject1).eJL()) {
                      break label645;
                    }
                  }
                }
              }
            }
            label645:
            for (int j = 1;; j = 2)
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject2).url, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(1) });
              localObject1 = "";
              try
              {
                localObject2 = URLEncoder.encode(((k.b)localObject2).url, "UTF-8");
                localObject1 = localObject2;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", localUnsupportedEncodingException, "", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
              break label89;
              i = 2;
              break;
              if (paramAnonymouscs.deR.ret == 0)
              {
                if (14 != paramAnonymouscs.deQ.type)
                {
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                  AppMethodBeat.o(35212);
                  return;
                }
                if (paramAnonymouscs.deQ.deT == null)
                {
                  com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                  AppMethodBeat.o(35212);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.vKh.f(11142, new Object[] { Integer.valueOf(paramAnonymouscs.deQ.deT.DiS), Integer.valueOf(paramAnonymouscs.deQ.deT.DiT), Integer.valueOf(paramAnonymouscs.deQ.deT.DiU), Integer.valueOf(paramAnonymouscs.deQ.deT.rBj), Integer.valueOf(paramAnonymouscs.deQ.deT.DiV), Integer.valueOf(paramAnonymouscs.deQ.deT.DiW), Integer.valueOf(paramAnonymouscs.deQ.deT.DiX), Integer.valueOf(paramAnonymouscs.deQ.deT.fileCount), Integer.valueOf(paramAnonymouscs.deQ.deT.DiY), Integer.valueOf(paramAnonymouscs.deQ.deT.DiZ), Integer.valueOf(paramAnonymouscs.deQ.deT.Dja), Integer.valueOf(paramAnonymouscs.deQ.deT.Djb), Integer.valueOf(paramAnonymouscs.deQ.deT.Djc), Integer.valueOf(paramAnonymouscs.deQ.deT.Djd), Integer.valueOf(paramAnonymouscs.deQ.deT.Dje) });
              }
              AppMethodBeat.o(35212);
              return;
            }
          }
          
          private void h(HashSet<Long> paramAnonymousHashSet)
          {
            AppMethodBeat.i(35215);
            if (paramAnonymousHashSet.isEmpty()) {
              new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(35210);
                  k.6.this.eXk();
                  AppMethodBeat.o(35210);
                }
              });
            }
            AppMethodBeat.o(35215);
          }
          
          private static String hC(List<bl> paramAnonymousList)
          {
            AppMethodBeat.i(35213);
            StringBuffer localStringBuffer = new StringBuffer();
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext()) {
              localStringBuffer.append(((bl)paramAnonymousList.next()).field_msgId);
            }
            paramAnonymousList = localStringBuffer.toString();
            AppMethodBeat.o(35213);
            return paramAnonymousList;
          }
          
          private static void hD(List<bl> paramAnonymousList)
          {
            AppMethodBeat.i(35217);
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              bl localbl = (bl)paramAnonymousList.next();
              com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Gjw, a.d.GjB, localbl, 0);
            }
            AppMethodBeat.o(35217);
          }
          
          public final void eXk()
          {
            AppMethodBeat.i(35216);
            k.a(k.this, "");
            final List localList = k.c(k.this);
            if (com.tencent.mm.ui.chatting.j.hx(localList))
            {
              com.tencent.mm.ui.base.h.a(k.this.cOd.GzJ.getContext(), k.this.cOd.GzJ.getContext().getString(2131758900), "", k.this.cOd.GzJ.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35216);
              return;
            }
            final cs localcs = new cs();
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { k.e(k.this).field_username });
            Object localObject1;
            Object localObject2;
            Object localObject3;
            if ((localList != null) && (localList.size() == 1))
            {
              localObject1 = (bl)localList.get(0);
              if ((localObject1 != null) && ((((bl)localObject1).cxB()) || (((bl)localObject1).eJL())))
              {
                localObject2 = y.tD(((du)localObject1).field_msgSvrId);
                localObject3 = y.arz().E((String)localObject2, true);
                ((y.b)localObject3).m("prePublishId", "msg_" + ((du)localObject1).field_msgSvrId);
                boolean bool = ((com.tencent.mm.ui.chatting.c.b.d)k.this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC();
                ((y.b)localObject3).m("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a((bl)localObject1, k.d(k.this), bool));
                ((y.b)localObject3).m("preChatName", k.e(k.this).field_username);
                ((y.b)localObject3).m("preMsgIndex", Integer.valueOf(0));
                ((y.b)localObject3).m("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.c.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.c.j.class)).a("adExtStr", (y.b)localObject3, (bl)localObject1);
                localcs.deQ.sessionId = ((String)localObject2);
              }
            }
            if (com.tencent.mm.pluginsdk.model.i.a(k.this.cOd.GzJ.getContext(), localcs, k.e(k.this).field_username, localList, true))
            {
              localObject1 = localList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (bl)((Iterator)localObject1).next();
                if (((bl)localObject2).cxB()) {
                  com.tencent.mm.modelstat.b.huc.c((bl)localObject2, com.tencent.mm.ai.l.r((bl)localObject2));
                } else {
                  com.tencent.mm.modelstat.b.huc.P((bl)localObject2);
                }
              }
              c(localcs);
              hD(k.c(k.this));
              AppMethodBeat.o(35216);
              return;
            }
            if (k.c(k.this).size() > 1)
            {
              localObject3 = k.this.cOd.GzJ.getContext();
              if (localcs.deQ.deV >= 0)
              {
                localObject1 = k.this.cOd.GzJ.getContext().getString(2131758899);
                if (localcs.deQ.deV < 0) {
                  break label642;
                }
              }
              label642:
              for (localObject2 = k.this.cOd.GzJ.getContext().getString(2131757560);; localObject2 = k.this.cOd.GzJ.getContext().getString(2131761941))
              {
                com.tencent.mm.ui.base.h.d((Context)localObject3, (String)localObject1, "", (String)localObject2, k.this.cOd.GzJ.getContext().getString(2131757558), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(35211);
                    paramAnonymous2DialogInterface = localList.iterator();
                    while (paramAnonymous2DialogInterface.hasNext())
                    {
                      bl localbl = (bl)paramAnonymous2DialogInterface.next();
                      if ((!localbl.eLZ()) && (!localbl.eLY()))
                      {
                        if ((localcs.deQ.type == 14) && (localcs.deQ.deS.mVb.size() == 0))
                        {
                          k.this.eXg();
                          AppMethodBeat.o(35211);
                          return;
                        }
                        k.6.a(k.6.this, localcs);
                        k.6.hE(k.c(k.this));
                        AppMethodBeat.o(35211);
                        return;
                      }
                    }
                    AppMethodBeat.o(35211);
                  }
                }, null);
                AppMethodBeat.o(35216);
                return;
                localObject1 = k.this.cOd.GzJ.getContext().getString(2131758898);
                break;
              }
            }
            com.tencent.mm.ui.base.h.j(k.this.cOd.GzJ.getContext(), localcs.deQ.deV, 0);
            AppMethodBeat.o(35216);
          }
          
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35214);
            Object localObject1 = k.c(k.this);
            paramAnonymousView = new HashSet();
            Object localObject2 = hC((List)localObject1);
            if (((String)localObject2).equals(k.g(k.this)))
            {
              com.tencent.mm.ui.base.t.makeText(k.this.cOd.GzJ.getContext(), k.this.cOd.GzJ.getContext().getString(2131758828), 0).show();
              AppMethodBeat.o(35214);
              return;
            }
            k.a(k.this, (String)localObject2);
            localObject1 = ((List)localObject1).iterator();
            label814:
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (bl)((Iterator)localObject1).next();
              Object localObject3;
              Object localObject4;
              com.tencent.mm.i.g localg;
              if (((bl)localObject2).cxB())
              {
                localObject3 = k.b.rx(((du)localObject2).field_content);
                if ((localObject3 != null) && (((k.b)localObject3).type == 6) && (!bt.isNullOrNil(((k.b)localObject3).gHk)))
                {
                  localObject4 = com.tencent.mm.pluginsdk.model.app.m.c((bl)localObject2, ((k.b)localObject3).dbA);
                  if ((localObject4 != null) && ((!com.tencent.mm.vfs.i.eK(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath)) || (com.tencent.mm.vfs.i.aMN(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen)))
                  {
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[] { Long.valueOf(((du)localObject2).field_msgId) });
                    paramAnonymousView.add(Long.valueOf(((du)localObject2).field_msgId));
                    localg = new com.tencent.mm.i.g();
                    localg.fnH = new g.a()
                    {
                      public final int a(String paramAnonymous2String, int paramAnonymous2Int, com.tencent.mm.i.c paramAnonymous2c, com.tencent.mm.i.d paramAnonymous2d, boolean paramAnonymous2Boolean)
                      {
                        AppMethodBeat.i(35209);
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2c != null))
                        {
                          this.GmS.field_offset = paramAnonymous2c.field_finishedLength;
                          com.tencent.mm.pluginsdk.model.app.ap.bxS().a(this.GmS, new String[0]);
                        }
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2d != null) && (paramAnonymous2d.field_retCode == 0))
                        {
                          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[] { Long.valueOf(this.gLQ.field_msgId) });
                          this.GmS.field_status = 199L;
                          this.GmS.field_offset = this.GmS.field_totalLen;
                          com.tencent.mm.pluginsdk.model.app.ap.bxS().a(this.GmS, new String[0]);
                          this.gLQ.setStatus(3);
                          az.arV();
                          com.tencent.mm.model.c.apO().a(this.gLQ.field_msgId, this.gLQ);
                          paramAnonymousView.remove(Long.valueOf(this.gLQ.field_msgId));
                          k.6.a(k.6.this, paramAnonymousView);
                        }
                        long l;
                        if ((paramAnonymous2Int != 0) || ((paramAnonymous2d != null) && (paramAnonymous2d.field_retCode != 0)))
                        {
                          l = this.gLQ.field_msgId;
                          if (paramAnonymous2d != null) {
                            break label283;
                          }
                        }
                        label283:
                        for (int i = 0;; i = paramAnonymous2d.field_retCode)
                        {
                          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymous2Int), Integer.valueOf(i) });
                          paramAnonymousView.remove(Long.valueOf(this.gLQ.field_msgId));
                          k.6.a(k.6.this, paramAnonymousView);
                          AppMethodBeat.o(35209);
                          return 0;
                        }
                      }
                      
                      public final void a(String paramAnonymous2String, ByteArrayOutputStream paramAnonymous2ByteArrayOutputStream) {}
                      
                      public final byte[] f(String paramAnonymous2String, byte[] paramAnonymous2ArrayOfByte)
                      {
                        return new byte[0];
                      }
                    };
                    localg.field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.eGO(), ((du)localObject2).field_talker, ((du)localObject2).field_msgId);
                    localg.field_aesKey = ((k.b)localObject3).fMw;
                    localg.field_fileType = 19;
                    localg.field_authKey = ((k.b)localObject3).gHq;
                    localg.fnK = ((k.b)localObject3).gHk;
                    if ((localObject4 == null) || (bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath))) {
                      break label712;
                    }
                    localg.field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath;
                    label378:
                    if (!com.tencent.mm.ao.f.awL().b(localg, -1))
                    {
                      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                      paramAnonymousView.remove(Long.valueOf(((du)localObject2).field_msgId));
                    }
                  }
                }
              }
              int i;
              if (((bl)localObject2).eJO())
              {
                localObject3 = com.tencent.mm.aw.o.ayF().mr(((du)localObject2).field_msgSvrId);
                if (((du)localObject2).field_isSend != 1) {
                  break label745;
                }
                if (!((com.tencent.mm.aw.e)localObject3).ayi()) {
                  break label740;
                }
                i = 1;
                label451:
                if ((((com.tencent.mm.aw.e)localObject3).offset < ((com.tencent.mm.aw.e)localObject3).gTY) || (((com.tencent.mm.aw.e)localObject3).gTY == 0))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(((du)localObject2).field_msgId) });
                  paramAnonymousView.add(Long.valueOf(((du)localObject2).field_msgId));
                  if (!com.tencent.mm.aw.o.ayG().a(((com.tencent.mm.aw.e)localObject3).deI, ((du)localObject2).field_msgId, i, localObject2, 2131231564, new d.a()
                  {
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(35208);
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.gLQ.field_msgId) });
                      paramAnonymousView.remove(Long.valueOf(this.gLQ.field_msgId));
                      k.6.a(k.6.this, paramAnonymousView);
                      AppMethodBeat.o(35208);
                    }
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, com.tencent.mm.al.n paramAnonymous2n) {}
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
                    {
                      AppMethodBeat.i(35207);
                      if ((paramAnonymous2Int3 == 0) && (paramAnonymous2Int4 == 0)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.gLQ.field_msgId), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
                        paramAnonymousView.remove(Long.valueOf(this.gLQ.field_msgId));
                        k.6.a(k.6.this, paramAnonymousView);
                        AppMethodBeat.o(35207);
                        return;
                      }
                    }
                  })) {
                    paramAnonymousView.remove(Long.valueOf(((du)localObject2).field_msgId));
                  }
                }
              }
              if ((((bl)localObject2).cjM()) || (((bl)localObject2).cjO()))
              {
                localObject3 = com.tencent.mm.modelvideo.u.Ae(((du)localObject2).field_imgPath);
                if ((localObject3 != null) && (((s)localObject3).status != 199))
                {
                  paramAnonymousView.add(Long.valueOf(((du)localObject2).field_msgId));
                  localObject4 = new t.a()
                  {
                    public final void a(t.a.a paramAnonymous2a)
                    {
                      AppMethodBeat.i(35206);
                      if (this.gLQ.field_imgPath.equals(paramAnonymous2a.fileName))
                      {
                        s locals = com.tencent.mm.modelvideo.u.Ae(paramAnonymous2a.fileName);
                        if ((locals == null) || (!locals.aCW())) {
                          break label114;
                        }
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.gLQ.field_msgId), paramAnonymous2a.fileName });
                      }
                      for (;;)
                      {
                        com.tencent.mm.modelvideo.o.aCI().a(this);
                        paramAnonymousView.remove(Long.valueOf(this.gLQ.field_msgId));
                        k.6.a(k.6.this, paramAnonymousView);
                        AppMethodBeat.o(35206);
                        return;
                        label114:
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.gLQ.field_msgId), paramAnonymous2a.fileName });
                      }
                    }
                  };
                  com.tencent.mm.modelvideo.o.aCI().a((t.a)localObject4, Looper.getMainLooper());
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(((du)localObject2).field_msgId), ((du)localObject2).field_imgPath });
                  if (((s)localObject3).aCV()) {
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                  }
                  for (i = com.tencent.mm.modelvideo.u.Al(((du)localObject2).field_imgPath);; i = com.tencent.mm.modelvideo.u.zZ(((du)localObject2).field_imgPath))
                  {
                    if (i == 0) {
                      break label814;
                    }
                    paramAnonymousView.remove(Long.valueOf(((du)localObject2).field_msgId));
                    break;
                    label712:
                    az.arV();
                    localg.field_fullpath = com.tencent.mm.pluginsdk.model.app.m.ai(com.tencent.mm.model.c.aqe(), ((k.b)localObject3).title, ((k.b)localObject3).gHf);
                    break label378;
                    label740:
                    i = 0;
                    break label451;
                    label745:
                    if (!((com.tencent.mm.aw.e)localObject3).ayi())
                    {
                      i = 0;
                      break label451;
                    }
                    localObject4 = com.tencent.mm.aw.f.a((com.tencent.mm.aw.e)localObject3);
                    if (!com.tencent.mm.vfs.i.eK(com.tencent.mm.aw.o.ayF().p(((com.tencent.mm.aw.e)localObject4).hgj, "", "")))
                    {
                      i = 0;
                      break label451;
                    }
                    i = 1;
                    break label451;
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                  }
                }
              }
            }
            h(paramAnonymousView);
            AppMethodBeat.o(35214);
          }
        });
        this.wtf = AnimationUtils.loadAnimation(this.cOd.GzJ.getContext(), 2130772108);
        ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).g(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35195);
            com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)k.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
            if (locali.wA(((Long)paramAnonymousView.getTag()).longValue()))
            {
              int i = locali.deG();
              ((ae)k.this.cOd.be(ae.class)).eYt();
              k.a(k.this).fdW();
              k.b(k.this).setVisibility(0);
              k.b(k.this).Yw(i);
            }
            AppMethodBeat.o(35195);
          }
        });
        break;
        this.fvI = new com.tencent.mm.ui.tools.r((byte)0);
      }
    }
  }
  
  public final void bz(bl parambl)
  {
    AppMethodBeat.i(35226);
    if (parambl == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
      AppMethodBeat.o(35226);
      return;
    }
    com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
    if (locali.wA(parambl.field_msgId))
    {
      int i = locali.deG();
      this.Gts.Yw(i);
      this.Gts.setVisibility(0);
      this.fvI.fdW();
    }
    AppMethodBeat.o(35226);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35231);
    eXg();
    AppMethodBeat.o(35231);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(169865);
    super.eWx();
    if (this.GrP) {
      eXg();
    }
    AppMethodBeat.o(169865);
  }
  
  public final void eXg()
  {
    AppMethodBeat.i(35227);
    this.cOd.GzJ.getController().addSearchMenu(false, this.fvI);
    if (this.Gts != null) {
      this.Gts.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).ciV();
    ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWQ();
    ((ae)this.cOd.be(ae.class)).eYt();
    this.GrP = false;
    eXh();
    ((com.tencent.mm.ui.chatting.c.b.m)this.cOd.be(com.tencent.mm.ui.chatting.c.b.m.class)).dCM();
    ((q)this.cOd.be(q.class)).eXB();
    this.cOd.hideVKB();
    com.tencent.mm.ui.chatting.k.eVm();
    AppMethodBeat.o(35227);
  }
  
  public final boolean eXi()
  {
    return this.GrP;
  }
  
  public final void eXj()
  {
    AppMethodBeat.i(35229);
    if (this.fvI != null)
    {
      this.fvI.fdW();
      this.fvI.Htp = null;
    }
    AppMethodBeat.o(35229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.k
 * JD-Core Version:    0.7.0.1
 */