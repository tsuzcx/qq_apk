package RegisterProxySvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SvcResponsePullDisGroupSeq
  extends JceStruct
  implements Cloneable
{
  static ArrayList<stDisGroupInfo> cache_vDisInfo;
  public byte cReplyCode;
  public String strResult = "";
  public long uUploadLimit;
  public ArrayList<stDisGroupInfo> vDisInfo;
  
  static
  {
    if (!SvcResponsePullDisGroupSeq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcResponsePullDisGroupSeq() {}
  
  public SvcResponsePullDisGroupSeq(byte paramByte, String paramString, ArrayList<stDisGroupInfo> paramArrayList, long paramLong)
  {
    this.cReplyCode = paramByte;
    this.strResult = paramString;
    this.vDisInfo = paramArrayList;
    this.uUploadLimit = paramLong;
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
    paramStringBuilder.display(this.cReplyCode, "cReplyCode");
    paramStringBuilder.display(this.strResult, "strResult");
    paramStringBuilder.display(this.vDisInfo, "vDisInfo");
    paramStringBuilder.display(this.uUploadLimit, "uUploadLimit");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.cReplyCode, true);
    paramStringBuilder.displaySimple(this.strResult, true);
    paramStringBuilder.displaySimple(this.vDisInfo, true);
    paramStringBuilder.displaySimple(this.uUploadLimit, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SvcResponsePullDisGroupSeq)paramObject;
    } while ((!JceUtil.equals(this.cReplyCode, paramObject.cReplyCode)) || (!JceUtil.equals(this.strResult, paramObject.strResult)) || (!JceUtil.equals(this.vDisInfo, paramObject.vDisInfo)) || (!JceUtil.equals(this.uUploadLimit, paramObject.uUploadLimit)));
    return true;
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
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 0, true);
    this.strResult = paramJceInputStream.readString(1, true);
    if (cache_vDisInfo == null)
    {
      cache_vDisInfo = new ArrayList();
      stDisGroupInfo localstDisGroupInfo = new stDisGroupInfo();
      cache_vDisInfo.add(localstDisGroupInfo);
    }
    this.vDisInfo = ((ArrayList)paramJceInputStream.read(cache_vDisInfo, 2, true));
    this.uUploadLimit = paramJceInputStream.read(this.uUploadLimit, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cReplyCode, 0);
    paramJceOutputStream.write(this.strResult, 1);
    paramJceOutputStream.write(this.vDisInfo, 2);
    paramJceOutputStream.write(this.uUploadLimit, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     RegisterProxySvcPack.SvcResponsePullDisGroupSeq
 * JD-Core Version:    0.7.0.1
 */