package com.tencent.mm.ui.tools;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class ShareImgUI$4$1
  implements Runnable
{
  ShareImgUI$4$1(ShareImgUI.4 param4, ArrayList paramArrayList, Parcelable paramParcelable, boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    AppMethodBeat.i(34938);
    if (!ShareImgUI.a(this.AxE.Axx, this.AxA, this.AxB)) {
      this.AxC[0] = true;
    }
    this.AxD.countDown();
    AppMethodBeat.o(34938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.4.1
 * JD-Core Version:    0.7.0.1
 */