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
import com.tencent.mm.ad.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import d.v;
import d.y;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"})
public final class StorySettingsUI
  extends MMActivity
{
  private static final String TAG = "MicroMsg.StorySettingUI";
  public static final d yqj;
  private com.tencent.mm.remoteservice.d fLo;
  private ListView izP;
  private final LinkedList<e> qPR;
  private a yqg;
  private StoryCaptureProxy yqh;
  private p yqi;
  
  static
  {
    AppMethodBeat.i(119711);
    yqj = new d((byte)0);
    TAG = "MicroMsg.StorySettingUI";
    AppMethodBeat.o(119711);
  }
  
  public StorySettingsUI()
  {
    AppMethodBeat.i(119710);
    this.fLo = new com.tencent.mm.remoteservice.d(aj.getContext());
    this.qPR = new LinkedList();
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
    this.yqh = new StoryCaptureProxy(this.fLo);
    this.fLo.connect((Runnable)new aj(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new ak(this));
    AppMethodBeat.o(119706);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119707);
    super.onDestroy();
    this.fLo.release();
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(119659);
      int i = StorySettingsUI.c(this.yqk).size();
      AppMethodBeat.o(119659);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(119660);
      Object localObject = StorySettingsUI.c(this.yqk).get(paramInt);
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
      paramView = new TextView((Context)this.yqk);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StorySettingsUI.ITestMenu");
        AppMethodBeat.o(119661);
        throw paramView;
      }
      paramViewGroup = (StorySettingsUI.e)paramViewGroup;
      paramView.setText((CharSequence)(paramViewGroup.aaO() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(119661);
      return paramView;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(StorySettingsUI.e parame, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119658);
        this.yql.dT((View)paramView);
        AppMethodBeat.o(119658);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aa
    implements View.OnClickListener
  {
    aa(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178050);
      try
      {
        paramView = this.yqk.getContext();
        d.g.b.k.g(paramView, "context");
        paramView = paramView.getExternalCacheDir().toString();
        com.tencent.mm.vfs.i.deleteDir(paramView + "/imgcache");
        AppMethodBeat.o(178050);
        return;
      }
      catch (Exception paramView)
      {
        AppMethodBeat.o(178050);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ab
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119697);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fva, Boolean.TRUE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fvc, Boolean.TRUE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fvb, Boolean.TRUE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FuQ, Boolean.FALSE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FuP, Integer.valueOf(0));
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FuR, Boolean.FALSE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FuS, Boolean.FALSE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FuT, Boolean.FALSE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FuU, Boolean.FALSE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fvd, Boolean.TRUE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fve, Integer.valueOf(0));
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fvn, Boolean.TRUE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FuV, Boolean.TRUE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FuW, Boolean.TRUE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fxu, Integer.valueOf(0));
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.Fxw, Boolean.TRUE);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FxB, Integer.valueOf(0));
      t.makeText(aj.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(119697);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ac
    implements View.OnClickListener
  {
    ac(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178051);
      paramView = new Intent();
      paramView.putExtra("KEY_EDITABLE", true);
      paramView.putExtra("KEY_CONTENT_XML", this.yqk.getSharedPreferences("test_plugin", 0).getString("content", ""));
      com.tencent.mm.bs.d.b((Context)this.yqk.getContext(), "editor", ".EditorUI", paramView, 4096);
      AppMethodBeat.o(178051);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ad
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119698);
      af.dtD().removeAll();
      t.makeText(aj.getContext(), (CharSequence)"好了", 1).show();
      AppMethodBeat.o(119698);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ae
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119699);
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.dGR();
      AppMethodBeat.o(119699);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class af
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119700);
      paramView = com.tencent.mm.plugin.recordvideo.b.e.vgG;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.vgG;
      if (!com.tencent.mm.plugin.recordvideo.b.e.dho()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.oq(bool);
        AppMethodBeat.o(119700);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class ag
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119701);
      paramView = com.tencent.mm.plugin.recordvideo.b.e.vgG;
      paramView = com.tencent.mm.plugin.recordvideo.b.e.vgG;
      if (!com.tencent.mm.plugin.recordvideo.b.e.dhp()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.plugin.recordvideo.b.e.or(bool);
        AppMethodBeat.o(119701);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class aj
    implements Runnable
  {
    aj(StorySettingsUI paramStorySettingsUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(119704);
      StorySettingsUI.d locald = StorySettingsUI.yqj;
      ad.i(StorySettingsUI.access$getTAG$cp(), "has connect");
      StorySettingsUI.d(this.yqk);
      AppMethodBeat.o(119704);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class ak
    implements MenuItem.OnMenuItemClickListener
  {
    ak(StorySettingsUI paramStorySettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119705);
      this.yqk.finish();
      AppMethodBeat.o(119705);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"})
  public final class b
    implements StorySettingsUI.e
  {
    private String qPW;
    ae.a qPX;
    private String[] qPY;
    Object qPZ;
    
    public b(ae.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(119666);
      this.qPW = parama;
      this.qPX = paramArrayOfString;
      this.qPY = paramObject;
      this.qPZ = localObject;
      AppMethodBeat.o(119666);
    }
    
    private final String dG(Object paramObject)
    {
      AppMethodBeat.i(119665);
      Object localObject = this.qPZ;
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
        paramObject = this.qPZ;
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
          paramObject = this.qPZ;
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((l == ((long[])paramObject)[i]) && (i < this.qPY.length))
          {
            paramObject = this.qPY[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.qPY[0];
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
        paramObject = this.qPZ;
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
          paramObject = this.qPZ;
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type kotlin.IntArray");
            AppMethodBeat.o(119665);
            throw paramObject;
          }
          if ((j == ((int[])paramObject)[i]) && (i < this.qPY.length))
          {
            paramObject = this.qPY[i];
            AppMethodBeat.o(119665);
            return paramObject;
          }
          i += 1;
        }
        paramObject = this.qPY[0];
        AppMethodBeat.o(119665);
        return paramObject;
      }
      AppMethodBeat.o(119665);
      return "";
    }
    
    public final String aaO()
    {
      return this.qPW;
    }
    
    public final void dT(View paramView)
    {
      AppMethodBeat.i(119664);
      d.g.b.k.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.qPY.length;
      while (i < j)
      {
        paramView.add(this.qPY[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      com.tencent.mm.ui.base.h.a((Context)StorySettingsUI.this, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
      AppMethodBeat.o(119664);
    }
    
    public final String value()
    {
      AppMethodBeat.i(119663);
      if ((this.qPZ instanceof long[]))
      {
        localObject = StorySettingsUI.a(StorySettingsUI.this);
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        localObject = dG(((StoryCaptureProxy)localObject).get(this.qPX, Long.valueOf(0L)));
        AppMethodBeat.o(119663);
        return localObject;
      }
      Object localObject = StorySettingsUI.a(StorySettingsUI.this);
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = dG(((StoryCaptureProxy)localObject).get(this.qPX, Integer.valueOf(0)));
      AppMethodBeat.o(119663);
      return localObject;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
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
          Object localObject1 = this.yqm.qPZ;
          if (!(localObject1 instanceof long[])) {
            break label141;
          }
          localObject1 = StorySettingsUI.a(this.yqm.yqk);
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          localObject3 = this.yqm.qPX;
          localObject4 = this.yqm.qPZ;
          if (localObject4 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(119662);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          localObject3 = StorySettingsUI.yqj;
          ad.printErrStackTrace(StorySettingsUI.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(119662);
          return;
        }
        localException.set((ae.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
        for (;;)
        {
          StorySettingsUI.b(this.yqm.yqk).notifyDataSetChanged();
          AppMethodBeat.o(119662);
          return;
          label141:
          if ((localException instanceof int[]))
          {
            Object localObject2 = StorySettingsUI.a(this.yqm.yqk);
            if (localObject2 == null) {
              d.g.b.k.fvU();
            }
            localObject3 = this.yqm.qPX;
            localObject4 = this.yqm.qPZ;
            if (localObject4 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(119662);
              throw ((Throwable)localObject2);
            }
            ((StoryCaptureProxy)localObject2).set((ae.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
          }
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class d {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-story_release"})
  public static abstract interface e
  {
    public abstract String aaO();
    
    public abstract void dT(View paramView);
    
    public abstract String value();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119674);
      paramView = j.yfh;
      j.b.dHh().dgI();
      paramView = j.yfh;
      j.b.dHf().dgI();
      paramView = j.yfh;
      j.b.dHd().dgI();
      paramView = j.yfh;
      com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
      AppMethodBeat.o(119674);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class j
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119675);
      paramView = com.tencent.mm.plugin.story.f.f.a.yio;
      com.tencent.mm.plugin.story.f.f.a.dIc();
      c.a(5000L, (d.g.a.a)a.yqn);
      AppMethodBeat.o(119675);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      public static final a yqn;
      
      static
      {
        AppMethodBeat.i(178044);
        yqn = new a();
        AppMethodBeat.o(178044);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class k
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119676);
      paramView = j.yfh;
      j.tF(0L);
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.dGS();
      com.tencent.mm.plugin.story.f.f.a.yio.init();
      AppMethodBeat.o(119676);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class l
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119677);
      paramView = com.tencent.mm.plugin.story.f.l.yfu;
      paramView = com.tencent.mm.plugin.story.f.l.cse();
      com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), paramView, "嗯");
      AppMethodBeat.o(119677);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class m
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119681);
      paramView = j.yfh;
      com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
      com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "ok", "嗯");
      AppMethodBeat.o(119681);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class n
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119682);
      paramView = this.yqk;
      Context localContext = (Context)this.yqk.getContext();
      this.yqk.getString(2131755906);
      StorySettingsUI.a(paramView, com.tencent.mm.ui.base.h.b(localContext, this.yqk.getString(2131755936), true, (DialogInterface.OnCancelListener)new a(this)));
      c.b("cpfiles", (d.g.a.a)new b(this));
      AppMethodBeat.o(119682);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      a(StorySettingsUI.n paramn) {}
      
      public final void onCancel(DialogInterface paramDialogInterface)
      {
        AppMethodBeat.i(178045);
        this.yqo.yqk.finish();
        AppMethodBeat.o(178045);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class o
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119683);
      if (!com.tencent.mm.platformtools.ab.hWI) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.platformtools.ab.hWI = bool;
        com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "ok value Test Fail:" + com.tencent.mm.platformtools.ab.hWI, "嗯");
        AppMethodBeat.o(119683);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$19", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class p
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119684);
      if (!com.tencent.mm.platformtools.ab.hWJ) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.platformtools.ab.hWJ = bool;
        com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "ok value Test Fail:" + com.tencent.mm.platformtools.ab.hWJ, "嗯");
        AppMethodBeat.o(119684);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
  public static final class q
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119685);
      new com.tencent.mm.plugin.story.f.h();
      com.tencent.mm.plugin.story.f.h.dGT();
      AppMethodBeat.o(119685);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119686);
      paramView = g.afB();
      d.g.b.k.g(paramView, "MMKernel.storage()");
      paramView.afk().set(ae.a.FuQ, Boolean.FALSE);
      com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "在群视频，不要上滑，静候5秒", "");
      AppMethodBeat.o(119686);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class v
    implements View.OnClickListener
  {
    v(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119693);
      ay.xBV = 1;
      com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "已调整到套图下载，即刻生效！", "");
      AppMethodBeat.o(119693);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119694);
      ay.xBV = 2;
      com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "已调整到单图下载，即刻生效！", "");
      AppMethodBeat.o(119694);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119695);
      switch (ay.xBV)
      {
      default: 
        if (ay.dBA())
        {
          com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "套图下载", "");
          AppMethodBeat.o(119695);
          return;
        }
        break;
      case 1: 
        com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "套图下载", "");
        AppMethodBeat.o(119695);
        return;
      case 2: 
        com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "单图下载", "");
        AppMethodBeat.o(119695);
        return;
      }
      com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "单图下载", "");
      AppMethodBeat.o(119695);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class y
    implements View.OnClickListener
  {
    y(StorySettingsUI paramStorySettingsUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119696);
      paramView = com.tencent.mm.plugin.story.f.i.yeK;
      com.tencent.mm.plugin.story.f.i.dGV();
      com.tencent.mm.ui.base.h.R((Context)this.yqk.getContext(), "ok！", "");
      AppMethodBeat.o(119696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI
 * JD-Core Version:    0.7.0.1
 */