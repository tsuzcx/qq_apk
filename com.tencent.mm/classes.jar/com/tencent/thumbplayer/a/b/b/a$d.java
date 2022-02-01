package com.tencent.thumbplayer.a.b.b;

import com.tencent.thumbplayer.api.TPCommonEnum.NativeInitConfig;
import com.tencent.thumbplayer.api.TPCommonEnum.OptionalIdType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface a$d
{
  @TPCommonEnum.OptionalIdType
  int type();
  
  @TPCommonEnum.NativeInitConfig
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.a.d
 * JD-Core Version:    0.7.0.1
 */