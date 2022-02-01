package SLICE_UPLOAD;

import java.io.Serializable;

public final class DUMP_BUSSINESS_ID
  implements Serializable
{
  public static final DUMP_BUSSINESS_ID DUMP_BUSSINESS_DEFAULT = new DUMP_BUSSINESS_ID(0, 0, "DUMP_BUSSINESS_DEFAULT");
  public static final DUMP_BUSSINESS_ID DUMP_BUSSINESS_WEISHI = new DUMP_BUSSINESS_ID(1, 1, "DUMP_BUSSINESS_WEISHI");
  public static final int _DUMP_BUSSINESS_DEFAULT = 0;
  public static final int _DUMP_BUSSINESS_WEISHI = 1;
  private static DUMP_BUSSINESS_ID[] __values = new DUMP_BUSSINESS_ID[2];
  private String __T = new String();
  private int __value;
  
  private DUMP_BUSSINESS_ID(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static DUMP_BUSSINESS_ID convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      DUMP_BUSSINESS_ID[] arrayOfDUMP_BUSSINESS_ID = __values;
      if (i >= arrayOfDUMP_BUSSINESS_ID.length) {
        break;
      }
      if (arrayOfDUMP_BUSSINESS_ID[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static DUMP_BUSSINESS_ID convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      DUMP_BUSSINESS_ID[] arrayOfDUMP_BUSSINESS_ID = __values;
      if (i >= arrayOfDUMP_BUSSINESS_ID.length) {
        break;
      }
      if (arrayOfDUMP_BUSSINESS_ID[i].toString().equals(paramString)) {
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
 * Qualified Name:     SLICE_UPLOAD.DUMP_BUSSINESS_ID
 * JD-Core Version:    0.7.0.1
 */