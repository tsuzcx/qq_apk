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
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.ve;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.c.a;
import com.tencent.mm.plugin.sns.ui.item.e.a;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.item.g.a;
import com.tencent.mm.plugin.sns.ui.item.h;
import com.tencent.mm.plugin.sns.ui.item.j.a;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.plugin.sns.ui.item.l.a;
import com.tencent.mm.plugin.sns.ui.item.m.b;
import com.tencent.mm.plugin.sns.ui.item.n;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
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

public final class bh
  implements ab
{
  protected ScaleAnimation AaG;
  protected ScaleAnimation AaH;
  public bb AaN;
  private int AaQ;
  public j AaS;
  public bo AaW;
  public boolean Aae;
  com.tencent.mm.sdk.b.c Abv;
  com.tencent.mm.sdk.b.c Abw;
  com.tencent.mm.sdk.b.c Abx;
  public int Afj;
  public boolean Afk;
  protected HashMap<String, Integer> Afm;
  protected z AjD;
  public i AjE;
  protected LinkedList<SnsCommentCollapseLayout> AjF;
  public HashMap<Integer, WeakReference<View>> AjG;
  View AjH;
  public PBool AjI;
  public int AjJ;
  int AjK;
  protected HashMap<String, a> AjL;
  protected HashMap<Integer, View> AjM;
  public l AjN;
  private Map<Integer, WeakReference<SnsCommentPreloadTextView>> AjO;
  public HashMap<String, String> AjP;
  private int AjQ;
  private HashMap<Integer, Class<? extends BaseTimeLineItem.BaseViewHolder>> AjR;
  public View.OnClickListener AjS;
  public View.OnClickListener AjT;
  public SnsPostDescPreloadTextView.b AjU;
  public View.OnClickListener AjV;
  public View.OnClickListener AjW;
  private HashMap<String, Boolean> AjX;
  private d AjY;
  public com.tencent.mm.ui.tools.l contextMenuHelper;
  public MMActivity fLP;
  private ListView gZb;
  protected ap handler;
  com.tencent.mm.sdk.b.c kwD;
  public com.tencent.mm.ui.widget.b.a nZK;
  protected int requestType;
  protected HashMap<String, Integer> zPM;
  public View.OnTouchListener zQU;
  public com.tencent.mm.plugin.sns.ui.d.c zpd;
  
  public bh(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.c paramc, i parami, final z paramz)
  {
    AppMethodBeat.i(99243);
    this.AjF = new LinkedList();
    this.AjG = new HashMap();
    this.Aae = false;
    this.Afj = 0;
    this.Afk = false;
    this.AjI = new PBool();
    this.AaQ = 0;
    this.AjJ = -1;
    this.AjK = 0;
    this.zPM = new HashMap();
    this.Afm = new HashMap();
    this.AjL = new HashMap();
    this.AjM = new HashMap();
    this.requestType = 0;
    this.handler = new ap();
    this.AjO = new HashMap();
    this.AjP = new HashMap();
    this.AjQ = 2;
    this.Abw = new com.tencent.mm.sdk.b.c() {};
    this.Abv = new com.tencent.mm.sdk.b.c() {};
    this.Abx = new com.tencent.mm.sdk.b.c() {};
    this.AjR = new HashMap();
    this.AjR.put(Integer.valueOf(6), l.a.class);
    this.AjR.put(Integer.valueOf(2), j.a.class);
    this.AjR.put(Integer.valueOf(3), j.a.class);
    this.AjR.put(Integer.valueOf(4), j.a.class);
    this.AjR.put(Integer.valueOf(5), j.a.class);
    this.AjR.put(Integer.valueOf(0), j.a.class);
    this.AjR.put(Integer.valueOf(1), j.a.class);
    this.AjR.put(Integer.valueOf(7), j.a.class);
    this.AjR.put(Integer.valueOf(8), j.a.class);
    this.AjR.put(Integer.valueOf(9), j.a.class);
    this.AjR.put(Integer.valueOf(11), m.b.class);
    this.AjR.put(Integer.valueOf(13), com.tencent.mm.plugin.sns.ui.item.a.a.class);
    this.AjR.put(Integer.valueOf(14), e.a.class);
    this.AjR.put(Integer.valueOf(15), k.a.class);
    this.AjR.put(Integer.valueOf(10), j.a.class);
    this.AjR.put(Integer.valueOf(12), j.a.class);
    this.AjR.put(Integer.valueOf(16), j.a.class);
    this.AjR.put(Integer.valueOf(17), g.a.class);
    this.AjR.put(Integer.valueOf(18), c.a.class);
    this.AjR.put(Integer.valueOf(19), com.tencent.mm.plugin.sns.ad.timeline.b.a.a.class);
    this.AjS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99228);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
        bh.this.AjE.zPe = false;
        com.tencent.mm.plugin.sns.abtest.a.dQX();
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          ad.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99228);
          return;
        }
        localObject = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.HAT.GaP == 21))
        {
          byo localbyo = ((BaseTimeLineItem.BaseViewHolder)localObject).zMQ;
          if ((!u.aAm().equals(((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.nDo)) && ((localbyo == null) || (localbyo.dNN == 0)))
          {
            com.tencent.mm.plugin.sns.lucky.ui.a.f(bh.this.fLP, ((BaseTimeLineItem.BaseViewHolder)localObject).Avw.Ra(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99228);
            return;
          }
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject).isAd) {
          com.tencent.mm.plugin.sns.ad.e.g.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(((BaseTimeLineItem.BaseViewHolder)localObject).doX, paramAnonymousView, bh.this.AjE.zPb));
        }
        if ((bh.this.fLP instanceof w)) {
          ((w)bh.this.fLP).fh(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99228);
      }
    };
    this.AjT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        paramAnonymousView = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (paramAnonymousView.isAd))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        if ((bh.this.zPM.containsKey(paramAnonymousView.doX)) && (((Integer)bh.this.zPM.get(paramAnonymousView.doX)).equals(Integer.valueOf(0))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        if ((bh.this.zPM.containsKey(paramAnonymousView.doX)) && (((Integer)bh.this.zPM.get(paramAnonymousView.doX)).equals(Integer.valueOf(1))))
        {
          bh.this.zPM.put(paramAnonymousView.doX, Integer.valueOf(2));
          bh.this.AjD.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        bh.this.zPM.put(paramAnonymousView.doX, Integer.valueOf(1));
        bh.this.AjD.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99229);
      }
    };
    this.AjU = new SnsPostDescPreloadTextView.b()
    {
      public final void ecO()
      {
        AppMethodBeat.i(198402);
        bh.this.AjD.notifyDataSetChanged();
        AppMethodBeat.o(198402);
      }
    };
    this.AjV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99231);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((!bh.this.Afk) || (bh.this.Afj <= 0))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99231);
          return;
        }
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99231);
          return;
        }
        paramAnonymousView = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99231);
          return;
        }
        ad.d("MicroMsg.SnsTimeLineBaseAdapter", "likeCollapListener onclick %s", new Object[] { paramAnonymousView.doX });
        if ((bh.this.Afm.containsKey(paramAnonymousView.doX)) && ((((Integer)bh.this.Afm.get(paramAnonymousView.doX)).equals(Integer.valueOf(1))) || (((Integer)bh.this.Afm.get(paramAnonymousView.doX)).equals(Integer.valueOf(3)))))
        {
          bh.this.Afm.put(paramAnonymousView.doX, Integer.valueOf(2));
          com.tencent.mm.plugin.sns.j.e.ztz.bQ(com.tencent.mm.plugin.sns.data.q.zw(paramAnonymousView.AuT), true);
        }
        for (;;)
        {
          bh.this.AjD.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99231);
          return;
          bh.this.Afm.put(paramAnonymousView.doX, Integer.valueOf(1));
          com.tencent.mm.plugin.sns.j.e.ztz.bQ(com.tencent.mm.plugin.sns.data.q.zw(paramAnonymousView.AuT), false);
        }
      }
    };
    this.AjW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198403);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousView.getParent() == null) || (!(paramAnonymousView.getParent() instanceof SnsCommentCollapseLayout)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198403);
          return;
        }
        if ((((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() == null) || (!(((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() instanceof m)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198403);
          return;
        }
        localObject = (m)((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag();
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198403);
          return;
        }
        try
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((m)localObject).hDa);
          paramAnonymousView.putExtra("sns_local_id", ((m)localObject).zPR);
          paramAnonymousView.putExtra("sns_comment_buf", ((m)localObject).zhw.toByteArray());
          paramAnonymousView.setClass(bh.this.fLP, SnsSingleTextViewUI.class);
          localObject = bh.this.fLP;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198403);
          return;
        }
        catch (IOException paramAnonymousView)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", paramAnonymousView, "commentCollapse click exception.", new Object[0]);
          }
        }
      }
    };
    this.zQU = bt.flQ();
    this.AjX = new HashMap();
    this.AjY = new d();
    this.kwD = new com.tencent.mm.sdk.b.c() {};
    this.AjD = paramz;
    this.AjE = parami;
    ad.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
    this.gZb = paramListView;
    ag.dUb();
    this.fLP = paramMMActivity;
    this.zpd = paramc;
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramMMActivity);
    this.nZK = new com.tencent.mm.ui.widget.b.a(paramMMActivity);
    this.AaN = new bb(paramMMActivity);
    this.AaG = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.AaG.setDuration(150L);
    this.AaH = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.AaH.setDuration(150L);
    this.AaS = new j(paramMMActivity, 0, parami.zPc);
    this.AjN = new l(parami);
    this.requestType = 10;
    this.AaW = new bo(paramMMActivity, new bo.a()
    {
      public final void dam()
      {
        AppMethodBeat.i(198404);
        paramz.notifyDataSetChanged();
        AppMethodBeat.o(198404);
      }
    }, 0, parami.zPc);
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE))
    {
      this.Afj = this.AjQ;
      this.Afk = true;
      com.tencent.mm.sdk.b.a.IbL.c(this.kwD);
      AppMethodBeat.o(99243);
      return;
    }
    for (;;)
    {
      try
      {
        this.Afj = bt.aRe(com.tencent.mm.plugin.expt.h.d.crP().gb(b.a.qBf.name(), "0"));
        if (bt.aRe(com.tencent.mm.plugin.expt.h.d.crP().gb(b.a.qBg.name(), "0")) != 1) {
          break label922;
        }
        bool = true;
        this.Afk = bool;
      }
      catch (NumberFormatException paramMMActivity)
      {
        ad.w("MicroMsg.SnsTimeLineBaseAdapter", "parse like collapse config error: %s", new Object[] { paramMMActivity.getMessage() });
      }
      break;
      label922:
      boolean bool = false;
    }
  }
  
  public static int R(p paramp)
  {
    AppMethodBeat.i(221351);
    int i = c(paramp, true);
    AppMethodBeat.o(221351);
    return i;
  }
  
  public static String a(TimeLineObject paramTimeLineObject, Context paramContext)
  {
    AppMethodBeat.i(99250);
    paramTimeLineObject = com.tencent.mm.plugin.sns.c.a.iRH.e(paramContext, paramTimeLineObject.HAS.Id, "timeline");
    AppMethodBeat.o(99250);
    return paramTimeLineObject;
  }
  
  public static String aAS(String paramString)
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
  
  public static String aAT(String paramString)
  {
    AppMethodBeat.i(99251);
    ad.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.iRH.Q(paramString, "timeline");
    AppMethodBeat.o(99251);
    return paramString;
  }
  
  protected static int c(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(99247);
    TimeLineObject localTimeLineObject = paramp.dYl();
    if (localTimeLineObject.HAT.GaP == 1)
    {
      if ((paramBoolean) && (localTimeLineObject.ePo == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramp.QM(32)) && (paramp.dRL() != null))
      {
        if (paramp.dRL().dVZ())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dWa())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dWb())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
      }
      int i = localTimeLineObject.HAT.GaQ.size();
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
    switch (localTimeLineObject.HAT.GaP)
    {
    default: 
      AppMethodBeat.o(99247);
      return 1;
    case 4: 
      AppMethodBeat.o(99247);
      return 0;
    case 5: 
      if ((paramp.QM(32)) && (paramp.dRL() != null))
      {
        if (paramp.dRL().dVZ())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dWa())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dWb())
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
      if ((paramBoolean) && (localTimeLineObject.HBa == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramp.QM(32)) && (paramp.dRL() != null))
      {
        if (paramp.dRL().dVZ())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dWa())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dWb())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
        AppMethodBeat.o(99247);
        return 19;
      }
      AppMethodBeat.o(99247);
      return 9;
    case 21: 
      AppMethodBeat.o(99247);
      return 10;
    case 27: 
      AppMethodBeat.o(99247);
      return 11;
    case 29: 
      AppMethodBeat.o(99247);
      return 16;
    case 33: 
      AppMethodBeat.o(99247);
      return 17;
    }
    AppMethodBeat.o(99247);
    return 18;
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(99241);
    this.AjD.notifyDataSetChanged();
    AppMethodBeat.o(99241);
  }
  
  public final void E(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(99253);
    a locala = (a)this.AjL.get(paramString);
    if ((locala != null) && (bt.lQ(locala.getKey(), paramString))) {
      locala.rS(paramBoolean);
    }
    AppMethodBeat.o(99253);
  }
  
  public final p QT(int paramInt)
  {
    AppMethodBeat.i(99257);
    p localp = this.AjD.QT(paramInt);
    AppMethodBeat.o(99257);
    return localp;
  }
  
  public final boolean QU(int paramInt)
  {
    AppMethodBeat.i(99259);
    if ((paramInt < this.gZb.getFirstVisiblePosition() - 1) || (paramInt > this.gZb.getLastVisiblePosition() - 1))
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
    this.AjF.add(paramSnsCommentCollapseLayout);
    AppMethodBeat.o(99239);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(99254);
    if (parama != null) {
      this.AjL.put(paramString, parama);
    }
    AppMethodBeat.o(99254);
  }
  
  public final void at(Runnable paramRunnable)
  {
    AppMethodBeat.i(99252);
    this.AjD.dZO();
    paramRunnable.run();
    AppMethodBeat.o(99252);
  }
  
  public final void ecF()
  {
    AppMethodBeat.i(99237);
    this.zPM.clear();
    this.Afm.clear();
    AppMethodBeat.o(99237);
  }
  
  public final w ecG()
  {
    if ((this.fLP instanceof w)) {
      return (w)this.fLP;
    }
    return null;
  }
  
  public final SnsCommentCollapseLayout ecH()
  {
    AppMethodBeat.i(99238);
    if (this.AjF.size() == 0)
    {
      localSnsCommentCollapseLayout = new SnsCommentCollapseLayout(this.fLP);
      AppMethodBeat.o(99238);
      return localSnsCommentCollapseLayout;
    }
    SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.AjF.removeFirst();
    AppMethodBeat.o(99238);
    return localSnsCommentCollapseLayout;
  }
  
  public final boolean ecI()
  {
    AppMethodBeat.i(99240);
    if (this.AjF != null) {
      this.AjF.clear();
    }
    if (this.AjR != null) {
      this.AjR.clear();
    }
    com.tencent.mm.pluginsdk.ui.span.k.clearCache();
    com.tencent.mm.kiss.widget.textview.c.gEJ.akE();
    if (this.AjI.value) {
      ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBg, 0);
    }
    AppMethodBeat.o(99240);
    return true;
  }
  
  public final void ecJ()
  {
    AppMethodBeat.i(99242);
    this.AjD.dZO();
    AppMethodBeat.o(99242);
  }
  
  public final void ecK()
  {
    AppMethodBeat.i(99244);
    int i = this.gZb.getFirstVisiblePosition() - this.gZb.getHeaderViewsCount();
    int j = this.gZb.getLastVisiblePosition() - this.gZb.getHeaderViewsCount();
    ad.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + i + " " + j);
    int k = this.AjD.getCount();
    if ((i <= j) && (i < k))
    {
      p localp = QT(i);
      Object localObject = (View)this.AjM.get(Integer.valueOf(i));
      if ((localObject == null) || (localp == null) || (((View)localObject).getTag() == null)) {
        ad.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        ad.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).position);
        ((BaseTimeLineItem.BaseViewHolder)localObject).AvW.a((BaseTimeLineItem.BaseViewHolder)localObject, i, localp);
      }
    }
    AppMethodBeat.o(99244);
  }
  
  public final z ecL()
  {
    return this.AjD;
  }
  
  public final void ecM()
  {
    AppMethodBeat.i(99255);
    this.AjL.clear();
    AppMethodBeat.o(99255);
  }
  
  public final com.tencent.mm.ui.widget.b.a ecN()
  {
    AppMethodBeat.i(99260);
    if (this.nZK != null) {
      this.nZK.fBg();
    }
    this.nZK = new com.tencent.mm.ui.widget.b.a(this.fLP);
    com.tencent.mm.ui.widget.b.a locala = this.nZK;
    AppMethodBeat.o(99260);
    return locala;
  }
  
  public final void fk(View paramView)
  {
    AppMethodBeat.i(99256);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      AppMethodBeat.o(99256);
      return;
    }
    ad.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
    if ((this.AjH != null) && (this.AjH.getVisibility() == 0))
    {
      this.AjH.startAnimation(this.AaH);
      this.AaH.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(198399);
          if (bh.this.AjH != null)
          {
            bh.this.AjH.clearAnimation();
            bh.this.AjH.setVisibility(8);
          }
          bh.this.AjH = null;
          AppMethodBeat.o(198399);
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
    int i = this.AjD.getCount();
    AppMethodBeat.o(99258);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99246);
    paramInt = c(this.AjD.QT(paramInt), true);
    AppMethodBeat.o(99246);
    return paramInt;
  }
  
  public final View m(int paramInt, View paramView)
  {
    AppMethodBeat.i(99245);
    p localp = this.AjD.QT(paramInt);
    TimeLineObject localTimeLineObject = localp.dYl();
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
        break label442;
      }
      i = ((Integer)localObject2).intValue();
      localObject4 = localObject1;
      localObject2 = localObject3;
      if (i == j)
      {
        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        localObject4 = ((BaseTimeLineItem.BaseViewHolder)localObject2).AvW;
      }
    }
    localObject1 = localObject2;
    localObject3 = paramView;
    if (localObject2 == null) {
      switch (j)
      {
      default: 
        localObject1 = new com.tencent.mm.plugin.sns.ui.item.i();
      }
    }
    for (;;)
    {
      for (;;)
      {
        Iterator localIterator;
        Object localObject6;
        label442:
        try
        {
          if (this.AjR.get(Integer.valueOf(j)) != null)
          {
            localObject3 = (BaseTimeLineItem.BaseViewHolder)((Class)this.AjR.get(Integer.valueOf(j))).newInstance();
            localObject2 = localObject3;
            localObject3 = paramView;
          }
        }
        catch (Exception localException1) {}
        try
        {
          ((BaseTimeLineItem.BaseViewHolder)localObject2).AvW = ((BaseTimeLineItem)localObject1);
          localObject3 = paramView;
          ((BaseTimeLineItem.BaseViewHolder)localObject2).timeLineObject = localTimeLineObject;
          localObject3 = paramView;
          paramView = ((BaseTimeLineItem)localObject1).a(this.fLP, (BaseTimeLineItem.BaseViewHolder)localObject2, j, this, localp);
          localObject3 = paramView;
          paramView.setTag(2131304989, Integer.valueOf(j));
          localObject4 = localObject1;
          localObject3 = paramView;
          localObject1 = localObject2;
          ((BaseTimeLineItem)localObject4).setIsFromMainTimeline(this.Aae);
          paramView = localp.getSnsId();
          localObject2 = new ArrayList();
          if (ar.dUO().size() <= 0) {
            break label698;
          }
          localIterator = ar.dUO().keySet().iterator();
          if (!localIterator.hasNext()) {
            break label698;
          }
          localObject6 = (String)localIterator.next();
          if (((String)localObject6).startsWith(paramView))
          {
            localObject6 = (ar.b)ar.dUO().get(localObject6);
            if (ar.c((ar.b)localObject6))
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
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.l();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.j();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.j();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.j();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.j();
      continue;
      localObject1 = new h();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.i();
      continue;
      localObject1 = new n();
      continue;
      localObject1 = new f();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.m();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.e();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.k();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.g();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.c();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.b.a();
      continue;
      localObject3 = new j.a();
      localObject2 = localObject3;
      continue;
      ad.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", localException1, "create holder error", new Object[0]);
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject3 = paramView;
    }
    label698:
    localObject5.AuQ = ((ArrayList)localObject2);
    localObject5.a((BaseTimeLineItem.BaseViewHolder)localObject1, paramInt, localp, localTimeLineObject, j, this);
    if (ar.eV(localp.getSnsId(), 2))
    {
      paramView = ar.azc(localp.getSnsId());
      if (localp.field_snsId == 0L) {
        paramView = new ar.b();
      }
      if (paramView.hII) {
        if (!paramView.aGQ) {
          BaseTimeLineItem.a(paramView, (BaseTimeLineItem.BaseViewHolder)localObject1, paramView.result, paramView.hQG);
        }
      }
    }
    for (;;)
    {
      this.AjM.put(Integer.valueOf(paramInt), localObject3);
      AppMethodBeat.o(99245);
      return localObject3;
      BaseTimeLineItem.j((BaseTimeLineItem.BaseViewHolder)localObject1);
      ar.eU(paramView.id, 2);
      continue;
      BaseTimeLineItem.i((BaseTimeLineItem.BaseViewHolder)localObject1);
      continue;
      BaseTimeLineItem.j((BaseTimeLineItem.BaseViewHolder)localObject1);
    }
  }
  
  public static abstract interface a
  {
    public abstract String getKey();
    
    public abstract void rS(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract boolean ecP();
  }
  
  public static final class c
    implements as.b.a
  {
    z Akc = null;
    int mPosition;
    
    public c(z paramz, int paramInt)
    {
      this.Akc = paramz;
      this.mPosition = paramInt;
    }
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(99235);
      if (paramBoolean)
      {
        com.tencent.mm.kernel.g.ajD();
        if (com.tencent.mm.kernel.g.ajA().aiK()) {
          ag.cVf().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(99234);
              if (bh.c.this.Akc.dZP() != null) {
                bh.c.this.Akc.dZP().request(Integer.valueOf(bh.c.this.mPosition));
              }
              bh.c.this.Akc.notifyDataSetChanged();
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
    private String drH;
    private View targetView;
    private String url;
    private p yXF;
    private TimeLineObject zQl;
    private byn zhs;
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(99236);
      paramContextMenuInfo = paramView.getTag();
      if ((paramContextMenuInfo instanceof s))
      {
        paramContextMenuInfo = (s)paramContextMenuInfo;
        TimeLineObject localTimeLineObject = paramContextMenuInfo.zQl;
        paramView.getContext();
        String str = bh.aAT(localTimeLineObject.HAT.Url);
        if ((str == null) || (str.length() == 0))
        {
          AppMethodBeat.o(99236);
          return;
        }
        this.url = str;
        this.drH = paramContextMenuInfo.doX;
        this.targetView = paramView;
        if (localTimeLineObject.HAT.GaQ.size() > 0) {}
        for (paramContextMenuInfo = (byn)localTimeLineObject.HAT.GaQ.get(0);; paramContextMenuInfo = null)
        {
          this.zhs = paramContextMenuInfo;
          this.yXF = ag.dUe().aAa(this.drH);
          this.zQl = localTimeLineObject;
          if ((localTimeLineObject.HAT.GaP != 10) && (localTimeLineObject.HAT.GaP != 13)) {
            break;
          }
          AppMethodBeat.o(99236);
          return;
        }
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          switch (localTimeLineObject.HAT.GaP)
          {
          default: 
            paramContextMenu.add(0, 3, 0, paramView.getContext().getString(2131761941));
          }
        }
      }
      for (;;)
      {
        if ((this.yXF != null) && (!this.yXF.field_userName.equals(ag.dTJ()))) {
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bh
 * JD-Core Version:    0.7.0.1
 */