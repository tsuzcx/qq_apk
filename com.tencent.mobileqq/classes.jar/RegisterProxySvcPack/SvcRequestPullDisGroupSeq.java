package RegisterProxySvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SvcRequestPullDisGroupSeq
  extends JceStruct
  implements Cloneable
{
  static ArrayList<PullDisSeqParam> cache_vDisInfo;
  public ArrayList<PullDisSeqParam> vDisInfo;
  
  static
  {
    if (!SvcRequestPullDisGroupSeq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcRequestPullDisGroupSeq() {}
  
  public SvcRequestPullDisGroupSeq(ArrayList<PullDisSeqParam> paramArrayList)
  {
    this.vDisInfo = paramArrayList;
  }
  
  public String className()
  {
    return "RegisterProxySvcPack.SvcRequestPullDisGroupSeq";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.vDisInfo, "vDisInfo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.vDisInfo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (SvcRequestPullDisGroupSeq)paramObject;
    return JceUtil.equals(this.vDisInfo, paramObject.vDisInfo);
  }
  
  public String fullClassName()
  {
    return "RegisterProxySvcPack.SvcRequestPullDisGroupSeq";
  }
  
  public ArrayList<PullDisSeqParam> getVDisInfo()
  {
    return this.vDisInfo;
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
    if (cache_vDisInfo == null)
    {
      cache_vDisInfo = new ArrayList();
      PullDisSeqParam localPullDisSeqParam = new PullDisSeqParam();
      cache_vDisInfo.add(localPullDisSeqParam);
    }
    this.vDisInfo = ((ArrayList)paramJceInputStream.read(cache_vDisInfo, 0, true));
  }
  
  public void setVDisInfo(ArrayList<PullDisSeqParam> paramArrayList)
  {
    this.vDisInfo = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vDisInfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     RegisterProxySvcPack.SvcRequestPullDisGroupSeq
 * JD-Core Version:    0.7.0.1
 */