package com.tencent.thumbplayer.a.b.b;

import com.tencent.thumbplayer.api.TPCommonEnum.NativeErrorType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface a$c
{
  @TPCommonEnum.NativeErrorType
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.a.c
 * JD-Core Version:    0.7.0.1
 */