package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SvcRequestPullGroupMsgSeq
  extends JceStruct
  implements Cloneable
{
  static int cache_filter;
  static ArrayList<PullGroupSeqParam> cache_vGroupInfo;
  public byte cVerifyType = 0;
  public int filter = MsgFilter.NO_FILTER.value();
  public ArrayList<PullGroupSeqParam> vGroupInfo = null;
  
  public SvcRequestPullGroupMsgSeq() {}
  
  public SvcRequestPullGroupMsgSeq(ArrayList<PullGroupSeqParam> paramArrayList, byte paramByte, int paramInt)
  {
    this.vGroupInfo = paramArrayList;
    this.cVerifyType = paramByte;
    this.filter = paramInt;
  }
  
  public String className()
  {
    return "MessageSvcPack.SvcRequestPullGroupMsgSeq";
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
    paramStringBuilder.display(this.vGroupInfo, "vGroupInfo");
    paramStringBuilder.display(this.cVerifyType, "cVerifyType");
    paramStringBuilder.display(this.filter, "filter");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.vGroupInfo, true);
    paramStringBuilder.displaySimple(this.cVerifyType, true);
    paramStringBuilder.displaySimple(this.filter, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SvcRequestPullGroupMsgSeq)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.vGroupInfo, paramObject.vGroupInfo))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.cVerifyType, paramObject.cVerifyType))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.filter, paramObject.filter)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "MessageSvcPack.SvcRequestPullGroupMsgSeq";
  }
  
  public byte getCVerifyType()
  {
    return this.cVerifyType;
  }
  
  public int getFilter()
  {
    return this.filter;
  }
  
  public ArrayList<PullGroupSeqParam> getVGroupInfo()
  {
    return this.vGroupInfo;
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
    if (cache_vGroupInfo == null)
    {
      cache_vGroupInfo = new ArrayList();
      PullGroupSeqParam localPullGroupSeqParam = new PullGroupSeqParam();
      cache_vGroupInfo.add(localPullGroupSeqParam);
    }
    this.vGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupInfo, 0, true));
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, false);
    this.filter = paramJceInputStream.read(this.filter, 2, false);
  }
  
  public void setCVerifyType(byte paramByte)
  {
    this.cVerifyType = paramByte;
  }
  
  public void setFilter(int paramInt)
  {
    this.filter = paramInt;
  }
  
  public void setVGroupInfo(ArrayList<PullGroupSeqParam> paramArrayList)
  {
    this.vGroupInfo = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vGroupInfo, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
    paramJceOutputStream.write(this.filter, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.SvcRequestPullGroupMsgSeq
 * JD-Core Version:    0.7.0.1
 */