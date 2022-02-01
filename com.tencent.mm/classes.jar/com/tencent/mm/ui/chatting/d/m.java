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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import com.tencent.mm.ui.widget.a.e.b;
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

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.l.class)
public class m
  extends a
  implements com.tencent.mm.ah.z, com.tencent.mm.ui.chatting.d.b.l
{
  public static bf KcB;
  private boolean JSi;
  private String JYv = "";
  private boolean Kap = false;
  private ChattingFooterMoreBtnBar KcC;
  private boolean KcD = true;
  private com.tencent.mm.storage.an dAu;
  private r fUI;
  private boolean hasInit = false;
  private Animation zjp;
  
  static
  {
    AppMethodBeat.i(35233);
    KcB = new bf(5, "MicroMsg.ChattingMoreBtnBarHelper");
    AppMethodBeat.o(35233);
  }
  
  private void fHu()
  {
    AppMethodBeat.i(35228);
    if (this.Kap) {
      this.cXJ.showOptionMenu(false);
    }
    for (;;)
    {
      ((at)this.cXJ.bh(at.class)).fJo();
      AppMethodBeat.o(35228);
      return;
      ((y)this.cXJ.bh(y.class)).fIf();
    }
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(35230);
    fHt();
    AppMethodBeat.o(35230);
  }
  
  public final boolean azv()
  {
    return this.KcD;
  }
  
  public final boolean azw()
  {
    return false;
  }
  
  public final boolean azx()
  {
    return true;
  }
  
  public final void b(z.a parama) {}
  
  public final void bF(bv parambv)
  {
    AppMethodBeat.i(35225);
    if (this.hasInit)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
      this.dAu = this.cXJ.Cqh;
      if ((!this.cXJ.fJB()) && (!((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK())) {
        break label583;
      }
    }
    label583:
    for (boolean bool = true;; bool = false)
    {
      this.JSi = bool;
      this.KcC.fFK();
      this.cXJ.Kkd.getController().addSearchMenu(true, this.fUI);
      if (this.KcC != null)
      {
        this.KcC.startAnimation(this.zjp);
        this.KcC.setVisibility(0);
      }
      this.Kap = true;
      ((aj)this.cXJ.bh(aj.class)).fIM();
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      localk.fGo();
      localk.fGn();
      localk.Eq(parambv.field_msgId);
      int i = localk.dGd();
      this.KcC.adz(i);
      ((com.tencent.mm.ui.chatting.d.b.o)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.o.class)).fHD();
      this.cXJ.hideVKB();
      fHu();
      ((com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fHO();
      com.tencent.mm.plugin.report.service.g.yxI.f(10811, new Object[] { Integer.valueOf(1) });
      if (this.dAu.fug())
      {
        parambv = this.cXJ;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[] { Integer.valueOf(2131302248) });
        parambv.Kke.removeOptionMenu(2131302248);
      }
      ((com.tencent.mm.ui.chatting.d.b.z)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.z.class)).fIq();
      AppMethodBeat.o(35225);
      return;
      this.hasInit = true;
      if (this.KcC == null)
      {
        ((ViewStub)this.cXJ.findViewById(2131306440)).inflate();
        this.KcC = ((ChattingFooterMoreBtnBar)this.cXJ.findViewById(2131298096));
      }
      if (((aj)this.cXJ.bh(aj.class)).fIT())
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        if (this.fUI == null) {}
      }
      for (this.fUI.Lhk = null;; this.fUI.Lhk = new r.b()
          {
            String KcN = null;
            
            public final boolean JO(String paramAnonymousString)
            {
              return false;
            }
            
            public final void JP(String paramAnonymousString)
            {
              AppMethodBeat.i(35222);
              com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
              Object localObject = (aj)m.this.cXJ.bh(aj.class);
              if (bu.isNullOrNil(paramAnonymousString)) {
                if (((aj)localObject).fIT())
                {
                  if (((aj)localObject).fIO() != null) {
                    ((aj)localObject).fIO().JN("");
                  }
                  ((aj)localObject).adT(-1);
                }
              }
              for (;;)
              {
                this.KcN = paramAnonymousString;
                AppMethodBeat.o(35222);
                return;
                if (m.f(m.this))
                {
                  if (this.KcN != null)
                  {
                    ((aj)localObject).fIM();
                    m.b(m.this).setVisibility(0);
                    localObject = (com.tencent.mm.ui.chatting.d.b.k)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
                    m.b(m.this).adz(((com.tencent.mm.ui.chatting.d.b.k)localObject).dGd());
                  }
                }
                else
                {
                  ((aj)localObject).fIM();
                  m.b(m.this).setVisibility(8);
                  continue;
                  com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                  m.b(m.this).setVisibility(8);
                  ((aj)localObject).fIL();
                  if (((aj)localObject).fIO() != null) {
                    ((aj)localObject).fIO().JN(paramAnonymousString);
                  }
                }
              }
            }
            
            public final void aSL()
            {
              AppMethodBeat.i(35223);
              com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
              com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
              if (localk.isInEditMode())
              {
                ((aj)m.this.cXJ.bh(aj.class)).fIM();
                m.b(m.this).setVisibility(0);
                m.b(m.this).adz(localk.dGd());
              }
              m.this.cXJ.Kkd.getController().supportInvalidateOptionsMenu();
              AppMethodBeat.o(35223);
            }
            
            public final void aSM()
            {
              AppMethodBeat.i(35224);
              com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 21L, 1L, true);
              if (((com.tencent.mm.ui.chatting.d.b.k)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode())
              {
                ((aj)m.this.cXJ.bh(aj.class)).fIL();
                m.b(m.this).setVisibility(8);
              }
              AppMethodBeat.o(35224);
            }
            
            public final void aSN() {}
            
            public final void aSO() {}
          })
      {
        this.KcC.b(3, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35197);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.k)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if (paramAnonymousView.dGd() == 0)
            {
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35197);
              return;
            }
            localObject = m.this.cXJ.Kkd.getContext();
            com.tencent.mm.ui.base.h.a((Context)localObject, ((Context)localObject).getString(2131757553), "", ((Context)localObject).getString(2131758038), ((Context)localObject).getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(35196);
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                paramAnonymous2DialogInterface = (Long[])paramAnonymousView.fGm().toArray(new Long[0]);
                Arrays.sort(paramAnonymous2DialogInterface, new Comparator() {});
                ArrayList localArrayList = new ArrayList();
                SparseArray localSparseArray = paramAnonymousView.fGk();
                int i = localSparseArray.size();
                int n = paramAnonymous2DialogInterface.length;
                int j = 0;
                int k = i;
                if (j < n)
                {
                  Object localObject = paramAnonymous2DialogInterface[j];
                  bv localbv;
                  do
                  {
                    paramAnonymous2Int = i - 1;
                    i = paramAnonymous2Int;
                    m = k;
                    if (paramAnonymous2Int < 0) {
                      break label217;
                    }
                    localbv = (bv)localSparseArray.get(paramAnonymous2Int);
                    if (localbv.field_msgId <= localObject.longValue()) {
                      break;
                    }
                    i = paramAnonymous2Int;
                  } while (localbv.fvF());
                  if (localbv.field_msgId == localObject.longValue()) {}
                  for (int m = 1;; m = 0)
                  {
                    i = paramAnonymous2Int;
                    if (m == 0) {
                      break label230;
                    }
                    i = k - 1;
                    while (i > paramAnonymous2Int)
                    {
                      localArrayList.add(Long.valueOf(((bv)localSparseArray.get(i)).field_msgId));
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
                    } while (((bv)localSparseArray.get(paramAnonymous2Int)).field_msgId != localObject.longValue());
                  }
                }
                com.tencent.mm.ui.chatting.j.a(this.val$context, paramAnonymousView.fGm(), m.this);
                if (localArrayList.size() > 0) {
                  com.tencent.mm.ui.chatting.j.a(this.val$context, new CopyOnWriteArraySet(localArrayList), m.this);
                }
                m.this.fHt();
                AppMethodBeat.o(35196);
              }
            }, null, 2131099904);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35197);
          }
        });
        this.KcC.b(2, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35198);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (((com.tencent.mm.ui.chatting.d.b.k)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).dGd() == 0)
            {
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35198);
              return;
            }
            com.tencent.mm.ui.chatting.n.a(m.this.cXJ, m.this.fHs(), m.c(m.this), m.this, m.d(m.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35198);
          }
        });
        this.KcC.b(1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35199);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.k)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if ((paramAnonymousView == null) || (paramAnonymousView.dGd() == 0))
            {
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            paramAnonymousView = m.this.fHs();
            if (com.tencent.mm.ui.chatting.k.ig(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(m.this.cXJ.Kkd.getContext(), m.this.cXJ.Kkd.getContext().getString(2131757937), "", m.this.cXJ.Kkd.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.k.ih(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(m.this.cXJ.Kkd.getContext(), m.this.cXJ.Kkd.getContext().getString(2131757938), "", m.this.cXJ.Kkd.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.k.jdMethod_if(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(m.this.cXJ.Kkd.getContext(), m.this.cXJ.Kkd.getContext().getString(2131757939), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.o.a(m.this.cXJ, paramAnonymousView, m.d(m.this))) {
              m.this.fHt();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35199);
          }
        });
        this.KcC.b(0, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35202);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (((com.tencent.mm.ui.chatting.d.b.k)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).dGd() == 0)
            {
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
            }
            if (((x.Ao(m.d(m.this).field_username)) && (!com.tencent.mm.al.g.vz(m.d(m.this).field_username))) || (x.Ba(m.d(m.this).field_username)))
            {
              m.a(m.this, true);
              com.tencent.mm.ui.chatting.l.a(m.this.cXJ.Kkd.getContext(), m.this.fHs(), m.c(m.this), m.d(m.this).field_username, m.this);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
              com.tencent.mm.plugin.selectrecord.b.b.dQz();
              paramAnonymousView = new com.tencent.mm.ui.widget.a.e(m.this.cXJ.Kkd.getContext(), 1, false);
              paramAnonymousView.LfS = new n.d()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(35200);
                  paramAnonymous2l.jM(0, 2131761385);
                  paramAnonymous2l.jM(1, 2131761386);
                  if (com.tencent.mm.ui.chatting.an.dK(m.this.cXJ.Kkd.getContext())) {
                    paramAnonymous2l.d(2, m.this.cXJ.Kkd.getContext().getString(2131761387, new Object[] { com.tencent.mm.ui.chatting.an.kr(m.this.cXJ.Kkd.getContext()) }));
                  }
                  AppMethodBeat.o(35200);
                }
              };
              paramAnonymousView.LfT = new n.e()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(35201);
                  final List localList = m.this.fHs();
                  Object localObject1 = com.tencent.mm.plugin.selectrecord.b.b.dQy();
                  long l = localList.size();
                  ((com.tencent.mm.plugin.selectrecord.b.b)localObject1).ySp.ehq = l;
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
                    Object localObject3 = (bv)((Iterator)localObject2).next();
                    switch (((bv)localObject3).getType())
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
                      localObject3 = k.b.zb(((ei)localObject3).field_content);
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
                  localObject1 = ((com.tencent.mm.plugin.selectrecord.b.b)localObject1).ySp;
                  ((dk)localObject1).ehr = ((dk)localObject1).t("FinalShareCountByType", (String)localObject2, true);
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(35201);
                    return;
                    com.tencent.mm.plugin.selectrecord.b.b.dQy().zD(2L);
                    if (localList.size() > 31)
                    {
                      com.tencent.mm.ui.base.h.e(m.this.cXJ.Kkd.getContext(), m.this.cXJ.Kkd.getContext().getString(2131767287), "", m.this.cXJ.Kkd.getContext().getString(2131761386), m.this.cXJ.Kkd.getContext().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(187312);
                          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL to MENU_ID_SEND_RECORD");
                          m.5.a(m.5.this, localList);
                          AppMethodBeat.o(187312);
                        }
                      }, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(187313);
                          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "MENU_ID_SEND_NORMAL onCancel");
                          AppMethodBeat.o(187313);
                        }
                      });
                      AppMethodBeat.o(35201);
                      return;
                    }
                    m.a(m.this, true);
                    if (!com.tencent.mm.ui.chatting.l.a(m.this.cXJ.Kkd.getContext(), localList, m.c(m.this), m.d(m.this).field_username, m.this))
                    {
                      com.tencent.mm.plugin.selectrecord.b.b.dQy().dQA();
                      AppMethodBeat.o(35201);
                      return;
                      m.5.a(m.5.this, localList);
                      AppMethodBeat.o(35201);
                      return;
                      com.tencent.mm.plugin.selectrecord.b.b.dQy().zD(3L);
                      if (!com.tencent.mm.ui.chatting.an.a(m.this.cXJ.Kkd.getContext(), m.d(m.this), localList, m.c(m.this))) {
                        com.tencent.mm.plugin.selectrecord.b.b.dQy().dQA();
                      }
                      m.this.fHt();
                    }
                  }
                }
              };
              paramAnonymousView.KtV = new e.b()
              {
                public final void onDismiss()
                {
                  AppMethodBeat.i(187314);
                  com.tencent.mm.plugin.selectrecord.b.b.dQy().dQA();
                  AppMethodBeat.o(187314);
                }
              };
              paramAnonymousView.cPF();
            }
          }
        });
        this.KcC.b(4, new View.OnClickListener()
        {
          private void c(cw paramAnonymouscw)
          {
            AppMethodBeat.i(35212);
            Object localObject1 = m.this.fHs();
            Object localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (!ac.bm((bv)((Iterator)localObject2).next()))
              {
                com.tencent.mm.ui.base.h.a(m.this.cXJ.Kkd.getContext(), m.this.cXJ.Kkd.getContext().getString(2131766957), "", m.this.cXJ.Kkd.getContext().getString(2131766205), null);
                AppMethodBeat.o(35212);
                return;
              }
            }
            long l = com.tencent.mm.n.b.act();
            localObject2 = com.tencent.mm.ui.chatting.h.JUT;
            if (com.tencent.mm.ui.chatting.h.h((List)localObject1, l))
            {
              com.tencent.mm.ui.base.h.a(m.this.cXJ.Kkd.getContext(), m.this.cXJ.Kkd.getContext().getString(2131767058, new Object[] { bu.sL(l) }), "", m.this.cXJ.Kkd.getContext().getString(2131766205), null);
              AppMethodBeat.o(35212);
              return;
            }
            l = com.tencent.mm.n.b.acv();
            localObject2 = com.tencent.mm.ui.chatting.h.JUT;
            if (com.tencent.mm.ui.chatting.h.g((List)localObject1, l))
            {
              com.tencent.mm.ui.base.h.a(m.this.cXJ.Kkd.getContext(), m.this.cXJ.Kkd.getContext().getString(2131759065, new Object[] { bu.sL(l) }), "", m.this.cXJ.Kkd.getContext().getString(2131766205), null);
              AppMethodBeat.o(35212);
              return;
            }
            paramAnonymouscw.doL.fragment = m.this.cXJ.Kkd;
            paramAnonymouscw.doL.doR = 41;
            paramAnonymouscw.doL.doT = new com.tencent.mm.ui.widget.snackbar.a.c()
            {
              public final void biX()
              {
                AppMethodBeat.i(35205);
                ((com.tencent.mm.ui.chatting.d.b.s)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fHN();
                AppMethodBeat.o(35205);
              }
              
              public final void onHide()
              {
                AppMethodBeat.i(35204);
                m.this.fHt();
                AppMethodBeat.o(35204);
              }
              
              public final void onShow()
              {
                AppMethodBeat.i(35203);
                m.this.fHt();
                m.b(m.this).setVisibility(4);
                AppMethodBeat.o(35203);
              }
            };
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymouscw);
            int i;
            if (paramAnonymouscw.doM.ret == 0)
            {
              i = 1;
              l = bu.aRi();
              Iterator localIterator = ((List)localObject1).iterator();
              label375:
              while (localIterator.hasNext())
              {
                localObject1 = (bv)localIterator.next();
                if (((bv)localObject1).cVH())
                {
                  localObject2 = k.b.zb(bu.aSA(((ei)localObject1).field_content));
                  if ((localObject2 != null) && (((k.b)localObject2).type == 5) && (!bu.isNullOrNil(((k.b)localObject2).url))) {
                    if (!((bv)localObject1).fta()) {
                      break label933;
                    }
                  }
                }
              }
            }
            label933:
            for (int j = 1;; j = 2)
            {
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((k.b)localObject2).url, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(1) });
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
                  com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", localUnsupportedEncodingException, "", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
              break label375;
              i = 2;
              break;
              if (paramAnonymouscw.doM.ret == 0)
              {
                if (14 != paramAnonymouscw.doL.type)
                {
                  com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                  AppMethodBeat.o(35212);
                  return;
                }
                if (paramAnonymouscw.doL.doO == null)
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                  AppMethodBeat.o(35212);
                  return;
                }
                com.tencent.mm.plugin.report.service.g.yxI.f(11142, new Object[] { Integer.valueOf(paramAnonymouscw.doL.doO.GCt), Integer.valueOf(paramAnonymouscw.doL.doO.GCu), Integer.valueOf(paramAnonymouscw.doL.doO.GCv), Integer.valueOf(paramAnonymouscw.doL.doO.tRD), Integer.valueOf(paramAnonymouscw.doL.doO.GCw), Integer.valueOf(paramAnonymouscw.doL.doO.GCx), Integer.valueOf(paramAnonymouscw.doL.doO.GCy), Integer.valueOf(paramAnonymouscw.doL.doO.fileCount), Integer.valueOf(paramAnonymouscw.doL.doO.GCz), Integer.valueOf(paramAnonymouscw.doL.doO.GCA), Integer.valueOf(paramAnonymouscw.doL.doO.GCB), Integer.valueOf(paramAnonymouscw.doL.doO.GCC), Integer.valueOf(paramAnonymouscw.doL.doO.GCD), Integer.valueOf(paramAnonymouscw.doL.doO.GCE), Integer.valueOf(paramAnonymouscw.doL.doO.GCF) });
              }
              AppMethodBeat.o(35212);
              return;
            }
          }
          
          private void h(HashSet<Long> paramAnonymousHashSet)
          {
            AppMethodBeat.i(35215);
            if (paramAnonymousHashSet.isEmpty()) {
              new aq(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(35210);
                  m.6.this.fHx();
                  AppMethodBeat.o(35210);
                }
              });
            }
            AppMethodBeat.o(35215);
          }
          
          private static String il(List<bv> paramAnonymousList)
          {
            AppMethodBeat.i(35213);
            StringBuffer localStringBuffer = new StringBuffer();
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext()) {
              localStringBuffer.append(((bv)paramAnonymousList.next()).field_msgId);
            }
            paramAnonymousList = localStringBuffer.toString();
            AppMethodBeat.o(35213);
            return paramAnonymousList;
          }
          
          private static void im(List<bv> paramAnonymousList)
          {
            AppMethodBeat.i(35217);
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              bv localbv = (bv)paramAnonymousList.next();
              com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.JRS, a.d.JRX, localbv, 0);
            }
            AppMethodBeat.o(35217);
          }
          
          public final void fHx()
          {
            AppMethodBeat.i(35216);
            m.a(m.this, "");
            final List localList = m.this.fHs();
            if (com.tencent.mm.ui.chatting.k.ig(localList))
            {
              com.tencent.mm.ui.base.h.a(m.this.cXJ.Kkd.getContext(), m.this.cXJ.Kkd.getContext().getString(2131758900), "", m.this.cXJ.Kkd.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35216);
              return;
            }
            final cw localcw = new cw();
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { m.d(m.this).field_username });
            Object localObject1;
            Object localObject2;
            Object localObject3;
            if (localList.size() == 1)
            {
              localObject1 = (bv)localList.get(0);
              if ((localObject1 != null) && ((((bv)localObject1).cVH()) || (((bv)localObject1).fta())))
              {
                localObject2 = com.tencent.mm.model.z.Br(((ei)localObject1).field_msgSvrId);
                localObject3 = com.tencent.mm.model.z.aBG().F((String)localObject2, true);
                ((z.b)localObject3).k("prePublishId", "msg_" + ((ei)localObject1).field_msgSvrId);
                boolean bool = ((com.tencent.mm.ui.chatting.d.b.d)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ();
                ((z.b)localObject3).k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a((bv)localObject1, m.c(m.this), bool));
                ((z.b)localObject3).k("preChatName", m.d(m.this).field_username);
                ((z.b)localObject3).k("preMsgIndex", Integer.valueOf(0));
                ((z.b)localObject3).k("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (z.b)localObject3, (bv)localObject1);
                localcw.doL.sessionId = ((String)localObject2);
              }
            }
            if (com.tencent.mm.pluginsdk.model.i.a(m.this.cXJ.Kkd.getContext(), localcw, m.d(m.this).field_username, localList, true))
            {
              localObject1 = localList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (bv)((Iterator)localObject1).next();
                if (((bv)localObject2).cVH()) {
                  com.tencent.mm.modelstat.b.iqT.c((bv)localObject2, com.tencent.mm.ah.l.r((bv)localObject2));
                } else {
                  com.tencent.mm.modelstat.b.iqT.S((bv)localObject2);
                }
              }
              c(localcw);
              im(m.this.fHs());
              AppMethodBeat.o(35216);
              return;
            }
            if (m.this.fHs().size() > 1)
            {
              localObject3 = m.this.cXJ.Kkd.getContext();
              if (localcw.doL.doQ >= 0)
              {
                localObject1 = m.this.cXJ.Kkd.getContext().getString(2131758899);
                if (localcw.doL.doQ < 0) {
                  break label637;
                }
              }
              label637:
              for (localObject2 = m.this.cXJ.Kkd.getContext().getString(2131757560);; localObject2 = m.this.cXJ.Kkd.getContext().getString(2131761941))
              {
                com.tencent.mm.ui.base.h.e((Context)localObject3, (String)localObject1, "", (String)localObject2, m.this.cXJ.Kkd.getContext().getString(2131757558), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(35211);
                    paramAnonymous2DialogInterface = localList.iterator();
                    while (paramAnonymous2DialogInterface.hasNext())
                    {
                      bv localbv = (bv)paramAnonymous2DialogInterface.next();
                      if ((!localbv.fvH()) && (!localbv.fvG()))
                      {
                        if ((localcw.doL.type == 14) && (localcw.doL.doN.oeJ.size() == 0))
                        {
                          m.this.fHt();
                          AppMethodBeat.o(35211);
                          return;
                        }
                        m.6.a(m.6.this, localcw);
                        m.6.in(m.this.fHs());
                        AppMethodBeat.o(35211);
                        return;
                      }
                    }
                    AppMethodBeat.o(35211);
                  }
                }, null);
                AppMethodBeat.o(35216);
                return;
                localObject1 = m.this.cXJ.Kkd.getContext().getString(2131758898);
                break;
              }
            }
            com.tencent.mm.ui.base.h.l(m.this.cXJ.Kkd.getContext(), localcw.doL.doQ, 0);
            AppMethodBeat.o(35216);
          }
          
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35214);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
            localObject1 = m.this.fHs();
            paramAnonymousView = new HashSet();
            Object localObject2 = il((List)localObject1);
            if (((String)localObject2).equals(m.e(m.this)))
            {
              com.tencent.mm.ui.base.t.makeText(m.this.cXJ.Kkd.getContext(), m.this.cXJ.Kkd.getContext().getString(2131758828), 0).show();
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
              localObject2 = (bv)((Iterator)localObject1).next();
              Object localObject3;
              Object localObject4;
              com.tencent.mm.i.g localg;
              if (((bv)localObject2).cVH())
              {
                localObject3 = k.b.zb(((ei)localObject2).field_content);
                if ((localObject3 != null) && (((k.b)localObject3).type == 6) && (!bu.isNullOrNil(((k.b)localObject3).hCI)))
                {
                  localObject4 = com.tencent.mm.pluginsdk.model.app.m.c((bv)localObject2, ((k.b)localObject3).dlu);
                  if ((localObject4 != null) && ((!com.tencent.mm.vfs.o.fB(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath)) || (com.tencent.mm.vfs.o.aZR(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen)))
                  {
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[] { Long.valueOf(((ei)localObject2).field_msgId) });
                    paramAnonymousView.add(Long.valueOf(((ei)localObject2).field_msgId));
                    localg = new com.tencent.mm.i.g();
                    localg.fLl = "task_ChattingMoreComponent";
                    localg.fLm = new g.a()
                    {
                      public final int a(String paramAnonymous2String, int paramAnonymous2Int, com.tencent.mm.i.c paramAnonymous2c, com.tencent.mm.i.d paramAnonymous2d, boolean paramAnonymous2Boolean)
                      {
                        AppMethodBeat.i(35209);
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2c != null))
                        {
                          this.JVp.field_offset = paramAnonymous2c.field_finishedLength;
                          ao.bJV().a(this.JVp, new String[0]);
                        }
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2d != null) && (paramAnonymous2d.field_retCode == 0))
                        {
                          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[] { Long.valueOf(this.hHv.field_msgId) });
                          this.JVp.field_status = 199L;
                          this.JVp.field_offset = this.JVp.field_totalLen;
                          ao.bJV().a(this.JVp, new String[0]);
                          this.hHv.setStatus(3);
                          bc.aCg();
                          com.tencent.mm.model.c.azI().a(this.hHv.field_msgId, this.hHv);
                          paramAnonymousView.remove(Long.valueOf(this.hHv.field_msgId));
                          m.6.a(m.6.this, paramAnonymousView);
                        }
                        long l;
                        if ((paramAnonymous2Int != 0) || ((paramAnonymous2d != null) && (paramAnonymous2d.field_retCode != 0)))
                        {
                          l = this.hHv.field_msgId;
                          if (paramAnonymous2d != null) {
                            break label283;
                          }
                        }
                        label283:
                        for (int i = 0;; i = paramAnonymous2d.field_retCode)
                        {
                          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymous2Int), Integer.valueOf(i) });
                          paramAnonymousView.remove(Long.valueOf(this.hHv.field_msgId));
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
                    localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", bu.fpO(), ((ei)localObject2).field_talker, ((ei)localObject2).field_msgId);
                    localg.field_aesKey = ((k.b)localObject3).gmb;
                    localg.field_fileType = 19;
                    localg.field_authKey = ((k.b)localObject3).hCO;
                    localg.fLp = ((k.b)localObject3).hCI;
                    if ((localObject4 == null) || (bu.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath))) {
                      break label774;
                    }
                    localg.field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath;
                    if (!f.aGZ().b(localg, -1))
                    {
                      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                      paramAnonymousView.remove(Long.valueOf(((ei)localObject2).field_msgId));
                    }
                  }
                }
              }
              int i;
              if (((bv)localObject2).ftg())
              {
                localObject3 = q.aIX().F(((ei)localObject2).field_talker, ((ei)localObject2).field_msgSvrId);
                if (((ei)localObject2).field_isSend != 1) {
                  break label807;
                }
                if (!((com.tencent.mm.av.g)localObject3).aIB()) {
                  break label802;
                }
                i = 1;
                if ((((com.tencent.mm.av.g)localObject3).offset < ((com.tencent.mm.av.g)localObject3).hPI) || (((com.tencent.mm.av.g)localObject3).hPI == 0))
                {
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(((ei)localObject2).field_msgId) });
                  paramAnonymousView.add(Long.valueOf(((ei)localObject2).field_msgId));
                  if (!q.aIY().a(((com.tencent.mm.av.g)localObject3).doE, ((ei)localObject2).field_msgId, i, localObject2, 2131231564, new e.a()
                  {
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(35208);
                      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.hHv.field_msgId) });
                      paramAnonymousView.remove(Long.valueOf(this.hHv.field_msgId));
                      m.6.a(m.6.this, paramAnonymousView);
                      AppMethodBeat.o(35208);
                    }
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, com.tencent.mm.ak.n paramAnonymous2n) {}
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
                    {
                      AppMethodBeat.i(35207);
                      if ((paramAnonymous2Int3 == 0) && (paramAnonymous2Int4 == 0)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.hHv.field_msgId), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
                        paramAnonymousView.remove(Long.valueOf(this.hHv.field_msgId));
                        m.6.a(m.6.this, paramAnonymousView);
                        AppMethodBeat.o(35207);
                        return;
                      }
                    }
                  })) {
                    paramAnonymousView.remove(Long.valueOf(((ei)localObject2).field_msgId));
                  }
                }
              }
              if ((((bv)localObject2).cyG()) || (((bv)localObject2).cyI()))
              {
                localObject3 = u.Ia(((ei)localObject2).field_imgPath);
                if ((localObject3 != null) && (((com.tencent.mm.modelvideo.s)localObject3).status != 199))
                {
                  paramAnonymousView.add(Long.valueOf(((ei)localObject2).field_msgId));
                  localObject4 = new t.a()
                  {
                    public final void a(t.a.a paramAnonymous2a)
                    {
                      AppMethodBeat.i(35206);
                      if (this.hHv.field_imgPath.equals(paramAnonymous2a.fileName))
                      {
                        com.tencent.mm.modelvideo.s locals = u.Ia(paramAnonymous2a.fileName);
                        if ((locals == null) || (!locals.aNw())) {
                          break label114;
                        }
                        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.hHv.field_msgId), paramAnonymous2a.fileName });
                      }
                      for (;;)
                      {
                        com.tencent.mm.modelvideo.o.aNh().a(this);
                        paramAnonymousView.remove(Long.valueOf(this.hHv.field_msgId));
                        m.6.a(m.6.this, paramAnonymousView);
                        AppMethodBeat.o(35206);
                        return;
                        label114:
                        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.hHv.field_msgId), paramAnonymous2a.fileName });
                      }
                    }
                  };
                  com.tencent.mm.modelvideo.o.aNh().a((t.a)localObject4, Looper.getMainLooper());
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(((ei)localObject2).field_msgId), ((ei)localObject2).field_imgPath });
                  if (((com.tencent.mm.modelvideo.s)localObject3).aNv()) {
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                  }
                  for (i = u.Ih(((ei)localObject2).field_imgPath);; i = u.HV(((ei)localObject2).field_imgPath))
                  {
                    if (i == 0) {
                      break label876;
                    }
                    paramAnonymousView.remove(Long.valueOf(((ei)localObject2).field_msgId));
                    break;
                    bc.aCg();
                    localg.field_fullpath = com.tencent.mm.pluginsdk.model.app.m.aq(com.tencent.mm.model.c.azY(), ((k.b)localObject3).title, ((k.b)localObject3).hCD);
                    break label435;
                    i = 0;
                    break label513;
                    if (!((com.tencent.mm.av.g)localObject3).aIB())
                    {
                      i = 0;
                      break label513;
                    }
                    localObject4 = com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject3);
                    if (!com.tencent.mm.vfs.o.fB(q.aIX().o(((com.tencent.mm.av.g)localObject4).ico, "", "")))
                    {
                      i = 0;
                      break label513;
                    }
                    i = 1;
                    break label513;
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                  }
                }
              }
            }
            label513:
            label774:
            label802:
            label807:
            h(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35214);
          }
        });
        this.zjp = AnimationUtils.loadAnimation(this.cXJ.Kkd.getContext(), 2130772108);
        ((com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).e(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35195);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            localObject = (com.tencent.mm.ui.chatting.d.b.k)m.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if (((com.tencent.mm.ui.chatting.d.b.k)localObject).Eq(((Long)paramAnonymousView.getTag()).longValue()))
            {
              int i = ((com.tencent.mm.ui.chatting.d.b.k)localObject).dGd();
              ((aj)m.this.cXJ.bh(aj.class)).fIM();
              m.a(m.this).fOV();
              m.b(m.this).setVisibility(0);
              m.b(m.this).adz(i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35195);
          }
        });
        break;
        this.fUI = new r((byte)0);
      }
    }
  }
  
  public final void bG(bv parambv)
  {
    AppMethodBeat.i(35226);
    if (parambv == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
      AppMethodBeat.o(35226);
      return;
    }
    com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    if (localk.Eq(parambv.field_msgId))
    {
      int i = localk.dGd();
      this.KcC.adz(i);
      this.KcC.setVisibility(0);
      this.fUI.fOV();
    }
    AppMethodBeat.o(35226);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35231);
    fHt();
    AppMethodBeat.o(35231);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(169865);
    super.fGE();
    if (this.Kap) {
      fHt();
    }
    AppMethodBeat.o(169865);
  }
  
  public final List<bv> fHs()
  {
    AppMethodBeat.i(169864);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGm().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[] { Long.valueOf(l) });
      bc.aCg();
      localLinkedList.add(com.tencent.mm.model.c.azI().ys(l));
    }
    Collections.sort(localLinkedList, new Comparator() {});
    AppMethodBeat.o(169864);
    return localLinkedList;
  }
  
  public final void fHt()
  {
    AppMethodBeat.i(35227);
    this.cXJ.Kkd.getController().addSearchMenu(false, this.fUI);
    if (this.KcC != null) {
      this.KcC.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).cxI();
    ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGX();
    ((aj)this.cXJ.bh(aj.class)).fIM();
    this.Kap = false;
    fHu();
    ((com.tencent.mm.ui.chatting.d.b.o)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.o.class)).ehi();
    ((com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fHO();
    this.cXJ.hideVKB();
    com.tencent.mm.ui.chatting.l.fFq();
    AppMethodBeat.o(35227);
  }
  
  public final boolean fHv()
  {
    return this.Kap;
  }
  
  public final void fHw()
  {
    AppMethodBeat.i(35229);
    if (this.fUI != null)
    {
      this.fUI.fOV();
      this.fUI.Lhk = null;
    }
    AppMethodBeat.o(35229);
  }
  
  public final void v(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.m
 * JD-Core Version:    0.7.0.1
 */