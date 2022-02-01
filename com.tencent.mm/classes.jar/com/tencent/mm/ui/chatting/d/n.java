package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.z;
import com.tencent.mm.aj.z.a;
import com.tencent.mm.aq.f;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.b.a.ia;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.t.b;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.wework.api.IWWAPI.WWAppType;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.l.class)
public class n
  extends a
  implements z, com.tencent.mm.ui.chatting.d.b.l
{
  public static QueueWorkerThread WIm;
  private Animation JtL;
  private String WDm = "";
  private boolean WFx = false;
  private ChattingFooterMoreBtnBar WIn;
  private boolean WIo = true;
  private boolean Wwx;
  private as fLE;
  private boolean hasInit = false;
  private t jjS;
  
  static
  {
    AppMethodBeat.i(35233);
    WIm = new QueueWorkerThread(5, "MicroMsg.ChattingMoreBtnBarHelper");
    AppMethodBeat.o(35233);
  }
  
  private void hOS()
  {
    AppMethodBeat.i(35228);
    if (this.WFx) {
      this.fgR.showOptionMenu(false);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.chatting.d.b.ax)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ax.class)).hQV();
      AppMethodBeat.o(35228);
      return;
      ((aa)this.fgR.bC(aa.class)).hPL();
    }
  }
  
  public final void H(Bundle paramBundle) {}
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(35230);
    hOR();
    AppMethodBeat.o(35230);
  }
  
  public final void b(z.a parama) {}
  
  public final boolean bbA()
  {
    return this.WIo;
  }
  
  public final boolean bbB()
  {
    return false;
  }
  
  public final boolean bbC()
  {
    return true;
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35231);
    hOR();
    AppMethodBeat.o(35231);
  }
  
  public final void cp(ca paramca)
  {
    AppMethodBeat.i(35225);
    if (this.hasInit)
    {
      Log.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
      this.fLE = this.fgR.NKq;
      if ((!this.fgR.hRh()) && (!((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf())) {
        break label584;
      }
    }
    label584:
    for (boolean bool = true;; bool = false)
    {
      this.Wwx = bool;
      this.WIn.eNL();
      this.fgR.WQv.getController().addSearchMenu(true, this.jjS);
      if (this.WIn != null)
      {
        this.WIn.startAnimation(this.JtL);
        this.WIn.setVisibility(0);
      }
      this.WFx = true;
      ((an)this.fgR.bC(an.class)).hQt();
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
      localk.hNF();
      localk.hNE();
      localk.VC(paramca.field_msgId);
      int i = localk.fsW();
      this.WIn.avk(i);
      ((p)this.fgR.bC(p.class)).hPg();
      this.fgR.hideVKB();
      hOS();
      ((com.tencent.mm.ui.chatting.d.b.u)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.u.class)).hPs();
      com.tencent.mm.plugin.report.service.h.IzE.a(10811, new Object[] { Integer.valueOf(1) });
      if (this.fLE.hxX())
      {
        paramca = this.fgR;
        i = R.h.menu_search;
        Log.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[] { Integer.valueOf(i) });
        paramca.WQw.removeOptionMenu(i);
      }
      ((com.tencent.mm.ui.chatting.d.b.ab)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ab.class)).hPY();
      AppMethodBeat.o(35225);
      return;
      this.hasInit = true;
      if (this.WIn == null)
      {
        ((ViewStub)this.fgR.findViewById(R.h.dZk)).inflate();
        this.WIn = ((ChattingFooterMoreBtnBar)this.fgR.findViewById(R.h.dxA));
      }
      if (((an)this.fgR.bC(an.class)).hQA())
      {
        Log.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        if (this.jjS == null) {}
      }
      for (this.jjS.XUl = null;; this.jjS.XUl = new t.b()
          {
            String jQq = null;
            
            public final boolean aat(String paramAnonymousString)
            {
              return false;
            }
            
            public final void aau(String paramAnonymousString)
            {
              AppMethodBeat.i(35222);
              Log.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
              Object localObject = (an)n.this.fgR.bC(an.class);
              if (Util.isNullOrNil(paramAnonymousString)) {
                if (((an)localObject).hQA())
                {
                  if (((an)localObject).hQv() != null) {
                    ((an)localObject).hQv().aas("");
                  }
                  ((an)localObject).avF(-1);
                }
              }
              for (;;)
              {
                this.jQq = paramAnonymousString;
                AppMethodBeat.o(35222);
                return;
                if (n.f(n.this))
                {
                  if (this.jQq != null)
                  {
                    ((an)localObject).hQt();
                    n.b(n.this).setVisibility(0);
                    localObject = (com.tencent.mm.ui.chatting.d.b.k)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
                    n.b(n.this).avk(((com.tencent.mm.ui.chatting.d.b.k)localObject).fsW());
                  }
                }
                else
                {
                  ((an)localObject).hQt();
                  n.b(n.this).setVisibility(8);
                  continue;
                  Log.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                  n.b(n.this).setVisibility(8);
                  ((an)localObject).hQs();
                  if (((an)localObject).hQv() != null) {
                    ((an)localObject).hQv().aas(paramAnonymousString);
                  }
                }
              }
            }
            
            public final void bxH()
            {
              AppMethodBeat.i(35223);
              Log.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
              com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
              if (localk.hNH())
              {
                ((an)n.this.fgR.bC(an.class)).hQt();
                n.b(n.this).setVisibility(0);
                n.b(n.this).avk(localk.fsW());
              }
              n.this.fgR.WQv.getController().supportInvalidateOptionsMenu();
              AppMethodBeat.o(35223);
            }
            
            public final void bxI()
            {
              AppMethodBeat.i(35224);
              Log.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 21L, 1L, true);
              if (((com.tencent.mm.ui.chatting.d.b.k)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNH())
              {
                ((an)n.this.fgR.bC(an.class)).hQs();
                n.b(n.this).setVisibility(8);
              }
              AppMethodBeat.o(35224);
            }
            
            public final void bxJ() {}
            
            public final void bxK() {}
          })
      {
        this.WIn.b(3, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35197);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.k)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
            if (paramAnonymousView.fsW() == 0)
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35197);
              return;
            }
            localObject = n.this.fgR.WQv.getContext();
            com.tencent.mm.ui.base.h.a((Context)localObject, ((Context)localObject).getString(R.l.exL), "", ((Context)localObject).getString(R.l.eBd), ((Context)localObject).getString(R.l.app_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(35196);
                Log.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                paramAnonymous2DialogInterface = (Long[])paramAnonymousView.hND().toArray(new Long[0]);
                Arrays.sort(paramAnonymous2DialogInterface, new Comparator() {});
                ArrayList localArrayList = new ArrayList();
                SparseArray localSparseArray = paramAnonymousView.hNB();
                int i = localSparseArray.size();
                int n = paramAnonymous2DialogInterface.length;
                int j = 0;
                int k = i;
                if (j < n)
                {
                  Object localObject = paramAnonymous2DialogInterface[j];
                  ca localca;
                  do
                  {
                    paramAnonymous2Int = i - 1;
                    i = paramAnonymous2Int;
                    m = k;
                    if (paramAnonymous2Int < 0) {
                      break label217;
                    }
                    localca = (ca)localSparseArray.get(paramAnonymous2Int);
                    if (localca.field_msgId <= localObject.longValue()) {
                      break;
                    }
                    i = paramAnonymous2Int;
                  } while (localca.hzA());
                  if (localca.field_msgId == localObject.longValue()) {}
                  for (int m = 1;; m = 0)
                  {
                    i = paramAnonymous2Int;
                    if (m == 0) {
                      break label230;
                    }
                    i = k - 1;
                    while (i > paramAnonymous2Int)
                    {
                      localArrayList.add(Long.valueOf(((ca)localSparseArray.get(i)).field_msgId));
                      i -= 1;
                    }
                  }
                  for (;;)
                  {
                    m = paramAnonymous2Int;
                    i = paramAnonymous2Int;
                    label217:
                    j += 1;
                    k = m;
                    break;
                    label230:
                    do
                    {
                      paramAnonymous2Int = i - 1;
                      if (paramAnonymous2Int < 0) {
                        break;
                      }
                      i = paramAnonymous2Int;
                    } while (((ca)localSparseArray.get(paramAnonymous2Int)).field_msgId != localObject.longValue());
                  }
                }
                j.a(this.val$context, paramAnonymousView.hND(), n.this);
                if (localArrayList.size() > 0) {
                  j.a(this.val$context, new CopyOnWriteArraySet(localArrayList), n.this);
                }
                n.this.hOR();
                AppMethodBeat.o(35196);
              }
            }, null, R.e.alert_btn_color_warn);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35197);
          }
        });
        this.WIn.b(2, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35198);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (((com.tencent.mm.ui.chatting.d.b.k)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).fsW() == 0)
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35198);
              return;
            }
            com.tencent.mm.ui.chatting.n.a(n.this.fgR, n.this.hOQ(), n.c(n.this), n.this, n.d(n.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35198);
          }
        });
        this.WIn.b(1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35199);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.k)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
            if ((paramAnonymousView == null) || (paramAnonymousView.fsW() == 0))
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            paramAnonymousView = n.this.hOQ();
            if (com.tencent.mm.ui.chatting.k.kb(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.eAr), "", n.this.fgR.WQv.getContext().getString(R.l.emp), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.k.kc(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.eAs), "", n.this.fgR.WQv.getContext().getString(R.l.emp), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.k.ka(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.eAt), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.o.a(n.this.fgR, paramAnonymousView, n.d(n.this))) {
              n.this.hOR();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35199);
          }
        });
        this.WIn.b(0, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35202);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            if (((com.tencent.mm.ui.chatting.d.b.k)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).fsW() == 0)
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
            }
            if (((com.tencent.mm.model.ab.Qm(n.d(n.this).field_username)) && (!com.tencent.mm.ao.g.KI(n.d(n.this).field_username))) || (com.tencent.mm.model.ab.QY(n.d(n.this).field_username)))
            {
              n.a(n.this, true);
              com.tencent.mm.ui.chatting.l.a(n.this.fgR.WQv.getContext(), n.this.hOQ(), n.c(n.this), n.d(n.this).field_username, n.this);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
              com.tencent.mm.plugin.selectrecord.b.b.fFD();
              localObject = new com.tencent.mm.ui.widget.a.e(n.this.fgR.WQv.getContext(), 1, false);
              ((com.tencent.mm.ui.widget.a.e)localObject).ODT = new q.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
                {
                  AppMethodBeat.i(35200);
                  paramAnonymous2o.mn(0, R.l.eMh);
                  paramAnonymous2o.mn(1, R.l.eMi);
                  if (com.tencent.mm.ui.chatting.ao.a(n.this.fgR.WQv.getContext(), IWWAPI.WWAppType.ZYc)) {
                    paramAnonymous2o.d(2, n.this.fgR.WQv.getContext().getString(R.l.eMj, new Object[] { com.tencent.mm.ui.chatting.ao.b(n.this.fgR.WQv.getContext(), IWWAPI.WWAppType.ZYc) }));
                  }
                  if (com.tencent.mm.ui.chatting.ao.a(n.this.fgR.WQv.getContext(), IWWAPI.WWAppType.ZYd)) {
                    paramAnonymous2o.d(3, n.this.fgR.WQv.getContext().getString(R.l.eMj, new Object[] { com.tencent.mm.ui.chatting.ao.b(n.this.fgR.WQv.getContext(), IWWAPI.WWAppType.ZYd) }));
                  }
                  AppMethodBeat.o(35200);
                }
              };
              ((com.tencent.mm.ui.widget.a.e)localObject).ODU = new q.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(35201);
                  final List localList = n.this.hOQ();
                  Object localObject1 = com.tencent.mm.plugin.selectrecord.b.b.fFC();
                  long l = localList.size();
                  ((com.tencent.mm.plugin.selectrecord.b.b)localObject1).JcL.gHM = l;
                  paramAnonymous2Int = 0;
                  int i = 0;
                  int m = 0;
                  int n = 0;
                  int j = 0;
                  int i1 = 0;
                  int k = 0;
                  int i2 = 0;
                  int i3 = 0;
                  Object localObject2 = localList.iterator();
                  int i4 = 0;
                  while (((Iterator)localObject2).hasNext())
                  {
                    Object localObject3 = (ca)((Iterator)localObject2).next();
                    switch (((ca)localObject3).getType())
                    {
                    default: 
                      paramAnonymous2Int += 1;
                      break;
                    case 1: 
                    case 11: 
                    case 21: 
                    case 31: 
                    case 36: 
                    case 301989937: 
                      i += 1;
                      break;
                    case 3: 
                    case 13: 
                    case 23: 
                    case 33: 
                    case 39: 
                    case 268435505: 
                      m += 1;
                      break;
                    case 34: 
                      n += 1;
                      break;
                    case 43: 
                    case 44: 
                    case 62: 
                      j += 1;
                      break;
                    case 42: 
                    case 66: 
                      i1 += 1;
                      break;
                    case 47: 
                      k += 1;
                      break;
                    case 49: 
                      localObject3 = k.b.OQ(((et)localObject3).field_content);
                      if (localObject3 != null) {
                        switch (((k.b)localObject3).type)
                        {
                        default: 
                          paramAnonymous2Int += 1;
                          break;
                        case 1: 
                        case 53: 
                        case 57: 
                          i += 1;
                          break;
                        case 6: 
                          i2 += 1;
                          break;
                        case 33: 
                        case 36: 
                        case 44: 
                        case 48: 
                          i4 += 1;
                          break;
                        case 4: 
                          j += 1;
                          break;
                        case 19: 
                          i3 += 1;
                          break;
                        case 1048625: 
                          k += 1;
                        }
                      }
                      break;
                    }
                  }
                  localObject2 = paramAnonymous2Int + ";" + i + ";" + m + ";" + n + ";" + j + ";" + i1 + ";" + k + ";" + i2 + ";" + i3 + ";" + i4 + ";";
                  localObject1 = ((com.tencent.mm.plugin.selectrecord.b.b)localObject1).JcL;
                  ((ia)localObject1).gHN = ((ia)localObject1).z("FinalShareCountByType", (String)localObject2, true);
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(35201);
                    return;
                    com.tencent.mm.plugin.selectrecord.b.b.fFC().Qb(2L);
                    if (localList.size() > 31)
                    {
                      com.tencent.mm.ui.base.h.c(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.eUv), "", n.this.fgR.WQv.getContext().getString(R.l.eMi), n.this.fgR.WQv.getContext().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(220970);
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL to MENU_ID_SEND_RECORD");
                          n.5.a(n.5.this, localList);
                          AppMethodBeat.o(220970);
                        }
                      }, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(290737);
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL onCancel");
                          AppMethodBeat.o(290737);
                        }
                      });
                      AppMethodBeat.o(35201);
                      return;
                    }
                    n.a(n.this, true);
                    if (!com.tencent.mm.ui.chatting.l.a(n.this.fgR.WQv.getContext(), localList, n.c(n.this), n.d(n.this).field_username, n.this))
                    {
                      com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
                      AppMethodBeat.o(35201);
                      return;
                      n.5.a(n.5.this, localList);
                      AppMethodBeat.o(35201);
                      return;
                      if (WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramAnonymousView.getContext()))
                      {
                        com.tencent.mm.plugin.selectrecord.b.b.fFC().Qb(3L);
                        if (!com.tencent.mm.ui.chatting.ao.a(n.this.fgR.WQv.getContext(), n.d(n.this), localList, n.c(n.this), IWWAPI.WWAppType.ZYc)) {
                          com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
                        }
                        n.this.hOR();
                        AppMethodBeat.o(35201);
                        return;
                        if (WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramAnonymousView.getContext()))
                        {
                          com.tencent.mm.plugin.selectrecord.b.b.fFC().Qb(3L);
                          if (!com.tencent.mm.ui.chatting.ao.a(n.this.fgR.WQv.getContext(), n.d(n.this), localList, n.c(n.this), IWWAPI.WWAppType.ZYd)) {
                            com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
                          }
                          n.this.hOR();
                        }
                      }
                    }
                  }
                }
              };
              ((com.tencent.mm.ui.widget.a.e)localObject).XbB = new e.b()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(271947);
                  com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
                  AppMethodBeat.o(271947);
                }
              };
              ((com.tencent.mm.ui.widget.a.e)localObject).eik();
            }
          }
        });
        this.WIn.b(4, new View.OnClickListener()
        {
          private void c(dd paramAnonymousdd)
          {
            AppMethodBeat.i(35212);
            Object localObject1 = n.this.hOQ();
            Object localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (!ac.bV((ca)((Iterator)localObject2).next()))
              {
                com.tencent.mm.ui.base.h.a(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.eEx), "", n.this.fgR.WQv.getContext().getString(R.l.welcome_i_know), null);
                AppMethodBeat.o(35212);
                return;
              }
            }
            long l = com.tencent.mm.n.c.awL();
            localObject2 = com.tencent.mm.ui.chatting.h.Wzz;
            if (com.tencent.mm.ui.chatting.h.h((List)localObject1, l))
            {
              com.tencent.mm.ui.base.h.a(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.eEO, new Object[] { Util.getSizeKB(l) }), "", n.this.fgR.WQv.getContext().getString(R.l.welcome_i_know), null);
              AppMethodBeat.o(35212);
              return;
            }
            l = com.tencent.mm.n.c.awN();
            localObject2 = com.tencent.mm.ui.chatting.h.Wzz;
            if (com.tencent.mm.ui.chatting.h.g((List)localObject1, l))
            {
              com.tencent.mm.ui.base.h.a(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.eEP, new Object[] { Util.getSizeKB(l) }), "", n.this.fgR.WQv.getContext().getString(R.l.welcome_i_know), null);
              AppMethodBeat.o(35212);
              return;
            }
            paramAnonymousdd.fyI.fragment = n.this.fgR.WQv;
            paramAnonymousdd.fyI.fyP = 41;
            paramAnonymousdd.fyI.fyR = new com.tencent.mm.ui.widget.snackbar.a.c()
            {
              public final void bPL()
              {
                AppMethodBeat.i(35205);
                ((com.tencent.mm.ui.chatting.d.b.u)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.u.class)).hPr();
                AppMethodBeat.o(35205);
              }
              
              public final void onHide()
              {
                AppMethodBeat.i(35204);
                n.this.hOR();
                AppMethodBeat.o(35204);
              }
              
              public final void onShow()
              {
                AppMethodBeat.i(35203);
                n.this.hOR();
                n.b(n.this).setVisibility(4);
                AppMethodBeat.o(35203);
              }
            };
            EventCenter.instance.publish(paramAnonymousdd);
            int i;
            if (paramAnonymousdd.fyJ.ret == 0)
            {
              i = 1;
              l = Util.nowSecond();
              Iterator localIterator = ((List)localObject1).iterator();
              label380:
              while (localIterator.hasNext())
              {
                localObject1 = (ca)localIterator.next();
                if (((ca)localObject1).erk())
                {
                  localObject2 = k.b.OQ(Util.processXml(((et)localObject1).field_content));
                  if ((localObject2 != null) && (((k.b)localObject2).type == 5) && (!Util.isNullOrNil(((k.b)localObject2).url))) {
                    if (!((ca)localObject1).hwA()) {
                      break label939;
                    }
                  }
                }
              }
            }
            label939:
            for (int j = 1;; j = 2)
            {
              Log.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject2).url, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(1) });
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
                  Log.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", localUnsupportedEncodingException, "", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
              break label380;
              i = 2;
              break;
              if (paramAnonymousdd.fyJ.ret == 0)
              {
                if (14 != paramAnonymousdd.fyI.type)
                {
                  Log.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                  AppMethodBeat.o(35212);
                  return;
                }
                if (paramAnonymousdd.fyI.fyL == null)
                {
                  Log.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                  AppMethodBeat.o(35212);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(11142, new Object[] { Integer.valueOf(paramAnonymousdd.fyI.fyL.SAQ), Integer.valueOf(paramAnonymousdd.fyI.fyL.JCD), Integer.valueOf(paramAnonymousdd.fyI.fyL.SAR), Integer.valueOf(paramAnonymousdd.fyI.fyL.xzT), Integer.valueOf(paramAnonymousdd.fyI.fyL.SAS), Integer.valueOf(paramAnonymousdd.fyI.fyL.SAT), Integer.valueOf(paramAnonymousdd.fyI.fyL.SAU), Integer.valueOf(paramAnonymousdd.fyI.fyL.fileCount), Integer.valueOf(paramAnonymousdd.fyI.fyL.SAV), Integer.valueOf(paramAnonymousdd.fyI.fyL.SAW), Integer.valueOf(paramAnonymousdd.fyI.fyL.SAX), Integer.valueOf(paramAnonymousdd.fyI.fyL.SAY), Integer.valueOf(paramAnonymousdd.fyI.fyL.SAZ), Integer.valueOf(paramAnonymousdd.fyI.fyL.SBa), Integer.valueOf(paramAnonymousdd.fyI.fyL.SBb) });
              }
              AppMethodBeat.o(35212);
              return;
            }
          }
          
          private void g(HashSet<Long> paramAnonymousHashSet)
          {
            AppMethodBeat.i(35215);
            if (paramAnonymousHashSet.isEmpty()) {
              new MMHandler(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(35210);
                  n.6.this.hOV();
                  AppMethodBeat.o(35210);
                }
              });
            }
            AppMethodBeat.o(35215);
          }
          
          private static String kf(List<ca> paramAnonymousList)
          {
            AppMethodBeat.i(35213);
            StringBuffer localStringBuffer = new StringBuffer();
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext()) {
              localStringBuffer.append(((ca)paramAnonymousList.next()).field_msgId);
            }
            paramAnonymousList = localStringBuffer.toString();
            AppMethodBeat.o(35213);
            return paramAnonymousList;
          }
          
          private static void kg(List<ca> paramAnonymousList)
          {
            AppMethodBeat.i(35217);
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              ca localca = (ca)paramAnonymousList.next();
              com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Wwh, a.d.Wwm, localca, 0);
            }
            AppMethodBeat.o(35217);
          }
          
          public final void hOV()
          {
            AppMethodBeat.i(35216);
            n.a(n.this, "");
            final List localList = n.this.hOQ();
            if (com.tencent.mm.ui.chatting.k.kb(localList))
            {
              com.tencent.mm.ui.base.h.a(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.favorite_fail_remuxing_error), "", n.this.fgR.WQv.getContext().getString(R.l.emp), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35216);
              return;
            }
            final dd localdd = new dd();
            Log.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { n.d(n.this).field_username });
            Object localObject1;
            Object localObject2;
            Object localObject3;
            if (localList.size() == 1)
            {
              localObject1 = (ca)localList.get(0);
              if ((localObject1 != null) && ((((ca)localObject1).erk()) || (((ca)localObject1).hwA())))
              {
                if (((ca)localObject1).hzJ())
                {
                  localObject2 = k.b.OQ(((et)localObject1).field_content);
                  if ((localObject2 != null) && (((k.b)localObject2).type == 74))
                  {
                    com.tencent.mm.ui.base.h.a(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.eEM), "", n.this.fgR.WQv.getContext().getString(R.l.emp), new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(35211);
                        AppMethodBeat.o(35211);
                      }
                    });
                    AppMethodBeat.o(35216);
                    return;
                  }
                }
                localObject2 = ad.Rp(((et)localObject1).field_msgSvrId);
                localObject3 = ad.beh().I((String)localObject2, true);
                ((ad.b)localObject3).k("prePublishId", "msg_" + ((et)localObject1).field_msgSvrId);
                boolean bool = ((com.tencent.mm.ui.chatting.d.b.d)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe();
                ((ad.b)localObject3).k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.b((ca)localObject1, n.c(n.this), bool));
                ((ad.b)localObject3).k("preChatName", n.d(n.this).field_username);
                ((ad.b)localObject3).k("preMsgIndex", Integer.valueOf(0));
                ((ad.b)localObject3).k("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.b.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.sns.b.k.class)).a("adExtStr", (ad.b)localObject3, (ca)localObject1);
                localdd.fyI.sessionId = ((String)localObject2);
              }
            }
            if (com.tencent.mm.pluginsdk.model.l.a(n.this.fgR.WQv.getContext(), localdd, n.d(n.this).field_username, localList, true))
            {
              localObject1 = localList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ca)((Iterator)localObject1).next();
                if (((ca)localObject2).erk()) {
                  com.tencent.mm.modelstat.b.mcf.e((ca)localObject2, com.tencent.mm.aj.l.v((ca)localObject2));
                } else {
                  com.tencent.mm.modelstat.b.mcf.aj((ca)localObject2);
                }
              }
              c(localdd);
              kg(n.this.hOQ());
              AppMethodBeat.o(35216);
              return;
            }
            if (n.this.hOQ().size() > 1)
            {
              localObject3 = n.this.fgR.WQv.getContext();
              if (localdd.fyI.fyO >= 0)
              {
                localObject1 = n.this.fgR.WQv.getContext().getString(R.l.favorite_fail_recordtype_error);
                if (localdd.fyI.fyO < 0) {
                  break label737;
                }
              }
              label737:
              for (localObject2 = n.this.fgR.WQv.getContext().getString(R.l.confirm_dialog_ok);; localObject2 = n.this.fgR.WQv.getContext().getString(R.l.plugin_favorite_opt))
              {
                com.tencent.mm.ui.base.h.c((Context)localObject3, (String)localObject1, "", (String)localObject2, n.this.fgR.WQv.getContext().getString(R.l.confirm_dialog_cancel), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(269751);
                    paramAnonymous2DialogInterface = localList.iterator();
                    while (paramAnonymous2DialogInterface.hasNext())
                    {
                      ca localca = (ca)paramAnonymous2DialogInterface.next();
                      if ((!localca.hzC()) && (!localca.hzB()))
                      {
                        if ((localdd.fyI.type == 14) && (localdd.fyI.fyK.syG.size() == 0))
                        {
                          n.this.hOR();
                          AppMethodBeat.o(269751);
                          return;
                        }
                        n.6.a(n.6.this, localdd);
                        n.6.kh(n.this.hOQ());
                        AppMethodBeat.o(269751);
                        return;
                      }
                    }
                    AppMethodBeat.o(269751);
                  }
                }, null);
                AppMethodBeat.o(35216);
                return;
                localObject1 = n.this.fgR.WQv.getContext().getString(R.l.favorite_fail_record_expired_bigfile);
                break;
              }
            }
            com.tencent.mm.ui.base.h.p(n.this.fgR.WQv.getContext(), localdd.fyI.fyO, 0);
            AppMethodBeat.o(35216);
          }
          
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35214);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
            localObject1 = n.this.hOQ();
            paramAnonymousView = new HashSet();
            Object localObject2 = kf((List)localObject1);
            if (((String)localObject2).equals(n.e(n.this)))
            {
              com.tencent.mm.ui.base.w.makeText(n.this.fgR.WQv.getContext(), n.this.fgR.WQv.getContext().getString(R.l.fav_doing_error_toast), 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35214);
              return;
            }
            n.a(n.this, (String)localObject2);
            localObject1 = ((List)localObject1).iterator();
            label435:
            label876:
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ca)((Iterator)localObject1).next();
              Object localObject3;
              Object localObject4;
              com.tencent.mm.i.g localg;
              if (((ca)localObject2).erk())
              {
                localObject3 = k.b.OQ(((et)localObject2).field_content);
                if ((localObject3 != null) && (((k.b)localObject3).type == 6) && (!Util.isNullOrNil(((k.b)localObject3).lmc)))
                {
                  localObject4 = m.e((ca)localObject2, ((k.b)localObject3).fvr);
                  if ((localObject4 != null) && ((!com.tencent.mm.vfs.u.agG(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath)) || (com.tencent.mm.vfs.u.bBQ(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen)))
                  {
                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[] { Long.valueOf(((et)localObject2).field_msgId) });
                    paramAnonymousView.add(Long.valueOf(((et)localObject2).field_msgId));
                    localg = new com.tencent.mm.i.g();
                    localg.taskName = "task_ChattingMoreComponent";
                    localg.iUG = new g.a()
                    {
                      public final int a(String paramAnonymous2String, int paramAnonymous2Int, com.tencent.mm.i.c paramAnonymous2c, com.tencent.mm.i.d paramAnonymous2d, boolean paramAnonymous2Boolean)
                      {
                        AppMethodBeat.i(35209);
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2c != null))
                        {
                          this.WzU.field_offset = paramAnonymous2c.field_finishedLength;
                          com.tencent.mm.pluginsdk.model.app.ao.ctZ().a(this.WzU, new String[0]);
                        }
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2d != null) && (paramAnonymous2d.field_retCode == 0))
                        {
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[] { Long.valueOf(this.lrk.field_msgId) });
                          this.WzU.field_status = 199L;
                          this.WzU.field_offset = this.WzU.field_totalLen;
                          com.tencent.mm.pluginsdk.model.app.ao.ctZ().a(this.WzU, new String[0]);
                          this.lrk.setStatus(3);
                          bh.beI();
                          com.tencent.mm.model.c.bbO().a(this.lrk.field_msgId, this.lrk);
                          paramAnonymousView.remove(Long.valueOf(this.lrk.field_msgId));
                          n.6.a(n.6.this, paramAnonymousView);
                        }
                        long l;
                        if ((paramAnonymous2Int != 0) || ((paramAnonymous2d != null) && (paramAnonymous2d.field_retCode != 0)))
                        {
                          l = this.lrk.field_msgId;
                          if (paramAnonymous2d != null) {
                            break label283;
                          }
                        }
                        label283:
                        for (int i = 0;; i = paramAnonymous2d.field_retCode)
                        {
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymous2Int), Integer.valueOf(i) });
                          paramAnonymousView.remove(Long.valueOf(this.lrk.field_msgId));
                          n.6.a(n.6.this, paramAnonymousView);
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
                    localg.field_mediaId = com.tencent.mm.aq.c.a("checkExist", Util.nowMilliSecond(), ((et)localObject2).field_talker, ((et)localObject2).field_msgId);
                    localg.field_aesKey = ((k.b)localObject3).aesKey;
                    localg.field_fileType = 19;
                    localg.field_authKey = ((k.b)localObject3).lmi;
                    localg.iUJ = ((k.b)localObject3).lmc;
                    if ((localObject4 == null) || (Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath))) {
                      break label774;
                    }
                    localg.field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath;
                    if (!f.bkg().b(localg, -1))
                    {
                      Log.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                      paramAnonymousView.remove(Long.valueOf(((et)localObject2).field_msgId));
                    }
                  }
                }
              }
              int i;
              if (((ca)localObject2).hwG())
              {
                localObject3 = com.tencent.mm.ay.q.bmh().C(((et)localObject2).field_talker, ((et)localObject2).field_msgSvrId);
                if (((et)localObject2).field_isSend != 1) {
                  break label807;
                }
                if (!((com.tencent.mm.ay.g)localObject3).blK()) {
                  break label802;
                }
                i = 1;
                if ((((com.tencent.mm.ay.g)localObject3).offset < ((com.tencent.mm.ay.g)localObject3).lAW) || (((com.tencent.mm.ay.g)localObject3).lAW == 0))
                {
                  Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(((et)localObject2).field_msgId) });
                  paramAnonymousView.add(Long.valueOf(((et)localObject2).field_msgId));
                  if (!com.tencent.mm.ay.q.bmi().a(((com.tencent.mm.ay.g)localObject3).localId, ((et)localObject2).field_msgId, i, localObject2, R.g.chat_img_template, new e.a()
                  {
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(35208);
                      Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.lrk.field_msgId) });
                      paramAnonymousView.remove(Long.valueOf(this.lrk.field_msgId));
                      n.6.a(n.6.this, paramAnonymousView);
                      AppMethodBeat.o(35208);
                    }
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, com.tencent.mm.an.q paramAnonymous2q) {}
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, String paramAnonymous2String, com.tencent.mm.an.q paramAnonymous2q)
                    {
                      AppMethodBeat.i(35207);
                      if ((paramAnonymous2Int3 == 0) && (paramAnonymous2Int4 == 0)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.lrk.field_msgId), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
                        paramAnonymousView.remove(Long.valueOf(this.lrk.field_msgId));
                        n.6.a(n.6.this, paramAnonymousView);
                        AppMethodBeat.o(35207);
                        return;
                      }
                    }
                  })) {
                    paramAnonymousView.remove(Long.valueOf(((et)localObject2).field_msgId));
                  }
                }
              }
              if ((((ca)localObject2).dlR()) || (((ca)localObject2).dlT()))
              {
                localObject3 = y.Yk(((et)localObject2).field_imgPath);
                if ((localObject3 != null) && (((com.tencent.mm.modelvideo.w)localObject3).status != 199))
                {
                  paramAnonymousView.add(Long.valueOf(((et)localObject2).field_msgId));
                  localObject4 = new x.a()
                  {
                    public final void a(x.a.a paramAnonymous2a)
                    {
                      AppMethodBeat.i(35206);
                      if (this.lrk.field_imgPath.equals(paramAnonymous2a.fileName))
                      {
                        com.tencent.mm.modelvideo.w localw = y.Yk(paramAnonymous2a.fileName);
                        if ((localw == null) || (!localw.bqS())) {
                          break label114;
                        }
                        Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.lrk.field_msgId), paramAnonymous2a.fileName });
                      }
                      for (;;)
                      {
                        s.bqB().a(this);
                        paramAnonymousView.remove(Long.valueOf(this.lrk.field_msgId));
                        n.6.a(n.6.this, paramAnonymousView);
                        AppMethodBeat.o(35206);
                        return;
                        label114:
                        Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.lrk.field_msgId), paramAnonymous2a.fileName });
                      }
                    }
                  };
                  s.bqB().a((x.a)localObject4, Looper.getMainLooper());
                  Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(((et)localObject2).field_msgId), ((et)localObject2).field_imgPath });
                  if (((com.tencent.mm.modelvideo.w)localObject3).bqR()) {
                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                  }
                  for (i = y.Yq(((et)localObject2).field_imgPath);; i = y.Yf(((et)localObject2).field_imgPath))
                  {
                    if (i == 0) {
                      break label876;
                    }
                    paramAnonymousView.remove(Long.valueOf(((et)localObject2).field_msgId));
                    break;
                    bh.beI();
                    localg.field_fullpath = m.aw(com.tencent.mm.model.c.bce(), ((k.b)localObject3).title, ((k.b)localObject3).llY);
                    break label435;
                    i = 0;
                    break label513;
                    if (!((com.tencent.mm.ay.g)localObject3).blK())
                    {
                      i = 0;
                      break label513;
                    }
                    localObject4 = com.tencent.mm.ay.h.a((com.tencent.mm.ay.g)localObject3);
                    if (!com.tencent.mm.vfs.u.agG(com.tencent.mm.ay.q.bmh().r(((com.tencent.mm.ay.g)localObject4).lNH, "", "")))
                    {
                      i = 0;
                      break label513;
                    }
                    i = 1;
                    break label513;
                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                  }
                }
              }
            }
            label513:
            label774:
            label802:
            label807:
            g(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35214);
          }
        });
        this.JtL = AnimationUtils.loadAnimation(this.fgR.WQv.getContext(), R.a.push_up_in);
        ((com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).k(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35195);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            localObject = (com.tencent.mm.ui.chatting.d.b.k)n.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
            if (((com.tencent.mm.ui.chatting.d.b.k)localObject).VC(((Long)paramAnonymousView.getTag()).longValue()))
            {
              int i = ((com.tencent.mm.ui.chatting.d.b.k)localObject).fsW();
              ((an)n.this.fgR.bC(an.class)).hQt();
              n.a(n.this).hVb();
              n.b(n.this).setVisibility(0);
              n.b(n.this).avk(i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35195);
          }
        });
        break;
        this.jjS = new t((byte)0);
      }
    }
  }
  
  public final void cq(ca paramca)
  {
    AppMethodBeat.i(35226);
    if (paramca == null)
    {
      Log.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
      AppMethodBeat.o(35226);
      return;
    }
    com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
    if (localk.VC(paramca.field_msgId))
    {
      int i = localk.fsW();
      this.WIn.avk(i);
      this.WIn.setVisibility(0);
      this.jjS.hVb();
    }
    AppMethodBeat.o(35226);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(169865);
    super.hNZ();
    if (this.WFx) {
      hOR();
    }
    AppMethodBeat.o(169865);
  }
  
  public final List<ca> hOQ()
  {
    AppMethodBeat.i(169864);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hND().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Log.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[] { Long.valueOf(l) });
      bh.beI();
      localLinkedList.add(com.tencent.mm.model.c.bbO().Oq(l));
    }
    Collections.sort(localLinkedList, new Comparator() {});
    AppMethodBeat.o(169864);
    return localLinkedList;
  }
  
  public final void hOR()
  {
    AppMethodBeat.i(35227);
    this.fgR.WQv.getController().addSearchMenu(false, this.jjS);
    if (this.WIn != null) {
      this.WIn.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).dkS();
    ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOt();
    ((an)this.fgR.bC(an.class)).hQt();
    this.WFx = false;
    hOS();
    ((p)this.fgR.bC(p.class)).fXV();
    ((com.tencent.mm.ui.chatting.d.b.u)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.u.class)).hPs();
    this.fgR.hideVKB();
    com.tencent.mm.ui.chatting.l.hMH();
    AppMethodBeat.o(35227);
  }
  
  public final boolean hOT()
  {
    return this.WFx;
  }
  
  public final void hOU()
  {
    AppMethodBeat.i(35229);
    if (this.jjS != null)
    {
      this.jjS.hVb();
      this.jjS.XUl = null;
    }
    AppMethodBeat.o(35229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.n
 * JD-Core Version:    0.7.0.1
 */