package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class enum_guiding_feed_type
  implements Serializable
{
  public static final int _eGuidingFollow = 2;
  public static final int _eGuidingFriendReminder = 3;
  public static final int _eGuidingMessage = 5;
  public static final int _eGuidingNoviceWelcome = 4;
  public static final int _eGuidingSetAuth = 1;
  public static final int _eGuidingUnknown = 0;
  private static enum_guiding_feed_type[] a;
  public static final enum_guiding_feed_type eGuidingFollow;
  public static final enum_guiding_feed_type eGuidingFriendReminder;
  public static final enum_guiding_feed_type eGuidingMessage;
  public static final enum_guiding_feed_type eGuidingNoviceWelcome;
  public static final enum_guiding_feed_type eGuidingSetAuth;
  public static final enum_guiding_feed_type eGuidingUnknown;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!enum_guiding_feed_type.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new enum_guiding_feed_type[6];
      eGuidingUnknown = new enum_guiding_feed_type(0, 0, "eGuidingUnknown");
      eGuidingSetAuth = new enum_guiding_feed_type(1, 1, "eGuidingSetAuth");
      eGuidingFollow = new enum_guiding_feed_type(2, 2, "eGuidingFollow");
      eGuidingFriendReminder = new enum_guiding_feed_type(3, 3, "eGuidingFriendReminder");
      eGuidingNoviceWelcome = new enum_guiding_feed_type(4, 4, "eGuidingNoviceWelcome");
      eGuidingMessage = new enum_guiding_feed_type(5, 5, "eGuidingMessage");
      return;
    }
  }
  
  private enum_guiding_feed_type(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static enum_guiding_feed_type convert(int paramInt)
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
  
  public static enum_guiding_feed_type convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_FEEDS.enum_guiding_feed_type
 * JD-Core Version:    0.7.0.1
 */