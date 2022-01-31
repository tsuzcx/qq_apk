package com.tencent.ttpic.logic.watermark;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LogicDataManager$53
  implements LogicDataManager.LogicValueProvider
{
  LogicDataManager$53(LogicDataManager paramLogicDataManager) {}
  
  public String getValue()
  {
    AppMethodBeat.i(83320);
    if ((!TextUtils.isEmpty(LogicDataManager.access$3900(this.this$0))) && (LogicDataManager.access$3900(this.this$0).length() > 2))
    {
      str = LogicDataManager.access$3900(this.this$0).substring(2, 3);
      AppMethodBeat.o(83320);
      return str;
    }
    String str = LogicDataManager.access$300(this.this$0, 2);
    AppMethodBeat.o(83320);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.LogicDataManager.53
 * JD-Core Version:    0.7.0.1
 */