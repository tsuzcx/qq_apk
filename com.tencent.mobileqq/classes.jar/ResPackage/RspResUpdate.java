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
  static ArrayList<ResUpdate> cache_ResInfo;
  static int cache_Ret;
  public int ResID = 0;
  public ArrayList<ResUpdate> ResInfo = null;
  public int Ret = 0;
  public long SeqID = 0L;
  
  public RspResUpdate() {}
  
  public RspResUpdate(int paramInt1, long paramLong, ArrayList<ResUpdate> paramArrayList, int paramInt2)
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (RspResUpdate)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.Ret, paramObject.Ret))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.SeqID, paramObject.SeqID))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.ResInfo, paramObject.ResInfo))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.ResID, paramObject.ResID)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "ResPackage.RspResUpdate";
  }
  
  public int getResID()
  {
    return this.ResID;
  }
  
  public ArrayList<ResUpdate> getResInfo()
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
  
  public void setResInfo(ArrayList<ResUpdate> paramArrayList)
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
    ArrayList localArrayList = this.ResInfo;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
    paramJceOutputStream.write(this.ResID, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ResPackage.RspResUpdate
 * JD-Core Version:    0.7.0.1
 */