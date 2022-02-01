package NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetAdvInfoRsp
  extends JceStruct
{
  static ArrayList<AdvExposureInfo> cache_vecAdvExposureInfo = new ArrayList();
  public int Code = 0;
  public String Msg = "";
  public ArrayList<AdvExposureInfo> vecAdvExposureInfo = null;
  
  static
  {
    AdvExposureInfo localAdvExposureInfo = new AdvExposureInfo();
    cache_vecAdvExposureInfo.add(localAdvExposureInfo);
  }
  
  public GetAdvInfoRsp() {}
  
  public GetAdvInfoRsp(int paramInt, String paramString, ArrayList<AdvExposureInfo> paramArrayList)
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
    Object localObject = this.Msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.vecAdvExposureInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.GetAdvInfoRsp
 * JD-Core Version:    0.7.0.1
 */