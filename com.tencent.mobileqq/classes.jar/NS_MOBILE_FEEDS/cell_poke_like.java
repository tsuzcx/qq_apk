package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_poke_like
  extends JceStruct
{
  static ArrayList<String> cache_emotion_id = new ArrayList();
  public int count = 0;
  public ArrayList<String> emotion_id = null;
  
  static
  {
    cache_emotion_id.add("");
  }
  
  public cell_poke_like() {}
  
  public cell_poke_like(ArrayList<String> paramArrayList, int paramInt)
  {
    this.emotion_id = paramArrayList;
    this.count = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.emotion_id = ((ArrayList)paramJceInputStream.read(cache_emotion_id, 0, false));
    this.count = paramJceInputStream.read(this.count, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.emotion_id != null) {
      paramJceOutputStream.write(this.emotion_id, 0);
    }
    paramJceOutputStream.write(this.count, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_poke_like
 * JD-Core Version:    0.7.0.1
 */