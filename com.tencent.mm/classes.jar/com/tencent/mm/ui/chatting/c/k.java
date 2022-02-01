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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.l;
import com.tencent.mm.ah.z;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.av.d.a;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ad;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
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

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.j.class)
public class k
  extends a
  implements z, com.tencent.mm.ui.chatting.c.b.j
{
  public static bd HTk;
  private boolean HJB;
  private String HPP = "";
  private boolean HRH = false;
  private ChattingFooterMoreBtnBar HTl;
  private boolean HTm = true;
  private ai dnB;
  private r fzp;
  private boolean hasInit = false;
  private Animation xEv;
  
  static
  {
    AppMethodBeat.i(35233);
    HTk = new bd(5, "MicroMsg.ChattingMoreBtnBarHelper");
    AppMethodBeat.o(35233);
  }
  
  private List<bo> fmR()
  {
    AppMethodBeat.i(169864);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).flS().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      ac.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[] { Long.valueOf(l) });
      az.ayM();
      localLinkedList.add(com.tencent.mm.model.c.awD().vP(l));
    }
    Collections.sort(localLinkedList, new Comparator() {});
    AppMethodBeat.o(169864);
    return localLinkedList;
  }
  
  private void fmT()
  {
    AppMethodBeat.i(35228);
    if (this.HRH) {
      this.cLy.showOptionMenu(false);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.chatting.c.b.ao)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).foH();
      AppMethodBeat.o(35228);
      return;
      ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnF();
    }
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(35230);
    fmS();
    AppMethodBeat.o(35230);
  }
  
  public final boolean awt()
  {
    return this.HTm;
  }
  
  public final void b(z.a parama) {}
  
  public final void bA(bo parambo)
  {
    AppMethodBeat.i(35225);
    if (this.hasInit)
    {
      ac.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
      this.dnB = this.cLy.AzG;
      if ((!this.cLy.foP()) && (!((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp())) {
        break label592;
      }
    }
    label592:
    for (boolean bool = true;; bool = false)
    {
      this.HJB = bool;
      this.HTl.fls();
      this.cLy.HZF.getController().addSearchMenu(true, this.fzp);
      if (this.HTl != null)
      {
        this.HTl.startAnimation(this.xEv);
        this.HTl.setVisibility(0);
      }
      this.HRH = true;
      ((ae)this.cLy.bf(ae.class)).fof();
      com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
      locali.flU();
      locali.flT();
      locali.Bd(parambo.field_msgId);
      int i = locali.dsn();
      this.HTl.aaH(i);
      ((com.tencent.mm.ui.chatting.c.b.m)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.m.class)).fnc();
      this.cLy.hideVKB();
      fmT();
      ((q)this.cLy.bf(q.class)).fnn();
      com.tencent.mm.plugin.report.service.h.wUl.f(10811, new Object[] { Integer.valueOf(1) });
      if (this.dnB.fad())
      {
        parambo = this.cLy;
        ac.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[] { Integer.valueOf(2131302248) });
        parambo.HZG.removeOptionMenu(2131302248);
      }
      ((x)this.cLy.bf(x.class)).fnP();
      AppMethodBeat.o(35225);
      return;
      this.hasInit = true;
      if (this.HTl == null)
      {
        ((ViewStub)this.cLy.findViewById(2131306440)).inflate();
        this.HTl = ((ChattingFooterMoreBtnBar)this.cLy.findViewById(2131298096));
      }
      if (((ae)this.cLy.bf(ae.class)).fom())
      {
        ac.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        if (this.fzp == null) {}
      }
      for (this.fzp.ITM = null;; this.fzp.ITM = new r.b()
          {
            String HTu = null;
            
            public final boolean Ga(String paramAnonymousString)
            {
              return false;
            }
            
            public final void Gb(String paramAnonymousString)
            {
              AppMethodBeat.i(35222);
              ac.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
              Object localObject = (ae)k.this.cLy.bf(ae.class);
              if (bs.isNullOrNil(paramAnonymousString)) {
                if (((ae)localObject).fom())
                {
                  if (((ae)localObject).foh() != null) {
                    ((ae)localObject).foh().FZ("");
                  }
                  ((ae)localObject).aba(-1);
                }
              }
              for (;;)
              {
                this.HTu = paramAnonymousString;
                AppMethodBeat.o(35222);
                return;
                if (k.h(k.this))
                {
                  if (this.HTu != null)
                  {
                    ((ae)localObject).fof();
                    k.b(k.this).setVisibility(0);
                    localObject = (com.tencent.mm.ui.chatting.c.b.i)k.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
                    k.b(k.this).aaH(((com.tencent.mm.ui.chatting.c.b.i)localObject).dsn());
                  }
                }
                else
                {
                  ((ae)localObject).fof();
                  k.b(k.this).setVisibility(8);
                  continue;
                  ac.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                  k.b(k.this).setVisibility(8);
                  ((ae)localObject).foe();
                  if (((ae)localObject).foh() != null) {
                    ((ae)localObject).foh().FZ(paramAnonymousString);
                  }
                }
              }
            }
            
            public final void aPa()
            {
              AppMethodBeat.i(35223);
              ac.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
              com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)k.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
              if (locali.isInEditMode())
              {
                ((ae)k.this.cLy.bf(ae.class)).fof();
                k.b(k.this).setVisibility(0);
                k.b(k.this).aaH(locali.dsn());
              }
              k.this.cLy.HZF.getController().supportInvalidateOptionsMenu();
              AppMethodBeat.o(35223);
            }
            
            public final void aPb()
            {
              AppMethodBeat.i(35224);
              ac.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 21L, 1L, true);
              if (((com.tencent.mm.ui.chatting.c.b.i)k.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).isInEditMode())
              {
                ((ae)k.this.cLy.bf(ae.class)).foe();
                k.b(k.this).setVisibility(8);
              }
              AppMethodBeat.o(35224);
            }
            
            public final void aPc() {}
            
            public final void aPd() {}
          })
      {
        this.HTl.b(3, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35197);
            paramAnonymousView = (com.tencent.mm.ui.chatting.c.b.i)k.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
            if (paramAnonymousView.dsn() == 0)
            {
              ac.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              AppMethodBeat.o(35197);
              return;
            }
            final Activity localActivity = k.this.cLy.HZF.getContext();
            com.tencent.mm.ui.base.h.a(localActivity, localActivity.getString(2131757553), "", localActivity.getString(2131758038), localActivity.getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(35196);
                ac.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                com.tencent.mm.ui.chatting.i.a(localActivity, paramAnonymousView.flS(), k.this);
                k.this.fmS();
                AppMethodBeat.o(35196);
              }
            }, null, 2131099904);
            AppMethodBeat.o(35197);
          }
        });
        this.HTl.b(2, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35198);
            if (((com.tencent.mm.ui.chatting.c.b.i)k.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).dsn() == 0)
            {
              ac.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              AppMethodBeat.o(35198);
              return;
            }
            com.tencent.mm.ui.chatting.m.a(k.this.cLy, k.c(k.this), k.d(k.this), k.this, k.e(k.this));
            AppMethodBeat.o(35198);
          }
        });
        this.HTl.b(1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35199);
            paramAnonymousView = (com.tencent.mm.ui.chatting.c.b.i)k.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
            if ((paramAnonymousView == null) || (paramAnonymousView.dsn() == 0))
            {
              ac.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              AppMethodBeat.o(35199);
              return;
            }
            paramAnonymousView = k.c(k.this);
            if (com.tencent.mm.ui.chatting.j.hK(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(k.this.cLy.HZF.getContext(), k.this.cLy.HZF.getContext().getString(2131757937), "", k.this.cLy.HZF.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.j.hL(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(k.this.cLy.HZF.getContext(), k.this.cLy.HZF.getContext().getString(2131757938), "", k.this.cLy.HZF.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.j.hJ(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(k.this.cLy.HZF.getContext(), k.this.cLy.HZF.getContext().getString(2131757939), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.n.a(k.this.cLy, paramAnonymousView, k.e(k.this))) {
              k.this.fmS();
            }
            AppMethodBeat.o(35199);
          }
        });
        this.HTl.b(0, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35202);
            if (((com.tencent.mm.ui.chatting.c.b.i)k.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).dsn() == 0)
            {
              ac.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              AppMethodBeat.o(35202);
              return;
            }
            if (((com.tencent.mm.model.w.wH(k.e(k.this).field_username)) && (!com.tencent.mm.al.f.so(k.e(k.this).field_username))) || (com.tencent.mm.model.w.xs(k.e(k.this).field_username)))
            {
              k.a(k.this, true);
              com.tencent.mm.ui.chatting.k.a(k.this.cLy.HZF.getContext(), k.c(k.this), k.d(k.this), k.e(k.this).field_username, k.this);
              AppMethodBeat.o(35202);
              return;
            }
            paramAnonymousView = new com.tencent.mm.ui.widget.a.e(k.this.cLy.HZF.getContext(), 1, false);
            paramAnonymousView.ISu = new k.5.1(this);
            paramAnonymousView.ISv = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(35201);
                if (k.f(k.this) > com.tencent.mm.m.b.ZJ())
                {
                  com.tencent.mm.ui.base.t.makeText(k.this.cLy.HZF.getContext(), k.this.cLy.HZF.getContext().getString(2131759065, new Object[] { bs.qz(com.tencent.mm.m.b.ZJ()) }), 0).show();
                  AppMethodBeat.o(35201);
                  return;
                }
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(35201);
                  return;
                  k.a(k.this, true);
                  com.tencent.mm.ui.chatting.k.a(k.this.cLy.HZF.getContext(), k.c(k.this), k.d(k.this), k.e(k.this).field_username, k.this);
                  AppMethodBeat.o(35201);
                  return;
                  k.a(k.this, false);
                  com.tencent.mm.ui.chatting.k.a(k.this.cLy.HZF.getContext(), k.c(k.this), k.d(k.this), k.e(k.this).field_username, k.this);
                  AppMethodBeat.o(35201);
                  return;
                  am.b(k.this.cLy.HZF.getContext(), k.e(k.this), k.c(k.this), k.d(k.this));
                  k.this.fmS();
                }
              }
            };
            paramAnonymousView.cED();
            AppMethodBeat.o(35202);
          }
        });
        this.HTl.b(4, new View.OnClickListener()
        {
          private void c(cs paramAnonymouscs)
          {
            AppMethodBeat.i(35212);
            paramAnonymouscs.dck.fragment = k.this.cLy.HZF;
            paramAnonymouscs.dck.dcq = 41;
            paramAnonymouscs.dck.dcs = new com.tencent.mm.ui.widget.snackbar.a.c()
            {
              public final void beK()
              {
                AppMethodBeat.i(35205);
                ((q)k.this.cLy.bf(q.class)).fnm();
                AppMethodBeat.o(35205);
              }
              
              public final void onHide()
              {
                AppMethodBeat.i(35204);
                k.this.fmS();
                AppMethodBeat.o(35204);
              }
              
              public final void onShow()
              {
                AppMethodBeat.i(35203);
                k.this.fmS();
                k.b(k.this).setVisibility(4);
                AppMethodBeat.o(35203);
              }
            };
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymouscs);
            int i;
            Object localObject1;
            long l;
            label89:
            Object localObject2;
            if (paramAnonymouscs.dcl.ret == 0)
            {
              i = 1;
              localObject1 = k.c(k.this);
              l = bs.aNx();
              Iterator localIterator = ((List)localObject1).iterator();
              while (localIterator.hasNext())
              {
                localObject1 = (bo)localIterator.next();
                if (((bo)localObject1).cKN())
                {
                  localObject2 = k.b.vA(bs.aLx(((dy)localObject1).field_content));
                  if ((localObject2 != null) && (((k.b)localObject2).type == 5) && (!bs.isNullOrNil(((k.b)localObject2).url))) {
                    if (!((bo)localObject1).eZj()) {
                      break label645;
                    }
                  }
                }
              }
            }
            label645:
            for (int j = 1;; j = 2)
            {
              ac.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject2).url, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(1) });
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
                  ac.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", localUnsupportedEncodingException, "", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
              break label89;
              i = 2;
              break;
              if (paramAnonymouscs.dcl.ret == 0)
              {
                if (14 != paramAnonymouscs.dck.type)
                {
                  ac.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                  AppMethodBeat.o(35212);
                  return;
                }
                if (paramAnonymouscs.dck.dcn == null)
                {
                  ac.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                  AppMethodBeat.o(35212);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.wUl.f(11142, new Object[] { Integer.valueOf(paramAnonymouscs.dck.dcn.EBY), Integer.valueOf(paramAnonymouscs.dck.dcn.EBZ), Integer.valueOf(paramAnonymouscs.dck.dcn.ECa), Integer.valueOf(paramAnonymouscs.dck.dcn.sKb), Integer.valueOf(paramAnonymouscs.dck.dcn.ECb), Integer.valueOf(paramAnonymouscs.dck.dcn.ECc), Integer.valueOf(paramAnonymouscs.dck.dcn.ECd), Integer.valueOf(paramAnonymouscs.dck.dcn.fileCount), Integer.valueOf(paramAnonymouscs.dck.dcn.ECe), Integer.valueOf(paramAnonymouscs.dck.dcn.ECf), Integer.valueOf(paramAnonymouscs.dck.dcn.ECg), Integer.valueOf(paramAnonymouscs.dck.dcn.ECh), Integer.valueOf(paramAnonymouscs.dck.dcn.ECi), Integer.valueOf(paramAnonymouscs.dck.dcn.ECj), Integer.valueOf(paramAnonymouscs.dck.dcn.ECk) });
              }
              AppMethodBeat.o(35212);
              return;
            }
          }
          
          private void h(HashSet<Long> paramAnonymousHashSet)
          {
            AppMethodBeat.i(35215);
            if (paramAnonymousHashSet.isEmpty()) {
              new com.tencent.mm.sdk.platformtools.ao(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(35210);
                  k.6.this.fmW();
                  AppMethodBeat.o(35210);
                }
              });
            }
            AppMethodBeat.o(35215);
          }
          
          private static String hP(List<bo> paramAnonymousList)
          {
            AppMethodBeat.i(35213);
            StringBuffer localStringBuffer = new StringBuffer();
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext()) {
              localStringBuffer.append(((bo)paramAnonymousList.next()).field_msgId);
            }
            paramAnonymousList = localStringBuffer.toString();
            AppMethodBeat.o(35213);
            return paramAnonymousList;
          }
          
          private static void hQ(List<bo> paramAnonymousList)
          {
            AppMethodBeat.i(35217);
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              bo localbo = (bo)paramAnonymousList.next();
              com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.HJl, a.d.HJq, localbo, 0);
            }
            AppMethodBeat.o(35217);
          }
          
          public final void fmW()
          {
            AppMethodBeat.i(35216);
            k.a(k.this, "");
            final List localList = k.c(k.this);
            if (com.tencent.mm.ui.chatting.j.hK(localList))
            {
              com.tencent.mm.ui.base.h.a(k.this.cLy.HZF.getContext(), k.this.cLy.HZF.getContext().getString(2131758900), "", k.this.cLy.HZF.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35216);
              return;
            }
            final cs localcs = new cs();
            ac.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { k.e(k.this).field_username });
            Object localObject1;
            Object localObject2;
            Object localObject3;
            if ((localList != null) && (localList.size() == 1))
            {
              localObject1 = (bo)localList.get(0);
              if ((localObject1 != null) && ((((bo)localObject1).cKN()) || (((bo)localObject1).eZj())))
              {
                localObject2 = y.xJ(((dy)localObject1).field_msgSvrId);
                localObject3 = y.ayq().F((String)localObject2, true);
                ((y.b)localObject3).l("prePublishId", "msg_" + ((dy)localObject1).field_msgSvrId);
                boolean bool = ((com.tencent.mm.ui.chatting.c.b.d)k.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo();
                ((y.b)localObject3).l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a((bo)localObject1, k.d(k.this), bool));
                ((y.b)localObject3).l("preChatName", k.e(k.this).field_username);
                ((y.b)localObject3).l("preMsgIndex", Integer.valueOf(0));
                ((y.b)localObject3).l("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (y.b)localObject3, (bo)localObject1);
                localcs.dck.sessionId = ((String)localObject2);
              }
            }
            if (com.tencent.mm.pluginsdk.model.i.a(k.this.cLy.HZF.getContext(), localcs, k.e(k.this).field_username, localList, true))
            {
              localObject1 = localList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (bo)((Iterator)localObject1).next();
                if (((bo)localObject2).cKN()) {
                  com.tencent.mm.modelstat.b.hUE.c((bo)localObject2, l.r((bo)localObject2));
                } else {
                  com.tencent.mm.modelstat.b.hUE.P((bo)localObject2);
                }
              }
              c(localcs);
              hQ(k.c(k.this));
              AppMethodBeat.o(35216);
              return;
            }
            if (k.c(k.this).size() > 1)
            {
              localObject3 = k.this.cLy.HZF.getContext();
              if (localcs.dck.dcp >= 0)
              {
                localObject1 = k.this.cLy.HZF.getContext().getString(2131758899);
                if (localcs.dck.dcp < 0) {
                  break label642;
                }
              }
              label642:
              for (localObject2 = k.this.cLy.HZF.getContext().getString(2131757560);; localObject2 = k.this.cLy.HZF.getContext().getString(2131761941))
              {
                com.tencent.mm.ui.base.h.d((Context)localObject3, (String)localObject1, "", (String)localObject2, k.this.cLy.HZF.getContext().getString(2131757558), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(35211);
                    paramAnonymous2DialogInterface = localList.iterator();
                    while (paramAnonymous2DialogInterface.hasNext())
                    {
                      bo localbo = (bo)paramAnonymous2DialogInterface.next();
                      if ((!localbo.fbD()) && (!localbo.fbC()))
                      {
                        if ((localcs.dck.type == 14) && (localcs.dck.dcm.nxC.size() == 0))
                        {
                          k.this.fmS();
                          AppMethodBeat.o(35211);
                          return;
                        }
                        k.6.a(k.6.this, localcs);
                        k.6.hR(k.c(k.this));
                        AppMethodBeat.o(35211);
                        return;
                      }
                    }
                    AppMethodBeat.o(35211);
                  }
                }, null);
                AppMethodBeat.o(35216);
                return;
                localObject1 = k.this.cLy.HZF.getContext().getString(2131758898);
                break;
              }
            }
            com.tencent.mm.ui.base.h.l(k.this.cLy.HZF.getContext(), localcs.dck.dcp, 0);
            AppMethodBeat.o(35216);
          }
          
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35214);
            Object localObject1 = k.c(k.this);
            paramAnonymousView = new HashSet();
            Object localObject2 = hP((List)localObject1);
            if (((String)localObject2).equals(k.g(k.this)))
            {
              com.tencent.mm.ui.base.t.makeText(k.this.cLy.HZF.getContext(), k.this.cLy.HZF.getContext().getString(2131758828), 0).show();
              AppMethodBeat.o(35214);
              return;
            }
            k.a(k.this, (String)localObject2);
            localObject1 = ((List)localObject1).iterator();
            label814:
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (bo)((Iterator)localObject1).next();
              Object localObject3;
              Object localObject4;
              com.tencent.mm.i.g localg;
              if (((bo)localObject2).cKN())
              {
                localObject3 = k.b.vA(((dy)localObject2).field_content);
                if ((localObject3 != null) && (((k.b)localObject3).type == 6) && (!bs.isNullOrNil(((k.b)localObject3).hhL)))
                {
                  localObject4 = com.tencent.mm.pluginsdk.model.app.m.c((bo)localObject2, ((k.b)localObject3).cZa);
                  if ((localObject4 != null) && ((!com.tencent.mm.vfs.i.eA(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath)) || (com.tencent.mm.vfs.i.aSp(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen)))
                  {
                    ac.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[] { Long.valueOf(((dy)localObject2).field_msgId) });
                    paramAnonymousView.add(Long.valueOf(((dy)localObject2).field_msgId));
                    localg = new com.tencent.mm.i.g();
                    localg.frb = new g.a()
                    {
                      public final int a(String paramAnonymous2String, int paramAnonymous2Int, com.tencent.mm.i.c paramAnonymous2c, com.tencent.mm.i.d paramAnonymous2d, boolean paramAnonymous2Boolean)
                      {
                        AppMethodBeat.i(35209);
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2c != null))
                        {
                          this.HMI.field_offset = paramAnonymous2c.field_finishedLength;
                          ap.bEO().a(this.HMI, new String[0]);
                        }
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2d != null) && (paramAnonymous2d.field_retCode == 0))
                        {
                          ac.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[] { Long.valueOf(this.hmq.field_msgId) });
                          this.HMI.field_status = 199L;
                          this.HMI.field_offset = this.HMI.field_totalLen;
                          ap.bEO().a(this.HMI, new String[0]);
                          this.hmq.setStatus(3);
                          az.ayM();
                          com.tencent.mm.model.c.awD().a(this.hmq.field_msgId, this.hmq);
                          paramAnonymousView.remove(Long.valueOf(this.hmq.field_msgId));
                          k.6.a(k.6.this, paramAnonymousView);
                        }
                        long l;
                        if ((paramAnonymous2Int != 0) || ((paramAnonymous2d != null) && (paramAnonymous2d.field_retCode != 0)))
                        {
                          l = this.hmq.field_msgId;
                          if (paramAnonymous2d != null) {
                            break label283;
                          }
                        }
                        label283:
                        for (int i = 0;; i = paramAnonymous2d.field_retCode)
                        {
                          ac.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymous2Int), Integer.valueOf(i) });
                          paramAnonymousView.remove(Long.valueOf(this.hmq.field_msgId));
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
                    localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", bs.eWj(), ((dy)localObject2).field_talker, ((dy)localObject2).field_msgId);
                    localg.field_aesKey = ((k.b)localObject3).fQi;
                    localg.field_fileType = 19;
                    localg.field_authKey = ((k.b)localObject3).hhR;
                    localg.fre = ((k.b)localObject3).hhL;
                    if ((localObject4 == null) || (bs.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath))) {
                      break label712;
                    }
                    localg.field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath;
                    label378:
                    if (!com.tencent.mm.an.f.aDD().b(localg, -1))
                    {
                      ac.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                      paramAnonymousView.remove(Long.valueOf(((dy)localObject2).field_msgId));
                    }
                  }
                }
              }
              int i;
              if (((bo)localObject2).eZm())
              {
                localObject3 = com.tencent.mm.av.o.aFx().qf(((dy)localObject2).field_msgSvrId);
                if (((dy)localObject2).field_isSend != 1) {
                  break label745;
                }
                if (!((com.tencent.mm.av.e)localObject3).aFa()) {
                  break label740;
                }
                i = 1;
                label451:
                if ((((com.tencent.mm.av.e)localObject3).offset < ((com.tencent.mm.av.e)localObject3).hux) || (((com.tencent.mm.av.e)localObject3).hux == 0))
                {
                  ac.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(((dy)localObject2).field_msgId) });
                  paramAnonymousView.add(Long.valueOf(((dy)localObject2).field_msgId));
                  if (!com.tencent.mm.av.o.aFy().a(((com.tencent.mm.av.e)localObject3).dcd, ((dy)localObject2).field_msgId, i, localObject2, 2131231564, new d.a()
                  {
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(35208);
                      ac.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.hmq.field_msgId) });
                      paramAnonymousView.remove(Long.valueOf(this.hmq.field_msgId));
                      k.6.a(k.6.this, paramAnonymousView);
                      AppMethodBeat.o(35208);
                    }
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, com.tencent.mm.ak.n paramAnonymous2n) {}
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
                    {
                      AppMethodBeat.i(35207);
                      if ((paramAnonymous2Int3 == 0) && (paramAnonymous2Int4 == 0)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        ac.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.hmq.field_msgId), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
                        paramAnonymousView.remove(Long.valueOf(this.hmq.field_msgId));
                        k.6.a(k.6.this, paramAnonymousView);
                        AppMethodBeat.o(35207);
                        return;
                      }
                    }
                  })) {
                    paramAnonymousView.remove(Long.valueOf(((dy)localObject2).field_msgId));
                  }
                }
              }
              if ((((bo)localObject2).crt()) || (((bo)localObject2).crv()))
              {
                localObject3 = com.tencent.mm.modelvideo.u.Ej(((dy)localObject2).field_imgPath);
                if ((localObject3 != null) && (((com.tencent.mm.modelvideo.s)localObject3).status != 199))
                {
                  paramAnonymousView.add(Long.valueOf(((dy)localObject2).field_msgId));
                  localObject4 = new t.a()
                  {
                    public final void a(t.a.a paramAnonymous2a)
                    {
                      AppMethodBeat.i(35206);
                      if (this.hmq.field_imgPath.equals(paramAnonymous2a.fileName))
                      {
                        com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Ej(paramAnonymous2a.fileName);
                        if ((locals == null) || (!locals.aJN())) {
                          break label114;
                        }
                        ac.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.hmq.field_msgId), paramAnonymous2a.fileName });
                      }
                      for (;;)
                      {
                        com.tencent.mm.modelvideo.o.aJy().a(this);
                        paramAnonymousView.remove(Long.valueOf(this.hmq.field_msgId));
                        k.6.a(k.6.this, paramAnonymousView);
                        AppMethodBeat.o(35206);
                        return;
                        label114:
                        ac.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.hmq.field_msgId), paramAnonymous2a.fileName });
                      }
                    }
                  };
                  com.tencent.mm.modelvideo.o.aJy().a((t.a)localObject4, Looper.getMainLooper());
                  ac.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(((dy)localObject2).field_msgId), ((dy)localObject2).field_imgPath });
                  if (((com.tencent.mm.modelvideo.s)localObject3).aJM()) {
                    ac.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                  }
                  for (i = com.tencent.mm.modelvideo.u.Eq(((dy)localObject2).field_imgPath);; i = com.tencent.mm.modelvideo.u.Ee(((dy)localObject2).field_imgPath))
                  {
                    if (i == 0) {
                      break label814;
                    }
                    paramAnonymousView.remove(Long.valueOf(((dy)localObject2).field_msgId));
                    break;
                    label712:
                    az.ayM();
                    localg.field_fullpath = com.tencent.mm.pluginsdk.model.app.m.aj(com.tencent.mm.model.c.awT(), ((k.b)localObject3).title, ((k.b)localObject3).hhG);
                    break label378;
                    label740:
                    i = 0;
                    break label451;
                    label745:
                    if (!((com.tencent.mm.av.e)localObject3).aFa())
                    {
                      i = 0;
                      break label451;
                    }
                    localObject4 = com.tencent.mm.av.f.a((com.tencent.mm.av.e)localObject3);
                    if (!com.tencent.mm.vfs.i.eA(com.tencent.mm.av.o.aFx().p(((com.tencent.mm.av.e)localObject4).hGM, "", "")))
                    {
                      i = 0;
                      break label451;
                    }
                    i = 1;
                    break label451;
                    ac.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                  }
                }
              }
            }
            h(paramAnonymousView);
            AppMethodBeat.o(35214);
          }
        });
        this.xEv = AnimationUtils.loadAnimation(this.cLy.HZF.getContext(), 2130772108);
        ((com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).g(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35195);
            com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)k.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
            if (locali.Bd(((Long)paramAnonymousView.getTag()).longValue()))
            {
              int i = locali.dsn();
              ((ae)k.this.cLy.bf(ae.class)).fof();
              k.a(k.this).ftR();
              k.b(k.this).setVisibility(0);
              k.b(k.this).aaH(i);
            }
            AppMethodBeat.o(35195);
          }
        });
        break;
        this.fzp = new r((byte)0);
      }
    }
  }
  
  public final void bB(bo parambo)
  {
    AppMethodBeat.i(35226);
    if (parambo == null)
    {
      ac.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
      AppMethodBeat.o(35226);
      return;
    }
    com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
    if (locali.Bd(parambo.field_msgId))
    {
      int i = locali.dsn();
      this.HTl.aaH(i);
      this.HTl.setVisibility(0);
      this.fzp.ftR();
    }
    AppMethodBeat.o(35226);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35231);
    fmS();
    AppMethodBeat.o(35231);
  }
  
  public final void fmS()
  {
    AppMethodBeat.i(35227);
    this.cLy.HZF.getController().addSearchMenu(false, this.fzp);
    if (this.HTl != null) {
      this.HTl.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).cqC();
    ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmC();
    ((ae)this.cLy.bf(ae.class)).fof();
    this.HRH = false;
    fmT();
    ((com.tencent.mm.ui.chatting.c.b.m)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.m.class)).dRj();
    ((q)this.cLy.bf(q.class)).fnn();
    this.cLy.hideVKB();
    com.tencent.mm.ui.chatting.k.fkY();
    AppMethodBeat.o(35227);
  }
  
  public final boolean fmU()
  {
    return this.HRH;
  }
  
  public final void fmV()
  {
    AppMethodBeat.i(35229);
    if (this.fzp != null)
    {
      this.fzp.ftR();
      this.fzp.ITM = null;
    }
    AppMethodBeat.o(35229);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(169865);
    super.fmj();
    if (this.HRH) {
      fmS();
    }
    AppMethodBeat.o(169865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.k
 * JD-Core Version:    0.7.0.1
 */