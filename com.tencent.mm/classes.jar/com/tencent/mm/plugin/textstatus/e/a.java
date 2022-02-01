package com.tencent.mm.plugin.textstatus.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.plugin.textstatus.j.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/manager/StatusImgHandler;", "", "()V", "TAG", "", "getFinalBitmap", "Landroid/graphics/Bitmap;", "oriBitmap", "isBlur", "", "context", "Landroid/content/Context;", "handleImgOnlyByUrl", "", "iv", "Landroid/widget/ImageView;", "username", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "useThumb", "handleImgUrl", "saveBitmap", "bitmap", "path", "setHeaderView", "triggerDownloadThumb", "plugin-textstatus_release"})
public final class a
{
  public static final a FYI;
  
  static
  {
    AppMethodBeat.i(216169);
    FYI = new a();
    AppMethodBeat.o(216169);
  }
  
  private static Bitmap a(Bitmap paramBitmap, boolean paramBoolean, Context paramContext)
  {
    AppMethodBeat.i(216168);
    if ((paramBitmap == null) || (!paramBoolean))
    {
      AppMethodBeat.o(216168);
      return paramBitmap;
    }
    com.tencent.mm.plugin.textstatus.j.f localf = com.tencent.mm.plugin.textstatus.j.f.Ggk;
    paramBitmap = com.tencent.mm.plugin.textstatus.j.f.a(paramBitmap, paramContext, 10.0F);
    AppMethodBeat.o(216168);
    return paramBitmap;
  }
  
  public static void a(final Context paramContext, final String paramString, final ImageView paramImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(216164);
    p.h(paramContext, "context");
    p.h(paramString, "username");
    p.h(paramImageView, "iv");
    Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    final com.tencent.mm.plugin.textstatus.f.f.a locala = com.tencent.mm.plugin.textstatus.b.f.aTf(paramString);
    if (locala == null)
    {
      AppMethodBeat.o(216164);
      return;
    }
    p.h(paramContext, "context");
    p.h(paramImageView, "iv");
    p.h(paramString, "username");
    p.h(locala, "info");
    final int i = locala.hashCode();
    paramImageView.setTag(2131299785, Integer.valueOf(i));
    if (paramBoolean)
    {
      localObject1 = locala.field_MediaThumbUrl;
      if (Util.isNullOrNil((String)localObject1)) {
        break label289;
      }
      q.bcQ();
      localObject2 = com.tencent.mm.av.d.EP((String)localObject1);
      if (localObject2 != null) {
        break label268;
      }
      localObject2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
      if (!paramBoolean) {
        break label199;
      }
    }
    label199:
    for (Object localObject2 = "thumb";; localObject2 = "image")
    {
      localObject2 = com.tencent.mm.plugin.textstatus.j.a.lf((String)localObject2, paramString);
      if (!s.YS((String)localObject2)) {
        break label207;
      }
      paramString = BitmapUtil.decodeFileWithSample((String)localObject2);
      paramImageView.setImageBitmap(a(paramString, locala.fvV(), paramContext));
      q.bcQ();
      com.tencent.mm.av.d.g((String)localObject1, paramString);
      AppMethodBeat.o(216164);
      return;
      localObject1 = locala.field_MediaUrl;
      break;
    }
    label207:
    Object localObject3 = e.Ggj;
    paramImageView.setImageResource(e.aTr(locala.field_backgroundId));
    localObject3 = locala.field_StatusID;
    q.bcU().a((String)localObject1, (r.a)new b((String)localObject3, (String)localObject2, paramString, (String)localObject1, paramImageView, i, locala, paramContext));
    AppMethodBeat.o(216164);
    return;
    label268:
    paramImageView.setImageBitmap(a((Bitmap)localObject2, locala.fvV(), paramContext));
    AppMethodBeat.o(216164);
    return;
    label289:
    if (!Util.isNullOrNil(locala.field_backgroundId))
    {
      paramContext = e.Ggj;
      paramImageView.setImageResource(e.aTr(locala.field_backgroundId));
      AppMethodBeat.o(216164);
      return;
    }
    localObject1 = com.tencent.mm.plugin.textstatus.j.a.GfU;
    if (paramBoolean) {}
    for (localObject1 = "thumb";; localObject1 = "image")
    {
      paramString = com.tencent.mm.plugin.textstatus.j.a.lf((String)localObject1, paramString);
      if (!s.YS(paramString)) {
        break;
      }
      paramImageView.setImageBitmap(a(BitmapUtil.decodeFileWithSample(paramString), locala.fvV(), paramContext));
      AppMethodBeat.o(216164);
      return;
    }
    paramContext = e.Ggj;
    paramImageView.setImageResource(e.aTr(locala.field_backgroundId));
    AppMethodBeat.o(216164);
  }
  
