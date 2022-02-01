package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SvcReqDelLoginInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<DeviceItemDes> cache_vecDeviceItemDes;
  static byte[] cache_vecGuid;
  public long iAppId = 0L;
  public long iDelMe = 0L;
  public long iDelType = 1L;
  public String strAppName = "";
  public ArrayList<DeviceItemDes> vecDeviceItemDes = null;
  public byte[] vecGuid = null;
  
  static
  {
    if (!SvcReqDelLoginInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcReqDelLoginInfo() {}
  
  public SvcReqDelLoginInfo(byte[] paramArrayOfByte, String paramString, ArrayList<DeviceItemDes> paramArrayList, long paramLong1, long paramLong2, long paramLong3)
  {
    this.vecGuid = paramArrayOfByte;
    this.strAppName = paramString;
    this.vecDeviceItemDes = paramArrayList;
    this.iDelType = paramLong1;
    this.iDelMe = paramLong2;
    this.iAppId = paramLong3;
  }
  
  public String className()
  {
    return "QQService.SvcReqDelLoginInfo";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.vecGuid, "vecGuid");
    paramStringBuilder.display(this.strAppName, "strAppName");
    paramStringBuilder.display(this.vecDeviceItemDes, "vecDeviceItemDes");
    paramStringBuilder.display(this.iDelType, "iDelType");
    paramStringBuilder.display(this.iDelMe, "iDelMe");
    paramStringBuilder.display(this.iAppId, "iAppId");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.vecGuid, true);
    paramStringBuilder.displaySimple(this.strAppName, true);
    paramStringBuilder.displaySimple(this.vecDeviceItemDes, true);
    paramStringBuilder.displaySimple(this.iDelType, true);
    paramStringBuilder.displaySimple(this.iDelMe, true);
    paramStringBuilder.displaySimple(this.iAppId, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SvcReqDelLoginInfo)paramObject;
    } while ((!JceUtil.equals(this.vecGuid, paramObject.vecGuid)) || (!JceUtil.equals(this.strAppName, paramObject.strAppName)) || (!JceUtil.equals(this.vecDeviceItemDes, paramObject.vecDeviceItemDes)) || (!JceUtil.equals(this.iDelType, paramObject.iDelType)) || (!JceUtil.equals(this.iDelMe, paramObject.iDelMe)) || (!JceUtil.equals(this.iAppId, paramObject.iAppId)));
    return true;
  }
  
  public String fullClassName()
  {
    return "QQService.SvcReqDelLoginInfo";
  }
  
  public long getIAppId()
  {
    return this.iAppId;
  }
  
  public long getIDelMe()
  {
    return this.iDelMe;
  }
  
  public long getIDelType()
  {
    return this.iDelType;
  }
  
  public String getStrAppName()
  {
    return this.strAppName;
  }
  
  public ArrayList<DeviceItemDes> getVecDeviceItemDes()
  {
    return this.vecDeviceItemDes;
  }
  
  public byte[] getVecGuid()
  {
    return this.vecGuid;
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
    if (cache_vecDeviceItemDes == null)
    {
      cache_vecDeviceItemDes = new ArrayList();
      DeviceItemDes localDeviceItemDes = new DeviceItemDes();
      cache_vecDeviceItemDes.add(localDeviceItemDes);
    }
    this.vecDeviceItemDes = ((ArrayList)paramJceInputStream.read(cache_vecDeviceItemDes, 2, true));
    this.iDelType = paramJceInputStream.read(this.iDelType, 3, false);
    this.iDelMe = paramJceInputStream.read(this.iDelMe, 4, false);
    this.iAppId = paramJceInputStream.read(this.iAppId, 5, false);
  }
  
  public void setIAppId(long paramLong)
  {
    this.iAppId = paramLong;
  }
  
  public void setIDelMe(long paramLong)
  {
    this.iDelMe = paramLong;
  }
  
  public void setIDelType(long paramLong)
  {
    this.iDelType = paramLong;
  }
  
  public void setStrAppName(String paramString)
  {
    this.strAppName = paramString;
  }
  
  public void setVecDeviceItemDes(ArrayList<DeviceItemDes> paramArrayList)
  {
    this.vecDeviceItemDes = paramArrayList;
  }
  
  public void setVecGuid(byte[] paramArrayOfByte)
  {
    this.vecGuid = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecGuid, 0);
    paramJceOutputStream.write(this.strAppName, 1);
    paramJceOutputStream.write(this.vecDeviceItemDes, 2);
    paramJceOutputStream.write(this.iDelType, 3);
    paramJceOutputStream.write(this.iDelMe, 4);
    paramJceOutputStream.write(this.iAppId, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.SvcReqDelLoginInfo
 * JD-Core Version:    0.7.0.1
 */