package com.tencent.mm.plugin.recordvideo.plugin.effect;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.a.m;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "changeFilterRunnable", "Ljava/lang/Runnable;", "dialogDismissPrepareCallback", "Lkotlin/Function0;", "", "disMissListener", "getDisMissListener", "()Lkotlin/jvm/functions/Function0;", "setDisMissListener", "(Lkotlin/jvm/functions/Function0;)V", "enableClearRenderEvent", "", "filterList", "Landroid/support/v7/widget/RecyclerView;", "filterProcess", "Landroid/widget/SeekBar;", "finderFilterItemRenderMgr", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterItemRenderMgr;", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "last", "pos", "itemClicker", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$FilterEffectItem;", "item", "getItemClicker", "()Lkotlin/jvm/functions/Function1;", "setItemClicker", "(Lkotlin/jvm/functions/Function1;)V", "lastSetTime", "", "loadImg", "Landroid/view/View;", "renderFinishRunnable", "cancelRenderItem", "prepareDismissDialog", "callback", "release", "renderFilterItem", "textureContext", "Landroid/opengl/EGLContext;", "texture", "width", "height", "rotate", "mirror", "setup", "Companion", "FilterEffectAdapter", "FilterEffectItem", "plugin-recordvideo_release"})
public final class c
  extends LinearLayout
{
  public static final a LnK;
  private SeekBar LnA;
  private View LnB;
  private d.g.a.b<? super c, y> LnC;
  d LnD;
  private d.g.a.a<y> LnE;
  d.g.a.a<y> LnF;
  Runnable LnG;
  private long LnH;
  private Runnable LnI;
  private boolean LnJ;
  RecyclerView Lnz;
  private m<? super Integer, ? super Integer, y> oOb;
  
  static
  {
    AppMethodBeat.i(204180);
    LnK = new a((byte)0);
    AppMethodBeat.o(204180);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204179);
    this.LnD = new d();
    this.LnI = ((Runnable)new d(this));
    this.oOb = ((m)new e(this));
    this.LnJ = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496196, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(204179);
      throw paramContext;
    }
    paramContext = (LinearLayout)paramContext;
    Object localObject = paramContext.findViewById(2131307311);
    k.g(localObject, "parent.findViewById(R.id.filter_effect_list)");
    this.Lnz = ((RecyclerView)localObject);
    paramContext.findViewById(2131307308).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204155);
        paramAnonymousView = this.LnL.getDisMissListener();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(204155);
          return;
        }
        AppMethodBeat.o(204155);
      }
    });
    localObject = this.Lnz;
    if (localObject == null) {
      k.aPZ("filterList");
    }
    ((RecyclerView)localObject).a((RecyclerView.m)new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(204157);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(204157);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(204156);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(204156);
          return;
          if (c.g(this.LnL))
          {
            c.a(this.LnL, false);
            c.h(this.LnL).fYl();
            continue;
            c.a(this.LnL, true);
          }
        }
      }
    });
    localObject = paramContext.findViewById(2131307317);
    k.g(localObject, "parent.findViewById(R.id.filter_progress)");
    this.LnA = ((SeekBar)localObject);
    paramContext = paramContext.findViewById(2131307313);
    k.g(paramContext, "parent.findViewById(R.id.filter_loading)");
    this.LnB = paramContext;
    this.LnA.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(204158);
        paramAnonymousSeekBar = c.f(this.LnL).getAdapter();
        if (paramAnonymousSeekBar == null)
        {
          paramAnonymousSeekBar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterEffectView.FilterEffectAdapter");
          AppMethodBeat.o(204158);
          throw paramAnonymousSeekBar;
        }
        int i = ((c.b)paramAnonymousSeekBar).zGx;
        paramAnonymousSeekBar = c.f(this.LnL).getAdapter();
        if (paramAnonymousSeekBar == null)
        {
          paramAnonymousSeekBar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterEffectView.FilterEffectAdapter");
          AppMethodBeat.o(204158);
          throw paramAnonymousSeekBar;
        }
        ((c.c)((c.b)paramAnonymousSeekBar).LnM.get(i)).LnR = (paramAnonymousInt / 100.0F);
        if (System.currentTimeMillis() - c.e(this.LnL) > 17L)
        {
          c.a(this.LnL, System.currentTimeMillis());
          paramAnonymousSeekBar = this.LnL.getItemClicker();
          if (paramAnonymousSeekBar != null)
          {
            Object localObject = c.f(this.LnL).getAdapter();
            if (localObject == null)
            {
              paramAnonymousSeekBar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterEffectView.FilterEffectAdapter");
              AppMethodBeat.o(204158);
              throw paramAnonymousSeekBar;
            }
            localObject = ((c.b)localObject).LnM.get(i);
            k.g(localObject, "(filterList.adapter as F…apter).filterItems[index]");
            paramAnonymousSeekBar.aA(localObject);
            AppMethodBeat.o(204158);
            return;
          }
          AppMethodBeat.o(204158);
          return;
        }
        aq.az(c.i(this.LnL));
        aq.n(c.i(this.LnL), System.currentTimeMillis() - c.e(this.LnL));
        AppMethodBeat.o(204158);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
    AppMethodBeat.o(204179);
  }
  
  public final void T(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(204178);
    k.h(parama, "callback");
    this.LnF = parama;
    AppMethodBeat.o(204178);
  }
  
  public final int fYk()
  {
    AppMethodBeat.i(204177);
    this.LnD.le(com.tencent.mm.cd.a.ao(getContext(), 2131167032), com.tencent.mm.cd.a.ao(getContext(), 2131167031));
    Object localObject1 = this.Lnz;
    if (localObject1 == null) {
      k.aPZ("filterList");
    }
    Object localObject2 = getContext();
    k.g(localObject2, "context");
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new FinderFilterLayoutManager((Context)localObject2));
    localObject1 = getContext();
    k.g(localObject1, "context");
    localObject1 = new b((Context)localObject1);
    ((b)localObject1).oOb = this.oOb;
    localObject2 = this.Lnz;
    if (localObject2 == null) {
      k.aPZ("filterList");
    }
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
    localObject2 = this.Lnz;
    if (localObject2 == null) {
      k.aPZ("filterList");
    }
    ((RecyclerView)localObject2).setItemViewCacheSize(10);
    localObject2 = com.tencent.mm.plugin.xlabeffect.c.BMk;
    localObject2 = com.tencent.mm.plugin.xlabeffect.c.fZD();
    if (i.eK((String)localObject2))
    {
      Object localObject3 = new e((String)localObject2).fhW();
      k.g(localObject3, "VFSFile(filterPath).listFiles()");
      if (localObject3.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label776;
        }
      }
      label776:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label781;
        }
        this.LnB.setVisibility(8);
        localObject3 = ((b)localObject1).LnM;
        String str = com.tencent.mm.cd.a.aq(getContext(), 2131766724);
        k.g(str, "ResourceHelper.getString…string.record_filter_000)");
        ((ArrayList)localObject3).add(new c(0, str, 0.0F, ""));
        localObject3 = ((b)localObject1).LnM;
        str = com.tencent.mm.cd.a.aq(getContext(), 2131766725);
        k.g(str, "ResourceHelper.getString…string.record_filter_001)");
        ((ArrayList)localObject3).add(new c(1, str, 1.0F, (String)localObject2 + "/f001.png"));
        localObject3 = ((b)localObject1).LnM;
        str = com.tencent.mm.cd.a.aq(getContext(), 2131766726);
        k.g(str, "ResourceHelper.getString…string.record_filter_003)");
        ((ArrayList)localObject3).add(new c(2, str, 1.0F, (String)localObject2 + "/f003.png"));
        localObject3 = ((b)localObject1).LnM;
        str = com.tencent.mm.cd.a.aq(getContext(), 2131766727);
        k.g(str, "ResourceHelper.getString…string.record_filter_004)");
        ((ArrayList)localObject3).add(new c(3, str, 1.0F, (String)localObject2 + "/f004.png"));
        localObject3 = ((b)localObject1).LnM;
        str = com.tencent.mm.cd.a.aq(getContext(), 2131766728);
        k.g(str, "ResourceHelper.getString…string.record_filter_006)");
        ((ArrayList)localObject3).add(new c(4, str, 1.0F, (String)localObject2 + "/f006.png"));
        localObject3 = ((b)localObject1).LnM;
        str = com.tencent.mm.cd.a.aq(getContext(), 2131766729);
        k.g(str, "ResourceHelper.getString…string.record_filter_011)");
        ((ArrayList)localObject3).add(new c(5, str, 1.0F, (String)localObject2 + "/f011.png"));
        localObject3 = ((b)localObject1).LnM;
        str = com.tencent.mm.cd.a.aq(getContext(), 2131766730);
        k.g(str, "ResourceHelper.getString…string.record_filter_012)");
        ((ArrayList)localObject3).add(new c(6, str, 1.0F, (String)localObject2 + "/f012.png"));
        localObject3 = ((b)localObject1).LnM;
        str = com.tencent.mm.cd.a.aq(getContext(), 2131766731);
        k.g(str, "ResourceHelper.getString…string.record_filter_013)");
        ((ArrayList)localObject3).add(new c(7, str, 1.0F, (String)localObject2 + "/f013.png"));
        localObject3 = ((b)localObject1).LnM;
        str = com.tencent.mm.cd.a.aq(getContext(), 2131766732);
        k.g(str, "ResourceHelper.getString…string.record_filter_015)");
        ((ArrayList)localObject3).add(new c(8, str, 1.0F, (String)localObject2 + "/f014.png"));
        ((b)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(204177);
        return 0;
        i = 0;
        break;
      }
    }
    label781:
    localObject1 = this.Lnz;
    if (localObject1 == null) {
      k.aPZ("filterList");
    }
    ((RecyclerView)localObject1).setVisibility(4);
    this.LnA.setVisibility(4);
    AppMethodBeat.o(204177);
    return -1;
  }
  
  public final d.g.a.a<y> getDisMissListener()
  {
    return this.LnE;
  }
  
  public final d.g.a.b<c, y> getItemClicker()
  {
    return this.LnC;
  }
  
  public final void setDisMissListener(d.g.a.a<y> parama)
  {
    this.LnE = parama;
  }
  
  public final void setItemClicker(d.g.a.b<? super c, y> paramb)
  {
    this.LnC = paramb;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$Companion;", "", "()V", "TAG", "", "itemViewCacheSize", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$FilterEffectAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "filterItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$FilterEffectItem;", "Lkotlin/collections/ArrayList;", "getFilterItems", "()Ljava/util/ArrayList;", "setFilterItems", "(Ljava/util/ArrayList;)V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "last", "pos", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "scaleAnimation", "Landroid/view/animation/ScaleAnimation;", "selectIndex", "getSelectIndex", "()I", "setSelectIndex", "(I)V", "getItemCount", "onBindViewHolder", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "holder", "plugin-recordvideo_release"})
  public static final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<c.c> LnM;
    private final ScaleAnimation LnN;
    private Context context;
    m<? super Integer, ? super Integer, y> oOb;
    int zGx;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(204167);
      this.context = paramContext;
      this.LnM = new ArrayList();
      this.LnN = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
      this.LnN.setDuration(100L);
      this.LnN.setFillAfter(false);
      AppMethodBeat.o(204167);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(204164);
      k.h(paramViewGroup, "parent");
      ad.d("MicroMsg.FinderFilterEffectView", "onCreateViewHolder");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496194, paramViewGroup, false);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(204164);
        throw paramViewGroup;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      TextureView localTextureView = new TextureView(this.context);
      localTextureView.setOpaque(false);
      localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new b(localTextureView));
      ((WeImageView)paramViewGroup.findViewById(2131307312)).setIconColor(-1);
      ((FrameLayout)paramViewGroup.findViewById(2131307316)).addView((View)localTextureView, 0, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup.setTag(localTextureView);
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup, (View)paramViewGroup);
      AppMethodBeat.o(204164);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv)
    {
      AppMethodBeat.i(204163);
      k.h(paramv, "holder");
      super.a(paramv);
      ad.d("MicroMsg.FinderFilterEffectView", "onViewRecycled");
      AppMethodBeat.o(204163);
    }
    
    public final void a(final RecyclerView.v paramv, final int paramInt)
    {
      float f2 = 1.0F;
      AppMethodBeat.i(204166);
      k.h(paramv, "viewHolder");
      ad.d("MicroMsg.FinderFilterEffectView", "onBindViewHolder position：".concat(String.valueOf(paramInt)));
      paramv = paramv.arI;
      k.g(paramv, "viewHolder.itemView");
      ImageView localImageView = (ImageView)paramv.findViewById(2131307312);
      k.g(localImageView, "icon");
      localImageView.setVisibility(0);
      if (paramInt == this.zGx)
      {
        f1 = 1.0F;
        localImageView.setAlpha(f1);
        localObject = (TextView)paramv.findViewById(2131307314);
        k.g(localObject, "filterName");
        ((TextView)localObject).setText((CharSequence)((c.c)this.LnM.get(paramInt)).name);
        if (paramInt != this.zGx) {
          break label180;
        }
      }
      label180:
      for (float f1 = f2;; f1 = 0.5F)
      {
        ((TextView)localObject).setAlpha(f1);
        localObject = ((FrameLayout)paramv.findViewById(2131307316)).getChildAt(0);
        if (localObject != null) {
          break label186;
        }
        paramv = new v("null cannot be cast to non-null type android.view.TextureView");
        AppMethodBeat.o(204166);
        throw paramv;
        f1 = 0.5F;
        break;
      }
      label186:
      Object localObject = (TextureView)localObject;
      if (paramInt == 0)
      {
        ((TextureView)localObject).setVisibility(4);
        if (paramv == null)
        {
          paramv = new v("null cannot be cast to non-null type android.widget.LinearLayout");
          AppMethodBeat.o(204166);
          throw paramv;
        }
        localObject = ((LinearLayout)paramv).getLayoutParams();
        if (localObject == null)
        {
          paramv = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(204166);
          throw paramv;
        }
        ((RecyclerView.LayoutParams)localObject).setMarginStart(com.tencent.mm.cd.a.ao(this.context, 2131165303));
        localImageView.setImageDrawable(am.i(this.context, 2131691504, -1));
      }
      for (;;)
      {
        paramv.setOnClickListener((View.OnClickListener)new a(this, paramv, paramInt));
        AppMethodBeat.o(204166);
        return;
        ((TextureView)localObject).setVisibility(0);
        if (paramv == null)
        {
          paramv = new v("null cannot be cast to non-null type android.widget.LinearLayout");
          AppMethodBeat.o(204166);
          throw paramv;
        }
        localObject = ((LinearLayout)paramv).getLayoutParams();
        if (localObject == null)
        {
          paramv = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(204166);
          throw paramv;
        }
        ((RecyclerView.LayoutParams)localObject).setMarginStart(0);
        if (this.zGx == paramInt) {
          localImageView.setImageDrawable(am.i(this.context, 2131691505, -1));
        } else {
          localImageView.setImageDrawable(null);
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(204165);
      int i = this.LnM.size();
      AppMethodBeat.o(204165);
      return i;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.b paramb, View paramView, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(204159);
        paramv.clearAnimation();
        paramv.startAnimation((Animation)c.b.a(this.LnO));
        if (paramInt == this.LnO.zGx)
        {
          AppMethodBeat.o(204159);
          return;
        }
        this.LnO.ck(this.LnO.zGx);
        this.LnO.ck(paramInt);
        int i = this.LnO.zGx;
        this.LnO.zGx = paramInt;
        paramView = this.LnO.oOb;
        if (paramView != null)
        {
          paramView.n(Integer.valueOf(i), Integer.valueOf(paramInt));
          AppMethodBeat.o(204159);
          return;
        }
        AppMethodBeat.o(204159);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$FilterEffectAdapter$onCreateViewHolder$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-recordvideo_release"})
    public static final class b
      implements TextureView.SurfaceTextureListener
    {
      b(TextureView paramTextureView) {}
      
      public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(204162);
        Object localObject1;
        if (this.LnP.getTag() == null)
        {
          this.LnP.setTag(paramSurfaceTexture);
          localObject1 = new StringBuilder("onSurfaceTextureAvailable ").append(paramSurfaceTexture).append(" hash:");
          if (paramSurfaceTexture == null) {
            break label142;
          }
        }
        label142:
        for (int i = paramSurfaceTexture.hashCode();; i = 0)
        {
          ad.d("MicroMsg.FinderFilterEffectView", i + "  " + paramInt1 + ' ' + paramInt2);
          AppMethodBeat.o(204162);
          return;
          localObject1 = this.LnP;
          Object localObject2 = this.LnP.getTag();
          if (localObject2 == null)
          {
            paramSurfaceTexture = new v("null cannot be cast to non-null type android.graphics.SurfaceTexture");
            AppMethodBeat.o(204162);
            throw paramSurfaceTexture;
          }
          ((TextureView)localObject1).setSurfaceTexture((SurfaceTexture)localObject2);
          break;
        }
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(204161);
        ad.d("MicroMsg.FinderFilterEffectView", "onSurfaceTextureDestroyed ".concat(String.valueOf(paramSurfaceTexture)));
        AppMethodBeat.o(204161);
        return false;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(204160);
        ad.d("MicroMsg.FinderFilterEffectView", "onSurfaceTextureSizeChanged ".concat(String.valueOf(paramSurfaceTexture)));
        AppMethodBeat.o(204160);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$FilterEffectAdapter$onCreateViewHolder$2", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-recordvideo_release"})
    public static final class c
      extends RecyclerView.v
    {
      c(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectView$FilterEffectItem;", "", "index", "", "name", "", "process", "", "path", "(ILjava/lang/String;FLjava/lang/String;)V", "getIndex", "()I", "setIndex", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPath", "setPath", "getProcess", "()F", "setProcess", "(F)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-recordvideo_release"})
  public static final class c
  {
    float LnR;
    int index;
    String name;
    String path;
    
    public c(int paramInt, String paramString1, float paramFloat, String paramString2)
    {
      AppMethodBeat.i(204168);
      this.index = paramInt;
      this.name = paramString1;
      this.LnR = paramFloat;
      this.path = paramString2;
      AppMethodBeat.o(204168);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(204171);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.index != paramObject.index) || (!k.g(this.name, paramObject.name)) || (Float.compare(this.LnR, paramObject.LnR) != 0) || (!k.g(this.path, paramObject.path))) {}
        }
      }
      else
      {
        AppMethodBeat.o(204171);
        return true;
      }
      AppMethodBeat.o(204171);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(204170);
      int k = this.index;
      String str = this.name;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int m = Float.floatToIntBits(this.LnR);
        str = this.path;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(204170);
        return ((i + k * 31) * 31 + m) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204169);
      String str = "FilterEffectItem(index=" + this.index + ", name=" + this.name + ", process=" + this.LnR + ", path=" + this.path + ")";
      AppMethodBeat.o(204169);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(204172);
      c.a(this.LnL, System.currentTimeMillis());
      Object localObject1 = c.f(this.LnL).getAdapter();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterEffectView.FilterEffectAdapter");
        AppMethodBeat.o(204172);
        throw ((Throwable)localObject1);
      }
      int i = ((c.b)localObject1).zGx;
      localObject1 = this.LnL.getItemClicker();
      if (localObject1 != null)
      {
        Object localObject2 = c.f(this.LnL).getAdapter();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterEffectView.FilterEffectAdapter");
          AppMethodBeat.o(204172);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((c.b)localObject2).LnM.get(i);
        k.g(localObject2, "(filterList.adapter as F…apter).filterItems[index]");
        ((d.g.a.b)localObject1).aA(localObject2);
        AppMethodBeat.o(204172);
        return;
      }
      AppMethodBeat.o(204172);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "last", "", "pos", "invoke"})
  static final class e
    extends d.g.b.l
    implements m<Integer, Integer, y>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.effect.c
 * JD-Core Version:    0.7.0.1
 */