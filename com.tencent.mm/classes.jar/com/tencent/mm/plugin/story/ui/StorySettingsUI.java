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
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.o;
import d.g.b.q;
import d.v;
import d.z;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"})
public final class StorySettingsUI
  extends MMActivity
{
  public static final d BmE;
  private static final String TAG = "MicroMsg.StorySettingUI";
  private a BmB;
  private StoryCaptureProxy BmC;
  private com.tencent.mm.ui.base.p BmD;
  private com.tencent.mm.remoteservice.d gkS;
  private final LinkedList<e> hbM;
  private ListView hbO;
  
  static
  {
    AppMethodBeat.i(119711);
    BmE = new d((byte)0);
    TAG = "MicroMsg.StorySettingUI";
    AppMethodBeat.o(119711);
  }
  
  public StorySettingsUI()
  {
    AppMethodBeat.i(119710);
    this.gkS = new com.tencent.mm.remoteservice.d(ak.getContext());
    this.hbM = new LinkedList();
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
      if (!bu.isNullOrNil(paramIntent)) {
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
    this.BmC = new StoryCaptureProxy(this.gkS);
    this.gkS.connect((Runnable)new ag(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new ah(this));
    AppMethodBeat.o(119706);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119707);
    super.onDestroy();
    this.gkS.release();
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(119659);
      int i = StorySettingsUI.c(this.BmF).size();
      AppMethodBeat.o(119659);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(119660);
      Object localObject = StorySettingsUI.c(this.BmF).get(paramInt);
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
      paramView = new TextView((Context)this.BmF);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StorySettingsUI.ITestMenu");
        AppMethodBeat.o(119661);
        throw paramView;
      }
      paramViewGroup = (StorySettingsUI.e)paramViewGroup;
      paramView.setText((CharSequence)(paramViewGroup.aeD() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(119661);
      return paramView;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(StorySettingsUI.e parame, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119658);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.BmG.cy((View)paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119658);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class aa
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119698);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.elp();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119698);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ab
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119699);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.recordvideo.b.e.xNf;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.xNf;
      if (!com.tencent.mm.plugin.recordvideo.b.e.dIG()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.pP(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119699);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ac
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119700);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.recordvideo.b.e.xNf;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.xNf;
      if (!com.tencent.mm.plugin.recordvideo.b.e.dIH()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.pQ(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119700);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ad
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119701);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (!com.tencent.mm.plugin.story.c.c.xNE) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.story.c.c.xNE = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119701);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ae
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119702);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      com.tencent.mm.plugin.story.c.c.Bc(100000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119702);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class af
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119703);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      com.tencent.mm.plugin.story.c.c.ekS();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119703);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class ag
    implements Runnable
  {
    ag(StorySettingsUI paramStorySettingsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(119704);
      StorySettingsUI.d locald = StorySettingsUI.BmE;
      ae.i(StorySettingsUI.access$getTAG$cp(), "has connect");
      StorySettingsUI.d(this.BmF);
      AppMethodBeat.o(119704);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class ah
    implements MenuItem.OnMenuItemClickListener
  {
    ah(StorySettingsUI paramStorySettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119705);
      this.BmF.finish();
      AppMethodBeat.o(119705);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"})
  public final class b
    implements StorySettingsUI.e
  {
    private String hbT;
    am.a hbU;
    private String[] hbV;
    Object hbW;
    
    public b(am.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(119666);
      this.hbT = parama;
      this.hbU = paramArrayOfString;
      this.hbV = paramObject;
      this.hbW = localObject;
      AppMethodBeat.o(119666);
    }
    
    private final String dL(Object paramObject)
    {
      AppMethodBeat.i(119665);
      Object localObject = this.hbW;
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
        paramObject = this.hbW;
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
          paramObject = this.hbW;
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((l == ((long[])paramObject)[i]) && (i < this.hbV.length))
          {
            paramObject = this.hbV[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.hbV[0];
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
        paramObject = this.hbW;
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
          paramObject = this.hbW;
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type kotlin.IntArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((j == ((int[])paramObject)[i]) && (i < this.hbV.length))
          {
            paramObject = this.hbV[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.hbV[0];
        AppMethodBeat.o(119665);
        return paramObject;
      }
      AppMethodBeat.o(119665);
      return "";
    }
    
    public final String aeD()
    {
      return this.hbT;
    }
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(119664);
      d.g.b.p.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.hbV.length;
      while (i < j)
      {
        paramView.add(this.hbV[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      com.tencent.mm.ui.base.h.a((Context)StorySettingsUI.this, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
      AppMethodBeat.o(119664);
    }
    
    public final String value()
    {
      AppMethodBeat.i(119663);
      if ((this.hbW instanceof long[]))
      {
        localObject = StorySettingsUI.a(StorySettingsUI.this);
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        localObject = dL(((StoryCaptureProxy)localObject).get(this.hbU, Long.valueOf(0L)));
        AppMethodBeat.o(119663);
        return localObject;
      }
      Object localObject = StorySettingsUI.a(StorySettingsUI.this);
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      localObject = dL(((StoryCaptureProxy)localObject).get(this.hbU, Integer.valueOf(0)));
      AppMethodBeat.o(119663);
      return localObject;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
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
          Object localObject1 = this.BmH.hbW;
          if (!(localObject1 instanceof long[])) {
            break label141;
          }
          localObject1 = StorySettingsUI.a(this.BmH.BmF);
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          localObject3 = this.BmH.hbU;
          localObject4 = this.BmH.hbW;
          if (localObject4 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119662);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          localObject3 = StorySettingsUI.BmE;
          ae.printErrStackTrace(StorySettingsUI.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(119662);
          return;
        }
        localException.set((am.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
        for (;;)
        {
          StorySettingsUI.b(this.BmH.BmF).notifyDataSetChanged();
          AppMethodBeat.o(119662);
          return;
          label141:
          if ((localException instanceof int[]))
          {
            Object localObject2 = StorySettingsUI.a(this.BmH.BmF);
            if (localObject2 == null) {
              d.g.b.p.gkB();
            }
            localObject3 = this.BmH.hbU;
            localObject4 = this.BmH.hbW;
            if (localObject4 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(119662);
              throw ((Throwable)localObject2);
            }
            ((StoryCaptureProxy)localObject2).set((am.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
          }
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ClickItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "getValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-story_release"})
  public static final class c
    implements StorySettingsUI.e
  {
    private final View.OnClickListener AzL;
    private final String title;
    private final String value;
    
    public c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(119668);
      this.title = paramString1;
      this.value = paramString2;
      this.AzL = paramOnClickListener;
      AppMethodBeat.o(119668);
    }
    
    public final String aeD()
    {
      return this.title;
    }
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(119667);
      d.g.b.p.h(paramView, "view");
      this.AzL.onClick(paramView);
      t.makeText(ak.getContext(), (CharSequence)"ClickItem Done", 1).show();
      AppMethodBeat.o(119667);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class d {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-story_release"})
  public static abstract interface e
  {
    public abstract String aeD();
    
    public abstract void cy(View paramView);
    
    public abstract String value();
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class f
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119669);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = new Intent((Context)this.BmF, Class.forName("com.tencent.mm.plugin.ui.SampleListUI"));
      paramView = this.BmF;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119669);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class g
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119670);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      com.tencent.mm.plugin.story.c.c.Bc(10000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119670);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119674);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.story.f.f.a.BeK;
      com.tencent.mm.plugin.story.f.f.a.emA();
      com.tencent.mm.ac.c.a(5000L, (d.g.a.a)a.BmI);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119674);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      public static final a BmI;
      
      static
      {
        AppMethodBeat.i(119673);
        BmI = new a();
        AppMethodBeat.o(119673);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class j
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119675);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = j.BbE;
      j.Be(0L);
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.elq();
      com.tencent.mm.plugin.story.f.f.a.BeK.init();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119675);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class k
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119676);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.story.f.l.BbR;
      paramView = com.tencent.mm.plugin.story.f.l.cOz();
      com.tencent.mm.ui.base.h.T((Context)this.BmF.getContext(), paramView, "嗯");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119676);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class l
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119677);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = j.BbE;
      o.deleteDir(j.b.getAccStoryCachePath());
      com.tencent.mm.ui.base.h.T((Context)this.BmF.getContext(), "ok", "嗯");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119677);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class m
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119681);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      paramView = this.BmF;
      localObject = (Context)this.BmF.getContext();
      this.BmF.getString(2131755906);
      StorySettingsUI.a(paramView, com.tencent.mm.ui.base.h.b((Context)localObject, this.BmF.getString(2131755936), true, (DialogInterface.OnCancelListener)new a(this)));
      com.tencent.mm.ac.c.b("cpfiles", (d.g.a.a)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119681);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      a(StorySettingsUI.m paramm) {}
      
      public final void onCancel(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(119678);
        this.BmJ.BmF.finish();
        AppMethodBeat.o(119678);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class n
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119682);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (!ac.iSN) {}
      for (boolean bool = true;; bool = false)
      {
        ac.iSN = bool;
        com.tencent.mm.ui.base.h.T((Context)this.BmF.getContext(), "ok value Test Fail:" + ac.iSN, "嗯");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119682);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class o
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119683);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (!ac.iSO) {}
      for (boolean bool = true;; bool = false)
      {
        ac.iSO = bool;
        com.tencent.mm.ui.base.h.T((Context)this.BmF.getContext(), "ok value Test Fail:" + ac.iSO, "嗯");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119683);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119684);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZP, Boolean.FALSE);
      com.tencent.mm.ui.base.h.T((Context)this.BmF.getContext(), "在群视频，不要上滑，静候5秒", "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119684);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class q
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119685);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.elr();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119685);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    public static final r BmL;
    
    static
    {
      AppMethodBeat.i(119687);
      BmL = new r();
      AppMethodBeat.o(119687);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119686);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZO, Integer.valueOf(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119686);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    public static final s BmM;
    
    static
    {
      AppMethodBeat.i(119689);
      BmM = new s();
      AppMethodBeat.o(119689);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119688);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZQ, Boolean.FALSE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119688);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    public static final t BmN;
    
    static
    {
      AppMethodBeat.i(119691);
      BmN = new t();
      AppMethodBeat.o(119691);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119690);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZS, Boolean.FALSE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZT, Boolean.FALSE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119690);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119692);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = i.Bbh;
      i.elt();
      com.tencent.mm.ui.base.h.T((Context)this.BmF.getContext(), "ok！", "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119692);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class v
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119693);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.Jai, Long.valueOf(0L));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119693);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119694);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      try
      {
        paramView = this.BmF.getContext();
        d.g.b.p.g(paramView, "context");
        paramView = paramView.getExternalCacheDir().toString();
        o.deleteDir(paramView + "/imgcache");
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119695);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = new Intent();
      paramView.putExtra("KEY_EDITABLE", true);
      paramView.putExtra("KEY_CONTENT_XML", this.BmF.getSharedPreferences("test_plugin", 0).getString("content", ""));
      com.tencent.mm.br.d.b((Context)this.BmF.getContext(), "editor", ".EditorUI", paramView, 4096);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119695);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class y
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119696);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.Jev, Integer.valueOf(0));
      t.makeText(ak.getContext(), (CharSequence)"好了", 1).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119696);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class z
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119697);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZZ, Boolean.TRUE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.Jab, Boolean.TRUE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.Jaa, Boolean.TRUE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZP, Boolean.FALSE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZO, Integer.valueOf(0));
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZQ, Boolean.FALSE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZR, Boolean.FALSE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZS, Boolean.FALSE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZT, Boolean.FALSE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.Jac, Boolean.TRUE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.Jad, Integer.valueOf(0));
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.Jam, Boolean.TRUE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZU, Boolean.TRUE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.IZV, Boolean.TRUE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.JdS, Integer.valueOf(0));
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.JdU, Boolean.TRUE);
      paramView = g.ajR();
      d.g.b.p.g(paramView, "MMKernel.storage()");
      paramView.ajA().set(am.a.JdZ, Integer.valueOf(0));
      t.makeText(ak.getContext(), (CharSequence)"好了", 1).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI
 * JD-Core Version:    0.7.0.1
 */