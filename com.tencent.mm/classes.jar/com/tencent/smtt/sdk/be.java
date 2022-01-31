package com.tencent.smtt.sdk;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.a.d;

class be
  implements TbsReaderView.ReaderCallback
{
  be(TbsReaderView paramTbsReaderView) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    int i = 0;
    AppMethodBeat.i(139380);
    Object localObject1;
    switch (paramInteger.intValue())
    {
    default: 
    case 5008: 
      for (;;)
      {
        if ((this.a.d != null) && (i == 0)) {
          this.a.d.onCallBackAction(paramInteger, paramObject1, paramObject2);
        }
        AppMethodBeat.o(139380);
        return;
        if (d.c(this.a.a)) {
          break;
        }
        paramInteger = Integer.valueOf(5011);
        localObject1 = TbsReaderView.getResString(this.a.a, 5023);
        paramObject1 = new Bundle();
        paramObject1.putString("tip", (String)localObject1);
        paramObject1.putString("statistics", "AHNG812");
        paramObject1.putInt("channel_id", 10834);
        this.a.userStatistics("AHNG811");
      }
      localObject1 = "";
      if (paramObject1 != null)
      {
        localObject2 = (Bundle)paramObject1;
        localObject1 = ((Bundle)localObject2).getString("docpath");
      }
      QbSdk.startQBForDoc(this.a.a, (String)localObject1, 4, 0, "pdf", (Bundle)localObject2);
      this.a.userStatistics("AHNG813");
    }
    for (;;)
    {
      i = 1;
      break;
      if (!d.c(this.a.a))
      {
        paramInteger = Integer.valueOf(5011);
        localObject1 = TbsReaderView.getResString(this.a.a, 5021);
        paramObject1 = new Bundle();
        paramObject1.putString("tip", (String)localObject1);
        paramObject1.putString("statistics", "AHNG808");
        paramObject1.putInt("channel_id", 10833);
        this.a.userStatistics("AHNG807");
        break;
      }
      localObject1 = "";
      localObject2 = localObject3;
      if (paramObject1 != null)
      {
        localObject2 = (Bundle)paramObject1;
        localObject1 = ((Bundle)localObject2).getString("docpath");
      }
      QbSdk.startQBForDoc(this.a.a, (String)localObject1, 4, 0, "", (Bundle)localObject2);
      this.a.userStatistics("AHNG809");
      continue;
      if (!d.c(this.a.a))
      {
        paramInteger = Integer.valueOf(5011);
        localObject1 = TbsReaderView.getResString(this.a.a, 5022);
        paramObject1 = new Bundle();
        paramObject1.putString("tip", (String)localObject1);
        paramObject1.putString("statistics", "AHNG816");
        paramObject1.putInt("channel_id", 10835);
        this.a.userStatistics("AHNG815");
        break;
      }
      localObject1 = "";
      localObject2 = localObject4;
      if (paramObject1 != null)
      {
        localObject2 = (Bundle)paramObject1;
        localObject1 = ((Bundle)localObject2).getString("docpath");
      }
      QbSdk.startQBForDoc(this.a.a, (String)localObject1, 4, 0, "txt", (Bundle)localObject2);
      continue;
      if (!d.c(this.a.a))
      {
        paramInteger = Integer.valueOf(5011);
        localObject1 = TbsReaderView.getResString(this.a.a, 5029);
        paramObject1 = new Bundle();
        paramObject1.putString("tip", (String)localObject1);
        paramObject1.putString("statistics", "AHNG828");
        paramObject1.putInt("channel_id", 10965);
        this.a.userStatistics("AHNG827");
        break;
      }
      localObject1 = "";
      localObject2 = localObject5;
      if (paramObject1 != null)
      {
        localObject2 = (Bundle)paramObject1;
        localObject1 = ((Bundle)localObject2).getString("docpath");
      }
      QbSdk.startQBForDoc(this.a.a, (String)localObject1, 4, 0, "doc", (Bundle)localObject2);
      this.a.userStatistics("AHNG829");
      continue;
      if (paramObject1 != null)
      {
        localObject1 = (Bundle)paramObject1;
        TbsReaderView.gReaderPackName = ((Bundle)localObject1).getString("name");
        TbsReaderView.gReaderPackVersion = ((Bundle)localObject1).getString("version");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.be
 * JD-Core Version:    0.7.0.1
 */