package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
public @interface DoNotCheckLeakForActivities
{
  Class<? extends Activity>[] value() default {};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities
 * JD-Core Version:    0.7.0.1
 */