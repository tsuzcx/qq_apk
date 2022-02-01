package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.ai.z.a;
import com.tencent.mm.ao.f;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ab;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.as;
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

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.l.class)
public class m
  extends a
  implements com.tencent.mm.ai.z, com.tencent.mm.ui.chatting.d.b.l
{
  public static be JHH;
  private String JDE = "";
  private boolean JFy = false;
  private ChattingFooterMoreBtnBar JHI;
  private boolean JHJ = true;
  private boolean Jxs;
  private com.tencent.mm.storage.am dzp;
  private r fSC;
  private boolean hasInit = false;
  private Animation yTf;
  
  static
  {
    AppMethodBeat.i(35233);
    JHH = new be(5, "MicroMsg.ChattingMoreBtnBarHelper");
    AppMethodBeat.o(35233);
  }
  
  private void fDr()
  {
    AppMethodBeat.i(35228);
    if (this.JFy) {
      this.cWM.showOptionMenu(false);
    }
    for (;;)
    {
      ((as)this.cWM.bh(as.class)).fFl();
      AppMethodBeat.o(35228);
      return;
      ((com.tencent.mm.ui.chatting.d.b.y)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fEc();
    }
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(35230);
    fDq();
    AppMethodBeat.o(35230);
  }
  
  public final boolean azg()
  {
    return this.JHJ;
  }
  
  public final boolean azh()
  {
    return false;
  }
  
  public final void b(z.a parama) {}
  
  public final void bG(bu parambu)
  {
    AppMethodBeat.i(35225);
    if (this.hasInit)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
      this.dzp = this.cWM.BYG;
      if ((!this.cWM.fFu()) && (!((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI())) {
        break label582;
      }
    }
    label582:
    for (boolean bool = true;; bool = false)
    {
      this.Jxs = bool;
      this.JHI.fBI();
      this.cWM.JOR.getController().addSearchMenu(true, this.fSC);
      if (this.JHI != null)
      {
        this.JHI.startAnimation(this.yTf);
        this.JHI.setVisibility(0);
      }
      this.JFy = true;
      ((ai)this.cWM.bh(ai.class)).fEJ();
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      localk.fCm();
      localk.fCl();
      localk.DR(parambu.field_msgId);
      int i = localk.dCM();
      this.JHI.acR(i);
      ((com.tencent.mm.ui.chatting.d.b.o)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.o.class)).fDA();
      this.cWM.hideVKB();
      fDr();
      ((com.tencent.mm.ui.chatting.d.b.s)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fDL();
      com.tencent.mm.plugin.report.service.g.yhR.f(10811, new Object[] { Integer.valueOf(1) });
      if (this.dzp.fqg())
      {
        parambu = this.cWM;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[] { Integer.valueOf(2131302248) });
        parambu.JOS.removeOptionMenu(2131302248);
      }
      ((com.tencent.mm.ui.chatting.d.b.z)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.z.class)).fEm();
      AppMethodBeat.o(35225);
      return;
      this.hasInit = true;
      if (this.JHI == null)
      {
        ((ViewStub)this.cWM.findViewById(2131306440)).inflate();
        this.JHI = ((ChattingFooterMoreBtnBar)this.cWM.findViewById(2131298096));
      }
      if (((ai)this.cWM.bh(ai.class)).fEQ())
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        if (this.fSC == null) {}
      }
      for (this.fSC.KKQ = null;; this.fSC.KKQ = new r.b()
          {
            String JHR = null;
            
            public final boolean Jp(String paramAnonymousString)
            {
              return false;
            }
            
            public final void Jq(String paramAnonymousString)
            {
              AppMethodBeat.i(35222);
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
              Object localObject = (ai)m.this.cWM.bh(ai.class);
              if (bt.isNullOrNil(paramAnonymousString)) {
                if (((ai)localObject).fEQ())
                {
                  if (((ai)localObject).fEL() != null) {
                    ((ai)localObject).fEL().Jo("");
                  }
                  ((ai)localObject).adm(-1);
                }
              }
              for (;;)
              {
                this.JHR = paramAnonymousString;
                AppMethodBeat.o(35222);
                return;
                if (m.f(m.this))
                {
                  if (this.JHR != null)
                  {
                    ((ai)localObject).fEJ();
                    m.b(m.this).setVisibility(0);
                    localObject = (com.tencent.mm.ui.chatting.d.b.k)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
                    m.b(m.this).acR(((com.tencent.mm.ui.chatting.d.b.k)localObject).dCM());
                  }
                }
                else
                {
                  ((ai)localObject).fEJ();
                  m.b(m.this).setVisibility(8);
                  continue;
                  com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                  m.b(m.this).setVisibility(8);
                  ((ai)localObject).fEI();
                  if (((ai)localObject).fEL() != null) {
                    ((ai)localObject).fEL().Jo(paramAnonymousString);
                  }
                }
              }
            }
            
            public final void aSm()
            {
              AppMethodBeat.i(35223);
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
              com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
              if (localk.isInEditMode())
              {
                ((ai)m.this.cWM.bh(ai.class)).fEJ();
                m.b(m.this).setVisibility(0);
                m.b(m.this).acR(localk.dCM());
              }
              m.this.cWM.JOR.getController().supportInvalidateOptionsMenu();
              AppMethodBeat.o(35223);
            }
            
            public final void aSn()
            {
              AppMethodBeat.i(35224);
              com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 21L, 1L, true);
              if (((com.tencent.mm.ui.chatting.d.b.k)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode())
              {
                ((ai)m.this.cWM.bh(ai.class)).fEI();
                m.b(m.this).setVisibility(8);
              }
              AppMethodBeat.o(35224);
            }
            
            public final void aSo() {}
            
            public final void aSp() {}
          })
      {
        this.JHI.b(3, new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35197);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.k)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if (paramAnonymousView.dCM() == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35197);
              return;
            }
            localObject = m.this.cWM.JOR.getContext();
            com.tencent.mm.ui.base.h.a((Context)localObject, ((Context)localObject).getString(2131757553), "", ((Context)localObject).getString(2131758038), ((Context)localObject).getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(35196);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                com.tencent.mm.ui.chatting.i.a(this.val$context, paramAnonymousView.fCk(), m.this);
                m.this.fDq();
                AppMethodBeat.o(35196);
              }
            }, null, 2131099904);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35197);
          }
        });
        this.JHI.b(2, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35198);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (((com.tencent.mm.ui.chatting.d.b.k)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).dCM() == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35198);
              return;
            }
            com.tencent.mm.ui.chatting.m.a(m.this.cWM, m.this.fDp(), m.c(m.this), m.this, m.d(m.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35198);
          }
        });
        this.JHI.b(1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35199);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.k)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if ((paramAnonymousView == null) || (paramAnonymousView.dCM() == 0))
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            paramAnonymousView = m.this.fDp();
            if (com.tencent.mm.ui.chatting.j.hW(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(m.this.cWM.JOR.getContext(), m.this.cWM.JOR.getContext().getString(2131757937), "", m.this.cWM.JOR.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.j.hX(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(m.this.cWM.JOR.getContext(), m.this.cWM.JOR.getContext().getString(2131757938), "", m.this.cWM.JOR.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.j.hV(paramAnonymousView))
            {
              com.tencent.mm.ui.base.h.a(m.this.cWM.JOR.getContext(), m.this.cWM.JOR.getContext().getString(2131757939), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              }, null);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35199);
              return;
            }
            if (com.tencent.mm.ui.chatting.n.a(m.this.cWM, paramAnonymousView, m.d(m.this))) {
              m.this.fDq();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35199);
          }
        });
        this.JHI.b(0, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35202);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (((com.tencent.mm.ui.chatting.d.b.k)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).dCM() == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
            }
            if (((w.zE(m.d(m.this).field_username)) && (!com.tencent.mm.am.g.vd(m.d(m.this).field_username))) || (w.Aq(m.d(m.this).field_username)))
            {
              m.a(m.this, true);
              com.tencent.mm.ui.chatting.k.a(m.this.cWM.JOR.getContext(), m.this.fDp(), m.c(m.this), m.d(m.this).field_username, m.this);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(35202);
              return;
              paramAnonymousView = new com.tencent.mm.ui.widget.a.e(m.this.cWM.JOR.getContext(), 1, false);
              paramAnonymousView.KJy = new n.d()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(35200);
                  paramAnonymous2l.jI(0, 2131761385);
                  paramAnonymous2l.jI(1, 2131761386);
                  if (com.tencent.mm.ui.chatting.am.dG(m.this.cWM.JOR.getContext())) {
                    paramAnonymous2l.c(2, m.this.cWM.JOR.getContext().getString(2131761387, new Object[] { com.tencent.mm.ui.chatting.am.kk(m.this.cWM.JOR.getContext()) }));
                  }
                  AppMethodBeat.o(35200);
                }
              };
              paramAnonymousView.KJz = new n.e()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(35201);
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(35201);
                    return;
                    if (com.tencent.mm.ui.chatting.j.hV(m.this.fDp()))
                    {
                      com.tencent.mm.ui.base.h.c(m.this.cWM.JOR.getContext(), m.this.cWM.JOR.getMMResources().getString(2131766922), "", true);
                      AppMethodBeat.o(35201);
                      return;
                    }
                    m.a(m.this, true);
                    com.tencent.mm.ui.chatting.k.a(m.this.cWM.JOR.getContext(), m.this.fDp(), m.c(m.this), m.d(m.this).field_username, m.this);
                    AppMethodBeat.o(35201);
                    return;
                    m.a(m.this, false);
                    com.tencent.mm.ui.chatting.k.a(m.this.cWM.JOR.getContext(), m.this.fDp(), m.c(m.this), m.d(m.this).field_username, m.this);
                    AppMethodBeat.o(35201);
                    return;
                    com.tencent.mm.ui.chatting.am.a(m.this.cWM.JOR.getContext(), m.d(m.this), m.this.fDp(), m.c(m.this));
                    m.this.fDq();
                  }
                }
              };
              paramAnonymousView.cMW();
            }
          }
        });
        this.JHI.b(4, new View.OnClickListener()
        {
          private void c(cv paramAnonymouscv)
          {
            AppMethodBeat.i(35212);
            Object localObject1 = m.this.fDp();
            Object localObject2 = ((List)localObject1).iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (!ab.bn((bu)((Iterator)localObject2).next()))
              {
                com.tencent.mm.ui.base.h.a(m.this.cWM.JOR.getContext(), m.this.cWM.JOR.getContext().getString(2131766957), "", m.this.cWM.JOR.getContext().getString(2131766205), null);
                AppMethodBeat.o(35212);
                return;
              }
            }
            paramAnonymouscv.dnG.fragment = m.this.cWM.JOR;
            paramAnonymouscv.dnG.dnM = 41;
            paramAnonymouscv.dnG.dnO = new com.tencent.mm.ui.widget.snackbar.a.c()
            {
              public final void bio()
              {
                AppMethodBeat.i(35205);
                ((com.tencent.mm.ui.chatting.d.b.s)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fDK();
                AppMethodBeat.o(35205);
              }
              
              public final void onHide()
              {
                AppMethodBeat.i(35204);
                m.this.fDq();
                AppMethodBeat.o(35204);
              }
              
              public final void onShow()
              {
                AppMethodBeat.i(35203);
                m.this.fDq();
                m.b(m.this).setVisibility(4);
                AppMethodBeat.o(35203);
              }
            };
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymouscv);
            int i;
            long l;
            if (paramAnonymouscv.dnH.ret == 0)
            {
              i = 1;
              l = bt.aQJ();
              Iterator localIterator = ((List)localObject1).iterator();
              label186:
              while (localIterator.hasNext())
              {
                localObject1 = (bu)localIterator.next();
                if (((bu)localObject1).cTc())
                {
                  localObject2 = k.b.yr(bt.aRd(((ei)localObject1).field_content));
                  if ((localObject2 != null) && (((k.b)localObject2).type == 5) && (!bt.isNullOrNil(((k.b)localObject2).url))) {
                    if (!((bu)localObject1).fpd()) {
                      break label742;
                    }
                  }
                }
              }
            }
            label742:
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
              com.tencent.mm.plugin.report.service.g.yhR.f(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
              break label186;
              i = 2;
              break;
              if (paramAnonymouscv.dnH.ret == 0)
              {
                if (14 != paramAnonymouscv.dnG.type)
                {
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                  AppMethodBeat.o(35212);
                  return;
                }
                if (paramAnonymouscv.dnG.dnJ == null)
                {
                  com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                  AppMethodBeat.o(35212);
                  return;
                }
                com.tencent.mm.plugin.report.service.g.yhR.f(11142, new Object[] { Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjK), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjL), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjM), Integer.valueOf(paramAnonymouscv.dnG.dnJ.tGM), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjN), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjO), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjP), Integer.valueOf(paramAnonymouscv.dnG.dnJ.fileCount), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjQ), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjR), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjS), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjT), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjU), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjV), Integer.valueOf(paramAnonymouscv.dnG.dnJ.GjW) });
              }
              AppMethodBeat.o(35212);
              return;
            }
          }
          
          private void h(HashSet<Long> paramAnonymousHashSet)
          {
            AppMethodBeat.i(35215);
            if (paramAnonymousHashSet.isEmpty()) {
              new ap(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(35210);
                  m.6.this.fDu();
                  AppMethodBeat.o(35210);
                }
              });
            }
            AppMethodBeat.o(35215);
          }
          
          private static String ib(List<bu> paramAnonymousList)
          {
            AppMethodBeat.i(35213);
            StringBuffer localStringBuffer = new StringBuffer();
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext()) {
              localStringBuffer.append(((bu)paramAnonymousList.next()).field_msgId);
            }
            paramAnonymousList = localStringBuffer.toString();
            AppMethodBeat.o(35213);
            return paramAnonymousList;
          }
          
          private static void ic(List<bu> paramAnonymousList)
          {
            AppMethodBeat.i(35217);
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              bu localbu = (bu)paramAnonymousList.next();
              com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Jxc, a.d.Jxh, localbu, 0);
            }
            AppMethodBeat.o(35217);
          }
          
          public final void fDu()
          {
            AppMethodBeat.i(35216);
            m.a(m.this, "");
            final List localList = m.this.fDp();
            if (com.tencent.mm.ui.chatting.j.hW(localList))
            {
              com.tencent.mm.ui.base.h.a(m.this.cWM.JOR.getContext(), m.this.cWM.JOR.getContext().getString(2131758900), "", m.this.cWM.JOR.getContext().getString(2131755012), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(35216);
              return;
            }
            final cv localcv = new cv();
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { m.d(m.this).field_username });
            Object localObject1;
            Object localObject2;
            Object localObject3;
            if (localList.size() == 1)
            {
              localObject1 = (bu)localList.get(0);
              if ((localObject1 != null) && ((((bu)localObject1).cTc()) || (((bu)localObject1).fpd())))
              {
                localObject2 = com.tencent.mm.model.y.AH(((ei)localObject1).field_msgSvrId);
                localObject3 = com.tencent.mm.model.y.aBq().F((String)localObject2, true);
                ((y.b)localObject3).k("prePublishId", "msg_" + ((ei)localObject1).field_msgSvrId);
                boolean bool = ((com.tencent.mm.ui.chatting.d.b.d)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH();
                ((y.b)localObject3).k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a((bu)localObject1, m.c(m.this), bool));
                ((y.b)localObject3).k("preChatName", m.d(m.this).field_username);
                ((y.b)localObject3).k("preMsgIndex", Integer.valueOf(0));
                ((y.b)localObject3).k("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (y.b)localObject3, (bu)localObject1);
                localcv.dnG.sessionId = ((String)localObject2);
              }
            }
            if (com.tencent.mm.pluginsdk.model.i.a(m.this.cWM.JOR.getContext(), localcv, m.d(m.this).field_username, localList, true))
            {
              localObject1 = localList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (bu)((Iterator)localObject1).next();
                if (((bu)localObject2).cTc()) {
                  com.tencent.mm.modelstat.b.inZ.c((bu)localObject2, com.tencent.mm.ai.l.r((bu)localObject2));
                } else {
                  com.tencent.mm.modelstat.b.inZ.S((bu)localObject2);
                }
              }
              c(localcv);
              ic(m.this.fDp());
              AppMethodBeat.o(35216);
              return;
            }
            if (m.this.fDp().size() > 1)
            {
              localObject3 = m.this.cWM.JOR.getContext();
              if (localcv.dnG.dnL >= 0)
              {
                localObject1 = m.this.cWM.JOR.getContext().getString(2131758899);
                if (localcv.dnG.dnL < 0) {
                  break label637;
                }
              }
              label637:
              for (localObject2 = m.this.cWM.JOR.getContext().getString(2131757560);; localObject2 = m.this.cWM.JOR.getContext().getString(2131761941))
              {
                com.tencent.mm.ui.base.h.e((Context)localObject3, (String)localObject1, "", (String)localObject2, m.this.cWM.JOR.getContext().getString(2131757558), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(35211);
                    paramAnonymous2DialogInterface = localList.iterator();
                    while (paramAnonymous2DialogInterface.hasNext())
                    {
                      bu localbu = (bu)paramAnonymous2DialogInterface.next();
                      if ((!localbu.frH()) && (!localbu.frG()))
                      {
                        if ((localcv.dnG.type == 14) && (localcv.dnG.dnI.nZa.size() == 0))
                        {
                          m.this.fDq();
                          AppMethodBeat.o(35211);
                          return;
                        }
                        m.6.a(m.6.this, localcv);
                        m.6.id(m.this.fDp());
                        AppMethodBeat.o(35211);
                        return;
                      }
                    }
                    AppMethodBeat.o(35211);
                  }
                }, null);
                AppMethodBeat.o(35216);
                return;
                localObject1 = m.this.cWM.JOR.getContext().getString(2131758898);
                break;
              }
            }
            com.tencent.mm.ui.base.h.l(m.this.cWM.JOR.getContext(), localcv.dnG.dnL, 0);
            AppMethodBeat.o(35216);
          }
          
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(35214);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
            localObject1 = m.this.fDp();
            paramAnonymousView = new HashSet();
            Object localObject2 = ib((List)localObject1);
            if (((String)localObject2).equals(m.e(m.this)))
            {
              com.tencent.mm.ui.base.t.makeText(m.this.cWM.JOR.getContext(), m.this.cWM.JOR.getContext().getString(2131758828), 0).show();
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
              localObject2 = (bu)((Iterator)localObject1).next();
              Object localObject3;
              Object localObject4;
              com.tencent.mm.i.g localg;
              if (((bu)localObject2).cTc())
              {
                localObject3 = k.b.yr(((ei)localObject2).field_content);
                if ((localObject3 != null) && (((k.b)localObject3).type == 6) && (!bt.isNullOrNil(((k.b)localObject3).hzU)))
                {
                  localObject4 = com.tencent.mm.pluginsdk.model.app.m.c((bu)localObject2, ((k.b)localObject3).dks);
                  if ((localObject4 != null) && ((!com.tencent.mm.vfs.i.fv(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath)) || (com.tencent.mm.vfs.i.aYo(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath) != ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_totalLen)))
                  {
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[] { Long.valueOf(((ei)localObject2).field_msgId) });
                    paramAnonymousView.add(Long.valueOf(((ei)localObject2).field_msgId));
                    localg = new com.tencent.mm.i.g();
                    localg.fJi = "task_ChattingMoreComponent";
                    localg.fJj = new g.a()
                    {
                      public final int a(String paramAnonymous2String, int paramAnonymous2Int, com.tencent.mm.i.c paramAnonymous2c, com.tencent.mm.i.d paramAnonymous2d, boolean paramAnonymous2Boolean)
                      {
                        AppMethodBeat.i(35209);
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2c != null))
                        {
                          this.JAy.field_offset = paramAnonymous2c.field_finishedLength;
                          ao.bIX().a(this.JAy, new String[0]);
                        }
                        if ((paramAnonymous2Int == 0) && (paramAnonymous2d != null) && (paramAnonymous2d.field_retCode == 0))
                        {
                          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[] { Long.valueOf(this.hED.field_msgId) });
                          this.JAy.field_status = 199L;
                          this.JAy.field_offset = this.JAy.field_totalLen;
                          ao.bIX().a(this.JAy, new String[0]);
                          this.hED.setStatus(3);
                          ba.aBQ();
                          com.tencent.mm.model.c.azs().a(this.hED.field_msgId, this.hED);
                          paramAnonymousView.remove(Long.valueOf(this.hED.field_msgId));
                          m.6.a(m.6.this, paramAnonymousView);
                        }
                        long l;
                        if ((paramAnonymous2Int != 0) || ((paramAnonymous2d != null) && (paramAnonymous2d.field_retCode != 0)))
                        {
                          l = this.hED.field_msgId;
                          if (paramAnonymous2d != null) {
                            break label283;
                          }
                        }
                        label283:
                        for (int i = 0;; i = paramAnonymous2d.field_retCode)
                        {
                          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)", new Object[] { Long.valueOf(l), Integer.valueOf(paramAnonymous2Int), Integer.valueOf(i) });
                          paramAnonymousView.remove(Long.valueOf(this.hED.field_msgId));
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
                    localg.field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.flT(), ((ei)localObject2).field_talker, ((ei)localObject2).field_msgId);
                    localg.field_aesKey = ((k.b)localObject3).gjI;
                    localg.field_fileType = 19;
                    localg.field_authKey = ((k.b)localObject3).hAa;
                    localg.fJm = ((k.b)localObject3).hzU;
                    if ((localObject4 == null) || (bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath))) {
                      break label774;
                    }
                    localg.field_fullpath = ((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath;
                    if (!f.aGI().b(localg, -1))
                    {
                      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                      paramAnonymousView.remove(Long.valueOf(((ei)localObject2).field_msgId));
                    }
                  }
                }
              }
              int i;
              if (((bu)localObject2).fpi())
              {
                localObject3 = q.aIF().F(((ei)localObject2).field_talker, ((ei)localObject2).field_msgSvrId);
                if (((ei)localObject2).field_isSend != 1) {
                  break label807;
                }
                if (!((com.tencent.mm.aw.g)localObject3).aIj()) {
                  break label802;
                }
                i = 1;
                if ((((com.tencent.mm.aw.g)localObject3).offset < ((com.tencent.mm.aw.g)localObject3).hMP) || (((com.tencent.mm.aw.g)localObject3).hMP == 0))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[] { Long.valueOf(((ei)localObject2).field_msgId) });
                  paramAnonymousView.add(Long.valueOf(((ei)localObject2).field_msgId));
                  if (!q.aIG().a(((com.tencent.mm.aw.g)localObject3).dnz, ((ei)localObject2).field_msgId, i, localObject2, 2131231564, new e.a()
                  {
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(35208);
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.hED.field_msgId) });
                      paramAnonymousView.remove(Long.valueOf(this.hED.field_msgId));
                      m.6.a(m.6.this, paramAnonymousView);
                      AppMethodBeat.o(35208);
                    }
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, com.tencent.mm.al.n paramAnonymous2n) {}
                    
                    public final void a(long paramAnonymous2Long1, long paramAnonymous2Long2, int paramAnonymous2Int1, int paramAnonymous2Int2, Object paramAnonymous2Object, int paramAnonymous2Int3, int paramAnonymous2Int4, String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
                    {
                      AppMethodBeat.i(35207);
                      if ((paramAnonymous2Int3 == 0) && (paramAnonymous2Int4 == 0)) {}
                      for (boolean bool = true;; bool = false)
                      {
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.hED.field_msgId), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(paramAnonymous2Int4) });
                        paramAnonymousView.remove(Long.valueOf(this.hED.field_msgId));
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
              if ((((bu)localObject2).cxf()) || (((bu)localObject2).cxh()))
              {
                localObject3 = com.tencent.mm.modelvideo.u.Hy(((ei)localObject2).field_imgPath);
                if ((localObject3 != null) && (((com.tencent.mm.modelvideo.s)localObject3).status != 199))
                {
                  paramAnonymousView.add(Long.valueOf(((ei)localObject2).field_msgId));
                  localObject4 = new t.a()
                  {
                    public final void a(t.a.a paramAnonymous2a)
                    {
                      AppMethodBeat.i(35206);
                      if (this.hED.field_imgPath.equals(paramAnonymous2a.fileName))
                      {
                        com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Hy(paramAnonymous2a.fileName);
                        if ((locals == null) || (!locals.aMY())) {
                          break label114;
                        }
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.hED.field_msgId), paramAnonymous2a.fileName });
                      }
                      for (;;)
                      {
                        com.tencent.mm.modelvideo.o.aMJ().a(this);
                        paramAnonymousView.remove(Long.valueOf(this.hED.field_msgId));
                        m.6.a(m.6.this, paramAnonymousView);
                        AppMethodBeat.o(35206);
                        return;
                        label114:
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.hED.field_msgId), paramAnonymous2a.fileName });
                      }
                    }
                  };
                  com.tencent.mm.modelvideo.o.aMJ().a((t.a)localObject4, Looper.getMainLooper());
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[] { Long.valueOf(((ei)localObject2).field_msgId), ((ei)localObject2).field_imgPath });
                  if (((com.tencent.mm.modelvideo.s)localObject3).aMX()) {
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                  }
                  for (i = com.tencent.mm.modelvideo.u.HF(((ei)localObject2).field_imgPath);; i = com.tencent.mm.modelvideo.u.Ht(((ei)localObject2).field_imgPath))
                  {
                    if (i == 0) {
                      break label876;
                    }
                    paramAnonymousView.remove(Long.valueOf(((ei)localObject2).field_msgId));
                    break;
                    ba.aBQ();
                    localg.field_fullpath = com.tencent.mm.pluginsdk.model.app.m.aq(com.tencent.mm.model.c.azI(), ((k.b)localObject3).title, ((k.b)localObject3).hzP);
                    break label435;
                    i = 0;
                    break label513;
                    if (!((com.tencent.mm.aw.g)localObject3).aIj())
                    {
                      i = 0;
                      break label513;
                    }
                    localObject4 = com.tencent.mm.aw.h.a((com.tencent.mm.aw.g)localObject3);
                    if (!com.tencent.mm.vfs.i.fv(q.aIF().o(((com.tencent.mm.aw.g)localObject4).hZw, "", "")))
                    {
                      i = 0;
                      break label513;
                    }
                    i = 1;
                    break label513;
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
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
        this.yTf = AnimationUtils.loadAnimation(this.cWM.JOR.getContext(), 2130772108);
        ((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).e(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(35195);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            localObject = (com.tencent.mm.ui.chatting.d.b.k)m.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if (((com.tencent.mm.ui.chatting.d.b.k)localObject).DR(((Long)paramAnonymousView.getTag()).longValue()))
            {
              int i = ((com.tencent.mm.ui.chatting.d.b.k)localObject).dCM();
              ((ai)m.this.cWM.bh(ai.class)).fEJ();
              m.a(m.this).fKE();
              m.b(m.this).setVisibility(0);
              m.b(m.this).acR(i);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/ChattingMoreComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35195);
          }
        });
        break;
        this.fSC = new r((byte)0);
      }
    }
  }
  
  public final void bH(bu parambu)
  {
    AppMethodBeat.i(35226);
    if (parambu == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
      AppMethodBeat.o(35226);
      return;
    }
    com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    if (localk.DR(parambu.field_msgId))
    {
      int i = localk.dCM();
      this.JHI.acR(i);
      this.JHI.setVisibility(0);
      this.fSC.fKE();
    }
    AppMethodBeat.o(35226);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35231);
    fDq();
    AppMethodBeat.o(35231);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(169865);
    super.fCC();
    if (this.JFy) {
      fDq();
    }
    AppMethodBeat.o(169865);
  }
  
  public final List<bu> fDp()
  {
    AppMethodBeat.i(169864);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCk().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[] { Long.valueOf(l) });
      ba.aBQ();
      localLinkedList.add(com.tencent.mm.model.c.azs().xY(l));
    }
    Collections.sort(localLinkedList, new Comparator() {});
    AppMethodBeat.o(169864);
    return localLinkedList;
  }
  
  public final void fDq()
  {
    AppMethodBeat.i(35227);
    this.cWM.JOR.getController().addSearchMenu(false, this.fSC);
    if (this.JHI != null) {
      this.JHI.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).cwh();
    ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCV();
    ((ai)this.cWM.bh(ai.class)).fEJ();
    this.JFy = false;
    fDr();
    ((com.tencent.mm.ui.chatting.d.b.o)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.o.class)).edB();
    ((com.tencent.mm.ui.chatting.d.b.s)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fDL();
    this.cWM.hideVKB();
    com.tencent.mm.ui.chatting.k.fBo();
    AppMethodBeat.o(35227);
  }
  
  public final boolean fDs()
  {
    return this.JFy;
  }
  
  public final void fDt()
  {
    AppMethodBeat.i(35229);
    if (this.fSC != null)
    {
      this.fSC.fKE();
      this.fSC.KKQ = null;
    }
    AppMethodBeat.o(35229);
  }
  
  public final void u(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.m
 * JD-Core Version:    0.7.0.1
 */