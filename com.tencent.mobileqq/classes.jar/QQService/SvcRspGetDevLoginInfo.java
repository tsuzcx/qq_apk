package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SvcRspGetDevLoginInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vecAuthLoginDevInfo;
  static ArrayList cache_vecCurrentLoginDevInfo;
  static ArrayList cache_vecHistoryLoginDevInfo;
  public long iNextItemIndex;
  public int iResult;
  public long iTotalItemCount;
  public String strResult = "";
  public ArrayList vecAuthLoginDevInfo;
  public ArrayList vecCurrentLoginDevInfo;
  public ArrayList vecHistoryLoginDevInfo;
  
  static
  {
    if (!SvcRspGetDevLoginInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcRspGetDevLoginInfo() {}
  
  public SvcRspGetDevLoginInfo(int paramInt, String paramString, long paramLong1, long paramLong2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    this.iResult = paramInt;
    this.strResult = paramString;
    this.iNextItemIndex = paramLong1;
    this.iTotalItemCount = paramLong2;
    this.vecCurrentLoginDevInfo = paramArrayList1;
    this.vecHistoryLoginDevInfo = paramArrayList2;
    this.vecAuthLoginDevInfo = paramArrayList3;
  }
  
  public String className()
  {
    return "QQService.SvcRspGetDevLoginInfo";
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
    paramStringBuilder.display(this.iResult, "iResult");
    paramStringBuilder.display(this.strResult, "strResult");
    paramStringBuilder.display(this.iNextItemIndex, "iNextItemIndex");
    paramStringBuilder.display(this.iTotalItemCount, "iTotalItemCount");
    paramStringBuilder.display(this.vecCurrentLoginDevInfo, "vecCurrentLoginDevInfo");
    paramStringBuilder.display(this.vecHistoryLoginDevInfo, "vecHistoryLoginDevInfo");
    paramStringBuilder.display(this.vecAuthLoginDevInfo, "vecAuthLoginDevInfo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.iResult, true);
    paramStringBuilder.displaySimple(this.strResult, true);
    paramStringBuilder.displaySimple(this.iNextItemIndex, true);
    paramStringBuilder.displaySimple(this.iTotalItemCount, true);
    paramStringBuilder.displaySimple(this.vecCurrentLoginDevInfo, true);
    paramStringBuilder.displaySimple(this.vecHistoryLoginDevInfo, true);
    paramStringBuilder.displaySimple(this.vecAuthLoginDevInfo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SvcRspGetDevLoginInfo)paramObject;
    } while ((!JceUtil.equals(this.iResult, paramObject.iResult)) || (!JceUtil.equals(this.strResult, paramObject.strResult)) || (!JceUtil.equals(this.iNextItemIndex, paramObject.iNextItemIndex)) || (!JceUtil.equals(this.iTotalItemCount, paramObject.iTotalItemCount)) || (!JceUtil.equals(this.vecCurrentLoginDevInfo, paramObject.vecCurrentLoginDevInfo)) || (!JceUtil.equals(this.vecHistoryLoginDevInfo, paramObject.vecHistoryLoginDevInfo)) || (!JceUtil.equals(this.vecAuthLoginDevInfo, paramObject.vecAuthLoginDevInfo)));
    return true;
  }
  
  public String fullClassName()
  {
    return "QQService.SvcRspGetDevLoginInfo";
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
    this.iResult = paramJceInputStream.read(this.iResult, 0, true);
    this.strResult = paramJceInputStream.readString(1, false);
    this.iNextItemIndex = paramJceInputStream.read(this.iNextItemIndex, 2, true);
    this.iTotalItemCount = paramJceInputStream.read(this.iTotalItemCount, 3, true);
    SvcDevLoginInfo localSvcDevLoginInfo;
    if (cache_vecCurrentLoginDevInfo == null)
    {
      cache_vecCurrentLoginDevInfo = new ArrayList();
      localSvcDevLoginInfo = new SvcDevLoginInfo();
      cache_vecCurrentLoginDevInfo.add(localSvcDevLoginInfo);
    }
    this.vecCurrentLoginDevInfo = ((ArrayList)paramJceInputStream.read(cache_vecCurrentLoginDevInfo, 4, false));
    if (cache_vecHistoryLoginDevInfo == null)
    {
      cache_vecHistoryLoginDevInfo = new ArrayList();
      localSvcDevLoginInfo = new SvcDevLoginInfo();
      cache_vecHistoryLoginDevInfo.add(localSvcDevLoginInfo);
    }
    this.vecHistoryLoginDevInfo = ((ArrayList)paramJceInputStream.read(cache_vecHistoryLoginDevInfo, 5, false));
    if (cache_vecAuthLoginDevInfo == null)
    {
      cache_vecAuthLoginDevInfo = new ArrayList();
      localSvcDevLoginInfo = new SvcDevLoginInfo();
      cache_vecAuthLoginDevInfo.add(localSvcDevLoginInfo);
    }
    this.vecAuthLoginDevInfo = ((ArrayList)paramJceInputStream.read(cache_vecAuthLoginDevInfo, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 0);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 1);
    }
    paramJceOutputStream.write(this.iNextItemIndex, 2);
    paramJceOutputStream.write(this.iTotalItemCount, 3);
    if (this.vecCurrentLoginDevInfo != null) {
      paramJceOutputStream.write(this.vecCurrentLoginDevInfo, 4);
    }
    if (this.vecHistoryLoginDevInfo != null) {
      paramJceOutputStream.write(this.vecHistoryLoginDevInfo, 5);
    }
    if (this.vecAuthLoginDevInfo != null) {
      paramJceOutputStream.write(this.vecAuthLoginDevInfo, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.SvcRspGetDevLoginInfo
 * JD-Core Version:    0.7.0.1
 */