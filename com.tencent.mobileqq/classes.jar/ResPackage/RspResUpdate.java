package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RspResUpdate
  extends JceStruct
  implements Cloneable
{
  static int cache_ResID;
  static ArrayList cache_ResInfo;
  static int cache_Ret;
  public int ResID;
  public ArrayList ResInfo;
  public int Ret;
  public long SeqID;
  
  static
  {
    if (!RspResUpdate.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RspResUpdate() {}
  
  public RspResUpdate(int paramInt1, long paramLong, ArrayList paramArrayList, int paramInt2)
  {
    this.Ret = paramInt1;
    this.SeqID = paramLong;
    this.ResInfo = paramArrayList;
    this.ResID = paramInt2;
  }
  
  public String className()
  {
    return "ResPackage.RspResUpdate";
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
    paramStringBuilder.display(this.Ret, "Ret");
    paramStringBuilder.display(this.SeqID, "SeqID");
    paramStringBuilder.display(this.ResInfo, "ResInfo");
    paramStringBuilder.display(this.ResID, "ResID");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.Ret, true);
    paramStringBuilder.displaySimple(this.SeqID, true);
    paramStringBuilder.displaySimple(this.ResInfo, true);
    paramStringBuilder.displaySimple(this.ResID, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RspResUpdate)paramObject;
    } while ((!JceUtil.equals(this.Ret, paramObject.Ret)) || (!JceUtil.equals(this.SeqID, paramObject.SeqID)) || (!JceUtil.equals(this.ResInfo, paramObject.ResInfo)) || (!JceUtil.equals(this.ResID, paramObject.ResID)));
    return true;
  }
  
  public String fullClassName()
  {
    return "ResPackage.RspResUpdate";
  }
  
  public int getResID()
  {
    return this.ResID;
  }
  
  public ArrayList getResInfo()
  {
    return this.ResInfo;
  }
  
  public int getRet()
  {
    return this.Ret;
  }
  
  public long getSeqID()
  {
    return this.SeqID;
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
    this.Ret = paramJceInputStream.read(this.Ret, 0, true);
    this.SeqID = paramJceInputStream.read(this.SeqID, 1, true);
    if (cache_ResInfo == null)
    {
      cache_ResInfo = new ArrayList();
      ResUpdate localResUpdate = new ResUpdate();
      cache_ResInfo.add(localResUpdate);
    }
    this.ResInfo = ((ArrayList)paramJceInputStream.read(cache_ResInfo, 2, false));
    this.ResID = paramJceInputStream.read(this.ResID, 3, false);
  }
  
  public void setResID(int paramInt)
  {
    this.ResID = paramInt;
  }
  
  public void setResInfo(ArrayList paramArrayList)
  {
    this.ResInfo = paramArrayList;
  }
  
  public void setRet(int paramInt)
  {
    this.Ret = paramInt;
  }
  
  public void setSeqID(long paramLong)
  {
    this.SeqID = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Ret, 0);
    paramJceOutputStream.write(this.SeqID, 1);
    if (this.ResInfo != null) {
      paramJceOutputStream.write(this.ResInfo, 2);
    }
    paramJceOutputStream.write(this.ResID, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ResPackage.RspResUpdate
 * JD-Core Version:    0.7.0.1
 */