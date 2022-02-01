package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.recordvideo.b.i;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vending.e.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/GetImageListRecommendAudioTask;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "scene", "", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/util/ArrayList;I)V", "imageList", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "", "onPrepareImageData", "plugin-recordvideo_release"})
public final class g
  extends a
{
  private ArrayList<String> wnH;
  
  public g(b<com.tencent.mm.vending.e.a> paramb, ArrayList<String> paramArrayList, int paramInt)
  {
    super(paramb);
    AppMethodBeat.i(75426);
    this.wnH = new ArrayList();
    this.wnH.addAll((Collection)paramArrayList);
    this.scene = paramInt;
    AppMethodBeat.o(75426);
  }
  
  public final Bitmap Mh(int paramInt)
  {
    AppMethodBeat.i(75424);
    Object localObject = (Collection)this.wnH;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
      k.g(localObject, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
      AppMethodBeat.o(75424);
      return localObject;
    }
    paramInt = this.wre[paramInt];
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)this.wnH.get(paramInt), (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = f.O(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, this.thumbWidth, this.thumbHeight);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    Bitmap localBitmap = MMBitmapFactory.decodeFile((String)this.wnH.get(paramInt), (BitmapFactory.Options)localObject);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      localObject = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
      k.g(localObject, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
    }
    AppMethodBeat.o(75424);
    return localObject;
  }
  
  public final void dvr()
  {
    AppMethodBeat.i(75425);
    if (this.scene == i.wpP.ordinal()) {}
    for (this.urm = 60000L;; this.urm = 15000L)
    {
      D(new int[] { 0, 0, 0 });
      if (this.wnH.size() < 3) {
        break;
      }
      this.wre[1] = (this.wnH.size() / 2);
      this.wre[2] = (this.wnH.size() - 1);
      AppMethodBeat.o(75425);
      return;
    }
    if (this.wnH.size() == 2)
    {
      this.wre[1] = 1;
      this.wre[2] = 1;
    }
    AppMethodBeat.o(75425);
  }
  
  public final void dvs() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.g
 * JD-Core Version:    0.7.0.1
 */