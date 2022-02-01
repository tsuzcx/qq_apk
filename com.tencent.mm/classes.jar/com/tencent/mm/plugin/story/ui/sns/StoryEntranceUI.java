package com.tencent.mm.plugin.story.ui.sns;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.story.f.f.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TYPE_TIP", "", "getTYPE_TIP", "()I", "TYPE_USERNAME", "getTYPE_USERNAME", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "readNameList", "", "", "kotlin.jvm.PlatformType", "", "storyTypeIndex", "userNameList", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "finish", "", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class StoryEntranceUI
  extends MMActivity
  implements k.a
{
  private static final String TAG = "MicroMsg.StoryEntranceUI";
  public static final a yta;
  private final int ysT;
  private final int ysU;
  private RecyclerView ysV;
  private c ysW;
  private int ysX;
  private List<b> ysY;
  private List<String> ysZ;
  
  static
  {
    AppMethodBeat.i(119981);
    yta = new a((byte)0);
    TAG = "MicroMsg.StoryEntranceUI";
    AppMethodBeat.o(119981);
  }
  
  public StoryEntranceUI()
  {
    AppMethodBeat.i(119980);
    this.ysT = 1;
    this.ysU = 2;
    this.ysX = -1;
    this.ysY = Collections.synchronizedList((List)new LinkedList());
    this.ysZ = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(119980);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(119979);
    if ((paramString != null) && (paramm != null) && ((paramm.obj instanceof f))) {
      switch (paramString.hashCode())
      {
      }
    }
    do
    {
      ad.i(TAG, "unknown event ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(119979);
      return;
    } while (!paramString.equals("notify_story_read"));
    paramString = paramm.obj;
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
      AppMethodBeat.o(119979);
      throw paramString;
    }
    paramString = ((f)paramString).getUserName();
    this.ysZ.add(paramString);
    paramString = this.ysW;
    if (paramString == null) {
      d.g.b.k.aPZ("entranceAdapter");
    }
    paramString.notifyDataSetChanged();
    AppMethodBeat.o(119979);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119978);
    ad.i(TAG, "finish " + this.ysZ.size());
    if (this.ysY.size() > 0)
    {
      Object localObject1 = ((b)this.ysY.get(0)).userName;
      Object localObject2 = j.yfh;
      localObject2 = j.b.dHe().arp((String)localObject1);
      if (localObject2 != null)
      {
        long l2 = ((f)localObject2).field_updateTime;
        long l1 = l2;
        if (l2 == 0L) {
          l1 = ((f)localObject2).field_storyPostTime * 1000L;
        }
        ad.i(TAG, "finish updateTime user:" + (String)localObject1 + " updateTime: " + l1);
        if (l1 > 0L)
        {
          localObject1 = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).afk().set(ae.a.Fvh, Long.valueOf(l1));
        }
      }
    }
    super.finish();
    AppMethodBeat.o(119978);
  }
  
  public final int getLayoutId()
  {
    return 2131495690;
  }
  
  public final void onCreate(Bundle arg1)
  {
    AppMethodBeat.i(119976);
    ad.i(TAG, "StoryEntranceUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    getWindow().addFlags(1024);
    super.onCreate(???);
    ??? = j.yfh;
    j.b.dHe().add((k.a)this);
    setMMTitle(2131763983);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this), 2131689488);
    ??? = findViewById(2131305410);
    d.g.b.k.g(???, "findViewById(R.id.story_entrance_recycler)");
    this.ysV = ((RecyclerView)???);
    ??? = this.ysV;
    if (??? == null) {
      d.g.b.k.aPZ("entranceRecycler");
    }
    ???.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.ysW = new c();
    ??? = this.ysV;
    if (??? == null) {
      d.g.b.k.aPZ("entranceRecycler");
    }
    ???.setItemViewCacheSize(0);
    ??? = this.ysV;
    if (??? == null) {
      d.g.b.k.aPZ("entranceRecycler");
    }
    ??? = this.ysW;
    if (??? == null) {
      d.g.b.k.aPZ("entranceAdapter");
    }
    ???.setAdapter((RecyclerView.a)???);
    ??? = this.ysW;
    if (??? == null) {
      d.g.b.k.aPZ("entranceAdapter");
    }
    ???.ypN = ((d.g.a.m)new e(this));
    ??? = a.yio.dGk();
    ??? = a.yio.dGl();
    ad.i(TAG, "userNames " + ((List)???).size() + " lastUserNames " + ???.size());
    synchronized ((Iterable)???)
    {
      localObject4 = ((Iterable)???).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        this.ysY.add(new b(str, 1));
      }
    }
    Object localObject4 = y.JfV;
    this.ysX = this.ysY.size();
    if (???.size() > 0) {
      this.ysY.add(new b("", 2));
    }
    synchronized ((Iterable)???)
    {
      ??? = ???.iterator();
      if (((Iterator)???).hasNext())
      {
        localObject4 = (String)((Iterator)???).next();
        this.ysY.add(new b((String)localObject4, 1));
      }
    }
    Object localObject3 = y.JfV;
    ??? = this.ysW;
    if (??? == null) {
      d.g.b.k.aPZ("entranceAdapter");
    }
    localObject3 = this.ysY;
    d.g.b.k.g(localObject3, "userNameList");
    d.g.b.k.h(localObject3, "extinfoList");
    ???.ytb.clear();
    ???.ytb.addAll((Collection)localObject3);
    ???.notifyDataSetChanged();
    AppMethodBeat.o(119976);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119977);
    super.onDestroy();
    j.b localb = j.yfh;
    j.b.dHe().remove((k.a)this);
    AppMethodBeat.o(119977);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extinfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
  public final class c
    extends RecyclerView.a<a>
  {
    d.g.a.m<? super Integer, ? super StoryEntranceUI.b, y> ypN;
    final ArrayList<StoryEntranceUI.b> ytb;
    
    public c()
    {
      AppMethodBeat.i(119973);
      this.ytb = new ArrayList();
      AppMethodBeat.o(119973);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119969);
      int i = this.ytb.size();
      AppMethodBeat.o(119969);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(119971);
      paramInt = ((StoryEntranceUI.b)this.ytb.get(paramInt)).type;
      AppMethodBeat.o(119971);
      return paramInt;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
    public abstract class a
      extends RecyclerView.v
    {
      public a()
      {
        super();
      }
      
      public abstract void a(StoryEntranceUI.b paramb);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
    public final class b
      extends StoryEntranceUI.c.a
    {
      private final TextView izX;
      
      public b()
      {
        super(localObject);
        AppMethodBeat.i(119965);
        this$1 = localObject.findViewById(2131305880);
        d.g.b.k.g(StoryEntranceUI.c.this, "itemView.findViewById(R.id.tip_tv)");
        this.izX = ((TextView)StoryEntranceUI.c.this);
        localObject.setOnClickListener((View.OnClickListener)1.yte);
        AppMethodBeat.o(119965);
      }
      
      public final void a(StoryEntranceUI.b paramb)
      {
        AppMethodBeat.i(119964);
        d.g.b.k.h(paramb, "data");
        this.izX.setText(2131763985);
        AppMethodBeat.o(119964);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
    public final class c
      extends StoryEntranceUI.c.a
    {
      private final ImageView ikp;
      private final TextView izX;
      
      public c()
      {
        super(localObject);
        AppMethodBeat.i(119968);
        this$1 = localObject.findViewById(2131297008);
        d.g.b.k.g(StoryEntranceUI.c.this, "itemView.findViewById(R.id.avatar_iv)");
        this.ikp = ((ImageView)StoryEntranceUI.c.this);
        this$1 = localObject.findViewById(2131306244);
        d.g.b.k.g(StoryEntranceUI.c.this, "itemView.findViewById(R.id.user_name_tv)");
        this.izX = ((TextView)StoryEntranceUI.c.this);
        localObject.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(119966);
            int i = this.ytf.ln();
            paramAnonymousView = StoryEntranceUI.c.a(this.ytf.ytd).get(i);
            d.g.b.k.g(paramAnonymousView, "userList[position]");
            paramAnonymousView = (StoryEntranceUI.b)paramAnonymousView;
            d.g.a.m localm = this.ytf.ytd.ypN;
            if (localm != null)
            {
              localm.n(Integer.valueOf(i), paramAnonymousView);
              AppMethodBeat.o(119966);
              return;
            }
            AppMethodBeat.o(119966);
          }
        });
        AppMethodBeat.o(119968);
      }
      
      public final void a(StoryEntranceUI.b paramb)
      {
        AppMethodBeat.i(119967);
        d.g.b.k.h(paramb, "data");
        a.b.c(this.ikp, paramb.userName);
        Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().aHY(paramb.userName);
        if (localObject != null)
        {
          String str = ((af)localObject).ZX();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = paramb.userName;
        }
        localObject = com.tencent.mm.pluginsdk.ui.span.k.b(this.izX.getContext(), (CharSequence)localObject, this.izX.getTextSize());
        if (StoryEntranceUI.a(StoryEntranceUI.c.this.ytc).contains(paramb.userName)) {
          this.izX.setTextColor(StoryEntranceUI.c.this.ytc.getContext().getResources().getColor(2131099660));
        }
        for (;;)
        {
          this.izX.setText((CharSequence)localObject);
          AppMethodBeat.o(119967);
          return;
          this.izX.setTextColor(StoryEntranceUI.c.this.ytc.getContext().getResources().getColor(2131100711));
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(StoryEntranceUI paramStoryEntranceUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119974);
      this.ytc.finish();
      AppMethodBeat.o(119974);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.m<Integer, StoryEntranceUI.b, y>
  {
    e(StoryEntranceUI paramStoryEntranceUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI
 * JD-Core Version:    0.7.0.1
 */