package com.tencent.mm.plugin.textstatus.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.h.f.g;
import com.tencent.mm.plugin.textstatus.util.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.effect.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/manager/StatusImgHandler;", "", "()V", "TAG", "", "downloadImage", "", "username", "url", "statusId", "downloadImgAndSet", "context", "Landroid/content/Context;", "iv", "Landroid/widget/ImageView;", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "imgUrl", "filePath", "listener", "Lcom/tencent/mm/plugin/textstatus/manager/StatusImgHandler$OnSetImgFinishedListener;", "infoHash", "", "needSetDefWhenDownload", "", "downloadPicsAndSet", "getFinalBitmap", "Landroid/graphics/Bitmap;", "oriBitmap", "isBlur", "handleImgOnlyByUrl", "useThumb", "setHeaderView", "onlyUseThumb", "setImageWithGradient", "triggerDownloadThumb", "OnSetImgFinishedListener", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Tmr;
  
  static
  {
    AppMethodBeat.i(289957);
    Tmr = new a();
    AppMethodBeat.o(289957);
  }
  
  private static final void a(long paramLong, String paramString1, final String paramString2, final String paramString3, final String paramString4, final ImageView paramImageView, final int paramInt, final com.tencent.mm.plugin.textstatus.h.f.b paramb, final WeakReference paramWeakReference, final a parama, String paramString5, final Bitmap paramBitmap, String paramString6)
  {
    AppMethodBeat.i(289939);
    kotlin.g.b.s.u(paramString2, "$filePath");
    kotlin.g.b.s.u(paramString3, "$username");
    kotlin.g.b.s.u(paramImageView, "$iv");
    kotlin.g.b.s.u(paramb, "$info");
    kotlin.g.b.s.u(paramWeakReference, "$contextRef");
    if (paramBitmap == null)
    {
      AppMethodBeat.o(289939);
      return;
    }
    b.bP((kotlin.g.a.a)new c(paramLong, paramString1, paramString2, paramString3, paramBitmap, paramString4, paramImageView, paramInt, paramb, paramWeakReference, parama));
    AppMethodBeat.o(289939);
  }
  
  private final void a(final Context paramContext, final ImageView paramImageView, final String paramString, final com.tencent.mm.plugin.textstatus.h.f.b paramb, final int paramInt)
  {
    AppMethodBeat.i(289880);
    if (paramb.field_MediaType == 2) {}
    Object localObject2;
    Object localObject3;
    for (Object localObject1 = "";; localObject1 = paramb.field_MediaUrl)
    {
      localObject2 = com.tencent.mm.plugin.textstatus.util.e.TAU;
      localObject2 = com.tencent.mm.plugin.textstatus.util.e.nl("image", paramString);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label122;
      }
      r.bJZ();
      localObject3 = com.tencent.mm.modelimage.e.Eo((String)localObject1);
      if (localObject3 == null) {
        break;
      }
      a(paramImageView, (Bitmap)localObject3, paramb.hHI());
      AppMethodBeat.o(289880);
      return;
    }
    if (y.ZC((String)localObject2))
    {
      b.bP((kotlin.g.a.a)new e((String)localObject2, (String)localObject1, paramImageView, paramb, paramContext));
      AppMethodBeat.o(289880);
      return;
    }
    label122:
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (localObject1 = null;; localObject1 = new f(paramContext, paramImageView, paramString, paramb, (String)localObject1, (String)localObject2, paramInt))
    {
      localObject2 = paramb.field_MediaThumbUrl;
      localObject3 = com.tencent.mm.plugin.textstatus.util.e.TAU;
      localObject3 = com.tencent.mm.plugin.textstatus.util.e.nl("thumb", paramString);
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "begin download thumb");
      a(paramContext, paramImageView, paramString, paramb, (String)localObject2, (String)localObject3, (a)localObject1, paramInt);
      AppMethodBeat.o(289880);
      return;
    }
  }
  
  public static void a(final Context paramContext, final ImageView paramImageView, String paramString1, final com.tencent.mm.plugin.textstatus.h.f.b paramb, final String paramString2, String paramString3, final a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(289903);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramImageView, "iv");
    kotlin.g.b.s.u(paramString1, "username");
    kotlin.g.b.s.u(paramb, "info");
    kotlin.g.b.s.u(paramString3, "filePath");
    paramContext = new WeakReference(paramContext);
    if (!Util.isNullOrNil(paramString2))
    {
      r.bJZ();
      Object localObject = com.tencent.mm.modelimage.e.Eo(paramString2);
      if (localObject == null)
      {
        if (y.ZC(paramString3))
        {
          b.bP((kotlin.g.a.a)new b(paramString3, paramString2, paramImageView, paramb, paramContext, parama));
          AppMethodBeat.o(289903);
          return;
        }
        if (paramBoolean)
        {
          localObject = k.TBx;
          paramImageView.setImageResource(k.bep(paramb.field_backgroundId));
        }
        localObject = paramb.field_StatusID;
        long l = System.currentTimeMillis();
        r.bKd().a(paramString2, new a..ExternalSyntheticLambda0(l, (String)localObject, paramString3, paramString1, paramString2, paramImageView, paramInt, paramb, paramContext, parama));
        AppMethodBeat.o(289903);
        return;
      }
      paramBoolean = paramb.hHI();
      paramContext.get();
      a(paramImageView, (Bitmap)localObject, paramBoolean);
      if (parama != null)
      {
        parama.hHy();
        AppMethodBeat.o(289903);
      }
    }
    else
    {
      if (Util.isNullOrNil(paramb.field_backgroundId)) {
        break label260;
      }
      paramContext = k.TBx;
      paramImageView.setImageResource(k.bep(paramb.field_backgroundId));
    }
    for (;;)
    {
      if (parama != null) {
        parama.hHy();
      }
      AppMethodBeat.o(289903);
      return;
      label260:
      if (y.ZC(paramString3))
      {
        b.bP((kotlin.g.a.a)new d(paramString3, paramImageView, paramb, paramContext));
      }
      else
      {
        paramContext = k.TBx;
        paramImageView.setImageResource(k.bep(paramb.field_backgroundId));
      }
    }
  }
  
  private static void a(ImageView paramImageView, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(289888);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(289888);
      return;
    }
    paramImageView.post(new a..ExternalSyntheticLambda3(paramBoolean, paramBitmap, paramImageView));
    AppMethodBeat.o(289888);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.textstatus.h.f.b paramb)
  {
    AppMethodBeat.i(289914);
    kotlin.g.b.s.u(paramString, "username");
    kotlin.g.b.s.u(paramb, "info");
    int i = ac.hGi();
    if (i == 2)
    {
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "do not triggerDownloadThumb");
      AppMethodBeat.o(289914);
      return;
    }
    boolean bool;
    String str;
    if ((i == 0) && (paramb.field_MediaType == 1))
    {
      bool = false;
      if (bool != true) {
        break label222;
      }
      str = paramb.field_MediaThumbUrl;
      label68:
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "trigger info: " + i + ", " + bool);
      if (!Util.isNullOrNil(str))
      {
        r.bJZ();
        if (com.tencent.mm.modelimage.e.Eo(str) == null)
        {
          localObject = com.tencent.mm.plugin.textstatus.util.e.TAU;
          if (!bool) {
            break label231;
          }
        }
      }
    }
    label222:
    label231:
    for (Object localObject = "thumb";; localObject = "image")
    {
      localObject = com.tencent.mm.plugin.textstatus.util.e.nl((String)localObject, paramString);
      if (!y.ZC((String)localObject))
      {
        paramb = paramb.field_StatusID;
        Log.i("MicroMsg.TextStatus.StatusImgHandler", "triggerDownloadThumb start " + (String)localObject + ' ' + paramb);
        r.bKd().a(str, new a..ExternalSyntheticLambda2(paramb, (String)localObject, paramString, str));
      }
      AppMethodBeat.o(289914);
      return;
      bool = true;
      break;
      str = paramb.field_MediaUrl;
      break label68;
    }
  }
  
  private static final void a(String paramString1, final com.tencent.mm.plugin.textstatus.h.f.b paramb, final String paramString2, final ImageView paramImageView, final int paramInt, final Context paramContext, String paramString3, final Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(289922);
    kotlin.g.b.s.u(paramString1, "$filePath");
    kotlin.g.b.s.u(paramb, "$info");
    kotlin.g.b.s.u(paramImageView, "$iv");
    kotlin.g.b.s.u(paramContext, "$context");
    if (paramBitmap == null)
    {
      AppMethodBeat.o(289922);
      return;
    }
    b.bP((kotlin.g.a.a)new h(paramString1, paramb, paramBitmap, paramString2, paramImageView, paramInt, paramContext));
    AppMethodBeat.o(289922);
  }
  
  private static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap, String paramString6)
  {
    AppMethodBeat.i(289944);
    kotlin.g.b.s.u(paramString2, "$filePath");
    kotlin.g.b.s.u(paramString3, "$username");
    if (paramBitmap == null)
    {
      AppMethodBeat.o(289944);
      return;
    }
    b.bP((kotlin.g.a.a)new a.j(paramString1, paramString2, paramString3, paramBitmap, paramString4));
    AppMethodBeat.o(289944);
  }
  
  private static final void a(boolean paramBoolean, Bitmap paramBitmap, ImageView paramImageView)
  {
    AppMethodBeat.i(289930);
    kotlin.g.b.s.u(paramImageView, "$iv");
    if ((!paramBoolean) && (paramBitmap.getWidth() != 0) && (paramImageView.getWidth() != 0) && (paramBitmap.getHeight() / paramBitmap.getWidth() >= paramImageView.getHeight() / paramImageView.getWidth()))
    {
      paramImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(289930);
      return;
    }
    com.tencent.mm.videocomposition.effect.a locala = new com.tencent.mm.videocomposition.effect.a();
    locala.setInputBitmap(paramBitmap);
    locala.setOutputSize(paramImageView.getWidth(), paramImageView.getHeight());
    locala.HkF.GpO.jQk();
    if (paramBoolean) {
      locala.HkF.GpO.jQj().setRadius(1.5F);
    }
    locala.aW((kotlin.g.a.b)new a.i(paramImageView));
    AppMethodBeat.o(289930);
  }
  
  public final void a(Context paramContext, String paramString, ImageView paramImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(289984);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "username");
    kotlin.g.b.s.u(paramImageView, "iv");
    Object localObject = f.TjQ;
    localObject = f.bdN(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(289984);
      return;
    }
    int i = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).hashCode();
    paramImageView.setTag(com.tencent.mm.plugin.textstatus.a.e.Tcg, Integer.valueOf(i));
    if (paramBoolean)
    {
      String str = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_MediaThumbUrl;
      com.tencent.mm.plugin.textstatus.util.e locale = com.tencent.mm.plugin.textstatus.util.e.TAU;
      a(paramContext, paramImageView, paramString, (com.tencent.mm.plugin.textstatus.h.f.b)localObject, str, com.tencent.mm.plugin.textstatus.util.e.nl("thumb", paramString), null, i);
      AppMethodBeat.o(289984);
      return;
    }
    a(paramContext, paramImageView, paramString, (com.tencent.mm.plugin.textstatus.h.f.b)localObject, i);
    AppMethodBeat.o(289984);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/manager/StatusImgHandler$OnSetImgFinishedListener;", "", "onSetImgFinished", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void hHy();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Object>
  {
    b(String paramString1, String paramString2, ImageView paramImageView, com.tencent.mm.plugin.textstatus.h.f.b paramb, WeakReference<Context> paramWeakReference, a.a parama)
    {
      super();
    }
    
    public final Object invoke()
    {
      AppMethodBeat.i(289825);
      Object localObject1 = b.aXb(this.svx);
      r.bJZ();
      com.tencent.mm.modelimage.e.g(paramString2, (Bitmap)localObject1);
      Object localObject2 = a.Tmr;
      localObject2 = paramImageView;
      boolean bool = paramb.hHI();
      paramContext.get();
      a.b((ImageView)localObject2, (Bitmap)localObject1, bool);
      localObject1 = parama;
      if (localObject1 == null)
      {
        AppMethodBeat.o(289825);
        return null;
      }
      ((a.a)localObject1).hHy();
      localObject1 = ah.aiuX;
      AppMethodBeat.o(289825);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Object>
  {
    c(long paramLong, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, ImageView paramImageView, int paramInt, com.tencent.mm.plugin.textstatus.h.f.b paramb, WeakReference<Context> paramWeakReference, a.a parama)
    {
      super();
    }
    
    private static final void a(ImageView paramImageView, int paramInt, Bitmap paramBitmap, com.tencent.mm.plugin.textstatus.h.f.b paramb, WeakReference paramWeakReference, a.a parama)
    {
      AppMethodBeat.i(289832);
      kotlin.g.b.s.u(paramImageView, "$iv");
      kotlin.g.b.s.u(paramb, "$info");
      kotlin.g.b.s.u(paramWeakReference, "$contextRef");
      if (!kotlin.g.b.s.p(paramImageView.getTag(com.tencent.mm.plugin.textstatus.a.e.Tcg), Integer.valueOf(paramInt)))
      {
        AppMethodBeat.o(289832);
        return;
      }
      a locala = a.Tmr;
      boolean bool = paramb.hHI();
      paramWeakReference.get();
      a.b(paramImageView, paramBitmap, bool);
      if (parama != null) {
        parama.hHy();
      }
      AppMethodBeat.o(289832);
    }
    
    public final Object invoke()
    {
      AppMethodBeat.i(289851);
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "handleImgUrl update " + (System.currentTimeMillis() - this.Uj) + ' ' + paramString2 + ' ' + paramString3);
      Object localObject1 = f.TjQ;
      Object localObject2 = f.hGH().bdY(paramBitmap);
      if (localObject2 == null) {
        localObject1 = null;
      }
      while (localObject1 == null)
      {
        Log.e("MicroMsg.TextStatus.StatusImgHandler", "handleImgUrl TextStatus is null");
        localObject1 = ah.aiuX;
        AppMethodBeat.o(289851);
        return localObject1;
        String str1 = paramString2;
        Bitmap localBitmap = paramString4;
        String str2 = paramString3;
        localObject1 = paramImageView;
        ImageView localImageView = paramInt;
        int i = paramb;
        com.tencent.mm.plugin.textstatus.h.f.b localb = paramWeakReference;
        WeakReference localWeakReference = parama;
        a.a locala = this.Tmu;
        if (Util.isEqual(str1, ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_StatusID))
        {
          b.m(localBitmap, str2);
          localObject2 = b.aXb(str2);
          r.bJZ();
          com.tencent.mm.modelimage.e.g((String)localObject1, (Bitmap)localObject2);
          localObject1 = Boolean.valueOf(localImageView.post(new a.c..ExternalSyntheticLambda0(localImageView, i, (Bitmap)localObject2, localb, localWeakReference, locala)));
        }
        else
        {
          Log.e("MicroMsg.TextStatus.StatusImgHandler", kotlin.g.b.s.X("handleImgUrl getLatest:", ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_StatusID));
          localObject1 = ah.aiuX;
        }
      }
      AppMethodBeat.o(289851);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(String paramString, ImageView paramImageView, com.tencent.mm.plugin.textstatus.h.f.b paramb, WeakReference<Context> paramWeakReference)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(String paramString1, String paramString2, ImageView paramImageView, com.tencent.mm.plugin.textstatus.h.f.b paramb, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/manager/StatusImgHandler$downloadPicsAndSet$onSetImgListener$1", "Lcom/tencent/mm/plugin/textstatus/manager/StatusImgHandler$OnSetImgFinishedListener;", "onSetImgFinished", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements a.a
  {
    f(Context paramContext, ImageView paramImageView, String paramString1, com.tencent.mm.plugin.textstatus.h.f.b paramb, String paramString2, String paramString3, int paramInt) {}
    
    public final void hHy()
    {
      AppMethodBeat.i(289842);
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "begin download ori pic");
      a locala = a.Tmr;
      a.a(this.$context, paramImageView, paramString, paramb, this.Tmx, this.Tmw, null, paramInt, false);
      AppMethodBeat.o(289842);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(String paramString1, String paramString2, ImageView paramImageView, com.tencent.mm.plugin.textstatus.h.f.b paramb, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Object>
  {
    h(String paramString1, com.tencent.mm.plugin.textstatus.h.f.b paramb, Bitmap paramBitmap, String paramString2, ImageView paramImageView, int paramInt, Context paramContext)
    {
      super();
    }
    
    private static final void a(ImageView paramImageView, int paramInt, Bitmap paramBitmap, com.tencent.mm.plugin.textstatus.h.f.b paramb, Context paramContext)
    {
      AppMethodBeat.i(289840);
      kotlin.g.b.s.u(paramImageView, "$iv");
      kotlin.g.b.s.u(paramb, "$info");
      kotlin.g.b.s.u(paramContext, "$context");
      if (!kotlin.g.b.s.p(paramImageView.getTag(com.tencent.mm.plugin.textstatus.a.e.Tcg), Integer.valueOf(paramInt)))
      {
        AppMethodBeat.o(289840);
        return;
      }
      paramContext = a.Tmr;
      a.b(paramImageView, paramBitmap, paramb.hHI());
      AppMethodBeat.o(289840);
    }
    
    public final Object invoke()
    {
      AppMethodBeat.i(289858);
      Log.i("MicroMsg.TextStatus.StatusImgHandler", "handleImgOnlyByUrl update " + this.svx + ' ' + paramb.field_StatusID);
      b.m(paramBitmap, this.svx);
      Bitmap localBitmap = b.aXb(this.svx);
      r.bJZ();
      com.tencent.mm.modelimage.e.g(paramString2, localBitmap);
      boolean bool = paramImageView.post(new a.h..ExternalSyntheticLambda0(paramImageView, paramInt, paramBitmap, paramb, paramContext));
      AppMethodBeat.o(289858);
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.a
 * JD-Core Version:    0.7.0.1
 */