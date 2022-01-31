package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

class XWalkCoreWrapper$ReservedAction
{
  Object[] mArguments;
  Class<?> mClass;
  ReflectMethod mMethod;
  Object mObject;
  
  XWalkCoreWrapper$ReservedAction(Class<?> paramClass)
  {
    this.mClass = paramClass;
  }
  
  XWalkCoreWrapper$ReservedAction(Object paramObject)
  {
    this.mObject = paramObject;
  }
  
  XWalkCoreWrapper$ReservedAction(ReflectMethod paramReflectMethod)
  {
    AppMethodBeat.i(85555);
    this.mMethod = paramReflectMethod;
    if (paramReflectMethod.getArguments() != null) {
      this.mArguments = Arrays.copyOf(paramReflectMethod.getArguments(), paramReflectMethod.getArguments().length);
    }
    AppMethodBeat.o(85555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.XWalkCoreWrapper.ReservedAction
 * JD-Core Version:    0.7.0.1
 */