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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xj;
import com.tencent.mm.f.b.a.lr;
import com.tencent.mm.f.b.a.ls;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.g.f.a;
import com.tencent.mm.pluginsdk.ui.a.b;
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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "blurLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "uiContext", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "buildRender", "", "finish", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class d
  extends LinearLayout
  implements a
{
  public static final a LUy;
  private List<b> CvF;
  private RecyclerView LUf;
  private c LUo;
  private int LUp;
  private int LUq;
  private int LUr;
  private View LUs;
  private TextView LUt;
  private boolean LUu;
  private BlurView LUv;
  private lr LUw;
  private LinkedHashMap<String, ArrayList<Long>> LUx;
  private Context uiContext;
  
  static
  {
    AppMethodBeat.i(119999);
    LUy = new a((byte)0);
    AppMethodBeat.o(119999);
  }
  
  public d(Context arg1, View.OnClickListener arg2)
  {
    super(???);
    AppMethodBeat.i(119998);
    this.LUp = -1;
    this.LUq = -1;
    this.LUr = -1;
    this.CvF = Collections.synchronizedList((List)new LinkedList());
    this.LUw = new lr();
    this.LUx = new LinkedHashMap();
    this.uiContext = ???;
    Object localObject1 = LayoutInflater.from(???).inflate(a.e.LCU, (ViewGroup)this, true);
    if (localObject1 == null)
    {
      ??? = new t("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(119998);
      throw ???;
    }
    localObject1 = (LinearLayout)localObject1;
    Object localObject4 = (LinearLayout)((LinearLayout)localObject1).findViewById(a.d.LzR);
    Object localObject2 = LayoutInflater.from(???).inflate(a.e.LCS, null);
    Object localObject3 = new ViewGroup.LayoutParams(-1, -1);
    if (((a.a)com.tencent.mm.plugin.story.c.a.a.LEY.aUb()).HKB)
    {
      this.LUv = new BlurView(???);
      Object localObject5 = this.LUv;
      if (localObject5 != null) {
        ((BlurView)localObject5).auW(Color.parseColor("#B31D1D1D"));
      }
      localObject5 = this.uiContext;
      if (localObject5 == null) {
        p.bGy("uiContext");
      }
      if (localObject5 == null)
      {
        ??? = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(119998);
        throw ???;
      }
      Object localObject6 = (MMActivity)localObject5;
      localObject5 = ((MMActivity)localObject6).getWindow();
      p.j(localObject5, "activity.window");
      localObject5 = ((Window)localObject5).getDecorView();
      if (localObject5 == null)
      {
        ??? = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(119998);
        throw ???;
      }
      localObject5 = (ViewGroup)localObject5;
      localObject6 = ((MMActivity)localObject6).getWindow();
      p.j(localObject6, "activity.window");
      localObject6 = ((Window)localObject6).getDecorView();
      p.j(localObject6, "activity.window.decorView");
      localObject6 = ((View)localObject6).getBackground();
      i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 20);
      BlurView localBlurView = this.LUv;
      if (localBlurView != null)
      {
        localObject5 = localBlurView.T((ViewGroup)localObject5).hLA().L((Drawable)localObject6);
        localObject6 = this.uiContext;
        if (localObject6 == null) {
          p.bGy("uiContext");
        }
        ((BlurView)localObject5).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f((Context)localObject6)).cO(20.0F).hLz().cN(i * 1.0F);
      }
      ((LinearLayout)localObject4).addView((View)this.LUv, (ViewGroup.LayoutParams)localObject3);
      localObject4 = this.LUv;
      if (localObject4 != null) {
        ((BlurView)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      ((LinearLayout)localObject1).findViewById(a.d.close_img).setOnClickListener(???);
      localObject2 = ((LinearLayout)localObject1).findViewById(a.d.LzP);
      p.j(localObject2, "parent.findViewById<View>(R.id.no_data)");
      this.LUs = ((View)localObject2);
      localObject2 = ((LinearLayout)localObject1).findViewById(a.d.LzF);
      p.j(localObject2, "parent.findViewById<TextView>(R.id.clear_txt)");
      this.LUt = ((TextView)localObject2);
      this.LUt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(119982);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = this.LUz;
          boolean bool;
          if (!d.a(this.LUz))
          {
            bool = true;
            d.a(paramAnonymousView, bool);
            if (!d.a(this.LUz)) {
              break label96;
            }
            d.b(this.LUz);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119982);
            return;
            bool = false;
            break;
            label96:
            d.c(this.LUz);
          }
        }
      });
      localObject1 = ((LinearLayout)localObject1).findViewById(a.d.LBu);
      p.j(localObject1, "parent.findViewById(R.id.story_entrance_recycler)");
      this.LUf = ((RecyclerView)localObject1);
      this.LUf.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.LUo = new c();
      this.LUf.setItemViewCacheSize(0);
      this.LUf.setAdapter((RecyclerView.a)this.LUo);
      this.LUo.yWH = ((kotlin.g.a.m)new q(???) {});
      ??? = com.tencent.mm.plugin.story.f.f.a.LJD.gbC();
      localObject1 = com.tencent.mm.plugin.story.f.f.a.LJD.gbD();
      this.LUx = com.tencent.mm.plugin.story.f.f.a.LJD.gbE();
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvC, 1) == 1)
      {
        if (((Collection)???).isEmpty()) {
          break label985;
        }
        i = 1;
        label701:
        if (i == 0) {
          break label990;
        }
        ??? = com.tencent.mm.plugin.story.g.f.LLM;
        ??? = f.a.cH((String)???.get(0), false);
        if (??? != null) {
          com.tencent.mm.plugin.story.ui.view.gallery.m.MbB.D(kotlin.a.j.listOf(???.LIV), 5);
        }
      }
      label742:
      Log.i("MicroMsg.StoryEntranceView", "userNames " + ???.size() + " lastUserNames " + ((List)localObject1).size());
      if (((Map)this.LUx).isEmpty()) {
        break label1055;
      }
    }
    label1053:
    label1055:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.CvF.add(new b("", 4));
        this.LUr = (this.LUx.size() + 1);
      }
      ??? = this.LUx.entrySet();
      p.j(???, "replyToIndexMap.entries");
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1060;
        }
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = this.CvF;
        localObject4 = ((Map.Entry)localObject4).getKey();
        p.j(localObject4, "it.key");
        ((List)localObject3).add(new b((String)localObject4, 5));
      }
      p.j(localObject2, "contentLayout");
      ((View)localObject2).setBackground(???.getResources().getDrawable(a.c.Lzj));
      ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      break;
      label985:
      i = 0;
      break label701;
      label990:
      if (!((Collection)localObject1).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1053;
        }
        ??? = com.tencent.mm.plugin.story.g.f.LLM;
        ??? = f.a.cH((String)((List)localObject1).get(0), false);
        if (??? == null) {
          break;
        }
        com.tencent.mm.plugin.story.ui.view.gallery.m.MbB.D(kotlin.a.j.listOf(???.LIV), 5);
        break;
      }
      break label742;
    }
    label1060:
    localObject2 = x.aazN;
    if (!???.isEmpty())
    {
      this.LUp = this.CvF.size();
      this.CvF.add(new b("", 3));
    }
    ??? = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.gfa().nI(???.size());
    ??? = "";
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject2 = ???.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.CvF.add(new b((String)localObject3, 1));
          localObject4 = com.tencent.mm.kernel.h.ae(n.class);
          p.j(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          localObject4 = ((n)localObject4).bbL().RG((String)localObject3);
          p.j(localObject4, "contact");
          if (((as)localObject4).ayh())
          {
            localObject4 = com.tencent.mm.plugin.story.h.h.LOJ;
            localObject4 = com.tencent.mm.plugin.story.h.h.gfa();
            ((ls)localObject4).nJ(((ls)localObject4).amO() + 1);
          }
          ??? = ??? + '|' + (String)localObject3;
          continue;
        }
        localObject2 = x.aazN;
        if (((CharSequence)???).length() > 0)
        {
          i = 1;
          ??? = ???;
          if (i == 0) {
            break label1367;
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
    p.j(???, "(this as java.lang.String).substring(startIndex)");
    label1367:
    ??? = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.gfa().Cp(???);
    ??? = com.tencent.mm.plugin.story.h.h.LOJ;
    com.tencent.mm.plugin.story.h.h.gfa().nK(((List)localObject1).size());
    this.LUq = this.CvF.size();
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        this.CvF.add(new b("", 2));
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
            this.CvF.add(new b((String)localObject2, 1));
            localObject3 = com.tencent.mm.kernel.h.ae(n.class);
            p.j(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
            localObject3 = ((n)localObject3).bbL().RG((String)localObject2);
            p.j(localObject3, "contact");
            if (((as)localObject3).ayh())
            {
              localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
              localObject3 = com.tencent.mm.plugin.story.h.h.gfa();
              ((ls)localObject3).nL(((ls)localObject3).amP() + 1);
            }
            ??? = ??? + '|' + (String)localObject2;
            continue;
          }
          localObject1 = x.aazN;
          if (((CharSequence)???).length() > 0)
          {
            i = 1;
            ??? = ???;
            if (i == 0) {
              break label1691;
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
      p.j(???, "(this as java.lang.String).substring(startIndex)");
      label1691:
      ??? = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.gfa().Cq(???);
      ??? = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.gfa().wf(this.LUx.size());
      ??? = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.gfb();
      ??? = this.LUo;
      ??? = this.CvF;
      p.j(???, "userNameList");
      p.k(???, "extInfoList");
      ???.kyn.clear();
      ???.kyn.addAll((Collection)???);
      ???.notifyDataSetChanged();
      ??? = this.LUw;
      ??? = com.tencent.mm.plugin.story.h.h.LOJ;
      ???.wb(com.tencent.mm.plugin.story.h.h.geZ());
      ??? = new xj();
      ???.fWp.fWq = true;
      EventCenter.instance.publish((IEvent)???);
      AppMethodBeat.o(119998);
      return;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119997);
    Object localObject1 = this.LUw;
    if (this.LUu) {}
    for (long l = 1L;; l = 0L)
    {
      ((lr)localObject1).we(l);
      this.LUw.bpa();
      if (!this.LUu) {
        break label200;
      }
      localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      com.tencent.mm.plugin.story.f.j.RD(cm.bfD() + 10L);
      localObject1 = ((Map)this.LUx).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ((Map.Entry)localObject2).getKey();
        localObject2 = ((Iterable)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Number)((Iterator)localObject2).next()).longValue();
          localObject3 = com.tencent.mm.plugin.story.f.b.b.LIo;
          com.tencent.mm.plugin.story.f.b.b.RE(l);
        }
      }
    }
    localObject1 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp();
    Object localObject2 = ar.a.Vxd;
    Object localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
    ((ao)localObject1).set((ar.a)localObject2, Long.valueOf(j.b.gcJ()));
    label200:
    localObject1 = new xj();
    ((xj)localObject1).fWp.fWq = false;
    EventCenter.instance.publish((IEvent)localObject1);
    Log.i("MicroMsg.StoryEntranceView", "finish");
    if (this.CvF.size() > 0)
    {
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.Vxc, Long.valueOf(cm.bfD()));
    }
    localObject1 = this.LUv;
    if (localObject1 != null)
    {
      localObject1 = ((BlurView)localObject1).getBlurController();
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
    }
    localObject1 = com.tencent.mm.plugin.story.f.f.a.LJD;
    com.tencent.mm.plugin.story.f.f.a.gdz();
    AppMethodBeat.o(119997);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$Companion;", "", "()V", "AGO_TYPE_TIP", "", "NEW_TYPE_TIP", "REPLY_TYPE_TIP", "TAG", "", "TYPE_REPLY_USERNAME", "TYPE_USERNAME", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class b
  {
    final int type;
    final String userName;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(119984);
      this.userName = paramString;
      this.type = paramInt;
      AppMethodBeat.o(119984);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extInfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
  public final class c
    extends RecyclerView.a<a>
  {
    final ArrayList<d.b> kyn;
    kotlin.g.a.m<? super Integer, ? super d.b, x> yWH;
    
    public c()
    {
      AppMethodBeat.i(119996);
      this.kyn = new ArrayList();
      AppMethodBeat.o(119996);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119992);
      int i = this.kyn.size();
      AppMethodBeat.o(119992);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(119994);
      paramInt = ((d.b)this.kyn.get(paramInt)).type;
      AppMethodBeat.o(119994);
      return paramInt;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
    public abstract class a
      extends RecyclerView.v
    {
      public a()
      {
        super();
      }
      
      public abstract void a(d.b paramb);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "tipId", "", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;I)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "getTipId", "()I", "setTipId", "(I)V", "onBind", "", "position", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
    public final class b
      extends d.c.a
    {
      private int LUC;
      private final TextView kMh;
      
      public b(int paramInt)
      {
        super(paramInt);
        AppMethodBeat.i(119988);
        int i;
        this.LUC = i;
        this$1 = paramInt.findViewById(a.d.tip_tv);
        p.j(d.c.this, "itemView.findViewById(R.id.tip_tv)");
        this.kMh = ((TextView)d.c.this);
        paramInt.setOnClickListener((View.OnClickListener)d.c.b.1.LUD);
        AppMethodBeat.o(119988);
      }
      
      public final void a(d.b paramb)
      {
        AppMethodBeat.i(119987);
        p.k(paramb, "data");
        this.kMh.setText(this.LUC);
        AppMethodBeat.o(119987);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "reply", "getReply", "setReply", "(Landroid/widget/TextView;)V", "star", "getStar", "()Landroid/view/View;", "setStar", "(Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
    public final class c
      extends d.c.a
    {
      private View LUE;
      private TextView LUF;
      private final TextView kMh;
      private final ImageView mWb;
      
      public c()
      {
        super(localObject);
        AppMethodBeat.i(119991);
        this$1 = localObject.findViewById(a.d.avatar_iv);
        p.j(d.c.this, "itemView.findViewById(R.id.avatar_iv)");
        this.mWb = ((ImageView)d.c.this);
        this$1 = localObject.findViewById(a.d.user_name_tv);
        p.j(d.c.this, "itemView.findViewById(R.id.user_name_tv)");
        this.kMh = ((TextView)d.c.this);
        this$1 = localObject.findViewById(a.d.LzZ);
        p.j(d.c.this, "itemView.findViewById(R.id.star)");
        this.LUE = d.c.this;
        this$1 = localObject.findViewById(a.d.LzQ);
        p.j(d.c.this, "itemView.findViewById(R.id.reply_icon)");
        this.LUF = ((TextView)d.c.this);
        localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(119989);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            int i = this.LUG.md();
            paramAnonymousView = d.c.a(this.LUG.LUB).get(i);
            p.j(paramAnonymousView, "userList[position]");
            paramAnonymousView = (d.b)paramAnonymousView;
            localObject = this.LUG.LUB.yWH;
            if (localObject != null) {
              ((kotlin.g.a.m)localObject).invoke(Integer.valueOf(i), paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119989);
          }
        });
        AppMethodBeat.o(119991);
      }
      
      public final void a(d.b paramb)
      {
        int j = 0;
        AppMethodBeat.i(119990);
        p.k(paramb, "data");
        a.b.d(this.mWb, paramb.userName);
        Object localObject1 = com.tencent.mm.kernel.h.ae(n.class);
        p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
        as localas = ((n)localObject1).bbL().RG(paramb.userName);
        if (localas != null)
        {
          localObject2 = localas.ays();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = paramb.userName;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b(this.kMh.getContext(), (CharSequence)localObject1, this.kMh.getTextSize());
        Object localObject2 = this.LUE;
        p.j(localas, "contact");
        if (localas.ayh())
        {
          i = 0;
          ((View)localObject2).setVisibility(i);
          this.kMh.setText((CharSequence)localObject1);
          localObject1 = this.LUF;
          if (paramb.type != 5) {
            break label207;
          }
          this.LUF.setText((CharSequence)String.valueOf(com.tencent.mm.plugin.story.f.f.a.LJD.bdj(paramb.userName)));
        }
        label207:
        for (int i = j;; i = 8)
        {
          ((TextView)localObject1).setVisibility(i);
          AppMethodBeat.o(119990);
          return;
          i = 4;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.d
 * JD-Core Version:    0.7.0.1
 */