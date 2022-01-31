package com.tencent.ttpic.logic.watermark;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LogicDataManager$58
  implements LogicDataManager.LogicValueProvider
{
  LogicDataManager$58(LogicDataManager paramLogicDataManager) {}
  
  public String getValue()
  {
    AppMethodBeat.i(83325);
    if ((!TextUtils.isEmpty(LogicDataManager.access$3900(this.this$0))) && (LogicDataManager.access$3900(this.this$0).length() > 9))
    {
      str = LogicDataManager.access$3900(this.this$0).substring(9, 10);
      AppMethodBeat.o(83325);
      return str;
    }
    String str = LogicDataManager.access$1300(this.this$0, 1);
    AppMethodBeat.o(83325);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.LogicDataManager.58
 * JD-Core Version:    0.7.0.1
 */