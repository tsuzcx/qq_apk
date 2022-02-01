package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ke;
import com.tencent.mm.g.g.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.z.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.aq;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.q;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.ui.widget.a.f.b;
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

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.n.class)
public class o
  extends a
  implements com.tencent.mm.message.z, com.tencent.mm.ui.chatting.component.api.n
{
  public static QueueWorkerThread aeqs;
  private Animation PHk;
  private boolean aedO;
  private String aekN = "";
  private boolean aemX = false;
  private ChattingFooterMoreBtnBar aeqt;
  private boolean aequ = true;
  private com.tencent.mm.storage.au hRm;
  private boolean hasInit = false;
  private com.tencent.mm.ui.tools.s lMw;
  
  static
  {
    AppMethodBeat.i(35233);
    aeqs = new QueueWorkerThread(5, "MicroMsg.ChattingMoreBtnBarHelper");
    AppMethodBeat.o(35233);
  }
  
  private void jrI()
  {
    AppMethodBeat.i(35228);
    if (this.aemX) {
      this.hlc.showOptionMenu(false);
    }
    for (;;)
    {
      ((bf)this.hlc.cm(bf.class)).juu();
      AppMethodBeat.o(35228);
      return;
      ((com.tencent.mm.ui.chatting.component.api.ad)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ad.class)).jsI();
    }
  }
  
  public final void O(Bundle paramBundle) {}
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(35230);
    jrH();
    AppMethodBeat.o(35230);
  }
  
  public final void b(z.a parama) {}
  
  public final boolean bws()
  {
    return this.aequ;
  }
  
  public final boolean bwt()
  {
    return false;
  }
  
  public final boolean bwu()
  {
    return true;
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35231);
    jrH();
    AppMethodBeat.o(35231);
  }
  
  public final void cL(cc paramcc)
  {
    AppMethodBeat.i(35225);
    if (this.hasInit)
    {
      Log.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
      this.hRm = this.hlc.Uxa;
      if ((!this.hlc.juF()) && (!((e)this.hlc.cm(e.class)).jqW())) {
        break label584;
      }
    }
    label584:
    for (boolean bool = true;; bool = false)
    {
      this.aedO = bool;
      this.aeqt.fWe();
      this.hlc.aezO.getController().addSearchMenu(true, this.lMw);
      if (this.aeqt != null)
      {
        this.aeqt.startAnimation(this.PHk);
        this.aeqt.setVisibility(0);
      }
      this.aemX = true;
      ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtv();
      com.tencent.mm.ui.chatting.component.api.m localm = (com.tencent.mm.ui.chatting.component.api.m)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class);
      localm.jqm();
      localm.jql();
      localm.zK(paramcc.field_msgId);
      int i = localm.gEF();
      this.aeqt.aBM(i);
      ((com.tencent.mm.ui.chatting.component.api.s)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.s.class)).jrX();
      this.hlc.hideVKB();
      jrI();
      ((com.tencent.mm.ui.chatting.component.api.x)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.x.class)).jsm();
      com.tencent.mm.plugin.report.service.h.OAn.b(10811, new Object[] { Integer.valueOf(1) });
      if (this.hRm.iZC())
      {
        paramcc = this.hlc;
        i = R.h.menu_search;
        Log.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[] { Integer.valueOf(i) });
        paramcc.aezP.removeOptionMenu(i);
      }
      ((com.tencent.mm.ui.chatting.component.api.ae)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ae.class)).jsW();
      AppMethodBeat.o(35225);
      return;
      this.hasInit = true;
      if (this.aeqt == null)
      {
        ((ViewStub)this.hlc.findViewById(R.h.gce)).inflate();
        this.aeqt = ((ChattingFooterMoreBtnBar)this.hlc.findViewById(R.h.fye));
      }
      if (((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtC())
      {
        Log.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        if (this.lMw == null) {}
      }
      for (this.lMw.afKz = null;; this.lMw.afKz = new s.c()
          {
            String mph = null;
            
            public final boolean SN(String paramAnonymousString)
            {
              return false;
            }
            
            public final void SO(String paramAnonymousString)
            {
              AppMethodBeat.i(35222);
              Log.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
              Object localObject = (com.tencent.mm.ui.chatting.component.api.au)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class);
              if (Util.isNullOrNil(paramAnonymousString)) {
                if (((com.tencent.mm.ui.chatting.component.api.au)localObject).jtC())
                {
                  if (((com.tencent.mm.ui.chatting.component.api.au)localObject).jtx() != null) {
                    ((com.tencent.mm.ui.chatting.component.api.au)localObject).jtx().SM("");
                  }
                  ((com.tencent.mm.ui.chatting.component.api.au)localObject).aCj(-1);
                }
              }
              for (;;)
              {
                this.mph = paramAnonymousString;
                AppMethodBeat.o(35222);
                return;
                if (o.f(o.this))
                {
                  if (this.mph != null)
                  {
                    ((com.tencent.mm.ui.chatting.component.api.au)localObject).jtv();
                    o.b(o.this).setVisibility(0);
                    localObject = (com.tencent.mm.ui.chatting.component.api.m)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class);
                    o.b(o.this).aBM(((com.tencent.mm.ui.chatting.component.api.m)localObject).gEF());
                  }
                }
                else
                {
                  ((com.tencent.mm.ui.chatting.component.api.au)localObject).jtv();
                  o.b(o.this).setVisibility(8);
                  continue;
                  Log.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                  o.b(o.this).setVisibility(8);
                  ((com.tencent.mm.ui.chatting.component.api.au)localObject).jtu();
                  if (((com.tencent.mm.ui.chatting.component.api.au)localObject).jtx() != null) {
                    ((com.tencent.mm.ui.chatting.component.api.au)localObject).jtx().SM(paramAnonymousString);
                  }
                }
              }
            }
            
            public final void bWw()
            {
              AppMethodBeat.i(35223);
              Log.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
              com.tencent.mm.ui.chatting.component.api.m localm = (com.tencent.mm.ui.chatting.component.api.m)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class);
              if (localm.jqo())
              {
                ((com.tencent.mm.ui.chatting.component.api.au)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtv();
                o.b(o.this).setVisibility(0);
                o.b(o.this).aBM(localm.gEF());
              }
              o.this.hlc.aezO.getController().supportInvalidateOptionsMenu();
              AppMethodBeat.o(35223);
            }
            
            public final void bWx()
            {
              AppMethodBeat.i(35224);
              Log.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 21L, 1L, true);
              if (((com.tencent.mm.ui.chatting.component.api.m)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqo())
              {
                ((com.tencent.mm.ui.chatting.component.api.au)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtu();
                o.b(o.this).setVisibility(8);
              }
              AppMethodBeat.o(35224);
            }
            
            public final void bWy() {}
            
            public final void bWz() {}
          })
      {
        this.aeqt.b(3, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35197);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = (com.tencent.mm.ui.chatting.component.api.m)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class);
            if (paramAnonymousView.gEF() == 0)
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35197);
              return;
            }
            localObject = o.this.hlc.aezO.getContext();
            com.tencent.mm.ui.base.k.a((Context)localObject, ((Context)localObject).getString(R.l.gAv), "", ((Context)localObject).getString(R.l.gEg), ((Context)localObject).getString(R.l.app_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(35196);
                Log.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                paramAnonymous2DialogInterface = (Long[])paramAnonymousView.jqk().toArray(new Long[0]);
                Arrays.sort(paramAnonymous2DialogInterface, new Comparator() {});
                ArrayList localArrayList = new ArrayList();
                SparseArray localSparseArray = paramAnonymousView.jqi();
                int i = localSparseArray.size();
                int n = paramAnonymous2DialogInterface.length;
                int j = 0;
                int k = i;
                if (j < n)
                {
                  Object localObject = paramAnonymous2DialogInterface[j];
                  cc localcc;
                  do
                  {
                    paramAnonymous2Int = i - 1;
                    i = paramAnonymous2Int;
                    m = k;
                    if (paramAnonymous2Int < 0) {
                      break label217;
                    }
                    localcc = (cc)localSparseArray.get(paramAnonymous2Int);
                    if (localcc.field_msgId <= localObject.longValue()) {
                      break;
                    }
                    i = paramAnonymous2Int;
                  } while (localcc.jbE());
                  if (localcc.field_msgId == localObject.longValue()) {}
                  for (int m = 1;; m = 0)
                  {
                    i = paramAnonymous2Int;
                    if (m == 0) {
                      break label230;
                    }
                    i = k - 1;
                    while (i > paramAnonymous2Int)
                    {
                      localArrayList.add(Long.valueOf(((cc)localSparseArray.get(i)).field_msgId));
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
                    } while (((cc)localSparseArray.get(paramAnonymous2Int)).field_msgId != localObject.longValue());
                  }
                }
                com.tencent.mm.ui.chatting.l.a(this.val$context, paramAnonymousView.jqk(), o.this);
                if (localArrayList.size() > 0) {
                  com.tencent.mm.ui.chatting.l.a(this.val$context, new CopyOnWriteArraySet(localArrayList), o.this);
                }
                o.this.jrH();
                AppMethodBeat.o(35196);
              }
            }, null, R.e.alert_btn_color_warn);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35197);
          }
        });
        this.aeqt.b(2, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35198);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (((com.tencent.mm.ui.chatting.component.api.m)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class)).gEF() == 0)
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35198);
              return;
            }
            com.tencent.mm.ui.chatting.p.a(o.this.hlc, o.this.jrG(), o.c(o.this), o.this, o.d(o.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35198);
          }
        });
        this.aeqt.b(1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35199);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = (com.tencent.mm.ui.chatting.component.api.m)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class);
            if ((paramAnonymousView == null) || (paramAnonymousView.gEF() == 0))
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            paramAnonymousView = o.this.jrG();
            if (com.tencent.mm.ui.chatting.m.nq(paramAnonymousView))
            {
              com.tencent.mm.ui.base.k.a(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.gDk), "", o.this.hlc.aezO.getContext().getString(R.l.gps), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.m.ns(paramAnonymousView))
            {
              com.tencent.mm.ui.base.k.a(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.gDl), "", o.this.hlc.aezO.getContext().getString(R.l.gps), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.m.nr(paramAnonymousView))
            {
              com.tencent.mm.ui.base.k.a(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.gDj), "", o.this.hlc.aezO.getContext().getString(R.l.gps), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.m.np(paramAnonymousView))
            {
              com.tencent.mm.ui.base.k.a(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.gDm), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (q.a(o.this.hlc, paramAnonymousView, o.d(o.this))) {
              o.this.jrH();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35199);
          }
        });
        this.aeqt.b(0, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35202);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if (((com.tencent.mm.ui.chatting.component.api.m)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class)).gEF() == 0)
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
            }
            if (((com.tencent.mm.model.ab.IS(o.d(o.this).field_username)) && (!com.tencent.mm.an.g.Dn(o.d(o.this).field_username))) || (com.tencent.mm.model.ab.IW(o.d(o.this).field_username)))
            {
              o.a(o.this, true);
              com.tencent.mm.ui.chatting.n.a(o.this.hlc.aezO.getContext(), o.this.jrG(), o.c(o.this), o.d(o.this).field_username, o.this);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
              com.tencent.mm.plugin.selectrecord.b.d.gUL();
              localObject = new com.tencent.mm.ui.widget.a.f(o.this.hlc.aezO.getContext(), 1, false);
              ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new u.g()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
                {
                  AppMethodBeat.i(35200);
                  paramAnonymous2s.oh(0, R.l.gOf);
                  paramAnonymous2s.oh(1, R.l.gOg);
                  if (aq.a(o.this.hlc.aezO.getContext(), IWWAPI.WWAppType.aicB)) {
                    paramAnonymous2s.c(2, o.this.hlc.aezO.getContext().getString(R.l.gOh, new Object[] { aq.b(o.this.hlc.aezO.getContext(), IWWAPI.WWAppType.aicB) }));
                  }
                  if (aq.a(o.this.hlc.aezO.getContext(), IWWAPI.WWAppType.aicC)) {
                    paramAnonymous2s.c(3, o.this.hlc.aezO.getContext().getString(R.l.gOh, new Object[] { aq.b(o.this.hlc.aezO.getContext(), IWWAPI.WWAppType.aicC) }));
                  }
                  AppMethodBeat.o(35200);
                }
              };
              ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new u.i()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(35201);
                  final List localList = o.this.jrG();
                  Object localObject1 = com.tencent.mm.plugin.selectrecord.b.d.gUK();
                  if ((localList == null) && (localList.size() == 0))
                  {
                    ((com.tencent.mm.plugin.selectrecord.b.d)localObject1).uh(0L);
                    switch (paramAnonymous2MenuItem.getItemId())
                    {
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(35201);
                    return;
                    ((com.tencent.mm.plugin.selectrecord.b.d)localObject1).uh(localList.size());
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
                      Object localObject3 = (cc)((Iterator)localObject2).next();
                      switch (((cc)localObject3).getType())
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
                        localObject3 = k.b.Hf(((fi)localObject3).field_content);
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
                    localObject1 = ((com.tencent.mm.plugin.selectrecord.b.d)localObject1).PmI;
                    ((ke)localObject1).iWf = ((ke)localObject1).F("FinalShareCountByType", (String)localObject2, true);
                    break;
                    com.tencent.mm.plugin.selectrecord.b.d.gUK().ug(2L);
                    if ((localList != null) && (localList.size() > 31))
                    {
                      com.tencent.mm.ui.base.k.b(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.gXu), "", o.this.hlc.aezO.getContext().getString(R.l.gOg), o.this.hlc.aezO.getContext().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(256271);
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL to MENU_ID_SEND_RECORD");
                          o.5.a(o.5.this, localList);
                          AppMethodBeat.o(256271);
                        }
                      }, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(256270);
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL onCancel");
                          AppMethodBeat.o(256270);
                        }
                      });
                      AppMethodBeat.o(35201);
                      return;
                    }
                    o.a(o.this, true);
                    if (!com.tencent.mm.ui.chatting.n.a(o.this.hlc.aezO.getContext(), localList, o.c(o.this), o.d(o.this).field_username, o.this))
                    {
                      com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
                      AppMethodBeat.o(35201);
                      return;
                      o.5.a(o.5.this, localList);
                      AppMethodBeat.o(35201);
                      return;
                      if (WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramAnonymousView.getContext()))
                      {
                        com.tencent.mm.plugin.selectrecord.b.d.gUK().ug(3L);
                        if (!aq.a(o.this.hlc.aezO.getContext(), o.d(o.this), localList, o.c(o.this), IWWAPI.WWAppType.aicB)) {
                          com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
                        }
                        o.this.jrH();
                        AppMethodBeat.o(35201);
                        return;
                        if (WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramAnonymousView.getContext()))
                        {
                          com.tencent.mm.plugin.selectrecord.b.d.gUK().ug(3L);
                          if (!aq.a(o.this.hlc.aezO.getContext(), o.d(o.this), localList, o.c(o.this), IWWAPI.WWAppType.aicC)) {
                            com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
                          }
                          o.this.jrH();
                        }
                      }
                    }
                  }
                }
              };
              ((com.tencent.mm.ui.widget.a.f)localObject).aeLi = new f.b()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(256125);
                  com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
                  AppMethodBeat.o(256125);
                }
              };
              ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
            }
          }
        });
        this.aeqt.b(4, new View.OnClickListener()
        {
          private void c(dn paramAnonymousdn)
          {
            AppMethodBeat.i(35212);
            Object localObject1 = o.this.jrG();
            Object localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (!com.tencent.mm.ui.chatting.ae.cj((cc)((Iterator)localObject2).next()))
              {
                com.tencent.mm.ui.base.k.a(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.gHq), "", o.this.hlc.aezO.getContext().getString(R.l.welcome_i_know), null);
                AppMethodBeat.o(35212);
                return;
              }
            }
            long l = com.tencent.mm.k.c.aRl();
            localObject2 = com.tencent.mm.ui.chatting.j.aegW;
            if (com.tencent.mm.ui.chatting.j.j((List)localObject1, l))
            {
              com.tencent.mm.ui.base.k.a(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.gHH, new Object[] { Util.getSizeKB(l) }), "", o.this.hlc.aezO.getContext().getString(R.l.welcome_i_know), null);
              AppMethodBeat.o(35212);
              return;
            }
            l = com.tencent.mm.k.c.aRn();
            localObject2 = com.tencent.mm.ui.chatting.j.aegW;
            if (com.tencent.mm.ui.chatting.j.i((List)localObject1, l))
            {
              com.tencent.mm.ui.base.k.a(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.gHI, new Object[] { Util.getSizeKB(l) }), "", o.this.hlc.aezO.getContext().getString(R.l.welcome_i_know), null);
              AppMethodBeat.o(35212);
              return;
            }
            paramAnonymousdn.hDr.fragment = o.this.hlc.aezO;
            paramAnonymousdn.hDr.hDy = 41;
            paramAnonymousdn.hDr.hDA = new com.tencent.mm.ui.widget.snackbar.a.c()
            {
              public final void cpT()
              {
                AppMethodBeat.i(35205);
                ((com.tencent.mm.ui.chatting.component.api.x)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.x.class)).jsl();
                AppMethodBeat.o(35205);
              }
              
              public final void onHide()
              {
                AppMethodBeat.i(35204);
                o.this.jrH();
                AppMethodBeat.o(35204);
              }
              
              public final void onShow()
              {
                AppMethodBeat.i(35203);
                o.this.jrH();
                o.b(o.this).setVisibility(4);
                AppMethodBeat.o(35203);
              }
            };
            paramAnonymousdn.publish();
            int i;
            if (paramAnonymousdn.hDs.ret == 0)
            {
              i = 1;
              l = Util.nowSecond();
              Iterator localIterator = ((List)localObject1).iterator();
              label377:
              while (localIterator.hasNext())
              {
                localObject1 = (cc)localIterator.next();
                if (((cc)localObject1).fxR())
                {
                  localObject2 = k.b.Hf(Util.processXml(((fi)localObject1).field_content));
                  if ((localObject2 != null) && (((k.b)localObject2).type == 5) && (!Util.isNullOrNil(((k.b)localObject2).url))) {
                    if (!((cc)localObject1).iYe()) {
                      break label935;
                    }
                  }
                }
              }
            }
            label935:
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
              com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
              break label377;
              i = 2;
              break;
              if (paramAnonymousdn.hDs.ret == 0)
              {
                if (14 != paramAnonymousdn.hDr.type)
                {
                  Log.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                  AppMethodBeat.o(35212);
                  return;
                }
                if (paramAnonymousdn.hDr.hDu == null)
                {
                  Log.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                  AppMethodBeat.o(35212);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(11142, new Object[] { Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBI), Integer.valueOf(paramAnonymousdn.hDr.hDu.PTe), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBJ), Integer.valueOf(paramAnonymousdn.hDr.hDu.AXs), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBK), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBL), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBM), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBN), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBO), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBP), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBQ), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBR), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBS), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBT), Integer.valueOf(paramAnonymousdn.hDr.hDu.ZBU) });
              }
              AppMethodBeat.o(35212);
              return;
            }
          }
          
          private void i(HashSet<Long> paramAnonymousHashSet)
          {
            AppMethodBeat.i(35215);
            if (paramAnonymousHashSet.isEmpty()) {
              new MMHandler(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(255794);
                  o.6.this.jrL();
                  AppMethodBeat.o(255794);
                }
              });
            }
            AppMethodBeat.o(35215);
          }
          
          private static String nv(List<cc> paramAnonymousList)
          {
            AppMethodBeat.i(35213);
            StringBuffer localStringBuffer = new StringBuffer();
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext()) {
              localStringBuffer.append(((cc)paramAnonymousList.next()).field_msgId);
            }
            paramAnonymousList = localStringBuffer.toString();
            AppMethodBeat.o(35213);
            return paramAnonymousList;
          }
          
          private static void nw(List<cc> paramAnonymousList)
          {
            AppMethodBeat.i(35217);
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              cc localcc = (cc)paramAnonymousList.next();
              com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.aedy, a.d.aedD, localcc, 0);
            }
            AppMethodBeat.o(35217);
          }
          
          public final void jrL()
          {
            AppMethodBeat.i(35216);
            o.a(o.this, "");
            final List localList = o.this.jrG();
            if (com.tencent.mm.ui.chatting.m.nq(localList))
            {
              com.tencent.mm.ui.base.k.a(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.favorite_fail_remuxing_error), "", o.this.hlc.aezO.getContext().getString(R.l.gps), new DialogInterface.OnClickListener()
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
            final dn localdn = new dn();
            Log.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { o.d(o.this).field_username });
            Object localObject1;
            Object localObject2;
            Object localObject3;
            if ((localList != null) && (localList.size() == 1))
            {
              localObject1 = (cc)localList.get(0);
              if ((localObject1 != null) && ((((cc)localObject1).fxR()) || (((cc)localObject1).iYe())))
              {
                if (((cc)localObject1).jbO())
                {
                  localObject2 = k.b.Hf(((fi)localObject1).field_content);
                  if ((localObject2 != null) && (((k.b)localObject2).type == 74))
                  {
                    com.tencent.mm.ui.base.k.a(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.gHF), "", o.this.hlc.aezO.getContext().getString(R.l.gps), new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                    });
                    AppMethodBeat.o(35216);
                    return;
                  }
                }
                localObject2 = com.tencent.mm.model.ad.Jo(((fi)localObject1).field_msgSvrId);
                localObject3 = com.tencent.mm.model.ad.bCb().M((String)localObject2, true);
                ((ad.b)localObject3).q("prePublishId", "msg_" + ((fi)localObject1).field_msgSvrId);
                boolean bool = ((e)o.this.hlc.cm(e.class)).jqV();
                ((ad.b)localObject3).q("preUsername", com.tencent.mm.ui.chatting.viewitems.c.b((cc)localObject1, o.c(o.this), bool));
                ((ad.b)localObject3).q("preChatName", o.d(o.this).field_username);
                ((ad.b)localObject3).q("preMsgIndex", Integer.valueOf(0));
                ((ad.b)localObject3).q("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.c.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.l.class)).a("adExtStr", (ad.b)localObject3, (cc)localObject1);
                localdn.hDr.sessionId = ((String)localObject2);
              }
            }
            if (com.tencent.mm.pluginsdk.model.n.a(o.this.hlc.aezO.getContext(), localdn, o.d(o.this).field_username, localList, true))
            {
              localObject1 = localList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (cc)((Iterator)localObject1).next();
                if (((cc)localObject2).fxR()) {
                  com.tencent.mm.modelstat.b.oUZ.e((cc)localObject2, com.tencent.mm.message.l.v((cc)localObject2));
                } else {
                  com.tencent.mm.modelstat.b.oUZ.ao((cc)localObject2);
                }
              }
              c(localdn);
              nw(o.this.jrG());
              AppMethodBeat.o(35216);
              return;
            }
            if (o.this.jrG().size() > 1)
            {
              localObject3 = o.this.hlc.aezO.getContext();
              if (localdn.hDr.hDx >= 0)
              {
                localObject1 = o.this.hlc.aezO.getContext().getString(R.l.favorite_fail_recordtype_error);
                if (localdn.hDr.hDx < 0) {
                  break label742;
                }
              }
              label742:
              for (localObject2 = o.this.hlc.aezO.getContext().getString(R.l.confirm_dialog_ok);; localObject2 = o.this.hlc.aezO.getContext().getString(R.l.plugin_favorite_opt))
              {
                com.tencent.mm.ui.base.k.b((Context)localObject3, (String)localObject1, "", (String)localObject2, o.this.hlc.aezO.getContext().getString(R.l.confirm_dialog_cancel), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(255954);
                    paramAnonymous2DialogInterface = localList.iterator();
                    while (paramAnonymous2DialogInterface.hasNext())
                    {
                      cc localcc = (cc)paramAnonymous2DialogInterface.next();
                      if ((!localcc.jbH()) && (!localcc.jbG()))
                      {
                        if ((localdn.hDr.type == 14) && (localdn.hDr.hDt.vEn.size() == 0))
                        {
                          o.this.jrH();
                          AppMethodBeat.o(255954);
                          return;
                        }
                        o.6.a(o.6.this, localdn);
                        o.6.nx(o.this.jrG());
                        AppMethodBeat.o(255954);
                        return;
                      }
                    }
                    AppMethodBeat.o(255954);
                  }
                }, null);
                AppMethodBeat.o(35216);
                return;
                localObject1 = o.this.hlc.aezO.getContext().getString(R.l.favorite_fail_record_expired_bigfile);
                break;
              }
            }
            com.tencent.mm.ui.base.k.s(o.this.hlc.aezO.getContext(), localdn.hDr.hDx, 0);
            AppMethodBeat.o(35216);
          }
          
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35214);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
            localObject1 = o.this.jrG();
            paramAnonymousView = new HashSet();
            Object localObject2 = nv((List)localObject1);
            if (((String)localObject2).equals(o.e(o.this)))
            {
              com.tencent.mm.ui.base.aa.makeText(o.this.hlc.aezO.getContext(), o.this.hlc.aezO.getContext().getString(R.l.fav_doing_error_toast), 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35214);
              return;
            }
            if (com.tencent.mm.ui.chatting.m.nr((List)localObject1))
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "fav item isContainPlaceHolderMsg");
              paramAnonymousView = o.this.hlc.aezO.getContext();
              com.tencent.mm.ui.base.k.a(paramAnonymousView, paramAnonymousView.getString(R.l.gDj), "", paramAnonymousView.getString(R.l.gps), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35214);
              return;
            }
            o.a(o.this, (String)localObject2);
            localObject1 = ((List)localObject1).iterator();
            label516:
            label957:
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (cc)((Iterator)localObject1).next();
              Object localObject3;
              Object localObject4;
              com.tencent.mm.g.g localg;
              if (((cc)localObject2).fxR())
              {
                localObject3 = k.b.Hf(((fi)localObject2).field_content);
                if ((localObject3 != null) && (((k.b)localObject3).type == 6) && (!Util.isNullOrNil(((k.b)localObject3).tpurl)))
                {
                  localObject4 = com.tencent.mm.pluginsdk.model.app.n.g((cc)localObject2, ((k.b)localObject3).hzM);
                  if ((localObject4 != null) && ((!com.tencent.mm.vfs.y.ZC(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath)) || (com.tencent.mm.vfs.y.bEl(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen)))
                  {
                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[] { Long.valueOf(((fi)localObject2).field_msgId) });
                    paramAnonymousView.add(Long.valueOf(((fi)localObject2).field_msgId));
                    localg = new com.tencent.mm.g.g();
                    localg.taskName = "task_ChattingMoreComponent";
                    localg.lwL = new g.a()
                    {
                      public final int a(String paramAnonymous2String, int paramAnonymous2Int, com.tencent.mm.g.c paramAnonymous2c, com.tencent.mm.g.d paramAnonymous2d, boolean paramAnonymous2Boolean)
                      {
                        AppMethodBeat.i(255793);
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2c != null))
                        {
                          this.aehp.field_offset = paramAnonymous2c.field_finishedLength;
                          as.cWJ().a(this.aehp, new String[0]);
                        }
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2d != null) && (paramAnonymous2d.field_retCode == 0))
                        {
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[] { Long.valueOf(this.oiL.field_msgId) });
                          this.aehp.field_status = 199L;
                          this.aehp.field_offset = this.aehp.field_totalLen;
                          as.cWJ().a(this.aehp, new String[0]);
                          this.oiL.setStatus(3);
                          bh.bCz();
                          com.tencent.mm.model.c.bzD().a(this.oiL.field_msgId, this.oiL);
                          paramAnonymousView.remove(Long.valueOf(this.oiL.field_msgId));
                          o.6.a(o.6.this, paramAnonymousView);
                        }
                        long l;
                        if ((paramAnonymous2Int != 0) || ((paramAnonymous2d != null) && (paramAnonymous2d.field_retCode != 0)))
                        {
                          l = this.oiL.field_msgId;
                          if (paramAnonymous2d != null) {
                            break label283;
                          }
                        }
                        label283:
                        for (int i = 0;; i = paramAnonymous2d.field_retCode)
                        {
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymous2Int), Integer.valueOf(i) });
                          paramAnonymousView.remove(Long.valueOf(this.oiL.field_msgId));
                          o.6.a(o.6.this, paramAnonymousView);
                          AppMethodBeat.o(255793);
                          return 0;
                        }
                      }
                      
                      public final void a(String paramAnonymous2String, ByteArrayOutputStream paramAnonymous2ByteArrayOutputStream) {}
                      
                      public final byte[] h(String paramAnonymous2String, byte[] paramAnonymous2ArrayOfByte)
                      {
                        return new byte[0];
                      }
                    };
                    localg.field_mediaId = com.tencent.mm.modelcdntran.h.a("checkExist", Util.nowMilliSecond(), ((fi)localObject2).field_talker, ((fi)localObject2).field_msgId);
                    localg.field_aesKey = ((k.b)localObject3).aesKey;
                    localg.field_fileType = 19;
                    localg.field_authKey = ((k.b)localObject3).nRn;
                    localg.lwO = ((k.b)localObject3).tpurl;
                    if ((localObject4 == null) || (Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath))) {
                      break label855;
                    }
                    localg.field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath;
                    if (!com.tencent.mm.modelcdntran.k.bHW().b(localg, -1))
                    {
                      Log.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                      paramAnonymousView.remove(Long.valueOf(((fi)localObject2).field_msgId));
                    }
                  }
                }
              }
              int i;
              if (((cc)localObject2).iYk())
              {
                localObject3 = r.bKa().G(((fi)localObject2).field_talker, ((fi)localObject2).field_msgSvrId);
                if (((fi)localObject2).field_isSend != 1) {
                  break label888;
                }
                if (!((com.tencent.mm.modelimage.h)localObject3).bJE()) {
                  break label883;
                }
                i = 1;
                label594:
                if ((((com.tencent.mm.modelimage.h)localObject3).offset < ((com.tencent.mm.modelimage.h)localObject3).osy) || (((com.tencent.mm.modelimage.h)localObject3).osy == 0))
                {
                  Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(((fi)localObject2).field_msgId) });
                  paramAnonymousView.add(Long.valueOf(((fi)localObject2).field_msgId));
                  if (!r.bKb().a(((com.tencent.mm.modelimage.h)localObject3).localId, ((fi)localObject2).field_msgId, i, localObject2, R.g.chat_img_template, new f.a()
                  {
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(255772);
                      Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.oiL.field_msgId) });
                      paramAnonymousView.remove(Long.valueOf(this.oiL.field_msgId));
                      o.6.a(o.6.this, paramAnonymousView);
                      AppMethodBeat.o(255772);
                    }
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, com.tencent.mm.am.p paramAnonymous2p) {}
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, String paramAnonymous2String, com.tencent.mm.am.p paramAnonymous2p)
                    {
                      AppMethodBeat.i(255767);
                      if ((paramAnonymous2Int3 == 0) && (paramAnonymous2Int4 == 0)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.oiL.field_msgId), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
                        paramAnonymousView.remove(Long.valueOf(this.oiL.field_msgId));
                        o.6.a(o.6.this, paramAnonymousView);
                        AppMethodBeat.o(255767);
                        return;
                      }
                    }
                  })) {
                    paramAnonymousView.remove(Long.valueOf(((fi)localObject2).field_msgId));
                  }
                }
              }
              if ((((cc)localObject2).dSH()) || (((cc)localObject2).dSJ()))
              {
                localObject3 = com.tencent.mm.modelvideo.ab.Qo(((fi)localObject2).field_imgPath);
                if ((localObject3 != null) && (((com.tencent.mm.modelvideo.z)localObject3).status != 199))
                {
                  paramAnonymousView.add(Long.valueOf(((fi)localObject2).field_msgId));
                  localObject4 = new aa.a()
                  {
                    public final void a(aa.a.a paramAnonymous2a)
                    {
                      AppMethodBeat.i(255764);
                      if (this.oiL.field_imgPath.equals(paramAnonymous2a.fileName))
                      {
                        com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(paramAnonymous2a.fileName);
                        if ((localz == null) || (!localz.bOx())) {
                          break label114;
                        }
                        Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.oiL.field_msgId), paramAnonymous2a.fileName });
                      }
                      for (;;)
                      {
                        v.bOh().a(this);
                        paramAnonymousView.remove(Long.valueOf(this.oiL.field_msgId));
                        o.6.a(o.6.this, paramAnonymousView);
                        AppMethodBeat.o(255764);
                        return;
                        label114:
                        Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.oiL.field_msgId), paramAnonymous2a.fileName });
                      }
                    }
                  };
                  v.bOh().a((aa.a)localObject4, Looper.getMainLooper());
                  Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(((fi)localObject2).field_msgId), ((fi)localObject2).field_imgPath });
                  if (((com.tencent.mm.modelvideo.z)localObject3).bOw()) {
                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                  }
                  for (i = com.tencent.mm.modelvideo.ab.Qu(((fi)localObject2).field_imgPath);; i = com.tencent.mm.modelvideo.ab.Qj(((fi)localObject2).field_imgPath))
                  {
                    if (i == 0) {
                      break label957;
                    }
                    paramAnonymousView.remove(Long.valueOf(((fi)localObject2).field_msgId));
                    break;
                    label855:
                    bh.bCz();
                    localg.field_fullpath = com.tencent.mm.pluginsdk.model.app.n.aK(com.tencent.mm.model.c.bzT(), ((k.b)localObject3).title, ((k.b)localObject3).nRe);
                    break label516;
                    label883:
                    i = 0;
                    break label594;
                    label888:
                    if (!((com.tencent.mm.modelimage.h)localObject3).bJE())
                    {
                      i = 0;
                      break label594;
                    }
                    localObject4 = com.tencent.mm.modelimage.i.a((com.tencent.mm.modelimage.h)localObject3);
                    if (!com.tencent.mm.vfs.y.ZC(r.bKa().v(((com.tencent.mm.modelimage.h)localObject4).oGr, "", "")))
                    {
                      i = 0;
                      break label594;
                    }
                    i = 1;
                    break label594;
                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                  }
                }
              }
            }
            i(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35214);
          }
        });
        this.PHk = AnimationUtils.loadAnimation(this.hlc.aezO.getContext(), R.a.push_up_in);
        ((com.tencent.mm.ui.chatting.component.api.m)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class)).m(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35195);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            localObject = (com.tencent.mm.ui.chatting.component.api.m)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class);
            if (((com.tencent.mm.ui.chatting.component.api.m)localObject).zK(((Long)paramAnonymousView.getTag()).longValue()))
            {
              int i = ((com.tencent.mm.ui.chatting.component.api.m)localObject).gEF();
              ((com.tencent.mm.ui.chatting.component.api.au)o.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtv();
              o.a(o.this).jyO();
              o.b(o.this).setVisibility(0);
              o.b(o.this).aBM(i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35195);
          }
        });
        break;
        this.lMw = new com.tencent.mm.ui.tools.s(true);
      }
    }
  }
  
  public final void cM(cc paramcc)
  {
    AppMethodBeat.i(35226);
    if (paramcc == null)
    {
      Log.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
      AppMethodBeat.o(35226);
      return;
    }
    com.tencent.mm.ui.chatting.component.api.m localm = (com.tencent.mm.ui.chatting.component.api.m)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class);
    if (localm.zK(paramcc.field_msgId))
    {
      int i = localm.gEF();
      this.aeqt.aBM(i);
      this.aeqt.setVisibility(0);
      this.lMw.jyO();
    }
    AppMethodBeat.o(35226);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(169865);
    super.jqF();
    if (this.aemX) {
      jrH();
    }
    AppMethodBeat.o(169865);
  }
  
  public final List<cc> jrG()
  {
    AppMethodBeat.i(169864);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((com.tencent.mm.ui.chatting.component.api.m)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqk().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Log.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[] { Long.valueOf(l) });
      bh.bCz();
      localLinkedList.add(com.tencent.mm.model.c.bzD().sl(l));
    }
    Collections.sort(localLinkedList, new Comparator() {});
    AppMethodBeat.o(169864);
    return localLinkedList;
  }
  
  public final void jrH()
  {
    AppMethodBeat.i(35227);
    this.hlc.aezO.getController().addSearchMenu(false, this.lMw);
    if (this.aeqt != null) {
      this.aeqt.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.component.api.m)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class)).dRI();
    ((e)this.hlc.cm(e.class)).jrl();
    ((com.tencent.mm.ui.chatting.component.api.au)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtv();
    this.aemX = false;
    jrI();
    ((com.tencent.mm.ui.chatting.component.api.s)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.s.class)).hqq();
    ((com.tencent.mm.ui.chatting.component.api.x)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.x.class)).jsm();
    this.hlc.hideVKB();
    com.tencent.mm.ui.chatting.n.jpj();
    AppMethodBeat.o(35227);
  }
  
  public final boolean jrJ()
  {
    return this.aemX;
  }
  
  public final void jrK()
  {
    AppMethodBeat.i(35229);
    if (this.lMw != null)
    {
      this.lMw.jyO();
      this.lMw.afKz = null;
    }
    AppMethodBeat.o(35229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.o
 * JD-Core Version:    0.7.0.1
 */