package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.Map;

public class ImagePreLoader
  extends PreLoader
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(81770);
    TAG = ImagePreLoader.class.getSimpleName();
    AppMethodBeat.o(81770);
  }
  
  public ImagePreLoader(Map<String, Bitmap> paramMap, String paramString, StickerItem paramStickerItem, int paramInt)
  {
    super(paramMap, paramString, paramStickerItem, paramInt);
  }
  
  public void clear() {}
  
  public void preloadNewImages(int paramInt)
  {
    AppMethodBeat.i(81769);
    this.frontIndex = paramInt;
    this.rearIndex = ((this.frontIndex + this.capacity) % this.item.frames);
    paramInt = this.frontIndex;
    if (paramInt != this.rearIndex)
    {
      Object localObject2 = this.item.id + "_" + paramInt + ".png";
      if (TextUtils.isEmpty(this.materialId)) {}
      for (Object localObject1 = localObject2;; localObject1 = this.materialId + File.separator + (String)localObject2)
      {
        if (!this.cache.containsKey(localObject1))
        {
          localObject2 = this.dataPath + File.separator + this.item.subFolder + File.separator + (String)localObject2;
          localObject2 = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
          if (BitmapUtils.isLegal((Bitmap)localObject2)) {
            this.cache.put(localObject1, localObject2);
          }
        }
        paramInt = (paramInt + 1) % this.item.frames;
        break;
      }
    }
    AppMethodBeat.o(81769);
  }
  
  public void prepareImages()
  {
    int i = 0;
    AppMethodBeat.i(81768);
    this.frontIndex = 0;
    if ((i < this.capacity) && (i < this.item.frames))
    {
      String str = this.item.id + "_" + i + ".png";
      Object localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + str;
      localObject = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      if (TextUtils.isEmpty(this.materialId)) {}
      for (;;)
      {
        if ((BitmapUtils.isLegal((Bitmap)localObject)) && (!this.cache.containsKey(str))) {
          this.cache.put(str, localObject);
        }
        this.rearIndex = i;
        i += 1;
        break;
        str = this.materialId + File.separator + str;
      }
    }
    AppMethodBeat.o(81768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImagePreLoader
 * JD-Core Version:    0.7.0.1
 */