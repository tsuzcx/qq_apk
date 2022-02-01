package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CustomTrack
  extends JceStruct
{
  static ArrayList<CustomTrackAction> cache_Actions = new ArrayList();
  public ArrayList<CustomTrackAction> Actions = null;
  
  static
  {
    CustomTrackAction localCustomTrackAction = new CustomTrackAction();
    cache_Actions.add(localCustomTrackAction);
  }
  
  public CustomTrack() {}
  
  public CustomTrack(ArrayList<CustomTrackAction> paramArrayList)
  {
    this.Actions = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Actions = ((ArrayList)paramJceInputStream.read(cache_Actions, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.Actions != null) {
      paramJceOutputStream.write(this.Actions, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.CustomTrack
 * JD-Core Version:    0.7.0.1
 */