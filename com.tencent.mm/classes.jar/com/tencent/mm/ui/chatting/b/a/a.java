package com.tencent.mm.ui.chatting.b.a;

import com.tencent.mm.ui.chatting.b.v;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface a
{
  Class<? extends v> cFA() default a.class;
  
  public static class a
    implements v
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.a.a
 * JD-Core Version:    0.7.0.1
 */