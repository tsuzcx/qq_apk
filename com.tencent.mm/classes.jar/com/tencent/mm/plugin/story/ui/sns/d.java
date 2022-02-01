package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zc;
import com.tencent.mm.autogen.mmdata.rpt.or;
import com.tencent.mm.autogen.mmdata.rpt.os;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.f.f.a;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.ui.view.gallery.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "blurLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "uiContext", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "buildRender", "", "finish", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends LinearLayout
  implements a
{
  public static final d.a Swq;
  private List<d.b> Imq;
  private LinkedHashMap<String, ArrayList<Long>> SwA;
  private RecyclerView Swk;
  private d.c Swr;
  private int Sws;
  private int Swt;
  private int Swu;
  private View Swv;
  private TextView Sww;
  private boolean Swx;
  private BlurView Swy;
  private or Swz;
  private Context uiContext;
  
  static
  {
    AppMethodBeat.i(119999);
    Swq = new d.a((byte)0);
    AppMethodBeat.o(119999);
  }
  
  public d(Context arg1, View.OnClickListener arg2)
  {
    super(???);
    AppMethodBeat.i(119998);
    this.Sws = -1;
    this.Swt = -1;
    this.Swu = -1;
    this.Imq = Collections.synchronizedList((List)new LinkedList());
    this.Swz = new or();
    this.SwA = new LinkedHashMap();
    this.uiContext = ???;
    Object localObject1 = LayoutInflater.from(???).inflate(a.e.SgF, (ViewGroup)this, true);
    if (localObject1 == null)
    {
      ??? = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(119998);
      throw ???;
    }
    Object localObject3 = (LinearLayout)localObject1;
    LinearLayout localLinearLayout = (LinearLayout)((LinearLayout)localObject3).findViewById(a.d.SdE);
    Object localObject4 = LayoutInflater.from(???).inflate(a.e.SgD, null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    if (((a.a)com.tencent.mm.plugin.story.c.a.a.SiJ.boF()).NHD)
    {
      this.Swy = new BlurView(???);
      localObject1 = this.Swy;
      if (localObject1 != null) {
        ((BlurView)localObject1).aBy(Color.parseColor("#B31D1D1D"));
      }
      localObject2 = this.uiContext;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("uiContext");
        localObject1 = null;
      }
      localObject2 = (MMActivity)localObject1;
      localObject1 = (ViewGroup)((MMActivity)localObject2).getWindow().getDecorView();
      localObject2 = ((MMActivity)localObject2).getWindow().getDecorView().getBackground();
      i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 20);
      BlurView localBlurView = this.Swy;
      if (localBlurView != null)
      {
        localBlurView = localBlurView.ad((ViewGroup)localObject1).job().V((Drawable)localObject2);
        localObject2 = this.uiContext;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("uiContext");
          localObject1 = null;
        }
        localBlurView.b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f((Context)localObject1)).eb(20.0F).joa().Rx = (i * 1.0F);
      }
      localLinearLayout.addView((View)this.Swy, localLayoutParams);
      localObject1 = this.Swy;
      if (localObject1 != null) {
        ((BlurView)localObject1).addView((View)localObject4, localLayoutParams);
      }
      ((LinearLayout)localObject3).findViewById(a.d.close_img).setOnClickListener(???);
      localObject1 = ((LinearLayout)localObject3).findViewById(a.d.SdC);
      s.s(localObject1, "parent.findViewById<View>(R.id.no_data)");
      this.Swv = ((View)localObject1);
      localObject1 = ((LinearLayout)localObject3).findViewById(a.d.Sds);
      s.s(localObject1, "parent.findViewById<TextView>(R.id.clear_txt)");
      this.Sww = ((TextView)localObject1);
      this.Sww.setOnClickListener(new d..ExternalSyntheticLambda0(this));
      localObject1 = ((LinearLayout)localObject3).findViewById(a.d.Sff);
      s.s(localObject1, "parent.findViewById(R.id.story_entrance_recycler)");
      this.Swk = ((RecyclerView)localObject1);
      this.Swk.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.Swr = new d.c(this);
      this.Swk.setItemViewCacheSize(0);
      this.Swk.setAdapter((RecyclerView.a)this.Swr);
      this.Swr.CyZ = ((m)new d.1(this, ???, ???));
      ??? = com.tencent.mm.plugin.story.model.sync.a.SmO.huV();
      localObject1 = com.tencent.mm.plugin.story.model.sync.a.SmO.huW();
      this.SwA = com.tencent.mm.plugin.story.model.sync.a.SmO.huX();
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIF, 1) == 1)
      {
        if (((Collection)???).isEmpty()) {
          break label904;
        }
        i = 1;
        label628:
        if (i == 0) {
          break label909;
        }
        ??? = com.tencent.mm.plugin.story.f.f.SoU;
        ??? = f.a.dn((String)???.get(0), false);
        if (??? != null) {
          j.SCD.V(p.listOf(???.Smr), 5);
        }
      }
      label669:
      Log.i("MicroMsg.StoryEntranceView", "userNames " + ???.size() + " lastUserNames " + ((List)localObject1).size());
      if (((Map)this.SwA).isEmpty()) {
        break label974;
      }
    }
    label904:
    label909:
    label972:
    label974:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.Imq.add(new d.b("", 4));
        this.Swu = (this.SwA.size() + 1);
      }
      ??? = this.SwA.entrySet();
      s.s(???, "replyToIndexMap.entries");
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label979;
        }
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = this.Imq;
        localObject4 = ((Map.Entry)localObject4).getKey();
        s.s(localObject4, "it.key");
        ((List)localObject3).add(new d.b((String)localObject4, 5));
      }
      ((View)localObject4).setBackground(???.getResources().getDrawable(a.c.ScW));
      localLinearLayout.addView((View)localObject4, localLayoutParams);
      break;
      i = 0;
      break label628;
      if (!((Collection)localObject1).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label972;
        }
        ??? = com.tencent.mm.plugin.story.f.f.SoU;
        ??? = f.a.dn((String)((List)localObject1).get(0), false);
        if (??? == null) {
          break;
        }
        j.SCD.V(p.listOf(???.Smr), 5);
        break;
      }
      break label669;
    }
    label979:
    Object localObject2 = ah.aiuX;
    if (!???.isEmpty())
    {
      this.Sws = this.Imq.size();
      this.Imq.add(new d.b("", 3));
    }
    ??? = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hys().jka = ???.size();
    ??? = "";
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.Imq.add(new d.b((String)localObject3, 1));
          if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject3).aSK())
          {
            localObject4 = com.tencent.mm.plugin.story.g.h.SqZ;
            localObject4 = com.tencent.mm.plugin.story.g.h.hys();
            ((os)localObject4).jkb += 1;
          }
          ??? = ??? + '|' + (String)localObject3;
          continue;
        }
        localObject2 = ah.aiuX;
        if (((CharSequence)???).length() > 0)
        {
          i = 1;
          ??? = ???;
          if (i == 0) {
            break label1260;
          }
          if (??? != null) {
            break;
          }
          ??? = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(119998);
          throw ???;
        }
      }
      i = 0;
    }
    ??? = ???.substring(1);
    s.s(???, "(this as java.lang.String).substring(startIndex)");
    label1260:
    ??? = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hys().wx(???);
    ??? = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hys().jkd = ((List)localObject1).size();
    this.Swt = this.Imq.size();
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        this.Imq.add(new d.b("", 2));
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
            this.Imq.add(new d.b((String)localObject2, 1));
            if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject2).aSK())
            {
              localObject3 = com.tencent.mm.plugin.story.g.h.SqZ;
              localObject3 = com.tencent.mm.plugin.story.g.h.hys();
              ((os)localObject3).jke += 1;
            }
            ??? = ??? + '|' + (String)localObject2;
            continue;
          }
          localObject1 = ah.aiuX;
          if (((CharSequence)???).length() > 0)
          {
            i = 1;
            ??? = ???;
            if (i == 0) {
              break label1558;
            }
            if (??? != null) {
              break;
            }
            ??? = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(119998);
            throw ???;
          }
        }
        i = 0;
      }
      ??? = ???.substring(1);
      s.s(???, "(this as java.lang.String).substring(startIndex)");
      label1558:
      ??? = com.tencent.mm.plugin.story.g.h.SqZ;
      ??? = com.tencent.mm.plugin.story.g.h.hys();
      ???.jkf = ???.F("ExposeBeforeUinList", ???, true);
      ??? = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hys().jkg = this.SwA.size();
      ??? = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hyt();
      ??? = this.Swr;
      ??? = this.Imq;
      s.s(???, "userNameList");
      s.u(???, "extInfoList");
      ???.nbM.clear();
      ???.nbM.addAll((Collection)???);
      ???.bZE.notifyChanged();
      ??? = this.Swz;
      ??? = com.tencent.mm.plugin.story.g.h.SqZ;
      ???.jjV = com.tencent.mm.plugin.story.g.h.hyr();
      ??? = new zc();
      ???.ico.icp = true;
      ???.publish();
      AppMethodBeat.o(119998);
      return;
    }
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(367421);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    boolean bool;
    if (!paramd.Swx)
    {
      bool = true;
      paramd.Swx = bool;
      if (!paramd.Swx) {
        break label174;
      }
      paramd.Swv.setVisibility(0);
      paramd.Swk.setVisibility(4);
      paramd.Sww.setText((CharSequence)paramd.getResources().getString(a.g.ShD));
      paramd.Swx = true;
      paramd = paramd.Swz;
      paramd.jdp += 1L;
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367421);
      return;
      bool = false;
      break;
      label174:
      paramd.Swv.setVisibility(4);
      paramd.Swk.setVisibility(0);
      paramd.Sww.setText((CharSequence)paramd.getResources().getString(a.g.ShC));
      paramd.Swx = false;
      paramd = paramd.Swz;
      paramd.jjW += 1L;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119997);
    Object localObject1 = this.Swz;
    if (this.Swx) {}
    for (long l = 1L;; l = 0L)
    {
      ((or)localObject1).jjX = l;
      this.Swz.bMH();
      if (!this.Swx) {
        break label190;
      }
      localObject1 = StoryCore.SjP;
      StoryCore.vM(cn.bDv() + 10L);
      localObject1 = ((Map)this.SwA).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ((Map.Entry)localObject2).getKey();
        localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Number)((Iterator)localObject2).next()).longValue();
          localObject3 = com.tencent.mm.plugin.story.model.b.b.SlF;
          com.tencent.mm.plugin.story.model.b.b.vN(l);
        }
      }
    }
    localObject1 = com.tencent.mm.kernel.h.baE().ban();
    Object localObject2 = at.a.acYO;
    Object localObject3 = StoryCore.SjP;
    ((aq)localObject1).set((at.a)localObject2, Long.valueOf(StoryCore.b.hwe()));
    label190:
    localObject1 = new zc();
    ((zc)localObject1).ico.icp = false;
    ((zc)localObject1).publish();
    Log.i("MicroMsg.StoryEntranceView", "finish");
    if (this.Imq.size() > 0) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYN, Long.valueOf(cn.bDv()));
    }
    localObject1 = this.Swy;
    if (localObject1 != null)
    {
      localObject1 = ((BlurView)localObject1).getBlurController();
      if (localObject1 != null) {
        ((com.tencent.mm.ui.blur.c)localObject1).destroy();
      }
    }
    localObject1 = com.tencent.mm.plugin.story.model.sync.a.SmO;
    com.tencent.mm.plugin.story.model.sync.a.hwU();
    AppMethodBeat.o(119997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d
 * JD-Core Version:    0.7.0.1
 */