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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import d.d.a.a;
import d.d.b.a.j;
import d.g.a.m;
import d.g.b.y.f;
import d.l;
import d.v;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/ThumbLoadingPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "thumbView", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "loadingState", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getThumbView", "()Landroid/widget/ImageView;", "setThumbView", "(Landroid/widget/ImageView;)V", "getScale", "", "width", "height", "getSourceHeight", "scale", "getSourceWidth", "hideLoading", "", "setTranslateY", "distance", "showLoading", "strRes", "fromThumbLoading", "", "showThumbLoading", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Companion", "plugin-vlog_release"})
public final class z
  implements t
{
  public static final z.a BOj;
  private int BOi;
  private final Context context;
  private com.tencent.mm.ui.base.p mCn;
  public ImageView rAT;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  
  static
  {
    AppMethodBeat.i(196371);
    BOj = new z.a((byte)0);
    AppMethodBeat.o(196371);
  }
  
  public z(ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(196370);
    this.rAT = paramImageView;
    this.sQE = paramd;
    this.context = this.rAT.getContext();
    this.BOi = -1;
    AppMethodBeat.o(196370);
  }
  
  public final void aL(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(196367);
    ad.i("MicroMsg.ThumbLoadingPlugin", "showDialog, fromThumbLoading:".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.BOi != 1))
    {
      ad.i("MicroMsg.ThumbLoadingPlugin", "showDialog state error ignore");
      AppMethodBeat.o(196367);
      return;
    }
    if (paramInt < 0) {}
    Context localContext;
    for (Object localObject = this.context.getString(2131760709);; localObject = this.context.getString(paramInt))
    {
      this.BOi = 2;
      localContext = this.context;
      if (localContext != null) {
        break;
      }
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(196367);
      throw ((Throwable)localObject);
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, (String)localObject));
    AppMethodBeat.o(196367);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final void hideLoading()
  {
    AppMethodBeat.i(196369);
    ad.i("MicroMsg.ThumbLoadingPlugin", "hideLoading");
    kotlinx.coroutines.f.b((ah)bk.NII, (d.d.f)az.gvo(), (m)new b(this, null), 2);
    AppMethodBeat.o(196369);
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
    AppMethodBeat.i(196372);
    d.g.b.p.h(paramArrayOfString, "permissions");
    d.g.b.p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196372);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.plugin.ThumbLoadingPlugin$hideLoading$1", f="ThumbLoadingPlugin.kt", gfL={}, m="invokeSuspend")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ah, d.d.d<? super d.z>, Object>
  {
    int label;
    private ah nWQ;
    
    b(z paramz, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(196351);
      d.g.b.p.h(paramd, "completion");
      paramd = new b(this.BOk, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(196351);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(196350);
      paramObject = a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196350);
        throw paramObject;
      }
      z.a(this.BOk, 3);
      this.BOk.rAT.setVisibility(8);
      paramObject = z.b(this.BOk);
      if (paramObject != null) {
        paramObject.dismiss();
      }
      z.a(this.BOk, null);
      paramObject = d.z.MKo;
      AppMethodBeat.o(196350);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196352);
      paramObject1 = ((b)a(paramObject1, (d.d.d)paramObject2)).cQ(d.z.MKo);
      AppMethodBeat.o(196352);
      return paramObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(z paramz, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(196353);
      z.a(this.BOk, h.b(z.c(this.BOk), this.gVJ, false, null));
      AppMethodBeat.o(196353);
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.plugin.ThumbLoadingPlugin$showThumbLoading$1", f="ThumbLoadingPlugin.kt", gfL={53, 59, 82}, m="invokeSuspend")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends j
    implements m<ah, d.d.d<? super d.z>, Object>
  {
    float BOl;
    int label;
    private ah nWQ;
    Object nWR;
    Object olg;
    Object olh;
    Object oli;
    int olr;
    int ols;
    
    d(z paramz, GalleryItem.MediaItem paramMediaItem, int paramInt, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(196364);
      d.g.b.p.h(paramd, "completion");
      paramd = new d(this.BOk, this.BOm, this.BOn, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(196364);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(196363);
      a locala = a.MLc;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196363);
        throw paramObject;
      case 0: 
        localObject1 = this.nWQ;
        z.a(this.BOk, 1);
        paramObject = new y.f();
        localObject2 = (d.d.f)az.gvp();
        localObject3 = (m)new a(this, null);
        this.nWR = localObject1;
        this.olg = paramObject;
        this.olh = paramObject;
        this.label = 1;
        localObject2 = kotlinx.coroutines.g.a((d.d.f)localObject2, (m)localObject3, this);
        if (localObject2 == locala)
        {
          AppMethodBeat.o(196363);
          return locala;
        }
        break;
      case 1: 
        localObject3 = (y.f)this.olh;
        localObject4 = (y.f)this.olg;
        localObject1 = (ah)this.nWR;
        localObject2 = paramObject;
        paramObject = localObject4;
      }
      for (;;)
      {
        ((y.f)localObject3).MLV = ((Bitmap)localObject2);
        if (((Bitmap)paramObject.MLV == null) || (((Bitmap)paramObject.MLV).isRecycled()))
        {
          ad.i("MicroMsg.ThumbLoadingPlugin", "cannot user memory thumb");
          localObject2 = (d.d.f)az.gvp();
          localObject3 = (m)new j(null)
          {
            int label;
            private ah nWQ;
            
            public final d.d.d<d.z> a(Object paramAnonymousObject, d.d.d<?> paramAnonymousd)
            {
              AppMethodBeat.i(196355);
              d.g.b.p.h(paramAnonymousd, "completion");
              paramAnonymousd = new 1(this.BOo, paramAnonymousd);
              paramAnonymousd.nWQ = ((ah)paramAnonymousObject);
              AppMethodBeat.o(196355);
              return paramAnonymousd;
            }
            
            public final Object cQ(Object paramAnonymousObject)
            {
              AppMethodBeat.i(196354);
              paramAnonymousObject = a.MLc;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(196354);
                throw paramAnonymousObject;
              }
              if (this.BOo.BOm.getType() == 2)
              {
                paramAnonymousObject = com.tencent.mm.plugin.mmsight.d.Gq(this.BOo.BOm.cVj());
                AppMethodBeat.o(196354);
                return paramAnonymousObject;
              }
              paramAnonymousObject = com.tencent.mm.sdk.platformtools.g.aQf(this.BOo.BOm.cVj());
              AppMethodBeat.o(196354);
              return paramAnonymousObject;
            }
            
            public final Object p(Object paramAnonymousObject1, Object paramAnonymousObject2)
            {
              AppMethodBeat.i(196356);
              paramAnonymousObject1 = ((1)a(paramAnonymousObject1, (d.d.d)paramAnonymousObject2)).cQ(d.z.MKo);
              AppMethodBeat.o(196356);
              return paramAnonymousObject1;
            }
          };
          this.nWR = localObject1;
          this.olg = paramObject;
          this.olh = paramObject;
          this.label = 2;
          localObject2 = kotlinx.coroutines.g.a((d.d.f)localObject2, (m)localObject3, this);
          if (localObject2 == locala)
          {
            AppMethodBeat.o(196363);
            return locala;
            localObject3 = (y.f)this.olh;
            localObject4 = (y.f)this.olg;
            localObject1 = (ah)this.nWR;
            localObject2 = paramObject;
            paramObject = localObject4;
            ((y.f)localObject3).MLV = ((Bitmap)localObject2);
          }
        }
        for (;;)
        {
          if ((Bitmap)paramObject.MLV == null)
          {
            ad.e("MicroMsg.ThumbLoadingPlugin", "thumb still null");
            this.BOk.aL(this.BOn, true);
            paramObject = d.z.MKo;
            AppMethodBeat.o(196363);
            return paramObject;
          }
          float f = z.a(this.BOk, ((Bitmap)paramObject.MLV).getWidth(), ((Bitmap)paramObject.MLV).getHeight());
          ad.i("MicroMsg.ThumbLoadingPlugin", "calculate thumb scale ".concat(String.valueOf(f)));
          if (f >= 0.999D)
          {
            localObject2 = paramObject;
            if (f <= 1.001D) {}
          }
          else
          {
            localObject2 = new Matrix();
            ((Matrix)localObject2).reset();
            int i = z.a(this.BOk, ((Bitmap)paramObject.MLV).getWidth(), f);
            int j = z.b(this.BOk, ((Bitmap)paramObject.MLV).getHeight(), f);
            localObject3 = (d.d.f)az.gvp();
            localObject4 = (m)new z.d.2(paramObject, i, j, (Matrix)localObject2, null);
            this.nWR = localObject1;
            this.olg = paramObject;
            this.BOl = f;
            this.olh = localObject2;
            this.olr = i;
            this.ols = j;
            this.oli = paramObject;
            this.label = 3;
            localObject1 = kotlinx.coroutines.g.a((d.d.f)localObject3, (m)localObject4, this);
            if (localObject1 != locala) {
              break label675;
            }
            AppMethodBeat.o(196363);
            return locala;
            localObject2 = (y.f)this.oli;
            localObject3 = (y.f)this.olg;
            localObject1 = paramObject;
            paramObject = localObject3;
          }
          for (;;)
          {
            ((y.f)localObject2).MLV = ((Bitmap)localObject1);
            localObject2 = paramObject;
            this.BOk.rAT.setImageBitmap((Bitmap)((y.f)localObject2).MLV);
            this.BOk.rAT.setVisibility(0);
            this.BOk.aL(this.BOn, true);
            paramObject = d.z.MKo;
            AppMethodBeat.o(196363);
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
      AppMethodBeat.i(196365);
      paramObject1 = ((d)a(paramObject1, (d.d.d)paramObject2)).cQ(d.z.MKo);
      AppMethodBeat.o(196365);
      return paramObject1;
    }
    
    @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.plugin.ThumbLoadingPlugin$showThumbLoading$1$thumb$1", f="ThumbLoadingPlugin.kt", gfL={}, m="invokeSuspend")
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends j
      implements m<ah, d.d.d<? super Bitmap>, Object>
    {
      int label;
      private ah nWQ;
      
      a(z.d paramd, d.d.d paramd1)
      {
        super();
      }
      
      public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(196361);
        d.g.b.p.h(paramd, "completion");
        paramd = new a(this.BOo, paramd);
        paramd.nWQ = ((ah)paramObject);
        AppMethodBeat.o(196361);
        return paramd;
      }
      
      public final Object cQ(Object paramObject)
      {
        AppMethodBeat.i(196360);
        paramObject = a.MLc;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(196360);
          throw paramObject;
        }
        paramObject = e.cUL().a(this.BOo.BOm.cVj(), this.BOo.BOm.cVj(), null, this.BOo.BOm.tGW);
        AppMethodBeat.o(196360);
        return paramObject;
      }
      
      public final Object p(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(196362);
        paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cQ(d.z.MKo);
        AppMethodBeat.o(196362);
        return paramObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.z
 * JD-Core Version:    0.7.0.1
 */