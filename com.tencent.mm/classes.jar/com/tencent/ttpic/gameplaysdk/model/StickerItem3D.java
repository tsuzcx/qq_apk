package com.tencent.ttpic.gameplaysdk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.StickerItem;
import java.io.File;

public class StickerItem3D
  extends StickerItem
{
  public String curFrameImagePath;
  public int curPlayCount = 0;
  public String extension = "";
  public long frameStartTime;
  public float[] nodeEulerAngles;
  public NodeParameter nodeParameter;
  public float[] nodePosition;
  public float[] nodeScale;
  public boolean triggered = false;
  
  public void calFrameIndex(long paramLong)
  {
    AppMethodBeat.i(83222);
    if ((!TextUtils.isEmpty(this.id)) && (this.id.contains(":")))
    {
      if ((!this.triggered) || (TextUtils.isEmpty(this.extension)))
      {
        this.curPlayCount = 0;
        this.curFrameImagePath = "";
        this.frameStartTime = paramLong;
        AppMethodBeat.o(83222);
        return;
      }
      int i = (int)((paramLong - this.frameStartTime) / Math.max(this.frameDuration, 1.0D));
      if (i >= this.frames * (this.curPlayCount + 1)) {
        this.curPlayCount += 1;
      }
      int j = Math.max(this.frames, 1);
      Object localObject = this.id.split(":");
      if (localObject.length == 2)
      {
        localObject = localObject[1];
        this.curFrameImagePath = ((String)localObject + File.separator + (String)localObject + "_" + i % j + "." + this.extension);
      }
    }
    AppMethodBeat.o(83222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.gameplaysdk.model.StickerItem3D
 * JD-Core Version:    0.7.0.1
 */