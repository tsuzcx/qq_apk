package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.b.a.ji;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.g.f.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.blur.c;
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
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "blurLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "uiContext", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "buildRender", "", "finish", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class d
  extends LinearLayout
  implements a
{
  public static final a FAu;
  private RecyclerView FAa;
  private List<d.b> FAd;
  private d.c FAk;
  private int FAl;
  private int FAm;
  private int FAn;
  private View FAo;
  private TextView FAp;
  private boolean FAq;
  private BlurView FAr;
  private ji FAs;
  private LinkedHashMap<String, ArrayList<Long>> FAt;
  private Context uiContext;
  
  static
  {
    AppMethodBeat.i(119999);
    FAu = new a((byte)0);
    AppMethodBeat.o(119999);
  }
  
  public d(Context arg1, View.OnClickListener arg2)
  {
    super(???);
    AppMethodBeat.i(119998);
    this.FAl = -1;
    this.FAm = -1;
    this.FAn = -1;
    this.FAd = Collections.synchronizedList((List)new LinkedList());
    this.FAs = new ji();
    this.FAt = new LinkedHashMap();
    this.uiContext = ???;
    Object localObject1 = LayoutInflater.from(???).inflate(2131496595, (ViewGroup)this, true);
    if (localObject1 == null)
    {
      ??? = new t("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(119998);
      throw ???;
    }
    localObject1 = (LinearLayout)localObject1;
    Object localObject4 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131308133);
    Object localObject2 = LayoutInflater.from(???).inflate(2131496593, null);
    Object localObject3 = new ViewGroup.LayoutParams(-1, -1);
    if (((a.a)com.tencent.mm.plugin.story.c.a.a.FkW.aLT()).BNT)
    {
      this.FAr = new BlurView(???);
      Object localObject5 = this.FAr;
      if (localObject5 != null) {
        ((BlurView)localObject5).alW(Color.parseColor("#B31D1D1D"));
      }
      localObject5 = this.uiContext;
      if (localObject5 == null) {
        p.btv("uiContext");
      }
      if (localObject5 == null)
      {
        ??? = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(119998);
        throw ???;
      }
      Object localObject6 = (MMActivity)localObject5;
      localObject5 = ((MMActivity)localObject6).getWindow();
      p.g(localObject5, "activity.window");
      localObject5 = ((Window)localObject5).getDecorView();
      if (localObject5 == null)
      {
        ??? = new t("null cannot be cast to non-null type android.view.ViewGroup");
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
      BlurView localBlurView = this.FAr;
      if (localBlurView != null)
      {
        localObject5 = localBlurView.L((ViewGroup)localObject5).gMt().F((Drawable)localObject6);
        localObject6 = this.uiContext;
        if (localObject6 == null) {
          p.btv("uiContext");
        }
        ((BlurView)localObject5).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f((Context)localObject6)).cw(20.0F).gMs().cv(i * 1.0F);
      }
      ((LinearLayout)localObject4).addView((View)this.FAr, (ViewGroup.LayoutParams)localObject3);
      localObject4 = this.FAr;
      if (localObject4 != null) {
        ((BlurView)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      ((LinearLayout)localObject1).findViewById(2131298781).setOnClickListener(???);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131305450);
      p.g(localObject2, "parent.findViewById<View>(R.id.no_data)");
      this.FAo = ((View)localObject2);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131298750);
      p.g(localObject2, "parent.findViewById<TextView>(R.id.clear_txt)");
      this.FAp = ((TextView)localObject2);
      this.FAp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119982);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = this.FAv;
          boolean bool;
          if (!d.a(this.FAv))
          {
            bool = true;
            d.a(paramAnonymousView, bool);
            if (!d.a(this.FAv)) {
              break label96;
            }
            d.b(this.FAv);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119982);
            return;
            bool = false;
            break;
            label96:
            d.c(this.FAv);
          }
        }
      });
      localObject1 = ((LinearLayout)localObject1).findViewById(2131308616);
      p.g(localObject1, "parent.findViewById(R.id.story_entrance_recycler)");
      this.FAa = ((RecyclerView)localObject1);
      this.FAa.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.FAk = new d.c(this);
      this.FAa.setItemViewCacheSize(0);
      this.FAa.setAdapter((RecyclerView.a)this.FAk);
      this.FAk.uAj = ((kotlin.g.a.m)new q(???) {});
      ??? = com.tencent.mm.plugin.story.f.f.a.FpB.fnj();
      localObject1 = com.tencent.mm.plugin.story.f.f.a.FpB.fnk();
      this.FAt = com.tencent.mm.plugin.story.f.f.a.FpB.fnl();
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPr, 1) == 1)
      {
        if (((Collection)???).isEmpty()) {
          break label980;
        }
        i = 1;
        label696:
        if (i == 0) {
          break label985;
        }
        ??? = com.tencent.mm.plugin.story.g.f.FrJ;
        ??? = f.a.ct((String)???.get(0), false);
        if (??? != null) {
          com.tencent.mm.plugin.story.ui.view.gallery.m.FHB.C(kotlin.a.j.listOf(???.FoT), 5);
        }
      }
      label737:
      Log.i("MicroMsg.StoryEntranceView", "userNames " + ???.size() + " lastUserNames " + ((List)localObject1).size());
      if (((Map)this.FAt).isEmpty()) {
        break label1050;
      }
    }
    label1048:
    label1050:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.FAd.add(new d.b("", 4));
        this.FAn = (this.FAt.size() + 1);
      }
      ??? = this.FAt.entrySet();
      p.g(???, "replyToIndexMap.entries");
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1055;
        }
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = this.FAd;
        localObject4 = ((Map.Entry)localObject4).getKey();
        p.g(localObject4, "it.key");
        ((List)localObject3).add(new d.b((String)localObject4, 5));
      }
      p.g(localObject2, "contentLayout");
      ((View)localObject2).setBackground(???.getResources().getDrawable(2131231202));
      ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      break;
      label980:
      i = 0;
      break label696;
      label985:
      if (!((Collection)localObject1).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1048;
        }
        ??? = com.tencent.mm.plugin.story.g.f.FrJ;
        ??? = f.a.ct((String)((List)localObject1).get(0), false);
        if (??? == null) {
          break;
        }
        com.tencent.mm.plugin.story.ui.view.gallery.m.FHB.C(kotlin.a.j.listOf(???.FoT), 5);
        break;
      }
      break label737;
    }
    label1055:
    localObject2 = x.SXb;
    if (!???.isEmpty())
    {
      this.FAl = this.FAd.size();
      this.FAd.add(new d.b("", 3));
    }
    ??? = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqE().lI(???.size());
    ??? = "";
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.FAd.add(new d.b((String)localObject3, 1));
          localObject4 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject4).aSN().Kn((String)localObject3);
          p.g(localObject4, "contact");
          if (((as)localObject4).arA())
          {
            localObject4 = com.tencent.mm.plugin.story.h.h.FuH;
            localObject4 = com.tencent.mm.plugin.story.h.h.fqE();
            ((jj)localObject4).lJ(((jj)localObject4).ahs() + 1);
          }
          ??? = ??? + '|' + (String)localObject3;
          continue;
        }
        localObject2 = x.SXb;
        if (((CharSequence)???).length() > 0)
        {
          i = 1;
          ??? = ???;
          if (i == 0) {
            break label1362;
          }
          if (??? != null) {
            break;
          }
          ??? = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(119998);
          throw ???;
        }
      }
      i = 0;
    }
    ??? = ???.substring(1);
    p.g(???, "(this as java.lang.String).substring(startIndex)");
    label1362:
    ??? = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqE().wO(???);
    ??? = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqE().lK(((List)localObject1).size());
    this.FAm = this.FAd.size();
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        this.FAd.add(new d.b("", 2));
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
            this.FAd.add(new d.b((String)localObject2, 1));
            localObject3 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).aSN().Kn((String)localObject2);
            p.g(localObject3, "contact");
            if (((as)localObject3).arA())
            {
              localObject3 = com.tencent.mm.plugin.story.h.h.FuH;
              localObject3 = com.tencent.mm.plugin.story.h.h.fqE();
              ((jj)localObject3).lL(((jj)localObject3).aht() + 1);
            }
            ??? = ??? + '|' + (String)localObject2;
            continue;
          }
          localObject1 = x.SXb;
          if (((CharSequence)???).length() > 0)
          {
            i = 1;
            ??? = ???;
            if (i == 0) {
              break label1686;
            }
            if (??? != null) {
              break;
            }
            ??? = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(119998);
            throw ???;
          }
        }
        i = 0;
      }
      ??? = ???.substring(1);
      p.g(???, "(this as java.lang.String).substring(startIndex)");
      label1686:
      ??? = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqE().wP(???);
      ??? = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqE().sd(this.FAt.size());
      ??? = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.fqF();
      ??? = this.FAk;
      ??? = this.FAd;
      p.g(???, "userNameList");
      p.h(???, "extInfoList");
      ???.hKT.clear();
      ???.hKT.addAll((Collection)???);
      ???.notifyDataSetChanged();
      ??? = this.FAs;
      ??? = com.tencent.mm.plugin.story.h.h.FuH;
      ???.rZ(com.tencent.mm.plugin.story.h.h.fqD());
      ??? = new we();
      ???.ecn.eco = true;
      EventCenter.instance.publish((IEvent)???);
      AppMethodBeat.o(119998);
      return;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119997);
    Object localObject1 = this.FAs;
    if (this.FAq) {}
    for (long l = 1L;; l = 0L)
    {
      ((ji)localObject1).sc(l);
      this.FAs.bfK();
      if (!this.FAq) {
        break label200;
      }
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      com.tencent.mm.plugin.story.f.j.Kj(cl.aWz() + 10L);
      localObject1 = ((Map)this.FAt).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ((Map.Entry)localObject2).getKey();
        localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Number)((Iterator)localObject2).next()).longValue();
          localObject3 = com.tencent.mm.plugin.story.f.b.b.Fom;
          com.tencent.mm.plugin.story.f.b.b.Kk(l);
        }
      }
    }
    localObject1 = g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((e)localObject1).azQ();
    Object localObject2 = ar.a.OiN;
    Object localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
    ((ao)localObject1).set((ar.a)localObject2, Long.valueOf(j.b.fop()));
    label200:
    localObject1 = new we();
    ((we)localObject1).ecn.eco = false;
    EventCenter.instance.publish((IEvent)localObject1);
    Log.i("MicroMsg.StoryEntranceView", "finish");
    if (this.FAd.size() > 0)
    {
      localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      ((e)localObject1).azQ().set(ar.a.OiM, Long.valueOf(cl.aWz()));
    }
    localObject1 = this.FAr;
    if (localObject1 != null)
    {
      localObject1 = ((BlurView)localObject1).getBlurController();
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
    }
    localObject1 = com.tencent.mm.plugin.story.f.f.a.FpB;
    com.tencent.mm.plugin.story.f.f.a.fpf();
    AppMethodBeat.o(119997);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$Companion;", "", "()V", "AGO_TYPE_TIP", "", "NEW_TYPE_TIP", "REPLY_TYPE_TIP", "TAG", "", "TYPE_REPLY_USERNAME", "TYPE_USERNAME", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d
 * JD-Core Version:    0.7.0.1
 */