package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.i.c;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.p;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-recordvideo_release"})
public final class f$b
  implements n
{
  public f$b(long paramLong, p paramp, boolean paramBoolean) {}
  
  public final void b(Bitmap paramBitmap, boolean paramBoolean)
  {
    Boolean localBoolean1 = null;
    AppMethodBeat.i(150617);
    ab.i("MicroMsg.EditPhotoPluginLayout", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + bo.av(this.kdR));
    Object localObject1 = c.eZC;
    c.gm(bo.av(this.kdR));
    if (paramBitmap == null)
    {
      localObject1 = c.eZC;
      c.VV();
    }
    if (paramBitmap != null)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
      localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
      float f;
      Object localObject2;
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVZ, true)) {
        if (paramBitmap.getHeight() > paramBitmap.getWidth())
        {
          localObject1 = paramBitmap;
          if (paramBitmap.getHeight() > 1920.0F)
          {
            f = 1920.0F / paramBitmap.getHeight();
            localObject1 = d.b(paramBitmap, 0.0F, f, f);
            j.p(localObject1, "BitmapUtil.rotateAndScale(temImage,0f,scale,scale)");
          }
          localObject2 = Bitmap.CompressFormat.JPEG;
          paramBitmap = f.b(this.qbZ);
          if (paramBitmap == null) {
            break label589;
          }
          paramBitmap = paramBitmap.qbD;
          label210:
          d.a((Bitmap)localObject1, 90, (Bitmap.CompressFormat)localObject2, paramBitmap, true);
          localObject1 = new StringBuilder("saveBitmapToImage  cost:").append(bo.av(this.kdR)).append("  path:");
          paramBitmap = f.b(this.qbZ);
          if (paramBitmap == null) {
            break label594;
          }
          paramBitmap = paramBitmap.qbD;
          label264:
          ab.i("MicroMsg.EditPhotoPluginLayout", paramBitmap);
          f.a(this.qbZ);
          this.iEF.dismiss();
          paramBitmap = com.tencent.mm.plugin.recordvideo.d.a.qfv;
          paramBitmap = f.b(this.qbZ);
          localObject1 = f.c(this.qbZ);
          if (localObject1 == null) {
            break label599;
          }
        }
      }
      label589:
      label594:
      label599:
      for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).fbp;; paramBoolean = false)
      {
        com.tencent.mm.plugin.recordvideo.d.a.b(paramBitmap, paramBoolean, this.qca);
        ab.d("MicroMsg.EditPhotoPluginLayout", "new ThreadPool  cost:" + bo.av(this.kdR));
        localObject1 = CaptureDataManager.qbh;
        localObject2 = f.d(this.qbZ);
        Boolean localBoolean2 = Boolean.TRUE;
        Object localObject3 = f.b(this.qbZ);
        paramBitmap = localBoolean1;
        if (localObject3 != null) {
          paramBitmap = ((RecordConfigProvider)localObject3).qbD;
        }
        localBoolean1 = Boolean.TRUE;
        localObject3 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        ((CaptureDataManager)localObject1).a((Context)localObject2, new CaptureDataManager.CaptureVideoNormalModel(localBoolean2, "", paramBitmap, Long.valueOf(-1L), localBoolean1, com.tencent.mm.plugin.recordvideo.c.b.cgB()));
        AppMethodBeat.o(150617);
        return;
        localObject1 = paramBitmap;
        if (paramBitmap.getWidth() <= 1920.0F) {
          break;
        }
        f = 1920.0F / paramBitmap.getWidth();
        localObject1 = d.b(paramBitmap, 0.0F, f, f);
        j.p(localObject1, "BitmapUtil.rotateAndScale(temImage,0f,scale,scale)");
        break;
        if (paramBitmap.getHeight() > paramBitmap.getWidth())
        {
          localObject1 = paramBitmap;
          if (paramBitmap.getWidth() <= 1080.0F) {
            break;
          }
          f = 1080.0F / paramBitmap.getHeight();
          localObject1 = d.b(paramBitmap, 0.0F, f, f);
          j.p(localObject1, "BitmapUtil.rotateAndScale(temImage,0f,scale,scale)");
          break;
        }
        localObject1 = paramBitmap;
        if (paramBitmap.getHeight() <= 1080.0F) {
          break;
        }
        f = 1080.0F / paramBitmap.getHeight();
        localObject1 = d.b(paramBitmap, 0.0F, f, f);
        j.p(localObject1, "BitmapUtil.rotateAndScale(temImage,0f,scale,scale)");
        break;
        paramBitmap = null;
        break label210;
        paramBitmap = null;
        break label264;
      }
    }
    AppMethodBeat.o(150617);
  }
  
  public final void onError(Exception paramException)
  {
    AppMethodBeat.i(150616);
    j.q(paramException, "e");
    ab.e("MicroMsg.EditPhotoPluginLayout", "photoEditor onError: %s", new Object[] { paramException });
    paramException = c.eZC;
    c.VU();
    paramException = c.eZC;
    c.gm(bo.av(this.kdR));
    f.a(this.qbZ);
    this.iEF.dismiss();
    AppMethodBeat.o(150616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.f.b
 * JD-Core Version:    0.7.0.1
 */