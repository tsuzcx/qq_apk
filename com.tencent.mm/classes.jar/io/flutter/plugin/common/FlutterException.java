package io.flutter.plugin.common;

public class FlutterException
  extends RuntimeException
{
  private static final String TAG = "FlutterException#";
  public final String code;
  public final Object details;
  
  FlutterException(String paramString1, String paramString2, Object paramObject)
  {
    super(paramString2);
    this.code = paramString1;
    this.details = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.plugin.common.FlutterException
 * JD-Core Version:    0.7.0.1
 */