package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class e_permission_visit_flag
  implements Serializable
{
  public static final int _enum_not_permission_some_fri = 8;
  public static final int _enum_permission_each_other = 7;
  public static final int _enum_permission_friend = 4;
  public static final int _enum_permission_passwd = 2;
  public static final int _enum_permission_private = 3;
  public static final int _enum_permission_public = 1;
  public static final int _enum_permission_qa = 5;
  public static final int _enum_permission_secndegrcontac = 9;
  public static final int _enum_permission_some_fri = 6;
  private static e_permission_visit_flag[] a;
  public static final e_permission_visit_flag enum_not_permission_some_fri;
  public static final e_permission_visit_flag enum_permission_each_other;
  public static final e_permission_visit_flag enum_permission_friend;
  public static final e_permission_visit_flag enum_permission_passwd;
  public static final e_permission_visit_flag enum_permission_private;
  public static final e_permission_visit_flag enum_permission_public;
  public static final e_permission_visit_flag enum_permission_qa;
  public static final e_permission_visit_flag enum_permission_secndegrcontac;
  public static final e_permission_visit_flag enum_permission_some_fri;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!e_permission_visit_flag.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new e_permission_visit_flag[9];
      enum_permission_public = new e_permission_visit_flag(0, 1, "enum_permission_public");
      enum_permission_passwd = new e_permission_visit_flag(1, 2, "enum_permission_passwd");
      enum_permission_private = new e_permission_visit_flag(2, 3, "enum_permission_private");
      enum_permission_friend = new e_permission_visit_flag(3, 4, "enum_permission_friend");
      enum_permission_qa = new e_permission_visit_flag(4, 5, "enum_permission_qa");
      enum_permission_some_fri = new e_permission_visit_flag(5, 6, "enum_permission_some_fri");
      enum_permission_each_other = new e_permission_visit_flag(6, 7, "enum_permission_each_other");
      enum_not_permission_some_fri = new e_permission_visit_flag(7, 8, "enum_not_permission_some_fri");
      enum_permission_secndegrcontac = new e_permission_visit_flag(8, 9, "enum_permission_secndegrcontac");
      return;
    }
  }
  
  private e_permission_visit_flag(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static e_permission_visit_flag convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static e_permission_visit_flag convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.e_permission_visit_flag
 * JD-Core Version:    0.7.0.1
 */