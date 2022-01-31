package com.tencent.mm.plugin.story.f;

import a.f.b.j;
import a.l;
import a.y;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.d.b.b;
import com.tencent.mm.plugin.story.e.c.a.a;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.image2video.g;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.i.a;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class b$h
  implements Runnable
{
  b$h(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(109536);
    final com.tencent.mm.media.i.a locala = new com.tencent.mm.media.i.a("runMixInBackground");
    this.sAK.pause();
    ab.i(this.sAK.TAG, "man pause ".concat(String.valueOf(locala)));
    long l2 = cb.abq();
    Object localObject1 = this.sAK.cgr();
    Object localObject5 = this.sAK.U((ArrayList)localObject1);
    com.tencent.mm.plugin.story.e.a locala1 = this.sAK.syP;
    j.q(locala1, "captureInfo");
    for (;;)
    {
      try
      {
        localObject3 = locala1.ssm;
        k = ((com.tencent.mm.plugin.story.model.e.b)localObject5).eWL;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          continue;
        }
        if (locala1.ssn <= 0L) {
          continue;
        }
        l1 = locala1.ssn;
        ab.i("MicroMsg.Media.StoryVideoMixer", "create thumb bitmap : ".concat(String.valueOf(l1)));
        if ((locala1.fbp) || (bo.isNullOrNil(locala1.ssl))) {
          continue;
        }
        localObject1 = (com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.srQ.Uw();
        ((com.tencent.mm.plugin.story.c.a.c.a)localObject1).acE(locala1.ssl);
        localObject3 = com.tencent.mm.plugin.mmsight.d.aw(locala1.ssl, l1);
        if (((com.tencent.mm.plugin.story.c.a.c.a)localObject1).eWL == 270) {
          break label1813;
        }
        if (((com.tencent.mm.plugin.story.c.a.c.a)localObject1).eWL != 90) {
          continue;
        }
      }
      catch (Exception localException1)
      {
        Object localObject3;
        int k;
        try
        {
          long l1;
          localObject1 = ((g)localObject4).Z((Bitmap)localObject1);
          j.p(localObject1, "renderScriptBlur.blur(tmpBg, 4f)");
          ((g)localObject4).destroy();
          if (localObject3 == null) {
            break label1806;
          }
          localObject4 = locala1.sss.get(0);
          j.p(localObject4, "captureInfo.fakeVideoImageList[0]");
          i = com.tencent.mm.plugin.story.model.e.b.acP((String)localObject4);
          if (i == 0) {
            break label1806;
          }
          localObject4 = new Matrix();
          ((Matrix)localObject4).postRotate(i);
          localObject3 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), (Matrix)localObject4, true);
          localObject4 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject4, true);
          j.p(localObject4, "Bitmap.createBitmap(bmBg…mBg.height, matrix, true)");
          localObject6 = com.tencent.mm.plugin.story.image2video.d.czT();
          if (localObject3 == null) {
            j.ebi();
          }
          if (((Bitmap)localObject3).getConfig() != null)
          {
            localObject1 = Bitmap.createBitmap(((Point)localObject6).x, ((Point)localObject6).y, ((Bitmap)localObject3).getConfig());
            localCanvas = new Canvas((Bitmap)localObject1);
            j.p(localObject6, "size");
            i = ((Bitmap)localObject4).getWidth();
            j = ((Bitmap)localObject4).getHeight();
            if ((i == ((Point)localObject6).x) && (j == ((Point)localObject6).y)) {
              continue;
            }
            f3 = 0.0F;
            f2 = 0.0F;
            if (((Point)localObject6).y * i <= ((Point)localObject6).x * j) {
              continue;
            }
            f1 = ((Point)localObject6).y / j;
            f3 = (((Point)localObject6).x - i * f1) * 0.5F;
            Matrix localMatrix = new Matrix();
            localMatrix.setScale(f1, f1);
            localMatrix.postTranslate(f3, f2);
            localCanvas.drawBitmap((Bitmap)localObject4, localMatrix, null);
            i = ((Bitmap)localObject3).getWidth();
            j = ((Bitmap)localObject3).getHeight();
            if ((i == ((Point)localObject6).x) && (j == ((Point)localObject6).y)) {
              continue;
            }
            f3 = 0.0F;
            f2 = 0.0F;
            if (((Point)localObject6).y * i <= ((Point)localObject6).x * j) {
              continue;
            }
            f1 = ((Point)localObject6).x / i;
            f2 = (((Point)localObject6).y - j * f1) * 0.5F;
            localObject4 = new Matrix();
            ((Matrix)localObject4).setScale(f1, f1);
            ((Matrix)localObject4).postTranslate(f3, f2);
            localCanvas.drawBitmap((Bitmap)localObject3, (Matrix)localObject4, null);
            continue;
            localException1 = localException1;
            ab.printErrStackTrace("MicroMsg.Media.StoryVideoMixer", (Throwable)localException1, "createGraffitiThumb error", new Object[0]);
            h localh = h.sEz;
            h.cDf();
          }
        }
        catch (Exception localException2)
        {
          int i;
          Canvas localCanvas;
          ab.printErrStackTrace("MicroMsg.Media.StoryVideoMixer", (Throwable)localException2, "rsblur exception", new Object[0]);
          ab.i("MicroMsg.Media.StoryVideoMixer", "rsblur exception, path:%s", new Object[] { locala1.sss.get(0) });
          localObject2 = com.tencent.mm.plugin.story.image2video.d.czT();
          localObject2 = com.tencent.mm.sdk.platformtools.d.au(Color.parseColor("#ff000000"), ((Point)localObject2).x, ((Point)localObject2).y);
          j.p(localObject2, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
          continue;
          localObject2 = com.tencent.mm.sdk.platformtools.d.au(Color.parseColor("#ff000000"), ((Point)localObject6).x, ((Point)localObject6).y);
          continue;
          float f1 = ((Point)localObject6).x / i;
          float f2 = (((Point)localObject6).y - j * f1) * 0.5F;
          continue;
          localCanvas.drawBitmap((Bitmap)localObject4, 0.0F, 0.0F, null);
          continue;
          f1 = ((Point)localObject6).y / j;
          float f3 = (((Point)localObject6).x - i * f1) * 0.5F;
          continue;
          localCanvas.drawBitmap((Bitmap)localObject3, 0.0F, 0.0F, null);
        }
        continue;
        localObject2 = new BitmapFactory.Options();
        ab.i("MicroMsg.Media.StoryVideoMixer", "exist thumb bitmap ");
        ((BitmapFactory.Options)localObject2).inMutable = true;
        localObject2 = com.tencent.mm.sdk.platformtools.d.decodeFile((String)localObject3, (BitmapFactory.Options)localObject2);
        continue;
        localObject4 = com.tencent.mm.plugin.story.model.e.b.ga(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
        Object localObject6 = com.tencent.mm.plugin.story.e.c.ssB;
        localObject6 = com.tencent.mm.plugin.story.e.c.a.acN(locala1.ssl);
        if ((locala1.fbp) || (localObject6 == null) || (((c.a.a)localObject6).ssC)) {
          continue;
        }
        ((com.tencent.mm.plugin.story.model.e.b)localObject5).syO = new com.tencent.mm.plugin.story.model.e.a(((com.tencent.mm.plugin.story.model.e.b)localObject5).qaY, ((com.tencent.mm.plugin.story.model.e.b)localObject5).eVw, ((Point)localObject4).x, ((Point)localObject4).y, ((c.a.a)localObject6).width, ((c.a.a)localObject6).height, k);
        localObject4 = ((com.tencent.mm.plugin.story.model.e.b)localObject5).syO;
        if (localObject4 != null) {
          continue;
        }
        j.ays("frameRetriever");
        ((com.tencent.mm.plugin.story.model.e.a)localObject4).start();
        localObject4 = (Bitmap)((com.tencent.mm.plugin.story.model.e.b)localObject5).eVY.S(Long.valueOf(1L));
        localObject5 = ((com.tencent.mm.plugin.story.model.e.b)localObject5).syO;
        if (localObject5 != null) {
          continue;
        }
        j.ays("frameRetriever");
        ((com.tencent.mm.plugin.story.model.e.a)localObject5).destroy();
        if (localObject4 == null) {
          continue;
        }
        new Canvas((Bitmap)localObject2).drawBitmap((Bitmap)localObject4, 0.0F, 0.0F, null);
        com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject2, 70, Bitmap.CompressFormat.JPEG, (String)localObject3, true);
        localObject2 = new StringBuilder("createGraffitiThumb : ").append((String)localObject3).append("   graffiti : ");
        if (localObject4 != null) {
          continue;
        }
        boolean bool = true;
        ab.i("MicroMsg.Media.StoryVideoMixer", bool);
        continue;
        ((com.tencent.mm.plugin.story.model.e.b)localObject5).syO = new com.tencent.mm.plugin.story.model.e.a(((com.tencent.mm.plugin.story.model.e.b)localObject5).qaY, ((com.tencent.mm.plugin.story.model.e.b)localObject5).eVw, ((Point)localObject4).x, ((Point)localObject4).y, 0, 0, k);
        continue;
        bool = false;
        continue;
        com.tencent.mm.ab.b.b((a.f.a.a)new b.h.1(this));
        ab.i(this.sAK.TAG, "error when runMixInBackground");
        AppMethodBeat.o(109536);
        return;
      }
      if (j != 0)
      {
        i = ((com.tencent.mm.plugin.story.c.a.c.a)localObject1).eRv;
        if (j != 0)
        {
          j = ((com.tencent.mm.plugin.story.c.a.c.a)localObject1).eRu;
          localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, i, j, true);
          localObject3 = new StringBuilder("createGraffitiThumb not capture, thumb size:[");
          j.p(localObject1, "thumb");
          ab.i("MicroMsg.Media.StoryVideoMixer", ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "], thumbRotate:" + k + ", drawingRect:" + Arrays.toString(((com.tencent.mm.plugin.story.model.e.b)localObject5).qaY));
          localObject3 = i.suJ;
          locala1.acI(i.a.mu(cb.abq()));
          localObject3 = locala1.ssm;
          if (localObject1 != null) {
            continue;
          }
          ab.e("MicroMsg.Media.StoryVideoMixer", "createGraffitiThumb thumb is null");
          localObject1 = h.sEz;
          h.cDf();
          ab.i(this.sAK.TAG, "man createGraffitiThumb ".concat(String.valueOf(locala)));
          localObject1 = k.sCp;
          localObject1 = k.a(this.sAK.sAF, this.sAK.sAC);
          localObject3 = k.sCp;
          localObject3 = k.a(this.sAK.sAF, this.sAK.qaU, this.sAK.sAC, this.sAK.syP, l2, this.sAK.sAF.getLocation());
          ab.i(this.sAK.TAG, "man insertdone ".concat(String.valueOf(locala)));
          if (localObject3 == null) {
            continue;
          }
          com.tencent.mm.ab.b.a("StoryCapture_commit", (a.f.a.a)new b.e(this.sAK, (com.tencent.mm.plugin.story.h.d)localObject3, this.sAK.syP.ssm, (chk)localObject1, this.sAK.syP.ssp, (a.f.a.b)new b.h.a(this, (chk)localObject1, (com.tencent.mm.plugin.story.h.d)localObject3, locala)));
          com.tencent.mm.ab.b.b((a.f.a.a)new b(this, (chk)localObject1, (com.tencent.mm.plugin.story.h.d)localObject3, locala));
          AppMethodBeat.o(109536);
          return;
          l1 = 0L;
          continue;
          j = 0;
          continue;
        }
      }
      else
      {
        i = ((com.tencent.mm.plugin.story.c.a.c.a)localObject1).eRu;
        continue;
      }
      int j = ((com.tencent.mm.plugin.story.c.a.c.a)localObject1).eRv;
      continue;
      if (locala1.sss.size() == 0)
      {
        localObject1 = com.tencent.mm.plugin.mmsight.d.aw(locala1.ssl, l1);
      }
      else
      {
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
        BitmapFactory.decodeFile((String)locala1.sss.get(0), (BitmapFactory.Options)localObject1);
        i = ((BitmapFactory.Options)localObject1).outWidth;
        j = ((BitmapFactory.Options)localObject1).outHeight;
        com.tencent.mm.plugin.story.image2video.d.fX(i, j);
        ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.sdk.platformtools.d.I(i, j, com.tencent.mm.plugin.story.image2video.d.getMaxSize(), com.tencent.mm.plugin.story.image2video.d.getMaxSize());
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject1).inMutable = true;
        localObject3 = MMBitmapFactory.decodeFile((String)locala1.sss.get(0), (BitmapFactory.Options)localObject1);
        ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.sdk.platformtools.d.I(i, j, com.tencent.mm.plugin.story.image2video.d.getMaxSize() / 2, com.tencent.mm.plugin.story.image2video.d.getMaxSize() / 2);
        Object localObject4 = new g(ah.getContext());
        localObject1 = MMBitmapFactory.decodeFile((String)locala1.sss.get(0), (BitmapFactory.Options)localObject1);
        Object localObject2;
        label1806:
        localObject4 = localObject2;
        continue;
        label1813:
        j = 1;
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/EditorPresenter$runMixInBackground$1$1$2"})
  static final class b
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    b(b.h paramh, chk paramchk, com.tencent.mm.plugin.story.h.d paramd, com.tencent.mm.media.i.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.h
 * JD-Core Version:    0.7.0.1
 */