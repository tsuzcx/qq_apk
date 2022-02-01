package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.a.b;
import java.util.List;

public class TXImageSprite
  implements com.tencent.rtmp.a.a
{
  private Context mContext;
  private com.tencent.rtmp.a.a mImageSprite;
  
  public TXImageSprite(Context paramContext)
  {
    AppMethodBeat.i(13548);
    this.mContext = paramContext.getApplicationContext();
    TXCDRApi.initCrashReport(paramContext);
    AppMethodBeat.o(13548);
  }
  
  public Bitmap getThumbnail(float paramFloat)
  {
    AppMethodBeat.i(13550);
    if (this.mImageSprite != null)
    {
      Bitmap localBitmap = this.mImageSprite.getThumbnail(paramFloat);
      AppMethodBeat.o(13550);
      return localBitmap;
    }
    AppMethodBeat.o(13550);
    return null;
  }
  
  public void release()
  {
    AppMethodBeat.i(13551);
    if (this.mImageSprite != null)
    {
      this.mImageSprite.release();
      this.mImageSprite = null;
    }
    AppMethodBeat.o(13551);
  }
  
  public void setVTTUrlAndImageUrls(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(13549);
    if (this.mImageSprite != null) {
      release();
    }
    if ((paramString != null) && (paramList != null) && (paramList.size() != 0))
    {
      TXCDRApi.txReportDAU(this.mContext, com.tencent.liteav.basic.datareport.a.bC);
      this.mImageSprite = new b();
      this.mImageSprite.setVTTUrlAndImageUrls(paramString, paramList);
    }
    AppMethodBeat.o(13549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXImageSprite
 * JD-Core Version:    0.7.0.1
 */