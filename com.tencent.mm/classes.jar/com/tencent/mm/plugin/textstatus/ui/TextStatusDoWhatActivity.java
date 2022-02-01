package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.a.m.a;
import com.tencent.mm.plugin.textstatus.b.c.b;
import com.tencent.mm.plugin.textstatus.f.e.c;
import com.tencent.mm.plugin.textstatus.j.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.c;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "btnBack", "Landroid/view/View;", "getBtnBack", "()Landroid/view/View;", "btnBack$delegate", "Lkotlin/Lazy;", "isCancel", "", "isEnter", "()Z", "setEnter", "(Z)V", "layoutContent", "getLayoutContent", "setLayoutContent", "(Landroid/view/View;)V", "onItemClickListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1;", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "finish", "", "getForceOrientation", "", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusDoWhatActivity
  extends MMActivity
{
  public static final TextStatusDoWhatActivity.a GdF;
  private View GdB;
  private final kotlin.f GdD;
  private final g GdE;
  private m Gev;
  boolean dEv;
  private boolean ifz;
  WxRecyclerView rHX;
  
  static
  {
    AppMethodBeat.i(216479);
    GdF = new TextStatusDoWhatActivity.a((byte)0);
    AppMethodBeat.o(216479);
  }
  
  public TextStatusDoWhatActivity()
  {
    AppMethodBeat.i(216478);
    this.ifz = true;
    this.GdD = g.ah((kotlin.g.a.a)new b(this));
    this.GdE = new g(this);
    AppMethodBeat.o(216478);
  }
  
  private final View fwo()
  {
    AppMethodBeat.i(216475);
    View localView = (View)this.GdD.getValue();
    AppMethodBeat.o(216475);
    return localView;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(258448);
    if (this.ifz)
    {
      com.tencent.mm.plugin.textstatus.k.a locala = com.tencent.mm.plugin.textstatus.k.a.UsD;
      com.tencent.mm.plugin.textstatus.k.a.a(this.Gev);
    }
    super.finish();
    AppMethodBeat.o(258448);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131496680;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(216477);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      finish();
      getContext().overridePendingTransition(2130772132, 2130772130);
    }
    AppMethodBeat.o(216477);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(216476);
    com.tencent.mm.pluginsdk.h.q((MMActivity)this);
    super.onCreate(paramBundle);
    setActionbarColor(0);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1792);
    d.e(getWindow());
    setNavigationbarColor(getResources().getColor(2131101287));
    setMMTitle("");
    hideActionbarLine();
    hideActionBarOperationArea();
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    this.rHX = ((WxRecyclerView)findViewById(2131307198));
    this.GdB = findViewById(2131303086);
    paramBundle = getIntent().getByteArrayExtra("SET_TEXT_PARAMS");
    if (paramBundle != null)
    {
      localObject1 = new m();
      ((m)localObject1).parseFrom(paramBundle);
      this.Gev = ((m)localObject1);
    }
    if (this.Gev == null) {
      this.Gev = new m();
    }
    paramBundle = this.Gev;
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle.enterTime = cl.aWA();
    paramBundle = this.Gev;
    if (paramBundle == null) {
      p.hyc();
    }
    Object localObject1 = getIntent();
    Object localObject2 = e.Ggj;
    paramBundle.Gag = ((Intent)localObject1).getIntExtra("KEY_DEFAULT_BACKGROUND_ID", e.fwL());
    this.dEv = getIntent().getBooleanExtra("KEY_IS_ENTER", false);
    paramBundle = this.Gev;
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle = BitmapUtil.getBitmapNative(paramBundle.Gag);
    localObject1 = this.GdB;
    if (localObject1 != null) {
      ((View)localObject1).setBackground((Drawable)new BitmapDrawable(getResources(), paramBundle));
    }
    paramBundle = this.rHX;
    if (paramBundle != null)
    {
      localObject1 = (com.tencent.mm.view.recyclerview.f)new TextStatusDoWhatActivity.c(this);
      localObject2 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)localObject1, com.tencent.mm.plugin.textstatus.j.b.getDataList()));
    }
    paramBundle = getContext();
    p.g(paramBundle, "context");
    paramBundle = paramBundle.getResources();
    p.g(paramBundle, "context.resources");
    int i = paramBundle.getDisplayMetrics().widthPixels;
    paramBundle = getContext();
    p.g(paramBundle, "context");
    paramBundle = paramBundle.getResources();
    p.g(paramBundle, "context.resources");
    int k = Math.min(i, paramBundle.getDisplayMetrics().heightPixels);
    paramBundle = this.rHX;
    if (paramBundle != null) {}
    for (i = paramBundle.getPaddingLeft();; i = 0)
    {
      paramBundle = this.rHX;
      if (paramBundle != null) {
        j = paramBundle.getPaddingRight();
      }
      float f = getResources().getDimension(2131166990);
      paramBundle = new z.c();
      paramBundle.SYD = getResources().getDimension(2131166989);
      f = (k - i - j + paramBundle.SYD) / (f + paramBundle.SYD);
      localObject1 = new z.f();
      ((z.f)localObject1).SYG = new GridLayoutManager((int)f);
      ((GridLayoutManager)((z.f)localObject1).SYG).a((GridLayoutManager.b)new e(this, (z.f)localObject1));
      localObject2 = this.rHX;
      if (localObject2 != null) {
        ((WxRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)((z.f)localObject1).SYG);
      }
      localObject1 = this.rHX;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).b((RecyclerView.h)new f(paramBundle));
      }
      paramBundle = fwo().getLayoutParams();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(216476);
      throw paramBundle;
    }
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    i = au.getStatusBarHeight((Context)getContext());
    paramBundle.topMargin = (at.fromDPToPix((Context)getContext(), 6) + i);
    fwo().setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(216476);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setLayoutContent(View paramView)
  {
    this.GdB = paramView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<View>
  {
    b(TextStatusDoWhatActivity paramTextStatusDoWhatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(TextStatusDoWhatActivity paramTextStatusDoWhatActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(258447);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.GdG.onBackPressed();
      this.GdG.getContext().overridePendingTransition(2130771986, 2130772130);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(258447);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$2", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-textstatus_release"})
  public static final class e
    extends GridLayoutManager.b
  {
    e(z.f paramf) {}
    
    public final int bX(int paramInt)
    {
      AppMethodBeat.i(258445);
      Object localObject = this.GdG.rHX;
      if (localObject != null)
      {
        localObject = ((WxRecyclerView)localObject).getAdapter();
        if (localObject != null)
        {
          localObject = Integer.valueOf(((RecyclerView.a)localObject).getItemViewType(paramInt));
          if (localObject != null) {
            break label55;
          }
          label39:
          if (localObject != null) {
            break label84;
          }
        }
      }
      label55:
      label84:
      while (((Integer)localObject).intValue() != 1)
      {
        AppMethodBeat.o(258445);
        return 1;
        localObject = null;
        break;
        if (((Integer)localObject).intValue() != -1) {
          break label39;
        }
        paramInt = ((GridLayoutManager)this.UsS.SYG).ki();
        AppMethodBeat.o(258445);
        return paramInt;
      }
      paramInt = ((GridLayoutManager)this.UsS.SYG).ki();
      AppMethodBeat.o(258445);
      return paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onCreate$3", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-textstatus_release"})
  public static final class f
    extends RecyclerView.h
  {
    f(z.c paramc) {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(258446);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramRect.bottom = ((int)this.UsT.SYD);
      paramRect.left = ((int)this.UsT.SYD / 2);
      paramRect.right = ((int)this.UsT.SYD / 2);
      AppMethodBeat.o(258446);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$onItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "onItemClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "plugin-textstatus_release"})
  public static final class g
    implements c.b
  {
    public final void a(View paramView, c paramc)
    {
      AppMethodBeat.i(216474);
      p.h(paramView, "v");
      p.h(paramc, "item");
      if (this.GdG.dEv)
      {
        paramView = new m.a().aSZ(paramc.name).aSY(paramc.id);
        paramc = TextStatusDoWhatActivity.b(this.GdG);
        if (paramc == null) {
          p.hyc();
        }
        paramView = paramView.abL(paramc.Gag);
        paramc = TextStatusDoWhatActivity.b(this.GdG);
        if (paramc == null) {
          p.hyc();
        }
        paramView = paramView.Rj(paramc.enterTime).fvz();
        paramc = TextStatusEditActivity.GeM;
        TextStatusEditActivity.a.b((Activity)this.GdG, paramView);
        com.tencent.f.h.RTc.n((Runnable)new a(this), 50L);
        AppMethodBeat.o(216474);
        return;
      }
      paramView = new Intent();
      paramView.putExtra("STATUS_TYPE_NAME", paramc.name);
      paramView.putExtra("STATUS_TYPE_IMG", paramc.id);
      this.GdG.setResult(-1, paramView);
      TextStatusDoWhatActivity.c(this.GdG);
      this.GdG.finish();
      this.GdG.getContext().overridePendingTransition(0, 2130772130);
      AppMethodBeat.o(216474);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(TextStatusDoWhatActivity.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(216473);
        TextStatusDoWhatActivity.c(this.GdJ.GdG);
        this.GdJ.GdG.finish();
        AppMethodBeat.o(216473);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity
 * JD-Core Version:    0.7.0.1
 */