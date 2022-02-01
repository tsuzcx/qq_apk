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
import com.tencent.mm.f.a.no;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.a.xo;
import com.tencent.mm.f.a.xq;
import com.tencent.mm.f.a.xr;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.at.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.item.e;
import com.tencent.mm.plugin.sns.ui.item.e.a;
import com.tencent.mm.plugin.sns.ui.item.g.a;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.item.j.a;
import com.tencent.mm.plugin.sns.ui.item.k;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.plugin.sns.ui.item.l.a;
import com.tencent.mm.plugin.sns.ui.item.o;
import com.tencent.mm.plugin.sns.ui.item.o.a;
import com.tencent.mm.plugin.sns.ui.item.p;
import com.tencent.mm.plugin.sns.ui.item.p.a;
import com.tencent.mm.plugin.sns.ui.item.q;
import com.tencent.mm.plugin.sns.ui.item.q.a;
import com.tencent.mm.plugin.sns.ui.item.r;
import com.tencent.mm.plugin.sns.ui.item.r.b;
import com.tencent.mm.plugin.sns.ui.item.t.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.ex;
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

public final class bm
  implements ae
{
  protected HashMap<String, Integer> KCy;
  public View.OnTouchListener KDW;
  protected ScaleAnimation KOP;
  protected ScaleAnimation KOQ;
  public bg KOW;
  private int KOZ;
  public boolean KOn;
  private com.tencent.mm.ui.blur.f KPB;
  private IListener KPD;
  private IListener KPE;
  private IListener KPF;
  public j KPc;
  public bu KPg;
  public int KTE;
  public boolean KTF;
  protected HashMap<String, Integer> KTH;
  private int KYA;
  public boolean KYB;
  private boolean KYC;
  private Set<String> KYD;
  private HashMap<Integer, Class<? extends BaseTimeLineItem.BaseViewHolder>> KYE;
  public View.OnClickListener KYF;
  public View.OnClickListener KYG;
  public SnsPostDescPreloadTextView.b KYH;
  public View.OnClickListener KYI;
  public View.OnClickListener KYJ;
  private HashMap<String, Boolean> KYK;
  private d KYL;
  protected ac KYn;
  public i KYo;
  protected LinkedList<SnsCommentCollapseLayout> KYp;
  public HashMap<Integer, WeakReference<View>> KYq;
  View KYr;
  public PBool KYs;
  public int KYt;
  int KYu;
  protected HashMap<String, a> KYv;
  protected HashMap<Integer, View> KYw;
  public l KYx;
  private Map<Integer, WeakReference<SnsCommentPreloadTextView>> KYy;
  public HashMap<String, String> KYz;
  public com.tencent.mm.plugin.sns.ui.d.c Kdz;
  public com.tencent.mm.ui.tools.m contextMenuHelper;
  protected MMHandler handler;
  public MMActivity iXq;
  private ListView kJh;
  private IListener ozM;
  protected int requestType;
  public com.tencent.mm.ui.widget.b.a szq;
  private IListener wNM;
  
  public bm(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.c paramc, i parami, final ac paramac)
  {
    AppMethodBeat.i(99243);
    this.KYp = new LinkedList();
    this.KYq = new HashMap();
    this.KOn = false;
    this.KTE = 0;
    this.KTF = false;
    this.KYs = new PBool();
    this.KOZ = 0;
    this.KYt = -1;
    this.KYu = 0;
    this.KCy = new HashMap();
    this.KTH = new HashMap();
    this.KYv = new HashMap();
    this.KYw = new HashMap();
    this.requestType = 0;
    this.handler = new MMHandler();
    this.KYy = new HashMap();
    this.KYz = new HashMap();
    this.KYA = 2;
    this.KPB = null;
    this.KYB = false;
    this.KYC = false;
    this.KYD = new HashSet();
    this.KPE = new IListener() {};
    this.KPD = new IListener() {};
    this.KPF = new IListener() {};
    this.KYE = new HashMap();
    this.KYE.put(Integer.valueOf(6), q.a.class);
    this.KYE.put(Integer.valueOf(2), o.a.class);
    this.KYE.put(Integer.valueOf(3), o.a.class);
    this.KYE.put(Integer.valueOf(4), o.a.class);
    this.KYE.put(Integer.valueOf(5), o.a.class);
    this.KYE.put(Integer.valueOf(0), o.a.class);
    this.KYE.put(Integer.valueOf(24), l.a.class);
    this.KYE.put(Integer.valueOf(1), o.a.class);
    this.KYE.put(Integer.valueOf(7), o.a.class);
    this.KYE.put(Integer.valueOf(8), o.a.class);
    this.KYE.put(Integer.valueOf(9), o.a.class);
    this.KYE.put(Integer.valueOf(11), r.b.class);
    this.KYE.put(Integer.valueOf(13), com.tencent.mm.plugin.sns.ui.item.a.a.class);
    this.KYE.put(Integer.valueOf(14), g.a.class);
    this.KYE.put(Integer.valueOf(27), h.a.class);
    this.KYE.put(Integer.valueOf(28), h.a.class);
    this.KYE.put(Integer.valueOf(29), h.a.class);
    this.KYE.put(Integer.valueOf(30), h.a.class);
    this.KYE.put(Integer.valueOf(31), h.a.class);
    this.KYE.put(Integer.valueOf(15), p.a.class);
    this.KYE.put(Integer.valueOf(10), o.a.class);
    this.KYE.put(Integer.valueOf(12), o.a.class);
    this.KYE.put(Integer.valueOf(16), o.a.class);
    this.KYE.put(Integer.valueOf(17), j.a.class);
    this.KYE.put(Integer.valueOf(18), e.a.class);
    this.KYE.put(Integer.valueOf(20), d.a.class);
    this.KYE.put(Integer.valueOf(25), d.a.class);
    this.KYE.put(Integer.valueOf(21), k.a.class);
    this.KYE.put(Integer.valueOf(19), com.tencent.mm.plugin.sns.ad.timeline.c.b.a.class);
    this.KYE.put(Integer.valueOf(22), t.a.class);
    this.KYE.put(Integer.valueOf(23), com.tencent.mm.plugin.sns.ad.timeline.c.a.a.class);
    this.KYE.put(Integer.valueOf(26), com.tencent.mm.plugin.sns.ad.timeline.c.a.a.a.class);
    this.KYF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99228);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
        bm.this.KYo.KBQ = false;
        com.tencent.mm.plugin.sns.abtest.a.fJx();
        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          Log.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99228);
          return;
        }
        localObject = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.ContentObj.Sqq == 21))
        {
          cvu localcvu = ((BaseTimeLineItem.BaseViewHolder)localObject).postInfo;
          if ((!com.tencent.mm.model.z.bcZ().equals(((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject.UserName)) && ((localcvu == null) || (localcvu.gbp == 0)))
          {
            Log.i("MicroMsg.SnsTimeLineBaseAdapter", "snsCommentFix showTipsDialog.");
            com.tencent.mm.plugin.sns.lucky.ui.a.f(bm.this.iXq, ((BaseTimeLineItem.BaseViewHolder)localObject).Lll.agW(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99228);
            return;
          }
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject).isAd) {
          com.tencent.mm.plugin.sns.ad.i.j.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(((BaseTimeLineItem.BaseViewHolder)localObject).fAg, paramAnonymousView, bm.this.KYo.KBN));
        }
        if ((bm.this.iXq instanceof z))
        {
          Log.i("MicroMsg.SnsTimeLineBaseAdapter", "snsCommentFix addCommentView.");
          ((z)bm.this.iXq).gC(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99228);
      }
    };
    this.KYG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        if ((bm.this.KCy.containsKey(paramAnonymousView.fAg)) && (((Integer)bm.this.KCy.get(paramAnonymousView.fAg)).equals(Integer.valueOf(0))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        if ((bm.this.KCy.containsKey(paramAnonymousView.fAg)) && (((Integer)bm.this.KCy.get(paramAnonymousView.fAg)).equals(Integer.valueOf(1))))
        {
          bm.this.KCy.put(paramAnonymousView.fAg, Integer.valueOf(2));
          bm.this.KYn.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99229);
          return;
        }
        bm.this.KCy.put(paramAnonymousView.fAg, Integer.valueOf(1));
        bm.this.KYn.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99229);
      }
    };
    this.KYH = new SnsPostDescPreloadTextView.b()
    {
      public final void fXj()
      {
        AppMethodBeat.i(210592);
        bm.this.KYn.notifyDataSetChanged();
        AppMethodBeat.o(210592);
      }
    };
    this.KYI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99231);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((!bm.this.KTF) || (bm.this.KTE <= 0))
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
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "likeCollapListener onclick %s", new Object[] { paramAnonymousView.fAg });
        if ((bm.this.KTH.containsKey(paramAnonymousView.fAg)) && ((((Integer)bm.this.KTH.get(paramAnonymousView.fAg)).equals(Integer.valueOf(1))) || (((Integer)bm.this.KTH.get(paramAnonymousView.fAg)).equals(Integer.valueOf(3)))))
        {
          bm.this.KTH.put(paramAnonymousView.fAg, Integer.valueOf(2));
          com.tencent.mm.plugin.sns.k.g.Kia.cz(com.tencent.mm.plugin.sns.data.t.Qu(paramAnonymousView.LkI), true);
        }
        for (;;)
        {
          bm.this.KYn.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99231);
          return;
          bm.this.KTH.put(paramAnonymousView.fAg, Integer.valueOf(1));
          com.tencent.mm.plugin.sns.k.g.Kia.cz(com.tencent.mm.plugin.sns.data.t.Qu(paramAnonymousView.LkI), false);
        }
      }
    };
    this.KYJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(223292);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousView.getParent() == null) || (!(paramAnonymousView.getParent() instanceof SnsCommentCollapseLayout)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(223292);
          return;
        }
        if ((((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() == null) || (!(((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag() instanceof m)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(223292);
          return;
        }
        localObject = (m)((SnsCommentCollapseLayout)paramAnonymousView.getParent()).getTag();
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(223292);
          return;
        }
        try
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((m)localObject).lpy);
          paramAnonymousView.putExtra("sns_local_id", ((m)localObject).KCD);
          paramAnonymousView.putExtra("sns_comment_buf", ((m)localObject).JVu.toByteArray());
          paramAnonymousView.putExtra("sns_content_source", 2);
          paramAnonymousView.setClass(bm.this.iXq, SnsSingleTextViewUI.class);
          localObject = bm.this.iXq;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(223292);
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
    this.KDW = Util.genLinearPressedListener();
    this.KYK = new HashMap();
    this.KYL = new d();
    this.ozM = new IListener() {};
    this.wNM = new IListener() {};
    this.KYn = paramac;
    this.KYo = parami;
    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
    this.kJh = paramListView;
    aj.fOF();
    this.iXq = paramMMActivity;
    this.Kdz = paramc;
    this.contextMenuHelper = new com.tencent.mm.ui.tools.m(paramMMActivity);
    this.szq = new com.tencent.mm.ui.widget.b.a(paramMMActivity);
    this.KOW = new bg(paramMMActivity);
    this.KOP = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.KOP.setDuration(150L);
    this.KOQ = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.KOQ.setDuration(150L);
    this.KPc = new j(paramMMActivity, 0, parami.KBO);
    this.KYx = new l(parami);
    this.requestType = 10;
    this.KPg = new bu(paramMMActivity, new bu.a()
    {
      public final void ezQ()
      {
        AppMethodBeat.i(268326);
        paramac.notifyDataSetChanged();
        AppMethodBeat.o(268326);
      }
    }, 0, parami.KBO);
    boolean bool;
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      this.KTE = this.KYA;
      this.KTF = true;
      this.KPB = new com.tencent.mm.ui.blur.f(paramMMActivity);
      if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VDH, 0) != 1) {
        break label1324;
      }
      bool = true;
      label1078:
      this.KYB = bool;
      if (Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_sns_timeline_skip_crash_item", "0", false, true)) <= 0) {
        break label1330;
      }
      bool = true;
      label1107:
      this.KYC = bool;
      paramc = MultiProcessMMKV.getMMKV("SnsTimelineMMKV");
      paramMMActivity = paramc.getString("SnsTimelineMMKVLastShowItemId", "");
      if (!Util.isNullOrNil(paramMMActivity))
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(150, 91);
        paramc.encode("SnsTimelineMMKVLastShowItemId", "");
        parami = paramc.getString("SnsTimelineMMKVLastCrashItemId", "");
        if ((!Util.isNullOrNil(parami)) && (parami.equals(paramMMActivity))) {
          break label1336;
        }
        paramc.encode("SnsTimelineMMKVLastCrashItemId", paramMMActivity);
        paramc.encode("SnsTimelineMMKVLastCrashItemCount", 1);
      }
    }
    for (;;)
    {
      if (this.KYC) {
        this.KYD = paramc.getStringSet("SnsTimelineMMKVNeedSkipItem", new HashSet());
      }
      AppMethodBeat.o(99243);
      return;
      for (;;)
      {
        try
        {
          this.KTE = Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.dgX().gO(com.tencent.mm.plugin.expt.b.b.a.vMZ.name(), "0"));
          if (Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.dgX().gO(com.tencent.mm.plugin.expt.b.b.a.vNa.name(), "0")) != 1) {
            break label1318;
          }
          bool = true;
          this.KTF = bool;
        }
        catch (NumberFormatException paramListView)
        {
          Log.w("MicroMsg.SnsTimeLineBaseAdapter", "parse like collapse config error: %s", new Object[] { paramListView.getMessage() });
        }
        break;
        label1318:
        bool = false;
      }
      label1324:
      bool = false;
      break label1078;
      label1330:
      bool = false;
      break label1107;
      label1336:
      int i = paramc.getInt("SnsTimelineMMKVLastCrashItemCount", 0) + 1;
      if (i >= Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_sns_timeline_skip_crash_item_count", "3", false, true)))
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(150, 92);
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
  
  public static int Z(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(292875);
    int i = g(paramSnsInfo, true);
    AppMethodBeat.o(292875);
    return i;
  }
  
  public static String a(TimeLineObject paramTimeLineObject, Context paramContext)
  {
    AppMethodBeat.i(99250);
    paramTimeLineObject = com.tencent.mm.plugin.sns.c.a.mIH.e(paramContext, paramTimeLineObject.AppInfo.Id, "timeline");
    AppMethodBeat.o(99250);
    return paramTimeLineObject;
  }
  
  public static boolean aXq(String paramString)
  {
    AppMethodBeat.i(208910);
    if (!com.tencent.mm.bb.a.bnx())
    {
      AppMethodBeat.o(208910);
      return false;
    }
    com.tencent.mm.bb.f localf = com.tencent.mm.bb.a.bnA();
    if ((localf != null) && (com.tencent.mm.bb.a.e(localf)) && (paramString.equals(localf.lVt)))
    {
      AppMethodBeat.o(208910);
      return true;
    }
    AppMethodBeat.o(208910);
    return false;
  }
  
  private static ArrayList<at.b> bcf(String paramString)
  {
    AppMethodBeat.i(208905);
    ArrayList localArrayList = new ArrayList();
    if (at.fPv().size() <= 0)
    {
      AppMethodBeat.o(208905);
      return localArrayList;
    }
    Iterator localIterator = at.fPv().keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (((String)localObject).startsWith(paramString))
      {
        localObject = (at.b)at.fPv().get(localObject);
        if (at.c((at.b)localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    AppMethodBeat.o(208905);
    return localArrayList;
  }
  
  public static String bcg(String paramString)
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
  
  public static String bch(String paramString)
  {
    AppMethodBeat.i(99251);
    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.mIH.V(paramString, "timeline");
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
    int i;
    if (((TimeLineObject)localObject).ContentObj.Sqq == 1)
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
          i = com.tencent.mm.plugin.sns.data.m.u(paramSnsInfo);
          AppMethodBeat.o(99247);
          return i;
        }
        if (paramSnsInfo.isSphereCardAd())
        {
          AppMethodBeat.o(99247);
          return 15;
        }
      }
      i = ((TimeLineObject)localObject).ContentObj.Sqr.size();
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
    switch (((TimeLineObject)localObject).ContentObj.Sqq)
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
        localObject = com.tencent.mm.plugin.comm.a.ubo;
        if (!com.tencent.mm.plugin.comm.a.asG(paramSnsInfo)) {
          break;
        }
        AppMethodBeat.o(99247);
        return 24;
      }
      paramSnsInfo = com.tencent.mm.plugin.comm.a.ubo;
      if (!com.tencent.mm.plugin.comm.a.cPi())
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
          i = com.tencent.mm.plugin.sns.data.m.u(paramSnsInfo);
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
          i = com.tencent.mm.plugin.sns.data.m.u(paramSnsInfo);
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
    case 43: 
      AppMethodBeat.o(99247);
      return 25;
    case 36: 
      AppMethodBeat.o(99247);
      return 21;
    }
    switch (((TimeLineObject)localObject).ContentObj.loX)
    {
    default: 
      AppMethodBeat.o(99247);
      return 1;
    }
    AppMethodBeat.o(99247);
    return 16;
  }
  
  public final void M(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(99253);
    a locala = (a)this.KYv.get(paramString);
    if ((locala != null) && (Util.isEqual(locala.getKey(), paramString))) {
      locala.yZ(paramBoolean);
    }
    AppMethodBeat.o(99253);
  }
  
  public final void a(SnsCommentCollapseLayout paramSnsCommentCollapseLayout)
  {
    AppMethodBeat.i(99239);
    this.KYp.add(paramSnsCommentCollapseLayout);
    AppMethodBeat.o(99239);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(99254);
    if (parama != null) {
      this.KYv.put(paramString, parama);
    }
    AppMethodBeat.o(99254);
  }
  
  public final void aH(Runnable paramRunnable)
  {
    AppMethodBeat.i(99252);
    this.KYn.fTJ();
    paramRunnable.run();
    AppMethodBeat.o(99252);
  }
  
  public final SnsInfo agM(int paramInt)
  {
    AppMethodBeat.i(99257);
    SnsInfo localSnsInfo = this.KYn.agM(paramInt);
    AppMethodBeat.o(99257);
    return localSnsInfo;
  }
  
  public final boolean agO(int paramInt)
  {
    AppMethodBeat.i(99259);
    if ((paramInt < this.kJh.getFirstVisiblePosition() - 1) || (paramInt > this.kJh.getLastVisiblePosition() - 1))
    {
      AppMethodBeat.o(99259);
      return false;
    }
    AppMethodBeat.o(99259);
    return true;
  }
  
  public final void fXa()
  {
    AppMethodBeat.i(99237);
    this.KCy.clear();
    this.KTH.clear();
    AppMethodBeat.o(99237);
  }
  
  public final z fXb()
  {
    if ((this.iXq instanceof z)) {
      return (z)this.iXq;
    }
    return null;
  }
  
  public final SnsCommentCollapseLayout fXc()
  {
    AppMethodBeat.i(99238);
    if (this.KYp.size() == 0)
    {
      localSnsCommentCollapseLayout = new SnsCommentCollapseLayout(this.iXq);
      AppMethodBeat.o(99238);
      return localSnsCommentCollapseLayout;
    }
    SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.KYp.removeFirst();
    AppMethodBeat.o(99238);
    return localSnsCommentCollapseLayout;
  }
  
  public final boolean fXd()
  {
    AppMethodBeat.i(99240);
    if (this.KYp != null) {
      this.KYp.clear();
    }
    if (this.KYE != null) {
      this.KYE.clear();
    }
    com.tencent.mm.pluginsdk.ui.span.l.clearCache();
    com.tencent.mm.kiss.widget.textview.c.kfZ.aIM();
    if (this.KYs.value) {
      ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vNa, 0);
    }
    if (this.KPB != null)
    {
      this.KPB.destroy();
      this.KPB = null;
    }
    AppMethodBeat.o(99240);
    return true;
  }
  
  public final void fXe()
  {
    AppMethodBeat.i(99242);
    this.KYn.fTJ();
    AppMethodBeat.o(99242);
  }
  
  public final void fXf()
  {
    AppMethodBeat.i(99244);
    int i = this.kJh.getFirstVisiblePosition() - this.kJh.getHeaderViewsCount();
    int j = this.kJh.getLastVisiblePosition() - this.kJh.getHeaderViewsCount();
    Log.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + i + " " + j);
    int k = this.KYn.getCount();
    if ((i <= j) && (i < k))
    {
      Object localObject1 = agM(i);
      Object localObject2 = (View)this.KYw.get(Integer.valueOf(i));
      if ((localObject2 == null) || (localObject1 == null) || (((View)localObject2).getTag() == null)) {
        Log.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (BaseTimeLineItem.BaseViewHolder)((View)localObject2).getTag();
        Log.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + ((BaseTimeLineItem.BaseViewHolder)localObject2).position);
        BaseTimeLineItem localBaseTimeLineItem = ((BaseTimeLineItem.BaseViewHolder)localObject2).LlL;
        bn localbn = this.KYn.agN(i);
        localObject1 = ((SnsInfo)localObject1).getTimeLine();
        localBaseTimeLineItem.a((BaseTimeLineItem.BaseViewHolder)localObject2, i, localbn, (TimeLineObject)localObject1, ((BaseTimeLineItem.BaseViewHolder)localObject2).viewType, localBaseTimeLineItem.Kee);
        localBaseTimeLineItem.a(localbn, (TimeLineObject)localObject1);
      }
    }
    AppMethodBeat.o(99244);
  }
  
  public final ac fXg()
  {
    return this.KYn;
  }
  
  public final void fXh()
  {
    AppMethodBeat.i(99255);
    this.KYv.clear();
    AppMethodBeat.o(99255);
  }
  
  public final com.tencent.mm.ui.widget.b.a fXi()
  {
    AppMethodBeat.i(99260);
    if (this.szq != null) {
      this.szq.cFD();
    }
    this.szq = new com.tencent.mm.ui.widget.b.a(this.iXq);
    com.tencent.mm.ui.widget.b.a locala = this.szq;
    AppMethodBeat.o(99260);
    return locala;
  }
  
  public final void gG(View paramView)
  {
    AppMethodBeat.i(99256);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      AppMethodBeat.o(99256);
      return;
    }
    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
    if ((this.KYr != null) && (this.KYr.getVisibility() == 0))
    {
      this.KYr.startAnimation(this.KOQ);
      this.KOQ.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(267993);
          if (bm.this.KYr != null)
          {
            bm.this.KYr.clearAnimation();
            bm.this.KYr.setVisibility(8);
          }
          bm.this.KYr = null;
          AppMethodBeat.o(267993);
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
    int i = this.KYn.getCount();
    AppMethodBeat.o(99258);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99246);
    SnsInfo localSnsInfo = this.KYn.agM(paramInt);
    if (this.KYo.fTj() == 1) {}
    for (paramInt = g(localSnsInfo, false);; paramInt = g(localSnsInfo, true))
    {
      AppMethodBeat.o(99246);
      return paramInt;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(99241);
    this.KYn.notifyDataSetChanged();
    AppMethodBeat.o(99241);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(208911);
    EventCenter.instance.removeListener(this.KPE);
    EventCenter.instance.removeListener(this.KPD);
    EventCenter.instance.removeListener(this.KPF);
    this.ozM.dead();
    this.wNM.dead();
    AppMethodBeat.o(208911);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(208912);
    EventCenter.instance.addListener(this.KPE);
    EventCenter.instance.addListener(this.KPD);
    EventCenter.instance.addListener(this.KPF);
    this.ozM.alive();
    this.wNM.alive();
    AppMethodBeat.o(208912);
  }
  
  public final View r(int paramInt, View paramView)
  {
    AppMethodBeat.i(99245);
    SnsInfo localSnsInfo = this.KYn.agM(paramInt);
    TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
    Object localObject1;
    if ((localTimeLineObject != null) && (!Util.isNullOrNil(localTimeLineObject.Id)))
    {
      if ((this.KYC) && (this.KYD.contains(localTimeLineObject.Id)))
      {
        Log.e("MicroMsg.SnsTimeLineBaseAdapter", "createView skipItemSet includes this id:%s", new Object[] { localTimeLineObject.Id });
        com.tencent.mm.plugin.report.service.h.IzE.el(150, 93);
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = new View(this.iXq);
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
        localObject1 = new View(this.iXq);
      }
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(99245);
      return localObject1;
    }
    int i;
    Object localObject4;
    Object localObject2;
    int j;
    if (this.KYo.fTj() == 1)
    {
      i = g(localSnsInfo, false);
      localObject1 = null;
      localObject3 = null;
      localObject4 = localObject1;
      localObject2 = localObject3;
      if (paramView != null)
      {
        localObject2 = paramView.getTag(i.f.sns_item_root);
        if (!(localObject2 instanceof Integer)) {
          break label765;
        }
        j = ((Integer)localObject2).intValue();
        label283:
        localObject4 = localObject1;
        localObject2 = localObject3;
        if (j == i)
        {
          localObject2 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
          localObject4 = ((BaseTimeLineItem.BaseViewHolder)localObject2).LlL;
        }
      }
      localObject1 = localObject2;
      localObject3 = paramView;
      if (localObject2 == null) {
        switch (i)
        {
        default: 
          localObject1 = new com.tencent.mm.plugin.sns.ui.item.n();
        }
      }
    }
    for (;;)
    {
      label765:
      try
      {
        if (this.KYE.get(Integer.valueOf(i)) != null)
        {
          localObject3 = (BaseTimeLineItem.BaseViewHolder)((Class)this.KYE.get(Integer.valueOf(i))).newInstance();
          localObject2 = localObject3;
          localObject3 = paramView;
        }
      }
      catch (Exception localException1) {}
      try
      {
        ((BaseTimeLineItem.BaseViewHolder)localObject2).LlL = ((BaseTimeLineItem)localObject1);
        localObject3 = paramView;
        ((BaseTimeLineItem.BaseViewHolder)localObject2).timeLineObject = localTimeLineObject;
        localObject3 = paramView;
        paramView = ((BaseTimeLineItem)localObject1).a(this.iXq, (BaseTimeLineItem.BaseViewHolder)localObject2, i, this, localSnsInfo);
        localObject3 = paramView;
        paramView.setTag(i.f.sns_item_root, Integer.valueOf(i));
        localObject4 = localObject1;
        localObject3 = paramView;
        localObject1 = localObject2;
        ((BaseTimeLineItem)localObject4).setIsFromMainTimeline(this.KOn);
        ((BaseTimeLineItem)localObject4).LkG = bcf(localSnsInfo.getSnsId());
        ((BaseTimeLineItem)localObject4).a((BaseTimeLineItem.BaseViewHolder)localObject1, paramInt, localSnsInfo, localTimeLineObject, i, this, this.KYn.agN(paramInt));
        if ((!at.gf(localSnsInfo.getSnsId(), 2)) || (i == 22)) {
          break label1190;
        }
        paramView = at.bal(localSnsInfo.getSnsId());
        if (localSnsInfo.field_snsId == 0L) {
          paramView = new at.b();
        }
        if (!paramView.lwF) {
          break label1182;
        }
        if (paramView.lAQ) {
          break label1166;
        }
        BaseTimeLineItem.a(paramView, (BaseTimeLineItem.BaseViewHolder)localObject1, paramView.result, paramView.brand);
        this.KYw.put(Integer.valueOf(paramInt), localObject3);
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
      localObject1 = new q();
      continue;
      localObject1 = new o();
      continue;
      localObject1 = new o();
      continue;
      localObject1 = new o();
      continue;
      localObject1 = new o();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.m();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.l();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.n();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.s();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.i();
      continue;
      localObject1 = new r();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.g();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.h();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a.d();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a.a();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a.c();
      continue;
      localObject1 = new p();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.j();
      continue;
      localObject1 = new e();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.d();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.c();
      continue;
      localObject1 = new k();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.c.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.t();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.c.a();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.c.a.a();
      continue;
      localObject3 = new o.a();
      localObject2 = localObject3;
      continue;
      Log.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", localException1, "create holder error", new Object[0]);
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject3 = paramView;
      continue;
      label1166:
      BaseTimeLineItem.j((BaseTimeLineItem.BaseViewHolder)localObject1);
      at.ge(paramView.id, 2);
      continue;
      label1182:
      BaseTimeLineItem.i((BaseTimeLineItem.BaseViewHolder)localObject1);
      continue;
      label1190:
      BaseTimeLineItem.j((BaseTimeLineItem.BaseViewHolder)localObject1);
    }
  }
  
  public static abstract interface a
  {
    public abstract String getKey();
    
    public abstract void yZ(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract boolean fXk();
  }
  
  public static final class c
    implements az.b.a
  {
    ac KYP = null;
    int mPosition;
    
    public c(ac paramac, int paramInt)
    {
      this.KYP = paramac;
      this.mPosition = paramInt;
    }
    
    public final void s(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(99235);
      if (paramBoolean)
      {
        com.tencent.mm.kernel.h.aHH();
        if (com.tencent.mm.kernel.h.aHE().aGM()) {
          aj.etE().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(99234);
              if (bm.c.this.KYP.fTK() != null) {
                bm.c.this.KYP.fTK().request(Integer.valueOf(bm.c.this.mPosition));
              }
              bm.c.this.KYP.notifyDataSetChanged();
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
    private cvt JVq;
    private SnsInfo Jzk;
    private TimeLineObject KCX;
    private String fCM;
    private View kJL;
    private String url;
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(99236);
      paramContextMenuInfo = paramView.getTag();
      if ((paramContextMenuInfo instanceof s))
      {
        paramContextMenuInfo = (s)paramContextMenuInfo;
        TimeLineObject localTimeLineObject = paramContextMenuInfo.KCX;
        paramView.getContext();
        String str = bm.bch(localTimeLineObject.ContentObj.Url);
        if ((str == null) || (str.length() == 0))
        {
          AppMethodBeat.o(99236);
          return;
        }
        this.url = str;
        this.fCM = paramContextMenuInfo.fAg;
        this.kJL = paramView;
        if (localTimeLineObject.ContentObj.Sqr.size() > 0) {}
        for (paramContextMenuInfo = (cvt)localTimeLineObject.ContentObj.Sqr.get(0);; paramContextMenuInfo = null)
        {
          this.JVq = paramContextMenuInfo;
          this.Jzk = aj.fOI().bbl(this.fCM);
          this.KCX = localTimeLineObject;
          if ((localTimeLineObject.ContentObj.Sqq != 10) && (localTimeLineObject.ContentObj.Sqq != 13)) {
            break;
          }
          AppMethodBeat.o(99236);
          return;
        }
        if (com.tencent.mm.by.c.blP("favorite")) {
          switch (localTimeLineObject.ContentObj.Sqq)
          {
          default: 
            paramContextMenu.add(0, 3, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
          }
        }
      }
      for (;;)
      {
        if ((this.Jzk != null) && (!this.Jzk.getUserName().equals(aj.fOo()))) {
          paramContextMenu.add(0, 8, 0, paramView.getContext().getString(i.j.contact_info_op_sns_permission));
        }
        AppMethodBeat.o(99236);
        return;
        paramContextMenu.add(0, 4, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        continue;
        paramContextMenu.add(0, 11, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        continue;
        paramContextMenu.add(0, 5, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        continue;
        paramContextMenu.add(0, 9, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bm
 * JD-Core Version:    0.7.0.1
 */