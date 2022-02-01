package com.tencent.thumbplayer.a.b.b;

import com.tencent.thumbplayer.api.TPCommonEnum.NativeConnectionAction;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface a$a
{
  @TPCommonEnum.NativeConnectionAction
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.a.a
 * JD-Core Version:    0.7.0.1
 */