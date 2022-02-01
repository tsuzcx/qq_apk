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
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.b.a.fs;
import com.tencent.mm.g.b.a.ft;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.g.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "blurLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "uiContext", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "buildRender", "", "finish", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class d
  extends LinearLayout
  implements a
{
  public static final d.a AYk;
  private RecyclerView AXQ;
  private List<d.b> AXT;
  private d.c AYa;
  private int AYb;
  private int AYc;
  private int AYd;
  private View AYe;
  private TextView AYf;
  private boolean AYg;
  private BlurView AYh;
  private fs AYi;
  private LinkedHashMap<String, ArrayList<Long>> AYj;
  private Context uiContext;
  
  static
  {
    AppMethodBeat.i(119999);
    AYk = new d.a((byte)0);
    AppMethodBeat.o(119999);
  }
  
  public d(Context arg1, View.OnClickListener arg2)
  {
    super(???);
    AppMethodBeat.i(119998);
    this.AYb = -1;
    this.AYc = -1;
    this.AYd = -1;
    this.AXT = Collections.synchronizedList((List)new LinkedList());
    this.AYi = new fs();
    this.AYj = new LinkedHashMap();
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
    if (((a.a)com.tencent.mm.plugin.story.c.a.a.AIv.ate()).xxQ)
    {
      this.AYh = new BlurView(???);
      Object localObject5 = this.AYh;
      if (localObject5 != null) {
        ((BlurView)localObject5).acE(Color.parseColor("#B31D1D1D"));
      }
      localObject5 = this.uiContext;
      if (localObject5 == null) {
        p.bcb("uiContext");
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
      i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 20);
      BlurView localBlurView = this.AYh;
      if (localBlurView != null)
      {
        localObject5 = localBlurView.B((ViewGroup)localObject5).fAj().F((Drawable)localObject6);
        localObject6 = this.uiContext;
        if (localObject6 == null) {
          p.bcb("uiContext");
        }
        ((BlurView)localObject5).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f((Context)localObject6)).bW(20.0F).fAi().bV(i * 1.0F);
      }
      ((LinearLayout)localObject4).addView((View)this.AYh, (ViewGroup.LayoutParams)localObject3);
      localObject4 = this.AYh;
      if (localObject4 != null) {
        ((BlurView)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      ((LinearLayout)localObject1).findViewById(2131298372).setOnClickListener(???);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131302877);
      p.g(localObject2, "parent.findViewById<View>(R.id.no_data)");
      this.AYe = ((View)localObject2);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131298351);
      p.g(localObject2, "parent.findViewById<TextView>(R.id.clear_txt)");
      this.AYf = ((TextView)localObject2);
      this.AYf.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119982);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = this.AYl;
          boolean bool;
          if (!d.a(this.AYl))
          {
            bool = true;
            d.a(paramAnonymousView, bool);
            if (!d.a(this.AYl)) {
              break label96;
            }
            d.b(this.AYl);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119982);
            return;
            bool = false;
            break;
            label96:
            d.c(this.AYl);
          }
        }
      });
      localObject1 = ((LinearLayout)localObject1).findViewById(2131305410);
      p.g(localObject1, "parent.findViewById(R.id.story_entrance_recycler)");
      this.AXQ = ((RecyclerView)localObject1);
      this.AXQ.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
      this.AYa = new d.c(this);
      this.AXQ.setItemViewCacheSize(0);
      this.AXQ.setAdapter((RecyclerView.a)this.AYa);
      this.AYa.sAA = ((d.g.a.m)new q(???) {});
      ??? = com.tencent.mm.plugin.story.f.f.a.ANj.eha();
      localObject1 = com.tencent.mm.plugin.story.f.f.a.ANj.ehb();
      this.AYj = com.tencent.mm.plugin.story.f.f.a.ANj.ehc();
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqM, 1) == 1)
      {
        if (((Collection)???).isEmpty()) {
          break label982;
        }
        i = 1;
        label696:
        if (i == 0) {
          break label987;
        }
        ??? = com.tencent.mm.plugin.story.g.f.APr;
        ??? = f.a.bX((String)???.get(0), false);
        if (??? != null)
        {
          localObject2 = com.tencent.mm.plugin.story.ui.view.gallery.m.Bfs;
          com.tencent.mm.plugin.story.ui.view.gallery.m.w(d.a.j.listOf(???.AMA), 5);
        }
      }
      label739:
      ad.i("MicroMsg.StoryEntranceView", "userNames " + ???.size() + " lastUserNames " + ((List)localObject1).size());
      if (((Map)this.AYj).isEmpty()) {
        break label1054;
      }
    }
    label1052:
    label1054:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.AXT.add(new d.b("", 4));
        this.AYd = (this.AYj.size() + 1);
      }
      ??? = this.AYj.entrySet();
      p.g(???, "replyToIndexMap.entries");
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1059;
        }
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = this.AXT;
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
        ??? = com.tencent.mm.plugin.story.g.f.APr;
        ??? = f.a.bX((String)((List)localObject1).get(0), false);
        if (??? == null) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.story.ui.view.gallery.m.Bfs;
        com.tencent.mm.plugin.story.ui.view.gallery.m.w(d.a.j.listOf(???.AMA), 5);
        break;
      }
      break label739;
    }
    label1059:
    localObject2 = z.MKo;
    if (!???.isEmpty())
    {
      this.AYb = this.AXT.size();
      this.AXT.add(new d.b("", 3));
    }
    ??? = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ekv().iG(???.size());
    ??? = "";
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.AXT.add(new d.b((String)localObject3, 1));
          localObject4 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject4).azp().Bf((String)localObject3);
          p.g(localObject4, "contact");
          if (((am)localObject4).adm())
          {
            localObject4 = com.tencent.mm.plugin.story.h.h.ASt;
            localObject4 = com.tencent.mm.plugin.story.h.h.ekv();
            ((ft)localObject4).iH(((ft)localObject4).Tx() + 1);
          }
          ??? = ??? + '|' + (String)localObject3;
          continue;
        }
        localObject2 = z.MKo;
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
    ??? = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ekv().oK(???);
    ??? = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ekv().iI(((List)localObject1).size());
    this.AYc = this.AXT.size();
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        this.AXT.add(new d.b("", 2));
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
            this.AXT.add(new d.b((String)localObject2, 1));
            localObject3 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).azp().Bf((String)localObject2);
            p.g(localObject3, "contact");
            if (((am)localObject3).adm())
            {
              localObject3 = com.tencent.mm.plugin.story.h.h.ASt;
              localObject3 = com.tencent.mm.plugin.story.h.h.ekv();
              ((ft)localObject3).iJ(((ft)localObject3).Ty() + 1);
            }
            ??? = ??? + '|' + (String)localObject2;
            continue;
          }
          localObject1 = z.MKo;
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
      ??? = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.ekv().oL(???);
      ??? = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.ekv().kQ(this.AYj.size());
      ??? = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.ekw();
      ??? = this.AYa;
      ??? = this.AXT;
      p.g(???, "userNameList");
      p.h(???, "extInfoList");
      ???.gQO.clear();
      ???.gQO.addAll((Collection)???);
      ???.notifyDataSetChanged();
      ??? = this.AYi;
      ??? = com.tencent.mm.plugin.story.h.h.ASt;
      ???.kM(com.tencent.mm.plugin.story.h.h.eku());
      ??? = new vb();
      ???.dJl.dJm = true;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(119998);
      return;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119997);
    Object localObject1 = this.AYi;
    if (this.AYg) {}
    for (long l = 1L;; l = 0L)
    {
      ((fs)localObject1).kP(l);
      this.AYi.aLk();
      if (!this.AYg) {
        break label200;
      }
      localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      com.tencent.mm.plugin.story.f.j.AG(cf.aCL() + 10L);
      localObject1 = ((Map)this.AYj).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ((Map.Entry)localObject2).getKey();
        localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Number)((Iterator)localObject2).next()).longValue();
          localObject3 = com.tencent.mm.plugin.story.f.b.b.ALT;
          com.tencent.mm.plugin.story.f.b.b.AH(l);
        }
      }
    }
    localObject1 = g.ajC();
    p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((e)localObject1).ajl();
    Object localObject2 = al.a.IFH;
    Object localObject3 = com.tencent.mm.plugin.story.f.j.AKb;
    ((ai)localObject1).set((al.a)localObject2, Long.valueOf(j.b.eig()));
    label200:
    localObject1 = new vb();
    ((vb)localObject1).dJl.dJm = false;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    ad.i("MicroMsg.StoryEntranceView", "finish");
    if (this.AXT.size() > 0)
    {
      localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      ((e)localObject1).ajl().set(al.a.IFG, Long.valueOf(cf.aCL()));
    }
    localObject1 = this.AYh;
    if (localObject1 != null)
    {
      localObject1 = ((BlurView)localObject1).getBlurController();
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
    }
    localObject1 = com.tencent.mm.plugin.story.f.f.a.ANj;
    com.tencent.mm.plugin.story.f.f.a.eiW();
    AppMethodBeat.o(119997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d
 * JD-Core Version:    0.7.0.1
 */