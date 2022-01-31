package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ReflectionHelper$MemberType
{
  static
  {
    AppMethodBeat.i(86139);
    JS_METHOD = new MemberType("JS_METHOD", 0);
    JS_PROPERTY = new MemberType("JS_PROPERTY", 1);
    JS_CONSTRUCTOR = new MemberType("JS_CONSTRUCTOR", 2);
    $VALUES = new MemberType[] { JS_METHOD, JS_PROPERTY, JS_CONSTRUCTOR };
    AppMethodBeat.o(86139);
  }
  
  private ReflectionHelper$MemberType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.extension.ReflectionHelper.MemberType
 * JD-Core Version:    0.7.0.1
 */