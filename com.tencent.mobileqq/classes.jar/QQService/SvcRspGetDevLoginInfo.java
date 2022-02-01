package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public final class SvcRspGetDevLoginInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<SvcDevLoginInfo> cache_vecAuthLoginDevInfo;
  static ArrayList<SvcDevLoginInfo> cache_vecCurrentLoginDevInfo;
  static ArrayList<SvcDevLoginInfo> cache_vecHistoryLoginDevInfo;
  public long iNextItemIndex = 0L;
  public int iResult = 0;
  public long iTotalItemCount = 0L;
  public String strResult = "";
  public ArrayList<SvcDevLoginInfo> vecAuthLoginDevInfo = null;
  public ArrayList<SvcDevLoginInfo> vecCurrentLoginDevInfo = null;
  public ArrayList<SvcDevLoginInfo> vecHistoryLoginDevInfo = null;
  
  public SvcRspGetDevLoginInfo() {}
  
  public SvcRspGetDevLoginInfo(int paramInt, String paramString, long paramLong1, long paramLong2, ArrayList<SvcDevLoginInfo> paramArrayList1, ArrayList<SvcDevLoginInfo> paramArrayList2, ArrayList<SvcDevLoginInfo> paramArrayList3)
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SvcRspGetDevLoginInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.iResult, paramObject.iResult))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.strResult, paramObject.strResult))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.iNextItemIndex, paramObject.iNextItemIndex))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.iTotalItemCount, paramObject.iTotalItemCount))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.vecCurrentLoginDevInfo, paramObject.vecCurrentLoginDevInfo))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.vecHistoryLoginDevInfo, paramObject.vecHistoryLoginDevInfo))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.vecAuthLoginDevInfo, paramObject.vecAuthLoginDevInfo)) {
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
    Object localObject = this.strResult;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.iNextItemIndex, 2);
    paramJceOutputStream.write(this.iTotalItemCount, 3);
    localObject = this.vecCurrentLoginDevInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    localObject = this.vecHistoryLoginDevInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    localObject = this.vecAuthLoginDevInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.SvcRspGetDevLoginInfo
 * JD-Core Version:    0.7.0.1
 */