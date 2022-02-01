package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.al.a.c;
import com.tencent.mm.plugin.al.a.e;
import com.tencent.mm.plugin.al.a.f;
import com.tencent.mm.plugin.al.a.h;
import com.tencent.mm.plugin.scanner.model.ScanProductInfo;
import com.tencent.mm.plugin.scanner.scan_goods_new.j;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.view.MultiRectView;
import com.tencent.mm.plugin.scanner.view.ScanProductDetectRectView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animateScaleDelta", "", "lastId", "getLastId", "()I", "setLastId", "(I)V", "mAdapter", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ProductInfoAdapter;", "productInfoRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rectView", "Lcom/tencent/mm/plugin/scanner/view/MultiRectView;", "scanProductCallBack", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ScanProductCallBack;", "scanProductListLayout", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductListLayout;", "scanProductListState", "scanProductOnItemClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ScanProductOnItemClickListener;", "addNewProduct", "", "info", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "rect", "Landroid/graphics/Rect;", "copyProductInfo", "oldRequestInfo", "doProductDetectorAnimate", "", "getTotalProductCount", "init", "notifyUpdateProductItemList", "productItemList", "", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "onBackPressed", "onDestroy", "setScanProductCallBack", "callBack", "setScanProductOnItemClickListener", "listener", "updateDecorRect", "rectList", "updateProductInfo", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductResult;", "updateProductInfoListArea", "bottomMargin", "Companion", "EmptyViewHolder", "ProductInfoAdapter", "ProductInfoViewHolder", "ScanProductCallBack", "ScanProductOnItemClickListener", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanProductMaskDecorView
  extends FrameLayout
{
  private static HashMap<String, Bitmap> Etw;
  public static final ScanProductMaskDecorView.a PgH;
  private MultiRectView PgI;
  private RecyclerView PgJ;
  private ScanProductListLayout PgK;
  private c PgL;
  private float PgM;
  public e PgN;
  private f PgO;
  public int PgP;
  private int PgQ;
  
  static
  {
    AppMethodBeat.i(314877);
    PgH = new ScanProductMaskDecorView.a((byte)0);
    Etw = new HashMap();
    AppMethodBeat.o(314877);
  }
  
  public ScanProductMaskDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(314830);
    this.PgQ = -1;
    init();
    AppMethodBeat.o(314830);
  }
  
  public ScanProductMaskDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(314833);
    this.PgQ = -1;
    init();
    AppMethodBeat.o(314833);
  }
  
  public static j a(j paramj)
  {
    AppMethodBeat.i(314851);
    Object localObject = new ScanProductInfo();
    ScanProductInfo localScanProductInfo = paramj.OWh;
    ((ScanProductInfo)localObject).setShouldShow(localScanProductInfo.getShouldShow());
    ((ScanProductInfo)localObject).setProb(localScanProductInfo.getProb());
    ((ScanProductInfo)localObject).setId(localScanProductInfo.getId());
    ((ScanProductInfo)localObject).setAge(localScanProductInfo.getAge());
    ((ScanProductInfo)localObject).setClassId(localScanProductInfo.getClassId());
    ((ScanProductInfo)localObject).setHit(localScanProductInfo.getHit());
    ((ScanProductInfo)localObject).setX1(localScanProductInfo.getX1());
    ((ScanProductInfo)localObject).setY1(localScanProductInfo.getY1());
    ((ScanProductInfo)localObject).setX2(localScanProductInfo.getX2());
    ((ScanProductInfo)localObject).setY2(localScanProductInfo.getY2());
    localObject = new j((ScanProductInfo)localObject);
    ((j)localObject).OWb = paramj.OWb;
    ((j)localObject).ORl = paramj.ORl;
    ((j)localObject).OWi = paramj.OWi;
    AppMethodBeat.o(314851);
    return localObject;
  }
  
  private static final void a(ScanProductDetectRectView paramScanProductDetectRectView, float paramFloat, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(314857);
    s.u(paramScanProductDetectRectView, "$rectView");
    float f = paramValueAnimator.getAnimatedFraction();
    if (f <= 0.3F)
    {
      paramScanProductDetectRectView.setAlpha(f / 0.3F);
      paramScanProductDetectRectView.setScaleX(1.0F);
      paramScanProductDetectRectView.setScaleY(1.0F);
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanProductMaskDecorView", "fraction:" + f + "  alpha:" + paramScanProductDetectRectView.getAlpha() + "  scale:" + paramScanProductDetectRectView.getScaleY());
      AppMethodBeat.o(314857);
      return;
      if (f <= 0.5F)
      {
        paramFloat = (f - 0.3F) / 0.2F * paramFloat + 1.0F;
        paramScanProductDetectRectView.setAlpha(1.0F);
        paramScanProductDetectRectView.setScaleX(paramFloat);
        paramScanProductDetectRectView.setScaleY(paramFloat);
      }
      else if (f <= 0.7F)
      {
        paramFloat = (0.7F - f) / 0.2F * paramFloat + 1.0F;
        paramScanProductDetectRectView.setAlpha(1.0F);
        paramScanProductDetectRectView.setScaleX(paramFloat);
        paramScanProductDetectRectView.setScaleY(paramFloat);
      }
      else
      {
        paramScanProductDetectRectView.setAlpha((1.0F - f) / 0.3F);
        paramScanProductDetectRectView.setScaleX(1.0F);
        paramScanProductDetectRectView.setScaleY(1.0F);
      }
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(314846);
    Log.i("MicroMsg.ScanProductMaskDecorView", "init");
    Object localObject1 = LayoutInflater.from(getContext()).inflate(a.f.layout_scan_product_mask_view, (ViewGroup)this);
    this.PgK = ((ScanProductListLayout)((View)localObject1).findViewById(a.e.scan_product_list));
    Object localObject2 = this.PgK;
    if (localObject2 != null) {
      ((ScanProductListLayout)localObject2).setProductListCallBack((ScanProductListLayout.b)new h(this));
    }
    this.PgJ = ((RecyclerView)((View)localObject1).findViewById(a.e.rv_scan_product_info));
    localObject1 = getContext();
    s.s(localObject1, "context");
    localObject2 = this.PgJ;
    s.checkNotNull(localObject2);
    this.PgL = new c((Context)localObject1, (RecyclerView)localObject2);
    localObject1 = this.PgJ;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.PgL);
    }
    localObject1 = this.PgJ;
    if (localObject1 != null)
    {
      getContext();
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    this.PgI = new MultiRectView(getContext());
    addView((View)this.PgI, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    setWillNotDraw(false);
    this.PgM = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    localObject1 = this.PgL;
    if (localObject1 != null) {
      ((RecyclerView.a)localObject1).bZE.notifyChanged();
    }
    AppMethodBeat.o(314846);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(314838);
    Iterator localIterator = ((Map)Etw).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((Bitmap)localEntry.getValue()).isRecycled()) {
        ((Bitmap)localEntry.getValue()).recycle();
      }
    }
    AppMethodBeat.o(314838);
  }
  
  public final void a(final j paramj, Rect arg2)
  {
    AppMethodBeat.i(314930);
    s.u(paramj, "info");
    s.u(???, "rect");
    final ScanProductDetectRectView localScanProductDetectRectView = new ScanProductDetectRectView(getContext());
    localScanProductDetectRectView.setRect(???);
    localScanProductDetectRectView.setPivotX(???.exactCenterX());
    localScanProductDetectRectView.setPivotY(???.exactCenterY());
    addView((View)localScanProductDetectRectView);
    float f = this.PgM / ???.width();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(1000L);
    Object localObject = this.PgL;
    int i;
    if (localObject != null)
    {
      i = paramj.OWh.getId();
      s.u(paramj, "info");
    }
    synchronized (((c)localObject).PgW)
    {
      localObject = (Map)((c)localObject).PgW;
      com.tencent.mm.plugin.scanner.scan_goods_new.h localh = new com.tencent.mm.plugin.scanner.scan_goods_new.h();
      localh.trackId = paramj.OWh.getId();
      localh.OWb = paramj.OWb;
      localh.ORl = paramj.ORl;
      localh.state = 1;
      ((Map)localObject).put(Integer.valueOf(i), localh);
      localObject = ah.aiuX;
      localValueAnimator.addListener((Animator.AnimatorListener)new g(this, localScanProductDetectRectView, paramj));
      localValueAnimator.addUpdateListener(new ScanProductMaskDecorView..ExternalSyntheticLambda0(localScanProductDetectRectView, f));
      localValueAnimator.start();
      AppMethodBeat.o(314930);
      return;
    }
  }
  
  public final void aiy(int paramInt)
  {
    AppMethodBeat.i(314908);
    if (this.PgK == null)
    {
      AppMethodBeat.o(314908);
      return;
    }
    Object localObject = this.PgK;
    s.checkNotNull(localObject);
    localObject = ((ScanProductListLayout)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(314908);
      throw ((Throwable)localObject);
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).height = (getHeight() / 2);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, paramInt);
    ScanProductListLayout localScanProductListLayout = this.PgK;
    s.checkNotNull(localScanProductListLayout);
    localScanProductListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(314908);
  }
  
  public final int getLastId()
  {
    return this.PgQ;
  }
  
  public final int getTotalProductCount()
  {
    AppMethodBeat.i(314935);
    if (this.PgL == null)
    {
      AppMethodBeat.o(314935);
      return 0;
    }
    c localc = this.PgL;
    s.checkNotNull(localc);
    int i = localc.gTw();
    AppMethodBeat.o(314935);
    return i;
  }
  
  public final int kk(List<com.tencent.mm.plugin.scanner.scan_goods_new.h> paramList)
  {
    AppMethodBeat.i(314938);
    s.u(paramList, "productItemList");
    c localc = this.PgL;
    if (localc == null)
    {
      AppMethodBeat.o(314938);
      return -1;
    }
    int i = localc.kk(paramList);
    AppMethodBeat.o(314938);
    return i;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(314901);
    ScanProductListLayout localScanProductListLayout = this.PgK;
    if (localScanProductListLayout == null)
    {
      AppMethodBeat.o(314901);
      return false;
    }
    boolean bool = localScanProductListLayout.onBackPressed();
    AppMethodBeat.o(314901);
    return bool;
  }
  
  public final void setLastId(int paramInt)
  {
    this.PgQ = paramInt;
  }
  
  public final void setScanProductCallBack(e parame)
  {
    AppMethodBeat.i(314889);
    s.u(parame, "callBack");
    this.PgN = parame;
    AppMethodBeat.o(314889);
  }
  
  public final void setScanProductOnItemClickListener(f paramf)
  {
    AppMethodBeat.i(314895);
    s.u(paramf, "listener");
    this.PgO = paramf;
    c localc = this.PgL;
    if (localc != null) {
      localc.PgX = paramf;
    }
    AppMethodBeat.o(314895);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ProductInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;)V", "TYPE_DATA", "", "TYPE_EMPTY", "imageSize", "mHeaderEmptyView", "Landroid/view/View;", "mOnItemClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ScanProductOnItemClickListener;", "mProductIdMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "Lkotlin/collections/HashMap;", "mProductInfoList", "Ljava/util/ArrayList;", "pendingAddIdList", "Lkotlin/collections/ArrayList;", "addProductId", "", "trackId", "info", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "addProductInfo", "requestInfo", "getItemCount", "getItemViewType", "position", "getProductCardCount", "getProductIdPosition", "id", "loadBitmap", "imageView", "Landroid/widget/ImageView;", "imageData", "", "imageEncodeType", "notifyProductItemChanged", "notifyUpdateProductItemList", "productItemList", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "listener", "updateHeaderEmptyView", "visible", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private final int PgS;
    private final int PgT;
    private int PgU;
    final ArrayList<Integer> PgV;
    final HashMap<Integer, com.tencent.mm.plugin.scanner.scan_goods_new.h> PgW;
    ScanProductMaskDecorView.f PgX;
    ArrayList<Integer> PgY;
    private View PgZ;
    private final Context context;
    final RecyclerView mkw;
    
    public c(Context paramContext, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(314942);
      this.context = paramContext;
      this.mkw = paramRecyclerView;
      this.PgS = 1;
      this.PgT = 2;
      this.PgU = this.context.getResources().getDimensionPixelSize(a.c.Edge_4A);
      this.PgV = new ArrayList();
      this.PgW = new HashMap();
      this.PgY = new ArrayList();
      AppMethodBeat.o(314942);
    }
    
    private static final void a(int paramInt1, byte[] paramArrayOfByte, c paramc, int paramInt2, ImageView paramImageView)
    {
      Object localObject = null;
      AppMethodBeat.i(314974);
      s.u(paramc, "this$0");
      s.u(paramImageView, "$imageView");
      long l1 = System.currentTimeMillis();
      String str;
      switch (paramInt1)
      {
      default: 
        paramArrayOfByte = null;
        long l2 = System.currentTimeMillis();
        str = "loadBitmap decode cost: " + (l2 - l1) + ", bm.size: %s, imageEncodeType: %s";
        if (paramArrayOfByte != null) {
          break;
        }
      }
      for (paramc = localObject;; paramc = Integer.valueOf(paramArrayOfByte.getAllocationByteCount()))
      {
        Log.v("MicroMsg.ScanProductMaskDecorView", str, new Object[] { paramc, Integer.valueOf(paramInt1) });
        com.tencent.threadpool.h.ahAA.bk(new ScanProductMaskDecorView.c..ExternalSyntheticLambda2(paramArrayOfByte, paramInt2, paramImageView));
        AppMethodBeat.o(314974);
        return;
        paramArrayOfByte = BitmapUtil.decodeByteArray(paramArrayOfByte, paramc.PgU * 2, paramc.PgU * 2);
        break;
        paramArrayOfByte = BitmapUtil.decodeByteArray(paramArrayOfByte, paramc.PgU, paramc.PgU);
        break;
      }
    }
    
    private static final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
    {
      AppMethodBeat.i(314970);
      s.u(paramImageView, "$imageView");
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        ScanProductMaskDecorView.a locala = ScanProductMaskDecorView.PgH;
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          ScanProductMaskDecorView.gTv().put(String.valueOf(paramInt), paramBitmap);
        }
        if (s.p(paramImageView.getTag(), Integer.valueOf(paramInt))) {
          paramImageView.setImageBitmap(paramBitmap);
        }
      }
      AppMethodBeat.o(314970);
    }
    
    private static final void a(ah.f paramf, c paramc, int paramInt, View paramView)
    {
      AppMethodBeat.i(314960);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramf);
      localb.cH(paramc);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ProductInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramf, "$info");
      s.u(paramc, "this$0");
      Log.i("MicroMsg.ScanProductMaskDecorView", "onScanProductItemClick reqKey: %s", new Object[] { ((com.tencent.mm.plugin.scanner.scan_goods_new.h)paramf.aqH).hAT });
      localObject = paramc.PgX;
      int j;
      int i;
      if (localObject != null)
      {
        s.s(paramView, "it");
        paramf = (com.tencent.mm.plugin.scanner.scan_goods_new.h)paramf.aqH;
        j = paramc.gTw();
        paramView = (Collection)paramc.PgV;
        if ((paramView != null) && (!paramView.isEmpty())) {
          break label211;
        }
        i = 1;
        if (i == 0) {
          break label217;
        }
        paramInt = 1;
      }
      for (;;)
      {
        ((ScanProductMaskDecorView.f)localObject).a(paramf, j, paramInt);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ProductInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(314960);
        return;
        label211:
        i = 0;
        break;
        label217:
        paramInt = paramc.PgV.indexOf(Integer.valueOf(paramInt));
        if (paramInt == -1) {
          paramInt = 1;
        } else {
          paramInt += 1;
        }
      }
    }
    
    private final int aiz(int paramInt)
    {
      AppMethodBeat.i(314951);
      Iterator localIterator = ((Iterable)this.PgV).iterator();
      int i = 0;
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        if (paramInt == ((Number)localObject).intValue())
        {
          fV(i + 1);
          AppMethodBeat.o(314951);
          return i + 1;
        }
        i += 1;
      }
      localIterator = ((Iterable)this.PgY).iterator();
      paramInt = 0;
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (paramInt < 0) {
          p.kkW();
        }
        i = ((Number)localObject).intValue();
        Log.i("MicroMsg.ScanProductMaskDecorView", "notifyItemChanged insert pending id: %s", new Object[] { Integer.valueOf(i) });
        this.PgV.add(0, Integer.valueOf(i));
        fW(1);
        paramInt += 1;
      }
      this.PgY.clear();
      AppMethodBeat.o(314951);
      return 1;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(314990);
      s.u(paramViewGroup, "parent");
      if (paramInt == this.PgS)
      {
        paramViewGroup = View.inflate(paramViewGroup.getContext(), a.f.scan_product_info_empty_item_layout, null);
        s.s(paramViewGroup, "view");
        paramViewGroup = (RecyclerView.v)new ScanProductMaskDecorView.b(paramViewGroup);
        AppMethodBeat.o(314990);
        return paramViewGroup;
      }
      paramViewGroup = View.inflate(paramViewGroup.getContext(), a.f.scan_product_info_item_layout, null);
      s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new ScanProductMaskDecorView.d(paramViewGroup);
      AppMethodBeat.o(314990);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(314996);
      s.u(paramv, "holder");
      if (paramInt == 0)
      {
        if ((paramv instanceof ScanProductMaskDecorView.b)) {
          this.PgZ = ((ScanProductMaskDecorView.b)paramv).PgR;
        }
        ??? = new StringBuilder("onBindViewHolder  header EmptyViewHolder  recyclerViewHeight:").append(this.mkw.getHeight()).append("  mHeaderEmptyView:");
        paramv = this.PgZ;
        if (paramv == null) {}
        for (paramv = null;; paramv = Integer.valueOf(paramv.getHeight()))
        {
          paramv = ((StringBuilder)???).append(paramv).append("  topMargin:");
          ??? = this.mkw.getLayoutParams();
          if (??? != null) {
            break;
          }
          paramv = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(314996);
          throw paramv;
        }
        Log.i("MicroMsg.ScanProductMaskDecorView", ((ViewGroup.MarginLayoutParams)???).topMargin + "  pos:" + paramInt);
        AppMethodBeat.o(314996);
        return;
      }
      if (paramInt > this.PgV.size())
      {
        if ((paramv instanceof ScanProductMaskDecorView.b)) {
          ((ScanProductMaskDecorView.b)paramv).PgR.setVisibility(8);
        }
        Log.i("MicroMsg.ScanProductMaskDecorView", s.X("onBindViewHolder  footer EmptyViewHolder pos:", Integer.valueOf(paramInt)));
        AppMethodBeat.o(314996);
        return;
      }
      ??? = this.PgV.get(paramInt - 1);
      s.s(???, "mProductInfoList[position - 1]");
      int j = ((Number)???).intValue();
      ah.f localf = new ah.f();
      Object localObject3;
      synchronized (this.PgW)
      {
        localf.aqH = this.PgW.get(Integer.valueOf(j));
        localObject3 = ah.aiuX;
        if ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH == null)
        {
          AppMethodBeat.o(314996);
          return;
        }
      }
      if (!(paramv instanceof ScanProductMaskDecorView.d))
      {
        AppMethodBeat.o(314996);
        return;
      }
      int i;
      if ((((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).state == 1) || (((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).state == 2) || (((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).state == 2))
      {
        ((ScanProductMaskDecorView.d)paramv).Dlp.setVisibility(0);
        ((ScanProductMaskDecorView.d)paramv).Phc.setVisibility(8);
        if (((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).state == 1) {
          ((ScanProductMaskDecorView.d)paramv).DmL.setVisibility(4);
        }
        if (((CharSequence)((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).hAT).length() <= 0) {
          break label988;
        }
        i = 1;
        label458:
        if (i == 0) {
          break label993;
        }
        ((ScanProductMaskDecorView.d)paramv).Pha.setOnClickListener(new ScanProductMaskDecorView.c..ExternalSyntheticLambda0(localf, this, j));
        label484:
        ((ScanProductMaskDecorView.d)paramv).Phb.setImageBitmap(null);
        ((ScanProductMaskDecorView.d)paramv).Phb.setTag(Integer.valueOf(((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).trackId));
        i = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).trackId;
        paramv = ((ScanProductMaskDecorView.d)paramv).Phb;
        s.s(paramv, "holder.productInfoIconIv");
        ??? = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).OWb;
        j = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).ORl;
        localObject3 = ScanProductMaskDecorView.PgH;
        localObject3 = (Bitmap)ScanProductMaskDecorView.gTv().get(String.valueOf(i));
        if ((localObject3 == null) || (((Bitmap)localObject3).isRecycled())) {
          break label1007;
        }
        paramv.setImageBitmap((Bitmap)localObject3);
        label611:
        ??? = new StringBuilder("onBindViewHolder info:").append(localf.aqH).append("  mHeaderEmptyView:");
        paramv = this.PgZ;
        if (paramv != null) {
          break label1033;
        }
      }
      label770:
      label1033:
      for (paramv = localObject2;; paramv = Integer.valueOf(paramv.getHeight()))
      {
        paramv = ((StringBuilder)???).append(paramv).append("  topMargin:");
        ??? = this.mkw.getLayoutParams();
        if (??? != null) {
          break label1044;
        }
        paramv = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(314996);
        throw paramv;
        ((ScanProductMaskDecorView.d)paramv).Phc.setVisibility(0);
        ((ScanProductMaskDecorView.d)paramv).Dlp.setVisibility(8);
        if (((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).state == 4)
        {
          ((ScanProductMaskDecorView.d)paramv).DmL.setVisibility(0);
          if ((e.gTR()) && (((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).OVD != 1))
          {
            ??? = "后台识别：";
            if (((CharSequence)((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).title).length() <= 0) {
              break label838;
            }
          }
          label838:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label843;
            }
            ((ScanProductMaskDecorView.d)paramv).Phc.setText((CharSequence)s.X((String)???, ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).title));
            break;
            ??? = "";
            break label770;
          }
          label843:
          ((ScanProductMaskDecorView.d)paramv).Phc.setText((CharSequence)s.X((String)???, this.context.getString(a.h.scan_product_failed_default_tips)));
          break;
        }
        if ((((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).state != 3) && (((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).state != 5)) {
          break;
        }
        ((ScanProductMaskDecorView.d)paramv).Phc.setText((CharSequence)this.context.getString(a.h.scan_product_failed_default_tips));
        if (((CharSequence)((com.tencent.mm.plugin.scanner.scan_goods_new.h)localf.aqH).hAT).length() == 0) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label974;
          }
          ((ScanProductMaskDecorView.d)paramv).DmL.setVisibility(4);
          break;
        }
        label974:
        ((ScanProductMaskDecorView.d)paramv).DmL.setVisibility(0);
        break;
        label988:
        i = 0;
        break label458;
        label993:
        ((ScanProductMaskDecorView.d)paramv).Pha.setOnClickListener(null);
        break label484;
        label1007:
        com.tencent.threadpool.h.ahAA.bm(new ScanProductMaskDecorView.c..ExternalSyntheticLambda1(j, (byte[])???, this, i, paramv));
        break label611;
      }
      label1044:
      Log.v("MicroMsg.ScanProductMaskDecorView", ((ViewGroup.MarginLayoutParams)???).topMargin + " pos:" + paramInt);
      AppMethodBeat.o(314996);
    }
    
    public final int gTw()
    {
      AppMethodBeat.i(315009);
      if (this.PgV == null)
      {
        AppMethodBeat.o(315009);
        return 0;
      }
      int i = this.PgV.size();
      AppMethodBeat.o(315009);
      return i;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(314999);
      int i = this.PgV.size();
      AppMethodBeat.o(314999);
      return i + 2;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(315002);
      int i = this.PgT;
      if ((paramInt == 0) || (paramInt > this.PgV.size())) {
        i = this.PgS;
      }
      Log.d("MicroMsg.ScanProductMaskDecorView", "getItemViewType   dataSize:" + this.PgV.size() + "  viewType" + i + "   pos:" + paramInt);
      AppMethodBeat.o(315002);
      return i;
    }
    
    public final int kk(List<com.tencent.mm.plugin.scanner.scan_goods_new.h> paramList)
    {
      AppMethodBeat.i(315006);
      s.u(paramList, "productItemList");
      Log.i("MicroMsg.ScanProductMaskDecorView", "notifyUpdateProductItemList size: %s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      int j = -1;
      boolean bool = false;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (i < 0) {
          p.kkW();
        }
        localObject = (com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject;
        com.tencent.mm.plugin.scanner.scan_goods_new.h localh = (com.tencent.mm.plugin.scanner.scan_goods_new.h)this.PgW.get(Integer.valueOf(((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).trackId));
        if (localh != null)
        {
          localh.hBk = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).hBk;
          localh.source = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).source;
          localh.OVD = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).OVD;
          localh.OVE = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).OVE;
          localh.state = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).state;
          localh.setReqKey(((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).hAT);
          localh.setTitle(((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).title);
          localh.setImageUrl(((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).imageUrl);
          localh.status = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).status;
          localh.OWd = ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).OWd;
          j = aiz(((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).trackId);
          bool = true;
        }
        Log.i("MicroMsg.ScanProductMaskDecorView", "notifyUpdateProductItemList updated: " + bool + ", source: " + ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).source + ", session: " + ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).hBk + ", scanImageType: " + ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).OVD + ", trackId: " + ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).trackId + ", reqKey: " + ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).hAT);
        i += 1;
      }
      AppMethodBeat.o(315006);
      return j;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ProductInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "kotlin.jvm.PlatformType", "getArrow", "()Landroid/view/View;", "loadingProgressBar", "Landroid/widget/ProgressBar;", "getLoadingProgressBar", "()Landroid/widget/ProgressBar;", "productInfoContentTv", "Landroid/widget/TextView;", "getProductInfoContentTv", "()Landroid/widget/TextView;", "productInfoIconIv", "Landroid/widget/ImageView;", "getProductInfoIconIv", "()Landroid/widget/ImageView;", "productInfoLayout", "Landroid/view/ViewGroup;", "getProductInfoLayout", "()Landroid/view/ViewGroup;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.v
  {
    final ProgressBar Dlp;
    final View DmL;
    final ViewGroup Pha;
    final ImageView Phb;
    final TextView Phc;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(314940);
      this.Pha = ((ViewGroup)paramView.findViewById(a.e.scan_product_info_layout));
      this.Phb = ((ImageView)paramView.findViewById(a.e.scan_product_info_icon));
      View localView = paramView.findViewById(a.e.scan_product_info_title);
      aw.a((Paint)((TextView)localView).getPaint(), 0.8F);
      ah localah = ah.aiuX;
      this.Phc = ((TextView)localView);
      this.Dlp = ((ProgressBar)paramView.findViewById(a.e.scan_product_info_loading));
      this.DmL = paramView.findViewById(a.e.arrow);
      AppMethodBeat.o(314940);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ScanProductCallBack;", "", "onAddScanProduct", "", "scanImageType", "", "detectSession", "", "productCardCount", "onProductListStateChange", "state", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface e
  {
    public abstract void air(int paramInt);
    
    public abstract void b(int paramInt1, long paramLong, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ScanProductOnItemClickListener;", "", "onClick", "", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "totalCount", "", "position", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface f
  {
    public abstract void a(com.tencent.mm.plugin.scanner.scan_goods_new.h paramh, int paramInt1, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$doProductDetectorAnimate$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements Animator.AnimatorListener
  {
    g(ScanProductMaskDecorView paramScanProductMaskDecorView, ScanProductDetectRectView paramScanProductDetectRectView, j paramj) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator arg1)
    {
      AppMethodBeat.i(314923);
      this.Phd.removeView((View)localScanProductDetectRectView);
      Object localObject1 = ScanProductMaskDecorView.a(this.Phd);
      if (localObject1 != null)
      {
        ??? = paramj;
        s.u(???, "requestInfo");
        ScanProductInfo localScanProductInfo = ???.OWh;
        Log.i("MicroMsg.ScanProductMaskDecorView", s.X("addNewProduct trackId: ", Integer.valueOf(localScanProductInfo.getId())));
        synchronized (((ScanProductMaskDecorView.c)localObject1).PgW)
        {
          if (((ScanProductMaskDecorView.c)localObject1).PgW.containsKey(Integer.valueOf(localScanProductInfo.getId())))
          {
            Log.i("MicroMsg.ScanProductMaskDecorView", "addNewProduct trackId: " + localScanProductInfo.getId() + " insert");
            ((ScanProductMaskDecorView.c)localObject1).PgV.add(0, Integer.valueOf(localScanProductInfo.getId()));
            ((ScanProductMaskDecorView.c)localObject1).fW(1);
            localObject1 = ah.aiuX;
            AppMethodBeat.o(314923);
            return;
          }
          RecyclerView.LayoutManager localLayoutManager = ((ScanProductMaskDecorView.c)localObject1).mkw.getLayoutManager();
          if (localLayoutManager != null)
          {
            com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, locala.aYi(), "com/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ProductInfoAdapter", "addProductInfo", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;)V", "Undefined", "scrollToPosition", "(I)V");
            localLayoutManager.scrollToPosition(((Integer)locala.sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "com/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$ProductInfoAdapter", "addProductInfo", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;)V", "Undefined", "scrollToPosition", "(I)V");
          }
          Log.i("MicroMsg.ScanProductMaskDecorView", "addNewProduct trackId: " + localScanProductInfo.getId() + " pending insert");
          ((ScanProductMaskDecorView.c)localObject1).PgY.add(Integer.valueOf(localScanProductInfo.getId()));
        }
      }
      AppMethodBeat.o(314923);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanProductMaskDecorView$init$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductListLayout$ProductListCallBack;", "onProductListScrollStateChange", "", "state", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements ScanProductListLayout.b
  {
    h(ScanProductMaskDecorView paramScanProductMaskDecorView) {}
    
    public final void aix(int paramInt)
    {
      AppMethodBeat.i(314914);
      ScanProductMaskDecorView.a(this.Phd, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        ScanProductMaskDecorView.e locale = ScanProductMaskDecorView.b(this.Phd);
        if (locale != null) {
          locale.air(paramInt);
        }
        AppMethodBeat.o(314914);
        return;
        if (ScanProductMaskDecorView.a(this.Phd) != null)
        {
          continue;
          ScanProductMaskDecorView.a(this.Phd);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanProductMaskDecorView
 * JD-Core Version:    0.7.0.1
 */