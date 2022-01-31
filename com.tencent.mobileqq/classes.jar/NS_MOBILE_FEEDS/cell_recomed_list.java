package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_recomed_list
  extends JceStruct
{
  static ArrayList<s_likeman> cache_likemans = new ArrayList();
  public int isrecomed;
  public ArrayList<s_likeman> likemans;
  public int num;
  
  static
  {
    s_likeman locals_likeman = new s_likeman();
    cache_likemans.add(locals_likeman);
  }
  
  public cell_recomed_list() {}
  
  public cell_recomed_list(int paramInt1, int paramInt2, ArrayList<s_likeman> paramArrayList)
  {
    this.num = paramInt1;
    this.isrecomed = paramInt2;
    this.likemans = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.isrecomed = paramJceInputStream.read(this.isrecomed, 1, false);
    this.likemans = ((ArrayList)paramJceInputStream.read(cache_likemans, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    paramJceOutputStream.write(this.isrecomed, 1);
    if (this.likemans != null) {
      paramJceOutputStream.write(this.likemans, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_recomed_list
 * JD-Core Version:    0.7.0.1
 */