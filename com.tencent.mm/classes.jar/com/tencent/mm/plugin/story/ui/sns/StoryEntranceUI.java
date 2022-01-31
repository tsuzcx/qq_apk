package com.tencent.mm.plugin.story.ui.sns;

import a.l;
import a.v;
import a.y;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.f.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TYPE_TIP", "", "getTYPE_TIP", "()I", "TYPE_USERNAME", "getTYPE_USERNAME", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "readNameList", "", "", "kotlin.jvm.PlatformType", "", "storyTypeIndex", "userNameList", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "finish", "", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class StoryEntranceUI
  extends MMActivity
  implements k.a
{
  private static final String TAG = "MicroMsg.StoryEntranceUI";
  public static final StoryEntranceUI.a sKx;
  private final int sKq;
  private final int sKr;
  private RecyclerView sKs;
  private StoryEntranceUI.c sKt;
  private int sKu;
  private List<StoryEntranceUI.b> sKv;
  private List<String> sKw;
  
  static
  {
    AppMethodBeat.i(110265);
    sKx = new StoryEntranceUI.a((byte)0);
    TAG = "MicroMsg.StoryEntranceUI";
    AppMethodBeat.o(110265);
  }
  
  public StoryEntranceUI()
  {
    AppMethodBeat.i(110264);
    this.sKq = 1;
    this.sKr = 2;
    this.sKu = -1;
    this.sKv = Collections.synchronizedList((List)new LinkedList());
    this.sKw = Collections.synchronizedList((List)new LinkedList());
    AppMethodBeat.o(110264);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(110263);
    if ((paramString != null) && (paramm != null) && ((paramm.obj instanceof f))) {
      switch (paramString.hashCode())
      {
      }
    }
    do
    {
      ab.i(TAG, "unknown event ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(110263);
      return;
    } while (!paramString.equals("notify_story_read"));
    paramString = paramm.obj;
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
      AppMethodBeat.o(110263);
      throw paramString;
    }
    paramString = ((f)paramString).getUserName();
    this.sKw.add(paramString);
    paramString = this.sKt;
    if (paramString == null) {
      a.f.b.j.ays("entranceAdapter");
    }
    paramString.notifyDataSetChanged();
    AppMethodBeat.o(110263);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(110262);
    ab.i(TAG, "finish " + this.sKw.size());
    if (this.sKv.size() > 0)
    {
      Object localObject1 = ((StoryEntranceUI.b)this.sKv.get(0)).userName;
      Object localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      localObject2 = j.b.cAC().acU((String)localObject1);
      if (localObject2 != null)
      {
        long l2 = ((f)localObject2).field_updateTime;
        long l1 = l2;
        if (l2 == 0L) {
          l1 = ((f)localObject2).field_storyPostTime * 1000L;
        }
        ab.i(TAG, "finish updateTime user:" + (String)localObject1 + " updateTime: " + l1);
        if (l1 > 0L)
        {
          localObject1 = com.tencent.mm.kernel.g.RL();
          a.f.b.j.p(localObject1, "MMKernel.storage()");
          ((e)localObject1).Ru().set(ac.a.yLL, Long.valueOf(l1));
        }
      }
    }
    super.finish();
    AppMethodBeat.o(110262);
  }
  
  public final int getLayoutId()
  {
    return 2130970952;
  }
  
  public final void onCreate(Bundle arg1)
  {
    AppMethodBeat.i(110260);
    ab.i(TAG, "StoryEntranceUI create ".concat(String.valueOf(this)));
    supportRequestWindowFeature(1);
    getWindow().addFlags(1024);
    super.onCreate(???);
    ??? = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAC().add((k.a)this);
    setMMTitle(2131303966);
    setBackBtn((MenuItem.OnMenuItemClickListener)new StoryEntranceUI.d(this), 2131230735);
    ??? = findViewById(2131828405);
    a.f.b.j.p(???, "findViewById(R.id.story_entrance_recycler)");
    this.sKs = ((RecyclerView)???);
    ??? = this.sKs;
    if (??? == null) {
      a.f.b.j.ays("entranceRecycler");
    }
    ???.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.sKt = new StoryEntranceUI.c(this);
    ??? = this.sKs;
    if (??? == null) {
      a.f.b.j.ays("entranceRecycler");
    }
    ???.setItemViewCacheSize(0);
    ??? = this.sKs;
    if (??? == null) {
      a.f.b.j.ays("entranceRecycler");
    }
    ??? = this.sKt;
    if (??? == null) {
      a.f.b.j.ays("entranceAdapter");
    }
    ???.setAdapter((RecyclerView.a)???);
    ??? = this.sKt;
    if (??? == null) {
      a.f.b.j.ays("entranceAdapter");
    }
    ???.sHB = ((a.f.a.m)new StoryEntranceUI.e(this));
    ??? = a.szc.czu();
    ??? = a.szc.czv();
    ab.i(TAG, "userNames " + ((List)???).size() + " lastUserNames " + ???.size());
    synchronized ((Iterable)???)
    {
      localObject4 = ((Iterable)???).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        this.sKv.add(new StoryEntranceUI.b(str, 1));
      }
    }
    Object localObject4 = y.BMg;
    this.sKu = this.sKv.size();
    if (???.size() > 0) {
      this.sKv.add(new StoryEntranceUI.b("", 2));
    }
    synchronized ((Iterable)???)
    {
      ??? = ???.iterator();
      if (((Iterator)???).hasNext())
      {
        localObject4 = (String)((Iterator)???).next();
        this.sKv.add(new StoryEntranceUI.b((String)localObject4, 1));
      }
    }
    Object localObject3 = y.BMg;
    ??? = this.sKt;
    if (??? == null) {
      a.f.b.j.ays("entranceAdapter");
    }
    localObject3 = this.sKv;
    a.f.b.j.p(localObject3, "userNameList");
    a.f.b.j.q(localObject3, "extinfoList");
    ???.sKy.clear();
    ???.sKy.addAll((Collection)localObject3);
    ???.notifyDataSetChanged();
    AppMethodBeat.o(110260);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(110261);
    super.onDestroy();
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAC().remove((k.a)this);
    AppMethodBeat.o(110261);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI
 * JD-Core Version:    0.7.0.1
 */