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
    AppMethodBeat.i(65934);
    this.mContext = paramContext.getApplicationContext();
    TXCDRApi.initCrashReport(paramContext);
    AppMethodBeat.o(65934);
  }
  
  public Bitmap getThumbnail(float paramFloat)
  {
    AppMethodBeat.i(65936);
    if (this.mImageSprite != null)
    {
      Bitmap localBitmap = this.mImageSprite.getThumbnail(paramFloat);
      AppMethodBeat.o(65936);
      return localBitmap;
    }
    AppMethodBeat.o(65936);
    return null;
  }
  
  public void release()
  {
    AppMethodBeat.i(65937);
    if (this.mImageSprite != null)
    {
      this.mImageSprite.release();
      this.mImageSprite = null;
    }
    AppMethodBeat.o(65937);
  }
  
  public void setVTTUrlAndImageUrls(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(65935);
    if (this.mImageSprite != null) {
      release();
    }
    if ((paramString != null) && (paramList != null) && (paramList.size() != 0))
    {
      TXCDRApi.txReportDAU(this.mContext, com.tencent.liteav.basic.datareport.a.bz);
      this.mImageSprite = new b();
      this.mImageSprite.setVTTUrlAndImageUrls(paramString, paramList);
    }
    AppMethodBeat.o(65935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.TXImageSprite
 * JD-Core Version:    0.7.0.1
 */