package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.d;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/GetImageListRecommendAudioTask;", "Lcom/tencent/mm/plugin/story/model/audio/AbsGetRecommendAudioTask;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "scene", "", "(Ljava/util/ArrayList;I)V", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "nextBitmap", "Landroid/graphics/Bitmap;", "index", "onFinishImageData", "", "onPrepareImageData", "plugin-story_release"})
public final class g
  extends a
{
  private ArrayList<String> ste;
  
  public g(ArrayList<String> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(151065);
    this.ste = paramArrayList;
    this.scene = paramInt;
    AppMethodBeat.o(151065);
  }
  
  public final Bitmap FI(int paramInt)
  {
    AppMethodBeat.i(155295);
    paramInt = this.swm[paramInt];
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)this.ste.get(paramInt), (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = d.I(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, this.fgR, this.fgQ);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    Bitmap localBitmap = MMBitmapFactory.decodeFile((String)this.ste.get(paramInt), (BitmapFactory.Options)localObject);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      localObject = Bitmap.createBitmap(this.fgR, this.fgQ, Bitmap.Config.ARGB_8888);
      j.p(localObject, "Bitmap.createBitmap(thum… Bitmap.Config.ARGB_8888)");
    }
    AppMethodBeat.o(155295);
    return localObject;
  }
  
  public final void cBr()
  {
    AppMethodBeat.i(155296);
    this.qZL = 15000L;
    A(new int[] { 0, 0, 0 });
    if (this.ste.size() >= 3)
    {
      this.swm[1] = (this.ste.size() / 2);
      this.swm[2] = (this.ste.size() - 1);
      AppMethodBeat.o(155296);
      return;
    }
    if (this.ste.size() == 2)
    {
      this.swm[1] = 1;
      this.swm[2] = 1;
    }
    AppMethodBeat.o(155296);
  }
  
  public final void cBs() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.g
 * JD-Core Version:    0.7.0.1
 */