package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetBatchPoiRsp_V2
  extends JceStruct
{
  static ArrayList<PoiInfoCell_V2> cache_vecPoiInfoCell = new ArrayList();
  public ArrayList<PoiInfoCell_V2> vecPoiInfoCell = null;
  
  static
  {
    PoiInfoCell_V2 localPoiInfoCell_V2 = new PoiInfoCell_V2();
    cache_vecPoiInfoCell.add(localPoiInfoCell_V2);
  }
  
  public GetBatchPoiRsp_V2() {}
  
  public GetBatchPoiRsp_V2(ArrayList<PoiInfoCell_V2> paramArrayList)
  {
    this.vecPoiInfoCell = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecPoiInfoCell = ((ArrayList)paramJceInputStream.read(cache_vecPoiInfoCell, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.vecPoiInfoCell;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetBatchPoiRsp_V2
 * JD-Core Version:    0.7.0.1
 */