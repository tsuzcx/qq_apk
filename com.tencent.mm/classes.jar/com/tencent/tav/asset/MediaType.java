package com.tencent.tav.asset;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MediaType
{
  public static final int AVMediaTypeAudio = 2;
  public static final int AVMediaTypeVideo = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tav.asset.MediaType
 * JD-Core Version:    0.7.0.1
 */