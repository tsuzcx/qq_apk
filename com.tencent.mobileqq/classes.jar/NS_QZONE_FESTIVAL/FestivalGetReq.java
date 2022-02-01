package NS_QZONE_FESTIVAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FestivalGetReq
  extends JceStruct
{
  static ArrayList<FestivalGetReqItem> cache__vec_festivals = new ArrayList();
  public ArrayList<FestivalGetReqItem> _vec_festivals = null;
  
  static
  {
    FestivalGetReqItem localFestivalGetReqItem = new FestivalGetReqItem();
    cache__vec_festivals.add(localFestivalGetReqItem);
  }
  
  public FestivalGetReq() {}
  
  public FestivalGetReq(ArrayList<FestivalGetReqItem> paramArrayList)
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
 * Qualified Name:     NS_QZONE_FESTIVAL.FestivalGetReq
 * JD-Core Version:    0.7.0.1
 */