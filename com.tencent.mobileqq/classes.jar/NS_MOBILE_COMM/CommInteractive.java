package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CommInteractive
  extends JceStruct
{
  static Map<Integer, String> cache_ext;
  static stOperaData cache_opData = new stOperaData();
  public Map<Integer, String> ext = null;
  public int iRet = 0;
  public int interactiveType = 0;
  public stOperaData opData = null;
  public String strErrToast = "";
  
  static
  {
    cache_ext = new HashMap();
    cache_ext.put(Integer.valueOf(0), "");
  }
  
  public CommInteractive() {}
  
  public CommInteractive(int paramInt1, String paramString, int paramInt2, stOperaData paramstOperaData, Map<Integer, String> paramMap)
  {
    this.iRet = paramInt1;
    this.strErrToast = paramString;
    this.interactiveType = paramInt2;
    this.opData = paramstOperaData;
    this.ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, false);
    this.strErrToast = paramJceInputStream.readString(1, false);
    this.interactiveType = paramJceInputStream.read(this.interactiveType, 2, false);
    this.opData = ((stOperaData)paramJceInputStream.read(cache_opData, 3, false));
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    Object localObject = this.strErrToast;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.interactiveType, 2);
    localObject = this.opData;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_COMM.CommInteractive
 * JD-Core Version:    0.7.0.1
 */