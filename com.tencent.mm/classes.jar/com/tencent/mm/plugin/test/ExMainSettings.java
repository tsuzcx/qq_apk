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
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.ac.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/test/ExMainSettings;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getLayoutId", "", "initList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "printCrash", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "d", "Companion", "Info", "SimpleAdapter", "ViewHolder", "app_release"})
public final class ExMainSettings
  extends MMActivity
{
  public static final a BHd;
  private static final String TAG = "ExMainSettings";
  private RecyclerView gpr;
  private final ArrayList<b> jhZ;
  
  static
  {
    AppMethodBeat.i(163411);
    BHd = new a((byte)0);
    TAG = "ExMainSettings";
    AppMethodBeat.o(163411);
  }
  
  public ExMainSettings()
  {
    AppMethodBeat.i(163410);
    this.jhZ = new ArrayList();
    AppMethodBeat.o(163410);
  }
  
  public final int getLayoutId()
  {
    return 2131495018;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(163409);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new j(this));
    this.jhZ.add(new b("朋友圈", 2131690250, (View.OnClickListener)new e(this)));
    this.jhZ.add(new b("视频动态", 2131689897, (View.OnClickListener)new f(this)));
    this.jhZ.add(new b("Live", 2131691550, (View.OnClickListener)new g(this)));
    paramBundle = com.tencent.mm.cb.a.l((Context)getContext(), 2131690572);
    Object localObject = getContext();
    p.g(localObject, "context");
    paramBundle.setColorFilter((ColorFilter)new PorterDuffColorFilter(((AppCompatActivity)localObject).getResources().getColor(2131099778), PorterDuff.Mode.SRC_ATOP));
    this.jhZ.add(new b("Finder", paramBundle, (View.OnClickListener)new h(this)));
    if (j.DEBUG) {
      this.jhZ.add(new b("moveXlog", null, (View.OnClickListener)new i(this)));
    }
    this.gpr = ((RecyclerView)findViewById(2131303744));
    paramBundle = new LinearLayoutManager();
    localObject = this.gpr;
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    }
    paramBundle = new c(this.jhZ);
    localObject = this.gpr;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle);
    }
    localObject = this.gpr;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemViewCacheSize(0);
    }
    c.a(0L, (d.g.a.a)new k(paramBundle));
    AppMethodBeat.o(163409);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/test/ExMainSettings$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "", "name", "", "resId", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;ILandroid/view/View$OnClickListener;)V", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;)V", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "getResId", "()Ljava/lang/Integer;", "setResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"})
  public static final class b
  {
    Integer BHe;
    Drawable drawable;
    View.OnClickListener km;
    String name;
    
    public b(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163394);
      this.name = paramString;
      this.BHe = Integer.valueOf(paramInt);
      this.km = paramOnClickListener;
      AppMethodBeat.o(163394);
    }
    
    public b(String paramString, Drawable paramDrawable, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163395);
      this.name = paramString;
      this.drawable = paramDrawable;
      this.km = paramOnClickListener;
      AppMethodBeat.o(163395);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/test/ExMainSettings$SimpleAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "_holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"})
  public static final class c
    extends RecyclerView.a<RecyclerView.w>
  {
    private final ArrayList<ExMainSettings.b> ddb;
    
    public c(ArrayList<ExMainSettings.b> paramArrayList)
    {
      AppMethodBeat.i(163399);
      this.ddb = paramArrayList;
      AppMethodBeat.o(163399);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(163396);
      p.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495394, paramViewGroup, false);
      p.g(paramViewGroup, "LayoutInflater.from(pare…yout_item, parent, false)");
      paramViewGroup = (RecyclerView.w)new ExMainSettings.d(paramViewGroup);
      AppMethodBeat.o(163396);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(163398);
      p.h(paramw, "_holder");
      Object localObject2 = (ExMainSettings.d)paramw;
      paramw = this.ddb.get(paramInt);
      p.g(paramw, "list[position]");
      ExMainSettings.b localb = (ExMainSettings.b)paramw;
      TextView localTextView = ((ExMainSettings.d)localObject2).fSj;
      if (localb != null) {}
      for (paramw = localb.name;; paramw = null)
      {
        localTextView.setText((CharSequence)paramw);
        if (localb != null)
        {
          paramw = localb.BHe;
          if (paramw != null)
          {
            paramInt = ((Number)paramw).intValue();
            ((ExMainSettings.d)localObject2).fWT.setImageResource(paramInt);
          }
        }
        if (localb != null)
        {
          paramw = localb.drawable;
          if (paramw != null) {
            ((ExMainSettings.d)localObject2).fWT.setImageDrawable(paramw);
          }
        }
        localObject2 = ((ExMainSettings.d)localObject2).rY;
        paramw = localObject1;
        if (localb != null) {
          paramw = localb.km;
        }
        ((View)localObject2).setOnClickListener(paramw);
        AppMethodBeat.o(163398);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(163397);
      int i = this.ddb.size();
      AppMethodBeat.o(163397);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/test/ExMainSettings$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "setIconIv", "(Landroid/widget/ImageView;)V", "layout", "getLayout", "()Landroid/view/View;", "setLayout", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "setNameTv", "(Landroid/widget/TextView;)V", "app_release"})
  public static final class d
    extends RecyclerView.w
  {
    TextView fSj;
    ImageView fWT;
    View rY;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(163400);
      View localView = paramView.findViewById(2131306428);
      p.g(localView, "itemView.findViewById(R.id.view_layout)");
      this.rY = localView;
      localView = paramView.findViewById(2131297628);
      p.g(localView, "itemView.findViewById(R.id.busi_icon)");
      this.fWT = ((ImageView)localView);
      paramView = paramView.findViewById(2131302666);
      p.g(paramView, "itemView.findViewById(R.id.name_tv)");
      this.fSj = ((TextView)paramView);
      AppMethodBeat.o(163400);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/test/ExMainSettings$initList$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class e
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163401);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = new Intent((Context)this.BHf, Class.forName("com.tencent.mm.plugin.sns.ui.SnsSettingUI"));
      paramView = this.BHf;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163401);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/test/ExMainSettings$initList$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class f
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(188258);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = new Intent((Context)this.BHf, Class.forName("com.tencent.mm.plugin.story.ui.StorySettingsUI"));
      paramView = this.BHf;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(188258);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/test/ExMainSettings$initList$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class g
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163402);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = new Intent((Context)this.BHf, Class.forName("com.tencent.mm.live.ui.LiveUIG"));
      paramView = this.BHf;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163402);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/test/ExMainSettings$initList$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class h
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163403);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = new Intent((Context)this.BHf, Class.forName("com.tencent.mm.plugin.finder.ui.FinderSettingsUI"));
      paramView = this.BHf;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163403);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/test/ExMainSettings$initList$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(188259);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ae.moveLogsFromCacheDirToLogDir();
      Toast.makeText((Context)this.BHf.getContext(), (CharSequence)"move success", 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(188259);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(ExMainSettings paramExMainSettings) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(163404);
      this.BHf.finish();
      AppMethodBeat.o(163404);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<z>
  {
    k(ExMainSettings.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.test.ExMainSettings
 * JD-Core Version:    0.7.0.1
 */