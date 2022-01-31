package com.tencent.xweb.xwalk;

import android.content.Context;
import android.webkit.DownloadListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkDownloadListener;

public final class f$f
  extends XWalkDownloadListener
{
  DownloadListener BHN;
  
  public f$f(Context paramContext, DownloadListener paramDownloadListener)
  {
    super(paramContext);
    this.BHN = paramDownloadListener;
  }
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(85225);
    if (this.BHN != null) {
      this.BHN.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
    }
    AppMethodBeat.o(85225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f.f
 * JD-Core Version:    0.7.0.1
 */