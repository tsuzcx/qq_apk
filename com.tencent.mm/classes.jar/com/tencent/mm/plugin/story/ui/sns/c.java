package com.tencent.mm.plugin.story.ui.sns;

import a.f.a.m;
import a.l;
import a.v;
import a.y;
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
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.b.a.av;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.f.g.a;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.ui.view.gallery.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.blur.BlurView;
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

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "blurLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "uiContext", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "buildRender", "", "finish", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class c
  extends LinearLayout
  implements a
{
  public static final c.a sKN;
  private c.c sKD;
  private int sKE;
  private int sKF;
  private int sKG;
  private View sKH;
  private TextView sKI;
  private boolean sKJ;
  private BlurView sKK;
  private av sKL;
  private LinkedHashMap<String, ArrayList<Long>> sKM;
  private RecyclerView sKs;
  private List<c.b> sKv;
  private Context uiContext;
  
  static
  {
    AppMethodBeat.i(110282);
    sKN = new c.a((byte)0);
    AppMethodBeat.o(110282);
  }
  
  public c(Context arg1, View.OnClickListener arg2)
  {
    super(???);
    AppMethodBeat.i(110281);
    this.sKE = -1;
    this.sKF = -1;
    this.sKG = -1;
    this.sKv = Collections.synchronizedList((List)new LinkedList());
    this.sKL = new av();
    this.sKM = new LinkedHashMap();
    this.uiContext = ???;
    Object localObject1 = LayoutInflater.from(???).inflate(2130970952, (ViewGroup)this, true);
    if (localObject1 == null)
    {
      ??? = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(110281);
      throw ???;
    }
    localObject1 = (LinearLayout)localObject1;
    Object localObject4 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131828406);
    Object localObject2 = LayoutInflater.from(???).inflate(2130970950, null);
    Object localObject3 = new ViewGroup.LayoutParams(-1, -1);
    if (((com.tencent.mm.plugin.story.c.a.a.a)com.tencent.mm.plugin.story.c.a.a.srz.Uw()).srI)
    {
      this.sKK = new BlurView(???);
      Object localObject5 = this.sKK;
      if (localObject5 != null) {
        ((BlurView)localObject5).Pd(Color.parseColor("#B31D1D1D"));
      }
      localObject5 = this.uiContext;
      if (localObject5 == null) {
        a.f.b.j.ays("uiContext");
      }
      if (localObject5 == null)
      {
        ??? = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(110281);
        throw ???;
      }
      Object localObject6 = (MMActivity)localObject5;
      localObject5 = ((MMActivity)localObject6).getWindow();
      a.f.b.j.p(localObject5, "activity.window");
      localObject5 = ((Window)localObject5).getDecorView();
      if (localObject5 == null)
      {
        ??? = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(110281);
        throw ???;
      }
      localObject5 = (ViewGroup)localObject5;
      localObject6 = ((MMActivity)localObject6).getWindow();
      a.f.b.j.p(localObject6, "activity.window");
      localObject6 = ((Window)localObject6).getDecorView();
      a.f.b.j.p(localObject6, "activity.window.decorView");
      localObject6 = ((View)localObject6).getBackground();
      i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 20);
      BlurView localBlurView = this.sKK;
      if (localBlurView != null)
      {
        localObject5 = localBlurView.t((ViewGroup)localObject5).dFo().x((Drawable)localObject6);
        localObject6 = this.uiContext;
        if (localObject6 == null) {
          a.f.b.j.ays("uiContext");
        }
        ((BlurView)localObject5).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.e((Context)localObject6)).bx(20.0F).dFn().bw(i * 1.0F);
      }
      ((LinearLayout)localObject4).addView((View)this.sKK, (ViewGroup.LayoutParams)localObject3);
      localObject4 = this.sKK;
      if (localObject4 != null) {
        ((BlurView)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      ((LinearLayout)localObject1).findViewById(2131828402).setOnClickListener(???);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131828404);
      a.f.b.j.p(localObject2, "parent.findViewById<View>(R.id.no_data)");
      this.sKH = ((View)localObject2);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131828403);
      a.f.b.j.p(localObject2, "parent.findViewById<TextView>(R.id.clear_txt)");
      this.sKI = ((TextView)localObject2);
      this.sKI.setOnClickListener((View.OnClickListener)new c.1(this));
      localObject1 = ((LinearLayout)localObject1).findViewById(2131828405);
      a.f.b.j.p(localObject1, "parent.findViewById(R.id.story_entrance_recycler)");
      this.sKs = ((RecyclerView)localObject1);
      this.sKs.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
      this.sKD = new c.c(this);
      this.sKs.setItemViewCacheSize(0);
      this.sKs.setAdapter((RecyclerView.a)this.sKD);
      this.sKD.sHB = ((m)new c.2(this, ???, ???));
      ??? = com.tencent.mm.plugin.story.model.f.a.szc.czu();
      localObject1 = com.tencent.mm.plugin.story.model.f.a.szc.czv();
      this.sKM = com.tencent.mm.plugin.story.model.f.a.szc.czw();
      if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lSe, 1) == 1)
      {
        if (((Collection)???).isEmpty()) {
          break label982;
        }
        i = 1;
        label696:
        if (i == 0) {
          break label987;
        }
        ??? = com.tencent.mm.plugin.story.f.g.sBI;
        ??? = g.a.bz((String)???.get(0), false);
        if (??? != null)
        {
          localObject2 = p.sUH;
          p.p(a.a.j.listOf(???.syr), 5);
        }
      }
      label739:
      ab.i("MicroMsg.StoryEntranceView", "userNames " + ???.size() + " lastUserNames " + ((List)localObject1).size());
      if (((Map)this.sKM).isEmpty()) {
        break label1054;
      }
    }
    label1052:
    label1054:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.sKv.add(new c.b("", 4));
        this.sKG = (this.sKM.size() + 1);
      }
      ??? = this.sKM.entrySet();
      a.f.b.j.p(???, "replyToIndexMap.entries");
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1059;
        }
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = this.sKv;
        localObject4 = ((Map.Entry)localObject4).getKey();
        a.f.b.j.p(localObject4, "it.key");
        ((List)localObject3).add(new c.b((String)localObject4, 5));
      }
      a.f.b.j.p(localObject2, "contentLayout");
      ((View)localObject2).setBackground(???.getResources().getDrawable(2130837881));
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
        ??? = com.tencent.mm.plugin.story.f.g.sBI;
        ??? = g.a.bz((String)((List)localObject1).get(0), false);
        if (??? == null) {
          break;
        }
        localObject2 = p.sUH;
        p.p(a.a.j.listOf(???.syr), 5);
        break;
      }
      break label739;
    }
    label1059:
    localObject2 = y.BMg;
    if (!???.isEmpty())
    {
      this.sKE = this.sKv.size();
      this.sKv.add(new c.b("", 3));
    }
    ??? = i.sFa;
    i.cDM().gF(???.size());
    ??? = "";
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.sKv.add(new c.b((String)localObject3, 1));
          localObject4 = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
          a.f.b.j.p(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject4).YA().arw((String)localObject3);
          a.f.b.j.p(localObject4, "contact");
          if (((ad)localObject4).NY())
          {
            localObject4 = i.sFa;
            localObject4 = i.cDM();
            ((aw)localObject4).gG(((aw)localObject4).FA() + 1);
          }
          ??? = ??? + '|' + (String)localObject3;
          continue;
        }
        localObject2 = y.BMg;
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
          AppMethodBeat.o(110281);
          throw ???;
        }
      }
      i = 0;
    }
    ??? = ???.substring(1);
    a.f.b.j.p(???, "(this as java.lang.String).substring(startIndex)");
    label1366:
    ??? = i.sFa;
    i.cDM().gk(???);
    ??? = i.sFa;
    i.cDM().gH(((List)localObject1).size());
    this.sKF = this.sKv.size();
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        this.sKv.add(new c.b("", 2));
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
            this.sKv.add(new c.b((String)localObject2, 1));
            localObject3 = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.p(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject3).YA().arw((String)localObject2);
            a.f.b.j.p(localObject3, "contact");
            if (((ad)localObject3).NY())
            {
              localObject3 = i.sFa;
              localObject3 = i.cDM();
              ((aw)localObject3).gI(((aw)localObject3).FB() + 1);
            }
            ??? = ??? + '|' + (String)localObject2;
            continue;
          }
          localObject1 = y.BMg;
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
            AppMethodBeat.o(110281);
            throw ???;
          }
        }
        i = 0;
      }
      ??? = ???.substring(1);
      a.f.b.j.p(???, "(this as java.lang.String).substring(startIndex)");
      label1690:
      ??? = i.sFa;
      i.cDM().gl(???);
      ??? = i.sFa;
      i.cDM().co(this.sKM.size());
      ??? = i.sFa;
      i.cDN();
      ??? = this.sKD;
      ??? = this.sKv;
      a.f.b.j.p(???, "userNameList");
      a.f.b.j.q(???, "extInfoList");
      ???.sKy.clear();
      ???.sKy.addAll((Collection)???);
      ???.notifyDataSetChanged();
      ??? = this.sKL;
      ??? = i.sFa;
      ???.ck(i.cDL());
      ??? = new se();
      ???.cIx.cIy = true;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(110281);
      return;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(110280);
    Object localObject1 = this.sKL;
    if (this.sKJ) {}
    for (long l = 1L;; l = 0L)
    {
      ((av)localObject1).cn(l);
      this.sKL.ake();
      if (!this.sKJ) {
        break label200;
      }
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      com.tencent.mm.plugin.story.model.j.mv(cb.abq() + 10L);
      localObject1 = ((Map)this.sKM).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ((Map.Entry)localObject2).getKey();
        localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Number)((Iterator)localObject2).next()).longValue();
          localObject3 = com.tencent.mm.plugin.story.model.b.b.sxN;
          com.tencent.mm.plugin.story.model.b.b.my(l);
        }
      }
    }
    localObject1 = com.tencent.mm.kernel.g.RL();
    a.f.b.j.p(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.e)localObject1).Ru();
    Object localObject2 = ac.a.yLM;
    Object localObject3 = com.tencent.mm.plugin.story.model.j.svi;
    ((z)localObject1).set((ac.a)localObject2, Long.valueOf(j.b.cAP()));
    label200:
    localObject1 = new se();
    ((se)localObject1).cIx.cIy = false;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    ab.i("MicroMsg.StoryEntranceView", "finish");
    if (this.sKv.size() > 0)
    {
      localObject1 = com.tencent.mm.kernel.g.RL();
      a.f.b.j.p(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).Ru().set(ac.a.yLL, Long.valueOf(cb.abq()));
    }
    localObject1 = this.sKK;
    if (localObject1 != null)
    {
      localObject1 = ((BlurView)localObject1).getBlurController();
      if (localObject1 != null) {
        ((com.tencent.mm.ui.blur.c)localObject1).destroy();
      }
    }
    localObject1 = com.tencent.mm.plugin.story.model.f.a.szc;
    com.tencent.mm.plugin.story.model.f.a.cBR();
    AppMethodBeat.o(110280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c
 * JD-Core Version:    0.7.0.1
 */