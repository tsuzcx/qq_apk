package com.tencent.ttpic.logic.watermark;

import com.tencent.matrix.trace.core.AppMethodBeat;

class LogicDataManager$43
  implements LogicDataManager.LogicValueProvider
{
  LogicDataManager$43(LogicDataManager paramLogicDataManager) {}
  
  public String getValue()
  {
    AppMethodBeat.i(83309);
    if (LogicDataManager.access$3200(this.this$0) == null)
    {
      AppMethodBeat.o(83309);
      return "这里";
    }
    String str = LogicDataManager.access$3200(this.this$0);
    AppMethodBeat.o(83309);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.LogicDataManager.43
 * JD-Core Version:    0.7.0.1
 */