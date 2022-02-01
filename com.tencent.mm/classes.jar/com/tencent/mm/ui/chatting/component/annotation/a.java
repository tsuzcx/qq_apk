package com.tencent.mm.ui.chatting.component.annotation;

import com.tencent.mm.ui.chatting.component.aj;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface a
{
  Class<? extends aj> juB() default a.a.class;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.annotation.a
 * JD-Core Version:    0.7.0.1
 */