package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class VipBaseInfo
  extends JceStruct
  implements Cloneable
{
  static Map<Integer, VipOpenInfo> cache_mOpenInfo = new HashMap();
  public int iGrayNameplateFlag = 0;
  public int iNameplateVipType = 0;
  public Map<Integer, VipOpenInfo> mOpenInfo = null;
  public String strExtendNameplateId = "";
  
  static
  {
    VipOpenInfo localVipOpenInfo = new VipOpenInfo();
    cache_mOpenInfo.put(Integer.valueOf(0), localVipOpenInfo);
  }
  
  public VipBaseInfo() {}
  
  public VipBaseInfo(Map<Integer, VipOpenInfo> paramMap, int paramInt1, int paramInt2, String paramString)
  {
    this.mOpenInfo = paramMap;
    this.iNameplateVipType = paramInt1;
    this.iGrayNameplateFlag = paramInt2;
    this.strExtendNameplateId = paramString;
  }
  
  public String className()
  {
    return "QQService.VipBaseInfo";
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
    paramStringBuilder.display(this.mOpenInfo, "mOpenInfo");
    paramStringBuilder.display(this.iNameplateVipType, "iNameplateVipType");
    paramStringBuilder.display(this.iGrayNameplateFlag, "iGrayNameplateFlag");
    paramStringBuilder.display(this.strExtendNameplateId, "strExtendNameplateId");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.mOpenInfo, true);
    paramStringBuilder.displaySimple(this.iNameplateVipType, true);
    paramStringBuilder.displaySimple(this.iGrayNameplateFlag, false);
    paramStringBuilder.displaySimple(this.strExtendNameplateId, true);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (VipBaseInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.mOpenInfo, paramObject.mOpenInfo))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.iNameplateVipType, paramObject.iNameplateVipType))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.iGrayNameplateFlag, paramObject.iGrayNameplateFlag)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "QQService.VipBaseInfo";
  }
  
  public int getIGrayNameplateFlag()
  {
    return this.iGrayNameplateFlag;
  }
  
  public int getINameplateVipType()
  {
    return this.iNameplateVipType;
  }
  
  public Map<Integer, VipOpenInfo> getMOpenInfo()
  {
    return this.mOpenInfo;
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
    this.mOpenInfo = ((Map)paramJceInputStream.read(cache_mOpenInfo, 0, true));
    this.iNameplateVipType = paramJceInputStream.read(this.iNameplateVipType, 1, false);
    this.iGrayNameplateFlag = paramJceInputStream.read(this.iGrayNameplateFlag, 2, false);
    this.strExtendNameplateId = paramJceInputStream.readString(3, false);
  }
  
  public void setIGrayNameplateFlag(int paramInt)
  {
    this.iGrayNameplateFlag = paramInt;
  }
  
  public void setINameplateVipType(int paramInt)
  {
    this.iNameplateVipType = paramInt;
  }
  
  public void setMOpenInfo(Map<Integer, VipOpenInfo> paramMap)
  {
    this.mOpenInfo = paramMap;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mOpenInfo, 0);
    paramJceOutputStream.write(this.iNameplateVipType, 1);
    paramJceOutputStream.write(this.iGrayNameplateFlag, 2);
    String str = this.strExtendNameplateId;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.VipBaseInfo
 * JD-Core Version:    0.7.0.1
 */