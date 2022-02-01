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
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.as.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
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
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  protected z AAP;
  public i AAQ;
  protected LinkedList<SnsCommentCollapseLayout> AAR;
  public HashMap<Integer, WeakReference<View>> AAS;
  View AAT;
  public PBool AAU;
  public int AAV;
  int AAW;
  protected HashMap<String, a> AAX;
  protected HashMap<Integer, View> AAY;
  public l AAZ;
  private Map<Integer, WeakReference<SnsCommentPreloadTextView>> ABa;
  public HashMap<String, String> ABb;
  private int ABc;
  private HashMap<Integer, Class<? extends BaseTimeLineItem.BaseViewHolder>> ABd;
  public View.OnClickListener ABe;
  public View.OnClickListener ABf;
  public SnsPostDescPreloadTextView.b ABg;
  public View.OnClickListener ABh;
  public View.OnClickListener ABi;
  private HashMap<String, Boolean> ABj;
  private d ABk;
  protected HashMap<String, Integer> AgT;
  public View.OnTouchListener Aib;
  protected ScaleAnimation ArT;
  protected ScaleAnimation ArU;
  public boolean Arr;
  com.tencent.mm.sdk.b.c AsI;
  com.tencent.mm.sdk.b.c AsJ;
  com.tencent.mm.sdk.b.c AsK;
  public bb Asa;
  private int Asd;
  public j Asf;
  public bo Asj;
  public int Awv;
  public boolean Aww;
  protected HashMap<String, Integer> Awy;
  public com.tencent.mm.ui.tools.l contextMenuHelper;
  public MMActivity fNT;
  protected aq handler;
  private ListView hbO;
  com.tencent.mm.sdk.b.c kzS;
  public com.tencent.mm.ui.widget.b.a ofu;
  protected int requestType;
  public com.tencent.mm.plugin.sns.ui.d.c zGs;
  
  public bh(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.c paramc, i parami, final z paramz)
  {
    AppMethodBeat.i(99243);
    this.AAR = new LinkedList();
    this.AAS = new HashMap();
    this.Arr = false;
    this.Awv = 0;
    this.Aww = false;
    this.AAU = new PBool();
    this.Asd = 0;
    this.AAV = -1;
    this.AAW = 0;
    this.AgT = new HashMap();
    this.Awy = new HashMap();
    this.AAX = new HashMap();
    this.AAY = new HashMap();
    this.requestType = 0;
    this.handler = new aq();
    this.ABa = new HashMap();
    this.ABb = new HashMap();
    this.ABc = 2;
    this.AsJ = new com.tencent.mm.sdk.b.c() {};
    this.AsI = new com.tencent.mm.sdk.b.c() {};
    this.AsK = new com.tencent.mm.sdk.b.c() {};
    this.ABd = new HashMap();
    this.ABd.put(Integer.valueOf(6), l.a.class);
    this.ABd.put(Integer.valueOf(2), j.a.class);
    this.ABd.put(Integer.valueOf(3), j.a.class);
    this.ABd.put(Integer.valueOf(4), j.a.class);
    this.ABd.put(Integer.valueOf(5), j.a.class);
    this.ABd.put(Integer.valueOf(0), j.a.class);
    this.ABd.put(Integer.valueOf(1), j.a.class);
    this.ABd.put(Integer.valueOf(7), j.a.class);
    this.ABd.put(Integer.valueOf(8), j.a.class);
    this.ABd.put(Integer.valueOf(9), j.a.class);
    this.ABd.put(Integer.valueOf(11), m.b.class);
    this.ABd.put(Integer.valueOf(13), com.tencent.mm.plugin.sns.ui.item.a.a.class);
    this.ABd.put(Integer.valueOf(14), e.a.class);
    this.ABd.put(Integer.valueOf(15), k.a.class);
    this.ABd.put(Integer.valueOf(10), j.a.class);
    this.ABd.put(Integer.valueOf(12), j.a.class);
    this.ABd.put(Integer.valueOf(16), j.a.class);
    this.ABd.put(Integer.valueOf(17), g.a.class);
    this.ABd.put(Integer.valueOf(18), c.a.class);
    this.ABd.put(Integer.valueOf(19), com.tencent.mm.plugin.sns.ad.timeline.b.a.a.class);
    this.ABe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99228);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
        bh.this.AAQ.Agl = false;
        com.tencent.mm.plugin.sns.abtest.a.dUu();
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          ae.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99228);
          return;
        }
        localObject = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.HUG.Gtw == 21))
        {
          bzi localbzi = ((BaseTimeLineItem.BaseViewHolder)localObject).AdX;
          if ((!v.aAC().equals(((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.nIJ)) && ((localbzi == null) || (localbzi.dPd == 0)))
          {
            com.tencent.mm.plugin.sns.lucky.ui.a.f(bh.this.fNT, ((BaseTimeLineItem.BaseViewHolder)localObject).AMM.RH(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99228);
            return;
          }
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject).isAd) {
          com.tencent.mm.plugin.sns.ad.f.g.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(((BaseTimeLineItem.BaseViewHolder)localObject).dqc, paramAnonymousView, bh.this.AAQ.Agi));
        }
        if ((bh.this.fNT instanceof w)) {
          ((w)bh.this.fNT).fg(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99228);
      }
    };
    this.ABf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        if ((bh.this.AgT.containsKey(paramAnonymousView.dqc)) && (((Integer)bh.this.AgT.get(paramAnonymousView.dqc)).equals(Integer.valueOf(0))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        if ((bh.this.AgT.containsKey(paramAnonymousView.dqc)) && (((Integer)bh.this.AgT.get(paramAnonymousView.dqc)).equals(Integer.valueOf(1))))
        {
          bh.this.AgT.put(paramAnonymousView.dqc, Integer.valueOf(2));
          bh.this.AAP.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        bh.this.AgT.put(paramAnonymousView.dqc, Integer.valueOf(1));
        bh.this.AAP.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99229);
      }
    };
    this.ABg = new SnsPostDescPreloadTextView.b()
    {
      public final void egv()
      {
        AppMethodBeat.i(219944);
        bh.this.AAP.notifyDataSetChanged();
        AppMethodBeat.o(219944);
      }
    };
    this.ABh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99231);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((!bh.this.Aww) || (bh.this.Awv <= 0))
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
        ae.d("MicroMsg.SnsTimeLineBaseAdapter", "likeCollapListener onclick %s", new Object[] { paramAnonymousView.dqc });
        if ((bh.this.Awy.containsKey(paramAnonymousView.dqc)) && ((((Integer)bh.this.Awy.get(paramAnonymousView.dqc)).equals(Integer.valueOf(1))) || (((Integer)bh.this.Awy.get(paramAnonymousView.dqc)).equals(Integer.valueOf(3)))))
        {
          bh.this.Awy.put(paramAnonymousView.dqc, Integer.valueOf(2));
          com.tencent.mm.plugin.sns.j.e.zKO.bU(r.zV(paramAnonymousView.AMj), true);
        }
        for (;;)
        {
          bh.this.AAP.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99231);
          return;
          bh.this.Awy.put(paramAnonymousView.dqc, Integer.valueOf(1));
          com.tencent.mm.plugin.sns.j.e.zKO.bU(r.zV(paramAnonymousView.AMj), false);
        }
      }
    };
    this.ABi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219945);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousView.getParent() == null) || (!(paramAnonymousView.getParent() instanceof SnsCommentCollapseLayout)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219945);
          return;
        }
        if ((((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() == null) || (!(((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() instanceof m)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219945);
          return;
        }
        localObject = (m)((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag();
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219945);
          return;
        }
        try
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((m)localObject).hFS);
          paramAnonymousView.putExtra("sns_local_id", ((m)localObject).AgY);
          paramAnonymousView.putExtra("sns_comment_buf", ((m)localObject).zyl.toByteArray());
          paramAnonymousView.setClass(bh.this.fNT, SnsSingleTextViewUI.class);
          localObject = bh.this.fNT;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219945);
          return;
        }
        catch (IOException paramAnonymousView)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", paramAnonymousView, "commentCollapse click exception.", new Object[0]);
          }
        }
      }
    };
    this.Aib = bu.fpL();
    this.ABj = new HashMap();
    this.ABk = new d();
    this.kzS = new com.tencent.mm.sdk.b.c() {};
    this.AAP = paramz;
    this.AAQ = parami;
    ae.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
    this.hbO = paramListView;
    ah.dXB();
    this.fNT = paramMMActivity;
    this.zGs = paramc;
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramMMActivity);
    this.ofu = new com.tencent.mm.ui.widget.b.a(paramMMActivity);
    this.Asa = new bb(paramMMActivity);
    this.ArT = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.ArT.setDuration(150L);
    this.ArU = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.ArU.setDuration(150L);
    this.Asf = new j(paramMMActivity, 0, parami.Agj);
    this.AAZ = new l(parami);
    this.requestType = 10;
    this.Asj = new bo(paramMMActivity, new bo.a()
    {
      public final void dcY()
      {
        AppMethodBeat.i(219946);
        paramz.notifyDataSetChanged();
        AppMethodBeat.o(219946);
      }
    }, 0, parami.Agj);
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE))
    {
      this.Awv = this.ABc;
      this.Aww = true;
      com.tencent.mm.sdk.b.a.IvT.c(this.kzS);
      AppMethodBeat.o(99243);
      return;
    }
    for (;;)
    {
      try
      {
        this.Awv = bu.aSB(com.tencent.mm.plugin.expt.h.d.ctr().gg(b.a.qIy.name(), "0"));
        if (bu.aSB(com.tencent.mm.plugin.expt.h.d.ctr().gg(b.a.qIz.name(), "0")) != 1) {
          break label922;
        }
        bool = true;
        this.Aww = bool;
      }
      catch (NumberFormatException paramMMActivity)
      {
        ae.w("MicroMsg.SnsTimeLineBaseAdapter", "parse like collapse config error: %s", new Object[] { paramMMActivity.getMessage() });
      }
      break;
      label922:
      boolean bool = false;
    }
  }
  
  public static int R(p paramp)
  {
    AppMethodBeat.i(224109);
    int i = c(paramp, true);
    AppMethodBeat.o(224109);
    return i;
  }
  
  public static String a(TimeLineObject paramTimeLineObject, Context paramContext)
  {
    AppMethodBeat.i(99250);
    paramTimeLineObject = com.tencent.mm.plugin.sns.c.a.iUA.e(paramContext, paramTimeLineObject.HUF.Id, "timeline");
    AppMethodBeat.o(99250);
    return paramTimeLineObject;
  }
  
  public static String aCj(String paramString)
  {
    AppMethodBeat.i(99249);
    if (bu.isNullOrNil(paramString))
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
  
  public static String aCk(String paramString)
  {
    AppMethodBeat.i(99251);
    ae.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.iUA.Q(paramString, "timeline");
    AppMethodBeat.o(99251);
    return paramString;
  }
  
  protected static int c(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(99247);
    TimeLineObject localTimeLineObject = paramp.ebP();
    if (localTimeLineObject.HUG.Gtw == 1)
    {
      if ((paramBoolean) && (localTimeLineObject.eQZ == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramp.Rt(32)) && (paramp.dVj() != null))
      {
        if (paramp.dVj().dZA())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dZB())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dZC())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
      }
      int i = localTimeLineObject.HUG.Gtx.size();
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
    switch (localTimeLineObject.HUG.Gtw)
    {
    default: 
      AppMethodBeat.o(99247);
      return 1;
    case 4: 
      AppMethodBeat.o(99247);
      return 0;
    case 5: 
      if ((paramp.Rt(32)) && (paramp.dVj() != null))
      {
        if (paramp.dVj().dZA())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dZB())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dZC())
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
      if ((paramBoolean) && (localTimeLineObject.HUN == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramp.Rt(32)) && (paramp.dVj() != null))
      {
        if (paramp.dVj().dZA())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramp.dZB())
        {
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramp.dZC())
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
    this.AAP.notifyDataSetChanged();
    AppMethodBeat.o(99241);
  }
  
  public final void G(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(99253);
    a locala = (a)this.AAX.get(paramString);
    if ((locala != null) && (bu.lX(locala.getKey(), paramString))) {
      locala.rZ(paramBoolean);
    }
    AppMethodBeat.o(99253);
  }
  
  public final p RA(int paramInt)
  {
    AppMethodBeat.i(99257);
    p localp = this.AAP.RA(paramInt);
    AppMethodBeat.o(99257);
    return localp;
  }
  
  public final boolean RB(int paramInt)
  {
    AppMethodBeat.i(99259);
    if ((paramInt < this.hbO.getFirstVisiblePosition() - 1) || (paramInt > this.hbO.getLastVisiblePosition() - 1))
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
    this.AAR.add(paramSnsCommentCollapseLayout);
    AppMethodBeat.o(99239);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(99254);
    if (parama != null) {
      this.AAX.put(paramString, parama);
    }
    AppMethodBeat.o(99254);
  }
  
  public final void ar(Runnable paramRunnable)
  {
    AppMethodBeat.i(99252);
    this.AAP.edu();
    paramRunnable.run();
    AppMethodBeat.o(99252);
  }
  
  public final void egm()
  {
    AppMethodBeat.i(99237);
    this.AgT.clear();
    this.Awy.clear();
    AppMethodBeat.o(99237);
  }
  
  public final w egn()
  {
    if ((this.fNT instanceof w)) {
      return (w)this.fNT;
    }
    return null;
  }
  
  public final SnsCommentCollapseLayout ego()
  {
    AppMethodBeat.i(99238);
    if (this.AAR.size() == 0)
    {
      localSnsCommentCollapseLayout = new SnsCommentCollapseLayout(this.fNT);
      AppMethodBeat.o(99238);
      return localSnsCommentCollapseLayout;
    }
    SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.AAR.removeFirst();
    AppMethodBeat.o(99238);
    return localSnsCommentCollapseLayout;
  }
  
  public final boolean egp()
  {
    AppMethodBeat.i(99240);
    if (this.AAR != null) {
      this.AAR.clear();
    }
    if (this.ABd != null) {
      this.ABd.clear();
    }
    com.tencent.mm.pluginsdk.ui.span.k.clearCache();
    com.tencent.mm.kiss.widget.textview.c.gHq.akT();
    if (this.AAU.value) {
      ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIz, 0);
    }
    AppMethodBeat.o(99240);
    return true;
  }
  
  public final void egq()
  {
    AppMethodBeat.i(99242);
    this.AAP.edu();
    AppMethodBeat.o(99242);
  }
  
  public final void egr()
  {
    AppMethodBeat.i(99244);
    int i = this.hbO.getFirstVisiblePosition() - this.hbO.getHeaderViewsCount();
    int j = this.hbO.getLastVisiblePosition() - this.hbO.getHeaderViewsCount();
    ae.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + i + " " + j);
    int k = this.AAP.getCount();
    if ((i <= j) && (i < k))
    {
      p localp = RA(i);
      Object localObject = (View)this.AAY.get(Integer.valueOf(i));
      if ((localObject == null) || (localp == null) || (((View)localObject).getTag() == null)) {
        ae.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        ae.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).position);
        ((BaseTimeLineItem.BaseViewHolder)localObject).ANn.a((BaseTimeLineItem.BaseViewHolder)localObject, i, localp);
      }
    }
    AppMethodBeat.o(99244);
  }
  
  public final z egs()
  {
    return this.AAP;
  }
  
  public final void egt()
  {
    AppMethodBeat.i(99255);
    this.AAX.clear();
    AppMethodBeat.o(99255);
  }
  
  public final com.tencent.mm.ui.widget.b.a egu()
  {
    AppMethodBeat.i(99260);
    if (this.ofu != null) {
      this.ofu.fFi();
    }
    this.ofu = new com.tencent.mm.ui.widget.b.a(this.fNT);
    com.tencent.mm.ui.widget.b.a locala = this.ofu;
    AppMethodBeat.o(99260);
    return locala;
  }
  
  public final void fj(View paramView)
  {
    AppMethodBeat.i(99256);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      AppMethodBeat.o(99256);
      return;
    }
    ae.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
    if ((this.AAT != null) && (this.AAT.getVisibility() == 0))
    {
      this.AAT.startAnimation(this.ArU);
      this.ArU.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(219941);
          if (bh.this.AAT != null)
          {
            bh.this.AAT.clearAnimation();
            bh.this.AAT.setVisibility(8);
          }
          bh.this.AAT = null;
          AppMethodBeat.o(219941);
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
    int i = this.AAP.getCount();
    AppMethodBeat.o(99258);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99246);
    paramInt = c(this.AAP.RA(paramInt), true);
    AppMethodBeat.o(99246);
    return paramInt;
  }
  
  public final View m(int paramInt, View paramView)
  {
    AppMethodBeat.i(99245);
    p localp = this.AAP.RA(paramInt);
    TimeLineObject localTimeLineObject = localp.ebP();
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
        localObject4 = ((BaseTimeLineItem.BaseViewHolder)localObject2).ANn;
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
          if (this.ABd.get(Integer.valueOf(j)) != null)
          {
            localObject3 = (BaseTimeLineItem.BaseViewHolder)((Class)this.ABd.get(Integer.valueOf(j))).newInstance();
            localObject2 = localObject3;
            localObject3 = paramView;
          }
        }
        catch (Exception localException1) {}
        try
        {
          ((BaseTimeLineItem.BaseViewHolder)localObject2).ANn = ((BaseTimeLineItem)localObject1);
          localObject3 = paramView;
          ((BaseTimeLineItem.BaseViewHolder)localObject2).timeLineObject = localTimeLineObject;
          localObject3 = paramView;
          paramView = ((BaseTimeLineItem)localObject1).a(this.fNT, (BaseTimeLineItem.BaseViewHolder)localObject2, j, this, localp);
          localObject3 = paramView;
          paramView.setTag(2131304989, Integer.valueOf(j));
          localObject4 = localObject1;
          localObject3 = paramView;
          localObject1 = localObject2;
          ((BaseTimeLineItem)localObject4).setIsFromMainTimeline(this.Arr);
          paramView = localp.getSnsId();
          localObject2 = new ArrayList();
          if (as.dYo().size() <= 0) {
            break label698;
          }
          localIterator = as.dYo().keySet().iterator();
          if (!localIterator.hasNext()) {
            break label698;
          }
          localObject6 = (String)localIterator.next();
          if (((String)localObject6).startsWith(paramView))
          {
            localObject6 = (as.b)as.dYo().get(localObject6);
            if (as.c((as.b)localObject6))
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
      ae.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", localException1, "create holder error", new Object[0]);
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject3 = paramView;
    }
    label698:
    localObject5.AMg = ((ArrayList)localObject2);
    localObject5.a((BaseTimeLineItem.BaseViewHolder)localObject1, paramInt, localp, localTimeLineObject, j, this);
    if (as.fe(localp.getSnsId(), 2))
    {
      paramView = as.aAt(localp.getSnsId());
      if (localp.field_snsId == 0L) {
        paramView = new as.b();
      }
      if (paramView.hLB) {
        if (!paramView.aGQ) {
          BaseTimeLineItem.a(paramView, (BaseTimeLineItem.BaseViewHolder)localObject1, paramView.result, paramView.hTy);
        }
      }
    }
    for (;;)
    {
      this.AAY.put(Integer.valueOf(paramInt), localObject3);
      AppMethodBeat.o(99245);
      return localObject3;
      BaseTimeLineItem.j((BaseTimeLineItem.BaseViewHolder)localObject1);
      as.fd(paramView.id, 2);
      continue;
      BaseTimeLineItem.i((BaseTimeLineItem.BaseViewHolder)localObject1);
      continue;
      BaseTimeLineItem.j((BaseTimeLineItem.BaseViewHolder)localObject1);
    }
  }
  
  public static abstract interface a
  {
    public abstract String getKey();
    
    public abstract void rZ(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract boolean egw();
  }
  
  public static final class c
    implements au.b.a
  {
    z ABo = null;
    int mPosition;
    
    public c(z paramz, int paramInt)
    {
      this.ABo = paramz;
      this.mPosition = paramInt;
    }
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(99235);
      if (paramBoolean)
      {
        com.tencent.mm.kernel.g.ajS();
        if (com.tencent.mm.kernel.g.ajP().aiZ()) {
          ah.cXK().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(99234);
              if (bh.c.this.ABo.edv() != null) {
                bh.c.this.ABo.edv().request(Integer.valueOf(bh.c.this.mPosition));
              }
              bh.c.this.ABo.notifyDataSetChanged();
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
    private TimeLineObject Ahs;
    private String dsN;
    private View targetView;
    private String url;
    private p znm;
    private bzh zyh;
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(99236);
      paramContextMenuInfo = paramView.getTag();
      if ((paramContextMenuInfo instanceof s))
      {
        paramContextMenuInfo = (s)paramContextMenuInfo;
        TimeLineObject localTimeLineObject = paramContextMenuInfo.Ahs;
        paramView.getContext();
        String str = bh.aCk(localTimeLineObject.HUG.Url);
        if ((str == null) || (str.length() == 0))
        {
          AppMethodBeat.o(99236);
          return;
        }
        this.url = str;
        this.dsN = paramContextMenuInfo.dqc;
        this.targetView = paramView;
        if (localTimeLineObject.HUG.Gtx.size() > 0) {}
        for (paramContextMenuInfo = (bzh)localTimeLineObject.HUG.Gtx.get(0);; paramContextMenuInfo = null)
        {
          this.zyh = paramContextMenuInfo;
          this.znm = ah.dXE().aBr(this.dsN);
          this.Ahs = localTimeLineObject;
          if ((localTimeLineObject.HUG.Gtw != 10) && (localTimeLineObject.HUG.Gtw != 13)) {
            break;
          }
          AppMethodBeat.o(99236);
          return;
        }
        if (com.tencent.mm.br.d.aJN("favorite")) {
          switch (localTimeLineObject.HUG.Gtw)
          {
          default: 
            paramContextMenu.add(0, 3, 0, paramView.getContext().getString(2131761941));
          }
        }
      }
      for (;;)
      {
        if ((this.znm != null) && (!this.znm.field_userName.equals(ah.dXj()))) {
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