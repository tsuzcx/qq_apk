package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.Map;

public class LoadETCItemManager
  implements LoadItemManager
{
  public static int FORMAT_COUNT = 3;
  private String dataPath;
  private StickerItem item;
  private Map<String, ETC1Util.ETC1Texture> mCache;
  private AsyncTask<Void, Integer, Boolean> mImageTask;
  
  public LoadETCItemManager(Map<String, ETC1Util.ETC1Texture> paramMap, String paramString, StickerItem paramStickerItem)
  {
    this.dataPath = paramString;
    this.item = paramStickerItem;
    this.mCache = paramMap;
  }
  
  public void clear()
  {
    AppMethodBeat.i(81783);
    if (this.mImageTask != null) {
      this.mImageTask.cancel(true);
    }
    AppMethodBeat.o(81783);
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(int paramInt)
  {
    AppMethodBeat.i(81782);
    Object localObject = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + String.format(new StringBuilder("%0").append(FORMAT_COUNT).append("d").toString(), new Object[] { Integer.valueOf(paramInt) }) + "_alpha.pkm";
    localObject = (ETC1Util.ETC1Texture)this.mCache.get(localObject);
    AppMethodBeat.o(81782);
    return localObject;
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(int paramInt)
  {
    AppMethodBeat.i(81781);
    Object localObject = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + String.format(new StringBuilder("%0").append(FORMAT_COUNT).append("d").toString(), new Object[] { Integer.valueOf(paramInt) }) + ".pkm";
    localObject = (ETC1Util.ETC1Texture)this.mCache.get(localObject);
    AppMethodBeat.o(81781);
    return localObject;
  }
  
  public Bitmap loadImage(int paramInt)
  {
    return null;
  }
  
  public Bitmap loadImage(String paramString)
  {
    return null;
  }
  
  public void prepareImages()
  {
    AppMethodBeat.i(81780);
    this.mImageTask = new LoadETCTextureTask(this.mCache, this.item.id, this.item.frames, this.dataPath + File.separator + this.item.subFolder + ".zip", VideoMaterialUtil.getMaterialId(this.dataPath));
    this.mImageTask.executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
    AppMethodBeat.o(81780);
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadETCItemManager
 * JD-Core Version:    0.7.0.1
 */