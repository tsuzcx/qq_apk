package com.tencent.mm.plugin.story.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.t;
import d.g.b.q;
import d.v;
import d.z;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"})
public final class StorySettingsUI
  extends MMActivity
{
  public static final d AVg;
  private static final String TAG = "MicroMsg.StorySettingUI";
  private a AVd;
  private StoryCaptureProxy AVe;
  private com.tencent.mm.ui.base.p AVf;
  private final LinkedList<e> gYZ;
  private ListView gZb;
  private com.tencent.mm.remoteservice.d giA;
  
  static
  {
    AppMethodBeat.i(119711);
    AVg = new d((byte)0);
    TAG = "MicroMsg.StorySettingUI";
    AppMethodBeat.o(119711);
  }
  
  public StorySettingsUI()
  {
    AppMethodBeat.i(119710);
    this.giA = new com.tencent.mm.remoteservice.d(aj.getContext());
    this.gYZ = new LinkedList();
    AppMethodBeat.o(119710);
  }
  
  public final int getLayoutId()
  {
    return 2131495719;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(178052);
    if ((4096 == paramInt1) && (-1 == paramInt2)) {
      if (paramIntent == null) {
        break label71;
      }
    }
    label71:
    for (paramIntent = paramIntent.getStringExtra("KEY_CONTENT_XML");; paramIntent = null)
    {
      if (!bt.isNullOrNil(paramIntent)) {
        getSharedPreferences("test_plugin", 0).edit().putString("content", paramIntent).apply();
      }
      AppMethodBeat.o(178052);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119706);
    super.onCreate(paramBundle);
    this.AVe = new StoryCaptureProxy(this.giA);
    this.giA.connect((Runnable)new ag(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new ah(this));
    AppMethodBeat.o(119706);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119707);
    super.onDestroy();
    this.giA.release();
    AppMethodBeat.o(119707);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(119709);
    super.onPause();
    AppMethodBeat.o(119709);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119708);
    super.onResume();
    AppMethodBeat.o(119708);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(119659);
      int i = StorySettingsUI.c(this.AVh).size();
      AppMethodBeat.o(119659);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(119660);
      Object localObject = StorySettingsUI.c(this.AVh).get(paramInt);
      d.g.b.p.g(localObject, "selectsList[position]");
      AppMethodBeat.o(119660);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"SetTextI18n"})
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(119661);
      d.g.b.p.h(paramViewGroup, "parent");
      paramView = new TextView((Context)this.AVh);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StorySettingsUI.ITestMenu");
        AppMethodBeat.o(119661);
        throw paramView;
      }
      paramViewGroup = (StorySettingsUI.e)paramViewGroup;
      paramView.setText((CharSequence)(paramViewGroup.aer() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(119661);
      return paramView;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(StorySettingsUI.e parame, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119658);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.AVi.cy((View)paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119658);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class aa
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119698);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.ehH();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119698);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ab
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119699);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.recordvideo.b.e.xxi;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.xxi;
      if (!com.tencent.mm.plugin.recordvideo.b.e.dFp()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.pH(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119699);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ac
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119700);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.recordvideo.b.e.xxi;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.xxi;
      if (!com.tencent.mm.plugin.recordvideo.b.e.dFq()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.pI(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119700);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ad
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119701);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (!com.tencent.mm.plugin.story.c.c.xxH) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.story.c.c.xxH = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119701);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ae
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119702);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      com.tencent.mm.plugin.story.c.c.AE(100000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119702);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class af
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119703);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      com.tencent.mm.plugin.story.c.c.ehk();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119703);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class ag
    implements Runnable
  {
    ag(StorySettingsUI paramStorySettingsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(119704);
      StorySettingsUI.d locald = StorySettingsUI.AVg;
      ad.i(StorySettingsUI.access$getTAG$cp(), "has connect");
      StorySettingsUI.d(this.AVh);
      AppMethodBeat.o(119704);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class ah
    implements MenuItem.OnMenuItemClickListener
  {
    ah(StorySettingsUI paramStorySettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119705);
      this.AVh.finish();
      AppMethodBeat.o(119705);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"})
  public final class b
    implements StorySettingsUI.e
  {
    private String gZg;
    al.a gZh;
    private String[] gZi;
    Object gZj;
    
    public b(al.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(119666);
      this.gZg = parama;
      this.gZh = paramArrayOfString;
      this.gZi = paramObject;
      this.gZj = localObject;
      AppMethodBeat.o(119666);
    }
    
    private final String dK(Object paramObject)
    {
      AppMethodBeat.i(119665);
      Object localObject = this.gZj;
      int j;
      int i;
      if ((localObject instanceof long[]))
      {
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(119665);
          throw paramObject;
        }
        long l = ((Long)paramObject).longValue();
        paramObject = this.gZj;
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.LongArray");
          AppMethodBeat.o(119665);
          throw paramObject;
        }
        j = ((long[])paramObject).length;
        i = 0;
        while (i < j)
        {
          paramObject = this.gZj;
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((l == ((long[])paramObject)[i]) && (i < this.gZi.length))
          {
            paramObject = this.gZi[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.gZi[0];
        AppMethodBeat.o(119665);
        return paramObject;
      }
      if ((localObject instanceof int[]))
      {
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(119665);
          throw paramObject;
        }
        j = ((Integer)paramObject).intValue();
        paramObject = this.gZj;
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.IntArray");
          AppMethodBeat.o(119665);
          throw paramObject;
        }
        int k = ((int[])paramObject).length;
        i = 0;
        while (i < k)
        {
          paramObject = this.gZj;
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type kotlin.IntArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((j == ((int[])paramObject)[i]) && (i < this.gZi.length))
          {
            paramObject = this.gZi[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.gZi[0];
        AppMethodBeat.o(119665);
        return paramObject;
      }
      AppMethodBeat.o(119665);
      return "";
    }
    
    public final String aer()
    {
      return this.gZg;
    }
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(119664);
      d.g.b.p.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.gZi.length;
      while (i < j)
      {
        paramView.add(this.gZi[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      com.tencent.mm.ui.base.h.a((Context)StorySettingsUI.this, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
      AppMethodBeat.o(119664);
    }
    
    public final String value()
    {
      AppMethodBeat.i(119663);
      if ((this.gZj instanceof long[]))
      {
        localObject = StorySettingsUI.a(StorySettingsUI.this);
        if (localObject == null) {
          d.g.b.p.gfZ();
        }
        localObject = dK(((StoryCaptureProxy)localObject).get(this.gZh, Long.valueOf(0L)));
        AppMethodBeat.o(119663);
        return localObject;
      }
      Object localObject = StorySettingsUI.a(StorySettingsUI.this);
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      localObject = dK(((StoryCaptureProxy)localObject).get(this.gZh, Integer.valueOf(0)));
      AppMethodBeat.o(119663);
      return localObject;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(StorySettingsUI.b paramb) {}
      
      public final void cv(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119662);
        Object localObject3;
        Object localObject4;
        try
        {
          Object localObject1 = this.AVj.gZj;
          if (!(localObject1 instanceof long[])) {
            break label141;
          }
          localObject1 = StorySettingsUI.a(this.AVj.AVh);
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          localObject3 = this.AVj.gZh;
          localObject4 = this.AVj.gZj;
          if (localObject4 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119662);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          localObject3 = StorySettingsUI.AVg;
          ad.printErrStackTrace(StorySettingsUI.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(119662);
          return;
        }
        localException.set((al.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
        for (;;)
        {
          StorySettingsUI.b(this.AVj.AVh).notifyDataSetChanged();
          AppMethodBeat.o(119662);
          return;
          label141:
          if ((localException instanceof int[]))
          {
            Object localObject2 = StorySettingsUI.a(this.AVj.AVh);
            if (localObject2 == null) {
              d.g.b.p.gfZ();
            }
            localObject3 = this.AVj.gZh;
            localObject4 = this.AVj.gZj;
            if (localObject4 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(119662);
              throw ((Throwable)localObject2);
            }
            ((StoryCaptureProxy)localObject2).set((al.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
          }
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ClickItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "getValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-story_release"})
  public static final class c
    implements StorySettingsUI.e
  {
    private final View.OnClickListener Aiz;
    private final String title;
    private final String value;
    
    public c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(119668);
      this.title = paramString1;
      this.value = paramString2;
      this.Aiz = paramOnClickListener;
      AppMethodBeat.o(119668);
    }
    
    public final String aer()
    {
      return this.title;
    }
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(119667);
      d.g.b.p.h(paramView, "view");
      this.Aiz.onClick(paramView);
      t.makeText(aj.getContext(), (CharSequence)"ClickItem Done", 1).show();
      AppMethodBeat.o(119667);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class d {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-story_release"})
  public static abstract interface e
  {
    public abstract String aer();
    
    public abstract void cy(View paramView);
    
    public abstract String value();
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class f
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119669);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      localObject = new Intent((Context)this.AVh, Class.forName("com.tencent.mm.plugin.ui.SampleListUI"));
      paramView = this.AVh;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119669);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class g
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119670);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      com.tencent.mm.plugin.story.c.c.AE(10000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119670);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119674);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.story.f.f.a.ANj;
      com.tencent.mm.plugin.story.f.f.a.eiS();
      com.tencent.mm.ad.c.a(5000L, (d.g.a.a)a.AVk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119674);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      public static final a AVk;
      
      static
      {
        AppMethodBeat.i(119673);
        AVk = new a();
        AppMethodBeat.o(119673);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class j
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119675);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = j.AKb;
      j.AG(0L);
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.ehI();
      com.tencent.mm.plugin.story.f.f.a.ANj.init();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119675);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class k
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119676);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.story.f.l.AKo;
      paramView = com.tencent.mm.plugin.story.f.l.cLR();
      com.tencent.mm.ui.base.h.T((Context)this.AVh.getContext(), paramView, "嗯");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119676);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class l
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119677);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = j.AKb;
      com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
      com.tencent.mm.ui.base.h.T((Context)this.AVh.getContext(), "ok", "嗯");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119677);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class m
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119681);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      paramView = this.AVh;
      localObject = (Context)this.AVh.getContext();
      this.AVh.getString(2131755906);
      StorySettingsUI.a(paramView, com.tencent.mm.ui.base.h.b((Context)localObject, this.AVh.getString(2131755936), true, (DialogInterface.OnCancelListener)new a(this)));
      com.tencent.mm.ad.c.b("cpfiles", (d.g.a.a)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119681);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      a(StorySettingsUI.m paramm) {}
      
      public final void onCancel(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(119678);
        this.AVl.AVh.finish();
        AppMethodBeat.o(119678);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(StorySettingsUI.m paramm)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class n
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119682);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (!ac.iPU) {}
      for (boolean bool = true;; bool = false)
      {
        ac.iPU = bool;
        com.tencent.mm.ui.base.h.T((Context)this.AVh.getContext(), "ok value Test Fail:" + ac.iPU, "嗯");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119682);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class o
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119683);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (!ac.iPV) {}
      for (boolean bool = true;; bool = false)
      {
        ac.iPV = bool;
        com.tencent.mm.ui.base.h.T((Context)this.AVh.getContext(), "ok value Test Fail:" + ac.iPV, "嗯");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119683);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119684);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFp, Boolean.FALSE);
      com.tencent.mm.ui.base.h.T((Context)this.AVh.getContext(), "在群视频，不要上滑，静候5秒", "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119684);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class q
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119685);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.ehJ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119685);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    public static final r AVn;
    
    static
    {
      AppMethodBeat.i(119687);
      AVn = new r();
      AppMethodBeat.o(119687);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119686);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFo, Integer.valueOf(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119686);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    public static final s AVo;
    
    static
    {
      AppMethodBeat.i(119689);
      AVo = new s();
      AppMethodBeat.o(119689);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119688);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFq, Boolean.FALSE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119688);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    public static final t AVp;
    
    static
    {
      AppMethodBeat.i(119691);
      AVp = new t();
      AppMethodBeat.o(119691);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119690);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFs, Boolean.FALSE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFt, Boolean.FALSE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119690);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119692);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.story.f.i.AJE;
      com.tencent.mm.plugin.story.f.i.ehL();
      com.tencent.mm.ui.base.h.T((Context)this.AVh.getContext(), "ok！", "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119692);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class v
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119693);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFI, Long.valueOf(0L));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119693);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119694);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      try
      {
        paramView = this.AVh.getContext();
        d.g.b.p.g(paramView, "context");
        paramView = paramView.getExternalCacheDir().toString();
        com.tencent.mm.vfs.i.deleteDir(paramView + "/imgcache");
        label79:
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119694);
        return;
      }
      catch (Exception paramView)
      {
        break label79;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119695);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = new Intent();
      paramView.putExtra("KEY_EDITABLE", true);
      paramView.putExtra("KEY_CONTENT_XML", this.AVh.getSharedPreferences("test_plugin", 0).getString("content", ""));
      com.tencent.mm.bs.d.b((Context)this.AVh.getContext(), "editor", ".EditorUI", paramView, 4096);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119695);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class y
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119696);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IJP, Integer.valueOf(0));
      t.makeText(aj.getContext(), (CharSequence)"好了", 1).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119696);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class z
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119697);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFz, Boolean.TRUE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFB, Boolean.TRUE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFA, Boolean.TRUE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFp, Boolean.FALSE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFo, Integer.valueOf(0));
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFq, Boolean.FALSE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFr, Boolean.FALSE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFs, Boolean.FALSE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFt, Boolean.FALSE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFC, Boolean.TRUE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFD, Integer.valueOf(0));
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFM, Boolean.TRUE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFu, Boolean.TRUE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IFv, Boolean.TRUE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IJm, Integer.valueOf(0));
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IJo, Boolean.TRUE);
      paramView = g.ajC();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajl().set(al.a.IJt, Integer.valueOf(0));
      t.makeText(aj.getContext(), (CharSequence)"好了", 1).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI
 * JD-Core Version:    0.7.0.1
 */