package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_like
  extends JceStruct
{
  static ArrayList cache_likemans = new ArrayList();
  public int isliked;
  public ArrayList likemans;
  public int num;
  
  static
  {
    s_likeman locals_likeman = new s_likeman();
    cache_likemans.add(locals_likeman);
  }
  
  public cell_like() {}
  
  public cell_like(int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    this.num = paramInt1;
    this.isliked = paramInt2;
    this.likemans = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.isliked = paramJceInputStream.read(this.isliked, 1, false);
    this.likemans = ((ArrayList)paramJceInputStream.read(cache_likemans, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    paramJceOutputStream.write(this.isliked, 1);
    if (this.likemans != null) {
      paramJceOutputStream.write(this.likemans, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_like
 * JD-Core Version:    0.7.0.1
 */