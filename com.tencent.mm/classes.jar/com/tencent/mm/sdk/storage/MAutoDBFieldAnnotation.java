package com.tencent.mm.sdk.storage;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface MAutoDBFieldAnnotation
{
  String defValue();
  
  int primaryKey() default 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MAutoDBFieldAnnotation
 * JD-Core Version:    0.7.0.1
 */