package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_diss
  extends JceStruct
{
  static ArrayList<s_likeman> cache_dissmans = new ArrayList();
  public ArrayList<s_likeman> dissmans = null;
  public int isdissed = 0;
  public int num = 0;
  
  static
  {
    s_likeman locals_likeman = new s_likeman();
    cache_dissmans.add(locals_likeman);
  }
  
  public cell_diss() {}
  
  public cell_diss(int paramInt1, int paramInt2, ArrayList<s_likeman> paramArrayList)
  {
    this.num = paramInt1;
    this.isdissed = paramInt2;
    this.dissmans = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.isdissed = paramJceInputStream.read(this.isdissed, 1, false);
    this.dissmans = ((ArrayList)paramJceInputStream.read(cache_dissmans, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    paramJceOutputStream.write(this.isdissed, 1);
    ArrayList localArrayList = this.dissmans;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_diss
 * JD-Core Version:    0.7.0.1
 */