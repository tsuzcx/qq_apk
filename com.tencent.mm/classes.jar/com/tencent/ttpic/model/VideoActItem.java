package com.tencent.ttpic.model;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.recorder.ActVideoDecoder;
import com.tencent.ttpic.util.BenchUtil;
import java.util.List;

public class VideoActItem
  extends FrameSourceItem
{
  private static final int FRAME_INTERVAL = 83;
  private static String TAG;
  private ActVideoDecoder decoder;
  private String path;
  private int[] texId;
  
  static
  {
    AppMethodBeat.i(83579);
    TAG = VideoActItem.class.getSimpleName();
    AppMethodBeat.o(83579);
  }
  
  public VideoActItem(String paramString, BaseFilter paramBaseFilter)
  {
    super(paramBaseFilter);
    AppMethodBeat.i(83572);
    this.texId = new int[1];
    this.path = paramString;
    AppMethodBeat.o(83572);
  }
  
  public void clear()
  {
    AppMethodBeat.i(83575);
    if (this.decoder != null)
    {
      this.decoder.release();
      this.decoder = null;
    }
    GLES20.glDeleteTextures(this.texId.length, this.texId, 0);
    AppMethodBeat.o(83575);
  }
  
  public int getOrigHeight(int paramInt)
  {
    AppMethodBeat.i(83578);
    paramInt = this.decoder.getHeight();
    AppMethodBeat.o(83578);
    return paramInt;
  }
  
  public int getOrigWidth(int paramInt)
  {
    AppMethodBeat.i(83577);
    paramInt = this.decoder.getWidth() / 2;
    AppMethodBeat.o(83577);
    return paramInt;
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return this.texId[0];
  }
  
  public void init()
  {
    AppMethodBeat.i(83573);
    GLES20.glGenTextures(this.texId.length, this.texId, 0);
    this.decoder = new ActVideoDecoder(this.path, this.texId[0]);
    this.decoder.decodeFrame(0L);
    this.decoder.updateFrame();
    AppMethodBeat.o(83573);
  }
  
  public void reset()
  {
    AppMethodBeat.i(83576);
    this.decoder.reset();
    AppMethodBeat.o(83576);
  }
  
  public void update(h paramh, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt)
  {
    AppMethodBeat.i(83574);
    BenchUtil.benchStart(TAG + "[update]");
    super.update(paramh, paramLong, paramList, paramList1, paramInt);
    this.decoder.decodeFrame(paramLong);
    this.decoder.updateFrame();
    BenchUtil.benchEnd(TAG + "[update]");
    AppMethodBeat.o(83574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.model.VideoActItem
 * JD-Core Version:    0.7.0.1
 */