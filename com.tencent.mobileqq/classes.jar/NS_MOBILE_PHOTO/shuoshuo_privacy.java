package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class shuoshuo_privacy
  extends JceStruct
{
  static ArrayList<Long> cache_mood_allowuins;
  public ArrayList<Long> mood_allowuins;
  public String mood_permission = "";
  
  public shuoshuo_privacy() {}
  
  public shuoshuo_privacy(String paramString, ArrayList<Long> paramArrayList)
  {
    this.mood_permission = paramString;
    this.mood_allowuins = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mood_permission = paramJceInputStream.readString(0, true);
    if (cache_mood_allowuins == null)
    {
      cache_mood_allowuins = new ArrayList();
      cache_mood_allowuins.add(Long.valueOf(0L));
    }
    this.mood_allowuins = ((ArrayList)paramJceInputStream.read(cache_mood_allowuins, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mood_permission, 0);
    if (this.mood_allowuins != null) {
      paramJceOutputStream.write(this.mood_allowuins, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.shuoshuo_privacy
 * JD-Core Version:    0.7.0.1
 */