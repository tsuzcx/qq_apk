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
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import d.v;
import d.y;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"})
public final class StorySettingsUI
  extends MMActivity
{
  private static final String TAG = "MicroMsg.StorySettingUI";
  public static final StorySettingsUI.d zDH;
  private d fPa;
  private final LinkedList<e> gFp;
  private ListView gFr;
  private a zDE;
  private StoryCaptureProxy zDF;
  private p zDG;
  
  static
  {
    AppMethodBeat.i(119711);
    zDH = new StorySettingsUI.d((byte)0);
    TAG = "MicroMsg.StorySettingUI";
    AppMethodBeat.o(119711);
  }
  
  public StorySettingsUI()
  {
    AppMethodBeat.i(119710);
    this.fPa = new d(ai.getContext());
    this.gFp = new LinkedList();
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
      if (!bs.isNullOrNil(paramIntent)) {
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
    this.zDF = new StoryCaptureProxy(this.fPa);
    this.fPa.connect((Runnable)new aj(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new ak(this));
    AppMethodBeat.o(119706);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119707);
    super.onDestroy();
    this.fPa.release();
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(119659);
      int i = StorySettingsUI.c(this.zDI).size();
      AppMethodBeat.o(119659);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(119660);
      Object localObject = StorySettingsUI.c(this.zDI).get(paramInt);
      d.g.b.k.g(localObject, "selectsList[position]");
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
      d.g.b.k.h(paramViewGroup, "parent");
      paramView = new TextView((Context)this.zDI);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StorySettingsUI.ITestMenu");
        AppMethodBeat.o(119661);
        throw paramView;
      }
      paramViewGroup = (StorySettingsUI.e)paramViewGroup;
      paramView.setText((CharSequence)(paramViewGroup.abN() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(119661);
      return paramView;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(StorySettingsUI.e parame, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119658);
        this.zDJ.cx((View)paramView);
        AppMethodBeat.o(119658);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ab
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119697);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSU, Boolean.TRUE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSW, Boolean.TRUE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSV, Boolean.TRUE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSK, Boolean.FALSE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSJ, Integer.valueOf(0));
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSL, Boolean.FALSE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSM, Boolean.FALSE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSN, Boolean.FALSE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSO, Boolean.FALSE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSX, Boolean.TRUE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSY, Integer.valueOf(0));
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GTh, Boolean.TRUE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSP, Boolean.TRUE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GSQ, Boolean.TRUE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GWo, Integer.valueOf(0));
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GWq, Boolean.TRUE);
      paramView = g.agR();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.agA().set(ah.a.GWv, Integer.valueOf(0));
      t.makeText(ai.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(119697);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ad
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119698);
      af.dIa().removeAll();
      t.makeText(ai.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(119698);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ae
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119699);
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.dVs();
      AppMethodBeat.o(119699);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class af
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119700);
      paramView = com.tencent.mm.plugin.recordvideo.b.e.wps;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.wps;
      if (!com.tencent.mm.plugin.recordvideo.b.e.duU()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.pk(bool);
        AppMethodBeat.o(119700);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ag
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119701);
      paramView = com.tencent.mm.plugin.recordvideo.b.e.wps;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.wps;
      if (!com.tencent.mm.plugin.recordvideo.b.e.duV()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.pl(bool);
        AppMethodBeat.o(119701);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class aj
    implements Runnable
  {
    aj(StorySettingsUI paramStorySettingsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(119704);
      StorySettingsUI.d locald = StorySettingsUI.zDH;
      ac.i(StorySettingsUI.access$getTAG$cp(), "has connect");
      StorySettingsUI.d(this.zDI);
      AppMethodBeat.o(119704);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class ak
    implements MenuItem.OnMenuItemClickListener
  {
    ak(StorySettingsUI paramStorySettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119705);
      this.zDI.finish();
      AppMethodBeat.o(119705);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"})
  public final class b
    implements StorySettingsUI.e
  {
    private String gFw;
    ah.a gFx;
    private String[] gFy;
    Object gFz;
    
    public b(ah.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(119666);
      this.gFw = parama;
      this.gFx = paramArrayOfString;
      this.gFy = paramObject;
      this.gFz = localObject;
      AppMethodBeat.o(119666);
    }
    
    private final String dH(Object paramObject)
    {
      AppMethodBeat.i(119665);
      Object localObject = this.gFz;
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
        paramObject = this.gFz;
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
          paramObject = this.gFz;
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((l == ((long[])paramObject)[i]) && (i < this.gFy.length))
          {
            paramObject = this.gFy[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.gFy[0];
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
        paramObject = this.gFz;
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
          paramObject = this.gFz;
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type kotlin.IntArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((j == ((int[])paramObject)[i]) && (i < this.gFy.length))
          {
            paramObject = this.gFy[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.gFy[0];
        AppMethodBeat.o(119665);
        return paramObject;
      }
      AppMethodBeat.o(119665);
      return "";
    }
    
    public final String abN()
    {
      return this.gFw;
    }
    
    public final void cx(View paramView)
    {
      AppMethodBeat.i(119664);
      d.g.b.k.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.gFy.length;
      while (i < j)
      {
        paramView.add(this.gFy[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      com.tencent.mm.ui.base.h.a((Context)StorySettingsUI.this, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
      AppMethodBeat.o(119664);
    }
    
    public final String value()
    {
      AppMethodBeat.i(119663);
      if ((this.gFz instanceof long[]))
      {
        localObject = StorySettingsUI.a(StorySettingsUI.this);
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        localObject = dH(((StoryCaptureProxy)localObject).get(this.gFx, Long.valueOf(0L)));
        AppMethodBeat.o(119663);
        return localObject;
      }
      Object localObject = StorySettingsUI.a(StorySettingsUI.this);
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = dH(((StoryCaptureProxy)localObject).get(this.gFx, Integer.valueOf(0)));
      AppMethodBeat.o(119663);
      return localObject;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(StorySettingsUI.b paramb) {}
      
      public final void ct(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119662);
        Object localObject3;
        Object localObject4;
        try
        {
          Object localObject1 = this.zDK.gFz;
          if (!(localObject1 instanceof long[])) {
            break label141;
          }
          localObject1 = StorySettingsUI.a(this.zDK.zDI);
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          localObject3 = this.zDK.gFx;
          localObject4 = this.zDK.gFz;
          if (localObject4 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119662);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          localObject3 = StorySettingsUI.zDH;
          ac.printErrStackTrace(StorySettingsUI.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(119662);
          return;
        }
        localException.set((ah.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
        for (;;)
        {
          StorySettingsUI.b(this.zDK.zDI).notifyDataSetChanged();
          AppMethodBeat.o(119662);
          return;
          label141:
          if ((localException instanceof int[]))
          {
            Object localObject2 = StorySettingsUI.a(this.zDK.zDI);
            if (localObject2 == null) {
              d.g.b.k.fOy();
            }
            localObject3 = this.zDK.gFx;
            localObject4 = this.zDK.gFz;
            if (localObject4 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(119662);
              throw ((Throwable)localObject2);
            }
            ((StoryCaptureProxy)localObject2).set((ah.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
          }
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-story_release"})
  public static abstract interface e
  {
    public abstract String abN();
    
    public abstract void cx(View paramView);
    
    public abstract String value();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119674);
      paramView = j.zsh;
      j.b.dVI().duq();
      paramView = j.zsh;
      j.b.dVG().duq();
      paramView = j.zsh;
      j.b.dVE().duq();
      paramView = j.zsh;
      com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
      AppMethodBeat.o(119674);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class j
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119675);
      paramView = com.tencent.mm.plugin.story.f.f.a.zvn;
      com.tencent.mm.plugin.story.f.f.a.dWD();
      c.a(5000L, (d.g.a.a)a.zDL);
      AppMethodBeat.o(119675);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      public static final a zDL;
      
      static
      {
        AppMethodBeat.i(178044);
        zDL = new a();
        AppMethodBeat.o(178044);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class k
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119676);
      paramView = j.zsh;
      j.yi(0L);
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.dVt();
      com.tencent.mm.plugin.story.f.f.a.zvn.init();
      AppMethodBeat.o(119676);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class l
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119677);
      paramView = com.tencent.mm.plugin.story.f.l.zsu;
      paramView = com.tencent.mm.plugin.story.f.l.cDx();
      com.tencent.mm.ui.base.h.Q((Context)this.zDI.getContext(), paramView, "嗯");
      AppMethodBeat.o(119677);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class m
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119681);
      paramView = j.zsh;
      com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
      com.tencent.mm.ui.base.h.Q((Context)this.zDI.getContext(), "ok", "嗯");
      AppMethodBeat.o(119681);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class n
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119682);
      paramView = this.zDI;
      Context localContext = (Context)this.zDI.getContext();
      this.zDI.getString(2131755906);
      StorySettingsUI.a(paramView, com.tencent.mm.ui.base.h.b(localContext, this.zDI.getString(2131755936), true, (DialogInterface.OnCancelListener)new a(this)));
      c.b("cpfiles", (d.g.a.a)new b(this));
      AppMethodBeat.o(119682);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      a(StorySettingsUI.n paramn) {}
      
      public final void onCancel(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(178045);
        this.zDM.zDI.finish();
        AppMethodBeat.o(178045);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(StorySettingsUI.n paramn)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class q
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119685);
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.dVu();
      AppMethodBeat.o(119685);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class v
    implements View.OnClickListener
  {
    v(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119693);
      ay.yOJ = 1;
      com.tencent.mm.ui.base.h.Q((Context)this.zDI.getContext(), "已调整到套图下载，即刻生效！", "");
      AppMethodBeat.o(119693);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119694);
      ay.yOJ = 2;
      com.tencent.mm.ui.base.h.Q((Context)this.zDI.getContext(), "已调整到单图下载，即刻生效！", "");
      AppMethodBeat.o(119694);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119695);
      switch (ay.yOJ)
      {
      default: 
        if (ay.dPX())
        {
          com.tencent.mm.ui.base.h.Q((Context)this.zDI.getContext(), "套图下载", "");
          AppMethodBeat.o(119695);
          return;
        }
        break;
      case 1: 
        com.tencent.mm.ui.base.h.Q((Context)this.zDI.getContext(), "套图下载", "");
        AppMethodBeat.o(119695);
        return;
      case 2: 
        com.tencent.mm.ui.base.h.Q((Context)this.zDI.getContext(), "单图下载", "");
        AppMethodBeat.o(119695);
        return;
      }
      com.tencent.mm.ui.base.h.Q((Context)this.zDI.getContext(), "单图下载", "");
      AppMethodBeat.o(119695);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class y
    implements View.OnClickListener
  {
    y(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119696);
      paramView = com.tencent.mm.plugin.story.f.i.zrK;
      com.tencent.mm.plugin.story.f.i.dVw();
      com.tencent.mm.ui.base.h.Q((Context)this.zDI.getContext(), "ok！", "");
      AppMethodBeat.o(119696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI
 * JD-Core Version:    0.7.0.1
 */