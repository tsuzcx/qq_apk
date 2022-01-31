package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_red_comm
  extends JceStruct
{
  static ArrayList<s_red_info> cache_redinfo;
  static int cache_showtype;
  static ArrayList<Integer> cache_subid;
  public ArrayList<s_red_info> redinfo;
  public int showtype;
  public ArrayList<Integer> subid;
  public long undealnum;
  
  public s_red_comm() {}
  
  public s_red_comm(int paramInt, long paramLong, ArrayList<s_red_info> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    this.showtype = paramInt;
    this.undealnum = paramLong;
    this.redinfo = paramArrayList;
    this.subid = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.showtype = paramJceInputStream.read(this.showtype, 0, false);
    this.undealnum = paramJceInputStream.read(this.undealnum, 1, false);
    if (cache_redinfo == null)
    {
      cache_redinfo = new ArrayList();
      s_red_info locals_red_info = new s_red_info();
      cache_redinfo.add(locals_red_info);
    }
    this.redinfo = ((ArrayList)paramJceInputStream.read(cache_redinfo, 2, false));
    if (cache_subid == null)
    {
      cache_subid = new ArrayList();
      cache_subid.add(Integer.valueOf(0));
    }
    this.subid = ((ArrayList)paramJceInputStream.read(cache_subid, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.showtype, 0);
    paramJceOutputStream.write(this.undealnum, 1);
    if (this.redinfo != null) {
      paramJceOutputStream.write(this.redinfo, 2);
    }
    if (this.subid != null) {
      paramJceOutputStream.write(this.subid, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_red_comm
 * JD-Core Version:    0.7.0.1
 */