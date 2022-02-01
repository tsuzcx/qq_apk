package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SimpleComment
  extends JceStruct
{
  static ArrayList<Long> cache_reply_ids = new ArrayList();
  public long id = 0L;
  public ArrayList<Long> reply_ids = null;
  
  static
  {
    cache_reply_ids.add(Long.valueOf(0L));
  }
  
  public SimpleComment() {}
  
  public SimpleComment(long paramLong, ArrayList<Long> paramArrayList)
  {
    this.id = paramLong;
    this.reply_ids = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, false);
    this.reply_ids = ((ArrayList)paramJceInputStream.read(cache_reply_ids, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    ArrayList localArrayList = this.reply_ids;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.SimpleComment
 * JD-Core Version:    0.7.0.1
 */