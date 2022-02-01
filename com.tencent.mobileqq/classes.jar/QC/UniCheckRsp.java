package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniCheckRsp
  extends JceStruct
{
  static ArrayList<UniBusinessCheckItem> cache_uniBusinessItemList = new ArrayList();
  public String errmsg = "";
  public int ret = 0;
  public ArrayList<UniBusinessCheckItem> uniBusinessItemList = null;
  
  static
  {
    UniBusinessCheckItem localUniBusinessCheckItem = new UniBusinessCheckItem();
    cache_uniBusinessItemList.add(localUniBusinessCheckItem);
  }
  
  public UniCheckRsp() {}
  
  public UniCheckRsp(int paramInt, String paramString, ArrayList<UniBusinessCheckItem> paramArrayList)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
    this.uniBusinessItemList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.uniBusinessItemList = ((ArrayList)paramJceInputStream.read(cache_uniBusinessItemList, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    if (this.uniBusinessItemList != null) {
      paramJceOutputStream.write(this.uniBusinessItemList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniCheckRsp
 * JD-Core Version:    0.7.0.1
 */