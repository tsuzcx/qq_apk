package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReaderCallback;

class TbsOneFileOpenManager$1
  implements ITbsReaderCallback
{
  TbsOneFileOpenManager$1(TbsOneFileOpenManager paramTbsOneFileOpenManager, ValueCallback paramValueCallback) {}
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(54321);
    if (this.a == null)
    {
      AppMethodBeat.o(54321);
      return;
    }
    if (10 == paramInteger.intValue()) {
      this.a.onReceiveValue("plugin success");
    }
    for (;;)
    {
      if (13 == paramInteger.intValue()) {
        this.a.onReceiveValue((String)paramObject1);
      }
      AppMethodBeat.o(54321);
      return;
      if (11 == paramInteger.intValue()) {
        this.a.onReceiveValue("plugin failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsOneFileOpenManager.1
 * JD-Core Version:    0.7.0.1
 */