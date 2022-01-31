package com.tencent.ttpic.logic.watermark;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

class LogicDataManager$50
  implements LogicDataManager.LogicValueProvider
{
  LogicDataManager$50(LogicDataManager paramLogicDataManager) {}
  
  public String getValue()
  {
    AppMethodBeat.i(83317);
    synchronized (LogicDataManager.access$3800(this.this$0))
    {
      if (LogicDataManager.access$3800(this.this$0).isEmpty()) {
        break label100;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (!LogicDataManager.access$3800(this.this$0).isEmpty()) {
        localStringBuilder.append((String)LogicDataManager.access$3800(this.this$0).poll());
      }
    }
    String str = localObject.toString();
    AppMethodBeat.o(83317);
    return str;
    label100:
    AppMethodBeat.o(83317);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.logic.watermark.LogicDataManager.50
 * JD-Core Version:    0.7.0.1
 */