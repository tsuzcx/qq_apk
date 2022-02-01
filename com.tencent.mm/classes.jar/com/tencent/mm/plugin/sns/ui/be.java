package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.item.e;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.item.i.a;
import com.tencent.mm.plugin.sns.ui.item.j.a;
import com.tencent.mm.plugin.sns.ui.item.k.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class be
  implements aa
{
  public com.tencent.mm.ui.tools.l contextMenuHelper;
  protected com.tencent.mm.sdk.platformtools.ap handler;
  public MMActivity imP;
  private ListView izP;
  com.tencent.mm.sdk.b.c jBI;
  public com.tencent.mm.ui.widget.b.a mVN;
  protected int requestType;
  public com.tencent.mm.plugin.sns.ui.d.b wMy;
  public int xAZ;
  public boolean xBa;
  protected HashMap<String, Integer> xBc;
  private Map<Integer, WeakReference<SnsCommentPreloadTextView>> xFA;
  public HashMap<String, String> xFB;
  private int xFC;
  private HashMap<Integer, Class<? extends BaseTimeLineItem.BaseViewHolder>> xFD;
  public View.OnClickListener xFE;
  public View.OnClickListener xFF;
  public View.OnClickListener xFG;
  public View.OnClickListener xFH;
  private HashMap<String, Boolean> xFI;
  private d xFJ;
  protected y xFp;
  public i xFq;
  protected LinkedList<SnsCommentCollapseLayout> xFr;
  public HashMap<Integer, WeakReference<View>> xFs;
  View xFt;
  public PBool xFu;
  public int xFv;
  int xFw;
  protected HashMap<String, a> xFx;
  protected HashMap<Integer, View> xFy;
  public l xFz;
  protected HashMap<String, Integer> xlJ;
  public View.OnTouchListener xmL;
  public boolean xvU;
  public ay xwD;
  private int xwG;
  public j xwI;
  public bl xwM;
  protected ScaleAnimation xww;
  protected ScaleAnimation xwx;
  com.tencent.mm.sdk.b.c xxj;
  com.tencent.mm.sdk.b.c xxk;
  com.tencent.mm.sdk.b.c xxl;
  
  public be(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.b paramb, i parami, final y paramy)
  {
    AppMethodBeat.i(99243);
    this.xFr = new LinkedList();
    this.xFs = new HashMap();
    this.xvU = false;
    this.xAZ = 0;
    this.xBa = false;
    this.xFu = new PBool();
    this.xwG = 0;
    this.xFv = -1;
    this.xFw = 0;
    this.xlJ = new HashMap();
    this.xBc = new HashMap();
    this.xFx = new HashMap();
    this.xFy = new HashMap();
    this.requestType = 0;
    this.handler = new com.tencent.mm.sdk.platformtools.ap();
    this.xFA = new HashMap();
    this.xFB = new HashMap();
    this.xFC = 2;
    this.xxk = new com.tencent.mm.sdk.b.c() {};
    this.xxj = new com.tencent.mm.sdk.b.c() {};
    this.xxl = new com.tencent.mm.sdk.b.c() {};
    this.xFD = new HashMap();
    this.xFD.put(Integer.valueOf(6), j.a.class);
    this.xFD.put(Integer.valueOf(2), h.a.class);
    this.xFD.put(Integer.valueOf(3), h.a.class);
    this.xFD.put(Integer.valueOf(4), h.a.class);
    this.xFD.put(Integer.valueOf(5), h.a.class);
    this.xFD.put(Integer.valueOf(0), h.a.class);
    this.xFD.put(Integer.valueOf(1), h.a.class);
    this.xFD.put(Integer.valueOf(7), h.a.class);
    this.xFD.put(Integer.valueOf(8), h.a.class);
    this.xFD.put(Integer.valueOf(9), h.a.class);
    this.xFD.put(Integer.valueOf(11), k.b.class);
    this.xFD.put(Integer.valueOf(13), a.a.class);
    this.xFD.put(Integer.valueOf(14), d.a.class);
    this.xFD.put(Integer.valueOf(15), i.a.class);
    this.xFD.put(Integer.valueOf(10), h.a.class);
    this.xFD.put(Integer.valueOf(12), h.a.class);
    this.xFD.put(Integer.valueOf(16), h.a.class);
    this.xFE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99228);
        ad.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
        be.this.xFq.xla = false;
        com.tencent.mm.plugin.sns.abtest.a.drm();
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          ad.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
          AppMethodBeat.o(99228);
          return;
        }
        BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if ((localBaseViewHolder.timeLineObject != null) && (localBaseViewHolder.timeLineObject.Etm.DaB == 21))
        {
          bpj localbpj = localBaseViewHolder.xiM;
          if ((!u.aqG().equals(localBaseViewHolder.timeLineObject.mAQ)) && ((localbpj == null) || (localbpj.dDO == 0)))
          {
            com.tencent.mm.plugin.sns.lucky.ui.a.f(be.this.imP, localBaseViewHolder.xQQ.No(0));
            AppMethodBeat.o(99228);
            return;
          }
        }
        if ((be.this.imP instanceof v)) {
          ((v)be.this.imP).eF(paramAnonymousView);
        }
        AppMethodBeat.o(99228);
      }
    };
    this.xFF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99229);
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          AppMethodBeat.o(99229);
          return;
        }
        paramAnonymousView = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(99229);
          return;
        }
        if ((be.this.xlJ.containsKey(paramAnonymousView.dgg)) && (((Integer)be.this.xlJ.get(paramAnonymousView.dgg)).equals(Integer.valueOf(1))))
        {
          be.this.xlJ.put(paramAnonymousView.dgg, Integer.valueOf(2));
          be.this.xFp.notifyDataSetChanged();
          AppMethodBeat.o(99229);
          return;
        }
        be.this.xlJ.put(paramAnonymousView.dgg, Integer.valueOf(1));
        if (paramAnonymousView.rLd.getTop() < 0)
        {
          be.this.wMy.d(paramAnonymousView.rLd, paramAnonymousView.position, paramAnonymousView.rLd.getTop(), paramAnonymousView.xQt.getSpreadHeight());
          AppMethodBeat.o(99229);
          return;
        }
        be.this.xFp.notifyDataSetChanged();
        AppMethodBeat.o(99229);
      }
    };
    this.xFG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99230);
        if ((!be.this.xBa) || (be.this.xAZ <= 0))
        {
          AppMethodBeat.o(99230);
          return;
        }
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          AppMethodBeat.o(99230);
          return;
        }
        paramAnonymousView = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(99230);
          return;
        }
        ad.d("MicroMsg.SnsTimeLineBaseAdapter", "likeCollapListener onclick %s", new Object[] { paramAnonymousView.dgg });
        if ((be.this.xBc.containsKey(paramAnonymousView.dgg)) && ((((Integer)be.this.xBc.get(paramAnonymousView.dgg)).equals(Integer.valueOf(1))) || (((Integer)be.this.xBc.get(paramAnonymousView.dgg)).equals(Integer.valueOf(3)))))
        {
          be.this.xBc.put(paramAnonymousView.dgg, Integer.valueOf(2));
          com.tencent.mm.plugin.sns.k.f.wQY.bC(com.tencent.mm.plugin.sns.data.q.st(paramAnonymousView.xQn), true);
        }
        for (;;)
        {
          be.this.xFp.notifyDataSetChanged();
          AppMethodBeat.o(99230);
          return;
          be.this.xBc.put(paramAnonymousView.dgg, Integer.valueOf(1));
          com.tencent.mm.plugin.sns.k.f.wQY.bC(com.tencent.mm.plugin.sns.data.q.st(paramAnonymousView.xQn), false);
        }
      }
    };
    this.xFH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99231);
        if ((paramAnonymousView.getParent() == null) || (!(paramAnonymousView.getParent() instanceof SnsCommentCollapseLayout)))
        {
          AppMethodBeat.o(99231);
          return;
        }
        if ((((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() == null) || (!(((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() instanceof m)))
        {
          AppMethodBeat.o(99231);
          return;
        }
        Object localObject = (m)((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag();
        if (localObject == null)
        {
          AppMethodBeat.o(99231);
          return;
        }
        try
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((m)localObject).gKr);
          paramAnonymousView.putExtra("sns_local_id", ((m)localObject).xlO);
          paramAnonymousView.putExtra("sns_comment_buf", ((m)localObject).wFh.toByteArray());
          paramAnonymousView.setClass(be.this.imP, SnsSingleTextViewUI.class);
          localObject = be.this.imP;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(99231);
          return;
        }
        catch (IOException paramAnonymousView)
        {
          ad.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", paramAnonymousView, "commentCollapse click exception.", new Object[0]);
          AppMethodBeat.o(99231);
        }
      }
    };
    this.xmL = bt.eGL();
    this.xFI = new HashMap();
    this.xFJ = new d();
    this.jBI = new com.tencent.mm.sdk.b.c() {};
    this.xFp = paramy;
    this.xFq = parami;
    ad.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
    this.izP = paramListView;
    af.dtr();
    this.imP = paramMMActivity;
    this.wMy = paramb;
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramMMActivity);
    this.mVN = new com.tencent.mm.ui.widget.b.a(paramMMActivity);
    this.xwD = new ay(paramMMActivity);
    this.xww = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.xww.setDuration(150L);
    this.xwx = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.xwx.setDuration(150L);
    this.xwI = new j(paramMMActivity, 0, parami.xkY);
    this.xFz = new l(parami);
    this.requestType = 10;
    this.xwM = new bl(paramMMActivity, new bl.a()
    {
      public final void cEs()
      {
        AppMethodBeat.i(99232);
        paramy.notifyDataSetChanged();
        AppMethodBeat.o(99232);
      }
    }, 0, parami.xkY);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
    {
      this.xAZ = this.xFC;
      this.xBa = true;
      com.tencent.mm.sdk.b.a.ESL.c(this.jBI);
      AppMethodBeat.o(99243);
      return;
    }
    for (;;)
    {
      try
      {
        this.xAZ = bt.aGh(com.tencent.mm.plugin.expt.e.b.ceD().fF(b.a.psg.name(), "0"));
        if (bt.aGh(com.tencent.mm.plugin.expt.e.b.ceD().fF(b.a.psh.name(), "0")) != 1) {
          break label862;
        }
        bool = true;
        this.xBa = bool;
      }
      catch (NumberFormatException paramMMActivity)
      {
        ad.w("MicroMsg.SnsTimeLineBaseAdapter", "parse like collapse config error: %s", new Object[] { paramMMActivity.getMessage() });
      }
      break;
      label862:
      boolean bool = false;
    }
  }
  
  public static int O(p paramp)
  {
    AppMethodBeat.i(201287);
    int i = c(paramp, true);
    AppMethodBeat.o(201287);
    return i;
  }
  
  public static String a(TimeLineObject paramTimeLineObject, Context paramContext)
  {
    AppMethodBeat.i(99250);
    paramTimeLineObject = com.tencent.mm.plugin.sns.d.a.hYu.e(paramContext, paramTimeLineObject.Etl.Id, "timeline");
    AppMethodBeat.o(99250);
    return paramTimeLineObject;
  }
  
  public static String aqC(String paramString)
  {
    AppMethodBeat.i(99249);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(99249);
      return paramString;
    }
    int i = paramString.indexOf("://");
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(i + 3);
    }
    i = str.indexOf("/");
    paramString = str;
    if (i != -1) {
      paramString = str.substring(0, i);
    }
    AppMethodBeat.o(99249);
    return paramString;
  }
  
  public static String aqD(String paramString)
  {
    AppMethodBeat.i(99251);
    ad.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.d.a.hYu.O(paramString, "timeline");
    AppMethodBeat.o(99251);
    return paramString;
  }
  
  protected static int c(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(99247);
    TimeLineObject localTimeLineObject = paramp.dxy();
    if (localTimeLineObject.Etm.DaB == 1)
    {
      if ((paramBoolean) && (localTimeLineObject.evt == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramp.Nb(32)) && (paramp.dxs() != null))
      {
        if (paramp.dxs().dvm())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dvn())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dyl())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
      }
      int i = localTimeLineObject.Etm.DaC.size();
      if (i <= 1)
      {
        AppMethodBeat.o(99247);
        return 2;
      }
      if (i <= 3)
      {
        AppMethodBeat.o(99247);
        return 3;
      }
      if (i <= 6)
      {
        AppMethodBeat.o(99247);
        return 4;
      }
      AppMethodBeat.o(99247);
      return 5;
    }
    switch (localTimeLineObject.Etm.DaB)
    {
    default: 
      AppMethodBeat.o(99247);
      return 1;
    case 4: 
      AppMethodBeat.o(99247);
      return 0;
    case 5: 
      if ((paramp.Nb(32)) && (paramp.dxs() != null))
      {
        if (paramp.dxs().dvm())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dvn())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dyl())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
      }
      AppMethodBeat.o(99247);
      return 1;
    case 2: 
      AppMethodBeat.o(99247);
      return 6;
    case 8: 
      AppMethodBeat.o(99247);
      return 3;
    case 7: 
      AppMethodBeat.o(99247);
      return 2;
    case 14: 
      AppMethodBeat.o(99247);
      return 7;
    case 15: 
      if ((paramBoolean) && (localTimeLineObject.Ett == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramp.Nb(32)) && (paramp.dxs() != null))
      {
        if (paramp.dxs().dvm())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dvn())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dyl())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
      }
      AppMethodBeat.o(99247);
      return 9;
    case 21: 
      AppMethodBeat.o(99247);
      return 10;
    case 27: 
      AppMethodBeat.o(99247);
      return 11;
    }
    AppMethodBeat.o(99247);
    return 16;
  }
  
  public final p Ni(int paramInt)
  {
    AppMethodBeat.i(99257);
    p localp = this.xFp.Ni(paramInt);
    AppMethodBeat.o(99257);
    return localp;
  }
  
  public final boolean Nj(int paramInt)
  {
    AppMethodBeat.i(99259);
    if ((paramInt < this.izP.getFirstVisiblePosition() - 1) || (paramInt > this.izP.getLastVisiblePosition() - 1))
    {
      AppMethodBeat.o(99259);
      return false;
    }
    AppMethodBeat.o(99259);
    return true;
  }
  
  public final void a(SnsCommentCollapseLayout paramSnsCommentCollapseLayout)
  {
    AppMethodBeat.i(99239);
    this.xFr.add(paramSnsCommentCollapseLayout);
    AppMethodBeat.o(99239);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(99254);
    if (parama != null) {
      this.xFx.put(paramString, parama);
    }
    AppMethodBeat.o(99254);
  }
  
  public final void as(Runnable paramRunnable)
  {
    AppMethodBeat.i(99252);
    this.xFp.dzc();
    paramRunnable.run();
    AppMethodBeat.o(99252);
  }
  
  public final void dBS()
  {
    AppMethodBeat.i(99237);
    this.xlJ.clear();
    this.xBc.clear();
    AppMethodBeat.o(99237);
  }
  
  public final v dBT()
  {
    if ((this.imP instanceof v)) {
      return (v)this.imP;
    }
    return null;
  }
  
  public final SnsCommentCollapseLayout dBU()
  {
    AppMethodBeat.i(99238);
    if (this.xFr.size() == 0)
    {
      localSnsCommentCollapseLayout = new SnsCommentCollapseLayout(this.imP);
      AppMethodBeat.o(99238);
      return localSnsCommentCollapseLayout;
    }
    SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.xFr.removeFirst();
    AppMethodBeat.o(99238);
    return localSnsCommentCollapseLayout;
  }
  
  public final boolean dBV()
  {
    AppMethodBeat.i(99240);
    if (this.xFr != null) {
      this.xFr.clear();
    }
    if (this.xFD != null) {
      this.xFD.clear();
    }
    com.tencent.mm.pluginsdk.ui.span.k.clearCache();
    com.tencent.mm.kiss.widget.textview.c.ggt.agC();
    if (this.xFu.value) {
      ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psh, 0);
    }
    AppMethodBeat.o(99240);
    return true;
  }
  
  public final void dBW()
  {
    AppMethodBeat.i(99242);
    this.xFp.dzc();
    AppMethodBeat.o(99242);
  }
  
  public final void dBX()
  {
    AppMethodBeat.i(99244);
    int i = this.izP.getFirstVisiblePosition() - this.izP.getHeaderViewsCount();
    int j = this.izP.getLastVisiblePosition() - this.izP.getHeaderViewsCount();
    ad.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + i + " " + j);
    int k = this.xFp.getCount();
    if ((i <= j) && (i < k))
    {
      p localp = Ni(i);
      Object localObject = (View)this.xFy.get(Integer.valueOf(i));
      if ((localObject == null) || (localp == null) || (((View)localObject).getTag() == null)) {
        ad.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        ad.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).position);
        ((BaseTimeLineItem.BaseViewHolder)localObject).xRq.a((BaseTimeLineItem.BaseViewHolder)localObject, i, localp);
      }
    }
    AppMethodBeat.o(99244);
  }
  
  public final y dBY()
  {
    return this.xFp;
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(99255);
    this.xFx.clear();
    AppMethodBeat.o(99255);
  }
  
  public final com.tencent.mm.ui.widget.b.a dCa()
  {
    AppMethodBeat.i(99260);
    if (this.mVN != null) {
      this.mVN.eVf();
    }
    this.mVN = new com.tencent.mm.ui.widget.b.a(this.imP);
    com.tencent.mm.ui.widget.b.a locala = this.mVN;
    AppMethodBeat.o(99260);
    return locala;
  }
  
  public final void eI(View paramView)
  {
    AppMethodBeat.i(99256);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      AppMethodBeat.o(99256);
      return;
    }
    ad.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
    if ((this.xFt != null) && (this.xFt.getVisibility() == 0))
    {
      this.xFt.startAnimation(this.xwx);
      this.xwx.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(99224);
          if (be.this.xFt != null)
          {
            be.this.xFt.clearAnimation();
            be.this.xFt.setVisibility(8);
          }
          be.this.xFt = null;
          AppMethodBeat.o(99224);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    AppMethodBeat.o(99256);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(99258);
    int i = this.xFp.getCount();
    AppMethodBeat.o(99258);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99246);
    paramInt = c(this.xFp.Ni(paramInt), true);
    AppMethodBeat.o(99246);
    return paramInt;
  }
  
  public final View l(int paramInt, View paramView)
  {
    AppMethodBeat.i(99245);
    p localp = this.xFp.Ni(paramInt);
    TimeLineObject localTimeLineObject = localp.dxy();
    int j = c(localp, true);
    Object localObject1 = null;
    localObject3 = null;
    Object localObject4 = localObject1;
    Object localObject2 = localObject3;
    int i;
    if (paramView != null)
    {
      localObject2 = paramView.getTag(2131304989);
      if (!(localObject2 instanceof Integer)) {
        break label430;
      }
      i = ((Integer)localObject2).intValue();
      localObject4 = localObject1;
      localObject2 = localObject3;
      if (i == j)
      {
        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        localObject4 = ((BaseTimeLineItem.BaseViewHolder)localObject2).xRq;
      }
    }
    localObject1 = localObject2;
    localObject3 = paramView;
    if (localObject2 == null) {
      switch (j)
      {
      default: 
        localObject1 = new com.tencent.mm.plugin.sns.ui.item.g();
      }
    }
    for (;;)
    {
      for (;;)
      {
        Iterator localIterator;
        Object localObject6;
        label430:
        try
        {
          if (this.xFD.get(Integer.valueOf(j)) != null)
          {
            localObject3 = (BaseTimeLineItem.BaseViewHolder)((Class)this.xFD.get(Integer.valueOf(j))).newInstance();
            localObject2 = localObject3;
            localObject3 = paramView;
          }
        }
        catch (Exception localException1) {}
        try
        {
          ((BaseTimeLineItem.BaseViewHolder)localObject2).xRq = ((BaseTimeLineItem)localObject1);
          localObject3 = paramView;
          ((BaseTimeLineItem.BaseViewHolder)localObject2).timeLineObject = localTimeLineObject;
          localObject3 = paramView;
          paramView = ((BaseTimeLineItem)localObject1).a(this.imP, (BaseTimeLineItem.BaseViewHolder)localObject2, j, this, localp);
          localObject3 = paramView;
          paramView.setTag(2131304989, Integer.valueOf(j));
          localObject4 = localObject1;
          localObject3 = paramView;
          localObject1 = localObject2;
          ((BaseTimeLineItem)localObject4).setIsFromMainTimeline(this.xvU);
          paramView = localp.getSnsId();
          localObject2 = new ArrayList();
          if (com.tencent.mm.plugin.sns.model.ap.dub().size() <= 0) {
            break label649;
          }
          localIterator = com.tencent.mm.plugin.sns.model.ap.dub().keySet().iterator();
          if (!localIterator.hasNext()) {
            break label649;
          }
          localObject6 = (String)localIterator.next();
          if (((String)localObject6).startsWith(paramView))
          {
            localObject6 = (ap.b)com.tencent.mm.plugin.sns.model.ap.dub().get(localObject6);
            if (com.tencent.mm.plugin.sns.model.ap.c((ap.b)localObject6))
            {
              ((ArrayList)localObject2).add(localObject6);
              continue;
              i = -1;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject5;
            paramView = (View)localObject3;
          }
        }
      }
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.j();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.h();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.h();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.h();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.h();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.f();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.g();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.l();
      continue;
      localObject1 = new e();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.k();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.d();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.i();
      continue;
      localObject3 = new h.a();
      localObject2 = localObject3;
      continue;
      ad.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", localException1, "create holder error", new Object[0]);
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject3 = paramView;
    }
    label649:
    localObject5.xQk = ((ArrayList)localObject2);
    localObject5.a((BaseTimeLineItem.BaseViewHolder)localObject1, paramInt, localp, localTimeLineObject, j, this);
    if (com.tencent.mm.plugin.sns.model.ap.ev(localp.getSnsId(), 2))
    {
      paramView = com.tencent.mm.plugin.sns.model.ap.aoL(localp.getSnsId());
      if (localp.field_snsId == 0L) {
        paramView = new ap.b();
      }
      if (paramView.gPQ) {
        if (!paramView.aEj) {
          BaseTimeLineItem.a(paramView, (BaseTimeLineItem.BaseViewHolder)localObject1, paramView.result, paramView.gXN);
        }
      }
    }
    for (;;)
    {
      this.xFy.put(Integer.valueOf(paramInt), localObject3);
      AppMethodBeat.o(99245);
      return localObject3;
      BaseTimeLineItem.g((BaseTimeLineItem.BaseViewHolder)localObject1);
      com.tencent.mm.plugin.sns.model.ap.eu(paramView.id, 2);
      continue;
      BaseTimeLineItem.f((BaseTimeLineItem.BaseViewHolder)localObject1);
      continue;
      BaseTimeLineItem.g((BaseTimeLineItem.BaseViewHolder)localObject1);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(99241);
    this.xFp.notifyDataSetChanged();
    AppMethodBeat.o(99241);
  }
  
  public final void y(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(99253);
    a locala = (a)this.xFx.get(paramString);
    if ((locala != null) && (bt.kU(locala.getKey(), paramString))) {
      locala.qq(paramBoolean);
    }
    AppMethodBeat.o(99253);
  }
  
  public static abstract interface a
  {
    public abstract String getKey();
    
    public abstract void qq(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract boolean dCb();
  }
  
  public static final class c
    implements ar.b.a
  {
    int mPosition;
    y xFN = null;
    
    public c(y paramy, int paramInt)
    {
      this.xFN = paramy;
      this.mPosition = paramInt;
    }
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(99235);
      if (paramBoolean)
      {
        com.tencent.mm.kernel.g.afC();
        if (com.tencent.mm.kernel.g.afz().aeI()) {
          af.czA().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(99234);
              if (be.c.this.xFN.dzd() != null) {
                be.c.this.xFN.dzd().request(Integer.valueOf(be.c.this.mPosition));
              }
              be.c.this.xFN.notifyDataSetChanged();
              AppMethodBeat.o(99234);
            }
          });
        }
      }
      AppMethodBeat.o(99235);
    }
  }
  
  static final class d
    implements View.OnCreateContextMenuListener
  {
    private String diQ;
    private View targetView;
    private String url;
    private bpi wFd;
    private p wwP;
    private TimeLineObject xmh;
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(99236);
      paramContextMenuInfo = paramView.getTag();
      if ((paramContextMenuInfo instanceof s))
      {
        paramContextMenuInfo = (s)paramContextMenuInfo;
        TimeLineObject localTimeLineObject = paramContextMenuInfo.xmh;
        paramView.getContext();
        String str = be.aqD(localTimeLineObject.Etm.Url);
        if ((str == null) || (str.length() == 0))
        {
          AppMethodBeat.o(99236);
          return;
        }
        this.url = str;
        this.diQ = paramContextMenuInfo.dgg;
        this.targetView = paramView;
        if (localTimeLineObject.Etm.DaC.size() > 0) {}
        for (paramContextMenuInfo = (bpi)localTimeLineObject.Etm.DaC.get(0);; paramContextMenuInfo = null)
        {
          this.wFd = paramContextMenuInfo;
          this.wwP = af.dtu().apK(this.diQ);
          this.xmh = localTimeLineObject;
          if ((localTimeLineObject.Etm.DaB != 10) && (localTimeLineObject.Etm.DaB != 13)) {
            break;
          }
          AppMethodBeat.o(99236);
          return;
        }
        if (com.tencent.mm.bs.d.axB("favorite")) {
          switch (localTimeLineObject.Etm.DaB)
          {
          default: 
            paramContextMenu.add(0, 3, 0, paramView.getContext().getString(2131761941));
          }
        }
      }
      for (;;)
      {
        if ((this.wwP != null) && (!this.wwP.field_userName.equals(af.dta()))) {
          paramContextMenu.add(0, 8, 0, paramView.getContext().getString(2131757747));
        }
        AppMethodBeat.o(99236);
        return;
        paramContextMenu.add(0, 4, 0, paramView.getContext().getString(2131761941));
        continue;
        paramContextMenu.add(0, 5, 0, paramView.getContext().getString(2131761941));
        continue;
        paramContextMenu.add(0, 9, 0, paramView.getContext().getString(2131761941));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be
 * JD-Core Version:    0.7.0.1
 */