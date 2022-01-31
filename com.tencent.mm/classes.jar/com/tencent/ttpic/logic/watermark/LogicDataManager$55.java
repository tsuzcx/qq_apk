package com.tencent.ttpic.logic.watermark;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LogicDataManager$55
  implements LogicDataManager.LogicValueProvider
{
  LogicDataManager$55(LogicDataManager paramLogicDataManager) {}
  
  public String getValue()
  {
    AppMethodBeat.i(83322);
    if ((!TextUtils.isEmpty(LogicDataManager.access$3900(this.this$0))) && (LogicDataManager.access$3900(this.this$0).length() > 5))
    {
      str = LogicDataManager.access$3900(this.this$0).substring(5, 6);
      AppMethodBeat.o(83322);
      return str;
    }
    String str = LogicDataManager.access$800(this.this$0, 0);
    AppMethodBeat.o(83322);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.LogicDataManager.55
 * JD-Core Version:    0.7.0.1
 */