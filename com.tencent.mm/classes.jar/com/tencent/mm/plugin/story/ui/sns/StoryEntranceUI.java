package com.tencent.mm.plugin.story.ui.sns;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TYPE_TIP", "", "getTYPE_TIP", "()I", "TYPE_USERNAME", "getTYPE_USERNAME", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "entranceRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "readNameList", "", "", "kotlin.jvm.PlatformType", "", "storyTypeIndex", "userNameList", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "finish", "", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class StoryEntranceUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  public static final a LUj;
  private static final String TAG = "MicroMsg.StoryEntranceUI";
  private List<b> CvF;
  private final int LUd;
  private final int LUe;
  private RecyclerView LUf;
  private c LUg;
  private int LUh;
  private List<String> LUi;
  
  static
  {
    AppMethodBeat.i(119981);
    LUj = new a((byte)0);
    TAG = "MicroMsg.StoryEntranceUI";
    AppMethodBeat.o(119981);
  }
  
  public StoryEntranceUI()
  {
    AppMethodBeat.i(119980);
    this.LUd = 1;
    this.LUe = 2;
    this.LUh = -1;
    this.CvF = Collections.synchronizedList((List)new LinkedList());
    this.LUi = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(119980);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119978);
    Log.i(TAG, "finish " + this.LUi.size());
    if (this.CvF.size() > 0)
    {
      Object localObject1 = ((b)this.CvF.get(0)).userName;
      Object localObject2 = j.LGA;
      localObject2 = j.b.gcx().bcW((String)localObject1);
      if (localObject2 != null)
      {
        long l2 = ((com.tencent.mm.plugin.story.i.f)localObject2).field_updateTime;
        long l1 = l2;
        if (l2 == 0L) {
          l1 = ((com.tencent.mm.plugin.story.i.f)localObject2).field_storyPostTime * 1000L;
        }
        Log.i(TAG, "finish updateTime user:" + (String)localObject1 + " updateTime: " + l1);
        if (l1 > 0L)
        {
          localObject1 = h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.Vxc, Long.valueOf(l1));
        }
      }
    }
    super.finish();
    AppMethodBeat.o(119978);
  }
  
  public final int getLayoutId()
  {
    return a.e.LCU;
  }
  
  public final void onCreate(Bundle arg1)
  {
    AppMethodBeat.i(119976);
    Log.i(TAG, "StoryEntranceUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    getWindow().addFlags(1024);
    super.onCreate(???);
    ??? = j.LGA;
    j.b.gcx().add((MStorage.IOnStorageChange)this);
    setMMTitle(a.g.sns_story_header_title_newer);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this), a.f.actionbar_icon_close_black);
    ??? = findViewById(a.d.LBu);
    p.j(???, "findViewById(R.id.story_entrance_recycler)");
    this.LUf = ((RecyclerView)???);
    ??? = this.LUf;
    if (??? == null) {
      p.bGy("entranceRecycler");
    }
    ???.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.LUg = new c();
    ??? = this.LUf;
    if (??? == null) {
      p.bGy("entranceRecycler");
    }
    ???.setItemViewCacheSize(0);
    ??? = this.LUf;
    if (??? == null) {
      p.bGy("entranceRecycler");
    }
    ??? = this.LUg;
    if (??? == null) {
      p.bGy("entranceAdapter");
    }
    ???.setAdapter((RecyclerView.a)???);
    ??? = this.LUg;
    if (??? == null) {
      p.bGy("entranceAdapter");
    }
    ???.yWH = ((m)new e(this));
    ??? = com.tencent.mm.plugin.story.f.f.a.LJD.gbC();
    ??? = com.tencent.mm.plugin.story.f.f.a.LJD.gbD();
    Log.i(TAG, "userNames " + ((List)???).size() + " lastUserNames " + ???.size());
    synchronized ((Iterable)???)
    {
      localObject4 = ((Iterable)???).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        this.CvF.add(new b(str, 1));
      }
    }
    Object localObject4 = x.aazN;
    this.LUh = this.CvF.size();
    if (???.size() > 0) {
      this.CvF.add(new b("", 2));
    }
    synchronized ((Iterable)???)
    {
      ??? = ???.iterator();
      if (((Iterator)???).hasNext())
      {
        localObject4 = (String)((Iterator)???).next();
        this.CvF.add(new b((String)localObject4, 1));
      }
    }
    Object localObject3 = x.aazN;
    ??? = this.LUg;
    if (??? == null) {
      p.bGy("entranceAdapter");
    }
    localObject3 = this.CvF;
    p.j(localObject3, "userNameList");
    p.k(localObject3, "extinfoList");
    ???.kyn.clear();
    ???.kyn.addAll((Collection)localObject3);
    ???.notifyDataSetChanged();
    AppMethodBeat.o(119976);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119977);
    super.onDestroy();
    j.b localb = j.LGA;
    j.b.gcx().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(119977);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119979);
    if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.story.i.f))) {
      switch (paramString.hashCode())
      {
      }
    }
    do
    {
      Log.i(TAG, "unknown event ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(119979);
      return;
    } while (!paramString.equals("notify_story_read"));
    paramString = paramMStorageEventData.obj;
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
      AppMethodBeat.o(119979);
      throw paramString;
    }
    paramString = ((com.tencent.mm.plugin.story.i.f)paramString).getUserName();
    this.LUi.add(paramString);
    paramString = this.LUg;
    if (paramString == null) {
      p.bGy("entranceAdapter");
    }
    paramString.notifyDataSetChanged();
    AppMethodBeat.o(119979);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class b
  {
    final int type;
    final String userName;
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(119961);
      this.userName = paramString;
      this.type = paramInt;
      AppMethodBeat.o(119961);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extinfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
  public final class c
    extends RecyclerView.a<a>
  {
    final ArrayList<StoryEntranceUI.b> kyn;
    m<? super Integer, ? super StoryEntranceUI.b, x> yWH;
    
    public c()
    {
      AppMethodBeat.i(119973);
      this.kyn = new ArrayList();
      AppMethodBeat.o(119973);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119969);
      int i = this.kyn.size();
      AppMethodBeat.o(119969);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(119971);
      paramInt = ((StoryEntranceUI.b)this.kyn.get(paramInt)).type;
      AppMethodBeat.o(119971);
      return paramInt;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
    public abstract class a
      extends RecyclerView.v
    {
      public a()
      {
        super();
      }
      
      public abstract void a(StoryEntranceUI.b paramb);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
    public final class b
      extends StoryEntranceUI.c.a
    {
      private final TextView kMh;
      
      public b()
      {
        super(localObject);
        AppMethodBeat.i(119965);
        this$1 = localObject.findViewById(a.d.tip_tv);
        p.j(StoryEntranceUI.c.this, "itemView.findViewById(R.id.tip_tv)");
        this.kMh = ((TextView)StoryEntranceUI.c.this);
        localObject.setOnClickListener((View.OnClickListener)StoryEntranceUI.c.b.1.LUm);
        AppMethodBeat.o(119965);
      }
      
      public final void a(StoryEntranceUI.b paramb)
      {
        AppMethodBeat.i(119964);
        p.k(paramb, "data");
        this.kMh.setText(a.g.sns_story_header_title_older);
        AppMethodBeat.o(119964);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
    public final class c
      extends StoryEntranceUI.c.a
    {
      private final TextView kMh;
      private final ImageView mWb;
      
      public c()
      {
        super(localObject);
        AppMethodBeat.i(119968);
        this$1 = localObject.findViewById(a.d.avatar_iv);
        p.j(StoryEntranceUI.c.this, "itemView.findViewById(R.id.avatar_iv)");
        this.mWb = ((ImageView)StoryEntranceUI.c.this);
        this$1 = localObject.findViewById(a.d.user_name_tv);
        p.j(StoryEntranceUI.c.this, "itemView.findViewById(R.id.user_name_tv)");
        this.kMh = ((TextView)StoryEntranceUI.c.this);
        localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(119966);
            Object localObject = new b();
            ((b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
            int i = this.LUn.md();
            paramAnonymousView = StoryEntranceUI.c.a(this.LUn.LUl).get(i);
            p.j(paramAnonymousView, "userList[position]");
            paramAnonymousView = (StoryEntranceUI.b)paramAnonymousView;
            localObject = this.LUn.LUl.yWH;
            if (localObject != null) {
              ((m)localObject).invoke(Integer.valueOf(i), paramAnonymousView);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119966);
          }
        });
        AppMethodBeat.o(119968);
      }
      
      public final void a(StoryEntranceUI.b paramb)
      {
        AppMethodBeat.i(119967);
        p.k(paramb, "data");
        a.b.c(this.mWb, paramb.userName);
        Object localObject = h.ae(n.class);
        p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((n)localObject).bbL().RG(paramb.userName);
        if (localObject != null)
        {
          String str = ((as)localObject).ays();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = paramb.userName;
        }
        localObject = com.tencent.mm.pluginsdk.ui.span.l.b(this.kMh.getContext(), (CharSequence)localObject, this.kMh.getTextSize());
        if (StoryEntranceUI.a(StoryEntranceUI.c.this.LUk).contains(paramb.userName)) {
          this.kMh.setTextColor(StoryEntranceUI.c.this.LUk.getContext().getResources().getColor(a.a.BW_0_Alpha_0_3));
        }
        for (;;)
        {
          this.kMh.setText((CharSequence)localObject);
          AppMethodBeat.o(119967);
          return;
          this.kMh.setTextColor(StoryEntranceUI.c.this.LUk.getContext().getResources().getColor(a.a.normal_text_color));
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(StoryEntranceUI paramStoryEntranceUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119974);
      this.LUk.finish();
      AppMethodBeat.o(119974);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "invoke"})
  static final class e
    extends q
    implements m<Integer, StoryEntranceUI.b, x>
  {
    e(StoryEntranceUI paramStoryEntranceUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI
 * JD-Core Version:    0.7.0.1
 */