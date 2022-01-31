package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RspGetAreaList
  extends JceStruct
{
  static ArrayList<GroupArea> cache_vGroupArea;
  public ArrayList<GroupArea> vGroupArea;
  
  public RspGetAreaList() {}
  
  public RspGetAreaList(ArrayList<GroupArea> paramArrayList)
  {
    this.vGroupArea = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vGroupArea == null)
    {
      cache_vGroupArea = new ArrayList();
      GroupArea localGroupArea = new GroupArea();
      cache_vGroupArea.add(localGroupArea);
    }
    this.vGroupArea = ((ArrayList)paramJceInputStream.read(cache_vGroupArea, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vGroupArea != null) {
      paramJceOutputStream.write(this.vGroupArea, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NearbyGroup.RspGetAreaList
 * JD-Core Version:    0.7.0.1
 */