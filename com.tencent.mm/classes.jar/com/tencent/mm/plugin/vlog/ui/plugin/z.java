package com.tencent.mm.plugin.vlog.ui.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.d.a.a;
import d.d.b.a.j;
import d.g.a.m;
import d.g.b.y.f;
import d.l;
import d.v;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;
import kotlinx.coroutines.g;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/ThumbLoadingPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "thumbView", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "loadingState", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getThumbView", "()Landroid/widget/ImageView;", "setThumbView", "(Landroid/widget/ImageView;)V", "getScale", "", "width", "height", "getSourceHeight", "scale", "getSourceWidth", "hideLoading", "", "setTranslateY", "distance", "showLoading", "strRes", "fromThumbLoading", "", "showThumbLoading", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Companion", "plugin-vlog_release"})
public final class z
  implements t
{
  public static final z.a CfI;
  private int CfH;
  private final Context context;
  private com.tencent.mm.ui.base.p mHs;
  public ImageView rJe;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  
  static
  {
    AppMethodBeat.i(191830);
    CfI = new z.a((byte)0);
    AppMethodBeat.o(191830);
  }
  
  public z(ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(191829);
    this.rJe = paramImageView;
    this.tbP = paramd;
    this.context = this.rJe.getContext();
    this.CfH = -1;
    AppMethodBeat.o(191829);
  }
  
  public final void aO(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(191826);
    ae.i("MicroMsg.ThumbLoadingPlugin", "showDialog, fromThumbLoading:".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.CfH != 1))
    {
      ae.i("MicroMsg.ThumbLoadingPlugin", "showDialog state error ignore");
      AppMethodBeat.o(191826);
      return;
    }
    if (paramInt < 0) {}
    Context localContext;
    for (Object localObject = this.context.getString(2131760709);; localObject = this.context.getString(paramInt))
    {
      this.CfH = 2;
      localContext = this.context;
      if (localContext != null) {
        break;
      }
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(191826);
      throw ((Throwable)localObject);
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, (String)localObject));
    AppMethodBeat.o(191826);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final void hideLoading()
  {
    AppMethodBeat.i(191828);
    ae.i("MicroMsg.ThumbLoadingPlugin", "hideLoading");
    kotlinx.coroutines.f.b((ah)bk.OfO, (d.d.f)az.gzQ(), (m)new b(this, null), 2);
    AppMethodBeat.o(191828);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191831);
    d.g.b.p.h(paramArrayOfString, "permissions");
    d.g.b.p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191831);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.plugin.ThumbLoadingPlugin$hideLoading$1", f="ThumbLoadingPlugin.kt", gkn={}, m="invokeSuspend")
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ah, d.d.d<? super d.z>, Object>
  {
    int label;
    private ah ocz;
    
    b(z paramz, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(191810);
      d.g.b.p.h(paramd, "completion");
      paramd = new b(this.CfJ, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(191810);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(191809);
      paramObject = a.Nif;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191809);
        throw paramObject;
      }
      z.a(this.CfJ, 3);
      this.CfJ.rJe.setVisibility(8);
      paramObject = z.b(this.CfJ);
      if (paramObject != null) {
        paramObject.dismiss();
      }
      z.a(this.CfJ, null);
      paramObject = d.z.Nhr;
      AppMethodBeat.o(191809);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(191811);
      paramObject1 = ((b)a(paramObject1, (d.d.d)paramObject2)).cR(d.z.Nhr);
      AppMethodBeat.o(191811);
      return paramObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(z paramz, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(191812);
      z.a(this.CfJ, com.tencent.mm.ui.base.h.b(z.c(this.CfJ), this.gYs, false, null));
      AppMethodBeat.o(191812);
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.plugin.ThumbLoadingPlugin$showThumbLoading$1", f="ThumbLoadingPlugin.kt", gkn={53, 59, 82}, m="invokeSuspend")
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends j
    implements m<ah, d.d.d<? super d.z>, Object>
  {
    float CfK;
    int label;
    Object ocA;
    private ah ocz;
    Object oqW;
    Object oqX;
    Object oqY;
    int orh;
    int ori;
    
    d(z paramz, GalleryItem.MediaItem paramMediaItem, int paramInt, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(191823);
      d.g.b.p.h(paramd, "completion");
      paramd = new d(this.CfJ, this.CfL, this.CfM, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(191823);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(191822);
      a locala = a.Nif;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191822);
        throw paramObject;
      case 0: 
        localObject1 = this.ocz;
        z.a(this.CfJ, 1);
        paramObject = new y.f();
        localObject2 = (d.d.f)az.gzR();
        localObject3 = (m)new a(this, null);
        this.ocA = localObject1;
        this.oqW = paramObject;
        this.oqX = paramObject;
        this.label = 1;
        localObject2 = g.a((d.d.f)localObject2, (m)localObject3, this);
        if (localObject2 == locala)
        {
          AppMethodBeat.o(191822);
          return locala;
        }
        break;
      case 1: 
        localObject3 = (y.f)this.oqX;
        localObject4 = (y.f)this.oqW;
        localObject1 = (ah)this.ocA;
        localObject2 = paramObject;
        paramObject = localObject4;
      }
      for (;;)
      {
        ((y.f)localObject3).NiY = ((Bitmap)localObject2);
        if (((Bitmap)paramObject.NiY == null) || (((Bitmap)paramObject.NiY).isRecycled()))
        {
          ae.i("MicroMsg.ThumbLoadingPlugin", "cannot user memory thumb");
          localObject2 = (d.d.f)az.gzR();
          localObject3 = (m)new j(null)
          {
            int label;
            private ah ocz;
            
            public final d.d.d<d.z> a(Object paramAnonymousObject, d.d.d<?> paramAnonymousd)
            {
              AppMethodBeat.i(191814);
              d.g.b.p.h(paramAnonymousd, "completion");
              paramAnonymousd = new 1(this.CfN, paramAnonymousd);
              paramAnonymousd.ocz = ((ah)paramAnonymousObject);
              AppMethodBeat.o(191814);
              return paramAnonymousd;
            }
            
            public final Object cR(Object paramAnonymousObject)
            {
              AppMethodBeat.i(191813);
              paramAnonymousObject = a.Nif;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(191813);
                throw paramAnonymousObject;
              }
              if (this.CfN.CfL.getType() == 2)
              {
                paramAnonymousObject = com.tencent.mm.plugin.mmsight.d.GS(this.CfN.CfL.cXO());
                AppMethodBeat.o(191813);
                return paramAnonymousObject;
              }
              paramAnonymousObject = com.tencent.mm.sdk.platformtools.h.aRC(this.CfN.CfL.cXO());
              AppMethodBeat.o(191813);
              return paramAnonymousObject;
            }
            
            public final Object p(Object paramAnonymousObject1, Object paramAnonymousObject2)
            {
              AppMethodBeat.i(191815);
              paramAnonymousObject1 = ((1)a(paramAnonymousObject1, (d.d.d)paramAnonymousObject2)).cR(d.z.Nhr);
              AppMethodBeat.o(191815);
              return paramAnonymousObject1;
            }
          };
          this.ocA = localObject1;
          this.oqW = paramObject;
          this.oqX = paramObject;
          this.label = 2;
          localObject2 = g.a((d.d.f)localObject2, (m)localObject3, this);
          if (localObject2 == locala)
          {
            AppMethodBeat.o(191822);
            return locala;
            localObject3 = (y.f)this.oqX;
            localObject4 = (y.f)this.oqW;
            localObject1 = (ah)this.ocA;
            localObject2 = paramObject;
            paramObject = localObject4;
            ((y.f)localObject3).NiY = ((Bitmap)localObject2);
          }
        }
        for (;;)
        {
          if ((Bitmap)paramObject.NiY == null)
          {
            ae.e("MicroMsg.ThumbLoadingPlugin", "thumb still null");
            this.CfJ.aO(this.CfM, true);
            paramObject = d.z.Nhr;
            AppMethodBeat.o(191822);
            return paramObject;
          }
          float f = z.a(this.CfJ, ((Bitmap)paramObject.NiY).getWidth(), ((Bitmap)paramObject.NiY).getHeight());
          ae.i("MicroMsg.ThumbLoadingPlugin", "calculate thumb scale ".concat(String.valueOf(f)));
          if (f >= 0.999D)
          {
            localObject2 = paramObject;
            if (f <= 1.001D) {}
          }
          else
          {
            localObject2 = new Matrix();
            ((Matrix)localObject2).reset();
            int i = z.a(this.CfJ, ((Bitmap)paramObject.NiY).getWidth(), f);
            int j = z.b(this.CfJ, ((Bitmap)paramObject.NiY).getHeight(), f);
            localObject3 = (d.d.f)az.gzR();
            localObject4 = (m)new z.d.2(paramObject, i, j, (Matrix)localObject2, null);
            this.ocA = localObject1;
            this.oqW = paramObject;
            this.CfK = f;
            this.oqX = localObject2;
            this.orh = i;
            this.ori = j;
            this.oqY = paramObject;
            this.label = 3;
            localObject1 = g.a((d.d.f)localObject3, (m)localObject4, this);
            if (localObject1 != locala) {
              break label675;
            }
            AppMethodBeat.o(191822);
            return locala;
            localObject2 = (y.f)this.oqY;
            localObject3 = (y.f)this.oqW;
            localObject1 = paramObject;
            paramObject = localObject3;
          }
          for (;;)
          {
            ((y.f)localObject2).NiY = ((Bitmap)localObject1);
            localObject2 = paramObject;
            this.CfJ.rJe.setImageBitmap((Bitmap)((y.f)localObject2).NiY);
            this.CfJ.rJe.setVisibility(0);
            this.CfJ.aO(this.CfM, true);
            paramObject = d.z.Nhr;
            AppMethodBeat.o(191822);
            return paramObject;
            label675:
            localObject2 = paramObject;
          }
          localObject3 = paramObject;
          break;
        }
        localObject3 = paramObject;
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(191824);
      paramObject1 = ((d)a(paramObject1, (d.d.d)paramObject2)).cR(d.z.Nhr);
      AppMethodBeat.o(191824);
      return paramObject1;
    }
    
    @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.plugin.ThumbLoadingPlugin$showThumbLoading$1$thumb$1", f="ThumbLoadingPlugin.kt", gkn={}, m="invokeSuspend")
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends j
      implements m<ah, d.d.d<? super Bitmap>, Object>
    {
      int label;
      private ah ocz;
      
      a(z.d paramd, d.d.d paramd1)
      {
        super();
      }
      
      public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(191820);
        d.g.b.p.h(paramd, "completion");
        paramd = new a(this.CfN, paramd);
        paramd.ocz = ((ah)paramObject);
        AppMethodBeat.o(191820);
        return paramd;
      }
      
      public final Object cR(Object paramObject)
      {
        AppMethodBeat.i(191819);
        paramObject = a.Nif;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(191819);
          throw paramObject;
        }
        paramObject = e.cXq().a(this.CfN.CfL.cXO(), this.CfN.CfL.cXO(), null, this.CfN.CfL.tRN);
        AppMethodBeat.o(191819);
        return paramObject;
      }
      
      public final Object p(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(191821);
        paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cR(d.z.Nhr);
        AppMethodBeat.o(191821);
        return paramObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.z
 * JD-Core Version:    0.7.0.1
 */