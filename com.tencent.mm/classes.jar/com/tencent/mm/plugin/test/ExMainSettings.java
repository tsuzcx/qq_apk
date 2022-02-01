package com.tencent.mm.plugin.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/test/ExMainSettings;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getLayoutId", "", "initList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "printCrash", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "d", "startFlutterVideoEditorChoosePic", "Companion", "Info", "SimpleAdapter", "ViewHolder", "app_release"})
public final class ExMainSettings
  extends MMActivity
{
  public static final a FWV;
  private static final String TAG = "ExMainSettings";
  private RecyclerView hak;
  private final ArrayList<b> kgc;
  
  static
  {
    AppMethodBeat.i(163411);
    FWV = new a((byte)0);
    TAG = "ExMainSettings";
    AppMethodBeat.o(163411);
  }
  
  public ExMainSettings()
  {
    AppMethodBeat.i(163410);
    this.kgc = new ArrayList();
    AppMethodBeat.o(163410);
  }
  
  public final int getLayoutId()
  {
    return 2131495849;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(163409);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new k(this));
    this.kgc.add(new b("朋友圈", 2131690346, (View.OnClickListener)new e(this)));
    this.kgc.add(new b("视频动态", 2131689912, (View.OnClickListener)new f(this)));
    this.kgc.add(new b("Live", 2131691307, (View.OnClickListener)new g(this)));
    paramBundle = com.tencent.mm.cb.a.l((Context)getContext(), 2131690801);
    Object localObject = getContext();
    p.g(localObject, "context");
    paramBundle.setColorFilter((ColorFilter)new PorterDuffColorFilter(((AppCompatActivity)localObject).getResources().getColor(2131099793), PorterDuff.Mode.SRC_ATOP));
    this.kgc.add(new b("Finder", paramBundle, (View.OnClickListener)new h(this)));
    if (BuildInfo.DEBUG) {
      this.kgc.add(new b("moveXlog", null, (View.OnClickListener)new i(this)));
    }
    this.kgc.add(new b("VideoCompositionUI", null, (View.OnClickListener)new j(this)));
    this.hak = ((RecyclerView)findViewById(2131306533));
    paramBundle = new LinearLayoutManager();
    localObject = this.hak;
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
    }
    paramBundle = new c(this.kgc);
    localObject = this.hak;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle);
    }
    localObject = this.hak;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemViewCacheSize(0);
    }
    d.a(0L, (kotlin.g.a.a)new l(paramBundle));
    AppMethodBeat.o(163409);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/test/ExMainSettings$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "", "name", "", "resId", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;ILandroid/view/View$OnClickListener;)V", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;)V", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "getResId", "()Ljava/lang/Integer;", "setResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"})
  public static final class b
  {
    Integer FWW;
    Drawable drawable;
    View.OnClickListener ko;
    String name;
    
    public b(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163394);
      this.name = paramString;
      this.FWW = Integer.valueOf(paramInt);
      this.ko = paramOnClickListener;
      AppMethodBeat.o(163394);
    }
    
    public b(String paramString, Drawable paramDrawable, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163395);
      this.name = paramString;
      this.drawable = paramDrawable;
      this.ko = paramOnClickListener;
      AppMethodBeat.o(163395);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/test/ExMainSettings$SimpleAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "_holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"})
  public static final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private final ArrayList<ExMainSettings.b> dtS;
    
    public c(ArrayList<ExMainSettings.b> paramArrayList)
    {
      AppMethodBeat.i(163399);
      this.dtS = paramArrayList;
      AppMethodBeat.o(163399);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(163396);
      p.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496255, paramViewGroup, false);
      p.g(paramViewGroup, "LayoutInflater.from(pare…yout_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new ExMainSettings.d(paramViewGroup);
      AppMethodBeat.o(163396);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(163398);
      p.h(paramv, "_holder");
      Object localObject2 = (ExMainSettings.d)paramv;
      paramv = this.dtS.get(paramInt);
      p.g(paramv, "list[position]");
      ExMainSettings.b localb = (ExMainSettings.b)paramv;
      TextView localTextView = ((ExMainSettings.d)localObject2).gxs;
      if (localb != null) {}
      for (paramv = localb.name;; paramv = null)
      {
        localTextView.setText((CharSequence)paramv);
        if (localb != null)
        {
          paramv = localb.FWW;
          if (paramv != null)
          {
            paramInt = ((Number)paramv).intValue();
            ((ExMainSettings.d)localObject2).gBZ.setImageResource(paramInt);
          }
        }
        if (localb != null)
        {
          paramv = localb.drawable;
          if (paramv != null) {
            ((ExMainSettings.d)localObject2).gBZ.setImageDrawable(paramv);
          }
        }
        localObject2 = ((ExMainSettings.d)localObject2).sc;
        paramv = localObject1;
        if (localb != null) {
          paramv = localb.ko;
        }
        ((View)localObject2).setOnClickListener(paramv);
        AppMethodBeat.o(163398);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(163397);
      int i = this.dtS.size();
      AppMethodBeat.o(163397);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/test/ExMainSettings$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "setIconIv", "(Landroid/widget/ImageView;)V", "layout", "getLayout", "()Landroid/view/View;", "setLayout", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "setNameTv", "(Landroid/widget/TextView;)V", "app_release"})
  public static final class d
    extends RecyclerView.v
  {
    ImageView gBZ;
    TextView gxs;
    View sc;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(163400);
      View localView = paramView.findViewById(2131309860);
      p.g(localView, "itemView.findViewById(R.id.view_layout)");
      this.sc = localView;
      localView = paramView.findViewById(2131297890);
      p.g(localView, "itemView.findViewById(R.id.busi_icon)");
      this.gBZ = ((ImageView)localView);
      paramView = paramView.findViewById(2131305220);
      p.g(paramView, "itemView.findViewById(R.id.name_tv)");
      this.gxs = ((TextView)paramView);
      AppMethodBeat.o(163400);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/test/ExMainSettings$initList$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class e
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163401);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = new Intent((Context)this.FWX, Class.forName("com.tencent.mm.plugin.sns.ui.SnsSettingUI"));
      paramView = this.FWX;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163401);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/test/ExMainSettings$initList$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class f
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230898);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = new Intent((Context)this.FWX, Class.forName("com.tencent.mm.plugin.story.ui.StorySettingsUI"));
      paramView = this.FWX;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230898);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/test/ExMainSettings$initList$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class g
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163402);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = new Intent((Context)this.FWX, Class.forName("com.tencent.mm.live.ui.LiveUIG"));
      paramView = this.FWX;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163402);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/test/ExMainSettings$initList$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class h
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163403);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = new Intent((Context)this.FWX, Class.forName("com.tencent.mm.plugin.finder.ui.FinderSettingsUI"));
      paramView = this.FWX;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163403);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/test/ExMainSettings$initList$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230899);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.moveLogsFromCacheDirToLogDir();
      Toast.makeText((Context)this.FWX.getContext(), (CharSequence)"move success", 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230899);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/test/ExMainSettings$initList$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class j
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230900);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ExMainSettings.a(this.FWX);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230900);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(ExMainSettings paramExMainSettings) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(163404);
      this.FWX.finish();
      AppMethodBeat.o(163404);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(ExMainSettings.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.test.ExMainSettings
 * JD-Core Version:    0.7.0.1
 */