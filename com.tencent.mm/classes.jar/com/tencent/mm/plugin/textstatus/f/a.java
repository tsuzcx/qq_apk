package com.tencent.mm.plugin.textstatus.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.r;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.k.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/manager/StatusImgHandler;", "", "()V", "TAG", "", "downloadImgAndSet", "", "context", "Landroid/content/Context;", "iv", "Landroid/widget/ImageView;", "username", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "imgUrl", "filePath", "listener", "Lcom/tencent/mm/plugin/textstatus/manager/StatusImgHandler$OnSetImgFinishedListener;", "infoHash", "", "needSetDefWhenDownload", "", "downloadPicsAndSet", "getFinalBitmap", "Landroid/graphics/Bitmap;", "oriBitmap", "isBlur", "handleImgOnlyByUrl", "useThumb", "setHeaderView", "onlyUseThumb", "setImageWithGradient", "triggerDownloadThumb", "OnSetImgFinishedListener", "plugin-textstatus_release"})
public final class a
{
  public static final a MCH;
  
  static
  {
    AppMethodBeat.i(233497);
    MCH = new a();
    AppMethodBeat.o(233497);
  }
  
  public static void a(final Context paramContext, final ImageView paramImageView, final String paramString1, final com.tencent.mm.plugin.textstatus.g.e.a parama, final String paramString2, final String paramString3, final a parama1, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(233490);
    p.k(paramContext, "context");
    p.k(paramImageView, "iv");
    p.k(paramString1, "username");
    p.k(parama, "info");
    p.k(paramString3, "filePath");
    if (!Util.isNullOrNil(paramString2))
    {
      com.tencent.mm.ay.q.bmg();
      Object localObject = d.LI(paramString2);
      if (localObject == null)
      {
        if (u.agG(paramString3))
        {
          b.ah((kotlin.g.a.a)new b(paramString3, paramString2, paramImageView, parama, paramContext, parama1));
          AppMethodBeat.o(233490);
          return;
        }
        if (paramBoolean)
        {
          localObject = m.MOX;
          paramImageView.setImageResource(m.beP(parama.field_backgroundId));
        }
        localObject = parama.field_StatusID;
        long l = System.currentTimeMillis();
        com.tencent.mm.ay.q.bmk().a(paramString2, (r.a)new c(l, (String)localObject, paramString3, paramString1, paramString2, paramImageView, paramInt, parama, paramContext, parama1));
        AppMethodBeat.o(233490);
        return;
      }
      a(paramImageView, (Bitmap)localObject, parama.gma());
      if (parama1 != null)
      {
        parama1.glV();
        AppMethodBeat.o(233490);
        return;
      }
      AppMethodBeat.o(233490);
      return;
    }
    if (!Util.isNullOrNil(parama.field_backgroundId))
    {
      paramContext = m.MOX;
      paramImageView.setImageResource(m.beP(parama.field_backgroundId));
    }
    while (parama1 != null)
    {
      parama1.glV();
      AppMethodBeat.o(233490);
      return;
      if (u.agG(paramString3))
      {
        b.ah((kotlin.g.a.a)new d(paramString3, paramImageView, parama, paramContext));
      }
      else
      {
        paramContext = m.MOX;
        paramImageView.setImageResource(m.beP(parama.field_backgroundId));
      }
    }
    AppMethodBeat.o(233490);
  }
  