  public static void c(String paramString, com.tencent.mm.plugin.textstatus.f.f.a parama)
  {
    AppMethodBeat.i(258419);
    p.h(paramString, "username");
    p.h(parama, "info");
    String str;
    if (parama.field_MediaType == 2)
    {
      str = parama.field_MediaThumbUrl;
      if (!Util.isNullOrNil(str))
      {
        q.bcQ();
        if (com.tencent.mm.av.d.EP(str) == null)
        {
          localObject = com.tencent.mm.plugin.textstatus.j.a.GfU;
          if (parama.field_MediaType != 2) {
            break label151;
          }
        }
      }
    }
    label151:
    for (Object localObject = "thumb";; localObject = "image")
    {
      localObject = com.tencent.mm.plugin.textstatus.j.a.lf((String)localObject, paramString);
      if (!s.YS((String)localObject))
      {
        parama = parama.field_StatusID;
        Log.i("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb start " + (String)localObject + ' ' + parama);
        q.bcU().a(str, (r.a)new a.c(parama, (String)localObject, paramString, str));
      }
      AppMethodBeat.o(258419);
      return;
      str = parama.field_MediaUrl;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
  static final class a
    implements r.a
  {
    a(String paramString1, com.tencent.mm.plugin.textstatus.f.f.a parama, String paramString2, ImageView paramImageView, int paramInt, Context paramContext) {}
    
    public final void a(String paramString1, final Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(216160);
      h.RTc.aX((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216159);
          Log.i("MicroMsg.TxtStatus.StatusImgHandler", "handleImgOnlyByUrl update " + this.FYL.msC + ' ' + this.FYL.FYF.field_StatusID);
          Object localObject = a.FYI;
          localObject = paramBitmap;
          p.g(localObject, "bitmap");
          a.j((Bitmap)localObject, this.FYL.msC);
          localObject = BitmapUtil.decodeFileWithSample(this.FYL.msC);
          q.bcQ();
          com.tencent.mm.av.d.g(this.FYL.UrL, (Bitmap)localObject);
          h.RTc.aV((Runnable)new a.a.1.1(this, (Bitmap)localObject));
          AppMethodBeat.o(216159);
        }
      });
      AppMethodBeat.o(216160);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
  static final class b
    implements r.a
  {
    b(String paramString1, String paramString2, String paramString3, String paramString4, ImageView paramImageView, int paramInt, com.tencent.mm.plugin.textstatus.f.f.a parama, Context paramContext) {}
    
    public final void a(String paramString1, final Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(216162);
      h.RTc.aX((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216161);
          Log.i("MicroMsg.TxtStatus.StatusImgHandler", "handleImgUrl update " + this.FYM.Gdu + ' ' + this.FYM.msC);
          Object localObject = com.tencent.mm.plugin.textstatus.b.f.FXJ;
          localObject = com.tencent.mm.plugin.textstatus.b.f.fvM().aTl(this.FYM.hLl);
          if (localObject != null)
          {
            if (!Util.isEqual(this.FYM.Gdu, ((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_StatusID)) {
              break label180;
            }
            localObject = a.FYI;
            localObject = paramBitmap;
            p.g(localObject, "bitmap");
            a.j((Bitmap)localObject, this.FYM.msC);
            localObject = BitmapUtil.decodeFileWithSample(this.FYM.msC);
            q.bcQ();
            com.tencent.mm.av.d.g(this.FYM.UrL, (Bitmap)localObject);
          }
          for (localObject = h.RTc.aV((Runnable)new a.b.1.a((Bitmap)localObject, this));; localObject = x.SXb)
          {
            if (localObject == null)
            {
              Log.e("MicroMsg.TxtStatus.StatusImgHandler", "handleImgUrl TextStatus is null");
              localObject = x.SXb;
            }
            AppMethodBeat.o(216161);
            return;
            label180:
            Log.e("MicroMsg.TxtStatus.StatusImgHandler", "handleImgUrl getLatest:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_StatusID);
          }
        }
      });
      AppMethodBeat.o(216162);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.a
 * JD-Core Version:    0.7.0.1
 */