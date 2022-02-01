package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.b.a.fu;
import com.tencent.mm.g.b.a.fv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.g.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.blur.c;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "blurLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "uiContext", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "buildRender", "", "finish", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class d
  extends LinearLayout
  implements a
{
  public static final d.a BpI;
  private int BpA;
  private int BpB;
  private View BpC;
  private TextView BpD;
  private boolean BpE;
  private BlurView BpF;
  private fu BpG;
  private LinkedHashMap<String, ArrayList<Long>> BpH;
  private RecyclerView Bpo;
  private List<d.b> Bpr;
  private d.c Bpy;
  private int Bpz;
  private Context uiContext;
  
  static
  {
    AppMethodBeat.i(119999);
    BpI = new d.a((byte)0);
    AppMethodBeat.o(119999);
  }
  
  public d(Context arg1, View.OnClickListener arg2)
  {
    super(???);
    AppMethodBeat.i(119998);
    this.Bpz = -1;
    this.BpA = -1;
    this.BpB = -1;
    this.Bpr = Collections.synchronizedList((List)new LinkedList());
    this.BpG = new fu();
    this.BpH = new LinkedHashMap();
    this.uiContext = ???;
    Object localObject1 = LayoutInflater.from(???).inflate(2131495690, (ViewGroup)this, true);
    if (localObject1 == null)
    {
      ??? = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(119998);
      throw ???;
    }
    localObject1 = (LinearLayout)localObject1;
    Object localObject4 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131304983);
    Object localObject2 = LayoutInflater.from(???).inflate(2131495688, null);
    Object localObject3 = new ViewGroup.LayoutParams(-1, -1);
    if (((a.a)com.tencent.mm.plugin.story.c.a.a.AZY.att()).xNN)
    {
      this.BpF = new BlurView(???);
      Object localObject5 = this.BpF;
      if (localObject5 != null) {
        ((BlurView)localObject5).adm(Color.parseColor("#B31D1D1D"));
      }
      localObject5 = this.uiContext;
      if (localObject5 == null) {
        p.bdF("uiContext");
      }
      if (localObject5 == null)
      {
        ??? = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(119998);
        throw ???;
      }
      Object localObject6 = (MMActivity)localObject5;
      localObject5 = ((MMActivity)localObject6).getWindow();
      p.g(localObject5, "activity.window");
      localObject5 = ((Window)localObject5).getDecorView();
      if (localObject5 == null)
      {
        ??? = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(119998);
        throw ???;
      }
      localObject5 = (ViewGroup)localObject5;
      localObject6 = ((MMActivity)localObject6).getWindow();
      p.g(localObject6, "activity.window");
      localObject6 = ((Window)localObject6).getDecorView();
      p.g(localObject6, "activity.window.decorView");
      localObject6 = ((View)localObject6).getBackground();
      i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 20);
      BlurView localBlurView = this.BpF;
      if (localBlurView != null)
      {
        localObject5 = localBlurView.B((ViewGroup)localObject5).fEl().G((Drawable)localObject6);
        localObject6 = this.uiContext;
        if (localObject6 == null) {
          p.bdF("uiContext");
        }
        ((BlurView)localObject5).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f((Context)localObject6)).bU(20.0F).fEk().bT(i * 1.0F);
      }
      ((LinearLayout)localObject4).addView((View)this.BpF, (ViewGroup.LayoutParams)localObject3);
      localObject4 = this.BpF;
      if (localObject4 != null) {
        ((BlurView)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      ((LinearLayout)localObject1).findViewById(2131298372).setOnClickListener(???);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131302877);
      p.g(localObject2, "parent.findViewById<View>(R.id.no_data)");
      this.BpC = ((View)localObject2);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131298351);
      p.g(localObject2, "parent.findViewById<TextView>(R.id.clear_txt)");
      this.BpD = ((TextView)localObject2);
      this.BpD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119982);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = this.BpJ;
          boolean bool;
          if (!d.a(this.BpJ))
          {
            bool = true;
            d.a(paramAnonymousView, bool);
            if (!d.a(this.BpJ)) {
              break label96;
            }
            d.b(this.BpJ);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119982);
            return;
            bool = false;
            break;
            label96:
            d.c(this.BpJ);
          }
        }
      });
      localObject1 = ((LinearLayout)localObject1).findViewById(2131305410);
      p.g(localObject1, "parent.findViewById(R.id.story_entrance_recycler)");
      this.Bpo = ((RecyclerView)localObject1);
      this.Bpo.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
      this.Bpy = new d.c(this);
      this.Bpo.setItemViewCacheSize(0);
      this.Bpo.setAdapter((RecyclerView.a)this.Bpy);
      this.Bpy.sLA = ((d.g.a.m)new q(???) {});
      ??? = com.tencent.mm.plugin.story.f.f.a.BeK.ekI();
      localObject1 = com.tencent.mm.plugin.story.f.f.a.BeK.ekJ();
      this.BpH = com.tencent.mm.plugin.story.f.f.a.BeK.ekK();
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxz, 1) == 1)
      {
        if (((Collection)???).isEmpty()) {
          break label982;
        }
        i = 1;
        label696:
        if (i == 0) {
          break label987;
        }
        ??? = com.tencent.mm.plugin.story.g.f.BgS;
        ??? = f.a.cb((String)???.get(0), false);
        if (??? != null)
        {
          localObject2 = com.tencent.mm.plugin.story.ui.view.gallery.m.BwQ;
          com.tencent.mm.plugin.story.ui.view.gallery.m.x(d.a.j.listOf(???.Bec), 5);
        }
      }
      label739:
      ae.i("MicroMsg.StoryEntranceView", "userNames " + ???.size() + " lastUserNames " + ((List)localObject1).size());
      if (((Map)this.BpH).isEmpty()) {
        break label1054;
      }
    }
    label1052:
    label1054:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.Bpr.add(new d.b("", 4));
        this.BpB = (this.BpH.size() + 1);
      }
      ??? = this.BpH.entrySet();
      p.g(???, "replyToIndexMap.entries");
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1059;
        }
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = this.Bpr;
        localObject4 = ((Map.Entry)localObject4).getKey();
        p.g(localObject4, "it.key");
        ((List)localObject3).add(new d.b((String)localObject4, 5));
      }
      p.g(localObject2, "contentLayout");
      ((View)localObject2).setBackground(???.getResources().getDrawable(2131231155));
      ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      break;
      label982:
      i = 0;
      break label696;
      label987:
      if (!((Collection)localObject1).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1052;
        }
        ??? = com.tencent.mm.plugin.story.g.f.BgS;
        ??? = f.a.cb((String)((List)localObject1).get(0), false);
        if (??? == null) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.story.ui.view.gallery.m.BwQ;
        com.tencent.mm.plugin.story.ui.view.gallery.m.x(d.a.j.listOf(???.Bec), 5);
        break;
      }
      break label739;
    }
    label1059:
    localObject2 = z.Nhr;
    if (!???.isEmpty())
    {
      this.Bpz = this.Bpr.size();
      this.Bpr.add(new d.b("", 3));
    }
    ??? = com.tencent.mm.plugin.story.h.h.BjR;
    com.tencent.mm.plugin.story.h.h.eoe().iI(???.size());
    ??? = "";
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.Bpr.add(new d.b((String)localObject3, 1));
          localObject4 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject4).azF().BH((String)localObject3);
          p.g(localObject4, "contact");
          if (((an)localObject4).adx())
          {
            localObject4 = com.tencent.mm.plugin.story.h.h.BjR;
            localObject4 = com.tencent.mm.plugin.story.h.h.eoe();
            ((fv)localObject4).iJ(((fv)localObject4).TD() + 1);
          }
          ??? = ??? + '|' + (String)localObject3;
          continue;
        }
        localObject2 = z.Nhr;
        if (((CharSequence)???).length() > 0)
        {
          i = 1;
          ??? = ???;
          if (i == 0) {
            break label1366;
          }
          if (??? != null) {
            break;
          }
          ??? = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(119998);
          throw ???;
        }
      }
      i = 0;
    }
    ??? = ???.substring(1);
    p.g(???, "(this as java.lang.String).substring(startIndex)");
    label1366:
    ??? = com.tencent.mm.plugin.story.h.h.BjR;
    com.tencent.mm.plugin.story.h.h.eoe().pf(???);
    ??? = com.tencent.mm.plugin.story.h.h.BjR;
    com.tencent.mm.plugin.story.h.h.eoe().iK(((List)localObject1).size());
    this.BpA = this.Bpr.size();
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        this.Bpr.add(new d.b("", 2));
      }
      ??? = "";
      for (;;)
      {
        synchronized ((Iterable)localObject1)
        {
          localObject1 = ???.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.Bpr.add(new d.b((String)localObject2, 1));
            localObject3 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).azF().BH((String)localObject2);
            p.g(localObject3, "contact");
            if (((an)localObject3).adx())
            {
              localObject3 = com.tencent.mm.plugin.story.h.h.BjR;
              localObject3 = com.tencent.mm.plugin.story.h.h.eoe();
              ((fv)localObject3).iL(((fv)localObject3).TE() + 1);
            }
            ??? = ??? + '|' + (String)localObject2;
            continue;
          }
          localObject1 = z.Nhr;
          if (((CharSequence)???).length() > 0)
          {
            i = 1;
            ??? = ???;
            if (i == 0) {
              break label1690;
            }
            if (??? != null) {
              break;
            }
            ??? = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(119998);
            throw ???;
          }
        }
        i = 0;
      }
      ??? = ???.substring(1);
      p.g(???, "(this as java.lang.String).substring(startIndex)");
      label1690:
      ??? = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.eoe().pg(???);
      ??? = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.eoe().lb(this.BpH.size());
      ??? = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.eof();
      ??? = this.Bpy;
      ??? = this.Bpr;
      p.g(???, "userNameList");
      p.h(???, "extInfoList");
      ???.gTw.clear();
      ???.gTw.addAll((Collection)???);
      ???.notifyDataSetChanged();
      ??? = this.BpG;
      ??? = com.tencent.mm.plugin.story.h.h.BjR;
      ???.kX(com.tencent.mm.plugin.story.h.h.eod());
      ??? = new vf();
      ???.dKz.dKA = true;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(119998);
      return;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119997);
    Object localObject1 = this.BpG;
    if (this.BpE) {}
    for (long l = 1L;; l = 0L)
    {
      ((fu)localObject1).la(l);
      this.BpG.aLH();
      if (!this.BpE) {
        break label200;
      }
      localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      com.tencent.mm.plugin.story.f.j.Be(ch.aDb() + 10L);
      localObject1 = ((Map)this.BpH).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ((Map.Entry)localObject2).getKey();
        localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Number)((Iterator)localObject2).next()).longValue();
          localObject3 = com.tencent.mm.plugin.story.f.b.b.Bdv;
          com.tencent.mm.plugin.story.f.b.b.Bf(l);
        }
      }
    }
    localObject1 = g.ajR();
    p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((e)localObject1).ajA();
    Object localObject2 = am.a.Jah;
    Object localObject3 = com.tencent.mm.plugin.story.f.j.BbE;
    ((aj)localObject1).set((am.a)localObject2, Long.valueOf(j.b.elO()));
    label200:
    localObject1 = new vf();
    ((vf)localObject1).dKz.dKA = false;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    ae.i("MicroMsg.StoryEntranceView", "finish");
    if (this.Bpr.size() > 0)
    {
      localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      ((e)localObject1).ajA().set(am.a.Jag, Long.valueOf(ch.aDb()));
    }
    localObject1 = this.BpF;
    if (localObject1 != null)
    {
      localObject1 = ((BlurView)localObject1).getBlurController();
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
    }
    localObject1 = com.tencent.mm.plugin.story.f.f.a.BeK;
    com.tencent.mm.plugin.story.f.f.a.emE();
    AppMethodBeat.o(119997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d
 * JD-Core Version:    0.7.0.1
 */