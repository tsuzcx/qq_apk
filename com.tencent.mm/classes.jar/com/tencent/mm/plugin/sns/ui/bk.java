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
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.au.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.c.a;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.item.f.a;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.item.i.a;
import com.tencent.mm.plugin.sns.ui.item.j.a;
import com.tencent.mm.plugin.sns.ui.item.k;
import com.tencent.mm.plugin.sns.ui.item.m.a;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.plugin.sns.ui.item.o;
import com.tencent.mm.plugin.sns.ui.item.o.a;
import com.tencent.mm.plugin.sns.ui.item.p;
import com.tencent.mm.plugin.sns.ui.item.p.b;
import com.tencent.mm.plugin.sns.ui.item.q;
import com.tencent.mm.plugin.sns.ui.item.r.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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

public final class bk
  implements ac
{
  public com.tencent.mm.plugin.sns.ui.d.c DQs;
  protected ScaleAnimation EAX;
  protected ScaleAnimation EAY;
  public boolean EAv;
  private com.tencent.mm.ui.blur.f EBK;
  private IListener EBM;
  private IListener EBN;
  private IListener EBO;
  public be EBe;
  private int EBh;
  public j EBk;
  public br EBo;
  public int EFK;
  public boolean EFL;
  protected HashMap<String, Integer> EFN;
  private Set<String> EKA;
  private HashMap<Integer, Class<? extends BaseTimeLineItem.BaseViewHolder>> EKB;
  public View.OnClickListener EKC;
  public View.OnClickListener EKD;
  public SnsPostDescPreloadTextView.b EKE;
  public View.OnClickListener EKF;
  public View.OnClickListener EKG;
  private HashMap<String, Boolean> EKH;
  private d EKI;
  protected aa EKk;
  public i EKl;
  protected LinkedList<SnsCommentCollapseLayout> EKm;
  public HashMap<Integer, WeakReference<View>> EKn;
  View EKo;
  public PBool EKp;
  public int EKq;
  int EKr;
  protected HashMap<String, a> EKs;
  protected HashMap<Integer, View> EKt;
  public l EKu;
  private Map<Integer, WeakReference<SnsCommentPreloadTextView>> EKv;
  public HashMap<String, String> EKw;
  private int EKx;
  public boolean EKy;
  private boolean EKz;
  protected HashMap<String, Integer> Epp;
  public View.OnTouchListener EqE;
  public com.tencent.mm.ui.tools.l contextMenuHelper;
  public MMActivity gte;
  private ListView hUI;
  protected MMHandler handler;
  IListener lEl;
  public com.tencent.mm.ui.widget.b.a pqr;
  protected int requestType;
  
  public bk(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.c paramc, i parami, final aa paramaa)
  {
    AppMethodBeat.i(99243);
    this.EKm = new LinkedList();
    this.EKn = new HashMap();
    this.EAv = false;
    this.EFK = 0;
    this.EFL = false;
    this.EKp = new PBool();
    this.EBh = 0;
    this.EKq = -1;
    this.EKr = 0;
    this.Epp = new HashMap();
    this.EFN = new HashMap();
    this.EKs = new HashMap();
    this.EKt = new HashMap();
    this.requestType = 0;
    this.handler = new MMHandler();
    this.EKv = new HashMap();
    this.EKw = new HashMap();
    this.EKx = 2;
    this.EBK = null;
    this.EKy = false;
    this.EKz = false;
    this.EKA = new HashSet();
    this.EBN = new IListener() {};
    this.EBM = new IListener() {};
    this.EBO = new IListener() {};
    this.EKB = new HashMap();
    this.EKB.put(Integer.valueOf(6), o.a.class);
    this.EKB.put(Integer.valueOf(2), m.a.class);
    this.EKB.put(Integer.valueOf(3), m.a.class);
    this.EKB.put(Integer.valueOf(4), m.a.class);
    this.EKB.put(Integer.valueOf(5), m.a.class);
    this.EKB.put(Integer.valueOf(0), m.a.class);
    this.EKB.put(Integer.valueOf(24), j.a.class);
    this.EKB.put(Integer.valueOf(1), m.a.class);
    this.EKB.put(Integer.valueOf(7), m.a.class);
    this.EKB.put(Integer.valueOf(8), m.a.class);
    this.EKB.put(Integer.valueOf(9), m.a.class);
    this.EKB.put(Integer.valueOf(11), p.b.class);
    this.EKB.put(Integer.valueOf(13), com.tencent.mm.plugin.sns.ui.item.a.a.class);
    this.EKB.put(Integer.valueOf(14), f.a.class);
    this.EKB.put(Integer.valueOf(15), n.a.class);
    this.EKB.put(Integer.valueOf(10), m.a.class);
    this.EKB.put(Integer.valueOf(12), m.a.class);
    this.EKB.put(Integer.valueOf(16), m.a.class);
    this.EKB.put(Integer.valueOf(17), h.a.class);
    this.EKB.put(Integer.valueOf(18), d.a.class);
    this.EKB.put(Integer.valueOf(20), c.a.class);
    this.EKB.put(Integer.valueOf(21), i.a.class);
    this.EKB.put(Integer.valueOf(19), com.tencent.mm.plugin.sns.ad.timeline.c.b.a.class);
    this.EKB.put(Integer.valueOf(22), r.a.class);
    this.EKB.put(Integer.valueOf(23), com.tencent.mm.plugin.sns.ad.timeline.c.a.a.class);
    this.EKC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99228);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
        bk.this.EKl.EoH = false;
        com.tencent.mm.plugin.sns.abtest.a.eWu();
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          Log.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99228);
          return;
        }
        localObject = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.ContentObj.LoU == 21))
        {
          cnc localcnc = ((BaseTimeLineItem.BaseViewHolder)localObject).postInfo;
          if ((!z.aTY().equals(((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.UserName)) && ((localcnc == null) || (localcnc.egZ == 0)))
          {
            com.tencent.mm.plugin.sns.lucky.ui.a.f(bk.this.gte, ((BaseTimeLineItem.BaseViewHolder)localObject).EWX.ZD(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99228);
            return;
          }
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject).isAd) {
          com.tencent.mm.plugin.sns.ad.i.i.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(((BaseTimeLineItem.BaseViewHolder)localObject).dHp, paramAnonymousView, bk.this.EKl.EoE));
        }
        if ((bk.this.gte instanceof x)) {
          ((x)bk.this.gte).fv(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99228);
      }
    };
    this.EKD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
        if ((bk.this.Epp.containsKey(paramAnonymousView.dHp)) && (((Integer)bk.this.Epp.get(paramAnonymousView.dHp)).equals(Integer.valueOf(0))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        if ((bk.this.Epp.containsKey(paramAnonymousView.dHp)) && (((Integer)bk.this.Epp.get(paramAnonymousView.dHp)).equals(Integer.valueOf(1))))
        {
          bk.this.Epp.put(paramAnonymousView.dHp, Integer.valueOf(2));
          bk.this.EKk.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        bk.this.Epp.put(paramAnonymousView.dHp, Integer.valueOf(1));
        bk.this.EKk.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99229);
      }
    };
    this.EKE = new SnsPostDescPreloadTextView.b()
    {
      public final void fiW()
      {
        AppMethodBeat.i(203661);
        bk.this.EKk.notifyDataSetChanged();
        AppMethodBeat.o(203661);
      }
    };
    this.EKF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99231);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((!bk.this.EFL) || (bk.this.EFK <= 0))
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
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "likeCollapListener onclick %s", new Object[] { paramAnonymousView.dHp });
        if ((bk.this.EFN.containsKey(paramAnonymousView.dHp)) && ((((Integer)bk.this.EFN.get(paramAnonymousView.dHp)).equals(Integer.valueOf(1))) || (((Integer)bk.this.EFN.get(paramAnonymousView.dHp)).equals(Integer.valueOf(3)))))
        {
          bk.this.EFN.put(paramAnonymousView.dHp, Integer.valueOf(2));
          com.tencent.mm.plugin.sns.k.e.DUQ.cm(com.tencent.mm.plugin.sns.data.r.Jb(paramAnonymousView.EWu), true);
        }
        for (;;)
        {
          bk.this.EKk.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99231);
          return;
          bk.this.EFN.put(paramAnonymousView.dHp, Integer.valueOf(1));
          com.tencent.mm.plugin.sns.k.e.DUQ.cm(com.tencent.mm.plugin.sns.data.r.Jb(paramAnonymousView.EWu), false);
        }
      }
    };
    this.EKG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203662);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousView.getParent() == null) || (!(paramAnonymousView.getParent() instanceof SnsCommentCollapseLayout)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203662);
          return;
        }
        if ((((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() == null) || (!(((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() instanceof m)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203662);
          return;
        }
        localObject = (m)((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag();
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203662);
          return;
        }
        try
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((m)localObject).iAc);
          paramAnonymousView.putExtra("sns_local_id", ((m)localObject).Epu);
          paramAnonymousView.putExtra("sns_comment_buf", ((m)localObject).DIu.toByteArray());
          paramAnonymousView.setClass(bk.this.gte, SnsSingleTextViewUI.class);
          localObject = bk.this.gte;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203662);
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
    this.EqE = Util.genLinearPressedListener();
    this.EKH = new HashMap();
    this.EKI = new d();
    this.lEl = new IListener() {};
    this.EKk = paramaa;
    this.EKl = parami;
    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
    this.hUI = paramListView;
    aj.faL();
    this.gte = paramMMActivity;
    this.DQs = paramc;
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(paramMMActivity);
    this.pqr = new com.tencent.mm.ui.widget.b.a(paramMMActivity);
    this.EBe = new be(paramMMActivity);
    this.EAX = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.EAX.setDuration(150L);
    this.EAY = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.EAY.setDuration(150L);
    this.EBk = new j(paramMMActivity, 0, parami.EoF);
    this.EKu = new l(parami);
    this.requestType = 10;
    this.EBo = new br(paramMMActivity, new br.a()
    {
      public final void dWI()
      {
        AppMethodBeat.i(203663);
        paramaa.notifyDataSetChanged();
        AppMethodBeat.o(203663);
      }
    }, 0, parami.EoF);
    boolean bool;
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      this.EFK = this.EKx;
      this.EFL = true;
      this.EBK = new com.tencent.mm.ui.blur.f(paramMMActivity);
      if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Ooo, 0) != 1) {
        break label1215;
      }
      bool = true;
      label958:
      this.EKy = bool;
      EventCenter.instance.addListener(this.lEl);
      if (Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_sns_timeline_skip_crash_item", "0", false, true)) <= 0) {
        break label1221;
      }
      bool = true;
      label998:
      this.EKz = bool;
      paramc = MultiProcessMMKV.getMMKV("SnsTimelineMMKV");
      paramMMActivity = paramc.getString("SnsTimelineMMKVLastShowItemId", "");
      if (!Util.isNullOrNil(paramMMActivity))
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(150, 91);
        paramc.encode("SnsTimelineMMKVLastShowItemId", "");
        parami = paramc.getString("SnsTimelineMMKVLastCrashItemId", "");
        if ((!Util.isNullOrNil(parami)) && (parami.equals(paramMMActivity))) {
          break label1227;
        }
        paramc.encode("SnsTimelineMMKVLastCrashItemId", paramMMActivity);
        paramc.encode("SnsTimelineMMKVLastCrashItemCount", 1);
      }
    }
    for (;;)
    {
      if (this.EKz) {
        this.EKA = paramc.getStringSet("SnsTimelineMMKVNeedSkipItem", new HashSet());
      }
      AppMethodBeat.o(99243);
      return;
      for (;;)
      {
        try
        {
          this.EFK = Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.cRY().gA(com.tencent.mm.plugin.expt.b.b.a.sdF.name(), "0"));
          if (Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.cRY().gA(com.tencent.mm.plugin.expt.b.b.a.sdG.name(), "0")) != 1) {
            break label1209;
          }
          bool = true;
          this.EFL = bool;
        }
        catch (NumberFormatException paramListView)
        {
          Log.w("MicroMsg.SnsTimeLineBaseAdapter", "parse like collapse config error: %s", new Object[] { paramListView.getMessage() });
        }
        break;
        label1209:
        bool = false;
      }
      label1215:
      bool = false;
      break label958;
      label1221:
      bool = false;
      break label998;
      label1227:
      int i = paramc.getInt("SnsTimelineMMKVLastCrashItemCount", 0) + 1;
      if (i >= Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_sns_timeline_skip_crash_item_count", "3", false, true)))
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(150, 92);
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
  
  public static int Y(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(258601);
    int i = g(paramSnsInfo, true);
    AppMethodBeat.o(258601);
    return i;
  }
  
  public static String a(TimeLineObject paramTimeLineObject, Context paramContext)
  {
    AppMethodBeat.i(99250);
    paramTimeLineObject = com.tencent.mm.plugin.sns.c.a.jRu.e(paramContext, paramTimeLineObject.AppInfo.Id, "timeline");
    AppMethodBeat.o(99250);
    return paramTimeLineObject;
  }
  
  public static boolean aMJ(String paramString)
  {
    AppMethodBeat.i(203667);
    if (!com.tencent.mm.ay.a.bec())
    {
      AppMethodBeat.o(203667);
      return false;
    }
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.bef();
    if ((localf != null) && (com.tencent.mm.ay.a.e(localf)) && (paramString.equals(localf.jeV)))
    {
      AppMethodBeat.o(203667);
      return true;
    }
    AppMethodBeat.o(203667);
    return false;
  }
  
  private static ArrayList<au.b> aRe(String paramString)
  {
    AppMethodBeat.i(203665);
    ArrayList localArrayList = new ArrayList();
    if (au.fbC().size() <= 0)
    {
      AppMethodBeat.o(203665);
      return localArrayList;
    }
    Iterator localIterator = au.fbC().keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (((String)localObject).startsWith(paramString))
      {
        localObject = (au.b)au.fbC().get(localObject);
        if (au.c((au.b)localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    AppMethodBeat.o(203665);
    return localArrayList;
  }
  
  public static String aRf(String paramString)
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
  
  public static String aRg(String paramString)
  {
    AppMethodBeat.i(99251);
    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.jRu.R(paramString, "timeline");
    AppMethodBeat.o(99251);
    return paramString;
  }
  
  protected static int g(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(99247);
    Object localObject = paramSnsInfo.getTimeLine();
    if ((paramBoolean) && (paramSnsInfo.isWsFold()))
    {
      AppMethodBeat.o(99247);
      return 22;
    }
    if (((TimeLineObject)localObject).ContentObj.LoU == 1)
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
          AppMethodBeat.o(99247);
          return 14;
        }
        if (paramSnsInfo.isSphereCardAd())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
      }
      int i = ((TimeLineObject)localObject).ContentObj.LoV.size();
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
    switch (((TimeLineObject)localObject).ContentObj.LoU)
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
        localObject = com.tencent.mm.plugin.comm.a.qCo;
        if (!com.tencent.mm.plugin.comm.a.akQ(paramSnsInfo)) {
          break;
        }
        AppMethodBeat.o(99247);
        return 24;
      }
      paramSnsInfo = com.tencent.mm.plugin.comm.a.qCo;
      if (!com.tencent.mm.plugin.comm.a.cAI())
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
          AppMethodBeat.o(99247);
          return 14;
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
          AppMethodBeat.o(99247);
          return 14;
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
    case 36: 
      AppMethodBeat.o(99247);
      return 21;
    }
    switch (((TimeLineObject)localObject).ContentObj.izD)
    {
    default: 
      AppMethodBeat.o(99247);
      return 1;
    }
    AppMethodBeat.o(99247);
    return 16;
  }
  
  public final void H(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(99253);
    a locala = (a)this.EKs.get(paramString);
    if ((locala != null) && (Util.isEqual(locala.getKey(), paramString))) {
      locala.vv(paramBoolean);
    }
    AppMethodBeat.o(99253);
  }
  
  public final SnsInfo Zv(int paramInt)
  {
    AppMethodBeat.i(99257);
    SnsInfo localSnsInfo = this.EKk.Zv(paramInt);
    AppMethodBeat.o(99257);
    return localSnsInfo;
  }
  
  public final boolean Zx(int paramInt)
  {
    AppMethodBeat.i(99259);
    if ((paramInt < this.hUI.getFirstVisiblePosition() - 1) || (paramInt > this.hUI.getLastVisiblePosition() - 1))
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
    this.EKm.add(paramSnsCommentCollapseLayout);
    AppMethodBeat.o(99239);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(99254);
    if (parama != null) {
      this.EKs.put(paramString, parama);
    }
    AppMethodBeat.o(99254);
  }
  
  public final void aB(Runnable paramRunnable)
  {
    AppMethodBeat.i(99252);
    this.EKk.ffM();
    paramRunnable.run();
    AppMethodBeat.o(99252);
  }
  
  public final void fiM()
  {
    AppMethodBeat.i(99237);
    this.Epp.clear();
    this.EFN.clear();
    AppMethodBeat.o(99237);
  }
  
  public final x fiN()
  {
    if ((this.gte instanceof x)) {
      return (x)this.gte;
    }
    return null;
  }
  
  public final SnsCommentCollapseLayout fiO()
  {
    AppMethodBeat.i(99238);
    if (this.EKm.size() == 0)
    {
      localSnsCommentCollapseLayout = new SnsCommentCollapseLayout(this.gte);
      AppMethodBeat.o(99238);
      return localSnsCommentCollapseLayout;
    }
    SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.EKm.removeFirst();
    AppMethodBeat.o(99238);
    return localSnsCommentCollapseLayout;
  }
  
  public final void fiP()
  {
    AppMethodBeat.i(203664);
    EventCenter.instance.removeListener(this.lEl);
    AppMethodBeat.o(203664);
  }
  
  public final boolean fiQ()
  {
    AppMethodBeat.i(99240);
    if (this.EKm != null) {
      this.EKm.clear();
    }
    if (this.EKB != null) {
      this.EKB.clear();
    }
    com.tencent.mm.pluginsdk.ui.span.l.clearCache();
    com.tencent.mm.kiss.widget.textview.c.hue.aBj();
    if (this.EKp.value) {
      ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sdG, 0);
    }
    if (this.EBK != null)
    {
      this.EBK.destroy();
      this.EBK = null;
    }
    AppMethodBeat.o(99240);
    return true;
  }
  
  public final void fiR()
  {
    AppMethodBeat.i(99242);
    this.EKk.ffM();
    AppMethodBeat.o(99242);
  }
  
  public final void fiS()
  {
    AppMethodBeat.i(99244);
    int i = this.hUI.getFirstVisiblePosition() - this.hUI.getHeaderViewsCount();
    int j = this.hUI.getLastVisiblePosition() - this.hUI.getHeaderViewsCount();
    Log.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + i + " " + j);
    int k = this.EKk.getCount();
    if ((i <= j) && (i < k))
    {
      SnsInfo localSnsInfo = Zv(i);
      Object localObject = (View)this.EKt.get(Integer.valueOf(i));
      if ((localObject == null) || (localSnsInfo == null) || (((View)localObject).getTag() == null)) {
        Log.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        Log.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).position);
        ((BaseTimeLineItem.BaseViewHolder)localObject).EXx.a((BaseTimeLineItem.BaseViewHolder)localObject, i, localSnsInfo, this.EKk.Zw(i));
      }
    }
    AppMethodBeat.o(99244);
  }
  
  public final aa fiT()
  {
    return this.EKk;
  }
  
  public final void fiU()
  {
    AppMethodBeat.i(99255);
    this.EKs.clear();
    AppMethodBeat.o(99255);
  }
  
  public final com.tencent.mm.ui.widget.b.a fiV()
  {
    AppMethodBeat.i(99260);
    if (this.pqr != null) {
      this.pqr.gNq();
    }
    this.pqr = new com.tencent.mm.ui.widget.b.a(this.gte);
    com.tencent.mm.ui.widget.b.a locala = this.pqr;
    AppMethodBeat.o(99260);
    return locala;
  }
  
  public final void fz(View paramView)
  {
    AppMethodBeat.i(99256);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      AppMethodBeat.o(99256);
      return;
    }
    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
    if ((this.EKo != null) && (this.EKo.getVisibility() == 0))
    {
      this.EKo.startAnimation(this.EAY);
      this.EAY.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(203658);
          if (bk.this.EKo != null)
          {
            bk.this.EKo.clearAnimation();
            bk.this.EKo.setVisibility(8);
          }
          bk.this.EKo = null;
          AppMethodBeat.o(203658);
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
    int i = this.EKk.getCount();
    AppMethodBeat.o(99258);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99246);
    SnsInfo localSnsInfo = this.EKk.Zv(paramInt);
    if (this.EKl.ffo() == 1) {}
    for (paramInt = g(localSnsInfo, false);; paramInt = g(localSnsInfo, true))
    {
      AppMethodBeat.o(99246);
      return paramInt;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(99241);
    this.EKk.notifyDataSetChanged();
    AppMethodBeat.o(99241);
  }
  
  public final View o(int paramInt, View paramView)
  {
    AppMethodBeat.i(99245);
    SnsInfo localSnsInfo = this.EKk.Zv(paramInt);
    TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
    Object localObject1;
    if ((localTimeLineObject != null) && (!Util.isNullOrNil(localTimeLineObject.Id)))
    {
      if ((this.EKz) && (this.EKA.contains(localTimeLineObject.Id)))
      {
        Log.e("MicroMsg.SnsTimeLineBaseAdapter", "createView skipItemSet includes this id:%s", new Object[] { localTimeLineObject.Id });
        com.tencent.mm.plugin.report.service.h.CyF.dN(150, 93);
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = new View(this.gte);
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
        localObject1 = new View(this.gte);
      }
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(99245);
      return localObject1;
    }
    int i;
    Object localObject4;
    Object localObject2;
    int j;
    if (this.EKl.ffo() == 1)
    {
      i = g(localSnsInfo, false);
      localObject1 = null;
      localObject3 = null;
      localObject4 = localObject1;
      localObject2 = localObject3;
      if (paramView != null)
      {
        localObject2 = paramView.getTag(2131308140);
        if (!(localObject2 instanceof Integer)) {
          break label737;
        }
        j = ((Integer)localObject2).intValue();
        label283:
        localObject4 = localObject1;
        localObject2 = localObject3;
        if (j == i)
        {
          localObject2 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
          localObject4 = ((BaseTimeLineItem.BaseViewHolder)localObject2).EXx;
        }
      }
      localObject1 = localObject2;
      localObject3 = paramView;
      if (localObject2 == null) {
        switch (i)
        {
        default: 
          localObject1 = new com.tencent.mm.plugin.sns.ui.item.l();
        }
      }
    }
    for (;;)
    {
      label737:
      try
      {
        if (this.EKB.get(Integer.valueOf(i)) != null)
        {
          localObject3 = (BaseTimeLineItem.BaseViewHolder)((Class)this.EKB.get(Integer.valueOf(i))).newInstance();
          localObject2 = localObject3;
          localObject3 = paramView;
        }
      }
      catch (Exception localException1) {}
      try
      {
        ((BaseTimeLineItem.BaseViewHolder)localObject2).EXx = ((BaseTimeLineItem)localObject1);
        localObject3 = paramView;
        ((BaseTimeLineItem.BaseViewHolder)localObject2).timeLineObject = localTimeLineObject;
        localObject3 = paramView;
        paramView = ((BaseTimeLineItem)localObject1).a(this.gte, (BaseTimeLineItem.BaseViewHolder)localObject2, i, this, localSnsInfo);
        localObject3 = paramView;
        paramView.setTag(2131308140, Integer.valueOf(i));
        localObject4 = localObject1;
        localObject3 = paramView;
        localObject1 = localObject2;
        ((BaseTimeLineItem)localObject4).setIsFromMainTimeline(this.EAv);
        ((BaseTimeLineItem)localObject4).EWs = aRe(localSnsInfo.getSnsId());
        ((BaseTimeLineItem)localObject4).a((BaseTimeLineItem.BaseViewHolder)localObject1, paramInt, localSnsInfo, localTimeLineObject, i, this, this.EKk.Zw(paramInt));
        if ((!au.fC(localSnsInfo.getSnsId(), 2)) || (i == 22)) {
          break label1078;
        }
        paramView = au.aPp(localSnsInfo.getSnsId());
        if (localSnsInfo.field_snsId == 0L) {
          paramView = new au.b();
        }
        if (!paramView.iGD) {
          break label1070;
        }
        if (paramView.aGI) {
          break label1054;
        }
        BaseTimeLineItem.a(paramView, (BaseTimeLineItem.BaseViewHolder)localObject1, paramView.result, paramView.brand);
        this.EKt.put(Integer.valueOf(paramInt), localObject3);
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
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.g();
      continue;
      localObject1 = new p();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.f();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.n();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.h();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.d();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.c();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.i();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.c.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.r();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.c.a();
      continue;
      localObject3 = new m.a();
      localObject2 = localObject3;
      continue;
      Log.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", localException1, "create holder error", new Object[0]);
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject3 = paramView;
      continue;
      label1054:
      BaseTimeLineItem.k((BaseTimeLineItem.BaseViewHolder)localObject1);
      au.fB(paramView.id, 2);
      continue;
      label1070:
      BaseTimeLineItem.j((BaseTimeLineItem.BaseViewHolder)localObject1);
      continue;
      label1078:
      BaseTimeLineItem.k((BaseTimeLineItem.BaseViewHolder)localObject1);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203668);
    EventCenter.instance.removeListener(this.EBN);
    EventCenter.instance.removeListener(this.EBM);
    EventCenter.instance.removeListener(this.EBO);
    AppMethodBeat.o(203668);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203669);
    EventCenter.instance.addListener(this.EBN);
    EventCenter.instance.addListener(this.EBM);
    EventCenter.instance.addListener(this.EBO);
    AppMethodBeat.o(203669);
  }
  
  public static abstract interface a
  {
    public abstract String getKey();
    
    public abstract void vv(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract boolean fiX();
  }
  
  public static final class c
    implements ay.b.a
  {
    aa EKM = null;
    int mPosition;
    
    public c(aa paramaa, int paramInt)
    {
      this.EKM = paramaa;
      this.mPosition = paramInt;
    }
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(99235);
      if (paramBoolean)
      {
        com.tencent.mm.kernel.g.aAi();
        if (com.tencent.mm.kernel.g.aAf().azp()) {
          aj.dRd().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(99234);
              if (bk.c.this.EKM.ffN() != null) {
                bk.c.this.EKM.ffN().request(Integer.valueOf(bk.c.this.mPosition));
              }
              bk.c.this.EKM.notifyDataSetChanged();
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
    private cnb DIq;
    private SnsInfo DsC;
    private TimeLineObject EpO;
    private String dJX;
    private View targetView;
    private String url;
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(99236);
      paramContextMenuInfo = paramView.getTag();
      if ((paramContextMenuInfo instanceof s))
      {
        paramContextMenuInfo = (s)paramContextMenuInfo;
        TimeLineObject localTimeLineObject = paramContextMenuInfo.EpO;
        paramView.getContext();
        String str = bk.aRg(localTimeLineObject.ContentObj.Url);
        if ((str == null) || (str.length() == 0))
        {
          AppMethodBeat.o(99236);
          return;
        }
        this.url = str;
        this.dJX = paramContextMenuInfo.dHp;
        this.targetView = paramView;
        if (localTimeLineObject.ContentObj.LoV.size() > 0) {}
        for (paramContextMenuInfo = (cnb)localTimeLineObject.ContentObj.LoV.get(0);; paramContextMenuInfo = null)
        {
          this.DIq = paramContextMenuInfo;
          this.DsC = aj.faO().aQm(this.dJX);
          this.EpO = localTimeLineObject;
          if ((localTimeLineObject.ContentObj.LoU != 10) && (localTimeLineObject.ContentObj.LoU != 13)) {
            break;
          }
          AppMethodBeat.o(99236);
          return;
        }
        if (com.tencent.mm.br.c.aZU("favorite")) {
          switch (localTimeLineObject.ContentObj.LoU)
          {
          default: 
            paramContextMenu.add(0, 3, 0, paramView.getContext().getString(2131763947));
          }
        }
      }
      for (;;)
      {
        if ((this.DsC != null) && (!this.DsC.getUserName().equals(aj.fau()))) {
          paramContextMenu.add(0, 8, 0, paramView.getContext().getString(2131757984));
        }
        AppMethodBeat.o(99236);
        return;
        paramContextMenu.add(0, 4, 0, paramView.getContext().getString(2131763947));
        continue;
        paramContextMenu.add(0, 11, 0, paramView.getContext().getString(2131763947));
        continue;
        paramContextMenu.add(0, 5, 0, paramView.getContext().getString(2131763947));
        continue;
        paramContextMenu.add(0, 9, 0, paramView.getContext().getString(2131763947));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bk
 * JD-Core Version:    0.7.0.1
 */