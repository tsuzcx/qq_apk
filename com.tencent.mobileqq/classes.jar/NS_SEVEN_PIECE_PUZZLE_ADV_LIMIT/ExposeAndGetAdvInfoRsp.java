package NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ExposeAndGetAdvInfoRsp
  extends JceStruct
{
  static ArrayList<AdvExposureInfo> cache_vecAdvExposureInfo = new ArrayList();
  public int Code;
  public String Msg = "";
  public ArrayList<AdvExposureInfo> vecAdvExposureInfo;
  
  static
  {
    AdvExposureInfo localAdvExposureInfo = new AdvExposureInfo();
    cache_vecAdvExposureInfo.add(localAdvExposureInfo);
  }
  
  public ExposeAndGetAdvInfoRsp() {}
  
  public ExposeAndGetAdvInfoRsp(int paramInt, String paramString, ArrayList<AdvExposureInfo> paramArrayList)
  {
    this.Code = paramInt;
    this.Msg = paramString;
    this.vecAdvExposureInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Code = paramJceInputStream.read(this.Code, 0, false);
    this.Msg = paramJceInputStream.readString(1, false);
    this.vecAdvExposureInfo = ((ArrayList)paramJceInputStream.read(cache_vecAdvExposureInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Code, 0);
    if (this.Msg != null) {
      paramJceOutputStream.write(this.Msg, 1);
    }
    if (this.vecAdvExposureInfo != null) {
      paramJceOutputStream.write(this.vecAdvExposureInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.ExposeAndGetAdvInfoRsp
 * JD-Core Version:    0.7.0.1
 */