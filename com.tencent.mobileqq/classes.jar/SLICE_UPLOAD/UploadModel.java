package SLICE_UPLOAD;

import java.io.Serializable;

public final class UploadModel
  implements Serializable
{
  public static final UploadModel MODEL_NORMAL;
  public static final UploadModel MODEL_PRE_UPLOAD;
  public static final int _MODEL_NORMAL = 0;
  public static final int _MODEL_PRE_UPLOAD = 1;
  private static UploadModel[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!UploadModel.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new UploadModel[2];
      MODEL_NORMAL = new UploadModel(0, 0, "MODEL_NORMAL");
      MODEL_PRE_UPLOAD = new UploadModel(1, 1, "MODEL_PRE_UPLOAD");
      return;
    }
  }
  
  private UploadModel(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static UploadModel convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static UploadModel convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SLICE_UPLOAD.UploadModel
 * JD-Core Version:    0.7.0.1
 */