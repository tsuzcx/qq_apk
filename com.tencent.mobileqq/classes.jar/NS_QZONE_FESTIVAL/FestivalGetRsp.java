package NS_QZONE_FESTIVAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FestivalGetRsp
  extends JceStruct
{
  static ArrayList<FestivalGetRspItem> cache__vec_festivals = new ArrayList();
  public ArrayList<FestivalGetRspItem> _vec_festivals = null;
  
  static
  {
    FestivalGetRspItem localFestivalGetRspItem = new FestivalGetRspItem();
    cache__vec_festivals.add(localFestivalGetRspItem);
  }
  
  public FestivalGetRsp() {}
  
  public FestivalGetRsp(ArrayList<FestivalGetRspItem> paramArrayList)
  {
    this._vec_festivals = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this._vec_festivals = ((ArrayList)paramJceInputStream.read(cache__vec_festivals, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this._vec_festivals != null) {
      paramJceOutputStream.write(this._vec_festivals, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_FESTIVAL.FestivalGetRsp
 * JD-Core Version:    0.7.0.1
 */