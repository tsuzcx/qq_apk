package AvatarInfo;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class GetAvatarUrlReq
  extends JceStruct
{
  static ArrayList<DestUserInfo> cache_destUserInfo;
  public ArrayList<DestUserInfo> destUserInfo = null;
  public long myUin = 0L;
  
  static
  {
    if (!GetAvatarUrlReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GetAvatarUrlReq()
  {
    setMyUin(this.myUin);
    setDestUserInfo(this.destUserInfo);
  }
  
  public GetAvatarUrlReq(long paramLong, ArrayList<DestUserInfo> paramArrayList)
  {
    setMyUin(paramLong);
    setDestUserInfo(paramArrayList);
  }
  
  public String className()
  {
    return "AvatarInfo.GetAvatarUrlReq";
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
    paramStringBuilder.display(this.myUin, "myUin");
    paramStringBuilder.display(this.destUserInfo, "destUserInfo");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (GetAvatarUrlReq)paramObject;
    return (JceUtil.equals(this.myUin, paramObject.myUin)) && (JceUtil.equals(this.destUserInfo, paramObject.destUserInfo));
  }
  
  public ArrayList<DestUserInfo> getDestUserInfo()
  {
    return this.destUserInfo;
  }
  
  public long getMyUin()
  {
    return this.myUin;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setMyUin(paramJceInputStream.read(this.myUin, 0, true));
    if (cache_destUserInfo == null)
    {
      cache_destUserInfo = new ArrayList();
      DestUserInfo localDestUserInfo = new DestUserInfo();
      cache_destUserInfo.add(localDestUserInfo);
    }
    setDestUserInfo((ArrayList)paramJceInputStream.read(cache_destUserInfo, 1, true));
  }
  
  public void setDestUserInfo(ArrayList<DestUserInfo> paramArrayList)
  {
    this.destUserInfo = paramArrayList;
  }
  
  public void setMyUin(long paramLong)
  {
    this.myUin = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.myUin, 0);
    paramJceOutputStream.write(this.destUserInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     AvatarInfo.GetAvatarUrlReq
 * JD-Core Version:    0.7.0.1
 */