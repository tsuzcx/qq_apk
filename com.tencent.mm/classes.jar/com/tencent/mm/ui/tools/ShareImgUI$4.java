package com.tencent.mm.ui.tools;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

final class ShareImgUI$4
  implements Runnable
{
  ShareImgUI$4(ShareImgUI paramShareImgUI, Bundle paramBundle, ShareImgUI.b paramb, long paramLong) {}
  
  public final void run()
  {
    Object localObject4 = this.gBV.getParcelableArrayList("android.intent.extra.STREAM");
    if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = new CountDownLatch(((ArrayList)localObject4).size());
      Object localObject1 = new boolean[1];
      localObject1[0] = 0;
      localObject4 = ((ArrayList)localObject4).iterator();
      Object localObject5;
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Parcelable)((Iterator)localObject4).next();
        e.post(new ShareImgUI.4.1(this, localArrayList, (Parcelable)localObject5, (boolean[])localObject1, (CountDownLatch)localObject2), "getMultiSendFilePathListItem" + localObject5.toString());
      }
      try
      {
        ((CountDownLatch)localObject2).await();
        if (localObject1[0] != 0)
        {
          y.d("MicroMsg.ShareImgUI", "hy: has non path img");
          localObject2 = this.weH;
          localObject1 = this.weI;
          localObject4 = null;
          ShareImgUI.a((ShareImgUI)localObject2, (ShareImgUI.b)localObject1, (ArrayList)localObject4);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.ShareImgUI", localInterruptedException, "hy: timeout when getmulti", new Object[0]);
          ShareImgUI.a(this.weH, this.weI, null);
          continue;
          y.i("MicroMsg.ShareImgUI", "hy: getMultiSendFilePathList done. using: %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.weJ) });
          localObject4 = this.weH;
          localObject5 = this.weI;
          localObject1 = localObject5;
          Object localObject3 = localObject4;
          if (localArrayList.size() > 0)
          {
            localObject1 = localObject5;
            localObject3 = localObject4;
            localObject4 = localArrayList;
          }
        }
      }
    }
    y.e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
    ShareImgUI.a(this.weH, this.weI, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.4
 * JD-Core Version:    0.7.0.1
 */