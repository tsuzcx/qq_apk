package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.recordvideo.b.i;
import com.tencent.mm.vending.e.b;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/GetImageListRecommendAudioTask;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "scene", "", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/util/ArrayList;I)V", "imageList", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "", "onPrepareImageData", "plugin-recordvideo_release"})
public final class g
  extends a
{
  private ArrayList<String> xvx;
  
  public g(b<com.tencent.mm.vending.e.a> paramb, ArrayList<String> paramArrayList, int paramInt)
  {
    super(paramb);
    AppMethodBeat.i(75426);
    this.xvx = new ArrayList();
    this.xvx.addAll((Collection)paramArrayList);
    this.scene = paramInt;
    AppMethodBeat.o(75426);
  }
  
  public final Bitmap NG(int paramInt)
  {
    AppMethodBeat.i(75424);
    Object localObject = (Collection)this.xvx;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
      p.g(localObject, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
      AppMethodBeat.o(75424);
      return localObject;
    }
    paramInt = this.xyV[paramInt];
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)this.xvx.get(paramInt), (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = com.tencent.mm.sdk.platformtools.g.O(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, this.thumbWidth, this.thumbHeight);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    Bitmap localBitmap = MMBitmapFactory.decodeFile((String)this.xvx.get(paramInt), (BitmapFactory.Options)localObject);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      localObject = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
      p.g(localObject, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
    }
    AppMethodBeat.o(75424);
    return localObject;
  }
  
  public final void dFN()
  {
    AppMethodBeat.i(75425);
    if (this.scene == i.xxF.ordinal()) {}
    for (this.vtP = 60000L;; this.vtP = 15000L)
    {
      D(new int[] { 0, 0, 0 });
      if (this.xvx.size() < 3) {
        break;
      }
      this.xyV[1] = (this.xvx.size() / 2);
      this.xyV[2] = (this.xvx.size() - 1);
      AppMethodBeat.o(75425);
      return;
    }
    if (this.xvx.size() == 2)
    {
      this.xyV[1] = 1;
      this.xyV[2] = 1;
    }
    AppMethodBeat.o(75425);
  }
  
  public final void dFO() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.g
 * JD-Core Version:    0.7.0.1
 */