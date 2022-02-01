package com.tencent.mm.plugin.story.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.h.a.f;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ContactsAdapter;", "blackList", "Ljava/util/ArrayList;", "", "contactLV", "Landroid/widget/ListView;", "groupList", "localId", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "titile", "userNames", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "prepareData", "Companion", "ContactsAdapter", "ViewHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryRangeDetailUI
  extends MMActivity
{
  public static final StoryRangeDetailUI.a StR;
  private static final String TAG;
  private ListView JVY;
  private j SnL;
  private StoryRangeDetailUI.b StS;
  private String StT;
  private int icg;
  private final ArrayList<String> lPt;
  private final ArrayList<String> mkV;
  private final ArrayList<String> qXB;
  
  static
  {
    AppMethodBeat.i(119657);
    StR = new StoryRangeDetailUI.a((byte)0);
    TAG = "MicroMsg.StoryRangeDetailUI";
    AppMethodBeat.o(119657);
  }
  
  public StoryRangeDetailUI()
  {
    AppMethodBeat.i(119656);
    this.lPt = new ArrayList();
    this.mkV = new ArrayList();
    this.qXB = new ArrayList();
    AppMethodBeat.o(119656);
  }
  
  private static final void a(StoryRangeDetailUI paramStoryRangeDetailUI, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(367213);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStoryRangeDetailUI);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/plugin/story/ui/StoryRangeDetailUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject, localb.aYj());
    s.u(paramStoryRangeDetailUI, "this$0");
    paramAdapterView = paramStoryRangeDetailUI.StS;
    if (paramAdapterView == null) {}
    for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = paramAdapterView.getItem(paramInt))
    {
      paramStoryRangeDetailUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.contact.RContact");
      AppMethodBeat.o(367213);
      throw paramStoryRangeDetailUI;
    }
    paramAdapterView = (d)paramAdapterView;
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramAdapterView.field_username);
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
    c.b((Context)paramStoryRangeDetailUI.getContext(), "profile", ".ui.ContactInfoUI", paramView);
    a.a(new Object(), "com/tencent/mm/plugin/story/ui/StoryRangeDetailUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(367213);
  }
  
  private static final boolean a(StoryRangeDetailUI paramStoryRangeDetailUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(367208);
    s.u(paramStoryRangeDetailUI, "this$0");
    paramStoryRangeDetailUI.finish();
    AppMethodBeat.o(367208);
    return true;
  }
  
  public final int getLayoutId()
  {
    return a.e.SgY;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(119654);
    setMMTitle(this.StT);
    Object localObject = findViewById(a.d.address_contactlist);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(119654);
      throw ((Throwable)localObject);
    }
    this.JVY = ((ListView)localObject);
    localObject = this.JVY;
    if (localObject != null) {
      ((ListView)localObject).setBackgroundColor(getResources().getColor(a.a.white));
    }
    localObject = this.JVY;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((ListView)localObject).getParent())
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(119654);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setBackgroundColor(getResources().getColor(a.a.white));
    setBackBtn(new StoryRangeDetailUI..ExternalSyntheticLambda0(this));
    showOptionMenu(false);
    if ((this.lPt != null) && (this.lPt.size() != 0))
    {
      this.StS = new StoryRangeDetailUI.b((Context)this, (List)this.lPt);
      localObject = this.JVY;
      if (localObject != null) {
        ((ListView)localObject).setAdapter((ListAdapter)this.StS);
      }
      localObject = this.JVY;
      if (localObject != null) {
        ((ListView)localObject).setVisibility(0);
      }
      localObject = this.JVY;
      if (localObject != null) {
        ((ListView)localObject).setOnItemClickListener(new StoryRangeDetailUI..ExternalSyntheticLambda1(this));
      }
    }
    AppMethodBeat.o(119654);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119653);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    Object localObject = a.f.SsE;
    this.icg = paramBundle.getIntExtra(a.f.hzf(), -1);
    paramBundle = StoryCore.SjP;
    this.SnL = StoryCore.b.hvR().anv(this.icg);
    localObject = this.mkV;
    paramBundle = this.SnL;
    if (paramBundle == null)
    {
      paramBundle = null;
      if (paramBundle != null) {
        break label205;
      }
      paramBundle = (Collection)new ArrayList();
      label81:
      ((ArrayList)localObject).addAll(paramBundle);
      localObject = this.qXB;
      paramBundle = this.SnL;
      if (paramBundle != null) {
        break label213;
      }
      paramBundle = null;
      label103:
      if (paramBundle != null) {
        break label221;
      }
      paramBundle = (Collection)new ArrayList();
      label118:
      ((ArrayList)localObject).addAll(paramBundle);
      if (this.icg != -1)
      {
        paramBundle = (Collection)this.mkV;
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label229;
        }
        i = 1;
        label155:
        if (i == 0) {
          break label239;
        }
        paramBundle = (Collection)this.qXB;
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label234;
        }
      }
    }
    label205:
    label213:
    label221:
    label229:
    label234:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label239;
      }
      finish();
      AppMethodBeat.o(119653);
      return;
      paramBundle = paramBundle.aVm();
      break;
      paramBundle = (Collection)paramBundle;
      break label81;
      paramBundle = paramBundle.hzr();
      break label103;
      paramBundle = (Collection)paramBundle;
      break label118;
      i = 0;
      break label155;
    }
    label239:
    paramBundle = (Collection)this.qXB;
    if ((paramBundle == null) || (paramBundle.isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label308;
      }
      this.StT = getString(a.g.ShS);
      this.lPt.addAll((Collection)this.qXB);
    }
    label308:
    label367:
    for (;;)
    {
      initView();
      AppMethodBeat.o(119653);
      return;
      i = 0;
      break;
      paramBundle = (Collection)this.mkV;
      if ((paramBundle == null) || (paramBundle.isEmpty())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label367;
        }
        this.StT = getString(a.g.ShT);
        this.lPt.addAll((Collection)this.mkV);
        break;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119655);
    super.onResume();
    if (this.StS != null)
    {
      StoryRangeDetailUI.b localb = this.StS;
      if (localb != null) {
        localb.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(119655);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryRangeDetailUI
 * JD-Core Version:    0.7.0.1
 */