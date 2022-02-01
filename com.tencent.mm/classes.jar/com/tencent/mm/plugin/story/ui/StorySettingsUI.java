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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"})
public final class StorySettingsUI
  extends MMActivity
{
  public static final d Fxu;
  private static final String TAG = "MicroMsg.StorySettingUI";
  private a Fxr;
  private StoryCaptureProxy Fxs;
  private com.tencent.mm.ui.base.q Fxt;
  private com.tencent.mm.remoteservice.d gVN;
  private final LinkedList<e> hUG;
  private ListView hUI;
  
  static
  {
    AppMethodBeat.i(119711);
    Fxu = new d((byte)0);
    TAG = "MicroMsg.StorySettingUI";
    AppMethodBeat.o(119711);
  }
  
  public StorySettingsUI()
  {
    AppMethodBeat.i(119710);
    this.gVN = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    this.hUG = new LinkedList();
    AppMethodBeat.o(119710);
  }
  
  public final int getLayoutId()
  {
    return 2131496624;
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
      if (!Util.isNullOrNil(paramIntent)) {
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
    this.Fxs = new StoryCaptureProxy(this.gVN);
    this.gVN.connect((Runnable)new ah(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new ai(this));
    AppMethodBeat.o(119706);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119707);
    super.onDestroy();
    this.gVN.release();
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(119659);
      int i = StorySettingsUI.c(this.Fxv).size();
      AppMethodBeat.o(119659);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(119660);
      Object localObject = StorySettingsUI.c(this.Fxv).get(paramInt);
      p.g(localObject, "selectsList[position]");
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
      p.h(paramViewGroup, "parent");
      paramView = new TextView((Context)this.Fxv);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StorySettingsUI.ITestMenu");
        AppMethodBeat.o(119661);
        throw paramView;
      }
      paramViewGroup = (StorySettingsUI.e)paramViewGroup;
      paramView.setText((CharSequence)(paramViewGroup.auk() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(119661);
      return paramView;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(StorySettingsUI.e parame, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119658);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.Fxw.cp((View)paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119658);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class aa
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119697);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OiF, Boolean.TRUE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OiH, Boolean.TRUE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OiG, Boolean.TRUE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiv, Boolean.FALSE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiu, Integer.valueOf(0));
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiw, Boolean.FALSE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oix, Boolean.FALSE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiy, Boolean.FALSE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiz, Boolean.FALSE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OiI, Boolean.TRUE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OiJ, Integer.valueOf(0));
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OiS, Boolean.TRUE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OiA, Boolean.TRUE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OiB, Boolean.TRUE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Ony, Integer.valueOf(0));
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OnA, Boolean.TRUE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OnF, Integer.valueOf(0));
      u.makeText(MMApplicationContext.getContext(), (CharSequence)"好了", 1).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119697);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ab
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119698);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.fnQ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119698);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ac
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119699);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.recordvideo.b.e.BNm;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.BNm;
      if (!com.tencent.mm.plugin.recordvideo.b.e.eJt()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.ta(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119699);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ad
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119700);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.recordvideo.b.e.BNm;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.BNm;
      if (!com.tencent.mm.plugin.recordvideo.b.e.eJu()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.tb(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119700);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ae
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119701);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!com.tencent.mm.plugin.story.c.c.BNK) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.story.c.c.BNK = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119701);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class af
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119702);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      com.tencent.mm.plugin.story.c.c.Kh(100000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119702);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ag
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119703);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      com.tencent.mm.plugin.story.c.c.fnt();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119703);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ah
    implements Runnable
  {
    ah(StorySettingsUI paramStorySettingsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(119704);
      StorySettingsUI.d locald = StorySettingsUI.Fxu;
      Log.i(StorySettingsUI.access$getTAG$cp(), "has connect");
      StorySettingsUI.d(this.Fxv);
      AppMethodBeat.o(119704);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class ai
    implements MenuItem.OnMenuItemClickListener
  {
    ai(StorySettingsUI paramStorySettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119705);
      this.Fxv.finish();
      AppMethodBeat.o(119705);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"})
  public final class b
    implements StorySettingsUI.e
  {
    private String hUN;
    ar.a hUO;
    private String[] hUP;
    Object hUQ;
    
    public b(ar.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(119666);
      this.hUN = parama;
      this.hUO = paramArrayOfString;
      this.hUP = paramObject;
      this.hUQ = localObject;
      AppMethodBeat.o(119666);
    }
    
    private final String dU(Object paramObject)
    {
      AppMethodBeat.i(119665);
      Object localObject = this.hUQ;
      int j;
      int i;
      if ((localObject instanceof long[]))
      {
        if (paramObject == null)
        {
          paramObject = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(119665);
          throw paramObject;
        }
        long l = ((Long)paramObject).longValue();
        paramObject = this.hUQ;
        if (paramObject == null)
        {
          paramObject = new t("null cannot be cast to non-null type kotlin.LongArray");
          AppMethodBeat.o(119665);
          throw paramObject;
        }
        j = ((long[])paramObject).length;
        i = 0;
        while (i < j)
        {
          paramObject = this.hUQ;
          if (paramObject == null)
          {
            paramObject = new t("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((l == ((long[])paramObject)[i]) && (i < this.hUP.length))
          {
            paramObject = this.hUP[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.hUP[0];
        AppMethodBeat.o(119665);
        return paramObject;
      }
      if ((localObject instanceof int[]))
      {
        if (paramObject == null)
        {
          paramObject = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(119665);
          throw paramObject;
        }
        j = ((Integer)paramObject).intValue();
        paramObject = this.hUQ;
        if (paramObject == null)
        {
          paramObject = new t("null cannot be cast to non-null type kotlin.IntArray");
          AppMethodBeat.o(119665);
          throw paramObject;
        }
        int k = ((int[])paramObject).length;
        i = 0;
        while (i < k)
        {
          paramObject = this.hUQ;
          if (paramObject == null)
          {
            paramObject = new t("null cannot be cast to non-null type kotlin.IntArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((j == ((int[])paramObject)[i]) && (i < this.hUP.length))
          {
            paramObject = this.hUP[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.hUP[0];
        AppMethodBeat.o(119665);
        return paramObject;
      }
      AppMethodBeat.o(119665);
      return "";
    }
    
    public final String auk()
    {
      return this.hUN;
    }
    
    public final void cp(View paramView)
    {
      AppMethodBeat.i(119664);
      p.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.hUP.length;
      while (i < j)
      {
        paramView.add(this.hUP[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      com.tencent.mm.ui.base.h.a((Context)StorySettingsUI.this, "", (List)paramView, (List)localLinkedList, "", (h.e)new a(this));
      AppMethodBeat.o(119664);
    }
    
    public final String value()
    {
      AppMethodBeat.i(119663);
      if ((this.hUQ instanceof long[]))
      {
        localObject = StorySettingsUI.a(StorySettingsUI.this);
        if (localObject == null) {
          p.hyc();
        }
        localObject = dU(((StoryCaptureProxy)localObject).get(this.hUO, Long.valueOf(0L)));
        AppMethodBeat.o(119663);
        return localObject;
      }
      Object localObject = StorySettingsUI.a(StorySettingsUI.this);
      if (localObject == null) {
        p.hyc();
      }
      localObject = dU(((StoryCaptureProxy)localObject).get(this.hUO, Integer.valueOf(0)));
      AppMethodBeat.o(119663);
      return localObject;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.e
    {
      a(StorySettingsUI.b paramb) {}
      
      public final void cy(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119662);
        Object localObject3;
        Object localObject4;
        try
        {
          Object localObject1 = this.Fxx.hUQ;
          if (!(localObject1 instanceof long[])) {
            break label141;
          }
          localObject1 = StorySettingsUI.a(this.Fxx.Fxv);
          if (localObject1 == null) {
            p.hyc();
          }
          localObject3 = this.Fxx.hUO;
          localObject4 = this.Fxx.hUQ;
          if (localObject4 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119662);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          localObject3 = StorySettingsUI.Fxu;
          Log.printErrStackTrace(StorySettingsUI.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(119662);
          return;
        }
        localException.set((ar.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
        for (;;)
        {
          StorySettingsUI.b(this.Fxx.Fxv).notifyDataSetChanged();
          AppMethodBeat.o(119662);
          return;
          label141:
          if ((localException instanceof int[]))
          {
            Object localObject2 = StorySettingsUI.a(this.Fxx.Fxv);
            if (localObject2 == null) {
              p.hyc();
            }
            localObject3 = this.Fxx.hUO;
            localObject4 = this.Fxx.hUQ;
            if (localObject4 == null)
            {
              localObject2 = new t("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(119662);
              throw ((Throwable)localObject2);
            }
            ((StoryCaptureProxy)localObject2).set((ar.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ClickItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "getValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-story_release"})
  public static final class c
    implements StorySettingsUI.e
  {
    private final View.OnClickListener EJh;
    private final String title;
    private final String value;
    
    public c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(119668);
      this.title = paramString1;
      this.value = paramString2;
      this.EJh = paramOnClickListener;
      AppMethodBeat.o(119668);
    }
    
    public final String auk()
    {
      return this.title;
    }
    
    public final void cp(View paramView)
    {
      AppMethodBeat.i(119667);
      p.h(paramView, "view");
      this.EJh.onClick(paramView);
      u.makeText(MMApplicationContext.getContext(), (CharSequence)"ClickItem Done", 1).show();
      AppMethodBeat.o(119667);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class d {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-story_release"})
  public static abstract interface e
  {
    public abstract String auk();
    
    public abstract void cp(View paramView);
    
    public abstract String value();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class f
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119669);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = new Intent((Context)this.Fxv, Class.forName("com.tencent.mm.plugin.ui.SampleListUI"));
      paramView = this.Fxv;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119669);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class g
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119670);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      com.tencent.mm.plugin.story.c.c.Kh(10000L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119670);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119674);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.story.f.f.a.FpB;
      com.tencent.mm.plugin.story.f.f.a.fpb();
      com.tencent.mm.ac.d.a(5000L, (kotlin.g.a.a)a.Fxy);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119674);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      public static final a Fxy;
      
      static
      {
        AppMethodBeat.i(119673);
        Fxy = new a();
        AppMethodBeat.o(119673);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class j
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119675);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = j.Fmy;
      j.Kj(0L);
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.fnR();
      com.tencent.mm.plugin.story.f.f.a.FpB.init();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119675);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class k
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119676);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.story.f.l.FmK;
      paramView = com.tencent.mm.plugin.story.f.l.fot();
      com.tencent.mm.ui.base.h.X((Context)this.Fxv.getContext(), paramView, "嗯");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119676);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class l
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119677);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = j.Fmy;
      s.deleteDir(j.b.getAccStoryCachePath());
      com.tencent.mm.ui.base.h.X((Context)this.Fxv.getContext(), "ok", "嗯");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119677);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class m
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119681);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.Fxv;
      localObject = (Context)this.Fxv.getContext();
      this.Fxv.getString(2131755998);
      StorySettingsUI.a(paramView, com.tencent.mm.ui.base.h.a((Context)localObject, this.Fxv.getString(2131756029), true, (DialogInterface.OnCancelListener)new a(this)));
      com.tencent.mm.ac.d.b("cpfiles", (kotlin.g.a.a)new b(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119681);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      a(StorySettingsUI.m paramm) {}
      
      public final void onCancel(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(119678);
        this.Fxz.Fxv.finish();
        AppMethodBeat.o(119678);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(StorySettingsUI.m paramm)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class n
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119682);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!ac.jPI) {}
      for (boolean bool = true;; bool = false)
      {
        ac.jPI = bool;
        com.tencent.mm.ui.base.h.X((Context)this.Fxv.getContext(), "ok value Test Fail:" + ac.jPI, "嗯");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119682);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class o
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119683);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!ac.jPJ) {}
      for (boolean bool = true;; bool = false)
      {
        ac.jPJ = bool;
        com.tencent.mm.ui.base.h.X((Context)this.Fxv.getContext(), "ok value Test Fail:" + ac.jPJ, "嗯");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119683);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119684);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiv, Boolean.FALSE);
      com.tencent.mm.ui.base.h.X((Context)this.Fxv.getContext(), "在群视频，不要上滑，静候5秒", "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119684);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class q
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119685);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.fnS();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119685);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    public static final r FxB;
    
    static
    {
      AppMethodBeat.i(119687);
      FxB = new r();
      AppMethodBeat.o(119687);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119686);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiu, Integer.valueOf(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119686);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    public static final s FxC;
    
    static
    {
      AppMethodBeat.i(119689);
      FxC = new s();
      AppMethodBeat.o(119689);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119688);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiw, Boolean.FALSE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119688);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    public static final t FxD;
    
    static
    {
      AppMethodBeat.i(119691);
      FxD = new t();
      AppMethodBeat.o(119691);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119690);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiy, Boolean.FALSE);
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Oiz, Boolean.FALSE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119690);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class u
    implements View.OnClickListener
  {
    u(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119692);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = i.Fmb;
      i.fnU();
      com.tencent.mm.ui.base.h.X((Context)this.Fxv.getContext(), "ok！", "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119692);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class v
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119693);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.OiO, Long.valueOf(0L));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119693);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119694);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      try
      {
        paramView = this.Fxv.getContext();
        p.g(paramView, "context");
        paramView = String.valueOf(paramView.getExternalCacheDir());
        s.deleteDir(paramView + "/imgcache");
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119695);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = new Intent();
      paramView.putExtra("KEY_EDITABLE", true);
      paramView.putExtra("KEY_CONTENT_XML", this.Fxv.getSharedPreferences("test_plugin", 0).getString("content", ""));
      com.tencent.mm.br.c.b((Context)this.Fxv.getContext(), "editor", ".EditorUI", paramView, 4096);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119695);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class y
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119696);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = g.aAh();
      p.g(paramView, "MMKernel.storage()");
      paramView.azQ().set(ar.a.Ood, Integer.valueOf(0));
      u.makeText(MMApplicationContext.getContext(), (CharSequence)"好了", 1).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119696);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class z
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178049);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      com.tencent.mm.plugin.t.a.c.eBv().gL((Context)this.Fxv.getContext());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI
 * JD-Core Version:    0.7.0.1
 */