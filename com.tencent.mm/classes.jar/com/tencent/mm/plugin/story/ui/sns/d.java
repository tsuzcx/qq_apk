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
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.b.a.df;
import com.tencent.mm.g.b.a.dg;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.g.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "blurLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "uiContext", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "buildRender", "", "finish", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class d
  extends LinearLayout
  implements a
{
  public static final a ytq;
  private Context uiContext;
  private RecyclerView ysV;
  private List<d.b> ysY;
  private d.c ytg;
  private int yth;
  private int yti;
  private int ytj;
  private View ytk;
  private TextView ytl;
  private boolean ytm;
  private BlurView ytn;
  private df yto;
  private LinkedHashMap<String, ArrayList<Long>> ytp;
  
  static
  {
    AppMethodBeat.i(119999);
    ytq = new a((byte)0);
    AppMethodBeat.o(119999);
  }
  
  public d(Context arg1, View.OnClickListener arg2)
  {
    super(???);
    AppMethodBeat.i(119998);
    this.yth = -1;
    this.yti = -1;
    this.ytj = -1;
    this.ysY = Collections.synchronizedList((List)new LinkedList());
    this.yto = new df();
    this.ytp = new LinkedHashMap();
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
    if (((a.a)com.tencent.mm.plugin.story.c.a.a.ydB.ajp()).vho)
    {
      this.ytn = new BlurView(???);
      Object localObject5 = this.ytn;
      if (localObject5 != null) {
        ((BlurView)localObject5).Yj(Color.parseColor("#B31D1D1D"));
      }
      localObject5 = this.uiContext;
      if (localObject5 == null) {
        d.g.b.k.aPZ("uiContext");
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
      i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 20);
      BlurView localBlurView = this.ytn;
      if (localBlurView != null)
      {
        localObject5 = localBlurView.w((ViewGroup)localObject5).eUh().G((Drawable)localObject6);
        localObject6 = this.uiContext;
        if (localObject6 == null) {
          d.g.b.k.aPZ("uiContext");
        }
        ((BlurView)localObject5).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f((Context)localObject6)).bJ(20.0F).eUg().bI(i * 1.0F);
      }
      ((LinearLayout)localObject4).addView((View)this.ytn, (ViewGroup.LayoutParams)localObject3);
      localObject4 = this.ytn;
      if (localObject4 != null) {
        ((BlurView)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      ((LinearLayout)localObject1).findViewById(2131298372).setOnClickListener(???);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131302877);
      d.g.b.k.g(localObject2, "parent.findViewById<View>(R.id.no_data)");
      this.ytk = ((View)localObject2);
      localObject2 = ((LinearLayout)localObject1).findViewById(2131298351);
      d.g.b.k.g(localObject2, "parent.findViewById<TextView>(R.id.clear_txt)");
      this.ytl = ((TextView)localObject2);
      this.ytl.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119982);
          paramAnonymousView = this.ytr;
          if (!d.a(this.ytr)) {}
          for (boolean bool = true;; bool = false)
          {
            d.a(paramAnonymousView, bool);
            if (!d.a(this.ytr)) {
              break;
            }
            d.b(this.ytr);
            AppMethodBeat.o(119982);
            return;
          }
          d.c(this.ytr);
          AppMethodBeat.o(119982);
        }
      });
      localObject1 = ((LinearLayout)localObject1).findViewById(2131305410);
      d.g.b.k.g(localObject1, "parent.findViewById(R.id.story_entrance_recycler)");
      this.ysV = ((RecyclerView)localObject1);
      this.ysV.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
      this.ytg = new d.c(this);
      this.ysV.setItemViewCacheSize(0);
      this.ysV.setAdapter((RecyclerView.a)this.ytg);
      this.ytg.ypN = ((d.g.a.m)new d.g.b.l(???) {});
      ??? = com.tencent.mm.plugin.story.f.f.a.yio.dGk();
      localObject1 = com.tencent.mm.plugin.story.f.f.a.yio.dGl();
      this.ytp = com.tencent.mm.plugin.story.f.f.a.yio.dGm();
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjy, 1) == 1)
      {
        if (((Collection)???).isEmpty()) {
          break label982;
        }
        i = 1;
        label696:
        if (i == 0) {
          break label987;
        }
        ??? = com.tencent.mm.plugin.story.g.f.ykw;
        ??? = f.a.bJ((String)???.get(0), false);
        if (??? != null)
        {
          localObject2 = com.tencent.mm.plugin.story.ui.view.gallery.m.yAD;
          com.tencent.mm.plugin.story.ui.view.gallery.m.u(d.a.j.listOf(???.yhF), 5);
        }
      }
      label739:
      ad.i("MicroMsg.StoryEntranceView", "userNames " + ???.size() + " lastUserNames " + ((List)localObject1).size());
      if (((Map)this.ytp).isEmpty()) {
        break label1054;
      }
    }
    label1052:
    label1054:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ysY.add(new d.b("", 4));
        this.ytj = (this.ytp.size() + 1);
      }
      ??? = this.ytp.entrySet();
      d.g.b.k.g(???, "replyToIndexMap.entries");
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1059;
        }
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = this.ysY;
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
        ??? = com.tencent.mm.plugin.story.g.f.ykw;
        ??? = f.a.bJ((String)((List)localObject1).get(0), false);
        if (??? == null) {
          break;
        }
        localObject2 = com.tencent.mm.plugin.story.ui.view.gallery.m.yAD;
        com.tencent.mm.plugin.story.ui.view.gallery.m.u(d.a.j.listOf(???.yhF), 5);
        break;
      }
      break label739;
    }
    label1059:
    localObject2 = y.JfV;
    if (!???.isEmpty())
    {
      this.yth = this.ysY.size();
      this.ysY.add(new d.b("", 3));
    }
    ??? = com.tencent.mm.plugin.story.h.h.ynv;
    com.tencent.mm.plugin.story.h.h.dJF().iz(???.size());
    ??? = "";
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.ysY.add(new d.b((String)localObject3, 1));
          localObject4 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject4).apM().aHY((String)localObject3);
          d.g.b.k.g(localObject4, "contact");
          if (((af)localObject4).ZO())
          {
            localObject4 = com.tencent.mm.plugin.story.h.h.ynv;
            localObject4 = com.tencent.mm.plugin.story.h.h.dJF();
            ((dg)localObject4).iA(((dg)localObject4).QO() + 1);
          }
          ??? = ??? + '|' + (String)localObject3;
          continue;
        }
        localObject2 = y.JfV;
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
    ??? = com.tencent.mm.plugin.story.h.h.ynv;
    com.tencent.mm.plugin.story.h.h.dJF().jH(???);
    ??? = com.tencent.mm.plugin.story.h.h.ynv;
    com.tencent.mm.plugin.story.h.h.dJF().iB(((List)localObject1).size());
    this.yti = this.ysY.size();
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        this.ysY.add(new d.b("", 2));
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
            this.ysY.add(new d.b((String)localObject2, 1));
            localObject3 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
            d.g.b.k.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject3).apM().aHY((String)localObject2);
            d.g.b.k.g(localObject3, "contact");
            if (((af)localObject3).ZO())
            {
              localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
              localObject3 = com.tencent.mm.plugin.story.h.h.dJF();
              ((dg)localObject3).iC(((dg)localObject3).QP() + 1);
            }
            ??? = ??? + '|' + (String)localObject2;
            continue;
          }
          localObject1 = y.JfV;
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
      ??? = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJF().jI(???);
      ??? = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJF().fR(this.ytp.size());
      ??? = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJG();
      ??? = this.ytg;
      ??? = this.ysY;
      d.g.b.k.g(???, "userNameList");
      d.g.b.k.h(???, "extInfoList");
      ???.ytb.clear();
      ???.ytb.addAll((Collection)???);
      ???.notifyDataSetChanged();
      ??? = this.yto;
      ??? = com.tencent.mm.plugin.story.h.h.ynv;
      ???.fN(com.tencent.mm.plugin.story.h.h.dJE());
      ??? = new ty();
      ???.dzn.dzo = true;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)???);
      AppMethodBeat.o(119998);
      return;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119997);
    Object localObject1 = this.yto;
    if (this.ytm) {}
    for (long l = 1L;; l = 0L)
    {
      ((df)localObject1).fQ(l);
      this.yto.aBj();
      if (!this.ytm) {
        break label200;
      }
      localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      com.tencent.mm.plugin.story.f.j.tF(ce.asR() + 10L);
      localObject1 = ((Map)this.ytp).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ((Map.Entry)localObject2).getKey();
        localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Number)((Iterator)localObject2).next()).longValue();
          localObject3 = com.tencent.mm.plugin.story.f.b.b.ygY;
          com.tencent.mm.plugin.story.f.b.b.tG(l);
        }
      }
    }
    localObject1 = g.afB();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    localObject1 = ((e)localObject1).afk();
    Object localObject2 = ae.a.Fvi;
    Object localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
    ((ab)localObject1).set((ae.a)localObject2, Long.valueOf(j.b.dHq()));
    label200:
    localObject1 = new ty();
    ((ty)localObject1).dzn.dzo = false;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    ad.i("MicroMsg.StoryEntranceView", "finish");
    if (this.ysY.size() > 0)
    {
      localObject1 = g.afB();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      ((e)localObject1).afk().set(ae.a.Fvh, Long.valueOf(ce.asR()));
    }
    localObject1 = this.ytn;
    if (localObject1 != null)
    {
      localObject1 = ((BlurView)localObject1).getBlurController();
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
    }
    localObject1 = com.tencent.mm.plugin.story.f.f.a.yio;
    com.tencent.mm.plugin.story.f.f.a.dIg();
    AppMethodBeat.o(119997);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$Companion;", "", "()V", "AGO_TYPE_TIP", "", "NEW_TYPE_TIP", "REPLY_TYPE_TIP", "TAG", "", "TYPE_REPLY_USERNAME", "TYPE_USERNAME", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d
 * JD-Core Version:    0.7.0.1
 */