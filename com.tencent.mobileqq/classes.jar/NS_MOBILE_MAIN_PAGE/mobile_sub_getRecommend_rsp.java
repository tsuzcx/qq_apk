package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class mobile_sub_getRecommend_rsp
  extends JceStruct
{
  static ArrayList<s_user> cache_datalist;
  public int allnum;
  public String attach_info = "";
  public ArrayList<s_user> datalist;
  
  public mobile_sub_getRecommend_rsp() {}
  
  public mobile_sub_getRecommend_rsp(int paramInt, ArrayList<s_user> paramArrayList, String paramString)
  {
    this.allnum = paramInt;
    this.datalist = paramArrayList;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.allnum = paramJceInputStream.read(this.allnum, 0, false);
    if (cache_datalist == null)
    {
      cache_datalist = new ArrayList();
      s_user locals_user = new s_user();
      cache_datalist.add(locals_user);
    }
    this.datalist = ((ArrayList)paramJceInputStream.read(cache_datalist, 1, false));
    this.attach_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.allnum, 0);
    Object localObject = this.datalist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_getRecommend_rsp
 * JD-Core Version:    0.7.0.1
 */