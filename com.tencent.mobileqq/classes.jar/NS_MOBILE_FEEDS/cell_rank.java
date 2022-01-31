package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_rank
  extends JceStruct
{
  static s_rank cache_rank = new s_rank();
  public s_rank rank;
  
  public cell_rank() {}
  
  public cell_rank(s_rank params_rank)
  {
    this.rank = params_rank;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rank = ((s_rank)paramJceInputStream.read(cache_rank, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rank != null) {
      paramJceOutputStream.write(this.rank, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_rank
 * JD-Core Version:    0.7.0.1
 */