package com.tencent.mm.ui.tools;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

final class ShareImgUI$4
  implements Runnable
{
  ShareImgUI$4(ShareImgUI paramShareImgUI, Bundle paramBundle, ShareImgUI.b paramb, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(34939);
    Object localObject1 = this.iao.getParcelableArrayList("android.intent.extra.STREAM");
    ArrayList localArrayList;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    Parcelable localParcelable;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localArrayList = new ArrayList();
      localObject4 = new CountDownLatch(((ArrayList)localObject1).size());
      localObject3 = new boolean[1];
      localObject3[0] = 0;
      localObject5 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject5).hasNext())
      {
        localParcelable = (Parcelable)((Iterator)localObject5).next();
        if (localParcelable == null) {
          break label277;
        }
      }
    }
    Object localObject2;
    label277:
    for (localObject1 = localParcelable.toString();; localObject2 = "null")
    {
      d.post(new ShareImgUI.4.1(this, localArrayList, localParcelable, (boolean[])localObject3, (CountDownLatch)localObject4), "getMultiSendFilePathListItem".concat(String.valueOf(localObject1)));
      break;
      try
      {
        ((CountDownLatch)localObject4).await();
        if (localObject3[0] != 0)
        {
          ab.d("MicroMsg.ShareImgUI", "hy: has non path img");
          localObject3 = this.Axx;
          localObject1 = this.Axy;
          localObject4 = null;
          ShareImgUI.a((ShareImgUI)localObject3, (ShareImgUI.b)localObject1, (ArrayList)localObject4);
          AppMethodBeat.o(34939);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.ShareImgUI", localInterruptedException, "hy: timeout when getmulti", new Object[0]);
          ShareImgUI.a(this.Axx, this.Axy, null);
          continue;
          ab.i("MicroMsg.ShareImgUI", "hy: getMultiSendFilePathList done. using: %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.Axz) });
          localObject4 = this.Axx;
          localObject5 = this.Axy;
          localObject2 = localObject5;
          localObject3 = localObject4;
          if (localArrayList.size() > 0)
          {
            localObject2 = localObject5;
            localObject3 = localObject4;
            localObject4 = localArrayList;
          }
        }
      }
      ab.e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
      ShareImgUI.a(this.Axx, this.Axy, null);
      AppMethodBeat.o(34939);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.4
 * JD-Core Version:    0.7.0.1
 */