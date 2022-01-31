package com.tencent.ttpic.logic.watermark;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LogicDataManager$51
  implements LogicDataManager.LogicValueProvider
{
  LogicDataManager$51(LogicDataManager paramLogicDataManager) {}
  
  public String getValue()
  {
    AppMethodBeat.i(83318);
    if ((!TextUtils.isEmpty(LogicDataManager.access$3900(this.this$0))) && (LogicDataManager.access$3900(this.this$0).length() > 0))
    {
      str = LogicDataManager.access$3900(this.this$0).substring(0, 1);
      AppMethodBeat.o(83318);
      return str;
    }
    String str = LogicDataManager.access$300(this.this$0, 0);
    AppMethodBeat.o(83318);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.LogicDataManager.51
 * JD-Core Version:    0.7.0.1
 */