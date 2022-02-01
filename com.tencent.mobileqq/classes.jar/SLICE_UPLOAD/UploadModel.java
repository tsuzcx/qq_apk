package SLICE_UPLOAD;

import java.io.Serializable;

public final class UploadModel
  implements Serializable
{
  public static final UploadModel MODEL_NORMAL = new UploadModel(0, 0, "MODEL_NORMAL");
  public static final UploadModel MODEL_PRE_UPLOAD = new UploadModel(1, 1, "MODEL_PRE_UPLOAD");
  public static final int _MODEL_NORMAL = 0;
  public static final int _MODEL_PRE_UPLOAD = 1;
  private static UploadModel[] __values = new UploadModel[2];
  private String __T = new String();
  private int __value;
  
  private UploadModel(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static UploadModel convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      UploadModel[] arrayOfUploadModel = __values;
      if (i >= arrayOfUploadModel.length) {
        break;
      }
      if (arrayOfUploadModel[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static UploadModel convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      UploadModel[] arrayOfUploadModel = __values;
      if (i >= arrayOfUploadModel.length) {
        break;
      }
      if (arrayOfUploadModel[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SLICE_UPLOAD.UploadModel
 * JD-Core Version:    0.7.0.1
 */