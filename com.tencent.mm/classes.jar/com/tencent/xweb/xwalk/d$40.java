package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.WebView;
import com.tencent.xweb.q;
import java.io.File;
import org.xwalk.core.Log;

final class d$40
  implements View.OnClickListener
{
  d$40(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(207257);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.SGe.SFW.setVisibility(8);
    this.SGe.SFP.startLongScreenshot(new q()
    {
      public final File getCacheFileDir()
      {
        AppMethodBeat.i(207255);
        File localFile = new File(d.40.this.SGe.SzQ.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
        AppMethodBeat.o(207255);
        return localFile;
      }
      
      public final int getMaxHeightSupported()
      {
        return 0;
      }
      
      public final File getResultFileDir()
      {
        AppMethodBeat.i(207256);
        File localFile = new File(d.40.this.SGe.SzQ.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
        AppMethodBeat.o(207256);
        return localFile;
      }
      
      public final void onLongScreenshotFinished(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(207254);
        Log.d("WebDebugPage", "onLongScreenshotFinished with " + paramAnonymousInt + " / " + paramAnonymousString);
        AppMethodBeat.o(207254);
      }
      
      public final Bitmap overrideScreenshot(Bitmap paramAnonymousBitmap)
      {
        return paramAnonymousBitmap;
      }
    }, true);
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(207257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.40
 * JD-Core Version:    0.7.0.1
 */