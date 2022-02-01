package com.tencent.mm.ui.chatting.d.a;

import com.tencent.mm.ui.chatting.d.ad;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface a
{
  Class<? extends ad> fFo() default a.class;
  
  public static class a
    implements ad
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.a.a
 * JD-Core Version:    0.7.0.1
 */