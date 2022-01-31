package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RequestBatchPushFStatus
  extends JceStruct
  implements Cloneable
{
  static ArrayList<RequestPushFStatus> cache_vBatchFStatusReq;
  public ArrayList<RequestPushFStatus> vBatchFStatusReq = null;
  
  static
  {
    if (!RequestBatchPushFStatus.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RequestBatchPushFStatus()
  {
    setVBatchFStatusReq(this.vBatchFStatusReq);
  }
  
  public RequestBatchPushFStatus(ArrayList<RequestPushFStatus> paramArrayList)
  {
    setVBatchFStatusReq(paramArrayList);
  }
  
  public String className()
  {
    return "MessageSvcPack.RequestBatchPushFStatus";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.vBatchFStatusReq, "vBatchFStatusReq");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (RequestBatchPushFStatus)paramObject;
    return JceUtil.equals(this.vBatchFStatusReq, paramObject.vBatchFStatusReq);
  }
  
  public String fullClassName()
  {
    return "MessageSvcPack.RequestBatchPushFStatus";
  }
  
  public ArrayList<RequestPushFStatus> getVBatchFStatusReq()
  {
    return this.vBatchFStatusReq;
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
    if (cache_vBatchFStatusReq == null)
    {
      cache_vBatchFStatusReq = new ArrayList();
      RequestPushFStatus localRequestPushFStatus = new RequestPushFStatus();
      cache_vBatchFStatusReq.add(localRequestPushFStatus);
    }
    setVBatchFStatusReq((ArrayList)paramJceInputStream.read(cache_vBatchFStatusReq, 0, true));
  }
  
  public void setVBatchFStatusReq(ArrayList<RequestPushFStatus> paramArrayList)
  {
    this.vBatchFStatusReq = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vBatchFStatusReq, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     MessageSvcPack.RequestBatchPushFStatus
 * JD-Core Version:    0.7.0.1
 */