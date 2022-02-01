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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.z;
import com.tencent.mm.ag.z.a;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.b.a.gf;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.p;
import com.tencent.mm.ui.chatting.n;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.s.b;
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

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.l.class)
public class m
  extends a
  implements z, com.tencent.mm.ui.chatting.d.b.l
{
  public static QueueWorkerThread PnZ;
  private Animation Dog;
  private boolean Pdm;
  private String PjI = "";
  private boolean PlM = false;
  private ChattingFooterMoreBtnBar Poa;
  private boolean Pob = true;
  private as dSh;
  private com.tencent.mm.ui.tools.s gzP;
  private boolean hasInit = false;
  
  static
  {
    AppMethodBeat.i(35233);
    PnZ = new QueueWorkerThread(5, "MicroMsg.ChattingMoreBtnBarHelper");
    AppMethodBeat.o(35233);
  }
  
  private void gPA()
  {
    AppMethodBeat.i(35228);
    if (this.PlM) {
      this.dom.showOptionMenu(false);
    }
    for (;;)
    {
      ((aw)this.dom.bh(aw.class)).gRy();
      AppMethodBeat.o(35228);
      return;
      ((aa)this.dom.bh(aa.class)).gQp();
    }
  }
  
  public final void B(Bundle paramBundle) {}
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(35230);
    gPz();
    AppMethodBeat.o(35230);
  }
  
  public final boolean aSC()
  {
    return this.Pob;
  }
  
  public final boolean aSD()
  {
    return false;
  }
  
  public final boolean aSE()
  {
    return true;
  }
  
  public final void b(z.a parama) {}
  
  public final void bV(ca paramca)
  {
    AppMethodBeat.i(35225);
    if (this.hasInit)
    {
      Log.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
      this.dSh = this.dom.GUe;
      if ((!this.dom.gRL()) && (!((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ())) {
        break label583;
      }
    }
    label583:
    for (boolean bool = true;; bool = false)
    {
      this.Pdm = bool;
      this.Poa.eer();
      this.dom.Pwc.getController().addSearchMenu(true, this.gzP);
      if (this.Poa != null)
      {
        this.Poa.startAnimation(this.Dog);
        this.Poa.setVisibility(0);
      }
      this.PlM = true;
      ((am)this.dom.bh(am.class)).gQW();
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      localk.gOu();
      localk.gOt();
      localk.Nu(paramca.field_msgId);
      int i = localk.eGR();
      this.Poa.amj(i);
      ((p)this.dom.bh(p.class)).gPM();
      this.dom.hideVKB();
      gPA();
      ((com.tencent.mm.ui.chatting.d.b.u)this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPX();
      com.tencent.mm.plugin.report.service.h.CyF.a(10811, new Object[] { Integer.valueOf(1) });
      if (this.dSh.gBM())
      {
        paramca = this.dom;
        Log.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[] { Integer.valueOf(2131304628) });
        paramca.Pwd.removeOptionMenu(2131304628);
      }
      ((com.tencent.mm.ui.chatting.d.b.ab)this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).gQB();
      AppMethodBeat.o(35225);
      return;
      this.hasInit = true;
      if (this.Poa == null)
      {
        ((ViewStub)this.dom.findViewById(2131309874)).inflate();
        this.Poa = ((ChattingFooterMoreBtnBar)this.dom.findViewById(2131298441));
      }
      if (((am)this.dom.bh(am.class)).gRd())
      {
        Log.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        if (this.gzP == null) {}
      }
      for (this.gzP.Qwi = null;; this.gzP.Qwi = new s.b()
          {
            String heA = null;
            
            public final boolean SN(String paramAnonymousString)
            {
              return false;
            }
            
            public final void SO(String paramAnonymousString)
            {
              AppMethodBeat.i(35222);
              Log.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
              Object localObject = (am)m.this.dom.bh(am.class);
              if (Util.isNullOrNil(paramAnonymousString)) {
                if (((am)localObject).gRd())
                {
                  if (((am)localObject).gQY() != null) {
                    ((am)localObject).gQY().SM("");
                  }
                  ((am)localObject).amE(-1);
                }
              }
              for (;;)
              {
                this.heA = paramAnonymousString;
                AppMethodBeat.o(35222);
                return;
                if (m.f(m.this))
                {
                  if (this.heA != null)
                  {
                    ((am)localObject).gQW();
                    m.b(m.this).setVisibility(0);
                    localObject = (com.tencent.mm.ui.chatting.d.b.k)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
                    m.b(m.this).amj(((com.tencent.mm.ui.chatting.d.b.k)localObject).eGR());
                  }
                }
                else
                {
                  ((am)localObject).gQW();
                  m.b(m.this).setVisibility(8);
                  continue;
                  Log.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                  m.b(m.this).setVisibility(8);
                  ((am)localObject).gQV();
                  if (((am)localObject).gQY() != null) {
                    ((am)localObject).gQY().SM(paramAnonymousString);
                  }
                }
              }
            }
            
            public final void bnA() {}
            
            public final void bnB() {}
            
            public final void bny()
            {
              AppMethodBeat.i(35223);
              Log.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
              com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
              if (localk.isInEditMode())
              {
                ((am)m.this.dom.bh(am.class)).gQW();
                m.b(m.this).setVisibility(0);
                m.b(m.this).amj(localk.eGR());
              }
              m.this.dom.Pwc.getController().supportInvalidateOptionsMenu();
              AppMethodBeat.o(35223);
            }
            
            public final void bnz()
            {
              AppMethodBeat.i(35224);
              Log.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 21L, 1L, true);
              if (((com.tencent.mm.ui.chatting.d.b.k)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode())
              {
                ((am)m.this.dom.bh(am.class)).gQV();
                m.b(m.this).setVisibility(8);
              }
              AppMethodBeat.o(35224);
            }
          })
      {
        this.Poa.b(3, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35197);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.k)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if (paramAnonymousView.eGR() == 0)
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35197);
              return;
            }
            localObject = m.this.dom.Pwc.getContext();
            com.tencent.mm.ui.base.h.a((Context)localObject, ((Context)localObject).getString(2131757780), "", ((Context)localObject).getString(2131758290), ((Context)localObject).getString(2131755761), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(35196);
                Log.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                paramAnonymous2DialogInterface = (Long[])paramAnonymousView.gOs().toArray(new Long[0]);
                Arrays.sort(paramAnonymous2DialogInterface, new Comparator() {});
                ArrayList localArrayList = new ArrayList();
                SparseArray localSparseArray = paramAnonymousView.gOq();
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
                  } while (localca.gDm());
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
                com.tencent.mm.ui.chatting.j.a(this.val$context, paramAnonymousView.gOs(), m.this);
                if (localArrayList.size() > 0) {
                  com.tencent.mm.ui.chatting.j.a(this.val$context, new CopyOnWriteArraySet(localArrayList), m.this);
                }
                m.this.gPz();
                AppMethodBeat.o(35196);
              }
            }, null, 2131099922);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35197);
          }
        });
        this.Poa.b(2, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35198);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (((com.tencent.mm.ui.chatting.d.b.k)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).eGR() == 0)
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35198);
              return;
            }
            n.a(m.this.dom, m.this.gPy(), m.c(m.this), m.this, m.d(m.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35198);
          }
        });
        this.Poa.b(1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35199);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.k)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if ((paramAnonymousView == null) || (paramAnonymousView.eGR() == 0))
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            paramAnonymousView = m.this.gPy();
            if (com.tencent.mm.ui.chatting.k.jj(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(2131758177), "", m.this.dom.Pwc.getContext().getString(2131755013), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.k.jk(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(2131758178), "", m.this.dom.Pwc.getContext().getString(2131755013), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.k.ji(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(2131758179), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.o.a(m.this.dom, paramAnonymousView, m.d(m.this))) {
              m.this.gPz();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35199);
          }
        });
        this.Poa.b(0, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35202);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            if (((com.tencent.mm.ui.chatting.d.b.k)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).eGR() == 0)
            {
              Log.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
            }
            if (((com.tencent.mm.model.ab.IT(m.d(m.this).field_username)) && (!com.tencent.mm.al.g.DQ(m.d(m.this).field_username))) || (com.tencent.mm.model.ab.JF(m.d(m.this).field_username)))
            {
              m.a(m.this, true);
              com.tencent.mm.ui.chatting.l.a(m.this.dom.Pwc.getContext(), m.this.gPy(), m.c(m.this), m.d(m.this).field_username, m.this);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
              com.tencent.mm.plugin.selectrecord.b.b.eSA();
              localObject = new com.tencent.mm.ui.widget.a.e(m.this.dom.Pwc.getContext(), 1, false);
              ((com.tencent.mm.ui.widget.a.e)localObject).HLX = new o.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
                {
                  AppMethodBeat.i(35200);
                  paramAnonymous2m.kV(0, 2131763226);
                  paramAnonymous2m.kV(1, 2131763227);
                  if (com.tencent.mm.ui.chatting.ao.a(m.this.dom.Pwc.getContext(), IWWAPI.WWAppType.Sxc)) {
                    paramAnonymous2m.d(2, m.this.dom.Pwc.getContext().getString(2131763228, new Object[] { com.tencent.mm.ui.chatting.ao.b(m.this.dom.Pwc.getContext(), IWWAPI.WWAppType.Sxc) }));
                  }
                  if (com.tencent.mm.ui.chatting.ao.a(m.this.dom.Pwc.getContext(), IWWAPI.WWAppType.Sxd)) {
                    paramAnonymous2m.d(3, m.this.dom.Pwc.getContext().getString(2131763228, new Object[] { com.tencent.mm.ui.chatting.ao.b(m.this.dom.Pwc.getContext(), IWWAPI.WWAppType.Sxd) }));
                  }
                  AppMethodBeat.o(35200);
                }
              };
              ((com.tencent.mm.ui.widget.a.e)localObject).HLY = new o.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(35201);
                  final List localList = m.this.gPy();
                  Object localObject1 = com.tencent.mm.plugin.selectrecord.b.b.eSz();
                  long l = localList.size();
                  ((com.tencent.mm.plugin.selectrecord.b.b)localObject1).CXf.eJj = l;
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
                      localObject3 = k.b.HD(((eo)localObject3).field_content);
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
                  localObject1 = ((com.tencent.mm.plugin.selectrecord.b.b)localObject1).CXf;
                  ((gf)localObject1).eJk = ((gf)localObject1).x("FinalShareCountByType", (String)localObject2, true);
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(35201);
                    return;
                    com.tencent.mm.plugin.selectrecord.b.b.eSz().IH(2L);
                    if (localList.size() > 31)
                    {
                      com.tencent.mm.ui.base.h.c(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(2131766881), "", m.this.dom.Pwc.getContext().getString(2131763227), m.this.dom.Pwc.getContext().getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(233072);
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL to MENU_ID_SEND_RECORD");
                          m.5.a(m.5.this, localList);
                          AppMethodBeat.o(233072);
                        }
                      }, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(233073);
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL onCancel");
                          AppMethodBeat.o(233073);
                        }
                      });
                      AppMethodBeat.o(35201);
                      return;
                    }
                    m.a(m.this, true);
                    if (!com.tencent.mm.ui.chatting.l.a(m.this.dom.Pwc.getContext(), localList, m.c(m.this), m.d(m.this).field_username, m.this))
                    {
                      com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
                      AppMethodBeat.o(35201);
                      return;
                      m.5.a(m.5.this, localList);
                      AppMethodBeat.o(35201);
                      return;
                      if (WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramAnonymousView.getContext()))
                      {
                        com.tencent.mm.plugin.selectrecord.b.b.eSz().IH(3L);
                        if (!com.tencent.mm.ui.chatting.ao.a(m.this.dom.Pwc.getContext(), m.d(m.this), localList, m.c(m.this), IWWAPI.WWAppType.Sxc)) {
                          com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
                        }
                        m.this.gPz();
                        AppMethodBeat.o(35201);
                        return;
                        if (WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramAnonymousView.getContext()))
                        {
                          com.tencent.mm.plugin.selectrecord.b.b.eSz().IH(3L);
                          if (!com.tencent.mm.ui.chatting.ao.a(m.this.dom.Pwc.getContext(), m.d(m.this), localList, m.c(m.this), IWWAPI.WWAppType.Sxd)) {
                            com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
                          }
                          m.this.gPz();
                        }
                      }
                    }
                  }
                }
              };
              ((com.tencent.mm.ui.widget.a.e)localObject).PGl = new e.b()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(233074);
                  com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
                  AppMethodBeat.o(233074);
                }
              };
              ((com.tencent.mm.ui.widget.a.e)localObject).dGm();
            }
          }
        });
        this.Poa.b(4, new View.OnClickListener()
        {
          private void c(cz paramAnonymouscz)
          {
            AppMethodBeat.i(35212);
            Object localObject1 = m.this.gPy();
            Object localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (!ac.bB((ca)((Iterator)localObject2).next()))
              {
                com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(2131759141), "", m.this.dom.Pwc.getContext().getString(2131768713), null);
                AppMethodBeat.o(35212);
                return;
              }
            }
            long l = com.tencent.mm.n.c.aqs();
            localObject2 = com.tencent.mm.ui.chatting.h.Pgg;
            if (com.tencent.mm.ui.chatting.h.i((List)localObject1, l))
            {
              com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(2131759396, new Object[] { Util.getSizeKB(l) }), "", m.this.dom.Pwc.getContext().getString(2131768713), null);
              AppMethodBeat.o(35212);
              return;
            }
            l = com.tencent.mm.n.c.aqu();
            localObject2 = com.tencent.mm.ui.chatting.h.Pgg;
            if (com.tencent.mm.ui.chatting.h.h((List)localObject1, l))
            {
              com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(2131759397, new Object[] { Util.getSizeKB(l) }), "", m.this.dom.Pwc.getContext().getString(2131768713), null);
              AppMethodBeat.o(35212);
              return;
            }
            paramAnonymouscz.dFZ.fragment = m.this.dom.Pwc;
            paramAnonymouscz.dFZ.dGf = 41;
            paramAnonymouscz.dFZ.dGh = new com.tencent.mm.ui.widget.snackbar.a.c()
            {
              public final void bDY()
              {
                AppMethodBeat.i(35205);
                ((com.tencent.mm.ui.chatting.d.b.u)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPW();
                AppMethodBeat.o(35205);
              }
              
              public final void onHide()
              {
                AppMethodBeat.i(35204);
                m.this.gPz();
                AppMethodBeat.o(35204);
              }
              
              public final void onShow()
              {
                AppMethodBeat.i(35203);
                m.this.gPz();
                m.b(m.this).setVisibility(4);
                AppMethodBeat.o(35203);
              }
            };
            EventCenter.instance.publish(paramAnonymouscz);
            int i;
            if (paramAnonymouscz.dGa.ret == 0)
            {
              i = 1;
              l = Util.nowSecond();
              Iterator localIterator = ((List)localObject1).iterator();
              label375:
              while (localIterator.hasNext())
              {
                localObject1 = (ca)localIterator.next();
                if (((ca)localObject1).dOQ())
                {
                  localObject2 = k.b.HD(Util.processXml(((eo)localObject1).field_content));
                  if ((localObject2 != null) && (((k.b)localObject2).type == 5) && (!Util.isNullOrNil(((k.b)localObject2).url))) {
                    if (!((ca)localObject1).gAt()) {
                      break label933;
                    }
                  }
                }
              }
            }
            label933:
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
              com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
              break label375;
              i = 2;
              break;
              if (paramAnonymouscz.dGa.ret == 0)
              {
                if (14 != paramAnonymouscz.dFZ.type)
                {
                  Log.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                  AppMethodBeat.o(35212);
                  return;
                }
                if (paramAnonymouscz.dFZ.dGc == null)
                {
                  Log.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                  AppMethodBeat.o(35212);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.CyF.a(11142, new Object[] { Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyp), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyq), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyr), Integer.valueOf(paramAnonymouscz.dFZ.dGc.xiP), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lys), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyt), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyu), Integer.valueOf(paramAnonymouscz.dFZ.dGc.fileCount), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyv), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyw), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyx), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyy), Integer.valueOf(paramAnonymouscz.dFZ.dGc.Lyz), Integer.valueOf(paramAnonymouscz.dFZ.dGc.LyA), Integer.valueOf(paramAnonymouscz.dFZ.dGc.LyB) });
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
                  m.6.this.gPD();
                  AppMethodBeat.o(35210);
                }
              });
            }
            AppMethodBeat.o(35215);
          }
          
          private static String jn(List<ca> paramAnonymousList)
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
          
          private static void jo(List<ca> paramAnonymousList)
          {
            AppMethodBeat.i(35217);
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              ca localca = (ca)paramAnonymousList.next();
              com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.PcW, a.d.Pdb, localca, 0);
            }
            AppMethodBeat.o(35217);
          }
          
          public final void gPD()
          {
            AppMethodBeat.i(35216);
            m.a(m.this, "");
            final List localList = m.this.gPy();
            if (com.tencent.mm.ui.chatting.k.jj(localList))
            {
              com.tencent.mm.ui.base.h.a(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(2131759224), "", m.this.dom.Pwc.getContext().getString(2131755013), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35216);
              return;
            }
            final cz localcz = new cz();
            Log.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { m.d(m.this).field_username });
            Object localObject1;
            Object localObject2;
            Object localObject3;
            if (localList.size() == 1)
            {
              localObject1 = (ca)localList.get(0);
              if ((localObject1 != null) && ((((ca)localObject1).dOQ()) || (((ca)localObject1).gAt())))
              {
                localObject2 = ad.JX(((eo)localObject1).field_msgSvrId);
                localObject3 = ad.aVe().G((String)localObject2, true);
                ((ad.b)localObject3).l("prePublishId", "msg_" + ((eo)localObject1).field_msgSvrId);
                boolean bool = ((com.tencent.mm.ui.chatting.d.b.d)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP();
                ((ad.b)localObject3).l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a((ca)localObject1, m.c(m.this), bool));
                ((ad.b)localObject3).l("preChatName", m.d(m.this).field_username);
                ((ad.b)localObject3).l("preMsgIndex", Integer.valueOf(0));
                ((ad.b)localObject3).l("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (ad.b)localObject3, (ca)localObject1);
                localcz.dFZ.sessionId = ((String)localObject2);
              }
            }
            if (com.tencent.mm.pluginsdk.model.j.a(m.this.dom.Pwc.getContext(), localcz, m.d(m.this).field_username, localList, true))
            {
              localObject1 = localList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ca)((Iterator)localObject1).next();
                if (((ca)localObject2).dOQ()) {
                  com.tencent.mm.modelstat.b.jmd.c((ca)localObject2, com.tencent.mm.ag.l.t((ca)localObject2));
                } else {
                  com.tencent.mm.modelstat.b.jmd.ac((ca)localObject2);
                }
              }
              c(localcz);
              jo(m.this.gPy());
              AppMethodBeat.o(35216);
              return;
            }
            if (m.this.gPy().size() > 1)
            {
              localObject3 = m.this.dom.Pwc.getContext();
              if (localcz.dFZ.dGe >= 0)
              {
                localObject1 = m.this.dom.Pwc.getContext().getString(2131759223);
                if (localcz.dFZ.dGe < 0) {
                  break label637;
                }
              }
              label637:
              for (localObject2 = m.this.dom.Pwc.getContext().getString(2131757787);; localObject2 = m.this.dom.Pwc.getContext().getString(2131763947))
              {
                com.tencent.mm.ui.base.h.c((Context)localObject3, (String)localObject1, "", (String)localObject2, m.this.dom.Pwc.getContext().getString(2131757785), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(35211);
                    paramAnonymous2DialogInterface = localList.iterator();
                    while (paramAnonymous2DialogInterface.hasNext())
                    {
                      ca localca = (ca)paramAnonymous2DialogInterface.next();
                      if ((!localca.gDo()) && (!localca.gDn()))
                      {
                        if ((localcz.dFZ.type == 14) && (localcz.dFZ.dGb.ppH.size() == 0))
                        {
                          m.this.gPz();
                          AppMethodBeat.o(35211);
                          return;
                        }
                        m.6.a(m.6.this, localcz);
                        m.6.jp(m.this.gPy());
                        AppMethodBeat.o(35211);
                        return;
                      }
                    }
                    AppMethodBeat.o(35211);
                  }
                }, null);
                AppMethodBeat.o(35216);
                return;
                localObject1 = m.this.dom.Pwc.getContext().getString(2131759222);
                break;
              }
            }
            com.tencent.mm.ui.base.h.n(m.this.dom.Pwc.getContext(), localcz.dFZ.dGe, 0);
            AppMethodBeat.o(35216);
          }
          
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35214);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
            localObject1 = m.this.gPy();
            paramAnonymousView = new HashSet();
            Object localObject2 = jn((List)localObject1);
            if (((String)localObject2).equals(m.e(m.this)))
            {
              com.tencent.mm.ui.base.u.makeText(m.this.dom.Pwc.getContext(), m.this.dom.Pwc.getContext().getString(2131759151), 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35214);
              return;
            }
            m.a(m.this, (String)localObject2);
            localObject1 = ((List)localObject1).iterator();
            label435:
            label876:
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ca)((Iterator)localObject1).next();
              Object localObject3;
              Object localObject4;
              com.tencent.mm.i.g localg;
              if (((ca)localObject2).dOQ())
              {
                localObject3 = k.b.HD(((eo)localObject2).field_content);
                if ((localObject3 != null) && (((k.b)localObject3).type == 6) && (!Util.isNullOrNil(((k.b)localObject3).iwN)))
                {
                  localObject4 = com.tencent.mm.pluginsdk.model.app.m.c((ca)localObject2, ((k.b)localObject3).dCK);
                  if ((localObject4 != null) && ((!com.tencent.mm.vfs.s.YS(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath)) || (com.tencent.mm.vfs.s.boW(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen)))
                  {
                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[] { Long.valueOf(((eo)localObject2).field_msgId) });
                    paramAnonymousView.add(Long.valueOf(((eo)localObject2).field_msgId));
                    localg = new com.tencent.mm.i.g();
                    localg.taskName = "task_ChattingMoreComponent";
                    localg.gqy = new g.a()
                    {
                      public final int a(String paramAnonymous2String, int paramAnonymous2Int, com.tencent.mm.i.c paramAnonymous2c, com.tencent.mm.i.d paramAnonymous2d, boolean paramAnonymous2Boolean)
                      {
                        AppMethodBeat.i(35209);
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2c != null))
                        {
                          this.PgB.field_offset = paramAnonymous2c.field_finishedLength;
                          com.tencent.mm.pluginsdk.model.app.ao.cgO().a(this.PgB, new String[0]);
                        }
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2d != null) && (paramAnonymous2d.field_retCode == 0))
                        {
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[] { Long.valueOf(this.iBF.field_msgId) });
                          this.PgB.field_status = 199L;
                          this.PgB.field_offset = this.PgB.field_totalLen;
                          com.tencent.mm.pluginsdk.model.app.ao.cgO().a(this.PgB, new String[0]);
                          this.iBF.setStatus(3);
                          bg.aVF();
                          com.tencent.mm.model.c.aSQ().a(this.iBF.field_msgId, this.iBF);
                          paramAnonymousView.remove(Long.valueOf(this.iBF.field_msgId));
                          m.6.a(m.6.this, paramAnonymousView);
                        }
                        long l;
                        if ((paramAnonymous2Int != 0) || ((paramAnonymous2d != null) && (paramAnonymous2d.field_retCode != 0)))
                        {
                          l = this.iBF.field_msgId;
                          if (paramAnonymous2d != null) {
                            break label283;
                          }
                        }
                        label283:
                        for (int i = 0;; i = paramAnonymous2d.field_retCode)
                        {
                          Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymous2Int), Integer.valueOf(i) });
                          paramAnonymousView.remove(Long.valueOf(this.iBF.field_msgId));
                          m.6.a(m.6.this, paramAnonymousView);
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
                    localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), ((eo)localObject2).field_talker, ((eo)localObject2).field_msgId);
                    localg.field_aesKey = ((k.b)localObject3).aesKey;
                    localg.field_fileType = 19;
                    localg.field_authKey = ((k.b)localObject3).iwT;
                    localg.gqB = ((k.b)localObject3).iwN;
                    if ((localObject4 == null) || (Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath))) {
                      break label774;
                    }
                    localg.field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath;
                    if (!f.baQ().b(localg, -1))
                    {
                      Log.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                      paramAnonymousView.remove(Long.valueOf(((eo)localObject2).field_msgId));
                    }
                  }
                }
              }
              int i;
              if (((ca)localObject2).gAz())
              {
                localObject3 = com.tencent.mm.av.q.bcR().G(((eo)localObject2).field_talker, ((eo)localObject2).field_msgSvrId);
                if (((eo)localObject2).field_isSend != 1) {
                  break label807;
                }
                if (!((com.tencent.mm.av.g)localObject3).bcv()) {
                  break label802;
                }
                i = 1;
                if ((((com.tencent.mm.av.g)localObject3).offset < ((com.tencent.mm.av.g)localObject3).iKP) || (((com.tencent.mm.av.g)localObject3).iKP == 0))
                {
                  Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(((eo)localObject2).field_msgId) });
                  paramAnonymousView.add(Long.valueOf(((eo)localObject2).field_msgId));
                  if (!com.tencent.mm.av.q.bcS().a(((com.tencent.mm.av.g)localObject3).localId, ((eo)localObject2).field_msgId, i, localObject2, 2131231628, new e.a()
                  {
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(35208);
                      Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.iBF.field_msgId) });
                      paramAnonymousView.remove(Long.valueOf(this.iBF.field_msgId));
                      m.6.a(m.6.this, paramAnonymousView);
                      AppMethodBeat.o(35208);
                    }
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, com.tencent.mm.ak.q paramAnonymous2q) {}
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, String paramAnonymous2String, com.tencent.mm.ak.q paramAnonymous2q)
                    {
                      AppMethodBeat.i(35207);
                      if ((paramAnonymous2Int3 == 0) && (paramAnonymous2Int4 == 0)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.iBF.field_msgId), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
                        paramAnonymousView.remove(Long.valueOf(this.iBF.field_msgId));
                        m.6.a(m.6.this, paramAnonymousView);
                        AppMethodBeat.o(35207);
                        return;
                      }
                    }
                  })) {
                    paramAnonymousView.remove(Long.valueOf(((eo)localObject2).field_msgId));
                  }
                }
              }
              if ((((ca)localObject2).cWJ()) || (((ca)localObject2).cWL()))
              {
                localObject3 = com.tencent.mm.modelvideo.u.QN(((eo)localObject2).field_imgPath);
                if ((localObject3 != null) && (((com.tencent.mm.modelvideo.s)localObject3).status != 199))
                {
                  paramAnonymousView.add(Long.valueOf(((eo)localObject2).field_msgId));
                  localObject4 = new t.a()
                  {
                    public final void a(t.a.a paramAnonymous2a)
                    {
                      AppMethodBeat.i(35206);
                      if (this.iBF.field_imgPath.equals(paramAnonymous2a.fileName))
                      {
                        com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.QN(paramAnonymous2a.fileName);
                        if ((locals == null) || (!locals.bhy())) {
                          break label114;
                        }
                        Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.iBF.field_msgId), paramAnonymous2a.fileName });
                      }
                      for (;;)
                      {
                        com.tencent.mm.modelvideo.o.bhj().a(this);
                        paramAnonymousView.remove(Long.valueOf(this.iBF.field_msgId));
                        m.6.a(m.6.this, paramAnonymousView);
                        AppMethodBeat.o(35206);
                        return;
                        label114:
                        Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.iBF.field_msgId), paramAnonymous2a.fileName });
                      }
                    }
                  };
                  com.tencent.mm.modelvideo.o.bhj().a((t.a)localObject4, Looper.getMainLooper());
                  Log.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(((eo)localObject2).field_msgId), ((eo)localObject2).field_imgPath });
                  if (((com.tencent.mm.modelvideo.s)localObject3).bhx()) {
                    Log.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                  }
                  for (i = com.tencent.mm.modelvideo.u.QT(((eo)localObject2).field_imgPath);; i = com.tencent.mm.modelvideo.u.QI(((eo)localObject2).field_imgPath))
                  {
                    if (i == 0) {
                      break label876;
                    }
                    paramAnonymousView.remove(Long.valueOf(((eo)localObject2).field_msgId));
                    break;
                    bg.aVF();
                    localg.field_fullpath = com.tencent.mm.pluginsdk.model.app.m.aB(com.tencent.mm.model.c.aTg(), ((k.b)localObject3).title, ((k.b)localObject3).iwJ);
                    break label435;
                    i = 0;
                    break label513;
                    if (!((com.tencent.mm.av.g)localObject3).bcv())
                    {
                      i = 0;
                      break label513;
                    }
                    localObject4 = com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject3);
                    if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.av.q.bcR().o(((com.tencent.mm.av.g)localObject4).iXm, "", "")))
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
        this.Dog = AnimationUtils.loadAnimation(this.dom.Pwc.getContext(), 2130772132);
        ((com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).i(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35195);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            localObject = (com.tencent.mm.ui.chatting.d.b.k)m.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if (((com.tencent.mm.ui.chatting.d.b.k)localObject).Nu(((Long)paramAnonymousView.getTag()).longValue()))
            {
              int i = ((com.tencent.mm.ui.chatting.d.b.k)localObject).eGR();
              ((am)m.this.dom.bh(am.class)).gQW();
              m.a(m.this).gXP();
              m.b(m.this).setVisibility(0);
              m.b(m.this).amj(i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35195);
          }
        });
        break;
        this.gzP = new com.tencent.mm.ui.tools.s((byte)0);
      }
    }
  }
  
  public final void bW(ca paramca)
  {
    AppMethodBeat.i(35226);
    if (paramca == null)
    {
      Log.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
      AppMethodBeat.o(35226);
      return;
    }
    com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    if (localk.Nu(paramca.field_msgId))
    {
      int i = localk.eGR();
      this.Poa.amj(i);
      this.Poa.setVisibility(0);
      this.gzP.gXP();
    }
    AppMethodBeat.o(35226);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35231);
    gPz();
    AppMethodBeat.o(35231);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(169865);
    super.gOK();
    if (this.PlM) {
      gPz();
    }
    AppMethodBeat.o(169865);
  }
  
  public final boolean gPB()
  {
    return this.PlM;
  }
  
  public final void gPC()
  {
    AppMethodBeat.i(35229);
    if (this.gzP != null)
    {
      this.gzP.gXP();
      this.gzP.Qwi = null;
    }
    AppMethodBeat.o(35229);
  }
  
  public final List<ca> gPy()
  {
    AppMethodBeat.i(169864);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOs().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Log.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[] { Long.valueOf(l) });
      bg.aVF();
      localLinkedList.add(com.tencent.mm.model.c.aSQ().Hb(l));
    }
    Collections.sort(localLinkedList, new Comparator() {});
    AppMethodBeat.o(169864);
    return localLinkedList;
  }
  
  public final void gPz()
  {
    AppMethodBeat.i(35227);
    this.dom.Pwc.getController().addSearchMenu(false, this.gzP);
    if (this.Poa != null) {
      this.Poa.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).cVM();
    ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gPd();
    ((am)this.dom.bh(am.class)).gQW();
    this.PlM = false;
    gPA();
    ((p)this.dom.bh(p.class)).fjK();
    ((com.tencent.mm.ui.chatting.d.b.u)this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPX();
    this.dom.hideVKB();
    com.tencent.mm.ui.chatting.l.gNy();
    AppMethodBeat.o(35227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.m
 * JD-Core Version:    0.7.0.1
 */