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
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.b.a.et;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.g.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.blur.c;
import d.v;
import d.y;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "blurLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "uiContext", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "buildRender", "", "finish", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class d
  extends LinearLayout
  implements a
{
  public static final d.a zGJ;
  private Context uiContext;
  private int zGA;
  private int zGB;
  private int zGC;
  private View zGD;
  private TextView zGE;
  private boolean zGF;
  private BlurView zGG;
  private et zGH;
  private LinkedHashMap<String, ArrayList<Long>> zGI;
  private RecyclerView zGp;
  private List<d.b> zGs;
  private d.c zGz;
  
  static
  {
    AppMethodBeat.i(119999);
    zGJ = new d.a((byte)0);
    AppMethodBeat.o(119999);
  }
  
  public d(Context arg1, View.OnClickListener arg2)
  {
    super(???);
    AppMethodBeat.i(119998);
    this.zGA = -1;
    this.zGB = -1;
    this.zGC = -1;
    this.zGs = Collections.synchronizedList((List)new LinkedList());
    this.zGH = new et();
    this.zGI = new LinkedHashMap();
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
    if (((a.a)com.tencent.mm.plugin.story.c.a.a.zqB.aqp()).wqa)
    {
      this.zGG = new BlurView(???);
      Object localObject5 = this.zGG;
      if (localObject5 != null) {
        ((BlurView)localObject5).aau(Color.parseColor("#B31D1D1D"));
      }
      localObject5 = this.uiContext;
      if (localObject5 == null) {
        d.g.b.k.aVY("uiContext");
      }
      if (localObject5 == null)
      {
        ??? = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(119998);
        throw ???;
      }
      Object localObject6 = (MMActivity)localObject5;
      localObject5 = ((MMActivity)localObject6).getWindow();
      d.g.b.k.g(localObject5, "activity.window");
      localObject5 = ((Window)localObject5).getDecorView();
      if (localObject5 == null)
      {
        ??? = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(119998);
        throw ???;
      }
      localObject5 = (ViewGroup)localObject5;
      localObject6 = ((MMActivity)localObject6).getWindow();
      d.g.b.k.g(localObject6, "activity.window");
      localObject6 = ((Window)localObject6).getDecorView();
      d.g.b.k.g(localObject6, "activity.window.decorView");
      localObject6 = ((View)localObject6).getBackground();
      i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 20);
      BlurView localBlurView = this.zGG;
      if (localBlurView != null)
      {
        localObject5 = localBlurView.x((ViewGroup)localObject5).fjU().F((Drawable)localObject6);
        localObject6 = this.uiContext;
        if (localObject6 == null) {
          d.g.b.k.aVY("uiContext");
        }
        ((BlurView)localObject5).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f((Context)localObject6)).bR(20.0F).fjT().bQ(i * 1.0F);
      }
      ((LinearLayout)localObject4).addView((View)this.zGG, (ViewGroup.LayoutParams)localObject3);
      localObject4 = this.zGG;
      if (localObject4 != null) {
        ((BlurView)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      ((LinearLayout)localObject1).findViewById(2131298372).setOnClickListener(???);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131302877);
      d.g.b.k.g(localObject2, "parent.findViewById<View>(R.id.no_data)");
      this.zGD = ((View)localObject2);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131298351);
      d.g.b.k.g(localObject2, "parent.findViewById<TextView>(R.id.clear_txt)");
      this.zGE = ((TextView)localObject2);
      this.zGE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119982);
          paramAnonymousView = this.zGK;
          if (!d.a(this.zGK)) {}
          for (boolean bool = true;; bool = false)
          {
            d.a(paramAnonymousView, bool);
            if (!d.a(this.zGK)) {
              break;
            }
            d.b(this.zGK);
            AppMethodBeat.o(119982);
            return;
          }
          d.c(this.zGK);
          AppMethodBeat.o(119982);
        }
      });
      localObject1 = ((LinearLayout)localObject1).findViewById(2131305410);
      d.g.b.k.g(localObject1, "parent.findViewById(R.id.story_entrance_recycler)");
      this.zGp = ((RecyclerView)localObject1);
      this.zGp.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
      this.zGz = new d.c(this);
      this.zGp.setItemViewCacheSize(0);
      this.zGp.setAdapter((RecyclerView.a)this.zGz);
      this.zGz.rFB = ((d.g.a.m)new d.g.b.l(???) {});
      ??? = com.tencent.mm.plugin.story.f.f.a.zvn.dUL();
      localObject1 = com.tencent.mm.plugin.story.f.f.a.zvn.dUM();
      this.zGI = com.tencent.mm.plugin.story.f.f.a.zvn.dUN();
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMP, 1) == 1)
      {
        if (((Collection)???).isEmpty()) {
          break label982;
        }
        i = 1;
        label696:
        if (i == 0) {
          break label987;
        }
        ??? = com.tencent.mm.plugin.story.g.f.zxv;
        ??? = f.a.bQ((String)???.get(0), false);
        if (??? != null)
        {
          localObject2 = com.tencent.mm.plugin.story.ui.view.gallery.m.zNR;
          com.tencent.mm.plugin.story.ui.view.gallery.m.u(d.a.j.listOf(???.zuF), 5);
        }
      }
      label739:
      ac.i("MicroMsg.StoryEntranceView", "userNames " + ???.size() + " lastUserNames " + ((List)localObject1).size());
      if (((Map)this.zGI).isEmpty()) {
        break label1054;
      }
    }
    label1052:
    label1054:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.zGs.add(new d.b("", 4));
        this.zGC = (this.zGI.size() + 1);
      }
      ??? = this.zGI.entrySet();
      d.g.b.k.g(???, "replyToIndexMap.entries");
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1059;
        }
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = this.zGs;
        localObject4 = ((Map.Entry)localObject4).getKey();
        d.g.b.k.g(localObject4, "it.key");
        ((List)localObject3).add(new d.b((String)localObject4, 5));
      }
      d.g.b.k.g(localObject2, "contentLayout");
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
        ??? = com.tencent.mm.plugin.story.g.f.zxv;
        ??? = f.a.bQ((String)((List)localObject1).get(0), false);
        if (??? == null) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.story.ui.view.gallery.m.zNR;
        com.tencent.mm.plugin.story.ui.view.gallery.m.u(d.a.j.listOf(???.zuF), 5);
        break;
      }
      break label739;
    }
    label1059:
    localObject2 = y.KTp;
    if (!???.isEmpty())
    {
      this.zGA = this.zGs.size();
      this.zGs.add(new d.b("", 3));
    }
    ??? = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dYg().ip(???.size());
    ??? = "";
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.zGs.add(new d.b((String)localObject3, 1));
          localObject4 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject4).awB().aNt((String)localObject3);
          d.g.b.k.g(localObject4, "contact");
          if (((ai)localObject4).aaJ())
          {
            localObject4 = com.tencent.mm.plugin.story.h.h.zAU;
            localObject4 = com.tencent.mm.plugin.story.h.h.dYg();
            ((eu)localObject4).iq(((eu)localObject4).Rq() + 1);
          }
          ??? = ??? + '|' + (String)localObject3;
          continue;
        }
        localObject2 = y.KTp;
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
    d.g.b.k.g(???, "(this as java.lang.String).substring(startIndex)");
    label1366:
    ??? = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dYg().mx(???);
    ??? = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dYg().ir(((List)localObject1).size());
    this.zGB = this.zGs.size();
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        this.zGs.add(new d.b("", 2));
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
            this.zGs.add(new d.b((String)localObject2, 1));
            localObject3 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
            d.g.b.k.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject3).awB().aNt((String)localObject2);
            d.g.b.k.g(localObject3, "contact");
            if (((ai)localObject3).aaJ())
            {
              localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
              localObject3 = com.tencent.mm.plugin.story.h.h.dYg();
              ((eu)localObject3).is(((eu)localObject3).Rr() + 1);
            }
            ??? = ??? + '|' + (String)localObject2;
            continue;
          }
          localObject1 = y.KTp;
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
      d.g.b.k.g(???, "(this as java.lang.String).substring(startIndex)");
      label1690:
      ??? = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dYg().my(???);
      ??? = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dYg().je(this.zGI.size());
      ??? = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dYh();
      ??? = this.zGz;
      ??? = this.zGs;
      d.g.b.k.g(???, "userNameList");
      d.g.b.k.h(???, "extInfoList");
      ???.gxd.clear();
      ???.gxd.addAll((Collection)???);
      ???.notifyDataSetChanged();
      ??? = this.zGH;
      ??? = com.tencent.mm.plugin.story.h.h.zAU;
      ???.ja(com.tencent.mm.plugin.story.h.h.dYf());
      ??? = new ui();
      ???.dwZ.dxa = true;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(119998);
      return;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119997);
    Object localObject1 = this.zGH;
    if (this.zGF) {}
    for (long l = 1L;; l = 0L)
    {
      ((et)localObject1).jd(l);
      this.zGH.aHZ();
      if (!this.zGF) {
        break label200;
      }
      localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      com.tencent.mm.plugin.story.f.j.yi(ce.azI() + 10L);
      localObject1 = ((Map)this.zGI).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ((Map.Entry)localObject2).getKey();
        localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Number)((Iterator)localObject2).next()).longValue();
          localObject3 = com.tencent.mm.plugin.story.f.b.b.ztY;
          com.tencent.mm.plugin.story.f.b.b.yj(l);
        }
      }
    }
    localObject1 = g.agR();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    localObject1 = ((e)localObject1).agA();
    Object localObject2 = ah.a.GTc;
    Object localObject3 = com.tencent.mm.plugin.story.f.j.zsh;
    ((ae)localObject1).set((ah.a)localObject2, Long.valueOf(j.b.dVR()));
    label200:
    localObject1 = new ui();
    ((ui)localObject1).dwZ.dxa = false;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    ac.i("MicroMsg.StoryEntranceView", "finish");
    if (this.zGs.size() > 0)
    {
      localObject1 = g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      ((e)localObject1).agA().set(ah.a.GTb, Long.valueOf(ce.azI()));
    }
    localObject1 = this.zGG;
    if (localObject1 != null)
    {
      localObject1 = ((BlurView)localObject1).getBlurController();
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
    }
    localObject1 = com.tencent.mm.plugin.story.f.f.a.zvn;
    com.tencent.mm.plugin.story.f.f.a.dWH();
    AppMethodBeat.o(119997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d
 * JD-Core Version:    0.7.0.1
 */