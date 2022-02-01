package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.item.e.a;
import com.tencent.mm.plugin.sns.ui.item.f.a;
import com.tencent.mm.plugin.sns.ui.item.g;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.item.i.a;
import com.tencent.mm.plugin.sns.ui.item.j.a;
import com.tencent.mm.plugin.sns.ui.item.k;
import com.tencent.mm.plugin.sns.ui.item.m.a;
import com.tencent.mm.plugin.sns.ui.item.n;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.plugin.sns.ui.item.o;
import com.tencent.mm.plugin.sns.ui.item.o.a;
import com.tencent.mm.plugin.sns.ui.item.p.b;
import com.tencent.mm.plugin.sns.ui.item.q;
import com.tencent.mm.plugin.sns.ui.item.r;
import com.tencent.mm.plugin.sns.ui.item.r.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class bn
  implements af
{
  private IListener Akp;
  private int Gix;
  public com.tencent.mm.plugin.sns.ui.listener.c QBf;
  protected HashMap<String, Integer> Rcg;
  public View.OnTouchListener Rdy;
  protected ScaleAnimation RoC;
  protected ScaleAnimation RoD;
  public bh RoJ;
  public j RoO;
  public bv RoS;
  public boolean Roa;
  private IListener Rpq;
  private IListener Rpr;
  private IListener Rps;
  int Rqq;
  public int RtB;
  public boolean RtC;
  protected HashMap<String, Integer> RtE;
  private int RyA;
  public boolean RyB;
  private boolean RyC;
  private Set<String> RyD;
  private HashMap<Integer, Class<? extends BaseTimeLineItem.BaseViewHolder>> RyE;
  public View.OnClickListener RyF;
  public View.OnClickListener RyG;
  public SnsPostDescPreloadTextView.b RyH;
  public View.OnClickListener RyI;
  public View.OnClickListener RyJ;
  private HashMap<String, Boolean> RyK;
  private bn.d RyL;
  protected ad Ryo;
  public i Ryp;
  protected LinkedList<SnsCommentCollapseLayout> Ryq;
  public HashMap<Integer, WeakReference<View>> Ryr;
  View Rys;
  public PBool Ryt;
  public int Ryu;
  protected HashMap<String, a> Ryv;
  protected HashMap<Integer, View> Ryw;
  public l Ryx;
  private Map<Integer, WeakReference<SnsCommentPreloadTextView>> Ryy;
  public HashMap<String, String> Ryz;
  public com.tencent.mm.ui.tools.l contextMenuHelper;
  protected MMHandler handler;
  public MMActivity lzt;
  private ListView nlI;
  private IListener rDF;
  protected int requestType;
  public com.tencent.mm.ui.widget.b.a vEV;
  
  public bn(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.listener.c paramc, i parami, final ad paramad)
  {
    AppMethodBeat.i(99243);
    this.Ryq = new LinkedList();
    this.Ryr = new HashMap();
    this.Roa = false;
    this.RtB = 0;
    this.RtC = false;
    this.Ryt = new PBool();
    this.Gix = 0;
    this.Ryu = -1;
    this.Rqq = 0;
    this.Rcg = new HashMap();
    this.RtE = new HashMap();
    this.Ryv = new HashMap();
    this.Ryw = new HashMap();
    this.requestType = 0;
    this.handler = new MMHandler();
    this.Ryy = new HashMap();
    this.Ryz = new HashMap();
    this.RyA = 2;
    this.RyB = false;
    this.RyC = false;
    this.RyD = new HashSet();
    this.Rpr = new SnsTimeLineBaseAdapter.1(this, com.tencent.mm.app.f.hfK);
    this.Rpq = new SnsTimeLineBaseAdapter.2(this, com.tencent.mm.app.f.hfK);
    this.Rps = new SnsTimeLineBaseAdapter.3(this, com.tencent.mm.app.f.hfK);
    this.RyE = new HashMap();
    this.RyE.put(Integer.valueOf(6), o.a.class);
    this.RyE.put(Integer.valueOf(2), m.a.class);
    this.RyE.put(Integer.valueOf(3), m.a.class);
    this.RyE.put(Integer.valueOf(4), m.a.class);
    this.RyE.put(Integer.valueOf(5), m.a.class);
    this.RyE.put(Integer.valueOf(0), m.a.class);
    this.RyE.put(Integer.valueOf(24), j.a.class);
    this.RyE.put(Integer.valueOf(1), m.a.class);
    this.RyE.put(Integer.valueOf(7), m.a.class);
    this.RyE.put(Integer.valueOf(8), m.a.class);
    this.RyE.put(Integer.valueOf(9), m.a.class);
    this.RyE.put(Integer.valueOf(11), p.b.class);
    this.RyE.put(Integer.valueOf(13), com.tencent.mm.plugin.sns.ui.item.a.a.class);
    this.RyE.put(Integer.valueOf(27), f.a.class);
    this.RyE.put(Integer.valueOf(28), f.a.class);
    this.RyE.put(Integer.valueOf(29), f.a.class);
    this.RyE.put(Integer.valueOf(30), f.a.class);
    this.RyE.put(Integer.valueOf(31), f.a.class);
    this.RyE.put(Integer.valueOf(32), f.a.class);
    this.RyE.put(Integer.valueOf(15), n.a.class);
    this.RyE.put(Integer.valueOf(10), m.a.class);
    this.RyE.put(Integer.valueOf(12), m.a.class);
    this.RyE.put(Integer.valueOf(16), m.a.class);
    this.RyE.put(Integer.valueOf(17), h.a.class);
    this.RyE.put(Integer.valueOf(18), e.a.class);
    this.RyE.put(Integer.valueOf(20), d.a.class);
    this.RyE.put(Integer.valueOf(33), d.a.class);
    this.RyE.put(Integer.valueOf(25), d.a.class);
    this.RyE.put(Integer.valueOf(21), i.a.class);
    this.RyE.put(Integer.valueOf(19), b.a.class);
    this.RyE.put(Integer.valueOf(22), r.a.class);
    this.RyE.put(Integer.valueOf(23), com.tencent.mm.plugin.sns.ad.timeline.b.a.a.class);
    this.RyE.put(Integer.valueOf(26), com.tencent.mm.plugin.sns.ad.timeline.b.a.a.a.class);
    this.RyF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99228);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        Log.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
        bn.this.Ryp.Rby = false;
        com.tencent.mm.plugin.sns.abtest.a.gZr();
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          Log.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99228);
          return;
        }
        localObject = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.ContentObj.Zpq == 21))
        {
          dna localdna = ((BaseTimeLineItem.BaseViewHolder)localObject).postInfo;
          if ((!z.bAM().equals(((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.UserName)) && ((localdna == null) || (localdna.ihz == 0)))
          {
            Log.i("MicroMsg.SnsTimeLineBaseAdapter", "snsCommentFix showTipsDialog.");
            com.tencent.mm.plugin.sns.lucky.ui.a.h(bn.this.lzt, ((BaseTimeLineItem.BaseViewHolder)localObject).RKZ.alP(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99228);
            return;
          }
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject).isAd) {
          com.tencent.mm.plugin.sns.ad.j.j.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(((BaseTimeLineItem.BaseViewHolder)localObject).hES, paramAnonymousView, bn.this.Ryp.Rbv));
        }
        if ((bn.this.lzt instanceof aa))
        {
          Log.i("MicroMsg.SnsTimeLineBaseAdapter", "snsCommentFix addCommentView.");
          ((aa)bn.this.lzt).jG(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99228);
      }
    };
    this.RyG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
        if ((bn.this.Rcg.containsKey(paramAnonymousView.hES)) && (((Integer)bn.this.Rcg.get(paramAnonymousView.hES)).equals(Integer.valueOf(0))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        if ((bn.this.Rcg.containsKey(paramAnonymousView.hES)) && (((Integer)bn.this.Rcg.get(paramAnonymousView.hES)).equals(Integer.valueOf(1))))
        {
          bn.this.Rcg.put(paramAnonymousView.hES, Integer.valueOf(2));
          bn.this.Ryo.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        bn.this.Rcg.put(paramAnonymousView.hES, Integer.valueOf(1));
        bn.this.Ryo.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99229);
      }
    };
    this.RyH = new SnsPostDescPreloadTextView.b()
    {
      public final void hpC()
      {
        AppMethodBeat.i(308039);
        bn.this.Ryo.notifyDataSetChanged();
        AppMethodBeat.o(308039);
      }
    };
    this.RyI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99231);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((!bn.this.RtC) || (bn.this.RtB <= 0))
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
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "likeCollapListener onclick %s", new Object[] { paramAnonymousView.hES });
        if ((bn.this.RtE.containsKey(paramAnonymousView.hES)) && ((((Integer)bn.this.RtE.get(paramAnonymousView.hES)).equals(Integer.valueOf(1))) || (((Integer)bn.this.RtE.get(paramAnonymousView.hES)).equals(Integer.valueOf(3)))))
        {
          bn.this.RtE.put(paramAnonymousView.hES, Integer.valueOf(2));
          com.tencent.mm.plugin.sns.statistics.j.QFS.da(t.uA(paramAnonymousView.RKx), true);
        }
        for (;;)
        {
          bn.this.Ryo.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99231);
          return;
          bn.this.RtE.put(paramAnonymousView.hES, Integer.valueOf(1));
          com.tencent.mm.plugin.sns.statistics.j.QFS.da(t.uA(paramAnonymousView.RKx), false);
        }
      }
    };
    this.RyJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308026);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousView.getParent() == null) || (!(paramAnonymousView.getParent() instanceof SnsCommentCollapseLayout)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308026);
          return;
        }
        if ((((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() == null) || (!(((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() instanceof m)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308026);
          return;
        }
        localObject = (m)((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag();
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308026);
          return;
        }
        try
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((m)localObject).nUB);
          paramAnonymousView.putExtra("sns_local_id", ((m)localObject).Rcl);
          paramAnonymousView.putExtra("sns_comment_buf", ((m)localObject).Qsv.toByteArray());
          paramAnonymousView.putExtra("sns_content_source", 2);
          paramAnonymousView.setClass(bn.this.lzt, SnsSingleTextViewUI.class);
          localObject = bn.this.lzt;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308026);
          return;
        }
        catch (IOException paramAnonymousView)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", paramAnonymousView, "commentCollapse click exception.", new Object[0]);
          }
        }
      }
    };
    this.Rdy = Util.genLinearPressedListener();
    this.RyK = new HashMap();
    this.RyL = new bn.d();
    this.rDF = new SnsTimeLineBaseAdapter.12(this, com.tencent.mm.app.f.hfK);
    this.Akp = new SnsTimeLineBaseAdapter.13(this, com.tencent.mm.app.f.hfK);
    this.Ryo = paramad;
    this.Ryp = parami;
    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
    this.nlI = paramListView;
    al.hgy();
    this.lzt = paramMMActivity;
    this.QBf = paramc;
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramMMActivity);
    this.vEV = new com.tencent.mm.ui.widget.b.a(paramMMActivity);
    this.RoJ = new bh(paramMMActivity);
    this.RoC = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.RoC.setDuration(150L);
    this.RoD = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.RoD.setDuration(150L);
    this.RoO = new j(paramMMActivity, 0, parami.Rbw);
    this.Ryx = new l(parami);
    this.requestType = 10;
    this.RoS = new bv(paramMMActivity, new bv.a()
    {
      public final void fHR()
      {
        AppMethodBeat.i(308004);
        paramad.notifyDataSetChanged();
        AppMethodBeat.o(308004);
      }
    }, 0, parami.Rbw);
    boolean bool;
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      this.RtB = this.RyA;
      this.RtC = true;
      if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adgE, 0) != 1) {
        break label1337;
      }
      bool = true;
      label1091:
      this.RyB = bool;
      if (Util.safeParseInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_sns_timeline_skip_crash_item", "0", false, true)) <= 0) {
        break label1343;
      }
      bool = true;
      label1120:
      this.RyC = bool;
      paramc = MultiProcessMMKV.getMMKV("SnsTimelineMMKV");
      paramMMActivity = paramc.getString("SnsTimelineMMKVLastShowItemId", "");
      if (!Util.isNullOrNil(paramMMActivity))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 91);
        paramc.encode("SnsTimelineMMKVLastShowItemId", "");
        parami = paramc.getString("SnsTimelineMMKVLastCrashItemId", "");
        if ((!Util.isNullOrNil(parami)) && (parami.equals(paramMMActivity))) {
          break label1349;
        }
        paramc.encode("SnsTimelineMMKVLastCrashItemId", paramMMActivity);
        paramc.encode("SnsTimelineMMKVLastCrashItemCount", 1);
      }
    }
    for (;;)
    {
      if (this.RyC) {
        this.RyD = paramc.getStringSet("SnsTimelineMMKVNeedSkipItem", new HashSet());
      }
      AppMethodBeat.o(99243);
      return;
      for (;;)
      {
        try
        {
          this.RtB = Util.safeParseInt(com.tencent.mm.plugin.expt.e.d.dNI().hx(c.a.zeY.name(), "0"));
          if (Util.safeParseInt(com.tencent.mm.plugin.expt.e.d.dNI().hx(c.a.zeZ.name(), "0")) != 1) {
            break label1331;
          }
          bool = true;
          this.RtC = bool;
        }
        catch (NumberFormatException paramMMActivity)
        {
          Log.w("MicroMsg.SnsTimeLineBaseAdapter", "parse like collapse config error: %s", new Object[] { paramMMActivity.getMessage() });
        }
        break;
        label1331:
        bool = false;
      }
      label1337:
      bool = false;
      break label1091;
      label1343:
      bool = false;
      break label1120;
      label1349:
      int i = paramc.getInt("SnsTimelineMMKVLastCrashItemCount", 0) + 1;
      if (i >= Util.safeParseInt(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_sns_timeline_skip_crash_item_count", "3", false, true)))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 92);
        paramListView = paramc.getStringSet("SnsTimelineMMKVNeedSkipItem", new HashSet());
        paramMMActivity = paramListView;
        if (paramListView.size() > 10) {
          paramMMActivity = new HashSet();
        }
        paramMMActivity.add(parami);
        paramc.encode("SnsTimelineMMKVNeedSkipItem", paramMMActivity);
        paramc.encode("SnsTimelineMMKVLastCrashItemId", "");
        paramc.encode("SnsTimelineMMKVLastCrashItemCount", 0);
      }
      else
      {
        paramc.encode("SnsTimelineMMKVLastCrashItemCount", i);
      }
    }
  }
  
  public static String a(TimeLineObject paramTimeLineObject, Context paramContext)
  {
    AppMethodBeat.i(99250);
    paramTimeLineObject = com.tencent.mm.plugin.sns.d.a.pFo.i(paramContext, paramTimeLineObject.AppInfo.Id, "timeline");
    AppMethodBeat.o(99250);
    return paramTimeLineObject;
  }
  
  public static boolean aUY(String paramString)
  {
    AppMethodBeat.i(308370);
    if (!com.tencent.mm.aw.a.bLk())
    {
      AppMethodBeat.o(308370);
      return false;
    }
    com.tencent.mm.aw.f localf = com.tencent.mm.aw.a.bLn();
    if ((localf != null) && (com.tencent.mm.aw.a.e(localf)) && (paramString.equals(localf.oOv)))
    {
      AppMethodBeat.o(308370);
      return true;
    }
    AppMethodBeat.o(308370);
    return false;
  }
  
  private static ArrayList<av.b> baL(String paramString)
  {
    AppMethodBeat.i(308364);
    ArrayList localArrayList = new ArrayList();
    if (av.hho().size() <= 0)
    {
      AppMethodBeat.o(308364);
      return localArrayList;
    }
    Iterator localIterator = av.hho().keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (((String)localObject).startsWith(paramString))
      {
        localObject = (av.b)av.hho().get(localObject);
        if (av.c((av.b)localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    AppMethodBeat.o(308364);
    return localArrayList;
  }
  
  public static String baM(String paramString)
  {
    AppMethodBeat.i(99249);
    if (Util.isNullOrNil(paramString))
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
  
  public static String baN(String paramString)
  {
    AppMethodBeat.i(99251);
    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.d.a.pFo.ab(paramString, "timeline");
    AppMethodBeat.o(99251);
    return paramString;
  }
  
  public static int g(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(99247);
    Object localObject = paramSnsInfo.getTimeLine();
    if ((paramBoolean) && (paramSnsInfo.isWsFold()))
    {
      AppMethodBeat.o(99247);
      return 22;
    }
    int i;
    if (((TimeLineObject)localObject).ContentObj.Zpq == 1)
    {
      if ((paramBoolean) && (((TimeLineObject)localObject).showFlag == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramSnsInfo.isAd()) && (paramSnsInfo.getAdXml() != null))
      {
        if (paramSnsInfo.getAdXml().isCardAd())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramSnsInfo.isFullCardAd())
        {
          i = com.tencent.mm.plugin.sns.ui.item.a.a.b.af(paramSnsInfo);
          AppMethodBeat.o(99247);
          return i;
        }
        if (paramSnsInfo.isSphereCardAd())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
      }
      i = ((TimeLineObject)localObject).ContentObj.Zpr.size();
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
    switch (((TimeLineObject)localObject).ContentObj.Zpq)
    {
    case 3: 
    case 6: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 30: 
    case 31: 
    case 32: 
    case 35: 
    case 40: 
    case 41: 
    default: 
      AppMethodBeat.o(99247);
      return 1;
    case 4: 
      if (((TimeLineObject)localObject).AppInfo != null) {}
      for (paramSnsInfo = ((TimeLineObject)localObject).AppInfo.Id;; paramSnsInfo = "")
      {
        localObject = com.tencent.mm.plugin.comm.a.xeG;
        if (!com.tencent.mm.plugin.comm.a.aml(paramSnsInfo)) {
          break;
        }
        AppMethodBeat.o(99247);
        return 24;
      }
      paramSnsInfo = com.tencent.mm.plugin.comm.a.xeG;
      if (!com.tencent.mm.plugin.comm.a.dsO())
      {
        AppMethodBeat.o(99247);
        return 0;
      }
      AppMethodBeat.o(99247);
      return 1;
    case 42: 
      AppMethodBeat.o(99247);
      return 24;
    case 5: 
      if ((paramSnsInfo.isAd()) && (paramSnsInfo.getAdXml() != null))
      {
        if (paramSnsInfo.getAdXml().isCardAd())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramSnsInfo.isFullCardAd())
        {
          i = com.tencent.mm.plugin.sns.ui.item.a.a.b.af(paramSnsInfo);
          AppMethodBeat.o(99247);
          return i;
        }
        if (paramSnsInfo.isSphereCardAd())
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
      if ((paramBoolean) && (((TimeLineObject)localObject).sightFolded == 1))
      {
        AppMethodBeat.o(99247);
        return 12;
      }
      if ((paramSnsInfo.isAd()) && (paramSnsInfo.getAdXml() != null))
      {
        if (paramSnsInfo.getAdXml().isCardAd())
        {
          AppMethodBeat.o(99247);
          return 13;
        }
        if (paramSnsInfo.isFullCardAd())
        {
          i = com.tencent.mm.plugin.sns.ui.item.a.a.b.af(paramSnsInfo);
          AppMethodBeat.o(99247);
          return i;
        }
        if (paramSnsInfo.isSphereCardAd())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
        if (paramSnsInfo.isFinderTopicCardAd())
        {
          AppMethodBeat.o(99247);
          return 23;
        }
        if (paramSnsInfo.isSlideFullCardAd())
        {
          AppMethodBeat.o(99247);
          return 26;
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
    case 37: 
    case 38: 
    case 44: 
      AppMethodBeat.o(99247);
      return 16;
    case 33: 
      AppMethodBeat.o(99247);
      return 17;
    case 28: 
      AppMethodBeat.o(99247);
      return 18;
    case 34: 
      AppMethodBeat.o(99247);
      return 20;
    case 45: 
      AppMethodBeat.o(99247);
      return 33;
    case 43: 
      AppMethodBeat.o(99247);
      return 25;
    case 36: 
      AppMethodBeat.o(99247);
      return 21;
    }
    switch (((TimeLineObject)localObject).ContentObj.nUa)
    {
    default: 
      AppMethodBeat.o(99247);
      return 1;
    }
    AppMethodBeat.o(99247);
    return 16;
  }
  
  public final void a(SnsCommentCollapseLayout paramSnsCommentCollapseLayout)
  {
    AppMethodBeat.i(99239);
    this.Ryq.add(paramSnsCommentCollapseLayout);
    AppMethodBeat.o(99239);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(99254);
    if (parama != null) {
      this.Ryv.put(paramString, parama);
    }
    AppMethodBeat.o(99254);
  }
  
  public final void aA(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(99253);
    a locala = (a)this.Ryv.get(paramString);
    if ((locala != null) && (Util.isEqual(locala.getKey(), paramString))) {
      locala.Ej(paramBoolean);
    }
    AppMethodBeat.o(99253);
  }
  
  public final void aQ(Runnable paramRunnable)
  {
    AppMethodBeat.i(99252);
    this.Ryo.hmc();
    paramRunnable.run();
    AppMethodBeat.o(99252);
  }
  
  public final SnsInfo alF(int paramInt)
  {
    AppMethodBeat.i(99257);
    SnsInfo localSnsInfo = this.Ryo.alF(paramInt);
    AppMethodBeat.o(99257);
    return localSnsInfo;
  }
  
  public final boolean alH(int paramInt)
  {
    AppMethodBeat.i(99259);
    if ((paramInt < this.nlI.getFirstVisiblePosition() - 1) || (paramInt > this.nlI.getLastVisiblePosition() - 1))
    {
      AppMethodBeat.o(99259);
      return false;
    }
    AppMethodBeat.o(99259);
    return true;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(99258);
    int i = this.Ryo.getCount();
    AppMethodBeat.o(99258);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99246);
    SnsInfo localSnsInfo = this.Ryo.alF(paramInt);
    if (this.Ryp.hlA() == 1) {}
    for (paramInt = g(localSnsInfo, false);; paramInt = g(localSnsInfo, true))
    {
      AppMethodBeat.o(99246);
      return paramInt;
    }
  }
  
  public final void hpA()
  {
    AppMethodBeat.i(99255);
    this.Ryv.clear();
    AppMethodBeat.o(99255);
  }
  
  public final com.tencent.mm.ui.widget.b.a hpB()
  {
    AppMethodBeat.i(99260);
    if (this.vEV != null) {
      this.vEV.diW();
    }
    this.vEV = new com.tencent.mm.ui.widget.b.a(this.lzt);
    com.tencent.mm.ui.widget.b.a locala = this.vEV;
    AppMethodBeat.o(99260);
    return locala;
  }
  
  public final void hpt()
  {
    AppMethodBeat.i(99237);
    this.Rcg.clear();
    this.RtE.clear();
    AppMethodBeat.o(99237);
  }
  
  public final aa hpu()
  {
    if ((this.lzt instanceof aa)) {
      return (aa)this.lzt;
    }
    return null;
  }
  
  public final SnsCommentCollapseLayout hpv()
  {
    AppMethodBeat.i(99238);
    if (this.Ryq.size() == 0)
    {
      localSnsCommentCollapseLayout = new SnsCommentCollapseLayout(this.lzt);
      AppMethodBeat.o(99238);
      return localSnsCommentCollapseLayout;
    }
    SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.Ryq.removeFirst();
    AppMethodBeat.o(99238);
    return localSnsCommentCollapseLayout;
  }
  
  public final boolean hpw()
  {
    AppMethodBeat.i(99240);
    if (this.Ryq != null) {
      this.Ryq.clear();
    }
    if (this.RyE != null) {
      this.RyE.clear();
    }
    com.tencent.mm.pluginsdk.ui.span.p.clearCache();
    com.tencent.mm.kiss.widget.textview.c.mGx.bbI();
    if (this.Ryt.value) {
      ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeZ, 0);
    }
    AppMethodBeat.o(99240);
    return true;
  }
  
  public final void hpx()
  {
    AppMethodBeat.i(99242);
    this.Ryo.hmc();
    AppMethodBeat.o(99242);
  }
  
  public final void hpy()
  {
    AppMethodBeat.i(99244);
    int i = this.nlI.getFirstVisiblePosition() - this.nlI.getHeaderViewsCount();
    int j = this.nlI.getLastVisiblePosition() - this.nlI.getHeaderViewsCount();
    Log.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + i + " " + j);
    int k = this.Ryo.getCount();
    if ((i <= j) && (i < k))
    {
      Object localObject1 = alF(i);
      Object localObject2 = (View)this.Ryw.get(Integer.valueOf(i));
      if ((localObject2 == null) || (localObject1 == null) || (((View)localObject2).getTag() == null)) {
        Log.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (BaseTimeLineItem.BaseViewHolder)((View)localObject2).getTag();
        Log.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + ((BaseTimeLineItem.BaseViewHolder)localObject2).position);
        BaseTimeLineItem localBaseTimeLineItem = ((BaseTimeLineItem.BaseViewHolder)localObject2).RLz;
        bo localbo = this.Ryo.alG(i);
        localObject1 = ((SnsInfo)localObject1).getTimeLine();
        localBaseTimeLineItem.a((BaseTimeLineItem.BaseViewHolder)localObject2, i, localbo, (TimeLineObject)localObject1, ((BaseTimeLineItem.BaseViewHolder)localObject2).viewType, localBaseTimeLineItem.QBJ);
        localBaseTimeLineItem.a(localbo, (TimeLineObject)localObject1);
      }
    }
    AppMethodBeat.o(99244);
  }
  
  public final ad hpz()
  {
    return this.Ryo;
  }
  
  public final void jL(View paramView)
  {
    AppMethodBeat.i(99256);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      AppMethodBeat.o(99256);
      return;
    }
    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
    if ((this.Rys != null) && (this.Rys.getVisibility() == 0))
    {
      this.Rys.startAnimation(this.RoD);
      this.RoD.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(308063);
          if (bn.this.Rys != null)
          {
            bn.this.Rys.clearAnimation();
            bn.this.Rys.setVisibility(8);
          }
          bn.this.Rys = null;
          AppMethodBeat.o(308063);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    AppMethodBeat.o(99256);
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(99241);
    this.Ryo.notifyDataSetChanged();
    AppMethodBeat.o(99241);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(308420);
    this.Rpr.dead();
    this.Rpq.dead();
    this.Rps.dead();
    this.rDF.dead();
    this.Akp.dead();
    AppMethodBeat.o(308420);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(308423);
    this.Rpr.alive();
    this.Rpq.alive();
    this.Rps.alive();
    this.rDF.alive();
    this.Akp.alive();
    AppMethodBeat.o(308423);
  }
  
  public final View y(int paramInt, View paramView)
  {
    AppMethodBeat.i(99245);
    SnsInfo localSnsInfo = this.Ryo.alF(paramInt);
    TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
    Object localObject1;
    if ((localTimeLineObject != null) && (!Util.isNullOrNil(localTimeLineObject.Id)))
    {
      if ((this.RyC) && (this.RyD.contains(localTimeLineObject.Id)))
      {
        Log.e("MicroMsg.SnsTimeLineBaseAdapter", "createView skipItemSet includes this id:%s", new Object[] { localTimeLineObject.Id });
        com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 93);
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = new View(this.lzt);
        }
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(99245);
        return localObject1;
      }
      MultiProcessMMKV.getMMKV("SnsTimelineMMKV").encode("SnsTimelineMMKVLastShowItemId", localTimeLineObject.Id);
    }
    if ((MultiProcessMMKV.getMMKV("SnsMMKV").getBoolean("SnsMMKVDeleteTable", false)) && (localSnsInfo.isAd()))
    {
      Log.i("MicroMsg.SnsTimeLineBaseAdapter", "already delete sns table, skip ad");
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = new View(this.lzt);
      }
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(99245);
      return localObject1;
    }
    int i;
    Object localObject4;
    Object localObject2;
    int j;
    if (this.Ryp.hlA() == 1)
    {
      i = g(localSnsInfo, false);
      localObject1 = null;
      localObject3 = null;
      localObject4 = localObject1;
      localObject2 = localObject3;
      if (paramView != null)
      {
        localObject2 = paramView.getTag(b.f.sns_item_root);
        if (!(localObject2 instanceof Integer)) {
          break label779;
        }
        j = ((Integer)localObject2).intValue();
        label283:
        localObject4 = localObject1;
        localObject2 = localObject3;
        if (j == i)
        {
          localObject2 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
          localObject4 = ((BaseTimeLineItem.BaseViewHolder)localObject2).RLz;
        }
      }
      localObject1 = localObject2;
      localObject3 = paramView;
      if (localObject2 == null) {
        switch (i)
        {
        case 14: 
        default: 
          localObject1 = new com.tencent.mm.plugin.sns.ui.item.l();
        }
      }
    }
    for (;;)
    {
      label779:
      try
      {
        if (this.RyE.get(Integer.valueOf(i)) != null)
        {
          localObject3 = (BaseTimeLineItem.BaseViewHolder)((Class)this.RyE.get(Integer.valueOf(i))).newInstance();
          localObject2 = localObject3;
          localObject3 = paramView;
        }
      }
      catch (Exception localException1) {}
      try
      {
        ((BaseTimeLineItem.BaseViewHolder)localObject2).RLz = ((BaseTimeLineItem)localObject1);
        localObject3 = paramView;
        ((BaseTimeLineItem.BaseViewHolder)localObject2).timeLineObject = localTimeLineObject;
        localObject3 = paramView;
        paramView = ((BaseTimeLineItem)localObject1).a(this.lzt, (BaseTimeLineItem.BaseViewHolder)localObject2, i, this, localSnsInfo);
        localObject3 = paramView;
        paramView.setTag(b.f.sns_item_root, Integer.valueOf(i));
        localObject4 = localObject1;
        localObject3 = paramView;
        localObject1 = localObject2;
        ((BaseTimeLineItem)localObject4).setIsFromMainTimeline(this.Roa);
        paramView = baL(localSnsInfo.getSnsId());
        if (paramView != null) {
          ((BaseTimeLineItem)localObject4).RKv = paramView;
        }
        ((BaseTimeLineItem)localObject4).a((BaseTimeLineItem.BaseViewHolder)localObject1, paramInt, localSnsInfo, localTimeLineObject, i, this, this.Ryo.alG(paramInt));
        if ((!av.gY(localSnsInfo.getSnsId(), 2)) || (i == 22)) {
          break label1204;
        }
        paramView = av.aYE(localSnsInfo.getSnsId());
        if (localSnsInfo.field_snsId == 0L) {
          paramView = new av.b();
        }
        if (!paramView.ooe) {
          break label1196;
        }
        if (paramView.oss) {
          break label1180;
        }
        BaseTimeLineItem.a(paramView, (BaseTimeLineItem.BaseViewHolder)localObject1, paramView.result, paramView.brand);
        this.Ryw.put(Integer.valueOf(paramInt), localObject3);
        if ((localTimeLineObject != null) && (!Util.isNullOrNil(localTimeLineObject.Id))) {
          MultiProcessMMKV.getMMKV("SnsTimelineMMKV").encode("SnsTimelineMMKVLastShowItemId", "");
        }
        AppMethodBeat.o(99245);
        return localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject5;
          paramView = (View)localObject3;
        }
      }
      i = g(localSnsInfo, true);
      break;
      j = -1;
      break label283;
      localObject1 = new o();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.m();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.m();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.m();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.m();
      continue;
      localObject1 = new k();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.j();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.l();
      continue;
      localObject1 = new q();
      continue;
      localObject1 = new g();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.p();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.f();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a.e();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a.c();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a.d();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a.a();
      continue;
      localObject1 = new n();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.h();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.e();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.d();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.c();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.i();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.b.b();
      continue;
      localObject1 = new r();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.b.a();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.b.a.a();
      continue;
      localObject3 = new m.a();
      localObject2 = localObject3;
      continue;
      Log.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", localException1, "create holder error", new Object[0]);
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject3 = paramView;
      continue;
      label1180:
      BaseTimeLineItem.j((BaseTimeLineItem.BaseViewHolder)localObject1);
      av.gX(paramView.id, 2);
      continue;
      label1196:
      BaseTimeLineItem.i((BaseTimeLineItem.BaseViewHolder)localObject1);
      continue;
      label1204:
      BaseTimeLineItem.j((BaseTimeLineItem.BaseViewHolder)localObject1);
    }
  }
  
  public static abstract interface a
  {
    public abstract void Ej(boolean paramBoolean);
    
    public abstract String getKey();
  }
  
  public static abstract interface b
  {
    public abstract boolean hpD();
  }
  
  public static final class c
    implements az.b.a
  {
    private ad RyP = null;
    private int mPosition;
    
    public c(ad paramad, int paramInt)
    {
      this.RyP = paramad;
      this.mPosition = paramInt;
    }
    
    public final void getContactCallBack(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(99235);
      if (paramBoolean)
      {
        com.tencent.mm.kernel.h.baF();
        if (com.tencent.mm.kernel.h.baC().aZN()) {
          al.fAG().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(99234);
              if (bn.c.a(bn.c.this).hmd() != null) {
                bn.c.a(bn.c.this).hmd().request(Integer.valueOf(bn.c.b(bn.c.this)));
              }
              bn.c.a(bn.c.this).notifyDataSetChanged();
              AppMethodBeat.o(99234);
            }
          });
        }
      }
      AppMethodBeat.o(99235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bn
 * JD-Core Version:    0.7.0.1
 */