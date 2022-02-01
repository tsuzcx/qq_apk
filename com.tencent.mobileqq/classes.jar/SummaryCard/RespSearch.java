package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public final class RespSearch
  extends JceStruct
  implements Cloneable
{
  static int cache_eEimKeyType;
  static ArrayList<SearchInfo> cache_vRecords = new ArrayList();
  static byte[] cache_vSecureSig;
  static ArrayList<byte[]> cache_vvRespServices;
  static byte[] cache_weiguang;
  public int eEimKeyType = 0;
  public int result = 0;
  public ArrayList<SearchInfo> vRecords = null;
  public byte[] vSecureSig = null;
  public ArrayList<byte[]> vvRespServices = null;
  public byte[] weiguang = null;
  
  static
  {
    Object localObject = new SearchInfo();
    cache_vRecords.add(localObject);
    cache_vSecureSig = (byte[])new byte[1];
    ((byte[])cache_vSecureSig)[0] = 0;
    cache_vvRespServices = new ArrayList();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_vvRespServices.add(localObject);
    cache_eEimKeyType = 0;
    cache_weiguang = (byte[])new byte[1];
    ((byte[])cache_weiguang)[0] = 0;
  }
  
  public RespSearch() {}
  
  public RespSearch(ArrayList<SearchInfo> paramArrayList, byte[] paramArrayOfByte1, ArrayList<byte[]> paramArrayList1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.vRecords = paramArrayList;
    this.vSecureSig = paramArrayOfByte1;
    this.vvRespServices = paramArrayList1;
    this.eEimKeyType = paramInt1;
    this.result = paramInt2;
    this.weiguang = paramArrayOfByte2;
  }
  
  public String className()
  {
    return "SummaryCard.RespSearch";
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
    paramStringBuilder.display(this.vRecords, "vRecords");
    paramStringBuilder.display(this.vSecureSig, "vSecureSig");
    paramStringBuilder.display(this.vvRespServices, "vvRespServices");
    paramStringBuilder.display(this.eEimKeyType, "eEimKeyType");
    paramStringBuilder.display(this.result, "result");
    paramStringBuilder.display(this.weiguang, "weiguang");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.vRecords, true);
    paramStringBuilder.displaySimple(this.vSecureSig, true);
    paramStringBuilder.displaySimple(this.vvRespServices, true);
    paramStringBuilder.displaySimple(this.eEimKeyType, true);
    paramStringBuilder.displaySimple(this.result, true);
    paramStringBuilder.displaySimple(this.weiguang, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (RespSearch)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.vRecords, paramObject.vRecords))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.vSecureSig, paramObject.vSecureSig))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.vvRespServices, paramObject.vvRespServices))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.eEimKeyType, paramObject.eEimKeyType))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.result, paramObject.result))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.weiguang, paramObject.weiguang)) {
                bool1 = true;
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
    return "SummaryCard.RespSearch";
  }
  
  public int getEEimKeyType()
  {
    return this.eEimKeyType;
  }
  
  public int getResult()
  {
    return this.result;
  }
  
  public ArrayList<SearchInfo> getVRecords()
  {
    return this.vRecords;
  }
  
  public byte[] getVSecureSig()
  {
    return this.vSecureSig;
  }
  
  public ArrayList<byte[]> getVvRespServices()
  {
    return this.vvRespServices;
  }
  
  public byte[] getWeiguang()
  {
    return this.weiguang;
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
    this.vRecords = ((ArrayList)paramJceInputStream.read(cache_vRecords, 0, true));
    this.vSecureSig = ((byte[])paramJceInputStream.read(cache_vSecureSig, 1, false));
    this.vvRespServices = ((ArrayList)paramJceInputStream.read(cache_vvRespServices, 2, false));
    this.eEimKeyType = paramJceInputStream.read(this.eEimKeyType, 3, false);
    this.result = paramJceInputStream.read(this.result, 4, false);
    this.weiguang = ((byte[])paramJceInputStream.read(cache_weiguang, 5, false));
  }
  
  public void setEEimKeyType(int paramInt)
  {
    this.eEimKeyType = paramInt;
  }
  
  public void setResult(int paramInt)
  {
    this.result = paramInt;
  }
  
  public void setVRecords(ArrayList<SearchInfo> paramArrayList)
  {
    this.vRecords = paramArrayList;
  }
  
  public void setVSecureSig(byte[] paramArrayOfByte)
  {
    this.vSecureSig = paramArrayOfByte;
  }
  
  public void setVvRespServices(ArrayList<byte[]> paramArrayList)
  {
    this.vvRespServices = paramArrayList;
  }
  
  public void setWeiguang(byte[] paramArrayOfByte)
  {
    this.weiguang = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vRecords, 0);
    Object localObject = this.vSecureSig;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 1);
    }
    localObject = this.vvRespServices;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    paramJceOutputStream.write(this.eEimKeyType, 3);
    paramJceOutputStream.write(this.result, 4);
    localObject = this.weiguang;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.RespSearch
 * JD-Core Version:    0.7.0.1
 */