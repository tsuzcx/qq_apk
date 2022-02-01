package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.recordvideo.c.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/GetImageListRecommendAudioTask;", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "scene", "", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Ljava/util/ArrayList;I)V", "imageList", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "", "onPrepareImageData", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  private ArrayList<String> NEX;
  
  public g(b<com.tencent.mm.vending.e.a> paramb, ArrayList<String> paramArrayList, int paramInt)
  {
    super(paramb);
    AppMethodBeat.i(75426);
    this.NEX = new ArrayList();
    this.NEX.addAll((Collection)paramArrayList);
    setScene(paramInt);
    AppMethodBeat.o(75426);
  }
  
  public final Bitmap agx(int paramInt)
  {
    AppMethodBeat.i(75424);
    Object localObject = (Collection)this.NEX;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
      s.s(localObject, "createBitmap(thumbWidth,… Bitmap.Config.ARGB_8888)");
      AppMethodBeat.o(75424);
      return localObject;
    }
    paramInt = this.NIx[paramInt];
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)this.NEX.get(paramInt), (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = BitmapUtil.calculateInSampleSize(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, this.thumbWidth, this.thumbHeight);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    localObject = MMBitmapFactory.decodeFile((String)this.NEX.get(paramInt), (BitmapFactory.Options)localObject);
    if (localObject == null)
    {
      localObject = Bitmap.createBitmap(this.thumbWidth, this.thumbHeight, Bitmap.Config.ARGB_8888);
      s.s(localObject, "createBitmap(thumbWidth,… Bitmap.Config.ARGB_8888)");
      AppMethodBeat.o(75424);
      return localObject;
    }
    AppMethodBeat.o(75424);
    return localObject;
  }
  
  public final void gHK()
  {
    AppMethodBeat.i(75425);
    if (getScene() == k.NHp.ordinal()) {
      kq(60000L);
    }
    for (;;)
    {
      L(new int[] { 0, 0, 0 });
      if (this.NEX.size() < 3) {
        break;
      }
      this.NIx[1] = (this.NEX.size() / 2);
      this.NIx[2] = (this.NEX.size() - 1);
      AppMethodBeat.o(75425);
      return;
      kq(15000L);
    }
    if (this.NEX.size() == 2)
    {
      this.NIx[1] = 1;
      this.NIx[2] = 1;
    }
    AppMethodBeat.o(75425);
  }
  
  public final void gHL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.g
 * JD-Core Version:    0.7.0.1
 */