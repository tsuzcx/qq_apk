package com.tencent.mm.plugin.story.ui.sns;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
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
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TYPE_TIP", "", "getTYPE_TIP", "()I", "TYPE_USERNAME", "getTYPE_USERNAME", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "entranceRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "readNameList", "", "", "kotlin.jvm.PlatformType", "", "storyTypeIndex", "userNameList", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "finish", "", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryEntranceUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  public static final StoryEntranceUI.a Swh;
  private static final String TAG;
  private List<b> Imq;
  private final int Swi;
  private final int Swj;
  private RecyclerView Swk;
  private c Swl;
  private int Swm;
  private List<String> Swn;
  
  static
  {
    AppMethodBeat.i(119981);
    Swh = new StoryEntranceUI.a((byte)0);
    TAG = "MicroMsg.StoryEntranceUI";
    AppMethodBeat.o(119981);
  }
  
  public StoryEntranceUI()
  {
    AppMethodBeat.i(119980);
    this.Swi = 1;
    this.Swj = 2;
    this.Swm = -1;
    this.Imq = Collections.synchronizedList((List)new LinkedList());
    this.Swn = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(119980);
  }
  
  private static final boolean a(StoryEntranceUI paramStoryEntranceUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(367378);
    s.u(paramStoryEntranceUI, "this$0");
    paramStoryEntranceUI.finish();
    AppMethodBeat.o(367378);
    return true;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119978);
    Log.i(TAG, s.X("finish ", Integer.valueOf(this.Swn.size())));
    if (this.Imq.size() > 0)
    {
      String str = ((b)this.Imq.get(0)).userName;
      Object localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvS().bbJ(str);
      if (localObject != null)
      {
        long l2 = ((com.tencent.mm.plugin.story.h.f)localObject).field_updateTime;
        long l1 = l2;
        if (l2 == 0L) {
          l1 = ((com.tencent.mm.plugin.story.h.f)localObject).field_storyPostTime * 1000L;
        }
        Log.i(TAG, "finish updateTime user:" + str + " updateTime: " + l1);
        if (l1 > 0L) {
          h.baE().ban().set(at.a.acYN, Long.valueOf(l1));
        }
      }
    }
    super.finish();
    AppMethodBeat.o(119978);
  }
  
  public final int getLayoutId()
  {
    return a.e.SgF;
  }
  
  public final void onCreate(Bundle arg1)
  {
    Object localObject4 = null;
    AppMethodBeat.i(119976);
    Log.i(TAG, s.X("StoryEntranceUI create ", this));
    supportRequestWindowFeature(1);
    getWindow().addFlags(1024);
    super.onCreate(???);
    ??? = StoryCore.SjP;
    StoryCore.b.hvS().add((MStorage.IOnStorageChange)this);
    setMMTitle(a.g.sns_story_header_title_newer);
    setBackBtn(new StoryEntranceUI..ExternalSyntheticLambda0(this), a.f.actionbar_icon_close_black);
    ??? = findViewById(a.d.Sff);
    s.s(???, "findViewById(R.id.story_entrance_recycler)");
    this.Swk = ((RecyclerView)???);
    ??? = this.Swk;
    if (??? == null)
    {
      s.bIx("entranceRecycler");
      ??? = null;
      ???.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.Swl = new c();
      ??? = this.Swk;
      ??? = (Bundle)???;
      if (??? == null)
      {
        s.bIx("entranceRecycler");
        ??? = null;
      }
      ???.setItemViewCacheSize(0);
      ??? = this.Swk;
      if (??? != null) {
        break label378;
      }
      s.bIx("entranceRecycler");
      ??? = null;
      label185:
      localObject5 = this.Swl;
      ??? = localObject5;
      if (localObject5 == null)
      {
        s.bIx("entranceAdapter");
        ??? = null;
      }
      ???.setAdapter((RecyclerView.a)???);
      ??? = this.Swl;
      if (??? != null) {
        break label381;
      }
      s.bIx("entranceAdapter");
      ??? = null;
    }
    label378:
    label381:
    for (;;)
    {
      ???.CyZ = ((m)new d(this));
      ??? = com.tencent.mm.plugin.story.model.sync.a.SmO.huV();
      ??? = com.tencent.mm.plugin.story.model.sync.a.SmO.huW();
      Log.i(TAG, "userNames " + ((List)???).size() + " lastUserNames " + ???.size());
      synchronized ((Iterable)???)
      {
        localObject5 = ((Iterable)???).iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label384;
        }
        String str = (String)((Iterator)localObject5).next();
        this.Imq.add(new b(str, 1));
      }
      break;
      break label185;
    }
    label384:
    Object localObject5 = ah.aiuX;
    this.Swm = this.Imq.size();
    if (???.size() > 0) {
      this.Imq.add(new b("", 2));
    }
    synchronized ((Iterable)???)
    {
      ??? = ???.iterator();
      if (((Iterator)???).hasNext())
      {
        localObject5 = (String)((Iterator)???).next();
        this.Imq.add(new b((String)localObject5, 1));
      }
    }
    Object localObject3 = ah.aiuX;
    ??? = this.Swl;
    if (??? == null)
    {
      s.bIx("entranceAdapter");
      ??? = localObject4;
    }
    for (;;)
    {
      localObject3 = this.Imq;
      s.s(localObject3, "userNameList");
      s.u(localObject3, "extinfoList");
      ???.nbM.clear();
      ???.nbM.addAll((Collection)localObject3);
      ???.bZE.notifyChanged();
      AppMethodBeat.o(119976);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119977);
    super.onDestroy();
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hvS().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(119977);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119979);
    if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.story.h.f)))
    {
      if (s.p(paramString, "notify_story_read"))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
          AppMethodBeat.o(119979);
          throw paramString;
        }
        paramString = ((com.tencent.mm.plugin.story.h.f)paramString).getUserName();
        this.Swn.add(paramString);
        paramMStorageEventData = this.Swl;
        paramString = paramMStorageEventData;
        if (paramMStorageEventData == null)
        {
          s.bIx("entranceAdapter");
          paramString = null;
        }
        paramString.bZE.notifyChanged();
        AppMethodBeat.o(119979);
        return;
      }
      Log.i(TAG, s.X("unknown event ", paramString));
    }
    AppMethodBeat.o(119979);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extinfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.a<a>
  {
    m<? super Integer, ? super StoryEntranceUI.b, ah> CyZ;
    final ArrayList<StoryEntranceUI.b> nbM;
    
    public c()
    {
      AppMethodBeat.i(119973);
      this.nbM = new ArrayList();
      AppMethodBeat.o(119973);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119969);
      int i = this.nbM.size();
      AppMethodBeat.o(119969);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(119971);
      paramInt = ((StoryEntranceUI.b)this.nbM.get(paramInt)).type;
      AppMethodBeat.o(119971);
      return paramInt;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
    public abstract class a
      extends RecyclerView.v
    {
      public a()
      {
        super();
      }
      
      public abstract void a(StoryEntranceUI.b paramb);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class b
      extends StoryEntranceUI.c.a
    {
      private final TextView noc;
      
      public b()
      {
        super(localObject);
        AppMethodBeat.i(119965);
        this$1 = localObject.findViewById(a.d.tip_tv);
        s.s(StoryEntranceUI.c.this, "itemView.findViewById(R.id.tip_tv)");
        this.noc = ((TextView)StoryEntranceUI.c.this);
        localObject.setOnClickListener(StoryEntranceUI.c.b..ExternalSyntheticLambda0.INSTANCE);
        AppMethodBeat.o(119965);
      }
      
      private static final void dg(View paramView)
      {
        AppMethodBeat.i(367401);
        Object localObject = new Object();
        b localb = new b();
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(367401);
      }
      
      public final void a(StoryEntranceUI.b paramb)
      {
        AppMethodBeat.i(119964);
        s.u(paramb, "data");
        this.noc.setText(a.g.sns_story_header_title_older);
        AppMethodBeat.o(119964);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class c
      extends StoryEntranceUI.c.a
    {
      private final ImageView avatar;
      private final TextView noc;
      
      public c()
      {
        super(localObject);
        AppMethodBeat.i(119968);
        this$1 = localObject.findViewById(a.d.avatar_iv);
        s.s(StoryEntranceUI.c.this, "itemView.findViewById(R.id.avatar_iv)");
        this.avatar = ((ImageView)StoryEntranceUI.c.this);
        this$1 = localObject.findViewById(a.d.user_name_tv);
        s.s(StoryEntranceUI.c.this, "itemView.findViewById(R.id.user_name_tv)");
        this.noc = ((TextView)StoryEntranceUI.c.this);
        localObject.setOnClickListener(new StoryEntranceUI.c.c..ExternalSyntheticLambda0(this, StoryEntranceUI.c.this));
        AppMethodBeat.o(119968);
      }
      
      private static final void a(c paramc, StoryEntranceUI.c paramc1, View paramView)
      {
        AppMethodBeat.i(367410);
        Object localObject = new Object();
        b localb = new b();
        localb.cH(paramc);
        localb.cH(paramc1);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramc, "this$0");
        s.u(paramc1, "this$1");
        int i = paramc.KJ();
        paramc = StoryEntranceUI.c.a(paramc1).get(i);
        s.s(paramc, "userList[position]");
        paramc = (StoryEntranceUI.b)paramc;
        paramc1 = paramc1.CyZ;
        if (paramc1 != null) {
          paramc1.invoke(Integer.valueOf(i), paramc);
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(367410);
      }
      
      public final void a(StoryEntranceUI.b paramb)
      {
        AppMethodBeat.i(119967);
        s.u(paramb, "data");
        a.b.g(this.avatar, paramb.userName);
        Object localObject1 = ((n)h.ax(n.class)).bzA().JE(paramb.userName);
        if (localObject1 == null)
        {
          localObject1 = null;
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = paramb.userName;
          }
          localObject1 = p.b(this.noc.getContext(), (CharSequence)localObject2, this.noc.getTextSize());
          if (!StoryEntranceUI.c(StoryEntranceUI.c.this.Swo).contains(paramb.userName)) {
            break label157;
          }
          this.noc.setTextColor(StoryEntranceUI.c.this.Swo.getContext().getResources().getColor(a.a.BW_0_Alpha_0_3));
        }
        for (;;)
        {
          this.noc.setText((CharSequence)localObject1);
          AppMethodBeat.o(119967);
          return;
          localObject1 = ((au)localObject1).aSV();
          break;
          label157:
          this.noc.setTextColor(StoryEntranceUI.c.this.Swo.getContext().getResources().getColor(a.a.normal_text_color));
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Integer, StoryEntranceUI.b, ah>
  {
    d(StoryEntranceUI paramStoryEntranceUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI
 * JD-Core Version:    0.7.0.1
 */