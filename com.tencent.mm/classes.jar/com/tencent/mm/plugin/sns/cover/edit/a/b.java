package com.tencent.mm.plugin.sns.cover.edit.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a.a;
import com.tencent.mm.api.ac.c;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mediabasic.data.MediaResultInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaResultInfo.a;
import com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.util.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.footer.c;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverEffectImagePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "blurBitmapOffsetHeight", "", "boardView", "Lcom/tencent/mm/view/board/BaseBoardView;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "<set-?>", "", "isExportIng", "()Z", "outputHeight", "outputWidth", "parentLayout", "Landroid/widget/FrameLayout;", "getParentLayout", "()Landroid/widget/FrameLayout;", "parentLayout$delegate", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getPhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "photoEditor$delegate", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "source", "Landroid/graphics/Bitmap;", "blurBitmap", "", "bitmap", "width", "height", "validRect", "Landroid/graphics/Rect;", "calculateTargetSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "decodeSourceImg", "filePath", "", "exportCoverImage", "Lcom/tencent/mm/plugin/mediabasic/data/MediaResultInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLogic", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadImageBitmap", "path", "release", "saveBitmap", "Lcom/tencent/mm/plugin/mediabasic/data/MediaSingleInfo;", "cropRect", "type", "Lcom/tencent/mm/plugin/mediabasic/data/MediaBasicType;", "setup", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final b.a Qlk;
  private final j ATU;
  private com.tencent.mm.bt.b Lsg;
  public boolean Qll;
  private final j Qlm;
  private final j Qln;
  private int Qlo;
  private com.tencent.mm.view.b.a Qlp;
  private Bitmap Qlq;
  private int outputHeight;
  private int outputWidth;
  
  static
  {
    AppMethodBeat.i(307465);
    Qlk = new b.a((byte)0);
    AppMethodBeat.o(307465);
  }
  
  public b(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(307383);
    this.Qlm = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Qln = kotlin.k.cm((kotlin.g.a.a)f.Qlt);
    this.ATU = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(307383);
  }
  
  private static MediaSingleInfo a(Bitmap paramBitmap, Rect paramRect, String paramString, com.tencent.mm.plugin.mediabasic.data.a parama)
  {
    AppMethodBeat.i(307417);
    if (paramBitmap != null) {
      try
      {
        int k = Math.max(paramRect.left, 0);
        int m = Math.max(paramRect.top, 0);
        int i;
        if (paramRect.width() + k >= paramBitmap.getWidth())
        {
          i = paramBitmap.getWidth() - k;
          if (paramRect.height() + m < paramBitmap.getHeight()) {
            break label126;
          }
        }
        label126:
        for (int j = paramBitmap.getHeight() - m;; j = paramRect.height())
        {
          BitmapUtil.saveBitmapToImage(Bitmap.createBitmap(paramBitmap, k, m, i, j, null, false), 100, Bitmap.CompressFormat.JPEG, paramString, true);
          paramBitmap = new MediaSingleInfo(parama, paramString);
          AppMethodBeat.o(307417);
          return paramBitmap;
          i = paramRect.width();
          break;
        }
        AppMethodBeat.o(307417);
      }
      catch (Exception paramBitmap)
      {
        Log.printErrStackTrace("MicroMsg.SnsCoverEffectImagePlugin", (Throwable)paramBitmap, "saveBitmapToImage error", new Object[0]);
      }
    }
    return null;
  }
  
  private final void b(Bitmap paramBitmap, Rect paramRect)
  {
    AppMethodBeat.i(307410);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(307410);
      return;
    }
    heC().a(new ac.a.a().dR(false).dQ(false).t(new Rect(heB().getLeft(), heB().getTop(), heB().getRight(), heB().getBottom())).a(ac.c.heg).dS(false).z(paramBitmap).hee);
    paramBitmap = heC().cn(getContext());
    if (paramBitmap == null)
    {
      paramBitmap = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
      AppMethodBeat.o(307410);
      throw paramBitmap;
    }
    paramBitmap = (com.tencent.mm.view.m)paramBitmap;
    com.tencent.mm.view.b.a locala = paramBitmap.getBaseBoardView();
    this.Qlp = locala;
    locala.setScaleType(ImageView.ScaleType.CENTER_CROP);
    locala.setValidImageRect(paramRect);
    paramRect = (c)paramBitmap.getBaseFooterView();
    if (paramRect != null) {
      paramRect.setHideFooter(true);
    }
    this.Lsg = paramBitmap.getPresenter();
    paramRect = new FrameLayout.LayoutParams(-1, -1);
    heB().addView((View)paramBitmap, (ViewGroup.LayoutParams)paramRect);
    AppMethodBeat.o(307410);
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(307400);
    Context localContext = (Context)this.ATU.getValue();
    AppMethodBeat.o(307400);
    return localContext;
  }
  
  private final FrameLayout heB()
  {
    AppMethodBeat.i(307389);
    FrameLayout localFrameLayout = (FrameLayout)this.Qlm.getValue();
    AppMethodBeat.o(307389);
    return localFrameLayout;
  }
  
  private final ac heC()
  {
    AppMethodBeat.i(307394);
    ac localac = (ac)this.Qln.getValue();
    AppMethodBeat.o(307394);
    return localac;
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(307480);
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(paramRecordConfigProvider);
    this.outputWidth = paramRecordConfigProvider.oXZ.width;
    this.outputHeight = paramRecordConfigProvider.oXZ.height;
    Object localObject = paramRecordConfigProvider.NIf;
    this.Qlq = BitmapUtil.decodeFileWithSample((String)localObject, this.outputWidth, this.outputHeight, true);
    Bitmap localBitmap1 = this.Qlq;
    paramRecordConfigProvider = localBitmap1;
    int j;
    if (this.Qlq != null)
    {
      i = ForceGpuUtil.getMaxTextureSize();
      paramRecordConfigProvider = this.Qlq;
      s.checkNotNull(paramRecordConfigProvider);
      if (paramRecordConfigProvider.getWidth() <= i)
      {
        Bitmap localBitmap2 = this.Qlq;
        s.checkNotNull(localBitmap2);
        paramRecordConfigProvider = localBitmap1;
        if (localBitmap2.getHeight() <= i) {}
      }
      else
      {
        paramRecordConfigProvider = this.Qlq;
        s.checkNotNull(paramRecordConfigProvider);
        j = kotlin.k.k.qv(i, paramRecordConfigProvider.getWidth());
        localBitmap1 = this.Qlq;
        s.checkNotNull(localBitmap1);
        paramRecordConfigProvider = BitmapUtil.getCenterCropBitmap(paramRecordConfigProvider, j, kotlin.k.k.qv(i, localBitmap1.getHeight()), true);
      }
    }
    int i = BackwardSupportUtil.ExifHelper.getExifOrientation((String)localObject);
    Log.i("MicroMsg.SnsCoverEffectImagePlugin", s.X("getExifOrientation degree:", Integer.valueOf(i)));
    if (i == 0)
    {
      this.Qlq = paramRecordConfigProvider;
      localBitmap1 = this.Qlq;
      if (localBitmap1 == null) {
        break label510;
      }
      if (localBitmap1.getHeight() * 1.0F / localBitmap1.getWidth() >= 1.777778F) {
        break label503;
      }
      i = localBitmap1.getWidth();
      j = localBitmap1.getHeight();
      if (i * 1.0F / j <= 1.0F) {
        break label444;
      }
      if (j < this.outputWidth)
      {
        this.outputWidth = j;
        this.outputHeight = ((int)(this.outputWidth * 1.777778F));
      }
      paramRecordConfigProvider = new ad(i, (int)(j * 1.777778F));
    }
    for (;;)
    {
      localObject = new Rect(0, (paramRecordConfigProvider.height - localBitmap1.getHeight()) / 2, paramRecordConfigProvider.width, paramRecordConfigProvider.height - (paramRecordConfigProvider.height - localBitmap1.getHeight()) / 2);
      this.Qlo = (paramRecordConfigProvider.height - localBitmap1.getHeight());
      i = paramRecordConfigProvider.width;
      j = paramRecordConfigProvider.height;
      paramRecordConfigProvider = new com.tencent.mm.videocomposition.effect.a();
      paramRecordConfigProvider.HkF.agEB.scene = 1;
      paramRecordConfigProvider.setInputBitmap(localBitmap1);
      paramRecordConfigProvider.setOutputSize(i, j);
      paramRecordConfigProvider.HkF.GpO.jQk();
      paramRecordConfigProvider.aW((kotlin.g.a.b)new b(this, (Rect)localObject));
      AppMethodBeat.o(307480);
      return;
      paramRecordConfigProvider = BitmapUtil.rotateAndScale(paramRecordConfigProvider, i, 1.0F, 1.0F);
      break;
      label444:
      if (j * 1.0F / i < 1.777778F)
      {
        if (i < this.outputWidth) {
          this.outputWidth = i;
        }
        paramRecordConfigProvider = new ad(i, (int)(i * 1.777778F));
      }
      else
      {
        paramRecordConfigProvider = new ad(i, j);
      }
    }
    label503:
    b(localBitmap1, null);
    label510:
    AppMethodBeat.o(307480);
  }
  
  public final void release()
  {
    AppMethodBeat.i(307484);
    super.release();
    com.tencent.mm.bt.b localb = this.Lsg;
    if (localb != null) {
      localb.onDestroy();
    }
    AppMethodBeat.o(307484);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "effectBitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    b(b paramb, Rect paramRect)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Context>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mediabasic/data/MediaResultInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super MediaResultInfo>, Object>
  {
    int label;
    
    public d(b paramb, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(307405);
      paramObject = (kotlin.d.d)new d(this.Qlr, paramd);
      AppMethodBeat.o(307405);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      boolean bool = false;
      AppMethodBeat.i(307399);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(307399);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if ((b.a(this.Qlr) == null) || (b.b(this.Qlr) == null))
      {
        paramObject = MediaResultInfo.KOL;
        paramObject = MediaResultInfo.a.gaG();
        AppMethodBeat.o(307399);
        return paramObject;
      }
      paramObject = b.a(this.Qlr);
      s.checkNotNull(paramObject);
      int i = paramObject.getWidth();
      paramObject = b.a(this.Qlr);
      s.checkNotNull(paramObject);
      int j = paramObject.getHeight();
      localObject1 = new Rect();
      paramObject = new Rect();
      ((Rect)localObject1).left = 0;
      ((Rect)localObject1).right = i;
      ((Rect)localObject1).top = ((j - i) / 2);
      ((Rect)localObject1).bottom = (j - ((Rect)localObject1).top);
      paramObject.left = 0;
      paramObject.right = i;
      paramObject.top = 0;
      paramObject.bottom = j;
      Object localObject2 = b.a(this.Qlr);
      s.checkNotNull(localObject2);
      Object localObject3 = new Matrix(((com.tencent.mm.view.b.a)localObject2).getMainMatrix());
      if (b.c(this.Qlr) != 0)
      {
        localObject2 = new float[9];
        ((Matrix)localObject3).getValues((float[])localObject2);
        ((Matrix)localObject3).postTranslate(0.0F, localObject2[0] * b.c(this.Qlr) / 2.0F);
      }
      localObject2 = new Matrix();
      ((Matrix)localObject3).invert((Matrix)localObject2);
      localObject3 = new RectF((Rect)localObject1);
      ((Matrix)localObject2).mapRect((RectF)localObject3);
      ((RectF)localObject3).round((Rect)localObject1);
      localObject1 = new RectF(paramObject);
      ((Matrix)localObject2).mapRect((RectF)localObject1);
      ((RectF)localObject1).round(paramObject);
      localObject1 = new ArrayList();
      localObject2 = b.b(this.Qlr);
      localObject3 = e.Obp;
      paramObject = b.b((Bitmap)localObject2, paramObject, e.getTmpFilePath("sns_cover_img"), com.tencent.mm.plugin.mediabasic.data.a.KOB);
      if (paramObject != null) {
        ((ArrayList)localObject1).add(paramObject);
      }
      if (((ArrayList)localObject1).size() > 0) {
        bool = true;
      }
      paramObject = new MediaResultInfo(bool, (ArrayList)localObject1);
      AppMethodBeat.o(307399);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ac>
  {
    public static final f Qlt;
    
    static
    {
      AppMethodBeat.i(307393);
      Qlt = new f();
      AppMethodBeat.o(307393);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.edit.a.b
 * JD-Core Version:    0.7.0.1
 */