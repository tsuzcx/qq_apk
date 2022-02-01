package com.tencent.mm.plugin.test;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/test/ExMainSettings;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getLayoutId", "", "initList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "printCrash", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "d", "startFlutterVideoEditorChoosePic", "Companion", "Info", "SimpleAdapter", "ViewHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ExMainSettings
  extends MMActivity
{
  private static final String TAG;
  public static final a Tbo;
  private RecyclerView mkw;
  private final ArrayList<b> pUj;
  
  static
  {
    AppMethodBeat.i(163411);
    Tbo = new a((byte)0);
    TAG = "ExMainSettings";
    AppMethodBeat.o(163411);
  }
  
  public ExMainSettings()
  {
    AppMethodBeat.i(163410);
    this.pUj = new ArrayList();
    AppMethodBeat.o(163410);
  }
  
  private static final boolean a(ExMainSettings paramExMainSettings, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(263859);
    s.u(paramExMainSettings, "this$0");
    paramExMainSettings.finish();
    AppMethodBeat.o(263859);
    return false;
  }
  
  public final int getLayoutId()
  {
    return R.i.gmz;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(163409);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn(new ExMainSettings..ExternalSyntheticLambda0(this));
    this.pUj.add(new b("朋友圈", R.k.friendactivity_refresh, (View.OnClickListener)new e(this)));
    this.pUj.add(new b("视频动态", R.k.chatting_avatar_story_hint, (View.OnClickListener)new f(this)));
    this.pUj.add(new b("Live", R.k.panel_icon_live, (View.OnClickListener)new g(this)));
    paramBundle = com.tencent.mm.cd.a.m((Context)getContext(), R.k.icons_outlined_finder_icon);
    paramBundle.setColorFilter((ColorFilter)new PorterDuffColorFilter(getContext().getResources().getColor(R.e.Orange_100), PorterDuff.Mode.SRC_ATOP));
    this.pUj.add(new b("Finder", paramBundle, (View.OnClickListener)new h(this)));
    if (BuildInfo.DEBUG) {
      this.pUj.add(new b("moveXlog", null, (View.OnClickListener)new i(this)));
    }
    this.pUj.add(new b("VideoCompositionUI", null, (View.OnClickListener)new j(this)));
    this.mkw = ((RecyclerView)findViewById(R.h.fUc));
    paramBundle = new LinearLayoutManager();
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null) {
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)paramBundle);
    }
    paramBundle = new c(this.pUj);
    localRecyclerView = this.mkw;
    if (localRecyclerView != null) {
      localRecyclerView.setAdapter((RecyclerView.a)paramBundle);
    }
    localRecyclerView = this.mkw;
    if (localRecyclerView != null) {
      localRecyclerView.setItemViewCacheSize(0);
    }
    d.a(0L, (kotlin.g.a.a)new k(paramBundle));
    AppMethodBeat.o(163409);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/test/ExMainSettings$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "", "name", "", "resId", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;ILandroid/view/View$OnClickListener;)V", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;)V", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "getResId", "()Ljava/lang/Integer;", "setResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    Integer Tbp;
    View.OnClickListener dpY;
    Drawable drawable;
    String name;
    
    public b(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163394);
      this.name = paramString;
      this.Tbp = Integer.valueOf(paramInt);
      this.dpY = paramOnClickListener;
      AppMethodBeat.o(163394);
    }
    
    public b(String paramString, Drawable paramDrawable, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163395);
      this.name = paramString;
      this.drawable = paramDrawable;
      this.dpY = paramOnClickListener;
      AppMethodBeat.o(163395);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/test/ExMainSettings$SimpleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "_holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private final ArrayList<ExMainSettings.b> hqL;
    
    public c(ArrayList<ExMainSettings.b> paramArrayList)
    {
      AppMethodBeat.i(163399);
      this.hqL = paramArrayList;
      AppMethodBeat.o(163399);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(263860);
      s.u(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gnW, paramViewGroup, false);
      s.s(paramViewGroup, "from(parent.context)\n   …yout_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new ExMainSettings.d(paramViewGroup);
      AppMethodBeat.o(263860);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(263867);
      s.u(paramv, "_holder");
      paramv = (ExMainSettings.d)paramv;
      Object localObject1 = this.hqL.get(paramInt);
      s.s(localObject1, "list[position]");
      localObject1 = (ExMainSettings.b)localObject1;
      paramv.lDF.setText((CharSequence)((ExMainSettings.b)localObject1).name);
      Object localObject2 = ((ExMainSettings.b)localObject1).Tbp;
      if (localObject2 != null)
      {
        paramInt = ((Number)localObject2).intValue();
        paramv.lPb.setImageResource(paramInt);
      }
      localObject2 = ((ExMainSettings.b)localObject1).drawable;
      if (localObject2 != null) {
        paramv.lPb.setImageDrawable((Drawable)localObject2);
      }
      paramv.doN.setOnClickListener(((ExMainSettings.b)localObject1).dpY);
      AppMethodBeat.o(263867);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(163397);
      int i = this.hqL.size();
      AppMethodBeat.o(163397);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/test/ExMainSettings$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "setIconIv", "(Landroid/widget/ImageView;)V", "layout", "getLayout", "()Landroid/view/View;", "setLayout", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "setNameTv", "(Landroid/widget/TextView;)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.v
  {
    View doN;
    TextView lDF;
    ImageView lPb;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(163400);
      View localView = paramView.findViewById(R.h.gbU);
      s.s(localView, "itemView.findViewById(R.id.view_layout)");
      this.doN = localView;
      localView = paramView.findViewById(R.h.fvb);
      s.s(localView, "itemView.findViewById(R.id.busi_icon)");
      this.lPb = ((ImageView)localView);
      paramView = paramView.findViewById(R.h.name_tv);
      s.s(paramView, "itemView.findViewById(R.id.name_tv)");
      this.lDF = ((TextView)paramView);
      AppMethodBeat.o(163400);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/test/ExMainSettings$initList$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements View.OnClickListener
  {
    e(ExMainSettings paramExMainSettings) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163401);
      Object localObject = new b();
      ((b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/test/ExMainSettings$initList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      localObject = new Intent((Context)this.Tbq, Class.forName("com.tencent.mm.plugin.sns.ui.SnsSettingUI"));
      paramView = this.Tbq;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163401);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/test/ExMainSettings$initList$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements View.OnClickListener
  {
    f(ExMainSettings paramExMainSettings) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(263849);
      Object localObject = new b();
      ((b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/test/ExMainSettings$initList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      localObject = new Intent((Context)this.Tbq, Class.forName("com.tencent.mm.plugin.story.ui.StorySettingsUI"));
      paramView = this.Tbq;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(263849);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/test/ExMainSettings$initList$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements View.OnClickListener
  {
    g(ExMainSettings paramExMainSettings) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163402);
      Object localObject = new b();
      ((b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/test/ExMainSettings$initList$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      localObject = new Intent((Context)this.Tbq, Class.forName("com.tencent.mm.live.ui.LiveUIG"));
      paramView = this.Tbq;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163402);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/test/ExMainSettings$initList$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements View.OnClickListener
  {
    h(ExMainSettings paramExMainSettings) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163403);
      Object localObject = new b();
      ((b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/test/ExMainSettings$initList$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      localObject = new Intent((Context)this.Tbq, Class.forName("com.tencent.mm.plugin.finder.ui.FinderSettingsUI"));
      paramView = this.Tbq;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163403);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/test/ExMainSettings$initList$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements View.OnClickListener
  {
    i(ExMainSettings paramExMainSettings) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(263834);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/test/ExMainSettings$initList$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      Log.moveLogsFromCacheDirToLogDir();
      Toast.makeText((Context)this.Tbq.getContext(), (CharSequence)"move success", 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(263834);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/test/ExMainSettings$initList$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements View.OnClickListener
  {
    j(ExMainSettings paramExMainSettings) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(263835);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/test/ExMainSettings$initList$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      ExMainSettings.a(this.Tbq);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(263835);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
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