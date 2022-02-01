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
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
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
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  private ListView gFr;
  protected ao handler;
  public MMActivity iMV;
  com.tencent.mm.sdk.b.c kce;
  public com.tencent.mm.ui.widget.b.a nym;
  protected int requestType;
  public com.tencent.mm.plugin.sns.ui.d.b xZe;
  public boolean yIK;
  public bl yJC;
  com.tencent.mm.sdk.b.c yJZ;
  protected ScaleAnimation yJm;
  protected ScaleAnimation yJn;
  public ay yJt;
  private int yJw;
  public j yJy;
  com.tencent.mm.sdk.b.c yKa;
  com.tencent.mm.sdk.b.c yKb;
  public int yNN;
  public boolean yNO;
  protected HashMap<String, Integer> yNQ;
  protected y ySc;
  public i ySd;
  protected LinkedList<SnsCommentCollapseLayout> ySe;
  public HashMap<Integer, WeakReference<View>> ySf;
  View ySg;
  public PBool ySh;
  public int ySi;
  int ySj;
  protected HashMap<String, a> ySk;
  protected HashMap<Integer, View> ySl;
  public l ySm;
  private Map<Integer, WeakReference<SnsCommentPreloadTextView>> ySn;
  public HashMap<String, String> ySo;
  private int ySp;
  private HashMap<Integer, Class<? extends BaseTimeLineItem.BaseViewHolder>> ySq;
  public View.OnClickListener ySr;
  public View.OnClickListener ySs;
  public View.OnClickListener ySt;
  public View.OnClickListener ySu;
  private HashMap<String, Boolean> ySv;
  private d ySw;
  protected HashMap<String, Integer> yyB;
  public View.OnTouchListener yzD;
  
  public be(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.b paramb, i parami, final y paramy)
  {
    AppMethodBeat.i(99243);
    this.ySe = new LinkedList();
    this.ySf = new HashMap();
    this.yIK = false;
    this.yNN = 0;
    this.yNO = false;
    this.ySh = new PBool();
    this.yJw = 0;
    this.ySi = -1;
    this.ySj = 0;
    this.yyB = new HashMap();
    this.yNQ = new HashMap();
    this.ySk = new HashMap();
    this.ySl = new HashMap();
    this.requestType = 0;
    this.handler = new ao();
    this.ySn = new HashMap();
    this.ySo = new HashMap();
    this.ySp = 2;
    this.yKa = new com.tencent.mm.sdk.b.c() {};
    this.yJZ = new com.tencent.mm.sdk.b.c() {};
    this.yKb = new com.tencent.mm.sdk.b.c() {};
    this.ySq = new HashMap();
    this.ySq.put(Integer.valueOf(6), j.a.class);
    this.ySq.put(Integer.valueOf(2), h.a.class);
    this.ySq.put(Integer.valueOf(3), h.a.class);
    this.ySq.put(Integer.valueOf(4), h.a.class);
    this.ySq.put(Integer.valueOf(5), h.a.class);
    this.ySq.put(Integer.valueOf(0), h.a.class);
    this.ySq.put(Integer.valueOf(1), h.a.class);
    this.ySq.put(Integer.valueOf(7), h.a.class);
    this.ySq.put(Integer.valueOf(8), h.a.class);
    this.ySq.put(Integer.valueOf(9), h.a.class);
    this.ySq.put(Integer.valueOf(11), k.b.class);
    this.ySq.put(Integer.valueOf(13), a.a.class);
    this.ySq.put(Integer.valueOf(14), d.a.class);
    this.ySq.put(Integer.valueOf(15), i.a.class);
    this.ySq.put(Integer.valueOf(10), h.a.class);
    this.ySq.put(Integer.valueOf(12), h.a.class);
    this.ySq.put(Integer.valueOf(16), h.a.class);
    this.ySr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99228);
        ac.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
        be.this.ySd.yxS = false;
        com.tencent.mm.plugin.sns.abtest.a.dFv();
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          ac.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
          AppMethodBeat.o(99228);
          return;
        }
        BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if ((localBaseViewHolder.timeLineObject != null) && (localBaseViewHolder.timeLineObject.FQo.Ety == 21))
        {
          bua localbua = localBaseViewHolder.yvD;
          if ((!u.axw().equals(localBaseViewHolder.timeLineObject.ncR)) && ((localbua == null) || (localbua.dBA == 0)))
          {
            com.tencent.mm.plugin.sns.lucky.ui.a.f(be.this.iMV, localBaseViewHolder.zdG.Pr(0));
            AppMethodBeat.o(99228);
            return;
          }
        }
        if (localBaseViewHolder.isAd) {
          com.tencent.mm.plugin.sns.ad.e.d.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(localBaseViewHolder.ddB, paramAnonymousView, be.this.ySd.yxP));
        }
        if ((be.this.iMV instanceof v)) {
          ((v)be.this.iMV).eS(paramAnonymousView);
        }
        AppMethodBeat.o(99228);
      }
    };
    this.ySs = new View.OnClickListener()
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
        if ((be.this.yyB.containsKey(paramAnonymousView.ddB)) && (((Integer)be.this.yyB.get(paramAnonymousView.ddB)).equals(Integer.valueOf(1))))
        {
          be.this.yyB.put(paramAnonymousView.ddB, Integer.valueOf(2));
          be.this.ySc.notifyDataSetChanged();
          AppMethodBeat.o(99229);
          return;
        }
        be.this.yyB.put(paramAnonymousView.ddB, Integer.valueOf(1));
        if (paramAnonymousView.sSS.getTop() < 0)
        {
          be.this.xZe.d(paramAnonymousView.sSS, paramAnonymousView.position, paramAnonymousView.sSS.getTop(), paramAnonymousView.zdj.getSpreadHeight());
          AppMethodBeat.o(99229);
          return;
        }
        be.this.ySc.notifyDataSetChanged();
        AppMethodBeat.o(99229);
      }
    };
    this.ySt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99230);
        if ((!be.this.yNO) || (be.this.yNN <= 0))
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
        ac.d("MicroMsg.SnsTimeLineBaseAdapter", "likeCollapListener onclick %s", new Object[] { paramAnonymousView.ddB });
        if ((be.this.yNQ.containsKey(paramAnonymousView.ddB)) && ((((Integer)be.this.yNQ.get(paramAnonymousView.ddB)).equals(Integer.valueOf(1))) || (((Integer)be.this.yNQ.get(paramAnonymousView.ddB)).equals(Integer.valueOf(3)))))
        {
          be.this.yNQ.put(paramAnonymousView.ddB, Integer.valueOf(2));
          com.tencent.mm.plugin.sns.j.f.ydE.bJ(com.tencent.mm.plugin.sns.data.q.wW(paramAnonymousView.zdd), true);
        }
        for (;;)
        {
          be.this.ySc.notifyDataSetChanged();
          AppMethodBeat.o(99230);
          return;
          be.this.yNQ.put(paramAnonymousView.ddB, Integer.valueOf(1));
          com.tencent.mm.plugin.sns.j.f.ydE.bJ(com.tencent.mm.plugin.sns.data.q.wW(paramAnonymousView.zdd), false);
        }
      }
    };
    this.ySu = new View.OnClickListener()
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
          paramAnonymousView.putExtra("sns_text_show", ((m)localObject).hkR);
          paramAnonymousView.putExtra("sns_local_id", ((m)localObject).yyG);
          paramAnonymousView.putExtra("sns_comment_buf", ((m)localObject).xRC.toByteArray());
          paramAnonymousView.setClass(be.this.iMV, SnsSingleTextViewUI.class);
          localObject = be.this.iMV;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(99231);
          return;
        }
        catch (IOException paramAnonymousView)
        {
          ac.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", paramAnonymousView, "commentCollapse click exception.", new Object[0]);
          AppMethodBeat.o(99231);
        }
      }
    };
    this.yzD = bs.eWg();
    this.ySv = new HashMap();
    this.ySw = new d();
    this.kce = new com.tencent.mm.sdk.b.c() {};
    this.ySc = paramy;
    this.ySd = parami;
    ac.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
    this.gFr = paramListView;
    af.dHO();
    this.iMV = paramMMActivity;
    this.xZe = paramb;
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramMMActivity);
    this.nym = new com.tencent.mm.ui.widget.b.a(paramMMActivity);
    this.yJt = new ay(paramMMActivity);
    this.yJm = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.yJm.setDuration(150L);
    this.yJn = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.yJn.setDuration(150L);
    this.yJy = new j(paramMMActivity, 0, parami.yxQ);
    this.ySm = new l(parami);
    this.requestType = 10;
    this.yJC = new bl(paramMMActivity, new bl.a()
    {
      public final void cRC()
      {
        AppMethodBeat.i(99232);
        paramy.notifyDataSetChanged();
        AppMethodBeat.o(99232);
      }
    }, 0, parami.yxQ);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
    {
      this.yNN = this.ySp;
      this.yNO = true;
      com.tencent.mm.sdk.b.a.GpY.c(this.kce);
      AppMethodBeat.o(99243);
      return;
    }
    for (;;)
    {
      try
      {
        this.yNN = bs.aLy(com.tencent.mm.plugin.expt.e.b.cmk().fS(b.a.pWl.name(), "0"));
        if (bs.aLy(com.tencent.mm.plugin.expt.e.b.cmk().fS(b.a.pWm.name(), "0")) != 1) {
          break label862;
        }
        bool = true;
        this.yNO = bool;
      }
      catch (NumberFormatException paramMMActivity)
      {
        ac.w("MicroMsg.SnsTimeLineBaseAdapter", "parse like collapse config error: %s", new Object[] { paramMMActivity.getMessage() });
      }
      break;
      label862:
      boolean bool = false;
    }
  }
  
  public static int P(p paramp)
  {
    AppMethodBeat.i(210272);
    int i = c(paramp, true);
    AppMethodBeat.o(210272);
    return i;
  }
  
  public static String a(TimeLineObject paramTimeLineObject, Context paramContext)
  {
    AppMethodBeat.i(99250);
    paramTimeLineObject = com.tencent.mm.plugin.sns.c.a.iyy.e(paramContext, paramTimeLineObject.FQn.Id, "timeline");
    AppMethodBeat.o(99250);
    return paramTimeLineObject;
  }
  
  public static String avL(String paramString)
  {
    AppMethodBeat.i(99249);
    if (bs.isNullOrNil(paramString))
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
  
  public static String avM(String paramString)
  {
    AppMethodBeat.i(99251);
    ac.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.iyy.P(paramString, "timeline");
    AppMethodBeat.o(99251);
    return paramString;
  }
  
  protected static int c(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(99247);
    TimeLineObject localTimeLineObject = paramp.dLV();
    if (localTimeLineObject.FQo.Ety == 1)
    {
      if ((paramBoolean) && (localTimeLineObject.exP == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramp.Pe(32)) && (paramp.dFR() != null))
      {
        if (paramp.dFR().dJL())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dJM())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dMI())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
      }
      int i = localTimeLineObject.FQo.Etz.size();
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
    switch (localTimeLineObject.FQo.Ety)
    {
    default: 
      AppMethodBeat.o(99247);
      return 1;
    case 4: 
      AppMethodBeat.o(99247);
      return 0;
    case 5: 
      if ((paramp.Pe(32)) && (paramp.dFR() != null))
      {
        if (paramp.dFR().dJL())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dJM())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dMI())
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
      if ((paramBoolean) && (localTimeLineObject.FQv == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramp.Pe(32)) && (paramp.dFR() != null))
      {
        if (paramp.dFR().dJL())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dJM())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dMI())
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
  
  public final p Pl(int paramInt)
  {
    AppMethodBeat.i(99257);
    p localp = this.ySc.Pl(paramInt);
    AppMethodBeat.o(99257);
    return localp;
  }
  
  public final boolean Pm(int paramInt)
  {
    AppMethodBeat.i(99259);
    if ((paramInt < this.gFr.getFirstVisiblePosition() - 1) || (paramInt > this.gFr.getLastVisiblePosition() - 1))
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
    this.ySe.add(paramSnsCommentCollapseLayout);
    AppMethodBeat.o(99239);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(99254);
    if (parama != null) {
      this.ySk.put(paramString, parama);
    }
    AppMethodBeat.o(99254);
  }
  
  public final void au(Runnable paramRunnable)
  {
    AppMethodBeat.i(99252);
    this.ySc.dNz();
    paramRunnable.run();
    AppMethodBeat.o(99252);
  }
  
  public final void dQp()
  {
    AppMethodBeat.i(99237);
    this.yyB.clear();
    this.yNQ.clear();
    AppMethodBeat.o(99237);
  }
  
  public final v dQq()
  {
    if ((this.iMV instanceof v)) {
      return (v)this.iMV;
    }
    return null;
  }
  
  public final SnsCommentCollapseLayout dQr()
  {
    AppMethodBeat.i(99238);
    if (this.ySe.size() == 0)
    {
      localSnsCommentCollapseLayout = new SnsCommentCollapseLayout(this.iMV);
      AppMethodBeat.o(99238);
      return localSnsCommentCollapseLayout;
    }
    SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.ySe.removeFirst();
    AppMethodBeat.o(99238);
    return localSnsCommentCollapseLayout;
  }
  
  public final boolean dQs()
  {
    AppMethodBeat.i(99240);
    if (this.ySe != null) {
      this.ySe.clear();
    }
    if (this.ySq != null) {
      this.ySq.clear();
    }
    com.tencent.mm.pluginsdk.ui.span.k.clearCache();
    com.tencent.mm.kiss.widget.textview.c.gkZ.ahT();
    if (this.ySh.value) {
      ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWm, 0);
    }
    AppMethodBeat.o(99240);
    return true;
  }
  
  public final void dQt()
  {
    AppMethodBeat.i(99242);
    this.ySc.dNz();
    AppMethodBeat.o(99242);
  }
  
  public final void dQu()
  {
    AppMethodBeat.i(99244);
    int i = this.gFr.getFirstVisiblePosition() - this.gFr.getHeaderViewsCount();
    int j = this.gFr.getLastVisiblePosition() - this.gFr.getHeaderViewsCount();
    ac.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + i + " " + j);
    int k = this.ySc.getCount();
    if ((i <= j) && (i < k))
    {
      p localp = Pl(i);
      Object localObject = (View)this.ySl.get(Integer.valueOf(i));
      if ((localObject == null) || (localp == null) || (((View)localObject).getTag() == null)) {
        ac.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        ac.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).position);
        ((BaseTimeLineItem.BaseViewHolder)localObject).zeg.a((BaseTimeLineItem.BaseViewHolder)localObject, i, localp);
      }
    }
    AppMethodBeat.o(99244);
  }
  
  public final y dQv()
  {
    return this.ySc;
  }
  
  public final void dQw()
  {
    AppMethodBeat.i(99255);
    this.ySk.clear();
    AppMethodBeat.o(99255);
  }
  
  public final com.tencent.mm.ui.widget.b.a dQx()
  {
    AppMethodBeat.i(99260);
    if (this.nym != null) {
      this.nym.fkR();
    }
    this.nym = new com.tencent.mm.ui.widget.b.a(this.iMV);
    com.tencent.mm.ui.widget.b.a locala = this.nym;
    AppMethodBeat.o(99260);
    return locala;
  }
  
  public final void eV(View paramView)
  {
    AppMethodBeat.i(99256);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      AppMethodBeat.o(99256);
      return;
    }
    ac.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
    if ((this.ySg != null) && (this.ySg.getVisibility() == 0))
    {
      this.ySg.startAnimation(this.yJn);
      this.yJn.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(99224);
          if (be.this.ySg != null)
          {
            be.this.ySg.clearAnimation();
            be.this.ySg.setVisibility(8);
          }
          be.this.ySg = null;
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
    int i = this.ySc.getCount();
    AppMethodBeat.o(99258);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99246);
    paramInt = c(this.ySc.Pl(paramInt), true);
    AppMethodBeat.o(99246);
    return paramInt;
  }
  
  public final View l(int paramInt, View paramView)
  {
    AppMethodBeat.i(99245);
    p localp = this.ySc.Pl(paramInt);
    TimeLineObject localTimeLineObject = localp.dLV();
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
        localObject4 = ((BaseTimeLineItem.BaseViewHolder)localObject2).zeg;
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
          if (this.ySq.get(Integer.valueOf(j)) != null)
          {
            localObject3 = (BaseTimeLineItem.BaseViewHolder)((Class)this.ySq.get(Integer.valueOf(j))).newInstance();
            localObject2 = localObject3;
            localObject3 = paramView;
          }
        }
        catch (Exception localException1) {}
        try
        {
          ((BaseTimeLineItem.BaseViewHolder)localObject2).zeg = ((BaseTimeLineItem)localObject1);
          localObject3 = paramView;
          ((BaseTimeLineItem.BaseViewHolder)localObject2).timeLineObject = localTimeLineObject;
          localObject3 = paramView;
          paramView = ((BaseTimeLineItem)localObject1).a(this.iMV, (BaseTimeLineItem.BaseViewHolder)localObject2, j, this, localp);
          localObject3 = paramView;
          paramView.setTag(2131304989, Integer.valueOf(j));
          localObject4 = localObject1;
          localObject3 = paramView;
          localObject1 = localObject2;
          ((BaseTimeLineItem)localObject4).setIsFromMainTimeline(this.yIK);
          paramView = localp.getSnsId();
          localObject2 = new ArrayList();
          if (aq.dIB().size() <= 0) {
            break label649;
          }
          localIterator = aq.dIB().keySet().iterator();
          if (!localIterator.hasNext()) {
            break label649;
          }
          localObject6 = (String)localIterator.next();
          if (((String)localObject6).startsWith(paramView))
          {
            localObject6 = (aq.b)aq.dIB().get(localObject6);
            if (aq.c((aq.b)localObject6))
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
      ac.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", localException1, "create holder error", new Object[0]);
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject3 = paramView;
    }
    label649:
    localObject5.zda = ((ArrayList)localObject2);
    localObject5.a((BaseTimeLineItem.BaseViewHolder)localObject1, paramInt, localp, localTimeLineObject, j, this);
    if (aq.eD(localp.getSnsId(), 2))
    {
      paramView = aq.atX(localp.getSnsId());
      if (localp.field_snsId == 0L) {
        paramView = new aq.b();
      }
      if (paramView.hqq) {
        if (!paramView.aEZ) {
          BaseTimeLineItem.a(paramView, (BaseTimeLineItem.BaseViewHolder)localObject1, paramView.result, paramView.hym);
        }
      }
    }
    for (;;)
    {
      this.ySl.put(Integer.valueOf(paramInt), localObject3);
      AppMethodBeat.o(99245);
      return localObject3;
      BaseTimeLineItem.g((BaseTimeLineItem.BaseViewHolder)localObject1);
      aq.eC(paramView.id, 2);
      continue;
      BaseTimeLineItem.f((BaseTimeLineItem.BaseViewHolder)localObject1);
      continue;
      BaseTimeLineItem.g((BaseTimeLineItem.BaseViewHolder)localObject1);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(99241);
    this.ySc.notifyDataSetChanged();
    AppMethodBeat.o(99241);
  }
  
  public final void z(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(99253);
    a locala = (a)this.ySk.get(paramString);
    if ((locala != null) && (bs.lr(locala.getKey(), paramString))) {
      locala.ro(paramBoolean);
    }
    AppMethodBeat.o(99253);
  }
  
  public static abstract interface a
  {
    public abstract String getKey();
    
    public abstract void ro(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract boolean dQy();
  }
  
  public static final class c
    implements ar.b.a
  {
    int mPosition;
    y ySA = null;
    
    public c(y paramy, int paramInt)
    {
      this.ySA = paramy;
      this.mPosition = paramInt;
    }
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(99235);
      if (paramBoolean)
      {
        com.tencent.mm.kernel.g.agS();
        if (com.tencent.mm.kernel.g.agP().afY()) {
          af.cMM().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(99234);
              if (be.c.this.ySA.dNA() != null) {
                be.c.this.ySA.dNA().request(Integer.valueOf(be.c.this.mPosition));
              }
              be.c.this.ySA.notifyDataSetChanged();
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
    private String dgl;
    private View targetView;
    private String url;
    private p xIq;
    private btz xRy;
    private TimeLineObject yyZ;
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(99236);
      paramContextMenuInfo = paramView.getTag();
      if ((paramContextMenuInfo instanceof s))
      {
        paramContextMenuInfo = (s)paramContextMenuInfo;
        TimeLineObject localTimeLineObject = paramContextMenuInfo.yyZ;
        paramView.getContext();
        String str = be.avM(localTimeLineObject.FQo.Url);
        if ((str == null) || (str.length() == 0))
        {
          AppMethodBeat.o(99236);
          return;
        }
        this.url = str;
        this.dgl = paramContextMenuInfo.ddB;
        this.targetView = paramView;
        if (localTimeLineObject.FQo.Etz.size() > 0) {}
        for (paramContextMenuInfo = (btz)localTimeLineObject.FQo.Etz.get(0);; paramContextMenuInfo = null)
        {
          this.xRy = paramContextMenuInfo;
          this.xIq = af.dHR().auT(this.dgl);
          this.yyZ = localTimeLineObject;
          if ((localTimeLineObject.FQo.Ety != 10) && (localTimeLineObject.FQo.Ety != 13)) {
            break;
          }
          AppMethodBeat.o(99236);
          return;
        }
        if (com.tencent.mm.br.d.aCT("favorite")) {
          switch (localTimeLineObject.FQo.Ety)
          {
          default: 
            paramContextMenu.add(0, 3, 0, paramView.getContext().getString(2131761941));
          }
        }
      }
      for (;;)
      {
        if ((this.xIq != null) && (!this.xIq.field_userName.equals(af.dHx()))) {
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