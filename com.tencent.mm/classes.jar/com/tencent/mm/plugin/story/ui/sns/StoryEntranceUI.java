package com.tencent.mm.plugin.story.ui.sns;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.story.f.f.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TYPE_TIP", "", "getTYPE_TIP", "()I", "TYPE_USERNAME", "getTYPE_USERNAME", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "readNameList", "", "", "kotlin.jvm.PlatformType", "", "storyTypeIndex", "userNameList", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "finish", "", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class StoryEntranceUI
  extends MMActivity
  implements k.a
{
  private static final String TAG = "MicroMsg.StoryEntranceUI";
  public static final StoryEntranceUI.a zGu;
  private final int zGn;
  private final int zGo;
  private RecyclerView zGp;
  private StoryEntranceUI.c zGq;
  private int zGr;
  private List<StoryEntranceUI.b> zGs;
  private List<String> zGt;
  
  static
  {
    AppMethodBeat.i(119981);
    zGu = new StoryEntranceUI.a((byte)0);
    TAG = "MicroMsg.StoryEntranceUI";
    AppMethodBeat.o(119981);
  }
  
  public StoryEntranceUI()
  {
    AppMethodBeat.i(119980);
    this.zGn = 1;
    this.zGo = 2;
    this.zGr = -1;
    this.zGs = Collections.synchronizedList((List)new LinkedList());
    this.zGt = Collections.synchronizedList((List)new LinkedList());
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
      ac.i(TAG, "unknown event ".concat(String.valueOf(paramString)));
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
    this.zGt.add(paramString);
    paramString = this.zGq;
    if (paramString == null) {
      k.aVY("entranceAdapter");
    }
    paramString.notifyDataSetChanged();
    AppMethodBeat.o(119979);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119978);
    ac.i(TAG, "finish " + this.zGt.size());
    if (this.zGs.size() > 0)
    {
      Object localObject1 = ((StoryEntranceUI.b)this.zGs.get(0)).userName;
      Object localObject2 = j.zsh;
      localObject2 = j.b.dVF().awy((String)localObject1);
      if (localObject2 != null)
      {
        long l2 = ((f)localObject2).field_updateTime;
        long l1 = l2;
        if (l2 == 0L) {
          l1 = ((f)localObject2).field_storyPostTime * 1000L;
        }
        ac.i(TAG, "finish updateTime user:" + (String)localObject1 + " updateTime: " + l1);
        if (l1 > 0L)
        {
          localObject1 = com.tencent.mm.kernel.g.agR();
          k.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).agA().set(ah.a.GTb, Long.valueOf(l1));
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
    ac.i(TAG, "StoryEntranceUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    getWindow().addFlags(1024);
    super.onCreate(???);
    ??? = j.zsh;
    j.b.dVF().add((k.a)this);
    setMMTitle(2131763983);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this), 2131689488);
    ??? = findViewById(2131305410);
    k.g(???, "findViewById(R.id.story_entrance_recycler)");
    this.zGp = ((RecyclerView)???);
    ??? = this.zGp;
    if (??? == null) {
      k.aVY("entranceRecycler");
    }
    ???.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.zGq = new StoryEntranceUI.c(this);
    ??? = this.zGp;
    if (??? == null) {
      k.aVY("entranceRecycler");
    }
    ???.setItemViewCacheSize(0);
    ??? = this.zGp;
    if (??? == null) {
      k.aVY("entranceRecycler");
    }
    ??? = this.zGq;
    if (??? == null) {
      k.aVY("entranceAdapter");
    }
    ???.setAdapter((RecyclerView.a)???);
    ??? = this.zGq;
    if (??? == null) {
      k.aVY("entranceAdapter");
    }
    ???.rFB = ((d.g.a.m)new e(this));
    ??? = a.zvn.dUL();
    ??? = a.zvn.dUM();
    ac.i(TAG, "userNames " + ((List)???).size() + " lastUserNames " + ???.size());
    synchronized ((Iterable)???)
    {
      localObject4 = ((Iterable)???).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        this.zGs.add(new StoryEntranceUI.b(str, 1));
      }
    }
    Object localObject4 = y.KTp;
    this.zGr = this.zGs.size();
    if (???.size() > 0) {
      this.zGs.add(new StoryEntranceUI.b("", 2));
    }
    synchronized ((Iterable)???)
    {
      ??? = ???.iterator();
      if (((Iterator)???).hasNext())
      {
        localObject4 = (String)((Iterator)???).next();
        this.zGs.add(new StoryEntranceUI.b((String)localObject4, 1));
      }
    }
    Object localObject3 = y.KTp;
    ??? = this.zGq;
    if (??? == null) {
      k.aVY("entranceAdapter");
    }
    localObject3 = this.zGs;
    k.g(localObject3, "userNameList");
    k.h(localObject3, "extinfoList");
    ???.gxd.clear();
    ???.gxd.addAll((Collection)localObject3);
    ???.notifyDataSetChanged();
    AppMethodBeat.o(119976);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119977);
    super.onDestroy();
    j.b localb = j.zsh;
    j.b.dVF().remove((k.a)this);
    AppMethodBeat.o(119977);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(StoryEntranceUI paramStoryEntranceUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119974);
      this.zGv.finish();
      AppMethodBeat.o(119974);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI
 * JD-Core Version:    0.7.0.1
 */