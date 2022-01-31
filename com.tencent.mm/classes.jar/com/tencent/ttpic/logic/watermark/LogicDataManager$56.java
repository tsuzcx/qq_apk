package com.tencent.ttpic.logic.watermark;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LogicDataManager$56
  implements LogicDataManager.LogicValueProvider
{
  LogicDataManager$56(LogicDataManager paramLogicDataManager) {}
  
  public String getValue()
  {
    AppMethodBeat.i(83323);
    if ((!TextUtils.isEmpty(LogicDataManager.access$3900(this.this$0))) && (LogicDataManager.access$3900(this.this$0).length() > 6))
    {
      str = LogicDataManager.access$3900(this.this$0).substring(6, 7);
      AppMethodBeat.o(83323);
      return str;
    }
    String str = LogicDataManager.access$800(this.this$0, 1);
    AppMethodBeat.o(83323);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.LogicDataManager.56
 * JD-Core Version:    0.7.0.1
 */