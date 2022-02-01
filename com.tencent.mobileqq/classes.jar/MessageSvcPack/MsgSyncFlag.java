package MessageSvcPack;

import java.io.Serializable;

public final class MsgSyncFlag
  implements Serializable
{
  public static final MsgSyncFlag SYNC_BEGIN = new MsgSyncFlag(0, 0, "SYNC_BEGIN");
  public static final MsgSyncFlag SYNC_CONTINUE = new MsgSyncFlag(1, 1, "SYNC_CONTINUE");
  public static final MsgSyncFlag SYNC_END = new MsgSyncFlag(2, 2, "SYNC_END");
  public static final MsgSyncFlag SYNC_FINI = new MsgSyncFlag(3, 3, "SYNC_FINI");
  public static final int _SYNC_BEGIN = 0;
  public static final int _SYNC_CONTINUE = 1;
  public static final int _SYNC_END = 2;
  public static final int _SYNC_FINI = 3;
  private static MsgSyncFlag[] a = new MsgSyncFlag[4];
  private String __T = new String();
  private int __value;
  
  private MsgSyncFlag(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static MsgSyncFlag convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      MsgSyncFlag[] arrayOfMsgSyncFlag = a;
      if (i >= arrayOfMsgSyncFlag.length) {
        break;
      }
      if (arrayOfMsgSyncFlag[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static MsgSyncFlag convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      MsgSyncFlag[] arrayOfMsgSyncFlag = a;
      if (i >= arrayOfMsgSyncFlag.length) {
        break;
      }
      if (arrayOfMsgSyncFlag[i].toString().equals(paramString)) {
        return a[i];
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
 * Qualified Name:     MessageSvcPack.MsgSyncFlag
 * JD-Core Version:    0.7.0.1
 */