  private static void a(ImageView paramImageView, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(233489);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(233489);
      return;
    }
    paramImageView.post((Runnable)new a.i(paramBitmap, paramImageView, paramBoolean));
    AppMethodBeat.o(233489);
  }
  
  public static void a(final String paramString, com.tencent.mm.plugin.textstatus.g.e.a parama)
  {
    AppMethodBeat.i(233495);
    p.k(paramString, "username");
    p.k(parama, "info");
    int i = t.glp();
    if (i == 2)
    {
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "do not triggerDownloadThumb");
      AppMethodBeat.o(233495);
      return;
    }
    boolean bool;
    final String str;
    if ((i == 0) && (parama.field_MediaType == 1))
    {
      bool = false;
      if (bool != true) {
        break label225;
      }
      str = parama.field_MediaThumbUrl;
      label68:
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "trigger info: " + i + ", " + bool);
      if (!Util.isNullOrNil(str))
      {
        com.tencent.mm.ay.q.bmg();
        if (d.LI(str) == null)
        {
          localObject = com.tencent.mm.plugin.textstatus.k.f.MOw;
          if (!bool) {
            break label234;
          }
        }
      }
    }
    label225:
    label234:
    for (Object localObject = "thumb";; localObject = "image")
    {
      localObject = com.tencent.mm.plugin.textstatus.k.f.lD((String)localObject, paramString);
      if (!u.agG((String)localObject))
      {
        parama = parama.field_StatusID;
        Log.i("MicroMsg.TextStatus.StatusImgHandler", "triggerDownloadThumb start " + (String)localObject + ' ' + parama);
        com.tencent.mm.ay.q.bmk().a(str, (r.a)new j(parama, (String)localObject, paramString, str));
      }
      AppMethodBeat.o(233495);
      return;
      bool = true;
      break;
      str = parama.field_MediaUrl;
      break label68;
    }
  }
  
  public final void a(final Context paramContext, final String paramString, final ImageView paramImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(233486);
    p.k(paramContext, "context");
    p.k(paramString, "username");
    p.k(paramImageView, "iv");
    Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    final com.tencent.mm.plugin.textstatus.g.e.a locala = com.tencent.mm.plugin.textstatus.b.f.bep(paramString);
    if (locala == null)
    {
      AppMethodBeat.o(233486);
      return;
    }
    final int i = locala.hashCode();
    paramImageView.setTag(b.e.MuU, Integer.valueOf(i));
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = locala.field_MediaThumbUrl;
      localObject2 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      a(paramContext, paramImageView, paramString, locala, (String)localObject1, com.tencent.mm.plugin.textstatus.k.f.lD("thumb", paramString), null, i);
      AppMethodBeat.o(233486);
      return;
    }
    if (locala.field_MediaType == 2) {}
    Object localObject3;
    for (localObject1 = "";; localObject1 = locala.field_MediaUrl)
    {
      localObject2 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject2 = com.tencent.mm.plugin.textstatus.k.f.lD("image", paramString);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label229;
      }
      com.tencent.mm.ay.q.bmg();
      localObject3 = d.LI((String)localObject1);
      if (localObject3 == null) {
        break;
      }
      a(paramImageView, (Bitmap)localObject3, locala.gma());
      AppMethodBeat.o(233486);
      return;
    }
    if (u.agG((String)localObject2))
    {
      b.ah((kotlin.g.a.a)new e((String)localObject2, (String)localObject1, paramImageView, locala, paramContext));
      AppMethodBeat.o(233486);
      return;
    }
    label229:
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (localObject1 = null;; localObject1 = new f(paramContext, paramImageView, paramString, locala, (String)localObject1, (String)localObject2, i))
    {
      localObject2 = locala.field_MediaThumbUrl;
      localObject3 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject3 = com.tencent.mm.plugin.textstatus.k.f.lD("thumb", paramString);
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "begin download thumb");
      a(paramContext, paramImageView, paramString, locala, (String)localObject2, (String)localObject3, (a)localObject1, i);
      AppMethodBeat.o(233486);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/manager/StatusImgHandler$OnSetImgFinishedListener;", "", "onSetImgFinished", "", "plugin-textstatus_release"})
  public static abstract interface a
  {
    public abstract void glV();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(String paramString1, String paramString2, ImageView paramImageView, com.tencent.mm.plugin.textstatus.g.e.a parama, Context paramContext, a.a parama1)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
  static final class c
    implements r.a
  {
    c(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, ImageView paramImageView, int paramInt, com.tencent.mm.plugin.textstatus.g.e.a parama, Context paramContext, a.a parama1) {}
    
    public final void a(String paramString1, final Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(234632);
      if (paramBitmap == null)
      {
        AppMethodBeat.o(234632);
        return;
      }
      b.ah((kotlin.g.a.a)new kotlin.g.b.q(paramBitmap)
      {
        public final Object invoke()
        {
          AppMethodBeat.i(238633);
          Log.i("MicroMsg.TextStatus.StatusImgHandler", "handleImgUrl update " + (System.currentTimeMillis() - this.MCN.uyk) + ' ' + this.MCN.MCL + ' ' + this.MCN.pqJ);
          Object localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
          localObject = com.tencent.mm.plugin.textstatus.b.f.gly().bey(this.MCN.kyF);
          if (localObject != null)
          {
            if (Util.isEqual(this.MCN.MCL, ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_StatusID))
            {
              b.i(paramBitmap, this.MCN.pqJ);
              localObject = b.bes(this.MCN.pqJ);
              com.tencent.mm.ay.q.bmg();
              d.g(this.MCN.MCI, (Bitmap)localObject);
              boolean bool = this.MCN.MCJ.post((Runnable)new a((Bitmap)localObject, this));
              AppMethodBeat.o(238633);
              return Boolean.valueOf(bool);
            }
            Log.e("MicroMsg.TextStatus.StatusImgHandler", "handleImgUrl getLatest:" + ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_StatusID);
            localObject = x.aazN;
            AppMethodBeat.o(238633);
            return localObject;
          }
          Log.e("MicroMsg.TextStatus.StatusImgHandler", "handleImgUrl TextStatus is null");
          localObject = x.aazN;
          AppMethodBeat.o(238633);
          return localObject;
        }
        
        @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/textstatus/manager/StatusImgHandler$downloadImgAndSet$2$1$1$1"})
        static final class a
          implements Runnable
        {
          a(Bitmap paramBitmap, a.c.1 param1) {}
          
          public final void run()
          {
            AppMethodBeat.i(237515);
            if ((p.h(jdField_this.MCN.MCJ.getTag(b.e.MuU), Integer.valueOf(jdField_this.MCN.MCM)) ^ true))
            {
              AppMethodBeat.o(237515);
              return;
            }
            Object localObject = a.MCH;
            a.b(jdField_this.MCN.MCJ, this.yVk, jdField_this.MCN.MCF.gma());
            localObject = jdField_this.MCN.MCK;
            if (localObject != null)
            {
              ((a.a)localObject).glV();
              AppMethodBeat.o(237515);
              return;
            }
            AppMethodBeat.o(237515);
          }
        }
      });
      AppMethodBeat.o(234632);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(String paramString, ImageView paramImageView, com.tencent.mm.plugin.textstatus.g.e.a parama, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(String paramString1, String paramString2, ImageView paramImageView, com.tencent.mm.plugin.textstatus.g.e.a parama, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/manager/StatusImgHandler$downloadPicsAndSet$onSetImgListener$1", "Lcom/tencent/mm/plugin/textstatus/manager/StatusImgHandler$OnSetImgFinishedListener;", "onSetImgFinished", "", "plugin-textstatus_release"})
  public static final class f
    implements a.a
  {
    f(Context paramContext, ImageView paramImageView, String paramString1, com.tencent.mm.plugin.textstatus.g.e.a parama, String paramString2, String paramString3, int paramInt) {}
    
    public final void glV()
    {
      AppMethodBeat.i(232209);
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "begin download ori pic");
      a locala = a.MCH;
      a.a(this.$context, paramImageView, paramString, locala, this.MCQ, this.MCP, null, i, false);
      AppMethodBeat.o(232209);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(String paramString1, String paramString2, ImageView paramImageView, com.tencent.mm.plugin.textstatus.g.e.a parama, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
  static final class h
    implements r.a
  {
    h(String paramString1, com.tencent.mm.plugin.textstatus.g.e.a parama, String paramString2, ImageView paramImageView, int paramInt, Context paramContext) {}
    
    public final void a(String paramString1, final Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(233461);
      if (paramBitmap == null)
      {
        AppMethodBeat.o(233461);
        return;
      }
      b.ah((kotlin.g.a.a)new kotlin.g.b.q(paramBitmap) {});
      AppMethodBeat.o(233461);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
  static final class j
    implements r.a
  {
    j(String paramString1, String paramString2, String paramString3, String paramString4) {}
    
    public final void a(String paramString1, final Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(236212);
      if (paramBitmap == null)
      {
        AppMethodBeat.o(236212);
        return;
      }
      b.ah((kotlin.g.a.a)new kotlin.g.b.q(paramBitmap)
      {
        public final Object invoke()
        {
          AppMethodBeat.i(238539);
          Log.i("MicroMsg.TextStatus.StatusImgHandler", "triggerDownloadThumb update " + this.MCW.MCL + ' ' + this.MCW.pqJ);
          Object localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
          localObject = com.tencent.mm.plugin.textstatus.b.f.gly().bey(this.MCW.kyF);
          if (localObject != null)
          {
            if (Util.isEqual(this.MCW.MCL, ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_StatusID))
            {
              Log.i("MicroMsg.TextStatus.StatusImgHandler", "triggerDownloadThumb update " + this.MCW.pqJ + ' ' + this.MCW.MCL);
              b.i(paramBitmap, this.MCW.pqJ);
              localObject = b.bes(this.MCW.pqJ);
              com.tencent.mm.ay.q.bmg();
              d.g(this.MCW.MCI, (Bitmap)localObject);
            }
            for (;;)
            {
              localObject = x.aazN;
              AppMethodBeat.o(238539);
              return localObject;
              Log.e("MicroMsg.TextStatus.StatusImgHandler", "triggerDownloadThumb getLatest:" + ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_StatusID);
            }
          }
          Log.e("MicroMsg.TextStatus.StatusImgHandler", "triggerDownloadThumb TextStatus is null");
          localObject = x.aazN;
          AppMethodBeat.o(238539);
          return localObject;
        }
      });
      AppMethodBeat.o(236212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.a
 * JD-Core Version:    0.7.0.1
 */