package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SvcReqGetDevLoginInfo
  extends JceStruct
  implements Cloneable
{
  static byte[] cache_vecGuid;
  public long iGetDevListType = 7L;
  public long iLoginType = 1L;
  public long iNextItemIndex = 0L;
  public long iRequireMax = 0L;
  public long iTimeStamp = 0L;
  public String strAppName = "";
  public byte[] vecGuid = null;
  
  public SvcReqGetDevLoginInfo() {}
  
  public SvcReqGetDevLoginInfo(byte[] paramArrayOfByte, String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.vecGuid = paramArrayOfByte;
    this.strAppName = paramString;
    this.iLoginType = paramLong1;
    this.iTimeStamp = paramLong2;
    this.iNextItemIndex = paramLong3;
    this.iRequireMax = paramLong4;
    this.iGetDevListType = paramLong5;
  }
  
  public String className()
  {
    return "QQService.SvcReqGetDevLoginInfo";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.vecGuid, "vecGuid");
    paramStringBuilder.display(this.strAppName, "strAppName");
    paramStringBuilder.display(this.iLoginType, "iLoginType");
    paramStringBuilder.display(this.iTimeStamp, "iTimeStamp");
    paramStringBuilder.display(this.iNextItemIndex, "iNextItemIndex");
    paramStringBuilder.display(this.iRequireMax, "iRequireMax");
    paramStringBuilder.display(this.iGetDevListType, "iGetDevListType");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.vecGuid, true);
    paramStringBuilder.displaySimple(this.strAppName, true);
    paramStringBuilder.displaySimple(this.iLoginType, true);
    paramStringBuilder.displaySimple(this.iTimeStamp, true);
    paramStringBuilder.displaySimple(this.iNextItemIndex, true);
    paramStringBuilder.displaySimple(this.iRequireMax, true);
    paramStringBuilder.displaySimple(this.iGetDevListType, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SvcReqGetDevLoginInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.vecGuid, paramObject.vecGuid))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.strAppName, paramObject.strAppName))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.iLoginType, paramObject.iLoginType))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.iTimeStamp, paramObject.iTimeStamp))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.iNextItemIndex, paramObject.iNextItemIndex))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.iRequireMax, paramObject.iRequireMax))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.iGetDevListType, paramObject.iGetDevListType)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "QQService.SvcReqGetDevLoginInfo";
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecGuid == null)
    {
      cache_vecGuid = (byte[])new byte[1];
      ((byte[])cache_vecGuid)[0] = 0;
    }
    this.vecGuid = ((byte[])paramJceInputStream.read(cache_vecGuid, 0, true));
    this.strAppName = paramJceInputStream.readString(1, true);
    this.iLoginType = paramJceInputStream.read(this.iLoginType, 2, true);
    this.iTimeStamp = paramJceInputStream.read(this.iTimeStamp, 3, true);
    this.iNextItemIndex = paramJceInputStream.read(this.iNextItemIndex, 4, true);
    this.iRequireMax = paramJceInputStream.read(this.iRequireMax, 5, true);
    this.iGetDevListType = paramJceInputStream.read(this.iGetDevListType, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecGuid, 0);
    paramJceOutputStream.write(this.strAppName, 1);
    paramJceOutputStream.write(this.iLoginType, 2);
    paramJceOutputStream.write(this.iTimeStamp, 3);
    paramJceOutputStream.write(this.iNextItemIndex, 4);
    paramJceOutputStream.write(this.iRequireMax, 5);
    paramJceOutputStream.write(this.iGetDevListType, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.SvcReqGetDevLoginInfo
 * JD-Core Version:    0.7.0.1
 */