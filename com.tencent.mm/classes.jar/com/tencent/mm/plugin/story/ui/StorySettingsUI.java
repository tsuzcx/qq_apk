package com.tencent.mm.plugin.story.ui;

import a.l;
import a.v;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.h;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"})
@com.tencent.mm.ui.base.a(3)
public final class StorySettingsUI
  extends MMActivity
{
  private static final String TAG = "MicroMsg.StorySettingUI";
  public static final StorySettingsUI.d sHP;
  private d evl;
  private ListView gMh;
  private final LinkedList<StorySettingsUI.e> oQA;
  private a sHM;
  private StoryCaptureProxy sHN;
  private p sHO;
  
  static
  {
    AppMethodBeat.i(110084);
    sHP = new StorySettingsUI.d((byte)0);
    TAG = "MicroMsg.StorySettingUI";
    AppMethodBeat.o(110084);
  }
  
  public StorySettingsUI()
  {
    AppMethodBeat.i(110083);
    this.evl = new d(ah.getContext());
    this.oQA = new LinkedList();
    AppMethodBeat.o(110083);
  }
  
  public final int getLayoutId()
  {
    return 2130970972;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110079);
    super.onCreate(paramBundle);
    this.sHN = new StoryCaptureProxy(this.evl);
    this.evl.connect((Runnable)new StorySettingsUI.ab(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new StorySettingsUI.ac(this));
    AppMethodBeat.o(110079);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(110080);
    super.onDestroy();
    this.evl.release();
    AppMethodBeat.o(110080);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(110082);
    super.onPause();
    AppMethodBeat.o(110082);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(110081);
    super.onResume();
    AppMethodBeat.o(110081);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(110041);
      int i = StorySettingsUI.c(this.sHQ).size();
      AppMethodBeat.o(110041);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(110042);
      Object localObject = StorySettingsUI.c(this.sHQ).get(paramInt);
      a.f.b.j.p(localObject, "selectsList[position]");
      AppMethodBeat.o(110042);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"SetTextI18n"})
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(110043);
      a.f.b.j.q(paramViewGroup, "parent");
      paramView = new TextView((Context)this.sHQ);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StorySettingsUI.ITestMenu");
        AppMethodBeat.o(110043);
        throw paramView;
      }
      paramViewGroup = (StorySettingsUI.e)paramViewGroup;
      paramView.setText((CharSequence)(paramViewGroup.Ol() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new StorySettingsUI.a.a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(110043);
      return paramView;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class aa
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(110076);
      paramView = com.tencent.mm.plugin.story.model.j.svi;
      com.tencent.mm.plugin.story.model.j.mv(0L);
      new h();
      h.cAn();
      com.tencent.mm.plugin.story.model.f.a.szc.init();
      AppMethodBeat.o(110076);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
  static final class b$a
    implements h.d
  {
    b$a(StorySettingsUI.b paramb) {}
    
    public final void ca(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(110044);
      Object localObject3;
      Object localObject4;
      try
      {
        Object localObject1 = this.sHU.sHT;
        if (!(localObject1 instanceof long[])) {
          break label141;
        }
        localObject1 = StorySettingsUI.a(this.sHU.sHQ);
        if (localObject1 == null) {
          a.f.b.j.ebi();
        }
        localObject3 = this.sHU.oQH;
        localObject4 = this.sHU.sHT;
        if (localObject4 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
          AppMethodBeat.o(110044);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        localObject3 = StorySettingsUI.sHP;
        ab.printErrStackTrace(StorySettingsUI.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(110044);
        return;
      }
      localException.set((ac.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
      for (;;)
      {
        StorySettingsUI.b(this.sHU.sHQ).notifyDataSetChanged();
        AppMethodBeat.o(110044);
        return;
        label141:
        if ((localException instanceof int[]))
        {
          Object localObject2 = StorySettingsUI.a(this.sHU.sHQ);
          if (localObject2 == null) {
            a.f.b.j.ebi();
          }
          localObject3 = this.sHU.oQH;
          localObject4 = this.sHU.sHT;
          if (localObject4 == null)
          {
            localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
            AppMethodBeat.o(110044);
            throw ((Throwable)localObject2);
          }
          ((StoryCaptureProxy)localObject2).set((ac.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI
 * JD-Core Version:    0.7.0.1
 */