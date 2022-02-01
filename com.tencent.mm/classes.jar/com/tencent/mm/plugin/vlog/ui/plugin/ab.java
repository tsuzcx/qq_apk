package com.tencent.mm.plugin.vlog.ui.plugin;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/ThumbLoadingPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "thumbView", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "loadingState", "", "getThumbView", "()Landroid/widget/ImageView;", "setThumbView", "(Landroid/widget/ImageView;)V", "getScale", "", "width", "height", "isFullScreen", "", "getSourceHeight", "scale", "getSourceWidth", "hideLoading", "", "setTranslateY", "distance", "showLoading", "strRes", "fromThumbLoading", "showThumbLoading", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final ab.a Ujy;
  public ImageView AlJ;
  private int Ujz;
  private final Context context;
  private w rYw;
  
  static
  {
    AppMethodBeat.i(282832);
    Ujy = new ab.a((byte)0);
    AppMethodBeat.o(282832);
  }
  
  public ab(ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282675);
    this.AlJ = paramImageView;
    this.context = this.AlJ.getContext();
    this.Ujz = -1;
    AppMethodBeat.o(282675);
  }
  
  private static final void a(ab paramab, String paramString)
  {
    AppMethodBeat.i(282701);
    s.u(paramab, "this$0");
    s.u(paramString, "$tip");
    paramab.rYw = com.tencent.mm.ui.base.k.a(paramab.context, paramString, false, null);
    AppMethodBeat.o(282701);
  }
  
  public final void bZ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(282848);
    Log.i("MicroMsg.ThumbLoadingPlugin", s.X("showDialog, fromThumbLoading:", Boolean.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.Ujz != 1))
    {
      Log.i("MicroMsg.ThumbLoadingPlugin", "showDialog state error ignore");
      AppMethodBeat.o(282848);
      return;
    }
    if (paramInt < 0) {}
    Context localContext;
    for (Object localObject = this.context.getString(a.i.loading_tips);; localObject = this.context.getString(paramInt))
    {
      s.s(localObject, "if (strRes < 0) {\n      …tString(strRes)\n        }");
      this.Ujz = 2;
      localContext = this.context;
      if (localContext != null) {
        break;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(282848);
      throw ((Throwable)localObject);
    }
    ((Activity)localContext).runOnUiThread(new ab..ExternalSyntheticLambda0(this, (String)localObject));
    AppMethodBeat.o(282848);
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(282850);
    Log.i("MicroMsg.ThumbLoadingPlugin", "hideLoading");
    j.a((aq)bu.ajwo, (f)bg.kCh(), null, (m)new b(this, null), 2);
    AppMethodBeat.o(282850);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(ab paramab, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(283091);
      paramObject = (kotlin.d.d)new b(this.UjA, paramd);
      AppMethodBeat.o(283091);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(283082);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(283082);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      ab.b(this.UjA, 3);
      this.UjA.AlJ.setVisibility(8);
      paramObject = ab.b(this.UjA);
      if (paramObject != null) {
        paramObject.dismiss();
      }
      ab.c(this.UjA);
      paramObject = ah.aiuX;
      AppMethodBeat.o(283082);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    c(ab paramab, int paramInt, boolean paramBoolean, GalleryItem.MediaItem paramMediaItem, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(283101);
      paramObject = (kotlin.d.d)new c(this.UjA, this.UjB, this.UjC, this.UjD, paramd);
      AppMethodBeat.o(283101);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(283096);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject2;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(283096);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        ab.b(this.UjA, 1);
        paramObject = new ah.f();
        localObject1 = (f)bg.kCi();
        localObject2 = (m)new a(this.UjD, null);
        localObject3 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = paramObject;
        this.label = 1;
        localObject2 = l.a((f)localObject1, (m)localObject2, (kotlin.d.d)localObject3);
        if (localObject2 == locala)
        {
          AppMethodBeat.o(283096);
          return locala;
        }
        break;
      case 1: 
        localObject3 = (ah.f)this.Uf;
        localObject1 = (ah.f)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject2 = paramObject;
        paramObject = localObject1;
      }
      for (Object localObject1 = localObject3;; localObject1 = paramObject)
      {
        ((ah.f)localObject1).aqH = localObject2;
        if ((paramObject.aqH == null) || (((Bitmap)paramObject.aqH).isRecycled()))
        {
          Log.i("MicroMsg.ThumbLoadingPlugin", "cannot user memory thumb");
          localObject1 = (f)bg.kCi();
          localObject2 = (m)new kotlin.d.b.a.k(this.UjD, null)
          {
            int label;
            
            public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
            {
              AppMethodBeat.i(282555);
              paramAnonymousObject = (kotlin.d.d)new 1(this.UjD, paramAnonymousd);
              AppMethodBeat.o(282555);
              return paramAnonymousObject;
            }
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(282545);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(282545);
                throw paramAnonymousObject;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              if (this.UjD.getType() == 2)
              {
                paramAnonymousObject = com.tencent.mm.plugin.mmsight.d.Pf(this.UjD.Gcc);
                AppMethodBeat.o(282545);
                return paramAnonymousObject;
              }
              paramAnonymousObject = BitmapUtil.getBitmapNative(this.UjD.Gcc);
              AppMethodBeat.o(282545);
              return paramAnonymousObject;
            }
          };
          localObject3 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.Uf = paramObject;
          this.label = 2;
          localObject2 = l.a((f)localObject1, (m)localObject2, (kotlin.d.d)localObject3);
          if (localObject2 == locala)
          {
            AppMethodBeat.o(283096);
            return locala;
            localObject1 = (ah.f)this.Uf;
            localObject3 = (ah.f)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject2 = paramObject;
            paramObject = localObject3;
            ((ah.f)localObject1).aqH = localObject2;
          }
        }
        for (;;)
        {
          if (paramObject.aqH == null)
          {
            Log.e("MicroMsg.ThumbLoadingPlugin", "thumb still null");
            this.UjA.bZ(this.UjB, true);
            paramObject = ah.aiuX;
            AppMethodBeat.o(283096);
            return paramObject;
          }
          float f = ab.a(this.UjA, ((Bitmap)paramObject.aqH).getWidth(), ((Bitmap)paramObject.aqH).getHeight(), this.UjC);
          Log.i("MicroMsg.ThumbLoadingPlugin", s.X("calculate thumb scale ", Float.valueOf(f)));
          if (f >= 0.999D)
          {
            localObject1 = paramObject;
            if (f <= 1.001D) {}
          }
          else
          {
            localObject2 = new Matrix();
            ((Matrix)localObject2).reset();
            int i = ab.a(this.UjA, ((Bitmap)paramObject.aqH).getWidth(), f);
            int j = ab.b(this.UjA, ((Bitmap)paramObject.aqH).getHeight(), f);
            localObject1 = (f)bg.kCi();
            localObject2 = (m)new ab.c.2(paramObject, i, j, (Matrix)localObject2, null);
            localObject3 = (kotlin.d.d)this;
            this.L$0 = paramObject;
            this.Uf = paramObject;
            this.label = 3;
            localObject2 = l.a((f)localObject1, (m)localObject2, (kotlin.d.d)localObject3);
            if (localObject2 != locala) {
              break label662;
            }
            AppMethodBeat.o(283096);
            return locala;
            localObject3 = (ah.f)this.Uf;
            localObject1 = (ah.f)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject2 = paramObject;
            paramObject = localObject1;
          }
          label662:
          for (localObject1 = localObject3;; localObject1 = paramObject)
          {
            ((ah.f)localObject1).aqH = localObject2;
            localObject1 = paramObject;
            if (ab.a(this.UjA) == 1)
            {
              this.UjA.AlJ.setImageBitmap((Bitmap)((ah.f)localObject1).aqH);
              this.UjA.AlJ.setVisibility(0);
              this.UjA.bZ(this.UjB, true);
            }
            paramObject = ah.aiuX;
            AppMethodBeat.o(283096);
            return paramObject;
          }
          localObject1 = paramObject;
          break;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super Bitmap>, Object>
    {
      int label;
      
      a(GalleryItem.MediaItem paramMediaItem, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(282446);
        paramObject = (kotlin.d.d)new a(this.UjD, paramd);
        AppMethodBeat.o(282446);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(282440);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(282440);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = e.fAm().a(this.UjD.Gcc, this.UjD.Gcc, null, this.UjD.HHK);
        AppMethodBeat.o(282440);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ab
 * JD-Core Version:    0.7.0.1
 */