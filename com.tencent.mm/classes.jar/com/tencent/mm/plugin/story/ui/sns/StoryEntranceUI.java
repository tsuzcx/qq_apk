package com.tencent.mm.plugin.story.ui.sns;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.story.f.f.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TYPE_TIP", "", "getTYPE_TIP", "()I", "TYPE_USERNAME", "getTYPE_USERNAME", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "readNameList", "", "", "kotlin.jvm.PlatformType", "", "storyTypeIndex", "userNameList", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "finish", "", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class StoryEntranceUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  public static final a FAf;
  private static final String TAG = "MicroMsg.StoryEntranceUI";
  private RecyclerView FAa;
  private StoryEntranceUI.c FAb;
  private int FAc;
  private List<StoryEntranceUI.b> FAd;
  private List<String> FAe;
  private final int FzY;
  private final int FzZ;
  
  static
  {
    AppMethodBeat.i(119981);
    FAf = new a((byte)0);
    TAG = "MicroMsg.StoryEntranceUI";
    AppMethodBeat.o(119981);
  }
  
  public StoryEntranceUI()
  {
    AppMethodBeat.i(119980);
    this.FzY = 1;
    this.FzZ = 2;
    this.FAc = -1;
    this.FAd = Collections.synchronizedList((List)new LinkedList());
    this.FAe = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(119980);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(119978);
    Log.i(TAG, "finish " + this.FAe.size());
    if (this.FAd.size() > 0)
    {
      Object localObject1 = ((StoryEntranceUI.b)this.FAd.get(0)).userName;
      Object localObject2 = j.Fmy;
      localObject2 = j.b.fod().aRS((String)localObject1);
      if (localObject2 != null)
      {
        long l2 = ((f)localObject2).field_updateTime;
        long l1 = l2;
        if (l2 == 0L) {
          l1 = ((f)localObject2).field_storyPostTime * 1000L;
        }
        Log.i(TAG, "finish updateTime user:" + (String)localObject1 + " updateTime: " + l1);
        if (l1 > 0L)
        {
          localObject1 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).azQ().set(ar.a.OiM, Long.valueOf(l1));
        }
      }
    }
    super.finish();
    AppMethodBeat.o(119978);
  }
  
  public final int getLayoutId()
  {
    return 2131496595;
  }
  
  public final void onCreate(Bundle arg1)
  {
    AppMethodBeat.i(119976);
    Log.i(TAG, "StoryEntranceUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    getWindow().addFlags(1024);
    super.onCreate(???);
    ??? = j.Fmy;
    j.b.fod().add((MStorage.IOnStorageChange)this);
    setMMTitle(2131766221);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this), 2131689490);
    ??? = findViewById(2131308616);
    p.g(???, "findViewById(R.id.story_entrance_recycler)");
    this.FAa = ((RecyclerView)???);
    ??? = this.FAa;
    if (??? == null) {
      p.btv("entranceRecycler");
    }
    ???.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.FAb = new StoryEntranceUI.c(this);
    ??? = this.FAa;
    if (??? == null) {
      p.btv("entranceRecycler");
    }
    ???.setItemViewCacheSize(0);
    ??? = this.FAa;
    if (??? == null) {
      p.btv("entranceRecycler");
    }
    ??? = this.FAb;
    if (??? == null) {
      p.btv("entranceAdapter");
    }
    ???.setAdapter((RecyclerView.a)???);
    ??? = this.FAb;
    if (??? == null) {
      p.btv("entranceAdapter");
    }
    ???.uAj = ((m)new e(this));
    ??? = a.FpB.fnj();
    ??? = a.FpB.fnk();
    Log.i(TAG, "userNames " + ((List)???).size() + " lastUserNames " + ???.size());
    synchronized ((Iterable)???)
    {
      localObject4 = ((Iterable)???).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        this.FAd.add(new StoryEntranceUI.b(str, 1));
      }
    }
    Object localObject4 = x.SXb;
    this.FAc = this.FAd.size();
    if (???.size() > 0) {
      this.FAd.add(new StoryEntranceUI.b("", 2));
    }
    synchronized ((Iterable)???)
    {
      ??? = ???.iterator();
      if (((Iterator)???).hasNext())
      {
        localObject4 = (String)((Iterator)???).next();
        this.FAd.add(new StoryEntranceUI.b((String)localObject4, 1));
      }
    }
    Object localObject3 = x.SXb;
    ??? = this.FAb;
    if (??? == null) {
      p.btv("entranceAdapter");
    }
    localObject3 = this.FAd;
    p.g(localObject3, "userNameList");
    p.h(localObject3, "extinfoList");
    ???.hKT.clear();
    ???.hKT.addAll((Collection)localObject3);
    ???.notifyDataSetChanged();
    AppMethodBeat.o(119976);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119977);
    super.onDestroy();
    j.b localb = j.Fmy;
    j.b.fod().remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(119977);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119979);
    if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof f))) {
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
    paramString = ((f)paramString).getUserName();
    this.FAe.add(paramString);
    paramString = this.FAb;
    if (paramString == null) {
      p.btv("entranceAdapter");
    }
    paramString.notifyDataSetChanged();
    AppMethodBeat.o(119979);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(StoryEntranceUI paramStoryEntranceUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119974);
      this.FAg.finish();
      AppMethodBeat.o(119974);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "invoke"})
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